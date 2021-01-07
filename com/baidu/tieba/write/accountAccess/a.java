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
import com.baidu.tieba.tbadkCore.writeModel.g;
/* loaded from: classes8.dex */
public class a {
    private final b nXW;
    private final NewWriteModel nXZ;
    private boolean nYa = false;
    private final NewWriteModel.d fGo = new NewWriteModel.d() { // from class: com.baidu.tieba.write.accountAccess.a.1
        @Override // com.baidu.tieba.tbadkCore.writeModel.NewWriteModel.d
        public void callback(boolean z, PostWriteCallBackData postWriteCallBackData, ah ahVar, WriteData writeData, AntiData antiData) {
            if (a.this.nXW != null && a.this.nXZ != null && a.this.nXZ.dcp() != null) {
                a.this.nXW.showPostThreadLoadingView(false);
                WriteData dcp = writeData == null ? a.this.nXZ.dcp() : writeData;
                if (z) {
                    a.this.nYa = true;
                    if (dcp.getType() != 0 || dcp.isUserFeedback()) {
                        if (postWriteCallBackData == null) {
                            g.i(a.this.nXW.getContext().getActivity(), a.this.nXW.getContext().getResources().getString(R.string.send_success), null, null);
                        } else {
                            g.i(a.this.nXW.getContext().getActivity(), postWriteCallBackData.getErrorString(), postWriteCallBackData.getPreMsg(), postWriteCallBackData.getColorMsg());
                        }
                    }
                    Intent intent = new Intent();
                    Bundle bundle = new Bundle();
                    bundle.putSerializable("post_write_callback_data", postWriteCallBackData);
                    intent.putExtras(bundle);
                    BaseActivity context = a.this.nXW.getContext();
                    a.this.nXW.getContext();
                    context.setResult(-1, intent);
                    a.this.nXW.getContext().finish();
                } else if (dcp != null && ahVar != null && !TextUtils.isEmpty(ahVar.bAg())) {
                    dcp.setVcodeMD5(ahVar.getVcode_md5());
                    dcp.setVcodeUrl(ahVar.getVcode_pic_url());
                    dcp.setVcodeExtra(ahVar.bAh());
                    a.this.nXW.getContext().setVisible(false);
                    if (com.baidu.tbadk.t.a.EP(ahVar.bAg())) {
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new NewVcodeActivityConfig(a.this.nXW.getContext().getActivity(), RequestResponseCode.REQUEST_VCODE, dcp, false, ahVar.bAg())));
                    } else {
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new VcodeActivityConfig(a.this.nXW.getContext().getActivity(), dcp, RequestResponseCode.REQUEST_VCODE)));
                    }
                } else if (postWriteCallBackData != null && postWriteCallBackData.isSensitiveError()) {
                    Intent intent2 = new Intent();
                    Bundle bundle2 = new Bundle();
                    bundle2.putSerializable("post_write_callback_data", postWriteCallBackData);
                    intent2.putExtras(bundle2);
                    BaseActivity context2 = a.this.nXW.getContext();
                    a.this.nXW.getContext();
                    context2.setResult(0, intent2);
                    a.this.nXW.getContext().finish();
                } else {
                    if (postWriteCallBackData != null) {
                        g.i(a.this.nXW.getContext().getActivity(), postWriteCallBackData.getErrorString(), postWriteCallBackData.getPreMsg(), postWriteCallBackData.getColorMsg());
                        BaseActivity context3 = a.this.nXW.getContext();
                        a.this.nXW.getContext();
                        context3.setResult(0, null);
                    }
                    a.this.nXW.getContext().finish();
                }
            }
        }
    };

    public a(b bVar, NewWriteModel newWriteModel) {
        this.nXW = bVar;
        this.nXZ = newWriteModel;
        newWriteModel.b(this.fGo);
    }

    public boolean Vj(String str) {
        if (this.nXW == null || str == null) {
            return false;
        }
        if (str.equals("http://tieba.baidu.com/account/access/cancel")) {
            this.nXW.getContext().finish();
            return true;
        } else if (str.equals("http://tieba.baidu.com/account/access/input_focus")) {
            this.nXW.setWebViewMargin(0, UtilHelper.getImmersiveStickyBarHeight(), 0, 0);
            if (this.nXW.dYm() != this.nXW.getRatio()) {
                this.nXW.setRatio(this.nXW.dYm());
                this.nXW.dYn();
            }
            this.nXW.getWebView().setVisibility(0);
            return true;
        } else if (str.equals("http://tieba.baidu.com/account/access/valid_success")) {
            dYl();
            return true;
        } else if (str.equals("http://tieba.baidu.com/account/access/feedback") || str.equals("https://tieba.baidu.com/account/access/feedback")) {
            this.nXW.getContext().finish();
            be.bwv().b(this.nXW.getContext().getPageContext(), new String[]{UrlSchemaHelper.SCHEMA_TYPE_FEED_BACK});
            return true;
        } else {
            return true;
        }
    }

    public void dYj() {
        if (this.nXW != null) {
            this.nXW.showWebViewDelay(500);
        }
    }

    public void start(String str) {
        if (this.nXW != null) {
            this.nXW.zi(true);
            this.nXW.showWebView(false);
            this.nXW.getWebView().loadUrl(str);
        }
    }

    public void dYk() {
        if (this.nXW != null) {
            this.nXW.showPostThreadLoadingView(false);
        }
    }

    private void dYl() {
        this.nYa = false;
        if (this.nXW != null && this.nXZ != null) {
            if (!l.isNetOk()) {
                this.nXW.getContext().showToast(R.string.neterror);
                this.nXW.getContext().finish();
                return;
            }
            this.nXW.showPostThreadLoadingView(true);
            this.nXZ.dQC();
        }
    }
}
