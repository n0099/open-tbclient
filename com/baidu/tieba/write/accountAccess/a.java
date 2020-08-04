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
import com.baidu.tbadk.core.util.bd;
import com.baidu.tbadk.coreExtra.data.WriteData;
import com.baidu.tbadk.coreExtra.data.ad;
import com.baidu.tieba.R;
import com.baidu.tieba.tbadkCore.writeModel.NewWriteModel;
import com.baidu.tieba.tbadkCore.writeModel.PostWriteCallBackData;
import com.baidu.tieba.tbadkCore.writeModel.c;
/* loaded from: classes3.dex */
public class a {
    private final NewWriteModel muA;
    private final b mux;
    private boolean muB = false;
    private final NewWriteModel.d eCe = new NewWriteModel.d() { // from class: com.baidu.tieba.write.accountAccess.a.1
        @Override // com.baidu.tieba.tbadkCore.writeModel.NewWriteModel.d
        public void callback(boolean z, PostWriteCallBackData postWriteCallBackData, ad adVar, WriteData writeData, AntiData antiData) {
            if (a.this.mux != null && a.this.muA != null && a.this.muA.dhF() != null) {
                a.this.mux.showPostThreadLoadingView(false);
                WriteData dhF = writeData == null ? a.this.muA.dhF() : writeData;
                if (z) {
                    a.this.muB = true;
                    if (dhF.getType() != 0 || dhF.isUserFeedback()) {
                        if (postWriteCallBackData == null) {
                            c.f(a.this.mux.getContext().getActivity(), a.this.mux.getContext().getResources().getString(R.string.send_success), null, null);
                        } else {
                            c.f(a.this.mux.getContext().getActivity(), postWriteCallBackData.getErrorString(), postWriteCallBackData.getPreMsg(), postWriteCallBackData.getColorMsg());
                        }
                    }
                    Intent intent = new Intent();
                    Bundle bundle = new Bundle();
                    bundle.putSerializable("post_write_callback_data", postWriteCallBackData);
                    intent.putExtras(bundle);
                    BaseActivity context = a.this.mux.getContext();
                    a.this.mux.getContext();
                    context.setResult(-1, intent);
                    a.this.mux.getContext().finish();
                } else if (dhF != null && adVar != null && !TextUtils.isEmpty(adVar.beo())) {
                    dhF.setVcodeMD5(adVar.getVcode_md5());
                    dhF.setVcodeUrl(adVar.getVcode_pic_url());
                    dhF.setVcodeExtra(adVar.bep());
                    a.this.mux.getContext().setVisible(false);
                    if (com.baidu.tbadk.t.a.Ay(adVar.beo())) {
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new NewVcodeActivityConfig(a.this.mux.getContext().getActivity(), RequestResponseCode.REQUEST_VCODE, dhF, false, adVar.beo())));
                    } else {
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new VcodeActivityConfig(a.this.mux.getContext().getActivity(), dhF, RequestResponseCode.REQUEST_VCODE)));
                    }
                } else if (postWriteCallBackData != null && postWriteCallBackData.isSensitiveError()) {
                    Intent intent2 = new Intent();
                    Bundle bundle2 = new Bundle();
                    bundle2.putSerializable("post_write_callback_data", postWriteCallBackData);
                    intent2.putExtras(bundle2);
                    BaseActivity context2 = a.this.mux.getContext();
                    a.this.mux.getContext();
                    context2.setResult(0, intent2);
                    a.this.mux.getContext().finish();
                } else {
                    if (postWriteCallBackData != null) {
                        c.f(a.this.mux.getContext().getActivity(), postWriteCallBackData.getErrorString(), postWriteCallBackData.getPreMsg(), postWriteCallBackData.getColorMsg());
                        BaseActivity context3 = a.this.mux.getContext();
                        a.this.mux.getContext();
                        context3.setResult(0, null);
                    }
                    a.this.mux.getContext().finish();
                }
            }
        }
    };

    public a(b bVar, NewWriteModel newWriteModel) {
        this.mux = bVar;
        this.muA = newWriteModel;
        newWriteModel.b(this.eCe);
    }

    public boolean PD(String str) {
        if (this.mux == null || str == null) {
            return false;
        }
        if (str.equals("http://tieba.baidu.com/account/access/cancel")) {
            this.mux.getContext().finish();
            return true;
        } else if (str.equals("http://tieba.baidu.com/account/access/input_focus")) {
            this.mux.setWebViewMargin(0, UtilHelper.getImmersiveStickyBarHeight(), 0, 0);
            if (this.mux.duv() != this.mux.duu()) {
                this.mux.setRatio(this.mux.duv());
                this.mux.duw();
            }
            this.mux.getWebView().setVisibility(0);
            return true;
        } else if (str.equals("http://tieba.baidu.com/account/access/valid_success")) {
            dut();
            return true;
        } else if (str.equals("http://tieba.baidu.com/account/access/feedback") || str.equals("https://tieba.baidu.com/account/access/feedback")) {
            this.mux.getContext().finish();
            bd.baV().b(this.mux.getContext().getPageContext(), new String[]{UrlSchemaHelper.SCHEMA_TYPE_FEED_BACK});
            return true;
        } else {
            return true;
        }
    }

    public void dur() {
        if (this.mux != null) {
            this.mux.showWebViewDelay(500);
        }
    }

    public void bl(String str) {
        if (this.mux != null) {
            this.mux.wo(true);
            this.mux.showWebView(false);
            this.mux.getWebView().loadUrl(str);
        }
    }

    public void dus() {
        if (this.mux != null) {
            this.mux.showPostThreadLoadingView(false);
        }
    }

    private void dut() {
        this.muB = false;
        if (this.mux != null && this.muA != null) {
            if (!l.isNetOk()) {
                this.mux.getContext().showToast(R.string.neterror);
                this.mux.getContext().finish();
                return;
            }
            this.mux.showPostThreadLoadingView(true);
            this.muA.dmx();
        }
    }
}
