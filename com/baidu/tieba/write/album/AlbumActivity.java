package com.baidu.tieba.write.album;

import android.app.Activity;
import android.content.Intent;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.e.a.a;
import com.baidu.sapi2.passhost.pluginsdk.service.IEventCenterService;
import com.baidu.tbadk.ActivityPendingTransitionFactory;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.album.VideoFileInfo;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.AlbumActivityConfig;
import com.baidu.tbadk.core.atomData.ImageViewerConfig;
import com.baidu.tbadk.core.atomData.RecordVideoActivityConfig;
import com.baidu.tbadk.core.atomData.WriteMulitImageActivityConfig;
import com.baidu.tbadk.core.frameworkData.IntentConfig;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.al;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.v;
import com.baidu.tbadk.img.ImageFileInfo;
import com.baidu.tbadk.img.WriteImagesInfo;
import com.baidu.tieba.d;
import com.baidu.tieba.frs.ForumWriteData;
/* loaded from: classes3.dex */
public class AlbumActivity extends BaseFragmentActivity implements View.OnClickListener, a.InterfaceC0040a {
    private boolean fcW;
    private com.baidu.tieba.c.d hvI;
    private c jmR;
    private com.baidu.tieba.write.album.a jmS;
    private e jmU;
    private Intent jmY;
    private i jnb;
    private int mCurrentPage = 0;
    private boolean jmT = false;
    private String callFrom = "";
    private String from = "";
    private String forumName = "";
    private String forumId = "0";
    private int jmV = 0;
    private int jmW = 0;
    private boolean jmX = false;
    private boolean jmZ = false;
    private int jna = 0;
    private View fbm = null;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.adp.base.BdBaseFragmentActivity, android.support.v4.app.FragmentActivity, android.support.v4.app.SupportActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setSwipeBackEnabled(false);
        setContentView(d.h.album_activity);
        this.fbm = findViewById(d.g.statebar_view);
        this.fcW = UtilHelper.canUseStyleImmersiveSticky();
        aCn();
        initData(bundle);
        this.jmS = new com.baidu.tieba.write.album.a(this);
        this.jmS.bjS();
        Be(0);
    }

    public void showTip(View view) {
        if (this.hvI == null && view != null) {
            this.hvI = new com.baidu.tieba.c.d(getPageContext(), view);
            this.hvI.oK(d.f.bg_tip_blue_up_left);
            this.hvI.o(new View.OnClickListener() { // from class: com.baidu.tieba.write.album.AlbumActivity.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    AlbumActivity.this.hvI.aSs();
                }
            });
            this.hvI.oJ(16);
            this.hvI.oL(5000);
        }
        if (this.hvI != null) {
            String sharedPrefKeyWithAccount = com.baidu.tbadk.core.sharedPref.b.getSharedPrefKeyWithAccount("key_show_take_photo_tip");
            this.hvI.cu(getString(d.j.album_take_photo_tip), sharedPrefKeyWithAccount);
        }
    }

    private void aCn() {
        if (this.fbm != null) {
            if (this.fcW && this.fbm.getLayoutParams() != null) {
                ViewGroup.LayoutParams layoutParams = this.fbm.getLayoutParams();
                layoutParams.height = UtilHelper.getStatusBarHeight();
                this.fbm.setLayoutParams(layoutParams);
                jt(true);
                return;
            }
            jt(false);
        }
    }

    private void jt(boolean z) {
        if (this.fbm != null) {
            if (this.fcW && z && this.fbm.getVisibility() != 0) {
                this.fbm.setVisibility(0);
            } else if (!z && this.fbm.getVisibility() != 8) {
                this.fbm.setVisibility(8);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.support.v4.app.FragmentActivity, android.support.v4.app.SupportActivity, android.app.Activity
    public void onSaveInstanceState(Bundle bundle) {
        bundle.putString(AlbumActivityConfig.WRITE_IMAGES_INFO, this.jmR.getWriteImagesInfo().toJsonString());
        bundle.putBoolean(AlbumActivityConfig.USE_ORIGINAL_IMG, this.jmX);
        bundle.putInt(AlbumActivityConfig.CAMERA_REQUEST_FROM, this.jmV);
        bundle.putString("forum_id", this.forumId);
        bundle.putString("forum_name", this.forumName);
        bundle.putInt(IntentConfig.KEY_ALBUM_THREAD, this.jmW);
        bundle.putBoolean(IntentConfig.KEY_FROM_WRITEACTIVITY, this.jmZ);
    }

    private void initData(Bundle bundle) {
        this.jmR = new c(this);
        if (bundle != null) {
            WriteImagesInfo writeImagesInfo = new WriteImagesInfo();
            writeImagesInfo.parseJson(bundle.getString(AlbumActivityConfig.WRITE_IMAGES_INFO));
            this.jmR.setWriteImagesInfo(writeImagesInfo);
            this.jmX = bundle.getBoolean(AlbumActivityConfig.USE_ORIGINAL_IMG, false);
            this.jmV = bundle.getInt(AlbumActivityConfig.CAMERA_REQUEST_FROM, 0);
            this.forumId = bundle.getString("forum_id");
            this.forumName = bundle.getString("forum_name");
            this.jmW = bundle.getInt(IntentConfig.KEY_ALBUM_THREAD);
            this.jmZ = bundle.getBoolean(IntentConfig.KEY_FROM_WRITEACTIVITY);
            this.callFrom = bundle.getString("KEY_CALL_FROM");
            this.jna = bundle.getInt("from_type");
        } else {
            Intent intent = getIntent();
            if (intent != null) {
                WriteImagesInfo writeImagesInfo2 = new WriteImagesInfo();
                writeImagesInfo2.parseJson(intent.getStringExtra(AlbumActivityConfig.WRITE_IMAGES_INFO));
                this.jmR.setWriteImagesInfo(writeImagesInfo2);
                this.jmR.setOriginalImg(writeImagesInfo2.isOriginalImg());
                this.jmX = intent.getBooleanExtra(AlbumActivityConfig.USE_ORIGINAL_IMG, false);
                this.jmV = intent.getIntExtra(AlbumActivityConfig.CAMERA_REQUEST_FROM, 0);
                this.from = intent.getStringExtra("from");
                this.forumId = intent.getStringExtra("forum_id");
                this.forumName = intent.getStringExtra("forum_name");
                this.jmW = intent.getIntExtra(IntentConfig.KEY_ALBUM_THREAD, 0);
                this.jmZ = intent.getBooleanExtra(IntentConfig.KEY_FROM_WRITEACTIVITY, false);
                this.callFrom = intent.getStringExtra("KEY_CALL_FROM");
                this.jna = intent.getIntExtra("from_type", 0);
            }
        }
        coy();
    }

    private void coy() {
        if (this.jmV == 2) {
            this.jmU = new e() { // from class: com.baidu.tieba.write.album.AlbumActivity.2
                @Override // com.baidu.tieba.write.album.e
                public boolean f(ImageFileInfo imageFileInfo) {
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
        if (this.jmS != null) {
            this.jmS.onChangeSkinType(i);
        }
        al.f(this.fbm, d.C0236d.cp_bg_line_d, i);
    }

    public void coz() {
        if (this.jmV == 3) {
            TiebaStatic.log("c10489");
        }
        if (this.jmV == 5) {
            showLoadingDialog("正在上传");
            new a().execute(new String[0]);
        } else if (this.jmR != null) {
            if (this.jnb == null || !this.jnb.cpo()) {
                if (this.jmR.coV()) {
                    VideoFileInfo coT = this.jmR.coT();
                    if (this.jnb == null) {
                        this.jnb = new i(this, this.forumName, this.forumId, "");
                        if (this.jmS != null) {
                            this.jmS.a(this.jnb);
                        }
                    }
                    this.jnb.a(coT, this.callFrom);
                } else if (coA()) {
                    coB();
                } else {
                    aw(null);
                }
            }
        }
    }

    private boolean coA() {
        if (this.jmR == null || v.S(this.jmR.coX()) == 0) {
            return false;
        }
        int i = 0;
        for (ImageFileInfo imageFileInfo : this.jmR.coX()) {
            if (imageFileInfo != null && imageFileInfo.getImageType() == 0 && (i = i + 1) >= 2) {
                return false;
            }
            i = i;
        }
        return i == 1;
    }

    private void aw(Intent intent) {
        Intent intent2 = new Intent();
        intent2.putExtra(AlbumActivityConfig.ALBUM_RESULT, this.jmR.getWriteImagesInfo().toJsonString());
        intent2.putExtra(AlbumActivityConfig.CAMERA_REQUEST_FROM, this.jmV);
        intent2.putExtra("from_type", this.jna);
        if (intent != null && !StringUtils.isNull(intent.getStringExtra("file_name"))) {
            intent2.putExtra("file_name", intent.getStringExtra("file_name"));
        }
        setResult(-1, intent2);
        finish();
    }

    private boolean aJu() {
        Activity pageActivity = getPageContext().getPageActivity();
        com.baidu.tbadk.core.util.b.a aVar = new com.baidu.tbadk.core.util.b.a();
        aVar.adQ();
        aVar.e(pageActivity, "android.permission.CAMERA");
        aVar.e(pageActivity, "android.permission.RECORD_AUDIO");
        aVar.e(pageActivity, "android.permission.WRITE_EXTERNAL_STORAGE");
        return aVar.Y(pageActivity);
    }

    public void c(TbPageContext tbPageContext) {
        if (!aJu() && com.baidu.tieba.write.i.cos()) {
            sendMessage(new CustomMessage(2002001, new RecordVideoActivityConfig(tbPageContext.getPageActivity(), this.jmZ ? 2 : 3, new ForumWriteData(this.forumId, this.forumName, null, null), this.jmR.getWriteImagesInfo(), "", this.jna)));
            TiebaStatic.log(new am("c12611").T("obj_locate", 5).T("obj_type", 2));
        }
    }

    private void coB() {
        WriteImagesInfo writeImagesInfo;
        if (this.jmR != null && (writeImagesInfo = this.jmR.getWriteImagesInfo()) != null) {
            sendMessage(new CustomMessage(2002001, new WriteMulitImageActivityConfig(getPageContext().getPageActivity(), IEventCenterService.EventId.EventMode.SAPIACCOUNT_THROUGH_SERVER, writeImagesInfo, coC())));
        }
    }

    private int coC() {
        if (this.jmR == null || v.S(this.jmR.coX()) == 0) {
            return 0;
        }
        for (int i = 0; i < v.S(this.jmR.coX()); i++) {
            ImageFileInfo imageFileInfo = this.jmR.coX().get(i);
            if (imageFileInfo != null && imageFileInfo.getImageType() == 0) {
                return i;
            }
        }
        return 0;
    }

    private void ax(Intent intent) {
        this.jmY = intent;
        if (intent == null || this.jmR == null) {
            aw(null);
            return;
        }
        String stringExtra = intent.getStringExtra(AlbumActivityConfig.ALBUM_RESULT);
        if (stringExtra != null) {
            WriteImagesInfo writeImagesInfo = this.jmR.getWriteImagesInfo();
            writeImagesInfo.parseJson(stringExtra);
            writeImagesInfo.updateQuality();
            aw(intent);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragmentActivity, android.support.v4.app.FragmentActivity, android.app.Activity
    public void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (i2 == -1) {
            ax(intent);
        }
    }

    @Override // com.baidu.adp.base.BdBaseFragmentActivity, android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.jmS.coL()) {
            coz();
        } else if (view == this.jmS.coN()) {
            coz();
        } else if (view == this.jmS.coK()) {
            if (this.jmR != null) {
                this.jmR.setLastAlbumId(null);
            }
            coH();
        } else if (view == this.jmS.coM()) {
            Be(0);
        } else if (view == this.jmS.coO()) {
            Bc(2);
        } else if (view == this.jmS.coP()) {
            Bc(1);
        }
    }

    private void Bc(int i) {
        if (this.jmS != null && this.jmR != null) {
            this.jmR.setOriginalImg(!this.jmR.isOriginalImg());
            coD();
            Bd(i);
        }
    }

    private void Bd(int i) {
        if (this.jmR != null && this.jmR.isOriginalImg() && !StringUtils.isNull(this.from, true) && !StringUtils.isNull(this.forumId, true)) {
            TiebaStatic.log(new am("c10349").bJ(ImageViewerConfig.FORUM_ID, this.forumId).bJ("obj_type", this.from).T("obj_locate", i));
        }
    }

    public void coD() {
        if (this.jmR != null && this.jmS != null) {
            this.jmS.qZ(this.jmR.isOriginalImg());
        }
    }

    public View bdg() {
        return this.fbm;
    }

    public int coE() {
        return this.jmW;
    }

    public c coF() {
        return this.jmR;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void Be(int i) {
        if (!this.jmT) {
            FragmentTransaction beginTransaction = getSupportFragmentManager().beginTransaction();
            Fragment findFragmentByTag = getSupportFragmentManager().findFragmentByTag(this.jmS.Bg(this.mCurrentPage));
            if (findFragmentByTag != null) {
                beginTransaction.hide(findFragmentByTag);
            }
            this.mCurrentPage = i;
            if (getSupportFragmentManager().findFragmentByTag(this.jmS.Bg(i)) != null) {
                beginTransaction.show(this.jmS.Bf(i));
            } else {
                beginTransaction.add(d.g.fragment, this.jmS.Bf(i), this.jmS.Bg(i));
            }
            beginTransaction.commitAllowingStateLoss();
            getSupportFragmentManager().executePendingTransactions();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean d(ImageFileInfo imageFileInfo) {
        if (imageFileInfo == null) {
            return false;
        }
        int maxImagesAllowed = this.jmR.getMaxImagesAllowed();
        if (this.jmR.size() < maxImagesAllowed) {
            if (this.jmU == null || this.jmU.f(imageFileInfo)) {
                ImageFileInfo imageFileInfo2 = new ImageFileInfo();
                imageFileInfo2.setAlbumnId(imageFileInfo.getAlbumId());
                imageFileInfo2.setFilePath(imageFileInfo.getFilePath());
                imageFileInfo2.setModifyTime(imageFileInfo.getModifyTime());
                imageFileInfo2.setIsGif(imageFileInfo.isGif());
                imageFileInfo2.setIsLong(imageFileInfo.isLong());
                this.jmR.a(null);
                this.jmR.addChooseFile(imageFileInfo2);
                coD();
                return true;
            }
            return false;
        } else if (coG()) {
            return d(imageFileInfo);
        } else {
            showToast(String.format(getPageContext().getContext().getString(d.j.max_choose_image_count), Integer.valueOf(maxImagesAllowed)));
            return false;
        }
    }

    public boolean coG() {
        if (getIntent().getBooleanExtra(AlbumActivityConfig.IS_SELECT_DIRECTLY, false)) {
            int maxImagesAllowed = this.jmR.getMaxImagesAllowed();
            if (this.jmR.size() == maxImagesAllowed && maxImagesAllowed == 1) {
                try {
                    ImageFileInfo imageFileInfo = (ImageFileInfo) v.c(this.jmR.coX(), 0);
                    if (e(imageFileInfo)) {
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
    public boolean e(ImageFileInfo imageFileInfo) {
        if (imageFileInfo == null) {
            return false;
        }
        this.jmR.a(null);
        this.jmR.delChooseFile(imageFileInfo);
        coD();
        return true;
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i == 4) {
            closeLoadingDialog();
            if (this.mCurrentPage == 0) {
                if (this.jmR != null) {
                    this.jmR.setLastAlbumId(null);
                }
                coH();
                return true;
            } else if (this.mCurrentPage == 1) {
                Be(0);
                return true;
            } else {
                return true;
            }
        }
        return super.onKeyDown(i, keyEvent);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void f(ImageFileInfo imageFileInfo, boolean z) {
        Fragment Bf;
        if (this.jmS != null && (Bf = this.jmS.Bf(0)) != null && (Bf instanceof ImageListFragment)) {
            ((ImageListFragment) Bf).h(imageFileInfo, z);
        }
    }

    void g(ImageFileInfo imageFileInfo, boolean z) {
        Fragment Bf;
        if (this.jmS != null && (Bf = this.jmS.Bf(1)) != null && (Bf instanceof AlbumImageBrowseFragment)) {
            ((AlbumImageBrowseFragment) Bf).h(imageFileInfo, z);
        }
    }

    private void coH() {
        Intent intent = new Intent();
        String lastAlbumId = this.jmR.getLastAlbumId();
        if (TextUtils.isEmpty(lastAlbumId)) {
            lastAlbumId = "";
        }
        intent.putExtra(AlbumActivityConfig.LAST_ALBUM_ID, lastAlbumId);
        intent.putExtra(AlbumActivityConfig.CAMERA_REQUEST_FROM, this.jmV);
        setResult(0, intent);
        finish();
    }

    private void stopCamera() {
        if (this.jmS != null) {
            this.jmS.stopCamera();
        }
    }

    private void coI() {
        if (this.jmS != null) {
            this.jmS.coI();
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
        this.jmT = true;
        stopCamera();
        closeLoadingDialog();
        dismissAllDialog();
        d.cpb().destory();
        if (this.fbm != null) {
            this.fbm.setBackgroundDrawable(null);
        }
        if (this.jmS != null) {
            this.jmS.onDestroy();
        }
        if (this.jnb != null) {
            this.jnb.onDestroy();
        }
        Intent intent = new Intent();
        intent.setAction(AlbumActivityConfig.ACTION_SELECT_IMAGE_RESULT);
        intent.putExtra(AlbumActivityConfig.ALBUM_RESULT, this.jmR.getWriteImagesInfo().toJsonString());
        intent.putExtra(AlbumActivityConfig.CAMERA_REQUEST_FROM, this.jmV);
        intent.putExtra("from_type", this.jna);
        if (this.jmY != null && !StringUtils.isNull(this.jmY.getStringExtra("file_name"))) {
            intent.putExtra("file_name", this.jmY.getStringExtra("file_name"));
        }
        TbadkCoreApplication.getInst().sendBroadcast(intent);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes3.dex */
    public class a extends BdAsyncTask<String, Integer, String> {
        private a() {
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public String doInBackground(String... strArr) {
            new com.baidu.tbadk.img.f(null).c(AlbumActivity.this.jmR.getWriteImagesInfo(), true);
            return AlbumActivity.this.jmR.getWriteImagesInfo().toJsonString();
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
        if (this.jnb != null) {
            this.jnb.onStart();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.adp.base.BdBaseFragmentActivity, android.support.v4.app.FragmentActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        coI();
        if (this.jnb != null) {
            this.jnb.onResume();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.base.BdBaseFragmentActivity, android.support.v4.app.FragmentActivity, android.app.Activity
    public void onStop() {
        super.onStop();
        if (this.jnb != null) {
            this.jnb.onStop();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.adp.base.BdBaseFragmentActivity, android.support.v4.app.FragmentActivity, android.app.Activity
    public void onPause() {
        stopCamera();
        super.onPause();
    }
}
