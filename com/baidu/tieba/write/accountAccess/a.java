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
/* loaded from: classes10.dex */
public class a {
    private final b kIe;
    private final NewWriteModel kIi;
    private boolean kIj = false;
    private final NewWriteModel.d dui = new NewWriteModel.d() { // from class: com.baidu.tieba.write.accountAccess.a.1
        @Override // com.baidu.tieba.tbadkCore.writeModel.NewWriteModel.d
        public void callback(boolean z, PostWriteCallBackData postWriteCallBackData, y yVar, WriteData writeData, AntiData antiData) {
            if (a.this.kIe != null && a.this.kIi != null && a.this.kIi.cFi() != null) {
                a.this.kIe.showPostThreadLoadingView(false);
                WriteData cFi = writeData == null ? a.this.kIi.cFi() : writeData;
                if (z) {
                    a.this.kIj = true;
                    if (cFi.getType() != 0 || cFi.isUserFeedback()) {
                        if (postWriteCallBackData == null) {
                            c.f(a.this.kIe.getContext().getActivity(), a.this.kIe.getContext().getResources().getString(R.string.send_success), null, null);
                        } else {
                            c.f(a.this.kIe.getContext().getActivity(), postWriteCallBackData.getErrorString(), postWriteCallBackData.getPreMsg(), postWriteCallBackData.getColorMsg());
                        }
                    }
                    Intent intent = new Intent();
                    Bundle bundle = new Bundle();
                    bundle.putSerializable("post_write_callback_data", postWriteCallBackData);
                    intent.putExtras(bundle);
                    BaseActivity context = a.this.kIe.getContext();
                    a.this.kIe.getContext();
                    context.setResult(-1, intent);
                    a.this.kIe.getContext().finish();
                } else if (cFi != null && yVar != null && !TextUtils.isEmpty(yVar.aGQ())) {
                    cFi.setVcodeMD5(yVar.getVcode_md5());
                    cFi.setVcodeUrl(yVar.getVcode_pic_url());
                    cFi.setVcodeExtra(yVar.aGR());
                    a.this.kIe.getContext().setVisible(false);
                    if (com.baidu.tbadk.s.a.vB(yVar.aGQ())) {
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new NewVcodeActivityConfig(a.this.kIe.getContext().getActivity(), RequestResponseCode.REQUEST_VCODE, cFi, false, yVar.aGQ())));
                    } else {
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new VcodeActivityConfig(a.this.kIe.getContext().getActivity(), cFi, RequestResponseCode.REQUEST_VCODE)));
                    }
                } else if (postWriteCallBackData != null && postWriteCallBackData.isSensitiveError()) {
                    Intent intent2 = new Intent();
                    Bundle bundle2 = new Bundle();
                    bundle2.putSerializable("post_write_callback_data", postWriteCallBackData);
                    intent2.putExtras(bundle2);
                    BaseActivity context2 = a.this.kIe.getContext();
                    a.this.kIe.getContext();
                    context2.setResult(0, intent2);
                    a.this.kIe.getContext().finish();
                } else {
                    if (postWriteCallBackData != null) {
                        c.f(a.this.kIe.getContext().getActivity(), postWriteCallBackData.getErrorString(), postWriteCallBackData.getPreMsg(), postWriteCallBackData.getColorMsg());
                        BaseActivity context3 = a.this.kIe.getContext();
                        a.this.kIe.getContext();
                        context3.setResult(0, null);
                    }
                    a.this.kIe.getContext().finish();
                }
            }
        }
    };

    public a(b bVar, NewWriteModel newWriteModel) {
        this.kIe = bVar;
        this.kIi = newWriteModel;
        newWriteModel.b(this.dui);
    }

    public boolean Kr(String str) {
        if (this.kIe == null || str == null) {
            return false;
        }
        if (str.equals("http://tieba.baidu.com/account/access/cancel")) {
            this.kIe.getContext().finish();
            return true;
        } else if (str.equals("http://tieba.baidu.com/account/access/input_focus")) {
            this.kIe.setWebViewMargin(0, UtilHelper.getImmersiveStickyBarHeight(), 0, 0);
            if (this.kIe.cSb() != this.kIe.dS()) {
                this.kIe.setRatio(this.kIe.cSb());
                this.kIe.cSc();
            }
            this.kIe.getWebView().setVisibility(0);
            return true;
        } else if (str.equals("http://tieba.baidu.com/account/access/valid_success")) {
            cSa();
            return true;
        } else if (str.equals("http://tieba.baidu.com/account/access/feedback") || str.equals("https://tieba.baidu.com/account/access/feedback")) {
            this.kIe.getContext().finish();
            ba.aEa().b(this.kIe.getContext().getPageContext(), new String[]{UrlSchemaHelper.SCHEMA_TYPE_FEED_BACK});
            return true;
        } else {
            return true;
        }
    }

    public void cRY() {
        if (this.kIe != null) {
            this.kIe.showWebViewDelay(500);
        }
    }

    public void U(String str) {
        if (this.kIe != null) {
            this.kIe.tv(true);
            this.kIe.showWebView(false);
            this.kIe.getWebView().loadUrl(str);
        }
    }

    public void cRZ() {
        if (this.kIe != null) {
            this.kIe.showPostThreadLoadingView(false);
        }
    }

    private void cSa() {
        this.kIj = false;
        if (this.kIe != null && this.kIi != null) {
            if (!l.isNetOk()) {
                this.kIe.getContext().showToast(R.string.neterror);
                this.kIe.getContext().finish();
                return;
            }
            this.kIe.showPostThreadLoadingView(true);
            this.kIi.cJG();
        }
    }
}
