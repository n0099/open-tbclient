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
import com.baidu.tbadk.coreExtra.data.ad;
import com.baidu.tieba.R;
import com.baidu.tieba.tbadkCore.writeModel.NewWriteModel;
import com.baidu.tieba.tbadkCore.writeModel.PostWriteCallBackData;
import com.baidu.tieba.write.vcode.newVcode.NewVcodeView;
import com.xiaomi.mipush.sdk.Constants;
/* loaded from: classes3.dex */
public class a implements b {
    private PostWriteCallBackData kqk;
    private final NewWriteModel muy;
    private final NewVcodeView myC;
    private NewWriteModel.d myD;
    private boolean muz = false;
    private final NewWriteModel.d eCe = new NewWriteModel.d() { // from class: com.baidu.tieba.write.vcode.newVcode.a.a.1
        @Override // com.baidu.tieba.tbadkCore.writeModel.NewWriteModel.d
        public void callback(boolean z, PostWriteCallBackData postWriteCallBackData, ad adVar, WriteData writeData, AntiData antiData) {
            String str;
            String str2;
            String str3 = null;
            if (a.this.myC != null) {
                a.this.myC.showPostThreadLoadingView(false);
                if (z) {
                    a.this.kqk = postWriteCallBackData;
                    a.this.muz = true;
                    if (adVar == null || adVar.bep() == null) {
                        str = null;
                        str2 = null;
                    } else {
                        str2 = adVar.bep().endPoint;
                        str = adVar.bep().successImg;
                        str3 = adVar.bep().slideEndPoint;
                    }
                    a.this.myC.runJsMethod("success", str + Constants.ACCEPT_TIME_SEPARATOR_SP + str2 + Constants.ACCEPT_TIME_SEPARATOR_SP + str3);
                } else if (postWriteCallBackData == null || postWriteCallBackData.getErrorCode() != 227001) {
                    if (a.this.myD != null) {
                        a.this.myD.callback(false, postWriteCallBackData, adVar, writeData, antiData);
                    }
                } else {
                    a.this.myC.getContext().setVisible(false);
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AccountAccessActivityConfig(a.this.myC.getContext().getActivity(), RequestResponseCode.REQUEST_VCODE, writeData, postWriteCallBackData.getAccessState())));
                }
            }
        }
    };

    public a(NewVcodeView newVcodeView, NewWriteModel newWriteModel) {
        this.myC = newVcodeView;
        this.muy = newWriteModel;
        this.muy.b(this.eCe);
    }

    @Override // com.baidu.tieba.write.vcode.newVcode.a.b
    public boolean c(WebView webView, String str) {
        WriteData dhF;
        if (this.muy.dhF() == null || StringUtils.isNull(str) || (dhF = this.muy.dhF()) == null) {
            return false;
        }
        if (str.contains("objc:loadReady")) {
            if (dhF.getVcodeExtra() == null) {
                return false;
            }
            this.myC.runJsMethod("handleFreshCaptcha", "'" + dhF.getVcodeUrl() + "','" + dhF.getVcodeExtra().slideImg + "','" + dhF.getVcodeExtra().textImg + "'");
            return true;
        } else if (str.contains("objc:jsChangePosition")) {
            PL(com.baidu.tbadk.t.a.Ax(str));
            return true;
        } else if (str.contains("objc:finish")) {
            this.muz = true;
            if (dhF != null && dhF.getVideoReviewType() == 1) {
                this.myC.showToast(true, this.myC.getContext().getResources().getString(R.string.video_send_success_under_review));
            } else if (dhF != null && dhF.getVideoReviewType() == 2) {
                this.myC.showToast(true, this.myC.getContext().getResources().getString(R.string.video_send_success));
            } else {
                String str2 = null;
                String str3 = null;
                String string = this.myC.getContext().getResources().getString(R.string.send_success);
                if (this.kqk != null) {
                    str2 = this.kqk.getPreMsg();
                    str3 = this.kqk.getColorMsg();
                    string = this.kqk.getErrorString();
                }
                if (dhF.getType() != 7) {
                    com.baidu.tieba.tbadkCore.writeModel.c.f(this.myC.getContext().getActivity(), string, str2, str3);
                }
            }
            Intent intent = new Intent();
            Bundle bundle = new Bundle();
            bundle.putSerializable("post_write_callback_data", this.kqk);
            intent.putExtras(bundle);
            BaseActivity context = this.myC.getContext();
            this.myC.getContext();
            context.setResult(-1, intent);
            this.myC.getContext().finish();
            return true;
        } else if (str.contains("objc:jumpToFeedback()")) {
            WriteActivityConfig writeActivityConfig = new WriteActivityConfig(this.myC.getContext().getActivity(), 0, TbConfig.getPositionPagerId(), TbConfig.getPositionPagerName(), null, null, 0, null, RequestResponseCode.REQUEST_WRITE_NEW, true, false, null, false, false, null, null, null, 0);
            writeActivityConfig.setIsVcodeFeedBack();
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, writeActivityConfig));
            return true;
        } else {
            return false;
        }
    }

    @Override // com.baidu.tieba.write.vcode.newVcode.a.b
    public void onPageFinished(WebView webView, String str) {
        if (this.myC != null) {
            this.myC.showWebViewDelay(1000);
        }
    }

    @Override // com.baidu.tieba.write.vcode.newVcode.a.b
    public void D(boolean z, String str) {
    }

    @Override // com.baidu.tieba.write.vcode.newVcode.a.b
    public void start(boolean z) {
        this.myC.setRatio(0.9433962f);
        this.myC.showWebView(false);
        this.myC.getWebView().loadUrl(TbConfig.SERVER_ADDRESS_WEB_VIEW + Config.DRAG_VCODE_WEBVIEW_ADDRESS);
    }

    @Override // com.baidu.tieba.write.vcode.newVcode.a.b
    public void onDestroy() {
    }

    @Override // com.baidu.tieba.write.vcode.newVcode.a.b
    public void d(NewWriteModel.d dVar) {
        this.myD = dVar;
    }

    @Override // com.baidu.tieba.write.vcode.newVcode.a.b
    public void dur() {
        this.myC.showPostThreadLoadingView(false);
        this.muy.cancelLoadData();
    }

    private void PL(String str) {
        this.muz = false;
        if (!l.isNetOk()) {
            this.myC.getContext().showToast(R.string.neterror);
            this.myC.getContext().finish();
        } else if (!StringUtils.isNull(str)) {
            this.myC.showPostThreadLoadingView(true);
            this.muy.dhF().setVcode(str);
            this.muy.dhF().setVcodeType("5");
            this.muy.dmw();
        } else {
            this.myC.getContext().showToast(R.string.neterror);
            this.myC.getContext().finish();
        }
    }
}
