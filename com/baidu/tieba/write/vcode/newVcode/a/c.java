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
/* loaded from: classes2.dex */
public class c implements b {
    private final NewWriteModel lRb;
    private final NewVcodeView lUV;
    private NewWriteModel.d lUW;
    private String lUY;
    private String lUZ;
    private boolean lVa = false;
    private String lVb = null;
    private boolean lRc = false;
    private Runnable lVc = new Runnable() { // from class: com.baidu.tieba.write.vcode.newVcode.a.c.1
        @Override // java.lang.Runnable
        public void run() {
            if (c.this.lUV != null) {
                if (StringUtils.isNull(c.this.lVb)) {
                    c.this.lUV.showToast(false, c.this.lUV.getContext().getResources().getString(R.string.drag_vcode_error));
                } else {
                    c.this.lUV.showToast(false, c.this.lVb);
                }
            }
        }
    };
    private final NewWriteModel.d emV = new NewWriteModel.d() { // from class: com.baidu.tieba.write.vcode.newVcode.a.c.2
        @Override // com.baidu.tieba.tbadkCore.writeModel.NewWriteModel.d
        public void callback(boolean z, PostWriteCallBackData postWriteCallBackData, aa aaVar, WriteData writeData, AntiData antiData) {
            String str;
            String str2 = null;
            if (c.this.lUV != null) {
                c.this.lUV.showPostThreadLoadingView(false);
                if (z) {
                    c.this.lRc = true;
                    if (writeData != null && writeData.getVideoReviewType() == 1) {
                        c.this.lUV.showToast(true, c.this.lUV.getContext().getResources().getString(R.string.video_send_success_under_review));
                    } else if (writeData != null && writeData.getVideoReviewType() == 2) {
                        c.this.lUV.showToast(true, c.this.lUV.getContext().getResources().getString(R.string.video_send_success));
                    } else if (writeData != null) {
                        String string = c.this.lUV.getContext().getResources().getString(R.string.send_success);
                        if (postWriteCallBackData != null) {
                            str = postWriteCallBackData.getPreMsg();
                            str2 = postWriteCallBackData.getColorMsg();
                            string = postWriteCallBackData.getErrorString();
                        } else {
                            str = null;
                        }
                        if (writeData.getType() != 7) {
                            com.baidu.tieba.tbadkCore.writeModel.c.f(c.this.lUV.getContext().getActivity(), string, str, str2);
                        }
                    }
                    Intent intent = new Intent();
                    Bundle bundle = new Bundle();
                    bundle.putSerializable("post_write_callback_data", postWriteCallBackData);
                    intent.putExtras(bundle);
                    BaseActivity context = c.this.lUV.getContext();
                    c.this.lUV.getContext();
                    context.setResult(-1, intent);
                    c.this.lUV.getContext().finish();
                } else if (postWriteCallBackData != null && postWriteCallBackData.getErrorCode() == 227001) {
                    c.this.lUV.getContext().setVisible(false);
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AccountAccessActivityConfig(c.this.lUV.getContext().getActivity(), RequestResponseCode.REQUEST_VCODE, writeData, postWriteCallBackData.getAccessState())));
                } else if (postWriteCallBackData != null && postWriteCallBackData.getErrorCode() == 220015 && c.this.lUW != null) {
                    if (c.this.lUW != null) {
                        c.this.lUW.callback(z, postWriteCallBackData, aaVar, writeData, antiData);
                    }
                } else if (postWriteCallBackData != null) {
                    if (StringUtils.isNull(postWriteCallBackData.getErrorString())) {
                        c.this.lUV.showToast(false, c.this.lUV.getContext().getResources().getString(R.string.input_vcode_error));
                    } else {
                        c.this.lUV.showToast(false, postWriteCallBackData.getErrorString());
                    }
                    c.this.dnu();
                }
            }
        }
    };

    public c(NewVcodeView newVcodeView, NewWriteModel newWriteModel) {
        this.lUV = newVcodeView;
        this.lRb = newWriteModel;
        this.lRb.b(this.emV);
    }

    @Override // com.baidu.tieba.write.vcode.newVcode.a.b
    public boolean c(WebView webView, String str) {
        if (str.contains("objc:jsChangeVcode")) {
            this.lUY = com.baidu.tbadk.s.a.yW(str);
            if (this.lUY != null && this.lRb.cZP() != null) {
                this.lUV.runJsMethod(this.lUY, "'" + this.lRb.cZP().getVcodeUrl() + "'");
                return true;
            }
            return false;
        } else if (str.equals("objc:jumpToFeedback()")) {
            WriteActivityConfig writeActivityConfig = new WriteActivityConfig(this.lUV.getContext().getActivity(), 0, TbConfig.getPositionPagerId(), TbConfig.getPositionPagerName(), null, null, 0, null, RequestResponseCode.REQUEST_WRITE_NEW, true, false, null, false, false, null, null, null, 0);
            writeActivityConfig.setIsVcodeFeedBack();
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, writeActivityConfig));
            return true;
        } else if (str.contains("objc:jsSubmit")) {
            return Os(com.baidu.tbadk.s.a.yW(str));
        } else {
            return false;
        }
    }

    @Override // com.baidu.tieba.write.vcode.newVcode.a.b
    public void onPageFinished(WebView webView, String str) {
        if (this.lUV != null) {
            this.lUV.showWebViewDelay(500);
            if (this.lVa) {
                e.ld().postDelayed(this.lVc, 500L);
            }
        }
    }

    @Override // com.baidu.tieba.write.vcode.newVcode.a.b
    public void B(boolean z, String str) {
        this.lVa = z;
        this.lVb = str;
    }

    @Override // com.baidu.tieba.write.vcode.newVcode.a.b
    public void start(boolean z) {
        this.lUV.setRatio(1.2631578f);
        this.lUV.showWebView(false);
        String str = TbConfig.SERVER_ADDRESS_WEB_VIEW + Config.NEW_VCODE_WEBVIEW_ADDRESS;
        if (z) {
            str = str + "?feedback=1";
        }
        this.lUV.getWebView().loadUrl(str);
    }

    @Override // com.baidu.tieba.write.vcode.newVcode.a.b
    public void onDestroy() {
        e.ld().removeCallbacks(this.lVc);
    }

    @Override // com.baidu.tieba.write.vcode.newVcode.a.b
    public void d(NewWriteModel.d dVar) {
        this.lUW = dVar;
    }

    @Override // com.baidu.tieba.write.vcode.newVcode.a.b
    public void dmz() {
        this.lUV.showPostThreadLoadingView(false);
        this.lRb.cancelLoadData();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dnu() {
        this.lUV.runJsMethod(this.lUZ, "'" + this.lRb.cZP().getVcodeUrl() + "'");
    }

    private boolean Os(String str) {
        String[] split;
        if (StringUtils.isNull(str) || (split = str.split(Constants.ACCEPT_TIME_SEPARATOR_SP)) == null || split.length != 2) {
            return false;
        }
        this.lUZ = split[0];
        Or(split[1]);
        return true;
    }

    private void Or(String str) {
        this.lRc = false;
        if (!l.isNetOk()) {
            this.lUV.getContext().showToast(R.string.neterror);
            this.lUV.getContext().finish();
        } else if (!StringUtils.isNull(str)) {
            this.lUV.showPostThreadLoadingView(true);
            this.lRb.cZP().setVcode(str);
            this.lRb.cZP().setVcodeType("4");
            this.lRb.deN();
        } else {
            this.lUV.getContext().showToast(R.string.neterror);
            this.lUV.getContext().finish();
        }
    }
}
