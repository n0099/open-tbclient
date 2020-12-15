package com.baidu.tieba.write.accountAccess;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.lib.util.l;
import com.baidu.live.tbadk.core.data.RequestResponseCode;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.live.tbadk.core.util.UrlSchemaHelper;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.core.atomData.NewVcodeActivityConfig;
import com.baidu.tbadk.core.atomData.VcodeActivityConfig;
import com.baidu.tbadk.core.data.AntiData;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.bf;
import com.baidu.tbadk.coreExtra.data.WriteData;
import com.baidu.tbadk.coreExtra.data.ah;
import com.baidu.tieba.R;
import com.baidu.tieba.tbadkCore.writeModel.NewWriteModel;
import com.baidu.tieba.tbadkCore.writeModel.PostWriteCallBackData;
import com.baidu.tieba.tbadkCore.writeModel.c;
/* loaded from: classes3.dex */
public class a {
    private final b nUC;
    private final NewWriteModel nUF;
    private boolean nUG = false;
    private final NewWriteModel.d fwI = new NewWriteModel.d() { // from class: com.baidu.tieba.write.accountAccess.a.1
        @Override // com.baidu.tieba.tbadkCore.writeModel.NewWriteModel.d
        public void callback(boolean z, PostWriteCallBackData postWriteCallBackData, ah ahVar, WriteData writeData, AntiData antiData) {
            if (a.this.nUC != null && a.this.nUF != null && a.this.nUF.dcE() != null) {
                a.this.nUC.showPostThreadLoadingView(false);
                WriteData dcE = writeData == null ? a.this.nUF.dcE() : writeData;
                if (z) {
                    a.this.nUG = true;
                    if (dcE.getType() != 0 || dcE.isUserFeedback()) {
                        if (postWriteCallBackData == null) {
                            c.h(a.this.nUC.getContext().getActivity(), a.this.nUC.getContext().getResources().getString(R.string.send_success), null, null);
                        } else {
                            c.h(a.this.nUC.getContext().getActivity(), postWriteCallBackData.getErrorString(), postWriteCallBackData.getPreMsg(), postWriteCallBackData.getColorMsg());
                        }
                    }
                    Intent intent = new Intent();
                    Bundle bundle = new Bundle();
                    bundle.putSerializable("post_write_callback_data", postWriteCallBackData);
                    intent.putExtras(bundle);
                    BaseActivity context = a.this.nUC.getContext();
                    a.this.nUC.getContext();
                    context.setResult(-1, intent);
                    a.this.nUC.getContext().finish();
                } else if (dcE != null && ahVar != null && !TextUtils.isEmpty(ahVar.bxL())) {
                    dcE.setVcodeMD5(ahVar.getVcode_md5());
                    dcE.setVcodeUrl(ahVar.getVcode_pic_url());
                    dcE.setVcodeExtra(ahVar.bxM());
                    a.this.nUC.getContext().setVisible(false);
                    if (com.baidu.tbadk.t.a.ES(ahVar.bxL())) {
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new NewVcodeActivityConfig(a.this.nUC.getContext().getActivity(), RequestResponseCode.REQUEST_VCODE, dcE, false, ahVar.bxL())));
                    } else {
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new VcodeActivityConfig(a.this.nUC.getContext().getActivity(), dcE, RequestResponseCode.REQUEST_VCODE)));
                    }
                } else if (postWriteCallBackData != null && postWriteCallBackData.isSensitiveError()) {
                    Intent intent2 = new Intent();
                    Bundle bundle2 = new Bundle();
                    bundle2.putSerializable("post_write_callback_data", postWriteCallBackData);
                    intent2.putExtras(bundle2);
                    BaseActivity context2 = a.this.nUC.getContext();
                    a.this.nUC.getContext();
                    context2.setResult(0, intent2);
                    a.this.nUC.getContext().finish();
                } else {
                    if (postWriteCallBackData != null) {
                        c.h(a.this.nUC.getContext().getActivity(), postWriteCallBackData.getErrorString(), postWriteCallBackData.getPreMsg(), postWriteCallBackData.getColorMsg());
                        BaseActivity context3 = a.this.nUC.getContext();
                        a.this.nUC.getContext();
                        context3.setResult(0, null);
                    }
                    a.this.nUC.getContext().finish();
                }
            }
        }
    };

    public a(b bVar, NewWriteModel newWriteModel) {
        this.nUC = bVar;
        this.nUF = newWriteModel;
        newWriteModel.b(this.fwI);
    }

    public boolean VF(String str) {
        if (this.nUC == null || str == null) {
            return false;
        }
        if (str.equals("http://tieba.baidu.com/account/access/cancel")) {
            this.nUC.getContext().finish();
            return true;
        } else if (str.equals("http://tieba.baidu.com/account/access/input_focus")) {
            this.nUC.setWebViewMargin(0, UtilHelper.getImmersiveStickyBarHeight(), 0, 0);
            if (this.nUC.dYI() != this.nUC.dYH()) {
                this.nUC.setRatio(this.nUC.dYI());
                this.nUC.dYJ();
            }
            this.nUC.getWebView().setVisibility(0);
            return true;
        } else if (str.equals("http://tieba.baidu.com/account/access/valid_success")) {
            dYG();
            return true;
        } else if (str.equals("http://tieba.baidu.com/account/access/feedback") || str.equals("https://tieba.baidu.com/account/access/feedback")) {
            this.nUC.getContext().finish();
            bf.bua().b(this.nUC.getContext().getPageContext(), new String[]{UrlSchemaHelper.SCHEMA_TYPE_FEED_BACK});
            return true;
        } else {
            return true;
        }
    }

    public void dYE() {
        if (this.nUC != null) {
            this.nUC.showWebViewDelay(500);
        }
    }

    public void bv(String str) {
        if (this.nUC != null) {
            this.nUC.zh(true);
            this.nUC.showWebView(false);
            this.nUC.getWebView().loadUrl(str);
        }
    }

    public void dYF() {
        if (this.nUC != null) {
            this.nUC.showPostThreadLoadingView(false);
        }
    }

    private void dYG() {
        this.nUG = false;
        if (this.nUC != null && this.nUF != null) {
            if (!l.isNetOk()) {
                this.nUC.getContext().showToast(R.string.neterror);
                this.nUC.getContext().finish();
                return;
            }
            this.nUC.showPostThreadLoadingView(true);
            this.nUF.dQE();
        }
    }
}
