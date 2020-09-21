package com.baidu.tieba.write.album;

import android.content.Context;
import android.content.Intent;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.text.TextUtils;
import android.view.View;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.live.tbadk.core.data.RequestResponseCode;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.live.tbadk.core.util.CommonStatisticKey;
import com.baidu.live.tbadk.core.util.TbadkCoreStatisticKey;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.album.VideoFileInfo;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.AlbumActivityConfig;
import com.baidu.tbadk.core.atomData.RecordVideoActivityConfig;
import com.baidu.tbadk.core.atomData.WriteActivityConfig;
import com.baidu.tbadk.core.atomData.WriteMulitImageActivityConfig;
import com.baidu.tbadk.core.data.AntiData;
import com.baidu.tbadk.core.data.PostPrefixData;
import com.baidu.tbadk.core.dialog.BdToast;
import com.baidu.tbadk.core.frameworkData.IntentConfig;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.core.util.permission.PermissionJudgePolicy;
import com.baidu.tbadk.core.util.y;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.img.ImageFileInfo;
import com.baidu.tbadk.img.WriteImagesInfo;
import com.baidu.tieba.R;
import com.baidu.tieba.frs.ForumWriteData;
import com.baidu.tieba.frs.FrsTabInfoData;
import com.baidu.webkit.sdk.PermissionRequest;
import java.io.Serializable;
import java.util.LinkedList;
/* loaded from: classes3.dex */
public class e implements View.OnClickListener, com.baidu.tbadk.suspended.a {
    private int mXB;
    private int mXC;
    private BaseFragmentActivity mXD;
    private com.baidu.tieba.write.album.a mXE;
    private f mXF;
    private j mXG;
    private FrsTabInfoData mXJ;
    private Intent mXL;
    private c mXs;
    private int aTP = 0;
    private boolean brI = false;
    private String callFrom = "";
    private String from = "";
    private String forumName = "";
    private String forumId = "0";
    private int requestFrom = 0;
    private int brK = 0;
    private boolean mXH = false;
    private boolean mXI = true;
    private boolean brL = false;
    private boolean brM = false;
    private int brN = 0;
    private int mXK = -1;
    private PostPrefixData prefixData = null;
    private AntiData antiData = null;
    private String firstDir = "";
    private String secondDir = "";

    public e(BaseFragmentActivity baseFragmentActivity, Bundle bundle, int i, int i2) {
        a(baseFragmentActivity, i, i2);
        if (bundle == null) {
            ap(this.mXD.getIntent());
        } else {
            initData(bundle);
        }
        dz(0, this.mXB);
    }

    private void a(BaseFragmentActivity baseFragmentActivity, int i, int i2) {
        this.mXD = baseFragmentActivity;
        this.mXB = i;
        this.mXC = i2;
        this.mXE = new com.baidu.tieba.write.album.a(baseFragmentActivity.getPageContext(), this);
        this.mXE.Pe();
    }

    private void initData(Bundle bundle) {
        this.mXs = new c(this.mXD.getPageContext());
        if (bundle != null) {
            WriteImagesInfo writeImagesInfo = new WriteImagesInfo();
            writeImagesInfo.parseJson(bundle.getString("write_images_info"));
            this.mXs.setWriteImagesInfo(writeImagesInfo);
            this.brL = bundle.getBoolean("use_original_img", false);
            this.requestFrom = bundle.getInt("camera_request_from", 0);
            this.forumId = bundle.getString("forum_id");
            this.forumName = bundle.getString("forum_name");
            this.brK = bundle.getInt("album_thread");
            this.mXH = bundle.getBoolean(IntentConfig.KEY_CAN_SELECT_VIDEO);
            this.brM = bundle.getBoolean("from_write");
            this.callFrom = bundle.getString("KEY_CALL_FROM");
            this.brN = bundle.getInt("from_type");
            this.mXJ = (FrsTabInfoData) bundle.getSerializable("tab_list");
            this.from = bundle.getString("from");
            this.mXK = bundle.getInt(WriteActivityConfig.KEY_PROFESSION_ZONE, -1);
            Serializable serializable = bundle.getSerializable("anti_data");
            if (serializable instanceof AntiData) {
                this.antiData = (AntiData) serializable;
            }
            Serializable serializable2 = bundle.getSerializable("prefix_data");
            if (serializable2 instanceof PostPrefixData) {
                this.prefixData = (PostPrefixData) serializable2;
            }
            this.firstDir = bundle.getString("forum_first_dir", "");
            this.secondDir = bundle.getString("forum_second_dir", "");
        }
        OS();
    }

