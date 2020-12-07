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
    private PostWriteCallBackData lJZ;
    private final NewWriteModel nUD;
    private final NewVcodeView nYD;
    private NewWriteModel.d nYE;
    private boolean nUE = false;
    private final NewWriteModel.d fwI = new NewWriteModel.d() { // from class: com.baidu.tieba.write.vcode.newVcode.a.a.1
        @Override // com.baidu.tieba.tbadkCore.writeModel.NewWriteModel.d
        public void callback(boolean z, PostWriteCallBackData postWriteCallBackData, ah ahVar, WriteData writeData, AntiData antiData) {
            String str;
            String str2;
            String str3 = null;
            if (a.this.nYD != null) {
                a.this.nYD.showPostThreadLoadingView(false);
                if (z) {
                    a.this.lJZ = postWriteCallBackData;
                    a.this.nUE = true;
                    if (ahVar == null || ahVar.bxM() == null) {
                        str = null;
                        str2 = null;
                    } else {
                        str2 = ahVar.bxM().endPoint;
                        str = ahVar.bxM().successImg;
                        str3 = ahVar.bxM().slideEndPoint;
                    }
                    a.this.nYD.runJsMethod("success", str + "," + str2 + "," + str3);
                } else if (postWriteCallBackData == null || postWriteCallBackData.getErrorCode() != 227001) {
                    if (a.this.nYE != null) {
                        a.this.nYE.callback(false, postWriteCallBackData, ahVar, writeData, antiData);
                    }
                } else {
                    a.this.nYD.getContext().setVisible(false);
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AccountAccessActivityConfig(a.this.nYD.getContext().getActivity(), RequestResponseCode.REQUEST_VCODE, writeData, postWriteCallBackData.getAccessState())));
                }
            }
        }
    };

    public a(NewVcodeView newVcodeView, NewWriteModel newWriteModel) {
        this.nYD = newVcodeView;
        this.nUD = newWriteModel;
        this.nUD.b(this.fwI);
    }

    @Override // com.baidu.tieba.write.vcode.newVcode.a.b
    public boolean c(WebView webView, String str) {
        WriteData dcD;
        if (this.nUD.dcD() == null || StringUtils.isNull(str) || (dcD = this.nUD.dcD()) == null) {
            return false;
        }
        if (str.contains("objc:loadReady")) {
            if (dcD.getVcodeExtra() == null) {
                return false;
            }
            this.nYD.runJsMethod("handleFreshCaptcha", "'" + dcD.getVcodeUrl() + "','" + dcD.getVcodeExtra().slideImg + "','" + dcD.getVcodeExtra().textImg + "'");
            return true;
        } else if (str.contains("objc:jsChangePosition")) {
            VN(com.baidu.tbadk.t.a.ER(str));
            return true;
        } else if (str.contains("objc:finish")) {
            this.nUE = true;
            if (dcD != null && dcD.getVideoReviewType() == 1) {
                this.nYD.showToast(true, this.nYD.getContext().getResources().getString(R.string.video_send_success_under_review));
            } else if (dcD != null && dcD.getVideoReviewType() == 2) {
                this.nYD.showToast(true, this.nYD.getContext().getResources().getString(R.string.video_send_success));
            } else {
                String str2 = null;
                String str3 = null;
                String string = this.nYD.getContext().getResources().getString(R.string.send_success);
                if (this.lJZ != null) {
                    str2 = this.lJZ.getPreMsg();
                    str3 = this.lJZ.getColorMsg();
                    string = this.lJZ.getErrorString();
                }
                if (dcD.getType() != 7) {
                    com.baidu.tieba.tbadkCore.writeModel.c.h(this.nYD.getContext().getActivity(), string, str2, str3);
                }
            }
            Intent intent = new Intent();
            Bundle bundle = new Bundle();
            bundle.putSerializable("post_write_callback_data", this.lJZ);
            intent.putExtras(bundle);
            BaseActivity context = this.nYD.getContext();
            this.nYD.getContext();
            context.setResult(-1, intent);
            this.nYD.getContext().finish();
            return true;
        } else if (str.contains("objc:jumpToFeedback()")) {
            WriteActivityConfig writeActivityConfig = new WriteActivityConfig(this.nYD.getContext().getActivity(), 0, TbConfig.getPositionPagerId(), TbConfig.getPositionPagerName(), null, null, 0, null, RequestResponseCode.REQUEST_WRITE_NEW, true, false, null, false, false, null, null, null, 0);
            writeActivityConfig.setIsVcodeFeedBack();
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, writeActivityConfig));
            return true;
        } else {
            return false;
        }
    }

    @Override // com.baidu.tieba.write.vcode.newVcode.a.b
    public void onPageFinished(WebView webView, String str) {
        if (this.nYD != null) {
            this.nYD.showWebViewDelay(1000);
        }
    }

    @Override // com.baidu.tieba.write.vcode.newVcode.a.b
    public void H(boolean z, String str) {
    }

    @Override // com.baidu.tieba.write.vcode.newVcode.a.b
    public void start(boolean z) {
        this.nYD.setRatio(0.9433962f);
        this.nYD.showWebView(false);
        this.nYD.getWebView().loadUrl(TbConfig.SERVER_ADDRESS_WEB_VIEW + Config.DRAG_VCODE_WEBVIEW_ADDRESS);
    }

    @Override // com.baidu.tieba.write.vcode.newVcode.a.b
    public void onDestroy() {
    }

    @Override // com.baidu.tieba.write.vcode.newVcode.a.b
    public void d(NewWriteModel.d dVar) {
        this.nYE = dVar;
    }

    @Override // com.baidu.tieba.write.vcode.newVcode.a.b
    public void dYE() {
        this.nYD.showPostThreadLoadingView(false);
        this.nUD.cancelLoadData();
    }

    private void VN(String str) {
        this.nUE = false;
        if (!l.isNetOk()) {
            this.nYD.getContext().showToast(R.string.neterror);
            this.nYD.getContext().finish();
        } else if (!StringUtils.isNull(str)) {
            this.nYD.showPostThreadLoadingView(true);
            this.nUD.dcD().setVcode(str);
            this.nUD.dcD().setVcodeType("5");
            this.nUD.dQD();
        } else {
            this.nYD.getContext().showToast(R.string.neterror);
            this.nYD.getContext().finish();
        }
    }
}
