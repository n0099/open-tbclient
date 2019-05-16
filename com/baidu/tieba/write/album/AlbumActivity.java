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
    private boolean fsW;
    private com.baidu.tieba.c.d hMR;
    private c jFA;
    private com.baidu.tieba.write.album.a jFB;
    private e jFD;
    private Intent jFH;
    private i jFK;
    private int mCurrentPage = 0;
    private boolean jFC = false;
    private String callFrom = "";
    private String from = "";
    private String forumName = "";
    private String forumId = "0";
    private int jFE = 0;
    private int jFF = 0;
    private boolean jFG = false;
    private boolean jFI = false;
    private int jFJ = 0;
    private View frm = null;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.adp.base.BdBaseFragmentActivity, android.support.v4.app.FragmentActivity, android.support.v4.app.SupportActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setSwipeBackEnabled(false);
        setContentView(R.layout.album_activity);
        this.frm = findViewById(R.id.statebar_view);
        this.fsW = UtilHelper.canUseStyleImmersiveSticky();
        aIw();
        initData(bundle);
        this.jFB = new com.baidu.tieba.write.album.a(this);
        this.jFB.brh();
        Cj(0);
    }

    public void showTip(View view) {
        if (this.hMR == null && view != null) {
            this.hMR = new com.baidu.tieba.c.d(getPageContext(), view);
            this.hMR.pK(R.drawable.bg_tip_blue_up_left);
            this.hMR.q(new View.OnClickListener() { // from class: com.baidu.tieba.write.album.AlbumActivity.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    AlbumActivity.this.hMR.aZx();
                }
            });
            this.hMR.pJ(16);
            this.hMR.pL(UIMsg.m_AppUI.MSG_APP_GPS);
        }
        if (this.hMR != null) {
            String sharedPrefKeyWithAccount = com.baidu.tbadk.core.sharedPref.b.getSharedPrefKeyWithAccount("key_show_take_photo_tip");
            this.hMR.cH(getString(R.string.album_take_photo_tip), sharedPrefKeyWithAccount);
        }
    }

    private void aIw() {
        if (this.frm != null) {
            if (this.fsW && this.frm.getLayoutParams() != null) {
                ViewGroup.LayoutParams layoutParams = this.frm.getLayoutParams();
                layoutParams.height = UtilHelper.getStatusBarHeight();
                this.frm.setLayoutParams(layoutParams);
                kd(true);
                return;
            }
            kd(false);
        }
    }

    private void kd(boolean z) {
        if (this.frm != null) {
            if (this.fsW && z && this.frm.getVisibility() != 0) {
                this.frm.setVisibility(0);
            } else if (!z && this.frm.getVisibility() != 8) {
                this.frm.setVisibility(8);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.support.v4.app.FragmentActivity, android.support.v4.app.SupportActivity, android.app.Activity
    public void onSaveInstanceState(Bundle bundle) {
        bundle.putString(AlbumActivityConfig.WRITE_IMAGES_INFO, this.jFA.getWriteImagesInfo().toJsonString());
        bundle.putBoolean(AlbumActivityConfig.USE_ORIGINAL_IMG, this.jFG);
        bundle.putInt(AlbumActivityConfig.CAMERA_REQUEST_FROM, this.jFE);
        bundle.putString("forum_id", this.forumId);
        bundle.putString("forum_name", this.forumName);
        bundle.putInt(IntentConfig.KEY_ALBUM_THREAD, this.jFF);
        bundle.putBoolean(IntentConfig.KEY_FROM_WRITEACTIVITY, this.jFI);
    }

    private void initData(Bundle bundle) {
        this.jFA = new c(this);
        if (bundle != null) {
            WriteImagesInfo writeImagesInfo = new WriteImagesInfo();
            writeImagesInfo.parseJson(bundle.getString(AlbumActivityConfig.WRITE_IMAGES_INFO));
            this.jFA.setWriteImagesInfo(writeImagesInfo);
            this.jFG = bundle.getBoolean(AlbumActivityConfig.USE_ORIGINAL_IMG, false);
            this.jFE = bundle.getInt(AlbumActivityConfig.CAMERA_REQUEST_FROM, 0);
            this.forumId = bundle.getString("forum_id");
            this.forumName = bundle.getString("forum_name");
            this.jFF = bundle.getInt(IntentConfig.KEY_ALBUM_THREAD);
            this.jFI = bundle.getBoolean(IntentConfig.KEY_FROM_WRITEACTIVITY);
            this.callFrom = bundle.getString("KEY_CALL_FROM");
            this.jFJ = bundle.getInt("from_type");
        } else {
            Intent intent = getIntent();
            if (intent != null) {
                WriteImagesInfo writeImagesInfo2 = new WriteImagesInfo();
                writeImagesInfo2.parseJson(intent.getStringExtra(AlbumActivityConfig.WRITE_IMAGES_INFO));
                this.jFA.setWriteImagesInfo(writeImagesInfo2);
                this.jFA.setOriginalImg(writeImagesInfo2.isOriginalImg());
                this.jFG = intent.getBooleanExtra(AlbumActivityConfig.USE_ORIGINAL_IMG, false);
                this.jFE = intent.getIntExtra(AlbumActivityConfig.CAMERA_REQUEST_FROM, 0);
                this.from = intent.getStringExtra("from");
                this.forumId = intent.getStringExtra("forum_id");
                this.forumName = intent.getStringExtra("forum_name");
                this.jFF = intent.getIntExtra(IntentConfig.KEY_ALBUM_THREAD, 0);
                this.jFI = intent.getBooleanExtra(IntentConfig.KEY_FROM_WRITEACTIVITY, false);
                this.callFrom = intent.getStringExtra("KEY_CALL_FROM");
                this.jFJ = intent.getIntExtra("from_type", 0);
            }
        }
        cwG();
    }

    private void cwG() {
        if (this.jFE == 2) {
            this.jFD = new e() { // from class: com.baidu.tieba.write.album.AlbumActivity.2
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
        if (this.jFB != null) {
            this.jFB.onChangeSkinType(i);
        }
        al.h(this.frm, R.color.cp_bg_line_d, i);
    }

    public void cwH() {
        if (this.jFE == 3) {
            TiebaStatic.log("c10489");
        }
        if (this.jFE == 5) {
            showLoadingDialog("正在上传");
            new a().execute(new String[0]);
        } else if (this.jFA != null) {
            if (this.jFK == null || !this.jFK.cxu()) {
                if (this.jFA.cxc()) {
                    VideoFileInfo cxa = this.jFA.cxa();
                    if (this.jFK == null) {
                        this.jFK = new i(this, this.forumName, this.forumId, "");
                        if (this.jFB != null) {
                            this.jFB.a(this.jFK);
                        }
                    }
                    if (getIntent() != null) {
                        this.jFK.setProfessionZone(getIntent().getIntExtra(WriteActivityConfig.KEY_PROFESSION_ZONE, -1));
                    }
                    this.jFK.a(cxa, this.callFrom);
                } else if (cwI()) {
                    cwJ();
                } else {
                    az(null);
                }
            }
        }
    }

    private boolean cwI() {
        if (this.jFA == null || v.Z(this.jFA.cxe()) == 0) {
            return false;
        }
        int i = 0;
        for (ImageFileInfo imageFileInfo : this.jFA.cxe()) {
            if (imageFileInfo != null && imageFileInfo.getImageType() == 0 && (i = i + 1) >= 2) {
                return false;
            }
            i = i;
        }
        return i == 1;
    }

    private void az(Intent intent) {
        Intent intent2 = new Intent();
        intent2.putExtra(AlbumActivityConfig.ALBUM_RESULT, this.jFA.getWriteImagesInfo().toJsonString());
        intent2.putExtra(AlbumActivityConfig.CAMERA_REQUEST_FROM, this.jFE);
        intent2.putExtra("from_type", this.jFJ);
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
            this.jFA.getWriteImagesInfo().setChosedFiles(linkedList);
            intent.putExtra(AlbumActivityConfig.ALBUM_RESULT, this.jFA.getWriteImagesInfo().toJsonString());
            intent.putExtra(AlbumActivityConfig.CAMERA_REQUEST_FROM, this.jFE);
            intent.putExtra("from_type", this.jFJ);
            setResult(-1, intent);
            finish();
        }
    }

    private boolean aPt() {
        Activity pageActivity = getPageContext().getPageActivity();
        com.baidu.tbadk.core.util.b.a aVar = new com.baidu.tbadk.core.util.b.a();
        aVar.aiM();
        aVar.e(pageActivity, "android.permission.CAMERA");
        aVar.e(pageActivity, "android.permission.RECORD_AUDIO");
        aVar.e(pageActivity, "android.permission.WRITE_EXTERNAL_STORAGE");
        return aVar.aa(pageActivity);
    }

    public void c(TbPageContext tbPageContext) {
        if (!aPt() && com.baidu.tieba.write.i.cwA()) {
            sendMessage(new CustomMessage(2002001, new RecordVideoActivityConfig(tbPageContext.getPageActivity(), this.jFI ? 2 : 3, new ForumWriteData(this.forumId, this.forumName, null, null), this.jFA.getWriteImagesInfo(), "", this.jFJ)));
            TiebaStatic.log(new am("c12611").P("obj_locate", 5).P("obj_type", 2));
        }
    }

    private void cwJ() {
        WriteImagesInfo writeImagesInfo;
        if (this.jFA != null && (writeImagesInfo = this.jFA.getWriteImagesInfo()) != null) {
            sendMessage(new CustomMessage(2002001, new WriteMulitImageActivityConfig(getPageContext().getPageActivity(), IEventCenterService.EventId.EventMode.SAPIACCOUNT_THROUGH_SERVER, writeImagesInfo, cwK())));
        }
    }

    private int cwK() {
        if (this.jFA == null || v.Z(this.jFA.cxe()) == 0) {
            return 0;
        }
        for (int i = 0; i < v.Z(this.jFA.cxe()); i++) {
            ImageFileInfo imageFileInfo = this.jFA.cxe().get(i);
            if (imageFileInfo != null && imageFileInfo.getImageType() == 0) {
                return i;
            }
        }
        return 0;
    }

    private void aA(Intent intent) {
        this.jFH = intent;
        if (intent == null || this.jFA == null) {
            az(null);
            return;
        }
        String stringExtra = intent.getStringExtra(AlbumActivityConfig.ALBUM_RESULT);
        if (stringExtra != null) {
            WriteImagesInfo writeImagesInfo = this.jFA.getWriteImagesInfo();
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
        if (view == this.jFB.cwS()) {
            cwH();
        } else if (view == this.jFB.cwU()) {
            cwH();
        } else if (view == this.jFB.cwR()) {
            if (this.jFA != null) {
                this.jFA.setLastAlbumId(null);
            }
            cwP();
        } else if (view == this.jFB.cwT()) {
            Cj(0);
        } else if (view == this.jFB.cwV()) {
            Ch(2);
        } else if (view == this.jFB.cwW()) {
            Ch(1);
        }
    }

    private void Ch(int i) {
        if (this.jFB != null && this.jFA != null) {
            this.jFA.setOriginalImg(!this.jFA.isOriginalImg());
            cwL();
            Ci(i);
        }
    }

    private void Ci(int i) {
        if (this.jFA != null && this.jFA.isOriginalImg() && !StringUtils.isNull(this.from, true) && !StringUtils.isNull(this.forumId, true)) {
            TiebaStatic.log(new am("c10349").bT("fid", this.forumId).bT("obj_type", this.from).P("obj_locate", i));
        }
    }

    public void cwL() {
        if (this.jFA != null && this.jFB != null) {
            this.jFB.rO(this.jFA.isOriginalImg());
        }
    }

    public View bkv() {
        return this.frm;
    }

    public int cwM() {
        return this.jFF;
    }

    public c cwN() {
        return this.jFA;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void Cj(int i) {
        if (!this.jFC) {
            FragmentTransaction beginTransaction = getSupportFragmentManager().beginTransaction();
            Fragment findFragmentByTag = getSupportFragmentManager().findFragmentByTag(this.jFB.Cl(this.mCurrentPage));
            if (findFragmentByTag != null) {
                beginTransaction.hide(findFragmentByTag);
            }
            this.mCurrentPage = i;
            if (getSupportFragmentManager().findFragmentByTag(this.jFB.Cl(i)) != null) {
                beginTransaction.show(this.jFB.Ck(i));
            } else {
                beginTransaction.add(R.id.fragment, this.jFB.Ck(i), this.jFB.Cl(i));
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
        int maxImagesAllowed = this.jFA.getMaxImagesAllowed();
        if (this.jFA.size() < maxImagesAllowed) {
            if (this.jFD == null || this.jFD.g(imageFileInfo)) {
                ImageFileInfo imageFileInfo2 = new ImageFileInfo();
                imageFileInfo2.setAlbumnId(imageFileInfo.getAlbumId());
                imageFileInfo2.setFilePath(imageFileInfo.getFilePath());
                imageFileInfo2.setModifyTime(imageFileInfo.getModifyTime());
                imageFileInfo2.setIsGif(imageFileInfo.isGif());
                imageFileInfo2.setIsLong(imageFileInfo.isLong());
                this.jFA.a(null);
                this.jFA.addChooseFile(imageFileInfo2);
                cwL();
                return true;
            }
            return false;
        } else if (cwO()) {
            return e(imageFileInfo);
        } else {
            showToast(String.format(getPageContext().getContext().getString(R.string.max_choose_image_count), Integer.valueOf(maxImagesAllowed)));
            return false;
        }
    }

    public boolean cwO() {
        if (getIntent().getBooleanExtra(AlbumActivityConfig.IS_SELECT_DIRECTLY, false)) {
            int maxImagesAllowed = this.jFA.getMaxImagesAllowed();
            if (this.jFA.size() == maxImagesAllowed && maxImagesAllowed == 1) {
                try {
                    ImageFileInfo imageFileInfo = (ImageFileInfo) v.c(this.jFA.cxe(), 0);
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
        this.jFA.a(null);
        this.jFA.delChooseFile(imageFileInfo);
        cwL();
        return true;
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i == 4) {
            closeLoadingDialog();
            if (this.mCurrentPage == 0) {
                if (this.jFA != null) {
                    this.jFA.setLastAlbumId(null);
                }
                cwP();
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
        if (this.jFB != null && (Ck = this.jFB.Ck(0)) != null && (Ck instanceof ImageListFragment)) {
            ((ImageListFragment) Ck).h(imageFileInfo, z);
        }
    }

    void g(ImageFileInfo imageFileInfo, boolean z) {
        Fragment Ck;
        if (this.jFB != null && (Ck = this.jFB.Ck(1)) != null && (Ck instanceof AlbumImageBrowseFragment)) {
            ((AlbumImageBrowseFragment) Ck).h(imageFileInfo, z);
        }
    }

    private void cwP() {
        Intent intent = new Intent();
        String lastAlbumId = this.jFA.getLastAlbumId();
        if (TextUtils.isEmpty(lastAlbumId)) {
            lastAlbumId = "";
        }
        intent.putExtra(AlbumActivityConfig.LAST_ALBUM_ID, lastAlbumId);
        intent.putExtra(AlbumActivityConfig.CAMERA_REQUEST_FROM, this.jFE);
        setResult(0, intent);
        finish();
    }

    private void stopCamera() {
        if (this.jFB != null) {
            this.jFB.stopCamera();
        }
    }

    private void aWV() {
        if (this.jFB != null) {
            this.jFB.aWV();
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
        this.jFC = true;
        stopCamera();
        closeLoadingDialog();
        dismissAllDialog();
        d.cxi().destory();
        if (this.frm != null) {
            this.frm.setBackgroundDrawable(null);
        }
        if (this.jFB != null) {
            this.jFB.onDestroy();
        }
        if (this.jFK != null) {
            this.jFK.onDestroy();
        }
        Intent intent = new Intent();
        intent.setAction(AlbumActivityConfig.ACTION_SELECT_IMAGE_RESULT);
        intent.putExtra(AlbumActivityConfig.ALBUM_RESULT, this.jFA.getWriteImagesInfo().toJsonString());
        intent.putExtra(AlbumActivityConfig.CAMERA_REQUEST_FROM, this.jFE);
        intent.putExtra("from_type", this.jFJ);
        if (this.jFH != null && !StringUtils.isNull(this.jFH.getStringExtra("file_name"))) {
            intent.putExtra("file_name", this.jFH.getStringExtra("file_name"));
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
            new com.baidu.tbadk.img.f(null).c(AlbumActivity.this.jFA.getWriteImagesInfo(), true);
            return AlbumActivity.this.jFA.getWriteImagesInfo().toJsonString();
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
        if (this.jFK != null) {
            this.jFK.onStart();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.adp.base.BdBaseFragmentActivity, android.support.v4.app.FragmentActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        aWV();
        if (this.jFK != null) {
            this.jFK.onResume();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.base.BdBaseFragmentActivity, android.support.v4.app.FragmentActivity, android.app.Activity
    public void onStop() {
        super.onStop();
        if (this.jFK != null) {
            this.jFK.onStop();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.adp.base.BdBaseFragmentActivity, android.support.v4.app.FragmentActivity, android.app.Activity
    public void onPause() {
        stopCamera();
        super.onPause();
    }
}
