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
/* loaded from: classes3.dex */
public class c implements b {
    private final NewWriteModel nUD;
    private final NewVcodeView nYD;
    private NewWriteModel.d nYE;
    private String nYG;
    private String nYH;
    private boolean nYI = false;
    private String nYJ = null;
    private boolean nUE = false;
    private Runnable nYK = new Runnable() { // from class: com.baidu.tieba.write.vcode.newVcode.a.c.1
        @Override // java.lang.Runnable
        public void run() {
            if (c.this.nYD != null) {
                if (StringUtils.isNull(c.this.nYJ)) {
                    c.this.nYD.showToast(false, c.this.nYD.getContext().getResources().getString(R.string.drag_vcode_error));
                } else {
                    c.this.nYD.showToast(false, c.this.nYJ);
                }
            }
        }
    };
    private final NewWriteModel.d fwI = new NewWriteModel.d() { // from class: com.baidu.tieba.write.vcode.newVcode.a.c.2
        @Override // com.baidu.tieba.tbadkCore.writeModel.NewWriteModel.d
        public void callback(boolean z, PostWriteCallBackData postWriteCallBackData, ah ahVar, WriteData writeData, AntiData antiData) {
            String str;
            String str2 = null;
            if (c.this.nYD != null) {
                c.this.nYD.showPostThreadLoadingView(false);
                if (z) {
                    c.this.nUE = true;
                    if (writeData != null && writeData.getVideoReviewType() == 1) {
                        c.this.nYD.showToast(true, c.this.nYD.getContext().getResources().getString(R.string.video_send_success_under_review));
                    } else if (writeData != null && writeData.getVideoReviewType() == 2) {
                        c.this.nYD.showToast(true, c.this.nYD.getContext().getResources().getString(R.string.video_send_success));
                    } else if (writeData != null) {
                        String string = c.this.nYD.getContext().getResources().getString(R.string.send_success);
                        if (postWriteCallBackData != null) {
                            str = postWriteCallBackData.getPreMsg();
                            str2 = postWriteCallBackData.getColorMsg();
                            string = postWriteCallBackData.getErrorString();
                        } else {
                            str = null;
                        }
                        if (writeData.getType() != 7) {
                            com.baidu.tieba.tbadkCore.writeModel.c.h(c.this.nYD.getContext().getActivity(), string, str, str2);
                        }
                    }
                    Intent intent = new Intent();
                    Bundle bundle = new Bundle();
                    bundle.putSerializable("post_write_callback_data", postWriteCallBackData);
                    intent.putExtras(bundle);
                    BaseActivity context = c.this.nYD.getContext();
                    c.this.nYD.getContext();
                    context.setResult(-1, intent);
                    c.this.nYD.getContext().finish();
                } else if (postWriteCallBackData != null && postWriteCallBackData.getErrorCode() == 227001) {
                    c.this.nYD.getContext().setVisible(false);
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AccountAccessActivityConfig(c.this.nYD.getContext().getActivity(), RequestResponseCode.REQUEST_VCODE, writeData, postWriteCallBackData.getAccessState())));
                } else if (postWriteCallBackData != null && postWriteCallBackData.getErrorCode() == 220015 && c.this.nYE != null) {
                    if (c.this.nYE != null) {
                        c.this.nYE.callback(z, postWriteCallBackData, ahVar, writeData, antiData);
                    }
                } else if (postWriteCallBackData != null) {
                    if (StringUtils.isNull(postWriteCallBackData.getErrorString())) {
                        c.this.nYD.showToast(false, c.this.nYD.getContext().getResources().getString(R.string.input_vcode_error));
                    } else {
                        c.this.nYD.showToast(false, postWriteCallBackData.getErrorString());
                    }
                    c.this.dZz();
                }
            }
        }
    };

    public c(NewVcodeView newVcodeView, NewWriteModel newWriteModel) {
        this.nYD = newVcodeView;
        this.nUD = newWriteModel;
        this.nUD.b(this.fwI);
    }

    @Override // com.baidu.tieba.write.vcode.newVcode.a.b
    public boolean c(WebView webView, String str) {
        if (str.contains("objc:jsChangeVcode")) {
            this.nYG = com.baidu.tbadk.t.a.ER(str);
            if (this.nYG != null && this.nUD.dcD() != null) {
                this.nYD.runJsMethod(this.nYG, "'" + this.nUD.dcD().getVcodeUrl() + "'");
                return true;
            }
            return false;
        } else if (str.equals("objc:jumpToFeedback()")) {
            WriteActivityConfig writeActivityConfig = new WriteActivityConfig(this.nYD.getContext().getActivity(), 0, TbConfig.getPositionPagerId(), TbConfig.getPositionPagerName(), null, null, 0, null, RequestResponseCode.REQUEST_WRITE_NEW, true, false, null, false, false, null, null, null, 0);
            writeActivityConfig.setIsVcodeFeedBack();
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, writeActivityConfig));
            return true;
        } else if (str.contains("objc:jsSubmit")) {
            return VO(com.baidu.tbadk.t.a.ER(str));
        } else {
            return false;
        }
    }

    @Override // com.baidu.tieba.write.vcode.newVcode.a.b
    public void onPageFinished(WebView webView, String str) {
        if (this.nYD != null) {
            this.nYD.showWebViewDelay(500);
            if (this.nYI) {
                e.mY().postDelayed(this.nYK, 500L);
            }
        }
    }

    @Override // com.baidu.tieba.write.vcode.newVcode.a.b
    public void H(boolean z, String str) {
        this.nYI = z;
        this.nYJ = str;
    }

    @Override // com.baidu.tieba.write.vcode.newVcode.a.b
    public void start(boolean z) {
        this.nYD.setRatio(1.2631578f);
        this.nYD.showWebView(false);
        String str = TbConfig.SERVER_ADDRESS_WEB_VIEW + Config.NEW_VCODE_WEBVIEW_ADDRESS;
        if (z) {
            str = str + "?feedback=1";
        }
        this.nYD.getWebView().loadUrl(str);
    }

    @Override // com.baidu.tieba.write.vcode.newVcode.a.b
    public void onDestroy() {
        e.mY().removeCallbacks(this.nYK);
    }

    @Override // com.baidu.tieba.write.vcode.newVcode.a.b
    public void d(NewWriteModel.d dVar) {
        this.nYE = dVar;
    }

    @Override // com.baidu.tieba.write.vcode.newVcode.a.b
    public void dYE() {
        this.nYD.showPostThreadLoadingView(false);
        this.nUD.cancelLoadData();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dZz() {
        this.nYD.runJsMethod(this.nYH, "'" + this.nUD.dcD().getVcodeUrl() + "'");
    }

    private boolean VO(String str) {
        String[] split;
        if (StringUtils.isNull(str) || (split = str.split(",")) == null || split.length != 2) {
            return false;
        }
        this.nYH = split[0];
        VN(split[1]);
        return true;
    }

    private void VN(String str) {
        this.nUE = false;
        if (!l.isNetOk()) {
            this.nYD.getContext().showToast(R.string.neterror);
            this.nYD.getContext().finish();
        } else if (!StringUtils.isNull(str)) {
            this.nYD.showPostThreadLoadingView(true);
            this.nUD.dcD().setVcode(str);
            this.nUD.dcD().setVcodeType("4");
            this.nUD.dQD();
        } else {
            this.nYD.getContext().showToast(R.string.neterror);
            this.nYD.getContext().finish();
        }
    }
}
