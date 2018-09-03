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
import com.baidu.tbadk.coreExtra.data.u;
import com.baidu.tieba.f;
import com.baidu.tieba.tbadkCore.writeModel.NewWriteModel;
import com.baidu.tieba.tbadkCore.writeModel.PostWriteCallBackData;
import com.baidu.tieba.write.vcode.newVcode.NewVcodeView;
/* loaded from: classes3.dex */
public class a implements b {
    private PostWriteCallBackData fAg;
    private final NewWriteModel htw;
    private final NewVcodeView hwD;
    private NewWriteModel.d hwE;
    private boolean htx = false;
    private final NewWriteModel.d aNZ = new NewWriteModel.d() { // from class: com.baidu.tieba.write.vcode.newVcode.a.a.1
        @Override // com.baidu.tieba.tbadkCore.writeModel.NewWriteModel.d
        public void callback(boolean z, PostWriteCallBackData postWriteCallBackData, u uVar, WriteData writeData, AntiData antiData) {
            String str;
            String str2;
            String str3 = null;
            if (a.this.hwD != null) {
                a.this.hwD.showPostThreadLoadingView(false);
                if (z) {
                    a.this.fAg = postWriteCallBackData;
                    a.this.htx = true;
                    if (uVar == null || uVar.Cs() == null) {
                        str = null;
                        str2 = null;
                    } else {
                        str2 = uVar.Cs().endPoint;
                        str = uVar.Cs().successImg;
                        str3 = uVar.Cs().slideEndPoint;
                    }
                    a.this.hwD.runJsMethod("success", str + "," + str2 + "," + str3);
                } else if (postWriteCallBackData == null || postWriteCallBackData.getErrorCode() != 227001) {
                    if (a.this.hwE != null) {
                        a.this.hwE.callback(false, postWriteCallBackData, uVar, writeData, antiData);
                    }
                } else {
                    a.this.hwD.getContext().setVisible(false);
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new AccountAccessActivityConfig(a.this.hwD.getContext().getActivity(), IEventCenterService.EventId.EventMode.SAPIACCOUNT_FACE_REG, writeData, postWriteCallBackData.getAccessState())));
                }
            }
        }
    };

    public a(NewVcodeView newVcodeView, NewWriteModel newWriteModel) {
        this.hwD = newVcodeView;
        this.htw = newWriteModel;
        this.htw.b(this.aNZ);
    }

    @Override // com.baidu.tieba.write.vcode.newVcode.a.b
    public boolean onUrlLoad(WebView webView, String str) {
        WriteData writeData;
        if (this.htw.getWriteData() == null || StringUtils.isNull(str) || (writeData = this.htw.getWriteData()) == null) {
            return false;
        }
        if (str.contains("objc:loadReady")) {
            if (writeData.getVcodeExtra() == null) {
                return false;
            }
            this.hwD.runJsMethod("handleFreshCaptcha", "'" + writeData.getVcodeUrl() + "','" + writeData.getVcodeExtra().slideImg + "','" + writeData.getVcodeExtra().textImg + "'");
            return true;
        } else if (str.contains("objc:jsChangePosition")) {
            vL(com.baidu.tbadk.q.a.hM(str));
            return true;
        } else if (str.contains("objc:finish")) {
            this.htx = true;
            if (writeData != null && writeData.getVideoReviewType() == 1) {
                this.hwD.showToast(true, this.hwD.getContext().getResources().getString(f.j.video_send_success_under_review));
            } else if (writeData != null && writeData.getVideoReviewType() == 2) {
                this.hwD.showToast(true, this.hwD.getContext().getResources().getString(f.j.video_send_success));
            } else {
                String str2 = null;
                String str3 = null;
                String string = this.hwD.getContext().getResources().getString(f.j.send_success);
                if (this.fAg != null) {
                    str2 = this.fAg.getPreMsg();
                    str3 = this.fAg.getColorMsg();
                    string = this.fAg.getErrorString();
                }
                if (writeData.getType() != 7) {
                    com.baidu.tieba.tbadkCore.writeModel.c.e(this.hwD.getContext().getActivity(), string, str2, str3);
                }
            }
            Intent intent = new Intent();
            Bundle bundle = new Bundle();
            bundle.putSerializable("post_write_callback_data", this.fAg);
            intent.putExtras(bundle);
            BaseActivity context = this.hwD.getContext();
            this.hwD.getContext();
            context.setResult(-1, intent);
            this.hwD.getContext().finish();
            return true;
        } else if (str.contains("objc:jumpToFeedback()")) {
            WriteActivityConfig writeActivityConfig = new WriteActivityConfig(this.hwD.getContext().getActivity(), 0, TbConfig.getPositionPagerId(), TbConfig.getPositionPagerName(), null, null, 0, null, 13003, true, false, null, false, false, null, null, null, 0);
            writeActivityConfig.setIsVcodeFeedBack();
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, writeActivityConfig));
            return true;
        } else {
            return false;
        }
    }

    @Override // com.baidu.tieba.write.vcode.newVcode.a.b
    public void onPageFinished(WebView webView, String str) {
        if (this.hwD != null) {
            this.hwD.showWebViewDelay(1000);
        }
    }

    @Override // com.baidu.tieba.write.vcode.newVcode.a.b
    public void showErrorOnStart(boolean z, String str) {
    }

    @Override // com.baidu.tieba.write.vcode.newVcode.a.b
    public void start(boolean z) {
        this.hwD.setRatio(0.9433962f);
        this.hwD.showWebView(false);
        this.hwD.getWebView().loadUrl(TbConfig.SERVER_ADDRESS_WEB_VIEW + "n/captcha-drag");
    }

    @Override // com.baidu.tieba.write.vcode.newVcode.a.b
    public void onDestroy() {
    }

    @Override // com.baidu.tieba.write.vcode.newVcode.a.b
    public void d(NewWriteModel.d dVar) {
        this.hwE = dVar;
    }

    @Override // com.baidu.tieba.write.vcode.newVcode.a.b
    public void onPostThreadCancle() {
        this.hwD.showPostThreadLoadingView(false);
        this.htw.cancelLoadData();
    }

    private void vL(String str) {
        this.htx = false;
        if (!l.jV()) {
            this.hwD.getContext().showToast(f.j.neterror);
            this.hwD.getContext().finish();
        } else if (!StringUtils.isNull(str)) {
            this.hwD.showPostThreadLoadingView(true);
            this.htw.getWriteData().setVcode(str);
            this.htw.getWriteData().setVcodeType("5");
            this.htw.startPostWrite();
        } else {
            this.hwD.getContext().showToast(f.j.neterror);
            this.hwD.getContext().finish();
        }
    }
}
