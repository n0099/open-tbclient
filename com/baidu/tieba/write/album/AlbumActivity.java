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
import com.baidu.tieba.R;
import com.baidu.tieba.frs.ForumWriteData;
import java.util.LinkedList;
/* loaded from: classes3.dex */
public class AlbumActivity extends BaseFragmentActivity implements View.OnClickListener, a.InterfaceC0041a {
    private boolean fsX;
    private com.baidu.tieba.c.d hMV;
    private c jFE;
    private com.baidu.tieba.write.album.a jFF;
    private e jFH;
    private Intent jFL;
    private i jFO;
    private int mCurrentPage = 0;
    private boolean jFG = false;
    private String callFrom = "";
    private String from = "";
    private String forumName = "";
    private String forumId = "0";
    private int jFI = 0;
    private int jFJ = 0;
    private boolean jFK = false;
    private boolean jFM = false;
    private int jFN = 0;
    private View frn = null;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.adp.base.BdBaseFragmentActivity, android.support.v4.app.FragmentActivity, android.support.v4.app.SupportActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setSwipeBackEnabled(false);
        setContentView(R.layout.album_activity);
        this.frn = findViewById(R.id.statebar_view);
        this.fsX = UtilHelper.canUseStyleImmersiveSticky();
        aIz();
        initData(bundle);
        this.jFF = new com.baidu.tieba.write.album.a(this);
        this.jFF.brm();
        Cj(0);
    }

    public void showTip(View view) {
        if (this.hMV == null && view != null) {
            this.hMV = new com.baidu.tieba.c.d(getPageContext(), view);
            this.hMV.pK(R.drawable.bg_tip_blue_up_left);
            this.hMV.q(new View.OnClickListener() { // from class: com.baidu.tieba.write.album.AlbumActivity.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    AlbumActivity.this.hMV.aZA();
                }
            });
            this.hMV.pJ(16);
            this.hMV.pL(UIMsg.m_AppUI.MSG_APP_GPS);
        }
        if (this.hMV != null) {
            String sharedPrefKeyWithAccount = com.baidu.tbadk.core.sharedPref.b.getSharedPrefKeyWithAccount("key_show_take_photo_tip");
            this.hMV.cH(getString(R.string.album_take_photo_tip), sharedPrefKeyWithAccount);
        }
    }

    private void aIz() {
        if (this.frn != null) {
            if (this.fsX && this.frn.getLayoutParams() != null) {
                ViewGroup.LayoutParams layoutParams = this.frn.getLayoutParams();
                layoutParams.height = UtilHelper.getStatusBarHeight();
                this.frn.setLayoutParams(layoutParams);
                kd(true);
                return;
            }
            kd(false);
        }
    }

    private void kd(boolean z) {
        if (this.frn != null) {
            if (this.fsX && z && this.frn.getVisibility() != 0) {
                this.frn.setVisibility(0);
            } else if (!z && this.frn.getVisibility() != 8) {
                this.frn.setVisibility(8);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.support.v4.app.FragmentActivity, android.support.v4.app.SupportActivity, android.app.Activity
    public void onSaveInstanceState(Bundle bundle) {
        bundle.putString(AlbumActivityConfig.WRITE_IMAGES_INFO, this.jFE.getWriteImagesInfo().toJsonString());
        bundle.putBoolean(AlbumActivityConfig.USE_ORIGINAL_IMG, this.jFK);
        bundle.putInt(AlbumActivityConfig.CAMERA_REQUEST_FROM, this.jFI);
        bundle.putString("forum_id", this.forumId);
        bundle.putString("forum_name", this.forumName);
        bundle.putInt(IntentConfig.KEY_ALBUM_THREAD, this.jFJ);
        bundle.putBoolean(IntentConfig.KEY_FROM_WRITEACTIVITY, this.jFM);
    }

    private void initData(Bundle bundle) {
        this.jFE = new c(this);
        if (bundle != null) {
            WriteImagesInfo writeImagesInfo = new WriteImagesInfo();
            writeImagesInfo.parseJson(bundle.getString(AlbumActivityConfig.WRITE_IMAGES_INFO));
            this.jFE.setWriteImagesInfo(writeImagesInfo);
            this.jFK = bundle.getBoolean(AlbumActivityConfig.USE_ORIGINAL_IMG, false);
            this.jFI = bundle.getInt(AlbumActivityConfig.CAMERA_REQUEST_FROM, 0);
            this.forumId = bundle.getString("forum_id");
            this.forumName = bundle.getString("forum_name");
            this.jFJ = bundle.getInt(IntentConfig.KEY_ALBUM_THREAD);
            this.jFM = bundle.getBoolean(IntentConfig.KEY_FROM_WRITEACTIVITY);
            this.callFrom = bundle.getString("KEY_CALL_FROM");
            this.jFN = bundle.getInt("from_type");
        } else {
            Intent intent = getIntent();
            if (intent != null) {
                WriteImagesInfo writeImagesInfo2 = new WriteImagesInfo();
                writeImagesInfo2.parseJson(intent.getStringExtra(AlbumActivityConfig.WRITE_IMAGES_INFO));
                this.jFE.setWriteImagesInfo(writeImagesInfo2);
                this.jFE.setOriginalImg(writeImagesInfo2.isOriginalImg());
                this.jFK = intent.getBooleanExtra(AlbumActivityConfig.USE_ORIGINAL_IMG, false);
                this.jFI = intent.getIntExtra(AlbumActivityConfig.CAMERA_REQUEST_FROM, 0);
                this.from = intent.getStringExtra("from");
                this.forumId = intent.getStringExtra("forum_id");
                this.forumName = intent.getStringExtra("forum_name");
                this.jFJ = intent.getIntExtra(IntentConfig.KEY_ALBUM_THREAD, 0);
                this.jFM = intent.getBooleanExtra(IntentConfig.KEY_FROM_WRITEACTIVITY, false);
                this.callFrom = intent.getStringExtra("KEY_CALL_FROM");
                this.jFN = intent.getIntExtra("from_type", 0);
            }
        }
        cwH();
    }

    private void cwH() {
        if (this.jFI == 2) {
            this.jFH = new e() { // from class: com.baidu.tieba.write.album.AlbumActivity.2
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
        if (this.jFF != null) {
            this.jFF.onChangeSkinType(i);
        }
        al.h(this.frn, R.color.cp_bg_line_d, i);
    }

    public void cwI() {
        if (this.jFI == 3) {
            TiebaStatic.log("c10489");
        }
        if (this.jFI == 5) {
            showLoadingDialog("正在上传");
            new a().execute(new String[0]);
        } else if (this.jFE != null) {
            if (this.jFO == null || !this.jFO.cxv()) {
                if (this.jFE.cxd()) {
                    VideoFileInfo cxb = this.jFE.cxb();
                    if (this.jFO == null) {
                        this.jFO = new i(this, this.forumName, this.forumId, "");
                        if (this.jFF != null) {
                            this.jFF.a(this.jFO);
                        }
                    }
                    if (getIntent() != null) {
                        this.jFO.setProfessionZone(getIntent().getIntExtra(WriteActivityConfig.KEY_PROFESSION_ZONE, -1));
                    }
                    this.jFO.a(cxb, this.callFrom);
                } else if (cwJ()) {
                    cwK();
                } else {
                    az(null);
                }
            }
        }
    }

    private boolean cwJ() {
        if (this.jFE == null || v.Z(this.jFE.cxf()) == 0) {
            return false;
        }
        int i = 0;
        for (ImageFileInfo imageFileInfo : this.jFE.cxf()) {
            if (imageFileInfo != null && imageFileInfo.getImageType() == 0 && (i = i + 1) >= 2) {
                return false;
            }
            i = i;
        }
        return i == 1;
    }

    private void az(Intent intent) {
        Intent intent2 = new Intent();
        intent2.putExtra(AlbumActivityConfig.ALBUM_RESULT, this.jFE.getWriteImagesInfo().toJsonString());
        intent2.putExtra(AlbumActivityConfig.CAMERA_REQUEST_FROM, this.jFI);
        intent2.putExtra("from_type", this.jFN);
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
            this.jFE.getWriteImagesInfo().setChosedFiles(linkedList);
            intent.putExtra(AlbumActivityConfig.ALBUM_RESULT, this.jFE.getWriteImagesInfo().toJsonString());
            intent.putExtra(AlbumActivityConfig.CAMERA_REQUEST_FROM, this.jFI);
            intent.putExtra("from_type", this.jFN);
            setResult(-1, intent);
            finish();
        }
    }

    private boolean aPw() {
        Activity pageActivity = getPageContext().getPageActivity();
        com.baidu.tbadk.core.util.b.a aVar = new com.baidu.tbadk.core.util.b.a();
        aVar.aiM();
        aVar.e(pageActivity, "android.permission.CAMERA");
        aVar.e(pageActivity, "android.permission.RECORD_AUDIO");
        aVar.e(pageActivity, "android.permission.WRITE_EXTERNAL_STORAGE");
        return aVar.aa(pageActivity);
    }

    public void c(TbPageContext tbPageContext) {
        if (!aPw() && com.baidu.tieba.write.i.cwB()) {
            sendMessage(new CustomMessage(2002001, new RecordVideoActivityConfig(tbPageContext.getPageActivity(), this.jFM ? 2 : 3, new ForumWriteData(this.forumId, this.forumName, null, null), this.jFE.getWriteImagesInfo(), "", this.jFN)));
            TiebaStatic.log(new am("c12611").P("obj_locate", 5).P("obj_type", 2));
        }
    }

    private void cwK() {
        WriteImagesInfo writeImagesInfo;
        if (this.jFE != null && (writeImagesInfo = this.jFE.getWriteImagesInfo()) != null) {
            sendMessage(new CustomMessage(2002001, new WriteMulitImageActivityConfig(getPageContext().getPageActivity(), IEventCenterService.EventId.EventMode.SAPIACCOUNT_THROUGH_SERVER, writeImagesInfo, cwL())));
        }
    }

    private int cwL() {
        if (this.jFE == null || v.Z(this.jFE.cxf()) == 0) {
            return 0;
        }
        for (int i = 0; i < v.Z(this.jFE.cxf()); i++) {
            ImageFileInfo imageFileInfo = this.jFE.cxf().get(i);
            if (imageFileInfo != null && imageFileInfo.getImageType() == 0) {
                return i;
            }
        }
        return 0;
    }

    private void aA(Intent intent) {
        this.jFL = intent;
        if (intent == null || this.jFE == null) {
            az(null);
            return;
        }
        String stringExtra = intent.getStringExtra(AlbumActivityConfig.ALBUM_RESULT);
        if (stringExtra != null) {
            WriteImagesInfo writeImagesInfo = this.jFE.getWriteImagesInfo();
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
        if (view == this.jFF.cwT()) {
            cwI();
        } else if (view == this.jFF.cwV()) {
            cwI();
        } else if (view == this.jFF.cwS()) {
            if (this.jFE != null) {
                this.jFE.setLastAlbumId(null);
            }
            cwQ();
        } else if (view == this.jFF.cwU()) {
            Cj(0);
        } else if (view == this.jFF.cwW()) {
            Ch(2);
        } else if (view == this.jFF.cwX()) {
            Ch(1);
        }
    }

    private void Ch(int i) {
        if (this.jFF != null && this.jFE != null) {
            this.jFE.setOriginalImg(!this.jFE.isOriginalImg());
            cwM();
            Ci(i);
        }
    }

    private void Ci(int i) {
        if (this.jFE != null && this.jFE.isOriginalImg() && !StringUtils.isNull(this.from, true) && !StringUtils.isNull(this.forumId, true)) {
            TiebaStatic.log(new am("c10349").bT("fid", this.forumId).bT("obj_type", this.from).P("obj_locate", i));
        }
    }

    public void cwM() {
        if (this.jFE != null && this.jFF != null) {
            this.jFF.rP(this.jFE.isOriginalImg());
        }
    }

    public View bky() {
        return this.frn;
    }

    public int cwN() {
        return this.jFJ;
    }

    public c cwO() {
        return this.jFE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void Cj(int i) {
        if (!this.jFG) {
            FragmentTransaction beginTransaction = getSupportFragmentManager().beginTransaction();
            Fragment findFragmentByTag = getSupportFragmentManager().findFragmentByTag(this.jFF.Cl(this.mCurrentPage));
            if (findFragmentByTag != null) {
                beginTransaction.hide(findFragmentByTag);
            }
            this.mCurrentPage = i;
            if (getSupportFragmentManager().findFragmentByTag(this.jFF.Cl(i)) != null) {
                beginTransaction.show(this.jFF.Ck(i));
            } else {
                beginTransaction.add(R.id.fragment, this.jFF.Ck(i), this.jFF.Cl(i));
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
        int maxImagesAllowed = this.jFE.getMaxImagesAllowed();
        if (this.jFE.size() < maxImagesAllowed) {
            if (this.jFH == null || this.jFH.g(imageFileInfo)) {
                ImageFileInfo imageFileInfo2 = new ImageFileInfo();
                imageFileInfo2.setAlbumnId(imageFileInfo.getAlbumId());
                imageFileInfo2.setFilePath(imageFileInfo.getFilePath());
                imageFileInfo2.setModifyTime(imageFileInfo.getModifyTime());
                imageFileInfo2.setIsGif(imageFileInfo.isGif());
                imageFileInfo2.setIsLong(imageFileInfo.isLong());
                this.jFE.a(null);
                this.jFE.addChooseFile(imageFileInfo2);
                cwM();
                return true;
            }
            return false;
        } else if (cwP()) {
            return e(imageFileInfo);
        } else {
            showToast(String.format(getPageContext().getContext().getString(R.string.max_choose_image_count), Integer.valueOf(maxImagesAllowed)));
            return false;
        }
    }

    public boolean cwP() {
        if (getIntent().getBooleanExtra(AlbumActivityConfig.IS_SELECT_DIRECTLY, false)) {
            int maxImagesAllowed = this.jFE.getMaxImagesAllowed();
            if (this.jFE.size() == maxImagesAllowed && maxImagesAllowed == 1) {
                try {
                    ImageFileInfo imageFileInfo = (ImageFileInfo) v.c(this.jFE.cxf(), 0);
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
        this.jFE.a(null);
        this.jFE.delChooseFile(imageFileInfo);
        cwM();
        return true;
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i == 4) {
            closeLoadingDialog();
            if (this.mCurrentPage == 0) {
                if (this.jFE != null) {
                    this.jFE.setLastAlbumId(null);
                }
                cwQ();
                return true;
            } else if (this.mCurrentPage == 1) {
                Cj(0);
                return true;
            } else {
                return true;
            }
        }
        return super.onKeyDown(i, keyEvent);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void f(ImageFileInfo imageFileInfo, boolean z) {
        Fragment Ck;
        if (this.jFF != null && (Ck = this.jFF.Ck(0)) != null && (Ck instanceof ImageListFragment)) {
            ((ImageListFragment) Ck).h(imageFileInfo, z);
        }
    }

    void g(ImageFileInfo imageFileInfo, boolean z) {
        Fragment Ck;
        if (this.jFF != null && (Ck = this.jFF.Ck(1)) != null && (Ck instanceof AlbumImageBrowseFragment)) {
            ((AlbumImageBrowseFragment) Ck).h(imageFileInfo, z);
        }
    }

    private void cwQ() {
        Intent intent = new Intent();
        String lastAlbumId = this.jFE.getLastAlbumId();
        if (TextUtils.isEmpty(lastAlbumId)) {
            lastAlbumId = "";
        }
        intent.putExtra(AlbumActivityConfig.LAST_ALBUM_ID, lastAlbumId);
        intent.putExtra(AlbumActivityConfig.CAMERA_REQUEST_FROM, this.jFI);
        setResult(0, intent);
        finish();
    }

    private void stopCamera() {
        if (this.jFF != null) {
            this.jFF.stopCamera();
        }
    }

    private void aWY() {
        if (this.jFF != null) {
            this.jFF.aWY();
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
        this.jFG = true;
        stopCamera();
        closeLoadingDialog();
        dismissAllDialog();
        d.cxj().destory();
        if (this.frn != null) {
            this.frn.setBackgroundDrawable(null);
        }
        if (this.jFF != null) {
            this.jFF.onDestroy();
        }
        if (this.jFO != null) {
            this.jFO.onDestroy();
        }
        Intent intent = new Intent();
        intent.setAction(AlbumActivityConfig.ACTION_SELECT_IMAGE_RESULT);
        intent.putExtra(AlbumActivityConfig.ALBUM_RESULT, this.jFE.getWriteImagesInfo().toJsonString());
        intent.putExtra(AlbumActivityConfig.CAMERA_REQUEST_FROM, this.jFI);
        intent.putExtra("from_type", this.jFN);
        if (this.jFL != null && !StringUtils.isNull(this.jFL.getStringExtra("file_name"))) {
            intent.putExtra("file_name", this.jFL.getStringExtra("file_name"));
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
            new com.baidu.tbadk.img.f(null).c(AlbumActivity.this.jFE.getWriteImagesInfo(), true);
            return AlbumActivity.this.jFE.getWriteImagesInfo().toJsonString();
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
        if (this.jFO != null) {
            this.jFO.onStart();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.adp.base.BdBaseFragmentActivity, android.support.v4.app.FragmentActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        aWY();
        if (this.jFO != null) {
            this.jFO.onResume();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.base.BdBaseFragmentActivity, android.support.v4.app.FragmentActivity, android.app.Activity
    public void onStop() {
        super.onStop();
        if (this.jFO != null) {
            this.jFO.onStop();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.adp.base.BdBaseFragmentActivity, android.support.v4.app.FragmentActivity, android.app.Activity
    public void onPause() {
        stopCamera();
        super.onPause();
    }
}
