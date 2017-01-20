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
import com.baidu.tbadk.core.util.ar;
import com.baidu.tbadk.img.ImageFileInfo;
import com.baidu.tbadk.img.WriteImagesInfo;
import com.baidu.tieba.r;
/* loaded from: classes.dex */
public class AlbumActivity extends BaseFragmentActivity implements View.OnClickListener, a.InterfaceC0000a {
    private com.baidu.tbadk.img.b aqo;
    private o fGE;
    private t fGF;
    private y fGI;
    private int mCurrentPage = 0;
    private boolean fGG = false;
    private int fGH = 0;
    private String from = "";
    private String fid = "";
    private boolean fGJ = false;
    private AlertDialog fGK = null;
    private a fGL = null;
    private boolean fGM = false;
    private String aWU = "";

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.adp.base.BdBaseFragmentActivity, android.support.v4.app.FragmentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.aqo = new com.baidu.tbadk.img.b();
        initView();
        initData(bundle);
        bmM();
        sO(0);
        bmN();
        boolean z = com.baidu.tbadk.core.sharedPref.b.tQ().getBoolean("add_img_water_tip_show", true);
        if (!(com.baidu.tbadk.core.l.oC().oG() != 0) && z && bmK()) {
            bmL();
            com.baidu.tbadk.core.sharedPref.b.tQ().putBoolean("add_img_water_tip_show", false);
        }
    }

    /* loaded from: classes.dex */
    public class a extends y.a {
        public int ahp;
        private TextView bYK;
        private TextView fGO;
        private TextView fGP;

        public a(View view) {
            super(view);
            this.ahp = 3;
            this.bYK = (TextView) view.findViewById(r.h.img_water_setting_title);
            this.fGO = (TextView) view.findViewById(r.h.img_water_setting_content);
            this.fGP = (TextView) view.findViewById(r.h.goto_setting);
            this.fGP.setOnClickListener(new c(this));
            bmW();
        }

        private void bmW() {
            com.baidu.tbadk.core.util.ap.c(this.bYK, r.e.cp_cont_g, 1);
            com.baidu.tbadk.core.util.ap.c(this.fGO, r.e.cp_cont_g, 1);
            com.baidu.tbadk.core.util.ap.c(this.fGP, r.e.cp_link_tip_a, 1);
        }

        public void onChangeSkinType(int i) {
            if (this.ahp != i) {
                bmW();
                this.ahp = i;
            }
            if (AlbumActivity.this.fGF != null) {
                AlbumActivity.this.fGF.sW(AlbumActivity.this.mCurrentPage);
            }
        }
    }

    private boolean bmK() {
        return 2 == this.fGH || 3 == this.fGH || 1 == this.fGH || 3 == this.fGH || "frs".equals(this.from) || "pb".equals(this.from) || "from_writeActivity_livePhoto".equals(this.from);
    }

    private void bmL() {
        if (this.fGL == null) {
            this.fGL = new a(LayoutInflater.from(getActivity()).inflate(r.j.dialog_img_water_setting, (ViewGroup) null));
        }
        this.fGK = new AlertDialog.Builder(getActivity()).create();
        this.fGK.show();
        Window window = this.fGK.getWindow();
        WindowManager.LayoutParams attributes = window.getAttributes();
        attributes.dimAmount = 0.5f;
        attributes.width = -2;
        attributes.height = -2;
        attributes.y = 0 - (com.baidu.adp.lib.util.k.J(getActivity()) / 5);
        window.setAttributes(attributes);
        window.setContentView(this.fGL.getView());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.adp.base.BdBaseFragmentActivity, android.support.v4.app.FragmentActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        if (this.fGK != null) {
            com.baidu.adp.lib.g.h.eE().postDelayed(new com.baidu.tieba.write.album.a(this), 3000L);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.adp.base.BdBaseFragmentActivity, android.support.v4.app.FragmentActivity, android.app.Activity
    public void onPause() {
        super.onPause();
        if (this.fGK != null) {
            this.fGK.dismiss();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.support.v4.app.FragmentActivity, android.app.Activity
    public void onSaveInstanceState(Bundle bundle) {
        bundle.putString(AlbumActivityConfig.WRITE_IMAGES_INFO, this.fGE.getWriteImagesInfo().toJsonString());
        bundle.putBoolean(AlbumActivityConfig.USE_ORIGINAL_IMG, this.fGM);
    }

    private void initData(Bundle bundle) {
        this.fGE = new o(this);
        if (bundle != null) {
            WriteImagesInfo writeImagesInfo = new WriteImagesInfo();
            writeImagesInfo.parseJson(bundle.getString(AlbumActivityConfig.WRITE_IMAGES_INFO));
            this.fGE.setWriteImagesInfo(writeImagesInfo);
            this.fGE.ry(bundle.getString(AlbumActivityConfig.CAMERA_PHOTO_NAME));
            this.fGM = bundle.getBoolean(AlbumActivityConfig.USE_ORIGINAL_IMG, false);
            return;
        }
        Intent intent = getIntent();
        if (intent != null) {
            WriteImagesInfo writeImagesInfo2 = new WriteImagesInfo();
            writeImagesInfo2.parseJson(intent.getStringExtra(AlbumActivityConfig.WRITE_IMAGES_INFO));
            this.fGE.setWriteImagesInfo(writeImagesInfo2);
            this.fGE.ry(intent.getStringExtra(AlbumActivityConfig.CAMERA_PHOTO_NAME));
            this.fGH = intent.getIntExtra(AlbumActivityConfig.CAMERA_REQUEST_FROM, 0);
            this.from = intent.getStringExtra("from");
            this.fid = intent.getStringExtra("forum_id");
            if ("from_writeActivity_livePhoto".equals(this.from)) {
                this.fGJ = true;
            } else {
                this.fGJ = false;
            }
            if (this.fGH == 2) {
                this.fGI = new com.baidu.tieba.write.album.b(this);
            }
            this.fGE.lG(intent.getBooleanExtra(AlbumActivityConfig.AUTO_PHOTO_NAME, false));
            this.fGM = intent.getBooleanExtra(AlbumActivityConfig.USE_ORIGINAL_IMG, false);
        }
    }

    private void initView() {
        this.fGF = new t(this);
        this.fGF.bnn();
    }

    private void bmM() {
        if (this.fGF != null && this.fGE != null) {
            this.fGF.sT(this.fGE.getMaxImagesAllowed());
            if (this.fGE.bnf() != null) {
                for (ImageFileInfo imageFileInfo : this.fGE.bnf()) {
                    this.fGF.g(imageFileInfo);
                }
            }
            bmU();
        }
    }

    private void bmN() {
        String string;
        int size = this.fGE.size();
        boolean z = size != 0;
        if (this.fGH == 5) {
            string = getPageContext().getPageActivity().getString(r.l.album_upload_btn, new Object[]{Integer.valueOf(size)});
        } else if (this.fGJ) {
            string = getPageContext().getPageActivity().getString(r.l.live_album_finish_btn, new Object[]{Integer.valueOf(size)});
        } else {
            string = getPageContext().getPageActivity().getString(r.l.album_finish_btn, new Object[]{Integer.valueOf(size)});
        }
        this.fGF.o(z, string);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragmentActivity
    public void onChangeSkinType(int i) {
        this.fGF.onChangeSkinType(i);
        if (this.fGL != null) {
            this.fGL.onChangeSkinType(i);
        }
    }

    private void bmO() {
        if (this.fGH == 3) {
            TiebaStatic.log("c10489");
        }
        if (this.fGH == 5) {
            showLoadingDialog("正在上传");
            new b(this, null).execute(new String[0]);
            return;
        }
        Intent intent = new Intent();
        intent.putExtra(AlbumActivityConfig.ALBUM_RESULT, this.fGE.getWriteImagesInfo().toJsonString());
        intent.putExtra(AlbumActivityConfig.CAMERA_REQUEST_FROM, this.fGH);
        setResult(-1, intent);
        finish();
    }

    @Override // com.baidu.adp.base.BdBaseFragmentActivity, android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.fGF.bno()) {
            bmO();
        } else if (view == this.fGF.bnp()) {
            if (this.fGE != null) {
                this.fGE.setLastAlbumId(null);
            }
            bmT();
        } else if (view == this.fGF.bnq()) {
            sO(0);
        } else if (view == this.fGF.bnr()) {
            bmP();
        }
    }

    private void bmP() {
        if (this.fGF != null && this.fGE != null) {
            this.fGE.setOriginalImg(!this.fGE.isOriginalImg());
            if (this.fGE.isOriginalImg()) {
                if (!StringUtils.isNull(this.from, true) && !StringUtils.isNull(this.fid, true)) {
                    TiebaStatic.log(new ar("c10349").ab("fid", this.fid).ab("obj_type", this.from));
                }
                bmV();
                return;
            }
            this.fGF.a(false, 0L);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public o bmQ() {
        return this.fGE;
    }

    public com.baidu.tbadk.img.b aii() {
        return this.aqo;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void sO(int i) {
        I(i, true);
    }

    void I(int i, boolean z) {
        if (!this.fGG) {
            if (i == 0) {
                setSwipeBackEnabled(true);
                if (this.fGM) {
                    this.fGF.F(false, this.fGE.isOriginalImg());
                }
            } else {
                setSwipeBackEnabled(false);
                if (this.fGM) {
                    this.fGF.F(true, this.fGE.isOriginalImg());
                    bmV();
                }
            }
            FragmentTransaction beginTransaction = getSupportFragmentManager().beginTransaction();
            Fragment findFragmentByTag = getSupportFragmentManager().findFragmentByTag(this.fGF.sV(this.mCurrentPage));
            if (findFragmentByTag != null) {
                beginTransaction.hide(findFragmentByTag);
                if (z) {
                    this.aqo.DY();
                }
            }
            this.mCurrentPage = i;
            if (this.fGF != null) {
                this.fGF.sW(this.mCurrentPage);
            }
            if (getSupportFragmentManager().findFragmentByTag(this.fGF.sV(i)) != null) {
                beginTransaction.show(this.fGF.sU(i));
            } else {
                beginTransaction.add(r.h.fragment, this.fGF.sU(i), this.fGF.sV(i));
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
        int maxImagesAllowed = this.fGE.getMaxImagesAllowed();
        if (this.fGE.size() < maxImagesAllowed) {
            if (this.fGI == null || this.fGI.e(imageFileInfo)) {
                ImageFileInfo imageFileInfo2 = new ImageFileInfo();
                imageFileInfo2.setAlbumnId(imageFileInfo.getAlbumId());
                imageFileInfo2.setFilePath(imageFileInfo.getFilePath());
                imageFileInfo2.setModifyTime(imageFileInfo.getModifyTime());
                this.fGE.addChooseFile(imageFileInfo2);
                bmN();
                bmU();
                this.fGF.g(imageFileInfo2);
                bmV();
                return true;
            }
            return false;
        } else if (bmR()) {
            return c(imageFileInfo);
        } else {
            showToast(String.format(getPageContext().getContext().getString(r.l.album_beyond_max_choose), Integer.valueOf(maxImagesAllowed)));
            return false;
        }
    }

    public boolean bmR() {
        if (getIntent().getBooleanExtra(AlbumActivityConfig.IS_SELECT_DIRECTLY, false)) {
            int maxImagesAllowed = this.fGE.getMaxImagesAllowed();
            if (this.fGE.size() == maxImagesAllowed && maxImagesAllowed == 1) {
                try {
                    ImageFileInfo imageFileInfo = this.fGE.getWriteImagesInfo().getChosedFiles().get(0);
                    if (d(imageFileInfo)) {
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
    public boolean d(ImageFileInfo imageFileInfo) {
        if (imageFileInfo == null) {
            return false;
        }
        this.fGE.delChooseFile(imageFileInfo);
        bmN();
        bmU();
        this.fGF.h(imageFileInfo);
        bmV();
        return true;
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity, android.support.v4.app.FragmentActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i == 4) {
            if (this.mCurrentPage == 0) {
                if (this.fGE != null) {
                    this.fGE.setLastAlbumId(null);
                }
                bmT();
                return true;
            } else if (this.mCurrentPage == 1) {
                sO(0);
                return true;
            } else {
                return true;
            }
        }
        return super.onKeyDown(i, keyEvent);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void J(int i, boolean z) {
        Fragment sU;
        if (this.fGF != null && (sU = this.fGF.sU(0)) != null && (sU instanceof ag)) {
            ((ag) sU).K(i, z);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void e(ImageFileInfo imageFileInfo, boolean z) {
        Fragment sU;
        if (this.fGF != null && (sU = this.fGF.sU(0)) != null && (sU instanceof ag)) {
            ((ag) sU).g(imageFileInfo, z);
        }
    }

    private void bmS() {
        Fragment sU;
        if (this.fGF != null && (sU = this.fGF.sU(0)) != null && (sU instanceof ag)) {
            ((ag) sU).refresh();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void f(ImageFileInfo imageFileInfo, boolean z) {
        Fragment sU;
        if (this.fGF != null && (sU = this.fGF.sU(1)) != null && (sU instanceof e)) {
            ((e) sU).g(imageFileInfo, z);
        }
    }

    private void bmT() {
        Intent intent = new Intent();
        String lastAlbumId = this.fGE.getLastAlbumId();
        if (TextUtils.isEmpty(lastAlbumId)) {
            lastAlbumId = "";
        }
        intent.putExtra(AlbumActivityConfig.LAST_ALBUM_ID, lastAlbumId);
        intent.putExtra(AlbumActivityConfig.CAMERA_REQUEST_FROM, this.fGH);
        setResult(0, intent);
        finish();
    }

    private void bmU() {
        if (this.fGE != null && this.fGF != null) {
            if (this.fGE.size() == this.fGE.getMaxImagesAllowed()) {
                this.fGF.lJ(false);
            } else {
                this.fGF.lJ(true);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.support.v4.app.FragmentActivity, android.app.Activity
    public void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (i2 == -1 && i == 12001) {
            rt(this.fGE.bnk());
            I(1, false);
        }
    }

    private void rt(String str) {
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
                    Bitmap loadResizedBitmap = BitmapHelper.loadResizedBitmap(str2, com.baidu.adp.lib.util.k.dip2px(getPageContext().getPageActivity(), com.baidu.adp.lib.util.k.I(getPageContext().getPageActivity())), com.baidu.adp.lib.util.k.dip2px(getPageContext().getPageActivity(), com.baidu.adp.lib.util.k.J(getPageContext().getPageActivity())));
                    Bitmap rotateBitmapBydegree = BitmapHelper.rotateBitmapBydegree(loadResizedBitmap, readPictureDegree);
                    if (loadResizedBitmap != rotateBitmapBydegree) {
                        loadResizedBitmap.recycle();
                    }
                    if (z) {
                        com.baidu.tbadk.core.util.l.a(null, str, rotateBitmapBydegree, 100);
                    } else {
                        com.baidu.tbadk.core.util.l.a(TbConfig.LOCAL_CAMERA_DIR, str, rotateBitmapBydegree, 100);
                    }
                    rotateBitmapBydegree.recycle();
                }
            } catch (Exception e) {
            }
            ImageFileInfo imageFileInfo = new ImageFileInfo();
            imageFileInfo.setFilePath(str2);
            imageFileInfo.setTempFile(true);
            if (this.fGE.bnh() != null && this.fGE.bnh().size() > 0) {
                this.fGE.bnh().add(1, imageFileInfo);
                c(imageFileInfo);
                this.fGE.sN(this.fGE.bnh().indexOf(imageFileInfo));
                bmS();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.adp.base.BdBaseFragmentActivity, android.support.v4.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        this.fGG = true;
        if (this.fGF != null) {
            this.fGF.onDestroy();
        }
        this.aqo.DY();
        p.bnm().destory();
    }

    public void bmV() {
        if (this.fGF != null && this.fGE != null && this.fGE.bnf() != null && this.fGE.isOriginalImg()) {
            long j = 0;
            for (ImageFileInfo imageFileInfo : this.fGE.bnf()) {
                if (imageFileInfo != null) {
                    j += com.baidu.tbadk.core.util.l.getFileSize(imageFileInfo.getFilePath());
                }
            }
            this.fGF.a(true, j);
        }
    }

    public void hH(String str) {
        this.aWU = str;
        if (!com.baidu.tbadk.core.util.ad.d(getPageContext().getPageActivity(), 1)) {
            if (StringUtils.isNull(this.aWU)) {
                com.baidu.tbadk.core.util.ao.c(getPageContext());
            } else {
                com.baidu.tbadk.core.util.ao.b(getPageContext(), this.aWU);
            }
        }
    }

    @Override // android.app.Activity, com.baidu.a.a.a.InterfaceC0000a
    public void onRequestPermissionsResult(int i, String[] strArr, int[] iArr) {
        if (i == 1) {
            if (com.baidu.tbadk.core.util.ad.aa(getApplicationContext())) {
                if (StringUtils.isNull(this.aWU)) {
                    com.baidu.tbadk.core.util.ao.c(getPageContext());
                } else {
                    com.baidu.tbadk.core.util.ao.b(getPageContext(), this.aWU);
                }
            } else {
                showToast(r.l.system_permission_prompt_camera);
            }
            ArrayMap<String, Boolean> a2 = com.baidu.tbadk.core.util.ad.a(strArr, iArr);
            if (a2.containsKey("android.permission.WRITE_EXTERNAL_STORAGE") && !a2.get("android.permission.WRITE_EXTERNAL_STORAGE").booleanValue()) {
                showToast(r.l.sdcard_permission_denied_advert_for_camera);
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
            new com.baidu.tbadk.img.c(null).c(AlbumActivity.this.fGE.getWriteImagesInfo(), true);
            return AlbumActivity.this.fGE.getWriteImagesInfo().toJsonString();
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPostExecute(String str) {
            Intent intent = new Intent();
            intent.putExtra(AlbumActivityConfig.ALBUM_RESULT, str);
            AlbumActivity.this.setResult(-1, intent);
            AlbumActivity.this.finish();
        }
    }
}
