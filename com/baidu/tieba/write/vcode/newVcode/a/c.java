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
/* loaded from: classes2.dex */
public class c implements b {
    private final NewWriteModel mmy;
    private final NewVcodeView mqD;
    private NewWriteModel.d mqE;
    private String mqG;
    private String mqH;
    private boolean mqI = false;
    private String mqJ = null;
    private boolean mmz = false;
    private Runnable mqK = new Runnable() { // from class: com.baidu.tieba.write.vcode.newVcode.a.c.1
        @Override // java.lang.Runnable
        public void run() {
            if (c.this.mqD != null) {
                if (StringUtils.isNull(c.this.mqJ)) {
                    c.this.mqD.showToast(false, c.this.mqD.getContext().getResources().getString(R.string.drag_vcode_error));
                } else {
                    c.this.mqD.showToast(false, c.this.mqJ);
                }
            }
        }
    };
    private final NewWriteModel.d evL = new NewWriteModel.d() { // from class: com.baidu.tieba.write.vcode.newVcode.a.c.2
        @Override // com.baidu.tieba.tbadkCore.writeModel.NewWriteModel.d
        public void callback(boolean z, PostWriteCallBackData postWriteCallBackData, ad adVar, WriteData writeData, AntiData antiData) {
            String str;
            String str2 = null;
            if (c.this.mqD != null) {
                c.this.mqD.showPostThreadLoadingView(false);
                if (z) {
                    c.this.mmz = true;
                    if (writeData != null && writeData.getVideoReviewType() == 1) {
                        c.this.mqD.showToast(true, c.this.mqD.getContext().getResources().getString(R.string.video_send_success_under_review));
                    } else if (writeData != null && writeData.getVideoReviewType() == 2) {
                        c.this.mqD.showToast(true, c.this.mqD.getContext().getResources().getString(R.string.video_send_success));
                    } else if (writeData != null) {
                        String string = c.this.mqD.getContext().getResources().getString(R.string.send_success);
                        if (postWriteCallBackData != null) {
                            str = postWriteCallBackData.getPreMsg();
                            str2 = postWriteCallBackData.getColorMsg();
                            string = postWriteCallBackData.getErrorString();
                        } else {
                            str = null;
                        }
                        if (writeData.getType() != 7) {
                            com.baidu.tieba.tbadkCore.writeModel.c.f(c.this.mqD.getContext().getActivity(), string, str, str2);
                        }
                    }
                    Intent intent = new Intent();
                    Bundle bundle = new Bundle();
                    bundle.putSerializable("post_write_callback_data", postWriteCallBackData);
                    intent.putExtras(bundle);
                    BaseActivity context = c.this.mqD.getContext();
                    c.this.mqD.getContext();
                    context.setResult(-1, intent);
                    c.this.mqD.getContext().finish();
                } else if (postWriteCallBackData != null && postWriteCallBackData.getErrorCode() == 227001) {
                    c.this.mqD.getContext().setVisible(false);
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AccountAccessActivityConfig(c.this.mqD.getContext().getActivity(), RequestResponseCode.REQUEST_VCODE, writeData, postWriteCallBackData.getAccessState())));
                } else if (postWriteCallBackData != null && postWriteCallBackData.getErrorCode() == 220015 && c.this.mqE != null) {
                    if (c.this.mqE != null) {
                        c.this.mqE.callback(z, postWriteCallBackData, adVar, writeData, antiData);
                    }
                } else if (postWriteCallBackData != null) {
                    if (StringUtils.isNull(postWriteCallBackData.getErrorString())) {
                        c.this.mqD.showToast(false, c.this.mqD.getContext().getResources().getString(R.string.input_vcode_error));
                    } else {
                        c.this.mqD.showToast(false, postWriteCallBackData.getErrorString());
                    }
                    c.this.dsa();
                }
            }
        }
    };

    public c(NewVcodeView newVcodeView, NewWriteModel newWriteModel) {
        this.mqD = newVcodeView;
        this.mmy = newWriteModel;
        this.mmy.b(this.evL);
    }

    @Override // com.baidu.tieba.write.vcode.newVcode.a.b
    public boolean c(WebView webView, String str) {
        if (str.contains("objc:jsChangeVcode")) {
            this.mqG = com.baidu.tbadk.t.a.zp(str);
            if (this.mqG != null && this.mmy.dew() != null) {
                this.mqD.runJsMethod(this.mqG, "'" + this.mmy.dew().getVcodeUrl() + "'");
                return true;
            }
            return false;
        } else if (str.equals("objc:jumpToFeedback()")) {
            WriteActivityConfig writeActivityConfig = new WriteActivityConfig(this.mqD.getContext().getActivity(), 0, TbConfig.getPositionPagerId(), TbConfig.getPositionPagerName(), null, null, 0, null, RequestResponseCode.REQUEST_WRITE_NEW, true, false, null, false, false, null, null, null, 0);
            writeActivityConfig.setIsVcodeFeedBack();
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, writeActivityConfig));
            return true;
        } else if (str.contains("objc:jsSubmit")) {
            return Pb(com.baidu.tbadk.t.a.zp(str));
        } else {
            return false;
        }
    }

    @Override // com.baidu.tieba.write.vcode.newVcode.a.b
    public void onPageFinished(WebView webView, String str) {
        if (this.mqD != null) {
            this.mqD.showWebViewDelay(500);
            if (this.mqI) {
                e.lt().postDelayed(this.mqK, 500L);
            }
        }
    }

    @Override // com.baidu.tieba.write.vcode.newVcode.a.b
    public void D(boolean z, String str) {
        this.mqI = z;
        this.mqJ = str;
    }

    @Override // com.baidu.tieba.write.vcode.newVcode.a.b
    public void start(boolean z) {
        this.mqD.setRatio(1.2631578f);
        this.mqD.showWebView(false);
        String str = TbConfig.SERVER_ADDRESS_WEB_VIEW + Config.NEW_VCODE_WEBVIEW_ADDRESS;
        if (z) {
            str = str + "?feedback=1";
        }
        this.mqD.getWebView().loadUrl(str);
    }

    @Override // com.baidu.tieba.write.vcode.newVcode.a.b
    public void onDestroy() {
        e.lt().removeCallbacks(this.mqK);
    }

    @Override // com.baidu.tieba.write.vcode.newVcode.a.b
    public void d(NewWriteModel.d dVar) {
        this.mqE = dVar;
    }

    @Override // com.baidu.tieba.write.vcode.newVcode.a.b
    public void drf() {
        this.mqD.showPostThreadLoadingView(false);
        this.mmy.cancelLoadData();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dsa() {
        this.mqD.runJsMethod(this.mqH, "'" + this.mmy.dew().getVcodeUrl() + "'");
    }

    private boolean Pb(String str) {
        String[] split;
        if (StringUtils.isNull(str) || (split = str.split(Constants.ACCEPT_TIME_SEPARATOR_SP)) == null || split.length != 2) {
            return false;
        }
        this.mqH = split[0];
        Pa(split[1]);
        return true;
    }

    private void Pa(String str) {
        this.mmz = false;
        if (!l.isNetOk()) {
            this.mqD.getContext().showToast(R.string.neterror);
            this.mqD.getContext().finish();
        } else if (!StringUtils.isNull(str)) {
            this.mqD.showPostThreadLoadingView(true);
            this.mmy.dew().setVcode(str);
            this.mmy.dew().setVcodeType("4");
            this.mmy.djo();
        } else {
            this.mqD.getContext().showToast(R.string.neterror);
            this.mqD.getContext().finish();
        }
    }
}
