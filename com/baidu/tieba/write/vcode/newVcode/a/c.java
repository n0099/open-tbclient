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
import com.baidu.tbadk.coreExtra.data.v;
import com.baidu.tieba.e;
import com.baidu.tieba.tbadkCore.writeModel.NewWriteModel;
import com.baidu.tieba.tbadkCore.writeModel.PostWriteCallBackData;
import com.baidu.tieba.write.vcode.newVcode.NewVcodeView;
/* loaded from: classes3.dex */
public class c implements b {
    private final NewWriteModel hID;
    private final NewVcodeView hMm;
    private NewWriteModel.d hMn;
    private String jsMethodForChangeVCode;
    private String jsMethodForInit;
    private boolean mNeedShowErrorToastOnStart = false;
    private String mErrorToastOnStart = null;
    private boolean hIE = false;
    private Runnable mShowErrorTaostRunnable = new Runnable() { // from class: com.baidu.tieba.write.vcode.newVcode.a.c.1
        @Override // java.lang.Runnable
        public void run() {
            if (c.this.hMm != null) {
                if (StringUtils.isNull(c.this.mErrorToastOnStart)) {
                    c.this.hMm.showToast(false, c.this.hMm.getContext().getResources().getString(e.j.drag_vcode_error));
                } else {
                    c.this.hMm.showToast(false, c.this.mErrorToastOnStart);
                }
            }
        }
    };
    private final NewWriteModel.d aVS = new NewWriteModel.d() { // from class: com.baidu.tieba.write.vcode.newVcode.a.c.2
        @Override // com.baidu.tieba.tbadkCore.writeModel.NewWriteModel.d
        public void callback(boolean z, PostWriteCallBackData postWriteCallBackData, v vVar, WriteData writeData, AntiData antiData) {
            String str;
            String str2 = null;
            if (c.this.hMm != null) {
                c.this.hMm.showPostThreadLoadingView(false);
                if (z) {
                    c.this.hIE = true;
                    if (writeData != null && writeData.getVideoReviewType() == 1) {
                        c.this.hMm.showToast(true, c.this.hMm.getContext().getResources().getString(e.j.video_send_success_under_review));
                    } else if (writeData != null && writeData.getVideoReviewType() == 2) {
                        c.this.hMm.showToast(true, c.this.hMm.getContext().getResources().getString(e.j.video_send_success));
                    } else if (writeData != null) {
                        String string = c.this.hMm.getContext().getResources().getString(e.j.send_success);
                        if (postWriteCallBackData != null) {
                            str = postWriteCallBackData.getPreMsg();
                            str2 = postWriteCallBackData.getColorMsg();
                            string = postWriteCallBackData.getErrorString();
                        } else {
                            str = null;
                        }
                        if (writeData.getType() != 7) {
                            com.baidu.tieba.tbadkCore.writeModel.c.e(c.this.hMm.getContext().getActivity(), string, str, str2);
                        }
                    }
                    Intent intent = new Intent();
                    Bundle bundle = new Bundle();
                    bundle.putSerializable("post_write_callback_data", postWriteCallBackData);
                    intent.putExtras(bundle);
                    BaseActivity context = c.this.hMm.getContext();
                    c.this.hMm.getContext();
                    context.setResult(-1, intent);
                    c.this.hMm.getContext().finish();
                } else if (postWriteCallBackData != null && postWriteCallBackData.getErrorCode() == 227001) {
                    c.this.hMm.getContext().setVisible(false);
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new AccountAccessActivityConfig(c.this.hMm.getContext().getActivity(), IEventCenterService.EventId.EventMode.SAPIACCOUNT_FACE_REG, writeData, postWriteCallBackData.getAccessState())));
                } else if (postWriteCallBackData != null && postWriteCallBackData.getErrorCode() == 220015 && c.this.hMn != null) {
                    if (c.this.hMn != null) {
                        c.this.hMn.callback(z, postWriteCallBackData, vVar, writeData, antiData);
                    }
                } else if (postWriteCallBackData != null) {
                    if (StringUtils.isNull(postWriteCallBackData.getErrorString())) {
                        c.this.hMm.showToast(false, c.this.hMm.getContext().getResources().getString(e.j.input_vcode_error));
                    } else {
                        c.this.hMm.showToast(false, postWriteCallBackData.getErrorString());
                    }
                    c.this.refreshVCode();
                }
            }
        }
    };

    public c(NewVcodeView newVcodeView, NewWriteModel newWriteModel) {
        this.hMm = newVcodeView;
        this.hID = newWriteModel;
        this.hID.b(this.aVS);
    }

    @Override // com.baidu.tieba.write.vcode.newVcode.a.b
    public boolean onUrlLoad(WebView webView, String str) {
        if (str.contains("objc:jsChangeVcode")) {
            this.jsMethodForInit = com.baidu.tbadk.q.a.ix(str);
            if (this.jsMethodForInit != null && this.hID.getWriteData() != null) {
                this.hMm.runJsMethod(this.jsMethodForInit, "'" + this.hID.getWriteData().getVcodeUrl() + "'");
                return true;
            }
            return false;
        } else if (str.equals("objc:jumpToFeedback()")) {
            WriteActivityConfig writeActivityConfig = new WriteActivityConfig(this.hMm.getContext().getActivity(), 0, TbConfig.getPositionPagerId(), TbConfig.getPositionPagerName(), null, null, 0, null, 13003, true, false, null, false, false, null, null, null, 0);
            writeActivityConfig.setIsVcodeFeedBack();
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, writeActivityConfig));
            return true;
        } else if (str.contains("objc:jsSubmit")) {
            return dealJsSubmit(com.baidu.tbadk.q.a.ix(str));
        } else {
            return false;
        }
    }

    @Override // com.baidu.tieba.write.vcode.newVcode.a.b
    public void onPageFinished(WebView webView, String str) {
        if (this.hMm != null) {
            this.hMm.showWebViewDelay(500);
            if (this.mNeedShowErrorToastOnStart) {
                com.baidu.adp.lib.g.e.jI().postDelayed(this.mShowErrorTaostRunnable, 500L);
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
        this.hMm.setRatio(1.2631578f);
        this.hMm.showWebView(false);
        String str = TbConfig.SERVER_ADDRESS_WEB_VIEW + "mo/q/captcha";
        if (z) {
            str = str + "?feedback=1";
        }
        this.hMm.getWebView().loadUrl(str);
    }

    @Override // com.baidu.tieba.write.vcode.newVcode.a.b
    public void onDestroy() {
        com.baidu.adp.lib.g.e.jI().removeCallbacks(this.mShowErrorTaostRunnable);
    }

    @Override // com.baidu.tieba.write.vcode.newVcode.a.b
    public void d(NewWriteModel.d dVar) {
        this.hMn = dVar;
    }

    @Override // com.baidu.tieba.write.vcode.newVcode.a.b
    public void onPostThreadCancle() {
        this.hMm.showPostThreadLoadingView(false);
        this.hID.cancelLoadData();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void refreshVCode() {
        this.hMm.runJsMethod(this.jsMethodForChangeVCode, "'" + this.hID.getWriteData().getVcodeUrl() + "'");
    }

    private boolean dealJsSubmit(String str) {
        String[] split;
        if (StringUtils.isNull(str) || (split = str.split(",")) == null || split.length != 2) {
            return false;
        }
        this.jsMethodForChangeVCode = split[0];
        wX(split[1]);
        return true;
    }

    private void wX(String str) {
        this.hIE = false;
        if (!l.lo()) {
            this.hMm.getContext().showToast(e.j.neterror);
            this.hMm.getContext().finish();
        } else if (!StringUtils.isNull(str)) {
            this.hMm.showPostThreadLoadingView(true);
            this.hID.getWriteData().setVcode(str);
            this.hID.getWriteData().setVcodeType("4");
            this.hID.startPostWrite();
        } else {
            this.hMm.getContext().showToast(e.j.neterror);
            this.hMm.getContext().finish();
        }
    }
}
