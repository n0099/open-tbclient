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
    private final b nGu;
    private final NewWriteModel nGx;
    private boolean nGy = false;
    private final NewWriteModel.d fpd = new NewWriteModel.d() { // from class: com.baidu.tieba.write.accountAccess.a.1
        @Override // com.baidu.tieba.tbadkCore.writeModel.NewWriteModel.d
        public void callback(boolean z, PostWriteCallBackData postWriteCallBackData, ah ahVar, WriteData writeData, AntiData antiData) {
            if (a.this.nGu != null && a.this.nGx != null && a.this.nGx.cXs() != null) {
                a.this.nGu.showPostThreadLoadingView(false);
                WriteData cXs = writeData == null ? a.this.nGx.cXs() : writeData;
                if (z) {
                    a.this.nGy = true;
                    if (cXs.getType() != 0 || cXs.isUserFeedback()) {
                        if (postWriteCallBackData == null) {
                            c.g(a.this.nGu.getContext().getActivity(), a.this.nGu.getContext().getResources().getString(R.string.send_success), null, null);
                        } else {
                            c.g(a.this.nGu.getContext().getActivity(), postWriteCallBackData.getErrorString(), postWriteCallBackData.getPreMsg(), postWriteCallBackData.getColorMsg());
                        }
                    }
                    Intent intent = new Intent();
                    Bundle bundle = new Bundle();
                    bundle.putSerializable("post_write_callback_data", postWriteCallBackData);
                    intent.putExtras(bundle);
                    BaseActivity context = a.this.nGu.getContext();
                    a.this.nGu.getContext();
                    context.setResult(-1, intent);
                    a.this.nGu.getContext().finish();
                } else if (cXs != null && ahVar != null && !TextUtils.isEmpty(ahVar.bul())) {
                    cXs.setVcodeMD5(ahVar.getVcode_md5());
                    cXs.setVcodeUrl(ahVar.getVcode_pic_url());
                    cXs.setVcodeExtra(ahVar.bum());
                    a.this.nGu.getContext().setVisible(false);
                    if (com.baidu.tbadk.t.a.Ef(ahVar.bul())) {
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new NewVcodeActivityConfig(a.this.nGu.getContext().getActivity(), RequestResponseCode.REQUEST_VCODE, cXs, false, ahVar.bul())));
                    } else {
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new VcodeActivityConfig(a.this.nGu.getContext().getActivity(), cXs, RequestResponseCode.REQUEST_VCODE)));
                    }
                } else if (postWriteCallBackData != null && postWriteCallBackData.isSensitiveError()) {
                    Intent intent2 = new Intent();
                    Bundle bundle2 = new Bundle();
                    bundle2.putSerializable("post_write_callback_data", postWriteCallBackData);
                    intent2.putExtras(bundle2);
                    BaseActivity context2 = a.this.nGu.getContext();
                    a.this.nGu.getContext();
                    context2.setResult(0, intent2);
                    a.this.nGu.getContext().finish();
                } else {
                    if (postWriteCallBackData != null) {
                        c.g(a.this.nGu.getContext().getActivity(), postWriteCallBackData.getErrorString(), postWriteCallBackData.getPreMsg(), postWriteCallBackData.getColorMsg());
                        BaseActivity context3 = a.this.nGu.getContext();
                        a.this.nGu.getContext();
                        context3.setResult(0, null);
                    }
                    a.this.nGu.getContext().finish();
                }
            }
        }
    };

    public a(b bVar, NewWriteModel newWriteModel) {
        this.nGu = bVar;
        this.nGx = newWriteModel;
        newWriteModel.b(this.fpd);
    }

    public boolean Uq(String str) {
        if (this.nGu == null || str == null) {
            return false;
        }
        if (str.equals("http://tieba.baidu.com/account/access/cancel")) {
            this.nGu.getContext().finish();
            return true;
        } else if (str.equals("http://tieba.baidu.com/account/access/input_focus")) {
            this.nGu.setWebViewMargin(0, UtilHelper.getImmersiveStickyBarHeight(), 0, 0);
            if (this.nGu.dTn() != this.nGu.dTm()) {
                this.nGu.setRatio(this.nGu.dTn());
                this.nGu.dTo();
            }
            this.nGu.getWebView().setVisibility(0);
            return true;
        } else if (str.equals("http://tieba.baidu.com/account/access/valid_success")) {
            dTl();
            return true;
        } else if (str.equals("http://tieba.baidu.com/account/access/feedback") || str.equals("https://tieba.baidu.com/account/access/feedback")) {
            this.nGu.getContext().finish();
            bf.bqF().b(this.nGu.getContext().getPageContext(), new String[]{UrlSchemaHelper.SCHEMA_TYPE_FEED_BACK});
            return true;
        } else {
            return true;
        }
    }

    public void dTj() {
        if (this.nGu != null) {
            this.nGu.showWebViewDelay(500);
        }
    }

    public void bs(String str) {
        if (this.nGu != null) {
            this.nGu.yC(true);
            this.nGu.showWebView(false);
            this.nGu.getWebView().loadUrl(str);
        }
    }

    public void dTk() {
        if (this.nGu != null) {
            this.nGu.showPostThreadLoadingView(false);
        }
    }

    private void dTl() {
        this.nGy = false;
        if (this.nGu != null && this.nGx != null) {
            if (!l.isNetOk()) {
                this.nGu.getContext().showToast(R.string.neterror);
                this.nGu.getContext().finish();
                return;
            }
            this.nGu.showPostThreadLoadingView(true);
            this.nGx.dLl();
        }
    }
}
