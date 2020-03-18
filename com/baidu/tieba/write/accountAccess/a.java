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
/* loaded from: classes13.dex */
public class a {
    private final b kOn;
    private final NewWriteModel kOr;
    private boolean kOs = false;
    private final NewWriteModel.d dza = new NewWriteModel.d() { // from class: com.baidu.tieba.write.accountAccess.a.1
        @Override // com.baidu.tieba.tbadkCore.writeModel.NewWriteModel.d
        public void callback(boolean z, PostWriteCallBackData postWriteCallBackData, aa aaVar, WriteData writeData, AntiData antiData) {
            if (a.this.kOn != null && a.this.kOr != null && a.this.kOr.cIp() != null) {
                a.this.kOn.showPostThreadLoadingView(false);
                WriteData cIp = writeData == null ? a.this.kOr.cIp() : writeData;
                if (z) {
                    a.this.kOs = true;
                    if (cIp.getType() != 0 || cIp.isUserFeedback()) {
                        if (postWriteCallBackData == null) {
                            c.g(a.this.kOn.getContext().getActivity(), a.this.kOn.getContext().getResources().getString(R.string.send_success), null, null);
                        } else {
                            c.g(a.this.kOn.getContext().getActivity(), postWriteCallBackData.getErrorString(), postWriteCallBackData.getPreMsg(), postWriteCallBackData.getColorMsg());
                        }
                    }
                    Intent intent = new Intent();
                    Bundle bundle = new Bundle();
                    bundle.putSerializable("post_write_callback_data", postWriteCallBackData);
                    intent.putExtras(bundle);
                    BaseActivity context = a.this.kOn.getContext();
                    a.this.kOn.getContext();
                    context.setResult(-1, intent);
                    a.this.kOn.getContext().finish();
                } else if (cIp != null && aaVar != null && !TextUtils.isEmpty(aaVar.aJK())) {
                    cIp.setVcodeMD5(aaVar.getVcode_md5());
                    cIp.setVcodeUrl(aaVar.getVcode_pic_url());
                    cIp.setVcodeExtra(aaVar.aJL());
                    a.this.kOn.getContext().setVisible(false);
                    if (com.baidu.tbadk.s.a.wb(aaVar.aJK())) {
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new NewVcodeActivityConfig(a.this.kOn.getContext().getActivity(), RequestResponseCode.REQUEST_VCODE, cIp, false, aaVar.aJK())));
                    } else {
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new VcodeActivityConfig(a.this.kOn.getContext().getActivity(), cIp, RequestResponseCode.REQUEST_VCODE)));
                    }
                } else if (postWriteCallBackData != null && postWriteCallBackData.isSensitiveError()) {
                    Intent intent2 = new Intent();
                    Bundle bundle2 = new Bundle();
                    bundle2.putSerializable("post_write_callback_data", postWriteCallBackData);
                    intent2.putExtras(bundle2);
                    BaseActivity context2 = a.this.kOn.getContext();
                    a.this.kOn.getContext();
                    context2.setResult(0, intent2);
                    a.this.kOn.getContext().finish();
                } else {
                    if (postWriteCallBackData != null) {
                        c.g(a.this.kOn.getContext().getActivity(), postWriteCallBackData.getErrorString(), postWriteCallBackData.getPreMsg(), postWriteCallBackData.getColorMsg());
                        BaseActivity context3 = a.this.kOn.getContext();
                        a.this.kOn.getContext();
                        context3.setResult(0, null);
                    }
                    a.this.kOn.getContext().finish();
                }
            }
        }
    };

    public a(b bVar, NewWriteModel newWriteModel) {
        this.kOn = bVar;
        this.kOr = newWriteModel;
        newWriteModel.b(this.dza);
    }

    public boolean KO(String str) {
        if (this.kOn == null || str == null) {
            return false;
        }
        if (str.equals("http://tieba.baidu.com/account/access/cancel")) {
            this.kOn.getContext().finish();
            return true;
        } else if (str.equals("http://tieba.baidu.com/account/access/input_focus")) {
            this.kOn.setWebViewMargin(0, UtilHelper.getImmersiveStickyBarHeight(), 0, 0);
            if (this.kOn.cUS() != this.kOn.dT()) {
                this.kOn.setRatio(this.kOn.cUS());
                this.kOn.cUT();
            }
            this.kOn.getWebView().setVisibility(0);
            return true;
        } else if (str.equals("http://tieba.baidu.com/account/access/valid_success")) {
            cUR();
            return true;
        } else if (str.equals("http://tieba.baidu.com/account/access/feedback") || str.equals("https://tieba.baidu.com/account/access/feedback")) {
            this.kOn.getContext().finish();
            ba.aGK().b(this.kOn.getContext().getPageContext(), new String[]{UrlSchemaHelper.SCHEMA_TYPE_FEED_BACK});
            return true;
        } else {
            return true;
        }
    }

    public void cUP() {
        if (this.kOn != null) {
            this.kOn.showWebViewDelay(500);
        }
    }

    public void V(String str) {
        if (this.kOn != null) {
            this.kOn.tS(true);
            this.kOn.showWebView(false);
            this.kOn.getWebView().loadUrl(str);
        }
    }

    public void cUQ() {
        if (this.kOn != null) {
            this.kOn.showPostThreadLoadingView(false);
        }
    }

    private void cUR() {
        this.kOs = false;
        if (this.kOn != null && this.kOr != null) {
            if (!l.isNetOk()) {
                this.kOn.getContext().showToast(R.string.neterror);
                this.kOn.getContext().finish();
                return;
            }
            this.kOn.showPostThreadLoadingView(true);
            this.kOr.cME();
        }
    }
}
