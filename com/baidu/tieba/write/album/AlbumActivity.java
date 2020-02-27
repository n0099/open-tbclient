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
import com.baidu.k.a.a;
import com.baidu.live.tbadk.core.data.RequestResponseCode;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.live.tbadk.core.sharedpref.SharedPrefConfig;
import com.baidu.live.tbadk.core.util.CommonStatisticKey;
import com.baidu.live.tbadk.core.util.TbadkCoreStatisticKey;
import com.baidu.tbadk.ActivityPendingTransitionFactory;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.album.VideoFileInfo;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.AlbumActivityConfig;
import com.baidu.tbadk.core.atomData.RecordVideoActivityConfig;
import com.baidu.tbadk.core.atomData.WriteActivityConfig;
import com.baidu.tbadk.core.atomData.WriteMulitImageActivityConfig;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.core.util.v;
import com.baidu.tbadk.img.ImageFileInfo;
import com.baidu.tbadk.img.WriteImagesInfo;
import com.baidu.tieba.R;
import com.baidu.tieba.frs.ForumWriteData;
import com.baidu.webkit.sdk.PermissionRequest;
import java.util.LinkedList;
/* loaded from: classes13.dex */
public class AlbumActivity extends BaseFragmentActivity implements View.OnClickListener, a.InterfaceC0078a {
    private boolean aCb;
    private com.baidu.tieba.c.d iNB;
    private c kMF;
    private com.baidu.tieba.write.album.a kMG;
    private e kMH;
    private Intent kMI;
    private i kMJ;
    private int akj = 0;
    private boolean aBU = false;
    private String callFrom = "";
    private String from = "";
    private String forumName = "";
    private String forumId = "0";
    private int requestFrom = 0;
    private int aBW = 0;
    private boolean aBX = false;
    private boolean aBY = false;
    private int aBZ = 0;
    private View aCa = null;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.adp.base.BdBaseFragmentActivity, android.support.v4.app.FragmentActivity, android.support.v4.app.SupportActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setSwipeBackEnabled(false);
        setContentView(R.layout.album_activity);
        this.aCa = findViewById(R.id.statebar_view);
        this.aCb = UtilHelper.canUseStyleImmersiveSticky();
        Af();
        initData(bundle);
        this.kMG = new com.baidu.tieba.write.album.a(this);
        this.kMG.Ap();
        cM(0);
    }

    public void showTip(View view) {
        if (this.iNB == null && view != null) {
            this.iNB = new com.baidu.tieba.c.d(getPageContext(), view);
            this.iNB.ck(R.drawable.bg_tip_blue_up_left);
            this.iNB.c(new View.OnClickListener() { // from class: com.baidu.tieba.write.album.AlbumActivity.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    AlbumActivity.this.iNB.zx();
                }
            });
            this.iNB.cj(16);
            this.iNB.cl(5000);
        }
        if (this.iNB != null) {
            String sharedPrefKeyWithAccount = com.baidu.tbadk.core.sharedPref.b.getSharedPrefKeyWithAccount(SharedPrefConfig.KEY_SHOW_TAKE_PHOTO_TIP);
            this.iNB.aj(getString(R.string.album_take_photo_tip), sharedPrefKeyWithAccount);
        }
    }

    private void Af() {
        if (this.aCa != null) {
            if (this.aCb && this.aCa.getLayoutParams() != null) {
                ViewGroup.LayoutParams layoutParams = this.aCa.getLayoutParams();
                layoutParams.height = UtilHelper.getStatusBarHeight();
                this.aCa.setLayoutParams(layoutParams);
                bs(true);
                return;
            }
            bs(false);
        }
    }

    private void bs(boolean z) {
        if (this.aCa != null) {
            if (this.aCb && z && this.aCa.getVisibility() != 0) {
                this.aCa.setVisibility(0);
            } else if (!z && this.aCa.getVisibility() != 8) {
                this.aCa.setVisibility(8);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.support.v4.app.FragmentActivity, android.support.v4.app.SupportActivity, android.app.Activity
    public void onSaveInstanceState(Bundle bundle) {
        bundle.putString("write_images_info", this.kMF.getWriteImagesInfo().toJsonString());
        bundle.putBoolean("use_original_img", this.aBX);
        bundle.putInt("camera_request_from", this.requestFrom);
        bundle.putString("forum_id", this.forumId);
        bundle.putString("forum_name", this.forumName);
        bundle.putInt("album_thread", this.aBW);
        bundle.putBoolean("from_write", this.aBY);
    }

    private void initData(Bundle bundle) {
        this.kMF = new c(this);
        if (bundle != null) {
            WriteImagesInfo writeImagesInfo = new WriteImagesInfo();
            writeImagesInfo.parseJson(bundle.getString("write_images_info"));
            this.kMF.setWriteImagesInfo(writeImagesInfo);
            this.aBX = bundle.getBoolean("use_original_img", false);
            this.requestFrom = bundle.getInt("camera_request_from", 0);
            this.forumId = bundle.getString("forum_id");
            this.forumName = bundle.getString("forum_name");
            this.aBW = bundle.getInt("album_thread");
            this.aBY = bundle.getBoolean("from_write");
            this.callFrom = bundle.getString("KEY_CALL_FROM");
            this.aBZ = bundle.getInt("from_type");
        } else {
            Intent intent = getIntent();
            if (intent != null) {
                WriteImagesInfo writeImagesInfo2 = new WriteImagesInfo();
                writeImagesInfo2.parseJson(intent.getStringExtra("write_images_info"));
                this.kMF.setWriteImagesInfo(writeImagesInfo2);
                this.kMF.setOriginalImg(writeImagesInfo2.isOriginalImg());
                this.aBX = intent.getBooleanExtra("use_original_img", false);
                this.requestFrom = intent.getIntExtra("camera_request_from", 0);
                this.from = intent.getStringExtra("from");
                this.forumId = intent.getStringExtra("forum_id");
                this.forumName = intent.getStringExtra("forum_name");
                this.aBW = intent.getIntExtra("album_thread", 0);
                this.aBY = intent.getBooleanExtra("from_write", false);
                this.callFrom = intent.getStringExtra("KEY_CALL_FROM");
                this.aBZ = intent.getIntExtra("from_type", 0);
            }
        }
        Ag();
    }

    private void Ag() {
        if (this.requestFrom == 2) {
            this.kMH = new e() { // from class: com.baidu.tieba.write.album.AlbumActivity.2
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
        if (this.kMG != null) {
            this.kMG.onChangeSkinType(i);
        }
        am.setBackgroundColor(this.aCa, R.color.cp_bg_line_d, i);
    }

    public void Ah() {
        if (this.requestFrom == 3) {
            TiebaStatic.log(TbadkCoreStatisticKey.UPGRADE_DIALOG_CHOOSE_IMAGE);
        }
        if (this.requestFrom == 5) {
            showLoadingDialog("正在上传");
            new a().execute(new String[0]);
        } else if (this.kMF != null) {
            if (this.kMJ == null || !this.kMJ.cUI()) {
                if (this.kMF.AC()) {
                    VideoFileInfo cUA = this.kMF.cUA();
                    if (this.kMJ == null) {
                        this.kMJ = new i(this, this.forumName, this.forumId, "");
                        if (this.kMG != null) {
                            this.kMG.a(this.kMJ);
                        }
                    }
                    if (getIntent() != null) {
                        this.kMJ.setProfessionZone(getIntent().getIntExtra(WriteActivityConfig.KEY_PROFESSION_ZONE, -1));
                    }
                    this.kMJ.a(cUA, this.callFrom);
                } else if (cUw()) {
                    Ai();
                } else {
                    z(null);
                }
            }
        }
    }

    private boolean cUw() {
        if (this.kMF == null || v.getCount(this.kMF.AE()) == 0) {
            return false;
        }
        int i = 0;
        for (ImageFileInfo imageFileInfo : this.kMF.AE()) {
            if (imageFileInfo != null && imageFileInfo.getImageType() == 0 && (i = i + 1) >= 2) {
                return false;
            }
            i = i;
        }
        return i == 1;
    }

    private void z(Intent intent) {
        Intent intent2 = new Intent();
        intent2.putExtra("album_result", this.kMF.getWriteImagesInfo().toJsonString());
        intent2.putExtra("camera_request_from", this.requestFrom);
        intent2.putExtra("from_type", this.aBZ);
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
            this.kMF.getWriteImagesInfo().setChosedFiles(linkedList);
            intent.putExtra("album_result", this.kMF.getWriteImagesInfo().toJsonString());
            intent.putExtra("camera_request_from", this.requestFrom);
            intent.putExtra("from_type", this.aBZ);
            setResult(-1, intent);
            finish();
        }
    }

    private boolean bni() {
        Activity pageActivity = getPageContext().getPageActivity();
        com.baidu.tbadk.core.util.b.a aVar = new com.baidu.tbadk.core.util.b.a();
        aVar.clearRequestPermissionList();
        aVar.appendRequestPermission(pageActivity, PermissionRequest.RESOURCE_VIDEO_CAPTURE);
        aVar.appendRequestPermission(pageActivity, PermissionRequest.RESOURCE_AUDIO_CAPTURE);
        aVar.appendRequestPermission(pageActivity, "android.permission.WRITE_EXTERNAL_STORAGE");
        return aVar.startRequestPermission(pageActivity);
    }

    public void e(TbPageContext tbPageContext) {
        if (!bni() && com.baidu.tieba.write.i.cUp()) {
            sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new RecordVideoActivityConfig(tbPageContext.getPageActivity(), this.aBY ? 2 : 3, new ForumWriteData(this.forumId, this.forumName, null, null), this.kMF.getWriteImagesInfo(), "", this.aBZ)));
            TiebaStatic.log(new an(CommonStatisticKey.KEY_ENTRANCE_CLICKED).X("obj_locate", 5).X("obj_type", 2));
        }
    }

    private void Ai() {
        WriteImagesInfo writeImagesInfo;
        if (this.kMF != null && (writeImagesInfo = this.kMF.getWriteImagesInfo()) != null) {
            sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new WriteMulitImageActivityConfig(getPageContext().getPageActivity(), RequestResponseCode.REQUEST_MOTU_IMAGE, writeImagesInfo, cUx())));
        }
    }

    private int cUx() {
        if (this.kMF == null || v.getCount(this.kMF.AE()) == 0) {
            return 0;
        }
        for (int i = 0; i < v.getCount(this.kMF.AE()); i++) {
            ImageFileInfo imageFileInfo = this.kMF.AE().get(i);
            if (imageFileInfo != null && imageFileInfo.getImageType() == 0) {
                return i;
            }
        }
        return 0;
    }

    private void A(Intent intent) {
        this.kMI = intent;
        if (intent == null || this.kMF == null) {
            z(null);
            return;
        }
        String stringExtra = intent.getStringExtra("album_result");
        if (stringExtra != null) {
            WriteImagesInfo writeImagesInfo = this.kMF.getWriteImagesInfo();
            writeImagesInfo.parseJson(stringExtra);
            writeImagesInfo.updateQuality();
            z(intent);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragmentActivity, android.support.v4.app.FragmentActivity, android.app.Activity
    public void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (i2 == -1) {
            A(intent);
        }
    }

    @Override // com.baidu.adp.base.BdBaseFragmentActivity, android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.kMG.Ar()) {
            Ah();
        } else if (view == this.kMG.At()) {
            Ah();
        } else if (view == this.kMG.Aq()) {
            if (this.kMF != null) {
                this.kMF.setLastAlbumId(null);
            }
            Ao();
        } else if (view == this.kMG.As()) {
            cM(0);
        } else if (view == this.kMG.Au()) {
            cK(2);
        } else if (view == this.kMG.Av()) {
            cK(1);
        }
    }

    private void cK(int i) {
        if (this.kMG != null && this.kMF != null) {
            this.kMF.setOriginalImg(!this.kMF.isOriginalImg());
            Aj();
            cL(i);
        }
    }

    private void cL(int i) {
        if (this.kMF != null && this.kMF.isOriginalImg() && !StringUtils.isNull(this.from, true) && !StringUtils.isNull(this.forumId, true)) {
            TiebaStatic.log(new an("c10349").cy("fid", this.forumId).cy("obj_type", this.from).X("obj_locate", i));
        }
    }

    public void Aj() {
        if (this.kMF != null && this.kMG != null) {
            this.kMG.bt(this.kMF.isOriginalImg());
        }
    }

    public View Ak() {
        return this.aCa;
    }

    public int Al() {
        return this.aBW;
    }

    public c cUy() {
        return this.kMF;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void cM(int i) {
        if (!this.aBU) {
            FragmentTransaction beginTransaction = getSupportFragmentManager().beginTransaction();
            Fragment findFragmentByTag = getSupportFragmentManager().findFragmentByTag(this.kMG.cO(this.akj));
            if (findFragmentByTag != null) {
                beginTransaction.hide(findFragmentByTag);
            }
            this.akj = i;
            if (getSupportFragmentManager().findFragmentByTag(this.kMG.cO(i)) != null) {
                beginTransaction.show(this.kMG.cN(i));
            } else {
                beginTransaction.add(R.id.fragment, this.kMG.cN(i), this.kMG.cO(i));
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
        int maxImagesAllowed = this.kMF.getMaxImagesAllowed();
        if (this.kMF.size() < maxImagesAllowed) {
            if (this.kMH == null || this.kMH.g(imageFileInfo)) {
                ImageFileInfo imageFileInfo2 = new ImageFileInfo();
                imageFileInfo2.setAlbumnId(imageFileInfo.getAlbumId());
                imageFileInfo2.setFilePath(imageFileInfo.getFilePath());
                imageFileInfo2.setModifyTime(imageFileInfo.getModifyTime());
                imageFileInfo2.setIsGif(imageFileInfo.isGif());
                imageFileInfo2.setIsLong(imageFileInfo.isLong());
                this.kMF.a(null);
                this.kMF.addChooseFile(imageFileInfo2);
                Aj();
                return true;
            }
            return false;
        } else if (An()) {
            return e(imageFileInfo);
        } else {
            showToast(String.format(getPageContext().getContext().getString(R.string.max_choose_image_count), Integer.valueOf(maxImagesAllowed)));
            return false;
        }
    }

    public boolean An() {
        if (getIntent().getBooleanExtra("select_directly", false)) {
            int maxImagesAllowed = this.kMF.getMaxImagesAllowed();
            if (this.kMF.size() == maxImagesAllowed && maxImagesAllowed == 1) {
                try {
                    ImageFileInfo imageFileInfo = (ImageFileInfo) v.getItem(this.kMF.AE(), 0);
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
        this.kMF.a(null);
        this.kMF.delChooseFile(imageFileInfo);
        Aj();
        return true;
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i == 4) {
            closeLoadingDialog();
            if (this.akj == 0) {
                if (this.kMF != null) {
                    this.kMF.setLastAlbumId(null);
                }
                Ao();
                return true;
            } else if (this.akj == 1) {
                cM(0);
                return true;
            } else {
                return true;
            }
        }
        return super.onKeyDown(i, keyEvent);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void f(ImageFileInfo imageFileInfo, boolean z) {
        Fragment cN;
        if (this.kMG != null && (cN = this.kMG.cN(0)) != null && (cN instanceof ImageListFragment)) {
            ((ImageListFragment) cN).h(imageFileInfo, z);
        }
    }

    void g(ImageFileInfo imageFileInfo, boolean z) {
        Fragment cN;
        if (this.kMG != null && (cN = this.kMG.cN(1)) != null && (cN instanceof AlbumImageBrowseFragment)) {
            ((AlbumImageBrowseFragment) cN).h(imageFileInfo, z);
        }
    }

    private void Ao() {
        Intent intent = new Intent();
        String lastAlbumId = this.kMF.getLastAlbumId();
        if (TextUtils.isEmpty(lastAlbumId)) {
            lastAlbumId = "";
        }
        intent.putExtra("last_album_id", lastAlbumId);
        intent.putExtra("camera_request_from", this.requestFrom);
        setResult(0, intent);
        finish();
    }

    private void stopCamera() {
        if (this.kMG != null) {
            this.kMG.stopCamera();
        }
    }

    private void FD() {
        if (this.kMG != null) {
            this.kMG.FD();
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
        this.aBU = true;
        stopCamera();
        closeLoadingDialog();
        dismissAllDialog();
        d.cUB().destory();
        if (this.aCa != null) {
            this.aCa.setBackgroundDrawable(null);
        }
        if (this.kMG != null) {
            this.kMG.onDestroy();
        }
        if (this.kMJ != null) {
            this.kMJ.onDestroy();
        }
        Intent intent = new Intent();
        intent.setAction(AlbumActivityConfig.ACTION_SELECT_IMAGE_RESULT);
        intent.putExtra("album_result", this.kMF.getWriteImagesInfo().toJsonString());
        intent.putExtra("camera_request_from", this.requestFrom);
        intent.putExtra("from_type", this.aBZ);
        if (this.kMI != null && !StringUtils.isNull(this.kMI.getStringExtra("file_name"))) {
            intent.putExtra("file_name", this.kMI.getStringExtra("file_name"));
        }
        TbadkCoreApplication.getInst().sendBroadcast(intent);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes13.dex */
    public class a extends BdAsyncTask<String, Integer, String> {
        private a() {
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public String doInBackground(String... strArr) {
            new com.baidu.tbadk.img.f(null).c(AlbumActivity.this.kMF.getWriteImagesInfo(), true);
            return AlbumActivity.this.kMF.getWriteImagesInfo().toJsonString();
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPostExecute(String str) {
            Intent intent = new Intent();
            intent.putExtra("album_result", str);
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
        if (this.kMJ != null) {
            this.kMJ.onStart();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.adp.base.BdBaseFragmentActivity, android.support.v4.app.FragmentActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        FD();
        if (this.kMJ != null) {
            this.kMJ.onResume();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.base.BdBaseFragmentActivity, android.support.v4.app.FragmentActivity, android.app.Activity
    public void onStop() {
        super.onStop();
        if (this.kMJ != null) {
            this.kMJ.onStop();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.adp.base.BdBaseFragmentActivity, android.support.v4.app.FragmentActivity, android.app.Activity
    public void onPause() {
        stopCamera();
        super.onPause();
    }
}
