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
import com.baidu.tbadk.coreExtra.data.ag;
import com.baidu.tieba.R;
import com.baidu.tieba.tbadkCore.writeModel.NewWriteModel;
import com.baidu.tieba.tbadkCore.writeModel.PostWriteCallBackData;
import com.baidu.tieba.write.vcode.newVcode.NewVcodeView;
import com.xiaomi.mipush.sdk.Constants;
/* loaded from: classes3.dex */
public class c implements b {
    private final NewWriteModel mNg;
    private final NewVcodeView mRm;
    private NewWriteModel.d mRn;
    private String mRp;
    private String mRq;
    private boolean mRr = false;
    private String mRs = null;
    private boolean mNh = false;
    private Runnable mRt = new Runnable() { // from class: com.baidu.tieba.write.vcode.newVcode.a.c.1
        @Override // java.lang.Runnable
        public void run() {
            if (c.this.mRm != null) {
                if (StringUtils.isNull(c.this.mRs)) {
                    c.this.mRm.showToast(false, c.this.mRm.getContext().getResources().getString(R.string.drag_vcode_error));
                } else {
                    c.this.mRm.showToast(false, c.this.mRs);
                }
            }
        }
    };
    private final NewWriteModel.d eMH = new NewWriteModel.d() { // from class: com.baidu.tieba.write.vcode.newVcode.a.c.2
        @Override // com.baidu.tieba.tbadkCore.writeModel.NewWriteModel.d
        public void callback(boolean z, PostWriteCallBackData postWriteCallBackData, ag agVar, WriteData writeData, AntiData antiData) {
            String str;
            String str2 = null;
            if (c.this.mRm != null) {
                c.this.mRm.showPostThreadLoadingView(false);
                if (z) {
                    c.this.mNh = true;
                    if (writeData != null && writeData.getVideoReviewType() == 1) {
                        c.this.mRm.showToast(true, c.this.mRm.getContext().getResources().getString(R.string.video_send_success_under_review));
                    } else if (writeData != null && writeData.getVideoReviewType() == 2) {
                        c.this.mRm.showToast(true, c.this.mRm.getContext().getResources().getString(R.string.video_send_success));
                    } else if (writeData != null) {
                        String string = c.this.mRm.getContext().getResources().getString(R.string.send_success);
                        if (postWriteCallBackData != null) {
                            str = postWriteCallBackData.getPreMsg();
                            str2 = postWriteCallBackData.getColorMsg();
                            string = postWriteCallBackData.getErrorString();
                        } else {
                            str = null;
                        }
                        if (writeData.getType() != 7) {
                            com.baidu.tieba.tbadkCore.writeModel.c.g(c.this.mRm.getContext().getActivity(), string, str, str2);
                        }
                    }
                    Intent intent = new Intent();
                    Bundle bundle = new Bundle();
                    bundle.putSerializable("post_write_callback_data", postWriteCallBackData);
                    intent.putExtras(bundle);
                    BaseActivity context = c.this.mRm.getContext();
                    c.this.mRm.getContext();
                    context.setResult(-1, intent);
                    c.this.mRm.getContext().finish();
                } else if (postWriteCallBackData != null && postWriteCallBackData.getErrorCode() == 227001) {
                    c.this.mRm.getContext().setVisible(false);
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AccountAccessActivityConfig(c.this.mRm.getContext().getActivity(), RequestResponseCode.REQUEST_VCODE, writeData, postWriteCallBackData.getAccessState())));
                } else if (postWriteCallBackData != null && postWriteCallBackData.getErrorCode() == 220015 && c.this.mRn != null) {
                    if (c.this.mRn != null) {
                        c.this.mRn.callback(z, postWriteCallBackData, agVar, writeData, antiData);
                    }
                } else if (postWriteCallBackData != null) {
                    if (StringUtils.isNull(postWriteCallBackData.getErrorString())) {
                        c.this.mRm.showToast(false, c.this.mRm.getContext().getResources().getString(R.string.input_vcode_error));
                    } else {
                        c.this.mRm.showToast(false, postWriteCallBackData.getErrorString());
                    }
                    c.this.dGS();
                }
            }
        }
    };

    public c(NewVcodeView newVcodeView, NewWriteModel newWriteModel) {
        this.mRm = newVcodeView;
        this.mNg = newWriteModel;
        this.mNg.b(this.eMH);
    }

    @Override // com.baidu.tieba.write.vcode.newVcode.a.b
    public boolean b(WebView webView, String str) {
        if (str.contains("objc:jsChangeVcode")) {
            this.mRp = com.baidu.tbadk.t.a.CO(str);
            if (this.mRp != null && this.mNg.cLa() != null) {
                this.mRm.runJsMethod(this.mRp, "'" + this.mNg.cLa().getVcodeUrl() + "'");
                return true;
            }
            return false;
        } else if (str.equals("objc:jumpToFeedback()")) {
            WriteActivityConfig writeActivityConfig = new WriteActivityConfig(this.mRm.getContext().getActivity(), 0, TbConfig.getPositionPagerId(), TbConfig.getPositionPagerName(), null, null, 0, null, RequestResponseCode.REQUEST_WRITE_NEW, true, false, null, false, false, null, null, null, 0);
            writeActivityConfig.setIsVcodeFeedBack();
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, writeActivityConfig));
            return true;
        } else if (str.contains("objc:jsSubmit")) {
            return SK(com.baidu.tbadk.t.a.CO(str));
        } else {
            return false;
        }
    }

    @Override // com.baidu.tieba.write.vcode.newVcode.a.b
    public void onPageFinished(WebView webView, String str) {
        if (this.mRm != null) {
            this.mRm.showWebViewDelay(500);
            if (this.mRr) {
                e.mS().postDelayed(this.mRt, 500L);
            }
        }
    }

    @Override // com.baidu.tieba.write.vcode.newVcode.a.b
    public void E(boolean z, String str) {
        this.mRr = z;
        this.mRs = str;
    }

    @Override // com.baidu.tieba.write.vcode.newVcode.a.b
    public void start(boolean z) {
        this.mRm.setRatio(1.2631578f);
        this.mRm.showWebView(false);
        String str = TbConfig.SERVER_ADDRESS_WEB_VIEW + Config.NEW_VCODE_WEBVIEW_ADDRESS;
        if (z) {
            str = str + "?feedback=1";
        }
        this.mRm.getWebView().loadUrl(str);
    }

    @Override // com.baidu.tieba.write.vcode.newVcode.a.b
    public void onDestroy() {
        e.mS().removeCallbacks(this.mRt);
    }

    @Override // com.baidu.tieba.write.vcode.newVcode.a.b
    public void d(NewWriteModel.d dVar) {
        this.mRn = dVar;
    }

    @Override // com.baidu.tieba.write.vcode.newVcode.a.b
    public void dFX() {
        this.mRm.showPostThreadLoadingView(false);
        this.mNg.cancelLoadData();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dGS() {
        this.mRm.runJsMethod(this.mRq, "'" + this.mNg.cLa().getVcodeUrl() + "'");
    }

    private boolean SK(String str) {
        String[] split;
        if (StringUtils.isNull(str) || (split = str.split(Constants.ACCEPT_TIME_SEPARATOR_SP)) == null || split.length != 2) {
            return false;
        }
        this.mRq = split[0];
        SJ(split[1]);
        return true;
    }

    private void SJ(String str) {
        this.mNh = false;
        if (!l.isNetOk()) {
            this.mRm.getContext().showToast(R.string.neterror);
            this.mRm.getContext().finish();
        } else if (!StringUtils.isNull(str)) {
            this.mRm.showPostThreadLoadingView(true);
            this.mNg.cLa().setVcode(str);
            this.mNg.cLa().setVcodeType("4");
            this.mNg.dxX();
        } else {
            this.mRm.getContext().showToast(R.string.neterror);
            this.mRm.getContext().finish();
        }
    }
}
