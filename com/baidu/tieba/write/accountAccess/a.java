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
    private final b gFY;
    private final NewWriteModel gGb;
    private boolean gGc = false;
    private final NewWriteModel.d aCE = new NewWriteModel.d() { // from class: com.baidu.tieba.write.accountAccess.a.1
        @Override // com.baidu.tieba.tbadkCore.writeModel.NewWriteModel.d
        public void callback(boolean z, PostWriteCallBackData postWriteCallBackData, q qVar, WriteData writeData, AntiData antiData) {
            if (a.this.gFY != null && a.this.gGb != null && a.this.gGb.getWriteData() != null) {
                a.this.gFY.showPostThreadLoadingView(false);
                WriteData writeData2 = writeData == null ? a.this.gGb.getWriteData() : writeData;
                if (z) {
                    a.this.gGc = true;
                    if (writeData2.getIsStory() != 1 && (writeData2.getType() != 0 || writeData2.isUserFeedback())) {
                        if (postWriteCallBackData == null) {
                            c.d(a.this.gFY.getContext().getActivity(), a.this.gFY.getContext().getResources().getString(d.l.send_success), null, null);
                        } else {
                            c.d(a.this.gFY.getContext().getActivity(), postWriteCallBackData.getErrorString(), postWriteCallBackData.getPreMsg(), postWriteCallBackData.getColorMsg());
                        }
                    }
                    Intent intent = new Intent();
                    Bundle bundle = new Bundle();
                    bundle.putSerializable(WriteActivityConfig.POST_WRITE_CALLBACK_DATA, postWriteCallBackData);
                    intent.putExtras(bundle);
                    BaseActivity context = a.this.gFY.getContext();
                    a.this.gFY.getContext();
                    context.setResult(-1, intent);
                    a.this.gFY.getContext().finish();
                } else if (writeData2 != null && qVar != null && !TextUtils.isEmpty(qVar.xS())) {
                    writeData2.setVcodeMD5(qVar.getVcode_md5());
                    writeData2.setVcodeUrl(qVar.getVcode_pic_url());
                    writeData2.setVcodeExtra(qVar.xT());
                    a.this.gFY.getContext().setVisible(false);
                    if (com.baidu.tbadk.p.a.gS(qVar.xS())) {
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new NewVcodeActivityConfig(a.this.gFY.getContext().getActivity(), 12006, writeData2, false, qVar.xS())));
                    } else {
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new VcodeActivityConfig(a.this.gFY.getContext().getActivity(), writeData2, 12006)));
                    }
                } else {
                    if (postWriteCallBackData != null) {
                        c.d(a.this.gFY.getContext().getActivity(), postWriteCallBackData.getErrorString(), postWriteCallBackData.getPreMsg(), postWriteCallBackData.getColorMsg());
                        BaseActivity context2 = a.this.gFY.getContext();
                        a.this.gFY.getContext();
                        context2.setResult(0, null);
                    }
                    a.this.gFY.getContext().finish();
                }
            }
        }
    };

    public a(b bVar, NewWriteModel newWriteModel) {
        this.gFY = bVar;
        this.gGb = newWriteModel;
        newWriteModel.b(this.aCE);
    }

    public boolean sX(String str) {
        if (this.gFY == null || str == null) {
            return false;
        }
        if (str.equals("http://tieba.baidu.com/account/access/cancel")) {
            this.gFY.getContext().finish();
            return true;
        } else if (str.equals("http://tieba.baidu.com/account/access/input_focus")) {
            this.gFY.x(0, UtilHelper.getImmersiveStickyBarHeight(), 0, 0);
            if (this.gFY.byW() != this.gFY.bm()) {
                this.gFY.setRatio(this.gFY.byW());
                this.gFY.byX();
            }
            this.gFY.getWebView().setVisibility(0);
            return true;
        } else if (str.equals("http://tieba.baidu.com/account/access/valid_success")) {
            byU();
            return true;
        } else if (str.equals("http://tieba.baidu.com/account/access/feedback") || str.equals("https://tieba.baidu.com/account/access/feedback")) {
            this.gFY.getContext().finish();
            av.vA().c(this.gFY.getContext().getPageContext(), new String[]{"feedback:"});
            return true;
        } else {
            return true;
        }
    }

    public void byT() {
        if (this.gFY != null) {
            this.gFY.showWebViewDelay(500);
        }
    }

    public void start(String str) {
        if (this.gFY != null) {
            this.gFY.showWebLoadingView(true);
            this.gFY.showWebView(false);
            this.gFY.getWebView().loadUrl(str);
        }
    }

    public void onPostThreadCancle() {
        if (this.gFY != null) {
            this.gFY.showPostThreadLoadingView(false);
        }
    }

    private void byU() {
        this.gGc = false;
        if (this.gFY != null && this.gGb != null) {
            if (!l.hy()) {
                this.gFY.getContext().showToast(d.l.neterror);
                this.gFY.getContext().finish();
                return;
            }
            this.gFY.showPostThreadLoadingView(true);
            this.gGb.startPostWrite();
        }
    }

    public boolean byV() {
        return this.gGc;
    }
}
