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
import com.baidu.tbadk.core.util.permission.PermissionJudgePolicy;
import com.baidu.tbadk.core.util.v;
import com.baidu.tbadk.img.ImageFileInfo;
import com.baidu.tbadk.img.WriteImagesInfo;
import com.baidu.tieba.R;
import com.baidu.tieba.frs.ForumWriteData;
import com.baidu.webkit.sdk.PermissionRequest;
import java.util.LinkedList;
/* loaded from: classes13.dex */
public class AlbumActivity extends BaseFragmentActivity implements View.OnClickListener, a.InterfaceC0078a {
    private boolean aCd;
    private com.baidu.tieba.c.d iNP;
    private c kMT;
    private com.baidu.tieba.write.album.a kMU;
    private e kMV;
    private Intent kMW;
    private i kMX;
    private int akk = 0;
    private boolean aBW = false;
    private String callFrom = "";
    private String from = "";
    private String forumName = "";
    private String forumId = "0";
    private int requestFrom = 0;
    private int aBY = 0;
    private boolean aBZ = false;
    private boolean aCa = false;
    private int aCb = 0;
    private View aCc = null;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.adp.base.BdBaseFragmentActivity, android.support.v4.app.FragmentActivity, android.support.v4.app.SupportActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setSwipeBackEnabled(false);
        setContentView(R.layout.album_activity);
        this.aCc = findViewById(R.id.statebar_view);
        this.aCd = UtilHelper.canUseStyleImmersiveSticky();
        Ah();
        initData(bundle);
        this.kMU = new com.baidu.tieba.write.album.a(this);
        this.kMU.Ar();
        cM(0);
    }

    public void showTip(View view) {
        if (this.iNP == null && view != null) {
            this.iNP = new com.baidu.tieba.c.d(getPageContext(), view);
            this.iNP.ck(R.drawable.bg_tip_blue_up_left);
            this.iNP.c(new View.OnClickListener() { // from class: com.baidu.tieba.write.album.AlbumActivity.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    AlbumActivity.this.iNP.zz();
                }
            });
            this.iNP.cj(16);
            this.iNP.cl(5000);
        }
        if (this.iNP != null) {
            String sharedPrefKeyWithAccount = com.baidu.tbadk.core.sharedPref.b.getSharedPrefKeyWithAccount(SharedPrefConfig.KEY_SHOW_TAKE_PHOTO_TIP);
            this.iNP.aj(getString(R.string.album_take_photo_tip), sharedPrefKeyWithAccount);
        }
    }

    private void Ah() {
        if (this.aCc != null) {
            if (this.aCd && this.aCc.getLayoutParams() != null) {
                ViewGroup.LayoutParams layoutParams = this.aCc.getLayoutParams();
                layoutParams.height = UtilHelper.getStatusBarHeight();
                this.aCc.setLayoutParams(layoutParams);
                bs(true);
                return;
            }
            bs(false);
        }
    }

    private void bs(boolean z) {
        if (this.aCc != null) {
            if (this.aCd && z && this.aCc.getVisibility() != 0) {
                this.aCc.setVisibility(0);
            } else if (!z && this.aCc.getVisibility() != 8) {
                this.aCc.setVisibility(8);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.support.v4.app.FragmentActivity, android.support.v4.app.SupportActivity, android.app.Activity
    public void onSaveInstanceState(Bundle bundle) {
        bundle.putString("write_images_info", this.kMT.getWriteImagesInfo().toJsonString());
        bundle.putBoolean("use_original_img", this.aBZ);
        bundle.putInt("camera_request_from", this.requestFrom);
        bundle.putString("forum_id", this.forumId);
        bundle.putString("forum_name", this.forumName);
        bundle.putInt("album_thread", this.aBY);
        bundle.putBoolean("from_write", this.aCa);
    }

    private void initData(Bundle bundle) {
        this.kMT = new c(this);
        if (bundle != null) {
            WriteImagesInfo writeImagesInfo = new WriteImagesInfo();
            writeImagesInfo.parseJson(bundle.getString("write_images_info"));
            this.kMT.setWriteImagesInfo(writeImagesInfo);
            this.aBZ = bundle.getBoolean("use_original_img", false);
            this.requestFrom = bundle.getInt("camera_request_from", 0);
            this.forumId = bundle.getString("forum_id");
            this.forumName = bundle.getString("forum_name");
            this.aBY = bundle.getInt("album_thread");
            this.aCa = bundle.getBoolean("from_write");
            this.callFrom = bundle.getString("KEY_CALL_FROM");
            this.aCb = bundle.getInt("from_type");
        } else {
            Intent intent = getIntent();
            if (intent != null) {
                WriteImagesInfo writeImagesInfo2 = new WriteImagesInfo();
                writeImagesInfo2.parseJson(intent.getStringExtra("write_images_info"));
                this.kMT.setWriteImagesInfo(writeImagesInfo2);
                this.kMT.setOriginalImg(writeImagesInfo2.isOriginalImg());
                this.aBZ = intent.getBooleanExtra("use_original_img", false);
                this.requestFrom = intent.getIntExtra("camera_request_from", 0);
                this.from = intent.getStringExtra("from");
                this.forumId = intent.getStringExtra("forum_id");
                this.forumName = intent.getStringExtra("forum_name");
                this.aBY = intent.getIntExtra("album_thread", 0);
                this.aCa = intent.getBooleanExtra("from_write", false);
                this.callFrom = intent.getStringExtra("KEY_CALL_FROM");
                this.aCb = intent.getIntExtra("from_type", 0);
            }
        }
        Ai();
    }

    private void Ai() {
        if (this.requestFrom == 2) {
            this.kMV = new e() { // from class: com.baidu.tieba.write.album.AlbumActivity.2
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
        if (this.kMU != null) {
            this.kMU.onChangeSkinType(i);
        }
        am.setBackgroundColor(this.aCc, R.color.cp_bg_line_d, i);
    }

    public void Aj() {
        if (this.requestFrom == 3) {
            TiebaStatic.log(TbadkCoreStatisticKey.UPGRADE_DIALOG_CHOOSE_IMAGE);
        }
        if (this.requestFrom == 5) {
            showLoadingDialog("正在上传");
            new a().execute(new String[0]);
        } else if (this.kMT != null) {
            if (this.kMX == null || !this.kMX.cUL()) {
                if (this.kMT.AE()) {
                    VideoFileInfo cUD = this.kMT.cUD();
                    if (this.kMX == null) {
                        this.kMX = new i(this, this.forumName, this.forumId, "");
                        if (this.kMU != null) {
                            this.kMU.a(this.kMX);
                        }
                    }
                    if (getIntent() != null) {
                        this.kMX.setProfessionZone(getIntent().getIntExtra(WriteActivityConfig.KEY_PROFESSION_ZONE, -1));
                    }
                    this.kMX.a(cUD, this.callFrom);
                } else if (cUz()) {
                    Ak();
                } else {
                    z(null);
                }
            }
        }
    }

    private boolean cUz() {
        if (this.kMT == null || v.getCount(this.kMT.AG()) == 0) {
            return false;
        }
        int i = 0;
        for (ImageFileInfo imageFileInfo : this.kMT.AG()) {
            if (imageFileInfo != null && imageFileInfo.getImageType() == 0 && (i = i + 1) >= 2) {
                return false;
            }
            i = i;
        }
        return i == 1;
    }

    private void z(Intent intent) {
        Intent intent2 = new Intent();
        intent2.putExtra("album_result", this.kMT.getWriteImagesInfo().toJsonString());
        intent2.putExtra("camera_request_from", this.requestFrom);
        intent2.putExtra("from_type", this.aCb);
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
            this.kMT.getWriteImagesInfo().setChosedFiles(linkedList);
            intent.putExtra("album_result", this.kMT.getWriteImagesInfo().toJsonString());
            intent.putExtra("camera_request_from", this.requestFrom);
            intent.putExtra("from_type", this.aCb);
            setResult(-1, intent);
            finish();
        }
    }

    private boolean bnl() {
        Activity pageActivity = getPageContext().getPageActivity();
        PermissionJudgePolicy permissionJudgePolicy = new PermissionJudgePolicy();
        permissionJudgePolicy.clearRequestPermissionList();
        permissionJudgePolicy.appendRequestPermission(pageActivity, PermissionRequest.RESOURCE_VIDEO_CAPTURE);
        permissionJudgePolicy.appendRequestPermission(pageActivity, PermissionRequest.RESOURCE_AUDIO_CAPTURE);
        permissionJudgePolicy.appendRequestPermission(pageActivity, "android.permission.WRITE_EXTERNAL_STORAGE");
        return permissionJudgePolicy.startRequestPermission(pageActivity);
    }

    public void e(TbPageContext tbPageContext) {
        if (!bnl() && com.baidu.tieba.write.i.cUs()) {
            sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new RecordVideoActivityConfig(tbPageContext.getPageActivity(), this.aCa ? 2 : 3, new ForumWriteData(this.forumId, this.forumName, null, null), this.kMT.getWriteImagesInfo(), "", this.aCb)));
            TiebaStatic.log(new an(CommonStatisticKey.KEY_ENTRANCE_CLICKED).X("obj_locate", 5).X("obj_type", 2));
        }
    }

    private void Ak() {
        WriteImagesInfo writeImagesInfo;
        if (this.kMT != null && (writeImagesInfo = this.kMT.getWriteImagesInfo()) != null) {
            sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new WriteMulitImageActivityConfig(getPageContext().getPageActivity(), RequestResponseCode.REQUEST_MOTU_IMAGE, writeImagesInfo, cUA())));
        }
    }

    private int cUA() {
        if (this.kMT == null || v.getCount(this.kMT.AG()) == 0) {
            return 0;
        }
        for (int i = 0; i < v.getCount(this.kMT.AG()); i++) {
            ImageFileInfo imageFileInfo = this.kMT.AG().get(i);
            if (imageFileInfo != null && imageFileInfo.getImageType() == 0) {
                return i;
            }
        }
        return 0;
    }

    private void A(Intent intent) {
        this.kMW = intent;
        if (intent == null || this.kMT == null) {
            z(null);
            return;
        }
        String stringExtra = intent.getStringExtra("album_result");
        if (stringExtra != null) {
            WriteImagesInfo writeImagesInfo = this.kMT.getWriteImagesInfo();
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
        if (view == this.kMU.At()) {
            Aj();
        } else if (view == this.kMU.Av()) {
            Aj();
        } else if (view == this.kMU.As()) {
            if (this.kMT != null) {
                this.kMT.setLastAlbumId(null);
            }
            Aq();
        } else if (view == this.kMU.Au()) {
            cM(0);
        } else if (view == this.kMU.Aw()) {
            cK(2);
        } else if (view == this.kMU.Ax()) {
            cK(1);
        }
    }

    private void cK(int i) {
        if (this.kMU != null && this.kMT != null) {
            this.kMT.setOriginalImg(!this.kMT.isOriginalImg());
            Al();
            cL(i);
        }
    }

    private void cL(int i) {
        if (this.kMT != null && this.kMT.isOriginalImg() && !StringUtils.isNull(this.from, true) && !StringUtils.isNull(this.forumId, true)) {
            TiebaStatic.log(new an("c10349").cy("fid", this.forumId).cy("obj_type", this.from).X("obj_locate", i));
        }
    }

    public void Al() {
        if (this.kMT != null && this.kMU != null) {
            this.kMU.bt(this.kMT.isOriginalImg());
        }
    }

    public View Am() {
        return this.aCc;
    }

    public int An() {
        return this.aBY;
    }

    public c cUB() {
        return this.kMT;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void cM(int i) {
        if (!this.aBW) {
            FragmentTransaction beginTransaction = getSupportFragmentManager().beginTransaction();
            Fragment findFragmentByTag = getSupportFragmentManager().findFragmentByTag(this.kMU.cO(this.akk));
            if (findFragmentByTag != null) {
                beginTransaction.hide(findFragmentByTag);
            }
            this.akk = i;
            if (getSupportFragmentManager().findFragmentByTag(this.kMU.cO(i)) != null) {
                beginTransaction.show(this.kMU.cN(i));
            } else {
                beginTransaction.add(R.id.fragment, this.kMU.cN(i), this.kMU.cO(i));
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
        int maxImagesAllowed = this.kMT.getMaxImagesAllowed();
        if (this.kMT.size() < maxImagesAllowed) {
            if (this.kMV == null || this.kMV.g(imageFileInfo)) {
                ImageFileInfo imageFileInfo2 = new ImageFileInfo();
                imageFileInfo2.setAlbumnId(imageFileInfo.getAlbumId());
                imageFileInfo2.setFilePath(imageFileInfo.getFilePath());
                imageFileInfo2.setModifyTime(imageFileInfo.getModifyTime());
                imageFileInfo2.setIsGif(imageFileInfo.isGif());
                imageFileInfo2.setIsLong(imageFileInfo.isLong());
                this.kMT.a(null);
                this.kMT.addChooseFile(imageFileInfo2);
                Al();
                return true;
            }
            return false;
        } else if (Ap()) {
            return e(imageFileInfo);
        } else {
            showToast(String.format(getPageContext().getContext().getString(R.string.max_choose_image_count), Integer.valueOf(maxImagesAllowed)));
            return false;
        }
    }

    public boolean Ap() {
        if (getIntent().getBooleanExtra("select_directly", false)) {
            int maxImagesAllowed = this.kMT.getMaxImagesAllowed();
            if (this.kMT.size() == maxImagesAllowed && maxImagesAllowed == 1) {
                try {
                    ImageFileInfo imageFileInfo = (ImageFileInfo) v.getItem(this.kMT.AG(), 0);
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
        this.kMT.a(null);
        this.kMT.delChooseFile(imageFileInfo);
        Al();
        return true;
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i == 4) {
            closeLoadingDialog();
            if (this.akk == 0) {
                if (this.kMT != null) {
                    this.kMT.setLastAlbumId(null);
                }
                Aq();
                return true;
            } else if (this.akk == 1) {
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
        if (this.kMU != null && (cN = this.kMU.cN(0)) != null && (cN instanceof ImageListFragment)) {
            ((ImageListFragment) cN).h(imageFileInfo, z);
        }
    }

    void g(ImageFileInfo imageFileInfo, boolean z) {
        Fragment cN;
        if (this.kMU != null && (cN = this.kMU.cN(1)) != null && (cN instanceof AlbumImageBrowseFragment)) {
            ((AlbumImageBrowseFragment) cN).h(imageFileInfo, z);
        }
    }

    private void Aq() {
        Intent intent = new Intent();
        String lastAlbumId = this.kMT.getLastAlbumId();
        if (TextUtils.isEmpty(lastAlbumId)) {
            lastAlbumId = "";
        }
        intent.putExtra("last_album_id", lastAlbumId);
        intent.putExtra("camera_request_from", this.requestFrom);
        setResult(0, intent);
        finish();
    }

    private void stopCamera() {
        if (this.kMU != null) {
            this.kMU.stopCamera();
        }
    }

    private void FF() {
        if (this.kMU != null) {
            this.kMU.FF();
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
        this.aBW = true;
        stopCamera();
        closeLoadingDialog();
        dismissAllDialog();
        d.cUE().destory();
        if (this.aCc != null) {
            this.aCc.setBackgroundDrawable(null);
        }
        if (this.kMU != null) {
            this.kMU.onDestroy();
        }
        if (this.kMX != null) {
            this.kMX.onDestroy();
        }
        Intent intent = new Intent();
        intent.setAction(AlbumActivityConfig.ACTION_SELECT_IMAGE_RESULT);
        intent.putExtra("album_result", this.kMT.getWriteImagesInfo().toJsonString());
        intent.putExtra("camera_request_from", this.requestFrom);
        intent.putExtra("from_type", this.aCb);
        if (this.kMW != null && !StringUtils.isNull(this.kMW.getStringExtra("file_name"))) {
            intent.putExtra("file_name", this.kMW.getStringExtra("file_name"));
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
            new com.baidu.tbadk.img.f(null).c(AlbumActivity.this.kMT.getWriteImagesInfo(), true);
            return AlbumActivity.this.kMT.getWriteImagesInfo().toJsonString();
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
        if (this.kMX != null) {
            this.kMX.onStart();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.adp.base.BdBaseFragmentActivity, android.support.v4.app.FragmentActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        FF();
        if (this.kMX != null) {
            this.kMX.onResume();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.base.BdBaseFragmentActivity, android.support.v4.app.FragmentActivity, android.app.Activity
    public void onStop() {
        super.onStop();
        if (this.kMX != null) {
            this.kMX.onStop();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.adp.base.BdBaseFragmentActivity, android.support.v4.app.FragmentActivity, android.app.Activity
    public void onPause() {
        stopCamera();
        super.onPause();
    }
}
