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
    private final NewWriteModel.d eMH;
    private NewWriteModel eMt;
    private DialogInterface.OnCancelListener hJK;
    private c itd;
    private String kHm;
    private e.a kiq;
    private String mFrom;
    private String mFromForumId;
    private InputMethodManager mInputManager;
    public String mLat;
    public String mLng;
    private b mRI;
    private GestureDetector mRJ;
    private int mRK;
    private VideoTitleData mRM;
    private e mRN;
    private boolean mRO;
    private Runnable mRQ;
    private Runnable mRR;
    private VideoTitleData mVideoTitleData;
    private a.InterfaceC0807a mje;
    private l mji;
    private int mvs;
    private FrsTabInfoData mvt;
    private String mvu;
    private List<VideoTitleData> mvv;
    private final WriteData lUv = new WriteData();
    private Runnable mRL = new Runnable() { // from class: com.baidu.tieba.write.video.WriteVideoActivity.1
        @Override // java.lang.Runnable
        public void run() {
            Intent intent = new Intent(MotuVideoConfig.ACTION_FINISH_VIDEO_ALL_ACTIVITY);
            intent.setPackage(TbadkCoreApplication.getInst().getPackageName());
            WriteVideoActivity.this.getPageContext().getPageActivity().sendBroadcast(intent);
        }
    };
    private String iwx = "0";
    private boolean mRP = false;

    public WriteVideoActivity() {
        CustomResponsedMessage runTask = MessageManager.getInstance().runTask(CmdConfigCustom.CMD_GET_VIDEO_PLATFORM_FACTORY, l.class);
        if (runTask != null) {
            this.mji = (l) runTask.getData();
        }
        this.kiq = new e.a() { // from class: com.baidu.tieba.write.video.WriteVideoActivity.8
            @Override // com.baidu.tieba.k.e.a
            public void Dd(int i) {
                if (i != 1) {
                    WriteVideoActivity.this.mRO = true;
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
            public void rV(boolean z) {
                WriteVideoActivity.this.mRO = true;
                aq aqVar = new aq("c12621");
                aqVar.ai("obj_locate", 0);
                aqVar.ai("obj_param1", z ? 1 : 0);
                TiebaStatic.log(aqVar);
            }
        };
        this.mRQ = new Runnable() { // from class: com.baidu.tieba.write.video.WriteVideoActivity.11
            @Override // java.lang.Runnable
            public void run() {
                if (!g.bpr() || WriteVideoActivity.this.mRN == null || WriteVideoActivity.this.mRO) {
                    if (WriteVideoActivity.this.eMt != null) {
                        WriteVideoActivity.this.eMt.dxX();
                        return;
                    }
                    return;
                }
                com.baidu.adp.lib.f.e.mS().postDelayed(WriteVideoActivity.this.mRQ, 100L);
            }
        };
        this.eMH = new NewWriteModel.d() { // from class: com.baidu.tieba.write.video.WriteVideoActivity.12
            @Override // com.baidu.tieba.tbadkCore.writeModel.NewWriteModel.d
            public void callback(boolean z, PostWriteCallBackData postWriteCallBackData, ag agVar, WriteData writeData, AntiData antiData) {
                WriteVideoActivity.this.closeLoadingDialog();
                if (postWriteCallBackData != null && WriteVideoActivity.this.lUv != null) {
                    boolean z2 = com.baidu.tbadk.core.sharedPref.b.bik().getBoolean(MotuVideoConfig.IS_SINGLE_GOD_USER, false);
                    if (WriteVideoActivity.this.lUv != null && WriteVideoActivity.this.lUv.getVideoInfo() != null && writeData != null) {
                        if (!z2 && WriteVideoActivity.this.lUv.getVideoInfo().getVideoDuration() > 8) {
                            writeData.setVideoReviewType(1);
                        } else {
                            writeData.setVideoReviewType(2);
                        }
                    }
                    WriteVideoActivity.this.mRI.dHf();
                    boolean z3 = com.baidu.tbadk.core.sharedPref.b.bik().getBoolean(SharedPrefConfig.WRITE_VIDEO_ACTIVITY_SAVE_VIDEO, true);
                    if (z) {
                        if (WriteVideoActivity.this.lUv != null && WriteVideoActivity.this.lUv.getVideoInfo() != null) {
                            WriteVideoActivity.this.xl(z3);
                            postWriteCallBackData.mVideoMd5 = WriteVideoActivity.this.lUv.getVideoInfo().getVideoMd5();
                        }
                        WriteVideoActivity.this.j(postWriteCallBackData);
                    } else if (postWriteCallBackData != null && postWriteCallBackData.isSensitiveError()) {
                        WriteVideoActivity.this.showToast(postWriteCallBackData.getErrorString());
                        WriteVideoActivity.this.mRI.k(postWriteCallBackData);
                    } else if ((agVar == null || writeData == null || agVar.getVcode_pic_url() == null || AntiHelper.e(antiData)) && postWriteCallBackData != null && postWriteCallBackData.getErrorCode() != 227001) {
                        WriteVideoActivity.this.c(false, postWriteCallBackData);
                    } else if (agVar != null && writeData != null && agVar.getVcode_pic_url() != null) {
                        writeData.setVcodeMD5(agVar.getVcode_md5());
                        writeData.setVcodeUrl(agVar.getVcode_pic_url());
                        writeData.setVcodeExtra(agVar.bmZ());
                        if (com.baidu.tbadk.t.a.CP(agVar.bmY())) {
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
        this.mRR = new Runnable() { // from class: com.baidu.tieba.write.video.WriteVideoActivity.13
            @Override // java.lang.Runnable
            public void run() {
                if (WriteVideoActivity.this.itd != null) {
                    WriteVideoActivity.this.itd.setPercent(WriteVideoActivity.this.mRK);
                }
            }
        };
        this.mje = new a.InterfaceC0807a() { // from class: com.baidu.tieba.write.video.WriteVideoActivity.14
            @Override // com.baidu.tieba.tbadkCore.c.a.InterfaceC0807a
            public void HS(int i) {
                WriteVideoActivity.this.mRK = i;
                com.baidu.adp.lib.f.e.mS().post(WriteVideoActivity.this.mRR);
            }
        };
        this.hJK = new DialogInterface.OnCancelListener() { // from class: com.baidu.tieba.write.video.WriteVideoActivity.2
            @Override // android.content.DialogInterface.OnCancelListener
            public void onCancel(DialogInterface dialogInterface) {
                WriteVideoActivity.this.destroyWaitingDialog();
                WriteVideoActivity.this.dte();
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.mRI = new b(this);
        setSwipeBackEnabled(false);
        dGT();
        this.mRI.xm(this.mRP);
        if (this.lUv.getVideoInfo() != null) {
            if (!StringUtils.isNull(this.mvu)) {
                VideoTitleData videoTitleData = new VideoTitleData();
                videoTitleData.name = this.mvu;
                this.mRI.a(this.lUv.getVideoInfo(), videoTitleData, (List<VideoTitleData>) null);
            } else {
                this.mRI.a(this.lUv.getVideoInfo(), this.mVideoTitleData, this.mvv);
            }
        }
        if (this.mRI.dHb() != null && !this.mRP) {
            this.mRI.dHb().f(this);
        }
        this.mRI.c(this.mvt);
        adjustResizeForSoftInput();
        this.mRJ = new GestureDetector(getPageContext().getPageActivity(), new a());
        this.mInputManager = (InputMethodManager) getSystemService("input_method");
        ShowSoftKeyPadDelay(this.mRI.dHd());
        this.mRI.dHd().requestFocus();
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
        if (this.lUv.getVideoInfo() != null && !StringUtils.isNull(this.lUv.getVideoInfo().getVideoPath())) {
            SM(this.lUv.getVideoInfo().getVideoPath());
        }
    }

    private void SM(String str) {
        if (g.bpr()) {
            if (this.mji != null) {
                this.mRN = this.mji.MK(str);
            }
            if (this.mRN != null) {
                this.mRN.a(this.kiq);
                this.mRN.cRc();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        com.baidu.adp.lib.f.e.mS().postDelayed(this.mRL, 500L);
        if (this.mRI != null) {
            this.mRI.dCG();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onStop() {
        super.onStop();
        if (this.mRI != null) {
            this.mRI.coK();
        }
    }

    private void dGT() {
        Intent intent = getIntent();
        if (intent != null) {
            Serializable serializableExtra = intent.getSerializableExtra(WriteVideoActivityConfig.VIDEO_INFO);
            if (serializableExtra instanceof VideoInfo) {
                this.lUv.setVideoInfo((VideoInfo) serializableExtra);
            }
            this.mFromForumId = intent.getStringExtra("forum_id");
            this.kHm = intent.getStringExtra("forum_name");
            this.mvs = intent.getIntExtra("pro_zone", -1);
            this.mFrom = intent.getStringExtra("from");
            this.lUv.setForumId(this.mFromForumId);
            this.lUv.setForumName(this.kHm);
            this.lUv.setProZone(this.mvs);
            this.mvu = intent.getStringExtra("video_title");
            if (intent.getSerializableExtra(WriteVideoActivityConfig.FORUM_VIDEO_TITLE) instanceof VideoTitleData) {
                this.mVideoTitleData = (VideoTitleData) intent.getSerializableExtra(WriteVideoActivityConfig.FORUM_VIDEO_TITLE);
            }
            if (intent.getSerializableExtra(WriteVideoActivityConfig.ALL_VIDEO_TITLE) instanceof List) {
                this.mvv = (List) intent.getSerializableExtra(WriteVideoActivityConfig.ALL_VIDEO_TITLE);
            }
            if (getIntent().getSerializableExtra("tab_list") instanceof FrsTabInfoData) {
                this.mvt = (FrsTabInfoData) getIntent().getSerializableExtra("tab_list");
            }
            if (!StringUtils.isNull(this.kHm)) {
                this.mRI.SP(this.kHm + getResources().getString(R.string.forum));
            } else {
                this.mRI.SP(this.kHm);
            }
            this.iwx = intent.getStringExtra("KEY_CALL_FROM");
            dGU();
            if ("main_tab".equals(this.mFrom) || AlbumActivityConfig.FROM_PERSON.equals(this.mFrom)) {
                this.mRP = true;
            }
        }
    }

    private void dGU() {
        if (this.lUv != null && this.mRI != null && this.mRI.getCenterTitleView() != null) {
            TextView centerTitleView = this.mRI.getCenterTitleView();
            if (this.lUv.getProZone() == 1) {
                centerTitleView.setText(R.string.write_zone_profession_title);
            }
        }
    }

    private void dGV() {
        if (StringUtils.isNull(this.mFromForumId) || Long.parseLong(this.mFromForumId) <= 0 || StringUtils.isNull(this.kHm)) {
            this.lUv.setCanNoForum(true);
        } else {
            this.lUv.setCanNoForum(false);
        }
        this.lUv.setForumName(this.kHm);
        this.lUv.setTitle(this.mRI.getContent());
        this.lUv.setContent("");
        this.lUv.setType(0);
        if (this.mRI.dHe() != null) {
            if (this.mRI.dHe().getState() == 0) {
                this.lUv.setPrivacy(false);
            } else {
                this.lUv.setPrivacy(true);
            }
        }
        this.lUv.setToDynamic(this.mRI.isToDynamic());
        if (this.mRI.dHb() != null) {
            this.lUv.setHasLocationData(this.mRI.dHb().bXA());
        }
        this.lUv.setIsNoTitle(TextUtils.isEmpty(this.lUv.getTitle()));
    }

    private void dGW() {
        showLoadingDialog();
        com.baidu.tieba.write.b.a.a(this.lUv, new a.InterfaceC0828a() { // from class: com.baidu.tieba.write.video.WriteVideoActivity.9
            @Override // com.baidu.tieba.write.b.a.InterfaceC0828a
            public void a(BaseUploadData baseUploadData) {
                com.baidu.tieba.write.b.c.b.dGI().a((VideoUploadData) baseUploadData, new b.a() { // from class: com.baidu.tieba.write.video.WriteVideoActivity.9.1
                    @Override // com.baidu.tieba.write.b.c.b.a
                    public void onSuccess(String str) {
                        WriteVideoActivity.this.xl(com.baidu.tbadk.core.sharedPref.b.bik().getBoolean(SharedPrefConfig.WRITE_VIDEO_ACTIVITY_SAVE_VIDEO, true));
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
        }, this.mje);
    }

    private void bsv() {
        if ("main_tab".equals(this.mFrom) || AlbumActivityConfig.FROM_PERSON.equals(this.mFrom)) {
            this.lUv.mDynamicVideoData = new VideoUploadData();
            dGW();
            return;
        }
        dte();
        showLoadingDialog();
        this.mRM = SN(this.lUv != null ? this.lUv.getTitle() : "");
        if (this.eMt == null) {
            this.eMt = new NewWriteModel(this);
        }
        if (!TextUtils.isEmpty(this.iwx)) {
            this.lUv.setCallFrom(this.iwx);
        }
        this.lUv.setPostLatLng(true);
        dGX();
        this.eMt.d(this.lUv);
        this.eMt.b(this.eMH);
        this.eMt.a(this.mje);
        if (!TextUtils.isEmpty(this.mLat) && !TextUtils.isEmpty(this.mLng)) {
            this.lUv.setLat(this.mLat);
            this.lUv.setLng(this.mLng);
            if (g.bpr() && this.mRN != null && !this.mRO) {
                com.baidu.adp.lib.f.e.mS().postDelayed(this.mRQ, 100L);
            } else {
                this.eMt.dxX();
            }
        } else if (ae.checkLocationForBaiduLocation(getPageContext().getPageActivity())) {
            com.baidu.adp.lib.c.a.mf().a(true, new a.InterfaceC0018a() { // from class: com.baidu.tieba.write.video.WriteVideoActivity.10
                @Override // com.baidu.adp.lib.c.a.InterfaceC0018a
                public void onLocationGeted(int i, String str, Address address) {
                    if (i == 0 && address != null) {
                        WriteVideoActivity.this.mLat = String.valueOf(address.getLatitude());
                        WriteVideoActivity.this.mLng = String.valueOf(address.getLongitude());
                        WriteVideoActivity.this.lUv.setLat(WriteVideoActivity.this.mLat);
                        WriteVideoActivity.this.lUv.setLng(WriteVideoActivity.this.mLng);
                    }
                    if (!g.bpr() || WriteVideoActivity.this.mRN == null || WriteVideoActivity.this.mRO) {
                        WriteVideoActivity.this.eMt.dxX();
                    } else {
                        com.baidu.adp.lib.f.e.mS().postDelayed(WriteVideoActivity.this.mRQ, 100L);
                    }
                }
            });
        } else if (g.bpr() && this.mRN != null && !this.mRO) {
            com.baidu.adp.lib.f.e.mS().postDelayed(this.mRQ, 100L);
        } else {
            this.eMt.dxX();
        }
    }

    private void dGX() {
        FrsTabItemData selectedTabItemData;
        if (this.lUv != null && this.mRI != null && this.mRI.dGZ() != null && (selectedTabItemData = this.mRI.dGZ().getSelectedTabItemData()) != null) {
            this.lUv.setTabId(selectedTabItemData.tabId);
            this.lUv.setTabName(selectedTabItemData.name);
            this.lUv.setIsGeneralTab(selectedTabItemData.isGeneralTab);
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
    public void xl(boolean z) {
        File file;
        File file2 = new File(com.baidu.tieba.video.c.mtT);
        if (!file2.exists()) {
            file2.mkdirs();
        }
        if (z && this.lUv.getVideoInfo().getVideoType() == 1) {
            String str = com.baidu.tieba.video.c.mtT + file.getName();
            n.copyFile(new File(this.lUv.getVideoInfo().getVideoPath()).getAbsolutePath(), str);
            be(BdBaseApplication.getInst(), str);
        }
        dGY();
        n.deleteFileOrDir(new File(com.baidu.tieba.video.c.mtS));
    }

    private void dGY() {
        VideoInfo videoInfo;
        if (this.lUv != null && (videoInfo = this.lUv.getVideoInfo()) != null && videoInfo.getVideoType() == 2) {
            if ((videoInfo.isCompressedVideo() || videoInfo.getMusicListInfo() != null) && videoInfo.getVideoPath() != null && videoInfo.getVideoPath().contains(com.baidu.tieba.video.c.mtS)) {
                File file = new File(videoInfo.getVideoPath());
                if (file.exists() && file.isFile()) {
                    if (com.baidu.tbadk.core.sharedPref.b.bik().getBoolean(SharedPrefConfig.WRITE_VIDEO_ACTIVITY_SAVE_VIDEO, true)) {
                        n.copyFile(file.getAbsolutePath(), com.baidu.tieba.video.c.mtT + file.getName());
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
            if (AntiHelper.by(postWriteCallBackData.getErrorCode(), postWriteCallBackData.getErrorString())) {
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
        this.itd = new c(getPageContext().getPageActivity());
        this.itd.setOnCancelListener(this.hJK);
        this.itd.setCancelable(true);
        this.itd.setCanceledOnTouchOutside(false);
        com.baidu.adp.lib.f.g.showDialog(this.itd, getPageContext().getPageActivity());
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity
    public void finish() {
        dte();
        destroyWaitingDialog();
        this.hJK = null;
        closeLoadingDialog();
        com.baidu.adp.lib.f.e.mS().removeCallbacks(this.mRR);
        super.finish();
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void destroyWaitingDialog() {
        this.itd = null;
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
                if (this.mRI.dHg() != null) {
                    this.mRI.dHg().bf(postWriteCallBackData.getSensitiveWords());
                    if (!y.isEmpty(this.mRI.dHg().dFD())) {
                        this.mRI.xn(true);
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
            /* renamed from: bBC */
            public Void doInBackground() {
                File file;
                if (WriteVideoActivity.this.lUv != null && WriteVideoActivity.this.lUv.getVideoInfo() != null && WriteVideoActivity.this.lUv.getVideoInfo().getVideoPath() != null && WriteVideoActivity.this.lUv.getVideoInfo().getVideoPath().contains(com.baidu.tieba.video.c.mtS) && (file = new File(WriteVideoActivity.this.lUv.getVideoInfo().getVideoPath())) != null) {
                    n.copyFile(file.getAbsolutePath(), com.baidu.tieba.video.c.mtT + file.getName());
                }
                n.deleteFileOrDir(new File(com.baidu.tieba.video.c.mtS));
                return null;
            }
        }, new com.baidu.tbadk.util.l<Void>() { // from class: com.baidu.tieba.write.video.WriteVideoActivity.4
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tbadk.util.l
            /* renamed from: a */
            public void onReturnDataInUI(Void r1) {
            }
        });
        if (!StringUtils.isNull(this.mvu)) {
            postWriteCallBackData.mFrom = 3;
        } else if (!StringUtils.isNull(this.kHm)) {
            postWriteCallBackData.mFrom = 2;
        } else {
            postWriteCallBackData.mFrom = 1;
        }
        postWriteCallBackData.mVideoTitleData = this.mRM;
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
        this.mRI.onChangeSkinType(i);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        if (this.mRI != null) {
            this.mRI.coK();
        }
        com.baidu.adp.lib.f.e.mS().removeCallbacks(this.mRL);
        com.baidu.adp.lib.f.e.mS().removeCallbacks(this.mRQ);
    }

    protected void dte() {
        if (this.eMt != null) {
            this.eMt.cancelLoadData();
        }
        if (this.mRI.dHb() != null) {
            this.mRI.dHb().dte();
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i == 4) {
            if (this.itd != null && this.itd.isShowing()) {
                com.baidu.adp.lib.f.g.b(this.itd, getPageContext());
                return true;
            }
            cqb();
            return true;
        }
        return super.onKeyDown(i, keyEvent);
    }

    private void cqb() {
        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(getPageContext().getPageActivity());
        aVar.nt(R.string.give_up_video_confirm);
        aVar.a(R.string.dialog_ok, new a.b() { // from class: com.baidu.tieba.write.video.WriteVideoActivity.5
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                aVar2.dismiss();
                WriteVideoActivity.this.dte();
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
        if (view == this.mRI.dHc()) {
            if (b.mRU - this.mRI.dHa() < 0) {
                showToast(getResources().getString(R.string.video_content_overflow));
            } else if (this.mRI.dHg() != null && this.mRI.dHg().dFF()) {
                showToast(this.mRI.dHg().dFH());
                this.mRI.xn(true);
            } else {
                dGV();
                bsv();
            }
        } else if (view == this.mRI.getBackButton()) {
            cqb();
        }
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void closeLoadingDialog() {
        if (this.itd != null) {
            if (this.itd.isShowing()) {
                com.baidu.adp.lib.f.g.b(this.itd, getPageContext());
            }
            this.itd = null;
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
        if (this.mRJ.onTouchEvent(motionEvent)) {
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
        this.mRI.xo(z);
    }

    public VideoTitleData SN(String str) {
        if (!StringUtils.isNull(str) && !y.isEmpty(this.mvv)) {
            Matcher matcher = Pattern.compile("#(.+)#.*").matcher(str);
            if (matcher.find()) {
                String group = matcher.group(1);
                int i = 0;
                while (true) {
                    int i2 = i;
                    if (i2 >= this.mvv.size()) {
                        break;
                    } else if (this.mvv.get(i2) == null || !group.equals(this.mvv.get(i2).name)) {
                        i = i2 + 1;
                    } else {
                        return this.mvv.get(i2);
                    }
                }
            }
        }
        return null;
    }
}
