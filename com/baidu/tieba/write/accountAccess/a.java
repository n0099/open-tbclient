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
import com.baidu.tbadk.coreExtra.data.aa;
import com.baidu.tieba.R;
import com.baidu.tieba.tbadkCore.writeModel.NewWriteModel;
import com.baidu.tieba.tbadkCore.writeModel.PostWriteCallBackData;
import com.baidu.tieba.tbadkCore.writeModel.c;
/* loaded from: classes2.dex */
public class a {
    private final b lQX;
    private final NewWriteModel lRb;
    private boolean lRc = false;
    private final NewWriteModel.d emV = new NewWriteModel.d() { // from class: com.baidu.tieba.write.accountAccess.a.1
        @Override // com.baidu.tieba.tbadkCore.writeModel.NewWriteModel.d
        public void callback(boolean z, PostWriteCallBackData postWriteCallBackData, aa aaVar, WriteData writeData, AntiData antiData) {
            if (a.this.lQX != null && a.this.lRb != null && a.this.lRb.cZP() != null) {
                a.this.lQX.showPostThreadLoadingView(false);
                WriteData cZP = writeData == null ? a.this.lRb.cZP() : writeData;
                if (z) {
                    a.this.lRc = true;
                    if (cZP.getType() != 0 || cZP.isUserFeedback()) {
                        if (postWriteCallBackData == null) {
                            c.f(a.this.lQX.getContext().getActivity(), a.this.lQX.getContext().getResources().getString(R.string.send_success), null, null);
                        } else {
                            c.f(a.this.lQX.getContext().getActivity(), postWriteCallBackData.getErrorString(), postWriteCallBackData.getPreMsg(), postWriteCallBackData.getColorMsg());
                        }
                    }
                    Intent intent = new Intent();
                    Bundle bundle = new Bundle();
                    bundle.putSerializable("post_write_callback_data", postWriteCallBackData);
                    intent.putExtras(bundle);
                    BaseActivity context = a.this.lQX.getContext();
                    a.this.lQX.getContext();
                    context.setResult(-1, intent);
                    a.this.lQX.getContext().finish();
                } else if (cZP != null && aaVar != null && !TextUtils.isEmpty(aaVar.aYl())) {
                    cZP.setVcodeMD5(aaVar.getVcode_md5());
                    cZP.setVcodeUrl(aaVar.getVcode_pic_url());
                    cZP.setVcodeExtra(aaVar.aYm());
                    a.this.lQX.getContext().setVisible(false);
                    if (com.baidu.tbadk.s.a.yX(aaVar.aYl())) {
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new NewVcodeActivityConfig(a.this.lQX.getContext().getActivity(), RequestResponseCode.REQUEST_VCODE, cZP, false, aaVar.aYl())));
                    } else {
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new VcodeActivityConfig(a.this.lQX.getContext().getActivity(), cZP, RequestResponseCode.REQUEST_VCODE)));
                    }
                } else if (postWriteCallBackData != null && postWriteCallBackData.isSensitiveError()) {
                    Intent intent2 = new Intent();
                    Bundle bundle2 = new Bundle();
                    bundle2.putSerializable("post_write_callback_data", postWriteCallBackData);
                    intent2.putExtras(bundle2);
                    BaseActivity context2 = a.this.lQX.getContext();
                    a.this.lQX.getContext();
                    context2.setResult(0, intent2);
                    a.this.lQX.getContext().finish();
                } else {
                    if (postWriteCallBackData != null) {
                        c.f(a.this.lQX.getContext().getActivity(), postWriteCallBackData.getErrorString(), postWriteCallBackData.getPreMsg(), postWriteCallBackData.getColorMsg());
                        BaseActivity context3 = a.this.lQX.getContext();
                        a.this.lQX.getContext();
                        context3.setResult(0, null);
                    }
                    a.this.lQX.getContext().finish();
                }
            }
        }
    };

    public a(b bVar, NewWriteModel newWriteModel) {
        this.lQX = bVar;
        this.lRb = newWriteModel;
        newWriteModel.b(this.emV);
    }

    public boolean Oj(String str) {
        if (this.lQX == null || str == null) {
            return false;
        }
        if (str.equals("http://tieba.baidu.com/account/access/cancel")) {
            this.lQX.getContext().finish();
            return true;
        } else if (str.equals("http://tieba.baidu.com/account/access/input_focus")) {
            this.lQX.setWebViewMargin(0, UtilHelper.getImmersiveStickyBarHeight(), 0, 0);
            if (this.lQX.dmC() != this.lQX.dmB()) {
                this.lQX.setRatio(this.lQX.dmC());
                this.lQX.dmD();
            }
            this.lQX.getWebView().setVisibility(0);
            return true;
        } else if (str.equals("http://tieba.baidu.com/account/access/valid_success")) {
            dmA();
            return true;
        } else if (str.equals("http://tieba.baidu.com/account/access/feedback") || str.equals("https://tieba.baidu.com/account/access/feedback")) {
            this.lQX.getContext().finish();
            ba.aUZ().b(this.lQX.getContext().getPageContext(), new String[]{UrlSchemaHelper.SCHEMA_TYPE_FEED_BACK});
            return true;
        } else {
            return true;
        }
    }

    public void dmy() {
        if (this.lQX != null) {
            this.lQX.showWebViewDelay(500);
        }
    }

    public void bk(String str) {
        if (this.lQX != null) {
            this.lQX.vq(true);
            this.lQX.showWebView(false);
            this.lQX.getWebView().loadUrl(str);
        }
    }

    public void dmz() {
        if (this.lQX != null) {
            this.lQX.showPostThreadLoadingView(false);
        }
    }

    private void dmA() {
        this.lRc = false;
        if (this.lQX != null && this.lRb != null) {
            if (!l.isNetOk()) {
                this.lQX.getContext().showToast(R.string.neterror);
                this.lQX.getContext().finish();
                return;
            }
            this.lQX.showPostThreadLoadingView(true);
            this.lRb.deN();
        }
    }
}
