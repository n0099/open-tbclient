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
    private final b gBg;
    private final NewWriteModel gBj;
    private boolean gBk = false;
    private final NewWriteModel.d aDB = new NewWriteModel.d() { // from class: com.baidu.tieba.write.accountAccess.a.1
        @Override // com.baidu.tieba.tbadkCore.writeModel.NewWriteModel.d
        public void callback(boolean z, PostWriteCallBackData postWriteCallBackData, q qVar, WriteData writeData, AntiData antiData) {
            if (a.this.gBg != null && a.this.gBj != null && a.this.gBj.getWriteData() != null) {
                a.this.gBg.showPostThreadLoadingView(false);
                WriteData writeData2 = writeData == null ? a.this.gBj.getWriteData() : writeData;
                if (z) {
                    a.this.gBk = true;
                    if (writeData2.getIsStory() != 1 && (writeData2.getType() != 0 || writeData2.isUserFeedback())) {
                        if (postWriteCallBackData == null) {
                            c.c(a.this.gBg.getContext().getActivity(), a.this.gBg.getContext().getResources().getString(d.l.send_success), null, null);
                        } else {
                            c.c(a.this.gBg.getContext().getActivity(), postWriteCallBackData.getErrorString(), postWriteCallBackData.getPreMsg(), postWriteCallBackData.getColorMsg());
                        }
                    }
                    Intent intent = new Intent();
                    Bundle bundle = new Bundle();
                    bundle.putSerializable(WriteActivityConfig.POST_WRITE_CALLBACK_DATA, postWriteCallBackData);
                    intent.putExtras(bundle);
                    BaseActivity context = a.this.gBg.getContext();
                    a.this.gBg.getContext();
                    context.setResult(-1, intent);
                    a.this.gBg.getContext().finish();
                } else if (writeData2 != null && qVar != null && !TextUtils.isEmpty(qVar.yA())) {
                    writeData2.setVcodeMD5(qVar.getVcode_md5());
                    writeData2.setVcodeUrl(qVar.getVcode_pic_url());
                    writeData2.setVcodeExtra(qVar.yB());
                    a.this.gBg.getContext().setVisible(false);
                    if (com.baidu.tbadk.q.a.gX(qVar.yA())) {
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new NewVcodeActivityConfig(a.this.gBg.getContext().getActivity(), 12006, writeData2, false, qVar.yA())));
                    } else {
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new VcodeActivityConfig(a.this.gBg.getContext().getActivity(), writeData2, 12006)));
                    }
                } else {
                    if (postWriteCallBackData != null) {
                        c.c(a.this.gBg.getContext().getActivity(), postWriteCallBackData.getErrorString(), postWriteCallBackData.getPreMsg(), postWriteCallBackData.getColorMsg());
                        BaseActivity context2 = a.this.gBg.getContext();
                        a.this.gBg.getContext();
                        context2.setResult(0, null);
                    }
                    a.this.gBg.getContext().finish();
                }
            }
        }
    };

    public a(b bVar, NewWriteModel newWriteModel) {
        this.gBg = bVar;
        this.gBj = newWriteModel;
        newWriteModel.b(this.aDB);
    }

    public boolean sU(String str) {
        if (this.gBg == null || str == null) {
            return false;
        }
        if (str.equals("http://tieba.baidu.com/account/access/cancel")) {
            this.gBg.getContext().finish();
            return true;
        } else if (str.equals("http://tieba.baidu.com/account/access/input_focus")) {
            this.gBg.u(0, UtilHelper.getImmersiveStickyBarHeight(), 0, 0);
            if (this.gBg.bxN() != this.gBg.bm()) {
                this.gBg.setRatio(this.gBg.bxN());
                this.gBg.bxO();
            }
            this.gBg.getWebView().setVisibility(0);
            return true;
        } else if (str.equals("http://tieba.baidu.com/account/access/valid_success")) {
            bxL();
            return true;
        } else if (str.equals("http://tieba.baidu.com/account/access/feedback") || str.equals("https://tieba.baidu.com/account/access/feedback")) {
            this.gBg.getContext().finish();
            au.wd().c(this.gBg.getContext().getPageContext(), new String[]{"feedback:"});
            return true;
        } else {
            return true;
        }
    }

    public void bxK() {
        if (this.gBg != null) {
            this.gBg.showWebViewDelay(500);
        }
    }

    public void start(String str) {
        if (this.gBg != null) {
            this.gBg.showWebLoadingView(true);
            this.gBg.showWebView(false);
            this.gBg.getWebView().loadUrl(str);
        }
    }

    public void onPostThreadCancle() {
        if (this.gBg != null) {
            this.gBg.showPostThreadLoadingView(false);
        }
    }

    private void bxL() {
        this.gBk = false;
        if (this.gBg != null && this.gBj != null) {
            if (!k.hz()) {
                this.gBg.getContext().showToast(d.l.neterror);
                this.gBg.getContext().finish();
                return;
            }
            this.gBg.showPostThreadLoadingView(true);
            this.gBj.startPostWrite();
        }
    }

    public boolean bxM() {
        return this.gBk;
    }
}
