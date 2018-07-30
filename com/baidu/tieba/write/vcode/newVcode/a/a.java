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
import com.baidu.tbadk.coreExtra.data.t;
import com.baidu.tieba.d;
import com.baidu.tieba.tbadkCore.writeModel.NewWriteModel;
import com.baidu.tieba.tbadkCore.writeModel.PostWriteCallBackData;
import com.baidu.tieba.write.vcode.newVcode.NewVcodeView;
/* loaded from: classes3.dex */
public class a implements b {
    private PostWriteCallBackData fAn;
    private final NewWriteModel htu;
    private final NewVcodeView hwB;
    private NewWriteModel.d hwC;
    private boolean htv = false;
    private final NewWriteModel.d aOc = new NewWriteModel.d() { // from class: com.baidu.tieba.write.vcode.newVcode.a.a.1
        @Override // com.baidu.tieba.tbadkCore.writeModel.NewWriteModel.d
        public void callback(boolean z, PostWriteCallBackData postWriteCallBackData, t tVar, WriteData writeData, AntiData antiData) {
            String str;
            String str2;
            String str3 = null;
            if (a.this.hwB != null) {
                a.this.hwB.showPostThreadLoadingView(false);
                if (z) {
                    a.this.fAn = postWriteCallBackData;
                    a.this.htv = true;
                    if (tVar == null || tVar.Cu() == null) {
                        str = null;
                        str2 = null;
                    } else {
                        str2 = tVar.Cu().endPoint;
                        str = tVar.Cu().successImg;
                        str3 = tVar.Cu().slideEndPoint;
                    }
                    a.this.hwB.runJsMethod("success", str + "," + str2 + "," + str3);
                } else if (postWriteCallBackData == null || postWriteCallBackData.getErrorCode() != 227001) {
                    if (a.this.hwC != null) {
                        a.this.hwC.callback(false, postWriteCallBackData, tVar, writeData, antiData);
                    }
                } else {
                    a.this.hwB.getContext().setVisible(false);
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new AccountAccessActivityConfig(a.this.hwB.getContext().getActivity(), IEventCenterService.EventId.EventMode.SAPIACCOUNT_FACE_REG, writeData, postWriteCallBackData.getAccessState())));
                }
            }
        }
    };

    public a(NewVcodeView newVcodeView, NewWriteModel newWriteModel) {
        this.hwB = newVcodeView;
        this.htu = newWriteModel;
        this.htu.b(this.aOc);
    }

    @Override // com.baidu.tieba.write.vcode.newVcode.a.b
    public boolean onUrlLoad(WebView webView, String str) {
        WriteData writeData;
        if (this.htu.getWriteData() == null || StringUtils.isNull(str) || (writeData = this.htu.getWriteData()) == null) {
            return false;
        }
        if (str.contains("objc:loadReady")) {
            if (writeData.getVcodeExtra() == null) {
                return false;
            }
            this.hwB.runJsMethod("handleFreshCaptcha", "'" + writeData.getVcodeUrl() + "','" + writeData.getVcodeExtra().slideImg + "','" + writeData.getVcodeExtra().textImg + "'");
            return true;
        } else if (str.contains("objc:jsChangePosition")) {
            vH(com.baidu.tbadk.q.a.hM(str));
            return true;
        } else if (str.contains("objc:finish")) {
            this.htv = true;
            if (writeData != null && writeData.getVideoReviewType() == 1) {
                this.hwB.showToast(true, this.hwB.getContext().getResources().getString(d.j.video_send_success_under_review));
            } else if (writeData != null && writeData.getVideoReviewType() == 2) {
                this.hwB.showToast(true, this.hwB.getContext().getResources().getString(d.j.video_send_success));
            } else {
                String str2 = null;
                String str3 = null;
                String string = this.hwB.getContext().getResources().getString(d.j.send_success);
                if (this.fAn != null) {
                    str2 = this.fAn.getPreMsg();
                    str3 = this.fAn.getColorMsg();
                    string = this.fAn.getErrorString();
                }
                if (writeData.getType() != 7) {
                    com.baidu.tieba.tbadkCore.writeModel.c.e(this.hwB.getContext().getActivity(), string, str2, str3);
                }
            }
            Intent intent = new Intent();
            Bundle bundle = new Bundle();
            bundle.putSerializable("post_write_callback_data", this.fAn);
            intent.putExtras(bundle);
            BaseActivity context = this.hwB.getContext();
            this.hwB.getContext();
            context.setResult(-1, intent);
            this.hwB.getContext().finish();
            return true;
        } else if (str.contains("objc:jumpToFeedback()")) {
            WriteActivityConfig writeActivityConfig = new WriteActivityConfig(this.hwB.getContext().getActivity(), 0, TbConfig.getPositionPagerId(), TbConfig.getPositionPagerName(), null, null, 0, null, 13003, true, false, null, false, false, null, null, null, 0);
            writeActivityConfig.setIsVcodeFeedBack();
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, writeActivityConfig));
            return true;
        } else {
            return false;
        }
    }

    @Override // com.baidu.tieba.write.vcode.newVcode.a.b
    public void onPageFinished(WebView webView, String str) {
        if (this.hwB != null) {
            this.hwB.showWebViewDelay(1000);
        }
    }

    @Override // com.baidu.tieba.write.vcode.newVcode.a.b
    public void showErrorOnStart(boolean z, String str) {
    }

    @Override // com.baidu.tieba.write.vcode.newVcode.a.b
    public void start(boolean z) {
        this.hwB.setRatio(0.9433962f);
        this.hwB.showWebView(false);
        this.hwB.getWebView().loadUrl(TbConfig.SERVER_ADDRESS_WEB_VIEW + "n/captcha-drag");
    }

    @Override // com.baidu.tieba.write.vcode.newVcode.a.b
    public void onDestroy() {
    }

    @Override // com.baidu.tieba.write.vcode.newVcode.a.b
    public void d(NewWriteModel.d dVar) {
        this.hwC = dVar;
    }

    @Override // com.baidu.tieba.write.vcode.newVcode.a.b
    public void onPostThreadCancle() {
        this.hwB.showPostThreadLoadingView(false);
        this.htu.cancelLoadData();
    }

    private void vH(String str) {
        this.htv = false;
        if (!l.jV()) {
            this.hwB.getContext().showToast(d.j.neterror);
            this.hwB.getContext().finish();
        } else if (!StringUtils.isNull(str)) {
            this.hwB.showPostThreadLoadingView(true);
            this.htu.getWriteData().setVcode(str);
            this.htu.getWriteData().setVcodeType("5");
            this.htu.startPostWrite();
        } else {
            this.hwB.getContext().showToast(d.j.neterror);
            this.hwB.getContext().finish();
        }
    }
}
