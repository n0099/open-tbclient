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
    private PostWriteCallBackData lVY;
    private final NewWriteModel ogh;
    private final NewVcodeView ojE;
    private NewWriteModel.d ojF;
    private boolean ogi = false;
    private final NewWriteModel.d fFv = new NewWriteModel.d() { // from class: com.baidu.tieba.write.vcode.newVcode.a.a.1
        @Override // com.baidu.tieba.tbadkCore.writeModel.NewWriteModel.d
        public void callback(boolean z, PostWriteCallBackData postWriteCallBackData, ah ahVar, WriteData writeData, AntiData antiData) {
            String str;
            String str2;
            String str3;
            if (a.this.ojE != null) {
                a.this.ojE.showPostThreadLoadingView(false);
                if (z) {
                    a.this.lVY = postWriteCallBackData;
                    a.this.ogi = true;
                    if (ahVar == null || ahVar.bwI() == null) {
                        str = null;
                        str2 = null;
                        str3 = null;
                    } else {
                        str3 = ahVar.bwI().endPoint;
                        String str4 = ahVar.bwI().successImg;
                        str = ahVar.bwI().slideEndPoint;
                        str2 = str4;
                    }
                    a.this.ojE.runJsMethod("success", str2 + "," + str3 + "," + str);
                } else if (postWriteCallBackData == null || postWriteCallBackData.getErrorCode() != 227001) {
                    if (a.this.ojF != null) {
                        a.this.ojF.callback(false, postWriteCallBackData, ahVar, writeData, antiData);
                    }
                } else {
                    a.this.ojE.getContext().setVisible(false);
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AccountAccessActivityConfig(a.this.ojE.getContext().getActivity(), RequestResponseCode.REQUEST_VCODE, writeData, postWriteCallBackData.getAccessState())));
                }
            }
        }
    };

    public a(NewVcodeView newVcodeView, NewWriteModel newWriteModel) {
        this.ojE = newVcodeView;
        this.ogh = newWriteModel;
        this.ogh.b(this.fFv);
    }

    @Override // com.baidu.tieba.write.vcode.newVcode.a.b
    public boolean c(WebView webView, String str) {
        WriteData daL;
        String str2;
        String str3;
        if (this.ogh.daL() == null || StringUtils.isNull(str) || (daL = this.ogh.daL()) == null) {
            return false;
        }
        if (str.contains("objc:loadReady")) {
            if (daL.getVcodeExtra() != null) {
                this.ojE.runJsMethod("handleFreshCaptcha", "'" + daL.getVcodeUrl() + "','" + daL.getVcodeExtra().slideImg + "','" + daL.getVcodeExtra().textImg + "'");
                return true;
            }
            return false;
        } else if (str.contains("objc:jsChangePosition")) {
            Vy(com.baidu.tbadk.t.a.Ee(str));
            return true;
        } else if (str.contains("objc:finish")) {
            this.ogi = true;
            if (daL != null && daL.getVideoReviewType() == 1) {
                this.ojE.showToast(true, this.ojE.getContext().getResources().getString(R.string.video_send_success_under_review));
            } else if (daL != null && daL.getVideoReviewType() == 2) {
                this.ojE.showToast(true, this.ojE.getContext().getResources().getString(R.string.video_send_success));
            } else {
                String string = this.ojE.getContext().getResources().getString(R.string.send_success);
                if (this.lVY != null) {
                    String preMsg = this.lVY.getPreMsg();
                    str2 = this.lVY.getColorMsg();
                    string = this.lVY.getErrorString();
                    str3 = preMsg;
                } else {
                    str2 = null;
                    str3 = null;
                }
                if (daL.getType() != 7) {
                    g.j(this.ojE.getContext().getActivity(), string, str3, str2);
                }
            }
            Intent intent = new Intent();
            Bundle bundle = new Bundle();
            bundle.putSerializable("post_write_callback_data", this.lVY);
            intent.putExtras(bundle);
            BaseActivity context = this.ojE.getContext();
            this.ojE.getContext();
            context.setResult(-1, intent);
            this.ojE.getContext().finish();
            return true;
        } else if (!str.contains("objc:jumpToFeedback()") || WriteActivityConfig.isAsyncWriting()) {
            return false;
        } else {
            WriteActivityConfig.newInstance(this.ojE.getContext()).setType(0).setForumId(TbConfig.getPositionPagerId()).setForumName(TbConfig.getPositionPagerName()).setIsVcodeFeedBack().send();
            return true;
        }
    }

    @Override // com.baidu.tieba.write.vcode.newVcode.a.b
    public void onPageFinished(WebView webView, String str) {
        if (this.ojE != null) {
            this.ojE.showWebViewDelay(1000);
        }
    }

    @Override // com.baidu.tieba.write.vcode.newVcode.a.b
    public void P(boolean z, String str) {
    }

    @Override // com.baidu.tieba.write.vcode.newVcode.a.b
    public void start(boolean z) {
        this.ojE.setRatio(0.9433962f);
        this.ojE.showWebView(false);
        this.ojE.getWebView().loadUrl(TbConfig.SERVER_ADDRESS_WEB_VIEW + Config.DRAG_VCODE_WEBVIEW_ADDRESS);
    }

    @Override // com.baidu.tieba.write.vcode.newVcode.a.b
    public void onDestroy() {
    }

    @Override // com.baidu.tieba.write.vcode.newVcode.a.b
    public void d(NewWriteModel.d dVar) {
        this.ojF = dVar;
    }

    @Override // com.baidu.tieba.write.vcode.newVcode.a.b
    public void dWW() {
        this.ojE.showPostThreadLoadingView(false);
        this.ogh.cancelLoadData();
    }

    private void Vy(String str) {
        this.ogi = false;
        if (!l.isNetOk()) {
            this.ojE.getContext().showToast(R.string.neterror);
            this.ojE.getContext().finish();
        } else if (!StringUtils.isNull(str)) {
            this.ojE.showPostThreadLoadingView(true);
            this.ogh.daL().setVcode(str);
            this.ogh.daL().setVcodeType("5");
            this.ogh.dPm();
        } else {
            this.ojE.getContext().showToast(R.string.neterror);
            this.ojE.getContext().finish();
        }
    }
}
