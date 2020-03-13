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
    private PostWriteCallBackData iJN;
    private final NewWriteModel kMI;
    private final NewVcodeView kQf;
    private NewWriteModel.d kQg;
    private boolean kMJ = false;
    private final NewWriteModel.d dyN = new NewWriteModel.d() { // from class: com.baidu.tieba.write.vcode.newVcode.a.a.1
        @Override // com.baidu.tieba.tbadkCore.writeModel.NewWriteModel.d
        public void callback(boolean z, PostWriteCallBackData postWriteCallBackData, aa aaVar, WriteData writeData, AntiData antiData) {
            String str;
            String str2;
            String str3 = null;
            if (a.this.kQf != null) {
                a.this.kQf.showPostThreadLoadingView(false);
                if (z) {
                    a.this.iJN = postWriteCallBackData;
                    a.this.kMJ = true;
                    if (aaVar == null || aaVar.aJH() == null) {
                        str = null;
                        str2 = null;
                    } else {
                        str2 = aaVar.aJH().endPoint;
                        str = aaVar.aJH().successImg;
                        str3 = aaVar.aJH().slideEndPoint;
                    }
                    a.this.kQf.runJsMethod("success", str + Constants.ACCEPT_TIME_SEPARATOR_SP + str2 + Constants.ACCEPT_TIME_SEPARATOR_SP + str3);
                } else if (postWriteCallBackData == null || postWriteCallBackData.getErrorCode() != 227001) {
                    if (a.this.kQg != null) {
                        a.this.kQg.callback(false, postWriteCallBackData, aaVar, writeData, antiData);
                    }
                } else {
                    a.this.kQf.getContext().setVisible(false);
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AccountAccessActivityConfig(a.this.kQf.getContext().getActivity(), RequestResponseCode.REQUEST_VCODE, writeData, postWriteCallBackData.getAccessState())));
                }
            }
        }
    };

    public a(NewVcodeView newVcodeView, NewWriteModel newWriteModel) {
        this.kQf = newVcodeView;
        this.kMI = newWriteModel;
        this.kMI.b(this.dyN);
    }

    @Override // com.baidu.tieba.write.vcode.newVcode.a.b
    public boolean c(WebView webView, String str) {
        WriteData cHV;
        if (this.kMI.cHV() == null || StringUtils.isNull(str) || (cHV = this.kMI.cHV()) == null) {
            return false;
        }
        if (str.contains("objc:loadReady")) {
            if (cHV.getVcodeExtra() == null) {
                return false;
            }
            this.kQf.runJsMethod("handleFreshCaptcha", "'" + cHV.getVcodeUrl() + "','" + cHV.getVcodeExtra().slideImg + "','" + cHV.getVcodeExtra().textImg + "'");
            return true;
        } else if (str.contains("objc:jsChangePosition")) {
            KV(com.baidu.tbadk.s.a.wa(str));
            return true;
        } else if (str.contains("objc:finish")) {
            this.kMJ = true;
            if (cHV != null && cHV.getVideoReviewType() == 1) {
                this.kQf.showToast(true, this.kQf.getContext().getResources().getString(R.string.video_send_success_under_review));
            } else if (cHV != null && cHV.getVideoReviewType() == 2) {
                this.kQf.showToast(true, this.kQf.getContext().getResources().getString(R.string.video_send_success));
            } else {
                String str2 = null;
                String str3 = null;
                String string = this.kQf.getContext().getResources().getString(R.string.send_success);
                if (this.iJN != null) {
                    str2 = this.iJN.getPreMsg();
                    str3 = this.iJN.getColorMsg();
                    string = this.iJN.getErrorString();
                }
                if (cHV.getType() != 7) {
                    com.baidu.tieba.tbadkCore.writeModel.c.g(this.kQf.getContext().getActivity(), string, str2, str3);
                }
            }
            Intent intent = new Intent();
            Bundle bundle = new Bundle();
            bundle.putSerializable("post_write_callback_data", this.iJN);
            intent.putExtras(bundle);
            BaseActivity context = this.kQf.getContext();
            this.kQf.getContext();
            context.setResult(-1, intent);
            this.kQf.getContext().finish();
            return true;
        } else if (str.contains("objc:jumpToFeedback()")) {
            WriteActivityConfig writeActivityConfig = new WriteActivityConfig(this.kQf.getContext().getActivity(), 0, TbConfig.getPositionPagerId(), TbConfig.getPositionPagerName(), null, null, 0, null, RequestResponseCode.REQUEST_WRITE_NEW, true, false, null, false, false, null, null, null, 0);
            writeActivityConfig.setIsVcodeFeedBack();
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, writeActivityConfig));
            return true;
        } else {
            return false;
        }
    }

    @Override // com.baidu.tieba.write.vcode.newVcode.a.b
    public void onPageFinished(WebView webView, String str) {
        if (this.kQf != null) {
            this.kQf.showWebViewDelay(1000);
        }
    }

    @Override // com.baidu.tieba.write.vcode.newVcode.a.b
    public void A(boolean z, String str) {
    }

    @Override // com.baidu.tieba.write.vcode.newVcode.a.b
    public void start(boolean z) {
        this.kQf.setRatio(0.9433962f);
        this.kQf.showWebView(false);
        this.kQf.getWebView().loadUrl(TbConfig.SERVER_ADDRESS_WEB_VIEW + Config.DRAG_VCODE_WEBVIEW_ADDRESS);
    }

    @Override // com.baidu.tieba.write.vcode.newVcode.a.b
    public void onDestroy() {
    }

    @Override // com.baidu.tieba.write.vcode.newVcode.a.b
    public void d(NewWriteModel.d dVar) {
        this.kQg = dVar;
    }

    @Override // com.baidu.tieba.write.vcode.newVcode.a.b
    public void cUv() {
        this.kQf.showPostThreadLoadingView(false);
        this.kMI.cancelLoadData();
    }

    private void KV(String str) {
        this.kMJ = false;
        if (!l.isNetOk()) {
            this.kQf.getContext().showToast(R.string.neterror);
            this.kQf.getContext().finish();
        } else if (!StringUtils.isNull(str)) {
            this.kQf.showPostThreadLoadingView(true);
            this.kMI.cHV().setVcode(str);
            this.kMI.cHV().setVcodeType("5");
            this.kMI.cMk();
        } else {
            this.kQf.getContext().showToast(R.string.neterror);
            this.kQf.getContext().finish();
        }
    }
}
