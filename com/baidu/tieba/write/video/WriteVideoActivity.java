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
import com.baidu.tbadk.coreExtra.data.ag;
import com.baidu.tbadk.coreExtra.model.g;
import com.baidu.tbadk.util.ac;
import com.baidu.tbadk.util.ad;
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
    private final NewWriteModel.d eMD;
    private NewWriteModel eMp;
    private DialogInterface.OnCancelListener hJE;
    private c isX;
    private String kHf;
    private e.a kij;
    private String mFrom;
    private String mFromForumId;
    private InputMethodManager mInputManager;
    public String mLat;
    public String mLng;
    private b mRq;
    private GestureDetector mRr;
    private int mRs;
    private VideoTitleData mRu;
    private e mRv;
    private boolean mRw;
    private Runnable mRy;
    private Runnable mRz;
    private VideoTitleData mVideoTitleData;
    private a.InterfaceC0807a miP;
    private l miT;
    private int mva;
    private FrsTabInfoData mvb;
    private String mvc;
    private List<VideoTitleData> mvd;
    private final WriteData lUg = new WriteData();
    private Runnable mRt = new Runnable() { // from class: com.baidu.tieba.write.video.WriteVideoActivity.1
        @Override // java.lang.Runnable
        public void run() {
            Intent intent = new Intent(MotuVideoConfig.ACTION_FINISH_VIDEO_ALL_ACTIVITY);
            intent.setPackage(TbadkCoreApplication.getInst().getPackageName());
            WriteVideoActivity.this.getPageContext().getPageActivity().sendBroadcast(intent);
        }
    };
    private String iwr = "0";
    private boolean mRx = false;

    public WriteVideoActivity() {
        CustomResponsedMessage runTask = MessageManager.getInstance().runTask(CmdConfigCustom.CMD_GET_VIDEO_PLATFORM_FACTORY, l.class);
        if (runTask != null) {
            this.miT = (l) runTask.getData();
        }
        this.kij = new e.a() { // from class: com.baidu.tieba.write.video.WriteVideoActivity.8
            @Override // com.baidu.tieba.k.e.a
            public void Dd(int i) {
                if (i != 1) {
                    WriteVideoActivity.this.mRw = true;
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
            public void rT(boolean z) {
                WriteVideoActivity.this.mRw = true;
                aq aqVar = new aq("c12621");
                aqVar.ai("obj_locate", 0);
                aqVar.ai("obj_param1", z ? 1 : 0);
                TiebaStatic.log(aqVar);
            }
        };
        this.mRy = new Runnable() { // from class: com.baidu.tieba.write.video.WriteVideoActivity.11
            @Override // java.lang.Runnable
            public void run() {
                if (!g.bpq() || WriteVideoActivity.this.mRv == null || WriteVideoActivity.this.mRw) {
                    if (WriteVideoActivity.this.eMp != null) {
                        WriteVideoActivity.this.eMp.dxS();
                        return;
                    }
                    return;
                }
                com.baidu.adp.lib.f.e.mS().postDelayed(WriteVideoActivity.this.mRy, 100L);
            }
        };
        this.eMD = new NewWriteModel.d() { // from class: com.baidu.tieba.write.video.WriteVideoActivity.12
            @Override // com.baidu.tieba.tbadkCore.writeModel.NewWriteModel.d
            public void callback(boolean z, PostWriteCallBackData postWriteCallBackData, ag agVar, WriteData writeData, AntiData antiData) {
                WriteVideoActivity.this.closeLoadingDialog();
                if (postWriteCallBackData != null && WriteVideoActivity.this.lUg != null) {
                    boolean z2 = com.baidu.tbadk.core.sharedPref.b.bik().getBoolean(MotuVideoConfig.IS_SINGLE_GOD_USER, false);
                    if (WriteVideoActivity.this.lUg != null && WriteVideoActivity.this.lUg.getVideoInfo() != null && writeData != null) {
                        if (!z2 && WriteVideoActivity.this.lUg.getVideoInfo().getVideoDuration() > 8) {
                            writeData.setVideoReviewType(1);
                        } else {
                            writeData.setVideoReviewType(2);
                        }
                    }
                    WriteVideoActivity.this.mRq.dGW();
                    boolean z3 = com.baidu.tbadk.core.sharedPref.b.bik().getBoolean(SharedPrefConfig.WRITE_VIDEO_ACTIVITY_SAVE_VIDEO, true);
                    if (z) {
                        if (WriteVideoActivity.this.lUg != null && WriteVideoActivity.this.lUg.getVideoInfo() != null) {
                            WriteVideoActivity.this.xj(z3);
                            postWriteCallBackData.mVideoMd5 = WriteVideoActivity.this.lUg.getVideoInfo().getVideoMd5();
                        }
                        WriteVideoActivity.this.j(postWriteCallBackData);
                    } else if (postWriteCallBackData != null && postWriteCallBackData.isSensitiveError()) {
                        WriteVideoActivity.this.showToast(postWriteCallBackData.getErrorString());
                        WriteVideoActivity.this.mRq.k(postWriteCallBackData);
                    } else if ((agVar == null || writeData == null || agVar.getVcode_pic_url() == null || AntiHelper.e(antiData)) && postWriteCallBackData != null && postWriteCallBackData.getErrorCode() != 227001) {
                        WriteVideoActivity.this.c(false, postWriteCallBackData);
                    } else if (agVar != null && writeData != null && agVar.getVcode_pic_url() != null) {
                        writeData.setVcodeMD5(agVar.getVcode_md5());
                        writeData.setVcodeUrl(agVar.getVcode_pic_url());
                        writeData.setVcodeExtra(agVar.bmZ());
                        if (com.baidu.tbadk.t.a.CO(agVar.bmY())) {
                            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new NewVcodeActivityConfig(WriteVideoActivity.this.getPageContext().getPageActivity(), RequestResponseCode.REQUEST_VCODE, writeData, false, agVar.bmY())));
                        } else {
                            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new VcodeActivityConfig(WriteVideoActivity.this.getPageContext().getPageActivity(), writeData, RequestResponseCode.REQUEST_VCODE)));
                        }
                    } else if (postWriteCallBackData != null && postWriteCallBackData.getErrorCode() == 227001) {
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AccountAccessActivityConfig(WriteVideoActivity.this.getActivity(), RequestResponseCode.REQUEST_VCODE, writeData, postWriteCallBackData.getAccessState())));
                    }
                }
            }
        };
        this.mRz = new Runnable() { // from class: com.baidu.tieba.write.video.WriteVideoActivity.13
            @Override // java.lang.Runnable
            public void run() {
                if (WriteVideoActivity.this.isX != null) {
                    WriteVideoActivity.this.isX.setPercent(WriteVideoActivity.this.mRs);
                }
            }
        };
        this.miP = new a.InterfaceC0807a() { // from class: com.baidu.tieba.write.video.WriteVideoActivity.14
            @Override // com.baidu.tieba.tbadkCore.c.a.InterfaceC0807a
            public void HS(int i) {
                WriteVideoActivity.this.mRs = i;
                com.baidu.adp.lib.f.e.mS().post(WriteVideoActivity.this.mRz);
            }
        };
        this.hJE = new DialogInterface.OnCancelListener() { // from class: com.baidu.tieba.write.video.WriteVideoActivity.2
            @Override // android.content.DialogInterface.OnCancelListener
            public void onCancel(DialogInterface dialogInterface) {
                WriteVideoActivity.this.destroyWaitingDialog();
                WriteVideoActivity.this.dsZ();
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.mRq = new b(this);
        setSwipeBackEnabled(false);
        dGK();
        this.mRq.xk(this.mRx);
        if (this.lUg.getVideoInfo() != null) {
            if (!StringUtils.isNull(this.mvc)) {
                VideoTitleData videoTitleData = new VideoTitleData();
                videoTitleData.name = this.mvc;
                this.mRq.a(this.lUg.getVideoInfo(), videoTitleData, (List<VideoTitleData>) null);
            } else {
                this.mRq.a(this.lUg.getVideoInfo(), this.mVideoTitleData, this.mvd);
            }
        }
        if (this.mRq.dGS() != null && !this.mRx) {
            this.mRq.dGS().f(this);
        }
        this.mRq.c(this.mvb);
        adjustResizeForSoftInput();
        this.mRr = new GestureDetector(getPageContext().getPageActivity(), new a());
        this.mInputManager = (InputMethodManager) getSystemService("input_method");
        ShowSoftKeyPadDelay(this.mRq.dGU());
        this.mRq.dGU().requestFocus();
        TiebaStatic.log(new aq("c12307"));
        addGlobalLayoutListener();
        if (ae.checkLocationForBaiduLocation(getPageContext().getPageActivity())) {
            com.baidu.adp.lib.c.a.mf().a(true, new a.InterfaceC0018a() { // from class: com.baidu.tieba.write.video.WriteVideoActivity.7
                @Override // com.baidu.adp.lib.c.a.InterfaceC0018a
                public void onLocationGeted(int i, String str, Address address) {
                    if (i == 0 && address != null) {
                        WriteVideoActivity.this.mLat = String.valueOf(address.getLatitude());
                        WriteVideoActivity.this.mLng = String.valueOf(address.getLongitude());
                    }
                }
            });
        }
        if (this.lUg.getVideoInfo() != null && !StringUtils.isNull(this.lUg.getVideoInfo().getVideoPath())) {
            SM(this.lUg.getVideoInfo().getVideoPath());
        }
    }

    private void SM(String str) {
        if (g.bpq()) {
            if (this.miT != null) {
                this.mRv = this.miT.MJ(str);
            }
            if (this.mRv != null) {
                this.mRv.a(this.kij);
                this.mRv.cRb();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        com.baidu.adp.lib.f.e.mS().postDelayed(this.mRt, 500L);
        if (this.mRq != null) {
            this.mRq.dCx();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onStop() {
        super.onStop();
        if (this.mRq != null) {
            this.mRq.coJ();
        }
    }

    private void dGK() {
        Intent intent = getIntent();
        if (intent != null) {
            Serializable serializableExtra = intent.getSerializableExtra(WriteVideoActivityConfig.VIDEO_INFO);
            if (serializableExtra instanceof VideoInfo) {
                this.lUg.setVideoInfo((VideoInfo) serializableExtra);
            }
            this.mFromForumId = intent.getStringExtra("forum_id");
            this.kHf = intent.getStringExtra("forum_name");
            this.mva = intent.getIntExtra("pro_zone", -1);
            this.mFrom = intent.getStringExtra("from");
            this.lUg.setForumId(this.mFromForumId);
            this.lUg.setForumName(this.kHf);
            this.lUg.setProZone(this.mva);
            this.mvc = intent.getStringExtra("video_title");
            if (intent.getSerializableExtra(WriteVideoActivityConfig.FORUM_VIDEO_TITLE) instanceof VideoTitleData) {
                this.mVideoTitleData = (VideoTitleData) intent.getSerializableExtra(WriteVideoActivityConfig.FORUM_VIDEO_TITLE);
            }
            if (intent.getSerializableExtra(WriteVideoActivityConfig.ALL_VIDEO_TITLE) instanceof List) {
                this.mvd = (List) intent.getSerializableExtra(WriteVideoActivityConfig.ALL_VIDEO_TITLE);
            }
            if (getIntent().getSerializableExtra("tab_list") instanceof FrsTabInfoData) {
                this.mvb = (FrsTabInfoData) getIntent().getSerializableExtra("tab_list");
            }
            if (!StringUtils.isNull(this.kHf)) {
                this.mRq.SP(this.kHf + getResources().getString(R.string.forum));
            } else {
                this.mRq.SP(this.kHf);
            }
            this.iwr = intent.getStringExtra("KEY_CALL_FROM");
            dGL();
            if ("main_tab".equals(this.mFrom) || AlbumActivityConfig.FROM_PERSON.equals(this.mFrom)) {
                this.mRx = true;
            }
        }
    }

    private void dGL() {
        if (this.lUg != null && this.mRq != null && this.mRq.getCenterTitleView() != null) {
            TextView centerTitleView = this.mRq.getCenterTitleView();
            if (this.lUg.getProZone() == 1) {
                centerTitleView.setText(R.string.write_zone_profession_title);
            }
        }
    }

    private void dGM() {
        if (StringUtils.isNull(this.mFromForumId) || Long.parseLong(this.mFromForumId) <= 0 || StringUtils.isNull(this.kHf)) {
            this.lUg.setCanNoForum(true);
        } else {
            this.lUg.setCanNoForum(false);
        }
        this.lUg.setForumName(this.kHf);
        this.lUg.setTitle(this.mRq.getContent());
        this.lUg.setContent("");
        this.lUg.setType(0);
        if (this.mRq.dGV() != null) {
            if (this.mRq.dGV().getState() == 0) {
                this.lUg.setPrivacy(false);
            } else {
                this.lUg.setPrivacy(true);
            }
        }
        this.lUg.setToDynamic(this.mRq.isToDynamic());
        if (this.mRq.dGS() != null) {
            this.lUg.setHasLocationData(this.mRq.dGS().bXz());
        }
        this.lUg.setIsNoTitle(TextUtils.isEmpty(this.lUg.getTitle()));
    }

    private void dGN() {
        showLoadingDialog();
        com.baidu.tieba.write.b.a.a(this.lUg, new a.InterfaceC0828a() { // from class: com.baidu.tieba.write.video.WriteVideoActivity.9
            @Override // com.baidu.tieba.write.b.a.InterfaceC0828a
            public void a(BaseUploadData baseUploadData) {
                com.baidu.tieba.write.b.c.b.dGz().a((VideoUploadData) baseUploadData, new b.a() { // from class: com.baidu.tieba.write.video.WriteVideoActivity.9.1
                    @Override // com.baidu.tieba.write.b.c.b.a
                    public void onSuccess(String str) {
                        WriteVideoActivity.this.xj(com.baidu.tbadk.core.sharedPref.b.bik().getBoolean(SharedPrefConfig.WRITE_VIDEO_ACTIVITY_SAVE_VIDEO, true));
                        WriteVideoActivity.this.closeLoadingDialog();
                        PostWriteCallBackData postWriteCallBackData = new PostWriteCallBackData();
                        postWriteCallBackData.setDyamicCallback(true);
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_VIDEO_WRITE_POST_SUCCESS, postWriteCallBackData));
                        WriteVideoActivity.this.finish();
                        com.baidu.adp.lib.util.l.showToast(TbadkCoreApplication.getInst(), R.string.publish_dynamic_success);
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

            @Override // com.baidu.tieba.write.b.a.InterfaceC0828a
            public void onError() {
                WriteVideoActivity.this.closeLoadingDialog();
                com.baidu.adp.lib.util.l.showToast(TbadkCoreApplication.getInst(), R.string.publish_dynamic_error);
            }
        }, this.miP);
    }

    private void bsu() {
        if ("main_tab".equals(this.mFrom) || AlbumActivityConfig.FROM_PERSON.equals(this.mFrom)) {
            this.lUg.mDynamicVideoData = new VideoUploadData();
            dGN();
            return;
        }
        dsZ();
        showLoadingDialog();
        this.mRu = SN(this.lUg != null ? this.lUg.getTitle() : "");
        if (this.eMp == null) {
            this.eMp = new NewWriteModel(this);
        }
        if (!TextUtils.isEmpty(this.iwr)) {
            this.lUg.setCallFrom(this.iwr);
        }
        this.lUg.setPostLatLng(true);
        dGO();
        this.eMp.d(this.lUg);
        this.eMp.b(this.eMD);
        this.eMp.a(this.miP);
        if (!TextUtils.isEmpty(this.mLat) && !TextUtils.isEmpty(this.mLng)) {
            this.lUg.setLat(this.mLat);
            this.lUg.setLng(this.mLng);
            if (g.bpq() && this.mRv != null && !this.mRw) {
                com.baidu.adp.lib.f.e.mS().postDelayed(this.mRy, 100L);
            } else {
                this.eMp.dxS();
            }
        } else if (ae.checkLocationForBaiduLocation(getPageContext().getPageActivity())) {
            com.baidu.adp.lib.c.a.mf().a(true, new a.InterfaceC0018a() { // from class: com.baidu.tieba.write.video.WriteVideoActivity.10
                @Override // com.baidu.adp.lib.c.a.InterfaceC0018a
                public void onLocationGeted(int i, String str, Address address) {
                    if (i == 0 && address != null) {
                        WriteVideoActivity.this.mLat = String.valueOf(address.getLatitude());
                        WriteVideoActivity.this.mLng = String.valueOf(address.getLongitude());
                        WriteVideoActivity.this.lUg.setLat(WriteVideoActivity.this.mLat);
                        WriteVideoActivity.this.lUg.setLng(WriteVideoActivity.this.mLng);
                    }
                    if (!g.bpq() || WriteVideoActivity.this.mRv == null || WriteVideoActivity.this.mRw) {
                        WriteVideoActivity.this.eMp.dxS();
                    } else {
                        com.baidu.adp.lib.f.e.mS().postDelayed(WriteVideoActivity.this.mRy, 100L);
                    }
                }
            });
        } else if (g.bpq() && this.mRv != null && !this.mRw) {
            com.baidu.adp.lib.f.e.mS().postDelayed(this.mRy, 100L);
        } else {
            this.eMp.dxS();
        }
    }

    private void dGO() {
        FrsTabItemData selectedTabItemData;
        if (this.lUg != null && this.mRq != null && this.mRq.dGQ() != null && (selectedTabItemData = this.mRq.dGQ().getSelectedTabItemData()) != null) {
            this.lUg.setTabId(selectedTabItemData.tabId);
            this.lUg.setTabName(selectedTabItemData.name);
            this.lUg.setIsGeneralTab(selectedTabItemData.isGeneralTab);
        }
    }

    private void be(Context context, String str) {
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
    public void xj(boolean z) {
        File file;
        File file2 = new File(com.baidu.tieba.video.c.mtB);
        if (!file2.exists()) {
            file2.mkdirs();
        }
        if (z && this.lUg.getVideoInfo().getVideoType() == 1) {
            String str = com.baidu.tieba.video.c.mtB + file.getName();
            n.copyFile(new File(this.lUg.getVideoInfo().getVideoPath()).getAbsolutePath(), str);
            be(BdBaseApplication.getInst(), str);
        }
        dGP();
        n.deleteFileOrDir(new File(com.baidu.tieba.video.c.mtA));
    }

    private void dGP() {
        VideoInfo videoInfo;
        if (this.lUg != null && (videoInfo = this.lUg.getVideoInfo()) != null && videoInfo.getVideoType() == 2) {
            if ((videoInfo.isCompressedVideo() || videoInfo.getMusicListInfo() != null) && videoInfo.getVideoPath() != null && videoInfo.getVideoPath().contains(com.baidu.tieba.video.c.mtA)) {
                File file = new File(videoInfo.getVideoPath());
                if (file.exists() && file.isFile()) {
                    if (com.baidu.tbadk.core.sharedPref.b.bik().getBoolean(SharedPrefConfig.WRITE_VIDEO_ACTIVITY_SAVE_VIDEO, true)) {
                        n.copyFile(file.getAbsolutePath(), com.baidu.tieba.video.c.mtB + file.getName());
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
            if (AntiHelper.bz(postWriteCallBackData.getErrorCode(), postWriteCallBackData.getErrorString())) {
                AntiHelper.bb(getPageContext().getPageActivity(), postWriteCallBackData.getErrorString());
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
        this.isX = new c(getPageContext().getPageActivity());
        this.isX.setOnCancelListener(this.hJE);
        this.isX.setCancelable(true);
        this.isX.setCanceledOnTouchOutside(false);
        com.baidu.adp.lib.f.g.showDialog(this.isX, getPageContext().getPageActivity());
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity
    public void finish() {
        dsZ();
        destroyWaitingDialog();
        this.hJE = null;
        closeLoadingDialog();
        com.baidu.adp.lib.f.e.mS().removeCallbacks(this.mRz);
        super.finish();
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void destroyWaitingDialog() {
        this.isX = null;
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
                    j(postWriteCallBackData2);
                }
            } else if (intent != null && intent.getExtras() != null && (intent.getExtras().getSerializable("post_write_callback_data") instanceof PostWriteCallBackData) && (postWriteCallBackData = (PostWriteCallBackData) intent.getExtras().getSerializable("post_write_callback_data")) != null && postWriteCallBackData.isSensitiveError()) {
                showToast(postWriteCallBackData.getErrorString());
                if (this.mRq.dGX() != null) {
                    this.mRq.dGX().bf(postWriteCallBackData.getSensitiveWords());
                    if (!y.isEmpty(this.mRq.dGX().dFu())) {
                        this.mRq.xl(true);
                    }
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void j(PostWriteCallBackData postWriteCallBackData) {
        ad.a(new ac<Void>() { // from class: com.baidu.tieba.write.video.WriteVideoActivity.3
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tbadk.util.ac
            /* renamed from: bBB */
            public Void doInBackground() {
                File file;
                if (WriteVideoActivity.this.lUg != null && WriteVideoActivity.this.lUg.getVideoInfo() != null && WriteVideoActivity.this.lUg.getVideoInfo().getVideoPath() != null && WriteVideoActivity.this.lUg.getVideoInfo().getVideoPath().contains(com.baidu.tieba.video.c.mtA) && (file = new File(WriteVideoActivity.this.lUg.getVideoInfo().getVideoPath())) != null) {
                    n.copyFile(file.getAbsolutePath(), com.baidu.tieba.video.c.mtB + file.getName());
                }
                n.deleteFileOrDir(new File(com.baidu.tieba.video.c.mtA));
                return null;
            }
        }, new com.baidu.tbadk.util.l<Void>() { // from class: com.baidu.tieba.write.video.WriteVideoActivity.4
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tbadk.util.l
            /* renamed from: a */
            public void onReturnDataInUI(Void r1) {
            }
        });
        if (!StringUtils.isNull(this.mvc)) {
            postWriteCallBackData.mFrom = 3;
        } else if (!StringUtils.isNull(this.kHf)) {
            postWriteCallBackData.mFrom = 2;
        } else {
            postWriteCallBackData.mFrom = 1;
        }
        postWriteCallBackData.mVideoTitleData = this.mRu;
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
        this.mRq.onChangeSkinType(i);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        if (this.mRq != null) {
            this.mRq.coJ();
        }
        com.baidu.adp.lib.f.e.mS().removeCallbacks(this.mRt);
        com.baidu.adp.lib.f.e.mS().removeCallbacks(this.mRy);
    }

    protected void dsZ() {
        if (this.eMp != null) {
            this.eMp.cancelLoadData();
        }
        if (this.mRq.dGS() != null) {
            this.mRq.dGS().dsZ();
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i == 4) {
            if (this.isX != null && this.isX.isShowing()) {
                com.baidu.adp.lib.f.g.b(this.isX, getPageContext());
                return true;
            }
            cqa();
            return true;
        }
        return super.onKeyDown(i, keyEvent);
    }

    private void cqa() {
        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(getPageContext().getPageActivity());
        aVar.nt(R.string.give_up_video_confirm);
        aVar.a(R.string.dialog_ok, new a.b() { // from class: com.baidu.tieba.write.video.WriteVideoActivity.5
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                aVar2.dismiss();
                WriteVideoActivity.this.dsZ();
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
        aVar.b(getPageContext()).bhg();
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.mRq.dGT()) {
            if (b.mRC - this.mRq.dGR() < 0) {
                showToast(getResources().getString(R.string.video_content_overflow));
            } else if (this.mRq.dGX() != null && this.mRq.dGX().dFw()) {
                showToast(this.mRq.dGX().dFy());
                this.mRq.xl(true);
            } else {
                dGM();
                bsu();
            }
        } else if (view == this.mRq.getBackButton()) {
            cqa();
        }
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void closeLoadingDialog() {
        if (this.isX != null) {
            if (this.isX.isShowing()) {
                com.baidu.adp.lib.f.g.b(this.isX, getPageContext());
            }
            this.isX = null;
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
        if (this.mRr.onTouchEvent(motionEvent)) {
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
        this.mRq.xm(z);
    }

    public VideoTitleData SN(String str) {
        if (!StringUtils.isNull(str) && !y.isEmpty(this.mvd)) {
            Matcher matcher = Pattern.compile("#(.+)#.*").matcher(str);
            if (matcher.find()) {
                String group = matcher.group(1);
                int i = 0;
                while (true) {
                    int i2 = i;
                    if (i2 >= this.mvd.size()) {
                        break;
                    } else if (this.mvd.get(i2) == null || !group.equals(this.mvd.get(i2).name)) {
                        i = i2 + 1;
                    } else {
                        return this.mvd.get(i2);
                    }
                }
            }
        }
        return null;
    }
}
