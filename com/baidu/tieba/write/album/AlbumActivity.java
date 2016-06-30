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
import com.baidu.adp.widget.ListView.y;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tbadk.core.atomData.AlbumActivityConfig;
import com.baidu.tbadk.core.util.BitmapHelper;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.au;
import com.baidu.tbadk.core.util.av;
import com.baidu.tbadk.core.util.ay;
import com.baidu.tbadk.img.ImageFileInfo;
import com.baidu.tbadk.img.WriteImagesInfo;
import com.baidu.tieba.u;
/* loaded from: classes.dex */
public class AlbumActivity extends BaseFragmentActivity implements View.OnClickListener, a.InterfaceC0000a {
    private com.baidu.tbadk.img.b anf;
    private o fCA;
    private t fCB;
    private y fCE;
    private int bPk = 0;
    private boolean fCC = false;
    private int fCD = 0;
    private String from = "";
    private String fid = "";
    private boolean fCF = false;
    private AlertDialog fCG = null;
    private a fCH = null;
    private boolean fCI = false;
    private String fCJ = "";

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.adp.base.BdBaseFragmentActivity, android.support.v4.app.FragmentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.anf = new com.baidu.tbadk.img.b();
        initView();
        initData(bundle);
        bjK();
        rZ(0);
        bjL();
        boolean z = com.baidu.tbadk.core.sharedPref.b.sO().getBoolean("add_img_water_tip_show", true);
        if (!(com.baidu.tbadk.core.l.nW().oa() != 0) && z && bjI()) {
            bjJ();
            com.baidu.tbadk.core.sharedPref.b.sO().putBoolean("add_img_water_tip_show", false);
        }
    }

    /* loaded from: classes.dex */
    public class a extends y.a {
        public int aeK;
        private TextView bdG;
        private TextView fCL;
        private TextView fCM;

        public a(View view) {
            super(view);
            this.aeK = 3;
            this.bdG = (TextView) view.findViewById(u.g.img_water_setting_title);
            this.fCL = (TextView) view.findViewById(u.g.img_water_setting_content);
            this.fCM = (TextView) view.findViewById(u.g.goto_setting);
            this.fCM.setOnClickListener(new c(this));
            bjU();
        }

        private void bjU() {
            av.c(this.bdG, u.d.cp_cont_g, 1);
            av.c(this.fCL, u.d.cp_cont_g, 1);
            av.c(this.fCM, u.d.cp_link_tip_a, 1);
        }

        public void onChangeSkinType(int i) {
            if (this.aeK != i) {
                bjU();
                this.aeK = i;
            }
            if (AlbumActivity.this.fCB != null) {
                AlbumActivity.this.fCB.sh(AlbumActivity.this.bPk);
            }
        }
    }

    private boolean bjI() {
        return 2 == this.fCD || 3 == this.fCD || 1 == this.fCD || 3 == this.fCD || "frs".equals(this.from) || "pb".equals(this.from) || "from_writeActivity_livePhoto".equals(this.from);
    }

    private void bjJ() {
        if (this.fCH == null) {
            this.fCH = new a(LayoutInflater.from(getActivity()).inflate(u.h.dialog_img_water_setting, (ViewGroup) null));
        }
        this.fCG = new AlertDialog.Builder(getActivity()).create();
        this.fCG.show();
        Window window = this.fCG.getWindow();
        WindowManager.LayoutParams attributes = window.getAttributes();
        attributes.dimAmount = 0.5f;
        attributes.width = -2;
        attributes.height = -2;
        attributes.y = 0 - (com.baidu.adp.lib.util.k.B(getActivity()) / 5);
        window.setAttributes(attributes);
        window.setContentView(this.fCH.getView());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.adp.base.BdBaseFragmentActivity, android.support.v4.app.FragmentActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        if (this.fCG != null) {
            com.baidu.adp.lib.h.h.dM().postDelayed(new com.baidu.tieba.write.album.a(this), 3000L);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.adp.base.BdBaseFragmentActivity, android.support.v4.app.FragmentActivity, android.app.Activity
    public void onPause() {
        super.onPause();
        if (this.fCG != null) {
            this.fCG.dismiss();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.support.v4.app.FragmentActivity, android.app.Activity
    public void onSaveInstanceState(Bundle bundle) {
        bundle.putString(AlbumActivityConfig.WRITE_IMAGES_INFO, this.fCA.getWriteImagesInfo().toJsonString());
        bundle.putBoolean(AlbumActivityConfig.USE_ORIGINAL_IMG, this.fCI);
    }

    private void initData(Bundle bundle) {
        this.fCA = new o(this);
        if (bundle != null) {
            WriteImagesInfo writeImagesInfo = new WriteImagesInfo();
            writeImagesInfo.parseJson(bundle.getString(AlbumActivityConfig.WRITE_IMAGES_INFO));
            this.fCA.setWriteImagesInfo(writeImagesInfo);
            this.fCA.qM(bundle.getString(AlbumActivityConfig.CAMERA_PHOTO_NAME));
            this.fCI = bundle.getBoolean(AlbumActivityConfig.USE_ORIGINAL_IMG, false);
            return;
        }
        Intent intent = getIntent();
        if (intent != null) {
            WriteImagesInfo writeImagesInfo2 = new WriteImagesInfo();
            writeImagesInfo2.parseJson(intent.getStringExtra(AlbumActivityConfig.WRITE_IMAGES_INFO));
            this.fCA.setWriteImagesInfo(writeImagesInfo2);
            this.fCA.qM(intent.getStringExtra(AlbumActivityConfig.CAMERA_PHOTO_NAME));
            this.fCD = intent.getIntExtra(AlbumActivityConfig.CAMERA_REQUEST_FROM, 0);
            this.from = intent.getStringExtra("from");
            this.fid = intent.getStringExtra("forum_id");
            if ("from_writeActivity_livePhoto".equals(this.from)) {
                this.fCF = true;
            } else {
                this.fCF = false;
            }
            if (this.fCD == 2) {
                this.fCE = new b(this);
            }
            this.fCA.lc(intent.getBooleanExtra(AlbumActivityConfig.AUTO_PHOTO_NAME, false));
            this.fCI = intent.getBooleanExtra(AlbumActivityConfig.USE_ORIGINAL_IMG, false);
        }
    }

    private void initView() {
        this.fCB = new t(this);
        this.fCB.bkh();
    }

    private void bjK() {
        if (this.fCB != null && this.fCA != null) {
            this.fCB.se(this.fCA.getMaxImagesAllowed());
            if (this.fCA.bka() != null) {
                for (ImageFileInfo imageFileInfo : this.fCA.bka()) {
                    this.fCB.h(imageFileInfo);
                }
            }
            bjS();
        }
    }

    private void bjL() {
        int size = this.fCA.size();
        this.fCB.p(size != 0, getPageContext().getPageActivity().getString(this.fCF ? u.j.live_album_finish_btn : u.j.album_finish_btn, new Object[]{Integer.valueOf(size)}));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragmentActivity
    public void onChangeSkinType(int i) {
        this.fCB.onChangeSkinType(i);
        if (this.fCH != null) {
            this.fCH.onChangeSkinType(i);
        }
    }

    private void bjM() {
        if (this.fCD == 3) {
            TiebaStatic.log("c10489");
        }
        Intent intent = new Intent();
        intent.putExtra(AlbumActivityConfig.ALBUM_RESULT, this.fCA.getWriteImagesInfo().toJsonString());
        intent.putExtra(AlbumActivityConfig.CAMERA_REQUEST_FROM, this.fCD);
        setResult(-1, intent);
        finish();
    }

    @Override // com.baidu.adp.base.BdBaseFragmentActivity, android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.fCB.bki()) {
            bjM();
        } else if (view == this.fCB.bkj()) {
            if (this.fCA != null) {
                this.fCA.setLastAlbumId(null);
            }
            bjR();
        } else if (view == this.fCB.bkk()) {
            rZ(0);
        } else if (view == this.fCB.bkl()) {
            bjN();
        }
    }

    private void bjN() {
        if (this.fCB != null && this.fCA != null) {
            this.fCA.setOriginalImg(!this.fCA.isOriginalImg());
            if (this.fCA.isOriginalImg()) {
                if (!StringUtils.isNull(this.from, true) && !StringUtils.isNull(this.fid, true)) {
                    TiebaStatic.log(new ay("c10349").ab("fid", this.fid).ab("obj_type", this.from));
                }
                bjT();
                return;
            }
            this.fCB.a(false, 0L);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public o bjO() {
        return this.fCA;
    }

    public com.baidu.tbadk.img.b afd() {
        return this.anf;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void rZ(int i) {
        P(i, true);
    }

    void P(int i, boolean z) {
        if (!this.fCC) {
            if (i == 0) {
                setSwipeBackEnabled(true);
                if (this.fCI) {
                    this.fCB.z(false, this.fCA.isOriginalImg());
                }
            } else {
                setSwipeBackEnabled(false);
                if (this.fCI) {
                    this.fCB.z(true, this.fCA.isOriginalImg());
                    bjT();
                }
            }
            FragmentTransaction beginTransaction = getSupportFragmentManager().beginTransaction();
            Fragment findFragmentByTag = getSupportFragmentManager().findFragmentByTag(this.fCB.sg(this.bPk));
            if (findFragmentByTag != null) {
                beginTransaction.hide(findFragmentByTag);
                if (z) {
                    this.anf.CW();
                }
            }
            this.bPk = i;
            if (this.fCB != null) {
                this.fCB.sh(this.bPk);
            }
            if (getSupportFragmentManager().findFragmentByTag(this.fCB.sg(i)) != null) {
                beginTransaction.show(this.fCB.sf(i));
            } else {
                beginTransaction.add(u.g.fragment, this.fCB.sf(i), this.fCB.sg(i));
            }
            beginTransaction.commitAllowingStateLoss();
            getSupportFragmentManager().executePendingTransactions();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean d(ImageFileInfo imageFileInfo) {
        if (imageFileInfo == null) {
            return false;
        }
        int maxImagesAllowed = this.fCA.getMaxImagesAllowed();
        if (this.fCA.size() < maxImagesAllowed) {
            if (this.fCE == null || this.fCE.f(imageFileInfo)) {
                ImageFileInfo imageFileInfo2 = new ImageFileInfo();
                imageFileInfo2.setAlbumnId(imageFileInfo.getAlbumId());
                imageFileInfo2.setFilePath(imageFileInfo.getFilePath());
                imageFileInfo2.setModifyTime(imageFileInfo.getModifyTime());
                this.fCA.addChooseFile(imageFileInfo2);
                bjL();
                bjS();
                this.fCB.h(imageFileInfo2);
                bjT();
                return true;
            }
            return false;
        } else if (bjP()) {
            return d(imageFileInfo);
        } else {
            showToast(String.format(getPageContext().getContext().getString(u.j.album_beyond_max_choose), Integer.valueOf(maxImagesAllowed)));
            return false;
        }
    }

    public boolean bjP() {
        if (getIntent().getBooleanExtra(AlbumActivityConfig.IS_SELECT_DIRECTLY, false)) {
            int maxImagesAllowed = this.fCA.getMaxImagesAllowed();
            if (this.fCA.size() == maxImagesAllowed && maxImagesAllowed == 1) {
                try {
                    ImageFileInfo imageFileInfo = this.fCA.getWriteImagesInfo().getChosedFiles().get(0);
                    if (e(imageFileInfo)) {
                        e(imageFileInfo, false);
                        f(imageFileInfo, false);
                        return true;
                    }
                } catch (Exception e) {
                }
            }
            return false;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean e(ImageFileInfo imageFileInfo) {
        if (imageFileInfo == null) {
            return false;
        }
        this.fCA.delChooseFile(imageFileInfo);
        bjL();
        bjS();
        this.fCB.i(imageFileInfo);
        bjT();
        return true;
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity, android.support.v4.app.FragmentActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i == 4) {
            if (this.bPk == 0) {
                if (this.fCA != null) {
                    this.fCA.setLastAlbumId(null);
                }
                bjR();
                return true;
            } else if (this.bPk == 1) {
                rZ(0);
                return true;
            } else {
                return true;
            }
        }
        return super.onKeyDown(i, keyEvent);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void Q(int i, boolean z) {
        Fragment sf;
        if (this.fCB != null && (sf = this.fCB.sf(0)) != null && (sf instanceof ag)) {
            ((ag) sf).R(i, z);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void e(ImageFileInfo imageFileInfo, boolean z) {
        Fragment sf;
        if (this.fCB != null && (sf = this.fCB.sf(0)) != null && (sf instanceof ag)) {
            ((ag) sf).g(imageFileInfo, z);
        }
    }

    private void bjQ() {
        Fragment sf;
        if (this.fCB != null && (sf = this.fCB.sf(0)) != null && (sf instanceof ag)) {
            ((ag) sf).refresh();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void f(ImageFileInfo imageFileInfo, boolean z) {
        Fragment sf;
        if (this.fCB != null && (sf = this.fCB.sf(1)) != null && (sf instanceof e)) {
            ((e) sf).g(imageFileInfo, z);
        }
    }

    private void bjR() {
        Intent intent = new Intent();
        String lastAlbumId = this.fCA.getLastAlbumId();
        if (TextUtils.isEmpty(lastAlbumId)) {
            lastAlbumId = "";
        }
        intent.putExtra(AlbumActivityConfig.LAST_ALBUM_ID, lastAlbumId);
        intent.putExtra(AlbumActivityConfig.CAMERA_REQUEST_FROM, this.fCD);
        setResult(0, intent);
        finish();
    }

    private void bjS() {
        if (this.fCA != null && this.fCB != null) {
            if (this.fCA.size() == this.fCA.getMaxImagesAllowed()) {
                this.fCB.lf(false);
            } else {
                this.fCB.lf(true);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.support.v4.app.FragmentActivity, android.app.Activity
    public void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (i2 == -1 && i == 12001) {
            qI(this.fCA.bke());
            P(1, false);
        }
    }

    private void qI(String str) {
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
                    Bitmap loadResizedBitmap = BitmapHelper.loadResizedBitmap(str2, com.baidu.adp.lib.util.k.dip2px(getPageContext().getPageActivity(), com.baidu.adp.lib.util.k.A(getPageContext().getPageActivity())), com.baidu.adp.lib.util.k.dip2px(getPageContext().getPageActivity(), com.baidu.adp.lib.util.k.B(getPageContext().getPageActivity())));
                    Bitmap rotateBitmapBydegree = BitmapHelper.rotateBitmapBydegree(loadResizedBitmap, readPictureDegree);
                    if (loadResizedBitmap != rotateBitmapBydegree) {
                        loadResizedBitmap.recycle();
                    }
                    if (z) {
                        com.baidu.tbadk.core.util.m.a(null, str, rotateBitmapBydegree, 100);
                    } else {
                        com.baidu.tbadk.core.util.m.a(TbConfig.LOCAL_CAMERA_DIR, str, rotateBitmapBydegree, 100);
                    }
                    rotateBitmapBydegree.recycle();
                }
            } catch (Exception e) {
            }
            ImageFileInfo imageFileInfo = new ImageFileInfo();
            imageFileInfo.setFilePath(str2);
            imageFileInfo.setTempFile(true);
            if (this.fCA.bkc() != null && this.fCA.bkc().size() > 0) {
                this.fCA.bkc().add(1, imageFileInfo);
                d(imageFileInfo);
                this.fCA.rX(this.fCA.bkc().indexOf(imageFileInfo));
                bjQ();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.adp.base.BdBaseFragmentActivity, android.support.v4.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        this.fCC = true;
        if (this.fCB != null) {
            this.fCB.onDestroy();
        }
        this.anf.CW();
        p.bkg().destory();
    }

    public void bjT() {
        if (this.fCB != null && this.fCA != null && this.fCA.bka() != null && this.fCA.isOriginalImg()) {
            long j = 0;
            for (ImageFileInfo imageFileInfo : this.fCA.bka()) {
                if (imageFileInfo != null) {
                    j += com.baidu.tbadk.core.util.m.db(imageFileInfo.getFilePath());
                }
            }
            this.fCB.a(true, j);
        }
    }

    public void qJ(String str) {
        this.fCJ = str;
        if (!com.baidu.tbadk.core.util.ag.c(getPageContext().getPageActivity(), 1)) {
            if (StringUtils.isNull(this.fCJ)) {
                au.c(getPageContext());
            } else {
                au.b(getPageContext(), this.fCJ);
            }
        }
    }

    @Override // android.app.Activity, com.baidu.a.a.a.InterfaceC0000a
    public void onRequestPermissionsResult(int i, String[] strArr, int[] iArr) {
        if (i == 1) {
            if (com.baidu.tbadk.core.util.ag.Q(getApplicationContext())) {
                if (StringUtils.isNull(this.fCJ)) {
                    au.c(getPageContext());
                } else {
                    au.b(getPageContext(), this.fCJ);
                }
            } else {
                showToast(u.j.system_permission_prompt_camera);
            }
            ArrayMap<String, Boolean> a2 = com.baidu.tbadk.core.util.ag.a(strArr, iArr);
            if (a2.containsKey("android.permission.WRITE_EXTERNAL_STORAGE") && !a2.get("android.permission.WRITE_EXTERNAL_STORAGE").booleanValue()) {
                showToast(u.j.sdcard_permission_denied_advert_for_camera);
            }
        }
    }
}
