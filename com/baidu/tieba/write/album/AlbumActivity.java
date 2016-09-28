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
import com.baidu.tbadk.core.util.au;
import com.baidu.tbadk.core.util.av;
import com.baidu.tbadk.core.util.ax;
import com.baidu.tbadk.img.ImageFileInfo;
import com.baidu.tbadk.img.WriteImagesInfo;
import com.baidu.tieba.r;
/* loaded from: classes.dex */
public class AlbumActivity extends BaseFragmentActivity implements View.OnClickListener, a.InterfaceC0000a {
    private com.baidu.tbadk.img.b aqL;
    private o gbZ;
    private t gca;
    private y gcd;
    private int cci = 0;
    private boolean gcb = false;
    private int gcc = 0;
    private String from = "";
    private String fid = "";
    private boolean gce = false;
    private AlertDialog gcf = null;
    private a gcg = null;
    private boolean gch = false;
    private String gci = "";

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.adp.base.BdBaseFragmentActivity, android.support.v4.app.FragmentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.aqL = new com.baidu.tbadk.img.b();
        initView();
        initData(bundle);
        bsc();
        ti(0);
        bsd();
        boolean z = com.baidu.tbadk.core.sharedPref.b.uh().getBoolean("add_img_water_tip_show", true);
        if (!(com.baidu.tbadk.core.l.oH().oL() != 0) && z && bsa()) {
            bsb();
            com.baidu.tbadk.core.sharedPref.b.uh().putBoolean("add_img_water_tip_show", false);
        }
    }

    /* loaded from: classes.dex */
    public class a extends y.a {
        public int ahV;
        private TextView bqy;
        private TextView gck;
        private TextView gcl;

        public a(View view) {
            super(view);
            this.ahV = 3;
            this.bqy = (TextView) view.findViewById(r.g.img_water_setting_title);
            this.gck = (TextView) view.findViewById(r.g.img_water_setting_content);
            this.gcl = (TextView) view.findViewById(r.g.goto_setting);
            this.gcl.setOnClickListener(new c(this));
            bsm();
        }

        private void bsm() {
            av.c(this.bqy, r.d.cp_cont_g, 1);
            av.c(this.gck, r.d.cp_cont_g, 1);
            av.c(this.gcl, r.d.cp_link_tip_a, 1);
        }

        public void onChangeSkinType(int i) {
            if (this.ahV != i) {
                bsm();
                this.ahV = i;
            }
            if (AlbumActivity.this.gca != null) {
                AlbumActivity.this.gca.tq(AlbumActivity.this.cci);
            }
        }
    }

    private boolean bsa() {
        return 2 == this.gcc || 3 == this.gcc || 1 == this.gcc || 3 == this.gcc || "frs".equals(this.from) || "pb".equals(this.from) || "from_writeActivity_livePhoto".equals(this.from);
    }

    private void bsb() {
        if (this.gcg == null) {
            this.gcg = new a(LayoutInflater.from(getActivity()).inflate(r.h.dialog_img_water_setting, (ViewGroup) null));
        }
        this.gcf = new AlertDialog.Builder(getActivity()).create();
        this.gcf.show();
        Window window = this.gcf.getWindow();
        WindowManager.LayoutParams attributes = window.getAttributes();
        attributes.dimAmount = 0.5f;
        attributes.width = -2;
        attributes.height = -2;
        attributes.y = 0 - (com.baidu.adp.lib.util.k.L(getActivity()) / 5);
        window.setAttributes(attributes);
        window.setContentView(this.gcg.getView());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.adp.base.BdBaseFragmentActivity, android.support.v4.app.FragmentActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        if (this.gcf != null) {
            com.baidu.adp.lib.h.h.eG().postDelayed(new com.baidu.tieba.write.album.a(this), 3000L);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.adp.base.BdBaseFragmentActivity, android.support.v4.app.FragmentActivity, android.app.Activity
    public void onPause() {
        super.onPause();
        if (this.gcf != null) {
            this.gcf.dismiss();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.support.v4.app.FragmentActivity, android.app.Activity
    public void onSaveInstanceState(Bundle bundle) {
        bundle.putString(AlbumActivityConfig.WRITE_IMAGES_INFO, this.gbZ.getWriteImagesInfo().toJsonString());
        bundle.putBoolean(AlbumActivityConfig.USE_ORIGINAL_IMG, this.gch);
    }

    private void initData(Bundle bundle) {
        this.gbZ = new o(this);
        if (bundle != null) {
            WriteImagesInfo writeImagesInfo = new WriteImagesInfo();
            writeImagesInfo.parseJson(bundle.getString(AlbumActivityConfig.WRITE_IMAGES_INFO));
            this.gbZ.setWriteImagesInfo(writeImagesInfo);
            this.gbZ.sw(bundle.getString(AlbumActivityConfig.CAMERA_PHOTO_NAME));
            this.gch = bundle.getBoolean(AlbumActivityConfig.USE_ORIGINAL_IMG, false);
            return;
        }
        Intent intent = getIntent();
        if (intent != null) {
            WriteImagesInfo writeImagesInfo2 = new WriteImagesInfo();
            writeImagesInfo2.parseJson(intent.getStringExtra(AlbumActivityConfig.WRITE_IMAGES_INFO));
            this.gbZ.setWriteImagesInfo(writeImagesInfo2);
            this.gbZ.sw(intent.getStringExtra(AlbumActivityConfig.CAMERA_PHOTO_NAME));
            this.gcc = intent.getIntExtra(AlbumActivityConfig.CAMERA_REQUEST_FROM, 0);
            this.from = intent.getStringExtra("from");
            this.fid = intent.getStringExtra("forum_id");
            if ("from_writeActivity_livePhoto".equals(this.from)) {
                this.gce = true;
            } else {
                this.gce = false;
            }
            if (this.gcc == 2) {
                this.gcd = new com.baidu.tieba.write.album.b(this);
            }
            this.gbZ.lJ(intent.getBooleanExtra(AlbumActivityConfig.AUTO_PHOTO_NAME, false));
            this.gch = intent.getBooleanExtra(AlbumActivityConfig.USE_ORIGINAL_IMG, false);
        }
    }

    private void initView() {
        this.gca = new t(this);
        this.gca.bsz();
    }

    private void bsc() {
        if (this.gca != null && this.gbZ != null) {
            this.gca.tn(this.gbZ.getMaxImagesAllowed());
            if (this.gbZ.bss() != null) {
                for (ImageFileInfo imageFileInfo : this.gbZ.bss()) {
                    this.gca.h(imageFileInfo);
                }
            }
            bsk();
        }
    }

    private void bsd() {
        String string;
        int size = this.gbZ.size();
        boolean z = size != 0;
        if (this.gcc == 5) {
            string = getPageContext().getPageActivity().getString(r.j.album_upload_btn, new Object[]{Integer.valueOf(size)});
        } else if (this.gce) {
            string = getPageContext().getPageActivity().getString(r.j.live_album_finish_btn, new Object[]{Integer.valueOf(size)});
        } else {
            string = getPageContext().getPageActivity().getString(r.j.album_finish_btn, new Object[]{Integer.valueOf(size)});
        }
        this.gca.n(z, string);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragmentActivity
    public void onChangeSkinType(int i) {
        this.gca.onChangeSkinType(i);
        if (this.gcg != null) {
            this.gcg.onChangeSkinType(i);
        }
    }

    private void bse() {
        if (this.gcc == 3) {
            TiebaStatic.log("c10489");
        }
        if (this.gcc == 5) {
            showLoadingDialog("正在上传");
            new b(this, null).execute(new String[0]);
            return;
        }
        Intent intent = new Intent();
        intent.putExtra(AlbumActivityConfig.ALBUM_RESULT, this.gbZ.getWriteImagesInfo().toJsonString());
        intent.putExtra(AlbumActivityConfig.CAMERA_REQUEST_FROM, this.gcc);
        setResult(-1, intent);
        finish();
    }

    @Override // com.baidu.adp.base.BdBaseFragmentActivity, android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.gca.bsA()) {
            bse();
        } else if (view == this.gca.bsB()) {
            if (this.gbZ != null) {
                this.gbZ.setLastAlbumId(null);
            }
            bsj();
        } else if (view == this.gca.bsC()) {
            ti(0);
        } else if (view == this.gca.bsD()) {
            bsf();
        }
    }

    private void bsf() {
        if (this.gca != null && this.gbZ != null) {
            this.gbZ.setOriginalImg(!this.gbZ.isOriginalImg());
            if (this.gbZ.isOriginalImg()) {
                if (!StringUtils.isNull(this.from, true) && !StringUtils.isNull(this.fid, true)) {
                    TiebaStatic.log(new ax("c10349").ab("fid", this.fid).ab("obj_type", this.from));
                }
                bsl();
                return;
            }
            this.gca.a(false, 0L);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public o bsg() {
        return this.gbZ;
    }

    public com.baidu.tbadk.img.b akF() {
        return this.aqL;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void ti(int i) {
        V(i, true);
    }

    void V(int i, boolean z) {
        if (!this.gcb) {
            if (i == 0) {
                setSwipeBackEnabled(true);
                if (this.gch) {
                    this.gca.E(false, this.gbZ.isOriginalImg());
                }
            } else {
                setSwipeBackEnabled(false);
                if (this.gch) {
                    this.gca.E(true, this.gbZ.isOriginalImg());
                    bsl();
                }
            }
            FragmentTransaction beginTransaction = getSupportFragmentManager().beginTransaction();
            Fragment findFragmentByTag = getSupportFragmentManager().findFragmentByTag(this.gca.tp(this.cci));
            if (findFragmentByTag != null) {
                beginTransaction.hide(findFragmentByTag);
                if (z) {
                    this.aqL.Eq();
                }
            }
            this.cci = i;
            if (this.gca != null) {
                this.gca.tq(this.cci);
            }
            if (getSupportFragmentManager().findFragmentByTag(this.gca.tp(i)) != null) {
                beginTransaction.show(this.gca.to(i));
            } else {
                beginTransaction.add(r.g.fragment, this.gca.to(i), this.gca.tp(i));
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
        int maxImagesAllowed = this.gbZ.getMaxImagesAllowed();
        if (this.gbZ.size() < maxImagesAllowed) {
            if (this.gcd == null || this.gcd.f(imageFileInfo)) {
                ImageFileInfo imageFileInfo2 = new ImageFileInfo();
                imageFileInfo2.setAlbumnId(imageFileInfo.getAlbumId());
                imageFileInfo2.setFilePath(imageFileInfo.getFilePath());
                imageFileInfo2.setModifyTime(imageFileInfo.getModifyTime());
                this.gbZ.addChooseFile(imageFileInfo2);
                bsd();
                bsk();
                this.gca.h(imageFileInfo2);
                bsl();
                return true;
            }
            return false;
        } else if (bsh()) {
            return d(imageFileInfo);
        } else {
            showToast(String.format(getPageContext().getContext().getString(r.j.album_beyond_max_choose), Integer.valueOf(maxImagesAllowed)));
            return false;
        }
    }

    public boolean bsh() {
        if (getIntent().getBooleanExtra(AlbumActivityConfig.IS_SELECT_DIRECTLY, false)) {
            int maxImagesAllowed = this.gbZ.getMaxImagesAllowed();
            if (this.gbZ.size() == maxImagesAllowed && maxImagesAllowed == 1) {
                try {
                    ImageFileInfo imageFileInfo = this.gbZ.getWriteImagesInfo().getChosedFiles().get(0);
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
        this.gbZ.delChooseFile(imageFileInfo);
        bsd();
        bsk();
        this.gca.i(imageFileInfo);
        bsl();
        return true;
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity, android.support.v4.app.FragmentActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i == 4) {
            if (this.cci == 0) {
                if (this.gbZ != null) {
                    this.gbZ.setLastAlbumId(null);
                }
                bsj();
                return true;
            } else if (this.cci == 1) {
                ti(0);
                return true;
            } else {
                return true;
            }
        }
        return super.onKeyDown(i, keyEvent);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void W(int i, boolean z) {
        Fragment fragment;
        if (this.gca != null && (fragment = this.gca.to(0)) != null && (fragment instanceof ag)) {
            ((ag) fragment).X(i, z);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void e(ImageFileInfo imageFileInfo, boolean z) {
        Fragment fragment;
        if (this.gca != null && (fragment = this.gca.to(0)) != null && (fragment instanceof ag)) {
            ((ag) fragment).g(imageFileInfo, z);
        }
    }

    private void bsi() {
        Fragment fragment;
        if (this.gca != null && (fragment = this.gca.to(0)) != null && (fragment instanceof ag)) {
            ((ag) fragment).refresh();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void f(ImageFileInfo imageFileInfo, boolean z) {
        Fragment fragment;
        if (this.gca != null && (fragment = this.gca.to(1)) != null && (fragment instanceof e)) {
            ((e) fragment).g(imageFileInfo, z);
        }
    }

    private void bsj() {
        Intent intent = new Intent();
        String lastAlbumId = this.gbZ.getLastAlbumId();
        if (TextUtils.isEmpty(lastAlbumId)) {
            lastAlbumId = "";
        }
        intent.putExtra(AlbumActivityConfig.LAST_ALBUM_ID, lastAlbumId);
        intent.putExtra(AlbumActivityConfig.CAMERA_REQUEST_FROM, this.gcc);
        setResult(0, intent);
        finish();
    }

    private void bsk() {
        if (this.gbZ != null && this.gca != null) {
            if (this.gbZ.size() == this.gbZ.getMaxImagesAllowed()) {
                this.gca.lM(false);
            } else {
                this.gca.lM(true);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.support.v4.app.FragmentActivity, android.app.Activity
    public void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (i2 == -1 && i == 12001) {
            ss(this.gbZ.bsw());
            V(1, false);
        }
    }

    private void ss(String str) {
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
            if (this.gbZ.bsu() != null && this.gbZ.bsu().size() > 0) {
                this.gbZ.bsu().add(1, imageFileInfo);
                d(imageFileInfo);
                this.gbZ.th(this.gbZ.bsu().indexOf(imageFileInfo));
                bsi();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.adp.base.BdBaseFragmentActivity, android.support.v4.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        this.gcb = true;
        if (this.gca != null) {
            this.gca.onDestroy();
        }
        this.aqL.Eq();
        p.bsy().destory();
    }

    public void bsl() {
        if (this.gca != null && this.gbZ != null && this.gbZ.bss() != null && this.gbZ.isOriginalImg()) {
            long j = 0;
            for (ImageFileInfo imageFileInfo : this.gbZ.bss()) {
                if (imageFileInfo != null) {
                    j += com.baidu.tbadk.core.util.m.getFileSize(imageFileInfo.getFilePath());
                }
            }
            this.gca.a(true, j);
        }
    }

    public void st(String str) {
        this.gci = str;
        if (!com.baidu.tbadk.core.util.ag.d(getPageContext().getPageActivity(), 1)) {
            if (StringUtils.isNull(this.gci)) {
                au.c(getPageContext());
            } else {
                au.b(getPageContext(), this.gci);
            }
        }
    }

    @Override // android.app.Activity, com.baidu.a.a.a.InterfaceC0000a
    public void onRequestPermissionsResult(int i, String[] strArr, int[] iArr) {
        if (i == 1) {
            if (com.baidu.tbadk.core.util.ag.aa(getApplicationContext())) {
                if (StringUtils.isNull(this.gci)) {
                    au.c(getPageContext());
                } else {
                    au.b(getPageContext(), this.gci);
                }
            } else {
                showToast(r.j.system_permission_prompt_camera);
            }
            ArrayMap<String, Boolean> a2 = com.baidu.tbadk.core.util.ag.a(strArr, iArr);
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
            new com.baidu.tbadk.img.c(null).c(AlbumActivity.this.gbZ.getWriteImagesInfo(), true);
            return AlbumActivity.this.gbZ.getWriteImagesInfo().toJsonString();
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: ex */
        public void onPostExecute(String str) {
            Intent intent = new Intent();
            intent.putExtra(AlbumActivityConfig.ALBUM_RESULT, str);
            AlbumActivity.this.setResult(-1, intent);
            AlbumActivity.this.finish();
        }
    }
}
