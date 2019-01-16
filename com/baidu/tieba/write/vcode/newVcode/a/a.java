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
    private PostWriteCallBackData gbv;
    private final NewWriteModel hVR;
    private NewWriteModel.d hZA;
    private final NewVcodeView hZz;
    private boolean hVS = false;
    private final NewWriteModel.d baT = new NewWriteModel.d() { // from class: com.baidu.tieba.write.vcode.newVcode.a.a.1
        @Override // com.baidu.tieba.tbadkCore.writeModel.NewWriteModel.d
        public void callback(boolean z, PostWriteCallBackData postWriteCallBackData, x xVar, WriteData writeData, AntiData antiData) {
            String str;
            String str2;
            String str3 = null;
            if (a.this.hZz != null) {
                a.this.hZz.showPostThreadLoadingView(false);
                if (z) {
                    a.this.gbv = postWriteCallBackData;
                    a.this.hVS = true;
                    if (xVar == null || xVar.Hl() == null) {
                        str = null;
                        str2 = null;
                    } else {
                        str2 = xVar.Hl().endPoint;
                        str = xVar.Hl().successImg;
                        str3 = xVar.Hl().slideEndPoint;
                    }
                    a.this.hZz.runJsMethod("success", str + "," + str2 + "," + str3);
                } else if (postWriteCallBackData == null || postWriteCallBackData.getErrorCode() != 227001) {
                    if (a.this.hZA != null) {
                        a.this.hZA.callback(false, postWriteCallBackData, xVar, writeData, antiData);
                    }
                } else {
                    a.this.hZz.getContext().setVisible(false);
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new AccountAccessActivityConfig(a.this.hZz.getContext().getActivity(), IEventCenterService.EventId.EventMode.SAPIACCOUNT_FACE_REG, writeData, postWriteCallBackData.getAccessState())));
                }
            }
        }
    };

    public a(NewVcodeView newVcodeView, NewWriteModel newWriteModel) {
        this.hZz = newVcodeView;
        this.hVR = newWriteModel;
        this.hVR.b(this.baT);
    }

    @Override // com.baidu.tieba.write.vcode.newVcode.a.b
    public boolean onUrlLoad(WebView webView, String str) {
        WriteData writeData;
        if (this.hVR.getWriteData() == null || StringUtils.isNull(str) || (writeData = this.hVR.getWriteData()) == null) {
            return false;
        }
        if (str.contains("objc:loadReady")) {
            if (writeData.getVcodeExtra() == null) {
                return false;
            }
            this.hZz.runJsMethod("handleFreshCaptcha", "'" + writeData.getVcodeUrl() + "','" + writeData.getVcodeExtra().slideImg + "','" + writeData.getVcodeExtra().textImg + "'");
            return true;
        } else if (str.contains("objc:jsChangePosition")) {
            xY(com.baidu.tbadk.r.a.ji(str));
            return true;
        } else if (str.contains("objc:finish")) {
            this.hVS = true;
            if (writeData != null && writeData.getVideoReviewType() == 1) {
                this.hZz.showToast(true, this.hZz.getContext().getResources().getString(e.j.video_send_success_under_review));
            } else if (writeData != null && writeData.getVideoReviewType() == 2) {
                this.hZz.showToast(true, this.hZz.getContext().getResources().getString(e.j.video_send_success));
            } else {
                String str2 = null;
                String str3 = null;
                String string = this.hZz.getContext().getResources().getString(e.j.send_success);
                if (this.gbv != null) {
                    str2 = this.gbv.getPreMsg();
                    str3 = this.gbv.getColorMsg();
                    string = this.gbv.getErrorString();
                }
                if (writeData.getType() != 7) {
                    com.baidu.tieba.tbadkCore.writeModel.c.e(this.hZz.getContext().getActivity(), string, str2, str3);
                }
            }
            Intent intent = new Intent();
            Bundle bundle = new Bundle();
            bundle.putSerializable("post_write_callback_data", this.gbv);
            intent.putExtras(bundle);
            BaseActivity context = this.hZz.getContext();
            this.hZz.getContext();
            context.setResult(-1, intent);
            this.hZz.getContext().finish();
            return true;
        } else if (str.contains("objc:jumpToFeedback()")) {
            WriteActivityConfig writeActivityConfig = new WriteActivityConfig(this.hZz.getContext().getActivity(), 0, TbConfig.getPositionPagerId(), TbConfig.getPositionPagerName(), null, null, 0, null, 13003, true, false, null, false, false, null, null, null, 0);
            writeActivityConfig.setIsVcodeFeedBack();
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, writeActivityConfig));
            return true;
        } else {
            return false;
        }
    }

    @Override // com.baidu.tieba.write.vcode.newVcode.a.b
    public void onPageFinished(WebView webView, String str) {
        if (this.hZz != null) {
            this.hZz.showWebViewDelay(1000);
        }
    }

    @Override // com.baidu.tieba.write.vcode.newVcode.a.b
    public void showErrorOnStart(boolean z, String str) {
    }

    @Override // com.baidu.tieba.write.vcode.newVcode.a.b
    public void start(boolean z) {
        this.hZz.setRatio(0.9433962f);
        this.hZz.showWebView(false);
        this.hZz.getWebView().loadUrl(TbConfig.SERVER_ADDRESS_WEB_VIEW + "n/captcha-drag");
    }

    @Override // com.baidu.tieba.write.vcode.newVcode.a.b
    public void onDestroy() {
    }

    @Override // com.baidu.tieba.write.vcode.newVcode.a.b
    public void d(NewWriteModel.d dVar) {
        this.hZA = dVar;
    }

    @Override // com.baidu.tieba.write.vcode.newVcode.a.b
    public void onPostThreadCancle() {
        this.hZz.showPostThreadLoadingView(false);
        this.hVR.cancelLoadData();
    }

    private void xY(String str) {
        this.hVS = false;
        if (!l.ll()) {
            this.hZz.getContext().showToast(e.j.neterror);
            this.hZz.getContext().finish();
        } else if (!StringUtils.isNull(str)) {
            this.hZz.showPostThreadLoadingView(true);
            this.hVR.getWriteData().setVcode(str);
            this.hVR.getWriteData().setVcodeType("5");
            this.hVR.startPostWrite();
        } else {
            this.hZz.getContext().showToast(e.j.neterror);
            this.hZz.getContext().finish();
        }
    }
}
