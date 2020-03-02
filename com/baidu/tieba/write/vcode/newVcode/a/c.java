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
/* loaded from: classes13.dex */
public class c implements b {
    private final NewWriteModel kMw;
    private final NewVcodeView kPT;
    private NewWriteModel.d kPU;
    private String kPW;
    private String kPX;
    private boolean kPY = false;
    private String kPZ = null;
    private boolean kMx = false;
    private Runnable kQa = new Runnable() { // from class: com.baidu.tieba.write.vcode.newVcode.a.c.1
        @Override // java.lang.Runnable
        public void run() {
            if (c.this.kPT != null) {
                if (StringUtils.isNull(c.this.kPZ)) {
                    c.this.kPT.showToast(false, c.this.kPT.getContext().getResources().getString(R.string.drag_vcode_error));
                } else {
                    c.this.kPT.showToast(false, c.this.kPZ);
                }
            }
        }
    };
    private final NewWriteModel.d dyA = new NewWriteModel.d() { // from class: com.baidu.tieba.write.vcode.newVcode.a.c.2
        @Override // com.baidu.tieba.tbadkCore.writeModel.NewWriteModel.d
        public void callback(boolean z, PostWriteCallBackData postWriteCallBackData, aa aaVar, WriteData writeData, AntiData antiData) {
            String str;
            String str2 = null;
            if (c.this.kPT != null) {
                c.this.kPT.showPostThreadLoadingView(false);
                if (z) {
                    c.this.kMx = true;
                    if (writeData != null && writeData.getVideoReviewType() == 1) {
                        c.this.kPT.showToast(true, c.this.kPT.getContext().getResources().getString(R.string.video_send_success_under_review));
                    } else if (writeData != null && writeData.getVideoReviewType() == 2) {
                        c.this.kPT.showToast(true, c.this.kPT.getContext().getResources().getString(R.string.video_send_success));
                    } else if (writeData != null) {
                        String string = c.this.kPT.getContext().getResources().getString(R.string.send_success);
                        if (postWriteCallBackData != null) {
                            str = postWriteCallBackData.getPreMsg();
                            str2 = postWriteCallBackData.getColorMsg();
                            string = postWriteCallBackData.getErrorString();
                        } else {
                            str = null;
                        }
                        if (writeData.getType() != 7) {
                            com.baidu.tieba.tbadkCore.writeModel.c.g(c.this.kPT.getContext().getActivity(), string, str, str2);
                        }
                    }
                    Intent intent = new Intent();
                    Bundle bundle = new Bundle();
                    bundle.putSerializable("post_write_callback_data", postWriteCallBackData);
                    intent.putExtras(bundle);
                    BaseActivity context = c.this.kPT.getContext();
                    c.this.kPT.getContext();
                    context.setResult(-1, intent);
                    c.this.kPT.getContext().finish();
                } else if (postWriteCallBackData != null && postWriteCallBackData.getErrorCode() == 227001) {
                    c.this.kPT.getContext().setVisible(false);
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AccountAccessActivityConfig(c.this.kPT.getContext().getActivity(), RequestResponseCode.REQUEST_VCODE, writeData, postWriteCallBackData.getAccessState())));
                } else if (postWriteCallBackData != null && postWriteCallBackData.getErrorCode() == 220015 && c.this.kPU != null) {
                    if (c.this.kPU != null) {
                        c.this.kPU.callback(z, postWriteCallBackData, aaVar, writeData, antiData);
                    }
                } else if (postWriteCallBackData != null) {
                    if (StringUtils.isNull(postWriteCallBackData.getErrorString())) {
                        c.this.kPT.showToast(false, c.this.kPT.getContext().getResources().getString(R.string.input_vcode_error));
                    } else {
                        c.this.kPT.showToast(false, postWriteCallBackData.getErrorString());
                    }
                    c.this.cVc();
                }
            }
        }
    };

    public c(NewVcodeView newVcodeView, NewWriteModel newWriteModel) {
        this.kPT = newVcodeView;
        this.kMw = newWriteModel;
        this.kMw.b(this.dyA);
    }

    @Override // com.baidu.tieba.write.vcode.newVcode.a.b
    public boolean c(WebView webView, String str) {
        if (str.contains("objc:jsChangeVcode")) {
            this.kPW = com.baidu.tbadk.s.a.vZ(str);
            if (this.kPW != null && this.kMw.cHU() != null) {
                this.kPT.runJsMethod(this.kPW, "'" + this.kMw.cHU().getVcodeUrl() + "'");
                return true;
            }
            return false;
        } else if (str.equals("objc:jumpToFeedback()")) {
            WriteActivityConfig writeActivityConfig = new WriteActivityConfig(this.kPT.getContext().getActivity(), 0, TbConfig.getPositionPagerId(), TbConfig.getPositionPagerName(), null, null, 0, null, RequestResponseCode.REQUEST_WRITE_NEW, true, false, null, false, false, null, null, null, 0);
            writeActivityConfig.setIsVcodeFeedBack();
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, writeActivityConfig));
            return true;
        } else if (str.contains("objc:jsSubmit")) {
            return KV(com.baidu.tbadk.s.a.vZ(str));
        } else {
            return false;
        }
    }

    @Override // com.baidu.tieba.write.vcode.newVcode.a.b
    public void onPageFinished(WebView webView, String str) {
        if (this.kPT != null) {
            this.kPT.showWebViewDelay(500);
            if (this.kPY) {
                e.gx().postDelayed(this.kQa, 500L);
            }
        }
    }

    @Override // com.baidu.tieba.write.vcode.newVcode.a.b
    public void A(boolean z, String str) {
        this.kPY = z;
        this.kPZ = str;
    }

    @Override // com.baidu.tieba.write.vcode.newVcode.a.b
    public void start(boolean z) {
        this.kPT.setRatio(1.2631578f);
        this.kPT.showWebView(false);
        String str = TbConfig.SERVER_ADDRESS_WEB_VIEW + Config.NEW_VCODE_WEBVIEW_ADDRESS;
        if (z) {
            str = str + "?feedback=1";
        }
        this.kPT.getWebView().loadUrl(str);
    }

    @Override // com.baidu.tieba.write.vcode.newVcode.a.b
    public void onDestroy() {
        e.gx().removeCallbacks(this.kQa);
    }

    @Override // com.baidu.tieba.write.vcode.newVcode.a.b
    public void d(NewWriteModel.d dVar) {
        this.kPU = dVar;
    }

    @Override // com.baidu.tieba.write.vcode.newVcode.a.b
    public void cUu() {
        this.kPT.showPostThreadLoadingView(false);
        this.kMw.cancelLoadData();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cVc() {
        this.kPT.runJsMethod(this.kPX, "'" + this.kMw.cHU().getVcodeUrl() + "'");
    }

    private boolean KV(String str) {
        String[] split;
        if (StringUtils.isNull(str) || (split = str.split(Constants.ACCEPT_TIME_SEPARATOR_SP)) == null || split.length != 2) {
            return false;
        }
        this.kPX = split[0];
        KU(split[1]);
        return true;
    }

    private void KU(String str) {
        this.kMx = false;
        if (!l.isNetOk()) {
            this.kPT.getContext().showToast(R.string.neterror);
            this.kPT.getContext().finish();
        } else if (!StringUtils.isNull(str)) {
            this.kPT.showPostThreadLoadingView(true);
            this.kMw.cHU().setVcode(str);
            this.kMw.cHU().setVcodeType("4");
            this.kMw.cMj();
        } else {
            this.kPT.getContext().showToast(R.string.neterror);
            this.kPT.getContext().finish();
        }
    }
}
