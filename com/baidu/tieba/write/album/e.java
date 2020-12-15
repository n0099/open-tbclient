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
    private c nUU;
    private int nVd;
    private int nVe;
    private BaseFragmentActivity nVf;
    private com.baidu.tieba.write.album.a nVg;
    private f nVh;
    private j nVi;
    private FrsTabInfoData nVl;
    private Intent nVn;
    private int bbx = 0;
    private boolean bHs = false;
    private String callFrom = "";
    private String from = "";
    private String forumName = "";
    private String forumId = "0";
    private int requestFrom = 0;
    private int bHu = 0;
    private boolean nVj = false;
    private boolean nVk = true;
    private boolean bHv = false;
    private boolean bHw = false;
    private int bHx = 0;
    private int nVm = -1;
    private PostPrefixData prefixData = null;
    private AntiData antiData = null;
    private String firstDir = "";
    private String secondDir = "";

    public e(BaseFragmentActivity baseFragmentActivity, Bundle bundle, int i, int i2) {
        a(baseFragmentActivity, i, i2);
        if (bundle == null) {
            an(this.nVf.getIntent());
        } else {
            initData(bundle);
        }
        dJ(0, this.nVd);
    }

    private void a(BaseFragmentActivity baseFragmentActivity, int i, int i2) {
        this.nVf = baseFragmentActivity;
        this.nVd = i;
        this.nVe = i2;
        this.nVg = new com.baidu.tieba.write.album.a(baseFragmentActivity.getPageContext(), this);
        this.nVg.VD();
    }

    private void initData(Bundle bundle) {
        this.nUU = new c(this.nVf.getPageContext());
        if (bundle != null) {
            WriteImagesInfo writeImagesInfo = new WriteImagesInfo();
            writeImagesInfo.parseJson(bundle.getString("write_images_info"));
            this.nUU.setWriteImagesInfo(writeImagesInfo);
            this.bHv = bundle.getBoolean("use_original_img", false);
            this.requestFrom = bundle.getInt("camera_request_from", 0);
            this.forumId = bundle.getString("forum_id");
            this.forumName = bundle.getString("forum_name");
            this.bHu = bundle.getInt("album_thread");
            this.nVj = bundle.getBoolean(IntentConfig.KEY_CAN_SELECT_VIDEO);
            this.bHw = bundle.getBoolean("from_write");
            this.callFrom = bundle.getString("KEY_CALL_FROM");
            this.bHx = bundle.getInt("from_type");
            this.nVl = (FrsTabInfoData) bundle.getSerializable("tab_list");
            this.from = bundle.getString("from");
            this.nVm = bundle.getInt(WriteActivityConfig.KEY_PROFESSION_ZONE, -1);
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
        Vr();
    }

    private void an(Intent intent) {
        this.nUU = new c(this.nVf.getPageContext());
        if (intent != null) {
            WriteImagesInfo writeImagesInfo = new WriteImagesInfo();
            writeImagesInfo.parseJson(intent.getStringExtra("write_images_info"));
            this.nUU.setWriteImagesInfo(writeImagesInfo);
            this.nUU.setOriginalImg(writeImagesInfo.isOriginalImg());
            this.bHv = intent.getBooleanExtra("use_original_img", false);
            this.requestFrom = intent.getIntExtra("camera_request_from", 0);
            this.from = intent.getStringExtra("from");
            this.forumId = intent.getStringExtra("forum_id");
            this.forumName = intent.getStringExtra("forum_name");
            this.bHu = intent.getIntExtra("album_thread", 0);
            this.nVj = intent.getBooleanExtra(IntentConfig.KEY_CAN_SELECT_VIDEO, false);
            this.nVk = intent.getBooleanExtra(IntentConfig.KEY_CAN_EDIT_IMAGE, true);
            this.bHw = intent.getBooleanExtra("from_write", false);
            this.callFrom = intent.getStringExtra("KEY_CALL_FROM");
            this.bHx = intent.getIntExtra("from_type", 0);
            this.nVl = (FrsTabInfoData) intent.getSerializableExtra("tab_list");
            this.nVm = intent.getIntExtra(WriteActivityConfig.KEY_PROFESSION_ZONE, -1);
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
        Vr();
    }

    private void Vr() {
        if (this.requestFrom == 2) {
            this.nVh = new f() { // from class: com.baidu.tieba.write.album.e.1
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
                    BdToast.a((Context) e.this.nVf, (CharSequence) e.this.nVf.getString(R.string.uploade_attation), R.drawable.icon_toast_game_error, false).brB();
                    return false;
                }
            };
        }
    }

    public void b(NavigationBar navigationBar) {
        if (navigationBar != null) {
            this.nVg.b(navigationBar);
        }
    }

    public void gr(int i) {
        if (i == 1) {
            dJ(i, this.nVe);
        } else {
            dJ(i, this.nVd);
        }
    }

    private void dJ(int i, int i2) {
        if (!this.bHs) {
            FragmentTransaction beginTransaction = this.nVf.getSupportFragmentManager().beginTransaction();
            Fragment findFragmentByTag = this.nVf.getSupportFragmentManager().findFragmentByTag(this.nVg.MI(this.bbx));
            if (findFragmentByTag != null) {
                beginTransaction.hide(findFragmentByTag);
            }
            this.bbx = i;
            if (this.nVf.getSupportFragmentManager().findFragmentByTag(this.nVg.MI(i)) != null) {
                beginTransaction.show(this.nVg.MH(i));
            } else {
                beginTransaction.add(i2, this.nVg.MH(i), this.nVg.MI(i));
            }
            beginTransaction.commitAllowingStateLoss();
            this.nVf.getSupportFragmentManager().executePendingTransactions();
        }
    }

    public void Vs() {
        if (this.requestFrom == 3) {
            TiebaStatic.log(TbadkCoreStatisticKey.UPGRADE_DIALOG_CHOOSE_IMAGE);
        }
        if (this.requestFrom == 5) {
            this.nVf.showLoadingDialog("正在上传");
            new a().execute(new String[0]);
        } else if (this.nUU != null) {
            if (this.nVi == null || !this.nVi.dYZ()) {
                if (this.nUU.VN()) {
                    VideoFileInfo dYN = this.nUU.dYN();
                    if (this.nVi == null) {
                        this.nVi = new j(this.nVf, this.forumName, this.forumId, "");
                        this.nVi.b(this.nVl);
                        this.nVi.setExtraData(this.antiData, this.prefixData, this.firstDir, this.secondDir);
                        if (this.nVg != null) {
                            this.nVg.a(this.nVi);
                        }
                    }
                    this.nVi.setProfessionZone(this.nVm);
                    this.nVi.a(dYN, this.callFrom, this.from);
                } else if (this.nVk && dYP()) {
                    Vt();
                } else {
                    n(null);
                }
            }
        }
    }

    private boolean dYP() {
        if (this.nUU == null || y.getCount(this.nUU.VP()) == 0) {
            return false;
        }
        int i = 0;
        for (ImageFileInfo imageFileInfo : this.nUU.VP()) {
            if (imageFileInfo != null && imageFileInfo.getImageType() == 0 && (i = i + 1) >= 2) {
                return false;
            }
            i = i;
        }
        return i == 1;
    }

    private void Vt() {
        WriteImagesInfo writeImagesInfo;
        if (this.nUU != null && (writeImagesInfo = this.nUU.getWriteImagesInfo()) != null) {
            this.nVf.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new WriteMulitImageActivityConfig(this.nVf, RequestResponseCode.REQUEST_MOTU_IMAGE, writeImagesInfo, dYQ())));
        }
    }

    private int dYQ() {
        if (this.nUU == null || y.getCount(this.nUU.VP()) == 0) {
            return 0;
        }
        for (int i = 0; i < y.getCount(this.nUU.VP()); i++) {
            ImageFileInfo imageFileInfo = this.nUU.VP().get(i);
            if (imageFileInfo != null && imageFileInfo.getImageType() == 0) {
                return i;
            }
        }
        return 0;
    }

    private void n(Intent intent) {
        Intent intent2 = new Intent();
        intent2.putExtra("album_result", this.nUU.getWriteImagesInfo().toJsonString());
        intent2.putExtra("camera_request_from", this.requestFrom);
        intent2.putExtra("from_type", this.bHx);
        if (intent != null && !StringUtils.isNull(intent.getStringExtra("file_name"))) {
            intent2.putExtra("file_name", intent.getStringExtra("file_name"));
        }
        this.nVf.setResult(-1, intent2);
        this.nVf.finish();
        if (AlbumActivityConfig.FROM_FLUTTER.equals(this.from)) {
            MessageManager.getInstance().sendMessage(new CustomMessage(2921464, intent2));
        }
    }

    @Override // com.baidu.tbadk.suspended.a
    public boolean bFL() {
        if (this.nVg == null || this.nVg.dYM() == null || this.nVg.dYM().dYV() == null) {
            return true;
        }
        return this.nVg.dYM().dYV().getFirstVisiblePosition() == 0 && !this.nVg.dYM().dYV().canScrollVertically(-1);
    }

    @Override // com.baidu.tbadk.suspended.a
    public boolean bFM() {
        return true;
    }

    @Override // com.baidu.tbadk.suspended.a
    public void sN(int i) {
        if (this.nVg != null) {
            this.nVg.onChangeSkinType(i);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void onSaveInstanceState(Bundle bundle) {
        bundle.putString("write_images_info", this.nUU.getWriteImagesInfo().toJsonString());
        bundle.putBoolean("use_original_img", this.bHv);
        bundle.putInt("camera_request_from", this.requestFrom);
        bundle.putString("forum_id", this.forumId);
        bundle.putString("forum_name", this.forumName);
        bundle.putInt("album_thread", this.bHu);
        bundle.putBoolean(IntentConfig.KEY_CAN_SELECT_VIDEO, this.nVj);
        bundle.putBoolean("from_write", this.bHw);
        bundle.putSerializable("tab_list", this.nVl);
        bundle.putSerializable("anti_data", this.antiData);
        bundle.putSerializable("prefix_data", this.prefixData);
        bundle.putString("forum_first_dir", this.firstDir);
        bundle.putString("forum_second_dir", this.secondDir);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.nVg.VF()) {
            Vs();
        } else if (view == this.nVg.VH()) {
            Vs();
        } else if (view == this.nVg.VE()) {
            if (this.nUU != null) {
                this.nUU.setLastAlbumId(null);
            }
            Vz();
        } else if (view == this.nVg.VG()) {
            dJ(0, this.nVd);
        } else if (view == this.nVg.VI()) {
            gp(2);
        } else if (view == this.nVg.VJ()) {
            gp(1);
        }
    }

    private void Vz() {
        Intent intent = new Intent();
        String lastAlbumId = this.nUU.getLastAlbumId();
        if (TextUtils.isEmpty(lastAlbumId)) {
            lastAlbumId = "";
        }
        intent.putExtra("last_album_id", lastAlbumId);
        intent.putExtra("camera_request_from", this.requestFrom);
        this.nVf.setResult(0, intent);
        this.nVf.finish();
    }

    private void gp(int i) {
        if (this.nVg != null && this.nUU != null) {
            this.nUU.setOriginalImg(!this.nUU.isOriginalImg());
            Vu();
            gq(i);
        }
    }

    public void Vu() {
        if (this.nUU != null && this.nVg != null) {
            this.nVg.dg(this.nUU.isOriginalImg());
        }
    }

    private void gq(int i) {
        if (this.nUU != null && this.nUU.isOriginalImg() && !StringUtils.isNull(this.from, true) && !StringUtils.isNull(this.forumId, true)) {
            TiebaStatic.log(new ar("c10349").dY("fid", this.forumId).dY("obj_type", this.from).al("obj_locate", i));
        }
    }

    @Override // com.baidu.tbadk.suspended.a
    public Intent bFN() {
        return null;
    }

    public void e(ImageFileInfo imageFileInfo) {
        if (imageFileInfo != null) {
            Intent intent = new Intent();
            LinkedList<ImageFileInfo> linkedList = new LinkedList<>();
            linkedList.add(imageFileInfo);
            this.nUU.getWriteImagesInfo().setChosedFiles(linkedList);
            intent.putExtra("album_result", this.nUU.getWriteImagesInfo().toJsonString());
            intent.putExtra("camera_request_from", this.requestFrom);
            intent.putExtra("from_type", this.bHx);
            this.nVf.setResult(-1, intent);
            this.nVf.finish();
        }
    }

    public c dYR() {
        return this.nUU;
    }

    public void g(TbPageContext tbPageContext) {
        PostPrefixData postPrefixData;
        AntiData antiData = null;
        if (!cgQ() && com.baidu.tieba.write.j.dYC()) {
            RecordVideoActivityConfig recordVideoActivityConfig = new RecordVideoActivityConfig(tbPageContext.getPageActivity(), this.bHw ? 2 : 3, new ForumWriteData(this.forumId, this.forumName, null, null), this.nUU.getWriteImagesInfo(), "", this.bHx);
            recordVideoActivityConfig.setShowType(this.nVj ? 0 : 1);
            if (this.nVj) {
                String str = "";
                String str2 = "";
                if (this.nVf.getIntent() != null) {
                    Serializable serializableExtra = this.nVf.getIntent().getSerializableExtra("anti_data");
                    AntiData antiData2 = serializableExtra instanceof AntiData ? (AntiData) serializableExtra : null;
                    Serializable serializableExtra2 = this.nVf.getIntent().getSerializableExtra("prefix_data");
                    PostPrefixData postPrefixData2 = serializableExtra2 instanceof PostPrefixData ? (PostPrefixData) serializableExtra2 : null;
                    antiData = antiData2;
                    str = this.nVf.getIntent().getStringExtra("forum_first_dir");
                    postPrefixData = postPrefixData2;
                    str2 = this.nVf.getIntent().getStringExtra("forum_second_dir");
                } else {
                    postPrefixData = null;
                }
                recordVideoActivityConfig.setExtraData(antiData, postPrefixData, str, str2);
            }
            this.nVf.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, recordVideoActivityConfig));
            TiebaStatic.log(new ar(CommonStatisticKey.KEY_ENTRANCE_CLICKED).al("obj_locate", 5).al("obj_type", 2));
        }
    }

    private boolean cgQ() {
        PermissionJudgePolicy permissionJudgePolicy = new PermissionJudgePolicy();
        permissionJudgePolicy.clearRequestPermissionList();
        permissionJudgePolicy.appendRequestPermission(this.nVf, PermissionRequest.RESOURCE_VIDEO_CAPTURE);
        permissionJudgePolicy.appendRequestPermission(this.nVf, PermissionRequest.RESOURCE_AUDIO_CAPTURE);
        permissionJudgePolicy.appendRequestPermission(this.nVf, "android.permission.WRITE_EXTERNAL_STORAGE");
        return permissionJudgePolicy.startRequestPermission(this.nVf);
    }

    public boolean f(ImageFileInfo imageFileInfo) {
        if (imageFileInfo == null) {
            return false;
        }
        this.nUU.a(null);
        this.nUU.delChooseFile(imageFileInfo);
        Vu();
        return true;
    }

    public boolean g(ImageFileInfo imageFileInfo) {
        if (imageFileInfo == null) {
            return false;
        }
        int maxImagesAllowed = this.nUU.getMaxImagesAllowed();
        if (this.nUU.size() < maxImagesAllowed) {
            if (this.nVh == null || this.nVh.h(imageFileInfo)) {
                ImageFileInfo imageFileInfo2 = new ImageFileInfo();
                imageFileInfo2.setAlbumnId(imageFileInfo.getAlbumId());
                imageFileInfo2.setContentUriStr(imageFileInfo.getContentUriStr());
                imageFileInfo2.setFilePath(imageFileInfo.getFilePath());
                imageFileInfo2.setModifyTime(imageFileInfo.getModifyTime());
                imageFileInfo2.setIsGif(imageFileInfo.isGif());
                imageFileInfo2.setIsLong(imageFileInfo.isLong());
                this.nUU.a(null);
                this.nUU.addChooseFile(imageFileInfo2);
                Vu();
                return true;
            }
            return false;
        } else if (Vy()) {
            return g(imageFileInfo);
        } else {
            this.nVf.showToast(String.format(this.nVf.getString(R.string.max_choose_image_count), Integer.valueOf(maxImagesAllowed)));
            return false;
        }
    }

    private boolean Vy() {
        if (this.nVf.getIntent().getBooleanExtra("select_directly", false)) {
            int maxImagesAllowed = this.nUU.getMaxImagesAllowed();
            if (this.nUU.size() == maxImagesAllowed && maxImagesAllowed == 1) {
                try {
                    ImageFileInfo imageFileInfo = (ImageFileInfo) y.getItem(this.nUU.VP(), 0);
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
        Fragment MH;
        if (this.nVg != null && (MH = this.nVg.MH(0)) != null && (MH instanceof ImageListFragment)) {
            ((ImageListFragment) MH).f(imageFileInfo, z);
        }
    }

    private void h(ImageFileInfo imageFileInfo, boolean z) {
        Fragment MH;
        if (this.nVg != null && (MH = this.nVg.MH(1)) != null && (MH instanceof AlbumImageBrowseFragment)) {
            ((AlbumImageBrowseFragment) MH).f(imageFileInfo, z);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void o(Intent intent) {
        this.nVn = intent;
        if (intent == null || this.nUU == null) {
            n(null);
            return;
        }
        String stringExtra = intent.getStringExtra("album_result");
        if (stringExtra != null) {
            WriteImagesInfo writeImagesInfo = this.nUU.getWriteImagesInfo();
            writeImagesInfo.parseJson(stringExtra);
            writeImagesInfo.updateQuality();
            n(intent);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void onBackClick() {
        this.nVf.closeLoadingDialog();
        if (this.bbx == 0) {
            if (this.nUU != null) {
                this.nUU.setLastAlbumId(null);
            }
            Vz();
        } else if (this.bbx == 1) {
            gr(0);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int Vw() {
        return this.bHu;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean dYS() {
        return this.nVj;
    }

    private void stopCamera() {
        if (this.nVg != null) {
            this.nVg.stopCamera();
        }
    }

    private void openCamera() {
        if (this.nVg != null) {
            this.nVg.openCamera();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void onStart() {
        if (this.nVi != null) {
            this.nVi.onStart();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void onResume() {
        openCamera();
        if (this.nVi != null) {
            this.nVi.onResume();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void onStop() {
        if (this.nVi != null) {
            this.nVi.onStop();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void onPause() {
        stopCamera();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void onDestroy() {
        this.bHs = true;
        stopCamera();
        this.nVf.closeLoadingDialog();
        this.nVf.dismissAllDialog();
        d.dYO().destory();
        if (this.nVg != null) {
            this.nVg.onDestroy();
        }
        if (this.nVi != null) {
            this.nVi.onDestroy();
        }
        Intent intent = new Intent();
        intent.setAction(AlbumActivityConfig.ACTION_SELECT_IMAGE_RESULT);
        intent.putExtra("album_result", this.nUU.getWriteImagesInfo().toJsonString());
        intent.putExtra("camera_request_from", this.requestFrom);
        intent.putExtra("from_type", this.bHx);
        if (this.nVn != null && !StringUtils.isNull(this.nVn.getStringExtra("file_name"))) {
            intent.putExtra("file_name", this.nVn.getStringExtra("file_name"));
        }
        TbadkCoreApplication.getInst().sendBroadcast(intent);
    }

    public void onRequestPermissionsResult(int i, @NonNull String[] strArr, @NonNull int[] iArr) {
        if (this.nVg != null) {
            this.nVg.dYL();
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
            new com.baidu.tbadk.img.f(null).c(e.this.nUU.getWriteImagesInfo(), true);
            return e.this.nUU.getWriteImagesInfo().toJsonString();
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPostExecute(String str) {
            Intent intent = new Intent();
            intent.putExtra("album_result", str);
            e.this.nVf.setResult(-1, intent);
            e.this.nVf.finish();
        }
    }
}
