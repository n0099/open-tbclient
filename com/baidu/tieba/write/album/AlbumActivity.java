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
import com.baidu.tbadk.core.util.al;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.v;
import com.baidu.tbadk.img.ImageFileInfo;
import com.baidu.tbadk.img.WriteImagesInfo;
import com.baidu.tieba.e;
import com.baidu.tieba.frs.ForumWriteData;
/* loaded from: classes3.dex */
public class AlbumActivity extends BaseFragmentActivity implements View.OnClickListener, a.InterfaceC0062a {
    private boolean dvU;
    private com.baidu.tieba.c.d fLL;
    private e hBA;
    private i hBG;
    private c hBx;
    private com.baidu.tieba.write.album.a hBy;
    private int mCurrentPage = 0;
    private boolean hBz = false;
    private String callFrom = "";
    private String from = "";
    private String forumName = "";
    private String forumId = "0";
    private int hBB = 0;
    private int hBC = 0;
    private boolean hBD = false;
    private boolean hBE = false;
    private int hBF = 0;
    private View dus = null;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.adp.base.BdBaseFragmentActivity, android.support.v4.app.FragmentActivity, android.support.v4.app.SupportActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setSwipeBackEnabled(false);
        setContentView(e.h.album_activity);
        this.dus = findViewById(e.g.statebar_view);
        this.dvU = UtilHelper.canUseStyleImmersiveSticky();
        VQ();
        initData(bundle);
        this.hBy = new com.baidu.tieba.write.album.a(this);
        this.hBy.aDh();
        vN(0);
    }

    public void showTip(View view) {
        if (this.fLL == null && view != null) {
            this.fLL = new com.baidu.tieba.c.d(getPageContext(), view);
            this.fLL.jN(e.f.bg_tip_blue_up_left);
            this.fLL.k(new View.OnClickListener() { // from class: com.baidu.tieba.write.album.AlbumActivity.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    AlbumActivity.this.fLL.amz();
                }
            });
            this.fLL.jM(16);
            this.fLL.jO(5000);
        }
        if (this.fLL != null) {
            String sharedPrefKeyWithAccount = com.baidu.tbadk.core.sharedPref.b.getSharedPrefKeyWithAccount("key_show_take_photo_tip");
            this.fLL.aW(getString(e.j.album_take_photo_tip), sharedPrefKeyWithAccount);
        }
    }

    private void VQ() {
        if (this.dus != null) {
            if (this.dvU && this.dus.getLayoutParams() != null) {
                ViewGroup.LayoutParams layoutParams = this.dus.getLayoutParams();
                layoutParams.height = UtilHelper.getStatusBarHeight();
                this.dus.setLayoutParams(layoutParams);
                gm(true);
                return;
            }
            gm(false);
        }
    }

    private void gm(boolean z) {
        if (this.dus != null) {
            if (this.dvU && z && this.dus.getVisibility() != 0) {
                this.dus.setVisibility(0);
            } else if (!z && this.dus.getVisibility() != 8) {
                this.dus.setVisibility(8);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.support.v4.app.FragmentActivity, android.support.v4.app.SupportActivity, android.app.Activity
    public void onSaveInstanceState(Bundle bundle) {
        bundle.putString(AlbumActivityConfig.WRITE_IMAGES_INFO, this.hBx.getWriteImagesInfo().toJsonString());
        bundle.putBoolean(AlbumActivityConfig.USE_ORIGINAL_IMG, this.hBD);
        bundle.putInt(AlbumActivityConfig.CAMERA_REQUEST_FROM, this.hBB);
        bundle.putString("forum_id", this.forumId);
        bundle.putString("forum_name", this.forumName);
        bundle.putInt(IntentConfig.KEY_ALBUM_THREAD, this.hBC);
        bundle.putBoolean(IntentConfig.KEY_FROM_WRITEACTIVITY, this.hBE);
    }

    private void initData(Bundle bundle) {
        this.hBx = new c(this);
        if (bundle != null) {
            WriteImagesInfo writeImagesInfo = new WriteImagesInfo();
            writeImagesInfo.parseJson(bundle.getString(AlbumActivityConfig.WRITE_IMAGES_INFO));
            this.hBx.setWriteImagesInfo(writeImagesInfo);
            this.hBD = bundle.getBoolean(AlbumActivityConfig.USE_ORIGINAL_IMG, false);
            this.hBB = bundle.getInt(AlbumActivityConfig.CAMERA_REQUEST_FROM, 0);
            this.forumId = bundle.getString("forum_id");
            this.forumName = bundle.getString("forum_name");
            this.hBC = bundle.getInt(IntentConfig.KEY_ALBUM_THREAD);
            this.hBE = bundle.getBoolean(IntentConfig.KEY_FROM_WRITEACTIVITY);
            this.callFrom = bundle.getString("KEY_CALL_FROM");
            this.hBF = bundle.getInt("from_type");
        } else {
            Intent intent = getIntent();
            if (intent != null) {
                WriteImagesInfo writeImagesInfo2 = new WriteImagesInfo();
                writeImagesInfo2.parseJson(intent.getStringExtra(AlbumActivityConfig.WRITE_IMAGES_INFO));
                this.hBx.setWriteImagesInfo(writeImagesInfo2);
                this.hBx.setOriginalImg(writeImagesInfo2.isOriginalImg());
                this.hBD = intent.getBooleanExtra(AlbumActivityConfig.USE_ORIGINAL_IMG, false);
                this.hBB = intent.getIntExtra(AlbumActivityConfig.CAMERA_REQUEST_FROM, 0);
                this.from = intent.getStringExtra("from");
                this.forumId = intent.getStringExtra("forum_id");
                this.forumName = intent.getStringExtra("forum_name");
                this.hBC = intent.getIntExtra(IntentConfig.KEY_ALBUM_THREAD, 0);
                this.hBE = intent.getBooleanExtra(IntentConfig.KEY_FROM_WRITEACTIVITY, false);
                this.callFrom = intent.getStringExtra("KEY_CALL_FROM");
                this.hBF = intent.getIntExtra("from_type", 0);
            }
        }
        bIu();
    }

    private void bIu() {
        if (this.hBB == 2) {
            this.hBA = new e() { // from class: com.baidu.tieba.write.album.AlbumActivity.2
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
        if (this.hBy != null) {
            this.hBy.onChangeSkinType(i);
        }
        al.e(this.dus, e.d.cp_bg_line_d, i);
    }

    public void bIv() {
        if (this.hBB == 3) {
            TiebaStatic.log("c10489");
        }
        if (this.hBB == 5) {
            showLoadingDialog("正在上传");
            new a().execute(new String[0]);
        } else if (this.hBx != null) {
            if (this.hBG == null || !this.hBG.bJi()) {
                if (this.hBx.bIP()) {
                    VideoFileInfo bIN = this.hBx.bIN();
                    if (this.hBG == null) {
                        this.hBG = new i(this, this.forumName, this.forumId, "");
                        if (this.hBy != null) {
                            this.hBy.a(this.hBG);
                        }
                    }
                    this.hBG.a(bIN, this.callFrom);
                } else if (v.y(this.hBx.bIR()) == 1 && this.hBF == 0) {
                    bIw();
                } else {
                    ab(null);
                }
            }
        }
    }

    private void ab(Intent intent) {
        Intent intent2 = new Intent();
        intent2.putExtra(AlbumActivityConfig.ALBUM_RESULT, this.hBx.getWriteImagesInfo().toJsonString());
        intent2.putExtra(AlbumActivityConfig.CAMERA_REQUEST_FROM, this.hBB);
        intent2.putExtra("from_type", this.hBF);
        if (intent != null && !StringUtils.isNull(intent.getStringExtra("file_name"))) {
            intent2.putExtra("file_name", intent.getStringExtra("file_name"));
        }
        setResult(-1, intent2);
        finish();
    }

    private boolean adw() {
        Activity pageActivity = getPageContext().getPageActivity();
        com.baidu.tbadk.core.util.b.a aVar = new com.baidu.tbadk.core.util.b.a();
        aVar.Bb();
        aVar.c(pageActivity, "android.permission.CAMERA");
        aVar.c(pageActivity, "android.permission.RECORD_AUDIO");
        aVar.c(pageActivity, "android.permission.WRITE_EXTERNAL_STORAGE");
        return aVar.x(pageActivity);
    }

    public void b(TbPageContext tbPageContext) {
        if (!adw() && com.baidu.tieba.write.e.bIo()) {
            sendMessage(new CustomMessage(2002001, new RecordVideoActivityConfig(tbPageContext.getPageActivity(), this.hBE ? 2 : 3, new ForumWriteData(this.forumId, this.forumName, null, null), this.hBx.getWriteImagesInfo(), "", this.hBF)));
            TiebaStatic.log(new am("c12611").w("obj_locate", 5).w("obj_type", 2));
        }
    }

    private void bIw() {
        WriteImagesInfo writeImagesInfo;
        if (this.hBx != null && (writeImagesInfo = this.hBx.getWriteImagesInfo()) != null) {
            sendMessage(new CustomMessage(2002001, new WriteMulitImageActivityConfig(getPageContext().getPageActivity(), IEventCenterService.EventId.EventMode.SAPIACCOUNT_THROUGH_SERVER, writeImagesInfo, 0)));
        }
    }

    private void ac(Intent intent) {
        if (intent == null || this.hBx == null) {
            ab(null);
            return;
        }
        String stringExtra = intent.getStringExtra(AlbumActivityConfig.ALBUM_RESULT);
        if (stringExtra != null) {
            WriteImagesInfo writeImagesInfo = this.hBx.getWriteImagesInfo();
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
        if (view == this.hBy.bIF()) {
            bIv();
        } else if (view == this.hBy.bIH()) {
            bIv();
        } else if (view == this.hBy.bIE()) {
            if (this.hBx != null) {
                this.hBx.setLastAlbumId(null);
            }
            bIB();
        } else if (view == this.hBy.bIG()) {
            vN(0);
        } else if (view == this.hBy.bII()) {
            vL(2);
        } else if (view == this.hBy.bIJ()) {
            vL(1);
        }
    }

    private void vL(int i) {
        if (this.hBy != null && this.hBx != null) {
            this.hBx.setOriginalImg(!this.hBx.isOriginalImg());
            bIx();
            vM(i);
        }
    }

    private void vM(int i) {
        if (this.hBx != null && this.hBx.isOriginalImg() && !StringUtils.isNull(this.from, true) && !StringUtils.isNull(this.forumId, true)) {
            TiebaStatic.log(new am("c10349").al(ImageViewerConfig.FORUM_ID, this.forumId).al("obj_type", this.from).w("obj_locate", i));
        }
    }

    public void bIx() {
        if (this.hBx != null && this.hBy != null) {
            this.hBy.nP(this.hBx.isOriginalImg());
        }
    }

    public View awI() {
        return this.dus;
    }

    public int bIy() {
        return this.hBC;
    }

    public c bIz() {
        return this.hBx;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void vN(int i) {
        if (!this.hBz) {
            FragmentTransaction beginTransaction = getSupportFragmentManager().beginTransaction();
            Fragment findFragmentByTag = getSupportFragmentManager().findFragmentByTag(this.hBy.vP(this.mCurrentPage));
            if (findFragmentByTag != null) {
                beginTransaction.hide(findFragmentByTag);
            }
            this.mCurrentPage = i;
            if (getSupportFragmentManager().findFragmentByTag(this.hBy.vP(i)) != null) {
                beginTransaction.show(this.hBy.vO(i));
            } else {
                beginTransaction.add(e.g.fragment, this.hBy.vO(i), this.hBy.vP(i));
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
        int maxImagesAllowed = this.hBx.getMaxImagesAllowed();
        if (this.hBx.size() < maxImagesAllowed) {
            if (this.hBA == null || this.hBA.e(imageFileInfo)) {
                ImageFileInfo imageFileInfo2 = new ImageFileInfo();
                imageFileInfo2.setAlbumnId(imageFileInfo.getAlbumId());
                imageFileInfo2.setFilePath(imageFileInfo.getFilePath());
                imageFileInfo2.setModifyTime(imageFileInfo.getModifyTime());
                imageFileInfo2.setIsGif(imageFileInfo.isGif());
                imageFileInfo2.setIsLong(imageFileInfo.isLong());
                this.hBx.a(null);
                this.hBx.addChooseFile(imageFileInfo2);
                bIx();
                return true;
            }
            return false;
        } else if (bIA()) {
            return c(imageFileInfo);
        } else {
            showToast(String.format(getPageContext().getContext().getString(e.j.album_beyond_max_choose), Integer.valueOf(maxImagesAllowed)));
            return false;
        }
    }

    public boolean bIA() {
        if (getIntent().getBooleanExtra(AlbumActivityConfig.IS_SELECT_DIRECTLY, false)) {
            int maxImagesAllowed = this.hBx.getMaxImagesAllowed();
            if (this.hBx.size() == maxImagesAllowed && maxImagesAllowed == 1) {
                try {
                    ImageFileInfo imageFileInfo = (ImageFileInfo) v.d(this.hBx.bIR(), 0);
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
        this.hBx.a(null);
        this.hBx.delChooseFile(imageFileInfo);
        bIx();
        return true;
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i == 4) {
            closeLoadingDialog();
            if (this.mCurrentPage == 0) {
                if (this.hBx != null) {
                    this.hBx.setLastAlbumId(null);
                }
                bIB();
                return true;
            } else if (this.mCurrentPage == 1) {
                vN(0);
                return true;
            } else {
                return true;
            }
        }
        return super.onKeyDown(i, keyEvent);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void f(ImageFileInfo imageFileInfo, boolean z) {
        Fragment vO;
        if (this.hBy != null && (vO = this.hBy.vO(0)) != null && (vO instanceof ImageListFragment)) {
            ((ImageListFragment) vO).h(imageFileInfo, z);
        }
    }

    void g(ImageFileInfo imageFileInfo, boolean z) {
        Fragment vO;
        if (this.hBy != null && (vO = this.hBy.vO(1)) != null && (vO instanceof AlbumImageBrowseFragment)) {
            ((AlbumImageBrowseFragment) vO).h(imageFileInfo, z);
        }
    }

    private void bIB() {
        Intent intent = new Intent();
        String lastAlbumId = this.hBx.getLastAlbumId();
        if (TextUtils.isEmpty(lastAlbumId)) {
            lastAlbumId = "";
        }
        intent.putExtra(AlbumActivityConfig.LAST_ALBUM_ID, lastAlbumId);
        intent.putExtra(AlbumActivityConfig.CAMERA_REQUEST_FROM, this.hBB);
        setResult(0, intent);
        finish();
    }

    private void stopCamera() {
        if (this.hBy != null) {
            this.hBy.stopCamera();
        }
    }

    private void bIC() {
        if (this.hBy != null) {
            this.hBy.bIC();
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
        this.hBz = true;
        stopCamera();
        closeLoadingDialog();
        dismissAllDialog();
        d.bIV().destory();
        if (this.dus != null) {
            this.dus.setBackgroundDrawable(null);
        }
        if (this.hBy != null) {
            this.hBy.onDestroy();
        }
        if (this.hBG != null) {
            this.hBG.onDestroy();
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
            new com.baidu.tbadk.img.f(null).c(AlbumActivity.this.hBx.getWriteImagesInfo(), true);
            return AlbumActivity.this.hBx.getWriteImagesInfo().toJsonString();
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
        if (this.hBG != null) {
            this.hBG.onStart();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.adp.base.BdBaseFragmentActivity, android.support.v4.app.FragmentActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        bIC();
        if (this.hBG != null) {
            this.hBG.onResume();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.base.BdBaseFragmentActivity, android.support.v4.app.FragmentActivity, android.app.Activity
    public void onStop() {
        super.onStop();
        if (this.hBG != null) {
            this.hBG.onStop();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.adp.base.BdBaseFragmentActivity, android.support.v4.app.FragmentActivity, android.app.Activity
    public void onPause() {
        stopCamera();
        super.onPause();
    }
}