    private void ap(Intent intent) {
        this.mXs = new c(this.mXD.getPageContext());
        if (intent != null) {
            WriteImagesInfo writeImagesInfo = new WriteImagesInfo();
            writeImagesInfo.parseJson(intent.getStringExtra("write_images_info"));
            this.mXs.setWriteImagesInfo(writeImagesInfo);
            this.mXs.setOriginalImg(writeImagesInfo.isOriginalImg());
            this.brL = intent.getBooleanExtra("use_original_img", false);
            this.requestFrom = intent.getIntExtra("camera_request_from", 0);
            this.from = intent.getStringExtra("from");
            this.forumId = intent.getStringExtra("forum_id");
            this.forumName = intent.getStringExtra("forum_name");
            this.brK = intent.getIntExtra("album_thread", 0);
            this.mXH = intent.getBooleanExtra(IntentConfig.KEY_CAN_SELECT_VIDEO, false);
            this.mXI = intent.getBooleanExtra(IntentConfig.KEY_CAN_EDIT_IMAGE, true);
            this.brM = intent.getBooleanExtra("from_write", false);
            this.callFrom = intent.getStringExtra("KEY_CALL_FROM");
            this.brN = intent.getIntExtra("from_type", 0);
            this.mXJ = (FrsTabInfoData) intent.getSerializableExtra("tab_list");
            this.mXK = intent.getIntExtra(WriteActivityConfig.KEY_PROFESSION_ZONE, -1);
            Serializable serializableExtra = intent.getSerializableExtra("anti_data");
            if (serializableExtra instanceof AntiData) {
                this.antiData = (AntiData) serializableExtra;
            }
            Serializable serializableExtra2 = intent.getSerializableExtra("prefix_data");
            if (serializableExtra2 instanceof PostPrefixData) {
                this.prefixData = (PostPrefixData) serializableExtra2;
            }
            this.firstDir = intent.getStringExtra("forum_first_dir");
            this.secondDir = intent.getStringExtra("forum_second_dir");
        }
        OS();
    }

    private void OS() {
        if (this.requestFrom == 2) {
            this.mXF = new f() { // from class: com.baidu.tieba.write.album.e.1
                @Override // com.baidu.tieba.write.album.f
                public boolean h(ImageFileInfo imageFileInfo) {
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
                    BdToast.a((Context) e.this.mXD, (CharSequence) e.this.mXD.getString(R.string.uploade_attation), R.drawable.icon_toast_game_error, false).big();
                    return false;
                }
            };
        }
    }

    public void a(NavigationBar navigationBar) {
        if (navigationBar != null) {
            this.mXE.a(navigationBar);
        }
    }

    public void fy(int i) {
        if (i == 1) {
            dz(i, this.mXC);
        } else {
            dz(i, this.mXB);
        }
    }

