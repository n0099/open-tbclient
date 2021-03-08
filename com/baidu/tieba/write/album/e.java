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
/* loaded from: classes7.dex */
public class e implements View.OnClickListener, com.baidu.tbadk.suspended.a {
    private int ogF;
    private int ogG;
    private BaseFragmentActivity ogH;
    private com.baidu.tieba.write.album.a ogI;
    private f ogJ;
    private j ogK;
    private FrsTabInfoData ogN;
    private Intent ogP;
    private c ogw;
    private int statisticFrom;
    private int bcY = 0;
    private boolean bMD = false;
    private String callFrom = "";
    private String from = "";
    private String forumName = "";
    private String forumId = "0";
    private int requestFrom = 0;
    private int bMF = 0;
    private boolean ogL = false;
    private boolean ogM = true;
    private boolean bMG = false;
    private boolean bMH = false;
    private int bMI = 0;
    private int ogO = -1;
    private PostPrefixData prefixData = null;
    private AntiData antiData = null;
    private String firstDir = "";
    private String secondDir = "";

    public e(BaseFragmentActivity baseFragmentActivity, Bundle bundle, int i, int i2) {
        a(baseFragmentActivity, i, i2);
        if (bundle == null) {
            an(this.ogH.getIntent());
        } else {
            initData(bundle);
        }
        dC(0, this.ogF);
    }

    private void a(BaseFragmentActivity baseFragmentActivity, int i, int i2) {
        this.ogH = baseFragmentActivity;
        this.ogF = i;
        this.ogG = i2;
        this.ogI = new com.baidu.tieba.write.album.a(baseFragmentActivity.getPageContext(), this);
        this.ogI.Ux();
    }

