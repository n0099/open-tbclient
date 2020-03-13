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
    private final b kME;
    private final NewWriteModel kMI;
    private boolean kMJ = false;
    private final NewWriteModel.d dyN = new NewWriteModel.d() { // from class: com.baidu.tieba.write.accountAccess.a.1
        @Override // com.baidu.tieba.tbadkCore.writeModel.NewWriteModel.d
        public void callback(boolean z, PostWriteCallBackData postWriteCallBackData, aa aaVar, WriteData writeData, AntiData antiData) {
            if (a.this.kME != null && a.this.kMI != null && a.this.kMI.cHV() != null) {
                a.this.kME.showPostThreadLoadingView(false);
                WriteData cHV = writeData == null ? a.this.kMI.cHV() : writeData;
                if (z) {
                    a.this.kMJ = true;
                    if (cHV.getType() != 0 || cHV.isUserFeedback()) {
                        if (postWriteCallBackData == null) {
                            c.g(a.this.kME.getContext().getActivity(), a.this.kME.getContext().getResources().getString(R.string.send_success), null, null);
                        } else {
                            c.g(a.this.kME.getContext().getActivity(), postWriteCallBackData.getErrorString(), postWriteCallBackData.getPreMsg(), postWriteCallBackData.getColorMsg());
                        }
                    }
                    Intent intent = new Intent();
                    Bundle bundle = new Bundle();
                    bundle.putSerializable("post_write_callback_data", postWriteCallBackData);
                    intent.putExtras(bundle);
                    BaseActivity context = a.this.kME.getContext();
                    a.this.kME.getContext();
                    context.setResult(-1, intent);
                    a.this.kME.getContext().finish();
                } else if (cHV != null && aaVar != null && !TextUtils.isEmpty(aaVar.aJG())) {
                    cHV.setVcodeMD5(aaVar.getVcode_md5());
                    cHV.setVcodeUrl(aaVar.getVcode_pic_url());
                    cHV.setVcodeExtra(aaVar.aJH());
                    a.this.kME.getContext().setVisible(false);
                    if (com.baidu.tbadk.s.a.wb(aaVar.aJG())) {
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new NewVcodeActivityConfig(a.this.kME.getContext().getActivity(), RequestResponseCode.REQUEST_VCODE, cHV, false, aaVar.aJG())));
                    } else {
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new VcodeActivityConfig(a.this.kME.getContext().getActivity(), cHV, RequestResponseCode.REQUEST_VCODE)));
                    }
                } else if (postWriteCallBackData != null && postWriteCallBackData.isSensitiveError()) {
                    Intent intent2 = new Intent();
                    Bundle bundle2 = new Bundle();
                    bundle2.putSerializable("post_write_callback_data", postWriteCallBackData);
                    intent2.putExtras(bundle2);
                    BaseActivity context2 = a.this.kME.getContext();
                    a.this.kME.getContext();
                    context2.setResult(0, intent2);
                    a.this.kME.getContext().finish();
                } else {
                    if (postWriteCallBackData != null) {
                        c.g(a.this.kME.getContext().getActivity(), postWriteCallBackData.getErrorString(), postWriteCallBackData.getPreMsg(), postWriteCallBackData.getColorMsg());
                        BaseActivity context3 = a.this.kME.getContext();
                        a.this.kME.getContext();
                        context3.setResult(0, null);
                    }
                    a.this.kME.getContext().finish();
                }
            }
        }
    };

    public a(b bVar, NewWriteModel newWriteModel) {
        this.kME = bVar;
        this.kMI = newWriteModel;
        newWriteModel.b(this.dyN);
    }

    public boolean KP(String str) {
        if (this.kME == null || str == null) {
            return false;
        }
        if (str.equals("http://tieba.baidu.com/account/access/cancel")) {
            this.kME.getContext().finish();
            return true;
        } else if (str.equals("http://tieba.baidu.com/account/access/input_focus")) {
            this.kME.setWebViewMargin(0, UtilHelper.getImmersiveStickyBarHeight(), 0, 0);
            if (this.kME.cUx() != this.kME.dT()) {
                this.kME.setRatio(this.kME.cUx());
                this.kME.cUy();
            }
            this.kME.getWebView().setVisibility(0);
            return true;
        } else if (str.equals("http://tieba.baidu.com/account/access/valid_success")) {
            cUw();
            return true;
        } else if (str.equals("http://tieba.baidu.com/account/access/feedback") || str.equals("https://tieba.baidu.com/account/access/feedback")) {
            this.kME.getContext().finish();
            ba.aGG().b(this.kME.getContext().getPageContext(), new String[]{UrlSchemaHelper.SCHEMA_TYPE_FEED_BACK});
            return true;
        } else {
            return true;
        }
    }

    public void cUu() {
        if (this.kME != null) {
            this.kME.showWebViewDelay(500);
        }
    }

    public void V(String str) {
        if (this.kME != null) {
            this.kME.tL(true);
            this.kME.showWebView(false);
            this.kME.getWebView().loadUrl(str);
        }
    }

    public void cUv() {
        if (this.kME != null) {
            this.kME.showPostThreadLoadingView(false);
        }
    }

    private void cUw() {
        this.kMJ = false;
        if (this.kME != null && this.kMI != null) {
            if (!l.isNetOk()) {
                this.kME.getContext().showToast(R.string.neterror);
                this.kME.getContext().finish();
                return;
            }
            this.kME.showPostThreadLoadingView(true);
            this.kMI.cMk();
        }
    }
}
