package com.baidu.tieba.write.vcode.newVcode.a;

import android.content.Intent;
import android.os.Bundle;
import android.webkit.WebView;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.lib.g.e;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.lib.util.l;
import com.baidu.sapi2.passhost.pluginsdk.service.IEventCenterService;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.atomData.AccountAccessActivityConfig;
import com.baidu.tbadk.core.atomData.WriteActivityConfig;
import com.baidu.tbadk.core.data.AntiData;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.coreExtra.data.WriteData;
import com.baidu.tbadk.coreExtra.data.s;
import com.baidu.tieba.d;
import com.baidu.tieba.tbadkCore.writeModel.NewWriteModel;
import com.baidu.tieba.tbadkCore.writeModel.PostWriteCallBackData;
import com.baidu.tieba.write.vcode.newVcode.NewVcodeView;
import com.xiaomi.mipush.sdk.Constants;
/* loaded from: classes2.dex */
public class c implements b {
    private final NewWriteModel hMT;
    private final NewVcodeView hQc;
    private NewWriteModel.d hQd;
    private String jsMethodForChangeVCode;
    private String jsMethodForInit;
    private boolean mNeedShowErrorToastOnStart = false;
    private String mErrorToastOnStart = null;
    private boolean hMU = false;
    private Runnable mShowErrorTaostRunnable = new Runnable() { // from class: com.baidu.tieba.write.vcode.newVcode.a.c.1
        @Override // java.lang.Runnable
        public void run() {
            if (c.this.hQc != null) {
                if (StringUtils.isNull(c.this.mErrorToastOnStart)) {
                    c.this.hQc.showToast(false, c.this.hQc.getContext().getResources().getString(d.j.drag_vcode_error));
                } else {
                    c.this.hQc.showToast(false, c.this.mErrorToastOnStart);
                }
            }
        }
    };
    private final NewWriteModel.d brP = new NewWriteModel.d() { // from class: com.baidu.tieba.write.vcode.newVcode.a.c.2
        @Override // com.baidu.tieba.tbadkCore.writeModel.NewWriteModel.d
        public void callback(boolean z, PostWriteCallBackData postWriteCallBackData, s sVar, WriteData writeData, AntiData antiData) {
            String str;
            String str2 = null;
            if (c.this.hQc != null) {
                c.this.hQc.showPostThreadLoadingView(false);
                if (z) {
                    c.this.hMU = true;
                    if (writeData != null && writeData.getVideoReviewType() == 1) {
                        if (writeData.getIsStory() != 1) {
                            c.this.hQc.showToast(true, c.this.hQc.getContext().getResources().getString(d.j.video_send_success_under_review));
                        }
                    } else if (writeData != null && writeData.getVideoReviewType() == 2) {
                        if (writeData.getIsStory() != 1) {
                            c.this.hQc.showToast(true, c.this.hQc.getContext().getResources().getString(d.j.video_send_success));
                        }
                    } else if (writeData != null && writeData.getIsStory() != 1) {
                        String string = c.this.hQc.getContext().getResources().getString(d.j.send_success);
                        if (postWriteCallBackData != null) {
                            str = postWriteCallBackData.getPreMsg();
                            str2 = postWriteCallBackData.getColorMsg();
                            string = postWriteCallBackData.getErrorString();
                        } else {
                            str = null;
                        }
                        if (writeData.getType() != 7) {
                            com.baidu.tieba.tbadkCore.writeModel.c.e(c.this.hQc.getContext().getActivity(), string, str, str2);
                        }
                    }
                    Intent intent = new Intent();
                    Bundle bundle = new Bundle();
                    bundle.putSerializable("post_write_callback_data", postWriteCallBackData);
                    intent.putExtras(bundle);
                    BaseActivity context = c.this.hQc.getContext();
                    c.this.hQc.getContext();
                    context.setResult(-1, intent);
                    c.this.hQc.getContext().finish();
                } else if (postWriteCallBackData != null && postWriteCallBackData.getErrorCode() == 227001) {
                    c.this.hQc.getContext().setVisible(false);
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AccountAccessActivityConfig(c.this.hQc.getContext().getActivity(), IEventCenterService.EventId.EventMode.SAPIACCOUNT_FACE_REG, writeData, postWriteCallBackData.getAccessState())));
                } else if (postWriteCallBackData != null && postWriteCallBackData.getErrorCode() == 220015 && c.this.hQd != null) {
                    if (c.this.hQd != null) {
                        c.this.hQd.callback(z, postWriteCallBackData, sVar, writeData, antiData);
                    }
                } else if (postWriteCallBackData != null) {
                    if (writeData != null && writeData.getIsStory() != 1) {
                        if (StringUtils.isNull(postWriteCallBackData.getErrorString())) {
                            c.this.hQc.showToast(false, c.this.hQc.getContext().getResources().getString(d.j.input_vcode_error));
                        } else {
                            c.this.hQc.showToast(false, postWriteCallBackData.getErrorString());
                        }
                    }
                    c.this.refreshVCode();
                }
            }
        }
    };

    public c(NewVcodeView newVcodeView, NewWriteModel newWriteModel) {
        this.hQc = newVcodeView;
        this.hMT = newWriteModel;
        this.hMT.b(this.brP);
    }

    @Override // com.baidu.tieba.write.vcode.newVcode.a.b
    public boolean onUrlLoad(WebView webView, String str) {
        if (str.contains("objc:jsChangeVcode")) {
            this.jsMethodForInit = com.baidu.tbadk.p.a.he(str);
            if (this.jsMethodForInit != null && this.hMT.getWriteData() != null) {
                this.hQc.runJsMethod(this.jsMethodForInit, "'" + this.hMT.getWriteData().getVcodeUrl() + "'");
                return true;
            }
            return false;
        } else if (str.equals("objc:jumpToFeedback()")) {
            WriteActivityConfig writeActivityConfig = new WriteActivityConfig(this.hQc.getContext().getActivity(), 0, TbConfig.getPositionPagerId(), TbConfig.getPositionPagerName(), null, null, 0, null, 13003, true, false, null, false, false, null, null, null, 0);
            writeActivityConfig.setIsVcodeFeedBack();
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, writeActivityConfig));
            return true;
        } else if (str.contains("objc:jsSubmit")) {
            return dealJsSubmit(com.baidu.tbadk.p.a.he(str));
        } else {
            return false;
        }
    }

    @Override // com.baidu.tieba.write.vcode.newVcode.a.b
    public void onPageFinished(WebView webView, String str) {
        if (this.hQc != null) {
            this.hQc.showWebViewDelay(500);
            if (this.mNeedShowErrorToastOnStart) {
                e.nr().postDelayed(this.mShowErrorTaostRunnable, 500L);
            }
        }
    }

    @Override // com.baidu.tieba.write.vcode.newVcode.a.b
    public void showErrorOnStart(boolean z, String str) {
        this.mNeedShowErrorToastOnStart = z;
        this.mErrorToastOnStart = str;
    }

    @Override // com.baidu.tieba.write.vcode.newVcode.a.b
    public void start(boolean z) {
        this.hQc.setRatio(1.2631578f);
        this.hQc.showWebView(false);
        String str = TbConfig.SERVER_ADDRESS_WEB_VIEW + "mo/q/captcha";
        if (z) {
            str = str + "?feedback=1";
        }
        this.hQc.getWebView().loadUrl(str);
    }

    @Override // com.baidu.tieba.write.vcode.newVcode.a.b
    public void onDestroy() {
        e.nr().removeCallbacks(this.mShowErrorTaostRunnable);
    }

    @Override // com.baidu.tieba.write.vcode.newVcode.a.b
    public void d(NewWriteModel.d dVar) {
        this.hQd = dVar;
    }

    @Override // com.baidu.tieba.write.vcode.newVcode.a.b
    public void onPostThreadCancle() {
        this.hQc.showPostThreadLoadingView(false);
        this.hMT.cancelLoadData();
    }

    @Override // com.baidu.tieba.write.vcode.newVcode.a.b
    public boolean bLA() {
        return this.hMU;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void refreshVCode() {
        this.hQc.runJsMethod(this.jsMethodForChangeVCode, "'" + this.hMT.getWriteData().getVcodeUrl() + "'");
    }

    private boolean dealJsSubmit(String str) {
        String[] split;
        if (StringUtils.isNull(str) || (split = str.split(Constants.ACCEPT_TIME_SEPARATOR_SP)) == null || split.length != 2) {
            return false;
        }
        this.jsMethodForChangeVCode = split[0];
        uQ(split[1]);
        return true;
    }

    private void uQ(String str) {
        this.hMU = false;
        if (!l.oZ()) {
            this.hQc.getContext().showToast(d.j.neterror);
            this.hQc.getContext().finish();
        } else if (!StringUtils.isNull(str)) {
            this.hQc.showPostThreadLoadingView(true);
            this.hMT.getWriteData().setVcode(str);
            this.hMT.getWriteData().setVcodeType("4");
            this.hMT.startPostWrite();
        } else {
            this.hQc.getContext().showToast(d.j.neterror);
            this.hQc.getContext().finish();
        }
    }
}
