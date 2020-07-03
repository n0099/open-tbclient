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
import com.baidu.tbadk.coreExtra.data.ad;
import com.baidu.tieba.R;
import com.baidu.tieba.tbadkCore.writeModel.NewWriteModel;
import com.baidu.tieba.tbadkCore.writeModel.PostWriteCallBackData;
import com.baidu.tieba.write.vcode.newVcode.NewVcodeView;
import com.xiaomi.mipush.sdk.Constants;
/* loaded from: classes2.dex */
public class c implements b {
    private final NewWriteModel mmv;
    private final NewVcodeView mqA;
    private NewWriteModel.d mqB;
    private String mqD;
    private String mqE;
    private boolean mqF = false;
    private String mqG = null;
    private boolean mmw = false;
    private Runnable mqH = new Runnable() { // from class: com.baidu.tieba.write.vcode.newVcode.a.c.1
        @Override // java.lang.Runnable
        public void run() {
            if (c.this.mqA != null) {
                if (StringUtils.isNull(c.this.mqG)) {
                    c.this.mqA.showToast(false, c.this.mqA.getContext().getResources().getString(R.string.drag_vcode_error));
                } else {
                    c.this.mqA.showToast(false, c.this.mqG);
                }
            }
        }
    };
    private final NewWriteModel.d evL = new NewWriteModel.d() { // from class: com.baidu.tieba.write.vcode.newVcode.a.c.2
        @Override // com.baidu.tieba.tbadkCore.writeModel.NewWriteModel.d
        public void callback(boolean z, PostWriteCallBackData postWriteCallBackData, ad adVar, WriteData writeData, AntiData antiData) {
            String str;
            String str2 = null;
            if (c.this.mqA != null) {
                c.this.mqA.showPostThreadLoadingView(false);
                if (z) {
                    c.this.mmw = true;
                    if (writeData != null && writeData.getVideoReviewType() == 1) {
                        c.this.mqA.showToast(true, c.this.mqA.getContext().getResources().getString(R.string.video_send_success_under_review));
                    } else if (writeData != null && writeData.getVideoReviewType() == 2) {
                        c.this.mqA.showToast(true, c.this.mqA.getContext().getResources().getString(R.string.video_send_success));
                    } else if (writeData != null) {
                        String string = c.this.mqA.getContext().getResources().getString(R.string.send_success);
                        if (postWriteCallBackData != null) {
                            str = postWriteCallBackData.getPreMsg();
                            str2 = postWriteCallBackData.getColorMsg();
                            string = postWriteCallBackData.getErrorString();
                        } else {
                            str = null;
                        }
                        if (writeData.getType() != 7) {
                            com.baidu.tieba.tbadkCore.writeModel.c.f(c.this.mqA.getContext().getActivity(), string, str, str2);
                        }
                    }
                    Intent intent = new Intent();
                    Bundle bundle = new Bundle();
                    bundle.putSerializable("post_write_callback_data", postWriteCallBackData);
                    intent.putExtras(bundle);
                    BaseActivity context = c.this.mqA.getContext();
                    c.this.mqA.getContext();
                    context.setResult(-1, intent);
                    c.this.mqA.getContext().finish();
                } else if (postWriteCallBackData != null && postWriteCallBackData.getErrorCode() == 227001) {
                    c.this.mqA.getContext().setVisible(false);
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AccountAccessActivityConfig(c.this.mqA.getContext().getActivity(), RequestResponseCode.REQUEST_VCODE, writeData, postWriteCallBackData.getAccessState())));
                } else if (postWriteCallBackData != null && postWriteCallBackData.getErrorCode() == 220015 && c.this.mqB != null) {
                    if (c.this.mqB != null) {
                        c.this.mqB.callback(z, postWriteCallBackData, adVar, writeData, antiData);
                    }
                } else if (postWriteCallBackData != null) {
                    if (StringUtils.isNull(postWriteCallBackData.getErrorString())) {
                        c.this.mqA.showToast(false, c.this.mqA.getContext().getResources().getString(R.string.input_vcode_error));
                    } else {
                        c.this.mqA.showToast(false, postWriteCallBackData.getErrorString());
                    }
                    c.this.drW();
                }
            }
        }
    };

    public c(NewVcodeView newVcodeView, NewWriteModel newWriteModel) {
        this.mqA = newVcodeView;
        this.mmv = newWriteModel;
        this.mmv.b(this.evL);
    }

    @Override // com.baidu.tieba.write.vcode.newVcode.a.b
    public boolean c(WebView webView, String str) {
        if (str.contains("objc:jsChangeVcode")) {
            this.mqD = com.baidu.tbadk.t.a.zp(str);
            if (this.mqD != null && this.mmv.dev() != null) {
                this.mqA.runJsMethod(this.mqD, "'" + this.mmv.dev().getVcodeUrl() + "'");
                return true;
            }
            return false;
        } else if (str.equals("objc:jumpToFeedback()")) {
            WriteActivityConfig writeActivityConfig = new WriteActivityConfig(this.mqA.getContext().getActivity(), 0, TbConfig.getPositionPagerId(), TbConfig.getPositionPagerName(), null, null, 0, null, RequestResponseCode.REQUEST_WRITE_NEW, true, false, null, false, false, null, null, null, 0);
            writeActivityConfig.setIsVcodeFeedBack();
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, writeActivityConfig));
            return true;
        } else if (str.contains("objc:jsSubmit")) {
            return Pa(com.baidu.tbadk.t.a.zp(str));
        } else {
            return false;
        }
    }

    @Override // com.baidu.tieba.write.vcode.newVcode.a.b
    public void onPageFinished(WebView webView, String str) {
        if (this.mqA != null) {
            this.mqA.showWebViewDelay(500);
            if (this.mqF) {
                e.lt().postDelayed(this.mqH, 500L);
            }
        }
    }

    @Override // com.baidu.tieba.write.vcode.newVcode.a.b
    public void D(boolean z, String str) {
        this.mqF = z;
        this.mqG = str;
    }

    @Override // com.baidu.tieba.write.vcode.newVcode.a.b
    public void start(boolean z) {
        this.mqA.setRatio(1.2631578f);
        this.mqA.showWebView(false);
        String str = TbConfig.SERVER_ADDRESS_WEB_VIEW + Config.NEW_VCODE_WEBVIEW_ADDRESS;
        if (z) {
            str = str + "?feedback=1";
        }
        this.mqA.getWebView().loadUrl(str);
    }

    @Override // com.baidu.tieba.write.vcode.newVcode.a.b
    public void onDestroy() {
        e.lt().removeCallbacks(this.mqH);
    }

    @Override // com.baidu.tieba.write.vcode.newVcode.a.b
    public void d(NewWriteModel.d dVar) {
        this.mqB = dVar;
    }

    @Override // com.baidu.tieba.write.vcode.newVcode.a.b
    public void drb() {
        this.mqA.showPostThreadLoadingView(false);
        this.mmv.cancelLoadData();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void drW() {
        this.mqA.runJsMethod(this.mqE, "'" + this.mmv.dev().getVcodeUrl() + "'");
    }

    private boolean Pa(String str) {
        String[] split;
        if (StringUtils.isNull(str) || (split = str.split(Constants.ACCEPT_TIME_SEPARATOR_SP)) == null || split.length != 2) {
            return false;
        }
        this.mqE = split[0];
        OZ(split[1]);
        return true;
    }

    private void OZ(String str) {
        this.mmw = false;
        if (!l.isNetOk()) {
            this.mqA.getContext().showToast(R.string.neterror);
            this.mqA.getContext().finish();
        } else if (!StringUtils.isNull(str)) {
            this.mqA.showPostThreadLoadingView(true);
            this.mmv.dev().setVcode(str);
            this.mmv.dev().setVcodeType("4");
            this.mmv.djn();
        } else {
            this.mqA.getContext().showToast(R.string.neterror);
            this.mqA.getContext().finish();
        }
    }
}
