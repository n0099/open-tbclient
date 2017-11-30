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
    private boolean cKi;
    private com.baidu.tieba.d.b fal;
    private e hci;
    private com.baidu.tieba.write.album.a hcj;
    private g hcl;
    private l hcq;
    private int mCurrentPage = 0;
    private boolean hck = false;
    private String from = "";
    private String forumName = "";
    private String forumId = "0";
    private int hcm = 0;
    private int hcn = 0;
    private boolean hco = false;
    private boolean fGI = false;
    private boolean hcp = false;
    private View cIM = null;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.adp.base.BdBaseFragmentActivity, android.support.v4.app.FragmentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setSwipeBackEnabled(false);
        setContentView(d.h.album_activity);
        this.cIM = findViewById(d.g.statebar_view);
        this.cKi = UtilHelper.canUseStyleImmersiveSticky();
        amz();
        initData(bundle);
        this.hcj = new com.baidu.tieba.write.album.a(this);
        this.hcj.aPI();
        vE(0);
    }

    public void showTip(View view) {
        if (this.fal == null && view != null) {
            this.fal = new com.baidu.tieba.d.b(getPageContext(), view);
            this.fal.iS(d.f.bg_tip_blue_up_left);
            this.fal.j(new View.OnClickListener() { // from class: com.baidu.tieba.write.album.AlbumActivity.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    AlbumActivity.this.fal.adz();
                }
            });
            this.fal.iR(16);
            this.fal.iT(5000);
        }
        if (this.fal != null) {
            String sharedPrefKeyWithAccount = com.baidu.tbadk.core.sharedPref.b.getSharedPrefKeyWithAccount("key_show_take_photo_tip");
            this.fal.aK(getString(d.j.album_take_photo_tip), sharedPrefKeyWithAccount);
        }
    }

    private void amz() {
        if (this.cIM != null) {
            if (this.cKi && this.cIM.getLayoutParams() != null) {
                ViewGroup.LayoutParams layoutParams = this.cIM.getLayoutParams();
                layoutParams.height = UtilHelper.getStatusBarHeight();
                this.cIM.setLayoutParams(layoutParams);
                fd(true);
                return;
            }
            fd(false);
        }
    }

    private void fd(boolean z) {
        if (this.cIM != null) {
            if (this.cKi && z && this.cIM.getVisibility() != 0) {
                this.cIM.setVisibility(0);
            } else if (!z && this.cIM.getVisibility() != 8) {
                this.cIM.setVisibility(8);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.support.v4.app.FragmentActivity, android.app.Activity
    public void onSaveInstanceState(Bundle bundle) {
        bundle.putString(AlbumActivityConfig.WRITE_IMAGES_INFO, this.hci.getWriteImagesInfo().toJsonString());
        bundle.putBoolean(AlbumActivityConfig.USE_ORIGINAL_IMG, this.hco);
        bundle.putInt(AlbumActivityConfig.CAMERA_REQUEST_FROM, this.hcm);
        bundle.putString("forum_id", this.forumId);
        bundle.putString("forum_name", this.forumName);
        bundle.putInt(IntentConfig.KEY_ALBUM_THREAD, this.hcn);
        bundle.putBoolean("from_write", this.fGI);
    }

    private void initData(Bundle bundle) {
        this.hci = new e(this);
        if (bundle != null) {
            WriteImagesInfo writeImagesInfo = new WriteImagesInfo();
            writeImagesInfo.parseJson(bundle.getString(AlbumActivityConfig.WRITE_IMAGES_INFO));
            this.hci.setWriteImagesInfo(writeImagesInfo);
            this.hco = bundle.getBoolean(AlbumActivityConfig.USE_ORIGINAL_IMG, false);
            this.hcm = bundle.getInt(AlbumActivityConfig.CAMERA_REQUEST_FROM, 0);
            this.forumId = bundle.getString("forum_id");
            this.forumName = bundle.getString("forum_name");
            this.hcn = bundle.getInt(IntentConfig.KEY_ALBUM_THREAD);
            this.fGI = bundle.getBoolean("from_write");
            this.hcp = bundle.getBoolean(IntentConfig.KEY_FROM_IM);
        } else {
            Intent intent = getIntent();
            if (intent != null) {
                WriteImagesInfo writeImagesInfo2 = new WriteImagesInfo();
                writeImagesInfo2.parseJson(intent.getStringExtra(AlbumActivityConfig.WRITE_IMAGES_INFO));
                this.hci.setWriteImagesInfo(writeImagesInfo2);
                this.hci.setOriginalImg(writeImagesInfo2.isOriginalImg());
                this.hco = intent.getBooleanExtra(AlbumActivityConfig.USE_ORIGINAL_IMG, false);
                this.hcm = intent.getIntExtra(AlbumActivityConfig.CAMERA_REQUEST_FROM, 0);
                this.from = intent.getStringExtra("from");
                this.forumId = intent.getStringExtra("forum_id");
                this.forumName = intent.getStringExtra("forum_name");
                this.hcn = intent.getIntExtra(IntentConfig.KEY_ALBUM_THREAD, 0);
                this.fGI = intent.getBooleanExtra("from_write", false);
                this.hcp = intent.getBooleanExtra(IntentConfig.KEY_FROM_IM, false);
            }
        }
        bFj();
    }

    private void bFj() {
        if (this.hcm == 2) {
            this.hcl = new g() { // from class: com.baidu.tieba.write.album.AlbumActivity.2
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
        if (this.hcj != null) {
            this.hcj.onChangeSkinType(i);
        }
        aj.e(this.cIM, d.C0082d.cp_bg_line_d, i);
    }

    public void bFk() {
        if (this.hcm == 3) {
            TiebaStatic.log("c10489");
        }
        if (this.hcm == 5) {
            showLoadingDialog("正在上传");
            new a().execute(new String[0]);
        } else if (this.hci != null) {
            if (this.hcq == null || !this.hcq.bFS()) {
                if (this.hci.bFE()) {
                    VideoFileInfo bFC = this.hci.bFC();
                    if (this.hcq == null) {
                        this.hcq = new l(this, this.forumName, this.forumId, "");
                        if (this.hcj != null) {
                            this.hcj.a(this.hcq);
                        }
                    }
                    this.hcq.d(bFC);
                } else if (v.v(this.hci.bFG()) == 1 && !this.hcp) {
                    bFl();
                } else {
                    ae(null);
                }
            }
        }
    }

    private void ae(Intent intent) {
        Intent intent2 = new Intent();
        intent2.putExtra(AlbumActivityConfig.ALBUM_RESULT, this.hci.getWriteImagesInfo().toJsonString());
        intent2.putExtra(AlbumActivityConfig.CAMERA_REQUEST_FROM, this.hcm);
        intent2.putExtra(IntentConfig.KEY_FROM_IM, this.hcp);
        if (intent != null && !StringUtils.isNull(intent.getStringExtra("file_name"))) {
            intent2.putExtra("file_name", intent.getStringExtra("file_name"));
        }
        setResult(-1, intent2);
        finish();
    }

    public void c(TbPageContext tbPageContext) {
        if (com.baidu.tieba.write.f.bFc()) {
            sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new RecordVideoActivityConfig(tbPageContext.getPageActivity(), this.fGI ? 2 : 3, new ForumWriteData(this.forumId, this.forumName, null, null), this.hci.getWriteImagesInfo(), "")));
            TiebaStatic.log(new ak("c12611").r("obj_locate", 5).r("obj_type", 2));
        }
    }

    private void bFl() {
        WriteImagesInfo writeImagesInfo;
        if (this.hci != null && (writeImagesInfo = this.hci.getWriteImagesInfo()) != null) {
            sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new WriteMulitImageActivityConfig(getPageContext().getPageActivity(), 12012, writeImagesInfo, 0)));
        }
    }

    private void af(Intent intent) {
        if (intent == null || this.hci == null) {
            ae(null);
            return;
        }
        String stringExtra = intent.getStringExtra(AlbumActivityConfig.ALBUM_RESULT);
        if (stringExtra != null) {
            WriteImagesInfo writeImagesInfo = this.hci.getWriteImagesInfo();
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
        if (view == this.hcj.bFu()) {
            bFk();
        } else if (view == this.hcj.bFw()) {
            bFk();
        } else if (view == this.hcj.bFt()) {
            if (this.hci != null) {
                this.hci.setLastAlbumId(null);
            }
            bFq();
        } else if (view == this.hcj.bFv()) {
            vE(0);
        } else if (view == this.hcj.bFx()) {
            vC(2);
        } else if (view == this.hcj.bFy()) {
            vC(1);
        }
    }

    private void vC(int i) {
        if (this.hcj != null && this.hci != null) {
            this.hci.setOriginalImg(!this.hci.isOriginalImg());
            bFm();
            vD(i);
        }
    }

    private void vD(int i) {
        if (this.hci != null && this.hci.isOriginalImg() && !StringUtils.isNull(this.from, true) && !StringUtils.isNull(this.forumId, true)) {
            TiebaStatic.log(new ak("c10349").ac(ImageViewerConfig.FORUM_ID, this.forumId).ac("obj_type", this.from).r("obj_locate", i));
        }
    }

    public void bFm() {
        if (this.hci != null && this.hcj != null) {
            this.hcj.nW(this.hci.isOriginalImg());
        }
    }

    public View alB() {
        return this.cIM;
    }

    public int bFn() {
        return this.hcn;
    }

    public e bFo() {
        return this.hci;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void vE(int i) {
        if (!this.hck) {
            FragmentTransaction beginTransaction = getSupportFragmentManager().beginTransaction();
            Fragment findFragmentByTag = getSupportFragmentManager().findFragmentByTag(this.hcj.vG(this.mCurrentPage));
            if (findFragmentByTag != null) {
                beginTransaction.hide(findFragmentByTag);
            }
            this.mCurrentPage = i;
            if (getSupportFragmentManager().findFragmentByTag(this.hcj.vG(i)) != null) {
                beginTransaction.show(this.hcj.vF(i));
            } else {
                beginTransaction.add(d.g.fragment, this.hcj.vF(i), this.hcj.vG(i));
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
        int maxImagesAllowed = this.hci.getMaxImagesAllowed();
        if (this.hci.size() < maxImagesAllowed) {
            if (this.hcl == null || this.hcl.e(imageFileInfo)) {
                ImageFileInfo imageFileInfo2 = new ImageFileInfo();
                imageFileInfo2.setAlbumnId(imageFileInfo.getAlbumId());
                imageFileInfo2.setFilePath(imageFileInfo.getFilePath());
                imageFileInfo2.setModifyTime(imageFileInfo.getModifyTime());
                imageFileInfo2.setIsGif(imageFileInfo.isGif());
                imageFileInfo2.setIsLong(imageFileInfo.isLong());
                this.hci.a(null);
                this.hci.addChooseFile(imageFileInfo2);
                bFm();
                return true;
            }
            return false;
        } else if (bFp()) {
            return c(imageFileInfo);
        } else {
            showToast(String.format(getPageContext().getContext().getString(d.j.album_beyond_max_choose), Integer.valueOf(maxImagesAllowed)));
            return false;
        }
    }

    public boolean bFp() {
        if (getIntent().getBooleanExtra(AlbumActivityConfig.IS_SELECT_DIRECTLY, false)) {
            int maxImagesAllowed = this.hci.getMaxImagesAllowed();
            if (this.hci.size() == maxImagesAllowed && maxImagesAllowed == 1) {
                try {
                    ImageFileInfo imageFileInfo = (ImageFileInfo) v.c(this.hci.bFG(), 0);
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
        this.hci.a(null);
        this.hci.delChooseFile(imageFileInfo);
        bFm();
        return true;
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity, android.support.v4.app.FragmentActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i == 4) {
            closeLoadingDialog();
            if (this.mCurrentPage == 0) {
                if (this.hci != null) {
                    this.hci.setLastAlbumId(null);
                }
                bFq();
                return true;
            } else if (this.mCurrentPage == 1) {
                vE(0);
                return true;
            } else {
                return true;
            }
        }
        return super.onKeyDown(i, keyEvent);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void f(ImageFileInfo imageFileInfo, boolean z) {
        Fragment vF;
        if (this.hcj != null && (vF = this.hcj.vF(0)) != null && (vF instanceof k)) {
            ((k) vF).h(imageFileInfo, z);
        }
    }

    void g(ImageFileInfo imageFileInfo, boolean z) {
        Fragment vF;
        if (this.hcj != null && (vF = this.hcj.vF(1)) != null && (vF instanceof b)) {
            ((b) vF).h(imageFileInfo, z);
        }
    }

    private void bFq() {
        Intent intent = new Intent();
        String lastAlbumId = this.hci.getLastAlbumId();
        if (TextUtils.isEmpty(lastAlbumId)) {
            lastAlbumId = "";
        }
        intent.putExtra(AlbumActivityConfig.LAST_ALBUM_ID, lastAlbumId);
        intent.putExtra(AlbumActivityConfig.CAMERA_REQUEST_FROM, this.hcm);
        setResult(0, intent);
        finish();
    }

    private void stopCamera() {
        if (this.hcj != null) {
            this.hcj.stopCamera();
        }
    }

    private void bFr() {
        if (this.hcj != null) {
            this.hcj.bFr();
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
        this.hck = true;
        stopCamera();
        closeLoadingDialog();
        dismissAllDialog();
        f.bFK().destory();
        if (this.cIM != null) {
            this.cIM.setBackgroundDrawable(null);
        }
        if (this.hcj != null) {
            this.hcj.onDestroy();
        }
        if (this.hcq != null) {
            this.hcq.onDestroy();
        }
    }

    @Override // android.app.Activity, com.baidu.b.a.a.InterfaceC0022a
    public void onRequestPermissionsResult(int i, String[] strArr, int[] iArr) {
        if (i == 1) {
            if (ab.aL(getApplicationContext())) {
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
            new com.baidu.tbadk.img.f(null).c(AlbumActivity.this.hci.getWriteImagesInfo(), true);
            return AlbumActivity.this.hci.getWriteImagesInfo().toJsonString();
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
        if (this.hcq != null) {
            this.hcq.onStart();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.adp.base.BdBaseFragmentActivity, android.support.v4.app.FragmentActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        bFr();
        if (this.hcq != null) {
            this.hcq.onResume();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.base.BdBaseFragmentActivity, android.support.v4.app.FragmentActivity, android.app.Activity
    public void onStop() {
        super.onStop();
        if (this.hcq != null) {
            this.hcq.onStop();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.adp.base.BdBaseFragmentActivity, android.support.v4.app.FragmentActivity, android.app.Activity
    public void onPause() {
        stopCamera();
        super.onPause();
    }
}
