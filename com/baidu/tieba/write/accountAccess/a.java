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
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.av;
import com.baidu.tbadk.coreExtra.data.WriteData;
import com.baidu.tbadk.coreExtra.data.r;
import com.baidu.tieba.d;
import com.baidu.tieba.tbadkCore.writeModel.NewWriteModel;
import com.baidu.tieba.tbadkCore.writeModel.PostWriteCallBackData;
import com.baidu.tieba.tbadkCore.writeModel.c;
/* loaded from: classes2.dex */
public class a {
    private final b hbZ;
    private final NewWriteModel hcc;
    private boolean hcd = false;
    private final NewWriteModel.d aDN = new NewWriteModel.d() { // from class: com.baidu.tieba.write.accountAccess.a.1
        @Override // com.baidu.tieba.tbadkCore.writeModel.NewWriteModel.d
        public void callback(boolean z, PostWriteCallBackData postWriteCallBackData, r rVar, WriteData writeData, AntiData antiData) {
            if (a.this.hbZ != null && a.this.hcc != null && a.this.hcc.getWriteData() != null) {
                a.this.hbZ.showPostThreadLoadingView(false);
                WriteData writeData2 = writeData == null ? a.this.hcc.getWriteData() : writeData;
                if (z) {
                    a.this.hcd = true;
                    if (writeData2.getIsStory() != 1 && (writeData2.getType() != 0 || writeData2.isUserFeedback())) {
                        if (postWriteCallBackData == null) {
                            c.d(a.this.hbZ.getContext().getActivity(), a.this.hbZ.getContext().getResources().getString(d.j.send_success), null, null);
                        } else {
                            c.d(a.this.hbZ.getContext().getActivity(), postWriteCallBackData.getErrorString(), postWriteCallBackData.getPreMsg(), postWriteCallBackData.getColorMsg());
                        }
                    }
                    Intent intent = new Intent();
                    Bundle bundle = new Bundle();
                    bundle.putSerializable("post_write_callback_data", postWriteCallBackData);
                    intent.putExtras(bundle);
                    BaseActivity context = a.this.hbZ.getContext();
                    a.this.hbZ.getContext();
                    context.setResult(-1, intent);
                    a.this.hbZ.getContext().finish();
                } else if (writeData2 != null && rVar != null && !TextUtils.isEmpty(rVar.yi())) {
                    writeData2.setVcodeMD5(rVar.getVcode_md5());
                    writeData2.setVcodeUrl(rVar.getVcode_pic_url());
                    writeData2.setVcodeExtra(rVar.yj());
                    a.this.hbZ.getContext().setVisible(false);
                    if (com.baidu.tbadk.p.a.he(rVar.yi())) {
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new NewVcodeActivityConfig(a.this.hbZ.getContext().getActivity(), 12006, writeData2, false, rVar.yi())));
                    } else {
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new VcodeActivityConfig(a.this.hbZ.getContext().getActivity(), writeData2, 12006)));
                    }
                } else if (postWriteCallBackData != null && postWriteCallBackData.isSensitiveError()) {
                    Intent intent2 = new Intent();
                    Bundle bundle2 = new Bundle();
                    bundle2.putSerializable("post_write_callback_data", postWriteCallBackData);
                    intent2.putExtras(bundle2);
                    BaseActivity context2 = a.this.hbZ.getContext();
                    a.this.hbZ.getContext();
                    context2.setResult(0, intent2);
                    a.this.hbZ.getContext().finish();
                } else {
                    if (postWriteCallBackData != null) {
                        c.d(a.this.hbZ.getContext().getActivity(), postWriteCallBackData.getErrorString(), postWriteCallBackData.getPreMsg(), postWriteCallBackData.getColorMsg());
                        BaseActivity context3 = a.this.hbZ.getContext();
                        a.this.hbZ.getContext();
                        context3.setResult(0, null);
                    }
                    a.this.hbZ.getContext().finish();
                }
            }
        }
    };

    public a(b bVar, NewWriteModel newWriteModel) {
        this.hbZ = bVar;
        this.hcc = newWriteModel;
        newWriteModel.b(this.aDN);
    }

    public boolean uy(String str) {
        if (this.hbZ == null || str == null) {
            return false;
        }
        if (str.equals("http://tieba.baidu.com/account/access/cancel")) {
            this.hbZ.getContext().finish();
            return true;
        } else if (str.equals("http://tieba.baidu.com/account/access/input_focus")) {
            this.hbZ.A(0, UtilHelper.getImmersiveStickyBarHeight(), 0, 0);
            if (this.hbZ.bFh() != this.hbZ.bm()) {
                this.hbZ.setRatio(this.hbZ.bFh());
                this.hbZ.bFi();
            }
            this.hbZ.getWebView().setVisibility(0);
            return true;
        } else if (str.equals("http://tieba.baidu.com/account/access/valid_success")) {
            bFf();
            return true;
        } else if (str.equals("http://tieba.baidu.com/account/access/feedback") || str.equals("https://tieba.baidu.com/account/access/feedback")) {
            this.hbZ.getContext().finish();
            av.vL().c(this.hbZ.getContext().getPageContext(), new String[]{"feedback:"});
            return true;
        } else {
            return true;
        }
    }

    public void bFe() {
        if (this.hbZ != null) {
            this.hbZ.showWebViewDelay(500);
        }
    }

    public void start(String str) {
        if (this.hbZ != null) {
            this.hbZ.showWebLoadingView(true);
            this.hbZ.showWebView(false);
            this.hbZ.getWebView().loadUrl(str);
        }
    }

    public void onPostThreadCancle() {
        if (this.hbZ != null) {
            this.hbZ.showPostThreadLoadingView(false);
        }
    }

    private void bFf() {
        this.hcd = false;
        if (this.hbZ != null && this.hcc != null) {
            if (!l.hy()) {
                this.hbZ.getContext().showToast(d.j.neterror);
                this.hbZ.getContext().finish();
                return;
            }
            this.hbZ.showPostThreadLoadingView(true);
            this.hcc.startPostWrite();
        }
    }

    public boolean bFg() {
        return this.hcd;
    }
}
