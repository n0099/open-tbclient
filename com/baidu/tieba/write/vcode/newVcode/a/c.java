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
    private final NewVcodeView lBH;
    private NewWriteModel.d lBI;
    private String lBK;
    private String lBL;
    private final NewWriteModel lxM;
    private boolean lBM = false;
    private String lBN = null;
    private boolean lxN = false;
    private Runnable lBO = new Runnable() { // from class: com.baidu.tieba.write.vcode.newVcode.a.c.1
        @Override // java.lang.Runnable
        public void run() {
            if (c.this.lBH != null) {
                if (StringUtils.isNull(c.this.lBN)) {
                    c.this.lBH.showToast(false, c.this.lBH.getContext().getResources().getString(R.string.drag_vcode_error));
                } else {
                    c.this.lBH.showToast(false, c.this.lBN);
                }
            }
        }
    };
    private final NewWriteModel.d dYM = new NewWriteModel.d() { // from class: com.baidu.tieba.write.vcode.newVcode.a.c.2
        @Override // com.baidu.tieba.tbadkCore.writeModel.NewWriteModel.d
        public void callback(boolean z, PostWriteCallBackData postWriteCallBackData, aa aaVar, WriteData writeData, AntiData antiData) {
            String str;
            String str2 = null;
            if (c.this.lBH != null) {
                c.this.lBH.showPostThreadLoadingView(false);
                if (z) {
                    c.this.lxN = true;
                    if (writeData != null && writeData.getVideoReviewType() == 1) {
                        c.this.lBH.showToast(true, c.this.lBH.getContext().getResources().getString(R.string.video_send_success_under_review));
                    } else if (writeData != null && writeData.getVideoReviewType() == 2) {
                        c.this.lBH.showToast(true, c.this.lBH.getContext().getResources().getString(R.string.video_send_success));
                    } else if (writeData != null) {
                        String string = c.this.lBH.getContext().getResources().getString(R.string.send_success);
                        if (postWriteCallBackData != null) {
                            str = postWriteCallBackData.getPreMsg();
                            str2 = postWriteCallBackData.getColorMsg();
                            string = postWriteCallBackData.getErrorString();
                        } else {
                            str = null;
                        }
                        if (writeData.getType() != 7) {
                            com.baidu.tieba.tbadkCore.writeModel.c.g(c.this.lBH.getContext().getActivity(), string, str, str2);
                        }
                    }
                    Intent intent = new Intent();
                    Bundle bundle = new Bundle();
                    bundle.putSerializable("post_write_callback_data", postWriteCallBackData);
                    intent.putExtras(bundle);
                    BaseActivity context = c.this.lBH.getContext();
                    c.this.lBH.getContext();
                    context.setResult(-1, intent);
                    c.this.lBH.getContext().finish();
                } else if (postWriteCallBackData != null && postWriteCallBackData.getErrorCode() == 227001) {
                    c.this.lBH.getContext().setVisible(false);
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AccountAccessActivityConfig(c.this.lBH.getContext().getActivity(), RequestResponseCode.REQUEST_VCODE, writeData, postWriteCallBackData.getAccessState())));
                } else if (postWriteCallBackData != null && postWriteCallBackData.getErrorCode() == 220015 && c.this.lBI != null) {
                    if (c.this.lBI != null) {
                        c.this.lBI.callback(z, postWriteCallBackData, aaVar, writeData, antiData);
                    }
                } else if (postWriteCallBackData != null) {
                    if (StringUtils.isNull(postWriteCallBackData.getErrorString())) {
                        c.this.lBH.showToast(false, c.this.lBH.getContext().getResources().getString(R.string.input_vcode_error));
                    } else {
                        c.this.lBH.showToast(false, postWriteCallBackData.getErrorString());
                    }
                    c.this.dgc();
                }
            }
        }
    };

    public c(NewVcodeView newVcodeView, NewWriteModel newWriteModel) {
        this.lBH = newVcodeView;
        this.lxM = newWriteModel;
        this.lxM.b(this.dYM);
    }

    @Override // com.baidu.tieba.write.vcode.newVcode.a.b
    public boolean c(WebView webView, String str) {
        if (str.contains("objc:jsChangeVcode")) {
            this.lBK = com.baidu.tbadk.s.a.xq(str);
            if (this.lBK != null && this.lxM.cSK() != null) {
                this.lBH.runJsMethod(this.lBK, "'" + this.lxM.cSK().getVcodeUrl() + "'");
                return true;
            }
            return false;
        } else if (str.equals("objc:jumpToFeedback()")) {
            WriteActivityConfig writeActivityConfig = new WriteActivityConfig(this.lBH.getContext().getActivity(), 0, TbConfig.getPositionPagerId(), TbConfig.getPositionPagerName(), null, null, 0, null, RequestResponseCode.REQUEST_WRITE_NEW, true, false, null, false, false, null, null, null, 0);
            writeActivityConfig.setIsVcodeFeedBack();
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, writeActivityConfig));
            return true;
        } else if (str.contains("objc:jsSubmit")) {
            return MF(com.baidu.tbadk.s.a.xq(str));
        } else {
            return false;
        }
    }

    @Override // com.baidu.tieba.write.vcode.newVcode.a.b
    public void onPageFinished(WebView webView, String str) {
        if (this.lBH != null) {
            this.lBH.showWebViewDelay(500);
            if (this.lBM) {
                e.lb().postDelayed(this.lBO, 500L);
            }
        }
    }

    @Override // com.baidu.tieba.write.vcode.newVcode.a.b
    public void B(boolean z, String str) {
        this.lBM = z;
        this.lBN = str;
    }

    @Override // com.baidu.tieba.write.vcode.newVcode.a.b
    public void start(boolean z) {
        this.lBH.setRatio(1.2631578f);
        this.lBH.showWebView(false);
        String str = TbConfig.SERVER_ADDRESS_WEB_VIEW + Config.NEW_VCODE_WEBVIEW_ADDRESS;
        if (z) {
            str = str + "?feedback=1";
        }
        this.lBH.getWebView().loadUrl(str);
    }

    @Override // com.baidu.tieba.write.vcode.newVcode.a.b
    public void onDestroy() {
        e.lb().removeCallbacks(this.lBO);
    }

    @Override // com.baidu.tieba.write.vcode.newVcode.a.b
    public void d(NewWriteModel.d dVar) {
        this.lBI = dVar;
    }

    @Override // com.baidu.tieba.write.vcode.newVcode.a.b
    public void dfi() {
        this.lBH.showPostThreadLoadingView(false);
        this.lxM.cancelLoadData();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dgc() {
        this.lBH.runJsMethod(this.lBL, "'" + this.lxM.cSK().getVcodeUrl() + "'");
    }

    private boolean MF(String str) {
        String[] split;
        if (StringUtils.isNull(str) || (split = str.split(Constants.ACCEPT_TIME_SEPARATOR_SP)) == null || split.length != 2) {
            return false;
        }
        this.lBL = split[0];
        ME(split[1]);
        return true;
    }

    private void ME(String str) {
        this.lxN = false;
        if (!l.isNetOk()) {
            this.lBH.getContext().showToast(R.string.neterror);
            this.lBH.getContext().finish();
        } else if (!StringUtils.isNull(str)) {
            this.lBH.showPostThreadLoadingView(true);
            this.lxM.cSK().setVcode(str);
            this.lxM.cSK().setVcodeType("4");
            this.lxM.cXy();
        } else {
            this.lBH.getContext().showToast(R.string.neterror);
            this.lBH.getContext().finish();
        }
    }
}
