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
    private PostWriteCallBackData gCB;
    private final NewWriteModel gPZ;
    private final NewVcodeView gTb;
    private NewWriteModel.d gTc;
    private boolean gQa = false;
    private final NewWriteModel.d aDo = new NewWriteModel.d() { // from class: com.baidu.tieba.write.vcode.newVcode.a.a.1
        @Override // com.baidu.tieba.tbadkCore.writeModel.NewWriteModel.d
        public void callback(boolean z, PostWriteCallBackData postWriteCallBackData, q qVar, WriteData writeData, AntiData antiData) {
            String str;
            String str2;
            String str3 = null;
            if (a.this.gTb != null) {
                a.this.gTb.showPostThreadLoadingView(false);
                if (z) {
                    a.this.gCB = postWriteCallBackData;
                    a.this.gQa = true;
                    if (qVar == null || qVar.ya() == null) {
                        str = null;
                        str2 = null;
                    } else {
                        str2 = qVar.ya().endPoint;
                        str = qVar.ya().successImg;
                        str3 = qVar.ya().slideEndPoint;
                    }
                    a.this.gTb.runJsMethod(ImagesInvalidReceiver.SUCCESS, str + Constants.ACCEPT_TIME_SEPARATOR_SP + str2 + Constants.ACCEPT_TIME_SEPARATOR_SP + str3);
                } else if (postWriteCallBackData == null || postWriteCallBackData.getErrorCode() != 227001) {
                    if (a.this.gTc != null) {
                        a.this.gTc.callback(false, postWriteCallBackData, qVar, writeData, antiData);
                    }
                } else {
                    a.this.gTb.getContext().setVisible(false);
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AccountAccessActivityConfig(a.this.gTb.getContext().getActivity(), 12006, writeData, postWriteCallBackData.getAccessState())));
                }
            }
        }
    };

    public a(NewVcodeView newVcodeView, NewWriteModel newWriteModel) {
        this.gTb = newVcodeView;
        this.gPZ = newWriteModel;
        this.gPZ.b(this.aDo);
    }

    @Override // com.baidu.tieba.write.vcode.newVcode.a.b
    public boolean onUrlLoad(WebView webView, String str) {
        WriteData writeData;
        if (this.gPZ.getWriteData() == null || StringUtils.isNull(str) || (writeData = this.gPZ.getWriteData()) == null) {
            return false;
        }
        if (str.contains("objc:loadReady")) {
            if (writeData.getVcodeExtra() == null) {
                return false;
            }
            this.gTb.runJsMethod("handleFreshCaptcha", "'" + writeData.getVcodeUrl() + "','" + writeData.getVcodeExtra().slideImg + "','" + writeData.getVcodeExtra().textImg + "'");
            return true;
        } else if (str.contains("objc:jsChangePosition")) {
            rY(com.baidu.tbadk.q.a.gZ(str));
            return true;
        } else if (str.contains("objc:finish")) {
            this.gQa = true;
            if (writeData != null && writeData.getVideoReviewType() == 1 && writeData.getIsStory() != 1) {
                this.gTb.showToast(true, this.gTb.getContext().getResources().getString(d.j.video_send_success_under_review));
            } else if (writeData != null && writeData.getVideoReviewType() == 2 && writeData.getIsStory() != 1) {
                this.gTb.showToast(true, this.gTb.getContext().getResources().getString(d.j.video_send_success));
            } else if (writeData.getIsStory() != 1) {
                String str2 = null;
                String str3 = null;
                String string = this.gTb.getContext().getResources().getString(d.j.send_success);
                if (this.gCB != null) {
                    str2 = this.gCB.getPreMsg();
                    str3 = this.gCB.getColorMsg();
                    string = this.gCB.getErrorString();
                }
                if (writeData.getType() != 7) {
                    com.baidu.tieba.tbadkCore.writeModel.c.d(this.gTb.getContext().getActivity(), string, str2, str3);
                }
            }
            Intent intent = new Intent();
            Bundle bundle = new Bundle();
            bundle.putSerializable(WriteActivityConfig.POST_WRITE_CALLBACK_DATA, this.gCB);
            intent.putExtras(bundle);
            BaseActivity context = this.gTb.getContext();
            this.gTb.getContext();
            context.setResult(-1, intent);
            this.gTb.getContext().finish();
            return true;
        } else if (str.contains("objc:jumpToFeedback()")) {
            WriteActivityConfig writeActivityConfig = new WriteActivityConfig(this.gTb.getContext().getActivity(), 0, TbConfig.getPositionPagerId(), TbConfig.getPositionPagerName(), null, null, 0, null, 13003, true, false, null, false, false, null, null, null, 0);
            writeActivityConfig.setIsVcodeFeedBack();
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, writeActivityConfig));
            return true;
        } else {
            return false;
        }
    }

    @Override // com.baidu.tieba.write.vcode.newVcode.a.b
    public void onPageFinished(WebView webView, String str) {
        if (this.gTb != null) {
            this.gTb.showWebViewDelay(1000);
        }
    }

    @Override // com.baidu.tieba.write.vcode.newVcode.a.b
    public void showErrorOnStart(boolean z, String str) {
    }

    @Override // com.baidu.tieba.write.vcode.newVcode.a.b
    public void start(boolean z) {
        this.gTb.setRatio(0.9433962f);
        this.gTb.showWebView(false);
        this.gTb.getWebView().loadUrl(TbConfig.SERVER_ADDRESS_WEB_VIEW + "n/captcha-drag");
    }

    @Override // com.baidu.tieba.write.vcode.newVcode.a.b
    public void onDestroy() {
    }

    @Override // com.baidu.tieba.write.vcode.newVcode.a.b
    public void d(NewWriteModel.d dVar) {
        this.gTc = dVar;
    }

    @Override // com.baidu.tieba.write.vcode.newVcode.a.b
    public void onPostThreadCancle() {
        this.gTb.showPostThreadLoadingView(false);
        this.gPZ.cancelLoadData();
    }

    @Override // com.baidu.tieba.write.vcode.newVcode.a.b
    public boolean bCt() {
        return this.gQa;
    }

    private void rY(String str) {
        this.gQa = false;
        if (!l.hy()) {
            this.gTb.getContext().showToast(d.j.neterror);
            this.gTb.getContext().finish();
        } else if (!StringUtils.isNull(str)) {
            this.gTb.showPostThreadLoadingView(true);
            this.gPZ.getWriteData().setVcode(str);
            this.gPZ.getWriteData().setVcodeType("5");
            this.gPZ.startPostWrite();
        } else {
            this.gTb.getContext().showToast(d.j.neterror);
            this.gTb.getContext().finish();
        }
    }
}
