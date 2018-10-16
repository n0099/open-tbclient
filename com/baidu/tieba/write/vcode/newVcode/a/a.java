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
    private PostWriteCallBackData fPq;
    private final NewWriteModel hID;
    private final NewVcodeView hMm;
    private NewWriteModel.d hMn;
    private boolean hIE = false;
    private final NewWriteModel.d aVS = new NewWriteModel.d() { // from class: com.baidu.tieba.write.vcode.newVcode.a.a.1
        @Override // com.baidu.tieba.tbadkCore.writeModel.NewWriteModel.d
        public void callback(boolean z, PostWriteCallBackData postWriteCallBackData, v vVar, WriteData writeData, AntiData antiData) {
            String str;
            String str2;
            String str3 = null;
            if (a.this.hMm != null) {
                a.this.hMm.showPostThreadLoadingView(false);
                if (z) {
                    a.this.fPq = postWriteCallBackData;
                    a.this.hIE = true;
                    if (vVar == null || vVar.FG() == null) {
                        str = null;
                        str2 = null;
                    } else {
                        str2 = vVar.FG().endPoint;
                        str = vVar.FG().successImg;
                        str3 = vVar.FG().slideEndPoint;
                    }
                    a.this.hMm.runJsMethod("success", str + "," + str2 + "," + str3);
                } else if (postWriteCallBackData == null || postWriteCallBackData.getErrorCode() != 227001) {
                    if (a.this.hMn != null) {
                        a.this.hMn.callback(false, postWriteCallBackData, vVar, writeData, antiData);
                    }
                } else {
                    a.this.hMm.getContext().setVisible(false);
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new AccountAccessActivityConfig(a.this.hMm.getContext().getActivity(), IEventCenterService.EventId.EventMode.SAPIACCOUNT_FACE_REG, writeData, postWriteCallBackData.getAccessState())));
                }
            }
        }
    };

    public a(NewVcodeView newVcodeView, NewWriteModel newWriteModel) {
        this.hMm = newVcodeView;
        this.hID = newWriteModel;
        this.hID.b(this.aVS);
    }

    @Override // com.baidu.tieba.write.vcode.newVcode.a.b
    public boolean onUrlLoad(WebView webView, String str) {
        WriteData writeData;
        if (this.hID.getWriteData() == null || StringUtils.isNull(str) || (writeData = this.hID.getWriteData()) == null) {
            return false;
        }
        if (str.contains("objc:loadReady")) {
            if (writeData.getVcodeExtra() == null) {
                return false;
            }
            this.hMm.runJsMethod("handleFreshCaptcha", "'" + writeData.getVcodeUrl() + "','" + writeData.getVcodeExtra().slideImg + "','" + writeData.getVcodeExtra().textImg + "'");
            return true;
        } else if (str.contains("objc:jsChangePosition")) {
            wX(com.baidu.tbadk.q.a.ix(str));
            return true;
        } else if (str.contains("objc:finish")) {
            this.hIE = true;
            if (writeData != null && writeData.getVideoReviewType() == 1) {
                this.hMm.showToast(true, this.hMm.getContext().getResources().getString(e.j.video_send_success_under_review));
            } else if (writeData != null && writeData.getVideoReviewType() == 2) {
                this.hMm.showToast(true, this.hMm.getContext().getResources().getString(e.j.video_send_success));
            } else {
                String str2 = null;
                String str3 = null;
                String string = this.hMm.getContext().getResources().getString(e.j.send_success);
                if (this.fPq != null) {
                    str2 = this.fPq.getPreMsg();
                    str3 = this.fPq.getColorMsg();
                    string = this.fPq.getErrorString();
                }
                if (writeData.getType() != 7) {
                    com.baidu.tieba.tbadkCore.writeModel.c.e(this.hMm.getContext().getActivity(), string, str2, str3);
                }
            }
            Intent intent = new Intent();
            Bundle bundle = new Bundle();
            bundle.putSerializable("post_write_callback_data", this.fPq);
            intent.putExtras(bundle);
            BaseActivity context = this.hMm.getContext();
            this.hMm.getContext();
            context.setResult(-1, intent);
            this.hMm.getContext().finish();
            return true;
        } else if (str.contains("objc:jumpToFeedback()")) {
            WriteActivityConfig writeActivityConfig = new WriteActivityConfig(this.hMm.getContext().getActivity(), 0, TbConfig.getPositionPagerId(), TbConfig.getPositionPagerName(), null, null, 0, null, 13003, true, false, null, false, false, null, null, null, 0);
            writeActivityConfig.setIsVcodeFeedBack();
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, writeActivityConfig));
            return true;
        } else {
            return false;
        }
    }

    @Override // com.baidu.tieba.write.vcode.newVcode.a.b
    public void onPageFinished(WebView webView, String str) {
        if (this.hMm != null) {
            this.hMm.showWebViewDelay(1000);
        }
    }

    @Override // com.baidu.tieba.write.vcode.newVcode.a.b
    public void showErrorOnStart(boolean z, String str) {
    }

    @Override // com.baidu.tieba.write.vcode.newVcode.a.b
    public void start(boolean z) {
        this.hMm.setRatio(0.9433962f);
        this.hMm.showWebView(false);
        this.hMm.getWebView().loadUrl(TbConfig.SERVER_ADDRESS_WEB_VIEW + "n/captcha-drag");
    }

    @Override // com.baidu.tieba.write.vcode.newVcode.a.b
    public void onDestroy() {
    }

    @Override // com.baidu.tieba.write.vcode.newVcode.a.b
    public void d(NewWriteModel.d dVar) {
        this.hMn = dVar;
    }

    @Override // com.baidu.tieba.write.vcode.newVcode.a.b
    public void onPostThreadCancle() {
        this.hMm.showPostThreadLoadingView(false);
        this.hID.cancelLoadData();
    }

    private void wX(String str) {
        this.hIE = false;
        if (!l.lo()) {
            this.hMm.getContext().showToast(e.j.neterror);
            this.hMm.getContext().finish();
        } else if (!StringUtils.isNull(str)) {
            this.hMm.showPostThreadLoadingView(true);
            this.hID.getWriteData().setVcode(str);
            this.hID.getWriteData().setVcodeType("5");
            this.hID.startPostWrite();
        } else {
            this.hMm.getContext().showToast(e.j.neterror);
            this.hMm.getContext().finish();
        }
    }
}
