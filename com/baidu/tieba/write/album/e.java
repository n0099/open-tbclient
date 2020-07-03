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
import com.baidu.tbadk.core.util.ao;
import com.baidu.tbadk.core.util.permission.PermissionJudgePolicy;
import com.baidu.tbadk.core.util.w;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.img.ImageFileInfo;
import com.baidu.tbadk.img.WriteImagesInfo;
import com.baidu.tieba.R;
import com.baidu.tieba.frs.ForumWriteData;
import com.baidu.tieba.frs.FrsTabInfoData;
import com.baidu.webkit.sdk.PermissionRequest;
import java.io.Serializable;
import java.util.LinkedList;
/* loaded from: classes2.dex */
public class e implements View.OnClickListener, com.baidu.tbadk.suspended.a {
    private c mmK;
    private int mmT;
    private int mmU;
    private BaseFragmentActivity mmV;
    private com.baidu.tieba.write.album.a mmW;
    private f mmX;
    private j mmY;
    private FrsTabInfoData mnb;
    private Intent mnd;
    private int aLb = 0;
    private boolean bix = false;
    private String callFrom = "";
    private String from = "";
    private String forumName = "";
    private String forumId = "0";
    private int requestFrom = 0;
    private int biz = 0;
    private boolean mmZ = false;
    private boolean mna = true;
    private boolean biA = false;
    private boolean biB = false;
    private int biC = 0;
    private int mnc = -1;
    private PostPrefixData prefixData = null;
    private AntiData antiData = null;
    private String firstDir = "";
    private String secondDir = "";

    public e(BaseFragmentActivity baseFragmentActivity, Bundle bundle, int i, int i2) {
        a(baseFragmentActivity, i, i2);
        if (bundle == null) {
            an(this.mmV.getIntent());
        } else {
            initData(bundle);
        }
        dl(0, this.mmT);
    }

    private void a(BaseFragmentActivity baseFragmentActivity, int i, int i2) {
        this.mmV = baseFragmentActivity;
        this.mmT = i;
        this.mmU = i2;
        this.mmW = new com.baidu.tieba.write.album.a(baseFragmentActivity.getPageContext(), this);
        this.mmW.IC();
    }

