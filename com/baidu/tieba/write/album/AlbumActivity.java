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
import com.baidu.tbadk.ActivityPendingTransitionFactory;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.album.VideoFileInfo;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.AlbumActivityConfig;
import com.baidu.tbadk.core.atomData.RecordVideoActivityConfig;
import com.baidu.tbadk.core.atomData.WriteActivityConfig;
import com.baidu.tbadk.core.atomData.WriteMulitImageActivityConfig;
import com.baidu.tbadk.core.frameworkData.IntentConfig;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.core.util.v;
import com.baidu.tbadk.img.ImageFileInfo;
import com.baidu.tbadk.img.WriteImagesInfo;
import com.baidu.tieba.R;
import com.baidu.tieba.frs.ForumWriteData;
import java.util.LinkedList;
/* loaded from: classes3.dex */
public class AlbumActivity extends BaseFragmentActivity implements View.OnClickListener, a.InterfaceC0041a {
    private boolean fxT;
    private com.baidu.tieba.c.d hTi;
    private c jMH;
    private com.baidu.tieba.write.album.a jMI;
    private e jMK;
    private Intent jMO;
    private i jMR;
    private int mCurrentPage = 0;
    private boolean jMJ = false;
    private String callFrom = "";
    private String from = "";
    private String forumName = "";
    private String forumId = "0";
    private int jML = 0;
    private int jMM = 0;
    private boolean jMN = false;
    private boolean jMP = false;
    private int jMQ = 0;
    private View fwl = null;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.adp.base.BdBaseFragmentActivity, android.support.v4.app.FragmentActivity, android.support.v4.app.SupportActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setSwipeBackEnabled(false);
        setContentView(R.layout.album_activity);
        this.fwl = findViewById(R.id.statebar_view);
        this.fxT = UtilHelper.canUseStyleImmersiveSticky();
        aKa();
        initData(bundle);
        this.jMI = new com.baidu.tieba.write.album.a(this);
        this.jMI.btn();
        CQ(0);
    }

    public void showTip(View view) {
        if (this.hTi == null && view != null) {
            this.hTi = new com.baidu.tieba.c.d(getPageContext(), view);
            this.hTi.qb(R.drawable.bg_tip_blue_up_left);
            this.hTi.q(new View.OnClickListener() { // from class: com.baidu.tieba.write.album.AlbumActivity.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    AlbumActivity.this.hTi.bbz();
                }
            });
            this.hTi.qa(16);
            this.hTi.qc(UIMsg.m_AppUI.MSG_APP_GPS);
        }
        if (this.hTi != null) {
            String sharedPrefKeyWithAccount = com.baidu.tbadk.core.sharedPref.b.getSharedPrefKeyWithAccount("key_show_take_photo_tip");
            this.hTi.cI(getString(R.string.album_take_photo_tip), sharedPrefKeyWithAccount);
        }
    }

    private void aKa() {
        if (this.fwl != null) {
            if (this.fxT && this.fwl.getLayoutParams() != null) {
                ViewGroup.LayoutParams layoutParams = this.fwl.getLayoutParams();
                layoutParams.height = UtilHelper.getStatusBarHeight();
                this.fwl.setLayoutParams(layoutParams);
                kn(true);
                return;
            }
            kn(false);
        }
    }

    private void kn(boolean z) {
        if (this.fwl != null) {
            if (this.fxT && z && this.fwl.getVisibility() != 0) {
                this.fwl.setVisibility(0);
            } else if (!z && this.fwl.getVisibility() != 8) {
                this.fwl.setVisibility(8);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.support.v4.app.FragmentActivity, android.support.v4.app.SupportActivity, android.app.Activity
    public void onSaveInstanceState(Bundle bundle) {
        bundle.putString(AlbumActivityConfig.WRITE_IMAGES_INFO, this.jMH.getWriteImagesInfo().toJsonString());
        bundle.putBoolean(AlbumActivityConfig.USE_ORIGINAL_IMG, this.jMN);
        bundle.putInt(AlbumActivityConfig.CAMERA_REQUEST_FROM, this.jML);
        bundle.putString("forum_id", this.forumId);
        bundle.putString("forum_name", this.forumName);
        bundle.putInt(IntentConfig.KEY_ALBUM_THREAD, this.jMM);
        bundle.putBoolean(IntentConfig.KEY_FROM_WRITEACTIVITY, this.jMP);
    }

    private void initData(Bundle bundle) {
        this.jMH = new c(this);
        if (bundle != null) {
            WriteImagesInfo writeImagesInfo = new WriteImagesInfo();
            writeImagesInfo.parseJson(bundle.getString(AlbumActivityConfig.WRITE_IMAGES_INFO));
            this.jMH.setWriteImagesInfo(writeImagesInfo);
            this.jMN = bundle.getBoolean(AlbumActivityConfig.USE_ORIGINAL_IMG, false);
            this.jML = bundle.getInt(AlbumActivityConfig.CAMERA_REQUEST_FROM, 0);
            this.forumId = bundle.getString("forum_id");
            this.forumName = bundle.getString("forum_name");
            this.jMM = bundle.getInt(IntentConfig.KEY_ALBUM_THREAD);
            this.jMP = bundle.getBoolean(IntentConfig.KEY_FROM_WRITEACTIVITY);
            this.callFrom = bundle.getString("KEY_CALL_FROM");
            this.jMQ = bundle.getInt("from_type");
        } else {
            Intent intent = getIntent();
            if (intent != null) {
                WriteImagesInfo writeImagesInfo2 = new WriteImagesInfo();
                writeImagesInfo2.parseJson(intent.getStringExtra(AlbumActivityConfig.WRITE_IMAGES_INFO));
                this.jMH.setWriteImagesInfo(writeImagesInfo2);
                this.jMH.setOriginalImg(writeImagesInfo2.isOriginalImg());
                this.jMN = intent.getBooleanExtra(AlbumActivityConfig.USE_ORIGINAL_IMG, false);
                this.jML = intent.getIntExtra(AlbumActivityConfig.CAMERA_REQUEST_FROM, 0);
                this.from = intent.getStringExtra("from");
                this.forumId = intent.getStringExtra("forum_id");
                this.forumName = intent.getStringExtra("forum_name");
                this.jMM = intent.getIntExtra(IntentConfig.KEY_ALBUM_THREAD, 0);
                this.jMP = intent.getBooleanExtra(IntentConfig.KEY_FROM_WRITEACTIVITY, false);
                this.callFrom = intent.getStringExtra("KEY_CALL_FROM");
                this.jMQ = intent.getIntExtra("from_type", 0);
            }
        }
        czI();
    }

    private void czI() {
        if (this.jML == 2) {
            this.jMK = new e() { // from class: com.baidu.tieba.write.album.AlbumActivity.2
                @Override // com.baidu.tieba.write.album.e
                public boolean g(ImageFileInfo imageFileInfo) {
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
                    AlbumActivity.this.showToastWithIcon(AlbumActivity.this.getPageContext().getPageActivity().getString(R.string.uploade_attation), R.drawable.icon_toast_game_error);
                    return false;
                }
            };
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity
    protected void onChangeSkinType(int i) {
        if (this.jMI != null) {
            this.jMI.onChangeSkinType(i);
        }
        am.h(this.fwl, R.color.cp_bg_line_d, i);
    }

    public void czJ() {
        if (this.jML == 3) {
            TiebaStatic.log("c10489");
        }
        if (this.jML == 5) {
            showLoadingDialog("正在上传");
            new a().execute(new String[0]);
        } else if (this.jMH != null) {
            if (this.jMR == null || !this.jMR.cAw()) {
                if (this.jMH.cAe()) {
                    VideoFileInfo cAc = this.jMH.cAc();
                    if (this.jMR == null) {
                        this.jMR = new i(this, this.forumName, this.forumId, "");
                        if (this.jMI != null) {
                            this.jMI.a(this.jMR);
                        }
                    }
                    if (getIntent() != null) {
                        this.jMR.setProfessionZone(getIntent().getIntExtra(WriteActivityConfig.KEY_PROFESSION_ZONE, -1));
                    }
                    this.jMR.a(cAc, this.callFrom);
                } else if (czK()) {
                    czL();
                } else {
                    az(null);
                }
            }
        }
    }

    private boolean czK() {
        if (this.jMH == null || v.Z(this.jMH.cAg()) == 0) {
            return false;
        }
        int i = 0;
        for (ImageFileInfo imageFileInfo : this.jMH.cAg()) {
            if (imageFileInfo != null && imageFileInfo.getImageType() == 0 && (i = i + 1) >= 2) {
                return false;
            }
            i = i;
        }
        return i == 1;
    }

    private void az(Intent intent) {
        Intent intent2 = new Intent();
        intent2.putExtra(AlbumActivityConfig.ALBUM_RESULT, this.jMH.getWriteImagesInfo().toJsonString());
        intent2.putExtra(AlbumActivityConfig.CAMERA_REQUEST_FROM, this.jML);
        intent2.putExtra("from_type", this.jMQ);
        if (intent != null && !StringUtils.isNull(intent.getStringExtra("file_name"))) {
            intent2.putExtra("file_name", intent.getStringExtra("file_name"));
        }
        setResult(-1, intent2);
        finish();
    }

    public void d(ImageFileInfo imageFileInfo) {
        if (imageFileInfo != null) {
            Intent intent = new Intent();
            LinkedList<ImageFileInfo> linkedList = new LinkedList<>();
            linkedList.add(imageFileInfo);
            this.jMH.getWriteImagesInfo().setChosedFiles(linkedList);
            intent.putExtra(AlbumActivityConfig.ALBUM_RESULT, this.jMH.getWriteImagesInfo().toJsonString());
            intent.putExtra(AlbumActivityConfig.CAMERA_REQUEST_FROM, this.jML);
            intent.putExtra("from_type", this.jMQ);
            setResult(-1, intent);
            finish();
        }
    }

    private boolean aRl() {
        Activity pageActivity = getPageContext().getPageActivity();
        com.baidu.tbadk.core.util.b.a aVar = new com.baidu.tbadk.core.util.b.a();
        aVar.ajQ();
        aVar.e(pageActivity, "android.permission.CAMERA");
        aVar.e(pageActivity, "android.permission.RECORD_AUDIO");
        aVar.e(pageActivity, "android.permission.WRITE_EXTERNAL_STORAGE");
        return aVar.ad(pageActivity);
    }

    public void c(TbPageContext tbPageContext) {
        if (!aRl() && com.baidu.tieba.write.i.czC()) {
            sendMessage(new CustomMessage(2002001, new RecordVideoActivityConfig(tbPageContext.getPageActivity(), this.jMP ? 2 : 3, new ForumWriteData(this.forumId, this.forumName, null, null), this.jMH.getWriteImagesInfo(), "", this.jMQ)));
            TiebaStatic.log(new an("c12611").P("obj_locate", 5).P("obj_type", 2));
        }
    }

    private void czL() {
        WriteImagesInfo writeImagesInfo;
        if (this.jMH != null && (writeImagesInfo = this.jMH.getWriteImagesInfo()) != null) {
            sendMessage(new CustomMessage(2002001, new WriteMulitImageActivityConfig(getPageContext().getPageActivity(), 12012, writeImagesInfo, czM())));
        }
    }

    private int czM() {
        if (this.jMH == null || v.Z(this.jMH.cAg()) == 0) {
            return 0;
        }
        for (int i = 0; i < v.Z(this.jMH.cAg()); i++) {
            ImageFileInfo imageFileInfo = this.jMH.cAg().get(i);
            if (imageFileInfo != null && imageFileInfo.getImageType() == 0) {
                return i;
            }
        }
        return 0;
    }

    private void aA(Intent intent) {
        this.jMO = intent;
        if (intent == null || this.jMH == null) {
            az(null);
            return;
        }
        String stringExtra = intent.getStringExtra(AlbumActivityConfig.ALBUM_RESULT);
        if (stringExtra != null) {
            WriteImagesInfo writeImagesInfo = this.jMH.getWriteImagesInfo();
            writeImagesInfo.parseJson(stringExtra);
            writeImagesInfo.updateQuality();
            az(intent);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragmentActivity, android.support.v4.app.FragmentActivity, android.app.Activity
    public void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (i2 == -1) {
            aA(intent);
        }
    }

    @Override // com.baidu.adp.base.BdBaseFragmentActivity, android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.jMI.czU()) {
            czJ();
        } else if (view == this.jMI.czW()) {
            czJ();
        } else if (view == this.jMI.czT()) {
            if (this.jMH != null) {
                this.jMH.setLastAlbumId(null);
            }
            czR();
        } else if (view == this.jMI.czV()) {
            CQ(0);
        } else if (view == this.jMI.czX()) {
            CO(2);
        } else if (view == this.jMI.czY()) {
            CO(1);
        }
    }

    private void CO(int i) {
        if (this.jMI != null && this.jMH != null) {
            this.jMH.setOriginalImg(!this.jMH.isOriginalImg());
            czN();
            CP(i);
        }
    }

    private void CP(int i) {
        if (this.jMH != null && this.jMH.isOriginalImg() && !StringUtils.isNull(this.from, true) && !StringUtils.isNull(this.forumId, true)) {
            TiebaStatic.log(new an("c10349").bT("fid", this.forumId).bT("obj_type", this.from).P("obj_locate", i));
        }
    }

    public void czN() {
        if (this.jMH != null && this.jMI != null) {
            this.jMI.se(this.jMH.isOriginalImg());
        }
    }

    public View bmA() {
        return this.fwl;
    }

    public int czO() {
        return this.jMM;
    }

    public c czP() {
        return this.jMH;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void CQ(int i) {
        if (!this.jMJ) {
            FragmentTransaction beginTransaction = getSupportFragmentManager().beginTransaction();
            Fragment findFragmentByTag = getSupportFragmentManager().findFragmentByTag(this.jMI.CS(this.mCurrentPage));
            if (findFragmentByTag != null) {
                beginTransaction.hide(findFragmentByTag);
            }
            this.mCurrentPage = i;
            if (getSupportFragmentManager().findFragmentByTag(this.jMI.CS(i)) != null) {
                beginTransaction.show(this.jMI.CR(i));
            } else {
                beginTransaction.add(R.id.fragment, this.jMI.CR(i), this.jMI.CS(i));
            }
            beginTransaction.commitAllowingStateLoss();
            getSupportFragmentManager().executePendingTransactions();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean e(ImageFileInfo imageFileInfo) {
        if (imageFileInfo == null) {
            return false;
        }
        int maxImagesAllowed = this.jMH.getMaxImagesAllowed();
        if (this.jMH.size() < maxImagesAllowed) {
            if (this.jMK == null || this.jMK.g(imageFileInfo)) {
                ImageFileInfo imageFileInfo2 = new ImageFileInfo();
                imageFileInfo2.setAlbumnId(imageFileInfo.getAlbumId());
                imageFileInfo2.setFilePath(imageFileInfo.getFilePath());
                imageFileInfo2.setModifyTime(imageFileInfo.getModifyTime());
                imageFileInfo2.setIsGif(imageFileInfo.isGif());
                imageFileInfo2.setIsLong(imageFileInfo.isLong());
                this.jMH.a(null);
                this.jMH.addChooseFile(imageFileInfo2);
                czN();
                return true;
            }
            return false;
        } else if (czQ()) {
            return e(imageFileInfo);
        } else {
            showToast(String.format(getPageContext().getContext().getString(R.string.max_choose_image_count), Integer.valueOf(maxImagesAllowed)));
            return false;
        }
    }

    public boolean czQ() {
        if (getIntent().getBooleanExtra(AlbumActivityConfig.IS_SELECT_DIRECTLY, false)) {
            int maxImagesAllowed = this.jMH.getMaxImagesAllowed();
            if (this.jMH.size() == maxImagesAllowed && maxImagesAllowed == 1) {
                try {
                    ImageFileInfo imageFileInfo = (ImageFileInfo) v.c(this.jMH.cAg(), 0);
                    if (f(imageFileInfo)) {
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
    public boolean f(ImageFileInfo imageFileInfo) {
        if (imageFileInfo == null) {
            return false;
        }
        this.jMH.a(null);
        this.jMH.delChooseFile(imageFileInfo);
        czN();
        return true;
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i == 4) {
            closeLoadingDialog();
            if (this.mCurrentPage == 0) {
                if (this.jMH != null) {
                    this.jMH.setLastAlbumId(null);
                }
                czR();
                return true;
            } else if (this.mCurrentPage == 1) {
                CQ(0);
                return true;
            } else {
                return true;
            }
        }
        return super.onKeyDown(i, keyEvent);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void f(ImageFileInfo imageFileInfo, boolean z) {
        Fragment CR;
        if (this.jMI != null && (CR = this.jMI.CR(0)) != null && (CR instanceof ImageListFragment)) {
            ((ImageListFragment) CR).h(imageFileInfo, z);
        }
    }

    void g(ImageFileInfo imageFileInfo, boolean z) {
        Fragment CR;
        if (this.jMI != null && (CR = this.jMI.CR(1)) != null && (CR instanceof AlbumImageBrowseFragment)) {
            ((AlbumImageBrowseFragment) CR).h(imageFileInfo, z);
        }
    }

    private void czR() {
        Intent intent = new Intent();
        String lastAlbumId = this.jMH.getLastAlbumId();
        if (TextUtils.isEmpty(lastAlbumId)) {
            lastAlbumId = "";
        }
        intent.putExtra(AlbumActivityConfig.LAST_ALBUM_ID, lastAlbumId);
        intent.putExtra(AlbumActivityConfig.CAMERA_REQUEST_FROM, this.jML);
        setResult(0, intent);
        finish();
    }

    private void stopCamera() {
        if (this.jMI != null) {
            this.jMI.stopCamera();
        }
    }

    private void aYU() {
        if (this.jMI != null) {
            this.jMI.aYU();
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
        this.jMJ = true;
        stopCamera();
        closeLoadingDialog();
        dismissAllDialog();
        d.cAk().destory();
        if (this.fwl != null) {
            this.fwl.setBackgroundDrawable(null);
        }
        if (this.jMI != null) {
            this.jMI.onDestroy();
        }
        if (this.jMR != null) {
            this.jMR.onDestroy();
        }
        Intent intent = new Intent();
        intent.setAction(AlbumActivityConfig.ACTION_SELECT_IMAGE_RESULT);
        intent.putExtra(AlbumActivityConfig.ALBUM_RESULT, this.jMH.getWriteImagesInfo().toJsonString());
        intent.putExtra(AlbumActivityConfig.CAMERA_REQUEST_FROM, this.jML);
        intent.putExtra("from_type", this.jMQ);
        if (this.jMO != null && !StringUtils.isNull(this.jMO.getStringExtra("file_name"))) {
            intent.putExtra("file_name", this.jMO.getStringExtra("file_name"));
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
            new com.baidu.tbadk.img.f(null).c(AlbumActivity.this.jMH.getWriteImagesInfo(), true);
            return AlbumActivity.this.jMH.getWriteImagesInfo().toJsonString();
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
        if (this.jMR != null) {
            this.jMR.onStart();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.adp.base.BdBaseFragmentActivity, android.support.v4.app.FragmentActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        aYU();
        if (this.jMR != null) {
            this.jMR.onResume();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.base.BdBaseFragmentActivity, android.support.v4.app.FragmentActivity, android.app.Activity
    public void onStop() {
        super.onStop();
        if (this.jMR != null) {
            this.jMR.onStop();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.adp.base.BdBaseFragmentActivity, android.support.v4.app.FragmentActivity, android.app.Activity
    public void onPause() {
        stopCamera();
        super.onPause();
    }
}
