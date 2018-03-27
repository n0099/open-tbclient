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
    private boolean dHu;
    private com.baidu.tieba.d.c fTx;
    private e hEI;
    private com.baidu.tieba.write.album.a hEJ;
    private g hEL;
    private l hER;
    private int mCurrentPage = 0;
    private boolean hEK = false;
    private String callFrom = "";
    private String from = "";
    private String forumName = "";
    private String forumId = "0";
    private int hEM = 0;
    private int hEN = 0;
    private boolean hEO = false;
    private boolean hEP = false;
    private int hEQ = 0;
    private View dGj = null;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.adp.base.BdBaseFragmentActivity, android.support.v4.app.FragmentActivity, android.support.v4.app.BaseFragmentActivityGingerbread, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setSwipeBackEnabled(false);
        setContentView(d.h.album_activity);
        this.dGj = findViewById(d.g.statebar_view);
        this.dHu = UtilHelper.canUseStyleImmersiveSticky();
        XD();
        initData(bundle);
        this.hEJ = new com.baidu.tieba.write.album.a(this);
        this.hEJ.aYU();
        xk(0);
    }

    public void showTip(View view) {
        if (this.fTx == null && view != null) {
            this.fTx = new com.baidu.tieba.d.c(getPageContext(), view);
            this.fTx.lS(d.f.bg_tip_blue_up_left);
            this.fTx.j(new View.OnClickListener() { // from class: com.baidu.tieba.write.album.AlbumActivity.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    AlbumActivity.this.fTx.anh();
                }
            });
            this.fTx.lR(16);
            this.fTx.lT(5000);
        }
        if (this.fTx != null) {
            String sharedPrefKeyWithAccount = com.baidu.tbadk.core.sharedPref.b.getSharedPrefKeyWithAccount("key_show_take_photo_tip");
            this.fTx.aK(getString(d.j.album_take_photo_tip), sharedPrefKeyWithAccount);
        }
    }

    private void XD() {
        if (this.dGj != null) {
            if (this.dHu && this.dGj.getLayoutParams() != null) {
                ViewGroup.LayoutParams layoutParams = this.dGj.getLayoutParams();
                layoutParams.height = UtilHelper.getStatusBarHeight();
                this.dGj.setLayoutParams(layoutParams);
                fY(true);
                return;
            }
            fY(false);
        }
    }

    private void fY(boolean z) {
        if (this.dGj != null) {
            if (this.dHu && z && this.dGj.getVisibility() != 0) {
                this.dGj.setVisibility(0);
            } else if (!z && this.dGj.getVisibility() != 8) {
                this.dGj.setVisibility(8);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.support.v4.app.FragmentActivity, android.app.Activity
    public void onSaveInstanceState(Bundle bundle) {
        bundle.putString(AlbumActivityConfig.WRITE_IMAGES_INFO, this.hEI.getWriteImagesInfo().toJsonString());
        bundle.putBoolean(AlbumActivityConfig.USE_ORIGINAL_IMG, this.hEO);
        bundle.putInt(AlbumActivityConfig.CAMERA_REQUEST_FROM, this.hEM);
        bundle.putString("forum_id", this.forumId);
        bundle.putString("forum_name", this.forumName);
        bundle.putInt(IntentConfig.KEY_ALBUM_THREAD, this.hEN);
        bundle.putBoolean("from_write", this.hEP);
    }

    private void initData(Bundle bundle) {
        this.hEI = new e(this);
        if (bundle != null) {
            WriteImagesInfo writeImagesInfo = new WriteImagesInfo();
            writeImagesInfo.parseJson(bundle.getString(AlbumActivityConfig.WRITE_IMAGES_INFO));
            this.hEI.setWriteImagesInfo(writeImagesInfo);
            this.hEO = bundle.getBoolean(AlbumActivityConfig.USE_ORIGINAL_IMG, false);
            this.hEM = bundle.getInt(AlbumActivityConfig.CAMERA_REQUEST_FROM, 0);
            this.forumId = bundle.getString("forum_id");
            this.forumName = bundle.getString("forum_name");
            this.hEN = bundle.getInt(IntentConfig.KEY_ALBUM_THREAD);
            this.hEP = bundle.getBoolean("from_write");
            this.callFrom = bundle.getString("KEY_CALL_FROM");
            this.hEQ = bundle.getInt("from_type");
        } else {
            Intent intent = getIntent();
            if (intent != null) {
                WriteImagesInfo writeImagesInfo2 = new WriteImagesInfo();
                writeImagesInfo2.parseJson(intent.getStringExtra(AlbumActivityConfig.WRITE_IMAGES_INFO));
                this.hEI.setWriteImagesInfo(writeImagesInfo2);
                this.hEI.setOriginalImg(writeImagesInfo2.isOriginalImg());
                this.hEO = intent.getBooleanExtra(AlbumActivityConfig.USE_ORIGINAL_IMG, false);
                this.hEM = intent.getIntExtra(AlbumActivityConfig.CAMERA_REQUEST_FROM, 0);
                this.from = intent.getStringExtra("from");
                this.forumId = intent.getStringExtra("forum_id");
                this.forumName = intent.getStringExtra("forum_name");
                this.hEN = intent.getIntExtra(IntentConfig.KEY_ALBUM_THREAD, 0);
                this.hEP = intent.getBooleanExtra("from_write", false);
                this.callFrom = intent.getStringExtra("KEY_CALL_FROM");
                this.hEQ = intent.getIntExtra("from_type", 0);
            }
        }
        bFX();
    }

    private void bFX() {
        if (this.hEM == 2) {
            this.hEL = new g() { // from class: com.baidu.tieba.write.album.AlbumActivity.2
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
        if (this.hEJ != null) {
            this.hEJ.onChangeSkinType(i);
        }
        aj.g(this.dGj, d.C0141d.cp_bg_line_d, i);
    }

    public void bFY() {
        if (this.hEM == 3) {
            TiebaStatic.log("c10489");
        }
        if (this.hEM == 5) {
            showLoadingDialog("正在上传");
            new a().execute(new String[0]);
        } else if (this.hEI != null) {
            if (this.hER == null || !this.hER.bGL()) {
                if (this.hEI.bGs()) {
                    VideoFileInfo bGq = this.hEI.bGq();
                    if (this.hER == null) {
                        this.hER = new l(this, this.forumName, this.forumId, "");
                        if (this.hEJ != null) {
                            this.hEJ.a(this.hER);
                        }
                    }
                    this.hER.a(bGq, this.callFrom);
                } else if (v.D(this.hEI.bGu()) == 1 && this.hEQ == 0) {
                    bFZ();
                } else {
                    ac(null);
                }
            }
        }
    }

    private void ac(Intent intent) {
        Intent intent2 = new Intent();
        intent2.putExtra(AlbumActivityConfig.ALBUM_RESULT, this.hEI.getWriteImagesInfo().toJsonString());
        intent2.putExtra(AlbumActivityConfig.CAMERA_REQUEST_FROM, this.hEM);
        intent2.putExtra("from_type", this.hEQ);
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
        if (!adh() && com.baidu.tieba.write.f.bFQ()) {
            sendMessage(new CustomMessage(2002001, new RecordVideoActivityConfig(tbPageContext.getPageActivity(), this.hEP ? 2 : 3, new ForumWriteData(this.forumId, this.forumName, null, null), this.hEI.getWriteImagesInfo(), "", this.hEQ)));
            TiebaStatic.log(new ak("c12611").s("obj_locate", 5).s("obj_type", 2));
        }
    }

    private void bFZ() {
        WriteImagesInfo writeImagesInfo;
        if (this.hEI != null && (writeImagesInfo = this.hEI.getWriteImagesInfo()) != null) {
            sendMessage(new CustomMessage(2002001, new WriteMulitImageActivityConfig(getPageContext().getPageActivity(), IEventCenterService.EventId.EventMode.SAPIACCOUNT_THROUGH_SERVER, writeImagesInfo, 0)));
        }
    }

    private void ad(Intent intent) {
        if (intent == null || this.hEI == null) {
            ac(null);
            return;
        }
        String stringExtra = intent.getStringExtra(AlbumActivityConfig.ALBUM_RESULT);
        if (stringExtra != null) {
            WriteImagesInfo writeImagesInfo = this.hEI.getWriteImagesInfo();
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
        if (view == this.hEJ.bGi()) {
            bFY();
        } else if (view == this.hEJ.bGk()) {
            bFY();
        } else if (view == this.hEJ.bGh()) {
            if (this.hEI != null) {
                this.hEI.setLastAlbumId(null);
            }
            bGe();
        } else if (view == this.hEJ.bGj()) {
            xk(0);
        } else if (view == this.hEJ.bGl()) {
            xi(2);
        } else if (view == this.hEJ.bGm()) {
            xi(1);
        }
    }

    private void xi(int i) {
        if (this.hEJ != null && this.hEI != null) {
            this.hEI.setOriginalImg(!this.hEI.isOriginalImg());
            bGa();
            xj(i);
        }
    }

    private void xj(int i) {
        if (this.hEI != null && this.hEI.isOriginalImg() && !StringUtils.isNull(this.from, true) && !StringUtils.isNull(this.forumId, true)) {
            TiebaStatic.log(new ak("c10349").ab(ImageViewerConfig.FORUM_ID, this.forumId).ab("obj_type", this.from).s("obj_locate", i));
        }
    }

    public void bGa() {
        if (this.hEI != null && this.hEJ != null) {
            this.hEJ.nJ(this.hEI.isOriginalImg());
        }
    }

    public View avs() {
        return this.dGj;
    }

    public int bGb() {
        return this.hEN;
    }

    public e bGc() {
        return this.hEI;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void xk(int i) {
        if (!this.hEK) {
            FragmentTransaction beginTransaction = getSupportFragmentManager().beginTransaction();
            Fragment findFragmentByTag = getSupportFragmentManager().findFragmentByTag(this.hEJ.xm(this.mCurrentPage));
            if (findFragmentByTag != null) {
                beginTransaction.hide(findFragmentByTag);
            }
            this.mCurrentPage = i;
            if (getSupportFragmentManager().findFragmentByTag(this.hEJ.xm(i)) != null) {
                beginTransaction.show(this.hEJ.xl(i));
            } else {
                beginTransaction.add(d.g.fragment, this.hEJ.xl(i), this.hEJ.xm(i));
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
        int maxImagesAllowed = this.hEI.getMaxImagesAllowed();
        if (this.hEI.size() < maxImagesAllowed) {
            if (this.hEL == null || this.hEL.e(imageFileInfo)) {
                ImageFileInfo imageFileInfo2 = new ImageFileInfo();
                imageFileInfo2.setAlbumnId(imageFileInfo.getAlbumId());
                imageFileInfo2.setFilePath(imageFileInfo.getFilePath());
                imageFileInfo2.setModifyTime(imageFileInfo.getModifyTime());
                imageFileInfo2.setIsGif(imageFileInfo.isGif());
                imageFileInfo2.setIsLong(imageFileInfo.isLong());
                this.hEI.a(null);
                this.hEI.addChooseFile(imageFileInfo2);
                bGa();
                return true;
            }
            return false;
        } else if (bGd()) {
            return c(imageFileInfo);
        } else {
            showToast(String.format(getPageContext().getContext().getString(d.j.album_beyond_max_choose), Integer.valueOf(maxImagesAllowed)));
            return false;
        }
    }

    public boolean bGd() {
        if (getIntent().getBooleanExtra(AlbumActivityConfig.IS_SELECT_DIRECTLY, false)) {
            int maxImagesAllowed = this.hEI.getMaxImagesAllowed();
            if (this.hEI.size() == maxImagesAllowed && maxImagesAllowed == 1) {
                try {
                    ImageFileInfo imageFileInfo = (ImageFileInfo) v.f(this.hEI.bGu(), 0);
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
        this.hEI.a(null);
        this.hEI.delChooseFile(imageFileInfo);
        bGa();
        return true;
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i == 4) {
            closeLoadingDialog();
            if (this.mCurrentPage == 0) {
                if (this.hEI != null) {
                    this.hEI.setLastAlbumId(null);
                }
                bGe();
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
        if (this.hEJ != null && (xl = this.hEJ.xl(0)) != null && (xl instanceof k)) {
            ((k) xl).h(imageFileInfo, z);
        }
    }

    void g(ImageFileInfo imageFileInfo, boolean z) {
        Fragment xl;
        if (this.hEJ != null && (xl = this.hEJ.xl(1)) != null && (xl instanceof b)) {
            ((b) xl).h(imageFileInfo, z);
        }
    }

    private void bGe() {
        Intent intent = new Intent();
        String lastAlbumId = this.hEI.getLastAlbumId();
        if (TextUtils.isEmpty(lastAlbumId)) {
            lastAlbumId = "";
        }
        intent.putExtra(AlbumActivityConfig.LAST_ALBUM_ID, lastAlbumId);
        intent.putExtra(AlbumActivityConfig.CAMERA_REQUEST_FROM, this.hEM);
        setResult(0, intent);
        finish();
    }

    private void stopCamera() {
        if (this.hEJ != null) {
            this.hEJ.stopCamera();
        }
    }

    private void bGf() {
        if (this.hEJ != null) {
            this.hEJ.bGf();
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
        this.hEK = true;
        stopCamera();
        closeLoadingDialog();
        dismissAllDialog();
        f.bGy().destory();
        if (this.dGj != null) {
            this.dGj.setBackgroundDrawable(null);
        }
        if (this.hEJ != null) {
            this.hEJ.onDestroy();
        }
        if (this.hER != null) {
            this.hER.onDestroy();
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
            new com.baidu.tbadk.img.f(null).c(AlbumActivity.this.hEI.getWriteImagesInfo(), true);
            return AlbumActivity.this.hEI.getWriteImagesInfo().toJsonString();
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
        if (this.hER != null) {
            this.hER.onStart();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.adp.base.BdBaseFragmentActivity, android.support.v4.app.FragmentActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        bGf();
        if (this.hER != null) {
            this.hER.onResume();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.base.BdBaseFragmentActivity, android.support.v4.app.FragmentActivity, android.app.Activity
    public void onStop() {
        super.onStop();
        if (this.hER != null) {
            this.hER.onStop();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.adp.base.BdBaseFragmentActivity, android.support.v4.app.FragmentActivity, android.app.Activity
    public void onPause() {
        stopCamera();
        super.onPause();
    }
}
