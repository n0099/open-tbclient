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
import com.baidu.tieba.tbadkCore.writeModel.g;
import com.baidu.tieba.write.vcode.newVcode.NewVcodeView;
/* loaded from: classes8.dex */
public class c implements b {
    private final NewWriteModel oeb;
    private NewWriteModel.d ohA;
    private String ohC;
    private String ohD;
    private final NewVcodeView ohz;
    private boolean ohE = false;
    private String ohF = null;
    private boolean oec = false;
    private Runnable ohG = new Runnable() { // from class: com.baidu.tieba.write.vcode.newVcode.a.c.1
        @Override // java.lang.Runnable
        public void run() {
            if (c.this.ohz != null) {
                if (StringUtils.isNull(c.this.ohF)) {
                    c.this.ohz.showToast(false, c.this.ohz.getContext().getResources().getString(R.string.drag_vcode_error));
                } else {
                    c.this.ohz.showToast(false, c.this.ohF);
                }
            }
        }
    };
    private final NewWriteModel.d fDW = new NewWriteModel.d() { // from class: com.baidu.tieba.write.vcode.newVcode.a.c.2
        @Override // com.baidu.tieba.tbadkCore.writeModel.NewWriteModel.d
        public void callback(boolean z, PostWriteCallBackData postWriteCallBackData, ah ahVar, WriteData writeData, AntiData antiData) {
            String str;
            String str2;
            if (c.this.ohz != null) {
                c.this.ohz.showPostThreadLoadingView(false);
                if (z) {
                    c.this.oec = true;
                    if (writeData != null && writeData.getVideoReviewType() == 1) {
                        c.this.ohz.showToast(true, c.this.ohz.getContext().getResources().getString(R.string.video_send_success_under_review));
                    } else if (writeData != null && writeData.getVideoReviewType() == 2) {
                        c.this.ohz.showToast(true, c.this.ohz.getContext().getResources().getString(R.string.video_send_success));
                    } else if (writeData != null) {
                        String string = c.this.ohz.getContext().getResources().getString(R.string.send_success);
                        if (postWriteCallBackData != null) {
                            String preMsg = postWriteCallBackData.getPreMsg();
                            str = postWriteCallBackData.getColorMsg();
                            string = postWriteCallBackData.getErrorString();
                            str2 = preMsg;
                        } else {
                            str = null;
                            str2 = null;
                        }
                        if (writeData.getType() != 7) {
                            g.j(c.this.ohz.getContext().getActivity(), string, str2, str);
                        }
                    }
                    Intent intent = new Intent();
                    Bundle bundle = new Bundle();
                    bundle.putSerializable("post_write_callback_data", postWriteCallBackData);
                    intent.putExtras(bundle);
                    BaseActivity context = c.this.ohz.getContext();
                    c.this.ohz.getContext();
                    context.setResult(-1, intent);
                    c.this.ohz.getContext().finish();
                } else if (postWriteCallBackData != null && postWriteCallBackData.getErrorCode() == 227001) {
                    c.this.ohz.getContext().setVisible(false);
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AccountAccessActivityConfig(c.this.ohz.getContext().getActivity(), RequestResponseCode.REQUEST_VCODE, writeData, postWriteCallBackData.getAccessState())));
                } else if (postWriteCallBackData != null && postWriteCallBackData.getErrorCode() == 220015 && c.this.ohA != null) {
                    if (c.this.ohA != null) {
                        c.this.ohA.callback(z, postWriteCallBackData, ahVar, writeData, antiData);
                    }
                } else if (postWriteCallBackData != null) {
                    if (StringUtils.isNull(postWriteCallBackData.getErrorString())) {
                        c.this.ohz.showToast(false, c.this.ohz.getContext().getResources().getString(R.string.input_vcode_error));
                    } else {
                        c.this.ohz.showToast(false, postWriteCallBackData.getErrorString());
                    }
                    c.this.dXC();
                }
            }
        }
    };

    public c(NewVcodeView newVcodeView, NewWriteModel newWriteModel) {
        this.ohz = newVcodeView;
        this.oeb = newWriteModel;
        this.oeb.b(this.fDW);
    }

    @Override // com.baidu.tieba.write.vcode.newVcode.a.b
    public boolean c(WebView webView, String str) {
        if (str.contains("objc:jsChangeVcode")) {
            this.ohC = com.baidu.tbadk.t.a.DX(str);
            if (this.ohC == null || this.oeb.daC() == null) {
                return false;
            }
            this.ohz.runJsMethod(this.ohC, "'" + this.oeb.daC().getVcodeUrl() + "'");
            return true;
        } else if (str.equals("objc:jumpToFeedback()")) {
            if (WriteActivityConfig.isAsyncWriting()) {
                return false;
            }
            WriteActivityConfig.newInstance(this.ohz.getContext()).setType(0).setForumId(TbConfig.getPositionPagerId()).setForumName(TbConfig.getPositionPagerName()).setIsVcodeFeedBack().send();
            return true;
        } else if (str.contains("objc:jsSubmit")) {
            return Vs(com.baidu.tbadk.t.a.DX(str));
        } else {
            return false;
        }
    }

    @Override // com.baidu.tieba.write.vcode.newVcode.a.b
    public void onPageFinished(WebView webView, String str) {
        if (this.ohz != null) {
            this.ohz.showWebViewDelay(500);
            if (this.ohE) {
                e.mA().postDelayed(this.ohG, 500L);
            }
        }
    }

    @Override // com.baidu.tieba.write.vcode.newVcode.a.b
    public void P(boolean z, String str) {
        this.ohE = z;
        this.ohF = str;
    }

    @Override // com.baidu.tieba.write.vcode.newVcode.a.b
    public void start(boolean z) {
        this.ohz.setRatio(1.2631578f);
        this.ohz.showWebView(false);
        String str = TbConfig.SERVER_ADDRESS_WEB_VIEW + Config.NEW_VCODE_WEBVIEW_ADDRESS;
        if (z) {
            str = str + "?feedback=1";
        }
        this.ohz.getWebView().loadUrl(str);
    }

    @Override // com.baidu.tieba.write.vcode.newVcode.a.b
    public void onDestroy() {
        e.mA().removeCallbacks(this.ohG);
    }

    @Override // com.baidu.tieba.write.vcode.newVcode.a.b
    public void d(NewWriteModel.d dVar) {
        this.ohA = dVar;
    }

    @Override // com.baidu.tieba.write.vcode.newVcode.a.b
    public void dWO() {
        this.ohz.showPostThreadLoadingView(false);
        this.oeb.cancelLoadData();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dXC() {
        this.ohz.runJsMethod(this.ohD, "'" + this.oeb.daC().getVcodeUrl() + "'");
    }

    private boolean Vs(String str) {
        String[] split;
        if (StringUtils.isNull(str) || (split = str.split(",")) == null || split.length != 2) {
            return false;
        }
        this.ohD = split[0];
        Vr(split[1]);
        return true;
    }

    private void Vr(String str) {
        this.oec = false;
        if (!l.isNetOk()) {
            this.ohz.getContext().showToast(R.string.neterror);
            this.ohz.getContext().finish();
        } else if (!StringUtils.isNull(str)) {
            this.ohz.showPostThreadLoadingView(true);
            this.oeb.daC().setVcode(str);
            this.oeb.daC().setVcodeType("4");
            this.oeb.dPd();
        } else {
            this.ohz.getContext().showToast(R.string.neterror);
            this.ohz.getContext().finish();
        }
    }
}
