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
    private c nmQ;
    private int nmZ;
    private int nna;
    private BaseFragmentActivity nnb;
    private com.baidu.tieba.write.album.a nnc;
    private f nnd;
    private j nne;
    private FrsTabInfoData nnh;
    private Intent nnj;
    private int aXa = 0;
    private boolean bvw = false;
    private String callFrom = "";
    private String from = "";
    private String forumName = "";
    private String forumId = "0";
    private int requestFrom = 0;
    private int bvy = 0;
    private boolean nnf = false;
    private boolean nng = true;
    private boolean bvz = false;
    private boolean bvA = false;
    private int bvB = 0;
    private int nni = -1;
    private PostPrefixData prefixData = null;
    private AntiData antiData = null;
    private String firstDir = "";
    private String secondDir = "";

    public e(BaseFragmentActivity baseFragmentActivity, Bundle bundle, int i, int i2) {
        a(baseFragmentActivity, i, i2);
        if (bundle == null) {
            an(this.nnb.getIntent());
        } else {
            initData(bundle);
        }
        dz(0, this.nmZ);
    }

    private void a(BaseFragmentActivity baseFragmentActivity, int i, int i2) {
        this.nnb = baseFragmentActivity;
        this.nmZ = i;
        this.nna = i2;
        this.nnc = new com.baidu.tieba.write.album.a(baseFragmentActivity.getPageContext(), this);
        this.nnc.Qj();
    }

    private void initData(Bundle bundle) {
        this.nmQ = new c(this.nnb.getPageContext());
        if (bundle != null) {
            WriteImagesInfo writeImagesInfo = new WriteImagesInfo();
            writeImagesInfo.parseJson(bundle.getString("write_images_info"));
            this.nmQ.setWriteImagesInfo(writeImagesInfo);
            this.bvz = bundle.getBoolean("use_original_img", false);
            this.requestFrom = bundle.getInt("camera_request_from", 0);
            this.forumId = bundle.getString("forum_id");
            this.forumName = bundle.getString("forum_name");
            this.bvy = bundle.getInt("album_thread");
            this.nnf = bundle.getBoolean(IntentConfig.KEY_CAN_SELECT_VIDEO);
            this.bvA = bundle.getBoolean("from_write");
            this.callFrom = bundle.getString("KEY_CALL_FROM");
            this.bvB = bundle.getInt("from_type");
            this.nnh = (FrsTabInfoData) bundle.getSerializable("tab_list");
            this.from = bundle.getString("from");
            this.nni = bundle.getInt(WriteActivityConfig.KEY_PROFESSION_ZONE, -1);
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
        PX();
    }

    private void an(Intent intent) {
        this.nmQ = new c(this.nnb.getPageContext());
        if (intent != null) {
            WriteImagesInfo writeImagesInfo = new WriteImagesInfo();
            writeImagesInfo.parseJson(intent.getStringExtra("write_images_info"));
            this.nmQ.setWriteImagesInfo(writeImagesInfo);
            this.nmQ.setOriginalImg(writeImagesInfo.isOriginalImg());
            this.bvz = intent.getBooleanExtra("use_original_img", false);
            this.requestFrom = intent.getIntExtra("camera_request_from", 0);
            this.from = intent.getStringExtra("from");
            this.forumId = intent.getStringExtra("forum_id");
            this.forumName = intent.getStringExtra("forum_name");
            this.bvy = intent.getIntExtra("album_thread", 0);
            this.nnf = intent.getBooleanExtra(IntentConfig.KEY_CAN_SELECT_VIDEO, false);
            this.nng = intent.getBooleanExtra(IntentConfig.KEY_CAN_EDIT_IMAGE, true);
            this.bvA = intent.getBooleanExtra("from_write", false);
            this.callFrom = intent.getStringExtra("KEY_CALL_FROM");
            this.bvB = intent.getIntExtra("from_type", 0);
            this.nnh = (FrsTabInfoData) intent.getSerializableExtra("tab_list");
            this.nni = intent.getIntExtra(WriteActivityConfig.KEY_PROFESSION_ZONE, -1);
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
        PX();
    }

    private void PX() {
        if (this.requestFrom == 2) {
            this.nnd = new f() { // from class: com.baidu.tieba.write.album.e.1
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
                    BdToast.a((Context) e.this.nnb, (CharSequence) e.this.nnb.getString(R.string.uploade_attation), R.drawable.icon_toast_game_error, false).bkP();
                    return false;
                }
            };
        }
    }

    public void a(NavigationBar navigationBar) {
        if (navigationBar != null) {
            this.nnc.a(navigationBar);
        }
    }

    public void fH(int i) {
        if (i == 1) {
            dz(i, this.nna);
        } else {
            dz(i, this.nmZ);
        }
    }

    private void dz(int i, int i2) {
        if (!this.bvw) {
            FragmentTransaction beginTransaction = this.nnb.getSupportFragmentManager().beginTransaction();
            Fragment findFragmentByTag = this.nnb.getSupportFragmentManager().findFragmentByTag(this.nnc.KI(this.aXa));
            if (findFragmentByTag != null) {
                beginTransaction.hide(findFragmentByTag);
            }
            this.aXa = i;
            if (this.nnb.getSupportFragmentManager().findFragmentByTag(this.nnc.KI(i)) != null) {
                beginTransaction.show(this.nnc.KH(i));
            } else {
                beginTransaction.add(i2, this.nnc.KH(i), this.nnc.KI(i));
            }
            beginTransaction.commitAllowingStateLoss();
            this.nnb.getSupportFragmentManager().executePendingTransactions();
        }
    }

    public void PY() {
        if (this.requestFrom == 3) {
            TiebaStatic.log(TbadkCoreStatisticKey.UPGRADE_DIALOG_CHOOSE_IMAGE);
        }
        if (this.requestFrom == 5) {
            this.nnb.showLoadingDialog("正在上传");
            new a().execute(new String[0]);
        } else if (this.nmQ != null) {
            if (this.nne == null || !this.nne.dNX()) {
                if (this.nmQ.Qt()) {
                    VideoFileInfo dNL = this.nmQ.dNL();
                    if (this.nne == null) {
                        this.nne = new j(this.nnb, this.forumName, this.forumId, "");
                        this.nne.b(this.nnh);
                        this.nne.setExtraData(this.antiData, this.prefixData, this.firstDir, this.secondDir);
                        if (this.nnc != null) {
                            this.nnc.a(this.nne);
                        }
                    }
                    this.nne.setProfessionZone(this.nni);
                    this.nne.a(dNL, this.callFrom, this.from);
                } else if (this.nng && dNN()) {
                    PZ();
                } else {
                    n(null);
                }
            }
        }
    }

    private boolean dNN() {
        if (this.nmQ == null || y.getCount(this.nmQ.Qv()) == 0) {
            return false;
        }
        int i = 0;
        for (ImageFileInfo imageFileInfo : this.nmQ.Qv()) {
            if (imageFileInfo != null && imageFileInfo.getImageType() == 0 && (i = i + 1) >= 2) {
                return false;
            }
            i = i;
        }
        return i == 1;
    }

    private void PZ() {
        WriteImagesInfo writeImagesInfo;
        if (this.nmQ != null && (writeImagesInfo = this.nmQ.getWriteImagesInfo()) != null) {
            this.nnb.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new WriteMulitImageActivityConfig(this.nnb, RequestResponseCode.REQUEST_MOTU_IMAGE, writeImagesInfo, dNO())));
        }
    }

    private int dNO() {
        if (this.nmQ == null || y.getCount(this.nmQ.Qv()) == 0) {
            return 0;
        }
        for (int i = 0; i < y.getCount(this.nmQ.Qv()); i++) {
            ImageFileInfo imageFileInfo = this.nmQ.Qv().get(i);
            if (imageFileInfo != null && imageFileInfo.getImageType() == 0) {
                return i;
            }
        }
        return 0;
    }

    private void n(Intent intent) {
        Intent intent2 = new Intent();
        intent2.putExtra("album_result", this.nmQ.getWriteImagesInfo().toJsonString());
        intent2.putExtra("camera_request_from", this.requestFrom);
        intent2.putExtra("from_type", this.bvB);
        if (intent != null && !StringUtils.isNull(intent.getStringExtra("file_name"))) {
            intent2.putExtra("file_name", intent.getStringExtra("file_name"));
        }
        this.nnb.setResult(-1, intent2);
        this.nnb.finish();
        if (AlbumActivityConfig.FROM_FLUTTER.equals(this.from)) {
            MessageManager.getInstance().sendMessage(new CustomMessage(2921464, intent2));
        }
    }

    @Override // com.baidu.tbadk.suspended.a
    public boolean byz() {
        if (this.nnc == null || this.nnc.dNK() == null || this.nnc.dNK().dNT() == null) {
            return true;
        }
        return this.nnc.dNK().dNT().getFirstVisiblePosition() == 0 && !this.nnc.dNK().dNT().canScrollVertically(-1);
    }

    @Override // com.baidu.tbadk.suspended.a
    public boolean byA() {
        return true;
    }

    @Override // com.baidu.tbadk.suspended.a
    public void rt(int i) {
        if (this.nnc != null) {
            this.nnc.onChangeSkinType(i);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void onSaveInstanceState(Bundle bundle) {
        bundle.putString("write_images_info", this.nmQ.getWriteImagesInfo().toJsonString());
        bundle.putBoolean("use_original_img", this.bvz);
        bundle.putInt("camera_request_from", this.requestFrom);
        bundle.putString("forum_id", this.forumId);
        bundle.putString("forum_name", this.forumName);
        bundle.putInt("album_thread", this.bvy);
        bundle.putBoolean(IntentConfig.KEY_CAN_SELECT_VIDEO, this.nnf);
        bundle.putBoolean("from_write", this.bvA);
        bundle.putSerializable("tab_list", this.nnh);
        bundle.putSerializable("anti_data", this.antiData);
        bundle.putSerializable("prefix_data", this.prefixData);
        bundle.putString("forum_first_dir", this.firstDir);
        bundle.putString("forum_second_dir", this.secondDir);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.nnc.Ql()) {
            PY();
        } else if (view == this.nnc.Qn()) {
            PY();
        } else if (view == this.nnc.Qk()) {
            if (this.nmQ != null) {
                this.nmQ.setLastAlbumId(null);
            }
            Qf();
        } else if (view == this.nnc.Qm()) {
            dz(0, this.nmZ);
        } else if (view == this.nnc.Qo()) {
            fF(2);
        } else if (view == this.nnc.Qp()) {
            fF(1);
        }
    }

    private void Qf() {
        Intent intent = new Intent();
        String lastAlbumId = this.nmQ.getLastAlbumId();
        if (TextUtils.isEmpty(lastAlbumId)) {
            lastAlbumId = "";
        }
        intent.putExtra("last_album_id", lastAlbumId);
        intent.putExtra("camera_request_from", this.requestFrom);
        this.nnb.setResult(0, intent);
        this.nnb.finish();
    }

    private void fF(int i) {
        if (this.nnc != null && this.nmQ != null) {
            this.nmQ.setOriginalImg(!this.nmQ.isOriginalImg());
            Qa();
            fG(i);
        }
    }

    public void Qa() {
        if (this.nmQ != null && this.nnc != null) {
            this.nnc.cD(this.nmQ.isOriginalImg());
        }
    }

    private void fG(int i) {
        if (this.nmQ != null && this.nmQ.isOriginalImg() && !StringUtils.isNull(this.from, true) && !StringUtils.isNull(this.forumId, true)) {
            TiebaStatic.log(new aq("c10349").dK("fid", this.forumId).dK("obj_type", this.from).aj("obj_locate", i));
        }
    }

    @Override // com.baidu.tbadk.suspended.a
    public Intent byB() {
        return null;
    }

    public void e(ImageFileInfo imageFileInfo) {
        if (imageFileInfo != null) {
            Intent intent = new Intent();
            LinkedList<ImageFileInfo> linkedList = new LinkedList<>();
            linkedList.add(imageFileInfo);
            this.nmQ.getWriteImagesInfo().setChosedFiles(linkedList);
            intent.putExtra("album_result", this.nmQ.getWriteImagesInfo().toJsonString());
            intent.putExtra("camera_request_from", this.requestFrom);
            intent.putExtra("from_type", this.bvB);
            this.nnb.setResult(-1, intent);
            this.nnb.finish();
        }
    }

    public c dNP() {
        return this.nmQ;
    }

    public void g(TbPageContext tbPageContext) {
        PostPrefixData postPrefixData;
        AntiData antiData = null;
        if (!bYc() && com.baidu.tieba.write.j.dNA()) {
            RecordVideoActivityConfig recordVideoActivityConfig = new RecordVideoActivityConfig(tbPageContext.getPageActivity(), this.bvA ? 2 : 3, new ForumWriteData(this.forumId, this.forumName, null, null), this.nmQ.getWriteImagesInfo(), "", this.bvB);
            recordVideoActivityConfig.setShowType(this.nnf ? 0 : 1);
            if (this.nnf) {
                String str = "";
                String str2 = "";
                if (this.nnb.getIntent() != null) {
                    Serializable serializableExtra = this.nnb.getIntent().getSerializableExtra("anti_data");
                    AntiData antiData2 = serializableExtra instanceof AntiData ? (AntiData) serializableExtra : null;
                    Serializable serializableExtra2 = this.nnb.getIntent().getSerializableExtra("prefix_data");
                    PostPrefixData postPrefixData2 = serializableExtra2 instanceof PostPrefixData ? (PostPrefixData) serializableExtra2 : null;
                    antiData = antiData2;
                    str = this.nnb.getIntent().getStringExtra("forum_first_dir");
                    postPrefixData = postPrefixData2;
                    str2 = this.nnb.getIntent().getStringExtra("forum_second_dir");
                } else {
                    postPrefixData = null;
                }
                recordVideoActivityConfig.setExtraData(antiData, postPrefixData, str, str2);
            }
            this.nnb.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, recordVideoActivityConfig));
            TiebaStatic.log(new aq(CommonStatisticKey.KEY_ENTRANCE_CLICKED).aj("obj_locate", 5).aj("obj_type", 2));
        }
    }

    private boolean bYc() {
        PermissionJudgePolicy permissionJudgePolicy = new PermissionJudgePolicy();
        permissionJudgePolicy.clearRequestPermissionList();
        permissionJudgePolicy.appendRequestPermission(this.nnb, PermissionRequest.RESOURCE_VIDEO_CAPTURE);
        permissionJudgePolicy.appendRequestPermission(this.nnb, PermissionRequest.RESOURCE_AUDIO_CAPTURE);
        permissionJudgePolicy.appendRequestPermission(this.nnb, "android.permission.WRITE_EXTERNAL_STORAGE");
        return permissionJudgePolicy.startRequestPermission(this.nnb);
    }

    public boolean f(ImageFileInfo imageFileInfo) {
        if (imageFileInfo == null) {
            return false;
        }
        this.nmQ.a(null);
        this.nmQ.delChooseFile(imageFileInfo);
        Qa();
        return true;
    }

    public boolean g(ImageFileInfo imageFileInfo) {
        if (imageFileInfo == null) {
            return false;
        }
        int maxImagesAllowed = this.nmQ.getMaxImagesAllowed();
        if (this.nmQ.size() < maxImagesAllowed) {
            if (this.nnd == null || this.nnd.h(imageFileInfo)) {
                ImageFileInfo imageFileInfo2 = new ImageFileInfo();
                imageFileInfo2.setAlbumnId(imageFileInfo.getAlbumId());
                imageFileInfo2.setContentUriStr(imageFileInfo.getContentUriStr());
                imageFileInfo2.setFilePath(imageFileInfo.getFilePath());
                imageFileInfo2.setModifyTime(imageFileInfo.getModifyTime());
                imageFileInfo2.setIsGif(imageFileInfo.isGif());
                imageFileInfo2.setIsLong(imageFileInfo.isLong());
                this.nmQ.a(null);
                this.nmQ.addChooseFile(imageFileInfo2);
                Qa();
                return true;
            }
            return false;
        } else if (Qe()) {
            return g(imageFileInfo);
        } else {
            this.nnb.showToast(String.format(this.nnb.getString(R.string.max_choose_image_count), Integer.valueOf(maxImagesAllowed)));
            return false;
        }
    }

    private boolean Qe() {
        if (this.nnb.getIntent().getBooleanExtra("select_directly", false)) {
            int maxImagesAllowed = this.nmQ.getMaxImagesAllowed();
            if (this.nmQ.size() == maxImagesAllowed && maxImagesAllowed == 1) {
                try {
                    ImageFileInfo imageFileInfo = (ImageFileInfo) y.getItem(this.nmQ.Qv(), 0);
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
        Fragment KH;
        if (this.nnc != null && (KH = this.nnc.KH(0)) != null && (KH instanceof ImageListFragment)) {
            ((ImageListFragment) KH).f(imageFileInfo, z);
        }
    }

    private void h(ImageFileInfo imageFileInfo, boolean z) {
        Fragment KH;
        if (this.nnc != null && (KH = this.nnc.KH(1)) != null && (KH instanceof AlbumImageBrowseFragment)) {
            ((AlbumImageBrowseFragment) KH).f(imageFileInfo, z);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void o(Intent intent) {
        this.nnj = intent;
        if (intent == null || this.nmQ == null) {
            n(null);
            return;
        }
        String stringExtra = intent.getStringExtra("album_result");
        if (stringExtra != null) {
            WriteImagesInfo writeImagesInfo = this.nmQ.getWriteImagesInfo();
            writeImagesInfo.parseJson(stringExtra);
            writeImagesInfo.updateQuality();
            n(intent);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void onBackClick() {
        this.nnb.closeLoadingDialog();
        if (this.aXa == 0) {
            if (this.nmQ != null) {
                this.nmQ.setLastAlbumId(null);
            }
            Qf();
        } else if (this.aXa == 1) {
            fH(0);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int Qc() {
        return this.bvy;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean dNQ() {
        return this.nnf;
    }

    private void stopCamera() {
        if (this.nnc != null) {
            this.nnc.stopCamera();
        }
    }

    private void openCamera() {
        if (this.nnc != null) {
            this.nnc.openCamera();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void onStart() {
        if (this.nne != null) {
            this.nne.onStart();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void onResume() {
        openCamera();
        if (this.nne != null) {
            this.nne.onResume();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void onStop() {
        if (this.nne != null) {
            this.nne.onStop();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void onPause() {
        stopCamera();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void onDestroy() {
        this.bvw = true;
        stopCamera();
        this.nnb.closeLoadingDialog();
        this.nnb.dismissAllDialog();
        d.dNM().destory();
        if (this.nnc != null) {
            this.nnc.onDestroy();
        }
        if (this.nne != null) {
            this.nne.onDestroy();
        }
        Intent intent = new Intent();
        intent.setAction(AlbumActivityConfig.ACTION_SELECT_IMAGE_RESULT);
        intent.putExtra("album_result", this.nmQ.getWriteImagesInfo().toJsonString());
        intent.putExtra("camera_request_from", this.requestFrom);
        intent.putExtra("from_type", this.bvB);
        if (this.nnj != null && !StringUtils.isNull(this.nnj.getStringExtra("file_name"))) {
            intent.putExtra("file_name", this.nnj.getStringExtra("file_name"));
        }
        TbadkCoreApplication.getInst().sendBroadcast(intent);
    }

    public void onRequestPermissionsResult(int i, @NonNull String[] strArr, @NonNull int[] iArr) {
        if (this.nnc != null) {
            this.nnc.dNJ();
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
            new com.baidu.tbadk.img.f(null).c(e.this.nmQ.getWriteImagesInfo(), true);
            return e.this.nmQ.getWriteImagesInfo().toJsonString();
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPostExecute(String str) {
            Intent intent = new Intent();
            intent.putExtra("album_result", str);
            e.this.nnb.setResult(-1, intent);
            e.this.nnb.finish();
        }
    }
}
