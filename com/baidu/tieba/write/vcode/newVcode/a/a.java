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
    private PostWriteCallBackData iJz;
    private final NewWriteModel kMu;
    private final NewVcodeView kPR;
    private NewWriteModel.d kPS;
    private boolean kMv = false;
    private final NewWriteModel.d dyz = new NewWriteModel.d() { // from class: com.baidu.tieba.write.vcode.newVcode.a.a.1
        @Override // com.baidu.tieba.tbadkCore.writeModel.NewWriteModel.d
        public void callback(boolean z, PostWriteCallBackData postWriteCallBackData, aa aaVar, WriteData writeData, AntiData antiData) {
            String str;
            String str2;
            String str3 = null;
            if (a.this.kPR != null) {
                a.this.kPR.showPostThreadLoadingView(false);
                if (z) {
                    a.this.iJz = postWriteCallBackData;
                    a.this.kMv = true;
                    if (aaVar == null || aaVar.aJE() == null) {
                        str = null;
                        str2 = null;
                    } else {
                        str2 = aaVar.aJE().endPoint;
                        str = aaVar.aJE().successImg;
                        str3 = aaVar.aJE().slideEndPoint;
                    }
                    a.this.kPR.runJsMethod("success", str + Constants.ACCEPT_TIME_SEPARATOR_SP + str2 + Constants.ACCEPT_TIME_SEPARATOR_SP + str3);
                } else if (postWriteCallBackData == null || postWriteCallBackData.getErrorCode() != 227001) {
                    if (a.this.kPS != null) {
                        a.this.kPS.callback(false, postWriteCallBackData, aaVar, writeData, antiData);
                    }
                } else {
                    a.this.kPR.getContext().setVisible(false);
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AccountAccessActivityConfig(a.this.kPR.getContext().getActivity(), RequestResponseCode.REQUEST_VCODE, writeData, postWriteCallBackData.getAccessState())));
                }
            }
        }
    };

    public a(NewVcodeView newVcodeView, NewWriteModel newWriteModel) {
        this.kPR = newVcodeView;
        this.kMu = newWriteModel;
        this.kMu.b(this.dyz);
    }

    @Override // com.baidu.tieba.write.vcode.newVcode.a.b
    public boolean c(WebView webView, String str) {
        WriteData cHS;
        if (this.kMu.cHS() == null || StringUtils.isNull(str) || (cHS = this.kMu.cHS()) == null) {
            return false;
        }
        if (str.contains("objc:loadReady")) {
            if (cHS.getVcodeExtra() == null) {
                return false;
            }
            this.kPR.runJsMethod("handleFreshCaptcha", "'" + cHS.getVcodeUrl() + "','" + cHS.getVcodeExtra().slideImg + "','" + cHS.getVcodeExtra().textImg + "'");
            return true;
        } else if (str.contains("objc:jsChangePosition")) {
            KU(com.baidu.tbadk.s.a.vZ(str));
            return true;
        } else if (str.contains("objc:finish")) {
            this.kMv = true;
            if (cHS != null && cHS.getVideoReviewType() == 1) {
                this.kPR.showToast(true, this.kPR.getContext().getResources().getString(R.string.video_send_success_under_review));
            } else if (cHS != null && cHS.getVideoReviewType() == 2) {
                this.kPR.showToast(true, this.kPR.getContext().getResources().getString(R.string.video_send_success));
            } else {
                String str2 = null;
                String str3 = null;
                String string = this.kPR.getContext().getResources().getString(R.string.send_success);
                if (this.iJz != null) {
                    str2 = this.iJz.getPreMsg();
                    str3 = this.iJz.getColorMsg();
                    string = this.iJz.getErrorString();
                }
                if (cHS.getType() != 7) {
                    com.baidu.tieba.tbadkCore.writeModel.c.g(this.kPR.getContext().getActivity(), string, str2, str3);
                }
            }
            Intent intent = new Intent();
            Bundle bundle = new Bundle();
            bundle.putSerializable("post_write_callback_data", this.iJz);
            intent.putExtras(bundle);
            BaseActivity context = this.kPR.getContext();
            this.kPR.getContext();
            context.setResult(-1, intent);
            this.kPR.getContext().finish();
            return true;
        } else if (str.contains("objc:jumpToFeedback()")) {
            WriteActivityConfig writeActivityConfig = new WriteActivityConfig(this.kPR.getContext().getActivity(), 0, TbConfig.getPositionPagerId(), TbConfig.getPositionPagerName(), null, null, 0, null, RequestResponseCode.REQUEST_WRITE_NEW, true, false, null, false, false, null, null, null, 0);
            writeActivityConfig.setIsVcodeFeedBack();
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, writeActivityConfig));
            return true;
        } else {
            return false;
        }
    }

    @Override // com.baidu.tieba.write.vcode.newVcode.a.b
    public void onPageFinished(WebView webView, String str) {
        if (this.kPR != null) {
            this.kPR.showWebViewDelay(1000);
        }
    }

    @Override // com.baidu.tieba.write.vcode.newVcode.a.b
    public void A(boolean z, String str) {
    }

    @Override // com.baidu.tieba.write.vcode.newVcode.a.b
    public void start(boolean z) {
        this.kPR.setRatio(0.9433962f);
        this.kPR.showWebView(false);
        this.kPR.getWebView().loadUrl(TbConfig.SERVER_ADDRESS_WEB_VIEW + Config.DRAG_VCODE_WEBVIEW_ADDRESS);
    }

    @Override // com.baidu.tieba.write.vcode.newVcode.a.b
    public void onDestroy() {
    }

    @Override // com.baidu.tieba.write.vcode.newVcode.a.b
    public void d(NewWriteModel.d dVar) {
        this.kPS = dVar;
    }

    @Override // com.baidu.tieba.write.vcode.newVcode.a.b
    public void cUs() {
        this.kPR.showPostThreadLoadingView(false);
        this.kMu.cancelLoadData();
    }

    private void KU(String str) {
        this.kMv = false;
        if (!l.isNetOk()) {
            this.kPR.getContext().showToast(R.string.neterror);
            this.kPR.getContext().finish();
        } else if (!StringUtils.isNull(str)) {
            this.kPR.showPostThreadLoadingView(true);
            this.kMu.cHS().setVcode(str);
            this.kMu.cHS().setVcodeType("5");
            this.kMu.cMh();
        } else {
            this.kPR.getContext().showToast(R.string.neterror);
            this.kPR.getContext().finish();
        }
    }
}
