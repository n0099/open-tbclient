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
    private final NewWriteModel mMO;
    private final NewVcodeView mQT;
    private NewWriteModel.d mQU;
    private String mQW;
    private String mQX;
    private boolean mQY = false;
    private String mQZ = null;
    private boolean mMP = false;
    private Runnable mRa = new Runnable() { // from class: com.baidu.tieba.write.vcode.newVcode.a.c.1
        @Override // java.lang.Runnable
        public void run() {
            if (c.this.mQT != null) {
                if (StringUtils.isNull(c.this.mQZ)) {
                    c.this.mQT.showToast(false, c.this.mQT.getContext().getResources().getString(R.string.drag_vcode_error));
                } else {
                    c.this.mQT.showToast(false, c.this.mQZ);
                }
            }
        }
    };
    private final NewWriteModel.d eMD = new NewWriteModel.d() { // from class: com.baidu.tieba.write.vcode.newVcode.a.c.2
        @Override // com.baidu.tieba.tbadkCore.writeModel.NewWriteModel.d
        public void callback(boolean z, PostWriteCallBackData postWriteCallBackData, ag agVar, WriteData writeData, AntiData antiData) {
            String str;
            String str2 = null;
            if (c.this.mQT != null) {
                c.this.mQT.showPostThreadLoadingView(false);
                if (z) {
                    c.this.mMP = true;
                    if (writeData != null && writeData.getVideoReviewType() == 1) {
                        c.this.mQT.showToast(true, c.this.mQT.getContext().getResources().getString(R.string.video_send_success_under_review));
                    } else if (writeData != null && writeData.getVideoReviewType() == 2) {
                        c.this.mQT.showToast(true, c.this.mQT.getContext().getResources().getString(R.string.video_send_success));
                    } else if (writeData != null) {
                        String string = c.this.mQT.getContext().getResources().getString(R.string.send_success);
                        if (postWriteCallBackData != null) {
                            str = postWriteCallBackData.getPreMsg();
                            str2 = postWriteCallBackData.getColorMsg();
                            string = postWriteCallBackData.getErrorString();
                        } else {
                            str = null;
                        }
                        if (writeData.getType() != 7) {
                            com.baidu.tieba.tbadkCore.writeModel.c.g(c.this.mQT.getContext().getActivity(), string, str, str2);
                        }
                    }
                    Intent intent = new Intent();
                    Bundle bundle = new Bundle();
                    bundle.putSerializable("post_write_callback_data", postWriteCallBackData);
                    intent.putExtras(bundle);
                    BaseActivity context = c.this.mQT.getContext();
                    c.this.mQT.getContext();
                    context.setResult(-1, intent);
                    c.this.mQT.getContext().finish();
                } else if (postWriteCallBackData != null && postWriteCallBackData.getErrorCode() == 227001) {
                    c.this.mQT.getContext().setVisible(false);
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AccountAccessActivityConfig(c.this.mQT.getContext().getActivity(), RequestResponseCode.REQUEST_VCODE, writeData, postWriteCallBackData.getAccessState())));
                } else if (postWriteCallBackData != null && postWriteCallBackData.getErrorCode() == 220015 && c.this.mQU != null) {
                    if (c.this.mQU != null) {
                        c.this.mQU.callback(z, postWriteCallBackData, agVar, writeData, antiData);
                    }
                } else if (postWriteCallBackData != null) {
                    if (StringUtils.isNull(postWriteCallBackData.getErrorString())) {
                        c.this.mQT.showToast(false, c.this.mQT.getContext().getResources().getString(R.string.input_vcode_error));
                    } else {
                        c.this.mQT.showToast(false, postWriteCallBackData.getErrorString());
                    }
                    c.this.dGJ();
                }
            }
        }
    };

    public c(NewVcodeView newVcodeView, NewWriteModel newWriteModel) {
        this.mQT = newVcodeView;
        this.mMO = newWriteModel;
        this.mMO.b(this.eMD);
    }

    @Override // com.baidu.tieba.write.vcode.newVcode.a.b
    public boolean b(WebView webView, String str) {
        if (str.contains("objc:jsChangeVcode")) {
            this.mQW = com.baidu.tbadk.t.a.CN(str);
            if (this.mQW != null && this.mMO.cKZ() != null) {
                this.mQT.runJsMethod(this.mQW, "'" + this.mMO.cKZ().getVcodeUrl() + "'");
                return true;
            }
            return false;
        } else if (str.equals("objc:jumpToFeedback()")) {
            WriteActivityConfig writeActivityConfig = new WriteActivityConfig(this.mQT.getContext().getActivity(), 0, TbConfig.getPositionPagerId(), TbConfig.getPositionPagerName(), null, null, 0, null, RequestResponseCode.REQUEST_WRITE_NEW, true, false, null, false, false, null, null, null, 0);
            writeActivityConfig.setIsVcodeFeedBack();
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, writeActivityConfig));
            return true;
        } else if (str.contains("objc:jsSubmit")) {
            return SK(com.baidu.tbadk.t.a.CN(str));
        } else {
            return false;
        }
    }

    @Override // com.baidu.tieba.write.vcode.newVcode.a.b
    public void onPageFinished(WebView webView, String str) {
        if (this.mQT != null) {
            this.mQT.showWebViewDelay(500);
            if (this.mQY) {
                e.mS().postDelayed(this.mRa, 500L);
            }
        }
    }

    @Override // com.baidu.tieba.write.vcode.newVcode.a.b
    public void E(boolean z, String str) {
        this.mQY = z;
        this.mQZ = str;
    }

    @Override // com.baidu.tieba.write.vcode.newVcode.a.b
    public void start(boolean z) {
        this.mQT.setRatio(1.2631578f);
        this.mQT.showWebView(false);
        String str = TbConfig.SERVER_ADDRESS_WEB_VIEW + Config.NEW_VCODE_WEBVIEW_ADDRESS;
        if (z) {
            str = str + "?feedback=1";
        }
        this.mQT.getWebView().loadUrl(str);
    }

    @Override // com.baidu.tieba.write.vcode.newVcode.a.b
    public void onDestroy() {
        e.mS().removeCallbacks(this.mRa);
    }

    @Override // com.baidu.tieba.write.vcode.newVcode.a.b
    public void d(NewWriteModel.d dVar) {
        this.mQU = dVar;
    }

    @Override // com.baidu.tieba.write.vcode.newVcode.a.b
    public void dFO() {
        this.mQT.showPostThreadLoadingView(false);
        this.mMO.cancelLoadData();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dGJ() {
        this.mQT.runJsMethod(this.mQX, "'" + this.mMO.cKZ().getVcodeUrl() + "'");
    }

    private boolean SK(String str) {
        String[] split;
        if (StringUtils.isNull(str) || (split = str.split(Constants.ACCEPT_TIME_SEPARATOR_SP)) == null || split.length != 2) {
            return false;
        }
        this.mQX = split[0];
        SJ(split[1]);
        return true;
    }

    private void SJ(String str) {
        this.mMP = false;
        if (!l.isNetOk()) {
            this.mQT.getContext().showToast(R.string.neterror);
            this.mQT.getContext().finish();
        } else if (!StringUtils.isNull(str)) {
            this.mQT.showPostThreadLoadingView(true);
            this.mMO.cKZ().setVcode(str);
            this.mMO.cKZ().setVcodeType("4");
            this.mMO.dxS();
        } else {
            this.mQT.getContext().showToast(R.string.neterror);
            this.mQT.getContext().finish();
        }
    }
}
