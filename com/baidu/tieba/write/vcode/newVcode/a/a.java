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
import com.baidu.tieba.R;
import com.baidu.tieba.tbadkCore.writeModel.NewWriteModel;
import com.baidu.tieba.tbadkCore.writeModel.PostWriteCallBackData;
import com.baidu.tieba.write.vcode.newVcode.NewVcodeView;
import com.xiaomi.mipush.sdk.Constants;
/* loaded from: classes3.dex */
public class a implements b {
    private PostWriteCallBackData hIR;
    private final NewWriteModel jFv;
    private final NewVcodeView jJm;
    private NewWriteModel.d jJn;
    private boolean jFw = false;
    private final NewWriteModel.d csD = new NewWriteModel.d() { // from class: com.baidu.tieba.write.vcode.newVcode.a.a.1
        @Override // com.baidu.tieba.tbadkCore.writeModel.NewWriteModel.d
        public void callback(boolean z, PostWriteCallBackData postWriteCallBackData, x xVar, WriteData writeData, AntiData antiData) {
            String str;
            String str2;
            String str3 = null;
            if (a.this.jJm != null) {
                a.this.jJm.showPostThreadLoadingView(false);
                if (z) {
                    a.this.hIR = postWriteCallBackData;
                    a.this.jFw = true;
                    if (xVar == null || xVar.alA() == null) {
                        str = null;
                        str2 = null;
                    } else {
                        str2 = xVar.alA().endPoint;
                        str = xVar.alA().successImg;
                        str3 = xVar.alA().slideEndPoint;
                    }
                    a.this.jJm.runJsMethod("success", str + Constants.ACCEPT_TIME_SEPARATOR_SP + str2 + Constants.ACCEPT_TIME_SEPARATOR_SP + str3);
                } else if (postWriteCallBackData == null || postWriteCallBackData.getErrorCode() != 227001) {
                    if (a.this.jJn != null) {
                        a.this.jJn.callback(false, postWriteCallBackData, xVar, writeData, antiData);
                    }
                } else {
                    a.this.jJm.getContext().setVisible(false);
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new AccountAccessActivityConfig(a.this.jJm.getContext().getActivity(), IEventCenterService.EventId.EventMode.SAPIACCOUNT_FACE_REG, writeData, postWriteCallBackData.getAccessState())));
                }
            }
        }
    };

    public a(NewVcodeView newVcodeView, NewWriteModel newWriteModel) {
        this.jJm = newVcodeView;
        this.jFv = newWriteModel;
        this.jFv.b(this.csD);
    }

    @Override // com.baidu.tieba.write.vcode.newVcode.a.b
    public boolean onUrlLoad(WebView webView, String str) {
        WriteData writeData;
        if (this.jFv.getWriteData() == null || StringUtils.isNull(str) || (writeData = this.jFv.getWriteData()) == null) {
            return false;
        }
        if (str.contains("objc:loadReady")) {
            if (writeData.getVcodeExtra() == null) {
                return false;
            }
            this.jJm.runJsMethod("handleFreshCaptcha", "'" + writeData.getVcodeUrl() + "','" + writeData.getVcodeExtra().slideImg + "','" + writeData.getVcodeExtra().textImg + "'");
            return true;
        } else if (str.contains("objc:jsChangePosition")) {
            FS(com.baidu.tbadk.v.a.rc(str));
            return true;
        } else if (str.contains("objc:finish")) {
            this.jFw = true;
            if (writeData != null && writeData.getVideoReviewType() == 1) {
                this.jJm.showToast(true, this.jJm.getContext().getResources().getString(R.string.video_send_success_under_review));
            } else if (writeData != null && writeData.getVideoReviewType() == 2) {
                this.jJm.showToast(true, this.jJm.getContext().getResources().getString(R.string.video_send_success));
            } else {
                String str2 = null;
                String str3 = null;
                String string = this.jJm.getContext().getResources().getString(R.string.send_success);
                if (this.hIR != null) {
                    str2 = this.hIR.getPreMsg();
                    str3 = this.hIR.getColorMsg();
                    string = this.hIR.getErrorString();
                }
                if (writeData.getType() != 7) {
                    com.baidu.tieba.tbadkCore.writeModel.c.f(this.jJm.getContext().getActivity(), string, str2, str3);
                }
            }
            Intent intent = new Intent();
            Bundle bundle = new Bundle();
            bundle.putSerializable("post_write_callback_data", this.hIR);
            intent.putExtras(bundle);
            BaseActivity context = this.jJm.getContext();
            this.jJm.getContext();
            context.setResult(-1, intent);
            this.jJm.getContext().finish();
            return true;
        } else if (str.contains("objc:jumpToFeedback()")) {
            WriteActivityConfig writeActivityConfig = new WriteActivityConfig(this.jJm.getContext().getActivity(), 0, TbConfig.getPositionPagerId(), TbConfig.getPositionPagerName(), null, null, 0, null, 13003, true, false, null, false, false, null, null, null, 0);
            writeActivityConfig.setIsVcodeFeedBack();
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, writeActivityConfig));
            return true;
        } else {
            return false;
        }
    }

    @Override // com.baidu.tieba.write.vcode.newVcode.a.b
    public void onPageFinished(WebView webView, String str) {
        if (this.jJm != null) {
            this.jJm.showWebViewDelay(1000);
        }
    }

    @Override // com.baidu.tieba.write.vcode.newVcode.a.b
    public void showErrorOnStart(boolean z, String str) {
    }

    @Override // com.baidu.tieba.write.vcode.newVcode.a.b
    public void start(boolean z) {
        this.jJm.setRatio(0.9433962f);
        this.jJm.showWebView(false);
        this.jJm.getWebView().loadUrl(TbConfig.SERVER_ADDRESS_WEB_VIEW + "n/captcha-drag");
    }

    @Override // com.baidu.tieba.write.vcode.newVcode.a.b
    public void onDestroy() {
    }

    @Override // com.baidu.tieba.write.vcode.newVcode.a.b
    public void d(NewWriteModel.d dVar) {
        this.jJn = dVar;
    }

    @Override // com.baidu.tieba.write.vcode.newVcode.a.b
    public void onPostThreadCancle() {
        this.jJm.showPostThreadLoadingView(false);
        this.jFv.cancelLoadData();
    }

    private void FS(String str) {
        this.jFw = false;
        if (!l.ki()) {
            this.jJm.getContext().showToast(R.string.neterror);
            this.jJm.getContext().finish();
        } else if (!StringUtils.isNull(str)) {
            this.jJm.showPostThreadLoadingView(true);
            this.jFv.getWriteData().setVcode(str);
            this.jFv.getWriteData().setVcodeType("5");
            this.jFv.startPostWrite();
        } else {
            this.jJm.getContext().showToast(R.string.neterror);
            this.jJm.getContext().finish();
        }
    }
}
