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
/* loaded from: classes10.dex */
public class a implements b {
    private PostWriteCallBackData iEv;
    private final NewWriteModel kIi;
    private final NewVcodeView kLF;
    private NewWriteModel.d kLG;
    private boolean kIj = false;
    private final NewWriteModel.d dui = new NewWriteModel.d() { // from class: com.baidu.tieba.write.vcode.newVcode.a.a.1
        @Override // com.baidu.tieba.tbadkCore.writeModel.NewWriteModel.d
        public void callback(boolean z, PostWriteCallBackData postWriteCallBackData, y yVar, WriteData writeData, AntiData antiData) {
            String str;
            String str2;
            String str3 = null;
            if (a.this.kLF != null) {
                a.this.kLF.showPostThreadLoadingView(false);
                if (z) {
                    a.this.iEv = postWriteCallBackData;
                    a.this.kIj = true;
                    if (yVar == null || yVar.aGR() == null) {
                        str = null;
                        str2 = null;
                    } else {
                        str2 = yVar.aGR().endPoint;
                        str = yVar.aGR().successImg;
                        str3 = yVar.aGR().slideEndPoint;
                    }
                    a.this.kLF.runJsMethod("success", str + Constants.ACCEPT_TIME_SEPARATOR_SP + str2 + Constants.ACCEPT_TIME_SEPARATOR_SP + str3);
                } else if (postWriteCallBackData == null || postWriteCallBackData.getErrorCode() != 227001) {
                    if (a.this.kLG != null) {
                        a.this.kLG.callback(false, postWriteCallBackData, yVar, writeData, antiData);
                    }
                } else {
                    a.this.kLF.getContext().setVisible(false);
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AccountAccessActivityConfig(a.this.kLF.getContext().getActivity(), RequestResponseCode.REQUEST_VCODE, writeData, postWriteCallBackData.getAccessState())));
                }
            }
        }
    };

    public a(NewVcodeView newVcodeView, NewWriteModel newWriteModel) {
        this.kLF = newVcodeView;
        this.kIi = newWriteModel;
        this.kIi.b(this.dui);
    }

    @Override // com.baidu.tieba.write.vcode.newVcode.a.b
    public boolean c(WebView webView, String str) {
        WriteData cFi;
        if (this.kIi.cFi() == null || StringUtils.isNull(str) || (cFi = this.kIi.cFi()) == null) {
            return false;
        }
        if (str.contains("objc:loadReady")) {
            if (cFi.getVcodeExtra() == null) {
                return false;
            }
            this.kLF.runJsMethod("handleFreshCaptcha", "'" + cFi.getVcodeUrl() + "','" + cFi.getVcodeExtra().slideImg + "','" + cFi.getVcodeExtra().textImg + "'");
            return true;
        } else if (str.contains("objc:jsChangePosition")) {
            Kx(com.baidu.tbadk.s.a.vA(str));
            return true;
        } else if (str.contains("objc:finish")) {
            this.kIj = true;
            if (cFi != null && cFi.getVideoReviewType() == 1) {
                this.kLF.showToast(true, this.kLF.getContext().getResources().getString(R.string.video_send_success_under_review));
            } else if (cFi != null && cFi.getVideoReviewType() == 2) {
                this.kLF.showToast(true, this.kLF.getContext().getResources().getString(R.string.video_send_success));
            } else {
                String str2 = null;
                String str3 = null;
                String string = this.kLF.getContext().getResources().getString(R.string.send_success);
                if (this.iEv != null) {
                    str2 = this.iEv.getPreMsg();
                    str3 = this.iEv.getColorMsg();
                    string = this.iEv.getErrorString();
                }
                if (cFi.getType() != 7) {
                    com.baidu.tieba.tbadkCore.writeModel.c.f(this.kLF.getContext().getActivity(), string, str2, str3);
                }
            }
            Intent intent = new Intent();
            Bundle bundle = new Bundle();
            bundle.putSerializable("post_write_callback_data", this.iEv);
            intent.putExtras(bundle);
            BaseActivity context = this.kLF.getContext();
            this.kLF.getContext();
            context.setResult(-1, intent);
            this.kLF.getContext().finish();
            return true;
        } else if (str.contains("objc:jumpToFeedback()")) {
            WriteActivityConfig writeActivityConfig = new WriteActivityConfig(this.kLF.getContext().getActivity(), 0, TbConfig.getPositionPagerId(), TbConfig.getPositionPagerName(), null, null, 0, null, RequestResponseCode.REQUEST_WRITE_NEW, true, false, null, false, false, null, null, null, 0);
            writeActivityConfig.setIsVcodeFeedBack();
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, writeActivityConfig));
            return true;
        } else {
            return false;
        }
    }

    @Override // com.baidu.tieba.write.vcode.newVcode.a.b
    public void onPageFinished(WebView webView, String str) {
        if (this.kLF != null) {
            this.kLF.showWebViewDelay(1000);
        }
    }

    @Override // com.baidu.tieba.write.vcode.newVcode.a.b
    public void A(boolean z, String str) {
    }

    @Override // com.baidu.tieba.write.vcode.newVcode.a.b
    public void start(boolean z) {
        this.kLF.setRatio(0.9433962f);
        this.kLF.showWebView(false);
        this.kLF.getWebView().loadUrl(TbConfig.SERVER_ADDRESS_WEB_VIEW + Config.DRAG_VCODE_WEBVIEW_ADDRESS);
    }

    @Override // com.baidu.tieba.write.vcode.newVcode.a.b
    public void onDestroy() {
    }

    @Override // com.baidu.tieba.write.vcode.newVcode.a.b
    public void d(NewWriteModel.d dVar) {
        this.kLG = dVar;
    }

    @Override // com.baidu.tieba.write.vcode.newVcode.a.b
    public void cRZ() {
        this.kLF.showPostThreadLoadingView(false);
        this.kIi.cancelLoadData();
    }

    private void Kx(String str) {
        this.kIj = false;
        if (!l.isNetOk()) {
            this.kLF.getContext().showToast(R.string.neterror);
            this.kLF.getContext().finish();
        } else if (!StringUtils.isNull(str)) {
            this.kLF.showPostThreadLoadingView(true);
            this.kIi.cFi().setVcode(str);
            this.kIi.cFi().setVcodeType("5");
            this.kIi.cJG();
        } else {
            this.kLF.getContext().showToast(R.string.neterror);
            this.kLF.getContext().finish();
        }
    }
}
