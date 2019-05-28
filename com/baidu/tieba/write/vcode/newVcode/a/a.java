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
    private PostWriteCallBackData hIU;
    private final NewWriteModel jFw;
    private final NewVcodeView jJn;
    private NewWriteModel.d jJo;
    private boolean jFx = false;
    private final NewWriteModel.d csD = new NewWriteModel.d() { // from class: com.baidu.tieba.write.vcode.newVcode.a.a.1
        @Override // com.baidu.tieba.tbadkCore.writeModel.NewWriteModel.d
        public void callback(boolean z, PostWriteCallBackData postWriteCallBackData, x xVar, WriteData writeData, AntiData antiData) {
            String str;
            String str2;
            String str3 = null;
            if (a.this.jJn != null) {
                a.this.jJn.showPostThreadLoadingView(false);
                if (z) {
                    a.this.hIU = postWriteCallBackData;
                    a.this.jFx = true;
                    if (xVar == null || xVar.alA() == null) {
                        str = null;
                        str2 = null;
                    } else {
                        str2 = xVar.alA().endPoint;
                        str = xVar.alA().successImg;
                        str3 = xVar.alA().slideEndPoint;
                    }
                    a.this.jJn.runJsMethod("success", str + Constants.ACCEPT_TIME_SEPARATOR_SP + str2 + Constants.ACCEPT_TIME_SEPARATOR_SP + str3);
                } else if (postWriteCallBackData == null || postWriteCallBackData.getErrorCode() != 227001) {
                    if (a.this.jJo != null) {
                        a.this.jJo.callback(false, postWriteCallBackData, xVar, writeData, antiData);
                    }
                } else {
                    a.this.jJn.getContext().setVisible(false);
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new AccountAccessActivityConfig(a.this.jJn.getContext().getActivity(), IEventCenterService.EventId.EventMode.SAPIACCOUNT_FACE_REG, writeData, postWriteCallBackData.getAccessState())));
                }
            }
        }
    };

    public a(NewVcodeView newVcodeView, NewWriteModel newWriteModel) {
        this.jJn = newVcodeView;
        this.jFw = newWriteModel;
        this.jFw.b(this.csD);
    }

    @Override // com.baidu.tieba.write.vcode.newVcode.a.b
    public boolean onUrlLoad(WebView webView, String str) {
        WriteData writeData;
        if (this.jFw.getWriteData() == null || StringUtils.isNull(str) || (writeData = this.jFw.getWriteData()) == null) {
            return false;
        }
        if (str.contains("objc:loadReady")) {
            if (writeData.getVcodeExtra() == null) {
                return false;
            }
            this.jJn.runJsMethod("handleFreshCaptcha", "'" + writeData.getVcodeUrl() + "','" + writeData.getVcodeExtra().slideImg + "','" + writeData.getVcodeExtra().textImg + "'");
            return true;
        } else if (str.contains("objc:jsChangePosition")) {
            FS(com.baidu.tbadk.v.a.rc(str));
            return true;
        } else if (str.contains("objc:finish")) {
            this.jFx = true;
            if (writeData != null && writeData.getVideoReviewType() == 1) {
                this.jJn.showToast(true, this.jJn.getContext().getResources().getString(R.string.video_send_success_under_review));
            } else if (writeData != null && writeData.getVideoReviewType() == 2) {
                this.jJn.showToast(true, this.jJn.getContext().getResources().getString(R.string.video_send_success));
            } else {
                String str2 = null;
                String str3 = null;
                String string = this.jJn.getContext().getResources().getString(R.string.send_success);
                if (this.hIU != null) {
                    str2 = this.hIU.getPreMsg();
                    str3 = this.hIU.getColorMsg();
                    string = this.hIU.getErrorString();
                }
                if (writeData.getType() != 7) {
                    com.baidu.tieba.tbadkCore.writeModel.c.f(this.jJn.getContext().getActivity(), string, str2, str3);
                }
            }
            Intent intent = new Intent();
            Bundle bundle = new Bundle();
            bundle.putSerializable("post_write_callback_data", this.hIU);
            intent.putExtras(bundle);
            BaseActivity context = this.jJn.getContext();
            this.jJn.getContext();
            context.setResult(-1, intent);
            this.jJn.getContext().finish();
            return true;
        } else if (str.contains("objc:jumpToFeedback()")) {
            WriteActivityConfig writeActivityConfig = new WriteActivityConfig(this.jJn.getContext().getActivity(), 0, TbConfig.getPositionPagerId(), TbConfig.getPositionPagerName(), null, null, 0, null, 13003, true, false, null, false, false, null, null, null, 0);
            writeActivityConfig.setIsVcodeFeedBack();
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, writeActivityConfig));
            return true;
        } else {
            return false;
        }
    }

    @Override // com.baidu.tieba.write.vcode.newVcode.a.b
    public void onPageFinished(WebView webView, String str) {
        if (this.jJn != null) {
            this.jJn.showWebViewDelay(1000);
        }
    }

    @Override // com.baidu.tieba.write.vcode.newVcode.a.b
    public void showErrorOnStart(boolean z, String str) {
    }

    @Override // com.baidu.tieba.write.vcode.newVcode.a.b
    public void start(boolean z) {
        this.jJn.setRatio(0.9433962f);
        this.jJn.showWebView(false);
        this.jJn.getWebView().loadUrl(TbConfig.SERVER_ADDRESS_WEB_VIEW + "n/captcha-drag");
    }

    @Override // com.baidu.tieba.write.vcode.newVcode.a.b
    public void onDestroy() {
    }

    @Override // com.baidu.tieba.write.vcode.newVcode.a.b
    public void d(NewWriteModel.d dVar) {
        this.jJo = dVar;
    }

    @Override // com.baidu.tieba.write.vcode.newVcode.a.b
    public void onPostThreadCancle() {
        this.jJn.showPostThreadLoadingView(false);
        this.jFw.cancelLoadData();
    }

    private void FS(String str) {
        this.jFx = false;
        if (!l.ki()) {
            this.jJn.getContext().showToast(R.string.neterror);
            this.jJn.getContext().finish();
        } else if (!StringUtils.isNull(str)) {
            this.jJn.showPostThreadLoadingView(true);
            this.jFw.getWriteData().setVcode(str);
            this.jFw.getWriteData().setVcodeType("5");
            this.jFw.startPostWrite();
        } else {
            this.jJn.getContext().showToast(R.string.neterror);
            this.jJn.getContext().finish();
        }
    }
}
