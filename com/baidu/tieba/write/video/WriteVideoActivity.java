package com.baidu.tieba.write.video;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.location.Address;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.GestureDetector;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.TextView;
import com.baidu.adp.base.BdBaseApplication;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.c.a;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.live.tbadk.core.data.RequestResponseCode;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.live.tbadk.core.sharedpref.SharedPrefConfig;
import com.baidu.tbadk.ActivityPendingTransitionFactory;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.AccountAccessActivityConfig;
import com.baidu.tbadk.core.atomData.AlbumActivityConfig;
import com.baidu.tbadk.core.atomData.MotuVideoConfig;
import com.baidu.tbadk.core.atomData.NewVcodeActivityConfig;
import com.baidu.tbadk.core.atomData.VcodeActivityConfig;
import com.baidu.tbadk.core.atomData.WriteVideoActivityConfig;
import com.baidu.tbadk.core.data.AntiData;
import com.baidu.tbadk.core.dialog.a;
import com.baidu.tbadk.core.dialog.c;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.ae;
import com.baidu.tbadk.core.util.ar;
import com.baidu.tbadk.core.util.n;
import com.baidu.tbadk.core.util.y;
import com.baidu.tbadk.core.util.z;
import com.baidu.tbadk.coreExtra.data.VideoInfo;
import com.baidu.tbadk.coreExtra.data.WriteData;
import com.baidu.tbadk.coreExtra.data.ah;
import com.baidu.tbadk.coreExtra.model.g;
import com.baidu.tbadk.util.ac;
import com.baidu.tbadk.util.ad;
import com.baidu.tbadk.util.m;
import com.baidu.tieba.R;
import com.baidu.tieba.frs.FrsTabInfoData;
import com.baidu.tieba.frs.FrsTabItemData;
import com.baidu.tieba.l.e;
import com.baidu.tieba.l.l;
import com.baidu.tieba.tbadkCore.c.a;
import com.baidu.tieba.tbadkCore.util.AntiHelper;
import com.baidu.tieba.tbadkCore.writeModel.NewWriteModel;
import com.baidu.tieba.tbadkCore.writeModel.PostWriteCallBackData;
import com.baidu.tieba.video.VideoTitleData;
import com.baidu.tieba.write.b.a;
import com.baidu.tieba.write.b.c.b;
import com.baidu.tieba.write.upload.BaseUploadData;
import com.baidu.tieba.write.upload.VideoUploadData;
import java.io.File;
import java.io.Serializable;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
/* loaded from: classes3.dex */
public class WriteVideoActivity extends BaseActivity<WriteVideoActivity> {
    private final NewWriteModel.d fwI;
    private NewWriteModel fwu;
    private DialogInterface.OnCancelListener iJM;
    private c jvY;
    private String lLC;
    private e.a lmf;
    private String mFrom;
    private String mFromForumId;
    private InputMethodManager mInputManager;
    public String mLat;
    public String mLng;
    private VideoTitleData mVideoTitleData;
    private List<VideoTitleData> nCA;
    private int nCx;
    private FrsTabInfoData nCy;
    private String nCz;
    private b nYZ;
    private GestureDetector nZa;
    private int nZb;
    private VideoTitleData nZd;
    private e nZe;
    private boolean nZf;
    private Runnable nZh;
    private Runnable nZi;
    private a.InterfaceC0869a npV;
    private l npZ;
    private final WriteData nbc = new WriteData();
    private Runnable nZc = new Runnable() { // from class: com.baidu.tieba.write.video.WriteVideoActivity.1
        @Override // java.lang.Runnable
        public void run() {
            Intent intent = new Intent(MotuVideoConfig.ACTION_FINISH_VIDEO_ALL_ACTIVITY);
            intent.setPackage(TbadkCoreApplication.getInst().getPackageName());
            WriteVideoActivity.this.getPageContext().getPageActivity().sendBroadcast(intent);
        }
    };
    private String jzq = "0";
    private boolean nZg = false;

