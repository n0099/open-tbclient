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
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.lib.util.l;
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
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.ab;
import com.baidu.tbadk.core.util.ak;
import com.baidu.tbadk.core.util.v;
import com.baidu.tbadk.core.util.w;
import com.baidu.tbadk.coreExtra.data.VideoInfo;
import com.baidu.tbadk.coreExtra.data.WriteData;
import com.baidu.tbadk.coreExtra.data.s;
import com.baidu.tbadk.coreExtra.model.f;
import com.baidu.tbadk.util.h;
import com.baidu.tbadk.util.u;
import com.baidu.tieba.d;
import com.baidu.tieba.i.e;
import com.baidu.tieba.i.k;
import com.baidu.tieba.tbadkCore.c.a;
import com.baidu.tieba.tbadkCore.util.AntiHelper;
import com.baidu.tieba.tbadkCore.writeModel.NewWriteModel;
import com.baidu.tieba.tbadkCore.writeModel.PostWriteCallBackData;
import com.baidu.tieba.video.VideoTitleData;
import java.io.File;
import java.io.Serializable;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
/* loaded from: classes2.dex */
public class WriteVideoActivity extends BaseActivity<WriteVideoActivity> {
    private NewWriteModel brB;
    private final NewWriteModel.d brP;
    private String csJ;
    private com.baidu.tbadk.core.dialog.c dMw;
    private String fLf;
    private e.a fro;
    private e gCL;
    private c hQp;
    private GestureDetector hQq;
    private int hQr;
    private VideoTitleData hQt;
    private boolean hQu;
    private Runnable hQv;
    private Runnable hQw;
    private a.InterfaceC0154a hmh;
    private k hmj;
    private String hyi;
    private List<VideoTitleData> hyj;
    private DialogInterface.OnCancelListener mDialogCancelListener;
    private InputMethodManager mInputManager;
    public String mLat;
    public String mLng;
    private VideoTitleData mVideoTitleData;
    private final WriteData mData = new WriteData();
    private Runnable hQs = new Runnable() { // from class: com.baidu.tieba.write.video.WriteVideoActivity.1
        @Override // java.lang.Runnable
        public void run() {
            Intent intent = new Intent(MotuVideoConfig.ACTION_FINISH_VIDEO_ALL_ACTIVITY);
            intent.setPackage(TbadkCoreApplication.getInst().getPackageName());
            WriteVideoActivity.this.getPageContext().getPageActivity().sendBroadcast(intent);
        }
    };
    private String hyr = "0";

