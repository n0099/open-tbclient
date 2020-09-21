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
    private final b mXa;
    private final NewWriteModel mXd;
    private boolean mXe = false;
    private final NewWriteModel.d ePy = new NewWriteModel.d() { // from class: com.baidu.tieba.write.accountAccess.a.1
        @Override // com.baidu.tieba.tbadkCore.writeModel.NewWriteModel.d
        public void callback(boolean z, PostWriteCallBackData postWriteCallBackData, ah ahVar, WriteData writeData, AntiData antiData) {
            if (a.this.mXa != null && a.this.mXd != null && a.this.mXd.cOG() != null) {
                a.this.mXa.showPostThreadLoadingView(false);
                WriteData cOG = writeData == null ? a.this.mXd.cOG() : writeData;
                if (z) {
                    a.this.mXe = true;
                    if (cOG.getType() != 0 || cOG.isUserFeedback()) {
                        if (postWriteCallBackData == null) {
                            c.g(a.this.mXa.getContext().getActivity(), a.this.mXa.getContext().getResources().getString(R.string.send_success), null, null);
                        } else {
                            c.g(a.this.mXa.getContext().getActivity(), postWriteCallBackData.getErrorString(), postWriteCallBackData.getPreMsg(), postWriteCallBackData.getColorMsg());
                        }
                    }
                    Intent intent = new Intent();
                    Bundle bundle = new Bundle();
                    bundle.putSerializable("post_write_callback_data", postWriteCallBackData);
                    intent.putExtras(bundle);
                    BaseActivity context = a.this.mXa.getContext();
                    a.this.mXa.getContext();
                    context.setResult(-1, intent);
                    a.this.mXa.getContext().finish();
                } else if (cOG != null && ahVar != null && !TextUtils.isEmpty(ahVar.bnS())) {
                    cOG.setVcodeMD5(ahVar.getVcode_md5());
                    cOG.setVcodeUrl(ahVar.getVcode_pic_url());
                    cOG.setVcodeExtra(ahVar.bnT());
                    a.this.mXa.getContext().setVisible(false);
                    if (com.baidu.tbadk.t.a.Dl(ahVar.bnS())) {
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new NewVcodeActivityConfig(a.this.mXa.getContext().getActivity(), RequestResponseCode.REQUEST_VCODE, cOG, false, ahVar.bnS())));
                    } else {
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new VcodeActivityConfig(a.this.mXa.getContext().getActivity(), cOG, RequestResponseCode.REQUEST_VCODE)));
                    }
                } else if (postWriteCallBackData != null && postWriteCallBackData.isSensitiveError()) {
                    Intent intent2 = new Intent();
                    Bundle bundle2 = new Bundle();
                    bundle2.putSerializable("post_write_callback_data", postWriteCallBackData);
                    intent2.putExtras(bundle2);
                    BaseActivity context2 = a.this.mXa.getContext();
                    a.this.mXa.getContext();
                    context2.setResult(0, intent2);
                    a.this.mXa.getContext().finish();
                } else {
                    if (postWriteCallBackData != null) {
                        c.g(a.this.mXa.getContext().getActivity(), postWriteCallBackData.getErrorString(), postWriteCallBackData.getPreMsg(), postWriteCallBackData.getColorMsg());
                        BaseActivity context3 = a.this.mXa.getContext();
                        a.this.mXa.getContext();
                        context3.setResult(0, null);
                    }
                    a.this.mXa.getContext().finish();
                }
            }
        }
    };

    public a(b bVar, NewWriteModel newWriteModel) {
        this.mXa = bVar;
        this.mXd = newWriteModel;
        newWriteModel.b(this.ePy);
    }

    public boolean Tb(String str) {
        if (this.mXa == null || str == null) {
            return false;
        }
        if (str.equals("http://tieba.baidu.com/account/access/cancel")) {
            this.mXa.getContext().finish();
            return true;
        } else if (str.equals("http://tieba.baidu.com/account/access/input_focus")) {
            this.mXa.setWebViewMargin(0, UtilHelper.getImmersiveStickyBarHeight(), 0, 0);
            if (this.mXa.dJU() != this.mXa.dJT()) {
                this.mXa.setRatio(this.mXa.dJU());
                this.mXa.dJV();
            }
            this.mXa.getWebView().setVisibility(0);
            return true;
        } else if (str.equals("http://tieba.baidu.com/account/access/valid_success")) {
            dJS();
            return true;
        } else if (str.equals("http://tieba.baidu.com/account/access/feedback") || str.equals("https://tieba.baidu.com/account/access/feedback")) {
            this.mXa.getContext().finish();
            be.bkp().b(this.mXa.getContext().getPageContext(), new String[]{UrlSchemaHelper.SCHEMA_TYPE_FEED_BACK});
            return true;
        } else {
            return true;
        }
    }

    public void dJQ() {
        if (this.mXa != null) {
            this.mXa.showWebViewDelay(500);
        }
    }

    public void bs(String str) {
        if (this.mXa != null) {
            this.mXa.xo(true);
            this.mXa.showWebView(false);
            this.mXa.getWebView().loadUrl(str);
        }
    }

    public void dJR() {
        if (this.mXa != null) {
            this.mXa.showPostThreadLoadingView(false);
        }
    }

    private void dJS() {
        this.mXe = false;
        if (this.mXa != null && this.mXd != null) {
            if (!l.isNetOk()) {
                this.mXa.getContext().showToast(R.string.neterror);
                this.mXa.getContext().finish();
                return;
            }
            this.mXa.showPostThreadLoadingView(true);
            this.mXd.dBQ();
        }
    }
}
