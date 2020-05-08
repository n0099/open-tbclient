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
public class AlbumActivity extends BaseFragmentActivity implements View.OnClickListener, a.InterfaceC0121a {
    private boolean aWd;
    private com.baidu.tieba.c.d jzD;
    private c lxX;
    private com.baidu.tieba.write.album.a lxY;
    private e lxZ;
    private Intent lya;
    private i lyb;
    private FrsTabInfoData lyc;
    private int aCY = 0;
    private boolean aVW = false;
    private String callFrom = "";
    private String from = "";
    private String forumName = "";
    private String forumId = "0";
    private int requestFrom = 0;
    private int aVY = 0;
    private boolean aVZ = false;
    private boolean aWa = false;
    private int aWb = 0;
    private View aWc = null;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.adp.base.BdBaseFragmentActivity, android.support.v4.app.FragmentActivity, android.support.v4.app.SupportActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setSwipeBackEnabled(false);
        setContentView(R.layout.album_activity);
        this.aWc = findViewById(R.id.statebar_view);
        this.aWd = UtilHelper.canUseStyleImmersiveSticky();
        Fl();
        initData(bundle);
        this.lxY = new com.baidu.tieba.write.album.a(this);
        this.lxY.Fv();
        db(0);
    }

    public void showTip(View view) {
        if (this.jzD == null && view != null) {
            this.jzD = new com.baidu.tieba.c.d(getPageContext(), view);
            this.jzD.cz(R.drawable.bg_tip_blue_up_left);
            this.jzD.c(new View.OnClickListener() { // from class: com.baidu.tieba.write.album.AlbumActivity.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    AlbumActivity.this.jzD.ED();
                }
            });
            this.jzD.cy(16);
            this.jzD.cA(5000);
        }
        if (this.jzD != null) {
            String sharedPrefKeyWithAccount = com.baidu.tbadk.core.sharedPref.b.getSharedPrefKeyWithAccount(SharedPrefConfig.KEY_SHOW_TAKE_PHOTO_TIP);
            this.jzD.al(getString(R.string.album_take_photo_tip), sharedPrefKeyWithAccount);
        }
    }

    private void Fl() {
        if (this.aWc != null) {
            if (this.aWd && this.aWc.getLayoutParams() != null) {
                ViewGroup.LayoutParams layoutParams = this.aWc.getLayoutParams();
                layoutParams.height = UtilHelper.getStatusBarHeight();
                this.aWc.setLayoutParams(layoutParams);
                bX(true);
                return;
            }
            bX(false);
        }
    }

    private void bX(boolean z) {
        if (this.aWc != null) {
            if (this.aWd && z && this.aWc.getVisibility() != 0) {
                this.aWc.setVisibility(0);
            } else if (!z && this.aWc.getVisibility() != 8) {
                this.aWc.setVisibility(8);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.support.v4.app.FragmentActivity, android.support.v4.app.SupportActivity, android.app.Activity
    public void onSaveInstanceState(Bundle bundle) {
        bundle.putString("write_images_info", this.lxX.getWriteImagesInfo().toJsonString());
        bundle.putBoolean("use_original_img", this.aVZ);
        bundle.putInt("camera_request_from", this.requestFrom);
        bundle.putString("forum_id", this.forumId);
        bundle.putString("forum_name", this.forumName);
        bundle.putInt("album_thread", this.aVY);
        bundle.putBoolean("from_write", this.aWa);
        bundle.putSerializable("tab_list", this.lyc);
    }

    private void initData(Bundle bundle) {
        this.lxX = new c(this);
        if (bundle != null) {
            WriteImagesInfo writeImagesInfo = new WriteImagesInfo();
            writeImagesInfo.parseJson(bundle.getString("write_images_info"));
            this.lxX.setWriteImagesInfo(writeImagesInfo);
            this.aVZ = bundle.getBoolean("use_original_img", false);
            this.requestFrom = bundle.getInt("camera_request_from", 0);
            this.forumId = bundle.getString("forum_id");
            this.forumName = bundle.getString("forum_name");
            this.aVY = bundle.getInt("album_thread");
            this.aWa = bundle.getBoolean("from_write");
            this.callFrom = bundle.getString("KEY_CALL_FROM");
            this.aWb = bundle.getInt("from_type");
            this.lyc = (FrsTabInfoData) bundle.getSerializable("tab_list");
            this.from = bundle.getString("from");
        } else {
            Intent intent = getIntent();
            if (intent != null) {
                WriteImagesInfo writeImagesInfo2 = new WriteImagesInfo();
                writeImagesInfo2.parseJson(intent.getStringExtra("write_images_info"));
                this.lxX.setWriteImagesInfo(writeImagesInfo2);
                this.lxX.setOriginalImg(writeImagesInfo2.isOriginalImg());
                this.aVZ = intent.getBooleanExtra("use_original_img", false);
                this.requestFrom = intent.getIntExtra("camera_request_from", 0);
                this.from = intent.getStringExtra("from");
                this.forumId = intent.getStringExtra("forum_id");
                this.forumName = intent.getStringExtra("forum_name");
                this.aVY = intent.getIntExtra("album_thread", 0);
                this.aWa = intent.getBooleanExtra("from_write", false);
                this.callFrom = intent.getStringExtra("KEY_CALL_FROM");
                this.aWb = intent.getIntExtra("from_type", 0);
                this.lyc = (FrsTabInfoData) intent.getSerializableExtra("tab_list");
            }
        }
        Fm();
    }

    private void Fm() {
        if (this.requestFrom == 2) {
            this.lxZ = new e() { // from class: com.baidu.tieba.write.album.AlbumActivity.2
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
        if (this.lxY != null) {
            this.lxY.onChangeSkinType(i);
        }
        am.setBackgroundColor(this.aWc, R.color.cp_bg_line_d, i);
    }

    public void Fn() {
        if (this.requestFrom == 3) {
            TiebaStatic.log(TbadkCoreStatisticKey.UPGRADE_DIALOG_CHOOSE_IMAGE);
        }
        if (this.requestFrom == 5) {
            showLoadingDialog("正在上传");
            new a().execute(new String[0]);
        } else if (this.lxX != null) {
            if (this.lyb == null || !this.lyb.dfz()) {
                if (this.lxX.FI()) {
                    VideoFileInfo dfr = this.lxX.dfr();
                    if (this.lyb == null) {
                        this.lyb = new i(this, this.forumName, this.forumId, "");
                        this.lyb.a(this.lyc);
                        if (this.lxY != null) {
                            this.lxY.a(this.lyb);
                        }
                    }
                    if (getIntent() != null) {
                        this.lyb.setProfessionZone(getIntent().getIntExtra(WriteActivityConfig.KEY_PROFESSION_ZONE, -1));
                    }
                    this.lyb.a(dfr, this.callFrom, this.from);
                } else if (dfn()) {
                    Fo();
                } else {
                    l(null);
                }
            }
        }
    }

    private boolean dfn() {
        if (this.lxX == null || v.getCount(this.lxX.FK()) == 0) {
            return false;
        }
        int i = 0;
        for (ImageFileInfo imageFileInfo : this.lxX.FK()) {
            if (imageFileInfo != null && imageFileInfo.getImageType() == 0 && (i = i + 1) >= 2) {
                return false;
            }
            i = i;
        }
        return i == 1;
    }

    private void l(Intent intent) {
        Intent intent2 = new Intent();
        intent2.putExtra("album_result", this.lxX.getWriteImagesInfo().toJsonString());
        intent2.putExtra("camera_request_from", this.requestFrom);
        intent2.putExtra("from_type", this.aWb);
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
            this.lxX.getWriteImagesInfo().setChosedFiles(linkedList);
            intent.putExtra("album_result", this.lxX.getWriteImagesInfo().toJsonString());
            intent.putExtra("camera_request_from", this.requestFrom);
            intent.putExtra("from_type", this.aWb);
            setResult(-1, intent);
            finish();
        }
    }

    private boolean bwF() {
        Activity pageActivity = getPageContext().getPageActivity();
        PermissionJudgePolicy permissionJudgePolicy = new PermissionJudgePolicy();
        permissionJudgePolicy.clearRequestPermissionList();
        permissionJudgePolicy.appendRequestPermission(pageActivity, PermissionRequest.RESOURCE_VIDEO_CAPTURE);
        permissionJudgePolicy.appendRequestPermission(pageActivity, PermissionRequest.RESOURCE_AUDIO_CAPTURE);
        permissionJudgePolicy.appendRequestPermission(pageActivity, "android.permission.WRITE_EXTERNAL_STORAGE");
        return permissionJudgePolicy.startRequestPermission(pageActivity);
    }

    public void e(TbPageContext tbPageContext) {
        if (!bwF() && com.baidu.tieba.write.i.dff()) {
            sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new RecordVideoActivityConfig(tbPageContext.getPageActivity(), this.aWa ? 2 : 3, new ForumWriteData(this.forumId, this.forumName, null, null), this.lxX.getWriteImagesInfo(), "", this.aWb)));
            TiebaStatic.log(new an(CommonStatisticKey.KEY_ENTRANCE_CLICKED).af("obj_locate", 5).af("obj_type", 2));
        }
    }

    private void Fo() {
        WriteImagesInfo writeImagesInfo;
        if (this.lxX != null && (writeImagesInfo = this.lxX.getWriteImagesInfo()) != null) {
            sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new WriteMulitImageActivityConfig(getPageContext().getPageActivity(), RequestResponseCode.REQUEST_MOTU_IMAGE, writeImagesInfo, dfo())));
        }
    }

    private int dfo() {
        if (this.lxX == null || v.getCount(this.lxX.FK()) == 0) {
            return 0;
        }
        for (int i = 0; i < v.getCount(this.lxX.FK()); i++) {
            ImageFileInfo imageFileInfo = this.lxX.FK().get(i);
            if (imageFileInfo != null && imageFileInfo.getImageType() == 0) {
                return i;
            }
        }
        return 0;
    }

    private void m(Intent intent) {
        this.lya = intent;
        if (intent == null || this.lxX == null) {
            l(null);
            return;
        }
        String stringExtra = intent.getStringExtra("album_result");
        if (stringExtra != null) {
            WriteImagesInfo writeImagesInfo = this.lxX.getWriteImagesInfo();
            writeImagesInfo.parseJson(stringExtra);
            writeImagesInfo.updateQuality();
            l(intent);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragmentActivity, android.support.v4.app.FragmentActivity, android.app.Activity
    public void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (i2 == -1) {
            m(intent);
        }
    }

    @Override // com.baidu.adp.base.BdBaseFragmentActivity, android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.lxY.Fx()) {
            Fn();
        } else if (view == this.lxY.Fz()) {
            Fn();
        } else if (view == this.lxY.Fw()) {
            if (this.lxX != null) {
                this.lxX.setLastAlbumId(null);
            }
            Fu();
        } else if (view == this.lxY.Fy()) {
            db(0);
        } else if (view == this.lxY.FA()) {
            cZ(2);
        } else if (view == this.lxY.FB()) {
            cZ(1);
        }
    }

    private void cZ(int i) {
        if (this.lxY != null && this.lxX != null) {
            this.lxX.setOriginalImg(!this.lxX.isOriginalImg());
            Fp();
            da(i);
        }
    }

    private void da(int i) {
        if (this.lxX != null && this.lxX.isOriginalImg() && !StringUtils.isNull(this.from, true) && !StringUtils.isNull(this.forumId, true)) {
            TiebaStatic.log(new an("c10349").cI("fid", this.forumId).cI("obj_type", this.from).af("obj_locate", i));
        }
    }

    public void Fp() {
        if (this.lxX != null && this.lxY != null) {
            this.lxY.bY(this.lxX.isOriginalImg());
        }
    }

    public View Fq() {
        return this.aWc;
    }

    public int Fr() {
        return this.aVY;
    }

    public c dfp() {
        return this.lxX;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void db(int i) {
        if (!this.aVW) {
            FragmentTransaction beginTransaction = getSupportFragmentManager().beginTransaction();
            Fragment findFragmentByTag = getSupportFragmentManager().findFragmentByTag(this.lxY.dd(this.aCY));
            if (findFragmentByTag != null) {
                beginTransaction.hide(findFragmentByTag);
            }
            this.aCY = i;
            if (getSupportFragmentManager().findFragmentByTag(this.lxY.dd(i)) != null) {
                beginTransaction.show(this.lxY.dc(i));
            } else {
                beginTransaction.add(R.id.fragment, this.lxY.dc(i), this.lxY.dd(i));
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
        int maxImagesAllowed = this.lxX.getMaxImagesAllowed();
        if (this.lxX.size() < maxImagesAllowed) {
            if (this.lxZ == null || this.lxZ.g(imageFileInfo)) {
                ImageFileInfo imageFileInfo2 = new ImageFileInfo();
                imageFileInfo2.setAlbumnId(imageFileInfo.getAlbumId());
                imageFileInfo2.setContentUriStr(imageFileInfo.getContentUriStr());
                imageFileInfo2.setFilePath(imageFileInfo.getFilePath());
                imageFileInfo2.setModifyTime(imageFileInfo.getModifyTime());
                imageFileInfo2.setIsGif(imageFileInfo.isGif());
                imageFileInfo2.setIsLong(imageFileInfo.isLong());
                this.lxX.a(null);
                this.lxX.addChooseFile(imageFileInfo2);
                Fp();
                return true;
            }
            return false;
        } else if (Ft()) {
            return e(imageFileInfo);
        } else {
            showToast(String.format(getPageContext().getContext().getString(R.string.max_choose_image_count), Integer.valueOf(maxImagesAllowed)));
            return false;
        }
    }

    public boolean Ft() {
        if (getIntent().getBooleanExtra("select_directly", false)) {
            int maxImagesAllowed = this.lxX.getMaxImagesAllowed();
            if (this.lxX.size() == maxImagesAllowed && maxImagesAllowed == 1) {
                try {
                    ImageFileInfo imageFileInfo = (ImageFileInfo) v.getItem(this.lxX.FK(), 0);
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
        this.lxX.a(null);
        this.lxX.delChooseFile(imageFileInfo);
        Fp();
        return true;
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i == 4) {
            closeLoadingDialog();
            if (this.aCY == 0) {
                if (this.lxX != null) {
                    this.lxX.setLastAlbumId(null);
                }
                Fu();
                return true;
            } else if (this.aCY == 1) {
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
        if (this.lxY != null && (dc = this.lxY.dc(0)) != null && (dc instanceof ImageListFragment)) {
            ((ImageListFragment) dc).h(imageFileInfo, z);
        }
    }

    void g(ImageFileInfo imageFileInfo, boolean z) {
        Fragment dc;
        if (this.lxY != null && (dc = this.lxY.dc(1)) != null && (dc instanceof AlbumImageBrowseFragment)) {
            ((AlbumImageBrowseFragment) dc).h(imageFileInfo, z);
        }
    }

    private void Fu() {
        Intent intent = new Intent();
        String lastAlbumId = this.lxX.getLastAlbumId();
        if (TextUtils.isEmpty(lastAlbumId)) {
            lastAlbumId = "";
        }
        intent.putExtra("last_album_id", lastAlbumId);
        intent.putExtra("camera_request_from", this.requestFrom);
        setResult(0, intent);
        finish();
    }

    private void stopCamera() {
        if (this.lxY != null) {
            this.lxY.stopCamera();
        }
    }

    private void Nv() {
        if (this.lxY != null) {
            this.lxY.Nv();
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
        this.aVW = true;
        stopCamera();
        closeLoadingDialog();
        dismissAllDialog();
        d.dfs().destory();
        if (this.aWc != null) {
            this.aWc.setBackgroundDrawable(null);
        }
        if (this.lxY != null) {
            this.lxY.onDestroy();
        }
        if (this.lyb != null) {
            this.lyb.onDestroy();
        }
        Intent intent = new Intent();
        intent.setAction(AlbumActivityConfig.ACTION_SELECT_IMAGE_RESULT);
        intent.putExtra("album_result", this.lxX.getWriteImagesInfo().toJsonString());
        intent.putExtra("camera_request_from", this.requestFrom);
        intent.putExtra("from_type", this.aWb);
        if (this.lya != null && !StringUtils.isNull(this.lya.getStringExtra("file_name"))) {
            intent.putExtra("file_name", this.lya.getStringExtra("file_name"));
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
            new com.baidu.tbadk.img.f(null).c(AlbumActivity.this.lxX.getWriteImagesInfo(), true);
            return AlbumActivity.this.lxX.getWriteImagesInfo().toJsonString();
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
        if (this.lyb != null) {
            this.lyb.onStart();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.adp.base.BdBaseFragmentActivity, android.support.v4.app.FragmentActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        Nv();
        if (this.lyb != null) {
            this.lyb.onResume();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.base.BdBaseFragmentActivity, android.support.v4.app.FragmentActivity, android.app.Activity
    public void onStop() {
        super.onStop();
        if (this.lyb != null) {
            this.lyb.onStop();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.adp.base.BdBaseFragmentActivity, android.support.v4.app.FragmentActivity, android.app.Activity
    public void onPause() {
        stopCamera();
        super.onPause();
    }
}
