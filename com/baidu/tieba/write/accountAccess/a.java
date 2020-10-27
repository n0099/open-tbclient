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
    private final b nyZ;
    private final NewWriteModel nzc;
    private boolean nzd = false;
    private final NewWriteModel.d fke = new NewWriteModel.d() { // from class: com.baidu.tieba.write.accountAccess.a.1
        @Override // com.baidu.tieba.tbadkCore.writeModel.NewWriteModel.d
        public void callback(boolean z, PostWriteCallBackData postWriteCallBackData, ah ahVar, WriteData writeData, AntiData antiData) {
            if (a.this.nyZ != null && a.this.nzc != null && a.this.nzc.cVv() != null) {
                a.this.nyZ.showPostThreadLoadingView(false);
                WriteData cVv = writeData == null ? a.this.nzc.cVv() : writeData;
                if (z) {
                    a.this.nzd = true;
                    if (cVv.getType() != 0 || cVv.isUserFeedback()) {
                        if (postWriteCallBackData == null) {
                            c.g(a.this.nyZ.getContext().getActivity(), a.this.nyZ.getContext().getResources().getString(R.string.send_success), null, null);
                        } else {
                            c.g(a.this.nyZ.getContext().getActivity(), postWriteCallBackData.getErrorString(), postWriteCallBackData.getPreMsg(), postWriteCallBackData.getColorMsg());
                        }
                    }
                    Intent intent = new Intent();
                    Bundle bundle = new Bundle();
                    bundle.putSerializable("post_write_callback_data", postWriteCallBackData);
                    intent.putExtras(bundle);
                    BaseActivity context = a.this.nyZ.getContext();
                    a.this.nyZ.getContext();
                    context.setResult(-1, intent);
                    a.this.nyZ.getContext().finish();
                } else if (cVv != null && ahVar != null && !TextUtils.isEmpty(ahVar.bsv())) {
                    cVv.setVcodeMD5(ahVar.getVcode_md5());
                    cVv.setVcodeUrl(ahVar.getVcode_pic_url());
                    cVv.setVcodeExtra(ahVar.bsw());
                    a.this.nyZ.getContext().setVisible(false);
                    if (com.baidu.tbadk.t.a.Eq(ahVar.bsv())) {
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new NewVcodeActivityConfig(a.this.nyZ.getContext().getActivity(), RequestResponseCode.REQUEST_VCODE, cVv, false, ahVar.bsv())));
                    } else {
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new VcodeActivityConfig(a.this.nyZ.getContext().getActivity(), cVv, RequestResponseCode.REQUEST_VCODE)));
                    }
                } else if (postWriteCallBackData != null && postWriteCallBackData.isSensitiveError()) {
                    Intent intent2 = new Intent();
                    Bundle bundle2 = new Bundle();
                    bundle2.putSerializable("post_write_callback_data", postWriteCallBackData);
                    intent2.putExtras(bundle2);
                    BaseActivity context2 = a.this.nyZ.getContext();
                    a.this.nyZ.getContext();
                    context2.setResult(0, intent2);
                    a.this.nyZ.getContext().finish();
                } else {
                    if (postWriteCallBackData != null) {
                        c.g(a.this.nyZ.getContext().getActivity(), postWriteCallBackData.getErrorString(), postWriteCallBackData.getPreMsg(), postWriteCallBackData.getColorMsg());
                        BaseActivity context3 = a.this.nyZ.getContext();
                        a.this.nyZ.getContext();
                        context3.setResult(0, null);
                    }
                    a.this.nyZ.getContext().finish();
                }
            }
        }
    };

    public a(b bVar, NewWriteModel newWriteModel) {
        this.nyZ = bVar;
        this.nzc = newWriteModel;
        newWriteModel.b(this.fke);
    }

    public boolean Uo(String str) {
        if (this.nyZ == null || str == null) {
            return false;
        }
        if (str.equals("http://tieba.baidu.com/account/access/cancel")) {
            this.nyZ.getContext().finish();
            return true;
        } else if (str.equals("http://tieba.baidu.com/account/access/input_focus")) {
            this.nyZ.setWebViewMargin(0, UtilHelper.getImmersiveStickyBarHeight(), 0, 0);
            if (this.nyZ.dQO() != this.nyZ.dQN()) {
                this.nyZ.setRatio(this.nyZ.dQO());
                this.nyZ.dQP();
            }
            this.nyZ.getWebView().setVisibility(0);
            return true;
        } else if (str.equals("http://tieba.baidu.com/account/access/valid_success")) {
            dQM();
            return true;
        } else if (str.equals("http://tieba.baidu.com/account/access/feedback") || str.equals("https://tieba.baidu.com/account/access/feedback")) {
            this.nyZ.getContext().finish();
            be.boR().b(this.nyZ.getContext().getPageContext(), new String[]{UrlSchemaHelper.SCHEMA_TYPE_FEED_BACK});
            return true;
        } else {
            return true;
        }
    }

    public void dQK() {
        if (this.nyZ != null) {
            this.nyZ.showWebViewDelay(500);
        }
    }

    public void bs(String str) {
        if (this.nyZ != null) {
            this.nyZ.ym(true);
            this.nyZ.showWebView(false);
            this.nyZ.getWebView().loadUrl(str);
        }
    }

    public void dQL() {
        if (this.nyZ != null) {
            this.nyZ.showPostThreadLoadingView(false);
        }
    }

    private void dQM() {
        this.nzd = false;
        if (this.nyZ != null && this.nzc != null) {
            if (!l.isNetOk()) {
                this.nyZ.getContext().showToast(R.string.neterror);
                this.nyZ.getContext().finish();
                return;
            }
            this.nyZ.showPostThreadLoadingView(true);
            this.nzc.dIK();
        }
    }
}
