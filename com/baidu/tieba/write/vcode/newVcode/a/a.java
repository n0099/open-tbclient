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
import com.baidu.tbadk.coreExtra.data.ag;
import com.baidu.tieba.R;
import com.baidu.tieba.tbadkCore.writeModel.NewWriteModel;
import com.baidu.tieba.tbadkCore.writeModel.PostWriteCallBackData;
import com.baidu.tieba.write.vcode.newVcode.NewVcodeView;
import com.xiaomi.mipush.sdk.Constants;
/* loaded from: classes3.dex */
public class a implements b {
    private PostWriteCallBackData kFL;
    private final NewWriteModel mNg;
    private final NewVcodeView mRm;
    private NewWriteModel.d mRn;
    private boolean mNh = false;
    private final NewWriteModel.d eMH = new NewWriteModel.d() { // from class: com.baidu.tieba.write.vcode.newVcode.a.a.1
        @Override // com.baidu.tieba.tbadkCore.writeModel.NewWriteModel.d
        public void callback(boolean z, PostWriteCallBackData postWriteCallBackData, ag agVar, WriteData writeData, AntiData antiData) {
            String str;
            String str2;
            String str3 = null;
            if (a.this.mRm != null) {
                a.this.mRm.showPostThreadLoadingView(false);
                if (z) {
                    a.this.kFL = postWriteCallBackData;
                    a.this.mNh = true;
                    if (agVar == null || agVar.bmZ() == null) {
                        str = null;
                        str2 = null;
                    } else {
                        str2 = agVar.bmZ().endPoint;
                        str = agVar.bmZ().successImg;
                        str3 = agVar.bmZ().slideEndPoint;
                    }
                    a.this.mRm.runJsMethod("success", str + Constants.ACCEPT_TIME_SEPARATOR_SP + str2 + Constants.ACCEPT_TIME_SEPARATOR_SP + str3);
                } else if (postWriteCallBackData == null || postWriteCallBackData.getErrorCode() != 227001) {
                    if (a.this.mRn != null) {
                        a.this.mRn.callback(false, postWriteCallBackData, agVar, writeData, antiData);
                    }
                } else {
                    a.this.mRm.getContext().setVisible(false);
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AccountAccessActivityConfig(a.this.mRm.getContext().getActivity(), RequestResponseCode.REQUEST_VCODE, writeData, postWriteCallBackData.getAccessState())));
                }
            }
        }
    };

    public a(NewVcodeView newVcodeView, NewWriteModel newWriteModel) {
        this.mRm = newVcodeView;
        this.mNg = newWriteModel;
        this.mNg.b(this.eMH);
    }

    @Override // com.baidu.tieba.write.vcode.newVcode.a.b
    public boolean b(WebView webView, String str) {
        WriteData cLa;
        if (this.mNg.cLa() == null || StringUtils.isNull(str) || (cLa = this.mNg.cLa()) == null) {
            return false;
        }
        if (str.contains("objc:loadReady")) {
            if (cLa.getVcodeExtra() == null) {
                return false;
            }
            this.mRm.runJsMethod("handleFreshCaptcha", "'" + cLa.getVcodeUrl() + "','" + cLa.getVcodeExtra().slideImg + "','" + cLa.getVcodeExtra().textImg + "'");
            return true;
        } else if (str.contains("objc:jsChangePosition")) {
            SJ(com.baidu.tbadk.t.a.CO(str));
            return true;
        } else if (str.contains("objc:finish")) {
            this.mNh = true;
            if (cLa != null && cLa.getVideoReviewType() == 1) {
                this.mRm.showToast(true, this.mRm.getContext().getResources().getString(R.string.video_send_success_under_review));
            } else if (cLa != null && cLa.getVideoReviewType() == 2) {
                this.mRm.showToast(true, this.mRm.getContext().getResources().getString(R.string.video_send_success));
            } else {
                String str2 = null;
                String str3 = null;
                String string = this.mRm.getContext().getResources().getString(R.string.send_success);
                if (this.kFL != null) {
                    str2 = this.kFL.getPreMsg();
                    str3 = this.kFL.getColorMsg();
                    string = this.kFL.getErrorString();
                }
                if (cLa.getType() != 7) {
                    com.baidu.tieba.tbadkCore.writeModel.c.g(this.mRm.getContext().getActivity(), string, str2, str3);
                }
            }
            Intent intent = new Intent();
            Bundle bundle = new Bundle();
            bundle.putSerializable("post_write_callback_data", this.kFL);
            intent.putExtras(bundle);
            BaseActivity context = this.mRm.getContext();
            this.mRm.getContext();
            context.setResult(-1, intent);
            this.mRm.getContext().finish();
            return true;
        } else if (str.contains("objc:jumpToFeedback()")) {
            WriteActivityConfig writeActivityConfig = new WriteActivityConfig(this.mRm.getContext().getActivity(), 0, TbConfig.getPositionPagerId(), TbConfig.getPositionPagerName(), null, null, 0, null, RequestResponseCode.REQUEST_WRITE_NEW, true, false, null, false, false, null, null, null, 0);
            writeActivityConfig.setIsVcodeFeedBack();
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, writeActivityConfig));
            return true;
        } else {
            return false;
        }
    }

    @Override // com.baidu.tieba.write.vcode.newVcode.a.b
    public void onPageFinished(WebView webView, String str) {
        if (this.mRm != null) {
            this.mRm.showWebViewDelay(1000);
        }
    }

    @Override // com.baidu.tieba.write.vcode.newVcode.a.b
    public void E(boolean z, String str) {
    }

    @Override // com.baidu.tieba.write.vcode.newVcode.a.b
    public void start(boolean z) {
        this.mRm.setRatio(0.9433962f);
        this.mRm.showWebView(false);
        this.mRm.getWebView().loadUrl(TbConfig.SERVER_ADDRESS_WEB_VIEW + Config.DRAG_VCODE_WEBVIEW_ADDRESS);
    }

    @Override // com.baidu.tieba.write.vcode.newVcode.a.b
    public void onDestroy() {
    }

    @Override // com.baidu.tieba.write.vcode.newVcode.a.b
    public void d(NewWriteModel.d dVar) {
        this.mRn = dVar;
    }

    @Override // com.baidu.tieba.write.vcode.newVcode.a.b
    public void dFX() {
        this.mRm.showPostThreadLoadingView(false);
        this.mNg.cancelLoadData();
    }

    private void SJ(String str) {
        this.mNh = false;
        if (!l.isNetOk()) {
            this.mRm.getContext().showToast(R.string.neterror);
            this.mRm.getContext().finish();
        } else if (!StringUtils.isNull(str)) {
            this.mRm.showPostThreadLoadingView(true);
            this.mNg.cLa().setVcode(str);
            this.mNg.cLa().setVcodeType("5");
            this.mNg.dxX();
        } else {
            this.mRm.getContext().showToast(R.string.neterror);
            this.mRm.getContext().finish();
        }
    }
}
