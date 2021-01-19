package com.baidu.tieba.write.album;

import android.content.Intent;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
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
import com.baidu.tbadk.core.util.x;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.img.ImageFileInfo;
import com.baidu.tbadk.img.WriteImagesInfo;
import com.baidu.tieba.R;
import com.baidu.tieba.frs.ForumWriteData;
import com.baidu.tieba.frs.FrsTabInfoData;
import com.baidu.webkit.sdk.PermissionRequest;
import java.io.Serializable;
import java.util.LinkedList;
/* loaded from: classes7.dex */
public class e implements View.OnClickListener, com.baidu.tbadk.suspended.a {
    private c nTK;
    private int nTT;
    private int nTU;
    private BaseFragmentActivity nTV;
    private com.baidu.tieba.write.album.a nTW;
    private f nTX;
    private j nTY;
    private FrsTabInfoData nUb;
    private Intent nUd;
    private int statisticFrom;
    private int aYr = 0;
    private boolean bHt = false;
    private String callFrom = "";
    private String from = "";
    private String forumName = "";
    private String forumId = "0";
    private int requestFrom = 0;
    private int bHv = 0;
    private boolean nTZ = false;
    private boolean nUa = true;
    private boolean bHw = false;
    private boolean bHx = false;
    private int bHy = 0;
    private int nUc = -1;
    private PostPrefixData prefixData = null;
    private AntiData antiData = null;
    private String firstDir = "";
    private String secondDir = "";

    public e(BaseFragmentActivity baseFragmentActivity, Bundle bundle, int i, int i2) {
        a(baseFragmentActivity, i, i2);
        if (bundle == null) {
            an(this.nTV.getIntent());
        } else {
            initData(bundle);
        }
        dE(0, this.nTT);
    }

    private void a(BaseFragmentActivity baseFragmentActivity, int i, int i2) {
        this.nTV = baseFragmentActivity;
        this.nTT = i;
        this.nTU = i2;
        this.nTW = new com.baidu.tieba.write.album.a(baseFragmentActivity.getPageContext(), this);
        this.nTW.SN();
    }

