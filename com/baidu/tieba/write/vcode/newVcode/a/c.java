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
    private final NewWriteModel mXd;
    private final NewVcodeView nbe;
    private NewWriteModel.d nbf;
    private String nbh;
    private String nbi;
    private boolean nbj = false;
    private String nbk = null;
    private boolean mXe = false;
    private Runnable nbl = new Runnable() { // from class: com.baidu.tieba.write.vcode.newVcode.a.c.1
        @Override // java.lang.Runnable
        public void run() {
            if (c.this.nbe != null) {
                if (StringUtils.isNull(c.this.nbk)) {
                    c.this.nbe.showToast(false, c.this.nbe.getContext().getResources().getString(R.string.drag_vcode_error));
                } else {
                    c.this.nbe.showToast(false, c.this.nbk);
                }
            }
        }
    };
    private final NewWriteModel.d ePy = new NewWriteModel.d() { // from class: com.baidu.tieba.write.vcode.newVcode.a.c.2
        @Override // com.baidu.tieba.tbadkCore.writeModel.NewWriteModel.d
        public void callback(boolean z, PostWriteCallBackData postWriteCallBackData, ah ahVar, WriteData writeData, AntiData antiData) {
            String str;
            String str2 = null;
            if (c.this.nbe != null) {
                c.this.nbe.showPostThreadLoadingView(false);
                if (z) {
                    c.this.mXe = true;
                    if (writeData != null && writeData.getVideoReviewType() == 1) {
                        c.this.nbe.showToast(true, c.this.nbe.getContext().getResources().getString(R.string.video_send_success_under_review));
                    } else if (writeData != null && writeData.getVideoReviewType() == 2) {
                        c.this.nbe.showToast(true, c.this.nbe.getContext().getResources().getString(R.string.video_send_success));
                    } else if (writeData != null) {
                        String string = c.this.nbe.getContext().getResources().getString(R.string.send_success);
                        if (postWriteCallBackData != null) {
                            str = postWriteCallBackData.getPreMsg();
                            str2 = postWriteCallBackData.getColorMsg();
                            string = postWriteCallBackData.getErrorString();
                        } else {
                            str = null;
                        }
                        if (writeData.getType() != 7) {
                            com.baidu.tieba.tbadkCore.writeModel.c.g(c.this.nbe.getContext().getActivity(), string, str, str2);
                        }
                    }
                    Intent intent = new Intent();
                    Bundle bundle = new Bundle();
                    bundle.putSerializable("post_write_callback_data", postWriteCallBackData);
                    intent.putExtras(bundle);
                    BaseActivity context = c.this.nbe.getContext();
                    c.this.nbe.getContext();
                    context.setResult(-1, intent);
                    c.this.nbe.getContext().finish();
                } else if (postWriteCallBackData != null && postWriteCallBackData.getErrorCode() == 227001) {
                    c.this.nbe.getContext().setVisible(false);
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AccountAccessActivityConfig(c.this.nbe.getContext().getActivity(), RequestResponseCode.REQUEST_VCODE, writeData, postWriteCallBackData.getAccessState())));
                } else if (postWriteCallBackData != null && postWriteCallBackData.getErrorCode() == 220015 && c.this.nbf != null) {
                    if (c.this.nbf != null) {
                        c.this.nbf.callback(z, postWriteCallBackData, ahVar, writeData, antiData);
                    }
                } else if (postWriteCallBackData != null) {
                    if (StringUtils.isNull(postWriteCallBackData.getErrorString())) {
                        c.this.nbe.showToast(false, c.this.nbe.getContext().getResources().getString(R.string.input_vcode_error));
                    } else {
                        c.this.nbe.showToast(false, postWriteCallBackData.getErrorString());
                    }
                    c.this.dKM();
                }
            }
        }
    };

    public c(NewVcodeView newVcodeView, NewWriteModel newWriteModel) {
        this.nbe = newVcodeView;
        this.mXd = newWriteModel;
        this.mXd.b(this.ePy);
    }

    @Override // com.baidu.tieba.write.vcode.newVcode.a.b
    public boolean b(WebView webView, String str) {
        if (str.contains("objc:jsChangeVcode")) {
            this.nbh = com.baidu.tbadk.t.a.Dk(str);
            if (this.nbh != null && this.mXd.cOG() != null) {
                this.nbe.runJsMethod(this.nbh, "'" + this.mXd.cOG().getVcodeUrl() + "'");
                return true;
            }
            return false;
        } else if (str.equals("objc:jumpToFeedback()")) {
            WriteActivityConfig writeActivityConfig = new WriteActivityConfig(this.nbe.getContext().getActivity(), 0, TbConfig.getPositionPagerId(), TbConfig.getPositionPagerName(), null, null, 0, null, RequestResponseCode.REQUEST_WRITE_NEW, true, false, null, false, false, null, null, null, 0);
            writeActivityConfig.setIsVcodeFeedBack();
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, writeActivityConfig));
            return true;
        } else if (str.contains("objc:jsSubmit")) {
            return Tk(com.baidu.tbadk.t.a.Dk(str));
        } else {
            return false;
        }
    }

    @Override // com.baidu.tieba.write.vcode.newVcode.a.b
    public void onPageFinished(WebView webView, String str) {
        if (this.nbe != null) {
            this.nbe.showWebViewDelay(500);
            if (this.nbj) {
                e.mX().postDelayed(this.nbl, 500L);
            }
        }
    }

    @Override // com.baidu.tieba.write.vcode.newVcode.a.b
    public void E(boolean z, String str) {
        this.nbj = z;
        this.nbk = str;
    }

    @Override // com.baidu.tieba.write.vcode.newVcode.a.b
    public void start(boolean z) {
        this.nbe.setRatio(1.2631578f);
        this.nbe.showWebView(false);
        String str = TbConfig.SERVER_ADDRESS_WEB_VIEW + Config.NEW_VCODE_WEBVIEW_ADDRESS;
        if (z) {
            str = str + "?feedback=1";
        }
        this.nbe.getWebView().loadUrl(str);
    }

    @Override // com.baidu.tieba.write.vcode.newVcode.a.b
    public void onDestroy() {
        e.mX().removeCallbacks(this.nbl);
    }

    @Override // com.baidu.tieba.write.vcode.newVcode.a.b
    public void d(NewWriteModel.d dVar) {
        this.nbf = dVar;
    }

    @Override // com.baidu.tieba.write.vcode.newVcode.a.b
    public void dJR() {
        this.nbe.showPostThreadLoadingView(false);
        this.mXd.cancelLoadData();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dKM() {
        this.nbe.runJsMethod(this.nbi, "'" + this.mXd.cOG().getVcodeUrl() + "'");
    }

    private boolean Tk(String str) {
        String[] split;
        if (StringUtils.isNull(str) || (split = str.split(Constants.ACCEPT_TIME_SEPARATOR_SP)) == null || split.length != 2) {
            return false;
        }
        this.nbi = split[0];
        Tj(split[1]);
        return true;
    }

    private void Tj(String str) {
        this.mXe = false;
        if (!l.isNetOk()) {
            this.nbe.getContext().showToast(R.string.neterror);
            this.nbe.getContext().finish();
        } else if (!StringUtils.isNull(str)) {
            this.nbe.showPostThreadLoadingView(true);
            this.mXd.cOG().setVcode(str);
            this.mXd.cOG().setVcodeType("4");
            this.mXd.dBQ();
        } else {
            this.nbe.getContext().showToast(R.string.neterror);
            this.nbe.getContext().finish();
        }
    }
}
