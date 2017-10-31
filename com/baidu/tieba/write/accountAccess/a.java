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
import com.baidu.tbadk.core.atomData.WriteActivityConfig;
import com.baidu.tbadk.core.data.AntiData;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.av;
import com.baidu.tbadk.coreExtra.data.WriteData;
import com.baidu.tbadk.coreExtra.data.q;
import com.baidu.tieba.d;
import com.baidu.tieba.tbadkCore.writeModel.NewWriteModel;
import com.baidu.tieba.tbadkCore.writeModel.PostWriteCallBackData;
import com.baidu.tieba.tbadkCore.writeModel.c;
/* loaded from: classes2.dex */
public class a {
    private final b gPW;
    private final NewWriteModel gPZ;
    private boolean gQa = false;
    private final NewWriteModel.d aDo = new NewWriteModel.d() { // from class: com.baidu.tieba.write.accountAccess.a.1
        @Override // com.baidu.tieba.tbadkCore.writeModel.NewWriteModel.d
        public void callback(boolean z, PostWriteCallBackData postWriteCallBackData, q qVar, WriteData writeData, AntiData antiData) {
            if (a.this.gPW != null && a.this.gPZ != null && a.this.gPZ.getWriteData() != null) {
                a.this.gPW.showPostThreadLoadingView(false);
                WriteData writeData2 = writeData == null ? a.this.gPZ.getWriteData() : writeData;
                if (z) {
                    a.this.gQa = true;
                    if (writeData2.getIsStory() != 1 && (writeData2.getType() != 0 || writeData2.isUserFeedback())) {
                        if (postWriteCallBackData == null) {
                            c.d(a.this.gPW.getContext().getActivity(), a.this.gPW.getContext().getResources().getString(d.j.send_success), null, null);
                        } else {
                            c.d(a.this.gPW.getContext().getActivity(), postWriteCallBackData.getErrorString(), postWriteCallBackData.getPreMsg(), postWriteCallBackData.getColorMsg());
                        }
                    }
                    Intent intent = new Intent();
                    Bundle bundle = new Bundle();
                    bundle.putSerializable(WriteActivityConfig.POST_WRITE_CALLBACK_DATA, postWriteCallBackData);
                    intent.putExtras(bundle);
                    BaseActivity context = a.this.gPW.getContext();
                    a.this.gPW.getContext();
                    context.setResult(-1, intent);
                    a.this.gPW.getContext().finish();
                } else if (writeData2 != null && qVar != null && !TextUtils.isEmpty(qVar.xZ())) {
                    writeData2.setVcodeMD5(qVar.getVcode_md5());
                    writeData2.setVcodeUrl(qVar.getVcode_pic_url());
                    writeData2.setVcodeExtra(qVar.ya());
                    a.this.gPW.getContext().setVisible(false);
                    if (com.baidu.tbadk.q.a.ha(qVar.xZ())) {
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new NewVcodeActivityConfig(a.this.gPW.getContext().getActivity(), 12006, writeData2, false, qVar.xZ())));
                    } else {
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new VcodeActivityConfig(a.this.gPW.getContext().getActivity(), writeData2, 12006)));
                    }
                } else if (postWriteCallBackData != null && postWriteCallBackData.isSensitiveError()) {
                    Intent intent2 = new Intent();
                    Bundle bundle2 = new Bundle();
                    bundle2.putSerializable(WriteActivityConfig.POST_WRITE_CALLBACK_DATA, postWriteCallBackData);
                    intent2.putExtras(bundle2);
                    BaseActivity context2 = a.this.gPW.getContext();
                    a.this.gPW.getContext();
                    context2.setResult(0, intent2);
                    a.this.gPW.getContext().finish();
                } else {
                    if (postWriteCallBackData != null) {
                        c.d(a.this.gPW.getContext().getActivity(), postWriteCallBackData.getErrorString(), postWriteCallBackData.getPreMsg(), postWriteCallBackData.getColorMsg());
                        BaseActivity context3 = a.this.gPW.getContext();
                        a.this.gPW.getContext();
                        context3.setResult(0, null);
                    }
                    a.this.gPW.getContext().finish();
                }
            }
        }
    };

    public a(b bVar, NewWriteModel newWriteModel) {
        this.gPW = bVar;
        this.gPZ = newWriteModel;
        newWriteModel.b(this.aDo);
    }

    public boolean tK(String str) {
        if (this.gPW == null || str == null) {
            return false;
        }
        if (str.equals("http://tieba.baidu.com/account/access/cancel")) {
            this.gPW.getContext().finish();
            return true;
        } else if (str.equals("http://tieba.baidu.com/account/access/input_focus")) {
            this.gPW.A(0, UtilHelper.getImmersiveStickyBarHeight(), 0, 0);
            if (this.gPW.bCu() != this.gPW.bm()) {
                this.gPW.setRatio(this.gPW.bCu());
                this.gPW.bCv();
            }
            this.gPW.getWebView().setVisibility(0);
            return true;
        } else if (str.equals("http://tieba.baidu.com/account/access/valid_success")) {
            bCs();
            return true;
        } else if (str.equals("http://tieba.baidu.com/account/access/feedback") || str.equals("https://tieba.baidu.com/account/access/feedback")) {
            this.gPW.getContext().finish();
            av.vI().c(this.gPW.getContext().getPageContext(), new String[]{"feedback:"});
            return true;
        } else {
            return true;
        }
    }

    public void bCr() {
        if (this.gPW != null) {
            this.gPW.showWebViewDelay(500);
        }
    }

    public void start(String str) {
        if (this.gPW != null) {
            this.gPW.showWebLoadingView(true);
            this.gPW.showWebView(false);
            this.gPW.getWebView().loadUrl(str);
        }
    }

    public void onPostThreadCancle() {
        if (this.gPW != null) {
            this.gPW.showPostThreadLoadingView(false);
        }
    }

    private void bCs() {
        this.gQa = false;
        if (this.gPW != null && this.gPZ != null) {
            if (!l.hy()) {
                this.gPW.getContext().showToast(d.j.neterror);
                this.gPW.getContext().finish();
                return;
            }
            this.gPW.showPostThreadLoadingView(true);
            this.gPZ.startPostWrite();
        }
    }

    public boolean bCt() {
        return this.gQa;
    }
}
