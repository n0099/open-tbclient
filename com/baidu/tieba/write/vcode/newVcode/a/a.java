package com.baidu.tieba.write.vcode.newVcode.a;

import android.content.Intent;
import android.os.Bundle;
import android.webkit.WebView;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.lib.util.l;
import com.baidu.live.tbadk.core.data.RequestResponseCode;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.live.tbadk.data.Config;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.atomData.AccountAccessActivityConfig;
import com.baidu.tbadk.core.atomData.WriteActivityConfig;
import com.baidu.tbadk.core.data.AntiData;
import com.baidu.tbadk.coreExtra.data.WriteData;
import com.baidu.tbadk.coreExtra.data.y;
import com.baidu.tieba.R;
import com.baidu.tieba.tbadkCore.writeModel.NewWriteModel;
import com.baidu.tieba.tbadkCore.writeModel.PostWriteCallBackData;
import com.baidu.tieba.write.vcode.newVcode.NewVcodeView;
import com.xiaomi.mipush.sdk.Constants;
/* loaded from: classes3.dex */
public class a implements b {
    private PostWriteCallBackData hQF;
    private final NewWriteModel jOl;
    private final NewVcodeView jRK;
    private NewWriteModel.d jRL;
    private boolean jOm = false;
    private final NewWriteModel.d cHf = new NewWriteModel.d() { // from class: com.baidu.tieba.write.vcode.newVcode.a.a.1
        @Override // com.baidu.tieba.tbadkCore.writeModel.NewWriteModel.d
        public void callback(boolean z, PostWriteCallBackData postWriteCallBackData, y yVar, WriteData writeData, AntiData antiData) {
            String str;
            String str2;
            String str3 = null;
            if (a.this.jRK != null) {
                a.this.jRK.showPostThreadLoadingView(false);
                if (z) {
                    a.this.hQF = postWriteCallBackData;
                    a.this.jOm = true;
                    if (yVar == null || yVar.apu() == null) {
                        str = null;
                        str2 = null;
                    } else {
                        str2 = yVar.apu().endPoint;
                        str = yVar.apu().successImg;
                        str3 = yVar.apu().slideEndPoint;
                    }
                    a.this.jRK.runJsMethod("success", str + Constants.ACCEPT_TIME_SEPARATOR_SP + str2 + Constants.ACCEPT_TIME_SEPARATOR_SP + str3);
                } else if (postWriteCallBackData == null || postWriteCallBackData.getErrorCode() != 227001) {
                    if (a.this.jRL != null) {
                        a.this.jRL.callback(false, postWriteCallBackData, yVar, writeData, antiData);
                    }
                } else {
                    a.this.jRK.getContext().setVisible(false);
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AccountAccessActivityConfig(a.this.jRK.getContext().getActivity(), RequestResponseCode.REQUEST_VCODE, writeData, postWriteCallBackData.getAccessState())));
                }
            }
        }
    };

    public a(NewVcodeView newVcodeView, NewWriteModel newWriteModel) {
        this.jRK = newVcodeView;
        this.jOl = newWriteModel;
        this.jOl.b(this.cHf);
    }

    @Override // com.baidu.tieba.write.vcode.newVcode.a.b
    public boolean c(WebView webView, String str) {
        WriteData clc;
        if (this.jOl.clc() == null || StringUtils.isNull(str) || (clc = this.jOl.clc()) == null) {
            return false;
        }
        if (str.contains("objc:loadReady")) {
            if (clc.getVcodeExtra() == null) {
                return false;
            }
            this.jRK.runJsMethod("handleFreshCaptcha", "'" + clc.getVcodeUrl() + "','" + clc.getVcodeExtra().slideImg + "','" + clc.getVcodeExtra().textImg + "'");
            return true;
        } else if (str.contains("objc:jsChangePosition")) {
            FF(com.baidu.tbadk.v.a.qu(str));
            return true;
        } else if (str.contains("objc:finish")) {
            this.jOm = true;
            if (clc != null && clc.getVideoReviewType() == 1) {
                this.jRK.showToast(true, this.jRK.getContext().getResources().getString(R.string.video_send_success_under_review));
            } else if (clc != null && clc.getVideoReviewType() == 2) {
                this.jRK.showToast(true, this.jRK.getContext().getResources().getString(R.string.video_send_success));
            } else {
                String str2 = null;
                String str3 = null;
                String string = this.jRK.getContext().getResources().getString(R.string.send_success);
                if (this.hQF != null) {
                    str2 = this.hQF.getPreMsg();
                    str3 = this.hQF.getColorMsg();
                    string = this.hQF.getErrorString();
                }
                if (clc.getType() != 7) {
                    com.baidu.tieba.tbadkCore.writeModel.c.g(this.jRK.getContext().getActivity(), string, str2, str3);
                }
            }
            Intent intent = new Intent();
            Bundle bundle = new Bundle();
            bundle.putSerializable("post_write_callback_data", this.hQF);
            intent.putExtras(bundle);
            BaseActivity context = this.jRK.getContext();
            this.jRK.getContext();
            context.setResult(-1, intent);
            this.jRK.getContext().finish();
            return true;
        } else if (str.contains("objc:jumpToFeedback()")) {
            WriteActivityConfig writeActivityConfig = new WriteActivityConfig(this.jRK.getContext().getActivity(), 0, TbConfig.getPositionPagerId(), TbConfig.getPositionPagerName(), null, null, 0, null, RequestResponseCode.REQUEST_WRITE_NEW, true, false, null, false, false, null, null, null, 0);
            writeActivityConfig.setIsVcodeFeedBack();
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, writeActivityConfig));
            return true;
        } else {
            return false;
        }
    }

    @Override // com.baidu.tieba.write.vcode.newVcode.a.b
    public void onPageFinished(WebView webView, String str) {
        if (this.jRK != null) {
            this.jRK.showWebViewDelay(1000);
        }
    }

    @Override // com.baidu.tieba.write.vcode.newVcode.a.b
    public void A(boolean z, String str) {
    }

    @Override // com.baidu.tieba.write.vcode.newVcode.a.b
    public void start(boolean z) {
        this.jRK.setRatio(0.9433962f);
        this.jRK.showWebView(false);
        this.jRK.getWebView().loadUrl(TbConfig.SERVER_ADDRESS_WEB_VIEW + Config.DRAG_VCODE_WEBVIEW_ADDRESS);
    }

    @Override // com.baidu.tieba.write.vcode.newVcode.a.b
    public void onDestroy() {
    }

    @Override // com.baidu.tieba.write.vcode.newVcode.a.b
    public void d(NewWriteModel.d dVar) {
        this.jRL = dVar;
    }

    @Override // com.baidu.tieba.write.vcode.newVcode.a.b
    public void cxZ() {
        this.jRK.showPostThreadLoadingView(false);
        this.jOl.cancelLoadData();
    }

    private void FF(String str) {
        this.jOm = false;
        if (!l.isNetOk()) {
            this.jRK.getContext().showToast(R.string.neterror);
            this.jRK.getContext().finish();
        } else if (!StringUtils.isNull(str)) {
            this.jRK.showPostThreadLoadingView(true);
            this.jOl.clc().setVcode(str);
            this.jOl.clc().setVcodeType("5");
            this.jOl.cpE();
        } else {
            this.jRK.getContext().showToast(R.string.neterror);
            this.jRK.getContext().finish();
        }
    }
}
