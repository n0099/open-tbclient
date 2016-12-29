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
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.core.util.ar;
import com.baidu.tbadk.core.util.at;
import com.baidu.tbadk.img.ImageFileInfo;
import com.baidu.tbadk.img.WriteImagesInfo;
import com.baidu.tieba.r;
/* loaded from: classes.dex */
public class AlbumActivity extends BaseFragmentActivity implements View.OnClickListener, a.InterfaceC0000a {
    private com.baidu.tbadk.img.b ari;
    private o fxZ;
    private t fya;
    private y fyd;
    private int bLo = 0;
    private boolean fyb = false;
    private int fyc = 0;
    private String from = "";
    private String fid = "";
    private boolean fye = false;
    private AlertDialog fyf = null;
    private a fyg = null;
    private boolean fyh = false;
    private String fyi = "";

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.adp.base.BdBaseFragmentActivity, android.support.v4.app.FragmentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.ari = new com.baidu.tbadk.img.b();
        initView();
        initData(bundle);
        blo();
        sd(0);
        blp();
        boolean z = com.baidu.tbadk.core.sharedPref.b.tW().getBoolean("add_img_water_tip_show", true);
        if (!(com.baidu.tbadk.core.l.oJ().oN() != 0) && z && blm()) {
            bln();
            com.baidu.tbadk.core.sharedPref.b.tW().putBoolean("add_img_water_tip_show", false);
        }
    }

    /* loaded from: classes.dex */
    public class a extends y.a {
        public int aib;
        private TextView bSn;
        private TextView fyk;
        private TextView fyl;

        public a(View view) {
            super(view);
            this.aib = 3;
            this.bSn = (TextView) view.findViewById(r.g.img_water_setting_title);
            this.fyk = (TextView) view.findViewById(r.g.img_water_setting_content);
            this.fyl = (TextView) view.findViewById(r.g.goto_setting);
            this.fyl.setOnClickListener(new c(this));
            bly();
        }

        private void bly() {
            ar.c(this.bSn, r.d.cp_cont_g, 1);
            ar.c(this.fyk, r.d.cp_cont_g, 1);
            ar.c(this.fyl, r.d.cp_link_tip_a, 1);
        }

        public void onChangeSkinType(int i) {
            if (this.aib != i) {
                bly();
                this.aib = i;
            }
            if (AlbumActivity.this.fya != null) {
                AlbumActivity.this.fya.sl(AlbumActivity.this.bLo);
            }
        }
    }

    private boolean blm() {
        return 2 == this.fyc || 3 == this.fyc || 1 == this.fyc || 3 == this.fyc || "frs".equals(this.from) || "pb".equals(this.from) || "from_writeActivity_livePhoto".equals(this.from);
    }

    private void bln() {
        if (this.fyg == null) {
            this.fyg = new a(LayoutInflater.from(getActivity()).inflate(r.h.dialog_img_water_setting, (ViewGroup) null));
        }
        this.fyf = new AlertDialog.Builder(getActivity()).create();
        this.fyf.show();
        Window window = this.fyf.getWindow();
        WindowManager.LayoutParams attributes = window.getAttributes();
        attributes.dimAmount = 0.5f;
        attributes.width = -2;
        attributes.height = -2;
        attributes.y = 0 - (com.baidu.adp.lib.util.k.J(getActivity()) / 5);
        window.setAttributes(attributes);
        window.setContentView(this.fyg.getView());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.adp.base.BdBaseFragmentActivity, android.support.v4.app.FragmentActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        if (this.fyf != null) {
            com.baidu.adp.lib.h.h.eG().postDelayed(new com.baidu.tieba.write.album.a(this), 3000L);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.adp.base.BdBaseFragmentActivity, android.support.v4.app.FragmentActivity, android.app.Activity
    public void onPause() {
        super.onPause();
        if (this.fyf != null) {
            this.fyf.dismiss();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.support.v4.app.FragmentActivity, android.app.Activity
    public void onSaveInstanceState(Bundle bundle) {
        bundle.putString(AlbumActivityConfig.WRITE_IMAGES_INFO, this.fxZ.getWriteImagesInfo().toJsonString());
        bundle.putBoolean(AlbumActivityConfig.USE_ORIGINAL_IMG, this.fyh);
    }

    private void initData(Bundle bundle) {
        this.fxZ = new o(this);
        if (bundle != null) {
            WriteImagesInfo writeImagesInfo = new WriteImagesInfo();
            writeImagesInfo.parseJson(bundle.getString(AlbumActivityConfig.WRITE_IMAGES_INFO));
            this.fxZ.setWriteImagesInfo(writeImagesInfo);
            this.fxZ.rf(bundle.getString(AlbumActivityConfig.CAMERA_PHOTO_NAME));
            this.fyh = bundle.getBoolean(AlbumActivityConfig.USE_ORIGINAL_IMG, false);
            return;
        }
        Intent intent = getIntent();
        if (intent != null) {
            WriteImagesInfo writeImagesInfo2 = new WriteImagesInfo();
            writeImagesInfo2.parseJson(intent.getStringExtra(AlbumActivityConfig.WRITE_IMAGES_INFO));
            this.fxZ.setWriteImagesInfo(writeImagesInfo2);
            this.fxZ.rf(intent.getStringExtra(AlbumActivityConfig.CAMERA_PHOTO_NAME));
            this.fyc = intent.getIntExtra(AlbumActivityConfig.CAMERA_REQUEST_FROM, 0);
            this.from = intent.getStringExtra("from");
            this.fid = intent.getStringExtra("forum_id");
            if ("from_writeActivity_livePhoto".equals(this.from)) {
                this.fye = true;
            } else {
                this.fye = false;
            }
            if (this.fyc == 2) {
                this.fyd = new com.baidu.tieba.write.album.b(this);
            }
            this.fxZ.lw(intent.getBooleanExtra(AlbumActivityConfig.AUTO_PHOTO_NAME, false));
            this.fyh = intent.getBooleanExtra(AlbumActivityConfig.USE_ORIGINAL_IMG, false);
        }
    }

    private void initView() {
        this.fya = new t(this);
        this.fya.blP();
    }

    private void blo() {
        if (this.fya != null && this.fxZ != null) {
            this.fya.si(this.fxZ.getMaxImagesAllowed());
            if (this.fxZ.blH() != null) {
                for (ImageFileInfo imageFileInfo : this.fxZ.blH()) {
                    this.fya.g(imageFileInfo);
                }
            }
            blw();
        }
    }

    private void blp() {
        String string;
        int size = this.fxZ.size();
        boolean z = size != 0;
        if (this.fyc == 5) {
            string = getPageContext().getPageActivity().getString(r.j.album_upload_btn, new Object[]{Integer.valueOf(size)});
        } else if (this.fye) {
            string = getPageContext().getPageActivity().getString(r.j.live_album_finish_btn, new Object[]{Integer.valueOf(size)});
        } else {
            string = getPageContext().getPageActivity().getString(r.j.album_finish_btn, new Object[]{Integer.valueOf(size)});
        }
        this.fya.o(z, string);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragmentActivity
    public void onChangeSkinType(int i) {
        this.fya.onChangeSkinType(i);
        if (this.fyg != null) {
            this.fyg.onChangeSkinType(i);
        }
    }

    private void blq() {
        if (this.fyc == 3) {
            TiebaStatic.log("c10489");
        }
        if (this.fyc == 5) {
            showLoadingDialog("正在上传");
            new b(this, null).execute(new String[0]);
            return;
        }
        Intent intent = new Intent();
        intent.putExtra(AlbumActivityConfig.ALBUM_RESULT, this.fxZ.getWriteImagesInfo().toJsonString());
        intent.putExtra(AlbumActivityConfig.CAMERA_REQUEST_FROM, this.fyc);
        setResult(-1, intent);
        finish();
    }

    @Override // com.baidu.adp.base.BdBaseFragmentActivity, android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.fya.blQ()) {
            blq();
        } else if (view == this.fya.blR()) {
            if (this.fxZ != null) {
                this.fxZ.setLastAlbumId(null);
            }
            blv();
        } else if (view == this.fya.blS()) {
            sd(0);
        } else if (view == this.fya.blT()) {
            blr();
        }
    }

    private void blr() {
        if (this.fya != null && this.fxZ != null) {
            this.fxZ.setOriginalImg(!this.fxZ.isOriginalImg());
            if (this.fxZ.isOriginalImg()) {
                if (!StringUtils.isNull(this.from, true) && !StringUtils.isNull(this.fid, true)) {
                    TiebaStatic.log(new at("c10349").ab("fid", this.fid).ab("obj_type", this.from));
                }
                blx();
                return;
            }
            this.fya.a(false, 0L);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public o bls() {
        return this.fxZ;
    }

    public com.baidu.tbadk.img.b ahb() {
        return this.ari;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void sd(int i) {
        I(i, true);
    }

    void I(int i, boolean z) {
        if (!this.fyb) {
            if (i == 0) {
                setSwipeBackEnabled(true);
                if (this.fyh) {
                    this.fya.H(false, this.fxZ.isOriginalImg());
                }
            } else {
                setSwipeBackEnabled(false);
                if (this.fyh) {
                    this.fya.H(true, this.fxZ.isOriginalImg());
                    blx();
                }
            }
            FragmentTransaction beginTransaction = getSupportFragmentManager().beginTransaction();
            Fragment findFragmentByTag = getSupportFragmentManager().findFragmentByTag(this.fya.sk(this.bLo));
            if (findFragmentByTag != null) {
                beginTransaction.hide(findFragmentByTag);
                if (z) {
                    this.ari.Ed();
                }
            }
            this.bLo = i;
            if (this.fya != null) {
                this.fya.sl(this.bLo);
            }
            if (getSupportFragmentManager().findFragmentByTag(this.fya.sk(i)) != null) {
                beginTransaction.show(this.fya.sj(i));
            } else {
                beginTransaction.add(r.g.fragment, this.fya.sj(i), this.fya.sk(i));
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
        int maxImagesAllowed = this.fxZ.getMaxImagesAllowed();
        if (this.fxZ.size() < maxImagesAllowed) {
            if (this.fyd == null || this.fyd.e(imageFileInfo)) {
                ImageFileInfo imageFileInfo2 = new ImageFileInfo();
                imageFileInfo2.setAlbumnId(imageFileInfo.getAlbumId());
                imageFileInfo2.setFilePath(imageFileInfo.getFilePath());
                imageFileInfo2.setModifyTime(imageFileInfo.getModifyTime());
                this.fxZ.addChooseFile(imageFileInfo2);
                blp();
                blw();
                this.fya.g(imageFileInfo2);
                blx();
                return true;
            }
            return false;
        } else if (blt()) {
            return c(imageFileInfo);
        } else {
            showToast(String.format(getPageContext().getContext().getString(r.j.album_beyond_max_choose), Integer.valueOf(maxImagesAllowed)));
            return false;
        }
    }

    public boolean blt() {
        if (getIntent().getBooleanExtra(AlbumActivityConfig.IS_SELECT_DIRECTLY, false)) {
            int maxImagesAllowed = this.fxZ.getMaxImagesAllowed();
            if (this.fxZ.size() == maxImagesAllowed && maxImagesAllowed == 1) {
                try {
                    ImageFileInfo imageFileInfo = this.fxZ.getWriteImagesInfo().getChosedFiles().get(0);
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
        this.fxZ.delChooseFile(imageFileInfo);
        blp();
        blw();
        this.fya.h(imageFileInfo);
        blx();
        return true;
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity, android.support.v4.app.FragmentActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i == 4) {
            if (this.bLo == 0) {
                if (this.fxZ != null) {
                    this.fxZ.setLastAlbumId(null);
                }
                blv();
                return true;
            } else if (this.bLo == 1) {
                sd(0);
                return true;
            } else {
                return true;
            }
        }
        return super.onKeyDown(i, keyEvent);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void J(int i, boolean z) {
        Fragment sj;
        if (this.fya != null && (sj = this.fya.sj(0)) != null && (sj instanceof ag)) {
            ((ag) sj).K(i, z);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void e(ImageFileInfo imageFileInfo, boolean z) {
        Fragment sj;
        if (this.fya != null && (sj = this.fya.sj(0)) != null && (sj instanceof ag)) {
            ((ag) sj).g(imageFileInfo, z);
        }
    }

    private void blu() {
        Fragment sj;
        if (this.fya != null && (sj = this.fya.sj(0)) != null && (sj instanceof ag)) {
            ((ag) sj).refresh();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void f(ImageFileInfo imageFileInfo, boolean z) {
        Fragment sj;
        if (this.fya != null && (sj = this.fya.sj(1)) != null && (sj instanceof e)) {
            ((e) sj).g(imageFileInfo, z);
        }
    }

    private void blv() {
        Intent intent = new Intent();
        String lastAlbumId = this.fxZ.getLastAlbumId();
        if (TextUtils.isEmpty(lastAlbumId)) {
            lastAlbumId = "";
        }
        intent.putExtra(AlbumActivityConfig.LAST_ALBUM_ID, lastAlbumId);
        intent.putExtra(AlbumActivityConfig.CAMERA_REQUEST_FROM, this.fyc);
        setResult(0, intent);
        finish();
    }

    private void blw() {
        if (this.fxZ != null && this.fya != null) {
            if (this.fxZ.size() == this.fxZ.getMaxImagesAllowed()) {
                this.fya.lz(false);
            } else {
                this.fya.lz(true);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.support.v4.app.FragmentActivity, android.app.Activity
    public void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (i2 == -1 && i == 12001) {
            qZ(this.fxZ.blM());
            I(1, false);
        }
    }

    private void qZ(String str) {
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
            if (this.fxZ.blJ() != null && this.fxZ.blJ().size() > 0) {
                this.fxZ.blJ().add(1, imageFileInfo);
                c(imageFileInfo);
                this.fxZ.sc(this.fxZ.blJ().indexOf(imageFileInfo));
                blu();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.adp.base.BdBaseFragmentActivity, android.support.v4.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        this.fyb = true;
        if (this.fya != null) {
            this.fya.onDestroy();
        }
        this.ari.Ed();
        p.blO().destory();
    }

    public void blx() {
        if (this.fya != null && this.fxZ != null && this.fxZ.blH() != null && this.fxZ.isOriginalImg()) {
            long j = 0;
            for (ImageFileInfo imageFileInfo : this.fxZ.blH()) {
                if (imageFileInfo != null) {
                    j += com.baidu.tbadk.core.util.m.getFileSize(imageFileInfo.getFilePath());
                }
            }
            this.fya.a(true, j);
        }
    }

    public void ra(String str) {
        this.fyi = str;
        if (!com.baidu.tbadk.core.util.ae.d(getPageContext().getPageActivity(), 1)) {
            if (StringUtils.isNull(this.fyi)) {
                aq.c(getPageContext());
            } else {
                aq.b(getPageContext(), this.fyi);
            }
        }
    }

    @Override // android.app.Activity, com.baidu.a.a.a.InterfaceC0000a
    public void onRequestPermissionsResult(int i, String[] strArr, int[] iArr) {
        if (i == 1) {
            if (com.baidu.tbadk.core.util.ae.Y(getApplicationContext())) {
                if (StringUtils.isNull(this.fyi)) {
                    aq.c(getPageContext());
                } else {
                    aq.b(getPageContext(), this.fyi);
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
            new com.baidu.tbadk.img.c(null).c(AlbumActivity.this.fxZ.getWriteImagesInfo(), true);
            return AlbumActivity.this.fxZ.getWriteImagesInfo().toJsonString();
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: ew */
        public void onPostExecute(String str) {
            Intent intent = new Intent();
            intent.putExtra(AlbumActivityConfig.ALBUM_RESULT, str);
            AlbumActivity.this.setResult(-1, intent);
            AlbumActivity.this.finish();
        }
    }
}
