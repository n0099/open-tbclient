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
import com.baidu.adp.lib.d.a;
import com.baidu.adp.lib.g.g;
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
import com.baidu.tbadk.util.j;
import com.baidu.tbadk.util.z;
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
/* loaded from: classes3.dex */
public class WriteVideoActivity extends BaseActivity<WriteVideoActivity> {
    private NewWriteModel cGQ;
    private final NewWriteModel.d cHf;
    private c fSz;
    private DialogInterface.OnCancelListener fms;
    private String hRw;
    private e.a hyf;
    private e ixf;
    private b jSg;
    private GestureDetector jSh;
    private com.baidu.tieba.write.b.c jSi;
    private int jSj;
    private VideoTitleData jSl;
    private boolean jSm;
    private Runnable jSn;
    private Runnable jSo;
    private a.InterfaceC0519a jmk;
    private l jmq;
    private String jyA;
    private List<VideoTitleData> jyB;
    private int jyz;
    private String mFromForumId;
    private InputMethodManager mInputManager;
    public String mLat;
    public String mLng;
    private VideoTitleData mVideoTitleData;
    private final WriteData iYy = new WriteData();
    private Runnable jSk = new Runnable() { // from class: com.baidu.tieba.write.video.WriteVideoActivity.1
        @Override // java.lang.Runnable
        public void run() {
            Intent intent = new Intent(MotuVideoConfig.ACTION_FINISH_VIDEO_ALL_ACTIVITY);
            intent.setPackage(TbadkCoreApplication.getInst().getPackageName());
            WriteVideoActivity.this.getPageContext().getPageActivity().sendBroadcast(intent);
        }
    };
    private String fVb = "0";

