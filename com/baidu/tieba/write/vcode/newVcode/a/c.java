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
    private final NewWriteModel nmB;
    private final NewVcodeView nqD;
    private NewWriteModel.d nqE;
    private String nqG;
    private String nqH;
    private boolean nqI = false;
    private String nqJ = null;
    private boolean nmC = false;
    private Runnable nqK = new Runnable() { // from class: com.baidu.tieba.write.vcode.newVcode.a.c.1
        @Override // java.lang.Runnable
        public void run() {
            if (c.this.nqD != null) {
                if (StringUtils.isNull(c.this.nqJ)) {
                    c.this.nqD.showToast(false, c.this.nqD.getContext().getResources().getString(R.string.drag_vcode_error));
                } else {
                    c.this.nqD.showToast(false, c.this.nqJ);
                }
            }
        }
    };
    private final NewWriteModel.d fbF = new NewWriteModel.d() { // from class: com.baidu.tieba.write.vcode.newVcode.a.c.2
        @Override // com.baidu.tieba.tbadkCore.writeModel.NewWriteModel.d
        public void callback(boolean z, PostWriteCallBackData postWriteCallBackData, ah ahVar, WriteData writeData, AntiData antiData) {
            String str;
            String str2 = null;
            if (c.this.nqD != null) {
                c.this.nqD.showPostThreadLoadingView(false);
                if (z) {
                    c.this.nmC = true;
                    if (writeData != null && writeData.getVideoReviewType() == 1) {
                        c.this.nqD.showToast(true, c.this.nqD.getContext().getResources().getString(R.string.video_send_success_under_review));
                    } else if (writeData != null && writeData.getVideoReviewType() == 2) {
                        c.this.nqD.showToast(true, c.this.nqD.getContext().getResources().getString(R.string.video_send_success));
                    } else if (writeData != null) {
                        String string = c.this.nqD.getContext().getResources().getString(R.string.send_success);
                        if (postWriteCallBackData != null) {
                            str = postWriteCallBackData.getPreMsg();
                            str2 = postWriteCallBackData.getColorMsg();
                            string = postWriteCallBackData.getErrorString();
                        } else {
                            str = null;
                        }
                        if (writeData.getType() != 7) {
                            com.baidu.tieba.tbadkCore.writeModel.c.g(c.this.nqD.getContext().getActivity(), string, str, str2);
                        }
                    }
                    Intent intent = new Intent();
                    Bundle bundle = new Bundle();
                    bundle.putSerializable("post_write_callback_data", postWriteCallBackData);
                    intent.putExtras(bundle);
                    BaseActivity context = c.this.nqD.getContext();
                    c.this.nqD.getContext();
                    context.setResult(-1, intent);
                    c.this.nqD.getContext().finish();
                } else if (postWriteCallBackData != null && postWriteCallBackData.getErrorCode() == 227001) {
                    c.this.nqD.getContext().setVisible(false);
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AccountAccessActivityConfig(c.this.nqD.getContext().getActivity(), RequestResponseCode.REQUEST_VCODE, writeData, postWriteCallBackData.getAccessState())));
                } else if (postWriteCallBackData != null && postWriteCallBackData.getErrorCode() == 220015 && c.this.nqE != null) {
                    if (c.this.nqE != null) {
                        c.this.nqE.callback(z, postWriteCallBackData, ahVar, writeData, antiData);
                    }
                } else if (postWriteCallBackData != null) {
                    if (StringUtils.isNull(postWriteCallBackData.getErrorString())) {
                        c.this.nqD.showToast(false, c.this.nqD.getContext().getResources().getString(R.string.input_vcode_error));
                    } else {
                        c.this.nqD.showToast(false, postWriteCallBackData.getErrorString());
                    }
                    c.this.dOy();
                }
            }
        }
    };

    public c(NewVcodeView newVcodeView, NewWriteModel newWriteModel) {
        this.nqD = newVcodeView;
        this.nmB = newWriteModel;
        this.nmB.b(this.fbF);
    }

    @Override // com.baidu.tieba.write.vcode.newVcode.a.b
    public boolean b(WebView webView, String str) {
        if (str.contains("objc:jsChangeVcode")) {
            this.nqG = com.baidu.tbadk.t.a.DW(str);
            if (this.nqG != null && this.nmB.cSo() != null) {
                this.nqD.runJsMethod(this.nqG, "'" + this.nmB.cSo().getVcodeUrl() + "'");
                return true;
            }
            return false;
        } else if (str.equals("objc:jumpToFeedback()")) {
            WriteActivityConfig writeActivityConfig = new WriteActivityConfig(this.nqD.getContext().getActivity(), 0, TbConfig.getPositionPagerId(), TbConfig.getPositionPagerName(), null, null, 0, null, RequestResponseCode.REQUEST_WRITE_NEW, true, false, null, false, false, null, null, null, 0);
            writeActivityConfig.setIsVcodeFeedBack();
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, writeActivityConfig));
            return true;
        } else if (str.contains("objc:jsSubmit")) {
            return TY(com.baidu.tbadk.t.a.DW(str));
        } else {
            return false;
        }
    }

    @Override // com.baidu.tieba.write.vcode.newVcode.a.b
    public void onPageFinished(WebView webView, String str) {
        if (this.nqD != null) {
            this.nqD.showWebViewDelay(500);
            if (this.nqI) {
                e.mY().postDelayed(this.nqK, 500L);
            }
        }
    }

    @Override // com.baidu.tieba.write.vcode.newVcode.a.b
    public void E(boolean z, String str) {
        this.nqI = z;
        this.nqJ = str;
    }

    @Override // com.baidu.tieba.write.vcode.newVcode.a.b
    public void start(boolean z) {
        this.nqD.setRatio(1.2631578f);
        this.nqD.showWebView(false);
        String str = TbConfig.SERVER_ADDRESS_WEB_VIEW + Config.NEW_VCODE_WEBVIEW_ADDRESS;
        if (z) {
            str = str + "?feedback=1";
        }
        this.nqD.getWebView().loadUrl(str);
    }

    @Override // com.baidu.tieba.write.vcode.newVcode.a.b
    public void onDestroy() {
        e.mY().removeCallbacks(this.nqK);
    }

    @Override // com.baidu.tieba.write.vcode.newVcode.a.b
    public void d(NewWriteModel.d dVar) {
        this.nqE = dVar;
    }

    @Override // com.baidu.tieba.write.vcode.newVcode.a.b
    public void dND() {
        this.nqD.showPostThreadLoadingView(false);
        this.nmB.cancelLoadData();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dOy() {
        this.nqD.runJsMethod(this.nqH, "'" + this.nmB.cSo().getVcodeUrl() + "'");
    }

    private boolean TY(String str) {
        String[] split;
        if (StringUtils.isNull(str) || (split = str.split(Constants.ACCEPT_TIME_SEPARATOR_SP)) == null || split.length != 2) {
            return false;
        }
        this.nqH = split[0];
        TX(split[1]);
        return true;
    }

    private void TX(String str) {
        this.nmC = false;
        if (!l.isNetOk()) {
            this.nqD.getContext().showToast(R.string.neterror);
            this.nqD.getContext().finish();
        } else if (!StringUtils.isNull(str)) {
            this.nqD.showPostThreadLoadingView(true);
            this.nmB.cSo().setVcode(str);
            this.nmB.cSo().setVcodeType("4");
            this.nmB.dFC();
        } else {
            this.nqD.getContext().showToast(R.string.neterror);
            this.nqD.getContext().finish();
        }
    }
}
