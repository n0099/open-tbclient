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
import com.baidu.tbadk.core.util.ar;
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
    private c nGM;
    private int nGV;
    private int nGW;
    private BaseFragmentActivity nGX;
    private com.baidu.tieba.write.album.a nGY;
    private f nGZ;
    private j nHa;
    private FrsTabInfoData nHd;
    private Intent nHf;
    private int aYc = 0;
    private boolean bCk = false;
    private String callFrom = "";
    private String from = "";
    private String forumName = "";
    private String forumId = "0";
    private int requestFrom = 0;
    private int bCm = 0;
    private boolean nHb = false;
    private boolean nHc = true;
    private boolean bCn = false;
    private boolean bCo = false;
    private int bCp = 0;
    private int nHe = -1;
    private PostPrefixData prefixData = null;
    private AntiData antiData = null;
    private String firstDir = "";
    private String secondDir = "";

    public e(BaseFragmentActivity baseFragmentActivity, Bundle bundle, int i, int i2) {
        a(baseFragmentActivity, i, i2);
        if (bundle == null) {
            an(this.nGX.getIntent());
        } else {
            initData(bundle);
        }
        dE(0, this.nGV);
    }

    private void a(BaseFragmentActivity baseFragmentActivity, int i, int i2) {
        this.nGX = baseFragmentActivity;
        this.nGV = i;
        this.nGW = i2;
        this.nGY = new com.baidu.tieba.write.album.a(baseFragmentActivity.getPageContext(), this);
        this.nGY.Td();
    }

    private void initData(Bundle bundle) {
        this.nGM = new c(this.nGX.getPageContext());
        if (bundle != null) {
            WriteImagesInfo writeImagesInfo = new WriteImagesInfo();
            writeImagesInfo.parseJson(bundle.getString("write_images_info"));
            this.nGM.setWriteImagesInfo(writeImagesInfo);
            this.bCn = bundle.getBoolean("use_original_img", false);
            this.requestFrom = bundle.getInt("camera_request_from", 0);
            this.forumId = bundle.getString("forum_id");
            this.forumName = bundle.getString("forum_name");
            this.bCm = bundle.getInt("album_thread");
            this.nHb = bundle.getBoolean(IntentConfig.KEY_CAN_SELECT_VIDEO);
            this.bCo = bundle.getBoolean("from_write");
            this.callFrom = bundle.getString("KEY_CALL_FROM");
            this.bCp = bundle.getInt("from_type");
            this.nHd = (FrsTabInfoData) bundle.getSerializable("tab_list");
            this.from = bundle.getString("from");
            this.nHe = bundle.getInt(WriteActivityConfig.KEY_PROFESSION_ZONE, -1);
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
        SR();
    }

    private void an(Intent intent) {
        this.nGM = new c(this.nGX.getPageContext());
        if (intent != null) {
            WriteImagesInfo writeImagesInfo = new WriteImagesInfo();
            writeImagesInfo.parseJson(intent.getStringExtra("write_images_info"));
            this.nGM.setWriteImagesInfo(writeImagesInfo);
            this.nGM.setOriginalImg(writeImagesInfo.isOriginalImg());
            this.bCn = intent.getBooleanExtra("use_original_img", false);
            this.requestFrom = intent.getIntExtra("camera_request_from", 0);
            this.from = intent.getStringExtra("from");
            this.forumId = intent.getStringExtra("forum_id");
            this.forumName = intent.getStringExtra("forum_name");
            this.bCm = intent.getIntExtra("album_thread", 0);
            this.nHb = intent.getBooleanExtra(IntentConfig.KEY_CAN_SELECT_VIDEO, false);
            this.nHc = intent.getBooleanExtra(IntentConfig.KEY_CAN_EDIT_IMAGE, true);
            this.bCo = intent.getBooleanExtra("from_write", false);
            this.callFrom = intent.getStringExtra("KEY_CALL_FROM");
            this.bCp = intent.getIntExtra("from_type", 0);
            this.nHd = (FrsTabInfoData) intent.getSerializableExtra("tab_list");
            this.nHe = intent.getIntExtra(WriteActivityConfig.KEY_PROFESSION_ZONE, -1);
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
        SR();
    }

    private void SR() {
        if (this.requestFrom == 2) {
            this.nGZ = new f() { // from class: com.baidu.tieba.write.album.e.1
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
                    BdToast.a((Context) e.this.nGX, (CharSequence) e.this.nGX.getString(R.string.uploade_attation), R.drawable.icon_toast_game_error, false).bom();
                    return false;
                }
            };
        }
    }

    public void a(NavigationBar navigationBar) {
        if (navigationBar != null) {
            this.nGY.a(navigationBar);
        }
    }

    public void fS(int i) {
        if (i == 1) {
            dE(i, this.nGW);
        } else {
            dE(i, this.nGV);
        }
    }

    private void dE(int i, int i2) {
        if (!this.bCk) {
            FragmentTransaction beginTransaction = this.nGX.getSupportFragmentManager().beginTransaction();
            Fragment findFragmentByTag = this.nGX.getSupportFragmentManager().findFragmentByTag(this.nGY.LQ(this.aYc));
            if (findFragmentByTag != null) {
                beginTransaction.hide(findFragmentByTag);
            }
            this.aYc = i;
            if (this.nGX.getSupportFragmentManager().findFragmentByTag(this.nGY.LQ(i)) != null) {
                beginTransaction.show(this.nGY.LP(i));
            } else {
                beginTransaction.add(i2, this.nGY.LP(i), this.nGY.LQ(i));
            }
            beginTransaction.commitAllowingStateLoss();
            this.nGX.getSupportFragmentManager().executePendingTransactions();
        }
    }

    public void SS() {
        if (this.requestFrom == 3) {
            TiebaStatic.log(TbadkCoreStatisticKey.UPGRADE_DIALOG_CHOOSE_IMAGE);
        }
        if (this.requestFrom == 5) {
            this.nGX.showLoadingDialog("正在上传");
            new a().execute(new String[0]);
        } else if (this.nGM != null) {
            if (this.nHa == null || !this.nHa.dTE()) {
                if (this.nGM.Tn()) {
                    VideoFileInfo dTs = this.nGM.dTs();
                    if (this.nHa == null) {
                        this.nHa = new j(this.nGX, this.forumName, this.forumId, "");
                        this.nHa.b(this.nHd);
                        this.nHa.setExtraData(this.antiData, this.prefixData, this.firstDir, this.secondDir);
                        if (this.nGY != null) {
                            this.nGY.a(this.nHa);
                        }
                    }
                    this.nHa.setProfessionZone(this.nHe);
                    this.nHa.a(dTs, this.callFrom, this.from);
                } else if (this.nHc && dTu()) {
                    ST();
                } else {
                    n(null);
                }
            }
        }
    }

    private boolean dTu() {
        if (this.nGM == null || y.getCount(this.nGM.Tp()) == 0) {
            return false;
        }
        int i = 0;
        for (ImageFileInfo imageFileInfo : this.nGM.Tp()) {
            if (imageFileInfo != null && imageFileInfo.getImageType() == 0 && (i = i + 1) >= 2) {
                return false;
            }
            i = i;
        }
        return i == 1;
    }

    private void ST() {
        WriteImagesInfo writeImagesInfo;
        if (this.nGM != null && (writeImagesInfo = this.nGM.getWriteImagesInfo()) != null) {
            this.nGX.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new WriteMulitImageActivityConfig(this.nGX, RequestResponseCode.REQUEST_MOTU_IMAGE, writeImagesInfo, dTv())));
        }
    }

    private int dTv() {
        if (this.nGM == null || y.getCount(this.nGM.Tp()) == 0) {
            return 0;
        }
        for (int i = 0; i < y.getCount(this.nGM.Tp()); i++) {
            ImageFileInfo imageFileInfo = this.nGM.Tp().get(i);
            if (imageFileInfo != null && imageFileInfo.getImageType() == 0) {
                return i;
            }
        }
        return 0;
    }

    private void n(Intent intent) {
        Intent intent2 = new Intent();
        intent2.putExtra("album_result", this.nGM.getWriteImagesInfo().toJsonString());
        intent2.putExtra("camera_request_from", this.requestFrom);
        intent2.putExtra("from_type", this.bCp);
        if (intent != null && !StringUtils.isNull(intent.getStringExtra("file_name"))) {
            intent2.putExtra("file_name", intent.getStringExtra("file_name"));
        }
        this.nGX.setResult(-1, intent2);
        this.nGX.finish();
        if (AlbumActivityConfig.FROM_FLUTTER.equals(this.from)) {
            MessageManager.getInstance().sendMessage(new CustomMessage(2921464, intent2));
        }
    }

    @Override // com.baidu.tbadk.suspended.a
    public boolean bCk() {
        if (this.nGY == null || this.nGY.dTr() == null || this.nGY.dTr().dTA() == null) {
            return true;
        }
        return this.nGY.dTr().dTA().getFirstVisiblePosition() == 0 && !this.nGY.dTr().dTA().canScrollVertically(-1);
    }

    @Override // com.baidu.tbadk.suspended.a
    public boolean bCl() {
        return true;
    }

    @Override // com.baidu.tbadk.suspended.a
    public void sm(int i) {
        if (this.nGY != null) {
            this.nGY.onChangeSkinType(i);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void onSaveInstanceState(Bundle bundle) {
        bundle.putString("write_images_info", this.nGM.getWriteImagesInfo().toJsonString());
        bundle.putBoolean("use_original_img", this.bCn);
        bundle.putInt("camera_request_from", this.requestFrom);
        bundle.putString("forum_id", this.forumId);
        bundle.putString("forum_name", this.forumName);
        bundle.putInt("album_thread", this.bCm);
        bundle.putBoolean(IntentConfig.KEY_CAN_SELECT_VIDEO, this.nHb);
        bundle.putBoolean("from_write", this.bCo);
        bundle.putSerializable("tab_list", this.nHd);
        bundle.putSerializable("anti_data", this.antiData);
        bundle.putSerializable("prefix_data", this.prefixData);
        bundle.putString("forum_first_dir", this.firstDir);
        bundle.putString("forum_second_dir", this.secondDir);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.nGY.Tf()) {
            SS();
        } else if (view == this.nGY.Th()) {
            SS();
        } else if (view == this.nGY.Te()) {
            if (this.nGM != null) {
                this.nGM.setLastAlbumId(null);
            }
            SZ();
        } else if (view == this.nGY.Tg()) {
            dE(0, this.nGV);
        } else if (view == this.nGY.Ti()) {
            fQ(2);
        } else if (view == this.nGY.Tj()) {
            fQ(1);
        }
    }

    private void SZ() {
        Intent intent = new Intent();
        String lastAlbumId = this.nGM.getLastAlbumId();
        if (TextUtils.isEmpty(lastAlbumId)) {
            lastAlbumId = "";
        }
        intent.putExtra("last_album_id", lastAlbumId);
        intent.putExtra("camera_request_from", this.requestFrom);
        this.nGX.setResult(0, intent);
        this.nGX.finish();
    }

    private void fQ(int i) {
        if (this.nGY != null && this.nGM != null) {
            this.nGM.setOriginalImg(!this.nGM.isOriginalImg());
            SU();
            fR(i);
        }
    }

    public void SU() {
        if (this.nGM != null && this.nGY != null) {
            this.nGY.cS(this.nGM.isOriginalImg());
        }
    }

    private void fR(int i) {
        if (this.nGM != null && this.nGM.isOriginalImg() && !StringUtils.isNull(this.from, true) && !StringUtils.isNull(this.forumId, true)) {
            TiebaStatic.log(new ar("c10349").dR("fid", this.forumId).dR("obj_type", this.from).ak("obj_locate", i));
        }
    }

    @Override // com.baidu.tbadk.suspended.a
    public Intent bCm() {
        return null;
    }

    public void e(ImageFileInfo imageFileInfo) {
        if (imageFileInfo != null) {
            Intent intent = new Intent();
            LinkedList<ImageFileInfo> linkedList = new LinkedList<>();
            linkedList.add(imageFileInfo);
            this.nGM.getWriteImagesInfo().setChosedFiles(linkedList);
            intent.putExtra("album_result", this.nGM.getWriteImagesInfo().toJsonString());
            intent.putExtra("camera_request_from", this.requestFrom);
            intent.putExtra("from_type", this.bCp);
            this.nGX.setResult(-1, intent);
            this.nGX.finish();
        }
    }

    public c dTw() {
        return this.nGM;
    }

    public void g(TbPageContext tbPageContext) {
        PostPrefixData postPrefixData;
        AntiData antiData = null;
        if (!ccX() && com.baidu.tieba.write.j.dTh()) {
            RecordVideoActivityConfig recordVideoActivityConfig = new RecordVideoActivityConfig(tbPageContext.getPageActivity(), this.bCo ? 2 : 3, new ForumWriteData(this.forumId, this.forumName, null, null), this.nGM.getWriteImagesInfo(), "", this.bCp);
            recordVideoActivityConfig.setShowType(this.nHb ? 0 : 1);
            if (this.nHb) {
                String str = "";
                String str2 = "";
                if (this.nGX.getIntent() != null) {
                    Serializable serializableExtra = this.nGX.getIntent().getSerializableExtra("anti_data");
                    AntiData antiData2 = serializableExtra instanceof AntiData ? (AntiData) serializableExtra : null;
                    Serializable serializableExtra2 = this.nGX.getIntent().getSerializableExtra("prefix_data");
                    PostPrefixData postPrefixData2 = serializableExtra2 instanceof PostPrefixData ? (PostPrefixData) serializableExtra2 : null;
                    antiData = antiData2;
                    str = this.nGX.getIntent().getStringExtra("forum_first_dir");
                    postPrefixData = postPrefixData2;
                    str2 = this.nGX.getIntent().getStringExtra("forum_second_dir");
                } else {
                    postPrefixData = null;
                }
                recordVideoActivityConfig.setExtraData(antiData, postPrefixData, str, str2);
            }
            this.nGX.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, recordVideoActivityConfig));
            TiebaStatic.log(new ar(CommonStatisticKey.KEY_ENTRANCE_CLICKED).ak("obj_locate", 5).ak("obj_type", 2));
        }
    }

    private boolean ccX() {
        PermissionJudgePolicy permissionJudgePolicy = new PermissionJudgePolicy();
        permissionJudgePolicy.clearRequestPermissionList();
        permissionJudgePolicy.appendRequestPermission(this.nGX, PermissionRequest.RESOURCE_VIDEO_CAPTURE);
        permissionJudgePolicy.appendRequestPermission(this.nGX, PermissionRequest.RESOURCE_AUDIO_CAPTURE);
        permissionJudgePolicy.appendRequestPermission(this.nGX, "android.permission.WRITE_EXTERNAL_STORAGE");
        return permissionJudgePolicy.startRequestPermission(this.nGX);
    }

    public boolean f(ImageFileInfo imageFileInfo) {
        if (imageFileInfo == null) {
            return false;
        }
        this.nGM.a(null);
        this.nGM.delChooseFile(imageFileInfo);
        SU();
        return true;
    }

    public boolean g(ImageFileInfo imageFileInfo) {
        if (imageFileInfo == null) {
            return false;
        }
        int maxImagesAllowed = this.nGM.getMaxImagesAllowed();
        if (this.nGM.size() < maxImagesAllowed) {
            if (this.nGZ == null || this.nGZ.h(imageFileInfo)) {
                ImageFileInfo imageFileInfo2 = new ImageFileInfo();
                imageFileInfo2.setAlbumnId(imageFileInfo.getAlbumId());
                imageFileInfo2.setContentUriStr(imageFileInfo.getContentUriStr());
                imageFileInfo2.setFilePath(imageFileInfo.getFilePath());
                imageFileInfo2.setModifyTime(imageFileInfo.getModifyTime());
                imageFileInfo2.setIsGif(imageFileInfo.isGif());
                imageFileInfo2.setIsLong(imageFileInfo.isLong());
                this.nGM.a(null);
                this.nGM.addChooseFile(imageFileInfo2);
                SU();
                return true;
            }
            return false;
        } else if (SY()) {
            return g(imageFileInfo);
        } else {
            this.nGX.showToast(String.format(this.nGX.getString(R.string.max_choose_image_count), Integer.valueOf(maxImagesAllowed)));
            return false;
        }
    }

    private boolean SY() {
        if (this.nGX.getIntent().getBooleanExtra("select_directly", false)) {
            int maxImagesAllowed = this.nGM.getMaxImagesAllowed();
            if (this.nGM.size() == maxImagesAllowed && maxImagesAllowed == 1) {
                try {
                    ImageFileInfo imageFileInfo = (ImageFileInfo) y.getItem(this.nGM.Tp(), 0);
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
        Fragment LP;
        if (this.nGY != null && (LP = this.nGY.LP(0)) != null && (LP instanceof ImageListFragment)) {
            ((ImageListFragment) LP).f(imageFileInfo, z);
        }
    }

    private void h(ImageFileInfo imageFileInfo, boolean z) {
        Fragment LP;
        if (this.nGY != null && (LP = this.nGY.LP(1)) != null && (LP instanceof AlbumImageBrowseFragment)) {
            ((AlbumImageBrowseFragment) LP).f(imageFileInfo, z);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void o(Intent intent) {
        this.nHf = intent;
        if (intent == null || this.nGM == null) {
            n(null);
            return;
        }
        String stringExtra = intent.getStringExtra("album_result");
        if (stringExtra != null) {
            WriteImagesInfo writeImagesInfo = this.nGM.getWriteImagesInfo();
            writeImagesInfo.parseJson(stringExtra);
            writeImagesInfo.updateQuality();
            n(intent);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void onBackClick() {
        this.nGX.closeLoadingDialog();
        if (this.aYc == 0) {
            if (this.nGM != null) {
                this.nGM.setLastAlbumId(null);
            }
            SZ();
        } else if (this.aYc == 1) {
            fS(0);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int SW() {
        return this.bCm;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean dTx() {
        return this.nHb;
    }

    private void stopCamera() {
        if (this.nGY != null) {
            this.nGY.stopCamera();
        }
    }

    private void openCamera() {
        if (this.nGY != null) {
            this.nGY.openCamera();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void onStart() {
        if (this.nHa != null) {
            this.nHa.onStart();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void onResume() {
        openCamera();
        if (this.nHa != null) {
            this.nHa.onResume();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void onStop() {
        if (this.nHa != null) {
            this.nHa.onStop();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void onPause() {
        stopCamera();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void onDestroy() {
        this.bCk = true;
        stopCamera();
        this.nGX.closeLoadingDialog();
        this.nGX.dismissAllDialog();
        d.dTt().destory();
        if (this.nGY != null) {
            this.nGY.onDestroy();
        }
        if (this.nHa != null) {
            this.nHa.onDestroy();
        }
        Intent intent = new Intent();
        intent.setAction(AlbumActivityConfig.ACTION_SELECT_IMAGE_RESULT);
        intent.putExtra("album_result", this.nGM.getWriteImagesInfo().toJsonString());
        intent.putExtra("camera_request_from", this.requestFrom);
        intent.putExtra("from_type", this.bCp);
        if (this.nHf != null && !StringUtils.isNull(this.nHf.getStringExtra("file_name"))) {
            intent.putExtra("file_name", this.nHf.getStringExtra("file_name"));
        }
        TbadkCoreApplication.getInst().sendBroadcast(intent);
    }

    public void onRequestPermissionsResult(int i, @NonNull String[] strArr, @NonNull int[] iArr) {
        if (this.nGY != null) {
            this.nGY.dTq();
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
            new com.baidu.tbadk.img.f(null).c(e.this.nGM.getWriteImagesInfo(), true);
            return e.this.nGM.getWriteImagesInfo().toJsonString();
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPostExecute(String str) {
            Intent intent = new Intent();
            intent.putExtra("album_result", str);
            e.this.nGX.setResult(-1, intent);
            e.this.nGX.finish();
        }
    }
}
