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
import com.baidu.tbadk.core.atomData.EditVideoActivityConfig;
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
import com.baidu.tbadk.coreExtra.data.y;
import com.baidu.tbadk.coreExtra.model.f;
import com.baidu.tbadk.util.ac;
import com.baidu.tieba.R;
import com.baidu.tieba.compatible.StatusBarUtil;
import com.baidu.tieba.j.e;
import com.baidu.tieba.j.l;
import com.baidu.tieba.tbadkCore.c.a;
import com.baidu.tieba.tbadkCore.util.AntiHelper;
import com.baidu.tieba.tbadkCore.writeModel.NewWriteModel;
import com.baidu.tieba.tbadkCore.writeModel.PostWriteCallBackData;
import com.baidu.tieba.video.VideoTitleData;
import com.baidu.tieba.write.b.c;
import java.io.File;
import java.io.Serializable;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
/* loaded from: classes10.dex */
public class WriteVideoActivity extends BaseActivity<WriteVideoActivity> {
    private NewWriteModel dtU;
    private final NewWriteModel.d dui;
    private DialogInterface.OnCancelListener fZZ;
    private c gFW;
    private String iFo;
    private e.a ilp;
    private e jqo;
    private b kMb;
    private GestureDetector kMc;
    private com.baidu.tieba.write.b.c kMd;
    private int kMe;
    private VideoTitleData kMg;
    private boolean kMh;
    private Runnable kMi;
    private Runnable kMj;
    private a.InterfaceC0598a kfI;
    private l kfM;
    private int krE;
    private String krF;
    private List<VideoTitleData> krG;
    private String mFromForumId;
    private InputMethodManager mInputManager;
    public String mLat;
    public String mLng;
    private VideoTitleData mVideoTitleData;
    private final WriteData jSa = new WriteData();
    private Runnable kMf = new Runnable() { // from class: com.baidu.tieba.write.video.WriteVideoActivity.1
        @Override // java.lang.Runnable
        public void run() {
            Intent intent = new Intent(MotuVideoConfig.ACTION_FINISH_VIDEO_ALL_ACTIVITY);
            intent.setPackage(TbadkCoreApplication.getInst().getPackageName());
            WriteVideoActivity.this.getPageContext().getPageActivity().sendBroadcast(intent);
        }
    };
    private String gIK = "0";

