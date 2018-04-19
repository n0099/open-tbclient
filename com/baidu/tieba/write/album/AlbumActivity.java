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
import com.baidu.tbadk.core.util.ak;
import com.baidu.tbadk.core.util.al;
import com.baidu.tbadk.core.util.v;
import com.baidu.tbadk.img.ImageFileInfo;
import com.baidu.tbadk.img.WriteImagesInfo;
import com.baidu.tieba.d;
import com.baidu.tieba.frs.ForumWriteData;
/* loaded from: classes3.dex */
public class AlbumActivity extends BaseFragmentActivity implements View.OnClickListener, a.InterfaceC0045a {
    private boolean dan;
    private com.baidu.tieba.d.c fnw;
    private c hbn;
    private com.baidu.tieba.write.album.a hbo;
    private e hbq;
    private i hbw;
    private int mCurrentPage = 0;
    private boolean hbp = false;
    private String callFrom = "";
    private String from = "";
    private String forumName = "";
    private String forumId = "0";
    private int hbr = 0;
    private int hbs = 0;
    private boolean hbt = false;
    private boolean hbu = false;
    private int hbv = 0;
    private View cZg = null;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.adp.base.BdBaseFragmentActivity, android.support.v4.app.FragmentActivity, android.support.v4.app.BaseFragmentActivityGingerbread, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setSwipeBackEnabled(false);
        setContentView(d.i.album_activity);
        this.cZg = findViewById(d.g.statebar_view);
        this.dan = UtilHelper.canUseStyleImmersiveSticky();
        Qd();
        initData(bundle);
        this.hbo = new com.baidu.tieba.write.album.a(this);
        this.hbo.aTP();
        uO(0);
    }

    public void showTip(View view2) {
        if (this.fnw == null && view2 != null) {
            this.fnw = new com.baidu.tieba.d.c(getPageContext(), view2);
            this.fnw.jd(d.f.bg_tip_blue_up_left);
            this.fnw.j(new View.OnClickListener() { // from class: com.baidu.tieba.write.album.AlbumActivity.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view3) {
                    AlbumActivity.this.fnw.ahf();
                }
            });
            this.fnw.jc(16);
            this.fnw.je(5000);
        }
        if (this.fnw != null) {
            String sharedPrefKeyWithAccount = com.baidu.tbadk.core.sharedPref.b.getSharedPrefKeyWithAccount("key_show_take_photo_tip");
            this.fnw.aJ(getString(d.k.album_take_photo_tip), sharedPrefKeyWithAccount);
        }
    }

    private void Qd() {
        if (this.cZg != null) {
            if (this.dan && this.cZg.getLayoutParams() != null) {
                ViewGroup.LayoutParams layoutParams = this.cZg.getLayoutParams();
                layoutParams.height = UtilHelper.getStatusBarHeight();
                this.cZg.setLayoutParams(layoutParams);
                fD(true);
                return;
            }
            fD(false);
        }
    }

    private void fD(boolean z) {
        if (this.cZg != null) {
            if (this.dan && z && this.cZg.getVisibility() != 0) {
                this.cZg.setVisibility(0);
            } else if (!z && this.cZg.getVisibility() != 8) {
                this.cZg.setVisibility(8);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.support.v4.app.FragmentActivity, android.app.Activity
    public void onSaveInstanceState(Bundle bundle) {
        bundle.putString(AlbumActivityConfig.WRITE_IMAGES_INFO, this.hbn.getWriteImagesInfo().toJsonString());
        bundle.putBoolean(AlbumActivityConfig.USE_ORIGINAL_IMG, this.hbt);
        bundle.putInt(AlbumActivityConfig.CAMERA_REQUEST_FROM, this.hbr);
        bundle.putString("forum_id", this.forumId);
        bundle.putString("forum_name", this.forumName);
        bundle.putInt(IntentConfig.KEY_ALBUM_THREAD, this.hbs);
        bundle.putBoolean(IntentConfig.KEY_FROM_WRITEACTIVITY, this.hbu);
    }

    private void initData(Bundle bundle) {
        this.hbn = new c(this);
        if (bundle != null) {
            WriteImagesInfo writeImagesInfo = new WriteImagesInfo();
            writeImagesInfo.parseJson(bundle.getString(AlbumActivityConfig.WRITE_IMAGES_INFO));
            this.hbn.setWriteImagesInfo(writeImagesInfo);
            this.hbt = bundle.getBoolean(AlbumActivityConfig.USE_ORIGINAL_IMG, false);
            this.hbr = bundle.getInt(AlbumActivityConfig.CAMERA_REQUEST_FROM, 0);
            this.forumId = bundle.getString("forum_id");
            this.forumName = bundle.getString("forum_name");
            this.hbs = bundle.getInt(IntentConfig.KEY_ALBUM_THREAD);
            this.hbu = bundle.getBoolean(IntentConfig.KEY_FROM_WRITEACTIVITY);
            this.callFrom = bundle.getString("KEY_CALL_FROM");
            this.hbv = bundle.getInt("from_type");
        } else {
            Intent intent = getIntent();
            if (intent != null) {
                WriteImagesInfo writeImagesInfo2 = new WriteImagesInfo();
                writeImagesInfo2.parseJson(intent.getStringExtra(AlbumActivityConfig.WRITE_IMAGES_INFO));
                this.hbn.setWriteImagesInfo(writeImagesInfo2);
                this.hbn.setOriginalImg(writeImagesInfo2.isOriginalImg());
                this.hbt = intent.getBooleanExtra(AlbumActivityConfig.USE_ORIGINAL_IMG, false);
                this.hbr = intent.getIntExtra(AlbumActivityConfig.CAMERA_REQUEST_FROM, 0);
                this.from = intent.getStringExtra("from");
                this.forumId = intent.getStringExtra("forum_id");
                this.forumName = intent.getStringExtra("forum_name");
                this.hbs = intent.getIntExtra(IntentConfig.KEY_ALBUM_THREAD, 0);
                this.hbu = intent.getBooleanExtra(IntentConfig.KEY_FROM_WRITEACTIVITY, false);
                this.callFrom = intent.getStringExtra("KEY_CALL_FROM");
                this.hbv = intent.getIntExtra("from_type", 0);
            }
        }
        bBk();
    }

    private void bBk() {
        if (this.hbr == 2) {
            this.hbq = new e() { // from class: com.baidu.tieba.write.album.AlbumActivity.2
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
        if (this.hbo != null) {
            this.hbo.onChangeSkinType(i);
        }
        ak.e(this.cZg, d.C0126d.cp_bg_line_d, i);
    }

    public void bBl() {
        if (this.hbr == 3) {
            TiebaStatic.log("c10489");
        }
        if (this.hbr == 5) {
            showLoadingDialog("正在上传");
            new a().execute(new String[0]);
        } else if (this.hbn != null) {
            if (this.hbw == null || !this.hbw.bBY()) {
                if (this.hbn.bBF()) {
                    VideoFileInfo bBD = this.hbn.bBD();
                    if (this.hbw == null) {
                        this.hbw = new i(this, this.forumName, this.forumId, "");
                        if (this.hbo != null) {
                            this.hbo.a(this.hbw);
                        }
                    }
                    this.hbw.a(bBD, this.callFrom);
                } else if (v.v(this.hbn.bBH()) == 1 && this.hbv == 0) {
                    bBm();
                } else {
                    ab(null);
                }
            }
        }
    }

    private void ab(Intent intent) {
        Intent intent2 = new Intent();
        intent2.putExtra(AlbumActivityConfig.ALBUM_RESULT, this.hbn.getWriteImagesInfo().toJsonString());
        intent2.putExtra(AlbumActivityConfig.CAMERA_REQUEST_FROM, this.hbr);
        intent2.putExtra("from_type", this.hbv);
        if (intent != null && !StringUtils.isNull(intent.getStringExtra("file_name"))) {
            intent2.putExtra("file_name", intent.getStringExtra("file_name"));
        }
        setResult(-1, intent2);
        finish();
    }

    private boolean Xn() {
        Activity pageActivity = getPageContext().getPageActivity();
        com.baidu.tbadk.core.util.b.a aVar = new com.baidu.tbadk.core.util.b.a();
        aVar.wu();
        aVar.c(pageActivity, "android.permission.CAMERA");
        aVar.c(pageActivity, "android.permission.RECORD_AUDIO");
        aVar.c(pageActivity, "android.permission.WRITE_EXTERNAL_STORAGE");
        return aVar.v(pageActivity);
    }

    public void b(TbPageContext tbPageContext) {
        if (!Xn() && com.baidu.tieba.write.e.bBe()) {
            sendMessage(new CustomMessage(2002001, new RecordVideoActivityConfig(tbPageContext.getPageActivity(), this.hbu ? 2 : 3, new ForumWriteData(this.forumId, this.forumName, null, null), this.hbn.getWriteImagesInfo(), "", this.hbv)));
            TiebaStatic.log(new al("c12611").r("obj_locate", 5).r("obj_type", 2));
        }
    }

    private void bBm() {
        WriteImagesInfo writeImagesInfo;
        if (this.hbn != null && (writeImagesInfo = this.hbn.getWriteImagesInfo()) != null) {
            sendMessage(new CustomMessage(2002001, new WriteMulitImageActivityConfig(getPageContext().getPageActivity(), IEventCenterService.EventId.EventMode.SAPIACCOUNT_THROUGH_SERVER, writeImagesInfo, 0)));
        }
    }

    private void ac(Intent intent) {
        if (intent == null || this.hbn == null) {
            ab(null);
            return;
        }
        String stringExtra = intent.getStringExtra(AlbumActivityConfig.ALBUM_RESULT);
        if (stringExtra != null) {
            WriteImagesInfo writeImagesInfo = this.hbn.getWriteImagesInfo();
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
    public void onClick(View view2) {
        if (view2 == this.hbo.bBv()) {
            bBl();
        } else if (view2 == this.hbo.bBx()) {
            bBl();
        } else if (view2 == this.hbo.bBu()) {
            if (this.hbn != null) {
                this.hbn.setLastAlbumId(null);
            }
            bBr();
        } else if (view2 == this.hbo.bBw()) {
            uO(0);
        } else if (view2 == this.hbo.bBy()) {
            uM(2);
        } else if (view2 == this.hbo.bBz()) {
            uM(1);
        }
    }

    private void uM(int i) {
        if (this.hbo != null && this.hbn != null) {
            this.hbn.setOriginalImg(!this.hbn.isOriginalImg());
            bBn();
            uN(i);
        }
    }

    private void uN(int i) {
        if (this.hbn != null && this.hbn.isOriginalImg() && !StringUtils.isNull(this.from, true) && !StringUtils.isNull(this.forumId, true)) {
            TiebaStatic.log(new al("c10349").ac(ImageViewerConfig.FORUM_ID, this.forumId).ac("obj_type", this.from).r("obj_locate", i));
        }
    }

    public void bBn() {
        if (this.hbn != null && this.hbo != null) {
            this.hbo.nn(this.hbn.isOriginalImg());
        }
    }

    public View apQ() {
        return this.cZg;
    }

    public int bBo() {
        return this.hbs;
    }

    public c bBp() {
        return this.hbn;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void uO(int i) {
        if (!this.hbp) {
            FragmentTransaction beginTransaction = getSupportFragmentManager().beginTransaction();
            Fragment findFragmentByTag = getSupportFragmentManager().findFragmentByTag(this.hbo.uQ(this.mCurrentPage));
            if (findFragmentByTag != null) {
                beginTransaction.hide(findFragmentByTag);
            }
            this.mCurrentPage = i;
            if (getSupportFragmentManager().findFragmentByTag(this.hbo.uQ(i)) != null) {
                beginTransaction.show(this.hbo.uP(i));
            } else {
                beginTransaction.add(d.g.fragment, this.hbo.uP(i), this.hbo.uQ(i));
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
        int maxImagesAllowed = this.hbn.getMaxImagesAllowed();
        if (this.hbn.size() < maxImagesAllowed) {
            if (this.hbq == null || this.hbq.e(imageFileInfo)) {
                ImageFileInfo imageFileInfo2 = new ImageFileInfo();
                imageFileInfo2.setAlbumnId(imageFileInfo.getAlbumId());
                imageFileInfo2.setFilePath(imageFileInfo.getFilePath());
                imageFileInfo2.setModifyTime(imageFileInfo.getModifyTime());
                imageFileInfo2.setIsGif(imageFileInfo.isGif());
                imageFileInfo2.setIsLong(imageFileInfo.isLong());
                this.hbn.a(null);
                this.hbn.addChooseFile(imageFileInfo2);
                bBn();
                return true;
            }
            return false;
        } else if (bBq()) {
            return c(imageFileInfo);
        } else {
            showToast(String.format(getPageContext().getContext().getString(d.k.album_beyond_max_choose), Integer.valueOf(maxImagesAllowed)));
            return false;
        }
    }

    public boolean bBq() {
        if (getIntent().getBooleanExtra(AlbumActivityConfig.IS_SELECT_DIRECTLY, false)) {
            int maxImagesAllowed = this.hbn.getMaxImagesAllowed();
            if (this.hbn.size() == maxImagesAllowed && maxImagesAllowed == 1) {
                try {
                    ImageFileInfo imageFileInfo = (ImageFileInfo) v.c(this.hbn.bBH(), 0);
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
        this.hbn.a(null);
        this.hbn.delChooseFile(imageFileInfo);
        bBn();
        return true;
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i == 4) {
            closeLoadingDialog();
            if (this.mCurrentPage == 0) {
                if (this.hbn != null) {
                    this.hbn.setLastAlbumId(null);
                }
                bBr();
                return true;
            } else if (this.mCurrentPage == 1) {
                uO(0);
                return true;
            } else {
                return true;
            }
        }
        return super.onKeyDown(i, keyEvent);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void f(ImageFileInfo imageFileInfo, boolean z) {
        Fragment uP;
        if (this.hbo != null && (uP = this.hbo.uP(0)) != null && (uP instanceof ImageListFragment)) {
            ((ImageListFragment) uP).h(imageFileInfo, z);
        }
    }

    void g(ImageFileInfo imageFileInfo, boolean z) {
        Fragment uP;
        if (this.hbo != null && (uP = this.hbo.uP(1)) != null && (uP instanceof AlbumImageBrowseFragment)) {
            ((AlbumImageBrowseFragment) uP).h(imageFileInfo, z);
        }
    }

    private void bBr() {
        Intent intent = new Intent();
        String lastAlbumId = this.hbn.getLastAlbumId();
        if (TextUtils.isEmpty(lastAlbumId)) {
            lastAlbumId = "";
        }
        intent.putExtra(AlbumActivityConfig.LAST_ALBUM_ID, lastAlbumId);
        intent.putExtra(AlbumActivityConfig.CAMERA_REQUEST_FROM, this.hbr);
        setResult(0, intent);
        finish();
    }

    private void stopCamera() {
        if (this.hbo != null) {
            this.hbo.stopCamera();
        }
    }

    private void bBs() {
        if (this.hbo != null) {
            this.hbo.bBs();
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
        this.hbp = true;
        stopCamera();
        closeLoadingDialog();
        dismissAllDialog();
        d.bBL().destory();
        if (this.cZg != null) {
            this.cZg.setBackgroundDrawable(null);
        }
        if (this.hbo != null) {
            this.hbo.onDestroy();
        }
        if (this.hbw != null) {
            this.hbw.onDestroy();
        }
    }

    @Override // android.support.v4.app.FragmentActivity, android.app.Activity, android.support.v4.app.ActivityCompat.OnRequestPermissionsResultCallback
    public void onRequestPermissionsResult(int i, String[] strArr, int[] iArr) {
        if (i == 1) {
            if (!ab.aD(getApplicationContext())) {
                showToast(d.k.system_permission_prompt_camera);
            }
            ArrayMap<String, Boolean> a2 = ab.a(strArr, iArr);
            if (a2.containsKey("android.permission.WRITE_EXTERNAL_STORAGE") && !a2.get("android.permission.WRITE_EXTERNAL_STORAGE").booleanValue()) {
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
            new com.baidu.tbadk.img.f(null).c(AlbumActivity.this.hbn.getWriteImagesInfo(), true);
            return AlbumActivity.this.hbn.getWriteImagesInfo().toJsonString();
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
        if (this.hbw != null) {
            this.hbw.onStart();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.adp.base.BdBaseFragmentActivity, android.support.v4.app.FragmentActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        bBs();
        if (this.hbw != null) {
            this.hbw.onResume();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.base.BdBaseFragmentActivity, android.support.v4.app.FragmentActivity, android.app.Activity
    public void onStop() {
        super.onStop();
        if (this.hbw != null) {
            this.hbw.onStop();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.adp.base.BdBaseFragmentActivity, android.support.v4.app.FragmentActivity, android.app.Activity
    public void onPause() {
        stopCamera();
        super.onPause();
    }
}
