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
import com.baidu.tbadk.core.util.ap;
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
/* loaded from: classes3.dex */
public class e implements View.OnClickListener, com.baidu.tbadk.suspended.a {
    private c muN;
    private int muW;
    private int muX;
    private BaseFragmentActivity muY;
    private com.baidu.tieba.write.album.a muZ;
    private f mva;
    private j mvb;
    private FrsTabInfoData mve;
    private Intent mvg;
    private int aMx = 0;
    private boolean biR = false;
    private String callFrom = "";
    private String from = "";
    private String forumName = "";
    private String forumId = "0";
    private int requestFrom = 0;
    private int biT = 0;
    private boolean mvc = false;
    private boolean mvd = true;
    private boolean biU = false;
    private boolean biV = false;
    private int biW = 0;
    private int mvf = -1;
    private PostPrefixData prefixData = null;
    private AntiData antiData = null;
    private String firstDir = "";
    private String secondDir = "";

    public e(BaseFragmentActivity baseFragmentActivity, Bundle bundle, int i, int i2) {
        a(baseFragmentActivity, i, i2);
        if (bundle == null) {
            ao(this.muY.getIntent());
        } else {
            initData(bundle);
        }
        dn(0, this.muW);
    }

    private void a(BaseFragmentActivity baseFragmentActivity, int i, int i2) {
        this.muY = baseFragmentActivity;
        this.muW = i;
        this.muX = i2;
        this.muZ = new com.baidu.tieba.write.album.a(baseFragmentActivity.getPageContext(), this);
        this.muZ.II();
    }