    public WriteVideoActivity() {
        CustomResponsedMessage runTask = MessageManager.getInstance().runTask(CmdConfigCustom.CMD_GET_VIDEO_PLATFORM_FACTORY, l.class);
        if (runTask != null) {
            this.npZ = (l) runTask.getData();
        }
        this.lmf = new e.a() { // from class: com.baidu.tieba.write.video.WriteVideoActivity.8
            @Override // com.baidu.tieba.l.e.a
            public void Gd(int i) {
                if (i != 1) {
                    WriteVideoActivity.this.nZf = true;
                    return;
                }
                ar arVar = new ar("c12620");
                arVar.al("obj_locate", 0);
                TiebaStatic.log(arVar);
            }

            @Override // com.baidu.tieba.l.e.a
            public void onChange(boolean z) {
            }

            @Override // com.baidu.tieba.l.e.a
            public void tP(boolean z) {
                WriteVideoActivity.this.nZf = true;
                ar arVar = new ar("c12621");
                arVar.al("obj_locate", 0);
                arVar.al("obj_param1", z ? 1 : 0);
                TiebaStatic.log(arVar);
            }
        };
        this.nZh = new Runnable() { // from class: com.baidu.tieba.write.video.WriteVideoActivity.11
            @Override // java.lang.Runnable
            public void run() {
                if (!g.bAe() || WriteVideoActivity.this.nZe == null || WriteVideoActivity.this.nZf) {
                    if (WriteVideoActivity.this.fwu != null) {
                        WriteVideoActivity.this.fwu.dQD();
                        return;
                    }
                    return;
                }
                com.baidu.adp.lib.f.e.mY().postDelayed(WriteVideoActivity.this.nZh, 100L);
            }
        };
        this.fwI = new NewWriteModel.d() { // from class: com.baidu.tieba.write.video.WriteVideoActivity.12
            @Override // com.baidu.tieba.tbadkCore.writeModel.NewWriteModel.d
            public void callback(boolean z, PostWriteCallBackData postWriteCallBackData, ah ahVar, WriteData writeData, AntiData antiData) {
                WriteVideoActivity.this.closeLoadingDialog();
                if (postWriteCallBackData != null && WriteVideoActivity.this.nbc != null) {
                    boolean z2 = com.baidu.tbadk.core.sharedPref.b.bsO().getBoolean(MotuVideoConfig.IS_SINGLE_GOD_USER, false);
                    if (WriteVideoActivity.this.nbc != null && WriteVideoActivity.this.nbc.getVideoInfo() != null && writeData != null) {
                        if (!z2 && WriteVideoActivity.this.nbc.getVideoInfo().getVideoDuration() > 8) {
                            writeData.setVideoReviewType(1);
                        } else {
                            writeData.setVideoReviewType(2);
                        }
                    }
                    WriteVideoActivity.this.nYZ.dZM();
                    boolean z3 = com.baidu.tbadk.core.sharedPref.b.bsO().getBoolean(SharedPrefConfig.WRITE_VIDEO_ACTIVITY_SAVE_VIDEO, true);
                    if (z) {
                        if (WriteVideoActivity.this.nbc != null && WriteVideoActivity.this.nbc.getVideoInfo() != null) {
                            WriteVideoActivity.this.zn(z3);
                            postWriteCallBackData.mVideoMd5 = WriteVideoActivity.this.nbc.getVideoInfo().getVideoMd5();
                        }
                        WriteVideoActivity.this.k(postWriteCallBackData);
                    } else if (postWriteCallBackData != null && postWriteCallBackData.isSensitiveError()) {
                        WriteVideoActivity.this.showToast(postWriteCallBackData.getErrorString());
                        WriteVideoActivity.this.nYZ.l(postWriteCallBackData);
                    } else if ((ahVar == null || writeData == null || ahVar.getVcode_pic_url() == null || AntiHelper.e(antiData)) && postWriteCallBackData != null && postWriteCallBackData.getErrorCode() != 227001) {
                        WriteVideoActivity.this.c(false, postWriteCallBackData);
                    } else if (ahVar != null && writeData != null && ahVar.getVcode_pic_url() != null) {
                        writeData.setVcodeMD5(ahVar.getVcode_md5());
                        writeData.setVcodeUrl(ahVar.getVcode_pic_url());
                        writeData.setVcodeExtra(ahVar.bxM());
                        if (com.baidu.tbadk.t.a.ES(ahVar.bxL())) {
                            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new NewVcodeActivityConfig(WriteVideoActivity.this.getPageContext().getPageActivity(), RequestResponseCode.REQUEST_VCODE, writeData, false, ahVar.bxL())));
                        } else {
                            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new VcodeActivityConfig(WriteVideoActivity.this.getPageContext().getPageActivity(), writeData, RequestResponseCode.REQUEST_VCODE)));
                        }
                    } else if (postWriteCallBackData != null && postWriteCallBackData.getErrorCode() == 227001) {
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AccountAccessActivityConfig(WriteVideoActivity.this.getActivity(), RequestResponseCode.REQUEST_VCODE, writeData, postWriteCallBackData.getAccessState())));
                    }
                }
            }
        };
        this.nZi = new Runnable() { // from class: com.baidu.tieba.write.video.WriteVideoActivity.13
            @Override // java.lang.Runnable
            public void run() {
                if (WriteVideoActivity.this.jvY != null) {
                    WriteVideoActivity.this.jvY.setPercent(WriteVideoActivity.this.nZb);
                }
            }
        };
        this.npV = new a.InterfaceC0869a() { // from class: com.baidu.tieba.write.video.WriteVideoActivity.14
            @Override // com.baidu.tieba.tbadkCore.c.a.InterfaceC0869a
            public void KY(int i) {
                WriteVideoActivity.this.nZb = i;
                com.baidu.adp.lib.f.e.mY().post(WriteVideoActivity.this.nZi);
            }
        };
        this.iJM = new DialogInterface.OnCancelListener() { // from class: com.baidu.tieba.write.video.WriteVideoActivity.2
            @Override // android.content.DialogInterface.OnCancelListener
            public void onCancel(DialogInterface dialogInterface) {
                WriteVideoActivity.this.destroyWaitingDialog();
                WriteVideoActivity.this.dLx();
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.nYZ = new b(this);
        setSwipeBackEnabled(false);
        dZA();
        this.nYZ.zo(this.nZg);
        if (this.nbc.getVideoInfo() != null) {
            if (!StringUtils.isNull(this.nCz)) {
                VideoTitleData videoTitleData = new VideoTitleData();
                videoTitleData.name = this.nCz;
                this.nYZ.a(this.nbc.getVideoInfo(), videoTitleData, (List<VideoTitleData>) null);
            } else {
                this.nYZ.a(this.nbc.getVideoInfo(), this.mVideoTitleData, this.nCA);
            }
        }
        if (this.nYZ.dZI() != null && !this.nZg) {
            this.nYZ.dZI().f(this);
        }
        this.nYZ.c(this.nCy);
        adjustResizeForSoftInput();
        this.nZa = new GestureDetector(getPageContext().getPageActivity(), new a());
        this.mInputManager = (InputMethodManager) getSystemService("input_method");
        ShowSoftKeyPadDelay(this.nYZ.dZK());
        this.nYZ.dZK().requestFocus();
        TiebaStatic.log(new ar("c12307"));
        addGlobalLayoutListener();
        if (ae.checkLocationForBaiduLocation(getPageContext().getPageActivity())) {
            com.baidu.adp.lib.c.a.mk().a(true, new a.InterfaceC0020a() { // from class: com.baidu.tieba.write.video.WriteVideoActivity.7
                @Override // com.baidu.adp.lib.c.a.InterfaceC0020a
                public void onLocationGeted(int i, String str, Address address) {
                    if (i == 0 && address != null) {
                        WriteVideoActivity.this.mLat = String.valueOf(address.getLatitude());
                        WriteVideoActivity.this.mLng = String.valueOf(address.getLongitude());
                    }
                }
            });
        }
        if (this.nbc.getVideoInfo() != null && !StringUtils.isNull(this.nbc.getVideoInfo().getVideoPath())) {
            VQ(this.nbc.getVideoInfo().getVideoPath());
        }
    }

    private void VQ(String str) {
        if (g.bAe()) {
            if (this.npZ != null) {
                this.nZe = this.npZ.Pt(str);
            }
            if (this.nZe != null) {
                this.nZe.a(this.lmf);
                this.nZe.diJ();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        com.baidu.adp.lib.f.e.mY().postDelayed(this.nZc, 500L);
        if (this.nYZ != null) {
            this.nYZ.dVp();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onStop() {
        super.onStop();
        if (this.nYZ != null) {
            this.nYZ.cEV();
        }
    }

    private void dZA() {
        Intent intent = getIntent();
        if (intent != null) {
            Serializable serializableExtra = intent.getSerializableExtra(WriteVideoActivityConfig.VIDEO_INFO);
            if (serializableExtra instanceof VideoInfo) {
                this.nbc.setVideoInfo((VideoInfo) serializableExtra);
            }
            this.mFromForumId = intent.getStringExtra("forum_id");
            this.lLC = intent.getStringExtra("forum_name");
            this.nCx = intent.getIntExtra("pro_zone", -1);
            this.mFrom = intent.getStringExtra("from");
            this.nbc.setForumId(this.mFromForumId);
            this.nbc.setForumName(this.lLC);
            this.nbc.setProZone(this.nCx);
            this.nCz = intent.getStringExtra("video_title");
            if (intent.getSerializableExtra(WriteVideoActivityConfig.FORUM_VIDEO_TITLE) instanceof VideoTitleData) {
                this.mVideoTitleData = (VideoTitleData) intent.getSerializableExtra(WriteVideoActivityConfig.FORUM_VIDEO_TITLE);
            }
            if (intent.getSerializableExtra(WriteVideoActivityConfig.ALL_VIDEO_TITLE) instanceof List) {
                this.nCA = (List) intent.getSerializableExtra(WriteVideoActivityConfig.ALL_VIDEO_TITLE);
            }
            if (getIntent().getSerializableExtra("tab_list") instanceof FrsTabInfoData) {
                this.nCy = (FrsTabInfoData) getIntent().getSerializableExtra("tab_list");
            }
            if (!StringUtils.isNull(this.lLC)) {
                this.nYZ.VT(this.lLC + getResources().getString(R.string.forum));
            } else {
                this.nYZ.VT(this.lLC);
            }
            this.jzq = intent.getStringExtra("KEY_CALL_FROM");
            dZB();
            if (AlbumActivityConfig.FROM_PERSON.equals(this.mFrom)) {
                this.nZg = true;
            }
        }
    }

    private void dZB() {
        if (this.nbc != null && this.nYZ != null && this.nYZ.getCenterTitleView() != null) {
            TextView centerTitleView = this.nYZ.getCenterTitleView();
            if (this.nbc.getProZone() == 1) {
                centerTitleView.setText(R.string.write_zone_profession_title);
            }
        }
    }

    private void dZC() {
        if (StringUtils.isNull(this.mFromForumId) || Long.parseLong(this.mFromForumId) <= 0 || StringUtils.isNull(this.lLC)) {
            this.nbc.setCanNoForum(true);
        } else {
            this.nbc.setCanNoForum(false);
        }
        this.nbc.setForumName(this.lLC);
        this.nbc.setTitle(this.nYZ.getContent());
        this.nbc.setContent("");
        this.nbc.setType(0);
        if (this.nYZ.dZL() != null) {
            if (this.nYZ.dZL().getState() == 0) {
                this.nbc.setPrivacy(false);
            } else {
                this.nbc.setPrivacy(true);
            }
        }
        this.nbc.setToDynamic(this.nYZ.isToDynamic());
        if (this.nYZ.dZI() != null) {
            this.nbc.setHasLocationData(this.nYZ.dZI().clB());
        }
        this.nbc.setIsNoTitle(TextUtils.isEmpty(this.nbc.getTitle()));
    }

    private void dZD() {
        showLoadingDialog();
        com.baidu.tieba.write.b.a.a(this.nbc, new a.InterfaceC0892a() { // from class: com.baidu.tieba.write.video.WriteVideoActivity.9
            @Override // com.baidu.tieba.write.b.a.InterfaceC0892a
            public void a(BaseUploadData baseUploadData) {
                com.baidu.tieba.write.b.c.b.dZm().a((VideoUploadData) baseUploadData, new b.a() { // from class: com.baidu.tieba.write.video.WriteVideoActivity.9.1
                    @Override // com.baidu.tieba.write.b.c.b.a
                    public void onSuccess(String str) {
                        WriteVideoActivity.this.zn(com.baidu.tbadk.core.sharedPref.b.bsO().getBoolean(SharedPrefConfig.WRITE_VIDEO_ACTIVITY_SAVE_VIDEO, true));
                        WriteVideoActivity.this.closeLoadingDialog();
                        PostWriteCallBackData postWriteCallBackData = new PostWriteCallBackData();
                        postWriteCallBackData.setDyamicCallback(true);
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_VIDEO_WRITE_POST_SUCCESS, postWriteCallBackData));
                        WriteVideoActivity.this.finish();
                        if (postWriteCallBackData.mFrom != 2 || postWriteCallBackData.getIconStampData() == null) {
                            com.baidu.adp.lib.util.l.showToast(TbadkCoreApplication.getInst(), R.string.publish_dynamic_success);
                        }
                    }

                    @Override // com.baidu.tieba.write.b.c.b.a
                    public void onFail(String str) {
                        WriteVideoActivity.this.closeLoadingDialog();
                        if (TextUtils.isEmpty(str)) {
                            str = TbadkCoreApplication.getInst().getString(R.string.publish_dynamic_error);
                        }
                        com.baidu.adp.lib.util.l.showToast(TbadkCoreApplication.getInst(), str);
                    }
                });
            }

            @Override // com.baidu.tieba.write.b.a.InterfaceC0892a
            public void onError() {
                WriteVideoActivity.this.closeLoadingDialog();
                com.baidu.adp.lib.util.l.showToast(TbadkCoreApplication.getInst(), R.string.publish_dynamic_error);
            }
        }, this.npV);
    }

    private void bDr() {
        if (AlbumActivityConfig.FROM_PERSON.equals(this.mFrom)) {
            this.nbc.mDynamicVideoData = new VideoUploadData();
            dZD();
            return;
        }
        dLx();
        showLoadingDialog();
        this.nZd = VR(this.nbc != null ? this.nbc.getTitle() : "");
        if (this.fwu == null) {
            this.fwu = new NewWriteModel(this);
        }
        if (!TextUtils.isEmpty(this.jzq)) {
            this.nbc.setCallFrom(this.jzq);
        }
        this.nbc.setPostLatLng(true);
        dZE();
        this.fwu.e(this.nbc);
        this.fwu.b(this.fwI);
        this.fwu.a(this.npV);
        if (!TextUtils.isEmpty(this.mLat) && !TextUtils.isEmpty(this.mLng)) {
            this.nbc.setLat(this.mLat);
            this.nbc.setLng(this.mLng);
            if (g.bAe() && this.nZe != null && !this.nZf) {
                com.baidu.adp.lib.f.e.mY().postDelayed(this.nZh, 100L);
            } else {
                this.fwu.dQD();
            }
        } else if (ae.checkLocationForBaiduLocation(getPageContext().getPageActivity())) {
            com.baidu.adp.lib.c.a.mk().a(true, new a.InterfaceC0020a() { // from class: com.baidu.tieba.write.video.WriteVideoActivity.10
                @Override // com.baidu.adp.lib.c.a.InterfaceC0020a
                public void onLocationGeted(int i, String str, Address address) {
                    if (i == 0 && address != null) {
                        WriteVideoActivity.this.mLat = String.valueOf(address.getLatitude());
                        WriteVideoActivity.this.mLng = String.valueOf(address.getLongitude());
                        WriteVideoActivity.this.nbc.setLat(WriteVideoActivity.this.mLat);
                        WriteVideoActivity.this.nbc.setLng(WriteVideoActivity.this.mLng);
                    }
                    if (!g.bAe() || WriteVideoActivity.this.nZe == null || WriteVideoActivity.this.nZf) {
                        WriteVideoActivity.this.fwu.dQD();
                    } else {
                        com.baidu.adp.lib.f.e.mY().postDelayed(WriteVideoActivity.this.nZh, 100L);
                    }
                }
            });
        } else if (g.bAe() && this.nZe != null && !this.nZf) {
            com.baidu.adp.lib.f.e.mY().postDelayed(this.nZh, 100L);
        } else {
            this.fwu.dQD();
        }
    }

    private void dZE() {
        FrsTabItemData selectedTabItemData;
        if (this.nbc != null && this.nYZ != null && this.nYZ.dZG() != null && (selectedTabItemData = this.nYZ.dZG().getSelectedTabItemData()) != null) {
            this.nbc.setTabId(selectedTabItemData.tabId);
            this.nbc.setTabName(selectedTabItemData.name);
            this.nbc.setIsGeneralTab(selectedTabItemData.isGeneralTab);
        }
    }

    private void bq(Context context, String str) {
        if (context != null) {
            try {
                if (!TextUtils.isEmpty(str)) {
                    new z(context).saveVideo(str);
                    Intent intent = new Intent("android.intent.action.MEDIA_SCANNER_SCAN_FILE");
                    intent.setData(Uri.fromFile(new File(str)));
                    context.sendBroadcast(intent);
                }
            } catch (Exception e) {
                BdLog.e(e);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void zn(boolean z) {
        File file;
        File file2 = new File(com.baidu.tieba.video.c.nAY);
        if (!file2.exists()) {
            file2.mkdirs();
        }
        if (z && this.nbc.getVideoInfo().getVideoType() == 1) {
            String str = com.baidu.tieba.video.c.nAY + file.getName();
            n.copyFile(new File(this.nbc.getVideoInfo().getVideoPath()).getAbsolutePath(), str);
            bq(BdBaseApplication.getInst(), str);
        }
        dZF();
        n.deleteFileOrDir(new File(com.baidu.tieba.video.c.nAX));
    }

    private void dZF() {
        VideoInfo videoInfo;
        if (this.nbc != null && (videoInfo = this.nbc.getVideoInfo()) != null && videoInfo.getVideoType() == 2) {
            if ((videoInfo.isCompressedVideo() || videoInfo.getMusicListInfo() != null) && videoInfo.getVideoPath() != null && videoInfo.getVideoPath().contains(com.baidu.tieba.video.c.nAX)) {
                File file = new File(videoInfo.getVideoPath());
                if (file.exists() && file.isFile()) {
                    if (com.baidu.tbadk.core.sharedPref.b.bsO().getBoolean(SharedPrefConfig.WRITE_VIDEO_ACTIVITY_SAVE_VIDEO, true)) {
                        n.copyFile(file.getAbsolutePath(), com.baidu.tieba.video.c.nAY + file.getName());
                    } else {
                        file.delete();
                    }
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(boolean z, PostWriteCallBackData postWriteCallBackData) {
        if (postWriteCallBackData != null) {
            postWriteCallBackData.getErrorString();
            if (AntiHelper.bP(postWriteCallBackData.getErrorCode(), postWriteCallBackData.getErrorString())) {
                AntiHelper.bn(getPageContext().getPageActivity(), postWriteCallBackData.getErrorString());
            } else if (postWriteCallBackData.getErrorCode() != 0) {
                String errorString = postWriteCallBackData.getErrorString();
                if (TextUtils.isEmpty(errorString)) {
                    errorString = getPageContext().getPageActivity().getString(R.string.sand_fail);
                }
                showToast(errorString);
            } else {
                com.baidu.tieba.tbadkCore.writeModel.c.h(getPageContext().getPageActivity(), postWriteCallBackData.getErrorString(), postWriteCallBackData.getPreMsg(), postWriteCallBackData.getColorMsg());
            }
        }
    }

    public void showLoadingDialog() {
        this.jvY = new c(getPageContext().getPageActivity());
        this.jvY.setOnCancelListener(this.iJM);
        this.jvY.setCancelable(true);
        this.jvY.setCanceledOnTouchOutside(false);
        com.baidu.adp.lib.f.g.showDialog(this.jvY, getPageContext().getPageActivity());
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity
    public void finish() {
        dLx();
        destroyWaitingDialog();
        this.iJM = null;
        closeLoadingDialog();
        com.baidu.adp.lib.f.e.mY().removeCallbacks(this.nZi);
        super.finish();
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void destroyWaitingDialog() {
        this.jvY = null;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity
    public void onActivityResult(int i, int i2, Intent intent) {
        PostWriteCallBackData postWriteCallBackData;
        super.onActivityResult(i, i2, intent);
        if (i == 12006) {
            if (i2 == -1) {
                PostWriteCallBackData postWriteCallBackData2 = null;
                if (intent != null && intent.getExtras() != null && (intent.getExtras().getSerializable("post_write_callback_data") instanceof PostWriteCallBackData)) {
                    postWriteCallBackData2 = (PostWriteCallBackData) intent.getExtras().getSerializable("post_write_callback_data");
                }
                if (postWriteCallBackData2 != null) {
                    k(postWriteCallBackData2);
                }
            } else if (intent != null && intent.getExtras() != null && (intent.getExtras().getSerializable("post_write_callback_data") instanceof PostWriteCallBackData) && (postWriteCallBackData = (PostWriteCallBackData) intent.getExtras().getSerializable("post_write_callback_data")) != null && postWriteCallBackData.isSensitiveError()) {
                showToast(postWriteCallBackData.getErrorString());
                if (this.nYZ.dZN() != null) {
                    this.nYZ.dZN().bn(postWriteCallBackData.getSensitiveWords());
                    if (!y.isEmpty(this.nYZ.dZN().dYm())) {
                        this.nYZ.zp(true);
                    }
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void k(PostWriteCallBackData postWriteCallBackData) {
        ad.a(new ac<Void>() { // from class: com.baidu.tieba.write.video.WriteVideoActivity.3
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tbadk.util.ac
            /* renamed from: bMT */
            public Void doInBackground() {
                File file;
                if (WriteVideoActivity.this.nbc != null && WriteVideoActivity.this.nbc.getVideoInfo() != null && WriteVideoActivity.this.nbc.getVideoInfo().getVideoPath() != null && WriteVideoActivity.this.nbc.getVideoInfo().getVideoPath().contains(com.baidu.tieba.video.c.nAX) && (file = new File(WriteVideoActivity.this.nbc.getVideoInfo().getVideoPath())) != null) {
                    n.copyFile(file.getAbsolutePath(), com.baidu.tieba.video.c.nAY + file.getName());
                }
                n.deleteFileOrDir(new File(com.baidu.tieba.video.c.nAX));
                return null;
            }
        }, new m<Void>() { // from class: com.baidu.tieba.write.video.WriteVideoActivity.4
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tbadk.util.m
            /* renamed from: a */
            public void onReturnDataInUI(Void r1) {
            }
        });
        if (!StringUtils.isNull(this.nCz)) {
            postWriteCallBackData.mFrom = 3;
        } else if (!StringUtils.isNull(this.lLC)) {
            postWriteCallBackData.mFrom = 2;
        } else {
            postWriteCallBackData.mFrom = 1;
        }
        postWriteCallBackData.mVideoTitleData = this.nZd;
        if (postWriteCallBackData.mFrom == 3 && postWriteCallBackData != null && !StringUtils.isNull(postWriteCallBackData.buildVideoFakeOnWallUrl())) {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_FINISH_THIS_PAGE));
            com.baidu.tbadk.browser.a.startWebActivity(this, (String) null, postWriteCallBackData.buildVideoFakeOnWallUrl());
        }
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_VIDEO_WRITE_POST_SUCCESS, postWriteCallBackData));
        finish();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        this.nYZ.onChangeSkinType(i);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        if (this.nYZ != null) {
            this.nYZ.cEV();
        }
        com.baidu.adp.lib.f.e.mY().removeCallbacks(this.nZc);
        com.baidu.adp.lib.f.e.mY().removeCallbacks(this.nZh);
    }

    protected void dLx() {
        if (this.fwu != null) {
            this.fwu.cancelLoadData();
        }
        if (this.nYZ.dZI() != null) {
            this.nYZ.dZI().dLx();
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i == 4) {
            if (this.jvY != null && this.jvY.isShowing()) {
                com.baidu.adp.lib.f.g.b(this.jvY, getPageContext());
                return true;
            }
            cGq();
            return true;
        }
        return super.onKeyDown(i, keyEvent);
    }

    private void cGq() {
        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(getPageContext().getPageActivity());
        aVar.oQ(R.string.give_up_video_confirm);
        aVar.a(R.string.dialog_ok, new a.b() { // from class: com.baidu.tieba.write.video.WriteVideoActivity.5
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                aVar2.dismiss();
                WriteVideoActivity.this.dLx();
                TiebaStatic.log("c10800");
                WriteVideoActivity.this.finish();
            }
        });
        aVar.b(R.string.dialog_cancel, new a.b() { // from class: com.baidu.tieba.write.video.WriteVideoActivity.6
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                aVar2.dismiss();
            }
        });
        aVar.b(getPageContext()).brv();
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.nYZ.dZJ()) {
            if (b.nZl - this.nYZ.dZH() < 0) {
                showToast(getResources().getString(R.string.video_content_overflow));
            } else if (this.nYZ.dZN() != null && this.nYZ.dZN().dYo()) {
                showToast(this.nYZ.dZN().dYq());
                this.nYZ.zp(true);
            } else {
                dZC();
                bDr();
            }
        } else if (view == this.nYZ.getBackButton()) {
            cGq();
        }
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void closeLoadingDialog() {
        if (this.jvY != null) {
            if (this.jvY.isShowing()) {
                com.baidu.adp.lib.f.g.b(this.jvY, getPageContext());
            }
            this.jvY = null;
        }
    }

    /* loaded from: classes3.dex */
    private class a extends GestureDetector.SimpleOnGestureListener {
        private a() {
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
        public boolean onFling(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
            com.baidu.adp.lib.util.l.hideSoftKeyPad(WriteVideoActivity.this.getActivity(), WriteVideoActivity.this.getCurrentFocus());
            return super.onFling(motionEvent, motionEvent2, f, f2);
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity, android.view.Window.Callback
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        if (this.nZa.onTouchEvent(motionEvent)) {
            motionEvent.setAction(3);
        }
        return super.dispatchTouchEvent(motionEvent);
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void enterExitAnimation() {
        ActivityPendingTransitionFactory.enterExitAnimation(getPageContext(), 0);
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void closeAnimation() {
        ActivityPendingTransitionFactory.closeAnimation(getPageContext(), 0);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onKeyboardVisibilityChanged(boolean z) {
        super.onKeyboardVisibilityChanged(z);
        this.nYZ.zq(z);
    }

    public VideoTitleData VR(String str) {
        if (!StringUtils.isNull(str) && !y.isEmpty(this.nCA)) {
            Matcher matcher = Pattern.compile("#(.+)#.*").matcher(str);
            if (matcher.find()) {
                String group = matcher.group(1);
                int i = 0;
                while (true) {
                    int i2 = i;
                    if (i2 >= this.nCA.size()) {
                        break;
                    } else if (this.nCA.get(i2) == null || !group.equals(this.nCA.get(i2).name)) {
                        i = i2 + 1;
                    } else {
                        return this.nCA.get(i2);
                    }
                }
            }
        }
        return null;
    }
}
