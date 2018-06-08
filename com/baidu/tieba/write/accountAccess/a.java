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
    private final b hoa;
    private final NewWriteModel hod;
    private boolean hoe = false;
    private final NewWriteModel.d aNh = new NewWriteModel.d() { // from class: com.baidu.tieba.write.accountAccess.a.1
        @Override // com.baidu.tieba.tbadkCore.writeModel.NewWriteModel.d
        public void callback(boolean z, PostWriteCallBackData postWriteCallBackData, t tVar, WriteData writeData, AntiData antiData) {
            if (a.this.hoa != null && a.this.hod != null && a.this.hod.getWriteData() != null) {
                a.this.hoa.showPostThreadLoadingView(false);
                WriteData writeData2 = writeData == null ? a.this.hod.getWriteData() : writeData;
                if (z) {
                    a.this.hoe = true;
                    if (writeData2.getType() != 0 || writeData2.isUserFeedback()) {
                        if (postWriteCallBackData == null) {
                            c.e(a.this.hoa.getContext().getActivity(), a.this.hoa.getContext().getResources().getString(d.k.send_success), null, null);
                        } else {
                            c.e(a.this.hoa.getContext().getActivity(), postWriteCallBackData.getErrorString(), postWriteCallBackData.getPreMsg(), postWriteCallBackData.getColorMsg());
                        }
                    }
                    Intent intent = new Intent();
                    Bundle bundle = new Bundle();
                    bundle.putSerializable("post_write_callback_data", postWriteCallBackData);
                    intent.putExtras(bundle);
                    BaseActivity context = a.this.hoa.getContext();
                    a.this.hoa.getContext();
                    context.setResult(-1, intent);
                    a.this.hoa.getContext().finish();
                } else if (writeData2 != null && tVar != null && !TextUtils.isEmpty(tVar.Cj())) {
                    writeData2.setVcodeMD5(tVar.getVcode_md5());
                    writeData2.setVcodeUrl(tVar.getVcode_pic_url());
                    writeData2.setVcodeExtra(tVar.Ck());
                    a.this.hoa.getContext().setVisible(false);
                    if (com.baidu.tbadk.p.a.hM(tVar.Cj())) {
                        MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new NewVcodeActivityConfig(a.this.hoa.getContext().getActivity(), IEventCenterService.EventId.EventMode.SAPIACCOUNT_FACE_REG, writeData2, false, tVar.Cj())));
                    } else {
                        MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new VcodeActivityConfig(a.this.hoa.getContext().getActivity(), writeData2, IEventCenterService.EventId.EventMode.SAPIACCOUNT_FACE_REG)));
                    }
                } else if (postWriteCallBackData != null && postWriteCallBackData.isSensitiveError()) {
                    Intent intent2 = new Intent();
                    Bundle bundle2 = new Bundle();
                    bundle2.putSerializable("post_write_callback_data", postWriteCallBackData);
                    intent2.putExtras(bundle2);
                    BaseActivity context2 = a.this.hoa.getContext();
                    a.this.hoa.getContext();
                    context2.setResult(0, intent2);
                    a.this.hoa.getContext().finish();
                } else {
                    if (postWriteCallBackData != null) {
                        c.e(a.this.hoa.getContext().getActivity(), postWriteCallBackData.getErrorString(), postWriteCallBackData.getPreMsg(), postWriteCallBackData.getColorMsg());
                        BaseActivity context3 = a.this.hoa.getContext();
                        a.this.hoa.getContext();
                        context3.setResult(0, null);
                    }
                    a.this.hoa.getContext().finish();
                }
            }
        }
    };

    public a(b bVar, NewWriteModel newWriteModel) {
        this.hoa = bVar;
        this.hod = newWriteModel;
        newWriteModel.b(this.aNh);
    }

    public boolean vC(String str) {
        if (this.hoa == null || str == null) {
            return false;
        }
        if (str.equals("http://tieba.baidu.com/account/access/cancel")) {
            this.hoa.getContext().finish();
            return true;
        } else if (str.equals("http://tieba.baidu.com/account/access/input_focus")) {
            this.hoa.C(0, UtilHelper.getImmersiveStickyBarHeight(), 0, 0);
            if (this.hoa.bGm() != this.hoa.dJ()) {
                this.hoa.setRatio(this.hoa.bGm());
                this.hoa.bGn();
            }
            this.hoa.getWebView().setVisibility(0);
            return true;
        } else if (str.equals("http://tieba.baidu.com/account/access/valid_success")) {
            bGl();
            return true;
        } else if (str.equals("http://tieba.baidu.com/account/access/feedback") || str.equals("https://tieba.baidu.com/account/access/feedback")) {
            this.hoa.getContext().finish();
            ay.zG().c(this.hoa.getContext().getPageContext(), new String[]{"feedback:"});
            return true;
        } else {
            return true;
        }
    }

    public void bGk() {
        if (this.hoa != null) {
            this.hoa.showWebViewDelay(500);
        }
    }

    public void start(String str) {
        if (this.hoa != null) {
            this.hoa.showWebLoadingView(true);
            this.hoa.showWebView(false);
            this.hoa.getWebView().loadUrl(str);
        }
    }

    public void onPostThreadCancle() {
        if (this.hoa != null) {
            this.hoa.showPostThreadLoadingView(false);
        }
    }

    private void bGl() {
        this.hoe = false;
        if (this.hoa != null && this.hod != null) {
            if (!l.jU()) {
                this.hoa.getContext().showToast(d.k.neterror);
                this.hoa.getContext().finish();
                return;
            }
            this.hoa.showPostThreadLoadingView(true);
            this.hod.startPostWrite();
        }
    }
}
