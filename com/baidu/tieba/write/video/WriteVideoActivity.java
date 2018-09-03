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
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.core.util.w;
import com.baidu.tbadk.core.util.x;
import com.baidu.tbadk.coreExtra.data.VideoInfo;
import com.baidu.tbadk.coreExtra.data.WriteData;
import com.baidu.tbadk.coreExtra.data.u;
import com.baidu.tbadk.coreExtra.model.f;
import com.baidu.tbadk.util.v;
import com.baidu.tieba.f;
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
    private NewWriteModel aNL;
    private final NewWriteModel.d aNZ;
    private Runnable bTh;
    private c dFL;
    private String fAS;
    private e.a fhS;
    private a.InterfaceC0235a gRt;
    private l gRv;
    private e gfz;
    private String hdk;
    private List<VideoTitleData> hdl;
    private b hwQ;
    private GestureDetector hwR;
    private int hwS;
    private VideoTitleData hwU;
    private boolean hwV;
    private Runnable hwW;
    private DialogInterface.OnCancelListener mDialogCancelListener;
    private String mFromForumId;
    private InputMethodManager mInputManager;
    public String mLat;
    public String mLng;
    private VideoTitleData mVideoTitleData;
    private final WriteData mData = new WriteData();
    private Runnable hwT = new Runnable() { // from class: com.baidu.tieba.write.video.WriteVideoActivity.1
        @Override // java.lang.Runnable
        public void run() {
            Intent intent = new Intent(MotuVideoConfig.ACTION_FINISH_VIDEO_ALL_ACTIVITY);
            intent.setPackage(TbadkCoreApplication.getInst().getPackageName());
            WriteVideoActivity.this.getPageContext().getPageActivity().sendBroadcast(intent);
        }
    };
    private String dHS = "0";

    public WriteVideoActivity() {
        CustomResponsedMessage runTask = MessageManager.getInstance().runTask(2921309, l.class);
        if (runTask != null) {
            this.gRv = (l) runTask.getData();
        }
        this.fhS = new e.a() { // from class: com.baidu.tieba.write.video.WriteVideoActivity.7
            @Override // com.baidu.tieba.j.e.a
            public void pR(int i) {
                if (i != 1) {
                    WriteVideoActivity.this.hwV = true;
                    return;
                }
                an anVar = new an("c12620");
                anVar.r("obj_locate", 0);
                TiebaStatic.log(anVar);
            }

            @Override // com.baidu.tieba.j.e.a
            public void onChange(boolean z) {
            }

            @Override // com.baidu.tieba.j.e.a
            public void iL(boolean z) {
                WriteVideoActivity.this.hwV = true;
                an anVar = new an("c12621");
                anVar.r("obj_locate", 0);
                anVar.r("obj_param1", z ? 1 : 0);
                TiebaStatic.log(anVar);
            }
        };
        this.hwW = new Runnable() { // from class: com.baidu.tieba.write.video.WriteVideoActivity.9
            @Override // java.lang.Runnable
            public void run() {
                if (!f.Fg() || WriteVideoActivity.this.gfz == null || WriteVideoActivity.this.hwV) {
                    if (WriteVideoActivity.this.aNL != null) {
                        WriteVideoActivity.this.aNL.startPostWrite();
                        return;
                    }
                    return;
                }
                com.baidu.adp.lib.g.e.in().postDelayed(WriteVideoActivity.this.hwW, 100L);
            }
        };
        this.aNZ = new NewWriteModel.d() { // from class: com.baidu.tieba.write.video.WriteVideoActivity.10
            @Override // com.baidu.tieba.tbadkCore.writeModel.NewWriteModel.d
            public void callback(boolean z, PostWriteCallBackData postWriteCallBackData, u uVar, WriteData writeData, AntiData antiData) {
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
                    WriteVideoActivity.this.hwQ.bGX();
                    boolean z3 = com.baidu.tbadk.core.sharedPref.b.getInstance().getBoolean("write_video_activity_save_video", true);
                    if (z) {
                        if (WriteVideoActivity.this.mData != null && WriteVideoActivity.this.mData.getVideoInfo() != null) {
                            File file2 = new File(com.baidu.tieba.video.c.hbF);
                            if (!file2.exists()) {
                                file2.mkdirs();
                            }
                            if (z3 && WriteVideoActivity.this.mData.getVideoInfo().getVideoType() == 1) {
                                String str = com.baidu.tieba.video.c.hbF + file.getName();
                                com.baidu.tbadk.core.util.l.ab(new File(WriteVideoActivity.this.mData.getVideoInfo().getVideoPath()).getAbsolutePath(), str);
                                WriteVideoActivity.this.at(BdBaseApplication.getInst(), str);
                            }
                            WriteVideoActivity.this.bGM();
                            com.baidu.tbadk.core.util.l.r(new File(com.baidu.tieba.video.c.hbE));
                            postWriteCallBackData.mVideoMd5 = WriteVideoActivity.this.mData.getVideoInfo().getVideoMd5();
                        }
                        WriteVideoActivity.this.i(postWriteCallBackData);
                    } else if (postWriteCallBackData != null && postWriteCallBackData.isSensitiveError()) {
                        WriteVideoActivity.this.showToast(postWriteCallBackData.getErrorString());
                        WriteVideoActivity.this.hwQ.j(postWriteCallBackData);
                    } else if ((uVar == null || writeData == null || uVar.getVcode_pic_url() == null || AntiHelper.f(antiData)) && postWriteCallBackData != null && postWriteCallBackData.getErrorCode() != 227001) {
                        WriteVideoActivity.this.c(false, postWriteCallBackData);
                    } else if (uVar != null && writeData != null && uVar.getVcode_pic_url() != null) {
                        writeData.setVcodeMD5(uVar.getVcode_md5());
                        writeData.setVcodeUrl(uVar.getVcode_pic_url());
                        writeData.setVcodeExtra(uVar.Cs());
                        if (com.baidu.tbadk.q.a.hN(uVar.Cr())) {
                            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new NewVcodeActivityConfig(WriteVideoActivity.this.getPageContext().getPageActivity(), IEventCenterService.EventId.EventMode.SAPIACCOUNT_FACE_REG, writeData, false, uVar.Cr())));
                        } else {
                            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new VcodeActivityConfig(WriteVideoActivity.this.getPageContext().getPageActivity(), writeData, IEventCenterService.EventId.EventMode.SAPIACCOUNT_FACE_REG)));
                        }
                    } else if (postWriteCallBackData != null && postWriteCallBackData.getErrorCode() == 227001) {
                        MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new AccountAccessActivityConfig(WriteVideoActivity.this.getActivity(), IEventCenterService.EventId.EventMode.SAPIACCOUNT_FACE_REG, writeData, postWriteCallBackData.getAccessState())));
                    }
                }
            }
        };
        this.bTh = new Runnable() { // from class: com.baidu.tieba.write.video.WriteVideoActivity.11
            @Override // java.lang.Runnable
            public void run() {
                if (WriteVideoActivity.this.dFL != null) {
                    WriteVideoActivity.this.dFL.setPercent(WriteVideoActivity.this.hwS);
                }
            }
        };
        this.gRt = new a.InterfaceC0235a() { // from class: com.baidu.tieba.write.video.WriteVideoActivity.12
            @Override // com.baidu.tieba.tbadkCore.c.a.InterfaceC0235a
            public void onUploadProgress(int i) {
                WriteVideoActivity.this.hwS = i;
                com.baidu.adp.lib.g.e.in().post(WriteVideoActivity.this.bTh);
            }
        };
        this.mDialogCancelListener = new DialogInterface.OnCancelListener() { // from class: com.baidu.tieba.write.video.WriteVideoActivity.13
            @Override // android.content.DialogInterface.OnCancelListener
            public void onCancel(DialogInterface dialogInterface) {
                WriteVideoActivity.this.destroyWaitingDialog();
                WriteVideoActivity.this.brM();
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.hwQ = new b(this);
        setSwipeBackEnabled(false);
        bGK();
        if (this.mData.getVideoInfo() != null) {
            if (!StringUtils.isNull(this.hdk)) {
                VideoTitleData videoTitleData = new VideoTitleData();
                videoTitleData.name = this.hdk;
                this.hwQ.a(this.mData.getVideoInfo(), videoTitleData, (List<VideoTitleData>) null);
            } else {
                this.hwQ.a(this.mData.getVideoInfo(), this.mVideoTitleData, this.hdl);
            }
        }
        if (this.hwQ.bGR() != null) {
            this.hwQ.bGR().d(this);
        }
        adjustResizeForSoftInput();
        this.hwR = new GestureDetector(getPageContext().getPageActivity(), new a());
        this.mInputManager = (InputMethodManager) getSystemService("input_method");
        ShowSoftKeyPadDelay(this.hwQ.bGT());
        this.hwQ.bGT().requestFocus();
        TiebaStatic.log(new an("c12307"));
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
            vN(this.mData.getVideoInfo().getVideoPath());
        }
    }

    private void vN(String str) {
        if (f.Fg()) {
            if (this.gRv != null) {
                this.gfz = this.gRv.qB(str);
            }
            if (this.gfz != null) {
                this.gfz.a(this.fhS);
                this.gfz.aVA();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        com.baidu.adp.lib.g.e.in().postDelayed(this.hwT, 500L);
        if (this.hwQ != null) {
            this.hwQ.bBU();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onStop() {
        super.onStop();
        if (this.hwQ != null) {
            this.hwQ.awe();
        }
    }

    private void bGK() {
        Intent intent = getIntent();
        if (intent != null) {
            Serializable serializableExtra = intent.getSerializableExtra(WriteVideoActivityConfig.VIDEO_INFO);
            if (serializableExtra instanceof VideoInfo) {
                this.mData.setVideoInfo((VideoInfo) serializableExtra);
            }
            this.mFromForumId = intent.getStringExtra("forum_id");
            this.fAS = intent.getStringExtra("forum_name");
            this.mData.setForumId(this.mFromForumId);
            this.mData.setForumName(this.fAS);
            this.hdk = intent.getStringExtra("video_title");
            if (intent.getSerializableExtra(WriteVideoActivityConfig.FORUM_VIDEO_TITLE) instanceof VideoTitleData) {
                this.mVideoTitleData = (VideoTitleData) intent.getSerializableExtra(WriteVideoActivityConfig.FORUM_VIDEO_TITLE);
            }
            if (intent.getSerializableExtra(WriteVideoActivityConfig.ALL_VIDEO_TITLE) instanceof List) {
                this.hdl = (List) intent.getSerializableExtra(WriteVideoActivityConfig.ALL_VIDEO_TITLE);
            }
            if (!StringUtils.isNull(this.fAS)) {
                this.hwQ.vQ(this.fAS + getResources().getString(f.j.forum));
            } else {
                this.hwQ.vQ(this.fAS);
            }
            this.dHS = intent.getStringExtra("KEY_CALL_FROM");
            if (EditVideoActivityConfig.FROM_TYPE_RECORD_VIDEO_ACTIVITY.equals(intent.getStringExtra("from_type"))) {
                this.hwQ.bGP();
            }
        }
    }

    private void bGL() {
        if (StringUtils.isNull(this.mFromForumId) || Long.parseLong(this.mFromForumId) <= 0 || StringUtils.isNull(this.fAS)) {
            this.mData.setCanNoForum(true);
        } else {
            this.mData.setCanNoForum(false);
        }
        this.mData.setForumName(this.fAS);
        this.mData.setTitle(this.hwQ.getContent());
        this.mData.setContent("");
        this.mData.setType(0);
        if (this.hwQ.bGU() != null) {
            if (this.hwQ.bGU().getState() == 0) {
                this.mData.setPrivacy(false);
            } else {
                this.mData.setPrivacy(true);
            }
        }
        if (this.hwQ.bGR() != null) {
            this.mData.setHasLocationData(this.hwQ.bGR().afS());
        }
        this.mData.setIsNoTitle(TextUtils.isEmpty(this.mData.getTitle()));
    }

    private void Il() {
        brM();
        showLoadingDialog();
        this.hwU = vO(this.mData != null ? this.mData.getTitle() : "");
        if (this.aNL == null) {
            this.aNL = new NewWriteModel(this);
        }
        if (!TextUtils.isEmpty(this.dHS)) {
            this.mData.setCallFrom(this.dHS);
        }
        this.mData.setPostLatLng(true);
        this.aNL.setWriteData(this.mData);
        this.aNL.b(this.aNZ);
        this.aNL.a(this.gRt);
        if (!TextUtils.isEmpty(this.mLat) && !TextUtils.isEmpty(this.mLng)) {
            this.mData.setLat(this.mLat);
            this.mData.setLng(this.mLng);
            if (com.baidu.tbadk.coreExtra.model.f.Fg() && this.gfz != null && !this.hwV) {
                com.baidu.adp.lib.g.e.in().postDelayed(this.hwW, 100L);
            } else {
                this.aNL.startPostWrite();
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
                    if (!com.baidu.tbadk.coreExtra.model.f.Fg() || WriteVideoActivity.this.gfz == null || WriteVideoActivity.this.hwV) {
                        WriteVideoActivity.this.aNL.startPostWrite();
                    } else {
                        com.baidu.adp.lib.g.e.in().postDelayed(WriteVideoActivity.this.hwW, 100L);
                    }
                }
            });
        } else if (com.baidu.tbadk.coreExtra.model.f.Fg() && this.gfz != null && !this.hwV) {
            com.baidu.adp.lib.g.e.in().postDelayed(this.hwW, 100L);
        } else {
            this.aNL.startPostWrite();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void at(Context context, String str) {
        if (context != null) {
            try {
                if (!TextUtils.isEmpty(str)) {
                    new x(context).ez(str);
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
    public void bGM() {
        VideoInfo videoInfo;
        if (this.mData != null && (videoInfo = this.mData.getVideoInfo()) != null && videoInfo.getVideoType() == 2) {
            if ((videoInfo.isCompressedVideo() || videoInfo.getMusicListInfo() != null) && videoInfo.getVideoPath() != null && videoInfo.getVideoPath().contains(com.baidu.tieba.video.c.hbE)) {
                File file = new File(videoInfo.getVideoPath());
                if (file.exists() && file.isFile()) {
                    if (com.baidu.tbadk.core.sharedPref.b.getInstance().getBoolean("write_video_activity_save_video", true)) {
                        com.baidu.tbadk.core.util.l.ab(file.getAbsolutePath(), com.baidu.tieba.video.c.hbF + file.getName());
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
            if (AntiHelper.al(postWriteCallBackData.getErrorCode(), postWriteCallBackData.getErrorString())) {
                AntiHelper.aq(getPageContext().getPageActivity(), postWriteCallBackData.getErrorString());
            } else if (postWriteCallBackData.getErrorCode() != 0) {
                String errorString = postWriteCallBackData.getErrorString();
                if (TextUtils.isEmpty(errorString)) {
                    errorString = getPageContext().getPageActivity().getString(f.j.sand_fail);
                }
                showToast(errorString);
            } else {
                com.baidu.tieba.tbadkCore.writeModel.c.e(getPageContext().getPageActivity(), postWriteCallBackData.getErrorString(), postWriteCallBackData.getPreMsg(), postWriteCallBackData.getColorMsg());
            }
        }
    }

    public void showLoadingDialog() {
        this.dFL = new c(getPageContext().getPageActivity());
        this.dFL.setOnCancelListener(this.mDialogCancelListener);
        this.dFL.setCancelable(true);
        this.dFL.setCanceledOnTouchOutside(false);
        g.a(this.dFL, getPageContext().getPageActivity());
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity
    public void finish() {
        brM();
        destroyWaitingDialog();
        this.mDialogCancelListener = null;
        closeLoadingDialog();
        com.baidu.adp.lib.g.e.in().removeCallbacks(this.bTh);
        super.finish();
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void destroyWaitingDialog() {
        this.dFL = null;
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
                if (this.hwQ.bGY() != null) {
                    this.hwQ.bGY().az(postWriteCallBackData.getSensitiveWords());
                    if (!w.z(this.hwQ.bGY().bFn())) {
                        this.hwQ.nx(true);
                    }
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void i(PostWriteCallBackData postWriteCallBackData) {
        v.a(new com.baidu.tbadk.util.u<Void>() { // from class: com.baidu.tieba.write.video.WriteVideoActivity.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tbadk.util.u
            /* renamed from: Rx */
            public Void doInBackground() {
                File file;
                if (WriteVideoActivity.this.mData != null && WriteVideoActivity.this.mData.getVideoInfo() != null && WriteVideoActivity.this.mData.getVideoInfo().getVideoPath() != null && WriteVideoActivity.this.mData.getVideoInfo().getVideoPath().contains(com.baidu.tieba.video.c.hbE) && (file = new File(WriteVideoActivity.this.mData.getVideoInfo().getVideoPath())) != null) {
                    com.baidu.tbadk.core.util.l.ab(file.getAbsolutePath(), com.baidu.tieba.video.c.hbF + file.getName());
                }
                com.baidu.tbadk.core.util.l.r(new File(com.baidu.tieba.video.c.hbE));
                return null;
            }
        }, new com.baidu.tbadk.util.g<Void>() { // from class: com.baidu.tieba.write.video.WriteVideoActivity.3
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tbadk.util.g
            /* renamed from: a */
            public void onReturnDataInUI(Void r1) {
            }
        });
        if (!StringUtils.isNull(this.hdk)) {
            postWriteCallBackData.mFrom = 3;
        } else if (!StringUtils.isNull(this.fAS)) {
            postWriteCallBackData.mFrom = 2;
        } else {
            postWriteCallBackData.mFrom = 1;
        }
        postWriteCallBackData.mVideoTitleData = this.hwU;
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
        this.hwQ.onChangeSkinType(i);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        if (this.hwQ != null) {
            this.hwQ.awe();
        }
        com.baidu.adp.lib.g.e.in().removeCallbacks(this.hwT);
        com.baidu.adp.lib.g.e.in().removeCallbacks(this.hwW);
    }

    protected void brM() {
        if (this.aNL != null) {
            this.aNL.cancelLoadData();
        }
        if (this.hwQ.bGR() != null) {
            this.hwQ.bGR().brM();
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i == 4) {
            if (this.dFL != null && this.dFL.isShowing()) {
                g.b(this.dFL, getPageContext());
                return true;
            }
            bGN();
            return true;
        }
        return super.onKeyDown(i, keyEvent);
    }

    private void bGN() {
        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(getPageContext().getPageActivity());
        aVar.cf(f.j.give_up_video_confirm);
        aVar.a(f.j.dialog_ok, new a.b() { // from class: com.baidu.tieba.write.video.WriteVideoActivity.4
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                aVar2.dismiss();
                WriteVideoActivity.this.brM();
                TiebaStatic.log("c10800");
                WriteVideoActivity.this.finish();
            }
        });
        aVar.b(f.j.dialog_cancel, new a.b() { // from class: com.baidu.tieba.write.video.WriteVideoActivity.5
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                aVar2.dismiss();
            }
        });
        aVar.b(getPageContext()).xe();
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.hwQ.bGS()) {
            if (b.hwY - this.hwQ.bGQ() < 0) {
                showToast(getResources().getString(f.j.video_content_overflow));
            } else if (this.hwQ.bGY() != null && this.hwQ.bGY().bFp()) {
                showToast(this.hwQ.bGY().bFr());
                this.hwQ.nx(true);
            } else {
                bGL();
                Il();
            }
        } else if (view == this.hwQ.getBackButton()) {
            bGN();
        }
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void closeLoadingDialog() {
        if (this.dFL != null) {
            if (this.dFL.isShowing()) {
                g.b(this.dFL, getPageContext());
            }
            this.dFL = null;
        }
    }

    /* loaded from: classes3.dex */
    private class a extends GestureDetector.SimpleOnGestureListener {
        private a() {
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
        public boolean onFling(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
            com.baidu.adp.lib.util.l.a(WriteVideoActivity.this.getActivity(), WriteVideoActivity.this.getCurrentFocus());
            return super.onFling(motionEvent, motionEvent2, f, f2);
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity, android.view.Window.Callback
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        if (this.hwR.onTouchEvent(motionEvent)) {
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
        this.hwQ.ny(z);
    }

    public VideoTitleData vO(String str) {
        if (!StringUtils.isNull(str) && !w.z(this.hdl)) {
            Matcher matcher = Pattern.compile("#(.+)#.*").matcher(str);
            if (matcher.find()) {
                String group = matcher.group(1);
                int i = 0;
                while (true) {
                    int i2 = i;
                    if (i2 >= this.hdl.size()) {
                        break;
                    } else if (this.hdl.get(i2) == null || !group.equals(this.hdl.get(i2).name)) {
                        i = i2 + 1;
                    } else {
                        return this.hdl.get(i2);
                    }
                }
            }
        }
        return null;
    }
}
