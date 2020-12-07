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
    private final b nUA;
    private final NewWriteModel nUD;
    private boolean nUE = false;
    private final NewWriteModel.d fwI = new NewWriteModel.d() { // from class: com.baidu.tieba.write.accountAccess.a.1
        @Override // com.baidu.tieba.tbadkCore.writeModel.NewWriteModel.d
        public void callback(boolean z, PostWriteCallBackData postWriteCallBackData, ah ahVar, WriteData writeData, AntiData antiData) {
            if (a.this.nUA != null && a.this.nUD != null && a.this.nUD.dcD() != null) {
                a.this.nUA.showPostThreadLoadingView(false);
                WriteData dcD = writeData == null ? a.this.nUD.dcD() : writeData;
                if (z) {
                    a.this.nUE = true;
                    if (dcD.getType() != 0 || dcD.isUserFeedback()) {
                        if (postWriteCallBackData == null) {
                            c.h(a.this.nUA.getContext().getActivity(), a.this.nUA.getContext().getResources().getString(R.string.send_success), null, null);
                        } else {
                            c.h(a.this.nUA.getContext().getActivity(), postWriteCallBackData.getErrorString(), postWriteCallBackData.getPreMsg(), postWriteCallBackData.getColorMsg());
                        }
                    }
                    Intent intent = new Intent();
                    Bundle bundle = new Bundle();
                    bundle.putSerializable("post_write_callback_data", postWriteCallBackData);
                    intent.putExtras(bundle);
                    BaseActivity context = a.this.nUA.getContext();
                    a.this.nUA.getContext();
                    context.setResult(-1, intent);
                    a.this.nUA.getContext().finish();
                } else if (dcD != null && ahVar != null && !TextUtils.isEmpty(ahVar.bxL())) {
                    dcD.setVcodeMD5(ahVar.getVcode_md5());
                    dcD.setVcodeUrl(ahVar.getVcode_pic_url());
                    dcD.setVcodeExtra(ahVar.bxM());
                    a.this.nUA.getContext().setVisible(false);
                    if (com.baidu.tbadk.t.a.ES(ahVar.bxL())) {
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new NewVcodeActivityConfig(a.this.nUA.getContext().getActivity(), RequestResponseCode.REQUEST_VCODE, dcD, false, ahVar.bxL())));
                    } else {
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new VcodeActivityConfig(a.this.nUA.getContext().getActivity(), dcD, RequestResponseCode.REQUEST_VCODE)));
                    }
                } else if (postWriteCallBackData != null && postWriteCallBackData.isSensitiveError()) {
                    Intent intent2 = new Intent();
                    Bundle bundle2 = new Bundle();
                    bundle2.putSerializable("post_write_callback_data", postWriteCallBackData);
                    intent2.putExtras(bundle2);
                    BaseActivity context2 = a.this.nUA.getContext();
                    a.this.nUA.getContext();
                    context2.setResult(0, intent2);
                    a.this.nUA.getContext().finish();
                } else {
                    if (postWriteCallBackData != null) {
                        c.h(a.this.nUA.getContext().getActivity(), postWriteCallBackData.getErrorString(), postWriteCallBackData.getPreMsg(), postWriteCallBackData.getColorMsg());
                        BaseActivity context3 = a.this.nUA.getContext();
                        a.this.nUA.getContext();
                        context3.setResult(0, null);
                    }
                    a.this.nUA.getContext().finish();
                }
            }
        }
    };

    public a(b bVar, NewWriteModel newWriteModel) {
        this.nUA = bVar;
        this.nUD = newWriteModel;
        newWriteModel.b(this.fwI);
    }

    public boolean VF(String str) {
        if (this.nUA == null || str == null) {
            return false;
        }
        if (str.equals("http://tieba.baidu.com/account/access/cancel")) {
            this.nUA.getContext().finish();
            return true;
        } else if (str.equals("http://tieba.baidu.com/account/access/input_focus")) {
            this.nUA.setWebViewMargin(0, UtilHelper.getImmersiveStickyBarHeight(), 0, 0);
            if (this.nUA.dYH() != this.nUA.dYG()) {
                this.nUA.setRatio(this.nUA.dYH());
                this.nUA.dYI();
            }
            this.nUA.getWebView().setVisibility(0);
            return true;
        } else if (str.equals("http://tieba.baidu.com/account/access/valid_success")) {
            dYF();
            return true;
        } else if (str.equals("http://tieba.baidu.com/account/access/feedback") || str.equals("https://tieba.baidu.com/account/access/feedback")) {
            this.nUA.getContext().finish();
            bf.bua().b(this.nUA.getContext().getPageContext(), new String[]{UrlSchemaHelper.SCHEMA_TYPE_FEED_BACK});
            return true;
        } else {
            return true;
        }
    }

    public void dYD() {
        if (this.nUA != null) {
            this.nUA.showWebViewDelay(500);
        }
    }

    public void bv(String str) {
        if (this.nUA != null) {
            this.nUA.zh(true);
            this.nUA.showWebView(false);
            this.nUA.getWebView().loadUrl(str);
        }
    }

    public void dYE() {
        if (this.nUA != null) {
            this.nUA.showPostThreadLoadingView(false);
        }
    }

    private void dYF() {
        this.nUE = false;
        if (this.nUA != null && this.nUD != null) {
            if (!l.isNetOk()) {
                this.nUA.getContext().showToast(R.string.neterror);
                this.nUA.getContext().finish();
                return;
            }
            this.nUA.showPostThreadLoadingView(true);
            this.nUD.dQD();
        }
    }
}
