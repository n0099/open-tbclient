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
    private final NewWriteModel.d dYH;
    private NewWriteModel dYt;
    private DialogInterface.OnCancelListener gPp;
    private c hvX;
    private e.a jcJ;
    private String jwn;
    private a.InterfaceC0653a kWi;
    private l kWm;
    private e kgp;
    private b lBZ;
    private GestureDetector lCa;
    private int lCb;
    private VideoTitleData lCd;
    private boolean lCe;
    private Runnable lCg;
    private Runnable lCh;
    private int liq;
    private FrsTabInfoData lir;
    private String lis;
    private List<VideoTitleData> lit;
    private String mFrom;
    private String mFromForumId;
    private InputMethodManager mInputManager;
    public String mLat;
    public String mLng;
    private VideoTitleData mVideoTitleData;
    private final WriteData kHI = new WriteData();
    private Runnable lCc = new Runnable() { // from class: com.baidu.tieba.write.video.WriteVideoActivity.1
        @Override // java.lang.Runnable
        public void run() {
            Intent intent = new Intent(MotuVideoConfig.ACTION_FINISH_VIDEO_ALL_ACTIVITY);
            intent.setPackage(TbadkCoreApplication.getInst().getPackageName());
            WriteVideoActivity.this.getPageContext().getPageActivity().sendBroadcast(intent);
        }
    };
    private String hzq = "0";
    private boolean lCf = false;

    public WriteVideoActivity() {
        CustomResponsedMessage runTask = MessageManager.getInstance().runTask(CmdConfigCustom.CMD_GET_VIDEO_PLATFORM_FACTORY, l.class);
        if (runTask != null) {
            this.kWm = (l) runTask.getData();
        }
        this.jcJ = new e.a() { // from class: com.baidu.tieba.write.video.WriteVideoActivity.8
            @Override // com.baidu.tieba.k.e.a
            public void yP(int i) {
                if (i != 1) {
                    WriteVideoActivity.this.lCe = true;
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
                WriteVideoActivity.this.lCe = true;
                an anVar = new an("c12621");
                anVar.af("obj_locate", 0);
                anVar.af("obj_param1", z ? 1 : 0);
                TiebaStatic.log(anVar);
            }
        };
        this.lCg = new Runnable() { // from class: com.baidu.tieba.write.video.WriteVideoActivity.11
            @Override // java.lang.Runnable
            public void run() {
                if (!f.aUB() || WriteVideoActivity.this.kgp == null || WriteVideoActivity.this.lCe) {
                    if (WriteVideoActivity.this.dYt != null) {
                        WriteVideoActivity.this.dYt.cXB();
                        return;
                    }
                    return;
                }
                com.baidu.adp.lib.f.e.lb().postDelayed(WriteVideoActivity.this.lCg, 100L);
            }
        };
        this.dYH = new NewWriteModel.d() { // from class: com.baidu.tieba.write.video.WriteVideoActivity.12
            @Override // com.baidu.tieba.tbadkCore.writeModel.NewWriteModel.d
            public void callback(boolean z, PostWriteCallBackData postWriteCallBackData, aa aaVar, WriteData writeData, AntiData antiData) {
                File file;
                WriteVideoActivity.this.closeLoadingDialog();
                if (postWriteCallBackData != null && WriteVideoActivity.this.kHI != null) {
                    boolean z2 = com.baidu.tbadk.core.sharedPref.b.aNV().getBoolean(MotuVideoConfig.IS_SINGLE_GOD_USER, false);
                    if (WriteVideoActivity.this.kHI != null && WriteVideoActivity.this.kHI.getVideoInfo() != null && writeData != null) {
                        if (!z2 && WriteVideoActivity.this.kHI.getVideoInfo().getVideoDuration() > 8) {
                            writeData.setVideoReviewType(1);
                        } else {
                            writeData.setVideoReviewType(2);
                        }
                    }
                    WriteVideoActivity.this.lBZ.dgt();
                    boolean z3 = com.baidu.tbadk.core.sharedPref.b.aNV().getBoolean(SharedPrefConfig.WRITE_VIDEO_ACTIVITY_SAVE_VIDEO, true);
                    if (z) {
                        if (WriteVideoActivity.this.kHI != null && WriteVideoActivity.this.kHI.getVideoInfo() != null) {
                            File file2 = new File(com.baidu.tieba.video.c.lgR);
                            if (!file2.exists()) {
                                file2.mkdirs();
                            }
                            if (z3 && WriteVideoActivity.this.kHI.getVideoInfo().getVideoType() == 1) {
                                String str = com.baidu.tieba.video.c.lgR + file.getName();
                                m.copyFile(new File(WriteVideoActivity.this.kHI.getVideoInfo().getVideoPath()).getAbsolutePath(), str);
                                WriteVideoActivity.this.bl(BdBaseApplication.getInst(), str);
                            }
                            WriteVideoActivity.this.dgl();
                            m.deleteFileOrDir(new File(com.baidu.tieba.video.c.lgQ));
                            postWriteCallBackData.mVideoMd5 = WriteVideoActivity.this.kHI.getVideoInfo().getVideoMd5();
                        }
                        WriteVideoActivity.this.i(postWriteCallBackData);
                    } else if (postWriteCallBackData != null && postWriteCallBackData.isSensitiveError()) {
                        WriteVideoActivity.this.showToast(postWriteCallBackData.getErrorString());
                        WriteVideoActivity.this.lBZ.j(postWriteCallBackData);
                    } else if ((aaVar == null || writeData == null || aaVar.getVcode_pic_url() == null || AntiHelper.e(antiData)) && postWriteCallBackData != null && postWriteCallBackData.getErrorCode() != 227001) {
                        WriteVideoActivity.this.c(false, postWriteCallBackData);
                    } else if (aaVar != null && writeData != null && aaVar.getVcode_pic_url() != null) {
                        writeData.setVcodeMD5(aaVar.getVcode_md5());
                        writeData.setVcodeUrl(aaVar.getVcode_pic_url());
                        writeData.setVcodeExtra(aaVar.aSi());
                        if (com.baidu.tbadk.s.a.xo(aaVar.aSh())) {
                            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new NewVcodeActivityConfig(WriteVideoActivity.this.getPageContext().getPageActivity(), RequestResponseCode.REQUEST_VCODE, writeData, false, aaVar.aSh())));
                        } else {
                            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new VcodeActivityConfig(WriteVideoActivity.this.getPageContext().getPageActivity(), writeData, RequestResponseCode.REQUEST_VCODE)));
                        }
                    } else if (postWriteCallBackData != null && postWriteCallBackData.getErrorCode() == 227001) {
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AccountAccessActivityConfig(WriteVideoActivity.this.getActivity(), RequestResponseCode.REQUEST_VCODE, writeData, postWriteCallBackData.getAccessState())));
                    }
                }
            }
        };
        this.lCh = new Runnable() { // from class: com.baidu.tieba.write.video.WriteVideoActivity.13
            @Override // java.lang.Runnable
            public void run() {
                if (WriteVideoActivity.this.hvX != null) {
                    WriteVideoActivity.this.hvX.setPercent(WriteVideoActivity.this.lCb);
                }
            }
        };
        this.kWi = new a.InterfaceC0653a() { // from class: com.baidu.tieba.write.video.WriteVideoActivity.14
            @Override // com.baidu.tieba.tbadkCore.c.a.InterfaceC0653a
            public void Dk(int i) {
                WriteVideoActivity.this.lCb = i;
                com.baidu.adp.lib.f.e.lb().post(WriteVideoActivity.this.lCh);
            }
        };
        this.gPp = new DialogInterface.OnCancelListener() { // from class: com.baidu.tieba.write.video.WriteVideoActivity.2
            @Override // android.content.DialogInterface.OnCancelListener
            public void onCancel(DialogInterface dialogInterface) {
                WriteVideoActivity.this.destroyWaitingDialog();
                WriteVideoActivity.this.cSL();
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.lBZ = new b(this);
        setSwipeBackEnabled(false);
        dgg();
        this.lBZ.uX(this.lCf);
        if (this.kHI.getVideoInfo() != null) {
            if (!StringUtils.isNull(this.lis)) {
                VideoTitleData videoTitleData = new VideoTitleData();
                videoTitleData.name = this.lis;
                this.lBZ.a(this.kHI.getVideoInfo(), videoTitleData, (List<VideoTitleData>) null);
            } else {
                this.lBZ.a(this.kHI.getVideoInfo(), this.mVideoTitleData, this.lit);
            }
        }
        if (this.lBZ.dgp() != null && !this.lCf) {
            this.lBZ.dgp().d(this);
        }
        this.lBZ.b(this.lir);
        adjustResizeForSoftInput();
        this.lCa = new GestureDetector(getPageContext().getPageActivity(), new a());
        this.mInputManager = (InputMethodManager) getSystemService("input_method");
        ShowSoftKeyPadDelay(this.lBZ.dgr());
        this.lBZ.dgr().requestFocus();
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
        if (this.kHI.getVideoInfo() != null && !StringUtils.isNull(this.kHI.getVideoInfo().getVideoPath())) {
            ME(this.kHI.getVideoInfo().getVideoPath());
        }
    }

    private void ME(String str) {
        if (f.aUB()) {
            if (this.kWm != null) {
                this.kgp = this.kWm.GQ(str);
            }
            if (this.kgp != null) {
                this.kgp.a(this.jcJ);
                this.kgp.crB();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        com.baidu.adp.lib.f.e.lb().postDelayed(this.lCc, 500L);
        if (this.lBZ != null) {
            this.lBZ.dcb();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onStop() {
        super.onStop();
        if (this.lBZ != null) {
            this.lBZ.bQY();
        }
    }

    private void dgg() {
        Intent intent = getIntent();
        if (intent != null) {
            Serializable serializableExtra = intent.getSerializableExtra(WriteVideoActivityConfig.VIDEO_INFO);
            if (serializableExtra instanceof VideoInfo) {
                this.kHI.setVideoInfo((VideoInfo) serializableExtra);
            }
            this.mFromForumId = intent.getStringExtra("forum_id");
            this.jwn = intent.getStringExtra("forum_name");
            this.liq = intent.getIntExtra("pro_zone", -1);
            this.mFrom = intent.getStringExtra("from");
            this.kHI.setForumId(this.mFromForumId);
            this.kHI.setForumName(this.jwn);
            this.kHI.setProZone(this.liq);
            this.lis = intent.getStringExtra("video_title");
            if (intent.getSerializableExtra(WriteVideoActivityConfig.FORUM_VIDEO_TITLE) instanceof VideoTitleData) {
                this.mVideoTitleData = (VideoTitleData) intent.getSerializableExtra(WriteVideoActivityConfig.FORUM_VIDEO_TITLE);
            }
            if (intent.getSerializableExtra(WriteVideoActivityConfig.ALL_VIDEO_TITLE) instanceof List) {
                this.lit = (List) intent.getSerializableExtra(WriteVideoActivityConfig.ALL_VIDEO_TITLE);
            }
            if (getIntent().getSerializableExtra("tab_list") instanceof FrsTabInfoData) {
                this.lir = (FrsTabInfoData) getIntent().getSerializableExtra("tab_list");
            }
            if (!StringUtils.isNull(this.jwn)) {
                this.lBZ.MH(this.jwn + getResources().getString(R.string.forum));
            } else {
                this.lBZ.MH(this.jwn);
            }
            this.hzq = intent.getStringExtra("KEY_CALL_FROM");
            dgh();
            if ("main_tab".equals(this.mFrom) || AlbumActivityConfig.FROM_PERSON.equals(this.mFrom)) {
                this.lCf = true;
            }
        }
    }

    private void dgh() {
        if (this.kHI != null && this.lBZ != null && this.lBZ.getCenterTitleView() != null) {
            TextView centerTitleView = this.lBZ.getCenterTitleView();
            if (this.kHI.getProZone() == 1) {
                centerTitleView.setText(R.string.write_zone_profession_title);
            }
        }
    }

    private void dgi() {
        if (StringUtils.isNull(this.mFromForumId) || Long.parseLong(this.mFromForumId) <= 0 || StringUtils.isNull(this.jwn)) {
            this.kHI.setCanNoForum(true);
        } else {
            this.kHI.setCanNoForum(false);
        }
        this.kHI.setForumName(this.jwn);
        this.kHI.setTitle(this.lBZ.getContent());
        this.kHI.setContent("");
        this.kHI.setType(0);
        if (this.lBZ.dgs() != null) {
            if (this.lBZ.dgs().getState() == 0) {
                this.kHI.setPrivacy(false);
            } else {
                this.kHI.setPrivacy(true);
            }
        }
        this.kHI.setToDynamic(this.lBZ.isToDynamic());
        if (this.lBZ.dgp() != null) {
            this.kHI.setHasLocationData(this.lBZ.dgp().bAU());
        }
        this.kHI.setIsNoTitle(TextUtils.isEmpty(this.kHI.getTitle()));
    }

    private void dgj() {
        showLoadingDialog();
        com.baidu.tieba.write.b.a.a(this.kHI, new a.InterfaceC0674a() { // from class: com.baidu.tieba.write.video.WriteVideoActivity.9
            @Override // com.baidu.tieba.write.b.a.InterfaceC0674a
            public void a(BaseUploadData baseUploadData) {
                com.baidu.tieba.write.b.c.b.dfV().a((VideoUploadData) baseUploadData, new b.a() { // from class: com.baidu.tieba.write.video.WriteVideoActivity.9.1
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

            @Override // com.baidu.tieba.write.b.a.InterfaceC0674a
            public void onError() {
                WriteVideoActivity.this.closeLoadingDialog();
                com.baidu.adp.lib.util.l.showToast(TbadkCoreApplication.getInst(), (int) R.string.publish_dynamic_error);
            }
        }, this.kWi);
    }

    private void aXK() {
        if ("main_tab".equals(this.mFrom) || AlbumActivityConfig.FROM_PERSON.equals(this.mFrom)) {
            this.kHI.mDynamicVideoData = new VideoUploadData();
            dgj();
            return;
        }
        cSL();
        showLoadingDialog();
        this.lCd = MF(this.kHI != null ? this.kHI.getTitle() : "");
        if (this.dYt == null) {
            this.dYt = new NewWriteModel(this);
        }
        if (!TextUtils.isEmpty(this.hzq)) {
            this.kHI.setCallFrom(this.hzq);
        }
        this.kHI.setPostLatLng(true);
        dgk();
        this.dYt.d(this.kHI);
        this.dYt.b(this.dYH);
        this.dYt.a(this.kWi);
        if (!TextUtils.isEmpty(this.mLat) && !TextUtils.isEmpty(this.mLng)) {
            this.kHI.setLat(this.mLat);
            this.kHI.setLng(this.mLng);
            if (f.aUB() && this.kgp != null && !this.lCe) {
                com.baidu.adp.lib.f.e.lb().postDelayed(this.lCg, 100L);
            } else {
                this.dYt.cXB();
            }
        } else if (ab.checkLocationForBaiduLocation(getPageContext().getPageActivity())) {
            com.baidu.adp.lib.c.a.ko().a(true, new a.InterfaceC0018a() { // from class: com.baidu.tieba.write.video.WriteVideoActivity.10
                @Override // com.baidu.adp.lib.c.a.InterfaceC0018a
                public void onLocationGeted(int i, String str, Address address) {
                    if (i == 0 && address != null) {
                        WriteVideoActivity.this.mLat = String.valueOf(address.getLatitude());
                        WriteVideoActivity.this.mLng = String.valueOf(address.getLongitude());
                        WriteVideoActivity.this.kHI.setLat(WriteVideoActivity.this.mLat);
                        WriteVideoActivity.this.kHI.setLng(WriteVideoActivity.this.mLng);
                    }
                    if (!f.aUB() || WriteVideoActivity.this.kgp == null || WriteVideoActivity.this.lCe) {
                        WriteVideoActivity.this.dYt.cXB();
                    } else {
                        com.baidu.adp.lib.f.e.lb().postDelayed(WriteVideoActivity.this.lCg, 100L);
                    }
                }
            });
        } else if (f.aUB() && this.kgp != null && !this.lCe) {
            com.baidu.adp.lib.f.e.lb().postDelayed(this.lCg, 100L);
        } else {
            this.dYt.cXB();
        }
    }

    private void dgk() {
        FrsTabItemData selectedTabItemData;
        if (this.kHI != null && this.lBZ != null && this.lBZ.dgn() != null && (selectedTabItemData = this.lBZ.dgn().getSelectedTabItemData()) != null) {
            this.kHI.setTabId(selectedTabItemData.tabId);
            this.kHI.setTabName(selectedTabItemData.name);
            this.kHI.setIsGeneralTab(selectedTabItemData.isGeneralTab);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bl(Context context, String str) {
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
    public void dgl() {
        VideoInfo videoInfo;
        if (this.kHI != null && (videoInfo = this.kHI.getVideoInfo()) != null && videoInfo.getVideoType() == 2) {
            if ((videoInfo.isCompressedVideo() || videoInfo.getMusicListInfo() != null) && videoInfo.getVideoPath() != null && videoInfo.getVideoPath().contains(com.baidu.tieba.video.c.lgQ)) {
                File file = new File(videoInfo.getVideoPath());
                if (file.exists() && file.isFile()) {
                    if (com.baidu.tbadk.core.sharedPref.b.aNV().getBoolean(SharedPrefConfig.WRITE_VIDEO_ACTIVITY_SAVE_VIDEO, true)) {
                        m.copyFile(file.getAbsolutePath(), com.baidu.tieba.video.c.lgR + file.getName());
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
                AntiHelper.bi(getPageContext().getPageActivity(), postWriteCallBackData.getErrorString());
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
        this.hvX = new c(getPageContext().getPageActivity());
        this.hvX.setOnCancelListener(this.gPp);
        this.hvX.setCancelable(true);
        this.hvX.setCanceledOnTouchOutside(false);
        g.showDialog(this.hvX, getPageContext().getPageActivity());
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity
    public void finish() {
        cSL();
        destroyWaitingDialog();
        this.gPp = null;
        closeLoadingDialog();
        com.baidu.adp.lib.f.e.lb().removeCallbacks(this.lCh);
        super.finish();
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void destroyWaitingDialog() {
        this.hvX = null;
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
                if (this.lBZ.dgu() != null) {
                    this.lBZ.dgu().aW(postWriteCallBackData.getSensitiveWords());
                    if (!v.isEmpty(this.lBZ.dgu().deS())) {
                        this.lBZ.uY(true);
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
            /* renamed from: bgQ */
            public Void doInBackground() {
                File file;
                if (WriteVideoActivity.this.kHI != null && WriteVideoActivity.this.kHI.getVideoInfo() != null && WriteVideoActivity.this.kHI.getVideoInfo().getVideoPath() != null && WriteVideoActivity.this.kHI.getVideoInfo().getVideoPath().contains(com.baidu.tieba.video.c.lgQ) && (file = new File(WriteVideoActivity.this.kHI.getVideoInfo().getVideoPath())) != null) {
                    m.copyFile(file.getAbsolutePath(), com.baidu.tieba.video.c.lgR + file.getName());
                }
                m.deleteFileOrDir(new File(com.baidu.tieba.video.c.lgQ));
                return null;
            }
        }, new com.baidu.tbadk.util.l<Void>() { // from class: com.baidu.tieba.write.video.WriteVideoActivity.4
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tbadk.util.l
            /* renamed from: a */
            public void onReturnDataInUI(Void r1) {
            }
        });
        if (!StringUtils.isNull(this.lis)) {
            postWriteCallBackData.mFrom = 3;
        } else if (!StringUtils.isNull(this.jwn)) {
            postWriteCallBackData.mFrom = 2;
        } else {
            postWriteCallBackData.mFrom = 1;
        }
        postWriteCallBackData.mVideoTitleData = this.lCd;
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
        this.lBZ.onChangeSkinType(i);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        if (this.lBZ != null) {
            this.lBZ.bQY();
        }
        com.baidu.adp.lib.f.e.lb().removeCallbacks(this.lCc);
        com.baidu.adp.lib.f.e.lb().removeCallbacks(this.lCg);
    }

    protected void cSL() {
        if (this.dYt != null) {
            this.dYt.cancelLoadData();
        }
        if (this.lBZ.dgp() != null) {
            this.lBZ.dgp().cSL();
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i == 4) {
            if (this.hvX != null && this.hvX.isShowing()) {
                g.b(this.hvX, getPageContext());
                return true;
            }
            dgm();
            return true;
        }
        return super.onKeyDown(i, keyEvent);
    }

    private void dgm() {
        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(getPageContext().getPageActivity());
        aVar.kd(R.string.give_up_video_confirm);
        aVar.a(R.string.dialog_ok, new a.b() { // from class: com.baidu.tieba.write.video.WriteVideoActivity.5
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                aVar2.dismiss();
                WriteVideoActivity.this.cSL();
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
        aVar.b(getPageContext()).aMU();
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.lBZ.dgq()) {
            if (b.lCk - this.lBZ.dgo() < 0) {
                showToast(getResources().getString(R.string.video_content_overflow));
            } else if (this.lBZ.dgu() != null && this.lBZ.dgu().deU()) {
                showToast(this.lBZ.dgu().deW());
                this.lBZ.uY(true);
            } else {
                dgi();
                aXK();
            }
        } else if (view == this.lBZ.getBackButton()) {
            dgm();
        }
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void closeLoadingDialog() {
        if (this.hvX != null) {
            if (this.hvX.isShowing()) {
                g.b(this.hvX, getPageContext());
            }
            this.hvX = null;
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
        if (this.lCa.onTouchEvent(motionEvent)) {
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
        this.lBZ.uZ(z);
    }

    public VideoTitleData MF(String str) {
        if (!StringUtils.isNull(str) && !v.isEmpty(this.lit)) {
            Matcher matcher = Pattern.compile("#(.+)#.*").matcher(str);
            if (matcher.find()) {
                String group = matcher.group(1);
                int i = 0;
                while (true) {
                    int i2 = i;
                    if (i2 >= this.lit.size()) {
                        break;
                    } else if (this.lit.get(i2) == null || !group.equals(this.lit.get(i2).name)) {
                        i = i2 + 1;
                    } else {
                        return this.lit.get(i2);
                    }
                }
            }
        }
        return null;
    }
}
