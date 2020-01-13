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
import com.baidu.tbadk.coreExtra.data.z;
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
/* loaded from: classes11.dex */
public class WriteVideoActivity extends BaseActivity<WriteVideoActivity> {
    private NewWriteModel duf;
    private final NewWriteModel.d dut;
    private c gJl;
    private DialogInterface.OnCancelListener gdj;
    private String iIS;
    private e.a ioV;
    private e jtP;
    private b kPC;
    private GestureDetector kPD;
    private com.baidu.tieba.write.b.c kPE;
    private int kPF;
    private VideoTitleData kPH;
    private boolean kPI;
    private Runnable kPJ;
    private Runnable kPK;
    private a.InterfaceC0603a kjl;
    private l kjp;
    private int kvh;
    private String kvi;
    private List<VideoTitleData> kvj;
    private String mFromForumId;
    private InputMethodManager mInputManager;
    public String mLat;
    public String mLng;
    private VideoTitleData mVideoTitleData;
    private final WriteData jVD = new WriteData();
    private Runnable kPG = new Runnable() { // from class: com.baidu.tieba.write.video.WriteVideoActivity.1
        @Override // java.lang.Runnable
        public void run() {
            Intent intent = new Intent(MotuVideoConfig.ACTION_FINISH_VIDEO_ALL_ACTIVITY);
            intent.setPackage(TbadkCoreApplication.getInst().getPackageName());
            WriteVideoActivity.this.getPageContext().getPageActivity().sendBroadcast(intent);
        }
    };
    private String gLX = "0";

