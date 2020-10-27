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
    private final NewVcodeView nDc;
    private NewWriteModel.d nDd;
    private String nDf;
    private String nDg;
    private final NewWriteModel nzc;
    private boolean nDh = false;
    private String nDi = null;
    private boolean nzd = false;
    private Runnable nDj = new Runnable() { // from class: com.baidu.tieba.write.vcode.newVcode.a.c.1
        @Override // java.lang.Runnable
        public void run() {
            if (c.this.nDc != null) {
                if (StringUtils.isNull(c.this.nDi)) {
                    c.this.nDc.showToast(false, c.this.nDc.getContext().getResources().getString(R.string.drag_vcode_error));
                } else {
                    c.this.nDc.showToast(false, c.this.nDi);
                }
            }
        }
    };
    private final NewWriteModel.d fke = new NewWriteModel.d() { // from class: com.baidu.tieba.write.vcode.newVcode.a.c.2
        @Override // com.baidu.tieba.tbadkCore.writeModel.NewWriteModel.d
        public void callback(boolean z, PostWriteCallBackData postWriteCallBackData, ah ahVar, WriteData writeData, AntiData antiData) {
            String str;
            String str2 = null;
            if (c.this.nDc != null) {
                c.this.nDc.showPostThreadLoadingView(false);
                if (z) {
                    c.this.nzd = true;
                    if (writeData != null && writeData.getVideoReviewType() == 1) {
                        c.this.nDc.showToast(true, c.this.nDc.getContext().getResources().getString(R.string.video_send_success_under_review));
                    } else if (writeData != null && writeData.getVideoReviewType() == 2) {
                        c.this.nDc.showToast(true, c.this.nDc.getContext().getResources().getString(R.string.video_send_success));
                    } else if (writeData != null) {
                        String string = c.this.nDc.getContext().getResources().getString(R.string.send_success);
                        if (postWriteCallBackData != null) {
                            str = postWriteCallBackData.getPreMsg();
                            str2 = postWriteCallBackData.getColorMsg();
                            string = postWriteCallBackData.getErrorString();
                        } else {
                            str = null;
                        }
                        if (writeData.getType() != 7) {
                            com.baidu.tieba.tbadkCore.writeModel.c.g(c.this.nDc.getContext().getActivity(), string, str, str2);
                        }
                    }
                    Intent intent = new Intent();
                    Bundle bundle = new Bundle();
                    bundle.putSerializable("post_write_callback_data", postWriteCallBackData);
                    intent.putExtras(bundle);
                    BaseActivity context = c.this.nDc.getContext();
                    c.this.nDc.getContext();
                    context.setResult(-1, intent);
                    c.this.nDc.getContext().finish();
                } else if (postWriteCallBackData != null && postWriteCallBackData.getErrorCode() == 227001) {
                    c.this.nDc.getContext().setVisible(false);
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AccountAccessActivityConfig(c.this.nDc.getContext().getActivity(), RequestResponseCode.REQUEST_VCODE, writeData, postWriteCallBackData.getAccessState())));
                } else if (postWriteCallBackData != null && postWriteCallBackData.getErrorCode() == 220015 && c.this.nDd != null) {
                    if (c.this.nDd != null) {
                        c.this.nDd.callback(z, postWriteCallBackData, ahVar, writeData, antiData);
                    }
                } else if (postWriteCallBackData != null) {
                    if (StringUtils.isNull(postWriteCallBackData.getErrorString())) {
                        c.this.nDc.showToast(false, c.this.nDc.getContext().getResources().getString(R.string.input_vcode_error));
                    } else {
                        c.this.nDc.showToast(false, postWriteCallBackData.getErrorString());
                    }
                    c.this.dRG();
                }
            }
        }
    };

    public c(NewVcodeView newVcodeView, NewWriteModel newWriteModel) {
        this.nDc = newVcodeView;
        this.nzc = newWriteModel;
        this.nzc.b(this.fke);
    }

    @Override // com.baidu.tieba.write.vcode.newVcode.a.b
    public boolean b(WebView webView, String str) {
        if (str.contains("objc:jsChangeVcode")) {
            this.nDf = com.baidu.tbadk.t.a.Ep(str);
            if (this.nDf != null && this.nzc.cVv() != null) {
                this.nDc.runJsMethod(this.nDf, "'" + this.nzc.cVv().getVcodeUrl() + "'");
                return true;
            }
            return false;
        } else if (str.equals("objc:jumpToFeedback()")) {
            WriteActivityConfig writeActivityConfig = new WriteActivityConfig(this.nDc.getContext().getActivity(), 0, TbConfig.getPositionPagerId(), TbConfig.getPositionPagerName(), null, null, 0, null, RequestResponseCode.REQUEST_WRITE_NEW, true, false, null, false, false, null, null, null, 0);
            writeActivityConfig.setIsVcodeFeedBack();
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, writeActivityConfig));
            return true;
        } else if (str.contains("objc:jsSubmit")) {
            return Ux(com.baidu.tbadk.t.a.Ep(str));
        } else {
            return false;
        }
    }

    @Override // com.baidu.tieba.write.vcode.newVcode.a.b
    public void onPageFinished(WebView webView, String str) {
        if (this.nDc != null) {
            this.nDc.showWebViewDelay(500);
            if (this.nDh) {
                e.mY().postDelayed(this.nDj, 500L);
            }
        }
    }

    @Override // com.baidu.tieba.write.vcode.newVcode.a.b
    public void G(boolean z, String str) {
        this.nDh = z;
        this.nDi = str;
    }

    @Override // com.baidu.tieba.write.vcode.newVcode.a.b
    public void start(boolean z) {
        this.nDc.setRatio(1.2631578f);
        this.nDc.showWebView(false);
        String str = TbConfig.SERVER_ADDRESS_WEB_VIEW + Config.NEW_VCODE_WEBVIEW_ADDRESS;
        if (z) {
            str = str + "?feedback=1";
        }
        this.nDc.getWebView().loadUrl(str);
    }

    @Override // com.baidu.tieba.write.vcode.newVcode.a.b
    public void onDestroy() {
        e.mY().removeCallbacks(this.nDj);
    }

    @Override // com.baidu.tieba.write.vcode.newVcode.a.b
    public void d(NewWriteModel.d dVar) {
        this.nDd = dVar;
    }

    @Override // com.baidu.tieba.write.vcode.newVcode.a.b
    public void dQL() {
        this.nDc.showPostThreadLoadingView(false);
        this.nzc.cancelLoadData();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dRG() {
        this.nDc.runJsMethod(this.nDg, "'" + this.nzc.cVv().getVcodeUrl() + "'");
    }

    private boolean Ux(String str) {
        String[] split;
        if (StringUtils.isNull(str) || (split = str.split(Constants.ACCEPT_TIME_SEPARATOR_SP)) == null || split.length != 2) {
            return false;
        }
        this.nDg = split[0];
        Uw(split[1]);
        return true;
    }

    private void Uw(String str) {
        this.nzd = false;
        if (!l.isNetOk()) {
            this.nDc.getContext().showToast(R.string.neterror);
            this.nDc.getContext().finish();
        } else if (!StringUtils.isNull(str)) {
            this.nDc.showPostThreadLoadingView(true);
            this.nzc.cVv().setVcode(str);
            this.nzc.cVv().setVcodeType("4");
            this.nzc.dIK();
        } else {
            this.nDc.getContext().showToast(R.string.neterror);
            this.nDc.getContext().finish();
        }
    }
}
