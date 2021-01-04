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
    private PostWriteCallBackData lPq;
    private final NewWriteModel nYa;
    private NewWriteModel.d obA;
    private final NewVcodeView obz;
    private boolean nYb = false;
    private final NewWriteModel.d fGo = new NewWriteModel.d() { // from class: com.baidu.tieba.write.vcode.newVcode.a.a.1
        @Override // com.baidu.tieba.tbadkCore.writeModel.NewWriteModel.d
        public void callback(boolean z, PostWriteCallBackData postWriteCallBackData, ah ahVar, WriteData writeData, AntiData antiData) {
            String str;
            String str2;
            String str3;
            if (a.this.obz != null) {
                a.this.obz.showPostThreadLoadingView(false);
                if (z) {
                    a.this.lPq = postWriteCallBackData;
                    a.this.nYb = true;
                    if (ahVar == null || ahVar.bAg() == null) {
                        str = null;
                        str2 = null;
                        str3 = null;
                    } else {
                        str3 = ahVar.bAg().endPoint;
                        String str4 = ahVar.bAg().successImg;
                        str = ahVar.bAg().slideEndPoint;
                        str2 = str4;
                    }
                    a.this.obz.runJsMethod("success", str2 + "," + str3 + "," + str);
                } else if (postWriteCallBackData == null || postWriteCallBackData.getErrorCode() != 227001) {
                    if (a.this.obA != null) {
                        a.this.obA.callback(false, postWriteCallBackData, ahVar, writeData, antiData);
                    }
                } else {
                    a.this.obz.getContext().setVisible(false);
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AccountAccessActivityConfig(a.this.obz.getContext().getActivity(), RequestResponseCode.REQUEST_VCODE, writeData, postWriteCallBackData.getAccessState())));
                }
            }
        }
    };

    public a(NewVcodeView newVcodeView, NewWriteModel newWriteModel) {
        this.obz = newVcodeView;
        this.nYa = newWriteModel;
        this.nYa.b(this.fGo);
    }

    @Override // com.baidu.tieba.write.vcode.newVcode.a.b
    public boolean c(WebView webView, String str) {
        WriteData dco;
        String str2;
        String str3;
        if (this.nYa.dco() == null || StringUtils.isNull(str) || (dco = this.nYa.dco()) == null) {
            return false;
        }
        if (str.contains("objc:loadReady")) {
            if (dco.getVcodeExtra() != null) {
                this.obz.runJsMethod("handleFreshCaptcha", "'" + dco.getVcodeUrl() + "','" + dco.getVcodeExtra().slideImg + "','" + dco.getVcodeExtra().textImg + "'");
                return true;
            }
            return false;
        } else if (str.contains("objc:jsChangePosition")) {
            Vp(com.baidu.tbadk.t.a.EP(str));
            return true;
        } else if (str.contains("objc:finish")) {
            this.nYb = true;
            if (dco != null && dco.getVideoReviewType() == 1) {
                this.obz.showToast(true, this.obz.getContext().getResources().getString(R.string.video_send_success_under_review));
            } else if (dco != null && dco.getVideoReviewType() == 2) {
                this.obz.showToast(true, this.obz.getContext().getResources().getString(R.string.video_send_success));
            } else {
                String string = this.obz.getContext().getResources().getString(R.string.send_success);
                if (this.lPq != null) {
                    String preMsg = this.lPq.getPreMsg();
                    str2 = this.lPq.getColorMsg();
                    string = this.lPq.getErrorString();
                    str3 = preMsg;
                } else {
                    str2 = null;
                    str3 = null;
                }
                if (dco.getType() != 7) {
                    g.i(this.obz.getContext().getActivity(), string, str3, str2);
                }
            }
            Intent intent = new Intent();
            Bundle bundle = new Bundle();
            bundle.putSerializable("post_write_callback_data", this.lPq);
            intent.putExtras(bundle);
            BaseActivity context = this.obz.getContext();
            this.obz.getContext();
            context.setResult(-1, intent);
            this.obz.getContext().finish();
            return true;
        } else if (!str.contains("objc:jumpToFeedback()") || WriteActivityConfig.isAsyncWriting()) {
            return false;
        } else {
            WriteActivityConfig.newInstance(this.obz.getContext()).setType(0).setForumId(TbConfig.getPositionPagerId()).setForumName(TbConfig.getPositionPagerName()).setIsVcodeFeedBack().send();
            return true;
        }
    }

    @Override // com.baidu.tieba.write.vcode.newVcode.a.b
    public void onPageFinished(WebView webView, String str) {
        if (this.obz != null) {
            this.obz.showWebViewDelay(1000);
        }
    }

    @Override // com.baidu.tieba.write.vcode.newVcode.a.b
    public void H(boolean z, String str) {
    }

    @Override // com.baidu.tieba.write.vcode.newVcode.a.b
    public void start(boolean z) {
        this.obz.setRatio(0.9433962f);
        this.obz.showWebView(false);
        this.obz.getWebView().loadUrl(TbConfig.SERVER_ADDRESS_WEB_VIEW + Config.DRAG_VCODE_WEBVIEW_ADDRESS);
    }

    @Override // com.baidu.tieba.write.vcode.newVcode.a.b
    public void onDestroy() {
    }

    @Override // com.baidu.tieba.write.vcode.newVcode.a.b
    public void d(NewWriteModel.d dVar) {
        this.obA = dVar;
    }

    @Override // com.baidu.tieba.write.vcode.newVcode.a.b
    public void dYj() {
        this.obz.showPostThreadLoadingView(false);
        this.nYa.cancelLoadData();
    }

    private void Vp(String str) {
        this.nYb = false;
        if (!l.isNetOk()) {
            this.obz.getContext().showToast(R.string.neterror);
            this.obz.getContext().finish();
        } else if (!StringUtils.isNull(str)) {
            this.obz.showPostThreadLoadingView(true);
            this.nYa.dco().setVcode(str);
            this.nYa.dco().setVcodeType("5");
            this.nYa.dQB();
        } else {
            this.obz.getContext().showToast(R.string.neterror);
            this.obz.getContext().finish();
        }
    }
}