    private void initData(Bundle bundle) {
        this.mmK = new c(this.mmV.getPageContext());
        if (bundle != null) {
            WriteImagesInfo writeImagesInfo = new WriteImagesInfo();
            writeImagesInfo.parseJson(bundle.getString("write_images_info"));
            this.mmK.setWriteImagesInfo(writeImagesInfo);
            this.biA = bundle.getBoolean("use_original_img", false);
            this.requestFrom = bundle.getInt("camera_request_from", 0);
            this.forumId = bundle.getString("forum_id");
            this.forumName = bundle.getString("forum_name");
            this.biz = bundle.getInt("album_thread");
            this.mmZ = bundle.getBoolean(IntentConfig.KEY_CAN_SELECT_VIDEO);
            this.biB = bundle.getBoolean("from_write");
            this.callFrom = bundle.getString("KEY_CALL_FROM");
            this.biC = bundle.getInt("from_type");
            this.mnb = (FrsTabInfoData) bundle.getSerializable("tab_list");
            this.from = bundle.getString("from");
            this.mnc = bundle.getInt(WriteActivityConfig.KEY_PROFESSION_ZONE, -1);
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
        Iq();
    }

    private void an(Intent intent) {
        this.mmK = new c(this.mmV.getPageContext());
        if (intent != null) {
            WriteImagesInfo writeImagesInfo = new WriteImagesInfo();
            writeImagesInfo.parseJson(intent.getStringExtra("write_images_info"));
            this.mmK.setWriteImagesInfo(writeImagesInfo);
            this.mmK.setOriginalImg(writeImagesInfo.isOriginalImg());
            this.biA = intent.getBooleanExtra("use_original_img", false);
            this.requestFrom = intent.getIntExtra("camera_request_from", 0);
            this.from = intent.getStringExtra("from");
            this.forumId = intent.getStringExtra("forum_id");
            this.forumName = intent.getStringExtra("forum_name");
            this.biz = intent.getIntExtra("album_thread", 0);
            this.mmZ = intent.getBooleanExtra(IntentConfig.KEY_CAN_SELECT_VIDEO, false);
            this.mna = intent.getBooleanExtra(IntentConfig.KEY_CAN_EDIT_IMAGE, true);
            this.biB = intent.getBooleanExtra("from_write", false);
            this.callFrom = intent.getStringExtra("KEY_CALL_FROM");
            this.biC = intent.getIntExtra("from_type", 0);
            this.mnb = (FrsTabInfoData) intent.getSerializableExtra("tab_list");
            this.mnc = intent.getIntExtra(WriteActivityConfig.KEY_PROFESSION_ZONE, -1);
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
        Iq();
    }

    private void Iq() {
        if (this.requestFrom == 2) {
            this.mmX = new f() { // from class: com.baidu.tieba.write.album.e.1
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
                    BdToast.a((Context) e.this.mmV, (CharSequence) e.this.mmV.getString(R.string.uploade_attation), (int) R.drawable.icon_toast_game_error, false).aUS();
                    return false;
                }
            };
        }
    }

    public void a(NavigationBar navigationBar) {
        if (navigationBar != null) {
            this.mmW.a(navigationBar);
        }
    }

    public void du(int i) {
        if (i == 1) {
            dl(i, this.mmU);
        } else {
            dl(i, this.mmT);
        }
    }

    private void dl(int i, int i2) {
        if (!this.bix) {
            FragmentTransaction beginTransaction = this.mmV.getSupportFragmentManager().beginTransaction();
            Fragment findFragmentByTag = this.mmV.getSupportFragmentManager().findFragmentByTag(this.mmW.GF(this.aLb));
            if (findFragmentByTag != null) {
                beginTransaction.hide(findFragmentByTag);
            }
            this.aLb = i;
            if (this.mmV.getSupportFragmentManager().findFragmentByTag(this.mmW.GF(i)) != null) {
                beginTransaction.show(this.mmW.GE(i));
            } else {
                beginTransaction.add(i2, this.mmW.GE(i), this.mmW.GF(i));
            }
            beginTransaction.commitAllowingStateLoss();
            this.mmV.getSupportFragmentManager().executePendingTransactions();
        }
    }

    public void Ir() {
        if (this.requestFrom == 3) {
            TiebaStatic.log(TbadkCoreStatisticKey.UPGRADE_DIALOG_CHOOSE_IMAGE);
        }
        if (this.requestFrom == 5) {
            this.mmV.showLoadingDialog("正在上传");
            new a().execute(new String[0]);
        } else if (this.mmK != null) {
            if (this.mmY == null || !this.mmY.drv()) {
                if (this.mmK.IM()) {
                    VideoFileInfo drj = this.mmK.drj();
                    if (this.mmY == null) {
                        this.mmY = new j(this.mmV, this.forumName, this.forumId, "");
                        this.mmY.a(this.mnb);
                        this.mmY.setExtraData(this.antiData, this.prefixData, this.firstDir, this.secondDir);
                        if (this.mmW != null) {
                            this.mmW.a(this.mmY);
                        }
                    }
                    this.mmY.setProfessionZone(this.mnc);
                    this.mmY.a(drj, this.callFrom, this.from);
                } else if (this.mna && drl()) {
                    Is();
                } else {
                    l(null);
                }
            }
        }
    }

    private boolean drl() {
        if (this.mmK == null || w.getCount(this.mmK.IO()) == 0) {
            return false;
        }
        int i = 0;
        for (ImageFileInfo imageFileInfo : this.mmK.IO()) {
            if (imageFileInfo != null && imageFileInfo.getImageType() == 0 && (i = i + 1) >= 2) {
                return false;
            }
            i = i;
        }
        return i == 1;
    }

    private void Is() {
        WriteImagesInfo writeImagesInfo;
        if (this.mmK != null && (writeImagesInfo = this.mmK.getWriteImagesInfo()) != null) {
            this.mmV.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new WriteMulitImageActivityConfig(this.mmV, RequestResponseCode.REQUEST_MOTU_IMAGE, writeImagesInfo, drm())));
        }
    }

    private int drm() {
        if (this.mmK == null || w.getCount(this.mmK.IO()) == 0) {
            return 0;
        }
        for (int i = 0; i < w.getCount(this.mmK.IO()); i++) {
            ImageFileInfo imageFileInfo = this.mmK.IO().get(i);
            if (imageFileInfo != null && imageFileInfo.getImageType() == 0) {
                return i;
            }
        }
        return 0;
    }

    private void l(Intent intent) {
        Intent intent2 = new Intent();
        intent2.putExtra("album_result", this.mmK.getWriteImagesInfo().toJsonString());
        intent2.putExtra("camera_request_from", this.requestFrom);
        intent2.putExtra("from_type", this.biC);
        if (intent != null && !StringUtils.isNull(intent.getStringExtra("file_name"))) {
            intent2.putExtra("file_name", intent.getStringExtra("file_name"));
        }
        this.mmV.setResult(-1, intent2);
        this.mmV.finish();
        MessageManager.getInstance().sendMessage(new CustomMessage(2921464, intent2));
    }

    @Override // com.baidu.tbadk.suspended.a
    public boolean bim() {
        if (this.mmW == null || this.mmW.dri() == null || this.mmW.dri().drr() == null) {
            return true;
        }
        return this.mmW.dri().drr().getFirstVisiblePosition() == 0 && !this.mmW.dri().drr().canScrollVertically(-1);
    }

    @Override // com.baidu.tbadk.suspended.a
    public boolean bin() {
        return true;
    }

    @Override // com.baidu.tbadk.suspended.a
    public void ob(int i) {
        if (this.mmW != null) {
            this.mmW.onChangeSkinType(i);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void onSaveInstanceState(Bundle bundle) {
        bundle.putString("write_images_info", this.mmK.getWriteImagesInfo().toJsonString());
        bundle.putBoolean("use_original_img", this.biA);
        bundle.putInt("camera_request_from", this.requestFrom);
        bundle.putString("forum_id", this.forumId);
        bundle.putString("forum_name", this.forumName);
        bundle.putInt("album_thread", this.biz);
        bundle.putBoolean(IntentConfig.KEY_CAN_SELECT_VIDEO, this.mmZ);
        bundle.putBoolean("from_write", this.biB);
        bundle.putSerializable("tab_list", this.mnb);
        bundle.putSerializable("anti_data", this.antiData);
        bundle.putSerializable("prefix_data", this.prefixData);
        bundle.putString("forum_first_dir", this.firstDir);
        bundle.putString("forum_second_dir", this.secondDir);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.mmW.IE()) {
            Ir();
        } else if (view == this.mmW.IG()) {
            Ir();
        } else if (view == this.mmW.ID()) {
            if (this.mmK != null) {
                this.mmK.setLastAlbumId(null);
            }
            Iy();
        } else if (view == this.mmW.IF()) {
            dl(0, this.mmT);
        } else if (view == this.mmW.IH()) {
            ds(2);
        } else if (view == this.mmW.II()) {
            ds(1);
        }
    }

    private void Iy() {
        Intent intent = new Intent();
        String lastAlbumId = this.mmK.getLastAlbumId();
        if (TextUtils.isEmpty(lastAlbumId)) {
            lastAlbumId = "";
        }
        intent.putExtra("last_album_id", lastAlbumId);
        intent.putExtra("camera_request_from", this.requestFrom);
        this.mmV.setResult(0, intent);
        this.mmV.finish();
    }

    private void ds(int i) {
        if (this.mmW != null && this.mmK != null) {
            this.mmK.setOriginalImg(!this.mmK.isOriginalImg());
            It();
            dt(i);
        }
    }

    public void It() {
        if (this.mmK != null && this.mmW != null) {
            this.mmW.cn(this.mmK.isOriginalImg());
        }
    }

    private void dt(int i) {
        if (this.mmK != null && this.mmK.isOriginalImg() && !StringUtils.isNull(this.from, true) && !StringUtils.isNull(this.forumId, true)) {
            TiebaStatic.log(new ao("c10349").dk("fid", this.forumId).dk("obj_type", this.from).ag("obj_locate", i));
        }
    }

    @Override // com.baidu.tbadk.suspended.a
    public Intent bio() {
        return null;
    }

    public void e(ImageFileInfo imageFileInfo) {
        if (imageFileInfo != null) {
            Intent intent = new Intent();
            LinkedList<ImageFileInfo> linkedList = new LinkedList<>();
            linkedList.add(imageFileInfo);
            this.mmK.getWriteImagesInfo().setChosedFiles(linkedList);
            intent.putExtra("album_result", this.mmK.getWriteImagesInfo().toJsonString());
            intent.putExtra("camera_request_from", this.requestFrom);
            intent.putExtra("from_type", this.biC);
            this.mmV.setResult(-1, intent);
            this.mmV.finish();
        }
    }

    public c drn() {
        return this.mmK;
    }

    public void g(TbPageContext tbPageContext) {
        PostPrefixData postPrefixData;
        AntiData antiData = null;
        if (!bFN() && com.baidu.tieba.write.j.dqY()) {
            RecordVideoActivityConfig recordVideoActivityConfig = new RecordVideoActivityConfig(tbPageContext.getPageActivity(), this.biB ? 2 : 3, new ForumWriteData(this.forumId, this.forumName, null, null), this.mmK.getWriteImagesInfo(), "", this.biC);
            recordVideoActivityConfig.setShowType(this.mmZ ? 0 : 1);
            if (this.mmZ) {
                String str = "";
                String str2 = "";
                if (this.mmV.getIntent() != null) {
                    Serializable serializableExtra = this.mmV.getIntent().getSerializableExtra("anti_data");
                    AntiData antiData2 = serializableExtra instanceof AntiData ? (AntiData) serializableExtra : null;
                    Serializable serializableExtra2 = this.mmV.getIntent().getSerializableExtra("prefix_data");
                    PostPrefixData postPrefixData2 = serializableExtra2 instanceof PostPrefixData ? (PostPrefixData) serializableExtra2 : null;
                    antiData = antiData2;
                    str = this.mmV.getIntent().getStringExtra("forum_first_dir");
                    postPrefixData = postPrefixData2;
                    str2 = this.mmV.getIntent().getStringExtra("forum_second_dir");
                } else {
                    postPrefixData = null;
                }
                recordVideoActivityConfig.setExtraData(antiData, postPrefixData, str, str2);
            }
            this.mmV.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, recordVideoActivityConfig));
            TiebaStatic.log(new ao(CommonStatisticKey.KEY_ENTRANCE_CLICKED).ag("obj_locate", 5).ag("obj_type", 2));
        }
    }

    private boolean bFN() {
        PermissionJudgePolicy permissionJudgePolicy = new PermissionJudgePolicy();
        permissionJudgePolicy.clearRequestPermissionList();
        permissionJudgePolicy.appendRequestPermission(this.mmV, PermissionRequest.RESOURCE_VIDEO_CAPTURE);
        permissionJudgePolicy.appendRequestPermission(this.mmV, PermissionRequest.RESOURCE_AUDIO_CAPTURE);
        permissionJudgePolicy.appendRequestPermission(this.mmV, "android.permission.WRITE_EXTERNAL_STORAGE");
        return permissionJudgePolicy.startRequestPermission(this.mmV);
    }

    public boolean f(ImageFileInfo imageFileInfo) {
        if (imageFileInfo == null) {
            return false;
        }
        this.mmK.a(null);
        this.mmK.delChooseFile(imageFileInfo);
        It();
        return true;
    }

    public boolean g(ImageFileInfo imageFileInfo) {
        if (imageFileInfo == null) {
            return false;
        }
        int maxImagesAllowed = this.mmK.getMaxImagesAllowed();
        if (this.mmK.size() < maxImagesAllowed) {
            if (this.mmX == null || this.mmX.h(imageFileInfo)) {
                ImageFileInfo imageFileInfo2 = new ImageFileInfo();
                imageFileInfo2.setAlbumnId(imageFileInfo.getAlbumId());
                imageFileInfo2.setContentUriStr(imageFileInfo.getContentUriStr());
                imageFileInfo2.setFilePath(imageFileInfo.getFilePath());
                imageFileInfo2.setModifyTime(imageFileInfo.getModifyTime());
                imageFileInfo2.setIsGif(imageFileInfo.isGif());
                imageFileInfo2.setIsLong(imageFileInfo.isLong());
                this.mmK.a(null);
                this.mmK.addChooseFile(imageFileInfo2);
                It();
                return true;
            }
            return false;
        } else if (Ix()) {
            return g(imageFileInfo);
        } else {
            this.mmV.showToast(String.format(this.mmV.getString(R.string.max_choose_image_count), Integer.valueOf(maxImagesAllowed)));
            return false;
        }
    }

    private boolean Ix() {
        if (this.mmV.getIntent().getBooleanExtra("select_directly", false)) {
            int maxImagesAllowed = this.mmK.getMaxImagesAllowed();
            if (this.mmK.size() == maxImagesAllowed && maxImagesAllowed == 1) {
                try {
                    ImageFileInfo imageFileInfo = (ImageFileInfo) w.getItem(this.mmK.IO(), 0);
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
        Fragment GE;
        if (this.mmW != null && (GE = this.mmW.GE(0)) != null && (GE instanceof ImageListFragment)) {
            ((ImageListFragment) GE).f(imageFileInfo, z);
        }
    }

    private void h(ImageFileInfo imageFileInfo, boolean z) {
        Fragment GE;
        if (this.mmW != null && (GE = this.mmW.GE(1)) != null && (GE instanceof AlbumImageBrowseFragment)) {
            ((AlbumImageBrowseFragment) GE).f(imageFileInfo, z);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void m(Intent intent) {
        this.mnd = intent;
        if (intent == null || this.mmK == null) {
            l(null);
            return;
        }
        String stringExtra = intent.getStringExtra("album_result");
        if (stringExtra != null) {
            WriteImagesInfo writeImagesInfo = this.mmK.getWriteImagesInfo();
            writeImagesInfo.parseJson(stringExtra);
            writeImagesInfo.updateQuality();
            l(intent);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void onBackClick() {
        this.mmV.closeLoadingDialog();
        if (this.aLb == 0) {
            if (this.mmK != null) {
                this.mmK.setLastAlbumId(null);
            }
            Iy();
        } else if (this.aLb == 1) {
            du(0);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int Iv() {
        return this.biz;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean dro() {
        return this.mmZ;
    }

    private void stopCamera() {
        if (this.mmW != null) {
            this.mmW.stopCamera();
        }
    }

    private void QO() {
        if (this.mmW != null) {
            this.mmW.QO();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void onStart() {
        if (this.mmY != null) {
            this.mmY.onStart();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void onResume() {
        QO();
        if (this.mmY != null) {
            this.mmY.onResume();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void onStop() {
        if (this.mmY != null) {
            this.mmY.onStop();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void onPause() {
        stopCamera();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void onDestroy() {
        this.bix = true;
        stopCamera();
        this.mmV.closeLoadingDialog();
        this.mmV.dismissAllDialog();
        d.drk().destory();
        if (this.mmW != null) {
            this.mmW.onDestroy();
        }
        if (this.mmY != null) {
            this.mmY.onDestroy();
        }
        Intent intent = new Intent();
        intent.setAction(AlbumActivityConfig.ACTION_SELECT_IMAGE_RESULT);
        intent.putExtra("album_result", this.mmK.getWriteImagesInfo().toJsonString());
        intent.putExtra("camera_request_from", this.requestFrom);
        intent.putExtra("from_type", this.biC);
        if (this.mnd != null && !StringUtils.isNull(this.mnd.getStringExtra("file_name"))) {
            intent.putExtra("file_name", this.mnd.getStringExtra("file_name"));
        }
        TbadkCoreApplication.getInst().sendBroadcast(intent);
    }

    public void onRequestPermissionsResult(int i, @NonNull String[] strArr, @NonNull int[] iArr) {
        if (this.mmW != null) {
            this.mmW.drh();
        }
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
            new com.baidu.tbadk.img.f(null).c(e.this.mmK.getWriteImagesInfo(), true);
            return e.this.mmK.getWriteImagesInfo().toJsonString();
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPostExecute(String str) {
            Intent intent = new Intent();
            intent.putExtra("album_result", str);
            e.this.mmV.setResult(-1, intent);
            e.this.mmV.finish();
        }
    }
}
