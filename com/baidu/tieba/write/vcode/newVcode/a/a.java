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
import com.baidu.tbadk.coreExtra.data.q;
import com.baidu.tieba.d;
import com.baidu.tieba.tbadkCore.writeModel.NewWriteModel;
import com.baidu.tieba.tbadkCore.writeModel.PostWriteCallBackData;
import com.baidu.tieba.write.vcode.newVcode.NewVcodeView;
import com.xiaomi.mipush.sdk.Constants;
/* loaded from: classes2.dex */
public class a implements b {
    private final NewWriteModel gGb;
    private final NewVcodeView gJd;
    private PostWriteCallBackData gJe;
    private NewWriteModel.d gJf;
    private boolean gGc = false;
    private final NewWriteModel.d aCE = new NewWriteModel.d() { // from class: com.baidu.tieba.write.vcode.newVcode.a.a.1
        @Override // com.baidu.tieba.tbadkCore.writeModel.NewWriteModel.d
        public void callback(boolean z, PostWriteCallBackData postWriteCallBackData, q qVar, WriteData writeData, AntiData antiData) {
            String str;
            String str2;
            String str3 = null;
            if (a.this.gJd != null) {
                a.this.gJd.showPostThreadLoadingView(false);
                if (z) {
                    a.this.gJe = postWriteCallBackData;
                    a.this.gGc = true;
                    if (qVar == null || qVar.xT() == null) {
                        str = null;
                        str2 = null;
                    } else {
                        str2 = qVar.xT().endPoint;
                        str = qVar.xT().successImg;
                        str3 = qVar.xT().slideEndPoint;
                    }
                    a.this.gJd.runJsMethod(ImagesInvalidReceiver.SUCCESS, str + Constants.ACCEPT_TIME_SEPARATOR_SP + str2 + Constants.ACCEPT_TIME_SEPARATOR_SP + str3);
                } else if (postWriteCallBackData == null || postWriteCallBackData.getErrorCode() != 227001) {
                    if (a.this.gJf != null) {
                        a.this.gJf.callback(false, postWriteCallBackData, qVar, writeData, antiData);
                    }
                } else {
                    a.this.gJd.getContext().setVisible(false);
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AccountAccessActivityConfig(a.this.gJd.getContext().getActivity(), 12006, writeData, postWriteCallBackData.getAccessState())));
                }
            }
        }
    };

    public a(NewVcodeView newVcodeView, NewWriteModel newWriteModel) {
        this.gJd = newVcodeView;
        this.gGb = newWriteModel;
        this.gGb.b(this.aCE);
    }

    @Override // com.baidu.tieba.write.vcode.newVcode.a.b
    public boolean onUrlLoad(WebView webView, String str) {
        WriteData writeData;
        if (this.gGb.getWriteData() == null || StringUtils.isNull(str) || (writeData = this.gGb.getWriteData()) == null) {
            return false;
        }
        if (str.contains("objc:loadReady")) {
            if (writeData.getVcodeExtra() == null) {
                return false;
            }
            this.gJd.runJsMethod("handleFreshCaptcha", "'" + writeData.getVcodeUrl() + "','" + writeData.getVcodeExtra().slideImg + "','" + writeData.getVcodeExtra().textImg + "'");
            return true;
        } else if (str.contains("objc:jsChangePosition")) {
            rq(com.baidu.tbadk.p.a.gR(str));
            return true;
        } else if (str.contains("objc:finish")) {
            this.gGc = true;
            if (writeData != null && writeData.getVideoReviewType() == 1 && writeData.getIsStory() != 1) {
                this.gJd.showToast(true, this.gJd.getContext().getResources().getString(d.l.video_send_success_under_review));
            } else if (writeData != null && writeData.getVideoReviewType() == 2 && writeData.getIsStory() != 1) {
                this.gJd.showToast(true, this.gJd.getContext().getResources().getString(d.l.video_send_success));
            } else if (writeData.getIsStory() != 1) {
                String str2 = null;
                String str3 = null;
                String string = this.gJd.getContext().getResources().getString(d.l.send_success);
                if (this.gJe != null) {
                    str2 = this.gJe.getPreMsg();
                    str3 = this.gJe.getColorMsg();
                    string = this.gJe.getErrorString();
                }
                if (writeData.getType() != 7) {
                    com.baidu.tieba.tbadkCore.writeModel.c.d(this.gJd.getContext().getActivity(), string, str2, str3);
                }
            }
            Intent intent = new Intent();
            Bundle bundle = new Bundle();
            bundle.putSerializable(WriteActivityConfig.POST_WRITE_CALLBACK_DATA, this.gJe);
            intent.putExtras(bundle);
            BaseActivity context = this.gJd.getContext();
            this.gJd.getContext();
            context.setResult(-1, intent);
            this.gJd.getContext().finish();
            return true;
        } else if (str.contains("objc:jumpToFeedback()")) {
            WriteActivityConfig writeActivityConfig = new WriteActivityConfig(this.gJd.getContext().getActivity(), 0, TbConfig.getPositionPagerId(), TbConfig.getPositionPagerName(), null, null, 0, null, 13003, true, false, null, false, false, null, null, null, 0);
            writeActivityConfig.setIsVcodeFeedBack();
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, writeActivityConfig));
            return true;
        } else {
            return false;
        }
    }

    @Override // com.baidu.tieba.write.vcode.newVcode.a.b
    public void onPageFinished(WebView webView, String str) {
        if (this.gJd != null) {
            this.gJd.showWebViewDelay(1000);
        }
    }

    @Override // com.baidu.tieba.write.vcode.newVcode.a.b
    public void showErrorOnStart(boolean z, String str) {
    }

    @Override // com.baidu.tieba.write.vcode.newVcode.a.b
    public void start(boolean z) {
        this.gJd.setRatio(0.9433962f);
        this.gJd.showWebView(false);
        this.gJd.getWebView().loadUrl(TbConfig.SERVER_ADDRESS_WEB_VIEW + "n/captcha-drag");
    }

    @Override // com.baidu.tieba.write.vcode.newVcode.a.b
    public void onDestroy() {
    }

    @Override // com.baidu.tieba.write.vcode.newVcode.a.b
    public void d(NewWriteModel.d dVar) {
        this.gJf = dVar;
    }

    @Override // com.baidu.tieba.write.vcode.newVcode.a.b
    public void onPostThreadCancle() {
        this.gJd.showPostThreadLoadingView(false);
        this.gGb.cancelLoadData();
    }

    @Override // com.baidu.tieba.write.vcode.newVcode.a.b
    public boolean byV() {
        return this.gGc;
    }

    private void rq(String str) {
        this.gGc = false;
        if (!l.hy()) {
            this.gJd.getContext().showToast(d.l.neterror);
            this.gJd.getContext().finish();
        } else if (!StringUtils.isNull(str)) {
            this.gJd.showPostThreadLoadingView(true);
            this.gGb.getWriteData().setVcode(str);
            this.gGb.getWriteData().setVcodeType("5");
            this.gGb.startPostWrite();
        } else {
            this.gJd.getContext().showToast(d.l.neterror);
            this.gJd.getContext().finish();
        }
    }
}
