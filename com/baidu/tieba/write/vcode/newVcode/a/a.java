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
    private PostWriteCallBackData hIV;
    private final NewWriteModel jFz;
    private final NewVcodeView jJq;
    private NewWriteModel.d jJr;
    private boolean jFA = false;
    private final NewWriteModel.d csE = new NewWriteModel.d() { // from class: com.baidu.tieba.write.vcode.newVcode.a.a.1
        @Override // com.baidu.tieba.tbadkCore.writeModel.NewWriteModel.d
        public void callback(boolean z, PostWriteCallBackData postWriteCallBackData, x xVar, WriteData writeData, AntiData antiData) {
            String str;
            String str2;
            String str3 = null;
            if (a.this.jJq != null) {
                a.this.jJq.showPostThreadLoadingView(false);
                if (z) {
                    a.this.hIV = postWriteCallBackData;
                    a.this.jFA = true;
                    if (xVar == null || xVar.alA() == null) {
                        str = null;
                        str2 = null;
                    } else {
                        str2 = xVar.alA().endPoint;
                        str = xVar.alA().successImg;
                        str3 = xVar.alA().slideEndPoint;
                    }
                    a.this.jJq.runJsMethod("success", str + Constants.ACCEPT_TIME_SEPARATOR_SP + str2 + Constants.ACCEPT_TIME_SEPARATOR_SP + str3);
                } else if (postWriteCallBackData == null || postWriteCallBackData.getErrorCode() != 227001) {
                    if (a.this.jJr != null) {
                        a.this.jJr.callback(false, postWriteCallBackData, xVar, writeData, antiData);
                    }
                } else {
                    a.this.jJq.getContext().setVisible(false);
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new AccountAccessActivityConfig(a.this.jJq.getContext().getActivity(), IEventCenterService.EventId.EventMode.SAPIACCOUNT_FACE_REG, writeData, postWriteCallBackData.getAccessState())));
                }
            }
        }
    };

    public a(NewVcodeView newVcodeView, NewWriteModel newWriteModel) {
        this.jJq = newVcodeView;
        this.jFz = newWriteModel;
        this.jFz.b(this.csE);
    }

    @Override // com.baidu.tieba.write.vcode.newVcode.a.b
    public boolean onUrlLoad(WebView webView, String str) {
        WriteData writeData;
        if (this.jFz.getWriteData() == null || StringUtils.isNull(str) || (writeData = this.jFz.getWriteData()) == null) {
            return false;
        }
        if (str.contains("objc:loadReady")) {
            if (writeData.getVcodeExtra() == null) {
                return false;
            }
            this.jJq.runJsMethod("handleFreshCaptcha", "'" + writeData.getVcodeUrl() + "','" + writeData.getVcodeExtra().slideImg + "','" + writeData.getVcodeExtra().textImg + "'");
            return true;
        } else if (str.contains("objc:jsChangePosition")) {
            FU(com.baidu.tbadk.v.a.rb(str));
            return true;
        } else if (str.contains("objc:finish")) {
            this.jFA = true;
            if (writeData != null && writeData.getVideoReviewType() == 1) {
                this.jJq.showToast(true, this.jJq.getContext().getResources().getString(R.string.video_send_success_under_review));
            } else if (writeData != null && writeData.getVideoReviewType() == 2) {
                this.jJq.showToast(true, this.jJq.getContext().getResources().getString(R.string.video_send_success));
            } else {
                String str2 = null;
                String str3 = null;
                String string = this.jJq.getContext().getResources().getString(R.string.send_success);
                if (this.hIV != null) {
                    str2 = this.hIV.getPreMsg();
                    str3 = this.hIV.getColorMsg();
                    string = this.hIV.getErrorString();
                }
                if (writeData.getType() != 7) {
                    com.baidu.tieba.tbadkCore.writeModel.c.f(this.jJq.getContext().getActivity(), string, str2, str3);
                }
            }
            Intent intent = new Intent();
            Bundle bundle = new Bundle();
            bundle.putSerializable("post_write_callback_data", this.hIV);
            intent.putExtras(bundle);
            BaseActivity context = this.jJq.getContext();
            this.jJq.getContext();
            context.setResult(-1, intent);
            this.jJq.getContext().finish();
            return true;
        } else if (str.contains("objc:jumpToFeedback()")) {
            WriteActivityConfig writeActivityConfig = new WriteActivityConfig(this.jJq.getContext().getActivity(), 0, TbConfig.getPositionPagerId(), TbConfig.getPositionPagerName(), null, null, 0, null, 13003, true, false, null, false, false, null, null, null, 0);
            writeActivityConfig.setIsVcodeFeedBack();
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, writeActivityConfig));
            return true;
        } else {
            return false;
        }
    }

    @Override // com.baidu.tieba.write.vcode.newVcode.a.b
    public void onPageFinished(WebView webView, String str) {
        if (this.jJq != null) {
            this.jJq.showWebViewDelay(1000);
        }
    }

    @Override // com.baidu.tieba.write.vcode.newVcode.a.b
    public void showErrorOnStart(boolean z, String str) {
    }

    @Override // com.baidu.tieba.write.vcode.newVcode.a.b
    public void start(boolean z) {
        this.jJq.setRatio(0.9433962f);
        this.jJq.showWebView(false);
        this.jJq.getWebView().loadUrl(TbConfig.SERVER_ADDRESS_WEB_VIEW + "n/captcha-drag");
    }

    @Override // com.baidu.tieba.write.vcode.newVcode.a.b
    public void onDestroy() {
    }

    @Override // com.baidu.tieba.write.vcode.newVcode.a.b
    public void d(NewWriteModel.d dVar) {
        this.jJr = dVar;
    }

    @Override // com.baidu.tieba.write.vcode.newVcode.a.b
    public void onPostThreadCancle() {
        this.jJq.showPostThreadLoadingView(false);
        this.jFz.cancelLoadData();
    }

    private void FU(String str) {
        this.jFA = false;
        if (!l.ki()) {
            this.jJq.getContext().showToast(R.string.neterror);
            this.jJq.getContext().finish();
        } else if (!StringUtils.isNull(str)) {
            this.jJq.showPostThreadLoadingView(true);
            this.jFz.getWriteData().setVcode(str);
            this.jFz.getWriteData().setVcodeType("5");
            this.jFz.startPostWrite();
        } else {
            this.jJq.getContext().showToast(R.string.neterror);
            this.jJq.getContext().finish();
        }
    }
}
