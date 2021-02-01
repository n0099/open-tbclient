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
import com.baidu.tieba.tbadkCore.writeModel.g;
import com.baidu.tieba.write.vcode.newVcode.NewVcodeView;
/* loaded from: classes8.dex */
public class c implements b {
    private final NewWriteModel odB;
    private final NewVcodeView ogZ;
    private NewWriteModel.d oha;
    private String ohc;
    private String ohd;
    private boolean ohe = false;
    private String ohf = null;
    private boolean odC = false;
    private Runnable ohg = new Runnable() { // from class: com.baidu.tieba.write.vcode.newVcode.a.c.1
        @Override // java.lang.Runnable
        public void run() {
            if (c.this.ogZ != null) {
                if (StringUtils.isNull(c.this.ohf)) {
                    c.this.ogZ.showToast(false, c.this.ogZ.getContext().getResources().getString(R.string.drag_vcode_error));
                } else {
                    c.this.ogZ.showToast(false, c.this.ohf);
                }
            }
        }
    };
    private final NewWriteModel.d fDW = new NewWriteModel.d() { // from class: com.baidu.tieba.write.vcode.newVcode.a.c.2
        @Override // com.baidu.tieba.tbadkCore.writeModel.NewWriteModel.d
        public void callback(boolean z, PostWriteCallBackData postWriteCallBackData, ah ahVar, WriteData writeData, AntiData antiData) {
            String str;
            String str2;
            if (c.this.ogZ != null) {
                c.this.ogZ.showPostThreadLoadingView(false);
                if (z) {
                    c.this.odC = true;
                    if (writeData != null && writeData.getVideoReviewType() == 1) {
                        c.this.ogZ.showToast(true, c.this.ogZ.getContext().getResources().getString(R.string.video_send_success_under_review));
                    } else if (writeData != null && writeData.getVideoReviewType() == 2) {
                        c.this.ogZ.showToast(true, c.this.ogZ.getContext().getResources().getString(R.string.video_send_success));
                    } else if (writeData != null) {
                        String string = c.this.ogZ.getContext().getResources().getString(R.string.send_success);
                        if (postWriteCallBackData != null) {
                            String preMsg = postWriteCallBackData.getPreMsg();
                            str = postWriteCallBackData.getColorMsg();
                            string = postWriteCallBackData.getErrorString();
                            str2 = preMsg;
                        } else {
                            str = null;
                            str2 = null;
                        }
                        if (writeData.getType() != 7) {
                            g.i(c.this.ogZ.getContext().getActivity(), string, str2, str);
                        }
                    }
                    Intent intent = new Intent();
                    Bundle bundle = new Bundle();
                    bundle.putSerializable("post_write_callback_data", postWriteCallBackData);
                    intent.putExtras(bundle);
                    BaseActivity context = c.this.ogZ.getContext();
                    c.this.ogZ.getContext();
                    context.setResult(-1, intent);
                    c.this.ogZ.getContext().finish();
                } else if (postWriteCallBackData != null && postWriteCallBackData.getErrorCode() == 227001) {
                    c.this.ogZ.getContext().setVisible(false);
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AccountAccessActivityConfig(c.this.ogZ.getContext().getActivity(), RequestResponseCode.REQUEST_VCODE, writeData, postWriteCallBackData.getAccessState())));
                } else if (postWriteCallBackData != null && postWriteCallBackData.getErrorCode() == 220015 && c.this.oha != null) {
                    if (c.this.oha != null) {
                        c.this.oha.callback(z, postWriteCallBackData, ahVar, writeData, antiData);
                    }
                } else if (postWriteCallBackData != null) {
                    if (StringUtils.isNull(postWriteCallBackData.getErrorString())) {
                        c.this.ogZ.showToast(false, c.this.ogZ.getContext().getResources().getString(R.string.input_vcode_error));
                    } else {
                        c.this.ogZ.showToast(false, postWriteCallBackData.getErrorString());
                    }
                    c.this.dXu();
                }
            }
        }
    };

    public c(NewVcodeView newVcodeView, NewWriteModel newWriteModel) {
        this.ogZ = newVcodeView;
        this.odB = newWriteModel;
        this.odB.b(this.fDW);
    }

    @Override // com.baidu.tieba.write.vcode.newVcode.a.b
    public boolean c(WebView webView, String str) {
        if (str.contains("objc:jsChangeVcode")) {
            this.ohc = com.baidu.tbadk.t.a.DZ(str);
            if (this.ohc == null || this.odB.dav() == null) {
                return false;
            }
            this.ogZ.runJsMethod(this.ohc, "'" + this.odB.dav().getVcodeUrl() + "'");
            return true;
        } else if (str.equals("objc:jumpToFeedback()")) {
            if (WriteActivityConfig.isAsyncWriting()) {
                return false;
            }
            WriteActivityConfig.newInstance(this.ogZ.getContext()).setType(0).setForumId(TbConfig.getPositionPagerId()).setForumName(TbConfig.getPositionPagerName()).setIsVcodeFeedBack().send();
            return true;
        } else if (str.contains("objc:jsSubmit")) {
            return Vg(com.baidu.tbadk.t.a.DZ(str));
        } else {
            return false;
        }
    }

    @Override // com.baidu.tieba.write.vcode.newVcode.a.b
    public void onPageFinished(WebView webView, String str) {
        if (this.ogZ != null) {
            this.ogZ.showWebViewDelay(500);
            if (this.ohe) {
                e.mA().postDelayed(this.ohg, 500L);
            }
        }
    }

    @Override // com.baidu.tieba.write.vcode.newVcode.a.b
    public void P(boolean z, String str) {
        this.ohe = z;
        this.ohf = str;
    }

    @Override // com.baidu.tieba.write.vcode.newVcode.a.b
    public void start(boolean z) {
        this.ogZ.setRatio(1.2631578f);
        this.ogZ.showWebView(false);
        String str = TbConfig.SERVER_ADDRESS_WEB_VIEW + Config.NEW_VCODE_WEBVIEW_ADDRESS;
        if (z) {
            str = str + "?feedback=1";
        }
        this.ogZ.getWebView().loadUrl(str);
    }

    @Override // com.baidu.tieba.write.vcode.newVcode.a.b
    public void onDestroy() {
        e.mA().removeCallbacks(this.ohg);
    }

    @Override // com.baidu.tieba.write.vcode.newVcode.a.b
    public void d(NewWriteModel.d dVar) {
        this.oha = dVar;
    }

    @Override // com.baidu.tieba.write.vcode.newVcode.a.b
    public void dWG() {
        this.ogZ.showPostThreadLoadingView(false);
        this.odB.cancelLoadData();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dXu() {
        this.ogZ.runJsMethod(this.ohd, "'" + this.odB.dav().getVcodeUrl() + "'");
    }

    private boolean Vg(String str) {
        String[] split;
        if (StringUtils.isNull(str) || (split = str.split(",")) == null || split.length != 2) {
            return false;
        }
        this.ohd = split[0];
        Vf(split[1]);
        return true;
    }

    private void Vf(String str) {
        this.odC = false;
        if (!l.isNetOk()) {
            this.ogZ.getContext().showToast(R.string.neterror);
            this.ogZ.getContext().finish();
        } else if (!StringUtils.isNull(str)) {
            this.ogZ.showPostThreadLoadingView(true);
            this.odB.dav().setVcode(str);
            this.odB.dav().setVcodeType("4");
            this.odB.dOV();
        } else {
            this.ogZ.getContext().showToast(R.string.neterror);
            this.ogZ.getContext().finish();
        }
    }
}
