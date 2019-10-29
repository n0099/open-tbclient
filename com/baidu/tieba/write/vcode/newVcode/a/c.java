package com.baidu.tieba.write.vcode.newVcode.a;

import android.content.Intent;
import android.os.Bundle;
import android.webkit.WebView;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.lib.g.e;
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
import com.baidu.tbadk.coreExtra.data.y;
import com.baidu.tieba.R;
import com.baidu.tieba.tbadkCore.writeModel.NewWriteModel;
import com.baidu.tieba.tbadkCore.writeModel.PostWriteCallBackData;
import com.baidu.tieba.write.vcode.newVcode.NewVcodeView;
import com.xiaomi.mipush.sdk.Constants;
/* loaded from: classes3.dex */
public class c implements b {
    private final NewWriteModel jOl;
    private final NewVcodeView jRK;
    private NewWriteModel.d jRL;
    private String jRN;
    private String jRO;
    private boolean jRP = false;
    private String jRQ = null;
    private boolean jOm = false;
    private Runnable jRR = new Runnable() { // from class: com.baidu.tieba.write.vcode.newVcode.a.c.1
        @Override // java.lang.Runnable
        public void run() {
            if (c.this.jRK != null) {
                if (StringUtils.isNull(c.this.jRQ)) {
                    c.this.jRK.showToast(false, c.this.jRK.getContext().getResources().getString(R.string.drag_vcode_error));
                } else {
                    c.this.jRK.showToast(false, c.this.jRQ);
                }
            }
        }
    };
    private final NewWriteModel.d cHf = new NewWriteModel.d() { // from class: com.baidu.tieba.write.vcode.newVcode.a.c.2
        @Override // com.baidu.tieba.tbadkCore.writeModel.NewWriteModel.d
        public void callback(boolean z, PostWriteCallBackData postWriteCallBackData, y yVar, WriteData writeData, AntiData antiData) {
            String str;
            String str2 = null;
            if (c.this.jRK != null) {
                c.this.jRK.showPostThreadLoadingView(false);
                if (z) {
                    c.this.jOm = true;
                    if (writeData != null && writeData.getVideoReviewType() == 1) {
                        c.this.jRK.showToast(true, c.this.jRK.getContext().getResources().getString(R.string.video_send_success_under_review));
                    } else if (writeData != null && writeData.getVideoReviewType() == 2) {
                        c.this.jRK.showToast(true, c.this.jRK.getContext().getResources().getString(R.string.video_send_success));
                    } else if (writeData != null) {
                        String string = c.this.jRK.getContext().getResources().getString(R.string.send_success);
                        if (postWriteCallBackData != null) {
                            str = postWriteCallBackData.getPreMsg();
                            str2 = postWriteCallBackData.getColorMsg();
                            string = postWriteCallBackData.getErrorString();
                        } else {
                            str = null;
                        }
                        if (writeData.getType() != 7) {
                            com.baidu.tieba.tbadkCore.writeModel.c.g(c.this.jRK.getContext().getActivity(), string, str, str2);
                        }
                    }
                    Intent intent = new Intent();
                    Bundle bundle = new Bundle();
                    bundle.putSerializable("post_write_callback_data", postWriteCallBackData);
                    intent.putExtras(bundle);
                    BaseActivity context = c.this.jRK.getContext();
                    c.this.jRK.getContext();
                    context.setResult(-1, intent);
                    c.this.jRK.getContext().finish();
                } else if (postWriteCallBackData != null && postWriteCallBackData.getErrorCode() == 227001) {
                    c.this.jRK.getContext().setVisible(false);
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AccountAccessActivityConfig(c.this.jRK.getContext().getActivity(), RequestResponseCode.REQUEST_VCODE, writeData, postWriteCallBackData.getAccessState())));
                } else if (postWriteCallBackData != null && postWriteCallBackData.getErrorCode() == 220015 && c.this.jRL != null) {
                    if (c.this.jRL != null) {
                        c.this.jRL.callback(z, postWriteCallBackData, yVar, writeData, antiData);
                    }
                } else if (postWriteCallBackData != null) {
                    if (StringUtils.isNull(postWriteCallBackData.getErrorString())) {
                        c.this.jRK.showToast(false, c.this.jRK.getContext().getResources().getString(R.string.input_vcode_error));
                    } else {
                        c.this.jRK.showToast(false, postWriteCallBackData.getErrorString());
                    }
                    c.this.cyH();
                }
            }
        }
    };

    public c(NewVcodeView newVcodeView, NewWriteModel newWriteModel) {
        this.jRK = newVcodeView;
        this.jOl = newWriteModel;
        this.jOl.b(this.cHf);
    }

    @Override // com.baidu.tieba.write.vcode.newVcode.a.b
    public boolean c(WebView webView, String str) {
        if (str.contains("objc:jsChangeVcode")) {
            this.jRN = com.baidu.tbadk.v.a.qu(str);
            if (this.jRN != null && this.jOl.clc() != null) {
                this.jRK.runJsMethod(this.jRN, "'" + this.jOl.clc().getVcodeUrl() + "'");
                return true;
            }
            return false;
        } else if (str.equals("objc:jumpToFeedback()")) {
            WriteActivityConfig writeActivityConfig = new WriteActivityConfig(this.jRK.getContext().getActivity(), 0, TbConfig.getPositionPagerId(), TbConfig.getPositionPagerName(), null, null, 0, null, RequestResponseCode.REQUEST_WRITE_NEW, true, false, null, false, false, null, null, null, 0);
            writeActivityConfig.setIsVcodeFeedBack();
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, writeActivityConfig));
            return true;
        } else if (str.contains("objc:jsSubmit")) {
            return FG(com.baidu.tbadk.v.a.qu(str));
        } else {
            return false;
        }
    }

    @Override // com.baidu.tieba.write.vcode.newVcode.a.b
    public void onPageFinished(WebView webView, String str) {
        if (this.jRK != null) {
            this.jRK.showWebViewDelay(500);
            if (this.jRP) {
                e.fZ().postDelayed(this.jRR, 500L);
            }
        }
    }

    @Override // com.baidu.tieba.write.vcode.newVcode.a.b
    public void A(boolean z, String str) {
        this.jRP = z;
        this.jRQ = str;
    }

    @Override // com.baidu.tieba.write.vcode.newVcode.a.b
    public void start(boolean z) {
        this.jRK.setRatio(1.2631578f);
        this.jRK.showWebView(false);
        String str = TbConfig.SERVER_ADDRESS_WEB_VIEW + Config.NEW_VCODE_WEBVIEW_ADDRESS;
        if (z) {
            str = str + "?feedback=1";
        }
        this.jRK.getWebView().loadUrl(str);
    }

    @Override // com.baidu.tieba.write.vcode.newVcode.a.b
    public void onDestroy() {
        e.fZ().removeCallbacks(this.jRR);
    }

    @Override // com.baidu.tieba.write.vcode.newVcode.a.b
    public void d(NewWriteModel.d dVar) {
        this.jRL = dVar;
    }

    @Override // com.baidu.tieba.write.vcode.newVcode.a.b
    public void cxZ() {
        this.jRK.showPostThreadLoadingView(false);
        this.jOl.cancelLoadData();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cyH() {
        this.jRK.runJsMethod(this.jRO, "'" + this.jOl.clc().getVcodeUrl() + "'");
    }

    private boolean FG(String str) {
        String[] split;
        if (StringUtils.isNull(str) || (split = str.split(Constants.ACCEPT_TIME_SEPARATOR_SP)) == null || split.length != 2) {
            return false;
        }
        this.jRO = split[0];
        FF(split[1]);
        return true;
    }

    private void FF(String str) {
        this.jOm = false;
        if (!l.isNetOk()) {
            this.jRK.getContext().showToast(R.string.neterror);
            this.jRK.getContext().finish();
        } else if (!StringUtils.isNull(str)) {
            this.jRK.showPostThreadLoadingView(true);
            this.jOl.clc().setVcode(str);
            this.jOl.clc().setVcodeType("4");
            this.jOl.cpE();
        } else {
            this.jRK.getContext().showToast(R.string.neterror);
            this.jRK.getContext().finish();
        }
    }
}
