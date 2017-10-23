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
    private com.baidu.tbadk.img.b axk;
    private ForumWriteData gFI;
    private e gGi;
    private com.baidu.tieba.write.album.a gGj;
    private h gGm;
    private int mCurrentPage = 0;
    private boolean gGk = false;
    private int gGl = 0;
    private String from = "";
    private String fid = "0";
    private boolean gGn = false;
    private AlertDialog bEq = null;
    private a gGo = null;
    private boolean gGp = false;
    private String bpl = "";

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.adp.base.BdBaseFragmentActivity, android.support.v4.app.FragmentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(d.j.album_activity);
        setSwipeBackEnabled(false);
        this.axk = new com.baidu.tbadk.img.b();
        this.gGj = new com.baidu.tieba.write.album.a(this);
        this.gGj.aLS();
        initData(bundle);
        uL(0);
        boolean z = com.baidu.tbadk.core.sharedPref.b.getInstance().getBoolean("add_img_water_tip_show", true);
        if (!(com.baidu.tbadk.core.h.oM().oQ() != 0) && z && byY()) {
            byZ();
            com.baidu.tbadk.core.sharedPref.b.getInstance().putBoolean("add_img_water_tip_show", false);
        }
    }

    /* loaded from: classes2.dex */
    public class a extends j.a {
        public int aoN;
        private TextView cKn;
        private TextView gGr;
        private TextView gGs;

        public a(View view) {
            super(view);
            this.aoN = 3;
            this.cKn = (TextView) view.findViewById(d.h.img_water_setting_title);
            this.gGr = (TextView) view.findViewById(d.h.img_water_setting_content);
            this.gGs = (TextView) view.findViewById(d.h.goto_setting);
            this.gGs.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.album.AlbumActivity.a.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    AlbumActivity.this.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new BrowseSettingActivityConfig(AlbumActivity.this.getPageContext().getPageActivity())));
                }
            });
            initResource();
        }

        private void initResource() {
            aj.c(this.cKn, d.e.cp_cont_g, 1);
            aj.c(this.gGr, d.e.cp_cont_g, 1);
            aj.c(this.gGs, d.e.cp_link_tip_a, 1);
        }

        public void onChangeSkinType(int i) {
            if (this.aoN != i) {
                initResource();
                this.aoN = i;
            }
        }
    }

    private boolean byY() {
        return 2 == this.gGl || 3 == this.gGl || 1 == this.gGl || 3 == this.gGl || "frs".equals(this.from) || "pb".equals(this.from) || AlbumActivityConfig.FROM_WRITE.equals(this.from) || "main_tab".equals(this.from) || "from_writeActivity_livePhoto".equals(this.from);
    }

    private void byZ() {
        if (this.gGo == null) {
            this.gGo = new a(LayoutInflater.from(getActivity()).inflate(d.j.dialog_img_water_setting, (ViewGroup) null));
        }
        this.bEq = new AlertDialog.Builder(getActivity()).create();
        this.bEq.show();
        Window window = this.bEq.getWindow();
        WindowManager.LayoutParams attributes = window.getAttributes();
        attributes.dimAmount = 0.5f;
        attributes.width = -2;
        attributes.height = -2;
        attributes.y = 0 - (com.baidu.adp.lib.util.l.af(getActivity()) / 5);
        window.setAttributes(attributes);
        window.setContentView(this.gGo.getView());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.adp.base.BdBaseFragmentActivity, android.support.v4.app.FragmentActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        if (this.bEq != null) {
            com.baidu.adp.lib.g.e.fP().postDelayed(new Runnable() { // from class: com.baidu.tieba.write.album.AlbumActivity.1
                @Override // java.lang.Runnable
                public void run() {
                    AlbumActivity.this.bEq.dismiss();
                }
            }, 3000L);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.adp.base.BdBaseFragmentActivity, android.support.v4.app.FragmentActivity, android.app.Activity
    public void onPause() {
        super.onPause();
        if (this.bEq != null) {
            this.bEq.dismiss();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.support.v4.app.FragmentActivity, android.app.Activity
    public void onSaveInstanceState(Bundle bundle) {
        bundle.putString(AlbumActivityConfig.WRITE_IMAGES_INFO, this.gGi.getWriteImagesInfo().toJsonString());
        bundle.putBoolean(AlbumActivityConfig.USE_ORIGINAL_IMG, this.gGp);
    }

    private void initData(Bundle bundle) {
        this.gGi = new e(this);
        if (bundle != null) {
            WriteImagesInfo writeImagesInfo = new WriteImagesInfo();
            writeImagesInfo.parseJson(bundle.getString(AlbumActivityConfig.WRITE_IMAGES_INFO));
            this.gGi.setWriteImagesInfo(writeImagesInfo);
            this.gGi.ta(bundle.getString(AlbumActivityConfig.CAMERA_PHOTO_NAME));
            this.gGp = bundle.getBoolean(AlbumActivityConfig.USE_ORIGINAL_IMG, false);
            return;
        }
        Intent intent = getIntent();
        if (intent != null) {
            WriteImagesInfo writeImagesInfo2 = new WriteImagesInfo();
            writeImagesInfo2.parseJson(intent.getStringExtra(AlbumActivityConfig.WRITE_IMAGES_INFO));
            this.gGi.setWriteImagesInfo(writeImagesInfo2);
            this.gGi.setOriginalImg(writeImagesInfo2.isOriginalImg());
            this.gGi.ta(intent.getStringExtra(AlbumActivityConfig.CAMERA_PHOTO_NAME));
            this.gGl = intent.getIntExtra(AlbumActivityConfig.CAMERA_REQUEST_FROM, 0);
            this.from = intent.getStringExtra("from");
            this.fid = intent.getStringExtra("forum_id");
            this.gFI = (ForumWriteData) intent.getSerializableExtra(AlbumActivityConfig.KEY_FORUM_WRITE_DATA);
            if ("from_writeActivity_livePhoto".equals(this.from)) {
                this.gGn = true;
            } else {
                this.gGn = false;
            }
            if (this.gGl == 2) {
                this.gGm = new h() { // from class: com.baidu.tieba.write.album.AlbumActivity.2
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
            this.gGi.np(intent.getBooleanExtra(AlbumActivityConfig.AUTO_PHOTO_NAME, false));
            this.gGp = intent.getBooleanExtra(AlbumActivityConfig.USE_ORIGINAL_IMG, false);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity
    protected void onChangeSkinType(int i) {
        this.gGj.onChangeSkinType(i);
        if (this.gGo != null) {
            this.gGo.onChangeSkinType(i);
        }
    }

    public void bza() {
        if (this.gGl == 3) {
            TiebaStatic.log("c10489");
        }
        if (this.gGl == 5) {
            showLoadingDialog("正在上传");
            new b().execute(new String[0]);
            return;
        }
        Intent intent = new Intent();
        intent.putExtra(AlbumActivityConfig.ALBUM_RESULT, this.gGi.getWriteImagesInfo().toJsonString());
        intent.putExtra(AlbumActivityConfig.CAMERA_REQUEST_FROM, this.gGl);
        setResult(-1, intent);
        finish();
    }

    @Override // com.baidu.adp.base.BdBaseFragmentActivity, android.view.View.OnClickListener
    public void onClick(View view) {
        int currentIndex;
        if (view == this.gGj.bzi()) {
            bza();
        } else if (view == this.gGj.bzk()) {
            if (this.gGi.getWriteImagesInfo() != null && this.gGi.getWriteImagesInfo().getChosedFiles() != null && this.gGi.getWriteImagesInfo().getChosedFiles().size() == 0 && this.gGj.bzn() != null && v.t(this.gGi.bzu()) > 0 && (currentIndex = this.gGj.bzn().getCurrentIndex()) >= 0) {
                d(this.gGi.bzu().get(currentIndex));
            }
            bza();
        } else if (view == this.gGj.bzh()) {
            if (this.gGi != null) {
                this.gGi.setLastAlbumId(null);
            }
            bzf();
        } else if (view == this.gGj.bzj()) {
            uL(0);
        } else if (view == this.gGj.bzl()) {
            uK(2);
        } else if (view == this.gGj.bzm()) {
            uK(1);
        }
    }

    private void uK(int i) {
        if (this.gGj != null && this.gGi != null) {
            this.gGi.setOriginalImg(!this.gGi.isOriginalImg());
            if (this.gGi.isOriginalImg()) {
                if (!StringUtils.isNull(this.from, true) && !StringUtils.isNull(this.fid, true)) {
                    TiebaStatic.log(new ak("c10349").ac("fid", this.fid).ac("obj_type", this.from).r("obj_locate", i));
                }
                bzb();
                return;
            }
            if (this.gGj.bzn() != null) {
                this.gGj.bzn().no(false);
            }
            if (this.gGj.bzo() != null) {
                this.gGj.bzo().no(false);
            }
        }
    }

    public void bzb() {
        if (this.gGj != null && this.gGi != null && this.gGi.bzs() != null && this.gGi.isOriginalImg()) {
            if (this.gGj.bzn() != null) {
                this.gGj.bzn().no(true);
            }
            if (this.gGj.bzo() != null) {
                this.gGj.bzo().no(true);
            }
        }
    }

    public void iv(String str) {
        this.bpl = str;
        g.a(getPageContext(), this.bpl, this.gGj.bzg());
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public e bzc() {
        return this.gGi;
    }

    public com.baidu.tbadk.img.b aLP() {
        return this.axk;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void uL(int i) {
        if (!this.gGk) {
            FragmentTransaction beginTransaction = getSupportFragmentManager().beginTransaction();
            Fragment findFragmentByTag = getSupportFragmentManager().findFragmentByTag(this.gGj.uN(this.mCurrentPage));
            if (findFragmentByTag != null) {
                beginTransaction.hide(findFragmentByTag);
                this.axk.Ee();
            }
            this.mCurrentPage = i;
            if (getSupportFragmentManager().findFragmentByTag(this.gGj.uN(i)) != null) {
                beginTransaction.show(this.gGj.uM(i));
            } else {
                beginTransaction.add(d.h.fragment, this.gGj.uM(i), this.gGj.uN(i));
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
        int maxImagesAllowed = this.gGi.getMaxImagesAllowed();
        if (this.gGi.size() < maxImagesAllowed) {
            if (this.gGm == null || this.gGm.f(imageFileInfo)) {
                ImageFileInfo imageFileInfo2 = new ImageFileInfo();
                imageFileInfo2.setAlbumnId(imageFileInfo.getAlbumId());
                imageFileInfo2.setFilePath(imageFileInfo.getFilePath());
                imageFileInfo2.setModifyTime(imageFileInfo.getModifyTime());
                imageFileInfo2.setIsGif(imageFileInfo.isGif());
                imageFileInfo2.setIsLong(imageFileInfo.isLong());
                this.gGi.addChooseFile(imageFileInfo2);
                bzb();
                return true;
            }
            return false;
        } else if (bzd()) {
            return d(imageFileInfo);
        } else {
            showToast(String.format(getPageContext().getContext().getString(d.l.album_beyond_max_choose), Integer.valueOf(maxImagesAllowed)));
            return false;
        }
    }

    public boolean bzd() {
        if (getIntent().getBooleanExtra(AlbumActivityConfig.IS_SELECT_DIRECTLY, false)) {
            int maxImagesAllowed = this.gGi.getMaxImagesAllowed();
            if (this.gGi.size() == maxImagesAllowed && maxImagesAllowed == 1) {
                try {
                    ImageFileInfo imageFileInfo = this.gGi.getWriteImagesInfo().getChosedFiles().get(0);
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
        this.gGi.delChooseFile(imageFileInfo);
        bzb();
        return true;
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity, android.support.v4.app.FragmentActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i == 4) {
            if (this.mCurrentPage == 0) {
                if (this.gGj.bzo() != null && !this.gGj.bzo().bzE()) {
                    this.gGj.bzo().bzA();
                    this.gGj.bzo().ns(true);
                    this.gGj.bzo().boW();
                    return true;
                }
                if (this.gGi != null) {
                    this.gGi.setLastAlbumId(null);
                }
                bzf();
                return true;
            } else if (this.mCurrentPage == 1) {
                uL(0);
                return true;
            } else {
                return true;
            }
        }
        return super.onKeyDown(i, keyEvent);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void F(int i, boolean z) {
        Fragment uM;
        int i2 = i + 3;
        if (this.gGj != null && (uM = this.gGj.uM(0)) != null && (uM instanceof l)) {
            ((l) uM).G(i2, z);
        }
    }

    void f(ImageFileInfo imageFileInfo, boolean z) {
        Fragment uM;
        if (this.gGj != null && (uM = this.gGj.uM(0)) != null && (uM instanceof l)) {
            ((l) uM).h(imageFileInfo, z);
        }
    }

    private void bze() {
        Fragment uM;
        if (this.gGj != null && (uM = this.gGj.uM(0)) != null && (uM instanceof l)) {
            ((l) uM).refresh();
        }
    }

    void g(ImageFileInfo imageFileInfo, boolean z) {
        Fragment uM;
        if (this.gGj != null && (uM = this.gGj.uM(1)) != null && (uM instanceof com.baidu.tieba.write.album.b)) {
            ((com.baidu.tieba.write.album.b) uM).h(imageFileInfo, z);
        }
    }

    private void bzf() {
        Intent intent = new Intent();
        String lastAlbumId = this.gGi.getLastAlbumId();
        if (TextUtils.isEmpty(lastAlbumId)) {
            lastAlbumId = "";
        }
        intent.putExtra(AlbumActivityConfig.LAST_ALBUM_ID, lastAlbumId);
        intent.putExtra(AlbumActivityConfig.CAMERA_REQUEST_FROM, this.gGl);
        setResult(0, intent);
        finish();
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity, android.app.Activity
    public void finish() {
        if (this.gGj != null && this.gGj.bzo() != null && this.gGj.bzo().bzg() != null) {
            this.gGj.bzo().bzg().stopCamera();
        }
        super.finish();
    }

    public void boT() {
        sY(this.gGi.bzx());
    }

    private void sY(String str) {
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
            if (this.gGi.bzu() != null && this.gGi.bzu().size() > 0) {
                this.gGi.bzu().add(0, imageFileInfo);
                d(imageFileInfo);
                this.gGi.setCurrentIndex(this.gGi.bzu().indexOf(imageFileInfo));
                bze();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.adp.base.BdBaseFragmentActivity, android.support.v4.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        this.gGk = true;
        if (this.gGj != null) {
            this.gGj.onDestroy();
        }
        this.axk.Ee();
        f.bzz().destory();
    }

    @Override // android.app.Activity, com.baidu.b.a.a.InterfaceC0022a
    public void onRequestPermissionsResult(int i, String[] strArr, int[] iArr) {
        if (i == 1) {
            if (ab.aJ(getApplicationContext())) {
                ai.b(getPageContext(), this.bpl);
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
            new com.baidu.tbadk.img.f(null).c(AlbumActivity.this.gGi.getWriteImagesInfo(), true);
            return AlbumActivity.this.gGi.getWriteImagesInfo().toJsonString();
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
