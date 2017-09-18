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
/* loaded from: classes2.dex */
public class a implements b {
    private final NewWriteModel gBj;
    private final NewVcodeView gEx;
    private PostWriteCallBackData gEy;
    private NewWriteModel.d gEz;
    private boolean gBk = false;
    private final NewWriteModel.d aDB = new NewWriteModel.d() { // from class: com.baidu.tieba.write.vcode.newVcode.a.a.1
        @Override // com.baidu.tieba.tbadkCore.writeModel.NewWriteModel.d
        public void callback(boolean z, PostWriteCallBackData postWriteCallBackData, q qVar, WriteData writeData, AntiData antiData) {
            String str;
            String str2;
            String str3 = null;
            if (a.this.gEx != null) {
                a.this.gEx.showPostThreadLoadingView(false);
                if (z) {
                    a.this.gEy = postWriteCallBackData;
                    a.this.gBk = true;
                    if (qVar == null || qVar.yB() == null) {
                        str = null;
                        str2 = null;
                    } else {
                        str2 = qVar.yB().endPoint;
                        str = qVar.yB().successImg;
                        str3 = qVar.yB().slideEndPoint;
                    }
                    a.this.gEx.runJsMethod(ImagesInvalidReceiver.SUCCESS, str + Constants.ACCEPT_TIME_SEPARATOR_SP + str2 + Constants.ACCEPT_TIME_SEPARATOR_SP + str3);
                } else if (postWriteCallBackData == null || postWriteCallBackData.getErrorCode() != 227001) {
                    if (a.this.gEz != null) {
                        a.this.gEz.callback(false, postWriteCallBackData, qVar, writeData, antiData);
                    }
                } else {
                    a.this.gEx.getContext().setVisible(false);
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AccountAccessActivityConfig(a.this.gEx.getContext().getActivity(), 12006, writeData, postWriteCallBackData.getAccessState())));
                }
            }
        }
    };

    public a(NewVcodeView newVcodeView, NewWriteModel newWriteModel) {
        this.gEx = newVcodeView;
        this.gBj = newWriteModel;
        this.gBj.b(this.aDB);
    }

    @Override // com.baidu.tieba.write.vcode.newVcode.a.b
    public boolean onUrlLoad(WebView webView, String str) {
        WriteData writeData;
        if (this.gBj.getWriteData() == null || StringUtils.isNull(str) || (writeData = this.gBj.getWriteData()) == null) {
            return false;
        }
        if (str.contains("objc:loadReady")) {
            if (writeData.getVcodeExtra() == null) {
                return false;
            }
            this.gEx.runJsMethod("handleFreshCaptcha", "'" + writeData.getVcodeUrl() + "','" + writeData.getVcodeExtra().slideImg + "','" + writeData.getVcodeExtra().textImg + "'");
            return true;
        } else if (str.contains("objc:jsChangePosition")) {
            rH(com.baidu.tbadk.q.a.gW(str));
            return true;
        } else if (str.contains("objc:finish")) {
            this.gBk = true;
            if (writeData != null && writeData.getVideoReviewType() == 1 && writeData.getIsStory() != 1) {
                this.gEx.showToast(true, this.gEx.getContext().getResources().getString(d.l.video_send_success_under_review));
            } else if (writeData != null && writeData.getVideoReviewType() == 2 && writeData.getIsStory() != 1) {
                this.gEx.showToast(true, this.gEx.getContext().getResources().getString(d.l.video_send_success));
            } else if (writeData.getIsStory() != 1) {
                String str2 = null;
                String str3 = null;
                String string = this.gEx.getContext().getResources().getString(d.l.send_success);
                if (this.gEy != null) {
                    str2 = this.gEy.getPreMsg();
                    str3 = this.gEy.getColorMsg();
                    string = this.gEy.getErrorString();
                }
                if (writeData.getType() != 7) {
                    com.baidu.tieba.tbadkCore.writeModel.c.c(this.gEx.getContext().getActivity(), string, str2, str3);
                }
            }
            Intent intent = new Intent();
            Bundle bundle = new Bundle();
            bundle.putSerializable(WriteActivityConfig.POST_WRITE_CALLBACK_DATA, this.gEy);
            intent.putExtras(bundle);
            BaseActivity context = this.gEx.getContext();
            this.gEx.getContext();
            context.setResult(-1, intent);
            this.gEx.getContext().finish();
            return true;
        } else if (str.contains("objc:jumpToFeedback()")) {
            WriteActivityConfig writeActivityConfig = new WriteActivityConfig(this.gEx.getContext().getActivity(), 0, TbConfig.getPositionPagerId(), TbConfig.getPositionPagerName(), null, null, 0, null, 13003, true, false, null, false, false, null, null, null, 0);
            writeActivityConfig.setIsVcodeFeedBack();
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, writeActivityConfig));
            return true;
        } else {
            return false;
        }
    }

    @Override // com.baidu.tieba.write.vcode.newVcode.a.b
    public void onPageFinished(WebView webView, String str) {
        if (this.gEx != null) {
            this.gEx.showWebViewDelay(1000);
        }
    }

    @Override // com.baidu.tieba.write.vcode.newVcode.a.b
    public void showErrorOnStart(boolean z, String str) {
    }

    @Override // com.baidu.tieba.write.vcode.newVcode.a.b
    public void start(boolean z) {
        this.gEx.setRatio(0.9433962f);
        this.gEx.showWebView(false);
        this.gEx.getWebView().loadUrl(TbConfig.SERVER_ADDRESS_WEB_VIEW + "n/captcha-drag");
    }

    @Override // com.baidu.tieba.write.vcode.newVcode.a.b
    public void onDestroy() {
    }

    @Override // com.baidu.tieba.write.vcode.newVcode.a.b
    public void d(NewWriteModel.d dVar) {
        this.gEz = dVar;
    }

    @Override // com.baidu.tieba.write.vcode.newVcode.a.b
    public void onPostThreadCancle() {
        this.gEx.showPostThreadLoadingView(false);
        this.gBj.cancelLoadData();
    }

    @Override // com.baidu.tieba.write.vcode.newVcode.a.b
    public boolean bxM() {
        return this.gBk;
    }

    private void rH(String str) {
        this.gBk = false;
        if (!k.hz()) {
            this.gEx.getContext().showToast(d.l.neterror);
            this.gEx.getContext().finish();
        } else if (!StringUtils.isNull(str)) {
            this.gEx.showPostThreadLoadingView(true);
            this.gBj.getWriteData().setVcode(str);
            this.gBj.getWriteData().setVcodeType("5");
            this.gBj.startPostWrite();
        } else {
            this.gEx.getContext().showToast(d.l.neterror);
            this.gEx.getContext().finish();
        }
    }
}
