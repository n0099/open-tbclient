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
import com.baidu.tbadk.core.util.ac;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.l;
import com.baidu.tbadk.core.util.w;
import com.baidu.tbadk.core.util.x;
import com.baidu.tbadk.coreExtra.data.VideoInfo;
import com.baidu.tbadk.coreExtra.data.WriteData;
import com.baidu.tbadk.coreExtra.data.t;
import com.baidu.tbadk.coreExtra.model.f;
import com.baidu.tbadk.util.h;
import com.baidu.tbadk.util.v;
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
    private NewWriteModel aMT;
    private final NewWriteModel.d aNh;
    private Runnable bQe;
    private String bWd;
    private c dzR;
    private e.a fdV;
    private String fwL;
    private a.InterfaceC0233a gMs;
    private k gMu;
    private String gXR;
    private List<VideoTitleData> gXS;
    private e gaZ;
    private GestureDetector hrA;
    private int hrB;
    private VideoTitleData hrD;
    private boolean hrE;
    private Runnable hrF;
    private b hrz;
    private DialogInterface.OnCancelListener mDialogCancelListener;
    private InputMethodManager mInputManager;
    public String mLat;
    public String mLng;
    private VideoTitleData mVideoTitleData;
    private final WriteData mData = new WriteData();
    private Runnable hrC = new Runnable() { // from class: com.baidu.tieba.write.video.WriteVideoActivity.1
        @Override // java.lang.Runnable
        public void run() {
            Intent intent = new Intent(MotuVideoConfig.ACTION_FINISH_VIDEO_ALL_ACTIVITY);
            intent.setPackage(TbadkCoreApplication.getInst().getPackageName());
            WriteVideoActivity.this.getPageContext().getPageActivity().sendBroadcast(intent);
        }
    };
    private String gYa = "0";

    public WriteVideoActivity() {
        CustomResponsedMessage runTask = MessageManager.getInstance().runTask(2921309, k.class);
        if (runTask != null) {
            this.gMu = (k) runTask.getData();
        }
        this.fdV = new e.a() { // from class: com.baidu.tieba.write.video.WriteVideoActivity.7
            @Override // com.baidu.tieba.j.e.a
            public void pN(int i) {
                if (i != 1) {
                    WriteVideoActivity.this.hrE = true;
                    return;
                }
                am amVar = new am("c12620");
                amVar.r("obj_locate", 0);
                TiebaStatic.log(amVar);
            }

            @Override // com.baidu.tieba.j.e.a
            public void onChange(boolean z) {
            }

            @Override // com.baidu.tieba.j.e.a
            public void iP(boolean z) {
                WriteVideoActivity.this.hrE = true;
                am amVar = new am("c12621");
                amVar.r("obj_locate", 0);
                amVar.r("obj_param1", z ? 1 : 0);
                TiebaStatic.log(amVar);
            }
        };
        this.hrF = new Runnable() { // from class: com.baidu.tieba.write.video.WriteVideoActivity.9
            @Override // java.lang.Runnable
            public void run() {
                if (!f.ES() || WriteVideoActivity.this.gaZ == null || WriteVideoActivity.this.hrE) {
                    if (WriteVideoActivity.this.aMT != null) {
                        WriteVideoActivity.this.aMT.startPostWrite();
                        return;
                    }
                    return;
                }
                com.baidu.adp.lib.g.e.im().postDelayed(WriteVideoActivity.this.hrF, 100L);
            }
        };
        this.aNh = new NewWriteModel.d() { // from class: com.baidu.tieba.write.video.WriteVideoActivity.10
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
                    WriteVideoActivity.this.hrz.bHH();
                    boolean z3 = com.baidu.tbadk.core.sharedPref.b.getInstance().getBoolean("write_video_activity_save_video", true);
                    if (z) {
                        if (WriteVideoActivity.this.mData != null && WriteVideoActivity.this.mData.getVideoInfo() != null) {
                            File file2 = new File(com.baidu.tieba.video.b.gWm);
                            if (!file2.exists()) {
                                file2.mkdirs();
                            }
                            if (z3 && WriteVideoActivity.this.mData.getVideoInfo().getVideoType() == 1) {
                                String str = com.baidu.tieba.video.b.gWm + file.getName();
                                l.ac(new File(WriteVideoActivity.this.mData.getVideoInfo().getVideoPath()).getAbsolutePath(), str);
                                WriteVideoActivity.this.ar(BdBaseApplication.getInst(), str);
                            }
                            WriteVideoActivity.this.bHw();
                            l.r(new File(com.baidu.tieba.video.b.gWl));
                            postWriteCallBackData.mVideoMd5 = WriteVideoActivity.this.mData.getVideoInfo().getVideoMd5();
                        }
                        WriteVideoActivity.this.i(postWriteCallBackData);
                    } else if (postWriteCallBackData != null && postWriteCallBackData.isSensitiveError()) {
                        WriteVideoActivity.this.showToast(postWriteCallBackData.getErrorString());
                        WriteVideoActivity.this.hrz.j(postWriteCallBackData);
                    } else if ((tVar == null || writeData == null || tVar.getVcode_pic_url() == null || AntiHelper.f(antiData)) && postWriteCallBackData != null && postWriteCallBackData.getErrorCode() != 227001) {
                        WriteVideoActivity.this.c(false, postWriteCallBackData);
                    } else if (tVar != null && writeData != null && tVar.getVcode_pic_url() != null) {
                        writeData.setVcodeMD5(tVar.getVcode_md5());
                        writeData.setVcodeUrl(tVar.getVcode_pic_url());
                        writeData.setVcodeExtra(tVar.Ck());
                        if (com.baidu.tbadk.p.a.hM(tVar.Cj())) {
                            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new NewVcodeActivityConfig(WriteVideoActivity.this.getPageContext().getPageActivity(), IEventCenterService.EventId.EventMode.SAPIACCOUNT_FACE_REG, writeData, false, tVar.Cj())));
                        } else {
                            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new VcodeActivityConfig(WriteVideoActivity.this.getPageContext().getPageActivity(), writeData, IEventCenterService.EventId.EventMode.SAPIACCOUNT_FACE_REG)));
                        }
                    } else if (postWriteCallBackData != null && postWriteCallBackData.getErrorCode() == 227001) {
                        MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new AccountAccessActivityConfig(WriteVideoActivity.this.getActivity(), IEventCenterService.EventId.EventMode.SAPIACCOUNT_FACE_REG, writeData, postWriteCallBackData.getAccessState())));
                    }
                }
            }
        };
        this.bQe = new Runnable() { // from class: com.baidu.tieba.write.video.WriteVideoActivity.11
            @Override // java.lang.Runnable
            public void run() {
                if (WriteVideoActivity.this.dzR != null) {
                    WriteVideoActivity.this.dzR.setPercent(WriteVideoActivity.this.hrB);
                }
            }
        };
        this.gMs = new a.InterfaceC0233a() { // from class: com.baidu.tieba.write.video.WriteVideoActivity.12
            @Override // com.baidu.tieba.tbadkCore.c.a.InterfaceC0233a
            public void onUploadProgress(int i) {
                WriteVideoActivity.this.hrB = i;
                com.baidu.adp.lib.g.e.im().post(WriteVideoActivity.this.bQe);
            }
        };
        this.mDialogCancelListener = new DialogInterface.OnCancelListener() { // from class: com.baidu.tieba.write.video.WriteVideoActivity.13
            @Override // android.content.DialogInterface.OnCancelListener
            public void onCancel(DialogInterface dialogInterface) {
                WriteVideoActivity.this.destroyWaitingDialog();
                WriteVideoActivity.this.bsI();
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.hrz = new b(this);
        setSwipeBackEnabled(false);
        bHu();
        if (this.mData.getVideoInfo() != null) {
            if (!StringUtils.isNull(this.gXR)) {
                VideoTitleData videoTitleData = new VideoTitleData();
                videoTitleData.name = this.gXR;
                this.hrz.a(this.mData.getVideoInfo(), videoTitleData, (List<VideoTitleData>) null);
            } else {
                this.hrz.a(this.mData.getVideoInfo(), this.mVideoTitleData, this.gXS);
            }
        }
        if (this.hrz.bHB() != null) {
            this.hrz.bHB().d(this);
        }
        adjustResizeForSoftInput();
        this.hrA = new GestureDetector(getPageContext().getPageActivity(), new a());
        this.mInputManager = (InputMethodManager) getSystemService("input_method");
        ShowSoftKeyPadDelay(this.hrz.bHD());
        this.hrz.bHD().requestFocus();
        TiebaStatic.log(new am("c12307"));
        addGlobalLayoutListener();
        if (ac.aL(getPageContext().getPageActivity())) {
            com.baidu.adp.lib.d.a.hB().a(true, new a.InterfaceC0014a() { // from class: com.baidu.tieba.write.video.WriteVideoActivity.6
                @Override // com.baidu.adp.lib.d.a.InterfaceC0014a
                public void b(int i, String str, Address address) {
                    if (i == 0 && address != null) {
                        WriteVideoActivity.this.mLat = String.valueOf(address.getLatitude());
                        WriteVideoActivity.this.mLng = String.valueOf(address.getLongitude());
                    }
                }
            });
        }
        if (this.mData.getVideoInfo() != null && !StringUtils.isNull(this.mData.getVideoInfo().getVideoPath())) {
            vM(this.mData.getVideoInfo().getVideoPath());
        }
    }

    private void vM(String str) {
        if (f.ES()) {
            if (this.gMu != null) {
                this.gaZ = this.gMu.qF(str);
            }
            if (this.gaZ != null) {
                this.gaZ.a(this.fdV);
                this.gaZ.aWE();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        com.baidu.adp.lib.g.e.im().postDelayed(this.hrC, 500L);
        if (this.hrz != null) {
            this.hrz.bCH();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onStop() {
        super.onStop();
        if (this.hrz != null) {
            this.hrz.auW();
        }
    }

    private void bHu() {
        Intent intent = getIntent();
        if (intent != null) {
            Serializable serializableExtra = intent.getSerializableExtra(WriteVideoActivityConfig.VIDEO_INFO);
            if (serializableExtra instanceof VideoInfo) {
                this.mData.setVideoInfo((VideoInfo) serializableExtra);
            }
            this.bWd = intent.getStringExtra("forum_id");
            this.fwL = intent.getStringExtra("forum_name");
            this.mData.setForumId(this.bWd);
            this.mData.setForumName(this.fwL);
            this.gXR = intent.getStringExtra("video_title");
            if (intent.getSerializableExtra(WriteVideoActivityConfig.FORUM_VIDEO_TITLE) instanceof VideoTitleData) {
                this.mVideoTitleData = (VideoTitleData) intent.getSerializableExtra(WriteVideoActivityConfig.FORUM_VIDEO_TITLE);
            }
            if (intent.getSerializableExtra(WriteVideoActivityConfig.ALL_VIDEO_TITLE) instanceof List) {
                this.gXS = (List) intent.getSerializableExtra(WriteVideoActivityConfig.ALL_VIDEO_TITLE);
            }
            if (!StringUtils.isNull(this.fwL)) {
                this.hrz.vP(this.fwL + getResources().getString(d.k.forum));
            } else {
                this.hrz.vP(this.fwL);
            }
            this.gYa = intent.getStringExtra("KEY_CALL_FROM");
            if (EditVideoActivityConfig.FROM_TYPE_RECORD_VIDEO_ACTIVITY.equals(intent.getStringExtra("from_type"))) {
                this.hrz.bHz();
            }
        }
    }

    private void bHv() {
        if (StringUtils.isNull(this.bWd) || Long.parseLong(this.bWd) <= 0 || StringUtils.isNull(this.fwL)) {
            this.mData.setCanNoForum(true);
        } else {
            this.mData.setCanNoForum(false);
        }
        this.mData.setForumName(this.fwL);
        this.mData.setTitle(this.hrz.getContent());
        this.mData.setContent("");
        this.mData.setType(0);
        if (this.hrz.bHE() != null) {
            if (this.hrz.bHE().getState() == 0) {
                this.mData.setPrivacy(false);
            } else {
                this.mData.setPrivacy(true);
            }
        }
        if (this.hrz.bHB() != null) {
            this.mData.setHasLocationData(this.hrz.bHB().aeO());
        }
        this.mData.setIsNoTitle(TextUtils.isEmpty(this.mData.getTitle()));
    }

    private void HY() {
        bsI();
        showLoadingDialog();
        this.hrD = vN(this.mData != null ? this.mData.getTitle() : "");
        if (this.aMT == null) {
            this.aMT = new NewWriteModel(this);
        }
        if (!TextUtils.isEmpty(this.gYa)) {
            this.mData.setCallFrom(this.gYa);
        }
        this.mData.setPostLatLng(true);
        this.aMT.setWriteData(this.mData);
        this.aMT.b(this.aNh);
        this.aMT.a(this.gMs);
        if (!TextUtils.isEmpty(this.mLat) && !TextUtils.isEmpty(this.mLng)) {
            this.mData.setLat(this.mLat);
            this.mData.setLng(this.mLng);
            if (f.ES() && this.gaZ != null && !this.hrE) {
                com.baidu.adp.lib.g.e.im().postDelayed(this.hrF, 100L);
            } else {
                this.aMT.startPostWrite();
            }
        } else if (ac.aL(getPageContext().getPageActivity())) {
            com.baidu.adp.lib.d.a.hB().a(true, new a.InterfaceC0014a() { // from class: com.baidu.tieba.write.video.WriteVideoActivity.8
                @Override // com.baidu.adp.lib.d.a.InterfaceC0014a
                public void b(int i, String str, Address address) {
                    if (i == 0 && address != null) {
                        WriteVideoActivity.this.mLat = String.valueOf(address.getLatitude());
                        WriteVideoActivity.this.mLng = String.valueOf(address.getLongitude());
                        WriteVideoActivity.this.mData.setLat(WriteVideoActivity.this.mLat);
                        WriteVideoActivity.this.mData.setLng(WriteVideoActivity.this.mLng);
                    }
                    if (!f.ES() || WriteVideoActivity.this.gaZ == null || WriteVideoActivity.this.hrE) {
                        WriteVideoActivity.this.aMT.startPostWrite();
                    } else {
                        com.baidu.adp.lib.g.e.im().postDelayed(WriteVideoActivity.this.hrF, 100L);
                    }
                }
            });
        } else if (f.ES() && this.gaZ != null && !this.hrE) {
            com.baidu.adp.lib.g.e.im().postDelayed(this.hrF, 100L);
        } else {
            this.aMT.startPostWrite();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ar(Context context, String str) {
        if (context != null) {
            try {
                if (!TextUtils.isEmpty(str)) {
                    new x(context).ey(str);
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
    public void bHw() {
        VideoInfo videoInfo;
        if (this.mData != null && (videoInfo = this.mData.getVideoInfo()) != null && videoInfo.getVideoType() == 2) {
            if ((videoInfo.isCompressedVideo() || videoInfo.getMusicListInfo() != null) && videoInfo.getVideoPath() != null && videoInfo.getVideoPath().contains(com.baidu.tieba.video.b.gWl)) {
                File file = new File(videoInfo.getVideoPath());
                if (file.exists() && file.isFile()) {
                    if (com.baidu.tbadk.core.sharedPref.b.getInstance().getBoolean("write_video_activity_save_video", true)) {
                        l.ac(file.getAbsolutePath(), com.baidu.tieba.video.b.gWm + file.getName());
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
            if (AntiHelper.tE(postWriteCallBackData.getErrorCode())) {
                AntiHelper.ao(getPageContext().getPageActivity(), postWriteCallBackData.getErrorString());
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
        this.dzR = new c(getPageContext().getPageActivity());
        this.dzR.setOnCancelListener(this.mDialogCancelListener);
        this.dzR.setCancelable(true);
        this.dzR.setCanceledOnTouchOutside(false);
        g.a(this.dzR, getPageContext().getPageActivity());
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity
    public void finish() {
        bsI();
        destroyWaitingDialog();
        this.mDialogCancelListener = null;
        closeLoadingDialog();
        com.baidu.adp.lib.g.e.im().removeCallbacks(this.bQe);
        super.finish();
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void destroyWaitingDialog() {
        this.dzR = null;
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
                if (this.hrz.bHI() != null) {
                    this.hrz.bHI().ax(postWriteCallBackData.getSensitiveWords());
                    if (!w.z(this.hrz.bHI().bFY())) {
                        this.hrz.nB(true);
                    }
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void i(PostWriteCallBackData postWriteCallBackData) {
        com.baidu.tbadk.util.w.a(new v<Void>() { // from class: com.baidu.tieba.write.video.WriteVideoActivity.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tbadk.util.v
            /* renamed from: QO */
            public Void doInBackground() {
                File file;
                if (WriteVideoActivity.this.mData != null && WriteVideoActivity.this.mData.getVideoInfo() != null && WriteVideoActivity.this.mData.getVideoInfo().getVideoPath() != null && WriteVideoActivity.this.mData.getVideoInfo().getVideoPath().contains(com.baidu.tieba.video.b.gWl) && (file = new File(WriteVideoActivity.this.mData.getVideoInfo().getVideoPath())) != null) {
                    l.ac(file.getAbsolutePath(), com.baidu.tieba.video.b.gWm + file.getName());
                }
                l.r(new File(com.baidu.tieba.video.b.gWl));
                return null;
            }
        }, new h<Void>() { // from class: com.baidu.tieba.write.video.WriteVideoActivity.3
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tbadk.util.h
            /* renamed from: a */
            public void onReturnDataInUI(Void r1) {
            }
        });
        if (!StringUtils.isNull(this.gXR)) {
            postWriteCallBackData.mFrom = 3;
        } else if (!StringUtils.isNull(this.fwL)) {
            postWriteCallBackData.mFrom = 2;
        } else {
            postWriteCallBackData.mFrom = 1;
        }
        postWriteCallBackData.mVideoTitleData = this.hrD;
        if (postWriteCallBackData.mFrom == 3 && postWriteCallBackData != null && !StringUtils.isNull(postWriteCallBackData.buildVideoFakeOnWallUrl())) {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921053));
            com.baidu.tbadk.browser.a.g(this, null, postWriteCallBackData.buildVideoFakeOnWallUrl());
        }
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001374, postWriteCallBackData));
        finish();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        this.hrz.onChangeSkinType(i);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        if (this.hrz != null) {
            this.hrz.auW();
        }
        com.baidu.adp.lib.g.e.im().removeCallbacks(this.hrC);
        com.baidu.adp.lib.g.e.im().removeCallbacks(this.hrF);
    }

    protected void bsI() {
        if (this.aMT != null) {
            this.aMT.cancelLoadData();
        }
        if (this.hrz.bHB() != null) {
            this.hrz.bHB().bsI();
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i == 4) {
            if (this.dzR != null && this.dzR.isShowing()) {
                g.b(this.dzR, getPageContext());
                return true;
            }
            bHx();
            return true;
        }
        return super.onKeyDown(i, keyEvent);
    }

    private void bHx() {
        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(getPageContext().getPageActivity());
        aVar.cc(d.k.give_up_video_confirm);
        aVar.a(d.k.dialog_ok, new a.b() { // from class: com.baidu.tieba.write.video.WriteVideoActivity.4
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                aVar2.dismiss();
                WriteVideoActivity.this.bsI();
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
        aVar.b(getPageContext()).xa();
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.hrz.bHC()) {
            if (b.hrH - this.hrz.bHA() < 0) {
                showToast(getResources().getString(d.k.video_content_overflow));
            } else if (this.hrz.bHI() != null && this.hrz.bHI().bGa()) {
                showToast(this.hrz.bHI().bGc());
                this.hrz.nB(true);
            } else {
                bHv();
                HY();
            }
        } else if (view == this.hrz.getBackButton()) {
            bHx();
        }
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void closeLoadingDialog() {
        if (this.dzR != null) {
            if (this.dzR.isShowing()) {
                g.b(this.dzR, getPageContext());
            }
            this.dzR = null;
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
        if (this.hrA.onTouchEvent(motionEvent)) {
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
        this.hrz.nC(z);
    }

    public VideoTitleData vN(String str) {
        if (!StringUtils.isNull(str) && !w.z(this.gXS)) {
            Matcher matcher = Pattern.compile("#(.+)#.*").matcher(str);
            if (matcher.find()) {
                String group = matcher.group(1);
                int i = 0;
                while (true) {
                    int i2 = i;
                    if (i2 >= this.gXS.size()) {
                        break;
                    } else if (this.gXS.get(i2) == null || !group.equals(this.gXS.get(i2).name)) {
                        i = i2 + 1;
                    } else {
                        return this.gXS.get(i2);
                    }
                }
            }
        }
        return null;
    }
}
