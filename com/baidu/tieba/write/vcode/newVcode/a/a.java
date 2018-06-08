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
import com.baidu.tbadk.core.diskCache.ImagesInvalidReceiver;
import com.baidu.tbadk.coreExtra.data.WriteData;
import com.baidu.tbadk.coreExtra.data.t;
import com.baidu.tieba.d;
import com.baidu.tieba.tbadkCore.writeModel.NewWriteModel;
import com.baidu.tieba.tbadkCore.writeModel.PostWriteCallBackData;
import com.baidu.tieba.write.vcode.newVcode.NewVcodeView;
/* loaded from: classes3.dex */
public class a implements b {
    private PostWriteCallBackData fwa;
    private final NewWriteModel hod;
    private final NewVcodeView hrm;
    private NewWriteModel.d hrn;
    private boolean hoe = false;
    private final NewWriteModel.d aNh = new NewWriteModel.d() { // from class: com.baidu.tieba.write.vcode.newVcode.a.a.1
        @Override // com.baidu.tieba.tbadkCore.writeModel.NewWriteModel.d
        public void callback(boolean z, PostWriteCallBackData postWriteCallBackData, t tVar, WriteData writeData, AntiData antiData) {
            String str;
            String str2;
            String str3 = null;
            if (a.this.hrm != null) {
                a.this.hrm.showPostThreadLoadingView(false);
                if (z) {
                    a.this.fwa = postWriteCallBackData;
                    a.this.hoe = true;
                    if (tVar == null || tVar.Ck() == null) {
                        str = null;
                        str2 = null;
                    } else {
                        str2 = tVar.Ck().endPoint;
                        str = tVar.Ck().successImg;
                        str3 = tVar.Ck().slideEndPoint;
                    }
                    a.this.hrm.runJsMethod(ImagesInvalidReceiver.SUCCESS, str + "," + str2 + "," + str3);
                } else if (postWriteCallBackData == null || postWriteCallBackData.getErrorCode() != 227001) {
                    if (a.this.hrn != null) {
                        a.this.hrn.callback(false, postWriteCallBackData, tVar, writeData, antiData);
                    }
                } else {
                    a.this.hrm.getContext().setVisible(false);
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new AccountAccessActivityConfig(a.this.hrm.getContext().getActivity(), IEventCenterService.EventId.EventMode.SAPIACCOUNT_FACE_REG, writeData, postWriteCallBackData.getAccessState())));
                }
            }
        }
    };

    public a(NewVcodeView newVcodeView, NewWriteModel newWriteModel) {
        this.hrm = newVcodeView;
        this.hod = newWriteModel;
        this.hod.b(this.aNh);
    }

    @Override // com.baidu.tieba.write.vcode.newVcode.a.b
    public boolean onUrlLoad(WebView webView, String str) {
        WriteData writeData;
        if (this.hod.getWriteData() == null || StringUtils.isNull(str) || (writeData = this.hod.getWriteData()) == null) {
            return false;
        }
        if (str.contains("objc:loadReady")) {
            if (writeData.getVcodeExtra() == null) {
                return false;
            }
            this.hrm.runJsMethod("handleFreshCaptcha", "'" + writeData.getVcodeUrl() + "','" + writeData.getVcodeExtra().slideImg + "','" + writeData.getVcodeExtra().textImg + "'");
            return true;
        } else if (str.contains("objc:jsChangePosition")) {
            vK(com.baidu.tbadk.p.a.hL(str));
            return true;
        } else if (str.contains("objc:finish")) {
            this.hoe = true;
            if (writeData != null && writeData.getVideoReviewType() == 1) {
                this.hrm.showToast(true, this.hrm.getContext().getResources().getString(d.k.video_send_success_under_review));
            } else if (writeData != null && writeData.getVideoReviewType() == 2) {
                this.hrm.showToast(true, this.hrm.getContext().getResources().getString(d.k.video_send_success));
            } else {
                String str2 = null;
                String str3 = null;
                String string = this.hrm.getContext().getResources().getString(d.k.send_success);
                if (this.fwa != null) {
                    str2 = this.fwa.getPreMsg();
                    str3 = this.fwa.getColorMsg();
                    string = this.fwa.getErrorString();
                }
                if (writeData.getType() != 7) {
                    com.baidu.tieba.tbadkCore.writeModel.c.e(this.hrm.getContext().getActivity(), string, str2, str3);
                }
            }
            Intent intent = new Intent();
            Bundle bundle = new Bundle();
            bundle.putSerializable("post_write_callback_data", this.fwa);
            intent.putExtras(bundle);
            BaseActivity context = this.hrm.getContext();
            this.hrm.getContext();
            context.setResult(-1, intent);
            this.hrm.getContext().finish();
            return true;
        } else if (str.contains("objc:jumpToFeedback()")) {
            WriteActivityConfig writeActivityConfig = new WriteActivityConfig(this.hrm.getContext().getActivity(), 0, TbConfig.getPositionPagerId(), TbConfig.getPositionPagerName(), null, null, 0, null, 13003, true, false, null, false, false, null, null, null, 0);
            writeActivityConfig.setIsVcodeFeedBack();
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, writeActivityConfig));
            return true;
        } else {
            return false;
        }
    }

    @Override // com.baidu.tieba.write.vcode.newVcode.a.b
    public void onPageFinished(WebView webView, String str) {
        if (this.hrm != null) {
            this.hrm.showWebViewDelay(1000);
        }
    }

    @Override // com.baidu.tieba.write.vcode.newVcode.a.b
    public void showErrorOnStart(boolean z, String str) {
    }

    @Override // com.baidu.tieba.write.vcode.newVcode.a.b
    public void start(boolean z) {
        this.hrm.setRatio(0.9433962f);
        this.hrm.showWebView(false);
        this.hrm.getWebView().loadUrl(TbConfig.SERVER_ADDRESS_WEB_VIEW + "n/captcha-drag");
    }

    @Override // com.baidu.tieba.write.vcode.newVcode.a.b
    public void onDestroy() {
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

    private void vK(String str) {
        this.hoe = false;
        if (!l.jU()) {
            this.hrm.getContext().showToast(d.k.neterror);
            this.hrm.getContext().finish();
        } else if (!StringUtils.isNull(str)) {
            this.hrm.showPostThreadLoadingView(true);
            this.hod.getWriteData().setVcode(str);
            this.hod.getWriteData().setVcodeType("5");
            this.hod.startPostWrite();
        } else {
            this.hrm.getContext().showToast(d.k.neterror);
            this.hrm.getContext().finish();
        }
    }
}
