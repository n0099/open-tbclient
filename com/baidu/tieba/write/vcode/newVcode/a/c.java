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
    private final NewWriteModel nTu;
    private final NewVcodeView nWS;
    private NewWriteModel.d nWT;
    private String nWV;
    private String nWW;
    private boolean nWX = false;
    private String nWY = null;
    private boolean nTv = false;
    private Runnable nWZ = new Runnable() { // from class: com.baidu.tieba.write.vcode.newVcode.a.c.1
        @Override // java.lang.Runnable
        public void run() {
            if (c.this.nWS != null) {
                if (StringUtils.isNull(c.this.nWY)) {
                    c.this.nWS.showToast(false, c.this.nWS.getContext().getResources().getString(R.string.drag_vcode_error));
                } else {
                    c.this.nWS.showToast(false, c.this.nWY);
                }
            }
        }
    };
    private final NewWriteModel.d fBH = new NewWriteModel.d() { // from class: com.baidu.tieba.write.vcode.newVcode.a.c.2
        @Override // com.baidu.tieba.tbadkCore.writeModel.NewWriteModel.d
        public void callback(boolean z, PostWriteCallBackData postWriteCallBackData, ah ahVar, WriteData writeData, AntiData antiData) {
            String str;
            String str2;
            if (c.this.nWS != null) {
                c.this.nWS.showPostThreadLoadingView(false);
                if (z) {
                    c.this.nTv = true;
                    if (writeData != null && writeData.getVideoReviewType() == 1) {
                        c.this.nWS.showToast(true, c.this.nWS.getContext().getResources().getString(R.string.video_send_success_under_review));
                    } else if (writeData != null && writeData.getVideoReviewType() == 2) {
                        c.this.nWS.showToast(true, c.this.nWS.getContext().getResources().getString(R.string.video_send_success));
                    } else if (writeData != null) {
                        String string = c.this.nWS.getContext().getResources().getString(R.string.send_success);
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
                            g.i(c.this.nWS.getContext().getActivity(), string, str2, str);
                        }
                    }
                    Intent intent = new Intent();
                    Bundle bundle = new Bundle();
                    bundle.putSerializable("post_write_callback_data", postWriteCallBackData);
                    intent.putExtras(bundle);
                    BaseActivity context = c.this.nWS.getContext();
                    c.this.nWS.getContext();
                    context.setResult(-1, intent);
                    c.this.nWS.getContext().finish();
                } else if (postWriteCallBackData != null && postWriteCallBackData.getErrorCode() == 227001) {
                    c.this.nWS.getContext().setVisible(false);
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AccountAccessActivityConfig(c.this.nWS.getContext().getActivity(), RequestResponseCode.REQUEST_VCODE, writeData, postWriteCallBackData.getAccessState())));
                } else if (postWriteCallBackData != null && postWriteCallBackData.getErrorCode() == 220015 && c.this.nWT != null) {
                    if (c.this.nWT != null) {
                        c.this.nWT.callback(z, postWriteCallBackData, ahVar, writeData, antiData);
                    }
                } else if (postWriteCallBackData != null) {
                    if (StringUtils.isNull(postWriteCallBackData.getErrorString())) {
                        c.this.nWS.showToast(false, c.this.nWS.getContext().getResources().getString(R.string.input_vcode_error));
                    } else {
                        c.this.nWS.showToast(false, postWriteCallBackData.getErrorString());
                    }
                    c.this.dVg();
                }
            }
        }
    };

    public c(NewVcodeView newVcodeView, NewWriteModel newWriteModel) {
        this.nWS = newVcodeView;
        this.nTu = newWriteModel;
        this.nTu.b(this.fBH);
    }

    @Override // com.baidu.tieba.write.vcode.newVcode.a.b
    public boolean c(WebView webView, String str) {
        if (str.contains("objc:jsChangeVcode")) {
            this.nWV = com.baidu.tbadk.t.a.DD(str);
            if (this.nWV == null || this.nTu.cYx() == null) {
                return false;
            }
            this.nWS.runJsMethod(this.nWV, "'" + this.nTu.cYx().getVcodeUrl() + "'");
            return true;
        } else if (str.equals("objc:jumpToFeedback()")) {
            if (WriteActivityConfig.isAsyncWriting()) {
                return false;
            }
            WriteActivityConfig.newInstance(this.nWS.getContext()).setType(0).setForumId(TbConfig.getPositionPagerId()).setForumName(TbConfig.getPositionPagerName()).setIsVcodeFeedBack().send();
            return true;
        } else if (str.contains("objc:jsSubmit")) {
            return Uh(com.baidu.tbadk.t.a.DD(str));
        } else {
            return false;
        }
    }

    @Override // com.baidu.tieba.write.vcode.newVcode.a.b
    public void onPageFinished(WebView webView, String str) {
        if (this.nWS != null) {
            this.nWS.showWebViewDelay(500);
            if (this.nWX) {
                e.mB().postDelayed(this.nWZ, 500L);
            }
        }
    }

    @Override // com.baidu.tieba.write.vcode.newVcode.a.b
    public void H(boolean z, String str) {
        this.nWX = z;
        this.nWY = str;
    }

    @Override // com.baidu.tieba.write.vcode.newVcode.a.b
    public void start(boolean z) {
        this.nWS.setRatio(1.2631578f);
        this.nWS.showWebView(false);
        String str = TbConfig.SERVER_ADDRESS_WEB_VIEW + Config.NEW_VCODE_WEBVIEW_ADDRESS;
        if (z) {
            str = str + "?feedback=1";
        }
        this.nWS.getWebView().loadUrl(str);
    }

    @Override // com.baidu.tieba.write.vcode.newVcode.a.b
    public void onDestroy() {
        e.mB().removeCallbacks(this.nWZ);
    }

    @Override // com.baidu.tieba.write.vcode.newVcode.a.b
    public void d(NewWriteModel.d dVar) {
        this.nWT = dVar;
    }

    @Override // com.baidu.tieba.write.vcode.newVcode.a.b
    public void dUs() {
        this.nWS.showPostThreadLoadingView(false);
        this.nTu.cancelLoadData();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dVg() {
        this.nWS.runJsMethod(this.nWW, "'" + this.nTu.cYx().getVcodeUrl() + "'");
    }

    private boolean Uh(String str) {
        String[] split;
        if (StringUtils.isNull(str) || (split = str.split(",")) == null || split.length != 2) {
            return false;
        }
        this.nWW = split[0];
        Ug(split[1]);
        return true;
    }

    private void Ug(String str) {
        this.nTv = false;
        if (!l.isNetOk()) {
            this.nWS.getContext().showToast(R.string.neterror);
            this.nWS.getContext().finish();
        } else if (!StringUtils.isNull(str)) {
            this.nWS.showPostThreadLoadingView(true);
            this.nTu.cYx().setVcode(str);
            this.nTu.cYx().setVcodeType("4");
            this.nTu.dMK();
        } else {
            this.nWS.getContext().showToast(R.string.neterror);
            this.nWS.getContext().finish();
        }
    }
}