    public WriteVideoActivity() {
        CustomResponsedMessage runTask = MessageManager.getInstance().runTask(CmdConfigCustom.CMD_GET_VIDEO_PLATFORM_FACTORY, l.class);
        if (runTask != null) {
            this.kfM = (l) runTask.getData();
        }
        this.ilp = new e.a() { // from class: com.baidu.tieba.write.video.WriteVideoActivity.8
            @Override // com.baidu.tieba.j.e.a
            public void xV(int i) {
                if (i != 1) {
                    WriteVideoActivity.this.kMh = true;
                    return;
                }
                an anVar = new an("c12620");
                anVar.Z("obj_locate", 0);
                TiebaStatic.log(anVar);
            }

            @Override // com.baidu.tieba.j.e.a
            public void onChange(boolean z) {
            }

            @Override // com.baidu.tieba.j.e.a
            public void oA(boolean z) {
                WriteVideoActivity.this.kMh = true;
                an anVar = new an("c12621");
                anVar.Z("obj_locate", 0);
                anVar.Z("obj_param1", z ? 1 : 0);
                TiebaStatic.log(anVar);
            }
        };
        this.kMi = new Runnable() { // from class: com.baidu.tieba.write.video.WriteVideoActivity.11
            @Override // java.lang.Runnable
            public void run() {
                if (!f.aJj() || WriteVideoActivity.this.jqo == null || WriteVideoActivity.this.kMh) {
                    if (WriteVideoActivity.this.dtU != null) {
                        WriteVideoActivity.this.dtU.cJG();
                        return;
                    }
                    return;
                }
                com.baidu.adp.lib.f.e.gy().postDelayed(WriteVideoActivity.this.kMi, 100L);
            }
        };
        this.dui = new NewWriteModel.d() { // from class: com.baidu.tieba.write.video.WriteVideoActivity.12
            @Override // com.baidu.tieba.tbadkCore.writeModel.NewWriteModel.d
            public void callback(boolean z, PostWriteCallBackData postWriteCallBackData, y yVar, WriteData writeData, AntiData antiData) {
                File file;
                WriteVideoActivity.this.closeLoadingDialog();
                if (postWriteCallBackData != null && WriteVideoActivity.this.jSa != null) {
                    boolean z2 = com.baidu.tbadk.core.sharedPref.b.aCY().getBoolean(MotuVideoConfig.IS_SINGLE_GOD_USER, false);
                    if (WriteVideoActivity.this.jSa != null && WriteVideoActivity.this.jSa.getVideoInfo() != null && writeData != null) {
                        if (!z2 && WriteVideoActivity.this.jSa.getVideoInfo().getVideoDuration() > 8) {
                            writeData.setVideoReviewType(1);
                        } else {
                            writeData.setVideoReviewType(2);
                        }
                    }
                    WriteVideoActivity.this.kMb.cSU();
                    boolean z3 = com.baidu.tbadk.core.sharedPref.b.aCY().getBoolean(SharedPrefConfig.WRITE_VIDEO_ACTIVITY_SAVE_VIDEO, true);
                    if (z) {
                        if (WriteVideoActivity.this.jSa != null && WriteVideoActivity.this.jSa.getVideoInfo() != null) {
                            File file2 = new File(com.baidu.tieba.video.c.kqh);
                            if (!file2.exists()) {
                                file2.mkdirs();
                            }
                            if (z3 && WriteVideoActivity.this.jSa.getVideoInfo().getVideoType() == 1) {
                                String str = com.baidu.tieba.video.c.kqh + file.getName();
                                m.copyFile(new File(WriteVideoActivity.this.jSa.getVideoInfo().getVideoPath()).getAbsolutePath(), str);
                                WriteVideoActivity.this.bm(BdBaseApplication.getInst(), str);
                            }
                            WriteVideoActivity.this.cSL();
                            m.deleteFileOrDir(new File(com.baidu.tieba.video.c.kqg));
                            postWriteCallBackData.mVideoMd5 = WriteVideoActivity.this.jSa.getVideoInfo().getVideoMd5();
                        }
                        WriteVideoActivity.this.i(postWriteCallBackData);
                    } else if (postWriteCallBackData != null && postWriteCallBackData.isSensitiveError()) {
                        WriteVideoActivity.this.showToast(postWriteCallBackData.getErrorString());
                        WriteVideoActivity.this.kMb.j(postWriteCallBackData);
                    } else if ((yVar == null || writeData == null || yVar.getVcode_pic_url() == null || AntiHelper.e(antiData)) && postWriteCallBackData != null && postWriteCallBackData.getErrorCode() != 227001) {
                        WriteVideoActivity.this.c(false, postWriteCallBackData);
                    } else if (yVar != null && writeData != null && yVar.getVcode_pic_url() != null) {
                        writeData.setVcodeMD5(yVar.getVcode_md5());
                        writeData.setVcodeUrl(yVar.getVcode_pic_url());
                        writeData.setVcodeExtra(yVar.aGR());
                        if (com.baidu.tbadk.s.a.vB(yVar.aGQ())) {
                            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new NewVcodeActivityConfig(WriteVideoActivity.this.getPageContext().getPageActivity(), RequestResponseCode.REQUEST_VCODE, writeData, false, yVar.aGQ())));
                        } else {
                            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new VcodeActivityConfig(WriteVideoActivity.this.getPageContext().getPageActivity(), writeData, RequestResponseCode.REQUEST_VCODE)));
                        }
                    } else if (postWriteCallBackData != null && postWriteCallBackData.getErrorCode() == 227001) {
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AccountAccessActivityConfig(WriteVideoActivity.this.getActivity(), RequestResponseCode.REQUEST_VCODE, writeData, postWriteCallBackData.getAccessState())));
                    }
                }
            }
        };
        this.kMj = new Runnable() { // from class: com.baidu.tieba.write.video.WriteVideoActivity.13
            @Override // java.lang.Runnable
            public void run() {
                if (WriteVideoActivity.this.gFW != null) {
                    WriteVideoActivity.this.gFW.setPercent(WriteVideoActivity.this.kMe);
                }
            }
        };
        this.kfI = new a.InterfaceC0598a() { // from class: com.baidu.tieba.write.video.WriteVideoActivity.14
            @Override // com.baidu.tieba.tbadkCore.c.a.InterfaceC0598a
            public void Cn(int i) {
                WriteVideoActivity.this.kMe = i;
                com.baidu.adp.lib.f.e.gy().post(WriteVideoActivity.this.kMj);
            }
        };
        this.fZZ = new DialogInterface.OnCancelListener() { // from class: com.baidu.tieba.write.video.WriteVideoActivity.2
            @Override // android.content.DialogInterface.OnCancelListener
            public void onCancel(DialogInterface dialogInterface) {
                WriteVideoActivity.this.destroyWaitingDialog();
                WriteVideoActivity.this.cFg();
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.kMb = new b(this);
        setSwipeBackEnabled(false);
        cSI();
        if (this.jSa.getVideoInfo() != null) {
            if (!StringUtils.isNull(this.krF)) {
                VideoTitleData videoTitleData = new VideoTitleData();
                videoTitleData.name = this.krF;
                this.kMb.a(this.jSa.getVideoInfo(), videoTitleData, (List<VideoTitleData>) null);
            } else {
                this.kMb.a(this.jSa.getVideoInfo(), this.mVideoTitleData, this.krG);
            }
        }
        if (this.kMb.cSQ() != null) {
            this.kMb.cSQ().d(this);
        }
        adjustResizeForSoftInput();
        this.kMc = new GestureDetector(getPageContext().getPageActivity(), new a());
        this.mInputManager = (InputMethodManager) getSystemService("input_method");
        ShowSoftKeyPadDelay(this.kMb.cSS());
        this.kMb.cSS().requestFocus();
        TiebaStatic.log(new an("c12307"));
        addGlobalLayoutListener();
        if (ab.checkLocationForBaiduLocation(getPageContext().getPageActivity())) {
            com.baidu.adp.lib.c.a.fK().a(true, new a.InterfaceC0016a() { // from class: com.baidu.tieba.write.video.WriteVideoActivity.7
                @Override // com.baidu.adp.lib.c.a.InterfaceC0016a
                public void onLocationGeted(int i, String str, Address address) {
                    if (i == 0 && address != null) {
                        WriteVideoActivity.this.mLat = String.valueOf(address.getLatitude());
                        WriteVideoActivity.this.mLng = String.valueOf(address.getLongitude());
                    }
                }
            });
        }
        if (this.jSa.getVideoInfo() != null && !StringUtils.isNull(this.jSa.getVideoInfo().getVideoPath())) {
            KA(this.jSa.getVideoInfo().getVideoPath());
        }
    }

    private void KA(String str) {
        if (f.aJj()) {
            if (this.kfM != null) {
                this.jqo = this.kfM.EJ(str);
            }
            if (this.jqo != null) {
                this.jqo.a(this.ilp);
                this.jqo.cdK();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        com.baidu.adp.lib.f.e.gy().postDelayed(this.kMf, 500L);
        if (this.kMb != null) {
            this.kMb.cOj();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onStop() {
        super.onStop();
        if (this.kMb != null) {
            this.kMb.bDE();
        }
    }

    private void cSI() {
        Intent intent = getIntent();
        if (intent != null) {
            Serializable serializableExtra = intent.getSerializableExtra(WriteVideoActivityConfig.VIDEO_INFO);
            if (serializableExtra instanceof VideoInfo) {
                this.jSa.setVideoInfo((VideoInfo) serializableExtra);
            }
            this.mFromForumId = intent.getStringExtra("forum_id");
            this.iFo = intent.getStringExtra("forum_name");
            this.krE = intent.getIntExtra("pro_zone", -1);
            this.jSa.setForumId(this.mFromForumId);
            this.jSa.setForumName(this.iFo);
            this.jSa.setProZone(this.krE);
            this.krF = intent.getStringExtra("video_title");
            if (intent.getSerializableExtra(WriteVideoActivityConfig.FORUM_VIDEO_TITLE) instanceof VideoTitleData) {
                this.mVideoTitleData = (VideoTitleData) intent.getSerializableExtra(WriteVideoActivityConfig.FORUM_VIDEO_TITLE);
            }
            if (intent.getSerializableExtra(WriteVideoActivityConfig.ALL_VIDEO_TITLE) instanceof List) {
                this.krG = (List) intent.getSerializableExtra(WriteVideoActivityConfig.ALL_VIDEO_TITLE);
            }
            if (!StringUtils.isNull(this.iFo)) {
                this.kMb.KD(this.iFo + getResources().getString(R.string.forum));
            } else {
                this.kMb.KD(this.iFo);
            }
            this.gIK = intent.getStringExtra("KEY_CALL_FROM");
            if (EditVideoActivityConfig.FROM_TYPE_RECORD_VIDEO_ACTIVITY.equals(intent.getStringExtra("from_type"))) {
                this.kMb.cSO();
            }
            cSJ();
        }
    }

    private void cSJ() {
        this.kMd = new com.baidu.tieba.write.b.c(getPageContext().getPageActivity(), this.kMb.getCenterTitleView(), this.jSa.getProZone(), isUseStyleImmersiveSticky() ? StatusBarUtil.getStatusBarOffsetPx(getPageContext().getPageActivity()) : 0);
        this.kMd.a(new c.a() { // from class: com.baidu.tieba.write.video.WriteVideoActivity.9
            @Override // com.baidu.tieba.write.b.c.a
            public void DY(int i) {
                WriteVideoActivity.this.jSa.setProZone(i);
            }
        });
        this.kMd.bvM();
    }

    private void cSK() {
        if (StringUtils.isNull(this.mFromForumId) || Long.parseLong(this.mFromForumId) <= 0 || StringUtils.isNull(this.iFo)) {
            this.jSa.setCanNoForum(true);
        } else {
            this.jSa.setCanNoForum(false);
        }
        this.jSa.setForumName(this.iFo);
        this.jSa.setTitle(this.kMb.getContent());
        this.jSa.setContent("");
        this.jSa.setType(0);
        if (this.kMb.cST() != null) {
            if (this.kMb.cST().getState() == 0) {
                this.jSa.setPrivacy(false);
            } else {
                this.jSa.setPrivacy(true);
            }
        }
        this.jSa.setToDynamic(this.kMb.isToDynamic());
        if (this.kMb.cSQ() != null) {
            this.jSa.setHasLocationData(this.kMb.cSQ().boD());
        }
        this.jSa.setIsNoTitle(TextUtils.isEmpty(this.jSa.getTitle()));
    }

    private void aMx() {
        cFg();
        showLoadingDialog();
        this.kMg = KB(this.jSa != null ? this.jSa.getTitle() : "");
        if (this.dtU == null) {
            this.dtU = new NewWriteModel(this);
        }
        if (!TextUtils.isEmpty(this.gIK)) {
            this.jSa.setCallFrom(this.gIK);
        }
        this.jSa.setPostLatLng(true);
        this.dtU.d(this.jSa);
        this.dtU.b(this.dui);
        this.dtU.a(this.kfI);
        if (!TextUtils.isEmpty(this.mLat) && !TextUtils.isEmpty(this.mLng)) {
            this.jSa.setLat(this.mLat);
            this.jSa.setLng(this.mLng);
            if (f.aJj() && this.jqo != null && !this.kMh) {
                com.baidu.adp.lib.f.e.gy().postDelayed(this.kMi, 100L);
            } else {
                this.dtU.cJG();
            }
        } else if (ab.checkLocationForBaiduLocation(getPageContext().getPageActivity())) {
            com.baidu.adp.lib.c.a.fK().a(true, new a.InterfaceC0016a() { // from class: com.baidu.tieba.write.video.WriteVideoActivity.10
                @Override // com.baidu.adp.lib.c.a.InterfaceC0016a
                public void onLocationGeted(int i, String str, Address address) {
                    if (i == 0 && address != null) {
                        WriteVideoActivity.this.mLat = String.valueOf(address.getLatitude());
                        WriteVideoActivity.this.mLng = String.valueOf(address.getLongitude());
                        WriteVideoActivity.this.jSa.setLat(WriteVideoActivity.this.mLat);
                        WriteVideoActivity.this.jSa.setLng(WriteVideoActivity.this.mLng);
                    }
                    if (!f.aJj() || WriteVideoActivity.this.jqo == null || WriteVideoActivity.this.kMh) {
                        WriteVideoActivity.this.dtU.cJG();
                    } else {
                        com.baidu.adp.lib.f.e.gy().postDelayed(WriteVideoActivity.this.kMi, 100L);
                    }
                }
            });
        } else if (f.aJj() && this.jqo != null && !this.kMh) {
            com.baidu.adp.lib.f.e.gy().postDelayed(this.kMi, 100L);
        } else {
            this.dtU.cJG();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bm(Context context, String str) {
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
    public void cSL() {
        VideoInfo videoInfo;
        if (this.jSa != null && (videoInfo = this.jSa.getVideoInfo()) != null && videoInfo.getVideoType() == 2) {
            if ((videoInfo.isCompressedVideo() || videoInfo.getMusicListInfo() != null) && videoInfo.getVideoPath() != null && videoInfo.getVideoPath().contains(com.baidu.tieba.video.c.kqg)) {
                File file = new File(videoInfo.getVideoPath());
                if (file.exists() && file.isFile()) {
                    if (com.baidu.tbadk.core.sharedPref.b.aCY().getBoolean(SharedPrefConfig.WRITE_VIDEO_ACTIVITY_SAVE_VIDEO, true)) {
                        m.copyFile(file.getAbsolutePath(), com.baidu.tieba.video.c.kqh + file.getName());
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
            if (AntiHelper.aW(postWriteCallBackData.getErrorCode(), postWriteCallBackData.getErrorString())) {
                AntiHelper.bj(getPageContext().getPageActivity(), postWriteCallBackData.getErrorString());
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
        this.gFW = new com.baidu.tbadk.core.dialog.c(getPageContext().getPageActivity());
        this.gFW.setOnCancelListener(this.fZZ);
        this.gFW.setCancelable(true);
        this.gFW.setCanceledOnTouchOutside(false);
        g.showDialog(this.gFW, getPageContext().getPageActivity());
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity
    public void finish() {
        cFg();
        destroyWaitingDialog();
        this.fZZ = null;
        closeLoadingDialog();
        com.baidu.adp.lib.f.e.gy().removeCallbacks(this.kMj);
        super.finish();
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void destroyWaitingDialog() {
        this.gFW = null;
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
                if (this.kMb.cSV() != null) {
                    this.kMb.cSV().aV(postWriteCallBackData.getSensitiveWords());
                    if (!v.isEmpty(this.kMb.cSV().cRH())) {
                        this.kMb.tz(true);
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
            /* renamed from: aVX */
            public Void doInBackground() {
                File file;
                if (WriteVideoActivity.this.jSa != null && WriteVideoActivity.this.jSa.getVideoInfo() != null && WriteVideoActivity.this.jSa.getVideoInfo().getVideoPath() != null && WriteVideoActivity.this.jSa.getVideoInfo().getVideoPath().contains(com.baidu.tieba.video.c.kqg) && (file = new File(WriteVideoActivity.this.jSa.getVideoInfo().getVideoPath())) != null) {
                    m.copyFile(file.getAbsolutePath(), com.baidu.tieba.video.c.kqh + file.getName());
                }
                m.deleteFileOrDir(new File(com.baidu.tieba.video.c.kqg));
                return null;
            }
        }, new com.baidu.tbadk.util.l<Void>() { // from class: com.baidu.tieba.write.video.WriteVideoActivity.4
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tbadk.util.l
            /* renamed from: a */
            public void onReturnDataInUI(Void r1) {
            }
        });
        if (!StringUtils.isNull(this.krF)) {
            postWriteCallBackData.mFrom = 3;
        } else if (!StringUtils.isNull(this.iFo)) {
            postWriteCallBackData.mFrom = 2;
        } else {
            postWriteCallBackData.mFrom = 1;
        }
        postWriteCallBackData.mVideoTitleData = this.kMg;
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
        this.kMb.onChangeSkinType(i);
        if (this.kMd != null) {
            this.kMd.onChangeSkinType(i);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        if (this.kMb != null) {
            this.kMb.bDE();
        }
        com.baidu.adp.lib.f.e.gy().removeCallbacks(this.kMf);
        com.baidu.adp.lib.f.e.gy().removeCallbacks(this.kMi);
    }

    protected void cFg() {
        if (this.dtU != null) {
            this.dtU.cancelLoadData();
        }
        if (this.kMb.cSQ() != null) {
            this.kMb.cSQ().cFg();
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i == 4) {
            if (this.gFW != null && this.gFW.isShowing()) {
                g.b(this.gFW, getPageContext());
                return true;
            }
            cSM();
            return true;
        }
        return super.onKeyDown(i, keyEvent);
    }

    private void cSM() {
        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(getPageContext().getPageActivity());
        aVar.jF(R.string.give_up_video_confirm);
        aVar.a(R.string.dialog_ok, new a.b() { // from class: com.baidu.tieba.write.video.WriteVideoActivity.5
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                aVar2.dismiss();
                WriteVideoActivity.this.cFg();
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
        aVar.b(getPageContext()).aBW();
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.kMb.cSR()) {
            if (b.kMl - this.kMb.cSP() < 0) {
                showToast(getResources().getString(R.string.video_content_overflow));
            } else if (this.kMb.cSV() != null && this.kMb.cSV().cRJ()) {
                showToast(this.kMb.cSV().cRL());
                this.kMb.tz(true);
            } else {
                cSK();
                aMx();
            }
        } else if (view == this.kMb.getBackButton()) {
            cSM();
        }
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void closeLoadingDialog() {
        if (this.gFW != null) {
            if (this.gFW.isShowing()) {
                g.b(this.gFW, getPageContext());
            }
            this.gFW = null;
        }
    }

    /* loaded from: classes10.dex */
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
        if (this.kMc.onTouchEvent(motionEvent)) {
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
        this.kMb.tA(z);
    }

    public VideoTitleData KB(String str) {
        if (!StringUtils.isNull(str) && !v.isEmpty(this.krG)) {
            Matcher matcher = Pattern.compile("#(.+)#.*").matcher(str);
            if (matcher.find()) {
                String group = matcher.group(1);
                int i = 0;
                while (true) {
                    int i2 = i;
                    if (i2 >= this.krG.size()) {
                        break;
                    } else if (this.krG.get(i2) == null || !group.equals(this.krG.get(i2).name)) {
                        i = i2 + 1;
                    } else {
                        return this.krG.get(i2);
                    }
                }
            }
        }
        return null;
    }
}
