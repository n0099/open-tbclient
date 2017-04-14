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
    private com.baidu.tbadk.img.b avZ;
    private o fMH;
    private t fMI;
    private y fML;
    private int mCurrentPage = 0;
    private boolean fMJ = false;
    private int fMK = 0;
    private String from = "";
    private String fid = "";
    private boolean fMM = false;
    private AlertDialog fMN = null;
    private a fMO = null;
    private boolean fMP = false;
    private String bdd = "";

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.adp.base.BdBaseFragmentActivity, android.support.v4.app.FragmentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.avZ = new com.baidu.tbadk.img.b();
        initView();
        initData(bundle);
        bnj();
        sL(0);
        bnk();
        boolean z = com.baidu.tbadk.core.sharedPref.b.uL().getBoolean("add_img_water_tip_show", true);
        if (!(com.baidu.tbadk.core.q.po().ps() != 0) && z && bnh()) {
            bni();
            com.baidu.tbadk.core.sharedPref.b.uL().putBoolean("add_img_water_tip_show", false);
        }
    }

    /* loaded from: classes.dex */
    public class a extends y.a {
        public int amZ;
        private TextView ceG;
        private TextView fMR;
        private TextView fMS;

        public a(View view) {
            super(view);
            this.amZ = 3;
            this.ceG = (TextView) view.findViewById(w.h.img_water_setting_title);
            this.fMR = (TextView) view.findViewById(w.h.img_water_setting_content);
            this.fMS = (TextView) view.findViewById(w.h.goto_setting);
            this.fMS.setOnClickListener(new c(this));
            bnt();
        }

        private void bnt() {
            aq.c(this.ceG, w.e.cp_cont_g, 1);
            aq.c(this.fMR, w.e.cp_cont_g, 1);
            aq.c(this.fMS, w.e.cp_link_tip_a, 1);
        }

        public void onChangeSkinType(int i) {
            if (this.amZ != i) {
                bnt();
                this.amZ = i;
            }
            if (AlbumActivity.this.fMI != null) {
                AlbumActivity.this.fMI.sT(AlbumActivity.this.mCurrentPage);
            }
        }
    }

    private boolean bnh() {
        return 2 == this.fMK || 3 == this.fMK || 1 == this.fMK || 3 == this.fMK || "frs".equals(this.from) || "pb".equals(this.from) || "from_writeActivity_livePhoto".equals(this.from);
    }

    private void bni() {
        if (this.fMO == null) {
            this.fMO = new a(LayoutInflater.from(getActivity()).inflate(w.j.dialog_img_water_setting, (ViewGroup) null));
        }
        this.fMN = new AlertDialog.Builder(getActivity()).create();
        this.fMN.show();
        Window window = this.fMN.getWindow();
        WindowManager.LayoutParams attributes = window.getAttributes();
        attributes.dimAmount = 0.5f;
        attributes.width = -2;
        attributes.height = -2;
        attributes.y = 0 - (com.baidu.adp.lib.util.k.ag(getActivity()) / 5);
        window.setAttributes(attributes);
        window.setContentView(this.fMO.getView());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.adp.base.BdBaseFragmentActivity, android.support.v4.app.FragmentActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        if (this.fMN != null) {
            com.baidu.adp.lib.g.h.fR().postDelayed(new com.baidu.tieba.write.album.a(this), 3000L);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.adp.base.BdBaseFragmentActivity, android.support.v4.app.FragmentActivity, android.app.Activity
    public void onPause() {
        super.onPause();
        if (this.fMN != null) {
            this.fMN.dismiss();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.support.v4.app.FragmentActivity, android.app.Activity
    public void onSaveInstanceState(Bundle bundle) {
        bundle.putString(AlbumActivityConfig.WRITE_IMAGES_INFO, this.fMH.getWriteImagesInfo().toJsonString());
        bundle.putBoolean(AlbumActivityConfig.USE_ORIGINAL_IMG, this.fMP);
    }

    private void initData(Bundle bundle) {
        this.fMH = new o(this);
        if (bundle != null) {
            WriteImagesInfo writeImagesInfo = new WriteImagesInfo();
            writeImagesInfo.parseJson(bundle.getString(AlbumActivityConfig.WRITE_IMAGES_INFO));
            this.fMH.setWriteImagesInfo(writeImagesInfo);
            this.fMH.ra(bundle.getString(AlbumActivityConfig.CAMERA_PHOTO_NAME));
            this.fMP = bundle.getBoolean(AlbumActivityConfig.USE_ORIGINAL_IMG, false);
            return;
        }
        Intent intent = getIntent();
        if (intent != null) {
            WriteImagesInfo writeImagesInfo2 = new WriteImagesInfo();
            writeImagesInfo2.parseJson(intent.getStringExtra(AlbumActivityConfig.WRITE_IMAGES_INFO));
            this.fMH.setWriteImagesInfo(writeImagesInfo2);
            this.fMH.ra(intent.getStringExtra(AlbumActivityConfig.CAMERA_PHOTO_NAME));
            this.fMK = intent.getIntExtra(AlbumActivityConfig.CAMERA_REQUEST_FROM, 0);
            this.from = intent.getStringExtra("from");
            this.fid = intent.getStringExtra("forum_id");
            if ("from_writeActivity_livePhoto".equals(this.from)) {
                this.fMM = true;
            } else {
                this.fMM = false;
            }
            if (this.fMK == 2) {
                this.fML = new com.baidu.tieba.write.album.b(this);
            }
            this.fMH.lI(intent.getBooleanExtra(AlbumActivityConfig.AUTO_PHOTO_NAME, false));
            this.fMP = intent.getBooleanExtra(AlbumActivityConfig.USE_ORIGINAL_IMG, false);
        }
    }

    private void initView() {
        this.fMI = new t(this);
        this.fMI.bnK();
    }

    private void bnj() {
        if (this.fMI != null && this.fMH != null) {
            this.fMI.sQ(this.fMH.getMaxImagesAllowed());
            if (this.fMH.bnC() != null) {
                for (ImageFileInfo imageFileInfo : this.fMH.bnC()) {
                    this.fMI.g(imageFileInfo);
                }
            }
            bnr();
        }
    }

    private void bnk() {
        String string;
        int size = this.fMH.size();
        boolean z = size != 0;
        if (this.fMK == 5) {
            string = getPageContext().getPageActivity().getString(w.l.album_upload_btn, new Object[]{Integer.valueOf(size)});
        } else if (this.fMM) {
            string = getPageContext().getPageActivity().getString(w.l.live_album_finish_btn, new Object[]{Integer.valueOf(size)});
        } else {
            string = getPageContext().getPageActivity().getString(w.l.album_finish_btn, new Object[]{Integer.valueOf(size)});
        }
        this.fMI.n(z, string);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragmentActivity
    public void onChangeSkinType(int i) {
        this.fMI.onChangeSkinType(i);
        if (this.fMO != null) {
            this.fMO.onChangeSkinType(i);
        }
    }

    private void bnl() {
        if (this.fMK == 3) {
            TiebaStatic.log("c10489");
        }
        if (this.fMK == 5) {
            showLoadingDialog("正在上传");
            new b(this, null).execute(new String[0]);
            return;
        }
        Intent intent = new Intent();
        intent.putExtra(AlbumActivityConfig.ALBUM_RESULT, this.fMH.getWriteImagesInfo().toJsonString());
        intent.putExtra(AlbumActivityConfig.CAMERA_REQUEST_FROM, this.fMK);
        setResult(-1, intent);
        finish();
    }

    @Override // com.baidu.adp.base.BdBaseFragmentActivity, android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.fMI.bnL()) {
            bnl();
        } else if (view == this.fMI.bnM()) {
            if (this.fMH != null) {
                this.fMH.setLastAlbumId(null);
            }
            bnq();
        } else if (view == this.fMI.bnN()) {
            sL(0);
        } else if (view == this.fMI.bnO()) {
            bnm();
        }
    }

    private void bnm() {
        if (this.fMI != null && this.fMH != null) {
            this.fMH.setOriginalImg(!this.fMH.isOriginalImg());
            if (this.fMH.isOriginalImg()) {
                if (!StringUtils.isNull(this.from, true) && !StringUtils.isNull(this.fid, true)) {
                    TiebaStatic.log(new as("c10349").aa("fid", this.fid).aa("obj_type", this.from));
                }
                bns();
                return;
            }
            this.fMI.a(false, 0L);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public o bnn() {
        return this.fMH;
    }

    public com.baidu.tbadk.img.b aho() {
        return this.avZ;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void sL(int i) {
        J(i, true);
    }

    void J(int i, boolean z) {
        if (!this.fMJ) {
            if (i == 0) {
                setSwipeBackEnabled(true);
                if (this.fMP) {
                    this.fMI.E(false, this.fMH.isOriginalImg());
                }
            } else {
                setSwipeBackEnabled(false);
                if (this.fMP) {
                    this.fMI.E(true, this.fMH.isOriginalImg());
                    bns();
                }
            }
            FragmentTransaction beginTransaction = getSupportFragmentManager().beginTransaction();
            Fragment findFragmentByTag = getSupportFragmentManager().findFragmentByTag(this.fMI.sS(this.mCurrentPage));
            if (findFragmentByTag != null) {
                beginTransaction.hide(findFragmentByTag);
                if (z) {
                    this.avZ.EP();
                }
            }
            this.mCurrentPage = i;
            if (this.fMI != null) {
                this.fMI.sT(this.mCurrentPage);
            }
            if (getSupportFragmentManager().findFragmentByTag(this.fMI.sS(i)) != null) {
                beginTransaction.show(this.fMI.sR(i));
            } else {
                beginTransaction.add(w.h.fragment, this.fMI.sR(i), this.fMI.sS(i));
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
        int maxImagesAllowed = this.fMH.getMaxImagesAllowed();
        if (this.fMH.size() < maxImagesAllowed) {
            if (this.fML == null || this.fML.e(imageFileInfo)) {
                ImageFileInfo imageFileInfo2 = new ImageFileInfo();
                imageFileInfo2.setAlbumnId(imageFileInfo.getAlbumId());
                imageFileInfo2.setFilePath(imageFileInfo.getFilePath());
                imageFileInfo2.setModifyTime(imageFileInfo.getModifyTime());
                this.fMH.addChooseFile(imageFileInfo2);
                bnk();
                bnr();
                this.fMI.g(imageFileInfo2);
                bns();
                return true;
            }
            return false;
        } else if (bno()) {
            return c(imageFileInfo);
        } else {
            showToast(String.format(getPageContext().getContext().getString(w.l.album_beyond_max_choose), Integer.valueOf(maxImagesAllowed)));
            return false;
        }
    }

    public boolean bno() {
        if (getIntent().getBooleanExtra(AlbumActivityConfig.IS_SELECT_DIRECTLY, false)) {
            int maxImagesAllowed = this.fMH.getMaxImagesAllowed();
            if (this.fMH.size() == maxImagesAllowed && maxImagesAllowed == 1) {
                try {
                    ImageFileInfo imageFileInfo = this.fMH.getWriteImagesInfo().getChosedFiles().get(0);
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
        this.fMH.delChooseFile(imageFileInfo);
        bnk();
        bnr();
        this.fMI.h(imageFileInfo);
        bns();
        return true;
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity, android.support.v4.app.FragmentActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i == 4) {
            if (this.mCurrentPage == 0) {
                if (this.fMH != null) {
                    this.fMH.setLastAlbumId(null);
                }
                bnq();
                return true;
            } else if (this.mCurrentPage == 1) {
                sL(0);
                return true;
            } else {
                return true;
            }
        }
        return super.onKeyDown(i, keyEvent);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void K(int i, boolean z) {
        Fragment sR;
        if (this.fMI != null && (sR = this.fMI.sR(0)) != null && (sR instanceof ag)) {
            ((ag) sR).L(i, z);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void e(ImageFileInfo imageFileInfo, boolean z) {
        Fragment sR;
        if (this.fMI != null && (sR = this.fMI.sR(0)) != null && (sR instanceof ag)) {
            ((ag) sR).g(imageFileInfo, z);
        }
    }

    private void bnp() {
        Fragment sR;
        if (this.fMI != null && (sR = this.fMI.sR(0)) != null && (sR instanceof ag)) {
            ((ag) sR).refresh();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void f(ImageFileInfo imageFileInfo, boolean z) {
        Fragment sR;
        if (this.fMI != null && (sR = this.fMI.sR(1)) != null && (sR instanceof e)) {
            ((e) sR).g(imageFileInfo, z);
        }
    }

    private void bnq() {
        Intent intent = new Intent();
        String lastAlbumId = this.fMH.getLastAlbumId();
        if (TextUtils.isEmpty(lastAlbumId)) {
            lastAlbumId = "";
        }
        intent.putExtra(AlbumActivityConfig.LAST_ALBUM_ID, lastAlbumId);
        intent.putExtra(AlbumActivityConfig.CAMERA_REQUEST_FROM, this.fMK);
        setResult(0, intent);
        finish();
    }

    private void bnr() {
        if (this.fMH != null && this.fMI != null) {
            if (this.fMH.size() == this.fMH.getMaxImagesAllowed()) {
                this.fMI.lL(false);
            } else {
                this.fMI.lL(true);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.support.v4.app.FragmentActivity, android.app.Activity
    public void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (i2 == -1 && i == 12001) {
            qV(this.fMH.bnH());
            J(1, false);
        }
    }

    private void qV(String str) {
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
                    Bitmap loadResizedBitmap = BitmapHelper.loadResizedBitmap(str2, com.baidu.adp.lib.util.k.dip2px(getPageContext().getPageActivity(), com.baidu.adp.lib.util.k.af(getPageContext().getPageActivity())), com.baidu.adp.lib.util.k.dip2px(getPageContext().getPageActivity(), com.baidu.adp.lib.util.k.ag(getPageContext().getPageActivity())));
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
            if (this.fMH.bnE() != null && this.fMH.bnE().size() > 0) {
                this.fMH.bnE().add(1, imageFileInfo);
                c(imageFileInfo);
                this.fMH.sK(this.fMH.bnE().indexOf(imageFileInfo));
                bnp();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.adp.base.BdBaseFragmentActivity, android.support.v4.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        this.fMJ = true;
        if (this.fMI != null) {
            this.fMI.onDestroy();
        }
        this.avZ.EP();
        p.bnJ().destory();
    }

    public void bns() {
        if (this.fMI != null && this.fMH != null && this.fMH.bnC() != null && this.fMH.isOriginalImg()) {
            long j = 0;
            for (ImageFileInfo imageFileInfo : this.fMH.bnC()) {
                if (imageFileInfo != null) {
                    j += com.baidu.tbadk.core.util.l.getFileSize(imageFileInfo.getFilePath());
                }
            }
            this.fMI.a(true, j);
        }
    }

    public void hB(String str) {
        this.bdd = str;
        if (!com.baidu.tbadk.core.util.ae.d(getPageContext().getPageActivity(), 1)) {
            if (StringUtils.isNull(this.bdd)) {
                com.baidu.tbadk.core.util.ap.c(getPageContext());
            } else {
                com.baidu.tbadk.core.util.ap.b(getPageContext(), this.bdd);
            }
        }
    }

    @Override // android.app.Activity, com.baidu.a.a.a.InterfaceC0000a
    public void onRequestPermissionsResult(int i, String[] strArr, int[] iArr) {
        if (i == 1) {
            if (com.baidu.tbadk.core.util.ae.aA(getApplicationContext())) {
                if (StringUtils.isNull(this.bdd)) {
                    com.baidu.tbadk.core.util.ap.c(getPageContext());
                } else {
                    com.baidu.tbadk.core.util.ap.b(getPageContext(), this.bdd);
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
            new com.baidu.tbadk.img.c(null).c(AlbumActivity.this.fMH.getWriteImagesInfo(), true);
            return AlbumActivity.this.fMH.getWriteImagesInfo().toJsonString();
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
