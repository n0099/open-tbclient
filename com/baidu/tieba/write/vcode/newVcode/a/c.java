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
import com.baidu.tbadk.coreExtra.data.z;
import com.baidu.tieba.R;
import com.baidu.tieba.tbadkCore.writeModel.NewWriteModel;
import com.baidu.tieba.tbadkCore.writeModel.PostWriteCallBackData;
import com.baidu.tieba.write.vcode.newVcode.NewVcodeView;
import com.xiaomi.mipush.sdk.Constants;
/* loaded from: classes11.dex */
public class c implements b {
    private final NewWriteModel kLJ;
    private final NewVcodeView kPg;
    private NewWriteModel.d kPh;
    private String kPj;
    private String kPk;
    private boolean kPl = false;
    private String kPm = null;
    private boolean kLK = false;
    private Runnable kPn = new Runnable() { // from class: com.baidu.tieba.write.vcode.newVcode.a.c.1
        @Override // java.lang.Runnable
        public void run() {
            if (c.this.kPg != null) {
                if (StringUtils.isNull(c.this.kPm)) {
                    c.this.kPg.showToast(false, c.this.kPg.getContext().getResources().getString(R.string.drag_vcode_error));
                } else {
                    c.this.kPg.showToast(false, c.this.kPm);
                }
            }
        }
    };
    private final NewWriteModel.d dut = new NewWriteModel.d() { // from class: com.baidu.tieba.write.vcode.newVcode.a.c.2
        @Override // com.baidu.tieba.tbadkCore.writeModel.NewWriteModel.d
        public void callback(boolean z, PostWriteCallBackData postWriteCallBackData, z zVar, WriteData writeData, AntiData antiData) {
            String str;
            String str2 = null;
            if (c.this.kPg != null) {
                c.this.kPg.showPostThreadLoadingView(false);
                if (z) {
                    c.this.kLK = true;
                    if (writeData != null && writeData.getVideoReviewType() == 1) {
                        c.this.kPg.showToast(true, c.this.kPg.getContext().getResources().getString(R.string.video_send_success_under_review));
                    } else if (writeData != null && writeData.getVideoReviewType() == 2) {
                        c.this.kPg.showToast(true, c.this.kPg.getContext().getResources().getString(R.string.video_send_success));
                    } else if (writeData != null) {
                        String string = c.this.kPg.getContext().getResources().getString(R.string.send_success);
                        if (postWriteCallBackData != null) {
                            str = postWriteCallBackData.getPreMsg();
                            str2 = postWriteCallBackData.getColorMsg();
                            string = postWriteCallBackData.getErrorString();
                        } else {
                            str = null;
                        }
                        if (writeData.getType() != 7) {
                            com.baidu.tieba.tbadkCore.writeModel.c.g(c.this.kPg.getContext().getActivity(), string, str, str2);
                        }
                    }
                    Intent intent = new Intent();
                    Bundle bundle = new Bundle();
                    bundle.putSerializable("post_write_callback_data", postWriteCallBackData);
                    intent.putExtras(bundle);
                    BaseActivity context = c.this.kPg.getContext();
                    c.this.kPg.getContext();
                    context.setResult(-1, intent);
                    c.this.kPg.getContext().finish();
                } else if (postWriteCallBackData != null && postWriteCallBackData.getErrorCode() == 227001) {
                    c.this.kPg.getContext().setVisible(false);
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AccountAccessActivityConfig(c.this.kPg.getContext().getActivity(), RequestResponseCode.REQUEST_VCODE, writeData, postWriteCallBackData.getAccessState())));
                } else if (postWriteCallBackData != null && postWriteCallBackData.getErrorCode() == 220015 && c.this.kPh != null) {
                    if (c.this.kPh != null) {
                        c.this.kPh.callback(z, postWriteCallBackData, zVar, writeData, antiData);
                    }
                } else if (postWriteCallBackData != null) {
                    if (StringUtils.isNull(postWriteCallBackData.getErrorString())) {
                        c.this.kPg.showToast(false, c.this.kPg.getContext().getResources().getString(R.string.input_vcode_error));
                    } else {
                        c.this.kPg.showToast(false, postWriteCallBackData.getErrorString());
                    }
                    c.this.cTK();
                }
            }
        }
    };

    public c(NewVcodeView newVcodeView, NewWriteModel newWriteModel) {
        this.kPg = newVcodeView;
        this.kLJ = newWriteModel;
        this.kLJ.b(this.dut);
    }

    @Override // com.baidu.tieba.write.vcode.newVcode.a.b
    public boolean c(WebView webView, String str) {
        if (str.contains("objc:jsChangeVcode")) {
            this.kPj = com.baidu.tbadk.s.a.vF(str);
            if (this.kPj != null && this.kLJ.cGm() != null) {
                this.kPg.runJsMethod(this.kPj, "'" + this.kLJ.cGm().getVcodeUrl() + "'");
                return true;
            }
            return false;
        } else if (str.equals("objc:jumpToFeedback()")) {
            WriteActivityConfig writeActivityConfig = new WriteActivityConfig(this.kPg.getContext().getActivity(), 0, TbConfig.getPositionPagerId(), TbConfig.getPositionPagerName(), null, null, 0, null, RequestResponseCode.REQUEST_WRITE_NEW, true, false, null, false, false, null, null, null, 0);
            writeActivityConfig.setIsVcodeFeedBack();
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, writeActivityConfig));
            return true;
        } else if (str.contains("objc:jsSubmit")) {
            return KI(com.baidu.tbadk.s.a.vF(str));
        } else {
            return false;
        }
    }

    @Override // com.baidu.tieba.write.vcode.newVcode.a.b
    public void onPageFinished(WebView webView, String str) {
        if (this.kPg != null) {
            this.kPg.showWebViewDelay(500);
            if (this.kPl) {
                e.gx().postDelayed(this.kPn, 500L);
            }
        }
    }

    @Override // com.baidu.tieba.write.vcode.newVcode.a.b
    public void A(boolean z, String str) {
        this.kPl = z;
        this.kPm = str;
    }

    @Override // com.baidu.tieba.write.vcode.newVcode.a.b
    public void start(boolean z) {
        this.kPg.setRatio(1.2631578f);
        this.kPg.showWebView(false);
        String str = TbConfig.SERVER_ADDRESS_WEB_VIEW + Config.NEW_VCODE_WEBVIEW_ADDRESS;
        if (z) {
            str = str + "?feedback=1";
        }
        this.kPg.getWebView().loadUrl(str);
    }

    @Override // com.baidu.tieba.write.vcode.newVcode.a.b
    public void onDestroy() {
        e.gx().removeCallbacks(this.kPn);
    }

    @Override // com.baidu.tieba.write.vcode.newVcode.a.b
    public void d(NewWriteModel.d dVar) {
        this.kPh = dVar;
    }

    @Override // com.baidu.tieba.write.vcode.newVcode.a.b
    public void cTc() {
        this.kPg.showPostThreadLoadingView(false);
        this.kLJ.cancelLoadData();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cTK() {
        this.kPg.runJsMethod(this.kPk, "'" + this.kLJ.cGm().getVcodeUrl() + "'");
    }

    private boolean KI(String str) {
        String[] split;
        if (StringUtils.isNull(str) || (split = str.split(Constants.ACCEPT_TIME_SEPARATOR_SP)) == null || split.length != 2) {
            return false;
        }
        this.kPk = split[0];
        KH(split[1]);
        return true;
    }

    private void KH(String str) {
        this.kLK = false;
        if (!l.isNetOk()) {
            this.kPg.getContext().showToast(R.string.neterror);
            this.kPg.getContext().finish();
        } else if (!StringUtils.isNull(str)) {
            this.kPg.showPostThreadLoadingView(true);
            this.kLJ.cGm().setVcode(str);
            this.kLJ.cGm().setVcodeType("4");
            this.kLJ.cKK();
        } else {
            this.kPg.getContext().showToast(R.string.neterror);
            this.kPg.getContext().finish();
        }
    }
}
