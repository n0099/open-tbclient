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
import com.baidu.tbadk.coreExtra.data.ah;
import com.baidu.tieba.R;
import com.baidu.tieba.tbadkCore.writeModel.NewWriteModel;
import com.baidu.tieba.tbadkCore.writeModel.PostWriteCallBackData;
import com.baidu.tieba.write.vcode.newVcode.NewVcodeView;
import com.xiaomi.mipush.sdk.Constants;
/* loaded from: classes3.dex */
public class a implements b {
    private PostWriteCallBackData ldw;
    private final NewWriteModel nmB;
    private final NewVcodeView nqD;
    private NewWriteModel.d nqE;
    private boolean nmC = false;
    private final NewWriteModel.d fbF = new NewWriteModel.d() { // from class: com.baidu.tieba.write.vcode.newVcode.a.a.1
        @Override // com.baidu.tieba.tbadkCore.writeModel.NewWriteModel.d
        public void callback(boolean z, PostWriteCallBackData postWriteCallBackData, ah ahVar, WriteData writeData, AntiData antiData) {
            String str;
            String str2;
            String str3 = null;
            if (a.this.nqD != null) {
                a.this.nqD.showPostThreadLoadingView(false);
                if (z) {
                    a.this.ldw = postWriteCallBackData;
                    a.this.nmC = true;
                    if (ahVar == null || ahVar.bqD() == null) {
                        str = null;
                        str2 = null;
                    } else {
                        str2 = ahVar.bqD().endPoint;
                        str = ahVar.bqD().successImg;
                        str3 = ahVar.bqD().slideEndPoint;
                    }
                    a.this.nqD.runJsMethod("success", str + Constants.ACCEPT_TIME_SEPARATOR_SP + str2 + Constants.ACCEPT_TIME_SEPARATOR_SP + str3);
                } else if (postWriteCallBackData == null || postWriteCallBackData.getErrorCode() != 227001) {
                    if (a.this.nqE != null) {
                        a.this.nqE.callback(false, postWriteCallBackData, ahVar, writeData, antiData);
                    }
                } else {
                    a.this.nqD.getContext().setVisible(false);
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AccountAccessActivityConfig(a.this.nqD.getContext().getActivity(), RequestResponseCode.REQUEST_VCODE, writeData, postWriteCallBackData.getAccessState())));
                }
            }
        }
    };

    public a(NewVcodeView newVcodeView, NewWriteModel newWriteModel) {
        this.nqD = newVcodeView;
        this.nmB = newWriteModel;
        this.nmB.b(this.fbF);
    }

    @Override // com.baidu.tieba.write.vcode.newVcode.a.b
    public boolean b(WebView webView, String str) {
        WriteData cSo;
        if (this.nmB.cSo() == null || StringUtils.isNull(str) || (cSo = this.nmB.cSo()) == null) {
            return false;
        }
        if (str.contains("objc:loadReady")) {
            if (cSo.getVcodeExtra() == null) {
                return false;
            }
            this.nqD.runJsMethod("handleFreshCaptcha", "'" + cSo.getVcodeUrl() + "','" + cSo.getVcodeExtra().slideImg + "','" + cSo.getVcodeExtra().textImg + "'");
            return true;
        } else if (str.contains("objc:jsChangePosition")) {
            TX(com.baidu.tbadk.t.a.DW(str));
            return true;
        } else if (str.contains("objc:finish")) {
            this.nmC = true;
            if (cSo != null && cSo.getVideoReviewType() == 1) {
                this.nqD.showToast(true, this.nqD.getContext().getResources().getString(R.string.video_send_success_under_review));
            } else if (cSo != null && cSo.getVideoReviewType() == 2) {
                this.nqD.showToast(true, this.nqD.getContext().getResources().getString(R.string.video_send_success));
            } else {
                String str2 = null;
                String str3 = null;
                String string = this.nqD.getContext().getResources().getString(R.string.send_success);
                if (this.ldw != null) {
                    str2 = this.ldw.getPreMsg();
                    str3 = this.ldw.getColorMsg();
                    string = this.ldw.getErrorString();
                }
                if (cSo.getType() != 7) {
                    com.baidu.tieba.tbadkCore.writeModel.c.g(this.nqD.getContext().getActivity(), string, str2, str3);
                }
            }
            Intent intent = new Intent();
            Bundle bundle = new Bundle();
            bundle.putSerializable("post_write_callback_data", this.ldw);
            intent.putExtras(bundle);
            BaseActivity context = this.nqD.getContext();
            this.nqD.getContext();
            context.setResult(-1, intent);
            this.nqD.getContext().finish();
            return true;
        } else if (str.contains("objc:jumpToFeedback()")) {
            WriteActivityConfig writeActivityConfig = new WriteActivityConfig(this.nqD.getContext().getActivity(), 0, TbConfig.getPositionPagerId(), TbConfig.getPositionPagerName(), null, null, 0, null, RequestResponseCode.REQUEST_WRITE_NEW, true, false, null, false, false, null, null, null, 0);
            writeActivityConfig.setIsVcodeFeedBack();
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, writeActivityConfig));
            return true;
        } else {
            return false;
        }
    }

    @Override // com.baidu.tieba.write.vcode.newVcode.a.b
    public void onPageFinished(WebView webView, String str) {
        if (this.nqD != null) {
            this.nqD.showWebViewDelay(1000);
        }
    }

    @Override // com.baidu.tieba.write.vcode.newVcode.a.b
    public void E(boolean z, String str) {
    }

    @Override // com.baidu.tieba.write.vcode.newVcode.a.b
    public void start(boolean z) {
        this.nqD.setRatio(0.9433962f);
        this.nqD.showWebView(false);
        this.nqD.getWebView().loadUrl(TbConfig.SERVER_ADDRESS_WEB_VIEW + Config.DRAG_VCODE_WEBVIEW_ADDRESS);
    }

    @Override // com.baidu.tieba.write.vcode.newVcode.a.b
    public void onDestroy() {
    }

    @Override // com.baidu.tieba.write.vcode.newVcode.a.b
    public void d(NewWriteModel.d dVar) {
        this.nqE = dVar;
    }

    @Override // com.baidu.tieba.write.vcode.newVcode.a.b
    public void dND() {
        this.nqD.showPostThreadLoadingView(false);
        this.nmB.cancelLoadData();
    }

    private void TX(String str) {
        this.nmC = false;
        if (!l.isNetOk()) {
            this.nqD.getContext().showToast(R.string.neterror);
            this.nqD.getContext().finish();
        } else if (!StringUtils.isNull(str)) {
            this.nqD.showPostThreadLoadingView(true);
            this.nmB.cSo().setVcode(str);
            this.nmB.cSo().setVcodeType("5");
            this.nmB.dFC();
        } else {
            this.nqD.getContext().showToast(R.string.neterror);
            this.nqD.getContext().finish();
        }
    }
}
