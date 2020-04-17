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
    private final b lxE;
    private final NewWriteModel lxI;
    private boolean lxJ = false;
    private final NewWriteModel.d dYH = new NewWriteModel.d() { // from class: com.baidu.tieba.write.accountAccess.a.1
        @Override // com.baidu.tieba.tbadkCore.writeModel.NewWriteModel.d
        public void callback(boolean z, PostWriteCallBackData postWriteCallBackData, aa aaVar, WriteData writeData, AntiData antiData) {
            if (a.this.lxE != null && a.this.lxI != null && a.this.lxI.cSN() != null) {
                a.this.lxE.showPostThreadLoadingView(false);
                WriteData cSN = writeData == null ? a.this.lxI.cSN() : writeData;
                if (z) {
                    a.this.lxJ = true;
                    if (cSN.getType() != 0 || cSN.isUserFeedback()) {
                        if (postWriteCallBackData == null) {
                            c.g(a.this.lxE.getContext().getActivity(), a.this.lxE.getContext().getResources().getString(R.string.send_success), null, null);
                        } else {
                            c.g(a.this.lxE.getContext().getActivity(), postWriteCallBackData.getErrorString(), postWriteCallBackData.getPreMsg(), postWriteCallBackData.getColorMsg());
                        }
                    }
                    Intent intent = new Intent();
                    Bundle bundle = new Bundle();
                    bundle.putSerializable("post_write_callback_data", postWriteCallBackData);
                    intent.putExtras(bundle);
                    BaseActivity context = a.this.lxE.getContext();
                    a.this.lxE.getContext();
                    context.setResult(-1, intent);
                    a.this.lxE.getContext().finish();
                } else if (cSN != null && aaVar != null && !TextUtils.isEmpty(aaVar.aSh())) {
                    cSN.setVcodeMD5(aaVar.getVcode_md5());
                    cSN.setVcodeUrl(aaVar.getVcode_pic_url());
                    cSN.setVcodeExtra(aaVar.aSi());
                    a.this.lxE.getContext().setVisible(false);
                    if (com.baidu.tbadk.s.a.xo(aaVar.aSh())) {
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new NewVcodeActivityConfig(a.this.lxE.getContext().getActivity(), RequestResponseCode.REQUEST_VCODE, cSN, false, aaVar.aSh())));
                    } else {
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new VcodeActivityConfig(a.this.lxE.getContext().getActivity(), cSN, RequestResponseCode.REQUEST_VCODE)));
                    }
                } else if (postWriteCallBackData != null && postWriteCallBackData.isSensitiveError()) {
                    Intent intent2 = new Intent();
                    Bundle bundle2 = new Bundle();
                    bundle2.putSerializable("post_write_callback_data", postWriteCallBackData);
                    intent2.putExtras(bundle2);
                    BaseActivity context2 = a.this.lxE.getContext();
                    a.this.lxE.getContext();
                    context2.setResult(0, intent2);
                    a.this.lxE.getContext().finish();
                } else {
                    if (postWriteCallBackData != null) {
                        c.g(a.this.lxE.getContext().getActivity(), postWriteCallBackData.getErrorString(), postWriteCallBackData.getPreMsg(), postWriteCallBackData.getColorMsg());
                        BaseActivity context3 = a.this.lxE.getContext();
                        a.this.lxE.getContext();
                        context3.setResult(0, null);
                    }
                    a.this.lxE.getContext().finish();
                }
            }
        }
    };

    public a(b bVar, NewWriteModel newWriteModel) {
        this.lxE = bVar;
        this.lxI = newWriteModel;
        newWriteModel.b(this.dYH);
    }

    public boolean Mt(String str) {
        if (this.lxE == null || str == null) {
            return false;
        }
        if (str.equals("http://tieba.baidu.com/account/access/cancel")) {
            this.lxE.getContext().finish();
            return true;
        } else if (str.equals("http://tieba.baidu.com/account/access/input_focus")) {
            this.lxE.setWebViewMargin(0, UtilHelper.getImmersiveStickyBarHeight(), 0, 0);
            if (this.lxE.dfo() != this.lxE.dfn()) {
                this.lxE.setRatio(this.lxE.dfo());
                this.lxE.dfp();
            }
            this.lxE.getWebView().setVisibility(0);
            return true;
        } else if (str.equals("http://tieba.baidu.com/account/access/valid_success")) {
            dfm();
            return true;
        } else if (str.equals("http://tieba.baidu.com/account/access/feedback") || str.equals("https://tieba.baidu.com/account/access/feedback")) {
            this.lxE.getContext().finish();
            ba.aOY().b(this.lxE.getContext().getPageContext(), new String[]{UrlSchemaHelper.SCHEMA_TYPE_FEED_BACK});
            return true;
        } else {
            return true;
        }
    }

    public void dfk() {
        if (this.lxE != null) {
            this.lxE.showWebViewDelay(500);
        }
    }

    public void bk(String str) {
        if (this.lxE != null) {
            this.lxE.uS(true);
            this.lxE.showWebView(false);
            this.lxE.getWebView().loadUrl(str);
        }
    }

    public void dfl() {
        if (this.lxE != null) {
            this.lxE.showPostThreadLoadingView(false);
        }
    }

    private void dfm() {
        this.lxJ = false;
        if (this.lxE != null && this.lxI != null) {
            if (!l.isNetOk()) {
                this.lxE.getContext().showToast(R.string.neterror);
                this.lxE.getContext().finish();
                return;
            }
            this.lxE.showPostThreadLoadingView(true);
            this.lxI.cXB();
        }
    }
}
