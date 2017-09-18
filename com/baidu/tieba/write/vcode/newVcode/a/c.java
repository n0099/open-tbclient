package com.baidu.tieba.write.vcode.newVcode.a;

import android.content.Intent;
import android.os.Bundle;
import android.webkit.WebView;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.lib.g.e;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.lib.util.k;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.atomData.AccountAccessActivityConfig;
import com.baidu.tbadk.core.atomData.WriteActivityConfig;
import com.baidu.tbadk.core.data.AntiData;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.coreExtra.data.WriteData;
import com.baidu.tbadk.coreExtra.data.q;
import com.baidu.tieba.d;
import com.baidu.tieba.tbadkCore.writeModel.NewWriteModel;
import com.baidu.tieba.tbadkCore.writeModel.PostWriteCallBackData;
import com.baidu.tieba.write.vcode.newVcode.NewVcodeView;
import com.xiaomi.mipush.sdk.Constants;
/* loaded from: classes2.dex */
public class c implements b {
    private final NewWriteModel gBj;
    private final NewVcodeView gEx;
    private String jsMethodForChangeVCode;
    private String jsMethodForInit;
    private boolean mNeedShowErrorToastOnStart = false;
    private String mErrorToastOnStart = null;
    private boolean gBk = false;
    private Runnable mShowErrorTaostRunnable = new Runnable() { // from class: com.baidu.tieba.write.vcode.newVcode.a.c.1
        @Override // java.lang.Runnable
        public void run() {
            if (c.this.gEx != null) {
                if (StringUtils.isNull(c.this.mErrorToastOnStart)) {
                    c.this.gEx.showToast(false, c.this.gEx.getContext().getResources().getString(d.l.drag_vcode_error));
                } else {
                    c.this.gEx.showToast(false, c.this.mErrorToastOnStart);
                }
            }
        }
    };
    private final NewWriteModel.d aDB = new NewWriteModel.d() { // from class: com.baidu.tieba.write.vcode.newVcode.a.c.2
        @Override // com.baidu.tieba.tbadkCore.writeModel.NewWriteModel.d
        public void callback(boolean z, PostWriteCallBackData postWriteCallBackData, q qVar, WriteData writeData, AntiData antiData) {
            String str;
            String str2 = null;
            c.this.gEx.showPostThreadLoadingView(false);
            if (c.this.gEx != null) {
                if (z) {
                    c.this.gBk = true;
                    if (writeData != null && writeData.getVideoReviewType() == 1) {
                        if (writeData.getIsStory() != 1) {
                            c.this.gEx.showToast(true, c.this.gEx.getContext().getResources().getString(d.l.video_send_success_under_review));
                        }
                    } else if (writeData != null && writeData.getVideoReviewType() == 2) {
                        if (writeData.getIsStory() != 1) {
                            c.this.gEx.showToast(true, c.this.gEx.getContext().getResources().getString(d.l.video_send_success));
                        }
                    } else if (writeData != null && writeData.getIsStory() != 1) {
                        String string = c.this.gEx.getContext().getResources().getString(d.l.send_success);
                        if (postWriteCallBackData != null) {
                            str = postWriteCallBackData.getPreMsg();
                            str2 = postWriteCallBackData.getColorMsg();
                            string = postWriteCallBackData.getErrorString();
                        } else {
                            str = null;
                        }
                        if (writeData.getType() != 7) {
                            com.baidu.tieba.tbadkCore.writeModel.c.c(c.this.gEx.getContext().getActivity(), string, str, str2);
                        }
                    }
                    Intent intent = new Intent();
                    Bundle bundle = new Bundle();
                    bundle.putSerializable(WriteActivityConfig.POST_WRITE_CALLBACK_DATA, postWriteCallBackData);
                    intent.putExtras(bundle);
                    BaseActivity context = c.this.gEx.getContext();
                    c.this.gEx.getContext();
                    context.setResult(-1, intent);
                    c.this.gEx.getContext().finish();
                } else if (postWriteCallBackData != null && postWriteCallBackData.getErrorCode() == 227001) {
                    c.this.gEx.getContext().setVisible(false);
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AccountAccessActivityConfig(c.this.gEx.getContext().getActivity(), 12006, writeData, postWriteCallBackData.getAccessState())));
                } else if (postWriteCallBackData != null) {
                    if (writeData != null && writeData.getIsStory() != 1) {
                        if (StringUtils.isNull(postWriteCallBackData.getErrorString())) {
                            c.this.gEx.showToast(false, c.this.gEx.getContext().getResources().getString(d.l.input_vcode_error));
                        } else {
                            c.this.gEx.showToast(false, postWriteCallBackData.getErrorString());
                        }
                    }
                    c.this.refreshVCode();
                }
            }
        }
    };

    public c(NewVcodeView newVcodeView, NewWriteModel newWriteModel) {
        this.gEx = newVcodeView;
        this.gBj = newWriteModel;
        this.gBj.b(this.aDB);
    }

    @Override // com.baidu.tieba.write.vcode.newVcode.a.b
    public boolean onUrlLoad(WebView webView, String str) {
        if (str.contains("objc:jsChangeVcode")) {
            this.jsMethodForInit = com.baidu.tbadk.q.a.gW(str);
            if (this.jsMethodForInit != null && this.gBj.getWriteData() != null) {
                this.gEx.runJsMethod(this.jsMethodForInit, "'" + this.gBj.getWriteData().getVcodeUrl() + "'");
                return true;
            }
            return false;
        } else if (str.equals("objc:jumpToFeedback()")) {
            WriteActivityConfig writeActivityConfig = new WriteActivityConfig(this.gEx.getContext().getActivity(), 0, TbConfig.getPositionPagerId(), TbConfig.getPositionPagerName(), null, null, 0, null, 13003, true, false, null, false, false, null, null, null, 0);
            writeActivityConfig.setIsVcodeFeedBack();
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, writeActivityConfig));
            return true;
        } else if (str.contains("objc:jsSubmit")) {
            return dealJsSubmit(com.baidu.tbadk.q.a.gW(str));
        } else {
            return false;
        }
    }

    @Override // com.baidu.tieba.write.vcode.newVcode.a.b
    public void onPageFinished(WebView webView, String str) {
        if (this.gEx != null) {
            this.gEx.showWebViewDelay(500);
            if (this.mNeedShowErrorToastOnStart) {
                e.fQ().postDelayed(this.mShowErrorTaostRunnable, 500L);
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
        this.gEx.setRatio(1.2631578f);
        this.gEx.showWebView(false);
        String str = TbConfig.SERVER_ADDRESS_WEB_VIEW + "mo/q/captcha";
        if (z) {
            str = str + "?feedback=1";
        }
        this.gEx.getWebView().loadUrl(str);
    }

    @Override // com.baidu.tieba.write.vcode.newVcode.a.b
    public void onDestroy() {
        e.fQ().removeCallbacks(this.mShowErrorTaostRunnable);
    }

    @Override // com.baidu.tieba.write.vcode.newVcode.a.b
    public void d(NewWriteModel.d dVar) {
    }

    @Override // com.baidu.tieba.write.vcode.newVcode.a.b
    public void onPostThreadCancle() {
        this.gEx.showPostThreadLoadingView(false);
        this.gBj.cancelLoadData();
    }

    @Override // com.baidu.tieba.write.vcode.newVcode.a.b
    public boolean bxM() {
        return this.gBk;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void refreshVCode() {
        this.gEx.runJsMethod(this.jsMethodForChangeVCode, "'" + this.gBj.getWriteData().getVcodeUrl() + "'");
    }

    private boolean dealJsSubmit(String str) {
        String[] split;
        if (StringUtils.isNull(str) || (split = str.split(Constants.ACCEPT_TIME_SEPARATOR_SP)) == null || split.length != 2) {
            return false;
        }
        this.jsMethodForChangeVCode = split[0];
        rH(split[1]);
        return true;
    }

    private void rH(String str) {
        this.gBk = false;
        if (!k.hz()) {
            this.gEx.getContext().showToast(d.l.neterror);
            this.gEx.getContext().finish();
        } else if (!StringUtils.isNull(str)) {
            this.gEx.showPostThreadLoadingView(true);
            this.gBj.getWriteData().setVcode(str);
            this.gBj.getWriteData().setVcodeType("4");
            this.gBj.startPostWrite();
        } else {
            this.gEx.getContext().showToast(d.l.neterror);
            this.gEx.getContext().finish();
        }
    }
}
