package com.baidu.tieba.write.accountAccess;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.lib.util.l;
import com.baidu.sapi2.passhost.pluginsdk.service.IEventCenterService;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.core.atomData.NewVcodeActivityConfig;
import com.baidu.tbadk.core.atomData.VcodeActivityConfig;
import com.baidu.tbadk.core.data.AntiData;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.ba;
import com.baidu.tbadk.coreExtra.data.WriteData;
import com.baidu.tbadk.coreExtra.data.x;
import com.baidu.tieba.d;
import com.baidu.tieba.tbadkCore.writeModel.NewWriteModel;
import com.baidu.tieba.tbadkCore.writeModel.PostWriteCallBackData;
import com.baidu.tieba.tbadkCore.writeModel.c;
/* loaded from: classes3.dex */
public class a {
    private final b jmo;
    private final NewWriteModel jms;
    private boolean jmt = false;
    private final NewWriteModel.d ckv = new NewWriteModel.d() { // from class: com.baidu.tieba.write.accountAccess.a.1
        @Override // com.baidu.tieba.tbadkCore.writeModel.NewWriteModel.d
        public void callback(boolean z, PostWriteCallBackData postWriteCallBackData, x xVar, WriteData writeData, AntiData antiData) {
            if (a.this.jmo != null && a.this.jms != null && a.this.jms.getWriteData() != null) {
                a.this.jmo.showPostThreadLoadingView(false);
                WriteData writeData2 = writeData == null ? a.this.jms.getWriteData() : writeData;
                if (z) {
                    a.this.jmt = true;
                    if (writeData2.getType() != 0 || writeData2.isUserFeedback()) {
                        if (postWriteCallBackData == null) {
                            c.f(a.this.jmo.getContext().getActivity(), a.this.jmo.getContext().getResources().getString(d.j.send_success), null, null);
                        } else {
                            c.f(a.this.jmo.getContext().getActivity(), postWriteCallBackData.getErrorString(), postWriteCallBackData.getPreMsg(), postWriteCallBackData.getColorMsg());
                        }
                    }
                    Intent intent = new Intent();
                    Bundle bundle = new Bundle();
                    bundle.putSerializable("post_write_callback_data", postWriteCallBackData);
                    intent.putExtras(bundle);
                    BaseActivity context = a.this.jmo.getContext();
                    a.this.jmo.getContext();
                    context.setResult(-1, intent);
                    a.this.jmo.getContext().finish();
                } else if (writeData2 != null && xVar != null && !TextUtils.isEmpty(xVar.agA())) {
                    writeData2.setVcodeMD5(xVar.getVcode_md5());
                    writeData2.setVcodeUrl(xVar.getVcode_pic_url());
                    writeData2.setVcodeExtra(xVar.agB());
                    a.this.jmo.getContext().setVisible(false);
                    if (com.baidu.tbadk.u.a.pU(xVar.agA())) {
                        MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new NewVcodeActivityConfig(a.this.jmo.getContext().getActivity(), IEventCenterService.EventId.EventMode.SAPIACCOUNT_FACE_REG, writeData2, false, xVar.agA())));
                    } else {
                        MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new VcodeActivityConfig(a.this.jmo.getContext().getActivity(), writeData2, IEventCenterService.EventId.EventMode.SAPIACCOUNT_FACE_REG)));
                    }
                } else if (postWriteCallBackData != null && postWriteCallBackData.isSensitiveError()) {
                    Intent intent2 = new Intent();
                    Bundle bundle2 = new Bundle();
                    bundle2.putSerializable("post_write_callback_data", postWriteCallBackData);
                    intent2.putExtras(bundle2);
                    BaseActivity context2 = a.this.jmo.getContext();
                    a.this.jmo.getContext();
                    context2.setResult(0, intent2);
                    a.this.jmo.getContext().finish();
                } else {
                    if (postWriteCallBackData != null) {
                        c.f(a.this.jmo.getContext().getActivity(), postWriteCallBackData.getErrorString(), postWriteCallBackData.getPreMsg(), postWriteCallBackData.getColorMsg());
                        BaseActivity context3 = a.this.jmo.getContext();
                        a.this.jmo.getContext();
                        context3.setResult(0, null);
                    }
                    a.this.jmo.getContext().finish();
                }
            }
        }
    };

    public a(b bVar, NewWriteModel newWriteModel) {
        this.jmo = bVar;
        this.jms = newWriteModel;
        newWriteModel.b(this.ckv);
    }

    public boolean Em(String str) {
        if (this.jmo == null || str == null) {
            return false;
        }
        if (str.equals("http://tieba.baidu.com/account/access/cancel")) {
            this.jmo.getContext().finish();
            return true;
        } else if (str.equals("http://tieba.baidu.com/account/access/input_focus")) {
            this.jmo.D(0, UtilHelper.getImmersiveStickyBarHeight(), 0, 0);
            if (this.jmo.cox() != this.jmo.fe()) {
                this.jmo.setRatio(this.jmo.cox());
                this.jmo.coy();
            }
            this.jmo.getWebView().setVisibility(0);
            return true;
        } else if (str.equals("http://tieba.baidu.com/account/access/valid_success")) {
            cow();
            return true;
        } else if (str.equals("http://tieba.baidu.com/account/access/feedback") || str.equals("https://tieba.baidu.com/account/access/feedback")) {
            this.jmo.getContext().finish();
            ba.adA().c(this.jmo.getContext().getPageContext(), new String[]{"feedback:"});
            return true;
        } else {
            return true;
        }
    }

    public void cov() {
        if (this.jmo != null) {
            this.jmo.showWebViewDelay(500);
        }
    }

    public void al(String str) {
        if (this.jmo != null) {
            this.jmo.showWebLoadingView(true);
            this.jmo.showWebView(false);
            this.jmo.getWebView().loadUrl(str);
        }
    }

    public void onPostThreadCancle() {
        if (this.jmo != null) {
            this.jmo.showPostThreadLoadingView(false);
        }
    }

    private void cow() {
        this.jmt = false;
        if (this.jmo != null && this.jms != null) {
            if (!l.lo()) {
                this.jmo.getContext().showToast(d.j.neterror);
                this.jmo.getContext().finish();
                return;
            }
            this.jmo.showPostThreadLoadingView(true);
            this.jms.startPostWrite();
        }
    }
}
