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
import com.baidu.tbadk.core.util.bb;
import com.baidu.tbadk.coreExtra.data.WriteData;
import com.baidu.tbadk.coreExtra.data.x;
import com.baidu.tieba.R;
import com.baidu.tieba.tbadkCore.writeModel.NewWriteModel;
import com.baidu.tieba.tbadkCore.writeModel.PostWriteCallBackData;
import com.baidu.tieba.tbadkCore.writeModel.c;
/* loaded from: classes3.dex */
public class a {
    private final b jNG;
    private final NewWriteModel jNJ;
    private boolean jNK = false;
    private final NewWriteModel.d ctY = new NewWriteModel.d() { // from class: com.baidu.tieba.write.accountAccess.a.1
        @Override // com.baidu.tieba.tbadkCore.writeModel.NewWriteModel.d
        public void callback(boolean z, PostWriteCallBackData postWriteCallBackData, x xVar, WriteData writeData, AntiData antiData) {
            if (a.this.jNG != null && a.this.jNJ != null && a.this.jNJ.getWriteData() != null) {
                a.this.jNG.showPostThreadLoadingView(false);
                WriteData writeData2 = writeData == null ? a.this.jNJ.getWriteData() : writeData;
                if (z) {
                    a.this.jNK = true;
                    if (writeData2.getType() != 0 || writeData2.isUserFeedback()) {
                        if (postWriteCallBackData == null) {
                            c.f(a.this.jNG.getContext().getActivity(), a.this.jNG.getContext().getResources().getString(R.string.send_success), null, null);
                        } else {
                            c.f(a.this.jNG.getContext().getActivity(), postWriteCallBackData.getErrorString(), postWriteCallBackData.getPreMsg(), postWriteCallBackData.getColorMsg());
                        }
                    }
                    Intent intent = new Intent();
                    Bundle bundle = new Bundle();
                    bundle.putSerializable("post_write_callback_data", postWriteCallBackData);
                    intent.putExtras(bundle);
                    BaseActivity context = a.this.jNG.getContext();
                    a.this.jNG.getContext();
                    context.setResult(-1, intent);
                    a.this.jNG.getContext().finish();
                } else if (writeData2 != null && xVar != null && !TextUtils.isEmpty(xVar.amG())) {
                    writeData2.setVcodeMD5(xVar.getVcode_md5());
                    writeData2.setVcodeUrl(xVar.getVcode_pic_url());
                    writeData2.setVcodeExtra(xVar.amH());
                    a.this.jNG.getContext().setVisible(false);
                    if (com.baidu.tbadk.v.a.ru(xVar.amG())) {
                        MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new NewVcodeActivityConfig(a.this.jNG.getContext().getActivity(), 12006, writeData2, false, xVar.amG())));
                    } else {
                        MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new VcodeActivityConfig(a.this.jNG.getContext().getActivity(), writeData2, 12006)));
                    }
                } else if (postWriteCallBackData != null && postWriteCallBackData.isSensitiveError()) {
                    Intent intent2 = new Intent();
                    Bundle bundle2 = new Bundle();
                    bundle2.putSerializable("post_write_callback_data", postWriteCallBackData);
                    intent2.putExtras(bundle2);
                    BaseActivity context2 = a.this.jNG.getContext();
                    a.this.jNG.getContext();
                    context2.setResult(0, intent2);
                    a.this.jNG.getContext().finish();
                } else {
                    if (postWriteCallBackData != null) {
                        c.f(a.this.jNG.getContext().getActivity(), postWriteCallBackData.getErrorString(), postWriteCallBackData.getPreMsg(), postWriteCallBackData.getColorMsg());
                        BaseActivity context3 = a.this.jNG.getContext();
                        a.this.jNG.getContext();
                        context3.setResult(0, null);
                    }
                    a.this.jNG.getContext().finish();
                }
            }
        }
    };

    public a(b bVar, NewWriteModel newWriteModel) {
        this.jNG = bVar;
        this.jNJ = newWriteModel;
        newWriteModel.b(this.ctY);
    }

    public boolean GF(String str) {
        if (this.jNG == null || str == null) {
            return false;
        }
        if (str.equals("http://tieba.baidu.com/account/access/cancel")) {
            this.jNG.getContext().finish();
            return true;
        } else if (str.equals("http://tieba.baidu.com/account/access/input_focus")) {
            this.jNG.E(0, UtilHelper.getImmersiveStickyBarHeight(), 0, 0);
            if (this.jNG.cAb() != this.jNG.ef()) {
                this.jNG.setRatio(this.jNG.cAb());
                this.jNG.cAc();
            }
            this.jNG.getWebView().setVisibility(0);
            return true;
        } else if (str.equals("http://tieba.baidu.com/account/access/valid_success")) {
            cAa();
            return true;
        } else if (str.equals("http://tieba.baidu.com/account/access/feedback") || str.equals("https://tieba.baidu.com/account/access/feedback")) {
            this.jNG.getContext().finish();
            bb.ajE().c(this.jNG.getContext().getPageContext(), new String[]{"feedback:"});
            return true;
        } else {
            return true;
        }
    }

    public void czZ() {
        if (this.jNG != null) {
            this.jNG.showWebViewDelay(500);
        }
    }

    public void U(String str) {
        if (this.jNG != null) {
            this.jNG.showWebLoadingView(true);
            this.jNG.showWebView(false);
            this.jNG.getWebView().loadUrl(str);
        }
    }

    public void onPostThreadCancle() {
        if (this.jNG != null) {
            this.jNG.showPostThreadLoadingView(false);
        }
    }

    private void cAa() {
        this.jNK = false;
        if (this.jNG != null && this.jNJ != null) {
            if (!l.kt()) {
                this.jNG.getContext().showToast(R.string.neterror);
                this.jNG.getContext().finish();
                return;
            }
            this.jNG.showPostThreadLoadingView(true);
            this.jNJ.startPostWrite();
        }
    }
}
