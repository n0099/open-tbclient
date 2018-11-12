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
import com.baidu.mapapi.UIMsg;
import com.baidu.sapi2.passhost.pluginsdk.service.IEventCenterService;
import com.baidu.tbadk.ActivityPendingTransitionFactory;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.album.VideoFileInfo;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.AlbumActivityConfig;
import com.baidu.tbadk.core.atomData.ImageViewerConfig;
import com.baidu.tbadk.core.atomData.RecordVideoActivityConfig;
import com.baidu.tbadk.core.atomData.WriteMulitImageActivityConfig;
import com.baidu.tbadk.core.frameworkData.IntentConfig;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.al;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.v;
import com.baidu.tbadk.img.ImageFileInfo;
import com.baidu.tbadk.img.WriteImagesInfo;
import com.baidu.tieba.e;
import com.baidu.tieba.frs.ForumWriteData;
/* loaded from: classes3.dex */
public class AlbumActivity extends BaseFragmentActivity implements View.OnClickListener, a.InterfaceC0073a {
    private boolean dFl;
    private com.baidu.tieba.c.d fUM;
    private Intent hKB;
    private i hKE;
    private c hKu;
    private com.baidu.tieba.write.album.a hKv;
    private e hKx;
    private int mCurrentPage = 0;
    private boolean hKw = false;
    private String callFrom = "";
    private String from = "";
    private String forumName = "";
    private String forumId = "0";
    private int hKy = 0;
    private int hKz = 0;
    private boolean hKA = false;
    private boolean hKC = false;
    private int hKD = 0;
    private View dDK = null;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.adp.base.BdBaseFragmentActivity, android.support.v4.app.FragmentActivity, android.support.v4.app.SupportActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setSwipeBackEnabled(false);
        setContentView(e.h.album_activity);
        this.dDK = findViewById(e.g.statebar_view);
        this.dFl = UtilHelper.canUseStyleImmersiveSticky();
        ZI();
        initData(bundle);
        this.hKv = new com.baidu.tieba.write.album.a(this);
        this.hKv.aFX();
        wD(0);
    }

    public void showTip(View view) {
        if (this.fUM == null && view != null) {
            this.fUM = new com.baidu.tieba.c.d(getPageContext(), view);
            this.fUM.kE(e.f.bg_tip_blue_up_left);
            this.fUM.n(new View.OnClickListener() { // from class: com.baidu.tieba.write.album.AlbumActivity.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    AlbumActivity.this.fUM.apA();
                }
            });
            this.fUM.kD(16);
            this.fUM.kF(UIMsg.m_AppUI.MSG_APP_GPS);
        }
        if (this.fUM != null) {
            String sharedPrefKeyWithAccount = com.baidu.tbadk.core.sharedPref.b.getSharedPrefKeyWithAccount("key_show_take_photo_tip");
            this.fUM.bj(getString(e.j.album_take_photo_tip), sharedPrefKeyWithAccount);
        }
    }

    private void ZI() {
        if (this.dDK != null) {
            if (this.dFl && this.dDK.getLayoutParams() != null) {
                ViewGroup.LayoutParams layoutParams = this.dDK.getLayoutParams();
                layoutParams.height = UtilHelper.getStatusBarHeight();
                this.dDK.setLayoutParams(layoutParams);
                gO(true);
                return;
            }
            gO(false);
        }
    }

    private void gO(boolean z) {
        if (this.dDK != null) {
            if (this.dFl && z && this.dDK.getVisibility() != 0) {
                this.dDK.setVisibility(0);
            } else if (!z && this.dDK.getVisibility() != 8) {
                this.dDK.setVisibility(8);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.support.v4.app.FragmentActivity, android.support.v4.app.SupportActivity, android.app.Activity
    public void onSaveInstanceState(Bundle bundle) {
        bundle.putString(AlbumActivityConfig.WRITE_IMAGES_INFO, this.hKu.getWriteImagesInfo().toJsonString());
        bundle.putBoolean(AlbumActivityConfig.USE_ORIGINAL_IMG, this.hKA);
        bundle.putInt(AlbumActivityConfig.CAMERA_REQUEST_FROM, this.hKy);
        bundle.putString("forum_id", this.forumId);
        bundle.putString("forum_name", this.forumName);
        bundle.putInt(IntentConfig.KEY_ALBUM_THREAD, this.hKz);
        bundle.putBoolean(IntentConfig.KEY_FROM_WRITEACTIVITY, this.hKC);
    }

    private void initData(Bundle bundle) {
        this.hKu = new c(this);
        if (bundle != null) {
            WriteImagesInfo writeImagesInfo = new WriteImagesInfo();
            writeImagesInfo.parseJson(bundle.getString(AlbumActivityConfig.WRITE_IMAGES_INFO));
            this.hKu.setWriteImagesInfo(writeImagesInfo);
            this.hKA = bundle.getBoolean(AlbumActivityConfig.USE_ORIGINAL_IMG, false);
            this.hKy = bundle.getInt(AlbumActivityConfig.CAMERA_REQUEST_FROM, 0);
            this.forumId = bundle.getString("forum_id");
            this.forumName = bundle.getString("forum_name");
            this.hKz = bundle.getInt(IntentConfig.KEY_ALBUM_THREAD);
            this.hKC = bundle.getBoolean(IntentConfig.KEY_FROM_WRITEACTIVITY);
            this.callFrom = bundle.getString("KEY_CALL_FROM");
            this.hKD = bundle.getInt("from_type");
        } else {
            Intent intent = getIntent();
            if (intent != null) {
                WriteImagesInfo writeImagesInfo2 = new WriteImagesInfo();
                writeImagesInfo2.parseJson(intent.getStringExtra(AlbumActivityConfig.WRITE_IMAGES_INFO));
                this.hKu.setWriteImagesInfo(writeImagesInfo2);
                this.hKu.setOriginalImg(writeImagesInfo2.isOriginalImg());
                this.hKA = intent.getBooleanExtra(AlbumActivityConfig.USE_ORIGINAL_IMG, false);
                this.hKy = intent.getIntExtra(AlbumActivityConfig.CAMERA_REQUEST_FROM, 0);
                this.from = intent.getStringExtra("from");
                this.forumId = intent.getStringExtra("forum_id");
                this.forumName = intent.getStringExtra("forum_name");
                this.hKz = intent.getIntExtra(IntentConfig.KEY_ALBUM_THREAD, 0);
                this.hKC = intent.getBooleanExtra(IntentConfig.KEY_FROM_WRITEACTIVITY, false);
                this.callFrom = intent.getStringExtra("KEY_CALL_FROM");
                this.hKD = intent.getIntExtra("from_type", 0);
            }
        }
        bLf();
    }

    private void bLf() {
        if (this.hKy == 2) {
            this.hKx = new e() { // from class: com.baidu.tieba.write.album.AlbumActivity.2
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
                    AlbumActivity.this.showToastWithIcon(AlbumActivity.this.getPageContext().getPageActivity().getString(e.j.uploade_attation), e.f.icon_toast_game_error);
                    return false;
                }
            };
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity
    protected void onChangeSkinType(int i) {
        if (this.hKv != null) {
            this.hKv.onChangeSkinType(i);
        }
        al.e(this.dDK, e.d.cp_bg_line_d, i);
    }

    public void bLg() {
        if (this.hKy == 3) {
            TiebaStatic.log("c10489");
        }
        if (this.hKy == 5) {
            showLoadingDialog("正在上传");
            new a().execute(new String[0]);
        } else if (this.hKu != null) {
            if (this.hKE == null || !this.hKE.bLT()) {
                if (this.hKu.bLA()) {
                    VideoFileInfo bLy = this.hKu.bLy();
                    if (this.hKE == null) {
                        this.hKE = new i(this, this.forumName, this.forumId, "");
                        if (this.hKv != null) {
                            this.hKv.a(this.hKE);
                        }
                    }
                    this.hKE.a(bLy, this.callFrom);
                } else if (v.H(this.hKu.bLC()) == 1 && this.hKD == 0) {
                    bLh();
                } else {
                    af(null);
                }
            }
        }
    }

    private void af(Intent intent) {
        Intent intent2 = new Intent();
        intent2.putExtra(AlbumActivityConfig.ALBUM_RESULT, this.hKu.getWriteImagesInfo().toJsonString());
        intent2.putExtra(AlbumActivityConfig.CAMERA_REQUEST_FROM, this.hKy);
        intent2.putExtra("from_type", this.hKD);
        if (intent != null && !StringUtils.isNull(intent.getStringExtra("file_name"))) {
            intent2.putExtra("file_name", intent.getStringExtra("file_name"));
        }
        setResult(-1, intent2);
        finish();
    }

    private boolean agD() {
        Activity pageActivity = getPageContext().getPageActivity();
        com.baidu.tbadk.core.util.b.a aVar = new com.baidu.tbadk.core.util.b.a();
        aVar.Dp();
        aVar.c(pageActivity, "android.permission.CAMERA");
        aVar.c(pageActivity, "android.permission.RECORD_AUDIO");
        aVar.c(pageActivity, "android.permission.WRITE_EXTERNAL_STORAGE");
        return aVar.A(pageActivity);
    }

    public void b(TbPageContext tbPageContext) {
        if (!agD() && com.baidu.tieba.write.e.bKZ()) {
            sendMessage(new CustomMessage(2002001, new RecordVideoActivityConfig(tbPageContext.getPageActivity(), this.hKC ? 2 : 3, new ForumWriteData(this.forumId, this.forumName, null, null), this.hKu.getWriteImagesInfo(), "", this.hKD)));
            TiebaStatic.log(new am("c12611").x("obj_locate", 5).x("obj_type", 2));
        }
    }

    private void bLh() {
        WriteImagesInfo writeImagesInfo;
        if (this.hKu != null && (writeImagesInfo = this.hKu.getWriteImagesInfo()) != null) {
            sendMessage(new CustomMessage(2002001, new WriteMulitImageActivityConfig(getPageContext().getPageActivity(), IEventCenterService.EventId.EventMode.SAPIACCOUNT_THROUGH_SERVER, writeImagesInfo, 0)));
        }
    }

    private void ag(Intent intent) {
        this.hKB = intent;
        if (intent == null || this.hKu == null) {
            af(null);
            return;
        }
        String stringExtra = intent.getStringExtra(AlbumActivityConfig.ALBUM_RESULT);
        if (stringExtra != null) {
            WriteImagesInfo writeImagesInfo = this.hKu.getWriteImagesInfo();
            writeImagesInfo.parseJson(stringExtra);
            writeImagesInfo.updateQuality();
            af(intent);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragmentActivity, android.support.v4.app.FragmentActivity, android.app.Activity
    public void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (i2 == -1) {
            ag(intent);
        }
    }

    @Override // com.baidu.adp.base.BdBaseFragmentActivity, android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.hKv.bLq()) {
            bLg();
        } else if (view == this.hKv.bLs()) {
            bLg();
        } else if (view == this.hKv.bLp()) {
            if (this.hKu != null) {
                this.hKu.setLastAlbumId(null);
            }
            bLm();
        } else if (view == this.hKv.bLr()) {
            wD(0);
        } else if (view == this.hKv.bLt()) {
            wB(2);
        } else if (view == this.hKv.bLu()) {
            wB(1);
        }
    }

    private void wB(int i) {
        if (this.hKv != null && this.hKu != null) {
            this.hKu.setOriginalImg(!this.hKu.isOriginalImg());
            bLi();
            wC(i);
        }
    }

    private void wC(int i) {
        if (this.hKu != null && this.hKu.isOriginalImg() && !StringUtils.isNull(this.from, true) && !StringUtils.isNull(this.forumId, true)) {
            TiebaStatic.log(new am("c10349").ax(ImageViewerConfig.FORUM_ID, this.forumId).ax("obj_type", this.from).x("obj_locate", i));
        }
    }

    public void bLi() {
        if (this.hKu != null && this.hKv != null) {
            this.hKv.ot(this.hKu.isOriginalImg());
        }
    }

    public View azC() {
        return this.dDK;
    }

    public int bLj() {
        return this.hKz;
    }

    public c bLk() {
        return this.hKu;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void wD(int i) {
        if (!this.hKw) {
            FragmentTransaction beginTransaction = getSupportFragmentManager().beginTransaction();
            Fragment findFragmentByTag = getSupportFragmentManager().findFragmentByTag(this.hKv.wF(this.mCurrentPage));
            if (findFragmentByTag != null) {
                beginTransaction.hide(findFragmentByTag);
            }
            this.mCurrentPage = i;
            if (getSupportFragmentManager().findFragmentByTag(this.hKv.wF(i)) != null) {
                beginTransaction.show(this.hKv.wE(i));
            } else {
                beginTransaction.add(e.g.fragment, this.hKv.wE(i), this.hKv.wF(i));
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
        int maxImagesAllowed = this.hKu.getMaxImagesAllowed();
        if (this.hKu.size() < maxImagesAllowed) {
            if (this.hKx == null || this.hKx.e(imageFileInfo)) {
                ImageFileInfo imageFileInfo2 = new ImageFileInfo();
                imageFileInfo2.setAlbumnId(imageFileInfo.getAlbumId());
                imageFileInfo2.setFilePath(imageFileInfo.getFilePath());
                imageFileInfo2.setModifyTime(imageFileInfo.getModifyTime());
                imageFileInfo2.setIsGif(imageFileInfo.isGif());
                imageFileInfo2.setIsLong(imageFileInfo.isLong());
                this.hKu.a(null);
                this.hKu.addChooseFile(imageFileInfo2);
                bLi();
                return true;
            }
            return false;
        } else if (bLl()) {
            return c(imageFileInfo);
        } else {
            showToast(String.format(getPageContext().getContext().getString(e.j.album_beyond_max_choose), Integer.valueOf(maxImagesAllowed)));
            return false;
        }
    }

    public boolean bLl() {
        if (getIntent().getBooleanExtra(AlbumActivityConfig.IS_SELECT_DIRECTLY, false)) {
            int maxImagesAllowed = this.hKu.getMaxImagesAllowed();
            if (this.hKu.size() == maxImagesAllowed && maxImagesAllowed == 1) {
                try {
                    ImageFileInfo imageFileInfo = (ImageFileInfo) v.d(this.hKu.bLC(), 0);
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
        this.hKu.a(null);
        this.hKu.delChooseFile(imageFileInfo);
        bLi();
        return true;
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i == 4) {
            closeLoadingDialog();
            if (this.mCurrentPage == 0) {
                if (this.hKu != null) {
                    this.hKu.setLastAlbumId(null);
                }
                bLm();
                return true;
            } else if (this.mCurrentPage == 1) {
                wD(0);
                return true;
            } else {
                return true;
            }
        }
        return super.onKeyDown(i, keyEvent);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void f(ImageFileInfo imageFileInfo, boolean z) {
        Fragment wE;
        if (this.hKv != null && (wE = this.hKv.wE(0)) != null && (wE instanceof ImageListFragment)) {
            ((ImageListFragment) wE).h(imageFileInfo, z);
        }
    }

    void g(ImageFileInfo imageFileInfo, boolean z) {
        Fragment wE;
        if (this.hKv != null && (wE = this.hKv.wE(1)) != null && (wE instanceof AlbumImageBrowseFragment)) {
            ((AlbumImageBrowseFragment) wE).h(imageFileInfo, z);
        }
    }

    private void bLm() {
        Intent intent = new Intent();
        String lastAlbumId = this.hKu.getLastAlbumId();
        if (TextUtils.isEmpty(lastAlbumId)) {
            lastAlbumId = "";
        }
        intent.putExtra(AlbumActivityConfig.LAST_ALBUM_ID, lastAlbumId);
        intent.putExtra(AlbumActivityConfig.CAMERA_REQUEST_FROM, this.hKy);
        setResult(0, intent);
        finish();
    }

    private void stopCamera() {
        if (this.hKv != null) {
            this.hKv.stopCamera();
        }
    }

    private void bLn() {
        if (this.hKv != null) {
            this.hKv.bLn();
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
        this.hKw = true;
        stopCamera();
        closeLoadingDialog();
        dismissAllDialog();
        d.bLG().destory();
        if (this.dDK != null) {
            this.dDK.setBackgroundDrawable(null);
        }
        if (this.hKv != null) {
            this.hKv.onDestroy();
        }
        if (this.hKE != null) {
            this.hKE.onDestroy();
        }
        Intent intent = new Intent();
        intent.setAction(AlbumActivityConfig.ACTION_SELECT_IMAGE_RESULT);
        intent.putExtra(AlbumActivityConfig.ALBUM_RESULT, this.hKu.getWriteImagesInfo().toJsonString());
        intent.putExtra(AlbumActivityConfig.CAMERA_REQUEST_FROM, this.hKy);
        intent.putExtra("from_type", this.hKD);
        if (this.hKB != null && !StringUtils.isNull(this.hKB.getStringExtra("file_name"))) {
            intent.putExtra("file_name", this.hKB.getStringExtra("file_name"));
        }
        TbadkCoreApplication.getInst().sendBroadcast(intent);
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
            new com.baidu.tbadk.img.f(null).c(AlbumActivity.this.hKu.getWriteImagesInfo(), true);
            return AlbumActivity.this.hKu.getWriteImagesInfo().toJsonString();
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
        if (this.hKE != null) {
            this.hKE.onStart();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.adp.base.BdBaseFragmentActivity, android.support.v4.app.FragmentActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        bLn();
        if (this.hKE != null) {
            this.hKE.onResume();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.base.BdBaseFragmentActivity, android.support.v4.app.FragmentActivity, android.app.Activity
    public void onStop() {
        super.onStop();
        if (this.hKE != null) {
            this.hKE.onStop();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.adp.base.BdBaseFragmentActivity, android.support.v4.app.FragmentActivity, android.app.Activity
    public void onPause() {
        stopCamera();
        super.onPause();
    }
}
