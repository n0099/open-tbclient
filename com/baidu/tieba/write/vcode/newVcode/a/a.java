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
    private PostWriteCallBackData kFE;
    private final NewWriteModel mMO;
    private final NewVcodeView mQT;
    private NewWriteModel.d mQU;
    private boolean mMP = false;
    private final NewWriteModel.d eMD = new NewWriteModel.d() { // from class: com.baidu.tieba.write.vcode.newVcode.a.a.1
        @Override // com.baidu.tieba.tbadkCore.writeModel.NewWriteModel.d
        public void callback(boolean z, PostWriteCallBackData postWriteCallBackData, ag agVar, WriteData writeData, AntiData antiData) {
            String str;
            String str2;
            String str3 = null;
            if (a.this.mQT != null) {
                a.this.mQT.showPostThreadLoadingView(false);
                if (z) {
                    a.this.kFE = postWriteCallBackData;
                    a.this.mMP = true;
                    if (agVar == null || agVar.bmZ() == null) {
                        str = null;
                        str2 = null;
                    } else {
                        str2 = agVar.bmZ().endPoint;
                        str = agVar.bmZ().successImg;
                        str3 = agVar.bmZ().slideEndPoint;
                    }
                    a.this.mQT.runJsMethod("success", str + Constants.ACCEPT_TIME_SEPARATOR_SP + str2 + Constants.ACCEPT_TIME_SEPARATOR_SP + str3);
                } else if (postWriteCallBackData == null || postWriteCallBackData.getErrorCode() != 227001) {
                    if (a.this.mQU != null) {
                        a.this.mQU.callback(false, postWriteCallBackData, agVar, writeData, antiData);
                    }
                } else {
                    a.this.mQT.getContext().setVisible(false);
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AccountAccessActivityConfig(a.this.mQT.getContext().getActivity(), RequestResponseCode.REQUEST_VCODE, writeData, postWriteCallBackData.getAccessState())));
                }
            }
        }
    };

    public a(NewVcodeView newVcodeView, NewWriteModel newWriteModel) {
        this.mQT = newVcodeView;
        this.mMO = newWriteModel;
        this.mMO.b(this.eMD);
    }

    @Override // com.baidu.tieba.write.vcode.newVcode.a.b
    public boolean b(WebView webView, String str) {
        WriteData cKZ;
        if (this.mMO.cKZ() == null || StringUtils.isNull(str) || (cKZ = this.mMO.cKZ()) == null) {
            return false;
        }
        if (str.contains("objc:loadReady")) {
            if (cKZ.getVcodeExtra() == null) {
                return false;
            }
            this.mQT.runJsMethod("handleFreshCaptcha", "'" + cKZ.getVcodeUrl() + "','" + cKZ.getVcodeExtra().slideImg + "','" + cKZ.getVcodeExtra().textImg + "'");
            return true;
        } else if (str.contains("objc:jsChangePosition")) {
            SJ(com.baidu.tbadk.t.a.CN(str));
            return true;
        } else if (str.contains("objc:finish")) {
            this.mMP = true;
            if (cKZ != null && cKZ.getVideoReviewType() == 1) {
                this.mQT.showToast(true, this.mQT.getContext().getResources().getString(R.string.video_send_success_under_review));
            } else if (cKZ != null && cKZ.getVideoReviewType() == 2) {
                this.mQT.showToast(true, this.mQT.getContext().getResources().getString(R.string.video_send_success));
            } else {
                String str2 = null;
                String str3 = null;
                String string = this.mQT.getContext().getResources().getString(R.string.send_success);
                if (this.kFE != null) {
                    str2 = this.kFE.getPreMsg();
                    str3 = this.kFE.getColorMsg();
                    string = this.kFE.getErrorString();
                }
                if (cKZ.getType() != 7) {
                    com.baidu.tieba.tbadkCore.writeModel.c.g(this.mQT.getContext().getActivity(), string, str2, str3);
                }
            }
            Intent intent = new Intent();
            Bundle bundle = new Bundle();
            bundle.putSerializable("post_write_callback_data", this.kFE);
            intent.putExtras(bundle);
            BaseActivity context = this.mQT.getContext();
            this.mQT.getContext();
            context.setResult(-1, intent);
            this.mQT.getContext().finish();
            return true;
        } else if (str.contains("objc:jumpToFeedback()")) {
            WriteActivityConfig writeActivityConfig = new WriteActivityConfig(this.mQT.getContext().getActivity(), 0, TbConfig.getPositionPagerId(), TbConfig.getPositionPagerName(), null, null, 0, null, RequestResponseCode.REQUEST_WRITE_NEW, true, false, null, false, false, null, null, null, 0);
            writeActivityConfig.setIsVcodeFeedBack();
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, writeActivityConfig));
            return true;
        } else {
            return false;
        }
    }

    @Override // com.baidu.tieba.write.vcode.newVcode.a.b
    public void onPageFinished(WebView webView, String str) {
        if (this.mQT != null) {
            this.mQT.showWebViewDelay(1000);
        }
    }

    @Override // com.baidu.tieba.write.vcode.newVcode.a.b
    public void E(boolean z, String str) {
    }

    @Override // com.baidu.tieba.write.vcode.newVcode.a.b
    public void start(boolean z) {
        this.mQT.setRatio(0.9433962f);
        this.mQT.showWebView(false);
        this.mQT.getWebView().loadUrl(TbConfig.SERVER_ADDRESS_WEB_VIEW + Config.DRAG_VCODE_WEBVIEW_ADDRESS);
    }

    @Override // com.baidu.tieba.write.vcode.newVcode.a.b
    public void onDestroy() {
    }

    @Override // com.baidu.tieba.write.vcode.newVcode.a.b
    public void d(NewWriteModel.d dVar) {
        this.mQU = dVar;
    }

    @Override // com.baidu.tieba.write.vcode.newVcode.a.b
    public void dFO() {
        this.mQT.showPostThreadLoadingView(false);
        this.mMO.cancelLoadData();
    }

    private void SJ(String str) {
        this.mMP = false;
        if (!l.isNetOk()) {
            this.mQT.getContext().showToast(R.string.neterror);
            this.mQT.getContext().finish();
        } else if (!StringUtils.isNull(str)) {
            this.mQT.showPostThreadLoadingView(true);
            this.mMO.cKZ().setVcode(str);
            this.mMO.cKZ().setVcodeType("5");
            this.mMO.dxS();
        } else {
            this.mQT.getContext().showToast(R.string.neterror);
            this.mQT.getContext().finish();
        }
    }
}
