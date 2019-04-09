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
    private PostWriteCallBackData hrn;
    private final NewWriteModel jms;
    private final NewVcodeView jqk;
    private NewWriteModel.d jql;
    private boolean jmt = false;
    private final NewWriteModel.d ckv = new NewWriteModel.d() { // from class: com.baidu.tieba.write.vcode.newVcode.a.a.1
        @Override // com.baidu.tieba.tbadkCore.writeModel.NewWriteModel.d
        public void callback(boolean z, PostWriteCallBackData postWriteCallBackData, x xVar, WriteData writeData, AntiData antiData) {
            String str;
            String str2;
            String str3 = null;
            if (a.this.jqk != null) {
                a.this.jqk.showPostThreadLoadingView(false);
                if (z) {
                    a.this.hrn = postWriteCallBackData;
                    a.this.jmt = true;
                    if (xVar == null || xVar.agB() == null) {
                        str = null;
                        str2 = null;
                    } else {
                        str2 = xVar.agB().endPoint;
                        str = xVar.agB().successImg;
                        str3 = xVar.agB().slideEndPoint;
                    }
                    a.this.jqk.runJsMethod("success", str + Constants.ACCEPT_TIME_SEPARATOR_SP + str2 + Constants.ACCEPT_TIME_SEPARATOR_SP + str3);
                } else if (postWriteCallBackData == null || postWriteCallBackData.getErrorCode() != 227001) {
                    if (a.this.jql != null) {
                        a.this.jql.callback(false, postWriteCallBackData, xVar, writeData, antiData);
                    }
                } else {
                    a.this.jqk.getContext().setVisible(false);
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new AccountAccessActivityConfig(a.this.jqk.getContext().getActivity(), IEventCenterService.EventId.EventMode.SAPIACCOUNT_FACE_REG, writeData, postWriteCallBackData.getAccessState())));
                }
            }
        }
    };

    public a(NewVcodeView newVcodeView, NewWriteModel newWriteModel) {
        this.jqk = newVcodeView;
        this.jms = newWriteModel;
        this.jms.b(this.ckv);
    }

    @Override // com.baidu.tieba.write.vcode.newVcode.a.b
    public boolean onUrlLoad(WebView webView, String str) {
        WriteData writeData;
        if (this.jms.getWriteData() == null || StringUtils.isNull(str) || (writeData = this.jms.getWriteData()) == null) {
            return false;
        }
        if (str.contains("objc:loadReady")) {
            if (writeData.getVcodeExtra() == null) {
                return false;
            }
            this.jqk.runJsMethod("handleFreshCaptcha", "'" + writeData.getVcodeUrl() + "','" + writeData.getVcodeExtra().slideImg + "','" + writeData.getVcodeExtra().textImg + "'");
            return true;
        } else if (str.contains("objc:jsChangePosition")) {
            Ew(com.baidu.tbadk.u.a.pT(str));
            return true;
        } else if (str.contains("objc:finish")) {
            this.jmt = true;
            if (writeData != null && writeData.getVideoReviewType() == 1) {
                this.jqk.showToast(true, this.jqk.getContext().getResources().getString(d.j.video_send_success_under_review));
            } else if (writeData != null && writeData.getVideoReviewType() == 2) {
                this.jqk.showToast(true, this.jqk.getContext().getResources().getString(d.j.video_send_success));
            } else {
                String str2 = null;
                String str3 = null;
                String string = this.jqk.getContext().getResources().getString(d.j.send_success);
                if (this.hrn != null) {
                    str2 = this.hrn.getPreMsg();
                    str3 = this.hrn.getColorMsg();
                    string = this.hrn.getErrorString();
                }
                if (writeData.getType() != 7) {
                    com.baidu.tieba.tbadkCore.writeModel.c.f(this.jqk.getContext().getActivity(), string, str2, str3);
                }
            }
            Intent intent = new Intent();
            Bundle bundle = new Bundle();
            bundle.putSerializable("post_write_callback_data", this.hrn);
            intent.putExtras(bundle);
            BaseActivity context = this.jqk.getContext();
            this.jqk.getContext();
            context.setResult(-1, intent);
            this.jqk.getContext().finish();
            return true;
        } else if (str.contains("objc:jumpToFeedback()")) {
            WriteActivityConfig writeActivityConfig = new WriteActivityConfig(this.jqk.getContext().getActivity(), 0, TbConfig.getPositionPagerId(), TbConfig.getPositionPagerName(), null, null, 0, null, 13003, true, false, null, false, false, null, null, null, 0);
            writeActivityConfig.setIsVcodeFeedBack();
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, writeActivityConfig));
            return true;
        } else {
            return false;
        }
    }

    @Override // com.baidu.tieba.write.vcode.newVcode.a.b
    public void onPageFinished(WebView webView, String str) {
        if (this.jqk != null) {
            this.jqk.showWebViewDelay(1000);
        }
    }

    @Override // com.baidu.tieba.write.vcode.newVcode.a.b
    public void showErrorOnStart(boolean z, String str) {
    }

    @Override // com.baidu.tieba.write.vcode.newVcode.a.b
    public void start(boolean z) {
        this.jqk.setRatio(0.9433962f);
        this.jqk.showWebView(false);
        this.jqk.getWebView().loadUrl(TbConfig.SERVER_ADDRESS_WEB_VIEW + "n/captcha-drag");
    }

    @Override // com.baidu.tieba.write.vcode.newVcode.a.b
    public void onDestroy() {
    }

    @Override // com.baidu.tieba.write.vcode.newVcode.a.b
    public void d(NewWriteModel.d dVar) {
        this.jql = dVar;
    }

    @Override // com.baidu.tieba.write.vcode.newVcode.a.b
    public void onPostThreadCancle() {
        this.jqk.showPostThreadLoadingView(false);
        this.jms.cancelLoadData();
    }

    private void Ew(String str) {
        this.jmt = false;
        if (!l.lo()) {
            this.jqk.getContext().showToast(d.j.neterror);
            this.jqk.getContext().finish();
        } else if (!StringUtils.isNull(str)) {
            this.jqk.showPostThreadLoadingView(true);
            this.jms.getWriteData().setVcode(str);
            this.jms.getWriteData().setVcodeType("5");
            this.jms.startPostWrite();
        } else {
            this.jqk.getContext().showToast(d.j.neterror);
            this.jqk.getContext().finish();
        }
    }
}
