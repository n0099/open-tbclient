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
import com.baidu.tbadk.core.util.as;
import com.baidu.tbadk.img.ImageFileInfo;
import com.baidu.tbadk.img.WriteImagesInfo;
import com.baidu.tieba.w;
/* loaded from: classes.dex */
public class AlbumActivity extends BaseFragmentActivity implements View.OnClickListener, a.InterfaceC0000a {
    private com.baidu.tbadk.img.b avJ;
    private o fKY;
    private t fKZ;
    private y fLc;
    private int mCurrentPage = 0;
    private boolean fLa = false;
    private int fLb = 0;
    private String from = "";
    private String fid = "";
    private boolean fLd = false;
    private AlertDialog fLe = null;
    private a fLf = null;
    private boolean fLg = false;
    private String bdk = "";

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.adp.base.BdBaseFragmentActivity, android.support.v4.app.FragmentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.avJ = new com.baidu.tbadk.img.b();
        initView();
        initData(bundle);
        bmz();
        sN(0);
        bmA();
        boolean z = com.baidu.tbadk.core.sharedPref.b.uo().getBoolean("add_img_water_tip_show", true);
        if (!(com.baidu.tbadk.core.l.oQ().oU() != 0) && z && bmx()) {
            bmy();
            com.baidu.tbadk.core.sharedPref.b.uo().putBoolean("add_img_water_tip_show", false);
        }
    }

    /* loaded from: classes.dex */
    public class a extends y.a {
        public int amL;
        private TextView cgg;
        private TextView fLi;
        private TextView fLj;

        public a(View view) {
            super(view);
            this.amL = 3;
            this.cgg = (TextView) view.findViewById(w.h.img_water_setting_title);
            this.fLi = (TextView) view.findViewById(w.h.img_water_setting_content);
            this.fLj = (TextView) view.findViewById(w.h.goto_setting);
            this.fLj.setOnClickListener(new c(this));
            bmJ();
        }

        private void bmJ() {
            aq.c(this.cgg, w.e.cp_cont_g, 1);
            aq.c(this.fLi, w.e.cp_cont_g, 1);
            aq.c(this.fLj, w.e.cp_link_tip_a, 1);
        }

        public void onChangeSkinType(int i) {
            if (this.amL != i) {
                bmJ();
                this.amL = i;
            }
            if (AlbumActivity.this.fKZ != null) {
                AlbumActivity.this.fKZ.sV(AlbumActivity.this.mCurrentPage);
            }
        }
    }

    private boolean bmx() {
        return 2 == this.fLb || 3 == this.fLb || 1 == this.fLb || 3 == this.fLb || "frs".equals(this.from) || "pb".equals(this.from) || "from_writeActivity_livePhoto".equals(this.from);
    }

    private void bmy() {
        if (this.fLf == null) {
            this.fLf = new a(LayoutInflater.from(getActivity()).inflate(w.j.dialog_img_water_setting, (ViewGroup) null));
        }
        this.fLe = new AlertDialog.Builder(getActivity()).create();
        this.fLe.show();
        Window window = this.fLe.getWindow();
        WindowManager.LayoutParams attributes = window.getAttributes();
        attributes.dimAmount = 0.5f;
        attributes.width = -2;
        attributes.height = -2;
        attributes.y = 0 - (com.baidu.adp.lib.util.k.ah(getActivity()) / 5);
        window.setAttributes(attributes);
        window.setContentView(this.fLf.getView());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.adp.base.BdBaseFragmentActivity, android.support.v4.app.FragmentActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        if (this.fLe != null) {
            com.baidu.adp.lib.g.h.fM().postDelayed(new com.baidu.tieba.write.album.a(this), 3000L);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.adp.base.BdBaseFragmentActivity, android.support.v4.app.FragmentActivity, android.app.Activity
    public void onPause() {
        super.onPause();
        if (this.fLe != null) {
            this.fLe.dismiss();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.support.v4.app.FragmentActivity, android.app.Activity
    public void onSaveInstanceState(Bundle bundle) {
        bundle.putString(AlbumActivityConfig.WRITE_IMAGES_INFO, this.fKY.getWriteImagesInfo().toJsonString());
        bundle.putBoolean(AlbumActivityConfig.USE_ORIGINAL_IMG, this.fLg);
    }

    private void initData(Bundle bundle) {
        this.fKY = new o(this);
        if (bundle != null) {
            WriteImagesInfo writeImagesInfo = new WriteImagesInfo();
            writeImagesInfo.parseJson(bundle.getString(AlbumActivityConfig.WRITE_IMAGES_INFO));
            this.fKY.setWriteImagesInfo(writeImagesInfo);
            this.fKY.qG(bundle.getString(AlbumActivityConfig.CAMERA_PHOTO_NAME));
            this.fLg = bundle.getBoolean(AlbumActivityConfig.USE_ORIGINAL_IMG, false);
            return;
        }
        Intent intent = getIntent();
        if (intent != null) {
            WriteImagesInfo writeImagesInfo2 = new WriteImagesInfo();
            writeImagesInfo2.parseJson(intent.getStringExtra(AlbumActivityConfig.WRITE_IMAGES_INFO));
            this.fKY.setWriteImagesInfo(writeImagesInfo2);
            this.fKY.qG(intent.getStringExtra(AlbumActivityConfig.CAMERA_PHOTO_NAME));
            this.fLb = intent.getIntExtra(AlbumActivityConfig.CAMERA_REQUEST_FROM, 0);
            this.from = intent.getStringExtra("from");
            this.fid = intent.getStringExtra("forum_id");
            if ("from_writeActivity_livePhoto".equals(this.from)) {
                this.fLd = true;
            } else {
                this.fLd = false;
            }
            if (this.fLb == 2) {
                this.fLc = new com.baidu.tieba.write.album.b(this);
            }
            this.fKY.lF(intent.getBooleanExtra(AlbumActivityConfig.AUTO_PHOTO_NAME, false));
            this.fLg = intent.getBooleanExtra(AlbumActivityConfig.USE_ORIGINAL_IMG, false);
        }
    }

    private void initView() {
        this.fKZ = new t(this);
        this.fKZ.bna();
    }

    private void bmz() {
        if (this.fKZ != null && this.fKY != null) {
            this.fKZ.sS(this.fKY.getMaxImagesAllowed());
            if (this.fKY.bmS() != null) {
                for (ImageFileInfo imageFileInfo : this.fKY.bmS()) {
                    this.fKZ.g(imageFileInfo);
                }
            }
            bmH();
        }
    }

    private void bmA() {
        String string;
        int size = this.fKY.size();
        boolean z = size != 0;
        if (this.fLb == 5) {
            string = getPageContext().getPageActivity().getString(w.l.album_upload_btn, new Object[]{Integer.valueOf(size)});
        } else if (this.fLd) {
            string = getPageContext().getPageActivity().getString(w.l.live_album_finish_btn, new Object[]{Integer.valueOf(size)});
        } else {
            string = getPageContext().getPageActivity().getString(w.l.album_finish_btn, new Object[]{Integer.valueOf(size)});
        }
        this.fKZ.o(z, string);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragmentActivity
    public void onChangeSkinType(int i) {
        this.fKZ.onChangeSkinType(i);
        if (this.fLf != null) {
            this.fLf.onChangeSkinType(i);
        }
    }

    private void bmB() {
        if (this.fLb == 3) {
            TiebaStatic.log("c10489");
        }
        if (this.fLb == 5) {
            showLoadingDialog("正在上传");
            new b(this, null).execute(new String[0]);
            return;
        }
        Intent intent = new Intent();
        intent.putExtra(AlbumActivityConfig.ALBUM_RESULT, this.fKY.getWriteImagesInfo().toJsonString());
        intent.putExtra(AlbumActivityConfig.CAMERA_REQUEST_FROM, this.fLb);
        setResult(-1, intent);
        finish();
    }

    @Override // com.baidu.adp.base.BdBaseFragmentActivity, android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.fKZ.bnb()) {
            bmB();
        } else if (view == this.fKZ.bnc()) {
            if (this.fKY != null) {
                this.fKY.setLastAlbumId(null);
            }
            bmG();
        } else if (view == this.fKZ.bnd()) {
            sN(0);
        } else if (view == this.fKZ.bne()) {
            bmC();
        }
    }

    private void bmC() {
        if (this.fKZ != null && this.fKY != null) {
            this.fKY.setOriginalImg(!this.fKY.isOriginalImg());
            if (this.fKY.isOriginalImg()) {
                if (!StringUtils.isNull(this.from, true) && !StringUtils.isNull(this.fid, true)) {
                    TiebaStatic.log(new as("c10349").Z("fid", this.fid).Z("obj_type", this.from));
                }
                bmI();
                return;
            }
            this.fKZ.a(false, 0L);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public o bmD() {
        return this.fKY;
    }

    public com.baidu.tbadk.img.b ahu() {
        return this.avJ;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void sN(int i) {
        J(i, true);
    }

    void J(int i, boolean z) {
        if (!this.fLa) {
            if (i == 0) {
                setSwipeBackEnabled(true);
                if (this.fLg) {
                    this.fKZ.E(false, this.fKY.isOriginalImg());
                }
            } else {
                setSwipeBackEnabled(false);
                if (this.fLg) {
                    this.fKZ.E(true, this.fKY.isOriginalImg());
                    bmI();
                }
            }
            FragmentTransaction beginTransaction = getSupportFragmentManager().beginTransaction();
            Fragment findFragmentByTag = getSupportFragmentManager().findFragmentByTag(this.fKZ.sU(this.mCurrentPage));
            if (findFragmentByTag != null) {
                beginTransaction.hide(findFragmentByTag);
                if (z) {
                    this.avJ.Er();
                }
            }
            this.mCurrentPage = i;
            if (this.fKZ != null) {
                this.fKZ.sV(this.mCurrentPage);
            }
            if (getSupportFragmentManager().findFragmentByTag(this.fKZ.sU(i)) != null) {
                beginTransaction.show(this.fKZ.sT(i));
            } else {
                beginTransaction.add(w.h.fragment, this.fKZ.sT(i), this.fKZ.sU(i));
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
        int maxImagesAllowed = this.fKY.getMaxImagesAllowed();
        if (this.fKY.size() < maxImagesAllowed) {
            if (this.fLc == null || this.fLc.e(imageFileInfo)) {
                ImageFileInfo imageFileInfo2 = new ImageFileInfo();
                imageFileInfo2.setAlbumnId(imageFileInfo.getAlbumId());
                imageFileInfo2.setFilePath(imageFileInfo.getFilePath());
                imageFileInfo2.setModifyTime(imageFileInfo.getModifyTime());
                this.fKY.addChooseFile(imageFileInfo2);
                bmA();
                bmH();
                this.fKZ.g(imageFileInfo2);
                bmI();
                return true;
            }
            return false;
        } else if (bmE()) {
            return c(imageFileInfo);
        } else {
            showToast(String.format(getPageContext().getContext().getString(w.l.album_beyond_max_choose), Integer.valueOf(maxImagesAllowed)));
            return false;
        }
    }

    public boolean bmE() {
        if (getIntent().getBooleanExtra(AlbumActivityConfig.IS_SELECT_DIRECTLY, false)) {
            int maxImagesAllowed = this.fKY.getMaxImagesAllowed();
            if (this.fKY.size() == maxImagesAllowed && maxImagesAllowed == 1) {
                try {
                    ImageFileInfo imageFileInfo = this.fKY.getWriteImagesInfo().getChosedFiles().get(0);
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
        this.fKY.delChooseFile(imageFileInfo);
        bmA();
        bmH();
        this.fKZ.h(imageFileInfo);
        bmI();
        return true;
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity, android.support.v4.app.FragmentActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i == 4) {
            if (this.mCurrentPage == 0) {
                if (this.fKY != null) {
                    this.fKY.setLastAlbumId(null);
                }
                bmG();
                return true;
            } else if (this.mCurrentPage == 1) {
                sN(0);
                return true;
            } else {
                return true;
            }
        }
        return super.onKeyDown(i, keyEvent);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void K(int i, boolean z) {
        Fragment sT;
        if (this.fKZ != null && (sT = this.fKZ.sT(0)) != null && (sT instanceof ag)) {
            ((ag) sT).L(i, z);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void e(ImageFileInfo imageFileInfo, boolean z) {
        Fragment sT;
        if (this.fKZ != null && (sT = this.fKZ.sT(0)) != null && (sT instanceof ag)) {
            ((ag) sT).g(imageFileInfo, z);
        }
    }

    private void bmF() {
        Fragment sT;
        if (this.fKZ != null && (sT = this.fKZ.sT(0)) != null && (sT instanceof ag)) {
            ((ag) sT).refresh();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void f(ImageFileInfo imageFileInfo, boolean z) {
        Fragment sT;
        if (this.fKZ != null && (sT = this.fKZ.sT(1)) != null && (sT instanceof e)) {
            ((e) sT).g(imageFileInfo, z);
        }
    }

    private void bmG() {
        Intent intent = new Intent();
        String lastAlbumId = this.fKY.getLastAlbumId();
        if (TextUtils.isEmpty(lastAlbumId)) {
            lastAlbumId = "";
        }
        intent.putExtra(AlbumActivityConfig.LAST_ALBUM_ID, lastAlbumId);
        intent.putExtra(AlbumActivityConfig.CAMERA_REQUEST_FROM, this.fLb);
        setResult(0, intent);
        finish();
    }

    private void bmH() {
        if (this.fKY != null && this.fKZ != null) {
            if (this.fKY.size() == this.fKY.getMaxImagesAllowed()) {
                this.fKZ.lI(false);
            } else {
                this.fKZ.lI(true);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.support.v4.app.FragmentActivity, android.app.Activity
    public void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (i2 == -1 && i == 12001) {
            qB(this.fKY.bmX());
            J(1, false);
        }
    }

    private void qB(String str) {
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
                    Bitmap loadResizedBitmap = BitmapHelper.loadResizedBitmap(str2, com.baidu.adp.lib.util.k.dip2px(getPageContext().getPageActivity(), com.baidu.adp.lib.util.k.ag(getPageContext().getPageActivity())), com.baidu.adp.lib.util.k.dip2px(getPageContext().getPageActivity(), com.baidu.adp.lib.util.k.ah(getPageContext().getPageActivity())));
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
            if (this.fKY.bmU() != null && this.fKY.bmU().size() > 0) {
                this.fKY.bmU().add(1, imageFileInfo);
                c(imageFileInfo);
                this.fKY.sM(this.fKY.bmU().indexOf(imageFileInfo));
                bmF();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.adp.base.BdBaseFragmentActivity, android.support.v4.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        this.fLa = true;
        if (this.fKZ != null) {
            this.fKZ.onDestroy();
        }
        this.avJ.Er();
        p.bmZ().destory();
    }

    public void bmI() {
        if (this.fKZ != null && this.fKY != null && this.fKY.bmS() != null && this.fKY.isOriginalImg()) {
            long j = 0;
            for (ImageFileInfo imageFileInfo : this.fKY.bmS()) {
                if (imageFileInfo != null) {
                    j += com.baidu.tbadk.core.util.l.getFileSize(imageFileInfo.getFilePath());
                }
            }
            this.fKZ.a(true, j);
        }
    }

    public void hx(String str) {
        this.bdk = str;
        if (!com.baidu.tbadk.core.util.ae.d(getPageContext().getPageActivity(), 1)) {
            if (StringUtils.isNull(this.bdk)) {
                com.baidu.tbadk.core.util.ap.c(getPageContext());
            } else {
                com.baidu.tbadk.core.util.ap.b(getPageContext(), this.bdk);
            }
        }
    }

    @Override // android.app.Activity, com.baidu.a.a.a.InterfaceC0000a
    public void onRequestPermissionsResult(int i, String[] strArr, int[] iArr) {
        if (i == 1) {
            if (com.baidu.tbadk.core.util.ae.ay(getApplicationContext())) {
                if (StringUtils.isNull(this.bdk)) {
                    com.baidu.tbadk.core.util.ap.c(getPageContext());
                } else {
                    com.baidu.tbadk.core.util.ap.b(getPageContext(), this.bdk);
                }
            } else {
                showToast(w.l.system_permission_prompt_camera);
            }
            ArrayMap<String, Boolean> a2 = com.baidu.tbadk.core.util.ae.a(strArr, iArr);
            if (a2.containsKey("android.permission.WRITE_EXTERNAL_STORAGE") && !a2.get("android.permission.WRITE_EXTERNAL_STORAGE").booleanValue()) {
                showToast(w.l.sdcard_permission_denied_advert_for_camera);
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
            new com.baidu.tbadk.img.c(null).c(AlbumActivity.this.fKY.getWriteImagesInfo(), true);
            return AlbumActivity.this.fKY.getWriteImagesInfo().toJsonString();
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
