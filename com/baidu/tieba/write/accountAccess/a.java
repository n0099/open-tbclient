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
    private final b gyw;
    private final NewWriteModel gyz;
    private boolean gyA = false;
    private final NewWriteModel.d aCV = new NewWriteModel.d() { // from class: com.baidu.tieba.write.accountAccess.a.1
        @Override // com.baidu.tieba.tbadkCore.writeModel.NewWriteModel.d
        public void callback(boolean z, PostWriteCallBackData postWriteCallBackData, q qVar, WriteData writeData, AntiData antiData) {
            if (a.this.gyw != null && a.this.gyz != null && a.this.gyz.getWriteData() != null) {
                a.this.gyw.showPostThreadLoadingView(false);
                WriteData writeData2 = writeData == null ? a.this.gyz.getWriteData() : writeData;
                if (z) {
                    a.this.gyA = true;
                    if (writeData2.getIsStory() != 1 && (writeData2.getType() != 0 || writeData2.isUserFeedback())) {
                        if (postWriteCallBackData == null) {
                            c.c(a.this.gyw.getContext().getActivity(), a.this.gyw.getContext().getResources().getString(d.l.send_success), null, null);
                        } else {
                            c.c(a.this.gyw.getContext().getActivity(), postWriteCallBackData.getErrorString(), postWriteCallBackData.getPreMsg(), postWriteCallBackData.getColorMsg());
                        }
                    }
                    Intent intent = new Intent();
                    Bundle bundle = new Bundle();
                    bundle.putSerializable(WriteActivityConfig.POST_WRITE_CALLBACK_DATA, postWriteCallBackData);
                    intent.putExtras(bundle);
                    BaseActivity context = a.this.gyw.getContext();
                    a.this.gyw.getContext();
                    context.setResult(-1, intent);
                    a.this.gyw.getContext().finish();
                } else if (writeData2 != null && qVar != null && !TextUtils.isEmpty(qVar.yp())) {
                    writeData2.setVcodeMD5(qVar.getVcode_md5());
                    writeData2.setVcodeUrl(qVar.getVcode_pic_url());
                    writeData2.setVcodeExtra(qVar.yq());
                    a.this.gyw.getContext().setVisible(false);
                    if (com.baidu.tbadk.q.a.gT(qVar.yp())) {
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new NewVcodeActivityConfig(a.this.gyw.getContext().getActivity(), 12006, writeData2, false, qVar.yp())));
                    } else {
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new VcodeActivityConfig(a.this.gyw.getContext().getActivity(), writeData2, 12006)));
                    }
                } else {
                    if (postWriteCallBackData != null) {
                        c.c(a.this.gyw.getContext().getActivity(), postWriteCallBackData.getErrorString(), postWriteCallBackData.getPreMsg(), postWriteCallBackData.getColorMsg());
                        BaseActivity context2 = a.this.gyw.getContext();
                        a.this.gyw.getContext();
                        context2.setResult(0, null);
                    }
                    a.this.gyw.getContext().finish();
                }
            }
        }
    };

    public a(b bVar, NewWriteModel newWriteModel) {
        this.gyw = bVar;
        this.gyz = newWriteModel;
        newWriteModel.b(this.aCV);
    }

    public boolean sL(String str) {
        if (this.gyw == null || str == null) {
            return false;
        }
        if (str.equals("http://tieba.baidu.com/account/access/cancel")) {
            this.gyw.getContext().finish();
            return true;
        } else if (str.equals("http://tieba.baidu.com/account/access/input_focus")) {
            this.gyw.w(0, UtilHelper.getImmersiveStickyBarHeight(), 0, 0);
            if (this.gyw.bxE() != this.gyw.bm()) {
                this.gyw.setRatio(this.gyw.bxE());
                this.gyw.bxF();
            }
            this.gyw.getWebView().setVisibility(0);
            return true;
        } else if (str.equals("http://tieba.baidu.com/account/access/valid_success")) {
            bxC();
            return true;
        } else if (str.equals("http://tieba.baidu.com/account/access/feedback") || str.equals("https://tieba.baidu.com/account/access/feedback")) {
            this.gyw.getContext().finish();
            at.vV().c(this.gyw.getContext().getPageContext(), new String[]{"feedback:"});
            return true;
        } else {
            return true;
        }
    }

    public void bxB() {
        if (this.gyw != null) {
            this.gyw.showWebViewDelay(500);
        }
    }

    public void start(String str) {
        if (this.gyw != null) {
            this.gyw.showWebLoadingView(true);
            this.gyw.showWebView(false);
            this.gyw.getWebView().loadUrl(str);
        }
    }

    public void onPostThreadCancle() {
        if (this.gyw != null) {
            this.gyw.showPostThreadLoadingView(false);
        }
    }

    private void bxC() {
        this.gyA = false;
        if (this.gyw != null && this.gyz != null) {
            if (!k.hy()) {
                this.gyw.getContext().showToast(d.l.neterror);
                this.gyw.getContext().finish();
                return;
            }
            this.gyw.showPostThreadLoadingView(true);
            this.gyz.startPostWrite();
        }
    }

    public boolean bxD() {
        return this.gyA;
    }
}
