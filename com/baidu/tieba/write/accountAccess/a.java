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
    private final b kMq;
    private final NewWriteModel kMu;
    private boolean kMv = false;
    private final NewWriteModel.d dyz = new NewWriteModel.d() { // from class: com.baidu.tieba.write.accountAccess.a.1
        @Override // com.baidu.tieba.tbadkCore.writeModel.NewWriteModel.d
        public void callback(boolean z, PostWriteCallBackData postWriteCallBackData, aa aaVar, WriteData writeData, AntiData antiData) {
            if (a.this.kMq != null && a.this.kMu != null && a.this.kMu.cHS() != null) {
                a.this.kMq.showPostThreadLoadingView(false);
                WriteData cHS = writeData == null ? a.this.kMu.cHS() : writeData;
                if (z) {
                    a.this.kMv = true;
                    if (cHS.getType() != 0 || cHS.isUserFeedback()) {
                        if (postWriteCallBackData == null) {
                            c.g(a.this.kMq.getContext().getActivity(), a.this.kMq.getContext().getResources().getString(R.string.send_success), null, null);
                        } else {
                            c.g(a.this.kMq.getContext().getActivity(), postWriteCallBackData.getErrorString(), postWriteCallBackData.getPreMsg(), postWriteCallBackData.getColorMsg());
                        }
                    }
                    Intent intent = new Intent();
                    Bundle bundle = new Bundle();
                    bundle.putSerializable("post_write_callback_data", postWriteCallBackData);
                    intent.putExtras(bundle);
                    BaseActivity context = a.this.kMq.getContext();
                    a.this.kMq.getContext();
                    context.setResult(-1, intent);
                    a.this.kMq.getContext().finish();
                } else if (cHS != null && aaVar != null && !TextUtils.isEmpty(aaVar.aJD())) {
                    cHS.setVcodeMD5(aaVar.getVcode_md5());
                    cHS.setVcodeUrl(aaVar.getVcode_pic_url());
                    cHS.setVcodeExtra(aaVar.aJE());
                    a.this.kMq.getContext().setVisible(false);
                    if (com.baidu.tbadk.s.a.wa(aaVar.aJD())) {
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new NewVcodeActivityConfig(a.this.kMq.getContext().getActivity(), RequestResponseCode.REQUEST_VCODE, cHS, false, aaVar.aJD())));
                    } else {
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new VcodeActivityConfig(a.this.kMq.getContext().getActivity(), cHS, RequestResponseCode.REQUEST_VCODE)));
                    }
                } else if (postWriteCallBackData != null && postWriteCallBackData.isSensitiveError()) {
                    Intent intent2 = new Intent();
                    Bundle bundle2 = new Bundle();
                    bundle2.putSerializable("post_write_callback_data", postWriteCallBackData);
                    intent2.putExtras(bundle2);
                    BaseActivity context2 = a.this.kMq.getContext();
                    a.this.kMq.getContext();
                    context2.setResult(0, intent2);
                    a.this.kMq.getContext().finish();
                } else {
                    if (postWriteCallBackData != null) {
                        c.g(a.this.kMq.getContext().getActivity(), postWriteCallBackData.getErrorString(), postWriteCallBackData.getPreMsg(), postWriteCallBackData.getColorMsg());
                        BaseActivity context3 = a.this.kMq.getContext();
                        a.this.kMq.getContext();
                        context3.setResult(0, null);
                    }
                    a.this.kMq.getContext().finish();
                }
            }
        }
    };

    public a(b bVar, NewWriteModel newWriteModel) {
        this.kMq = bVar;
        this.kMu = newWriteModel;
        newWriteModel.b(this.dyz);
    }

    public boolean KO(String str) {
        if (this.kMq == null || str == null) {
            return false;
        }
        if (str.equals("http://tieba.baidu.com/account/access/cancel")) {
            this.kMq.getContext().finish();
            return true;
        } else if (str.equals("http://tieba.baidu.com/account/access/input_focus")) {
            this.kMq.setWebViewMargin(0, UtilHelper.getImmersiveStickyBarHeight(), 0, 0);
            if (this.kMq.cUu() != this.kMq.dT()) {
                this.kMq.setRatio(this.kMq.cUu());
                this.kMq.cUv();
            }
            this.kMq.getWebView().setVisibility(0);
            return true;
        } else if (str.equals("http://tieba.baidu.com/account/access/valid_success")) {
            cUt();
            return true;
        } else if (str.equals("http://tieba.baidu.com/account/access/feedback") || str.equals("https://tieba.baidu.com/account/access/feedback")) {
            this.kMq.getContext().finish();
            ba.aGE().b(this.kMq.getContext().getPageContext(), new String[]{UrlSchemaHelper.SCHEMA_TYPE_FEED_BACK});
            return true;
        } else {
            return true;
        }
    }

    public void cUr() {
        if (this.kMq != null) {
            this.kMq.showWebViewDelay(500);
        }
    }

    public void V(String str) {
        if (this.kMq != null) {
            this.kMq.tL(true);
            this.kMq.showWebView(false);
            this.kMq.getWebView().loadUrl(str);
        }
    }

    public void cUs() {
        if (this.kMq != null) {
            this.kMq.showPostThreadLoadingView(false);
        }
    }

    private void cUt() {
        this.kMv = false;
        if (this.kMq != null && this.kMu != null) {
            if (!l.isNetOk()) {
                this.kMq.getContext().showToast(R.string.neterror);
                this.kMq.getContext().finish();
                return;
            }
            this.kMq.showPostThreadLoadingView(true);
            this.kMu.cMh();
        }
    }
}
