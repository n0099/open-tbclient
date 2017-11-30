package com.baidu.tieba.write.vcode.newVcode.a;

import android.content.Intent;
import android.os.Bundle;
import android.webkit.WebView;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.lib.util.l;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.atomData.AccountAccessActivityConfig;
import com.baidu.tbadk.core.atomData.WriteActivityConfig;
import com.baidu.tbadk.core.data.AntiData;
import com.baidu.tbadk.core.diskCache.ImagesInvalidReceiver;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.coreExtra.data.WriteData;
import com.baidu.tbadk.coreExtra.data.r;
import com.baidu.tieba.d;
import com.baidu.tieba.tbadkCore.writeModel.NewWriteModel;
import com.baidu.tieba.tbadkCore.writeModel.PostWriteCallBackData;
import com.baidu.tieba.write.vcode.newVcode.NewVcodeView;
import com.xiaomi.mipush.sdk.Constants;
/* loaded from: classes2.dex */
public class a implements b {
    private PostWriteCallBackData eWx;
    private final NewWriteModel hcc;
    private final NewVcodeView hfd;
    private NewWriteModel.d hfe;
    private boolean hcd = false;
    private final NewWriteModel.d aDN = new NewWriteModel.d() { // from class: com.baidu.tieba.write.vcode.newVcode.a.a.1
        @Override // com.baidu.tieba.tbadkCore.writeModel.NewWriteModel.d
        public void callback(boolean z, PostWriteCallBackData postWriteCallBackData, r rVar, WriteData writeData, AntiData antiData) {
            String str;
            String str2;
            String str3 = null;
            if (a.this.hfd != null) {
                a.this.hfd.showPostThreadLoadingView(false);
                if (z) {
                    a.this.eWx = postWriteCallBackData;
                    a.this.hcd = true;
                    if (rVar == null || rVar.yj() == null) {
                        str = null;
                        str2 = null;
                    } else {
                        str2 = rVar.yj().endPoint;
                        str = rVar.yj().successImg;
                        str3 = rVar.yj().slideEndPoint;
                    }
                    a.this.hfd.runJsMethod(ImagesInvalidReceiver.SUCCESS, str + Constants.ACCEPT_TIME_SEPARATOR_SP + str2 + Constants.ACCEPT_TIME_SEPARATOR_SP + str3);
                } else if (postWriteCallBackData == null || postWriteCallBackData.getErrorCode() != 227001) {
                    if (a.this.hfe != null) {
                        a.this.hfe.callback(false, postWriteCallBackData, rVar, writeData, antiData);
                    }
                } else {
                    a.this.hfd.getContext().setVisible(false);
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AccountAccessActivityConfig(a.this.hfd.getContext().getActivity(), 12006, writeData, postWriteCallBackData.getAccessState())));
                }
            }
        }
    };

    public a(NewVcodeView newVcodeView, NewWriteModel newWriteModel) {
        this.hfd = newVcodeView;
        this.hcc = newWriteModel;
        this.hcc.b(this.aDN);
    }

    @Override // com.baidu.tieba.write.vcode.newVcode.a.b
    public boolean onUrlLoad(WebView webView, String str) {
        WriteData writeData;
        if (this.hcc.getWriteData() == null || StringUtils.isNull(str) || (writeData = this.hcc.getWriteData()) == null) {
            return false;
        }
        if (str.contains("objc:loadReady")) {
            if (writeData.getVcodeExtra() == null) {
                return false;
            }
            this.hfd.runJsMethod("handleFreshCaptcha", "'" + writeData.getVcodeUrl() + "','" + writeData.getVcodeExtra().slideImg + "','" + writeData.getVcodeExtra().textImg + "'");
            return true;
        } else if (str.contains("objc:jsChangePosition")) {
            sA(com.baidu.tbadk.p.a.hd(str));
            return true;
        } else if (str.contains("objc:finish")) {
            this.hcd = true;
            if (writeData != null && writeData.getVideoReviewType() == 1 && writeData.getIsStory() != 1) {
                this.hfd.showToast(true, this.hfd.getContext().getResources().getString(d.j.video_send_success_under_review));
            } else if (writeData != null && writeData.getVideoReviewType() == 2 && writeData.getIsStory() != 1) {
                this.hfd.showToast(true, this.hfd.getContext().getResources().getString(d.j.video_send_success));
            } else if (writeData.getIsStory() != 1) {
                String str2 = null;
                String str3 = null;
                String string = this.hfd.getContext().getResources().getString(d.j.send_success);
                if (this.eWx != null) {
                    str2 = this.eWx.getPreMsg();
                    str3 = this.eWx.getColorMsg();
                    string = this.eWx.getErrorString();
                }
                if (writeData.getType() != 7) {
                    com.baidu.tieba.tbadkCore.writeModel.c.d(this.hfd.getContext().getActivity(), string, str2, str3);
                }
            }
            Intent intent = new Intent();
            Bundle bundle = new Bundle();
            bundle.putSerializable("post_write_callback_data", this.eWx);
            intent.putExtras(bundle);
            BaseActivity context = this.hfd.getContext();
            this.hfd.getContext();
            context.setResult(-1, intent);
            this.hfd.getContext().finish();
            return true;
        } else if (str.contains("objc:jumpToFeedback()")) {
            WriteActivityConfig writeActivityConfig = new WriteActivityConfig(this.hfd.getContext().getActivity(), 0, TbConfig.getPositionPagerId(), TbConfig.getPositionPagerName(), null, null, 0, null, 13003, true, false, null, false, false, null, null, null, 0);
            writeActivityConfig.setIsVcodeFeedBack();
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, writeActivityConfig));
            return true;
        } else {
            return false;
        }
    }

    @Override // com.baidu.tieba.write.vcode.newVcode.a.b
    public void onPageFinished(WebView webView, String str) {
        if (this.hfd != null) {
            this.hfd.showWebViewDelay(1000);
        }
    }

    @Override // com.baidu.tieba.write.vcode.newVcode.a.b
    public void showErrorOnStart(boolean z, String str) {
    }

    @Override // com.baidu.tieba.write.vcode.newVcode.a.b
    public void start(boolean z) {
        this.hfd.setRatio(0.9433962f);
        this.hfd.showWebView(false);
        this.hfd.getWebView().loadUrl(TbConfig.SERVER_ADDRESS_WEB_VIEW + "n/captcha-drag");
    }

    @Override // com.baidu.tieba.write.vcode.newVcode.a.b
    public void onDestroy() {
    }

    @Override // com.baidu.tieba.write.vcode.newVcode.a.b
    public void d(NewWriteModel.d dVar) {
        this.hfe = dVar;
    }

    @Override // com.baidu.tieba.write.vcode.newVcode.a.b
    public void onPostThreadCancle() {
        this.hfd.showPostThreadLoadingView(false);
        this.hcc.cancelLoadData();
    }

    @Override // com.baidu.tieba.write.vcode.newVcode.a.b
    public boolean bFg() {
        return this.hcd;
    }

    private void sA(String str) {
        this.hcd = false;
        if (!l.hy()) {
            this.hfd.getContext().showToast(d.j.neterror);
            this.hfd.getContext().finish();
        } else if (!StringUtils.isNull(str)) {
            this.hfd.showPostThreadLoadingView(true);
            this.hcc.getWriteData().setVcode(str);
            this.hcc.getWriteData().setVcodeType("5");
            this.hcc.startPostWrite();
        } else {
            this.hfd.getContext().showToast(d.j.neterror);
            this.hfd.getContext().finish();
        }
    }
}
