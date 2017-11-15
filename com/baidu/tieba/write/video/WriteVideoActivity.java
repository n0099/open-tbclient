package com.baidu.tieba.write.video;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.GestureDetector;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.g.e;
import com.baidu.adp.lib.g.g;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.lib.util.j;
import com.baidu.adp.lib.util.l;
import com.baidu.tbadk.ActivityPendingTransitionFactory;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.AccountAccessActivityConfig;
import com.baidu.tbadk.core.atomData.MotuVideoConfig;
import com.baidu.tbadk.core.atomData.NewVcodeActivityConfig;
import com.baidu.tbadk.core.atomData.VcodeActivityConfig;
import com.baidu.tbadk.core.atomData.WriteActivityConfig;
import com.baidu.tbadk.core.atomData.WriteVideoActivityConfig;
import com.baidu.tbadk.core.data.AntiData;
import com.baidu.tbadk.core.dialog.a;
import com.baidu.tbadk.core.dialog.c;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.ak;
import com.baidu.tbadk.core.util.k;
import com.baidu.tbadk.core.util.v;
import com.baidu.tbadk.coreExtra.c.f;
import com.baidu.tbadk.coreExtra.data.VideoInfo;
import com.baidu.tbadk.coreExtra.data.WriteData;
import com.baidu.tbadk.coreExtra.data.r;
import com.baidu.tbadk.util.h;
import com.baidu.tbadk.util.u;
import com.baidu.tieba.d;
import com.baidu.tieba.play.c.a;
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
import org.json.JSONArray;
import org.json.JSONException;
/* loaded from: classes2.dex */
public class WriteVideoActivity extends BaseActivity<WriteVideoActivity> {
    private NewWriteModel aDf;
    private String bxC;
    private c cQM;
    private String eOD;
    private com.baidu.tieba.play.c.a fGo;
    private String gEL;
    private List<VideoTitleData> gEM;
    private boolean gUA;
    private b gUt;
    private GestureDetector gUu;
    private boolean gUv;
    private com.baidu.tieba.write.a gUw;
    private int gUx;
    private VideoTitleData gUz;
    private InputMethodManager mInputManager;
    private VideoTitleData mVideoTitleData;
    private final WriteData mData = new WriteData();
    private Runnable gUy = new Runnable() { // from class: com.baidu.tieba.write.video.WriteVideoActivity.1
        @Override // java.lang.Runnable
        public void run() {
            Intent intent = new Intent(MotuVideoConfig.ACTION_FINISH_VIDEO_ALL_ACTIVITY);
            intent.setPackage(TbadkCoreApplication.getInst().getPackageName());
            WriteVideoActivity.this.getPageContext().getPageActivity().sendBroadcast(intent);
        }
    };
    private Runnable gUB = new Runnable() { // from class: com.baidu.tieba.write.video.WriteVideoActivity.5
        @Override // java.lang.Runnable
        public void run() {
            if (WriteVideoActivity.this.gUA || WriteVideoActivity.this.fGo == null || !f.AA()) {
                WriteVideoActivity.this.bDH();
            } else {
                e.fP().postDelayed(WriteVideoActivity.this.gUB, 100L);
            }
        }
    };
    private final NewWriteModel.d aDw = new NewWriteModel.d() { // from class: com.baidu.tieba.write.video.WriteVideoActivity.6
        @Override // com.baidu.tieba.tbadkCore.writeModel.NewWriteModel.d
        public void callback(boolean z, PostWriteCallBackData postWriteCallBackData, r rVar, WriteData writeData, AntiData antiData) {
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
                WriteVideoActivity.this.gUt.bDR();
                boolean z3 = com.baidu.tbadk.core.sharedPref.b.getInstance().getBoolean("write_video_activity_save_video", true);
                if (z) {
                    if (WriteVideoActivity.this.mData != null && WriteVideoActivity.this.mData.getVideoInfo() != null) {
                        File file = new File(com.baidu.tieba.video.b.gDC);
                        if (!file.exists()) {
                            file.mkdirs();
                        }
                        if (z3 && WriteVideoActivity.this.mData.getVideoInfo().getVideoType() == 1) {
                            File file2 = new File(WriteVideoActivity.this.mData.getVideoInfo().getVideoPath());
                            k.Z(file2.getAbsolutePath(), com.baidu.tieba.video.b.gDC + file2.getName());
                        }
                        WriteVideoActivity.this.bDI();
                        k.r(new File(com.baidu.tieba.video.b.gDB));
                        postWriteCallBackData.mVideoMd5 = WriteVideoActivity.this.mData.getVideoInfo().getVideoMd5();
                    }
                    WriteVideoActivity.this.g(postWriteCallBackData);
                } else if (postWriteCallBackData != null && postWriteCallBackData.isSensitiveError()) {
                    WriteVideoActivity.this.showToast(postWriteCallBackData.getErrorString());
                    WriteVideoActivity.this.gUt.h(postWriteCallBackData);
                } else if ((rVar == null || writeData == null || rVar.getVcode_pic_url() == null || AntiHelper.h(antiData)) && postWriteCallBackData != null && postWriteCallBackData.getErrorCode() != 227001) {
                    WriteVideoActivity.this.b(false, postWriteCallBackData);
                } else if (rVar != null && writeData != null && rVar.getVcode_pic_url() != null) {
                    writeData.setVcodeMD5(rVar.getVcode_md5());
                    writeData.setVcodeUrl(rVar.getVcode_pic_url());
                    writeData.setVcodeExtra(rVar.yi());
                    if (com.baidu.tbadk.q.a.hb(rVar.yh())) {
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new NewVcodeActivityConfig(WriteVideoActivity.this.getPageContext().getPageActivity(), 12006, writeData, false, rVar.yh())));
                    } else {
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new VcodeActivityConfig(WriteVideoActivity.this.getPageContext().getPageActivity(), writeData, 12006)));
                    }
                } else if (postWriteCallBackData != null && postWriteCallBackData.getErrorCode() == 227001) {
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AccountAccessActivityConfig(WriteVideoActivity.this.getActivity(), 12006, writeData, postWriteCallBackData.getAccessState())));
                }
            }
        }
    };
    private Runnable gUC = new Runnable() { // from class: com.baidu.tieba.write.video.WriteVideoActivity.7
        @Override // java.lang.Runnable
        public void run() {
            if (WriteVideoActivity.this.cQM != null) {
                WriteVideoActivity.this.cQM.setPercent(WriteVideoActivity.this.gUx);
            }
        }
    };
    private a.InterfaceC0128a gkU = new a.InterfaceC0128a() { // from class: com.baidu.tieba.write.video.WriteVideoActivity.8
        @Override // com.baidu.tieba.tbadkCore.c.a.InterfaceC0128a
        public void onUploadProgress(int i) {
            WriteVideoActivity.this.gUx = i;
            e.fP().post(WriteVideoActivity.this.gUC);
        }
    };
    private DialogInterface.OnCancelListener mDialogCancelListener = new DialogInterface.OnCancelListener() { // from class: com.baidu.tieba.write.video.WriteVideoActivity.9
        @Override // android.content.DialogInterface.OnCancelListener
        public void onCancel(DialogInterface dialogInterface) {
            WriteVideoActivity.this.destroyWaitingDialog();
            WriteVideoActivity.this.bnW();
        }
    };

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.gUt = new b(this);
        setSwipeBackEnabled(false);
        bDG();
        if (this.mData.getVideoInfo() != null) {
            if (!StringUtils.isNull(this.gEL)) {
                VideoTitleData videoTitleData = new VideoTitleData();
                videoTitleData.name = this.gEL;
                this.gUt.a(this.mData.getVideoInfo(), videoTitleData, (List<VideoTitleData>) null);
            } else {
                this.gUt.a(this.mData.getVideoInfo(), this.mVideoTitleData, this.gEM);
            }
            if (!StringUtils.isNull(this.mData.getVideoInfo().getVideoPath())) {
                tZ(this.mData.getVideoInfo().getVideoPath());
            }
        }
        if (this.gUt.bDN() != null) {
            this.gUt.bDN().f(this);
        }
        adjustResizeForSoftInput();
        this.gUu = new GestureDetector(getPageContext().getPageActivity(), new a());
        this.mInputManager = (InputMethodManager) getSystemService("input_method");
        ShowSoftKeyPadDelay(this.gUt.bDP());
        this.gUt.bDP().requestFocus();
        TiebaStatic.log(new ak("c12307"));
        this.gUw = new com.baidu.tieba.write.a(getPageContext(), this.mData);
        addGlobalLayoutListener();
    }

    private void tZ(String str) {
        if (f.AA()) {
            this.fGo = new com.baidu.tieba.play.c.a(null);
            this.fGo.bP(str, null);
            this.fGo.a(new a.b() { // from class: com.baidu.tieba.write.video.WriteVideoActivity.4
                @Override // com.baidu.tieba.play.c.a.b
                public void lz(boolean z) {
                    WriteVideoActivity.this.gUA = true;
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        e.fP().postDelayed(this.gUy, 500L);
        if (this.gUt != null) {
            this.gUt.bzK();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onStop() {
        super.onStop();
        if (this.gUt != null) {
            this.gUt.akH();
        }
    }

    private void bDG() {
        Intent intent = getIntent();
        if (intent != null) {
            Serializable serializableExtra = intent.getSerializableExtra(WriteVideoActivityConfig.VIDEO_INFO);
            if (serializableExtra instanceof VideoInfo) {
                this.mData.setVideoInfo((VideoInfo) serializableExtra);
            }
            this.bxC = intent.getStringExtra("forum_id");
            this.eOD = intent.getStringExtra("forum_name");
            this.mData.setForumId(this.bxC);
            this.mData.setForumName(this.eOD);
            this.gEL = intent.getStringExtra("video_title");
            if (intent.getSerializableExtra(WriteVideoActivityConfig.FORUM_VIDEO_TITLE) instanceof VideoTitleData) {
                this.mVideoTitleData = (VideoTitleData) intent.getSerializableExtra(WriteVideoActivityConfig.FORUM_VIDEO_TITLE);
            }
            if (intent.getSerializableExtra(WriteVideoActivityConfig.ALL_VIDEO_TITLE) instanceof List) {
                this.gEM = (List) intent.getSerializableExtra(WriteVideoActivityConfig.ALL_VIDEO_TITLE);
            }
            if (!StringUtils.isNull(this.eOD)) {
                this.gUt.ud(this.eOD + getResources().getString(d.j.forum));
            }
        }
    }

    private void ua(String str) {
        JSONArray jSONArray;
        boolean z;
        if (StringUtils.isNull(str)) {
            jSONArray = null;
        } else {
            try {
                jSONArray = new JSONArray(str);
            } catch (JSONException e) {
                jSONArray = null;
            }
        }
        if (jSONArray == null || jSONArray.length() <= 0) {
            z = true;
        } else {
            this.mData.setForumId(this.bxC);
            z = false;
        }
        if (StringUtils.isNull(this.bxC) || Long.parseLong(this.bxC) <= 0 || StringUtils.isNull(this.eOD) || z) {
            this.mData.setCanNoForum(true);
        } else {
            this.mData.setCanNoForum(false);
        }
        this.mData.setForumName(this.eOD);
        this.mData.setTitle(this.gUt.getContent());
        this.mData.setContent("");
        this.mData.setType(0);
        this.mData.setTransmitForumData(str);
        if (this.gUt.bDN() != null) {
            this.mData.setHasLocationData(this.gUt.bDN().WV());
        }
        this.mData.setIsNoTitle(TextUtils.isEmpty(this.mData.getTitle()));
    }

    private void DO() {
        bnW();
        showLoadingDialog();
        if (!this.gUA && this.fGo != null && f.AA()) {
            e.fP().postDelayed(this.gUB, 100L);
        } else {
            bDH();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bDH() {
        this.gUz = ub(this.mData != null ? this.mData.getTitle() : "");
        if (this.aDf == null) {
            this.aDf = new NewWriteModel(this);
        }
        this.aDf.setWriteData(this.mData);
        this.aDf.b(this.aDw);
        this.aDf.a(this.gkU);
        this.aDf.startPostWrite();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bDI() {
        VideoInfo videoInfo;
        if (this.mData != null && (videoInfo = this.mData.getVideoInfo()) != null && videoInfo.getVideoType() == 2) {
            if ((videoInfo.isCompressedVideo() || videoInfo.getMusicListInfo() != null) && videoInfo.getVideoPath() != null && videoInfo.getVideoPath().contains(com.baidu.tieba.video.b.gDB)) {
                File file = new File(videoInfo.getVideoPath());
                if (file.exists() && file.isFile()) {
                    if (com.baidu.tbadk.core.sharedPref.b.getInstance().getBoolean("write_video_activity_save_video", true)) {
                        k.Z(file.getAbsolutePath(), com.baidu.tieba.video.b.gDC + file.getName());
                    } else {
                        file.delete();
                    }
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(boolean z, PostWriteCallBackData postWriteCallBackData) {
        if (postWriteCallBackData != null) {
            postWriteCallBackData.getErrorString();
            if (AntiHelper.ua(postWriteCallBackData.getErrorCode())) {
                AntiHelper.ao(getPageContext().getPageActivity(), postWriteCallBackData.getErrorString());
            } else if (postWriteCallBackData.getErrorCode() != 0) {
                String errorString = postWriteCallBackData.getErrorString();
                if (TextUtils.isEmpty(errorString)) {
                    errorString = getPageContext().getPageActivity().getString(d.j.sand_fail);
                }
                showToast(errorString);
            } else {
                com.baidu.tieba.tbadkCore.writeModel.c.d(getPageContext().getPageActivity(), postWriteCallBackData.getErrorString(), postWriteCallBackData.getPreMsg(), postWriteCallBackData.getColorMsg());
            }
        }
    }

    public void showLoadingDialog() {
        this.cQM = new c(getPageContext().getPageActivity());
        this.cQM.setOnCancelListener(this.mDialogCancelListener);
        this.cQM.setCancelable(true);
        this.cQM.setCanceledOnTouchOutside(false);
        g.a(this.cQM, getPageContext().getPageActivity());
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity
    public void finish() {
        bnW();
        destroyWaitingDialog();
        this.mDialogCancelListener = null;
        closeLoadingDialog();
        e.fP().removeCallbacks(this.gUC);
        super.finish();
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void destroyWaitingDialog() {
        this.cQM = null;
    }

    @Override // android.app.Activity
    protected void onActivityResult(int i, int i2, Intent intent) {
        PostWriteCallBackData postWriteCallBackData;
        super.onActivityResult(i, i2, intent);
        if (i == 12006) {
            if (i2 == -1) {
                PostWriteCallBackData postWriteCallBackData2 = null;
                if (intent != null && intent.getExtras() != null && (intent.getExtras().getSerializable(WriteActivityConfig.POST_WRITE_CALLBACK_DATA) instanceof PostWriteCallBackData)) {
                    postWriteCallBackData2 = (PostWriteCallBackData) intent.getExtras().getSerializable(WriteActivityConfig.POST_WRITE_CALLBACK_DATA);
                }
                g(postWriteCallBackData2);
            } else if (intent != null && intent.getExtras() != null && (intent.getExtras().getSerializable(WriteActivityConfig.POST_WRITE_CALLBACK_DATA) instanceof PostWriteCallBackData) && (postWriteCallBackData = (PostWriteCallBackData) intent.getExtras().getSerializable(WriteActivityConfig.POST_WRITE_CALLBACK_DATA)) != null && postWriteCallBackData.isSensitiveError()) {
                showToast(postWriteCallBackData.getErrorString());
                if (this.gUt.bDS() != null) {
                    this.gUt.bDS().aB(postWriteCallBackData.getSensitiveWords());
                    if (!v.v(this.gUt.bDS().bCp())) {
                        this.gUt.nz(true);
                    }
                }
            }
        } else if (i == 25018 && i2 == -1) {
            if (intent != null) {
                this.gUw.aa(intent);
                this.gUt.ud(this.gUw.bCm());
                ua(this.gUw.bCl());
            }
            if (this.gUv) {
                DO();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void g(PostWriteCallBackData postWriteCallBackData) {
        com.baidu.tbadk.util.v.a(new u<Void>() { // from class: com.baidu.tieba.write.video.WriteVideoActivity.10
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tbadk.util.u
            /* renamed from: Md */
            public Void doInBackground() {
                File file;
                if (WriteVideoActivity.this.mData != null && WriteVideoActivity.this.mData.getVideoInfo() != null && WriteVideoActivity.this.mData.getVideoInfo().getVideoPath() != null && WriteVideoActivity.this.mData.getVideoInfo().getVideoPath().contains(com.baidu.tieba.video.b.gDB) && (file = new File(WriteVideoActivity.this.mData.getVideoInfo().getVideoPath())) != null) {
                    k.Z(file.getAbsolutePath(), com.baidu.tieba.video.b.gDC + file.getName());
                }
                k.r(new File(com.baidu.tieba.video.b.gDB));
                return null;
            }
        }, new h<Void>() { // from class: com.baidu.tieba.write.video.WriteVideoActivity.11
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tbadk.util.h
            /* renamed from: c */
            public void onReturnDataInUI(Void r1) {
            }
        });
        if (!StringUtils.isNull(this.gEL)) {
            postWriteCallBackData.mFrom = 3;
        } else if (!StringUtils.isNull(this.eOD)) {
            postWriteCallBackData.mFrom = 2;
        } else {
            postWriteCallBackData.mFrom = 1;
        }
        postWriteCallBackData.mVideoTitleData = this.gUz;
        if (postWriteCallBackData.mFrom == 3 && postWriteCallBackData != null && !StringUtils.isNull(postWriteCallBackData.buildVideoFakeOnWallUrl())) {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_FINISH_THIS_PAGE));
            com.baidu.tbadk.browser.a.f(this, null, postWriteCallBackData.buildVideoFakeOnWallUrl());
        }
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_VIDEO_WRITE_POST_SUCCESS, postWriteCallBackData));
        finish();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        this.gUt.onChangeSkinType(i);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        if (this.gUw != null) {
            this.gUw.destroy();
        }
        if (this.gUt != null) {
            this.gUt.akH();
        }
        e.fP().removeCallbacks(this.gUy);
        e.fP().removeCallbacks(this.gUB);
    }

    protected void bnW() {
        if (this.aDf != null) {
            this.aDf.cancelLoadData();
        }
        if (this.gUt.bDN() != null) {
            this.gUt.bDN().bnW();
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i == 4) {
            if (this.cQM != null && this.cQM.isShowing()) {
                g.b(this.cQM, getPageContext());
                return true;
            }
            bDJ();
            return true;
        }
        return super.onKeyDown(i, keyEvent);
    }

    private void bDJ() {
        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(getPageContext().getPageActivity());
        aVar.cc(d.j.give_up_video_confirm);
        aVar.a(d.j.dialog_ok, new a.b() { // from class: com.baidu.tieba.write.video.WriteVideoActivity.2
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                aVar2.dismiss();
                WriteVideoActivity.this.bnW();
                TiebaStatic.log("c10800");
                WriteVideoActivity.this.finish();
            }
        });
        aVar.b(d.j.dialog_cancel, new a.b() { // from class: com.baidu.tieba.write.video.WriteVideoActivity.3
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                aVar2.dismiss();
            }
        });
        aVar.b(getPageContext()).th();
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.gUt.bDO()) {
            if (b.gUE - this.gUt.bDM() < 0) {
                showToast(getResources().getString(d.j.video_content_overflow));
            } else if (this.gUt.bDS() != null && this.gUt.bDS().bCr()) {
                showToast(this.gUt.bDS().bCt());
                this.gUt.nz(true);
            } else if (this.gUw.bCn()) {
                ua(this.gUw.bCl());
                DO();
            } else {
                this.gUv = true;
                bDK();
            }
        } else if (view == this.gUt.getBackButton()) {
            bDJ();
        } else if (view == this.gUt.bDQ()) {
            this.gUv = false;
            bDK();
        }
    }

    private void bDK() {
        if (!j.hh()) {
            showToast(d.j.neterror);
        } else {
            this.gUw.cn(this.gUt.getContent(), "");
        }
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void closeLoadingDialog() {
        if (this.cQM != null) {
            if (this.cQM.isShowing()) {
                g.b(this.cQM, getPageContext());
            }
            this.cQM = null;
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
        if (this.gUu.onTouchEvent(motionEvent)) {
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
        this.gUt.nA(z);
    }

    public VideoTitleData ub(String str) {
        if (!StringUtils.isNull(str) && !v.v(this.gEM)) {
            Matcher matcher = Pattern.compile("#(.+)#.*").matcher(str);
            if (matcher.find()) {
                String group = matcher.group(1);
                int i = 0;
                while (true) {
                    int i2 = i;
                    if (i2 >= this.gEM.size()) {
                        break;
                    } else if (this.gEM.get(i2) == null || !group.equals(this.gEM.get(i2).name)) {
                        i = i2 + 1;
                    } else {
                        return this.gEM.get(i2);
                    }
                }
            }
        }
        return null;
    }
}
