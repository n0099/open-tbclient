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
    private boolean dPh;
    private com.baidu.tieba.c.d gfy;
    private c hVX;
    private com.baidu.tieba.write.album.a hVY;
    private e hWa;
    private Intent hWe;
    private i hWh;
    private int mCurrentPage = 0;
    private boolean hVZ = false;
    private String callFrom = "";
    private String from = "";
    private String forumName = "";
    private String forumId = "0";
    private int hWb = 0;
    private int hWc = 0;
    private boolean hWd = false;
    private boolean hWf = false;
    private int hWg = 0;
    private View dNG = null;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.adp.base.BdBaseFragmentActivity, android.support.v4.app.FragmentActivity, android.support.v4.app.SupportActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setSwipeBackEnabled(false);
        setContentView(e.h.album_activity);
        this.dNG = findViewById(e.g.statebar_view);
        this.dPh = UtilHelper.canUseStyleImmersiveSticky();
        abn();
        initData(bundle);
        this.hVY = new com.baidu.tieba.write.album.a(this);
        this.hVY.aIW();
        xp(0);
    }

    public void showTip(View view) {
        if (this.gfy == null && view != null) {
            this.gfy = new com.baidu.tieba.c.d(getPageContext(), view);
            this.gfy.li(e.f.bg_tip_blue_up_left);
            this.gfy.n(new View.OnClickListener() { // from class: com.baidu.tieba.write.album.AlbumActivity.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    AlbumActivity.this.gfy.asz();
                }
            });
            this.gfy.lh(16);
            this.gfy.lj(UIMsg.m_AppUI.MSG_APP_GPS);
        }
        if (this.gfy != null) {
            String sharedPrefKeyWithAccount = com.baidu.tbadk.core.sharedPref.b.getSharedPrefKeyWithAccount("key_show_take_photo_tip");
            this.gfy.bp(getString(e.j.album_take_photo_tip), sharedPrefKeyWithAccount);
        }
    }

    private void abn() {
        if (this.dNG != null) {
            if (this.dPh && this.dNG.getLayoutParams() != null) {
                ViewGroup.LayoutParams layoutParams = this.dNG.getLayoutParams();
                layoutParams.height = UtilHelper.getStatusBarHeight();
                this.dNG.setLayoutParams(layoutParams);
                gV(true);
                return;
            }
            gV(false);
        }
    }

    private void gV(boolean z) {
        if (this.dNG != null) {
            if (this.dPh && z && this.dNG.getVisibility() != 0) {
                this.dNG.setVisibility(0);
            } else if (!z && this.dNG.getVisibility() != 8) {
                this.dNG.setVisibility(8);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.support.v4.app.FragmentActivity, android.support.v4.app.SupportActivity, android.app.Activity
    public void onSaveInstanceState(Bundle bundle) {
        bundle.putString(AlbumActivityConfig.WRITE_IMAGES_INFO, this.hVX.getWriteImagesInfo().toJsonString());
        bundle.putBoolean(AlbumActivityConfig.USE_ORIGINAL_IMG, this.hWd);
        bundle.putInt(AlbumActivityConfig.CAMERA_REQUEST_FROM, this.hWb);
        bundle.putString("forum_id", this.forumId);
        bundle.putString("forum_name", this.forumName);
        bundle.putInt(IntentConfig.KEY_ALBUM_THREAD, this.hWc);
        bundle.putBoolean(IntentConfig.KEY_FROM_WRITEACTIVITY, this.hWf);
    }

    private void initData(Bundle bundle) {
        this.hVX = new c(this);
        if (bundle != null) {
            WriteImagesInfo writeImagesInfo = new WriteImagesInfo();
            writeImagesInfo.parseJson(bundle.getString(AlbumActivityConfig.WRITE_IMAGES_INFO));
            this.hVX.setWriteImagesInfo(writeImagesInfo);
            this.hWd = bundle.getBoolean(AlbumActivityConfig.USE_ORIGINAL_IMG, false);
            this.hWb = bundle.getInt(AlbumActivityConfig.CAMERA_REQUEST_FROM, 0);
            this.forumId = bundle.getString("forum_id");
            this.forumName = bundle.getString("forum_name");
            this.hWc = bundle.getInt(IntentConfig.KEY_ALBUM_THREAD);
            this.hWf = bundle.getBoolean(IntentConfig.KEY_FROM_WRITEACTIVITY);
            this.callFrom = bundle.getString("KEY_CALL_FROM");
            this.hWg = bundle.getInt("from_type");
        } else {
            Intent intent = getIntent();
            if (intent != null) {
                WriteImagesInfo writeImagesInfo2 = new WriteImagesInfo();
                writeImagesInfo2.parseJson(intent.getStringExtra(AlbumActivityConfig.WRITE_IMAGES_INFO));
                this.hVX.setWriteImagesInfo(writeImagesInfo2);
                this.hVX.setOriginalImg(writeImagesInfo2.isOriginalImg());
                this.hWd = intent.getBooleanExtra(AlbumActivityConfig.USE_ORIGINAL_IMG, false);
                this.hWb = intent.getIntExtra(AlbumActivityConfig.CAMERA_REQUEST_FROM, 0);
                this.from = intent.getStringExtra("from");
                this.forumId = intent.getStringExtra("forum_id");
                this.forumName = intent.getStringExtra("forum_name");
                this.hWc = intent.getIntExtra(IntentConfig.KEY_ALBUM_THREAD, 0);
                this.hWf = intent.getBooleanExtra(IntentConfig.KEY_FROM_WRITEACTIVITY, false);
                this.callFrom = intent.getStringExtra("KEY_CALL_FROM");
                this.hWg = intent.getIntExtra("from_type", 0);
            }
        }
        bOJ();
    }

    private void bOJ() {
        if (this.hWb == 2) {
            this.hWa = new e() { // from class: com.baidu.tieba.write.album.AlbumActivity.2
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
        if (this.hVY != null) {
            this.hVY.onChangeSkinType(i);
        }
        al.e(this.dNG, e.d.cp_bg_line_d, i);
    }

    public void bOK() {
        if (this.hWb == 3) {
            TiebaStatic.log("c10489");
        }
        if (this.hWb == 5) {
            showLoadingDialog("正在上传");
            new a().execute(new String[0]);
        } else if (this.hVX != null) {
            if (this.hWh == null || !this.hWh.bPx()) {
                if (this.hVX.bPe()) {
                    VideoFileInfo bPc = this.hVX.bPc();
                    if (this.hWh == null) {
                        this.hWh = new i(this, this.forumName, this.forumId, "");
                        if (this.hVY != null) {
                            this.hVY.a(this.hWh);
                        }
                    }
                    this.hWh.a(bPc, this.callFrom);
                } else if (v.H(this.hVX.bPg()) == 1 && this.hWg == 0) {
                    bOL();
                } else {
                    af(null);
                }
            }
        }
    }

    private void af(Intent intent) {
        Intent intent2 = new Intent();
        intent2.putExtra(AlbumActivityConfig.ALBUM_RESULT, this.hVX.getWriteImagesInfo().toJsonString());
        intent2.putExtra(AlbumActivityConfig.CAMERA_REQUEST_FROM, this.hWb);
        intent2.putExtra("from_type", this.hWg);
        if (intent != null && !StringUtils.isNull(intent.getStringExtra("file_name"))) {
            intent2.putExtra("file_name", intent.getStringExtra("file_name"));
        }
        setResult(-1, intent2);
        finish();
    }

    private boolean aiy() {
        Activity pageActivity = getPageContext().getPageActivity();
        com.baidu.tbadk.core.util.b.a aVar = new com.baidu.tbadk.core.util.b.a();
        aVar.EG();
        aVar.c(pageActivity, "android.permission.CAMERA");
        aVar.c(pageActivity, "android.permission.RECORD_AUDIO");
        aVar.c(pageActivity, "android.permission.WRITE_EXTERNAL_STORAGE");
        return aVar.B(pageActivity);
    }

    public void b(TbPageContext tbPageContext) {
        if (!aiy() && com.baidu.tieba.write.e.bOD()) {
            sendMessage(new CustomMessage(2002001, new RecordVideoActivityConfig(tbPageContext.getPageActivity(), this.hWf ? 2 : 3, new ForumWriteData(this.forumId, this.forumName, null, null), this.hVX.getWriteImagesInfo(), "", this.hWg)));
            TiebaStatic.log(new am("c12611").y("obj_locate", 5).y("obj_type", 2));
        }
    }

    private void bOL() {
        WriteImagesInfo writeImagesInfo;
        if (this.hVX != null && (writeImagesInfo = this.hVX.getWriteImagesInfo()) != null) {
            sendMessage(new CustomMessage(2002001, new WriteMulitImageActivityConfig(getPageContext().getPageActivity(), IEventCenterService.EventId.EventMode.SAPIACCOUNT_THROUGH_SERVER, writeImagesInfo, 0)));
        }
    }

    private void ag(Intent intent) {
        this.hWe = intent;
        if (intent == null || this.hVX == null) {
            af(null);
            return;
        }
        String stringExtra = intent.getStringExtra(AlbumActivityConfig.ALBUM_RESULT);
        if (stringExtra != null) {
            WriteImagesInfo writeImagesInfo = this.hVX.getWriteImagesInfo();
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
        if (view == this.hVY.bOU()) {
            bOK();
        } else if (view == this.hVY.bOW()) {
            bOK();
        } else if (view == this.hVY.bOT()) {
            if (this.hVX != null) {
                this.hVX.setLastAlbumId(null);
            }
            bOQ();
        } else if (view == this.hVY.bOV()) {
            xp(0);
        } else if (view == this.hVY.bOX()) {
            xn(2);
        } else if (view == this.hVY.bOY()) {
            xn(1);
        }
    }

    private void xn(int i) {
        if (this.hVY != null && this.hVX != null) {
            this.hVX.setOriginalImg(!this.hVX.isOriginalImg());
            bOM();
            xo(i);
        }
    }

    private void xo(int i) {
        if (this.hVX != null && this.hVX.isOriginalImg() && !StringUtils.isNull(this.from, true) && !StringUtils.isNull(this.forumId, true)) {
            TiebaStatic.log(new am("c10349").aB(ImageViewerConfig.FORUM_ID, this.forumId).aB("obj_type", this.from).y("obj_locate", i));
        }
    }

    public void bOM() {
        if (this.hVX != null && this.hVY != null) {
            this.hVY.oz(this.hVX.isOriginalImg());
        }
    }

    public View aCz() {
        return this.dNG;
    }

    public int bON() {
        return this.hWc;
    }

    public c bOO() {
        return this.hVX;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void xp(int i) {
        if (!this.hVZ) {
            FragmentTransaction beginTransaction = getSupportFragmentManager().beginTransaction();
            Fragment findFragmentByTag = getSupportFragmentManager().findFragmentByTag(this.hVY.xr(this.mCurrentPage));
            if (findFragmentByTag != null) {
                beginTransaction.hide(findFragmentByTag);
            }
            this.mCurrentPage = i;
            if (getSupportFragmentManager().findFragmentByTag(this.hVY.xr(i)) != null) {
                beginTransaction.show(this.hVY.xq(i));
            } else {
                beginTransaction.add(e.g.fragment, this.hVY.xq(i), this.hVY.xr(i));
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
        int maxImagesAllowed = this.hVX.getMaxImagesAllowed();
        if (this.hVX.size() < maxImagesAllowed) {
            if (this.hWa == null || this.hWa.e(imageFileInfo)) {
                ImageFileInfo imageFileInfo2 = new ImageFileInfo();
                imageFileInfo2.setAlbumnId(imageFileInfo.getAlbumId());
                imageFileInfo2.setFilePath(imageFileInfo.getFilePath());
                imageFileInfo2.setModifyTime(imageFileInfo.getModifyTime());
                imageFileInfo2.setIsGif(imageFileInfo.isGif());
                imageFileInfo2.setIsLong(imageFileInfo.isLong());
                this.hVX.a(null);
                this.hVX.addChooseFile(imageFileInfo2);
                bOM();
                return true;
            }
            return false;
        } else if (bOP()) {
            return c(imageFileInfo);
        } else {
            showToast(String.format(getPageContext().getContext().getString(e.j.album_beyond_max_choose), Integer.valueOf(maxImagesAllowed)));
            return false;
        }
    }

    public boolean bOP() {
        if (getIntent().getBooleanExtra(AlbumActivityConfig.IS_SELECT_DIRECTLY, false)) {
            int maxImagesAllowed = this.hVX.getMaxImagesAllowed();
            if (this.hVX.size() == maxImagesAllowed && maxImagesAllowed == 1) {
                try {
                    ImageFileInfo imageFileInfo = (ImageFileInfo) v.d(this.hVX.bPg(), 0);
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
        this.hVX.a(null);
        this.hVX.delChooseFile(imageFileInfo);
        bOM();
        return true;
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i == 4) {
            closeLoadingDialog();
            if (this.mCurrentPage == 0) {
                if (this.hVX != null) {
                    this.hVX.setLastAlbumId(null);
                }
                bOQ();
                return true;
            } else if (this.mCurrentPage == 1) {
                xp(0);
                return true;
            } else {
                return true;
            }
        }
        return super.onKeyDown(i, keyEvent);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void f(ImageFileInfo imageFileInfo, boolean z) {
        Fragment xq;
        if (this.hVY != null && (xq = this.hVY.xq(0)) != null && (xq instanceof ImageListFragment)) {
            ((ImageListFragment) xq).h(imageFileInfo, z);
        }
    }

    void g(ImageFileInfo imageFileInfo, boolean z) {
        Fragment xq;
        if (this.hVY != null && (xq = this.hVY.xq(1)) != null && (xq instanceof AlbumImageBrowseFragment)) {
            ((AlbumImageBrowseFragment) xq).h(imageFileInfo, z);
        }
    }

    private void bOQ() {
        Intent intent = new Intent();
        String lastAlbumId = this.hVX.getLastAlbumId();
        if (TextUtils.isEmpty(lastAlbumId)) {
            lastAlbumId = "";
        }
        intent.putExtra(AlbumActivityConfig.LAST_ALBUM_ID, lastAlbumId);
        intent.putExtra(AlbumActivityConfig.CAMERA_REQUEST_FROM, this.hWb);
        setResult(0, intent);
        finish();
    }

    private void stopCamera() {
        if (this.hVY != null) {
            this.hVY.stopCamera();
        }
    }

    private void bOR() {
        if (this.hVY != null) {
            this.hVY.bOR();
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
        this.hVZ = true;
        stopCamera();
        closeLoadingDialog();
        dismissAllDialog();
        d.bPk().destory();
        if (this.dNG != null) {
            this.dNG.setBackgroundDrawable(null);
        }
        if (this.hVY != null) {
            this.hVY.onDestroy();
        }
        if (this.hWh != null) {
            this.hWh.onDestroy();
        }
        Intent intent = new Intent();
        intent.setAction(AlbumActivityConfig.ACTION_SELECT_IMAGE_RESULT);
        intent.putExtra(AlbumActivityConfig.ALBUM_RESULT, this.hVX.getWriteImagesInfo().toJsonString());
        intent.putExtra(AlbumActivityConfig.CAMERA_REQUEST_FROM, this.hWb);
        intent.putExtra("from_type", this.hWg);
        if (this.hWe != null && !StringUtils.isNull(this.hWe.getStringExtra("file_name"))) {
            intent.putExtra("file_name", this.hWe.getStringExtra("file_name"));
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
            new com.baidu.tbadk.img.f(null).c(AlbumActivity.this.hVX.getWriteImagesInfo(), true);
            return AlbumActivity.this.hVX.getWriteImagesInfo().toJsonString();
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
        if (this.hWh != null) {
            this.hWh.onStart();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.adp.base.BdBaseFragmentActivity, android.support.v4.app.FragmentActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        bOR();
        if (this.hWh != null) {
            this.hWh.onResume();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.base.BdBaseFragmentActivity, android.support.v4.app.FragmentActivity, android.app.Activity
    public void onStop() {
        super.onStop();
        if (this.hWh != null) {
            this.hWh.onStop();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.adp.base.BdBaseFragmentActivity, android.support.v4.app.FragmentActivity, android.app.Activity
    public void onPause() {
        stopCamera();
        super.onPause();
    }
}
