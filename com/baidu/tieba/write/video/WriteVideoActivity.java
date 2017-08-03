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
import com.baidu.adp.lib.util.i;
import com.baidu.adp.lib.util.k;
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
import com.baidu.tbadk.core.data.TransmitForumData;
import com.baidu.tbadk.core.dialog.a;
import com.baidu.tbadk.core.dialog.c;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.sharedPref.b;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.u;
import com.baidu.tbadk.coreExtra.data.VideoInfo;
import com.baidu.tbadk.coreExtra.data.WriteData;
import com.baidu.tbadk.coreExtra.data.q;
import com.baidu.tbadk.plugins.XiaoyingUtil;
import com.baidu.tieba.d;
import com.baidu.tieba.tbadkCore.c.a;
import com.baidu.tieba.tbadkCore.util.AntiHelper;
import com.baidu.tieba.tbadkCore.writeModel.NewWriteModel;
import com.baidu.tieba.tbadkCore.writeModel.PostWriteCallBackData;
import com.baidu.tieba.write.transmit.TransmitForumActivityConfig;
import com.baidu.tieba.write.transmit.model.a;
import java.io.File;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import tbclient.SimpleForum;
/* loaded from: classes.dex */
public class WriteVideoActivity extends BaseActivity<WriteVideoActivity> {
    private NewWriteModel aCE;
    private String boC;
    private c cvO;
    private String eJP;
    private com.baidu.tieba.write.video.a gCg;
    private GestureDetector gCh;
    private int gCi;
    private com.baidu.tieba.write.transmit.model.a gCk;
    private String gCl;
    private InputMethodManager mInputManager;
    private final WriteData mData = new WriteData();
    private Runnable gCj = new Runnable() { // from class: com.baidu.tieba.write.video.WriteVideoActivity.1
        @Override // java.lang.Runnable
        public void run() {
            Intent intent = new Intent(MotuVideoConfig.ACTION_FINISH_VIDEO_ALL_ACTIVITY);
            intent.setPackage(TbadkCoreApplication.getInst().getPackageName());
            WriteVideoActivity.this.getPageContext().getPageActivity().sendBroadcast(intent);
        }
    };
    private a.InterfaceC0126a gxS = new a.InterfaceC0126a() { // from class: com.baidu.tieba.write.video.WriteVideoActivity.2
        @Override // com.baidu.tieba.write.transmit.model.a.InterfaceC0126a
        public void bxt() {
            WriteVideoActivity.this.dD(null);
        }

        @Override // com.baidu.tieba.write.transmit.model.a.InterfaceC0126a
        public void B(List<SimpleForum> list) {
            WriteVideoActivity.this.dD(list);
        }
    };
    private final NewWriteModel.d aCV = new NewWriteModel.d() { // from class: com.baidu.tieba.write.video.WriteVideoActivity.3
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
                    WriteVideoActivity.this.byI();
                    WriteVideoActivity.this.a(true, postWriteCallBackData);
                    WriteVideoActivity.this.b(postWriteCallBackData);
                } else if ((qVar == null || writeData == null || qVar.getVcode_pic_url() == null || AntiHelper.h(antiData)) && postWriteCallBackData != null && postWriteCallBackData.getErrorCode() != 227001) {
                    WriteVideoActivity.this.a(false, postWriteCallBackData);
                } else if (qVar != null && writeData != null && qVar.getVcode_pic_url() != null) {
                    writeData.setVcodeMD5(qVar.getVcode_md5());
                    writeData.setVcodeUrl(qVar.getVcode_pic_url());
                    writeData.setVcodeExtra(qVar.yq());
                    if (com.baidu.tbadk.q.a.gT(qVar.yp())) {
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new NewVcodeActivityConfig(WriteVideoActivity.this.getPageContext().getPageActivity(), 12006, writeData, false, qVar.yp())));
                    } else {
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new VcodeActivityConfig(WriteVideoActivity.this.getPageContext().getPageActivity(), writeData, 12006)));
                    }
                } else if (postWriteCallBackData != null && postWriteCallBackData.getErrorCode() == 227001) {
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AccountAccessActivityConfig(WriteVideoActivity.this.getActivity(), 12006, writeData, postWriteCallBackData.getAccessState())));
                }
            }
        }
    };
    private Runnable gCm = new Runnable() { // from class: com.baidu.tieba.write.video.WriteVideoActivity.4
        @Override // java.lang.Runnable
        public void run() {
            if (WriteVideoActivity.this.cvO != null) {
                WriteVideoActivity.this.cvO.ci(WriteVideoActivity.this.gCi);
            }
        }
    };
    private a.InterfaceC0120a gbf = new a.InterfaceC0120a() { // from class: com.baidu.tieba.write.video.WriteVideoActivity.5
        @Override // com.baidu.tieba.tbadkCore.c.a.InterfaceC0120a
        public void onUploadProgress(int i) {
            WriteVideoActivity.this.gCi = i;
            e.fP().post(WriteVideoActivity.this.gCm);
        }
    };
    private DialogInterface.OnCancelListener mDialogCancelListener = new DialogInterface.OnCancelListener() { // from class: com.baidu.tieba.write.video.WriteVideoActivity.6
        @Override // android.content.DialogInterface.OnCancelListener
        public void onCancel(DialogInterface dialogInterface) {
            WriteVideoActivity.this.destroyWaitingDialog();
            WriteVideoActivity.this.blL();
        }
    };

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.gCg = new com.baidu.tieba.write.video.a(this);
        setSwipeBackEnabled(false);
        byH();
        if (this.mData.getVideoInfo() != null) {
            this.gCg.sV(this.mData.getVideoInfo().getThumbPath());
        }
        if (this.gCg.byO() != null) {
            this.gCg.byO().f(this);
        }
        adjustResizeForSoftInput();
        this.gCh = new GestureDetector(getPageContext().getPageActivity(), new a());
        this.mInputManager = (InputMethodManager) getSystemService("input_method");
        ShowSoftKeyPadDelay(this.gCg.byR());
        this.gCk = new com.baidu.tieba.write.transmit.model.a(getUniqueId());
        this.gCk.a(this.gxS);
        this.gCk.setForumId(this.boC);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dD(List<SimpleForum> list) {
        ArrayList<TransmitForumData> arrayList = new ArrayList<>();
        if (!StringUtils.isNull(this.boC) && !StringUtils.isNull(this.eJP)) {
            TransmitForumData transmitForumData = new TransmitForumData(com.baidu.adp.lib.g.b.c(this.boC, 0L), this.eJP, true, 1);
            if (arrayList != null) {
                arrayList.add(transmitForumData);
            }
        }
        if (u.u(list) > 0) {
            for (SimpleForum simpleForum : list) {
                if (simpleForum != null && simpleForum.id != null && !StringUtils.isNull(simpleForum.name) && simpleForum.id.longValue() != com.baidu.adp.lib.g.b.c(this.boC, 0L)) {
                    arrayList.add(new TransmitForumData(simpleForum.id.longValue(), simpleForum.name, false, 1));
                }
            }
        }
        TransmitForumActivityConfig transmitForumActivityConfig = new TransmitForumActivityConfig(getPageContext().getPageActivity(), 25013);
        CustomMessage customMessage = new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, transmitForumActivityConfig);
        transmitForumActivityConfig.setRecommendForumList(arrayList);
        MessageManager.getInstance().sendMessage(customMessage);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        e.fP().postDelayed(this.gCj, 500L);
    }

    private void byH() {
        Intent intent = getIntent();
        if (intent != null) {
            Serializable serializableExtra = intent.getSerializableExtra(WriteVideoActivityConfig.VIDEO_INFO);
            if (serializableExtra instanceof VideoInfo) {
                this.mData.setVideoInfo((VideoInfo) serializableExtra);
            }
            this.boC = intent.getStringExtra("forum_id");
            this.eJP = intent.getStringExtra("forum_name");
            this.gCl = intent.getStringExtra("video_title");
            if (this.gCg != null && this.mData.getVideoInfo() != null) {
                this.gCg.db((this.mData.getVideoInfo().getVideoDuration() + 1) * 1000);
            }
            if (this.gCg != null) {
                this.gCg.sX(this.gCl);
            }
        }
    }

    private void sU(String str) {
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
            this.mData.setForumId(this.boC);
            z = false;
        }
        if (StringUtils.isNull(this.boC) || Long.parseLong(this.boC) <= 0 || StringUtils.isNull(this.eJP) || z) {
            this.mData.setCanNoForum(true);
        } else {
            this.mData.setCanNoForum(false);
        }
        this.mData.setForumName(this.eJP);
        this.mData.setTitle(this.gCg.getContent());
        this.mData.setContent("");
        this.mData.setType(0);
        this.mData.setTransmitForumData(str);
        if (this.gCg.byO() != null) {
            this.mData.setHasLocationData(this.gCg.byO().Th());
        }
        this.mData.setIsNoTitle(TextUtils.isEmpty(this.mData.getTitle()));
    }

    private void DM() {
        blL();
        QS();
        if (this.aCE == null) {
            this.aCE = new NewWriteModel(this);
        }
        this.aCE.setWriteData(this.mData);
        this.aCE.b(this.aCV);
        this.aCE.a(this.gbf);
        this.aCE.startPostWrite();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void byI() {
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
            if (AntiHelper.tn(postWriteCallBackData.getErrorCode())) {
                AntiHelper.ar(getPageContext().getPageActivity(), postWriteCallBackData.getErrorString());
            } else if (postWriteCallBackData.getErrorCode() != 0) {
                String errorString = postWriteCallBackData.getErrorString();
                if (TextUtils.isEmpty(errorString)) {
                    errorString = getPageContext().getPageActivity().getString(d.l.error_write);
                }
                showToast(errorString);
            } else {
                com.baidu.tieba.tbadkCore.writeModel.c.c(getPageContext().getPageActivity(), postWriteCallBackData.getErrorString(), postWriteCallBackData.getPreMsg(), postWriteCallBackData.getColorMsg());
            }
        }
    }

    public void QS() {
        this.cvO = new c(getPageContext().getPageActivity());
        this.cvO.setOnCancelListener(this.mDialogCancelListener);
        this.cvO.setCancelable(true);
        this.cvO.setCanceledOnTouchOutside(false);
        g.a(this.cvO, getPageContext().getPageActivity());
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity
    public void finish() {
        blL();
        destroyWaitingDialog();
        this.mDialogCancelListener = null;
        closeLoadingDialog();
        e.fP().removeCallbacks(this.gCm);
        super.finish();
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void destroyWaitingDialog() {
        this.cvO = null;
    }

    @Override // android.app.Activity
    protected void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (i == 12006) {
            if (i2 == -1) {
                b((PostWriteCallBackData) intent.getExtras().getSerializable(WriteActivityConfig.POST_WRITE_CALLBACK_DATA));
            }
        } else if (i == 25013 && i2 == -1) {
            sU(intent.getStringExtra(TransmitForumActivityConfig.KEY_FORUM_LIST_SELECTED));
            DM();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(PostWriteCallBackData postWriteCallBackData) {
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_VIDEO_WRITE_POST_SUCCESS, postWriteCallBackData));
        if (!StringUtils.isNull(postWriteCallBackData.getErrorString())) {
            showToast(postWriteCallBackData.getErrorString());
        }
        finish();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        this.gCg.onChangeSkinType(i);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        if (this.gCk != null) {
            this.gCk.destroy();
        }
        e.fP().removeCallbacks(this.gCj);
    }

    protected void blL() {
        if (this.aCE != null) {
            this.aCE.cancelLoadData();
        }
        if (this.gCg.byO() != null) {
            this.gCg.byO().blL();
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i == 4) {
            if (this.cvO != null && this.cvO.isShowing()) {
                g.b(this.cvO, getPageContext());
                return true;
            }
            byJ();
            return true;
        }
        return super.onKeyDown(i, keyEvent);
    }

    private void byJ() {
        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(getPageContext().getPageActivity());
        aVar.ca(d.l.give_up_video_confirm);
        aVar.a(d.l.dialog_ok, new a.b() { // from class: com.baidu.tieba.write.video.WriteVideoActivity.7
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                aVar2.dismiss();
                WriteVideoActivity.this.blL();
                TiebaStatic.log("c10800");
                WriteVideoActivity.this.byI();
                WriteVideoActivity.this.finish();
            }
        });
        aVar.b(d.l.dialog_cancel, new a.b() { // from class: com.baidu.tieba.write.video.WriteVideoActivity.8
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                aVar2.dismiss();
            }
        });
        aVar.b(getPageContext()).th();
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.gCg.byP()) {
            byK();
        } else if (view == this.gCg.byQ()) {
            if (com.baidu.tieba.write.video.a.gCo - this.gCg.byN() < 0) {
                showToast(getResources().getString(d.l.video_content_overflow));
            } else {
                byL();
            }
        } else if (view == this.gCg.getBackButton()) {
            byJ();
        }
    }

    private void byK() {
        if (this.mData.getVideoInfo() != null) {
            if (TextUtils.isEmpty(this.mData.getVideoInfo().getVideoPath())) {
                showToast(d.l.file_not_exist);
            } else if (!new File(this.mData.getVideoInfo().getVideoPath()).exists()) {
                showToast(d.l.file_not_exist);
            } else {
                XiaoyingUtil.startPlayXiaoyingVideo(getPageContext().getPageActivity(), this.mData.getVideoInfo().getVideoPath(), this.mData.getVideoInfo().getVideoWidth(), this.mData.getVideoInfo().getVideoHeight(), this.mData.getVideoInfo().getThumbPath(), false);
            }
        }
    }

    private void byL() {
        if (!i.hh()) {
            showToast(d.l.neterror);
            return;
        }
        this.gCk.setThreadTitle(this.gCg.getContent());
        this.gCk.setThreadContent("");
        this.gCk.Pm();
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void closeLoadingDialog() {
        if (this.cvO != null) {
            if (this.cvO.isShowing()) {
                g.b(this.cvO, getPageContext());
            }
            this.cvO = null;
        }
    }

    /* loaded from: classes.dex */
    private class a extends GestureDetector.SimpleOnGestureListener {
        private a() {
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
        public boolean onFling(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
            k.b(WriteVideoActivity.this.getActivity(), WriteVideoActivity.this.getCurrentFocus());
            return super.onFling(motionEvent, motionEvent2, f, f2);
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity, android.view.Window.Callback
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        if (this.gCh.onTouchEvent(motionEvent)) {
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
