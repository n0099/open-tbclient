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
import com.xiaomi.mipush.sdk.Constants;
/* loaded from: classes3.dex */
public class a implements b {
    private PostWriteCallBackData fjB;
    private final NewWriteModel hbh;
    private final NewVcodeView heq;
    private NewWriteModel.d her;
    private boolean hbi = false;
    private final NewWriteModel.d aEK = new NewWriteModel.d() { // from class: com.baidu.tieba.write.vcode.newVcode.a.a.1
        @Override // com.baidu.tieba.tbadkCore.writeModel.NewWriteModel.d
        public void callback(boolean z, PostWriteCallBackData postWriteCallBackData, t tVar, WriteData writeData, AntiData antiData) {
            String str;
            String str2;
            String str3 = null;
            if (a.this.heq != null) {
                a.this.heq.showPostThreadLoadingView(false);
                if (z) {
                    a.this.fjB = postWriteCallBackData;
                    a.this.hbi = true;
                    if (tVar == null || tVar.yL() == null) {
                        str = null;
                        str2 = null;
                    } else {
                        str2 = tVar.yL().endPoint;
                        str = tVar.yL().successImg;
                        str3 = tVar.yL().slideEndPoint;
                    }
                    a.this.heq.runJsMethod(ImagesInvalidReceiver.SUCCESS, str + Constants.ACCEPT_TIME_SEPARATOR_SP + str2 + Constants.ACCEPT_TIME_SEPARATOR_SP + str3);
                } else if (postWriteCallBackData == null || postWriteCallBackData.getErrorCode() != 227001) {
                    if (a.this.her != null) {
                        a.this.her.callback(false, postWriteCallBackData, tVar, writeData, antiData);
                    }
                } else {
                    a.this.heq.getContext().setVisible(false);
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new AccountAccessActivityConfig(a.this.heq.getContext().getActivity(), IEventCenterService.EventId.EventMode.SAPIACCOUNT_FACE_REG, writeData, postWriteCallBackData.getAccessState())));
                }
            }
        }
    };

    public a(NewVcodeView newVcodeView, NewWriteModel newWriteModel) {
        this.heq = newVcodeView;
        this.hbh = newWriteModel;
        this.hbh.b(this.aEK);
    }

    @Override // com.baidu.tieba.write.vcode.newVcode.a.b
    public boolean onUrlLoad(WebView webView, String str) {
        WriteData writeData;
        if (this.hbh.getWriteData() == null || StringUtils.isNull(str) || (writeData = this.hbh.getWriteData()) == null) {
            return false;
        }
        if (str.contains("objc:loadReady")) {
            if (writeData.getVcodeExtra() == null) {
                return false;
            }
            this.heq.runJsMethod("handleFreshCaptcha", "'" + writeData.getVcodeUrl() + "','" + writeData.getVcodeExtra().slideImg + "','" + writeData.getVcodeExtra().textImg + "'");
            return true;
        } else if (str.contains("objc:jsChangePosition")) {
            uN(com.baidu.tbadk.p.a.hp(str));
            return true;
        } else if (str.contains("objc:finish")) {
            this.hbi = true;
            if (writeData != null && writeData.getVideoReviewType() == 1) {
                this.heq.showToast(true, this.heq.getContext().getResources().getString(d.k.video_send_success_under_review));
            } else if (writeData != null && writeData.getVideoReviewType() == 2) {
                this.heq.showToast(true, this.heq.getContext().getResources().getString(d.k.video_send_success));
            } else {
                String str2 = null;
                String str3 = null;
                String string = this.heq.getContext().getResources().getString(d.k.send_success);
                if (this.fjB != null) {
                    str2 = this.fjB.getPreMsg();
                    str3 = this.fjB.getColorMsg();
                    string = this.fjB.getErrorString();
                }
                if (writeData.getType() != 7) {
                    com.baidu.tieba.tbadkCore.writeModel.c.e(this.heq.getContext().getActivity(), string, str2, str3);
                }
            }
            Intent intent = new Intent();
            Bundle bundle = new Bundle();
            bundle.putSerializable("post_write_callback_data", this.fjB);
            intent.putExtras(bundle);
            BaseActivity context = this.heq.getContext();
            this.heq.getContext();
            context.setResult(-1, intent);
            this.heq.getContext().finish();
            return true;
        } else if (str.contains("objc:jumpToFeedback()")) {
            WriteActivityConfig writeActivityConfig = new WriteActivityConfig(this.heq.getContext().getActivity(), 0, TbConfig.getPositionPagerId(), TbConfig.getPositionPagerName(), null, null, 0, null, 13003, true, false, null, false, false, null, null, null, 0);
            writeActivityConfig.setIsVcodeFeedBack();
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, writeActivityConfig));
            return true;
        } else {
            return false;
        }
    }

    @Override // com.baidu.tieba.write.vcode.newVcode.a.b
    public void onPageFinished(WebView webView, String str) {
        if (this.heq != null) {
            this.heq.showWebViewDelay(1000);
        }
    }

    @Override // com.baidu.tieba.write.vcode.newVcode.a.b
    public void showErrorOnStart(boolean z, String str) {
    }

    @Override // com.baidu.tieba.write.vcode.newVcode.a.b
    public void start(boolean z) {
        this.heq.setRatio(0.9433962f);
        this.heq.showWebView(false);
        this.heq.getWebView().loadUrl(TbConfig.SERVER_ADDRESS_WEB_VIEW + "n/captcha-drag");
    }

    @Override // com.baidu.tieba.write.vcode.newVcode.a.b
    public void onDestroy() {
    }

    @Override // com.baidu.tieba.write.vcode.newVcode.a.b
    public void d(NewWriteModel.d dVar) {
        this.her = dVar;
    }

    @Override // com.baidu.tieba.write.vcode.newVcode.a.b
    public void onPostThreadCancle() {
        this.heq.showPostThreadLoadingView(false);
        this.hbh.cancelLoadData();
    }

    private void uN(String str) {
        this.hbi = false;
        if (!l.hg()) {
            this.heq.getContext().showToast(d.k.neterror);
            this.heq.getContext().finish();
        } else if (!StringUtils.isNull(str)) {
            this.heq.showPostThreadLoadingView(true);
            this.hbh.getWriteData().setVcode(str);
            this.hbh.getWriteData().setVcodeType("5");
            this.hbh.startPostWrite();
        } else {
            this.heq.getContext().showToast(d.k.neterror);
            this.heq.getContext().finish();
        }
    }
}
