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
    private NewWriteModel aAB;
    private com.baidu.tbadk.core.dialog.e cgF;
    private String epw;
    private n fXk;
    private GestureDetector fXl;
    private int fXm;
    private com.baidu.tieba.write.transmit.model.a fXo;
    private String fXp;
    private InputMethodManager mInputManager;
    private final WriteData mData = new WriteData();
    private Runnable fXn = new f(this);
    private a.InterfaceC0086a fWS = new g(this);
    private final NewWriteModel.d aAR = new h(this);
    private Runnable fXq = new i(this);
    private a.InterfaceC0081a fFv = new j(this);
    private DialogInterface.OnCancelListener mDialogCancelListener = new k(this);

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.fXk = new n(this);
        setSwipeBackEnabled(false);
        boB();
        if (this.mData.getVideoInfo() != null) {
            this.fXk.rq(this.mData.getVideoInfo().getThumbPath());
        }
        if (this.fXk.boI() != null) {
            this.fXk.boI().f(this);
        }
        adjustResizeForSoftInput();
        this.fXl = new GestureDetector(getPageContext().getPageActivity(), new a(this, null));
        this.mInputManager = (InputMethodManager) getSystemService("input_method");
        ShowSoftKeyPadDelay(this.fXk.boL());
        this.fXo = new com.baidu.tieba.write.transmit.model.a(getUniqueId());
        this.fXo.a(this.fWS);
        this.fXo.setForumId(this.fXp);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cT(List<SimpleForum> list) {
        ArrayList<TransmitForumData> arrayList = new ArrayList<>();
        if (!StringUtils.isNull(this.fXp) && !StringUtils.isNull(this.epw)) {
            TransmitForumData transmitForumData = new TransmitForumData(com.baidu.adp.lib.g.b.c(this.fXp, 0L), this.epw, true, 1);
            if (arrayList != null) {
                arrayList.add(transmitForumData);
            }
        }
        if (x.q(list) > 0) {
            for (SimpleForum simpleForum : list) {
                if (simpleForum != null && simpleForum.id != null && !StringUtils.isNull(simpleForum.name) && simpleForum.id.longValue() != com.baidu.adp.lib.g.b.c(this.fXp, 0L)) {
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
        com.baidu.adp.lib.g.h.fS().postDelayed(this.fXn, 500L);
    }

    private void boB() {
        Intent intent = getIntent();
        if (intent != null) {
            Serializable serializableExtra = intent.getSerializableExtra(WriteVideoActivityConfig.VIDEO_INFO);
            if (serializableExtra instanceof VideoInfo) {
                this.mData.setVideoInfo((VideoInfo) serializableExtra);
            }
            this.fXp = intent.getStringExtra("forum_id");
            this.epw = intent.getStringExtra("forum_name");
            if (this.fXk != null && this.mData.getVideoInfo() != null) {
                this.fXk.cz((this.mData.getVideoInfo().getVideoDuration() + 1) * 1000);
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:17:0x0064  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void rp(String str) {
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
                this.mData.setForumId(this.fXp);
                z = false;
            }
            if (Long.parseLong(this.fXp) > 0 || StringUtils.isNull(this.epw) || z) {
                this.mData.setCanNoForum(true);
            } else {
                this.mData.setCanNoForum(false);
            }
            this.mData.setForumName(this.epw);
            this.mData.setTitle(this.fXk.getContent());
            this.mData.setContent("");
            this.mData.setType(0);
            this.mData.setTransmitForumData(str);
            if (this.fXk.boI() != null) {
                this.mData.setHasLocationData(this.fXk.boI().QG());
            }
            this.mData.setIsNoTitle(TextUtils.isEmpty(this.mData.getTitle()));
        }
        jSONArray = null;
        if (jSONArray != null) {
        }
        z = true;
        if (Long.parseLong(this.fXp) > 0) {
        }
        this.mData.setCanNoForum(true);
        this.mData.setForumName(this.epw);
        this.mData.setTitle(this.fXk.getContent());
        this.mData.setContent("");
        this.mData.setType(0);
        this.mData.setTransmitForumData(str);
        if (this.fXk.boI() != null) {
        }
        this.mData.setIsNoTitle(TextUtils.isEmpty(this.mData.getTitle()));
    }

    private void Dg() {
        bdV();
        Pd();
        if (this.aAB == null) {
            this.aAB = new NewWriteModel(this);
        }
        this.aAB.setWriteData(this.mData);
        this.aAB.b(this.aAR);
        this.aAB.a(this.fFv);
        this.aAB.startPostWrite();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void boC() {
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
            if (AntiHelper.sr(postWriteCallBackData.getErrorCode())) {
                AntiHelper.ap(getPageContext().getPageActivity(), postWriteCallBackData.getErrorString());
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

    public void Pd() {
        this.cgF = new com.baidu.tbadk.core.dialog.e(getPageContext().getPageActivity());
        this.cgF.setOnCancelListener(this.mDialogCancelListener);
        this.cgF.setCancelable(true);
        this.cgF.setCanceledOnTouchOutside(false);
        com.baidu.adp.lib.g.j.a(this.cgF, getPageContext().getPageActivity());
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity
    public void finish() {
        bdV();
        destroyWaitingDialog();
        this.mDialogCancelListener = null;
        closeLoadingDialog();
        com.baidu.adp.lib.g.h.fS().removeCallbacks(this.fXq);
        super.finish();
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void destroyWaitingDialog() {
        this.cgF = null;
    }

    @Override // android.app.Activity
    protected void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (i == 12006) {
            if (i2 == -1) {
                b((PostWriteCallBackData) intent.getExtras().getSerializable("post_write_callback_data"));
            }
        } else if (i == 25013 && i2 == -1) {
            rp(intent.getStringExtra(TransmitForumActivityConfig.KEY_FORUM_LIST_SELECTED));
            Dg();
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
        this.fXk.onChangeSkinType(i);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        if (this.fXo != null) {
            this.fXo.destroy();
        }
        com.baidu.adp.lib.g.h.fS().removeCallbacks(this.fXn);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void bdV() {
        if (this.aAB != null) {
            this.aAB.cancelLoadData();
        }
        if (this.fXk.boI() != null) {
            this.fXk.boI().bdV();
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i == 4) {
            if (this.cgF != null && this.cgF.isShowing()) {
                com.baidu.adp.lib.g.j.b(this.cgF, getPageContext());
                return true;
            }
            boD();
            return true;
        }
        return super.onKeyDown(i, keyEvent);
    }

    private void boD() {
        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(getPageContext().getPageActivity());
        aVar.bY(w.l.give_up_video_confirm);
        aVar.a(w.l.dialog_ok, new l(this));
        aVar.b(w.l.dialog_cancel, new m(this));
        aVar.b(getPageContext()).tc();
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.fXk.boJ()) {
            boE();
        } else if (view == this.fXk.boK()) {
            if (n.fXs - this.fXk.boH() < 0) {
                showToast(getResources().getString(w.l.video_content_overflow));
            } else {
                boF();
            }
        } else if (view == this.fXk.getBackButton()) {
            boD();
        }
    }

    private void boE() {
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

    private void boF() {
        if (!com.baidu.adp.lib.util.i.hk()) {
            showToast(w.l.neterror);
            return;
        }
        this.fXo.setThreadTitle(this.fXk.getContent());
        this.fXo.setThreadContent("");
        this.fXo.NJ();
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void closeLoadingDialog() {
        if (this.cgF != null) {
            if (this.cgF.isShowing()) {
                com.baidu.adp.lib.g.j.b(this.cgF, getPageContext());
            }
            this.cgF = null;
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
        if (this.fXl.onTouchEvent(motionEvent)) {
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
