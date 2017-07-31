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
    private NewWriteModel aDU;
    private String bpM;
    private c cxi;
    private String eLc;
    private com.baidu.tieba.write.video.a gDr;
    private GestureDetector gDs;
    private int gDt;
    private com.baidu.tieba.write.transmit.model.a gDv;
    private String gDw;
    private InputMethodManager mInputManager;
    private final WriteData mData = new WriteData();
    private Runnable gDu = new Runnable() { // from class: com.baidu.tieba.write.video.WriteVideoActivity.1
        @Override // java.lang.Runnable
        public void run() {
            Intent intent = new Intent(MotuVideoConfig.ACTION_FINISH_VIDEO_ALL_ACTIVITY);
            intent.setPackage(TbadkCoreApplication.getInst().getPackageName());
            WriteVideoActivity.this.getPageContext().getPageActivity().sendBroadcast(intent);
        }
    };
    private a.InterfaceC0125a gzd = new a.InterfaceC0125a() { // from class: com.baidu.tieba.write.video.WriteVideoActivity.2
        @Override // com.baidu.tieba.write.transmit.model.a.InterfaceC0125a
        public void bxA() {
            WriteVideoActivity.this.dD(null);
        }

        @Override // com.baidu.tieba.write.transmit.model.a.InterfaceC0125a
        public void B(List<SimpleForum> list) {
            WriteVideoActivity.this.dD(list);
        }
    };
    private final NewWriteModel.d aEl = new NewWriteModel.d() { // from class: com.baidu.tieba.write.video.WriteVideoActivity.3
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
                    WriteVideoActivity.this.byP();
                    WriteVideoActivity.this.a(true, postWriteCallBackData);
                    WriteVideoActivity.this.b(postWriteCallBackData);
                } else if ((qVar == null || writeData == null || qVar.getVcode_pic_url() == null || AntiHelper.h(antiData)) && postWriteCallBackData != null && postWriteCallBackData.getErrorCode() != 227001) {
                    WriteVideoActivity.this.a(false, postWriteCallBackData);
                } else if (qVar != null && writeData != null && qVar.getVcode_pic_url() != null) {
                    writeData.setVcodeMD5(qVar.getVcode_md5());
                    writeData.setVcodeUrl(qVar.getVcode_pic_url());
                    writeData.setVcodeExtra(qVar.yy());
                    if (com.baidu.tbadk.q.a.gY(qVar.yx())) {
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new NewVcodeActivityConfig(WriteVideoActivity.this.getPageContext().getPageActivity(), 12006, writeData, false, qVar.yx())));
                    } else {
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new VcodeActivityConfig(WriteVideoActivity.this.getPageContext().getPageActivity(), writeData, 12006)));
                    }
                } else if (postWriteCallBackData != null && postWriteCallBackData.getErrorCode() == 227001) {
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AccountAccessActivityConfig(WriteVideoActivity.this.getActivity(), 12006, writeData, postWriteCallBackData.getAccessState())));
                }
            }
        }
    };
    private Runnable gDx = new Runnable() { // from class: com.baidu.tieba.write.video.WriteVideoActivity.4
        @Override // java.lang.Runnable
        public void run() {
            if (WriteVideoActivity.this.cxi != null) {
                WriteVideoActivity.this.cxi.ck(WriteVideoActivity.this.gDt);
            }
        }
    };
    private a.InterfaceC0119a gcr = new a.InterfaceC0119a() { // from class: com.baidu.tieba.write.video.WriteVideoActivity.5
        @Override // com.baidu.tieba.tbadkCore.c.a.InterfaceC0119a
        public void onUploadProgress(int i) {
            WriteVideoActivity.this.gDt = i;
            e.ga().post(WriteVideoActivity.this.gDx);
        }
    };
    private DialogInterface.OnCancelListener mDialogCancelListener = new DialogInterface.OnCancelListener() { // from class: com.baidu.tieba.write.video.WriteVideoActivity.6
        @Override // android.content.DialogInterface.OnCancelListener
        public void onCancel(DialogInterface dialogInterface) {
            WriteVideoActivity.this.destroyWaitingDialog();
            WriteVideoActivity.this.blV();
        }
    };

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.gDr = new com.baidu.tieba.write.video.a(this);
        setSwipeBackEnabled(false);
        byO();
        if (this.mData.getVideoInfo() != null) {
            this.gDr.ta(this.mData.getVideoInfo().getThumbPath());
        }
        if (this.gDr.byV() != null) {
            this.gDr.byV().f(this);
        }
        adjustResizeForSoftInput();
        this.gDs = new GestureDetector(getPageContext().getPageActivity(), new a());
        this.mInputManager = (InputMethodManager) getSystemService("input_method");
        ShowSoftKeyPadDelay(this.gDr.byY());
        this.gDv = new com.baidu.tieba.write.transmit.model.a(getUniqueId());
        this.gDv.a(this.gzd);
        this.gDv.setForumId(this.bpM);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dD(List<SimpleForum> list) {
        ArrayList<TransmitForumData> arrayList = new ArrayList<>();
        if (!StringUtils.isNull(this.bpM) && !StringUtils.isNull(this.eLc)) {
            TransmitForumData transmitForumData = new TransmitForumData(com.baidu.adp.lib.g.b.d(this.bpM, 0L), this.eLc, true, 1);
            if (arrayList != null) {
                arrayList.add(transmitForumData);
            }
        }
        if (u.u(list) > 0) {
            for (SimpleForum simpleForum : list) {
                if (simpleForum != null && simpleForum.id != null && !StringUtils.isNull(simpleForum.name) && simpleForum.id.longValue() != com.baidu.adp.lib.g.b.d(this.bpM, 0L)) {
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
        e.ga().postDelayed(this.gDu, 500L);
    }

    private void byO() {
        Intent intent = getIntent();
        if (intent != null) {
            Serializable serializableExtra = intent.getSerializableExtra(WriteVideoActivityConfig.VIDEO_INFO);
            if (serializableExtra instanceof VideoInfo) {
                this.mData.setVideoInfo((VideoInfo) serializableExtra);
            }
            this.bpM = intent.getStringExtra("forum_id");
            this.eLc = intent.getStringExtra("forum_name");
            this.gDw = intent.getStringExtra("video_title");
            if (this.gDr != null && this.mData.getVideoInfo() != null) {
                this.gDr.db((this.mData.getVideoInfo().getVideoDuration() + 1) * 1000);
            }
            if (this.gDr != null) {
                this.gDr.tc(this.gDw);
            }
        }
    }

    private void sZ(String str) {
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
            this.mData.setForumId(this.bpM);
            z = false;
        }
        if (StringUtils.isNull(this.bpM) || Long.parseLong(this.bpM) <= 0 || StringUtils.isNull(this.eLc) || z) {
            this.mData.setCanNoForum(true);
        } else {
            this.mData.setCanNoForum(false);
        }
        this.mData.setForumName(this.eLc);
        this.mData.setTitle(this.gDr.getContent());
        this.mData.setContent("");
        this.mData.setType(0);
        this.mData.setTransmitForumData(str);
        if (this.gDr.byV() != null) {
            this.mData.setHasLocationData(this.gDr.byV().Tm());
        }
        this.mData.setIsNoTitle(TextUtils.isEmpty(this.mData.getTitle()));
    }

    private void DU() {
        blV();
        QX();
        if (this.aDU == null) {
            this.aDU = new NewWriteModel(this);
        }
        this.aDU.setWriteData(this.mData);
        this.aDU.b(this.aEl);
        this.aDU.a(this.gcr);
        this.aDU.startPostWrite();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void byP() {
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

    public void QX() {
        this.cxi = new c(getPageContext().getPageActivity());
        this.cxi.setOnCancelListener(this.mDialogCancelListener);
        this.cxi.setCancelable(true);
        this.cxi.setCanceledOnTouchOutside(false);
        g.a(this.cxi, getPageContext().getPageActivity());
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity
    public void finish() {
        blV();
        destroyWaitingDialog();
        this.mDialogCancelListener = null;
        closeLoadingDialog();
        e.ga().removeCallbacks(this.gDx);
        super.finish();
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void destroyWaitingDialog() {
        this.cxi = null;
    }

    @Override // android.app.Activity
    protected void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (i == 12006) {
            if (i2 == -1) {
                b((PostWriteCallBackData) intent.getExtras().getSerializable(WriteActivityConfig.POST_WRITE_CALLBACK_DATA));
            }
        } else if (i == 25013 && i2 == -1) {
            sZ(intent.getStringExtra(TransmitForumActivityConfig.KEY_FORUM_LIST_SELECTED));
            DU();
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
        this.gDr.onChangeSkinType(i);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        if (this.gDv != null) {
            this.gDv.destroy();
        }
        e.ga().removeCallbacks(this.gDu);
    }

    protected void blV() {
        if (this.aDU != null) {
            this.aDU.cancelLoadData();
        }
        if (this.gDr.byV() != null) {
            this.gDr.byV().blV();
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i == 4) {
            if (this.cxi != null && this.cxi.isShowing()) {
                g.b(this.cxi, getPageContext());
                return true;
            }
            byQ();
            return true;
        }
        return super.onKeyDown(i, keyEvent);
    }

    private void byQ() {
        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(getPageContext().getPageActivity());
        aVar.cc(d.l.give_up_video_confirm);
        aVar.a(d.l.dialog_ok, new a.b() { // from class: com.baidu.tieba.write.video.WriteVideoActivity.7
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                aVar2.dismiss();
                WriteVideoActivity.this.blV();
                TiebaStatic.log("c10800");
                WriteVideoActivity.this.byP();
                WriteVideoActivity.this.finish();
            }
        });
        aVar.b(d.l.dialog_cancel, new a.b() { // from class: com.baidu.tieba.write.video.WriteVideoActivity.8
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                aVar2.dismiss();
            }
        });
        aVar.b(getPageContext()).tr();
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.gDr.byW()) {
            byR();
        } else if (view == this.gDr.byX()) {
            if (com.baidu.tieba.write.video.a.gDz - this.gDr.byU() < 0) {
                showToast(getResources().getString(d.l.video_content_overflow));
            } else {
                byS();
            }
        } else if (view == this.gDr.getBackButton()) {
            byQ();
        }
    }

    private void byR() {
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

    private void byS() {
        if (!i.hr()) {
            showToast(d.l.neterror);
            return;
        }
        this.gDv.setThreadTitle(this.gDr.getContent());
        this.gDv.setThreadContent("");
        this.gDv.Pr();
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void closeLoadingDialog() {
        if (this.cxi != null) {
            if (this.cxi.isShowing()) {
                g.b(this.cxi, getPageContext());
            }
            this.cxi = null;
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
        if (this.gDs.onTouchEvent(motionEvent)) {
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
