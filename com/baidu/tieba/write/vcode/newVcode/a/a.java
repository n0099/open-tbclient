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
    private PostWriteCallBackData fAb;
    private final NewWriteModel hsm;
    private final NewVcodeView hvv;
    private NewWriteModel.d hvw;
    private boolean hsn = false;
    private final NewWriteModel.d aOd = new NewWriteModel.d() { // from class: com.baidu.tieba.write.vcode.newVcode.a.a.1
        @Override // com.baidu.tieba.tbadkCore.writeModel.NewWriteModel.d
        public void callback(boolean z, PostWriteCallBackData postWriteCallBackData, t tVar, WriteData writeData, AntiData antiData) {
            String str;
            String str2;
            String str3 = null;
            if (a.this.hvv != null) {
                a.this.hvv.showPostThreadLoadingView(false);
                if (z) {
                    a.this.fAb = postWriteCallBackData;
                    a.this.hsn = true;
                    if (tVar == null || tVar.CC() == null) {
                        str = null;
                        str2 = null;
                    } else {
                        str2 = tVar.CC().endPoint;
                        str = tVar.CC().successImg;
                        str3 = tVar.CC().slideEndPoint;
                    }
                    a.this.hvv.runJsMethod("success", str + "," + str2 + "," + str3);
                } else if (postWriteCallBackData == null || postWriteCallBackData.getErrorCode() != 227001) {
                    if (a.this.hvw != null) {
                        a.this.hvw.callback(false, postWriteCallBackData, tVar, writeData, antiData);
                    }
                } else {
                    a.this.hvv.getContext().setVisible(false);
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new AccountAccessActivityConfig(a.this.hvv.getContext().getActivity(), IEventCenterService.EventId.EventMode.SAPIACCOUNT_FACE_REG, writeData, postWriteCallBackData.getAccessState())));
                }
            }
        }
    };

    public a(NewVcodeView newVcodeView, NewWriteModel newWriteModel) {
        this.hvv = newVcodeView;
        this.hsm = newWriteModel;
        this.hsm.b(this.aOd);
    }

    @Override // com.baidu.tieba.write.vcode.newVcode.a.b
    public boolean onUrlLoad(WebView webView, String str) {
        WriteData writeData;
        if (this.hsm.getWriteData() == null || StringUtils.isNull(str) || (writeData = this.hsm.getWriteData()) == null) {
            return false;
        }
        if (str.contains("objc:loadReady")) {
            if (writeData.getVcodeExtra() == null) {
                return false;
            }
            this.hvv.runJsMethod("handleFreshCaptcha", "'" + writeData.getVcodeUrl() + "','" + writeData.getVcodeExtra().slideImg + "','" + writeData.getVcodeExtra().textImg + "'");
            return true;
        } else if (str.contains("objc:jsChangePosition")) {
            vG(com.baidu.tbadk.p.a.hP(str));
            return true;
        } else if (str.contains("objc:finish")) {
            this.hsn = true;
            if (writeData != null && writeData.getVideoReviewType() == 1) {
                this.hvv.showToast(true, this.hvv.getContext().getResources().getString(d.k.video_send_success_under_review));
            } else if (writeData != null && writeData.getVideoReviewType() == 2) {
                this.hvv.showToast(true, this.hvv.getContext().getResources().getString(d.k.video_send_success));
            } else {
                String str2 = null;
                String str3 = null;
                String string = this.hvv.getContext().getResources().getString(d.k.send_success);
                if (this.fAb != null) {
                    str2 = this.fAb.getPreMsg();
                    str3 = this.fAb.getColorMsg();
                    string = this.fAb.getErrorString();
                }
                if (writeData.getType() != 7) {
                    com.baidu.tieba.tbadkCore.writeModel.c.e(this.hvv.getContext().getActivity(), string, str2, str3);
                }
            }
            Intent intent = new Intent();
            Bundle bundle = new Bundle();
            bundle.putSerializable("post_write_callback_data", this.fAb);
            intent.putExtras(bundle);
            BaseActivity context = this.hvv.getContext();
            this.hvv.getContext();
            context.setResult(-1, intent);
            this.hvv.getContext().finish();
            return true;
        } else if (str.contains("objc:jumpToFeedback()")) {
            WriteActivityConfig writeActivityConfig = new WriteActivityConfig(this.hvv.getContext().getActivity(), 0, TbConfig.getPositionPagerId(), TbConfig.getPositionPagerName(), null, null, 0, null, 13003, true, false, null, false, false, null, null, null, 0);
            writeActivityConfig.setIsVcodeFeedBack();
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, writeActivityConfig));
            return true;
        } else {
            return false;
        }
    }

    @Override // com.baidu.tieba.write.vcode.newVcode.a.b
    public void onPageFinished(WebView webView, String str) {
        if (this.hvv != null) {
            this.hvv.showWebViewDelay(1000);
        }
    }

    @Override // com.baidu.tieba.write.vcode.newVcode.a.b
    public void showErrorOnStart(boolean z, String str) {
    }

    @Override // com.baidu.tieba.write.vcode.newVcode.a.b
    public void start(boolean z) {
        this.hvv.setRatio(0.9433962f);
        this.hvv.showWebView(false);
        this.hvv.getWebView().loadUrl(TbConfig.SERVER_ADDRESS_WEB_VIEW + "n/captcha-drag");
    }

    @Override // com.baidu.tieba.write.vcode.newVcode.a.b
    public void onDestroy() {
    }

    @Override // com.baidu.tieba.write.vcode.newVcode.a.b
    public void d(NewWriteModel.d dVar) {
        this.hvw = dVar;
    }

    @Override // com.baidu.tieba.write.vcode.newVcode.a.b
    public void onPostThreadCancle() {
        this.hvv.showPostThreadLoadingView(false);
        this.hsm.cancelLoadData();
    }

    private void vG(String str) {
        this.hsn = false;
        if (!l.jU()) {
            this.hvv.getContext().showToast(d.k.neterror);
            this.hvv.getContext().finish();
        } else if (!StringUtils.isNull(str)) {
            this.hvv.showPostThreadLoadingView(true);
            this.hsm.getWriteData().setVcode(str);
            this.hsm.getWriteData().setVcodeType("5");
            this.hsm.startPostWrite();
        } else {
            this.hvv.getContext().showToast(d.k.neterror);
            this.hvv.getContext().finish();
        }
    }
}
