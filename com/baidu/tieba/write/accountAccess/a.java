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
import com.baidu.tbadk.core.util.bc;
import com.baidu.tbadk.coreExtra.data.WriteData;
import com.baidu.tbadk.coreExtra.data.ad;
import com.baidu.tieba.R;
import com.baidu.tieba.tbadkCore.writeModel.NewWriteModel;
import com.baidu.tieba.tbadkCore.writeModel.PostWriteCallBackData;
import com.baidu.tieba.tbadkCore.writeModel.c;
/* loaded from: classes2.dex */
public class a {
    private final b mms;
    private final NewWriteModel mmv;
    private boolean mmw = false;
    private final NewWriteModel.d evL = new NewWriteModel.d() { // from class: com.baidu.tieba.write.accountAccess.a.1
        @Override // com.baidu.tieba.tbadkCore.writeModel.NewWriteModel.d
        public void callback(boolean z, PostWriteCallBackData postWriteCallBackData, ad adVar, WriteData writeData, AntiData antiData) {
            if (a.this.mms != null && a.this.mmv != null && a.this.mmv.dev() != null) {
                a.this.mms.showPostThreadLoadingView(false);
                WriteData dev = writeData == null ? a.this.mmv.dev() : writeData;
                if (z) {
                    a.this.mmw = true;
                    if (dev.getType() != 0 || dev.isUserFeedback()) {
                        if (postWriteCallBackData == null) {
                            c.f(a.this.mms.getContext().getActivity(), a.this.mms.getContext().getResources().getString(R.string.send_success), null, null);
                        } else {
                            c.f(a.this.mms.getContext().getActivity(), postWriteCallBackData.getErrorString(), postWriteCallBackData.getPreMsg(), postWriteCallBackData.getColorMsg());
                        }
                    }
                    Intent intent = new Intent();
                    Bundle bundle = new Bundle();
                    bundle.putSerializable("post_write_callback_data", postWriteCallBackData);
                    intent.putExtras(bundle);
                    BaseActivity context = a.this.mms.getContext();
                    a.this.mms.getContext();
                    context.setResult(-1, intent);
                    a.this.mms.getContext().finish();
                } else if (dev != null && adVar != null && !TextUtils.isEmpty(adVar.bar())) {
                    dev.setVcodeMD5(adVar.getVcode_md5());
                    dev.setVcodeUrl(adVar.getVcode_pic_url());
                    dev.setVcodeExtra(adVar.bas());
                    a.this.mms.getContext().setVisible(false);
                    if (com.baidu.tbadk.t.a.zq(adVar.bar())) {
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new NewVcodeActivityConfig(a.this.mms.getContext().getActivity(), RequestResponseCode.REQUEST_VCODE, dev, false, adVar.bar())));
                    } else {
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new VcodeActivityConfig(a.this.mms.getContext().getActivity(), dev, RequestResponseCode.REQUEST_VCODE)));
                    }
                } else if (postWriteCallBackData != null && postWriteCallBackData.isSensitiveError()) {
                    Intent intent2 = new Intent();
                    Bundle bundle2 = new Bundle();
                    bundle2.putSerializable("post_write_callback_data", postWriteCallBackData);
                    intent2.putExtras(bundle2);
                    BaseActivity context2 = a.this.mms.getContext();
                    a.this.mms.getContext();
                    context2.setResult(0, intent2);
                    a.this.mms.getContext().finish();
                } else {
                    if (postWriteCallBackData != null) {
                        c.f(a.this.mms.getContext().getActivity(), postWriteCallBackData.getErrorString(), postWriteCallBackData.getPreMsg(), postWriteCallBackData.getColorMsg());
                        BaseActivity context3 = a.this.mms.getContext();
                        a.this.mms.getContext();
                        context3.setResult(0, null);
                    }
                    a.this.mms.getContext().finish();
                }
            }
        }
    };

    public a(b bVar, NewWriteModel newWriteModel) {
        this.mms = bVar;
        this.mmv = newWriteModel;
        newWriteModel.b(this.evL);
    }

    public boolean OR(String str) {
        if (this.mms == null || str == null) {
            return false;
        }
        if (str.equals("http://tieba.baidu.com/account/access/cancel")) {
            this.mms.getContext().finish();
            return true;
        } else if (str.equals("http://tieba.baidu.com/account/access/input_focus")) {
            this.mms.setWebViewMargin(0, UtilHelper.getImmersiveStickyBarHeight(), 0, 0);
            if (this.mms.dre() != this.mms.drd()) {
                this.mms.setRatio(this.mms.dre());
                this.mms.drf();
            }
            this.mms.getWebView().setVisibility(0);
            return true;
        } else if (str.equals("http://tieba.baidu.com/account/access/valid_success")) {
            drc();
            return true;
        } else if (str.equals("http://tieba.baidu.com/account/access/feedback") || str.equals("https://tieba.baidu.com/account/access/feedback")) {
            this.mms.getContext().finish();
            bc.aWU().b(this.mms.getContext().getPageContext(), new String[]{UrlSchemaHelper.SCHEMA_TYPE_FEED_BACK});
            return true;
        } else {
            return true;
        }
    }

    public void dra() {
        if (this.mms != null) {
            this.mms.showWebViewDelay(500);
        }
    }

    public void bl(String str) {
        if (this.mms != null) {
            this.mms.vK(true);
            this.mms.showWebView(false);
            this.mms.getWebView().loadUrl(str);
        }
    }

    public void drb() {
        if (this.mms != null) {
            this.mms.showPostThreadLoadingView(false);
        }
    }

    private void drc() {
        this.mmw = false;
        if (this.mms != null && this.mmv != null) {
            if (!l.isNetOk()) {
                this.mms.getContext().showToast(R.string.neterror);
                this.mms.getContext().finish();
                return;
            }
            this.mms.showPostThreadLoadingView(true);
            this.mmv.djn();
        }
    }
}
