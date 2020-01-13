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
    private final NewWriteModel kLJ;
    private final NewVcodeView kPg;
    private NewWriteModel.d kPh;
    private boolean kLK = false;
    private final NewWriteModel.d dut = new NewWriteModel.d() { // from class: com.baidu.tieba.write.vcode.newVcode.a.a.1
        @Override // com.baidu.tieba.tbadkCore.writeModel.NewWriteModel.d
        public void callback(boolean z, PostWriteCallBackData postWriteCallBackData, z zVar, WriteData writeData, AntiData antiData) {
            String str;
            String str2;
            String str3 = null;
            if (a.this.kPg != null) {
                a.this.kPg.showPostThreadLoadingView(false);
                if (z) {
                    a.this.iHZ = postWriteCallBackData;
                    a.this.kLK = true;
                    if (zVar == null || zVar.aHl() == null) {
                        str = null;
                        str2 = null;
                    } else {
                        str2 = zVar.aHl().endPoint;
                        str = zVar.aHl().successImg;
                        str3 = zVar.aHl().slideEndPoint;
                    }
                    a.this.kPg.runJsMethod("success", str + Constants.ACCEPT_TIME_SEPARATOR_SP + str2 + Constants.ACCEPT_TIME_SEPARATOR_SP + str3);
                } else if (postWriteCallBackData == null || postWriteCallBackData.getErrorCode() != 227001) {
                    if (a.this.kPh != null) {
                        a.this.kPh.callback(false, postWriteCallBackData, zVar, writeData, antiData);
                    }
                } else {
                    a.this.kPg.getContext().setVisible(false);
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AccountAccessActivityConfig(a.this.kPg.getContext().getActivity(), RequestResponseCode.REQUEST_VCODE, writeData, postWriteCallBackData.getAccessState())));
                }
            }
        }
    };

    public a(NewVcodeView newVcodeView, NewWriteModel newWriteModel) {
        this.kPg = newVcodeView;
        this.kLJ = newWriteModel;
        this.kLJ.b(this.dut);
    }

    @Override // com.baidu.tieba.write.vcode.newVcode.a.b
    public boolean c(WebView webView, String str) {
        WriteData cGm;
        if (this.kLJ.cGm() == null || StringUtils.isNull(str) || (cGm = this.kLJ.cGm()) == null) {
            return false;
        }
        if (str.contains("objc:loadReady")) {
            if (cGm.getVcodeExtra() == null) {
                return false;
            }
            this.kPg.runJsMethod("handleFreshCaptcha", "'" + cGm.getVcodeUrl() + "','" + cGm.getVcodeExtra().slideImg + "','" + cGm.getVcodeExtra().textImg + "'");
            return true;
        } else if (str.contains("objc:jsChangePosition")) {
            KH(com.baidu.tbadk.s.a.vF(str));
            return true;
        } else if (str.contains("objc:finish")) {
            this.kLK = true;
            if (cGm != null && cGm.getVideoReviewType() == 1) {
                this.kPg.showToast(true, this.kPg.getContext().getResources().getString(R.string.video_send_success_under_review));
            } else if (cGm != null && cGm.getVideoReviewType() == 2) {
                this.kPg.showToast(true, this.kPg.getContext().getResources().getString(R.string.video_send_success));
            } else {
                String str2 = null;
                String str3 = null;
                String string = this.kPg.getContext().getResources().getString(R.string.send_success);
                if (this.iHZ != null) {
                    str2 = this.iHZ.getPreMsg();
                    str3 = this.iHZ.getColorMsg();
                    string = this.iHZ.getErrorString();
                }
                if (cGm.getType() != 7) {
                    com.baidu.tieba.tbadkCore.writeModel.c.g(this.kPg.getContext().getActivity(), string, str2, str3);
                }
            }
            Intent intent = new Intent();
            Bundle bundle = new Bundle();
            bundle.putSerializable("post_write_callback_data", this.iHZ);
            intent.putExtras(bundle);
            BaseActivity context = this.kPg.getContext();
            this.kPg.getContext();
            context.setResult(-1, intent);
            this.kPg.getContext().finish();
            return true;
        } else if (str.contains("objc:jumpToFeedback()")) {
            WriteActivityConfig writeActivityConfig = new WriteActivityConfig(this.kPg.getContext().getActivity(), 0, TbConfig.getPositionPagerId(), TbConfig.getPositionPagerName(), null, null, 0, null, RequestResponseCode.REQUEST_WRITE_NEW, true, false, null, false, false, null, null, null, 0);
            writeActivityConfig.setIsVcodeFeedBack();
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, writeActivityConfig));
            return true;
        } else {
            return false;
        }
    }

    @Override // com.baidu.tieba.write.vcode.newVcode.a.b
    public void onPageFinished(WebView webView, String str) {
        if (this.kPg != null) {
            this.kPg.showWebViewDelay(1000);
        }
    }

    @Override // com.baidu.tieba.write.vcode.newVcode.a.b
    public void A(boolean z, String str) {
    }

    @Override // com.baidu.tieba.write.vcode.newVcode.a.b
    public void start(boolean z) {
        this.kPg.setRatio(0.9433962f);
        this.kPg.showWebView(false);
        this.kPg.getWebView().loadUrl(TbConfig.SERVER_ADDRESS_WEB_VIEW + Config.DRAG_VCODE_WEBVIEW_ADDRESS);
    }

    @Override // com.baidu.tieba.write.vcode.newVcode.a.b
    public void onDestroy() {
    }

    @Override // com.baidu.tieba.write.vcode.newVcode.a.b
    public void d(NewWriteModel.d dVar) {
        this.kPh = dVar;
    }

    @Override // com.baidu.tieba.write.vcode.newVcode.a.b
    public void cTc() {
        this.kPg.showPostThreadLoadingView(false);
        this.kLJ.cancelLoadData();
    }

    private void KH(String str) {
        this.kLK = false;
        if (!l.isNetOk()) {
            this.kPg.getContext().showToast(R.string.neterror);
            this.kPg.getContext().finish();
        } else if (!StringUtils.isNull(str)) {
            this.kPg.showPostThreadLoadingView(true);
            this.kLJ.cGm().setVcode(str);
            this.kLJ.cGm().setVcodeType("5");
            this.kLJ.cKK();
        } else {
            this.kPg.getContext().showToast(R.string.neterror);
            this.kPg.getContext().finish();
        }
    }
}
