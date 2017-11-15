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
    private PostWriteCallBackData gDJ;
    private final NewWriteModel gRh;
    private final NewVcodeView gUj;
    private NewWriteModel.d gUk;
    private boolean gRi = false;
    private final NewWriteModel.d aDw = new NewWriteModel.d() { // from class: com.baidu.tieba.write.vcode.newVcode.a.a.1
        @Override // com.baidu.tieba.tbadkCore.writeModel.NewWriteModel.d
        public void callback(boolean z, PostWriteCallBackData postWriteCallBackData, r rVar, WriteData writeData, AntiData antiData) {
            String str;
            String str2;
            String str3 = null;
            if (a.this.gUj != null) {
                a.this.gUj.showPostThreadLoadingView(false);
                if (z) {
                    a.this.gDJ = postWriteCallBackData;
                    a.this.gRi = true;
                    if (rVar == null || rVar.yi() == null) {
                        str = null;
                        str2 = null;
                    } else {
                        str2 = rVar.yi().endPoint;
                        str = rVar.yi().successImg;
                        str3 = rVar.yi().slideEndPoint;
                    }
                    a.this.gUj.runJsMethod(ImagesInvalidReceiver.SUCCESS, str + Constants.ACCEPT_TIME_SEPARATOR_SP + str2 + Constants.ACCEPT_TIME_SEPARATOR_SP + str3);
                } else if (postWriteCallBackData == null || postWriteCallBackData.getErrorCode() != 227001) {
                    if (a.this.gUk != null) {
                        a.this.gUk.callback(false, postWriteCallBackData, rVar, writeData, antiData);
                    }
                } else {
                    a.this.gUj.getContext().setVisible(false);
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AccountAccessActivityConfig(a.this.gUj.getContext().getActivity(), 12006, writeData, postWriteCallBackData.getAccessState())));
                }
            }
        }
    };

    public a(NewVcodeView newVcodeView, NewWriteModel newWriteModel) {
        this.gUj = newVcodeView;
        this.gRh = newWriteModel;
        this.gRh.b(this.aDw);
    }

    @Override // com.baidu.tieba.write.vcode.newVcode.a.b
    public boolean onUrlLoad(WebView webView, String str) {
        WriteData writeData;
        if (this.gRh.getWriteData() == null || StringUtils.isNull(str) || (writeData = this.gRh.getWriteData()) == null) {
            return false;
        }
        if (str.contains("objc:loadReady")) {
            if (writeData.getVcodeExtra() == null) {
                return false;
            }
            this.gUj.runJsMethod("handleFreshCaptcha", "'" + writeData.getVcodeUrl() + "','" + writeData.getVcodeExtra().slideImg + "','" + writeData.getVcodeExtra().textImg + "'");
            return true;
        } else if (str.contains("objc:jsChangePosition")) {
            se(com.baidu.tbadk.q.a.ha(str));
            return true;
        } else if (str.contains("objc:finish")) {
            this.gRi = true;
            if (writeData != null && writeData.getVideoReviewType() == 1 && writeData.getIsStory() != 1) {
                this.gUj.showToast(true, this.gUj.getContext().getResources().getString(d.j.video_send_success_under_review));
            } else if (writeData != null && writeData.getVideoReviewType() == 2 && writeData.getIsStory() != 1) {
                this.gUj.showToast(true, this.gUj.getContext().getResources().getString(d.j.video_send_success));
            } else if (writeData.getIsStory() != 1) {
                String str2 = null;
                String str3 = null;
                String string = this.gUj.getContext().getResources().getString(d.j.send_success);
                if (this.gDJ != null) {
                    str2 = this.gDJ.getPreMsg();
                    str3 = this.gDJ.getColorMsg();
                    string = this.gDJ.getErrorString();
                }
                if (writeData.getType() != 7) {
                    com.baidu.tieba.tbadkCore.writeModel.c.d(this.gUj.getContext().getActivity(), string, str2, str3);
                }
            }
            Intent intent = new Intent();
            Bundle bundle = new Bundle();
            bundle.putSerializable(WriteActivityConfig.POST_WRITE_CALLBACK_DATA, this.gDJ);
            intent.putExtras(bundle);
            BaseActivity context = this.gUj.getContext();
            this.gUj.getContext();
            context.setResult(-1, intent);
            this.gUj.getContext().finish();
            return true;
        } else if (str.contains("objc:jumpToFeedback()")) {
            WriteActivityConfig writeActivityConfig = new WriteActivityConfig(this.gUj.getContext().getActivity(), 0, TbConfig.getPositionPagerId(), TbConfig.getPositionPagerName(), null, null, 0, null, 13003, true, false, null, false, false, null, null, null, 0);
            writeActivityConfig.setIsVcodeFeedBack();
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, writeActivityConfig));
            return true;
        } else {
            return false;
        }
    }

    @Override // com.baidu.tieba.write.vcode.newVcode.a.b
    public void onPageFinished(WebView webView, String str) {
        if (this.gUj != null) {
            this.gUj.showWebViewDelay(1000);
        }
    }

    @Override // com.baidu.tieba.write.vcode.newVcode.a.b
    public void showErrorOnStart(boolean z, String str) {
    }

    @Override // com.baidu.tieba.write.vcode.newVcode.a.b
    public void start(boolean z) {
        this.gUj.setRatio(0.9433962f);
        this.gUj.showWebView(false);
        this.gUj.getWebView().loadUrl(TbConfig.SERVER_ADDRESS_WEB_VIEW + "n/captcha-drag");
    }

    @Override // com.baidu.tieba.write.vcode.newVcode.a.b
    public void onDestroy() {
    }

    @Override // com.baidu.tieba.write.vcode.newVcode.a.b
    public void d(NewWriteModel.d dVar) {
        this.gUk = dVar;
    }

    @Override // com.baidu.tieba.write.vcode.newVcode.a.b
    public void onPostThreadCancle() {
        this.gUj.showPostThreadLoadingView(false);
        this.gRh.cancelLoadData();
    }

    @Override // com.baidu.tieba.write.vcode.newVcode.a.b
    public boolean bCF() {
        return this.gRi;
    }

    private void se(String str) {
        this.gRi = false;
        if (!l.hy()) {
            this.gUj.getContext().showToast(d.j.neterror);
            this.gUj.getContext().finish();
        } else if (!StringUtils.isNull(str)) {
            this.gUj.showPostThreadLoadingView(true);
            this.gRh.getWriteData().setVcode(str);
            this.gRh.getWriteData().setVcodeType("5");
            this.gRh.startPostWrite();
        } else {
            this.gUj.getContext().showToast(d.j.neterror);
            this.gUj.getContext().finish();
        }
    }
}
