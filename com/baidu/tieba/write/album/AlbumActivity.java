package com.baidu.tieba.write.album;

import android.app.AlertDialog;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
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
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.widget.ListView.j;
import com.baidu.b.a.a;
import com.baidu.tbadk.ActivityPendingTransitionFactory;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tbadk.core.atomData.AlbumActivityConfig;
import com.baidu.tbadk.core.atomData.BrowseSettingActivityConfig;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.util.BitmapHelper;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.ab;
import com.baidu.tbadk.core.util.ai;
import com.baidu.tbadk.core.util.aj;
import com.baidu.tbadk.core.util.ak;
import com.baidu.tbadk.core.util.v;
import com.baidu.tbadk.img.ImageFileInfo;
import com.baidu.tbadk.img.WriteImagesInfo;
import com.baidu.tieba.d;
import com.baidu.tieba.frs.ForumWriteData;
/* loaded from: classes2.dex */
public class AlbumActivity extends BaseFragmentActivity implements View.OnClickListener, a.InterfaceC0022a {
    private com.baidu.tbadk.img.b axw;
    private ForumWriteData gFY;
    private h gGC;
    private e gGy;
    private com.baidu.tieba.write.album.a gGz;
    private int mCurrentPage = 0;
    private boolean gGA = false;
    private int gGB = 0;
    private String from = "";
    private String fid = "0";
    private boolean gGD = false;
    private AlertDialog bEC = null;
    private a gGE = null;
    private boolean gGF = false;
    private String bpx = "";

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.adp.base.BdBaseFragmentActivity, android.support.v4.app.FragmentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(d.j.album_activity);
        setSwipeBackEnabled(false);
        this.axw = new com.baidu.tbadk.img.b();
        this.gGz = new com.baidu.tieba.write.album.a(this);
        this.gGz.aLX();
        initData(bundle);
        uM(0);
        boolean z = com.baidu.tbadk.core.sharedPref.b.getInstance().getBoolean("add_img_water_tip_show", true);
        if (!(com.baidu.tbadk.core.h.oT().oX() != 0) && z && bzf()) {
            bzg();
            com.baidu.tbadk.core.sharedPref.b.getInstance().putBoolean("add_img_water_tip_show", false);
        }
    }

    /* loaded from: classes2.dex */
    public class a extends j.a {
        public int aoZ;
        private TextView cKz;
        private TextView gGH;
        private TextView gGI;

        public a(View view) {
            super(view);
            this.aoZ = 3;
            this.cKz = (TextView) view.findViewById(d.h.img_water_setting_title);
            this.gGH = (TextView) view.findViewById(d.h.img_water_setting_content);
            this.gGI = (TextView) view.findViewById(d.h.goto_setting);
            this.gGI.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.album.AlbumActivity.a.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    AlbumActivity.this.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new BrowseSettingActivityConfig(AlbumActivity.this.getPageContext().getPageActivity())));
                }
            });
            initResource();
        }

        private void initResource() {
            aj.c(this.cKz, d.e.cp_cont_g, 1);
            aj.c(this.gGH, d.e.cp_cont_g, 1);
            aj.c(this.gGI, d.e.cp_link_tip_a, 1);
        }

        public void onChangeSkinType(int i) {
            if (this.aoZ != i) {
                initResource();
                this.aoZ = i;
            }
        }
    }

    private boolean bzf() {
        return 2 == this.gGB || 3 == this.gGB || 1 == this.gGB || 3 == this.gGB || "frs".equals(this.from) || "pb".equals(this.from) || AlbumActivityConfig.FROM_WRITE.equals(this.from) || "main_tab".equals(this.from) || "from_writeActivity_livePhoto".equals(this.from);
    }

    private void bzg() {
        if (this.gGE == null) {
            this.gGE = new a(LayoutInflater.from(getActivity()).inflate(d.j.dialog_img_water_setting, (ViewGroup) null));
        }
        this.bEC = new AlertDialog.Builder(getActivity()).create();
        this.bEC.show();
        Window window = this.bEC.getWindow();
        WindowManager.LayoutParams attributes = window.getAttributes();
        attributes.dimAmount = 0.5f;
        attributes.width = -2;
        attributes.height = -2;
        attributes.y = 0 - (com.baidu.adp.lib.util.l.af(getActivity()) / 5);
        window.setAttributes(attributes);
        window.setContentView(this.gGE.getView());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.adp.base.BdBaseFragmentActivity, android.support.v4.app.FragmentActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        if (this.bEC != null) {
            com.baidu.adp.lib.g.e.fP().postDelayed(new Runnable() { // from class: com.baidu.tieba.write.album.AlbumActivity.1
                @Override // java.lang.Runnable
                public void run() {
                    AlbumActivity.this.bEC.dismiss();
                }
            }, 3000L);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.adp.base.BdBaseFragmentActivity, android.support.v4.app.FragmentActivity, android.app.Activity
    public void onPause() {
        super.onPause();
        if (this.bEC != null) {
            this.bEC.dismiss();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.support.v4.app.FragmentActivity, android.app.Activity
    public void onSaveInstanceState(Bundle bundle) {
        bundle.putString(AlbumActivityConfig.WRITE_IMAGES_INFO, this.gGy.getWriteImagesInfo().toJsonString());
        bundle.putBoolean(AlbumActivityConfig.USE_ORIGINAL_IMG, this.gGF);
    }

    private void initData(Bundle bundle) {
        this.gGy = new e(this);
        if (bundle != null) {
            WriteImagesInfo writeImagesInfo = new WriteImagesInfo();
            writeImagesInfo.parseJson(bundle.getString(AlbumActivityConfig.WRITE_IMAGES_INFO));
            this.gGy.setWriteImagesInfo(writeImagesInfo);
            this.gGy.tb(bundle.getString(AlbumActivityConfig.CAMERA_PHOTO_NAME));
            this.gGF = bundle.getBoolean(AlbumActivityConfig.USE_ORIGINAL_IMG, false);
            return;
        }
        Intent intent = getIntent();
        if (intent != null) {
            WriteImagesInfo writeImagesInfo2 = new WriteImagesInfo();
            writeImagesInfo2.parseJson(intent.getStringExtra(AlbumActivityConfig.WRITE_IMAGES_INFO));
            this.gGy.setWriteImagesInfo(writeImagesInfo2);
            this.gGy.setOriginalImg(writeImagesInfo2.isOriginalImg());
            this.gGy.tb(intent.getStringExtra(AlbumActivityConfig.CAMERA_PHOTO_NAME));
            this.gGB = intent.getIntExtra(AlbumActivityConfig.CAMERA_REQUEST_FROM, 0);
            this.from = intent.getStringExtra("from");
            this.fid = intent.getStringExtra("forum_id");
            this.gFY = (ForumWriteData) intent.getSerializableExtra(AlbumActivityConfig.KEY_FORUM_WRITE_DATA);
            if ("from_writeActivity_livePhoto".equals(this.from)) {
                this.gGD = true;
            } else {
                this.gGD = false;
            }
            if (this.gGB == 2) {
                this.gGC = new h() { // from class: com.baidu.tieba.write.album.AlbumActivity.2
                    @Override // com.baidu.tieba.write.album.h
                    public boolean f(ImageFileInfo imageFileInfo) {
                        if (imageFileInfo != null) {
                            String filePath = imageFileInfo.getFilePath();
                            if (!StringUtils.isNULL(filePath)) {
                                BitmapFactory.Options options = new BitmapFactory.Options();
                                options.inJustDecodeBounds = true;
                                BitmapFactory.decodeFile(filePath, options);
                                int i = options.outWidth;
                                if (options.outHeight >= 200 && i >= 200) {
                                    return true;
                                }
                            }
                        }
                        AlbumActivity.this.showToastWithIcon(AlbumActivity.this.getPageContext().getPageActivity().getString(d.l.uploade_attation), d.g.icon_toast_game_error);
                        return false;
                    }
                };
            }
            this.gGy.nq(intent.getBooleanExtra(AlbumActivityConfig.AUTO_PHOTO_NAME, false));
            this.gGF = intent.getBooleanExtra(AlbumActivityConfig.USE_ORIGINAL_IMG, false);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity
    protected void onChangeSkinType(int i) {
        this.gGz.onChangeSkinType(i);
        if (this.gGE != null) {
            this.gGE.onChangeSkinType(i);
        }
    }

    public void bzh() {
        if (this.gGB == 3) {
            TiebaStatic.log("c10489");
        }
        if (this.gGB == 5) {
            showLoadingDialog("正在上传");
            new b().execute(new String[0]);
            return;
        }
        Intent intent = new Intent();
        intent.putExtra(AlbumActivityConfig.ALBUM_RESULT, this.gGy.getWriteImagesInfo().toJsonString());
        intent.putExtra(AlbumActivityConfig.CAMERA_REQUEST_FROM, this.gGB);
        setResult(-1, intent);
        finish();
    }

    @Override // com.baidu.adp.base.BdBaseFragmentActivity, android.view.View.OnClickListener
    public void onClick(View view) {
        int currentIndex;
        if (view == this.gGz.bzp()) {
            bzh();
        } else if (view == this.gGz.bzr()) {
            if (this.gGy.getWriteImagesInfo() != null && this.gGy.getWriteImagesInfo().getChosedFiles() != null && this.gGy.getWriteImagesInfo().getChosedFiles().size() == 0 && this.gGz.bzu() != null && v.t(this.gGy.bzB()) > 0 && (currentIndex = this.gGz.bzu().getCurrentIndex()) >= 0) {
                d(this.gGy.bzB().get(currentIndex));
            }
            bzh();
        } else if (view == this.gGz.bzo()) {
            if (this.gGy != null) {
                this.gGy.setLastAlbumId(null);
            }
            bzm();
        } else if (view == this.gGz.bzq()) {
            uM(0);
        } else if (view == this.gGz.bzs()) {
            uL(2);
        } else if (view == this.gGz.bzt()) {
            uL(1);
        }
    }

    private void uL(int i) {
        if (this.gGz != null && this.gGy != null) {
            this.gGy.setOriginalImg(!this.gGy.isOriginalImg());
            if (this.gGy.isOriginalImg()) {
                if (!StringUtils.isNull(this.from, true) && !StringUtils.isNull(this.fid, true)) {
                    TiebaStatic.log(new ak("c10349").ad("fid", this.fid).ad("obj_type", this.from).r("obj_locate", i));
                }
                bzi();
                return;
            }
            if (this.gGz.bzu() != null) {
                this.gGz.bzu().np(false);
            }
            if (this.gGz.bzv() != null) {
                this.gGz.bzv().np(false);
            }
        }
    }

    public void bzi() {
        if (this.gGz != null && this.gGy != null && this.gGy.bzz() != null && this.gGy.isOriginalImg()) {
            if (this.gGz.bzu() != null) {
                this.gGz.bzu().np(true);
            }
            if (this.gGz.bzv() != null) {
                this.gGz.bzv().np(true);
            }
        }
    }

    public void ix(String str) {
        this.bpx = str;
        g.a(getPageContext(), this.bpx, this.gGz.bzn());
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public e bzj() {
        return this.gGy;
    }

    public com.baidu.tbadk.img.b aLU() {
        return this.axw;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void uM(int i) {
        if (!this.gGA) {
            FragmentTransaction beginTransaction = getSupportFragmentManager().beginTransaction();
            Fragment findFragmentByTag = getSupportFragmentManager().findFragmentByTag(this.gGz.uO(this.mCurrentPage));
            if (findFragmentByTag != null) {
                beginTransaction.hide(findFragmentByTag);
                this.axw.Ek();
            }
            this.mCurrentPage = i;
            if (getSupportFragmentManager().findFragmentByTag(this.gGz.uO(i)) != null) {
                beginTransaction.show(this.gGz.uN(i));
            } else {
                beginTransaction.add(d.h.fragment, this.gGz.uN(i), this.gGz.uO(i));
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
        int maxImagesAllowed = this.gGy.getMaxImagesAllowed();
        if (this.gGy.size() < maxImagesAllowed) {
            if (this.gGC == null || this.gGC.f(imageFileInfo)) {
                ImageFileInfo imageFileInfo2 = new ImageFileInfo();
                imageFileInfo2.setAlbumnId(imageFileInfo.getAlbumId());
                imageFileInfo2.setFilePath(imageFileInfo.getFilePath());
                imageFileInfo2.setModifyTime(imageFileInfo.getModifyTime());
                imageFileInfo2.setIsGif(imageFileInfo.isGif());
                imageFileInfo2.setIsLong(imageFileInfo.isLong());
                this.gGy.addChooseFile(imageFileInfo2);
                bzi();
                return true;
            }
            return false;
        } else if (bzk()) {
            return d(imageFileInfo);
        } else {
            showToast(String.format(getPageContext().getContext().getString(d.l.album_beyond_max_choose), Integer.valueOf(maxImagesAllowed)));
            return false;
        }
    }

    public boolean bzk() {
        if (getIntent().getBooleanExtra(AlbumActivityConfig.IS_SELECT_DIRECTLY, false)) {
            int maxImagesAllowed = this.gGy.getMaxImagesAllowed();
            if (this.gGy.size() == maxImagesAllowed && maxImagesAllowed == 1) {
                try {
                    ImageFileInfo imageFileInfo = this.gGy.getWriteImagesInfo().getChosedFiles().get(0);
                    if (e(imageFileInfo)) {
                        f(imageFileInfo, false);
                        g(imageFileInfo, false);
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
        this.gGy.delChooseFile(imageFileInfo);
        bzi();
        return true;
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity, android.support.v4.app.FragmentActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i == 4) {
            if (this.mCurrentPage == 0) {
                if (this.gGz.bzv() != null && !this.gGz.bzv().bzL()) {
                    this.gGz.bzv().bzH();
                    this.gGz.bzv().nt(true);
                    this.gGz.bzv().bpe();
                    return true;
                }
                if (this.gGy != null) {
                    this.gGy.setLastAlbumId(null);
                }
                bzm();
                return true;
            } else if (this.mCurrentPage == 1) {
                uM(0);
                return true;
            } else {
                return true;
            }
        }
        return super.onKeyDown(i, keyEvent);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void F(int i, boolean z) {
        Fragment uN;
        int i2 = i + 3;
        if (this.gGz != null && (uN = this.gGz.uN(0)) != null && (uN instanceof l)) {
            ((l) uN).G(i2, z);
        }
    }

    void f(ImageFileInfo imageFileInfo, boolean z) {
        Fragment uN;
        if (this.gGz != null && (uN = this.gGz.uN(0)) != null && (uN instanceof l)) {
            ((l) uN).h(imageFileInfo, z);
        }
    }

    private void bzl() {
        Fragment uN;
        if (this.gGz != null && (uN = this.gGz.uN(0)) != null && (uN instanceof l)) {
            ((l) uN).refresh();
        }
    }

    void g(ImageFileInfo imageFileInfo, boolean z) {
        Fragment uN;
        if (this.gGz != null && (uN = this.gGz.uN(1)) != null && (uN instanceof com.baidu.tieba.write.album.b)) {
            ((com.baidu.tieba.write.album.b) uN).h(imageFileInfo, z);
        }
    }

    private void bzm() {
        Intent intent = new Intent();
        String lastAlbumId = this.gGy.getLastAlbumId();
        if (TextUtils.isEmpty(lastAlbumId)) {
            lastAlbumId = "";
        }
        intent.putExtra(AlbumActivityConfig.LAST_ALBUM_ID, lastAlbumId);
        intent.putExtra(AlbumActivityConfig.CAMERA_REQUEST_FROM, this.gGB);
        setResult(0, intent);
        finish();
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity, android.app.Activity
    public void finish() {
        if (this.gGz != null && this.gGz.bzv() != null && this.gGz.bzv().bzn() != null) {
            this.gGz.bzv().bzn().stopCamera();
        }
        super.finish();
    }

    public void bpb() {
        sZ(this.gGy.bzE());
    }

    private void sZ(String str) {
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
                    Bitmap loadResizedBitmap = BitmapHelper.loadResizedBitmap(str2, com.baidu.adp.lib.util.l.dip2px(getPageContext().getPageActivity(), com.baidu.adp.lib.util.l.ad(getPageContext().getPageActivity())), com.baidu.adp.lib.util.l.dip2px(getPageContext().getPageActivity(), com.baidu.adp.lib.util.l.af(getPageContext().getPageActivity())));
                    Bitmap rotateBitmapBydegree = BitmapHelper.rotateBitmapBydegree(loadResizedBitmap, readPictureDegree);
                    if (loadResizedBitmap != rotateBitmapBydegree) {
                        loadResizedBitmap.recycle();
                    }
                    if (z) {
                        com.baidu.tbadk.core.util.k.a((String) null, str, rotateBitmapBydegree, 100);
                    } else {
                        com.baidu.tbadk.core.util.k.a(TbConfig.LOCAL_CAMERA_DIR, str, rotateBitmapBydegree, 100);
                    }
                    rotateBitmapBydegree.recycle();
                }
            } catch (Exception e) {
            }
            ImageFileInfo imageFileInfo = new ImageFileInfo();
            imageFileInfo.setFilePath(str2);
            imageFileInfo.setTempFile(true);
            if (this.gGy.bzB() != null && this.gGy.bzB().size() > 0) {
                this.gGy.bzB().add(0, imageFileInfo);
                d(imageFileInfo);
                this.gGy.setCurrentIndex(this.gGy.bzB().indexOf(imageFileInfo));
                bzl();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.adp.base.BdBaseFragmentActivity, android.support.v4.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        this.gGA = true;
        if (this.gGz != null) {
            this.gGz.onDestroy();
        }
        this.axw.Ek();
        f.bzG().destory();
    }

    @Override // android.app.Activity, com.baidu.b.a.a.InterfaceC0022a
    public void onRequestPermissionsResult(int i, String[] strArr, int[] iArr) {
        if (i == 1) {
            if (ab.aK(getApplicationContext())) {
                ai.b(getPageContext(), this.bpx);
            } else {
                showToast(d.l.system_permission_prompt_camera);
            }
            ArrayMap<String, Boolean> a2 = ab.a(strArr, iArr);
            if (a2.containsKey("android.permission.WRITE_EXTERNAL_STORAGE") && !a2.get("android.permission.WRITE_EXTERNAL_STORAGE").booleanValue()) {
                showToast(d.l.sdcard_permission_denied_advert_for_camera);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public class b extends BdAsyncTask<String, Integer, String> {
        private b() {
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: i */
        public String doInBackground(String... strArr) {
            new com.baidu.tbadk.img.f(null).c(AlbumActivity.this.gGy.getWriteImagesInfo(), true);
            return AlbumActivity.this.gGy.getWriteImagesInfo().toJsonString();
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

    @Override // com.baidu.tbadk.core.BaseFragmentActivity
    public void enterExitAnimation() {
        ActivityPendingTransitionFactory.enterExitAnimation(getPageContext(), 4);
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity
    public void closeAnimation() {
        ActivityPendingTransitionFactory.closeAnimation(getPageContext(), 4);
    }
}
