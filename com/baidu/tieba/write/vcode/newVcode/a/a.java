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
    private PostWriteCallBackData lTH;
    private final NewWriteModel odB;
    private final NewVcodeView ogZ;
    private NewWriteModel.d oha;
    private boolean odC = false;
    private final NewWriteModel.d fDW = new NewWriteModel.d() { // from class: com.baidu.tieba.write.vcode.newVcode.a.a.1
        @Override // com.baidu.tieba.tbadkCore.writeModel.NewWriteModel.d
        public void callback(boolean z, PostWriteCallBackData postWriteCallBackData, ah ahVar, WriteData writeData, AntiData antiData) {
            String str;
            String str2;
            String str3;
            if (a.this.ogZ != null) {
                a.this.ogZ.showPostThreadLoadingView(false);
                if (z) {
                    a.this.lTH = postWriteCallBackData;
                    a.this.odC = true;
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
                    a.this.ogZ.runJsMethod("success", str2 + "," + str3 + "," + str);
                } else if (postWriteCallBackData == null || postWriteCallBackData.getErrorCode() != 227001) {
                    if (a.this.oha != null) {
                        a.this.oha.callback(false, postWriteCallBackData, ahVar, writeData, antiData);
                    }
                } else {
                    a.this.ogZ.getContext().setVisible(false);
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AccountAccessActivityConfig(a.this.ogZ.getContext().getActivity(), RequestResponseCode.REQUEST_VCODE, writeData, postWriteCallBackData.getAccessState())));
                }
            }
        }
    };

    public a(NewVcodeView newVcodeView, NewWriteModel newWriteModel) {
        this.ogZ = newVcodeView;
        this.odB = newWriteModel;
        this.odB.b(this.fDW);
    }

    @Override // com.baidu.tieba.write.vcode.newVcode.a.b
    public boolean c(WebView webView, String str) {
        WriteData dav;
        String str2;
        String str3;
        if (this.odB.dav() == null || StringUtils.isNull(str) || (dav = this.odB.dav()) == null) {
            return false;
        }
        if (str.contains("objc:loadReady")) {
            if (dav.getVcodeExtra() != null) {
                this.ogZ.runJsMethod("handleFreshCaptcha", "'" + dav.getVcodeUrl() + "','" + dav.getVcodeExtra().slideImg + "','" + dav.getVcodeExtra().textImg + "'");
                return true;
            }
            return false;
        } else if (str.contains("objc:jsChangePosition")) {
            Vf(com.baidu.tbadk.t.a.DZ(str));
            return true;
        } else if (str.contains("objc:finish")) {
            this.odC = true;
            if (dav != null && dav.getVideoReviewType() == 1) {
                this.ogZ.showToast(true, this.ogZ.getContext().getResources().getString(R.string.video_send_success_under_review));
            } else if (dav != null && dav.getVideoReviewType() == 2) {
                this.ogZ.showToast(true, this.ogZ.getContext().getResources().getString(R.string.video_send_success));
            } else {
                String string = this.ogZ.getContext().getResources().getString(R.string.send_success);
                if (this.lTH != null) {
                    String preMsg = this.lTH.getPreMsg();
                    str2 = this.lTH.getColorMsg();
                    string = this.lTH.getErrorString();
                    str3 = preMsg;
                } else {
                    str2 = null;
                    str3 = null;
                }
                if (dav.getType() != 7) {
                    g.i(this.ogZ.getContext().getActivity(), string, str3, str2);
                }
            }
            Intent intent = new Intent();
            Bundle bundle = new Bundle();
            bundle.putSerializable("post_write_callback_data", this.lTH);
            intent.putExtras(bundle);
            BaseActivity context = this.ogZ.getContext();
            this.ogZ.getContext();
            context.setResult(-1, intent);
            this.ogZ.getContext().finish();
            return true;
        } else if (!str.contains("objc:jumpToFeedback()") || WriteActivityConfig.isAsyncWriting()) {
            return false;
        } else {
            WriteActivityConfig.newInstance(this.ogZ.getContext()).setType(0).setForumId(TbConfig.getPositionPagerId()).setForumName(TbConfig.getPositionPagerName()).setIsVcodeFeedBack().send();
            return true;
        }
    }

    @Override // com.baidu.tieba.write.vcode.newVcode.a.b
    public void onPageFinished(WebView webView, String str) {
        if (this.ogZ != null) {
            this.ogZ.showWebViewDelay(1000);
        }
    }

    @Override // com.baidu.tieba.write.vcode.newVcode.a.b
    public void P(boolean z, String str) {
    }

    @Override // com.baidu.tieba.write.vcode.newVcode.a.b
    public void start(boolean z) {
        this.ogZ.setRatio(0.9433962f);
        this.ogZ.showWebView(false);
        this.ogZ.getWebView().loadUrl(TbConfig.SERVER_ADDRESS_WEB_VIEW + Config.DRAG_VCODE_WEBVIEW_ADDRESS);
    }

    @Override // com.baidu.tieba.write.vcode.newVcode.a.b
    public void onDestroy() {
    }

    @Override // com.baidu.tieba.write.vcode.newVcode.a.b
    public void d(NewWriteModel.d dVar) {
        this.oha = dVar;
    }

    @Override // com.baidu.tieba.write.vcode.newVcode.a.b
    public void dWG() {
        this.ogZ.showPostThreadLoadingView(false);
        this.odB.cancelLoadData();
    }

    private void Vf(String str) {
        this.odC = false;
        if (!l.isNetOk()) {
            this.ogZ.getContext().showToast(R.string.neterror);
            this.ogZ.getContext().finish();
        } else if (!StringUtils.isNull(str)) {
            this.ogZ.showPostThreadLoadingView(true);
            this.odB.dav().setVcode(str);
            this.odB.dav().setVcodeType("5");
            this.odB.dOV();
        } else {
            this.ogZ.getContext().showToast(R.string.neterror);
            this.ogZ.getContext().finish();
        }
    }
}
