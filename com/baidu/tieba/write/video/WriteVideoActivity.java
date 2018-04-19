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
import com.baidu.tbadk.core.dialog.c;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.ab;
import com.baidu.tbadk.core.util.al;
import com.baidu.tbadk.core.util.v;
import com.baidu.tbadk.core.util.w;
import com.baidu.tbadk.coreExtra.data.VideoInfo;
import com.baidu.tbadk.coreExtra.data.WriteData;
import com.baidu.tbadk.coreExtra.data.t;
import com.baidu.tbadk.coreExtra.model.f;
import com.baidu.tbadk.util.h;
import com.baidu.tbadk.util.u;
import com.baidu.tieba.d;
import com.baidu.tieba.j.e;
import com.baidu.tieba.j.k;
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
    private final NewWriteModel.d aEK;
    private NewWriteModel aEw;
    private Runnable bGI;
    private String bNn;
    private c dpz;
    private e.a eRz;
    private e fOK;
    private String fkm;
    private String gLp;
    private List<VideoTitleData> gLq;
    private a.InterfaceC0216a gzR;
    private k gzT;
    private b heD;
    private GestureDetector heE;
    private int heF;
    private VideoTitleData heH;
    private boolean heI;
    private Runnable heJ;
    private DialogInterface.OnCancelListener mDialogCancelListener;
    private InputMethodManager mInputManager;
    public String mLat;
    public String mLng;
    private VideoTitleData mVideoTitleData;
    private final WriteData mData = new WriteData();
    private Runnable heG = new Runnable() { // from class: com.baidu.tieba.write.video.WriteVideoActivity.1
        @Override // java.lang.Runnable
        public void run() {
            Intent intent = new Intent(MotuVideoConfig.ACTION_FINISH_VIDEO_ALL_ACTIVITY);
            intent.setPackage(TbadkCoreApplication.getInst().getPackageName());
            WriteVideoActivity.this.getPageContext().getPageActivity().sendBroadcast(intent);
        }
    };
    private String gLy = "0";

    public WriteVideoActivity() {
        CustomResponsedMessage runTask = MessageManager.getInstance().runTask(2921309, k.class);
        if (runTask != null) {
            this.gzT = (k) runTask.getData();
        }
        this.eRz = new e.a() { // from class: com.baidu.tieba.write.video.WriteVideoActivity.7
            @Override // com.baidu.tieba.j.e.a
            public void pC(int i) {
                if (i != 1) {
                    WriteVideoActivity.this.heI = true;
                    return;
                }
                al alVar = new al("c12620");
                alVar.r("obj_locate", 0);
                TiebaStatic.log(alVar);
            }

            @Override // com.baidu.tieba.j.e.a
            public void onChange(boolean z) {
            }

            @Override // com.baidu.tieba.j.e.a
            public void iI(boolean z) {
                WriteVideoActivity.this.heI = true;
                al alVar = new al("c12621");
                alVar.r("obj_locate", 0);
                alVar.r("obj_param1", z ? 1 : 0);
                TiebaStatic.log(alVar);
            }
        };
        this.heJ = new Runnable() { // from class: com.baidu.tieba.write.video.WriteVideoActivity.9
            @Override // java.lang.Runnable
            public void run() {
                if (!f.Bt() || WriteVideoActivity.this.fOK == null || WriteVideoActivity.this.heI) {
                    if (WriteVideoActivity.this.aEw != null) {
                        WriteVideoActivity.this.aEw.startPostWrite();
                        return;
                    }
                    return;
                }
                com.baidu.adp.lib.g.e.fw().postDelayed(WriteVideoActivity.this.heJ, 100L);
            }
        };
        this.aEK = new NewWriteModel.d() { // from class: com.baidu.tieba.write.video.WriteVideoActivity.10
            @Override // com.baidu.tieba.tbadkCore.writeModel.NewWriteModel.d
            public void callback(boolean z, PostWriteCallBackData postWriteCallBackData, t tVar, WriteData writeData, AntiData antiData) {
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
                    WriteVideoActivity.this.heD.bCE();
                    boolean z3 = com.baidu.tbadk.core.sharedPref.b.getInstance().getBoolean("write_video_activity_save_video", true);
                    if (z) {
                        if (WriteVideoActivity.this.mData != null && WriteVideoActivity.this.mData.getVideoInfo() != null) {
                            File file2 = new File(com.baidu.tieba.video.b.gJK);
                            if (!file2.exists()) {
                                file2.mkdirs();
                            }
                            if (z3 && WriteVideoActivity.this.mData.getVideoInfo().getVideoType() == 1) {
                                String str = com.baidu.tieba.video.b.gJK + file.getName();
                                com.baidu.tbadk.core.util.k.Z(new File(WriteVideoActivity.this.mData.getVideoInfo().getVideoPath()).getAbsolutePath(), str);
                                WriteVideoActivity.this.ap(BdBaseApplication.getInst(), str);
                            }
                            WriteVideoActivity.this.bCt();
                            com.baidu.tbadk.core.util.k.r(new File(com.baidu.tieba.video.b.gJJ));
                            postWriteCallBackData.mVideoMd5 = WriteVideoActivity.this.mData.getVideoInfo().getVideoMd5();
                        }
                        WriteVideoActivity.this.i(postWriteCallBackData);
                    } else if (postWriteCallBackData != null && postWriteCallBackData.isSensitiveError()) {
                        WriteVideoActivity.this.showToast(postWriteCallBackData.getErrorString());
                        WriteVideoActivity.this.heD.j(postWriteCallBackData);
                    } else if ((tVar == null || writeData == null || tVar.getVcode_pic_url() == null || AntiHelper.f(antiData)) && postWriteCallBackData != null && postWriteCallBackData.getErrorCode() != 227001) {
                        WriteVideoActivity.this.c(false, postWriteCallBackData);
                    } else if (tVar != null && writeData != null && tVar.getVcode_pic_url() != null) {
                        writeData.setVcodeMD5(tVar.getVcode_md5());
                        writeData.setVcodeUrl(tVar.getVcode_pic_url());
                        writeData.setVcodeExtra(tVar.yL());
                        if (com.baidu.tbadk.p.a.hq(tVar.yK())) {
                            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new NewVcodeActivityConfig(WriteVideoActivity.this.getPageContext().getPageActivity(), IEventCenterService.EventId.EventMode.SAPIACCOUNT_FACE_REG, writeData, false, tVar.yK())));
                        } else {
                            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new VcodeActivityConfig(WriteVideoActivity.this.getPageContext().getPageActivity(), writeData, IEventCenterService.EventId.EventMode.SAPIACCOUNT_FACE_REG)));
                        }
                    } else if (postWriteCallBackData != null && postWriteCallBackData.getErrorCode() == 227001) {
                        MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new AccountAccessActivityConfig(WriteVideoActivity.this.getActivity(), IEventCenterService.EventId.EventMode.SAPIACCOUNT_FACE_REG, writeData, postWriteCallBackData.getAccessState())));
                    }
                }
            }
        };
        this.bGI = new Runnable() { // from class: com.baidu.tieba.write.video.WriteVideoActivity.11
            @Override // java.lang.Runnable
            public void run() {
                if (WriteVideoActivity.this.dpz != null) {
                    WriteVideoActivity.this.dpz.setPercent(WriteVideoActivity.this.heF);
                }
            }
        };
        this.gzR = new a.InterfaceC0216a() { // from class: com.baidu.tieba.write.video.WriteVideoActivity.12
            @Override // com.baidu.tieba.tbadkCore.c.a.InterfaceC0216a
            public void onUploadProgress(int i) {
                WriteVideoActivity.this.heF = i;
                com.baidu.adp.lib.g.e.fw().post(WriteVideoActivity.this.bGI);
            }
        };
        this.mDialogCancelListener = new DialogInterface.OnCancelListener() { // from class: com.baidu.tieba.write.video.WriteVideoActivity.13
            @Override // android.content.DialogInterface.OnCancelListener
            public void onCancel(DialogInterface dialogInterface) {
                WriteVideoActivity.this.destroyWaitingDialog();
                WriteVideoActivity.this.bnK();
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.heD = new b(this);
        setSwipeBackEnabled(false);
        bCr();
        if (this.mData.getVideoInfo() != null) {
            if (!StringUtils.isNull(this.gLp)) {
                VideoTitleData videoTitleData = new VideoTitleData();
                videoTitleData.name = this.gLp;
                this.heD.a(this.mData.getVideoInfo(), videoTitleData, (List<VideoTitleData>) null);
            } else {
                this.heD.a(this.mData.getVideoInfo(), this.mVideoTitleData, this.gLq);
            }
        }
        if (this.heD.bCy() != null) {
            this.heD.bCy().d(this);
        }
        adjustResizeForSoftInput();
        this.heE = new GestureDetector(getPageContext().getPageActivity(), new a());
        this.mInputManager = (InputMethodManager) getSystemService("input_method");
        ShowSoftKeyPadDelay(this.heD.bCA());
        this.heD.bCA().requestFocus();
        TiebaStatic.log(new al("c12307"));
        addGlobalLayoutListener();
        if (ab.aB(getPageContext().getPageActivity())) {
            com.baidu.adp.lib.d.a.eK().a(true, new a.InterfaceC0006a() { // from class: com.baidu.tieba.write.video.WriteVideoActivity.6
                @Override // com.baidu.adp.lib.d.a.InterfaceC0006a
                public void b(int i, String str, Address address) {
                    if (i == 0 && address != null) {
                        WriteVideoActivity.this.mLat = String.valueOf(address.getLatitude());
                        WriteVideoActivity.this.mLng = String.valueOf(address.getLongitude());
                    }
                }
            });
        }
        if (this.mData.getVideoInfo() != null && !StringUtils.isNull(this.mData.getVideoInfo().getVideoPath())) {
            uP(this.mData.getVideoInfo().getVideoPath());
        }
    }

    private void uP(String str) {
        if (f.Bt()) {
            if (this.gzT != null) {
                this.fOK = this.gzT.pO(str);
            }
            if (this.fOK != null) {
                this.fOK.a(this.eRz);
                this.fOK.aRH();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        com.baidu.adp.lib.g.e.fw().postDelayed(this.heG, 500L);
        if (this.heD != null) {
            this.heD.bxC();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onStop() {
        super.onStop();
        if (this.heD != null) {
            this.heD.aqS();
        }
    }

    private void bCr() {
        Intent intent = getIntent();
        if (intent != null) {
            Serializable serializableExtra = intent.getSerializableExtra(WriteVideoActivityConfig.VIDEO_INFO);
            if (serializableExtra instanceof VideoInfo) {
                this.mData.setVideoInfo((VideoInfo) serializableExtra);
            }
            this.bNn = intent.getStringExtra("forum_id");
            this.fkm = intent.getStringExtra("forum_name");
            this.mData.setForumId(this.bNn);
            this.mData.setForumName(this.fkm);
            this.gLp = intent.getStringExtra("video_title");
            if (intent.getSerializableExtra(WriteVideoActivityConfig.FORUM_VIDEO_TITLE) instanceof VideoTitleData) {
                this.mVideoTitleData = (VideoTitleData) intent.getSerializableExtra(WriteVideoActivityConfig.FORUM_VIDEO_TITLE);
            }
            if (intent.getSerializableExtra(WriteVideoActivityConfig.ALL_VIDEO_TITLE) instanceof List) {
                this.gLq = (List) intent.getSerializableExtra(WriteVideoActivityConfig.ALL_VIDEO_TITLE);
            }
            if (!StringUtils.isNull(this.fkm)) {
                this.heD.uS(this.fkm + getResources().getString(d.k.forum));
            } else {
                this.heD.uS(this.fkm);
            }
            this.gLy = intent.getStringExtra("KEY_CALL_FROM");
            if (EditVideoActivityConfig.FROM_TYPE_RECORD_VIDEO_ACTIVITY.equals(intent.getStringExtra("from_type"))) {
                this.heD.bCw();
            }
        }
    }

    private void bCs() {
        if (StringUtils.isNull(this.bNn) || Long.parseLong(this.bNn) <= 0 || StringUtils.isNull(this.fkm)) {
            this.mData.setCanNoForum(true);
        } else {
            this.mData.setCanNoForum(false);
        }
        this.mData.setForumName(this.fkm);
        this.mData.setTitle(this.heD.getContent());
        this.mData.setContent("");
        this.mData.setType(0);
        if (this.heD.bCB() != null) {
            if (this.heD.bCB().getState() == 0) {
                this.mData.setPrivacy(false);
            } else {
                this.mData.setPrivacy(true);
            }
        }
        if (this.heD.bCy() != null) {
            this.mData.setHasLocationData(this.heD.bCy().abo());
        }
        this.mData.setIsNoTitle(TextUtils.isEmpty(this.mData.getTitle()));
    }

    private void Ew() {
        bnK();
        showLoadingDialog();
        this.heH = uQ(this.mData != null ? this.mData.getTitle() : "");
        if (this.aEw == null) {
            this.aEw = new NewWriteModel(this);
        }
        if (!TextUtils.isEmpty(this.gLy)) {
            this.mData.setCallFrom(this.gLy);
        }
        this.mData.setPostLatLng(true);
        this.aEw.setWriteData(this.mData);
        this.aEw.b(this.aEK);
        this.aEw.a(this.gzR);
        if (!TextUtils.isEmpty(this.mLat) && !TextUtils.isEmpty(this.mLng)) {
            this.mData.setLat(this.mLat);
            this.mData.setLng(this.mLng);
            if (f.Bt() && this.fOK != null && !this.heI) {
                com.baidu.adp.lib.g.e.fw().postDelayed(this.heJ, 100L);
            } else {
                this.aEw.startPostWrite();
            }
        } else if (ab.aB(getPageContext().getPageActivity())) {
            com.baidu.adp.lib.d.a.eK().a(true, new a.InterfaceC0006a() { // from class: com.baidu.tieba.write.video.WriteVideoActivity.8
                @Override // com.baidu.adp.lib.d.a.InterfaceC0006a
                public void b(int i, String str, Address address) {
                    if (i == 0 && address != null) {
                        WriteVideoActivity.this.mLat = String.valueOf(address.getLatitude());
                        WriteVideoActivity.this.mLng = String.valueOf(address.getLongitude());
                        WriteVideoActivity.this.mData.setLat(WriteVideoActivity.this.mLat);
                        WriteVideoActivity.this.mData.setLng(WriteVideoActivity.this.mLng);
                    }
                    if (!f.Bt() || WriteVideoActivity.this.fOK == null || WriteVideoActivity.this.heI) {
                        WriteVideoActivity.this.aEw.startPostWrite();
                    } else {
                        com.baidu.adp.lib.g.e.fw().postDelayed(WriteVideoActivity.this.heJ, 100L);
                    }
                }
            });
        } else if (f.Bt() && this.fOK != null && !this.heI) {
            com.baidu.adp.lib.g.e.fw().postDelayed(this.heJ, 100L);
        } else {
            this.aEw.startPostWrite();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ap(Context context, String str) {
        if (context != null) {
            try {
                if (!TextUtils.isEmpty(str)) {
                    new w(context).dY(str);
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
    public void bCt() {
        VideoInfo videoInfo;
        if (this.mData != null && (videoInfo = this.mData.getVideoInfo()) != null && videoInfo.getVideoType() == 2) {
            if ((videoInfo.isCompressedVideo() || videoInfo.getMusicListInfo() != null) && videoInfo.getVideoPath() != null && videoInfo.getVideoPath().contains(com.baidu.tieba.video.b.gJJ)) {
                File file = new File(videoInfo.getVideoPath());
                if (file.exists() && file.isFile()) {
                    if (com.baidu.tbadk.core.sharedPref.b.getInstance().getBoolean("write_video_activity_save_video", true)) {
                        com.baidu.tbadk.core.util.k.Z(file.getAbsolutePath(), com.baidu.tieba.video.b.gJK + file.getName());
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
            if (AntiHelper.tt(postWriteCallBackData.getErrorCode())) {
                AntiHelper.am(getPageContext().getPageActivity(), postWriteCallBackData.getErrorString());
            } else if (postWriteCallBackData.getErrorCode() != 0) {
                String errorString = postWriteCallBackData.getErrorString();
                if (TextUtils.isEmpty(errorString)) {
                    errorString = getPageContext().getPageActivity().getString(d.k.sand_fail);
                }
                showToast(errorString);
            } else {
                com.baidu.tieba.tbadkCore.writeModel.c.e(getPageContext().getPageActivity(), postWriteCallBackData.getErrorString(), postWriteCallBackData.getPreMsg(), postWriteCallBackData.getColorMsg());
            }
        }
    }

    public void showLoadingDialog() {
        this.dpz = new c(getPageContext().getPageActivity());
        this.dpz.setOnCancelListener(this.mDialogCancelListener);
        this.dpz.setCancelable(true);
        this.dpz.setCanceledOnTouchOutside(false);
        g.a(this.dpz, getPageContext().getPageActivity());
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity
    public void finish() {
        bnK();
        destroyWaitingDialog();
        this.mDialogCancelListener = null;
        closeLoadingDialog();
        com.baidu.adp.lib.g.e.fw().removeCallbacks(this.bGI);
        super.finish();
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void destroyWaitingDialog() {
        this.dpz = null;
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
                if (this.heD.bCF() != null) {
                    this.heD.bCF().ax(postWriteCallBackData.getSensitiveWords());
                    if (!v.w(this.heD.bCF().bAU())) {
                        this.heD.ns(true);
                    }
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void i(PostWriteCallBackData postWriteCallBackData) {
        com.baidu.tbadk.util.v.a(new u<Void>() { // from class: com.baidu.tieba.write.video.WriteVideoActivity.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tbadk.util.u
            /* renamed from: Nq */
            public Void doInBackground() {
                File file;
                if (WriteVideoActivity.this.mData != null && WriteVideoActivity.this.mData.getVideoInfo() != null && WriteVideoActivity.this.mData.getVideoInfo().getVideoPath() != null && WriteVideoActivity.this.mData.getVideoInfo().getVideoPath().contains(com.baidu.tieba.video.b.gJJ) && (file = new File(WriteVideoActivity.this.mData.getVideoInfo().getVideoPath())) != null) {
                    com.baidu.tbadk.core.util.k.Z(file.getAbsolutePath(), com.baidu.tieba.video.b.gJK + file.getName());
                }
                com.baidu.tbadk.core.util.k.r(new File(com.baidu.tieba.video.b.gJJ));
                return null;
            }
        }, new h<Void>() { // from class: com.baidu.tieba.write.video.WriteVideoActivity.3
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tbadk.util.h
            /* renamed from: c */
            public void onReturnDataInUI(Void r1) {
            }
        });
        if (!StringUtils.isNull(this.gLp)) {
            postWriteCallBackData.mFrom = 3;
        } else if (!StringUtils.isNull(this.fkm)) {
            postWriteCallBackData.mFrom = 2;
        } else {
            postWriteCallBackData.mFrom = 1;
        }
        postWriteCallBackData.mVideoTitleData = this.heH;
        if (postWriteCallBackData.mFrom == 3 && postWriteCallBackData != null && !StringUtils.isNull(postWriteCallBackData.buildVideoFakeOnWallUrl())) {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921053));
            com.baidu.tbadk.browser.a.f(this, null, postWriteCallBackData.buildVideoFakeOnWallUrl());
        }
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001374, postWriteCallBackData));
        finish();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        this.heD.onChangeSkinType(i);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        if (this.heD != null) {
            this.heD.aqS();
        }
        com.baidu.adp.lib.g.e.fw().removeCallbacks(this.heG);
        com.baidu.adp.lib.g.e.fw().removeCallbacks(this.heJ);
    }

    protected void bnK() {
        if (this.aEw != null) {
            this.aEw.cancelLoadData();
        }
        if (this.heD.bCy() != null) {
            this.heD.bCy().bnK();
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i == 4) {
            if (this.dpz != null && this.dpz.isShowing()) {
                g.b(this.dpz, getPageContext());
                return true;
            }
            bCu();
            return true;
        }
        return super.onKeyDown(i, keyEvent);
    }

    private void bCu() {
        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(getPageContext().getPageActivity());
        aVar.bZ(d.k.give_up_video_confirm);
        aVar.a(d.k.dialog_ok, new a.b() { // from class: com.baidu.tieba.write.video.WriteVideoActivity.4
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                aVar2.dismiss();
                WriteVideoActivity.this.bnK();
                TiebaStatic.log("c10800");
                WriteVideoActivity.this.finish();
            }
        });
        aVar.b(d.k.dialog_cancel, new a.b() { // from class: com.baidu.tieba.write.video.WriteVideoActivity.5
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                aVar2.dismiss();
            }
        });
        aVar.b(getPageContext()).tD();
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.view.View.OnClickListener
    public void onClick(View view2) {
        if (view2 == this.heD.bCz()) {
            if (b.heL - this.heD.bCx() < 0) {
                showToast(getResources().getString(d.k.video_content_overflow));
            } else if (this.heD.bCF() != null && this.heD.bCF().bAW()) {
                showToast(this.heD.bCF().bAY());
                this.heD.ns(true);
            } else {
                bCs();
                Ew();
            }
        } else if (view2 == this.heD.getBackButton()) {
            bCu();
        }
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void closeLoadingDialog() {
        if (this.dpz != null) {
            if (this.dpz.isShowing()) {
                g.b(this.dpz, getPageContext());
            }
            this.dpz = null;
        }
    }

    /* loaded from: classes3.dex */
    private class a extends GestureDetector.SimpleOnGestureListener {
        private a() {
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
        public boolean onFling(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
            l.b(WriteVideoActivity.this.getActivity(), WriteVideoActivity.this.getCurrentFocus());
            return super.onFling(motionEvent, motionEvent2, f, f2);
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity, android.view.Window.Callback
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        if (this.heE.onTouchEvent(motionEvent)) {
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
        this.heD.nt(z);
    }

    public VideoTitleData uQ(String str) {
        if (!StringUtils.isNull(str) && !v.w(this.gLq)) {
            Matcher matcher = Pattern.compile("#(.+)#.*").matcher(str);
            if (matcher.find()) {
                String group = matcher.group(1);
                int i = 0;
                while (true) {
                    int i2 = i;
                    if (i2 >= this.gLq.size()) {
                        break;
                    } else if (this.gLq.get(i2) == null || !group.equals(this.gLq.get(i2).name)) {
                        i = i2 + 1;
                    } else {
                        return this.gLq.get(i2);
                    }
                }
            }
        }
        return null;
    }
}
