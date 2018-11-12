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
    private PostWriteCallBackData fQQ;
    private final NewWriteModel hKo;
    private final NewVcodeView hNX;
    private NewWriteModel.d hNY;
    private boolean hKp = false;
    private final NewWriteModel.d aWI = new NewWriteModel.d() { // from class: com.baidu.tieba.write.vcode.newVcode.a.a.1
        @Override // com.baidu.tieba.tbadkCore.writeModel.NewWriteModel.d
        public void callback(boolean z, PostWriteCallBackData postWriteCallBackData, w wVar, WriteData writeData, AntiData antiData) {
            String str;
            String str2;
            String str3 = null;
            if (a.this.hNX != null) {
                a.this.hNX.showPostThreadLoadingView(false);
                if (z) {
                    a.this.fQQ = postWriteCallBackData;
                    a.this.hKp = true;
                    if (wVar == null || wVar.FS() == null) {
                        str = null;
                        str2 = null;
                    } else {
                        str2 = wVar.FS().endPoint;
                        str = wVar.FS().successImg;
                        str3 = wVar.FS().slideEndPoint;
                    }
                    a.this.hNX.runJsMethod("success", str + "," + str2 + "," + str3);
                } else if (postWriteCallBackData == null || postWriteCallBackData.getErrorCode() != 227001) {
                    if (a.this.hNY != null) {
                        a.this.hNY.callback(false, postWriteCallBackData, wVar, writeData, antiData);
                    }
                } else {
                    a.this.hNX.getContext().setVisible(false);
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new AccountAccessActivityConfig(a.this.hNX.getContext().getActivity(), IEventCenterService.EventId.EventMode.SAPIACCOUNT_FACE_REG, writeData, postWriteCallBackData.getAccessState())));
                }
            }
        }
    };

    public a(NewVcodeView newVcodeView, NewWriteModel newWriteModel) {
        this.hNX = newVcodeView;
        this.hKo = newWriteModel;
        this.hKo.b(this.aWI);
    }

    @Override // com.baidu.tieba.write.vcode.newVcode.a.b
    public boolean onUrlLoad(WebView webView, String str) {
        WriteData writeData;
        if (this.hKo.getWriteData() == null || StringUtils.isNull(str) || (writeData = this.hKo.getWriteData()) == null) {
            return false;
        }
        if (str.contains("objc:loadReady")) {
            if (writeData.getVcodeExtra() == null) {
                return false;
            }
            this.hNX.runJsMethod("handleFreshCaptcha", "'" + writeData.getVcodeUrl() + "','" + writeData.getVcodeExtra().slideImg + "','" + writeData.getVcodeExtra().textImg + "'");
            return true;
        } else if (str.contains("objc:jsChangePosition")) {
            xc(com.baidu.tbadk.q.a.iz(str));
            return true;
        } else if (str.contains("objc:finish")) {
            this.hKp = true;
            if (writeData != null && writeData.getVideoReviewType() == 1) {
                this.hNX.showToast(true, this.hNX.getContext().getResources().getString(e.j.video_send_success_under_review));
            } else if (writeData != null && writeData.getVideoReviewType() == 2) {
                this.hNX.showToast(true, this.hNX.getContext().getResources().getString(e.j.video_send_success));
            } else {
                String str2 = null;
                String str3 = null;
                String string = this.hNX.getContext().getResources().getString(e.j.send_success);
                if (this.fQQ != null) {
                    str2 = this.fQQ.getPreMsg();
                    str3 = this.fQQ.getColorMsg();
                    string = this.fQQ.getErrorString();
                }
                if (writeData.getType() != 7) {
                    com.baidu.tieba.tbadkCore.writeModel.c.e(this.hNX.getContext().getActivity(), string, str2, str3);
                }
            }
            Intent intent = new Intent();
            Bundle bundle = new Bundle();
            bundle.putSerializable("post_write_callback_data", this.fQQ);
            intent.putExtras(bundle);
            BaseActivity context = this.hNX.getContext();
            this.hNX.getContext();
            context.setResult(-1, intent);
            this.hNX.getContext().finish();
            return true;
        } else if (str.contains("objc:jumpToFeedback()")) {
            WriteActivityConfig writeActivityConfig = new WriteActivityConfig(this.hNX.getContext().getActivity(), 0, TbConfig.getPositionPagerId(), TbConfig.getPositionPagerName(), null, null, 0, null, 13003, true, false, null, false, false, null, null, null, 0);
            writeActivityConfig.setIsVcodeFeedBack();
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, writeActivityConfig));
            return true;
        } else {
            return false;
        }
    }

    @Override // com.baidu.tieba.write.vcode.newVcode.a.b
    public void onPageFinished(WebView webView, String str) {
        if (this.hNX != null) {
            this.hNX.showWebViewDelay(1000);
        }
    }

    @Override // com.baidu.tieba.write.vcode.newVcode.a.b
    public void showErrorOnStart(boolean z, String str) {
    }

    @Override // com.baidu.tieba.write.vcode.newVcode.a.b
    public void start(boolean z) {
        this.hNX.setRatio(0.9433962f);
        this.hNX.showWebView(false);
        this.hNX.getWebView().loadUrl(TbConfig.SERVER_ADDRESS_WEB_VIEW + "n/captcha-drag");
    }

    @Override // com.baidu.tieba.write.vcode.newVcode.a.b
    public void onDestroy() {
    }

    @Override // com.baidu.tieba.write.vcode.newVcode.a.b
    public void d(NewWriteModel.d dVar) {
        this.hNY = dVar;
    }

    @Override // com.baidu.tieba.write.vcode.newVcode.a.b
    public void onPostThreadCancle() {
        this.hNX.showPostThreadLoadingView(false);
        this.hKo.cancelLoadData();
    }

    private void xc(String str) {
        this.hKp = false;
        if (!l.lm()) {
            this.hNX.getContext().showToast(e.j.neterror);
            this.hNX.getContext().finish();
        } else if (!StringUtils.isNull(str)) {
            this.hNX.showPostThreadLoadingView(true);
            this.hKo.getWriteData().setVcode(str);
            this.hKo.getWriteData().setVcodeType("5");
            this.hKo.startPostWrite();
        } else {
            this.hNX.getContext().showToast(e.j.neterror);
            this.hNX.getContext().finish();
        }
    }
}
