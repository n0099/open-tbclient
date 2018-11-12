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
import com.baidu.tbadk.core.util.v;
import com.baidu.tbadk.coreExtra.data.VideoInfo;
import com.baidu.tbadk.coreExtra.data.WriteData;
import com.baidu.tbadk.coreExtra.data.w;
import com.baidu.tbadk.coreExtra.model.f;
import com.baidu.tbadk.util.h;
import com.baidu.tbadk.util.x;
import com.baidu.tieba.e;
import com.baidu.tieba.j.e;
import com.baidu.tieba.j.l;
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
/* loaded from: classes3.dex */
public class WriteVideoActivity extends BaseActivity<WriteVideoActivity> {
    private final NewWriteModel.d aWI;
    private NewWriteModel aWu;
    private Runnable chG;
    private c dVU;
    private String fRD;
    private e.a fyt;
    private e gvU;
    private b hOk;
    private GestureDetector hOl;
    private int hOm;
    private VideoTitleData hOo;
    private boolean hOp;
    private Runnable hOq;
    private a.InterfaceC0304a hhV;
    private l hhY;
    private String hub;
    private List<VideoTitleData> huc;
    private DialogInterface.OnCancelListener mDialogCancelListener;
    private String mFromForumId;
    private InputMethodManager mInputManager;
    public String mLat;
    public String mLng;
    private VideoTitleData mVideoTitleData;
    private final WriteData mData = new WriteData();
    private Runnable hOn = new Runnable() { // from class: com.baidu.tieba.write.video.WriteVideoActivity.1
        @Override // java.lang.Runnable
        public void run() {
            Intent intent = new Intent(MotuVideoConfig.ACTION_FINISH_VIDEO_ALL_ACTIVITY);
            intent.setPackage(TbadkCoreApplication.getInst().getPackageName());
            WriteVideoActivity.this.getPageContext().getPageActivity().sendBroadcast(intent);
        }
    };
    private String dYg = "0";

