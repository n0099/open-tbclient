package com.baidu.tieba.write.vcode.newVcode.a;

import android.content.Intent;
import android.os.Bundle;
import android.webkit.WebView;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.lib.util.l;
import com.baidu.live.tbadk.core.data.RequestResponseCode;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.live.tbadk.data.Config;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.atomData.AccountAccessActivityConfig;
import com.baidu.tbadk.core.atomData.WriteActivityConfig;
import com.baidu.tbadk.core.data.AntiData;
import com.baidu.tbadk.coreExtra.data.WriteData;
import com.baidu.tbadk.coreExtra.data.ab;
import com.baidu.tieba.R;
import com.baidu.tieba.tbadkCore.writeModel.NewWriteModel;
import com.baidu.tieba.tbadkCore.writeModel.PostWriteCallBackData;
import com.baidu.tieba.write.vcode.newVcode.NewVcodeView;
import com.xiaomi.mipush.sdk.Constants;
/* loaded from: classes2.dex */
public class a implements b {
    private PostWriteCallBackData jNG;
    private final NewWriteModel lSm;
    private final NewVcodeView lWg;
    private NewWriteModel.d lWh;
    private boolean lSn = false;
    private final NewWriteModel.d emV = new NewWriteModel.d() { // from class: com.baidu.tieba.write.vcode.newVcode.a.a.1
        @Override // com.baidu.tieba.tbadkCore.writeModel.NewWriteModel.d
        public void callback(boolean z, PostWriteCallBackData postWriteCallBackData, ab abVar, WriteData writeData, AntiData antiData) {
            String str;
            String str2;
            String str3 = null;
            if (a.this.lWg != null) {
                a.this.lWg.showPostThreadLoadingView(false);
                if (z) {
                    a.this.jNG = postWriteCallBackData;
                    a.this.lSn = true;
                    if (abVar == null || abVar.aYn() == null) {
                        str = null;
                        str2 = null;
                    } else {
                        str2 = abVar.aYn().endPoint;
                        str = abVar.aYn().successImg;
                        str3 = abVar.aYn().slideEndPoint;
                    }
                    a.this.lWg.runJsMethod("success", str + Constants.ACCEPT_TIME_SEPARATOR_SP + str2 + Constants.ACCEPT_TIME_SEPARATOR_SP + str3);
                } else if (postWriteCallBackData == null || postWriteCallBackData.getErrorCode() != 227001) {
                    if (a.this.lWh != null) {
                        a.this.lWh.callback(false, postWriteCallBackData, abVar, writeData, antiData);
                    }
                } else {
                    a.this.lWg.getContext().setVisible(false);
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AccountAccessActivityConfig(a.this.lWg.getContext().getActivity(), RequestResponseCode.REQUEST_VCODE, writeData, postWriteCallBackData.getAccessState())));
                }
            }
        }
    };

    public a(NewVcodeView newVcodeView, NewWriteModel newWriteModel) {
        this.lWg = newVcodeView;
        this.lSm = newWriteModel;
        this.lSm.b(this.emV);
    }

    @Override // com.baidu.tieba.write.vcode.newVcode.a.b
    public boolean c(WebView webView, String str) {
        WriteData daf;
        if (this.lSm.daf() == null || StringUtils.isNull(str) || (daf = this.lSm.daf()) == null) {
            return false;
        }
        if (str.contains("objc:loadReady")) {
            if (daf.getVcodeExtra() == null) {
                return false;
            }
            this.lWg.runJsMethod("handleFreshCaptcha", "'" + daf.getVcodeUrl() + "','" + daf.getVcodeExtra().slideImg + "','" + daf.getVcodeExtra().textImg + "'");
            return true;
        } else if (str.contains("objc:jsChangePosition")) {
            Os(com.baidu.tbadk.s.a.yW(str));
            return true;
        } else if (str.contains("objc:finish")) {
            this.lSn = true;
            if (daf != null && daf.getVideoReviewType() == 1) {
                this.lWg.showToast(true, this.lWg.getContext().getResources().getString(R.string.video_send_success_under_review));
            } else if (daf != null && daf.getVideoReviewType() == 2) {
                this.lWg.showToast(true, this.lWg.getContext().getResources().getString(R.string.video_send_success));
            } else {
                String str2 = null;
                String str3 = null;
                String string = this.lWg.getContext().getResources().getString(R.string.send_success);
                if (this.jNG != null) {
                    str2 = this.jNG.getPreMsg();
                    str3 = this.jNG.getColorMsg();
                    string = this.jNG.getErrorString();
                }
                if (daf.getType() != 7) {
                    com.baidu.tieba.tbadkCore.writeModel.c.f(this.lWg.getContext().getActivity(), string, str2, str3);
                }
            }
            Intent intent = new Intent();
            Bundle bundle = new Bundle();
            bundle.putSerializable("post_write_callback_data", this.jNG);
            intent.putExtras(bundle);
            BaseActivity context = this.lWg.getContext();
            this.lWg.getContext();
            context.setResult(-1, intent);
            this.lWg.getContext().finish();
            return true;
        } else if (str.contains("objc:jumpToFeedback()")) {
            WriteActivityConfig writeActivityConfig = new WriteActivityConfig(this.lWg.getContext().getActivity(), 0, TbConfig.getPositionPagerId(), TbConfig.getPositionPagerName(), null, null, 0, null, RequestResponseCode.REQUEST_WRITE_NEW, true, false, null, false, false, null, null, null, 0);
            writeActivityConfig.setIsVcodeFeedBack();
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, writeActivityConfig));
            return true;
        } else {
            return false;
        }
    }

    @Override // com.baidu.tieba.write.vcode.newVcode.a.b
    public void onPageFinished(WebView webView, String str) {
        if (this.lWg != null) {
            this.lWg.showWebViewDelay(1000);
        }
    }

    @Override // com.baidu.tieba.write.vcode.newVcode.a.b
    public void B(boolean z, String str) {
    }

    @Override // com.baidu.tieba.write.vcode.newVcode.a.b
    public void start(boolean z) {
        this.lWg.setRatio(0.9433962f);
        this.lWg.showWebView(false);
        this.lWg.getWebView().loadUrl(TbConfig.SERVER_ADDRESS_WEB_VIEW + Config.DRAG_VCODE_WEBVIEW_ADDRESS);
    }

    @Override // com.baidu.tieba.write.vcode.newVcode.a.b
    public void onDestroy() {
    }

    @Override // com.baidu.tieba.write.vcode.newVcode.a.b
    public void d(NewWriteModel.d dVar) {
        this.lWh = dVar;
    }

    @Override // com.baidu.tieba.write.vcode.newVcode.a.b
    public void dmP() {
        this.lWg.showPostThreadLoadingView(false);
        this.lSm.cancelLoadData();
    }

    private void Os(String str) {
        this.lSn = false;
        if (!l.isNetOk()) {
            this.lWg.getContext().showToast(R.string.neterror);
            this.lWg.getContext().finish();
        } else if (!StringUtils.isNull(str)) {
            this.lWg.showPostThreadLoadingView(true);
            this.lSm.daf().setVcode(str);
            this.lSm.daf().setVcodeType("5");
            this.lSm.dfc();
        } else {
            this.lWg.getContext().showToast(R.string.neterror);
            this.lWg.getContext().finish();
        }
    }
}
