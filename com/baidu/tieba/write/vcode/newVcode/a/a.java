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
    private PostWriteCallBackData hPO;
    private final NewWriteModel jNu;
    private final NewVcodeView jQT;
    private NewWriteModel.d jQU;
    private boolean jNv = false;
    private final NewWriteModel.d cGo = new NewWriteModel.d() { // from class: com.baidu.tieba.write.vcode.newVcode.a.a.1
        @Override // com.baidu.tieba.tbadkCore.writeModel.NewWriteModel.d
        public void callback(boolean z, PostWriteCallBackData postWriteCallBackData, y yVar, WriteData writeData, AntiData antiData) {
            String str;
            String str2;
            String str3 = null;
            if (a.this.jQT != null) {
                a.this.jQT.showPostThreadLoadingView(false);
                if (z) {
                    a.this.hPO = postWriteCallBackData;
                    a.this.jNv = true;
                    if (yVar == null || yVar.aps() == null) {
                        str = null;
                        str2 = null;
                    } else {
                        str2 = yVar.aps().endPoint;
                        str = yVar.aps().successImg;
                        str3 = yVar.aps().slideEndPoint;
                    }
                    a.this.jQT.runJsMethod("success", str + Constants.ACCEPT_TIME_SEPARATOR_SP + str2 + Constants.ACCEPT_TIME_SEPARATOR_SP + str3);
                } else if (postWriteCallBackData == null || postWriteCallBackData.getErrorCode() != 227001) {
                    if (a.this.jQU != null) {
                        a.this.jQU.callback(false, postWriteCallBackData, yVar, writeData, antiData);
                    }
                } else {
                    a.this.jQT.getContext().setVisible(false);
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AccountAccessActivityConfig(a.this.jQT.getContext().getActivity(), RequestResponseCode.REQUEST_VCODE, writeData, postWriteCallBackData.getAccessState())));
                }
            }
        }
    };

    public a(NewVcodeView newVcodeView, NewWriteModel newWriteModel) {
        this.jQT = newVcodeView;
        this.jNu = newWriteModel;
        this.jNu.b(this.cGo);
    }

    @Override // com.baidu.tieba.write.vcode.newVcode.a.b
    public boolean c(WebView webView, String str) {
        WriteData cla;
        if (this.jNu.cla() == null || StringUtils.isNull(str) || (cla = this.jNu.cla()) == null) {
            return false;
        }
        if (str.contains("objc:loadReady")) {
            if (cla.getVcodeExtra() == null) {
                return false;
            }
            this.jQT.runJsMethod("handleFreshCaptcha", "'" + cla.getVcodeUrl() + "','" + cla.getVcodeExtra().slideImg + "','" + cla.getVcodeExtra().textImg + "'");
            return true;
        } else if (str.contains("objc:jsChangePosition")) {
            FF(com.baidu.tbadk.v.a.qu(str));
            return true;
        } else if (str.contains("objc:finish")) {
            this.jNv = true;
            if (cla != null && cla.getVideoReviewType() == 1) {
                this.jQT.showToast(true, this.jQT.getContext().getResources().getString(R.string.video_send_success_under_review));
            } else if (cla != null && cla.getVideoReviewType() == 2) {
                this.jQT.showToast(true, this.jQT.getContext().getResources().getString(R.string.video_send_success));
            } else {
                String str2 = null;
                String str3 = null;
                String string = this.jQT.getContext().getResources().getString(R.string.send_success);
                if (this.hPO != null) {
                    str2 = this.hPO.getPreMsg();
                    str3 = this.hPO.getColorMsg();
                    string = this.hPO.getErrorString();
                }
                if (cla.getType() != 7) {
                    com.baidu.tieba.tbadkCore.writeModel.c.g(this.jQT.getContext().getActivity(), string, str2, str3);
                }
            }
            Intent intent = new Intent();
            Bundle bundle = new Bundle();
            bundle.putSerializable("post_write_callback_data", this.hPO);
            intent.putExtras(bundle);
            BaseActivity context = this.jQT.getContext();
            this.jQT.getContext();
            context.setResult(-1, intent);
            this.jQT.getContext().finish();
            return true;
        } else if (str.contains("objc:jumpToFeedback()")) {
            WriteActivityConfig writeActivityConfig = new WriteActivityConfig(this.jQT.getContext().getActivity(), 0, TbConfig.getPositionPagerId(), TbConfig.getPositionPagerName(), null, null, 0, null, RequestResponseCode.REQUEST_WRITE_NEW, true, false, null, false, false, null, null, null, 0);
            writeActivityConfig.setIsVcodeFeedBack();
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, writeActivityConfig));
            return true;
        } else {
            return false;
        }
    }

    @Override // com.baidu.tieba.write.vcode.newVcode.a.b
    public void onPageFinished(WebView webView, String str) {
        if (this.jQT != null) {
            this.jQT.showWebViewDelay(1000);
        }
    }

    @Override // com.baidu.tieba.write.vcode.newVcode.a.b
    public void A(boolean z, String str) {
    }

    @Override // com.baidu.tieba.write.vcode.newVcode.a.b
    public void start(boolean z) {
        this.jQT.setRatio(0.9433962f);
        this.jQT.showWebView(false);
        this.jQT.getWebView().loadUrl(TbConfig.SERVER_ADDRESS_WEB_VIEW + Config.DRAG_VCODE_WEBVIEW_ADDRESS);
    }

    @Override // com.baidu.tieba.write.vcode.newVcode.a.b
    public void onDestroy() {
    }

    @Override // com.baidu.tieba.write.vcode.newVcode.a.b
    public void d(NewWriteModel.d dVar) {
        this.jQU = dVar;
    }

    @Override // com.baidu.tieba.write.vcode.newVcode.a.b
    public void cxX() {
        this.jQT.showPostThreadLoadingView(false);
        this.jNu.cancelLoadData();
    }

    private void FF(String str) {
        this.jNv = false;
        if (!l.isNetOk()) {
            this.jQT.getContext().showToast(R.string.neterror);
            this.jQT.getContext().finish();
        } else if (!StringUtils.isNull(str)) {
            this.jQT.showPostThreadLoadingView(true);
            this.jNu.cla().setVcode(str);
            this.jNu.cla().setVcodeType("5");
            this.jNu.cpC();
        } else {
            this.jQT.getContext().showToast(R.string.neterror);
            this.jQT.getContext().finish();
        }
    }
}