    private void initData(Bundle bundle) {
        this.nTK = new c(this.nTV.getPageContext());
        if (bundle != null) {
            WriteImagesInfo writeImagesInfo = new WriteImagesInfo();
            writeImagesInfo.parseJson(bundle.getString("write_images_info"));
            this.nTK.setWriteImagesInfo(writeImagesInfo);
            this.bHw = bundle.getBoolean("use_original_img", false);
            this.requestFrom = bundle.getInt("camera_request_from", 0);
            this.forumId = bundle.getString("forum_id");
            this.forumName = bundle.getString("forum_name");
            this.bHv = bundle.getInt("album_thread");
            this.nTZ = bundle.getBoolean(IntentConfig.KEY_CAN_SELECT_VIDEO);
            this.bHx = bundle.getBoolean("from_write");
            this.callFrom = bundle.getString("KEY_CALL_FROM");
            this.statisticFrom = bundle.getInt(WriteActivityConfig.KEY_STATISTIS_FROM);
            this.bHy = bundle.getInt("from_type");
            this.nUb = (FrsTabInfoData) bundle.getSerializable("tab_list");
            this.from = bundle.getString("from");
            this.nUc = bundle.getInt(WriteActivityConfig.KEY_PROFESSION_ZONE, -1);
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
        SB();
    }

    private void an(Intent intent) {
        this.nTK = new c(this.nTV.getPageContext());
        if (intent != null) {
            WriteImagesInfo writeImagesInfo = new WriteImagesInfo();
            writeImagesInfo.parseJson(intent.getStringExtra("write_images_info"));
            this.nTK.setWriteImagesInfo(writeImagesInfo);
            this.nTK.setOriginalImg(writeImagesInfo.isOriginalImg());
            this.bHw = intent.getBooleanExtra("use_original_img", false);
            this.requestFrom = intent.getIntExtra("camera_request_from", 0);
            this.from = intent.getStringExtra("from");
            this.forumId = intent.getStringExtra("forum_id");
            this.forumName = intent.getStringExtra("forum_name");
            this.bHv = intent.getIntExtra("album_thread", 0);
            this.nTZ = intent.getBooleanExtra(IntentConfig.KEY_CAN_SELECT_VIDEO, false);
            this.nUa = intent.getBooleanExtra(IntentConfig.KEY_CAN_EDIT_IMAGE, true);
            this.bHx = intent.getBooleanExtra("from_write", false);
            this.callFrom = intent.getStringExtra("KEY_CALL_FROM");
            this.statisticFrom = intent.getIntExtra(WriteActivityConfig.KEY_STATISTIS_FROM, 0);
            this.bHy = intent.getIntExtra("from_type", 0);
            this.nUb = (FrsTabInfoData) intent.getSerializableExtra("tab_list");
            this.nUc = intent.getIntExtra(WriteActivityConfig.KEY_PROFESSION_ZONE, -1);
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
        SB();
    }

    private void SB() {
        if (this.requestFrom == 2) {
            this.nTX = new f() { // from class: com.baidu.tieba.write.album.e.1
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
                    BdToast.b(e.this.nTV, e.this.nTV.getString(R.string.uploade_attation), R.drawable.icon_toast_game_error, false).bqk();
                    return false;
                }
            };
        }
    }

    public void b(NavigationBar navigationBar) {
        if (navigationBar != null) {
            this.nTW.b(navigationBar);
        }
    }

    public void eL(int i) {
        if (i == 1) {
            dE(i, this.nTU);
        } else {
            dE(i, this.nTT);
        }
    }

    private void dE(int i, int i2) {
        if (!this.bHt) {
            FragmentTransaction beginTransaction = this.nTV.getSupportFragmentManager().beginTransaction();
            Fragment findFragmentByTag = this.nTV.getSupportFragmentManager().findFragmentByTag(this.nTW.KO(this.aYr));
            if (findFragmentByTag != null) {
                beginTransaction.hide(findFragmentByTag);
            }
            this.aYr = i;
            if (this.nTV.getSupportFragmentManager().findFragmentByTag(this.nTW.KO(i)) != null) {
                beginTransaction.show(this.nTW.KN(i));
            } else {
                beginTransaction.add(i2, this.nTW.KN(i), this.nTW.KO(i));
            }
            beginTransaction.commitAllowingStateLoss();
            this.nTV.getSupportFragmentManager().executePendingTransactions();
        }
    }

    public void SC() {
        if (this.requestFrom == 3) {
            TiebaStatic.log(TbadkCoreStatisticKey.UPGRADE_DIALOG_CHOOSE_IMAGE);
        }
        if (this.requestFrom == 5) {
            this.nTV.showLoadingDialog("正在上传");
            new a().execute(new String[0]);
        } else if (this.nTK != null) {
            if (this.nTY == null || !this.nTY.dUP()) {
                if (this.nTK.SX()) {
                    VideoFileInfo dUz = this.nTK.dUz();
                    if (this.nTY == null) {
                        this.nTY = new j(this.nTV, this.forumName, this.forumId, "");
                        this.nTY.b(this.nUb);
                        this.nTY.setExtraData(this.antiData, this.prefixData, this.firstDir, this.secondDir);
                        if (this.nTW != null) {
                            this.nTW.a(this.nTY);
                        }
                    }
                    this.nTY.setProfessionZone(this.nUc);
                    this.nTY.setStatisticFrom(this.statisticFrom);
                    this.nTY.a(dUz, this.callFrom, this.from);
                } else if (this.nUa && dUB()) {
                    SD();
                } else {
                    n(null);
                }
            }
        }
    }

    private boolean dUB() {
        if (this.nTK == null || x.getCount(this.nTK.SZ()) == 0) {
            return false;
        }
        int i = 0;
        for (ImageFileInfo imageFileInfo : this.nTK.SZ()) {
            if (imageFileInfo != null && imageFileInfo.getImageType() == 0 && (i = i + 1) >= 2) {
                return false;
            }
            i = i;
        }
        return i == 1;
    }

    private void SD() {
        WriteImagesInfo writeImagesInfo;
        if (this.nTK != null && (writeImagesInfo = this.nTK.getWriteImagesInfo()) != null) {
            this.nTV.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new WriteMulitImageActivityConfig(this.nTV, RequestResponseCode.REQUEST_MOTU_IMAGE, writeImagesInfo, dUC())));
        }
    }

    private int dUC() {
        if (this.nTK == null || x.getCount(this.nTK.SZ()) == 0) {
            return 0;
        }
        for (int i = 0; i < x.getCount(this.nTK.SZ()); i++) {
            ImageFileInfo imageFileInfo = this.nTK.SZ().get(i);
            if (imageFileInfo != null && imageFileInfo.getImageType() == 0) {
                return i;
            }
        }
        return 0;
    }

    private void n(Intent intent) {
        Intent intent2 = new Intent();
        intent2.putExtra("album_result", this.nTK.getWriteImagesInfo().toJsonString());
        intent2.putExtra("camera_request_from", this.requestFrom);
        intent2.putExtra("from_type", this.bHy);
        if (intent != null && !StringUtils.isNull(intent.getStringExtra("file_name"))) {
            intent2.putExtra("file_name", intent.getStringExtra("file_name"));
        }
        this.nTV.setResult(-1, intent2);
        this.nTV.finish();
        if (AlbumActivityConfig.FROM_FLUTTER.equals(this.from)) {
            MessageManager.getInstance().sendMessage(new CustomMessage(2921464, intent2));
        }
    }

    @Override // com.baidu.tbadk.suspended.a
    public boolean bEp() {
        if (this.nTW == null || this.nTW.dUy() == null || this.nTW.dUy().dUH() == null) {
            return true;
        }
        return this.nTW.dUy().dUH().getFirstVisiblePosition() == 0 && !this.nTW.dUy().dUH().canScrollVertically(-1);
    }

    @Override // com.baidu.tbadk.suspended.a
    public boolean bEq() {
        return true;
    }

    @Override // com.baidu.tbadk.suspended.a
    public void rs(int i) {
        if (this.nTW != null) {
            this.nTW.onChangeSkinType(i);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void onSaveInstanceState(Bundle bundle) {
        bundle.putString("write_images_info", this.nTK.getWriteImagesInfo().toJsonString());
        bundle.putBoolean("use_original_img", this.bHw);
        bundle.putInt("camera_request_from", this.requestFrom);
        bundle.putString("forum_id", this.forumId);
        bundle.putString("forum_name", this.forumName);
        bundle.putInt("album_thread", this.bHv);
        bundle.putBoolean(IntentConfig.KEY_CAN_SELECT_VIDEO, this.nTZ);
        bundle.putBoolean("from_write", this.bHx);
        bundle.putSerializable("tab_list", this.nUb);
        bundle.putSerializable("anti_data", this.antiData);
        bundle.putSerializable("prefix_data", this.prefixData);
        bundle.putString("forum_first_dir", this.firstDir);
        bundle.putString("forum_second_dir", this.secondDir);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.nTW.SP()) {
            SC();
        } else if (view == this.nTW.SR()) {
            SC();
        } else if (view == this.nTW.SO()) {
            if (this.nTK != null) {
                this.nTK.setLastAlbumId(null);
            }
            SJ();
        } else if (view == this.nTW.SQ()) {
            dE(0, this.nTT);
        } else if (view == this.nTW.SS()) {
            eJ(2);
        } else if (view == this.nTW.ST()) {
            eJ(1);
        }
    }

    private void SJ() {
        Intent intent = new Intent();
        String lastAlbumId = this.nTK.getLastAlbumId();
        if (TextUtils.isEmpty(lastAlbumId)) {
            lastAlbumId = "";
        }
        intent.putExtra("last_album_id", lastAlbumId);
        intent.putExtra("camera_request_from", this.requestFrom);
        this.nTV.setResult(0, intent);
        this.nTV.finish();
    }

    private void eJ(int i) {
        if (this.nTW != null && this.nTK != null) {
            this.nTK.setOriginalImg(!this.nTK.isOriginalImg());
            SE();
            eK(i);
        }
    }

    public void SE() {
        if (this.nTK != null && this.nTW != null) {
            this.nTW.df(this.nTK.isOriginalImg());
        }
    }

    private void eK(int i) {
        if (this.nTK != null && this.nTK.isOriginalImg() && !StringUtils.isNull(this.from, true) && !StringUtils.isNull(this.forumId, true)) {
            TiebaStatic.log(new aq("c10349").dW("fid", this.forumId).dW("obj_type", this.from).an("obj_locate", i));
        }
    }

    @Override // com.baidu.tbadk.suspended.a
    public Intent bEr() {
        return null;
    }

    public void e(ImageFileInfo imageFileInfo) {
        if (imageFileInfo != null) {
            Intent intent = new Intent();
            LinkedList<ImageFileInfo> linkedList = new LinkedList<>();
            linkedList.add(imageFileInfo);
            this.nTK.getWriteImagesInfo().setChosedFiles(linkedList);
            intent.putExtra("album_result", this.nTK.getWriteImagesInfo().toJsonString());
            intent.putExtra("camera_request_from", this.requestFrom);
            intent.putExtra("from_type", this.bHy);
            this.nTV.setResult(-1, intent);
            this.nTV.finish();
        }
    }

    public c dUD() {
        return this.nTK;
    }

    public void g(TbPageContext tbPageContext) {
        String str;
        String str2;
        AntiData antiData;
        PostPrefixData postPrefixData;
        if (!cfN() && com.baidu.tieba.write.j.dUp()) {
            ForumWriteData forumWriteData = new ForumWriteData(this.forumId, this.forumName, null, null);
            forumWriteData.statisticFrom = this.statisticFrom;
            RecordVideoActivityConfig recordVideoActivityConfig = new RecordVideoActivityConfig(tbPageContext.getPageActivity(), this.bHx ? 2 : 3, forumWriteData, this.nTK.getWriteImagesInfo(), "", this.bHy);
            recordVideoActivityConfig.setShowType(this.nTZ ? 0 : 1);
            if (this.nTZ) {
                if (this.nTV.getIntent() == null) {
                    str = "";
                    str2 = "";
                    antiData = null;
                    postPrefixData = null;
                } else {
                    Serializable serializableExtra = this.nTV.getIntent().getSerializableExtra("anti_data");
                    AntiData antiData2 = serializableExtra instanceof AntiData ? (AntiData) serializableExtra : null;
                    Serializable serializableExtra2 = this.nTV.getIntent().getSerializableExtra("prefix_data");
                    PostPrefixData postPrefixData2 = serializableExtra2 instanceof PostPrefixData ? (PostPrefixData) serializableExtra2 : null;
                    str2 = this.nTV.getIntent().getStringExtra("forum_first_dir");
                    str = this.nTV.getIntent().getStringExtra("forum_second_dir");
                    antiData = antiData2;
                    postPrefixData = postPrefixData2;
                }
                recordVideoActivityConfig.setExtraData(antiData, postPrefixData, str2, str);
            }
            this.nTV.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, recordVideoActivityConfig));
            TiebaStatic.log(new aq(CommonStatisticKey.KEY_ENTRANCE_CLICKED).an("obj_locate", 5).an("obj_type", 2));
        }
    }

    private boolean cfN() {
        PermissionJudgePolicy permissionJudgePolicy = new PermissionJudgePolicy();
        permissionJudgePolicy.clearRequestPermissionList();
        permissionJudgePolicy.appendRequestPermission(this.nTV, PermissionRequest.RESOURCE_VIDEO_CAPTURE);
        permissionJudgePolicy.appendRequestPermission(this.nTV, PermissionRequest.RESOURCE_AUDIO_CAPTURE);
        permissionJudgePolicy.appendRequestPermission(this.nTV, "android.permission.WRITE_EXTERNAL_STORAGE");
        return permissionJudgePolicy.startRequestPermission(this.nTV);
    }

    public boolean f(ImageFileInfo imageFileInfo) {
        if (imageFileInfo == null) {
            return false;
        }
        this.nTK.a(null);
        this.nTK.delChooseFile(imageFileInfo);
        SE();
        return true;
    }

    public boolean g(ImageFileInfo imageFileInfo) {
        if (imageFileInfo == null) {
            return false;
        }
        int maxImagesAllowed = this.nTK.getMaxImagesAllowed();
        if (this.nTK.size() < maxImagesAllowed) {
            if (this.nTX == null || this.nTX.h(imageFileInfo)) {
                ImageFileInfo imageFileInfo2 = new ImageFileInfo();
                imageFileInfo2.setAlbumnId(imageFileInfo.getAlbumId());
                imageFileInfo2.setContentUriStr(imageFileInfo.getContentUriStr());
                imageFileInfo2.setFilePath(imageFileInfo.getFilePath());
                imageFileInfo2.setModifyTime(imageFileInfo.getModifyTime());
                imageFileInfo2.setIsGif(imageFileInfo.isGif());
                imageFileInfo2.setIsLong(imageFileInfo.isLong());
                this.nTK.a(null);
                this.nTK.addChooseFile(imageFileInfo2);
                SE();
                return true;
            }
            return false;
        } else if (SI()) {
            return g(imageFileInfo);
        } else {
            this.nTV.showToast(String.format(this.nTV.getString(R.string.max_choose_image_count), Integer.valueOf(maxImagesAllowed)));
            return false;
        }
    }

    private boolean SI() {
        if (this.nTV.getIntent().getBooleanExtra("select_directly", false)) {
            int maxImagesAllowed = this.nTK.getMaxImagesAllowed();
            if (this.nTK.size() == maxImagesAllowed && maxImagesAllowed == 1) {
                try {
                    ImageFileInfo imageFileInfo = (ImageFileInfo) x.getItem(this.nTK.SZ(), 0);
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
        Fragment KN;
        if (this.nTW != null && (KN = this.nTW.KN(0)) != null && (KN instanceof ImageListFragment)) {
            ((ImageListFragment) KN).f(imageFileInfo, z);
        }
    }

    private void h(ImageFileInfo imageFileInfo, boolean z) {
        Fragment KN;
        if (this.nTW != null && (KN = this.nTW.KN(1)) != null && (KN instanceof AlbumImageBrowseFragment)) {
            ((AlbumImageBrowseFragment) KN).f(imageFileInfo, z);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void o(Intent intent) {
        this.nUd = intent;
        if (intent == null || this.nTK == null) {
            n(null);
            return;
        }
        String stringExtra = intent.getStringExtra("album_result");
        if (stringExtra != null) {
            WriteImagesInfo writeImagesInfo = this.nTK.getWriteImagesInfo();
            writeImagesInfo.parseJson(stringExtra);
            writeImagesInfo.updateQuality();
            n(intent);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void onBackClick() {
        this.nTV.closeLoadingDialog();
        if (this.aYr == 0) {
            if (this.nTK != null) {
                this.nTK.setLastAlbumId(null);
            }
            SJ();
        } else if (this.aYr == 1) {
            eL(0);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int SG() {
        return this.bHv;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean dUE() {
        return this.nTZ;
    }

    private void stopCamera() {
        if (this.nTW != null) {
            this.nTW.stopCamera();
        }
    }

    private void openCamera() {
        if (this.nTW != null) {
            this.nTW.openCamera();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void onStart() {
        if (this.nTY != null) {
            this.nTY.onStart();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void onResume() {
        openCamera();
        if (this.nTY != null) {
            this.nTY.onResume();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void onStop() {
        if (this.nTY != null) {
            this.nTY.onStop();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void onPause() {
        stopCamera();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void onDestroy() {
        this.bHt = true;
        stopCamera();
        this.nTV.closeLoadingDialog();
        this.nTV.dismissAllDialog();
        d.dUA().destory();
        if (this.nTW != null) {
            this.nTW.onDestroy();
        }
        if (this.nTY != null) {
            this.nTY.onDestroy();
        }
        Intent intent = new Intent();
        intent.setAction(AlbumActivityConfig.ACTION_SELECT_IMAGE_RESULT);
        intent.putExtra("album_result", this.nTK.getWriteImagesInfo().toJsonString());
        intent.putExtra("camera_request_from", this.requestFrom);
        intent.putExtra("from_type", this.bHy);
        if (this.nUd != null && !StringUtils.isNull(this.nUd.getStringExtra("file_name"))) {
            intent.putExtra("file_name", this.nUd.getStringExtra("file_name"));
        }
        TbadkCoreApplication.getInst().sendBroadcast(intent);
    }

    public void onRequestPermissionsResult(int i, @NonNull String[] strArr, @NonNull int[] iArr) {
        if (this.nTW != null) {
            this.nTW.dUx();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes7.dex */
    public class a extends BdAsyncTask<String, Integer, String> {
        private a() {
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public String doInBackground(String... strArr) {
            new com.baidu.tbadk.img.f(null).c(e.this.nTK.getWriteImagesInfo(), true);
            return e.this.nTK.getWriteImagesInfo().toJsonString();
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPostExecute(String str) {
            Intent intent = new Intent();
            intent.putExtra("album_result", str);
            e.this.nTV.setResult(-1, intent);
            e.this.nTV.finish();
        }
    }
}
