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
import com.baidu.tbadk.coreExtra.data.WriteData;
import com.baidu.tbadk.coreExtra.data.t;
import com.baidu.tieba.d;
import com.baidu.tieba.tbadkCore.writeModel.NewWriteModel;
import com.baidu.tieba.tbadkCore.writeModel.PostWriteCallBackData;
import com.baidu.tieba.write.vcode.newVcode.NewVcodeView;
import com.xiaomi.mipush.sdk.Constants;
/* loaded from: classes2.dex */
public class a implements b {
    private PostWriteCallBackData fPC;
    private final NewWriteModel hEC;
    private final NewVcodeView hHM;
    private NewWriteModel.d hHN;
    private boolean hED = false;
    private final NewWriteModel.d bum = new NewWriteModel.d() { // from class: com.baidu.tieba.write.vcode.newVcode.a.a.1
        @Override // com.baidu.tieba.tbadkCore.writeModel.NewWriteModel.d
        public void callback(boolean z, PostWriteCallBackData postWriteCallBackData, t tVar, WriteData writeData, AntiData antiData) {
            String str;
            String str2;
            String str3 = null;
            if (a.this.hHM != null) {
                a.this.hHM.showPostThreadLoadingView(false);
                if (z) {
                    a.this.fPC = postWriteCallBackData;
                    a.this.hED = true;
                    if (tVar == null || tVar.FY() == null) {
                        str = null;
                        str2 = null;
                    } else {
                        str2 = tVar.FY().endPoint;
                        str = tVar.FY().successImg;
                        str3 = tVar.FY().slideEndPoint;
                    }
                    a.this.hHM.runJsMethod(ImagesInvalidReceiver.SUCCESS, str + Constants.ACCEPT_TIME_SEPARATOR_SP + str2 + Constants.ACCEPT_TIME_SEPARATOR_SP + str3);
                } else if (postWriteCallBackData == null || postWriteCallBackData.getErrorCode() != 227001) {
                    if (a.this.hHN != null) {
                        a.this.hHN.callback(false, postWriteCallBackData, tVar, writeData, antiData);
                    }
                } else {
                    a.this.hHM.getContext().setVisible(false);
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new AccountAccessActivityConfig(a.this.hHM.getContext().getActivity(), IEventCenterService.EventId.EventMode.SAPIACCOUNT_FACE_REG, writeData, postWriteCallBackData.getAccessState())));
                }
            }
        }
    };

    public a(NewVcodeView newVcodeView, NewWriteModel newWriteModel) {
        this.hHM = newVcodeView;
        this.hEC = newWriteModel;
        this.hEC.b(this.bum);
    }

    @Override // com.baidu.tieba.write.vcode.newVcode.a.b
    public boolean onUrlLoad(WebView webView, String str) {
        WriteData writeData;
        if (this.hEC.getWriteData() == null || StringUtils.isNull(str) || (writeData = this.hEC.getWriteData()) == null) {
            return false;
        }
        if (str.contains("objc:loadReady")) {
            if (writeData.getVcodeExtra() == null) {
                return false;
            }
            this.hHM.runJsMethod("handleFreshCaptcha", "'" + writeData.getVcodeUrl() + "','" + writeData.getVcodeExtra().slideImg + "','" + writeData.getVcodeExtra().textImg + "'");
            return true;
        } else if (str.contains("objc:jsChangePosition")) {
            ux(com.baidu.tbadk.p.a.hw(str));
            return true;
        } else if (str.contains("objc:finish")) {
            this.hED = true;
            if (writeData != null && writeData.getVideoReviewType() == 1 && writeData.getIsStory() != 1) {
                this.hHM.showToast(true, this.hHM.getContext().getResources().getString(d.j.video_send_success_under_review));
            } else if (writeData != null && writeData.getVideoReviewType() == 2 && writeData.getIsStory() != 1) {
                this.hHM.showToast(true, this.hHM.getContext().getResources().getString(d.j.video_send_success));
            } else if (writeData.getIsStory() != 1) {
                String str2 = null;
                String str3 = null;
                String string = this.hHM.getContext().getResources().getString(d.j.send_success);
                if (this.fPC != null) {
                    str2 = this.fPC.getPreMsg();
                    str3 = this.fPC.getColorMsg();
                    string = this.fPC.getErrorString();
                }
                if (writeData.getType() != 7) {
                    com.baidu.tieba.tbadkCore.writeModel.c.e(this.hHM.getContext().getActivity(), string, str2, str3);
                }
            }
            Intent intent = new Intent();
            Bundle bundle = new Bundle();
            bundle.putSerializable("post_write_callback_data", this.fPC);
            intent.putExtras(bundle);
            BaseActivity context = this.hHM.getContext();
            this.hHM.getContext();
            context.setResult(-1, intent);
            this.hHM.getContext().finish();
            return true;
        } else if (str.contains("objc:jumpToFeedback()")) {
            WriteActivityConfig writeActivityConfig = new WriteActivityConfig(this.hHM.getContext().getActivity(), 0, TbConfig.getPositionPagerId(), TbConfig.getPositionPagerName(), null, null, 0, null, 13003, true, false, null, false, false, null, null, null, 0);
            writeActivityConfig.setIsVcodeFeedBack();
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, writeActivityConfig));
            return true;
        } else {
            return false;
        }
    }

    @Override // com.baidu.tieba.write.vcode.newVcode.a.b
    public void onPageFinished(WebView webView, String str) {
        if (this.hHM != null) {
            this.hHM.showWebViewDelay(1000);
        }
    }

    @Override // com.baidu.tieba.write.vcode.newVcode.a.b
    public void showErrorOnStart(boolean z, String str) {
    }

    @Override // com.baidu.tieba.write.vcode.newVcode.a.b
    public void start(boolean z) {
        this.hHM.setRatio(0.9433962f);
        this.hHM.showWebView(false);
        this.hHM.getWebView().loadUrl(TbConfig.SERVER_ADDRESS_WEB_VIEW + "n/captcha-drag");
    }

    @Override // com.baidu.tieba.write.vcode.newVcode.a.b
    public void onDestroy() {
    }

    @Override // com.baidu.tieba.write.vcode.newVcode.a.b
    public void d(NewWriteModel.d dVar) {
        this.hHN = dVar;
    }

    @Override // com.baidu.tieba.write.vcode.newVcode.a.b
    public void onPostThreadCancle() {
        this.hHM.showPostThreadLoadingView(false);
        this.hEC.cancelLoadData();
    }

    @Override // com.baidu.tieba.write.vcode.newVcode.a.b
    public boolean bFU() {
        return this.hED;
    }

    private void ux(String str) {
        this.hED = false;
        if (!l.pa()) {
            this.hHM.getContext().showToast(d.j.neterror);
            this.hHM.getContext().finish();
        } else if (!StringUtils.isNull(str)) {
            this.hHM.showPostThreadLoadingView(true);
            this.hEC.getWriteData().setVcode(str);
            this.hEC.getWriteData().setVcodeType("5");
            this.hEC.startPostWrite();
        } else {
            this.hHM.getContext().showToast(d.j.neterror);
            this.hHM.getContext().finish();
        }
    }
}
