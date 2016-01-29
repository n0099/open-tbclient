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
import com.baidu.tbadk.core.util.BitmapHelper;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.ar;
import com.baidu.tbadk.core.util.au;
import com.baidu.tbadk.img.ImageFileInfo;
import com.baidu.tbadk.img.WriteImagesInfo;
import com.baidu.tieba.t;
import com.baidu.tieba.write.write.WriteActivity;
/* loaded from: classes.dex */
public class AlbumActivity extends BaseFragmentActivity implements View.OnClickListener {
    private com.baidu.tbadk.img.b aqu;
    private o emG;
    private t emH;
    private y emK;
    private int bnW = 0;
    private boolean emI = false;
    private int emJ = 0;
    private String from = "";
    private String fid = "";
    private boolean emL = false;
    private AlertDialog emM = null;
    private a emN = null;
    private boolean emO = false;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.adp.base.BdBaseFragmentActivity, android.support.v4.app.FragmentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.aqu = new com.baidu.tbadk.img.b();
        initView();
        initData(bundle);
        aSr();
        ps(0);
        aSs();
        if (com.baidu.tbadk.core.sharedPref.b.uO().getBoolean("add_img_water_tip_show", true) && aSp()) {
            aSq();
            com.baidu.tbadk.core.sharedPref.b.uO().putBoolean("add_img_water_tip_show", false);
        }
    }

    /* loaded from: classes.dex */
    public class a extends x.a {
        public int ahU;
        private TextView dgl;
        private TextView emQ;
        private TextView emR;

        public a(View view) {
            super(view);
            this.ahU = 3;
            this.dgl = (TextView) view.findViewById(t.g.img_water_setting_title);
            this.emQ = (TextView) view.findViewById(t.g.img_water_setting_content);
            this.emR = (TextView) view.findViewById(t.g.goto_setting);
            this.emR.setOnClickListener(new c(this));
            aSB();
        }

        private void aSB() {
            ar.b(this.dgl, t.d.cp_cont_g, 1);
            ar.b(this.emQ, t.d.cp_cont_g, 1);
            ar.b(this.emR, t.d.cp_link_tip_a, 1);
        }

        public void onChangeSkinType(int i) {
            if (this.ahU != i) {
                aSB();
                this.ahU = i;
            }
            if (AlbumActivity.this.emH != null) {
                AlbumActivity.this.emH.pC(AlbumActivity.this.bnW);
            }
        }
    }

    private boolean aSp() {
        return 2 == this.emJ || 3 == this.emJ || 1 == this.emJ || 3 == this.emJ || "frs".equals(this.from) || "pb".equals(this.from) || WriteActivity.etm.equals(this.from);
    }

    private void aSq() {
        if (this.emN == null) {
            this.emN = new a(LayoutInflater.from(getActivity()).inflate(t.h.dialog_img_water_setting, (ViewGroup) null));
        }
        this.emM = new AlertDialog.Builder(getActivity()).create();
        this.emM.show();
        Window window = this.emM.getWindow();
        WindowManager.LayoutParams attributes = window.getAttributes();
        attributes.dimAmount = 0.5f;
        attributes.width = -2;
        attributes.height = -2;
        attributes.y = 0 - (com.baidu.adp.lib.util.k.L(getActivity()) / 5);
        window.setAttributes(attributes);
        window.setContentView(this.emN.getView());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.adp.base.BdBaseFragmentActivity, android.support.v4.app.FragmentActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        if (this.emM != null) {
            com.baidu.adp.lib.h.h.hr().postDelayed(new com.baidu.tieba.write.album.a(this), 3000L);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.adp.base.BdBaseFragmentActivity, android.support.v4.app.FragmentActivity, android.app.Activity
    public void onPause() {
        super.onPause();
        if (this.emM != null) {
            this.emM.dismiss();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.support.v4.app.FragmentActivity, android.app.Activity
    public void onSaveInstanceState(Bundle bundle) {
        bundle.putString(AlbumActivityConfig.WRITE_IMAGES_INFO, this.emG.getWriteImagesInfo().toJsonString());
        bundle.putBoolean(AlbumActivityConfig.USE_ORIGINAL_IMG, this.emO);
    }

    private void initData(Bundle bundle) {
        this.emG = new o(this);
        if (bundle != null) {
            WriteImagesInfo writeImagesInfo = new WriteImagesInfo();
            writeImagesInfo.parseJson(bundle.getString(AlbumActivityConfig.WRITE_IMAGES_INFO));
            this.emG.setWriteImagesInfo(writeImagesInfo);
            this.emG.nA(bundle.getString(AlbumActivityConfig.CAMERA_PHOTO_NAME));
            this.emO = bundle.getBoolean(AlbumActivityConfig.USE_ORIGINAL_IMG, false);
            return;
        }
        Intent intent = getIntent();
        if (intent != null) {
            WriteImagesInfo writeImagesInfo2 = new WriteImagesInfo();
            writeImagesInfo2.parseJson(intent.getStringExtra(AlbumActivityConfig.WRITE_IMAGES_INFO));
            this.emG.setWriteImagesInfo(writeImagesInfo2);
            this.emG.nA(intent.getStringExtra(AlbumActivityConfig.CAMERA_PHOTO_NAME));
            this.emJ = intent.getIntExtra(AlbumActivityConfig.CAMERA_REQUEST_FROM, 0);
            this.from = intent.getStringExtra("from");
            this.fid = intent.getStringExtra("forum_id");
            if (WriteActivity.etm.equals(this.from)) {
                this.emL = true;
            } else {
                this.emL = false;
            }
            if (this.emJ == 2) {
                this.emK = new b(this);
            }
            this.emG.iw(intent.getBooleanExtra(AlbumActivityConfig.AUTO_PHOTO_NAME, false));
            this.emO = intent.getBooleanExtra(AlbumActivityConfig.USE_ORIGINAL_IMG, false);
        }
    }

    private void initView() {
        this.emH = new t(this);
        this.emH.aSP();
    }

    private void aSr() {
        if (this.emH != null && this.emG != null) {
            this.emH.pz(this.emG.getMaxImagesAllowed());
            if (this.emG.aSI() != null) {
                for (ImageFileInfo imageFileInfo : this.emG.aSI()) {
                    this.emH.e(imageFileInfo);
                }
            }
            aSz();
        }
    }

    private void aSs() {
        int size = this.emG.size();
        this.emH.p(size != 0, getPageContext().getPageActivity().getString(this.emL ? t.j.live_album_finish_btn : t.j.album_finish_btn, new Object[]{Integer.valueOf(size)}));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragmentActivity
    public void onChangeSkinType(int i) {
        this.emH.onChangeSkinType(i);
        if (this.emN != null) {
            this.emN.onChangeSkinType(i);
        }
    }

    private void aSt() {
        if (this.emJ == 3) {
            TiebaStatic.log("c10489");
        }
        Intent intent = new Intent();
        intent.putExtra(AlbumActivityConfig.ALBUM_RESULT, this.emG.getWriteImagesInfo().toJsonString());
        intent.putExtra(AlbumActivityConfig.CAMERA_REQUEST_FROM, this.emJ);
        setResult(-1, intent);
        finish();
    }

    @Override // com.baidu.adp.base.BdBaseFragmentActivity, android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.emH.aSQ()) {
            aSt();
        } else if (view == this.emH.aSR()) {
            if (this.emG != null) {
                this.emG.setLastAlbumId(null);
            }
            aSy();
        } else if (view == this.emH.aSS()) {
            ps(0);
        } else if (view == this.emH.aST()) {
            aSu();
        }
    }

    private void aSu() {
        if (this.emH != null && this.emG != null) {
            this.emG.setOriginalImg(!this.emG.isOriginalImg());
            if (this.emG.isOriginalImg()) {
                if (!StringUtils.isNull(this.from, true) && !StringUtils.isNull(this.fid, true)) {
                    TiebaStatic.log(new au("c10349").aa(ImageViewerConfig.FORUM_ID, this.fid).aa("obj_type", this.from));
                }
                aSA();
                return;
            }
            this.emH.a(false, 0L);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public o aSv() {
        return this.emG;
    }

    public com.baidu.tbadk.img.b aSw() {
        return this.aqu;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void ps(int i) {
        x(i, true);
    }

    void x(int i, boolean z) {
        if (!this.emI) {
            if (i == 0) {
                setSwipeBackEnabled(true);
                if (this.emO) {
                    this.emH.x(false, this.emG.isOriginalImg());
                }
            } else {
                setSwipeBackEnabled(false);
                if (this.emO) {
                    this.emH.x(true, this.emG.isOriginalImg());
                    aSA();
                }
            }
            FragmentTransaction beginTransaction = getSupportFragmentManager().beginTransaction();
            Fragment findFragmentByTag = getSupportFragmentManager().findFragmentByTag(this.emH.pB(this.bnW));
            if (findFragmentByTag != null) {
                beginTransaction.hide(findFragmentByTag);
                if (z) {
                    this.aqu.Ej();
                }
            }
            this.bnW = i;
            if (this.emH != null) {
                this.emH.pC(this.bnW);
            }
            if (getSupportFragmentManager().findFragmentByTag(this.emH.pB(i)) != null) {
                beginTransaction.show(this.emH.pA(i));
            } else {
                beginTransaction.add(t.g.fragment, this.emH.pA(i), this.emH.pB(i));
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
        int maxImagesAllowed = this.emG.getMaxImagesAllowed();
        if (this.emG.size() < maxImagesAllowed) {
            if (this.emK == null || this.emK.c(imageFileInfo)) {
                ImageFileInfo imageFileInfo2 = new ImageFileInfo();
                imageFileInfo2.setAlbumnId(imageFileInfo.getAlbumId());
                imageFileInfo2.setFilePath(imageFileInfo.getFilePath());
                this.emG.addChooseFile(imageFileInfo2);
                aSs();
                aSz();
                this.emH.e(imageFileInfo2);
                aSA();
                return true;
            }
            return false;
        }
        showToast(String.format(getPageContext().getContext().getString(t.j.album_beyond_max_choose), Integer.valueOf(maxImagesAllowed)));
        return false;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean b(ImageFileInfo imageFileInfo) {
        if (imageFileInfo == null) {
            return false;
        }
        this.emG.delChooseFile(imageFileInfo);
        aSs();
        aSz();
        this.emH.f(imageFileInfo);
        aSA();
        return true;
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity, android.support.v4.app.FragmentActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i == 4) {
            if (this.bnW == 0) {
                if (this.emG != null) {
                    this.emG.setLastAlbumId(null);
                }
                aSy();
                return true;
            } else if (this.bnW == 1) {
                ps(0);
                return true;
            } else {
                return true;
            }
        }
        return super.onKeyDown(i, keyEvent);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void y(int i, boolean z) {
        Fragment pA;
        if (this.emH != null && (pA = this.emH.pA(0)) != null && (pA instanceof ag)) {
            ((ag) pA).z(i, z);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void e(ImageFileInfo imageFileInfo, boolean z) {
        Fragment pA;
        if (this.emH != null && (pA = this.emH.pA(0)) != null && (pA instanceof ag)) {
            ((ag) pA).g(imageFileInfo, z);
        }
    }

    private void aSx() {
        Fragment pA;
        if (this.emH != null && (pA = this.emH.pA(0)) != null && (pA instanceof ag)) {
            ((ag) pA).refresh();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void f(ImageFileInfo imageFileInfo, boolean z) {
        Fragment pA;
        if (this.emH != null && (pA = this.emH.pA(1)) != null && (pA instanceof e)) {
            ((e) pA).g(imageFileInfo, z);
        }
    }

    private void aSy() {
        Intent intent = new Intent();
        String lastAlbumId = this.emG.getLastAlbumId();
        if (TextUtils.isEmpty(lastAlbumId)) {
            lastAlbumId = "";
        }
        intent.putExtra(AlbumActivityConfig.LAST_ALBUM_ID, lastAlbumId);
        intent.putExtra(AlbumActivityConfig.CAMERA_REQUEST_FROM, this.emJ);
        setResult(0, intent);
        finish();
    }

    private void aSz() {
        if (this.emG != null && this.emH != null) {
            if (this.emG.size() == this.emG.getMaxImagesAllowed()) {
                this.emH.iz(false);
            } else {
                this.emH.iz(true);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.support.v4.app.FragmentActivity, android.app.Activity
    public void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (i2 == -1 && i == 12001) {
            nx(this.emG.aSM());
            x(1, false);
        }
    }

    private void nx(String str) {
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
                int readPictureDegree = BitmapHelper.readPictureDegree(str2);
                if (readPictureDegree != 0) {
                    Bitmap loadResizedBitmap = BitmapHelper.loadResizedBitmap(str2, com.baidu.adp.lib.util.k.dip2px(getPageContext().getPageActivity(), com.baidu.adp.lib.util.k.K(getPageContext().getPageActivity())), com.baidu.adp.lib.util.k.dip2px(getPageContext().getPageActivity(), com.baidu.adp.lib.util.k.L(getPageContext().getPageActivity())));
                    Bitmap rotateBitmapBydegree = BitmapHelper.rotateBitmapBydegree(loadResizedBitmap, readPictureDegree);
                    if (loadResizedBitmap != rotateBitmapBydegree) {
                        loadResizedBitmap.recycle();
                    }
                    if (z) {
                        com.baidu.tbadk.core.util.m.b(null, str, rotateBitmapBydegree, 100);
                    } else {
                        com.baidu.tbadk.core.util.m.b(TbConfig.LOCAL_CAMERA_DIR, str, rotateBitmapBydegree, 100);
                    }
                    rotateBitmapBydegree.recycle();
                }
            } catch (Exception e) {
            }
            ImageFileInfo imageFileInfo = new ImageFileInfo();
            imageFileInfo.setFilePath(str2);
            imageFileInfo.setTempFile(true);
            if (this.emG.aSK() != null && this.emG.aSK().size() > 0) {
                this.emG.aSK().add(1, imageFileInfo);
                a(imageFileInfo);
                this.emG.py(this.emG.aSK().indexOf(imageFileInfo));
                aSx();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.adp.base.BdBaseFragmentActivity, android.support.v4.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        this.emI = true;
        if (this.emH != null) {
            this.emH.onDestroy();
        }
        this.aqu.Ej();
        p.aSO().destory();
    }

    public void aSA() {
        if (this.emH != null && this.emG != null && this.emG.aSI() != null && this.emG.isOriginalImg()) {
            long j = 0;
            for (ImageFileInfo imageFileInfo : this.emG.aSI()) {
                if (imageFileInfo != null) {
                    j += com.baidu.tbadk.core.util.m.da(imageFileInfo.getFilePath());
                }
            }
            this.emH.a(true, j);
        }
    }
}
