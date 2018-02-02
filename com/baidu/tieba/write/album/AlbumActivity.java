package com.baidu.tieba.write.album;

import android.app.Activity;
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
import com.baidu.b.a.a;
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
public class AlbumActivity extends BaseFragmentActivity implements View.OnClickListener, a.InterfaceC0036a {
    private boolean dEx;
    private com.baidu.tieba.d.b fQg;
    private e hDa;
    private com.baidu.tieba.write.album.a hDb;
    private g hDd;
    private l hDj;
    private int mCurrentPage = 0;
    private boolean hDc = false;
    private String callFrom = "";
    private String from = "";
    private String forumName = "";
    private String forumId = "0";
    private int hDe = 0;
    private int hDf = 0;
    private boolean hDg = false;
    private boolean hDh = false;
    private int hDi = 0;
    private View dDt = null;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.adp.base.BdBaseFragmentActivity, android.support.v4.app.FragmentActivity, android.support.v4.app.BaseFragmentActivityGingerbread, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setSwipeBackEnabled(false);
        setContentView(d.h.album_activity);
        this.dDt = findViewById(d.g.statebar_view);
        this.dEx = UtilHelper.canUseStyleImmersiveSticky();
        avx();
        initData(bundle);
        this.hDb = new com.baidu.tieba.write.album.a(this);
        this.hDb.aXl();
        xk(0);
    }

    public void showTip(View view) {
        if (this.fQg == null && view != null) {
            this.fQg = new com.baidu.tieba.d.b(getPageContext(), view);
            this.fQg.lV(d.f.bg_tip_blue_up_left);
            this.fQg.j(new View.OnClickListener() { // from class: com.baidu.tieba.write.album.AlbumActivity.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    AlbumActivity.this.fQg.amw();
                }
            });
            this.fQg.lU(16);
            this.fQg.lW(5000);
        }
        if (this.fQg != null) {
            String sharedPrefKeyWithAccount = com.baidu.tbadk.core.sharedPref.b.getSharedPrefKeyWithAccount("key_show_take_photo_tip");
            this.fQg.aJ(getString(d.j.album_take_photo_tip), sharedPrefKeyWithAccount);
        }
    }

    private void avx() {
        if (this.dDt != null) {
            if (this.dEx && this.dDt.getLayoutParams() != null) {
                ViewGroup.LayoutParams layoutParams = this.dDt.getLayoutParams();
                layoutParams.height = UtilHelper.getStatusBarHeight();
                this.dDt.setLayoutParams(layoutParams);
                fR(true);
                return;
            }
            fR(false);
        }
    }

    private void fR(boolean z) {
        if (this.dDt != null) {
            if (this.dEx && z && this.dDt.getVisibility() != 0) {
                this.dDt.setVisibility(0);
            } else if (!z && this.dDt.getVisibility() != 8) {
                this.dDt.setVisibility(8);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.support.v4.app.FragmentActivity, android.app.Activity
    public void onSaveInstanceState(Bundle bundle) {
        bundle.putString(AlbumActivityConfig.WRITE_IMAGES_INFO, this.hDa.getWriteImagesInfo().toJsonString());
        bundle.putBoolean(AlbumActivityConfig.USE_ORIGINAL_IMG, this.hDg);
        bundle.putInt(AlbumActivityConfig.CAMERA_REQUEST_FROM, this.hDe);
        bundle.putString("forum_id", this.forumId);
        bundle.putString("forum_name", this.forumName);
        bundle.putInt(IntentConfig.KEY_ALBUM_THREAD, this.hDf);
        bundle.putBoolean("from_write", this.hDh);
    }

    private void initData(Bundle bundle) {
        this.hDa = new e(this);
        if (bundle != null) {
            WriteImagesInfo writeImagesInfo = new WriteImagesInfo();
            writeImagesInfo.parseJson(bundle.getString(AlbumActivityConfig.WRITE_IMAGES_INFO));
            this.hDa.setWriteImagesInfo(writeImagesInfo);
            this.hDg = bundle.getBoolean(AlbumActivityConfig.USE_ORIGINAL_IMG, false);
            this.hDe = bundle.getInt(AlbumActivityConfig.CAMERA_REQUEST_FROM, 0);
            this.forumId = bundle.getString("forum_id");
            this.forumName = bundle.getString("forum_name");
            this.hDf = bundle.getInt(IntentConfig.KEY_ALBUM_THREAD);
            this.hDh = bundle.getBoolean("from_write");
            this.callFrom = bundle.getString("KEY_CALL_FROM");
            this.hDi = bundle.getInt("from_type");
        } else {
            Intent intent = getIntent();
            if (intent != null) {
                WriteImagesInfo writeImagesInfo2 = new WriteImagesInfo();
                writeImagesInfo2.parseJson(intent.getStringExtra(AlbumActivityConfig.WRITE_IMAGES_INFO));
                this.hDa.setWriteImagesInfo(writeImagesInfo2);
                this.hDa.setOriginalImg(writeImagesInfo2.isOriginalImg());
                this.hDg = intent.getBooleanExtra(AlbumActivityConfig.USE_ORIGINAL_IMG, false);
                this.hDe = intent.getIntExtra(AlbumActivityConfig.CAMERA_REQUEST_FROM, 0);
                this.from = intent.getStringExtra("from");
                this.forumId = intent.getStringExtra("forum_id");
                this.forumName = intent.getStringExtra("forum_name");
                this.hDf = intent.getIntExtra(IntentConfig.KEY_ALBUM_THREAD, 0);
                this.hDh = intent.getBooleanExtra("from_write", false);
                this.callFrom = intent.getStringExtra("KEY_CALL_FROM");
                this.hDi = intent.getIntExtra("from_type", 0);
            }
        }
        bFf();
    }

    private void bFf() {
        if (this.hDe == 2) {
            this.hDd = new g() { // from class: com.baidu.tieba.write.album.AlbumActivity.2
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
        if (this.hDb != null) {
            this.hDb.onChangeSkinType(i);
        }
        aj.g(this.dDt, d.C0108d.cp_bg_line_d, i);
    }

    public void bFg() {
        if (this.hDe == 3) {
            TiebaStatic.log("c10489");
        }
        if (this.hDe == 5) {
            showLoadingDialog("正在上传");
            new a().execute(new String[0]);
        } else if (this.hDa != null) {
            if (this.hDj == null || !this.hDj.bFT()) {
                if (this.hDa.bFA()) {
                    VideoFileInfo bFy = this.hDa.bFy();
                    if (this.hDj == null) {
                        this.hDj = new l(this, this.forumName, this.forumId, "");
                        if (this.hDb != null) {
                            this.hDb.a(this.hDj);
                        }
                    }
                    this.hDj.a(bFy, this.callFrom);
                } else if (v.D(this.hDa.bFC()) == 1 && this.hDi == 0) {
                    bFh();
                } else {
                    ae(null);
                }
            }
        }
    }

    private void ae(Intent intent) {
        Intent intent2 = new Intent();
        intent2.putExtra(AlbumActivityConfig.ALBUM_RESULT, this.hDa.getWriteImagesInfo().toJsonString());
        intent2.putExtra(AlbumActivityConfig.CAMERA_REQUEST_FROM, this.hDe);
        intent2.putExtra("from_type", this.hDi);
        if (intent != null && !StringUtils.isNull(intent.getStringExtra("file_name"))) {
            intent2.putExtra("file_name", intent.getStringExtra("file_name"));
        }
        setResult(-1, intent2);
        finish();
    }

    private boolean acb() {
        Activity pageActivity = getPageContext().getPageActivity();
        com.baidu.tbadk.core.util.b.a aVar = new com.baidu.tbadk.core.util.b.a();
        aVar.Do();
        aVar.c(pageActivity, "android.permission.CAMERA");
        aVar.c(pageActivity, "android.permission.RECORD_AUDIO");
        aVar.c(pageActivity, "android.permission.WRITE_EXTERNAL_STORAGE");
        return aVar.u(pageActivity);
    }

    public void c(TbPageContext tbPageContext) {
        if (!acb() && com.baidu.tieba.write.f.bEY()) {
            sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new RecordVideoActivityConfig(tbPageContext.getPageActivity(), this.hDh ? 2 : 3, new ForumWriteData(this.forumId, this.forumName, null, null), this.hDa.getWriteImagesInfo(), "", this.hDi)));
            TiebaStatic.log(new ak("c12611").s("obj_locate", 5).s("obj_type", 2));
        }
    }

    private void bFh() {
        WriteImagesInfo writeImagesInfo;
        if (this.hDa != null && (writeImagesInfo = this.hDa.getWriteImagesInfo()) != null) {
            sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new WriteMulitImageActivityConfig(getPageContext().getPageActivity(), IEventCenterService.EventId.EventMode.SAPIACCOUNT_THROUGH_SERVER, writeImagesInfo, 0)));
        }
    }

    private void af(Intent intent) {
        if (intent == null || this.hDa == null) {
            ae(null);
            return;
        }
        String stringExtra = intent.getStringExtra(AlbumActivityConfig.ALBUM_RESULT);
        if (stringExtra != null) {
            WriteImagesInfo writeImagesInfo = this.hDa.getWriteImagesInfo();
            writeImagesInfo.parseJson(stringExtra);
            writeImagesInfo.updateQuality();
            ae(intent);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragmentActivity, android.support.v4.app.FragmentActivity, android.app.Activity
    public void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (i2 == -1) {
            af(intent);
        }
    }

    @Override // com.baidu.adp.base.BdBaseFragmentActivity, android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.hDb.bFq()) {
            bFg();
        } else if (view == this.hDb.bFs()) {
            bFg();
        } else if (view == this.hDb.bFp()) {
            if (this.hDa != null) {
                this.hDa.setLastAlbumId(null);
            }
            bFm();
        } else if (view == this.hDb.bFr()) {
            xk(0);
        } else if (view == this.hDb.bFt()) {
            xi(2);
        } else if (view == this.hDb.bFu()) {
            xi(1);
        }
    }

    private void xi(int i) {
        if (this.hDb != null && this.hDa != null) {
            this.hDa.setOriginalImg(!this.hDa.isOriginalImg());
            bFi();
            xj(i);
        }
    }

    private void xj(int i) {
        if (this.hDa != null && this.hDa.isOriginalImg() && !StringUtils.isNull(this.from, true) && !StringUtils.isNull(this.forumId, true)) {
            TiebaStatic.log(new ak("c10349").aa(ImageViewerConfig.FORUM_ID, this.forumId).aa("obj_type", this.from).s("obj_locate", i));
        }
    }

    public void bFi() {
        if (this.hDa != null && this.hDb != null) {
            this.hDb.nx(this.hDa.isOriginalImg());
        }
    }

    public View auC() {
        return this.dDt;
    }

    public int bFj() {
        return this.hDf;
    }

    public e bFk() {
        return this.hDa;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void xk(int i) {
        if (!this.hDc) {
            FragmentTransaction beginTransaction = getSupportFragmentManager().beginTransaction();
            Fragment findFragmentByTag = getSupportFragmentManager().findFragmentByTag(this.hDb.xm(this.mCurrentPage));
            if (findFragmentByTag != null) {
                beginTransaction.hide(findFragmentByTag);
            }
            this.mCurrentPage = i;
            if (getSupportFragmentManager().findFragmentByTag(this.hDb.xm(i)) != null) {
                beginTransaction.show(this.hDb.xl(i));
            } else {
                beginTransaction.add(d.g.fragment, this.hDb.xl(i), this.hDb.xm(i));
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
        int maxImagesAllowed = this.hDa.getMaxImagesAllowed();
        if (this.hDa.size() < maxImagesAllowed) {
            if (this.hDd == null || this.hDd.e(imageFileInfo)) {
                ImageFileInfo imageFileInfo2 = new ImageFileInfo();
                imageFileInfo2.setAlbumnId(imageFileInfo.getAlbumId());
                imageFileInfo2.setFilePath(imageFileInfo.getFilePath());
                imageFileInfo2.setModifyTime(imageFileInfo.getModifyTime());
                imageFileInfo2.setIsGif(imageFileInfo.isGif());
                imageFileInfo2.setIsLong(imageFileInfo.isLong());
                this.hDa.a(null);
                this.hDa.addChooseFile(imageFileInfo2);
                bFi();
                return true;
            }
            return false;
        } else if (bFl()) {
            return c(imageFileInfo);
        } else {
            showToast(String.format(getPageContext().getContext().getString(d.j.album_beyond_max_choose), Integer.valueOf(maxImagesAllowed)));
            return false;
        }
    }

    public boolean bFl() {
        if (getIntent().getBooleanExtra(AlbumActivityConfig.IS_SELECT_DIRECTLY, false)) {
            int maxImagesAllowed = this.hDa.getMaxImagesAllowed();
            if (this.hDa.size() == maxImagesAllowed && maxImagesAllowed == 1) {
                try {
                    ImageFileInfo imageFileInfo = (ImageFileInfo) v.f(this.hDa.bFC(), 0);
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
        this.hDa.a(null);
        this.hDa.delChooseFile(imageFileInfo);
        bFi();
        return true;
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i == 4) {
            closeLoadingDialog();
            if (this.mCurrentPage == 0) {
                if (this.hDa != null) {
                    this.hDa.setLastAlbumId(null);
                }
                bFm();
                return true;
            } else if (this.mCurrentPage == 1) {
                xk(0);
                return true;
            } else {
                return true;
            }
        }
        return super.onKeyDown(i, keyEvent);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void f(ImageFileInfo imageFileInfo, boolean z) {
        Fragment xl;
        if (this.hDb != null && (xl = this.hDb.xl(0)) != null && (xl instanceof k)) {
            ((k) xl).h(imageFileInfo, z);
        }
    }

    void g(ImageFileInfo imageFileInfo, boolean z) {
        Fragment xl;
        if (this.hDb != null && (xl = this.hDb.xl(1)) != null && (xl instanceof b)) {
            ((b) xl).h(imageFileInfo, z);
        }
    }

    private void bFm() {
        Intent intent = new Intent();
        String lastAlbumId = this.hDa.getLastAlbumId();
        if (TextUtils.isEmpty(lastAlbumId)) {
            lastAlbumId = "";
        }
        intent.putExtra(AlbumActivityConfig.LAST_ALBUM_ID, lastAlbumId);
        intent.putExtra(AlbumActivityConfig.CAMERA_REQUEST_FROM, this.hDe);
        setResult(0, intent);
        finish();
    }

    private void stopCamera() {
        if (this.hDb != null) {
            this.hDb.stopCamera();
        }
    }

    private void bFn() {
        if (this.hDb != null) {
            this.hDb.bFn();
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
        this.hDc = true;
        stopCamera();
        closeLoadingDialog();
        dismissAllDialog();
        f.bFG().destory();
        if (this.dDt != null) {
            this.dDt.setBackgroundDrawable(null);
        }
        if (this.hDb != null) {
            this.hDb.onDestroy();
        }
        if (this.hDj != null) {
            this.hDj.onDestroy();
        }
    }

    @Override // android.support.v4.app.FragmentActivity, android.app.Activity, android.support.v4.app.ActivityCompat.OnRequestPermissionsResultCallback
    public void onRequestPermissionsResult(int i, String[] strArr, int[] iArr) {
        if (i == 1) {
            if (!ab.aU(getApplicationContext())) {
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
            new com.baidu.tbadk.img.f(null).c(AlbumActivity.this.hDa.getWriteImagesInfo(), true);
            return AlbumActivity.this.hDa.getWriteImagesInfo().toJsonString();
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
        if (this.hDj != null) {
            this.hDj.onStart();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.adp.base.BdBaseFragmentActivity, android.support.v4.app.FragmentActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        bFn();
        if (this.hDj != null) {
            this.hDj.onResume();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.base.BdBaseFragmentActivity, android.support.v4.app.FragmentActivity, android.app.Activity
    public void onStop() {
        super.onStop();
        if (this.hDj != null) {
            this.hDj.onStop();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.adp.base.BdBaseFragmentActivity, android.support.v4.app.FragmentActivity, android.app.Activity
    public void onPause() {
        stopCamera();
        super.onPause();
    }
}