    public WriteVideoActivity() {
        CustomResponsedMessage runTask = MessageManager.getInstance().runTask(CmdConfigCustom.CMD_GET_VIDEO_PLATFORM_FACTORY, l.class);
        if (runTask != null) {
            this.jmq = (l) runTask.getData();
        }
        this.hyf = new e.a() { // from class: com.baidu.tieba.write.video.WriteVideoActivity.8
            @Override // com.baidu.tieba.j.e.a
            public void vV(int i) {
                if (i != 1) {
                    WriteVideoActivity.this.jSm = true;
                    return;
                }
                an anVar = new an("c12620");
                anVar.O("obj_locate", 0);
                TiebaStatic.log(anVar);
            }

            @Override // com.baidu.tieba.j.e.a
            public void onChange(boolean z) {
            }

            @Override // com.baidu.tieba.j.e.a
            public void nl(boolean z) {
                WriteVideoActivity.this.jSm = true;
                an anVar = new an("c12621");
                anVar.O("obj_locate", 0);
                anVar.O("obj_param1", z ? 1 : 0);
                TiebaStatic.log(anVar);
            }
        };
        this.jSn = new Runnable() { // from class: com.baidu.tieba.write.video.WriteVideoActivity.11
            @Override // java.lang.Runnable
            public void run() {
                if (!f.arM() || WriteVideoActivity.this.ixf == null || WriteVideoActivity.this.jSm) {
                    if (WriteVideoActivity.this.cGQ != null) {
                        WriteVideoActivity.this.cGQ.cpE();
                        return;
                    }
                    return;
                }
                com.baidu.adp.lib.g.e.fZ().postDelayed(WriteVideoActivity.this.jSn, 100L);
            }
        };
        this.cHf = new NewWriteModel.d() { // from class: com.baidu.tieba.write.video.WriteVideoActivity.12
            @Override // com.baidu.tieba.tbadkCore.writeModel.NewWriteModel.d
            public void callback(boolean z, PostWriteCallBackData postWriteCallBackData, y yVar, WriteData writeData, AntiData antiData) {
                File file;
                WriteVideoActivity.this.closeLoadingDialog();
                if (postWriteCallBackData != null && WriteVideoActivity.this.iYy != null) {
                    boolean z2 = com.baidu.tbadk.core.sharedPref.b.alR().getBoolean(MotuVideoConfig.IS_SINGLE_GOD_USER, false);
                    if (WriteVideoActivity.this.iYy != null && WriteVideoActivity.this.iYy.getVideoInfo() != null && writeData != null) {
                        if (!z2 && WriteVideoActivity.this.iYy.getVideoInfo().getVideoDuration() > 8) {
                            writeData.setVideoReviewType(1);
                        } else {
                            writeData.setVideoReviewType(2);
                        }
                    }
                    WriteVideoActivity.this.jSg.cyW();
                    boolean z3 = com.baidu.tbadk.core.sharedPref.b.alR().getBoolean(SharedPrefConfig.WRITE_VIDEO_ACTIVITY_SAVE_VIDEO, true);
                    if (z) {
                        if (WriteVideoActivity.this.iYy != null && WriteVideoActivity.this.iYy.getVideoInfo() != null) {
                            File file2 = new File(com.baidu.tieba.video.c.jwV);
                            if (!file2.exists()) {
                                file2.mkdirs();
                            }
                            if (z3 && WriteVideoActivity.this.iYy.getVideoInfo().getVideoType() == 1) {
                                String str = com.baidu.tieba.video.c.jwV + file.getName();
                                m.copyFile(new File(WriteVideoActivity.this.iYy.getVideoInfo().getVideoPath()).getAbsolutePath(), str);
                                WriteVideoActivity.this.aV(BdBaseApplication.getInst(), str);
                            }
                            WriteVideoActivity.this.cyL();
                            m.deleteFileOrDir(new File(com.baidu.tieba.video.c.jwU));
                            postWriteCallBackData.mVideoMd5 = WriteVideoActivity.this.iYy.getVideoInfo().getVideoMd5();
                        }
                        WriteVideoActivity.this.i(postWriteCallBackData);
                    } else if (postWriteCallBackData != null && postWriteCallBackData.isSensitiveError()) {
                        WriteVideoActivity.this.showToast(postWriteCallBackData.getErrorString());
                        WriteVideoActivity.this.jSg.j(postWriteCallBackData);
                    } else if ((yVar == null || writeData == null || yVar.getVcode_pic_url() == null || AntiHelper.e(antiData)) && postWriteCallBackData != null && postWriteCallBackData.getErrorCode() != 227001) {
                        WriteVideoActivity.this.c(false, postWriteCallBackData);
                    } else if (yVar != null && writeData != null && yVar.getVcode_pic_url() != null) {
                        writeData.setVcodeMD5(yVar.getVcode_md5());
                        writeData.setVcodeUrl(yVar.getVcode_pic_url());
                        writeData.setVcodeExtra(yVar.apu());
                        if (com.baidu.tbadk.v.a.qv(yVar.apt())) {
                            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new NewVcodeActivityConfig(WriteVideoActivity.this.getPageContext().getPageActivity(), RequestResponseCode.REQUEST_VCODE, writeData, false, yVar.apt())));
                        } else {
                            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new VcodeActivityConfig(WriteVideoActivity.this.getPageContext().getPageActivity(), writeData, RequestResponseCode.REQUEST_VCODE)));
                        }
                    } else if (postWriteCallBackData != null && postWriteCallBackData.getErrorCode() == 227001) {
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AccountAccessActivityConfig(WriteVideoActivity.this.getActivity(), RequestResponseCode.REQUEST_VCODE, writeData, postWriteCallBackData.getAccessState())));
                    }
                }
            }
        };
        this.jSo = new Runnable() { // from class: com.baidu.tieba.write.video.WriteVideoActivity.13
            @Override // java.lang.Runnable
            public void run() {
                if (WriteVideoActivity.this.fSz != null) {
                    WriteVideoActivity.this.fSz.setPercent(WriteVideoActivity.this.jSj);
                }
            }
        };
        this.jmk = new a.InterfaceC0519a() { // from class: com.baidu.tieba.write.video.WriteVideoActivity.14
            @Override // com.baidu.tieba.tbadkCore.c.a.InterfaceC0519a
            public void zT(int i) {
                WriteVideoActivity.this.jSj = i;
                com.baidu.adp.lib.g.e.fZ().post(WriteVideoActivity.this.jSo);
            }
        };
        this.fms = new DialogInterface.OnCancelListener() { // from class: com.baidu.tieba.write.video.WriteVideoActivity.2
            @Override // android.content.DialogInterface.OnCancelListener
            public void onCancel(DialogInterface dialogInterface) {
                WriteVideoActivity.this.destroyWaitingDialog();
                WriteVideoActivity.this.cla();
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.jSg = new b(this);
        setSwipeBackEnabled(false);
        cyI();
        if (this.iYy.getVideoInfo() != null) {
            if (!StringUtils.isNull(this.jyA)) {
                VideoTitleData videoTitleData = new VideoTitleData();
                videoTitleData.name = this.jyA;
                this.jSg.a(this.iYy.getVideoInfo(), videoTitleData, (List<VideoTitleData>) null);
            } else {
                this.jSg.a(this.iYy.getVideoInfo(), this.mVideoTitleData, this.jyB);
            }
        }
        if (this.jSg.cyQ() != null) {
            this.jSg.cyQ().d(this);
        }
        adjustResizeForSoftInput();
        this.jSh = new GestureDetector(getPageContext().getPageActivity(), new a());
        this.mInputManager = (InputMethodManager) getSystemService("input_method");
        ShowSoftKeyPadDelay(this.jSg.cyS());
        this.jSg.cyS().requestFocus();
        TiebaStatic.log(new an("c12307"));
        addGlobalLayoutListener();
        if (ab.checkLocationForBaiduLocation(getPageContext().getPageActivity())) {
            com.baidu.adp.lib.d.a.fw().a(true, new a.InterfaceC0015a() { // from class: com.baidu.tieba.write.video.WriteVideoActivity.7
                @Override // com.baidu.adp.lib.d.a.InterfaceC0015a
                public void onLocationGeted(int i, String str, Address address) {
                    if (i == 0 && address != null) {
                        WriteVideoActivity.this.mLat = String.valueOf(address.getLatitude());
                        WriteVideoActivity.this.mLng = String.valueOf(address.getLongitude());
                    }
                }
            });
        }
        if (this.iYy.getVideoInfo() != null && !StringUtils.isNull(this.iYy.getVideoInfo().getVideoPath())) {
            FI(this.iYy.getVideoInfo().getVideoPath());
        }
    }

    private void FI(String str) {
        if (f.arM()) {
            if (this.jmq != null) {
                this.ixf = this.jmq.Ab(str);
            }
            if (this.ixf != null) {
                this.ixf.a(this.hyf);
                this.ixf.bMA();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        com.baidu.adp.lib.g.e.fZ().postDelayed(this.jSk, 500L);
        if (this.jSg != null) {
            this.jSg.cum();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onStop() {
        super.onStop();
        if (this.jSg != null) {
            this.jSg.bmj();
        }
    }

    private void cyI() {
        Intent intent = getIntent();
        if (intent != null) {
            Serializable serializableExtra = intent.getSerializableExtra(WriteVideoActivityConfig.VIDEO_INFO);
            if (serializableExtra instanceof VideoInfo) {
                this.iYy.setVideoInfo((VideoInfo) serializableExtra);
            }
            this.mFromForumId = intent.getStringExtra("forum_id");
            this.hRw = intent.getStringExtra("forum_name");
            this.jyz = intent.getIntExtra("pro_zone", -1);
            this.iYy.setForumId(this.mFromForumId);
            this.iYy.setForumName(this.hRw);
            this.iYy.setProZone(this.jyz);
            this.jyA = intent.getStringExtra("video_title");
            if (intent.getSerializableExtra(WriteVideoActivityConfig.FORUM_VIDEO_TITLE) instanceof VideoTitleData) {
                this.mVideoTitleData = (VideoTitleData) intent.getSerializableExtra(WriteVideoActivityConfig.FORUM_VIDEO_TITLE);
            }
            if (intent.getSerializableExtra(WriteVideoActivityConfig.ALL_VIDEO_TITLE) instanceof List) {
                this.jyB = (List) intent.getSerializableExtra(WriteVideoActivityConfig.ALL_VIDEO_TITLE);
            }
            if (!StringUtils.isNull(this.hRw)) {
                this.jSg.FL(this.hRw + getResources().getString(R.string.forum));
            } else {
                this.jSg.FL(this.hRw);
            }
            this.fVb = intent.getStringExtra("KEY_CALL_FROM");
            if (EditVideoActivityConfig.FROM_TYPE_RECORD_VIDEO_ACTIVITY.equals(intent.getStringExtra("from_type"))) {
                this.jSg.cyO();
            }
            cyJ();
        }
    }

    private void cyJ() {
        this.jSi = new com.baidu.tieba.write.b.c(getPageContext().getPageActivity(), this.jSg.getCenterTitleView(), this.iYy.getProZone(), isUseStyleImmersiveSticky() ? StatusBarUtil.getStatusBarOffsetPx(getPageContext().getPageActivity()) : 0);
        this.jSi.a(new c.a() { // from class: com.baidu.tieba.write.video.WriteVideoActivity.9
            @Override // com.baidu.tieba.write.b.c.a
            public void BC(int i) {
                WriteVideoActivity.this.iYy.setProZone(i);
            }
        });
        this.jSi.bet();
    }

    private void cyK() {
        if (StringUtils.isNull(this.mFromForumId) || Long.parseLong(this.mFromForumId) <= 0 || StringUtils.isNull(this.hRw)) {
            this.iYy.setCanNoForum(true);
        } else {
            this.iYy.setCanNoForum(false);
        }
        this.iYy.setForumName(this.hRw);
        this.iYy.setTitle(this.jSg.getContent());
        this.iYy.setContent("");
        this.iYy.setType(0);
        if (this.jSg.cyT() != null) {
            if (this.jSg.cyT().getState() == 0) {
                this.iYy.setPrivacy(false);
            } else {
                this.iYy.setPrivacy(true);
            }
        }
        if (this.jSg.cyQ() != null) {
            this.iYy.setHasLocationData(this.jSg.cyQ().aWR());
        }
        this.iYy.setIsNoTitle(TextUtils.isEmpty(this.iYy.getTitle()));
    }

    private void auR() {
        cla();
        showLoadingDialog();
        this.jSl = FJ(this.iYy != null ? this.iYy.getTitle() : "");
        if (this.cGQ == null) {
            this.cGQ = new NewWriteModel(this);
        }
        if (!TextUtils.isEmpty(this.fVb)) {
            this.iYy.setCallFrom(this.fVb);
        }
        this.iYy.setPostLatLng(true);
        this.cGQ.d(this.iYy);
        this.cGQ.b(this.cHf);
        this.cGQ.a(this.jmk);
        if (!TextUtils.isEmpty(this.mLat) && !TextUtils.isEmpty(this.mLng)) {
            this.iYy.setLat(this.mLat);
            this.iYy.setLng(this.mLng);
            if (f.arM() && this.ixf != null && !this.jSm) {
                com.baidu.adp.lib.g.e.fZ().postDelayed(this.jSn, 100L);
            } else {
                this.cGQ.cpE();
            }
        } else if (ab.checkLocationForBaiduLocation(getPageContext().getPageActivity())) {
            com.baidu.adp.lib.d.a.fw().a(true, new a.InterfaceC0015a() { // from class: com.baidu.tieba.write.video.WriteVideoActivity.10
                @Override // com.baidu.adp.lib.d.a.InterfaceC0015a
                public void onLocationGeted(int i, String str, Address address) {
                    if (i == 0 && address != null) {
                        WriteVideoActivity.this.mLat = String.valueOf(address.getLatitude());
                        WriteVideoActivity.this.mLng = String.valueOf(address.getLongitude());
                        WriteVideoActivity.this.iYy.setLat(WriteVideoActivity.this.mLat);
                        WriteVideoActivity.this.iYy.setLng(WriteVideoActivity.this.mLng);
                    }
                    if (!f.arM() || WriteVideoActivity.this.ixf == null || WriteVideoActivity.this.jSm) {
                        WriteVideoActivity.this.cGQ.cpE();
                    } else {
                        com.baidu.adp.lib.g.e.fZ().postDelayed(WriteVideoActivity.this.jSn, 100L);
                    }
                }
            });
        } else if (f.arM() && this.ixf != null && !this.jSm) {
            com.baidu.adp.lib.g.e.fZ().postDelayed(this.jSn, 100L);
        } else {
            this.cGQ.cpE();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aV(Context context, String str) {
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
    public void cyL() {
        VideoInfo videoInfo;
        if (this.iYy != null && (videoInfo = this.iYy.getVideoInfo()) != null && videoInfo.getVideoType() == 2) {
            if ((videoInfo.isCompressedVideo() || videoInfo.getMusicListInfo() != null) && videoInfo.getVideoPath() != null && videoInfo.getVideoPath().contains(com.baidu.tieba.video.c.jwU)) {
                File file = new File(videoInfo.getVideoPath());
                if (file.exists() && file.isFile()) {
                    if (com.baidu.tbadk.core.sharedPref.b.alR().getBoolean(SharedPrefConfig.WRITE_VIDEO_ACTIVITY_SAVE_VIDEO, true)) {
                        m.copyFile(file.getAbsolutePath(), com.baidu.tieba.video.c.jwV + file.getName());
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
            if (AntiHelper.aH(postWriteCallBackData.getErrorCode(), postWriteCallBackData.getErrorString())) {
                AntiHelper.aS(getPageContext().getPageActivity(), postWriteCallBackData.getErrorString());
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
        this.fSz = new com.baidu.tbadk.core.dialog.c(getPageContext().getPageActivity());
        this.fSz.setOnCancelListener(this.fms);
        this.fSz.setCancelable(true);
        this.fSz.setCanceledOnTouchOutside(false);
        g.showDialog(this.fSz, getPageContext().getPageActivity());
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity
    public void finish() {
        cla();
        destroyWaitingDialog();
        this.fms = null;
        closeLoadingDialog();
        com.baidu.adp.lib.g.e.fZ().removeCallbacks(this.jSo);
        super.finish();
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void destroyWaitingDialog() {
        this.fSz = null;
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
                if (this.jSg.cyX() != null) {
                    this.jSg.cyX().aM(postWriteCallBackData.getSensitiveWords());
                    if (!v.isEmpty(this.jSg.cyX().cxy())) {
                        this.jSg.rS(true);
                    }
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void i(PostWriteCallBackData postWriteCallBackData) {
        z.a(new com.baidu.tbadk.util.y<Void>() { // from class: com.baidu.tieba.write.video.WriteVideoActivity.3
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tbadk.util.y
            /* renamed from: aEg */
            public Void doInBackground() {
                File file;
                if (WriteVideoActivity.this.iYy != null && WriteVideoActivity.this.iYy.getVideoInfo() != null && WriteVideoActivity.this.iYy.getVideoInfo().getVideoPath() != null && WriteVideoActivity.this.iYy.getVideoInfo().getVideoPath().contains(com.baidu.tieba.video.c.jwU) && (file = new File(WriteVideoActivity.this.iYy.getVideoInfo().getVideoPath())) != null) {
                    m.copyFile(file.getAbsolutePath(), com.baidu.tieba.video.c.jwV + file.getName());
                }
                m.deleteFileOrDir(new File(com.baidu.tieba.video.c.jwU));
                return null;
            }
        }, new j<Void>() { // from class: com.baidu.tieba.write.video.WriteVideoActivity.4
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tbadk.util.j
            /* renamed from: a */
            public void onReturnDataInUI(Void r1) {
            }
        });
        if (!StringUtils.isNull(this.jyA)) {
            postWriteCallBackData.mFrom = 3;
        } else if (!StringUtils.isNull(this.hRw)) {
            postWriteCallBackData.mFrom = 2;
        } else {
            postWriteCallBackData.mFrom = 1;
        }
        postWriteCallBackData.mVideoTitleData = this.jSl;
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
        this.jSg.onChangeSkinType(i);
        if (this.jSi != null) {
            this.jSi.onChangeSkinType(i);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        if (this.jSg != null) {
            this.jSg.bmj();
        }
        com.baidu.adp.lib.g.e.fZ().removeCallbacks(this.jSk);
        com.baidu.adp.lib.g.e.fZ().removeCallbacks(this.jSn);
    }

    protected void cla() {
        if (this.cGQ != null) {
            this.cGQ.cancelLoadData();
        }
        if (this.jSg.cyQ() != null) {
            this.jSg.cyQ().cla();
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i == 4) {
            if (this.fSz != null && this.fSz.isShowing()) {
                g.b(this.fSz, getPageContext());
                return true;
            }
            cyM();
            return true;
        }
        return super.onKeyDown(i, keyEvent);
    }

    private void cyM() {
        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(getPageContext().getPageActivity());
        aVar.hU(R.string.give_up_video_confirm);
        aVar.a(R.string.dialog_ok, new a.b() { // from class: com.baidu.tieba.write.video.WriteVideoActivity.5
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                aVar2.dismiss();
                WriteVideoActivity.this.cla();
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
        aVar.b(getPageContext()).akO();
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.jSg.cyR()) {
            if (b.jSq - this.jSg.cyP() < 0) {
                showToast(getResources().getString(R.string.video_content_overflow));
            } else if (this.jSg.cyX() != null && this.jSg.cyX().cxA()) {
                showToast(this.jSg.cyX().cxC());
                this.jSg.rS(true);
            } else {
                cyK();
                auR();
            }
        } else if (view == this.jSg.getBackButton()) {
            cyM();
        }
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void closeLoadingDialog() {
        if (this.fSz != null) {
            if (this.fSz.isShowing()) {
                g.b(this.fSz, getPageContext());
            }
            this.fSz = null;
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
        if (this.jSh.onTouchEvent(motionEvent)) {
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
        this.jSg.rT(z);
    }

    public VideoTitleData FJ(String str) {
        if (!StringUtils.isNull(str) && !v.isEmpty(this.jyB)) {
            Matcher matcher = Pattern.compile("#(.+)#.*").matcher(str);
            if (matcher.find()) {
                String group = matcher.group(1);
                int i = 0;
                while (true) {
                    int i2 = i;
                    if (i2 >= this.jyB.size()) {
                        break;
                    } else if (this.jyB.get(i2) == null || !group.equals(this.jyB.get(i2).name)) {
                        i = i2 + 1;
                    } else {
                        return this.jyB.get(i2);
                    }
                }
            }
        }
        return null;
    }
}
