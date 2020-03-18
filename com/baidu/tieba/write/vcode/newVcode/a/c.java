package com.baidu.tieba.write.vcode.newVcode.a;

import android.content.Intent;
import android.os.Bundle;
import android.webkit.WebView;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.lib.f.e;
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
import com.baidu.tbadk.coreExtra.data.aa;
import com.baidu.tieba.R;
import com.baidu.tieba.tbadkCore.writeModel.NewWriteModel;
import com.baidu.tieba.tbadkCore.writeModel.PostWriteCallBackData;
import com.baidu.tieba.write.vcode.newVcode.NewVcodeView;
import com.xiaomi.mipush.sdk.Constants;
/* loaded from: classes13.dex */
public class c implements b {
    private final NewWriteModel kOr;
    private final NewVcodeView kRF;
    private NewWriteModel.d kRG;
    private String kRI;
    private String kRJ;
    private boolean kRK = false;
    private String kRL = null;
    private boolean kOs = false;
    private Runnable kRM = new Runnable() { // from class: com.baidu.tieba.write.vcode.newVcode.a.c.1
        @Override // java.lang.Runnable
        public void run() {
            if (c.this.kRF != null) {
                if (StringUtils.isNull(c.this.kRL)) {
                    c.this.kRF.showToast(false, c.this.kRF.getContext().getResources().getString(R.string.drag_vcode_error));
                } else {
                    c.this.kRF.showToast(false, c.this.kRL);
                }
            }
        }
    };
    private final NewWriteModel.d dza = new NewWriteModel.d() { // from class: com.baidu.tieba.write.vcode.newVcode.a.c.2
        @Override // com.baidu.tieba.tbadkCore.writeModel.NewWriteModel.d
        public void callback(boolean z, PostWriteCallBackData postWriteCallBackData, aa aaVar, WriteData writeData, AntiData antiData) {
            String str;
            String str2 = null;
            if (c.this.kRF != null) {
                c.this.kRF.showPostThreadLoadingView(false);
                if (z) {
                    c.this.kOs = true;
                    if (writeData != null && writeData.getVideoReviewType() == 1) {
                        c.this.kRF.showToast(true, c.this.kRF.getContext().getResources().getString(R.string.video_send_success_under_review));
                    } else if (writeData != null && writeData.getVideoReviewType() == 2) {
                        c.this.kRF.showToast(true, c.this.kRF.getContext().getResources().getString(R.string.video_send_success));
                    } else if (writeData != null) {
                        String string = c.this.kRF.getContext().getResources().getString(R.string.send_success);
                        if (postWriteCallBackData != null) {
                            str = postWriteCallBackData.getPreMsg();
                            str2 = postWriteCallBackData.getColorMsg();
                            string = postWriteCallBackData.getErrorString();
                        } else {
                            str = null;
                        }
                        if (writeData.getType() != 7) {
                            com.baidu.tieba.tbadkCore.writeModel.c.g(c.this.kRF.getContext().getActivity(), string, str, str2);
                        }
                    }
                    Intent intent = new Intent();
                    Bundle bundle = new Bundle();
                    bundle.putSerializable("post_write_callback_data", postWriteCallBackData);
                    intent.putExtras(bundle);
                    BaseActivity context = c.this.kRF.getContext();
                    c.this.kRF.getContext();
                    context.setResult(-1, intent);
                    c.this.kRF.getContext().finish();
                } else if (postWriteCallBackData != null && postWriteCallBackData.getErrorCode() == 227001) {
                    c.this.kRF.getContext().setVisible(false);
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AccountAccessActivityConfig(c.this.kRF.getContext().getActivity(), RequestResponseCode.REQUEST_VCODE, writeData, postWriteCallBackData.getAccessState())));
                } else if (postWriteCallBackData != null && postWriteCallBackData.getErrorCode() == 220015 && c.this.kRG != null) {
                    if (c.this.kRG != null) {
                        c.this.kRG.callback(z, postWriteCallBackData, aaVar, writeData, antiData);
                    }
                } else if (postWriteCallBackData != null) {
                    if (StringUtils.isNull(postWriteCallBackData.getErrorString())) {
                        c.this.kRF.showToast(false, c.this.kRF.getContext().getResources().getString(R.string.input_vcode_error));
                    } else {
                        c.this.kRF.showToast(false, postWriteCallBackData.getErrorString());
                    }
                    c.this.cVx();
                }
            }
        }
    };

    public c(NewVcodeView newVcodeView, NewWriteModel newWriteModel) {
        this.kRF = newVcodeView;
        this.kOr = newWriteModel;
        this.kOr.b(this.dza);
    }

    @Override // com.baidu.tieba.write.vcode.newVcode.a.b
    public boolean c(WebView webView, String str) {
        if (str.contains("objc:jsChangeVcode")) {
            this.kRI = com.baidu.tbadk.s.a.wa(str);
            if (this.kRI != null && this.kOr.cIp() != null) {
                this.kRF.runJsMethod(this.kRI, "'" + this.kOr.cIp().getVcodeUrl() + "'");
                return true;
            }
            return false;
        } else if (str.equals("objc:jumpToFeedback()")) {
            WriteActivityConfig writeActivityConfig = new WriteActivityConfig(this.kRF.getContext().getActivity(), 0, TbConfig.getPositionPagerId(), TbConfig.getPositionPagerName(), null, null, 0, null, RequestResponseCode.REQUEST_WRITE_NEW, true, false, null, false, false, null, null, null, 0);
            writeActivityConfig.setIsVcodeFeedBack();
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, writeActivityConfig));
            return true;
        } else if (str.contains("objc:jsSubmit")) {
            return KV(com.baidu.tbadk.s.a.wa(str));
        } else {
            return false;
        }
    }

    @Override // com.baidu.tieba.write.vcode.newVcode.a.b
    public void onPageFinished(WebView webView, String str) {
        if (this.kRF != null) {
            this.kRF.showWebViewDelay(500);
            if (this.kRK) {
                e.gx().postDelayed(this.kRM, 500L);
            }
        }
    }

    @Override // com.baidu.tieba.write.vcode.newVcode.a.b
    public void A(boolean z, String str) {
        this.kRK = z;
        this.kRL = str;
    }

    @Override // com.baidu.tieba.write.vcode.newVcode.a.b
    public void start(boolean z) {
        this.kRF.setRatio(1.2631578f);
        this.kRF.showWebView(false);
        String str = TbConfig.SERVER_ADDRESS_WEB_VIEW + Config.NEW_VCODE_WEBVIEW_ADDRESS;
        if (z) {
            str = str + "?feedback=1";
        }
        this.kRF.getWebView().loadUrl(str);
    }

    @Override // com.baidu.tieba.write.vcode.newVcode.a.b
    public void onDestroy() {
        e.gx().removeCallbacks(this.kRM);
    }

    @Override // com.baidu.tieba.write.vcode.newVcode.a.b
    public void d(NewWriteModel.d dVar) {
        this.kRG = dVar;
    }

    @Override // com.baidu.tieba.write.vcode.newVcode.a.b
    public void cUQ() {
        this.kRF.showPostThreadLoadingView(false);
        this.kOr.cancelLoadData();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cVx() {
        this.kRF.runJsMethod(this.kRJ, "'" + this.kOr.cIp().getVcodeUrl() + "'");
    }

    private boolean KV(String str) {
        String[] split;
        if (StringUtils.isNull(str) || (split = str.split(Constants.ACCEPT_TIME_SEPARATOR_SP)) == null || split.length != 2) {
            return false;
        }
        this.kRJ = split[0];
        KU(split[1]);
        return true;
    }

    private void KU(String str) {
        this.kOs = false;
        if (!l.isNetOk()) {
            this.kRF.getContext().showToast(R.string.neterror);
            this.kRF.getContext().finish();
        } else if (!StringUtils.isNull(str)) {
            this.kRF.showPostThreadLoadingView(true);
            this.kOr.cIp().setVcode(str);
            this.kOr.cIp().setVcodeType("4");
            this.kOr.cME();
        } else {
            this.kRF.getContext().showToast(R.string.neterror);
            this.kRF.getContext().finish();
        }
    }
}
