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
import com.baidu.tieba.tbadkCore.writeModel.g;
import com.baidu.tieba.write.vcode.newVcode.NewVcodeView;
/* loaded from: classes7.dex */
public class a implements b {
    private PostWriteCallBackData lKL;
    private final NewWriteModel nTv;
    private final NewVcodeView nWT;
    private NewWriteModel.d nWU;
    private boolean nTw = false;
    private final NewWriteModel.d fBH = new NewWriteModel.d() { // from class: com.baidu.tieba.write.vcode.newVcode.a.a.1
        @Override // com.baidu.tieba.tbadkCore.writeModel.NewWriteModel.d
        public void callback(boolean z, PostWriteCallBackData postWriteCallBackData, ah ahVar, WriteData writeData, AntiData antiData) {
            String str;
            String str2;
            String str3;
            if (a.this.nWT != null) {
                a.this.nWT.showPostThreadLoadingView(false);
                if (z) {
                    a.this.lKL = postWriteCallBackData;
                    a.this.nTw = true;
                    if (ahVar == null || ahVar.bwn() == null) {
                        str = null;
                        str2 = null;
                        str3 = null;
                    } else {
                        str3 = ahVar.bwn().endPoint;
                        String str4 = ahVar.bwn().successImg;
                        str = ahVar.bwn().slideEndPoint;
                        str2 = str4;
                    }
                    a.this.nWT.runJsMethod("success", str2 + "," + str3 + "," + str);
                } else if (postWriteCallBackData == null || postWriteCallBackData.getErrorCode() != 227001) {
                    if (a.this.nWU != null) {
                        a.this.nWU.callback(false, postWriteCallBackData, ahVar, writeData, antiData);
                    }
                } else {
                    a.this.nWT.getContext().setVisible(false);
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AccountAccessActivityConfig(a.this.nWT.getContext().getActivity(), RequestResponseCode.REQUEST_VCODE, writeData, postWriteCallBackData.getAccessState())));
                }
            }
        }
    };

    public a(NewVcodeView newVcodeView, NewWriteModel newWriteModel) {
        this.nWT = newVcodeView;
        this.nTv = newWriteModel;
        this.nTv.b(this.fBH);
    }

    @Override // com.baidu.tieba.write.vcode.newVcode.a.b
    public boolean c(WebView webView, String str) {
        WriteData cYx;
        String str2;
        String str3;
        if (this.nTv.cYx() == null || StringUtils.isNull(str) || (cYx = this.nTv.cYx()) == null) {
            return false;
        }
        if (str.contains("objc:loadReady")) {
            if (cYx.getVcodeExtra() != null) {
                this.nWT.runJsMethod("handleFreshCaptcha", "'" + cYx.getVcodeUrl() + "','" + cYx.getVcodeExtra().slideImg + "','" + cYx.getVcodeExtra().textImg + "'");
                return true;
            }
            return false;
        } else if (str.contains("objc:jsChangePosition")) {
            Uh(com.baidu.tbadk.t.a.DD(str));
            return true;
        } else if (str.contains("objc:finish")) {
            this.nTw = true;
            if (cYx != null && cYx.getVideoReviewType() == 1) {
                this.nWT.showToast(true, this.nWT.getContext().getResources().getString(R.string.video_send_success_under_review));
            } else if (cYx != null && cYx.getVideoReviewType() == 2) {
                this.nWT.showToast(true, this.nWT.getContext().getResources().getString(R.string.video_send_success));
            } else {
                String string = this.nWT.getContext().getResources().getString(R.string.send_success);
                if (this.lKL != null) {
                    String preMsg = this.lKL.getPreMsg();
                    str2 = this.lKL.getColorMsg();
                    string = this.lKL.getErrorString();
                    str3 = preMsg;
                } else {
                    str2 = null;
                    str3 = null;
                }
                if (cYx.getType() != 7) {
                    g.i(this.nWT.getContext().getActivity(), string, str3, str2);
                }
            }
            Intent intent = new Intent();
            Bundle bundle = new Bundle();
            bundle.putSerializable("post_write_callback_data", this.lKL);
            intent.putExtras(bundle);
            BaseActivity context = this.nWT.getContext();
            this.nWT.getContext();
            context.setResult(-1, intent);
            this.nWT.getContext().finish();
            return true;
        } else if (!str.contains("objc:jumpToFeedback()") || WriteActivityConfig.isAsyncWriting()) {
            return false;
        } else {
            WriteActivityConfig.newInstance(this.nWT.getContext()).setType(0).setForumId(TbConfig.getPositionPagerId()).setForumName(TbConfig.getPositionPagerName()).setIsVcodeFeedBack().send();
            return true;
        }
    }

    @Override // com.baidu.tieba.write.vcode.newVcode.a.b
    public void onPageFinished(WebView webView, String str) {
        if (this.nWT != null) {
            this.nWT.showWebViewDelay(1000);
        }
    }

    @Override // com.baidu.tieba.write.vcode.newVcode.a.b
    public void H(boolean z, String str) {
    }

    @Override // com.baidu.tieba.write.vcode.newVcode.a.b
    public void start(boolean z) {
        this.nWT.setRatio(0.9433962f);
        this.nWT.showWebView(false);
        this.nWT.getWebView().loadUrl(TbConfig.SERVER_ADDRESS_WEB_VIEW + Config.DRAG_VCODE_WEBVIEW_ADDRESS);
    }

    @Override // com.baidu.tieba.write.vcode.newVcode.a.b
    public void onDestroy() {
    }

    @Override // com.baidu.tieba.write.vcode.newVcode.a.b
    public void d(NewWriteModel.d dVar) {
        this.nWU = dVar;
    }

    @Override // com.baidu.tieba.write.vcode.newVcode.a.b
    public void dUs() {
        this.nWT.showPostThreadLoadingView(false);
        this.nTv.cancelLoadData();
    }

    private void Uh(String str) {
        this.nTw = false;
        if (!l.isNetOk()) {
            this.nWT.getContext().showToast(R.string.neterror);
            this.nWT.getContext().finish();
        } else if (!StringUtils.isNull(str)) {
            this.nWT.showPostThreadLoadingView(true);
            this.nTv.cYx().setVcode(str);
            this.nTv.cYx().setVcodeType("5");
            this.nTv.dMK();
        } else {
            this.nWT.getContext().showToast(R.string.neterror);
            this.nWT.getContext().finish();
        }
    }
}
