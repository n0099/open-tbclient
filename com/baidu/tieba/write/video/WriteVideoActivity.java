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
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.core.util.n;
import com.baidu.tbadk.core.util.y;
import com.baidu.tbadk.core.util.z;
import com.baidu.tbadk.coreExtra.data.VideoInfo;
import com.baidu.tbadk.coreExtra.data.WriteData;
import com.baidu.tbadk.coreExtra.data.ah;
import com.baidu.tbadk.coreExtra.model.g;
import com.baidu.tbadk.util.ad;
import com.baidu.tbadk.util.m;
import com.baidu.tieba.R;
import com.baidu.tieba.frs.FrsTabInfoData;
import com.baidu.tieba.frs.FrsTabItemData;
import com.baidu.tieba.k.e;
import com.baidu.tieba.k.l;
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
    private final NewWriteModel.d fbF;
    private NewWriteModel fbr;
    private c iPr;
    private DialogInterface.OnCancelListener ifK;
    private e.a kGb;
    private String leZ;
    private String mFrom;
    private String mFromForumId;
    private a.InterfaceC0822a mIk;
    private InputMethodManager mInputManager;
    private l mIo;
    public String mLat;
    public String mLng;
    private int mUR;
    private FrsTabInfoData mUS;
    private String mUT;
    private List<VideoTitleData> mUU;
    private VideoTitleData mVideoTitleData;
    private b nqZ;
    private GestureDetector nra;
    private int nrb;
    private VideoTitleData nrd;
    private e nre;
    private boolean nrf;
    private Runnable nrh;
    private Runnable nri;
    private final WriteData mtA = new WriteData();
    private Runnable nrc = new Runnable() { // from class: com.baidu.tieba.write.video.WriteVideoActivity.1
        @Override // java.lang.Runnable
        public void run() {
            Intent intent = new Intent(MotuVideoConfig.ACTION_FINISH_VIDEO_ALL_ACTIVITY);
            intent.setPackage(TbadkCoreApplication.getInst().getPackageName());
            WriteVideoActivity.this.getPageContext().getPageActivity().sendBroadcast(intent);
        }
    };
    private String iSJ = "0";
    private boolean nrg = false;

    public WriteVideoActivity() {
        CustomResponsedMessage runTask = MessageManager.getInstance().runTask(CmdConfigCustom.CMD_GET_VIDEO_PLATFORM_FACTORY, l.class);
        if (runTask != null) {
            this.mIo = (l) runTask.getData();
        }
        this.kGb = new e.a() { // from class: com.baidu.tieba.write.video.WriteVideoActivity.8
            @Override // com.baidu.tieba.k.e.a
            public void Ek(int i) {
                if (i != 1) {
                    WriteVideoActivity.this.nrf = true;
                    return;
                }
                aq aqVar = new aq("c12620");
                aqVar.aj("obj_locate", 0);
                TiebaStatic.log(aqVar);
            }

            @Override // com.baidu.tieba.k.e.a
            public void onChange(boolean z) {
            }

            @Override // com.baidu.tieba.k.e.a
            public void sK(boolean z) {
                WriteVideoActivity.this.nrf = true;
                aq aqVar = new aq("c12621");
                aqVar.aj("obj_locate", 0);
                aqVar.aj("obj_param1", z ? 1 : 0);
                TiebaStatic.log(aqVar);
            }
        };
        this.nrh = new Runnable() { // from class: com.baidu.tieba.write.video.WriteVideoActivity.11
            @Override // java.lang.Runnable
            public void run() {
                if (!g.bsV() || WriteVideoActivity.this.nre == null || WriteVideoActivity.this.nrf) {
                    if (WriteVideoActivity.this.fbr != null) {
                        WriteVideoActivity.this.fbr.dFC();
                        return;
                    }
                    return;
                }
                com.baidu.adp.lib.f.e.mY().postDelayed(WriteVideoActivity.this.nrh, 100L);
            }
        };
        this.fbF = new NewWriteModel.d() { // from class: com.baidu.tieba.write.video.WriteVideoActivity.12
            @Override // com.baidu.tieba.tbadkCore.writeModel.NewWriteModel.d
            public void callback(boolean z, PostWriteCallBackData postWriteCallBackData, ah ahVar, WriteData writeData, AntiData antiData) {
                WriteVideoActivity.this.closeLoadingDialog();
                if (postWriteCallBackData != null && WriteVideoActivity.this.mtA != null) {
                    boolean z2 = com.baidu.tbadk.core.sharedPref.b.blO().getBoolean(MotuVideoConfig.IS_SINGLE_GOD_USER, false);
                    if (WriteVideoActivity.this.mtA != null && WriteVideoActivity.this.mtA.getVideoInfo() != null && writeData != null) {
                        if (!z2 && WriteVideoActivity.this.mtA.getVideoInfo().getVideoDuration() > 8) {
                            writeData.setVideoReviewType(1);
                        } else {
                            writeData.setVideoReviewType(2);
                        }
                    }
                    WriteVideoActivity.this.nqZ.dOL();
                    boolean z3 = com.baidu.tbadk.core.sharedPref.b.blO().getBoolean(SharedPrefConfig.WRITE_VIDEO_ACTIVITY_SAVE_VIDEO, true);
                    if (z) {
                        if (WriteVideoActivity.this.mtA != null && WriteVideoActivity.this.mtA.getVideoInfo() != null) {
                            WriteVideoActivity.this.yb(z3);
                            postWriteCallBackData.mVideoMd5 = WriteVideoActivity.this.mtA.getVideoInfo().getVideoMd5();
                        }
                        WriteVideoActivity.this.k(postWriteCallBackData);
                    } else if (postWriteCallBackData != null && postWriteCallBackData.isSensitiveError()) {
                        WriteVideoActivity.this.showToast(postWriteCallBackData.getErrorString());
                        WriteVideoActivity.this.nqZ.l(postWriteCallBackData);
                    } else if ((ahVar == null || writeData == null || ahVar.getVcode_pic_url() == null || AntiHelper.e(antiData)) && postWriteCallBackData != null && postWriteCallBackData.getErrorCode() != 227001) {
                        WriteVideoActivity.this.c(false, postWriteCallBackData);
                    } else if (ahVar != null && writeData != null && ahVar.getVcode_pic_url() != null) {
                        writeData.setVcodeMD5(ahVar.getVcode_md5());
                        writeData.setVcodeUrl(ahVar.getVcode_pic_url());
                        writeData.setVcodeExtra(ahVar.bqD());
                        if (com.baidu.tbadk.t.a.DX(ahVar.bqC())) {
                            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new NewVcodeActivityConfig(WriteVideoActivity.this.getPageContext().getPageActivity(), RequestResponseCode.REQUEST_VCODE, writeData, false, ahVar.bqC())));
                        } else {
                            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new VcodeActivityConfig(WriteVideoActivity.this.getPageContext().getPageActivity(), writeData, RequestResponseCode.REQUEST_VCODE)));
                        }
                    } else if (postWriteCallBackData != null && postWriteCallBackData.getErrorCode() == 227001) {
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AccountAccessActivityConfig(WriteVideoActivity.this.getActivity(), RequestResponseCode.REQUEST_VCODE, writeData, postWriteCallBackData.getAccessState())));
                    }
                }
            }
        };
        this.nri = new Runnable() { // from class: com.baidu.tieba.write.video.WriteVideoActivity.13
            @Override // java.lang.Runnable
            public void run() {
                if (WriteVideoActivity.this.iPr != null) {
                    WriteVideoActivity.this.iPr.setPercent(WriteVideoActivity.this.nrb);
                }
            }
        };
        this.mIk = new a.InterfaceC0822a() { // from class: com.baidu.tieba.write.video.WriteVideoActivity.14
            @Override // com.baidu.tieba.tbadkCore.c.a.InterfaceC0822a
            public void Jb(int i) {
                WriteVideoActivity.this.nrb = i;
                com.baidu.adp.lib.f.e.mY().post(WriteVideoActivity.this.nri);
            }
        };
        this.ifK = new DialogInterface.OnCancelListener() { // from class: com.baidu.tieba.write.video.WriteVideoActivity.2
            @Override // android.content.DialogInterface.OnCancelListener
            public void onCancel(DialogInterface dialogInterface) {
                WriteVideoActivity.this.destroyWaitingDialog();
                WriteVideoActivity.this.dAI();
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.nqZ = new b(this);
        setSwipeBackEnabled(false);
        dOz();
        this.nqZ.yc(this.nrg);
        if (this.mtA.getVideoInfo() != null) {
            if (!StringUtils.isNull(this.mUT)) {
                VideoTitleData videoTitleData = new VideoTitleData();
                videoTitleData.name = this.mUT;
                this.nqZ.a(this.mtA.getVideoInfo(), videoTitleData, (List<VideoTitleData>) null);
            } else {
                this.nqZ.a(this.mtA.getVideoInfo(), this.mVideoTitleData, this.mUU);
            }
        }
        if (this.nqZ.dOH() != null && !this.nrg) {
            this.nqZ.dOH().f(this);
        }
        this.nqZ.c(this.mUS);
        adjustResizeForSoftInput();
        this.nra = new GestureDetector(getPageContext().getPageActivity(), new a());
        this.mInputManager = (InputMethodManager) getSystemService("input_method");
        ShowSoftKeyPadDelay(this.nqZ.dOJ());
        this.nqZ.dOJ().requestFocus();
        TiebaStatic.log(new aq("c12307"));
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
        if (this.mtA.getVideoInfo() != null && !StringUtils.isNull(this.mtA.getVideoInfo().getVideoPath())) {
            Ua(this.mtA.getVideoInfo().getVideoPath());
        }
    }

    private void Ua(String str) {
        if (g.bsV()) {
            if (this.mIo != null) {
                this.nre = this.mIo.Ob(str);
            }
            if (this.nre != null) {
                this.nre.a(this.kGb);
                this.nre.cYr();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        com.baidu.adp.lib.f.e.mY().postDelayed(this.nrc, 500L);
        if (this.nqZ != null) {
            this.nqZ.dKm();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onStop() {
        super.onStop();
        if (this.nqZ != null) {
            this.nqZ.cvu();
        }
    }

    private void dOz() {
        Intent intent = getIntent();
        if (intent != null) {
            Serializable serializableExtra = intent.getSerializableExtra(WriteVideoActivityConfig.VIDEO_INFO);
            if (serializableExtra instanceof VideoInfo) {
                this.mtA.setVideoInfo((VideoInfo) serializableExtra);
            }
            this.mFromForumId = intent.getStringExtra("forum_id");
            this.leZ = intent.getStringExtra("forum_name");
            this.mUR = intent.getIntExtra("pro_zone", -1);
            this.mFrom = intent.getStringExtra("from");
            this.mtA.setForumId(this.mFromForumId);
            this.mtA.setForumName(this.leZ);
            this.mtA.setProZone(this.mUR);
            this.mUT = intent.getStringExtra("video_title");
            if (intent.getSerializableExtra(WriteVideoActivityConfig.FORUM_VIDEO_TITLE) instanceof VideoTitleData) {
                this.mVideoTitleData = (VideoTitleData) intent.getSerializableExtra(WriteVideoActivityConfig.FORUM_VIDEO_TITLE);
            }
            if (intent.getSerializableExtra(WriteVideoActivityConfig.ALL_VIDEO_TITLE) instanceof List) {
                this.mUU = (List) intent.getSerializableExtra(WriteVideoActivityConfig.ALL_VIDEO_TITLE);
            }
            if (getIntent().getSerializableExtra("tab_list") instanceof FrsTabInfoData) {
                this.mUS = (FrsTabInfoData) getIntent().getSerializableExtra("tab_list");
            }
            if (!StringUtils.isNull(this.leZ)) {
                this.nqZ.Ud(this.leZ + getResources().getString(R.string.forum));
            } else {
                this.nqZ.Ud(this.leZ);
            }
            this.iSJ = intent.getStringExtra("KEY_CALL_FROM");
            dOA();
            if (AlbumActivityConfig.FROM_PERSON.equals(this.mFrom)) {
                this.nrg = true;
            }
        }
    }

    private void dOA() {
        if (this.mtA != null && this.nqZ != null && this.nqZ.getCenterTitleView() != null) {
            TextView centerTitleView = this.nqZ.getCenterTitleView();
            if (this.mtA.getProZone() == 1) {
                centerTitleView.setText(R.string.write_zone_profession_title);
            }
        }
    }

    private void dOB() {
        if (StringUtils.isNull(this.mFromForumId) || Long.parseLong(this.mFromForumId) <= 0 || StringUtils.isNull(this.leZ)) {
            this.mtA.setCanNoForum(true);
        } else {
            this.mtA.setCanNoForum(false);
        }
        this.mtA.setForumName(this.leZ);
        this.mtA.setTitle(this.nqZ.getContent());
        this.mtA.setContent("");
        this.mtA.setType(0);
        if (this.nqZ.dOK() != null) {
            if (this.nqZ.dOK().getState() == 0) {
                this.mtA.setPrivacy(false);
            } else {
                this.mtA.setPrivacy(true);
            }
        }
        this.mtA.setToDynamic(this.nqZ.isToDynamic());
        if (this.nqZ.dOH() != null) {
            this.mtA.setHasLocationData(this.nqZ.dOH().ccF());
        }
        this.mtA.setIsNoTitle(TextUtils.isEmpty(this.mtA.getTitle()));
    }

    private void dOC() {
        showLoadingDialog();
        com.baidu.tieba.write.b.a.a(this.mtA, new a.InterfaceC0843a() { // from class: com.baidu.tieba.write.video.WriteVideoActivity.9
            @Override // com.baidu.tieba.write.b.a.InterfaceC0843a
            public void a(BaseUploadData baseUploadData) {
                com.baidu.tieba.write.b.c.b.dOl().a((VideoUploadData) baseUploadData, new b.a() { // from class: com.baidu.tieba.write.video.WriteVideoActivity.9.1
                    @Override // com.baidu.tieba.write.b.c.b.a
                    public void onSuccess(String str) {
                        WriteVideoActivity.this.yb(com.baidu.tbadk.core.sharedPref.b.blO().getBoolean(SharedPrefConfig.WRITE_VIDEO_ACTIVITY_SAVE_VIDEO, true));
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

            @Override // com.baidu.tieba.write.b.a.InterfaceC0843a
            public void onError() {
                WriteVideoActivity.this.closeLoadingDialog();
                com.baidu.adp.lib.util.l.showToast(TbadkCoreApplication.getInst(), R.string.publish_dynamic_error);
            }
        }, this.mIk);
    }

    private void bwj() {
        if (AlbumActivityConfig.FROM_PERSON.equals(this.mFrom)) {
            this.mtA.mDynamicVideoData = new VideoUploadData();
            dOC();
            return;
        }
        dAI();
        showLoadingDialog();
        this.nrd = Ub(this.mtA != null ? this.mtA.getTitle() : "");
        if (this.fbr == null) {
            this.fbr = new NewWriteModel(this);
        }
        if (!TextUtils.isEmpty(this.iSJ)) {
            this.mtA.setCallFrom(this.iSJ);
        }
        this.mtA.setPostLatLng(true);
        dOD();
        this.fbr.e(this.mtA);
        this.fbr.b(this.fbF);
        this.fbr.a(this.mIk);
        if (!TextUtils.isEmpty(this.mLat) && !TextUtils.isEmpty(this.mLng)) {
            this.mtA.setLat(this.mLat);
            this.mtA.setLng(this.mLng);
            if (g.bsV() && this.nre != null && !this.nrf) {
                com.baidu.adp.lib.f.e.mY().postDelayed(this.nrh, 100L);
            } else {
                this.fbr.dFC();
            }
        } else if (ae.checkLocationForBaiduLocation(getPageContext().getPageActivity())) {
            com.baidu.adp.lib.c.a.mk().a(true, new a.InterfaceC0020a() { // from class: com.baidu.tieba.write.video.WriteVideoActivity.10
                @Override // com.baidu.adp.lib.c.a.InterfaceC0020a
                public void onLocationGeted(int i, String str, Address address) {
                    if (i == 0 && address != null) {
                        WriteVideoActivity.this.mLat = String.valueOf(address.getLatitude());
                        WriteVideoActivity.this.mLng = String.valueOf(address.getLongitude());
                        WriteVideoActivity.this.mtA.setLat(WriteVideoActivity.this.mLat);
                        WriteVideoActivity.this.mtA.setLng(WriteVideoActivity.this.mLng);
                    }
                    if (!g.bsV() || WriteVideoActivity.this.nre == null || WriteVideoActivity.this.nrf) {
                        WriteVideoActivity.this.fbr.dFC();
                    } else {
                        com.baidu.adp.lib.f.e.mY().postDelayed(WriteVideoActivity.this.nrh, 100L);
                    }
                }
            });
        } else if (g.bsV() && this.nre != null && !this.nrf) {
            com.baidu.adp.lib.f.e.mY().postDelayed(this.nrh, 100L);
        } else {
            this.fbr.dFC();
        }
    }

    private void dOD() {
        FrsTabItemData selectedTabItemData;
        if (this.mtA != null && this.nqZ != null && this.nqZ.dOF() != null && (selectedTabItemData = this.nqZ.dOF().getSelectedTabItemData()) != null) {
            this.mtA.setTabId(selectedTabItemData.tabId);
            this.mtA.setTabName(selectedTabItemData.name);
            this.mtA.setIsGeneralTab(selectedTabItemData.isGeneralTab);
        }
    }

    private void bn(Context context, String str) {
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
    public void yb(boolean z) {
        File file;
        File file2 = new File(com.baidu.tieba.video.c.mTr);
        if (!file2.exists()) {
            file2.mkdirs();
        }
        if (z && this.mtA.getVideoInfo().getVideoType() == 1) {
            String str = com.baidu.tieba.video.c.mTr + file.getName();
            n.copyFile(new File(this.mtA.getVideoInfo().getVideoPath()).getAbsolutePath(), str);
            bn(BdBaseApplication.getInst(), str);
        }
        dOE();
        n.deleteFileOrDir(new File(com.baidu.tieba.video.c.mTq));
    }

    private void dOE() {
        VideoInfo videoInfo;
        if (this.mtA != null && (videoInfo = this.mtA.getVideoInfo()) != null && videoInfo.getVideoType() == 2) {
            if ((videoInfo.isCompressedVideo() || videoInfo.getMusicListInfo() != null) && videoInfo.getVideoPath() != null && videoInfo.getVideoPath().contains(com.baidu.tieba.video.c.mTq)) {
                File file = new File(videoInfo.getVideoPath());
                if (file.exists() && file.isFile()) {
                    if (com.baidu.tbadk.core.sharedPref.b.blO().getBoolean(SharedPrefConfig.WRITE_VIDEO_ACTIVITY_SAVE_VIDEO, true)) {
                        n.copyFile(file.getAbsolutePath(), com.baidu.tieba.video.c.mTr + file.getName());
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
            if (AntiHelper.bM(postWriteCallBackData.getErrorCode(), postWriteCallBackData.getErrorString())) {
                AntiHelper.bk(getPageContext().getPageActivity(), postWriteCallBackData.getErrorString());
            } else if (postWriteCallBackData.getErrorCode() != 0) {
                String errorString = postWriteCallBackData.getErrorString();
                if (TextUtils.isEmpty(errorString)) {
                    errorString = getPageContext().getPageActivity().getString(R.string.sand_fail);
                }
                showToast(errorString);
            } else {
                com.baidu.tieba.tbadkCore.writeModel.c.g(getPageContext().getPageActivity(), postWriteCallBackData.getErrorString(), postWriteCallBackData.getPreMsg(), postWriteCallBackData.getColorMsg());
            }
        }
    }

    public void showLoadingDialog() {
        this.iPr = new c(getPageContext().getPageActivity());
        this.iPr.setOnCancelListener(this.ifK);
        this.iPr.setCancelable(true);
        this.iPr.setCanceledOnTouchOutside(false);
        com.baidu.adp.lib.f.g.showDialog(this.iPr, getPageContext().getPageActivity());
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity
    public void finish() {
        dAI();
        destroyWaitingDialog();
        this.ifK = null;
        closeLoadingDialog();
        com.baidu.adp.lib.f.e.mY().removeCallbacks(this.nri);
        super.finish();
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void destroyWaitingDialog() {
        this.iPr = null;
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
                if (this.nqZ.dOM() != null) {
                    this.nqZ.dOM().bh(postWriteCallBackData.getSensitiveWords());
                    if (!y.isEmpty(this.nqZ.dOM().dNj())) {
                        this.nqZ.yd(true);
                    }
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void k(PostWriteCallBackData postWriteCallBackData) {
        com.baidu.tbadk.util.ae.a(new ad<Void>() { // from class: com.baidu.tieba.write.video.WriteVideoActivity.3
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tbadk.util.ad
            /* renamed from: bFA */
            public Void doInBackground() {
                File file;
                if (WriteVideoActivity.this.mtA != null && WriteVideoActivity.this.mtA.getVideoInfo() != null && WriteVideoActivity.this.mtA.getVideoInfo().getVideoPath() != null && WriteVideoActivity.this.mtA.getVideoInfo().getVideoPath().contains(com.baidu.tieba.video.c.mTq) && (file = new File(WriteVideoActivity.this.mtA.getVideoInfo().getVideoPath())) != null) {
                    n.copyFile(file.getAbsolutePath(), com.baidu.tieba.video.c.mTr + file.getName());
                }
                n.deleteFileOrDir(new File(com.baidu.tieba.video.c.mTq));
                return null;
            }
        }, new m<Void>() { // from class: com.baidu.tieba.write.video.WriteVideoActivity.4
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tbadk.util.m
            /* renamed from: a */
            public void onReturnDataInUI(Void r1) {
            }
        });
        if (!StringUtils.isNull(this.mUT)) {
            postWriteCallBackData.mFrom = 3;
        } else if (!StringUtils.isNull(this.leZ)) {
            postWriteCallBackData.mFrom = 2;
        } else {
            postWriteCallBackData.mFrom = 1;
        }
        postWriteCallBackData.mVideoTitleData = this.nrd;
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
        this.nqZ.onChangeSkinType(i);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        if (this.nqZ != null) {
            this.nqZ.cvu();
        }
        com.baidu.adp.lib.f.e.mY().removeCallbacks(this.nrc);
        com.baidu.adp.lib.f.e.mY().removeCallbacks(this.nrh);
    }

    protected void dAI() {
        if (this.fbr != null) {
            this.fbr.cancelLoadData();
        }
        if (this.nqZ.dOH() != null) {
            this.nqZ.dOH().dAI();
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i == 4) {
            if (this.iPr != null && this.iPr.isShowing()) {
                com.baidu.adp.lib.f.g.b(this.iPr, getPageContext());
                return true;
            }
            cwL();
            return true;
        }
        return super.onKeyDown(i, keyEvent);
    }

    private void cwL() {
        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(getPageContext().getPageActivity());
        aVar.ob(R.string.give_up_video_confirm);
        aVar.a(R.string.dialog_ok, new a.b() { // from class: com.baidu.tieba.write.video.WriteVideoActivity.5
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                aVar2.dismiss();
                WriteVideoActivity.this.dAI();
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
        aVar.b(getPageContext()).bkJ();
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.nqZ.dOI()) {
            if (b.nrl - this.nqZ.dOG() < 0) {
                showToast(getResources().getString(R.string.video_content_overflow));
            } else if (this.nqZ.dOM() != null && this.nqZ.dOM().dNl()) {
                showToast(this.nqZ.dOM().dNn());
                this.nqZ.yd(true);
            } else {
                dOB();
                bwj();
            }
        } else if (view == this.nqZ.getBackButton()) {
            cwL();
        }
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void closeLoadingDialog() {
        if (this.iPr != null) {
            if (this.iPr.isShowing()) {
                com.baidu.adp.lib.f.g.b(this.iPr, getPageContext());
            }
            this.iPr = null;
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
        if (this.nra.onTouchEvent(motionEvent)) {
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
        this.nqZ.ye(z);
    }

    public VideoTitleData Ub(String str) {
        if (!StringUtils.isNull(str) && !y.isEmpty(this.mUU)) {
            Matcher matcher = Pattern.compile("#(.+)#.*").matcher(str);
            if (matcher.find()) {
                String group = matcher.group(1);
                int i = 0;
                while (true) {
                    int i2 = i;
                    if (i2 >= this.mUU.size()) {
                        break;
                    } else if (this.mUU.get(i2) == null || !group.equals(this.mUU.get(i2).name)) {
                        i = i2 + 1;
                    } else {
                        return this.mUU.get(i2);
                    }
                }
            }
        }
        return null;
    }
}
