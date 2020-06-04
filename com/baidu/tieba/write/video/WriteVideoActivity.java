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
import com.baidu.adp.lib.f.g;
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
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.core.util.m;
import com.baidu.tbadk.core.util.v;
import com.baidu.tbadk.core.util.w;
import com.baidu.tbadk.coreExtra.data.VideoInfo;
import com.baidu.tbadk.coreExtra.data.WriteData;
import com.baidu.tbadk.coreExtra.data.ab;
import com.baidu.tbadk.coreExtra.model.f;
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
/* loaded from: classes2.dex */
public class WriteVideoActivity extends BaseActivity<WriteVideoActivity> {
    private NewWriteModel emH;
    private final NewWriteModel.d emV;
    private c hLD;
    private DialogInterface.OnCancelListener hes;
    private String jON;
    private e.a jsW;
    private e kzr;
    private int lCo;
    private FrsTabInfoData lCp;
    private String lCq;
    private List<VideoTitleData> lCr;
    private b lWC;
    private GestureDetector lWD;
    private int lWE;
    private VideoTitleData lWG;
    private boolean lWH;
    private Runnable lWJ;
    private Runnable lWK;
    private a.InterfaceC0728a lqd;
    private l lqh;
    private String mFrom;
    private String mFromForumId;
    private InputMethodManager mInputManager;
    public String mLat;
    public String mLng;
    private VideoTitleData mVideoTitleData;
    private final WriteData lbl = new WriteData();
    private Runnable lWF = new Runnable() { // from class: com.baidu.tieba.write.video.WriteVideoActivity.1
        @Override // java.lang.Runnable
        public void run() {
            Intent intent = new Intent(MotuVideoConfig.ACTION_FINISH_VIDEO_ALL_ACTIVITY);
            intent.setPackage(TbadkCoreApplication.getInst().getPackageName());
            WriteVideoActivity.this.getPageContext().getPageActivity().sendBroadcast(intent);
        }
    };
    private String hOW = "0";
    private boolean lWI = false;

