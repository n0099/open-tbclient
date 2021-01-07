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
    private final NewWriteModel nXZ;
    private String obB;
    private String obC;
    private final NewVcodeView oby;
    private NewWriteModel.d obz;
    private boolean obD = false;
    private String obE = null;
    private boolean nYa = false;
    private Runnable obF = new Runnable() { // from class: com.baidu.tieba.write.vcode.newVcode.a.c.1
        @Override // java.lang.Runnable
        public void run() {
            if (c.this.oby != null) {
                if (StringUtils.isNull(c.this.obE)) {
                    c.this.oby.showToast(false, c.this.oby.getContext().getResources().getString(R.string.drag_vcode_error));
                } else {
                    c.this.oby.showToast(false, c.this.obE);
                }
            }
        }
    };
    private final NewWriteModel.d fGo = new NewWriteModel.d() { // from class: com.baidu.tieba.write.vcode.newVcode.a.c.2
        @Override // com.baidu.tieba.tbadkCore.writeModel.NewWriteModel.d
        public void callback(boolean z, PostWriteCallBackData postWriteCallBackData, ah ahVar, WriteData writeData, AntiData antiData) {
            String str;
            String str2;
            if (c.this.oby != null) {
                c.this.oby.showPostThreadLoadingView(false);
                if (z) {
                    c.this.nYa = true;
                    if (writeData != null && writeData.getVideoReviewType() == 1) {
                        c.this.oby.showToast(true, c.this.oby.getContext().getResources().getString(R.string.video_send_success_under_review));
                    } else if (writeData != null && writeData.getVideoReviewType() == 2) {
                        c.this.oby.showToast(true, c.this.oby.getContext().getResources().getString(R.string.video_send_success));
                    } else if (writeData != null) {
                        String string = c.this.oby.getContext().getResources().getString(R.string.send_success);
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
                            g.i(c.this.oby.getContext().getActivity(), string, str2, str);
                        }
                    }
                    Intent intent = new Intent();
                    Bundle bundle = new Bundle();
                    bundle.putSerializable("post_write_callback_data", postWriteCallBackData);
                    intent.putExtras(bundle);
                    BaseActivity context = c.this.oby.getContext();
                    c.this.oby.getContext();
                    context.setResult(-1, intent);
                    c.this.oby.getContext().finish();
                } else if (postWriteCallBackData != null && postWriteCallBackData.getErrorCode() == 227001) {
                    c.this.oby.getContext().setVisible(false);
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AccountAccessActivityConfig(c.this.oby.getContext().getActivity(), RequestResponseCode.REQUEST_VCODE, writeData, postWriteCallBackData.getAccessState())));
                } else if (postWriteCallBackData != null && postWriteCallBackData.getErrorCode() == 220015 && c.this.obz != null) {
                    if (c.this.obz != null) {
                        c.this.obz.callback(z, postWriteCallBackData, ahVar, writeData, antiData);
                    }
                } else if (postWriteCallBackData != null) {
                    if (StringUtils.isNull(postWriteCallBackData.getErrorString())) {
                        c.this.oby.showToast(false, c.this.oby.getContext().getResources().getString(R.string.input_vcode_error));
                    } else {
                        c.this.oby.showToast(false, postWriteCallBackData.getErrorString());
                    }
                    c.this.dYY();
                }
            }
        }
    };

    public c(NewVcodeView newVcodeView, NewWriteModel newWriteModel) {
        this.oby = newVcodeView;
        this.nXZ = newWriteModel;
        this.nXZ.b(this.fGo);
    }

    @Override // com.baidu.tieba.write.vcode.newVcode.a.b
    public boolean c(WebView webView, String str) {
        if (str.contains("objc:jsChangeVcode")) {
            this.obB = com.baidu.tbadk.t.a.EO(str);
            if (this.obB == null || this.nXZ.dcp() == null) {
                return false;
            }
            this.oby.runJsMethod(this.obB, "'" + this.nXZ.dcp().getVcodeUrl() + "'");
            return true;
        } else if (str.equals("objc:jumpToFeedback()")) {
            if (WriteActivityConfig.isAsyncWriting()) {
                return false;
            }
            WriteActivityConfig.newInstance(this.oby.getContext()).setType(0).setForumId(TbConfig.getPositionPagerId()).setForumName(TbConfig.getPositionPagerName()).setIsVcodeFeedBack().send();
            return true;
        } else if (str.contains("objc:jsSubmit")) {
            return Vp(com.baidu.tbadk.t.a.EO(str));
        } else {
            return false;
        }
    }

    @Override // com.baidu.tieba.write.vcode.newVcode.a.b
    public void onPageFinished(WebView webView, String str) {
        if (this.oby != null) {
            this.oby.showWebViewDelay(500);
            if (this.obD) {
                e.mB().postDelayed(this.obF, 500L);
            }
        }
    }

    @Override // com.baidu.tieba.write.vcode.newVcode.a.b
    public void H(boolean z, String str) {
        this.obD = z;
        this.obE = str;
    }

    @Override // com.baidu.tieba.write.vcode.newVcode.a.b
    public void start(boolean z) {
        this.oby.setRatio(1.2631578f);
        this.oby.showWebView(false);
        String str = TbConfig.SERVER_ADDRESS_WEB_VIEW + Config.NEW_VCODE_WEBVIEW_ADDRESS;
        if (z) {
            str = str + "?feedback=1";
        }
        this.oby.getWebView().loadUrl(str);
    }

    @Override // com.baidu.tieba.write.vcode.newVcode.a.b
    public void onDestroy() {
        e.mB().removeCallbacks(this.obF);
    }

    @Override // com.baidu.tieba.write.vcode.newVcode.a.b
    public void d(NewWriteModel.d dVar) {
        this.obz = dVar;
    }

    @Override // com.baidu.tieba.write.vcode.newVcode.a.b
    public void dYk() {
        this.oby.showPostThreadLoadingView(false);
        this.nXZ.cancelLoadData();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dYY() {
        this.oby.runJsMethod(this.obC, "'" + this.nXZ.dcp().getVcodeUrl() + "'");
    }

    private boolean Vp(String str) {
        String[] split;
        if (StringUtils.isNull(str) || (split = str.split(",")) == null || split.length != 2) {
            return false;
        }
        this.obC = split[0];
        Vo(split[1]);
        return true;
    }

    private void Vo(String str) {
        this.nYa = false;
        if (!l.isNetOk()) {
            this.oby.getContext().showToast(R.string.neterror);
            this.oby.getContext().finish();
        } else if (!StringUtils.isNull(str)) {
            this.oby.showPostThreadLoadingView(true);
            this.nXZ.dcp().setVcode(str);
            this.nXZ.dcp().setVcodeType("4");
            this.nXZ.dQC();
        } else {
            this.oby.getContext().showToast(R.string.neterror);
            this.oby.getContext().finish();
        }
    }
}
