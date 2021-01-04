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
    private final NewWriteModel nYa;
    private NewWriteModel.d obA;
    private String obC;
    private String obD;
    private final NewVcodeView obz;
    private boolean obE = false;
    private String obF = null;
    private boolean nYb = false;
    private Runnable obG = new Runnable() { // from class: com.baidu.tieba.write.vcode.newVcode.a.c.1
        @Override // java.lang.Runnable
        public void run() {
            if (c.this.obz != null) {
                if (StringUtils.isNull(c.this.obF)) {
                    c.this.obz.showToast(false, c.this.obz.getContext().getResources().getString(R.string.drag_vcode_error));
                } else {
                    c.this.obz.showToast(false, c.this.obF);
                }
            }
        }
    };
    private final NewWriteModel.d fGo = new NewWriteModel.d() { // from class: com.baidu.tieba.write.vcode.newVcode.a.c.2
        @Override // com.baidu.tieba.tbadkCore.writeModel.NewWriteModel.d
        public void callback(boolean z, PostWriteCallBackData postWriteCallBackData, ah ahVar, WriteData writeData, AntiData antiData) {
            String str;
            String str2;
            if (c.this.obz != null) {
                c.this.obz.showPostThreadLoadingView(false);
                if (z) {
                    c.this.nYb = true;
                    if (writeData != null && writeData.getVideoReviewType() == 1) {
                        c.this.obz.showToast(true, c.this.obz.getContext().getResources().getString(R.string.video_send_success_under_review));
                    } else if (writeData != null && writeData.getVideoReviewType() == 2) {
                        c.this.obz.showToast(true, c.this.obz.getContext().getResources().getString(R.string.video_send_success));
                    } else if (writeData != null) {
                        String string = c.this.obz.getContext().getResources().getString(R.string.send_success);
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
                            g.i(c.this.obz.getContext().getActivity(), string, str2, str);
                        }
                    }
                    Intent intent = new Intent();
                    Bundle bundle = new Bundle();
                    bundle.putSerializable("post_write_callback_data", postWriteCallBackData);
                    intent.putExtras(bundle);
                    BaseActivity context = c.this.obz.getContext();
                    c.this.obz.getContext();
                    context.setResult(-1, intent);
                    c.this.obz.getContext().finish();
                } else if (postWriteCallBackData != null && postWriteCallBackData.getErrorCode() == 227001) {
                    c.this.obz.getContext().setVisible(false);
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AccountAccessActivityConfig(c.this.obz.getContext().getActivity(), RequestResponseCode.REQUEST_VCODE, writeData, postWriteCallBackData.getAccessState())));
                } else if (postWriteCallBackData != null && postWriteCallBackData.getErrorCode() == 220015 && c.this.obA != null) {
                    if (c.this.obA != null) {
                        c.this.obA.callback(z, postWriteCallBackData, ahVar, writeData, antiData);
                    }
                } else if (postWriteCallBackData != null) {
                    if (StringUtils.isNull(postWriteCallBackData.getErrorString())) {
                        c.this.obz.showToast(false, c.this.obz.getContext().getResources().getString(R.string.input_vcode_error));
                    } else {
                        c.this.obz.showToast(false, postWriteCallBackData.getErrorString());
                    }
                    c.this.dYX();
                }
            }
        }
    };

    public c(NewVcodeView newVcodeView, NewWriteModel newWriteModel) {
        this.obz = newVcodeView;
        this.nYa = newWriteModel;
        this.nYa.b(this.fGo);
    }

    @Override // com.baidu.tieba.write.vcode.newVcode.a.b
    public boolean c(WebView webView, String str) {
        if (str.contains("objc:jsChangeVcode")) {
            this.obC = com.baidu.tbadk.t.a.EP(str);
            if (this.obC == null || this.nYa.dco() == null) {
                return false;
            }
            this.obz.runJsMethod(this.obC, "'" + this.nYa.dco().getVcodeUrl() + "'");
            return true;
        } else if (str.equals("objc:jumpToFeedback()")) {
            if (WriteActivityConfig.isAsyncWriting()) {
                return false;
            }
            WriteActivityConfig.newInstance(this.obz.getContext()).setType(0).setForumId(TbConfig.getPositionPagerId()).setForumName(TbConfig.getPositionPagerName()).setIsVcodeFeedBack().send();
            return true;
        } else if (str.contains("objc:jsSubmit")) {
            return Vq(com.baidu.tbadk.t.a.EP(str));
        } else {
            return false;
        }
    }

    @Override // com.baidu.tieba.write.vcode.newVcode.a.b
    public void onPageFinished(WebView webView, String str) {
        if (this.obz != null) {
            this.obz.showWebViewDelay(500);
            if (this.obE) {
                e.mB().postDelayed(this.obG, 500L);
            }
        }
    }

    @Override // com.baidu.tieba.write.vcode.newVcode.a.b
    public void H(boolean z, String str) {
        this.obE = z;
        this.obF = str;
    }

    @Override // com.baidu.tieba.write.vcode.newVcode.a.b
    public void start(boolean z) {
        this.obz.setRatio(1.2631578f);
        this.obz.showWebView(false);
        String str = TbConfig.SERVER_ADDRESS_WEB_VIEW + Config.NEW_VCODE_WEBVIEW_ADDRESS;
        if (z) {
            str = str + "?feedback=1";
        }
        this.obz.getWebView().loadUrl(str);
    }

    @Override // com.baidu.tieba.write.vcode.newVcode.a.b
    public void onDestroy() {
        e.mB().removeCallbacks(this.obG);
    }

    @Override // com.baidu.tieba.write.vcode.newVcode.a.b
    public void d(NewWriteModel.d dVar) {
        this.obA = dVar;
    }

    @Override // com.baidu.tieba.write.vcode.newVcode.a.b
    public void dYj() {
        this.obz.showPostThreadLoadingView(false);
        this.nYa.cancelLoadData();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dYX() {
        this.obz.runJsMethod(this.obD, "'" + this.nYa.dco().getVcodeUrl() + "'");
    }

    private boolean Vq(String str) {
        String[] split;
        if (StringUtils.isNull(str) || (split = str.split(",")) == null || split.length != 2) {
            return false;
        }
        this.obD = split[0];
        Vp(split[1]);
        return true;
    }

    private void Vp(String str) {
        this.nYb = false;
        if (!l.isNetOk()) {
            this.obz.getContext().showToast(R.string.neterror);
            this.obz.getContext().finish();
        } else if (!StringUtils.isNull(str)) {
            this.obz.showPostThreadLoadingView(true);
            this.nYa.dco().setVcode(str);
            this.nYa.dco().setVcodeType("4");
            this.nYa.dQB();
        } else {
            this.obz.getContext().showToast(R.string.neterror);
            this.obz.getContext().finish();
        }
    }
}
