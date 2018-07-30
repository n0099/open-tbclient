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
import com.baidu.tieba.d;
import com.baidu.tieba.frs.ForumWriteData;
/* loaded from: classes3.dex */
public class AlbumActivity extends BaseFragmentActivity implements View.OnClickListener, a.InterfaceC0062a {
    private boolean dpI;
    private com.baidu.tieba.c.d fEi;
    private c htA;
    private com.baidu.tieba.write.album.a htB;
    private e htD;
    private i htJ;
    private int mCurrentPage = 0;
    private boolean htC = false;
    private String callFrom = "";
    private String from = "";
    private String forumName = "";
    private String forumId = "0";
    private int htE = 0;
    private int htF = 0;
    private boolean htG = false;
    private boolean htH = false;
    private int htI = 0;
    private View dox = null;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.adp.base.BdBaseFragmentActivity, android.support.v4.app.FragmentActivity, android.support.v4.app.SupportActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setSwipeBackEnabled(false);
        setContentView(d.h.album_activity);
        this.dox = findViewById(d.g.statebar_view);
        this.dpI = UtilHelper.canUseStyleImmersiveSticky();
        Ua();
        initData(bundle);
        this.htB = new com.baidu.tieba.write.album.a(this);
        this.htB.aBc();
        vn(0);
    }

    public void showTip(View view) {
        if (this.fEi == null && view != null) {
            this.fEi = new com.baidu.tieba.c.d(getPageContext(), view);
            this.fEi.jp(d.f.bg_tip_blue_up_left);
            this.fEi.k(new View.OnClickListener() { // from class: com.baidu.tieba.write.album.AlbumActivity.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    AlbumActivity.this.fEi.akM();
                }
            });
            this.fEi.jo(16);
            this.fEi.jq(5000);
        }
        if (this.fEi != null) {
            String sharedPrefKeyWithAccount = com.baidu.tbadk.core.sharedPref.b.getSharedPrefKeyWithAccount("key_show_take_photo_tip");
            this.fEi.aO(getString(d.j.album_take_photo_tip), sharedPrefKeyWithAccount);
        }
    }

    private void Ua() {
        if (this.dox != null) {
            if (this.dpI && this.dox.getLayoutParams() != null) {
                ViewGroup.LayoutParams layoutParams = this.dox.getLayoutParams();
                layoutParams.height = UtilHelper.getStatusBarHeight();
                this.dox.setLayoutParams(layoutParams);
                fP(true);
                return;
            }
            fP(false);
        }
    }

    private void fP(boolean z) {
        if (this.dox != null) {
            if (this.dpI && z && this.dox.getVisibility() != 0) {
                this.dox.setVisibility(0);
            } else if (!z && this.dox.getVisibility() != 8) {
                this.dox.setVisibility(8);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.support.v4.app.FragmentActivity, android.support.v4.app.SupportActivity, android.app.Activity
    public void onSaveInstanceState(Bundle bundle) {
        bundle.putString(AlbumActivityConfig.WRITE_IMAGES_INFO, this.htA.getWriteImagesInfo().toJsonString());
        bundle.putBoolean(AlbumActivityConfig.USE_ORIGINAL_IMG, this.htG);
        bundle.putInt(AlbumActivityConfig.CAMERA_REQUEST_FROM, this.htE);
        bundle.putString("forum_id", this.forumId);
        bundle.putString("forum_name", this.forumName);
        bundle.putInt(IntentConfig.KEY_ALBUM_THREAD, this.htF);
        bundle.putBoolean(IntentConfig.KEY_FROM_WRITEACTIVITY, this.htH);
    }

    private void initData(Bundle bundle) {
        this.htA = new c(this);
        if (bundle != null) {
            WriteImagesInfo writeImagesInfo = new WriteImagesInfo();
            writeImagesInfo.parseJson(bundle.getString(AlbumActivityConfig.WRITE_IMAGES_INFO));
            this.htA.setWriteImagesInfo(writeImagesInfo);
            this.htG = bundle.getBoolean(AlbumActivityConfig.USE_ORIGINAL_IMG, false);
            this.htE = bundle.getInt(AlbumActivityConfig.CAMERA_REQUEST_FROM, 0);
            this.forumId = bundle.getString("forum_id");
            this.forumName = bundle.getString("forum_name");
            this.htF = bundle.getInt(IntentConfig.KEY_ALBUM_THREAD);
            this.htH = bundle.getBoolean(IntentConfig.KEY_FROM_WRITEACTIVITY);
            this.callFrom = bundle.getString("KEY_CALL_FROM");
            this.htI = bundle.getInt("from_type");
        } else {
            Intent intent = getIntent();
            if (intent != null) {
                WriteImagesInfo writeImagesInfo2 = new WriteImagesInfo();
                writeImagesInfo2.parseJson(intent.getStringExtra(AlbumActivityConfig.WRITE_IMAGES_INFO));
                this.htA.setWriteImagesInfo(writeImagesInfo2);
                this.htA.setOriginalImg(writeImagesInfo2.isOriginalImg());
                this.htG = intent.getBooleanExtra(AlbumActivityConfig.USE_ORIGINAL_IMG, false);
                this.htE = intent.getIntExtra(AlbumActivityConfig.CAMERA_REQUEST_FROM, 0);
                this.from = intent.getStringExtra("from");
                this.forumId = intent.getStringExtra("forum_id");
                this.forumName = intent.getStringExtra("forum_name");
                this.htF = intent.getIntExtra(IntentConfig.KEY_ALBUM_THREAD, 0);
                this.htH = intent.getBooleanExtra(IntentConfig.KEY_FROM_WRITEACTIVITY, false);
                this.callFrom = intent.getStringExtra("KEY_CALL_FROM");
                this.htI = intent.getIntExtra("from_type", 0);
            }
        }
        bFA();
    }

    private void bFA() {
        if (this.htE == 2) {
            this.htD = new e() { // from class: com.baidu.tieba.write.album.AlbumActivity.2
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
                    AlbumActivity.this.showToastWithIcon(AlbumActivity.this.getPageContext().getPageActivity().getString(d.j.uploade_attation), d.f.icon_toast_game_error);
                    return false;
                }
            };
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity
    protected void onChangeSkinType(int i) {
        if (this.htB != null) {
            this.htB.onChangeSkinType(i);
        }
        am.e(this.dox, d.C0140d.cp_bg_line_d, i);
    }

    public void bFB() {
        if (this.htE == 3) {
            TiebaStatic.log("c10489");
        }
        if (this.htE == 5) {
            showLoadingDialog("正在上传");
            new a().execute(new String[0]);
        } else if (this.htA != null) {
            if (this.htJ == null || !this.htJ.bGo()) {
                if (this.htA.bFV()) {
                    VideoFileInfo bFT = this.htA.bFT();
                    if (this.htJ == null) {
                        this.htJ = new i(this, this.forumName, this.forumId, "");
                        if (this.htB != null) {
                            this.htB.a(this.htJ);
                        }
                    }
                    this.htJ.a(bFT, this.callFrom);
                } else if (w.y(this.htA.bFX()) == 1 && this.htI == 0) {
                    bFC();
                } else {
                    ab(null);
                }
            }
        }
    }

    private void ab(Intent intent) {
        Intent intent2 = new Intent();
        intent2.putExtra(AlbumActivityConfig.ALBUM_RESULT, this.htA.getWriteImagesInfo().toJsonString());
        intent2.putExtra(AlbumActivityConfig.CAMERA_REQUEST_FROM, this.htE);
        intent2.putExtra("from_type", this.htI);
        if (intent != null && !StringUtils.isNull(intent.getStringExtra("file_name"))) {
            intent2.putExtra("file_name", intent.getStringExtra("file_name"));
        }
        setResult(-1, intent2);
        finish();
    }

    private boolean abJ() {
        Activity pageActivity = getPageContext().getPageActivity();
        com.baidu.tbadk.core.util.b.a aVar = new com.baidu.tbadk.core.util.b.a();
        aVar.zY();
        aVar.c(pageActivity, "android.permission.CAMERA");
        aVar.c(pageActivity, "android.permission.RECORD_AUDIO");
        aVar.c(pageActivity, "android.permission.WRITE_EXTERNAL_STORAGE");
        return aVar.u(pageActivity);
    }

    public void b(TbPageContext tbPageContext) {
        if (!abJ() && com.baidu.tieba.write.e.bFu()) {
            sendMessage(new CustomMessage(2002001, new RecordVideoActivityConfig(tbPageContext.getPageActivity(), this.htH ? 2 : 3, new ForumWriteData(this.forumId, this.forumName, null, null), this.htA.getWriteImagesInfo(), "", this.htI)));
            TiebaStatic.log(new an("c12611").r("obj_locate", 5).r("obj_type", 2));
        }
    }

    private void bFC() {
        WriteImagesInfo writeImagesInfo;
        if (this.htA != null && (writeImagesInfo = this.htA.getWriteImagesInfo()) != null) {
            sendMessage(new CustomMessage(2002001, new WriteMulitImageActivityConfig(getPageContext().getPageActivity(), IEventCenterService.EventId.EventMode.SAPIACCOUNT_THROUGH_SERVER, writeImagesInfo, 0)));
        }
    }

    private void ac(Intent intent) {
        if (intent == null || this.htA == null) {
            ab(null);
            return;
        }
        String stringExtra = intent.getStringExtra(AlbumActivityConfig.ALBUM_RESULT);
        if (stringExtra != null) {
            WriteImagesInfo writeImagesInfo = this.htA.getWriteImagesInfo();
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
        if (view == this.htB.bFL()) {
            bFB();
        } else if (view == this.htB.bFN()) {
            bFB();
        } else if (view == this.htB.bFK()) {
            if (this.htA != null) {
                this.htA.setLastAlbumId(null);
            }
            bFH();
        } else if (view == this.htB.bFM()) {
            vn(0);
        } else if (view == this.htB.bFO()) {
            vl(2);
        } else if (view == this.htB.bFP()) {
            vl(1);
        }
    }

    private void vl(int i) {
        if (this.htB != null && this.htA != null) {
            this.htA.setOriginalImg(!this.htA.isOriginalImg());
            bFD();
            vm(i);
        }
    }

    private void vm(int i) {
        if (this.htA != null && this.htA.isOriginalImg() && !StringUtils.isNull(this.from, true) && !StringUtils.isNull(this.forumId, true)) {
            TiebaStatic.log(new an("c10349").af(ImageViewerConfig.FORUM_ID, this.forumId).af("obj_type", this.from).r("obj_locate", i));
        }
    }

    public void bFD() {
        if (this.htA != null && this.htB != null) {
            this.htB.ns(this.htA.isOriginalImg());
        }
    }

    public View auQ() {
        return this.dox;
    }

    public int bFE() {
        return this.htF;
    }

    public c bFF() {
        return this.htA;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void vn(int i) {
        if (!this.htC) {
            FragmentTransaction beginTransaction = getSupportFragmentManager().beginTransaction();
            Fragment findFragmentByTag = getSupportFragmentManager().findFragmentByTag(this.htB.vp(this.mCurrentPage));
            if (findFragmentByTag != null) {
                beginTransaction.hide(findFragmentByTag);
            }
            this.mCurrentPage = i;
            if (getSupportFragmentManager().findFragmentByTag(this.htB.vp(i)) != null) {
                beginTransaction.show(this.htB.vo(i));
            } else {
                beginTransaction.add(d.g.fragment, this.htB.vo(i), this.htB.vp(i));
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
        int maxImagesAllowed = this.htA.getMaxImagesAllowed();
        if (this.htA.size() < maxImagesAllowed) {
            if (this.htD == null || this.htD.e(imageFileInfo)) {
                ImageFileInfo imageFileInfo2 = new ImageFileInfo();
                imageFileInfo2.setAlbumnId(imageFileInfo.getAlbumId());
                imageFileInfo2.setFilePath(imageFileInfo.getFilePath());
                imageFileInfo2.setModifyTime(imageFileInfo.getModifyTime());
                imageFileInfo2.setIsGif(imageFileInfo.isGif());
                imageFileInfo2.setIsLong(imageFileInfo.isLong());
                this.htA.a(null);
                this.htA.addChooseFile(imageFileInfo2);
                bFD();
                return true;
            }
            return false;
        } else if (bFG()) {
            return c(imageFileInfo);
        } else {
            showToast(String.format(getPageContext().getContext().getString(d.j.album_beyond_max_choose), Integer.valueOf(maxImagesAllowed)));
            return false;
        }
    }

    public boolean bFG() {
        if (getIntent().getBooleanExtra(AlbumActivityConfig.IS_SELECT_DIRECTLY, false)) {
            int maxImagesAllowed = this.htA.getMaxImagesAllowed();
            if (this.htA.size() == maxImagesAllowed && maxImagesAllowed == 1) {
                try {
                    ImageFileInfo imageFileInfo = (ImageFileInfo) w.d(this.htA.bFX(), 0);
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
        this.htA.a(null);
        this.htA.delChooseFile(imageFileInfo);
        bFD();
        return true;
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i == 4) {
            closeLoadingDialog();
            if (this.mCurrentPage == 0) {
                if (this.htA != null) {
                    this.htA.setLastAlbumId(null);
                }
                bFH();
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
        if (this.htB != null && (vo = this.htB.vo(0)) != null && (vo instanceof ImageListFragment)) {
            ((ImageListFragment) vo).h(imageFileInfo, z);
        }
    }

    void g(ImageFileInfo imageFileInfo, boolean z) {
        Fragment vo;
        if (this.htB != null && (vo = this.htB.vo(1)) != null && (vo instanceof AlbumImageBrowseFragment)) {
            ((AlbumImageBrowseFragment) vo).h(imageFileInfo, z);
        }
    }

    private void bFH() {
        Intent intent = new Intent();
        String lastAlbumId = this.htA.getLastAlbumId();
        if (TextUtils.isEmpty(lastAlbumId)) {
            lastAlbumId = "";
        }
        intent.putExtra(AlbumActivityConfig.LAST_ALBUM_ID, lastAlbumId);
        intent.putExtra(AlbumActivityConfig.CAMERA_REQUEST_FROM, this.htE);
        setResult(0, intent);
        finish();
    }

    private void stopCamera() {
        if (this.htB != null) {
            this.htB.stopCamera();
        }
    }

    private void bFI() {
        if (this.htB != null) {
            this.htB.bFI();
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
        this.htC = true;
        stopCamera();
        closeLoadingDialog();
        dismissAllDialog();
        d.bGb().destory();
        if (this.dox != null) {
            this.dox.setBackgroundDrawable(null);
        }
        if (this.htB != null) {
            this.htB.onDestroy();
        }
        if (this.htJ != null) {
            this.htJ.onDestroy();
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
        /* renamed from: i */
        public String doInBackground(String... strArr) {
            new com.baidu.tbadk.img.f(null).c(AlbumActivity.this.htA.getWriteImagesInfo(), true);
            return AlbumActivity.this.htA.getWriteImagesInfo().toJsonString();
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
        if (this.htJ != null) {
            this.htJ.onStart();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.adp.base.BdBaseFragmentActivity, android.support.v4.app.FragmentActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        bFI();
        if (this.htJ != null) {
            this.htJ.onResume();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.base.BdBaseFragmentActivity, android.support.v4.app.FragmentActivity, android.app.Activity
    public void onStop() {
        super.onStop();
        if (this.htJ != null) {
            this.htJ.onStop();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.adp.base.BdBaseFragmentActivity, android.support.v4.app.FragmentActivity, android.app.Activity
    public void onPause() {
        stopCamera();
        super.onPause();
    }
}
