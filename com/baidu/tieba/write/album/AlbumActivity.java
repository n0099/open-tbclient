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
/* loaded from: classes10.dex */
public class AlbumActivity extends BaseFragmentActivity implements View.OnClickListener, a.InterfaceC0072a {
    private boolean axc;
    private com.baidu.tieba.c.d iID;
    private c kIt;
    private com.baidu.tieba.write.album.a kIu;
    private e kIv;
    private Intent kIw;
    private i kIx;
    private int aht = 0;
    private boolean awV = false;
    private String callFrom = "";
    private String from = "";
    private String forumName = "";
    private String forumId = "0";
    private int requestFrom = 0;
    private int awX = 0;
    private boolean awY = false;
    private boolean awZ = false;
    private int axa = 0;
    private View axb = null;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.adp.base.BdBaseFragmentActivity, android.support.v4.app.FragmentActivity, android.support.v4.app.SupportActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setSwipeBackEnabled(false);
        setContentView(R.layout.album_activity);
        this.axb = findViewById(R.id.statebar_view);
        this.axc = UtilHelper.canUseStyleImmersiveSticky();
        xy();
        initData(bundle);
        this.kIu = new com.baidu.tieba.write.album.a(this);
        this.kIu.xI();
        cv(0);
    }

    public void showTip(View view) {
        if (this.iID == null && view != null) {
            this.iID = new com.baidu.tieba.c.d(getPageContext(), view);
            this.iID.bT(R.drawable.bg_tip_blue_up_left);
            this.iID.c(new View.OnClickListener() { // from class: com.baidu.tieba.write.album.AlbumActivity.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    AlbumActivity.this.iID.wP();
                }
            });
            this.iID.bS(16);
            this.iID.bU(5000);
        }
        if (this.iID != null) {
            String sharedPrefKeyWithAccount = com.baidu.tbadk.core.sharedPref.b.getSharedPrefKeyWithAccount(SharedPrefConfig.KEY_SHOW_TAKE_PHOTO_TIP);
            this.iID.Z(getString(R.string.album_take_photo_tip), sharedPrefKeyWithAccount);
        }
    }

    private void xy() {
        if (this.axb != null) {
            if (this.axc && this.axb.getLayoutParams() != null) {
                ViewGroup.LayoutParams layoutParams = this.axb.getLayoutParams();
                layoutParams.height = UtilHelper.getStatusBarHeight();
                this.axb.setLayoutParams(layoutParams);
                bg(true);
                return;
            }
            bg(false);
        }
    }

    private void bg(boolean z) {
        if (this.axb != null) {
            if (this.axc && z && this.axb.getVisibility() != 0) {
                this.axb.setVisibility(0);
            } else if (!z && this.axb.getVisibility() != 8) {
                this.axb.setVisibility(8);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.support.v4.app.FragmentActivity, android.support.v4.app.SupportActivity, android.app.Activity
    public void onSaveInstanceState(Bundle bundle) {
        bundle.putString("write_images_info", this.kIt.getWriteImagesInfo().toJsonString());
        bundle.putBoolean("use_original_img", this.awY);
        bundle.putInt("camera_request_from", this.requestFrom);
        bundle.putString("forum_id", this.forumId);
        bundle.putString("forum_name", this.forumName);
        bundle.putInt("album_thread", this.awX);
        bundle.putBoolean("from_write", this.awZ);
    }

    private void initData(Bundle bundle) {
        this.kIt = new c(this);
        if (bundle != null) {
            WriteImagesInfo writeImagesInfo = new WriteImagesInfo();
            writeImagesInfo.parseJson(bundle.getString("write_images_info"));
            this.kIt.setWriteImagesInfo(writeImagesInfo);
            this.awY = bundle.getBoolean("use_original_img", false);
            this.requestFrom = bundle.getInt("camera_request_from", 0);
            this.forumId = bundle.getString("forum_id");
            this.forumName = bundle.getString("forum_name");
            this.awX = bundle.getInt("album_thread");
            this.awZ = bundle.getBoolean("from_write");
            this.callFrom = bundle.getString("KEY_CALL_FROM");
            this.axa = bundle.getInt("from_type");
        } else {
            Intent intent = getIntent();
            if (intent != null) {
                WriteImagesInfo writeImagesInfo2 = new WriteImagesInfo();
                writeImagesInfo2.parseJson(intent.getStringExtra("write_images_info"));
                this.kIt.setWriteImagesInfo(writeImagesInfo2);
                this.kIt.setOriginalImg(writeImagesInfo2.isOriginalImg());
                this.awY = intent.getBooleanExtra("use_original_img", false);
                this.requestFrom = intent.getIntExtra("camera_request_from", 0);
                this.from = intent.getStringExtra("from");
                this.forumId = intent.getStringExtra("forum_id");
                this.forumName = intent.getStringExtra("forum_name");
                this.awX = intent.getIntExtra("album_thread", 0);
                this.awZ = intent.getBooleanExtra("from_write", false);
                this.callFrom = intent.getStringExtra("KEY_CALL_FROM");
                this.axa = intent.getIntExtra("from_type", 0);
            }
        }
        xz();
    }

    private void xz() {
        if (this.requestFrom == 2) {
            this.kIv = new e() { // from class: com.baidu.tieba.write.album.AlbumActivity.2
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
        if (this.kIu != null) {
            this.kIu.onChangeSkinType(i);
        }
        am.setBackgroundColor(this.axb, R.color.cp_bg_line_d, i);
    }

    public void xA() {
        if (this.requestFrom == 3) {
            TiebaStatic.log(TbadkCoreStatisticKey.UPGRADE_DIALOG_CHOOSE_IMAGE);
        }
        if (this.requestFrom == 5) {
            showLoadingDialog("正在上传");
            new a().execute(new String[0]);
        } else if (this.kIt != null) {
            if (this.kIx == null || !this.kIx.cSp()) {
                if (this.kIt.xV()) {
                    VideoFileInfo cSh = this.kIt.cSh();
                    if (this.kIx == null) {
                        this.kIx = new i(this, this.forumName, this.forumId, "");
                        if (this.kIu != null) {
                            this.kIu.a(this.kIx);
                        }
                    }
                    if (getIntent() != null) {
                        this.kIx.setProfessionZone(getIntent().getIntExtra(WriteActivityConfig.KEY_PROFESSION_ZONE, -1));
                    }
                    this.kIx.a(cSh, this.callFrom);
                } else if (cSd()) {
                    xB();
                } else {
                    z(null);
                }
            }
        }
    }

    private boolean cSd() {
        if (this.kIt == null || v.getCount(this.kIt.xX()) == 0) {
            return false;
        }
        int i = 0;
        for (ImageFileInfo imageFileInfo : this.kIt.xX()) {
            if (imageFileInfo != null && imageFileInfo.getImageType() == 0 && (i = i + 1) >= 2) {
                return false;
            }
            i = i;
        }
        return i == 1;
    }

    private void z(Intent intent) {
        Intent intent2 = new Intent();
        intent2.putExtra("album_result", this.kIt.getWriteImagesInfo().toJsonString());
        intent2.putExtra("camera_request_from", this.requestFrom);
        intent2.putExtra("from_type", this.axa);
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
            this.kIt.getWriteImagesInfo().setChosedFiles(linkedList);
            intent.putExtra("album_result", this.kIt.getWriteImagesInfo().toJsonString());
            intent.putExtra("camera_request_from", this.requestFrom);
            intent.putExtra("from_type", this.axa);
            setResult(-1, intent);
            finish();
        }
    }

    private boolean bkE() {
        Activity pageActivity = getPageContext().getPageActivity();
        com.baidu.tbadk.core.util.b.a aVar = new com.baidu.tbadk.core.util.b.a();
        aVar.clearRequestPermissionList();
        aVar.appendRequestPermission(pageActivity, PermissionRequest.RESOURCE_VIDEO_CAPTURE);
        aVar.appendRequestPermission(pageActivity, PermissionRequest.RESOURCE_AUDIO_CAPTURE);
        aVar.appendRequestPermission(pageActivity, "android.permission.WRITE_EXTERNAL_STORAGE");
        return aVar.startRequestPermission(pageActivity);
    }

    public void e(TbPageContext tbPageContext) {
        if (!bkE() && com.baidu.tieba.write.i.cRW()) {
            sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new RecordVideoActivityConfig(tbPageContext.getPageActivity(), this.awZ ? 2 : 3, new ForumWriteData(this.forumId, this.forumName, null, null), this.kIt.getWriteImagesInfo(), "", this.axa)));
            TiebaStatic.log(new an(CommonStatisticKey.KEY_ENTRANCE_CLICKED).Z("obj_locate", 5).Z("obj_type", 2));
        }
    }

    private void xB() {
        WriteImagesInfo writeImagesInfo;
        if (this.kIt != null && (writeImagesInfo = this.kIt.getWriteImagesInfo()) != null) {
            sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new WriteMulitImageActivityConfig(getPageContext().getPageActivity(), RequestResponseCode.REQUEST_MOTU_IMAGE, writeImagesInfo, cSe())));
        }
    }

    private int cSe() {
        if (this.kIt == null || v.getCount(this.kIt.xX()) == 0) {
            return 0;
        }
        for (int i = 0; i < v.getCount(this.kIt.xX()); i++) {
            ImageFileInfo imageFileInfo = this.kIt.xX().get(i);
            if (imageFileInfo != null && imageFileInfo.getImageType() == 0) {
                return i;
            }
        }
        return 0;
    }

    private void A(Intent intent) {
        this.kIw = intent;
        if (intent == null || this.kIt == null) {
            z(null);
            return;
        }
        String stringExtra = intent.getStringExtra("album_result");
        if (stringExtra != null) {
            WriteImagesInfo writeImagesInfo = this.kIt.getWriteImagesInfo();
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
        if (view == this.kIu.xK()) {
            xA();
        } else if (view == this.kIu.xM()) {
            xA();
        } else if (view == this.kIu.xJ()) {
            if (this.kIt != null) {
                this.kIt.setLastAlbumId(null);
            }
            xH();
        } else if (view == this.kIu.xL()) {
            cv(0);
        } else if (view == this.kIu.xN()) {
            ct(2);
        } else if (view == this.kIu.xO()) {
            ct(1);
        }
    }

    private void ct(int i) {
        if (this.kIu != null && this.kIt != null) {
            this.kIt.setOriginalImg(!this.kIt.isOriginalImg());
            xC();
            cu(i);
        }
    }

    private void cu(int i) {
        if (this.kIt != null && this.kIt.isOriginalImg() && !StringUtils.isNull(this.from, true) && !StringUtils.isNull(this.forumId, true)) {
            TiebaStatic.log(new an("c10349").cp("fid", this.forumId).cp("obj_type", this.from).Z("obj_locate", i));
        }
    }

    public void xC() {
        if (this.kIt != null && this.kIu != null) {
            this.kIu.bh(this.kIt.isOriginalImg());
        }
    }

    public View xD() {
        return this.axb;
    }

    public int xE() {
        return this.awX;
    }

    public c cSf() {
        return this.kIt;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void cv(int i) {
        if (!this.awV) {
            FragmentTransaction beginTransaction = getSupportFragmentManager().beginTransaction();
            Fragment findFragmentByTag = getSupportFragmentManager().findFragmentByTag(this.kIu.cx(this.aht));
            if (findFragmentByTag != null) {
                beginTransaction.hide(findFragmentByTag);
            }
            this.aht = i;
            if (getSupportFragmentManager().findFragmentByTag(this.kIu.cx(i)) != null) {
                beginTransaction.show(this.kIu.cw(i));
            } else {
                beginTransaction.add(R.id.fragment, this.kIu.cw(i), this.kIu.cx(i));
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
        int maxImagesAllowed = this.kIt.getMaxImagesAllowed();
        if (this.kIt.size() < maxImagesAllowed) {
            if (this.kIv == null || this.kIv.g(imageFileInfo)) {
                ImageFileInfo imageFileInfo2 = new ImageFileInfo();
                imageFileInfo2.setAlbumnId(imageFileInfo.getAlbumId());
                imageFileInfo2.setFilePath(imageFileInfo.getFilePath());
                imageFileInfo2.setModifyTime(imageFileInfo.getModifyTime());
                imageFileInfo2.setIsGif(imageFileInfo.isGif());
                imageFileInfo2.setIsLong(imageFileInfo.isLong());
                this.kIt.a(null);
                this.kIt.addChooseFile(imageFileInfo2);
                xC();
                return true;
            }
            return false;
        } else if (xG()) {
            return e(imageFileInfo);
        } else {
            showToast(String.format(getPageContext().getContext().getString(R.string.max_choose_image_count), Integer.valueOf(maxImagesAllowed)));
            return false;
        }
    }

    public boolean xG() {
        if (getIntent().getBooleanExtra("select_directly", false)) {
            int maxImagesAllowed = this.kIt.getMaxImagesAllowed();
            if (this.kIt.size() == maxImagesAllowed && maxImagesAllowed == 1) {
                try {
                    ImageFileInfo imageFileInfo = (ImageFileInfo) v.getItem(this.kIt.xX(), 0);
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
        this.kIt.a(null);
        this.kIt.delChooseFile(imageFileInfo);
        xC();
        return true;
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i == 4) {
            closeLoadingDialog();
            if (this.aht == 0) {
                if (this.kIt != null) {
                    this.kIt.setLastAlbumId(null);
                }
                xH();
                return true;
            } else if (this.aht == 1) {
                cv(0);
                return true;
            } else {
                return true;
            }
        }
        return super.onKeyDown(i, keyEvent);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void f(ImageFileInfo imageFileInfo, boolean z) {
        Fragment cw;
        if (this.kIu != null && (cw = this.kIu.cw(0)) != null && (cw instanceof ImageListFragment)) {
            ((ImageListFragment) cw).h(imageFileInfo, z);
        }
    }

    void g(ImageFileInfo imageFileInfo, boolean z) {
        Fragment cw;
        if (this.kIu != null && (cw = this.kIu.cw(1)) != null && (cw instanceof AlbumImageBrowseFragment)) {
            ((AlbumImageBrowseFragment) cw).h(imageFileInfo, z);
        }
    }

    private void xH() {
        Intent intent = new Intent();
        String lastAlbumId = this.kIt.getLastAlbumId();
        if (TextUtils.isEmpty(lastAlbumId)) {
            lastAlbumId = "";
        }
        intent.putExtra("last_album_id", lastAlbumId);
        intent.putExtra("camera_request_from", this.requestFrom);
        setResult(0, intent);
        finish();
    }

    private void stopCamera() {
        if (this.kIu != null) {
            this.kIu.stopCamera();
        }
    }

    private void CL() {
        if (this.kIu != null) {
            this.kIu.CL();
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
        this.awV = true;
        stopCamera();
        closeLoadingDialog();
        dismissAllDialog();
        d.cSi().destory();
        if (this.axb != null) {
            this.axb.setBackgroundDrawable(null);
        }
        if (this.kIu != null) {
            this.kIu.onDestroy();
        }
        if (this.kIx != null) {
            this.kIx.onDestroy();
        }
        Intent intent = new Intent();
        intent.setAction(AlbumActivityConfig.ACTION_SELECT_IMAGE_RESULT);
        intent.putExtra("album_result", this.kIt.getWriteImagesInfo().toJsonString());
        intent.putExtra("camera_request_from", this.requestFrom);
        intent.putExtra("from_type", this.axa);
        if (this.kIw != null && !StringUtils.isNull(this.kIw.getStringExtra("file_name"))) {
            intent.putExtra("file_name", this.kIw.getStringExtra("file_name"));
        }
        TbadkCoreApplication.getInst().sendBroadcast(intent);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes10.dex */
    public class a extends BdAsyncTask<String, Integer, String> {
        private a() {
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public String doInBackground(String... strArr) {
            new com.baidu.tbadk.img.f(null).c(AlbumActivity.this.kIt.getWriteImagesInfo(), true);
            return AlbumActivity.this.kIt.getWriteImagesInfo().toJsonString();
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
        if (this.kIx != null) {
            this.kIx.onStart();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.adp.base.BdBaseFragmentActivity, android.support.v4.app.FragmentActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        CL();
        if (this.kIx != null) {
            this.kIx.onResume();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.base.BdBaseFragmentActivity, android.support.v4.app.FragmentActivity, android.app.Activity
    public void onStop() {
        super.onStop();
        if (this.kIx != null) {
            this.kIx.onStop();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.adp.base.BdBaseFragmentActivity, android.support.v4.app.FragmentActivity, android.app.Activity
    public void onPause() {
        stopCamera();
        super.onPause();
    }
}
