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
    private final NewWriteModel nGx;
    private String nKA;
    private String nKB;
    private final NewVcodeView nKx;
    private NewWriteModel.d nKy;
    private boolean nKC = false;
    private String nKD = null;
    private boolean nGy = false;
    private Runnable nKE = new Runnable() { // from class: com.baidu.tieba.write.vcode.newVcode.a.c.1
        @Override // java.lang.Runnable
        public void run() {
            if (c.this.nKx != null) {
                if (StringUtils.isNull(c.this.nKD)) {
                    c.this.nKx.showToast(false, c.this.nKx.getContext().getResources().getString(R.string.drag_vcode_error));
                } else {
                    c.this.nKx.showToast(false, c.this.nKD);
                }
            }
        }
    };
    private final NewWriteModel.d fpd = new NewWriteModel.d() { // from class: com.baidu.tieba.write.vcode.newVcode.a.c.2
        @Override // com.baidu.tieba.tbadkCore.writeModel.NewWriteModel.d
        public void callback(boolean z, PostWriteCallBackData postWriteCallBackData, ah ahVar, WriteData writeData, AntiData antiData) {
            String str;
            String str2 = null;
            if (c.this.nKx != null) {
                c.this.nKx.showPostThreadLoadingView(false);
                if (z) {
                    c.this.nGy = true;
                    if (writeData != null && writeData.getVideoReviewType() == 1) {
                        c.this.nKx.showToast(true, c.this.nKx.getContext().getResources().getString(R.string.video_send_success_under_review));
                    } else if (writeData != null && writeData.getVideoReviewType() == 2) {
                        c.this.nKx.showToast(true, c.this.nKx.getContext().getResources().getString(R.string.video_send_success));
                    } else if (writeData != null) {
                        String string = c.this.nKx.getContext().getResources().getString(R.string.send_success);
                        if (postWriteCallBackData != null) {
                            str = postWriteCallBackData.getPreMsg();
                            str2 = postWriteCallBackData.getColorMsg();
                            string = postWriteCallBackData.getErrorString();
                        } else {
                            str = null;
                        }
                        if (writeData.getType() != 7) {
                            com.baidu.tieba.tbadkCore.writeModel.c.g(c.this.nKx.getContext().getActivity(), string, str, str2);
                        }
                    }
                    Intent intent = new Intent();
                    Bundle bundle = new Bundle();
                    bundle.putSerializable("post_write_callback_data", postWriteCallBackData);
                    intent.putExtras(bundle);
                    BaseActivity context = c.this.nKx.getContext();
                    c.this.nKx.getContext();
                    context.setResult(-1, intent);
                    c.this.nKx.getContext().finish();
                } else if (postWriteCallBackData != null && postWriteCallBackData.getErrorCode() == 227001) {
                    c.this.nKx.getContext().setVisible(false);
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AccountAccessActivityConfig(c.this.nKx.getContext().getActivity(), RequestResponseCode.REQUEST_VCODE, writeData, postWriteCallBackData.getAccessState())));
                } else if (postWriteCallBackData != null && postWriteCallBackData.getErrorCode() == 220015 && c.this.nKy != null) {
                    if (c.this.nKy != null) {
                        c.this.nKy.callback(z, postWriteCallBackData, ahVar, writeData, antiData);
                    }
                } else if (postWriteCallBackData != null) {
                    if (StringUtils.isNull(postWriteCallBackData.getErrorString())) {
                        c.this.nKx.showToast(false, c.this.nKx.getContext().getResources().getString(R.string.input_vcode_error));
                    } else {
                        c.this.nKx.showToast(false, postWriteCallBackData.getErrorString());
                    }
                    c.this.dUf();
                }
            }
        }
    };

    public c(NewVcodeView newVcodeView, NewWriteModel newWriteModel) {
        this.nKx = newVcodeView;
        this.nGx = newWriteModel;
        this.nGx.b(this.fpd);
    }

    @Override // com.baidu.tieba.write.vcode.newVcode.a.b
    public boolean c(WebView webView, String str) {
        if (str.contains("objc:jsChangeVcode")) {
            this.nKA = com.baidu.tbadk.t.a.Ee(str);
            if (this.nKA != null && this.nGx.cXs() != null) {
                this.nKx.runJsMethod(this.nKA, "'" + this.nGx.cXs().getVcodeUrl() + "'");
                return true;
            }
            return false;
        } else if (str.equals("objc:jumpToFeedback()")) {
            WriteActivityConfig writeActivityConfig = new WriteActivityConfig(this.nKx.getContext().getActivity(), 0, TbConfig.getPositionPagerId(), TbConfig.getPositionPagerName(), null, null, 0, null, RequestResponseCode.REQUEST_WRITE_NEW, true, false, null, false, false, null, null, null, 0);
            writeActivityConfig.setIsVcodeFeedBack();
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, writeActivityConfig));
            return true;
        } else if (str.contains("objc:jsSubmit")) {
            return Uz(com.baidu.tbadk.t.a.Ee(str));
        } else {
            return false;
        }
    }

    @Override // com.baidu.tieba.write.vcode.newVcode.a.b
    public void onPageFinished(WebView webView, String str) {
        if (this.nKx != null) {
            this.nKx.showWebViewDelay(500);
            if (this.nKC) {
                e.mY().postDelayed(this.nKE, 500L);
            }
        }
    }

    @Override // com.baidu.tieba.write.vcode.newVcode.a.b
    public void H(boolean z, String str) {
        this.nKC = z;
        this.nKD = str;
    }

    @Override // com.baidu.tieba.write.vcode.newVcode.a.b
    public void start(boolean z) {
        this.nKx.setRatio(1.2631578f);
        this.nKx.showWebView(false);
        String str = TbConfig.SERVER_ADDRESS_WEB_VIEW + Config.NEW_VCODE_WEBVIEW_ADDRESS;
        if (z) {
            str = str + "?feedback=1";
        }
        this.nKx.getWebView().loadUrl(str);
    }

    @Override // com.baidu.tieba.write.vcode.newVcode.a.b
    public void onDestroy() {
        e.mY().removeCallbacks(this.nKE);
    }

    @Override // com.baidu.tieba.write.vcode.newVcode.a.b
    public void d(NewWriteModel.d dVar) {
        this.nKy = dVar;
    }

    @Override // com.baidu.tieba.write.vcode.newVcode.a.b
    public void dTk() {
        this.nKx.showPostThreadLoadingView(false);
        this.nGx.cancelLoadData();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dUf() {
        this.nKx.runJsMethod(this.nKB, "'" + this.nGx.cXs().getVcodeUrl() + "'");
    }

    private boolean Uz(String str) {
        String[] split;
        if (StringUtils.isNull(str) || (split = str.split(Constants.ACCEPT_TIME_SEPARATOR_SP)) == null || split.length != 2) {
            return false;
        }
        this.nKB = split[0];
        Uy(split[1]);
        return true;
    }

    private void Uy(String str) {
        this.nGy = false;
        if (!l.isNetOk()) {
            this.nKx.getContext().showToast(R.string.neterror);
            this.nKx.getContext().finish();
        } else if (!StringUtils.isNull(str)) {
            this.nKx.showPostThreadLoadingView(true);
            this.nGx.cXs().setVcode(str);
            this.nGx.cXs().setVcodeType("4");
            this.nGx.dLl();
        } else {
            this.nKx.getContext().showToast(R.string.neterror);
            this.nKx.getContext().finish();
        }
    }
}
