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
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.widget.ListView.y;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tbadk.core.atomData.AlbumActivityConfig;
import com.baidu.tbadk.core.util.BitmapHelper;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.as;
import com.baidu.tbadk.core.util.at;
import com.baidu.tbadk.core.util.av;
import com.baidu.tbadk.img.ImageFileInfo;
import com.baidu.tbadk.img.WriteImagesInfo;
import com.baidu.tieba.r;
/* loaded from: classes.dex */
public class AlbumActivity extends BaseFragmentActivity implements View.OnClickListener, a.InterfaceC0000a {
    private com.baidu.tbadk.img.b arF;
    private o gjE;
    private t gjF;
    private y gjI;
    private int cfF = 0;
    private boolean gjG = false;
    private int gjH = 0;
    private String from = "";
    private String fid = "";
    private boolean gjJ = false;
    private AlertDialog gjK = null;
    private a gjL = null;
    private boolean gjM = false;
    private String gjN = "";

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.adp.base.BdBaseFragmentActivity, android.support.v4.app.FragmentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.arF = new com.baidu.tbadk.img.b();
        initView();
        initData(bundle);
        bux();
        tE(0);
        buy();
        boolean z = com.baidu.tbadk.core.sharedPref.b.um().getBoolean("add_img_water_tip_show", true);
        if (!(com.baidu.tbadk.core.l.oJ().oN() != 0) && z && buv()) {
            buw();
            com.baidu.tbadk.core.sharedPref.b.um().putBoolean("add_img_water_tip_show", false);
        }
    }

    /* loaded from: classes.dex */
    public class a extends y.a {
        public int aiA;
        private TextView btu;
        private TextView gjP;
        private TextView gjQ;

        public a(View view) {
            super(view);
            this.aiA = 3;
            this.btu = (TextView) view.findViewById(r.g.img_water_setting_title);
            this.gjP = (TextView) view.findViewById(r.g.img_water_setting_content);
            this.gjQ = (TextView) view.findViewById(r.g.goto_setting);
            this.gjQ.setOnClickListener(new c(this));
            buH();
        }

        private void buH() {
            at.c(this.btu, r.d.cp_cont_g, 1);
            at.c(this.gjP, r.d.cp_cont_g, 1);
            at.c(this.gjQ, r.d.cp_link_tip_a, 1);
        }

        public void onChangeSkinType(int i) {
            if (this.aiA != i) {
                buH();
                this.aiA = i;
            }
            if (AlbumActivity.this.gjF != null) {
                AlbumActivity.this.gjF.tM(AlbumActivity.this.cfF);
            }
        }
    }

    private boolean buv() {
        return 2 == this.gjH || 3 == this.gjH || 1 == this.gjH || 3 == this.gjH || "frs".equals(this.from) || "pb".equals(this.from) || "from_writeActivity_livePhoto".equals(this.from);
    }

    private void buw() {
        if (this.gjL == null) {
            this.gjL = new a(LayoutInflater.from(getActivity()).inflate(r.h.dialog_img_water_setting, (ViewGroup) null));
        }
        this.gjK = new AlertDialog.Builder(getActivity()).create();
        this.gjK.show();
        Window window = this.gjK.getWindow();
        WindowManager.LayoutParams attributes = window.getAttributes();
        attributes.dimAmount = 0.5f;
        attributes.width = -2;
        attributes.height = -2;
        attributes.y = 0 - (com.baidu.adp.lib.util.k.L(getActivity()) / 5);
        window.setAttributes(attributes);
        window.setContentView(this.gjL.getView());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.adp.base.BdBaseFragmentActivity, android.support.v4.app.FragmentActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        if (this.gjK != null) {
            com.baidu.adp.lib.h.h.eG().postDelayed(new com.baidu.tieba.write.album.a(this), 3000L);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.adp.base.BdBaseFragmentActivity, android.support.v4.app.FragmentActivity, android.app.Activity
    public void onPause() {
        super.onPause();
        if (this.gjK != null) {
            this.gjK.dismiss();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.support.v4.app.FragmentActivity, android.app.Activity
    public void onSaveInstanceState(Bundle bundle) {
        bundle.putString(AlbumActivityConfig.WRITE_IMAGES_INFO, this.gjE.getWriteImagesInfo().toJsonString());
        bundle.putBoolean(AlbumActivityConfig.USE_ORIGINAL_IMG, this.gjM);
    }

    private void initData(Bundle bundle) {
        this.gjE = new o(this);
        if (bundle != null) {
            WriteImagesInfo writeImagesInfo = new WriteImagesInfo();
            writeImagesInfo.parseJson(bundle.getString(AlbumActivityConfig.WRITE_IMAGES_INFO));
            this.gjE.setWriteImagesInfo(writeImagesInfo);
            this.gjE.sS(bundle.getString(AlbumActivityConfig.CAMERA_PHOTO_NAME));
            this.gjM = bundle.getBoolean(AlbumActivityConfig.USE_ORIGINAL_IMG, false);
            return;
        }
        Intent intent = getIntent();
        if (intent != null) {
            WriteImagesInfo writeImagesInfo2 = new WriteImagesInfo();
            writeImagesInfo2.parseJson(intent.getStringExtra(AlbumActivityConfig.WRITE_IMAGES_INFO));
            this.gjE.setWriteImagesInfo(writeImagesInfo2);
            this.gjE.sS(intent.getStringExtra(AlbumActivityConfig.CAMERA_PHOTO_NAME));
            this.gjH = intent.getIntExtra(AlbumActivityConfig.CAMERA_REQUEST_FROM, 0);
            this.from = intent.getStringExtra("from");
            this.fid = intent.getStringExtra("forum_id");
            if ("from_writeActivity_livePhoto".equals(this.from)) {
                this.gjJ = true;
            } else {
                this.gjJ = false;
            }
            if (this.gjH == 2) {
                this.gjI = new com.baidu.tieba.write.album.b(this);
            }
            this.gjE.mi(intent.getBooleanExtra(AlbumActivityConfig.AUTO_PHOTO_NAME, false));
            this.gjM = intent.getBooleanExtra(AlbumActivityConfig.USE_ORIGINAL_IMG, false);
        }
    }

    private void initView() {
        this.gjF = new t(this);
        this.gjF.buU();
    }

    private void bux() {
        if (this.gjF != null && this.gjE != null) {
            this.gjF.tJ(this.gjE.getMaxImagesAllowed());
            if (this.gjE.buN() != null) {
                for (ImageFileInfo imageFileInfo : this.gjE.buN()) {
                    this.gjF.h(imageFileInfo);
                }
            }
            buF();
        }
    }

    private void buy() {
        String string;
        int size = this.gjE.size();
        boolean z = size != 0;
        if (this.gjH == 5) {
            string = getPageContext().getPageActivity().getString(r.j.album_upload_btn, new Object[]{Integer.valueOf(size)});
        } else if (this.gjJ) {
            string = getPageContext().getPageActivity().getString(r.j.live_album_finish_btn, new Object[]{Integer.valueOf(size)});
        } else {
            string = getPageContext().getPageActivity().getString(r.j.album_finish_btn, new Object[]{Integer.valueOf(size)});
        }
        this.gjF.o(z, string);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragmentActivity
    public void onChangeSkinType(int i) {
        this.gjF.onChangeSkinType(i);
        if (this.gjL != null) {
            this.gjL.onChangeSkinType(i);
        }
    }

    private void buz() {
        if (this.gjH == 3) {
            TiebaStatic.log("c10489");
        }
        if (this.gjH == 5) {
            showLoadingDialog("正在上传");
            new b(this, null).execute(new String[0]);
            return;
        }
        Intent intent = new Intent();
        intent.putExtra(AlbumActivityConfig.ALBUM_RESULT, this.gjE.getWriteImagesInfo().toJsonString());
        intent.putExtra(AlbumActivityConfig.CAMERA_REQUEST_FROM, this.gjH);
        setResult(-1, intent);
        finish();
    }

    @Override // com.baidu.adp.base.BdBaseFragmentActivity, android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.gjF.buV()) {
            buz();
        } else if (view == this.gjF.buW()) {
            if (this.gjE != null) {
                this.gjE.setLastAlbumId(null);
            }
            buE();
        } else if (view == this.gjF.buX()) {
            tE(0);
        } else if (view == this.gjF.buY()) {
            buA();
        }
    }

    private void buA() {
        if (this.gjF != null && this.gjE != null) {
            this.gjE.setOriginalImg(!this.gjE.isOriginalImg());
            if (this.gjE.isOriginalImg()) {
                if (!StringUtils.isNull(this.from, true) && !StringUtils.isNull(this.fid, true)) {
                    TiebaStatic.log(new av("c10349").ab("fid", this.fid).ab("obj_type", this.from));
                }
                buG();
                return;
            }
            this.gjF.a(false, 0L);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public o buB() {
        return this.gjE;
    }

    public com.baidu.tbadk.img.b amA() {
        return this.arF;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void tE(int i) {
        Y(i, true);
    }

    void Y(int i, boolean z) {
        if (!this.gjG) {
            if (i == 0) {
                setSwipeBackEnabled(true);
                if (this.gjM) {
                    this.gjF.G(false, this.gjE.isOriginalImg());
                }
            } else {
                setSwipeBackEnabled(false);
                if (this.gjM) {
                    this.gjF.G(true, this.gjE.isOriginalImg());
                    buG();
                }
            }
            FragmentTransaction beginTransaction = getSupportFragmentManager().beginTransaction();
            Fragment findFragmentByTag = getSupportFragmentManager().findFragmentByTag(this.gjF.tL(this.cfF));
            if (findFragmentByTag != null) {
                beginTransaction.hide(findFragmentByTag);
                if (z) {
                    this.arF.Ev();
                }
            }
            this.cfF = i;
            if (this.gjF != null) {
                this.gjF.tM(this.cfF);
            }
            if (getSupportFragmentManager().findFragmentByTag(this.gjF.tL(i)) != null) {
                beginTransaction.show(this.gjF.tK(i));
            } else {
                beginTransaction.add(r.g.fragment, this.gjF.tK(i), this.gjF.tL(i));
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
        int maxImagesAllowed = this.gjE.getMaxImagesAllowed();
        if (this.gjE.size() < maxImagesAllowed) {
            if (this.gjI == null || this.gjI.f(imageFileInfo)) {
                ImageFileInfo imageFileInfo2 = new ImageFileInfo();
                imageFileInfo2.setAlbumnId(imageFileInfo.getAlbumId());
                imageFileInfo2.setFilePath(imageFileInfo.getFilePath());
                imageFileInfo2.setModifyTime(imageFileInfo.getModifyTime());
                this.gjE.addChooseFile(imageFileInfo2);
                buy();
                buF();
                this.gjF.h(imageFileInfo2);
                buG();
                return true;
            }
            return false;
        } else if (buC()) {
            return d(imageFileInfo);
        } else {
            showToast(String.format(getPageContext().getContext().getString(r.j.album_beyond_max_choose), Integer.valueOf(maxImagesAllowed)));
            return false;
        }
    }

    public boolean buC() {
        if (getIntent().getBooleanExtra(AlbumActivityConfig.IS_SELECT_DIRECTLY, false)) {
            int maxImagesAllowed = this.gjE.getMaxImagesAllowed();
            if (this.gjE.size() == maxImagesAllowed && maxImagesAllowed == 1) {
                try {
                    ImageFileInfo imageFileInfo = this.gjE.getWriteImagesInfo().getChosedFiles().get(0);
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
        this.gjE.delChooseFile(imageFileInfo);
        buy();
        buF();
        this.gjF.i(imageFileInfo);
        buG();
        return true;
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity, android.support.v4.app.FragmentActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i == 4) {
            if (this.cfF == 0) {
                if (this.gjE != null) {
                    this.gjE.setLastAlbumId(null);
                }
                buE();
                return true;
            } else if (this.cfF == 1) {
                tE(0);
                return true;
            } else {
                return true;
            }
        }
        return super.onKeyDown(i, keyEvent);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void Z(int i, boolean z) {
        Fragment tK;
        if (this.gjF != null && (tK = this.gjF.tK(0)) != null && (tK instanceof ag)) {
            ((ag) tK).aa(i, z);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void e(ImageFileInfo imageFileInfo, boolean z) {
        Fragment tK;
        if (this.gjF != null && (tK = this.gjF.tK(0)) != null && (tK instanceof ag)) {
            ((ag) tK).g(imageFileInfo, z);
        }
    }

    private void buD() {
        Fragment tK;
        if (this.gjF != null && (tK = this.gjF.tK(0)) != null && (tK instanceof ag)) {
            ((ag) tK).refresh();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void f(ImageFileInfo imageFileInfo, boolean z) {
        Fragment tK;
        if (this.gjF != null && (tK = this.gjF.tK(1)) != null && (tK instanceof e)) {
            ((e) tK).g(imageFileInfo, z);
        }
    }

    private void buE() {
        Intent intent = new Intent();
        String lastAlbumId = this.gjE.getLastAlbumId();
        if (TextUtils.isEmpty(lastAlbumId)) {
            lastAlbumId = "";
        }
        intent.putExtra(AlbumActivityConfig.LAST_ALBUM_ID, lastAlbumId);
        intent.putExtra(AlbumActivityConfig.CAMERA_REQUEST_FROM, this.gjH);
        setResult(0, intent);
        finish();
    }

    private void buF() {
        if (this.gjE != null && this.gjF != null) {
            if (this.gjE.size() == this.gjE.getMaxImagesAllowed()) {
                this.gjF.ml(false);
            } else {
                this.gjF.ml(true);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.support.v4.app.FragmentActivity, android.app.Activity
    public void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (i2 == -1 && i == 12001) {
            sO(this.gjE.buR());
            Y(1, false);
        }
    }

    private void sO(String str) {
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
            if (this.gjE.buP() != null && this.gjE.buP().size() > 0) {
                this.gjE.buP().add(1, imageFileInfo);
                d(imageFileInfo);
                this.gjE.tD(this.gjE.buP().indexOf(imageFileInfo));
                buD();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.adp.base.BdBaseFragmentActivity, android.support.v4.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        this.gjG = true;
        if (this.gjF != null) {
            this.gjF.onDestroy();
        }
        this.arF.Ev();
        p.buT().destory();
    }

    public void buG() {
        if (this.gjF != null && this.gjE != null && this.gjE.buN() != null && this.gjE.isOriginalImg()) {
            long j = 0;
            for (ImageFileInfo imageFileInfo : this.gjE.buN()) {
                if (imageFileInfo != null) {
                    j += com.baidu.tbadk.core.util.m.getFileSize(imageFileInfo.getFilePath());
                }
            }
            this.gjF.a(true, j);
        }
    }

    public void sP(String str) {
        this.gjN = str;
        if (!com.baidu.tbadk.core.util.ae.d(getPageContext().getPageActivity(), 1)) {
            if (StringUtils.isNull(this.gjN)) {
                as.c(getPageContext());
            } else {
                as.b(getPageContext(), this.gjN);
            }
        }
    }

    @Override // android.app.Activity, com.baidu.a.a.a.InterfaceC0000a
    public void onRequestPermissionsResult(int i, String[] strArr, int[] iArr) {
        if (i == 1) {
            if (com.baidu.tbadk.core.util.ae.aa(getApplicationContext())) {
                if (StringUtils.isNull(this.gjN)) {
                    as.c(getPageContext());
                } else {
                    as.b(getPageContext(), this.gjN);
                }
            } else {
                showToast(r.j.system_permission_prompt_camera);
            }
            ArrayMap<String, Boolean> a2 = com.baidu.tbadk.core.util.ae.a(strArr, iArr);
            if (a2.containsKey("android.permission.WRITE_EXTERNAL_STORAGE") && !a2.get("android.permission.WRITE_EXTERNAL_STORAGE").booleanValue()) {
                showToast(r.j.sdcard_permission_denied_advert_for_camera);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class b extends BdAsyncTask<String, Integer, String> {
        private b() {
        }

        /* synthetic */ b(AlbumActivity albumActivity, b bVar) {
            this();
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: i */
        public String doInBackground(String... strArr) {
            new com.baidu.tbadk.img.c(null).c(AlbumActivity.this.gjE.getWriteImagesInfo(), true);
            return AlbumActivity.this.gjE.getWriteImagesInfo().toJsonString();
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: ez */
        public void onPostExecute(String str) {
            Intent intent = new Intent();
            intent.putExtra(AlbumActivityConfig.ALBUM_RESULT, str);
            AlbumActivity.this.setResult(-1, intent);
            AlbumActivity.this.finish();
        }
    }
}
