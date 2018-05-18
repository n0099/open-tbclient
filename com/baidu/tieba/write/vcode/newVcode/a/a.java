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
import com.baidu.tbadk.core.diskCache.ImagesInvalidReceiver;
import com.baidu.tbadk.coreExtra.data.WriteData;
import com.baidu.tbadk.coreExtra.data.t;
import com.baidu.tieba.d;
import com.baidu.tieba.tbadkCore.writeModel.NewWriteModel;
import com.baidu.tieba.tbadkCore.writeModel.PostWriteCallBackData;
import com.baidu.tieba.write.vcode.newVcode.NewVcodeView;
import com.xiaomi.mipush.sdk.Constants;
/* loaded from: classes3.dex */
public class a implements b {
    private PostWriteCallBackData fkF;
    private final NewWriteModel hci;
    private final NewVcodeView hfr;
    private NewWriteModel.d hfs;
    private boolean hcj = false;
    private final NewWriteModel.d aEL = new NewWriteModel.d() { // from class: com.baidu.tieba.write.vcode.newVcode.a.a.1
        @Override // com.baidu.tieba.tbadkCore.writeModel.NewWriteModel.d
        public void callback(boolean z, PostWriteCallBackData postWriteCallBackData, t tVar, WriteData writeData, AntiData antiData) {
            String str;
            String str2;
            String str3 = null;
            if (a.this.hfr != null) {
                a.this.hfr.showPostThreadLoadingView(false);
                if (z) {
                    a.this.fkF = postWriteCallBackData;
                    a.this.hcj = true;
                    if (tVar == null || tVar.yK() == null) {
                        str = null;
                        str2 = null;
                    } else {
                        str2 = tVar.yK().endPoint;
                        str = tVar.yK().successImg;
                        str3 = tVar.yK().slideEndPoint;
                    }
                    a.this.hfr.runJsMethod(ImagesInvalidReceiver.SUCCESS, str + Constants.ACCEPT_TIME_SEPARATOR_SP + str2 + Constants.ACCEPT_TIME_SEPARATOR_SP + str3);
                } else if (postWriteCallBackData == null || postWriteCallBackData.getErrorCode() != 227001) {
                    if (a.this.hfs != null) {
                        a.this.hfs.callback(false, postWriteCallBackData, tVar, writeData, antiData);
                    }
                } else {
                    a.this.hfr.getContext().setVisible(false);
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new AccountAccessActivityConfig(a.this.hfr.getContext().getActivity(), IEventCenterService.EventId.EventMode.SAPIACCOUNT_FACE_REG, writeData, postWriteCallBackData.getAccessState())));
                }
            }
        }
    };

    public a(NewVcodeView newVcodeView, NewWriteModel newWriteModel) {
        this.hfr = newVcodeView;
        this.hci = newWriteModel;
        this.hci.b(this.aEL);
    }

    @Override // com.baidu.tieba.write.vcode.newVcode.a.b
    public boolean onUrlLoad(WebView webView, String str) {
        WriteData writeData;
        if (this.hci.getWriteData() == null || StringUtils.isNull(str) || (writeData = this.hci.getWriteData()) == null) {
            return false;
        }
        if (str.contains("objc:loadReady")) {
            if (writeData.getVcodeExtra() == null) {
                return false;
            }
            this.hfr.runJsMethod("handleFreshCaptcha", "'" + writeData.getVcodeUrl() + "','" + writeData.getVcodeExtra().slideImg + "','" + writeData.getVcodeExtra().textImg + "'");
            return true;
        } else if (str.contains("objc:jsChangePosition")) {
            uQ(com.baidu.tbadk.p.a.hq(str));
            return true;
        } else if (str.contains("objc:finish")) {
            this.hcj = true;
            if (writeData != null && writeData.getVideoReviewType() == 1) {
                this.hfr.showToast(true, this.hfr.getContext().getResources().getString(d.k.video_send_success_under_review));
            } else if (writeData != null && writeData.getVideoReviewType() == 2) {
                this.hfr.showToast(true, this.hfr.getContext().getResources().getString(d.k.video_send_success));
            } else {
                String str2 = null;
                String str3 = null;
                String string = this.hfr.getContext().getResources().getString(d.k.send_success);
                if (this.fkF != null) {
                    str2 = this.fkF.getPreMsg();
                    str3 = this.fkF.getColorMsg();
                    string = this.fkF.getErrorString();
                }
                if (writeData.getType() != 7) {
                    com.baidu.tieba.tbadkCore.writeModel.c.e(this.hfr.getContext().getActivity(), string, str2, str3);
                }
            }
            Intent intent = new Intent();
            Bundle bundle = new Bundle();
            bundle.putSerializable("post_write_callback_data", this.fkF);
            intent.putExtras(bundle);
            BaseActivity context = this.hfr.getContext();
            this.hfr.getContext();
            context.setResult(-1, intent);
            this.hfr.getContext().finish();
            return true;
        } else if (str.contains("objc:jumpToFeedback()")) {
            WriteActivityConfig writeActivityConfig = new WriteActivityConfig(this.hfr.getContext().getActivity(), 0, TbConfig.getPositionPagerId(), TbConfig.getPositionPagerName(), null, null, 0, null, 13003, true, false, null, false, false, null, null, null, 0);
            writeActivityConfig.setIsVcodeFeedBack();
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, writeActivityConfig));
            return true;
        } else {
            return false;
        }
    }

    @Override // com.baidu.tieba.write.vcode.newVcode.a.b
    public void onPageFinished(WebView webView, String str) {
        if (this.hfr != null) {
            this.hfr.showWebViewDelay(1000);
        }
    }

    @Override // com.baidu.tieba.write.vcode.newVcode.a.b
    public void showErrorOnStart(boolean z, String str) {
    }

    @Override // com.baidu.tieba.write.vcode.newVcode.a.b
    public void start(boolean z) {
        this.hfr.setRatio(0.9433962f);
        this.hfr.showWebView(false);
        this.hfr.getWebView().loadUrl(TbConfig.SERVER_ADDRESS_WEB_VIEW + "n/captcha-drag");
    }

    @Override // com.baidu.tieba.write.vcode.newVcode.a.b
    public void onDestroy() {
    }

    @Override // com.baidu.tieba.write.vcode.newVcode.a.b
    public void d(NewWriteModel.d dVar) {
        this.hfs = dVar;
    }

    @Override // com.baidu.tieba.write.vcode.newVcode.a.b
    public void onPostThreadCancle() {
        this.hfr.showPostThreadLoadingView(false);
        this.hci.cancelLoadData();
    }

    private void uQ(String str) {
        this.hcj = false;
        if (!l.hg()) {
            this.hfr.getContext().showToast(d.k.neterror);
            this.hfr.getContext().finish();
        } else if (!StringUtils.isNull(str)) {
            this.hfr.showPostThreadLoadingView(true);
            this.hci.getWriteData().setVcode(str);
            this.hci.getWriteData().setVcodeType("5");
            this.hci.startPostWrite();
        } else {
            this.hfr.getContext().showToast(d.k.neterror);
            this.hfr.getContext().finish();
        }
    }
}
