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
    private c mmN;
    private int mmW;
    private int mmX;
    private BaseFragmentActivity mmY;
    private com.baidu.tieba.write.album.a mmZ;
    private f mna;
    private j mnb;
    private FrsTabInfoData mne;
    private Intent mng;
    private int aLb = 0;
    private boolean bix = false;
    private String callFrom = "";
    private String from = "";
    private String forumName = "";
    private String forumId = "0";
    private int requestFrom = 0;
    private int biz = 0;
    private boolean mnc = false;
    private boolean mnd = true;
    private boolean biA = false;
    private boolean biB = false;
    private int biC = 0;
    private int mnf = -1;
    private PostPrefixData prefixData = null;
    private AntiData antiData = null;
    private String firstDir = "";
    private String secondDir = "";

    public e(BaseFragmentActivity baseFragmentActivity, Bundle bundle, int i, int i2) {
        a(baseFragmentActivity, i, i2);
        if (bundle == null) {
            an(this.mmY.getIntent());
        } else {
            initData(bundle);
        }
        dl(0, this.mmW);
    }

    private void a(BaseFragmentActivity baseFragmentActivity, int i, int i2) {
        this.mmY = baseFragmentActivity;
        this.mmW = i;
        this.mmX = i2;
        this.mmZ = new com.baidu.tieba.write.album.a(baseFragmentActivity.getPageContext(), this);
        this.mmZ.IC();
    }

    private void initData(Bundle bundle) {
        this.mmN = new c(this.mmY.getPageContext());
        if (bundle != null) {
            WriteImagesInfo writeImagesInfo = new WriteImagesInfo();
            writeImagesInfo.parseJson(bundle.getString("write_images_info"));
            this.mmN.setWriteImagesInfo(writeImagesInfo);
            this.biA = bundle.getBoolean("use_original_img", false);
            this.requestFrom = bundle.getInt("camera_request_from", 0);
            this.forumId = bundle.getString("forum_id");
            this.forumName = bundle.getString("forum_name");
            this.biz = bundle.getInt("album_thread");
            this.mnc = bundle.getBoolean(IntentConfig.KEY_CAN_SELECT_VIDEO);
            this.biB = bundle.getBoolean("from_write");
            this.callFrom = bundle.getString("KEY_CALL_FROM");
            this.biC = bundle.getInt("from_type");
            this.mne = (FrsTabInfoData) bundle.getSerializable("tab_list");
            this.from = bundle.getString("from");
            this.mnf = bundle.getInt(WriteActivityConfig.KEY_PROFESSION_ZONE, -1);
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
        this.mmN = new c(this.mmY.getPageContext());
        if (intent != null) {
            WriteImagesInfo writeImagesInfo = new WriteImagesInfo();
            writeImagesInfo.parseJson(intent.getStringExtra("write_images_info"));
            this.mmN.setWriteImagesInfo(writeImagesInfo);
            this.mmN.setOriginalImg(writeImagesInfo.isOriginalImg());
            this.biA = intent.getBooleanExtra("use_original_img", false);
            this.requestFrom = intent.getIntExtra("camera_request_from", 0);
            this.from = intent.getStringExtra("from");
            this.forumId = intent.getStringExtra("forum_id");
            this.forumName = intent.getStringExtra("forum_name");
            this.biz = intent.getIntExtra("album_thread", 0);
            this.mnc = intent.getBooleanExtra(IntentConfig.KEY_CAN_SELECT_VIDEO, false);
            this.mnd = intent.getBooleanExtra(IntentConfig.KEY_CAN_EDIT_IMAGE, true);
            this.biB = intent.getBooleanExtra("from_write", false);
            this.callFrom = intent.getStringExtra("KEY_CALL_FROM");
            this.biC = intent.getIntExtra("from_type", 0);
            this.mne = (FrsTabInfoData) intent.getSerializableExtra("tab_list");
            this.mnf = intent.getIntExtra(WriteActivityConfig.KEY_PROFESSION_ZONE, -1);
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
            this.mna = new f() { // from class: com.baidu.tieba.write.album.e.1
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
                    BdToast.a((Context) e.this.mmY, (CharSequence) e.this.mmY.getString(R.string.uploade_attation), (int) R.drawable.icon_toast_game_error, false).aUS();
                    return false;
                }
            };
        }
    }

    public void a(NavigationBar navigationBar) {
        if (navigationBar != null) {
            this.mmZ.a(navigationBar);
        }
    }

    public void du(int i) {
        if (i == 1) {
            dl(i, this.mmX);
        } else {
            dl(i, this.mmW);
        }
    }

    private void dl(int i, int i2) {
        if (!this.bix) {
            FragmentTransaction beginTransaction = this.mmY.getSupportFragmentManager().beginTransaction();
            Fragment findFragmentByTag = this.mmY.getSupportFragmentManager().findFragmentByTag(this.mmZ.GF(this.aLb));
            if (findFragmentByTag != null) {
                beginTransaction.hide(findFragmentByTag);
            }
            this.aLb = i;
            if (this.mmY.getSupportFragmentManager().findFragmentByTag(this.mmZ.GF(i)) != null) {
                beginTransaction.show(this.mmZ.GE(i));
            } else {
                beginTransaction.add(i2, this.mmZ.GE(i), this.mmZ.GF(i));
            }
            beginTransaction.commitAllowingStateLoss();
            this.mmY.getSupportFragmentManager().executePendingTransactions();
        }
    }

    public void Ir() {
        if (this.requestFrom == 3) {
            TiebaStatic.log(TbadkCoreStatisticKey.UPGRADE_DIALOG_CHOOSE_IMAGE);
        }
        if (this.requestFrom == 5) {
            this.mmY.showLoadingDialog("正在上传");
            new a().execute(new String[0]);
        } else if (this.mmN != null) {
            if (this.mnb == null || !this.mnb.drz()) {
                if (this.mmN.IM()) {
                    VideoFileInfo drn = this.mmN.drn();
                    if (this.mnb == null) {
                        this.mnb = new j(this.mmY, this.forumName, this.forumId, "");
                        this.mnb.a(this.mne);
                        this.mnb.setExtraData(this.antiData, this.prefixData, this.firstDir, this.secondDir);
                        if (this.mmZ != null) {
                            this.mmZ.a(this.mnb);
                        }
                    }
                    this.mnb.setProfessionZone(this.mnf);
                    this.mnb.a(drn, this.callFrom, this.from);
                } else if (this.mnd && drp()) {
                    Is();
                } else {
                    l(null);
                }
            }
        }
    }

    private boolean drp() {
        if (this.mmN == null || w.getCount(this.mmN.IO()) == 0) {
            return false;
        }
        int i = 0;
        for (ImageFileInfo imageFileInfo : this.mmN.IO()) {
            if (imageFileInfo != null && imageFileInfo.getImageType() == 0 && (i = i + 1) >= 2) {
                return false;
            }
            i = i;
        }
        return i == 1;
    }

    private void Is() {
        WriteImagesInfo writeImagesInfo;
        if (this.mmN != null && (writeImagesInfo = this.mmN.getWriteImagesInfo()) != null) {
            this.mmY.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new WriteMulitImageActivityConfig(this.mmY, RequestResponseCode.REQUEST_MOTU_IMAGE, writeImagesInfo, drq())));
        }
    }

    private int drq() {
        if (this.mmN == null || w.getCount(this.mmN.IO()) == 0) {
            return 0;
        }
        for (int i = 0; i < w.getCount(this.mmN.IO()); i++) {
            ImageFileInfo imageFileInfo = this.mmN.IO().get(i);
            if (imageFileInfo != null && imageFileInfo.getImageType() == 0) {
                return i;
            }
        }
        return 0;
    }

    private void l(Intent intent) {
        Intent intent2 = new Intent();
        intent2.putExtra("album_result", this.mmN.getWriteImagesInfo().toJsonString());
        intent2.putExtra("camera_request_from", this.requestFrom);
        intent2.putExtra("from_type", this.biC);
        if (intent != null && !StringUtils.isNull(intent.getStringExtra("file_name"))) {
            intent2.putExtra("file_name", intent.getStringExtra("file_name"));
        }
        this.mmY.setResult(-1, intent2);
        this.mmY.finish();
        MessageManager.getInstance().sendMessage(new CustomMessage(2921464, intent2));
    }

    @Override // com.baidu.tbadk.suspended.a
    public boolean bim() {
        if (this.mmZ == null || this.mmZ.drm() == null || this.mmZ.drm().drv() == null) {
            return true;
        }
        return this.mmZ.drm().drv().getFirstVisiblePosition() == 0 && !this.mmZ.drm().drv().canScrollVertically(-1);
    }

    @Override // com.baidu.tbadk.suspended.a
    public boolean bin() {
        return true;
    }

    @Override // com.baidu.tbadk.suspended.a
    public void ob(int i) {
        if (this.mmZ != null) {
            this.mmZ.onChangeSkinType(i);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void onSaveInstanceState(Bundle bundle) {
        bundle.putString("write_images_info", this.mmN.getWriteImagesInfo().toJsonString());
        bundle.putBoolean("use_original_img", this.biA);
        bundle.putInt("camera_request_from", this.requestFrom);
        bundle.putString("forum_id", this.forumId);
        bundle.putString("forum_name", this.forumName);
        bundle.putInt("album_thread", this.biz);
        bundle.putBoolean(IntentConfig.KEY_CAN_SELECT_VIDEO, this.mnc);
        bundle.putBoolean("from_write", this.biB);
        bundle.putSerializable("tab_list", this.mne);
        bundle.putSerializable("anti_data", this.antiData);
        bundle.putSerializable("prefix_data", this.prefixData);
        bundle.putString("forum_first_dir", this.firstDir);
        bundle.putString("forum_second_dir", this.secondDir);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.mmZ.IE()) {
            Ir();
        } else if (view == this.mmZ.IG()) {
            Ir();
        } else if (view == this.mmZ.ID()) {
            if (this.mmN != null) {
                this.mmN.setLastAlbumId(null);
            }
            Iy();
        } else if (view == this.mmZ.IF()) {
            dl(0, this.mmW);
        } else if (view == this.mmZ.IH()) {
            ds(2);
        } else if (view == this.mmZ.II()) {
            ds(1);
        }
    }

    private void Iy() {
        Intent intent = new Intent();
        String lastAlbumId = this.mmN.getLastAlbumId();
        if (TextUtils.isEmpty(lastAlbumId)) {
            lastAlbumId = "";
        }
        intent.putExtra("last_album_id", lastAlbumId);
        intent.putExtra("camera_request_from", this.requestFrom);
        this.mmY.setResult(0, intent);
        this.mmY.finish();
    }

    private void ds(int i) {
        if (this.mmZ != null && this.mmN != null) {
            this.mmN.setOriginalImg(!this.mmN.isOriginalImg());
            It();
            dt(i);
        }
    }

    public void It() {
        if (this.mmN != null && this.mmZ != null) {
            this.mmZ.cn(this.mmN.isOriginalImg());
        }
    }

    private void dt(int i) {
        if (this.mmN != null && this.mmN.isOriginalImg() && !StringUtils.isNull(this.from, true) && !StringUtils.isNull(this.forumId, true)) {
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
            this.mmN.getWriteImagesInfo().setChosedFiles(linkedList);
            intent.putExtra("album_result", this.mmN.getWriteImagesInfo().toJsonString());
            intent.putExtra("camera_request_from", this.requestFrom);
            intent.putExtra("from_type", this.biC);
            this.mmY.setResult(-1, intent);
            this.mmY.finish();
        }
    }

    public c drr() {
        return this.mmN;
    }

    public void g(TbPageContext tbPageContext) {
        PostPrefixData postPrefixData;
        AntiData antiData = null;
        if (!bFO() && com.baidu.tieba.write.j.drc()) {
            RecordVideoActivityConfig recordVideoActivityConfig = new RecordVideoActivityConfig(tbPageContext.getPageActivity(), this.biB ? 2 : 3, new ForumWriteData(this.forumId, this.forumName, null, null), this.mmN.getWriteImagesInfo(), "", this.biC);
            recordVideoActivityConfig.setShowType(this.mnc ? 0 : 1);
            if (this.mnc) {
                String str = "";
                String str2 = "";
                if (this.mmY.getIntent() != null) {
                    Serializable serializableExtra = this.mmY.getIntent().getSerializableExtra("anti_data");
                    AntiData antiData2 = serializableExtra instanceof AntiData ? (AntiData) serializableExtra : null;
                    Serializable serializableExtra2 = this.mmY.getIntent().getSerializableExtra("prefix_data");
                    PostPrefixData postPrefixData2 = serializableExtra2 instanceof PostPrefixData ? (PostPrefixData) serializableExtra2 : null;
                    antiData = antiData2;
                    str = this.mmY.getIntent().getStringExtra("forum_first_dir");
                    postPrefixData = postPrefixData2;
                    str2 = this.mmY.getIntent().getStringExtra("forum_second_dir");
                } else {
                    postPrefixData = null;
                }
                recordVideoActivityConfig.setExtraData(antiData, postPrefixData, str, str2);
            }
            this.mmY.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, recordVideoActivityConfig));
            TiebaStatic.log(new ao(CommonStatisticKey.KEY_ENTRANCE_CLICKED).ag("obj_locate", 5).ag("obj_type", 2));
        }
    }

    private boolean bFO() {
        PermissionJudgePolicy permissionJudgePolicy = new PermissionJudgePolicy();
        permissionJudgePolicy.clearRequestPermissionList();
        permissionJudgePolicy.appendRequestPermission(this.mmY, PermissionRequest.RESOURCE_VIDEO_CAPTURE);
        permissionJudgePolicy.appendRequestPermission(this.mmY, PermissionRequest.RESOURCE_AUDIO_CAPTURE);
        permissionJudgePolicy.appendRequestPermission(this.mmY, "android.permission.WRITE_EXTERNAL_STORAGE");
        return permissionJudgePolicy.startRequestPermission(this.mmY);
    }

    public boolean f(ImageFileInfo imageFileInfo) {
        if (imageFileInfo == null) {
            return false;
        }
        this.mmN.a(null);
        this.mmN.delChooseFile(imageFileInfo);
        It();
        return true;
    }

    public boolean g(ImageFileInfo imageFileInfo) {
        if (imageFileInfo == null) {
            return false;
        }
        int maxImagesAllowed = this.mmN.getMaxImagesAllowed();
        if (this.mmN.size() < maxImagesAllowed) {
            if (this.mna == null || this.mna.h(imageFileInfo)) {
                ImageFileInfo imageFileInfo2 = new ImageFileInfo();
                imageFileInfo2.setAlbumnId(imageFileInfo.getAlbumId());
                imageFileInfo2.setContentUriStr(imageFileInfo.getContentUriStr());
                imageFileInfo2.setFilePath(imageFileInfo.getFilePath());
                imageFileInfo2.setModifyTime(imageFileInfo.getModifyTime());
                imageFileInfo2.setIsGif(imageFileInfo.isGif());
                imageFileInfo2.setIsLong(imageFileInfo.isLong());
                this.mmN.a(null);
                this.mmN.addChooseFile(imageFileInfo2);
                It();
                return true;
            }
            return false;
        } else if (Ix()) {
            return g(imageFileInfo);
        } else {
            this.mmY.showToast(String.format(this.mmY.getString(R.string.max_choose_image_count), Integer.valueOf(maxImagesAllowed)));
            return false;
        }
    }

    private boolean Ix() {
        if (this.mmY.getIntent().getBooleanExtra("select_directly", false)) {
            int maxImagesAllowed = this.mmN.getMaxImagesAllowed();
            if (this.mmN.size() == maxImagesAllowed && maxImagesAllowed == 1) {
                try {
                    ImageFileInfo imageFileInfo = (ImageFileInfo) w.getItem(this.mmN.IO(), 0);
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
        if (this.mmZ != null && (GE = this.mmZ.GE(0)) != null && (GE instanceof ImageListFragment)) {
            ((ImageListFragment) GE).f(imageFileInfo, z);
        }
    }

    private void h(ImageFileInfo imageFileInfo, boolean z) {
        Fragment GE;
        if (this.mmZ != null && (GE = this.mmZ.GE(1)) != null && (GE instanceof AlbumImageBrowseFragment)) {
            ((AlbumImageBrowseFragment) GE).f(imageFileInfo, z);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void m(Intent intent) {
        this.mng = intent;
        if (intent == null || this.mmN == null) {
            l(null);
            return;
        }
        String stringExtra = intent.getStringExtra("album_result");
        if (stringExtra != null) {
            WriteImagesInfo writeImagesInfo = this.mmN.getWriteImagesInfo();
            writeImagesInfo.parseJson(stringExtra);
            writeImagesInfo.updateQuality();
            l(intent);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void onBackClick() {
        this.mmY.closeLoadingDialog();
        if (this.aLb == 0) {
            if (this.mmN != null) {
                this.mmN.setLastAlbumId(null);
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
    public boolean drs() {
        return this.mnc;
    }

    private void stopCamera() {
        if (this.mmZ != null) {
            this.mmZ.stopCamera();
        }
    }

    private void QO() {
        if (this.mmZ != null) {
            this.mmZ.QO();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void onStart() {
        if (this.mnb != null) {
            this.mnb.onStart();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void onResume() {
        QO();
        if (this.mnb != null) {
            this.mnb.onResume();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void onStop() {
        if (this.mnb != null) {
            this.mnb.onStop();
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
        this.mmY.closeLoadingDialog();
        this.mmY.dismissAllDialog();
        d.dro().destory();
        if (this.mmZ != null) {
            this.mmZ.onDestroy();
        }
        if (this.mnb != null) {
            this.mnb.onDestroy();
        }
        Intent intent = new Intent();
        intent.setAction(AlbumActivityConfig.ACTION_SELECT_IMAGE_RESULT);
        intent.putExtra("album_result", this.mmN.getWriteImagesInfo().toJsonString());
        intent.putExtra("camera_request_from", this.requestFrom);
        intent.putExtra("from_type", this.biC);
        if (this.mng != null && !StringUtils.isNull(this.mng.getStringExtra("file_name"))) {
            intent.putExtra("file_name", this.mng.getStringExtra("file_name"));
        }
        TbadkCoreApplication.getInst().sendBroadcast(intent);
    }

    public void onRequestPermissionsResult(int i, @NonNull String[] strArr, @NonNull int[] iArr) {
        if (this.mmZ != null) {
            this.mmZ.drl();
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
            new com.baidu.tbadk.img.f(null).c(e.this.mmN.getWriteImagesInfo(), true);
            return e.this.mmN.getWriteImagesInfo().toJsonString();
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPostExecute(String str) {
            Intent intent = new Intent();
            intent.putExtra("album_result", str);
            e.this.mmY.setResult(-1, intent);
            e.this.mmY.finish();
        }
    }
}
