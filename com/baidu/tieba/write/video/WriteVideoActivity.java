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
    private NewWriteModel cFZ;
    private final NewWriteModel.d cGo;
    private c fRI;
    private DialogInterface.OnCancelListener flB;
    private String hQF;
    private e.a hxo;
    private e iwo;
    private b jRp;
    private GestureDetector jRq;
    private com.baidu.tieba.write.b.c jRr;
    private int jRs;
    private VideoTitleData jRu;
    private boolean jRv;
    private Runnable jRw;
    private Runnable jRx;
    private a.InterfaceC0519a jlt;
    private l jly;
    private int jxI;
    private String jxJ;
    private List<VideoTitleData> jxK;
    private String mFromForumId;
    private InputMethodManager mInputManager;
    public String mLat;
    public String mLng;
    private VideoTitleData mVideoTitleData;
    private final WriteData iXH = new WriteData();
    private Runnable jRt = new Runnable() { // from class: com.baidu.tieba.write.video.WriteVideoActivity.1
        @Override // java.lang.Runnable
        public void run() {
            Intent intent = new Intent(MotuVideoConfig.ACTION_FINISH_VIDEO_ALL_ACTIVITY);
            intent.setPackage(TbadkCoreApplication.getInst().getPackageName());
            WriteVideoActivity.this.getPageContext().getPageActivity().sendBroadcast(intent);
        }
    };
    private String fUk = "0";

    public WriteVideoActivity() {
        CustomResponsedMessage runTask = MessageManager.getInstance().runTask(CmdConfigCustom.CMD_GET_VIDEO_PLATFORM_FACTORY, l.class);
        if (runTask != null) {
            this.jly = (l) runTask.getData();
        }
        this.hxo = new e.a() { // from class: com.baidu.tieba.write.video.WriteVideoActivity.8
            @Override // com.baidu.tieba.j.e.a
            public void vU(int i) {
                if (i != 1) {
                    WriteVideoActivity.this.jRv = true;
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
                WriteVideoActivity.this.jRv = true;
                an anVar = new an("c12621");
                anVar.O("obj_locate", 0);
                anVar.O("obj_param1", z ? 1 : 0);
                TiebaStatic.log(anVar);
            }
        };
        this.jRw = new Runnable() { // from class: com.baidu.tieba.write.video.WriteVideoActivity.11
            @Override // java.lang.Runnable
            public void run() {
                if (!f.arK() || WriteVideoActivity.this.iwo == null || WriteVideoActivity.this.jRv) {
                    if (WriteVideoActivity.this.cFZ != null) {
                        WriteVideoActivity.this.cFZ.cpC();
                        return;
                    }
                    return;
                }
                com.baidu.adp.lib.g.e.fZ().postDelayed(WriteVideoActivity.this.jRw, 100L);
            }
        };
        this.cGo = new NewWriteModel.d() { // from class: com.baidu.tieba.write.video.WriteVideoActivity.12
            @Override // com.baidu.tieba.tbadkCore.writeModel.NewWriteModel.d
            public void callback(boolean z, PostWriteCallBackData postWriteCallBackData, y yVar, WriteData writeData, AntiData antiData) {
                File file;
                WriteVideoActivity.this.closeLoadingDialog();
                if (postWriteCallBackData != null && WriteVideoActivity.this.iXH != null) {
                    boolean z2 = com.baidu.tbadk.core.sharedPref.b.alP().getBoolean(MotuVideoConfig.IS_SINGLE_GOD_USER, false);
                    if (WriteVideoActivity.this.iXH != null && WriteVideoActivity.this.iXH.getVideoInfo() != null && writeData != null) {
                        if (!z2 && WriteVideoActivity.this.iXH.getVideoInfo().getVideoDuration() > 8) {
                            writeData.setVideoReviewType(1);
                        } else {
                            writeData.setVideoReviewType(2);
                        }
                    }
                    WriteVideoActivity.this.jRp.cyU();
                    boolean z3 = com.baidu.tbadk.core.sharedPref.b.alP().getBoolean(SharedPrefConfig.WRITE_VIDEO_ACTIVITY_SAVE_VIDEO, true);
                    if (z) {
                        if (WriteVideoActivity.this.iXH != null && WriteVideoActivity.this.iXH.getVideoInfo() != null) {
                            File file2 = new File(com.baidu.tieba.video.c.jwe);
                            if (!file2.exists()) {
                                file2.mkdirs();
                            }
                            if (z3 && WriteVideoActivity.this.iXH.getVideoInfo().getVideoType() == 1) {
                                String str = com.baidu.tieba.video.c.jwe + file.getName();
                                m.copyFile(new File(WriteVideoActivity.this.iXH.getVideoInfo().getVideoPath()).getAbsolutePath(), str);
                                WriteVideoActivity.this.aV(BdBaseApplication.getInst(), str);
                            }
                            WriteVideoActivity.this.cyJ();
                            m.deleteFileOrDir(new File(com.baidu.tieba.video.c.jwd));
                            postWriteCallBackData.mVideoMd5 = WriteVideoActivity.this.iXH.getVideoInfo().getVideoMd5();
                        }
                        WriteVideoActivity.this.i(postWriteCallBackData);
                    } else if (postWriteCallBackData != null && postWriteCallBackData.isSensitiveError()) {
                        WriteVideoActivity.this.showToast(postWriteCallBackData.getErrorString());
                        WriteVideoActivity.this.jRp.j(postWriteCallBackData);
                    } else if ((yVar == null || writeData == null || yVar.getVcode_pic_url() == null || AntiHelper.e(antiData)) && postWriteCallBackData != null && postWriteCallBackData.getErrorCode() != 227001) {
                        WriteVideoActivity.this.c(false, postWriteCallBackData);
                    } else if (yVar != null && writeData != null && yVar.getVcode_pic_url() != null) {
                        writeData.setVcodeMD5(yVar.getVcode_md5());
                        writeData.setVcodeUrl(yVar.getVcode_pic_url());
                        writeData.setVcodeExtra(yVar.aps());
                        if (com.baidu.tbadk.v.a.qv(yVar.apr())) {
                            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new NewVcodeActivityConfig(WriteVideoActivity.this.getPageContext().getPageActivity(), RequestResponseCode.REQUEST_VCODE, writeData, false, yVar.apr())));
                        } else {
                            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new VcodeActivityConfig(WriteVideoActivity.this.getPageContext().getPageActivity(), writeData, RequestResponseCode.REQUEST_VCODE)));
                        }
                    } else if (postWriteCallBackData != null && postWriteCallBackData.getErrorCode() == 227001) {
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AccountAccessActivityConfig(WriteVideoActivity.this.getActivity(), RequestResponseCode.REQUEST_VCODE, writeData, postWriteCallBackData.getAccessState())));
                    }
                }
            }
        };
        this.jRx = new Runnable() { // from class: com.baidu.tieba.write.video.WriteVideoActivity.13
            @Override // java.lang.Runnable
            public void run() {
                if (WriteVideoActivity.this.fRI != null) {
                    WriteVideoActivity.this.fRI.setPercent(WriteVideoActivity.this.jRs);
                }
            }
        };
        this.jlt = new a.InterfaceC0519a() { // from class: com.baidu.tieba.write.video.WriteVideoActivity.14
            @Override // com.baidu.tieba.tbadkCore.c.a.InterfaceC0519a
            public void zS(int i) {
                WriteVideoActivity.this.jRs = i;
                com.baidu.adp.lib.g.e.fZ().post(WriteVideoActivity.this.jRx);
            }
        };
        this.flB = new DialogInterface.OnCancelListener() { // from class: com.baidu.tieba.write.video.WriteVideoActivity.2
            @Override // android.content.DialogInterface.OnCancelListener
            public void onCancel(DialogInterface dialogInterface) {
                WriteVideoActivity.this.destroyWaitingDialog();
                WriteVideoActivity.this.ckY();
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.jRp = new b(this);
        setSwipeBackEnabled(false);
        cyG();
        if (this.iXH.getVideoInfo() != null) {
            if (!StringUtils.isNull(this.jxJ)) {
                VideoTitleData videoTitleData = new VideoTitleData();
                videoTitleData.name = this.jxJ;
                this.jRp.a(this.iXH.getVideoInfo(), videoTitleData, (List<VideoTitleData>) null);
            } else {
                this.jRp.a(this.iXH.getVideoInfo(), this.mVideoTitleData, this.jxK);
            }
        }
        if (this.jRp.cyO() != null) {
            this.jRp.cyO().d(this);
        }
        adjustResizeForSoftInput();
        this.jRq = new GestureDetector(getPageContext().getPageActivity(), new a());
        this.mInputManager = (InputMethodManager) getSystemService("input_method");
        ShowSoftKeyPadDelay(this.jRp.cyQ());
        this.jRp.cyQ().requestFocus();
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
        if (this.iXH.getVideoInfo() != null && !StringUtils.isNull(this.iXH.getVideoInfo().getVideoPath())) {
            FI(this.iXH.getVideoInfo().getVideoPath());
        }
    }

    private void FI(String str) {
        if (f.arK()) {
            if (this.jly != null) {
                this.iwo = this.jly.Ab(str);
            }
            if (this.iwo != null) {
                this.iwo.a(this.hxo);
                this.iwo.bMy();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        com.baidu.adp.lib.g.e.fZ().postDelayed(this.jRt, 500L);
        if (this.jRp != null) {
            this.jRp.cuk();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onStop() {
        super.onStop();
        if (this.jRp != null) {
            this.jRp.bmh();
        }
    }

    private void cyG() {
        Intent intent = getIntent();
        if (intent != null) {
            Serializable serializableExtra = intent.getSerializableExtra(WriteVideoActivityConfig.VIDEO_INFO);
            if (serializableExtra instanceof VideoInfo) {
                this.iXH.setVideoInfo((VideoInfo) serializableExtra);
            }
            this.mFromForumId = intent.getStringExtra("forum_id");
            this.hQF = intent.getStringExtra("forum_name");
            this.jxI = intent.getIntExtra("pro_zone", -1);
            this.iXH.setForumId(this.mFromForumId);
            this.iXH.setForumName(this.hQF);
            this.iXH.setProZone(this.jxI);
            this.jxJ = intent.getStringExtra("video_title");
            if (intent.getSerializableExtra(WriteVideoActivityConfig.FORUM_VIDEO_TITLE) instanceof VideoTitleData) {
                this.mVideoTitleData = (VideoTitleData) intent.getSerializableExtra(WriteVideoActivityConfig.FORUM_VIDEO_TITLE);
            }
            if (intent.getSerializableExtra(WriteVideoActivityConfig.ALL_VIDEO_TITLE) instanceof List) {
                this.jxK = (List) intent.getSerializableExtra(WriteVideoActivityConfig.ALL_VIDEO_TITLE);
            }
            if (!StringUtils.isNull(this.hQF)) {
                this.jRp.FL(this.hQF + getResources().getString(R.string.forum));
            } else {
                this.jRp.FL(this.hQF);
            }
            this.fUk = intent.getStringExtra("KEY_CALL_FROM");
            if (EditVideoActivityConfig.FROM_TYPE_RECORD_VIDEO_ACTIVITY.equals(intent.getStringExtra("from_type"))) {
                this.jRp.cyM();
            }
            cyH();
        }
    }

    private void cyH() {
        this.jRr = new com.baidu.tieba.write.b.c(getPageContext().getPageActivity(), this.jRp.getCenterTitleView(), this.iXH.getProZone(), isUseStyleImmersiveSticky() ? StatusBarUtil.getStatusBarOffsetPx(getPageContext().getPageActivity()) : 0);
        this.jRr.a(new c.a() { // from class: com.baidu.tieba.write.video.WriteVideoActivity.9
            @Override // com.baidu.tieba.write.b.c.a
            public void BB(int i) {
                WriteVideoActivity.this.iXH.setProZone(i);
            }
        });
        this.jRr.ber();
    }

    private void cyI() {
        if (StringUtils.isNull(this.mFromForumId) || Long.parseLong(this.mFromForumId) <= 0 || StringUtils.isNull(this.hQF)) {
            this.iXH.setCanNoForum(true);
        } else {
            this.iXH.setCanNoForum(false);
        }
        this.iXH.setForumName(this.hQF);
        this.iXH.setTitle(this.jRp.getContent());
        this.iXH.setContent("");
        this.iXH.setType(0);
        if (this.jRp.cyR() != null) {
            if (this.jRp.cyR().getState() == 0) {
                this.iXH.setPrivacy(false);
            } else {
                this.iXH.setPrivacy(true);
            }
        }
        if (this.jRp.cyO() != null) {
            this.iXH.setHasLocationData(this.jRp.cyO().aWP());
        }
        this.iXH.setIsNoTitle(TextUtils.isEmpty(this.iXH.getTitle()));
    }

    private void auP() {
        ckY();
        showLoadingDialog();
        this.jRu = FJ(this.iXH != null ? this.iXH.getTitle() : "");
        if (this.cFZ == null) {
            this.cFZ = new NewWriteModel(this);
        }
        if (!TextUtils.isEmpty(this.fUk)) {
            this.iXH.setCallFrom(this.fUk);
        }
        this.iXH.setPostLatLng(true);
        this.cFZ.d(this.iXH);
        this.cFZ.b(this.cGo);
        this.cFZ.a(this.jlt);
        if (!TextUtils.isEmpty(this.mLat) && !TextUtils.isEmpty(this.mLng)) {
            this.iXH.setLat(this.mLat);
            this.iXH.setLng(this.mLng);
            if (f.arK() && this.iwo != null && !this.jRv) {
                com.baidu.adp.lib.g.e.fZ().postDelayed(this.jRw, 100L);
            } else {
                this.cFZ.cpC();
            }
        } else if (ab.checkLocationForBaiduLocation(getPageContext().getPageActivity())) {
            com.baidu.adp.lib.d.a.fw().a(true, new a.InterfaceC0015a() { // from class: com.baidu.tieba.write.video.WriteVideoActivity.10
                @Override // com.baidu.adp.lib.d.a.InterfaceC0015a
                public void onLocationGeted(int i, String str, Address address) {
                    if (i == 0 && address != null) {
                        WriteVideoActivity.this.mLat = String.valueOf(address.getLatitude());
                        WriteVideoActivity.this.mLng = String.valueOf(address.getLongitude());
                        WriteVideoActivity.this.iXH.setLat(WriteVideoActivity.this.mLat);
                        WriteVideoActivity.this.iXH.setLng(WriteVideoActivity.this.mLng);
                    }
                    if (!f.arK() || WriteVideoActivity.this.iwo == null || WriteVideoActivity.this.jRv) {
                        WriteVideoActivity.this.cFZ.cpC();
                    } else {
                        com.baidu.adp.lib.g.e.fZ().postDelayed(WriteVideoActivity.this.jRw, 100L);
                    }
                }
            });
        } else if (f.arK() && this.iwo != null && !this.jRv) {
            com.baidu.adp.lib.g.e.fZ().postDelayed(this.jRw, 100L);
        } else {
            this.cFZ.cpC();
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
    public void cyJ() {
        VideoInfo videoInfo;
        if (this.iXH != null && (videoInfo = this.iXH.getVideoInfo()) != null && videoInfo.getVideoType() == 2) {
            if ((videoInfo.isCompressedVideo() || videoInfo.getMusicListInfo() != null) && videoInfo.getVideoPath() != null && videoInfo.getVideoPath().contains(com.baidu.tieba.video.c.jwd)) {
                File file = new File(videoInfo.getVideoPath());
                if (file.exists() && file.isFile()) {
                    if (com.baidu.tbadk.core.sharedPref.b.alP().getBoolean(SharedPrefConfig.WRITE_VIDEO_ACTIVITY_SAVE_VIDEO, true)) {
                        m.copyFile(file.getAbsolutePath(), com.baidu.tieba.video.c.jwe + file.getName());
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
            if (AntiHelper.aG(postWriteCallBackData.getErrorCode(), postWriteCallBackData.getErrorString())) {
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
        this.fRI = new com.baidu.tbadk.core.dialog.c(getPageContext().getPageActivity());
        this.fRI.setOnCancelListener(this.flB);
        this.fRI.setCancelable(true);
        this.fRI.setCanceledOnTouchOutside(false);
        g.showDialog(this.fRI, getPageContext().getPageActivity());
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity
    public void finish() {
        ckY();
        destroyWaitingDialog();
        this.flB = null;
        closeLoadingDialog();
        com.baidu.adp.lib.g.e.fZ().removeCallbacks(this.jRx);
        super.finish();
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void destroyWaitingDialog() {
        this.fRI = null;
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
                if (this.jRp.cyV() != null) {
                    this.jRp.cyV().aM(postWriteCallBackData.getSensitiveWords());
                    if (!v.isEmpty(this.jRp.cyV().cxw())) {
                        this.jRp.rS(true);
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
            /* renamed from: aEe */
            public Void doInBackground() {
                File file;
                if (WriteVideoActivity.this.iXH != null && WriteVideoActivity.this.iXH.getVideoInfo() != null && WriteVideoActivity.this.iXH.getVideoInfo().getVideoPath() != null && WriteVideoActivity.this.iXH.getVideoInfo().getVideoPath().contains(com.baidu.tieba.video.c.jwd) && (file = new File(WriteVideoActivity.this.iXH.getVideoInfo().getVideoPath())) != null) {
                    m.copyFile(file.getAbsolutePath(), com.baidu.tieba.video.c.jwe + file.getName());
                }
                m.deleteFileOrDir(new File(com.baidu.tieba.video.c.jwd));
                return null;
            }
        }, new j<Void>() { // from class: com.baidu.tieba.write.video.WriteVideoActivity.4
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tbadk.util.j
            /* renamed from: a */
            public void onReturnDataInUI(Void r1) {
            }
        });
        if (!StringUtils.isNull(this.jxJ)) {
            postWriteCallBackData.mFrom = 3;
        } else if (!StringUtils.isNull(this.hQF)) {
            postWriteCallBackData.mFrom = 2;
        } else {
            postWriteCallBackData.mFrom = 1;
        }
        postWriteCallBackData.mVideoTitleData = this.jRu;
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
        this.jRp.onChangeSkinType(i);
        if (this.jRr != null) {
            this.jRr.onChangeSkinType(i);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        if (this.jRp != null) {
            this.jRp.bmh();
        }
        com.baidu.adp.lib.g.e.fZ().removeCallbacks(this.jRt);
        com.baidu.adp.lib.g.e.fZ().removeCallbacks(this.jRw);
    }

    protected void ckY() {
        if (this.cFZ != null) {
            this.cFZ.cancelLoadData();
        }
        if (this.jRp.cyO() != null) {
            this.jRp.cyO().ckY();
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i == 4) {
            if (this.fRI != null && this.fRI.isShowing()) {
                g.b(this.fRI, getPageContext());
                return true;
            }
            cyK();
            return true;
        }
        return super.onKeyDown(i, keyEvent);
    }

    private void cyK() {
        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(getPageContext().getPageActivity());
        aVar.hT(R.string.give_up_video_confirm);
        aVar.a(R.string.dialog_ok, new a.b() { // from class: com.baidu.tieba.write.video.WriteVideoActivity.5
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                aVar2.dismiss();
                WriteVideoActivity.this.ckY();
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
        aVar.b(getPageContext()).akM();
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.jRp.cyP()) {
            if (b.jRz - this.jRp.cyN() < 0) {
                showToast(getResources().getString(R.string.video_content_overflow));
            } else if (this.jRp.cyV() != null && this.jRp.cyV().cxy()) {
                showToast(this.jRp.cyV().cxA());
                this.jRp.rS(true);
            } else {
                cyI();
                auP();
            }
        } else if (view == this.jRp.getBackButton()) {
            cyK();
        }
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void closeLoadingDialog() {
        if (this.fRI != null) {
            if (this.fRI.isShowing()) {
                g.b(this.fRI, getPageContext());
            }
            this.fRI = null;
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
        if (this.jRq.onTouchEvent(motionEvent)) {
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
        this.jRp.rT(z);
    }

    public VideoTitleData FJ(String str) {
        if (!StringUtils.isNull(str) && !v.isEmpty(this.jxK)) {
            Matcher matcher = Pattern.compile("#(.+)#.*").matcher(str);
            if (matcher.find()) {
                String group = matcher.group(1);
                int i = 0;
                while (true) {
                    int i2 = i;
                    if (i2 >= this.jxK.size()) {
                        break;
                    } else if (this.jxK.get(i2) == null || !group.equals(this.jxK.get(i2).name)) {
                        i = i2 + 1;
                    } else {
                        return this.jxK.get(i2);
                    }
                }
            }
        }
        return null;
    }
}
