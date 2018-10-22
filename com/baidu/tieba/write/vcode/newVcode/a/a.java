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
    private PostWriteCallBackData fPr;
    private final NewWriteModel hIE;
    private final NewVcodeView hMn;
    private NewWriteModel.d hMo;
    private boolean hIF = false;
    private final NewWriteModel.d aVS = new NewWriteModel.d() { // from class: com.baidu.tieba.write.vcode.newVcode.a.a.1
        @Override // com.baidu.tieba.tbadkCore.writeModel.NewWriteModel.d
        public void callback(boolean z, PostWriteCallBackData postWriteCallBackData, v vVar, WriteData writeData, AntiData antiData) {
            String str;
            String str2;
            String str3 = null;
            if (a.this.hMn != null) {
                a.this.hMn.showPostThreadLoadingView(false);
                if (z) {
                    a.this.fPr = postWriteCallBackData;
                    a.this.hIF = true;
                    if (vVar == null || vVar.FG() == null) {
                        str = null;
                        str2 = null;
                    } else {
                        str2 = vVar.FG().endPoint;
                        str = vVar.FG().successImg;
                        str3 = vVar.FG().slideEndPoint;
                    }
                    a.this.hMn.runJsMethod("success", str + "," + str2 + "," + str3);
                } else if (postWriteCallBackData == null || postWriteCallBackData.getErrorCode() != 227001) {
                    if (a.this.hMo != null) {
                        a.this.hMo.callback(false, postWriteCallBackData, vVar, writeData, antiData);
                    }
                } else {
                    a.this.hMn.getContext().setVisible(false);
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new AccountAccessActivityConfig(a.this.hMn.getContext().getActivity(), IEventCenterService.EventId.EventMode.SAPIACCOUNT_FACE_REG, writeData, postWriteCallBackData.getAccessState())));
                }
            }
        }
    };

    public a(NewVcodeView newVcodeView, NewWriteModel newWriteModel) {
        this.hMn = newVcodeView;
        this.hIE = newWriteModel;
        this.hIE.b(this.aVS);
    }

    @Override // com.baidu.tieba.write.vcode.newVcode.a.b
    public boolean onUrlLoad(WebView webView, String str) {
        WriteData writeData;
        if (this.hIE.getWriteData() == null || StringUtils.isNull(str) || (writeData = this.hIE.getWriteData()) == null) {
            return false;
        }
        if (str.contains("objc:loadReady")) {
            if (writeData.getVcodeExtra() == null) {
                return false;
            }
            this.hMn.runJsMethod("handleFreshCaptcha", "'" + writeData.getVcodeUrl() + "','" + writeData.getVcodeExtra().slideImg + "','" + writeData.getVcodeExtra().textImg + "'");
            return true;
        } else if (str.contains("objc:jsChangePosition")) {
            wX(com.baidu.tbadk.q.a.ix(str));
            return true;
        } else if (str.contains("objc:finish")) {
            this.hIF = true;
            if (writeData != null && writeData.getVideoReviewType() == 1) {
                this.hMn.showToast(true, this.hMn.getContext().getResources().getString(e.j.video_send_success_under_review));
            } else if (writeData != null && writeData.getVideoReviewType() == 2) {
                this.hMn.showToast(true, this.hMn.getContext().getResources().getString(e.j.video_send_success));
            } else {
                String str2 = null;
                String str3 = null;
                String string = this.hMn.getContext().getResources().getString(e.j.send_success);
                if (this.fPr != null) {
                    str2 = this.fPr.getPreMsg();
                    str3 = this.fPr.getColorMsg();
                    string = this.fPr.getErrorString();
                }
                if (writeData.getType() != 7) {
                    com.baidu.tieba.tbadkCore.writeModel.c.e(this.hMn.getContext().getActivity(), string, str2, str3);
                }
            }
            Intent intent = new Intent();
            Bundle bundle = new Bundle();
            bundle.putSerializable("post_write_callback_data", this.fPr);
            intent.putExtras(bundle);
            BaseActivity context = this.hMn.getContext();
            this.hMn.getContext();
            context.setResult(-1, intent);
            this.hMn.getContext().finish();
            return true;
        } else if (str.contains("objc:jumpToFeedback()")) {
            WriteActivityConfig writeActivityConfig = new WriteActivityConfig(this.hMn.getContext().getActivity(), 0, TbConfig.getPositionPagerId(), TbConfig.getPositionPagerName(), null, null, 0, null, 13003, true, false, null, false, false, null, null, null, 0);
            writeActivityConfig.setIsVcodeFeedBack();
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, writeActivityConfig));
            return true;
        } else {
            return false;
        }
    }

    @Override // com.baidu.tieba.write.vcode.newVcode.a.b
    public void onPageFinished(WebView webView, String str) {
        if (this.hMn != null) {
            this.hMn.showWebViewDelay(1000);
        }
    }

    @Override // com.baidu.tieba.write.vcode.newVcode.a.b
    public void showErrorOnStart(boolean z, String str) {
    }

    @Override // com.baidu.tieba.write.vcode.newVcode.a.b
    public void start(boolean z) {
        this.hMn.setRatio(0.9433962f);
        this.hMn.showWebView(false);
        this.hMn.getWebView().loadUrl(TbConfig.SERVER_ADDRESS_WEB_VIEW + "n/captcha-drag");
    }

    @Override // com.baidu.tieba.write.vcode.newVcode.a.b
    public void onDestroy() {
    }

    @Override // com.baidu.tieba.write.vcode.newVcode.a.b
    public void d(NewWriteModel.d dVar) {
        this.hMo = dVar;
    }

    @Override // com.baidu.tieba.write.vcode.newVcode.a.b
    public void onPostThreadCancle() {
        this.hMn.showPostThreadLoadingView(false);
        this.hIE.cancelLoadData();
    }

    private void wX(String str) {
        this.hIF = false;
        if (!l.lo()) {
            this.hMn.getContext().showToast(e.j.neterror);
            this.hMn.getContext().finish();
        } else if (!StringUtils.isNull(str)) {
            this.hMn.showPostThreadLoadingView(true);
            this.hIE.getWriteData().setVcode(str);
            this.hIE.getWriteData().setVcodeType("5");
            this.hIE.startPostWrite();
        } else {
            this.hMn.getContext().showToast(e.j.neterror);
            this.hMn.getContext().finish();
        }
    }
}
