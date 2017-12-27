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
public class AlbumActivity extends BaseFragmentActivity implements View.OnClickListener, a.InterfaceC0036a {
    private boolean dzB;
    private com.baidu.tieba.d.b fOl;
    private e hMZ;
    private com.baidu.tieba.write.album.a hNa;
    private g hNc;
    private l hNh;
    private int mCurrentPage = 0;
    private boolean hNb = false;
    private String callFrom = "";
    private String from = "";
    private String forumName = "";
    private String forumId = "0";
    private int hNd = 0;
    private int hNe = 0;
    private boolean hNf = false;
    private boolean guE = false;
    private int hNg = 0;
    private View dyx = null;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.adp.base.BdBaseFragmentActivity, android.support.v4.app.FragmentActivity, android.support.v4.app.BaseFragmentActivityGingerbread, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setSwipeBackEnabled(false);
        setContentView(d.h.album_activity);
        this.dyx = findViewById(d.g.statebar_view);
        this.dzB = UtilHelper.canUseStyleImmersiveSticky();
        aup();
        initData(bundle);
        this.hNa = new com.baidu.tieba.write.album.a(this);
        this.hNa.aXb();
        yH(0);
    }

    public void showTip(View view) {
        if (this.fOl == null && view != null) {
            this.fOl = new com.baidu.tieba.d.b(getPageContext(), view);
            this.fOl.lS(d.f.bg_tip_blue_up_left);
            this.fOl.j(new View.OnClickListener() { // from class: com.baidu.tieba.write.album.AlbumActivity.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    AlbumActivity.this.fOl.alo();
                }
            });
            this.fOl.lR(16);
            this.fOl.lT(5000);
        }
        if (this.fOl != null) {
            String sharedPrefKeyWithAccount = com.baidu.tbadk.core.sharedPref.b.getSharedPrefKeyWithAccount("key_show_take_photo_tip");
            this.fOl.aK(getString(d.j.album_take_photo_tip), sharedPrefKeyWithAccount);
        }
    }

    private void aup() {
        if (this.dyx != null) {
            if (this.dzB && this.dyx.getLayoutParams() != null) {
                ViewGroup.LayoutParams layoutParams = this.dyx.getLayoutParams();
                layoutParams.height = UtilHelper.getStatusBarHeight();
                this.dyx.setLayoutParams(layoutParams);
                fK(true);
                return;
            }
            fK(false);
        }
    }

    private void fK(boolean z) {
        if (this.dyx != null) {
            if (this.dzB && z && this.dyx.getVisibility() != 0) {
                this.dyx.setVisibility(0);
            } else if (!z && this.dyx.getVisibility() != 8) {
                this.dyx.setVisibility(8);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.support.v4.app.FragmentActivity, android.app.Activity
    public void onSaveInstanceState(Bundle bundle) {
        bundle.putString(AlbumActivityConfig.WRITE_IMAGES_INFO, this.hMZ.getWriteImagesInfo().toJsonString());
        bundle.putBoolean(AlbumActivityConfig.USE_ORIGINAL_IMG, this.hNf);
        bundle.putInt(AlbumActivityConfig.CAMERA_REQUEST_FROM, this.hNd);
        bundle.putString("forum_id", this.forumId);
        bundle.putString("forum_name", this.forumName);
        bundle.putInt(IntentConfig.KEY_ALBUM_THREAD, this.hNe);
        bundle.putBoolean("from_write", this.guE);
    }

    private void initData(Bundle bundle) {
        this.hMZ = new e(this);
        if (bundle != null) {
            WriteImagesInfo writeImagesInfo = new WriteImagesInfo();
            writeImagesInfo.parseJson(bundle.getString(AlbumActivityConfig.WRITE_IMAGES_INFO));
            this.hMZ.setWriteImagesInfo(writeImagesInfo);
            this.hNf = bundle.getBoolean(AlbumActivityConfig.USE_ORIGINAL_IMG, false);
            this.hNd = bundle.getInt(AlbumActivityConfig.CAMERA_REQUEST_FROM, 0);
            this.forumId = bundle.getString("forum_id");
            this.forumName = bundle.getString("forum_name");
            this.hNe = bundle.getInt(IntentConfig.KEY_ALBUM_THREAD);
            this.guE = bundle.getBoolean("from_write");
            this.callFrom = bundle.getString("KEY_CALL_FROM");
            this.hNg = bundle.getInt("from_type");
        } else {
            Intent intent = getIntent();
            if (intent != null) {
                WriteImagesInfo writeImagesInfo2 = new WriteImagesInfo();
                writeImagesInfo2.parseJson(intent.getStringExtra(AlbumActivityConfig.WRITE_IMAGES_INFO));
                this.hMZ.setWriteImagesInfo(writeImagesInfo2);
                this.hMZ.setOriginalImg(writeImagesInfo2.isOriginalImg());
                this.hNf = intent.getBooleanExtra(AlbumActivityConfig.USE_ORIGINAL_IMG, false);
                this.hNd = intent.getIntExtra(AlbumActivityConfig.CAMERA_REQUEST_FROM, 0);
                this.from = intent.getStringExtra("from");
                this.forumId = intent.getStringExtra("forum_id");
                this.forumName = intent.getStringExtra("forum_name");
                this.hNe = intent.getIntExtra(IntentConfig.KEY_ALBUM_THREAD, 0);
                this.guE = intent.getBooleanExtra("from_write", false);
                this.callFrom = intent.getStringExtra("KEY_CALL_FROM");
                this.hNg = intent.getIntExtra("from_type", 0);
            }
        }
        bLD();
    }

    private void bLD() {
        if (this.hNd == 2) {
            this.hNc = new g() { // from class: com.baidu.tieba.write.album.AlbumActivity.2
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
        if (this.hNa != null) {
            this.hNa.onChangeSkinType(i);
        }
        aj.g(this.dyx, d.C0108d.cp_bg_line_d, i);
    }

    public void bLE() {
        if (this.hNd == 3) {
            TiebaStatic.log("c10489");
        }
        if (this.hNd == 5) {
            showLoadingDialog("正在上传");
            new a().execute(new String[0]);
        } else if (this.hMZ != null) {
            if (this.hNh == null || !this.hNh.bMr()) {
                if (this.hMZ.bLY()) {
                    VideoFileInfo bLW = this.hMZ.bLW();
                    if (this.hNh == null) {
                        this.hNh = new l(this, this.forumName, this.forumId, "");
                        if (this.hNa != null) {
                            this.hNa.a(this.hNh);
                        }
                    }
                    this.hNh.a(bLW, this.callFrom);
                } else if (v.F(this.hMZ.bMa()) == 1 && this.hNg == 0) {
                    bLF();
                } else {
                    af(null);
                }
            }
        }
    }

    private void af(Intent intent) {
        Intent intent2 = new Intent();
        intent2.putExtra(AlbumActivityConfig.ALBUM_RESULT, this.hMZ.getWriteImagesInfo().toJsonString());
        intent2.putExtra(AlbumActivityConfig.CAMERA_REQUEST_FROM, this.hNd);
        intent2.putExtra("from_type", this.hNg);
        if (intent != null && !StringUtils.isNull(intent.getStringExtra("file_name"))) {
            intent2.putExtra("file_name", intent.getStringExtra("file_name"));
        }
        setResult(-1, intent2);
        finish();
    }

    public void c(TbPageContext tbPageContext) {
        if (com.baidu.tieba.write.f.bLw()) {
            sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new RecordVideoActivityConfig(tbPageContext.getPageActivity(), this.guE ? 2 : 3, new ForumWriteData(this.forumId, this.forumName, null, null), this.hMZ.getWriteImagesInfo(), "", this.hNg)));
            TiebaStatic.log(new ak("c12611").s("obj_locate", 5).s("obj_type", 2));
        }
    }

    private void bLF() {
        WriteImagesInfo writeImagesInfo;
        if (this.hMZ != null && (writeImagesInfo = this.hMZ.getWriteImagesInfo()) != null) {
            sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new WriteMulitImageActivityConfig(getPageContext().getPageActivity(), IEventCenterService.EventId.EventMode.SAPIACCOUNT_THROUGH_SERVER, writeImagesInfo, 0)));
        }
    }

    private void ag(Intent intent) {
        if (intent == null || this.hMZ == null) {
            af(null);
            return;
        }
        String stringExtra = intent.getStringExtra(AlbumActivityConfig.ALBUM_RESULT);
        if (stringExtra != null) {
            WriteImagesInfo writeImagesInfo = this.hMZ.getWriteImagesInfo();
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
        if (view == this.hNa.bLO()) {
            bLE();
        } else if (view == this.hNa.bLQ()) {
            bLE();
        } else if (view == this.hNa.bLN()) {
            if (this.hMZ != null) {
                this.hMZ.setLastAlbumId(null);
            }
            bLK();
        } else if (view == this.hNa.bLP()) {
            yH(0);
        } else if (view == this.hNa.bLR()) {
            yF(2);
        } else if (view == this.hNa.bLS()) {
            yF(1);
        }
    }

    private void yF(int i) {
        if (this.hNa != null && this.hMZ != null) {
            this.hMZ.setOriginalImg(!this.hMZ.isOriginalImg());
            bLG();
            yG(i);
        }
    }

    private void yG(int i) {
        if (this.hMZ != null && this.hMZ.isOriginalImg() && !StringUtils.isNull(this.from, true) && !StringUtils.isNull(this.forumId, true)) {
            TiebaStatic.log(new ak("c10349").ab(ImageViewerConfig.FORUM_ID, this.forumId).ab("obj_type", this.from).s("obj_locate", i));
        }
    }

    public void bLG() {
        if (this.hMZ != null && this.hNa != null) {
            this.hNa.or(this.hMZ.isOriginalImg());
        }
    }

    public View atu() {
        return this.dyx;
    }

    public int bLH() {
        return this.hNe;
    }

    public e bLI() {
        return this.hMZ;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void yH(int i) {
        if (!this.hNb) {
            FragmentTransaction beginTransaction = getSupportFragmentManager().beginTransaction();
            Fragment findFragmentByTag = getSupportFragmentManager().findFragmentByTag(this.hNa.yJ(this.mCurrentPage));
            if (findFragmentByTag != null) {
                beginTransaction.hide(findFragmentByTag);
            }
            this.mCurrentPage = i;
            if (getSupportFragmentManager().findFragmentByTag(this.hNa.yJ(i)) != null) {
                beginTransaction.show(this.hNa.yI(i));
            } else {
                beginTransaction.add(d.g.fragment, this.hNa.yI(i), this.hNa.yJ(i));
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
        int maxImagesAllowed = this.hMZ.getMaxImagesAllowed();
        if (this.hMZ.size() < maxImagesAllowed) {
            if (this.hNc == null || this.hNc.e(imageFileInfo)) {
                ImageFileInfo imageFileInfo2 = new ImageFileInfo();
                imageFileInfo2.setAlbumnId(imageFileInfo.getAlbumId());
                imageFileInfo2.setFilePath(imageFileInfo.getFilePath());
                imageFileInfo2.setModifyTime(imageFileInfo.getModifyTime());
                imageFileInfo2.setIsGif(imageFileInfo.isGif());
                imageFileInfo2.setIsLong(imageFileInfo.isLong());
                this.hMZ.a(null);
                this.hMZ.addChooseFile(imageFileInfo2);
                bLG();
                return true;
            }
            return false;
        } else if (bLJ()) {
            return c(imageFileInfo);
        } else {
            showToast(String.format(getPageContext().getContext().getString(d.j.album_beyond_max_choose), Integer.valueOf(maxImagesAllowed)));
            return false;
        }
    }

    public boolean bLJ() {
        if (getIntent().getBooleanExtra(AlbumActivityConfig.IS_SELECT_DIRECTLY, false)) {
            int maxImagesAllowed = this.hMZ.getMaxImagesAllowed();
            if (this.hMZ.size() == maxImagesAllowed && maxImagesAllowed == 1) {
                try {
                    ImageFileInfo imageFileInfo = (ImageFileInfo) v.f(this.hMZ.bMa(), 0);
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
        this.hMZ.a(null);
        this.hMZ.delChooseFile(imageFileInfo);
        bLG();
        return true;
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i == 4) {
            closeLoadingDialog();
            if (this.mCurrentPage == 0) {
                if (this.hMZ != null) {
                    this.hMZ.setLastAlbumId(null);
                }
                bLK();
                return true;
            } else if (this.mCurrentPage == 1) {
                yH(0);
                return true;
            } else {
                return true;
            }
        }
        return super.onKeyDown(i, keyEvent);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void f(ImageFileInfo imageFileInfo, boolean z) {
        Fragment yI;
        if (this.hNa != null && (yI = this.hNa.yI(0)) != null && (yI instanceof k)) {
            ((k) yI).h(imageFileInfo, z);
        }
    }

    void g(ImageFileInfo imageFileInfo, boolean z) {
        Fragment yI;
        if (this.hNa != null && (yI = this.hNa.yI(1)) != null && (yI instanceof b)) {
            ((b) yI).h(imageFileInfo, z);
        }
    }

    private void bLK() {
        Intent intent = new Intent();
        String lastAlbumId = this.hMZ.getLastAlbumId();
        if (TextUtils.isEmpty(lastAlbumId)) {
            lastAlbumId = "";
        }
        intent.putExtra(AlbumActivityConfig.LAST_ALBUM_ID, lastAlbumId);
        intent.putExtra(AlbumActivityConfig.CAMERA_REQUEST_FROM, this.hNd);
        setResult(0, intent);
        finish();
    }

    private void stopCamera() {
        if (this.hNa != null) {
            this.hNa.stopCamera();
        }
    }

    private void bLL() {
        if (this.hNa != null) {
            this.hNa.bLL();
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
        this.hNb = true;
        stopCamera();
        closeLoadingDialog();
        dismissAllDialog();
        f.bMe().destory();
        if (this.dyx != null) {
            this.dyx.setBackgroundDrawable(null);
        }
        if (this.hNa != null) {
            this.hNa.onDestroy();
        }
        if (this.hNh != null) {
            this.hNh.onDestroy();
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
            new com.baidu.tbadk.img.f(null).c(AlbumActivity.this.hMZ.getWriteImagesInfo(), true);
            return AlbumActivity.this.hMZ.getWriteImagesInfo().toJsonString();
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
        if (this.hNh != null) {
            this.hNh.onStart();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.adp.base.BdBaseFragmentActivity, android.support.v4.app.FragmentActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        bLL();
        if (this.hNh != null) {
            this.hNh.onResume();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.base.BdBaseFragmentActivity, android.support.v4.app.FragmentActivity, android.app.Activity
    public void onStop() {
        super.onStop();
        if (this.hNh != null) {
            this.hNh.onStop();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.adp.base.BdBaseFragmentActivity, android.support.v4.app.FragmentActivity, android.app.Activity
    public void onPause() {
        stopCamera();
        super.onPause();
    }
}