    private void initData(Bundle bundle) {
        this.ogw = new c(this.ogH.getPageContext());
        if (bundle != null) {
            WriteImagesInfo writeImagesInfo = new WriteImagesInfo();
            writeImagesInfo.parseJson(bundle.getString("write_images_info"));
            this.ogw.setWriteImagesInfo(writeImagesInfo);
            this.bMG = bundle.getBoolean("use_original_img", false);
            this.requestFrom = bundle.getInt("camera_request_from", 0);
            this.forumId = bundle.getString("forum_id");
            this.forumName = bundle.getString("forum_name");
            this.bMF = bundle.getInt("album_thread");
            this.ogL = bundle.getBoolean(IntentConfig.KEY_CAN_SELECT_VIDEO);
            this.bMH = bundle.getBoolean("from_write");
            this.callFrom = bundle.getString("KEY_CALL_FROM");
            this.statisticFrom = bundle.getInt(WriteActivityConfig.KEY_STATISTIS_FROM);
            this.bMI = bundle.getInt("from_type");
            this.ogN = (FrsTabInfoData) bundle.getSerializable("tab_list");
            this.from = bundle.getString("from");
            this.ogO = bundle.getInt(WriteActivityConfig.KEY_PROFESSION_ZONE, -1);
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
        Ul();
    }

    private void an(Intent intent) {
        this.ogw = new c(this.ogH.getPageContext());
        if (intent != null) {
            WriteImagesInfo writeImagesInfo = new WriteImagesInfo();
            writeImagesInfo.parseJson(intent.getStringExtra("write_images_info"));
            this.ogw.setWriteImagesInfo(writeImagesInfo);
            this.ogw.setOriginalImg(writeImagesInfo.isOriginalImg());
            this.bMG = intent.getBooleanExtra("use_original_img", false);
            this.requestFrom = intent.getIntExtra("camera_request_from", 0);
            this.from = intent.getStringExtra("from");
            this.forumId = intent.getStringExtra("forum_id");
            this.forumName = intent.getStringExtra("forum_name");
            this.bMF = intent.getIntExtra("album_thread", 0);
            this.ogL = intent.getBooleanExtra(IntentConfig.KEY_CAN_SELECT_VIDEO, false);
            this.ogM = intent.getBooleanExtra(IntentConfig.KEY_CAN_EDIT_IMAGE, true);
            this.bMH = intent.getBooleanExtra("from_write", false);
            this.callFrom = intent.getStringExtra("KEY_CALL_FROM");
            this.statisticFrom = intent.getIntExtra(WriteActivityConfig.KEY_STATISTIS_FROM, 0);
            this.bMI = intent.getIntExtra("from_type", 0);
            this.ogN = (FrsTabInfoData) intent.getSerializableExtra("tab_list");
            this.ogO = intent.getIntExtra(WriteActivityConfig.KEY_PROFESSION_ZONE, -1);
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
        Ul();
    }

    private void Ul() {
        if (this.requestFrom == 2) {
            this.ogJ = new f() { // from class: com.baidu.tieba.write.album.e.1
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
                    BdToast.b(e.this.ogH, e.this.ogH.getString(R.string.uploade_attation), R.drawable.icon_toast_game_error, false).bqF();
                    return false;
                }
            };
        }
    }

    public void b(NavigationBar navigationBar) {
        if (navigationBar != null) {
            this.ogI.b(navigationBar);
        }
    }

    public void eQ(int i) {
        if (i == 1) {
            dC(i, this.ogG);
        } else {
            dC(i, this.ogF);
        }
    }

    private void dC(int i, int i2) {
        if (!this.bMD) {
            FragmentTransaction beginTransaction = this.ogH.getSupportFragmentManager().beginTransaction();
            Fragment findFragmentByTag = this.ogH.getSupportFragmentManager().findFragmentByTag(this.ogI.Lo(this.bcY));
            if (findFragmentByTag != null) {
                beginTransaction.hide(findFragmentByTag);
            }
            this.bcY = i;
            if (this.ogH.getSupportFragmentManager().findFragmentByTag(this.ogI.Lo(i)) != null) {
                beginTransaction.show(this.ogI.Ln(i));
            } else {
                beginTransaction.add(i2, this.ogI.Ln(i), this.ogI.Lo(i));
            }
            beginTransaction.commitAllowingStateLoss();
            this.ogH.getSupportFragmentManager().executePendingTransactions();
        }
    }

    public void Um() {
        if (this.requestFrom == 3) {
            TiebaStatic.log(TbadkCoreStatisticKey.UPGRADE_DIALOG_CHOOSE_IMAGE);
        }
        if (this.requestFrom == 5) {
            this.ogH.showLoadingDialog("正在上传");
            new a().execute(new String[0]);
        } else if (this.ogw != null) {
            if (this.ogK == null || !this.ogK.dXt()) {
                if (this.ogw.UH()) {
                    VideoFileInfo dXd = this.ogw.dXd();
                    if (this.ogK == null) {
                        this.ogK = new j(this.ogH, this.forumName, this.forumId, "");
                        this.ogK.b(this.ogN);
                        this.ogK.setExtraData(this.antiData, this.prefixData, this.firstDir, this.secondDir);
                        if (this.ogI != null) {
                            this.ogI.a(this.ogK);
                        }
                    }
                    this.ogK.setProfessionZone(this.ogO);
                    this.ogK.setStatisticFrom(this.statisticFrom);
                    this.ogK.a(dXd, this.callFrom, this.from);
                } else if (this.ogM && dXf()) {
                    Un();
                } else {
                    n(null);
                }
            }
        }
    }

    private boolean dXf() {
        if (this.ogw == null || y.getCount(this.ogw.UJ()) == 0) {
            return false;
        }
        int i = 0;
        for (ImageFileInfo imageFileInfo : this.ogw.UJ()) {
            if (imageFileInfo != null && imageFileInfo.getImageType() == 0 && (i = i + 1) >= 2) {
                return false;
            }
            i = i;
        }
        return i == 1;
    }

    private void Un() {
        WriteImagesInfo writeImagesInfo;
        if (this.ogw != null && (writeImagesInfo = this.ogw.getWriteImagesInfo()) != null) {
            this.ogH.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new WriteMulitImageActivityConfig(this.ogH, RequestResponseCode.REQUEST_MOTU_IMAGE, writeImagesInfo, dXg())));
        }
    }

    private int dXg() {
        if (this.ogw == null || y.getCount(this.ogw.UJ()) == 0) {
            return 0;
        }
        for (int i = 0; i < y.getCount(this.ogw.UJ()); i++) {
            ImageFileInfo imageFileInfo = this.ogw.UJ().get(i);
            if (imageFileInfo != null && imageFileInfo.getImageType() == 0) {
                return i;
            }
        }
        return 0;
    }

    private void n(Intent intent) {
        Intent intent2 = new Intent();
        intent2.putExtra("album_result", this.ogw.getWriteImagesInfo().toJsonString());
        intent2.putExtra("camera_request_from", this.requestFrom);
        intent2.putExtra("from_type", this.bMI);
        if (intent != null && !StringUtils.isNull(intent.getStringExtra("file_name"))) {
            intent2.putExtra("file_name", intent.getStringExtra("file_name"));
        }
        this.ogH.setResult(-1, intent2);
        this.ogH.finish();
        if (AlbumActivityConfig.FROM_FLUTTER.equals(this.from)) {
            MessageManager.getInstance().sendMessage(new CustomMessage(2921464, intent2));
        }
    }

    @Override // com.baidu.tbadk.suspended.a
    public boolean bEL() {
        if (this.ogI == null || this.ogI.dXc() == null || this.ogI.dXc().dXl() == null) {
            return true;
        }
        return this.ogI.dXc().dXl().getFirstVisiblePosition() == 0 && !this.ogI.dXc().dXl().canScrollVertically(-1);
    }

    @Override // com.baidu.tbadk.suspended.a
    public boolean bEM() {
        return true;
    }

    @Override // com.baidu.tbadk.suspended.a
    public void rz(int i) {
        if (this.ogI != null) {
            this.ogI.onChangeSkinType(i);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void onSaveInstanceState(Bundle bundle) {
        bundle.putString("write_images_info", this.ogw.getWriteImagesInfo().toJsonString());
        bundle.putBoolean("use_original_img", this.bMG);
        bundle.putInt("camera_request_from", this.requestFrom);
        bundle.putString("forum_id", this.forumId);
        bundle.putString("forum_name", this.forumName);
        bundle.putInt("album_thread", this.bMF);
        bundle.putBoolean(IntentConfig.KEY_CAN_SELECT_VIDEO, this.ogL);
        bundle.putBoolean("from_write", this.bMH);
        bundle.putSerializable("tab_list", this.ogN);
        bundle.putSerializable("anti_data", this.antiData);
        bundle.putSerializable("prefix_data", this.prefixData);
        bundle.putString("forum_first_dir", this.firstDir);
        bundle.putString("forum_second_dir", this.secondDir);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.ogI.Uz()) {
            Um();
        } else if (view == this.ogI.UB()) {
            Um();
        } else if (view == this.ogI.Uy()) {
            if (this.ogw != null) {
                this.ogw.setLastAlbumId(null);
            }
            Ut();
        } else if (view == this.ogI.UA()) {
            dC(0, this.ogF);
        } else if (view == this.ogI.UC()) {
            eO(2);
        } else if (view == this.ogI.UD()) {
            eO(1);
        }
    }

    private void Ut() {
        Intent intent = new Intent();
        String lastAlbumId = this.ogw.getLastAlbumId();
        if (TextUtils.isEmpty(lastAlbumId)) {
            lastAlbumId = "";
        }
        intent.putExtra("last_album_id", lastAlbumId);
        intent.putExtra("camera_request_from", this.requestFrom);
        this.ogH.setResult(0, intent);
        this.ogH.finish();
    }

    private void eO(int i) {
        if (this.ogI != null && this.ogw != null) {
            this.ogw.setOriginalImg(!this.ogw.isOriginalImg());
            Uo();
            eP(i);
        }
    }

    public void Uo() {
        if (this.ogw != null && this.ogI != null) {
            this.ogI.dn(this.ogw.isOriginalImg());
        }
    }

    private void eP(int i) {
        if (this.ogw != null && this.ogw.isOriginalImg() && !StringUtils.isNull(this.from, true) && !StringUtils.isNull(this.forumId, true)) {
            TiebaStatic.log(new ar("c10349").dR("fid", this.forumId).dR("obj_type", this.from).aq("obj_locate", i));
        }
    }

    @Override // com.baidu.tbadk.suspended.a
    public Intent bEN() {
        return null;
    }

    public void e(ImageFileInfo imageFileInfo) {
        if (imageFileInfo != null) {
            Intent intent = new Intent();
            LinkedList<ImageFileInfo> linkedList = new LinkedList<>();
            linkedList.add(imageFileInfo);
            this.ogw.getWriteImagesInfo().setChosedFiles(linkedList);
            intent.putExtra("album_result", this.ogw.getWriteImagesInfo().toJsonString());
            intent.putExtra("camera_request_from", this.requestFrom);
            intent.putExtra("from_type", this.bMI);
            this.ogH.setResult(-1, intent);
            this.ogH.finish();
        }
    }

    public c dXh() {
        return this.ogw;
    }

    public void g(TbPageContext tbPageContext) {
        String str;
        String str2;
        AntiData antiData;
        PostPrefixData postPrefixData;
        if (!cgT() && com.baidu.tieba.write.j.dWT()) {
            ForumWriteData forumWriteData = new ForumWriteData(this.forumId, this.forumName, null, null);
            forumWriteData.statisticFrom = this.statisticFrom;
            RecordVideoActivityConfig recordVideoActivityConfig = new RecordVideoActivityConfig(tbPageContext.getPageActivity(), this.bMH ? 2 : 3, forumWriteData, this.ogw.getWriteImagesInfo(), "", this.bMI);
            recordVideoActivityConfig.setShowType(this.ogL ? 0 : 1);
            if (this.ogL) {
                if (this.ogH.getIntent() == null) {
                    str = "";
                    str2 = "";
                    antiData = null;
                    postPrefixData = null;
                } else {
                    Serializable serializableExtra = this.ogH.getIntent().getSerializableExtra("anti_data");
                    AntiData antiData2 = serializableExtra instanceof AntiData ? (AntiData) serializableExtra : null;
                    Serializable serializableExtra2 = this.ogH.getIntent().getSerializableExtra("prefix_data");
                    PostPrefixData postPrefixData2 = serializableExtra2 instanceof PostPrefixData ? (PostPrefixData) serializableExtra2 : null;
                    str2 = this.ogH.getIntent().getStringExtra("forum_first_dir");
                    str = this.ogH.getIntent().getStringExtra("forum_second_dir");
                    antiData = antiData2;
                    postPrefixData = postPrefixData2;
                }
                recordVideoActivityConfig.setExtraData(antiData, postPrefixData, str2, str);
            }
            this.ogH.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, recordVideoActivityConfig));
            TiebaStatic.log(new ar(CommonStatisticKey.KEY_ENTRANCE_CLICKED).aq("obj_locate", 5).aq("obj_type", 2));
        }
    }

    private boolean cgT() {
        PermissionJudgePolicy permissionJudgePolicy = new PermissionJudgePolicy();
        permissionJudgePolicy.clearRequestPermissionList();
        permissionJudgePolicy.appendRequestPermission(this.ogH, PermissionRequest.RESOURCE_VIDEO_CAPTURE);
        permissionJudgePolicy.appendRequestPermission(this.ogH, PermissionRequest.RESOURCE_AUDIO_CAPTURE);
        permissionJudgePolicy.appendRequestPermission(this.ogH, "android.permission.WRITE_EXTERNAL_STORAGE");
        return permissionJudgePolicy.startRequestPermission(this.ogH);
    }

    public boolean f(ImageFileInfo imageFileInfo) {
        if (imageFileInfo == null) {
            return false;
        }
        this.ogw.a(null);
        this.ogw.delChooseFile(imageFileInfo);
        Uo();
        return true;
    }

    public boolean g(ImageFileInfo imageFileInfo) {
        if (imageFileInfo == null) {
            return false;
        }
        int maxImagesAllowed = this.ogw.getMaxImagesAllowed();
        if (this.ogw.size() < maxImagesAllowed) {
            if (this.ogJ == null || this.ogJ.h(imageFileInfo)) {
                ImageFileInfo imageFileInfo2 = new ImageFileInfo();
                imageFileInfo2.setAlbumnId(imageFileInfo.getAlbumId());
                imageFileInfo2.setContentUriStr(imageFileInfo.getContentUriStr());
                imageFileInfo2.setFilePath(imageFileInfo.getFilePath());
                imageFileInfo2.setModifyTime(imageFileInfo.getModifyTime());
                imageFileInfo2.setIsGif(imageFileInfo.isGif());
                imageFileInfo2.setIsLong(imageFileInfo.isLong());
                this.ogw.a(null);
                this.ogw.addChooseFile(imageFileInfo2);
                Uo();
                return true;
            }
            return false;
        } else if (Us()) {
            return g(imageFileInfo);
        } else {
            this.ogH.showToast(String.format(this.ogH.getString(R.string.max_choose_image_count), Integer.valueOf(maxImagesAllowed)));
            return false;
        }
    }

    private boolean Us() {
        if (this.ogH.getIntent().getBooleanExtra("select_directly", false)) {
            int maxImagesAllowed = this.ogw.getMaxImagesAllowed();
            if (this.ogw.size() == maxImagesAllowed && maxImagesAllowed == 1) {
                try {
                    ImageFileInfo imageFileInfo = (ImageFileInfo) y.getItem(this.ogw.UJ(), 0);
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
        Fragment Ln;
        if (this.ogI != null && (Ln = this.ogI.Ln(0)) != null && (Ln instanceof ImageListFragment)) {
            ((ImageListFragment) Ln).f(imageFileInfo, z);
        }
    }

    private void h(ImageFileInfo imageFileInfo, boolean z) {
        Fragment Ln;
        if (this.ogI != null && (Ln = this.ogI.Ln(1)) != null && (Ln instanceof AlbumImageBrowseFragment)) {
            ((AlbumImageBrowseFragment) Ln).f(imageFileInfo, z);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void o(Intent intent) {
        this.ogP = intent;
        if (intent == null || this.ogw == null) {
            n(null);
            return;
        }
        String stringExtra = intent.getStringExtra("album_result");
        if (stringExtra != null) {
            WriteImagesInfo writeImagesInfo = this.ogw.getWriteImagesInfo();
            writeImagesInfo.parseJson(stringExtra);
            writeImagesInfo.updateQuality();
            n(intent);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void onBackClick() {
        this.ogH.closeLoadingDialog();
        if (this.bcY == 0) {
            if (this.ogw != null) {
                this.ogw.setLastAlbumId(null);
            }
            Ut();
        } else if (this.bcY == 1) {
            eQ(0);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int Uq() {
        return this.bMF;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean dXi() {
        return this.ogL;
    }

    private void stopCamera() {
        if (this.ogI != null) {
            this.ogI.stopCamera();
        }
    }

    private void openCamera() {
        if (this.ogI != null) {
            this.ogI.openCamera();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void onStart() {
        if (this.ogK != null) {
            this.ogK.onStart();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void onResume() {
        openCamera();
        if (this.ogK != null) {
            this.ogK.onResume();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void onStop() {
        if (this.ogK != null) {
            this.ogK.onStop();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void onPause() {
        stopCamera();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void onDestroy() {
        this.bMD = true;
        stopCamera();
        this.ogH.closeLoadingDialog();
        this.ogH.dismissAllDialog();
        d.dXe().destory();
        if (this.ogI != null) {
            this.ogI.onDestroy();
        }
        if (this.ogK != null) {
            this.ogK.onDestroy();
        }
        Intent intent = new Intent();
        intent.setAction(AlbumActivityConfig.ACTION_SELECT_IMAGE_RESULT);
        intent.putExtra("album_result", this.ogw.getWriteImagesInfo().toJsonString());
        intent.putExtra("camera_request_from", this.requestFrom);
        intent.putExtra("from_type", this.bMI);
        if (this.ogP != null && !StringUtils.isNull(this.ogP.getStringExtra("file_name"))) {
            intent.putExtra("file_name", this.ogP.getStringExtra("file_name"));
        }
        TbadkCoreApplication.getInst().sendBroadcast(intent);
    }

    public void onRequestPermissionsResult(int i, @NonNull String[] strArr, @NonNull int[] iArr) {
        if (this.ogI != null) {
            this.ogI.dXb();
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
            new com.baidu.tbadk.img.f(null).c(e.this.ogw.getWriteImagesInfo(), true);
            return e.this.ogw.getWriteImagesInfo().toJsonString();
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPostExecute(String str) {
            Intent intent = new Intent();
            intent.putExtra("album_result", str);
            e.this.ogH.setResult(-1, intent);
            e.this.ogH.finish();
        }
    }
}
