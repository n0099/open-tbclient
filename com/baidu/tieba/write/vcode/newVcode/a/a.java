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
    private PostWriteCallBackData gay;
    private final NewWriteModel hUK;
    private final NewVcodeView hYs;
    private NewWriteModel.d hYt;
    private boolean hUL = false;
    private final NewWriteModel.d bai = new NewWriteModel.d() { // from class: com.baidu.tieba.write.vcode.newVcode.a.a.1
        @Override // com.baidu.tieba.tbadkCore.writeModel.NewWriteModel.d
        public void callback(boolean z, PostWriteCallBackData postWriteCallBackData, w wVar, WriteData writeData, AntiData antiData) {
            String str;
            String str2;
            String str3 = null;
            if (a.this.hYs != null) {
                a.this.hYs.showPostThreadLoadingView(false);
                if (z) {
                    a.this.gay = postWriteCallBackData;
                    a.this.hUL = true;
                    if (wVar == null || wVar.GX() == null) {
                        str = null;
                        str2 = null;
                    } else {
                        str2 = wVar.GX().endPoint;
                        str = wVar.GX().successImg;
                        str3 = wVar.GX().slideEndPoint;
                    }
                    a.this.hYs.runJsMethod("success", str + "," + str2 + "," + str3);
                } else if (postWriteCallBackData == null || postWriteCallBackData.getErrorCode() != 227001) {
                    if (a.this.hYt != null) {
                        a.this.hYt.callback(false, postWriteCallBackData, wVar, writeData, antiData);
                    }
                } else {
                    a.this.hYs.getContext().setVisible(false);
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new AccountAccessActivityConfig(a.this.hYs.getContext().getActivity(), IEventCenterService.EventId.EventMode.SAPIACCOUNT_FACE_REG, writeData, postWriteCallBackData.getAccessState())));
                }
            }
        }
    };

    public a(NewVcodeView newVcodeView, NewWriteModel newWriteModel) {
        this.hYs = newVcodeView;
        this.hUK = newWriteModel;
        this.hUK.b(this.bai);
    }

    @Override // com.baidu.tieba.write.vcode.newVcode.a.b
    public boolean onUrlLoad(WebView webView, String str) {
        WriteData writeData;
        if (this.hUK.getWriteData() == null || StringUtils.isNull(str) || (writeData = this.hUK.getWriteData()) == null) {
            return false;
        }
        if (str.contains("objc:loadReady")) {
            if (writeData.getVcodeExtra() == null) {
                return false;
            }
            this.hYs.runJsMethod("handleFreshCaptcha", "'" + writeData.getVcodeUrl() + "','" + writeData.getVcodeExtra().slideImg + "','" + writeData.getVcodeExtra().textImg + "'");
            return true;
        } else if (str.contains("objc:jsChangePosition")) {
            xI(com.baidu.tbadk.r.a.iS(str));
            return true;
        } else if (str.contains("objc:finish")) {
            this.hUL = true;
            if (writeData != null && writeData.getVideoReviewType() == 1) {
                this.hYs.showToast(true, this.hYs.getContext().getResources().getString(e.j.video_send_success_under_review));
            } else if (writeData != null && writeData.getVideoReviewType() == 2) {
                this.hYs.showToast(true, this.hYs.getContext().getResources().getString(e.j.video_send_success));
            } else {
                String str2 = null;
                String str3 = null;
                String string = this.hYs.getContext().getResources().getString(e.j.send_success);
                if (this.gay != null) {
                    str2 = this.gay.getPreMsg();
                    str3 = this.gay.getColorMsg();
                    string = this.gay.getErrorString();
                }
                if (writeData.getType() != 7) {
                    com.baidu.tieba.tbadkCore.writeModel.c.e(this.hYs.getContext().getActivity(), string, str2, str3);
                }
            }
            Intent intent = new Intent();
            Bundle bundle = new Bundle();
            bundle.putSerializable("post_write_callback_data", this.gay);
            intent.putExtras(bundle);
            BaseActivity context = this.hYs.getContext();
            this.hYs.getContext();
            context.setResult(-1, intent);
            this.hYs.getContext().finish();
            return true;
        } else if (str.contains("objc:jumpToFeedback()")) {
            WriteActivityConfig writeActivityConfig = new WriteActivityConfig(this.hYs.getContext().getActivity(), 0, TbConfig.getPositionPagerId(), TbConfig.getPositionPagerName(), null, null, 0, null, 13003, true, false, null, false, false, null, null, null, 0);
            writeActivityConfig.setIsVcodeFeedBack();
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, writeActivityConfig));
            return true;
        } else {
            return false;
        }
    }

    @Override // com.baidu.tieba.write.vcode.newVcode.a.b
    public void onPageFinished(WebView webView, String str) {
        if (this.hYs != null) {
            this.hYs.showWebViewDelay(1000);
        }
    }

    @Override // com.baidu.tieba.write.vcode.newVcode.a.b
    public void showErrorOnStart(boolean z, String str) {
    }

    @Override // com.baidu.tieba.write.vcode.newVcode.a.b
    public void start(boolean z) {
        this.hYs.setRatio(0.9433962f);
        this.hYs.showWebView(false);
        this.hYs.getWebView().loadUrl(TbConfig.SERVER_ADDRESS_WEB_VIEW + "n/captcha-drag");
    }

    @Override // com.baidu.tieba.write.vcode.newVcode.a.b
    public void onDestroy() {
    }

    @Override // com.baidu.tieba.write.vcode.newVcode.a.b
    public void d(NewWriteModel.d dVar) {
        this.hYt = dVar;
    }

    @Override // com.baidu.tieba.write.vcode.newVcode.a.b
    public void onPostThreadCancle() {
        this.hYs.showPostThreadLoadingView(false);
        this.hUK.cancelLoadData();
    }

    private void xI(String str) {
        this.hUL = false;
        if (!l.ll()) {
            this.hYs.getContext().showToast(e.j.neterror);
            this.hYs.getContext().finish();
        } else if (!StringUtils.isNull(str)) {
            this.hYs.showPostThreadLoadingView(true);
            this.hUK.getWriteData().setVcode(str);
            this.hUK.getWriteData().setVcodeType("5");
            this.hUK.startPostWrite();
        } else {
            this.hYs.getContext().showToast(e.j.neterror);
            this.hYs.getContext().finish();
        }
    }
}
