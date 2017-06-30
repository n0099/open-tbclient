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
import com.baidu.tbadk.core.atomData.WriteActivityConfig;
import com.baidu.tbadk.core.atomData.WriteVideoActivityConfig;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.util.z;
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
    private NewWriteModel aBE;
    private String blf;
    private com.baidu.tbadk.core.dialog.e coV;
    private String eyG;
    private n gik;
    private GestureDetector gil;
    private int gim;
    private com.baidu.tieba.write.transmit.model.a gio;
    private String gip;
    private InputMethodManager mInputManager;
    private final WriteData mData = new WriteData();
    private Runnable gin = new f(this);
    private a.InterfaceC0088a gdx = new g(this);
    private final NewWriteModel.d aBU = new h(this);
    private Runnable giq = new i(this);
    private a.InterfaceC0084a fPA = new j(this);
    private DialogInterface.OnCancelListener mDialogCancelListener = new k(this);

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.gik = new n(this);
        setSwipeBackEnabled(false);
        bsZ();
        if (this.mData.getVideoInfo() != null) {
            this.gik.sp(this.mData.getVideoInfo().getThumbPath());
        }
        if (this.gik.btg() != null) {
            this.gik.btg().f(this);
        }
        adjustResizeForSoftInput();
        this.gil = new GestureDetector(getPageContext().getPageActivity(), new a(this, null));
        this.mInputManager = (InputMethodManager) getSystemService("input_method");
        ShowSoftKeyPadDelay(this.gik.btj());
        this.gio = new com.baidu.tieba.write.transmit.model.a(getUniqueId());
        this.gio.a(this.gdx);
        this.gio.setForumId(this.blf);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void di(List<SimpleForum> list) {
        ArrayList<TransmitForumData> arrayList = new ArrayList<>();
        if (!StringUtils.isNull(this.blf) && !StringUtils.isNull(this.eyG)) {
            TransmitForumData transmitForumData = new TransmitForumData(com.baidu.adp.lib.g.b.c(this.blf, 0L), this.eyG, true, 1);
            if (arrayList != null) {
                arrayList.add(transmitForumData);
            }
        }
        if (z.s(list) > 0) {
            for (SimpleForum simpleForum : list) {
                if (simpleForum != null && simpleForum.id != null && !StringUtils.isNull(simpleForum.name) && simpleForum.id.longValue() != com.baidu.adp.lib.g.b.c(this.blf, 0L)) {
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
        com.baidu.adp.lib.g.h.fR().postDelayed(this.gin, 500L);
    }

    private void bsZ() {
        Intent intent = getIntent();
        if (intent != null) {
            Serializable serializableExtra = intent.getSerializableExtra(WriteVideoActivityConfig.VIDEO_INFO);
            if (serializableExtra instanceof VideoInfo) {
                this.mData.setVideoInfo((VideoInfo) serializableExtra);
            }
            this.blf = intent.getStringExtra("forum_id");
            this.eyG = intent.getStringExtra("forum_name");
            this.gip = intent.getStringExtra("video_title");
            if (this.gik != null && this.mData.getVideoInfo() != null) {
                this.gik.cO((this.mData.getVideoInfo().getVideoDuration() + 1) * 1000);
            }
            if (this.gik != null) {
                this.gik.sr(this.gip);
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:17:0x0064  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void so(String str) {
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
                this.mData.setForumId(this.blf);
                z = false;
            }
            if (Long.parseLong(this.blf) > 0 || StringUtils.isNull(this.eyG) || z) {
                this.mData.setCanNoForum(true);
            } else {
                this.mData.setCanNoForum(false);
            }
            this.mData.setForumName(this.eyG);
            this.mData.setTitle(this.gik.getContent());
            this.mData.setContent("");
            this.mData.setType(0);
            this.mData.setTransmitForumData(str);
            if (this.gik.btg() != null) {
                this.mData.setHasLocationData(this.gik.btg().Sy());
            }
            this.mData.setIsNoTitle(TextUtils.isEmpty(this.mData.getTitle()));
        }
        jSONArray = null;
        if (jSONArray != null) {
        }
        z = true;
        if (Long.parseLong(this.blf) > 0) {
        }
        this.mData.setCanNoForum(true);
        this.mData.setForumName(this.eyG);
        this.mData.setTitle(this.gik.getContent());
        this.mData.setContent("");
        this.mData.setType(0);
        this.mData.setTransmitForumData(str);
        if (this.gik.btg() != null) {
        }
        this.mData.setIsNoTitle(TextUtils.isEmpty(this.mData.getTitle()));
    }

    private void DA() {
        bik();
        Qx();
        if (this.aBE == null) {
            this.aBE = new NewWriteModel(this);
        }
        this.aBE.setWriteData(this.mData);
        this.aBE.b(this.aBU);
        this.aBE.a(this.fPA);
        this.aBE.startPostWrite();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bta() {
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
            if (AntiHelper.sK(postWriteCallBackData.getErrorCode())) {
                AntiHelper.ar(getPageContext().getPageActivity(), postWriteCallBackData.getErrorString());
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

    public void Qx() {
        this.coV = new com.baidu.tbadk.core.dialog.e(getPageContext().getPageActivity());
        this.coV.setOnCancelListener(this.mDialogCancelListener);
        this.coV.setCancelable(true);
        this.coV.setCanceledOnTouchOutside(false);
        com.baidu.adp.lib.g.j.a(this.coV, getPageContext().getPageActivity());
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity
    public void finish() {
        bik();
        destroyWaitingDialog();
        this.mDialogCancelListener = null;
        closeLoadingDialog();
        com.baidu.adp.lib.g.h.fR().removeCallbacks(this.giq);
        super.finish();
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void destroyWaitingDialog() {
        this.coV = null;
    }

    @Override // android.app.Activity
    protected void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (i == 12006) {
            if (i2 == -1) {
                b((PostWriteCallBackData) intent.getExtras().getSerializable(WriteActivityConfig.POST_WRITE_CALLBACK_DATA));
            }
        } else if (i == 25013 && i2 == -1) {
            so(intent.getStringExtra(TransmitForumActivityConfig.KEY_FORUM_LIST_SELECTED));
            DA();
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
        this.gik.onChangeSkinType(i);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        if (this.gio != null) {
            this.gio.destroy();
        }
        com.baidu.adp.lib.g.h.fR().removeCallbacks(this.gin);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void bik() {
        if (this.aBE != null) {
            this.aBE.cancelLoadData();
        }
        if (this.gik.btg() != null) {
            this.gik.btg().bik();
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i == 4) {
            if (this.coV != null && this.coV.isShowing()) {
                com.baidu.adp.lib.g.j.b(this.coV, getPageContext());
                return true;
            }
            btb();
            return true;
        }
        return super.onKeyDown(i, keyEvent);
    }

    private void btb() {
        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(getPageContext().getPageActivity());
        aVar.bY(w.l.give_up_video_confirm);
        aVar.a(w.l.dialog_ok, new l(this));
        aVar.b(w.l.dialog_cancel, new m(this));
        aVar.b(getPageContext()).ta();
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.gik.bth()) {
            btc();
        } else if (view == this.gik.bti()) {
            if (n.gis - this.gik.btf() < 0) {
                showToast(getResources().getString(w.l.video_content_overflow));
            } else {
                btd();
            }
        } else if (view == this.gik.getBackButton()) {
            btb();
        }
    }

    private void btc() {
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

    private void btd() {
        if (!com.baidu.adp.lib.util.i.hj()) {
            showToast(w.l.neterror);
            return;
        }
        this.gio.setThreadTitle(this.gik.getContent());
        this.gio.setThreadContent("");
        this.gio.OZ();
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void closeLoadingDialog() {
        if (this.coV != null) {
            if (this.coV.isShowing()) {
                com.baidu.adp.lib.g.j.b(this.coV, getPageContext());
            }
            this.coV = null;
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
        if (this.gil.onTouchEvent(motionEvent)) {
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
