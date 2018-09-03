package com.baidu.tieba.write.album;

import android.app.Activity;
import android.content.Intent;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.e.a.a;
import com.baidu.sapi2.passhost.pluginsdk.service.IEventCenterService;
import com.baidu.tbadk.ActivityPendingTransitionFactory;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.album.VideoFileInfo;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tbadk.core.atomData.AlbumActivityConfig;
import com.baidu.tbadk.core.atomData.ImageViewerConfig;
import com.baidu.tbadk.core.atomData.RecordVideoActivityConfig;
import com.baidu.tbadk.core.atomData.WriteMulitImageActivityConfig;
import com.baidu.tbadk.core.frameworkData.IntentConfig;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.core.util.w;
import com.baidu.tbadk.img.ImageFileInfo;
import com.baidu.tbadk.img.WriteImagesInfo;
import com.baidu.tieba.f;
import com.baidu.tieba.frs.ForumWriteData;
/* loaded from: classes3.dex */
public class AlbumActivity extends BaseFragmentActivity implements View.OnClickListener, a.InterfaceC0062a {
    private boolean dpG;
    private com.baidu.tieba.c.d fEb;
    private c htC;
    private com.baidu.tieba.write.album.a htD;
    private e htF;
    private i htL;
    private int mCurrentPage = 0;
    private boolean htE = false;
    private String callFrom = "";
    private String from = "";
    private String forumName = "";
    private String forumId = "0";
    private int htG = 0;
    private int htH = 0;
    private boolean htI = false;
    private boolean htJ = false;
    private int htK = 0;
    private View dov = null;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.adp.base.BdBaseFragmentActivity, android.support.v4.app.FragmentActivity, android.support.v4.app.SupportActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setSwipeBackEnabled(false);
        setContentView(f.h.album_activity);
        this.dov = findViewById(f.g.statebar_view);
        this.dpG = UtilHelper.canUseStyleImmersiveSticky();
        Ud();
        initData(bundle);
        this.htD = new com.baidu.tieba.write.album.a(this);
        this.htD.aAZ();
        vn(0);
    }

    public void showTip(View view) {
        if (this.fEb == null && view != null) {
            this.fEb = new com.baidu.tieba.c.d(getPageContext(), view);
            this.fEb.jo(f.C0146f.bg_tip_blue_up_left);
            this.fEb.k(new View.OnClickListener() { // from class: com.baidu.tieba.write.album.AlbumActivity.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    AlbumActivity.this.fEb.akO();
                }
            });
            this.fEb.jn(16);
            this.fEb.jp(5000);
        }
        if (this.fEb != null) {
            String sharedPrefKeyWithAccount = com.baidu.tbadk.core.sharedPref.b.getSharedPrefKeyWithAccount("key_show_take_photo_tip");
            this.fEb.aO(getString(f.j.album_take_photo_tip), sharedPrefKeyWithAccount);
        }
    }

    private void Ud() {
        if (this.dov != null) {
            if (this.dpG && this.dov.getLayoutParams() != null) {
                ViewGroup.LayoutParams layoutParams = this.dov.getLayoutParams();
                layoutParams.height = UtilHelper.getStatusBarHeight();
                this.dov.setLayoutParams(layoutParams);
                fP(true);
                return;
            }
            fP(false);
        }
    }

    private void fP(boolean z) {
        if (this.dov != null) {
            if (this.dpG && z && this.dov.getVisibility() != 0) {
                this.dov.setVisibility(0);
            } else if (!z && this.dov.getVisibility() != 8) {
                this.dov.setVisibility(8);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.support.v4.app.FragmentActivity, android.support.v4.app.SupportActivity, android.app.Activity
    public void onSaveInstanceState(Bundle bundle) {
        bundle.putString(AlbumActivityConfig.WRITE_IMAGES_INFO, this.htC.getWriteImagesInfo().toJsonString());
        bundle.putBoolean(AlbumActivityConfig.USE_ORIGINAL_IMG, this.htI);
        bundle.putInt(AlbumActivityConfig.CAMERA_REQUEST_FROM, this.htG);
        bundle.putString("forum_id", this.forumId);
        bundle.putString("forum_name", this.forumName);
        bundle.putInt(IntentConfig.KEY_ALBUM_THREAD, this.htH);
        bundle.putBoolean(IntentConfig.KEY_FROM_WRITEACTIVITY, this.htJ);
    }

    private void initData(Bundle bundle) {
        this.htC = new c(this);
        if (bundle != null) {
            WriteImagesInfo writeImagesInfo = new WriteImagesInfo();
            writeImagesInfo.parseJson(bundle.getString(AlbumActivityConfig.WRITE_IMAGES_INFO));
            this.htC.setWriteImagesInfo(writeImagesInfo);
            this.htI = bundle.getBoolean(AlbumActivityConfig.USE_ORIGINAL_IMG, false);
            this.htG = bundle.getInt(AlbumActivityConfig.CAMERA_REQUEST_FROM, 0);
            this.forumId = bundle.getString("forum_id");
            this.forumName = bundle.getString("forum_name");
            this.htH = bundle.getInt(IntentConfig.KEY_ALBUM_THREAD);
            this.htJ = bundle.getBoolean(IntentConfig.KEY_FROM_WRITEACTIVITY);
            this.callFrom = bundle.getString("KEY_CALL_FROM");
            this.htK = bundle.getInt("from_type");
        } else {
            Intent intent = getIntent();
            if (intent != null) {
                WriteImagesInfo writeImagesInfo2 = new WriteImagesInfo();
                writeImagesInfo2.parseJson(intent.getStringExtra(AlbumActivityConfig.WRITE_IMAGES_INFO));
                this.htC.setWriteImagesInfo(writeImagesInfo2);
                this.htC.setOriginalImg(writeImagesInfo2.isOriginalImg());
                this.htI = intent.getBooleanExtra(AlbumActivityConfig.USE_ORIGINAL_IMG, false);
                this.htG = intent.getIntExtra(AlbumActivityConfig.CAMERA_REQUEST_FROM, 0);
                this.from = intent.getStringExtra("from");
                this.forumId = intent.getStringExtra("forum_id");
                this.forumName = intent.getStringExtra("forum_name");
                this.htH = intent.getIntExtra(IntentConfig.KEY_ALBUM_THREAD, 0);
                this.htJ = intent.getBooleanExtra(IntentConfig.KEY_FROM_WRITEACTIVITY, false);
                this.callFrom = intent.getStringExtra("KEY_CALL_FROM");
                this.htK = intent.getIntExtra("from_type", 0);
            }
        }
        bFE();
    }

    private void bFE() {
        if (this.htG == 2) {
            this.htF = new e() { // from class: com.baidu.tieba.write.album.AlbumActivity.2
                @Override // com.baidu.tieba.write.album.e
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
                    AlbumActivity.this.showToastWithIcon(AlbumActivity.this.getPageContext().getPageActivity().getString(f.j.uploade_attation), f.C0146f.icon_toast_game_error);
                    return false;
                }
            };
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity
    protected void onChangeSkinType(int i) {
        if (this.htD != null) {
            this.htD.onChangeSkinType(i);
        }
        am.e(this.dov, f.d.cp_bg_line_d, i);
    }

    public void bFF() {
        if (this.htG == 3) {
            TiebaStatic.log("c10489");
        }
        if (this.htG == 5) {
            showLoadingDialog("正在上传");
            new a().execute(new String[0]);
        } else if (this.htC != null) {
            if (this.htL == null || !this.htL.bGs()) {
                if (this.htC.bFZ()) {
                    VideoFileInfo bFX = this.htC.bFX();
                    if (this.htL == null) {
                        this.htL = new i(this, this.forumName, this.forumId, "");
                        if (this.htD != null) {
                            this.htD.a(this.htL);
                        }
                    }
                    this.htL.a(bFX, this.callFrom);
                } else if (w.y(this.htC.bGb()) == 1 && this.htK == 0) {
                    bFG();
                } else {
                    ab(null);
                }
            }
        }
    }

    private void ab(Intent intent) {
        Intent intent2 = new Intent();
        intent2.putExtra(AlbumActivityConfig.ALBUM_RESULT, this.htC.getWriteImagesInfo().toJsonString());
        intent2.putExtra(AlbumActivityConfig.CAMERA_REQUEST_FROM, this.htG);
        intent2.putExtra("from_type", this.htK);
        if (intent != null && !StringUtils.isNull(intent.getStringExtra("file_name"))) {
            intent2.putExtra("file_name", intent.getStringExtra("file_name"));
        }
        setResult(-1, intent2);
        finish();
    }

    private boolean abK() {
        Activity pageActivity = getPageContext().getPageActivity();
        com.baidu.tbadk.core.util.b.a aVar = new com.baidu.tbadk.core.util.b.a();
        aVar.zW();
        aVar.c(pageActivity, "android.permission.CAMERA");
        aVar.c(pageActivity, "android.permission.RECORD_AUDIO");
        aVar.c(pageActivity, "android.permission.WRITE_EXTERNAL_STORAGE");
        return aVar.u(pageActivity);
    }

    public void b(TbPageContext tbPageContext) {
        if (!abK() && com.baidu.tieba.write.e.bFy()) {
            sendMessage(new CustomMessage(2002001, new RecordVideoActivityConfig(tbPageContext.getPageActivity(), this.htJ ? 2 : 3, new ForumWriteData(this.forumId, this.forumName, null, null), this.htC.getWriteImagesInfo(), "", this.htK)));
            TiebaStatic.log(new an("c12611").r("obj_locate", 5).r("obj_type", 2));
        }
    }

    private void bFG() {
        WriteImagesInfo writeImagesInfo;
        if (this.htC != null && (writeImagesInfo = this.htC.getWriteImagesInfo()) != null) {
            sendMessage(new CustomMessage(2002001, new WriteMulitImageActivityConfig(getPageContext().getPageActivity(), IEventCenterService.EventId.EventMode.SAPIACCOUNT_THROUGH_SERVER, writeImagesInfo, 0)));
        }
    }

    private void ac(Intent intent) {
        if (intent == null || this.htC == null) {
            ab(null);
            return;
        }
        String stringExtra = intent.getStringExtra(AlbumActivityConfig.ALBUM_RESULT);
        if (stringExtra != null) {
            WriteImagesInfo writeImagesInfo = this.htC.getWriteImagesInfo();
            writeImagesInfo.parseJson(stringExtra);
            writeImagesInfo.updateQuality();
            ab(intent);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragmentActivity, android.support.v4.app.FragmentActivity, android.app.Activity
    public void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (i2 == -1) {
            ac(intent);
        }
    }

    @Override // com.baidu.adp.base.BdBaseFragmentActivity, android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.htD.bFP()) {
            bFF();
        } else if (view == this.htD.bFR()) {
            bFF();
        } else if (view == this.htD.bFO()) {
            if (this.htC != null) {
                this.htC.setLastAlbumId(null);
            }
            bFL();
        } else if (view == this.htD.bFQ()) {
            vn(0);
        } else if (view == this.htD.bFS()) {
            vl(2);
        } else if (view == this.htD.bFT()) {
            vl(1);
        }
    }

    private void vl(int i) {
        if (this.htD != null && this.htC != null) {
            this.htC.setOriginalImg(!this.htC.isOriginalImg());
            bFH();
            vm(i);
        }
    }

    private void vm(int i) {
        if (this.htC != null && this.htC.isOriginalImg() && !StringUtils.isNull(this.from, true) && !StringUtils.isNull(this.forumId, true)) {
            TiebaStatic.log(new an("c10349").ae(ImageViewerConfig.FORUM_ID, this.forumId).ae("obj_type", this.from).r("obj_locate", i));
        }
    }

    public void bFH() {
        if (this.htC != null && this.htD != null) {
            this.htD.ns(this.htC.isOriginalImg());
        }
    }

    public View auP() {
        return this.dov;
    }

    public int bFI() {
        return this.htH;
    }

    public c bFJ() {
        return this.htC;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void vn(int i) {
        if (!this.htE) {
            FragmentTransaction beginTransaction = getSupportFragmentManager().beginTransaction();
            Fragment findFragmentByTag = getSupportFragmentManager().findFragmentByTag(this.htD.vp(this.mCurrentPage));
            if (findFragmentByTag != null) {
                beginTransaction.hide(findFragmentByTag);
            }
            this.mCurrentPage = i;
            if (getSupportFragmentManager().findFragmentByTag(this.htD.vp(i)) != null) {
                beginTransaction.show(this.htD.vo(i));
            } else {
                beginTransaction.add(f.g.fragment, this.htD.vo(i), this.htD.vp(i));
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
        int maxImagesAllowed = this.htC.getMaxImagesAllowed();
        if (this.htC.size() < maxImagesAllowed) {
            if (this.htF == null || this.htF.e(imageFileInfo)) {
                ImageFileInfo imageFileInfo2 = new ImageFileInfo();
                imageFileInfo2.setAlbumnId(imageFileInfo.getAlbumId());
                imageFileInfo2.setFilePath(imageFileInfo.getFilePath());
                imageFileInfo2.setModifyTime(imageFileInfo.getModifyTime());
                imageFileInfo2.setIsGif(imageFileInfo.isGif());
                imageFileInfo2.setIsLong(imageFileInfo.isLong());
                this.htC.a(null);
                this.htC.addChooseFile(imageFileInfo2);
                bFH();
                return true;
            }
            return false;
        } else if (bFK()) {
            return c(imageFileInfo);
        } else {
            showToast(String.format(getPageContext().getContext().getString(f.j.album_beyond_max_choose), Integer.valueOf(maxImagesAllowed)));
            return false;
        }
    }

    public boolean bFK() {
        if (getIntent().getBooleanExtra(AlbumActivityConfig.IS_SELECT_DIRECTLY, false)) {
            int maxImagesAllowed = this.htC.getMaxImagesAllowed();
            if (this.htC.size() == maxImagesAllowed && maxImagesAllowed == 1) {
                try {
                    ImageFileInfo imageFileInfo = (ImageFileInfo) w.d(this.htC.bGb(), 0);
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
        this.htC.a(null);
        this.htC.delChooseFile(imageFileInfo);
        bFH();
        return true;
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i == 4) {
            closeLoadingDialog();
            if (this.mCurrentPage == 0) {
                if (this.htC != null) {
                    this.htC.setLastAlbumId(null);
                }
                bFL();
                return true;
            } else if (this.mCurrentPage == 1) {
                vn(0);
                return true;
            } else {
                return true;
            }
        }
        return super.onKeyDown(i, keyEvent);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void f(ImageFileInfo imageFileInfo, boolean z) {
        Fragment vo;
        if (this.htD != null && (vo = this.htD.vo(0)) != null && (vo instanceof ImageListFragment)) {
            ((ImageListFragment) vo).h(imageFileInfo, z);
        }
    }

    void g(ImageFileInfo imageFileInfo, boolean z) {
        Fragment vo;
        if (this.htD != null && (vo = this.htD.vo(1)) != null && (vo instanceof AlbumImageBrowseFragment)) {
            ((AlbumImageBrowseFragment) vo).h(imageFileInfo, z);
        }
    }

    private void bFL() {
        Intent intent = new Intent();
        String lastAlbumId = this.htC.getLastAlbumId();
        if (TextUtils.isEmpty(lastAlbumId)) {
            lastAlbumId = "";
        }
        intent.putExtra(AlbumActivityConfig.LAST_ALBUM_ID, lastAlbumId);
        intent.putExtra(AlbumActivityConfig.CAMERA_REQUEST_FROM, this.htG);
        setResult(0, intent);
        finish();
    }

    private void stopCamera() {
        if (this.htD != null) {
            this.htD.stopCamera();
        }
    }

    private void bFM() {
        if (this.htD != null) {
            this.htD.bFM();
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
        this.htE = true;
        stopCamera();
        closeLoadingDialog();
        dismissAllDialog();
        d.bGf().destory();
        if (this.dov != null) {
            this.dov.setBackgroundDrawable(null);
        }
        if (this.htD != null) {
            this.htD.onDestroy();
        }
        if (this.htL != null) {
            this.htL.onDestroy();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes3.dex */
    public class a extends BdAsyncTask<String, Integer, String> {
        private a() {
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public String doInBackground(String... strArr) {
            new com.baidu.tbadk.img.f(null).c(AlbumActivity.this.htC.getWriteImagesInfo(), true);
            return AlbumActivity.this.htC.getWriteImagesInfo().toJsonString();
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
        if (this.htL != null) {
            this.htL.onStart();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.adp.base.BdBaseFragmentActivity, android.support.v4.app.FragmentActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        bFM();
        if (this.htL != null) {
            this.htL.onResume();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.base.BdBaseFragmentActivity, android.support.v4.app.FragmentActivity, android.app.Activity
    public void onStop() {
        super.onStop();
        if (this.htL != null) {
            this.htL.onStop();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.adp.base.BdBaseFragmentActivity, android.support.v4.app.FragmentActivity, android.app.Activity
    public void onPause() {
        stopCamera();
        super.onPause();
    }
}
