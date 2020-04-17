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
/* loaded from: classes2.dex */
public class c implements b {
    private final NewVcodeView lBD;
    private NewWriteModel.d lBE;
    private String lBG;
    private String lBH;
    private final NewWriteModel lxI;
    private boolean lBI = false;
    private String lBJ = null;
    private boolean lxJ = false;
    private Runnable lBK = new Runnable() { // from class: com.baidu.tieba.write.vcode.newVcode.a.c.1
        @Override // java.lang.Runnable
        public void run() {
            if (c.this.lBD != null) {
                if (StringUtils.isNull(c.this.lBJ)) {
                    c.this.lBD.showToast(false, c.this.lBD.getContext().getResources().getString(R.string.drag_vcode_error));
                } else {
                    c.this.lBD.showToast(false, c.this.lBJ);
                }
            }
        }
    };
    private final NewWriteModel.d dYH = new NewWriteModel.d() { // from class: com.baidu.tieba.write.vcode.newVcode.a.c.2
        @Override // com.baidu.tieba.tbadkCore.writeModel.NewWriteModel.d
        public void callback(boolean z, PostWriteCallBackData postWriteCallBackData, aa aaVar, WriteData writeData, AntiData antiData) {
            String str;
            String str2 = null;
            if (c.this.lBD != null) {
                c.this.lBD.showPostThreadLoadingView(false);
                if (z) {
                    c.this.lxJ = true;
                    if (writeData != null && writeData.getVideoReviewType() == 1) {
                        c.this.lBD.showToast(true, c.this.lBD.getContext().getResources().getString(R.string.video_send_success_under_review));
                    } else if (writeData != null && writeData.getVideoReviewType() == 2) {
                        c.this.lBD.showToast(true, c.this.lBD.getContext().getResources().getString(R.string.video_send_success));
                    } else if (writeData != null) {
                        String string = c.this.lBD.getContext().getResources().getString(R.string.send_success);
                        if (postWriteCallBackData != null) {
                            str = postWriteCallBackData.getPreMsg();
                            str2 = postWriteCallBackData.getColorMsg();
                            string = postWriteCallBackData.getErrorString();
                        } else {
                            str = null;
                        }
                        if (writeData.getType() != 7) {
                            com.baidu.tieba.tbadkCore.writeModel.c.g(c.this.lBD.getContext().getActivity(), string, str, str2);
                        }
                    }
                    Intent intent = new Intent();
                    Bundle bundle = new Bundle();
                    bundle.putSerializable("post_write_callback_data", postWriteCallBackData);
                    intent.putExtras(bundle);
                    BaseActivity context = c.this.lBD.getContext();
                    c.this.lBD.getContext();
                    context.setResult(-1, intent);
                    c.this.lBD.getContext().finish();
                } else if (postWriteCallBackData != null && postWriteCallBackData.getErrorCode() == 227001) {
                    c.this.lBD.getContext().setVisible(false);
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AccountAccessActivityConfig(c.this.lBD.getContext().getActivity(), RequestResponseCode.REQUEST_VCODE, writeData, postWriteCallBackData.getAccessState())));
                } else if (postWriteCallBackData != null && postWriteCallBackData.getErrorCode() == 220015 && c.this.lBE != null) {
                    if (c.this.lBE != null) {
                        c.this.lBE.callback(z, postWriteCallBackData, aaVar, writeData, antiData);
                    }
                } else if (postWriteCallBackData != null) {
                    if (StringUtils.isNull(postWriteCallBackData.getErrorString())) {
                        c.this.lBD.showToast(false, c.this.lBD.getContext().getResources().getString(R.string.input_vcode_error));
                    } else {
                        c.this.lBD.showToast(false, postWriteCallBackData.getErrorString());
                    }
                    c.this.dgf();
                }
            }
        }
    };

    public c(NewVcodeView newVcodeView, NewWriteModel newWriteModel) {
        this.lBD = newVcodeView;
        this.lxI = newWriteModel;
        this.lxI.b(this.dYH);
    }

    @Override // com.baidu.tieba.write.vcode.newVcode.a.b
    public boolean c(WebView webView, String str) {
        if (str.contains("objc:jsChangeVcode")) {
            this.lBG = com.baidu.tbadk.s.a.xn(str);
            if (this.lBG != null && this.lxI.cSN() != null) {
                this.lBD.runJsMethod(this.lBG, "'" + this.lxI.cSN().getVcodeUrl() + "'");
                return true;
            }
            return false;
        } else if (str.equals("objc:jumpToFeedback()")) {
            WriteActivityConfig writeActivityConfig = new WriteActivityConfig(this.lBD.getContext().getActivity(), 0, TbConfig.getPositionPagerId(), TbConfig.getPositionPagerName(), null, null, 0, null, RequestResponseCode.REQUEST_WRITE_NEW, true, false, null, false, false, null, null, null, 0);
            writeActivityConfig.setIsVcodeFeedBack();
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, writeActivityConfig));
            return true;
        } else if (str.contains("objc:jsSubmit")) {
            return MC(com.baidu.tbadk.s.a.xn(str));
        } else {
            return false;
        }
    }

    @Override // com.baidu.tieba.write.vcode.newVcode.a.b
    public void onPageFinished(WebView webView, String str) {
        if (this.lBD != null) {
            this.lBD.showWebViewDelay(500);
            if (this.lBI) {
                e.lb().postDelayed(this.lBK, 500L);
            }
        }
    }

    @Override // com.baidu.tieba.write.vcode.newVcode.a.b
    public void B(boolean z, String str) {
        this.lBI = z;
        this.lBJ = str;
    }

    @Override // com.baidu.tieba.write.vcode.newVcode.a.b
    public void start(boolean z) {
        this.lBD.setRatio(1.2631578f);
        this.lBD.showWebView(false);
        String str = TbConfig.SERVER_ADDRESS_WEB_VIEW + Config.NEW_VCODE_WEBVIEW_ADDRESS;
        if (z) {
            str = str + "?feedback=1";
        }
        this.lBD.getWebView().loadUrl(str);
    }

    @Override // com.baidu.tieba.write.vcode.newVcode.a.b
    public void onDestroy() {
        e.lb().removeCallbacks(this.lBK);
    }

    @Override // com.baidu.tieba.write.vcode.newVcode.a.b
    public void d(NewWriteModel.d dVar) {
        this.lBE = dVar;
    }

    @Override // com.baidu.tieba.write.vcode.newVcode.a.b
    public void dfl() {
        this.lBD.showPostThreadLoadingView(false);
        this.lxI.cancelLoadData();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dgf() {
        this.lBD.runJsMethod(this.lBH, "'" + this.lxI.cSN().getVcodeUrl() + "'");
    }

    private boolean MC(String str) {
        String[] split;
        if (StringUtils.isNull(str) || (split = str.split(Constants.ACCEPT_TIME_SEPARATOR_SP)) == null || split.length != 2) {
            return false;
        }
        this.lBH = split[0];
        MB(split[1]);
        return true;
    }

    private void MB(String str) {
        this.lxJ = false;
        if (!l.isNetOk()) {
            this.lBD.getContext().showToast(R.string.neterror);
            this.lBD.getContext().finish();
        } else if (!StringUtils.isNull(str)) {
            this.lBD.showPostThreadLoadingView(true);
            this.lxI.cSN().setVcode(str);
            this.lxI.cSN().setVcodeType("4");
            this.lxI.cXB();
        } else {
            this.lBD.getContext().showToast(R.string.neterror);
            this.lBD.getContext().finish();
        }
    }
}