    private void initData(Bundle bundle) {
        this.muN = new c(this.muY.getPageContext());
        if (bundle != null) {
            WriteImagesInfo writeImagesInfo = new WriteImagesInfo();
            writeImagesInfo.parseJson(bundle.getString("write_images_info"));
            this.muN.setWriteImagesInfo(writeImagesInfo);
            this.biU = bundle.getBoolean("use_original_img", false);
            this.requestFrom = bundle.getInt("camera_request_from", 0);
            this.forumId = bundle.getString("forum_id");
            this.forumName = bundle.getString("forum_name");
            this.biT = bundle.getInt("album_thread");
            this.mvc = bundle.getBoolean(IntentConfig.KEY_CAN_SELECT_VIDEO);
            this.biV = bundle.getBoolean("from_write");
            this.callFrom = bundle.getString("KEY_CALL_FROM");
            this.biW = bundle.getInt("from_type");
            this.mve = (FrsTabInfoData) bundle.getSerializable("tab_list");
            this.from = bundle.getString("from");
            this.mvf = bundle.getInt(WriteActivityConfig.KEY_PROFESSION_ZONE, -1);
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
        Iw();
    }

    private void ao(Intent intent) {
        this.muN = new c(this.muY.getPageContext());
        if (intent != null) {
            WriteImagesInfo writeImagesInfo = new WriteImagesInfo();
            writeImagesInfo.parseJson(intent.getStringExtra("write_images_info"));
            this.muN.setWriteImagesInfo(writeImagesInfo);
            this.muN.setOriginalImg(writeImagesInfo.isOriginalImg());
            this.biU = intent.getBooleanExtra("use_original_img", false);
            this.requestFrom = intent.getIntExtra("camera_request_from", 0);
            this.from = intent.getStringExtra("from");
            this.forumId = intent.getStringExtra("forum_id");
            this.forumName = intent.getStringExtra("forum_name");
            this.biT = intent.getIntExtra("album_thread", 0);
            this.mvc = intent.getBooleanExtra(IntentConfig.KEY_CAN_SELECT_VIDEO, false);
            this.mvd = intent.getBooleanExtra(IntentConfig.KEY_CAN_EDIT_IMAGE, true);
            this.biV = intent.getBooleanExtra("from_write", false);
            this.callFrom = intent.getStringExtra("KEY_CALL_FROM");
            this.biW = intent.getIntExtra("from_type", 0);
            this.mve = (FrsTabInfoData) intent.getSerializableExtra("tab_list");
            this.mvf = intent.getIntExtra(WriteActivityConfig.KEY_PROFESSION_ZONE, -1);
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
        Iw();
    }

    private void Iw() {
        if (this.requestFrom == 2) {
            this.mva = new f() { // from class: com.baidu.tieba.write.album.e.1
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
                    BdToast.a((Context) e.this.muY, (CharSequence) e.this.muY.getString(R.string.uploade_attation), R.drawable.icon_toast_game_error, false).aYR();
                    return false;
                }
            };
        }
    }

    public void a(NavigationBar navigationBar) {
        if (navigationBar != null) {
            this.muZ.a(navigationBar);
        }
    }

    public void du(int i) {
        if (i == 1) {
            dn(i, this.muX);
        } else {
            dn(i, this.muW);
        }
    }

    private void dn(int i, int i2) {
        if (!this.biR) {
            FragmentTransaction beginTransaction = this.muY.getSupportFragmentManager().beginTransaction();
            Fragment findFragmentByTag = this.muY.getSupportFragmentManager().findFragmentByTag(this.muZ.Hb(this.aMx));
            if (findFragmentByTag != null) {
                beginTransaction.hide(findFragmentByTag);
            }
            this.aMx = i;
            if (this.muY.getSupportFragmentManager().findFragmentByTag(this.muZ.Hb(i)) != null) {
                beginTransaction.show(this.muZ.Ha(i));
            } else {
                beginTransaction.add(i2, this.muZ.Ha(i), this.muZ.Hb(i));
            }
            beginTransaction.commitAllowingStateLoss();
            this.muY.getSupportFragmentManager().executePendingTransactions();
        }
    }

    public void Ix() {
        if (this.requestFrom == 3) {
            TiebaStatic.log(TbadkCoreStatisticKey.UPGRADE_DIALOG_CHOOSE_IMAGE);
        }
        if (this.requestFrom == 5) {
            this.muY.showLoadingDialog("正在上传");
            new a().execute(new String[0]);
        } else if (this.muN != null) {
            if (this.mvb == null || !this.mvb.duL()) {
                if (this.muN.IS()) {
                    VideoFileInfo duz = this.muN.duz();
                    if (this.mvb == null) {
                        this.mvb = new j(this.muY, this.forumName, this.forumId, "");
                        this.mvb.a(this.mve);
                        this.mvb.setExtraData(this.antiData, this.prefixData, this.firstDir, this.secondDir);
                        if (this.muZ != null) {
                            this.muZ.a(this.mvb);
                        }
                    }
                    this.mvb.setProfessionZone(this.mvf);
                    this.mvb.a(duz, this.callFrom, this.from);
                } else if (this.mvd && duB()) {
                    Iy();
                } else {
                    l(null);
                }
            }
        }
    }

    private boolean duB() {
        if (this.muN == null || x.getCount(this.muN.IU()) == 0) {
            return false;
        }
        int i = 0;
        for (ImageFileInfo imageFileInfo : this.muN.IU()) {
            if (imageFileInfo != null && imageFileInfo.getImageType() == 0 && (i = i + 1) >= 2) {
                return false;
            }
            i = i;
        }
        return i == 1;
    }

    private void Iy() {
        WriteImagesInfo writeImagesInfo;
        if (this.muN != null && (writeImagesInfo = this.muN.getWriteImagesInfo()) != null) {
            this.muY.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new WriteMulitImageActivityConfig(this.muY, RequestResponseCode.REQUEST_MOTU_IMAGE, writeImagesInfo, duC())));
        }
    }

    private int duC() {
        if (this.muN == null || x.getCount(this.muN.IU()) == 0) {
            return 0;
        }
        for (int i = 0; i < x.getCount(this.muN.IU()); i++) {
            ImageFileInfo imageFileInfo = this.muN.IU().get(i);
            if (imageFileInfo != null && imageFileInfo.getImageType() == 0) {
                return i;
            }
        }
        return 0;
    }

    private void l(Intent intent) {
        Intent intent2 = new Intent();
        intent2.putExtra("album_result", this.muN.getWriteImagesInfo().toJsonString());
        intent2.putExtra("camera_request_from", this.requestFrom);
        intent2.putExtra("from_type", this.biW);
        if (intent != null && !StringUtils.isNull(intent.getStringExtra("file_name"))) {
            intent2.putExtra("file_name", intent.getStringExtra("file_name"));
        }
        this.muY.setResult(-1, intent2);
        this.muY.finish();
        MessageManager.getInstance().sendMessage(new CustomMessage(2921464, intent2));
    }

    @Override // com.baidu.tbadk.suspended.a
    public boolean blX() {
        if (this.muZ == null || this.muZ.duy() == null || this.muZ.duy().duH() == null) {
            return true;
        }
        return this.muZ.duy().duH().getFirstVisiblePosition() == 0 && !this.muZ.duy().duH().canScrollVertically(-1);
    }

    @Override // com.baidu.tbadk.suspended.a
    public boolean blY() {
        return true;
    }

    @Override // com.baidu.tbadk.suspended.a
    public void ot(int i) {
        if (this.muZ != null) {
            this.muZ.onChangeSkinType(i);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void onSaveInstanceState(Bundle bundle) {
        bundle.putString("write_images_info", this.muN.getWriteImagesInfo().toJsonString());
        bundle.putBoolean("use_original_img", this.biU);
        bundle.putInt("camera_request_from", this.requestFrom);
        bundle.putString("forum_id", this.forumId);
        bundle.putString("forum_name", this.forumName);
        bundle.putInt("album_thread", this.biT);
        bundle.putBoolean(IntentConfig.KEY_CAN_SELECT_VIDEO, this.mvc);
        bundle.putBoolean("from_write", this.biV);
        bundle.putSerializable("tab_list", this.mve);
        bundle.putSerializable("anti_data", this.antiData);
        bundle.putSerializable("prefix_data", this.prefixData);
        bundle.putString("forum_first_dir", this.firstDir);
        bundle.putString("forum_second_dir", this.secondDir);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.muZ.IK()) {
            Ix();
        } else if (view == this.muZ.IM()) {
            Ix();
        } else if (view == this.muZ.IJ()) {
            if (this.muN != null) {
                this.muN.setLastAlbumId(null);
            }
            IE();
        } else if (view == this.muZ.IL()) {
            dn(0, this.muW);
        } else if (view == this.muZ.IN()) {
            ds(2);
        } else if (view == this.muZ.IO()) {
            ds(1);
        }
    }

    private void IE() {
        Intent intent = new Intent();
        String lastAlbumId = this.muN.getLastAlbumId();
        if (TextUtils.isEmpty(lastAlbumId)) {
            lastAlbumId = "";
        }
        intent.putExtra("last_album_id", lastAlbumId);
        intent.putExtra("camera_request_from", this.requestFrom);
        this.muY.setResult(0, intent);
        this.muY.finish();
    }

    private void ds(int i) {
        if (this.muZ != null && this.muN != null) {
            this.muN.setOriginalImg(!this.muN.isOriginalImg());
            Iz();
            dt(i);
        }
    }

    public void Iz() {
        if (this.muN != null && this.muZ != null) {
            this.muZ.cp(this.muN.isOriginalImg());
        }
    }

    private void dt(int i) {
        if (this.muN != null && this.muN.isOriginalImg() && !StringUtils.isNull(this.from, true) && !StringUtils.isNull(this.forumId, true)) {
            TiebaStatic.log(new ap("c10349").dn("fid", this.forumId).dn("obj_type", this.from).ah("obj_locate", i));
        }
    }

    @Override // com.baidu.tbadk.suspended.a
    public Intent blZ() {
        return null;
    }

    public void e(ImageFileInfo imageFileInfo) {
        if (imageFileInfo != null) {
            Intent intent = new Intent();
            LinkedList<ImageFileInfo> linkedList = new LinkedList<>();
            linkedList.add(imageFileInfo);
            this.muN.getWriteImagesInfo().setChosedFiles(linkedList);
            intent.putExtra("album_result", this.muN.getWriteImagesInfo().toJsonString());
            intent.putExtra("camera_request_from", this.requestFrom);
            intent.putExtra("from_type", this.biW);
            this.muY.setResult(-1, intent);
            this.muY.finish();
        }
    }

    public c duD() {
        return this.muN;
    }

    public void g(TbPageContext tbPageContext) {
        PostPrefixData postPrefixData;
        AntiData antiData = null;
        if (!bIW() && com.baidu.tieba.write.j.duo()) {
            RecordVideoActivityConfig recordVideoActivityConfig = new RecordVideoActivityConfig(tbPageContext.getPageActivity(), this.biV ? 2 : 3, new ForumWriteData(this.forumId, this.forumName, null, null), this.muN.getWriteImagesInfo(), "", this.biW);
            recordVideoActivityConfig.setShowType(this.mvc ? 0 : 1);
            if (this.mvc) {
                String str = "";
                String str2 = "";
                if (this.muY.getIntent() != null) {
                    Serializable serializableExtra = this.muY.getIntent().getSerializableExtra("anti_data");
                    AntiData antiData2 = serializableExtra instanceof AntiData ? (AntiData) serializableExtra : null;
                    Serializable serializableExtra2 = this.muY.getIntent().getSerializableExtra("prefix_data");
                    PostPrefixData postPrefixData2 = serializableExtra2 instanceof PostPrefixData ? (PostPrefixData) serializableExtra2 : null;
                    antiData = antiData2;
                    str = this.muY.getIntent().getStringExtra("forum_first_dir");
                    postPrefixData = postPrefixData2;
                    str2 = this.muY.getIntent().getStringExtra("forum_second_dir");
                } else {
                    postPrefixData = null;
                }
                recordVideoActivityConfig.setExtraData(antiData, postPrefixData, str, str2);
            }
            this.muY.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, recordVideoActivityConfig));
            TiebaStatic.log(new ap(CommonStatisticKey.KEY_ENTRANCE_CLICKED).ah("obj_locate", 5).ah("obj_type", 2));
        }
    }

    private boolean bIW() {
        PermissionJudgePolicy permissionJudgePolicy = new PermissionJudgePolicy();
        permissionJudgePolicy.clearRequestPermissionList();
        permissionJudgePolicy.appendRequestPermission(this.muY, PermissionRequest.RESOURCE_VIDEO_CAPTURE);
        permissionJudgePolicy.appendRequestPermission(this.muY, PermissionRequest.RESOURCE_AUDIO_CAPTURE);
        permissionJudgePolicy.appendRequestPermission(this.muY, "android.permission.WRITE_EXTERNAL_STORAGE");
        return permissionJudgePolicy.startRequestPermission(this.muY);
    }

    public boolean f(ImageFileInfo imageFileInfo) {
        if (imageFileInfo == null) {
            return false;
        }
        this.muN.a(null);
        this.muN.delChooseFile(imageFileInfo);
        Iz();
        return true;
    }

    public boolean g(ImageFileInfo imageFileInfo) {
        if (imageFileInfo == null) {
            return false;
        }
        int maxImagesAllowed = this.muN.getMaxImagesAllowed();
        if (this.muN.size() < maxImagesAllowed) {
            if (this.mva == null || this.mva.h(imageFileInfo)) {
                ImageFileInfo imageFileInfo2 = new ImageFileInfo();
                imageFileInfo2.setAlbumnId(imageFileInfo.getAlbumId());
                imageFileInfo2.setContentUriStr(imageFileInfo.getContentUriStr());
                imageFileInfo2.setFilePath(imageFileInfo.getFilePath());
                imageFileInfo2.setModifyTime(imageFileInfo.getModifyTime());
                imageFileInfo2.setIsGif(imageFileInfo.isGif());
                imageFileInfo2.setIsLong(imageFileInfo.isLong());
                this.muN.a(null);
                this.muN.addChooseFile(imageFileInfo2);
                Iz();
                return true;
            }
            return false;
        } else if (ID()) {
            return g(imageFileInfo);
        } else {
            this.muY.showToast(String.format(this.muY.getString(R.string.max_choose_image_count), Integer.valueOf(maxImagesAllowed)));
            return false;
        }
    }

    private boolean ID() {
        if (this.muY.getIntent().getBooleanExtra("select_directly", false)) {
            int maxImagesAllowed = this.muN.getMaxImagesAllowed();
            if (this.muN.size() == maxImagesAllowed && maxImagesAllowed == 1) {
                try {
                    ImageFileInfo imageFileInfo = (ImageFileInfo) x.getItem(this.muN.IU(), 0);
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
        Fragment Ha;
        if (this.muZ != null && (Ha = this.muZ.Ha(0)) != null && (Ha instanceof ImageListFragment)) {
            ((ImageListFragment) Ha).f(imageFileInfo, z);
        }
    }

    private void h(ImageFileInfo imageFileInfo, boolean z) {
        Fragment Ha;
        if (this.muZ != null && (Ha = this.muZ.Ha(1)) != null && (Ha instanceof AlbumImageBrowseFragment)) {
            ((AlbumImageBrowseFragment) Ha).f(imageFileInfo, z);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void m(Intent intent) {
        this.mvg = intent;
        if (intent == null || this.muN == null) {
            l(null);
            return;
        }
        String stringExtra = intent.getStringExtra("album_result");
        if (stringExtra != null) {
            WriteImagesInfo writeImagesInfo = this.muN.getWriteImagesInfo();
            writeImagesInfo.parseJson(stringExtra);
            writeImagesInfo.updateQuality();
            l(intent);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void onBackClick() {
        this.muY.closeLoadingDialog();
        if (this.aMx == 0) {
            if (this.muN != null) {
                this.muN.setLastAlbumId(null);
            }
            IE();
        } else if (this.aMx == 1) {
            du(0);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int IB() {
        return this.biT;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean duE() {
        return this.mvc;
    }

    private void stopCamera() {
        if (this.muZ != null) {
            this.muZ.stopCamera();
        }
    }

    private void Rd() {
        if (this.muZ != null) {
            this.muZ.Rd();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void onStart() {
        if (this.mvb != null) {
            this.mvb.onStart();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void onResume() {
        Rd();
        if (this.mvb != null) {
            this.mvb.onResume();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void onStop() {
        if (this.mvb != null) {
            this.mvb.onStop();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void onPause() {
        stopCamera();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void onDestroy() {
        this.biR = true;
        stopCamera();
        this.muY.closeLoadingDialog();
        this.muY.dismissAllDialog();
        d.duA().destory();
        if (this.muZ != null) {
            this.muZ.onDestroy();
        }
        if (this.mvb != null) {
            this.mvb.onDestroy();
        }
        Intent intent = new Intent();
        intent.setAction(AlbumActivityConfig.ACTION_SELECT_IMAGE_RESULT);
        intent.putExtra("album_result", this.muN.getWriteImagesInfo().toJsonString());
        intent.putExtra("camera_request_from", this.requestFrom);
        intent.putExtra("from_type", this.biW);
        if (this.mvg != null && !StringUtils.isNull(this.mvg.getStringExtra("file_name"))) {
            intent.putExtra("file_name", this.mvg.getStringExtra("file_name"));
        }
        TbadkCoreApplication.getInst().sendBroadcast(intent);
    }

    public void onRequestPermissionsResult(int i, @NonNull String[] strArr, @NonNull int[] iArr) {
        if (this.muZ != null) {
            this.muZ.dux();
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
            new com.baidu.tbadk.img.f(null).c(e.this.muN.getWriteImagesInfo(), true);
            return e.this.muN.getWriteImagesInfo().toJsonString();
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPostExecute(String str) {
            Intent intent = new Intent();
            intent.putExtra("album_result", str);
            e.this.muY.setResult(-1, intent);
            e.this.muY.finish();
        }
    }
}