    public WriteVideoActivity() {
        CustomResponsedMessage runTask = MessageManager.getInstance().runTask(2921309, l.class);
        if (runTask != null) {
            this.hhY = (l) runTask.getData();
        }
        this.fyt = new e.a() { // from class: com.baidu.tieba.write.video.WriteVideoActivity.7
            @Override // com.baidu.tieba.j.e.a
            public void rm(int i) {
                if (i != 1) {
                    WriteVideoActivity.this.hOp = true;
                    return;
                }
                am amVar = new am("c12620");
                amVar.x("obj_locate", 0);
                TiebaStatic.log(amVar);
            }

            @Override // com.baidu.tieba.j.e.a
            public void onChange(boolean z) {
            }

            @Override // com.baidu.tieba.j.e.a
            public void jL(boolean z) {
                WriteVideoActivity.this.hOp = true;
                am amVar = new am("c12621");
                amVar.x("obj_locate", 0);
                amVar.x("obj_param1", z ? 1 : 0);
                TiebaStatic.log(amVar);
            }
        };
        this.hOq = new Runnable() { // from class: com.baidu.tieba.write.video.WriteVideoActivity.9
            @Override // java.lang.Runnable
            public void run() {
                if (!f.IJ() || WriteVideoActivity.this.gvU == null || WriteVideoActivity.this.hOp) {
                    if (WriteVideoActivity.this.aWu != null) {
                        WriteVideoActivity.this.aWu.startPostWrite();
                        return;
                    }
                    return;
                }
                com.baidu.adp.lib.g.e.jG().postDelayed(WriteVideoActivity.this.hOq, 100L);
            }
        };
        this.aWI = new NewWriteModel.d() { // from class: com.baidu.tieba.write.video.WriteVideoActivity.10
            @Override // com.baidu.tieba.tbadkCore.writeModel.NewWriteModel.d
            public void callback(boolean z, PostWriteCallBackData postWriteCallBackData, w wVar, WriteData writeData, AntiData antiData) {
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
                    WriteVideoActivity.this.hOk.bMz();
                    boolean z3 = com.baidu.tbadk.core.sharedPref.b.getInstance().getBoolean("write_video_activity_save_video", true);
                    if (z) {
                        if (WriteVideoActivity.this.mData != null && WriteVideoActivity.this.mData.getVideoInfo() != null) {
                            File file2 = new File(com.baidu.tieba.video.c.hsx);
                            if (!file2.exists()) {
                                file2.mkdirs();
                            }
                            if (z3 && WriteVideoActivity.this.mData.getVideoInfo().getVideoType() == 1) {
                                String str = com.baidu.tieba.video.c.hsx + file.getName();
                                com.baidu.tbadk.core.util.l.copyFile(new File(WriteVideoActivity.this.mData.getVideoInfo().getVideoPath()).getAbsolutePath(), str);
                                WriteVideoActivity.this.aJ(BdBaseApplication.getInst(), str);
                            }
                            WriteVideoActivity.this.bMo();
                            com.baidu.tbadk.core.util.l.x(new File(com.baidu.tieba.video.c.hsw));
                            postWriteCallBackData.mVideoMd5 = WriteVideoActivity.this.mData.getVideoInfo().getVideoMd5();
                        }
                        WriteVideoActivity.this.i(postWriteCallBackData);
                    } else if (postWriteCallBackData != null && postWriteCallBackData.isSensitiveError()) {
                        WriteVideoActivity.this.showToast(postWriteCallBackData.getErrorString());
                        WriteVideoActivity.this.hOk.j(postWriteCallBackData);
                    } else if ((wVar == null || writeData == null || wVar.getVcode_pic_url() == null || AntiHelper.f(antiData)) && postWriteCallBackData != null && postWriteCallBackData.getErrorCode() != 227001) {
                        WriteVideoActivity.this.c(false, postWriteCallBackData);
                    } else if (wVar != null && writeData != null && wVar.getVcode_pic_url() != null) {
                        writeData.setVcodeMD5(wVar.getVcode_md5());
                        writeData.setVcodeUrl(wVar.getVcode_pic_url());
                        writeData.setVcodeExtra(wVar.FS());
                        if (com.baidu.tbadk.q.a.iA(wVar.FR())) {
                            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new NewVcodeActivityConfig(WriteVideoActivity.this.getPageContext().getPageActivity(), IEventCenterService.EventId.EventMode.SAPIACCOUNT_FACE_REG, writeData, false, wVar.FR())));
                        } else {
                            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new VcodeActivityConfig(WriteVideoActivity.this.getPageContext().getPageActivity(), writeData, IEventCenterService.EventId.EventMode.SAPIACCOUNT_FACE_REG)));
                        }
                    } else if (postWriteCallBackData != null && postWriteCallBackData.getErrorCode() == 227001) {
                        MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new AccountAccessActivityConfig(WriteVideoActivity.this.getActivity(), IEventCenterService.EventId.EventMode.SAPIACCOUNT_FACE_REG, writeData, postWriteCallBackData.getAccessState())));
                    }
                }
            }
        };
        this.chG = new Runnable() { // from class: com.baidu.tieba.write.video.WriteVideoActivity.11
            @Override // java.lang.Runnable
            public void run() {
                if (WriteVideoActivity.this.dVU != null) {
                    WriteVideoActivity.this.dVU.setPercent(WriteVideoActivity.this.hOm);
                }
            }
        };
        this.hhV = new a.InterfaceC0304a() { // from class: com.baidu.tieba.write.video.WriteVideoActivity.12
            @Override // com.baidu.tieba.tbadkCore.c.a.InterfaceC0304a
            public void onUploadProgress(int i) {
                WriteVideoActivity.this.hOm = i;
                com.baidu.adp.lib.g.e.jG().post(WriteVideoActivity.this.chG);
            }
        };
        this.mDialogCancelListener = new DialogInterface.OnCancelListener() { // from class: com.baidu.tieba.write.video.WriteVideoActivity.13
            @Override // android.content.DialogInterface.OnCancelListener
            public void onCancel(DialogInterface dialogInterface) {
                WriteVideoActivity.this.destroyWaitingDialog();
                WriteVideoActivity.this.bxc();
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.hOk = new b(this);
        setSwipeBackEnabled(false);
        bMm();
        if (this.mData.getVideoInfo() != null) {
            if (!StringUtils.isNull(this.hub)) {
                VideoTitleData videoTitleData = new VideoTitleData();
                videoTitleData.name = this.hub;
                this.hOk.a(this.mData.getVideoInfo(), videoTitleData, (List<VideoTitleData>) null);
            } else {
                this.hOk.a(this.mData.getVideoInfo(), this.mVideoTitleData, this.huc);
            }
        }
        if (this.hOk.bMt() != null) {
            this.hOk.bMt().d(this);
        }
        adjustResizeForSoftInput();
        this.hOl = new GestureDetector(getPageContext().getPageActivity(), new a());
        this.mInputManager = (InputMethodManager) getSystemService("input_method");
        ShowSoftKeyPadDelay(this.hOk.bMv());
        this.hOk.bMv().requestFocus();
        TiebaStatic.log(new am("c12307"));
        addGlobalLayoutListener();
        if (ab.by(getPageContext().getPageActivity())) {
            com.baidu.adp.lib.d.a.iW().a(true, new a.InterfaceC0017a() { // from class: com.baidu.tieba.write.video.WriteVideoActivity.6
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
            xe(this.mData.getVideoInfo().getVideoPath());
        }
    }

    private void xe(String str) {
        if (f.IJ()) {
            if (this.hhY != null) {
                this.gvU = this.hhY.rH(str);
            }
            if (this.gvU != null) {
                this.gvU.a(this.fyt);
                this.gvU.bay();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        com.baidu.adp.lib.g.e.jG().postDelayed(this.hOn, 500L);
        if (this.hOk != null) {
            this.hOk.bHv();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onStop() {
        super.onStop();
        if (this.hOk != null) {
            this.hOk.aBh();
        }
    }

    private void bMm() {
        Intent intent = getIntent();
        if (intent != null) {
            Serializable serializableExtra = intent.getSerializableExtra(WriteVideoActivityConfig.VIDEO_INFO);
            if (serializableExtra instanceof VideoInfo) {
                this.mData.setVideoInfo((VideoInfo) serializableExtra);
            }
            this.mFromForumId = intent.getStringExtra("forum_id");
            this.fRD = intent.getStringExtra("forum_name");
            this.mData.setForumId(this.mFromForumId);
            this.mData.setForumName(this.fRD);
            this.hub = intent.getStringExtra("video_title");
            if (intent.getSerializableExtra(WriteVideoActivityConfig.FORUM_VIDEO_TITLE) instanceof VideoTitleData) {
                this.mVideoTitleData = (VideoTitleData) intent.getSerializableExtra(WriteVideoActivityConfig.FORUM_VIDEO_TITLE);
            }
            if (intent.getSerializableExtra(WriteVideoActivityConfig.ALL_VIDEO_TITLE) instanceof List) {
                this.huc = (List) intent.getSerializableExtra(WriteVideoActivityConfig.ALL_VIDEO_TITLE);
            }
            if (!StringUtils.isNull(this.fRD)) {
                this.hOk.xh(this.fRD + getResources().getString(e.j.forum));
            } else {
                this.hOk.xh(this.fRD);
            }
            this.dYg = intent.getStringExtra("KEY_CALL_FROM");
            if (EditVideoActivityConfig.FROM_TYPE_RECORD_VIDEO_ACTIVITY.equals(intent.getStringExtra("from_type"))) {
                this.hOk.bMr();
            }
        }
    }

    private void bMn() {
        if (StringUtils.isNull(this.mFromForumId) || Long.parseLong(this.mFromForumId) <= 0 || StringUtils.isNull(this.fRD)) {
            this.mData.setCanNoForum(true);
        } else {
            this.mData.setCanNoForum(false);
        }
        this.mData.setForumName(this.fRD);
        this.mData.setTitle(this.hOk.getContent());
        this.mData.setContent("");
        this.mData.setType(0);
        if (this.hOk.bMw() != null) {
            if (this.hOk.bMw().getState() == 0) {
                this.mData.setPrivacy(false);
            } else {
                this.mData.setPrivacy(true);
            }
        }
        if (this.hOk.bMt() != null) {
            this.mData.setHasLocationData(this.hOk.bMt().akF());
        }
        this.mData.setIsNoTitle(TextUtils.isEmpty(this.mData.getTitle()));
    }

    private void LL() {
        bxc();
        showLoadingDialog();
        this.hOo = xf(this.mData != null ? this.mData.getTitle() : "");
        if (this.aWu == null) {
            this.aWu = new NewWriteModel(this);
        }
        if (!TextUtils.isEmpty(this.dYg)) {
            this.mData.setCallFrom(this.dYg);
        }
        this.mData.setPostLatLng(true);
        this.aWu.setWriteData(this.mData);
        this.aWu.b(this.aWI);
        this.aWu.a(this.hhV);
        if (!TextUtils.isEmpty(this.mLat) && !TextUtils.isEmpty(this.mLng)) {
            this.mData.setLat(this.mLat);
            this.mData.setLng(this.mLng);
            if (f.IJ() && this.gvU != null && !this.hOp) {
                com.baidu.adp.lib.g.e.jG().postDelayed(this.hOq, 100L);
            } else {
                this.aWu.startPostWrite();
            }
        } else if (ab.by(getPageContext().getPageActivity())) {
            com.baidu.adp.lib.d.a.iW().a(true, new a.InterfaceC0017a() { // from class: com.baidu.tieba.write.video.WriteVideoActivity.8
                @Override // com.baidu.adp.lib.d.a.InterfaceC0017a
                public void b(int i, String str, Address address) {
                    if (i == 0 && address != null) {
                        WriteVideoActivity.this.mLat = String.valueOf(address.getLatitude());
                        WriteVideoActivity.this.mLng = String.valueOf(address.getLongitude());
                        WriteVideoActivity.this.mData.setLat(WriteVideoActivity.this.mLat);
                        WriteVideoActivity.this.mData.setLng(WriteVideoActivity.this.mLng);
                    }
                    if (!f.IJ() || WriteVideoActivity.this.gvU == null || WriteVideoActivity.this.hOp) {
                        WriteVideoActivity.this.aWu.startPostWrite();
                    } else {
                        com.baidu.adp.lib.g.e.jG().postDelayed(WriteVideoActivity.this.hOq, 100L);
                    }
                }
            });
        } else if (f.IJ() && this.gvU != null && !this.hOp) {
            com.baidu.adp.lib.g.e.jG().postDelayed(this.hOq, 100L);
        } else {
            this.aWu.startPostWrite();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aJ(Context context, String str) {
        if (context != null) {
            try {
                if (!TextUtils.isEmpty(str)) {
                    new com.baidu.tbadk.core.util.w(context).fg(str);
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
    public void bMo() {
        VideoInfo videoInfo;
        if (this.mData != null && (videoInfo = this.mData.getVideoInfo()) != null && videoInfo.getVideoType() == 2) {
            if ((videoInfo.isCompressedVideo() || videoInfo.getMusicListInfo() != null) && videoInfo.getVideoPath() != null && videoInfo.getVideoPath().contains(com.baidu.tieba.video.c.hsw)) {
                File file = new File(videoInfo.getVideoPath());
                if (file.exists() && file.isFile()) {
                    if (com.baidu.tbadk.core.sharedPref.b.getInstance().getBoolean("write_video_activity_save_video", true)) {
                        com.baidu.tbadk.core.util.l.copyFile(file.getAbsolutePath(), com.baidu.tieba.video.c.hsx + file.getName());
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
            if (AntiHelper.ai(postWriteCallBackData.getErrorCode(), postWriteCallBackData.getErrorString())) {
                AntiHelper.aG(getPageContext().getPageActivity(), postWriteCallBackData.getErrorString());
            } else if (postWriteCallBackData.getErrorCode() != 0) {
                String errorString = postWriteCallBackData.getErrorString();
                if (TextUtils.isEmpty(errorString)) {
                    errorString = getPageContext().getPageActivity().getString(e.j.sand_fail);
                }
                showToast(errorString);
            } else {
                com.baidu.tieba.tbadkCore.writeModel.c.e(getPageContext().getPageActivity(), postWriteCallBackData.getErrorString(), postWriteCallBackData.getPreMsg(), postWriteCallBackData.getColorMsg());
            }
        }
    }

    public void showLoadingDialog() {
        this.dVU = new c(getPageContext().getPageActivity());
        this.dVU.setOnCancelListener(this.mDialogCancelListener);
        this.dVU.setCancelable(true);
        this.dVU.setCanceledOnTouchOutside(false);
        g.a(this.dVU, getPageContext().getPageActivity());
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity
    public void finish() {
        bxc();
        destroyWaitingDialog();
        this.mDialogCancelListener = null;
        closeLoadingDialog();
        com.baidu.adp.lib.g.e.jG().removeCallbacks(this.chG);
        super.finish();
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void destroyWaitingDialog() {
        this.dVU = null;
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
                if (this.hOk.bMA() != null) {
                    this.hOk.bMA().az(postWriteCallBackData.getSensitiveWords());
                    if (!v.I(this.hOk.bMA().bKP())) {
                        this.hOk.oy(true);
                    }
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void i(PostWriteCallBackData postWriteCallBackData) {
        x.a(new com.baidu.tbadk.util.w<Void>() { // from class: com.baidu.tieba.write.video.WriteVideoActivity.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tbadk.util.w
            /* renamed from: Vq */
            public Void doInBackground() {
                File file;
                if (WriteVideoActivity.this.mData != null && WriteVideoActivity.this.mData.getVideoInfo() != null && WriteVideoActivity.this.mData.getVideoInfo().getVideoPath() != null && WriteVideoActivity.this.mData.getVideoInfo().getVideoPath().contains(com.baidu.tieba.video.c.hsw) && (file = new File(WriteVideoActivity.this.mData.getVideoInfo().getVideoPath())) != null) {
                    com.baidu.tbadk.core.util.l.copyFile(file.getAbsolutePath(), com.baidu.tieba.video.c.hsx + file.getName());
                }
                com.baidu.tbadk.core.util.l.x(new File(com.baidu.tieba.video.c.hsw));
                return null;
            }
        }, new h<Void>() { // from class: com.baidu.tieba.write.video.WriteVideoActivity.3
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tbadk.util.h
            /* renamed from: a */
            public void onReturnDataInUI(Void r1) {
            }
        });
        if (!StringUtils.isNull(this.hub)) {
            postWriteCallBackData.mFrom = 3;
        } else if (!StringUtils.isNull(this.fRD)) {
            postWriteCallBackData.mFrom = 2;
        } else {
            postWriteCallBackData.mFrom = 1;
        }
        postWriteCallBackData.mVideoTitleData = this.hOo;
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
        this.hOk.onChangeSkinType(i);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        if (this.hOk != null) {
            this.hOk.aBh();
        }
        com.baidu.adp.lib.g.e.jG().removeCallbacks(this.hOn);
        com.baidu.adp.lib.g.e.jG().removeCallbacks(this.hOq);
    }

    protected void bxc() {
        if (this.aWu != null) {
            this.aWu.cancelLoadData();
        }
        if (this.hOk.bMt() != null) {
            this.hOk.bMt().bxc();
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i == 4) {
            if (this.dVU != null && this.dVU.isShowing()) {
                g.b(this.dVU, getPageContext());
                return true;
            }
            bMp();
            return true;
        }
        return super.onKeyDown(i, keyEvent);
    }

    private void bMp() {
        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(getPageContext().getPageActivity());
        aVar.cN(e.j.give_up_video_confirm);
        aVar.a(e.j.dialog_ok, new a.b() { // from class: com.baidu.tieba.write.video.WriteVideoActivity.4
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                aVar2.dismiss();
                WriteVideoActivity.this.bxc();
                TiebaStatic.log("c10800");
                WriteVideoActivity.this.finish();
            }
        });
        aVar.b(e.j.dialog_cancel, new a.b() { // from class: com.baidu.tieba.write.video.WriteVideoActivity.5
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                aVar2.dismiss();
            }
        });
        aVar.b(getPageContext()).AB();
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.hOk.bMu()) {
            if (b.hOs - this.hOk.bMs() < 0) {
                showToast(getResources().getString(e.j.video_content_overflow));
            } else if (this.hOk.bMA() != null && this.hOk.bMA().bKR()) {
                showToast(this.hOk.bMA().bKT());
                this.hOk.oy(true);
            } else {
                bMn();
                LL();
            }
        } else if (view == this.hOk.getBackButton()) {
            bMp();
        }
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void closeLoadingDialog() {
        if (this.dVU != null) {
            if (this.dVU.isShowing()) {
                g.b(this.dVU, getPageContext());
            }
            this.dVU = null;
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
        if (this.hOl.onTouchEvent(motionEvent)) {
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
        this.hOk.oz(z);
    }

    public VideoTitleData xf(String str) {
        if (!StringUtils.isNull(str) && !v.I(this.huc)) {
            Matcher matcher = Pattern.compile("#(.+)#.*").matcher(str);
            if (matcher.find()) {
                String group = matcher.group(1);
                int i = 0;
                while (true) {
                    int i2 = i;
                    if (i2 >= this.huc.size()) {
                        break;
                    } else if (this.huc.get(i2) == null || !group.equals(this.huc.get(i2).name)) {
                        i = i2 + 1;
                    } else {
                        return this.huc.get(i2);
                    }
                }
            }
        }
        return null;
    }
}
