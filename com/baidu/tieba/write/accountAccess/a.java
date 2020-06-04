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
import com.baidu.tbadk.coreExtra.data.ab;
import com.baidu.tieba.R;
import com.baidu.tieba.tbadkCore.writeModel.NewWriteModel;
import com.baidu.tieba.tbadkCore.writeModel.PostWriteCallBackData;
import com.baidu.tieba.tbadkCore.writeModel.c;
/* loaded from: classes2.dex */
public class a {
    private final b lSj;
    private final NewWriteModel lSm;
    private boolean lSn = false;
    private final NewWriteModel.d emV = new NewWriteModel.d() { // from class: com.baidu.tieba.write.accountAccess.a.1
        @Override // com.baidu.tieba.tbadkCore.writeModel.NewWriteModel.d
        public void callback(boolean z, PostWriteCallBackData postWriteCallBackData, ab abVar, WriteData writeData, AntiData antiData) {
            if (a.this.lSj != null && a.this.lSm != null && a.this.lSm.daf() != null) {
                a.this.lSj.showPostThreadLoadingView(false);
                WriteData daf = writeData == null ? a.this.lSm.daf() : writeData;
                if (z) {
                    a.this.lSn = true;
                    if (daf.getType() != 0 || daf.isUserFeedback()) {
                        if (postWriteCallBackData == null) {
                            c.f(a.this.lSj.getContext().getActivity(), a.this.lSj.getContext().getResources().getString(R.string.send_success), null, null);
                        } else {
                            c.f(a.this.lSj.getContext().getActivity(), postWriteCallBackData.getErrorString(), postWriteCallBackData.getPreMsg(), postWriteCallBackData.getColorMsg());
                        }
                    }
                    Intent intent = new Intent();
                    Bundle bundle = new Bundle();
                    bundle.putSerializable("post_write_callback_data", postWriteCallBackData);
                    intent.putExtras(bundle);
                    BaseActivity context = a.this.lSj.getContext();
                    a.this.lSj.getContext();
                    context.setResult(-1, intent);
                    a.this.lSj.getContext().finish();
                } else if (daf != null && abVar != null && !TextUtils.isEmpty(abVar.aYm())) {
                    daf.setVcodeMD5(abVar.getVcode_md5());
                    daf.setVcodeUrl(abVar.getVcode_pic_url());
                    daf.setVcodeExtra(abVar.aYn());
                    a.this.lSj.getContext().setVisible(false);
                    if (com.baidu.tbadk.s.a.yX(abVar.aYm())) {
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new NewVcodeActivityConfig(a.this.lSj.getContext().getActivity(), RequestResponseCode.REQUEST_VCODE, daf, false, abVar.aYm())));
                    } else {
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new VcodeActivityConfig(a.this.lSj.getContext().getActivity(), daf, RequestResponseCode.REQUEST_VCODE)));
                    }
                } else if (postWriteCallBackData != null && postWriteCallBackData.isSensitiveError()) {
                    Intent intent2 = new Intent();
                    Bundle bundle2 = new Bundle();
                    bundle2.putSerializable("post_write_callback_data", postWriteCallBackData);
                    intent2.putExtras(bundle2);
                    BaseActivity context2 = a.this.lSj.getContext();
                    a.this.lSj.getContext();
                    context2.setResult(0, intent2);
                    a.this.lSj.getContext().finish();
                } else {
                    if (postWriteCallBackData != null) {
                        c.f(a.this.lSj.getContext().getActivity(), postWriteCallBackData.getErrorString(), postWriteCallBackData.getPreMsg(), postWriteCallBackData.getColorMsg());
                        BaseActivity context3 = a.this.lSj.getContext();
                        a.this.lSj.getContext();
                        context3.setResult(0, null);
                    }
                    a.this.lSj.getContext().finish();
                }
            }
        }
    };

    public a(b bVar, NewWriteModel newWriteModel) {
        this.lSj = bVar;
        this.lSm = newWriteModel;
        newWriteModel.b(this.emV);
    }

    public boolean Ok(String str) {
        if (this.lSj == null || str == null) {
            return false;
        }
        if (str.equals("http://tieba.baidu.com/account/access/cancel")) {
            this.lSj.getContext().finish();
            return true;
        } else if (str.equals("http://tieba.baidu.com/account/access/input_focus")) {
            this.lSj.setWebViewMargin(0, UtilHelper.getImmersiveStickyBarHeight(), 0, 0);
            if (this.lSj.dmS() != this.lSj.dmR()) {
                this.lSj.setRatio(this.lSj.dmS());
                this.lSj.dmT();
            }
            this.lSj.getWebView().setVisibility(0);
            return true;
        } else if (str.equals("http://tieba.baidu.com/account/access/valid_success")) {
            dmQ();
            return true;
        } else if (str.equals("http://tieba.baidu.com/account/access/feedback") || str.equals("https://tieba.baidu.com/account/access/feedback")) {
            this.lSj.getContext().finish();
            ba.aVa().b(this.lSj.getContext().getPageContext(), new String[]{UrlSchemaHelper.SCHEMA_TYPE_FEED_BACK});
            return true;
        } else {
            return true;
        }
    }

    public void dmO() {
        if (this.lSj != null) {
            this.lSj.showWebViewDelay(500);
        }
    }

    public void bk(String str) {
        if (this.lSj != null) {
            this.lSj.vs(true);
            this.lSj.showWebView(false);
            this.lSj.getWebView().loadUrl(str);
        }
    }

    public void dmP() {
        if (this.lSj != null) {
            this.lSj.showPostThreadLoadingView(false);
        }
    }

    private void dmQ() {
        this.lSn = false;
        if (this.lSj != null && this.lSm != null) {
            if (!l.isNetOk()) {
                this.lSj.getContext().showToast(R.string.neterror);
                this.lSj.getContext().finish();
                return;
            }
            this.lSj.showPostThreadLoadingView(true);
            this.lSm.dfc();
        }
    }
}
