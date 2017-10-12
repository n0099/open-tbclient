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
    private final b gGn;
    private final NewWriteModel gGq;
    private boolean gGr = false;
    private final NewWriteModel.d aCR = new NewWriteModel.d() { // from class: com.baidu.tieba.write.accountAccess.a.1
        @Override // com.baidu.tieba.tbadkCore.writeModel.NewWriteModel.d
        public void callback(boolean z, PostWriteCallBackData postWriteCallBackData, q qVar, WriteData writeData, AntiData antiData) {
            if (a.this.gGn != null && a.this.gGq != null && a.this.gGq.getWriteData() != null) {
                a.this.gGn.showPostThreadLoadingView(false);
                WriteData writeData2 = writeData == null ? a.this.gGq.getWriteData() : writeData;
                if (z) {
                    a.this.gGr = true;
                    if (writeData2.getIsStory() != 1 && (writeData2.getType() != 0 || writeData2.isUserFeedback())) {
                        if (postWriteCallBackData == null) {
                            c.d(a.this.gGn.getContext().getActivity(), a.this.gGn.getContext().getResources().getString(d.l.send_success), null, null);
                        } else {
                            c.d(a.this.gGn.getContext().getActivity(), postWriteCallBackData.getErrorString(), postWriteCallBackData.getPreMsg(), postWriteCallBackData.getColorMsg());
                        }
                    }
                    Intent intent = new Intent();
                    Bundle bundle = new Bundle();
                    bundle.putSerializable(WriteActivityConfig.POST_WRITE_CALLBACK_DATA, postWriteCallBackData);
                    intent.putExtras(bundle);
                    BaseActivity context = a.this.gGn.getContext();
                    a.this.gGn.getContext();
                    context.setResult(-1, intent);
                    a.this.gGn.getContext().finish();
                } else if (writeData2 != null && qVar != null && !TextUtils.isEmpty(qVar.xZ())) {
                    writeData2.setVcodeMD5(qVar.getVcode_md5());
                    writeData2.setVcodeUrl(qVar.getVcode_pic_url());
                    writeData2.setVcodeExtra(qVar.ya());
                    a.this.gGn.getContext().setVisible(false);
                    if (com.baidu.tbadk.p.a.gT(qVar.xZ())) {
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new NewVcodeActivityConfig(a.this.gGn.getContext().getActivity(), 12006, writeData2, false, qVar.xZ())));
                    } else {
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new VcodeActivityConfig(a.this.gGn.getContext().getActivity(), writeData2, 12006)));
                    }
                } else {
                    if (postWriteCallBackData != null) {
                        c.d(a.this.gGn.getContext().getActivity(), postWriteCallBackData.getErrorString(), postWriteCallBackData.getPreMsg(), postWriteCallBackData.getColorMsg());
                        BaseActivity context2 = a.this.gGn.getContext();
                        a.this.gGn.getContext();
                        context2.setResult(0, null);
                    }
                    a.this.gGn.getContext().finish();
                }
            }
        }
    };

    public a(b bVar, NewWriteModel newWriteModel) {
        this.gGn = bVar;
        this.gGq = newWriteModel;
        newWriteModel.b(this.aCR);
    }

    public boolean sY(String str) {
        if (this.gGn == null || str == null) {
            return false;
        }
        if (str.equals("http://tieba.baidu.com/account/access/cancel")) {
            this.gGn.getContext().finish();
            return true;
        } else if (str.equals("http://tieba.baidu.com/account/access/input_focus")) {
            this.gGn.x(0, UtilHelper.getImmersiveStickyBarHeight(), 0, 0);
            if (this.gGn.bzc() != this.gGn.bm()) {
                this.gGn.setRatio(this.gGn.bzc());
                this.gGn.bzd();
            }
            this.gGn.getWebView().setVisibility(0);
            return true;
        } else if (str.equals("http://tieba.baidu.com/account/access/valid_success")) {
            bza();
            return true;
        } else if (str.equals("http://tieba.baidu.com/account/access/feedback") || str.equals("https://tieba.baidu.com/account/access/feedback")) {
            this.gGn.getContext().finish();
            av.vH().c(this.gGn.getContext().getPageContext(), new String[]{"feedback:"});
            return true;
        } else {
            return true;
        }
    }

    public void byZ() {
        if (this.gGn != null) {
            this.gGn.showWebViewDelay(500);
        }
    }

    public void start(String str) {
        if (this.gGn != null) {
            this.gGn.showWebLoadingView(true);
            this.gGn.showWebView(false);
            this.gGn.getWebView().loadUrl(str);
        }
    }

    public void onPostThreadCancle() {
        if (this.gGn != null) {
            this.gGn.showPostThreadLoadingView(false);
        }
    }

    private void bza() {
        this.gGr = false;
        if (this.gGn != null && this.gGq != null) {
            if (!l.hy()) {
                this.gGn.getContext().showToast(d.l.neterror);
                this.gGn.getContext().finish();
                return;
            }
            this.gGn.showPostThreadLoadingView(true);
            this.gGq.startPostWrite();
        }
    }

    public boolean bzb() {
        return this.gGr;
    }
}
