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
import com.baidu.tbadk.core.util.az;
import com.baidu.tbadk.coreExtra.data.WriteData;
import com.baidu.tbadk.coreExtra.data.u;
import com.baidu.tieba.f;
import com.baidu.tieba.tbadkCore.writeModel.NewWriteModel;
import com.baidu.tieba.tbadkCore.writeModel.PostWriteCallBackData;
import com.baidu.tieba.tbadkCore.writeModel.c;
/* loaded from: classes3.dex */
public class a {
    private final b htt;
    private final NewWriteModel htw;
    private boolean htx = false;
    private final NewWriteModel.d aNZ = new NewWriteModel.d() { // from class: com.baidu.tieba.write.accountAccess.a.1
        @Override // com.baidu.tieba.tbadkCore.writeModel.NewWriteModel.d
        public void callback(boolean z, PostWriteCallBackData postWriteCallBackData, u uVar, WriteData writeData, AntiData antiData) {
            if (a.this.htt != null && a.this.htw != null && a.this.htw.getWriteData() != null) {
                a.this.htt.showPostThreadLoadingView(false);
                WriteData writeData2 = writeData == null ? a.this.htw.getWriteData() : writeData;
                if (z) {
                    a.this.htx = true;
                    if (writeData2.getType() != 0 || writeData2.isUserFeedback()) {
                        if (postWriteCallBackData == null) {
                            c.e(a.this.htt.getContext().getActivity(), a.this.htt.getContext().getResources().getString(f.j.send_success), null, null);
                        } else {
                            c.e(a.this.htt.getContext().getActivity(), postWriteCallBackData.getErrorString(), postWriteCallBackData.getPreMsg(), postWriteCallBackData.getColorMsg());
                        }
                    }
                    Intent intent = new Intent();
                    Bundle bundle = new Bundle();
                    bundle.putSerializable("post_write_callback_data", postWriteCallBackData);
                    intent.putExtras(bundle);
                    BaseActivity context = a.this.htt.getContext();
                    a.this.htt.getContext();
                    context.setResult(-1, intent);
                    a.this.htt.getContext().finish();
                } else if (writeData2 != null && uVar != null && !TextUtils.isEmpty(uVar.Cr())) {
                    writeData2.setVcodeMD5(uVar.getVcode_md5());
                    writeData2.setVcodeUrl(uVar.getVcode_pic_url());
                    writeData2.setVcodeExtra(uVar.Cs());
                    a.this.htt.getContext().setVisible(false);
                    if (com.baidu.tbadk.q.a.hN(uVar.Cr())) {
                        MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new NewVcodeActivityConfig(a.this.htt.getContext().getActivity(), IEventCenterService.EventId.EventMode.SAPIACCOUNT_FACE_REG, writeData2, false, uVar.Cr())));
                    } else {
                        MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new VcodeActivityConfig(a.this.htt.getContext().getActivity(), writeData2, IEventCenterService.EventId.EventMode.SAPIACCOUNT_FACE_REG)));
                    }
                } else if (postWriteCallBackData != null && postWriteCallBackData.isSensitiveError()) {
                    Intent intent2 = new Intent();
                    Bundle bundle2 = new Bundle();
                    bundle2.putSerializable("post_write_callback_data", postWriteCallBackData);
                    intent2.putExtras(bundle2);
                    BaseActivity context2 = a.this.htt.getContext();
                    a.this.htt.getContext();
                    context2.setResult(0, intent2);
                    a.this.htt.getContext().finish();
                } else {
                    if (postWriteCallBackData != null) {
                        c.e(a.this.htt.getContext().getActivity(), postWriteCallBackData.getErrorString(), postWriteCallBackData.getPreMsg(), postWriteCallBackData.getColorMsg());
                        BaseActivity context3 = a.this.htt.getContext();
                        a.this.htt.getContext();
                        context3.setResult(0, null);
                    }
                    a.this.htt.getContext().finish();
                }
            }
        }
    };

    public a(b bVar, NewWriteModel newWriteModel) {
        this.htt = bVar;
        this.htw = newWriteModel;
        newWriteModel.b(this.aNZ);
    }

    public boolean vD(String str) {
        if (this.htt == null || str == null) {
            return false;
        }
        if (str.equals("http://tieba.baidu.com/account/access/cancel")) {
            this.htt.getContext().finish();
            return true;
        } else if (str.equals("http://tieba.baidu.com/account/access/input_focus")) {
            this.htt.z(0, UtilHelper.getImmersiveStickyBarHeight(), 0, 0);
            if (this.htt.bFC() != this.htt.dH()) {
                this.htt.setRatio(this.htt.bFC());
                this.htt.bFD();
            }
            this.htt.getWebView().setVisibility(0);
            return true;
        } else if (str.equals("http://tieba.baidu.com/account/access/valid_success")) {
            bFB();
            return true;
        } else if (str.equals("http://tieba.baidu.com/account/access/feedback") || str.equals("https://tieba.baidu.com/account/access/feedback")) {
            this.htt.getContext().finish();
            az.zI().c(this.htt.getContext().getPageContext(), new String[]{"feedback:"});
            return true;
        } else {
            return true;
        }
    }

    public void bFA() {
        if (this.htt != null) {
            this.htt.showWebViewDelay(500);
        }
    }

    public void U(String str) {
        if (this.htt != null) {
            this.htt.showWebLoadingView(true);
            this.htt.showWebView(false);
            this.htt.getWebView().loadUrl(str);
        }
    }

    public void onPostThreadCancle() {
        if (this.htt != null) {
            this.htt.showPostThreadLoadingView(false);
        }
    }

    private void bFB() {
        this.htx = false;
        if (this.htt != null && this.htw != null) {
            if (!l.jV()) {
                this.htt.getContext().showToast(f.j.neterror);
                this.htt.getContext().finish();
                return;
            }
            this.htt.showPostThreadLoadingView(true);
            this.htw.startPostWrite();
        }
    }
}
