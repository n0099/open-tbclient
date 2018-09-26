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
import com.baidu.tbadk.coreExtra.data.v;
import com.baidu.tieba.e;
import com.baidu.tieba.tbadkCore.writeModel.NewWriteModel;
import com.baidu.tieba.tbadkCore.writeModel.PostWriteCallBackData;
import com.baidu.tieba.write.vcode.newVcode.NewVcodeView;
/* loaded from: classes3.dex */
public class a implements b {
    private PostWriteCallBackData fHP;
    private final NewWriteModel hBr;
    private final NewVcodeView hFa;
    private NewWriteModel.d hFb;
    private boolean hBs = false;
    private final NewWriteModel.d aRr = new NewWriteModel.d() { // from class: com.baidu.tieba.write.vcode.newVcode.a.a.1
        @Override // com.baidu.tieba.tbadkCore.writeModel.NewWriteModel.d
        public void callback(boolean z, PostWriteCallBackData postWriteCallBackData, v vVar, WriteData writeData, AntiData antiData) {
            String str;
            String str2;
            String str3 = null;
            if (a.this.hFa != null) {
                a.this.hFa.showPostThreadLoadingView(false);
                if (z) {
                    a.this.fHP = postWriteCallBackData;
                    a.this.hBs = true;
                    if (vVar == null || vVar.DF() == null) {
                        str = null;
                        str2 = null;
                    } else {
                        str2 = vVar.DF().endPoint;
                        str = vVar.DF().successImg;
                        str3 = vVar.DF().slideEndPoint;
                    }
                    a.this.hFa.runJsMethod("success", str + "," + str2 + "," + str3);
                } else if (postWriteCallBackData == null || postWriteCallBackData.getErrorCode() != 227001) {
                    if (a.this.hFb != null) {
                        a.this.hFb.callback(false, postWriteCallBackData, vVar, writeData, antiData);
                    }
                } else {
                    a.this.hFa.getContext().setVisible(false);
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new AccountAccessActivityConfig(a.this.hFa.getContext().getActivity(), IEventCenterService.EventId.EventMode.SAPIACCOUNT_FACE_REG, writeData, postWriteCallBackData.getAccessState())));
                }
            }
        }
    };

    public a(NewVcodeView newVcodeView, NewWriteModel newWriteModel) {
        this.hFa = newVcodeView;
        this.hBr = newWriteModel;
        this.hBr.b(this.aRr);
    }

    @Override // com.baidu.tieba.write.vcode.newVcode.a.b
    public boolean onUrlLoad(WebView webView, String str) {
        WriteData writeData;
        if (this.hBr.getWriteData() == null || StringUtils.isNull(str) || (writeData = this.hBr.getWriteData()) == null) {
            return false;
        }
        if (str.contains("objc:loadReady")) {
            if (writeData.getVcodeExtra() == null) {
                return false;
            }
            this.hFa.runJsMethod("handleFreshCaptcha", "'" + writeData.getVcodeUrl() + "','" + writeData.getVcodeExtra().slideImg + "','" + writeData.getVcodeExtra().textImg + "'");
            return true;
        } else if (str.contains("objc:jsChangePosition")) {
            ww(com.baidu.tbadk.q.a.ik(str));
            return true;
        } else if (str.contains("objc:finish")) {
            this.hBs = true;
            if (writeData != null && writeData.getVideoReviewType() == 1) {
                this.hFa.showToast(true, this.hFa.getContext().getResources().getString(e.j.video_send_success_under_review));
            } else if (writeData != null && writeData.getVideoReviewType() == 2) {
                this.hFa.showToast(true, this.hFa.getContext().getResources().getString(e.j.video_send_success));
            } else {
                String str2 = null;
                String str3 = null;
                String string = this.hFa.getContext().getResources().getString(e.j.send_success);
                if (this.fHP != null) {
                    str2 = this.fHP.getPreMsg();
                    str3 = this.fHP.getColorMsg();
                    string = this.fHP.getErrorString();
                }
                if (writeData.getType() != 7) {
                    com.baidu.tieba.tbadkCore.writeModel.c.e(this.hFa.getContext().getActivity(), string, str2, str3);
                }
            }
            Intent intent = new Intent();
            Bundle bundle = new Bundle();
            bundle.putSerializable("post_write_callback_data", this.fHP);
            intent.putExtras(bundle);
            BaseActivity context = this.hFa.getContext();
            this.hFa.getContext();
            context.setResult(-1, intent);
            this.hFa.getContext().finish();
            return true;
        } else if (str.contains("objc:jumpToFeedback()")) {
            WriteActivityConfig writeActivityConfig = new WriteActivityConfig(this.hFa.getContext().getActivity(), 0, TbConfig.getPositionPagerId(), TbConfig.getPositionPagerName(), null, null, 0, null, 13003, true, false, null, false, false, null, null, null, 0);
            writeActivityConfig.setIsVcodeFeedBack();
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, writeActivityConfig));
            return true;
        } else {
            return false;
        }
    }

    @Override // com.baidu.tieba.write.vcode.newVcode.a.b
    public void onPageFinished(WebView webView, String str) {
        if (this.hFa != null) {
            this.hFa.showWebViewDelay(1000);
        }
    }

    @Override // com.baidu.tieba.write.vcode.newVcode.a.b
    public void showErrorOnStart(boolean z, String str) {
    }

    @Override // com.baidu.tieba.write.vcode.newVcode.a.b
    public void start(boolean z) {
        this.hFa.setRatio(0.9433962f);
        this.hFa.showWebView(false);
        this.hFa.getWebView().loadUrl(TbConfig.SERVER_ADDRESS_WEB_VIEW + "n/captcha-drag");
    }

    @Override // com.baidu.tieba.write.vcode.newVcode.a.b
    public void onDestroy() {
    }

    @Override // com.baidu.tieba.write.vcode.newVcode.a.b
    public void d(NewWriteModel.d dVar) {
        this.hFb = dVar;
    }

    @Override // com.baidu.tieba.write.vcode.newVcode.a.b
    public void onPostThreadCancle() {
        this.hFa.showPostThreadLoadingView(false);
        this.hBr.cancelLoadData();
    }

    private void ww(String str) {
        this.hBs = false;
        if (!l.lb()) {
            this.hFa.getContext().showToast(e.j.neterror);
            this.hFa.getContext().finish();
        } else if (!StringUtils.isNull(str)) {
            this.hFa.showPostThreadLoadingView(true);
            this.hBr.getWriteData().setVcode(str);
            this.hBr.getWriteData().setVcodeType("5");
            this.hBr.startPostWrite();
        } else {
            this.hFa.getContext().showToast(e.j.neterror);
            this.hFa.getContext().finish();
        }
    }
}
