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
    private final b mmv;
    private final NewWriteModel mmy;
    private boolean mmz = false;
    private final NewWriteModel.d evL = new NewWriteModel.d() { // from class: com.baidu.tieba.write.accountAccess.a.1
        @Override // com.baidu.tieba.tbadkCore.writeModel.NewWriteModel.d
        public void callback(boolean z, PostWriteCallBackData postWriteCallBackData, ad adVar, WriteData writeData, AntiData antiData) {
            if (a.this.mmv != null && a.this.mmy != null && a.this.mmy.dew() != null) {
                a.this.mmv.showPostThreadLoadingView(false);
                WriteData dew = writeData == null ? a.this.mmy.dew() : writeData;
                if (z) {
                    a.this.mmz = true;
                    if (dew.getType() != 0 || dew.isUserFeedback()) {
                        if (postWriteCallBackData == null) {
                            c.f(a.this.mmv.getContext().getActivity(), a.this.mmv.getContext().getResources().getString(R.string.send_success), null, null);
                        } else {
                            c.f(a.this.mmv.getContext().getActivity(), postWriteCallBackData.getErrorString(), postWriteCallBackData.getPreMsg(), postWriteCallBackData.getColorMsg());
                        }
                    }
                    Intent intent = new Intent();
                    Bundle bundle = new Bundle();
                    bundle.putSerializable("post_write_callback_data", postWriteCallBackData);
                    intent.putExtras(bundle);
                    BaseActivity context = a.this.mmv.getContext();
                    a.this.mmv.getContext();
                    context.setResult(-1, intent);
                    a.this.mmv.getContext().finish();
                } else if (dew != null && adVar != null && !TextUtils.isEmpty(adVar.bar())) {
                    dew.setVcodeMD5(adVar.getVcode_md5());
                    dew.setVcodeUrl(adVar.getVcode_pic_url());
                    dew.setVcodeExtra(adVar.bas());
                    a.this.mmv.getContext().setVisible(false);
                    if (com.baidu.tbadk.t.a.zq(adVar.bar())) {
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new NewVcodeActivityConfig(a.this.mmv.getContext().getActivity(), RequestResponseCode.REQUEST_VCODE, dew, false, adVar.bar())));
                    } else {
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new VcodeActivityConfig(a.this.mmv.getContext().getActivity(), dew, RequestResponseCode.REQUEST_VCODE)));
                    }
                } else if (postWriteCallBackData != null && postWriteCallBackData.isSensitiveError()) {
                    Intent intent2 = new Intent();
                    Bundle bundle2 = new Bundle();
                    bundle2.putSerializable("post_write_callback_data", postWriteCallBackData);
                    intent2.putExtras(bundle2);
                    BaseActivity context2 = a.this.mmv.getContext();
                    a.this.mmv.getContext();
                    context2.setResult(0, intent2);
                    a.this.mmv.getContext().finish();
                } else {
                    if (postWriteCallBackData != null) {
                        c.f(a.this.mmv.getContext().getActivity(), postWriteCallBackData.getErrorString(), postWriteCallBackData.getPreMsg(), postWriteCallBackData.getColorMsg());
                        BaseActivity context3 = a.this.mmv.getContext();
                        a.this.mmv.getContext();
                        context3.setResult(0, null);
                    }
                    a.this.mmv.getContext().finish();
                }
            }
        }
    };

    public a(b bVar, NewWriteModel newWriteModel) {
        this.mmv = bVar;
        this.mmy = newWriteModel;
        newWriteModel.b(this.evL);
    }

    public boolean OS(String str) {
        if (this.mmv == null || str == null) {
            return false;
        }
        if (str.equals("http://tieba.baidu.com/account/access/cancel")) {
            this.mmv.getContext().finish();
            return true;
        } else if (str.equals("http://tieba.baidu.com/account/access/input_focus")) {
            this.mmv.setWebViewMargin(0, UtilHelper.getImmersiveStickyBarHeight(), 0, 0);
            if (this.mmv.dri() != this.mmv.drh()) {
                this.mmv.setRatio(this.mmv.dri());
                this.mmv.drj();
            }
            this.mmv.getWebView().setVisibility(0);
            return true;
        } else if (str.equals("http://tieba.baidu.com/account/access/valid_success")) {
            drg();
            return true;
        } else if (str.equals("http://tieba.baidu.com/account/access/feedback") || str.equals("https://tieba.baidu.com/account/access/feedback")) {
            this.mmv.getContext().finish();
            bc.aWU().b(this.mmv.getContext().getPageContext(), new String[]{UrlSchemaHelper.SCHEMA_TYPE_FEED_BACK});
            return true;
        } else {
            return true;
        }
    }

    public void dre() {
        if (this.mmv != null) {
            this.mmv.showWebViewDelay(500);
        }
    }

    public void bl(String str) {
        if (this.mmv != null) {
            this.mmv.vK(true);
            this.mmv.showWebView(false);
            this.mmv.getWebView().loadUrl(str);
        }
    }

    public void drf() {
        if (this.mmv != null) {
            this.mmv.showPostThreadLoadingView(false);
        }
    }

    private void drg() {
        this.mmz = false;
        if (this.mmv != null && this.mmy != null) {
            if (!l.isNetOk()) {
                this.mmv.getContext().showToast(R.string.neterror);
                this.mmv.getContext().finish();
                return;
            }
            this.mmv.showPostThreadLoadingView(true);
            this.mmy.djo();
        }
    }
}
