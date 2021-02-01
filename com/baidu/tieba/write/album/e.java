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
/* loaded from: classes8.dex */
public class e implements View.OnClickListener, com.baidu.tbadk.suspended.a {
    private c odQ;
    private int odZ;
    private int oea;
    private BaseFragmentActivity oeb;
    private com.baidu.tieba.write.album.a oec;
    private f oed;
    private j oee;
    private FrsTabInfoData oeh;
    private Intent oej;
    private int statisticFrom;
    private int bby = 0;
    private boolean bLd = false;
    private String callFrom = "";
    private String from = "";
    private String forumName = "";
    private String forumId = "0";
    private int requestFrom = 0;
    private int bLf = 0;
    private boolean oef = false;
    private boolean oeg = true;
    private boolean bLg = false;
    private boolean bLh = false;
    private int bLi = 0;
    private int oei = -1;
    private PostPrefixData prefixData = null;
    private AntiData antiData = null;
    private String firstDir = "";
    private String secondDir = "";

    public e(BaseFragmentActivity baseFragmentActivity, Bundle bundle, int i, int i2) {
        a(baseFragmentActivity, i, i2);
        if (bundle == null) {
            an(this.oeb.getIntent());
        } else {
            initData(bundle);
        }
        dB(0, this.odZ);
    }

    private void a(BaseFragmentActivity baseFragmentActivity, int i, int i2) {
        this.oeb = baseFragmentActivity;
        this.odZ = i;
        this.oea = i2;
        this.oec = new com.baidu.tieba.write.album.a(baseFragmentActivity.getPageContext(), this);
        this.oec.Uu();
    }

