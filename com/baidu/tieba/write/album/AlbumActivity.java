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
import com.baidu.mapapi.UIMsg;
import com.baidu.sapi2.passhost.pluginsdk.service.IEventCenterService;
import com.baidu.tbadk.ActivityPendingTransitionFactory;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.album.VideoFileInfo;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.AlbumActivityConfig;
import com.baidu.tbadk.core.atomData.ImageViewerConfig;
import com.baidu.tbadk.core.atomData.RecordVideoActivityConfig;
import com.baidu.tbadk.core.atomData.WriteActivityConfig;
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
public class AlbumActivity extends BaseFragmentActivity implements View.OnClickListener, a.InterfaceC0042a {
    private boolean fcI;
    private com.baidu.tieba.c.d hvp;
    private e jmB;
    private Intent jmF;
    private i jmI;
    private c jmy;
    private com.baidu.tieba.write.album.a jmz;
    private int mCurrentPage = 0;
    private boolean jmA = false;
    private String callFrom = "";
    private String from = "";
    private String forumName = "";
    private String forumId = "0";
    private int jmC = 0;
    private int jmD = 0;
    private boolean jmE = false;
    private boolean jmG = false;
    private int jmH = 0;
    private View faY = null;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.adp.base.BdBaseFragmentActivity, android.support.v4.app.FragmentActivity, android.support.v4.app.SupportActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setSwipeBackEnabled(false);
        setContentView(d.h.album_activity);
        this.faY = findViewById(d.g.statebar_view);
        this.fcI = UtilHelper.canUseStyleImmersiveSticky();
        aCj();
        initData(bundle);
        this.jmz = new com.baidu.tieba.write.album.a(this);
        this.jmz.bjP();
        Ba(0);
    }

    public void showTip(View view) {
        if (this.hvp == null && view != null) {
            this.hvp = new com.baidu.tieba.c.d(getPageContext(), view);
            this.hvp.oG(d.f.bg_tip_blue_up_left);
            this.hvp.o(new View.OnClickListener() { // from class: com.baidu.tieba.write.album.AlbumActivity.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    AlbumActivity.this.hvp.aSp();
                }
            });
            this.hvp.oF(16);
            this.hvp.oH(UIMsg.m_AppUI.MSG_APP_GPS);
        }
        if (this.hvp != null) {
            String sharedPrefKeyWithAccount = com.baidu.tbadk.core.sharedPref.b.getSharedPrefKeyWithAccount("key_show_take_photo_tip");
            this.hvp.cv(getString(d.j.album_take_photo_tip), sharedPrefKeyWithAccount);
        }
    }

    private void aCj() {
        if (this.faY != null) {
            if (this.fcI && this.faY.getLayoutParams() != null) {
                ViewGroup.LayoutParams layoutParams = this.faY.getLayoutParams();
                layoutParams.height = UtilHelper.getStatusBarHeight();
                this.faY.setLayoutParams(layoutParams);
                jt(true);
                return;
            }
            jt(false);
        }
    }

    private void jt(boolean z) {
        if (this.faY != null) {
            if (this.fcI && z && this.faY.getVisibility() != 0) {
                this.faY.setVisibility(0);
            } else if (!z && this.faY.getVisibility() != 8) {
                this.faY.setVisibility(8);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.support.v4.app.FragmentActivity, android.support.v4.app.SupportActivity, android.app.Activity
    public void onSaveInstanceState(Bundle bundle) {
        bundle.putString(AlbumActivityConfig.WRITE_IMAGES_INFO, this.jmy.getWriteImagesInfo().toJsonString());
        bundle.putBoolean(AlbumActivityConfig.USE_ORIGINAL_IMG, this.jmE);
        bundle.putInt(AlbumActivityConfig.CAMERA_REQUEST_FROM, this.jmC);
        bundle.putString("forum_id", this.forumId);
        bundle.putString("forum_name", this.forumName);
        bundle.putInt(IntentConfig.KEY_ALBUM_THREAD, this.jmD);
        bundle.putBoolean(IntentConfig.KEY_FROM_WRITEACTIVITY, this.jmG);
    }

    private void initData(Bundle bundle) {
        this.jmy = new c(this);
        if (bundle != null) {
            WriteImagesInfo writeImagesInfo = new WriteImagesInfo();
            writeImagesInfo.parseJson(bundle.getString(AlbumActivityConfig.WRITE_IMAGES_INFO));
            this.jmy.setWriteImagesInfo(writeImagesInfo);
            this.jmE = bundle.getBoolean(AlbumActivityConfig.USE_ORIGINAL_IMG, false);
            this.jmC = bundle.getInt(AlbumActivityConfig.CAMERA_REQUEST_FROM, 0);
            this.forumId = bundle.getString("forum_id");
            this.forumName = bundle.getString("forum_name");
            this.jmD = bundle.getInt(IntentConfig.KEY_ALBUM_THREAD);
            this.jmG = bundle.getBoolean(IntentConfig.KEY_FROM_WRITEACTIVITY);
            this.callFrom = bundle.getString("KEY_CALL_FROM");
            this.jmH = bundle.getInt("from_type");
        } else {
            Intent intent = getIntent();
            if (intent != null) {
                WriteImagesInfo writeImagesInfo2 = new WriteImagesInfo();
                writeImagesInfo2.parseJson(intent.getStringExtra(AlbumActivityConfig.WRITE_IMAGES_INFO));
                this.jmy.setWriteImagesInfo(writeImagesInfo2);
                this.jmy.setOriginalImg(writeImagesInfo2.isOriginalImg());
                this.jmE = intent.getBooleanExtra(AlbumActivityConfig.USE_ORIGINAL_IMG, false);
                this.jmC = intent.getIntExtra(AlbumActivityConfig.CAMERA_REQUEST_FROM, 0);
                this.from = intent.getStringExtra("from");
                this.forumId = intent.getStringExtra("forum_id");
                this.forumName = intent.getStringExtra("forum_name");
                this.jmD = intent.getIntExtra(IntentConfig.KEY_ALBUM_THREAD, 0);
                this.jmG = intent.getBooleanExtra(IntentConfig.KEY_FROM_WRITEACTIVITY, false);
                this.callFrom = intent.getStringExtra("KEY_CALL_FROM");
                this.jmH = intent.getIntExtra("from_type", 0);
            }
        }
        coz();
    }

    private void coz() {
        if (this.jmC == 2) {
            this.jmB = new e() { // from class: com.baidu.tieba.write.album.AlbumActivity.2
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
        if (this.jmz != null) {
            this.jmz.onChangeSkinType(i);
        }
        al.f(this.faY, d.C0277d.cp_bg_line_d, i);
    }

    public void coA() {
        if (this.jmC == 3) {
            TiebaStatic.log("c10489");
        }
        if (this.jmC == 5) {
            showLoadingDialog("正在上传");
            new a().execute(new String[0]);
        } else if (this.jmy != null) {
            if (this.jmI == null || !this.jmI.cpp()) {
                if (this.jmy.coW()) {
                    VideoFileInfo coU = this.jmy.coU();
                    if (this.jmI == null) {
                        this.jmI = new i(this, this.forumName, this.forumId, "");
                        if (this.jmz != null) {
                            this.jmz.a(this.jmI);
                        }
                    }
                    if (getIntent() != null) {
                        this.jmI.setProfessionZone(getIntent().getIntExtra(WriteActivityConfig.KEY_PROFESSION_ZONE, -1));
                    }
                    this.jmI.a(coU, this.callFrom);
                } else if (coB()) {
                    coC();
                } else {
                    aw(null);
                }
            }
        }
    }

    private boolean coB() {
        if (this.jmy == null || v.S(this.jmy.coY()) == 0) {
            return false;
        }
        int i = 0;
        for (ImageFileInfo imageFileInfo : this.jmy.coY()) {
            if (imageFileInfo != null && imageFileInfo.getImageType() == 0 && (i = i + 1) >= 2) {
                return false;
            }
            i = i;
        }
        return i == 1;
    }

    private void aw(Intent intent) {
        Intent intent2 = new Intent();
        intent2.putExtra(AlbumActivityConfig.ALBUM_RESULT, this.jmy.getWriteImagesInfo().toJsonString());
        intent2.putExtra(AlbumActivityConfig.CAMERA_REQUEST_FROM, this.jmC);
        intent2.putExtra("from_type", this.jmH);
        if (intent != null && !StringUtils.isNull(intent.getStringExtra("file_name"))) {
            intent2.putExtra("file_name", intent.getStringExtra("file_name"));
        }
        setResult(-1, intent2);
        finish();
    }

    private boolean aJi() {
        Activity pageActivity = getPageContext().getPageActivity();
        com.baidu.tbadk.core.util.b.a aVar = new com.baidu.tbadk.core.util.b.a();
        aVar.adN();
        aVar.e(pageActivity, "android.permission.CAMERA");
        aVar.e(pageActivity, "android.permission.RECORD_AUDIO");
        aVar.e(pageActivity, "android.permission.WRITE_EXTERNAL_STORAGE");
        return aVar.Y(pageActivity);
    }

    public void c(TbPageContext tbPageContext) {
        if (!aJi() && com.baidu.tieba.write.i.cot()) {
            sendMessage(new CustomMessage(2002001, new RecordVideoActivityConfig(tbPageContext.getPageActivity(), this.jmG ? 2 : 3, new ForumWriteData(this.forumId, this.forumName, null, null), this.jmy.getWriteImagesInfo(), "", this.jmH)));
            TiebaStatic.log(new am("c12611").T("obj_locate", 5).T("obj_type", 2));
        }
    }

    private void coC() {
        WriteImagesInfo writeImagesInfo;
        if (this.jmy != null && (writeImagesInfo = this.jmy.getWriteImagesInfo()) != null) {
            sendMessage(new CustomMessage(2002001, new WriteMulitImageActivityConfig(getPageContext().getPageActivity(), IEventCenterService.EventId.EventMode.SAPIACCOUNT_THROUGH_SERVER, writeImagesInfo, coD())));
        }
    }

    private int coD() {
        if (this.jmy == null || v.S(this.jmy.coY()) == 0) {
            return 0;
        }
        for (int i = 0; i < v.S(this.jmy.coY()); i++) {
            ImageFileInfo imageFileInfo = this.jmy.coY().get(i);
            if (imageFileInfo != null && imageFileInfo.getImageType() == 0) {
                return i;
            }
        }
        return 0;
    }

    private void ax(Intent intent) {
        this.jmF = intent;
        if (intent == null || this.jmy == null) {
            aw(null);
            return;
        }
        String stringExtra = intent.getStringExtra(AlbumActivityConfig.ALBUM_RESULT);
        if (stringExtra != null) {
            WriteImagesInfo writeImagesInfo = this.jmy.getWriteImagesInfo();
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
        if (view == this.jmz.coM()) {
            coA();
        } else if (view == this.jmz.coO()) {
            coA();
        } else if (view == this.jmz.coL()) {
            if (this.jmy != null) {
                this.jmy.setLastAlbumId(null);
            }
            coI();
        } else if (view == this.jmz.coN()) {
            Ba(0);
        } else if (view == this.jmz.coP()) {
            AY(2);
        } else if (view == this.jmz.coQ()) {
            AY(1);
        }
    }

    private void AY(int i) {
        if (this.jmz != null && this.jmy != null) {
            this.jmy.setOriginalImg(!this.jmy.isOriginalImg());
            coE();
            AZ(i);
        }
    }

    private void AZ(int i) {
        if (this.jmy != null && this.jmy.isOriginalImg() && !StringUtils.isNull(this.from, true) && !StringUtils.isNull(this.forumId, true)) {
            TiebaStatic.log(new am("c10349").bJ(ImageViewerConfig.FORUM_ID, this.forumId).bJ("obj_type", this.from).T("obj_locate", i));
        }
    }

    public void coE() {
        if (this.jmy != null && this.jmz != null) {
            this.jmz.qZ(this.jmy.isOriginalImg());
        }
    }

    public View bdd() {
        return this.faY;
    }

    public int coF() {
        return this.jmD;
    }

    public c coG() {
        return this.jmy;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void Ba(int i) {
        if (!this.jmA) {
            FragmentTransaction beginTransaction = getSupportFragmentManager().beginTransaction();
            Fragment findFragmentByTag = getSupportFragmentManager().findFragmentByTag(this.jmz.Bc(this.mCurrentPage));
            if (findFragmentByTag != null) {
                beginTransaction.hide(findFragmentByTag);
            }
            this.mCurrentPage = i;
            if (getSupportFragmentManager().findFragmentByTag(this.jmz.Bc(i)) != null) {
                beginTransaction.show(this.jmz.Bb(i));
            } else {
                beginTransaction.add(d.g.fragment, this.jmz.Bb(i), this.jmz.Bc(i));
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
        int maxImagesAllowed = this.jmy.getMaxImagesAllowed();
        if (this.jmy.size() < maxImagesAllowed) {
            if (this.jmB == null || this.jmB.f(imageFileInfo)) {
                ImageFileInfo imageFileInfo2 = new ImageFileInfo();
                imageFileInfo2.setAlbumnId(imageFileInfo.getAlbumId());
                imageFileInfo2.setFilePath(imageFileInfo.getFilePath());
                imageFileInfo2.setModifyTime(imageFileInfo.getModifyTime());
                imageFileInfo2.setIsGif(imageFileInfo.isGif());
                imageFileInfo2.setIsLong(imageFileInfo.isLong());
                this.jmy.a(null);
                this.jmy.addChooseFile(imageFileInfo2);
                coE();
                return true;
            }
            return false;
        } else if (coH()) {
            return d(imageFileInfo);
        } else {
            showToast(String.format(getPageContext().getContext().getString(d.j.max_choose_image_count), Integer.valueOf(maxImagesAllowed)));
            return false;
        }
    }

    public boolean coH() {
        if (getIntent().getBooleanExtra(AlbumActivityConfig.IS_SELECT_DIRECTLY, false)) {
            int maxImagesAllowed = this.jmy.getMaxImagesAllowed();
            if (this.jmy.size() == maxImagesAllowed && maxImagesAllowed == 1) {
                try {
                    ImageFileInfo imageFileInfo = (ImageFileInfo) v.c(this.jmy.coY(), 0);
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
        this.jmy.a(null);
        this.jmy.delChooseFile(imageFileInfo);
        coE();
        return true;
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i == 4) {
            closeLoadingDialog();
            if (this.mCurrentPage == 0) {
                if (this.jmy != null) {
                    this.jmy.setLastAlbumId(null);
                }
                coI();
                return true;
            } else if (this.mCurrentPage == 1) {
                Ba(0);
                return true;
            } else {
                return true;
            }
        }
        return super.onKeyDown(i, keyEvent);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void f(ImageFileInfo imageFileInfo, boolean z) {
        Fragment Bb;
        if (this.jmz != null && (Bb = this.jmz.Bb(0)) != null && (Bb instanceof ImageListFragment)) {
            ((ImageListFragment) Bb).h(imageFileInfo, z);
        }
    }

    void g(ImageFileInfo imageFileInfo, boolean z) {
        Fragment Bb;
        if (this.jmz != null && (Bb = this.jmz.Bb(1)) != null && (Bb instanceof AlbumImageBrowseFragment)) {
            ((AlbumImageBrowseFragment) Bb).h(imageFileInfo, z);
        }
    }

    private void coI() {
        Intent intent = new Intent();
        String lastAlbumId = this.jmy.getLastAlbumId();
        if (TextUtils.isEmpty(lastAlbumId)) {
            lastAlbumId = "";
        }
        intent.putExtra(AlbumActivityConfig.LAST_ALBUM_ID, lastAlbumId);
        intent.putExtra(AlbumActivityConfig.CAMERA_REQUEST_FROM, this.jmC);
        setResult(0, intent);
        finish();
    }

    private void stopCamera() {
        if (this.jmz != null) {
            this.jmz.stopCamera();
        }
    }

    private void coJ() {
        if (this.jmz != null) {
            this.jmz.coJ();
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
        this.jmA = true;
        stopCamera();
        closeLoadingDialog();
        dismissAllDialog();
        d.cpc().destory();
        if (this.faY != null) {
            this.faY.setBackgroundDrawable(null);
        }
        if (this.jmz != null) {
            this.jmz.onDestroy();
        }
        if (this.jmI != null) {
            this.jmI.onDestroy();
        }
        Intent intent = new Intent();
        intent.setAction(AlbumActivityConfig.ACTION_SELECT_IMAGE_RESULT);
        intent.putExtra(AlbumActivityConfig.ALBUM_RESULT, this.jmy.getWriteImagesInfo().toJsonString());
        intent.putExtra(AlbumActivityConfig.CAMERA_REQUEST_FROM, this.jmC);
        intent.putExtra("from_type", this.jmH);
        if (this.jmF != null && !StringUtils.isNull(this.jmF.getStringExtra("file_name"))) {
            intent.putExtra("file_name", this.jmF.getStringExtra("file_name"));
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
            new com.baidu.tbadk.img.f(null).c(AlbumActivity.this.jmy.getWriteImagesInfo(), true);
            return AlbumActivity.this.jmy.getWriteImagesInfo().toJsonString();
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
        if (this.jmI != null) {
            this.jmI.onStart();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.adp.base.BdBaseFragmentActivity, android.support.v4.app.FragmentActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        coJ();
        if (this.jmI != null) {
            this.jmI.onResume();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.base.BdBaseFragmentActivity, android.support.v4.app.FragmentActivity, android.app.Activity
    public void onStop() {
        super.onStop();
        if (this.jmI != null) {
            this.jmI.onStop();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.adp.base.BdBaseFragmentActivity, android.support.v4.app.FragmentActivity, android.app.Activity
    public void onPause() {
        stopCamera();
        super.onPause();
    }
}
