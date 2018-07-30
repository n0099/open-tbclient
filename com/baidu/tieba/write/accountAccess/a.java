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
import com.baidu.tbadk.core.util.ay;
import com.baidu.tbadk.coreExtra.data.WriteData;
import com.baidu.tbadk.coreExtra.data.t;
import com.baidu.tieba.d;
import com.baidu.tieba.tbadkCore.writeModel.NewWriteModel;
import com.baidu.tieba.tbadkCore.writeModel.PostWriteCallBackData;
import com.baidu.tieba.tbadkCore.writeModel.c;
/* loaded from: classes3.dex */
public class a {
    private final b htr;
    private final NewWriteModel htu;
    private boolean htv = false;
    private final NewWriteModel.d aOc = new NewWriteModel.d() { // from class: com.baidu.tieba.write.accountAccess.a.1
        @Override // com.baidu.tieba.tbadkCore.writeModel.NewWriteModel.d
        public void callback(boolean z, PostWriteCallBackData postWriteCallBackData, t tVar, WriteData writeData, AntiData antiData) {
            if (a.this.htr != null && a.this.htu != null && a.this.htu.getWriteData() != null) {
                a.this.htr.showPostThreadLoadingView(false);
                WriteData writeData2 = writeData == null ? a.this.htu.getWriteData() : writeData;
                if (z) {
                    a.this.htv = true;
                    if (writeData2.getType() != 0 || writeData2.isUserFeedback()) {
                        if (postWriteCallBackData == null) {
                            c.e(a.this.htr.getContext().getActivity(), a.this.htr.getContext().getResources().getString(d.j.send_success), null, null);
                        } else {
                            c.e(a.this.htr.getContext().getActivity(), postWriteCallBackData.getErrorString(), postWriteCallBackData.getPreMsg(), postWriteCallBackData.getColorMsg());
                        }
                    }
                    Intent intent = new Intent();
                    Bundle bundle = new Bundle();
                    bundle.putSerializable("post_write_callback_data", postWriteCallBackData);
                    intent.putExtras(bundle);
                    BaseActivity context = a.this.htr.getContext();
                    a.this.htr.getContext();
                    context.setResult(-1, intent);
                    a.this.htr.getContext().finish();
                } else if (writeData2 != null && tVar != null && !TextUtils.isEmpty(tVar.Ct())) {
                    writeData2.setVcodeMD5(tVar.getVcode_md5());
                    writeData2.setVcodeUrl(tVar.getVcode_pic_url());
                    writeData2.setVcodeExtra(tVar.Cu());
                    a.this.htr.getContext().setVisible(false);
                    if (com.baidu.tbadk.q.a.hN(tVar.Ct())) {
                        MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new NewVcodeActivityConfig(a.this.htr.getContext().getActivity(), IEventCenterService.EventId.EventMode.SAPIACCOUNT_FACE_REG, writeData2, false, tVar.Ct())));
                    } else {
                        MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new VcodeActivityConfig(a.this.htr.getContext().getActivity(), writeData2, IEventCenterService.EventId.EventMode.SAPIACCOUNT_FACE_REG)));
                    }
                } else if (postWriteCallBackData != null && postWriteCallBackData.isSensitiveError()) {
                    Intent intent2 = new Intent();
                    Bundle bundle2 = new Bundle();
                    bundle2.putSerializable("post_write_callback_data", postWriteCallBackData);
                    intent2.putExtras(bundle2);
                    BaseActivity context2 = a.this.htr.getContext();
                    a.this.htr.getContext();
                    context2.setResult(0, intent2);
                    a.this.htr.getContext().finish();
                } else {
                    if (postWriteCallBackData != null) {
                        c.e(a.this.htr.getContext().getActivity(), postWriteCallBackData.getErrorString(), postWriteCallBackData.getPreMsg(), postWriteCallBackData.getColorMsg());
                        BaseActivity context3 = a.this.htr.getContext();
                        a.this.htr.getContext();
                        context3.setResult(0, null);
                    }
                    a.this.htr.getContext().finish();
                }
            }
        }
    };

    public a(b bVar, NewWriteModel newWriteModel) {
        this.htr = bVar;
        this.htu = newWriteModel;
        newWriteModel.b(this.aOc);
    }

    public boolean vz(String str) {
        if (this.htr == null || str == null) {
            return false;
        }
        if (str.equals("http://tieba.baidu.com/account/access/cancel")) {
            this.htr.getContext().finish();
            return true;
        } else if (str.equals("http://tieba.baidu.com/account/access/input_focus")) {
            this.htr.z(0, UtilHelper.getImmersiveStickyBarHeight(), 0, 0);
            if (this.htr.bFy() != this.htr.dH()) {
                this.htr.setRatio(this.htr.bFy());
                this.htr.bFz();
            }
            this.htr.getWebView().setVisibility(0);
            return true;
        } else if (str.equals("http://tieba.baidu.com/account/access/valid_success")) {
            bFx();
            return true;
        } else if (str.equals("http://tieba.baidu.com/account/access/feedback") || str.equals("https://tieba.baidu.com/account/access/feedback")) {
            this.htr.getContext().finish();
            ay.zK().c(this.htr.getContext().getPageContext(), new String[]{"feedback:"});
            return true;
        } else {
            return true;
        }
    }

    public void bFw() {
        if (this.htr != null) {
            this.htr.showWebViewDelay(500);
        }
    }

    public void U(String str) {
        if (this.htr != null) {
            this.htr.showWebLoadingView(true);
            this.htr.showWebView(false);
            this.htr.getWebView().loadUrl(str);
        }
    }

    public void onPostThreadCancle() {
        if (this.htr != null) {
            this.htr.showPostThreadLoadingView(false);
        }
    }

    private void bFx() {
        this.htv = false;
        if (this.htr != null && this.htu != null) {
            if (!l.jV()) {
                this.htr.getContext().showToast(d.j.neterror);
                this.htr.getContext().finish();
                return;
            }
            this.htr.showPostThreadLoadingView(true);
            this.htu.startPostWrite();
        }
    }
}
