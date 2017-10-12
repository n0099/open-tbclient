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
    private ForumWriteData gFX;
    private h gGB;
    private e gGx;
    private com.baidu.tieba.write.album.a gGy;
    private int mCurrentPage = 0;
    private boolean gGz = false;
    private int gGA = 0;
    private String from = "";
    private String fid = "0";
    private boolean gGC = false;
    private AlertDialog bEC = null;
    private a gGD = null;
    private boolean gGE = false;
    private String bpx = "";

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.adp.base.BdBaseFragmentActivity, android.support.v4.app.FragmentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(d.j.album_activity);
        setSwipeBackEnabled(false);
        this.axw = new com.baidu.tbadk.img.b();
        this.gGy = new com.baidu.tieba.write.album.a(this);
        this.gGy.aLX();
        initData(bundle);
        uM(0);
        boolean z = com.baidu.tbadk.core.sharedPref.b.getInstance().getBoolean("add_img_water_tip_show", true);
        if (!(com.baidu.tbadk.core.h.oT().oX() != 0) && z && bze()) {
            bzf();
            com.baidu.tbadk.core.sharedPref.b.getInstance().putBoolean("add_img_water_tip_show", false);
        }
    }

    /* loaded from: classes2.dex */
    public class a extends j.a {
        public int aoZ;
        private TextView cKz;
        private TextView gGG;
        private TextView gGH;

        public a(View view) {
            super(view);
            this.aoZ = 3;
            this.cKz = (TextView) view.findViewById(d.h.img_water_setting_title);
            this.gGG = (TextView) view.findViewById(d.h.img_water_setting_content);
            this.gGH = (TextView) view.findViewById(d.h.goto_setting);
            this.gGH.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.album.AlbumActivity.a.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    AlbumActivity.this.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new BrowseSettingActivityConfig(AlbumActivity.this.getPageContext().getPageActivity())));
                }
            });
            initResource();
        }

        private void initResource() {
            aj.c(this.cKz, d.e.cp_cont_g, 1);
            aj.c(this.gGG, d.e.cp_cont_g, 1);
            aj.c(this.gGH, d.e.cp_link_tip_a, 1);
        }

        public void onChangeSkinType(int i) {
            if (this.aoZ != i) {
                initResource();
                this.aoZ = i;
            }
        }
    }

    private boolean bze() {
        return 2 == this.gGA || 3 == this.gGA || 1 == this.gGA || 3 == this.gGA || "frs".equals(this.from) || "pb".equals(this.from) || AlbumActivityConfig.FROM_WRITE.equals(this.from) || "main_tab".equals(this.from) || "from_writeActivity_livePhoto".equals(this.from);
    }

    private void bzf() {
        if (this.gGD == null) {
            this.gGD = new a(LayoutInflater.from(getActivity()).inflate(d.j.dialog_img_water_setting, (ViewGroup) null));
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
        window.setContentView(this.gGD.getView());
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
        bundle.putString(AlbumActivityConfig.WRITE_IMAGES_INFO, this.gGx.getWriteImagesInfo().toJsonString());
        bundle.putBoolean(AlbumActivityConfig.USE_ORIGINAL_IMG, this.gGE);
    }

    private void initData(Bundle bundle) {
        this.gGx = new e(this);
        if (bundle != null) {
            WriteImagesInfo writeImagesInfo = new WriteImagesInfo();
            writeImagesInfo.parseJson(bundle.getString(AlbumActivityConfig.WRITE_IMAGES_INFO));
            this.gGx.setWriteImagesInfo(writeImagesInfo);
            this.gGx.tb(bundle.getString(AlbumActivityConfig.CAMERA_PHOTO_NAME));
            this.gGE = bundle.getBoolean(AlbumActivityConfig.USE_ORIGINAL_IMG, false);
            return;
        }
        Intent intent = getIntent();
        if (intent != null) {
            WriteImagesInfo writeImagesInfo2 = new WriteImagesInfo();
            writeImagesInfo2.parseJson(intent.getStringExtra(AlbumActivityConfig.WRITE_IMAGES_INFO));
            this.gGx.setWriteImagesInfo(writeImagesInfo2);
            this.gGx.setOriginalImg(writeImagesInfo2.isOriginalImg());
            this.gGx.tb(intent.getStringExtra(AlbumActivityConfig.CAMERA_PHOTO_NAME));
            this.gGA = intent.getIntExtra(AlbumActivityConfig.CAMERA_REQUEST_FROM, 0);
            this.from = intent.getStringExtra("from");
            this.fid = intent.getStringExtra("forum_id");
            this.gFX = (ForumWriteData) intent.getSerializableExtra(AlbumActivityConfig.KEY_FORUM_WRITE_DATA);
            if ("from_writeActivity_livePhoto".equals(this.from)) {
                this.gGC = true;
            } else {
                this.gGC = false;
            }
            if (this.gGA == 2) {
                this.gGB = new h() { // from class: com.baidu.tieba.write.album.AlbumActivity.2
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
            this.gGx.nq(intent.getBooleanExtra(AlbumActivityConfig.AUTO_PHOTO_NAME, false));
            this.gGE = intent.getBooleanExtra(AlbumActivityConfig.USE_ORIGINAL_IMG, false);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity
    protected void onChangeSkinType(int i) {
        this.gGy.onChangeSkinType(i);
        if (this.gGD != null) {
            this.gGD.onChangeSkinType(i);
        }
    }

    public void bzg() {
        if (this.gGA == 3) {
            TiebaStatic.log("c10489");
        }
        if (this.gGA == 5) {
            showLoadingDialog("正在上传");
            new b().execute(new String[0]);
            return;
        }
        Intent intent = new Intent();
        intent.putExtra(AlbumActivityConfig.ALBUM_RESULT, this.gGx.getWriteImagesInfo().toJsonString());
        intent.putExtra(AlbumActivityConfig.CAMERA_REQUEST_FROM, this.gGA);
        setResult(-1, intent);
        finish();
    }

    @Override // com.baidu.adp.base.BdBaseFragmentActivity, android.view.View.OnClickListener
    public void onClick(View view) {
        int currentIndex;
        if (view == this.gGy.bzo()) {
            bzg();
        } else if (view == this.gGy.bzq()) {
            if (this.gGx.getWriteImagesInfo() != null && this.gGx.getWriteImagesInfo().getChosedFiles() != null && this.gGx.getWriteImagesInfo().getChosedFiles().size() == 0 && this.gGy.bzt() != null && v.t(this.gGx.bzA()) > 0 && (currentIndex = this.gGy.bzt().getCurrentIndex()) >= 0) {
                d(this.gGx.bzA().get(currentIndex));
            }
            bzg();
        } else if (view == this.gGy.bzn()) {
            if (this.gGx != null) {
                this.gGx.setLastAlbumId(null);
            }
            bzl();
        } else if (view == this.gGy.bzp()) {
            uM(0);
        } else if (view == this.gGy.bzr()) {
            uL(2);
        } else if (view == this.gGy.bzs()) {
            uL(1);
        }
    }

    private void uL(int i) {
        if (this.gGy != null && this.gGx != null) {
            this.gGx.setOriginalImg(!this.gGx.isOriginalImg());
            if (this.gGx.isOriginalImg()) {
                if (!StringUtils.isNull(this.from, true) && !StringUtils.isNull(this.fid, true)) {
                    TiebaStatic.log(new ak("c10349").ad("fid", this.fid).ad("obj_type", this.from).r("obj_locate", i));
                }
                bzh();
                return;
            }
            if (this.gGy.bzt() != null) {
                this.gGy.bzt().np(false);
            }
            if (this.gGy.bzu() != null) {
                this.gGy.bzu().np(false);
            }
        }
    }

    public void bzh() {
        if (this.gGy != null && this.gGx != null && this.gGx.bzy() != null && this.gGx.isOriginalImg()) {
            if (this.gGy.bzt() != null) {
                this.gGy.bzt().np(true);
            }
            if (this.gGy.bzu() != null) {
                this.gGy.bzu().np(true);
            }
        }
    }

    public void iw(String str) {
        this.bpx = str;
        g.a(getPageContext(), this.bpx, this.gGy.bzm());
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public e bzi() {
        return this.gGx;
    }

    public com.baidu.tbadk.img.b aLU() {
        return this.axw;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void uM(int i) {
        if (!this.gGz) {
            FragmentTransaction beginTransaction = getSupportFragmentManager().beginTransaction();
            Fragment findFragmentByTag = getSupportFragmentManager().findFragmentByTag(this.gGy.uO(this.mCurrentPage));
            if (findFragmentByTag != null) {
                beginTransaction.hide(findFragmentByTag);
                this.axw.Ek();
            }
            this.mCurrentPage = i;
            if (getSupportFragmentManager().findFragmentByTag(this.gGy.uO(i)) != null) {
                beginTransaction.show(this.gGy.uN(i));
            } else {
                beginTransaction.add(d.h.fragment, this.gGy.uN(i), this.gGy.uO(i));
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
        int maxImagesAllowed = this.gGx.getMaxImagesAllowed();
        if (this.gGx.size() < maxImagesAllowed) {
            if (this.gGB == null || this.gGB.f(imageFileInfo)) {
                ImageFileInfo imageFileInfo2 = new ImageFileInfo();
                imageFileInfo2.setAlbumnId(imageFileInfo.getAlbumId());
                imageFileInfo2.setFilePath(imageFileInfo.getFilePath());
                imageFileInfo2.setModifyTime(imageFileInfo.getModifyTime());
                imageFileInfo2.setIsGif(imageFileInfo.isGif());
                imageFileInfo2.setIsLong(imageFileInfo.isLong());
                this.gGx.addChooseFile(imageFileInfo2);
                bzh();
                return true;
            }
            return false;
        } else if (bzj()) {
            return d(imageFileInfo);
        } else {
            showToast(String.format(getPageContext().getContext().getString(d.l.album_beyond_max_choose), Integer.valueOf(maxImagesAllowed)));
            return false;
        }
    }

    public boolean bzj() {
        if (getIntent().getBooleanExtra(AlbumActivityConfig.IS_SELECT_DIRECTLY, false)) {
            int maxImagesAllowed = this.gGx.getMaxImagesAllowed();
            if (this.gGx.size() == maxImagesAllowed && maxImagesAllowed == 1) {
                try {
                    ImageFileInfo imageFileInfo = this.gGx.getWriteImagesInfo().getChosedFiles().get(0);
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
        this.gGx.delChooseFile(imageFileInfo);
        bzh();
        return true;
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity, android.support.v4.app.FragmentActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i == 4) {
            if (this.mCurrentPage == 0) {
                if (this.gGy.bzu() != null && !this.gGy.bzu().bzK()) {
                    this.gGy.bzu().bzG();
                    this.gGy.bzu().nt(true);
                    this.gGy.bzu().bpd();
                    return true;
                }
                if (this.gGx != null) {
                    this.gGx.setLastAlbumId(null);
                }
                bzl();
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
        if (this.gGy != null && (uN = this.gGy.uN(0)) != null && (uN instanceof l)) {
            ((l) uN).G(i2, z);
        }
    }

    void f(ImageFileInfo imageFileInfo, boolean z) {
        Fragment uN;
        if (this.gGy != null && (uN = this.gGy.uN(0)) != null && (uN instanceof l)) {
            ((l) uN).h(imageFileInfo, z);
        }
    }

    private void bzk() {
        Fragment uN;
        if (this.gGy != null && (uN = this.gGy.uN(0)) != null && (uN instanceof l)) {
            ((l) uN).refresh();
        }
    }

    void g(ImageFileInfo imageFileInfo, boolean z) {
        Fragment uN;
        if (this.gGy != null && (uN = this.gGy.uN(1)) != null && (uN instanceof com.baidu.tieba.write.album.b)) {
            ((com.baidu.tieba.write.album.b) uN).h(imageFileInfo, z);
        }
    }

    private void bzl() {
        Intent intent = new Intent();
        String lastAlbumId = this.gGx.getLastAlbumId();
        if (TextUtils.isEmpty(lastAlbumId)) {
            lastAlbumId = "";
        }
        intent.putExtra(AlbumActivityConfig.LAST_ALBUM_ID, lastAlbumId);
        intent.putExtra(AlbumActivityConfig.CAMERA_REQUEST_FROM, this.gGA);
        setResult(0, intent);
        finish();
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity, android.app.Activity
    public void finish() {
        if (this.gGy != null && this.gGy.bzu() != null && this.gGy.bzu().bzm() != null) {
            this.gGy.bzu().bzm().stopCamera();
        }
        super.finish();
    }

    public void bpa() {
        sZ(this.gGx.bzD());
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
            if (this.gGx.bzA() != null && this.gGx.bzA().size() > 0) {
                this.gGx.bzA().add(0, imageFileInfo);
                d(imageFileInfo);
                this.gGx.setCurrentIndex(this.gGx.bzA().indexOf(imageFileInfo));
                bzk();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.adp.base.BdBaseFragmentActivity, android.support.v4.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        this.gGz = true;
        if (this.gGy != null) {
            this.gGy.onDestroy();
        }
        this.axw.Ek();
        f.bzF().destory();
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
            new com.baidu.tbadk.img.f(null).c(AlbumActivity.this.gGx.getWriteImagesInfo(), true);
            return AlbumActivity.this.gGx.getWriteImagesInfo().toJsonString();
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
