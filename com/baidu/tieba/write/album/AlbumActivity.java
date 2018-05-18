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
    private boolean dbt;
    private com.baidu.tieba.d.c foB;
    private c hco;
    private com.baidu.tieba.write.album.a hcp;
    private e hcr;
    private i hcx;
    private int mCurrentPage = 0;
    private boolean hcq = false;
    private String callFrom = "";
    private String from = "";
    private String forumName = "";
    private String forumId = "0";
    private int hcs = 0;
    private int hct = 0;
    private boolean hcu = false;
    private boolean hcv = false;
    private int hcw = 0;
    private View dak = null;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.adp.base.BdBaseFragmentActivity, android.support.v4.app.FragmentActivity, android.support.v4.app.BaseFragmentActivityGingerbread, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setSwipeBackEnabled(false);
        setContentView(d.i.album_activity);
        this.dak = findViewById(d.g.statebar_view);
        this.dbt = UtilHelper.canUseStyleImmersiveSticky();
        Qa();
        initData(bundle);
        this.hcp = new com.baidu.tieba.write.album.a(this);
        this.hcp.aTP();
        uN(0);
    }

    public void showTip(View view2) {
        if (this.foB == null && view2 != null) {
            this.foB = new com.baidu.tieba.d.c(getPageContext(), view2);
            this.foB.jc(d.f.bg_tip_blue_up_left);
            this.foB.j(new View.OnClickListener() { // from class: com.baidu.tieba.write.album.AlbumActivity.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view3) {
                    AlbumActivity.this.foB.ahf();
                }
            });
            this.foB.jb(16);
            this.foB.jd(5000);
        }
        if (this.foB != null) {
            String sharedPrefKeyWithAccount = com.baidu.tbadk.core.sharedPref.b.getSharedPrefKeyWithAccount("key_show_take_photo_tip");
            this.foB.aJ(getString(d.k.album_take_photo_tip), sharedPrefKeyWithAccount);
        }
    }

    private void Qa() {
        if (this.dak != null) {
            if (this.dbt && this.dak.getLayoutParams() != null) {
                ViewGroup.LayoutParams layoutParams = this.dak.getLayoutParams();
                layoutParams.height = UtilHelper.getStatusBarHeight();
                this.dak.setLayoutParams(layoutParams);
                fE(true);
                return;
            }
            fE(false);
        }
    }

    private void fE(boolean z) {
        if (this.dak != null) {
            if (this.dbt && z && this.dak.getVisibility() != 0) {
                this.dak.setVisibility(0);
            } else if (!z && this.dak.getVisibility() != 8) {
                this.dak.setVisibility(8);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.support.v4.app.FragmentActivity, android.app.Activity
    public void onSaveInstanceState(Bundle bundle) {
        bundle.putString(AlbumActivityConfig.WRITE_IMAGES_INFO, this.hco.getWriteImagesInfo().toJsonString());
        bundle.putBoolean(AlbumActivityConfig.USE_ORIGINAL_IMG, this.hcu);
        bundle.putInt(AlbumActivityConfig.CAMERA_REQUEST_FROM, this.hcs);
        bundle.putString("forum_id", this.forumId);
        bundle.putString("forum_name", this.forumName);
        bundle.putInt(IntentConfig.KEY_ALBUM_THREAD, this.hct);
        bundle.putBoolean(IntentConfig.KEY_FROM_WRITEACTIVITY, this.hcv);
    }

    private void initData(Bundle bundle) {
        this.hco = new c(this);
        if (bundle != null) {
            WriteImagesInfo writeImagesInfo = new WriteImagesInfo();
            writeImagesInfo.parseJson(bundle.getString(AlbumActivityConfig.WRITE_IMAGES_INFO));
            this.hco.setWriteImagesInfo(writeImagesInfo);
            this.hcu = bundle.getBoolean(AlbumActivityConfig.USE_ORIGINAL_IMG, false);
            this.hcs = bundle.getInt(AlbumActivityConfig.CAMERA_REQUEST_FROM, 0);
            this.forumId = bundle.getString("forum_id");
            this.forumName = bundle.getString("forum_name");
            this.hct = bundle.getInt(IntentConfig.KEY_ALBUM_THREAD);
            this.hcv = bundle.getBoolean(IntentConfig.KEY_FROM_WRITEACTIVITY);
            this.callFrom = bundle.getString("KEY_CALL_FROM");
            this.hcw = bundle.getInt("from_type");
        } else {
            Intent intent = getIntent();
            if (intent != null) {
                WriteImagesInfo writeImagesInfo2 = new WriteImagesInfo();
                writeImagesInfo2.parseJson(intent.getStringExtra(AlbumActivityConfig.WRITE_IMAGES_INFO));
                this.hco.setWriteImagesInfo(writeImagesInfo2);
                this.hco.setOriginalImg(writeImagesInfo2.isOriginalImg());
                this.hcu = intent.getBooleanExtra(AlbumActivityConfig.USE_ORIGINAL_IMG, false);
                this.hcs = intent.getIntExtra(AlbumActivityConfig.CAMERA_REQUEST_FROM, 0);
                this.from = intent.getStringExtra("from");
                this.forumId = intent.getStringExtra("forum_id");
                this.forumName = intent.getStringExtra("forum_name");
                this.hct = intent.getIntExtra(IntentConfig.KEY_ALBUM_THREAD, 0);
                this.hcv = intent.getBooleanExtra(IntentConfig.KEY_FROM_WRITEACTIVITY, false);
                this.callFrom = intent.getStringExtra("KEY_CALL_FROM");
                this.hcw = intent.getIntExtra("from_type", 0);
            }
        }
        bBi();
    }

    private void bBi() {
        if (this.hcs == 2) {
            this.hcr = new e() { // from class: com.baidu.tieba.write.album.AlbumActivity.2
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
        if (this.hcp != null) {
            this.hcp.onChangeSkinType(i);
        }
        ak.e(this.dak, d.C0126d.cp_bg_line_d, i);
    }

    public void bBj() {
        if (this.hcs == 3) {
            TiebaStatic.log("c10489");
        }
        if (this.hcs == 5) {
            showLoadingDialog("正在上传");
            new a().execute(new String[0]);
        } else if (this.hco != null) {
            if (this.hcx == null || !this.hcx.bBW()) {
                if (this.hco.bBD()) {
                    VideoFileInfo bBB = this.hco.bBB();
                    if (this.hcx == null) {
                        this.hcx = new i(this, this.forumName, this.forumId, "");
                        if (this.hcp != null) {
                            this.hcp.a(this.hcx);
                        }
                    }
                    this.hcx.a(bBB, this.callFrom);
                } else if (v.v(this.hco.bBF()) == 1 && this.hcw == 0) {
                    bBk();
                } else {
                    ab(null);
                }
            }
        }
    }

    private void ab(Intent intent) {
        Intent intent2 = new Intent();
        intent2.putExtra(AlbumActivityConfig.ALBUM_RESULT, this.hco.getWriteImagesInfo().toJsonString());
        intent2.putExtra(AlbumActivityConfig.CAMERA_REQUEST_FROM, this.hcs);
        intent2.putExtra("from_type", this.hcw);
        if (intent != null && !StringUtils.isNull(intent.getStringExtra("file_name"))) {
            intent2.putExtra("file_name", intent.getStringExtra("file_name"));
        }
        setResult(-1, intent2);
        finish();
    }

    private boolean Xp() {
        Activity pageActivity = getPageContext().getPageActivity();
        com.baidu.tbadk.core.util.b.a aVar = new com.baidu.tbadk.core.util.b.a();
        aVar.wt();
        aVar.c(pageActivity, "android.permission.CAMERA");
        aVar.c(pageActivity, "android.permission.RECORD_AUDIO");
        aVar.c(pageActivity, "android.permission.WRITE_EXTERNAL_STORAGE");
        return aVar.v(pageActivity);
    }

    public void b(TbPageContext tbPageContext) {
        if (!Xp() && com.baidu.tieba.write.e.bBc()) {
            sendMessage(new CustomMessage(2002001, new RecordVideoActivityConfig(tbPageContext.getPageActivity(), this.hcv ? 2 : 3, new ForumWriteData(this.forumId, this.forumName, null, null), this.hco.getWriteImagesInfo(), "", this.hcw)));
            TiebaStatic.log(new al("c12611").r("obj_locate", 5).r("obj_type", 2));
        }
    }

    private void bBk() {
        WriteImagesInfo writeImagesInfo;
        if (this.hco != null && (writeImagesInfo = this.hco.getWriteImagesInfo()) != null) {
            sendMessage(new CustomMessage(2002001, new WriteMulitImageActivityConfig(getPageContext().getPageActivity(), IEventCenterService.EventId.EventMode.SAPIACCOUNT_THROUGH_SERVER, writeImagesInfo, 0)));
        }
    }

    private void ac(Intent intent) {
        if (intent == null || this.hco == null) {
            ab(null);
            return;
        }
        String stringExtra = intent.getStringExtra(AlbumActivityConfig.ALBUM_RESULT);
        if (stringExtra != null) {
            WriteImagesInfo writeImagesInfo = this.hco.getWriteImagesInfo();
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
        if (view2 == this.hcp.bBt()) {
            bBj();
        } else if (view2 == this.hcp.bBv()) {
            bBj();
        } else if (view2 == this.hcp.bBs()) {
            if (this.hco != null) {
                this.hco.setLastAlbumId(null);
            }
            bBp();
        } else if (view2 == this.hcp.bBu()) {
            uN(0);
        } else if (view2 == this.hcp.bBw()) {
            uL(2);
        } else if (view2 == this.hcp.bBx()) {
            uL(1);
        }
    }

    private void uL(int i) {
        if (this.hcp != null && this.hco != null) {
            this.hco.setOriginalImg(!this.hco.isOriginalImg());
            bBl();
            uM(i);
        }
    }

    private void uM(int i) {
        if (this.hco != null && this.hco.isOriginalImg() && !StringUtils.isNull(this.from, true) && !StringUtils.isNull(this.forumId, true)) {
            TiebaStatic.log(new al("c10349").ac(ImageViewerConfig.FORUM_ID, this.forumId).ac("obj_type", this.from).r("obj_locate", i));
        }
    }

    public void bBl() {
        if (this.hco != null && this.hcp != null) {
            this.hcp.no(this.hco.isOriginalImg());
        }
    }

    public View apP() {
        return this.dak;
    }

    public int bBm() {
        return this.hct;
    }

    public c bBn() {
        return this.hco;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void uN(int i) {
        if (!this.hcq) {
            FragmentTransaction beginTransaction = getSupportFragmentManager().beginTransaction();
            Fragment findFragmentByTag = getSupportFragmentManager().findFragmentByTag(this.hcp.uP(this.mCurrentPage));
            if (findFragmentByTag != null) {
                beginTransaction.hide(findFragmentByTag);
            }
            this.mCurrentPage = i;
            if (getSupportFragmentManager().findFragmentByTag(this.hcp.uP(i)) != null) {
                beginTransaction.show(this.hcp.uO(i));
            } else {
                beginTransaction.add(d.g.fragment, this.hcp.uO(i), this.hcp.uP(i));
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
        int maxImagesAllowed = this.hco.getMaxImagesAllowed();
        if (this.hco.size() < maxImagesAllowed) {
            if (this.hcr == null || this.hcr.e(imageFileInfo)) {
                ImageFileInfo imageFileInfo2 = new ImageFileInfo();
                imageFileInfo2.setAlbumnId(imageFileInfo.getAlbumId());
                imageFileInfo2.setFilePath(imageFileInfo.getFilePath());
                imageFileInfo2.setModifyTime(imageFileInfo.getModifyTime());
                imageFileInfo2.setIsGif(imageFileInfo.isGif());
                imageFileInfo2.setIsLong(imageFileInfo.isLong());
                this.hco.a(null);
                this.hco.addChooseFile(imageFileInfo2);
                bBl();
                return true;
            }
            return false;
        } else if (bBo()) {
            return c(imageFileInfo);
        } else {
            showToast(String.format(getPageContext().getContext().getString(d.k.album_beyond_max_choose), Integer.valueOf(maxImagesAllowed)));
            return false;
        }
    }

    public boolean bBo() {
        if (getIntent().getBooleanExtra(AlbumActivityConfig.IS_SELECT_DIRECTLY, false)) {
            int maxImagesAllowed = this.hco.getMaxImagesAllowed();
            if (this.hco.size() == maxImagesAllowed && maxImagesAllowed == 1) {
                try {
                    ImageFileInfo imageFileInfo = (ImageFileInfo) v.c(this.hco.bBF(), 0);
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
        this.hco.a(null);
        this.hco.delChooseFile(imageFileInfo);
        bBl();
        return true;
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i == 4) {
            closeLoadingDialog();
            if (this.mCurrentPage == 0) {
                if (this.hco != null) {
                    this.hco.setLastAlbumId(null);
                }
                bBp();
                return true;
            } else if (this.mCurrentPage == 1) {
                uN(0);
                return true;
            } else {
                return true;
            }
        }
        return super.onKeyDown(i, keyEvent);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void f(ImageFileInfo imageFileInfo, boolean z) {
        Fragment uO;
        if (this.hcp != null && (uO = this.hcp.uO(0)) != null && (uO instanceof ImageListFragment)) {
            ((ImageListFragment) uO).h(imageFileInfo, z);
        }
    }

    void g(ImageFileInfo imageFileInfo, boolean z) {
        Fragment uO;
        if (this.hcp != null && (uO = this.hcp.uO(1)) != null && (uO instanceof AlbumImageBrowseFragment)) {
            ((AlbumImageBrowseFragment) uO).h(imageFileInfo, z);
        }
    }

    private void bBp() {
        Intent intent = new Intent();
        String lastAlbumId = this.hco.getLastAlbumId();
        if (TextUtils.isEmpty(lastAlbumId)) {
            lastAlbumId = "";
        }
        intent.putExtra(AlbumActivityConfig.LAST_ALBUM_ID, lastAlbumId);
        intent.putExtra(AlbumActivityConfig.CAMERA_REQUEST_FROM, this.hcs);
        setResult(0, intent);
        finish();
    }

    private void stopCamera() {
        if (this.hcp != null) {
            this.hcp.stopCamera();
        }
    }

    private void bBq() {
        if (this.hcp != null) {
            this.hcp.bBq();
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
        this.hcq = true;
        stopCamera();
        closeLoadingDialog();
        dismissAllDialog();
        d.bBJ().destory();
        if (this.dak != null) {
            this.dak.setBackgroundDrawable(null);
        }
        if (this.hcp != null) {
            this.hcp.onDestroy();
        }
        if (this.hcx != null) {
            this.hcx.onDestroy();
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
            new com.baidu.tbadk.img.f(null).c(AlbumActivity.this.hco.getWriteImagesInfo(), true);
            return AlbumActivity.this.hco.getWriteImagesInfo().toJsonString();
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
        if (this.hcx != null) {
            this.hcx.onStart();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.adp.base.BdBaseFragmentActivity, android.support.v4.app.FragmentActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        bBq();
        if (this.hcx != null) {
            this.hcx.onResume();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.base.BdBaseFragmentActivity, android.support.v4.app.FragmentActivity, android.app.Activity
    public void onStop() {
        super.onStop();
        if (this.hcx != null) {
            this.hcx.onStop();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.adp.base.BdBaseFragmentActivity, android.support.v4.app.FragmentActivity, android.app.Activity
    public void onPause() {
        stopCamera();
        super.onPause();
    }
}
