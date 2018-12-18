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
    private boolean dLK;
    private com.baidu.tieba.c.d gbC;
    private c hRF;
    private com.baidu.tieba.write.album.a hRG;
    private e hRI;
    private Intent hRM;
    private i hRP;
    private int mCurrentPage = 0;
    private boolean hRH = false;
    private String callFrom = "";
    private String from = "";
    private String forumName = "";
    private String forumId = "0";
    private int hRJ = 0;
    private int hRK = 0;
    private boolean hRL = false;
    private boolean hRN = false;
    private int hRO = 0;
    private View dKj = null;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.adp.base.BdBaseFragmentActivity, android.support.v4.app.FragmentActivity, android.support.v4.app.SupportActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setSwipeBackEnabled(false);
        setContentView(e.h.album_activity);
        this.dKj = findViewById(e.g.statebar_view);
        this.dLK = UtilHelper.canUseStyleImmersiveSticky();
        aaO();
        initData(bundle);
        this.hRG = new com.baidu.tieba.write.album.a(this);
        this.hRG.aHJ();
        xa(0);
    }

    public void showTip(View view) {
        if (this.gbC == null && view != null) {
            this.gbC = new com.baidu.tieba.c.d(getPageContext(), view);
            this.gbC.kU(e.f.bg_tip_blue_up_left);
            this.gbC.n(new View.OnClickListener() { // from class: com.baidu.tieba.write.album.AlbumActivity.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    AlbumActivity.this.gbC.arm();
                }
            });
            this.gbC.kT(16);
            this.gbC.kV(UIMsg.m_AppUI.MSG_APP_GPS);
        }
        if (this.gbC != null) {
            String sharedPrefKeyWithAccount = com.baidu.tbadk.core.sharedPref.b.getSharedPrefKeyWithAccount("key_show_take_photo_tip");
            this.gbC.bo(getString(e.j.album_take_photo_tip), sharedPrefKeyWithAccount);
        }
    }

    private void aaO() {
        if (this.dKj != null) {
            if (this.dLK && this.dKj.getLayoutParams() != null) {
                ViewGroup.LayoutParams layoutParams = this.dKj.getLayoutParams();
                layoutParams.height = UtilHelper.getStatusBarHeight();
                this.dKj.setLayoutParams(layoutParams);
                gP(true);
                return;
            }
            gP(false);
        }
    }

    private void gP(boolean z) {
        if (this.dKj != null) {
            if (this.dLK && z && this.dKj.getVisibility() != 0) {
                this.dKj.setVisibility(0);
            } else if (!z && this.dKj.getVisibility() != 8) {
                this.dKj.setVisibility(8);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.support.v4.app.FragmentActivity, android.support.v4.app.SupportActivity, android.app.Activity
    public void onSaveInstanceState(Bundle bundle) {
        bundle.putString(AlbumActivityConfig.WRITE_IMAGES_INFO, this.hRF.getWriteImagesInfo().toJsonString());
        bundle.putBoolean(AlbumActivityConfig.USE_ORIGINAL_IMG, this.hRL);
        bundle.putInt(AlbumActivityConfig.CAMERA_REQUEST_FROM, this.hRJ);
        bundle.putString("forum_id", this.forumId);
        bundle.putString("forum_name", this.forumName);
        bundle.putInt(IntentConfig.KEY_ALBUM_THREAD, this.hRK);
        bundle.putBoolean(IntentConfig.KEY_FROM_WRITEACTIVITY, this.hRN);
    }

    private void initData(Bundle bundle) {
        this.hRF = new c(this);
        if (bundle != null) {
            WriteImagesInfo writeImagesInfo = new WriteImagesInfo();
            writeImagesInfo.parseJson(bundle.getString(AlbumActivityConfig.WRITE_IMAGES_INFO));
            this.hRF.setWriteImagesInfo(writeImagesInfo);
            this.hRL = bundle.getBoolean(AlbumActivityConfig.USE_ORIGINAL_IMG, false);
            this.hRJ = bundle.getInt(AlbumActivityConfig.CAMERA_REQUEST_FROM, 0);
            this.forumId = bundle.getString("forum_id");
            this.forumName = bundle.getString("forum_name");
            this.hRK = bundle.getInt(IntentConfig.KEY_ALBUM_THREAD);
            this.hRN = bundle.getBoolean(IntentConfig.KEY_FROM_WRITEACTIVITY);
            this.callFrom = bundle.getString("KEY_CALL_FROM");
            this.hRO = bundle.getInt("from_type");
        } else {
            Intent intent = getIntent();
            if (intent != null) {
                WriteImagesInfo writeImagesInfo2 = new WriteImagesInfo();
                writeImagesInfo2.parseJson(intent.getStringExtra(AlbumActivityConfig.WRITE_IMAGES_INFO));
                this.hRF.setWriteImagesInfo(writeImagesInfo2);
                this.hRF.setOriginalImg(writeImagesInfo2.isOriginalImg());
                this.hRL = intent.getBooleanExtra(AlbumActivityConfig.USE_ORIGINAL_IMG, false);
                this.hRJ = intent.getIntExtra(AlbumActivityConfig.CAMERA_REQUEST_FROM, 0);
                this.from = intent.getStringExtra("from");
                this.forumId = intent.getStringExtra("forum_id");
                this.forumName = intent.getStringExtra("forum_name");
                this.hRK = intent.getIntExtra(IntentConfig.KEY_ALBUM_THREAD, 0);
                this.hRN = intent.getBooleanExtra(IntentConfig.KEY_FROM_WRITEACTIVITY, false);
                this.callFrom = intent.getStringExtra("KEY_CALL_FROM");
                this.hRO = intent.getIntExtra("from_type", 0);
            }
        }
        bNk();
    }

    private void bNk() {
        if (this.hRJ == 2) {
            this.hRI = new e() { // from class: com.baidu.tieba.write.album.AlbumActivity.2
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
        if (this.hRG != null) {
            this.hRG.onChangeSkinType(i);
        }
        al.e(this.dKj, e.d.cp_bg_line_d, i);
    }

    public void bNl() {
        if (this.hRJ == 3) {
            TiebaStatic.log("c10489");
        }
        if (this.hRJ == 5) {
            showLoadingDialog("正在上传");
            new a().execute(new String[0]);
        } else if (this.hRF != null) {
            if (this.hRP == null || !this.hRP.bNY()) {
                if (this.hRF.bNF()) {
                    VideoFileInfo bND = this.hRF.bND();
                    if (this.hRP == null) {
                        this.hRP = new i(this, this.forumName, this.forumId, "");
                        if (this.hRG != null) {
                            this.hRG.a(this.hRP);
                        }
                    }
                    this.hRP.a(bND, this.callFrom);
                } else if (v.H(this.hRF.bNH()) == 1 && this.hRO == 0) {
                    bNm();
                } else {
                    af(null);
                }
            }
        }
    }

    private void af(Intent intent) {
        Intent intent2 = new Intent();
        intent2.putExtra(AlbumActivityConfig.ALBUM_RESULT, this.hRF.getWriteImagesInfo().toJsonString());
        intent2.putExtra(AlbumActivityConfig.CAMERA_REQUEST_FROM, this.hRJ);
        intent2.putExtra("from_type", this.hRO);
        if (intent != null && !StringUtils.isNull(intent.getStringExtra("file_name"))) {
            intent2.putExtra("file_name", intent.getStringExtra("file_name"));
        }
        setResult(-1, intent2);
        finish();
    }

    private boolean ahL() {
        Activity pageActivity = getPageContext().getPageActivity();
        com.baidu.tbadk.core.util.b.a aVar = new com.baidu.tbadk.core.util.b.a();
        aVar.Et();
        aVar.c(pageActivity, "android.permission.CAMERA");
        aVar.c(pageActivity, "android.permission.RECORD_AUDIO");
        aVar.c(pageActivity, "android.permission.WRITE_EXTERNAL_STORAGE");
        return aVar.A(pageActivity);
    }

    public void b(TbPageContext tbPageContext) {
        if (!ahL() && com.baidu.tieba.write.e.bNe()) {
            sendMessage(new CustomMessage(2002001, new RecordVideoActivityConfig(tbPageContext.getPageActivity(), this.hRN ? 2 : 3, new ForumWriteData(this.forumId, this.forumName, null, null), this.hRF.getWriteImagesInfo(), "", this.hRO)));
            TiebaStatic.log(new am("c12611").x("obj_locate", 5).x("obj_type", 2));
        }
    }

    private void bNm() {
        WriteImagesInfo writeImagesInfo;
        if (this.hRF != null && (writeImagesInfo = this.hRF.getWriteImagesInfo()) != null) {
            sendMessage(new CustomMessage(2002001, new WriteMulitImageActivityConfig(getPageContext().getPageActivity(), IEventCenterService.EventId.EventMode.SAPIACCOUNT_THROUGH_SERVER, writeImagesInfo, 0)));
        }
    }

    private void ag(Intent intent) {
        this.hRM = intent;
        if (intent == null || this.hRF == null) {
            af(null);
            return;
        }
        String stringExtra = intent.getStringExtra(AlbumActivityConfig.ALBUM_RESULT);
        if (stringExtra != null) {
            WriteImagesInfo writeImagesInfo = this.hRF.getWriteImagesInfo();
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
        if (view == this.hRG.bNv()) {
            bNl();
        } else if (view == this.hRG.bNx()) {
            bNl();
        } else if (view == this.hRG.bNu()) {
            if (this.hRF != null) {
                this.hRF.setLastAlbumId(null);
            }
            bNr();
        } else if (view == this.hRG.bNw()) {
            xa(0);
        } else if (view == this.hRG.bNy()) {
            wY(2);
        } else if (view == this.hRG.bNz()) {
            wY(1);
        }
    }

    private void wY(int i) {
        if (this.hRG != null && this.hRF != null) {
            this.hRF.setOriginalImg(!this.hRF.isOriginalImg());
            bNn();
            wZ(i);
        }
    }

    private void wZ(int i) {
        if (this.hRF != null && this.hRF.isOriginalImg() && !StringUtils.isNull(this.from, true) && !StringUtils.isNull(this.forumId, true)) {
            TiebaStatic.log(new am("c10349").aA(ImageViewerConfig.FORUM_ID, this.forumId).aA("obj_type", this.from).x("obj_locate", i));
        }
    }

    public void bNn() {
        if (this.hRF != null && this.hRG != null) {
            this.hRG.ov(this.hRF.isOriginalImg());
        }
    }

    public View aBn() {
        return this.dKj;
    }

    public int bNo() {
        return this.hRK;
    }

    public c bNp() {
        return this.hRF;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void xa(int i) {
        if (!this.hRH) {
            FragmentTransaction beginTransaction = getSupportFragmentManager().beginTransaction();
            Fragment findFragmentByTag = getSupportFragmentManager().findFragmentByTag(this.hRG.xc(this.mCurrentPage));
            if (findFragmentByTag != null) {
                beginTransaction.hide(findFragmentByTag);
            }
            this.mCurrentPage = i;
            if (getSupportFragmentManager().findFragmentByTag(this.hRG.xc(i)) != null) {
                beginTransaction.show(this.hRG.xb(i));
            } else {
                beginTransaction.add(e.g.fragment, this.hRG.xb(i), this.hRG.xc(i));
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
        int maxImagesAllowed = this.hRF.getMaxImagesAllowed();
        if (this.hRF.size() < maxImagesAllowed) {
            if (this.hRI == null || this.hRI.e(imageFileInfo)) {
                ImageFileInfo imageFileInfo2 = new ImageFileInfo();
                imageFileInfo2.setAlbumnId(imageFileInfo.getAlbumId());
                imageFileInfo2.setFilePath(imageFileInfo.getFilePath());
                imageFileInfo2.setModifyTime(imageFileInfo.getModifyTime());
                imageFileInfo2.setIsGif(imageFileInfo.isGif());
                imageFileInfo2.setIsLong(imageFileInfo.isLong());
                this.hRF.a(null);
                this.hRF.addChooseFile(imageFileInfo2);
                bNn();
                return true;
            }
            return false;
        } else if (bNq()) {
            return c(imageFileInfo);
        } else {
            showToast(String.format(getPageContext().getContext().getString(e.j.album_beyond_max_choose), Integer.valueOf(maxImagesAllowed)));
            return false;
        }
    }

    public boolean bNq() {
        if (getIntent().getBooleanExtra(AlbumActivityConfig.IS_SELECT_DIRECTLY, false)) {
            int maxImagesAllowed = this.hRF.getMaxImagesAllowed();
            if (this.hRF.size() == maxImagesAllowed && maxImagesAllowed == 1) {
                try {
                    ImageFileInfo imageFileInfo = (ImageFileInfo) v.d(this.hRF.bNH(), 0);
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
        this.hRF.a(null);
        this.hRF.delChooseFile(imageFileInfo);
        bNn();
        return true;
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i == 4) {
            closeLoadingDialog();
            if (this.mCurrentPage == 0) {
                if (this.hRF != null) {
                    this.hRF.setLastAlbumId(null);
                }
                bNr();
                return true;
            } else if (this.mCurrentPage == 1) {
                xa(0);
                return true;
            } else {
                return true;
            }
        }
        return super.onKeyDown(i, keyEvent);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void f(ImageFileInfo imageFileInfo, boolean z) {
        Fragment xb;
        if (this.hRG != null && (xb = this.hRG.xb(0)) != null && (xb instanceof ImageListFragment)) {
            ((ImageListFragment) xb).h(imageFileInfo, z);
        }
    }

    void g(ImageFileInfo imageFileInfo, boolean z) {
        Fragment xb;
        if (this.hRG != null && (xb = this.hRG.xb(1)) != null && (xb instanceof AlbumImageBrowseFragment)) {
            ((AlbumImageBrowseFragment) xb).h(imageFileInfo, z);
        }
    }

    private void bNr() {
        Intent intent = new Intent();
        String lastAlbumId = this.hRF.getLastAlbumId();
        if (TextUtils.isEmpty(lastAlbumId)) {
            lastAlbumId = "";
        }
        intent.putExtra(AlbumActivityConfig.LAST_ALBUM_ID, lastAlbumId);
        intent.putExtra(AlbumActivityConfig.CAMERA_REQUEST_FROM, this.hRJ);
        setResult(0, intent);
        finish();
    }

    private void stopCamera() {
        if (this.hRG != null) {
            this.hRG.stopCamera();
        }
    }

    private void bNs() {
        if (this.hRG != null) {
            this.hRG.bNs();
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
        this.hRH = true;
        stopCamera();
        closeLoadingDialog();
        dismissAllDialog();
        d.bNL().destory();
        if (this.dKj != null) {
            this.dKj.setBackgroundDrawable(null);
        }
        if (this.hRG != null) {
            this.hRG.onDestroy();
        }
        if (this.hRP != null) {
            this.hRP.onDestroy();
        }
        Intent intent = new Intent();
        intent.setAction(AlbumActivityConfig.ACTION_SELECT_IMAGE_RESULT);
        intent.putExtra(AlbumActivityConfig.ALBUM_RESULT, this.hRF.getWriteImagesInfo().toJsonString());
        intent.putExtra(AlbumActivityConfig.CAMERA_REQUEST_FROM, this.hRJ);
        intent.putExtra("from_type", this.hRO);
        if (this.hRM != null && !StringUtils.isNull(this.hRM.getStringExtra("file_name"))) {
            intent.putExtra("file_name", this.hRM.getStringExtra("file_name"));
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
            new com.baidu.tbadk.img.f(null).c(AlbumActivity.this.hRF.getWriteImagesInfo(), true);
            return AlbumActivity.this.hRF.getWriteImagesInfo().toJsonString();
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
        if (this.hRP != null) {
            this.hRP.onStart();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.adp.base.BdBaseFragmentActivity, android.support.v4.app.FragmentActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        bNs();
        if (this.hRP != null) {
            this.hRP.onResume();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.base.BdBaseFragmentActivity, android.support.v4.app.FragmentActivity, android.app.Activity
    public void onStop() {
        super.onStop();
        if (this.hRP != null) {
            this.hRP.onStop();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.adp.base.BdBaseFragmentActivity, android.support.v4.app.FragmentActivity, android.app.Activity
    public void onPause() {
        stopCamera();
        super.onPause();
    }
}