    private void dz(int i, int i2) {
        if (!this.brI) {
            FragmentTransaction beginTransaction = this.mXD.getSupportFragmentManager().beginTransaction();
            Fragment findFragmentByTag = this.mXD.getSupportFragmentManager().findFragmentByTag(this.mXE.Kc(this.aTP));
            if (findFragmentByTag != null) {
                beginTransaction.hide(findFragmentByTag);
            }
            this.aTP = i;
            if (this.mXD.getSupportFragmentManager().findFragmentByTag(this.mXE.Kc(i)) != null) {
                beginTransaction.show(this.mXE.Kb(i));
            } else {
                beginTransaction.add(i2, this.mXE.Kb(i), this.mXE.Kc(i));
            }
            beginTransaction.commitAllowingStateLoss();
            this.mXD.getSupportFragmentManager().executePendingTransactions();
        }
    }

    public void OT() {
        if (this.requestFrom == 3) {
            TiebaStatic.log(TbadkCoreStatisticKey.UPGRADE_DIALOG_CHOOSE_IMAGE);
        }
        if (this.requestFrom == 5) {
            this.mXD.showLoadingDialog("正在上传");
            new a().execute(new String[0]);
        } else if (this.mXs != null) {
            if (this.mXG == null || !this.mXG.dKl()) {
                if (this.mXs.Po()) {
                    VideoFileInfo dJZ = this.mXs.dJZ();
                    if (this.mXG == null) {
                        this.mXG = new j(this.mXD, this.forumName, this.forumId, "");
                        this.mXG.b(this.mXJ);
                        this.mXG.setExtraData(this.antiData, this.prefixData, this.firstDir, this.secondDir);
                        if (this.mXE != null) {
                            this.mXE.a(this.mXG);
                        }
                    }
                    this.mXG.setProfessionZone(this.mXK);
                    this.mXG.a(dJZ, this.callFrom, this.from);
                } else if (this.mXI && dKb()) {
                    OU();
                } else {
                    n(null);
                }
            }
        }
    }

    private boolean dKb() {
        if (this.mXs == null || y.getCount(this.mXs.Pq()) == 0) {
            return false;
        }
        int i = 0;
        for (ImageFileInfo imageFileInfo : this.mXs.Pq()) {
            if (imageFileInfo != null && imageFileInfo.getImageType() == 0 && (i = i + 1) >= 2) {
                return false;
            }
            i = i;
        }
        return i == 1;
    }

