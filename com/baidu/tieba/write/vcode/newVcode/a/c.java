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
import com.baidu.tbadk.coreExtra.data.ab;
import com.baidu.tieba.R;
import com.baidu.tieba.tbadkCore.writeModel.NewWriteModel;
import com.baidu.tieba.tbadkCore.writeModel.PostWriteCallBackData;
import com.baidu.tieba.write.vcode.newVcode.NewVcodeView;
import com.xiaomi.mipush.sdk.Constants;
/* loaded from: classes2.dex */
public class c implements b {
    private final NewWriteModel lSm;
    private final NewVcodeView lWg;
    private NewWriteModel.d lWh;
    private String lWj;
    private String lWk;
    private boolean lWl = false;
    private String lWm = null;
    private boolean lSn = false;
    private Runnable lWn = new Runnable() { // from class: com.baidu.tieba.write.vcode.newVcode.a.c.1
        @Override // java.lang.Runnable
        public void run() {
            if (c.this.lWg != null) {
                if (StringUtils.isNull(c.this.lWm)) {
                    c.this.lWg.showToast(false, c.this.lWg.getContext().getResources().getString(R.string.drag_vcode_error));
                } else {
                    c.this.lWg.showToast(false, c.this.lWm);
                }
            }
        }
    };
    private final NewWriteModel.d emV = new NewWriteModel.d() { // from class: com.baidu.tieba.write.vcode.newVcode.a.c.2
        @Override // com.baidu.tieba.tbadkCore.writeModel.NewWriteModel.d
        public void callback(boolean z, PostWriteCallBackData postWriteCallBackData, ab abVar, WriteData writeData, AntiData antiData) {
            String str;
            String str2 = null;
            if (c.this.lWg != null) {
                c.this.lWg.showPostThreadLoadingView(false);
                if (z) {
                    c.this.lSn = true;
                    if (writeData != null && writeData.getVideoReviewType() == 1) {
                        c.this.lWg.showToast(true, c.this.lWg.getContext().getResources().getString(R.string.video_send_success_under_review));
                    } else if (writeData != null && writeData.getVideoReviewType() == 2) {
                        c.this.lWg.showToast(true, c.this.lWg.getContext().getResources().getString(R.string.video_send_success));
                    } else if (writeData != null) {
                        String string = c.this.lWg.getContext().getResources().getString(R.string.send_success);
                        if (postWriteCallBackData != null) {
                            str = postWriteCallBackData.getPreMsg();
                            str2 = postWriteCallBackData.getColorMsg();
                            string = postWriteCallBackData.getErrorString();
                        } else {
                            str = null;
                        }
                        if (writeData.getType() != 7) {
                            com.baidu.tieba.tbadkCore.writeModel.c.f(c.this.lWg.getContext().getActivity(), string, str, str2);
                        }
                    }
                    Intent intent = new Intent();
                    Bundle bundle = new Bundle();
                    bundle.putSerializable("post_write_callback_data", postWriteCallBackData);
                    intent.putExtras(bundle);
                    BaseActivity context = c.this.lWg.getContext();
                    c.this.lWg.getContext();
                    context.setResult(-1, intent);
                    c.this.lWg.getContext().finish();
                } else if (postWriteCallBackData != null && postWriteCallBackData.getErrorCode() == 227001) {
                    c.this.lWg.getContext().setVisible(false);
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AccountAccessActivityConfig(c.this.lWg.getContext().getActivity(), RequestResponseCode.REQUEST_VCODE, writeData, postWriteCallBackData.getAccessState())));
                } else if (postWriteCallBackData != null && postWriteCallBackData.getErrorCode() == 220015 && c.this.lWh != null) {
                    if (c.this.lWh != null) {
                        c.this.lWh.callback(z, postWriteCallBackData, abVar, writeData, antiData);
                    }
                } else if (postWriteCallBackData != null) {
                    if (StringUtils.isNull(postWriteCallBackData.getErrorString())) {
                        c.this.lWg.showToast(false, c.this.lWg.getContext().getResources().getString(R.string.input_vcode_error));
                    } else {
                        c.this.lWg.showToast(false, postWriteCallBackData.getErrorString());
                    }
                    c.this.dnK();
                }
            }
        }
    };

    public c(NewVcodeView newVcodeView, NewWriteModel newWriteModel) {
        this.lWg = newVcodeView;
        this.lSm = newWriteModel;
        this.lSm.b(this.emV);
    }

    @Override // com.baidu.tieba.write.vcode.newVcode.a.b
    public boolean c(WebView webView, String str) {
        if (str.contains("objc:jsChangeVcode")) {
            this.lWj = com.baidu.tbadk.s.a.yW(str);
            if (this.lWj != null && this.lSm.daf() != null) {
                this.lWg.runJsMethod(this.lWj, "'" + this.lSm.daf().getVcodeUrl() + "'");
                return true;
            }
            return false;
        } else if (str.equals("objc:jumpToFeedback()")) {
            WriteActivityConfig writeActivityConfig = new WriteActivityConfig(this.lWg.getContext().getActivity(), 0, TbConfig.getPositionPagerId(), TbConfig.getPositionPagerName(), null, null, 0, null, RequestResponseCode.REQUEST_WRITE_NEW, true, false, null, false, false, null, null, null, 0);
            writeActivityConfig.setIsVcodeFeedBack();
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, writeActivityConfig));
            return true;
        } else if (str.contains("objc:jsSubmit")) {
            return Ot(com.baidu.tbadk.s.a.yW(str));
        } else {
            return false;
        }
    }

    @Override // com.baidu.tieba.write.vcode.newVcode.a.b
    public void onPageFinished(WebView webView, String str) {
        if (this.lWg != null) {
            this.lWg.showWebViewDelay(500);
            if (this.lWl) {
                e.ld().postDelayed(this.lWn, 500L);
            }
        }
    }

    @Override // com.baidu.tieba.write.vcode.newVcode.a.b
    public void B(boolean z, String str) {
        this.lWl = z;
        this.lWm = str;
    }

    @Override // com.baidu.tieba.write.vcode.newVcode.a.b
    public void start(boolean z) {
        this.lWg.setRatio(1.2631578f);
        this.lWg.showWebView(false);
        String str = TbConfig.SERVER_ADDRESS_WEB_VIEW + Config.NEW_VCODE_WEBVIEW_ADDRESS;
        if (z) {
            str = str + "?feedback=1";
        }
        this.lWg.getWebView().loadUrl(str);
    }

    @Override // com.baidu.tieba.write.vcode.newVcode.a.b
    public void onDestroy() {
        e.ld().removeCallbacks(this.lWn);
    }

    @Override // com.baidu.tieba.write.vcode.newVcode.a.b
    public void d(NewWriteModel.d dVar) {
        this.lWh = dVar;
    }

    @Override // com.baidu.tieba.write.vcode.newVcode.a.b
    public void dmP() {
        this.lWg.showPostThreadLoadingView(false);
        this.lSm.cancelLoadData();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dnK() {
        this.lWg.runJsMethod(this.lWk, "'" + this.lSm.daf().getVcodeUrl() + "'");
    }

    private boolean Ot(String str) {
        String[] split;
        if (StringUtils.isNull(str) || (split = str.split(Constants.ACCEPT_TIME_SEPARATOR_SP)) == null || split.length != 2) {
            return false;
        }
        this.lWk = split[0];
        Os(split[1]);
        return true;
    }

    private void Os(String str) {
        this.lSn = false;
        if (!l.isNetOk()) {
            this.lWg.getContext().showToast(R.string.neterror);
            this.lWg.getContext().finish();
        } else if (!StringUtils.isNull(str)) {
            this.lWg.showPostThreadLoadingView(true);
            this.lSm.daf().setVcode(str);
            this.lSm.daf().setVcodeType("4");
            this.lSm.dfc();
        } else {
            this.lWg.getContext().showToast(R.string.neterror);
            this.lWg.getContext().finish();
        }
    }
}
