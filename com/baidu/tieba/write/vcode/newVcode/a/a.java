package com.baidu.tieba.write.vcode.newVcode.a;

import android.content.Intent;
import android.os.Bundle;
import android.webkit.WebView;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.lib.util.k;
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
/* loaded from: classes.dex */
public class a implements b {
    private final NewWriteModel gBC;
    private final NewVcodeView gEY;
    private PostWriteCallBackData gEZ;
    private NewWriteModel.d gFa;
    private boolean gBD = false;
    private final NewWriteModel.d aEn = new NewWriteModel.d() { // from class: com.baidu.tieba.write.vcode.newVcode.a.a.1
        @Override // com.baidu.tieba.tbadkCore.writeModel.NewWriteModel.d
        public void callback(boolean z, PostWriteCallBackData postWriteCallBackData, q qVar, WriteData writeData, AntiData antiData) {
            String str;
            String str2;
            String str3 = null;
            if (a.this.gEY != null) {
                a.this.gEY.showPostThreadLoadingView(false);
                if (z) {
                    a.this.gEZ = postWriteCallBackData;
                    a.this.gBD = true;
                    if (qVar == null || qVar.yy() == null) {
                        str = null;
                        str2 = null;
                    } else {
                        str2 = qVar.yy().endPoint;
                        str = qVar.yy().successImg;
                        str3 = qVar.yy().slideEndPoint;
                    }
                    a.this.gEY.runJsMethod(ImagesInvalidReceiver.SUCCESS, str + Constants.ACCEPT_TIME_SEPARATOR_SP + str2 + Constants.ACCEPT_TIME_SEPARATOR_SP + str3);
                } else if (postWriteCallBackData == null || postWriteCallBackData.getErrorCode() != 227001) {
                    if (a.this.gFa != null) {
                        a.this.gFa.callback(false, postWriteCallBackData, qVar, writeData, antiData);
                    }
                } else {
                    a.this.gEY.getContext().setVisible(false);
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AccountAccessActivityConfig(a.this.gEY.getContext().getActivity(), 12006, writeData, postWriteCallBackData.getAccessState())));
                }
            }
        }
    };

    public a(NewVcodeView newVcodeView, NewWriteModel newWriteModel) {
        this.gEY = newVcodeView;
        this.gBC = newWriteModel;
        this.gBC.b(this.aEn);
    }

    @Override // com.baidu.tieba.write.vcode.newVcode.a.b
    public boolean onUrlLoad(WebView webView, String str) {
        WriteData writeData;
        if (this.gBC.getWriteData() == null || StringUtils.isNull(str) || (writeData = this.gBC.getWriteData()) == null) {
            return false;
        }
        if (str.contains("objc:loadReady")) {
            if (writeData.getVcodeExtra() == null) {
                return false;
            }
            this.gEY.runJsMethod("handleFreshCaptcha", "'" + writeData.getVcodeUrl() + "','" + writeData.getVcodeExtra().slideImg + "','" + writeData.getVcodeExtra().textImg + "'");
            return true;
        } else if (str.contains("objc:jsChangePosition")) {
            rK(com.baidu.tbadk.q.a.ha(str));
            return true;
        } else if (str.contains("objc:finish")) {
            this.gBD = true;
            if (writeData != null && writeData.getVideoReviewType() == 1 && writeData.getIsStory() != 1) {
                this.gEY.showToast(true, this.gEY.getContext().getResources().getString(d.l.video_send_success_under_review));
            } else if (writeData != null && writeData.getVideoReviewType() == 2 && writeData.getIsStory() != 1) {
                this.gEY.showToast(true, this.gEY.getContext().getResources().getString(d.l.video_send_success));
            } else if (writeData.getIsStory() != 1) {
                String str2 = null;
                String str3 = null;
                String string = this.gEY.getContext().getResources().getString(d.l.send_success);
                if (this.gEZ != null) {
                    str2 = this.gEZ.getPreMsg();
                    str3 = this.gEZ.getColorMsg();
                    string = this.gEZ.getErrorString();
                }
                if (writeData.getType() != 7) {
                    com.baidu.tieba.tbadkCore.writeModel.c.c(this.gEY.getContext().getActivity(), string, str2, str3);
                }
            }
            Intent intent = new Intent();
            Bundle bundle = new Bundle();
            bundle.putSerializable(WriteActivityConfig.POST_WRITE_CALLBACK_DATA, this.gEZ);
            intent.putExtras(bundle);
            BaseActivity context = this.gEY.getContext();
            this.gEY.getContext();
            context.setResult(-1, intent);
            this.gEY.getContext().finish();
            return true;
        } else if (str.contains("objc:jumpToFeedback()")) {
            WriteActivityConfig writeActivityConfig = new WriteActivityConfig(this.gEY.getContext().getActivity(), 0, TbConfig.getPositionPagerId(), TbConfig.getPositionPagerName(), null, null, 0, null, 13003, true, false, null, false, false, null, null, null, 0);
            writeActivityConfig.setIsVcodeFeedBack();
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, writeActivityConfig));
            return true;
        } else {
            return false;
        }
    }

    @Override // com.baidu.tieba.write.vcode.newVcode.a.b
    public void onPageFinished(WebView webView, String str) {
        if (this.gEY != null) {
            this.gEY.showWebViewDelay(1000);
        }
    }

    @Override // com.baidu.tieba.write.vcode.newVcode.a.b
    public void showErrorOnStart(boolean z, String str) {
    }

    @Override // com.baidu.tieba.write.vcode.newVcode.a.b
    public void start(boolean z) {
        this.gEY.setRatio(0.9433962f);
        this.gEY.showWebView(false);
        this.gEY.getWebView().loadUrl(TbConfig.SERVER_ADDRESS_WEB_VIEW + "n/captcha-drag");
    }

    @Override // com.baidu.tieba.write.vcode.newVcode.a.b
    public void onDestroy() {
    }

    @Override // com.baidu.tieba.write.vcode.newVcode.a.b
    public void d(NewWriteModel.d dVar) {
        this.gFa = dVar;
    }

    @Override // com.baidu.tieba.write.vcode.newVcode.a.b
    public void onPostThreadCancle() {
        this.gEY.showPostThreadLoadingView(false);
        this.gBC.cancelLoadData();
    }

    @Override // com.baidu.tieba.write.vcode.newVcode.a.b
    public boolean byk() {
        return this.gBD;
    }

    private void rK(String str) {
        this.gBD = false;
        if (!k.hI()) {
            this.gEY.getContext().showToast(d.l.neterror);
            this.gEY.getContext().finish();
        } else if (!StringUtils.isNull(str)) {
            this.gEY.showPostThreadLoadingView(true);
            this.gBC.getWriteData().setVcode(str);
            this.gBC.getWriteData().setVcodeType("5");
            this.gBC.startPostWrite();
        } else {
            this.gEY.getContext().showToast(d.l.neterror);
            this.gEY.getContext().finish();
        }
    }
}
