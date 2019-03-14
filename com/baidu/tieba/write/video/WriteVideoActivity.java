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
import com.baidu.sapi2.passhost.pluginsdk.service.IEventCenterService;
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
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.m;
import com.baidu.tbadk.core.util.v;
import com.baidu.tbadk.core.util.w;
import com.baidu.tbadk.coreExtra.data.VideoInfo;
import com.baidu.tbadk.coreExtra.data.WriteData;
import com.baidu.tbadk.coreExtra.data.x;
import com.baidu.tbadk.coreExtra.model.f;
import com.baidu.tbadk.util.aa;
import com.baidu.tbadk.util.k;
import com.baidu.tbadk.util.z;
import com.baidu.tieba.compatible.StatusBarUtil;
import com.baidu.tieba.d;
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
    private NewWriteModel cke;
    private final NewWriteModel.d cks;
    private Runnable dBo;
    private c fuX;
    private e.a gZi;
    private e hWI;
    private String hso;
    private a.InterfaceC0389a iJN;
    private l iJP;
    private int iWg;
    private String iWh;
    private List<VideoTitleData> iWi;
    private b jqH;
    private GestureDetector jqI;
    private com.baidu.tieba.write.b.c jqJ;
    private int jqK;
    private VideoTitleData jqM;
    private boolean jqN;
    private Runnable jqO;
    private DialogInterface.OnCancelListener mDialogCancelListener;
    private String mFromForumId;
    private InputMethodManager mInputManager;
    public String mLat;
    public String mLng;
    private VideoTitleData mVideoTitleData;
    private final WriteData mData = new WriteData();
    private Runnable jqL = new Runnable() { // from class: com.baidu.tieba.write.video.WriteVideoActivity.1
        @Override // java.lang.Runnable
        public void run() {
            Intent intent = new Intent(MotuVideoConfig.ACTION_FINISH_VIDEO_ALL_ACTIVITY);
            intent.setPackage(TbadkCoreApplication.getInst().getPackageName());
            WriteVideoActivity.this.getPageContext().getPageActivity().sendBroadcast(intent);
        }
    };
    private String fxu = "0";

    public WriteVideoActivity() {
        CustomResponsedMessage runTask = MessageManager.getInstance().runTask(2921309, l.class);
        if (runTask != null) {
            this.iJP = (l) runTask.getData();
        }
        this.gZi = new e.a() { // from class: com.baidu.tieba.write.video.WriteVideoActivity.8
            @Override // com.baidu.tieba.j.e.a
            public void vE(int i) {
                if (i != 1) {
                    WriteVideoActivity.this.jqN = true;
                    return;
                }
                am amVar = new am("c12620");
                amVar.T("obj_locate", 0);
                TiebaStatic.log(amVar);
            }

            @Override // com.baidu.tieba.j.e.a
            public void onChange(boolean z) {
            }

            @Override // com.baidu.tieba.j.e.a
            public void ms(boolean z) {
                WriteVideoActivity.this.jqN = true;
                am amVar = new am("c12621");
                amVar.T("obj_locate", 0);
                amVar.T("obj_param1", z ? 1 : 0);
                TiebaStatic.log(amVar);
            }
        };
        this.jqO = new Runnable() { // from class: com.baidu.tieba.write.video.WriteVideoActivity.11
            @Override // java.lang.Runnable
            public void run() {
                if (!f.ajA() || WriteVideoActivity.this.hWI == null || WriteVideoActivity.this.jqN) {
                    if (WriteVideoActivity.this.cke != null) {
                        WriteVideoActivity.this.cke.startPostWrite();
                        return;
                    }
                    return;
                }
                com.baidu.adp.lib.g.e.jH().postDelayed(WriteVideoActivity.this.jqO, 100L);
            }
        };
        this.cks = new NewWriteModel.d() { // from class: com.baidu.tieba.write.video.WriteVideoActivity.12
            @Override // com.baidu.tieba.tbadkCore.writeModel.NewWriteModel.d
            public void callback(boolean z, PostWriteCallBackData postWriteCallBackData, x xVar, WriteData writeData, AntiData antiData) {
                File file;
                WriteVideoActivity.this.closeLoadingDialog();
                if (postWriteCallBackData != null && WriteVideoActivity.this.mData != null) {
                    boolean z2 = com.baidu.tbadk.core.sharedPref.b.getInstance().getBoolean(MotuVideoConfig.IS_SINGLE_GOD_USER, false);
                    if (WriteVideoActivity.this.mData != null && WriteVideoActivity.this.mData.getVideoInfo() != null && writeData != null) {
                        if (!z2 && WriteVideoActivity.this.mData.getVideoInfo().getVideoDuration() > 8) {
                            writeData.setVideoReviewType(1);
                        } else {
                            writeData.setVideoReviewType(2);
                        }
                    }
                    WriteVideoActivity.this.jqH.cqa();
                    boolean z3 = com.baidu.tbadk.core.sharedPref.b.getInstance().getBoolean("write_video_activity_save_video", true);
                    if (z) {
                        if (WriteVideoActivity.this.mData != null && WriteVideoActivity.this.mData.getVideoInfo() != null) {
                            File file2 = new File(com.baidu.tieba.video.c.iUC);
                            if (!file2.exists()) {
                                file2.mkdirs();
                            }
                            if (z3 && WriteVideoActivity.this.mData.getVideoInfo().getVideoType() == 1) {
                                String str = com.baidu.tieba.video.c.iUC + file.getName();
                                m.bG(new File(WriteVideoActivity.this.mData.getVideoInfo().getVideoPath()).getAbsolutePath(), str);
                                WriteVideoActivity.this.aX(BdBaseApplication.getInst(), str);
                            }
                            WriteVideoActivity.this.cpO();
                            m.G(new File(com.baidu.tieba.video.c.iUB));
                            postWriteCallBackData.mVideoMd5 = WriteVideoActivity.this.mData.getVideoInfo().getVideoMd5();
                        }
                        WriteVideoActivity.this.i(postWriteCallBackData);
                    } else if (postWriteCallBackData != null && postWriteCallBackData.isSensitiveError()) {
                        WriteVideoActivity.this.showToast(postWriteCallBackData.getErrorString());
                        WriteVideoActivity.this.jqH.j(postWriteCallBackData);
                    } else if ((xVar == null || writeData == null || xVar.getVcode_pic_url() == null || AntiHelper.e(antiData)) && postWriteCallBackData != null && postWriteCallBackData.getErrorCode() != 227001) {
                        WriteVideoActivity.this.c(false, postWriteCallBackData);
                    } else if (xVar != null && writeData != null && xVar.getVcode_pic_url() != null) {
                        writeData.setVcodeMD5(xVar.getVcode_md5());
                        writeData.setVcodeUrl(xVar.getVcode_pic_url());
                        writeData.setVcodeExtra(xVar.agE());
                        if (com.baidu.tbadk.u.a.pT(xVar.agD())) {
                            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new NewVcodeActivityConfig(WriteVideoActivity.this.getPageContext().getPageActivity(), IEventCenterService.EventId.EventMode.SAPIACCOUNT_FACE_REG, writeData, false, xVar.agD())));
                        } else {
                            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new VcodeActivityConfig(WriteVideoActivity.this.getPageContext().getPageActivity(), writeData, IEventCenterService.EventId.EventMode.SAPIACCOUNT_FACE_REG)));
                        }
                    } else if (postWriteCallBackData != null && postWriteCallBackData.getErrorCode() == 227001) {
                        MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new AccountAccessActivityConfig(WriteVideoActivity.this.getActivity(), IEventCenterService.EventId.EventMode.SAPIACCOUNT_FACE_REG, writeData, postWriteCallBackData.getAccessState())));
                    }
                }
            }
        };
        this.dBo = new Runnable() { // from class: com.baidu.tieba.write.video.WriteVideoActivity.13
            @Override // java.lang.Runnable
            public void run() {
                if (WriteVideoActivity.this.fuX != null) {
                    WriteVideoActivity.this.fuX.setPercent(WriteVideoActivity.this.jqK);
                }
            }
        };
        this.iJN = new a.InterfaceC0389a() { // from class: com.baidu.tieba.write.video.WriteVideoActivity.14
            @Override // com.baidu.tieba.tbadkCore.c.a.InterfaceC0389a
            public void onUploadProgress(int i) {
                WriteVideoActivity.this.jqK = i;
                com.baidu.adp.lib.g.e.jH().post(WriteVideoActivity.this.dBo);
            }
        };
        this.mDialogCancelListener = new DialogInterface.OnCancelListener() { // from class: com.baidu.tieba.write.video.WriteVideoActivity.2
            @Override // android.content.DialogInterface.OnCancelListener
            public void onCancel(DialogInterface dialogInterface) {
                WriteVideoActivity.this.destroyWaitingDialog();
                WriteVideoActivity.this.cbl();
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.jqH = new b(this);
        setSwipeBackEnabled(false);
        cpL();
        if (this.mData.getVideoInfo() != null) {
            if (!StringUtils.isNull(this.iWh)) {
                VideoTitleData videoTitleData = new VideoTitleData();
                videoTitleData.name = this.iWh;
                this.jqH.a(this.mData.getVideoInfo(), videoTitleData, (List<VideoTitleData>) null);
            } else {
                this.jqH.a(this.mData.getVideoInfo(), this.mVideoTitleData, this.iWi);
            }
        }
        if (this.jqH.cpU() != null) {
            this.jqH.cpU().d(this);
        }
        adjustResizeForSoftInput();
        this.jqI = new GestureDetector(getPageContext().getPageActivity(), new a());
        this.mInputManager = (InputMethodManager) getSystemService("input_method");
        ShowSoftKeyPadDelay(this.jqH.cpW());
        this.jqH.cpW().requestFocus();
        TiebaStatic.log(new am("c12307"));
        addGlobalLayoutListener();
        if (ab.cQ(getPageContext().getPageActivity())) {
            com.baidu.adp.lib.d.a.iW().a(true, new a.InterfaceC0015a() { // from class: com.baidu.tieba.write.video.WriteVideoActivity.7
                @Override // com.baidu.adp.lib.d.a.InterfaceC0015a
                public void b(int i, String str, Address address) {
                    if (i == 0 && address != null) {
                        WriteVideoActivity.this.mLat = String.valueOf(address.getLatitude());
                        WriteVideoActivity.this.mLng = String.valueOf(address.getLongitude());
                    }
                }
            });
        }
        if (this.mData.getVideoInfo() != null && !StringUtils.isNull(this.mData.getVideoInfo().getVideoPath())) {
            Ez(this.mData.getVideoInfo().getVideoPath());
        }
    }

    private void Ez(String str) {
        if (f.ajA()) {
            if (this.iJP != null) {
                this.hWI = this.iJP.zf(str);
            }
            if (this.hWI != null) {
                this.hWI.a(this.gZi);
                this.hWI.bEf();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        com.baidu.adp.lib.g.e.jH().postDelayed(this.jqL, 500L);
        if (this.jqH != null) {
            this.jqH.ckz();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onStop() {
        super.onStop();
        if (this.jqH != null) {
            this.jqH.beM();
        }
    }

    private void cpL() {
        Intent intent = getIntent();
        if (intent != null) {
            Serializable serializableExtra = intent.getSerializableExtra(WriteVideoActivityConfig.VIDEO_INFO);
            if (serializableExtra instanceof VideoInfo) {
                this.mData.setVideoInfo((VideoInfo) serializableExtra);
            }
            this.mFromForumId = intent.getStringExtra("forum_id");
            this.hso = intent.getStringExtra("forum_name");
            this.iWg = intent.getIntExtra("pro_zone", -1);
            this.mData.setForumId(this.mFromForumId);
            this.mData.setForumName(this.hso);
            this.mData.setProZone(this.iWg);
            this.iWh = intent.getStringExtra("video_title");
            if (intent.getSerializableExtra(WriteVideoActivityConfig.FORUM_VIDEO_TITLE) instanceof VideoTitleData) {
                this.mVideoTitleData = (VideoTitleData) intent.getSerializableExtra(WriteVideoActivityConfig.FORUM_VIDEO_TITLE);
            }
            if (intent.getSerializableExtra(WriteVideoActivityConfig.ALL_VIDEO_TITLE) instanceof List) {
                this.iWi = (List) intent.getSerializableExtra(WriteVideoActivityConfig.ALL_VIDEO_TITLE);
            }
            if (!StringUtils.isNull(this.hso)) {
                this.jqH.EC(this.hso + getResources().getString(d.j.forum));
            } else {
                this.jqH.EC(this.hso);
            }
            this.fxu = intent.getStringExtra("KEY_CALL_FROM");
            if (EditVideoActivityConfig.FROM_TYPE_RECORD_VIDEO_ACTIVITY.equals(intent.getStringExtra("from_type"))) {
                this.jqH.cpR();
            }
            cpM();
        }
    }

    private void cpM() {
        this.jqJ = new com.baidu.tieba.write.b.c(getPageContext().getPageActivity(), this.jqH.cpS(), this.mData.getProZone(), isUseStyleImmersiveSticky() ? StatusBarUtil.getStatusBarOffsetPx(getPageContext().getPageActivity()) : 0);
        this.jqJ.a(new c.a() { // from class: com.baidu.tieba.write.video.WriteVideoActivity.9
            @Override // com.baidu.tieba.write.b.c.a
            public void Bo(int i) {
                WriteVideoActivity.this.mData.setProZone(i);
            }
        });
        this.jqJ.aWF();
    }

    private void cpN() {
        if (StringUtils.isNull(this.mFromForumId) || Long.parseLong(this.mFromForumId) <= 0 || StringUtils.isNull(this.hso)) {
            this.mData.setCanNoForum(true);
        } else {
            this.mData.setCanNoForum(false);
        }
        this.mData.setForumName(this.hso);
        this.mData.setTitle(this.jqH.getContent());
        this.mData.setContent("");
        this.mData.setType(0);
        if (this.jqH.cpX() != null) {
            if (this.jqH.cpX().getState() == 0) {
                this.mData.setPrivacy(false);
            } else {
                this.mData.setPrivacy(true);
            }
        }
        if (this.jqH.cpU() != null) {
            this.mData.setHasLocationData(this.jqH.cpU().aNF());
        }
        this.mData.setIsNoTitle(TextUtils.isEmpty(this.mData.getTitle()));
    }

    private void amL() {
        cbl();
        showLoadingDialog();
        this.jqM = EA(this.mData != null ? this.mData.getTitle() : "");
        if (this.cke == null) {
            this.cke = new NewWriteModel(this);
        }
        if (!TextUtils.isEmpty(this.fxu)) {
            this.mData.setCallFrom(this.fxu);
        }
        this.mData.setPostLatLng(true);
        this.cke.setWriteData(this.mData);
        this.cke.b(this.cks);
        this.cke.a(this.iJN);
        if (!TextUtils.isEmpty(this.mLat) && !TextUtils.isEmpty(this.mLng)) {
            this.mData.setLat(this.mLat);
            this.mData.setLng(this.mLng);
            if (f.ajA() && this.hWI != null && !this.jqN) {
                com.baidu.adp.lib.g.e.jH().postDelayed(this.jqO, 100L);
            } else {
                this.cke.startPostWrite();
            }
        } else if (ab.cQ(getPageContext().getPageActivity())) {
            com.baidu.adp.lib.d.a.iW().a(true, new a.InterfaceC0015a() { // from class: com.baidu.tieba.write.video.WriteVideoActivity.10
                @Override // com.baidu.adp.lib.d.a.InterfaceC0015a
                public void b(int i, String str, Address address) {
                    if (i == 0 && address != null) {
                        WriteVideoActivity.this.mLat = String.valueOf(address.getLatitude());
                        WriteVideoActivity.this.mLng = String.valueOf(address.getLongitude());
                        WriteVideoActivity.this.mData.setLat(WriteVideoActivity.this.mLat);
                        WriteVideoActivity.this.mData.setLng(WriteVideoActivity.this.mLng);
                    }
                    if (!f.ajA() || WriteVideoActivity.this.hWI == null || WriteVideoActivity.this.jqN) {
                        WriteVideoActivity.this.cke.startPostWrite();
                    } else {
                        com.baidu.adp.lib.g.e.jH().postDelayed(WriteVideoActivity.this.jqO, 100L);
                    }
                }
            });
        } else if (f.ajA() && this.hWI != null && !this.jqN) {
            com.baidu.adp.lib.g.e.jH().postDelayed(this.jqO, 100L);
        } else {
            this.cke.startPostWrite();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aX(Context context, String str) {
        if (context != null) {
            try {
                if (!TextUtils.isEmpty(str)) {
                    new w(context).mw(str);
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
    public void cpO() {
        VideoInfo videoInfo;
        if (this.mData != null && (videoInfo = this.mData.getVideoInfo()) != null && videoInfo.getVideoType() == 2) {
            if ((videoInfo.isCompressedVideo() || videoInfo.getMusicListInfo() != null) && videoInfo.getVideoPath() != null && videoInfo.getVideoPath().contains(com.baidu.tieba.video.c.iUB)) {
                File file = new File(videoInfo.getVideoPath());
                if (file.exists() && file.isFile()) {
                    if (com.baidu.tbadk.core.sharedPref.b.getInstance().getBoolean("write_video_activity_save_video", true)) {
                        m.bG(file.getAbsolutePath(), com.baidu.tieba.video.c.iUC + file.getName());
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
            if (AntiHelper.aB(postWriteCallBackData.getErrorCode(), postWriteCallBackData.getErrorString())) {
                AntiHelper.aU(getPageContext().getPageActivity(), postWriteCallBackData.getErrorString());
            } else if (postWriteCallBackData.getErrorCode() != 0) {
                String errorString = postWriteCallBackData.getErrorString();
                if (TextUtils.isEmpty(errorString)) {
                    errorString = getPageContext().getPageActivity().getString(d.j.sand_fail);
                }
                showToast(errorString);
            } else {
                com.baidu.tieba.tbadkCore.writeModel.c.f(getPageContext().getPageActivity(), postWriteCallBackData.getErrorString(), postWriteCallBackData.getPreMsg(), postWriteCallBackData.getColorMsg());
            }
        }
    }

    public void showLoadingDialog() {
        this.fuX = new com.baidu.tbadk.core.dialog.c(getPageContext().getPageActivity());
        this.fuX.setOnCancelListener(this.mDialogCancelListener);
        this.fuX.setCancelable(true);
        this.fuX.setCanceledOnTouchOutside(false);
        g.a(this.fuX, getPageContext().getPageActivity());
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity
    public void finish() {
        cbl();
        destroyWaitingDialog();
        this.mDialogCancelListener = null;
        closeLoadingDialog();
        com.baidu.adp.lib.g.e.jH().removeCallbacks(this.dBo);
        super.finish();
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void destroyWaitingDialog() {
        this.fuX = null;
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
                if (this.jqH.cqb() != null) {
                    this.jqH.cqb().aE(postWriteCallBackData.getSensitiveWords());
                    if (!v.T(this.jqH.cqb().cnY())) {
                        this.jqH.re(true);
                    }
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void i(PostWriteCallBackData postWriteCallBackData) {
        aa.a(new z<Void>() { // from class: com.baidu.tieba.write.video.WriteVideoActivity.3
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tbadk.util.z
            /* renamed from: awV */
            public Void doInBackground() {
                File file;
                if (WriteVideoActivity.this.mData != null && WriteVideoActivity.this.mData.getVideoInfo() != null && WriteVideoActivity.this.mData.getVideoInfo().getVideoPath() != null && WriteVideoActivity.this.mData.getVideoInfo().getVideoPath().contains(com.baidu.tieba.video.c.iUB) && (file = new File(WriteVideoActivity.this.mData.getVideoInfo().getVideoPath())) != null) {
                    m.bG(file.getAbsolutePath(), com.baidu.tieba.video.c.iUC + file.getName());
                }
                m.G(new File(com.baidu.tieba.video.c.iUB));
                return null;
            }
        }, new k<Void>() { // from class: com.baidu.tieba.write.video.WriteVideoActivity.4
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tbadk.util.k
            /* renamed from: b */
            public void onReturnDataInUI(Void r1) {
            }
        });
        if (!StringUtils.isNull(this.iWh)) {
            postWriteCallBackData.mFrom = 3;
        } else if (!StringUtils.isNull(this.hso)) {
            postWriteCallBackData.mFrom = 2;
        } else {
            postWriteCallBackData.mFrom = 1;
        }
        postWriteCallBackData.mVideoTitleData = this.jqM;
        if (postWriteCallBackData.mFrom == 3 && postWriteCallBackData != null && !StringUtils.isNull(postWriteCallBackData.buildVideoFakeOnWallUrl())) {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921053));
            com.baidu.tbadk.browser.a.h(this, null, postWriteCallBackData.buildVideoFakeOnWallUrl());
        }
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001374, postWriteCallBackData));
        finish();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        this.jqH.onChangeSkinType(i);
        if (this.jqJ != null) {
            this.jqJ.onChangeSkinType(i);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        if (this.jqH != null) {
            this.jqH.beM();
        }
        com.baidu.adp.lib.g.e.jH().removeCallbacks(this.jqL);
        com.baidu.adp.lib.g.e.jH().removeCallbacks(this.jqO);
    }

    protected void cbl() {
        if (this.cke != null) {
            this.cke.cancelLoadData();
        }
        if (this.jqH.cpU() != null) {
            this.jqH.cpU().cbl();
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i == 4) {
            if (this.fuX != null && this.fuX.isShowing()) {
                g.b(this.fuX, getPageContext());
                return true;
            }
            cpP();
            return true;
        }
        return super.onKeyDown(i, keyEvent);
    }

    private void cpP() {
        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(getPageContext().getPageActivity());
        aVar.gD(d.j.give_up_video_confirm);
        aVar.a(d.j.dialog_ok, new a.b() { // from class: com.baidu.tieba.write.video.WriteVideoActivity.5
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                aVar2.dismiss();
                WriteVideoActivity.this.cbl();
                TiebaStatic.log("c10800");
                WriteVideoActivity.this.finish();
            }
        });
        aVar.b(d.j.dialog_cancel, new a.b() { // from class: com.baidu.tieba.write.video.WriteVideoActivity.6
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                aVar2.dismiss();
            }
        });
        aVar.b(getPageContext()).aaZ();
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.jqH.cpV()) {
            if (b.jqQ - this.jqH.cpT() < 0) {
                showToast(getResources().getString(d.j.video_content_overflow));
            } else if (this.jqH.cqb() != null && this.jqH.cqb().coa()) {
                showToast(this.jqH.cqb().coc());
                this.jqH.re(true);
            } else {
                cpN();
                amL();
            }
        } else if (view == this.jqH.getBackButton()) {
            cpP();
        }
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void closeLoadingDialog() {
        if (this.fuX != null) {
            if (this.fuX.isShowing()) {
                g.b(this.fuX, getPageContext());
            }
            this.fuX = null;
        }
    }

    /* loaded from: classes3.dex */
    private class a extends GestureDetector.SimpleOnGestureListener {
        private a() {
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
        public boolean onFling(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
            com.baidu.adp.lib.util.l.b(WriteVideoActivity.this.getActivity(), WriteVideoActivity.this.getCurrentFocus());
            return super.onFling(motionEvent, motionEvent2, f, f2);
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity, android.view.Window.Callback
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        if (this.jqI.onTouchEvent(motionEvent)) {
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
        this.jqH.rf(z);
    }

    public VideoTitleData EA(String str) {
        if (!StringUtils.isNull(str) && !v.T(this.iWi)) {
            Matcher matcher = Pattern.compile("#(.+)#.*").matcher(str);
            if (matcher.find()) {
                String group = matcher.group(1);
                int i = 0;
                while (true) {
                    int i2 = i;
                    if (i2 >= this.iWi.size()) {
                        break;
                    } else if (this.iWi.get(i2) == null || !group.equals(this.iWi.get(i2).name)) {
                        i = i2 + 1;
                    } else {
                        return this.iWi.get(i2);
                    }
                }
            }
        }
        return null;
    }
}
