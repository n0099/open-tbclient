package com.baidu.tieba.write.accountAccess;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.lib.util.l;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.core.atomData.NewVcodeActivityConfig;
import com.baidu.tbadk.core.atomData.VcodeActivityConfig;
import com.baidu.tbadk.core.data.AntiData;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.ba;
import com.baidu.tbadk.coreExtra.data.WriteData;
import com.baidu.tbadk.coreExtra.data.y;
import com.baidu.tieba.R;
import com.baidu.tieba.tbadkCore.writeModel.NewWriteModel;
import com.baidu.tieba.tbadkCore.writeModel.PostWriteCallBackData;
import com.baidu.tieba.tbadkCore.writeModel.c;
/* loaded from: classes3.dex */
public class a {
    private final b jQb;
    private final NewWriteModel jQe;
    private boolean jQf = false;
    private final NewWriteModel.d cuV = new NewWriteModel.d() { // from class: com.baidu.tieba.write.accountAccess.a.1
        @Override // com.baidu.tieba.tbadkCore.writeModel.NewWriteModel.d
        public void callback(boolean z, PostWriteCallBackData postWriteCallBackData, y yVar, WriteData writeData, AntiData antiData) {
            if (a.this.jQb != null && a.this.jQe != null && a.this.jQe.getWriteData() != null) {
                a.this.jQb.showPostThreadLoadingView(false);
                WriteData writeData2 = writeData == null ? a.this.jQe.getWriteData() : writeData;
                if (z) {
                    a.this.jQf = true;
                    if (writeData2.getType() != 0 || writeData2.isUserFeedback()) {
                        if (postWriteCallBackData == null) {
                            c.f(a.this.jQb.getContext().getActivity(), a.this.jQb.getContext().getResources().getString(R.string.send_success), null, null);
                        } else {
                            c.f(a.this.jQb.getContext().getActivity(), postWriteCallBackData.getErrorString(), postWriteCallBackData.getPreMsg(), postWriteCallBackData.getColorMsg());
                        }
                    }
                    Intent intent = new Intent();
                    Bundle bundle = new Bundle();
                    bundle.putSerializable("post_write_callback_data", postWriteCallBackData);
                    intent.putExtras(bundle);
                    BaseActivity context = a.this.jQb.getContext();
                    a.this.jQb.getContext();
                    context.setResult(-1, intent);
                    a.this.jQb.getContext().finish();
                } else if (writeData2 != null && yVar != null && !TextUtils.isEmpty(yVar.amS())) {
                    writeData2.setVcodeMD5(yVar.getVcode_md5());
                    writeData2.setVcodeUrl(yVar.getVcode_pic_url());
                    writeData2.setVcodeExtra(yVar.amT());
                    a.this.jQb.getContext().setVisible(false);
                    if (com.baidu.tbadk.v.a.rF(yVar.amS())) {
                        MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new NewVcodeActivityConfig(a.this.jQb.getContext().getActivity(), 12006, writeData2, false, yVar.amS())));
                    } else {
                        MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new VcodeActivityConfig(a.this.jQb.getContext().getActivity(), writeData2, 12006)));
                    }
                } else if (postWriteCallBackData != null && postWriteCallBackData.isSensitiveError()) {
                    Intent intent2 = new Intent();
                    Bundle bundle2 = new Bundle();
                    bundle2.putSerializable("post_write_callback_data", postWriteCallBackData);
                    intent2.putExtras(bundle2);
                    BaseActivity context2 = a.this.jQb.getContext();
                    a.this.jQb.getContext();
                    context2.setResult(0, intent2);
                    a.this.jQb.getContext().finish();
                } else {
                    if (postWriteCallBackData != null) {
                        c.f(a.this.jQb.getContext().getActivity(), postWriteCallBackData.getErrorString(), postWriteCallBackData.getPreMsg(), postWriteCallBackData.getColorMsg());
                        BaseActivity context3 = a.this.jQb.getContext();
                        a.this.jQb.getContext();
                        context3.setResult(0, null);
                    }
                    a.this.jQb.getContext().finish();
                }
            }
        }
    };

    public a(b bVar, NewWriteModel newWriteModel) {
        this.jQb = bVar;
        this.jQe = newWriteModel;
        newWriteModel.b(this.cuV);
    }

    public boolean Hf(String str) {
        if (this.jQb == null || str == null) {
            return false;
        }
        if (str.equals("http://tieba.baidu.com/account/access/cancel")) {
            this.jQb.getContext().finish();
            return true;
        } else if (str.equals("http://tieba.baidu.com/account/access/input_focus")) {
            this.jQb.H(0, UtilHelper.getImmersiveStickyBarHeight(), 0, 0);
            if (this.jQb.cAP() != this.jQb.ef()) {
                this.jQb.setRatio(this.jQb.cAP());
                this.jQb.cAQ();
            }
            this.jQb.getWebView().setVisibility(0);
            return true;
        } else if (str.equals("http://tieba.baidu.com/account/access/valid_success")) {
            cAO();
            return true;
        } else if (str.equals("http://tieba.baidu.com/account/access/feedback") || str.equals("https://tieba.baidu.com/account/access/feedback")) {
            this.jQb.getContext().finish();
            ba.ajK().c(this.jQb.getContext().getPageContext(), new String[]{"feedback:"});
            return true;
        } else {
            return true;
        }
    }

    public void cAN() {
        if (this.jQb != null) {
            this.jQb.showWebViewDelay(500);
        }
    }

    public void U(String str) {
        if (this.jQb != null) {
            this.jQb.showWebLoadingView(true);
            this.jQb.showWebView(false);
            this.jQb.getWebView().loadUrl(str);
        }
    }

    public void onPostThreadCancle() {
        if (this.jQb != null) {
            this.jQb.showPostThreadLoadingView(false);
        }
    }

    private void cAO() {
        this.jQf = false;
        if (this.jQb != null && this.jQe != null) {
            if (!l.kt()) {
                this.jQb.getContext().showToast(R.string.neterror);
                this.jQb.getContext().finish();
                return;
            }
            this.jQb.showPostThreadLoadingView(true);
            this.jQe.startPostWrite();
        }
    }
}
