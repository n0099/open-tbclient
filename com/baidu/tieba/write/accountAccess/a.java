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
import com.baidu.tbadk.core.util.at;
import com.baidu.tbadk.coreExtra.data.WriteData;
import com.baidu.tbadk.coreExtra.data.q;
import com.baidu.tieba.d;
import com.baidu.tieba.tbadkCore.writeModel.NewWriteModel;
import com.baidu.tieba.tbadkCore.writeModel.PostWriteCallBackData;
import com.baidu.tieba.tbadkCore.writeModel.c;
/* loaded from: classes.dex */
public class a {
    private final NewWriteModel gBC;
    private final b gBz;
    private boolean gBD = false;
    private final NewWriteModel.d aEn = new NewWriteModel.d() { // from class: com.baidu.tieba.write.accountAccess.a.1
        @Override // com.baidu.tieba.tbadkCore.writeModel.NewWriteModel.d
        public void callback(boolean z, PostWriteCallBackData postWriteCallBackData, q qVar, WriteData writeData, AntiData antiData) {
            if (a.this.gBz != null && a.this.gBC != null && a.this.gBC.getWriteData() != null) {
                a.this.gBz.showPostThreadLoadingView(false);
                WriteData writeData2 = writeData == null ? a.this.gBC.getWriteData() : writeData;
                if (z) {
                    a.this.gBD = true;
                    if (writeData2.getIsStory() != 1 && (writeData2.getType() != 0 || writeData2.isUserFeedback())) {
                        if (postWriteCallBackData == null) {
                            c.c(a.this.gBz.getContext().getActivity(), a.this.gBz.getContext().getResources().getString(d.l.send_success), null, null);
                        } else {
                            c.c(a.this.gBz.getContext().getActivity(), postWriteCallBackData.getErrorString(), postWriteCallBackData.getPreMsg(), postWriteCallBackData.getColorMsg());
                        }
                    }
                    Intent intent = new Intent();
                    Bundle bundle = new Bundle();
                    bundle.putSerializable(WriteActivityConfig.POST_WRITE_CALLBACK_DATA, postWriteCallBackData);
                    intent.putExtras(bundle);
                    BaseActivity context = a.this.gBz.getContext();
                    a.this.gBz.getContext();
                    context.setResult(-1, intent);
                    a.this.gBz.getContext().finish();
                } else if (writeData2 != null && qVar != null && !TextUtils.isEmpty(qVar.yx())) {
                    writeData2.setVcodeMD5(qVar.getVcode_md5());
                    writeData2.setVcodeUrl(qVar.getVcode_pic_url());
                    writeData2.setVcodeExtra(qVar.yy());
                    a.this.gBz.getContext().setVisible(false);
                    if (com.baidu.tbadk.q.a.hb(qVar.yx())) {
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new NewVcodeActivityConfig(a.this.gBz.getContext().getActivity(), 12006, writeData2, false, qVar.yx())));
                    } else {
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new VcodeActivityConfig(a.this.gBz.getContext().getActivity(), writeData2, 12006)));
                    }
                } else {
                    if (postWriteCallBackData != null) {
                        c.c(a.this.gBz.getContext().getActivity(), postWriteCallBackData.getErrorString(), postWriteCallBackData.getPreMsg(), postWriteCallBackData.getColorMsg());
                        BaseActivity context2 = a.this.gBz.getContext();
                        a.this.gBz.getContext();
                        context2.setResult(0, null);
                    }
                    a.this.gBz.getContext().finish();
                }
            }
        }
    };

    public a(b bVar, NewWriteModel newWriteModel) {
        this.gBz = bVar;
        this.gBC = newWriteModel;
        newWriteModel.b(this.aEn);
    }

    public boolean sX(String str) {
        if (this.gBz == null || str == null) {
            return false;
        }
        if (str.equals("http://tieba.baidu.com/account/access/cancel")) {
            this.gBz.getContext().finish();
            return true;
        } else if (str.equals("http://tieba.baidu.com/account/access/input_focus")) {
            this.gBz.x(0, UtilHelper.getImmersiveStickyBarHeight(), 0, 0);
            if (this.gBz.byl() != this.gBz.bx()) {
                this.gBz.setRatio(this.gBz.byl());
                this.gBz.bym();
            }
            this.gBz.getWebView().setVisibility(0);
            return true;
        } else if (str.equals("http://tieba.baidu.com/account/access/valid_success")) {
            byj();
            return true;
        } else if (str.equals("http://tieba.baidu.com/account/access/feedback") || str.equals("https://tieba.baidu.com/account/access/feedback")) {
            this.gBz.getContext().finish();
            at.wg().c(this.gBz.getContext().getPageContext(), new String[]{"feedback:"});
            return true;
        } else {
            return true;
        }
    }

    public void byi() {
        if (this.gBz != null) {
            this.gBz.showWebViewDelay(500);
        }
    }

    public void start(String str) {
        if (this.gBz != null) {
            this.gBz.showWebLoadingView(true);
            this.gBz.showWebView(false);
            this.gBz.getWebView().loadUrl(str);
        }
    }

    public void onPostThreadCancle() {
        if (this.gBz != null) {
            this.gBz.showPostThreadLoadingView(false);
        }
    }

    private void byj() {
        this.gBD = false;
        if (this.gBz != null && this.gBC != null) {
            if (!k.hI()) {
                this.gBz.getContext().showToast(d.l.neterror);
                this.gBz.getContext().finish();
                return;
            }
            this.gBz.showPostThreadLoadingView(true);
            this.gBC.startPostWrite();
        }
    }

    public boolean byk() {
        return this.gBD;
    }
}
