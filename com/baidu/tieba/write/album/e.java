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
    private c mNd;
    private int mNm;
    private int mNn;
    private BaseFragmentActivity mNo;
    private com.baidu.tieba.write.album.a mNp;
    private f mNq;
    private j mNr;
    private FrsTabInfoData mNu;
    private Intent mNw;
    private int aRK = 0;
    private boolean bow = false;
    private String callFrom = "";
    private String from = "";
    private String forumName = "";
    private String forumId = "0";
    private int requestFrom = 0;
    private int boy = 0;
    private boolean mNs = false;
    private boolean mNt = true;
    private boolean boz = false;
    private boolean boA = false;
    private int boB = 0;
    private int mNv = -1;
    private PostPrefixData prefixData = null;
    private AntiData antiData = null;
    private String firstDir = "";
    private String secondDir = "";

    public e(BaseFragmentActivity baseFragmentActivity, Bundle bundle, int i, int i2) {
        a(baseFragmentActivity, i, i2);
        if (bundle == null) {
            aq(this.mNo.getIntent());
        } else {
            initData(bundle);
        }
        dv(0, this.mNm);
    }

    private void a(BaseFragmentActivity baseFragmentActivity, int i, int i2) {
        this.mNo = baseFragmentActivity;
        this.mNm = i;
        this.mNn = i2;
        this.mNp = new com.baidu.tieba.write.album.a(baseFragmentActivity.getPageContext(), this);
        this.mNp.OB();
    }

    private void initData(Bundle bundle) {
        this.mNd = new c(this.mNo.getPageContext());
        if (bundle != null) {
            WriteImagesInfo writeImagesInfo = new WriteImagesInfo();
            writeImagesInfo.parseJson(bundle.getString("write_images_info"));
            this.mNd.setWriteImagesInfo(writeImagesInfo);
            this.boz = bundle.getBoolean("use_original_img", false);
            this.requestFrom = bundle.getInt("camera_request_from", 0);
            this.forumId = bundle.getString("forum_id");
            this.forumName = bundle.getString("forum_name");
            this.boy = bundle.getInt("album_thread");
            this.mNs = bundle.getBoolean(IntentConfig.KEY_CAN_SELECT_VIDEO);
            this.boA = bundle.getBoolean("from_write");
            this.callFrom = bundle.getString("KEY_CALL_FROM");
            this.boB = bundle.getInt("from_type");
            this.mNu = (FrsTabInfoData) bundle.getSerializable("tab_list");
            this.from = bundle.getString("from");
            this.mNv = bundle.getInt(WriteActivityConfig.KEY_PROFESSION_ZONE, -1);
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
        this.mNd = new c(this.mNo.getPageContext());
        if (intent != null) {
            WriteImagesInfo writeImagesInfo = new WriteImagesInfo();
            writeImagesInfo.parseJson(intent.getStringExtra("write_images_info"));
            this.mNd.setWriteImagesInfo(writeImagesInfo);
            this.mNd.setOriginalImg(writeImagesInfo.isOriginalImg());
            this.boz = intent.getBooleanExtra("use_original_img", false);
            this.requestFrom = intent.getIntExtra("camera_request_from", 0);
            this.from = intent.getStringExtra("from");
            this.forumId = intent.getStringExtra("forum_id");
            this.forumName = intent.getStringExtra("forum_name");
            this.boy = intent.getIntExtra("album_thread", 0);
            this.mNs = intent.getBooleanExtra(IntentConfig.KEY_CAN_SELECT_VIDEO, false);
            this.mNt = intent.getBooleanExtra(IntentConfig.KEY_CAN_EDIT_IMAGE, true);
            this.boA = intent.getBooleanExtra("from_write", false);
            this.callFrom = intent.getStringExtra("KEY_CALL_FROM");
            this.boB = intent.getIntExtra("from_type", 0);
            this.mNu = (FrsTabInfoData) intent.getSerializableExtra("tab_list");
            this.mNv = intent.getIntExtra(WriteActivityConfig.KEY_PROFESSION_ZONE, -1);
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
            this.mNq = new f() { // from class: com.baidu.tieba.write.album.e.1
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
                    BdToast.a((Context) e.this.mNo, (CharSequence) e.this.mNo.getString(R.string.uploade_attation), R.drawable.icon_toast_game_error, false).bhm();
                    return false;
                }
            };
        }
    }

    public void a(NavigationBar navigationBar) {
        if (navigationBar != null) {
            this.mNp.a(navigationBar);
        }
    }

    public void fn(int i) {
        if (i == 1) {
            dv(i, this.mNn);
        } else {
            dv(i, this.mNm);
        }
    }

    private void dv(int i, int i2) {
        if (!this.bow) {
            FragmentTransaction beginTransaction = this.mNo.getSupportFragmentManager().beginTransaction();
            Fragment findFragmentByTag = this.mNo.getSupportFragmentManager().findFragmentByTag(this.mNp.Jy(this.aRK));
            if (findFragmentByTag != null) {
                beginTransaction.hide(findFragmentByTag);
            }
            this.aRK = i;
            if (this.mNo.getSupportFragmentManager().findFragmentByTag(this.mNp.Jy(i)) != null) {
                beginTransaction.show(this.mNp.Jx(i));
            } else {
                beginTransaction.add(i2, this.mNp.Jx(i), this.mNp.Jy(i));
            }
            beginTransaction.commitAllowingStateLoss();
            this.mNo.getSupportFragmentManager().executePendingTransactions();
        }
    }

    public void Oq() {
        if (this.requestFrom == 3) {
            TiebaStatic.log(TbadkCoreStatisticKey.UPGRADE_DIALOG_CHOOSE_IMAGE);
        }
        if (this.requestFrom == 5) {
            this.mNo.showLoadingDialog("正在上传");
            new a().execute(new String[0]);
        } else if (this.mNd != null) {
            if (this.mNr == null || !this.mNr.dGi()) {
                if (this.mNd.OL()) {
                    VideoFileInfo dFW = this.mNd.dFW();
                    if (this.mNr == null) {
                        this.mNr = new j(this.mNo, this.forumName, this.forumId, "");
                        this.mNr.b(this.mNu);
                        this.mNr.setExtraData(this.antiData, this.prefixData, this.firstDir, this.secondDir);
                        if (this.mNp != null) {
                            this.mNp.a(this.mNr);
                        }
                    }
                    this.mNr.setProfessionZone(this.mNv);
                    this.mNr.a(dFW, this.callFrom, this.from);
                } else if (this.mNt && dFY()) {
                    Or();
                } else {
                    n(null);
                }
            }
        }
    }

    private boolean dFY() {
        if (this.mNd == null || y.getCount(this.mNd.ON()) == 0) {
            return false;
        }
        int i = 0;
        for (ImageFileInfo imageFileInfo : this.mNd.ON()) {
            if (imageFileInfo != null && imageFileInfo.getImageType() == 0 && (i = i + 1) >= 2) {
                return false;
            }
            i = i;
        }
        return i == 1;
    }

    private void Or() {
        WriteImagesInfo writeImagesInfo;
        if (this.mNd != null && (writeImagesInfo = this.mNd.getWriteImagesInfo()) != null) {
            this.mNo.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new WriteMulitImageActivityConfig(this.mNo, RequestResponseCode.REQUEST_MOTU_IMAGE, writeImagesInfo, dFZ())));
        }
    }

    private int dFZ() {
        if (this.mNd == null || y.getCount(this.mNd.ON()) == 0) {
            return 0;
        }
        for (int i = 0; i < y.getCount(this.mNd.ON()); i++) {
            ImageFileInfo imageFileInfo = this.mNd.ON().get(i);
            if (imageFileInfo != null && imageFileInfo.getImageType() == 0) {
                return i;
            }
        }
        return 0;
    }

    private void n(Intent intent) {
        Intent intent2 = new Intent();
        intent2.putExtra("album_result", this.mNd.getWriteImagesInfo().toJsonString());
        intent2.putExtra("camera_request_from", this.requestFrom);
        intent2.putExtra("from_type", this.boB);
        if (intent != null && !StringUtils.isNull(intent.getStringExtra("file_name"))) {
            intent2.putExtra("file_name", intent.getStringExtra("file_name"));
        }
        this.mNo.setResult(-1, intent2);
        this.mNo.finish();
        if (AlbumActivityConfig.FROM_FLUTTER.equals(this.from)) {
            MessageManager.getInstance().sendMessage(new CustomMessage(2921464, intent2));
        }
    }

    @Override // com.baidu.tbadk.suspended.a
    public boolean buK() {
        if (this.mNp == null || this.mNp.dFV() == null || this.mNp.dFV().dGe() == null) {
            return true;
        }
        return this.mNp.dFV().dGe().getFirstVisiblePosition() == 0 && !this.mNp.dFV().dGe().canScrollVertically(-1);
    }

    @Override // com.baidu.tbadk.suspended.a
    public boolean buL() {
        return true;
    }

    @Override // com.baidu.tbadk.suspended.a
    public void qE(int i) {
        if (this.mNp != null) {
            this.mNp.onChangeSkinType(i);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void onSaveInstanceState(Bundle bundle) {
        bundle.putString("write_images_info", this.mNd.getWriteImagesInfo().toJsonString());
        bundle.putBoolean("use_original_img", this.boz);
        bundle.putInt("camera_request_from", this.requestFrom);
        bundle.putString("forum_id", this.forumId);
        bundle.putString("forum_name", this.forumName);
        bundle.putInt("album_thread", this.boy);
        bundle.putBoolean(IntentConfig.KEY_CAN_SELECT_VIDEO, this.mNs);
        bundle.putBoolean("from_write", this.boA);
        bundle.putSerializable("tab_list", this.mNu);
        bundle.putSerializable("anti_data", this.antiData);
        bundle.putSerializable("prefix_data", this.prefixData);
        bundle.putString("forum_first_dir", this.firstDir);
        bundle.putString("forum_second_dir", this.secondDir);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.mNp.OD()) {
            Oq();
        } else if (view == this.mNp.OF()) {
            Oq();
        } else if (view == this.mNp.OC()) {
            if (this.mNd != null) {
                this.mNd.setLastAlbumId(null);
            }
            Ox();
        } else if (view == this.mNp.OE()) {
            dv(0, this.mNm);
        } else if (view == this.mNp.OG()) {
            fl(2);
        } else if (view == this.mNp.OH()) {
            fl(1);
        }
    }

    private void Ox() {
        Intent intent = new Intent();
        String lastAlbumId = this.mNd.getLastAlbumId();
        if (TextUtils.isEmpty(lastAlbumId)) {
            lastAlbumId = "";
        }
        intent.putExtra("last_album_id", lastAlbumId);
        intent.putExtra("camera_request_from", this.requestFrom);
        this.mNo.setResult(0, intent);
        this.mNo.finish();
    }

    private void fl(int i) {
        if (this.mNp != null && this.mNd != null) {
            this.mNd.setOriginalImg(!this.mNd.isOriginalImg());
            Os();
            fm(i);
        }
    }

    public void Os() {
        if (this.mNd != null && this.mNp != null) {
            this.mNp.cy(this.mNd.isOriginalImg());
        }
    }

    private void fm(int i) {
        if (this.mNd != null && this.mNd.isOriginalImg() && !StringUtils.isNull(this.from, true) && !StringUtils.isNull(this.forumId, true)) {
            TiebaStatic.log(new aq("c10349").dD("fid", this.forumId).dD("obj_type", this.from).ai("obj_locate", i));
        }
    }

    @Override // com.baidu.tbadk.suspended.a
    public Intent buM() {
        return null;
    }

    public void e(ImageFileInfo imageFileInfo) {
        if (imageFileInfo != null) {
            Intent intent = new Intent();
            LinkedList<ImageFileInfo> linkedList = new LinkedList<>();
            linkedList.add(imageFileInfo);
            this.mNd.getWriteImagesInfo().setChosedFiles(linkedList);
            intent.putExtra("album_result", this.mNd.getWriteImagesInfo().toJsonString());
            intent.putExtra("camera_request_from", this.requestFrom);
            intent.putExtra("from_type", this.boB);
            this.mNo.setResult(-1, intent);
            this.mNo.finish();
        }
    }

    public c dGa() {
        return this.mNd;
    }

    public void g(TbPageContext tbPageContext) {
        PostPrefixData postPrefixData;
        AntiData antiData = null;
        if (!bSX() && com.baidu.tieba.write.j.dFL()) {
            RecordVideoActivityConfig recordVideoActivityConfig = new RecordVideoActivityConfig(tbPageContext.getPageActivity(), this.boA ? 2 : 3, new ForumWriteData(this.forumId, this.forumName, null, null), this.mNd.getWriteImagesInfo(), "", this.boB);
            recordVideoActivityConfig.setShowType(this.mNs ? 0 : 1);
            if (this.mNs) {
                String str = "";
                String str2 = "";
                if (this.mNo.getIntent() != null) {
                    Serializable serializableExtra = this.mNo.getIntent().getSerializableExtra("anti_data");
                    AntiData antiData2 = serializableExtra instanceof AntiData ? (AntiData) serializableExtra : null;
                    Serializable serializableExtra2 = this.mNo.getIntent().getSerializableExtra("prefix_data");
                    PostPrefixData postPrefixData2 = serializableExtra2 instanceof PostPrefixData ? (PostPrefixData) serializableExtra2 : null;
                    antiData = antiData2;
                    str = this.mNo.getIntent().getStringExtra("forum_first_dir");
                    postPrefixData = postPrefixData2;
                    str2 = this.mNo.getIntent().getStringExtra("forum_second_dir");
                } else {
                    postPrefixData = null;
                }
                recordVideoActivityConfig.setExtraData(antiData, postPrefixData, str, str2);
            }
            this.mNo.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, recordVideoActivityConfig));
            TiebaStatic.log(new aq(CommonStatisticKey.KEY_ENTRANCE_CLICKED).ai("obj_locate", 5).ai("obj_type", 2));
        }
    }

    private boolean bSX() {
        PermissionJudgePolicy permissionJudgePolicy = new PermissionJudgePolicy();
        permissionJudgePolicy.clearRequestPermissionList();
        permissionJudgePolicy.appendRequestPermission(this.mNo, PermissionRequest.RESOURCE_VIDEO_CAPTURE);
        permissionJudgePolicy.appendRequestPermission(this.mNo, PermissionRequest.RESOURCE_AUDIO_CAPTURE);
        permissionJudgePolicy.appendRequestPermission(this.mNo, "android.permission.WRITE_EXTERNAL_STORAGE");
        return permissionJudgePolicy.startRequestPermission(this.mNo);
    }

    public boolean f(ImageFileInfo imageFileInfo) {
        if (imageFileInfo == null) {
            return false;
        }
        this.mNd.a(null);
        this.mNd.delChooseFile(imageFileInfo);
        Os();
        return true;
    }

    public boolean g(ImageFileInfo imageFileInfo) {
        if (imageFileInfo == null) {
            return false;
        }
        int maxImagesAllowed = this.mNd.getMaxImagesAllowed();
        if (this.mNd.size() < maxImagesAllowed) {
            if (this.mNq == null || this.mNq.h(imageFileInfo)) {
                ImageFileInfo imageFileInfo2 = new ImageFileInfo();
                imageFileInfo2.setAlbumnId(imageFileInfo.getAlbumId());
                imageFileInfo2.setContentUriStr(imageFileInfo.getContentUriStr());
                imageFileInfo2.setFilePath(imageFileInfo.getFilePath());
                imageFileInfo2.setModifyTime(imageFileInfo.getModifyTime());
                imageFileInfo2.setIsGif(imageFileInfo.isGif());
                imageFileInfo2.setIsLong(imageFileInfo.isLong());
                this.mNd.a(null);
                this.mNd.addChooseFile(imageFileInfo2);
                Os();
                return true;
            }
            return false;
        } else if (Ow()) {
            return g(imageFileInfo);
        } else {
            this.mNo.showToast(String.format(this.mNo.getString(R.string.max_choose_image_count), Integer.valueOf(maxImagesAllowed)));
            return false;
        }
    }

    private boolean Ow() {
        if (this.mNo.getIntent().getBooleanExtra("select_directly", false)) {
            int maxImagesAllowed = this.mNd.getMaxImagesAllowed();
            if (this.mNd.size() == maxImagesAllowed && maxImagesAllowed == 1) {
                try {
                    ImageFileInfo imageFileInfo = (ImageFileInfo) y.getItem(this.mNd.ON(), 0);
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
        if (this.mNp != null && (Jx = this.mNp.Jx(0)) != null && (Jx instanceof ImageListFragment)) {
            ((ImageListFragment) Jx).f(imageFileInfo, z);
        }
    }

    private void h(ImageFileInfo imageFileInfo, boolean z) {
        Fragment Jx;
        if (this.mNp != null && (Jx = this.mNp.Jx(1)) != null && (Jx instanceof AlbumImageBrowseFragment)) {
            ((AlbumImageBrowseFragment) Jx).f(imageFileInfo, z);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void o(Intent intent) {
        this.mNw = intent;
        if (intent == null || this.mNd == null) {
            n(null);
            return;
        }
        String stringExtra = intent.getStringExtra("album_result");
        if (stringExtra != null) {
            WriteImagesInfo writeImagesInfo = this.mNd.getWriteImagesInfo();
            writeImagesInfo.parseJson(stringExtra);
            writeImagesInfo.updateQuality();
            n(intent);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void onBackClick() {
        this.mNo.closeLoadingDialog();
        if (this.aRK == 0) {
            if (this.mNd != null) {
                this.mNd.setLastAlbumId(null);
            }
            Ox();
        } else if (this.aRK == 1) {
            fn(0);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int Ou() {
        return this.boy;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean dGb() {
        return this.mNs;
    }

    private void stopCamera() {
        if (this.mNp != null) {
            this.mNp.stopCamera();
        }
    }

    private void WZ() {
        if (this.mNp != null) {
            this.mNp.WZ();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void onStart() {
        if (this.mNr != null) {
            this.mNr.onStart();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void onResume() {
        WZ();
        if (this.mNr != null) {
            this.mNr.onResume();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void onStop() {
        if (this.mNr != null) {
            this.mNr.onStop();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void onPause() {
        stopCamera();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void onDestroy() {
        this.bow = true;
        stopCamera();
        this.mNo.closeLoadingDialog();
        this.mNo.dismissAllDialog();
        d.dFX().destory();
        if (this.mNp != null) {
            this.mNp.onDestroy();
        }
        if (this.mNr != null) {
            this.mNr.onDestroy();
        }
        Intent intent = new Intent();
        intent.setAction(AlbumActivityConfig.ACTION_SELECT_IMAGE_RESULT);
        intent.putExtra("album_result", this.mNd.getWriteImagesInfo().toJsonString());
        intent.putExtra("camera_request_from", this.requestFrom);
        intent.putExtra("from_type", this.boB);
        if (this.mNw != null && !StringUtils.isNull(this.mNw.getStringExtra("file_name"))) {
            intent.putExtra("file_name", this.mNw.getStringExtra("file_name"));
        }
        TbadkCoreApplication.getInst().sendBroadcast(intent);
    }

    public void onRequestPermissionsResult(int i, @NonNull String[] strArr, @NonNull int[] iArr) {
        if (this.mNp != null) {
            this.mNp.dFU();
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
            new com.baidu.tbadk.img.f(null).c(e.this.mNd.getWriteImagesInfo(), true);
            return e.this.mNd.getWriteImagesInfo().toJsonString();
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPostExecute(String str) {
            Intent intent = new Intent();
            intent.putExtra("album_result", str);
            e.this.mNo.setResult(-1, intent);
            e.this.mNo.finish();
        }
    }
}
