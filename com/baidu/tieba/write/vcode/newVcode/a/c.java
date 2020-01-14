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
    private final NewWriteModel kLO;
    private final NewVcodeView kPl;
    private NewWriteModel.d kPm;
    private String kPo;
    private String kPp;
    private boolean kPq = false;
    private String kPr = null;
    private boolean kLP = false;
    private Runnable kPs = new Runnable() { // from class: com.baidu.tieba.write.vcode.newVcode.a.c.1
        @Override // java.lang.Runnable
        public void run() {
            if (c.this.kPl != null) {
                if (StringUtils.isNull(c.this.kPr)) {
                    c.this.kPl.showToast(false, c.this.kPl.getContext().getResources().getString(R.string.drag_vcode_error));
                } else {
                    c.this.kPl.showToast(false, c.this.kPr);
                }
            }
        }
    };
    private final NewWriteModel.d dut = new NewWriteModel.d() { // from class: com.baidu.tieba.write.vcode.newVcode.a.c.2
        @Override // com.baidu.tieba.tbadkCore.writeModel.NewWriteModel.d
        public void callback(boolean z, PostWriteCallBackData postWriteCallBackData, z zVar, WriteData writeData, AntiData antiData) {
            String str;
            String str2 = null;
            if (c.this.kPl != null) {
                c.this.kPl.showPostThreadLoadingView(false);
                if (z) {
                    c.this.kLP = true;
                    if (writeData != null && writeData.getVideoReviewType() == 1) {
                        c.this.kPl.showToast(true, c.this.kPl.getContext().getResources().getString(R.string.video_send_success_under_review));
                    } else if (writeData != null && writeData.getVideoReviewType() == 2) {
                        c.this.kPl.showToast(true, c.this.kPl.getContext().getResources().getString(R.string.video_send_success));
                    } else if (writeData != null) {
                        String string = c.this.kPl.getContext().getResources().getString(R.string.send_success);
                        if (postWriteCallBackData != null) {
                            str = postWriteCallBackData.getPreMsg();
                            str2 = postWriteCallBackData.getColorMsg();
                            string = postWriteCallBackData.getErrorString();
                        } else {
                            str = null;
                        }
                        if (writeData.getType() != 7) {
                            com.baidu.tieba.tbadkCore.writeModel.c.g(c.this.kPl.getContext().getActivity(), string, str, str2);
                        }
                    }
                    Intent intent = new Intent();
                    Bundle bundle = new Bundle();
                    bundle.putSerializable("post_write_callback_data", postWriteCallBackData);
                    intent.putExtras(bundle);
                    BaseActivity context = c.this.kPl.getContext();
                    c.this.kPl.getContext();
                    context.setResult(-1, intent);
                    c.this.kPl.getContext().finish();
                } else if (postWriteCallBackData != null && postWriteCallBackData.getErrorCode() == 227001) {
                    c.this.kPl.getContext().setVisible(false);
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AccountAccessActivityConfig(c.this.kPl.getContext().getActivity(), RequestResponseCode.REQUEST_VCODE, writeData, postWriteCallBackData.getAccessState())));
                } else if (postWriteCallBackData != null && postWriteCallBackData.getErrorCode() == 220015 && c.this.kPm != null) {
                    if (c.this.kPm != null) {
                        c.this.kPm.callback(z, postWriteCallBackData, zVar, writeData, antiData);
                    }
                } else if (postWriteCallBackData != null) {
                    if (StringUtils.isNull(postWriteCallBackData.getErrorString())) {
                        c.this.kPl.showToast(false, c.this.kPl.getContext().getResources().getString(R.string.input_vcode_error));
                    } else {
                        c.this.kPl.showToast(false, postWriteCallBackData.getErrorString());
                    }
                    c.this.cTM();
                }
            }
        }
    };

    public c(NewVcodeView newVcodeView, NewWriteModel newWriteModel) {
        this.kPl = newVcodeView;
        this.kLO = newWriteModel;
        this.kLO.b(this.dut);
    }

    @Override // com.baidu.tieba.write.vcode.newVcode.a.b
    public boolean c(WebView webView, String str) {
        if (str.contains("objc:jsChangeVcode")) {
            this.kPo = com.baidu.tbadk.s.a.vF(str);
            if (this.kPo != null && this.kLO.cGo() != null) {
                this.kPl.runJsMethod(this.kPo, "'" + this.kLO.cGo().getVcodeUrl() + "'");
                return true;
            }
            return false;
        } else if (str.equals("objc:jumpToFeedback()")) {
            WriteActivityConfig writeActivityConfig = new WriteActivityConfig(this.kPl.getContext().getActivity(), 0, TbConfig.getPositionPagerId(), TbConfig.getPositionPagerName(), null, null, 0, null, RequestResponseCode.REQUEST_WRITE_NEW, true, false, null, false, false, null, null, null, 0);
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
        if (this.kPl != null) {
            this.kPl.showWebViewDelay(500);
            if (this.kPq) {
                e.gx().postDelayed(this.kPs, 500L);
            }
        }
    }

    @Override // com.baidu.tieba.write.vcode.newVcode.a.b
    public void A(boolean z, String str) {
        this.kPq = z;
        this.kPr = str;
    }

    @Override // com.baidu.tieba.write.vcode.newVcode.a.b
    public void start(boolean z) {
        this.kPl.setRatio(1.2631578f);
        this.kPl.showWebView(false);
        String str = TbConfig.SERVER_ADDRESS_WEB_VIEW + Config.NEW_VCODE_WEBVIEW_ADDRESS;
        if (z) {
            str = str + "?feedback=1";
        }
        this.kPl.getWebView().loadUrl(str);
    }

    @Override // com.baidu.tieba.write.vcode.newVcode.a.b
    public void onDestroy() {
        e.gx().removeCallbacks(this.kPs);
    }

    @Override // com.baidu.tieba.write.vcode.newVcode.a.b
    public void d(NewWriteModel.d dVar) {
        this.kPm = dVar;
    }

    @Override // com.baidu.tieba.write.vcode.newVcode.a.b
    public void cTe() {
        this.kPl.showPostThreadLoadingView(false);
        this.kLO.cancelLoadData();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cTM() {
        this.kPl.runJsMethod(this.kPp, "'" + this.kLO.cGo().getVcodeUrl() + "'");
    }

    private boolean KI(String str) {
        String[] split;
        if (StringUtils.isNull(str) || (split = str.split(Constants.ACCEPT_TIME_SEPARATOR_SP)) == null || split.length != 2) {
            return false;
        }
        this.kPp = split[0];
        KH(split[1]);
        return true;
    }

    private void KH(String str) {
        this.kLP = false;
        if (!l.isNetOk()) {
            this.kPl.getContext().showToast(R.string.neterror);
            this.kPl.getContext().finish();
        } else if (!StringUtils.isNull(str)) {
            this.kPl.showPostThreadLoadingView(true);
            this.kLO.cGo().setVcode(str);
            this.kLO.cGo().setVcodeType("4");
            this.kLO.cKM();
        } else {
            this.kPl.getContext().showToast(R.string.neterror);
            this.kPl.getContext().finish();
        }
    }
}