    public WriteVideoActivity() {
        CustomResponsedMessage runTask = MessageManager.getInstance().runTask(CmdConfigCustom.CMD_GET_VIDEO_PLATFORM_FACTORY, k.class);
        if (runTask != null) {
            this.hmj = (k) runTask.getData();
        }
        this.fro = new e.a() { // from class: com.baidu.tieba.write.video.WriteVideoActivity.7
            @Override // com.baidu.tieba.i.e.a
            public void sk(int i) {
                if (i != 1) {
                    WriteVideoActivity.this.hQu = true;
                    return;
                }
                ak akVar = new ak("c12620");
                akVar.s("obj_locate", 0);
                TiebaStatic.log(akVar);
            }

            @Override // com.baidu.tieba.i.e.a
            public void onChange(boolean z) {
            }

            @Override // com.baidu.tieba.i.e.a
            public void iS(boolean z) {
                WriteVideoActivity.this.hQu = true;
                ak akVar = new ak("c12621");
                akVar.s("obj_locate", 0);
                akVar.s("obj_param1", z ? 1 : 0);
                TiebaStatic.log(akVar);
            }
        };
        this.hQv = new Runnable() { // from class: com.baidu.tieba.write.video.WriteVideoActivity.9
            @Override // java.lang.Runnable
            public void run() {
                if (!f.Ie() || WriteVideoActivity.this.gCL == null || WriteVideoActivity.this.hQu) {
                    if (WriteVideoActivity.this.brB != null) {
                        WriteVideoActivity.this.brB.startPostWrite();
                        return;
                    }
                    return;
                }
                com.baidu.adp.lib.g.e.nr().postDelayed(WriteVideoActivity.this.hQv, 100L);
            }
        };
        this.brP = new NewWriteModel.d() { // from class: com.baidu.tieba.write.video.WriteVideoActivity.10
            @Override // com.baidu.tieba.tbadkCore.writeModel.NewWriteModel.d
            public void callback(boolean z, PostWriteCallBackData postWriteCallBackData, s sVar, WriteData writeData, AntiData antiData) {
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
                    WriteVideoActivity.this.hQp.bMY();
                    boolean z3 = com.baidu.tbadk.core.sharedPref.b.getInstance().getBoolean("write_video_activity_save_video", true);
                    if (z) {
                        if (WriteVideoActivity.this.mData != null && WriteVideoActivity.this.mData.getVideoInfo() != null) {
                            File file2 = new File(com.baidu.tieba.video.b.hwF);
                            if (!file2.exists()) {
                                file2.mkdirs();
                            }
                            if (z3 && WriteVideoActivity.this.mData.getVideoInfo().getVideoType() == 1) {
                                String str = com.baidu.tieba.video.b.hwF + file.getName();
                                com.baidu.tbadk.core.util.k.Y(new File(WriteVideoActivity.this.mData.getVideoInfo().getVideoPath()).getAbsolutePath(), str);
                                WriteVideoActivity.this.ar(BdBaseApplication.getInst(), str);
                            }
                            WriteVideoActivity.this.bMN();
                            com.baidu.tbadk.core.util.k.s(new File(com.baidu.tieba.video.b.hwE));
                            postWriteCallBackData.mVideoMd5 = WriteVideoActivity.this.mData.getVideoInfo().getVideoMd5();
                        }
                        WriteVideoActivity.this.h(postWriteCallBackData);
                    } else if (postWriteCallBackData != null && postWriteCallBackData.isSensitiveError()) {
                        WriteVideoActivity.this.showToast(postWriteCallBackData.getErrorString());
                        WriteVideoActivity.this.hQp.i(postWriteCallBackData);
                    } else if ((sVar == null || writeData == null || sVar.getVcode_pic_url() == null || AntiHelper.f(antiData)) && postWriteCallBackData != null && postWriteCallBackData.getErrorCode() != 227001) {
                        WriteVideoActivity.this.c(false, postWriteCallBackData);
                    } else if (sVar != null && writeData != null && sVar.getVcode_pic_url() != null) {
                        writeData.setVcodeMD5(sVar.getVcode_md5());
                        writeData.setVcodeUrl(sVar.getVcode_pic_url());
                        writeData.setVcodeExtra(sVar.FJ());
                        if (com.baidu.tbadk.p.a.hf(sVar.FI())) {
                            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new NewVcodeActivityConfig(WriteVideoActivity.this.getPageContext().getPageActivity(), IEventCenterService.EventId.EventMode.SAPIACCOUNT_FACE_REG, writeData, false, sVar.FI())));
                        } else {
                            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new VcodeActivityConfig(WriteVideoActivity.this.getPageContext().getPageActivity(), writeData, IEventCenterService.EventId.EventMode.SAPIACCOUNT_FACE_REG)));
                        }
                    } else if (postWriteCallBackData != null && postWriteCallBackData.getErrorCode() == 227001) {
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AccountAccessActivityConfig(WriteVideoActivity.this.getActivity(), IEventCenterService.EventId.EventMode.SAPIACCOUNT_FACE_REG, writeData, postWriteCallBackData.getAccessState())));
                    }
                }
            }
        };
        this.hQw = new Runnable() { // from class: com.baidu.tieba.write.video.WriteVideoActivity.11
            @Override // java.lang.Runnable
            public void run() {
                if (WriteVideoActivity.this.dMw != null) {
                    WriteVideoActivity.this.dMw.setPercent(WriteVideoActivity.this.hQr);
                }
            }
        };
        this.hmh = new a.InterfaceC0154a() { // from class: com.baidu.tieba.write.video.WriteVideoActivity.12
            @Override // com.baidu.tieba.tbadkCore.c.a.InterfaceC0154a
            public void onUploadProgress(int i) {
                WriteVideoActivity.this.hQr = i;
                com.baidu.adp.lib.g.e.nr().post(WriteVideoActivity.this.hQw);
            }
        };
        this.mDialogCancelListener = new DialogInterface.OnCancelListener() { // from class: com.baidu.tieba.write.video.WriteVideoActivity.13
            @Override // android.content.DialogInterface.OnCancelListener
            public void onCancel(DialogInterface dialogInterface) {
                WriteVideoActivity.this.destroyWaitingDialog();
                WriteVideoActivity.this.bxS();
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.hQp = new c(this);
        setSwipeBackEnabled(false);
        bML();
        if (this.mData.getVideoInfo() != null) {
            if (!StringUtils.isNull(this.hyi)) {
                VideoTitleData videoTitleData = new VideoTitleData();
                videoTitleData.name = this.hyi;
                this.hQp.a(this.mData.getVideoInfo(), videoTitleData, (List<VideoTitleData>) null);
            } else {
                this.hQp.a(this.mData.getVideoInfo(), this.mVideoTitleData, this.hyj);
            }
        }
        if (this.hQp.bMS() != null) {
            this.hQp.bMS().g(this);
        }
        adjustResizeForSoftInput();
        this.hQq = new GestureDetector(getPageContext().getPageActivity(), new a());
        this.mInputManager = (InputMethodManager) getSystemService("input_method");
        ShowSoftKeyPadDelay(this.hQp.bMU());
        this.hQp.bMU().requestFocus();
        TiebaStatic.log(new ak("c12307"));
        addGlobalLayoutListener();
        if (ab.aS(getPageContext().getPageActivity())) {
            com.baidu.adp.lib.d.a.mF().a(true, new a.InterfaceC0017a() { // from class: com.baidu.tieba.write.video.WriteVideoActivity.6
                @Override // com.baidu.adp.lib.d.a.InterfaceC0017a
                public void b(int i, String str, Address address) {
                    if (i == 0 && address != null) {
                        WriteVideoActivity.this.mLat = String.valueOf(address.getLatitude());
                        WriteVideoActivity.this.mLng = String.valueOf(address.getLongitude());
                    }
                }
            });
        }
        if (this.mData.getVideoInfo() != null && !StringUtils.isNull(this.mData.getVideoInfo().getVideoPath())) {
            uS(this.mData.getVideoInfo().getVideoPath());
        }
    }

    private void uS(String str) {
        if (f.Ie()) {
            if (this.hmj != null) {
                this.gCL = this.hmj.pp(str);
            }
            if (this.gCL != null) {
                this.gCL.a(this.fro);
                this.gCL.aUT();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        com.baidu.adp.lib.g.e.nr().postDelayed(this.hQs, 500L);
        if (this.hQp != null) {
            this.hQp.bIl();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onStop() {
        super.onStop();
        if (this.hQp != null) {
            this.hQp.aut();
        }
    }

    private void bML() {
        Intent intent = getIntent();
        if (intent != null) {
            Serializable serializableExtra = intent.getSerializableExtra(WriteVideoActivityConfig.VIDEO_INFO);
            if (serializableExtra instanceof VideoInfo) {
                this.mData.setVideoInfo((VideoInfo) serializableExtra);
            }
            this.csJ = intent.getStringExtra("forum_id");
            this.fLf = intent.getStringExtra("forum_name");
            this.mData.setForumId(this.csJ);
            this.mData.setForumName(this.fLf);
            this.hyi = intent.getStringExtra("video_title");
            if (intent.getSerializableExtra(WriteVideoActivityConfig.FORUM_VIDEO_TITLE) instanceof VideoTitleData) {
                this.mVideoTitleData = (VideoTitleData) intent.getSerializableExtra(WriteVideoActivityConfig.FORUM_VIDEO_TITLE);
            }
            if (intent.getSerializableExtra(WriteVideoActivityConfig.ALL_VIDEO_TITLE) instanceof List) {
                this.hyj = (List) intent.getSerializableExtra(WriteVideoActivityConfig.ALL_VIDEO_TITLE);
            }
            if (!StringUtils.isNull(this.fLf)) {
                this.hQp.uV(this.fLf + getResources().getString(d.j.forum));
            } else {
                this.hQp.uV(this.fLf);
            }
            this.hyr = intent.getStringExtra("KEY_CALL_FROM");
            if (EditVideoActivityConfig.FROM_TYPE_RECORD_VIDEO_ACTIVITY.equals(intent.getStringExtra("from_type"))) {
                this.hQp.bMQ();
            }
        }
    }

    private void bMM() {
        if (StringUtils.isNull(this.csJ) || Long.parseLong(this.csJ) <= 0 || StringUtils.isNull(this.fLf)) {
            this.mData.setCanNoForum(true);
        } else {
            this.mData.setCanNoForum(false);
        }
        this.mData.setForumName(this.fLf);
        this.mData.setTitle(this.hQp.getContent());
        this.mData.setContent("");
        this.mData.setType(0);
        if (this.hQp.bMV() != null) {
            if (this.hQp.bMV().getState() == 0) {
                this.mData.setPrivacy(false);
            } else {
                this.mData.setPrivacy(true);
            }
        }
        if (this.hQp.bMS() != null) {
            this.mData.setHasLocationData(this.hQp.bMS().agr());
        }
        this.mData.setIsNoTitle(TextUtils.isEmpty(this.mData.getTitle()));
    }

    private void Lx() {
        bxS();
        showLoadingDialog();
        this.hQt = uT(this.mData != null ? this.mData.getTitle() : "");
        if (this.brB == null) {
            this.brB = new NewWriteModel(this);
        }
        if (!TextUtils.isEmpty(this.hyr)) {
            this.mData.setCallFrom(this.hyr);
        }
        this.mData.setPostLatLng(true);
        this.brB.setWriteData(this.mData);
        this.brB.b(this.brP);
        this.brB.a(this.hmh);
        if (!TextUtils.isEmpty(this.mLat) && !TextUtils.isEmpty(this.mLng)) {
            this.mData.setLat(this.mLat);
            this.mData.setLng(this.mLng);
            if (f.Ie() && this.gCL != null && !this.hQu) {
                com.baidu.adp.lib.g.e.nr().postDelayed(this.hQv, 100L);
            } else {
                this.brB.startPostWrite();
            }
        } else if (ab.aS(getPageContext().getPageActivity())) {
            com.baidu.adp.lib.d.a.mF().a(true, new a.InterfaceC0017a() { // from class: com.baidu.tieba.write.video.WriteVideoActivity.8
                @Override // com.baidu.adp.lib.d.a.InterfaceC0017a
                public void b(int i, String str, Address address) {
                    if (i == 0 && address != null) {
                        WriteVideoActivity.this.mLat = String.valueOf(address.getLatitude());
                        WriteVideoActivity.this.mLng = String.valueOf(address.getLongitude());
                        WriteVideoActivity.this.mData.setLat(WriteVideoActivity.this.mLat);
                        WriteVideoActivity.this.mData.setLng(WriteVideoActivity.this.mLng);
                    }
                    if (!f.Ie() || WriteVideoActivity.this.gCL == null || WriteVideoActivity.this.hQu) {
                        WriteVideoActivity.this.brB.startPostWrite();
                    } else {
                        com.baidu.adp.lib.g.e.nr().postDelayed(WriteVideoActivity.this.hQv, 100L);
                    }
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ar(Context context, String str) {
        if (context != null) {
            try {
                if (!TextUtils.isEmpty(str)) {
                    new w(context).dP(str);
                    Intent intent = new Intent("android.intent.action.MEDIA_SCANNER_SCAN_FILE");
                    intent.setData(Uri.fromFile(new File(str)));
                    context.sendBroadcast(intent);
                }
            } catch (Exception e) {
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bMN() {
        VideoInfo videoInfo;
        if (this.mData != null && (videoInfo = this.mData.getVideoInfo()) != null && videoInfo.getVideoType() == 2) {
            if ((videoInfo.isCompressedVideo() || videoInfo.getMusicListInfo() != null) && videoInfo.getVideoPath() != null && videoInfo.getVideoPath().contains(com.baidu.tieba.video.b.hwE)) {
                File file = new File(videoInfo.getVideoPath());
                if (file.exists() && file.isFile()) {
                    if (com.baidu.tbadk.core.sharedPref.b.getInstance().getBoolean("write_video_activity_save_video", true)) {
                        com.baidu.tbadk.core.util.k.Y(file.getAbsolutePath(), com.baidu.tieba.video.b.hwF + file.getName());
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
            if (AntiHelper.xo(postWriteCallBackData.getErrorCode())) {
                AntiHelper.ap(getPageContext().getPageActivity(), postWriteCallBackData.getErrorString());
            } else if (postWriteCallBackData.getErrorCode() != 0) {
                String errorString = postWriteCallBackData.getErrorString();
                if (TextUtils.isEmpty(errorString)) {
                    errorString = getPageContext().getPageActivity().getString(d.j.sand_fail);
                }
                showToast(errorString);
            } else {
                com.baidu.tieba.tbadkCore.writeModel.c.e(getPageContext().getPageActivity(), postWriteCallBackData.getErrorString(), postWriteCallBackData.getPreMsg(), postWriteCallBackData.getColorMsg());
            }
        }
    }

    public void showLoadingDialog() {
        this.dMw = new com.baidu.tbadk.core.dialog.c(getPageContext().getPageActivity());
        this.dMw.setOnCancelListener(this.mDialogCancelListener);
        this.dMw.setCancelable(true);
        this.dMw.setCanceledOnTouchOutside(false);
        g.a(this.dMw, getPageContext().getPageActivity());
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity
    public void finish() {
        bxS();
        destroyWaitingDialog();
        this.mDialogCancelListener = null;
        closeLoadingDialog();
        com.baidu.adp.lib.g.e.nr().removeCallbacks(this.hQw);
        super.finish();
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void destroyWaitingDialog() {
        this.dMw = null;
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
                    h(postWriteCallBackData2);
                }
            } else if (intent != null && intent.getExtras() != null && (intent.getExtras().getSerializable("post_write_callback_data") instanceof PostWriteCallBackData) && (postWriteCallBackData = (PostWriteCallBackData) intent.getExtras().getSerializable("post_write_callback_data")) != null && postWriteCallBackData.isSensitiveError()) {
                showToast(postWriteCallBackData.getErrorString());
                if (this.hQp.bMZ() != null) {
                    this.hQp.bMZ().aB(postWriteCallBackData.getSensitiveWords());
                    if (!v.G(this.hQp.bMZ().bLm())) {
                        this.hQp.ow(true);
                    }
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void h(PostWriteCallBackData postWriteCallBackData) {
        com.baidu.tbadk.util.v.a(new u<Void>() { // from class: com.baidu.tieba.write.video.WriteVideoActivity.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tbadk.util.u
            /* renamed from: Uh */
            public Void doInBackground() {
                File file;
                if (WriteVideoActivity.this.mData != null && WriteVideoActivity.this.mData.getVideoInfo() != null && WriteVideoActivity.this.mData.getVideoInfo().getVideoPath() != null && WriteVideoActivity.this.mData.getVideoInfo().getVideoPath().contains(com.baidu.tieba.video.b.hwE) && (file = new File(WriteVideoActivity.this.mData.getVideoInfo().getVideoPath())) != null) {
                    com.baidu.tbadk.core.util.k.Y(file.getAbsolutePath(), com.baidu.tieba.video.b.hwF + file.getName());
                }
                com.baidu.tbadk.core.util.k.s(new File(com.baidu.tieba.video.b.hwE));
                return null;
            }
        }, new h<Void>() { // from class: com.baidu.tieba.write.video.WriteVideoActivity.3
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tbadk.util.h
            /* renamed from: c */
            public void onReturnDataInUI(Void r1) {
            }
        });
        if (!StringUtils.isNull(this.hyi)) {
            postWriteCallBackData.mFrom = 3;
        } else if (!StringUtils.isNull(this.fLf)) {
            postWriteCallBackData.mFrom = 2;
        } else {
            postWriteCallBackData.mFrom = 1;
        }
        postWriteCallBackData.mVideoTitleData = this.hQt;
        if (postWriteCallBackData.mFrom == 3 && postWriteCallBackData != null && !StringUtils.isNull(postWriteCallBackData.buildVideoFakeOnWallUrl())) {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_FINISH_THIS_PAGE));
            com.baidu.tbadk.browser.a.g(this, null, postWriteCallBackData.buildVideoFakeOnWallUrl());
        }
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_VIDEO_WRITE_POST_SUCCESS, postWriteCallBackData));
        finish();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        this.hQp.onChangeSkinType(i);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        if (this.hQp != null) {
            this.hQp.aut();
        }
        com.baidu.adp.lib.g.e.nr().removeCallbacks(this.hQs);
        com.baidu.adp.lib.g.e.nr().removeCallbacks(this.hQv);
    }

    protected void bxS() {
        if (this.brB != null) {
            this.brB.cancelLoadData();
        }
        if (this.hQp.bMS() != null) {
            this.hQp.bMS().bxS();
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i == 4) {
            if (this.dMw != null && this.dMw.isShowing()) {
                g.b(this.dMw, getPageContext());
                return true;
            }
            bMO();
            return true;
        }
        return super.onKeyDown(i, keyEvent);
    }

    private void bMO() {
        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(getPageContext().getPageActivity());
        aVar.fd(d.j.give_up_video_confirm);
        aVar.a(d.j.dialog_ok, new a.b() { // from class: com.baidu.tieba.write.video.WriteVideoActivity.4
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                aVar2.dismiss();
                WriteVideoActivity.this.bxS();
                TiebaStatic.log("c10800");
                WriteVideoActivity.this.finish();
            }
        });
        aVar.b(d.j.dialog_cancel, new a.b() { // from class: com.baidu.tieba.write.video.WriteVideoActivity.5
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                aVar2.dismiss();
            }
        });
        aVar.b(getPageContext()).AI();
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.hQp.bMT()) {
            if (c.hQy - this.hQp.bMR() < 0) {
                showToast(getResources().getString(d.j.video_content_overflow));
            } else if (this.hQp.bMZ() != null && this.hQp.bMZ().bLo()) {
                showToast(this.hQp.bMZ().bLq());
                this.hQp.ow(true);
            } else {
                bMM();
                Lx();
            }
        } else if (view == this.hQp.getBackButton()) {
            bMO();
        }
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void closeLoadingDialog() {
        if (this.dMw != null) {
            if (this.dMw.isShowing()) {
                g.b(this.dMw, getPageContext());
            }
            this.dMw = null;
        }
    }

    /* loaded from: classes2.dex */
    private class a extends GestureDetector.SimpleOnGestureListener {
        private a() {
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
        public boolean onFling(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
            l.a(WriteVideoActivity.this.getActivity(), WriteVideoActivity.this.getCurrentFocus());
            return super.onFling(motionEvent, motionEvent2, f, f2);
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity, android.view.Window.Callback
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        if (this.hQq.onTouchEvent(motionEvent)) {
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
        this.hQp.ox(z);
    }

    public VideoTitleData uT(String str) {
        if (!StringUtils.isNull(str) && !v.G(this.hyj)) {
            Matcher matcher = Pattern.compile("#(.+)#.*").matcher(str);
            if (matcher.find()) {
                String group = matcher.group(1);
                int i = 0;
                while (true) {
                    int i2 = i;
                    if (i2 >= this.hyj.size()) {
                        break;
                    } else if (this.hyj.get(i2) == null || !group.equals(this.hyj.get(i2).name)) {
                        i = i2 + 1;
                    } else {
                        return this.hyj.get(i2);
                    }
                }
            }
        }
        return null;
    }
}
