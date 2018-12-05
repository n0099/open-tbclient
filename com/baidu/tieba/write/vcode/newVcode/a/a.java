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
import com.baidu.tbadk.coreExtra.data.w;
import com.baidu.tieba.e;
import com.baidu.tieba.tbadkCore.writeModel.NewWriteModel;
import com.baidu.tieba.tbadkCore.writeModel.PostWriteCallBackData;
import com.baidu.tieba.write.vcode.newVcode.NewVcodeView;
/* loaded from: classes3.dex */
public class a implements b {
    private PostWriteCallBackData fXG;
    private final NewWriteModel hRz;
    private final NewVcodeView hVh;
    private NewWriteModel.d hVi;
    private boolean hRA = false;
    private final NewWriteModel.d baf = new NewWriteModel.d() { // from class: com.baidu.tieba.write.vcode.newVcode.a.a.1
        @Override // com.baidu.tieba.tbadkCore.writeModel.NewWriteModel.d
        public void callback(boolean z, PostWriteCallBackData postWriteCallBackData, w wVar, WriteData writeData, AntiData antiData) {
            String str;
            String str2;
            String str3 = null;
            if (a.this.hVh != null) {
                a.this.hVh.showPostThreadLoadingView(false);
                if (z) {
                    a.this.fXG = postWriteCallBackData;
                    a.this.hRA = true;
                    if (wVar == null || wVar.GW() == null) {
                        str = null;
                        str2 = null;
                    } else {
                        str2 = wVar.GW().endPoint;
                        str = wVar.GW().successImg;
                        str3 = wVar.GW().slideEndPoint;
                    }
                    a.this.hVh.runJsMethod("success", str + "," + str2 + "," + str3);
                } else if (postWriteCallBackData == null || postWriteCallBackData.getErrorCode() != 227001) {
                    if (a.this.hVi != null) {
                        a.this.hVi.callback(false, postWriteCallBackData, wVar, writeData, antiData);
                    }
                } else {
                    a.this.hVh.getContext().setVisible(false);
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new AccountAccessActivityConfig(a.this.hVh.getContext().getActivity(), IEventCenterService.EventId.EventMode.SAPIACCOUNT_FACE_REG, writeData, postWriteCallBackData.getAccessState())));
                }
            }
        }
    };

    public a(NewVcodeView newVcodeView, NewWriteModel newWriteModel) {
        this.hVh = newVcodeView;
        this.hRz = newWriteModel;
        this.hRz.b(this.baf);
    }

    @Override // com.baidu.tieba.write.vcode.newVcode.a.b
    public boolean onUrlLoad(WebView webView, String str) {
        WriteData writeData;
        if (this.hRz.getWriteData() == null || StringUtils.isNull(str) || (writeData = this.hRz.getWriteData()) == null) {
            return false;
        }
        if (str.contains("objc:loadReady")) {
            if (writeData.getVcodeExtra() == null) {
                return false;
            }
            this.hVh.runJsMethod("handleFreshCaptcha", "'" + writeData.getVcodeUrl() + "','" + writeData.getVcodeExtra().slideImg + "','" + writeData.getVcodeExtra().textImg + "'");
            return true;
        } else if (str.contains("objc:jsChangePosition")) {
            xF(com.baidu.tbadk.r.a.iR(str));
            return true;
        } else if (str.contains("objc:finish")) {
            this.hRA = true;
            if (writeData != null && writeData.getVideoReviewType() == 1) {
                this.hVh.showToast(true, this.hVh.getContext().getResources().getString(e.j.video_send_success_under_review));
            } else if (writeData != null && writeData.getVideoReviewType() == 2) {
                this.hVh.showToast(true, this.hVh.getContext().getResources().getString(e.j.video_send_success));
            } else {
                String str2 = null;
                String str3 = null;
                String string = this.hVh.getContext().getResources().getString(e.j.send_success);
                if (this.fXG != null) {
                    str2 = this.fXG.getPreMsg();
                    str3 = this.fXG.getColorMsg();
                    string = this.fXG.getErrorString();
                }
                if (writeData.getType() != 7) {
                    com.baidu.tieba.tbadkCore.writeModel.c.e(this.hVh.getContext().getActivity(), string, str2, str3);
                }
            }
            Intent intent = new Intent();
            Bundle bundle = new Bundle();
            bundle.putSerializable("post_write_callback_data", this.fXG);
            intent.putExtras(bundle);
            BaseActivity context = this.hVh.getContext();
            this.hVh.getContext();
            context.setResult(-1, intent);
            this.hVh.getContext().finish();
            return true;
        } else if (str.contains("objc:jumpToFeedback()")) {
            WriteActivityConfig writeActivityConfig = new WriteActivityConfig(this.hVh.getContext().getActivity(), 0, TbConfig.getPositionPagerId(), TbConfig.getPositionPagerName(), null, null, 0, null, 13003, true, false, null, false, false, null, null, null, 0);
            writeActivityConfig.setIsVcodeFeedBack();
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, writeActivityConfig));
            return true;
        } else {
            return false;
        }
    }

    @Override // com.baidu.tieba.write.vcode.newVcode.a.b
    public void onPageFinished(WebView webView, String str) {
        if (this.hVh != null) {
            this.hVh.showWebViewDelay(1000);
        }
    }

    @Override // com.baidu.tieba.write.vcode.newVcode.a.b
    public void showErrorOnStart(boolean z, String str) {
    }

    @Override // com.baidu.tieba.write.vcode.newVcode.a.b
    public void start(boolean z) {
        this.hVh.setRatio(0.9433962f);
        this.hVh.showWebView(false);
        this.hVh.getWebView().loadUrl(TbConfig.SERVER_ADDRESS_WEB_VIEW + "n/captcha-drag");
    }

    @Override // com.baidu.tieba.write.vcode.newVcode.a.b
    public void onDestroy() {
    }

    @Override // com.baidu.tieba.write.vcode.newVcode.a.b
    public void d(NewWriteModel.d dVar) {
        this.hVi = dVar;
    }

    @Override // com.baidu.tieba.write.vcode.newVcode.a.b
    public void onPostThreadCancle() {
        this.hVh.showPostThreadLoadingView(false);
        this.hRz.cancelLoadData();
    }

    private void xF(String str) {
        this.hRA = false;
        if (!l.ll()) {
            this.hVh.getContext().showToast(e.j.neterror);
            this.hVh.getContext().finish();
        } else if (!StringUtils.isNull(str)) {
            this.hVh.showPostThreadLoadingView(true);
            this.hRz.getWriteData().setVcode(str);
            this.hRz.getWriteData().setVcodeType("5");
            this.hRz.startPostWrite();
        } else {
            this.hVh.getContext().showToast(e.j.neterror);
            this.hVh.getContext().finish();
        }
    }
}
