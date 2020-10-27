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
    private int nzA;
    private int nzB;
    private BaseFragmentActivity nzC;
    private com.baidu.tieba.write.album.a nzD;
    private f nzE;
    private j nzF;
    private FrsTabInfoData nzI;
    private Intent nzK;
    private c nzr;
    private int aYv = 0;
    private boolean bxK = false;
    private String callFrom = "";
    private String from = "";
    private String forumName = "";
    private String forumId = "0";
    private int requestFrom = 0;
    private int bxM = 0;
    private boolean nzG = false;
    private boolean nzH = true;
    private boolean bxN = false;
    private boolean bxO = false;
    private int bxP = 0;
    private int nzJ = -1;
    private PostPrefixData prefixData = null;
    private AntiData antiData = null;
    private String firstDir = "";
    private String secondDir = "";

    public e(BaseFragmentActivity baseFragmentActivity, Bundle bundle, int i, int i2) {
        a(baseFragmentActivity, i, i2);
        if (bundle == null) {
            an(this.nzC.getIntent());
        } else {
            initData(bundle);
        }
        dB(0, this.nzA);
    }

    private void a(BaseFragmentActivity baseFragmentActivity, int i, int i2) {
        this.nzC = baseFragmentActivity;
        this.nzA = i;
        this.nzB = i2;
        this.nzD = new com.baidu.tieba.write.album.a(baseFragmentActivity.getPageContext(), this);
        this.nzD.Re();
    }

    private void initData(Bundle bundle) {
        this.nzr = new c(this.nzC.getPageContext());
        if (bundle != null) {
            WriteImagesInfo writeImagesInfo = new WriteImagesInfo();
            writeImagesInfo.parseJson(bundle.getString("write_images_info"));
            this.nzr.setWriteImagesInfo(writeImagesInfo);
            this.bxN = bundle.getBoolean("use_original_img", false);
            this.requestFrom = bundle.getInt("camera_request_from", 0);
            this.forumId = bundle.getString("forum_id");
            this.forumName = bundle.getString("forum_name");
            this.bxM = bundle.getInt("album_thread");
            this.nzG = bundle.getBoolean(IntentConfig.KEY_CAN_SELECT_VIDEO);
            this.bxO = bundle.getBoolean("from_write");
            this.callFrom = bundle.getString("KEY_CALL_FROM");
            this.bxP = bundle.getInt("from_type");
            this.nzI = (FrsTabInfoData) bundle.getSerializable("tab_list");
            this.from = bundle.getString("from");
            this.nzJ = bundle.getInt(WriteActivityConfig.KEY_PROFESSION_ZONE, -1);
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
        QS();
    }

    private void an(Intent intent) {
        this.nzr = new c(this.nzC.getPageContext());
        if (intent != null) {
            WriteImagesInfo writeImagesInfo = new WriteImagesInfo();
            writeImagesInfo.parseJson(intent.getStringExtra("write_images_info"));
            this.nzr.setWriteImagesInfo(writeImagesInfo);
            this.nzr.setOriginalImg(writeImagesInfo.isOriginalImg());
            this.bxN = intent.getBooleanExtra("use_original_img", false);
            this.requestFrom = intent.getIntExtra("camera_request_from", 0);
            this.from = intent.getStringExtra("from");
            this.forumId = intent.getStringExtra("forum_id");
            this.forumName = intent.getStringExtra("forum_name");
            this.bxM = intent.getIntExtra("album_thread", 0);
            this.nzG = intent.getBooleanExtra(IntentConfig.KEY_CAN_SELECT_VIDEO, false);
            this.nzH = intent.getBooleanExtra(IntentConfig.KEY_CAN_EDIT_IMAGE, true);
            this.bxO = intent.getBooleanExtra("from_write", false);
            this.callFrom = intent.getStringExtra("KEY_CALL_FROM");
            this.bxP = intent.getIntExtra("from_type", 0);
            this.nzI = (FrsTabInfoData) intent.getSerializableExtra("tab_list");
            this.nzJ = intent.getIntExtra(WriteActivityConfig.KEY_PROFESSION_ZONE, -1);
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
        QS();
    }

    private void QS() {
        if (this.requestFrom == 2) {
            this.nzE = new f() { // from class: com.baidu.tieba.write.album.e.1
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
                    BdToast.a((Context) e.this.nzC, (CharSequence) e.this.nzC.getString(R.string.uploade_attation), R.drawable.icon_toast_game_error, false).bmI();
                    return false;
                }
            };
        }
    }

    public void a(NavigationBar navigationBar) {
        if (navigationBar != null) {
            this.nzD.a(navigationBar);
        }
    }

    public void fJ(int i) {
        if (i == 1) {
            dB(i, this.nzB);
        } else {
            dB(i, this.nzA);
        }
    }

    private void dB(int i, int i2) {
        if (!this.bxK) {
            FragmentTransaction beginTransaction = this.nzC.getSupportFragmentManager().beginTransaction();
            Fragment findFragmentByTag = this.nzC.getSupportFragmentManager().findFragmentByTag(this.nzD.La(this.aYv));
            if (findFragmentByTag != null) {
                beginTransaction.hide(findFragmentByTag);
            }
            this.aYv = i;
            if (this.nzC.getSupportFragmentManager().findFragmentByTag(this.nzD.La(i)) != null) {
                beginTransaction.show(this.nzD.KZ(i));
            } else {
                beginTransaction.add(i2, this.nzD.KZ(i), this.nzD.La(i));
            }
            beginTransaction.commitAllowingStateLoss();
            this.nzC.getSupportFragmentManager().executePendingTransactions();
        }
    }

    public void QT() {
        if (this.requestFrom == 3) {
            TiebaStatic.log(TbadkCoreStatisticKey.UPGRADE_DIALOG_CHOOSE_IMAGE);
        }
        if (this.requestFrom == 5) {
            this.nzC.showLoadingDialog("正在上传");
            new a().execute(new String[0]);
        } else if (this.nzr != null) {
            if (this.nzF == null || !this.nzF.dRf()) {
                if (this.nzr.Ro()) {
                    VideoFileInfo dQT = this.nzr.dQT();
                    if (this.nzF == null) {
                        this.nzF = new j(this.nzC, this.forumName, this.forumId, "");
                        this.nzF.b(this.nzI);
                        this.nzF.setExtraData(this.antiData, this.prefixData, this.firstDir, this.secondDir);
                        if (this.nzD != null) {
                            this.nzD.a(this.nzF);
                        }
                    }
                    this.nzF.setProfessionZone(this.nzJ);
                    this.nzF.a(dQT, this.callFrom, this.from);
                } else if (this.nzH && dQV()) {
                    QU();
                } else {
                    n(null);
                }
            }
        }
    }

    private boolean dQV() {
        if (this.nzr == null || y.getCount(this.nzr.Rq()) == 0) {
            return false;
        }
        int i = 0;
        for (ImageFileInfo imageFileInfo : this.nzr.Rq()) {
            if (imageFileInfo != null && imageFileInfo.getImageType() == 0 && (i = i + 1) >= 2) {
                return false;
            }
            i = i;
        }
        return i == 1;
    }

    private void QU() {
        WriteImagesInfo writeImagesInfo;
        if (this.nzr != null && (writeImagesInfo = this.nzr.getWriteImagesInfo()) != null) {
            this.nzC.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new WriteMulitImageActivityConfig(this.nzC, RequestResponseCode.REQUEST_MOTU_IMAGE, writeImagesInfo, dQW())));
        }
    }

    private int dQW() {
        if (this.nzr == null || y.getCount(this.nzr.Rq()) == 0) {
            return 0;
        }
        for (int i = 0; i < y.getCount(this.nzr.Rq()); i++) {
            ImageFileInfo imageFileInfo = this.nzr.Rq().get(i);
            if (imageFileInfo != null && imageFileInfo.getImageType() == 0) {
                return i;
            }
        }
        return 0;
    }

    private void n(Intent intent) {
        Intent intent2 = new Intent();
        intent2.putExtra("album_result", this.nzr.getWriteImagesInfo().toJsonString());
        intent2.putExtra("camera_request_from", this.requestFrom);
        intent2.putExtra("from_type", this.bxP);
        if (intent != null && !StringUtils.isNull(intent.getStringExtra("file_name"))) {
            intent2.putExtra("file_name", intent.getStringExtra("file_name"));
        }
        this.nzC.setResult(-1, intent2);
        this.nzC.finish();
        if (AlbumActivityConfig.FROM_FLUTTER.equals(this.from)) {
            MessageManager.getInstance().sendMessage(new CustomMessage(2921464, intent2));
        }
    }

    @Override // com.baidu.tbadk.suspended.a
    public boolean bAs() {
        if (this.nzD == null || this.nzD.dQS() == null || this.nzD.dQS().dRb() == null) {
            return true;
        }
        return this.nzD.dQS().dRb().getFirstVisiblePosition() == 0 && !this.nzD.dQS().dRb().canScrollVertically(-1);
    }

    @Override // com.baidu.tbadk.suspended.a
    public boolean bAt() {
        return true;
    }

    @Override // com.baidu.tbadk.suspended.a
    public void rE(int i) {
        if (this.nzD != null) {
            this.nzD.onChangeSkinType(i);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void onSaveInstanceState(Bundle bundle) {
        bundle.putString("write_images_info", this.nzr.getWriteImagesInfo().toJsonString());
        bundle.putBoolean("use_original_img", this.bxN);
        bundle.putInt("camera_request_from", this.requestFrom);
        bundle.putString("forum_id", this.forumId);
        bundle.putString("forum_name", this.forumName);
        bundle.putInt("album_thread", this.bxM);
        bundle.putBoolean(IntentConfig.KEY_CAN_SELECT_VIDEO, this.nzG);
        bundle.putBoolean("from_write", this.bxO);
        bundle.putSerializable("tab_list", this.nzI);
        bundle.putSerializable("anti_data", this.antiData);
        bundle.putSerializable("prefix_data", this.prefixData);
        bundle.putString("forum_first_dir", this.firstDir);
        bundle.putString("forum_second_dir", this.secondDir);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.nzD.Rg()) {
            QT();
        } else if (view == this.nzD.Ri()) {
            QT();
        } else if (view == this.nzD.Rf()) {
            if (this.nzr != null) {
                this.nzr.setLastAlbumId(null);
            }
            Ra();
        } else if (view == this.nzD.Rh()) {
            dB(0, this.nzA);
        } else if (view == this.nzD.Rj()) {
            fH(2);
        } else if (view == this.nzD.Rk()) {
            fH(1);
        }
    }

    private void Ra() {
        Intent intent = new Intent();
        String lastAlbumId = this.nzr.getLastAlbumId();
        if (TextUtils.isEmpty(lastAlbumId)) {
            lastAlbumId = "";
        }
        intent.putExtra("last_album_id", lastAlbumId);
        intent.putExtra("camera_request_from", this.requestFrom);
        this.nzC.setResult(0, intent);
        this.nzC.finish();
    }

    private void fH(int i) {
        if (this.nzD != null && this.nzr != null) {
            this.nzr.setOriginalImg(!this.nzr.isOriginalImg());
            QV();
            fI(i);
        }
    }

    public void QV() {
        if (this.nzr != null && this.nzD != null) {
            this.nzD.cJ(this.nzr.isOriginalImg());
        }
    }

    private void fI(int i) {
        if (this.nzr != null && this.nzr.isOriginalImg() && !StringUtils.isNull(this.from, true) && !StringUtils.isNull(this.forumId, true)) {
            TiebaStatic.log(new aq("c10349").dR("fid", this.forumId).dR("obj_type", this.from).aj("obj_locate", i));
        }
    }

    @Override // com.baidu.tbadk.suspended.a
    public Intent bAu() {
        return null;
    }

    public void e(ImageFileInfo imageFileInfo) {
        if (imageFileInfo != null) {
            Intent intent = new Intent();
            LinkedList<ImageFileInfo> linkedList = new LinkedList<>();
            linkedList.add(imageFileInfo);
            this.nzr.getWriteImagesInfo().setChosedFiles(linkedList);
            intent.putExtra("album_result", this.nzr.getWriteImagesInfo().toJsonString());
            intent.putExtra("camera_request_from", this.requestFrom);
            intent.putExtra("from_type", this.bxP);
            this.nzC.setResult(-1, intent);
            this.nzC.finish();
        }
    }

    public c dQX() {
        return this.nzr;
    }

    public void g(TbPageContext tbPageContext) {
        PostPrefixData postPrefixData;
        AntiData antiData = null;
        if (!cbd() && com.baidu.tieba.write.j.dQI()) {
            RecordVideoActivityConfig recordVideoActivityConfig = new RecordVideoActivityConfig(tbPageContext.getPageActivity(), this.bxO ? 2 : 3, new ForumWriteData(this.forumId, this.forumName, null, null), this.nzr.getWriteImagesInfo(), "", this.bxP);
            recordVideoActivityConfig.setShowType(this.nzG ? 0 : 1);
            if (this.nzG) {
                String str = "";
                String str2 = "";
                if (this.nzC.getIntent() != null) {
                    Serializable serializableExtra = this.nzC.getIntent().getSerializableExtra("anti_data");
                    AntiData antiData2 = serializableExtra instanceof AntiData ? (AntiData) serializableExtra : null;
                    Serializable serializableExtra2 = this.nzC.getIntent().getSerializableExtra("prefix_data");
                    PostPrefixData postPrefixData2 = serializableExtra2 instanceof PostPrefixData ? (PostPrefixData) serializableExtra2 : null;
                    antiData = antiData2;
                    str = this.nzC.getIntent().getStringExtra("forum_first_dir");
                    postPrefixData = postPrefixData2;
                    str2 = this.nzC.getIntent().getStringExtra("forum_second_dir");
                } else {
                    postPrefixData = null;
                }
                recordVideoActivityConfig.setExtraData(antiData, postPrefixData, str, str2);
            }
            this.nzC.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, recordVideoActivityConfig));
            TiebaStatic.log(new aq(CommonStatisticKey.KEY_ENTRANCE_CLICKED).aj("obj_locate", 5).aj("obj_type", 2));
        }
    }

    private boolean cbd() {
        PermissionJudgePolicy permissionJudgePolicy = new PermissionJudgePolicy();
        permissionJudgePolicy.clearRequestPermissionList();
        permissionJudgePolicy.appendRequestPermission(this.nzC, PermissionRequest.RESOURCE_VIDEO_CAPTURE);
        permissionJudgePolicy.appendRequestPermission(this.nzC, PermissionRequest.RESOURCE_AUDIO_CAPTURE);
        permissionJudgePolicy.appendRequestPermission(this.nzC, "android.permission.WRITE_EXTERNAL_STORAGE");
        return permissionJudgePolicy.startRequestPermission(this.nzC);
    }

    public boolean f(ImageFileInfo imageFileInfo) {
        if (imageFileInfo == null) {
            return false;
        }
        this.nzr.a(null);
        this.nzr.delChooseFile(imageFileInfo);
        QV();
        return true;
    }

    public boolean g(ImageFileInfo imageFileInfo) {
        if (imageFileInfo == null) {
            return false;
        }
        int maxImagesAllowed = this.nzr.getMaxImagesAllowed();
        if (this.nzr.size() < maxImagesAllowed) {
            if (this.nzE == null || this.nzE.h(imageFileInfo)) {
                ImageFileInfo imageFileInfo2 = new ImageFileInfo();
                imageFileInfo2.setAlbumnId(imageFileInfo.getAlbumId());
                imageFileInfo2.setContentUriStr(imageFileInfo.getContentUriStr());
                imageFileInfo2.setFilePath(imageFileInfo.getFilePath());
                imageFileInfo2.setModifyTime(imageFileInfo.getModifyTime());
                imageFileInfo2.setIsGif(imageFileInfo.isGif());
                imageFileInfo2.setIsLong(imageFileInfo.isLong());
                this.nzr.a(null);
                this.nzr.addChooseFile(imageFileInfo2);
                QV();
                return true;
            }
            return false;
        } else if (QZ()) {
            return g(imageFileInfo);
        } else {
            this.nzC.showToast(String.format(this.nzC.getString(R.string.max_choose_image_count), Integer.valueOf(maxImagesAllowed)));
            return false;
        }
    }

    private boolean QZ() {
        if (this.nzC.getIntent().getBooleanExtra("select_directly", false)) {
            int maxImagesAllowed = this.nzr.getMaxImagesAllowed();
            if (this.nzr.size() == maxImagesAllowed && maxImagesAllowed == 1) {
                try {
                    ImageFileInfo imageFileInfo = (ImageFileInfo) y.getItem(this.nzr.Rq(), 0);
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
        Fragment KZ;
        if (this.nzD != null && (KZ = this.nzD.KZ(0)) != null && (KZ instanceof ImageListFragment)) {
            ((ImageListFragment) KZ).f(imageFileInfo, z);
        }
    }

    private void h(ImageFileInfo imageFileInfo, boolean z) {
        Fragment KZ;
        if (this.nzD != null && (KZ = this.nzD.KZ(1)) != null && (KZ instanceof AlbumImageBrowseFragment)) {
            ((AlbumImageBrowseFragment) KZ).f(imageFileInfo, z);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void o(Intent intent) {
        this.nzK = intent;
        if (intent == null || this.nzr == null) {
            n(null);
            return;
        }
        String stringExtra = intent.getStringExtra("album_result");
        if (stringExtra != null) {
            WriteImagesInfo writeImagesInfo = this.nzr.getWriteImagesInfo();
            writeImagesInfo.parseJson(stringExtra);
            writeImagesInfo.updateQuality();
            n(intent);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void onBackClick() {
        this.nzC.closeLoadingDialog();
        if (this.aYv == 0) {
            if (this.nzr != null) {
                this.nzr.setLastAlbumId(null);
            }
            Ra();
        } else if (this.aYv == 1) {
            fJ(0);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int QX() {
        return this.bxM;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean dQY() {
        return this.nzG;
    }

    private void stopCamera() {
        if (this.nzD != null) {
            this.nzD.stopCamera();
        }
    }

    private void openCamera() {
        if (this.nzD != null) {
            this.nzD.openCamera();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void onStart() {
        if (this.nzF != null) {
            this.nzF.onStart();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void onResume() {
        openCamera();
        if (this.nzF != null) {
            this.nzF.onResume();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void onStop() {
        if (this.nzF != null) {
            this.nzF.onStop();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void onPause() {
        stopCamera();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void onDestroy() {
        this.bxK = true;
        stopCamera();
        this.nzC.closeLoadingDialog();
        this.nzC.dismissAllDialog();
        d.dQU().destory();
        if (this.nzD != null) {
            this.nzD.onDestroy();
        }
        if (this.nzF != null) {
            this.nzF.onDestroy();
        }
        Intent intent = new Intent();
        intent.setAction(AlbumActivityConfig.ACTION_SELECT_IMAGE_RESULT);
        intent.putExtra("album_result", this.nzr.getWriteImagesInfo().toJsonString());
        intent.putExtra("camera_request_from", this.requestFrom);
        intent.putExtra("from_type", this.bxP);
        if (this.nzK != null && !StringUtils.isNull(this.nzK.getStringExtra("file_name"))) {
            intent.putExtra("file_name", this.nzK.getStringExtra("file_name"));
        }
        TbadkCoreApplication.getInst().sendBroadcast(intent);
    }

    public void onRequestPermissionsResult(int i, @NonNull String[] strArr, @NonNull int[] iArr) {
        if (this.nzD != null) {
            this.nzD.dQR();
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
            new com.baidu.tbadk.img.f(null).c(e.this.nzr.getWriteImagesInfo(), true);
            return e.this.nzr.getWriteImagesInfo().toJsonString();
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPostExecute(String str) {
            Intent intent = new Intent();
            intent.putExtra("album_result", str);
            e.this.nzC.setResult(-1, intent);
            e.this.nzC.finish();
        }
    }
}
