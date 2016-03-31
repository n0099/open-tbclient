package com.baidu.tieba.write.album;

import android.app.AlertDialog;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.os.Environment;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.util.ArrayMap;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.TextView;
import com.baidu.a.a.a;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.widget.ListView.x;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tbadk.core.atomData.AlbumActivityConfig;
import com.baidu.tbadk.core.util.BitmapHelper;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.as;
import com.baidu.tbadk.core.util.at;
import com.baidu.tbadk.core.util.aw;
import com.baidu.tbadk.img.ImageFileInfo;
import com.baidu.tbadk.img.WriteImagesInfo;
import com.baidu.tieba.t;
import com.baidu.tieba.write.write.WriteActivity;
/* loaded from: classes.dex */
public class AlbumActivity extends BaseFragmentActivity implements View.OnClickListener, a.InterfaceC0000a {
    private com.baidu.tbadk.img.b aqL;
    private o eGD;
    private t eGE;
    private y eGH;
    private int bsT = 0;
    private boolean eGF = false;
    private int eGG = 0;
    private String from = "";
    private String fid = "";
    private boolean eGI = false;
    private AlertDialog eGJ = null;
    private a eGK = null;
    private boolean eGL = false;
    private String eGM = "";

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.adp.base.BdBaseFragmentActivity, android.support.v4.app.FragmentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.aqL = new com.baidu.tbadk.img.b();
        initView();
        initData(bundle);
        aYT();
        qm(0);
        aYU();
        boolean z = com.baidu.tbadk.core.sharedPref.b.vk().getBoolean("add_img_water_tip_show", true);
        if (!(com.baidu.tbadk.core.l.qE().qI() != 0) && z && aYR()) {
            aYS();
            com.baidu.tbadk.core.sharedPref.b.vk().putBoolean("add_img_water_tip_show", false);
        }
    }

    /* loaded from: classes.dex */
    public class a extends x.a {
        public int aik;
        private TextView dAK;
        private TextView eGO;
        private TextView eGP;

        public a(View view) {
            super(view);
            this.aik = 3;
            this.dAK = (TextView) view.findViewById(t.g.img_water_setting_title);
            this.eGO = (TextView) view.findViewById(t.g.img_water_setting_content);
            this.eGP = (TextView) view.findViewById(t.g.goto_setting);
            this.eGP.setOnClickListener(new c(this));
            anK();
        }

        private void anK() {
            at.b(this.dAK, t.d.cp_cont_g, 1);
            at.b(this.eGO, t.d.cp_cont_g, 1);
            at.b(this.eGP, t.d.cp_link_tip_a, 1);
        }

        public void onChangeSkinType(int i) {
            if (this.aik != i) {
                anK();
                this.aik = i;
            }
            if (AlbumActivity.this.eGE != null) {
                AlbumActivity.this.eGE.qv(AlbumActivity.this.bsT);
            }
        }
    }

    private boolean aYR() {
        return 2 == this.eGG || 3 == this.eGG || 1 == this.eGG || 3 == this.eGG || "frs".equals(this.from) || "pb".equals(this.from) || WriteActivity.eMX.equals(this.from);
    }

    private void aYS() {
        if (this.eGK == null) {
            this.eGK = new a(LayoutInflater.from(getActivity()).inflate(t.h.dialog_img_water_setting, (ViewGroup) null));
        }
        this.eGJ = new AlertDialog.Builder(getActivity()).create();
        this.eGJ.show();
        Window window = this.eGJ.getWindow();
        WindowManager.LayoutParams attributes = window.getAttributes();
        attributes.dimAmount = 0.5f;
        attributes.width = -2;
        attributes.height = -2;
        attributes.y = 0 - (com.baidu.adp.lib.util.k.C(getActivity()) / 5);
        window.setAttributes(attributes);
        window.setContentView(this.eGK.getView());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.adp.base.BdBaseFragmentActivity, android.support.v4.app.FragmentActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        if (this.eGJ != null) {
            com.baidu.adp.lib.h.h.hx().postDelayed(new com.baidu.tieba.write.album.a(this), 3000L);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.adp.base.BdBaseFragmentActivity, android.support.v4.app.FragmentActivity, android.app.Activity
    public void onPause() {
        super.onPause();
        if (this.eGJ != null) {
            this.eGJ.dismiss();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.support.v4.app.FragmentActivity, android.app.Activity
    public void onSaveInstanceState(Bundle bundle) {
        bundle.putString(AlbumActivityConfig.WRITE_IMAGES_INFO, this.eGD.getWriteImagesInfo().toJsonString());
        bundle.putBoolean(AlbumActivityConfig.USE_ORIGINAL_IMG, this.eGL);
    }

    private void initData(Bundle bundle) {
        this.eGD = new o(this);
        if (bundle != null) {
            WriteImagesInfo writeImagesInfo = new WriteImagesInfo();
            writeImagesInfo.parseJson(bundle.getString(AlbumActivityConfig.WRITE_IMAGES_INFO));
            this.eGD.setWriteImagesInfo(writeImagesInfo);
            this.eGD.oN(bundle.getString(AlbumActivityConfig.CAMERA_PHOTO_NAME));
            this.eGL = bundle.getBoolean(AlbumActivityConfig.USE_ORIGINAL_IMG, false);
            return;
        }
        Intent intent = getIntent();
        if (intent != null) {
            WriteImagesInfo writeImagesInfo2 = new WriteImagesInfo();
            writeImagesInfo2.parseJson(intent.getStringExtra(AlbumActivityConfig.WRITE_IMAGES_INFO));
            this.eGD.setWriteImagesInfo(writeImagesInfo2);
            this.eGD.oN(intent.getStringExtra(AlbumActivityConfig.CAMERA_PHOTO_NAME));
            this.eGG = intent.getIntExtra(AlbumActivityConfig.CAMERA_REQUEST_FROM, 0);
            this.from = intent.getStringExtra("from");
            this.fid = intent.getStringExtra("forum_id");
            if (WriteActivity.eMX.equals(this.from)) {
                this.eGI = true;
            } else {
                this.eGI = false;
            }
            if (this.eGG == 2) {
                this.eGH = new b(this);
            }
            this.eGD.jm(intent.getBooleanExtra(AlbumActivityConfig.AUTO_PHOTO_NAME, false));
            this.eGL = intent.getBooleanExtra(AlbumActivityConfig.USE_ORIGINAL_IMG, false);
        }
    }

    private void initView() {
        this.eGE = new t(this);
        this.eGE.aZp();
    }

    private void aYT() {
        if (this.eGE != null && this.eGD != null) {
            this.eGE.qs(this.eGD.getMaxImagesAllowed());
            if (this.eGD.aZi() != null) {
                for (ImageFileInfo imageFileInfo : this.eGD.aZi()) {
                    this.eGE.g(imageFileInfo);
                }
            }
            aZa();
        }
    }

    private void aYU() {
        int size = this.eGD.size();
        this.eGE.o(size != 0, getPageContext().getPageActivity().getString(this.eGI ? t.j.live_album_finish_btn : t.j.album_finish_btn, new Object[]{Integer.valueOf(size)}));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragmentActivity
    public void onChangeSkinType(int i) {
        this.eGE.onChangeSkinType(i);
        if (this.eGK != null) {
            this.eGK.onChangeSkinType(i);
        }
    }

    private void aYV() {
        if (this.eGG == 3) {
            TiebaStatic.log("c10489");
        }
        Intent intent = new Intent();
        intent.putExtra(AlbumActivityConfig.ALBUM_RESULT, this.eGD.getWriteImagesInfo().toJsonString());
        intent.putExtra(AlbumActivityConfig.CAMERA_REQUEST_FROM, this.eGG);
        setResult(-1, intent);
        finish();
    }

    @Override // com.baidu.adp.base.BdBaseFragmentActivity, android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.eGE.aZq()) {
            aYV();
        } else if (view == this.eGE.aZr()) {
            if (this.eGD != null) {
                this.eGD.setLastAlbumId(null);
            }
            aYZ();
        } else if (view == this.eGE.aZs()) {
            qm(0);
        } else if (view == this.eGE.aZt()) {
            aYW();
        }
    }

    private void aYW() {
        if (this.eGE != null && this.eGD != null) {
            this.eGD.setOriginalImg(!this.eGD.isOriginalImg());
            if (this.eGD.isOriginalImg()) {
                if (!StringUtils.isNull(this.from, true) && !StringUtils.isNull(this.fid, true)) {
                    TiebaStatic.log(new aw("c10349").ac("fid", this.fid).ac("obj_type", this.from));
                }
                aZb();
                return;
            }
            this.eGE.a(false, 0L);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public o aYX() {
        return this.eGD;
    }

    public com.baidu.tbadk.img.b YO() {
        return this.aqL;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void qm(int i) {
        x(i, true);
    }

    void x(int i, boolean z) {
        if (!this.eGF) {
            if (i == 0) {
                setSwipeBackEnabled(true);
                if (this.eGL) {
                    this.eGE.z(false, this.eGD.isOriginalImg());
                }
            } else {
                setSwipeBackEnabled(false);
                if (this.eGL) {
                    this.eGE.z(true, this.eGD.isOriginalImg());
                    aZb();
                }
            }
            FragmentTransaction beginTransaction = getSupportFragmentManager().beginTransaction();
            Fragment findFragmentByTag = getSupportFragmentManager().findFragmentByTag(this.eGE.qu(this.bsT));
            if (findFragmentByTag != null) {
                beginTransaction.hide(findFragmentByTag);
                if (z) {
                    this.aqL.EU();
                }
            }
            this.bsT = i;
            if (this.eGE != null) {
                this.eGE.qv(this.bsT);
            }
            if (getSupportFragmentManager().findFragmentByTag(this.eGE.qu(i)) != null) {
                beginTransaction.show(this.eGE.qt(i));
            } else {
                beginTransaction.add(t.g.fragment, this.eGE.qt(i), this.eGE.qu(i));
            }
            beginTransaction.commitAllowingStateLoss();
            getSupportFragmentManager().executePendingTransactions();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean c(ImageFileInfo imageFileInfo) {
        if (imageFileInfo == null) {
            return false;
        }
        int maxImagesAllowed = this.eGD.getMaxImagesAllowed();
        if (this.eGD.size() < maxImagesAllowed) {
            if (this.eGH == null || this.eGH.e(imageFileInfo)) {
                ImageFileInfo imageFileInfo2 = new ImageFileInfo();
                imageFileInfo2.setAlbumnId(imageFileInfo.getAlbumId());
                imageFileInfo2.setFilePath(imageFileInfo.getFilePath());
                imageFileInfo2.setModifyTime(imageFileInfo.getModifyTime());
                this.eGD.addChooseFile(imageFileInfo2);
                aYU();
                aZa();
                this.eGE.g(imageFileInfo2);
                aZb();
                return true;
            }
            return false;
        }
        showToast(String.format(getPageContext().getContext().getString(t.j.album_beyond_max_choose), Integer.valueOf(maxImagesAllowed)));
        return false;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean d(ImageFileInfo imageFileInfo) {
        if (imageFileInfo == null) {
            return false;
        }
        this.eGD.delChooseFile(imageFileInfo);
        aYU();
        aZa();
        this.eGE.h(imageFileInfo);
        aZb();
        return true;
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity, android.support.v4.app.FragmentActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i == 4) {
            if (this.bsT == 0) {
                if (this.eGD != null) {
                    this.eGD.setLastAlbumId(null);
                }
                aYZ();
                return true;
            } else if (this.bsT == 1) {
                qm(0);
                return true;
            } else {
                return true;
            }
        }
        return super.onKeyDown(i, keyEvent);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void y(int i, boolean z) {
        Fragment qt;
        if (this.eGE != null && (qt = this.eGE.qt(0)) != null && (qt instanceof ag)) {
            ((ag) qt).z(i, z);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void e(ImageFileInfo imageFileInfo, boolean z) {
        Fragment qt;
        if (this.eGE != null && (qt = this.eGE.qt(0)) != null && (qt instanceof ag)) {
            ((ag) qt).g(imageFileInfo, z);
        }
    }

    private void aYY() {
        Fragment qt;
        if (this.eGE != null && (qt = this.eGE.qt(0)) != null && (qt instanceof ag)) {
            ((ag) qt).refresh();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void f(ImageFileInfo imageFileInfo, boolean z) {
        Fragment qt;
        if (this.eGE != null && (qt = this.eGE.qt(1)) != null && (qt instanceof e)) {
            ((e) qt).g(imageFileInfo, z);
        }
    }

    private void aYZ() {
        Intent intent = new Intent();
        String lastAlbumId = this.eGD.getLastAlbumId();
        if (TextUtils.isEmpty(lastAlbumId)) {
            lastAlbumId = "";
        }
        intent.putExtra(AlbumActivityConfig.LAST_ALBUM_ID, lastAlbumId);
        intent.putExtra(AlbumActivityConfig.CAMERA_REQUEST_FROM, this.eGG);
        setResult(0, intent);
        finish();
    }

    private void aZa() {
        if (this.eGD != null && this.eGE != null) {
            if (this.eGD.size() == this.eGD.getMaxImagesAllowed()) {
                this.eGE.jp(false);
            } else {
                this.eGE.jp(true);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.support.v4.app.FragmentActivity, android.app.Activity
    public void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (i2 == -1 && i == 12001) {
            oJ(this.eGD.aZm());
            x(1, false);
        }
    }

    private void oJ(String str) {
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
                    Bitmap loadResizedBitmap = BitmapHelper.loadResizedBitmap(str2, com.baidu.adp.lib.util.k.dip2px(getPageContext().getPageActivity(), com.baidu.adp.lib.util.k.B(getPageContext().getPageActivity())), com.baidu.adp.lib.util.k.dip2px(getPageContext().getPageActivity(), com.baidu.adp.lib.util.k.C(getPageContext().getPageActivity())));
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
            if (this.eGD.aZk() != null && this.eGD.aZk().size() > 0) {
                this.eGD.aZk().add(1, imageFileInfo);
                c(imageFileInfo);
                this.eGD.qr(this.eGD.aZk().indexOf(imageFileInfo));
                aYY();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.adp.base.BdBaseFragmentActivity, android.support.v4.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        this.eGF = true;
        if (this.eGE != null) {
            this.eGE.onDestroy();
        }
        this.aqL.EU();
        p.aZo().destory();
    }

    public void aZb() {
        if (this.eGE != null && this.eGD != null && this.eGD.aZi() != null && this.eGD.isOriginalImg()) {
            long j = 0;
            for (ImageFileInfo imageFileInfo : this.eGD.aZi()) {
                if (imageFileInfo != null) {
                    j += com.baidu.tbadk.core.util.m.de(imageFileInfo.getFilePath());
                }
            }
            this.eGE.a(true, j);
        }
    }

    public void oK(String str) {
        this.eGM = str;
        if (!com.baidu.tbadk.core.util.ag.c(getPageContext().getPageActivity(), 1)) {
            if (StringUtils.isNull(this.eGM)) {
                as.c(getPageContext());
            } else {
                as.b(getPageContext(), this.eGM);
            }
        }
    }

    @Override // com.baidu.a.a.a.InterfaceC0000a
    public void a(int i, String[] strArr, int[] iArr) {
        if (i == 1) {
            if (com.baidu.tbadk.core.util.ag.S(getApplicationContext())) {
                if (StringUtils.isNull(this.eGM)) {
                    as.c(getPageContext());
                } else {
                    as.b(getPageContext(), this.eGM);
                }
            } else {
                showToast(t.j.system_permission_prompt_camera);
            }
            ArrayMap<String, Boolean> a2 = com.baidu.tbadk.core.util.ag.a(strArr, iArr);
            if (a2.containsKey("android.permission.WRITE_EXTERNAL_STORAGE") && !a2.get("android.permission.WRITE_EXTERNAL_STORAGE").booleanValue()) {
                showToast(t.j.sdcard_permission_denied_advert_for_camera);
            }
        }
    }
}
