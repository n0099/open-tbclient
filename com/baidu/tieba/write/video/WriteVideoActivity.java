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
import com.baidu.tbadk.coreExtra.data.VideoInfo;
import com.baidu.tbadk.coreExtra.data.WriteData;
import com.baidu.tbadk.coreExtra.data.q;
import com.baidu.tbadk.util.h;
import com.baidu.tbadk.util.u;
import com.baidu.tieba.d;
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
    private NewWriteModel aCX;
    private String bxq;
    private c cQs;
    private String eOj;
    private String gDD;
    private List<VideoTitleData> gDE;
    private b gTl;
    private GestureDetector gTm;
    private boolean gTn;
    private com.baidu.tieba.write.a gTo;
    private int gTp;
    private VideoTitleData gTr;
    private InputMethodManager mInputManager;
    private VideoTitleData mVideoTitleData;
    private final WriteData mData = new WriteData();
    private Runnable gTq = new Runnable() { // from class: com.baidu.tieba.write.video.WriteVideoActivity.1
        @Override // java.lang.Runnable
        public void run() {
            Intent intent = new Intent(MotuVideoConfig.ACTION_FINISH_VIDEO_ALL_ACTIVITY);
            intent.setPackage(TbadkCoreApplication.getInst().getPackageName());
            WriteVideoActivity.this.getPageContext().getPageActivity().sendBroadcast(intent);
        }
    };
    private final NewWriteModel.d aDo = new NewWriteModel.d() { // from class: com.baidu.tieba.write.video.WriteVideoActivity.2
        @Override // com.baidu.tieba.tbadkCore.writeModel.NewWriteModel.d
        public void callback(boolean z, PostWriteCallBackData postWriteCallBackData, q qVar, WriteData writeData, AntiData antiData) {
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
                WriteVideoActivity.this.gTl.bDE();
                boolean z3 = com.baidu.tbadk.core.sharedPref.b.getInstance().getBoolean("write_video_activity_save_video", true);
                if (z) {
                    if (WriteVideoActivity.this.mData != null && WriteVideoActivity.this.mData.getVideoInfo() != null) {
                        File file = new File(com.baidu.tieba.video.b.gCu);
                        if (!file.exists()) {
                            file.mkdirs();
                        }
                        if (z3 && WriteVideoActivity.this.mData.getVideoInfo().getVideoType() == 1) {
                            File file2 = new File(WriteVideoActivity.this.mData.getVideoInfo().getVideoPath());
                            k.Z(file2.getAbsolutePath(), com.baidu.tieba.video.b.gCu + file2.getName());
                        }
                        WriteVideoActivity.this.bDv();
                        k.r(new File(com.baidu.tieba.video.b.gCt));
                        postWriteCallBackData.mVideoMd5 = WriteVideoActivity.this.mData.getVideoInfo().getVideoMd5();
                    }
                    WriteVideoActivity.this.g(postWriteCallBackData);
                } else if (postWriteCallBackData != null && postWriteCallBackData.isSensitiveError()) {
                    WriteVideoActivity.this.showToast(postWriteCallBackData.getErrorString());
                    WriteVideoActivity.this.gTl.h(postWriteCallBackData);
                } else if ((qVar == null || writeData == null || qVar.getVcode_pic_url() == null || AntiHelper.h(antiData)) && postWriteCallBackData != null && postWriteCallBackData.getErrorCode() != 227001) {
                    WriteVideoActivity.this.b(false, postWriteCallBackData);
                } else if (qVar != null && writeData != null && qVar.getVcode_pic_url() != null) {
                    writeData.setVcodeMD5(qVar.getVcode_md5());
                    writeData.setVcodeUrl(qVar.getVcode_pic_url());
                    writeData.setVcodeExtra(qVar.ya());
                    if (com.baidu.tbadk.q.a.ha(qVar.xZ())) {
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new NewVcodeActivityConfig(WriteVideoActivity.this.getPageContext().getPageActivity(), 12006, writeData, false, qVar.xZ())));
                    } else {
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new VcodeActivityConfig(WriteVideoActivity.this.getPageContext().getPageActivity(), writeData, 12006)));
                    }
                } else if (postWriteCallBackData != null && postWriteCallBackData.getErrorCode() == 227001) {
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AccountAccessActivityConfig(WriteVideoActivity.this.getActivity(), 12006, writeData, postWriteCallBackData.getAccessState())));
                }
            }
        }
    };
    private Runnable gTs = new Runnable() { // from class: com.baidu.tieba.write.video.WriteVideoActivity.3
        @Override // java.lang.Runnable
        public void run() {
            if (WriteVideoActivity.this.cQs != null) {
                WriteVideoActivity.this.cQs.setPercent(WriteVideoActivity.this.gTp);
            }
        }
    };
    private a.InterfaceC0125a gjS = new a.InterfaceC0125a() { // from class: com.baidu.tieba.write.video.WriteVideoActivity.4
        @Override // com.baidu.tieba.tbadkCore.c.a.InterfaceC0125a
        public void onUploadProgress(int i) {
            WriteVideoActivity.this.gTp = i;
            e.fP().post(WriteVideoActivity.this.gTs);
        }
    };
    private DialogInterface.OnCancelListener mDialogCancelListener = new DialogInterface.OnCancelListener() { // from class: com.baidu.tieba.write.video.WriteVideoActivity.5
        @Override // android.content.DialogInterface.OnCancelListener
        public void onCancel(DialogInterface dialogInterface) {
            WriteVideoActivity.this.destroyWaitingDialog();
            WriteVideoActivity.this.bnL();
        }
    };

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.gTl = new b(this);
        setSwipeBackEnabled(false);
        bDu();
        if (this.mData.getVideoInfo() != null) {
            if (!StringUtils.isNull(this.gDD)) {
                VideoTitleData videoTitleData = new VideoTitleData();
                videoTitleData.name = this.gDD;
                this.gTl.a(this.mData.getVideoInfo(), videoTitleData, (List<VideoTitleData>) null);
            } else {
                this.gTl.a(this.mData.getVideoInfo(), this.mVideoTitleData, this.gDE);
            }
        }
        if (this.gTl.bDA() != null) {
            this.gTl.bDA().f(this);
        }
        adjustResizeForSoftInput();
        this.gTm = new GestureDetector(getPageContext().getPageActivity(), new a());
        this.mInputManager = (InputMethodManager) getSystemService("input_method");
        ShowSoftKeyPadDelay(this.gTl.bDC());
        this.gTl.bDC().requestFocus();
        TiebaStatic.log(new ak("c12307"));
        this.gTo = new com.baidu.tieba.write.a(getPageContext(), this.mData);
        addGlobalLayoutListener();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        e.fP().postDelayed(this.gTq, 500L);
        if (this.gTl != null) {
            this.gTl.bzy();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onStop() {
        super.onStop();
        if (this.gTl != null) {
            this.gTl.akt();
        }
    }

    private void bDu() {
        Intent intent = getIntent();
        if (intent != null) {
            Serializable serializableExtra = intent.getSerializableExtra(WriteVideoActivityConfig.VIDEO_INFO);
            if (serializableExtra instanceof VideoInfo) {
                this.mData.setVideoInfo((VideoInfo) serializableExtra);
            }
            this.bxq = intent.getStringExtra("forum_id");
            this.eOj = intent.getStringExtra("forum_name");
            this.mData.setForumId(this.bxq);
            this.mData.setForumName(this.eOj);
            this.gDD = intent.getStringExtra("video_title");
            if (intent.getSerializableExtra(WriteVideoActivityConfig.FORUM_VIDEO_TITLE) instanceof VideoTitleData) {
                this.mVideoTitleData = (VideoTitleData) intent.getSerializableExtra(WriteVideoActivityConfig.FORUM_VIDEO_TITLE);
            }
            if (intent.getSerializableExtra(WriteVideoActivityConfig.ALL_VIDEO_TITLE) instanceof List) {
                this.gDE = (List) intent.getSerializableExtra(WriteVideoActivityConfig.ALL_VIDEO_TITLE);
            }
            if (!StringUtils.isNull(this.eOj)) {
                this.gTl.tW(this.eOj + getResources().getString(d.j.forum));
            }
        }
    }

    private void tT(String str) {
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
            this.mData.setForumId(this.bxq);
            z = false;
        }
        if (StringUtils.isNull(this.bxq) || Long.parseLong(this.bxq) <= 0 || StringUtils.isNull(this.eOj) || z) {
            this.mData.setCanNoForum(true);
        } else {
            this.mData.setCanNoForum(false);
        }
        this.mData.setForumName(this.eOj);
        this.mData.setTitle(this.gTl.getContent());
        this.mData.setContent("");
        this.mData.setType(0);
        this.mData.setTransmitForumData(str);
        if (this.gTl.bDA() != null) {
            this.mData.setHasLocationData(this.gTl.bDA().WK());
        }
        this.mData.setIsNoTitle(TextUtils.isEmpty(this.mData.getTitle()));
    }

    private void DC() {
        bnL();
        showLoadingDialog();
        this.gTr = tU(this.mData != null ? this.mData.getTitle() : "");
        if (this.aCX == null) {
            this.aCX = new NewWriteModel(this);
        }
        this.aCX.setWriteData(this.mData);
        this.aCX.b(this.aDo);
        this.aCX.a(this.gjS);
        this.aCX.startPostWrite();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bDv() {
        VideoInfo videoInfo;
        if (this.mData != null && (videoInfo = this.mData.getVideoInfo()) != null && videoInfo.getVideoType() == 2) {
            if ((videoInfo.isCompressedVideo() || videoInfo.getMusicListInfo() != null) && videoInfo.getVideoPath() != null && videoInfo.getVideoPath().contains(com.baidu.tieba.video.b.gCt)) {
                File file = new File(videoInfo.getVideoPath());
                if (file.exists() && file.isFile()) {
                    if (com.baidu.tbadk.core.sharedPref.b.getInstance().getBoolean("write_video_activity_save_video", true)) {
                        k.Z(file.getAbsolutePath(), com.baidu.tieba.video.b.gCu + file.getName());
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
            if (AntiHelper.tW(postWriteCallBackData.getErrorCode())) {
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
        this.cQs = new c(getPageContext().getPageActivity());
        this.cQs.setOnCancelListener(this.mDialogCancelListener);
        this.cQs.setCancelable(true);
        this.cQs.setCanceledOnTouchOutside(false);
        g.a(this.cQs, getPageContext().getPageActivity());
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity
    public void finish() {
        bnL();
        destroyWaitingDialog();
        this.mDialogCancelListener = null;
        closeLoadingDialog();
        e.fP().removeCallbacks(this.gTs);
        super.finish();
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void destroyWaitingDialog() {
        this.cQs = null;
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
                if (this.gTl.bDF() != null) {
                    this.gTl.bDF().aB(postWriteCallBackData.getSensitiveWords());
                    if (!v.v(this.gTl.bDF().bCd())) {
                        this.gTl.nr(true);
                    }
                }
            }
        } else if (i == 25018 && i2 == -1) {
            if (intent != null) {
                this.gTo.aa(intent);
                this.gTl.tW(this.gTo.bCa());
                tT(this.gTo.bBZ());
            }
            if (this.gTn) {
                DC();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void g(PostWriteCallBackData postWriteCallBackData) {
        com.baidu.tbadk.util.v.a(new u<Void>() { // from class: com.baidu.tieba.write.video.WriteVideoActivity.6
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tbadk.util.u
            /* renamed from: LS */
            public Void doInBackground() {
                File file;
                if (WriteVideoActivity.this.mData != null && WriteVideoActivity.this.mData.getVideoInfo() != null && WriteVideoActivity.this.mData.getVideoInfo().getVideoPath() != null && WriteVideoActivity.this.mData.getVideoInfo().getVideoPath().contains(com.baidu.tieba.video.b.gCt) && (file = new File(WriteVideoActivity.this.mData.getVideoInfo().getVideoPath())) != null) {
                    k.Z(file.getAbsolutePath(), com.baidu.tieba.video.b.gCu + file.getName());
                }
                k.r(new File(com.baidu.tieba.video.b.gCt));
                return null;
            }
        }, new h<Void>() { // from class: com.baidu.tieba.write.video.WriteVideoActivity.7
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tbadk.util.h
            /* renamed from: c */
            public void onReturnDataInUI(Void r1) {
            }
        });
        if (!StringUtils.isNull(this.gDD)) {
            postWriteCallBackData.mFrom = 3;
        } else if (!StringUtils.isNull(this.eOj)) {
            postWriteCallBackData.mFrom = 2;
        } else {
            postWriteCallBackData.mFrom = 1;
        }
        postWriteCallBackData.mVideoTitleData = this.gTr;
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
        this.gTl.onChangeSkinType(i);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        if (this.gTo != null) {
            this.gTo.destroy();
        }
        if (this.gTl != null) {
            this.gTl.akt();
        }
        e.fP().removeCallbacks(this.gTq);
    }

    protected void bnL() {
        if (this.aCX != null) {
            this.aCX.cancelLoadData();
        }
        if (this.gTl.bDA() != null) {
            this.gTl.bDA().bnL();
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i == 4) {
            if (this.cQs != null && this.cQs.isShowing()) {
                g.b(this.cQs, getPageContext());
                return true;
            }
            bDw();
            return true;
        }
        return super.onKeyDown(i, keyEvent);
    }

    private void bDw() {
        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(getPageContext().getPageActivity());
        aVar.cc(d.j.give_up_video_confirm);
        aVar.a(d.j.dialog_ok, new a.b() { // from class: com.baidu.tieba.write.video.WriteVideoActivity.8
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                aVar2.dismiss();
                WriteVideoActivity.this.bnL();
                TiebaStatic.log("c10800");
                WriteVideoActivity.this.finish();
            }
        });
        aVar.b(d.j.dialog_cancel, new a.b() { // from class: com.baidu.tieba.write.video.WriteVideoActivity.9
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                aVar2.dismiss();
            }
        });
        aVar.b(getPageContext()).th();
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.gTl.bDB()) {
            if (b.gTu - this.gTl.bDz() < 0) {
                showToast(getResources().getString(d.j.video_content_overflow));
            } else if (this.gTl.bDF() != null && this.gTl.bDF().bCf()) {
                showToast(this.gTl.bDF().bCh());
                this.gTl.nr(true);
            } else if (this.gTo.bCb()) {
                tT(this.gTo.bBZ());
                DC();
            } else {
                this.gTn = true;
                bDx();
            }
        } else if (view == this.gTl.getBackButton()) {
            bDw();
        } else if (view == this.gTl.bDD()) {
            this.gTn = false;
            bDx();
        }
    }

    private void bDx() {
        if (!j.hh()) {
            showToast(d.j.neterror);
        } else {
            this.gTo.cj(this.gTl.getContent(), "");
        }
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void closeLoadingDialog() {
        if (this.cQs != null) {
            if (this.cQs.isShowing()) {
                g.b(this.cQs, getPageContext());
            }
            this.cQs = null;
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
        if (this.gTm.onTouchEvent(motionEvent)) {
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
        this.gTl.ns(z);
    }

    public VideoTitleData tU(String str) {
        if (!StringUtils.isNull(str) && !v.v(this.gDE)) {
            Matcher matcher = Pattern.compile("#(.+)#.*").matcher(str);
            if (matcher.find()) {
                String group = matcher.group(1);
                int i = 0;
                while (true) {
                    int i2 = i;
                    if (i2 >= this.gDE.size()) {
                        break;
                    } else if (this.gDE.get(i2) == null || !group.equals(this.gDE.get(i2).name)) {
                        i = i2 + 1;
                    } else {
                        return this.gDE.get(i2);
                    }
                }
            }
        }
        return null;
    }
}
