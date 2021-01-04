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
/* loaded from: classes8.dex */
public class e implements View.OnClickListener, com.baidu.tbadk.suspended.a {
    private BaseFragmentActivity nYA;
    private com.baidu.tieba.write.album.a nYB;
    private f nYC;
    private j nYD;
    private FrsTabInfoData nYG;
    private Intent nYI;
    private c nYp;
    private int nYy;
    private int nYz;
    private int statisticFrom;
    private int bdf = 0;
    private boolean bMf = false;
    private String callFrom = "";
    private String from = "";
    private String forumName = "";
    private String forumId = "0";
    private int requestFrom = 0;
    private int bMh = 0;
    private boolean nYE = false;
    private boolean nYF = true;
    private boolean bMi = false;
    private boolean bMj = false;
    private int bMk = 0;
    private int nYH = -1;
    private PostPrefixData prefixData = null;
    private AntiData antiData = null;
    private String firstDir = "";
    private String secondDir = "";

    public e(BaseFragmentActivity baseFragmentActivity, Bundle bundle, int i, int i2) {
        a(baseFragmentActivity, i, i2);
        if (bundle == null) {
            an(this.nYA.getIntent());
        } else {
            initData(bundle);
        }
        dE(0, this.nYy);
    }

    private void a(BaseFragmentActivity baseFragmentActivity, int i, int i2) {
        this.nYA = baseFragmentActivity;
        this.nYy = i;
        this.nYz = i2;
        this.nYB = new com.baidu.tieba.write.album.a(baseFragmentActivity.getPageContext(), this);
        this.nYB.WF();
    }

