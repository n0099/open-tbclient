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
    private boolean dEc;
    private com.baidu.tieba.d.b fPL;
    private e hCG;
    private com.baidu.tieba.write.album.a hCH;
    private g hCJ;
    private l hCP;
    private int mCurrentPage = 0;
    private boolean hCI = false;
    private String callFrom = "";
    private String from = "";
    private String forumName = "";
    private String forumId = "0";
    private int hCK = 0;
    private int hCL = 0;
    private boolean hCM = false;
    private boolean hCN = false;
    private int hCO = 0;
    private View dCY = null;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.adp.base.BdBaseFragmentActivity, android.support.v4.app.FragmentActivity, android.support.v4.app.BaseFragmentActivityGingerbread, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setSwipeBackEnabled(false);
        setContentView(d.h.album_activity);
        this.dCY = findViewById(d.g.statebar_view);
        this.dEc = UtilHelper.canUseStyleImmersiveSticky();
        avs();
        initData(bundle);
        this.hCH = new com.baidu.tieba.write.album.a(this);
        this.hCH.aXg();
        xk(0);
    }

    public void showTip(View view) {
        if (this.fPL == null && view != null) {
            this.fPL = new com.baidu.tieba.d.b(getPageContext(), view);
            this.fPL.lV(d.f.bg_tip_blue_up_left);
            this.fPL.j(new View.OnClickListener() { // from class: com.baidu.tieba.write.album.AlbumActivity.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    AlbumActivity.this.fPL.amr();
                }
            });
            this.fPL.lU(16);
            this.fPL.lW(5000);
        }
        if (this.fPL != null) {
            String sharedPrefKeyWithAccount = com.baidu.tbadk.core.sharedPref.b.getSharedPrefKeyWithAccount("key_show_take_photo_tip");
            this.fPL.aK(getString(d.j.album_take_photo_tip), sharedPrefKeyWithAccount);
        }
    }

    private void avs() {
        if (this.dCY != null) {
            if (this.dEc && this.dCY.getLayoutParams() != null) {
                ViewGroup.LayoutParams layoutParams = this.dCY.getLayoutParams();
                layoutParams.height = UtilHelper.getStatusBarHeight();
                this.dCY.setLayoutParams(layoutParams);
                fO(true);
                return;
            }
            fO(false);
        }
    }

    private void fO(boolean z) {
        if (this.dCY != null) {
            if (this.dEc && z && this.dCY.getVisibility() != 0) {
                this.dCY.setVisibility(0);
            } else if (!z && this.dCY.getVisibility() != 8) {
                this.dCY.setVisibility(8);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.support.v4.app.FragmentActivity, android.app.Activity
    public void onSaveInstanceState(Bundle bundle) {
        bundle.putString(AlbumActivityConfig.WRITE_IMAGES_INFO, this.hCG.getWriteImagesInfo().toJsonString());
        bundle.putBoolean(AlbumActivityConfig.USE_ORIGINAL_IMG, this.hCM);
        bundle.putInt(AlbumActivityConfig.CAMERA_REQUEST_FROM, this.hCK);
        bundle.putString("forum_id", this.forumId);
        bundle.putString("forum_name", this.forumName);
        bundle.putInt(IntentConfig.KEY_ALBUM_THREAD, this.hCL);
        bundle.putBoolean("from_write", this.hCN);
    }

    private void initData(Bundle bundle) {
        this.hCG = new e(this);
        if (bundle != null) {
            WriteImagesInfo writeImagesInfo = new WriteImagesInfo();
            writeImagesInfo.parseJson(bundle.getString(AlbumActivityConfig.WRITE_IMAGES_INFO));
            this.hCG.setWriteImagesInfo(writeImagesInfo);
            this.hCM = bundle.getBoolean(AlbumActivityConfig.USE_ORIGINAL_IMG, false);
            this.hCK = bundle.getInt(AlbumActivityConfig.CAMERA_REQUEST_FROM, 0);
            this.forumId = bundle.getString("forum_id");
            this.forumName = bundle.getString("forum_name");
            this.hCL = bundle.getInt(IntentConfig.KEY_ALBUM_THREAD);
            this.hCN = bundle.getBoolean("from_write");
            this.callFrom = bundle.getString("KEY_CALL_FROM");
            this.hCO = bundle.getInt("from_type");
        } else {
            Intent intent = getIntent();
            if (intent != null) {
                WriteImagesInfo writeImagesInfo2 = new WriteImagesInfo();
                writeImagesInfo2.parseJson(intent.getStringExtra(AlbumActivityConfig.WRITE_IMAGES_INFO));
                this.hCG.setWriteImagesInfo(writeImagesInfo2);
                this.hCG.setOriginalImg(writeImagesInfo2.isOriginalImg());
                this.hCM = intent.getBooleanExtra(AlbumActivityConfig.USE_ORIGINAL_IMG, false);
                this.hCK = intent.getIntExtra(AlbumActivityConfig.CAMERA_REQUEST_FROM, 0);
                this.from = intent.getStringExtra("from");
                this.forumId = intent.getStringExtra("forum_id");
                this.forumName = intent.getStringExtra("forum_name");
                this.hCL = intent.getIntExtra(IntentConfig.KEY_ALBUM_THREAD, 0);
                this.hCN = intent.getBooleanExtra("from_write", false);
                this.callFrom = intent.getStringExtra("KEY_CALL_FROM");
                this.hCO = intent.getIntExtra("from_type", 0);
            }
        }
        bFd();
    }

    private void bFd() {
        if (this.hCK == 2) {
            this.hCJ = new g() { // from class: com.baidu.tieba.write.album.AlbumActivity.2
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
        if (this.hCH != null) {
            this.hCH.onChangeSkinType(i);
        }
        aj.g(this.dCY, d.C0107d.cp_bg_line_d, i);
    }

    public void bFe() {
        if (this.hCK == 3) {
            TiebaStatic.log("c10489");
        }
        if (this.hCK == 5) {
            showLoadingDialog("正在上传");
            new a().execute(new String[0]);
        } else if (this.hCG != null) {
            if (this.hCP == null || !this.hCP.bFR()) {
                if (this.hCG.bFy()) {
                    VideoFileInfo bFw = this.hCG.bFw();
                    if (this.hCP == null) {
                        this.hCP = new l(this, this.forumName, this.forumId, "");
                        if (this.hCH != null) {
                            this.hCH.a(this.hCP);
                        }
                    }
                    this.hCP.a(bFw, this.callFrom);
                } else if (v.D(this.hCG.bFA()) == 1 && this.hCO == 0) {
                    bFf();
                } else {
                    ae(null);
                }
            }
        }
    }

    private void ae(Intent intent) {
        Intent intent2 = new Intent();
        intent2.putExtra(AlbumActivityConfig.ALBUM_RESULT, this.hCG.getWriteImagesInfo().toJsonString());
        intent2.putExtra(AlbumActivityConfig.CAMERA_REQUEST_FROM, this.hCK);
        intent2.putExtra("from_type", this.hCO);
        if (intent != null && !StringUtils.isNull(intent.getStringExtra("file_name"))) {
            intent2.putExtra("file_name", intent.getStringExtra("file_name"));
        }
        setResult(-1, intent2);
        finish();
    }

    public void c(TbPageContext tbPageContext) {
        if (com.baidu.tieba.write.f.bEW()) {
            sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new RecordVideoActivityConfig(tbPageContext.getPageActivity(), this.hCN ? 2 : 3, new ForumWriteData(this.forumId, this.forumName, null, null), this.hCG.getWriteImagesInfo(), "", this.hCO)));
            TiebaStatic.log(new ak("c12611").s("obj_locate", 5).s("obj_type", 2));
        }
    }

    private void bFf() {
        WriteImagesInfo writeImagesInfo;
        if (this.hCG != null && (writeImagesInfo = this.hCG.getWriteImagesInfo()) != null) {
            sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new WriteMulitImageActivityConfig(getPageContext().getPageActivity(), IEventCenterService.EventId.EventMode.SAPIACCOUNT_THROUGH_SERVER, writeImagesInfo, 0)));
        }
    }

    private void af(Intent intent) {
        if (intent == null || this.hCG == null) {
            ae(null);
            return;
        }
        String stringExtra = intent.getStringExtra(AlbumActivityConfig.ALBUM_RESULT);
        if (stringExtra != null) {
            WriteImagesInfo writeImagesInfo = this.hCG.getWriteImagesInfo();
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
        if (view == this.hCH.bFo()) {
            bFe();
        } else if (view == this.hCH.bFq()) {
            bFe();
        } else if (view == this.hCH.bFn()) {
            if (this.hCG != null) {
                this.hCG.setLastAlbumId(null);
            }
            bFk();
        } else if (view == this.hCH.bFp()) {
            xk(0);
        } else if (view == this.hCH.bFr()) {
            xi(2);
        } else if (view == this.hCH.bFs()) {
            xi(1);
        }
    }

    private void xi(int i) {
        if (this.hCH != null && this.hCG != null) {
            this.hCG.setOriginalImg(!this.hCG.isOriginalImg());
            bFg();
            xj(i);
        }
    }

    private void xj(int i) {
        if (this.hCG != null && this.hCG.isOriginalImg() && !StringUtils.isNull(this.from, true) && !StringUtils.isNull(this.forumId, true)) {
            TiebaStatic.log(new ak("c10349").ab(ImageViewerConfig.FORUM_ID, this.forumId).ab("obj_type", this.from).s("obj_locate", i));
        }
    }

    public void bFg() {
        if (this.hCG != null && this.hCH != null) {
            this.hCH.nu(this.hCG.isOriginalImg());
        }
    }

    public View aux() {
        return this.dCY;
    }

    public int bFh() {
        return this.hCL;
    }

    public e bFi() {
        return this.hCG;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void xk(int i) {
        if (!this.hCI) {
            FragmentTransaction beginTransaction = getSupportFragmentManager().beginTransaction();
            Fragment findFragmentByTag = getSupportFragmentManager().findFragmentByTag(this.hCH.xm(this.mCurrentPage));
            if (findFragmentByTag != null) {
                beginTransaction.hide(findFragmentByTag);
            }
            this.mCurrentPage = i;
            if (getSupportFragmentManager().findFragmentByTag(this.hCH.xm(i)) != null) {
                beginTransaction.show(this.hCH.xl(i));
            } else {
                beginTransaction.add(d.g.fragment, this.hCH.xl(i), this.hCH.xm(i));
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
        int maxImagesAllowed = this.hCG.getMaxImagesAllowed();
        if (this.hCG.size() < maxImagesAllowed) {
            if (this.hCJ == null || this.hCJ.e(imageFileInfo)) {
                ImageFileInfo imageFileInfo2 = new ImageFileInfo();
                imageFileInfo2.setAlbumnId(imageFileInfo.getAlbumId());
                imageFileInfo2.setFilePath(imageFileInfo.getFilePath());
                imageFileInfo2.setModifyTime(imageFileInfo.getModifyTime());
                imageFileInfo2.setIsGif(imageFileInfo.isGif());
                imageFileInfo2.setIsLong(imageFileInfo.isLong());
                this.hCG.a(null);
                this.hCG.addChooseFile(imageFileInfo2);
                bFg();
                return true;
            }
            return false;
        } else if (bFj()) {
            return c(imageFileInfo);
        } else {
            showToast(String.format(getPageContext().getContext().getString(d.j.album_beyond_max_choose), Integer.valueOf(maxImagesAllowed)));
            return false;
        }
    }

    public boolean bFj() {
        if (getIntent().getBooleanExtra(AlbumActivityConfig.IS_SELECT_DIRECTLY, false)) {
            int maxImagesAllowed = this.hCG.getMaxImagesAllowed();
            if (this.hCG.size() == maxImagesAllowed && maxImagesAllowed == 1) {
                try {
                    ImageFileInfo imageFileInfo = (ImageFileInfo) v.f(this.hCG.bFA(), 0);
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
        this.hCG.a(null);
        this.hCG.delChooseFile(imageFileInfo);
        bFg();
        return true;
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i == 4) {
            closeLoadingDialog();
            if (this.mCurrentPage == 0) {
                if (this.hCG != null) {
                    this.hCG.setLastAlbumId(null);
                }
                bFk();
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
        if (this.hCH != null && (xl = this.hCH.xl(0)) != null && (xl instanceof k)) {
            ((k) xl).h(imageFileInfo, z);
        }
    }

    void g(ImageFileInfo imageFileInfo, boolean z) {
        Fragment xl;
        if (this.hCH != null && (xl = this.hCH.xl(1)) != null && (xl instanceof b)) {
            ((b) xl).h(imageFileInfo, z);
        }
    }

    private void bFk() {
        Intent intent = new Intent();
        String lastAlbumId = this.hCG.getLastAlbumId();
        if (TextUtils.isEmpty(lastAlbumId)) {
            lastAlbumId = "";
        }
        intent.putExtra(AlbumActivityConfig.LAST_ALBUM_ID, lastAlbumId);
        intent.putExtra(AlbumActivityConfig.CAMERA_REQUEST_FROM, this.hCK);
        setResult(0, intent);
        finish();
    }

    private void stopCamera() {
        if (this.hCH != null) {
            this.hCH.stopCamera();
        }
    }

    private void bFl() {
        if (this.hCH != null) {
            this.hCH.bFl();
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
        this.hCI = true;
        stopCamera();
        closeLoadingDialog();
        dismissAllDialog();
        f.bFE().destory();
        if (this.dCY != null) {
            this.dCY.setBackgroundDrawable(null);
        }
        if (this.hCH != null) {
            this.hCH.onDestroy();
        }
        if (this.hCP != null) {
            this.hCP.onDestroy();
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
            new com.baidu.tbadk.img.f(null).c(AlbumActivity.this.hCG.getWriteImagesInfo(), true);
            return AlbumActivity.this.hCG.getWriteImagesInfo().toJsonString();
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
        if (this.hCP != null) {
            this.hCP.onStart();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.adp.base.BdBaseFragmentActivity, android.support.v4.app.FragmentActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        bFl();
        if (this.hCP != null) {
            this.hCP.onResume();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.base.BdBaseFragmentActivity, android.support.v4.app.FragmentActivity, android.app.Activity
    public void onStop() {
        super.onStop();
        if (this.hCP != null) {
            this.hCP.onStop();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.adp.base.BdBaseFragmentActivity, android.support.v4.app.FragmentActivity, android.app.Activity
    public void onPause() {
        stopCamera();
        super.onPause();
    }
}
