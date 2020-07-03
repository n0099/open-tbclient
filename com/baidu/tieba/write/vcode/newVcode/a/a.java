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
    private final NewWriteModel mmv;
    private final NewVcodeView mqA;
    private NewWriteModel.d mqB;
    private boolean mmw = false;
    private final NewWriteModel.d evL = new NewWriteModel.d() { // from class: com.baidu.tieba.write.vcode.newVcode.a.a.1
        @Override // com.baidu.tieba.tbadkCore.writeModel.NewWriteModel.d
        public void callback(boolean z, PostWriteCallBackData postWriteCallBackData, ad adVar, WriteData writeData, AntiData antiData) {
            String str;
            String str2;
            String str3 = null;
            if (a.this.mqA != null) {
                a.this.mqA.showPostThreadLoadingView(false);
                if (z) {
                    a.this.khu = postWriteCallBackData;
                    a.this.mmw = true;
                    if (adVar == null || adVar.bas() == null) {
                        str = null;
                        str2 = null;
                    } else {
                        str2 = adVar.bas().endPoint;
                        str = adVar.bas().successImg;
                        str3 = adVar.bas().slideEndPoint;
                    }
                    a.this.mqA.runJsMethod("success", str + Constants.ACCEPT_TIME_SEPARATOR_SP + str2 + Constants.ACCEPT_TIME_SEPARATOR_SP + str3);
                } else if (postWriteCallBackData == null || postWriteCallBackData.getErrorCode() != 227001) {
                    if (a.this.mqB != null) {
                        a.this.mqB.callback(false, postWriteCallBackData, adVar, writeData, antiData);
                    }
                } else {
                    a.this.mqA.getContext().setVisible(false);
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AccountAccessActivityConfig(a.this.mqA.getContext().getActivity(), RequestResponseCode.REQUEST_VCODE, writeData, postWriteCallBackData.getAccessState())));
                }
            }
        }
    };

    public a(NewVcodeView newVcodeView, NewWriteModel newWriteModel) {
        this.mqA = newVcodeView;
        this.mmv = newWriteModel;
        this.mmv.b(this.evL);
    }

    @Override // com.baidu.tieba.write.vcode.newVcode.a.b
    public boolean c(WebView webView, String str) {
        WriteData dev;
        if (this.mmv.dev() == null || StringUtils.isNull(str) || (dev = this.mmv.dev()) == null) {
            return false;
        }
        if (str.contains("objc:loadReady")) {
            if (dev.getVcodeExtra() == null) {
                return false;
            }
            this.mqA.runJsMethod("handleFreshCaptcha", "'" + dev.getVcodeUrl() + "','" + dev.getVcodeExtra().slideImg + "','" + dev.getVcodeExtra().textImg + "'");
            return true;
        } else if (str.contains("objc:jsChangePosition")) {
            OZ(com.baidu.tbadk.t.a.zp(str));
            return true;
        } else if (str.contains("objc:finish")) {
            this.mmw = true;
            if (dev != null && dev.getVideoReviewType() == 1) {
                this.mqA.showToast(true, this.mqA.getContext().getResources().getString(R.string.video_send_success_under_review));
            } else if (dev != null && dev.getVideoReviewType() == 2) {
                this.mqA.showToast(true, this.mqA.getContext().getResources().getString(R.string.video_send_success));
            } else {
                String str2 = null;
                String str3 = null;
                String string = this.mqA.getContext().getResources().getString(R.string.send_success);
                if (this.khu != null) {
                    str2 = this.khu.getPreMsg();
                    str3 = this.khu.getColorMsg();
                    string = this.khu.getErrorString();
                }
                if (dev.getType() != 7) {
                    com.baidu.tieba.tbadkCore.writeModel.c.f(this.mqA.getContext().getActivity(), string, str2, str3);
                }
            }
            Intent intent = new Intent();
            Bundle bundle = new Bundle();
            bundle.putSerializable("post_write_callback_data", this.khu);
            intent.putExtras(bundle);
            BaseActivity context = this.mqA.getContext();
            this.mqA.getContext();
            context.setResult(-1, intent);
            this.mqA.getContext().finish();
            return true;
        } else if (str.contains("objc:jumpToFeedback()")) {
            WriteActivityConfig writeActivityConfig = new WriteActivityConfig(this.mqA.getContext().getActivity(), 0, TbConfig.getPositionPagerId(), TbConfig.getPositionPagerName(), null, null, 0, null, RequestResponseCode.REQUEST_WRITE_NEW, true, false, null, false, false, null, null, null, 0);
            writeActivityConfig.setIsVcodeFeedBack();
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, writeActivityConfig));
            return true;
        } else {
            return false;
        }
    }

    @Override // com.baidu.tieba.write.vcode.newVcode.a.b
    public void onPageFinished(WebView webView, String str) {
        if (this.mqA != null) {
            this.mqA.showWebViewDelay(1000);
        }
    }

    @Override // com.baidu.tieba.write.vcode.newVcode.a.b
    public void D(boolean z, String str) {
    }

    @Override // com.baidu.tieba.write.vcode.newVcode.a.b
    public void start(boolean z) {
        this.mqA.setRatio(0.9433962f);
        this.mqA.showWebView(false);
        this.mqA.getWebView().loadUrl(TbConfig.SERVER_ADDRESS_WEB_VIEW + Config.DRAG_VCODE_WEBVIEW_ADDRESS);
    }

    @Override // com.baidu.tieba.write.vcode.newVcode.a.b
    public void onDestroy() {
    }

    @Override // com.baidu.tieba.write.vcode.newVcode.a.b
    public void d(NewWriteModel.d dVar) {
        this.mqB = dVar;
    }

    @Override // com.baidu.tieba.write.vcode.newVcode.a.b
    public void drb() {
        this.mqA.showPostThreadLoadingView(false);
        this.mmv.cancelLoadData();
    }

    private void OZ(String str) {
        this.mmw = false;
        if (!l.isNetOk()) {
            this.mqA.getContext().showToast(R.string.neterror);
            this.mqA.getContext().finish();
        } else if (!StringUtils.isNull(str)) {
            this.mqA.showPostThreadLoadingView(true);
            this.mmv.dev().setVcode(str);
            this.mmv.dev().setVcodeType("5");
            this.mmv.djn();
        } else {
            this.mqA.getContext().showToast(R.string.neterror);
            this.mqA.getContext().finish();
        }
    }
}
