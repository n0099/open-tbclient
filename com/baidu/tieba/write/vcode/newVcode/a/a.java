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
import com.baidu.tbadk.coreExtra.data.aa;
import com.baidu.tieba.R;
import com.baidu.tieba.tbadkCore.writeModel.NewWriteModel;
import com.baidu.tieba.tbadkCore.writeModel.PostWriteCallBackData;
import com.baidu.tieba.write.vcode.newVcode.NewVcodeView;
import com.xiaomi.mipush.sdk.Constants;
/* loaded from: classes13.dex */
public class a implements b {
    private PostWriteCallBackData iLo;
    private final NewWriteModel kOr;
    private final NewVcodeView kRF;
    private NewWriteModel.d kRG;
    private boolean kOs = false;
    private final NewWriteModel.d dza = new NewWriteModel.d() { // from class: com.baidu.tieba.write.vcode.newVcode.a.a.1
        @Override // com.baidu.tieba.tbadkCore.writeModel.NewWriteModel.d
        public void callback(boolean z, PostWriteCallBackData postWriteCallBackData, aa aaVar, WriteData writeData, AntiData antiData) {
            String str;
            String str2;
            String str3 = null;
            if (a.this.kRF != null) {
                a.this.kRF.showPostThreadLoadingView(false);
                if (z) {
                    a.this.iLo = postWriteCallBackData;
                    a.this.kOs = true;
                    if (aaVar == null || aaVar.aJL() == null) {
                        str = null;
                        str2 = null;
                    } else {
                        str2 = aaVar.aJL().endPoint;
                        str = aaVar.aJL().successImg;
                        str3 = aaVar.aJL().slideEndPoint;
                    }
                    a.this.kRF.runJsMethod("success", str + Constants.ACCEPT_TIME_SEPARATOR_SP + str2 + Constants.ACCEPT_TIME_SEPARATOR_SP + str3);
                } else if (postWriteCallBackData == null || postWriteCallBackData.getErrorCode() != 227001) {
                    if (a.this.kRG != null) {
                        a.this.kRG.callback(false, postWriteCallBackData, aaVar, writeData, antiData);
                    }
                } else {
                    a.this.kRF.getContext().setVisible(false);
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AccountAccessActivityConfig(a.this.kRF.getContext().getActivity(), RequestResponseCode.REQUEST_VCODE, writeData, postWriteCallBackData.getAccessState())));
                }
            }
        }
    };

    public a(NewVcodeView newVcodeView, NewWriteModel newWriteModel) {
        this.kRF = newVcodeView;
        this.kOr = newWriteModel;
        this.kOr.b(this.dza);
    }

    @Override // com.baidu.tieba.write.vcode.newVcode.a.b
    public boolean c(WebView webView, String str) {
        WriteData cIp;
        if (this.kOr.cIp() == null || StringUtils.isNull(str) || (cIp = this.kOr.cIp()) == null) {
            return false;
        }
        if (str.contains("objc:loadReady")) {
            if (cIp.getVcodeExtra() == null) {
                return false;
            }
            this.kRF.runJsMethod("handleFreshCaptcha", "'" + cIp.getVcodeUrl() + "','" + cIp.getVcodeExtra().slideImg + "','" + cIp.getVcodeExtra().textImg + "'");
            return true;
        } else if (str.contains("objc:jsChangePosition")) {
            KV(com.baidu.tbadk.s.a.wb(str));
            return true;
        } else if (str.contains("objc:finish")) {
            this.kOs = true;
            if (cIp != null && cIp.getVideoReviewType() == 1) {
                this.kRF.showToast(true, this.kRF.getContext().getResources().getString(R.string.video_send_success_under_review));
            } else if (cIp != null && cIp.getVideoReviewType() == 2) {
                this.kRF.showToast(true, this.kRF.getContext().getResources().getString(R.string.video_send_success));
            } else {
                String str2 = null;
                String str3 = null;
                String string = this.kRF.getContext().getResources().getString(R.string.send_success);
                if (this.iLo != null) {
                    str2 = this.iLo.getPreMsg();
                    str3 = this.iLo.getColorMsg();
                    string = this.iLo.getErrorString();
                }
                if (cIp.getType() != 7) {
                    com.baidu.tieba.tbadkCore.writeModel.c.g(this.kRF.getContext().getActivity(), string, str2, str3);
                }
            }
            Intent intent = new Intent();
            Bundle bundle = new Bundle();
            bundle.putSerializable("post_write_callback_data", this.iLo);
            intent.putExtras(bundle);
            BaseActivity context = this.kRF.getContext();
            this.kRF.getContext();
            context.setResult(-1, intent);
            this.kRF.getContext().finish();
            return true;
        } else if (str.contains("objc:jumpToFeedback()")) {
            WriteActivityConfig writeActivityConfig = new WriteActivityConfig(this.kRF.getContext().getActivity(), 0, TbConfig.getPositionPagerId(), TbConfig.getPositionPagerName(), null, null, 0, null, RequestResponseCode.REQUEST_WRITE_NEW, true, false, null, false, false, null, null, null, 0);
            writeActivityConfig.setIsVcodeFeedBack();
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, writeActivityConfig));
            return true;
        } else {
            return false;
        }
    }

    @Override // com.baidu.tieba.write.vcode.newVcode.a.b
    public void onPageFinished(WebView webView, String str) {
        if (this.kRF != null) {
            this.kRF.showWebViewDelay(1000);
        }
    }

    @Override // com.baidu.tieba.write.vcode.newVcode.a.b
    public void A(boolean z, String str) {
    }

    @Override // com.baidu.tieba.write.vcode.newVcode.a.b
    public void start(boolean z) {
        this.kRF.setRatio(0.9433962f);
        this.kRF.showWebView(false);
        this.kRF.getWebView().loadUrl(TbConfig.SERVER_ADDRESS_WEB_VIEW + Config.DRAG_VCODE_WEBVIEW_ADDRESS);
    }

    @Override // com.baidu.tieba.write.vcode.newVcode.a.b
    public void onDestroy() {
    }

    @Override // com.baidu.tieba.write.vcode.newVcode.a.b
    public void d(NewWriteModel.d dVar) {
        this.kRG = dVar;
    }

    @Override // com.baidu.tieba.write.vcode.newVcode.a.b
    public void cUQ() {
        this.kRF.showPostThreadLoadingView(false);
        this.kOr.cancelLoadData();
    }

    private void KV(String str) {
        this.kOs = false;
        if (!l.isNetOk()) {
            this.kRF.getContext().showToast(R.string.neterror);
            this.kRF.getContext().finish();
        } else if (!StringUtils.isNull(str)) {
            this.kRF.showPostThreadLoadingView(true);
            this.kOr.cIp().setVcode(str);
            this.kOr.cIp().setVcodeType("5");
            this.kOr.cME();
        } else {
            this.kRF.getContext().showToast(R.string.neterror);
            this.kRF.getContext().finish();
        }
    }
}
