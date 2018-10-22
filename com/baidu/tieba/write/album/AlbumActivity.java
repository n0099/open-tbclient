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
import com.baidu.f.a.a;
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
    private boolean dDV;
    private com.baidu.tieba.c.d fTn;
    private c hIK;
    private com.baidu.tieba.write.album.a hIL;
    private e hIN;
    private Intent hIR;
    private i hIU;
    private int mCurrentPage = 0;
    private boolean hIM = false;
    private String callFrom = "";
    private String from = "";
    private String forumName = "";
    private String forumId = "0";
    private int hIO = 0;
    private int hIP = 0;
    private boolean hIQ = false;
    private boolean hIS = false;
    private int hIT = 0;
    private View dCt = null;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.adp.base.BdBaseFragmentActivity, android.support.v4.app.FragmentActivity, android.support.v4.app.SupportActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setSwipeBackEnabled(false);
        setContentView(e.h.album_activity);
        this.dCt = findViewById(e.g.statebar_view);
        this.dDV = UtilHelper.canUseStyleImmersiveSticky();
        Zy();
        initData(bundle);
        this.hIL = new com.baidu.tieba.write.album.a(this);
        this.hIL.aGz();
        wk(0);
    }

    public void showTip(View view) {
        if (this.fTn == null && view != null) {
            this.fTn = new com.baidu.tieba.c.d(getPageContext(), view);
            this.fTn.kl(e.f.bg_tip_blue_up_left);
            this.fTn.l(new View.OnClickListener() { // from class: com.baidu.tieba.write.album.AlbumActivity.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    AlbumActivity.this.fTn.apZ();
                }
            });
            this.fTn.kk(16);
            this.fTn.km(5000);
        }
        if (this.fTn != null) {
            String sharedPrefKeyWithAccount = com.baidu.tbadk.core.sharedPref.b.getSharedPrefKeyWithAccount("key_show_take_photo_tip");
            this.fTn.bj(getString(e.j.album_take_photo_tip), sharedPrefKeyWithAccount);
        }
    }

    private void Zy() {
        if (this.dCt != null) {
            if (this.dDV && this.dCt.getLayoutParams() != null) {
                ViewGroup.LayoutParams layoutParams = this.dCt.getLayoutParams();
                layoutParams.height = UtilHelper.getStatusBarHeight();
                this.dCt.setLayoutParams(layoutParams);
                gE(true);
                return;
            }
            gE(false);
        }
    }

    private void gE(boolean z) {
        if (this.dCt != null) {
            if (this.dDV && z && this.dCt.getVisibility() != 0) {
                this.dCt.setVisibility(0);
            } else if (!z && this.dCt.getVisibility() != 8) {
                this.dCt.setVisibility(8);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.support.v4.app.FragmentActivity, android.support.v4.app.SupportActivity, android.app.Activity
    public void onSaveInstanceState(Bundle bundle) {
        bundle.putString(AlbumActivityConfig.WRITE_IMAGES_INFO, this.hIK.getWriteImagesInfo().toJsonString());
        bundle.putBoolean(AlbumActivityConfig.USE_ORIGINAL_IMG, this.hIQ);
        bundle.putInt(AlbumActivityConfig.CAMERA_REQUEST_FROM, this.hIO);
        bundle.putString("forum_id", this.forumId);
        bundle.putString("forum_name", this.forumName);
        bundle.putInt(IntentConfig.KEY_ALBUM_THREAD, this.hIP);
        bundle.putBoolean(IntentConfig.KEY_FROM_WRITEACTIVITY, this.hIS);
    }

    private void initData(Bundle bundle) {
        this.hIK = new c(this);
        if (bundle != null) {
            WriteImagesInfo writeImagesInfo = new WriteImagesInfo();
            writeImagesInfo.parseJson(bundle.getString(AlbumActivityConfig.WRITE_IMAGES_INFO));
            this.hIK.setWriteImagesInfo(writeImagesInfo);
            this.hIQ = bundle.getBoolean(AlbumActivityConfig.USE_ORIGINAL_IMG, false);
            this.hIO = bundle.getInt(AlbumActivityConfig.CAMERA_REQUEST_FROM, 0);
            this.forumId = bundle.getString("forum_id");
            this.forumName = bundle.getString("forum_name");
            this.hIP = bundle.getInt(IntentConfig.KEY_ALBUM_THREAD);
            this.hIS = bundle.getBoolean(IntentConfig.KEY_FROM_WRITEACTIVITY);
            this.callFrom = bundle.getString("KEY_CALL_FROM");
            this.hIT = bundle.getInt("from_type");
        } else {
            Intent intent = getIntent();
            if (intent != null) {
                WriteImagesInfo writeImagesInfo2 = new WriteImagesInfo();
                writeImagesInfo2.parseJson(intent.getStringExtra(AlbumActivityConfig.WRITE_IMAGES_INFO));
                this.hIK.setWriteImagesInfo(writeImagesInfo2);
                this.hIK.setOriginalImg(writeImagesInfo2.isOriginalImg());
                this.hIQ = intent.getBooleanExtra(AlbumActivityConfig.USE_ORIGINAL_IMG, false);
                this.hIO = intent.getIntExtra(AlbumActivityConfig.CAMERA_REQUEST_FROM, 0);
                this.from = intent.getStringExtra("from");
                this.forumId = intent.getStringExtra("forum_id");
                this.forumName = intent.getStringExtra("forum_name");
                this.hIP = intent.getIntExtra(IntentConfig.KEY_ALBUM_THREAD, 0);
                this.hIS = intent.getBooleanExtra(IntentConfig.KEY_FROM_WRITEACTIVITY, false);
                this.callFrom = intent.getStringExtra("KEY_CALL_FROM");
                this.hIT = intent.getIntExtra("from_type", 0);
            }
        }
        bLG();
    }

    private void bLG() {
        if (this.hIO == 2) {
            this.hIN = new e() { // from class: com.baidu.tieba.write.album.AlbumActivity.2
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
        if (this.hIL != null) {
            this.hIL.onChangeSkinType(i);
        }
        al.e(this.dCt, e.d.cp_bg_line_d, i);
    }

    public void bLH() {
        if (this.hIO == 3) {
            TiebaStatic.log("c10489");
        }
        if (this.hIO == 5) {
            showLoadingDialog("正在上传");
            new a().execute(new String[0]);
        } else if (this.hIK != null) {
            if (this.hIU == null || !this.hIU.bMu()) {
                if (this.hIK.bMb()) {
                    VideoFileInfo bLZ = this.hIK.bLZ();
                    if (this.hIU == null) {
                        this.hIU = new i(this, this.forumName, this.forumId, "");
                        if (this.hIL != null) {
                            this.hIL.a(this.hIU);
                        }
                    }
                    this.hIU.a(bLZ, this.callFrom);
                } else if (v.I(this.hIK.bMd()) == 1 && this.hIT == 0) {
                    bLI();
                } else {
                    af(null);
                }
            }
        }
    }

    private void af(Intent intent) {
        Intent intent2 = new Intent();
        intent2.putExtra(AlbumActivityConfig.ALBUM_RESULT, this.hIK.getWriteImagesInfo().toJsonString());
        intent2.putExtra(AlbumActivityConfig.CAMERA_REQUEST_FROM, this.hIO);
        intent2.putExtra("from_type", this.hIT);
        if (intent != null && !StringUtils.isNull(intent.getStringExtra("file_name"))) {
            intent2.putExtra("file_name", intent.getStringExtra("file_name"));
        }
        setResult(-1, intent2);
        finish();
    }

    private boolean ahd() {
        Activity pageActivity = getPageContext().getPageActivity();
        com.baidu.tbadk.core.util.b.a aVar = new com.baidu.tbadk.core.util.b.a();
        aVar.Di();
        aVar.c(pageActivity, "android.permission.CAMERA");
        aVar.c(pageActivity, "android.permission.RECORD_AUDIO");
        aVar.c(pageActivity, "android.permission.WRITE_EXTERNAL_STORAGE");
        return aVar.z(pageActivity);
    }

    public void b(TbPageContext tbPageContext) {
        if (!ahd() && com.baidu.tieba.write.e.bLA()) {
            sendMessage(new CustomMessage(2002001, new RecordVideoActivityConfig(tbPageContext.getPageActivity(), this.hIS ? 2 : 3, new ForumWriteData(this.forumId, this.forumName, null, null), this.hIK.getWriteImagesInfo(), "", this.hIT)));
            TiebaStatic.log(new am("c12611").x("obj_locate", 5).x("obj_type", 2));
        }
    }

    private void bLI() {
        WriteImagesInfo writeImagesInfo;
        if (this.hIK != null && (writeImagesInfo = this.hIK.getWriteImagesInfo()) != null) {
            sendMessage(new CustomMessage(2002001, new WriteMulitImageActivityConfig(getPageContext().getPageActivity(), IEventCenterService.EventId.EventMode.SAPIACCOUNT_THROUGH_SERVER, writeImagesInfo, 0)));
        }
    }

    private void ag(Intent intent) {
        this.hIR = intent;
        if (intent == null || this.hIK == null) {
            af(null);
            return;
        }
        String stringExtra = intent.getStringExtra(AlbumActivityConfig.ALBUM_RESULT);
        if (stringExtra != null) {
            WriteImagesInfo writeImagesInfo = this.hIK.getWriteImagesInfo();
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
        if (view == this.hIL.bLR()) {
            bLH();
        } else if (view == this.hIL.bLT()) {
            bLH();
        } else if (view == this.hIL.bLQ()) {
            if (this.hIK != null) {
                this.hIK.setLastAlbumId(null);
            }
            bLN();
        } else if (view == this.hIL.bLS()) {
            wk(0);
        } else if (view == this.hIL.bLU()) {
            wi(2);
        } else if (view == this.hIL.bLV()) {
            wi(1);
        }
    }

    private void wi(int i) {
        if (this.hIL != null && this.hIK != null) {
            this.hIK.setOriginalImg(!this.hIK.isOriginalImg());
            bLJ();
            wj(i);
        }
    }

    private void wj(int i) {
        if (this.hIK != null && this.hIK.isOriginalImg() && !StringUtils.isNull(this.from, true) && !StringUtils.isNull(this.forumId, true)) {
            TiebaStatic.log(new am("c10349").ax(ImageViewerConfig.FORUM_ID, this.forumId).ax("obj_type", this.from).x("obj_locate", i));
        }
    }

    public void bLJ() {
        if (this.hIK != null && this.hIL != null) {
            this.hIL.of(this.hIK.isOriginalImg());
        }
    }

    public View aAf() {
        return this.dCt;
    }

    public int bLK() {
        return this.hIP;
    }

    public c bLL() {
        return this.hIK;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void wk(int i) {
        if (!this.hIM) {
            FragmentTransaction beginTransaction = getSupportFragmentManager().beginTransaction();
            Fragment findFragmentByTag = getSupportFragmentManager().findFragmentByTag(this.hIL.wm(this.mCurrentPage));
            if (findFragmentByTag != null) {
                beginTransaction.hide(findFragmentByTag);
            }
            this.mCurrentPage = i;
            if (getSupportFragmentManager().findFragmentByTag(this.hIL.wm(i)) != null) {
                beginTransaction.show(this.hIL.wl(i));
            } else {
                beginTransaction.add(e.g.fragment, this.hIL.wl(i), this.hIL.wm(i));
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
        int maxImagesAllowed = this.hIK.getMaxImagesAllowed();
        if (this.hIK.size() < maxImagesAllowed) {
            if (this.hIN == null || this.hIN.e(imageFileInfo)) {
                ImageFileInfo imageFileInfo2 = new ImageFileInfo();
                imageFileInfo2.setAlbumnId(imageFileInfo.getAlbumId());
                imageFileInfo2.setFilePath(imageFileInfo.getFilePath());
                imageFileInfo2.setModifyTime(imageFileInfo.getModifyTime());
                imageFileInfo2.setIsGif(imageFileInfo.isGif());
                imageFileInfo2.setIsLong(imageFileInfo.isLong());
                this.hIK.a(null);
                this.hIK.addChooseFile(imageFileInfo2);
                bLJ();
                return true;
            }
            return false;
        } else if (bLM()) {
            return c(imageFileInfo);
        } else {
            showToast(String.format(getPageContext().getContext().getString(e.j.album_beyond_max_choose), Integer.valueOf(maxImagesAllowed)));
            return false;
        }
    }

    public boolean bLM() {
        if (getIntent().getBooleanExtra(AlbumActivityConfig.IS_SELECT_DIRECTLY, false)) {
            int maxImagesAllowed = this.hIK.getMaxImagesAllowed();
            if (this.hIK.size() == maxImagesAllowed && maxImagesAllowed == 1) {
                try {
                    ImageFileInfo imageFileInfo = (ImageFileInfo) v.d(this.hIK.bMd(), 0);
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
        this.hIK.a(null);
        this.hIK.delChooseFile(imageFileInfo);
        bLJ();
        return true;
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i == 4) {
            closeLoadingDialog();
            if (this.mCurrentPage == 0) {
                if (this.hIK != null) {
                    this.hIK.setLastAlbumId(null);
                }
                bLN();
                return true;
            } else if (this.mCurrentPage == 1) {
                wk(0);
                return true;
            } else {
                return true;
            }
        }
        return super.onKeyDown(i, keyEvent);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void f(ImageFileInfo imageFileInfo, boolean z) {
        Fragment wl;
        if (this.hIL != null && (wl = this.hIL.wl(0)) != null && (wl instanceof ImageListFragment)) {
            ((ImageListFragment) wl).h(imageFileInfo, z);
        }
    }

    void g(ImageFileInfo imageFileInfo, boolean z) {
        Fragment wl;
        if (this.hIL != null && (wl = this.hIL.wl(1)) != null && (wl instanceof AlbumImageBrowseFragment)) {
            ((AlbumImageBrowseFragment) wl).h(imageFileInfo, z);
        }
    }

    private void bLN() {
        Intent intent = new Intent();
        String lastAlbumId = this.hIK.getLastAlbumId();
        if (TextUtils.isEmpty(lastAlbumId)) {
            lastAlbumId = "";
        }
        intent.putExtra(AlbumActivityConfig.LAST_ALBUM_ID, lastAlbumId);
        intent.putExtra(AlbumActivityConfig.CAMERA_REQUEST_FROM, this.hIO);
        setResult(0, intent);
        finish();
    }

    private void stopCamera() {
        if (this.hIL != null) {
            this.hIL.stopCamera();
        }
    }

    private void bLO() {
        if (this.hIL != null) {
            this.hIL.bLO();
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
        this.hIM = true;
        stopCamera();
        closeLoadingDialog();
        dismissAllDialog();
        d.bMh().destory();
        if (this.dCt != null) {
            this.dCt.setBackgroundDrawable(null);
        }
        if (this.hIL != null) {
            this.hIL.onDestroy();
        }
        if (this.hIU != null) {
            this.hIU.onDestroy();
        }
        Intent intent = new Intent();
        intent.setAction(AlbumActivityConfig.ACTION_SELECT_IMAGE_RESULT);
        intent.putExtra(AlbumActivityConfig.ALBUM_RESULT, this.hIK.getWriteImagesInfo().toJsonString());
        intent.putExtra(AlbumActivityConfig.CAMERA_REQUEST_FROM, this.hIO);
        intent.putExtra("from_type", this.hIT);
        if (this.hIR != null && !StringUtils.isNull(this.hIR.getStringExtra("file_name"))) {
            intent.putExtra("file_name", this.hIR.getStringExtra("file_name"));
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
            new com.baidu.tbadk.img.f(null).c(AlbumActivity.this.hIK.getWriteImagesInfo(), true);
            return AlbumActivity.this.hIK.getWriteImagesInfo().toJsonString();
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
        if (this.hIU != null) {
            this.hIU.onStart();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.adp.base.BdBaseFragmentActivity, android.support.v4.app.FragmentActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        bLO();
        if (this.hIU != null) {
            this.hIU.onResume();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.base.BdBaseFragmentActivity, android.support.v4.app.FragmentActivity, android.app.Activity
    public void onStop() {
        super.onStop();
        if (this.hIU != null) {
            this.hIU.onStop();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.adp.base.BdBaseFragmentActivity, android.support.v4.app.FragmentActivity, android.app.Activity
    public void onPause() {
        stopCamera();
        super.onPause();
    }
}
