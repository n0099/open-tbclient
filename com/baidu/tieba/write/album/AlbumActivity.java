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
import com.baidu.d.a.a;
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
import com.baidu.tbadk.core.util.ab;
import com.baidu.tbadk.core.util.aj;
import com.baidu.tbadk.core.util.ak;
import com.baidu.tbadk.core.util.v;
import com.baidu.tbadk.img.ImageFileInfo;
import com.baidu.tbadk.img.WriteImagesInfo;
import com.baidu.tieba.d;
import com.baidu.tieba.frs.ForumWriteData;
/* loaded from: classes2.dex */
public class AlbumActivity extends BaseFragmentActivity implements View.OnClickListener, a.InterfaceC0056a {
    private boolean dHp;
    private com.baidu.tieba.d.c fTh;
    private e hEk;
    private com.baidu.tieba.write.album.a hEl;
    private g hEn;
    private l hEt;
    private int mCurrentPage = 0;
    private boolean hEm = false;
    private String callFrom = "";
    private String from = "";
    private String forumName = "";
    private String forumId = "0";
    private int hEo = 0;
    private int hEp = 0;
    private boolean hEq = false;
    private boolean hEr = false;
    private int hEs = 0;
    private View dGe = null;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.adp.base.BdBaseFragmentActivity, android.support.v4.app.FragmentActivity, android.support.v4.app.BaseFragmentActivityGingerbread, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setSwipeBackEnabled(false);
        setContentView(d.h.album_activity);
        this.dGe = findViewById(d.g.statebar_view);
        this.dHp = UtilHelper.canUseStyleImmersiveSticky();
        XC();
        initData(bundle);
        this.hEl = new com.baidu.tieba.write.album.a(this);
        this.hEl.aYT();
        xk(0);
    }

    public void showTip(View view) {
        if (this.fTh == null && view != null) {
            this.fTh = new com.baidu.tieba.d.c(getPageContext(), view);
            this.fTh.lS(d.f.bg_tip_blue_up_left);
            this.fTh.j(new View.OnClickListener() { // from class: com.baidu.tieba.write.album.AlbumActivity.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    AlbumActivity.this.fTh.ang();
                }
            });
            this.fTh.lR(16);
            this.fTh.lT(5000);
        }
        if (this.fTh != null) {
            String sharedPrefKeyWithAccount = com.baidu.tbadk.core.sharedPref.b.getSharedPrefKeyWithAccount("key_show_take_photo_tip");
            this.fTh.aK(getString(d.j.album_take_photo_tip), sharedPrefKeyWithAccount);
        }
    }

    private void XC() {
        if (this.dGe != null) {
            if (this.dHp && this.dGe.getLayoutParams() != null) {
                ViewGroup.LayoutParams layoutParams = this.dGe.getLayoutParams();
                layoutParams.height = UtilHelper.getStatusBarHeight();
                this.dGe.setLayoutParams(layoutParams);
                fY(true);
                return;
            }
            fY(false);
        }
    }

    private void fY(boolean z) {
        if (this.dGe != null) {
            if (this.dHp && z && this.dGe.getVisibility() != 0) {
                this.dGe.setVisibility(0);
            } else if (!z && this.dGe.getVisibility() != 8) {
                this.dGe.setVisibility(8);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.support.v4.app.FragmentActivity, android.app.Activity
    public void onSaveInstanceState(Bundle bundle) {
        bundle.putString(AlbumActivityConfig.WRITE_IMAGES_INFO, this.hEk.getWriteImagesInfo().toJsonString());
        bundle.putBoolean(AlbumActivityConfig.USE_ORIGINAL_IMG, this.hEq);
        bundle.putInt(AlbumActivityConfig.CAMERA_REQUEST_FROM, this.hEo);
        bundle.putString("forum_id", this.forumId);
        bundle.putString("forum_name", this.forumName);
        bundle.putInt(IntentConfig.KEY_ALBUM_THREAD, this.hEp);
        bundle.putBoolean("from_write", this.hEr);
    }

    private void initData(Bundle bundle) {
        this.hEk = new e(this);
        if (bundle != null) {
            WriteImagesInfo writeImagesInfo = new WriteImagesInfo();
            writeImagesInfo.parseJson(bundle.getString(AlbumActivityConfig.WRITE_IMAGES_INFO));
            this.hEk.setWriteImagesInfo(writeImagesInfo);
            this.hEq = bundle.getBoolean(AlbumActivityConfig.USE_ORIGINAL_IMG, false);
            this.hEo = bundle.getInt(AlbumActivityConfig.CAMERA_REQUEST_FROM, 0);
            this.forumId = bundle.getString("forum_id");
            this.forumName = bundle.getString("forum_name");
            this.hEp = bundle.getInt(IntentConfig.KEY_ALBUM_THREAD);
            this.hEr = bundle.getBoolean("from_write");
            this.callFrom = bundle.getString("KEY_CALL_FROM");
            this.hEs = bundle.getInt("from_type");
        } else {
            Intent intent = getIntent();
            if (intent != null) {
                WriteImagesInfo writeImagesInfo2 = new WriteImagesInfo();
                writeImagesInfo2.parseJson(intent.getStringExtra(AlbumActivityConfig.WRITE_IMAGES_INFO));
                this.hEk.setWriteImagesInfo(writeImagesInfo2);
                this.hEk.setOriginalImg(writeImagesInfo2.isOriginalImg());
                this.hEq = intent.getBooleanExtra(AlbumActivityConfig.USE_ORIGINAL_IMG, false);
                this.hEo = intent.getIntExtra(AlbumActivityConfig.CAMERA_REQUEST_FROM, 0);
                this.from = intent.getStringExtra("from");
                this.forumId = intent.getStringExtra("forum_id");
                this.forumName = intent.getStringExtra("forum_name");
                this.hEp = intent.getIntExtra(IntentConfig.KEY_ALBUM_THREAD, 0);
                this.hEr = intent.getBooleanExtra("from_write", false);
                this.callFrom = intent.getStringExtra("KEY_CALL_FROM");
                this.hEs = intent.getIntExtra("from_type", 0);
            }
        }
        bFS();
    }

    private void bFS() {
        if (this.hEo == 2) {
            this.hEn = new g() { // from class: com.baidu.tieba.write.album.AlbumActivity.2
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
        if (this.hEl != null) {
            this.hEl.onChangeSkinType(i);
        }
        aj.g(this.dGe, d.C0141d.cp_bg_line_d, i);
    }

    public void bFT() {
        if (this.hEo == 3) {
            TiebaStatic.log("c10489");
        }
        if (this.hEo == 5) {
            showLoadingDialog("正在上传");
            new a().execute(new String[0]);
        } else if (this.hEk != null) {
            if (this.hEt == null || !this.hEt.bGG()) {
                if (this.hEk.bGn()) {
                    VideoFileInfo bGl = this.hEk.bGl();
                    if (this.hEt == null) {
                        this.hEt = new l(this, this.forumName, this.forumId, "");
                        if (this.hEl != null) {
                            this.hEl.a(this.hEt);
                        }
                    }
                    this.hEt.a(bGl, this.callFrom);
                } else if (v.D(this.hEk.bGp()) == 1 && this.hEs == 0) {
                    bFU();
                } else {
                    ac(null);
                }
            }
        }
    }

    private void ac(Intent intent) {
        Intent intent2 = new Intent();
        intent2.putExtra(AlbumActivityConfig.ALBUM_RESULT, this.hEk.getWriteImagesInfo().toJsonString());
        intent2.putExtra(AlbumActivityConfig.CAMERA_REQUEST_FROM, this.hEo);
        intent2.putExtra("from_type", this.hEs);
        if (intent != null && !StringUtils.isNull(intent.getStringExtra("file_name"))) {
            intent2.putExtra("file_name", intent.getStringExtra("file_name"));
        }
        setResult(-1, intent2);
        finish();
    }

    private boolean adg() {
        Activity pageActivity = getPageContext().getPageActivity();
        com.baidu.tbadk.core.util.b.a aVar = new com.baidu.tbadk.core.util.b.a();
        aVar.DH();
        aVar.c(pageActivity, "android.permission.CAMERA");
        aVar.c(pageActivity, "android.permission.RECORD_AUDIO");
        aVar.c(pageActivity, "android.permission.WRITE_EXTERNAL_STORAGE");
        return aVar.v(pageActivity);
    }

    public void b(TbPageContext tbPageContext) {
        if (!adg() && com.baidu.tieba.write.f.bFL()) {
            sendMessage(new CustomMessage(2002001, new RecordVideoActivityConfig(tbPageContext.getPageActivity(), this.hEr ? 2 : 3, new ForumWriteData(this.forumId, this.forumName, null, null), this.hEk.getWriteImagesInfo(), "", this.hEs)));
            TiebaStatic.log(new ak("c12611").s("obj_locate", 5).s("obj_type", 2));
        }
    }

    private void bFU() {
        WriteImagesInfo writeImagesInfo;
        if (this.hEk != null && (writeImagesInfo = this.hEk.getWriteImagesInfo()) != null) {
            sendMessage(new CustomMessage(2002001, new WriteMulitImageActivityConfig(getPageContext().getPageActivity(), IEventCenterService.EventId.EventMode.SAPIACCOUNT_THROUGH_SERVER, writeImagesInfo, 0)));
        }
    }

    private void ad(Intent intent) {
        if (intent == null || this.hEk == null) {
            ac(null);
            return;
        }
        String stringExtra = intent.getStringExtra(AlbumActivityConfig.ALBUM_RESULT);
        if (stringExtra != null) {
            WriteImagesInfo writeImagesInfo = this.hEk.getWriteImagesInfo();
            writeImagesInfo.parseJson(stringExtra);
            writeImagesInfo.updateQuality();
            ac(intent);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragmentActivity, android.support.v4.app.FragmentActivity, android.app.Activity
    public void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (i2 == -1) {
            ad(intent);
        }
    }

    @Override // com.baidu.adp.base.BdBaseFragmentActivity, android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.hEl.bGd()) {
            bFT();
        } else if (view == this.hEl.bGf()) {
            bFT();
        } else if (view == this.hEl.bGc()) {
            if (this.hEk != null) {
                this.hEk.setLastAlbumId(null);
            }
            bFZ();
        } else if (view == this.hEl.bGe()) {
            xk(0);
        } else if (view == this.hEl.bGg()) {
            xi(2);
        } else if (view == this.hEl.bGh()) {
            xi(1);
        }
    }

    private void xi(int i) {
        if (this.hEl != null && this.hEk != null) {
            this.hEk.setOriginalImg(!this.hEk.isOriginalImg());
            bFV();
            xj(i);
        }
    }

    private void xj(int i) {
        if (this.hEk != null && this.hEk.isOriginalImg() && !StringUtils.isNull(this.from, true) && !StringUtils.isNull(this.forumId, true)) {
            TiebaStatic.log(new ak("c10349").ab(ImageViewerConfig.FORUM_ID, this.forumId).ab("obj_type", this.from).s("obj_locate", i));
        }
    }

    public void bFV() {
        if (this.hEk != null && this.hEl != null) {
            this.hEl.nE(this.hEk.isOriginalImg());
        }
    }

    public View avr() {
        return this.dGe;
    }

    public int bFW() {
        return this.hEp;
    }

    public e bFX() {
        return this.hEk;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void xk(int i) {
        if (!this.hEm) {
            FragmentTransaction beginTransaction = getSupportFragmentManager().beginTransaction();
            Fragment findFragmentByTag = getSupportFragmentManager().findFragmentByTag(this.hEl.xm(this.mCurrentPage));
            if (findFragmentByTag != null) {
                beginTransaction.hide(findFragmentByTag);
            }
            this.mCurrentPage = i;
            if (getSupportFragmentManager().findFragmentByTag(this.hEl.xm(i)) != null) {
                beginTransaction.show(this.hEl.xl(i));
            } else {
                beginTransaction.add(d.g.fragment, this.hEl.xl(i), this.hEl.xm(i));
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
        int maxImagesAllowed = this.hEk.getMaxImagesAllowed();
        if (this.hEk.size() < maxImagesAllowed) {
            if (this.hEn == null || this.hEn.e(imageFileInfo)) {
                ImageFileInfo imageFileInfo2 = new ImageFileInfo();
                imageFileInfo2.setAlbumnId(imageFileInfo.getAlbumId());
                imageFileInfo2.setFilePath(imageFileInfo.getFilePath());
                imageFileInfo2.setModifyTime(imageFileInfo.getModifyTime());
                imageFileInfo2.setIsGif(imageFileInfo.isGif());
                imageFileInfo2.setIsLong(imageFileInfo.isLong());
                this.hEk.a(null);
                this.hEk.addChooseFile(imageFileInfo2);
                bFV();
                return true;
            }
            return false;
        } else if (bFY()) {
            return c(imageFileInfo);
        } else {
            showToast(String.format(getPageContext().getContext().getString(d.j.album_beyond_max_choose), Integer.valueOf(maxImagesAllowed)));
            return false;
        }
    }

    public boolean bFY() {
        if (getIntent().getBooleanExtra(AlbumActivityConfig.IS_SELECT_DIRECTLY, false)) {
            int maxImagesAllowed = this.hEk.getMaxImagesAllowed();
            if (this.hEk.size() == maxImagesAllowed && maxImagesAllowed == 1) {
                try {
                    ImageFileInfo imageFileInfo = (ImageFileInfo) v.f(this.hEk.bGp(), 0);
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
        this.hEk.a(null);
        this.hEk.delChooseFile(imageFileInfo);
        bFV();
        return true;
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i == 4) {
            closeLoadingDialog();
            if (this.mCurrentPage == 0) {
                if (this.hEk != null) {
                    this.hEk.setLastAlbumId(null);
                }
                bFZ();
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
        if (this.hEl != null && (xl = this.hEl.xl(0)) != null && (xl instanceof k)) {
            ((k) xl).h(imageFileInfo, z);
        }
    }

    void g(ImageFileInfo imageFileInfo, boolean z) {
        Fragment xl;
        if (this.hEl != null && (xl = this.hEl.xl(1)) != null && (xl instanceof b)) {
            ((b) xl).h(imageFileInfo, z);
        }
    }

    private void bFZ() {
        Intent intent = new Intent();
        String lastAlbumId = this.hEk.getLastAlbumId();
        if (TextUtils.isEmpty(lastAlbumId)) {
            lastAlbumId = "";
        }
        intent.putExtra(AlbumActivityConfig.LAST_ALBUM_ID, lastAlbumId);
        intent.putExtra(AlbumActivityConfig.CAMERA_REQUEST_FROM, this.hEo);
        setResult(0, intent);
        finish();
    }

    private void stopCamera() {
        if (this.hEl != null) {
            this.hEl.stopCamera();
        }
    }

    private void bGa() {
        if (this.hEl != null) {
            this.hEl.bGa();
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
        this.hEm = true;
        stopCamera();
        closeLoadingDialog();
        dismissAllDialog();
        f.bGt().destory();
        if (this.dGe != null) {
            this.dGe.setBackgroundDrawable(null);
        }
        if (this.hEl != null) {
            this.hEl.onDestroy();
        }
        if (this.hEt != null) {
            this.hEt.onDestroy();
        }
    }

    @Override // android.support.v4.app.FragmentActivity, android.app.Activity, android.support.v4.app.ActivityCompat.OnRequestPermissionsResultCallback
    public void onRequestPermissionsResult(int i, String[] strArr, int[] iArr) {
        if (i == 1) {
            if (!ab.aT(getApplicationContext())) {
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
            new com.baidu.tbadk.img.f(null).c(AlbumActivity.this.hEk.getWriteImagesInfo(), true);
            return AlbumActivity.this.hEk.getWriteImagesInfo().toJsonString();
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
        if (this.hEt != null) {
            this.hEt.onStart();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.adp.base.BdBaseFragmentActivity, android.support.v4.app.FragmentActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        bGa();
        if (this.hEt != null) {
            this.hEt.onResume();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.base.BdBaseFragmentActivity, android.support.v4.app.FragmentActivity, android.app.Activity
    public void onStop() {
        super.onStop();
        if (this.hEt != null) {
            this.hEt.onStop();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.adp.base.BdBaseFragmentActivity, android.support.v4.app.FragmentActivity, android.app.Activity
    public void onPause() {
        stopCamera();
        super.onPause();
    }
}
