package com.baidu.tieba.write.album;

import android.app.AlertDialog;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.os.Environment;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.TextView;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.widget.ListView.x;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tbadk.core.atomData.AlbumActivityConfig;
import com.baidu.tbadk.core.atomData.ImageViewerConfig;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.as;
import com.baidu.tbadk.core.util.av;
import com.baidu.tbadk.img.ImageFileInfo;
import com.baidu.tbadk.img.WriteImagesInfo;
import com.baidu.tieba.n;
import com.baidu.tieba.write.write.WriteActivity;
/* loaded from: classes.dex */
public class AlbumActivity extends BaseFragmentActivity implements View.OnClickListener {
    private com.baidu.tbadk.img.b anY;
    private y dKB;
    private o dKx;
    private t dKy;
    private int bhi = 0;
    private boolean dKz = false;
    private int dKA = 0;
    private String from = "";
    private String fid = "";
    private boolean dKC = false;
    private AlertDialog dKD = null;
    private a dKE = null;
    private boolean dKF = false;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.adp.base.BdBaseFragmentActivity, android.support.v4.app.FragmentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.anY = new com.baidu.tbadk.img.b();
        initView();
        initData(bundle);
        aHj();
        ng(0);
        aHk();
        if (com.baidu.tbadk.core.sharedPref.b.tZ().getBoolean("add_img_water_tip_show", true) && aHh()) {
            aHi();
            com.baidu.tbadk.core.sharedPref.b.tZ().putBoolean("add_img_water_tip_show", false);
        }
    }

    /* loaded from: classes.dex */
    public class a extends x.a {
        public int afY;
        private TextView bBA;
        private TextView bBB;
        private TextView dKH;

        public a(View view) {
            super(view);
            this.afY = 3;
            this.bBA = (TextView) view.findViewById(n.f.img_water_setting_title);
            this.bBB = (TextView) view.findViewById(n.f.img_water_setting_content);
            this.dKH = (TextView) view.findViewById(n.f.goto_setting);
            this.dKH.setOnClickListener(new c(this));
            TX();
        }

        private void TX() {
            as.b(this.bBA, n.c.cp_cont_g, 1);
            as.b(this.bBB, n.c.cp_cont_g, 1);
            as.b(this.dKH, n.c.cp_link_tip_a, 1);
        }

        public void onChangeSkinType(int i) {
            if (this.afY != i) {
                TX();
                this.afY = i;
            }
            if (AlbumActivity.this.dKy != null) {
                AlbumActivity.this.dKy.np(AlbumActivity.this.bhi);
            }
        }
    }

    private boolean aHh() {
        return 2 == this.dKA || 3 == this.dKA || 1 == this.dKA || 2 == this.dKA || "frs".equals(this.from) || "pb".equals(this.from) || WriteActivity.dQY.equals(this.from);
    }

    private void aHi() {
        if (this.dKE == null) {
            this.dKE = new a(LayoutInflater.from(getActivity()).inflate(n.g.dialog_img_water_setting, (ViewGroup) null));
        }
        this.dKD = new AlertDialog.Builder(getActivity()).create();
        this.dKD.show();
        Window window = this.dKD.getWindow();
        WindowManager.LayoutParams attributes = window.getAttributes();
        attributes.dimAmount = 0.5f;
        attributes.width = -2;
        attributes.height = -2;
        attributes.y = 0 - (com.baidu.adp.lib.util.k.L(getActivity()) / 5);
        window.setAttributes(attributes);
        window.setContentView(this.dKE.getView());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.adp.base.BdBaseFragmentActivity, android.support.v4.app.FragmentActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        if (this.dKD != null) {
            com.baidu.adp.lib.h.h.hj().postDelayed(new com.baidu.tieba.write.album.a(this), 3000L);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.adp.base.BdBaseFragmentActivity, android.support.v4.app.FragmentActivity, android.app.Activity
    public void onPause() {
        super.onPause();
        if (this.dKD != null) {
            this.dKD.dismiss();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.support.v4.app.FragmentActivity, android.app.Activity
    public void onSaveInstanceState(Bundle bundle) {
        bundle.putString(AlbumActivityConfig.WRITE_IMAGES_INFO, this.dKx.getWriteImagesInfo().toJsonString());
        bundle.putBoolean(AlbumActivityConfig.USE_ORIGINAL_IMG, this.dKF);
    }

    private void initData(Bundle bundle) {
        this.dKx = new o(this);
        if (bundle != null) {
            WriteImagesInfo writeImagesInfo = new WriteImagesInfo();
            writeImagesInfo.parseJson(bundle.getString(AlbumActivityConfig.WRITE_IMAGES_INFO));
            this.dKx.setWriteImagesInfo(writeImagesInfo);
            this.dKx.nm(bundle.getString(AlbumActivityConfig.CAMERA_PHOTO_NAME));
            this.dKF = bundle.getBoolean(AlbumActivityConfig.USE_ORIGINAL_IMG, false);
            return;
        }
        Intent intent = getIntent();
        if (intent != null) {
            WriteImagesInfo writeImagesInfo2 = new WriteImagesInfo();
            writeImagesInfo2.parseJson(intent.getStringExtra(AlbumActivityConfig.WRITE_IMAGES_INFO));
            this.dKx.setWriteImagesInfo(writeImagesInfo2);
            this.dKx.nm(intent.getStringExtra(AlbumActivityConfig.CAMERA_PHOTO_NAME));
            this.dKA = intent.getIntExtra(AlbumActivityConfig.CAMERA_REQUEST_FROM, 0);
            this.from = intent.getStringExtra("from");
            this.fid = intent.getStringExtra("forum_id");
            if (WriteActivity.dQY.equals(this.from)) {
                this.dKC = true;
            } else {
                this.dKC = false;
            }
            if (this.dKA == 2) {
                this.dKB = new b(this);
            }
            this.dKx.hB(intent.getBooleanExtra(AlbumActivityConfig.AUTO_PHOTO_NAME, false));
            this.dKF = intent.getBooleanExtra(AlbumActivityConfig.USE_ORIGINAL_IMG, false);
        }
    }

    private void initView() {
        this.dKy = new t(this);
        this.dKy.aHJ();
    }

    private void aHj() {
        if (this.dKy != null && this.dKx != null) {
            this.dKy.nm(this.dKx.getMaxImagesAllowed());
            if (this.dKx.aHB() != null) {
                for (ImageFileInfo imageFileInfo : this.dKx.aHB()) {
                    this.dKy.e(imageFileInfo);
                }
            }
            aHr();
        }
    }

    private void aHk() {
        int size = this.dKx.size();
        this.dKy.o(size != 0, getPageContext().getPageActivity().getString(this.dKC ? n.i.live_album_finish_btn : n.i.album_finish_btn, new Object[]{Integer.valueOf(size)}));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragmentActivity
    public void onChangeSkinType(int i) {
        this.dKy.onChangeSkinType(i);
        if (this.dKE != null) {
            this.dKE.onChangeSkinType(i);
        }
    }

    private void aHl() {
        if (this.dKA == 2) {
            TiebaStatic.log("c10489");
        }
        Intent intent = new Intent();
        intent.putExtra(AlbumActivityConfig.ALBUM_RESULT, this.dKx.getWriteImagesInfo().toJsonString());
        intent.putExtra(AlbumActivityConfig.CAMERA_REQUEST_FROM, this.dKA);
        setResult(-1, intent);
        finish();
    }

    @Override // com.baidu.adp.base.BdBaseFragmentActivity, android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.dKy.aHK()) {
            aHl();
        } else if (view == this.dKy.aHL()) {
            if (this.dKx != null) {
                this.dKx.setLastAlbumId(null);
            }
            aHq();
        } else if (view == this.dKy.aHM()) {
            ng(0);
        } else if (view == this.dKy.aHN()) {
            aHm();
        }
    }

    private void aHm() {
        if (this.dKy != null && this.dKx != null) {
            this.dKx.setOriginalImg(!this.dKx.isOriginalImg());
            if (this.dKx.isOriginalImg()) {
                if (!StringUtils.isNull(this.from, true) && !StringUtils.isNull(this.fid, true)) {
                    TiebaStatic.log(new av("c10349").ab(ImageViewerConfig.FORUM_ID, this.fid).ab("obj_type", this.from));
                }
                aHs();
                return;
            }
            this.dKy.a(false, 0L);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public o aHn() {
        return this.dKx;
    }

    public com.baidu.tbadk.img.b aHo() {
        return this.anY;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void ng(int i) {
        u(i, true);
    }

    void u(int i, boolean z) {
        if (!this.dKz) {
            if (i == 0) {
                setSwipeBackEnabled(true);
                if (this.dKF) {
                    this.dKy.r(false, this.dKx.isOriginalImg());
                }
            } else {
                setSwipeBackEnabled(false);
                if (this.dKF) {
                    this.dKy.r(true, this.dKx.isOriginalImg());
                    aHs();
                }
            }
            FragmentTransaction beginTransaction = getSupportFragmentManager().beginTransaction();
            Fragment findFragmentByTag = getSupportFragmentManager().findFragmentByTag(this.dKy.no(this.bhi));
            if (findFragmentByTag != null) {
                beginTransaction.hide(findFragmentByTag);
                if (z) {
                    this.anY.Dd();
                }
            }
            this.bhi = i;
            if (this.dKy != null) {
                this.dKy.np(this.bhi);
            }
            if (getSupportFragmentManager().findFragmentByTag(this.dKy.no(i)) != null) {
                beginTransaction.show(this.dKy.nn(i));
            } else {
                beginTransaction.add(n.f.fragment, this.dKy.nn(i), this.dKy.no(i));
            }
            beginTransaction.commitAllowingStateLoss();
            getSupportFragmentManager().executePendingTransactions();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean a(ImageFileInfo imageFileInfo) {
        if (imageFileInfo == null) {
            return false;
        }
        int maxImagesAllowed = this.dKx.getMaxImagesAllowed();
        if (this.dKx.size() < maxImagesAllowed) {
            if (this.dKB == null || this.dKB.c(imageFileInfo)) {
                ImageFileInfo imageFileInfo2 = new ImageFileInfo();
                imageFileInfo2.setAlbumnId(imageFileInfo.getAlbumId());
                imageFileInfo2.setFilePath(imageFileInfo.getFilePath());
                this.dKx.addChooseFile(imageFileInfo2);
                aHk();
                aHr();
                this.dKy.e(imageFileInfo2);
                aHs();
                return true;
            }
            return false;
        }
        showToast(String.format(getPageContext().getContext().getString(n.i.album_beyond_max_choose), Integer.valueOf(maxImagesAllowed)));
        return false;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean b(ImageFileInfo imageFileInfo) {
        if (imageFileInfo == null) {
            return false;
        }
        this.dKx.delChooseFile(imageFileInfo);
        aHk();
        aHr();
        this.dKy.f(imageFileInfo);
        aHs();
        return true;
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity, android.support.v4.app.FragmentActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i == 4) {
            if (this.bhi == 0) {
                if (this.dKx != null) {
                    this.dKx.setLastAlbumId(null);
                }
                aHq();
                return true;
            } else if (this.bhi == 1) {
                ng(0);
                return true;
            } else {
                return true;
            }
        }
        return super.onKeyDown(i, keyEvent);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void v(int i, boolean z) {
        Fragment nn;
        if (this.dKy != null && (nn = this.dKy.nn(0)) != null && (nn instanceof ag)) {
            ((ag) nn).w(i, z);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void e(ImageFileInfo imageFileInfo, boolean z) {
        Fragment nn;
        if (this.dKy != null && (nn = this.dKy.nn(0)) != null && (nn instanceof ag)) {
            ((ag) nn).g(imageFileInfo, z);
        }
    }

    private void aHp() {
        Fragment nn;
        if (this.dKy != null && (nn = this.dKy.nn(0)) != null && (nn instanceof ag)) {
            ((ag) nn).refresh();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void f(ImageFileInfo imageFileInfo, boolean z) {
        Fragment nn;
        if (this.dKy != null && (nn = this.dKy.nn(1)) != null && (nn instanceof e)) {
            ((e) nn).g(imageFileInfo, z);
        }
    }

    private void aHq() {
        Intent intent = new Intent();
        String lastAlbumId = this.dKx.getLastAlbumId();
        if (TextUtils.isEmpty(lastAlbumId)) {
            lastAlbumId = "";
        }
        intent.putExtra(AlbumActivityConfig.LAST_ALBUM_ID, lastAlbumId);
        intent.putExtra(AlbumActivityConfig.CAMERA_REQUEST_FROM, this.dKA);
        setResult(0, intent);
        finish();
    }

    private void aHr() {
        if (this.dKx != null && this.dKy != null) {
            if (this.dKx.size() == this.dKx.getMaxImagesAllowed()) {
                this.dKy.hE(false);
            } else {
                this.dKy.hE(true);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.support.v4.app.FragmentActivity, android.app.Activity
    public void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (i2 == -1 && i == 12001) {
            nh(this.dKx.aHG());
            u(1, false);
        }
    }

    private void nh(String str) {
        String str2;
        boolean z;
        if (StringUtils.isNull(str, true)) {
            str = "camera.jpg";
            str2 = Environment.getExternalStorageDirectory() + "/" + TbConfig.getTempDirName() + "/camera.jpg";
            z = true;
        } else {
            str2 = Environment.getExternalStorageDirectory() + "/" + TbConfig.getTempDirName() + "/" + TbConfig.LOCAL_CAMERA_DIR + "/" + str;
            z = false;
        }
        if (!TextUtils.isEmpty(str2)) {
            try {
                int cK = com.baidu.tbadk.core.util.c.cK(str2);
                if (cK != 0) {
                    Bitmap b = com.baidu.tbadk.core.util.c.b(str2, com.baidu.adp.lib.util.k.dip2px(getPageContext().getPageActivity(), com.baidu.adp.lib.util.k.K(getPageContext().getPageActivity())), com.baidu.adp.lib.util.k.dip2px(getPageContext().getPageActivity(), com.baidu.adp.lib.util.k.L(getPageContext().getPageActivity())));
                    Bitmap i = com.baidu.tbadk.core.util.c.i(b, cK);
                    if (b != i) {
                        b.recycle();
                    }
                    if (z) {
                        com.baidu.tbadk.core.util.n.a(null, str, i, 100);
                    } else {
                        com.baidu.tbadk.core.util.n.a(TbConfig.LOCAL_CAMERA_DIR, str, i, 100);
                    }
                    i.recycle();
                }
            } catch (Exception e) {
            }
            ImageFileInfo imageFileInfo = new ImageFileInfo();
            imageFileInfo.setFilePath(str2);
            imageFileInfo.setTempFile(true);
            if (this.dKx.aHD() != null && this.dKx.aHD().size() > 0) {
                this.dKx.aHD().add(1, imageFileInfo);
                a(imageFileInfo);
                this.dKx.nl(this.dKx.aHD().indexOf(imageFileInfo));
                aHp();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.adp.base.BdBaseFragmentActivity, android.support.v4.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        this.dKz = true;
        if (this.dKy != null) {
            this.dKy.onDestroy();
        }
        this.anY.Dd();
        p.aHI().destory();
    }

    public void aHs() {
        if (this.dKy != null && this.dKx != null && this.dKx.aHB() != null && this.dKx.isOriginalImg()) {
            long j = 0;
            for (ImageFileInfo imageFileInfo : this.dKx.aHB()) {
                if (imageFileInfo != null) {
                    j += com.baidu.tbadk.core.util.n.da(imageFileInfo.getFilePath());
                }
            }
            this.dKy.a(true, j);
        }
    }
}
