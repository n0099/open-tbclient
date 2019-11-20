package com.baidu.tieba.write.vcode.newVcode.a;

import android.content.Intent;
import android.os.Bundle;
import android.webkit.WebView;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.lib.g.e;
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
import com.baidu.tbadk.coreExtra.data.y;
import com.baidu.tieba.R;
import com.baidu.tieba.tbadkCore.writeModel.NewWriteModel;
import com.baidu.tieba.tbadkCore.writeModel.PostWriteCallBackData;
import com.baidu.tieba.write.vcode.newVcode.NewVcodeView;
import com.xiaomi.mipush.sdk.Constants;
/* loaded from: classes3.dex */
public class c implements b {
    private final NewWriteModel jNu;
    private final NewVcodeView jQT;
    private NewWriteModel.d jQU;
    private String jQW;
    private String jQX;
    private boolean jQY = false;
    private String jQZ = null;
    private boolean jNv = false;
    private Runnable jRa = new Runnable() { // from class: com.baidu.tieba.write.vcode.newVcode.a.c.1
        @Override // java.lang.Runnable
        public void run() {
            if (c.this.jQT != null) {
                if (StringUtils.isNull(c.this.jQZ)) {
                    c.this.jQT.showToast(false, c.this.jQT.getContext().getResources().getString(R.string.drag_vcode_error));
                } else {
                    c.this.jQT.showToast(false, c.this.jQZ);
                }
            }
        }
    };
    private final NewWriteModel.d cGo = new NewWriteModel.d() { // from class: com.baidu.tieba.write.vcode.newVcode.a.c.2
        @Override // com.baidu.tieba.tbadkCore.writeModel.NewWriteModel.d
        public void callback(boolean z, PostWriteCallBackData postWriteCallBackData, y yVar, WriteData writeData, AntiData antiData) {
            String str;
            String str2 = null;
            if (c.this.jQT != null) {
                c.this.jQT.showPostThreadLoadingView(false);
                if (z) {
                    c.this.jNv = true;
                    if (writeData != null && writeData.getVideoReviewType() == 1) {
                        c.this.jQT.showToast(true, c.this.jQT.getContext().getResources().getString(R.string.video_send_success_under_review));
                    } else if (writeData != null && writeData.getVideoReviewType() == 2) {
                        c.this.jQT.showToast(true, c.this.jQT.getContext().getResources().getString(R.string.video_send_success));
                    } else if (writeData != null) {
                        String string = c.this.jQT.getContext().getResources().getString(R.string.send_success);
                        if (postWriteCallBackData != null) {
                            str = postWriteCallBackData.getPreMsg();
                            str2 = postWriteCallBackData.getColorMsg();
                            string = postWriteCallBackData.getErrorString();
                        } else {
                            str = null;
                        }
                        if (writeData.getType() != 7) {
                            com.baidu.tieba.tbadkCore.writeModel.c.g(c.this.jQT.getContext().getActivity(), string, str, str2);
                        }
                    }
                    Intent intent = new Intent();
                    Bundle bundle = new Bundle();
                    bundle.putSerializable("post_write_callback_data", postWriteCallBackData);
                    intent.putExtras(bundle);
                    BaseActivity context = c.this.jQT.getContext();
                    c.this.jQT.getContext();
                    context.setResult(-1, intent);
                    c.this.jQT.getContext().finish();
                } else if (postWriteCallBackData != null && postWriteCallBackData.getErrorCode() == 227001) {
                    c.this.jQT.getContext().setVisible(false);
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AccountAccessActivityConfig(c.this.jQT.getContext().getActivity(), RequestResponseCode.REQUEST_VCODE, writeData, postWriteCallBackData.getAccessState())));
                } else if (postWriteCallBackData != null && postWriteCallBackData.getErrorCode() == 220015 && c.this.jQU != null) {
                    if (c.this.jQU != null) {
                        c.this.jQU.callback(z, postWriteCallBackData, yVar, writeData, antiData);
                    }
                } else if (postWriteCallBackData != null) {
                    if (StringUtils.isNull(postWriteCallBackData.getErrorString())) {
                        c.this.jQT.showToast(false, c.this.jQT.getContext().getResources().getString(R.string.input_vcode_error));
                    } else {
                        c.this.jQT.showToast(false, postWriteCallBackData.getErrorString());
                    }
                    c.this.cyF();
                }
            }
        }
    };

    public c(NewVcodeView newVcodeView, NewWriteModel newWriteModel) {
        this.jQT = newVcodeView;
        this.jNu = newWriteModel;
        this.jNu.b(this.cGo);
    }

    @Override // com.baidu.tieba.write.vcode.newVcode.a.b
    public boolean c(WebView webView, String str) {
        if (str.contains("objc:jsChangeVcode")) {
            this.jQW = com.baidu.tbadk.v.a.qu(str);
            if (this.jQW != null && this.jNu.cla() != null) {
                this.jQT.runJsMethod(this.jQW, "'" + this.jNu.cla().getVcodeUrl() + "'");
                return true;
            }
            return false;
        } else if (str.equals("objc:jumpToFeedback()")) {
            WriteActivityConfig writeActivityConfig = new WriteActivityConfig(this.jQT.getContext().getActivity(), 0, TbConfig.getPositionPagerId(), TbConfig.getPositionPagerName(), null, null, 0, null, RequestResponseCode.REQUEST_WRITE_NEW, true, false, null, false, false, null, null, null, 0);
            writeActivityConfig.setIsVcodeFeedBack();
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, writeActivityConfig));
            return true;
        } else if (str.contains("objc:jsSubmit")) {
            return FG(com.baidu.tbadk.v.a.qu(str));
        } else {
            return false;
        }
    }

    @Override // com.baidu.tieba.write.vcode.newVcode.a.b
    public void onPageFinished(WebView webView, String str) {
        if (this.jQT != null) {
            this.jQT.showWebViewDelay(500);
            if (this.jQY) {
                e.fZ().postDelayed(this.jRa, 500L);
            }
        }
    }

    @Override // com.baidu.tieba.write.vcode.newVcode.a.b
    public void A(boolean z, String str) {
        this.jQY = z;
        this.jQZ = str;
    }

    @Override // com.baidu.tieba.write.vcode.newVcode.a.b
    public void start(boolean z) {
        this.jQT.setRatio(1.2631578f);
        this.jQT.showWebView(false);
        String str = TbConfig.SERVER_ADDRESS_WEB_VIEW + Config.NEW_VCODE_WEBVIEW_ADDRESS;
        if (z) {
            str = str + "?feedback=1";
        }
        this.jQT.getWebView().loadUrl(str);
    }

    @Override // com.baidu.tieba.write.vcode.newVcode.a.b
    public void onDestroy() {
        e.fZ().removeCallbacks(this.jRa);
    }

    @Override // com.baidu.tieba.write.vcode.newVcode.a.b
    public void d(NewWriteModel.d dVar) {
        this.jQU = dVar;
    }

    @Override // com.baidu.tieba.write.vcode.newVcode.a.b
    public void cxX() {
        this.jQT.showPostThreadLoadingView(false);
        this.jNu.cancelLoadData();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cyF() {
        this.jQT.runJsMethod(this.jQX, "'" + this.jNu.cla().getVcodeUrl() + "'");
    }

    private boolean FG(String str) {
        String[] split;
        if (StringUtils.isNull(str) || (split = str.split(Constants.ACCEPT_TIME_SEPARATOR_SP)) == null || split.length != 2) {
            return false;
        }
        this.jQX = split[0];
        FF(split[1]);
        return true;
    }

    private void FF(String str) {
        this.jNv = false;
        if (!l.isNetOk()) {
            this.jQT.getContext().showToast(R.string.neterror);
            this.jQT.getContext().finish();
        } else if (!StringUtils.isNull(str)) {
            this.jQT.showPostThreadLoadingView(true);
            this.jNu.cla().setVcode(str);
            this.jNu.cla().setVcodeType("4");
            this.jNu.cpC();
        } else {
            this.jQT.getContext().showToast(R.string.neterror);
            this.jQT.getContext().finish();
        }
    }
}