    private void initData(Bundle bundle) {
        this.nYp = new c(this.nYA.getPageContext());
        if (bundle != null) {
            WriteImagesInfo writeImagesInfo = new WriteImagesInfo();
            writeImagesInfo.parseJson(bundle.getString("write_images_info"));
            this.nYp.setWriteImagesInfo(writeImagesInfo);
            this.bMi = bundle.getBoolean("use_original_img", false);
            this.requestFrom = bundle.getInt("camera_request_from", 0);
            this.forumId = bundle.getString("forum_id");
            this.forumName = bundle.getString("forum_name");
            this.bMh = bundle.getInt("album_thread");
            this.nYE = bundle.getBoolean(IntentConfig.KEY_CAN_SELECT_VIDEO);
            this.bMj = bundle.getBoolean("from_write");
            this.callFrom = bundle.getString("KEY_CALL_FROM");
            this.statisticFrom = bundle.getInt(WriteActivityConfig.KEY_STATISTIS_FROM);
            this.bMk = bundle.getInt("from_type");
            this.nYG = (FrsTabInfoData) bundle.getSerializable("tab_list");
            this.from = bundle.getString("from");
            this.nYH = bundle.getInt(WriteActivityConfig.KEY_PROFESSION_ZONE, -1);
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
        Wt();
    }

    private void an(Intent intent) {
        this.nYp = new c(this.nYA.getPageContext());
        if (intent != null) {
            WriteImagesInfo writeImagesInfo = new WriteImagesInfo();
            writeImagesInfo.parseJson(intent.getStringExtra("write_images_info"));
            this.nYp.setWriteImagesInfo(writeImagesInfo);
            this.nYp.setOriginalImg(writeImagesInfo.isOriginalImg());
            this.bMi = intent.getBooleanExtra("use_original_img", false);
            this.requestFrom = intent.getIntExtra("camera_request_from", 0);
            this.from = intent.getStringExtra("from");
            this.forumId = intent.getStringExtra("forum_id");
            this.forumName = intent.getStringExtra("forum_name");
            this.bMh = intent.getIntExtra("album_thread", 0);
            this.nYE = intent.getBooleanExtra(IntentConfig.KEY_CAN_SELECT_VIDEO, false);
            this.nYF = intent.getBooleanExtra(IntentConfig.KEY_CAN_EDIT_IMAGE, true);
            this.bMj = intent.getBooleanExtra("from_write", false);
            this.callFrom = intent.getStringExtra("KEY_CALL_FROM");
            this.statisticFrom = intent.getIntExtra(WriteActivityConfig.KEY_STATISTIS_FROM, 0);
            this.bMk = intent.getIntExtra("from_type", 0);
            this.nYG = (FrsTabInfoData) intent.getSerializableExtra("tab_list");
            this.nYH = intent.getIntExtra(WriteActivityConfig.KEY_PROFESSION_ZONE, -1);
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
        Wt();
    }

    private void Wt() {
        if (this.requestFrom == 2) {
            this.nYC = new f() { // from class: com.baidu.tieba.write.album.e.1
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
                    BdToast.b(e.this.nYA, e.this.nYA.getString(R.string.uploade_attation), R.drawable.icon_toast_game_error, false).bud();
                    return false;
                }
            };
        }
    }

    public void b(NavigationBar navigationBar) {
        if (navigationBar != null) {
            this.nYB.b(navigationBar);
        }
    }

    public void gs(int i) {
        if (i == 1) {
            dE(i, this.nYz);
        } else {
            dE(i, this.nYy);
        }
    }

    private void dE(int i, int i2) {
        if (!this.bMf) {
            FragmentTransaction beginTransaction = this.nYA.getSupportFragmentManager().beginTransaction();
            Fragment findFragmentByTag = this.nYA.getSupportFragmentManager().findFragmentByTag(this.nYB.Mv(this.bdf));
            if (findFragmentByTag != null) {
                beginTransaction.hide(findFragmentByTag);
            }
            this.bdf = i;
            if (this.nYA.getSupportFragmentManager().findFragmentByTag(this.nYB.Mv(i)) != null) {
                beginTransaction.show(this.nYB.Mu(i));
            } else {
                beginTransaction.add(i2, this.nYB.Mu(i), this.nYB.Mv(i));
            }
            beginTransaction.commitAllowingStateLoss();
            this.nYA.getSupportFragmentManager().executePendingTransactions();
        }
    }

    public void Wu() {
        if (this.requestFrom == 3) {
            TiebaStatic.log(TbadkCoreStatisticKey.UPGRADE_DIALOG_CHOOSE_IMAGE);
        }
        if (this.requestFrom == 5) {
            this.nYA.showLoadingDialog("正在上传");
            new a().execute(new String[0]);
        } else if (this.nYp != null) {
            if (this.nYD == null || !this.nYD.dYG()) {
                if (this.nYp.WP()) {
                    VideoFileInfo dYq = this.nYp.dYq();
                    if (this.nYD == null) {
                        this.nYD = new j(this.nYA, this.forumName, this.forumId, "");
                        this.nYD.b(this.nYG);
                        this.nYD.setExtraData(this.antiData, this.prefixData, this.firstDir, this.secondDir);
                        if (this.nYB != null) {
                            this.nYB.a(this.nYD);
                        }
                    }
                    this.nYD.setProfessionZone(this.nYH);
                    this.nYD.setStatisticFrom(this.statisticFrom);
                    this.nYD.a(dYq, this.callFrom, this.from);
                } else if (this.nYF && dYs()) {
                    Wv();
                } else {
                    n(null);
                }
            }
        }
    }

    private boolean dYs() {
        if (this.nYp == null || x.getCount(this.nYp.WR()) == 0) {
            return false;
        }
        int i = 0;
        for (ImageFileInfo imageFileInfo : this.nYp.WR()) {
            if (imageFileInfo != null && imageFileInfo.getImageType() == 0 && (i = i + 1) >= 2) {
                return false;
            }
            i = i;
        }
        return i == 1;
    }

    private void Wv() {
        WriteImagesInfo writeImagesInfo;
        if (this.nYp != null && (writeImagesInfo = this.nYp.getWriteImagesInfo()) != null) {
            this.nYA.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new WriteMulitImageActivityConfig(this.nYA, RequestResponseCode.REQUEST_MOTU_IMAGE, writeImagesInfo, dYt())));
        }
    }

    private int dYt() {
        if (this.nYp == null || x.getCount(this.nYp.WR()) == 0) {
            return 0;
        }
        for (int i = 0; i < x.getCount(this.nYp.WR()); i++) {
            ImageFileInfo imageFileInfo = this.nYp.WR().get(i);
            if (imageFileInfo != null && imageFileInfo.getImageType() == 0) {
                return i;
            }
        }
        return 0;
    }

    private void n(Intent intent) {
        Intent intent2 = new Intent();
        intent2.putExtra("album_result", this.nYp.getWriteImagesInfo().toJsonString());
        intent2.putExtra("camera_request_from", this.requestFrom);
        intent2.putExtra("from_type", this.bMk);
        if (intent != null && !StringUtils.isNull(intent.getStringExtra("file_name"))) {
            intent2.putExtra("file_name", intent.getStringExtra("file_name"));
        }
        this.nYA.setResult(-1, intent2);
        this.nYA.finish();
        if (AlbumActivityConfig.FROM_FLUTTER.equals(this.from)) {
            MessageManager.getInstance().sendMessage(new CustomMessage(2921464, intent2));
        }
    }

    @Override // com.baidu.tbadk.suspended.a
    public boolean bIg() {
        if (this.nYB == null || this.nYB.dYp() == null || this.nYB.dYp().dYy() == null) {
            return true;
        }
        return this.nYB.dYp().dYy().getFirstVisiblePosition() == 0 && !this.nYB.dYp().dYy().canScrollVertically(-1);
    }

    @Override // com.baidu.tbadk.suspended.a
    public boolean bIh() {
        return true;
    }

    @Override // com.baidu.tbadk.suspended.a
    public void sY(int i) {
        if (this.nYB != null) {
            this.nYB.onChangeSkinType(i);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void onSaveInstanceState(Bundle bundle) {
        bundle.putString("write_images_info", this.nYp.getWriteImagesInfo().toJsonString());
        bundle.putBoolean("use_original_img", this.bMi);
        bundle.putInt("camera_request_from", this.requestFrom);
        bundle.putString("forum_id", this.forumId);
        bundle.putString("forum_name", this.forumName);
        bundle.putInt("album_thread", this.bMh);
        bundle.putBoolean(IntentConfig.KEY_CAN_SELECT_VIDEO, this.nYE);
        bundle.putBoolean("from_write", this.bMj);
        bundle.putSerializable("tab_list", this.nYG);
        bundle.putSerializable("anti_data", this.antiData);
        bundle.putSerializable("prefix_data", this.prefixData);
        bundle.putString("forum_first_dir", this.firstDir);
        bundle.putString("forum_second_dir", this.secondDir);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.nYB.WH()) {
            Wu();
        } else if (view == this.nYB.WJ()) {
            Wu();
        } else if (view == this.nYB.WG()) {
            if (this.nYp != null) {
                this.nYp.setLastAlbumId(null);
            }
            WB();
        } else if (view == this.nYB.WI()) {
            dE(0, this.nYy);
        } else if (view == this.nYB.WK()) {
            gq(2);
        } else if (view == this.nYB.WL()) {
            gq(1);
        }
    }

    private void WB() {
        Intent intent = new Intent();
        String lastAlbumId = this.nYp.getLastAlbumId();
        if (TextUtils.isEmpty(lastAlbumId)) {
            lastAlbumId = "";
        }
        intent.putExtra("last_album_id", lastAlbumId);
        intent.putExtra("camera_request_from", this.requestFrom);
        this.nYA.setResult(0, intent);
        this.nYA.finish();
    }

    private void gq(int i) {
        if (this.nYB != null && this.nYp != null) {
            this.nYp.setOriginalImg(!this.nYp.isOriginalImg());
            Ww();
            gr(i);
        }
    }

    public void Ww() {
        if (this.nYp != null && this.nYB != null) {
            this.nYB.dj(this.nYp.isOriginalImg());
        }
    }

    private void gr(int i) {
        if (this.nYp != null && this.nYp.isOriginalImg() && !StringUtils.isNull(this.from, true) && !StringUtils.isNull(this.forumId, true)) {
            TiebaStatic.log(new aq("c10349").dX("fid", this.forumId).dX("obj_type", this.from).an("obj_locate", i));
        }
    }

    @Override // com.baidu.tbadk.suspended.a
    public Intent bIi() {
        return null;
    }

    public void e(ImageFileInfo imageFileInfo) {
        if (imageFileInfo != null) {
            Intent intent = new Intent();
            LinkedList<ImageFileInfo> linkedList = new LinkedList<>();
            linkedList.add(imageFileInfo);
            this.nYp.getWriteImagesInfo().setChosedFiles(linkedList);
            intent.putExtra("album_result", this.nYp.getWriteImagesInfo().toJsonString());
            intent.putExtra("camera_request_from", this.requestFrom);
            intent.putExtra("from_type", this.bMk);
            this.nYA.setResult(-1, intent);
            this.nYA.finish();
        }
    }

    public c dYu() {
        return this.nYp;
    }

    public void g(TbPageContext tbPageContext) {
        String str;
        String str2;
        AntiData antiData;
        PostPrefixData postPrefixData;
        if (!cjE() && com.baidu.tieba.write.j.dYg()) {
            ForumWriteData forumWriteData = new ForumWriteData(this.forumId, this.forumName, null, null);
            forumWriteData.statisticFrom = this.statisticFrom;
            RecordVideoActivityConfig recordVideoActivityConfig = new RecordVideoActivityConfig(tbPageContext.getPageActivity(), this.bMj ? 2 : 3, forumWriteData, this.nYp.getWriteImagesInfo(), "", this.bMk);
            recordVideoActivityConfig.setShowType(this.nYE ? 0 : 1);
            if (this.nYE) {
                if (this.nYA.getIntent() == null) {
                    str = "";
                    str2 = "";
                    antiData = null;
                    postPrefixData = null;
                } else {
                    Serializable serializableExtra = this.nYA.getIntent().getSerializableExtra("anti_data");
                    AntiData antiData2 = serializableExtra instanceof AntiData ? (AntiData) serializableExtra : null;
                    Serializable serializableExtra2 = this.nYA.getIntent().getSerializableExtra("prefix_data");
                    PostPrefixData postPrefixData2 = serializableExtra2 instanceof PostPrefixData ? (PostPrefixData) serializableExtra2 : null;
                    str2 = this.nYA.getIntent().getStringExtra("forum_first_dir");
                    str = this.nYA.getIntent().getStringExtra("forum_second_dir");
                    antiData = antiData2;
                    postPrefixData = postPrefixData2;
                }
                recordVideoActivityConfig.setExtraData(antiData, postPrefixData, str2, str);
            }
            this.nYA.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, recordVideoActivityConfig));
            TiebaStatic.log(new aq(CommonStatisticKey.KEY_ENTRANCE_CLICKED).an("obj_locate", 5).an("obj_type", 2));
        }
    }

    private boolean cjE() {
        PermissionJudgePolicy permissionJudgePolicy = new PermissionJudgePolicy();
        permissionJudgePolicy.clearRequestPermissionList();
        permissionJudgePolicy.appendRequestPermission(this.nYA, PermissionRequest.RESOURCE_VIDEO_CAPTURE);
        permissionJudgePolicy.appendRequestPermission(this.nYA, PermissionRequest.RESOURCE_AUDIO_CAPTURE);
        permissionJudgePolicy.appendRequestPermission(this.nYA, "android.permission.WRITE_EXTERNAL_STORAGE");
        return permissionJudgePolicy.startRequestPermission(this.nYA);
    }

    public boolean f(ImageFileInfo imageFileInfo) {
        if (imageFileInfo == null) {
            return false;
        }
        this.nYp.a(null);
        this.nYp.delChooseFile(imageFileInfo);
        Ww();
        return true;
    }

    public boolean g(ImageFileInfo imageFileInfo) {
        if (imageFileInfo == null) {
            return false;
        }
        int maxImagesAllowed = this.nYp.getMaxImagesAllowed();
        if (this.nYp.size() < maxImagesAllowed) {
            if (this.nYC == null || this.nYC.h(imageFileInfo)) {
                ImageFileInfo imageFileInfo2 = new ImageFileInfo();
                imageFileInfo2.setAlbumnId(imageFileInfo.getAlbumId());
                imageFileInfo2.setContentUriStr(imageFileInfo.getContentUriStr());
                imageFileInfo2.setFilePath(imageFileInfo.getFilePath());
                imageFileInfo2.setModifyTime(imageFileInfo.getModifyTime());
                imageFileInfo2.setIsGif(imageFileInfo.isGif());
                imageFileInfo2.setIsLong(imageFileInfo.isLong());
                this.nYp.a(null);
                this.nYp.addChooseFile(imageFileInfo2);
                Ww();
                return true;
            }
            return false;
        } else if (WA()) {
            return g(imageFileInfo);
        } else {
            this.nYA.showToast(String.format(this.nYA.getString(R.string.max_choose_image_count), Integer.valueOf(maxImagesAllowed)));
            return false;
        }
    }

    private boolean WA() {
        if (this.nYA.getIntent().getBooleanExtra("select_directly", false)) {
            int maxImagesAllowed = this.nYp.getMaxImagesAllowed();
            if (this.nYp.size() == maxImagesAllowed && maxImagesAllowed == 1) {
                try {
                    ImageFileInfo imageFileInfo = (ImageFileInfo) x.getItem(this.nYp.WR(), 0);
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
        Fragment Mu;
        if (this.nYB != null && (Mu = this.nYB.Mu(0)) != null && (Mu instanceof ImageListFragment)) {
            ((ImageListFragment) Mu).f(imageFileInfo, z);
        }
    }

    private void h(ImageFileInfo imageFileInfo, boolean z) {
        Fragment Mu;
        if (this.nYB != null && (Mu = this.nYB.Mu(1)) != null && (Mu instanceof AlbumImageBrowseFragment)) {
            ((AlbumImageBrowseFragment) Mu).f(imageFileInfo, z);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void o(Intent intent) {
        this.nYI = intent;
        if (intent == null || this.nYp == null) {
            n(null);
            return;
        }
        String stringExtra = intent.getStringExtra("album_result");
        if (stringExtra != null) {
            WriteImagesInfo writeImagesInfo = this.nYp.getWriteImagesInfo();
            writeImagesInfo.parseJson(stringExtra);
            writeImagesInfo.updateQuality();
            n(intent);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void onBackClick() {
        this.nYA.closeLoadingDialog();
        if (this.bdf == 0) {
            if (this.nYp != null) {
                this.nYp.setLastAlbumId(null);
            }
            WB();
        } else if (this.bdf == 1) {
            gs(0);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int Wy() {
        return this.bMh;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean dYv() {
        return this.nYE;
    }

    private void stopCamera() {
        if (this.nYB != null) {
            this.nYB.stopCamera();
        }
    }

    private void openCamera() {
        if (this.nYB != null) {
            this.nYB.openCamera();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void onStart() {
        if (this.nYD != null) {
            this.nYD.onStart();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void onResume() {
        openCamera();
        if (this.nYD != null) {
            this.nYD.onResume();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void onStop() {
        if (this.nYD != null) {
            this.nYD.onStop();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void onPause() {
        stopCamera();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void onDestroy() {
        this.bMf = true;
        stopCamera();
        this.nYA.closeLoadingDialog();
        this.nYA.dismissAllDialog();
        d.dYr().destory();
        if (this.nYB != null) {
            this.nYB.onDestroy();
        }
        if (this.nYD != null) {
            this.nYD.onDestroy();
        }
        Intent intent = new Intent();
        intent.setAction(AlbumActivityConfig.ACTION_SELECT_IMAGE_RESULT);
        intent.putExtra("album_result", this.nYp.getWriteImagesInfo().toJsonString());
        intent.putExtra("camera_request_from", this.requestFrom);
        intent.putExtra("from_type", this.bMk);
        if (this.nYI != null && !StringUtils.isNull(this.nYI.getStringExtra("file_name"))) {
            intent.putExtra("file_name", this.nYI.getStringExtra("file_name"));
        }
        TbadkCoreApplication.getInst().sendBroadcast(intent);
    }

    public void onRequestPermissionsResult(int i, @NonNull String[] strArr, @NonNull int[] iArr) {
        if (this.nYB != null) {
            this.nYB.dYo();
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
            new com.baidu.tbadk.img.f(null).c(e.this.nYp.getWriteImagesInfo(), true);
            return e.this.nYp.getWriteImagesInfo().toJsonString();
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPostExecute(String str) {
            Intent intent = new Intent();
            intent.putExtra("album_result", str);
            e.this.nYA.setResult(-1, intent);
            e.this.nYA.finish();
        }
    }
}
