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
    private NewWriteModel aCo;
    private String bsP;
    private c cHh;
    private String eFz;
    private com.baidu.tieba.write.video.a gJo;
    private GestureDetector gJp;
    private boolean gJq;
    private com.baidu.tieba.write.a gJr;
    private int gJs;
    private String guL;
    private InputMethodManager mInputManager;
    private final WriteData mData = new WriteData();
    private Runnable gJt = new Runnable() { // from class: com.baidu.tieba.write.video.WriteVideoActivity.1
        @Override // java.lang.Runnable
        public void run() {
            Intent intent = new Intent(MotuVideoConfig.ACTION_FINISH_VIDEO_ALL_ACTIVITY);
            intent.setPackage(TbadkCoreApplication.getInst().getPackageName());
            WriteVideoActivity.this.getPageContext().getPageActivity().sendBroadcast(intent);
        }
    };
    private final NewWriteModel.d aCE = new NewWriteModel.d() { // from class: com.baidu.tieba.write.video.WriteVideoActivity.2
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
                    WriteVideoActivity.this.bzX();
                    if (WriteVideoActivity.this.mData != null && WriteVideoActivity.this.mData.getVideoInfo() != null) {
                        File file = new File(com.baidu.tieba.video.b.gtI);
                        if (!file.exists()) {
                            file.mkdirs();
                        }
                        if (WriteVideoActivity.this.mData.getVideoInfo().getVideoType() == 1) {
                            File file2 = new File(WriteVideoActivity.this.mData.getVideoInfo().getVideoPath());
                            k.Z(file2.getAbsolutePath(), com.baidu.tieba.video.b.gtI + file2.getName());
                        }
                        k.s(new File(com.baidu.tieba.video.b.gtH));
                    }
                    WriteVideoActivity.this.c(postWriteCallBackData);
                } else if ((qVar == null || writeData == null || qVar.getVcode_pic_url() == null || AntiHelper.h(antiData)) && postWriteCallBackData != null && postWriteCallBackData.getErrorCode() != 227001) {
                    WriteVideoActivity.this.a(false, postWriteCallBackData);
                } else if (qVar != null && writeData != null && qVar.getVcode_pic_url() != null) {
                    writeData.setVcodeMD5(qVar.getVcode_md5());
                    writeData.setVcodeUrl(qVar.getVcode_pic_url());
                    writeData.setVcodeExtra(qVar.xT());
                    if (com.baidu.tbadk.p.a.gS(qVar.xS())) {
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new NewVcodeActivityConfig(WriteVideoActivity.this.getPageContext().getPageActivity(), 12006, writeData, false, qVar.xS())));
                    } else {
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new VcodeActivityConfig(WriteVideoActivity.this.getPageContext().getPageActivity(), writeData, 12006)));
                    }
                } else if (postWriteCallBackData != null && postWriteCallBackData.getErrorCode() == 227001) {
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AccountAccessActivityConfig(WriteVideoActivity.this.getActivity(), 12006, writeData, postWriteCallBackData.getAccessState())));
                }
            }
        }
    };
    private Runnable gJu = new Runnable() { // from class: com.baidu.tieba.write.video.WriteVideoActivity.3
        @Override // java.lang.Runnable
        public void run() {
            if (WriteVideoActivity.this.cHh != null) {
                WriteVideoActivity.this.cHh.setPercent(WriteVideoActivity.this.gJs);
            }
        }
    };
    private a.InterfaceC0125a gbf = new a.InterfaceC0125a() { // from class: com.baidu.tieba.write.video.WriteVideoActivity.4
        @Override // com.baidu.tieba.tbadkCore.c.a.InterfaceC0125a
        public void onUploadProgress(int i) {
            WriteVideoActivity.this.gJs = i;
            e.fP().post(WriteVideoActivity.this.gJu);
        }
    };
    private DialogInterface.OnCancelListener mDialogCancelListener = new DialogInterface.OnCancelListener() { // from class: com.baidu.tieba.write.video.WriteVideoActivity.5
        @Override // android.content.DialogInterface.OnCancelListener
        public void onCancel(DialogInterface dialogInterface) {
            WriteVideoActivity.this.destroyWaitingDialog();
            WriteVideoActivity.this.bkE();
        }
    };

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.gJo = new com.baidu.tieba.write.video.a(this);
        setSwipeBackEnabled(false);
        bzW();
        if (this.mData.getVideoInfo() != null) {
            this.gJo.a(this.mData.getVideoInfo());
        }
        if (this.gJo.bAc() != null) {
            this.gJo.bAc().e(this);
        }
        adjustResizeForSoftInput();
        this.gJp = new GestureDetector(getPageContext().getPageActivity(), new a());
        this.mInputManager = (InputMethodManager) getSystemService("input_method");
        ShowSoftKeyPadDelay(this.gJo.bAe());
        this.gJo.bAe().requestFocus();
        TiebaStatic.log(new ak("c12307"));
        this.gJr = new com.baidu.tieba.write.a(getPageContext(), this.mData);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        e.fP().postDelayed(this.gJt, 500L);
        if (this.gJo != null) {
            this.gJo.bwl();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onStop() {
        super.onStop();
        if (this.gJo != null) {
            this.gJo.ail();
        }
    }

    private void bzW() {
        Intent intent = getIntent();
        if (intent != null) {
            Serializable serializableExtra = intent.getSerializableExtra(WriteVideoActivityConfig.VIDEO_INFO);
            if (serializableExtra instanceof VideoInfo) {
                this.mData.setVideoInfo((VideoInfo) serializableExtra);
            }
            this.bsP = intent.getStringExtra("forum_id");
            this.eFz = intent.getStringExtra("forum_name");
            this.mData.setForumId(this.bsP);
            this.mData.setForumName(this.eFz);
            this.guL = intent.getStringExtra("video_title");
            if (this.gJo != null && !StringUtils.isNull(this.guL)) {
                this.gJo.ti(this.guL);
            }
            if (!StringUtils.isNull(this.eFz)) {
                this.gJo.tj(this.eFz + getResources().getString(d.l.forum));
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
            this.mData.setForumId(this.bsP);
            z = false;
        }
        if (StringUtils.isNull(this.bsP) || Long.parseLong(this.bsP) <= 0 || StringUtils.isNull(this.eFz) || z) {
            this.mData.setCanNoForum(true);
        } else {
            this.mData.setCanNoForum(false);
        }
        this.mData.setForumName(this.eFz);
        this.mData.setTitle(this.gJo.getContent());
        this.mData.setContent("");
        this.mData.setType(0);
        this.mData.setTransmitForumData(str);
        if (this.gJo.bAc() != null) {
            this.mData.setHasLocationData(this.gJo.bAc().US());
        }
        this.mData.setIsNoTitle(TextUtils.isEmpty(this.mData.getTitle()));
    }

    private void Dn() {
        bkE();
        showLoadingDialog();
        if (this.aCo == null) {
            this.aCo = new NewWriteModel(this);
        }
        this.aCo.setWriteData(this.mData);
        this.aCo.b(this.aCE);
        this.aCo.a(this.gbf);
        this.aCo.startPostWrite();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bzX() {
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
            if (AntiHelper.tF(postWriteCallBackData.getErrorCode())) {
                AntiHelper.ao(getPageContext().getPageActivity(), postWriteCallBackData.getErrorString());
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
        this.cHh = new c(getPageContext().getPageActivity());
        this.cHh.setOnCancelListener(this.mDialogCancelListener);
        this.cHh.setCancelable(true);
        this.cHh.setCanceledOnTouchOutside(false);
        g.a(this.cHh, getPageContext().getPageActivity());
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity
    public void finish() {
        bkE();
        destroyWaitingDialog();
        this.mDialogCancelListener = null;
        closeLoadingDialog();
        e.fP().removeCallbacks(this.gJu);
        super.finish();
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void destroyWaitingDialog() {
        this.cHh = null;
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
                this.gJr.aa(intent);
                this.gJo.tj(this.gJr.byH());
                tg(this.gJr.byG());
            }
            if (this.gJq) {
                Dn();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(PostWriteCallBackData postWriteCallBackData) {
        t.a(new s<Void>() { // from class: com.baidu.tieba.write.video.WriteVideoActivity.6
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tbadk.util.s
            /* renamed from: LJ */
            public Void doInBackground() {
                File file;
                if (WriteVideoActivity.this.mData != null && WriteVideoActivity.this.mData.getVideoInfo() != null && WriteVideoActivity.this.mData.getVideoInfo().getVideoPath() != null && WriteVideoActivity.this.mData.getVideoInfo().getVideoPath().contains(com.baidu.tieba.video.b.gtH) && (file = new File(WriteVideoActivity.this.mData.getVideoInfo().getVideoPath())) != null) {
                    k.Z(file.getAbsolutePath(), com.baidu.tieba.video.b.gtI + file.getName());
                }
                k.s(new File(com.baidu.tieba.video.b.gtH));
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
        this.gJo.onChangeSkinType(i);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        if (this.gJr != null) {
            this.gJr.destroy();
        }
        if (this.gJo != null) {
            this.gJo.ail();
        }
        e.fP().removeCallbacks(this.gJt);
    }

    protected void bkE() {
        if (this.aCo != null) {
            this.aCo.cancelLoadData();
        }
        if (this.gJo.bAc() != null) {
            this.gJo.bAc().bkE();
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i == 4) {
            if (this.cHh != null && this.cHh.isShowing()) {
                g.b(this.cHh, getPageContext());
                return true;
            }
            bzY();
            return true;
        }
        return super.onKeyDown(i, keyEvent);
    }

    private void bzY() {
        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(getPageContext().getPageActivity());
        aVar.cc(d.l.give_up_video_confirm);
        aVar.a(d.l.dialog_ok, new a.b() { // from class: com.baidu.tieba.write.video.WriteVideoActivity.8
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                aVar2.dismiss();
                WriteVideoActivity.this.bkE();
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
        aVar.b(getPageContext()).tb();
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.gJo.bAd()) {
            if (com.baidu.tieba.write.video.a.gJw - this.gJo.bAb() < 0) {
                showToast(getResources().getString(d.l.video_content_overflow));
            } else if (this.gJr.byI()) {
                tg(this.gJr.byG());
                Dn();
            } else {
                this.gJq = true;
                bzZ();
            }
        } else if (view == this.gJo.getBackButton()) {
            bzY();
        } else if (view == this.gJo.bAf()) {
            this.gJq = false;
            bzZ();
        }
    }

    private void bzZ() {
        if (!j.hh()) {
            showToast(d.l.neterror);
        } else {
            this.gJr.cm(this.gJo.getContent(), "");
        }
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void closeLoadingDialog() {
        if (this.cHh != null) {
            if (this.cHh.isShowing()) {
                g.b(this.cHh, getPageContext());
            }
            this.cHh = null;
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
        if (this.gJp.onTouchEvent(motionEvent)) {
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
