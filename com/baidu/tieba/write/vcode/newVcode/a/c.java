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
/* loaded from: classes3.dex */
public class c implements b {
    private final NewWriteModel muy;
    private final NewVcodeView myC;
    private NewWriteModel.d myD;
    private String myF;
    private String myG;
    private boolean myH = false;
    private String myI = null;
    private boolean muz = false;
    private Runnable myJ = new Runnable() { // from class: com.baidu.tieba.write.vcode.newVcode.a.c.1
        @Override // java.lang.Runnable
        public void run() {
            if (c.this.myC != null) {
                if (StringUtils.isNull(c.this.myI)) {
                    c.this.myC.showToast(false, c.this.myC.getContext().getResources().getString(R.string.drag_vcode_error));
                } else {
                    c.this.myC.showToast(false, c.this.myI);
                }
            }
        }
    };
    private final NewWriteModel.d eCe = new NewWriteModel.d() { // from class: com.baidu.tieba.write.vcode.newVcode.a.c.2
        @Override // com.baidu.tieba.tbadkCore.writeModel.NewWriteModel.d
        public void callback(boolean z, PostWriteCallBackData postWriteCallBackData, ad adVar, WriteData writeData, AntiData antiData) {
            String str;
            String str2 = null;
            if (c.this.myC != null) {
                c.this.myC.showPostThreadLoadingView(false);
                if (z) {
                    c.this.muz = true;
                    if (writeData != null && writeData.getVideoReviewType() == 1) {
                        c.this.myC.showToast(true, c.this.myC.getContext().getResources().getString(R.string.video_send_success_under_review));
                    } else if (writeData != null && writeData.getVideoReviewType() == 2) {
                        c.this.myC.showToast(true, c.this.myC.getContext().getResources().getString(R.string.video_send_success));
                    } else if (writeData != null) {
                        String string = c.this.myC.getContext().getResources().getString(R.string.send_success);
                        if (postWriteCallBackData != null) {
                            str = postWriteCallBackData.getPreMsg();
                            str2 = postWriteCallBackData.getColorMsg();
                            string = postWriteCallBackData.getErrorString();
                        } else {
                            str = null;
                        }
                        if (writeData.getType() != 7) {
                            com.baidu.tieba.tbadkCore.writeModel.c.f(c.this.myC.getContext().getActivity(), string, str, str2);
                        }
                    }
                    Intent intent = new Intent();
                    Bundle bundle = new Bundle();
                    bundle.putSerializable("post_write_callback_data", postWriteCallBackData);
                    intent.putExtras(bundle);
                    BaseActivity context = c.this.myC.getContext();
                    c.this.myC.getContext();
                    context.setResult(-1, intent);
                    c.this.myC.getContext().finish();
                } else if (postWriteCallBackData != null && postWriteCallBackData.getErrorCode() == 227001) {
                    c.this.myC.getContext().setVisible(false);
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AccountAccessActivityConfig(c.this.myC.getContext().getActivity(), RequestResponseCode.REQUEST_VCODE, writeData, postWriteCallBackData.getAccessState())));
                } else if (postWriteCallBackData != null && postWriteCallBackData.getErrorCode() == 220015 && c.this.myD != null) {
                    if (c.this.myD != null) {
                        c.this.myD.callback(z, postWriteCallBackData, adVar, writeData, antiData);
                    }
                } else if (postWriteCallBackData != null) {
                    if (StringUtils.isNull(postWriteCallBackData.getErrorString())) {
                        c.this.myC.showToast(false, c.this.myC.getContext().getResources().getString(R.string.input_vcode_error));
                    } else {
                        c.this.myC.showToast(false, postWriteCallBackData.getErrorString());
                    }
                    c.this.dvm();
                }
            }
        }
    };

    public c(NewVcodeView newVcodeView, NewWriteModel newWriteModel) {
        this.myC = newVcodeView;
        this.muy = newWriteModel;
        this.muy.b(this.eCe);
    }

    @Override // com.baidu.tieba.write.vcode.newVcode.a.b
    public boolean c(WebView webView, String str) {
        if (str.contains("objc:jsChangeVcode")) {
            this.myF = com.baidu.tbadk.t.a.Ax(str);
            if (this.myF != null && this.muy.dhF() != null) {
                this.myC.runJsMethod(this.myF, "'" + this.muy.dhF().getVcodeUrl() + "'");
                return true;
            }
            return false;
        } else if (str.equals("objc:jumpToFeedback()")) {
            WriteActivityConfig writeActivityConfig = new WriteActivityConfig(this.myC.getContext().getActivity(), 0, TbConfig.getPositionPagerId(), TbConfig.getPositionPagerName(), null, null, 0, null, RequestResponseCode.REQUEST_WRITE_NEW, true, false, null, false, false, null, null, null, 0);
            writeActivityConfig.setIsVcodeFeedBack();
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, writeActivityConfig));
            return true;
        } else if (str.contains("objc:jsSubmit")) {
            return PM(com.baidu.tbadk.t.a.Ax(str));
        } else {
            return false;
        }
    }

    @Override // com.baidu.tieba.write.vcode.newVcode.a.b
    public void onPageFinished(WebView webView, String str) {
        if (this.myC != null) {
            this.myC.showWebViewDelay(500);
            if (this.myH) {
                e.lt().postDelayed(this.myJ, 500L);
            }
        }
    }

    @Override // com.baidu.tieba.write.vcode.newVcode.a.b
    public void D(boolean z, String str) {
        this.myH = z;
        this.myI = str;
    }

    @Override // com.baidu.tieba.write.vcode.newVcode.a.b
    public void start(boolean z) {
        this.myC.setRatio(1.2631578f);
        this.myC.showWebView(false);
        String str = TbConfig.SERVER_ADDRESS_WEB_VIEW + Config.NEW_VCODE_WEBVIEW_ADDRESS;
        if (z) {
            str = str + "?feedback=1";
        }
        this.myC.getWebView().loadUrl(str);
    }

    @Override // com.baidu.tieba.write.vcode.newVcode.a.b
    public void onDestroy() {
        e.lt().removeCallbacks(this.myJ);
    }

    @Override // com.baidu.tieba.write.vcode.newVcode.a.b
    public void d(NewWriteModel.d dVar) {
        this.myD = dVar;
    }

    @Override // com.baidu.tieba.write.vcode.newVcode.a.b
    public void dur() {
        this.myC.showPostThreadLoadingView(false);
        this.muy.cancelLoadData();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dvm() {
        this.myC.runJsMethod(this.myG, "'" + this.muy.dhF().getVcodeUrl() + "'");
    }

    private boolean PM(String str) {
        String[] split;
        if (StringUtils.isNull(str) || (split = str.split(Constants.ACCEPT_TIME_SEPARATOR_SP)) == null || split.length != 2) {
            return false;
        }
        this.myG = split[0];
        PL(split[1]);
        return true;
    }

    private void PL(String str) {
        this.muz = false;
        if (!l.isNetOk()) {
            this.myC.getContext().showToast(R.string.neterror);
            this.myC.getContext().finish();
        } else if (!StringUtils.isNull(str)) {
            this.myC.showPostThreadLoadingView(true);
            this.muy.dhF().setVcode(str);
            this.muy.dhF().setVcodeType("4");
            this.muy.dmw();
        } else {
            this.myC.getContext().showToast(R.string.neterror);
            this.myC.getContext().finish();
        }
    }
}
