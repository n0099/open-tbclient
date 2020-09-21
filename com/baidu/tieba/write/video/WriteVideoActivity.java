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
    private NewWriteModel ePk;
    private final NewWriteModel.d ePy;
    private DialogInterface.OnCancelListener hQL;
    private c iAz;
    private String kPM;
    private e.a kqP;
    private int mFe;
    private FrsTabInfoData mFf;
    private String mFg;
    private List<VideoTitleData> mFh;
    private String mFrom;
    private String mFromForumId;
    private InputMethodManager mInputManager;
    public String mLat;
    public String mLng;
    private VideoTitleData mVideoTitleData;
    private a.InterfaceC0804a msD;
    private l msH;
    private b nbA;
    private GestureDetector nbB;
    private int nbC;
    private VideoTitleData nbE;
    private e nbF;
    private boolean nbG;
    private Runnable nbI;
    private Runnable nbJ;
    private final WriteData mdW = new WriteData();
    private Runnable nbD = new Runnable() { // from class: com.baidu.tieba.write.video.WriteVideoActivity.1
        @Override // java.lang.Runnable
        public void run() {
            Intent intent = new Intent(MotuVideoConfig.ACTION_FINISH_VIDEO_ALL_ACTIVITY);
            intent.setPackage(TbadkCoreApplication.getInst().getPackageName());
            WriteVideoActivity.this.getPageContext().getPageActivity().sendBroadcast(intent);
        }
    };
    private String iDT = "0";
    private boolean nbH = false;

    public WriteVideoActivity() {
        CustomResponsedMessage runTask = MessageManager.getInstance().runTask(CmdConfigCustom.CMD_GET_VIDEO_PLATFORM_FACTORY, l.class);
        if (runTask != null) {
            this.msH = (l) runTask.getData();
        }
        this.kqP = new e.a() { // from class: com.baidu.tieba.write.video.WriteVideoActivity.8
            @Override // com.baidu.tieba.k.e.a
            public void DE(int i) {
                if (i != 1) {
                    WriteVideoActivity.this.nbG = true;
                    return;
                }
                aq aqVar = new aq("c12620");
                aqVar.ai("obj_locate", 0);
                TiebaStatic.log(aqVar);
            }

            @Override // com.baidu.tieba.k.e.a
            public void onChange(boolean z) {
            }

            @Override // com.baidu.tieba.k.e.a
            public void sd(boolean z) {
                WriteVideoActivity.this.nbG = true;
                aq aqVar = new aq("c12621");
                aqVar.ai("obj_locate", 0);
                aqVar.ai("obj_param1", z ? 1 : 0);
                TiebaStatic.log(aqVar);
            }
        };
        this.nbI = new Runnable() { // from class: com.baidu.tieba.write.video.WriteVideoActivity.11
            @Override // java.lang.Runnable
            public void run() {
                if (!g.bql() || WriteVideoActivity.this.nbF == null || WriteVideoActivity.this.nbG) {
                    if (WriteVideoActivity.this.ePk != null) {
                        WriteVideoActivity.this.ePk.dBQ();
                        return;
                    }
                    return;
                }
                com.baidu.adp.lib.f.e.mX().postDelayed(WriteVideoActivity.this.nbI, 100L);
            }
        };
        this.ePy = new NewWriteModel.d() { // from class: com.baidu.tieba.write.video.WriteVideoActivity.12
            @Override // com.baidu.tieba.tbadkCore.writeModel.NewWriteModel.d
            public void callback(boolean z, PostWriteCallBackData postWriteCallBackData, ah ahVar, WriteData writeData, AntiData antiData) {
                WriteVideoActivity.this.closeLoadingDialog();
                if (postWriteCallBackData != null && WriteVideoActivity.this.mdW != null) {
                    boolean z2 = com.baidu.tbadk.core.sharedPref.b.bjf().getBoolean(MotuVideoConfig.IS_SINGLE_GOD_USER, false);
                    if (WriteVideoActivity.this.mdW != null && WriteVideoActivity.this.mdW.getVideoInfo() != null && writeData != null) {
                        if (!z2 && WriteVideoActivity.this.mdW.getVideoInfo().getVideoDuration() > 8) {
                            writeData.setVideoReviewType(1);
                        } else {
                            writeData.setVideoReviewType(2);
                        }
                    }
                    WriteVideoActivity.this.nbA.dKZ();
                    boolean z3 = com.baidu.tbadk.core.sharedPref.b.bjf().getBoolean(SharedPrefConfig.WRITE_VIDEO_ACTIVITY_SAVE_VIDEO, true);
                    if (z) {
                        if (WriteVideoActivity.this.mdW != null && WriteVideoActivity.this.mdW.getVideoInfo() != null) {
                            WriteVideoActivity.this.xu(z3);
                            postWriteCallBackData.mVideoMd5 = WriteVideoActivity.this.mdW.getVideoInfo().getVideoMd5();
                        }
                        WriteVideoActivity.this.k(postWriteCallBackData);
                    } else if (postWriteCallBackData != null && postWriteCallBackData.isSensitiveError()) {
                        WriteVideoActivity.this.showToast(postWriteCallBackData.getErrorString());
                        WriteVideoActivity.this.nbA.l(postWriteCallBackData);
                    } else if ((ahVar == null || writeData == null || ahVar.getVcode_pic_url() == null || AntiHelper.e(antiData)) && postWriteCallBackData != null && postWriteCallBackData.getErrorCode() != 227001) {
                        WriteVideoActivity.this.c(false, postWriteCallBackData);
                    } else if (ahVar != null && writeData != null && ahVar.getVcode_pic_url() != null) {
                        writeData.setVcodeMD5(ahVar.getVcode_md5());
                        writeData.setVcodeUrl(ahVar.getVcode_pic_url());
                        writeData.setVcodeExtra(ahVar.bnT());
                        if (com.baidu.tbadk.t.a.Dl(ahVar.bnS())) {
                            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new NewVcodeActivityConfig(WriteVideoActivity.this.getPageContext().getPageActivity(), RequestResponseCode.REQUEST_VCODE, writeData, false, ahVar.bnS())));
                        } else {
                            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new VcodeActivityConfig(WriteVideoActivity.this.getPageContext().getPageActivity(), writeData, RequestResponseCode.REQUEST_VCODE)));
                        }
                    } else if (postWriteCallBackData != null && postWriteCallBackData.getErrorCode() == 227001) {
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AccountAccessActivityConfig(WriteVideoActivity.this.getActivity(), RequestResponseCode.REQUEST_VCODE, writeData, postWriteCallBackData.getAccessState())));
                    }
                }
            }
        };
        this.nbJ = new Runnable() { // from class: com.baidu.tieba.write.video.WriteVideoActivity.13
            @Override // java.lang.Runnable
            public void run() {
                if (WriteVideoActivity.this.iAz != null) {
                    WriteVideoActivity.this.iAz.setPercent(WriteVideoActivity.this.nbC);
                }
            }
        };
        this.msD = new a.InterfaceC0804a() { // from class: com.baidu.tieba.write.video.WriteVideoActivity.14
            @Override // com.baidu.tieba.tbadkCore.c.a.InterfaceC0804a
            public void Iv(int i) {
                WriteVideoActivity.this.nbC = i;
                com.baidu.adp.lib.f.e.mX().post(WriteVideoActivity.this.nbJ);
            }
        };
        this.hQL = new DialogInterface.OnCancelListener() { // from class: com.baidu.tieba.write.video.WriteVideoActivity.2
            @Override // android.content.DialogInterface.OnCancelListener
            public void onCancel(DialogInterface dialogInterface) {
                WriteVideoActivity.this.destroyWaitingDialog();
                WriteVideoActivity.this.dwX();
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.nbA = new b(this);
        setSwipeBackEnabled(false);
        dKN();
        this.nbA.xv(this.nbH);
        if (this.mdW.getVideoInfo() != null) {
            if (!StringUtils.isNull(this.mFg)) {
                VideoTitleData videoTitleData = new VideoTitleData();
                videoTitleData.name = this.mFg;
                this.nbA.a(this.mdW.getVideoInfo(), videoTitleData, (List<VideoTitleData>) null);
            } else {
                this.nbA.a(this.mdW.getVideoInfo(), this.mVideoTitleData, this.mFh);
            }
        }
        if (this.nbA.dKV() != null && !this.nbH) {
            this.nbA.dKV().f(this);
        }
        this.nbA.c(this.mFf);
        adjustResizeForSoftInput();
        this.nbB = new GestureDetector(getPageContext().getPageActivity(), new a());
        this.mInputManager = (InputMethodManager) getSystemService("input_method");
        ShowSoftKeyPadDelay(this.nbA.dKX());
        this.nbA.dKX().requestFocus();
        TiebaStatic.log(new aq("c12307"));
        addGlobalLayoutListener();
        if (ae.checkLocationForBaiduLocation(getPageContext().getPageActivity())) {
            com.baidu.adp.lib.c.a.mj().a(true, new a.InterfaceC0019a() { // from class: com.baidu.tieba.write.video.WriteVideoActivity.7
                @Override // com.baidu.adp.lib.c.a.InterfaceC0019a
                public void onLocationGeted(int i, String str, Address address) {
                    if (i == 0 && address != null) {
                        WriteVideoActivity.this.mLat = String.valueOf(address.getLatitude());
                        WriteVideoActivity.this.mLng = String.valueOf(address.getLongitude());
                    }
                }
            });
        }
        if (this.mdW.getVideoInfo() != null && !StringUtils.isNull(this.mdW.getVideoInfo().getVideoPath())) {
            Tm(this.mdW.getVideoInfo().getVideoPath());
        }
    }

    private void Tm(String str) {
        if (g.bql()) {
            if (this.msH != null) {
                this.nbF = this.msH.Nm(str);
            }
            if (this.nbF != null) {
                this.nbF.a(this.kqP);
                this.nbF.cUI();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        com.baidu.adp.lib.f.e.mX().postDelayed(this.nbD, 500L);
        if (this.nbA != null) {
            this.nbA.dGA();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onStop() {
        super.onStop();
        if (this.nbA != null) {
            this.nbA.crX();
        }
    }

    private void dKN() {
        Intent intent = getIntent();
        if (intent != null) {
            Serializable serializableExtra = intent.getSerializableExtra(WriteVideoActivityConfig.VIDEO_INFO);
            if (serializableExtra instanceof VideoInfo) {
                this.mdW.setVideoInfo((VideoInfo) serializableExtra);
            }
            this.mFromForumId = intent.getStringExtra("forum_id");
            this.kPM = intent.getStringExtra("forum_name");
            this.mFe = intent.getIntExtra("pro_zone", -1);
            this.mFrom = intent.getStringExtra("from");
            this.mdW.setForumId(this.mFromForumId);
            this.mdW.setForumName(this.kPM);
            this.mdW.setProZone(this.mFe);
            this.mFg = intent.getStringExtra("video_title");
            if (intent.getSerializableExtra(WriteVideoActivityConfig.FORUM_VIDEO_TITLE) instanceof VideoTitleData) {
                this.mVideoTitleData = (VideoTitleData) intent.getSerializableExtra(WriteVideoActivityConfig.FORUM_VIDEO_TITLE);
            }
            if (intent.getSerializableExtra(WriteVideoActivityConfig.ALL_VIDEO_TITLE) instanceof List) {
                this.mFh = (List) intent.getSerializableExtra(WriteVideoActivityConfig.ALL_VIDEO_TITLE);
            }
            if (getIntent().getSerializableExtra("tab_list") instanceof FrsTabInfoData) {
                this.mFf = (FrsTabInfoData) getIntent().getSerializableExtra("tab_list");
            }
            if (!StringUtils.isNull(this.kPM)) {
                this.nbA.Tp(this.kPM + getResources().getString(R.string.forum));
            } else {
                this.nbA.Tp(this.kPM);
            }
            this.iDT = intent.getStringExtra("KEY_CALL_FROM");
            dKO();
            if (AlbumActivityConfig.FROM_PERSON.equals(this.mFrom)) {
                this.nbH = true;
            }
        }
    }

    private void dKO() {
        if (this.mdW != null && this.nbA != null && this.nbA.getCenterTitleView() != null) {
            TextView centerTitleView = this.nbA.getCenterTitleView();
            if (this.mdW.getProZone() == 1) {
                centerTitleView.setText(R.string.write_zone_profession_title);
            }
        }
    }

    private void dKP() {
        if (StringUtils.isNull(this.mFromForumId) || Long.parseLong(this.mFromForumId) <= 0 || StringUtils.isNull(this.kPM)) {
            this.mdW.setCanNoForum(true);
        } else {
            this.mdW.setCanNoForum(false);
        }
        this.mdW.setForumName(this.kPM);
        this.mdW.setTitle(this.nbA.getContent());
        this.mdW.setContent("");
        this.mdW.setType(0);
        if (this.nbA.dKY() != null) {
            if (this.nbA.dKY().getState() == 0) {
                this.mdW.setPrivacy(false);
            } else {
                this.mdW.setPrivacy(true);
            }
        }
        this.mdW.setToDynamic(this.nbA.isToDynamic());
        if (this.nbA.dKV() != null) {
            this.mdW.setHasLocationData(this.nbA.dKV().bZh());
        }
        this.mdW.setIsNoTitle(TextUtils.isEmpty(this.mdW.getTitle()));
    }

    private void dKQ() {
        showLoadingDialog();
        com.baidu.tieba.write.b.a.a(this.mdW, new a.InterfaceC0825a() { // from class: com.baidu.tieba.write.video.WriteVideoActivity.9
            @Override // com.baidu.tieba.write.b.a.InterfaceC0825a
            public void a(BaseUploadData baseUploadData) {
                com.baidu.tieba.write.b.c.b.dKz().a((VideoUploadData) baseUploadData, new b.a() { // from class: com.baidu.tieba.write.video.WriteVideoActivity.9.1
                    @Override // com.baidu.tieba.write.b.c.b.a
                    public void onSuccess(String str) {
                        WriteVideoActivity.this.xu(com.baidu.tbadk.core.sharedPref.b.bjf().getBoolean(SharedPrefConfig.WRITE_VIDEO_ACTIVITY_SAVE_VIDEO, true));
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

            @Override // com.baidu.tieba.write.b.a.InterfaceC0825a
            public void onError() {
                WriteVideoActivity.this.closeLoadingDialog();
                com.baidu.adp.lib.util.l.showToast(TbadkCoreApplication.getInst(), R.string.publish_dynamic_error);
            }
        }, this.msD);
    }

    private void btz() {
        if (AlbumActivityConfig.FROM_PERSON.equals(this.mFrom)) {
            this.mdW.mDynamicVideoData = new VideoUploadData();
            dKQ();
            return;
        }
        dwX();
        showLoadingDialog();
        this.nbE = Tn(this.mdW != null ? this.mdW.getTitle() : "");
        if (this.ePk == null) {
            this.ePk = new NewWriteModel(this);
        }
        if (!TextUtils.isEmpty(this.iDT)) {
            this.mdW.setCallFrom(this.iDT);
        }
        this.mdW.setPostLatLng(true);
        dKR();
        this.ePk.e(this.mdW);
        this.ePk.b(this.ePy);
        this.ePk.a(this.msD);
        if (!TextUtils.isEmpty(this.mLat) && !TextUtils.isEmpty(this.mLng)) {
            this.mdW.setLat(this.mLat);
            this.mdW.setLng(this.mLng);
            if (g.bql() && this.nbF != null && !this.nbG) {
                com.baidu.adp.lib.f.e.mX().postDelayed(this.nbI, 100L);
            } else {
                this.ePk.dBQ();
            }
        } else if (ae.checkLocationForBaiduLocation(getPageContext().getPageActivity())) {
            com.baidu.adp.lib.c.a.mj().a(true, new a.InterfaceC0019a() { // from class: com.baidu.tieba.write.video.WriteVideoActivity.10
                @Override // com.baidu.adp.lib.c.a.InterfaceC0019a
                public void onLocationGeted(int i, String str, Address address) {
                    if (i == 0 && address != null) {
                        WriteVideoActivity.this.mLat = String.valueOf(address.getLatitude());
                        WriteVideoActivity.this.mLng = String.valueOf(address.getLongitude());
                        WriteVideoActivity.this.mdW.setLat(WriteVideoActivity.this.mLat);
                        WriteVideoActivity.this.mdW.setLng(WriteVideoActivity.this.mLng);
                    }
                    if (!g.bql() || WriteVideoActivity.this.nbF == null || WriteVideoActivity.this.nbG) {
                        WriteVideoActivity.this.ePk.dBQ();
                    } else {
                        com.baidu.adp.lib.f.e.mX().postDelayed(WriteVideoActivity.this.nbI, 100L);
                    }
                }
            });
        } else if (g.bql() && this.nbF != null && !this.nbG) {
            com.baidu.adp.lib.f.e.mX().postDelayed(this.nbI, 100L);
        } else {
            this.ePk.dBQ();
        }
    }

    private void dKR() {
        FrsTabItemData selectedTabItemData;
        if (this.mdW != null && this.nbA != null && this.nbA.dKT() != null && (selectedTabItemData = this.nbA.dKT().getSelectedTabItemData()) != null) {
            this.mdW.setTabId(selectedTabItemData.tabId);
            this.mdW.setTabName(selectedTabItemData.name);
            this.mdW.setIsGeneralTab(selectedTabItemData.isGeneralTab);
        }
    }

    private void bk(Context context, String str) {
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
    public void xu(boolean z) {
        File file;
        File file2 = new File(com.baidu.tieba.video.c.mDE);
        if (!file2.exists()) {
            file2.mkdirs();
        }
        if (z && this.mdW.getVideoInfo().getVideoType() == 1) {
            String str = com.baidu.tieba.video.c.mDE + file.getName();
            n.copyFile(new File(this.mdW.getVideoInfo().getVideoPath()).getAbsolutePath(), str);
            bk(BdBaseApplication.getInst(), str);
        }
        dKS();
        n.deleteFileOrDir(new File(com.baidu.tieba.video.c.mDD));
    }

    private void dKS() {
        VideoInfo videoInfo;
        if (this.mdW != null && (videoInfo = this.mdW.getVideoInfo()) != null && videoInfo.getVideoType() == 2) {
            if ((videoInfo.isCompressedVideo() || videoInfo.getMusicListInfo() != null) && videoInfo.getVideoPath() != null && videoInfo.getVideoPath().contains(com.baidu.tieba.video.c.mDD)) {
                File file = new File(videoInfo.getVideoPath());
                if (file.exists() && file.isFile()) {
                    if (com.baidu.tbadk.core.sharedPref.b.bjf().getBoolean(SharedPrefConfig.WRITE_VIDEO_ACTIVITY_SAVE_VIDEO, true)) {
                        n.copyFile(file.getAbsolutePath(), com.baidu.tieba.video.c.mDE + file.getName());
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
            if (AntiHelper.bC(postWriteCallBackData.getErrorCode(), postWriteCallBackData.getErrorString())) {
                AntiHelper.bh(getPageContext().getPageActivity(), postWriteCallBackData.getErrorString());
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
        this.iAz = new c(getPageContext().getPageActivity());
        this.iAz.setOnCancelListener(this.hQL);
        this.iAz.setCancelable(true);
        this.iAz.setCanceledOnTouchOutside(false);
        com.baidu.adp.lib.f.g.showDialog(this.iAz, getPageContext().getPageActivity());
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity
    public void finish() {
        dwX();
        destroyWaitingDialog();
        this.hQL = null;
        closeLoadingDialog();
        com.baidu.adp.lib.f.e.mX().removeCallbacks(this.nbJ);
        super.finish();
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void destroyWaitingDialog() {
        this.iAz = null;
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
                if (this.nbA.dLa() != null) {
                    this.nbA.dLa().bh(postWriteCallBackData.getSensitiveWords());
                    if (!y.isEmpty(this.nbA.dLa().dJx())) {
                        this.nbA.xw(true);
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
            /* renamed from: bCO */
            public Void doInBackground() {
                File file;
                if (WriteVideoActivity.this.mdW != null && WriteVideoActivity.this.mdW.getVideoInfo() != null && WriteVideoActivity.this.mdW.getVideoInfo().getVideoPath() != null && WriteVideoActivity.this.mdW.getVideoInfo().getVideoPath().contains(com.baidu.tieba.video.c.mDD) && (file = new File(WriteVideoActivity.this.mdW.getVideoInfo().getVideoPath())) != null) {
                    n.copyFile(file.getAbsolutePath(), com.baidu.tieba.video.c.mDE + file.getName());
                }
                n.deleteFileOrDir(new File(com.baidu.tieba.video.c.mDD));
                return null;
            }
        }, new m<Void>() { // from class: com.baidu.tieba.write.video.WriteVideoActivity.4
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tbadk.util.m
            /* renamed from: a */
            public void onReturnDataInUI(Void r1) {
            }
        });
        if (!StringUtils.isNull(this.mFg)) {
            postWriteCallBackData.mFrom = 3;
        } else if (!StringUtils.isNull(this.kPM)) {
            postWriteCallBackData.mFrom = 2;
        } else {
            postWriteCallBackData.mFrom = 1;
        }
        postWriteCallBackData.mVideoTitleData = this.nbE;
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
        this.nbA.onChangeSkinType(i);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        if (this.nbA != null) {
            this.nbA.crX();
        }
        com.baidu.adp.lib.f.e.mX().removeCallbacks(this.nbD);
        com.baidu.adp.lib.f.e.mX().removeCallbacks(this.nbI);
    }

    protected void dwX() {
        if (this.ePk != null) {
            this.ePk.cancelLoadData();
        }
        if (this.nbA.dKV() != null) {
            this.nbA.dKV().dwX();
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i == 4) {
            if (this.iAz != null && this.iAz.isShowing()) {
                com.baidu.adp.lib.f.g.b(this.iAz, getPageContext());
                return true;
            }
            cto();
            return true;
        }
        return super.onKeyDown(i, keyEvent);
    }

    private void cto() {
        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(getPageContext().getPageActivity());
        aVar.nE(R.string.give_up_video_confirm);
        aVar.a(R.string.dialog_ok, new a.b() { // from class: com.baidu.tieba.write.video.WriteVideoActivity.5
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                aVar2.dismiss();
                WriteVideoActivity.this.dwX();
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
        aVar.b(getPageContext()).bia();
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.nbA.dKW()) {
            if (b.nbM - this.nbA.dKU() < 0) {
                showToast(getResources().getString(R.string.video_content_overflow));
            } else if (this.nbA.dLa() != null && this.nbA.dLa().dJz()) {
                showToast(this.nbA.dLa().dJB());
                this.nbA.xw(true);
            } else {
                dKP();
                btz();
            }
        } else if (view == this.nbA.getBackButton()) {
            cto();
        }
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void closeLoadingDialog() {
        if (this.iAz != null) {
            if (this.iAz.isShowing()) {
                com.baidu.adp.lib.f.g.b(this.iAz, getPageContext());
            }
            this.iAz = null;
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
        if (this.nbB.onTouchEvent(motionEvent)) {
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
        this.nbA.xx(z);
    }

    public VideoTitleData Tn(String str) {
        if (!StringUtils.isNull(str) && !y.isEmpty(this.mFh)) {
            Matcher matcher = Pattern.compile("#(.+)#.*").matcher(str);
            if (matcher.find()) {
                String group = matcher.group(1);
                int i = 0;
                while (true) {
                    int i2 = i;
                    if (i2 >= this.mFh.size()) {
                        break;
                    } else if (this.mFh.get(i2) == null || !group.equals(this.mFh.get(i2).name)) {
                        i = i2 + 1;
                    } else {
                        return this.mFh.get(i2);
                    }
                }
            }
        }
        return null;
    }
}
