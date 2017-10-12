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
import com.baidu.tbadk.core.sharedPref.b;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.ak;
import com.baidu.tbadk.core.util.k;
import com.baidu.tbadk.coreExtra.data.VideoInfo;
import com.baidu.tbadk.coreExtra.data.WriteData;
import com.baidu.tbadk.coreExtra.data.q;
import com.baidu.tbadk.util.s;
import com.baidu.tbadk.util.t;
import com.baidu.tieba.d;
import com.baidu.tieba.tbadkCore.c.a;
import com.baidu.tieba.tbadkCore.util.AntiHelper;
import com.baidu.tieba.tbadkCore.writeModel.NewWriteModel;
import com.baidu.tieba.tbadkCore.writeModel.PostWriteCallBackData;
import java.io.File;
import java.io.Serializable;
import org.json.JSONArray;
import org.json.JSONException;
/* loaded from: classes2.dex */
public class WriteVideoActivity extends BaseActivity<WriteVideoActivity> {
    private NewWriteModel aCB;
    private String btb;
    private c cHt;
    private String eFN;
    private com.baidu.tieba.write.video.a gJD;
    private GestureDetector gJE;
    private boolean gJF;
    private com.baidu.tieba.write.a gJG;
    private int gJH;
    private String guZ;
    private InputMethodManager mInputManager;
    private final WriteData mData = new WriteData();
    private Runnable gJI = new Runnable() { // from class: com.baidu.tieba.write.video.WriteVideoActivity.1
        @Override // java.lang.Runnable
        public void run() {
            Intent intent = new Intent(MotuVideoConfig.ACTION_FINISH_VIDEO_ALL_ACTIVITY);
            intent.setPackage(TbadkCoreApplication.getInst().getPackageName());
            WriteVideoActivity.this.getPageContext().getPageActivity().sendBroadcast(intent);
        }
    };
    private final NewWriteModel.d aCR = new NewWriteModel.d() { // from class: com.baidu.tieba.write.video.WriteVideoActivity.2
        @Override // com.baidu.tieba.tbadkCore.writeModel.NewWriteModel.d
        public void callback(boolean z, PostWriteCallBackData postWriteCallBackData, q qVar, WriteData writeData, AntiData antiData) {
            WriteVideoActivity.this.closeLoadingDialog();
            if (postWriteCallBackData != null && WriteVideoActivity.this.mData != null) {
                boolean z2 = b.getInstance().getBoolean(MotuVideoConfig.IS_SINGLE_GOD_USER, false);
                if (WriteVideoActivity.this.mData != null && WriteVideoActivity.this.mData.getVideoInfo() != null && writeData != null) {
                    if (!z2 && WriteVideoActivity.this.mData.getVideoInfo().getVideoDuration() > 8) {
                        writeData.setVideoReviewType(1);
                    } else {
                        writeData.setVideoReviewType(2);
                    }
                }
                if (z) {
                    WriteVideoActivity.this.bAd();
                    if (WriteVideoActivity.this.mData != null && WriteVideoActivity.this.mData.getVideoInfo() != null) {
                        File file = new File(com.baidu.tieba.video.b.gtW);
                        if (!file.exists()) {
                            file.mkdirs();
                        }
                        if (WriteVideoActivity.this.mData.getVideoInfo().getVideoType() == 1) {
                            File file2 = new File(WriteVideoActivity.this.mData.getVideoInfo().getVideoPath());
                            k.aa(file2.getAbsolutePath(), com.baidu.tieba.video.b.gtW + file2.getName());
                        }
                        k.s(new File(com.baidu.tieba.video.b.gtV));
                    }
                    WriteVideoActivity.this.c(postWriteCallBackData);
                } else if ((qVar == null || writeData == null || qVar.getVcode_pic_url() == null || AntiHelper.h(antiData)) && postWriteCallBackData != null && postWriteCallBackData.getErrorCode() != 227001) {
                    WriteVideoActivity.this.a(false, postWriteCallBackData);
                } else if (qVar != null && writeData != null && qVar.getVcode_pic_url() != null) {
                    writeData.setVcodeMD5(qVar.getVcode_md5());
                    writeData.setVcodeUrl(qVar.getVcode_pic_url());
                    writeData.setVcodeExtra(qVar.ya());
                    if (com.baidu.tbadk.p.a.gT(qVar.xZ())) {
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
    private Runnable gJJ = new Runnable() { // from class: com.baidu.tieba.write.video.WriteVideoActivity.3
        @Override // java.lang.Runnable
        public void run() {
            if (WriteVideoActivity.this.cHt != null) {
                WriteVideoActivity.this.cHt.setPercent(WriteVideoActivity.this.gJH);
            }
        }
    };
    private a.InterfaceC0125a gbt = new a.InterfaceC0125a() { // from class: com.baidu.tieba.write.video.WriteVideoActivity.4
        @Override // com.baidu.tieba.tbadkCore.c.a.InterfaceC0125a
        public void onUploadProgress(int i) {
            WriteVideoActivity.this.gJH = i;
            e.fP().post(WriteVideoActivity.this.gJJ);
        }
    };
    private DialogInterface.OnCancelListener mDialogCancelListener = new DialogInterface.OnCancelListener() { // from class: com.baidu.tieba.write.video.WriteVideoActivity.5
        @Override // android.content.DialogInterface.OnCancelListener
        public void onCancel(DialogInterface dialogInterface) {
            WriteVideoActivity.this.destroyWaitingDialog();
            WriteVideoActivity.this.bkL();
        }
    };

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.gJD = new com.baidu.tieba.write.video.a(this);
        setSwipeBackEnabled(false);
        bAc();
        if (this.mData.getVideoInfo() != null) {
            this.gJD.a(this.mData.getVideoInfo());
        }
        if (this.gJD.bAi() != null) {
            this.gJD.bAi().e(this);
        }
        adjustResizeForSoftInput();
        this.gJE = new GestureDetector(getPageContext().getPageActivity(), new a());
        this.mInputManager = (InputMethodManager) getSystemService("input_method");
        ShowSoftKeyPadDelay(this.gJD.bAk());
        this.gJD.bAk().requestFocus();
        TiebaStatic.log(new ak("c12307"));
        this.gJG = new com.baidu.tieba.write.a(getPageContext(), this.mData);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        e.fP().postDelayed(this.gJI, 500L);
        if (this.gJD != null) {
            this.gJD.bwt();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onStop() {
        super.onStop();
        if (this.gJD != null) {
            this.gJD.aiq();
        }
    }

    private void bAc() {
        Intent intent = getIntent();
        if (intent != null) {
            Serializable serializableExtra = intent.getSerializableExtra(WriteVideoActivityConfig.VIDEO_INFO);
            if (serializableExtra instanceof VideoInfo) {
                this.mData.setVideoInfo((VideoInfo) serializableExtra);
            }
            this.btb = intent.getStringExtra("forum_id");
            this.eFN = intent.getStringExtra("forum_name");
            this.mData.setForumId(this.btb);
            this.mData.setForumName(this.eFN);
            this.guZ = intent.getStringExtra("video_title");
            if (this.gJD != null && !StringUtils.isNull(this.guZ)) {
                this.gJD.tj(this.guZ);
            }
            if (!StringUtils.isNull(this.eFN)) {
                this.gJD.tk(this.eFN + getResources().getString(d.l.forum));
            }
        }
    }

    private void th(String str) {
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
            this.mData.setForumId(this.btb);
            z = false;
        }
        if (StringUtils.isNull(this.btb) || Long.parseLong(this.btb) <= 0 || StringUtils.isNull(this.eFN) || z) {
            this.mData.setCanNoForum(true);
        } else {
            this.mData.setCanNoForum(false);
        }
        this.mData.setForumName(this.eFN);
        this.mData.setTitle(this.gJD.getContent());
        this.mData.setContent("");
        this.mData.setType(0);
        this.mData.setTransmitForumData(str);
        if (this.gJD.bAi() != null) {
            this.mData.setHasLocationData(this.gJD.bAi().UW());
        }
        this.mData.setIsNoTitle(TextUtils.isEmpty(this.mData.getTitle()));
    }

    private void Dt() {
        bkL();
        showLoadingDialog();
        if (this.aCB == null) {
            this.aCB = new NewWriteModel(this);
        }
        this.aCB.setWriteData(this.mData);
        this.aCB.b(this.aCR);
        this.aCB.a(this.gbt);
        this.aCB.startPostWrite();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bAd() {
        VideoInfo videoInfo;
        if (this.mData != null && (videoInfo = this.mData.getVideoInfo()) != null && videoInfo.getVideoType() == 2 && videoInfo.isCompressedVideo()) {
            File file = new File(videoInfo.getVideoPath());
            if (file.exists() && file.isFile()) {
                file.delete();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(boolean z, PostWriteCallBackData postWriteCallBackData) {
        if (postWriteCallBackData != null) {
            postWriteCallBackData.getErrorString();
            if (AntiHelper.tG(postWriteCallBackData.getErrorCode())) {
                AntiHelper.at(getPageContext().getPageActivity(), postWriteCallBackData.getErrorString());
            } else if (postWriteCallBackData.getErrorCode() != 0) {
                String errorString = postWriteCallBackData.getErrorString();
                if (TextUtils.isEmpty(errorString)) {
                    errorString = getPageContext().getPageActivity().getString(d.l.error_write);
                }
                showToast(errorString);
            } else {
                com.baidu.tieba.tbadkCore.writeModel.c.d(getPageContext().getPageActivity(), postWriteCallBackData.getErrorString(), postWriteCallBackData.getPreMsg(), postWriteCallBackData.getColorMsg());
            }
        }
    }

    public void showLoadingDialog() {
        this.cHt = new c(getPageContext().getPageActivity());
        this.cHt.setOnCancelListener(this.mDialogCancelListener);
        this.cHt.setCancelable(true);
        this.cHt.setCanceledOnTouchOutside(false);
        g.a(this.cHt, getPageContext().getPageActivity());
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity
    public void finish() {
        bkL();
        destroyWaitingDialog();
        this.mDialogCancelListener = null;
        closeLoadingDialog();
        e.fP().removeCallbacks(this.gJJ);
        super.finish();
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void destroyWaitingDialog() {
        this.cHt = null;
    }

    @Override // android.app.Activity
    protected void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (i == 12006) {
            if (i2 == -1) {
                c((PostWriteCallBackData) intent.getExtras().getSerializable(WriteActivityConfig.POST_WRITE_CALLBACK_DATA));
            }
        } else if (i == 25018 && i2 == -1) {
            if (intent != null) {
                this.gJG.aa(intent);
                this.gJD.tk(this.gJG.byN());
                th(this.gJG.byM());
            }
            if (this.gJF) {
                Dt();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(PostWriteCallBackData postWriteCallBackData) {
        t.a(new s<Void>() { // from class: com.baidu.tieba.write.video.WriteVideoActivity.6
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tbadk.util.s
            /* renamed from: LP */
            public Void doInBackground() {
                File file;
                if (WriteVideoActivity.this.mData != null && WriteVideoActivity.this.mData.getVideoInfo() != null && WriteVideoActivity.this.mData.getVideoInfo().getVideoPath() != null && WriteVideoActivity.this.mData.getVideoInfo().getVideoPath().contains(com.baidu.tieba.video.b.gtV) && (file = new File(WriteVideoActivity.this.mData.getVideoInfo().getVideoPath())) != null) {
                    k.aa(file.getAbsolutePath(), com.baidu.tieba.video.b.gtW + file.getName());
                }
                k.s(new File(com.baidu.tieba.video.b.gtV));
                return null;
            }
        }, new com.baidu.tbadk.util.g<Void>() { // from class: com.baidu.tieba.write.video.WriteVideoActivity.7
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tbadk.util.g
            /* renamed from: c */
            public void onReturnDataInUI(Void r1) {
            }
        });
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_VIDEO_WRITE_POST_SUCCESS, postWriteCallBackData));
        a(true, postWriteCallBackData);
        finish();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        this.gJD.onChangeSkinType(i);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        if (this.gJG != null) {
            this.gJG.destroy();
        }
        if (this.gJD != null) {
            this.gJD.aiq();
        }
        e.fP().removeCallbacks(this.gJI);
    }

    protected void bkL() {
        if (this.aCB != null) {
            this.aCB.cancelLoadData();
        }
        if (this.gJD.bAi() != null) {
            this.gJD.bAi().bkL();
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i == 4) {
            if (this.cHt != null && this.cHt.isShowing()) {
                g.b(this.cHt, getPageContext());
                return true;
            }
            bAe();
            return true;
        }
        return super.onKeyDown(i, keyEvent);
    }

    private void bAe() {
        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(getPageContext().getPageActivity());
        aVar.cd(d.l.give_up_video_confirm);
        aVar.a(d.l.dialog_ok, new a.b() { // from class: com.baidu.tieba.write.video.WriteVideoActivity.8
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                aVar2.dismiss();
                WriteVideoActivity.this.bkL();
                TiebaStatic.log("c10800");
                WriteVideoActivity.this.finish();
            }
        });
        aVar.b(d.l.dialog_cancel, new a.b() { // from class: com.baidu.tieba.write.video.WriteVideoActivity.9
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                aVar2.dismiss();
            }
        });
        aVar.b(getPageContext()).ti();
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.gJD.bAj()) {
            if (com.baidu.tieba.write.video.a.gJL - this.gJD.bAh() < 0) {
                showToast(getResources().getString(d.l.video_content_overflow));
            } else if (this.gJG.byO()) {
                th(this.gJG.byM());
                Dt();
            } else {
                this.gJF = true;
                bAf();
            }
        } else if (view == this.gJD.getBackButton()) {
            bAe();
        } else if (view == this.gJD.bAl()) {
            this.gJF = false;
            bAf();
        }
    }

    private void bAf() {
        if (!j.hh()) {
            showToast(d.l.neterror);
        } else {
            this.gJG.cn(this.gJD.getContent(), "");
        }
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void closeLoadingDialog() {
        if (this.cHt != null) {
            if (this.cHt.isShowing()) {
                g.b(this.cHt, getPageContext());
            }
            this.cHt = null;
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
        if (this.gJE.onTouchEvent(motionEvent)) {
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
}
