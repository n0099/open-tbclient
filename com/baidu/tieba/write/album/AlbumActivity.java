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
    private com.baidu.tbadk.img.b apC;
    private o dRW;
    private t dRX;
    private y dSa;
    private int bkZ = 0;
    private boolean dRY = false;
    private int dRZ = 0;
    private String from = "";
    private String fid = "";
    private boolean dSb = false;
    private AlertDialog dSc = null;
    private a dSd = null;
    private boolean dSe = false;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.adp.base.BdBaseFragmentActivity, android.support.v4.app.FragmentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.apC = new com.baidu.tbadk.img.b();
        initView();
        initData(bundle);
        aJD();
        nY(0);
        aJE();
        if (com.baidu.tbadk.core.sharedPref.b.tJ().getBoolean("add_img_water_tip_show", true) && aJB()) {
            aJC();
            com.baidu.tbadk.core.sharedPref.b.tJ().putBoolean("add_img_water_tip_show", false);
        }
    }

    /* loaded from: classes.dex */
    public class a extends x.a {
        public int ahf;
        private TextView bID;
        private TextView dCu;
        private TextView dSg;

        public a(View view) {
            super(view);
            this.ahf = 3;
            this.dCu = (TextView) view.findViewById(n.g.img_water_setting_title);
            this.bID = (TextView) view.findViewById(n.g.img_water_setting_content);
            this.dSg = (TextView) view.findViewById(n.g.goto_setting);
            this.dSg.setOnClickListener(new c(this));
            aJN();
        }

        private void aJN() {
            as.b(this.dCu, n.d.cp_cont_g, 1);
            as.b(this.bID, n.d.cp_cont_g, 1);
            as.b(this.dSg, n.d.cp_link_tip_a, 1);
        }

        public void onChangeSkinType(int i) {
            if (this.ahf != i) {
                aJN();
                this.ahf = i;
            }
            if (AlbumActivity.this.dRX != null) {
                AlbumActivity.this.dRX.oh(AlbumActivity.this.bkZ);
            }
        }
    }

    private boolean aJB() {
        return 2 == this.dRZ || 3 == this.dRZ || 1 == this.dRZ || 3 == this.dRZ || "frs".equals(this.from) || "pb".equals(this.from) || WriteActivity.dYw.equals(this.from);
    }

    private void aJC() {
        if (this.dSd == null) {
            this.dSd = new a(LayoutInflater.from(getActivity()).inflate(n.h.dialog_img_water_setting, (ViewGroup) null));
        }
        this.dSc = new AlertDialog.Builder(getActivity()).create();
        this.dSc.show();
        Window window = this.dSc.getWindow();
        WindowManager.LayoutParams attributes = window.getAttributes();
        attributes.dimAmount = 0.5f;
        attributes.width = -2;
        attributes.height = -2;
        attributes.y = 0 - (com.baidu.adp.lib.util.k.L(getActivity()) / 5);
        window.setAttributes(attributes);
        window.setContentView(this.dSd.getView());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.adp.base.BdBaseFragmentActivity, android.support.v4.app.FragmentActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        if (this.dSc != null) {
            com.baidu.adp.lib.h.h.hj().postDelayed(new com.baidu.tieba.write.album.a(this), 3000L);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.adp.base.BdBaseFragmentActivity, android.support.v4.app.FragmentActivity, android.app.Activity
    public void onPause() {
        super.onPause();
        if (this.dSc != null) {
            this.dSc.dismiss();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.support.v4.app.FragmentActivity, android.app.Activity
    public void onSaveInstanceState(Bundle bundle) {
        bundle.putString(AlbumActivityConfig.WRITE_IMAGES_INFO, this.dRW.getWriteImagesInfo().toJsonString());
        bundle.putBoolean(AlbumActivityConfig.USE_ORIGINAL_IMG, this.dSe);
    }

    private void initData(Bundle bundle) {
        this.dRW = new o(this);
        if (bundle != null) {
            WriteImagesInfo writeImagesInfo = new WriteImagesInfo();
            writeImagesInfo.parseJson(bundle.getString(AlbumActivityConfig.WRITE_IMAGES_INFO));
            this.dRW.setWriteImagesInfo(writeImagesInfo);
            this.dRW.nk(bundle.getString(AlbumActivityConfig.CAMERA_PHOTO_NAME));
            this.dSe = bundle.getBoolean(AlbumActivityConfig.USE_ORIGINAL_IMG, false);
            return;
        }
        Intent intent = getIntent();
        if (intent != null) {
            WriteImagesInfo writeImagesInfo2 = new WriteImagesInfo();
            writeImagesInfo2.parseJson(intent.getStringExtra(AlbumActivityConfig.WRITE_IMAGES_INFO));
            this.dRW.setWriteImagesInfo(writeImagesInfo2);
            this.dRW.nk(intent.getStringExtra(AlbumActivityConfig.CAMERA_PHOTO_NAME));
            this.dRZ = intent.getIntExtra(AlbumActivityConfig.CAMERA_REQUEST_FROM, 0);
            this.from = intent.getStringExtra("from");
            this.fid = intent.getStringExtra("forum_id");
            if (WriteActivity.dYw.equals(this.from)) {
                this.dSb = true;
            } else {
                this.dSb = false;
            }
            if (this.dRZ == 2) {
                this.dSa = new b(this);
            }
            this.dRW.hK(intent.getBooleanExtra(AlbumActivityConfig.AUTO_PHOTO_NAME, false));
            this.dSe = intent.getBooleanExtra(AlbumActivityConfig.USE_ORIGINAL_IMG, false);
        }
    }

    private void initView() {
        this.dRX = new t(this);
        this.dRX.aKe();
    }

    private void aJD() {
        if (this.dRX != null && this.dRW != null) {
            this.dRX.oe(this.dRW.getMaxImagesAllowed());
            if (this.dRW.aJW() != null) {
                for (ImageFileInfo imageFileInfo : this.dRW.aJW()) {
                    this.dRX.e(imageFileInfo);
                }
            }
            aJL();
        }
    }

    private void aJE() {
        int size = this.dRW.size();
        this.dRX.o(size != 0, getPageContext().getPageActivity().getString(this.dSb ? n.j.live_album_finish_btn : n.j.album_finish_btn, new Object[]{Integer.valueOf(size)}));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragmentActivity
    public void onChangeSkinType(int i) {
        this.dRX.onChangeSkinType(i);
        if (this.dSd != null) {
            this.dSd.onChangeSkinType(i);
        }
    }

    private void aJF() {
        if (this.dRZ == 3) {
            TiebaStatic.log("c10489");
        }
        Intent intent = new Intent();
        intent.putExtra(AlbumActivityConfig.ALBUM_RESULT, this.dRW.getWriteImagesInfo().toJsonString());
        intent.putExtra(AlbumActivityConfig.CAMERA_REQUEST_FROM, this.dRZ);
        setResult(-1, intent);
        finish();
    }

    @Override // com.baidu.adp.base.BdBaseFragmentActivity, android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.dRX.aKf()) {
            aJF();
        } else if (view == this.dRX.aKg()) {
            if (this.dRW != null) {
                this.dRW.setLastAlbumId(null);
            }
            aJK();
        } else if (view == this.dRX.aKh()) {
            nY(0);
        } else if (view == this.dRX.aKi()) {
            aJG();
        }
    }

    private void aJG() {
        if (this.dRX != null && this.dRW != null) {
            this.dRW.setOriginalImg(!this.dRW.isOriginalImg());
            if (this.dRW.isOriginalImg()) {
                if (!StringUtils.isNull(this.from, true) && !StringUtils.isNull(this.fid, true)) {
                    TiebaStatic.log(new av("c10349").aa(ImageViewerConfig.FORUM_ID, this.fid).aa("obj_type", this.from));
                }
                aJM();
                return;
            }
            this.dRX.a(false, 0L);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public o aJH() {
        return this.dRW;
    }

    public com.baidu.tbadk.img.b aJI() {
        return this.apC;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void nY(int i) {
        v(i, true);
    }

    void v(int i, boolean z) {
        if (!this.dRY) {
            if (i == 0) {
                setSwipeBackEnabled(true);
                if (this.dSe) {
                    this.dRX.u(false, this.dRW.isOriginalImg());
                }
            } else {
                setSwipeBackEnabled(false);
                if (this.dSe) {
                    this.dRX.u(true, this.dRW.isOriginalImg());
                    aJM();
                }
            }
            FragmentTransaction beginTransaction = getSupportFragmentManager().beginTransaction();
            Fragment findFragmentByTag = getSupportFragmentManager().findFragmentByTag(this.dRX.og(this.bkZ));
            if (findFragmentByTag != null) {
                beginTransaction.hide(findFragmentByTag);
                if (z) {
                    this.apC.CS();
                }
            }
            this.bkZ = i;
            if (this.dRX != null) {
                this.dRX.oh(this.bkZ);
            }
            if (getSupportFragmentManager().findFragmentByTag(this.dRX.og(i)) != null) {
                beginTransaction.show(this.dRX.of(i));
            } else {
                beginTransaction.add(n.g.fragment, this.dRX.of(i), this.dRX.og(i));
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
        int maxImagesAllowed = this.dRW.getMaxImagesAllowed();
        if (this.dRW.size() < maxImagesAllowed) {
            if (this.dSa == null || this.dSa.c(imageFileInfo)) {
                ImageFileInfo imageFileInfo2 = new ImageFileInfo();
                imageFileInfo2.setAlbumnId(imageFileInfo.getAlbumId());
                imageFileInfo2.setFilePath(imageFileInfo.getFilePath());
                this.dRW.addChooseFile(imageFileInfo2);
                aJE();
                aJL();
                this.dRX.e(imageFileInfo2);
                aJM();
                return true;
            }
            return false;
        }
        showToast(String.format(getPageContext().getContext().getString(n.j.album_beyond_max_choose), Integer.valueOf(maxImagesAllowed)));
        return false;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean b(ImageFileInfo imageFileInfo) {
        if (imageFileInfo == null) {
            return false;
        }
        this.dRW.delChooseFile(imageFileInfo);
        aJE();
        aJL();
        this.dRX.f(imageFileInfo);
        aJM();
        return true;
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity, android.support.v4.app.FragmentActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i == 4) {
            if (this.bkZ == 0) {
                if (this.dRW != null) {
                    this.dRW.setLastAlbumId(null);
                }
                aJK();
                return true;
            } else if (this.bkZ == 1) {
                nY(0);
                return true;
            } else {
                return true;
            }
        }
        return super.onKeyDown(i, keyEvent);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void w(int i, boolean z) {
        Fragment of;
        if (this.dRX != null && (of = this.dRX.of(0)) != null && (of instanceof ag)) {
            ((ag) of).x(i, z);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void e(ImageFileInfo imageFileInfo, boolean z) {
        Fragment of;
        if (this.dRX != null && (of = this.dRX.of(0)) != null && (of instanceof ag)) {
            ((ag) of).g(imageFileInfo, z);
        }
    }

    private void aJJ() {
        Fragment of;
        if (this.dRX != null && (of = this.dRX.of(0)) != null && (of instanceof ag)) {
            ((ag) of).refresh();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void f(ImageFileInfo imageFileInfo, boolean z) {
        Fragment of;
        if (this.dRX != null && (of = this.dRX.of(1)) != null && (of instanceof e)) {
            ((e) of).g(imageFileInfo, z);
        }
    }

    private void aJK() {
        Intent intent = new Intent();
        String lastAlbumId = this.dRW.getLastAlbumId();
        if (TextUtils.isEmpty(lastAlbumId)) {
            lastAlbumId = "";
        }
        intent.putExtra(AlbumActivityConfig.LAST_ALBUM_ID, lastAlbumId);
        intent.putExtra(AlbumActivityConfig.CAMERA_REQUEST_FROM, this.dRZ);
        setResult(0, intent);
        finish();
    }

    private void aJL() {
        if (this.dRW != null && this.dRX != null) {
            if (this.dRW.size() == this.dRW.getMaxImagesAllowed()) {
                this.dRX.hN(false);
            } else {
                this.dRX.hN(true);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.support.v4.app.FragmentActivity, android.app.Activity
    public void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (i2 == -1 && i == 12001) {
            nf(this.dRW.aKb());
            v(1, false);
        }
    }

    private void nf(String str) {
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
                int cN = com.baidu.tbadk.core.util.c.cN(str2);
                if (cN != 0) {
                    Bitmap b = com.baidu.tbadk.core.util.c.b(str2, com.baidu.adp.lib.util.k.dip2px(getPageContext().getPageActivity(), com.baidu.adp.lib.util.k.K(getPageContext().getPageActivity())), com.baidu.adp.lib.util.k.dip2px(getPageContext().getPageActivity(), com.baidu.adp.lib.util.k.L(getPageContext().getPageActivity())));
                    Bitmap i = com.baidu.tbadk.core.util.c.i(b, cN);
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
            if (this.dRW.aJY() != null && this.dRW.aJY().size() > 0) {
                this.dRW.aJY().add(1, imageFileInfo);
                a(imageFileInfo);
                this.dRW.od(this.dRW.aJY().indexOf(imageFileInfo));
                aJJ();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.adp.base.BdBaseFragmentActivity, android.support.v4.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        this.dRY = true;
        if (this.dRX != null) {
            this.dRX.onDestroy();
        }
        this.apC.CS();
        p.aKd().destory();
    }

    public void aJM() {
        if (this.dRX != null && this.dRW != null && this.dRW.aJW() != null && this.dRW.isOriginalImg()) {
            long j = 0;
            for (ImageFileInfo imageFileInfo : this.dRW.aJW()) {
                if (imageFileInfo != null) {
                    j += com.baidu.tbadk.core.util.n.dd(imageFileInfo.getFilePath());
                }
            }
            this.dRX.a(true, j);
        }
    }
}
