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
    private final NewWriteModel kMu;
    private final NewVcodeView kPR;
    private NewWriteModel.d kPS;
    private String kPU;
    private String kPV;
    private boolean kPW = false;
    private String kPX = null;
    private boolean kMv = false;
    private Runnable kPY = new Runnable() { // from class: com.baidu.tieba.write.vcode.newVcode.a.c.1
        @Override // java.lang.Runnable
        public void run() {
            if (c.this.kPR != null) {
                if (StringUtils.isNull(c.this.kPX)) {
                    c.this.kPR.showToast(false, c.this.kPR.getContext().getResources().getString(R.string.drag_vcode_error));
                } else {
                    c.this.kPR.showToast(false, c.this.kPX);
                }
            }
        }
    };
    private final NewWriteModel.d dyz = new NewWriteModel.d() { // from class: com.baidu.tieba.write.vcode.newVcode.a.c.2
        @Override // com.baidu.tieba.tbadkCore.writeModel.NewWriteModel.d
        public void callback(boolean z, PostWriteCallBackData postWriteCallBackData, aa aaVar, WriteData writeData, AntiData antiData) {
            String str;
            String str2 = null;
            if (c.this.kPR != null) {
                c.this.kPR.showPostThreadLoadingView(false);
                if (z) {
                    c.this.kMv = true;
                    if (writeData != null && writeData.getVideoReviewType() == 1) {
                        c.this.kPR.showToast(true, c.this.kPR.getContext().getResources().getString(R.string.video_send_success_under_review));
                    } else if (writeData != null && writeData.getVideoReviewType() == 2) {
                        c.this.kPR.showToast(true, c.this.kPR.getContext().getResources().getString(R.string.video_send_success));
                    } else if (writeData != null) {
                        String string = c.this.kPR.getContext().getResources().getString(R.string.send_success);
                        if (postWriteCallBackData != null) {
                            str = postWriteCallBackData.getPreMsg();
                            str2 = postWriteCallBackData.getColorMsg();
                            string = postWriteCallBackData.getErrorString();
                        } else {
                            str = null;
                        }
                        if (writeData.getType() != 7) {
                            com.baidu.tieba.tbadkCore.writeModel.c.g(c.this.kPR.getContext().getActivity(), string, str, str2);
                        }
                    }
                    Intent intent = new Intent();
                    Bundle bundle = new Bundle();
                    bundle.putSerializable("post_write_callback_data", postWriteCallBackData);
                    intent.putExtras(bundle);
                    BaseActivity context = c.this.kPR.getContext();
                    c.this.kPR.getContext();
                    context.setResult(-1, intent);
                    c.this.kPR.getContext().finish();
                } else if (postWriteCallBackData != null && postWriteCallBackData.getErrorCode() == 227001) {
                    c.this.kPR.getContext().setVisible(false);
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AccountAccessActivityConfig(c.this.kPR.getContext().getActivity(), RequestResponseCode.REQUEST_VCODE, writeData, postWriteCallBackData.getAccessState())));
                } else if (postWriteCallBackData != null && postWriteCallBackData.getErrorCode() == 220015 && c.this.kPS != null) {
                    if (c.this.kPS != null) {
                        c.this.kPS.callback(z, postWriteCallBackData, aaVar, writeData, antiData);
                    }
                } else if (postWriteCallBackData != null) {
                    if (StringUtils.isNull(postWriteCallBackData.getErrorString())) {
                        c.this.kPR.showToast(false, c.this.kPR.getContext().getResources().getString(R.string.input_vcode_error));
                    } else {
                        c.this.kPR.showToast(false, postWriteCallBackData.getErrorString());
                    }
                    c.this.cVa();
                }
            }
        }
    };

    public c(NewVcodeView newVcodeView, NewWriteModel newWriteModel) {
        this.kPR = newVcodeView;
        this.kMu = newWriteModel;
        this.kMu.b(this.dyz);
    }

    @Override // com.baidu.tieba.write.vcode.newVcode.a.b
    public boolean c(WebView webView, String str) {
        if (str.contains("objc:jsChangeVcode")) {
            this.kPU = com.baidu.tbadk.s.a.vZ(str);
            if (this.kPU != null && this.kMu.cHS() != null) {
                this.kPR.runJsMethod(this.kPU, "'" + this.kMu.cHS().getVcodeUrl() + "'");
                return true;
            }
            return false;
        } else if (str.equals("objc:jumpToFeedback()")) {
            WriteActivityConfig writeActivityConfig = new WriteActivityConfig(this.kPR.getContext().getActivity(), 0, TbConfig.getPositionPagerId(), TbConfig.getPositionPagerName(), null, null, 0, null, RequestResponseCode.REQUEST_WRITE_NEW, true, false, null, false, false, null, null, null, 0);
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
        if (this.kPR != null) {
            this.kPR.showWebViewDelay(500);
            if (this.kPW) {
                e.gx().postDelayed(this.kPY, 500L);
            }
        }
    }

    @Override // com.baidu.tieba.write.vcode.newVcode.a.b
    public void A(boolean z, String str) {
        this.kPW = z;
        this.kPX = str;
    }

    @Override // com.baidu.tieba.write.vcode.newVcode.a.b
    public void start(boolean z) {
        this.kPR.setRatio(1.2631578f);
        this.kPR.showWebView(false);
        String str = TbConfig.SERVER_ADDRESS_WEB_VIEW + Config.NEW_VCODE_WEBVIEW_ADDRESS;
        if (z) {
            str = str + "?feedback=1";
        }
        this.kPR.getWebView().loadUrl(str);
    }

    @Override // com.baidu.tieba.write.vcode.newVcode.a.b
    public void onDestroy() {
        e.gx().removeCallbacks(this.kPY);
    }

    @Override // com.baidu.tieba.write.vcode.newVcode.a.b
    public void d(NewWriteModel.d dVar) {
        this.kPS = dVar;
    }

    @Override // com.baidu.tieba.write.vcode.newVcode.a.b
    public void cUs() {
        this.kPR.showPostThreadLoadingView(false);
        this.kMu.cancelLoadData();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cVa() {
        this.kPR.runJsMethod(this.kPV, "'" + this.kMu.cHS().getVcodeUrl() + "'");
    }

    private boolean KV(String str) {
        String[] split;
        if (StringUtils.isNull(str) || (split = str.split(Constants.ACCEPT_TIME_SEPARATOR_SP)) == null || split.length != 2) {
            return false;
        }
        this.kPV = split[0];
        KU(split[1]);
        return true;
    }

    private void KU(String str) {
        this.kMv = false;
        if (!l.isNetOk()) {
            this.kPR.getContext().showToast(R.string.neterror);
            this.kPR.getContext().finish();
        } else if (!StringUtils.isNull(str)) {
            this.kPR.showPostThreadLoadingView(true);
            this.kMu.cHS().setVcode(str);
            this.kMu.cHS().setVcodeType("4");
            this.kMu.cMh();
        } else {
            this.kPR.getContext().showToast(R.string.neterror);
            this.kPR.getContext().finish();
        }
    }
}
