package com.baidu.tieba.write.album;

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
public class AlbumActivity extends BaseFragmentActivity implements View.OnClickListener, a.InterfaceC0022a {
    private boolean cKw;
    private com.baidu.tieba.d.b fbt;
    private e hfd;
    private com.baidu.tieba.write.album.a hfe;
    private g hfg;
    private l hfl;
    private int mCurrentPage = 0;
    private boolean hff = false;
    private String callFrom = "";
    private String from = "";
    private String forumName = "";
    private String forumId = "0";
    private int hfh = 0;
    private int hfi = 0;
    private boolean hfj = false;
    private boolean fHF = false;
    private boolean hfk = false;
    private View cJa = null;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.adp.base.BdBaseFragmentActivity, android.support.v4.app.FragmentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setSwipeBackEnabled(false);
        setContentView(d.h.album_activity);
        this.cJa = findViewById(d.g.statebar_view);
        this.cKw = UtilHelper.canUseStyleImmersiveSticky();
        amI();
        initData(bundle);
        this.hfe = new com.baidu.tieba.write.album.a(this);
        this.hfe.aPR();
        vQ(0);
    }

    public void showTip(View view) {
        if (this.fbt == null && view != null) {
            this.fbt = new com.baidu.tieba.d.b(getPageContext(), view);
            this.fbt.iU(d.f.bg_tip_blue_up_left);
            this.fbt.j(new View.OnClickListener() { // from class: com.baidu.tieba.write.album.AlbumActivity.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    AlbumActivity.this.fbt.adI();
                }
            });
            this.fbt.iT(16);
            this.fbt.iV(5000);
        }
        if (this.fbt != null) {
            String sharedPrefKeyWithAccount = com.baidu.tbadk.core.sharedPref.b.getSharedPrefKeyWithAccount("key_show_take_photo_tip");
            this.fbt.aL(getString(d.j.album_take_photo_tip), sharedPrefKeyWithAccount);
        }
    }

    private void amI() {
        if (this.cJa != null) {
            if (this.cKw && this.cJa.getLayoutParams() != null) {
                ViewGroup.LayoutParams layoutParams = this.cJa.getLayoutParams();
                layoutParams.height = UtilHelper.getStatusBarHeight();
                this.cJa.setLayoutParams(layoutParams);
                fe(true);
                return;
            }
            fe(false);
        }
    }

    private void fe(boolean z) {
        if (this.cJa != null) {
            if (this.cKw && z && this.cJa.getVisibility() != 0) {
                this.cJa.setVisibility(0);
            } else if (!z && this.cJa.getVisibility() != 8) {
                this.cJa.setVisibility(8);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.support.v4.app.FragmentActivity, android.app.Activity
    public void onSaveInstanceState(Bundle bundle) {
        bundle.putString(AlbumActivityConfig.WRITE_IMAGES_INFO, this.hfd.getWriteImagesInfo().toJsonString());
        bundle.putBoolean(AlbumActivityConfig.USE_ORIGINAL_IMG, this.hfj);
        bundle.putInt(AlbumActivityConfig.CAMERA_REQUEST_FROM, this.hfh);
        bundle.putString("forum_id", this.forumId);
        bundle.putString("forum_name", this.forumName);
        bundle.putInt(IntentConfig.KEY_ALBUM_THREAD, this.hfi);
        bundle.putBoolean("from_write", this.fHF);
    }

    private void initData(Bundle bundle) {
        this.hfd = new e(this);
        if (bundle != null) {
            WriteImagesInfo writeImagesInfo = new WriteImagesInfo();
            writeImagesInfo.parseJson(bundle.getString(AlbumActivityConfig.WRITE_IMAGES_INFO));
            this.hfd.setWriteImagesInfo(writeImagesInfo);
            this.hfj = bundle.getBoolean(AlbumActivityConfig.USE_ORIGINAL_IMG, false);
            this.hfh = bundle.getInt(AlbumActivityConfig.CAMERA_REQUEST_FROM, 0);
            this.forumId = bundle.getString("forum_id");
            this.forumName = bundle.getString("forum_name");
            this.hfi = bundle.getInt(IntentConfig.KEY_ALBUM_THREAD);
            this.fHF = bundle.getBoolean("from_write");
            this.callFrom = bundle.getString("KEY_CALL_FROM");
            this.hfk = bundle.getBoolean(IntentConfig.KEY_FROM_IM);
        } else {
            Intent intent = getIntent();
            if (intent != null) {
                WriteImagesInfo writeImagesInfo2 = new WriteImagesInfo();
                writeImagesInfo2.parseJson(intent.getStringExtra(AlbumActivityConfig.WRITE_IMAGES_INFO));
                this.hfd.setWriteImagesInfo(writeImagesInfo2);
                this.hfd.setOriginalImg(writeImagesInfo2.isOriginalImg());
                this.hfj = intent.getBooleanExtra(AlbumActivityConfig.USE_ORIGINAL_IMG, false);
                this.hfh = intent.getIntExtra(AlbumActivityConfig.CAMERA_REQUEST_FROM, 0);
                this.from = intent.getStringExtra("from");
                this.forumId = intent.getStringExtra("forum_id");
                this.forumName = intent.getStringExtra("forum_name");
                this.hfi = intent.getIntExtra(IntentConfig.KEY_ALBUM_THREAD, 0);
                this.fHF = intent.getBooleanExtra("from_write", false);
                this.callFrom = intent.getStringExtra("KEY_CALL_FROM");
                this.hfk = intent.getBooleanExtra(IntentConfig.KEY_FROM_IM, false);
            }
        }
        bFV();
    }

    private void bFV() {
        if (this.hfh == 2) {
            this.hfg = new g() { // from class: com.baidu.tieba.write.album.AlbumActivity.2
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
        if (this.hfe != null) {
            this.hfe.onChangeSkinType(i);
        }
        aj.e(this.cJa, d.C0095d.cp_bg_line_d, i);
    }

    public void bFW() {
        if (this.hfh == 3) {
            TiebaStatic.log("c10489");
        }
        if (this.hfh == 5) {
            showLoadingDialog("正在上传");
            new a().execute(new String[0]);
        } else if (this.hfd != null) {
            if (this.hfl == null || !this.hfl.bGE()) {
                if (this.hfd.bGq()) {
                    VideoFileInfo bGo = this.hfd.bGo();
                    if (this.hfl == null) {
                        this.hfl = new l(this, this.forumName, this.forumId, "");
                        if (this.hfe != null) {
                            this.hfe.a(this.hfl);
                        }
                    }
                    this.hfl.a(bGo, this.callFrom);
                } else if (v.v(this.hfd.bGs()) == 1 && !this.hfk) {
                    bFX();
                } else {
                    ae(null);
                }
            }
        }
    }

    private void ae(Intent intent) {
        Intent intent2 = new Intent();
        intent2.putExtra(AlbumActivityConfig.ALBUM_RESULT, this.hfd.getWriteImagesInfo().toJsonString());
        intent2.putExtra(AlbumActivityConfig.CAMERA_REQUEST_FROM, this.hfh);
        intent2.putExtra(IntentConfig.KEY_FROM_IM, this.hfk);
        if (intent != null && !StringUtils.isNull(intent.getStringExtra("file_name"))) {
            intent2.putExtra("file_name", intent.getStringExtra("file_name"));
        }
        setResult(-1, intent2);
        finish();
    }

    public void c(TbPageContext tbPageContext) {
        if (com.baidu.tieba.write.f.bFO()) {
            sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new RecordVideoActivityConfig(tbPageContext.getPageActivity(), this.fHF ? 2 : 3, new ForumWriteData(this.forumId, this.forumName, null, null), this.hfd.getWriteImagesInfo(), "")));
            TiebaStatic.log(new ak("c12611").r("obj_locate", 5).r("obj_type", 2));
        }
    }

    private void bFX() {
        WriteImagesInfo writeImagesInfo;
        if (this.hfd != null && (writeImagesInfo = this.hfd.getWriteImagesInfo()) != null) {
            sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new WriteMulitImageActivityConfig(getPageContext().getPageActivity(), IEventCenterService.EventId.EventMode.SAPIACCOUNT_THROUGH_SERVER, writeImagesInfo, 0)));
        }
    }

    private void af(Intent intent) {
        if (intent == null || this.hfd == null) {
            ae(null);
            return;
        }
        String stringExtra = intent.getStringExtra(AlbumActivityConfig.ALBUM_RESULT);
        if (stringExtra != null) {
            WriteImagesInfo writeImagesInfo = this.hfd.getWriteImagesInfo();
            writeImagesInfo.parseJson(stringExtra);
            writeImagesInfo.updateQuality();
            ae(intent);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.support.v4.app.FragmentActivity, android.app.Activity
    public void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (i2 == -1) {
            af(intent);
        }
    }

    @Override // com.baidu.adp.base.BdBaseFragmentActivity, android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.hfe.bGg()) {
            bFW();
        } else if (view == this.hfe.bGi()) {
            bFW();
        } else if (view == this.hfe.bGf()) {
            if (this.hfd != null) {
                this.hfd.setLastAlbumId(null);
            }
            bGc();
        } else if (view == this.hfe.bGh()) {
            vQ(0);
        } else if (view == this.hfe.bGj()) {
            vO(2);
        } else if (view == this.hfe.bGk()) {
            vO(1);
        }
    }

    private void vO(int i) {
        if (this.hfe != null && this.hfd != null) {
            this.hfd.setOriginalImg(!this.hfd.isOriginalImg());
            bFY();
            vP(i);
        }
    }

    private void vP(int i) {
        if (this.hfd != null && this.hfd.isOriginalImg() && !StringUtils.isNull(this.from, true) && !StringUtils.isNull(this.forumId, true)) {
            TiebaStatic.log(new ak("c10349").ac(ImageViewerConfig.FORUM_ID, this.forumId).ac("obj_type", this.from).r("obj_locate", i));
        }
    }

    public void bFY() {
        if (this.hfd != null && this.hfe != null) {
            this.hfe.nX(this.hfd.isOriginalImg());
        }
    }

    public View alK() {
        return this.cJa;
    }

    public int bFZ() {
        return this.hfi;
    }

    public e bGa() {
        return this.hfd;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void vQ(int i) {
        if (!this.hff) {
            FragmentTransaction beginTransaction = getSupportFragmentManager().beginTransaction();
            Fragment findFragmentByTag = getSupportFragmentManager().findFragmentByTag(this.hfe.vS(this.mCurrentPage));
            if (findFragmentByTag != null) {
                beginTransaction.hide(findFragmentByTag);
            }
            this.mCurrentPage = i;
            if (getSupportFragmentManager().findFragmentByTag(this.hfe.vS(i)) != null) {
                beginTransaction.show(this.hfe.vR(i));
            } else {
                beginTransaction.add(d.g.fragment, this.hfe.vR(i), this.hfe.vS(i));
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
        int maxImagesAllowed = this.hfd.getMaxImagesAllowed();
        if (this.hfd.size() < maxImagesAllowed) {
            if (this.hfg == null || this.hfg.e(imageFileInfo)) {
                ImageFileInfo imageFileInfo2 = new ImageFileInfo();
                imageFileInfo2.setAlbumnId(imageFileInfo.getAlbumId());
                imageFileInfo2.setFilePath(imageFileInfo.getFilePath());
                imageFileInfo2.setModifyTime(imageFileInfo.getModifyTime());
                imageFileInfo2.setIsGif(imageFileInfo.isGif());
                imageFileInfo2.setIsLong(imageFileInfo.isLong());
                this.hfd.a(null);
                this.hfd.addChooseFile(imageFileInfo2);
                bFY();
                return true;
            }
            return false;
        } else if (bGb()) {
            return c(imageFileInfo);
        } else {
            showToast(String.format(getPageContext().getContext().getString(d.j.album_beyond_max_choose), Integer.valueOf(maxImagesAllowed)));
            return false;
        }
    }

    public boolean bGb() {
        if (getIntent().getBooleanExtra(AlbumActivityConfig.IS_SELECT_DIRECTLY, false)) {
            int maxImagesAllowed = this.hfd.getMaxImagesAllowed();
            if (this.hfd.size() == maxImagesAllowed && maxImagesAllowed == 1) {
                try {
                    ImageFileInfo imageFileInfo = (ImageFileInfo) v.c(this.hfd.bGs(), 0);
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
        this.hfd.a(null);
        this.hfd.delChooseFile(imageFileInfo);
        bFY();
        return true;
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity, android.support.v4.app.FragmentActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i == 4) {
            closeLoadingDialog();
            if (this.mCurrentPage == 0) {
                if (this.hfd != null) {
                    this.hfd.setLastAlbumId(null);
                }
                bGc();
                return true;
            } else if (this.mCurrentPage == 1) {
                vQ(0);
                return true;
            } else {
                return true;
            }
        }
        return super.onKeyDown(i, keyEvent);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void f(ImageFileInfo imageFileInfo, boolean z) {
        Fragment vR;
        if (this.hfe != null && (vR = this.hfe.vR(0)) != null && (vR instanceof k)) {
            ((k) vR).h(imageFileInfo, z);
        }
    }

    void g(ImageFileInfo imageFileInfo, boolean z) {
        Fragment vR;
        if (this.hfe != null && (vR = this.hfe.vR(1)) != null && (vR instanceof b)) {
            ((b) vR).h(imageFileInfo, z);
        }
    }

    private void bGc() {
        Intent intent = new Intent();
        String lastAlbumId = this.hfd.getLastAlbumId();
        if (TextUtils.isEmpty(lastAlbumId)) {
            lastAlbumId = "";
        }
        intent.putExtra(AlbumActivityConfig.LAST_ALBUM_ID, lastAlbumId);
        intent.putExtra(AlbumActivityConfig.CAMERA_REQUEST_FROM, this.hfh);
        setResult(0, intent);
        finish();
    }

    private void stopCamera() {
        if (this.hfe != null) {
            this.hfe.stopCamera();
        }
    }

    private void bGd() {
        if (this.hfe != null) {
            this.hfe.bGd();
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
        this.hff = true;
        stopCamera();
        closeLoadingDialog();
        dismissAllDialog();
        f.bGw().destory();
        if (this.cJa != null) {
            this.cJa.setBackgroundDrawable(null);
        }
        if (this.hfe != null) {
            this.hfe.onDestroy();
        }
        if (this.hfl != null) {
            this.hfl.onDestroy();
        }
    }

    @Override // android.app.Activity, com.baidu.b.a.a.InterfaceC0022a
    public void onRequestPermissionsResult(int i, String[] strArr, int[] iArr) {
        if (i == 1) {
            if (ab.aI(getApplicationContext())) {
                c(getPageContext());
            } else {
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
            new com.baidu.tbadk.img.f(null).c(AlbumActivity.this.hfd.getWriteImagesInfo(), true);
            return AlbumActivity.this.hfd.getWriteImagesInfo().toJsonString();
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
        if (this.hfl != null) {
            this.hfl.onStart();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.adp.base.BdBaseFragmentActivity, android.support.v4.app.FragmentActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        bGd();
        if (this.hfl != null) {
            this.hfl.onResume();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.base.BdBaseFragmentActivity, android.support.v4.app.FragmentActivity, android.app.Activity
    public void onStop() {
        super.onStop();
        if (this.hfl != null) {
            this.hfl.onStop();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.adp.base.BdBaseFragmentActivity, android.support.v4.app.FragmentActivity, android.app.Activity
    public void onPause() {
        stopCamera();
        super.onPause();
    }
}
