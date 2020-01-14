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
import com.baidu.tbadk.coreExtra.data.z;
import com.baidu.tieba.R;
import com.baidu.tieba.tbadkCore.writeModel.NewWriteModel;
import com.baidu.tieba.tbadkCore.writeModel.PostWriteCallBackData;
import com.baidu.tieba.write.vcode.newVcode.NewVcodeView;
import com.xiaomi.mipush.sdk.Constants;
/* loaded from: classes11.dex */
public class a implements b {
    private PostWriteCallBackData iHZ;
    private final NewWriteModel kLO;
    private final NewVcodeView kPl;
    private NewWriteModel.d kPm;
    private boolean kLP = false;
    private final NewWriteModel.d dut = new NewWriteModel.d() { // from class: com.baidu.tieba.write.vcode.newVcode.a.a.1
        @Override // com.baidu.tieba.tbadkCore.writeModel.NewWriteModel.d
        public void callback(boolean z, PostWriteCallBackData postWriteCallBackData, z zVar, WriteData writeData, AntiData antiData) {
            String str;
            String str2;
            String str3 = null;
            if (a.this.kPl != null) {
                a.this.kPl.showPostThreadLoadingView(false);
                if (z) {
                    a.this.iHZ = postWriteCallBackData;
                    a.this.kLP = true;
                    if (zVar == null || zVar.aHl() == null) {
                        str = null;
                        str2 = null;
                    } else {
                        str2 = zVar.aHl().endPoint;
                        str = zVar.aHl().successImg;
                        str3 = zVar.aHl().slideEndPoint;
                    }
                    a.this.kPl.runJsMethod("success", str + Constants.ACCEPT_TIME_SEPARATOR_SP + str2 + Constants.ACCEPT_TIME_SEPARATOR_SP + str3);
                } else if (postWriteCallBackData == null || postWriteCallBackData.getErrorCode() != 227001) {
                    if (a.this.kPm != null) {
                        a.this.kPm.callback(false, postWriteCallBackData, zVar, writeData, antiData);
                    }
                } else {
                    a.this.kPl.getContext().setVisible(false);
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AccountAccessActivityConfig(a.this.kPl.getContext().getActivity(), RequestResponseCode.REQUEST_VCODE, writeData, postWriteCallBackData.getAccessState())));
                }
            }
        }
    };

    public a(NewVcodeView newVcodeView, NewWriteModel newWriteModel) {
        this.kPl = newVcodeView;
        this.kLO = newWriteModel;
        this.kLO.b(this.dut);
    }

    @Override // com.baidu.tieba.write.vcode.newVcode.a.b
    public boolean c(WebView webView, String str) {
        WriteData cGo;
        if (this.kLO.cGo() == null || StringUtils.isNull(str) || (cGo = this.kLO.cGo()) == null) {
            return false;
        }
        if (str.contains("objc:loadReady")) {
            if (cGo.getVcodeExtra() == null) {
                return false;
            }
            this.kPl.runJsMethod("handleFreshCaptcha", "'" + cGo.getVcodeUrl() + "','" + cGo.getVcodeExtra().slideImg + "','" + cGo.getVcodeExtra().textImg + "'");
            return true;
        } else if (str.contains("objc:jsChangePosition")) {
            KH(com.baidu.tbadk.s.a.vF(str));
            return true;
        } else if (str.contains("objc:finish")) {
            this.kLP = true;
            if (cGo != null && cGo.getVideoReviewType() == 1) {
                this.kPl.showToast(true, this.kPl.getContext().getResources().getString(R.string.video_send_success_under_review));
            } else if (cGo != null && cGo.getVideoReviewType() == 2) {
                this.kPl.showToast(true, this.kPl.getContext().getResources().getString(R.string.video_send_success));
            } else {
                String str2 = null;
                String str3 = null;
                String string = this.kPl.getContext().getResources().getString(R.string.send_success);
                if (this.iHZ != null) {
                    str2 = this.iHZ.getPreMsg();
                    str3 = this.iHZ.getColorMsg();
                    string = this.iHZ.getErrorString();
                }
                if (cGo.getType() != 7) {
                    com.baidu.tieba.tbadkCore.writeModel.c.g(this.kPl.getContext().getActivity(), string, str2, str3);
                }
            }
            Intent intent = new Intent();
            Bundle bundle = new Bundle();
            bundle.putSerializable("post_write_callback_data", this.iHZ);
            intent.putExtras(bundle);
            BaseActivity context = this.kPl.getContext();
            this.kPl.getContext();
            context.setResult(-1, intent);
            this.kPl.getContext().finish();
            return true;
        } else if (str.contains("objc:jumpToFeedback()")) {
            WriteActivityConfig writeActivityConfig = new WriteActivityConfig(this.kPl.getContext().getActivity(), 0, TbConfig.getPositionPagerId(), TbConfig.getPositionPagerName(), null, null, 0, null, RequestResponseCode.REQUEST_WRITE_NEW, true, false, null, false, false, null, null, null, 0);
            writeActivityConfig.setIsVcodeFeedBack();
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, writeActivityConfig));
            return true;
        } else {
            return false;
        }
    }

    @Override // com.baidu.tieba.write.vcode.newVcode.a.b
    public void onPageFinished(WebView webView, String str) {
        if (this.kPl != null) {
            this.kPl.showWebViewDelay(1000);
        }
    }

    @Override // com.baidu.tieba.write.vcode.newVcode.a.b
    public void A(boolean z, String str) {
    }

    @Override // com.baidu.tieba.write.vcode.newVcode.a.b
    public void start(boolean z) {
        this.kPl.setRatio(0.9433962f);
        this.kPl.showWebView(false);
        this.kPl.getWebView().loadUrl(TbConfig.SERVER_ADDRESS_WEB_VIEW + Config.DRAG_VCODE_WEBVIEW_ADDRESS);
    }

    @Override // com.baidu.tieba.write.vcode.newVcode.a.b
    public void onDestroy() {
    }

    @Override // com.baidu.tieba.write.vcode.newVcode.a.b
    public void d(NewWriteModel.d dVar) {
        this.kPm = dVar;
    }

    @Override // com.baidu.tieba.write.vcode.newVcode.a.b
    public void cTe() {
        this.kPl.showPostThreadLoadingView(false);
        this.kLO.cancelLoadData();
    }

    private void KH(String str) {
        this.kLP = false;
        if (!l.isNetOk()) {
            this.kPl.getContext().showToast(R.string.neterror);
            this.kPl.getContext().finish();
        } else if (!StringUtils.isNull(str)) {
            this.kPl.showPostThreadLoadingView(true);
            this.kLO.cGo().setVcode(str);
            this.kLO.cGo().setVcodeType("5");
            this.kLO.cKM();
        } else {
            this.kPl.getContext().showToast(R.string.neterror);
            this.kPl.getContext().finish();
        }
    }
}
