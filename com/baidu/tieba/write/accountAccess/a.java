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
    private final b jNq;
    private final NewWriteModel jNu;
    private boolean jNv = false;
    private final NewWriteModel.d cGo = new NewWriteModel.d() { // from class: com.baidu.tieba.write.accountAccess.a.1
        @Override // com.baidu.tieba.tbadkCore.writeModel.NewWriteModel.d
        public void callback(boolean z, PostWriteCallBackData postWriteCallBackData, y yVar, WriteData writeData, AntiData antiData) {
            if (a.this.jNq != null && a.this.jNu != null && a.this.jNu.cla() != null) {
                a.this.jNq.showPostThreadLoadingView(false);
                WriteData cla = writeData == null ? a.this.jNu.cla() : writeData;
                if (z) {
                    a.this.jNv = true;
                    if (cla.getType() != 0 || cla.isUserFeedback()) {
                        if (postWriteCallBackData == null) {
                            c.g(a.this.jNq.getContext().getActivity(), a.this.jNq.getContext().getResources().getString(R.string.send_success), null, null);
                        } else {
                            c.g(a.this.jNq.getContext().getActivity(), postWriteCallBackData.getErrorString(), postWriteCallBackData.getPreMsg(), postWriteCallBackData.getColorMsg());
                        }
                    }
                    Intent intent = new Intent();
                    Bundle bundle = new Bundle();
                    bundle.putSerializable("post_write_callback_data", postWriteCallBackData);
                    intent.putExtras(bundle);
                    BaseActivity context = a.this.jNq.getContext();
                    a.this.jNq.getContext();
                    context.setResult(-1, intent);
                    a.this.jNq.getContext().finish();
                } else if (cla != null && yVar != null && !TextUtils.isEmpty(yVar.apr())) {
                    cla.setVcodeMD5(yVar.getVcode_md5());
                    cla.setVcodeUrl(yVar.getVcode_pic_url());
                    cla.setVcodeExtra(yVar.aps());
                    a.this.jNq.getContext().setVisible(false);
                    if (com.baidu.tbadk.v.a.qv(yVar.apr())) {
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new NewVcodeActivityConfig(a.this.jNq.getContext().getActivity(), RequestResponseCode.REQUEST_VCODE, cla, false, yVar.apr())));
                    } else {
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new VcodeActivityConfig(a.this.jNq.getContext().getActivity(), cla, RequestResponseCode.REQUEST_VCODE)));
                    }
                } else if (postWriteCallBackData != null && postWriteCallBackData.isSensitiveError()) {
                    Intent intent2 = new Intent();
                    Bundle bundle2 = new Bundle();
                    bundle2.putSerializable("post_write_callback_data", postWriteCallBackData);
                    intent2.putExtras(bundle2);
                    BaseActivity context2 = a.this.jNq.getContext();
                    a.this.jNq.getContext();
                    context2.setResult(0, intent2);
                    a.this.jNq.getContext().finish();
                } else {
                    if (postWriteCallBackData != null) {
                        c.g(a.this.jNq.getContext().getActivity(), postWriteCallBackData.getErrorString(), postWriteCallBackData.getPreMsg(), postWriteCallBackData.getColorMsg());
                        BaseActivity context3 = a.this.jNq.getContext();
                        a.this.jNq.getContext();
                        context3.setResult(0, null);
                    }
                    a.this.jNq.getContext().finish();
                }
            }
        }
    };

    public a(b bVar, NewWriteModel newWriteModel) {
        this.jNq = bVar;
        this.jNu = newWriteModel;
        newWriteModel.b(this.cGo);
    }

    public boolean Fz(String str) {
        if (this.jNq == null || str == null) {
            return false;
        }
        if (str.equals("http://tieba.baidu.com/account/access/cancel")) {
            this.jNq.getContext().finish();
            return true;
        } else if (str.equals("http://tieba.baidu.com/account/access/input_focus")) {
            this.jNq.C(0, UtilHelper.getImmersiveStickyBarHeight(), 0, 0);
            if (this.jNq.cxZ() != this.jNq.dy()) {
                this.jNq.setRatio(this.jNq.cxZ());
                this.jNq.cya();
            }
            this.jNq.getWebView().setVisibility(0);
            return true;
        } else if (str.equals("http://tieba.baidu.com/account/access/valid_success")) {
            cxY();
            return true;
        } else if (str.equals("http://tieba.baidu.com/account/access/feedback") || str.equals("https://tieba.baidu.com/account/access/feedback")) {
            this.jNq.getContext().finish();
            ba.amO().b(this.jNq.getContext().getPageContext(), new String[]{UrlSchemaHelper.SCHEMA_TYPE_FEED_BACK});
            return true;
        } else {
            return true;
        }
    }

    public void cxW() {
        if (this.jNq != null) {
            this.jNq.showWebViewDelay(500);
        }
    }

    public void P(String str) {
        if (this.jNq != null) {
            this.jNq.rP(true);
            this.jNq.showWebView(false);
            this.jNq.getWebView().loadUrl(str);
        }
    }

    public void cxX() {
        if (this.jNq != null) {
            this.jNq.showPostThreadLoadingView(false);
        }
    }

    private void cxY() {
        this.jNv = false;
        if (this.jNq != null && this.jNu != null) {
            if (!l.isNetOk()) {
                this.jNq.getContext().showToast(R.string.neterror);
                this.jNq.getContext().finish();
                return;
            }
            this.jNq.showPostThreadLoadingView(true);
            this.jNu.cpC();
        }
    }
}
