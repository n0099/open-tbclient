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
    private com.baidu.tieba.write.album.a nYA;
    private f nYB;
    private j nYC;
    private FrsTabInfoData nYF;
    private Intent nYH;
    private c nYo;
    private int nYx;
    private int nYy;
    private BaseFragmentActivity nYz;
    private int statisticFrom;
    private int bdf = 0;
    private boolean bMf = false;
    private String callFrom = "";
    private String from = "";
    private String forumName = "";
    private String forumId = "0";
    private int requestFrom = 0;
    private int bMh = 0;
    private boolean nYD = false;
    private boolean nYE = true;
    private boolean bMi = false;
    private boolean bMj = false;
    private int bMk = 0;
    private int nYG = -1;
    private PostPrefixData prefixData = null;
    private AntiData antiData = null;
    private String firstDir = "";
    private String secondDir = "";

    public e(BaseFragmentActivity baseFragmentActivity, Bundle bundle, int i, int i2) {
        a(baseFragmentActivity, i, i2);
        if (bundle == null) {
            an(this.nYz.getIntent());
        } else {
            initData(bundle);
        }
        dE(0, this.nYx);
    }

    private void a(BaseFragmentActivity baseFragmentActivity, int i, int i2) {
        this.nYz = baseFragmentActivity;
        this.nYx = i;
        this.nYy = i2;
        this.nYA = new com.baidu.tieba.write.album.a(baseFragmentActivity.getPageContext(), this);
        this.nYA.WG();
    }

    private void initData(Bundle bundle) {
        this.nYo = new c(this.nYz.getPageContext());
        if (bundle != null) {
            WriteImagesInfo writeImagesInfo = new WriteImagesInfo();
            writeImagesInfo.parseJson(bundle.getString("write_images_info"));
            this.nYo.setWriteImagesInfo(writeImagesInfo);
            this.bMi = bundle.getBoolean("use_original_img", false);
            this.requestFrom = bundle.getInt("camera_request_from", 0);
            this.forumId = bundle.getString("forum_id");
            this.forumName = bundle.getString("forum_name");
            this.bMh = bundle.getInt("album_thread");
            this.nYD = bundle.getBoolean(IntentConfig.KEY_CAN_SELECT_VIDEO);
            this.bMj = bundle.getBoolean("from_write");
            this.callFrom = bundle.getString("KEY_CALL_FROM");
            this.statisticFrom = bundle.getInt(WriteActivityConfig.KEY_STATISTIS_FROM);
            this.bMk = bundle.getInt("from_type");
            this.nYF = (FrsTabInfoData) bundle.getSerializable("tab_list");
            this.from = bundle.getString("from");
            this.nYG = bundle.getInt(WriteActivityConfig.KEY_PROFESSION_ZONE, -1);
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
        Wu();
    }

    private void an(Intent intent) {
        this.nYo = new c(this.nYz.getPageContext());
        if (intent != null) {
            WriteImagesInfo writeImagesInfo = new WriteImagesInfo();
            writeImagesInfo.parseJson(intent.getStringExtra("write_images_info"));
            this.nYo.setWriteImagesInfo(writeImagesInfo);
            this.nYo.setOriginalImg(writeImagesInfo.isOriginalImg());
            this.bMi = intent.getBooleanExtra("use_original_img", false);
            this.requestFrom = intent.getIntExtra("camera_request_from", 0);
            this.from = intent.getStringExtra("from");
            this.forumId = intent.getStringExtra("forum_id");
            this.forumName = intent.getStringExtra("forum_name");
            this.bMh = intent.getIntExtra("album_thread", 0);
            this.nYD = intent.getBooleanExtra(IntentConfig.KEY_CAN_SELECT_VIDEO, false);
            this.nYE = intent.getBooleanExtra(IntentConfig.KEY_CAN_EDIT_IMAGE, true);
            this.bMj = intent.getBooleanExtra("from_write", false);
            this.callFrom = intent.getStringExtra("KEY_CALL_FROM");
            this.statisticFrom = intent.getIntExtra(WriteActivityConfig.KEY_STATISTIS_FROM, 0);
            this.bMk = intent.getIntExtra("from_type", 0);
            this.nYF = (FrsTabInfoData) intent.getSerializableExtra("tab_list");
            this.nYG = intent.getIntExtra(WriteActivityConfig.KEY_PROFESSION_ZONE, -1);
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
        Wu();
    }

    private void Wu() {
        if (this.requestFrom == 2) {
            this.nYB = new f() { // from class: com.baidu.tieba.write.album.e.1
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
                    BdToast.b(e.this.nYz, e.this.nYz.getString(R.string.uploade_attation), R.drawable.icon_toast_game_error, false).bue();
                    return false;
                }
            };
        }
    }

    public void b(NavigationBar navigationBar) {
        if (navigationBar != null) {
            this.nYA.b(navigationBar);
        }
    }

    public void gs(int i) {
        if (i == 1) {
            dE(i, this.nYy);
        } else {
            dE(i, this.nYx);
        }
    }

    private void dE(int i, int i2) {
        if (!this.bMf) {
            FragmentTransaction beginTransaction = this.nYz.getSupportFragmentManager().beginTransaction();
            Fragment findFragmentByTag = this.nYz.getSupportFragmentManager().findFragmentByTag(this.nYA.Mv(this.bdf));
            if (findFragmentByTag != null) {
                beginTransaction.hide(findFragmentByTag);
            }
            this.bdf = i;
            if (this.nYz.getSupportFragmentManager().findFragmentByTag(this.nYA.Mv(i)) != null) {
                beginTransaction.show(this.nYA.Mu(i));
            } else {
                beginTransaction.add(i2, this.nYA.Mu(i), this.nYA.Mv(i));
            }
            beginTransaction.commitAllowingStateLoss();
            this.nYz.getSupportFragmentManager().executePendingTransactions();
        }
    }

    public void Wv() {
        if (this.requestFrom == 3) {
            TiebaStatic.log(TbadkCoreStatisticKey.UPGRADE_DIALOG_CHOOSE_IMAGE);
        }
        if (this.requestFrom == 5) {
            this.nYz.showLoadingDialog("正在上传");
            new a().execute(new String[0]);
        } else if (this.nYo != null) {
            if (this.nYC == null || !this.nYC.dYH()) {
                if (this.nYo.WQ()) {
                    VideoFileInfo dYr = this.nYo.dYr();
                    if (this.nYC == null) {
                        this.nYC = new j(this.nYz, this.forumName, this.forumId, "");
                        this.nYC.b(this.nYF);
                        this.nYC.setExtraData(this.antiData, this.prefixData, this.firstDir, this.secondDir);
                        if (this.nYA != null) {
                            this.nYA.a(this.nYC);
                        }
                    }
                    this.nYC.setProfessionZone(this.nYG);
                    this.nYC.setStatisticFrom(this.statisticFrom);
                    this.nYC.a(dYr, this.callFrom, this.from);
                } else if (this.nYE && dYt()) {
                    Ww();
                } else {
                    n(null);
                }
            }
        }
    }

    private boolean dYt() {
        if (this.nYo == null || x.getCount(this.nYo.WS()) == 0) {
            return false;
        }
        int i = 0;
        for (ImageFileInfo imageFileInfo : this.nYo.WS()) {
            if (imageFileInfo != null && imageFileInfo.getImageType() == 0 && (i = i + 1) >= 2) {
                return false;
            }
            i = i;
        }
        return i == 1;
    }

    private void Ww() {
        WriteImagesInfo writeImagesInfo;
        if (this.nYo != null && (writeImagesInfo = this.nYo.getWriteImagesInfo()) != null) {
            this.nYz.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new WriteMulitImageActivityConfig(this.nYz, RequestResponseCode.REQUEST_MOTU_IMAGE, writeImagesInfo, dYu())));
        }
    }

    private int dYu() {
        if (this.nYo == null || x.getCount(this.nYo.WS()) == 0) {
            return 0;
        }
        for (int i = 0; i < x.getCount(this.nYo.WS()); i++) {
            ImageFileInfo imageFileInfo = this.nYo.WS().get(i);
            if (imageFileInfo != null && imageFileInfo.getImageType() == 0) {
                return i;
            }
        }
        return 0;
    }

    private void n(Intent intent) {
        Intent intent2 = new Intent();
        intent2.putExtra("album_result", this.nYo.getWriteImagesInfo().toJsonString());
        intent2.putExtra("camera_request_from", this.requestFrom);
        intent2.putExtra("from_type", this.bMk);
        if (intent != null && !StringUtils.isNull(intent.getStringExtra("file_name"))) {
            intent2.putExtra("file_name", intent.getStringExtra("file_name"));
        }
        this.nYz.setResult(-1, intent2);
        this.nYz.finish();
        if (AlbumActivityConfig.FROM_FLUTTER.equals(this.from)) {
            MessageManager.getInstance().sendMessage(new CustomMessage(2921464, intent2));
        }
    }

    @Override // com.baidu.tbadk.suspended.a
    public boolean bIh() {
        if (this.nYA == null || this.nYA.dYq() == null || this.nYA.dYq().dYz() == null) {
            return true;
        }
        return this.nYA.dYq().dYz().getFirstVisiblePosition() == 0 && !this.nYA.dYq().dYz().canScrollVertically(-1);
    }

    @Override // com.baidu.tbadk.suspended.a
    public boolean bIi() {
        return true;
    }

    @Override // com.baidu.tbadk.suspended.a
    public void sY(int i) {
        if (this.nYA != null) {
            this.nYA.onChangeSkinType(i);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void onSaveInstanceState(Bundle bundle) {
        bundle.putString("write_images_info", this.nYo.getWriteImagesInfo().toJsonString());
        bundle.putBoolean("use_original_img", this.bMi);
        bundle.putInt("camera_request_from", this.requestFrom);
        bundle.putString("forum_id", this.forumId);
        bundle.putString("forum_name", this.forumName);
        bundle.putInt("album_thread", this.bMh);
        bundle.putBoolean(IntentConfig.KEY_CAN_SELECT_VIDEO, this.nYD);
        bundle.putBoolean("from_write", this.bMj);
        bundle.putSerializable("tab_list", this.nYF);
        bundle.putSerializable("anti_data", this.antiData);
        bundle.putSerializable("prefix_data", this.prefixData);
        bundle.putString("forum_first_dir", this.firstDir);
        bundle.putString("forum_second_dir", this.secondDir);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.nYA.WI()) {
            Wv();
        } else if (view == this.nYA.WK()) {
            Wv();
        } else if (view == this.nYA.WH()) {
            if (this.nYo != null) {
                this.nYo.setLastAlbumId(null);
            }
            WC();
        } else if (view == this.nYA.WJ()) {
            dE(0, this.nYx);
        } else if (view == this.nYA.WL()) {
            gq(2);
        } else if (view == this.nYA.WM()) {
            gq(1);
        }
    }

    private void WC() {
        Intent intent = new Intent();
        String lastAlbumId = this.nYo.getLastAlbumId();
        if (TextUtils.isEmpty(lastAlbumId)) {
            lastAlbumId = "";
        }
        intent.putExtra("last_album_id", lastAlbumId);
        intent.putExtra("camera_request_from", this.requestFrom);
        this.nYz.setResult(0, intent);
        this.nYz.finish();
    }

    private void gq(int i) {
        if (this.nYA != null && this.nYo != null) {
            this.nYo.setOriginalImg(!this.nYo.isOriginalImg());
            Wx();
            gr(i);
        }
    }

    public void Wx() {
        if (this.nYo != null && this.nYA != null) {
            this.nYA.dj(this.nYo.isOriginalImg());
        }
    }

    private void gr(int i) {
        if (this.nYo != null && this.nYo.isOriginalImg() && !StringUtils.isNull(this.from, true) && !StringUtils.isNull(this.forumId, true)) {
            TiebaStatic.log(new aq("c10349").dX("fid", this.forumId).dX("obj_type", this.from).an("obj_locate", i));
        }
    }

    @Override // com.baidu.tbadk.suspended.a
    public Intent bIj() {
        return null;
    }

    public void e(ImageFileInfo imageFileInfo) {
        if (imageFileInfo != null) {
            Intent intent = new Intent();
            LinkedList<ImageFileInfo> linkedList = new LinkedList<>();
            linkedList.add(imageFileInfo);
            this.nYo.getWriteImagesInfo().setChosedFiles(linkedList);
            intent.putExtra("album_result", this.nYo.getWriteImagesInfo().toJsonString());
            intent.putExtra("camera_request_from", this.requestFrom);
            intent.putExtra("from_type", this.bMk);
            this.nYz.setResult(-1, intent);
            this.nYz.finish();
        }
    }

    public c dYv() {
        return this.nYo;
    }

    public void g(TbPageContext tbPageContext) {
        String str;
        String str2;
        AntiData antiData;
        PostPrefixData postPrefixData;
        if (!cjF() && com.baidu.tieba.write.j.dYh()) {
            ForumWriteData forumWriteData = new ForumWriteData(this.forumId, this.forumName, null, null);
            forumWriteData.statisticFrom = this.statisticFrom;
            RecordVideoActivityConfig recordVideoActivityConfig = new RecordVideoActivityConfig(tbPageContext.getPageActivity(), this.bMj ? 2 : 3, forumWriteData, this.nYo.getWriteImagesInfo(), "", this.bMk);
            recordVideoActivityConfig.setShowType(this.nYD ? 0 : 1);
            if (this.nYD) {
                if (this.nYz.getIntent() == null) {
                    str = "";
                    str2 = "";
                    antiData = null;
                    postPrefixData = null;
                } else {
                    Serializable serializableExtra = this.nYz.getIntent().getSerializableExtra("anti_data");
                    AntiData antiData2 = serializableExtra instanceof AntiData ? (AntiData) serializableExtra : null;
                    Serializable serializableExtra2 = this.nYz.getIntent().getSerializableExtra("prefix_data");
                    PostPrefixData postPrefixData2 = serializableExtra2 instanceof PostPrefixData ? (PostPrefixData) serializableExtra2 : null;
                    str2 = this.nYz.getIntent().getStringExtra("forum_first_dir");
                    str = this.nYz.getIntent().getStringExtra("forum_second_dir");
                    antiData = antiData2;
                    postPrefixData = postPrefixData2;
                }
                recordVideoActivityConfig.setExtraData(antiData, postPrefixData, str2, str);
            }
            this.nYz.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, recordVideoActivityConfig));
            TiebaStatic.log(new aq(CommonStatisticKey.KEY_ENTRANCE_CLICKED).an("obj_locate", 5).an("obj_type", 2));
        }
    }

    private boolean cjF() {
        PermissionJudgePolicy permissionJudgePolicy = new PermissionJudgePolicy();
        permissionJudgePolicy.clearRequestPermissionList();
        permissionJudgePolicy.appendRequestPermission(this.nYz, PermissionRequest.RESOURCE_VIDEO_CAPTURE);
        permissionJudgePolicy.appendRequestPermission(this.nYz, PermissionRequest.RESOURCE_AUDIO_CAPTURE);
        permissionJudgePolicy.appendRequestPermission(this.nYz, "android.permission.WRITE_EXTERNAL_STORAGE");
        return permissionJudgePolicy.startRequestPermission(this.nYz);
    }

    public boolean f(ImageFileInfo imageFileInfo) {
        if (imageFileInfo == null) {
            return false;
        }
        this.nYo.a(null);
        this.nYo.delChooseFile(imageFileInfo);
        Wx();
        return true;
    }

    public boolean g(ImageFileInfo imageFileInfo) {
        if (imageFileInfo == null) {
            return false;
        }
        int maxImagesAllowed = this.nYo.getMaxImagesAllowed();
        if (this.nYo.size() < maxImagesAllowed) {
            if (this.nYB == null || this.nYB.h(imageFileInfo)) {
                ImageFileInfo imageFileInfo2 = new ImageFileInfo();
                imageFileInfo2.setAlbumnId(imageFileInfo.getAlbumId());
                imageFileInfo2.setContentUriStr(imageFileInfo.getContentUriStr());
                imageFileInfo2.setFilePath(imageFileInfo.getFilePath());
                imageFileInfo2.setModifyTime(imageFileInfo.getModifyTime());
                imageFileInfo2.setIsGif(imageFileInfo.isGif());
                imageFileInfo2.setIsLong(imageFileInfo.isLong());
                this.nYo.a(null);
                this.nYo.addChooseFile(imageFileInfo2);
                Wx();
                return true;
            }
            return false;
        } else if (WB()) {
            return g(imageFileInfo);
        } else {
            this.nYz.showToast(String.format(this.nYz.getString(R.string.max_choose_image_count), Integer.valueOf(maxImagesAllowed)));
            return false;
        }
    }

    private boolean WB() {
        if (this.nYz.getIntent().getBooleanExtra("select_directly", false)) {
            int maxImagesAllowed = this.nYo.getMaxImagesAllowed();
            if (this.nYo.size() == maxImagesAllowed && maxImagesAllowed == 1) {
                try {
                    ImageFileInfo imageFileInfo = (ImageFileInfo) x.getItem(this.nYo.WS(), 0);
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
        if (this.nYA != null && (Mu = this.nYA.Mu(0)) != null && (Mu instanceof ImageListFragment)) {
            ((ImageListFragment) Mu).f(imageFileInfo, z);
        }
    }

    private void h(ImageFileInfo imageFileInfo, boolean z) {
        Fragment Mu;
        if (this.nYA != null && (Mu = this.nYA.Mu(1)) != null && (Mu instanceof AlbumImageBrowseFragment)) {
            ((AlbumImageBrowseFragment) Mu).f(imageFileInfo, z);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void o(Intent intent) {
        this.nYH = intent;
        if (intent == null || this.nYo == null) {
            n(null);
            return;
        }
        String stringExtra = intent.getStringExtra("album_result");
        if (stringExtra != null) {
            WriteImagesInfo writeImagesInfo = this.nYo.getWriteImagesInfo();
            writeImagesInfo.parseJson(stringExtra);
            writeImagesInfo.updateQuality();
            n(intent);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void onBackClick() {
        this.nYz.closeLoadingDialog();
        if (this.bdf == 0) {
            if (this.nYo != null) {
                this.nYo.setLastAlbumId(null);
            }
            WC();
        } else if (this.bdf == 1) {
            gs(0);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int Wz() {
        return this.bMh;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean dYw() {
        return this.nYD;
    }

    private void stopCamera() {
        if (this.nYA != null) {
            this.nYA.stopCamera();
        }
    }

    private void openCamera() {
        if (this.nYA != null) {
            this.nYA.openCamera();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void onStart() {
        if (this.nYC != null) {
            this.nYC.onStart();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void onResume() {
        openCamera();
        if (this.nYC != null) {
            this.nYC.onResume();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void onStop() {
        if (this.nYC != null) {
            this.nYC.onStop();
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
        this.nYz.closeLoadingDialog();
        this.nYz.dismissAllDialog();
        d.dYs().destory();
        if (this.nYA != null) {
            this.nYA.onDestroy();
        }
        if (this.nYC != null) {
            this.nYC.onDestroy();
        }
        Intent intent = new Intent();
        intent.setAction(AlbumActivityConfig.ACTION_SELECT_IMAGE_RESULT);
        intent.putExtra("album_result", this.nYo.getWriteImagesInfo().toJsonString());
        intent.putExtra("camera_request_from", this.requestFrom);
        intent.putExtra("from_type", this.bMk);
        if (this.nYH != null && !StringUtils.isNull(this.nYH.getStringExtra("file_name"))) {
            intent.putExtra("file_name", this.nYH.getStringExtra("file_name"));
        }
        TbadkCoreApplication.getInst().sendBroadcast(intent);
    }

    public void onRequestPermissionsResult(int i, @NonNull String[] strArr, @NonNull int[] iArr) {
        if (this.nYA != null) {
            this.nYA.dYp();
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
            new com.baidu.tbadk.img.f(null).c(e.this.nYo.getWriteImagesInfo(), true);
            return e.this.nYo.getWriteImagesInfo().toJsonString();
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPostExecute(String str) {
            Intent intent = new Intent();
            intent.putExtra("album_result", str);
            e.this.nYz.setResult(-1, intent);
            e.this.nYz.finish();
        }
    }
}
