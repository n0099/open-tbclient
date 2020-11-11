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
    private FrsTabInfoData nFC;
    private Intent nFE;
    private c nFl;
    private int nFu;
    private int nFv;
    private BaseFragmentActivity nFw;
    private com.baidu.tieba.write.album.a nFx;
    private f nFy;
    private j nFz;
    private int aZN = 0;
    private boolean bDV = false;
    private String callFrom = "";
    private String from = "";
    private String forumName = "";
    private String forumId = "0";
    private int requestFrom = 0;
    private int bDX = 0;
    private boolean nFA = false;
    private boolean nFB = true;
    private boolean bDY = false;
    private boolean bDZ = false;
    private int bEa = 0;
    private int nFD = -1;
    private PostPrefixData prefixData = null;
    private AntiData antiData = null;
    private String firstDir = "";
    private String secondDir = "";

    public e(BaseFragmentActivity baseFragmentActivity, Bundle bundle, int i, int i2) {
        a(baseFragmentActivity, i, i2);
        if (bundle == null) {
            an(this.nFw.getIntent());
        } else {
            initData(bundle);
        }
        dD(0, this.nFu);
    }

    private void a(BaseFragmentActivity baseFragmentActivity, int i, int i2) {
        this.nFw = baseFragmentActivity;
        this.nFu = i;
        this.nFv = i2;
        this.nFx = new com.baidu.tieba.write.album.a(baseFragmentActivity.getPageContext(), this);
        this.nFx.TM();
    }

    private void initData(Bundle bundle) {
        this.nFl = new c(this.nFw.getPageContext());
        if (bundle != null) {
            WriteImagesInfo writeImagesInfo = new WriteImagesInfo();
            writeImagesInfo.parseJson(bundle.getString("write_images_info"));
            this.nFl.setWriteImagesInfo(writeImagesInfo);
            this.bDY = bundle.getBoolean("use_original_img", false);
            this.requestFrom = bundle.getInt("camera_request_from", 0);
            this.forumId = bundle.getString("forum_id");
            this.forumName = bundle.getString("forum_name");
            this.bDX = bundle.getInt("album_thread");
            this.nFA = bundle.getBoolean(IntentConfig.KEY_CAN_SELECT_VIDEO);
            this.bDZ = bundle.getBoolean("from_write");
            this.callFrom = bundle.getString("KEY_CALL_FROM");
            this.bEa = bundle.getInt("from_type");
            this.nFC = (FrsTabInfoData) bundle.getSerializable("tab_list");
            this.from = bundle.getString("from");
            this.nFD = bundle.getInt(WriteActivityConfig.KEY_PROFESSION_ZONE, -1);
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
        TA();
    }

    private void an(Intent intent) {
        this.nFl = new c(this.nFw.getPageContext());
        if (intent != null) {
            WriteImagesInfo writeImagesInfo = new WriteImagesInfo();
            writeImagesInfo.parseJson(intent.getStringExtra("write_images_info"));
            this.nFl.setWriteImagesInfo(writeImagesInfo);
            this.nFl.setOriginalImg(writeImagesInfo.isOriginalImg());
            this.bDY = intent.getBooleanExtra("use_original_img", false);
            this.requestFrom = intent.getIntExtra("camera_request_from", 0);
            this.from = intent.getStringExtra("from");
            this.forumId = intent.getStringExtra("forum_id");
            this.forumName = intent.getStringExtra("forum_name");
            this.bDX = intent.getIntExtra("album_thread", 0);
            this.nFA = intent.getBooleanExtra(IntentConfig.KEY_CAN_SELECT_VIDEO, false);
            this.nFB = intent.getBooleanExtra(IntentConfig.KEY_CAN_EDIT_IMAGE, true);
            this.bDZ = intent.getBooleanExtra("from_write", false);
            this.callFrom = intent.getStringExtra("KEY_CALL_FROM");
            this.bEa = intent.getIntExtra("from_type", 0);
            this.nFC = (FrsTabInfoData) intent.getSerializableExtra("tab_list");
            this.nFD = intent.getIntExtra(WriteActivityConfig.KEY_PROFESSION_ZONE, -1);
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
        TA();
    }

    private void TA() {
        if (this.requestFrom == 2) {
            this.nFy = new f() { // from class: com.baidu.tieba.write.album.e.1
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
                    BdToast.a((Context) e.this.nFw, (CharSequence) e.this.nFw.getString(R.string.uploade_attation), R.drawable.icon_toast_game_error, false).bpi();
                    return false;
                }
            };
        }
    }

    public void a(NavigationBar navigationBar) {
        if (navigationBar != null) {
            this.nFx.a(navigationBar);
        }
    }

    public void fW(int i) {
        if (i == 1) {
            dD(i, this.nFv);
        } else {
            dD(i, this.nFu);
        }
    }

    private void dD(int i, int i2) {
        if (!this.bDV) {
            FragmentTransaction beginTransaction = this.nFw.getSupportFragmentManager().beginTransaction();
            Fragment findFragmentByTag = this.nFw.getSupportFragmentManager().findFragmentByTag(this.nFx.Ln(this.aZN));
            if (findFragmentByTag != null) {
                beginTransaction.hide(findFragmentByTag);
            }
            this.aZN = i;
            if (this.nFw.getSupportFragmentManager().findFragmentByTag(this.nFx.Ln(i)) != null) {
                beginTransaction.show(this.nFx.Lm(i));
            } else {
                beginTransaction.add(i2, this.nFx.Lm(i), this.nFx.Ln(i));
            }
            beginTransaction.commitAllowingStateLoss();
            this.nFw.getSupportFragmentManager().executePendingTransactions();
        }
    }

    public void TB() {
        if (this.requestFrom == 3) {
            TiebaStatic.log(TbadkCoreStatisticKey.UPGRADE_DIALOG_CHOOSE_IMAGE);
        }
        if (this.requestFrom == 5) {
            this.nFw.showLoadingDialog("正在上传");
            new a().execute(new String[0]);
        } else if (this.nFl != null) {
            if (this.nFz == null || !this.nFz.dTF()) {
                if (this.nFl.TW()) {
                    VideoFileInfo dTt = this.nFl.dTt();
                    if (this.nFz == null) {
                        this.nFz = new j(this.nFw, this.forumName, this.forumId, "");
                        this.nFz.b(this.nFC);
                        this.nFz.setExtraData(this.antiData, this.prefixData, this.firstDir, this.secondDir);
                        if (this.nFx != null) {
                            this.nFx.a(this.nFz);
                        }
                    }
                    this.nFz.setProfessionZone(this.nFD);
                    this.nFz.a(dTt, this.callFrom, this.from);
                } else if (this.nFB && dTv()) {
                    TC();
                } else {
                    n(null);
                }
            }
        }
    }

    private boolean dTv() {
        if (this.nFl == null || y.getCount(this.nFl.TY()) == 0) {
            return false;
        }
        int i = 0;
        for (ImageFileInfo imageFileInfo : this.nFl.TY()) {
            if (imageFileInfo != null && imageFileInfo.getImageType() == 0 && (i = i + 1) >= 2) {
                return false;
            }
            i = i;
        }
        return i == 1;
    }

    private void TC() {
        WriteImagesInfo writeImagesInfo;
        if (this.nFl != null && (writeImagesInfo = this.nFl.getWriteImagesInfo()) != null) {
            this.nFw.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new WriteMulitImageActivityConfig(this.nFw, RequestResponseCode.REQUEST_MOTU_IMAGE, writeImagesInfo, dTw())));
        }
    }

    private int dTw() {
        if (this.nFl == null || y.getCount(this.nFl.TY()) == 0) {
            return 0;
        }
        for (int i = 0; i < y.getCount(this.nFl.TY()); i++) {
            ImageFileInfo imageFileInfo = this.nFl.TY().get(i);
            if (imageFileInfo != null && imageFileInfo.getImageType() == 0) {
                return i;
            }
        }
        return 0;
    }

    private void n(Intent intent) {
        Intent intent2 = new Intent();
        intent2.putExtra("album_result", this.nFl.getWriteImagesInfo().toJsonString());
        intent2.putExtra("camera_request_from", this.requestFrom);
        intent2.putExtra("from_type", this.bEa);
        if (intent != null && !StringUtils.isNull(intent.getStringExtra("file_name"))) {
            intent2.putExtra("file_name", intent.getStringExtra("file_name"));
        }
        this.nFw.setResult(-1, intent2);
        this.nFw.finish();
        if (AlbumActivityConfig.FROM_FLUTTER.equals(this.from)) {
            MessageManager.getInstance().sendMessage(new CustomMessage(2921464, intent2));
        }
    }

    @Override // com.baidu.tbadk.suspended.a
    public boolean bCR() {
        if (this.nFx == null || this.nFx.dTs() == null || this.nFx.dTs().dTB() == null) {
            return true;
        }
        return this.nFx.dTs().dTB().getFirstVisiblePosition() == 0 && !this.nFx.dTs().dTB().canScrollVertically(-1);
    }

    @Override // com.baidu.tbadk.suspended.a
    public boolean bCS() {
        return true;
    }

    @Override // com.baidu.tbadk.suspended.a
    public void rO(int i) {
        if (this.nFx != null) {
            this.nFx.onChangeSkinType(i);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void onSaveInstanceState(Bundle bundle) {
        bundle.putString("write_images_info", this.nFl.getWriteImagesInfo().toJsonString());
        bundle.putBoolean("use_original_img", this.bDY);
        bundle.putInt("camera_request_from", this.requestFrom);
        bundle.putString("forum_id", this.forumId);
        bundle.putString("forum_name", this.forumName);
        bundle.putInt("album_thread", this.bDX);
        bundle.putBoolean(IntentConfig.KEY_CAN_SELECT_VIDEO, this.nFA);
        bundle.putBoolean("from_write", this.bDZ);
        bundle.putSerializable("tab_list", this.nFC);
        bundle.putSerializable("anti_data", this.antiData);
        bundle.putSerializable("prefix_data", this.prefixData);
        bundle.putString("forum_first_dir", this.firstDir);
        bundle.putString("forum_second_dir", this.secondDir);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.nFx.TO()) {
            TB();
        } else if (view == this.nFx.TQ()) {
            TB();
        } else if (view == this.nFx.TN()) {
            if (this.nFl != null) {
                this.nFl.setLastAlbumId(null);
            }
            TI();
        } else if (view == this.nFx.TP()) {
            dD(0, this.nFu);
        } else if (view == this.nFx.TR()) {
            fU(2);
        } else if (view == this.nFx.TS()) {
            fU(1);
        }
    }

    private void TI() {
        Intent intent = new Intent();
        String lastAlbumId = this.nFl.getLastAlbumId();
        if (TextUtils.isEmpty(lastAlbumId)) {
            lastAlbumId = "";
        }
        intent.putExtra("last_album_id", lastAlbumId);
        intent.putExtra("camera_request_from", this.requestFrom);
        this.nFw.setResult(0, intent);
        this.nFw.finish();
    }

    private void fU(int i) {
        if (this.nFx != null && this.nFl != null) {
            this.nFl.setOriginalImg(!this.nFl.isOriginalImg());
            TD();
            fV(i);
        }
    }

    public void TD() {
        if (this.nFl != null && this.nFx != null) {
            this.nFx.cQ(this.nFl.isOriginalImg());
        }
    }

    private void fV(int i) {
        if (this.nFl != null && this.nFl.isOriginalImg() && !StringUtils.isNull(this.from, true) && !StringUtils.isNull(this.forumId, true)) {
            TiebaStatic.log(new aq("c10349").dR("fid", this.forumId).dR("obj_type", this.from).al("obj_locate", i));
        }
    }

    @Override // com.baidu.tbadk.suspended.a
    public Intent bCT() {
        return null;
    }

    public void e(ImageFileInfo imageFileInfo) {
        if (imageFileInfo != null) {
            Intent intent = new Intent();
            LinkedList<ImageFileInfo> linkedList = new LinkedList<>();
            linkedList.add(imageFileInfo);
            this.nFl.getWriteImagesInfo().setChosedFiles(linkedList);
            intent.putExtra("album_result", this.nFl.getWriteImagesInfo().toJsonString());
            intent.putExtra("camera_request_from", this.requestFrom);
            intent.putExtra("from_type", this.bEa);
            this.nFw.setResult(-1, intent);
            this.nFw.finish();
        }
    }

    public c dTx() {
        return this.nFl;
    }

    public void g(TbPageContext tbPageContext) {
        PostPrefixData postPrefixData;
        AntiData antiData = null;
        if (!cdE() && com.baidu.tieba.write.j.dTi()) {
            RecordVideoActivityConfig recordVideoActivityConfig = new RecordVideoActivityConfig(tbPageContext.getPageActivity(), this.bDZ ? 2 : 3, new ForumWriteData(this.forumId, this.forumName, null, null), this.nFl.getWriteImagesInfo(), "", this.bEa);
            recordVideoActivityConfig.setShowType(this.nFA ? 0 : 1);
            if (this.nFA) {
                String str = "";
                String str2 = "";
                if (this.nFw.getIntent() != null) {
                    Serializable serializableExtra = this.nFw.getIntent().getSerializableExtra("anti_data");
                    AntiData antiData2 = serializableExtra instanceof AntiData ? (AntiData) serializableExtra : null;
                    Serializable serializableExtra2 = this.nFw.getIntent().getSerializableExtra("prefix_data");
                    PostPrefixData postPrefixData2 = serializableExtra2 instanceof PostPrefixData ? (PostPrefixData) serializableExtra2 : null;
                    antiData = antiData2;
                    str = this.nFw.getIntent().getStringExtra("forum_first_dir");
                    postPrefixData = postPrefixData2;
                    str2 = this.nFw.getIntent().getStringExtra("forum_second_dir");
                } else {
                    postPrefixData = null;
                }
                recordVideoActivityConfig.setExtraData(antiData, postPrefixData, str, str2);
            }
            this.nFw.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, recordVideoActivityConfig));
            TiebaStatic.log(new aq(CommonStatisticKey.KEY_ENTRANCE_CLICKED).al("obj_locate", 5).al("obj_type", 2));
        }
    }

    private boolean cdE() {
        PermissionJudgePolicy permissionJudgePolicy = new PermissionJudgePolicy();
        permissionJudgePolicy.clearRequestPermissionList();
        permissionJudgePolicy.appendRequestPermission(this.nFw, PermissionRequest.RESOURCE_VIDEO_CAPTURE);
        permissionJudgePolicy.appendRequestPermission(this.nFw, PermissionRequest.RESOURCE_AUDIO_CAPTURE);
        permissionJudgePolicy.appendRequestPermission(this.nFw, "android.permission.WRITE_EXTERNAL_STORAGE");
        return permissionJudgePolicy.startRequestPermission(this.nFw);
    }

    public boolean f(ImageFileInfo imageFileInfo) {
        if (imageFileInfo == null) {
            return false;
        }
        this.nFl.a(null);
        this.nFl.delChooseFile(imageFileInfo);
        TD();
        return true;
    }

    public boolean g(ImageFileInfo imageFileInfo) {
        if (imageFileInfo == null) {
            return false;
        }
        int maxImagesAllowed = this.nFl.getMaxImagesAllowed();
        if (this.nFl.size() < maxImagesAllowed) {
            if (this.nFy == null || this.nFy.h(imageFileInfo)) {
                ImageFileInfo imageFileInfo2 = new ImageFileInfo();
                imageFileInfo2.setAlbumnId(imageFileInfo.getAlbumId());
                imageFileInfo2.setContentUriStr(imageFileInfo.getContentUriStr());
                imageFileInfo2.setFilePath(imageFileInfo.getFilePath());
                imageFileInfo2.setModifyTime(imageFileInfo.getModifyTime());
                imageFileInfo2.setIsGif(imageFileInfo.isGif());
                imageFileInfo2.setIsLong(imageFileInfo.isLong());
                this.nFl.a(null);
                this.nFl.addChooseFile(imageFileInfo2);
                TD();
                return true;
            }
            return false;
        } else if (TH()) {
            return g(imageFileInfo);
        } else {
            this.nFw.showToast(String.format(this.nFw.getString(R.string.max_choose_image_count), Integer.valueOf(maxImagesAllowed)));
            return false;
        }
    }

    private boolean TH() {
        if (this.nFw.getIntent().getBooleanExtra("select_directly", false)) {
            int maxImagesAllowed = this.nFl.getMaxImagesAllowed();
            if (this.nFl.size() == maxImagesAllowed && maxImagesAllowed == 1) {
                try {
                    ImageFileInfo imageFileInfo = (ImageFileInfo) y.getItem(this.nFl.TY(), 0);
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
        Fragment Lm;
        if (this.nFx != null && (Lm = this.nFx.Lm(0)) != null && (Lm instanceof ImageListFragment)) {
            ((ImageListFragment) Lm).f(imageFileInfo, z);
        }
    }

    private void h(ImageFileInfo imageFileInfo, boolean z) {
        Fragment Lm;
        if (this.nFx != null && (Lm = this.nFx.Lm(1)) != null && (Lm instanceof AlbumImageBrowseFragment)) {
            ((AlbumImageBrowseFragment) Lm).f(imageFileInfo, z);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void o(Intent intent) {
        this.nFE = intent;
        if (intent == null || this.nFl == null) {
            n(null);
            return;
        }
        String stringExtra = intent.getStringExtra("album_result");
        if (stringExtra != null) {
            WriteImagesInfo writeImagesInfo = this.nFl.getWriteImagesInfo();
            writeImagesInfo.parseJson(stringExtra);
            writeImagesInfo.updateQuality();
            n(intent);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void onBackClick() {
        this.nFw.closeLoadingDialog();
        if (this.aZN == 0) {
            if (this.nFl != null) {
                this.nFl.setLastAlbumId(null);
            }
            TI();
        } else if (this.aZN == 1) {
            fW(0);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int TF() {
        return this.bDX;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean dTy() {
        return this.nFA;
    }

    private void stopCamera() {
        if (this.nFx != null) {
            this.nFx.stopCamera();
        }
    }

    private void openCamera() {
        if (this.nFx != null) {
            this.nFx.openCamera();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void onStart() {
        if (this.nFz != null) {
            this.nFz.onStart();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void onResume() {
        openCamera();
        if (this.nFz != null) {
            this.nFz.onResume();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void onStop() {
        if (this.nFz != null) {
            this.nFz.onStop();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void onPause() {
        stopCamera();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void onDestroy() {
        this.bDV = true;
        stopCamera();
        this.nFw.closeLoadingDialog();
        this.nFw.dismissAllDialog();
        d.dTu().destory();
        if (this.nFx != null) {
            this.nFx.onDestroy();
        }
        if (this.nFz != null) {
            this.nFz.onDestroy();
        }
        Intent intent = new Intent();
        intent.setAction(AlbumActivityConfig.ACTION_SELECT_IMAGE_RESULT);
        intent.putExtra("album_result", this.nFl.getWriteImagesInfo().toJsonString());
        intent.putExtra("camera_request_from", this.requestFrom);
        intent.putExtra("from_type", this.bEa);
        if (this.nFE != null && !StringUtils.isNull(this.nFE.getStringExtra("file_name"))) {
            intent.putExtra("file_name", this.nFE.getStringExtra("file_name"));
        }
        TbadkCoreApplication.getInst().sendBroadcast(intent);
    }

    public void onRequestPermissionsResult(int i, @NonNull String[] strArr, @NonNull int[] iArr) {
        if (this.nFx != null) {
            this.nFx.dTr();
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
            new com.baidu.tbadk.img.f(null).c(e.this.nFl.getWriteImagesInfo(), true);
            return e.this.nFl.getWriteImagesInfo().toJsonString();
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPostExecute(String str) {
            Intent intent = new Intent();
            intent.putExtra("album_result", str);
            e.this.nFw.setResult(-1, intent);
            e.this.nFw.finish();
        }
    }
}
