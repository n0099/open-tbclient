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
import com.baidu.tieba.frs.FrsTabInfoData;
import com.baidu.webkit.sdk.PermissionRequest;
import java.util.LinkedList;
/* loaded from: classes13.dex */
public class AlbumActivity extends BaseFragmentActivity implements View.OnClickListener, a.InterfaceC0078a {
    private boolean aCr;
    private com.baidu.tieba.c.d iPq;
    private c kOC;
    private com.baidu.tieba.write.album.a kOD;
    private e kOE;
    private Intent kOF;
    private i kOG;
    private FrsTabInfoData kOH;
    private int aku = 0;
    private boolean aCk = false;
    private String callFrom = "";
    private String from = "";
    private String forumName = "";
    private String forumId = "0";
    private int requestFrom = 0;
    private int aCm = 0;
    private boolean aCn = false;
    private boolean aCo = false;
    private int aCp = 0;
    private View aCq = null;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.adp.base.BdBaseFragmentActivity, android.support.v4.app.FragmentActivity, android.support.v4.app.SupportActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setSwipeBackEnabled(false);
        setContentView(R.layout.album_activity);
        this.aCq = findViewById(R.id.statebar_view);
        this.aCr = UtilHelper.canUseStyleImmersiveSticky();
        Ao();
        initData(bundle);
        this.kOD = new com.baidu.tieba.write.album.a(this);
        this.kOD.Ay();
        cM(0);
    }

    public void showTip(View view) {
        if (this.iPq == null && view != null) {
            this.iPq = new com.baidu.tieba.c.d(getPageContext(), view);
            this.iPq.ck(R.drawable.bg_tip_blue_up_left);
            this.iPq.c(new View.OnClickListener() { // from class: com.baidu.tieba.write.album.AlbumActivity.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    AlbumActivity.this.iPq.zG();
                }
            });
            this.iPq.cj(16);
            this.iPq.cl(5000);
        }
        if (this.iPq != null) {
            String sharedPrefKeyWithAccount = com.baidu.tbadk.core.sharedPref.b.getSharedPrefKeyWithAccount(SharedPrefConfig.KEY_SHOW_TAKE_PHOTO_TIP);
            this.iPq.ai(getString(R.string.album_take_photo_tip), sharedPrefKeyWithAccount);
        }
    }

    private void Ao() {
        if (this.aCq != null) {
            if (this.aCr && this.aCq.getLayoutParams() != null) {
                ViewGroup.LayoutParams layoutParams = this.aCq.getLayoutParams();
                layoutParams.height = UtilHelper.getStatusBarHeight();
                this.aCq.setLayoutParams(layoutParams);
                bt(true);
                return;
            }
            bt(false);
        }
    }

    private void bt(boolean z) {
        if (this.aCq != null) {
            if (this.aCr && z && this.aCq.getVisibility() != 0) {
                this.aCq.setVisibility(0);
            } else if (!z && this.aCq.getVisibility() != 8) {
                this.aCq.setVisibility(8);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.support.v4.app.FragmentActivity, android.support.v4.app.SupportActivity, android.app.Activity
    public void onSaveInstanceState(Bundle bundle) {
        bundle.putString("write_images_info", this.kOC.getWriteImagesInfo().toJsonString());
        bundle.putBoolean("use_original_img", this.aCn);
        bundle.putInt("camera_request_from", this.requestFrom);
        bundle.putString("forum_id", this.forumId);
        bundle.putString("forum_name", this.forumName);
        bundle.putInt("album_thread", this.aCm);
        bundle.putBoolean("from_write", this.aCo);
        bundle.putSerializable("tab_list", this.kOH);
    }

    private void initData(Bundle bundle) {
        this.kOC = new c(this);
        if (bundle != null) {
            WriteImagesInfo writeImagesInfo = new WriteImagesInfo();
            writeImagesInfo.parseJson(bundle.getString("write_images_info"));
            this.kOC.setWriteImagesInfo(writeImagesInfo);
            this.aCn = bundle.getBoolean("use_original_img", false);
            this.requestFrom = bundle.getInt("camera_request_from", 0);
            this.forumId = bundle.getString("forum_id");
            this.forumName = bundle.getString("forum_name");
            this.aCm = bundle.getInt("album_thread");
            this.aCo = bundle.getBoolean("from_write");
            this.callFrom = bundle.getString("KEY_CALL_FROM");
            this.aCp = bundle.getInt("from_type");
            this.kOH = (FrsTabInfoData) bundle.getSerializable("tab_list");
        } else {
            Intent intent = getIntent();
            if (intent != null) {
                WriteImagesInfo writeImagesInfo2 = new WriteImagesInfo();
                writeImagesInfo2.parseJson(intent.getStringExtra("write_images_info"));
                this.kOC.setWriteImagesInfo(writeImagesInfo2);
                this.kOC.setOriginalImg(writeImagesInfo2.isOriginalImg());
                this.aCn = intent.getBooleanExtra("use_original_img", false);
                this.requestFrom = intent.getIntExtra("camera_request_from", 0);
                this.from = intent.getStringExtra("from");
                this.forumId = intent.getStringExtra("forum_id");
                this.forumName = intent.getStringExtra("forum_name");
                this.aCm = intent.getIntExtra("album_thread", 0);
                this.aCo = intent.getBooleanExtra("from_write", false);
                this.callFrom = intent.getStringExtra("KEY_CALL_FROM");
                this.aCp = intent.getIntExtra("from_type", 0);
                this.kOH = (FrsTabInfoData) intent.getSerializableExtra("tab_list");
            }
        }
        Ap();
    }

    private void Ap() {
        if (this.requestFrom == 2) {
            this.kOE = new e() { // from class: com.baidu.tieba.write.album.AlbumActivity.2
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
        if (this.kOD != null) {
            this.kOD.onChangeSkinType(i);
        }
        am.setBackgroundColor(this.aCq, R.color.cp_bg_line_d, i);
    }

    public void Aq() {
        if (this.requestFrom == 3) {
            TiebaStatic.log(TbadkCoreStatisticKey.UPGRADE_DIALOG_CHOOSE_IMAGE);
        }
        if (this.requestFrom == 5) {
            showLoadingDialog("正在上传");
            new a().execute(new String[0]);
        } else if (this.kOC != null) {
            if (this.kOG == null || !this.kOG.cVg()) {
                if (this.kOC.AL()) {
                    VideoFileInfo cUY = this.kOC.cUY();
                    if (this.kOG == null) {
                        this.kOG = new i(this, this.forumName, this.forumId, "");
                        this.kOG.a(this.kOH);
                        if (this.kOD != null) {
                            this.kOD.a(this.kOG);
                        }
                    }
                    if (getIntent() != null) {
                        this.kOG.setProfessionZone(getIntent().getIntExtra(WriteActivityConfig.KEY_PROFESSION_ZONE, -1));
                    }
                    this.kOG.a(cUY, this.callFrom);
                } else if (cUU()) {
                    Ar();
                } else {
                    z(null);
                }
            }
        }
    }

    private boolean cUU() {
        if (this.kOC == null || v.getCount(this.kOC.AN()) == 0) {
            return false;
        }
        int i = 0;
        for (ImageFileInfo imageFileInfo : this.kOC.AN()) {
            if (imageFileInfo != null && imageFileInfo.getImageType() == 0 && (i = i + 1) >= 2) {
                return false;
            }
            i = i;
        }
        return i == 1;
    }

    private void z(Intent intent) {
        Intent intent2 = new Intent();
        intent2.putExtra("album_result", this.kOC.getWriteImagesInfo().toJsonString());
        intent2.putExtra("camera_request_from", this.requestFrom);
        intent2.putExtra("from_type", this.aCp);
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
            this.kOC.getWriteImagesInfo().setChosedFiles(linkedList);
            intent.putExtra("album_result", this.kOC.getWriteImagesInfo().toJsonString());
            intent.putExtra("camera_request_from", this.requestFrom);
            intent.putExtra("from_type", this.aCp);
            setResult(-1, intent);
            finish();
        }
    }

    private boolean bnq() {
        Activity pageActivity = getPageContext().getPageActivity();
        PermissionJudgePolicy permissionJudgePolicy = new PermissionJudgePolicy();
        permissionJudgePolicy.clearRequestPermissionList();
        permissionJudgePolicy.appendRequestPermission(pageActivity, PermissionRequest.RESOURCE_VIDEO_CAPTURE);
        permissionJudgePolicy.appendRequestPermission(pageActivity, PermissionRequest.RESOURCE_AUDIO_CAPTURE);
        permissionJudgePolicy.appendRequestPermission(pageActivity, "android.permission.WRITE_EXTERNAL_STORAGE");
        return permissionJudgePolicy.startRequestPermission(pageActivity);
    }

    public void e(TbPageContext tbPageContext) {
        if (!bnq() && com.baidu.tieba.write.i.cUN()) {
            sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new RecordVideoActivityConfig(tbPageContext.getPageActivity(), this.aCo ? 2 : 3, new ForumWriteData(this.forumId, this.forumName, null, null), this.kOC.getWriteImagesInfo(), "", this.aCp)));
            TiebaStatic.log(new an(CommonStatisticKey.KEY_ENTRANCE_CLICKED).X("obj_locate", 5).X("obj_type", 2));
        }
    }

    private void Ar() {
        WriteImagesInfo writeImagesInfo;
        if (this.kOC != null && (writeImagesInfo = this.kOC.getWriteImagesInfo()) != null) {
            sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new WriteMulitImageActivityConfig(getPageContext().getPageActivity(), RequestResponseCode.REQUEST_MOTU_IMAGE, writeImagesInfo, cUV())));
        }
    }

    private int cUV() {
        if (this.kOC == null || v.getCount(this.kOC.AN()) == 0) {
            return 0;
        }
        for (int i = 0; i < v.getCount(this.kOC.AN()); i++) {
            ImageFileInfo imageFileInfo = this.kOC.AN().get(i);
            if (imageFileInfo != null && imageFileInfo.getImageType() == 0) {
                return i;
            }
        }
        return 0;
    }

    private void A(Intent intent) {
        this.kOF = intent;
        if (intent == null || this.kOC == null) {
            z(null);
            return;
        }
        String stringExtra = intent.getStringExtra("album_result");
        if (stringExtra != null) {
            WriteImagesInfo writeImagesInfo = this.kOC.getWriteImagesInfo();
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
        if (view == this.kOD.AA()) {
            Aq();
        } else if (view == this.kOD.AC()) {
            Aq();
        } else if (view == this.kOD.Az()) {
            if (this.kOC != null) {
                this.kOC.setLastAlbumId(null);
            }
            Ax();
        } else if (view == this.kOD.AB()) {
            cM(0);
        } else if (view == this.kOD.AD()) {
            cK(2);
        } else if (view == this.kOD.AE()) {
            cK(1);
        }
    }

    private void cK(int i) {
        if (this.kOD != null && this.kOC != null) {
            this.kOC.setOriginalImg(!this.kOC.isOriginalImg());
            As();
            cL(i);
        }
    }

    private void cL(int i) {
        if (this.kOC != null && this.kOC.isOriginalImg() && !StringUtils.isNull(this.from, true) && !StringUtils.isNull(this.forumId, true)) {
            TiebaStatic.log(new an("c10349").cx("fid", this.forumId).cx("obj_type", this.from).X("obj_locate", i));
        }
    }

    public void As() {
        if (this.kOC != null && this.kOD != null) {
            this.kOD.bu(this.kOC.isOriginalImg());
        }
    }

    public View At() {
        return this.aCq;
    }

    public int Au() {
        return this.aCm;
    }

    public c cUW() {
        return this.kOC;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void cM(int i) {
        if (!this.aCk) {
            FragmentTransaction beginTransaction = getSupportFragmentManager().beginTransaction();
            Fragment findFragmentByTag = getSupportFragmentManager().findFragmentByTag(this.kOD.cO(this.aku));
            if (findFragmentByTag != null) {
                beginTransaction.hide(findFragmentByTag);
            }
            this.aku = i;
            if (getSupportFragmentManager().findFragmentByTag(this.kOD.cO(i)) != null) {
                beginTransaction.show(this.kOD.cN(i));
            } else {
                beginTransaction.add(R.id.fragment, this.kOD.cN(i), this.kOD.cO(i));
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
        int maxImagesAllowed = this.kOC.getMaxImagesAllowed();
        if (this.kOC.size() < maxImagesAllowed) {
            if (this.kOE == null || this.kOE.g(imageFileInfo)) {
                ImageFileInfo imageFileInfo2 = new ImageFileInfo();
                imageFileInfo2.setAlbumnId(imageFileInfo.getAlbumId());
                imageFileInfo2.setFilePath(imageFileInfo.getFilePath());
                imageFileInfo2.setModifyTime(imageFileInfo.getModifyTime());
                imageFileInfo2.setIsGif(imageFileInfo.isGif());
                imageFileInfo2.setIsLong(imageFileInfo.isLong());
                this.kOC.a(null);
                this.kOC.addChooseFile(imageFileInfo2);
                As();
                return true;
            }
            return false;
        } else if (Aw()) {
            return e(imageFileInfo);
        } else {
            showToast(String.format(getPageContext().getContext().getString(R.string.max_choose_image_count), Integer.valueOf(maxImagesAllowed)));
            return false;
        }
    }

    public boolean Aw() {
        if (getIntent().getBooleanExtra("select_directly", false)) {
            int maxImagesAllowed = this.kOC.getMaxImagesAllowed();
            if (this.kOC.size() == maxImagesAllowed && maxImagesAllowed == 1) {
                try {
                    ImageFileInfo imageFileInfo = (ImageFileInfo) v.getItem(this.kOC.AN(), 0);
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
        this.kOC.a(null);
        this.kOC.delChooseFile(imageFileInfo);
        As();
        return true;
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i == 4) {
            closeLoadingDialog();
            if (this.aku == 0) {
                if (this.kOC != null) {
                    this.kOC.setLastAlbumId(null);
                }
                Ax();
                return true;
            } else if (this.aku == 1) {
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
        if (this.kOD != null && (cN = this.kOD.cN(0)) != null && (cN instanceof ImageListFragment)) {
            ((ImageListFragment) cN).h(imageFileInfo, z);
        }
    }

    void g(ImageFileInfo imageFileInfo, boolean z) {
        Fragment cN;
        if (this.kOD != null && (cN = this.kOD.cN(1)) != null && (cN instanceof AlbumImageBrowseFragment)) {
            ((AlbumImageBrowseFragment) cN).h(imageFileInfo, z);
        }
    }

    private void Ax() {
        Intent intent = new Intent();
        String lastAlbumId = this.kOC.getLastAlbumId();
        if (TextUtils.isEmpty(lastAlbumId)) {
            lastAlbumId = "";
        }
        intent.putExtra("last_album_id", lastAlbumId);
        intent.putExtra("camera_request_from", this.requestFrom);
        setResult(0, intent);
        finish();
    }

    private void stopCamera() {
        if (this.kOD != null) {
            this.kOD.stopCamera();
        }
    }

    private void FK() {
        if (this.kOD != null) {
            this.kOD.FK();
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
        this.aCk = true;
        stopCamera();
        closeLoadingDialog();
        dismissAllDialog();
        d.cUZ().destory();
        if (this.aCq != null) {
            this.aCq.setBackgroundDrawable(null);
        }
        if (this.kOD != null) {
            this.kOD.onDestroy();
        }
        if (this.kOG != null) {
            this.kOG.onDestroy();
        }
        Intent intent = new Intent();
        intent.setAction(AlbumActivityConfig.ACTION_SELECT_IMAGE_RESULT);
        intent.putExtra("album_result", this.kOC.getWriteImagesInfo().toJsonString());
        intent.putExtra("camera_request_from", this.requestFrom);
        intent.putExtra("from_type", this.aCp);
        if (this.kOF != null && !StringUtils.isNull(this.kOF.getStringExtra("file_name"))) {
            intent.putExtra("file_name", this.kOF.getStringExtra("file_name"));
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
            new com.baidu.tbadk.img.f(null).c(AlbumActivity.this.kOC.getWriteImagesInfo(), true);
            return AlbumActivity.this.kOC.getWriteImagesInfo().toJsonString();
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
        if (this.kOG != null) {
            this.kOG.onStart();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.adp.base.BdBaseFragmentActivity, android.support.v4.app.FragmentActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        FK();
        if (this.kOG != null) {
            this.kOG.onResume();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.base.BdBaseFragmentActivity, android.support.v4.app.FragmentActivity, android.app.Activity
    public void onStop() {
        super.onStop();
        if (this.kOG != null) {
            this.kOG.onStop();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.adp.base.BdBaseFragmentActivity, android.support.v4.app.FragmentActivity, android.app.Activity
    public void onPause() {
        stopCamera();
        super.onPause();
    }
}
