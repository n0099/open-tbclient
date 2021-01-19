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
/* loaded from: classes7.dex */
public class c implements b {
    private final NewWriteModel nTv;
    private final NewVcodeView nWT;
    private NewWriteModel.d nWU;
    private String nWW;
    private String nWX;
    private boolean nWY = false;
    private String nWZ = null;
    private boolean nTw = false;
    private Runnable nXa = new Runnable() { // from class: com.baidu.tieba.write.vcode.newVcode.a.c.1
        @Override // java.lang.Runnable
        public void run() {
            if (c.this.nWT != null) {
                if (StringUtils.isNull(c.this.nWZ)) {
                    c.this.nWT.showToast(false, c.this.nWT.getContext().getResources().getString(R.string.drag_vcode_error));
                } else {
                    c.this.nWT.showToast(false, c.this.nWZ);
                }
            }
        }
    };
    private final NewWriteModel.d fBH = new NewWriteModel.d() { // from class: com.baidu.tieba.write.vcode.newVcode.a.c.2
        @Override // com.baidu.tieba.tbadkCore.writeModel.NewWriteModel.d
        public void callback(boolean z, PostWriteCallBackData postWriteCallBackData, ah ahVar, WriteData writeData, AntiData antiData) {
            String str;
            String str2;
            if (c.this.nWT != null) {
                c.this.nWT.showPostThreadLoadingView(false);
                if (z) {
                    c.this.nTw = true;
                    if (writeData != null && writeData.getVideoReviewType() == 1) {
                        c.this.nWT.showToast(true, c.this.nWT.getContext().getResources().getString(R.string.video_send_success_under_review));
                    } else if (writeData != null && writeData.getVideoReviewType() == 2) {
                        c.this.nWT.showToast(true, c.this.nWT.getContext().getResources().getString(R.string.video_send_success));
                    } else if (writeData != null) {
                        String string = c.this.nWT.getContext().getResources().getString(R.string.send_success);
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
                            g.i(c.this.nWT.getContext().getActivity(), string, str2, str);
                        }
                    }
                    Intent intent = new Intent();
                    Bundle bundle = new Bundle();
                    bundle.putSerializable("post_write_callback_data", postWriteCallBackData);
                    intent.putExtras(bundle);
                    BaseActivity context = c.this.nWT.getContext();
                    c.this.nWT.getContext();
                    context.setResult(-1, intent);
                    c.this.nWT.getContext().finish();
                } else if (postWriteCallBackData != null && postWriteCallBackData.getErrorCode() == 227001) {
                    c.this.nWT.getContext().setVisible(false);
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AccountAccessActivityConfig(c.this.nWT.getContext().getActivity(), RequestResponseCode.REQUEST_VCODE, writeData, postWriteCallBackData.getAccessState())));
                } else if (postWriteCallBackData != null && postWriteCallBackData.getErrorCode() == 220015 && c.this.nWU != null) {
                    if (c.this.nWU != null) {
                        c.this.nWU.callback(z, postWriteCallBackData, ahVar, writeData, antiData);
                    }
                } else if (postWriteCallBackData != null) {
                    if (StringUtils.isNull(postWriteCallBackData.getErrorString())) {
                        c.this.nWT.showToast(false, c.this.nWT.getContext().getResources().getString(R.string.input_vcode_error));
                    } else {
                        c.this.nWT.showToast(false, postWriteCallBackData.getErrorString());
                    }
                    c.this.dVg();
                }
            }
        }
    };

    public c(NewVcodeView newVcodeView, NewWriteModel newWriteModel) {
        this.nWT = newVcodeView;
        this.nTv = newWriteModel;
        this.nTv.b(this.fBH);
    }

    @Override // com.baidu.tieba.write.vcode.newVcode.a.b
    public boolean c(WebView webView, String str) {
        if (str.contains("objc:jsChangeVcode")) {
            this.nWW = com.baidu.tbadk.t.a.DD(str);
            if (this.nWW == null || this.nTv.cYx() == null) {
                return false;
            }
            this.nWT.runJsMethod(this.nWW, "'" + this.nTv.cYx().getVcodeUrl() + "'");
            return true;
        } else if (str.equals("objc:jumpToFeedback()")) {
            if (WriteActivityConfig.isAsyncWriting()) {
                return false;
            }
            WriteActivityConfig.newInstance(this.nWT.getContext()).setType(0).setForumId(TbConfig.getPositionPagerId()).setForumName(TbConfig.getPositionPagerName()).setIsVcodeFeedBack().send();
            return true;
        } else if (str.contains("objc:jsSubmit")) {
            return Ui(com.baidu.tbadk.t.a.DD(str));
        } else {
            return false;
        }
    }

    @Override // com.baidu.tieba.write.vcode.newVcode.a.b
    public void onPageFinished(WebView webView, String str) {
        if (this.nWT != null) {
            this.nWT.showWebViewDelay(500);
            if (this.nWY) {
                e.mB().postDelayed(this.nXa, 500L);
            }
        }
    }

    @Override // com.baidu.tieba.write.vcode.newVcode.a.b
    public void H(boolean z, String str) {
        this.nWY = z;
        this.nWZ = str;
    }

    @Override // com.baidu.tieba.write.vcode.newVcode.a.b
    public void start(boolean z) {
        this.nWT.setRatio(1.2631578f);
        this.nWT.showWebView(false);
        String str = TbConfig.SERVER_ADDRESS_WEB_VIEW + Config.NEW_VCODE_WEBVIEW_ADDRESS;
        if (z) {
            str = str + "?feedback=1";
        }
        this.nWT.getWebView().loadUrl(str);
    }

    @Override // com.baidu.tieba.write.vcode.newVcode.a.b
    public void onDestroy() {
        e.mB().removeCallbacks(this.nXa);
    }

    @Override // com.baidu.tieba.write.vcode.newVcode.a.b
    public void d(NewWriteModel.d dVar) {
        this.nWU = dVar;
    }

    @Override // com.baidu.tieba.write.vcode.newVcode.a.b
    public void dUs() {
        this.nWT.showPostThreadLoadingView(false);
        this.nTv.cancelLoadData();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dVg() {
        this.nWT.runJsMethod(this.nWX, "'" + this.nTv.cYx().getVcodeUrl() + "'");
    }

    private boolean Ui(String str) {
        String[] split;
        if (StringUtils.isNull(str) || (split = str.split(",")) == null || split.length != 2) {
            return false;
        }
        this.nWX = split[0];
        Uh(split[1]);
        return true;
    }

    private void Uh(String str) {
        this.nTw = false;
        if (!l.isNetOk()) {
            this.nWT.getContext().showToast(R.string.neterror);
            this.nWT.getContext().finish();
        } else if (!StringUtils.isNull(str)) {
            this.nWT.showPostThreadLoadingView(true);
            this.nTv.cYx().setVcode(str);
            this.nTv.cYx().setVcodeType("4");
            this.nTv.dMK();
        } else {
            this.nWT.getContext().showToast(R.string.neterror);
            this.nWT.getContext().finish();
        }
    }
}
