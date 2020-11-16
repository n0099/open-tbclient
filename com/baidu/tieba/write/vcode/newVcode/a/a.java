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
    private PostWriteCallBackData lwm;
    private final NewWriteModel nGx;
    private final NewVcodeView nKx;
    private NewWriteModel.d nKy;
    private boolean nGy = false;
    private final NewWriteModel.d fpd = new NewWriteModel.d() { // from class: com.baidu.tieba.write.vcode.newVcode.a.a.1
        @Override // com.baidu.tieba.tbadkCore.writeModel.NewWriteModel.d
        public void callback(boolean z, PostWriteCallBackData postWriteCallBackData, ah ahVar, WriteData writeData, AntiData antiData) {
            String str;
            String str2;
            String str3 = null;
            if (a.this.nKx != null) {
                a.this.nKx.showPostThreadLoadingView(false);
                if (z) {
                    a.this.lwm = postWriteCallBackData;
                    a.this.nGy = true;
                    if (ahVar == null || ahVar.bum() == null) {
                        str = null;
                        str2 = null;
                    } else {
                        str2 = ahVar.bum().endPoint;
                        str = ahVar.bum().successImg;
                        str3 = ahVar.bum().slideEndPoint;
                    }
                    a.this.nKx.runJsMethod("success", str + Constants.ACCEPT_TIME_SEPARATOR_SP + str2 + Constants.ACCEPT_TIME_SEPARATOR_SP + str3);
                } else if (postWriteCallBackData == null || postWriteCallBackData.getErrorCode() != 227001) {
                    if (a.this.nKy != null) {
                        a.this.nKy.callback(false, postWriteCallBackData, ahVar, writeData, antiData);
                    }
                } else {
                    a.this.nKx.getContext().setVisible(false);
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AccountAccessActivityConfig(a.this.nKx.getContext().getActivity(), RequestResponseCode.REQUEST_VCODE, writeData, postWriteCallBackData.getAccessState())));
                }
            }
        }
    };

    public a(NewVcodeView newVcodeView, NewWriteModel newWriteModel) {
        this.nKx = newVcodeView;
        this.nGx = newWriteModel;
        this.nGx.b(this.fpd);
    }

    @Override // com.baidu.tieba.write.vcode.newVcode.a.b
    public boolean c(WebView webView, String str) {
        WriteData cXs;
        if (this.nGx.cXs() == null || StringUtils.isNull(str) || (cXs = this.nGx.cXs()) == null) {
            return false;
        }
        if (str.contains("objc:loadReady")) {
            if (cXs.getVcodeExtra() == null) {
                return false;
            }
            this.nKx.runJsMethod("handleFreshCaptcha", "'" + cXs.getVcodeUrl() + "','" + cXs.getVcodeExtra().slideImg + "','" + cXs.getVcodeExtra().textImg + "'");
            return true;
        } else if (str.contains("objc:jsChangePosition")) {
            Uy(com.baidu.tbadk.t.a.Ee(str));
            return true;
        } else if (str.contains("objc:finish")) {
            this.nGy = true;
            if (cXs != null && cXs.getVideoReviewType() == 1) {
                this.nKx.showToast(true, this.nKx.getContext().getResources().getString(R.string.video_send_success_under_review));
            } else if (cXs != null && cXs.getVideoReviewType() == 2) {
                this.nKx.showToast(true, this.nKx.getContext().getResources().getString(R.string.video_send_success));
            } else {
                String str2 = null;
                String str3 = null;
                String string = this.nKx.getContext().getResources().getString(R.string.send_success);
                if (this.lwm != null) {
                    str2 = this.lwm.getPreMsg();
                    str3 = this.lwm.getColorMsg();
                    string = this.lwm.getErrorString();
                }
                if (cXs.getType() != 7) {
                    com.baidu.tieba.tbadkCore.writeModel.c.g(this.nKx.getContext().getActivity(), string, str2, str3);
                }
            }
            Intent intent = new Intent();
            Bundle bundle = new Bundle();
            bundle.putSerializable("post_write_callback_data", this.lwm);
            intent.putExtras(bundle);
            BaseActivity context = this.nKx.getContext();
            this.nKx.getContext();
            context.setResult(-1, intent);
            this.nKx.getContext().finish();
            return true;
        } else if (str.contains("objc:jumpToFeedback()")) {
            WriteActivityConfig writeActivityConfig = new WriteActivityConfig(this.nKx.getContext().getActivity(), 0, TbConfig.getPositionPagerId(), TbConfig.getPositionPagerName(), null, null, 0, null, RequestResponseCode.REQUEST_WRITE_NEW, true, false, null, false, false, null, null, null, 0);
            writeActivityConfig.setIsVcodeFeedBack();
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, writeActivityConfig));
            return true;
        } else {
            return false;
        }
    }

    @Override // com.baidu.tieba.write.vcode.newVcode.a.b
    public void onPageFinished(WebView webView, String str) {
        if (this.nKx != null) {
            this.nKx.showWebViewDelay(1000);
        }
    }

    @Override // com.baidu.tieba.write.vcode.newVcode.a.b
    public void H(boolean z, String str) {
    }

    @Override // com.baidu.tieba.write.vcode.newVcode.a.b
    public void start(boolean z) {
        this.nKx.setRatio(0.9433962f);
        this.nKx.showWebView(false);
        this.nKx.getWebView().loadUrl(TbConfig.SERVER_ADDRESS_WEB_VIEW + Config.DRAG_VCODE_WEBVIEW_ADDRESS);
    }

    @Override // com.baidu.tieba.write.vcode.newVcode.a.b
    public void onDestroy() {
    }

    @Override // com.baidu.tieba.write.vcode.newVcode.a.b
    public void d(NewWriteModel.d dVar) {
        this.nKy = dVar;
    }

    @Override // com.baidu.tieba.write.vcode.newVcode.a.b
    public void dTk() {
        this.nKx.showPostThreadLoadingView(false);
        this.nGx.cancelLoadData();
    }

    private void Uy(String str) {
        this.nGy = false;
        if (!l.isNetOk()) {
            this.nKx.getContext().showToast(R.string.neterror);
            this.nKx.getContext().finish();
        } else if (!StringUtils.isNull(str)) {
            this.nKx.showPostThreadLoadingView(true);
            this.nGx.cXs().setVcode(str);
            this.nGx.cXs().setVcodeType("5");
            this.nGx.dLl();
        } else {
            this.nKx.getContext().showToast(R.string.neterror);
            this.nKx.getContext().finish();
        }
    }
}
