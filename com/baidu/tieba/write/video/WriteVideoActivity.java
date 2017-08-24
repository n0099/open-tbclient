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
    private NewWriteModel aDW;
    private String bqv;
    private c czg;
    private String eMY;
    private com.baidu.tieba.write.video.a gFj;
    private GestureDetector gFk;
    private int gFl;
    private com.baidu.tieba.write.transmit.model.a gFn;
    private String gFo;
    private InputMethodManager mInputManager;
    private final WriteData mData = new WriteData();
    private Runnable gFm = new Runnable() { // from class: com.baidu.tieba.write.video.WriteVideoActivity.1
        @Override // java.lang.Runnable
        public void run() {
            Intent intent = new Intent(MotuVideoConfig.ACTION_FINISH_VIDEO_ALL_ACTIVITY);
            intent.setPackage(TbadkCoreApplication.getInst().getPackageName());
            WriteVideoActivity.this.getPageContext().getPageActivity().sendBroadcast(intent);
        }
    };
    private a.InterfaceC0126a gAV = new a.InterfaceC0126a() { // from class: com.baidu.tieba.write.video.WriteVideoActivity.2
        @Override // com.baidu.tieba.write.transmit.model.a.InterfaceC0126a
        public void bya() {
            WriteVideoActivity.this.dG(null);
        }

        @Override // com.baidu.tieba.write.transmit.model.a.InterfaceC0126a
        public void B(List<SimpleForum> list) {
            WriteVideoActivity.this.dG(list);
        }
    };
    private final NewWriteModel.d aEn = new NewWriteModel.d() { // from class: com.baidu.tieba.write.video.WriteVideoActivity.3
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
                    WriteVideoActivity.this.bzo();
                    WriteVideoActivity.this.a(true, postWriteCallBackData);
                    WriteVideoActivity.this.b(postWriteCallBackData);
                } else if ((qVar == null || writeData == null || qVar.getVcode_pic_url() == null || AntiHelper.h(antiData)) && postWriteCallBackData != null && postWriteCallBackData.getErrorCode() != 227001) {
                    WriteVideoActivity.this.a(false, postWriteCallBackData);
                } else if (qVar != null && writeData != null && qVar.getVcode_pic_url() != null) {
                    writeData.setVcodeMD5(qVar.getVcode_md5());
                    writeData.setVcodeUrl(qVar.getVcode_pic_url());
                    writeData.setVcodeExtra(qVar.yy());
                    if (com.baidu.tbadk.q.a.hb(qVar.yx())) {
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
    private Runnable gFp = new Runnable() { // from class: com.baidu.tieba.write.video.WriteVideoActivity.4
        @Override // java.lang.Runnable
        public void run() {
            if (WriteVideoActivity.this.czg != null) {
                WriteVideoActivity.this.czg.ck(WriteVideoActivity.this.gFl);
            }
        }
    };
    private a.InterfaceC0120a gej = new a.InterfaceC0120a() { // from class: com.baidu.tieba.write.video.WriteVideoActivity.5
        @Override // com.baidu.tieba.tbadkCore.c.a.InterfaceC0120a
        public void onUploadProgress(int i) {
            WriteVideoActivity.this.gFl = i;
            e.ga().post(WriteVideoActivity.this.gFp);
        }
    };
    private DialogInterface.OnCancelListener mDialogCancelListener = new DialogInterface.OnCancelListener() { // from class: com.baidu.tieba.write.video.WriteVideoActivity.6
        @Override // android.content.DialogInterface.OnCancelListener
        public void onCancel(DialogInterface dialogInterface) {
            WriteVideoActivity.this.destroyWaitingDialog();
            WriteVideoActivity.this.bmu();
        }
    };

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.gFj = new com.baidu.tieba.write.video.a(this);
        setSwipeBackEnabled(false);
        bzn();
        if (this.mData.getVideoInfo() != null) {
            this.gFj.th(this.mData.getVideoInfo().getThumbPath());
        }
        if (this.gFj.bzu() != null) {
            this.gFj.bzu().f(this);
        }
        adjustResizeForSoftInput();
        this.gFk = new GestureDetector(getPageContext().getPageActivity(), new a());
        this.mInputManager = (InputMethodManager) getSystemService("input_method");
        ShowSoftKeyPadDelay(this.gFj.bzx());
        this.gFn = new com.baidu.tieba.write.transmit.model.a(getUniqueId());
        this.gFn.a(this.gAV);
        this.gFn.setForumId(this.bqv);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dG(List<SimpleForum> list) {
        ArrayList<TransmitForumData> arrayList = new ArrayList<>();
        if (!StringUtils.isNull(this.bqv) && !StringUtils.isNull(this.eMY)) {
            TransmitForumData transmitForumData = new TransmitForumData(com.baidu.adp.lib.g.b.d(this.bqv, 0L), this.eMY, true, 1);
            if (arrayList != null) {
                arrayList.add(transmitForumData);
            }
        }
        if (u.u(list) > 0) {
            for (SimpleForum simpleForum : list) {
                if (simpleForum != null && simpleForum.id != null && !StringUtils.isNull(simpleForum.name) && simpleForum.id.longValue() != com.baidu.adp.lib.g.b.d(this.bqv, 0L)) {
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
        e.ga().postDelayed(this.gFm, 500L);
    }

    private void bzn() {
        Intent intent = getIntent();
        if (intent != null) {
            Serializable serializableExtra = intent.getSerializableExtra(WriteVideoActivityConfig.VIDEO_INFO);
            if (serializableExtra instanceof VideoInfo) {
                this.mData.setVideoInfo((VideoInfo) serializableExtra);
            }
            this.bqv = intent.getStringExtra("forum_id");
            this.eMY = intent.getStringExtra("forum_name");
            this.gFo = intent.getStringExtra("video_title");
            if (this.gFj != null && this.mData.getVideoInfo() != null) {
                this.gFj.db((this.mData.getVideoInfo().getVideoDuration() + 1) * 1000);
            }
            if (this.gFj != null) {
                this.gFj.tj(this.gFo);
            }
        }
    }

    private void tg(String str) {
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
            this.mData.setForumId(this.bqv);
            z = false;
        }
        if (StringUtils.isNull(this.bqv) || Long.parseLong(this.bqv) <= 0 || StringUtils.isNull(this.eMY) || z) {
            this.mData.setCanNoForum(true);
        } else {
            this.mData.setCanNoForum(false);
        }
        this.mData.setForumName(this.eMY);
        this.mData.setTitle(this.gFj.getContent());
        this.mData.setContent("");
        this.mData.setType(0);
        this.mData.setTransmitForumData(str);
        if (this.gFj.bzu() != null) {
            this.mData.setHasLocationData(this.gFj.bzu().TG());
        }
        this.mData.setIsNoTitle(TextUtils.isEmpty(this.mData.getTitle()));
    }

    private void DU() {
        bmu();
        showLoadingDialog();
        if (this.aDW == null) {
            this.aDW = new NewWriteModel(this);
        }
        this.aDW.setWriteData(this.mData);
        this.aDW.b(this.aEn);
        this.aDW.a(this.gej);
        this.aDW.startPostWrite();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bzo() {
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
            if (AntiHelper.tx(postWriteCallBackData.getErrorCode())) {
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

    public void showLoadingDialog() {
        this.czg = new c(getPageContext().getPageActivity());
        this.czg.setOnCancelListener(this.mDialogCancelListener);
        this.czg.setCancelable(true);
        this.czg.setCanceledOnTouchOutside(false);
        g.a(this.czg, getPageContext().getPageActivity());
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity
    public void finish() {
        bmu();
        destroyWaitingDialog();
        this.mDialogCancelListener = null;
        closeLoadingDialog();
        e.ga().removeCallbacks(this.gFp);
        super.finish();
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void destroyWaitingDialog() {
        this.czg = null;
    }

    @Override // android.app.Activity
    protected void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (i == 12006) {
            if (i2 == -1) {
                b((PostWriteCallBackData) intent.getExtras().getSerializable(WriteActivityConfig.POST_WRITE_CALLBACK_DATA));
            }
        } else if (i == 25013 && i2 == -1) {
            tg(intent.getStringExtra(TransmitForumActivityConfig.KEY_FORUM_LIST_SELECTED));
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
        this.gFj.onChangeSkinType(i);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        if (this.gFn != null) {
            this.gFn.destroy();
        }
        e.ga().removeCallbacks(this.gFm);
    }

    protected void bmu() {
        if (this.aDW != null) {
            this.aDW.cancelLoadData();
        }
        if (this.gFj.bzu() != null) {
            this.gFj.bzu().bmu();
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i == 4) {
            if (this.czg != null && this.czg.isShowing()) {
                g.b(this.czg, getPageContext());
                return true;
            }
            bzp();
            return true;
        }
        return super.onKeyDown(i, keyEvent);
    }

    private void bzp() {
        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(getPageContext().getPageActivity());
        aVar.cc(d.l.give_up_video_confirm);
        aVar.a(d.l.dialog_ok, new a.b() { // from class: com.baidu.tieba.write.video.WriteVideoActivity.7
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                aVar2.dismiss();
                WriteVideoActivity.this.bmu();
                TiebaStatic.log("c10800");
                WriteVideoActivity.this.bzo();
                WriteVideoActivity.this.finish();
            }
        });
        aVar.b(d.l.dialog_cancel, new a.b() { // from class: com.baidu.tieba.write.video.WriteVideoActivity.8
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                aVar2.dismiss();
            }
        });
        aVar.b(getPageContext()).ts();
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.gFj.bzv()) {
            bzq();
        } else if (view == this.gFj.bzw()) {
            if (com.baidu.tieba.write.video.a.gFr - this.gFj.bzt() < 0) {
                showToast(getResources().getString(d.l.video_content_overflow));
            } else {
                bzr();
            }
        } else if (view == this.gFj.getBackButton()) {
            bzp();
        }
    }

    private void bzq() {
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

    private void bzr() {
        if (!i.hr()) {
            showToast(d.l.neterror);
            return;
        }
        this.gFn.setThreadTitle(this.gFj.getContent());
        this.gFn.setThreadContent("");
        this.gFn.Px();
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void closeLoadingDialog() {
        if (this.czg != null) {
            if (this.czg.isShowing()) {
                g.b(this.czg, getPageContext());
            }
            this.czg = null;
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
        if (this.gFk.onTouchEvent(motionEvent)) {
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
