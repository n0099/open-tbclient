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
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.coreExtra.data.WriteData;
import com.baidu.tbadk.coreExtra.data.s;
import com.baidu.tieba.d;
import com.baidu.tieba.tbadkCore.writeModel.NewWriteModel;
import com.baidu.tieba.tbadkCore.writeModel.PostWriteCallBackData;
import com.baidu.tieba.write.vcode.newVcode.NewVcodeView;
import com.xiaomi.mipush.sdk.Constants;
/* loaded from: classes2.dex */
public class c implements b {
    private final NewWriteModel heS;
    private final NewVcodeView hhV;
    private NewWriteModel.d hhW;
    private String jsMethodForChangeVCode;
    private String jsMethodForInit;
    private boolean mNeedShowErrorToastOnStart = false;
    private String mErrorToastOnStart = null;
    private boolean heT = false;
    private Runnable mShowErrorTaostRunnable = new Runnable() { // from class: com.baidu.tieba.write.vcode.newVcode.a.c.1
        @Override // java.lang.Runnable
        public void run() {
            if (c.this.hhV != null) {
                if (StringUtils.isNull(c.this.mErrorToastOnStart)) {
                    c.this.hhV.showToast(false, c.this.hhV.getContext().getResources().getString(d.j.drag_vcode_error));
                } else {
                    c.this.hhV.showToast(false, c.this.mErrorToastOnStart);
                }
            }
        }
    };
    private final NewWriteModel.d aDS = new NewWriteModel.d() { // from class: com.baidu.tieba.write.vcode.newVcode.a.c.2
        @Override // com.baidu.tieba.tbadkCore.writeModel.NewWriteModel.d
        public void callback(boolean z, PostWriteCallBackData postWriteCallBackData, s sVar, WriteData writeData, AntiData antiData) {
            String str;
            String str2 = null;
            if (c.this.hhV != null) {
                c.this.hhV.showPostThreadLoadingView(false);
                if (z) {
                    c.this.heT = true;
                    if (writeData != null && writeData.getVideoReviewType() == 1) {
                        if (writeData.getIsStory() != 1) {
                            c.this.hhV.showToast(true, c.this.hhV.getContext().getResources().getString(d.j.video_send_success_under_review));
                        }
                    } else if (writeData != null && writeData.getVideoReviewType() == 2) {
                        if (writeData.getIsStory() != 1) {
                            c.this.hhV.showToast(true, c.this.hhV.getContext().getResources().getString(d.j.video_send_success));
                        }
                    } else if (writeData != null && writeData.getIsStory() != 1) {
                        String string = c.this.hhV.getContext().getResources().getString(d.j.send_success);
                        if (postWriteCallBackData != null) {
                            str = postWriteCallBackData.getPreMsg();
                            str2 = postWriteCallBackData.getColorMsg();
                            string = postWriteCallBackData.getErrorString();
                        } else {
                            str = null;
                        }
                        if (writeData.getType() != 7) {
                            com.baidu.tieba.tbadkCore.writeModel.c.d(c.this.hhV.getContext().getActivity(), string, str, str2);
                        }
                    }
                    Intent intent = new Intent();
                    Bundle bundle = new Bundle();
                    bundle.putSerializable("post_write_callback_data", postWriteCallBackData);
                    intent.putExtras(bundle);
                    BaseActivity context = c.this.hhV.getContext();
                    c.this.hhV.getContext();
                    context.setResult(-1, intent);
                    c.this.hhV.getContext().finish();
                } else if (postWriteCallBackData != null && postWriteCallBackData.getErrorCode() == 227001) {
                    c.this.hhV.getContext().setVisible(false);
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AccountAccessActivityConfig(c.this.hhV.getContext().getActivity(), IEventCenterService.EventId.EventMode.SAPIACCOUNT_FACE_REG, writeData, postWriteCallBackData.getAccessState())));
                } else if (postWriteCallBackData != null && postWriteCallBackData.getErrorCode() == 220015 && c.this.hhW != null) {
                    if (c.this.hhW != null) {
                        c.this.hhW.callback(z, postWriteCallBackData, sVar, writeData, antiData);
                    }
                } else if (postWriteCallBackData != null) {
                    if (writeData != null && writeData.getIsStory() != 1) {
                        if (StringUtils.isNull(postWriteCallBackData.getErrorString())) {
                            c.this.hhV.showToast(false, c.this.hhV.getContext().getResources().getString(d.j.input_vcode_error));
                        } else {
                            c.this.hhV.showToast(false, postWriteCallBackData.getErrorString());
                        }
                    }
                    c.this.refreshVCode();
                }
            }
        }
    };

    public c(NewVcodeView newVcodeView, NewWriteModel newWriteModel) {
        this.hhV = newVcodeView;
        this.heS = newWriteModel;
        this.heS.b(this.aDS);
    }

    @Override // com.baidu.tieba.write.vcode.newVcode.a.b
    public boolean onUrlLoad(WebView webView, String str) {
        if (str.contains("objc:jsChangeVcode")) {
            this.jsMethodForInit = com.baidu.tbadk.p.a.hb(str);
            if (this.jsMethodForInit != null && this.heS.getWriteData() != null) {
                this.hhV.runJsMethod(this.jsMethodForInit, "'" + this.heS.getWriteData().getVcodeUrl() + "'");
                return true;
            }
            return false;
        } else if (str.equals("objc:jumpToFeedback()")) {
            WriteActivityConfig writeActivityConfig = new WriteActivityConfig(this.hhV.getContext().getActivity(), 0, TbConfig.getPositionPagerId(), TbConfig.getPositionPagerName(), null, null, 0, null, 13003, true, false, null, false, false, null, null, null, 0);
            writeActivityConfig.setIsVcodeFeedBack();
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, writeActivityConfig));
            return true;
        } else if (str.contains("objc:jsSubmit")) {
            return dealJsSubmit(com.baidu.tbadk.p.a.hb(str));
        } else {
            return false;
        }
    }

    @Override // com.baidu.tieba.write.vcode.newVcode.a.b
    public void onPageFinished(WebView webView, String str) {
        if (this.hhV != null) {
            this.hhV.showWebViewDelay(500);
            if (this.mNeedShowErrorToastOnStart) {
                e.fP().postDelayed(this.mShowErrorTaostRunnable, 500L);
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
        this.hhV.setRatio(1.2631578f);
        this.hhV.showWebView(false);
        String str = TbConfig.SERVER_ADDRESS_WEB_VIEW + "mo/q/captcha";
        if (z) {
            str = str + "?feedback=1";
        }
        this.hhV.getWebView().loadUrl(str);
    }

    @Override // com.baidu.tieba.write.vcode.newVcode.a.b
    public void onDestroy() {
        e.fP().removeCallbacks(this.mShowErrorTaostRunnable);
    }

    @Override // com.baidu.tieba.write.vcode.newVcode.a.b
    public void d(NewWriteModel.d dVar) {
        this.hhW = dVar;
    }

    @Override // com.baidu.tieba.write.vcode.newVcode.a.b
    public void onPostThreadCancle() {
        this.hhV.showPostThreadLoadingView(false);
        this.heS.cancelLoadData();
    }

    @Override // com.baidu.tieba.write.vcode.newVcode.a.b
    public boolean bFS() {
        return this.heT;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void refreshVCode() {
        this.hhV.runJsMethod(this.jsMethodForChangeVCode, "'" + this.heS.getWriteData().getVcodeUrl() + "'");
    }

    private boolean dealJsSubmit(String str) {
        String[] split;
        if (StringUtils.isNull(str) || (split = str.split(Constants.ACCEPT_TIME_SEPARATOR_SP)) == null || split.length != 2) {
            return false;
        }
        this.jsMethodForChangeVCode = split[0];
        sF(split[1]);
        return true;
    }

    private void sF(String str) {
        this.heT = false;
        if (!l.hy()) {
            this.hhV.getContext().showToast(d.j.neterror);
            this.hhV.getContext().finish();
        } else if (!StringUtils.isNull(str)) {
            this.hhV.showPostThreadLoadingView(true);
            this.heS.getWriteData().setVcode(str);
            this.heS.getWriteData().setVcodeType("4");
            this.heS.startPostWrite();
        } else {
            this.hhV.getContext().showToast(d.j.neterror);
            this.hhV.getContext().finish();
        }
    }
}
