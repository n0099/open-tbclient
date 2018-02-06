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
    private boolean dHB;
    private com.baidu.tieba.d.c fTs;
    private g hEA;
    private l hEG;
    private e hEx;
    private com.baidu.tieba.write.album.a hEy;
    private int mCurrentPage = 0;
    private boolean hEz = false;
    private String callFrom = "";
    private String from = "";
    private String forumName = "";
    private String forumId = "0";
    private int hEB = 0;
    private int hEC = 0;
    private boolean hED = false;
    private boolean hEE = false;
    private int hEF = 0;
    private View dGq = null;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.adp.base.BdBaseFragmentActivity, android.support.v4.app.FragmentActivity, android.support.v4.app.BaseFragmentActivityGingerbread, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setSwipeBackEnabled(false);
        setContentView(d.h.album_activity);
        this.dGq = findViewById(d.g.statebar_view);
        this.dHB = UtilHelper.canUseStyleImmersiveSticky();
        XD();
        initData(bundle);
        this.hEy = new com.baidu.tieba.write.album.a(this);
        this.hEy.aYU();
        xj(0);
    }

    public void showTip(View view) {
        if (this.fTs == null && view != null) {
            this.fTs = new com.baidu.tieba.d.c(getPageContext(), view);
            this.fTs.lS(d.f.bg_tip_blue_up_left);
            this.fTs.j(new View.OnClickListener() { // from class: com.baidu.tieba.write.album.AlbumActivity.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    AlbumActivity.this.fTs.anh();
                }
            });
            this.fTs.lR(16);
            this.fTs.lT(5000);
        }
        if (this.fTs != null) {
            String sharedPrefKeyWithAccount = com.baidu.tbadk.core.sharedPref.b.getSharedPrefKeyWithAccount("key_show_take_photo_tip");
            this.fTs.aK(getString(d.j.album_take_photo_tip), sharedPrefKeyWithAccount);
        }
    }

    private void XD() {
        if (this.dGq != null) {
            if (this.dHB && this.dGq.getLayoutParams() != null) {
                ViewGroup.LayoutParams layoutParams = this.dGq.getLayoutParams();
                layoutParams.height = UtilHelper.getStatusBarHeight();
                this.dGq.setLayoutParams(layoutParams);
                fY(true);
                return;
            }
            fY(false);
        }
    }

    private void fY(boolean z) {
        if (this.dGq != null) {
            if (this.dHB && z && this.dGq.getVisibility() != 0) {
                this.dGq.setVisibility(0);
            } else if (!z && this.dGq.getVisibility() != 8) {
                this.dGq.setVisibility(8);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.support.v4.app.FragmentActivity, android.app.Activity
    public void onSaveInstanceState(Bundle bundle) {
        bundle.putString(AlbumActivityConfig.WRITE_IMAGES_INFO, this.hEx.getWriteImagesInfo().toJsonString());
        bundle.putBoolean(AlbumActivityConfig.USE_ORIGINAL_IMG, this.hED);
        bundle.putInt(AlbumActivityConfig.CAMERA_REQUEST_FROM, this.hEB);
        bundle.putString("forum_id", this.forumId);
        bundle.putString("forum_name", this.forumName);
        bundle.putInt(IntentConfig.KEY_ALBUM_THREAD, this.hEC);
        bundle.putBoolean("from_write", this.hEE);
    }

    private void initData(Bundle bundle) {
        this.hEx = new e(this);
        if (bundle != null) {
            WriteImagesInfo writeImagesInfo = new WriteImagesInfo();
            writeImagesInfo.parseJson(bundle.getString(AlbumActivityConfig.WRITE_IMAGES_INFO));
            this.hEx.setWriteImagesInfo(writeImagesInfo);
            this.hED = bundle.getBoolean(AlbumActivityConfig.USE_ORIGINAL_IMG, false);
            this.hEB = bundle.getInt(AlbumActivityConfig.CAMERA_REQUEST_FROM, 0);
            this.forumId = bundle.getString("forum_id");
            this.forumName = bundle.getString("forum_name");
            this.hEC = bundle.getInt(IntentConfig.KEY_ALBUM_THREAD);
            this.hEE = bundle.getBoolean("from_write");
            this.callFrom = bundle.getString("KEY_CALL_FROM");
            this.hEF = bundle.getInt("from_type");
        } else {
            Intent intent = getIntent();
            if (intent != null) {
                WriteImagesInfo writeImagesInfo2 = new WriteImagesInfo();
                writeImagesInfo2.parseJson(intent.getStringExtra(AlbumActivityConfig.WRITE_IMAGES_INFO));
                this.hEx.setWriteImagesInfo(writeImagesInfo2);
                this.hEx.setOriginalImg(writeImagesInfo2.isOriginalImg());
                this.hED = intent.getBooleanExtra(AlbumActivityConfig.USE_ORIGINAL_IMG, false);
                this.hEB = intent.getIntExtra(AlbumActivityConfig.CAMERA_REQUEST_FROM, 0);
                this.from = intent.getStringExtra("from");
                this.forumId = intent.getStringExtra("forum_id");
                this.forumName = intent.getStringExtra("forum_name");
                this.hEC = intent.getIntExtra(IntentConfig.KEY_ALBUM_THREAD, 0);
                this.hEE = intent.getBooleanExtra("from_write", false);
                this.callFrom = intent.getStringExtra("KEY_CALL_FROM");
                this.hEF = intent.getIntExtra("from_type", 0);
            }
        }
        bFT();
    }

    private void bFT() {
        if (this.hEB == 2) {
            this.hEA = new g() { // from class: com.baidu.tieba.write.album.AlbumActivity.2
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
        if (this.hEy != null) {
            this.hEy.onChangeSkinType(i);
        }
        aj.g(this.dGq, d.C0140d.cp_bg_line_d, i);
    }

    public void bFU() {
        if (this.hEB == 3) {
            TiebaStatic.log("c10489");
        }
        if (this.hEB == 5) {
            showLoadingDialog("正在上传");
            new a().execute(new String[0]);
        } else if (this.hEx != null) {
            if (this.hEG == null || !this.hEG.bGH()) {
                if (this.hEx.bGo()) {
                    VideoFileInfo bGm = this.hEx.bGm();
                    if (this.hEG == null) {
                        this.hEG = new l(this, this.forumName, this.forumId, "");
                        if (this.hEy != null) {
                            this.hEy.a(this.hEG);
                        }
                    }
                    this.hEG.a(bGm, this.callFrom);
                } else if (v.D(this.hEx.bGq()) == 1 && this.hEF == 0) {
                    bFV();
                } else {
                    ac(null);
                }
            }
        }
    }

    private void ac(Intent intent) {
        Intent intent2 = new Intent();
        intent2.putExtra(AlbumActivityConfig.ALBUM_RESULT, this.hEx.getWriteImagesInfo().toJsonString());
        intent2.putExtra(AlbumActivityConfig.CAMERA_REQUEST_FROM, this.hEB);
        intent2.putExtra("from_type", this.hEF);
        if (intent != null && !StringUtils.isNull(intent.getStringExtra("file_name"))) {
            intent2.putExtra("file_name", intent.getStringExtra("file_name"));
        }
        setResult(-1, intent2);
        finish();
    }

    private boolean adh() {
        Activity pageActivity = getPageContext().getPageActivity();
        com.baidu.tbadk.core.util.b.a aVar = new com.baidu.tbadk.core.util.b.a();
        aVar.DI();
        aVar.c(pageActivity, "android.permission.CAMERA");
        aVar.c(pageActivity, "android.permission.RECORD_AUDIO");
        aVar.c(pageActivity, "android.permission.WRITE_EXTERNAL_STORAGE");
        return aVar.v(pageActivity);
    }

    public void b(TbPageContext tbPageContext) {
        if (!adh() && com.baidu.tieba.write.f.bFM()) {
            sendMessage(new CustomMessage(2002001, new RecordVideoActivityConfig(tbPageContext.getPageActivity(), this.hEE ? 2 : 3, new ForumWriteData(this.forumId, this.forumName, null, null), this.hEx.getWriteImagesInfo(), "", this.hEF)));
            TiebaStatic.log(new ak("c12611").s("obj_locate", 5).s("obj_type", 2));
        }
    }

    private void bFV() {
        WriteImagesInfo writeImagesInfo;
        if (this.hEx != null && (writeImagesInfo = this.hEx.getWriteImagesInfo()) != null) {
            sendMessage(new CustomMessage(2002001, new WriteMulitImageActivityConfig(getPageContext().getPageActivity(), IEventCenterService.EventId.EventMode.SAPIACCOUNT_THROUGH_SERVER, writeImagesInfo, 0)));
        }
    }

    private void ad(Intent intent) {
        if (intent == null || this.hEx == null) {
            ac(null);
            return;
        }
        String stringExtra = intent.getStringExtra(AlbumActivityConfig.ALBUM_RESULT);
        if (stringExtra != null) {
            WriteImagesInfo writeImagesInfo = this.hEx.getWriteImagesInfo();
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
        if (view == this.hEy.bGe()) {
            bFU();
        } else if (view == this.hEy.bGg()) {
            bFU();
        } else if (view == this.hEy.bGd()) {
            if (this.hEx != null) {
                this.hEx.setLastAlbumId(null);
            }
            bGa();
        } else if (view == this.hEy.bGf()) {
            xj(0);
        } else if (view == this.hEy.bGh()) {
            xh(2);
        } else if (view == this.hEy.bGi()) {
            xh(1);
        }
    }

    private void xh(int i) {
        if (this.hEy != null && this.hEx != null) {
            this.hEx.setOriginalImg(!this.hEx.isOriginalImg());
            bFW();
            xi(i);
        }
    }

    private void xi(int i) {
        if (this.hEx != null && this.hEx.isOriginalImg() && !StringUtils.isNull(this.from, true) && !StringUtils.isNull(this.forumId, true)) {
            TiebaStatic.log(new ak("c10349").ab(ImageViewerConfig.FORUM_ID, this.forumId).ab("obj_type", this.from).s("obj_locate", i));
        }
    }

    public void bFW() {
        if (this.hEx != null && this.hEy != null) {
            this.hEy.nE(this.hEx.isOriginalImg());
        }
    }

    public View avs() {
        return this.dGq;
    }

    public int bFX() {
        return this.hEC;
    }

    public e bFY() {
        return this.hEx;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void xj(int i) {
        if (!this.hEz) {
            FragmentTransaction beginTransaction = getSupportFragmentManager().beginTransaction();
            Fragment findFragmentByTag = getSupportFragmentManager().findFragmentByTag(this.hEy.xl(this.mCurrentPage));
            if (findFragmentByTag != null) {
                beginTransaction.hide(findFragmentByTag);
            }
            this.mCurrentPage = i;
            if (getSupportFragmentManager().findFragmentByTag(this.hEy.xl(i)) != null) {
                beginTransaction.show(this.hEy.xk(i));
            } else {
                beginTransaction.add(d.g.fragment, this.hEy.xk(i), this.hEy.xl(i));
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
        int maxImagesAllowed = this.hEx.getMaxImagesAllowed();
        if (this.hEx.size() < maxImagesAllowed) {
            if (this.hEA == null || this.hEA.e(imageFileInfo)) {
                ImageFileInfo imageFileInfo2 = new ImageFileInfo();
                imageFileInfo2.setAlbumnId(imageFileInfo.getAlbumId());
                imageFileInfo2.setFilePath(imageFileInfo.getFilePath());
                imageFileInfo2.setModifyTime(imageFileInfo.getModifyTime());
                imageFileInfo2.setIsGif(imageFileInfo.isGif());
                imageFileInfo2.setIsLong(imageFileInfo.isLong());
                this.hEx.a(null);
                this.hEx.addChooseFile(imageFileInfo2);
                bFW();
                return true;
            }
            return false;
        } else if (bFZ()) {
            return c(imageFileInfo);
        } else {
            showToast(String.format(getPageContext().getContext().getString(d.j.album_beyond_max_choose), Integer.valueOf(maxImagesAllowed)));
            return false;
        }
    }

    public boolean bFZ() {
        if (getIntent().getBooleanExtra(AlbumActivityConfig.IS_SELECT_DIRECTLY, false)) {
            int maxImagesAllowed = this.hEx.getMaxImagesAllowed();
            if (this.hEx.size() == maxImagesAllowed && maxImagesAllowed == 1) {
                try {
                    ImageFileInfo imageFileInfo = (ImageFileInfo) v.f(this.hEx.bGq(), 0);
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
        this.hEx.a(null);
        this.hEx.delChooseFile(imageFileInfo);
        bFW();
        return true;
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i == 4) {
            closeLoadingDialog();
            if (this.mCurrentPage == 0) {
                if (this.hEx != null) {
                    this.hEx.setLastAlbumId(null);
                }
                bGa();
                return true;
            } else if (this.mCurrentPage == 1) {
                xj(0);
                return true;
            } else {
                return true;
            }
        }
        return super.onKeyDown(i, keyEvent);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void f(ImageFileInfo imageFileInfo, boolean z) {
        Fragment xk;
        if (this.hEy != null && (xk = this.hEy.xk(0)) != null && (xk instanceof k)) {
            ((k) xk).h(imageFileInfo, z);
        }
    }

    void g(ImageFileInfo imageFileInfo, boolean z) {
        Fragment xk;
        if (this.hEy != null && (xk = this.hEy.xk(1)) != null && (xk instanceof b)) {
            ((b) xk).h(imageFileInfo, z);
        }
    }

    private void bGa() {
        Intent intent = new Intent();
        String lastAlbumId = this.hEx.getLastAlbumId();
        if (TextUtils.isEmpty(lastAlbumId)) {
            lastAlbumId = "";
        }
        intent.putExtra(AlbumActivityConfig.LAST_ALBUM_ID, lastAlbumId);
        intent.putExtra(AlbumActivityConfig.CAMERA_REQUEST_FROM, this.hEB);
        setResult(0, intent);
        finish();
    }

    private void stopCamera() {
        if (this.hEy != null) {
            this.hEy.stopCamera();
        }
    }

    private void bGb() {
        if (this.hEy != null) {
            this.hEy.bGb();
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
        this.hEz = true;
        stopCamera();
        closeLoadingDialog();
        dismissAllDialog();
        f.bGu().destory();
        if (this.dGq != null) {
            this.dGq.setBackgroundDrawable(null);
        }
        if (this.hEy != null) {
            this.hEy.onDestroy();
        }
        if (this.hEG != null) {
            this.hEG.onDestroy();
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
            new com.baidu.tbadk.img.f(null).c(AlbumActivity.this.hEx.getWriteImagesInfo(), true);
            return AlbumActivity.this.hEx.getWriteImagesInfo().toJsonString();
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
        if (this.hEG != null) {
            this.hEG.onStart();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.adp.base.BdBaseFragmentActivity, android.support.v4.app.FragmentActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        bGb();
        if (this.hEG != null) {
            this.hEG.onResume();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.base.BdBaseFragmentActivity, android.support.v4.app.FragmentActivity, android.app.Activity
    public void onStop() {
        super.onStop();
        if (this.hEG != null) {
            this.hEG.onStop();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.adp.base.BdBaseFragmentActivity, android.support.v4.app.FragmentActivity, android.app.Activity
    public void onPause() {
        stopCamera();
        super.onPause();
    }
}
