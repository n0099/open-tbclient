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
import com.baidu.tbadk.core.util.ba;
import com.baidu.tbadk.coreExtra.data.WriteData;
import com.baidu.tbadk.coreExtra.data.y;
import com.baidu.tieba.R;
import com.baidu.tieba.tbadkCore.writeModel.NewWriteModel;
import com.baidu.tieba.tbadkCore.writeModel.PostWriteCallBackData;
import com.baidu.tieba.tbadkCore.writeModel.c;
/* loaded from: classes3.dex */
public class a {
    private final b jOh;
    private final NewWriteModel jOl;
    private boolean jOm = false;
    private final NewWriteModel.d cHf = new NewWriteModel.d() { // from class: com.baidu.tieba.write.accountAccess.a.1
        @Override // com.baidu.tieba.tbadkCore.writeModel.NewWriteModel.d
        public void callback(boolean z, PostWriteCallBackData postWriteCallBackData, y yVar, WriteData writeData, AntiData antiData) {
            if (a.this.jOh != null && a.this.jOl != null && a.this.jOl.clc() != null) {
                a.this.jOh.showPostThreadLoadingView(false);
                WriteData clc = writeData == null ? a.this.jOl.clc() : writeData;
                if (z) {
                    a.this.jOm = true;
                    if (clc.getType() != 0 || clc.isUserFeedback()) {
                        if (postWriteCallBackData == null) {
                            c.g(a.this.jOh.getContext().getActivity(), a.this.jOh.getContext().getResources().getString(R.string.send_success), null, null);
                        } else {
                            c.g(a.this.jOh.getContext().getActivity(), postWriteCallBackData.getErrorString(), postWriteCallBackData.getPreMsg(), postWriteCallBackData.getColorMsg());
                        }
                    }
                    Intent intent = new Intent();
                    Bundle bundle = new Bundle();
                    bundle.putSerializable("post_write_callback_data", postWriteCallBackData);
                    intent.putExtras(bundle);
                    BaseActivity context = a.this.jOh.getContext();
                    a.this.jOh.getContext();
                    context.setResult(-1, intent);
                    a.this.jOh.getContext().finish();
                } else if (clc != null && yVar != null && !TextUtils.isEmpty(yVar.apt())) {
                    clc.setVcodeMD5(yVar.getVcode_md5());
                    clc.setVcodeUrl(yVar.getVcode_pic_url());
                    clc.setVcodeExtra(yVar.apu());
                    a.this.jOh.getContext().setVisible(false);
                    if (com.baidu.tbadk.v.a.qv(yVar.apt())) {
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new NewVcodeActivityConfig(a.this.jOh.getContext().getActivity(), RequestResponseCode.REQUEST_VCODE, clc, false, yVar.apt())));
                    } else {
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new VcodeActivityConfig(a.this.jOh.getContext().getActivity(), clc, RequestResponseCode.REQUEST_VCODE)));
                    }
                } else if (postWriteCallBackData != null && postWriteCallBackData.isSensitiveError()) {
                    Intent intent2 = new Intent();
                    Bundle bundle2 = new Bundle();
                    bundle2.putSerializable("post_write_callback_data", postWriteCallBackData);
                    intent2.putExtras(bundle2);
                    BaseActivity context2 = a.this.jOh.getContext();
                    a.this.jOh.getContext();
                    context2.setResult(0, intent2);
                    a.this.jOh.getContext().finish();
                } else {
                    if (postWriteCallBackData != null) {
                        c.g(a.this.jOh.getContext().getActivity(), postWriteCallBackData.getErrorString(), postWriteCallBackData.getPreMsg(), postWriteCallBackData.getColorMsg());
                        BaseActivity context3 = a.this.jOh.getContext();
                        a.this.jOh.getContext();
                        context3.setResult(0, null);
                    }
                    a.this.jOh.getContext().finish();
                }
            }
        }
    };

    public a(b bVar, NewWriteModel newWriteModel) {
        this.jOh = bVar;
        this.jOl = newWriteModel;
        newWriteModel.b(this.cHf);
    }

    public boolean Fz(String str) {
        if (this.jOh == null || str == null) {
            return false;
        }
        if (str.equals("http://tieba.baidu.com/account/access/cancel")) {
            this.jOh.getContext().finish();
            return true;
        } else if (str.equals("http://tieba.baidu.com/account/access/input_focus")) {
            this.jOh.C(0, UtilHelper.getImmersiveStickyBarHeight(), 0, 0);
            if (this.jOh.cyb() != this.jOh.dy()) {
                this.jOh.setRatio(this.jOh.cyb());
                this.jOh.cyc();
            }
            this.jOh.getWebView().setVisibility(0);
            return true;
        } else if (str.equals("http://tieba.baidu.com/account/access/valid_success")) {
            cya();
            return true;
        } else if (str.equals("http://tieba.baidu.com/account/access/feedback") || str.equals("https://tieba.baidu.com/account/access/feedback")) {
            this.jOh.getContext().finish();
            ba.amQ().b(this.jOh.getContext().getPageContext(), new String[]{UrlSchemaHelper.SCHEMA_TYPE_FEED_BACK});
            return true;
        } else {
            return true;
        }
    }

    public void cxY() {
        if (this.jOh != null) {
            this.jOh.showWebViewDelay(500);
        }
    }

    public void P(String str) {
        if (this.jOh != null) {
            this.jOh.rP(true);
            this.jOh.showWebView(false);
            this.jOh.getWebView().loadUrl(str);
        }
    }

    public void cxZ() {
        if (this.jOh != null) {
            this.jOh.showPostThreadLoadingView(false);
        }
    }

    private void cya() {
        this.jOm = false;
        if (this.jOh != null && this.jOl != null) {
            if (!l.isNetOk()) {
                this.jOh.getContext().showToast(R.string.neterror);
                this.jOh.getContext().finish();
                return;
            }
            this.jOh.showPostThreadLoadingView(true);
            this.jOl.cpE();
        }
    }
}
