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
/* loaded from: classes2.dex */
public class a implements b {
    private PostWriteCallBackData jMA;
    private final NewWriteModel lRb;
    private final NewVcodeView lUV;
    private NewWriteModel.d lUW;
    private boolean lRc = false;
    private final NewWriteModel.d emV = new NewWriteModel.d() { // from class: com.baidu.tieba.write.vcode.newVcode.a.a.1
        @Override // com.baidu.tieba.tbadkCore.writeModel.NewWriteModel.d
        public void callback(boolean z, PostWriteCallBackData postWriteCallBackData, aa aaVar, WriteData writeData, AntiData antiData) {
            String str;
            String str2;
            String str3 = null;
            if (a.this.lUV != null) {
                a.this.lUV.showPostThreadLoadingView(false);
                if (z) {
                    a.this.jMA = postWriteCallBackData;
                    a.this.lRc = true;
                    if (aaVar == null || aaVar.aYm() == null) {
                        str = null;
                        str2 = null;
                    } else {
                        str2 = aaVar.aYm().endPoint;
                        str = aaVar.aYm().successImg;
                        str3 = aaVar.aYm().slideEndPoint;
                    }
                    a.this.lUV.runJsMethod("success", str + Constants.ACCEPT_TIME_SEPARATOR_SP + str2 + Constants.ACCEPT_TIME_SEPARATOR_SP + str3);
                } else if (postWriteCallBackData == null || postWriteCallBackData.getErrorCode() != 227001) {
                    if (a.this.lUW != null) {
                        a.this.lUW.callback(false, postWriteCallBackData, aaVar, writeData, antiData);
                    }
                } else {
                    a.this.lUV.getContext().setVisible(false);
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AccountAccessActivityConfig(a.this.lUV.getContext().getActivity(), RequestResponseCode.REQUEST_VCODE, writeData, postWriteCallBackData.getAccessState())));
                }
            }
        }
    };

    public a(NewVcodeView newVcodeView, NewWriteModel newWriteModel) {
        this.lUV = newVcodeView;
        this.lRb = newWriteModel;
        this.lRb.b(this.emV);
    }

    @Override // com.baidu.tieba.write.vcode.newVcode.a.b
    public boolean c(WebView webView, String str) {
        WriteData cZP;
        if (this.lRb.cZP() == null || StringUtils.isNull(str) || (cZP = this.lRb.cZP()) == null) {
            return false;
        }
        if (str.contains("objc:loadReady")) {
            if (cZP.getVcodeExtra() == null) {
                return false;
            }
            this.lUV.runJsMethod("handleFreshCaptcha", "'" + cZP.getVcodeUrl() + "','" + cZP.getVcodeExtra().slideImg + "','" + cZP.getVcodeExtra().textImg + "'");
            return true;
        } else if (str.contains("objc:jsChangePosition")) {
            Or(com.baidu.tbadk.s.a.yW(str));
            return true;
        } else if (str.contains("objc:finish")) {
            this.lRc = true;
            if (cZP != null && cZP.getVideoReviewType() == 1) {
                this.lUV.showToast(true, this.lUV.getContext().getResources().getString(R.string.video_send_success_under_review));
            } else if (cZP != null && cZP.getVideoReviewType() == 2) {
                this.lUV.showToast(true, this.lUV.getContext().getResources().getString(R.string.video_send_success));
            } else {
                String str2 = null;
                String str3 = null;
                String string = this.lUV.getContext().getResources().getString(R.string.send_success);
                if (this.jMA != null) {
                    str2 = this.jMA.getPreMsg();
                    str3 = this.jMA.getColorMsg();
                    string = this.jMA.getErrorString();
                }
                if (cZP.getType() != 7) {
                    com.baidu.tieba.tbadkCore.writeModel.c.f(this.lUV.getContext().getActivity(), string, str2, str3);
                }
            }
            Intent intent = new Intent();
            Bundle bundle = new Bundle();
            bundle.putSerializable("post_write_callback_data", this.jMA);
            intent.putExtras(bundle);
            BaseActivity context = this.lUV.getContext();
            this.lUV.getContext();
            context.setResult(-1, intent);
            this.lUV.getContext().finish();
            return true;
        } else if (str.contains("objc:jumpToFeedback()")) {
            WriteActivityConfig writeActivityConfig = new WriteActivityConfig(this.lUV.getContext().getActivity(), 0, TbConfig.getPositionPagerId(), TbConfig.getPositionPagerName(), null, null, 0, null, RequestResponseCode.REQUEST_WRITE_NEW, true, false, null, false, false, null, null, null, 0);
            writeActivityConfig.setIsVcodeFeedBack();
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, writeActivityConfig));
            return true;
        } else {
            return false;
        }
    }

    @Override // com.baidu.tieba.write.vcode.newVcode.a.b
    public void onPageFinished(WebView webView, String str) {
        if (this.lUV != null) {
            this.lUV.showWebViewDelay(1000);
        }
    }

    @Override // com.baidu.tieba.write.vcode.newVcode.a.b
    public void B(boolean z, String str) {
    }

    @Override // com.baidu.tieba.write.vcode.newVcode.a.b
    public void start(boolean z) {
        this.lUV.setRatio(0.9433962f);
        this.lUV.showWebView(false);
        this.lUV.getWebView().loadUrl(TbConfig.SERVER_ADDRESS_WEB_VIEW + Config.DRAG_VCODE_WEBVIEW_ADDRESS);
    }

    @Override // com.baidu.tieba.write.vcode.newVcode.a.b
    public void onDestroy() {
    }

    @Override // com.baidu.tieba.write.vcode.newVcode.a.b
    public void d(NewWriteModel.d dVar) {
        this.lUW = dVar;
    }

    @Override // com.baidu.tieba.write.vcode.newVcode.a.b
    public void dmz() {
        this.lUV.showPostThreadLoadingView(false);
        this.lRb.cancelLoadData();
    }

    private void Or(String str) {
        this.lRc = false;
        if (!l.isNetOk()) {
            this.lUV.getContext().showToast(R.string.neterror);
            this.lUV.getContext().finish();
        } else if (!StringUtils.isNull(str)) {
            this.lUV.showPostThreadLoadingView(true);
            this.lRb.cZP().setVcode(str);
            this.lRb.cZP().setVcodeType("5");
            this.lRb.deN();
        } else {
            this.lUV.getContext().showToast(R.string.neterror);
            this.lUV.getContext().finish();
        }
    }
}