    private void initData(Bundle bundle) {
        this.odQ = new c(this.oeb.getPageContext());
        if (bundle != null) {
            WriteImagesInfo writeImagesInfo = new WriteImagesInfo();
            writeImagesInfo.parseJson(bundle.getString("write_images_info"));
            this.odQ.setWriteImagesInfo(writeImagesInfo);
            this.bLg = bundle.getBoolean("use_original_img", false);
            this.requestFrom = bundle.getInt("camera_request_from", 0);
            this.forumId = bundle.getString("forum_id");
            this.forumName = bundle.getString("forum_name");
            this.bLf = bundle.getInt("album_thread");
            this.oef = bundle.getBoolean(IntentConfig.KEY_CAN_SELECT_VIDEO);
            this.bLh = bundle.getBoolean("from_write");
            this.callFrom = bundle.getString("KEY_CALL_FROM");
            this.statisticFrom = bundle.getInt(WriteActivityConfig.KEY_STATISTIS_FROM);
            this.bLi = bundle.getInt("from_type");
            this.oeh = (FrsTabInfoData) bundle.getSerializable("tab_list");
            this.from = bundle.getString("from");
            this.oei = bundle.getInt(WriteActivityConfig.KEY_PROFESSION_ZONE, -1);
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
        Ui();
    }

    private void an(Intent intent) {
        this.odQ = new c(this.oeb.getPageContext());
        if (intent != null) {
            WriteImagesInfo writeImagesInfo = new WriteImagesInfo();
            writeImagesInfo.parseJson(intent.getStringExtra("write_images_info"));
            this.odQ.setWriteImagesInfo(writeImagesInfo);
            this.odQ.setOriginalImg(writeImagesInfo.isOriginalImg());
            this.bLg = intent.getBooleanExtra("use_original_img", false);
            this.requestFrom = intent.getIntExtra("camera_request_from", 0);
            this.from = intent.getStringExtra("from");
            this.forumId = intent.getStringExtra("forum_id");
            this.forumName = intent.getStringExtra("forum_name");
            this.bLf = intent.getIntExtra("album_thread", 0);
            this.oef = intent.getBooleanExtra(IntentConfig.KEY_CAN_SELECT_VIDEO, false);
            this.oeg = intent.getBooleanExtra(IntentConfig.KEY_CAN_EDIT_IMAGE, true);
            this.bLh = intent.getBooleanExtra("from_write", false);
            this.callFrom = intent.getStringExtra("KEY_CALL_FROM");
            this.statisticFrom = intent.getIntExtra(WriteActivityConfig.KEY_STATISTIS_FROM, 0);
            this.bLi = intent.getIntExtra("from_type", 0);
            this.oeh = (FrsTabInfoData) intent.getSerializableExtra("tab_list");
            this.oei = intent.getIntExtra(WriteActivityConfig.KEY_PROFESSION_ZONE, -1);
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
        Ui();
    }

    private void Ui() {
        if (this.requestFrom == 2) {
            this.oed = new f() { // from class: com.baidu.tieba.write.album.e.1
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
                    BdToast.b(e.this.oeb, e.this.oeb.getString(R.string.uploade_attation), R.drawable.icon_toast_game_error, false).bqD();
                    return false;
                }
            };
        }
    }

    public void b(NavigationBar navigationBar) {
        if (navigationBar != null) {
            this.oec.b(navigationBar);
        }
    }

    public void eP(int i) {
        if (i == 1) {
            dB(i, this.oea);
        } else {
            dB(i, this.odZ);
        }
    }

    private void dB(int i, int i2) {
        if (!this.bLd) {
            FragmentTransaction beginTransaction = this.oeb.getSupportFragmentManager().beginTransaction();
            Fragment findFragmentByTag = this.oeb.getSupportFragmentManager().findFragmentByTag(this.oec.Lj(this.bby));
            if (findFragmentByTag != null) {
                beginTransaction.hide(findFragmentByTag);
            }
            this.bby = i;
            if (this.oeb.getSupportFragmentManager().findFragmentByTag(this.oec.Lj(i)) != null) {
                beginTransaction.show(this.oec.Li(i));
            } else {
                beginTransaction.add(i2, this.oec.Li(i), this.oec.Lj(i));
            }
            beginTransaction.commitAllowingStateLoss();
            this.oeb.getSupportFragmentManager().executePendingTransactions();
        }
    }

    public void Uj() {
        if (this.requestFrom == 3) {
            TiebaStatic.log(TbadkCoreStatisticKey.UPGRADE_DIALOG_CHOOSE_IMAGE);
        }
        if (this.requestFrom == 5) {
            this.oeb.showLoadingDialog("正在上传");
            new a().execute(new String[0]);
        } else if (this.odQ != null) {
            if (this.oee == null || !this.oee.dXd()) {
                if (this.odQ.UE()) {
                    VideoFileInfo dWN = this.odQ.dWN();
                    if (this.oee == null) {
                        this.oee = new j(this.oeb, this.forumName, this.forumId, "");
                        this.oee.b(this.oeh);
                        this.oee.setExtraData(this.antiData, this.prefixData, this.firstDir, this.secondDir);
                        if (this.oec != null) {
                            this.oec.a(this.oee);
                        }
                    }
                    this.oee.setProfessionZone(this.oei);
                    this.oee.setStatisticFrom(this.statisticFrom);
                    this.oee.a(dWN, this.callFrom, this.from);
                } else if (this.oeg && dWP()) {
                    Uk();
                } else {
                    n(null);
                }
            }
        }
    }

    private boolean dWP() {
        if (this.odQ == null || y.getCount(this.odQ.UG()) == 0) {
            return false;
        }
        int i = 0;
        for (ImageFileInfo imageFileInfo : this.odQ.UG()) {
            if (imageFileInfo != null && imageFileInfo.getImageType() == 0 && (i = i + 1) >= 2) {
                return false;
            }
            i = i;
        }
        return i == 1;
    }

    private void Uk() {
        WriteImagesInfo writeImagesInfo;
        if (this.odQ != null && (writeImagesInfo = this.odQ.getWriteImagesInfo()) != null) {
            this.oeb.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new WriteMulitImageActivityConfig(this.oeb, RequestResponseCode.REQUEST_MOTU_IMAGE, writeImagesInfo, dWQ())));
        }
    }

    private int dWQ() {
        if (this.odQ == null || y.getCount(this.odQ.UG()) == 0) {
            return 0;
        }
        for (int i = 0; i < y.getCount(this.odQ.UG()); i++) {
            ImageFileInfo imageFileInfo = this.odQ.UG().get(i);
            if (imageFileInfo != null && imageFileInfo.getImageType() == 0) {
                return i;
            }
        }
        return 0;
    }

    private void n(Intent intent) {
        Intent intent2 = new Intent();
        intent2.putExtra("album_result", this.odQ.getWriteImagesInfo().toJsonString());
        intent2.putExtra("camera_request_from", this.requestFrom);
        intent2.putExtra("from_type", this.bLi);
        if (intent != null && !StringUtils.isNull(intent.getStringExtra("file_name"))) {
            intent2.putExtra("file_name", intent.getStringExtra("file_name"));
        }
        this.oeb.setResult(-1, intent2);
        this.oeb.finish();
        if (AlbumActivityConfig.FROM_FLUTTER.equals(this.from)) {
            MessageManager.getInstance().sendMessage(new CustomMessage(2921464, intent2));
        }
    }

    @Override // com.baidu.tbadk.suspended.a
    public boolean bEH() {
        if (this.oec == null || this.oec.dWM() == null || this.oec.dWM().dWV() == null) {
            return true;
        }
        return this.oec.dWM().dWV().getFirstVisiblePosition() == 0 && !this.oec.dWM().dWV().canScrollVertically(-1);
    }

    @Override // com.baidu.tbadk.suspended.a
    public boolean bEI() {
        return true;
    }

    @Override // com.baidu.tbadk.suspended.a
    public void rx(int i) {
        if (this.oec != null) {
            this.oec.onChangeSkinType(i);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void onSaveInstanceState(Bundle bundle) {
        bundle.putString("write_images_info", this.odQ.getWriteImagesInfo().toJsonString());
        bundle.putBoolean("use_original_img", this.bLg);
        bundle.putInt("camera_request_from", this.requestFrom);
        bundle.putString("forum_id", this.forumId);
        bundle.putString("forum_name", this.forumName);
        bundle.putInt("album_thread", this.bLf);
        bundle.putBoolean(IntentConfig.KEY_CAN_SELECT_VIDEO, this.oef);
        bundle.putBoolean("from_write", this.bLh);
        bundle.putSerializable("tab_list", this.oeh);
        bundle.putSerializable("anti_data", this.antiData);
        bundle.putSerializable("prefix_data", this.prefixData);
        bundle.putString("forum_first_dir", this.firstDir);
        bundle.putString("forum_second_dir", this.secondDir);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.oec.Uw()) {
            Uj();
        } else if (view == this.oec.Uy()) {
            Uj();
        } else if (view == this.oec.Uv()) {
            if (this.odQ != null) {
                this.odQ.setLastAlbumId(null);
            }
            Uq();
        } else if (view == this.oec.Ux()) {
            dB(0, this.odZ);
        } else if (view == this.oec.Uz()) {
            eN(2);
        } else if (view == this.oec.UA()) {
            eN(1);
        }
    }

    private void Uq() {
        Intent intent = new Intent();
        String lastAlbumId = this.odQ.getLastAlbumId();
        if (TextUtils.isEmpty(lastAlbumId)) {
            lastAlbumId = "";
        }
        intent.putExtra("last_album_id", lastAlbumId);
        intent.putExtra("camera_request_from", this.requestFrom);
        this.oeb.setResult(0, intent);
        this.oeb.finish();
    }

    private void eN(int i) {
        if (this.oec != null && this.odQ != null) {
            this.odQ.setOriginalImg(!this.odQ.isOriginalImg());
            Ul();
            eO(i);
        }
    }

    public void Ul() {
        if (this.odQ != null && this.oec != null) {
            this.oec.dn(this.odQ.isOriginalImg());
        }
    }

    private void eO(int i) {
        if (this.odQ != null && this.odQ.isOriginalImg() && !StringUtils.isNull(this.from, true) && !StringUtils.isNull(this.forumId, true)) {
            TiebaStatic.log(new ar("c10349").dR("fid", this.forumId).dR("obj_type", this.from).ap("obj_locate", i));
        }
    }

    @Override // com.baidu.tbadk.suspended.a
    public Intent bEJ() {
        return null;
    }

    public void e(ImageFileInfo imageFileInfo) {
        if (imageFileInfo != null) {
            Intent intent = new Intent();
            LinkedList<ImageFileInfo> linkedList = new LinkedList<>();
            linkedList.add(imageFileInfo);
            this.odQ.getWriteImagesInfo().setChosedFiles(linkedList);
            intent.putExtra("album_result", this.odQ.getWriteImagesInfo().toJsonString());
            intent.putExtra("camera_request_from", this.requestFrom);
            intent.putExtra("from_type", this.bLi);
            this.oeb.setResult(-1, intent);
            this.oeb.finish();
        }
    }

    public c dWR() {
        return this.odQ;
    }

    public void g(TbPageContext tbPageContext) {
        String str;
        String str2;
        AntiData antiData;
        PostPrefixData postPrefixData;
        if (!cgG() && com.baidu.tieba.write.j.dWD()) {
            ForumWriteData forumWriteData = new ForumWriteData(this.forumId, this.forumName, null, null);
            forumWriteData.statisticFrom = this.statisticFrom;
            RecordVideoActivityConfig recordVideoActivityConfig = new RecordVideoActivityConfig(tbPageContext.getPageActivity(), this.bLh ? 2 : 3, forumWriteData, this.odQ.getWriteImagesInfo(), "", this.bLi);
            recordVideoActivityConfig.setShowType(this.oef ? 0 : 1);
            if (this.oef) {
                if (this.oeb.getIntent() == null) {
                    str = "";
                    str2 = "";
                    antiData = null;
                    postPrefixData = null;
                } else {
                    Serializable serializableExtra = this.oeb.getIntent().getSerializableExtra("anti_data");
                    AntiData antiData2 = serializableExtra instanceof AntiData ? (AntiData) serializableExtra : null;
                    Serializable serializableExtra2 = this.oeb.getIntent().getSerializableExtra("prefix_data");
                    PostPrefixData postPrefixData2 = serializableExtra2 instanceof PostPrefixData ? (PostPrefixData) serializableExtra2 : null;
                    str2 = this.oeb.getIntent().getStringExtra("forum_first_dir");
                    str = this.oeb.getIntent().getStringExtra("forum_second_dir");
                    antiData = antiData2;
                    postPrefixData = postPrefixData2;
                }
                recordVideoActivityConfig.setExtraData(antiData, postPrefixData, str2, str);
            }
            this.oeb.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, recordVideoActivityConfig));
            TiebaStatic.log(new ar(CommonStatisticKey.KEY_ENTRANCE_CLICKED).ap("obj_locate", 5).ap("obj_type", 2));
        }
    }

    private boolean cgG() {
        PermissionJudgePolicy permissionJudgePolicy = new PermissionJudgePolicy();
        permissionJudgePolicy.clearRequestPermissionList();
        permissionJudgePolicy.appendRequestPermission(this.oeb, PermissionRequest.RESOURCE_VIDEO_CAPTURE);
        permissionJudgePolicy.appendRequestPermission(this.oeb, PermissionRequest.RESOURCE_AUDIO_CAPTURE);
        permissionJudgePolicy.appendRequestPermission(this.oeb, "android.permission.WRITE_EXTERNAL_STORAGE");
        return permissionJudgePolicy.startRequestPermission(this.oeb);
    }

    public boolean f(ImageFileInfo imageFileInfo) {
        if (imageFileInfo == null) {
            return false;
        }
        this.odQ.a(null);
        this.odQ.delChooseFile(imageFileInfo);
        Ul();
        return true;
    }

    public boolean g(ImageFileInfo imageFileInfo) {
        if (imageFileInfo == null) {
            return false;
        }
        int maxImagesAllowed = this.odQ.getMaxImagesAllowed();
        if (this.odQ.size() < maxImagesAllowed) {
            if (this.oed == null || this.oed.h(imageFileInfo)) {
                ImageFileInfo imageFileInfo2 = new ImageFileInfo();
                imageFileInfo2.setAlbumnId(imageFileInfo.getAlbumId());
                imageFileInfo2.setContentUriStr(imageFileInfo.getContentUriStr());
                imageFileInfo2.setFilePath(imageFileInfo.getFilePath());
                imageFileInfo2.setModifyTime(imageFileInfo.getModifyTime());
                imageFileInfo2.setIsGif(imageFileInfo.isGif());
                imageFileInfo2.setIsLong(imageFileInfo.isLong());
                this.odQ.a(null);
                this.odQ.addChooseFile(imageFileInfo2);
                Ul();
                return true;
            }
            return false;
        } else if (Up()) {
            return g(imageFileInfo);
        } else {
            this.oeb.showToast(String.format(this.oeb.getString(R.string.max_choose_image_count), Integer.valueOf(maxImagesAllowed)));
            return false;
        }
    }

    private boolean Up() {
        if (this.oeb.getIntent().getBooleanExtra("select_directly", false)) {
            int maxImagesAllowed = this.odQ.getMaxImagesAllowed();
            if (this.odQ.size() == maxImagesAllowed && maxImagesAllowed == 1) {
                try {
                    ImageFileInfo imageFileInfo = (ImageFileInfo) y.getItem(this.odQ.UG(), 0);
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
        Fragment Li;
        if (this.oec != null && (Li = this.oec.Li(0)) != null && (Li instanceof ImageListFragment)) {
            ((ImageListFragment) Li).f(imageFileInfo, z);
        }
    }

    private void h(ImageFileInfo imageFileInfo, boolean z) {
        Fragment Li;
        if (this.oec != null && (Li = this.oec.Li(1)) != null && (Li instanceof AlbumImageBrowseFragment)) {
            ((AlbumImageBrowseFragment) Li).f(imageFileInfo, z);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void o(Intent intent) {
        this.oej = intent;
        if (intent == null || this.odQ == null) {
            n(null);
            return;
        }
        String stringExtra = intent.getStringExtra("album_result");
        if (stringExtra != null) {
            WriteImagesInfo writeImagesInfo = this.odQ.getWriteImagesInfo();
            writeImagesInfo.parseJson(stringExtra);
            writeImagesInfo.updateQuality();
            n(intent);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void onBackClick() {
        this.oeb.closeLoadingDialog();
        if (this.bby == 0) {
            if (this.odQ != null) {
                this.odQ.setLastAlbumId(null);
            }
            Uq();
        } else if (this.bby == 1) {
            eP(0);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int Un() {
        return this.bLf;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean dWS() {
        return this.oef;
    }

    private void stopCamera() {
        if (this.oec != null) {
            this.oec.stopCamera();
        }
    }

    private void openCamera() {
        if (this.oec != null) {
            this.oec.openCamera();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void onStart() {
        if (this.oee != null) {
            this.oee.onStart();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void onResume() {
        openCamera();
        if (this.oee != null) {
            this.oee.onResume();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void onStop() {
        if (this.oee != null) {
            this.oee.onStop();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void onPause() {
        stopCamera();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void onDestroy() {
        this.bLd = true;
        stopCamera();
        this.oeb.closeLoadingDialog();
        this.oeb.dismissAllDialog();
        d.dWO().destory();
        if (this.oec != null) {
            this.oec.onDestroy();
        }
        if (this.oee != null) {
            this.oee.onDestroy();
        }
        Intent intent = new Intent();
        intent.setAction(AlbumActivityConfig.ACTION_SELECT_IMAGE_RESULT);
        intent.putExtra("album_result", this.odQ.getWriteImagesInfo().toJsonString());
        intent.putExtra("camera_request_from", this.requestFrom);
        intent.putExtra("from_type", this.bLi);
        if (this.oej != null && !StringUtils.isNull(this.oej.getStringExtra("file_name"))) {
            intent.putExtra("file_name", this.oej.getStringExtra("file_name"));
        }
        TbadkCoreApplication.getInst().sendBroadcast(intent);
    }

    public void onRequestPermissionsResult(int i, @NonNull String[] strArr, @NonNull int[] iArr) {
        if (this.oec != null) {
            this.oec.dWL();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes8.dex */
    public class a extends BdAsyncTask<String, Integer, String> {
        private a() {
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public String doInBackground(String... strArr) {
            new com.baidu.tbadk.img.f(null).c(e.this.odQ.getWriteImagesInfo(), true);
            return e.this.odQ.getWriteImagesInfo().toJsonString();
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPostExecute(String str) {
            Intent intent = new Intent();
            intent.putExtra("album_result", str);
            e.this.oeb.setResult(-1, intent);
            e.this.oeb.finish();
        }
    }
}
