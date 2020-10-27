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
    private PostWriteCallBackData lpZ;
    private final NewVcodeView nDc;
    private NewWriteModel.d nDd;
    private final NewWriteModel nzc;
    private boolean nzd = false;
    private final NewWriteModel.d fke = new NewWriteModel.d() { // from class: com.baidu.tieba.write.vcode.newVcode.a.a.1
        @Override // com.baidu.tieba.tbadkCore.writeModel.NewWriteModel.d
        public void callback(boolean z, PostWriteCallBackData postWriteCallBackData, ah ahVar, WriteData writeData, AntiData antiData) {
            String str;
            String str2;
            String str3 = null;
            if (a.this.nDc != null) {
                a.this.nDc.showPostThreadLoadingView(false);
                if (z) {
                    a.this.lpZ = postWriteCallBackData;
                    a.this.nzd = true;
                    if (ahVar == null || ahVar.bsw() == null) {
                        str = null;
                        str2 = null;
                    } else {
                        str2 = ahVar.bsw().endPoint;
                        str = ahVar.bsw().successImg;
                        str3 = ahVar.bsw().slideEndPoint;
                    }
                    a.this.nDc.runJsMethod("success", str + Constants.ACCEPT_TIME_SEPARATOR_SP + str2 + Constants.ACCEPT_TIME_SEPARATOR_SP + str3);
                } else if (postWriteCallBackData == null || postWriteCallBackData.getErrorCode() != 227001) {
                    if (a.this.nDd != null) {
                        a.this.nDd.callback(false, postWriteCallBackData, ahVar, writeData, antiData);
                    }
                } else {
                    a.this.nDc.getContext().setVisible(false);
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AccountAccessActivityConfig(a.this.nDc.getContext().getActivity(), RequestResponseCode.REQUEST_VCODE, writeData, postWriteCallBackData.getAccessState())));
                }
            }
        }
    };

    public a(NewVcodeView newVcodeView, NewWriteModel newWriteModel) {
        this.nDc = newVcodeView;
        this.nzc = newWriteModel;
        this.nzc.b(this.fke);
    }

    @Override // com.baidu.tieba.write.vcode.newVcode.a.b
    public boolean b(WebView webView, String str) {
        WriteData cVv;
        if (this.nzc.cVv() == null || StringUtils.isNull(str) || (cVv = this.nzc.cVv()) == null) {
            return false;
        }
        if (str.contains("objc:loadReady")) {
            if (cVv.getVcodeExtra() == null) {
                return false;
            }
            this.nDc.runJsMethod("handleFreshCaptcha", "'" + cVv.getVcodeUrl() + "','" + cVv.getVcodeExtra().slideImg + "','" + cVv.getVcodeExtra().textImg + "'");
            return true;
        } else if (str.contains("objc:jsChangePosition")) {
            Uw(com.baidu.tbadk.t.a.Ep(str));
            return true;
        } else if (str.contains("objc:finish")) {
            this.nzd = true;
            if (cVv != null && cVv.getVideoReviewType() == 1) {
                this.nDc.showToast(true, this.nDc.getContext().getResources().getString(R.string.video_send_success_under_review));
            } else if (cVv != null && cVv.getVideoReviewType() == 2) {
                this.nDc.showToast(true, this.nDc.getContext().getResources().getString(R.string.video_send_success));
            } else {
                String str2 = null;
                String str3 = null;
                String string = this.nDc.getContext().getResources().getString(R.string.send_success);
                if (this.lpZ != null) {
                    str2 = this.lpZ.getPreMsg();
                    str3 = this.lpZ.getColorMsg();
                    string = this.lpZ.getErrorString();
                }
                if (cVv.getType() != 7) {
                    com.baidu.tieba.tbadkCore.writeModel.c.g(this.nDc.getContext().getActivity(), string, str2, str3);
                }
            }
            Intent intent = new Intent();
            Bundle bundle = new Bundle();
            bundle.putSerializable("post_write_callback_data", this.lpZ);
            intent.putExtras(bundle);
            BaseActivity context = this.nDc.getContext();
            this.nDc.getContext();
            context.setResult(-1, intent);
            this.nDc.getContext().finish();
            return true;
        } else if (str.contains("objc:jumpToFeedback()")) {
            WriteActivityConfig writeActivityConfig = new WriteActivityConfig(this.nDc.getContext().getActivity(), 0, TbConfig.getPositionPagerId(), TbConfig.getPositionPagerName(), null, null, 0, null, RequestResponseCode.REQUEST_WRITE_NEW, true, false, null, false, false, null, null, null, 0);
            writeActivityConfig.setIsVcodeFeedBack();
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, writeActivityConfig));
            return true;
        } else {
            return false;
        }
    }

    @Override // com.baidu.tieba.write.vcode.newVcode.a.b
    public void onPageFinished(WebView webView, String str) {
        if (this.nDc != null) {
            this.nDc.showWebViewDelay(1000);
        }
    }

    @Override // com.baidu.tieba.write.vcode.newVcode.a.b
    public void G(boolean z, String str) {
    }

    @Override // com.baidu.tieba.write.vcode.newVcode.a.b
    public void start(boolean z) {
        this.nDc.setRatio(0.9433962f);
        this.nDc.showWebView(false);
        this.nDc.getWebView().loadUrl(TbConfig.SERVER_ADDRESS_WEB_VIEW + Config.DRAG_VCODE_WEBVIEW_ADDRESS);
    }

    @Override // com.baidu.tieba.write.vcode.newVcode.a.b
    public void onDestroy() {
    }

    @Override // com.baidu.tieba.write.vcode.newVcode.a.b
    public void d(NewWriteModel.d dVar) {
        this.nDd = dVar;
    }

    @Override // com.baidu.tieba.write.vcode.newVcode.a.b
    public void dQL() {
        this.nDc.showPostThreadLoadingView(false);
        this.nzc.cancelLoadData();
    }

    private void Uw(String str) {
        this.nzd = false;
        if (!l.isNetOk()) {
            this.nDc.getContext().showToast(R.string.neterror);
            this.nDc.getContext().finish();
        } else if (!StringUtils.isNull(str)) {
            this.nDc.showPostThreadLoadingView(true);
            this.nzc.cVv().setVcode(str);
            this.nzc.cVv().setVcodeType("5");
            this.nzc.dIK();
        } else {
            this.nDc.getContext().showToast(R.string.neterror);
            this.nDc.getContext().finish();
        }
    }
}
