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
    private final b gzH;
    private final NewWriteModel gzK;
    private boolean gzL = false;
    private final NewWriteModel.d aEl = new NewWriteModel.d() { // from class: com.baidu.tieba.write.accountAccess.a.1
        @Override // com.baidu.tieba.tbadkCore.writeModel.NewWriteModel.d
        public void callback(boolean z, PostWriteCallBackData postWriteCallBackData, q qVar, WriteData writeData, AntiData antiData) {
            if (a.this.gzH != null && a.this.gzK != null && a.this.gzK.getWriteData() != null) {
                a.this.gzH.showPostThreadLoadingView(false);
                WriteData writeData2 = writeData == null ? a.this.gzK.getWriteData() : writeData;
                if (z) {
                    a.this.gzL = true;
                    if (writeData2.getIsStory() != 1 && (writeData2.getType() != 0 || writeData2.isUserFeedback())) {
                        if (postWriteCallBackData == null) {
                            c.c(a.this.gzH.getContext().getActivity(), a.this.gzH.getContext().getResources().getString(d.l.send_success), null, null);
                        } else {
                            c.c(a.this.gzH.getContext().getActivity(), postWriteCallBackData.getErrorString(), postWriteCallBackData.getPreMsg(), postWriteCallBackData.getColorMsg());
                        }
                    }
                    Intent intent = new Intent();
                    Bundle bundle = new Bundle();
                    bundle.putSerializable(WriteActivityConfig.POST_WRITE_CALLBACK_DATA, postWriteCallBackData);
                    intent.putExtras(bundle);
                    BaseActivity context = a.this.gzH.getContext();
                    a.this.gzH.getContext();
                    context.setResult(-1, intent);
                    a.this.gzH.getContext().finish();
                } else if (writeData2 != null && qVar != null && !TextUtils.isEmpty(qVar.yx())) {
                    writeData2.setVcodeMD5(qVar.getVcode_md5());
                    writeData2.setVcodeUrl(qVar.getVcode_pic_url());
                    writeData2.setVcodeExtra(qVar.yy());
                    a.this.gzH.getContext().setVisible(false);
                    if (com.baidu.tbadk.q.a.gY(qVar.yx())) {
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new NewVcodeActivityConfig(a.this.gzH.getContext().getActivity(), 12006, writeData2, false, qVar.yx())));
                    } else {
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new VcodeActivityConfig(a.this.gzH.getContext().getActivity(), writeData2, 12006)));
                    }
                } else {
                    if (postWriteCallBackData != null) {
                        c.c(a.this.gzH.getContext().getActivity(), postWriteCallBackData.getErrorString(), postWriteCallBackData.getPreMsg(), postWriteCallBackData.getColorMsg());
                        BaseActivity context2 = a.this.gzH.getContext();
                        a.this.gzH.getContext();
                        context2.setResult(0, null);
                    }
                    a.this.gzH.getContext().finish();
                }
            }
        }
    };

    public a(b bVar, NewWriteModel newWriteModel) {
        this.gzH = bVar;
        this.gzK = newWriteModel;
        newWriteModel.b(this.aEl);
    }

    public boolean sQ(String str) {
        if (this.gzH == null || str == null) {
            return false;
        }
        if (str.equals("http://tieba.baidu.com/account/access/cancel")) {
            this.gzH.getContext().finish();
            return true;
        } else if (str.equals("http://tieba.baidu.com/account/access/input_focus")) {
            this.gzH.w(0, UtilHelper.getImmersiveStickyBarHeight(), 0, 0);
            if (this.gzH.bxL() != this.gzH.bx()) {
                this.gzH.setRatio(this.gzH.bxL());
                this.gzH.bxM();
            }
            this.gzH.getWebView().setVisibility(0);
            return true;
        } else if (str.equals("http://tieba.baidu.com/account/access/valid_success")) {
            bxJ();
            return true;
        } else if (str.equals("http://tieba.baidu.com/account/access/feedback") || str.equals("https://tieba.baidu.com/account/access/feedback")) {
            this.gzH.getContext().finish();
            at.wf().c(this.gzH.getContext().getPageContext(), new String[]{"feedback:"});
            return true;
        } else {
            return true;
        }
    }

    public void bxI() {
        if (this.gzH != null) {
            this.gzH.showWebViewDelay(500);
        }
    }

    public void start(String str) {
        if (this.gzH != null) {
            this.gzH.showWebLoadingView(true);
            this.gzH.showWebView(false);
            this.gzH.getWebView().loadUrl(str);
        }
    }

    public void onPostThreadCancle() {
        if (this.gzH != null) {
            this.gzH.showPostThreadLoadingView(false);
        }
    }

    private void bxJ() {
        this.gzL = false;
        if (this.gzH != null && this.gzK != null) {
            if (!k.hI()) {
                this.gzH.getContext().showToast(d.l.neterror);
                this.gzH.getContext().finish();
                return;
            }
            this.gzH.showPostThreadLoadingView(true);
            this.gzK.startPostWrite();
        }
    }

    public boolean bxK() {
        return this.gzL;
    }
}
