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
    private boolean fcV;
    private com.baidu.tieba.c.d hvB;
    private c jmJ;
    private com.baidu.tieba.write.album.a jmK;
    private e jmM;
    private Intent jmQ;
    private i jmT;
    private int mCurrentPage = 0;
    private boolean jmL = false;
    private String callFrom = "";
    private String from = "";
    private String forumName = "";
    private String forumId = "0";
    private int jmN = 0;
    private int jmO = 0;
    private boolean jmP = false;
    private boolean jmR = false;
    private int jmS = 0;
    private View fbl = null;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.adp.base.BdBaseFragmentActivity, android.support.v4.app.FragmentActivity, android.support.v4.app.SupportActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setSwipeBackEnabled(false);
        setContentView(d.h.album_activity);
        this.fbl = findViewById(d.g.statebar_view);
        this.fcV = UtilHelper.canUseStyleImmersiveSticky();
        aCm();
        initData(bundle);
        this.jmK = new com.baidu.tieba.write.album.a(this);
        this.jmK.bjR();
        Be(0);
    }

    public void showTip(View view) {
        if (this.hvB == null && view != null) {
            this.hvB = new com.baidu.tieba.c.d(getPageContext(), view);
            this.hvB.oK(d.f.bg_tip_blue_up_left);
            this.hvB.o(new View.OnClickListener() { // from class: com.baidu.tieba.write.album.AlbumActivity.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    AlbumActivity.this.hvB.aSr();
                }
            });
            this.hvB.oJ(16);
            this.hvB.oL(UIMsg.m_AppUI.MSG_APP_GPS);
        }
        if (this.hvB != null) {
            String sharedPrefKeyWithAccount = com.baidu.tbadk.core.sharedPref.b.getSharedPrefKeyWithAccount("key_show_take_photo_tip");
            this.hvB.cu(getString(d.j.album_take_photo_tip), sharedPrefKeyWithAccount);
        }
    }

    private void aCm() {
        if (this.fbl != null) {
            if (this.fcV && this.fbl.getLayoutParams() != null) {
                ViewGroup.LayoutParams layoutParams = this.fbl.getLayoutParams();
                layoutParams.height = UtilHelper.getStatusBarHeight();
                this.fbl.setLayoutParams(layoutParams);
                jt(true);
                return;
            }
            jt(false);
        }
    }

    private void jt(boolean z) {
        if (this.fbl != null) {
            if (this.fcV && z && this.fbl.getVisibility() != 0) {
                this.fbl.setVisibility(0);
            } else if (!z && this.fbl.getVisibility() != 8) {
                this.fbl.setVisibility(8);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.support.v4.app.FragmentActivity, android.support.v4.app.SupportActivity, android.app.Activity
    public void onSaveInstanceState(Bundle bundle) {
        bundle.putString(AlbumActivityConfig.WRITE_IMAGES_INFO, this.jmJ.getWriteImagesInfo().toJsonString());
        bundle.putBoolean(AlbumActivityConfig.USE_ORIGINAL_IMG, this.jmP);
        bundle.putInt(AlbumActivityConfig.CAMERA_REQUEST_FROM, this.jmN);
        bundle.putString("forum_id", this.forumId);
        bundle.putString("forum_name", this.forumName);
        bundle.putInt(IntentConfig.KEY_ALBUM_THREAD, this.jmO);
        bundle.putBoolean(IntentConfig.KEY_FROM_WRITEACTIVITY, this.jmR);
    }

    private void initData(Bundle bundle) {
        this.jmJ = new c(this);
        if (bundle != null) {
            WriteImagesInfo writeImagesInfo = new WriteImagesInfo();
            writeImagesInfo.parseJson(bundle.getString(AlbumActivityConfig.WRITE_IMAGES_INFO));
            this.jmJ.setWriteImagesInfo(writeImagesInfo);
            this.jmP = bundle.getBoolean(AlbumActivityConfig.USE_ORIGINAL_IMG, false);
            this.jmN = bundle.getInt(AlbumActivityConfig.CAMERA_REQUEST_FROM, 0);
            this.forumId = bundle.getString("forum_id");
            this.forumName = bundle.getString("forum_name");
            this.jmO = bundle.getInt(IntentConfig.KEY_ALBUM_THREAD);
            this.jmR = bundle.getBoolean(IntentConfig.KEY_FROM_WRITEACTIVITY);
            this.callFrom = bundle.getString("KEY_CALL_FROM");
            this.jmS = bundle.getInt("from_type");
        } else {
            Intent intent = getIntent();
            if (intent != null) {
                WriteImagesInfo writeImagesInfo2 = new WriteImagesInfo();
                writeImagesInfo2.parseJson(intent.getStringExtra(AlbumActivityConfig.WRITE_IMAGES_INFO));
                this.jmJ.setWriteImagesInfo(writeImagesInfo2);
                this.jmJ.setOriginalImg(writeImagesInfo2.isOriginalImg());
                this.jmP = intent.getBooleanExtra(AlbumActivityConfig.USE_ORIGINAL_IMG, false);
                this.jmN = intent.getIntExtra(AlbumActivityConfig.CAMERA_REQUEST_FROM, 0);
                this.from = intent.getStringExtra("from");
                this.forumId = intent.getStringExtra("forum_id");
                this.forumName = intent.getStringExtra("forum_name");
                this.jmO = intent.getIntExtra(IntentConfig.KEY_ALBUM_THREAD, 0);
                this.jmR = intent.getBooleanExtra(IntentConfig.KEY_FROM_WRITEACTIVITY, false);
                this.callFrom = intent.getStringExtra("KEY_CALL_FROM");
                this.jmS = intent.getIntExtra("from_type", 0);
            }
        }
        coB();
    }

    private void coB() {
        if (this.jmN == 2) {
            this.jmM = new e() { // from class: com.baidu.tieba.write.album.AlbumActivity.2
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
        if (this.jmK != null) {
            this.jmK.onChangeSkinType(i);
        }
        al.f(this.fbl, d.C0277d.cp_bg_line_d, i);
    }

    public void coC() {
        if (this.jmN == 3) {
            TiebaStatic.log("c10489");
        }
        if (this.jmN == 5) {
            showLoadingDialog("正在上传");
            new a().execute(new String[0]);
        } else if (this.jmJ != null) {
            if (this.jmT == null || !this.jmT.cpr()) {
                if (this.jmJ.coY()) {
                    VideoFileInfo coW = this.jmJ.coW();
                    if (this.jmT == null) {
                        this.jmT = new i(this, this.forumName, this.forumId, "");
                        if (this.jmK != null) {
                            this.jmK.a(this.jmT);
                        }
                    }
                    this.jmT.a(coW, this.callFrom);
                } else if (coD()) {
                    coE();
                } else {
                    aw(null);
                }
            }
        }
    }

    private boolean coD() {
        if (this.jmJ == null || v.S(this.jmJ.cpa()) == 0) {
            return false;
        }
        int i = 0;
        for (ImageFileInfo imageFileInfo : this.jmJ.cpa()) {
            if (imageFileInfo != null && imageFileInfo.getImageType() == 0 && (i = i + 1) >= 2) {
                return false;
            }
            i = i;
        }
        return i == 1;
    }

    private void aw(Intent intent) {
        Intent intent2 = new Intent();
        intent2.putExtra(AlbumActivityConfig.ALBUM_RESULT, this.jmJ.getWriteImagesInfo().toJsonString());
        intent2.putExtra(AlbumActivityConfig.CAMERA_REQUEST_FROM, this.jmN);
        intent2.putExtra("from_type", this.jmS);
        if (intent != null && !StringUtils.isNull(intent.getStringExtra("file_name"))) {
            intent2.putExtra("file_name", intent.getStringExtra("file_name"));
        }
        setResult(-1, intent2);
        finish();
    }

    private boolean aJt() {
        Activity pageActivity = getPageContext().getPageActivity();
        com.baidu.tbadk.core.util.b.a aVar = new com.baidu.tbadk.core.util.b.a();
        aVar.adQ();
        aVar.e(pageActivity, "android.permission.CAMERA");
        aVar.e(pageActivity, "android.permission.RECORD_AUDIO");
        aVar.e(pageActivity, "android.permission.WRITE_EXTERNAL_STORAGE");
        return aVar.Y(pageActivity);
    }

    public void c(TbPageContext tbPageContext) {
        if (!aJt() && com.baidu.tieba.write.i.cov()) {
            sendMessage(new CustomMessage(2002001, new RecordVideoActivityConfig(tbPageContext.getPageActivity(), this.jmR ? 2 : 3, new ForumWriteData(this.forumId, this.forumName, null, null), this.jmJ.getWriteImagesInfo(), "", this.jmS)));
            TiebaStatic.log(new am("c12611").T("obj_locate", 5).T("obj_type", 2));
        }
    }

    private void coE() {
        WriteImagesInfo writeImagesInfo;
        if (this.jmJ != null && (writeImagesInfo = this.jmJ.getWriteImagesInfo()) != null) {
            sendMessage(new CustomMessage(2002001, new WriteMulitImageActivityConfig(getPageContext().getPageActivity(), IEventCenterService.EventId.EventMode.SAPIACCOUNT_THROUGH_SERVER, writeImagesInfo, coF())));
        }
    }

    private int coF() {
        if (this.jmJ == null || v.S(this.jmJ.cpa()) == 0) {
            return 0;
        }
        for (int i = 0; i < v.S(this.jmJ.cpa()); i++) {
            ImageFileInfo imageFileInfo = this.jmJ.cpa().get(i);
            if (imageFileInfo != null && imageFileInfo.getImageType() == 0) {
                return i;
            }
        }
        return 0;
    }

    private void ax(Intent intent) {
        this.jmQ = intent;
        if (intent == null || this.jmJ == null) {
            aw(null);
            return;
        }
        String stringExtra = intent.getStringExtra(AlbumActivityConfig.ALBUM_RESULT);
        if (stringExtra != null) {
            WriteImagesInfo writeImagesInfo = this.jmJ.getWriteImagesInfo();
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
        if (view == this.jmK.coO()) {
            coC();
        } else if (view == this.jmK.coQ()) {
            coC();
        } else if (view == this.jmK.coN()) {
            if (this.jmJ != null) {
                this.jmJ.setLastAlbumId(null);
            }
            coK();
        } else if (view == this.jmK.coP()) {
            Be(0);
        } else if (view == this.jmK.coR()) {
            Bc(2);
        } else if (view == this.jmK.coS()) {
            Bc(1);
        }
    }

    private void Bc(int i) {
        if (this.jmK != null && this.jmJ != null) {
            this.jmJ.setOriginalImg(!this.jmJ.isOriginalImg());
            coG();
            Bd(i);
        }
    }

    private void Bd(int i) {
        if (this.jmJ != null && this.jmJ.isOriginalImg() && !StringUtils.isNull(this.from, true) && !StringUtils.isNull(this.forumId, true)) {
            TiebaStatic.log(new am("c10349").bJ(ImageViewerConfig.FORUM_ID, this.forumId).bJ("obj_type", this.from).T("obj_locate", i));
        }
    }

    public void coG() {
        if (this.jmJ != null && this.jmK != null) {
            this.jmK.qZ(this.jmJ.isOriginalImg());
        }
    }

    public View bdf() {
        return this.fbl;
    }

    public int coH() {
        return this.jmO;
    }

    public c coI() {
        return this.jmJ;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void Be(int i) {
        if (!this.jmL) {
            FragmentTransaction beginTransaction = getSupportFragmentManager().beginTransaction();
            Fragment findFragmentByTag = getSupportFragmentManager().findFragmentByTag(this.jmK.Bg(this.mCurrentPage));
            if (findFragmentByTag != null) {
                beginTransaction.hide(findFragmentByTag);
            }
            this.mCurrentPage = i;
            if (getSupportFragmentManager().findFragmentByTag(this.jmK.Bg(i)) != null) {
                beginTransaction.show(this.jmK.Bf(i));
            } else {
                beginTransaction.add(d.g.fragment, this.jmK.Bf(i), this.jmK.Bg(i));
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
        int maxImagesAllowed = this.jmJ.getMaxImagesAllowed();
        if (this.jmJ.size() < maxImagesAllowed) {
            if (this.jmM == null || this.jmM.f(imageFileInfo)) {
                ImageFileInfo imageFileInfo2 = new ImageFileInfo();
                imageFileInfo2.setAlbumnId(imageFileInfo.getAlbumId());
                imageFileInfo2.setFilePath(imageFileInfo.getFilePath());
                imageFileInfo2.setModifyTime(imageFileInfo.getModifyTime());
                imageFileInfo2.setIsGif(imageFileInfo.isGif());
                imageFileInfo2.setIsLong(imageFileInfo.isLong());
                this.jmJ.a(null);
                this.jmJ.addChooseFile(imageFileInfo2);
                coG();
                return true;
            }
            return false;
        } else if (coJ()) {
            return d(imageFileInfo);
        } else {
            showToast(String.format(getPageContext().getContext().getString(d.j.max_choose_image_count), Integer.valueOf(maxImagesAllowed)));
            return false;
        }
    }

    public boolean coJ() {
        if (getIntent().getBooleanExtra(AlbumActivityConfig.IS_SELECT_DIRECTLY, false)) {
            int maxImagesAllowed = this.jmJ.getMaxImagesAllowed();
            if (this.jmJ.size() == maxImagesAllowed && maxImagesAllowed == 1) {
                try {
                    ImageFileInfo imageFileInfo = (ImageFileInfo) v.c(this.jmJ.cpa(), 0);
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
        this.jmJ.a(null);
        this.jmJ.delChooseFile(imageFileInfo);
        coG();
        return true;
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i == 4) {
            closeLoadingDialog();
            if (this.mCurrentPage == 0) {
                if (this.jmJ != null) {
                    this.jmJ.setLastAlbumId(null);
                }
                coK();
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
        if (this.jmK != null && (Bf = this.jmK.Bf(0)) != null && (Bf instanceof ImageListFragment)) {
            ((ImageListFragment) Bf).h(imageFileInfo, z);
        }
    }

    void g(ImageFileInfo imageFileInfo, boolean z) {
        Fragment Bf;
        if (this.jmK != null && (Bf = this.jmK.Bf(1)) != null && (Bf instanceof AlbumImageBrowseFragment)) {
            ((AlbumImageBrowseFragment) Bf).h(imageFileInfo, z);
        }
    }

    private void coK() {
        Intent intent = new Intent();
        String lastAlbumId = this.jmJ.getLastAlbumId();
        if (TextUtils.isEmpty(lastAlbumId)) {
            lastAlbumId = "";
        }
        intent.putExtra(AlbumActivityConfig.LAST_ALBUM_ID, lastAlbumId);
        intent.putExtra(AlbumActivityConfig.CAMERA_REQUEST_FROM, this.jmN);
        setResult(0, intent);
        finish();
    }

    private void stopCamera() {
        if (this.jmK != null) {
            this.jmK.stopCamera();
        }
    }

    private void coL() {
        if (this.jmK != null) {
            this.jmK.coL();
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
        this.jmL = true;
        stopCamera();
        closeLoadingDialog();
        dismissAllDialog();
        d.cpe().destory();
        if (this.fbl != null) {
            this.fbl.setBackgroundDrawable(null);
        }
        if (this.jmK != null) {
            this.jmK.onDestroy();
        }
        if (this.jmT != null) {
            this.jmT.onDestroy();
        }
        Intent intent = new Intent();
        intent.setAction(AlbumActivityConfig.ACTION_SELECT_IMAGE_RESULT);
        intent.putExtra(AlbumActivityConfig.ALBUM_RESULT, this.jmJ.getWriteImagesInfo().toJsonString());
        intent.putExtra(AlbumActivityConfig.CAMERA_REQUEST_FROM, this.jmN);
        intent.putExtra("from_type", this.jmS);
        if (this.jmQ != null && !StringUtils.isNull(this.jmQ.getStringExtra("file_name"))) {
            intent.putExtra("file_name", this.jmQ.getStringExtra("file_name"));
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
            new com.baidu.tbadk.img.f(null).c(AlbumActivity.this.jmJ.getWriteImagesInfo(), true);
            return AlbumActivity.this.jmJ.getWriteImagesInfo().toJsonString();
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
        if (this.jmT != null) {
            this.jmT.onStart();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.adp.base.BdBaseFragmentActivity, android.support.v4.app.FragmentActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        coL();
        if (this.jmT != null) {
            this.jmT.onResume();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.base.BdBaseFragmentActivity, android.support.v4.app.FragmentActivity, android.app.Activity
    public void onStop() {
        super.onStop();
        if (this.jmT != null) {
            this.jmT.onStop();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.adp.base.BdBaseFragmentActivity, android.support.v4.app.FragmentActivity, android.app.Activity
    public void onPause() {
        stopCamera();
        super.onPause();
    }
}
