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
/* loaded from: classes7.dex */
public class c implements b {
    private final NewWriteModel ogh;
    private final NewVcodeView ojE;
    private NewWriteModel.d ojF;
    private String ojH;
    private String ojI;
    private boolean ojJ = false;
    private String ojK = null;
    private boolean ogi = false;
    private Runnable ojL = new Runnable() { // from class: com.baidu.tieba.write.vcode.newVcode.a.c.1
        @Override // java.lang.Runnable
        public void run() {
            if (c.this.ojE != null) {
                if (StringUtils.isNull(c.this.ojK)) {
                    c.this.ojE.showToast(false, c.this.ojE.getContext().getResources().getString(R.string.drag_vcode_error));
                } else {
                    c.this.ojE.showToast(false, c.this.ojK);
                }
            }
        }
    };
    private final NewWriteModel.d fFv = new NewWriteModel.d() { // from class: com.baidu.tieba.write.vcode.newVcode.a.c.2
        @Override // com.baidu.tieba.tbadkCore.writeModel.NewWriteModel.d
        public void callback(boolean z, PostWriteCallBackData postWriteCallBackData, ah ahVar, WriteData writeData, AntiData antiData) {
            String str;
            String str2;
            if (c.this.ojE != null) {
                c.this.ojE.showPostThreadLoadingView(false);
                if (z) {
                    c.this.ogi = true;
                    if (writeData != null && writeData.getVideoReviewType() == 1) {
                        c.this.ojE.showToast(true, c.this.ojE.getContext().getResources().getString(R.string.video_send_success_under_review));
                    } else if (writeData != null && writeData.getVideoReviewType() == 2) {
                        c.this.ojE.showToast(true, c.this.ojE.getContext().getResources().getString(R.string.video_send_success));
                    } else if (writeData != null) {
                        String string = c.this.ojE.getContext().getResources().getString(R.string.send_success);
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
                            g.j(c.this.ojE.getContext().getActivity(), string, str2, str);
                        }
                    }
                    Intent intent = new Intent();
                    Bundle bundle = new Bundle();
                    bundle.putSerializable("post_write_callback_data", postWriteCallBackData);
                    intent.putExtras(bundle);
                    BaseActivity context = c.this.ojE.getContext();
                    c.this.ojE.getContext();
                    context.setResult(-1, intent);
                    c.this.ojE.getContext().finish();
                } else if (postWriteCallBackData != null && postWriteCallBackData.getErrorCode() == 227001) {
                    c.this.ojE.getContext().setVisible(false);
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AccountAccessActivityConfig(c.this.ojE.getContext().getActivity(), RequestResponseCode.REQUEST_VCODE, writeData, postWriteCallBackData.getAccessState())));
                } else if (postWriteCallBackData != null && postWriteCallBackData.getErrorCode() == 220015 && c.this.ojF != null) {
                    if (c.this.ojF != null) {
                        c.this.ojF.callback(z, postWriteCallBackData, ahVar, writeData, antiData);
                    }
                } else if (postWriteCallBackData != null) {
                    if (StringUtils.isNull(postWriteCallBackData.getErrorString())) {
                        c.this.ojE.showToast(false, c.this.ojE.getContext().getResources().getString(R.string.input_vcode_error));
                    } else {
                        c.this.ojE.showToast(false, postWriteCallBackData.getErrorString());
                    }
                    c.this.dXK();
                }
            }
        }
    };

    public c(NewVcodeView newVcodeView, NewWriteModel newWriteModel) {
        this.ojE = newVcodeView;
        this.ogh = newWriteModel;
        this.ogh.b(this.fFv);
    }

    @Override // com.baidu.tieba.write.vcode.newVcode.a.b
    public boolean c(WebView webView, String str) {
        if (str.contains("objc:jsChangeVcode")) {
            this.ojH = com.baidu.tbadk.t.a.Ee(str);
            if (this.ojH == null || this.ogh.daL() == null) {
                return false;
            }
            this.ojE.runJsMethod(this.ojH, "'" + this.ogh.daL().getVcodeUrl() + "'");
            return true;
        } else if (str.equals("objc:jumpToFeedback()")) {
            if (WriteActivityConfig.isAsyncWriting()) {
                return false;
            }
            WriteActivityConfig.newInstance(this.ojE.getContext()).setType(0).setForumId(TbConfig.getPositionPagerId()).setForumName(TbConfig.getPositionPagerName()).setIsVcodeFeedBack().send();
            return true;
        } else if (str.contains("objc:jsSubmit")) {
            return Vz(com.baidu.tbadk.t.a.Ee(str));
        } else {
            return false;
        }
    }

    @Override // com.baidu.tieba.write.vcode.newVcode.a.b
    public void onPageFinished(WebView webView, String str) {
        if (this.ojE != null) {
            this.ojE.showWebViewDelay(500);
            if (this.ojJ) {
                e.mA().postDelayed(this.ojL, 500L);
            }
        }
    }

    @Override // com.baidu.tieba.write.vcode.newVcode.a.b
    public void P(boolean z, String str) {
        this.ojJ = z;
        this.ojK = str;
    }

    @Override // com.baidu.tieba.write.vcode.newVcode.a.b
    public void start(boolean z) {
        this.ojE.setRatio(1.2631578f);
        this.ojE.showWebView(false);
        String str = TbConfig.SERVER_ADDRESS_WEB_VIEW + Config.NEW_VCODE_WEBVIEW_ADDRESS;
        if (z) {
            str = str + "?feedback=1";
        }
        this.ojE.getWebView().loadUrl(str);
    }

    @Override // com.baidu.tieba.write.vcode.newVcode.a.b
    public void onDestroy() {
        e.mA().removeCallbacks(this.ojL);
    }

    @Override // com.baidu.tieba.write.vcode.newVcode.a.b
    public void d(NewWriteModel.d dVar) {
        this.ojF = dVar;
    }

    @Override // com.baidu.tieba.write.vcode.newVcode.a.b
    public void dWW() {
        this.ojE.showPostThreadLoadingView(false);
        this.ogh.cancelLoadData();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dXK() {
        this.ojE.runJsMethod(this.ojI, "'" + this.ogh.daL().getVcodeUrl() + "'");
    }

    private boolean Vz(String str) {
        String[] split;
        if (StringUtils.isNull(str) || (split = str.split(",")) == null || split.length != 2) {
            return false;
        }
        this.ojI = split[0];
        Vy(split[1]);
        return true;
    }

    private void Vy(String str) {
        this.ogi = false;
        if (!l.isNetOk()) {
            this.ojE.getContext().showToast(R.string.neterror);
            this.ojE.getContext().finish();
        } else if (!StringUtils.isNull(str)) {
            this.ojE.showPostThreadLoadingView(true);
            this.ogh.daL().setVcode(str);
            this.ogh.daL().setVcodeType("4");
            this.ogh.dPm();
        } else {
            this.ojE.getContext().showToast(R.string.neterror);
            this.ojE.getContext().finish();
        }
    }
}
