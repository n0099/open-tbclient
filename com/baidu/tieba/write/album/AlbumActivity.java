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
import com.baidu.h.a.a;
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
import com.baidu.tieba.frs.FrsTabInfoData;
import com.baidu.webkit.sdk.PermissionRequest;
import java.util.LinkedList;
/* loaded from: classes2.dex */
public class AlbumActivity extends BaseFragmentActivity implements View.OnClickListener, a.InterfaceC0100a {
    private boolean aVY;
    private com.baidu.tieba.c.d jzz;
    private c lxT;
    private com.baidu.tieba.write.album.a lxU;
    private e lxV;
    private Intent lxW;
    private i lxX;
    private FrsTabInfoData lxY;
    private int aCS = 0;
    private boolean aVR = false;
    private String callFrom = "";
    private String from = "";
    private String forumName = "";
    private String forumId = "0";
    private int requestFrom = 0;
    private int aVT = 0;
    private boolean aVU = false;
    private boolean aVV = false;
    private int aVW = 0;
    private View aVX = null;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.adp.base.BdBaseFragmentActivity, android.support.v4.app.FragmentActivity, android.support.v4.app.SupportActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setSwipeBackEnabled(false);
        setContentView(R.layout.album_activity);
        this.aVX = findViewById(R.id.statebar_view);
        this.aVY = UtilHelper.canUseStyleImmersiveSticky();
        Fm();
        initData(bundle);
        this.lxU = new com.baidu.tieba.write.album.a(this);
        this.lxU.Fw();
        db(0);
    }

    public void showTip(View view) {
        if (this.jzz == null && view != null) {
            this.jzz = new com.baidu.tieba.c.d(getPageContext(), view);
            this.jzz.cz(R.drawable.bg_tip_blue_up_left);
            this.jzz.c(new View.OnClickListener() { // from class: com.baidu.tieba.write.album.AlbumActivity.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    AlbumActivity.this.jzz.EE();
                }
            });
            this.jzz.cy(16);
            this.jzz.cA(5000);
        }
        if (this.jzz != null) {
            String sharedPrefKeyWithAccount = com.baidu.tbadk.core.sharedPref.b.getSharedPrefKeyWithAccount(SharedPrefConfig.KEY_SHOW_TAKE_PHOTO_TIP);
            this.jzz.al(getString(R.string.album_take_photo_tip), sharedPrefKeyWithAccount);
        }
    }

    private void Fm() {
        if (this.aVX != null) {
            if (this.aVY && this.aVX.getLayoutParams() != null) {
                ViewGroup.LayoutParams layoutParams = this.aVX.getLayoutParams();
                layoutParams.height = UtilHelper.getStatusBarHeight();
                this.aVX.setLayoutParams(layoutParams);
                bX(true);
                return;
            }
            bX(false);
        }
    }

    private void bX(boolean z) {
        if (this.aVX != null) {
            if (this.aVY && z && this.aVX.getVisibility() != 0) {
                this.aVX.setVisibility(0);
            } else if (!z && this.aVX.getVisibility() != 8) {
                this.aVX.setVisibility(8);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.support.v4.app.FragmentActivity, android.support.v4.app.SupportActivity, android.app.Activity
    public void onSaveInstanceState(Bundle bundle) {
        bundle.putString("write_images_info", this.lxT.getWriteImagesInfo().toJsonString());
        bundle.putBoolean("use_original_img", this.aVU);
        bundle.putInt("camera_request_from", this.requestFrom);
        bundle.putString("forum_id", this.forumId);
        bundle.putString("forum_name", this.forumName);
        bundle.putInt("album_thread", this.aVT);
        bundle.putBoolean("from_write", this.aVV);
        bundle.putSerializable("tab_list", this.lxY);
    }

    private void initData(Bundle bundle) {
        this.lxT = new c(this);
        if (bundle != null) {
            WriteImagesInfo writeImagesInfo = new WriteImagesInfo();
            writeImagesInfo.parseJson(bundle.getString("write_images_info"));
            this.lxT.setWriteImagesInfo(writeImagesInfo);
            this.aVU = bundle.getBoolean("use_original_img", false);
            this.requestFrom = bundle.getInt("camera_request_from", 0);
            this.forumId = bundle.getString("forum_id");
            this.forumName = bundle.getString("forum_name");
            this.aVT = bundle.getInt("album_thread");
            this.aVV = bundle.getBoolean("from_write");
            this.callFrom = bundle.getString("KEY_CALL_FROM");
            this.aVW = bundle.getInt("from_type");
            this.lxY = (FrsTabInfoData) bundle.getSerializable("tab_list");
            this.from = bundle.getString("from");
        } else {
            Intent intent = getIntent();
            if (intent != null) {
                WriteImagesInfo writeImagesInfo2 = new WriteImagesInfo();
                writeImagesInfo2.parseJson(intent.getStringExtra("write_images_info"));
                this.lxT.setWriteImagesInfo(writeImagesInfo2);
                this.lxT.setOriginalImg(writeImagesInfo2.isOriginalImg());
                this.aVU = intent.getBooleanExtra("use_original_img", false);
                this.requestFrom = intent.getIntExtra("camera_request_from", 0);
                this.from = intent.getStringExtra("from");
                this.forumId = intent.getStringExtra("forum_id");
                this.forumName = intent.getStringExtra("forum_name");
                this.aVT = intent.getIntExtra("album_thread", 0);
                this.aVV = intent.getBooleanExtra("from_write", false);
                this.callFrom = intent.getStringExtra("KEY_CALL_FROM");
                this.aVW = intent.getIntExtra("from_type", 0);
                this.lxY = (FrsTabInfoData) intent.getSerializableExtra("tab_list");
            }
        }
        Fn();
    }

    private void Fn() {
        if (this.requestFrom == 2) {
            this.lxV = new e() { // from class: com.baidu.tieba.write.album.AlbumActivity.2
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
        if (this.lxU != null) {
            this.lxU.onChangeSkinType(i);
        }
        am.setBackgroundColor(this.aVX, R.color.cp_bg_line_d, i);
    }

    public void Fo() {
        if (this.requestFrom == 3) {
            TiebaStatic.log(TbadkCoreStatisticKey.UPGRADE_DIALOG_CHOOSE_IMAGE);
        }
        if (this.requestFrom == 5) {
            showLoadingDialog("正在上传");
            new a().execute(new String[0]);
        } else if (this.lxT != null) {
            if (this.lxX == null || !this.lxX.dfC()) {
                if (this.lxT.FJ()) {
                    VideoFileInfo dfu = this.lxT.dfu();
                    if (this.lxX == null) {
                        this.lxX = new i(this, this.forumName, this.forumId, "");
                        this.lxX.a(this.lxY);
                        if (this.lxU != null) {
                            this.lxU.a(this.lxX);
                        }
                    }
                    if (getIntent() != null) {
                        this.lxX.setProfessionZone(getIntent().getIntExtra(WriteActivityConfig.KEY_PROFESSION_ZONE, -1));
                    }
                    this.lxX.a(dfu, this.callFrom, this.from);
                } else if (dfq()) {
                    Fp();
                } else {
                    y(null);
                }
            }
        }
    }

    private boolean dfq() {
        if (this.lxT == null || v.getCount(this.lxT.FL()) == 0) {
            return false;
        }
        int i = 0;
        for (ImageFileInfo imageFileInfo : this.lxT.FL()) {
            if (imageFileInfo != null && imageFileInfo.getImageType() == 0 && (i = i + 1) >= 2) {
                return false;
            }
            i = i;
        }
        return i == 1;
    }

    private void y(Intent intent) {
        Intent intent2 = new Intent();
        intent2.putExtra("album_result", this.lxT.getWriteImagesInfo().toJsonString());
        intent2.putExtra("camera_request_from", this.requestFrom);
        intent2.putExtra("from_type", this.aVW);
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
            this.lxT.getWriteImagesInfo().setChosedFiles(linkedList);
            intent.putExtra("album_result", this.lxT.getWriteImagesInfo().toJsonString());
            intent.putExtra("camera_request_from", this.requestFrom);
            intent.putExtra("from_type", this.aVW);
            setResult(-1, intent);
            finish();
        }
    }

    private boolean bwH() {
        Activity pageActivity = getPageContext().getPageActivity();
        PermissionJudgePolicy permissionJudgePolicy = new PermissionJudgePolicy();
        permissionJudgePolicy.clearRequestPermissionList();
        permissionJudgePolicy.appendRequestPermission(pageActivity, PermissionRequest.RESOURCE_VIDEO_CAPTURE);
        permissionJudgePolicy.appendRequestPermission(pageActivity, PermissionRequest.RESOURCE_AUDIO_CAPTURE);
        permissionJudgePolicy.appendRequestPermission(pageActivity, "android.permission.WRITE_EXTERNAL_STORAGE");
        return permissionJudgePolicy.startRequestPermission(pageActivity);
    }

    public void e(TbPageContext tbPageContext) {
        if (!bwH() && com.baidu.tieba.write.i.dfi()) {
            sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new RecordVideoActivityConfig(tbPageContext.getPageActivity(), this.aVV ? 2 : 3, new ForumWriteData(this.forumId, this.forumName, null, null), this.lxT.getWriteImagesInfo(), "", this.aVW)));
            TiebaStatic.log(new an(CommonStatisticKey.KEY_ENTRANCE_CLICKED).af("obj_locate", 5).af("obj_type", 2));
        }
    }

    private void Fp() {
        WriteImagesInfo writeImagesInfo;
        if (this.lxT != null && (writeImagesInfo = this.lxT.getWriteImagesInfo()) != null) {
            sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new WriteMulitImageActivityConfig(getPageContext().getPageActivity(), RequestResponseCode.REQUEST_MOTU_IMAGE, writeImagesInfo, dfr())));
        }
    }

    private int dfr() {
        if (this.lxT == null || v.getCount(this.lxT.FL()) == 0) {
            return 0;
        }
        for (int i = 0; i < v.getCount(this.lxT.FL()); i++) {
            ImageFileInfo imageFileInfo = this.lxT.FL().get(i);
            if (imageFileInfo != null && imageFileInfo.getImageType() == 0) {
                return i;
            }
        }
        return 0;
    }

    private void z(Intent intent) {
        this.lxW = intent;
        if (intent == null || this.lxT == null) {
            y(null);
            return;
        }
        String stringExtra = intent.getStringExtra("album_result");
        if (stringExtra != null) {
            WriteImagesInfo writeImagesInfo = this.lxT.getWriteImagesInfo();
            writeImagesInfo.parseJson(stringExtra);
            writeImagesInfo.updateQuality();
            y(intent);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragmentActivity, android.support.v4.app.FragmentActivity, android.app.Activity
    public void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (i2 == -1) {
            z(intent);
        }
    }

    @Override // com.baidu.adp.base.BdBaseFragmentActivity, android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.lxU.Fy()) {
            Fo();
        } else if (view == this.lxU.FA()) {
            Fo();
        } else if (view == this.lxU.Fx()) {
            if (this.lxT != null) {
                this.lxT.setLastAlbumId(null);
            }
            Fv();
        } else if (view == this.lxU.Fz()) {
            db(0);
        } else if (view == this.lxU.FB()) {
            cZ(2);
        } else if (view == this.lxU.FC()) {
            cZ(1);
        }
    }

    private void cZ(int i) {
        if (this.lxU != null && this.lxT != null) {
            this.lxT.setOriginalImg(!this.lxT.isOriginalImg());
            Fq();
            da(i);
        }
    }

    private void da(int i) {
        if (this.lxT != null && this.lxT.isOriginalImg() && !StringUtils.isNull(this.from, true) && !StringUtils.isNull(this.forumId, true)) {
            TiebaStatic.log(new an("c10349").cI("fid", this.forumId).cI("obj_type", this.from).af("obj_locate", i));
        }
    }

    public void Fq() {
        if (this.lxT != null && this.lxU != null) {
            this.lxU.bY(this.lxT.isOriginalImg());
        }
    }

    public View Fr() {
        return this.aVX;
    }

    public int Fs() {
        return this.aVT;
    }

    public c dfs() {
        return this.lxT;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void db(int i) {
        if (!this.aVR) {
            FragmentTransaction beginTransaction = getSupportFragmentManager().beginTransaction();
            Fragment findFragmentByTag = getSupportFragmentManager().findFragmentByTag(this.lxU.dd(this.aCS));
            if (findFragmentByTag != null) {
                beginTransaction.hide(findFragmentByTag);
            }
            this.aCS = i;
            if (getSupportFragmentManager().findFragmentByTag(this.lxU.dd(i)) != null) {
                beginTransaction.show(this.lxU.dc(i));
            } else {
                beginTransaction.add(R.id.fragment, this.lxU.dc(i), this.lxU.dd(i));
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
        int maxImagesAllowed = this.lxT.getMaxImagesAllowed();
        if (this.lxT.size() < maxImagesAllowed) {
            if (this.lxV == null || this.lxV.g(imageFileInfo)) {
                ImageFileInfo imageFileInfo2 = new ImageFileInfo();
                imageFileInfo2.setAlbumnId(imageFileInfo.getAlbumId());
                imageFileInfo2.setContentUriStr(imageFileInfo.getContentUriStr());
                imageFileInfo2.setFilePath(imageFileInfo.getFilePath());
                imageFileInfo2.setModifyTime(imageFileInfo.getModifyTime());
                imageFileInfo2.setIsGif(imageFileInfo.isGif());
                imageFileInfo2.setIsLong(imageFileInfo.isLong());
                this.lxT.a(null);
                this.lxT.addChooseFile(imageFileInfo2);
                Fq();
                return true;
            }
            return false;
        } else if (Fu()) {
            return e(imageFileInfo);
        } else {
            showToast(String.format(getPageContext().getContext().getString(R.string.max_choose_image_count), Integer.valueOf(maxImagesAllowed)));
            return false;
        }
    }

    public boolean Fu() {
        if (getIntent().getBooleanExtra("select_directly", false)) {
            int maxImagesAllowed = this.lxT.getMaxImagesAllowed();
            if (this.lxT.size() == maxImagesAllowed && maxImagesAllowed == 1) {
                try {
                    ImageFileInfo imageFileInfo = (ImageFileInfo) v.getItem(this.lxT.FL(), 0);
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
        this.lxT.a(null);
        this.lxT.delChooseFile(imageFileInfo);
        Fq();
        return true;
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i == 4) {
            closeLoadingDialog();
            if (this.aCS == 0) {
                if (this.lxT != null) {
                    this.lxT.setLastAlbumId(null);
                }
                Fv();
                return true;
            } else if (this.aCS == 1) {
                db(0);
                return true;
            } else {
                return true;
            }
        }
        return super.onKeyDown(i, keyEvent);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void f(ImageFileInfo imageFileInfo, boolean z) {
        Fragment dc;
        if (this.lxU != null && (dc = this.lxU.dc(0)) != null && (dc instanceof ImageListFragment)) {
            ((ImageListFragment) dc).h(imageFileInfo, z);
        }
    }

    void g(ImageFileInfo imageFileInfo, boolean z) {
        Fragment dc;
        if (this.lxU != null && (dc = this.lxU.dc(1)) != null && (dc instanceof AlbumImageBrowseFragment)) {
            ((AlbumImageBrowseFragment) dc).h(imageFileInfo, z);
        }
    }

    private void Fv() {
        Intent intent = new Intent();
        String lastAlbumId = this.lxT.getLastAlbumId();
        if (TextUtils.isEmpty(lastAlbumId)) {
            lastAlbumId = "";
        }
        intent.putExtra("last_album_id", lastAlbumId);
        intent.putExtra("camera_request_from", this.requestFrom);
        setResult(0, intent);
        finish();
    }

    private void stopCamera() {
        if (this.lxU != null) {
            this.lxU.stopCamera();
        }
    }

    private void Nw() {
        if (this.lxU != null) {
            this.lxU.Nw();
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
        this.aVR = true;
        stopCamera();
        closeLoadingDialog();
        dismissAllDialog();
        d.dfv().destory();
        if (this.aVX != null) {
            this.aVX.setBackgroundDrawable(null);
        }
        if (this.lxU != null) {
            this.lxU.onDestroy();
        }
        if (this.lxX != null) {
            this.lxX.onDestroy();
        }
        Intent intent = new Intent();
        intent.setAction(AlbumActivityConfig.ACTION_SELECT_IMAGE_RESULT);
        intent.putExtra("album_result", this.lxT.getWriteImagesInfo().toJsonString());
        intent.putExtra("camera_request_from", this.requestFrom);
        intent.putExtra("from_type", this.aVW);
        if (this.lxW != null && !StringUtils.isNull(this.lxW.getStringExtra("file_name"))) {
            intent.putExtra("file_name", this.lxW.getStringExtra("file_name"));
        }
        TbadkCoreApplication.getInst().sendBroadcast(intent);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public class a extends BdAsyncTask<String, Integer, String> {
        private a() {
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public String doInBackground(String... strArr) {
            new com.baidu.tbadk.img.f(null).c(AlbumActivity.this.lxT.getWriteImagesInfo(), true);
            return AlbumActivity.this.lxT.getWriteImagesInfo().toJsonString();
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
        if (this.lxX != null) {
            this.lxX.onStart();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.adp.base.BdBaseFragmentActivity, android.support.v4.app.FragmentActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        Nw();
        if (this.lxX != null) {
            this.lxX.onResume();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.base.BdBaseFragmentActivity, android.support.v4.app.FragmentActivity, android.app.Activity
    public void onStop() {
        super.onStop();
        if (this.lxX != null) {
            this.lxX.onStop();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.adp.base.BdBaseFragmentActivity, android.support.v4.app.FragmentActivity, android.app.Activity
    public void onPause() {
        stopCamera();
        super.onPause();
    }
}
