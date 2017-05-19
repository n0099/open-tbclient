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
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.ActivityPendingTransitionFactory;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.core.atomData.WriteVideoActivityConfig;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.util.x;
import com.baidu.tbadk.coreExtra.data.VideoInfo;
import com.baidu.tbadk.coreExtra.data.WriteData;
import com.baidu.tbadk.plugins.XiaoyingUtil;
import com.baidu.tieba.tbadkCore.c.a;
import com.baidu.tieba.tbadkCore.util.AntiHelper;
import com.baidu.tieba.tbadkCore.writeModel.NewWriteModel;
import com.baidu.tieba.tbadkCore.writeModel.PostWriteCallBackData;
import com.baidu.tieba.w;
import com.baidu.tieba.write.transmit.TransmitForumActivityConfig;
import com.baidu.tieba.write.transmit.TransmitForumData;
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
    private NewWriteModel aAP;
    private com.baidu.tbadk.core.dialog.e cat;
    private String ejK;
    private n fPo;
    private GestureDetector fPp;
    private int fPq;
    private com.baidu.tieba.write.transmit.model.a fPs;
    private String fPt;
    private InputMethodManager mInputManager;
    private final WriteData mData = new WriteData();
    private Runnable fPr = new f(this);
    private a.InterfaceC0083a fOW = new g(this);
    private final NewWriteModel.d aBf = new h(this);
    private Runnable fPu = new i(this);
    private a.InterfaceC0079a fxE = new j(this);
    private DialogInterface.OnCancelListener mDialogCancelListener = new k(this);

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.fPo = new n(this);
        setSwipeBackEnabled(false);
        bnc();
        if (this.mData.getVideoInfo() != null) {
            this.fPo.rc(this.mData.getVideoInfo().getThumbPath());
        }
        if (this.fPo.bnj() != null) {
            this.fPo.bnj().f(this);
        }
        adjustResizeForSoftInput();
        this.fPp = new GestureDetector(getPageContext().getPageActivity(), new a(this, null));
        this.mInputManager = (InputMethodManager) getSystemService("input_method");
        ShowSoftKeyPadDelay(this.fPo.bnm());
        this.fPs = new com.baidu.tieba.write.transmit.model.a(getUniqueId());
        this.fPs.a(this.fOW);
        this.fPs.setForumId(this.fPt);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cR(List<SimpleForum> list) {
        ArrayList<TransmitForumData> arrayList = new ArrayList<>();
        if (!StringUtils.isNull(this.fPt) && !StringUtils.isNull(this.ejK)) {
            TransmitForumData transmitForumData = new TransmitForumData(com.baidu.adp.lib.g.b.c(this.fPt, 0L), this.ejK, true, 1);
            if (arrayList != null) {
                arrayList.add(transmitForumData);
            }
        }
        if (x.q(list) > 0) {
            for (SimpleForum simpleForum : list) {
                if (simpleForum != null && simpleForum.id != null && !StringUtils.isNull(simpleForum.name) && simpleForum.id.longValue() != com.baidu.adp.lib.g.b.c(this.fPt, 0L)) {
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
        com.baidu.adp.lib.g.h.fS().postDelayed(this.fPr, 500L);
    }

    private void bnc() {
        Intent intent = getIntent();
        if (intent != null) {
            Serializable serializableExtra = intent.getSerializableExtra(WriteVideoActivityConfig.VIDEO_INFO);
            if (serializableExtra instanceof VideoInfo) {
                this.mData.setVideoInfo((VideoInfo) serializableExtra);
            }
            this.fPt = intent.getStringExtra("forum_id");
            this.ejK = intent.getStringExtra("forum_name");
            if (this.fPo != null && this.mData.getVideoInfo() != null) {
                this.fPo.cu((this.mData.getVideoInfo().getVideoDuration() + 1) * 1000);
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:17:0x0064  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void rb(String str) {
        JSONArray jSONArray;
        boolean z;
        if (!StringUtils.isNull(str)) {
            try {
                jSONArray = new JSONArray(str);
            } catch (JSONException e) {
            }
            if (jSONArray != null || jSONArray.length() <= 0) {
                z = true;
            } else {
                this.mData.setForumId(this.fPt);
                z = false;
            }
            if (Long.parseLong(this.fPt) > 0 || StringUtils.isNull(this.ejK) || z) {
                this.mData.setCanNoForum(true);
            } else {
                this.mData.setCanNoForum(false);
            }
            this.mData.setForumName(this.ejK);
            this.mData.setTitle(this.fPo.getContent());
            this.mData.setContent("");
            this.mData.setType(0);
            this.mData.setTransmitForumData(str);
            if (this.fPo.bnj() != null) {
                this.mData.setHasLocationData(this.fPo.bnj().Qu());
            }
            this.mData.setIsNoTitle(TextUtils.isEmpty(this.mData.getTitle()));
        }
        jSONArray = null;
        if (jSONArray != null) {
        }
        z = true;
        if (Long.parseLong(this.fPt) > 0) {
        }
        this.mData.setCanNoForum(true);
        this.mData.setForumName(this.ejK);
        this.mData.setTitle(this.fPo.getContent());
        this.mData.setContent("");
        this.mData.setType(0);
        this.mData.setTransmitForumData(str);
        if (this.fPo.bnj() != null) {
        }
        this.mData.setIsNoTitle(TextUtils.isEmpty(this.mData.getTitle()));
    }

    private void Dm() {
        bcB();
        asr();
        if (this.aAP == null) {
            this.aAP = new NewWriteModel(this);
        }
        this.aAP.setWriteData(this.mData);
        this.aAP.b(this.aBf);
        this.aAP.a(this.fxE);
        this.aAP.startPostWrite();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bnd() {
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
            if (AntiHelper.rV(postWriteCallBackData.getErrorCode())) {
                AntiHelper.aq(getPageContext().getPageActivity(), postWriteCallBackData.getErrorString());
            } else if (postWriteCallBackData.getErrorCode() != 0) {
                String errorString = postWriteCallBackData.getErrorString();
                if (TextUtils.isEmpty(errorString)) {
                    errorString = getPageContext().getPageActivity().getString(w.l.error_write);
                }
                showToast(errorString);
            } else {
                com.baidu.tieba.tbadkCore.writeModel.e.c(getPageContext().getPageActivity(), postWriteCallBackData.getErrorString(), postWriteCallBackData.getPreMsg(), postWriteCallBackData.getColorMsg());
            }
        }
    }

    public void asr() {
        this.cat = new com.baidu.tbadk.core.dialog.e(getPageContext().getPageActivity());
        this.cat.setOnCancelListener(this.mDialogCancelListener);
        this.cat.setCancelable(true);
        this.cat.setCanceledOnTouchOutside(false);
        com.baidu.adp.lib.g.j.a(this.cat, getPageContext().getPageActivity());
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity
    public void finish() {
        bcB();
        destroyWaitingDialog();
        this.mDialogCancelListener = null;
        closeLoadingDialog();
        com.baidu.adp.lib.g.h.fS().removeCallbacks(this.fPu);
        super.finish();
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void destroyWaitingDialog() {
        this.cat = null;
    }

    @Override // android.app.Activity
    protected void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (i == 12006) {
            if (i2 == -1) {
                b((PostWriteCallBackData) intent.getExtras().getSerializable("post_write_callback_data"));
            }
        } else if (i == 25013 && i2 == -1) {
            rb(intent.getStringExtra(TransmitForumActivityConfig.KEY_FORUM_LIST_SELECTED));
            Dm();
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
        this.fPo.onChangeSkinType(i);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        if (this.fPs != null) {
            this.fPs.destroy();
        }
        com.baidu.adp.lib.g.h.fS().removeCallbacks(this.fPr);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void bcB() {
        if (this.aAP != null) {
            this.aAP.cancelLoadData();
        }
        if (this.fPo.bnj() != null) {
            this.fPo.bnj().bcB();
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i == 4) {
            if (this.cat != null && this.cat.isShowing()) {
                com.baidu.adp.lib.g.j.b(this.cat, getPageContext());
                return true;
            }
            bne();
            return true;
        }
        return super.onKeyDown(i, keyEvent);
    }

    private void bne() {
        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(getPageContext().getPageActivity());
        aVar.bX(w.l.give_up_video_confirm);
        aVar.a(w.l.dialog_ok, new l(this));
        aVar.b(w.l.dialog_cancel, new m(this));
        aVar.b(getPageContext()).td();
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.fPo.bnk()) {
            bnf();
        } else if (view == this.fPo.bnl()) {
            if (n.fPw - this.fPo.bni() < 0) {
                showToast(getResources().getString(w.l.video_content_overflow));
            } else {
                bng();
            }
        } else if (view == this.fPo.getBackButton()) {
            bne();
        }
    }

    private void bnf() {
        if (this.mData.getVideoInfo() != null) {
            if (TextUtils.isEmpty(this.mData.getVideoInfo().getVideoPath())) {
                showToast(w.l.file_not_exist);
            } else if (!new File(this.mData.getVideoInfo().getVideoPath()).exists()) {
                showToast(w.l.file_not_exist);
            } else {
                XiaoyingUtil.startPlayXiaoyingVideo(getPageContext().getPageActivity(), this.mData.getVideoInfo().getVideoPath(), this.mData.getVideoInfo().getVideoWidth(), this.mData.getVideoInfo().getVideoHeight(), this.mData.getVideoInfo().getThumbPath(), false);
            }
        }
    }

    private void bng() {
        if (!com.baidu.adp.lib.util.i.hk()) {
            showToast(w.l.neterror);
            return;
        }
        this.fPs.setThreadTitle(this.fPo.getContent());
        this.fPs.setThreadContent("");
        this.fPs.NA();
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void closeLoadingDialog() {
        if (this.cat != null) {
            if (this.cat.isShowing()) {
                com.baidu.adp.lib.g.j.b(this.cat, getPageContext());
            }
            this.cat = null;
        }
    }

    /* loaded from: classes.dex */
    private class a extends GestureDetector.SimpleOnGestureListener {
        private a() {
        }

        /* synthetic */ a(WriteVideoActivity writeVideoActivity, a aVar) {
            this();
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
        public boolean onFling(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
            com.baidu.adp.lib.util.k.b(WriteVideoActivity.this.getActivity(), WriteVideoActivity.this.getCurrentFocus());
            return super.onFling(motionEvent, motionEvent2, f, f2);
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity, android.view.Window.Callback
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        if (this.fPp.onTouchEvent(motionEvent)) {
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
