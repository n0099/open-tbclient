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
    private final b kMs;
    private final NewWriteModel kMw;
    private boolean kMx = false;
    private final NewWriteModel.d dyA = new NewWriteModel.d() { // from class: com.baidu.tieba.write.accountAccess.a.1
        @Override // com.baidu.tieba.tbadkCore.writeModel.NewWriteModel.d
        public void callback(boolean z, PostWriteCallBackData postWriteCallBackData, aa aaVar, WriteData writeData, AntiData antiData) {
            if (a.this.kMs != null && a.this.kMw != null && a.this.kMw.cHU() != null) {
                a.this.kMs.showPostThreadLoadingView(false);
                WriteData cHU = writeData == null ? a.this.kMw.cHU() : writeData;
                if (z) {
                    a.this.kMx = true;
                    if (cHU.getType() != 0 || cHU.isUserFeedback()) {
                        if (postWriteCallBackData == null) {
                            c.g(a.this.kMs.getContext().getActivity(), a.this.kMs.getContext().getResources().getString(R.string.send_success), null, null);
                        } else {
                            c.g(a.this.kMs.getContext().getActivity(), postWriteCallBackData.getErrorString(), postWriteCallBackData.getPreMsg(), postWriteCallBackData.getColorMsg());
                        }
                    }
                    Intent intent = new Intent();
                    Bundle bundle = new Bundle();
                    bundle.putSerializable("post_write_callback_data", postWriteCallBackData);
                    intent.putExtras(bundle);
                    BaseActivity context = a.this.kMs.getContext();
                    a.this.kMs.getContext();
                    context.setResult(-1, intent);
                    a.this.kMs.getContext().finish();
                } else if (cHU != null && aaVar != null && !TextUtils.isEmpty(aaVar.aJF())) {
                    cHU.setVcodeMD5(aaVar.getVcode_md5());
                    cHU.setVcodeUrl(aaVar.getVcode_pic_url());
                    cHU.setVcodeExtra(aaVar.aJG());
                    a.this.kMs.getContext().setVisible(false);
                    if (com.baidu.tbadk.s.a.wa(aaVar.aJF())) {
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new NewVcodeActivityConfig(a.this.kMs.getContext().getActivity(), RequestResponseCode.REQUEST_VCODE, cHU, false, aaVar.aJF())));
                    } else {
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new VcodeActivityConfig(a.this.kMs.getContext().getActivity(), cHU, RequestResponseCode.REQUEST_VCODE)));
                    }
                } else if (postWriteCallBackData != null && postWriteCallBackData.isSensitiveError()) {
                    Intent intent2 = new Intent();
                    Bundle bundle2 = new Bundle();
                    bundle2.putSerializable("post_write_callback_data", postWriteCallBackData);
                    intent2.putExtras(bundle2);
                    BaseActivity context2 = a.this.kMs.getContext();
                    a.this.kMs.getContext();
                    context2.setResult(0, intent2);
                    a.this.kMs.getContext().finish();
                } else {
                    if (postWriteCallBackData != null) {
                        c.g(a.this.kMs.getContext().getActivity(), postWriteCallBackData.getErrorString(), postWriteCallBackData.getPreMsg(), postWriteCallBackData.getColorMsg());
                        BaseActivity context3 = a.this.kMs.getContext();
                        a.this.kMs.getContext();
                        context3.setResult(0, null);
                    }
                    a.this.kMs.getContext().finish();
                }
            }
        }
    };

    public a(b bVar, NewWriteModel newWriteModel) {
        this.kMs = bVar;
        this.kMw = newWriteModel;
        newWriteModel.b(this.dyA);
    }

    public boolean KO(String str) {
        if (this.kMs == null || str == null) {
            return false;
        }
        if (str.equals("http://tieba.baidu.com/account/access/cancel")) {
            this.kMs.getContext().finish();
            return true;
        } else if (str.equals("http://tieba.baidu.com/account/access/input_focus")) {
            this.kMs.setWebViewMargin(0, UtilHelper.getImmersiveStickyBarHeight(), 0, 0);
            if (this.kMs.cUw() != this.kMs.dT()) {
                this.kMs.setRatio(this.kMs.cUw());
                this.kMs.cUx();
            }
            this.kMs.getWebView().setVisibility(0);
            return true;
        } else if (str.equals("http://tieba.baidu.com/account/access/valid_success")) {
            cUv();
            return true;
        } else if (str.equals("http://tieba.baidu.com/account/access/feedback") || str.equals("https://tieba.baidu.com/account/access/feedback")) {
            this.kMs.getContext().finish();
            ba.aGG().b(this.kMs.getContext().getPageContext(), new String[]{UrlSchemaHelper.SCHEMA_TYPE_FEED_BACK});
            return true;
        } else {
            return true;
        }
    }

    public void cUt() {
        if (this.kMs != null) {
            this.kMs.showWebViewDelay(500);
        }
    }

    public void V(String str) {
        if (this.kMs != null) {
            this.kMs.tL(true);
            this.kMs.showWebView(false);
            this.kMs.getWebView().loadUrl(str);
        }
    }

    public void cUu() {
        if (this.kMs != null) {
            this.kMs.showPostThreadLoadingView(false);
        }
    }

    private void cUv() {
        this.kMx = false;
        if (this.kMs != null && this.kMw != null) {
            if (!l.isNetOk()) {
                this.kMs.getContext().showToast(R.string.neterror);
                this.kMs.getContext().finish();
                return;
            }
            this.kMs.showPostThreadLoadingView(true);
            this.kMw.cMj();
        }
    }
}
