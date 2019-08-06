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
    private boolean fys;
    private com.baidu.tieba.c.d hUe;
    private c jNO;
    private com.baidu.tieba.write.album.a jNP;
    private e jNR;
    private Intent jNV;
    private i jNY;
    private int mCurrentPage = 0;
    private boolean jNQ = false;
    private String callFrom = "";
    private String from = "";
    private String forumName = "";
    private String forumId = "0";
    private int jNS = 0;
    private int jNT = 0;
    private boolean jNU = false;
    private boolean jNW = false;
    private int jNX = 0;
    private View fwK = null;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.adp.base.BdBaseFragmentActivity, android.support.v4.app.FragmentActivity, android.support.v4.app.SupportActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setSwipeBackEnabled(false);
        setContentView(R.layout.album_activity);
        this.fwK = findViewById(R.id.statebar_view);
        this.fys = UtilHelper.canUseStyleImmersiveSticky();
        aKc();
        initData(bundle);
        this.jNP = new com.baidu.tieba.write.album.a(this);
        this.jNP.btA();
        CS(0);
    }

    public void showTip(View view) {
        if (this.hUe == null && view != null) {
            this.hUe = new com.baidu.tieba.c.d(getPageContext(), view);
            this.hUe.qc(R.drawable.bg_tip_blue_up_left);
            this.hUe.q(new View.OnClickListener() { // from class: com.baidu.tieba.write.album.AlbumActivity.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    AlbumActivity.this.hUe.bbB();
                }
            });
            this.hUe.qb(16);
            this.hUe.qd(UIMsg.m_AppUI.MSG_APP_GPS);
        }
        if (this.hUe != null) {
            String sharedPrefKeyWithAccount = com.baidu.tbadk.core.sharedPref.b.getSharedPrefKeyWithAccount("key_show_take_photo_tip");
            this.hUe.cI(getString(R.string.album_take_photo_tip), sharedPrefKeyWithAccount);
        }
    }

    private void aKc() {
        if (this.fwK != null) {
            if (this.fys && this.fwK.getLayoutParams() != null) {
                ViewGroup.LayoutParams layoutParams = this.fwK.getLayoutParams();
                layoutParams.height = UtilHelper.getStatusBarHeight();
                this.fwK.setLayoutParams(layoutParams);
                kn(true);
                return;
            }
            kn(false);
        }
    }

    private void kn(boolean z) {
        if (this.fwK != null) {
            if (this.fys && z && this.fwK.getVisibility() != 0) {
                this.fwK.setVisibility(0);
            } else if (!z && this.fwK.getVisibility() != 8) {
                this.fwK.setVisibility(8);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.support.v4.app.FragmentActivity, android.support.v4.app.SupportActivity, android.app.Activity
    public void onSaveInstanceState(Bundle bundle) {
        bundle.putString(AlbumActivityConfig.WRITE_IMAGES_INFO, this.jNO.getWriteImagesInfo().toJsonString());
        bundle.putBoolean(AlbumActivityConfig.USE_ORIGINAL_IMG, this.jNU);
        bundle.putInt(AlbumActivityConfig.CAMERA_REQUEST_FROM, this.jNS);
        bundle.putString("forum_id", this.forumId);
        bundle.putString("forum_name", this.forumName);
        bundle.putInt(IntentConfig.KEY_ALBUM_THREAD, this.jNT);
        bundle.putBoolean(IntentConfig.KEY_FROM_WRITEACTIVITY, this.jNW);
    }

    private void initData(Bundle bundle) {
        this.jNO = new c(this);
        if (bundle != null) {
            WriteImagesInfo writeImagesInfo = new WriteImagesInfo();
            writeImagesInfo.parseJson(bundle.getString(AlbumActivityConfig.WRITE_IMAGES_INFO));
            this.jNO.setWriteImagesInfo(writeImagesInfo);
            this.jNU = bundle.getBoolean(AlbumActivityConfig.USE_ORIGINAL_IMG, false);
            this.jNS = bundle.getInt(AlbumActivityConfig.CAMERA_REQUEST_FROM, 0);
            this.forumId = bundle.getString("forum_id");
            this.forumName = bundle.getString("forum_name");
            this.jNT = bundle.getInt(IntentConfig.KEY_ALBUM_THREAD);
            this.jNW = bundle.getBoolean(IntentConfig.KEY_FROM_WRITEACTIVITY);
            this.callFrom = bundle.getString("KEY_CALL_FROM");
            this.jNX = bundle.getInt("from_type");
        } else {
            Intent intent = getIntent();
            if (intent != null) {
                WriteImagesInfo writeImagesInfo2 = new WriteImagesInfo();
                writeImagesInfo2.parseJson(intent.getStringExtra(AlbumActivityConfig.WRITE_IMAGES_INFO));
                this.jNO.setWriteImagesInfo(writeImagesInfo2);
                this.jNO.setOriginalImg(writeImagesInfo2.isOriginalImg());
                this.jNU = intent.getBooleanExtra(AlbumActivityConfig.USE_ORIGINAL_IMG, false);
                this.jNS = intent.getIntExtra(AlbumActivityConfig.CAMERA_REQUEST_FROM, 0);
                this.from = intent.getStringExtra("from");
                this.forumId = intent.getStringExtra("forum_id");
                this.forumName = intent.getStringExtra("forum_name");
                this.jNT = intent.getIntExtra(IntentConfig.KEY_ALBUM_THREAD, 0);
                this.jNW = intent.getBooleanExtra(IntentConfig.KEY_FROM_WRITEACTIVITY, false);
                this.callFrom = intent.getStringExtra("KEY_CALL_FROM");
                this.jNX = intent.getIntExtra("from_type", 0);
            }
        }
        cAd();
    }

    private void cAd() {
        if (this.jNS == 2) {
            this.jNR = new e() { // from class: com.baidu.tieba.write.album.AlbumActivity.2
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
        if (this.jNP != null) {
            this.jNP.onChangeSkinType(i);
        }
        am.h(this.fwK, R.color.cp_bg_line_d, i);
    }

    public void cAe() {
        if (this.jNS == 3) {
            TiebaStatic.log("c10489");
        }
        if (this.jNS == 5) {
            showLoadingDialog("正在上传");
            new a().execute(new String[0]);
        } else if (this.jNO != null) {
            if (this.jNY == null || !this.jNY.cAR()) {
                if (this.jNO.cAz()) {
                    VideoFileInfo cAx = this.jNO.cAx();
                    if (this.jNY == null) {
                        this.jNY = new i(this, this.forumName, this.forumId, "");
                        if (this.jNP != null) {
                            this.jNP.a(this.jNY);
                        }
                    }
                    if (getIntent() != null) {
                        this.jNY.setProfessionZone(getIntent().getIntExtra(WriteActivityConfig.KEY_PROFESSION_ZONE, -1));
                    }
                    this.jNY.a(cAx, this.callFrom);
                } else if (cAf()) {
                    cAg();
                } else {
                    aB(null);
                }
            }
        }
    }

    private boolean cAf() {
        if (this.jNO == null || v.Z(this.jNO.cAB()) == 0) {
            return false;
        }
        int i = 0;
        for (ImageFileInfo imageFileInfo : this.jNO.cAB()) {
            if (imageFileInfo != null && imageFileInfo.getImageType() == 0 && (i = i + 1) >= 2) {
                return false;
            }
            i = i;
        }
        return i == 1;
    }

    private void aB(Intent intent) {
        Intent intent2 = new Intent();
        intent2.putExtra(AlbumActivityConfig.ALBUM_RESULT, this.jNO.getWriteImagesInfo().toJsonString());
        intent2.putExtra(AlbumActivityConfig.CAMERA_REQUEST_FROM, this.jNS);
        intent2.putExtra("from_type", this.jNX);
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
            this.jNO.getWriteImagesInfo().setChosedFiles(linkedList);
            intent.putExtra(AlbumActivityConfig.ALBUM_RESULT, this.jNO.getWriteImagesInfo().toJsonString());
            intent.putExtra(AlbumActivityConfig.CAMERA_REQUEST_FROM, this.jNS);
            intent.putExtra("from_type", this.jNX);
            setResult(-1, intent);
            finish();
        }
    }

    private boolean aRn() {
        Activity pageActivity = getPageContext().getPageActivity();
        com.baidu.tbadk.core.util.b.a aVar = new com.baidu.tbadk.core.util.b.a();
        aVar.ajS();
        aVar.e(pageActivity, "android.permission.CAMERA");
        aVar.e(pageActivity, "android.permission.RECORD_AUDIO");
        aVar.e(pageActivity, "android.permission.WRITE_EXTERNAL_STORAGE");
        return aVar.ad(pageActivity);
    }

    public void c(TbPageContext tbPageContext) {
        if (!aRn() && com.baidu.tieba.write.i.czX()) {
            sendMessage(new CustomMessage(2002001, new RecordVideoActivityConfig(tbPageContext.getPageActivity(), this.jNW ? 2 : 3, new ForumWriteData(this.forumId, this.forumName, null, null), this.jNO.getWriteImagesInfo(), "", this.jNX)));
            TiebaStatic.log(new an("c12611").P("obj_locate", 5).P("obj_type", 2));
        }
    }

    private void cAg() {
        WriteImagesInfo writeImagesInfo;
        if (this.jNO != null && (writeImagesInfo = this.jNO.getWriteImagesInfo()) != null) {
            sendMessage(new CustomMessage(2002001, new WriteMulitImageActivityConfig(getPageContext().getPageActivity(), 12012, writeImagesInfo, cAh())));
        }
    }

    private int cAh() {
        if (this.jNO == null || v.Z(this.jNO.cAB()) == 0) {
            return 0;
        }
        for (int i = 0; i < v.Z(this.jNO.cAB()); i++) {
            ImageFileInfo imageFileInfo = this.jNO.cAB().get(i);
            if (imageFileInfo != null && imageFileInfo.getImageType() == 0) {
                return i;
            }
        }
        return 0;
    }

    private void aC(Intent intent) {
        this.jNV = intent;
        if (intent == null || this.jNO == null) {
            aB(null);
            return;
        }
        String stringExtra = intent.getStringExtra(AlbumActivityConfig.ALBUM_RESULT);
        if (stringExtra != null) {
            WriteImagesInfo writeImagesInfo = this.jNO.getWriteImagesInfo();
            writeImagesInfo.parseJson(stringExtra);
            writeImagesInfo.updateQuality();
            aB(intent);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragmentActivity, android.support.v4.app.FragmentActivity, android.app.Activity
    public void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (i2 == -1) {
            aC(intent);
        }
    }

    @Override // com.baidu.adp.base.BdBaseFragmentActivity, android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.jNP.cAp()) {
            cAe();
        } else if (view == this.jNP.cAr()) {
            cAe();
        } else if (view == this.jNP.cAo()) {
            if (this.jNO != null) {
                this.jNO.setLastAlbumId(null);
            }
            cAm();
        } else if (view == this.jNP.cAq()) {
            CS(0);
        } else if (view == this.jNP.cAs()) {
            CQ(2);
        } else if (view == this.jNP.cAt()) {
            CQ(1);
        }
    }

    private void CQ(int i) {
        if (this.jNP != null && this.jNO != null) {
            this.jNO.setOriginalImg(!this.jNO.isOriginalImg());
            cAi();
            CR(i);
        }
    }

    private void CR(int i) {
        if (this.jNO != null && this.jNO.isOriginalImg() && !StringUtils.isNull(this.from, true) && !StringUtils.isNull(this.forumId, true)) {
            TiebaStatic.log(new an("c10349").bT("fid", this.forumId).bT("obj_type", this.from).P("obj_locate", i));
        }
    }

    public void cAi() {
        if (this.jNO != null && this.jNP != null) {
            this.jNP.sf(this.jNO.isOriginalImg());
        }
    }

    public View bmK() {
        return this.fwK;
    }

    public int cAj() {
        return this.jNT;
    }

    public c cAk() {
        return this.jNO;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void CS(int i) {
        if (!this.jNQ) {
            FragmentTransaction beginTransaction = getSupportFragmentManager().beginTransaction();
            Fragment findFragmentByTag = getSupportFragmentManager().findFragmentByTag(this.jNP.CU(this.mCurrentPage));
            if (findFragmentByTag != null) {
                beginTransaction.hide(findFragmentByTag);
            }
            this.mCurrentPage = i;
            if (getSupportFragmentManager().findFragmentByTag(this.jNP.CU(i)) != null) {
                beginTransaction.show(this.jNP.CT(i));
            } else {
                beginTransaction.add(R.id.fragment, this.jNP.CT(i), this.jNP.CU(i));
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
        int maxImagesAllowed = this.jNO.getMaxImagesAllowed();
        if (this.jNO.size() < maxImagesAllowed) {
            if (this.jNR == null || this.jNR.g(imageFileInfo)) {
                ImageFileInfo imageFileInfo2 = new ImageFileInfo();
                imageFileInfo2.setAlbumnId(imageFileInfo.getAlbumId());
                imageFileInfo2.setFilePath(imageFileInfo.getFilePath());
                imageFileInfo2.setModifyTime(imageFileInfo.getModifyTime());
                imageFileInfo2.setIsGif(imageFileInfo.isGif());
                imageFileInfo2.setIsLong(imageFileInfo.isLong());
                this.jNO.a(null);
                this.jNO.addChooseFile(imageFileInfo2);
                cAi();
                return true;
            }
            return false;
        } else if (cAl()) {
            return e(imageFileInfo);
        } else {
            showToast(String.format(getPageContext().getContext().getString(R.string.max_choose_image_count), Integer.valueOf(maxImagesAllowed)));
            return false;
        }
    }

    public boolean cAl() {
        if (getIntent().getBooleanExtra(AlbumActivityConfig.IS_SELECT_DIRECTLY, false)) {
            int maxImagesAllowed = this.jNO.getMaxImagesAllowed();
            if (this.jNO.size() == maxImagesAllowed && maxImagesAllowed == 1) {
                try {
                    ImageFileInfo imageFileInfo = (ImageFileInfo) v.c(this.jNO.cAB(), 0);
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
        this.jNO.a(null);
        this.jNO.delChooseFile(imageFileInfo);
        cAi();
        return true;
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i == 4) {
            closeLoadingDialog();
            if (this.mCurrentPage == 0) {
                if (this.jNO != null) {
                    this.jNO.setLastAlbumId(null);
                }
                cAm();
                return true;
            } else if (this.mCurrentPage == 1) {
                CS(0);
                return true;
            } else {
                return true;
            }
        }
        return super.onKeyDown(i, keyEvent);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void f(ImageFileInfo imageFileInfo, boolean z) {
        Fragment CT;
        if (this.jNP != null && (CT = this.jNP.CT(0)) != null && (CT instanceof ImageListFragment)) {
            ((ImageListFragment) CT).h(imageFileInfo, z);
        }
    }

    void g(ImageFileInfo imageFileInfo, boolean z) {
        Fragment CT;
        if (this.jNP != null && (CT = this.jNP.CT(1)) != null && (CT instanceof AlbumImageBrowseFragment)) {
            ((AlbumImageBrowseFragment) CT).h(imageFileInfo, z);
        }
    }

    private void cAm() {
        Intent intent = new Intent();
        String lastAlbumId = this.jNO.getLastAlbumId();
        if (TextUtils.isEmpty(lastAlbumId)) {
            lastAlbumId = "";
        }
        intent.putExtra(AlbumActivityConfig.LAST_ALBUM_ID, lastAlbumId);
        intent.putExtra(AlbumActivityConfig.CAMERA_REQUEST_FROM, this.jNS);
        setResult(0, intent);
        finish();
    }

    private void stopCamera() {
        if (this.jNP != null) {
            this.jNP.stopCamera();
        }
    }

    private void aYW() {
        if (this.jNP != null) {
            this.jNP.aYW();
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
        this.jNQ = true;
        stopCamera();
        closeLoadingDialog();
        dismissAllDialog();
        d.cAF().destory();
        if (this.fwK != null) {
            this.fwK.setBackgroundDrawable(null);
        }
        if (this.jNP != null) {
            this.jNP.onDestroy();
        }
        if (this.jNY != null) {
            this.jNY.onDestroy();
        }
        Intent intent = new Intent();
        intent.setAction(AlbumActivityConfig.ACTION_SELECT_IMAGE_RESULT);
        intent.putExtra(AlbumActivityConfig.ALBUM_RESULT, this.jNO.getWriteImagesInfo().toJsonString());
        intent.putExtra(AlbumActivityConfig.CAMERA_REQUEST_FROM, this.jNS);
        intent.putExtra("from_type", this.jNX);
        if (this.jNV != null && !StringUtils.isNull(this.jNV.getStringExtra("file_name"))) {
            intent.putExtra("file_name", this.jNV.getStringExtra("file_name"));
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
            new com.baidu.tbadk.img.f(null).c(AlbumActivity.this.jNO.getWriteImagesInfo(), true);
            return AlbumActivity.this.jNO.getWriteImagesInfo().toJsonString();
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
        if (this.jNY != null) {
            this.jNY.onStart();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.adp.base.BdBaseFragmentActivity, android.support.v4.app.FragmentActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        aYW();
        if (this.jNY != null) {
            this.jNY.onResume();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.base.BdBaseFragmentActivity, android.support.v4.app.FragmentActivity, android.app.Activity
    public void onStop() {
        super.onStop();
        if (this.jNY != null) {
            this.jNY.onStop();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.adp.base.BdBaseFragmentActivity, android.support.v4.app.FragmentActivity, android.app.Activity
    public void onPause() {
        stopCamera();
        super.onPause();
    }
}
