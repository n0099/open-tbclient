package com.baidu.tieba.write.accountAccess;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.lib.util.k;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.core.atomData.NewVcodeActivityConfig;
import com.baidu.tbadk.core.atomData.VcodeActivityConfig;
import com.baidu.tbadk.core.atomData.WriteActivityConfig;
import com.baidu.tbadk.core.data.AntiData;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.au;
import com.baidu.tbadk.coreExtra.data.WriteData;
import com.baidu.tbadk.coreExtra.data.q;
import com.baidu.tieba.d;
import com.baidu.tieba.tbadkCore.writeModel.NewWriteModel;
import com.baidu.tieba.tbadkCore.writeModel.PostWriteCallBackData;
import com.baidu.tieba.tbadkCore.writeModel.c;
/* loaded from: classes2.dex */
public class a {
    private final b gAn;
    private final NewWriteModel gAq;
    private boolean gAr = false;
    private final NewWriteModel.d aDE = new NewWriteModel.d() { // from class: com.baidu.tieba.write.accountAccess.a.1
        @Override // com.baidu.tieba.tbadkCore.writeModel.NewWriteModel.d
        public void callback(boolean z, PostWriteCallBackData postWriteCallBackData, q qVar, WriteData writeData, AntiData antiData) {
            if (a.this.gAn != null && a.this.gAq != null && a.this.gAq.getWriteData() != null) {
                a.this.gAn.showPostThreadLoadingView(false);
                WriteData writeData2 = writeData == null ? a.this.gAq.getWriteData() : writeData;
                if (z) {
                    a.this.gAr = true;
                    if (writeData2.getIsStory() != 1 && (writeData2.getType() != 0 || writeData2.isUserFeedback())) {
                        if (postWriteCallBackData == null) {
                            c.c(a.this.gAn.getContext().getActivity(), a.this.gAn.getContext().getResources().getString(d.l.send_success), null, null);
                        } else {
                            c.c(a.this.gAn.getContext().getActivity(), postWriteCallBackData.getErrorString(), postWriteCallBackData.getPreMsg(), postWriteCallBackData.getColorMsg());
                        }
                    }
                    Intent intent = new Intent();
                    Bundle bundle = new Bundle();
                    bundle.putSerializable(WriteActivityConfig.POST_WRITE_CALLBACK_DATA, postWriteCallBackData);
                    intent.putExtras(bundle);
                    BaseActivity context = a.this.gAn.getContext();
                    a.this.gAn.getContext();
                    context.setResult(-1, intent);
                    a.this.gAn.getContext().finish();
                } else if (writeData2 != null && qVar != null && !TextUtils.isEmpty(qVar.yA())) {
                    writeData2.setVcodeMD5(qVar.getVcode_md5());
                    writeData2.setVcodeUrl(qVar.getVcode_pic_url());
                    writeData2.setVcodeExtra(qVar.yB());
                    a.this.gAn.getContext().setVisible(false);
                    if (com.baidu.tbadk.q.a.gX(qVar.yA())) {
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new NewVcodeActivityConfig(a.this.gAn.getContext().getActivity(), 12006, writeData2, false, qVar.yA())));
                    } else {
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new VcodeActivityConfig(a.this.gAn.getContext().getActivity(), writeData2, 12006)));
                    }
                } else {
                    if (postWriteCallBackData != null) {
                        c.c(a.this.gAn.getContext().getActivity(), postWriteCallBackData.getErrorString(), postWriteCallBackData.getPreMsg(), postWriteCallBackData.getColorMsg());
                        BaseActivity context2 = a.this.gAn.getContext();
                        a.this.gAn.getContext();
                        context2.setResult(0, null);
                    }
                    a.this.gAn.getContext().finish();
                }
            }
        }
    };

    public a(b bVar, NewWriteModel newWriteModel) {
        this.gAn = bVar;
        this.gAq = newWriteModel;
        newWriteModel.b(this.aDE);
    }

    public boolean sS(String str) {
        if (this.gAn == null || str == null) {
            return false;
        }
        if (str.equals("http://tieba.baidu.com/account/access/cancel")) {
            this.gAn.getContext().finish();
            return true;
        } else if (str.equals("http://tieba.baidu.com/account/access/input_focus")) {
            this.gAn.u(0, UtilHelper.getImmersiveStickyBarHeight(), 0, 0);
            if (this.gAn.bxC() != this.gAn.bm()) {
                this.gAn.setRatio(this.gAn.bxC());
                this.gAn.bxD();
            }
            this.gAn.getWebView().setVisibility(0);
            return true;
        } else if (str.equals("http://tieba.baidu.com/account/access/valid_success")) {
            bxA();
            return true;
        } else if (str.equals("http://tieba.baidu.com/account/access/feedback") || str.equals("https://tieba.baidu.com/account/access/feedback")) {
            this.gAn.getContext().finish();
            au.wd().c(this.gAn.getContext().getPageContext(), new String[]{"feedback:"});
            return true;
        } else {
            return true;
        }
    }

    public void bxz() {
        if (this.gAn != null) {
            this.gAn.showWebViewDelay(500);
        }
    }

    public void start(String str) {
        if (this.gAn != null) {
            this.gAn.showWebLoadingView(true);
            this.gAn.showWebView(false);
            this.gAn.getWebView().loadUrl(str);
        }
    }

    public void onPostThreadCancle() {
        if (this.gAn != null) {
            this.gAn.showPostThreadLoadingView(false);
        }
    }

    private void bxA() {
        this.gAr = false;
        if (this.gAn != null && this.gAq != null) {
            if (!k.hz()) {
                this.gAn.getContext().showToast(d.l.neterror);
                this.gAn.getContext().finish();
                return;
            }
            this.gAn.showPostThreadLoadingView(true);
            this.gAq.startPostWrite();
        }
    }

    public boolean bxB() {
        return this.gAr;
    }
}
