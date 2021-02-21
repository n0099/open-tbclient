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
/* loaded from: classes8.dex */
public class a implements b {
    private PostWriteCallBackData lTW;
    private final NewWriteModel oeb;
    private NewWriteModel.d ohA;
    private final NewVcodeView ohz;
    private boolean oec = false;
    private final NewWriteModel.d fDW = new NewWriteModel.d() { // from class: com.baidu.tieba.write.vcode.newVcode.a.a.1
        @Override // com.baidu.tieba.tbadkCore.writeModel.NewWriteModel.d
        public void callback(boolean z, PostWriteCallBackData postWriteCallBackData, ah ahVar, WriteData writeData, AntiData antiData) {
            String str;
            String str2;
            String str3;
            if (a.this.ohz != null) {
                a.this.ohz.showPostThreadLoadingView(false);
                if (z) {
                    a.this.lTW = postWriteCallBackData;
                    a.this.oec = true;
                    if (ahVar == null || ahVar.bwF() == null) {
                        str = null;
                        str2 = null;
                        str3 = null;
                    } else {
                        str3 = ahVar.bwF().endPoint;
                        String str4 = ahVar.bwF().successImg;
                        str = ahVar.bwF().slideEndPoint;
                        str2 = str4;
                    }
                    a.this.ohz.runJsMethod("success", str2 + "," + str3 + "," + str);
                } else if (postWriteCallBackData == null || postWriteCallBackData.getErrorCode() != 227001) {
                    if (a.this.ohA != null) {
                        a.this.ohA.callback(false, postWriteCallBackData, ahVar, writeData, antiData);
                    }
                } else {
                    a.this.ohz.getContext().setVisible(false);
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AccountAccessActivityConfig(a.this.ohz.getContext().getActivity(), RequestResponseCode.REQUEST_VCODE, writeData, postWriteCallBackData.getAccessState())));
                }
            }
        }
    };

    public a(NewVcodeView newVcodeView, NewWriteModel newWriteModel) {
        this.ohz = newVcodeView;
        this.oeb = newWriteModel;
        this.oeb.b(this.fDW);
    }

    @Override // com.baidu.tieba.write.vcode.newVcode.a.b
    public boolean c(WebView webView, String str) {
        WriteData daC;
        String str2;
        String str3;
        if (this.oeb.daC() == null || StringUtils.isNull(str) || (daC = this.oeb.daC()) == null) {
            return false;
        }
        if (str.contains("objc:loadReady")) {
            if (daC.getVcodeExtra() != null) {
                this.ohz.runJsMethod("handleFreshCaptcha", "'" + daC.getVcodeUrl() + "','" + daC.getVcodeExtra().slideImg + "','" + daC.getVcodeExtra().textImg + "'");
                return true;
            }
            return false;
        } else if (str.contains("objc:jsChangePosition")) {
            Vr(com.baidu.tbadk.t.a.DX(str));
            return true;
        } else if (str.contains("objc:finish")) {
            this.oec = true;
            if (daC != null && daC.getVideoReviewType() == 1) {
                this.ohz.showToast(true, this.ohz.getContext().getResources().getString(R.string.video_send_success_under_review));
            } else if (daC != null && daC.getVideoReviewType() == 2) {
                this.ohz.showToast(true, this.ohz.getContext().getResources().getString(R.string.video_send_success));
            } else {
                String string = this.ohz.getContext().getResources().getString(R.string.send_success);
                if (this.lTW != null) {
                    String preMsg = this.lTW.getPreMsg();
                    str2 = this.lTW.getColorMsg();
                    string = this.lTW.getErrorString();
                    str3 = preMsg;
                } else {
                    str2 = null;
                    str3 = null;
                }
                if (daC.getType() != 7) {
                    g.j(this.ohz.getContext().getActivity(), string, str3, str2);
                }
            }
            Intent intent = new Intent();
            Bundle bundle = new Bundle();
            bundle.putSerializable("post_write_callback_data", this.lTW);
            intent.putExtras(bundle);
            BaseActivity context = this.ohz.getContext();
            this.ohz.getContext();
            context.setResult(-1, intent);
            this.ohz.getContext().finish();
            return true;
        } else if (!str.contains("objc:jumpToFeedback()") || WriteActivityConfig.isAsyncWriting()) {
            return false;
        } else {
            WriteActivityConfig.newInstance(this.ohz.getContext()).setType(0).setForumId(TbConfig.getPositionPagerId()).setForumName(TbConfig.getPositionPagerName()).setIsVcodeFeedBack().send();
            return true;
        }
    }

    @Override // com.baidu.tieba.write.vcode.newVcode.a.b
    public void onPageFinished(WebView webView, String str) {
        if (this.ohz != null) {
            this.ohz.showWebViewDelay(1000);
        }
    }

    @Override // com.baidu.tieba.write.vcode.newVcode.a.b
    public void P(boolean z, String str) {
    }

    @Override // com.baidu.tieba.write.vcode.newVcode.a.b
    public void start(boolean z) {
        this.ohz.setRatio(0.9433962f);
        this.ohz.showWebView(false);
        this.ohz.getWebView().loadUrl(TbConfig.SERVER_ADDRESS_WEB_VIEW + Config.DRAG_VCODE_WEBVIEW_ADDRESS);
    }

    @Override // com.baidu.tieba.write.vcode.newVcode.a.b
    public void onDestroy() {
    }

    @Override // com.baidu.tieba.write.vcode.newVcode.a.b
    public void d(NewWriteModel.d dVar) {
        this.ohA = dVar;
    }

    @Override // com.baidu.tieba.write.vcode.newVcode.a.b
    public void dWO() {
        this.ohz.showPostThreadLoadingView(false);
        this.oeb.cancelLoadData();
    }

    private void Vr(String str) {
        this.oec = false;
        if (!l.isNetOk()) {
            this.ohz.getContext().showToast(R.string.neterror);
            this.ohz.getContext().finish();
        } else if (!StringUtils.isNull(str)) {
            this.ohz.showPostThreadLoadingView(true);
            this.oeb.daC().setVcode(str);
            this.oeb.daC().setVcodeType("5");
            this.oeb.dPd();
        } else {
            this.ohz.getContext().showToast(R.string.neterror);
            this.ohz.getContext().finish();
        }
    }
}
