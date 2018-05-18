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
import com.baidu.tbadk.core.util.ax;
import com.baidu.tbadk.coreExtra.data.WriteData;
import com.baidu.tbadk.coreExtra.data.t;
import com.baidu.tieba.d;
import com.baidu.tieba.tbadkCore.writeModel.NewWriteModel;
import com.baidu.tieba.tbadkCore.writeModel.PostWriteCallBackData;
import com.baidu.tieba.tbadkCore.writeModel.c;
/* loaded from: classes3.dex */
public class a {
    private final b hcf;
    private final NewWriteModel hci;
    private boolean hcj = false;
    private final NewWriteModel.d aEL = new NewWriteModel.d() { // from class: com.baidu.tieba.write.accountAccess.a.1
        @Override // com.baidu.tieba.tbadkCore.writeModel.NewWriteModel.d
        public void callback(boolean z, PostWriteCallBackData postWriteCallBackData, t tVar, WriteData writeData, AntiData antiData) {
            if (a.this.hcf != null && a.this.hci != null && a.this.hci.getWriteData() != null) {
                a.this.hcf.showPostThreadLoadingView(false);
                WriteData writeData2 = writeData == null ? a.this.hci.getWriteData() : writeData;
                if (z) {
                    a.this.hcj = true;
                    if (writeData2.getType() != 0 || writeData2.isUserFeedback()) {
                        if (postWriteCallBackData == null) {
                            c.e(a.this.hcf.getContext().getActivity(), a.this.hcf.getContext().getResources().getString(d.k.send_success), null, null);
                        } else {
                            c.e(a.this.hcf.getContext().getActivity(), postWriteCallBackData.getErrorString(), postWriteCallBackData.getPreMsg(), postWriteCallBackData.getColorMsg());
                        }
                    }
                    Intent intent = new Intent();
                    Bundle bundle = new Bundle();
                    bundle.putSerializable("post_write_callback_data", postWriteCallBackData);
                    intent.putExtras(bundle);
                    BaseActivity context = a.this.hcf.getContext();
                    a.this.hcf.getContext();
                    context.setResult(-1, intent);
                    a.this.hcf.getContext().finish();
                } else if (writeData2 != null && tVar != null && !TextUtils.isEmpty(tVar.yJ())) {
                    writeData2.setVcodeMD5(tVar.getVcode_md5());
                    writeData2.setVcodeUrl(tVar.getVcode_pic_url());
                    writeData2.setVcodeExtra(tVar.yK());
                    a.this.hcf.getContext().setVisible(false);
                    if (com.baidu.tbadk.p.a.hr(tVar.yJ())) {
                        MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new NewVcodeActivityConfig(a.this.hcf.getContext().getActivity(), IEventCenterService.EventId.EventMode.SAPIACCOUNT_FACE_REG, writeData2, false, tVar.yJ())));
                    } else {
                        MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new VcodeActivityConfig(a.this.hcf.getContext().getActivity(), writeData2, IEventCenterService.EventId.EventMode.SAPIACCOUNT_FACE_REG)));
                    }
                } else if (postWriteCallBackData != null && postWriteCallBackData.isSensitiveError()) {
                    Intent intent2 = new Intent();
                    Bundle bundle2 = new Bundle();
                    bundle2.putSerializable("post_write_callback_data", postWriteCallBackData);
                    intent2.putExtras(bundle2);
                    BaseActivity context2 = a.this.hcf.getContext();
                    a.this.hcf.getContext();
                    context2.setResult(0, intent2);
                    a.this.hcf.getContext().finish();
                } else {
                    if (postWriteCallBackData != null) {
                        c.e(a.this.hcf.getContext().getActivity(), postWriteCallBackData.getErrorString(), postWriteCallBackData.getPreMsg(), postWriteCallBackData.getColorMsg());
                        BaseActivity context3 = a.this.hcf.getContext();
                        a.this.hcf.getContext();
                        context3.setResult(0, null);
                    }
                    a.this.hcf.getContext().finish();
                }
            }
        }
    };

    public a(b bVar, NewWriteModel newWriteModel) {
        this.hcf = bVar;
        this.hci = newWriteModel;
        newWriteModel.b(this.aEL);
    }

    public boolean uI(String str) {
        if (this.hcf == null || str == null) {
            return false;
        }
        if (str.equals("http://tieba.baidu.com/account/access/cancel")) {
            this.hcf.getContext().finish();
            return true;
        } else if (str.equals("http://tieba.baidu.com/account/access/input_focus")) {
            this.hcf.A(0, UtilHelper.getImmersiveStickyBarHeight(), 0, 0);
            if (this.hcf.bBg() != this.hcf.aV()) {
                this.hcf.setRatio(this.hcf.bBg());
                this.hcf.bBh();
            }
            this.hcf.getWebView().setVisibility(0);
            return true;
        } else if (str.equals("http://tieba.baidu.com/account/access/valid_success")) {
            bBf();
            return true;
        } else if (str.equals("http://tieba.baidu.com/account/access/feedback") || str.equals("https://tieba.baidu.com/account/access/feedback")) {
            this.hcf.getContext().finish();
            ax.wf().c(this.hcf.getContext().getPageContext(), new String[]{"feedback:"});
            return true;
        } else {
            return true;
        }
    }

    public void bBe() {
        if (this.hcf != null) {
            this.hcf.showWebViewDelay(500);
        }
    }

    public void start(String str) {
        if (this.hcf != null) {
            this.hcf.showWebLoadingView(true);
            this.hcf.showWebView(false);
            this.hcf.getWebView().loadUrl(str);
        }
    }

    public void onPostThreadCancle() {
        if (this.hcf != null) {
            this.hcf.showPostThreadLoadingView(false);
        }
    }

    private void bBf() {
        this.hcj = false;
        if (this.hcf != null && this.hci != null) {
            if (!l.hg()) {
                this.hcf.getContext().showToast(d.k.neterror);
                this.hcf.getContext().finish();
                return;
            }
            this.hcf.showPostThreadLoadingView(true);
            this.hci.startPostWrite();
        }
    }
}
