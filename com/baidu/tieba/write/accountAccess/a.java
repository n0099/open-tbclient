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
    private final NewWriteModel jMC;
    private final b jMz;
    private boolean jMD = false;
    private final NewWriteModel.d ctR = new NewWriteModel.d() { // from class: com.baidu.tieba.write.accountAccess.a.1
        @Override // com.baidu.tieba.tbadkCore.writeModel.NewWriteModel.d
        public void callback(boolean z, PostWriteCallBackData postWriteCallBackData, x xVar, WriteData writeData, AntiData antiData) {
            if (a.this.jMz != null && a.this.jMC != null && a.this.jMC.getWriteData() != null) {
                a.this.jMz.showPostThreadLoadingView(false);
                WriteData writeData2 = writeData == null ? a.this.jMC.getWriteData() : writeData;
                if (z) {
                    a.this.jMD = true;
                    if (writeData2.getType() != 0 || writeData2.isUserFeedback()) {
                        if (postWriteCallBackData == null) {
                            c.f(a.this.jMz.getContext().getActivity(), a.this.jMz.getContext().getResources().getString(R.string.send_success), null, null);
                        } else {
                            c.f(a.this.jMz.getContext().getActivity(), postWriteCallBackData.getErrorString(), postWriteCallBackData.getPreMsg(), postWriteCallBackData.getColorMsg());
                        }
                    }
                    Intent intent = new Intent();
                    Bundle bundle = new Bundle();
                    bundle.putSerializable("post_write_callback_data", postWriteCallBackData);
                    intent.putExtras(bundle);
                    BaseActivity context = a.this.jMz.getContext();
                    a.this.jMz.getContext();
                    context.setResult(-1, intent);
                    a.this.jMz.getContext().finish();
                } else if (writeData2 != null && xVar != null && !TextUtils.isEmpty(xVar.amE())) {
                    writeData2.setVcodeMD5(xVar.getVcode_md5());
                    writeData2.setVcodeUrl(xVar.getVcode_pic_url());
                    writeData2.setVcodeExtra(xVar.amF());
                    a.this.jMz.getContext().setVisible(false);
                    if (com.baidu.tbadk.v.a.ru(xVar.amE())) {
                        MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new NewVcodeActivityConfig(a.this.jMz.getContext().getActivity(), 12006, writeData2, false, xVar.amE())));
                    } else {
                        MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new VcodeActivityConfig(a.this.jMz.getContext().getActivity(), writeData2, 12006)));
                    }
                } else if (postWriteCallBackData != null && postWriteCallBackData.isSensitiveError()) {
                    Intent intent2 = new Intent();
                    Bundle bundle2 = new Bundle();
                    bundle2.putSerializable("post_write_callback_data", postWriteCallBackData);
                    intent2.putExtras(bundle2);
                    BaseActivity context2 = a.this.jMz.getContext();
                    a.this.jMz.getContext();
                    context2.setResult(0, intent2);
                    a.this.jMz.getContext().finish();
                } else {
                    if (postWriteCallBackData != null) {
                        c.f(a.this.jMz.getContext().getActivity(), postWriteCallBackData.getErrorString(), postWriteCallBackData.getPreMsg(), postWriteCallBackData.getColorMsg());
                        BaseActivity context3 = a.this.jMz.getContext();
                        a.this.jMz.getContext();
                        context3.setResult(0, null);
                    }
                    a.this.jMz.getContext().finish();
                }
            }
        }
    };

    public a(b bVar, NewWriteModel newWriteModel) {
        this.jMz = bVar;
        this.jMC = newWriteModel;
        newWriteModel.b(this.ctR);
    }

    public boolean GE(String str) {
        if (this.jMz == null || str == null) {
            return false;
        }
        if (str.equals("http://tieba.baidu.com/account/access/cancel")) {
            this.jMz.getContext().finish();
            return true;
        } else if (str.equals("http://tieba.baidu.com/account/access/input_focus")) {
            this.jMz.E(0, UtilHelper.getImmersiveStickyBarHeight(), 0, 0);
            if (this.jMz.czG() != this.jMz.ef()) {
                this.jMz.setRatio(this.jMz.czG());
                this.jMz.czH();
            }
            this.jMz.getWebView().setVisibility(0);
            return true;
        } else if (str.equals("http://tieba.baidu.com/account/access/valid_success")) {
            czF();
            return true;
        } else if (str.equals("http://tieba.baidu.com/account/access/feedback") || str.equals("https://tieba.baidu.com/account/access/feedback")) {
            this.jMz.getContext().finish();
            bb.ajC().c(this.jMz.getContext().getPageContext(), new String[]{"feedback:"});
            return true;
        } else {
            return true;
        }
    }

    public void czE() {
        if (this.jMz != null) {
            this.jMz.showWebViewDelay(500);
        }
    }

    public void U(String str) {
        if (this.jMz != null) {
            this.jMz.showWebLoadingView(true);
            this.jMz.showWebView(false);
            this.jMz.getWebView().loadUrl(str);
        }
    }

    public void onPostThreadCancle() {
        if (this.jMz != null) {
            this.jMz.showPostThreadLoadingView(false);
        }
    }

    private void czF() {
        this.jMD = false;
        if (this.jMz != null && this.jMC != null) {
            if (!l.kt()) {
                this.jMz.getContext().showToast(R.string.neterror);
                this.jMz.getContext().finish();
                return;
            }
            this.jMz.showPostThreadLoadingView(true);
            this.jMC.startPostWrite();
        }
    }
}
