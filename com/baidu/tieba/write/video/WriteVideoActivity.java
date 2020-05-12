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
import com.baidu.tbadk.core.util.ab;
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.core.util.m;
import com.baidu.tbadk.core.util.v;
import com.baidu.tbadk.core.util.w;
import com.baidu.tbadk.coreExtra.data.VideoInfo;
import com.baidu.tbadk.coreExtra.data.WriteData;
import com.baidu.tbadk.coreExtra.data.aa;
import com.baidu.tbadk.coreExtra.model.f;
import com.baidu.tbadk.util.ac;
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
    private final NewWriteModel.d dYM;
    private NewWriteModel dYy;
    private DialogInterface.OnCancelListener gPv;
    private c hwd;
    private e.a jcN;
    private String jwr;
    private a.InterfaceC0674a kWm;
    private l kWq;
    private e kgt;
    private b lCd;
    private GestureDetector lCe;
    private int lCf;
    private VideoTitleData lCh;
    private boolean lCi;
    private Runnable lCk;
    private Runnable lCl;
    private int liu;
    private FrsTabInfoData liv;
    private String liw;
    private List<VideoTitleData> lix;
    private String mFrom;
    private String mFromForumId;
    private InputMethodManager mInputManager;
    public String mLat;
    public String mLng;
    private VideoTitleData mVideoTitleData;
    private final WriteData kHM = new WriteData();
    private Runnable lCg = new Runnable() { // from class: com.baidu.tieba.write.video.WriteVideoActivity.1
        @Override // java.lang.Runnable
        public void run() {
            Intent intent = new Intent(MotuVideoConfig.ACTION_FINISH_VIDEO_ALL_ACTIVITY);
            intent.setPackage(TbadkCoreApplication.getInst().getPackageName());
            WriteVideoActivity.this.getPageContext().getPageActivity().sendBroadcast(intent);
        }
    };
    private String hzw = "0";
    private boolean lCj = false;

    public WriteVideoActivity() {
        CustomResponsedMessage runTask = MessageManager.getInstance().runTask(CmdConfigCustom.CMD_GET_VIDEO_PLATFORM_FACTORY, l.class);
        if (runTask != null) {
            this.kWq = (l) runTask.getData();
        }
        this.jcN = new e.a() { // from class: com.baidu.tieba.write.video.WriteVideoActivity.8
            @Override // com.baidu.tieba.k.e.a
            public void yP(int i) {
                if (i != 1) {
                    WriteVideoActivity.this.lCi = true;
                    return;
                }
                an anVar = new an("c12620");
                anVar.af("obj_locate", 0);
                TiebaStatic.log(anVar);
            }

            @Override // com.baidu.tieba.k.e.a
            public void onChange(boolean z) {
            }

            @Override // com.baidu.tieba.k.e.a
            public void pZ(boolean z) {
                WriteVideoActivity.this.lCi = true;
                an anVar = new an("c12621");
                anVar.af("obj_locate", 0);
                anVar.af("obj_param1", z ? 1 : 0);
                TiebaStatic.log(anVar);
            }
        };
        this.lCk = new Runnable() { // from class: com.baidu.tieba.write.video.WriteVideoActivity.11
            @Override // java.lang.Runnable
            public void run() {
                if (!f.aUz() || WriteVideoActivity.this.kgt == null || WriteVideoActivity.this.lCi) {
                    if (WriteVideoActivity.this.dYy != null) {
                        WriteVideoActivity.this.dYy.cXz();
                        return;
                    }
                    return;
                }
                com.baidu.adp.lib.f.e.lb().postDelayed(WriteVideoActivity.this.lCk, 100L);
            }
        };
        this.dYM = new NewWriteModel.d() { // from class: com.baidu.tieba.write.video.WriteVideoActivity.12
            @Override // com.baidu.tieba.tbadkCore.writeModel.NewWriteModel.d
            public void callback(boolean z, PostWriteCallBackData postWriteCallBackData, aa aaVar, WriteData writeData, AntiData antiData) {
                File file;
                WriteVideoActivity.this.closeLoadingDialog();
                if (postWriteCallBackData != null && WriteVideoActivity.this.kHM != null) {
                    boolean z2 = com.baidu.tbadk.core.sharedPref.b.aNT().getBoolean(MotuVideoConfig.IS_SINGLE_GOD_USER, false);
                    if (WriteVideoActivity.this.kHM != null && WriteVideoActivity.this.kHM.getVideoInfo() != null && writeData != null) {
                        if (!z2 && WriteVideoActivity.this.kHM.getVideoInfo().getVideoDuration() > 8) {
                            writeData.setVideoReviewType(1);
                        } else {
                            writeData.setVideoReviewType(2);
                        }
                    }
                    WriteVideoActivity.this.lCd.dgr();
                    boolean z3 = com.baidu.tbadk.core.sharedPref.b.aNT().getBoolean(SharedPrefConfig.WRITE_VIDEO_ACTIVITY_SAVE_VIDEO, true);
                    if (z) {
                        if (WriteVideoActivity.this.kHM != null && WriteVideoActivity.this.kHM.getVideoInfo() != null) {
                            File file2 = new File(com.baidu.tieba.video.c.lgV);
                            if (!file2.exists()) {
                                file2.mkdirs();
                            }
                            if (z3 && WriteVideoActivity.this.kHM.getVideoInfo().getVideoType() == 1) {
                                String str = com.baidu.tieba.video.c.lgV + file.getName();
                                m.copyFile(new File(WriteVideoActivity.this.kHM.getVideoInfo().getVideoPath()).getAbsolutePath(), str);
                                WriteVideoActivity.this.aZ(BdBaseApplication.getInst(), str);
                            }
                            WriteVideoActivity.this.dgj();
                            m.deleteFileOrDir(new File(com.baidu.tieba.video.c.lgU));
                            postWriteCallBackData.mVideoMd5 = WriteVideoActivity.this.kHM.getVideoInfo().getVideoMd5();
                        }
                        WriteVideoActivity.this.i(postWriteCallBackData);
                    } else if (postWriteCallBackData != null && postWriteCallBackData.isSensitiveError()) {
                        WriteVideoActivity.this.showToast(postWriteCallBackData.getErrorString());
                        WriteVideoActivity.this.lCd.j(postWriteCallBackData);
                    } else if ((aaVar == null || writeData == null || aaVar.getVcode_pic_url() == null || AntiHelper.e(antiData)) && postWriteCallBackData != null && postWriteCallBackData.getErrorCode() != 227001) {
                        WriteVideoActivity.this.c(false, postWriteCallBackData);
                    } else if (aaVar != null && writeData != null && aaVar.getVcode_pic_url() != null) {
                        writeData.setVcodeMD5(aaVar.getVcode_md5());
                        writeData.setVcodeUrl(aaVar.getVcode_pic_url());
                        writeData.setVcodeExtra(aaVar.aSf());
                        if (com.baidu.tbadk.s.a.xr(aaVar.aSe())) {
                            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new NewVcodeActivityConfig(WriteVideoActivity.this.getPageContext().getPageActivity(), RequestResponseCode.REQUEST_VCODE, writeData, false, aaVar.aSe())));
                        } else {
                            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new VcodeActivityConfig(WriteVideoActivity.this.getPageContext().getPageActivity(), writeData, RequestResponseCode.REQUEST_VCODE)));
                        }
                    } else if (postWriteCallBackData != null && postWriteCallBackData.getErrorCode() == 227001) {
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AccountAccessActivityConfig(WriteVideoActivity.this.getActivity(), RequestResponseCode.REQUEST_VCODE, writeData, postWriteCallBackData.getAccessState())));
                    }
                }
            }
        };
        this.lCl = new Runnable() { // from class: com.baidu.tieba.write.video.WriteVideoActivity.13
            @Override // java.lang.Runnable
            public void run() {
                if (WriteVideoActivity.this.hwd != null) {
                    WriteVideoActivity.this.hwd.setPercent(WriteVideoActivity.this.lCf);
                }
            }
        };
        this.kWm = new a.InterfaceC0674a() { // from class: com.baidu.tieba.write.video.WriteVideoActivity.14
            @Override // com.baidu.tieba.tbadkCore.c.a.InterfaceC0674a
            public void Dk(int i) {
                WriteVideoActivity.this.lCf = i;
                com.baidu.adp.lib.f.e.lb().post(WriteVideoActivity.this.lCl);
            }
        };
        this.gPv = new DialogInterface.OnCancelListener() { // from class: com.baidu.tieba.write.video.WriteVideoActivity.2
            @Override // android.content.DialogInterface.OnCancelListener
            public void onCancel(DialogInterface dialogInterface) {
                WriteVideoActivity.this.destroyWaitingDialog();
                WriteVideoActivity.this.cSJ();
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.lCd = new b(this);
        setSwipeBackEnabled(false);
        dge();
        this.lCd.uX(this.lCj);
        if (this.kHM.getVideoInfo() != null) {
            if (!StringUtils.isNull(this.liw)) {
                VideoTitleData videoTitleData = new VideoTitleData();
                videoTitleData.name = this.liw;
                this.lCd.a(this.kHM.getVideoInfo(), videoTitleData, (List<VideoTitleData>) null);
            } else {
                this.lCd.a(this.kHM.getVideoInfo(), this.mVideoTitleData, this.lix);
            }
        }
        if (this.lCd.dgn() != null && !this.lCj) {
            this.lCd.dgn().d(this);
        }
        this.lCd.b(this.liv);
        adjustResizeForSoftInput();
        this.lCe = new GestureDetector(getPageContext().getPageActivity(), new a());
        this.mInputManager = (InputMethodManager) getSystemService("input_method");
        ShowSoftKeyPadDelay(this.lCd.dgp());
        this.lCd.dgp().requestFocus();
        TiebaStatic.log(new an("c12307"));
        addGlobalLayoutListener();
        if (ab.checkLocationForBaiduLocation(getPageContext().getPageActivity())) {
            com.baidu.adp.lib.c.a.ko().a(true, new a.InterfaceC0018a() { // from class: com.baidu.tieba.write.video.WriteVideoActivity.7
                @Override // com.baidu.adp.lib.c.a.InterfaceC0018a
                public void onLocationGeted(int i, String str, Address address) {
                    if (i == 0 && address != null) {
                        WriteVideoActivity.this.mLat = String.valueOf(address.getLatitude());
                        WriteVideoActivity.this.mLng = String.valueOf(address.getLongitude());
                    }
                }
            });
        }
        if (this.kHM.getVideoInfo() != null && !StringUtils.isNull(this.kHM.getVideoInfo().getVideoPath())) {
            MH(this.kHM.getVideoInfo().getVideoPath());
        }
    }

    private void MH(String str) {
        if (f.aUz()) {
            if (this.kWq != null) {
                this.kgt = this.kWq.GT(str);
            }
            if (this.kgt != null) {
                this.kgt.a(this.jcN);
                this.kgt.crz();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        com.baidu.adp.lib.f.e.lb().postDelayed(this.lCg, 500L);
        if (this.lCd != null) {
            this.lCd.dbZ();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onStop() {
        super.onStop();
        if (this.lCd != null) {
            this.lCd.bQX();
        }
    }

    private void dge() {
        Intent intent = getIntent();
        if (intent != null) {
            Serializable serializableExtra = intent.getSerializableExtra(WriteVideoActivityConfig.VIDEO_INFO);
            if (serializableExtra instanceof VideoInfo) {
                this.kHM.setVideoInfo((VideoInfo) serializableExtra);
            }
            this.mFromForumId = intent.getStringExtra("forum_id");
            this.jwr = intent.getStringExtra("forum_name");
            this.liu = intent.getIntExtra("pro_zone", -1);
            this.mFrom = intent.getStringExtra("from");
            this.kHM.setForumId(this.mFromForumId);
            this.kHM.setForumName(this.jwr);
            this.kHM.setProZone(this.liu);
            this.liw = intent.getStringExtra("video_title");
            if (intent.getSerializableExtra(WriteVideoActivityConfig.FORUM_VIDEO_TITLE) instanceof VideoTitleData) {
                this.mVideoTitleData = (VideoTitleData) intent.getSerializableExtra(WriteVideoActivityConfig.FORUM_VIDEO_TITLE);
            }
            if (intent.getSerializableExtra(WriteVideoActivityConfig.ALL_VIDEO_TITLE) instanceof List) {
                this.lix = (List) intent.getSerializableExtra(WriteVideoActivityConfig.ALL_VIDEO_TITLE);
            }
            if (getIntent().getSerializableExtra("tab_list") instanceof FrsTabInfoData) {
                this.liv = (FrsTabInfoData) getIntent().getSerializableExtra("tab_list");
            }
            if (!StringUtils.isNull(this.jwr)) {
                this.lCd.MK(this.jwr + getResources().getString(R.string.forum));
            } else {
                this.lCd.MK(this.jwr);
            }
            this.hzw = intent.getStringExtra("KEY_CALL_FROM");
            dgf();
            if ("main_tab".equals(this.mFrom) || AlbumActivityConfig.FROM_PERSON.equals(this.mFrom)) {
                this.lCj = true;
            }
        }
    }

    private void dgf() {
        if (this.kHM != null && this.lCd != null && this.lCd.getCenterTitleView() != null) {
            TextView centerTitleView = this.lCd.getCenterTitleView();
            if (this.kHM.getProZone() == 1) {
                centerTitleView.setText(R.string.write_zone_profession_title);
            }
        }
    }

    private void dgg() {
        if (StringUtils.isNull(this.mFromForumId) || Long.parseLong(this.mFromForumId) <= 0 || StringUtils.isNull(this.jwr)) {
            this.kHM.setCanNoForum(true);
        } else {
            this.kHM.setCanNoForum(false);
        }
        this.kHM.setForumName(this.jwr);
        this.kHM.setTitle(this.lCd.getContent());
        this.kHM.setContent("");
        this.kHM.setType(0);
        if (this.lCd.dgq() != null) {
            if (this.lCd.dgq().getState() == 0) {
                this.kHM.setPrivacy(false);
            } else {
                this.kHM.setPrivacy(true);
            }
        }
        this.kHM.setToDynamic(this.lCd.isToDynamic());
        if (this.lCd.dgn() != null) {
            this.kHM.setHasLocationData(this.lCd.dgn().bAS());
        }
        this.kHM.setIsNoTitle(TextUtils.isEmpty(this.kHM.getTitle()));
    }

    private void dgh() {
        showLoadingDialog();
        com.baidu.tieba.write.b.a.a(this.kHM, new a.InterfaceC0695a() { // from class: com.baidu.tieba.write.video.WriteVideoActivity.9
            @Override // com.baidu.tieba.write.b.a.InterfaceC0695a
            public void a(BaseUploadData baseUploadData) {
                com.baidu.tieba.write.b.c.b.dfT().a((VideoUploadData) baseUploadData, new b.a() { // from class: com.baidu.tieba.write.video.WriteVideoActivity.9.1
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

            @Override // com.baidu.tieba.write.b.a.InterfaceC0695a
            public void onError() {
                WriteVideoActivity.this.closeLoadingDialog();
                com.baidu.adp.lib.util.l.showToast(TbadkCoreApplication.getInst(), (int) R.string.publish_dynamic_error);
            }
        }, this.kWm);
    }

    private void aXI() {
        if ("main_tab".equals(this.mFrom) || AlbumActivityConfig.FROM_PERSON.equals(this.mFrom)) {
            this.kHM.mDynamicVideoData = new VideoUploadData();
            dgh();
            return;
        }
        cSJ();
        showLoadingDialog();
        this.lCh = MI(this.kHM != null ? this.kHM.getTitle() : "");
        if (this.dYy == null) {
            this.dYy = new NewWriteModel(this);
        }
        if (!TextUtils.isEmpty(this.hzw)) {
            this.kHM.setCallFrom(this.hzw);
        }
        this.kHM.setPostLatLng(true);
        dgi();
        this.dYy.d(this.kHM);
        this.dYy.b(this.dYM);
        this.dYy.a(this.kWm);
        if (!TextUtils.isEmpty(this.mLat) && !TextUtils.isEmpty(this.mLng)) {
            this.kHM.setLat(this.mLat);
            this.kHM.setLng(this.mLng);
            if (f.aUz() && this.kgt != null && !this.lCi) {
                com.baidu.adp.lib.f.e.lb().postDelayed(this.lCk, 100L);
            } else {
                this.dYy.cXz();
            }
        } else if (ab.checkLocationForBaiduLocation(getPageContext().getPageActivity())) {
            com.baidu.adp.lib.c.a.ko().a(true, new a.InterfaceC0018a() { // from class: com.baidu.tieba.write.video.WriteVideoActivity.10
                @Override // com.baidu.adp.lib.c.a.InterfaceC0018a
                public void onLocationGeted(int i, String str, Address address) {
                    if (i == 0 && address != null) {
                        WriteVideoActivity.this.mLat = String.valueOf(address.getLatitude());
                        WriteVideoActivity.this.mLng = String.valueOf(address.getLongitude());
                        WriteVideoActivity.this.kHM.setLat(WriteVideoActivity.this.mLat);
                        WriteVideoActivity.this.kHM.setLng(WriteVideoActivity.this.mLng);
                    }
                    if (!f.aUz() || WriteVideoActivity.this.kgt == null || WriteVideoActivity.this.lCi) {
                        WriteVideoActivity.this.dYy.cXz();
                    } else {
                        com.baidu.adp.lib.f.e.lb().postDelayed(WriteVideoActivity.this.lCk, 100L);
                    }
                }
            });
        } else if (f.aUz() && this.kgt != null && !this.lCi) {
            com.baidu.adp.lib.f.e.lb().postDelayed(this.lCk, 100L);
        } else {
            this.dYy.cXz();
        }
    }

    private void dgi() {
        FrsTabItemData selectedTabItemData;
        if (this.kHM != null && this.lCd != null && this.lCd.dgl() != null && (selectedTabItemData = this.lCd.dgl().getSelectedTabItemData()) != null) {
            this.kHM.setTabId(selectedTabItemData.tabId);
            this.kHM.setTabName(selectedTabItemData.name);
            this.kHM.setIsGeneralTab(selectedTabItemData.isGeneralTab);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aZ(Context context, String str) {
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
    public void dgj() {
        VideoInfo videoInfo;
        if (this.kHM != null && (videoInfo = this.kHM.getVideoInfo()) != null && videoInfo.getVideoType() == 2) {
            if ((videoInfo.isCompressedVideo() || videoInfo.getMusicListInfo() != null) && videoInfo.getVideoPath() != null && videoInfo.getVideoPath().contains(com.baidu.tieba.video.c.lgU)) {
                File file = new File(videoInfo.getVideoPath());
                if (file.exists() && file.isFile()) {
                    if (com.baidu.tbadk.core.sharedPref.b.aNT().getBoolean(SharedPrefConfig.WRITE_VIDEO_ACTIVITY_SAVE_VIDEO, true)) {
                        m.copyFile(file.getAbsolutePath(), com.baidu.tieba.video.c.lgV + file.getName());
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
            if (AntiHelper.bq(postWriteCallBackData.getErrorCode(), postWriteCallBackData.getErrorString())) {
                AntiHelper.aW(getPageContext().getPageActivity(), postWriteCallBackData.getErrorString());
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
        this.hwd = new c(getPageContext().getPageActivity());
        this.hwd.setOnCancelListener(this.gPv);
        this.hwd.setCancelable(true);
        this.hwd.setCanceledOnTouchOutside(false);
        g.showDialog(this.hwd, getPageContext().getPageActivity());
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity
    public void finish() {
        cSJ();
        destroyWaitingDialog();
        this.gPv = null;
        closeLoadingDialog();
        com.baidu.adp.lib.f.e.lb().removeCallbacks(this.lCl);
        super.finish();
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void destroyWaitingDialog() {
        this.hwd = null;
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
                if (this.lCd.dgs() != null) {
                    this.lCd.dgs().aW(postWriteCallBackData.getSensitiveWords());
                    if (!v.isEmpty(this.lCd.dgs().deQ())) {
                        this.lCd.uY(true);
                    }
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void i(PostWriteCallBackData postWriteCallBackData) {
        ac.a(new com.baidu.tbadk.util.ab<Void>() { // from class: com.baidu.tieba.write.video.WriteVideoActivity.3
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tbadk.util.ab
            /* renamed from: bgO */
            public Void doInBackground() {
                File file;
                if (WriteVideoActivity.this.kHM != null && WriteVideoActivity.this.kHM.getVideoInfo() != null && WriteVideoActivity.this.kHM.getVideoInfo().getVideoPath() != null && WriteVideoActivity.this.kHM.getVideoInfo().getVideoPath().contains(com.baidu.tieba.video.c.lgU) && (file = new File(WriteVideoActivity.this.kHM.getVideoInfo().getVideoPath())) != null) {
                    m.copyFile(file.getAbsolutePath(), com.baidu.tieba.video.c.lgV + file.getName());
                }
                m.deleteFileOrDir(new File(com.baidu.tieba.video.c.lgU));
                return null;
            }
        }, new com.baidu.tbadk.util.l<Void>() { // from class: com.baidu.tieba.write.video.WriteVideoActivity.4
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tbadk.util.l
            /* renamed from: a */
            public void onReturnDataInUI(Void r1) {
            }
        });
        if (!StringUtils.isNull(this.liw)) {
            postWriteCallBackData.mFrom = 3;
        } else if (!StringUtils.isNull(this.jwr)) {
            postWriteCallBackData.mFrom = 2;
        } else {
            postWriteCallBackData.mFrom = 1;
        }
        postWriteCallBackData.mVideoTitleData = this.lCh;
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
        this.lCd.onChangeSkinType(i);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        if (this.lCd != null) {
            this.lCd.bQX();
        }
        com.baidu.adp.lib.f.e.lb().removeCallbacks(this.lCg);
        com.baidu.adp.lib.f.e.lb().removeCallbacks(this.lCk);
    }

    protected void cSJ() {
        if (this.dYy != null) {
            this.dYy.cancelLoadData();
        }
        if (this.lCd.dgn() != null) {
            this.lCd.dgn().cSJ();
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i == 4) {
            if (this.hwd != null && this.hwd.isShowing()) {
                g.b(this.hwd, getPageContext());
                return true;
            }
            dgk();
            return true;
        }
        return super.onKeyDown(i, keyEvent);
    }

    private void dgk() {
        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(getPageContext().getPageActivity());
        aVar.kd(R.string.give_up_video_confirm);
        aVar.a(R.string.dialog_ok, new a.b() { // from class: com.baidu.tieba.write.video.WriteVideoActivity.5
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                aVar2.dismiss();
                WriteVideoActivity.this.cSJ();
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
        aVar.b(getPageContext()).aMS();
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.lCd.dgo()) {
            if (b.lCo - this.lCd.dgm() < 0) {
                showToast(getResources().getString(R.string.video_content_overflow));
            } else if (this.lCd.dgs() != null && this.lCd.dgs().deS()) {
                showToast(this.lCd.dgs().deU());
                this.lCd.uY(true);
            } else {
                dgg();
                aXI();
            }
        } else if (view == this.lCd.getBackButton()) {
            dgk();
        }
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void closeLoadingDialog() {
        if (this.hwd != null) {
            if (this.hwd.isShowing()) {
                g.b(this.hwd, getPageContext());
            }
            this.hwd = null;
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
        if (this.lCe.onTouchEvent(motionEvent)) {
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
        this.lCd.uZ(z);
    }

    public VideoTitleData MI(String str) {
        if (!StringUtils.isNull(str) && !v.isEmpty(this.lix)) {
            Matcher matcher = Pattern.compile("#(.+)#.*").matcher(str);
            if (matcher.find()) {
                String group = matcher.group(1);
                int i = 0;
                while (true) {
                    int i2 = i;
                    if (i2 >= this.lix.size()) {
                        break;
                    } else if (this.lix.get(i2) == null || !group.equals(this.lix.get(i2).name)) {
                        i = i2 + 1;
                    } else {
                        return this.lix.get(i2);
                    }
                }
            }
        }
        return null;
    }
}
