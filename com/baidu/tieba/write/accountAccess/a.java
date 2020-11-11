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
import com.baidu.tbadk.core.util.be;
import com.baidu.tbadk.coreExtra.data.WriteData;
import com.baidu.tbadk.coreExtra.data.ah;
import com.baidu.tieba.R;
import com.baidu.tieba.tbadkCore.writeModel.NewWriteModel;
import com.baidu.tieba.tbadkCore.writeModel.PostWriteCallBackData;
import com.baidu.tieba.tbadkCore.writeModel.c;
/* loaded from: classes3.dex */
public class a {
    private final b nET;
    private final NewWriteModel nEW;
    private boolean nEX = false;
    private final NewWriteModel.d fpW = new NewWriteModel.d() { // from class: com.baidu.tieba.write.accountAccess.a.1
        @Override // com.baidu.tieba.tbadkCore.writeModel.NewWriteModel.d
        public void callback(boolean z, PostWriteCallBackData postWriteCallBackData, ah ahVar, WriteData writeData, AntiData antiData) {
            if (a.this.nET != null && a.this.nEW != null && a.this.nEW.cXW() != null) {
                a.this.nET.showPostThreadLoadingView(false);
                WriteData cXW = writeData == null ? a.this.nEW.cXW() : writeData;
                if (z) {
                    a.this.nEX = true;
                    if (cXW.getType() != 0 || cXW.isUserFeedback()) {
                        if (postWriteCallBackData == null) {
                            c.g(a.this.nET.getContext().getActivity(), a.this.nET.getContext().getResources().getString(R.string.send_success), null, null);
                        } else {
                            c.g(a.this.nET.getContext().getActivity(), postWriteCallBackData.getErrorString(), postWriteCallBackData.getPreMsg(), postWriteCallBackData.getColorMsg());
                        }
                    }
                    Intent intent = new Intent();
                    Bundle bundle = new Bundle();
                    bundle.putSerializable("post_write_callback_data", postWriteCallBackData);
                    intent.putExtras(bundle);
                    BaseActivity context = a.this.nET.getContext();
                    a.this.nET.getContext();
                    context.setResult(-1, intent);
                    a.this.nET.getContext().finish();
                } else if (cXW != null && ahVar != null && !TextUtils.isEmpty(ahVar.buV())) {
                    cXW.setVcodeMD5(ahVar.getVcode_md5());
                    cXW.setVcodeUrl(ahVar.getVcode_pic_url());
                    cXW.setVcodeExtra(ahVar.buW());
                    a.this.nET.getContext().setVisible(false);
                    if (com.baidu.tbadk.t.a.EE(ahVar.buV())) {
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new NewVcodeActivityConfig(a.this.nET.getContext().getActivity(), RequestResponseCode.REQUEST_VCODE, cXW, false, ahVar.buV())));
                    } else {
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new VcodeActivityConfig(a.this.nET.getContext().getActivity(), cXW, RequestResponseCode.REQUEST_VCODE)));
                    }
                } else if (postWriteCallBackData != null && postWriteCallBackData.isSensitiveError()) {
                    Intent intent2 = new Intent();
                    Bundle bundle2 = new Bundle();
                    bundle2.putSerializable("post_write_callback_data", postWriteCallBackData);
                    intent2.putExtras(bundle2);
                    BaseActivity context2 = a.this.nET.getContext();
                    a.this.nET.getContext();
                    context2.setResult(0, intent2);
                    a.this.nET.getContext().finish();
                } else {
                    if (postWriteCallBackData != null) {
                        c.g(a.this.nET.getContext().getActivity(), postWriteCallBackData.getErrorString(), postWriteCallBackData.getPreMsg(), postWriteCallBackData.getColorMsg());
                        BaseActivity context3 = a.this.nET.getContext();
                        a.this.nET.getContext();
                        context3.setResult(0, null);
                    }
                    a.this.nET.getContext().finish();
                }
            }
        }
    };

    public a(b bVar, NewWriteModel newWriteModel) {
        this.nET = bVar;
        this.nEW = newWriteModel;
        newWriteModel.b(this.fpW);
    }

    public boolean UF(String str) {
        if (this.nET == null || str == null) {
            return false;
        }
        if (str.equals("http://tieba.baidu.com/account/access/cancel")) {
            this.nET.getContext().finish();
            return true;
        } else if (str.equals("http://tieba.baidu.com/account/access/input_focus")) {
            this.nET.setWebViewMargin(0, UtilHelper.getImmersiveStickyBarHeight(), 0, 0);
            if (this.nET.dTo() != this.nET.dTn()) {
                this.nET.setRatio(this.nET.dTo());
                this.nET.dTp();
            }
            this.nET.getWebView().setVisibility(0);
            return true;
        } else if (str.equals("http://tieba.baidu.com/account/access/valid_success")) {
            dTm();
            return true;
        } else if (str.equals("http://tieba.baidu.com/account/access/feedback") || str.equals("https://tieba.baidu.com/account/access/feedback")) {
            this.nET.getContext().finish();
            be.brr().b(this.nET.getContext().getPageContext(), new String[]{UrlSchemaHelper.SCHEMA_TYPE_FEED_BACK});
            return true;
        } else {
            return true;
        }
    }

    public void dTk() {
        if (this.nET != null) {
            this.nET.showWebViewDelay(500);
        }
    }

    public void bs(String str) {
        if (this.nET != null) {
            this.nET.yv(true);
            this.nET.showWebView(false);
            this.nET.getWebView().loadUrl(str);
        }
    }

    public void dTl() {
        if (this.nET != null) {
            this.nET.showPostThreadLoadingView(false);
        }
    }

    private void dTm() {
        this.nEX = false;
        if (this.nET != null && this.nEW != null) {
            if (!l.isNetOk()) {
                this.nET.getContext().showToast(R.string.neterror);
                this.nET.getContext().finish();
                return;
            }
            this.nET.showPostThreadLoadingView(true);
            this.nEW.dLm();
        }
    }
}
