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
    private final b jmA;
    private final NewWriteModel jmD;
    private boolean jmE = false;
    private final NewWriteModel.d cks = new NewWriteModel.d() { // from class: com.baidu.tieba.write.accountAccess.a.1
        @Override // com.baidu.tieba.tbadkCore.writeModel.NewWriteModel.d
        public void callback(boolean z, PostWriteCallBackData postWriteCallBackData, x xVar, WriteData writeData, AntiData antiData) {
            if (a.this.jmA != null && a.this.jmD != null && a.this.jmD.getWriteData() != null) {
                a.this.jmA.showPostThreadLoadingView(false);
                WriteData writeData2 = writeData == null ? a.this.jmD.getWriteData() : writeData;
                if (z) {
                    a.this.jmE = true;
                    if (writeData2.getType() != 0 || writeData2.isUserFeedback()) {
                        if (postWriteCallBackData == null) {
                            c.f(a.this.jmA.getContext().getActivity(), a.this.jmA.getContext().getResources().getString(d.j.send_success), null, null);
                        } else {
                            c.f(a.this.jmA.getContext().getActivity(), postWriteCallBackData.getErrorString(), postWriteCallBackData.getPreMsg(), postWriteCallBackData.getColorMsg());
                        }
                    }
                    Intent intent = new Intent();
                    Bundle bundle = new Bundle();
                    bundle.putSerializable("post_write_callback_data", postWriteCallBackData);
                    intent.putExtras(bundle);
                    BaseActivity context = a.this.jmA.getContext();
                    a.this.jmA.getContext();
                    context.setResult(-1, intent);
                    a.this.jmA.getContext().finish();
                } else if (writeData2 != null && xVar != null && !TextUtils.isEmpty(xVar.agD())) {
                    writeData2.setVcodeMD5(xVar.getVcode_md5());
                    writeData2.setVcodeUrl(xVar.getVcode_pic_url());
                    writeData2.setVcodeExtra(xVar.agE());
                    a.this.jmA.getContext().setVisible(false);
                    if (com.baidu.tbadk.u.a.pT(xVar.agD())) {
                        MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new NewVcodeActivityConfig(a.this.jmA.getContext().getActivity(), IEventCenterService.EventId.EventMode.SAPIACCOUNT_FACE_REG, writeData2, false, xVar.agD())));
                    } else {
                        MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new VcodeActivityConfig(a.this.jmA.getContext().getActivity(), writeData2, IEventCenterService.EventId.EventMode.SAPIACCOUNT_FACE_REG)));
                    }
                } else if (postWriteCallBackData != null && postWriteCallBackData.isSensitiveError()) {
                    Intent intent2 = new Intent();
                    Bundle bundle2 = new Bundle();
                    bundle2.putSerializable("post_write_callback_data", postWriteCallBackData);
                    intent2.putExtras(bundle2);
                    BaseActivity context2 = a.this.jmA.getContext();
                    a.this.jmA.getContext();
                    context2.setResult(0, intent2);
                    a.this.jmA.getContext().finish();
                } else {
                    if (postWriteCallBackData != null) {
                        c.f(a.this.jmA.getContext().getActivity(), postWriteCallBackData.getErrorString(), postWriteCallBackData.getPreMsg(), postWriteCallBackData.getColorMsg());
                        BaseActivity context3 = a.this.jmA.getContext();
                        a.this.jmA.getContext();
                        context3.setResult(0, null);
                    }
                    a.this.jmA.getContext().finish();
                }
            }
        }
    };

    public a(b bVar, NewWriteModel newWriteModel) {
        this.jmA = bVar;
        this.jmD = newWriteModel;
        newWriteModel.b(this.cks);
    }

    public boolean En(String str) {
        if (this.jmA == null || str == null) {
            return false;
        }
        if (str.equals("http://tieba.baidu.com/account/access/cancel")) {
            this.jmA.getContext().finish();
            return true;
        } else if (str.equals("http://tieba.baidu.com/account/access/input_focus")) {
            this.jmA.D(0, UtilHelper.getImmersiveStickyBarHeight(), 0, 0);
            if (this.jmA.coz() != this.jmA.fe()) {
                this.jmA.setRatio(this.jmA.coz());
                this.jmA.coA();
            }
            this.jmA.getWebView().setVisibility(0);
            return true;
        } else if (str.equals("http://tieba.baidu.com/account/access/valid_success")) {
            coy();
            return true;
        } else if (str.equals("http://tieba.baidu.com/account/access/feedback") || str.equals("https://tieba.baidu.com/account/access/feedback")) {
            this.jmA.getContext().finish();
            ba.adD().c(this.jmA.getContext().getPageContext(), new String[]{"feedback:"});
            return true;
        } else {
            return true;
        }
    }

    public void cox() {
        if (this.jmA != null) {
            this.jmA.showWebViewDelay(500);
        }
    }

    public void al(String str) {
        if (this.jmA != null) {
            this.jmA.showWebLoadingView(true);
            this.jmA.showWebView(false);
            this.jmA.getWebView().loadUrl(str);
        }
    }

    public void onPostThreadCancle() {
        if (this.jmA != null) {
            this.jmA.showPostThreadLoadingView(false);
        }
    }

    private void coy() {
        this.jmE = false;
        if (this.jmA != null && this.jmD != null) {
            if (!l.lo()) {
                this.jmA.getContext().showToast(d.j.neterror);
                this.jmA.getContext().finish();
                return;
            }
            this.jmA.showPostThreadLoadingView(true);
            this.jmD.startPostWrite();
        }
    }
}
