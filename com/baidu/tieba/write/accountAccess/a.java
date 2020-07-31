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
    private final b muv;
    private final NewWriteModel muy;
    private boolean muz = false;
    private final NewWriteModel.d eCe = new NewWriteModel.d() { // from class: com.baidu.tieba.write.accountAccess.a.1
        @Override // com.baidu.tieba.tbadkCore.writeModel.NewWriteModel.d
        public void callback(boolean z, PostWriteCallBackData postWriteCallBackData, ad adVar, WriteData writeData, AntiData antiData) {
            if (a.this.muv != null && a.this.muy != null && a.this.muy.dhF() != null) {
                a.this.muv.showPostThreadLoadingView(false);
                WriteData dhF = writeData == null ? a.this.muy.dhF() : writeData;
                if (z) {
                    a.this.muz = true;
                    if (dhF.getType() != 0 || dhF.isUserFeedback()) {
                        if (postWriteCallBackData == null) {
                            c.f(a.this.muv.getContext().getActivity(), a.this.muv.getContext().getResources().getString(R.string.send_success), null, null);
                        } else {
                            c.f(a.this.muv.getContext().getActivity(), postWriteCallBackData.getErrorString(), postWriteCallBackData.getPreMsg(), postWriteCallBackData.getColorMsg());
                        }
                    }
                    Intent intent = new Intent();
                    Bundle bundle = new Bundle();
                    bundle.putSerializable("post_write_callback_data", postWriteCallBackData);
                    intent.putExtras(bundle);
                    BaseActivity context = a.this.muv.getContext();
                    a.this.muv.getContext();
                    context.setResult(-1, intent);
                    a.this.muv.getContext().finish();
                } else if (dhF != null && adVar != null && !TextUtils.isEmpty(adVar.beo())) {
                    dhF.setVcodeMD5(adVar.getVcode_md5());
                    dhF.setVcodeUrl(adVar.getVcode_pic_url());
                    dhF.setVcodeExtra(adVar.bep());
                    a.this.muv.getContext().setVisible(false);
                    if (com.baidu.tbadk.t.a.Ay(adVar.beo())) {
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new NewVcodeActivityConfig(a.this.muv.getContext().getActivity(), RequestResponseCode.REQUEST_VCODE, dhF, false, adVar.beo())));
                    } else {
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new VcodeActivityConfig(a.this.muv.getContext().getActivity(), dhF, RequestResponseCode.REQUEST_VCODE)));
                    }
                } else if (postWriteCallBackData != null && postWriteCallBackData.isSensitiveError()) {
                    Intent intent2 = new Intent();
                    Bundle bundle2 = new Bundle();
                    bundle2.putSerializable("post_write_callback_data", postWriteCallBackData);
                    intent2.putExtras(bundle2);
                    BaseActivity context2 = a.this.muv.getContext();
                    a.this.muv.getContext();
                    context2.setResult(0, intent2);
                    a.this.muv.getContext().finish();
                } else {
                    if (postWriteCallBackData != null) {
                        c.f(a.this.muv.getContext().getActivity(), postWriteCallBackData.getErrorString(), postWriteCallBackData.getPreMsg(), postWriteCallBackData.getColorMsg());
                        BaseActivity context3 = a.this.muv.getContext();
                        a.this.muv.getContext();
                        context3.setResult(0, null);
                    }
                    a.this.muv.getContext().finish();
                }
            }
        }
    };

    public a(b bVar, NewWriteModel newWriteModel) {
        this.muv = bVar;
        this.muy = newWriteModel;
        newWriteModel.b(this.eCe);
    }

    public boolean PD(String str) {
        if (this.muv == null || str == null) {
            return false;
        }
        if (str.equals("http://tieba.baidu.com/account/access/cancel")) {
            this.muv.getContext().finish();
            return true;
        } else if (str.equals("http://tieba.baidu.com/account/access/input_focus")) {
            this.muv.setWebViewMargin(0, UtilHelper.getImmersiveStickyBarHeight(), 0, 0);
            if (this.muv.duu() != this.muv.dut()) {
                this.muv.setRatio(this.muv.duu());
                this.muv.duv();
            }
            this.muv.getWebView().setVisibility(0);
            return true;
        } else if (str.equals("http://tieba.baidu.com/account/access/valid_success")) {
            dus();
            return true;
        } else if (str.equals("http://tieba.baidu.com/account/access/feedback") || str.equals("https://tieba.baidu.com/account/access/feedback")) {
            this.muv.getContext().finish();
            bd.baV().b(this.muv.getContext().getPageContext(), new String[]{UrlSchemaHelper.SCHEMA_TYPE_FEED_BACK});
            return true;
        } else {
            return true;
        }
    }

    public void duq() {
        if (this.muv != null) {
            this.muv.showWebViewDelay(500);
        }
    }

    public void bl(String str) {
        if (this.muv != null) {
            this.muv.wo(true);
            this.muv.showWebView(false);
            this.muv.getWebView().loadUrl(str);
        }
    }

    public void dur() {
        if (this.muv != null) {
            this.muv.showPostThreadLoadingView(false);
        }
    }

    private void dus() {
        this.muz = false;
        if (this.muv != null && this.muy != null) {
            if (!l.isNetOk()) {
                this.muv.getContext().showToast(R.string.neterror);
                this.muv.getContext().finish();
                return;
            }
            this.muv.showPostThreadLoadingView(true);
            this.muy.dmw();
        }
    }
}
