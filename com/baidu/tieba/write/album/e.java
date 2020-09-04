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
    private int mNE;
    private int mNF;
    private BaseFragmentActivity mNG;
    private com.baidu.tieba.write.album.a mNH;
    private f mNI;
    private j mNJ;
    private FrsTabInfoData mNM;
    private Intent mNO;
    private c mNv;
    private int aRM = 0;
    private boolean boz = false;
    private String callFrom = "";
    private String from = "";
    private String forumName = "";
    private String forumId = "0";
    private int requestFrom = 0;
    private int boB = 0;
    private boolean mNK = false;
    private boolean mNL = true;
    private boolean boC = false;
    private boolean boD = false;
    private int boE = 0;
    private int mNN = -1;
    private PostPrefixData prefixData = null;
    private AntiData antiData = null;
    private String firstDir = "";
    private String secondDir = "";

    public e(BaseFragmentActivity baseFragmentActivity, Bundle bundle, int i, int i2) {
        a(baseFragmentActivity, i, i2);
        if (bundle == null) {
            aq(this.mNG.getIntent());
        } else {
            initData(bundle);
        }
        dv(0, this.mNE);
    }

    private void a(BaseFragmentActivity baseFragmentActivity, int i, int i2) {
        this.mNG = baseFragmentActivity;
        this.mNE = i;
        this.mNF = i2;
        this.mNH = new com.baidu.tieba.write.album.a(baseFragmentActivity.getPageContext(), this);
        this.mNH.OB();
    }

    private void initData(Bundle bundle) {
        this.mNv = new c(this.mNG.getPageContext());
        if (bundle != null) {
            WriteImagesInfo writeImagesInfo = new WriteImagesInfo();
            writeImagesInfo.parseJson(bundle.getString("write_images_info"));
            this.mNv.setWriteImagesInfo(writeImagesInfo);
            this.boC = bundle.getBoolean("use_original_img", false);
            this.requestFrom = bundle.getInt("camera_request_from", 0);
            this.forumId = bundle.getString("forum_id");
            this.forumName = bundle.getString("forum_name");
            this.boB = bundle.getInt("album_thread");
            this.mNK = bundle.getBoolean(IntentConfig.KEY_CAN_SELECT_VIDEO);
            this.boD = bundle.getBoolean("from_write");
            this.callFrom = bundle.getString("KEY_CALL_FROM");
            this.boE = bundle.getInt("from_type");
            this.mNM = (FrsTabInfoData) bundle.getSerializable("tab_list");
            this.from = bundle.getString("from");
            this.mNN = bundle.getInt(WriteActivityConfig.KEY_PROFESSION_ZONE, -1);
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
        Op();
    }

    private void aq(Intent intent) {
        this.mNv = new c(this.mNG.getPageContext());
        if (intent != null) {
            WriteImagesInfo writeImagesInfo = new WriteImagesInfo();
            writeImagesInfo.parseJson(intent.getStringExtra("write_images_info"));
            this.mNv.setWriteImagesInfo(writeImagesInfo);
            this.mNv.setOriginalImg(writeImagesInfo.isOriginalImg());
            this.boC = intent.getBooleanExtra("use_original_img", false);
            this.requestFrom = intent.getIntExtra("camera_request_from", 0);
            this.from = intent.getStringExtra("from");
            this.forumId = intent.getStringExtra("forum_id");
            this.forumName = intent.getStringExtra("forum_name");
            this.boB = intent.getIntExtra("album_thread", 0);
            this.mNK = intent.getBooleanExtra(IntentConfig.KEY_CAN_SELECT_VIDEO, false);
            this.mNL = intent.getBooleanExtra(IntentConfig.KEY_CAN_EDIT_IMAGE, true);
            this.boD = intent.getBooleanExtra("from_write", false);
            this.callFrom = intent.getStringExtra("KEY_CALL_FROM");
            this.boE = intent.getIntExtra("from_type", 0);
            this.mNM = (FrsTabInfoData) intent.getSerializableExtra("tab_list");
            this.mNN = intent.getIntExtra(WriteActivityConfig.KEY_PROFESSION_ZONE, -1);
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
        Op();
    }

    private void Op() {
        if (this.requestFrom == 2) {
            this.mNI = new f() { // from class: com.baidu.tieba.write.album.e.1
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
                    BdToast.a((Context) e.this.mNG, (CharSequence) e.this.mNG.getString(R.string.uploade_attation), R.drawable.icon_toast_game_error, false).bhm();
                    return false;
                }
            };
        }
    }

    public void a(NavigationBar navigationBar) {
        if (navigationBar != null) {
            this.mNH.a(navigationBar);
        }
    }

    public void fn(int i) {
        if (i == 1) {
            dv(i, this.mNF);
        } else {
            dv(i, this.mNE);
        }
    }

    private void dv(int i, int i2) {
        if (!this.boz) {
            FragmentTransaction beginTransaction = this.mNG.getSupportFragmentManager().beginTransaction();
            Fragment findFragmentByTag = this.mNG.getSupportFragmentManager().findFragmentByTag(this.mNH.Jy(this.aRM));
            if (findFragmentByTag != null) {
                beginTransaction.hide(findFragmentByTag);
            }
            this.aRM = i;
            if (this.mNG.getSupportFragmentManager().findFragmentByTag(this.mNH.Jy(i)) != null) {
                beginTransaction.show(this.mNH.Jx(i));
            } else {
                beginTransaction.add(i2, this.mNH.Jx(i), this.mNH.Jy(i));
            }
            beginTransaction.commitAllowingStateLoss();
            this.mNG.getSupportFragmentManager().executePendingTransactions();
        }
    }

    public void Oq() {
        if (this.requestFrom == 3) {
            TiebaStatic.log(TbadkCoreStatisticKey.UPGRADE_DIALOG_CHOOSE_IMAGE);
        }
        if (this.requestFrom == 5) {
            this.mNG.showLoadingDialog("正在上传");
            new a().execute(new String[0]);
        } else if (this.mNv != null) {
            if (this.mNJ == null || !this.mNJ.dGr()) {
                if (this.mNv.OL()) {
                    VideoFileInfo dGf = this.mNv.dGf();
                    if (this.mNJ == null) {
                        this.mNJ = new j(this.mNG, this.forumName, this.forumId, "");
                        this.mNJ.b(this.mNM);
                        this.mNJ.setExtraData(this.antiData, this.prefixData, this.firstDir, this.secondDir);
                        if (this.mNH != null) {
                            this.mNH.a(this.mNJ);
                        }
                    }
                    this.mNJ.setProfessionZone(this.mNN);
                    this.mNJ.a(dGf, this.callFrom, this.from);
                } else if (this.mNL && dGh()) {
                    Or();
                } else {
                    n(null);
                }
            }
        }
    }

    private boolean dGh() {
        if (this.mNv == null || y.getCount(this.mNv.ON()) == 0) {
            return false;
        }
        int i = 0;
        for (ImageFileInfo imageFileInfo : this.mNv.ON()) {
            if (imageFileInfo != null && imageFileInfo.getImageType() == 0 && (i = i + 1) >= 2) {
                return false;
            }
            i = i;
        }
        return i == 1;
    }

    private void Or() {
        WriteImagesInfo writeImagesInfo;
        if (this.mNv != null && (writeImagesInfo = this.mNv.getWriteImagesInfo()) != null) {
            this.mNG.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new WriteMulitImageActivityConfig(this.mNG, RequestResponseCode.REQUEST_MOTU_IMAGE, writeImagesInfo, dGi())));
        }
    }

    private int dGi() {
        if (this.mNv == null || y.getCount(this.mNv.ON()) == 0) {
            return 0;
        }
        for (int i = 0; i < y.getCount(this.mNv.ON()); i++) {
            ImageFileInfo imageFileInfo = this.mNv.ON().get(i);
            if (imageFileInfo != null && imageFileInfo.getImageType() == 0) {
                return i;
            }
        }
        return 0;
    }

    private void n(Intent intent) {
        Intent intent2 = new Intent();
        intent2.putExtra("album_result", this.mNv.getWriteImagesInfo().toJsonString());
        intent2.putExtra("camera_request_from", this.requestFrom);
        intent2.putExtra("from_type", this.boE);
        if (intent != null && !StringUtils.isNull(intent.getStringExtra("file_name"))) {
            intent2.putExtra("file_name", intent.getStringExtra("file_name"));
        }
        this.mNG.setResult(-1, intent2);
        this.mNG.finish();
        if (AlbumActivityConfig.FROM_FLUTTER.equals(this.from)) {
            MessageManager.getInstance().sendMessage(new CustomMessage(2921464, intent2));
        }
    }

    @Override // com.baidu.tbadk.suspended.a
    public boolean buL() {
        if (this.mNH == null || this.mNH.dGe() == null || this.mNH.dGe().dGn() == null) {
            return true;
        }
        return this.mNH.dGe().dGn().getFirstVisiblePosition() == 0 && !this.mNH.dGe().dGn().canScrollVertically(-1);
    }

    @Override // com.baidu.tbadk.suspended.a
    public boolean buM() {
        return true;
    }

    @Override // com.baidu.tbadk.suspended.a
    public void qE(int i) {
        if (this.mNH != null) {
            this.mNH.onChangeSkinType(i);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void onSaveInstanceState(Bundle bundle) {
        bundle.putString("write_images_info", this.mNv.getWriteImagesInfo().toJsonString());
        bundle.putBoolean("use_original_img", this.boC);
        bundle.putInt("camera_request_from", this.requestFrom);
        bundle.putString("forum_id", this.forumId);
        bundle.putString("forum_name", this.forumName);
        bundle.putInt("album_thread", this.boB);
        bundle.putBoolean(IntentConfig.KEY_CAN_SELECT_VIDEO, this.mNK);
        bundle.putBoolean("from_write", this.boD);
        bundle.putSerializable("tab_list", this.mNM);
        bundle.putSerializable("anti_data", this.antiData);
        bundle.putSerializable("prefix_data", this.prefixData);
        bundle.putString("forum_first_dir", this.firstDir);
        bundle.putString("forum_second_dir", this.secondDir);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.mNH.OD()) {
            Oq();
        } else if (view == this.mNH.OF()) {
            Oq();
        } else if (view == this.mNH.OC()) {
            if (this.mNv != null) {
                this.mNv.setLastAlbumId(null);
            }
            Ox();
        } else if (view == this.mNH.OE()) {
            dv(0, this.mNE);
        } else if (view == this.mNH.OG()) {
            fl(2);
        } else if (view == this.mNH.OH()) {
            fl(1);
        }
    }

    private void Ox() {
        Intent intent = new Intent();
        String lastAlbumId = this.mNv.getLastAlbumId();
        if (TextUtils.isEmpty(lastAlbumId)) {
            lastAlbumId = "";
        }
        intent.putExtra("last_album_id", lastAlbumId);
        intent.putExtra("camera_request_from", this.requestFrom);
        this.mNG.setResult(0, intent);
        this.mNG.finish();
    }

    private void fl(int i) {
        if (this.mNH != null && this.mNv != null) {
            this.mNv.setOriginalImg(!this.mNv.isOriginalImg());
            Os();
            fm(i);
        }
    }

    public void Os() {
        if (this.mNv != null && this.mNH != null) {
            this.mNH.cz(this.mNv.isOriginalImg());
        }
    }

    private void fm(int i) {
        if (this.mNv != null && this.mNv.isOriginalImg() && !StringUtils.isNull(this.from, true) && !StringUtils.isNull(this.forumId, true)) {
            TiebaStatic.log(new aq("c10349").dD("fid", this.forumId).dD("obj_type", this.from).ai("obj_locate", i));
        }
    }

    @Override // com.baidu.tbadk.suspended.a
    public Intent buN() {
        return null;
    }

    public void e(ImageFileInfo imageFileInfo) {
        if (imageFileInfo != null) {
            Intent intent = new Intent();
            LinkedList<ImageFileInfo> linkedList = new LinkedList<>();
            linkedList.add(imageFileInfo);
            this.mNv.getWriteImagesInfo().setChosedFiles(linkedList);
            intent.putExtra("album_result", this.mNv.getWriteImagesInfo().toJsonString());
            intent.putExtra("camera_request_from", this.requestFrom);
            intent.putExtra("from_type", this.boE);
            this.mNG.setResult(-1, intent);
            this.mNG.finish();
        }
    }

    public c dGj() {
        return this.mNv;
    }

    public void g(TbPageContext tbPageContext) {
        PostPrefixData postPrefixData;
        AntiData antiData = null;
        if (!bSY() && com.baidu.tieba.write.j.dFU()) {
            RecordVideoActivityConfig recordVideoActivityConfig = new RecordVideoActivityConfig(tbPageContext.getPageActivity(), this.boD ? 2 : 3, new ForumWriteData(this.forumId, this.forumName, null, null), this.mNv.getWriteImagesInfo(), "", this.boE);
            recordVideoActivityConfig.setShowType(this.mNK ? 0 : 1);
            if (this.mNK) {
                String str = "";
                String str2 = "";
                if (this.mNG.getIntent() != null) {
                    Serializable serializableExtra = this.mNG.getIntent().getSerializableExtra("anti_data");
                    AntiData antiData2 = serializableExtra instanceof AntiData ? (AntiData) serializableExtra : null;
                    Serializable serializableExtra2 = this.mNG.getIntent().getSerializableExtra("prefix_data");
                    PostPrefixData postPrefixData2 = serializableExtra2 instanceof PostPrefixData ? (PostPrefixData) serializableExtra2 : null;
                    antiData = antiData2;
                    str = this.mNG.getIntent().getStringExtra("forum_first_dir");
                    postPrefixData = postPrefixData2;
                    str2 = this.mNG.getIntent().getStringExtra("forum_second_dir");
                } else {
                    postPrefixData = null;
                }
                recordVideoActivityConfig.setExtraData(antiData, postPrefixData, str, str2);
            }
            this.mNG.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, recordVideoActivityConfig));
            TiebaStatic.log(new aq(CommonStatisticKey.KEY_ENTRANCE_CLICKED).ai("obj_locate", 5).ai("obj_type", 2));
        }
    }

    private boolean bSY() {
        PermissionJudgePolicy permissionJudgePolicy = new PermissionJudgePolicy();
        permissionJudgePolicy.clearRequestPermissionList();
        permissionJudgePolicy.appendRequestPermission(this.mNG, PermissionRequest.RESOURCE_VIDEO_CAPTURE);
        permissionJudgePolicy.appendRequestPermission(this.mNG, PermissionRequest.RESOURCE_AUDIO_CAPTURE);
        permissionJudgePolicy.appendRequestPermission(this.mNG, "android.permission.WRITE_EXTERNAL_STORAGE");
        return permissionJudgePolicy.startRequestPermission(this.mNG);
    }

    public boolean f(ImageFileInfo imageFileInfo) {
        if (imageFileInfo == null) {
            return false;
        }
        this.mNv.a(null);
        this.mNv.delChooseFile(imageFileInfo);
        Os();
        return true;
    }

    public boolean g(ImageFileInfo imageFileInfo) {
        if (imageFileInfo == null) {
            return false;
        }
        int maxImagesAllowed = this.mNv.getMaxImagesAllowed();
        if (this.mNv.size() < maxImagesAllowed) {
            if (this.mNI == null || this.mNI.h(imageFileInfo)) {
                ImageFileInfo imageFileInfo2 = new ImageFileInfo();
                imageFileInfo2.setAlbumnId(imageFileInfo.getAlbumId());
                imageFileInfo2.setContentUriStr(imageFileInfo.getContentUriStr());
                imageFileInfo2.setFilePath(imageFileInfo.getFilePath());
                imageFileInfo2.setModifyTime(imageFileInfo.getModifyTime());
                imageFileInfo2.setIsGif(imageFileInfo.isGif());
                imageFileInfo2.setIsLong(imageFileInfo.isLong());
                this.mNv.a(null);
                this.mNv.addChooseFile(imageFileInfo2);
                Os();
                return true;
            }
            return false;
        } else if (Ow()) {
            return g(imageFileInfo);
        } else {
            this.mNG.showToast(String.format(this.mNG.getString(R.string.max_choose_image_count), Integer.valueOf(maxImagesAllowed)));
            return false;
        }
    }

    private boolean Ow() {
        if (this.mNG.getIntent().getBooleanExtra("select_directly", false)) {
            int maxImagesAllowed = this.mNv.getMaxImagesAllowed();
            if (this.mNv.size() == maxImagesAllowed && maxImagesAllowed == 1) {
                try {
                    ImageFileInfo imageFileInfo = (ImageFileInfo) y.getItem(this.mNv.ON(), 0);
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
        Fragment Jx;
        if (this.mNH != null && (Jx = this.mNH.Jx(0)) != null && (Jx instanceof ImageListFragment)) {
            ((ImageListFragment) Jx).f(imageFileInfo, z);
        }
    }

    private void h(ImageFileInfo imageFileInfo, boolean z) {
        Fragment Jx;
        if (this.mNH != null && (Jx = this.mNH.Jx(1)) != null && (Jx instanceof AlbumImageBrowseFragment)) {
            ((AlbumImageBrowseFragment) Jx).f(imageFileInfo, z);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void o(Intent intent) {
        this.mNO = intent;
        if (intent == null || this.mNv == null) {
            n(null);
            return;
        }
        String stringExtra = intent.getStringExtra("album_result");
        if (stringExtra != null) {
            WriteImagesInfo writeImagesInfo = this.mNv.getWriteImagesInfo();
            writeImagesInfo.parseJson(stringExtra);
            writeImagesInfo.updateQuality();
            n(intent);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void onBackClick() {
        this.mNG.closeLoadingDialog();
        if (this.aRM == 0) {
            if (this.mNv != null) {
                this.mNv.setLastAlbumId(null);
            }
            Ox();
        } else if (this.aRM == 1) {
            fn(0);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int Ou() {
        return this.boB;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean dGk() {
        return this.mNK;
    }

    private void stopCamera() {
        if (this.mNH != null) {
            this.mNH.stopCamera();
        }
    }

    private void WZ() {
        if (this.mNH != null) {
            this.mNH.WZ();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void onStart() {
        if (this.mNJ != null) {
            this.mNJ.onStart();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void onResume() {
        WZ();
        if (this.mNJ != null) {
            this.mNJ.onResume();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void onStop() {
        if (this.mNJ != null) {
            this.mNJ.onStop();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void onPause() {
        stopCamera();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void onDestroy() {
        this.boz = true;
        stopCamera();
        this.mNG.closeLoadingDialog();
        this.mNG.dismissAllDialog();
        d.dGg().destory();
        if (this.mNH != null) {
            this.mNH.onDestroy();
        }
        if (this.mNJ != null) {
            this.mNJ.onDestroy();
        }
        Intent intent = new Intent();
        intent.setAction(AlbumActivityConfig.ACTION_SELECT_IMAGE_RESULT);
        intent.putExtra("album_result", this.mNv.getWriteImagesInfo().toJsonString());
        intent.putExtra("camera_request_from", this.requestFrom);
        intent.putExtra("from_type", this.boE);
        if (this.mNO != null && !StringUtils.isNull(this.mNO.getStringExtra("file_name"))) {
            intent.putExtra("file_name", this.mNO.getStringExtra("file_name"));
        }
        TbadkCoreApplication.getInst().sendBroadcast(intent);
    }

    public void onRequestPermissionsResult(int i, @NonNull String[] strArr, @NonNull int[] iArr) {
        if (this.mNH != null) {
            this.mNH.dGd();
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
            new com.baidu.tbadk.img.f(null).c(e.this.mNv.getWriteImagesInfo(), true);
            return e.this.mNv.getWriteImagesInfo().toJsonString();
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPostExecute(String str) {
            Intent intent = new Intent();
            intent.putExtra("album_result", str);
            e.this.mNG.setResult(-1, intent);
            e.this.mNG.finish();
        }
    }
}
