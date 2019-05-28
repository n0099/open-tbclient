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
    private com.baidu.tieba.c.d hMU;
    private c jFB;
    private com.baidu.tieba.write.album.a jFC;
    private e jFE;
    private Intent jFI;
    private i jFL;
    private int mCurrentPage = 0;
    private boolean jFD = false;
    private String callFrom = "";
    private String from = "";
    private String forumName = "";
    private String forumId = "0";
    private int jFF = 0;
    private int jFG = 0;
    private boolean jFH = false;
    private boolean jFJ = false;
    private int jFK = 0;
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
        this.jFC = new com.baidu.tieba.write.album.a(this);
        this.jFC.brk();
        Cj(0);
    }

    public void showTip(View view) {
        if (this.hMU == null && view != null) {
            this.hMU = new com.baidu.tieba.c.d(getPageContext(), view);
            this.hMU.pK(R.drawable.bg_tip_blue_up_left);
            this.hMU.q(new View.OnClickListener() { // from class: com.baidu.tieba.write.album.AlbumActivity.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    AlbumActivity.this.hMU.aZA();
                }
            });
            this.hMU.pJ(16);
            this.hMU.pL(UIMsg.m_AppUI.MSG_APP_GPS);
        }
        if (this.hMU != null) {
            String sharedPrefKeyWithAccount = com.baidu.tbadk.core.sharedPref.b.getSharedPrefKeyWithAccount("key_show_take_photo_tip");
            this.hMU.cH(getString(R.string.album_take_photo_tip), sharedPrefKeyWithAccount);
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
        bundle.putString(AlbumActivityConfig.WRITE_IMAGES_INFO, this.jFB.getWriteImagesInfo().toJsonString());
        bundle.putBoolean(AlbumActivityConfig.USE_ORIGINAL_IMG, this.jFH);
        bundle.putInt(AlbumActivityConfig.CAMERA_REQUEST_FROM, this.jFF);
        bundle.putString("forum_id", this.forumId);
        bundle.putString("forum_name", this.forumName);
        bundle.putInt(IntentConfig.KEY_ALBUM_THREAD, this.jFG);
        bundle.putBoolean(IntentConfig.KEY_FROM_WRITEACTIVITY, this.jFJ);
    }

    private void initData(Bundle bundle) {
        this.jFB = new c(this);
        if (bundle != null) {
            WriteImagesInfo writeImagesInfo = new WriteImagesInfo();
            writeImagesInfo.parseJson(bundle.getString(AlbumActivityConfig.WRITE_IMAGES_INFO));
            this.jFB.setWriteImagesInfo(writeImagesInfo);
            this.jFH = bundle.getBoolean(AlbumActivityConfig.USE_ORIGINAL_IMG, false);
            this.jFF = bundle.getInt(AlbumActivityConfig.CAMERA_REQUEST_FROM, 0);
            this.forumId = bundle.getString("forum_id");
            this.forumName = bundle.getString("forum_name");
            this.jFG = bundle.getInt(IntentConfig.KEY_ALBUM_THREAD);
            this.jFJ = bundle.getBoolean(IntentConfig.KEY_FROM_WRITEACTIVITY);
            this.callFrom = bundle.getString("KEY_CALL_FROM");
            this.jFK = bundle.getInt("from_type");
        } else {
            Intent intent = getIntent();
            if (intent != null) {
                WriteImagesInfo writeImagesInfo2 = new WriteImagesInfo();
                writeImagesInfo2.parseJson(intent.getStringExtra(AlbumActivityConfig.WRITE_IMAGES_INFO));
                this.jFB.setWriteImagesInfo(writeImagesInfo2);
                this.jFB.setOriginalImg(writeImagesInfo2.isOriginalImg());
                this.jFH = intent.getBooleanExtra(AlbumActivityConfig.USE_ORIGINAL_IMG, false);
                this.jFF = intent.getIntExtra(AlbumActivityConfig.CAMERA_REQUEST_FROM, 0);
                this.from = intent.getStringExtra("from");
                this.forumId = intent.getStringExtra("forum_id");
                this.forumName = intent.getStringExtra("forum_name");
                this.jFG = intent.getIntExtra(IntentConfig.KEY_ALBUM_THREAD, 0);
                this.jFJ = intent.getBooleanExtra(IntentConfig.KEY_FROM_WRITEACTIVITY, false);
                this.callFrom = intent.getStringExtra("KEY_CALL_FROM");
                this.jFK = intent.getIntExtra("from_type", 0);
            }
        }
        cwI();
    }

    private void cwI() {
        if (this.jFF == 2) {
            this.jFE = new e() { // from class: com.baidu.tieba.write.album.AlbumActivity.2
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
        if (this.jFC != null) {
            this.jFC.onChangeSkinType(i);
        }
        al.h(this.frn, R.color.cp_bg_line_d, i);
    }

    public void cwJ() {
        if (this.jFF == 3) {
            TiebaStatic.log("c10489");
        }
        if (this.jFF == 5) {
            showLoadingDialog("正在上传");
            new a().execute(new String[0]);
        } else if (this.jFB != null) {
            if (this.jFL == null || !this.jFL.cxw()) {
                if (this.jFB.cxe()) {
                    VideoFileInfo cxc = this.jFB.cxc();
                    if (this.jFL == null) {
                        this.jFL = new i(this, this.forumName, this.forumId, "");
                        if (this.jFC != null) {
                            this.jFC.a(this.jFL);
                        }
                    }
                    if (getIntent() != null) {
                        this.jFL.setProfessionZone(getIntent().getIntExtra(WriteActivityConfig.KEY_PROFESSION_ZONE, -1));
                    }
                    this.jFL.a(cxc, this.callFrom);
                } else if (cwK()) {
                    cwL();
                } else {
                    az(null);
                }
            }
        }
    }

    private boolean cwK() {
        if (this.jFB == null || v.Z(this.jFB.cxg()) == 0) {
            return false;
        }
        int i = 0;
        for (ImageFileInfo imageFileInfo : this.jFB.cxg()) {
            if (imageFileInfo != null && imageFileInfo.getImageType() == 0 && (i = i + 1) >= 2) {
                return false;
            }
            i = i;
        }
        return i == 1;
    }

    private void az(Intent intent) {
        Intent intent2 = new Intent();
        intent2.putExtra(AlbumActivityConfig.ALBUM_RESULT, this.jFB.getWriteImagesInfo().toJsonString());
        intent2.putExtra(AlbumActivityConfig.CAMERA_REQUEST_FROM, this.jFF);
        intent2.putExtra("from_type", this.jFK);
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
            this.jFB.getWriteImagesInfo().setChosedFiles(linkedList);
            intent.putExtra(AlbumActivityConfig.ALBUM_RESULT, this.jFB.getWriteImagesInfo().toJsonString());
            intent.putExtra(AlbumActivityConfig.CAMERA_REQUEST_FROM, this.jFF);
            intent.putExtra("from_type", this.jFK);
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
        if (!aPw() && com.baidu.tieba.write.i.cwC()) {
            sendMessage(new CustomMessage(2002001, new RecordVideoActivityConfig(tbPageContext.getPageActivity(), this.jFJ ? 2 : 3, new ForumWriteData(this.forumId, this.forumName, null, null), this.jFB.getWriteImagesInfo(), "", this.jFK)));
            TiebaStatic.log(new am("c12611").P("obj_locate", 5).P("obj_type", 2));
        }
    }

    private void cwL() {
        WriteImagesInfo writeImagesInfo;
        if (this.jFB != null && (writeImagesInfo = this.jFB.getWriteImagesInfo()) != null) {
            sendMessage(new CustomMessage(2002001, new WriteMulitImageActivityConfig(getPageContext().getPageActivity(), IEventCenterService.EventId.EventMode.SAPIACCOUNT_THROUGH_SERVER, writeImagesInfo, cwM())));
        }
    }

    private int cwM() {
        if (this.jFB == null || v.Z(this.jFB.cxg()) == 0) {
            return 0;
        }
        for (int i = 0; i < v.Z(this.jFB.cxg()); i++) {
            ImageFileInfo imageFileInfo = this.jFB.cxg().get(i);
            if (imageFileInfo != null && imageFileInfo.getImageType() == 0) {
                return i;
            }
        }
        return 0;
    }

    private void aA(Intent intent) {
        this.jFI = intent;
        if (intent == null || this.jFB == null) {
            az(null);
            return;
        }
        String stringExtra = intent.getStringExtra(AlbumActivityConfig.ALBUM_RESULT);
        if (stringExtra != null) {
            WriteImagesInfo writeImagesInfo = this.jFB.getWriteImagesInfo();
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
        if (view == this.jFC.cwU()) {
            cwJ();
        } else if (view == this.jFC.cwW()) {
            cwJ();
        } else if (view == this.jFC.cwT()) {
            if (this.jFB != null) {
                this.jFB.setLastAlbumId(null);
            }
            cwR();
        } else if (view == this.jFC.cwV()) {
            Cj(0);
        } else if (view == this.jFC.cwX()) {
            Ch(2);
        } else if (view == this.jFC.cwY()) {
            Ch(1);
        }
    }

    private void Ch(int i) {
        if (this.jFC != null && this.jFB != null) {
            this.jFB.setOriginalImg(!this.jFB.isOriginalImg());
            cwN();
            Ci(i);
        }
    }

    private void Ci(int i) {
        if (this.jFB != null && this.jFB.isOriginalImg() && !StringUtils.isNull(this.from, true) && !StringUtils.isNull(this.forumId, true)) {
            TiebaStatic.log(new am("c10349").bT("fid", this.forumId).bT("obj_type", this.from).P("obj_locate", i));
        }
    }

    public void cwN() {
        if (this.jFB != null && this.jFC != null) {
            this.jFC.rO(this.jFB.isOriginalImg());
        }
    }

    public View bky() {
        return this.frn;
    }

    public int cwO() {
        return this.jFG;
    }

    public c cwP() {
        return this.jFB;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void Cj(int i) {
        if (!this.jFD) {
            FragmentTransaction beginTransaction = getSupportFragmentManager().beginTransaction();
            Fragment findFragmentByTag = getSupportFragmentManager().findFragmentByTag(this.jFC.Cl(this.mCurrentPage));
            if (findFragmentByTag != null) {
                beginTransaction.hide(findFragmentByTag);
            }
            this.mCurrentPage = i;
            if (getSupportFragmentManager().findFragmentByTag(this.jFC.Cl(i)) != null) {
                beginTransaction.show(this.jFC.Ck(i));
            } else {
                beginTransaction.add(R.id.fragment, this.jFC.Ck(i), this.jFC.Cl(i));
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
        int maxImagesAllowed = this.jFB.getMaxImagesAllowed();
        if (this.jFB.size() < maxImagesAllowed) {
            if (this.jFE == null || this.jFE.g(imageFileInfo)) {
                ImageFileInfo imageFileInfo2 = new ImageFileInfo();
                imageFileInfo2.setAlbumnId(imageFileInfo.getAlbumId());
                imageFileInfo2.setFilePath(imageFileInfo.getFilePath());
                imageFileInfo2.setModifyTime(imageFileInfo.getModifyTime());
                imageFileInfo2.setIsGif(imageFileInfo.isGif());
                imageFileInfo2.setIsLong(imageFileInfo.isLong());
                this.jFB.a(null);
                this.jFB.addChooseFile(imageFileInfo2);
                cwN();
                return true;
            }
            return false;
        } else if (cwQ()) {
            return e(imageFileInfo);
        } else {
            showToast(String.format(getPageContext().getContext().getString(R.string.max_choose_image_count), Integer.valueOf(maxImagesAllowed)));
            return false;
        }
    }

    public boolean cwQ() {
        if (getIntent().getBooleanExtra(AlbumActivityConfig.IS_SELECT_DIRECTLY, false)) {
            int maxImagesAllowed = this.jFB.getMaxImagesAllowed();
            if (this.jFB.size() == maxImagesAllowed && maxImagesAllowed == 1) {
                try {
                    ImageFileInfo imageFileInfo = (ImageFileInfo) v.c(this.jFB.cxg(), 0);
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
        this.jFB.a(null);
        this.jFB.delChooseFile(imageFileInfo);
        cwN();
        return true;
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i == 4) {
            closeLoadingDialog();
            if (this.mCurrentPage == 0) {
                if (this.jFB != null) {
                    this.jFB.setLastAlbumId(null);
                }
                cwR();
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
        if (this.jFC != null && (Ck = this.jFC.Ck(0)) != null && (Ck instanceof ImageListFragment)) {
            ((ImageListFragment) Ck).h(imageFileInfo, z);
        }
    }

    void g(ImageFileInfo imageFileInfo, boolean z) {
        Fragment Ck;
        if (this.jFC != null && (Ck = this.jFC.Ck(1)) != null && (Ck instanceof AlbumImageBrowseFragment)) {
            ((AlbumImageBrowseFragment) Ck).h(imageFileInfo, z);
        }
    }

    private void cwR() {
        Intent intent = new Intent();
        String lastAlbumId = this.jFB.getLastAlbumId();
        if (TextUtils.isEmpty(lastAlbumId)) {
            lastAlbumId = "";
        }
        intent.putExtra(AlbumActivityConfig.LAST_ALBUM_ID, lastAlbumId);
        intent.putExtra(AlbumActivityConfig.CAMERA_REQUEST_FROM, this.jFF);
        setResult(0, intent);
        finish();
    }

    private void stopCamera() {
        if (this.jFC != null) {
            this.jFC.stopCamera();
        }
    }

    private void aWY() {
        if (this.jFC != null) {
            this.jFC.aWY();
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
        this.jFD = true;
        stopCamera();
        closeLoadingDialog();
        dismissAllDialog();
        d.cxk().destory();
        if (this.frn != null) {
            this.frn.setBackgroundDrawable(null);
        }
        if (this.jFC != null) {
            this.jFC.onDestroy();
        }
        if (this.jFL != null) {
            this.jFL.onDestroy();
        }
        Intent intent = new Intent();
        intent.setAction(AlbumActivityConfig.ACTION_SELECT_IMAGE_RESULT);
        intent.putExtra(AlbumActivityConfig.ALBUM_RESULT, this.jFB.getWriteImagesInfo().toJsonString());
        intent.putExtra(AlbumActivityConfig.CAMERA_REQUEST_FROM, this.jFF);
        intent.putExtra("from_type", this.jFK);
        if (this.jFI != null && !StringUtils.isNull(this.jFI.getStringExtra("file_name"))) {
            intent.putExtra("file_name", this.jFI.getStringExtra("file_name"));
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
            new com.baidu.tbadk.img.f(null).c(AlbumActivity.this.jFB.getWriteImagesInfo(), true);
            return AlbumActivity.this.jFB.getWriteImagesInfo().toJsonString();
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
        if (this.jFL != null) {
            this.jFL.onStart();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.adp.base.BdBaseFragmentActivity, android.support.v4.app.FragmentActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        aWY();
        if (this.jFL != null) {
            this.jFL.onResume();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.base.BdBaseFragmentActivity, android.support.v4.app.FragmentActivity, android.app.Activity
    public void onStop() {
        super.onStop();
        if (this.jFL != null) {
            this.jFL.onStop();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.adp.base.BdBaseFragmentActivity, android.support.v4.app.FragmentActivity, android.app.Activity
    public void onPause() {
        stopCamera();
        super.onPause();
    }
}
