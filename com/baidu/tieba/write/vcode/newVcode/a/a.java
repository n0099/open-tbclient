package com.baidu.tieba.write.vcode.newVcode.a;

import android.content.Intent;
import android.os.Bundle;
import android.webkit.WebView;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.lib.util.l;
import com.baidu.sapi2.passhost.pluginsdk.service.IEventCenterService;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.atomData.AccountAccessActivityConfig;
import com.baidu.tbadk.core.atomData.WriteActivityConfig;
import com.baidu.tbadk.core.data.AntiData;
import com.baidu.tbadk.coreExtra.data.WriteData;
import com.baidu.tbadk.coreExtra.data.x;
import com.baidu.tieba.d;
import com.baidu.tieba.tbadkCore.writeModel.NewWriteModel;
import com.baidu.tieba.tbadkCore.writeModel.PostWriteCallBackData;
import com.baidu.tieba.write.vcode.newVcode.NewVcodeView;
import com.xiaomi.mipush.sdk.Constants;
/* loaded from: classes3.dex */
public class a implements b {
    private PostWriteCallBackData hrG;
    private final NewWriteModel jmL;
    private final NewVcodeView jqC;
    private NewWriteModel.d jqD;
    private boolean jmM = false;
    private final NewWriteModel.d cks = new NewWriteModel.d() { // from class: com.baidu.tieba.write.vcode.newVcode.a.a.1
        @Override // com.baidu.tieba.tbadkCore.writeModel.NewWriteModel.d
        public void callback(boolean z, PostWriteCallBackData postWriteCallBackData, x xVar, WriteData writeData, AntiData antiData) {
            String str;
            String str2;
            String str3 = null;
            if (a.this.jqC != null) {
                a.this.jqC.showPostThreadLoadingView(false);
                if (z) {
                    a.this.hrG = postWriteCallBackData;
                    a.this.jmM = true;
                    if (xVar == null || xVar.agE() == null) {
                        str = null;
                        str2 = null;
                    } else {
                        str2 = xVar.agE().endPoint;
                        str = xVar.agE().successImg;
                        str3 = xVar.agE().slideEndPoint;
                    }
                    a.this.jqC.runJsMethod("success", str + Constants.ACCEPT_TIME_SEPARATOR_SP + str2 + Constants.ACCEPT_TIME_SEPARATOR_SP + str3);
                } else if (postWriteCallBackData == null || postWriteCallBackData.getErrorCode() != 227001) {
                    if (a.this.jqD != null) {
                        a.this.jqD.callback(false, postWriteCallBackData, xVar, writeData, antiData);
                    }
                } else {
                    a.this.jqC.getContext().setVisible(false);
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new AccountAccessActivityConfig(a.this.jqC.getContext().getActivity(), IEventCenterService.EventId.EventMode.SAPIACCOUNT_FACE_REG, writeData, postWriteCallBackData.getAccessState())));
                }
            }
        }
    };

    public a(NewVcodeView newVcodeView, NewWriteModel newWriteModel) {
        this.jqC = newVcodeView;
        this.jmL = newWriteModel;
        this.jmL.b(this.cks);
    }

    @Override // com.baidu.tieba.write.vcode.newVcode.a.b
    public boolean onUrlLoad(WebView webView, String str) {
        WriteData writeData;
        if (this.jmL.getWriteData() == null || StringUtils.isNull(str) || (writeData = this.jmL.getWriteData()) == null) {
            return false;
        }
        if (str.contains("objc:loadReady")) {
            if (writeData.getVcodeExtra() == null) {
                return false;
            }
            this.jqC.runJsMethod("handleFreshCaptcha", "'" + writeData.getVcodeUrl() + "','" + writeData.getVcodeExtra().slideImg + "','" + writeData.getVcodeExtra().textImg + "'");
            return true;
        } else if (str.contains("objc:jsChangePosition")) {
            Ez(com.baidu.tbadk.u.a.pU(str));
            return true;
        } else if (str.contains("objc:finish")) {
            this.jmM = true;
            if (writeData != null && writeData.getVideoReviewType() == 1) {
                this.jqC.showToast(true, this.jqC.getContext().getResources().getString(d.j.video_send_success_under_review));
            } else if (writeData != null && writeData.getVideoReviewType() == 2) {
                this.jqC.showToast(true, this.jqC.getContext().getResources().getString(d.j.video_send_success));
            } else {
                String str2 = null;
                String str3 = null;
                String string = this.jqC.getContext().getResources().getString(d.j.send_success);
                if (this.hrG != null) {
                    str2 = this.hrG.getPreMsg();
                    str3 = this.hrG.getColorMsg();
                    string = this.hrG.getErrorString();
                }
                if (writeData.getType() != 7) {
                    com.baidu.tieba.tbadkCore.writeModel.c.f(this.jqC.getContext().getActivity(), string, str2, str3);
                }
            }
            Intent intent = new Intent();
            Bundle bundle = new Bundle();
            bundle.putSerializable("post_write_callback_data", this.hrG);
            intent.putExtras(bundle);
            BaseActivity context = this.jqC.getContext();
            this.jqC.getContext();
            context.setResult(-1, intent);
            this.jqC.getContext().finish();
            return true;
        } else if (str.contains("objc:jumpToFeedback()")) {
            WriteActivityConfig writeActivityConfig = new WriteActivityConfig(this.jqC.getContext().getActivity(), 0, TbConfig.getPositionPagerId(), TbConfig.getPositionPagerName(), null, null, 0, null, 13003, true, false, null, false, false, null, null, null, 0);
            writeActivityConfig.setIsVcodeFeedBack();
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, writeActivityConfig));
            return true;
        } else {
            return false;
        }
    }

    @Override // com.baidu.tieba.write.vcode.newVcode.a.b
    public void onPageFinished(WebView webView, String str) {
        if (this.jqC != null) {
            this.jqC.showWebViewDelay(1000);
        }
    }

    @Override // com.baidu.tieba.write.vcode.newVcode.a.b
    public void showErrorOnStart(boolean z, String str) {
    }

    @Override // com.baidu.tieba.write.vcode.newVcode.a.b
    public void start(boolean z) {
        this.jqC.setRatio(0.9433962f);
        this.jqC.showWebView(false);
        this.jqC.getWebView().loadUrl(TbConfig.SERVER_ADDRESS_WEB_VIEW + "n/captcha-drag");
    }

    @Override // com.baidu.tieba.write.vcode.newVcode.a.b
    public void onDestroy() {
    }

    @Override // com.baidu.tieba.write.vcode.newVcode.a.b
    public void d(NewWriteModel.d dVar) {
        this.jqD = dVar;
    }

    @Override // com.baidu.tieba.write.vcode.newVcode.a.b
    public void onPostThreadCancle() {
        this.jqC.showPostThreadLoadingView(false);
        this.jmL.cancelLoadData();
    }

    private void Ez(String str) {
        this.jmM = false;
        if (!l.lo()) {
            this.jqC.getContext().showToast(d.j.neterror);
            this.jqC.getContext().finish();
        } else if (!StringUtils.isNull(str)) {
            this.jqC.showPostThreadLoadingView(true);
            this.jmL.getWriteData().setVcode(str);
            this.jmL.getWriteData().setVcodeType("5");
            this.jmL.startPostWrite();
        } else {
            this.jqC.getContext().showToast(d.j.neterror);
            this.jqC.getContext().finish();
        }
    }
}
