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
    private boolean dPi;
    private com.baidu.tieba.c.d gfz;
    private c hVY;
    private com.baidu.tieba.write.album.a hVZ;
    private e hWb;
    private Intent hWf;
    private i hWi;
    private int mCurrentPage = 0;
    private boolean hWa = false;
    private String callFrom = "";
    private String from = "";
    private String forumName = "";
    private String forumId = "0";
    private int hWc = 0;
    private int hWd = 0;
    private boolean hWe = false;
    private boolean hWg = false;
    private int hWh = 0;
    private View dNH = null;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.adp.base.BdBaseFragmentActivity, android.support.v4.app.FragmentActivity, android.support.v4.app.SupportActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setSwipeBackEnabled(false);
        setContentView(e.h.album_activity);
        this.dNH = findViewById(e.g.statebar_view);
        this.dPi = UtilHelper.canUseStyleImmersiveSticky();
        abn();
        initData(bundle);
        this.hVZ = new com.baidu.tieba.write.album.a(this);
        this.hVZ.aIW();
        xp(0);
    }

    public void showTip(View view) {
        if (this.gfz == null && view != null) {
            this.gfz = new com.baidu.tieba.c.d(getPageContext(), view);
            this.gfz.li(e.f.bg_tip_blue_up_left);
            this.gfz.n(new View.OnClickListener() { // from class: com.baidu.tieba.write.album.AlbumActivity.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    AlbumActivity.this.gfz.asz();
                }
            });
            this.gfz.lh(16);
            this.gfz.lj(UIMsg.m_AppUI.MSG_APP_GPS);
        }
        if (this.gfz != null) {
            String sharedPrefKeyWithAccount = com.baidu.tbadk.core.sharedPref.b.getSharedPrefKeyWithAccount("key_show_take_photo_tip");
            this.gfz.bp(getString(e.j.album_take_photo_tip), sharedPrefKeyWithAccount);
        }
    }

    private void abn() {
        if (this.dNH != null) {
            if (this.dPi && this.dNH.getLayoutParams() != null) {
                ViewGroup.LayoutParams layoutParams = this.dNH.getLayoutParams();
                layoutParams.height = UtilHelper.getStatusBarHeight();
                this.dNH.setLayoutParams(layoutParams);
                gV(true);
                return;
            }
            gV(false);
        }
    }

    private void gV(boolean z) {
        if (this.dNH != null) {
            if (this.dPi && z && this.dNH.getVisibility() != 0) {
                this.dNH.setVisibility(0);
            } else if (!z && this.dNH.getVisibility() != 8) {
                this.dNH.setVisibility(8);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.support.v4.app.FragmentActivity, android.support.v4.app.SupportActivity, android.app.Activity
    public void onSaveInstanceState(Bundle bundle) {
        bundle.putString(AlbumActivityConfig.WRITE_IMAGES_INFO, this.hVY.getWriteImagesInfo().toJsonString());
        bundle.putBoolean(AlbumActivityConfig.USE_ORIGINAL_IMG, this.hWe);
        bundle.putInt(AlbumActivityConfig.CAMERA_REQUEST_FROM, this.hWc);
        bundle.putString("forum_id", this.forumId);
        bundle.putString("forum_name", this.forumName);
        bundle.putInt(IntentConfig.KEY_ALBUM_THREAD, this.hWd);
        bundle.putBoolean(IntentConfig.KEY_FROM_WRITEACTIVITY, this.hWg);
    }

    private void initData(Bundle bundle) {
        this.hVY = new c(this);
        if (bundle != null) {
            WriteImagesInfo writeImagesInfo = new WriteImagesInfo();
            writeImagesInfo.parseJson(bundle.getString(AlbumActivityConfig.WRITE_IMAGES_INFO));
            this.hVY.setWriteImagesInfo(writeImagesInfo);
            this.hWe = bundle.getBoolean(AlbumActivityConfig.USE_ORIGINAL_IMG, false);
            this.hWc = bundle.getInt(AlbumActivityConfig.CAMERA_REQUEST_FROM, 0);
            this.forumId = bundle.getString("forum_id");
            this.forumName = bundle.getString("forum_name");
            this.hWd = bundle.getInt(IntentConfig.KEY_ALBUM_THREAD);
            this.hWg = bundle.getBoolean(IntentConfig.KEY_FROM_WRITEACTIVITY);
            this.callFrom = bundle.getString("KEY_CALL_FROM");
            this.hWh = bundle.getInt("from_type");
        } else {
            Intent intent = getIntent();
            if (intent != null) {
                WriteImagesInfo writeImagesInfo2 = new WriteImagesInfo();
                writeImagesInfo2.parseJson(intent.getStringExtra(AlbumActivityConfig.WRITE_IMAGES_INFO));
                this.hVY.setWriteImagesInfo(writeImagesInfo2);
                this.hVY.setOriginalImg(writeImagesInfo2.isOriginalImg());
                this.hWe = intent.getBooleanExtra(AlbumActivityConfig.USE_ORIGINAL_IMG, false);
                this.hWc = intent.getIntExtra(AlbumActivityConfig.CAMERA_REQUEST_FROM, 0);
                this.from = intent.getStringExtra("from");
                this.forumId = intent.getStringExtra("forum_id");
                this.forumName = intent.getStringExtra("forum_name");
                this.hWd = intent.getIntExtra(IntentConfig.KEY_ALBUM_THREAD, 0);
                this.hWg = intent.getBooleanExtra(IntentConfig.KEY_FROM_WRITEACTIVITY, false);
                this.callFrom = intent.getStringExtra("KEY_CALL_FROM");
                this.hWh = intent.getIntExtra("from_type", 0);
            }
        }
        bOJ();
    }

    private void bOJ() {
        if (this.hWc == 2) {
            this.hWb = new e() { // from class: com.baidu.tieba.write.album.AlbumActivity.2
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
        if (this.hVZ != null) {
            this.hVZ.onChangeSkinType(i);
        }
        al.e(this.dNH, e.d.cp_bg_line_d, i);
    }

    public void bOK() {
        if (this.hWc == 3) {
            TiebaStatic.log("c10489");
        }
        if (this.hWc == 5) {
            showLoadingDialog("正在上传");
            new a().execute(new String[0]);
        } else if (this.hVY != null) {
            if (this.hWi == null || !this.hWi.bPx()) {
                if (this.hVY.bPe()) {
                    VideoFileInfo bPc = this.hVY.bPc();
                    if (this.hWi == null) {
                        this.hWi = new i(this, this.forumName, this.forumId, "");
                        if (this.hVZ != null) {
                            this.hVZ.a(this.hWi);
                        }
                    }
                    this.hWi.a(bPc, this.callFrom);
                } else if (v.H(this.hVY.bPg()) == 1 && this.hWh == 0) {
                    bOL();
                } else {
                    af(null);
                }
            }
        }
    }

    private void af(Intent intent) {
        Intent intent2 = new Intent();
        intent2.putExtra(AlbumActivityConfig.ALBUM_RESULT, this.hVY.getWriteImagesInfo().toJsonString());
        intent2.putExtra(AlbumActivityConfig.CAMERA_REQUEST_FROM, this.hWc);
        intent2.putExtra("from_type", this.hWh);
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
            sendMessage(new CustomMessage(2002001, new RecordVideoActivityConfig(tbPageContext.getPageActivity(), this.hWg ? 2 : 3, new ForumWriteData(this.forumId, this.forumName, null, null), this.hVY.getWriteImagesInfo(), "", this.hWh)));
            TiebaStatic.log(new am("c12611").y("obj_locate", 5).y("obj_type", 2));
        }
    }

    private void bOL() {
        WriteImagesInfo writeImagesInfo;
        if (this.hVY != null && (writeImagesInfo = this.hVY.getWriteImagesInfo()) != null) {
            sendMessage(new CustomMessage(2002001, new WriteMulitImageActivityConfig(getPageContext().getPageActivity(), IEventCenterService.EventId.EventMode.SAPIACCOUNT_THROUGH_SERVER, writeImagesInfo, 0)));
        }
    }

    private void ag(Intent intent) {
        this.hWf = intent;
        if (intent == null || this.hVY == null) {
            af(null);
            return;
        }
        String stringExtra = intent.getStringExtra(AlbumActivityConfig.ALBUM_RESULT);
        if (stringExtra != null) {
            WriteImagesInfo writeImagesInfo = this.hVY.getWriteImagesInfo();
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
        if (view == this.hVZ.bOU()) {
            bOK();
        } else if (view == this.hVZ.bOW()) {
            bOK();
        } else if (view == this.hVZ.bOT()) {
            if (this.hVY != null) {
                this.hVY.setLastAlbumId(null);
            }
            bOQ();
        } else if (view == this.hVZ.bOV()) {
            xp(0);
        } else if (view == this.hVZ.bOX()) {
            xn(2);
        } else if (view == this.hVZ.bOY()) {
            xn(1);
        }
    }

    private void xn(int i) {
        if (this.hVZ != null && this.hVY != null) {
            this.hVY.setOriginalImg(!this.hVY.isOriginalImg());
            bOM();
            xo(i);
        }
    }

    private void xo(int i) {
        if (this.hVY != null && this.hVY.isOriginalImg() && !StringUtils.isNull(this.from, true) && !StringUtils.isNull(this.forumId, true)) {
            TiebaStatic.log(new am("c10349").aB(ImageViewerConfig.FORUM_ID, this.forumId).aB("obj_type", this.from).y("obj_locate", i));
        }
    }

    public void bOM() {
        if (this.hVY != null && this.hVZ != null) {
            this.hVZ.oz(this.hVY.isOriginalImg());
        }
    }

    public View aCz() {
        return this.dNH;
    }

    public int bON() {
        return this.hWd;
    }

    public c bOO() {
        return this.hVY;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void xp(int i) {
        if (!this.hWa) {
            FragmentTransaction beginTransaction = getSupportFragmentManager().beginTransaction();
            Fragment findFragmentByTag = getSupportFragmentManager().findFragmentByTag(this.hVZ.xr(this.mCurrentPage));
            if (findFragmentByTag != null) {
                beginTransaction.hide(findFragmentByTag);
            }
            this.mCurrentPage = i;
            if (getSupportFragmentManager().findFragmentByTag(this.hVZ.xr(i)) != null) {
                beginTransaction.show(this.hVZ.xq(i));
            } else {
                beginTransaction.add(e.g.fragment, this.hVZ.xq(i), this.hVZ.xr(i));
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
        int maxImagesAllowed = this.hVY.getMaxImagesAllowed();
        if (this.hVY.size() < maxImagesAllowed) {
            if (this.hWb == null || this.hWb.e(imageFileInfo)) {
                ImageFileInfo imageFileInfo2 = new ImageFileInfo();
                imageFileInfo2.setAlbumnId(imageFileInfo.getAlbumId());
                imageFileInfo2.setFilePath(imageFileInfo.getFilePath());
                imageFileInfo2.setModifyTime(imageFileInfo.getModifyTime());
                imageFileInfo2.setIsGif(imageFileInfo.isGif());
                imageFileInfo2.setIsLong(imageFileInfo.isLong());
                this.hVY.a(null);
                this.hVY.addChooseFile(imageFileInfo2);
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
            int maxImagesAllowed = this.hVY.getMaxImagesAllowed();
            if (this.hVY.size() == maxImagesAllowed && maxImagesAllowed == 1) {
                try {
                    ImageFileInfo imageFileInfo = (ImageFileInfo) v.d(this.hVY.bPg(), 0);
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
        this.hVY.a(null);
        this.hVY.delChooseFile(imageFileInfo);
        bOM();
        return true;
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i == 4) {
            closeLoadingDialog();
            if (this.mCurrentPage == 0) {
                if (this.hVY != null) {
                    this.hVY.setLastAlbumId(null);
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
        if (this.hVZ != null && (xq = this.hVZ.xq(0)) != null && (xq instanceof ImageListFragment)) {
            ((ImageListFragment) xq).h(imageFileInfo, z);
        }
    }

    void g(ImageFileInfo imageFileInfo, boolean z) {
        Fragment xq;
        if (this.hVZ != null && (xq = this.hVZ.xq(1)) != null && (xq instanceof AlbumImageBrowseFragment)) {
            ((AlbumImageBrowseFragment) xq).h(imageFileInfo, z);
        }
    }

    private void bOQ() {
        Intent intent = new Intent();
        String lastAlbumId = this.hVY.getLastAlbumId();
        if (TextUtils.isEmpty(lastAlbumId)) {
            lastAlbumId = "";
        }
        intent.putExtra(AlbumActivityConfig.LAST_ALBUM_ID, lastAlbumId);
        intent.putExtra(AlbumActivityConfig.CAMERA_REQUEST_FROM, this.hWc);
        setResult(0, intent);
        finish();
    }

    private void stopCamera() {
        if (this.hVZ != null) {
            this.hVZ.stopCamera();
        }
    }

    private void bOR() {
        if (this.hVZ != null) {
            this.hVZ.bOR();
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
        this.hWa = true;
        stopCamera();
        closeLoadingDialog();
        dismissAllDialog();
        d.bPk().destory();
        if (this.dNH != null) {
            this.dNH.setBackgroundDrawable(null);
        }
        if (this.hVZ != null) {
            this.hVZ.onDestroy();
        }
        if (this.hWi != null) {
            this.hWi.onDestroy();
        }
        Intent intent = new Intent();
        intent.setAction(AlbumActivityConfig.ACTION_SELECT_IMAGE_RESULT);
        intent.putExtra(AlbumActivityConfig.ALBUM_RESULT, this.hVY.getWriteImagesInfo().toJsonString());
        intent.putExtra(AlbumActivityConfig.CAMERA_REQUEST_FROM, this.hWc);
        intent.putExtra("from_type", this.hWh);
        if (this.hWf != null && !StringUtils.isNull(this.hWf.getStringExtra("file_name"))) {
            intent.putExtra("file_name", this.hWf.getStringExtra("file_name"));
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
            new com.baidu.tbadk.img.f(null).c(AlbumActivity.this.hVY.getWriteImagesInfo(), true);
            return AlbumActivity.this.hVY.getWriteImagesInfo().toJsonString();
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
        if (this.hWi != null) {
            this.hWi.onStart();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.adp.base.BdBaseFragmentActivity, android.support.v4.app.FragmentActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        bOR();
        if (this.hWi != null) {
            this.hWi.onResume();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.base.BdBaseFragmentActivity, android.support.v4.app.FragmentActivity, android.app.Activity
    public void onStop() {
        super.onStop();
        if (this.hWi != null) {
            this.hWi.onStop();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.adp.base.BdBaseFragmentActivity, android.support.v4.app.FragmentActivity, android.app.Activity
    public void onPause() {
        stopCamera();
        super.onPause();
    }
}
