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
    private com.baidu.tbadk.img.b awb;
    private o fPd;
    private t fPe;
    private y fPh;
    private int mCurrentPage = 0;
    private boolean fPf = false;
    private int fPg = 0;
    private String from = "";
    private String fid = "";
    private boolean fPi = false;
    private AlertDialog fPj = null;
    private a fPk = null;
    private boolean fPl = false;
    private String beu = "";

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.adp.base.BdBaseFragmentActivity, android.support.v4.app.FragmentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.awb = new com.baidu.tbadk.img.b();
        initView();
        initData(bundle);
        bok();
        sR(0);
        bol();
        boolean z = com.baidu.tbadk.core.sharedPref.b.uL().getBoolean("add_img_water_tip_show", true);
        if (!(com.baidu.tbadk.core.q.po().ps() != 0) && z && boi()) {
            boj();
            com.baidu.tbadk.core.sharedPref.b.uL().putBoolean("add_img_water_tip_show", false);
        }
    }

    /* loaded from: classes.dex */
    public class a extends y.a {
        public int amZ;
        private TextView cgX;
        private TextView fPn;
        private TextView fPo;

        public a(View view) {
            super(view);
            this.amZ = 3;
            this.cgX = (TextView) view.findViewById(w.h.img_water_setting_title);
            this.fPn = (TextView) view.findViewById(w.h.img_water_setting_content);
            this.fPo = (TextView) view.findViewById(w.h.goto_setting);
            this.fPo.setOnClickListener(new c(this));
            bou();
        }

        private void bou() {
            aq.c(this.cgX, w.e.cp_cont_g, 1);
            aq.c(this.fPn, w.e.cp_cont_g, 1);
            aq.c(this.fPo, w.e.cp_link_tip_a, 1);
        }

        public void onChangeSkinType(int i) {
            if (this.amZ != i) {
                bou();
                this.amZ = i;
            }
            if (AlbumActivity.this.fPe != null) {
                AlbumActivity.this.fPe.sZ(AlbumActivity.this.mCurrentPage);
            }
        }
    }

    private boolean boi() {
        return 2 == this.fPg || 3 == this.fPg || 1 == this.fPg || 3 == this.fPg || "frs".equals(this.from) || "pb".equals(this.from) || "from_writeActivity_livePhoto".equals(this.from);
    }

    private void boj() {
        if (this.fPk == null) {
            this.fPk = new a(LayoutInflater.from(getActivity()).inflate(w.j.dialog_img_water_setting, (ViewGroup) null));
        }
        this.fPj = new AlertDialog.Builder(getActivity()).create();
        this.fPj.show();
        Window window = this.fPj.getWindow();
        WindowManager.LayoutParams attributes = window.getAttributes();
        attributes.dimAmount = 0.5f;
        attributes.width = -2;
        attributes.height = -2;
        attributes.y = 0 - (com.baidu.adp.lib.util.k.ag(getActivity()) / 5);
        window.setAttributes(attributes);
        window.setContentView(this.fPk.getView());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.adp.base.BdBaseFragmentActivity, android.support.v4.app.FragmentActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        if (this.fPj != null) {
            com.baidu.adp.lib.g.h.fS().postDelayed(new com.baidu.tieba.write.album.a(this), 3000L);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.adp.base.BdBaseFragmentActivity, android.support.v4.app.FragmentActivity, android.app.Activity
    public void onPause() {
        super.onPause();
        if (this.fPj != null) {
            this.fPj.dismiss();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.support.v4.app.FragmentActivity, android.app.Activity
    public void onSaveInstanceState(Bundle bundle) {
        bundle.putString(AlbumActivityConfig.WRITE_IMAGES_INFO, this.fPd.getWriteImagesInfo().toJsonString());
        bundle.putBoolean(AlbumActivityConfig.USE_ORIGINAL_IMG, this.fPl);
    }

    private void initData(Bundle bundle) {
        this.fPd = new o(this);
        if (bundle != null) {
            WriteImagesInfo writeImagesInfo = new WriteImagesInfo();
            writeImagesInfo.parseJson(bundle.getString(AlbumActivityConfig.WRITE_IMAGES_INFO));
            this.fPd.setWriteImagesInfo(writeImagesInfo);
            this.fPd.rb(bundle.getString(AlbumActivityConfig.CAMERA_PHOTO_NAME));
            this.fPl = bundle.getBoolean(AlbumActivityConfig.USE_ORIGINAL_IMG, false);
            return;
        }
        Intent intent = getIntent();
        if (intent != null) {
            WriteImagesInfo writeImagesInfo2 = new WriteImagesInfo();
            writeImagesInfo2.parseJson(intent.getStringExtra(AlbumActivityConfig.WRITE_IMAGES_INFO));
            this.fPd.setWriteImagesInfo(writeImagesInfo2);
            this.fPd.rb(intent.getStringExtra(AlbumActivityConfig.CAMERA_PHOTO_NAME));
            this.fPg = intent.getIntExtra(AlbumActivityConfig.CAMERA_REQUEST_FROM, 0);
            this.from = intent.getStringExtra("from");
            this.fid = intent.getStringExtra("forum_id");
            if ("from_writeActivity_livePhoto".equals(this.from)) {
                this.fPi = true;
            } else {
                this.fPi = false;
            }
            if (this.fPg == 2) {
                this.fPh = new com.baidu.tieba.write.album.b(this);
            }
            this.fPd.lS(intent.getBooleanExtra(AlbumActivityConfig.AUTO_PHOTO_NAME, false));
            this.fPl = intent.getBooleanExtra(AlbumActivityConfig.USE_ORIGINAL_IMG, false);
        }
    }

    private void initView() {
        this.fPe = new t(this);
        this.fPe.boL();
    }

    private void bok() {
        if (this.fPe != null && this.fPd != null) {
            this.fPe.sW(this.fPd.getMaxImagesAllowed());
            if (this.fPd.boD() != null) {
                for (ImageFileInfo imageFileInfo : this.fPd.boD()) {
                    this.fPe.g(imageFileInfo);
                }
            }
            bos();
        }
    }

    private void bol() {
        String string;
        int size = this.fPd.size();
        boolean z = size != 0;
        if (this.fPg == 5) {
            string = getPageContext().getPageActivity().getString(w.l.album_upload_btn, new Object[]{Integer.valueOf(size)});
        } else if (this.fPi) {
            string = getPageContext().getPageActivity().getString(w.l.live_album_finish_btn, new Object[]{Integer.valueOf(size)});
        } else {
            string = getPageContext().getPageActivity().getString(w.l.album_finish_btn, new Object[]{Integer.valueOf(size)});
        }
        this.fPe.n(z, string);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragmentActivity
    public void onChangeSkinType(int i) {
        this.fPe.onChangeSkinType(i);
        if (this.fPk != null) {
            this.fPk.onChangeSkinType(i);
        }
    }

    private void bom() {
        if (this.fPg == 3) {
            TiebaStatic.log("c10489");
        }
        if (this.fPg == 5) {
            showLoadingDialog("正在上传");
            new b(this, null).execute(new String[0]);
            return;
        }
        Intent intent = new Intent();
        intent.putExtra(AlbumActivityConfig.ALBUM_RESULT, this.fPd.getWriteImagesInfo().toJsonString());
        intent.putExtra(AlbumActivityConfig.CAMERA_REQUEST_FROM, this.fPg);
        setResult(-1, intent);
        finish();
    }

    @Override // com.baidu.adp.base.BdBaseFragmentActivity, android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.fPe.boM()) {
            bom();
        } else if (view == this.fPe.boN()) {
            if (this.fPd != null) {
                this.fPd.setLastAlbumId(null);
            }
            bor();
        } else if (view == this.fPe.boO()) {
            sR(0);
        } else if (view == this.fPe.boP()) {
            bon();
        }
    }

    private void bon() {
        if (this.fPe != null && this.fPd != null) {
            this.fPd.setOriginalImg(!this.fPd.isOriginalImg());
            if (this.fPd.isOriginalImg()) {
                if (!StringUtils.isNull(this.from, true) && !StringUtils.isNull(this.fid, true)) {
                    TiebaStatic.log(new as("c10349").aa("fid", this.fid).aa("obj_type", this.from));
                }
                bot();
                return;
            }
            this.fPe.a(false, 0L);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public o boo() {
        return this.fPd;
    }

    public com.baidu.tbadk.img.b aip() {
        return this.awb;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void sR(int i) {
        J(i, true);
    }

    void J(int i, boolean z) {
        if (!this.fPf) {
            if (i == 0) {
                setSwipeBackEnabled(true);
                if (this.fPl) {
                    this.fPe.E(false, this.fPd.isOriginalImg());
                }
            } else {
                setSwipeBackEnabled(false);
                if (this.fPl) {
                    this.fPe.E(true, this.fPd.isOriginalImg());
                    bot();
                }
            }
            FragmentTransaction beginTransaction = getSupportFragmentManager().beginTransaction();
            Fragment findFragmentByTag = getSupportFragmentManager().findFragmentByTag(this.fPe.sY(this.mCurrentPage));
            if (findFragmentByTag != null) {
                beginTransaction.hide(findFragmentByTag);
                if (z) {
                    this.awb.EP();
                }
            }
            this.mCurrentPage = i;
            if (this.fPe != null) {
                this.fPe.sZ(this.mCurrentPage);
            }
            if (getSupportFragmentManager().findFragmentByTag(this.fPe.sY(i)) != null) {
                beginTransaction.show(this.fPe.sX(i));
            } else {
                beginTransaction.add(w.h.fragment, this.fPe.sX(i), this.fPe.sY(i));
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
        int maxImagesAllowed = this.fPd.getMaxImagesAllowed();
        if (this.fPd.size() < maxImagesAllowed) {
            if (this.fPh == null || this.fPh.e(imageFileInfo)) {
                ImageFileInfo imageFileInfo2 = new ImageFileInfo();
                imageFileInfo2.setAlbumnId(imageFileInfo.getAlbumId());
                imageFileInfo2.setFilePath(imageFileInfo.getFilePath());
                imageFileInfo2.setModifyTime(imageFileInfo.getModifyTime());
                this.fPd.addChooseFile(imageFileInfo2);
                bol();
                bos();
                this.fPe.g(imageFileInfo2);
                bot();
                return true;
            }
            return false;
        } else if (bop()) {
            return c(imageFileInfo);
        } else {
            showToast(String.format(getPageContext().getContext().getString(w.l.album_beyond_max_choose), Integer.valueOf(maxImagesAllowed)));
            return false;
        }
    }

    public boolean bop() {
        if (getIntent().getBooleanExtra(AlbumActivityConfig.IS_SELECT_DIRECTLY, false)) {
            int maxImagesAllowed = this.fPd.getMaxImagesAllowed();
            if (this.fPd.size() == maxImagesAllowed && maxImagesAllowed == 1) {
                try {
                    ImageFileInfo imageFileInfo = this.fPd.getWriteImagesInfo().getChosedFiles().get(0);
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
        this.fPd.delChooseFile(imageFileInfo);
        bol();
        bos();
        this.fPe.h(imageFileInfo);
        bot();
        return true;
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity, android.support.v4.app.FragmentActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i == 4) {
            if (this.mCurrentPage == 0) {
                if (this.fPd != null) {
                    this.fPd.setLastAlbumId(null);
                }
                bor();
                return true;
            } else if (this.mCurrentPage == 1) {
                sR(0);
                return true;
            } else {
                return true;
            }
        }
        return super.onKeyDown(i, keyEvent);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void K(int i, boolean z) {
        Fragment sX;
        if (this.fPe != null && (sX = this.fPe.sX(0)) != null && (sX instanceof ag)) {
            ((ag) sX).L(i, z);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void e(ImageFileInfo imageFileInfo, boolean z) {
        Fragment sX;
        if (this.fPe != null && (sX = this.fPe.sX(0)) != null && (sX instanceof ag)) {
            ((ag) sX).g(imageFileInfo, z);
        }
    }

    private void boq() {
        Fragment sX;
        if (this.fPe != null && (sX = this.fPe.sX(0)) != null && (sX instanceof ag)) {
            ((ag) sX).refresh();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void f(ImageFileInfo imageFileInfo, boolean z) {
        Fragment sX;
        if (this.fPe != null && (sX = this.fPe.sX(1)) != null && (sX instanceof e)) {
            ((e) sX).g(imageFileInfo, z);
        }
    }

    private void bor() {
        Intent intent = new Intent();
        String lastAlbumId = this.fPd.getLastAlbumId();
        if (TextUtils.isEmpty(lastAlbumId)) {
            lastAlbumId = "";
        }
        intent.putExtra(AlbumActivityConfig.LAST_ALBUM_ID, lastAlbumId);
        intent.putExtra(AlbumActivityConfig.CAMERA_REQUEST_FROM, this.fPg);
        setResult(0, intent);
        finish();
    }

    private void bos() {
        if (this.fPd != null && this.fPe != null) {
            if (this.fPd.size() == this.fPd.getMaxImagesAllowed()) {
                this.fPe.lV(false);
            } else {
                this.fPe.lV(true);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.support.v4.app.FragmentActivity, android.app.Activity
    public void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (i2 == -1 && i == 12001) {
            qW(this.fPd.boI());
            J(1, false);
        }
    }

    private void qW(String str) {
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
            if (this.fPd.boF() != null && this.fPd.boF().size() > 0) {
                this.fPd.boF().add(1, imageFileInfo);
                c(imageFileInfo);
                this.fPd.sQ(this.fPd.boF().indexOf(imageFileInfo));
                boq();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.adp.base.BdBaseFragmentActivity, android.support.v4.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        this.fPf = true;
        if (this.fPe != null) {
            this.fPe.onDestroy();
        }
        this.awb.EP();
        p.boK().destory();
    }

    public void bot() {
        if (this.fPe != null && this.fPd != null && this.fPd.boD() != null && this.fPd.isOriginalImg()) {
            long j = 0;
            for (ImageFileInfo imageFileInfo : this.fPd.boD()) {
                if (imageFileInfo != null) {
                    j += com.baidu.tbadk.core.util.l.getFileSize(imageFileInfo.getFilePath());
                }
            }
            this.fPe.a(true, j);
        }
    }

    public void hC(String str) {
        this.beu = str;
        if (!com.baidu.tbadk.core.util.ae.d(getPageContext().getPageActivity(), 1)) {
            if (StringUtils.isNull(this.beu)) {
                com.baidu.tbadk.core.util.ap.c(getPageContext());
            } else {
                com.baidu.tbadk.core.util.ap.b(getPageContext(), this.beu);
            }
        }
    }

    @Override // android.app.Activity, com.baidu.a.a.a.InterfaceC0000a
    public void onRequestPermissionsResult(int i, String[] strArr, int[] iArr) {
        if (i == 1) {
            if (com.baidu.tbadk.core.util.ae.aA(getApplicationContext())) {
                if (StringUtils.isNull(this.beu)) {
                    com.baidu.tbadk.core.util.ap.c(getPageContext());
                } else {
                    com.baidu.tbadk.core.util.ap.b(getPageContext(), this.beu);
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
            new com.baidu.tbadk.img.c(null).c(AlbumActivity.this.fPd.getWriteImagesInfo(), true);
            return AlbumActivity.this.fPd.getWriteImagesInfo().toJsonString();
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
