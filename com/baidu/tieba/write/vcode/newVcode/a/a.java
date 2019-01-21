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
import com.baidu.tbadk.coreExtra.data.x;
import com.baidu.tieba.e;
import com.baidu.tieba.tbadkCore.writeModel.NewWriteModel;
import com.baidu.tieba.tbadkCore.writeModel.PostWriteCallBackData;
import com.baidu.tieba.write.vcode.newVcode.NewVcodeView;
/* loaded from: classes3.dex */
public class a implements b {
    private PostWriteCallBackData gbw;
    private final NewWriteModel hVS;
    private final NewVcodeView hZA;
    private NewWriteModel.d hZB;
    private boolean hVT = false;
    private final NewWriteModel.d baU = new NewWriteModel.d() { // from class: com.baidu.tieba.write.vcode.newVcode.a.a.1
        @Override // com.baidu.tieba.tbadkCore.writeModel.NewWriteModel.d
        public void callback(boolean z, PostWriteCallBackData postWriteCallBackData, x xVar, WriteData writeData, AntiData antiData) {
            String str;
            String str2;
            String str3 = null;
            if (a.this.hZA != null) {
                a.this.hZA.showPostThreadLoadingView(false);
                if (z) {
                    a.this.gbw = postWriteCallBackData;
                    a.this.hVT = true;
                    if (xVar == null || xVar.Hl() == null) {
                        str = null;
                        str2 = null;
                    } else {
                        str2 = xVar.Hl().endPoint;
                        str = xVar.Hl().successImg;
                        str3 = xVar.Hl().slideEndPoint;
                    }
                    a.this.hZA.runJsMethod("success", str + "," + str2 + "," + str3);
                } else if (postWriteCallBackData == null || postWriteCallBackData.getErrorCode() != 227001) {
                    if (a.this.hZB != null) {
                        a.this.hZB.callback(false, postWriteCallBackData, xVar, writeData, antiData);
                    }
                } else {
                    a.this.hZA.getContext().setVisible(false);
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new AccountAccessActivityConfig(a.this.hZA.getContext().getActivity(), IEventCenterService.EventId.EventMode.SAPIACCOUNT_FACE_REG, writeData, postWriteCallBackData.getAccessState())));
                }
            }
        }
    };

    public a(NewVcodeView newVcodeView, NewWriteModel newWriteModel) {
        this.hZA = newVcodeView;
        this.hVS = newWriteModel;
        this.hVS.b(this.baU);
    }

    @Override // com.baidu.tieba.write.vcode.newVcode.a.b
    public boolean onUrlLoad(WebView webView, String str) {
        WriteData writeData;
        if (this.hVS.getWriteData() == null || StringUtils.isNull(str) || (writeData = this.hVS.getWriteData()) == null) {
            return false;
        }
        if (str.contains("objc:loadReady")) {
            if (writeData.getVcodeExtra() == null) {
                return false;
            }
            this.hZA.runJsMethod("handleFreshCaptcha", "'" + writeData.getVcodeUrl() + "','" + writeData.getVcodeExtra().slideImg + "','" + writeData.getVcodeExtra().textImg + "'");
            return true;
        } else if (str.contains("objc:jsChangePosition")) {
            xY(com.baidu.tbadk.r.a.ji(str));
            return true;
        } else if (str.contains("objc:finish")) {
            this.hVT = true;
            if (writeData != null && writeData.getVideoReviewType() == 1) {
                this.hZA.showToast(true, this.hZA.getContext().getResources().getString(e.j.video_send_success_under_review));
            } else if (writeData != null && writeData.getVideoReviewType() == 2) {
                this.hZA.showToast(true, this.hZA.getContext().getResources().getString(e.j.video_send_success));
            } else {
                String str2 = null;
                String str3 = null;
                String string = this.hZA.getContext().getResources().getString(e.j.send_success);
                if (this.gbw != null) {
                    str2 = this.gbw.getPreMsg();
                    str3 = this.gbw.getColorMsg();
                    string = this.gbw.getErrorString();
                }
                if (writeData.getType() != 7) {
                    com.baidu.tieba.tbadkCore.writeModel.c.e(this.hZA.getContext().getActivity(), string, str2, str3);
                }
            }
            Intent intent = new Intent();
            Bundle bundle = new Bundle();
            bundle.putSerializable("post_write_callback_data", this.gbw);
            intent.putExtras(bundle);
            BaseActivity context = this.hZA.getContext();
            this.hZA.getContext();
            context.setResult(-1, intent);
            this.hZA.getContext().finish();
            return true;
        } else if (str.contains("objc:jumpToFeedback()")) {
            WriteActivityConfig writeActivityConfig = new WriteActivityConfig(this.hZA.getContext().getActivity(), 0, TbConfig.getPositionPagerId(), TbConfig.getPositionPagerName(), null, null, 0, null, 13003, true, false, null, false, false, null, null, null, 0);
            writeActivityConfig.setIsVcodeFeedBack();
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, writeActivityConfig));
            return true;
        } else {
            return false;
        }
    }

    @Override // com.baidu.tieba.write.vcode.newVcode.a.b
    public void onPageFinished(WebView webView, String str) {
        if (this.hZA != null) {
            this.hZA.showWebViewDelay(1000);
        }
    }

    @Override // com.baidu.tieba.write.vcode.newVcode.a.b
    public void showErrorOnStart(boolean z, String str) {
    }

    @Override // com.baidu.tieba.write.vcode.newVcode.a.b
    public void start(boolean z) {
        this.hZA.setRatio(0.9433962f);
        this.hZA.showWebView(false);
        this.hZA.getWebView().loadUrl(TbConfig.SERVER_ADDRESS_WEB_VIEW + "n/captcha-drag");
    }

    @Override // com.baidu.tieba.write.vcode.newVcode.a.b
    public void onDestroy() {
    }

    @Override // com.baidu.tieba.write.vcode.newVcode.a.b
    public void d(NewWriteModel.d dVar) {
        this.hZB = dVar;
    }

    @Override // com.baidu.tieba.write.vcode.newVcode.a.b
    public void onPostThreadCancle() {
        this.hZA.showPostThreadLoadingView(false);
        this.hVS.cancelLoadData();
    }

    private void xY(String str) {
        this.hVT = false;
        if (!l.ll()) {
            this.hZA.getContext().showToast(e.j.neterror);
            this.hZA.getContext().finish();
        } else if (!StringUtils.isNull(str)) {
            this.hZA.showPostThreadLoadingView(true);
            this.hVS.getWriteData().setVcode(str);
            this.hVS.getWriteData().setVcodeType("5");
            this.hVS.startPostWrite();
        } else {
            this.hZA.getContext().showToast(e.j.neterror);
            this.hZA.getContext().finish();
        }
    }
}
