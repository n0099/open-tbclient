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
import com.baidu.tbadk.core.util.be;
import com.baidu.tbadk.coreExtra.data.WriteData;
import com.baidu.tbadk.coreExtra.data.ah;
import com.baidu.tieba.R;
import com.baidu.tieba.tbadkCore.writeModel.NewWriteModel;
import com.baidu.tieba.tbadkCore.writeModel.PostWriteCallBackData;
import com.baidu.tieba.tbadkCore.writeModel.c;
/* loaded from: classes3.dex */
public class a {
    private final NewWriteModel nmB;
    private final b nmy;
    private boolean nmC = false;
    private final NewWriteModel.d fbF = new NewWriteModel.d() { // from class: com.baidu.tieba.write.accountAccess.a.1
        @Override // com.baidu.tieba.tbadkCore.writeModel.NewWriteModel.d
        public void callback(boolean z, PostWriteCallBackData postWriteCallBackData, ah ahVar, WriteData writeData, AntiData antiData) {
            if (a.this.nmy != null && a.this.nmB != null && a.this.nmB.cSo() != null) {
                a.this.nmy.showPostThreadLoadingView(false);
                WriteData cSo = writeData == null ? a.this.nmB.cSo() : writeData;
                if (z) {
                    a.this.nmC = true;
                    if (cSo.getType() != 0 || cSo.isUserFeedback()) {
                        if (postWriteCallBackData == null) {
                            c.g(a.this.nmy.getContext().getActivity(), a.this.nmy.getContext().getResources().getString(R.string.send_success), null, null);
                        } else {
                            c.g(a.this.nmy.getContext().getActivity(), postWriteCallBackData.getErrorString(), postWriteCallBackData.getPreMsg(), postWriteCallBackData.getColorMsg());
                        }
                    }
                    Intent intent = new Intent();
                    Bundle bundle = new Bundle();
                    bundle.putSerializable("post_write_callback_data", postWriteCallBackData);
                    intent.putExtras(bundle);
                    BaseActivity context = a.this.nmy.getContext();
                    a.this.nmy.getContext();
                    context.setResult(-1, intent);
                    a.this.nmy.getContext().finish();
                } else if (cSo != null && ahVar != null && !TextUtils.isEmpty(ahVar.bqC())) {
                    cSo.setVcodeMD5(ahVar.getVcode_md5());
                    cSo.setVcodeUrl(ahVar.getVcode_pic_url());
                    cSo.setVcodeExtra(ahVar.bqD());
                    a.this.nmy.getContext().setVisible(false);
                    if (com.baidu.tbadk.t.a.DX(ahVar.bqC())) {
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new NewVcodeActivityConfig(a.this.nmy.getContext().getActivity(), RequestResponseCode.REQUEST_VCODE, cSo, false, ahVar.bqC())));
                    } else {
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new VcodeActivityConfig(a.this.nmy.getContext().getActivity(), cSo, RequestResponseCode.REQUEST_VCODE)));
                    }
                } else if (postWriteCallBackData != null && postWriteCallBackData.isSensitiveError()) {
                    Intent intent2 = new Intent();
                    Bundle bundle2 = new Bundle();
                    bundle2.putSerializable("post_write_callback_data", postWriteCallBackData);
                    intent2.putExtras(bundle2);
                    BaseActivity context2 = a.this.nmy.getContext();
                    a.this.nmy.getContext();
                    context2.setResult(0, intent2);
                    a.this.nmy.getContext().finish();
                } else {
                    if (postWriteCallBackData != null) {
                        c.g(a.this.nmy.getContext().getActivity(), postWriteCallBackData.getErrorString(), postWriteCallBackData.getPreMsg(), postWriteCallBackData.getColorMsg());
                        BaseActivity context3 = a.this.nmy.getContext();
                        a.this.nmy.getContext();
                        context3.setResult(0, null);
                    }
                    a.this.nmy.getContext().finish();
                }
            }
        }
    };

    public a(b bVar, NewWriteModel newWriteModel) {
        this.nmy = bVar;
        this.nmB = newWriteModel;
        newWriteModel.b(this.fbF);
    }

    public boolean TP(String str) {
        if (this.nmy == null || str == null) {
            return false;
        }
        if (str.equals("http://tieba.baidu.com/account/access/cancel")) {
            this.nmy.getContext().finish();
            return true;
        } else if (str.equals("http://tieba.baidu.com/account/access/input_focus")) {
            this.nmy.setWebViewMargin(0, UtilHelper.getImmersiveStickyBarHeight(), 0, 0);
            if (this.nmy.dNG() != this.nmy.dNF()) {
                this.nmy.setRatio(this.nmy.dNG());
                this.nmy.dNH();
            }
            this.nmy.getWebView().setVisibility(0);
            return true;
        } else if (str.equals("http://tieba.baidu.com/account/access/valid_success")) {
            dNE();
            return true;
        } else if (str.equals("http://tieba.baidu.com/account/access/feedback") || str.equals("https://tieba.baidu.com/account/access/feedback")) {
            this.nmy.getContext().finish();
            be.bmY().b(this.nmy.getContext().getPageContext(), new String[]{UrlSchemaHelper.SCHEMA_TYPE_FEED_BACK});
            return true;
        } else {
            return true;
        }
    }

    public void dNC() {
        if (this.nmy != null) {
            this.nmy.showWebViewDelay(500);
        }
    }

    public void bs(String str) {
        if (this.nmy != null) {
            this.nmy.xV(true);
            this.nmy.showWebView(false);
            this.nmy.getWebView().loadUrl(str);
        }
    }

    public void dND() {
        if (this.nmy != null) {
            this.nmy.showPostThreadLoadingView(false);
        }
    }

    private void dNE() {
        this.nmC = false;
        if (this.nmy != null && this.nmB != null) {
            if (!l.isNetOk()) {
                this.nmy.getContext().showToast(R.string.neterror);
                this.nmy.getContext().finish();
                return;
            }
            this.nmy.showPostThreadLoadingView(true);
            this.nmB.dFC();
        }
    }
}
