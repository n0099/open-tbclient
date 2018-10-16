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
    private com.baidu.tieba.c.d fTm;
    private c hIJ;
    private com.baidu.tieba.write.album.a hIK;
    private e hIM;
    private Intent hIQ;
    private i hIT;
    private int mCurrentPage = 0;
    private boolean hIL = false;
    private String callFrom = "";
    private String from = "";
    private String forumName = "";
    private String forumId = "0";
    private int hIN = 0;
    private int hIO = 0;
    private boolean hIP = false;
    private boolean hIR = false;
    private int hIS = 0;
    private View dCt = null;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.adp.base.BdBaseFragmentActivity, android.support.v4.app.FragmentActivity, android.support.v4.app.SupportActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setSwipeBackEnabled(false);
        setContentView(e.h.album_activity);
        this.dCt = findViewById(e.g.statebar_view);
        this.dDV = UtilHelper.canUseStyleImmersiveSticky();
        Zx();
        initData(bundle);
        this.hIK = new com.baidu.tieba.write.album.a(this);
        this.hIK.aGz();
        wk(0);
    }

    public void showTip(View view) {
        if (this.fTm == null && view != null) {
            this.fTm = new com.baidu.tieba.c.d(getPageContext(), view);
            this.fTm.kl(e.f.bg_tip_blue_up_left);
            this.fTm.l(new View.OnClickListener() { // from class: com.baidu.tieba.write.album.AlbumActivity.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    AlbumActivity.this.fTm.apY();
                }
            });
            this.fTm.kk(16);
            this.fTm.km(5000);
        }
        if (this.fTm != null) {
            String sharedPrefKeyWithAccount = com.baidu.tbadk.core.sharedPref.b.getSharedPrefKeyWithAccount("key_show_take_photo_tip");
            this.fTm.bj(getString(e.j.album_take_photo_tip), sharedPrefKeyWithAccount);
        }
    }

    private void Zx() {
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
        bundle.putString(AlbumActivityConfig.WRITE_IMAGES_INFO, this.hIJ.getWriteImagesInfo().toJsonString());
        bundle.putBoolean(AlbumActivityConfig.USE_ORIGINAL_IMG, this.hIP);
        bundle.putInt(AlbumActivityConfig.CAMERA_REQUEST_FROM, this.hIN);
        bundle.putString("forum_id", this.forumId);
        bundle.putString("forum_name", this.forumName);
        bundle.putInt(IntentConfig.KEY_ALBUM_THREAD, this.hIO);
        bundle.putBoolean(IntentConfig.KEY_FROM_WRITEACTIVITY, this.hIR);
    }

    private void initData(Bundle bundle) {
        this.hIJ = new c(this);
        if (bundle != null) {
            WriteImagesInfo writeImagesInfo = new WriteImagesInfo();
            writeImagesInfo.parseJson(bundle.getString(AlbumActivityConfig.WRITE_IMAGES_INFO));
            this.hIJ.setWriteImagesInfo(writeImagesInfo);
            this.hIP = bundle.getBoolean(AlbumActivityConfig.USE_ORIGINAL_IMG, false);
            this.hIN = bundle.getInt(AlbumActivityConfig.CAMERA_REQUEST_FROM, 0);
            this.forumId = bundle.getString("forum_id");
            this.forumName = bundle.getString("forum_name");
            this.hIO = bundle.getInt(IntentConfig.KEY_ALBUM_THREAD);
            this.hIR = bundle.getBoolean(IntentConfig.KEY_FROM_WRITEACTIVITY);
            this.callFrom = bundle.getString("KEY_CALL_FROM");
            this.hIS = bundle.getInt("from_type");
        } else {
            Intent intent = getIntent();
            if (intent != null) {
                WriteImagesInfo writeImagesInfo2 = new WriteImagesInfo();
                writeImagesInfo2.parseJson(intent.getStringExtra(AlbumActivityConfig.WRITE_IMAGES_INFO));
                this.hIJ.setWriteImagesInfo(writeImagesInfo2);
                this.hIJ.setOriginalImg(writeImagesInfo2.isOriginalImg());
                this.hIP = intent.getBooleanExtra(AlbumActivityConfig.USE_ORIGINAL_IMG, false);
                this.hIN = intent.getIntExtra(AlbumActivityConfig.CAMERA_REQUEST_FROM, 0);
                this.from = intent.getStringExtra("from");
                this.forumId = intent.getStringExtra("forum_id");
                this.forumName = intent.getStringExtra("forum_name");
                this.hIO = intent.getIntExtra(IntentConfig.KEY_ALBUM_THREAD, 0);
                this.hIR = intent.getBooleanExtra(IntentConfig.KEY_FROM_WRITEACTIVITY, false);
                this.callFrom = intent.getStringExtra("KEY_CALL_FROM");
                this.hIS = intent.getIntExtra("from_type", 0);
            }
        }
        bLG();
    }

    private void bLG() {
        if (this.hIN == 2) {
            this.hIM = new e() { // from class: com.baidu.tieba.write.album.AlbumActivity.2
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
        if (this.hIK != null) {
            this.hIK.onChangeSkinType(i);
        }
        al.e(this.dCt, e.d.cp_bg_line_d, i);
    }

    public void bLH() {
        if (this.hIN == 3) {
            TiebaStatic.log("c10489");
        }
        if (this.hIN == 5) {
            showLoadingDialog("正在上传");
            new a().execute(new String[0]);
        } else if (this.hIJ != null) {
            if (this.hIT == null || !this.hIT.bMu()) {
                if (this.hIJ.bMb()) {
                    VideoFileInfo bLZ = this.hIJ.bLZ();
                    if (this.hIT == null) {
                        this.hIT = new i(this, this.forumName, this.forumId, "");
                        if (this.hIK != null) {
                            this.hIK.a(this.hIT);
                        }
                    }
                    this.hIT.a(bLZ, this.callFrom);
                } else if (v.I(this.hIJ.bMd()) == 1 && this.hIS == 0) {
                    bLI();
                } else {
                    af(null);
                }
            }
        }
    }

    private void af(Intent intent) {
        Intent intent2 = new Intent();
        intent2.putExtra(AlbumActivityConfig.ALBUM_RESULT, this.hIJ.getWriteImagesInfo().toJsonString());
        intent2.putExtra(AlbumActivityConfig.CAMERA_REQUEST_FROM, this.hIN);
        intent2.putExtra("from_type", this.hIS);
        if (intent != null && !StringUtils.isNull(intent.getStringExtra("file_name"))) {
            intent2.putExtra("file_name", intent.getStringExtra("file_name"));
        }
        setResult(-1, intent2);
        finish();
    }

    private boolean ahc() {
        Activity pageActivity = getPageContext().getPageActivity();
        com.baidu.tbadk.core.util.b.a aVar = new com.baidu.tbadk.core.util.b.a();
        aVar.Di();
        aVar.c(pageActivity, "android.permission.CAMERA");
        aVar.c(pageActivity, "android.permission.RECORD_AUDIO");
        aVar.c(pageActivity, "android.permission.WRITE_EXTERNAL_STORAGE");
        return aVar.z(pageActivity);
    }

    public void b(TbPageContext tbPageContext) {
        if (!ahc() && com.baidu.tieba.write.e.bLA()) {
            sendMessage(new CustomMessage(2002001, new RecordVideoActivityConfig(tbPageContext.getPageActivity(), this.hIR ? 2 : 3, new ForumWriteData(this.forumId, this.forumName, null, null), this.hIJ.getWriteImagesInfo(), "", this.hIS)));
            TiebaStatic.log(new am("c12611").x("obj_locate", 5).x("obj_type", 2));
        }
    }

    private void bLI() {
        WriteImagesInfo writeImagesInfo;
        if (this.hIJ != null && (writeImagesInfo = this.hIJ.getWriteImagesInfo()) != null) {
            sendMessage(new CustomMessage(2002001, new WriteMulitImageActivityConfig(getPageContext().getPageActivity(), IEventCenterService.EventId.EventMode.SAPIACCOUNT_THROUGH_SERVER, writeImagesInfo, 0)));
        }
    }

    private void ag(Intent intent) {
        this.hIQ = intent;
        if (intent == null || this.hIJ == null) {
            af(null);
            return;
        }
        String stringExtra = intent.getStringExtra(AlbumActivityConfig.ALBUM_RESULT);
        if (stringExtra != null) {
            WriteImagesInfo writeImagesInfo = this.hIJ.getWriteImagesInfo();
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
        if (view == this.hIK.bLR()) {
            bLH();
        } else if (view == this.hIK.bLT()) {
            bLH();
        } else if (view == this.hIK.bLQ()) {
            if (this.hIJ != null) {
                this.hIJ.setLastAlbumId(null);
            }
            bLN();
        } else if (view == this.hIK.bLS()) {
            wk(0);
        } else if (view == this.hIK.bLU()) {
            wi(2);
        } else if (view == this.hIK.bLV()) {
            wi(1);
        }
    }

    private void wi(int i) {
        if (this.hIK != null && this.hIJ != null) {
            this.hIJ.setOriginalImg(!this.hIJ.isOriginalImg());
            bLJ();
            wj(i);
        }
    }

    private void wj(int i) {
        if (this.hIJ != null && this.hIJ.isOriginalImg() && !StringUtils.isNull(this.from, true) && !StringUtils.isNull(this.forumId, true)) {
            TiebaStatic.log(new am("c10349").ax(ImageViewerConfig.FORUM_ID, this.forumId).ax("obj_type", this.from).x("obj_locate", i));
        }
    }

    public void bLJ() {
        if (this.hIJ != null && this.hIK != null) {
            this.hIK.of(this.hIJ.isOriginalImg());
        }
    }

    public View aAe() {
        return this.dCt;
    }

    public int bLK() {
        return this.hIO;
    }

    public c bLL() {
        return this.hIJ;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void wk(int i) {
        if (!this.hIL) {
            FragmentTransaction beginTransaction = getSupportFragmentManager().beginTransaction();
            Fragment findFragmentByTag = getSupportFragmentManager().findFragmentByTag(this.hIK.wm(this.mCurrentPage));
            if (findFragmentByTag != null) {
                beginTransaction.hide(findFragmentByTag);
            }
            this.mCurrentPage = i;
            if (getSupportFragmentManager().findFragmentByTag(this.hIK.wm(i)) != null) {
                beginTransaction.show(this.hIK.wl(i));
            } else {
                beginTransaction.add(e.g.fragment, this.hIK.wl(i), this.hIK.wm(i));
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
        int maxImagesAllowed = this.hIJ.getMaxImagesAllowed();
        if (this.hIJ.size() < maxImagesAllowed) {
            if (this.hIM == null || this.hIM.e(imageFileInfo)) {
                ImageFileInfo imageFileInfo2 = new ImageFileInfo();
                imageFileInfo2.setAlbumnId(imageFileInfo.getAlbumId());
                imageFileInfo2.setFilePath(imageFileInfo.getFilePath());
                imageFileInfo2.setModifyTime(imageFileInfo.getModifyTime());
                imageFileInfo2.setIsGif(imageFileInfo.isGif());
                imageFileInfo2.setIsLong(imageFileInfo.isLong());
                this.hIJ.a(null);
                this.hIJ.addChooseFile(imageFileInfo2);
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
            int maxImagesAllowed = this.hIJ.getMaxImagesAllowed();
            if (this.hIJ.size() == maxImagesAllowed && maxImagesAllowed == 1) {
                try {
                    ImageFileInfo imageFileInfo = (ImageFileInfo) v.d(this.hIJ.bMd(), 0);
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
        this.hIJ.a(null);
        this.hIJ.delChooseFile(imageFileInfo);
        bLJ();
        return true;
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i == 4) {
            closeLoadingDialog();
            if (this.mCurrentPage == 0) {
                if (this.hIJ != null) {
                    this.hIJ.setLastAlbumId(null);
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
        if (this.hIK != null && (wl = this.hIK.wl(0)) != null && (wl instanceof ImageListFragment)) {
            ((ImageListFragment) wl).h(imageFileInfo, z);
        }
    }

    void g(ImageFileInfo imageFileInfo, boolean z) {
        Fragment wl;
        if (this.hIK != null && (wl = this.hIK.wl(1)) != null && (wl instanceof AlbumImageBrowseFragment)) {
            ((AlbumImageBrowseFragment) wl).h(imageFileInfo, z);
        }
    }

    private void bLN() {
        Intent intent = new Intent();
        String lastAlbumId = this.hIJ.getLastAlbumId();
        if (TextUtils.isEmpty(lastAlbumId)) {
            lastAlbumId = "";
        }
        intent.putExtra(AlbumActivityConfig.LAST_ALBUM_ID, lastAlbumId);
        intent.putExtra(AlbumActivityConfig.CAMERA_REQUEST_FROM, this.hIN);
        setResult(0, intent);
        finish();
    }

    private void stopCamera() {
        if (this.hIK != null) {
            this.hIK.stopCamera();
        }
    }

    private void bLO() {
        if (this.hIK != null) {
            this.hIK.bLO();
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
        this.hIL = true;
        stopCamera();
        closeLoadingDialog();
        dismissAllDialog();
        d.bMh().destory();
        if (this.dCt != null) {
            this.dCt.setBackgroundDrawable(null);
        }
        if (this.hIK != null) {
            this.hIK.onDestroy();
        }
        if (this.hIT != null) {
            this.hIT.onDestroy();
        }
        Intent intent = new Intent();
        intent.setAction(AlbumActivityConfig.ACTION_SELECT_IMAGE_RESULT);
        intent.putExtra(AlbumActivityConfig.ALBUM_RESULT, this.hIJ.getWriteImagesInfo().toJsonString());
        intent.putExtra(AlbumActivityConfig.CAMERA_REQUEST_FROM, this.hIN);
        intent.putExtra("from_type", this.hIS);
        if (this.hIQ != null && !StringUtils.isNull(this.hIQ.getStringExtra("file_name"))) {
            intent.putExtra("file_name", this.hIQ.getStringExtra("file_name"));
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
            new com.baidu.tbadk.img.f(null).c(AlbumActivity.this.hIJ.getWriteImagesInfo(), true);
            return AlbumActivity.this.hIJ.getWriteImagesInfo().toJsonString();
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
        if (this.hIT != null) {
            this.hIT.onStart();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.adp.base.BdBaseFragmentActivity, android.support.v4.app.FragmentActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        bLO();
        if (this.hIT != null) {
            this.hIT.onResume();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.base.BdBaseFragmentActivity, android.support.v4.app.FragmentActivity, android.app.Activity
    public void onStop() {
        super.onStop();
        if (this.hIT != null) {
            this.hIT.onStop();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.adp.base.BdBaseFragmentActivity, android.support.v4.app.FragmentActivity, android.app.Activity
    public void onPause() {
        stopCamera();
        super.onPause();
    }
}
