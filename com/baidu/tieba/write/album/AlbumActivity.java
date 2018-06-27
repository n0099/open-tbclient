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
import com.baidu.tbadk.core.util.ac;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.core.util.w;
import com.baidu.tbadk.img.ImageFileInfo;
import com.baidu.tbadk.img.WriteImagesInfo;
import com.baidu.tieba.d;
import com.baidu.tieba.frs.ForumWriteData;
/* loaded from: classes3.dex */
public class AlbumActivity extends BaseFragmentActivity implements View.OnClickListener, a.InterfaceC0062a {
    private boolean dmQ;
    private com.baidu.tieba.c.d fDV;
    private i hsC;
    private c hss;
    private com.baidu.tieba.write.album.a hst;
    private e hsw;
    private int mCurrentPage = 0;
    private boolean hsu = false;
    private String callFrom = "";
    private String from = "";
    private String forumName = "";
    private String forumId = "0";
    private int hsx = 0;
    private int hsy = 0;
    private boolean hsz = false;
    private boolean hsA = false;
    private int hsB = 0;
    private View dlF = null;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.adp.base.BdBaseFragmentActivity, android.support.v4.app.FragmentActivity, android.support.v4.app.SupportActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setSwipeBackEnabled(false);
        setContentView(d.i.album_activity);
        this.dlF = findViewById(d.g.statebar_view);
        this.dmQ = UtilHelper.canUseStyleImmersiveSticky();
        TS();
        initData(bundle);
        this.hst = new com.baidu.tieba.write.album.a(this);
        this.hst.aZs();
        vo(0);
    }

    public void showTip(View view) {
        if (this.fDV == null && view != null) {
            this.fDV = new com.baidu.tieba.c.d(getPageContext(), view);
            this.fDV.jd(d.f.bg_tip_blue_up_left);
            this.fDV.k(new View.OnClickListener() { // from class: com.baidu.tieba.write.album.AlbumActivity.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    AlbumActivity.this.fDV.akn();
                }
            });
            this.fDV.jc(16);
            this.fDV.je(5000);
        }
        if (this.fDV != null) {
            String sharedPrefKeyWithAccount = com.baidu.tbadk.core.sharedPref.b.getSharedPrefKeyWithAccount("key_show_take_photo_tip");
            this.fDV.aQ(getString(d.k.album_take_photo_tip), sharedPrefKeyWithAccount);
        }
    }

    private void TS() {
        if (this.dlF != null) {
            if (this.dmQ && this.dlF.getLayoutParams() != null) {
                ViewGroup.LayoutParams layoutParams = this.dlF.getLayoutParams();
                layoutParams.height = UtilHelper.getStatusBarHeight();
                this.dlF.setLayoutParams(layoutParams);
                fN(true);
                return;
            }
            fN(false);
        }
    }

    private void fN(boolean z) {
        if (this.dlF != null) {
            if (this.dmQ && z && this.dlF.getVisibility() != 0) {
                this.dlF.setVisibility(0);
            } else if (!z && this.dlF.getVisibility() != 8) {
                this.dlF.setVisibility(8);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.support.v4.app.FragmentActivity, android.support.v4.app.SupportActivity, android.app.Activity
    public void onSaveInstanceState(Bundle bundle) {
        bundle.putString(AlbumActivityConfig.WRITE_IMAGES_INFO, this.hss.getWriteImagesInfo().toJsonString());
        bundle.putBoolean(AlbumActivityConfig.USE_ORIGINAL_IMG, this.hsz);
        bundle.putInt(AlbumActivityConfig.CAMERA_REQUEST_FROM, this.hsx);
        bundle.putString("forum_id", this.forumId);
        bundle.putString("forum_name", this.forumName);
        bundle.putInt(IntentConfig.KEY_ALBUM_THREAD, this.hsy);
        bundle.putBoolean(IntentConfig.KEY_FROM_WRITEACTIVITY, this.hsA);
    }

    private void initData(Bundle bundle) {
        this.hss = new c(this);
        if (bundle != null) {
            WriteImagesInfo writeImagesInfo = new WriteImagesInfo();
            writeImagesInfo.parseJson(bundle.getString(AlbumActivityConfig.WRITE_IMAGES_INFO));
            this.hss.setWriteImagesInfo(writeImagesInfo);
            this.hsz = bundle.getBoolean(AlbumActivityConfig.USE_ORIGINAL_IMG, false);
            this.hsx = bundle.getInt(AlbumActivityConfig.CAMERA_REQUEST_FROM, 0);
            this.forumId = bundle.getString("forum_id");
            this.forumName = bundle.getString("forum_name");
            this.hsy = bundle.getInt(IntentConfig.KEY_ALBUM_THREAD);
            this.hsA = bundle.getBoolean(IntentConfig.KEY_FROM_WRITEACTIVITY);
            this.callFrom = bundle.getString("KEY_CALL_FROM");
            this.hsB = bundle.getInt("from_type");
        } else {
            Intent intent = getIntent();
            if (intent != null) {
                WriteImagesInfo writeImagesInfo2 = new WriteImagesInfo();
                writeImagesInfo2.parseJson(intent.getStringExtra(AlbumActivityConfig.WRITE_IMAGES_INFO));
                this.hss.setWriteImagesInfo(writeImagesInfo2);
                this.hss.setOriginalImg(writeImagesInfo2.isOriginalImg());
                this.hsz = intent.getBooleanExtra(AlbumActivityConfig.USE_ORIGINAL_IMG, false);
                this.hsx = intent.getIntExtra(AlbumActivityConfig.CAMERA_REQUEST_FROM, 0);
                this.from = intent.getStringExtra("from");
                this.forumId = intent.getStringExtra("forum_id");
                this.forumName = intent.getStringExtra("forum_name");
                this.hsy = intent.getIntExtra(IntentConfig.KEY_ALBUM_THREAD, 0);
                this.hsA = intent.getBooleanExtra(IntentConfig.KEY_FROM_WRITEACTIVITY, false);
                this.callFrom = intent.getStringExtra("KEY_CALL_FROM");
                this.hsB = intent.getIntExtra("from_type", 0);
            }
        }
        bGP();
    }

    private void bGP() {
        if (this.hsx == 2) {
            this.hsw = new e() { // from class: com.baidu.tieba.write.album.AlbumActivity.2
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
                    AlbumActivity.this.showToastWithIcon(AlbumActivity.this.getPageContext().getPageActivity().getString(d.k.uploade_attation), d.f.icon_toast_game_error);
                    return false;
                }
            };
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity
    protected void onChangeSkinType(int i) {
        if (this.hst != null) {
            this.hst.onChangeSkinType(i);
        }
        am.e(this.dlF, d.C0142d.cp_bg_line_d, i);
    }

    public void bGQ() {
        if (this.hsx == 3) {
            TiebaStatic.log("c10489");
        }
        if (this.hsx == 5) {
            showLoadingDialog("正在上传");
            new a().execute(new String[0]);
        } else if (this.hss != null) {
            if (this.hsC == null || !this.hsC.bHD()) {
                if (this.hss.bHk()) {
                    VideoFileInfo bHi = this.hss.bHi();
                    if (this.hsC == null) {
                        this.hsC = new i(this, this.forumName, this.forumId, "");
                        if (this.hst != null) {
                            this.hst.a(this.hsC);
                        }
                    }
                    this.hsC.a(bHi, this.callFrom);
                } else if (w.z(this.hss.bHm()) == 1 && this.hsB == 0) {
                    bGR();
                } else {
                    ab(null);
                }
            }
        }
    }

    private void ab(Intent intent) {
        Intent intent2 = new Intent();
        intent2.putExtra(AlbumActivityConfig.ALBUM_RESULT, this.hss.getWriteImagesInfo().toJsonString());
        intent2.putExtra(AlbumActivityConfig.CAMERA_REQUEST_FROM, this.hsx);
        intent2.putExtra("from_type", this.hsB);
        if (intent != null && !StringUtils.isNull(intent.getStringExtra("file_name"))) {
            intent2.putExtra("file_name", intent.getStringExtra("file_name"));
        }
        setResult(-1, intent2);
        finish();
    }

    private boolean abu() {
        Activity pageActivity = getPageContext().getPageActivity();
        com.baidu.tbadk.core.util.b.a aVar = new com.baidu.tbadk.core.util.b.a();
        aVar.Aj();
        aVar.c(pageActivity, "android.permission.CAMERA");
        aVar.c(pageActivity, "android.permission.RECORD_AUDIO");
        aVar.c(pageActivity, "android.permission.WRITE_EXTERNAL_STORAGE");
        return aVar.u(pageActivity);
    }

    public void b(TbPageContext tbPageContext) {
        if (!abu() && com.baidu.tieba.write.e.bGJ()) {
            sendMessage(new CustomMessage(2002001, new RecordVideoActivityConfig(tbPageContext.getPageActivity(), this.hsA ? 2 : 3, new ForumWriteData(this.forumId, this.forumName, null, null), this.hss.getWriteImagesInfo(), "", this.hsB)));
            TiebaStatic.log(new an("c12611").r("obj_locate", 5).r("obj_type", 2));
        }
    }

    private void bGR() {
        WriteImagesInfo writeImagesInfo;
        if (this.hss != null && (writeImagesInfo = this.hss.getWriteImagesInfo()) != null) {
            sendMessage(new CustomMessage(2002001, new WriteMulitImageActivityConfig(getPageContext().getPageActivity(), IEventCenterService.EventId.EventMode.SAPIACCOUNT_THROUGH_SERVER, writeImagesInfo, 0)));
        }
    }

    private void ac(Intent intent) {
        if (intent == null || this.hss == null) {
            ab(null);
            return;
        }
        String stringExtra = intent.getStringExtra(AlbumActivityConfig.ALBUM_RESULT);
        if (stringExtra != null) {
            WriteImagesInfo writeImagesInfo = this.hss.getWriteImagesInfo();
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
        if (view == this.hst.bHa()) {
            bGQ();
        } else if (view == this.hst.bHc()) {
            bGQ();
        } else if (view == this.hst.bGZ()) {
            if (this.hss != null) {
                this.hss.setLastAlbumId(null);
            }
            bGW();
        } else if (view == this.hst.bHb()) {
            vo(0);
        } else if (view == this.hst.bHd()) {
            vm(2);
        } else if (view == this.hst.bHe()) {
            vm(1);
        }
    }

    private void vm(int i) {
        if (this.hst != null && this.hss != null) {
            this.hss.setOriginalImg(!this.hss.isOriginalImg());
            bGS();
            vn(i);
        }
    }

    private void vn(int i) {
        if (this.hss != null && this.hss.isOriginalImg() && !StringUtils.isNull(this.from, true) && !StringUtils.isNull(this.forumId, true)) {
            TiebaStatic.log(new an("c10349").ah(ImageViewerConfig.FORUM_ID, this.forumId).ah("obj_type", this.from).r("obj_locate", i));
        }
    }

    public void bGS() {
        if (this.hss != null && this.hst != null) {
            this.hst.nE(this.hss.isOriginalImg());
        }
    }

    public View aum() {
        return this.dlF;
    }

    public int bGT() {
        return this.hsy;
    }

    public c bGU() {
        return this.hss;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void vo(int i) {
        if (!this.hsu) {
            FragmentTransaction beginTransaction = getSupportFragmentManager().beginTransaction();
            Fragment findFragmentByTag = getSupportFragmentManager().findFragmentByTag(this.hst.vq(this.mCurrentPage));
            if (findFragmentByTag != null) {
                beginTransaction.hide(findFragmentByTag);
            }
            this.mCurrentPage = i;
            if (getSupportFragmentManager().findFragmentByTag(this.hst.vq(i)) != null) {
                beginTransaction.show(this.hst.vp(i));
            } else {
                beginTransaction.add(d.g.fragment, this.hst.vp(i), this.hst.vq(i));
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
        int maxImagesAllowed = this.hss.getMaxImagesAllowed();
        if (this.hss.size() < maxImagesAllowed) {
            if (this.hsw == null || this.hsw.e(imageFileInfo)) {
                ImageFileInfo imageFileInfo2 = new ImageFileInfo();
                imageFileInfo2.setAlbumnId(imageFileInfo.getAlbumId());
                imageFileInfo2.setFilePath(imageFileInfo.getFilePath());
                imageFileInfo2.setModifyTime(imageFileInfo.getModifyTime());
                imageFileInfo2.setIsGif(imageFileInfo.isGif());
                imageFileInfo2.setIsLong(imageFileInfo.isLong());
                this.hss.a(null);
                this.hss.addChooseFile(imageFileInfo2);
                bGS();
                return true;
            }
            return false;
        } else if (bGV()) {
            return c(imageFileInfo);
        } else {
            showToast(String.format(getPageContext().getContext().getString(d.k.album_beyond_max_choose), Integer.valueOf(maxImagesAllowed)));
            return false;
        }
    }

    public boolean bGV() {
        if (getIntent().getBooleanExtra(AlbumActivityConfig.IS_SELECT_DIRECTLY, false)) {
            int maxImagesAllowed = this.hss.getMaxImagesAllowed();
            if (this.hss.size() == maxImagesAllowed && maxImagesAllowed == 1) {
                try {
                    ImageFileInfo imageFileInfo = (ImageFileInfo) w.d(this.hss.bHm(), 0);
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
        this.hss.a(null);
        this.hss.delChooseFile(imageFileInfo);
        bGS();
        return true;
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i == 4) {
            closeLoadingDialog();
            if (this.mCurrentPage == 0) {
                if (this.hss != null) {
                    this.hss.setLastAlbumId(null);
                }
                bGW();
                return true;
            } else if (this.mCurrentPage == 1) {
                vo(0);
                return true;
            } else {
                return true;
            }
        }
        return super.onKeyDown(i, keyEvent);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void f(ImageFileInfo imageFileInfo, boolean z) {
        Fragment vp;
        if (this.hst != null && (vp = this.hst.vp(0)) != null && (vp instanceof ImageListFragment)) {
            ((ImageListFragment) vp).h(imageFileInfo, z);
        }
    }

    void g(ImageFileInfo imageFileInfo, boolean z) {
        Fragment vp;
        if (this.hst != null && (vp = this.hst.vp(1)) != null && (vp instanceof AlbumImageBrowseFragment)) {
            ((AlbumImageBrowseFragment) vp).h(imageFileInfo, z);
        }
    }

    private void bGW() {
        Intent intent = new Intent();
        String lastAlbumId = this.hss.getLastAlbumId();
        if (TextUtils.isEmpty(lastAlbumId)) {
            lastAlbumId = "";
        }
        intent.putExtra(AlbumActivityConfig.LAST_ALBUM_ID, lastAlbumId);
        intent.putExtra(AlbumActivityConfig.CAMERA_REQUEST_FROM, this.hsx);
        setResult(0, intent);
        finish();
    }

    private void stopCamera() {
        if (this.hst != null) {
            this.hst.stopCamera();
        }
    }

    private void bGX() {
        if (this.hst != null) {
            this.hst.bGX();
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
        this.hsu = true;
        stopCamera();
        closeLoadingDialog();
        dismissAllDialog();
        d.bHq().destory();
        if (this.dlF != null) {
            this.dlF.setBackgroundDrawable(null);
        }
        if (this.hst != null) {
            this.hst.onDestroy();
        }
        if (this.hsC != null) {
            this.hsC.onDestroy();
        }
    }

    @Override // android.support.v4.app.FragmentActivity, android.app.Activity, android.support.v4.app.ActivityCompat.OnRequestPermissionsResultCallback
    public void onRequestPermissionsResult(int i, String[] strArr, int[] iArr) {
        if (i == 1) {
            if (!ac.aN(getApplicationContext())) {
                showToast(d.k.system_permission_prompt_camera);
            }
            ArrayMap<String, Boolean> b = ac.b(strArr, iArr);
            if (b.containsKey("android.permission.WRITE_EXTERNAL_STORAGE") && !b.get("android.permission.WRITE_EXTERNAL_STORAGE").booleanValue()) {
                showToast(d.k.sdcard_permission_denied_advert_for_camera);
            }
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
            new com.baidu.tbadk.img.f(null).c(AlbumActivity.this.hss.getWriteImagesInfo(), true);
            return AlbumActivity.this.hss.getWriteImagesInfo().toJsonString();
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
        if (this.hsC != null) {
            this.hsC.onStart();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.adp.base.BdBaseFragmentActivity, android.support.v4.app.FragmentActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        bGX();
        if (this.hsC != null) {
            this.hsC.onResume();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.base.BdBaseFragmentActivity, android.support.v4.app.FragmentActivity, android.app.Activity
    public void onStop() {
        super.onStop();
        if (this.hsC != null) {
            this.hsC.onStop();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.adp.base.BdBaseFragmentActivity, android.support.v4.app.FragmentActivity, android.app.Activity
    public void onPause() {
        stopCamera();
        super.onPause();
    }
}
