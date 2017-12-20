package com.baidu.tieba.write.album;

import android.content.Intent;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.util.ArrayMap;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.c.a.a;
import com.baidu.sapi2.passhost.pluginsdk.service.IEventCenterService;
import com.baidu.tbadk.ActivityPendingTransitionFactory;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.album.VideoFileInfo;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tbadk.core.atomData.AlbumActivityConfig;
import com.baidu.tbadk.core.atomData.ImageViewerConfig;
import com.baidu.tbadk.core.atomData.RecordVideoActivityConfig;
import com.baidu.tbadk.core.atomData.WriteMulitImageActivityConfig;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.frameworkData.IntentConfig;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.ab;
import com.baidu.tbadk.core.util.aj;
import com.baidu.tbadk.core.util.ak;
import com.baidu.tbadk.core.util.v;
import com.baidu.tbadk.img.ImageFileInfo;
import com.baidu.tbadk.img.WriteImagesInfo;
import com.baidu.tieba.d;
import com.baidu.tieba.frs.ForumWriteData;
/* loaded from: classes2.dex */
public class AlbumActivity extends BaseFragmentActivity implements View.OnClickListener, a.InterfaceC0023a {
    private boolean cKs;
    private com.baidu.tieba.d.b fbo;
    private e heY;
    private com.baidu.tieba.write.album.a heZ;
    private g hfb;
    private l hfg;
    private int mCurrentPage = 0;
    private boolean hfa = false;
    private String callFrom = "";
    private String from = "";
    private String forumName = "";
    private String forumId = "0";
    private int hfc = 0;
    private int hfd = 0;
    private boolean hfe = false;
    private boolean fHA = false;
    private boolean hff = false;
    private View cIW = null;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.adp.base.BdBaseFragmentActivity, android.support.v4.app.FragmentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setSwipeBackEnabled(false);
        setContentView(d.h.album_activity);
        this.cIW = findViewById(d.g.statebar_view);
        this.cKs = UtilHelper.canUseStyleImmersiveSticky();
        amH();
        initData(bundle);
        this.heZ = new com.baidu.tieba.write.album.a(this);
        this.heZ.aPQ();
        vQ(0);
    }

    public void showTip(View view) {
        if (this.fbo == null && view != null) {
            this.fbo = new com.baidu.tieba.d.b(getPageContext(), view);
            this.fbo.iU(d.f.bg_tip_blue_up_left);
            this.fbo.j(new View.OnClickListener() { // from class: com.baidu.tieba.write.album.AlbumActivity.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    AlbumActivity.this.fbo.adI();
                }
            });
            this.fbo.iT(16);
            this.fbo.iV(5000);
        }
        if (this.fbo != null) {
            String sharedPrefKeyWithAccount = com.baidu.tbadk.core.sharedPref.b.getSharedPrefKeyWithAccount("key_show_take_photo_tip");
            this.fbo.aL(getString(d.j.album_take_photo_tip), sharedPrefKeyWithAccount);
        }
    }

    private void amH() {
        if (this.cIW != null) {
            if (this.cKs && this.cIW.getLayoutParams() != null) {
                ViewGroup.LayoutParams layoutParams = this.cIW.getLayoutParams();
                layoutParams.height = UtilHelper.getStatusBarHeight();
                this.cIW.setLayoutParams(layoutParams);
                fe(true);
                return;
            }
            fe(false);
        }
    }

    private void fe(boolean z) {
        if (this.cIW != null) {
            if (this.cKs && z && this.cIW.getVisibility() != 0) {
                this.cIW.setVisibility(0);
            } else if (!z && this.cIW.getVisibility() != 8) {
                this.cIW.setVisibility(8);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.support.v4.app.FragmentActivity, android.app.Activity
    public void onSaveInstanceState(Bundle bundle) {
        bundle.putString(AlbumActivityConfig.WRITE_IMAGES_INFO, this.heY.getWriteImagesInfo().toJsonString());
        bundle.putBoolean(AlbumActivityConfig.USE_ORIGINAL_IMG, this.hfe);
        bundle.putInt(AlbumActivityConfig.CAMERA_REQUEST_FROM, this.hfc);
        bundle.putString("forum_id", this.forumId);
        bundle.putString("forum_name", this.forumName);
        bundle.putInt(IntentConfig.KEY_ALBUM_THREAD, this.hfd);
        bundle.putBoolean("from_write", this.fHA);
    }

    private void initData(Bundle bundle) {
        this.heY = new e(this);
        if (bundle != null) {
            WriteImagesInfo writeImagesInfo = new WriteImagesInfo();
            writeImagesInfo.parseJson(bundle.getString(AlbumActivityConfig.WRITE_IMAGES_INFO));
            this.heY.setWriteImagesInfo(writeImagesInfo);
            this.hfe = bundle.getBoolean(AlbumActivityConfig.USE_ORIGINAL_IMG, false);
            this.hfc = bundle.getInt(AlbumActivityConfig.CAMERA_REQUEST_FROM, 0);
            this.forumId = bundle.getString("forum_id");
            this.forumName = bundle.getString("forum_name");
            this.hfd = bundle.getInt(IntentConfig.KEY_ALBUM_THREAD);
            this.fHA = bundle.getBoolean("from_write");
            this.callFrom = bundle.getString("KEY_CALL_FROM");
            this.hff = bundle.getBoolean(IntentConfig.KEY_FROM_IM);
        } else {
            Intent intent = getIntent();
            if (intent != null) {
                WriteImagesInfo writeImagesInfo2 = new WriteImagesInfo();
                writeImagesInfo2.parseJson(intent.getStringExtra(AlbumActivityConfig.WRITE_IMAGES_INFO));
                this.heY.setWriteImagesInfo(writeImagesInfo2);
                this.heY.setOriginalImg(writeImagesInfo2.isOriginalImg());
                this.hfe = intent.getBooleanExtra(AlbumActivityConfig.USE_ORIGINAL_IMG, false);
                this.hfc = intent.getIntExtra(AlbumActivityConfig.CAMERA_REQUEST_FROM, 0);
                this.from = intent.getStringExtra("from");
                this.forumId = intent.getStringExtra("forum_id");
                this.forumName = intent.getStringExtra("forum_name");
                this.hfd = intent.getIntExtra(IntentConfig.KEY_ALBUM_THREAD, 0);
                this.fHA = intent.getBooleanExtra("from_write", false);
                this.callFrom = intent.getStringExtra("KEY_CALL_FROM");
                this.hff = intent.getBooleanExtra(IntentConfig.KEY_FROM_IM, false);
            }
        }
        bFU();
    }

    private void bFU() {
        if (this.hfc == 2) {
            this.hfb = new g() { // from class: com.baidu.tieba.write.album.AlbumActivity.2
                @Override // com.baidu.tieba.write.album.g
                public boolean e(ImageFileInfo imageFileInfo) {
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
                    AlbumActivity.this.showToastWithIcon(AlbumActivity.this.getPageContext().getPageActivity().getString(d.j.uploade_attation), d.f.icon_toast_game_error);
                    return false;
                }
            };
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity
    protected void onChangeSkinType(int i) {
        if (this.heZ != null) {
            this.heZ.onChangeSkinType(i);
        }
        aj.e(this.cIW, d.C0096d.cp_bg_line_d, i);
    }

    public void bFV() {
        if (this.hfc == 3) {
            TiebaStatic.log("c10489");
        }
        if (this.hfc == 5) {
            showLoadingDialog("正在上传");
            new a().execute(new String[0]);
        } else if (this.heY != null) {
            if (this.hfg == null || !this.hfg.bGD()) {
                if (this.heY.bGp()) {
                    VideoFileInfo bGn = this.heY.bGn();
                    if (this.hfg == null) {
                        this.hfg = new l(this, this.forumName, this.forumId, "");
                        if (this.heZ != null) {
                            this.heZ.a(this.hfg);
                        }
                    }
                    this.hfg.a(bGn, this.callFrom);
                } else if (v.v(this.heY.bGr()) == 1 && !this.hff) {
                    bFW();
                } else {
                    ae(null);
                }
            }
        }
    }

    private void ae(Intent intent) {
        Intent intent2 = new Intent();
        intent2.putExtra(AlbumActivityConfig.ALBUM_RESULT, this.heY.getWriteImagesInfo().toJsonString());
        intent2.putExtra(AlbumActivityConfig.CAMERA_REQUEST_FROM, this.hfc);
        intent2.putExtra(IntentConfig.KEY_FROM_IM, this.hff);
        if (intent != null && !StringUtils.isNull(intent.getStringExtra("file_name"))) {
            intent2.putExtra("file_name", intent.getStringExtra("file_name"));
        }
        setResult(-1, intent2);
        finish();
    }

    public void c(TbPageContext tbPageContext) {
        if (com.baidu.tieba.write.f.bFN()) {
            sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new RecordVideoActivityConfig(tbPageContext.getPageActivity(), this.fHA ? 2 : 3, new ForumWriteData(this.forumId, this.forumName, null, null), this.heY.getWriteImagesInfo(), "")));
            TiebaStatic.log(new ak("c12611").r("obj_locate", 5).r("obj_type", 2));
        }
    }

    private void bFW() {
        WriteImagesInfo writeImagesInfo;
        if (this.heY != null && (writeImagesInfo = this.heY.getWriteImagesInfo()) != null) {
            sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new WriteMulitImageActivityConfig(getPageContext().getPageActivity(), IEventCenterService.EventId.EventMode.SAPIACCOUNT_THROUGH_SERVER, writeImagesInfo, 0)));
        }
    }

    private void af(Intent intent) {
        if (intent == null || this.heY == null) {
            ae(null);
            return;
        }
        String stringExtra = intent.getStringExtra(AlbumActivityConfig.ALBUM_RESULT);
        if (stringExtra != null) {
            WriteImagesInfo writeImagesInfo = this.heY.getWriteImagesInfo();
            writeImagesInfo.parseJson(stringExtra);
            writeImagesInfo.updateQuality();
            ae(intent);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.support.v4.app.FragmentActivity, android.app.Activity
    public void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (i2 == -1) {
            af(intent);
        }
    }

    @Override // com.baidu.adp.base.BdBaseFragmentActivity, android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.heZ.bGf()) {
            bFV();
        } else if (view == this.heZ.bGh()) {
            bFV();
        } else if (view == this.heZ.bGe()) {
            if (this.heY != null) {
                this.heY.setLastAlbumId(null);
            }
            bGb();
        } else if (view == this.heZ.bGg()) {
            vQ(0);
        } else if (view == this.heZ.bGi()) {
            vO(2);
        } else if (view == this.heZ.bGj()) {
            vO(1);
        }
    }

    private void vO(int i) {
        if (this.heZ != null && this.heY != null) {
            this.heY.setOriginalImg(!this.heY.isOriginalImg());
            bFX();
            vP(i);
        }
    }

    private void vP(int i) {
        if (this.heY != null && this.heY.isOriginalImg() && !StringUtils.isNull(this.from, true) && !StringUtils.isNull(this.forumId, true)) {
            TiebaStatic.log(new ak("c10349").ac(ImageViewerConfig.FORUM_ID, this.forumId).ac("obj_type", this.from).r("obj_locate", i));
        }
    }

    public void bFX() {
        if (this.heY != null && this.heZ != null) {
            this.heZ.nX(this.heY.isOriginalImg());
        }
    }

    public View alJ() {
        return this.cIW;
    }

    public int bFY() {
        return this.hfd;
    }

    public e bFZ() {
        return this.heY;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void vQ(int i) {
        if (!this.hfa) {
            FragmentTransaction beginTransaction = getSupportFragmentManager().beginTransaction();
            Fragment findFragmentByTag = getSupportFragmentManager().findFragmentByTag(this.heZ.vS(this.mCurrentPage));
            if (findFragmentByTag != null) {
                beginTransaction.hide(findFragmentByTag);
            }
            this.mCurrentPage = i;
            if (getSupportFragmentManager().findFragmentByTag(this.heZ.vS(i)) != null) {
                beginTransaction.show(this.heZ.vR(i));
            } else {
                beginTransaction.add(d.g.fragment, this.heZ.vR(i), this.heZ.vS(i));
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
        int maxImagesAllowed = this.heY.getMaxImagesAllowed();
        if (this.heY.size() < maxImagesAllowed) {
            if (this.hfb == null || this.hfb.e(imageFileInfo)) {
                ImageFileInfo imageFileInfo2 = new ImageFileInfo();
                imageFileInfo2.setAlbumnId(imageFileInfo.getAlbumId());
                imageFileInfo2.setFilePath(imageFileInfo.getFilePath());
                imageFileInfo2.setModifyTime(imageFileInfo.getModifyTime());
                imageFileInfo2.setIsGif(imageFileInfo.isGif());
                imageFileInfo2.setIsLong(imageFileInfo.isLong());
                this.heY.a(null);
                this.heY.addChooseFile(imageFileInfo2);
                bFX();
                return true;
            }
            return false;
        } else if (bGa()) {
            return c(imageFileInfo);
        } else {
            showToast(String.format(getPageContext().getContext().getString(d.j.album_beyond_max_choose), Integer.valueOf(maxImagesAllowed)));
            return false;
        }
    }

    public boolean bGa() {
        if (getIntent().getBooleanExtra(AlbumActivityConfig.IS_SELECT_DIRECTLY, false)) {
            int maxImagesAllowed = this.heY.getMaxImagesAllowed();
            if (this.heY.size() == maxImagesAllowed && maxImagesAllowed == 1) {
                try {
                    ImageFileInfo imageFileInfo = (ImageFileInfo) v.c(this.heY.bGr(), 0);
                    if (d(imageFileInfo)) {
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
    public boolean d(ImageFileInfo imageFileInfo) {
        if (imageFileInfo == null) {
            return false;
        }
        this.heY.a(null);
        this.heY.delChooseFile(imageFileInfo);
        bFX();
        return true;
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity, android.support.v4.app.FragmentActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i == 4) {
            closeLoadingDialog();
            if (this.mCurrentPage == 0) {
                if (this.heY != null) {
                    this.heY.setLastAlbumId(null);
                }
                bGb();
                return true;
            } else if (this.mCurrentPage == 1) {
                vQ(0);
                return true;
            } else {
                return true;
            }
        }
        return super.onKeyDown(i, keyEvent);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void f(ImageFileInfo imageFileInfo, boolean z) {
        Fragment vR;
        if (this.heZ != null && (vR = this.heZ.vR(0)) != null && (vR instanceof k)) {
            ((k) vR).h(imageFileInfo, z);
        }
    }

    void g(ImageFileInfo imageFileInfo, boolean z) {
        Fragment vR;
        if (this.heZ != null && (vR = this.heZ.vR(1)) != null && (vR instanceof b)) {
            ((b) vR).h(imageFileInfo, z);
        }
    }

    private void bGb() {
        Intent intent = new Intent();
        String lastAlbumId = this.heY.getLastAlbumId();
        if (TextUtils.isEmpty(lastAlbumId)) {
            lastAlbumId = "";
        }
        intent.putExtra(AlbumActivityConfig.LAST_ALBUM_ID, lastAlbumId);
        intent.putExtra(AlbumActivityConfig.CAMERA_REQUEST_FROM, this.hfc);
        setResult(0, intent);
        finish();
    }

    private void stopCamera() {
        if (this.heZ != null) {
            this.heZ.stopCamera();
        }
    }

    private void bGc() {
        if (this.heZ != null) {
            this.heZ.bGc();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity, android.app.Activity
    public void finish() {
        super.finish();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.adp.base.BdBaseFragmentActivity, android.support.v4.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        this.hfa = true;
        stopCamera();
        closeLoadingDialog();
        dismissAllDialog();
        f.bGv().destory();
        if (this.cIW != null) {
            this.cIW.setBackgroundDrawable(null);
        }
        if (this.heZ != null) {
            this.heZ.onDestroy();
        }
        if (this.hfg != null) {
            this.hfg.onDestroy();
        }
    }

    @Override // android.app.Activity, com.baidu.c.a.a.InterfaceC0023a
    public void onRequestPermissionsResult(int i, String[] strArr, int[] iArr) {
        if (i == 1) {
            if (ab.aI(getApplicationContext())) {
                c(getPageContext());
            } else {
                showToast(d.j.system_permission_prompt_camera);
            }
            ArrayMap<String, Boolean> a2 = ab.a(strArr, iArr);
            if (a2.containsKey("android.permission.WRITE_EXTERNAL_STORAGE") && !a2.get("android.permission.WRITE_EXTERNAL_STORAGE").booleanValue()) {
                showToast(d.j.sdcard_permission_denied_advert_for_camera);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public class a extends BdAsyncTask<String, Integer, String> {
        private a() {
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: i */
        public String doInBackground(String... strArr) {
            new com.baidu.tbadk.img.f(null).c(AlbumActivity.this.heY.getWriteImagesInfo(), true);
            return AlbumActivity.this.heY.getWriteImagesInfo().toJsonString();
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

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.support.v4.app.FragmentActivity, android.app.Activity
    public void onStart() {
        super.onStart();
        if (this.hfg != null) {
            this.hfg.onStart();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.adp.base.BdBaseFragmentActivity, android.support.v4.app.FragmentActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        bGc();
        if (this.hfg != null) {
            this.hfg.onResume();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.base.BdBaseFragmentActivity, android.support.v4.app.FragmentActivity, android.app.Activity
    public void onStop() {
        super.onStop();
        if (this.hfg != null) {
            this.hfg.onStop();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.adp.base.BdBaseFragmentActivity, android.support.v4.app.FragmentActivity, android.app.Activity
    public void onPause() {
        stopCamera();
        super.onPause();
    }
}
