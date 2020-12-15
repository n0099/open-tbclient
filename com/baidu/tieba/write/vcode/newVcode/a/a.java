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
/* loaded from: classes3.dex */
public class a implements b {
    private PostWriteCallBackData lKb;
    private final NewWriteModel nUF;
    private final NewVcodeView nYF;
    private NewWriteModel.d nYG;
    private boolean nUG = false;
    private final NewWriteModel.d fwI = new NewWriteModel.d() { // from class: com.baidu.tieba.write.vcode.newVcode.a.a.1
        @Override // com.baidu.tieba.tbadkCore.writeModel.NewWriteModel.d
        public void callback(boolean z, PostWriteCallBackData postWriteCallBackData, ah ahVar, WriteData writeData, AntiData antiData) {
            String str;
            String str2;
            String str3 = null;
            if (a.this.nYF != null) {
                a.this.nYF.showPostThreadLoadingView(false);
                if (z) {
                    a.this.lKb = postWriteCallBackData;
                    a.this.nUG = true;
                    if (ahVar == null || ahVar.bxM() == null) {
                        str = null;
                        str2 = null;
                    } else {
                        str2 = ahVar.bxM().endPoint;
                        str = ahVar.bxM().successImg;
                        str3 = ahVar.bxM().slideEndPoint;
                    }
                    a.this.nYF.runJsMethod("success", str + "," + str2 + "," + str3);
                } else if (postWriteCallBackData == null || postWriteCallBackData.getErrorCode() != 227001) {
                    if (a.this.nYG != null) {
                        a.this.nYG.callback(false, postWriteCallBackData, ahVar, writeData, antiData);
                    }
                } else {
                    a.this.nYF.getContext().setVisible(false);
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AccountAccessActivityConfig(a.this.nYF.getContext().getActivity(), RequestResponseCode.REQUEST_VCODE, writeData, postWriteCallBackData.getAccessState())));
                }
            }
        }
    };

    public a(NewVcodeView newVcodeView, NewWriteModel newWriteModel) {
        this.nYF = newVcodeView;
        this.nUF = newWriteModel;
        this.nUF.b(this.fwI);
    }

    @Override // com.baidu.tieba.write.vcode.newVcode.a.b
    public boolean c(WebView webView, String str) {
        WriteData dcE;
        if (this.nUF.dcE() == null || StringUtils.isNull(str) || (dcE = this.nUF.dcE()) == null) {
            return false;
        }
        if (str.contains("objc:loadReady")) {
            if (dcE.getVcodeExtra() == null) {
                return false;
            }
            this.nYF.runJsMethod("handleFreshCaptcha", "'" + dcE.getVcodeUrl() + "','" + dcE.getVcodeExtra().slideImg + "','" + dcE.getVcodeExtra().textImg + "'");
            return true;
        } else if (str.contains("objc:jsChangePosition")) {
            VN(com.baidu.tbadk.t.a.ER(str));
            return true;
        } else if (str.contains("objc:finish")) {
            this.nUG = true;
            if (dcE != null && dcE.getVideoReviewType() == 1) {
                this.nYF.showToast(true, this.nYF.getContext().getResources().getString(R.string.video_send_success_under_review));
            } else if (dcE != null && dcE.getVideoReviewType() == 2) {
                this.nYF.showToast(true, this.nYF.getContext().getResources().getString(R.string.video_send_success));
            } else {
                String str2 = null;
                String str3 = null;
                String string = this.nYF.getContext().getResources().getString(R.string.send_success);
                if (this.lKb != null) {
                    str2 = this.lKb.getPreMsg();
                    str3 = this.lKb.getColorMsg();
                    string = this.lKb.getErrorString();
                }
                if (dcE.getType() != 7) {
                    com.baidu.tieba.tbadkCore.writeModel.c.h(this.nYF.getContext().getActivity(), string, str2, str3);
                }
            }
            Intent intent = new Intent();
            Bundle bundle = new Bundle();
            bundle.putSerializable("post_write_callback_data", this.lKb);
            intent.putExtras(bundle);
            BaseActivity context = this.nYF.getContext();
            this.nYF.getContext();
            context.setResult(-1, intent);
            this.nYF.getContext().finish();
            return true;
        } else if (str.contains("objc:jumpToFeedback()")) {
            WriteActivityConfig writeActivityConfig = new WriteActivityConfig(this.nYF.getContext().getActivity(), 0, TbConfig.getPositionPagerId(), TbConfig.getPositionPagerName(), null, null, 0, null, RequestResponseCode.REQUEST_WRITE_NEW, true, false, null, false, false, null, null, null, 0);
            writeActivityConfig.setIsVcodeFeedBack();
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, writeActivityConfig));
            return true;
        } else {
            return false;
        }
    }

    @Override // com.baidu.tieba.write.vcode.newVcode.a.b
    public void onPageFinished(WebView webView, String str) {
        if (this.nYF != null) {
            this.nYF.showWebViewDelay(1000);
        }
    }

    @Override // com.baidu.tieba.write.vcode.newVcode.a.b
    public void H(boolean z, String str) {
    }

    @Override // com.baidu.tieba.write.vcode.newVcode.a.b
    public void start(boolean z) {
        this.nYF.setRatio(0.9433962f);
        this.nYF.showWebView(false);
        this.nYF.getWebView().loadUrl(TbConfig.SERVER_ADDRESS_WEB_VIEW + Config.DRAG_VCODE_WEBVIEW_ADDRESS);
    }

    @Override // com.baidu.tieba.write.vcode.newVcode.a.b
    public void onDestroy() {
    }

    @Override // com.baidu.tieba.write.vcode.newVcode.a.b
    public void d(NewWriteModel.d dVar) {
        this.nYG = dVar;
    }

    @Override // com.baidu.tieba.write.vcode.newVcode.a.b
    public void dYF() {
        this.nYF.showPostThreadLoadingView(false);
        this.nUF.cancelLoadData();
    }

    private void VN(String str) {
        this.nUG = false;
        if (!l.isNetOk()) {
            this.nYF.getContext().showToast(R.string.neterror);
            this.nYF.getContext().finish();
        } else if (!StringUtils.isNull(str)) {
            this.nYF.showPostThreadLoadingView(true);
            this.nUF.dcE().setVcode(str);
            this.nUF.dcE().setVcodeType("5");
            this.nUF.dQE();
        } else {
            this.nYF.getContext().showToast(R.string.neterror);
            this.nYF.getContext().finish();
        }
    }
}
