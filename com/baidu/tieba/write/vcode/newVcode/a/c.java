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
import com.baidu.tbadk.coreExtra.data.y;
import com.baidu.tieba.R;
import com.baidu.tieba.tbadkCore.writeModel.NewWriteModel;
import com.baidu.tieba.tbadkCore.writeModel.PostWriteCallBackData;
import com.baidu.tieba.write.vcode.newVcode.NewVcodeView;
import com.xiaomi.mipush.sdk.Constants;
/* loaded from: classes10.dex */
public class c implements b {
    private final NewWriteModel kIi;
    private final NewVcodeView kLF;
    private NewWriteModel.d kLG;
    private String kLI;
    private String kLJ;
    private boolean kLK = false;
    private String kLL = null;
    private boolean kIj = false;
    private Runnable kLM = new Runnable() { // from class: com.baidu.tieba.write.vcode.newVcode.a.c.1
        @Override // java.lang.Runnable
        public void run() {
            if (c.this.kLF != null) {
                if (StringUtils.isNull(c.this.kLL)) {
                    c.this.kLF.showToast(false, c.this.kLF.getContext().getResources().getString(R.string.drag_vcode_error));
                } else {
                    c.this.kLF.showToast(false, c.this.kLL);
                }
            }
        }
    };
    private final NewWriteModel.d dui = new NewWriteModel.d() { // from class: com.baidu.tieba.write.vcode.newVcode.a.c.2
        @Override // com.baidu.tieba.tbadkCore.writeModel.NewWriteModel.d
        public void callback(boolean z, PostWriteCallBackData postWriteCallBackData, y yVar, WriteData writeData, AntiData antiData) {
            String str;
            String str2 = null;
            if (c.this.kLF != null) {
                c.this.kLF.showPostThreadLoadingView(false);
                if (z) {
                    c.this.kIj = true;
                    if (writeData != null && writeData.getVideoReviewType() == 1) {
                        c.this.kLF.showToast(true, c.this.kLF.getContext().getResources().getString(R.string.video_send_success_under_review));
                    } else if (writeData != null && writeData.getVideoReviewType() == 2) {
                        c.this.kLF.showToast(true, c.this.kLF.getContext().getResources().getString(R.string.video_send_success));
                    } else if (writeData != null) {
                        String string = c.this.kLF.getContext().getResources().getString(R.string.send_success);
                        if (postWriteCallBackData != null) {
                            str = postWriteCallBackData.getPreMsg();
                            str2 = postWriteCallBackData.getColorMsg();
                            string = postWriteCallBackData.getErrorString();
                        } else {
                            str = null;
                        }
                        if (writeData.getType() != 7) {
                            com.baidu.tieba.tbadkCore.writeModel.c.f(c.this.kLF.getContext().getActivity(), string, str, str2);
                        }
                    }
                    Intent intent = new Intent();
                    Bundle bundle = new Bundle();
                    bundle.putSerializable("post_write_callback_data", postWriteCallBackData);
                    intent.putExtras(bundle);
                    BaseActivity context = c.this.kLF.getContext();
                    c.this.kLF.getContext();
                    context.setResult(-1, intent);
                    c.this.kLF.getContext().finish();
                } else if (postWriteCallBackData != null && postWriteCallBackData.getErrorCode() == 227001) {
                    c.this.kLF.getContext().setVisible(false);
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AccountAccessActivityConfig(c.this.kLF.getContext().getActivity(), RequestResponseCode.REQUEST_VCODE, writeData, postWriteCallBackData.getAccessState())));
                } else if (postWriteCallBackData != null && postWriteCallBackData.getErrorCode() == 220015 && c.this.kLG != null) {
                    if (c.this.kLG != null) {
                        c.this.kLG.callback(z, postWriteCallBackData, yVar, writeData, antiData);
                    }
                } else if (postWriteCallBackData != null) {
                    if (StringUtils.isNull(postWriteCallBackData.getErrorString())) {
                        c.this.kLF.showToast(false, c.this.kLF.getContext().getResources().getString(R.string.input_vcode_error));
                    } else {
                        c.this.kLF.showToast(false, postWriteCallBackData.getErrorString());
                    }
                    c.this.cSH();
                }
            }
        }
    };

    public c(NewVcodeView newVcodeView, NewWriteModel newWriteModel) {
        this.kLF = newVcodeView;
        this.kIi = newWriteModel;
        this.kIi.b(this.dui);
    }

    @Override // com.baidu.tieba.write.vcode.newVcode.a.b
    public boolean c(WebView webView, String str) {
        if (str.contains("objc:jsChangeVcode")) {
            this.kLI = com.baidu.tbadk.s.a.vA(str);
            if (this.kLI != null && this.kIi.cFi() != null) {
                this.kLF.runJsMethod(this.kLI, "'" + this.kIi.cFi().getVcodeUrl() + "'");
                return true;
            }
            return false;
        } else if (str.equals("objc:jumpToFeedback()")) {
            WriteActivityConfig writeActivityConfig = new WriteActivityConfig(this.kLF.getContext().getActivity(), 0, TbConfig.getPositionPagerId(), TbConfig.getPositionPagerName(), null, null, 0, null, RequestResponseCode.REQUEST_WRITE_NEW, true, false, null, false, false, null, null, null, 0);
            writeActivityConfig.setIsVcodeFeedBack();
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, writeActivityConfig));
            return true;
        } else if (str.contains("objc:jsSubmit")) {
            return Ky(com.baidu.tbadk.s.a.vA(str));
        } else {
            return false;
        }
    }

    @Override // com.baidu.tieba.write.vcode.newVcode.a.b
    public void onPageFinished(WebView webView, String str) {
        if (this.kLF != null) {
            this.kLF.showWebViewDelay(500);
            if (this.kLK) {
                e.gy().postDelayed(this.kLM, 500L);
            }
        }
    }

    @Override // com.baidu.tieba.write.vcode.newVcode.a.b
    public void A(boolean z, String str) {
        this.kLK = z;
        this.kLL = str;
    }

    @Override // com.baidu.tieba.write.vcode.newVcode.a.b
    public void start(boolean z) {
        this.kLF.setRatio(1.2631578f);
        this.kLF.showWebView(false);
        String str = TbConfig.SERVER_ADDRESS_WEB_VIEW + Config.NEW_VCODE_WEBVIEW_ADDRESS;
        if (z) {
            str = str + "?feedback=1";
        }
        this.kLF.getWebView().loadUrl(str);
    }

    @Override // com.baidu.tieba.write.vcode.newVcode.a.b
    public void onDestroy() {
        e.gy().removeCallbacks(this.kLM);
    }

    @Override // com.baidu.tieba.write.vcode.newVcode.a.b
    public void d(NewWriteModel.d dVar) {
        this.kLG = dVar;
    }

    @Override // com.baidu.tieba.write.vcode.newVcode.a.b
    public void cRZ() {
        this.kLF.showPostThreadLoadingView(false);
        this.kIi.cancelLoadData();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cSH() {
        this.kLF.runJsMethod(this.kLJ, "'" + this.kIi.cFi().getVcodeUrl() + "'");
    }

    private boolean Ky(String str) {
        String[] split;
        if (StringUtils.isNull(str) || (split = str.split(Constants.ACCEPT_TIME_SEPARATOR_SP)) == null || split.length != 2) {
            return false;
        }
        this.kLJ = split[0];
        Kx(split[1]);
        return true;
    }

    private void Kx(String str) {
        this.kIj = false;
        if (!l.isNetOk()) {
            this.kLF.getContext().showToast(R.string.neterror);
            this.kLF.getContext().finish();
        } else if (!StringUtils.isNull(str)) {
            this.kLF.showPostThreadLoadingView(true);
            this.kIi.cFi().setVcode(str);
            this.kIi.cFi().setVcodeType("4");
            this.kIi.cJG();
        } else {
            this.kLF.getContext().showToast(R.string.neterror);
            this.kLF.getContext().finish();
        }
    }
}