    public WriteVideoActivity() {
        CustomResponsedMessage runTask = MessageManager.getInstance().runTask(CmdConfigCustom.CMD_GET_VIDEO_PLATFORM_FACTORY, l.class);
        if (runTask != null) {
            this.lqh = (l) runTask.getData();
        }
        this.jsW = new e.a() { // from class: com.baidu.tieba.write.video.WriteVideoActivity.8
            @Override // com.baidu.tieba.k.e.a
            public void zz(int i) {
                if (i != 1) {
                    WriteVideoActivity.this.lWH = true;
                    return;
                }
                an anVar = new an("c12620");
                anVar.ag("obj_locate", 0);
                TiebaStatic.log(anVar);
            }

            @Override // com.baidu.tieba.k.e.a
            public void onChange(boolean z) {
            }

            @Override // com.baidu.tieba.k.e.a
            public void qw(boolean z) {
                WriteVideoActivity.this.lWH = true;
                an anVar = new an("c12621");
                anVar.ag("obj_locate", 0);
                anVar.ag("obj_param1", z ? 1 : 0);
                TiebaStatic.log(anVar);
            }
        };
        this.lWJ = new Runnable() { // from class: com.baidu.tieba.write.video.WriteVideoActivity.11
            @Override // java.lang.Runnable
            public void run() {
                if (!f.baK() || WriteVideoActivity.this.kzr == null || WriteVideoActivity.this.lWH) {
                    if (WriteVideoActivity.this.emH != null) {
                        WriteVideoActivity.this.emH.dfc();
                        return;
                    }
                    return;
                }
                com.baidu.adp.lib.f.e.ld().postDelayed(WriteVideoActivity.this.lWJ, 100L);
            }
        };
        this.emV = new NewWriteModel.d() { // from class: com.baidu.tieba.write.video.WriteVideoActivity.12
            @Override // com.baidu.tieba.tbadkCore.writeModel.NewWriteModel.d
            public void callback(boolean z, PostWriteCallBackData postWriteCallBackData, ab abVar, WriteData writeData, AntiData antiData) {
                File file;
                WriteVideoActivity.this.closeLoadingDialog();
                if (postWriteCallBackData != null && WriteVideoActivity.this.lbl != null) {
                    boolean z2 = com.baidu.tbadk.core.sharedPref.b.aTX().getBoolean(MotuVideoConfig.IS_SINGLE_GOD_USER, false);
                    if (WriteVideoActivity.this.lbl != null && WriteVideoActivity.this.lbl.getVideoInfo() != null && writeData != null) {
                        if (!z2 && WriteVideoActivity.this.lbl.getVideoInfo().getVideoDuration() > 8) {
                            writeData.setVideoReviewType(1);
                        } else {
                            writeData.setVideoReviewType(2);
                        }
                    }
                    WriteVideoActivity.this.lWC.dnX();
                    boolean z3 = com.baidu.tbadk.core.sharedPref.b.aTX().getBoolean(SharedPrefConfig.WRITE_VIDEO_ACTIVITY_SAVE_VIDEO, true);
                    if (z) {
                        if (WriteVideoActivity.this.lbl != null && WriteVideoActivity.this.lbl.getVideoInfo() != null) {
                            File file2 = new File(com.baidu.tieba.video.c.lAP);
                            if (!file2.exists()) {
                                file2.mkdirs();
                            }
                            if (z3 && WriteVideoActivity.this.lbl.getVideoInfo().getVideoType() == 1) {
                                String str = com.baidu.tieba.video.c.lAP + file.getName();
                                m.copyFile(new File(WriteVideoActivity.this.lbl.getVideoInfo().getVideoPath()).getAbsolutePath(), str);
                                WriteVideoActivity.this.ba(BdBaseApplication.getInst(), str);
                            }
                            WriteVideoActivity.this.dnQ();
                            m.deleteFileOrDir(new File(com.baidu.tieba.video.c.lAO));
                            postWriteCallBackData.mVideoMd5 = WriteVideoActivity.this.lbl.getVideoInfo().getVideoMd5();
                        }
                        WriteVideoActivity.this.i(postWriteCallBackData);
                    } else if (postWriteCallBackData != null && postWriteCallBackData.isSensitiveError()) {
                        WriteVideoActivity.this.showToast(postWriteCallBackData.getErrorString());
                        WriteVideoActivity.this.lWC.j(postWriteCallBackData);
                    } else if ((abVar == null || writeData == null || abVar.getVcode_pic_url() == null || AntiHelper.e(antiData)) && postWriteCallBackData != null && postWriteCallBackData.getErrorCode() != 227001) {
                        WriteVideoActivity.this.c(false, postWriteCallBackData);
                    } else if (abVar != null && writeData != null && abVar.getVcode_pic_url() != null) {
                        writeData.setVcodeMD5(abVar.getVcode_md5());
                        writeData.setVcodeUrl(abVar.getVcode_pic_url());
                        writeData.setVcodeExtra(abVar.aYn());
                        if (com.baidu.tbadk.s.a.yX(abVar.aYm())) {
                            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new NewVcodeActivityConfig(WriteVideoActivity.this.getPageContext().getPageActivity(), RequestResponseCode.REQUEST_VCODE, writeData, false, abVar.aYm())));
                        } else {
                            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new VcodeActivityConfig(WriteVideoActivity.this.getPageContext().getPageActivity(), writeData, RequestResponseCode.REQUEST_VCODE)));
                        }
                    } else if (postWriteCallBackData != null && postWriteCallBackData.getErrorCode() == 227001) {
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AccountAccessActivityConfig(WriteVideoActivity.this.getActivity(), RequestResponseCode.REQUEST_VCODE, writeData, postWriteCallBackData.getAccessState())));
                    }
                }
            }
        };
        this.lWK = new Runnable() { // from class: com.baidu.tieba.write.video.WriteVideoActivity.13
            @Override // java.lang.Runnable
            public void run() {
                if (WriteVideoActivity.this.hLD != null) {
                    WriteVideoActivity.this.hLD.setPercent(WriteVideoActivity.this.lWE);
                }
            }
        };
        this.lqd = new a.InterfaceC0728a() { // from class: com.baidu.tieba.write.video.WriteVideoActivity.14
            @Override // com.baidu.tieba.tbadkCore.c.a.InterfaceC0728a
            public void DX(int i) {
                WriteVideoActivity.this.lWE = i;
                com.baidu.adp.lib.f.e.ld().post(WriteVideoActivity.this.lWK);
            }
        };
        this.hes = new DialogInterface.OnCancelListener() { // from class: com.baidu.tieba.write.video.WriteVideoActivity.2
            @Override // android.content.DialogInterface.OnCancelListener
            public void onCancel(DialogInterface dialogInterface) {
                WriteVideoActivity.this.destroyWaitingDialog();
                WriteVideoActivity.this.dad();
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.lWC = new b(this);
        setSwipeBackEnabled(false);
        dnL();
        this.lWC.vx(this.lWI);
        if (this.lbl.getVideoInfo() != null) {
            if (!StringUtils.isNull(this.lCq)) {
                VideoTitleData videoTitleData = new VideoTitleData();
                videoTitleData.name = this.lCq;
                this.lWC.a(this.lbl.getVideoInfo(), videoTitleData, (List<VideoTitleData>) null);
            } else {
                this.lWC.a(this.lbl.getVideoInfo(), this.mVideoTitleData, this.lCr);
            }
        }
        if (this.lWC.dnT() != null && !this.lWI) {
            this.lWC.dnT().d(this);
        }
        this.lWC.b(this.lCp);
        adjustResizeForSoftInput();
        this.lWD = new GestureDetector(getPageContext().getPageActivity(), new a());
        this.mInputManager = (InputMethodManager) getSystemService("input_method");
        ShowSoftKeyPadDelay(this.lWC.dnV());
        this.lWC.dnV().requestFocus();
        TiebaStatic.log(new an("c12307"));
        addGlobalLayoutListener();
        if (com.baidu.tbadk.core.util.ab.checkLocationForBaiduLocation(getPageContext().getPageActivity())) {
            com.baidu.adp.lib.c.a.kq().a(true, new a.InterfaceC0020a() { // from class: com.baidu.tieba.write.video.WriteVideoActivity.7
                @Override // com.baidu.adp.lib.c.a.InterfaceC0020a
                public void onLocationGeted(int i, String str, Address address) {
                    if (i == 0 && address != null) {
                        WriteVideoActivity.this.mLat = String.valueOf(address.getLatitude());
                        WriteVideoActivity.this.mLng = String.valueOf(address.getLongitude());
                    }
                }
            });
        }
        if (this.lbl.getVideoInfo() != null && !StringUtils.isNull(this.lbl.getVideoInfo().getVideoPath())) {
            Ov(this.lbl.getVideoInfo().getVideoPath());
        }
    }

    private void Ov(String str) {
        if (f.baK()) {
            if (this.lqh != null) {
                this.kzr = this.lqh.ID(str);
            }
            if (this.kzr != null) {
                this.kzr.a(this.jsW);
                this.kzr.cyt();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        com.baidu.adp.lib.f.e.ld().postDelayed(this.lWF, 500L);
        if (this.lWC != null) {
            this.lWC.djC();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onStop() {
        super.onStop();
        if (this.lWC != null) {
            this.lWC.bXv();
        }
    }

    private void dnL() {
        Intent intent = getIntent();
        if (intent != null) {
            Serializable serializableExtra = intent.getSerializableExtra(WriteVideoActivityConfig.VIDEO_INFO);
            if (serializableExtra instanceof VideoInfo) {
                this.lbl.setVideoInfo((VideoInfo) serializableExtra);
            }
            this.mFromForumId = intent.getStringExtra("forum_id");
            this.jON = intent.getStringExtra("forum_name");
            this.lCo = intent.getIntExtra("pro_zone", -1);
            this.mFrom = intent.getStringExtra("from");
            this.lbl.setForumId(this.mFromForumId);
            this.lbl.setForumName(this.jON);
            this.lbl.setProZone(this.lCo);
            this.lCq = intent.getStringExtra("video_title");
            if (intent.getSerializableExtra(WriteVideoActivityConfig.FORUM_VIDEO_TITLE) instanceof VideoTitleData) {
                this.mVideoTitleData = (VideoTitleData) intent.getSerializableExtra(WriteVideoActivityConfig.FORUM_VIDEO_TITLE);
            }
            if (intent.getSerializableExtra(WriteVideoActivityConfig.ALL_VIDEO_TITLE) instanceof List) {
                this.lCr = (List) intent.getSerializableExtra(WriteVideoActivityConfig.ALL_VIDEO_TITLE);
            }
            if (getIntent().getSerializableExtra("tab_list") instanceof FrsTabInfoData) {
                this.lCp = (FrsTabInfoData) getIntent().getSerializableExtra("tab_list");
            }
            if (!StringUtils.isNull(this.jON)) {
                this.lWC.Oy(this.jON + getResources().getString(R.string.forum));
            } else {
                this.lWC.Oy(this.jON);
            }
            this.hOW = intent.getStringExtra("KEY_CALL_FROM");
            dnM();
            if ("main_tab".equals(this.mFrom) || AlbumActivityConfig.FROM_PERSON.equals(this.mFrom)) {
                this.lWI = true;
            }
        }
    }

    private void dnM() {
        if (this.lbl != null && this.lWC != null && this.lWC.getCenterTitleView() != null) {
            TextView centerTitleView = this.lWC.getCenterTitleView();
            if (this.lbl.getProZone() == 1) {
                centerTitleView.setText(R.string.write_zone_profession_title);
            }
        }
    }

    private void dnN() {
        if (StringUtils.isNull(this.mFromForumId) || Long.parseLong(this.mFromForumId) <= 0 || StringUtils.isNull(this.jON)) {
            this.lbl.setCanNoForum(true);
        } else {
            this.lbl.setCanNoForum(false);
        }
        this.lbl.setForumName(this.jON);
        this.lbl.setTitle(this.lWC.getContent());
        this.lbl.setContent("");
        this.lbl.setType(0);
        if (this.lWC.dnW() != null) {
            if (this.lWC.dnW().getState() == 0) {
                this.lbl.setPrivacy(false);
            } else {
                this.lbl.setPrivacy(true);
            }
        }
        this.lbl.setToDynamic(this.lWC.isToDynamic());
        if (this.lWC.dnT() != null) {
            this.lbl.setHasLocationData(this.lWC.dnT().bHo());
        }
        this.lbl.setIsNoTitle(TextUtils.isEmpty(this.lbl.getTitle()));
    }

    private void dnO() {
        showLoadingDialog();
        com.baidu.tieba.write.b.a.a(this.lbl, new a.InterfaceC0749a() { // from class: com.baidu.tieba.write.video.WriteVideoActivity.9
            @Override // com.baidu.tieba.write.b.a.InterfaceC0749a
            public void a(BaseUploadData baseUploadData) {
                com.baidu.tieba.write.b.c.b.dnA().a((VideoUploadData) baseUploadData, new b.a() { // from class: com.baidu.tieba.write.video.WriteVideoActivity.9.1
                    @Override // com.baidu.tieba.write.b.c.b.a
                    public void onSuccess(String str) {
                        WriteVideoActivity.this.closeLoadingDialog();
                        PostWriteCallBackData postWriteCallBackData = new PostWriteCallBackData();
                        postWriteCallBackData.setDyamicCallback(true);
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_VIDEO_WRITE_POST_SUCCESS, postWriteCallBackData));
                        WriteVideoActivity.this.finish();
                        com.baidu.adp.lib.util.l.showToast(TbadkCoreApplication.getInst(), (int) R.string.publish_dynamic_success);
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

            @Override // com.baidu.tieba.write.b.a.InterfaceC0749a
            public void onError() {
                WriteVideoActivity.this.closeLoadingDialog();
                com.baidu.adp.lib.util.l.showToast(TbadkCoreApplication.getInst(), (int) R.string.publish_dynamic_error);
            }
        }, this.lqd);
    }

    private void bdS() {
        if ("main_tab".equals(this.mFrom) || AlbumActivityConfig.FROM_PERSON.equals(this.mFrom)) {
            this.lbl.mDynamicVideoData = new VideoUploadData();
            dnO();
            return;
        }
        dad();
        showLoadingDialog();
        this.lWG = Ow(this.lbl != null ? this.lbl.getTitle() : "");
        if (this.emH == null) {
            this.emH = new NewWriteModel(this);
        }
        if (!TextUtils.isEmpty(this.hOW)) {
            this.lbl.setCallFrom(this.hOW);
        }
        this.lbl.setPostLatLng(true);
        dnP();
        this.emH.d(this.lbl);
        this.emH.b(this.emV);
        this.emH.a(this.lqd);
        if (!TextUtils.isEmpty(this.mLat) && !TextUtils.isEmpty(this.mLng)) {
            this.lbl.setLat(this.mLat);
            this.lbl.setLng(this.mLng);
            if (f.baK() && this.kzr != null && !this.lWH) {
                com.baidu.adp.lib.f.e.ld().postDelayed(this.lWJ, 100L);
            } else {
                this.emH.dfc();
            }
        } else if (com.baidu.tbadk.core.util.ab.checkLocationForBaiduLocation(getPageContext().getPageActivity())) {
            com.baidu.adp.lib.c.a.kq().a(true, new a.InterfaceC0020a() { // from class: com.baidu.tieba.write.video.WriteVideoActivity.10
                @Override // com.baidu.adp.lib.c.a.InterfaceC0020a
                public void onLocationGeted(int i, String str, Address address) {
                    if (i == 0 && address != null) {
                        WriteVideoActivity.this.mLat = String.valueOf(address.getLatitude());
                        WriteVideoActivity.this.mLng = String.valueOf(address.getLongitude());
                        WriteVideoActivity.this.lbl.setLat(WriteVideoActivity.this.mLat);
                        WriteVideoActivity.this.lbl.setLng(WriteVideoActivity.this.mLng);
                    }
                    if (!f.baK() || WriteVideoActivity.this.kzr == null || WriteVideoActivity.this.lWH) {
                        WriteVideoActivity.this.emH.dfc();
                    } else {
                        com.baidu.adp.lib.f.e.ld().postDelayed(WriteVideoActivity.this.lWJ, 100L);
                    }
                }
            });
        } else if (f.baK() && this.kzr != null && !this.lWH) {
            com.baidu.adp.lib.f.e.ld().postDelayed(this.lWJ, 100L);
        } else {
            this.emH.dfc();
        }
    }

    private void dnP() {
        FrsTabItemData selectedTabItemData;
        if (this.lbl != null && this.lWC != null && this.lWC.dnR() != null && (selectedTabItemData = this.lWC.dnR().getSelectedTabItemData()) != null) {
            this.lbl.setTabId(selectedTabItemData.tabId);
            this.lbl.setTabName(selectedTabItemData.name);
            this.lbl.setIsGeneralTab(selectedTabItemData.isGeneralTab);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ba(Context context, String str) {
        if (context != null) {
            try {
                if (!TextUtils.isEmpty(str)) {
                    new w(context).saveVideo(str);
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
    public void dnQ() {
        VideoInfo videoInfo;
        if (this.lbl != null && (videoInfo = this.lbl.getVideoInfo()) != null && videoInfo.getVideoType() == 2) {
            if ((videoInfo.isCompressedVideo() || videoInfo.getMusicListInfo() != null) && videoInfo.getVideoPath() != null && videoInfo.getVideoPath().contains(com.baidu.tieba.video.c.lAO)) {
                File file = new File(videoInfo.getVideoPath());
                if (file.exists() && file.isFile()) {
                    if (com.baidu.tbadk.core.sharedPref.b.aTX().getBoolean(SharedPrefConfig.WRITE_VIDEO_ACTIVITY_SAVE_VIDEO, true)) {
                        m.copyFile(file.getAbsolutePath(), com.baidu.tieba.video.c.lAP + file.getName());
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
            if (AntiHelper.bv(postWriteCallBackData.getErrorCode(), postWriteCallBackData.getErrorString())) {
                AntiHelper.aX(getPageContext().getPageActivity(), postWriteCallBackData.getErrorString());
            } else if (postWriteCallBackData.getErrorCode() != 0) {
                String errorString = postWriteCallBackData.getErrorString();
                if (TextUtils.isEmpty(errorString)) {
                    errorString = getPageContext().getPageActivity().getString(R.string.sand_fail);
                }
                showToast(errorString);
            } else {
                com.baidu.tieba.tbadkCore.writeModel.c.f(getPageContext().getPageActivity(), postWriteCallBackData.getErrorString(), postWriteCallBackData.getPreMsg(), postWriteCallBackData.getColorMsg());
            }
        }
    }

    public void showLoadingDialog() {
        this.hLD = new c(getPageContext().getPageActivity());
        this.hLD.setOnCancelListener(this.hes);
        this.hLD.setCancelable(true);
        this.hLD.setCanceledOnTouchOutside(false);
        g.showDialog(this.hLD, getPageContext().getPageActivity());
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity
    public void finish() {
        dad();
        destroyWaitingDialog();
        this.hes = null;
        closeLoadingDialog();
        com.baidu.adp.lib.f.e.ld().removeCallbacks(this.lWK);
        super.finish();
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void destroyWaitingDialog() {
        this.hLD = null;
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
                    i(postWriteCallBackData2);
                }
            } else if (intent != null && intent.getExtras() != null && (intent.getExtras().getSerializable("post_write_callback_data") instanceof PostWriteCallBackData) && (postWriteCallBackData = (PostWriteCallBackData) intent.getExtras().getSerializable("post_write_callback_data")) != null && postWriteCallBackData.isSensitiveError()) {
                showToast(postWriteCallBackData.getErrorString());
                if (this.lWC.dnY() != null) {
                    this.lWC.dnY().aX(postWriteCallBackData.getSensitiveWords());
                    if (!v.isEmpty(this.lWC.dnY().dmv())) {
                        this.lWC.vy(true);
                    }
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void i(PostWriteCallBackData postWriteCallBackData) {
        ad.a(new ac<Void>() { // from class: com.baidu.tieba.write.video.WriteVideoActivity.3
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tbadk.util.ac
            /* renamed from: bnb */
            public Void doInBackground() {
                File file;
                if (WriteVideoActivity.this.lbl != null && WriteVideoActivity.this.lbl.getVideoInfo() != null && WriteVideoActivity.this.lbl.getVideoInfo().getVideoPath() != null && WriteVideoActivity.this.lbl.getVideoInfo().getVideoPath().contains(com.baidu.tieba.video.c.lAO) && (file = new File(WriteVideoActivity.this.lbl.getVideoInfo().getVideoPath())) != null) {
                    m.copyFile(file.getAbsolutePath(), com.baidu.tieba.video.c.lAP + file.getName());
                }
                m.deleteFileOrDir(new File(com.baidu.tieba.video.c.lAO));
                return null;
            }
        }, new com.baidu.tbadk.util.l<Void>() { // from class: com.baidu.tieba.write.video.WriteVideoActivity.4
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tbadk.util.l
            /* renamed from: a */
            public void onReturnDataInUI(Void r1) {
            }
        });
        if (!StringUtils.isNull(this.lCq)) {
            postWriteCallBackData.mFrom = 3;
        } else if (!StringUtils.isNull(this.jON)) {
            postWriteCallBackData.mFrom = 2;
        } else {
            postWriteCallBackData.mFrom = 1;
        }
        postWriteCallBackData.mVideoTitleData = this.lWG;
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
        this.lWC.onChangeSkinType(i);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        if (this.lWC != null) {
            this.lWC.bXv();
        }
        com.baidu.adp.lib.f.e.ld().removeCallbacks(this.lWF);
        com.baidu.adp.lib.f.e.ld().removeCallbacks(this.lWJ);
    }

    protected void dad() {
        if (this.emH != null) {
            this.emH.cancelLoadData();
        }
        if (this.lWC.dnT() != null) {
            this.lWC.dnT().dad();
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i == 4) {
            if (this.hLD != null && this.hLD.isShowing()) {
                g.b(this.hLD, getPageContext());
                return true;
            }
            bYL();
            return true;
        }
        return super.onKeyDown(i, keyEvent);
    }

    private void bYL() {
        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(getPageContext().getPageActivity());
        aVar.kF(R.string.give_up_video_confirm);
        aVar.a(R.string.dialog_ok, new a.b() { // from class: com.baidu.tieba.write.video.WriteVideoActivity.5
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                aVar2.dismiss();
                WriteVideoActivity.this.dad();
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
        aVar.b(getPageContext()).aST();
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.lWC.dnU()) {
            if (b.lWN - this.lWC.dnS() < 0) {
                showToast(getResources().getString(R.string.video_content_overflow));
            } else if (this.lWC.dnY() != null && this.lWC.dnY().dmx()) {
                showToast(this.lWC.dnY().dmz());
                this.lWC.vy(true);
            } else {
                dnN();
                bdS();
            }
        } else if (view == this.lWC.getBackButton()) {
            bYL();
        }
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void closeLoadingDialog() {
        if (this.hLD != null) {
            if (this.hLD.isShowing()) {
                g.b(this.hLD, getPageContext());
            }
            this.hLD = null;
        }
    }

    /* loaded from: classes2.dex */
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
        if (this.lWD.onTouchEvent(motionEvent)) {
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
        this.lWC.vz(z);
    }

    public VideoTitleData Ow(String str) {
        if (!StringUtils.isNull(str) && !v.isEmpty(this.lCr)) {
            Matcher matcher = Pattern.compile("#(.+)#.*").matcher(str);
            if (matcher.find()) {
                String group = matcher.group(1);
                int i = 0;
                while (true) {
                    int i2 = i;
                    if (i2 >= this.lCr.size()) {
                        break;
                    } else if (this.lCr.get(i2) == null || !group.equals(this.lCr.get(i2).name)) {
                        i = i2 + 1;
                    } else {
                        return this.lCr.get(i2);
                    }
                }
            }
        }
        return null;
    }
}
