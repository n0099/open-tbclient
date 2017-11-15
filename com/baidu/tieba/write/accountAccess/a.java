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
import com.baidu.tbadk.coreExtra.data.r;
import com.baidu.tieba.d;
import com.baidu.tieba.tbadkCore.writeModel.NewWriteModel;
import com.baidu.tieba.tbadkCore.writeModel.PostWriteCallBackData;
import com.baidu.tieba.tbadkCore.writeModel.c;
/* loaded from: classes2.dex */
public class a {
    private final b gRe;
    private final NewWriteModel gRh;
    private boolean gRi = false;
    private final NewWriteModel.d aDw = new NewWriteModel.d() { // from class: com.baidu.tieba.write.accountAccess.a.1
        @Override // com.baidu.tieba.tbadkCore.writeModel.NewWriteModel.d
        public void callback(boolean z, PostWriteCallBackData postWriteCallBackData, r rVar, WriteData writeData, AntiData antiData) {
            if (a.this.gRe != null && a.this.gRh != null && a.this.gRh.getWriteData() != null) {
                a.this.gRe.showPostThreadLoadingView(false);
                WriteData writeData2 = writeData == null ? a.this.gRh.getWriteData() : writeData;
                if (z) {
                    a.this.gRi = true;
                    if (writeData2.getIsStory() != 1 && (writeData2.getType() != 0 || writeData2.isUserFeedback())) {
                        if (postWriteCallBackData == null) {
                            c.d(a.this.gRe.getContext().getActivity(), a.this.gRe.getContext().getResources().getString(d.j.send_success), null, null);
                        } else {
                            c.d(a.this.gRe.getContext().getActivity(), postWriteCallBackData.getErrorString(), postWriteCallBackData.getPreMsg(), postWriteCallBackData.getColorMsg());
                        }
                    }
                    Intent intent = new Intent();
                    Bundle bundle = new Bundle();
                    bundle.putSerializable(WriteActivityConfig.POST_WRITE_CALLBACK_DATA, postWriteCallBackData);
                    intent.putExtras(bundle);
                    BaseActivity context = a.this.gRe.getContext();
                    a.this.gRe.getContext();
                    context.setResult(-1, intent);
                    a.this.gRe.getContext().finish();
                } else if (writeData2 != null && rVar != null && !TextUtils.isEmpty(rVar.yh())) {
                    writeData2.setVcodeMD5(rVar.getVcode_md5());
                    writeData2.setVcodeUrl(rVar.getVcode_pic_url());
                    writeData2.setVcodeExtra(rVar.yi());
                    a.this.gRe.getContext().setVisible(false);
                    if (com.baidu.tbadk.q.a.hb(rVar.yh())) {
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new NewVcodeActivityConfig(a.this.gRe.getContext().getActivity(), 12006, writeData2, false, rVar.yh())));
                    } else {
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new VcodeActivityConfig(a.this.gRe.getContext().getActivity(), writeData2, 12006)));
                    }
                } else if (postWriteCallBackData != null && postWriteCallBackData.isSensitiveError()) {
                    Intent intent2 = new Intent();
                    Bundle bundle2 = new Bundle();
                    bundle2.putSerializable(WriteActivityConfig.POST_WRITE_CALLBACK_DATA, postWriteCallBackData);
                    intent2.putExtras(bundle2);
                    BaseActivity context2 = a.this.gRe.getContext();
                    a.this.gRe.getContext();
                    context2.setResult(0, intent2);
                    a.this.gRe.getContext().finish();
                } else {
                    if (postWriteCallBackData != null) {
                        c.d(a.this.gRe.getContext().getActivity(), postWriteCallBackData.getErrorString(), postWriteCallBackData.getPreMsg(), postWriteCallBackData.getColorMsg());
                        BaseActivity context3 = a.this.gRe.getContext();
                        a.this.gRe.getContext();
                        context3.setResult(0, null);
                    }
                    a.this.gRe.getContext().finish();
                }
            }
        }
    };

    public a(b bVar, NewWriteModel newWriteModel) {
        this.gRe = bVar;
        this.gRh = newWriteModel;
        newWriteModel.b(this.aDw);
    }

    public boolean tQ(String str) {
        if (this.gRe == null || str == null) {
            return false;
        }
        if (str.equals("http://tieba.baidu.com/account/access/cancel")) {
            this.gRe.getContext().finish();
            return true;
        } else if (str.equals("http://tieba.baidu.com/account/access/input_focus")) {
            this.gRe.A(0, UtilHelper.getImmersiveStickyBarHeight(), 0, 0);
            if (this.gRe.bCG() != this.gRe.bm()) {
                this.gRe.setRatio(this.gRe.bCG());
                this.gRe.bCH();
            }
            this.gRe.getWebView().setVisibility(0);
            return true;
        } else if (str.equals("http://tieba.baidu.com/account/access/valid_success")) {
            bCE();
            return true;
        } else if (str.equals("http://tieba.baidu.com/account/access/feedback") || str.equals("https://tieba.baidu.com/account/access/feedback")) {
            this.gRe.getContext().finish();
            av.vI().c(this.gRe.getContext().getPageContext(), new String[]{"feedback:"});
            return true;
        } else {
            return true;
        }
    }

    public void bCD() {
        if (this.gRe != null) {
            this.gRe.showWebViewDelay(500);
        }
    }

    public void start(String str) {
        if (this.gRe != null) {
            this.gRe.showWebLoadingView(true);
            this.gRe.showWebView(false);
            this.gRe.getWebView().loadUrl(str);
        }
    }

    public void onPostThreadCancle() {
        if (this.gRe != null) {
            this.gRe.showPostThreadLoadingView(false);
        }
    }

    private void bCE() {
        this.gRi = false;
        if (this.gRe != null && this.gRh != null) {
            if (!l.hy()) {
                this.gRe.getContext().showToast(d.j.neterror);
                this.gRe.getContext().finish();
                return;
            }
            this.gRe.showPostThreadLoadingView(true);
            this.gRh.startPostWrite();
        }
    }

    public boolean bCF() {
        return this.gRi;
    }
}
