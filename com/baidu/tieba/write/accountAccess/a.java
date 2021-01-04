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
    private final b nXX;
    private final NewWriteModel nYa;
    private boolean nYb = false;
    private final NewWriteModel.d fGo = new NewWriteModel.d() { // from class: com.baidu.tieba.write.accountAccess.a.1
        @Override // com.baidu.tieba.tbadkCore.writeModel.NewWriteModel.d
        public void callback(boolean z, PostWriteCallBackData postWriteCallBackData, ah ahVar, WriteData writeData, AntiData antiData) {
            if (a.this.nXX != null && a.this.nYa != null && a.this.nYa.dco() != null) {
                a.this.nXX.showPostThreadLoadingView(false);
                WriteData dco = writeData == null ? a.this.nYa.dco() : writeData;
                if (z) {
                    a.this.nYb = true;
                    if (dco.getType() != 0 || dco.isUserFeedback()) {
                        if (postWriteCallBackData == null) {
                            g.i(a.this.nXX.getContext().getActivity(), a.this.nXX.getContext().getResources().getString(R.string.send_success), null, null);
                        } else {
                            g.i(a.this.nXX.getContext().getActivity(), postWriteCallBackData.getErrorString(), postWriteCallBackData.getPreMsg(), postWriteCallBackData.getColorMsg());
                        }
                    }
                    Intent intent = new Intent();
                    Bundle bundle = new Bundle();
                    bundle.putSerializable("post_write_callback_data", postWriteCallBackData);
                    intent.putExtras(bundle);
                    BaseActivity context = a.this.nXX.getContext();
                    a.this.nXX.getContext();
                    context.setResult(-1, intent);
                    a.this.nXX.getContext().finish();
                } else if (dco != null && ahVar != null && !TextUtils.isEmpty(ahVar.bAf())) {
                    dco.setVcodeMD5(ahVar.getVcode_md5());
                    dco.setVcodeUrl(ahVar.getVcode_pic_url());
                    dco.setVcodeExtra(ahVar.bAg());
                    a.this.nXX.getContext().setVisible(false);
                    if (com.baidu.tbadk.t.a.EQ(ahVar.bAf())) {
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new NewVcodeActivityConfig(a.this.nXX.getContext().getActivity(), RequestResponseCode.REQUEST_VCODE, dco, false, ahVar.bAf())));
                    } else {
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new VcodeActivityConfig(a.this.nXX.getContext().getActivity(), dco, RequestResponseCode.REQUEST_VCODE)));
                    }
                } else if (postWriteCallBackData != null && postWriteCallBackData.isSensitiveError()) {
                    Intent intent2 = new Intent();
                    Bundle bundle2 = new Bundle();
                    bundle2.putSerializable("post_write_callback_data", postWriteCallBackData);
                    intent2.putExtras(bundle2);
                    BaseActivity context2 = a.this.nXX.getContext();
                    a.this.nXX.getContext();
                    context2.setResult(0, intent2);
                    a.this.nXX.getContext().finish();
                } else {
                    if (postWriteCallBackData != null) {
                        g.i(a.this.nXX.getContext().getActivity(), postWriteCallBackData.getErrorString(), postWriteCallBackData.getPreMsg(), postWriteCallBackData.getColorMsg());
                        BaseActivity context3 = a.this.nXX.getContext();
                        a.this.nXX.getContext();
                        context3.setResult(0, null);
                    }
                    a.this.nXX.getContext().finish();
                }
            }
        }
    };

    public a(b bVar, NewWriteModel newWriteModel) {
        this.nXX = bVar;
        this.nYa = newWriteModel;
        newWriteModel.b(this.fGo);
    }

    public boolean Vk(String str) {
        if (this.nXX == null || str == null) {
            return false;
        }
        if (str.equals("http://tieba.baidu.com/account/access/cancel")) {
            this.nXX.getContext().finish();
            return true;
        } else if (str.equals("http://tieba.baidu.com/account/access/input_focus")) {
            this.nXX.setWebViewMargin(0, UtilHelper.getImmersiveStickyBarHeight(), 0, 0);
            if (this.nXX.dYl() != this.nXX.getRatio()) {
                this.nXX.setRatio(this.nXX.dYl());
                this.nXX.dYm();
            }
            this.nXX.getWebView().setVisibility(0);
            return true;
        } else if (str.equals("http://tieba.baidu.com/account/access/valid_success")) {
            dYk();
            return true;
        } else if (str.equals("http://tieba.baidu.com/account/access/feedback") || str.equals("https://tieba.baidu.com/account/access/feedback")) {
            this.nXX.getContext().finish();
            be.bwu().b(this.nXX.getContext().getPageContext(), new String[]{UrlSchemaHelper.SCHEMA_TYPE_FEED_BACK});
            return true;
        } else {
            return true;
        }
    }

    public void dYi() {
        if (this.nXX != null) {
            this.nXX.showWebViewDelay(500);
        }
    }

    public void start(String str) {
        if (this.nXX != null) {
            this.nXX.zi(true);
            this.nXX.showWebView(false);
            this.nXX.getWebView().loadUrl(str);
        }
    }

    public void dYj() {
        if (this.nXX != null) {
            this.nXX.showPostThreadLoadingView(false);
        }
    }

    private void dYk() {
        this.nYb = false;
        if (this.nXX != null && this.nYa != null) {
            if (!l.isNetOk()) {
                this.nXX.getContext().showToast(R.string.neterror);
                this.nXX.getContext().finish();
                return;
            }
            this.nXX.showPostThreadLoadingView(true);
            this.nYa.dQB();
        }
    }
}
