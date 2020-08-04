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
/* loaded from: classes3.dex */
public class c implements b {
    private final NewWriteModel muA;
    private final NewVcodeView myE;
    private NewWriteModel.d myF;
    private String myH;
    private String myI;
    private boolean myJ = false;
    private String myK = null;
    private boolean muB = false;
    private Runnable myL = new Runnable() { // from class: com.baidu.tieba.write.vcode.newVcode.a.c.1
        @Override // java.lang.Runnable
        public void run() {
            if (c.this.myE != null) {
                if (StringUtils.isNull(c.this.myK)) {
                    c.this.myE.showToast(false, c.this.myE.getContext().getResources().getString(R.string.drag_vcode_error));
                } else {
                    c.this.myE.showToast(false, c.this.myK);
                }
            }
        }
    };
    private final NewWriteModel.d eCe = new NewWriteModel.d() { // from class: com.baidu.tieba.write.vcode.newVcode.a.c.2
        @Override // com.baidu.tieba.tbadkCore.writeModel.NewWriteModel.d
        public void callback(boolean z, PostWriteCallBackData postWriteCallBackData, ad adVar, WriteData writeData, AntiData antiData) {
            String str;
            String str2 = null;
            if (c.this.myE != null) {
                c.this.myE.showPostThreadLoadingView(false);
                if (z) {
                    c.this.muB = true;
                    if (writeData != null && writeData.getVideoReviewType() == 1) {
                        c.this.myE.showToast(true, c.this.myE.getContext().getResources().getString(R.string.video_send_success_under_review));
                    } else if (writeData != null && writeData.getVideoReviewType() == 2) {
                        c.this.myE.showToast(true, c.this.myE.getContext().getResources().getString(R.string.video_send_success));
                    } else if (writeData != null) {
                        String string = c.this.myE.getContext().getResources().getString(R.string.send_success);
                        if (postWriteCallBackData != null) {
                            str = postWriteCallBackData.getPreMsg();
                            str2 = postWriteCallBackData.getColorMsg();
                            string = postWriteCallBackData.getErrorString();
                        } else {
                            str = null;
                        }
                        if (writeData.getType() != 7) {
                            com.baidu.tieba.tbadkCore.writeModel.c.f(c.this.myE.getContext().getActivity(), string, str, str2);
                        }
                    }
                    Intent intent = new Intent();
                    Bundle bundle = new Bundle();
                    bundle.putSerializable("post_write_callback_data", postWriteCallBackData);
                    intent.putExtras(bundle);
                    BaseActivity context = c.this.myE.getContext();
                    c.this.myE.getContext();
                    context.setResult(-1, intent);
                    c.this.myE.getContext().finish();
                } else if (postWriteCallBackData != null && postWriteCallBackData.getErrorCode() == 227001) {
                    c.this.myE.getContext().setVisible(false);
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AccountAccessActivityConfig(c.this.myE.getContext().getActivity(), RequestResponseCode.REQUEST_VCODE, writeData, postWriteCallBackData.getAccessState())));
                } else if (postWriteCallBackData != null && postWriteCallBackData.getErrorCode() == 220015 && c.this.myF != null) {
                    if (c.this.myF != null) {
                        c.this.myF.callback(z, postWriteCallBackData, adVar, writeData, antiData);
                    }
                } else if (postWriteCallBackData != null) {
                    if (StringUtils.isNull(postWriteCallBackData.getErrorString())) {
                        c.this.myE.showToast(false, c.this.myE.getContext().getResources().getString(R.string.input_vcode_error));
                    } else {
                        c.this.myE.showToast(false, postWriteCallBackData.getErrorString());
                    }
                    c.this.dvn();
                }
            }
        }
    };

    public c(NewVcodeView newVcodeView, NewWriteModel newWriteModel) {
        this.myE = newVcodeView;
        this.muA = newWriteModel;
        this.muA.b(this.eCe);
    }

    @Override // com.baidu.tieba.write.vcode.newVcode.a.b
    public boolean c(WebView webView, String str) {
        if (str.contains("objc:jsChangeVcode")) {
            this.myH = com.baidu.tbadk.t.a.Ax(str);
            if (this.myH != null && this.muA.dhF() != null) {
                this.myE.runJsMethod(this.myH, "'" + this.muA.dhF().getVcodeUrl() + "'");
                return true;
            }
            return false;
        } else if (str.equals("objc:jumpToFeedback()")) {
            WriteActivityConfig writeActivityConfig = new WriteActivityConfig(this.myE.getContext().getActivity(), 0, TbConfig.getPositionPagerId(), TbConfig.getPositionPagerName(), null, null, 0, null, RequestResponseCode.REQUEST_WRITE_NEW, true, false, null, false, false, null, null, null, 0);
            writeActivityConfig.setIsVcodeFeedBack();
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, writeActivityConfig));
            return true;
        } else if (str.contains("objc:jsSubmit")) {
            return PM(com.baidu.tbadk.t.a.Ax(str));
        } else {
            return false;
        }
    }

    @Override // com.baidu.tieba.write.vcode.newVcode.a.b
    public void onPageFinished(WebView webView, String str) {
        if (this.myE != null) {
            this.myE.showWebViewDelay(500);
            if (this.myJ) {
                e.lt().postDelayed(this.myL, 500L);
            }
        }
    }

    @Override // com.baidu.tieba.write.vcode.newVcode.a.b
    public void D(boolean z, String str) {
        this.myJ = z;
        this.myK = str;
    }

    @Override // com.baidu.tieba.write.vcode.newVcode.a.b
    public void start(boolean z) {
        this.myE.setRatio(1.2631578f);
        this.myE.showWebView(false);
        String str = TbConfig.SERVER_ADDRESS_WEB_VIEW + Config.NEW_VCODE_WEBVIEW_ADDRESS;
        if (z) {
            str = str + "?feedback=1";
        }
        this.myE.getWebView().loadUrl(str);
    }

    @Override // com.baidu.tieba.write.vcode.newVcode.a.b
    public void onDestroy() {
        e.lt().removeCallbacks(this.myL);
    }

    @Override // com.baidu.tieba.write.vcode.newVcode.a.b
    public void d(NewWriteModel.d dVar) {
        this.myF = dVar;
    }

    @Override // com.baidu.tieba.write.vcode.newVcode.a.b
    public void dus() {
        this.myE.showPostThreadLoadingView(false);
        this.muA.cancelLoadData();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dvn() {
        this.myE.runJsMethod(this.myI, "'" + this.muA.dhF().getVcodeUrl() + "'");
    }

    private boolean PM(String str) {
        String[] split;
        if (StringUtils.isNull(str) || (split = str.split(Constants.ACCEPT_TIME_SEPARATOR_SP)) == null || split.length != 2) {
            return false;
        }
        this.myI = split[0];
        PL(split[1]);
        return true;
    }

    private void PL(String str) {
        this.muB = false;
        if (!l.isNetOk()) {
            this.myE.getContext().showToast(R.string.neterror);
            this.myE.getContext().finish();
        } else if (!StringUtils.isNull(str)) {
            this.myE.showPostThreadLoadingView(true);
            this.muA.dhF().setVcode(str);
            this.muA.dhF().setVcodeType("4");
            this.muA.dmx();
        } else {
            this.myE.getContext().showToast(R.string.neterror);
            this.myE.getContext().finish();
        }
    }
}
