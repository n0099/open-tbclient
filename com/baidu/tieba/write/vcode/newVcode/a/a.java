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
    private PostWriteCallBackData lPp;
    private final NewWriteModel nXZ;
    private final NewVcodeView oby;
    private NewWriteModel.d obz;
    private boolean nYa = false;
    private final NewWriteModel.d fGo = new NewWriteModel.d() { // from class: com.baidu.tieba.write.vcode.newVcode.a.a.1
        @Override // com.baidu.tieba.tbadkCore.writeModel.NewWriteModel.d
        public void callback(boolean z, PostWriteCallBackData postWriteCallBackData, ah ahVar, WriteData writeData, AntiData antiData) {
            String str;
            String str2;
            String str3;
            if (a.this.oby != null) {
                a.this.oby.showPostThreadLoadingView(false);
                if (z) {
                    a.this.lPp = postWriteCallBackData;
                    a.this.nYa = true;
                    if (ahVar == null || ahVar.bAh() == null) {
                        str = null;
                        str2 = null;
                        str3 = null;
                    } else {
                        str3 = ahVar.bAh().endPoint;
                        String str4 = ahVar.bAh().successImg;
                        str = ahVar.bAh().slideEndPoint;
                        str2 = str4;
                    }
                    a.this.oby.runJsMethod("success", str2 + "," + str3 + "," + str);
                } else if (postWriteCallBackData == null || postWriteCallBackData.getErrorCode() != 227001) {
                    if (a.this.obz != null) {
                        a.this.obz.callback(false, postWriteCallBackData, ahVar, writeData, antiData);
                    }
                } else {
                    a.this.oby.getContext().setVisible(false);
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AccountAccessActivityConfig(a.this.oby.getContext().getActivity(), RequestResponseCode.REQUEST_VCODE, writeData, postWriteCallBackData.getAccessState())));
                }
            }
        }
    };

    public a(NewVcodeView newVcodeView, NewWriteModel newWriteModel) {
        this.oby = newVcodeView;
        this.nXZ = newWriteModel;
        this.nXZ.b(this.fGo);
    }

    @Override // com.baidu.tieba.write.vcode.newVcode.a.b
    public boolean c(WebView webView, String str) {
        WriteData dcp;
        String str2;
        String str3;
        if (this.nXZ.dcp() == null || StringUtils.isNull(str) || (dcp = this.nXZ.dcp()) == null) {
            return false;
        }
        if (str.contains("objc:loadReady")) {
            if (dcp.getVcodeExtra() != null) {
                this.oby.runJsMethod("handleFreshCaptcha", "'" + dcp.getVcodeUrl() + "','" + dcp.getVcodeExtra().slideImg + "','" + dcp.getVcodeExtra().textImg + "'");
                return true;
            }
            return false;
        } else if (str.contains("objc:jsChangePosition")) {
            Vo(com.baidu.tbadk.t.a.EO(str));
            return true;
        } else if (str.contains("objc:finish")) {
            this.nYa = true;
            if (dcp != null && dcp.getVideoReviewType() == 1) {
                this.oby.showToast(true, this.oby.getContext().getResources().getString(R.string.video_send_success_under_review));
            } else if (dcp != null && dcp.getVideoReviewType() == 2) {
                this.oby.showToast(true, this.oby.getContext().getResources().getString(R.string.video_send_success));
            } else {
                String string = this.oby.getContext().getResources().getString(R.string.send_success);
                if (this.lPp != null) {
                    String preMsg = this.lPp.getPreMsg();
                    str2 = this.lPp.getColorMsg();
                    string = this.lPp.getErrorString();
                    str3 = preMsg;
                } else {
                    str2 = null;
                    str3 = null;
                }
                if (dcp.getType() != 7) {
                    g.i(this.oby.getContext().getActivity(), string, str3, str2);
                }
            }
            Intent intent = new Intent();
            Bundle bundle = new Bundle();
            bundle.putSerializable("post_write_callback_data", this.lPp);
            intent.putExtras(bundle);
            BaseActivity context = this.oby.getContext();
            this.oby.getContext();
            context.setResult(-1, intent);
            this.oby.getContext().finish();
            return true;
        } else if (!str.contains("objc:jumpToFeedback()") || WriteActivityConfig.isAsyncWriting()) {
            return false;
        } else {
            WriteActivityConfig.newInstance(this.oby.getContext()).setType(0).setForumId(TbConfig.getPositionPagerId()).setForumName(TbConfig.getPositionPagerName()).setIsVcodeFeedBack().send();
            return true;
        }
    }

    @Override // com.baidu.tieba.write.vcode.newVcode.a.b
    public void onPageFinished(WebView webView, String str) {
        if (this.oby != null) {
            this.oby.showWebViewDelay(1000);
        }
    }

    @Override // com.baidu.tieba.write.vcode.newVcode.a.b
    public void H(boolean z, String str) {
    }

    @Override // com.baidu.tieba.write.vcode.newVcode.a.b
    public void start(boolean z) {
        this.oby.setRatio(0.9433962f);
        this.oby.showWebView(false);
        this.oby.getWebView().loadUrl(TbConfig.SERVER_ADDRESS_WEB_VIEW + Config.DRAG_VCODE_WEBVIEW_ADDRESS);
    }

    @Override // com.baidu.tieba.write.vcode.newVcode.a.b
    public void onDestroy() {
    }

    @Override // com.baidu.tieba.write.vcode.newVcode.a.b
    public void d(NewWriteModel.d dVar) {
        this.obz = dVar;
    }

    @Override // com.baidu.tieba.write.vcode.newVcode.a.b
    public void dYk() {
        this.oby.showPostThreadLoadingView(false);
        this.nXZ.cancelLoadData();
    }

    private void Vo(String str) {
        this.nYa = false;
        if (!l.isNetOk()) {
            this.oby.getContext().showToast(R.string.neterror);
            this.oby.getContext().finish();
        } else if (!StringUtils.isNull(str)) {
            this.oby.showPostThreadLoadingView(true);
            this.nXZ.dcp().setVcode(str);
            this.nXZ.dcp().setVcodeType("5");
            this.nXZ.dQC();
        } else {
            this.oby.getContext().showToast(R.string.neterror);
            this.oby.getContext().finish();
        }
    }
}
