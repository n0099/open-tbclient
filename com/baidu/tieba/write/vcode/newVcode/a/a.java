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
import com.baidu.tbadk.core.diskCache.ImagesInvalidReceiver;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.coreExtra.data.WriteData;
import com.baidu.tbadk.coreExtra.data.s;
import com.baidu.tieba.d;
import com.baidu.tieba.tbadkCore.writeModel.NewWriteModel;
import com.baidu.tieba.tbadkCore.writeModel.PostWriteCallBackData;
import com.baidu.tieba.write.vcode.newVcode.NewVcodeView;
import com.xiaomi.mipush.sdk.Constants;
/* loaded from: classes2.dex */
public class a implements b {
    private PostWriteCallBackData fKt;
    private final NewWriteModel hMT;
    private final NewVcodeView hQc;
    private NewWriteModel.d hQd;
    private boolean hMU = false;
    private final NewWriteModel.d brP = new NewWriteModel.d() { // from class: com.baidu.tieba.write.vcode.newVcode.a.a.1
        @Override // com.baidu.tieba.tbadkCore.writeModel.NewWriteModel.d
        public void callback(boolean z, PostWriteCallBackData postWriteCallBackData, s sVar, WriteData writeData, AntiData antiData) {
            String str;
            String str2;
            String str3 = null;
            if (a.this.hQc != null) {
                a.this.hQc.showPostThreadLoadingView(false);
                if (z) {
                    a.this.fKt = postWriteCallBackData;
                    a.this.hMU = true;
                    if (sVar == null || sVar.FJ() == null) {
                        str = null;
                        str2 = null;
                    } else {
                        str2 = sVar.FJ().endPoint;
                        str = sVar.FJ().successImg;
                        str3 = sVar.FJ().slideEndPoint;
                    }
                    a.this.hQc.runJsMethod(ImagesInvalidReceiver.SUCCESS, str + Constants.ACCEPT_TIME_SEPARATOR_SP + str2 + Constants.ACCEPT_TIME_SEPARATOR_SP + str3);
                } else if (postWriteCallBackData == null || postWriteCallBackData.getErrorCode() != 227001) {
                    if (a.this.hQd != null) {
                        a.this.hQd.callback(false, postWriteCallBackData, sVar, writeData, antiData);
                    }
                } else {
                    a.this.hQc.getContext().setVisible(false);
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AccountAccessActivityConfig(a.this.hQc.getContext().getActivity(), IEventCenterService.EventId.EventMode.SAPIACCOUNT_FACE_REG, writeData, postWriteCallBackData.getAccessState())));
                }
            }
        }
    };

    public a(NewVcodeView newVcodeView, NewWriteModel newWriteModel) {
        this.hQc = newVcodeView;
        this.hMT = newWriteModel;
        this.hMT.b(this.brP);
    }

    @Override // com.baidu.tieba.write.vcode.newVcode.a.b
    public boolean onUrlLoad(WebView webView, String str) {
        WriteData writeData;
        if (this.hMT.getWriteData() == null || StringUtils.isNull(str) || (writeData = this.hMT.getWriteData()) == null) {
            return false;
        }
        if (str.contains("objc:loadReady")) {
            if (writeData.getVcodeExtra() == null) {
                return false;
            }
            this.hQc.runJsMethod("handleFreshCaptcha", "'" + writeData.getVcodeUrl() + "','" + writeData.getVcodeExtra().slideImg + "','" + writeData.getVcodeExtra().textImg + "'");
            return true;
        } else if (str.contains("objc:jsChangePosition")) {
            uQ(com.baidu.tbadk.p.a.he(str));
            return true;
        } else if (str.contains("objc:finish")) {
            this.hMU = true;
            if (writeData != null && writeData.getVideoReviewType() == 1 && writeData.getIsStory() != 1) {
                this.hQc.showToast(true, this.hQc.getContext().getResources().getString(d.j.video_send_success_under_review));
            } else if (writeData != null && writeData.getVideoReviewType() == 2 && writeData.getIsStory() != 1) {
                this.hQc.showToast(true, this.hQc.getContext().getResources().getString(d.j.video_send_success));
            } else if (writeData.getIsStory() != 1) {
                String str2 = null;
                String str3 = null;
                String string = this.hQc.getContext().getResources().getString(d.j.send_success);
                if (this.fKt != null) {
                    str2 = this.fKt.getPreMsg();
                    str3 = this.fKt.getColorMsg();
                    string = this.fKt.getErrorString();
                }
                if (writeData.getType() != 7) {
                    com.baidu.tieba.tbadkCore.writeModel.c.e(this.hQc.getContext().getActivity(), string, str2, str3);
                }
            }
            Intent intent = new Intent();
            Bundle bundle = new Bundle();
            bundle.putSerializable("post_write_callback_data", this.fKt);
            intent.putExtras(bundle);
            BaseActivity context = this.hQc.getContext();
            this.hQc.getContext();
            context.setResult(-1, intent);
            this.hQc.getContext().finish();
            return true;
        } else if (str.contains("objc:jumpToFeedback()")) {
            WriteActivityConfig writeActivityConfig = new WriteActivityConfig(this.hQc.getContext().getActivity(), 0, TbConfig.getPositionPagerId(), TbConfig.getPositionPagerName(), null, null, 0, null, 13003, true, false, null, false, false, null, null, null, 0);
            writeActivityConfig.setIsVcodeFeedBack();
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, writeActivityConfig));
            return true;
        } else {
            return false;
        }
    }

    @Override // com.baidu.tieba.write.vcode.newVcode.a.b
    public void onPageFinished(WebView webView, String str) {
        if (this.hQc != null) {
            this.hQc.showWebViewDelay(1000);
        }
    }

    @Override // com.baidu.tieba.write.vcode.newVcode.a.b
    public void showErrorOnStart(boolean z, String str) {
    }

    @Override // com.baidu.tieba.write.vcode.newVcode.a.b
    public void start(boolean z) {
        this.hQc.setRatio(0.9433962f);
        this.hQc.showWebView(false);
        this.hQc.getWebView().loadUrl(TbConfig.SERVER_ADDRESS_WEB_VIEW + "n/captcha-drag");
    }

    @Override // com.baidu.tieba.write.vcode.newVcode.a.b
    public void onDestroy() {
    }

    @Override // com.baidu.tieba.write.vcode.newVcode.a.b
    public void d(NewWriteModel.d dVar) {
        this.hQd = dVar;
    }

    @Override // com.baidu.tieba.write.vcode.newVcode.a.b
    public void onPostThreadCancle() {
        this.hQc.showPostThreadLoadingView(false);
        this.hMT.cancelLoadData();
    }

    @Override // com.baidu.tieba.write.vcode.newVcode.a.b
    public boolean bLA() {
        return this.hMU;
    }

    private void uQ(String str) {
        this.hMU = false;
        if (!l.oZ()) {
            this.hQc.getContext().showToast(d.j.neterror);
            this.hQc.getContext().finish();
        } else if (!StringUtils.isNull(str)) {
            this.hQc.showPostThreadLoadingView(true);
            this.hMT.getWriteData().setVcode(str);
            this.hMT.getWriteData().setVcodeType("5");
            this.hMT.startPostWrite();
        } else {
            this.hQc.getContext().showToast(d.j.neterror);
            this.hQc.getContext().finish();
        }
    }
}
