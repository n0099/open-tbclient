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
    private boolean dak;
    private com.baidu.tieba.d.c fnt;
    private c hbk;
    private com.baidu.tieba.write.album.a hbl;
    private e hbn;
    private i hbt;
    private int mCurrentPage = 0;
    private boolean hbm = false;
    private String callFrom = "";
    private String from = "";
    private String forumName = "";
    private String forumId = "0";
    private int hbo = 0;
    private int hbp = 0;
    private boolean hbq = false;
    private boolean hbr = false;
    private int hbs = 0;
    private View cZd = null;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.adp.base.BdBaseFragmentActivity, android.support.v4.app.FragmentActivity, android.support.v4.app.BaseFragmentActivityGingerbread, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setSwipeBackEnabled(false);
        setContentView(d.i.album_activity);
        this.cZd = findViewById(d.g.statebar_view);
        this.dak = UtilHelper.canUseStyleImmersiveSticky();
        Qd();
        initData(bundle);
        this.hbl = new com.baidu.tieba.write.album.a(this);
        this.hbl.aTP();
        uO(0);
    }

    public void showTip(View view2) {
        if (this.fnt == null && view2 != null) {
            this.fnt = new com.baidu.tieba.d.c(getPageContext(), view2);
            this.fnt.jd(d.f.bg_tip_blue_up_left);
            this.fnt.j(new View.OnClickListener() { // from class: com.baidu.tieba.write.album.AlbumActivity.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view3) {
                    AlbumActivity.this.fnt.ahf();
                }
            });
            this.fnt.jc(16);
            this.fnt.je(5000);
        }
        if (this.fnt != null) {
            String sharedPrefKeyWithAccount = com.baidu.tbadk.core.sharedPref.b.getSharedPrefKeyWithAccount("key_show_take_photo_tip");
            this.fnt.aJ(getString(d.k.album_take_photo_tip), sharedPrefKeyWithAccount);
        }
    }

    private void Qd() {
        if (this.cZd != null) {
            if (this.dak && this.cZd.getLayoutParams() != null) {
                ViewGroup.LayoutParams layoutParams = this.cZd.getLayoutParams();
                layoutParams.height = UtilHelper.getStatusBarHeight();
                this.cZd.setLayoutParams(layoutParams);
                fD(true);
                return;
            }
            fD(false);
        }
    }

    private void fD(boolean z) {
        if (this.cZd != null) {
            if (this.dak && z && this.cZd.getVisibility() != 0) {
                this.cZd.setVisibility(0);
            } else if (!z && this.cZd.getVisibility() != 8) {
                this.cZd.setVisibility(8);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.support.v4.app.FragmentActivity, android.app.Activity
    public void onSaveInstanceState(Bundle bundle) {
        bundle.putString(AlbumActivityConfig.WRITE_IMAGES_INFO, this.hbk.getWriteImagesInfo().toJsonString());
        bundle.putBoolean(AlbumActivityConfig.USE_ORIGINAL_IMG, this.hbq);
        bundle.putInt(AlbumActivityConfig.CAMERA_REQUEST_FROM, this.hbo);
        bundle.putString("forum_id", this.forumId);
        bundle.putString("forum_name", this.forumName);
        bundle.putInt(IntentConfig.KEY_ALBUM_THREAD, this.hbp);
        bundle.putBoolean(IntentConfig.KEY_FROM_WRITEACTIVITY, this.hbr);
    }

    private void initData(Bundle bundle) {
        this.hbk = new c(this);
        if (bundle != null) {
            WriteImagesInfo writeImagesInfo = new WriteImagesInfo();
            writeImagesInfo.parseJson(bundle.getString(AlbumActivityConfig.WRITE_IMAGES_INFO));
            this.hbk.setWriteImagesInfo(writeImagesInfo);
            this.hbq = bundle.getBoolean(AlbumActivityConfig.USE_ORIGINAL_IMG, false);
            this.hbo = bundle.getInt(AlbumActivityConfig.CAMERA_REQUEST_FROM, 0);
            this.forumId = bundle.getString("forum_id");
            this.forumName = bundle.getString("forum_name");
            this.hbp = bundle.getInt(IntentConfig.KEY_ALBUM_THREAD);
            this.hbr = bundle.getBoolean(IntentConfig.KEY_FROM_WRITEACTIVITY);
            this.callFrom = bundle.getString("KEY_CALL_FROM");
            this.hbs = bundle.getInt("from_type");
        } else {
            Intent intent = getIntent();
            if (intent != null) {
                WriteImagesInfo writeImagesInfo2 = new WriteImagesInfo();
                writeImagesInfo2.parseJson(intent.getStringExtra(AlbumActivityConfig.WRITE_IMAGES_INFO));
                this.hbk.setWriteImagesInfo(writeImagesInfo2);
                this.hbk.setOriginalImg(writeImagesInfo2.isOriginalImg());
                this.hbq = intent.getBooleanExtra(AlbumActivityConfig.USE_ORIGINAL_IMG, false);
                this.hbo = intent.getIntExtra(AlbumActivityConfig.CAMERA_REQUEST_FROM, 0);
                this.from = intent.getStringExtra("from");
                this.forumId = intent.getStringExtra("forum_id");
                this.forumName = intent.getStringExtra("forum_name");
                this.hbp = intent.getIntExtra(IntentConfig.KEY_ALBUM_THREAD, 0);
                this.hbr = intent.getBooleanExtra(IntentConfig.KEY_FROM_WRITEACTIVITY, false);
                this.callFrom = intent.getStringExtra("KEY_CALL_FROM");
                this.hbs = intent.getIntExtra("from_type", 0);
            }
        }
        bBk();
    }

    private void bBk() {
        if (this.hbo == 2) {
            this.hbn = new e() { // from class: com.baidu.tieba.write.album.AlbumActivity.2
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
        if (this.hbl != null) {
            this.hbl.onChangeSkinType(i);
        }
        ak.e(this.cZd, d.C0126d.cp_bg_line_d, i);
    }

    public void bBl() {
        if (this.hbo == 3) {
            TiebaStatic.log("c10489");
        }
        if (this.hbo == 5) {
            showLoadingDialog("正在上传");
            new a().execute(new String[0]);
        } else if (this.hbk != null) {
            if (this.hbt == null || !this.hbt.bBY()) {
                if (this.hbk.bBF()) {
                    VideoFileInfo bBD = this.hbk.bBD();
                    if (this.hbt == null) {
                        this.hbt = new i(this, this.forumName, this.forumId, "");
                        if (this.hbl != null) {
                            this.hbl.a(this.hbt);
                        }
                    }
                    this.hbt.a(bBD, this.callFrom);
                } else if (v.v(this.hbk.bBH()) == 1 && this.hbs == 0) {
                    bBm();
                } else {
                    ab(null);
                }
            }
        }
    }

    private void ab(Intent intent) {
        Intent intent2 = new Intent();
        intent2.putExtra(AlbumActivityConfig.ALBUM_RESULT, this.hbk.getWriteImagesInfo().toJsonString());
        intent2.putExtra(AlbumActivityConfig.CAMERA_REQUEST_FROM, this.hbo);
        intent2.putExtra("from_type", this.hbs);
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
            sendMessage(new CustomMessage(2002001, new RecordVideoActivityConfig(tbPageContext.getPageActivity(), this.hbr ? 2 : 3, new ForumWriteData(this.forumId, this.forumName, null, null), this.hbk.getWriteImagesInfo(), "", this.hbs)));
            TiebaStatic.log(new al("c12611").r("obj_locate", 5).r("obj_type", 2));
        }
    }

    private void bBm() {
        WriteImagesInfo writeImagesInfo;
        if (this.hbk != null && (writeImagesInfo = this.hbk.getWriteImagesInfo()) != null) {
            sendMessage(new CustomMessage(2002001, new WriteMulitImageActivityConfig(getPageContext().getPageActivity(), IEventCenterService.EventId.EventMode.SAPIACCOUNT_THROUGH_SERVER, writeImagesInfo, 0)));
        }
    }

    private void ac(Intent intent) {
        if (intent == null || this.hbk == null) {
            ab(null);
            return;
        }
        String stringExtra = intent.getStringExtra(AlbumActivityConfig.ALBUM_RESULT);
        if (stringExtra != null) {
            WriteImagesInfo writeImagesInfo = this.hbk.getWriteImagesInfo();
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
        if (view2 == this.hbl.bBv()) {
            bBl();
        } else if (view2 == this.hbl.bBx()) {
            bBl();
        } else if (view2 == this.hbl.bBu()) {
            if (this.hbk != null) {
                this.hbk.setLastAlbumId(null);
            }
            bBr();
        } else if (view2 == this.hbl.bBw()) {
            uO(0);
        } else if (view2 == this.hbl.bBy()) {
            uM(2);
        } else if (view2 == this.hbl.bBz()) {
            uM(1);
        }
    }

    private void uM(int i) {
        if (this.hbl != null && this.hbk != null) {
            this.hbk.setOriginalImg(!this.hbk.isOriginalImg());
            bBn();
            uN(i);
        }
    }

    private void uN(int i) {
        if (this.hbk != null && this.hbk.isOriginalImg() && !StringUtils.isNull(this.from, true) && !StringUtils.isNull(this.forumId, true)) {
            TiebaStatic.log(new al("c10349").ac(ImageViewerConfig.FORUM_ID, this.forumId).ac("obj_type", this.from).r("obj_locate", i));
        }
    }

    public void bBn() {
        if (this.hbk != null && this.hbl != null) {
            this.hbl.nn(this.hbk.isOriginalImg());
        }
    }

    public View apQ() {
        return this.cZd;
    }

    public int bBo() {
        return this.hbp;
    }

    public c bBp() {
        return this.hbk;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void uO(int i) {
        if (!this.hbm) {
            FragmentTransaction beginTransaction = getSupportFragmentManager().beginTransaction();
            Fragment findFragmentByTag = getSupportFragmentManager().findFragmentByTag(this.hbl.uQ(this.mCurrentPage));
            if (findFragmentByTag != null) {
                beginTransaction.hide(findFragmentByTag);
            }
            this.mCurrentPage = i;
            if (getSupportFragmentManager().findFragmentByTag(this.hbl.uQ(i)) != null) {
                beginTransaction.show(this.hbl.uP(i));
            } else {
                beginTransaction.add(d.g.fragment, this.hbl.uP(i), this.hbl.uQ(i));
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
        int maxImagesAllowed = this.hbk.getMaxImagesAllowed();
        if (this.hbk.size() < maxImagesAllowed) {
            if (this.hbn == null || this.hbn.e(imageFileInfo)) {
                ImageFileInfo imageFileInfo2 = new ImageFileInfo();
                imageFileInfo2.setAlbumnId(imageFileInfo.getAlbumId());
                imageFileInfo2.setFilePath(imageFileInfo.getFilePath());
                imageFileInfo2.setModifyTime(imageFileInfo.getModifyTime());
                imageFileInfo2.setIsGif(imageFileInfo.isGif());
                imageFileInfo2.setIsLong(imageFileInfo.isLong());
                this.hbk.a(null);
                this.hbk.addChooseFile(imageFileInfo2);
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
            int maxImagesAllowed = this.hbk.getMaxImagesAllowed();
            if (this.hbk.size() == maxImagesAllowed && maxImagesAllowed == 1) {
                try {
                    ImageFileInfo imageFileInfo = (ImageFileInfo) v.c(this.hbk.bBH(), 0);
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
        this.hbk.a(null);
        this.hbk.delChooseFile(imageFileInfo);
        bBn();
        return true;
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i == 4) {
            closeLoadingDialog();
            if (this.mCurrentPage == 0) {
                if (this.hbk != null) {
                    this.hbk.setLastAlbumId(null);
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
        if (this.hbl != null && (uP = this.hbl.uP(0)) != null && (uP instanceof ImageListFragment)) {
            ((ImageListFragment) uP).h(imageFileInfo, z);
        }
    }

    void g(ImageFileInfo imageFileInfo, boolean z) {
        Fragment uP;
        if (this.hbl != null && (uP = this.hbl.uP(1)) != null && (uP instanceof AlbumImageBrowseFragment)) {
            ((AlbumImageBrowseFragment) uP).h(imageFileInfo, z);
        }
    }

    private void bBr() {
        Intent intent = new Intent();
        String lastAlbumId = this.hbk.getLastAlbumId();
        if (TextUtils.isEmpty(lastAlbumId)) {
            lastAlbumId = "";
        }
        intent.putExtra(AlbumActivityConfig.LAST_ALBUM_ID, lastAlbumId);
        intent.putExtra(AlbumActivityConfig.CAMERA_REQUEST_FROM, this.hbo);
        setResult(0, intent);
        finish();
    }

    private void stopCamera() {
        if (this.hbl != null) {
            this.hbl.stopCamera();
        }
    }

    private void bBs() {
        if (this.hbl != null) {
            this.hbl.bBs();
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
        this.hbm = true;
        stopCamera();
        closeLoadingDialog();
        dismissAllDialog();
        d.bBL().destory();
        if (this.cZd != null) {
            this.cZd.setBackgroundDrawable(null);
        }
        if (this.hbl != null) {
            this.hbl.onDestroy();
        }
        if (this.hbt != null) {
            this.hbt.onDestroy();
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
            new com.baidu.tbadk.img.f(null).c(AlbumActivity.this.hbk.getWriteImagesInfo(), true);
            return AlbumActivity.this.hbk.getWriteImagesInfo().toJsonString();
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
        if (this.hbt != null) {
            this.hbt.onStart();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.adp.base.BdBaseFragmentActivity, android.support.v4.app.FragmentActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        bBs();
        if (this.hbt != null) {
            this.hbt.onResume();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.base.BdBaseFragmentActivity, android.support.v4.app.FragmentActivity, android.app.Activity
    public void onStop() {
        super.onStop();
        if (this.hbt != null) {
            this.hbt.onStop();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.adp.base.BdBaseFragmentActivity, android.support.v4.app.FragmentActivity, android.app.Activity
    public void onPause() {
        stopCamera();
        super.onPause();
    }
}