    private void OU() {
        WriteImagesInfo writeImagesInfo;
        if (this.mXs != null && (writeImagesInfo = this.mXs.getWriteImagesInfo()) != null) {
            this.mXD.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new WriteMulitImageActivityConfig(this.mXD, RequestResponseCode.REQUEST_MOTU_IMAGE, writeImagesInfo, dKc())));
        }
    }

    private int dKc() {
        if (this.mXs == null || y.getCount(this.mXs.Pq()) == 0) {
            return 0;
        }
        for (int i = 0; i < y.getCount(this.mXs.Pq()); i++) {
            ImageFileInfo imageFileInfo = this.mXs.Pq().get(i);
            if (imageFileInfo != null && imageFileInfo.getImageType() == 0) {
                return i;
            }
        }
        return 0;
    }

    private void n(Intent intent) {
        Intent intent2 = new Intent();
        intent2.putExtra("album_result", this.mXs.getWriteImagesInfo().toJsonString());
        intent2.putExtra("camera_request_from", this.requestFrom);
        intent2.putExtra("from_type", this.brN);
        if (intent != null && !StringUtils.isNull(intent.getStringExtra("file_name"))) {
            intent2.putExtra("file_name", intent.getStringExtra("file_name"));
        }
        this.mXD.setResult(-1, intent2);
        this.mXD.finish();
        if (AlbumActivityConfig.FROM_FLUTTER.equals(this.from)) {
            MessageManager.getInstance().sendMessage(new CustomMessage(2921464, intent2));
        }
    }

    @Override // com.baidu.tbadk.suspended.a
    public boolean bvP() {
        if (this.mXE == null || this.mXE.dJY() == null || this.mXE.dJY().dKh() == null) {
            return true;
        }
        return this.mXE.dJY().dKh().getFirstVisiblePosition() == 0 && !this.mXE.dJY().dKh().canScrollVertically(-1);
    }

    @Override // com.baidu.tbadk.suspended.a
    public boolean bvQ() {
        return true;
    }

    @Override // com.baidu.tbadk.suspended.a
    public void qV(int i) {
        if (this.mXE != null) {
            this.mXE.onChangeSkinType(i);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void onSaveInstanceState(Bundle bundle) {
        bundle.putString("write_images_info", this.mXs.getWriteImagesInfo().toJsonString());
        bundle.putBoolean("use_original_img", this.brL);
        bundle.putInt("camera_request_from", this.requestFrom);
        bundle.putString("forum_id", this.forumId);
        bundle.putString("forum_name", this.forumName);
        bundle.putInt("album_thread", this.brK);
        bundle.putBoolean(IntentConfig.KEY_CAN_SELECT_VIDEO, this.mXH);
        bundle.putBoolean("from_write", this.brM);
        bundle.putSerializable("tab_list", this.mXJ);
        bundle.putSerializable("anti_data", this.antiData);
        bundle.putSerializable("prefix_data", this.prefixData);
        bundle.putString("forum_first_dir", this.firstDir);
        bundle.putString("forum_second_dir", this.secondDir);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.mXE.Pg()) {
            OT();
        } else if (view == this.mXE.Pi()) {
            OT();
        } else if (view == this.mXE.Pf()) {
            if (this.mXs != null) {
                this.mXs.setLastAlbumId(null);
            }
            Pa();
        } else if (view == this.mXE.Ph()) {
            dz(0, this.mXB);
        } else if (view == this.mXE.Pj()) {
            fw(2);
        } else if (view == this.mXE.Pk()) {
            fw(1);
        }
    }

    private void Pa() {
        Intent intent = new Intent();
        String lastAlbumId = this.mXs.getLastAlbumId();
        if (TextUtils.isEmpty(lastAlbumId)) {
            lastAlbumId = "";
        }
        intent.putExtra("last_album_id", lastAlbumId);
        intent.putExtra("camera_request_from", this.requestFrom);
        this.mXD.setResult(0, intent);
        this.mXD.finish();
    }

    private void fw(int i) {
        if (this.mXE != null && this.mXs != null) {
            this.mXs.setOriginalImg(!this.mXs.isOriginalImg());
            OV();
            fx(i);
        }
    }

    public void OV() {
        if (this.mXs != null && this.mXE != null) {
            this.mXE.cA(this.mXs.isOriginalImg());
        }
    }

    private void fx(int i) {
        if (this.mXs != null && this.mXs.isOriginalImg() && !StringUtils.isNull(this.from, true) && !StringUtils.isNull(this.forumId, true)) {
            TiebaStatic.log(new aq("c10349").dF("fid", this.forumId).dF("obj_type", this.from).ai("obj_locate", i));
        }
    }

    @Override // com.baidu.tbadk.suspended.a
    public Intent bvR() {
        return null;
    }

    public void e(ImageFileInfo imageFileInfo) {
        if (imageFileInfo != null) {
            Intent intent = new Intent();
            LinkedList<ImageFileInfo> linkedList = new LinkedList<>();
            linkedList.add(imageFileInfo);
            this.mXs.getWriteImagesInfo().setChosedFiles(linkedList);
            intent.putExtra("album_result", this.mXs.getWriteImagesInfo().toJsonString());
            intent.putExtra("camera_request_from", this.requestFrom);
            intent.putExtra("from_type", this.brN);
            this.mXD.setResult(-1, intent);
            this.mXD.finish();
        }
    }

    public c dKd() {
        return this.mXs;
    }

    public void g(TbPageContext tbPageContext) {
        PostPrefixData postPrefixData;
        AntiData antiData = null;
        if (!bUJ() && com.baidu.tieba.write.j.dJO()) {
            RecordVideoActivityConfig recordVideoActivityConfig = new RecordVideoActivityConfig(tbPageContext.getPageActivity(), this.brM ? 2 : 3, new ForumWriteData(this.forumId, this.forumName, null, null), this.mXs.getWriteImagesInfo(), "", this.brN);
            recordVideoActivityConfig.setShowType(this.mXH ? 0 : 1);
            if (this.mXH) {
                String str = "";
                String str2 = "";
                if (this.mXD.getIntent() != null) {
                    Serializable serializableExtra = this.mXD.getIntent().getSerializableExtra("anti_data");
                    AntiData antiData2 = serializableExtra instanceof AntiData ? (AntiData) serializableExtra : null;
                    Serializable serializableExtra2 = this.mXD.getIntent().getSerializableExtra("prefix_data");
                    PostPrefixData postPrefixData2 = serializableExtra2 instanceof PostPrefixData ? (PostPrefixData) serializableExtra2 : null;
                    antiData = antiData2;
                    str = this.mXD.getIntent().getStringExtra("forum_first_dir");
                    postPrefixData = postPrefixData2;
                    str2 = this.mXD.getIntent().getStringExtra("forum_second_dir");
                } else {
                    postPrefixData = null;
                }
                recordVideoActivityConfig.setExtraData(antiData, postPrefixData, str, str2);
            }
            this.mXD.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, recordVideoActivityConfig));
            TiebaStatic.log(new aq(CommonStatisticKey.KEY_ENTRANCE_CLICKED).ai("obj_locate", 5).ai("obj_type", 2));
        }
    }

    private boolean bUJ() {
        PermissionJudgePolicy permissionJudgePolicy = new PermissionJudgePolicy();
        permissionJudgePolicy.clearRequestPermissionList();
        permissionJudgePolicy.appendRequestPermission(this.mXD, PermissionRequest.RESOURCE_VIDEO_CAPTURE);
        permissionJudgePolicy.appendRequestPermission(this.mXD, PermissionRequest.RESOURCE_AUDIO_CAPTURE);
        permissionJudgePolicy.appendRequestPermission(this.mXD, "android.permission.WRITE_EXTERNAL_STORAGE");
        return permissionJudgePolicy.startRequestPermission(this.mXD);
    }

    public boolean f(ImageFileInfo imageFileInfo) {
        if (imageFileInfo == null) {
            return false;
        }
        this.mXs.a(null);
        this.mXs.delChooseFile(imageFileInfo);
        OV();
        return true;
    }

    public boolean g(ImageFileInfo imageFileInfo) {
        if (imageFileInfo == null) {
            return false;
        }
        int maxImagesAllowed = this.mXs.getMaxImagesAllowed();
        if (this.mXs.size() < maxImagesAllowed) {
            if (this.mXF == null || this.mXF.h(imageFileInfo)) {
                ImageFileInfo imageFileInfo2 = new ImageFileInfo();
                imageFileInfo2.setAlbumnId(imageFileInfo.getAlbumId());
                imageFileInfo2.setContentUriStr(imageFileInfo.getContentUriStr());
                imageFileInfo2.setFilePath(imageFileInfo.getFilePath());
                imageFileInfo2.setModifyTime(imageFileInfo.getModifyTime());
                imageFileInfo2.setIsGif(imageFileInfo.isGif());
                imageFileInfo2.setIsLong(imageFileInfo.isLong());
                this.mXs.a(null);
                this.mXs.addChooseFile(imageFileInfo2);
                OV();
                return true;
            }
            return false;
        } else if (OZ()) {
            return g(imageFileInfo);
        } else {
            this.mXD.showToast(String.format(this.mXD.getString(R.string.max_choose_image_count), Integer.valueOf(maxImagesAllowed)));
            return false;
        }
    }

    private boolean OZ() {
        if (this.mXD.getIntent().getBooleanExtra("select_directly", false)) {
            int maxImagesAllowed = this.mXs.getMaxImagesAllowed();
            if (this.mXs.size() == maxImagesAllowed && maxImagesAllowed == 1) {
                try {
                    ImageFileInfo imageFileInfo = (ImageFileInfo) y.getItem(this.mXs.Pq(), 0);
                    if (f(imageFileInfo)) {
                        g(imageFileInfo, false);
                        h(imageFileInfo, false);
                        return true;
                    }
                } catch (Exception e) {
                }
            }
            return false;
        }
        return false;
    }

    public void g(ImageFileInfo imageFileInfo, boolean z) {
        Fragment Kb;
        if (this.mXE != null && (Kb = this.mXE.Kb(0)) != null && (Kb instanceof ImageListFragment)) {
            ((ImageListFragment) Kb).f(imageFileInfo, z);
        }
    }

    private void h(ImageFileInfo imageFileInfo, boolean z) {
        Fragment Kb;
        if (this.mXE != null && (Kb = this.mXE.Kb(1)) != null && (Kb instanceof AlbumImageBrowseFragment)) {
            ((AlbumImageBrowseFragment) Kb).f(imageFileInfo, z);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void o(Intent intent) {
        this.mXL = intent;
        if (intent == null || this.mXs == null) {
            n(null);
            return;
        }
        String stringExtra = intent.getStringExtra("album_result");
        if (stringExtra != null) {
            WriteImagesInfo writeImagesInfo = this.mXs.getWriteImagesInfo();
            writeImagesInfo.parseJson(stringExtra);
            writeImagesInfo.updateQuality();
            n(intent);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void onBackClick() {
        this.mXD.closeLoadingDialog();
        if (this.aTP == 0) {
            if (this.mXs != null) {
                this.mXs.setLastAlbumId(null);
            }
            Pa();
        } else if (this.aTP == 1) {
            fy(0);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int OX() {
        return this.brK;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean dKe() {
        return this.mXH;
    }

    private void stopCamera() {
        if (this.mXE != null) {
            this.mXE.stopCamera();
        }
    }

    private void XI() {
        if (this.mXE != null) {
            this.mXE.XI();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void onStart() {
        if (this.mXG != null) {
            this.mXG.onStart();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void onResume() {
        XI();
        if (this.mXG != null) {
            this.mXG.onResume();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void onStop() {
        if (this.mXG != null) {
            this.mXG.onStop();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void onPause() {
        stopCamera();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void onDestroy() {
        this.brI = true;
        stopCamera();
        this.mXD.closeLoadingDialog();
        this.mXD.dismissAllDialog();
        d.dKa().destory();
        if (this.mXE != null) {
            this.mXE.onDestroy();
        }
        if (this.mXG != null) {
            this.mXG.onDestroy();
        }
        Intent intent = new Intent();
        intent.setAction(AlbumActivityConfig.ACTION_SELECT_IMAGE_RESULT);
        intent.putExtra("album_result", this.mXs.getWriteImagesInfo().toJsonString());
        intent.putExtra("camera_request_from", this.requestFrom);
        intent.putExtra("from_type", this.brN);
        if (this.mXL != null && !StringUtils.isNull(this.mXL.getStringExtra("file_name"))) {
            intent.putExtra("file_name", this.mXL.getStringExtra("file_name"));
        }
        TbadkCoreApplication.getInst().sendBroadcast(intent);
    }

    public void onRequestPermissionsResult(int i, @NonNull String[] strArr, @NonNull int[] iArr) {
        if (this.mXE != null) {
            this.mXE.dJX();
        }
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
            new com.baidu.tbadk.img.f(null).c(e.this.mXs.getWriteImagesInfo(), true);
            return e.this.mXs.getWriteImagesInfo().toJsonString();
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPostExecute(String str) {
            Intent intent = new Intent();
            intent.putExtra("album_result", str);
            e.this.mXD.setResult(-1, intent);
            e.this.mXD.finish();
        }
    }
}
