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
import com.baidu.tbadk.coreExtra.data.ah;
import com.baidu.tieba.R;
import com.baidu.tieba.tbadkCore.writeModel.NewWriteModel;
import com.baidu.tieba.tbadkCore.writeModel.PostWriteCallBackData;
import com.baidu.tieba.write.vcode.newVcode.NewVcodeView;
import com.xiaomi.mipush.sdk.Constants;
/* loaded from: classes3.dex */
public class a implements b {
    private PostWriteCallBackData lvW;
    private final NewWriteModel nEW;
    private final NewVcodeView nIW;
    private NewWriteModel.d nIX;
    private boolean nEX = false;
    private final NewWriteModel.d fpW = new NewWriteModel.d() { // from class: com.baidu.tieba.write.vcode.newVcode.a.a.1
        @Override // com.baidu.tieba.tbadkCore.writeModel.NewWriteModel.d
        public void callback(boolean z, PostWriteCallBackData postWriteCallBackData, ah ahVar, WriteData writeData, AntiData antiData) {
            String str;
            String str2;
            String str3 = null;
            if (a.this.nIW != null) {
                a.this.nIW.showPostThreadLoadingView(false);
                if (z) {
                    a.this.lvW = postWriteCallBackData;
                    a.this.nEX = true;
                    if (ahVar == null || ahVar.buW() == null) {
                        str = null;
                        str2 = null;
                    } else {
                        str2 = ahVar.buW().endPoint;
                        str = ahVar.buW().successImg;
                        str3 = ahVar.buW().slideEndPoint;
                    }
                    a.this.nIW.runJsMethod("success", str + Constants.ACCEPT_TIME_SEPARATOR_SP + str2 + Constants.ACCEPT_TIME_SEPARATOR_SP + str3);
                } else if (postWriteCallBackData == null || postWriteCallBackData.getErrorCode() != 227001) {
                    if (a.this.nIX != null) {
                        a.this.nIX.callback(false, postWriteCallBackData, ahVar, writeData, antiData);
                    }
                } else {
                    a.this.nIW.getContext().setVisible(false);
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AccountAccessActivityConfig(a.this.nIW.getContext().getActivity(), RequestResponseCode.REQUEST_VCODE, writeData, postWriteCallBackData.getAccessState())));
                }
            }
        }
    };

    public a(NewVcodeView newVcodeView, NewWriteModel newWriteModel) {
        this.nIW = newVcodeView;
        this.nEW = newWriteModel;
        this.nEW.b(this.fpW);
    }

    @Override // com.baidu.tieba.write.vcode.newVcode.a.b
    public boolean b(WebView webView, String str) {
        WriteData cXW;
        if (this.nEW.cXW() == null || StringUtils.isNull(str) || (cXW = this.nEW.cXW()) == null) {
            return false;
        }
        if (str.contains("objc:loadReady")) {
            if (cXW.getVcodeExtra() == null) {
                return false;
            }
            this.nIW.runJsMethod("handleFreshCaptcha", "'" + cXW.getVcodeUrl() + "','" + cXW.getVcodeExtra().slideImg + "','" + cXW.getVcodeExtra().textImg + "'");
            return true;
        } else if (str.contains("objc:jsChangePosition")) {
            UN(com.baidu.tbadk.t.a.ED(str));
            return true;
        } else if (str.contains("objc:finish")) {
            this.nEX = true;
            if (cXW != null && cXW.getVideoReviewType() == 1) {
                this.nIW.showToast(true, this.nIW.getContext().getResources().getString(R.string.video_send_success_under_review));
            } else if (cXW != null && cXW.getVideoReviewType() == 2) {
                this.nIW.showToast(true, this.nIW.getContext().getResources().getString(R.string.video_send_success));
            } else {
                String str2 = null;
                String str3 = null;
                String string = this.nIW.getContext().getResources().getString(R.string.send_success);
                if (this.lvW != null) {
                    str2 = this.lvW.getPreMsg();
                    str3 = this.lvW.getColorMsg();
                    string = this.lvW.getErrorString();
                }
                if (cXW.getType() != 7) {
                    com.baidu.tieba.tbadkCore.writeModel.c.g(this.nIW.getContext().getActivity(), string, str2, str3);
                }
            }
            Intent intent = new Intent();
            Bundle bundle = new Bundle();
            bundle.putSerializable("post_write_callback_data", this.lvW);
            intent.putExtras(bundle);
            BaseActivity context = this.nIW.getContext();
            this.nIW.getContext();
            context.setResult(-1, intent);
            this.nIW.getContext().finish();
            return true;
        } else if (str.contains("objc:jumpToFeedback()")) {
            WriteActivityConfig writeActivityConfig = new WriteActivityConfig(this.nIW.getContext().getActivity(), 0, TbConfig.getPositionPagerId(), TbConfig.getPositionPagerName(), null, null, 0, null, RequestResponseCode.REQUEST_WRITE_NEW, true, false, null, false, false, null, null, null, 0);
            writeActivityConfig.setIsVcodeFeedBack();
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, writeActivityConfig));
            return true;
        } else {
            return false;
        }
    }

    @Override // com.baidu.tieba.write.vcode.newVcode.a.b
    public void onPageFinished(WebView webView, String str) {
        if (this.nIW != null) {
            this.nIW.showWebViewDelay(1000);
        }
    }

    @Override // com.baidu.tieba.write.vcode.newVcode.a.b
    public void G(boolean z, String str) {
    }

    @Override // com.baidu.tieba.write.vcode.newVcode.a.b
    public void start(boolean z) {
        this.nIW.setRatio(0.9433962f);
        this.nIW.showWebView(false);
        this.nIW.getWebView().loadUrl(TbConfig.SERVER_ADDRESS_WEB_VIEW + Config.DRAG_VCODE_WEBVIEW_ADDRESS);
    }

    @Override // com.baidu.tieba.write.vcode.newVcode.a.b
    public void onDestroy() {
    }

    @Override // com.baidu.tieba.write.vcode.newVcode.a.b
    public void d(NewWriteModel.d dVar) {
        this.nIX = dVar;
    }

    @Override // com.baidu.tieba.write.vcode.newVcode.a.b
    public void dTl() {
        this.nIW.showPostThreadLoadingView(false);
        this.nEW.cancelLoadData();
    }

    private void UN(String str) {
        this.nEX = false;
        if (!l.isNetOk()) {
            this.nIW.getContext().showToast(R.string.neterror);
            this.nIW.getContext().finish();
        } else if (!StringUtils.isNull(str)) {
            this.nIW.showPostThreadLoadingView(true);
            this.nEW.cXW().setVcode(str);
            this.nEW.cXW().setVcodeType("5");
            this.nEW.dLm();
        } else {
            this.nIW.getContext().showToast(R.string.neterror);
            this.nIW.getContext().finish();
        }
    }
}