    public WriteVideoActivity() {
        CustomResponsedMessage runTask = MessageManager.getInstance().runTask(CmdConfigCustom.CMD_GET_VIDEO_PLATFORM_FACTORY, l.class);
        if (runTask != null) {
            this.kjp = (l) runTask.getData();
        }
        this.ioV = new e.a() { // from class: com.baidu.tieba.write.video.WriteVideoActivity.8
            @Override // com.baidu.tieba.j.e.a
            public void ya(int i) {
                if (i != 1) {
                    WriteVideoActivity.this.kPI = true;
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
            public void oM(boolean z) {
                WriteVideoActivity.this.kPI = true;
                an anVar = new an("c12621");
                anVar.Z("obj_locate", 0);
                anVar.Z("obj_param1", z ? 1 : 0);
                TiebaStatic.log(anVar);
            }
        };
        this.kPJ = new Runnable() { // from class: com.baidu.tieba.write.video.WriteVideoActivity.11
            @Override // java.lang.Runnable
            public void run() {
                if (!f.aJD() || WriteVideoActivity.this.jtP == null || WriteVideoActivity.this.kPI) {
                    if (WriteVideoActivity.this.duf != null) {
                        WriteVideoActivity.this.duf.cKK();
                        return;
                    }
                    return;
                }
                com.baidu.adp.lib.f.e.gx().postDelayed(WriteVideoActivity.this.kPJ, 100L);
            }
        };
        this.dut = new NewWriteModel.d() { // from class: com.baidu.tieba.write.video.WriteVideoActivity.12
            @Override // com.baidu.tieba.tbadkCore.writeModel.NewWriteModel.d
            public void callback(boolean z, PostWriteCallBackData postWriteCallBackData, z zVar, WriteData writeData, AntiData antiData) {
                File file;
                WriteVideoActivity.this.closeLoadingDialog();
                if (postWriteCallBackData != null && WriteVideoActivity.this.jVD != null) {
                    boolean z2 = com.baidu.tbadk.core.sharedPref.b.aDr().getBoolean(MotuVideoConfig.IS_SINGLE_GOD_USER, false);
                    if (WriteVideoActivity.this.jVD != null && WriteVideoActivity.this.jVD.getVideoInfo() != null && writeData != null) {
                        if (!z2 && WriteVideoActivity.this.jVD.getVideoInfo().getVideoDuration() > 8) {
                            writeData.setVideoReviewType(1);
                        } else {
                            writeData.setVideoReviewType(2);
                        }
                    }
                    WriteVideoActivity.this.kPC.cTX();
                    boolean z3 = com.baidu.tbadk.core.sharedPref.b.aDr().getBoolean(SharedPrefConfig.WRITE_VIDEO_ACTIVITY_SAVE_VIDEO, true);
                    if (z) {
                        if (WriteVideoActivity.this.jVD != null && WriteVideoActivity.this.jVD.getVideoInfo() != null) {
                            File file2 = new File(com.baidu.tieba.video.c.ktK);
                            if (!file2.exists()) {
                                file2.mkdirs();
                            }
                            if (z3 && WriteVideoActivity.this.jVD.getVideoInfo().getVideoType() == 1) {
                                String str = com.baidu.tieba.video.c.ktK + file.getName();
                                m.copyFile(new File(WriteVideoActivity.this.jVD.getVideoInfo().getVideoPath()).getAbsolutePath(), str);
                                WriteVideoActivity.this.bq(BdBaseApplication.getInst(), str);
                            }
                            WriteVideoActivity.this.cTO();
                            m.deleteFileOrDir(new File(com.baidu.tieba.video.c.ktJ));
                            postWriteCallBackData.mVideoMd5 = WriteVideoActivity.this.jVD.getVideoInfo().getVideoMd5();
                        }
                        WriteVideoActivity.this.i(postWriteCallBackData);
                    } else if (postWriteCallBackData != null && postWriteCallBackData.isSensitiveError()) {
                        WriteVideoActivity.this.showToast(postWriteCallBackData.getErrorString());
                        WriteVideoActivity.this.kPC.j(postWriteCallBackData);
                    } else if ((zVar == null || writeData == null || zVar.getVcode_pic_url() == null || AntiHelper.e(antiData)) && postWriteCallBackData != null && postWriteCallBackData.getErrorCode() != 227001) {
                        WriteVideoActivity.this.c(false, postWriteCallBackData);
                    } else if (zVar != null && writeData != null && zVar.getVcode_pic_url() != null) {
                        writeData.setVcodeMD5(zVar.getVcode_md5());
                        writeData.setVcodeUrl(zVar.getVcode_pic_url());
                        writeData.setVcodeExtra(zVar.aHl());
                        if (com.baidu.tbadk.s.a.vG(zVar.aHk())) {
                            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new NewVcodeActivityConfig(WriteVideoActivity.this.getPageContext().getPageActivity(), RequestResponseCode.REQUEST_VCODE, writeData, false, zVar.aHk())));
                        } else {
                            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new VcodeActivityConfig(WriteVideoActivity.this.getPageContext().getPageActivity(), writeData, RequestResponseCode.REQUEST_VCODE)));
                        }
                    } else if (postWriteCallBackData != null && postWriteCallBackData.getErrorCode() == 227001) {
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AccountAccessActivityConfig(WriteVideoActivity.this.getActivity(), RequestResponseCode.REQUEST_VCODE, writeData, postWriteCallBackData.getAccessState())));
                    }
                }
            }
        };
        this.kPK = new Runnable() { // from class: com.baidu.tieba.write.video.WriteVideoActivity.13
            @Override // java.lang.Runnable
            public void run() {
                if (WriteVideoActivity.this.gJl != null) {
                    WriteVideoActivity.this.gJl.setPercent(WriteVideoActivity.this.kPF);
                }
            }
        };
        this.kjl = new a.InterfaceC0603a() { // from class: com.baidu.tieba.write.video.WriteVideoActivity.14
            @Override // com.baidu.tieba.tbadkCore.c.a.InterfaceC0603a
            public void Cs(int i) {
                WriteVideoActivity.this.kPF = i;
                com.baidu.adp.lib.f.e.gx().post(WriteVideoActivity.this.kPK);
            }
        };
        this.gdj = new DialogInterface.OnCancelListener() { // from class: com.baidu.tieba.write.video.WriteVideoActivity.2
            @Override // android.content.DialogInterface.OnCancelListener
            public void onCancel(DialogInterface dialogInterface) {
                WriteVideoActivity.this.destroyWaitingDialog();
                WriteVideoActivity.this.cGk();
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.kPC = new b(this);
        setSwipeBackEnabled(false);
        cTL();
        if (this.jVD.getVideoInfo() != null) {
            if (!StringUtils.isNull(this.kvi)) {
                VideoTitleData videoTitleData = new VideoTitleData();
                videoTitleData.name = this.kvi;
                this.kPC.a(this.jVD.getVideoInfo(), videoTitleData, (List<VideoTitleData>) null);
            } else {
                this.kPC.a(this.jVD.getVideoInfo(), this.mVideoTitleData, this.kvj);
            }
        }
        if (this.kPC.cTT() != null) {
            this.kPC.cTT().d(this);
        }
        adjustResizeForSoftInput();
        this.kPD = new GestureDetector(getPageContext().getPageActivity(), new a());
        this.mInputManager = (InputMethodManager) getSystemService("input_method");
        ShowSoftKeyPadDelay(this.kPC.cTV());
        this.kPC.cTV().requestFocus();
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
        if (this.jVD.getVideoInfo() != null && !StringUtils.isNull(this.jVD.getVideoInfo().getVideoPath())) {
            KK(this.jVD.getVideoInfo().getVideoPath());
        }
    }

    private void KK(String str) {
        if (f.aJD()) {
            if (this.kjp != null) {
                this.jtP = this.kjp.ET(str);
            }
            if (this.jtP != null) {
                this.jtP.a(this.ioV);
                this.jtP.ceT();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        com.baidu.adp.lib.f.e.gx().postDelayed(this.kPG, 500L);
        if (this.kPC != null) {
            this.kPC.cPm();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onStop() {
        super.onStop();
        if (this.kPC != null) {
            this.kPC.bEG();
        }
    }

    private void cTL() {
        Intent intent = getIntent();
        if (intent != null) {
            Serializable serializableExtra = intent.getSerializableExtra(WriteVideoActivityConfig.VIDEO_INFO);
            if (serializableExtra instanceof VideoInfo) {
                this.jVD.setVideoInfo((VideoInfo) serializableExtra);
            }
            this.mFromForumId = intent.getStringExtra("forum_id");
            this.iIS = intent.getStringExtra("forum_name");
            this.kvh = intent.getIntExtra("pro_zone", -1);
            this.jVD.setForumId(this.mFromForumId);
            this.jVD.setForumName(this.iIS);
            this.jVD.setProZone(this.kvh);
            this.kvi = intent.getStringExtra("video_title");
            if (intent.getSerializableExtra(WriteVideoActivityConfig.FORUM_VIDEO_TITLE) instanceof VideoTitleData) {
                this.mVideoTitleData = (VideoTitleData) intent.getSerializableExtra(WriteVideoActivityConfig.FORUM_VIDEO_TITLE);
            }
            if (intent.getSerializableExtra(WriteVideoActivityConfig.ALL_VIDEO_TITLE) instanceof List) {
                this.kvj = (List) intent.getSerializableExtra(WriteVideoActivityConfig.ALL_VIDEO_TITLE);
            }
            if (!StringUtils.isNull(this.iIS)) {
                this.kPC.KN(this.iIS + getResources().getString(R.string.forum));
            } else {
                this.kPC.KN(this.iIS);
            }
            this.gLX = intent.getStringExtra("KEY_CALL_FROM");
            if (EditVideoActivityConfig.FROM_TYPE_RECORD_VIDEO_ACTIVITY.equals(intent.getStringExtra("from_type"))) {
                this.kPC.cTR();
            }
            cTM();
        }
    }

    private void cTM() {
        this.kPE = new com.baidu.tieba.write.b.c(getPageContext().getPageActivity(), this.kPC.getCenterTitleView(), this.jVD.getProZone(), isUseStyleImmersiveSticky() ? StatusBarUtil.getStatusBarOffsetPx(getPageContext().getPageActivity()) : 0);
        this.kPE.a(new c.a() { // from class: com.baidu.tieba.write.video.WriteVideoActivity.9
            @Override // com.baidu.tieba.write.b.c.a
            public void Ed(int i) {
                WriteVideoActivity.this.jVD.setProZone(i);
            }
        });
        this.kPE.bwO();
    }

    private void cTN() {
        if (StringUtils.isNull(this.mFromForumId) || Long.parseLong(this.mFromForumId) <= 0 || StringUtils.isNull(this.iIS)) {
            this.jVD.setCanNoForum(true);
        } else {
            this.jVD.setCanNoForum(false);
        }
        this.jVD.setForumName(this.iIS);
        this.jVD.setTitle(this.kPC.getContent());
        this.jVD.setContent("");
        this.jVD.setType(0);
        if (this.kPC.cTW() != null) {
            if (this.kPC.cTW().getState() == 0) {
                this.jVD.setPrivacy(false);
            } else {
                this.jVD.setPrivacy(true);
            }
        }
        this.jVD.setToDynamic(this.kPC.isToDynamic());
        if (this.kPC.cTT() != null) {
            this.jVD.setHasLocationData(this.kPC.cTT().bpD());
        }
        this.jVD.setIsNoTitle(TextUtils.isEmpty(this.jVD.getTitle()));
    }

    private void aMQ() {
        cGk();
        showLoadingDialog();
        this.kPH = KL(this.jVD != null ? this.jVD.getTitle() : "");
        if (this.duf == null) {
            this.duf = new NewWriteModel(this);
        }
        if (!TextUtils.isEmpty(this.gLX)) {
            this.jVD.setCallFrom(this.gLX);
        }
        this.jVD.setPostLatLng(true);
        this.duf.d(this.jVD);
        this.duf.b(this.dut);
        this.duf.a(this.kjl);
        if (!TextUtils.isEmpty(this.mLat) && !TextUtils.isEmpty(this.mLng)) {
            this.jVD.setLat(this.mLat);
            this.jVD.setLng(this.mLng);
            if (f.aJD() && this.jtP != null && !this.kPI) {
                com.baidu.adp.lib.f.e.gx().postDelayed(this.kPJ, 100L);
            } else {
                this.duf.cKK();
            }
        } else if (ab.checkLocationForBaiduLocation(getPageContext().getPageActivity())) {
            com.baidu.adp.lib.c.a.fK().a(true, new a.InterfaceC0016a() { // from class: com.baidu.tieba.write.video.WriteVideoActivity.10
                @Override // com.baidu.adp.lib.c.a.InterfaceC0016a
                public void onLocationGeted(int i, String str, Address address) {
                    if (i == 0 && address != null) {
                        WriteVideoActivity.this.mLat = String.valueOf(address.getLatitude());
                        WriteVideoActivity.this.mLng = String.valueOf(address.getLongitude());
                        WriteVideoActivity.this.jVD.setLat(WriteVideoActivity.this.mLat);
                        WriteVideoActivity.this.jVD.setLng(WriteVideoActivity.this.mLng);
                    }
                    if (!f.aJD() || WriteVideoActivity.this.jtP == null || WriteVideoActivity.this.kPI) {
                        WriteVideoActivity.this.duf.cKK();
                    } else {
                        com.baidu.adp.lib.f.e.gx().postDelayed(WriteVideoActivity.this.kPJ, 100L);
                    }
                }
            });
        } else if (f.aJD() && this.jtP != null && !this.kPI) {
            com.baidu.adp.lib.f.e.gx().postDelayed(this.kPJ, 100L);
        } else {
            this.duf.cKK();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bq(Context context, String str) {
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
    public void cTO() {
        VideoInfo videoInfo;
        if (this.jVD != null && (videoInfo = this.jVD.getVideoInfo()) != null && videoInfo.getVideoType() == 2) {
            if ((videoInfo.isCompressedVideo() || videoInfo.getMusicListInfo() != null) && videoInfo.getVideoPath() != null && videoInfo.getVideoPath().contains(com.baidu.tieba.video.c.ktJ)) {
                File file = new File(videoInfo.getVideoPath());
                if (file.exists() && file.isFile()) {
                    if (com.baidu.tbadk.core.sharedPref.b.aDr().getBoolean(SharedPrefConfig.WRITE_VIDEO_ACTIVITY_SAVE_VIDEO, true)) {
                        m.copyFile(file.getAbsolutePath(), com.baidu.tieba.video.c.ktK + file.getName());
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
            if (AntiHelper.bc(postWriteCallBackData.getErrorCode(), postWriteCallBackData.getErrorString())) {
                AntiHelper.bn(getPageContext().getPageActivity(), postWriteCallBackData.getErrorString());
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
        this.gJl = new com.baidu.tbadk.core.dialog.c(getPageContext().getPageActivity());
        this.gJl.setOnCancelListener(this.gdj);
        this.gJl.setCancelable(true);
        this.gJl.setCanceledOnTouchOutside(false);
        g.showDialog(this.gJl, getPageContext().getPageActivity());
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity
    public void finish() {
        cGk();
        destroyWaitingDialog();
        this.gdj = null;
        closeLoadingDialog();
        com.baidu.adp.lib.f.e.gx().removeCallbacks(this.kPK);
        super.finish();
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void destroyWaitingDialog() {
        this.gJl = null;
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
                if (this.kPC.cTY() != null) {
                    this.kPC.cTY().aV(postWriteCallBackData.getSensitiveWords());
                    if (!v.isEmpty(this.kPC.cTY().cSK())) {
                        this.kPC.tL(true);
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
            /* renamed from: aWq */
            public Void doInBackground() {
                File file;
                if (WriteVideoActivity.this.jVD != null && WriteVideoActivity.this.jVD.getVideoInfo() != null && WriteVideoActivity.this.jVD.getVideoInfo().getVideoPath() != null && WriteVideoActivity.this.jVD.getVideoInfo().getVideoPath().contains(com.baidu.tieba.video.c.ktJ) && (file = new File(WriteVideoActivity.this.jVD.getVideoInfo().getVideoPath())) != null) {
                    m.copyFile(file.getAbsolutePath(), com.baidu.tieba.video.c.ktK + file.getName());
                }
                m.deleteFileOrDir(new File(com.baidu.tieba.video.c.ktJ));
                return null;
            }
        }, new com.baidu.tbadk.util.l<Void>() { // from class: com.baidu.tieba.write.video.WriteVideoActivity.4
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tbadk.util.l
            /* renamed from: a */
            public void onReturnDataInUI(Void r1) {
            }
        });
        if (!StringUtils.isNull(this.kvi)) {
            postWriteCallBackData.mFrom = 3;
        } else if (!StringUtils.isNull(this.iIS)) {
            postWriteCallBackData.mFrom = 2;
        } else {
            postWriteCallBackData.mFrom = 1;
        }
        postWriteCallBackData.mVideoTitleData = this.kPH;
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
        this.kPC.onChangeSkinType(i);
        if (this.kPE != null) {
            this.kPE.onChangeSkinType(i);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        if (this.kPC != null) {
            this.kPC.bEG();
        }
        com.baidu.adp.lib.f.e.gx().removeCallbacks(this.kPG);
        com.baidu.adp.lib.f.e.gx().removeCallbacks(this.kPJ);
    }

    protected void cGk() {
        if (this.duf != null) {
            this.duf.cancelLoadData();
        }
        if (this.kPC.cTT() != null) {
            this.kPC.cTT().cGk();
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i == 4) {
            if (this.gJl != null && this.gJl.isShowing()) {
                g.b(this.gJl, getPageContext());
                return true;
            }
            cTP();
            return true;
        }
        return super.onKeyDown(i, keyEvent);
    }

    private void cTP() {
        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(getPageContext().getPageActivity());
        aVar.jF(R.string.give_up_video_confirm);
        aVar.a(R.string.dialog_ok, new a.b() { // from class: com.baidu.tieba.write.video.WriteVideoActivity.5
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                aVar2.dismiss();
                WriteVideoActivity.this.cGk();
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
        aVar.b(getPageContext()).aCp();
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.kPC.cTU()) {
            if (b.kPM - this.kPC.cTS() < 0) {
                showToast(getResources().getString(R.string.video_content_overflow));
            } else if (this.kPC.cTY() != null && this.kPC.cTY().cSM()) {
                showToast(this.kPC.cTY().cSO());
                this.kPC.tL(true);
            } else {
                cTN();
                aMQ();
            }
        } else if (view == this.kPC.getBackButton()) {
            cTP();
        }
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void closeLoadingDialog() {
        if (this.gJl != null) {
            if (this.gJl.isShowing()) {
                g.b(this.gJl, getPageContext());
            }
            this.gJl = null;
        }
    }

    /* loaded from: classes11.dex */
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
        if (this.kPD.onTouchEvent(motionEvent)) {
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
        this.kPC.tM(z);
    }

    public VideoTitleData KL(String str) {
        if (!StringUtils.isNull(str) && !v.isEmpty(this.kvj)) {
            Matcher matcher = Pattern.compile("#(.+)#.*").matcher(str);
            if (matcher.find()) {
                String group = matcher.group(1);
                int i = 0;
                while (true) {
                    int i2 = i;
                    if (i2 >= this.kvj.size()) {
                        break;
                    } else if (this.kvj.get(i2) == null || !group.equals(this.kvj.get(i2).name)) {
                        i = i2 + 1;
                    } else {
                        return this.kvj.get(i2);
                    }
                }
            }
        }
        return null;
    }
}
