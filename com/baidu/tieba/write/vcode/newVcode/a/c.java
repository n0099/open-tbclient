package com.baidu.tieba.write.vcode.newVcode.a;

import android.content.Intent;
import android.os.Bundle;
import android.webkit.WebView;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.lib.g.e;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.lib.util.l;
import com.baidu.sapi2.passhost.pluginsdk.service.IEventCenterService;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.atomData.AccountAccessActivityConfig;
import com.baidu.tbadk.core.atomData.WriteActivityConfig;
import com.baidu.tbadk.core.data.AntiData;
import com.baidu.tbadk.coreExtra.data.WriteData;
import com.baidu.tbadk.coreExtra.data.t;
import com.baidu.tieba.d;
import com.baidu.tieba.tbadkCore.writeModel.NewWriteModel;
import com.baidu.tieba.tbadkCore.writeModel.PostWriteCallBackData;
import com.baidu.tieba.write.vcode.newVcode.NewVcodeView;
/* loaded from: classes3.dex */
public class c implements b {
    private final NewWriteModel hod;
    private final NewVcodeView hrm;
    private NewWriteModel.d hrn;
    private String jsMethodForChangeVCode;
    private String jsMethodForInit;
    private boolean mNeedShowErrorToastOnStart = false;
    private String mErrorToastOnStart = null;
    private boolean hoe = false;
    private Runnable mShowErrorTaostRunnable = new Runnable() { // from class: com.baidu.tieba.write.vcode.newVcode.a.c.1
        @Override // java.lang.Runnable
        public void run() {
            if (c.this.hrm != null) {
                if (StringUtils.isNull(c.this.mErrorToastOnStart)) {
                    c.this.hrm.showToast(false, c.this.hrm.getContext().getResources().getString(d.k.drag_vcode_error));
                } else {
                    c.this.hrm.showToast(false, c.this.mErrorToastOnStart);
                }
            }
        }
    };
    private final NewWriteModel.d aNh = new NewWriteModel.d() { // from class: com.baidu.tieba.write.vcode.newVcode.a.c.2
        @Override // com.baidu.tieba.tbadkCore.writeModel.NewWriteModel.d
        public void callback(boolean z, PostWriteCallBackData postWriteCallBackData, t tVar, WriteData writeData, AntiData antiData) {
            String str;
            String str2 = null;
            if (c.this.hrm != null) {
                c.this.hrm.showPostThreadLoadingView(false);
                if (z) {
                    c.this.hoe = true;
                    if (writeData != null && writeData.getVideoReviewType() == 1) {
                        c.this.hrm.showToast(true, c.this.hrm.getContext().getResources().getString(d.k.video_send_success_under_review));
                    } else if (writeData != null && writeData.getVideoReviewType() == 2) {
                        c.this.hrm.showToast(true, c.this.hrm.getContext().getResources().getString(d.k.video_send_success));
                    } else if (writeData != null) {
                        String string = c.this.hrm.getContext().getResources().getString(d.k.send_success);
                        if (postWriteCallBackData != null) {
                            str = postWriteCallBackData.getPreMsg();
                            str2 = postWriteCallBackData.getColorMsg();
                            string = postWriteCallBackData.getErrorString();
                        } else {
                            str = null;
                        }
                        if (writeData.getType() != 7) {
                            com.baidu.tieba.tbadkCore.writeModel.c.e(c.this.hrm.getContext().getActivity(), string, str, str2);
                        }
                    }
                    Intent intent = new Intent();
                    Bundle bundle = new Bundle();
                    bundle.putSerializable("post_write_callback_data", postWriteCallBackData);
                    intent.putExtras(bundle);
                    BaseActivity context = c.this.hrm.getContext();
                    c.this.hrm.getContext();
                    context.setResult(-1, intent);
                    c.this.hrm.getContext().finish();
                } else if (postWriteCallBackData != null && postWriteCallBackData.getErrorCode() == 227001) {
                    c.this.hrm.getContext().setVisible(false);
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new AccountAccessActivityConfig(c.this.hrm.getContext().getActivity(), IEventCenterService.EventId.EventMode.SAPIACCOUNT_FACE_REG, writeData, postWriteCallBackData.getAccessState())));
                } else if (postWriteCallBackData != null && postWriteCallBackData.getErrorCode() == 220015 && c.this.hrn != null) {
                    if (c.this.hrn != null) {
                        c.this.hrn.callback(z, postWriteCallBackData, tVar, writeData, antiData);
                    }
                } else if (postWriteCallBackData != null) {
                    if (StringUtils.isNull(postWriteCallBackData.getErrorString())) {
                        c.this.hrm.showToast(false, c.this.hrm.getContext().getResources().getString(d.k.input_vcode_error));
                    } else {
                        c.this.hrm.showToast(false, postWriteCallBackData.getErrorString());
                    }
                    c.this.refreshVCode();
                }
            }
        }
    };

    public c(NewVcodeView newVcodeView, NewWriteModel newWriteModel) {
        this.hrm = newVcodeView;
        this.hod = newWriteModel;
        this.hod.b(this.aNh);
    }

    @Override // com.baidu.tieba.write.vcode.newVcode.a.b
    public boolean onUrlLoad(WebView webView, String str) {
        if (str.contains("objc:jsChangeVcode")) {
            this.jsMethodForInit = com.baidu.tbadk.p.a.hL(str);
            if (this.jsMethodForInit != null && this.hod.getWriteData() != null) {
                this.hrm.runJsMethod(this.jsMethodForInit, "'" + this.hod.getWriteData().getVcodeUrl() + "'");
                return true;
            }
            return false;
        } else if (str.equals("objc:jumpToFeedback()")) {
            WriteActivityConfig writeActivityConfig = new WriteActivityConfig(this.hrm.getContext().getActivity(), 0, TbConfig.getPositionPagerId(), TbConfig.getPositionPagerName(), null, null, 0, null, 13003, true, false, null, false, false, null, null, null, 0);
            writeActivityConfig.setIsVcodeFeedBack();
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, writeActivityConfig));
            return true;
        } else if (str.contains("objc:jsSubmit")) {
            return dealJsSubmit(com.baidu.tbadk.p.a.hL(str));
        } else {
            return false;
        }
    }

    @Override // com.baidu.tieba.write.vcode.newVcode.a.b
    public void onPageFinished(WebView webView, String str) {
        if (this.hrm != null) {
            this.hrm.showWebViewDelay(500);
            if (this.mNeedShowErrorToastOnStart) {
                e.im().postDelayed(this.mShowErrorTaostRunnable, 500L);
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
        this.hrm.setRatio(1.2631578f);
        this.hrm.showWebView(false);
        String str = TbConfig.SERVER_ADDRESS_WEB_VIEW + "mo/q/captcha";
        if (z) {
            str = str + "?feedback=1";
        }
        this.hrm.getWebView().loadUrl(str);
    }

    @Override // com.baidu.tieba.write.vcode.newVcode.a.b
    public void onDestroy() {
        e.im().removeCallbacks(this.mShowErrorTaostRunnable);
    }

    @Override // com.baidu.tieba.write.vcode.newVcode.a.b
    public void d(NewWriteModel.d dVar) {
        this.hrn = dVar;
    }

    @Override // com.baidu.tieba.write.vcode.newVcode.a.b
    public void onPostThreadCancle() {
        this.hrm.showPostThreadLoadingView(false);
        this.hod.cancelLoadData();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void refreshVCode() {
        this.hrm.runJsMethod(this.jsMethodForChangeVCode, "'" + this.hod.getWriteData().getVcodeUrl() + "'");
    }

    private boolean dealJsSubmit(String str) {
        String[] split;
        if (StringUtils.isNull(str) || (split = str.split(",")) == null || split.length != 2) {
            return false;
        }
        this.jsMethodForChangeVCode = split[0];
        vK(split[1]);
        return true;
    }

    private void vK(String str) {
        this.hoe = false;
        if (!l.jU()) {
            this.hrm.getContext().showToast(d.k.neterror);
            this.hrm.getContext().finish();
        } else if (!StringUtils.isNull(str)) {
            this.hrm.showPostThreadLoadingView(true);
            this.hod.getWriteData().setVcode(str);
            this.hod.getWriteData().setVcodeType("4");
            this.hod.startPostWrite();
        } else {
            this.hrm.getContext().showToast(d.k.neterror);
            this.hrm.getContext().finish();
        }
    }
}
