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
    private final b gGo;
    private final NewWriteModel gGr;
    private boolean gGs = false;
    private final NewWriteModel.d aCR = new NewWriteModel.d() { // from class: com.baidu.tieba.write.accountAccess.a.1
        @Override // com.baidu.tieba.tbadkCore.writeModel.NewWriteModel.d
        public void callback(boolean z, PostWriteCallBackData postWriteCallBackData, q qVar, WriteData writeData, AntiData antiData) {
            if (a.this.gGo != null && a.this.gGr != null && a.this.gGr.getWriteData() != null) {
                a.this.gGo.showPostThreadLoadingView(false);
                WriteData writeData2 = writeData == null ? a.this.gGr.getWriteData() : writeData;
                if (z) {
                    a.this.gGs = true;
                    if (writeData2.getIsStory() != 1 && (writeData2.getType() != 0 || writeData2.isUserFeedback())) {
                        if (postWriteCallBackData == null) {
                            c.d(a.this.gGo.getContext().getActivity(), a.this.gGo.getContext().getResources().getString(d.l.send_success), null, null);
                        } else {
                            c.d(a.this.gGo.getContext().getActivity(), postWriteCallBackData.getErrorString(), postWriteCallBackData.getPreMsg(), postWriteCallBackData.getColorMsg());
                        }
                    }
                    Intent intent = new Intent();
                    Bundle bundle = new Bundle();
                    bundle.putSerializable(WriteActivityConfig.POST_WRITE_CALLBACK_DATA, postWriteCallBackData);
                    intent.putExtras(bundle);
                    BaseActivity context = a.this.gGo.getContext();
                    a.this.gGo.getContext();
                    context.setResult(-1, intent);
                    a.this.gGo.getContext().finish();
                } else if (writeData2 != null && qVar != null && !TextUtils.isEmpty(qVar.xZ())) {
                    writeData2.setVcodeMD5(qVar.getVcode_md5());
                    writeData2.setVcodeUrl(qVar.getVcode_pic_url());
                    writeData2.setVcodeExtra(qVar.ya());
                    a.this.gGo.getContext().setVisible(false);
                    if (com.baidu.tbadk.p.a.gT(qVar.xZ())) {
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new NewVcodeActivityConfig(a.this.gGo.getContext().getActivity(), 12006, writeData2, false, qVar.xZ())));
                    } else {
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new VcodeActivityConfig(a.this.gGo.getContext().getActivity(), writeData2, 12006)));
                    }
                } else {
                    if (postWriteCallBackData != null) {
                        c.d(a.this.gGo.getContext().getActivity(), postWriteCallBackData.getErrorString(), postWriteCallBackData.getPreMsg(), postWriteCallBackData.getColorMsg());
                        BaseActivity context2 = a.this.gGo.getContext();
                        a.this.gGo.getContext();
                        context2.setResult(0, null);
                    }
                    a.this.gGo.getContext().finish();
                }
            }
        }
    };

    public a(b bVar, NewWriteModel newWriteModel) {
        this.gGo = bVar;
        this.gGr = newWriteModel;
        newWriteModel.b(this.aCR);
    }

    public boolean sY(String str) {
        if (this.gGo == null || str == null) {
            return false;
        }
        if (str.equals("http://tieba.baidu.com/account/access/cancel")) {
            this.gGo.getContext().finish();
            return true;
        } else if (str.equals("http://tieba.baidu.com/account/access/input_focus")) {
            this.gGo.x(0, UtilHelper.getImmersiveStickyBarHeight(), 0, 0);
            if (this.gGo.bzd() != this.gGo.bm()) {
                this.gGo.setRatio(this.gGo.bzd());
                this.gGo.bze();
            }
            this.gGo.getWebView().setVisibility(0);
            return true;
        } else if (str.equals("http://tieba.baidu.com/account/access/valid_success")) {
            bzb();
            return true;
        } else if (str.equals("http://tieba.baidu.com/account/access/feedback") || str.equals("https://tieba.baidu.com/account/access/feedback")) {
            this.gGo.getContext().finish();
            av.vH().c(this.gGo.getContext().getPageContext(), new String[]{"feedback:"});
            return true;
        } else {
            return true;
        }
    }

    public void bza() {
        if (this.gGo != null) {
            this.gGo.showWebViewDelay(500);
        }
    }

    public void start(String str) {
        if (this.gGo != null) {
            this.gGo.showWebLoadingView(true);
            this.gGo.showWebView(false);
            this.gGo.getWebView().loadUrl(str);
        }
    }

    public void onPostThreadCancle() {
        if (this.gGo != null) {
            this.gGo.showPostThreadLoadingView(false);
        }
    }

    private void bzb() {
        this.gGs = false;
        if (this.gGo != null && this.gGr != null) {
            if (!l.hy()) {
                this.gGo.getContext().showToast(d.l.neterror);
                this.gGo.getContext().finish();
                return;
            }
            this.gGo.showPostThreadLoadingView(true);
            this.gGr.startPostWrite();
        }
    }

    public boolean bzc() {
        return this.gGs;
    }
}
