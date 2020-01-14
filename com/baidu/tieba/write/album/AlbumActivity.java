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
/* loaded from: classes11.dex */
public class AlbumActivity extends BaseFragmentActivity implements View.OnClickListener, a.InterfaceC0072a {
    private boolean axL;
    private com.baidu.tieba.c.d iMh;
    private c kLZ;
    private com.baidu.tieba.write.album.a kMa;
    private e kMb;
    private Intent kMc;
    private i kMd;
    private int aic = 0;
    private boolean axE = false;
    private String callFrom = "";
    private String from = "";
    private String forumName = "";
    private String forumId = "0";
    private int requestFrom = 0;
    private int axG = 0;
    private boolean axH = false;
    private boolean axI = false;
    private int axJ = 0;
    private View axK = null;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.adp.base.BdBaseFragmentActivity, android.support.v4.app.FragmentActivity, android.support.v4.app.SupportActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setSwipeBackEnabled(false);
        setContentView(R.layout.album_activity);
        this.axK = findViewById(R.id.statebar_view);
        this.axL = UtilHelper.canUseStyleImmersiveSticky();
        xO();
        initData(bundle);
        this.kMa = new com.baidu.tieba.write.album.a(this);
        this.kMa.xY();
        cw(0);
    }

    public void showTip(View view) {
        if (this.iMh == null && view != null) {
            this.iMh = new com.baidu.tieba.c.d(getPageContext(), view);
            this.iMh.bU(R.drawable.bg_tip_blue_up_left);
            this.iMh.c(new View.OnClickListener() { // from class: com.baidu.tieba.write.album.AlbumActivity.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    AlbumActivity.this.iMh.xg();
                }
            });
            this.iMh.bT(16);
            this.iMh.bV(5000);
        }
        if (this.iMh != null) {
            String sharedPrefKeyWithAccount = com.baidu.tbadk.core.sharedPref.b.getSharedPrefKeyWithAccount(SharedPrefConfig.KEY_SHOW_TAKE_PHOTO_TIP);
            this.iMh.Y(getString(R.string.album_take_photo_tip), sharedPrefKeyWithAccount);
        }
    }

    private void xO() {
        if (this.axK != null) {
            if (this.axL && this.axK.getLayoutParams() != null) {
                ViewGroup.LayoutParams layoutParams = this.axK.getLayoutParams();
                layoutParams.height = UtilHelper.getStatusBarHeight();
                this.axK.setLayoutParams(layoutParams);
                bk(true);
                return;
            }
            bk(false);
        }
    }

    private void bk(boolean z) {
        if (this.axK != null) {
            if (this.axL && z && this.axK.getVisibility() != 0) {
                this.axK.setVisibility(0);
            } else if (!z && this.axK.getVisibility() != 8) {
                this.axK.setVisibility(8);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.support.v4.app.FragmentActivity, android.support.v4.app.SupportActivity, android.app.Activity
    public void onSaveInstanceState(Bundle bundle) {
        bundle.putString("write_images_info", this.kLZ.getWriteImagesInfo().toJsonString());
        bundle.putBoolean("use_original_img", this.axH);
        bundle.putInt("camera_request_from", this.requestFrom);
        bundle.putString("forum_id", this.forumId);
        bundle.putString("forum_name", this.forumName);
        bundle.putInt("album_thread", this.axG);
        bundle.putBoolean("from_write", this.axI);
    }

    private void initData(Bundle bundle) {
        this.kLZ = new c(this);
        if (bundle != null) {
            WriteImagesInfo writeImagesInfo = new WriteImagesInfo();
            writeImagesInfo.parseJson(bundle.getString("write_images_info"));
            this.kLZ.setWriteImagesInfo(writeImagesInfo);
            this.axH = bundle.getBoolean("use_original_img", false);
            this.requestFrom = bundle.getInt("camera_request_from", 0);
            this.forumId = bundle.getString("forum_id");
            this.forumName = bundle.getString("forum_name");
            this.axG = bundle.getInt("album_thread");
            this.axI = bundle.getBoolean("from_write");
            this.callFrom = bundle.getString("KEY_CALL_FROM");
            this.axJ = bundle.getInt("from_type");
        } else {
            Intent intent = getIntent();
            if (intent != null) {
                WriteImagesInfo writeImagesInfo2 = new WriteImagesInfo();
                writeImagesInfo2.parseJson(intent.getStringExtra("write_images_info"));
                this.kLZ.setWriteImagesInfo(writeImagesInfo2);
                this.kLZ.setOriginalImg(writeImagesInfo2.isOriginalImg());
                this.axH = intent.getBooleanExtra("use_original_img", false);
                this.requestFrom = intent.getIntExtra("camera_request_from", 0);
                this.from = intent.getStringExtra("from");
                this.forumId = intent.getStringExtra("forum_id");
                this.forumName = intent.getStringExtra("forum_name");
                this.axG = intent.getIntExtra("album_thread", 0);
                this.axI = intent.getBooleanExtra("from_write", false);
                this.callFrom = intent.getStringExtra("KEY_CALL_FROM");
                this.axJ = intent.getIntExtra("from_type", 0);
            }
        }
        xP();
    }

    private void xP() {
        if (this.requestFrom == 2) {
            this.kMb = new e() { // from class: com.baidu.tieba.write.album.AlbumActivity.2
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
        if (this.kMa != null) {
            this.kMa.onChangeSkinType(i);
        }
        am.setBackgroundColor(this.axK, R.color.cp_bg_line_d, i);
    }

    public void xQ() {
        if (this.requestFrom == 3) {
            TiebaStatic.log(TbadkCoreStatisticKey.UPGRADE_DIALOG_CHOOSE_IMAGE);
        }
        if (this.requestFrom == 5) {
            showLoadingDialog("正在上传");
            new a().execute(new String[0]);
        } else if (this.kLZ != null) {
            if (this.kMd == null || !this.kMd.cTu()) {
                if (this.kLZ.yl()) {
                    VideoFileInfo cTm = this.kLZ.cTm();
                    if (this.kMd == null) {
                        this.kMd = new i(this, this.forumName, this.forumId, "");
                        if (this.kMa != null) {
                            this.kMa.a(this.kMd);
                        }
                    }
                    if (getIntent() != null) {
                        this.kMd.setProfessionZone(getIntent().getIntExtra(WriteActivityConfig.KEY_PROFESSION_ZONE, -1));
                    }
                    this.kMd.a(cTm, this.callFrom);
                } else if (cTi()) {
                    xR();
                } else {
                    z(null);
                }
            }
        }
    }

    private boolean cTi() {
        if (this.kLZ == null || v.getCount(this.kLZ.yn()) == 0) {
            return false;
        }
        int i = 0;
        for (ImageFileInfo imageFileInfo : this.kLZ.yn()) {
            if (imageFileInfo != null && imageFileInfo.getImageType() == 0 && (i = i + 1) >= 2) {
                return false;
            }
            i = i;
        }
        return i == 1;
    }

    private void z(Intent intent) {
        Intent intent2 = new Intent();
        intent2.putExtra("album_result", this.kLZ.getWriteImagesInfo().toJsonString());
        intent2.putExtra("camera_request_from", this.requestFrom);
        intent2.putExtra("from_type", this.axJ);
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
            this.kLZ.getWriteImagesInfo().setChosedFiles(linkedList);
            intent.putExtra("album_result", this.kLZ.getWriteImagesInfo().toJsonString());
            intent.putExtra("camera_request_from", this.requestFrom);
            intent.putExtra("from_type", this.axJ);
            setResult(-1, intent);
            finish();
        }
    }

    private boolean blA() {
        Activity pageActivity = getPageContext().getPageActivity();
        com.baidu.tbadk.core.util.b.a aVar = new com.baidu.tbadk.core.util.b.a();
        aVar.clearRequestPermissionList();
        aVar.appendRequestPermission(pageActivity, PermissionRequest.RESOURCE_VIDEO_CAPTURE);
        aVar.appendRequestPermission(pageActivity, PermissionRequest.RESOURCE_AUDIO_CAPTURE);
        aVar.appendRequestPermission(pageActivity, "android.permission.WRITE_EXTERNAL_STORAGE");
        return aVar.startRequestPermission(pageActivity);
    }

    public void e(TbPageContext tbPageContext) {
        if (!blA() && com.baidu.tieba.write.i.cTb()) {
            sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new RecordVideoActivityConfig(tbPageContext.getPageActivity(), this.axI ? 2 : 3, new ForumWriteData(this.forumId, this.forumName, null, null), this.kLZ.getWriteImagesInfo(), "", this.axJ)));
            TiebaStatic.log(new an(CommonStatisticKey.KEY_ENTRANCE_CLICKED).Z("obj_locate", 5).Z("obj_type", 2));
        }
    }

    private void xR() {
        WriteImagesInfo writeImagesInfo;
        if (this.kLZ != null && (writeImagesInfo = this.kLZ.getWriteImagesInfo()) != null) {
            sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new WriteMulitImageActivityConfig(getPageContext().getPageActivity(), RequestResponseCode.REQUEST_MOTU_IMAGE, writeImagesInfo, cTj())));
        }
    }

    private int cTj() {
        if (this.kLZ == null || v.getCount(this.kLZ.yn()) == 0) {
            return 0;
        }
        for (int i = 0; i < v.getCount(this.kLZ.yn()); i++) {
            ImageFileInfo imageFileInfo = this.kLZ.yn().get(i);
            if (imageFileInfo != null && imageFileInfo.getImageType() == 0) {
                return i;
            }
        }
        return 0;
    }

    private void A(Intent intent) {
        this.kMc = intent;
        if (intent == null || this.kLZ == null) {
            z(null);
            return;
        }
        String stringExtra = intent.getStringExtra("album_result");
        if (stringExtra != null) {
            WriteImagesInfo writeImagesInfo = this.kLZ.getWriteImagesInfo();
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
        if (view == this.kMa.ya()) {
            xQ();
        } else if (view == this.kMa.yc()) {
            xQ();
        } else if (view == this.kMa.xZ()) {
            if (this.kLZ != null) {
                this.kLZ.setLastAlbumId(null);
            }
            xX();
        } else if (view == this.kMa.yb()) {
            cw(0);
        } else if (view == this.kMa.yd()) {
            cu(2);
        } else if (view == this.kMa.ye()) {
            cu(1);
        }
    }

    private void cu(int i) {
        if (this.kMa != null && this.kLZ != null) {
            this.kLZ.setOriginalImg(!this.kLZ.isOriginalImg());
            xS();
            cv(i);
        }
    }

    private void cv(int i) {
        if (this.kLZ != null && this.kLZ.isOriginalImg() && !StringUtils.isNull(this.from, true) && !StringUtils.isNull(this.forumId, true)) {
            TiebaStatic.log(new an("c10349").cp("fid", this.forumId).cp("obj_type", this.from).Z("obj_locate", i));
        }
    }

    public void xS() {
        if (this.kLZ != null && this.kMa != null) {
            this.kMa.bl(this.kLZ.isOriginalImg());
        }
    }

    public View xT() {
        return this.axK;
    }

    public int xU() {
        return this.axG;
    }

    public c cTk() {
        return this.kLZ;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void cw(int i) {
        if (!this.axE) {
            FragmentTransaction beginTransaction = getSupportFragmentManager().beginTransaction();
            Fragment findFragmentByTag = getSupportFragmentManager().findFragmentByTag(this.kMa.cy(this.aic));
            if (findFragmentByTag != null) {
                beginTransaction.hide(findFragmentByTag);
            }
            this.aic = i;
            if (getSupportFragmentManager().findFragmentByTag(this.kMa.cy(i)) != null) {
                beginTransaction.show(this.kMa.cx(i));
            } else {
                beginTransaction.add(R.id.fragment, this.kMa.cx(i), this.kMa.cy(i));
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
        int maxImagesAllowed = this.kLZ.getMaxImagesAllowed();
        if (this.kLZ.size() < maxImagesAllowed) {
            if (this.kMb == null || this.kMb.g(imageFileInfo)) {
                ImageFileInfo imageFileInfo2 = new ImageFileInfo();
                imageFileInfo2.setAlbumnId(imageFileInfo.getAlbumId());
                imageFileInfo2.setFilePath(imageFileInfo.getFilePath());
                imageFileInfo2.setModifyTime(imageFileInfo.getModifyTime());
                imageFileInfo2.setIsGif(imageFileInfo.isGif());
                imageFileInfo2.setIsLong(imageFileInfo.isLong());
                this.kLZ.a(null);
                this.kLZ.addChooseFile(imageFileInfo2);
                xS();
                return true;
            }
            return false;
        } else if (xW()) {
            return e(imageFileInfo);
        } else {
            showToast(String.format(getPageContext().getContext().getString(R.string.max_choose_image_count), Integer.valueOf(maxImagesAllowed)));
            return false;
        }
    }

    public boolean xW() {
        if (getIntent().getBooleanExtra("select_directly", false)) {
            int maxImagesAllowed = this.kLZ.getMaxImagesAllowed();
            if (this.kLZ.size() == maxImagesAllowed && maxImagesAllowed == 1) {
                try {
                    ImageFileInfo imageFileInfo = (ImageFileInfo) v.getItem(this.kLZ.yn(), 0);
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
        this.kLZ.a(null);
        this.kLZ.delChooseFile(imageFileInfo);
        xS();
        return true;
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i == 4) {
            closeLoadingDialog();
            if (this.aic == 0) {
                if (this.kLZ != null) {
                    this.kLZ.setLastAlbumId(null);
                }
                xX();
                return true;
            } else if (this.aic == 1) {
                cw(0);
                return true;
            } else {
                return true;
            }
        }
        return super.onKeyDown(i, keyEvent);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void f(ImageFileInfo imageFileInfo, boolean z) {
        Fragment cx;
        if (this.kMa != null && (cx = this.kMa.cx(0)) != null && (cx instanceof ImageListFragment)) {
            ((ImageListFragment) cx).h(imageFileInfo, z);
        }
    }

    void g(ImageFileInfo imageFileInfo, boolean z) {
        Fragment cx;
        if (this.kMa != null && (cx = this.kMa.cx(1)) != null && (cx instanceof AlbumImageBrowseFragment)) {
            ((AlbumImageBrowseFragment) cx).h(imageFileInfo, z);
        }
    }

    private void xX() {
        Intent intent = new Intent();
        String lastAlbumId = this.kLZ.getLastAlbumId();
        if (TextUtils.isEmpty(lastAlbumId)) {
            lastAlbumId = "";
        }
        intent.putExtra("last_album_id", lastAlbumId);
        intent.putExtra("camera_request_from", this.requestFrom);
        setResult(0, intent);
        finish();
    }

    private void stopCamera() {
        if (this.kMa != null) {
            this.kMa.stopCamera();
        }
    }

    private void Dh() {
        if (this.kMa != null) {
            this.kMa.Dh();
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
        this.axE = true;
        stopCamera();
        closeLoadingDialog();
        dismissAllDialog();
        d.cTn().destory();
        if (this.axK != null) {
            this.axK.setBackgroundDrawable(null);
        }
        if (this.kMa != null) {
            this.kMa.onDestroy();
        }
        if (this.kMd != null) {
            this.kMd.onDestroy();
        }
        Intent intent = new Intent();
        intent.setAction(AlbumActivityConfig.ACTION_SELECT_IMAGE_RESULT);
        intent.putExtra("album_result", this.kLZ.getWriteImagesInfo().toJsonString());
        intent.putExtra("camera_request_from", this.requestFrom);
        intent.putExtra("from_type", this.axJ);
        if (this.kMc != null && !StringUtils.isNull(this.kMc.getStringExtra("file_name"))) {
            intent.putExtra("file_name", this.kMc.getStringExtra("file_name"));
        }
        TbadkCoreApplication.getInst().sendBroadcast(intent);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes11.dex */
    public class a extends BdAsyncTask<String, Integer, String> {
        private a() {
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public String doInBackground(String... strArr) {
            new com.baidu.tbadk.img.f(null).c(AlbumActivity.this.kLZ.getWriteImagesInfo(), true);
            return AlbumActivity.this.kLZ.getWriteImagesInfo().toJsonString();
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
        if (this.kMd != null) {
            this.kMd.onStart();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.adp.base.BdBaseFragmentActivity, android.support.v4.app.FragmentActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        Dh();
        if (this.kMd != null) {
            this.kMd.onResume();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.base.BdBaseFragmentActivity, android.support.v4.app.FragmentActivity, android.app.Activity
    public void onStop() {
        super.onStop();
        if (this.kMd != null) {
            this.kMd.onStop();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.adp.base.BdBaseFragmentActivity, android.support.v4.app.FragmentActivity, android.app.Activity
    public void onPause() {
        stopCamera();
        super.onPause();
    }
}
