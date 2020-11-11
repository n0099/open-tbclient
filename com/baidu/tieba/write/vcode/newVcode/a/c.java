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
import com.baidu.tbadk.coreExtra.data.ah;
import com.baidu.tieba.R;
import com.baidu.tieba.tbadkCore.writeModel.NewWriteModel;
import com.baidu.tieba.tbadkCore.writeModel.PostWriteCallBackData;
import com.baidu.tieba.write.vcode.newVcode.NewVcodeView;
import com.xiaomi.mipush.sdk.Constants;
/* loaded from: classes3.dex */
public class c implements b {
    private final NewWriteModel nEW;
    private final NewVcodeView nIW;
    private NewWriteModel.d nIX;
    private String nIZ;
    private String nJa;
    private boolean nJb = false;
    private String nJc = null;
    private boolean nEX = false;
    private Runnable nJd = new Runnable() { // from class: com.baidu.tieba.write.vcode.newVcode.a.c.1
        @Override // java.lang.Runnable
        public void run() {
            if (c.this.nIW != null) {
                if (StringUtils.isNull(c.this.nJc)) {
                    c.this.nIW.showToast(false, c.this.nIW.getContext().getResources().getString(R.string.drag_vcode_error));
                } else {
                    c.this.nIW.showToast(false, c.this.nJc);
                }
            }
        }
    };
    private final NewWriteModel.d fpW = new NewWriteModel.d() { // from class: com.baidu.tieba.write.vcode.newVcode.a.c.2
        @Override // com.baidu.tieba.tbadkCore.writeModel.NewWriteModel.d
        public void callback(boolean z, PostWriteCallBackData postWriteCallBackData, ah ahVar, WriteData writeData, AntiData antiData) {
            String str;
            String str2 = null;
            if (c.this.nIW != null) {
                c.this.nIW.showPostThreadLoadingView(false);
                if (z) {
                    c.this.nEX = true;
                    if (writeData != null && writeData.getVideoReviewType() == 1) {
                        c.this.nIW.showToast(true, c.this.nIW.getContext().getResources().getString(R.string.video_send_success_under_review));
                    } else if (writeData != null && writeData.getVideoReviewType() == 2) {
                        c.this.nIW.showToast(true, c.this.nIW.getContext().getResources().getString(R.string.video_send_success));
                    } else if (writeData != null) {
                        String string = c.this.nIW.getContext().getResources().getString(R.string.send_success);
                        if (postWriteCallBackData != null) {
                            str = postWriteCallBackData.getPreMsg();
                            str2 = postWriteCallBackData.getColorMsg();
                            string = postWriteCallBackData.getErrorString();
                        } else {
                            str = null;
                        }
                        if (writeData.getType() != 7) {
                            com.baidu.tieba.tbadkCore.writeModel.c.g(c.this.nIW.getContext().getActivity(), string, str, str2);
                        }
                    }
                    Intent intent = new Intent();
                    Bundle bundle = new Bundle();
                    bundle.putSerializable("post_write_callback_data", postWriteCallBackData);
                    intent.putExtras(bundle);
                    BaseActivity context = c.this.nIW.getContext();
                    c.this.nIW.getContext();
                    context.setResult(-1, intent);
                    c.this.nIW.getContext().finish();
                } else if (postWriteCallBackData != null && postWriteCallBackData.getErrorCode() == 227001) {
                    c.this.nIW.getContext().setVisible(false);
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AccountAccessActivityConfig(c.this.nIW.getContext().getActivity(), RequestResponseCode.REQUEST_VCODE, writeData, postWriteCallBackData.getAccessState())));
                } else if (postWriteCallBackData != null && postWriteCallBackData.getErrorCode() == 220015 && c.this.nIX != null) {
                    if (c.this.nIX != null) {
                        c.this.nIX.callback(z, postWriteCallBackData, ahVar, writeData, antiData);
                    }
                } else if (postWriteCallBackData != null) {
                    if (StringUtils.isNull(postWriteCallBackData.getErrorString())) {
                        c.this.nIW.showToast(false, c.this.nIW.getContext().getResources().getString(R.string.input_vcode_error));
                    } else {
                        c.this.nIW.showToast(false, postWriteCallBackData.getErrorString());
                    }
                    c.this.dUg();
                }
            }
        }
    };

    public c(NewVcodeView newVcodeView, NewWriteModel newWriteModel) {
        this.nIW = newVcodeView;
        this.nEW = newWriteModel;
        this.nEW.b(this.fpW);
    }

    @Override // com.baidu.tieba.write.vcode.newVcode.a.b
    public boolean b(WebView webView, String str) {
        if (str.contains("objc:jsChangeVcode")) {
            this.nIZ = com.baidu.tbadk.t.a.ED(str);
            if (this.nIZ != null && this.nEW.cXW() != null) {
                this.nIW.runJsMethod(this.nIZ, "'" + this.nEW.cXW().getVcodeUrl() + "'");
                return true;
            }
            return false;
        } else if (str.equals("objc:jumpToFeedback()")) {
            WriteActivityConfig writeActivityConfig = new WriteActivityConfig(this.nIW.getContext().getActivity(), 0, TbConfig.getPositionPagerId(), TbConfig.getPositionPagerName(), null, null, 0, null, RequestResponseCode.REQUEST_WRITE_NEW, true, false, null, false, false, null, null, null, 0);
            writeActivityConfig.setIsVcodeFeedBack();
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, writeActivityConfig));
            return true;
        } else if (str.contains("objc:jsSubmit")) {
            return UO(com.baidu.tbadk.t.a.ED(str));
        } else {
            return false;
        }
    }

    @Override // com.baidu.tieba.write.vcode.newVcode.a.b
    public void onPageFinished(WebView webView, String str) {
        if (this.nIW != null) {
            this.nIW.showWebViewDelay(500);
            if (this.nJb) {
                e.mY().postDelayed(this.nJd, 500L);
            }
        }
    }

    @Override // com.baidu.tieba.write.vcode.newVcode.a.b
    public void G(boolean z, String str) {
        this.nJb = z;
        this.nJc = str;
    }

    @Override // com.baidu.tieba.write.vcode.newVcode.a.b
    public void start(boolean z) {
        this.nIW.setRatio(1.2631578f);
        this.nIW.showWebView(false);
        String str = TbConfig.SERVER_ADDRESS_WEB_VIEW + Config.NEW_VCODE_WEBVIEW_ADDRESS;
        if (z) {
            str = str + "?feedback=1";
        }
        this.nIW.getWebView().loadUrl(str);
    }

    @Override // com.baidu.tieba.write.vcode.newVcode.a.b
    public void onDestroy() {
        e.mY().removeCallbacks(this.nJd);
    }

    @Override // com.baidu.tieba.write.vcode.newVcode.a.b
    public void d(NewWriteModel.d dVar) {
        this.nIX = dVar;
    }

    @Override // com.baidu.tieba.write.vcode.newVcode.a.b
    public void dTl() {
        this.nIW.showPostThreadLoadingView(false);
        this.nEW.cancelLoadData();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dUg() {
        this.nIW.runJsMethod(this.nJa, "'" + this.nEW.cXW().getVcodeUrl() + "'");
    }

    private boolean UO(String str) {
        String[] split;
        if (StringUtils.isNull(str) || (split = str.split(Constants.ACCEPT_TIME_SEPARATOR_SP)) == null || split.length != 2) {
            return false;
        }
        this.nJa = split[0];
        UN(split[1]);
        return true;
    }

    private void UN(String str) {
        this.nEX = false;
        if (!l.isNetOk()) {
            this.nIW.getContext().showToast(R.string.neterror);
            this.nIW.getContext().finish();
        } else if (!StringUtils.isNull(str)) {
            this.nIW.showPostThreadLoadingView(true);
            this.nEW.cXW().setVcode(str);
            this.nEW.cXW().setVcodeType("4");
            this.nEW.dLm();
        } else {
            this.nIW.getContext().showToast(R.string.neterror);
            this.nIW.getContext().finish();
        }
    }
}
