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
/* loaded from: classes2.dex */
public class a implements b {
    private PostWriteCallBackData khu;
    private final NewWriteModel mmy;
    private final NewVcodeView mqD;
    private NewWriteModel.d mqE;
    private boolean mmz = false;
    private final NewWriteModel.d evL = new NewWriteModel.d() { // from class: com.baidu.tieba.write.vcode.newVcode.a.a.1
        @Override // com.baidu.tieba.tbadkCore.writeModel.NewWriteModel.d
        public void callback(boolean z, PostWriteCallBackData postWriteCallBackData, ad adVar, WriteData writeData, AntiData antiData) {
            String str;
            String str2;
            String str3 = null;
            if (a.this.mqD != null) {
                a.this.mqD.showPostThreadLoadingView(false);
                if (z) {
                    a.this.khu = postWriteCallBackData;
                    a.this.mmz = true;
                    if (adVar == null || adVar.bas() == null) {
                        str = null;
                        str2 = null;
                    } else {
                        str2 = adVar.bas().endPoint;
                        str = adVar.bas().successImg;
                        str3 = adVar.bas().slideEndPoint;
                    }
                    a.this.mqD.runJsMethod("success", str + Constants.ACCEPT_TIME_SEPARATOR_SP + str2 + Constants.ACCEPT_TIME_SEPARATOR_SP + str3);
                } else if (postWriteCallBackData == null || postWriteCallBackData.getErrorCode() != 227001) {
                    if (a.this.mqE != null) {
                        a.this.mqE.callback(false, postWriteCallBackData, adVar, writeData, antiData);
                    }
                } else {
                    a.this.mqD.getContext().setVisible(false);
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AccountAccessActivityConfig(a.this.mqD.getContext().getActivity(), RequestResponseCode.REQUEST_VCODE, writeData, postWriteCallBackData.getAccessState())));
                }
            }
        }
    };

    public a(NewVcodeView newVcodeView, NewWriteModel newWriteModel) {
        this.mqD = newVcodeView;
        this.mmy = newWriteModel;
        this.mmy.b(this.evL);
    }

    @Override // com.baidu.tieba.write.vcode.newVcode.a.b
    public boolean c(WebView webView, String str) {
        WriteData dew;
        if (this.mmy.dew() == null || StringUtils.isNull(str) || (dew = this.mmy.dew()) == null) {
            return false;
        }
        if (str.contains("objc:loadReady")) {
            if (dew.getVcodeExtra() == null) {
                return false;
            }
            this.mqD.runJsMethod("handleFreshCaptcha", "'" + dew.getVcodeUrl() + "','" + dew.getVcodeExtra().slideImg + "','" + dew.getVcodeExtra().textImg + "'");
            return true;
        } else if (str.contains("objc:jsChangePosition")) {
            Pa(com.baidu.tbadk.t.a.zp(str));
            return true;
        } else if (str.contains("objc:finish")) {
            this.mmz = true;
            if (dew != null && dew.getVideoReviewType() == 1) {
                this.mqD.showToast(true, this.mqD.getContext().getResources().getString(R.string.video_send_success_under_review));
            } else if (dew != null && dew.getVideoReviewType() == 2) {
                this.mqD.showToast(true, this.mqD.getContext().getResources().getString(R.string.video_send_success));
            } else {
                String str2 = null;
                String str3 = null;
                String string = this.mqD.getContext().getResources().getString(R.string.send_success);
                if (this.khu != null) {
                    str2 = this.khu.getPreMsg();
                    str3 = this.khu.getColorMsg();
                    string = this.khu.getErrorString();
                }
                if (dew.getType() != 7) {
                    com.baidu.tieba.tbadkCore.writeModel.c.f(this.mqD.getContext().getActivity(), string, str2, str3);
                }
            }
            Intent intent = new Intent();
            Bundle bundle = new Bundle();
            bundle.putSerializable("post_write_callback_data", this.khu);
            intent.putExtras(bundle);
            BaseActivity context = this.mqD.getContext();
            this.mqD.getContext();
            context.setResult(-1, intent);
            this.mqD.getContext().finish();
            return true;
        } else if (str.contains("objc:jumpToFeedback()")) {
            WriteActivityConfig writeActivityConfig = new WriteActivityConfig(this.mqD.getContext().getActivity(), 0, TbConfig.getPositionPagerId(), TbConfig.getPositionPagerName(), null, null, 0, null, RequestResponseCode.REQUEST_WRITE_NEW, true, false, null, false, false, null, null, null, 0);
            writeActivityConfig.setIsVcodeFeedBack();
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, writeActivityConfig));
            return true;
        } else {
            return false;
        }
    }

    @Override // com.baidu.tieba.write.vcode.newVcode.a.b
    public void onPageFinished(WebView webView, String str) {
        if (this.mqD != null) {
            this.mqD.showWebViewDelay(1000);
        }
    }

    @Override // com.baidu.tieba.write.vcode.newVcode.a.b
    public void D(boolean z, String str) {
    }

    @Override // com.baidu.tieba.write.vcode.newVcode.a.b
    public void start(boolean z) {
        this.mqD.setRatio(0.9433962f);
        this.mqD.showWebView(false);
        this.mqD.getWebView().loadUrl(TbConfig.SERVER_ADDRESS_WEB_VIEW + Config.DRAG_VCODE_WEBVIEW_ADDRESS);
    }

    @Override // com.baidu.tieba.write.vcode.newVcode.a.b
    public void onDestroy() {
    }

    @Override // com.baidu.tieba.write.vcode.newVcode.a.b
    public void d(NewWriteModel.d dVar) {
        this.mqE = dVar;
    }

    @Override // com.baidu.tieba.write.vcode.newVcode.a.b
    public void drf() {
        this.mqD.showPostThreadLoadingView(false);
        this.mmy.cancelLoadData();
    }

    private void Pa(String str) {
        this.mmz = false;
        if (!l.isNetOk()) {
            this.mqD.getContext().showToast(R.string.neterror);
            this.mqD.getContext().finish();
        } else if (!StringUtils.isNull(str)) {
            this.mqD.showPostThreadLoadingView(true);
            this.mmy.dew().setVcode(str);
            this.mmy.dew().setVcodeType("5");
            this.mmy.djo();
        } else {
            this.mqD.getContext().showToast(R.string.neterror);
            this.mqD.getContext().finish();
        }
    }
}
