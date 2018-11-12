package com.baidu.tieba.write.vcode.newVcode.a;

import android.content.Intent;
import android.os.Bundle;
import android.webkit.WebView;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.lib.util.l;
import com.baidu.sapi2.passhost.pluginsdk.service.IEventCenterService;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.atomData.AccountAccessActivityConfig;
import com.baidu.tbadk.core.atomData.WriteActivityConfig;
import com.baidu.tbadk.core.data.AntiData;
import com.baidu.tbadk.coreExtra.data.WriteData;
import com.baidu.tbadk.coreExtra.data.w;
import com.baidu.tieba.e;
import com.baidu.tieba.tbadkCore.writeModel.NewWriteModel;
import com.baidu.tieba.tbadkCore.writeModel.PostWriteCallBackData;
import com.baidu.tieba.write.vcode.newVcode.NewVcodeView;
/* loaded from: classes3.dex */
public class c implements b {
    private final NewWriteModel hKo;
    private final NewVcodeView hNX;
    private NewWriteModel.d hNY;
    private String jsMethodForChangeVCode;
    private String jsMethodForInit;
    private boolean mNeedShowErrorToastOnStart = false;
    private String mErrorToastOnStart = null;
    private boolean hKp = false;
    private Runnable mShowErrorTaostRunnable = new Runnable() { // from class: com.baidu.tieba.write.vcode.newVcode.a.c.1
        @Override // java.lang.Runnable
        public void run() {
            if (c.this.hNX != null) {
                if (StringUtils.isNull(c.this.mErrorToastOnStart)) {
                    c.this.hNX.showToast(false, c.this.hNX.getContext().getResources().getString(e.j.drag_vcode_error));
                } else {
                    c.this.hNX.showToast(false, c.this.mErrorToastOnStart);
                }
            }
        }
    };
    private final NewWriteModel.d aWI = new NewWriteModel.d() { // from class: com.baidu.tieba.write.vcode.newVcode.a.c.2
        @Override // com.baidu.tieba.tbadkCore.writeModel.NewWriteModel.d
        public void callback(boolean z, PostWriteCallBackData postWriteCallBackData, w wVar, WriteData writeData, AntiData antiData) {
            String str;
            String str2 = null;
            if (c.this.hNX != null) {
                c.this.hNX.showPostThreadLoadingView(false);
                if (z) {
                    c.this.hKp = true;
                    if (writeData != null && writeData.getVideoReviewType() == 1) {
                        c.this.hNX.showToast(true, c.this.hNX.getContext().getResources().getString(e.j.video_send_success_under_review));
                    } else if (writeData != null && writeData.getVideoReviewType() == 2) {
                        c.this.hNX.showToast(true, c.this.hNX.getContext().getResources().getString(e.j.video_send_success));
                    } else if (writeData != null) {
                        String string = c.this.hNX.getContext().getResources().getString(e.j.send_success);
                        if (postWriteCallBackData != null) {
                            str = postWriteCallBackData.getPreMsg();
                            str2 = postWriteCallBackData.getColorMsg();
                            string = postWriteCallBackData.getErrorString();
                        } else {
                            str = null;
                        }
                        if (writeData.getType() != 7) {
                            com.baidu.tieba.tbadkCore.writeModel.c.e(c.this.hNX.getContext().getActivity(), string, str, str2);
                        }
                    }
                    Intent intent = new Intent();
                    Bundle bundle = new Bundle();
                    bundle.putSerializable("post_write_callback_data", postWriteCallBackData);
                    intent.putExtras(bundle);
                    BaseActivity context = c.this.hNX.getContext();
                    c.this.hNX.getContext();
                    context.setResult(-1, intent);
                    c.this.hNX.getContext().finish();
                } else if (postWriteCallBackData != null && postWriteCallBackData.getErrorCode() == 227001) {
                    c.this.hNX.getContext().setVisible(false);
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new AccountAccessActivityConfig(c.this.hNX.getContext().getActivity(), IEventCenterService.EventId.EventMode.SAPIACCOUNT_FACE_REG, writeData, postWriteCallBackData.getAccessState())));
                } else if (postWriteCallBackData != null && postWriteCallBackData.getErrorCode() == 220015 && c.this.hNY != null) {
                    if (c.this.hNY != null) {
                        c.this.hNY.callback(z, postWriteCallBackData, wVar, writeData, antiData);
                    }
                } else if (postWriteCallBackData != null) {
                    if (StringUtils.isNull(postWriteCallBackData.getErrorString())) {
                        c.this.hNX.showToast(false, c.this.hNX.getContext().getResources().getString(e.j.input_vcode_error));
                    } else {
                        c.this.hNX.showToast(false, postWriteCallBackData.getErrorString());
                    }
                    c.this.refreshVCode();
                }
            }
        }
    };

    public c(NewVcodeView newVcodeView, NewWriteModel newWriteModel) {
        this.hNX = newVcodeView;
        this.hKo = newWriteModel;
        this.hKo.b(this.aWI);
    }

    @Override // com.baidu.tieba.write.vcode.newVcode.a.b
    public boolean onUrlLoad(WebView webView, String str) {
        if (str.contains("objc:jsChangeVcode")) {
            this.jsMethodForInit = com.baidu.tbadk.q.a.iz(str);
            if (this.jsMethodForInit != null && this.hKo.getWriteData() != null) {
                this.hNX.runJsMethod(this.jsMethodForInit, "'" + this.hKo.getWriteData().getVcodeUrl() + "'");
                return true;
            }
            return false;
        } else if (str.equals("objc:jumpToFeedback()")) {
            WriteActivityConfig writeActivityConfig = new WriteActivityConfig(this.hNX.getContext().getActivity(), 0, TbConfig.getPositionPagerId(), TbConfig.getPositionPagerName(), null, null, 0, null, 13003, true, false, null, false, false, null, null, null, 0);
            writeActivityConfig.setIsVcodeFeedBack();
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, writeActivityConfig));
            return true;
        } else if (str.contains("objc:jsSubmit")) {
            return dealJsSubmit(com.baidu.tbadk.q.a.iz(str));
        } else {
            return false;
        }
    }

    @Override // com.baidu.tieba.write.vcode.newVcode.a.b
    public void onPageFinished(WebView webView, String str) {
        if (this.hNX != null) {
            this.hNX.showWebViewDelay(500);
            if (this.mNeedShowErrorToastOnStart) {
                com.baidu.adp.lib.g.e.jG().postDelayed(this.mShowErrorTaostRunnable, 500L);
            }
        }
    }

    @Override // com.baidu.tieba.write.vcode.newVcode.a.b
    public void showErrorOnStart(boolean z, String str) {
        this.mNeedShowErrorToastOnStart = z;
        this.mErrorToastOnStart = str;
    }

    @Override // com.baidu.tieba.write.vcode.newVcode.a.b
    public void start(boolean z) {
        this.hNX.setRatio(1.2631578f);
        this.hNX.showWebView(false);
        String str = TbConfig.SERVER_ADDRESS_WEB_VIEW + "mo/q/captcha";
        if (z) {
            str = str + "?feedback=1";
        }
        this.hNX.getWebView().loadUrl(str);
    }

    @Override // com.baidu.tieba.write.vcode.newVcode.a.b
    public void onDestroy() {
        com.baidu.adp.lib.g.e.jG().removeCallbacks(this.mShowErrorTaostRunnable);
    }

    @Override // com.baidu.tieba.write.vcode.newVcode.a.b
    public void d(NewWriteModel.d dVar) {
        this.hNY = dVar;
    }

    @Override // com.baidu.tieba.write.vcode.newVcode.a.b
    public void onPostThreadCancle() {
        this.hNX.showPostThreadLoadingView(false);
        this.hKo.cancelLoadData();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void refreshVCode() {
        this.hNX.runJsMethod(this.jsMethodForChangeVCode, "'" + this.hKo.getWriteData().getVcodeUrl() + "'");
    }

    private boolean dealJsSubmit(String str) {
        String[] split;
        if (StringUtils.isNull(str) || (split = str.split(",")) == null || split.length != 2) {
            return false;
        }
        this.jsMethodForChangeVCode = split[0];
        xc(split[1]);
        return true;
    }

    private void xc(String str) {
        this.hKp = false;
        if (!l.lm()) {
            this.hNX.getContext().showToast(e.j.neterror);
            this.hNX.getContext().finish();
        } else if (!StringUtils.isNull(str)) {
            this.hNX.showPostThreadLoadingView(true);
            this.hKo.getWriteData().setVcode(str);
            this.hKo.getWriteData().setVcodeType("4");
            this.hKo.startPostWrite();
        } else {
            this.hNX.getContext().showToast(e.j.neterror);
            this.hNX.getContext().finish();
        }
    }
}
