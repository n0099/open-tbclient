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
    private boolean dOy;
    private com.baidu.tieba.c.d gev;
    private c hUQ;
    private com.baidu.tieba.write.album.a hUR;
    private e hUT;
    private Intent hUX;
    private i hVa;
    private int mCurrentPage = 0;
    private boolean hUS = false;
    private String callFrom = "";
    private String from = "";
    private String forumName = "";
    private String forumId = "0";
    private int hUU = 0;
    private int hUV = 0;
    private boolean hUW = false;
    private boolean hUY = false;
    private int hUZ = 0;
    private View dMX = null;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.adp.base.BdBaseFragmentActivity, android.support.v4.app.FragmentActivity, android.support.v4.app.SupportActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setSwipeBackEnabled(false);
        setContentView(e.h.album_activity);
        this.dMX = findViewById(e.g.statebar_view);
        this.dOy = UtilHelper.canUseStyleImmersiveSticky();
        aaQ();
        initData(bundle);
        this.hUR = new com.baidu.tieba.write.album.a(this);
        this.hUR.aIy();
        xn(0);
    }

    public void showTip(View view) {
        if (this.gev == null && view != null) {
            this.gev = new com.baidu.tieba.c.d(getPageContext(), view);
            this.gev.lh(e.f.bg_tip_blue_up_left);
            this.gev.n(new View.OnClickListener() { // from class: com.baidu.tieba.write.album.AlbumActivity.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    AlbumActivity.this.gev.asb();
                }
            });
            this.gev.lg(16);
            this.gev.li(UIMsg.m_AppUI.MSG_APP_GPS);
        }
        if (this.gev != null) {
            String sharedPrefKeyWithAccount = com.baidu.tbadk.core.sharedPref.b.getSharedPrefKeyWithAccount("key_show_take_photo_tip");
            this.gev.bo(getString(e.j.album_take_photo_tip), sharedPrefKeyWithAccount);
        }
    }

    private void aaQ() {
        if (this.dMX != null) {
            if (this.dOy && this.dMX.getLayoutParams() != null) {
                ViewGroup.LayoutParams layoutParams = this.dMX.getLayoutParams();
                layoutParams.height = UtilHelper.getStatusBarHeight();
                this.dMX.setLayoutParams(layoutParams);
                gS(true);
                return;
            }
            gS(false);
        }
    }

    private void gS(boolean z) {
        if (this.dMX != null) {
            if (this.dOy && z && this.dMX.getVisibility() != 0) {
                this.dMX.setVisibility(0);
            } else if (!z && this.dMX.getVisibility() != 8) {
                this.dMX.setVisibility(8);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.support.v4.app.FragmentActivity, android.support.v4.app.SupportActivity, android.app.Activity
    public void onSaveInstanceState(Bundle bundle) {
        bundle.putString(AlbumActivityConfig.WRITE_IMAGES_INFO, this.hUQ.getWriteImagesInfo().toJsonString());
        bundle.putBoolean(AlbumActivityConfig.USE_ORIGINAL_IMG, this.hUW);
        bundle.putInt(AlbumActivityConfig.CAMERA_REQUEST_FROM, this.hUU);
        bundle.putString("forum_id", this.forumId);
        bundle.putString("forum_name", this.forumName);
        bundle.putInt(IntentConfig.KEY_ALBUM_THREAD, this.hUV);
        bundle.putBoolean(IntentConfig.KEY_FROM_WRITEACTIVITY, this.hUY);
    }

    private void initData(Bundle bundle) {
        this.hUQ = new c(this);
        if (bundle != null) {
            WriteImagesInfo writeImagesInfo = new WriteImagesInfo();
            writeImagesInfo.parseJson(bundle.getString(AlbumActivityConfig.WRITE_IMAGES_INFO));
            this.hUQ.setWriteImagesInfo(writeImagesInfo);
            this.hUW = bundle.getBoolean(AlbumActivityConfig.USE_ORIGINAL_IMG, false);
            this.hUU = bundle.getInt(AlbumActivityConfig.CAMERA_REQUEST_FROM, 0);
            this.forumId = bundle.getString("forum_id");
            this.forumName = bundle.getString("forum_name");
            this.hUV = bundle.getInt(IntentConfig.KEY_ALBUM_THREAD);
            this.hUY = bundle.getBoolean(IntentConfig.KEY_FROM_WRITEACTIVITY);
            this.callFrom = bundle.getString("KEY_CALL_FROM");
            this.hUZ = bundle.getInt("from_type");
        } else {
            Intent intent = getIntent();
            if (intent != null) {
                WriteImagesInfo writeImagesInfo2 = new WriteImagesInfo();
                writeImagesInfo2.parseJson(intent.getStringExtra(AlbumActivityConfig.WRITE_IMAGES_INFO));
                this.hUQ.setWriteImagesInfo(writeImagesInfo2);
                this.hUQ.setOriginalImg(writeImagesInfo2.isOriginalImg());
                this.hUW = intent.getBooleanExtra(AlbumActivityConfig.USE_ORIGINAL_IMG, false);
                this.hUU = intent.getIntExtra(AlbumActivityConfig.CAMERA_REQUEST_FROM, 0);
                this.from = intent.getStringExtra("from");
                this.forumId = intent.getStringExtra("forum_id");
                this.forumName = intent.getStringExtra("forum_name");
                this.hUV = intent.getIntExtra(IntentConfig.KEY_ALBUM_THREAD, 0);
                this.hUY = intent.getBooleanExtra(IntentConfig.KEY_FROM_WRITEACTIVITY, false);
                this.callFrom = intent.getStringExtra("KEY_CALL_FROM");
                this.hUZ = intent.getIntExtra("from_type", 0);
            }
        }
        bOb();
    }

    private void bOb() {
        if (this.hUU == 2) {
            this.hUT = new e() { // from class: com.baidu.tieba.write.album.AlbumActivity.2
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
        if (this.hUR != null) {
            this.hUR.onChangeSkinType(i);
        }
        al.e(this.dMX, e.d.cp_bg_line_d, i);
    }

    public void bOc() {
        if (this.hUU == 3) {
            TiebaStatic.log("c10489");
        }
        if (this.hUU == 5) {
            showLoadingDialog("正在上传");
            new a().execute(new String[0]);
        } else if (this.hUQ != null) {
            if (this.hVa == null || !this.hVa.bOP()) {
                if (this.hUQ.bOw()) {
                    VideoFileInfo bOu = this.hUQ.bOu();
                    if (this.hVa == null) {
                        this.hVa = new i(this, this.forumName, this.forumId, "");
                        if (this.hUR != null) {
                            this.hUR.a(this.hVa);
                        }
                    }
                    this.hVa.a(bOu, this.callFrom);
                } else if (v.H(this.hUQ.bOy()) == 1 && this.hUZ == 0) {
                    bOd();
                } else {
                    af(null);
                }
            }
        }
    }

    private void af(Intent intent) {
        Intent intent2 = new Intent();
        intent2.putExtra(AlbumActivityConfig.ALBUM_RESULT, this.hUQ.getWriteImagesInfo().toJsonString());
        intent2.putExtra(AlbumActivityConfig.CAMERA_REQUEST_FROM, this.hUU);
        intent2.putExtra("from_type", this.hUZ);
        if (intent != null && !StringUtils.isNull(intent.getStringExtra("file_name"))) {
            intent2.putExtra("file_name", intent.getStringExtra("file_name"));
        }
        setResult(-1, intent2);
        finish();
    }

    private boolean aib() {
        Activity pageActivity = getPageContext().getPageActivity();
        com.baidu.tbadk.core.util.b.a aVar = new com.baidu.tbadk.core.util.b.a();
        aVar.Et();
        aVar.c(pageActivity, "android.permission.CAMERA");
        aVar.c(pageActivity, "android.permission.RECORD_AUDIO");
        aVar.c(pageActivity, "android.permission.WRITE_EXTERNAL_STORAGE");
        return aVar.A(pageActivity);
    }

    public void b(TbPageContext tbPageContext) {
        if (!aib() && com.baidu.tieba.write.e.bNV()) {
            sendMessage(new CustomMessage(2002001, new RecordVideoActivityConfig(tbPageContext.getPageActivity(), this.hUY ? 2 : 3, new ForumWriteData(this.forumId, this.forumName, null, null), this.hUQ.getWriteImagesInfo(), "", this.hUZ)));
            TiebaStatic.log(new am("c12611").x("obj_locate", 5).x("obj_type", 2));
        }
    }

    private void bOd() {
        WriteImagesInfo writeImagesInfo;
        if (this.hUQ != null && (writeImagesInfo = this.hUQ.getWriteImagesInfo()) != null) {
            sendMessage(new CustomMessage(2002001, new WriteMulitImageActivityConfig(getPageContext().getPageActivity(), IEventCenterService.EventId.EventMode.SAPIACCOUNT_THROUGH_SERVER, writeImagesInfo, 0)));
        }
    }

    private void ag(Intent intent) {
        this.hUX = intent;
        if (intent == null || this.hUQ == null) {
            af(null);
            return;
        }
        String stringExtra = intent.getStringExtra(AlbumActivityConfig.ALBUM_RESULT);
        if (stringExtra != null) {
            WriteImagesInfo writeImagesInfo = this.hUQ.getWriteImagesInfo();
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
        if (view == this.hUR.bOm()) {
            bOc();
        } else if (view == this.hUR.bOo()) {
            bOc();
        } else if (view == this.hUR.bOl()) {
            if (this.hUQ != null) {
                this.hUQ.setLastAlbumId(null);
            }
            bOi();
        } else if (view == this.hUR.bOn()) {
            xn(0);
        } else if (view == this.hUR.bOp()) {
            xl(2);
        } else if (view == this.hUR.bOq()) {
            xl(1);
        }
    }

    private void xl(int i) {
        if (this.hUR != null && this.hUQ != null) {
            this.hUQ.setOriginalImg(!this.hUQ.isOriginalImg());
            bOe();
            xm(i);
        }
    }

    private void xm(int i) {
        if (this.hUQ != null && this.hUQ.isOriginalImg() && !StringUtils.isNull(this.from, true) && !StringUtils.isNull(this.forumId, true)) {
            TiebaStatic.log(new am("c10349").aA(ImageViewerConfig.FORUM_ID, this.forumId).aA("obj_type", this.from).x("obj_locate", i));
        }
    }

    public void bOe() {
        if (this.hUQ != null && this.hUR != null) {
            this.hUR.oy(this.hUQ.isOriginalImg());
        }
    }

    public View aCc() {
        return this.dMX;
    }

    public int bOf() {
        return this.hUV;
    }

    public c bOg() {
        return this.hUQ;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void xn(int i) {
        if (!this.hUS) {
            FragmentTransaction beginTransaction = getSupportFragmentManager().beginTransaction();
            Fragment findFragmentByTag = getSupportFragmentManager().findFragmentByTag(this.hUR.xp(this.mCurrentPage));
            if (findFragmentByTag != null) {
                beginTransaction.hide(findFragmentByTag);
            }
            this.mCurrentPage = i;
            if (getSupportFragmentManager().findFragmentByTag(this.hUR.xp(i)) != null) {
                beginTransaction.show(this.hUR.xo(i));
            } else {
                beginTransaction.add(e.g.fragment, this.hUR.xo(i), this.hUR.xp(i));
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
        int maxImagesAllowed = this.hUQ.getMaxImagesAllowed();
        if (this.hUQ.size() < maxImagesAllowed) {
            if (this.hUT == null || this.hUT.e(imageFileInfo)) {
                ImageFileInfo imageFileInfo2 = new ImageFileInfo();
                imageFileInfo2.setAlbumnId(imageFileInfo.getAlbumId());
                imageFileInfo2.setFilePath(imageFileInfo.getFilePath());
                imageFileInfo2.setModifyTime(imageFileInfo.getModifyTime());
                imageFileInfo2.setIsGif(imageFileInfo.isGif());
                imageFileInfo2.setIsLong(imageFileInfo.isLong());
                this.hUQ.a(null);
                this.hUQ.addChooseFile(imageFileInfo2);
                bOe();
                return true;
            }
            return false;
        } else if (bOh()) {
            return c(imageFileInfo);
        } else {
            showToast(String.format(getPageContext().getContext().getString(e.j.album_beyond_max_choose), Integer.valueOf(maxImagesAllowed)));
            return false;
        }
    }

    public boolean bOh() {
        if (getIntent().getBooleanExtra(AlbumActivityConfig.IS_SELECT_DIRECTLY, false)) {
            int maxImagesAllowed = this.hUQ.getMaxImagesAllowed();
            if (this.hUQ.size() == maxImagesAllowed && maxImagesAllowed == 1) {
                try {
                    ImageFileInfo imageFileInfo = (ImageFileInfo) v.d(this.hUQ.bOy(), 0);
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
        this.hUQ.a(null);
        this.hUQ.delChooseFile(imageFileInfo);
        bOe();
        return true;
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i == 4) {
            closeLoadingDialog();
            if (this.mCurrentPage == 0) {
                if (this.hUQ != null) {
                    this.hUQ.setLastAlbumId(null);
                }
                bOi();
                return true;
            } else if (this.mCurrentPage == 1) {
                xn(0);
                return true;
            } else {
                return true;
            }
        }
        return super.onKeyDown(i, keyEvent);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void f(ImageFileInfo imageFileInfo, boolean z) {
        Fragment xo;
        if (this.hUR != null && (xo = this.hUR.xo(0)) != null && (xo instanceof ImageListFragment)) {
            ((ImageListFragment) xo).h(imageFileInfo, z);
        }
    }

    void g(ImageFileInfo imageFileInfo, boolean z) {
        Fragment xo;
        if (this.hUR != null && (xo = this.hUR.xo(1)) != null && (xo instanceof AlbumImageBrowseFragment)) {
            ((AlbumImageBrowseFragment) xo).h(imageFileInfo, z);
        }
    }

    private void bOi() {
        Intent intent = new Intent();
        String lastAlbumId = this.hUQ.getLastAlbumId();
        if (TextUtils.isEmpty(lastAlbumId)) {
            lastAlbumId = "";
        }
        intent.putExtra(AlbumActivityConfig.LAST_ALBUM_ID, lastAlbumId);
        intent.putExtra(AlbumActivityConfig.CAMERA_REQUEST_FROM, this.hUU);
        setResult(0, intent);
        finish();
    }

    private void stopCamera() {
        if (this.hUR != null) {
            this.hUR.stopCamera();
        }
    }

    private void bOj() {
        if (this.hUR != null) {
            this.hUR.bOj();
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
        this.hUS = true;
        stopCamera();
        closeLoadingDialog();
        dismissAllDialog();
        d.bOC().destory();
        if (this.dMX != null) {
            this.dMX.setBackgroundDrawable(null);
        }
        if (this.hUR != null) {
            this.hUR.onDestroy();
        }
        if (this.hVa != null) {
            this.hVa.onDestroy();
        }
        Intent intent = new Intent();
        intent.setAction(AlbumActivityConfig.ACTION_SELECT_IMAGE_RESULT);
        intent.putExtra(AlbumActivityConfig.ALBUM_RESULT, this.hUQ.getWriteImagesInfo().toJsonString());
        intent.putExtra(AlbumActivityConfig.CAMERA_REQUEST_FROM, this.hUU);
        intent.putExtra("from_type", this.hUZ);
        if (this.hUX != null && !StringUtils.isNull(this.hUX.getStringExtra("file_name"))) {
            intent.putExtra("file_name", this.hUX.getStringExtra("file_name"));
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
            new com.baidu.tbadk.img.f(null).c(AlbumActivity.this.hUQ.getWriteImagesInfo(), true);
            return AlbumActivity.this.hUQ.getWriteImagesInfo().toJsonString();
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
        if (this.hVa != null) {
            this.hVa.onStart();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.adp.base.BdBaseFragmentActivity, android.support.v4.app.FragmentActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        bOj();
        if (this.hVa != null) {
            this.hVa.onResume();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.base.BdBaseFragmentActivity, android.support.v4.app.FragmentActivity, android.app.Activity
    public void onStop() {
        super.onStop();
        if (this.hVa != null) {
            this.hVa.onStop();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.adp.base.BdBaseFragmentActivity, android.support.v4.app.FragmentActivity, android.app.Activity
    public void onPause() {
        stopCamera();
        super.onPause();
    }
}
