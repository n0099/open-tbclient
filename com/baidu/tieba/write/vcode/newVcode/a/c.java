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
/* loaded from: classes3.dex */
public class c implements b {
    private final NewWriteModel nUF;
    private final NewVcodeView nYF;
    private NewWriteModel.d nYG;
    private String nYI;
    private String nYJ;
    private boolean nYK = false;
    private String nYL = null;
    private boolean nUG = false;
    private Runnable nYM = new Runnable() { // from class: com.baidu.tieba.write.vcode.newVcode.a.c.1
        @Override // java.lang.Runnable
        public void run() {
            if (c.this.nYF != null) {
                if (StringUtils.isNull(c.this.nYL)) {
                    c.this.nYF.showToast(false, c.this.nYF.getContext().getResources().getString(R.string.drag_vcode_error));
                } else {
                    c.this.nYF.showToast(false, c.this.nYL);
                }
            }
        }
    };
    private final NewWriteModel.d fwI = new NewWriteModel.d() { // from class: com.baidu.tieba.write.vcode.newVcode.a.c.2
        @Override // com.baidu.tieba.tbadkCore.writeModel.NewWriteModel.d
        public void callback(boolean z, PostWriteCallBackData postWriteCallBackData, ah ahVar, WriteData writeData, AntiData antiData) {
            String str;
            String str2 = null;
            if (c.this.nYF != null) {
                c.this.nYF.showPostThreadLoadingView(false);
                if (z) {
                    c.this.nUG = true;
                    if (writeData != null && writeData.getVideoReviewType() == 1) {
                        c.this.nYF.showToast(true, c.this.nYF.getContext().getResources().getString(R.string.video_send_success_under_review));
                    } else if (writeData != null && writeData.getVideoReviewType() == 2) {
                        c.this.nYF.showToast(true, c.this.nYF.getContext().getResources().getString(R.string.video_send_success));
                    } else if (writeData != null) {
                        String string = c.this.nYF.getContext().getResources().getString(R.string.send_success);
                        if (postWriteCallBackData != null) {
                            str = postWriteCallBackData.getPreMsg();
                            str2 = postWriteCallBackData.getColorMsg();
                            string = postWriteCallBackData.getErrorString();
                        } else {
                            str = null;
                        }
                        if (writeData.getType() != 7) {
                            com.baidu.tieba.tbadkCore.writeModel.c.h(c.this.nYF.getContext().getActivity(), string, str, str2);
                        }
                    }
                    Intent intent = new Intent();
                    Bundle bundle = new Bundle();
                    bundle.putSerializable("post_write_callback_data", postWriteCallBackData);
                    intent.putExtras(bundle);
                    BaseActivity context = c.this.nYF.getContext();
                    c.this.nYF.getContext();
                    context.setResult(-1, intent);
                    c.this.nYF.getContext().finish();
                } else if (postWriteCallBackData != null && postWriteCallBackData.getErrorCode() == 227001) {
                    c.this.nYF.getContext().setVisible(false);
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AccountAccessActivityConfig(c.this.nYF.getContext().getActivity(), RequestResponseCode.REQUEST_VCODE, writeData, postWriteCallBackData.getAccessState())));
                } else if (postWriteCallBackData != null && postWriteCallBackData.getErrorCode() == 220015 && c.this.nYG != null) {
                    if (c.this.nYG != null) {
                        c.this.nYG.callback(z, postWriteCallBackData, ahVar, writeData, antiData);
                    }
                } else if (postWriteCallBackData != null) {
                    if (StringUtils.isNull(postWriteCallBackData.getErrorString())) {
                        c.this.nYF.showToast(false, c.this.nYF.getContext().getResources().getString(R.string.input_vcode_error));
                    } else {
                        c.this.nYF.showToast(false, postWriteCallBackData.getErrorString());
                    }
                    c.this.dZA();
                }
            }
        }
    };

    public c(NewVcodeView newVcodeView, NewWriteModel newWriteModel) {
        this.nYF = newVcodeView;
        this.nUF = newWriteModel;
        this.nUF.b(this.fwI);
    }

    @Override // com.baidu.tieba.write.vcode.newVcode.a.b
    public boolean c(WebView webView, String str) {
        if (str.contains("objc:jsChangeVcode")) {
            this.nYI = com.baidu.tbadk.t.a.ER(str);
            if (this.nYI != null && this.nUF.dcE() != null) {
                this.nYF.runJsMethod(this.nYI, "'" + this.nUF.dcE().getVcodeUrl() + "'");
                return true;
            }
            return false;
        } else if (str.equals("objc:jumpToFeedback()")) {
            WriteActivityConfig writeActivityConfig = new WriteActivityConfig(this.nYF.getContext().getActivity(), 0, TbConfig.getPositionPagerId(), TbConfig.getPositionPagerName(), null, null, 0, null, RequestResponseCode.REQUEST_WRITE_NEW, true, false, null, false, false, null, null, null, 0);
            writeActivityConfig.setIsVcodeFeedBack();
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, writeActivityConfig));
            return true;
        } else if (str.contains("objc:jsSubmit")) {
            return VO(com.baidu.tbadk.t.a.ER(str));
        } else {
            return false;
        }
    }

    @Override // com.baidu.tieba.write.vcode.newVcode.a.b
    public void onPageFinished(WebView webView, String str) {
        if (this.nYF != null) {
            this.nYF.showWebViewDelay(500);
            if (this.nYK) {
                e.mY().postDelayed(this.nYM, 500L);
            }
        }
    }

    @Override // com.baidu.tieba.write.vcode.newVcode.a.b
    public void H(boolean z, String str) {
        this.nYK = z;
        this.nYL = str;
    }

    @Override // com.baidu.tieba.write.vcode.newVcode.a.b
    public void start(boolean z) {
        this.nYF.setRatio(1.2631578f);
        this.nYF.showWebView(false);
        String str = TbConfig.SERVER_ADDRESS_WEB_VIEW + Config.NEW_VCODE_WEBVIEW_ADDRESS;
        if (z) {
            str = str + "?feedback=1";
        }
        this.nYF.getWebView().loadUrl(str);
    }

    @Override // com.baidu.tieba.write.vcode.newVcode.a.b
    public void onDestroy() {
        e.mY().removeCallbacks(this.nYM);
    }

    @Override // com.baidu.tieba.write.vcode.newVcode.a.b
    public void d(NewWriteModel.d dVar) {
        this.nYG = dVar;
    }

    @Override // com.baidu.tieba.write.vcode.newVcode.a.b
    public void dYF() {
        this.nYF.showPostThreadLoadingView(false);
        this.nUF.cancelLoadData();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dZA() {
        this.nYF.runJsMethod(this.nYJ, "'" + this.nUF.dcE().getVcodeUrl() + "'");
    }

    private boolean VO(String str) {
        String[] split;
        if (StringUtils.isNull(str) || (split = str.split(",")) == null || split.length != 2) {
            return false;
        }
        this.nYJ = split[0];
        VN(split[1]);
        return true;
    }

    private void VN(String str) {
        this.nUG = false;
        if (!l.isNetOk()) {
            this.nYF.getContext().showToast(R.string.neterror);
            this.nYF.getContext().finish();
        } else if (!StringUtils.isNull(str)) {
            this.nYF.showPostThreadLoadingView(true);
            this.nUF.dcE().setVcode(str);
            this.nUF.dcE().setVcodeType("4");
            this.nUF.dQE();
        } else {
            this.nYF.getContext().showToast(R.string.neterror);
            this.nYF.getContext().finish();
        }
    }
}
