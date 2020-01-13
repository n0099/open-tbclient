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
import com.baidu.tbadk.coreExtra.data.z;
import com.baidu.tieba.R;
import com.baidu.tieba.tbadkCore.writeModel.NewWriteModel;
import com.baidu.tieba.tbadkCore.writeModel.PostWriteCallBackData;
import com.baidu.tieba.tbadkCore.writeModel.c;
/* loaded from: classes11.dex */
public class a {
    private final b kLF;
    private final NewWriteModel kLJ;
    private boolean kLK = false;
    private final NewWriteModel.d dut = new NewWriteModel.d() { // from class: com.baidu.tieba.write.accountAccess.a.1
        @Override // com.baidu.tieba.tbadkCore.writeModel.NewWriteModel.d
        public void callback(boolean z, PostWriteCallBackData postWriteCallBackData, z zVar, WriteData writeData, AntiData antiData) {
            if (a.this.kLF != null && a.this.kLJ != null && a.this.kLJ.cGm() != null) {
                a.this.kLF.showPostThreadLoadingView(false);
                WriteData cGm = writeData == null ? a.this.kLJ.cGm() : writeData;
                if (z) {
                    a.this.kLK = true;
                    if (cGm.getType() != 0 || cGm.isUserFeedback()) {
                        if (postWriteCallBackData == null) {
                            c.g(a.this.kLF.getContext().getActivity(), a.this.kLF.getContext().getResources().getString(R.string.send_success), null, null);
                        } else {
                            c.g(a.this.kLF.getContext().getActivity(), postWriteCallBackData.getErrorString(), postWriteCallBackData.getPreMsg(), postWriteCallBackData.getColorMsg());
                        }
                    }
                    Intent intent = new Intent();
                    Bundle bundle = new Bundle();
                    bundle.putSerializable("post_write_callback_data", postWriteCallBackData);
                    intent.putExtras(bundle);
                    BaseActivity context = a.this.kLF.getContext();
                    a.this.kLF.getContext();
                    context.setResult(-1, intent);
                    a.this.kLF.getContext().finish();
                } else if (cGm != null && zVar != null && !TextUtils.isEmpty(zVar.aHk())) {
                    cGm.setVcodeMD5(zVar.getVcode_md5());
                    cGm.setVcodeUrl(zVar.getVcode_pic_url());
                    cGm.setVcodeExtra(zVar.aHl());
                    a.this.kLF.getContext().setVisible(false);
                    if (com.baidu.tbadk.s.a.vG(zVar.aHk())) {
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new NewVcodeActivityConfig(a.this.kLF.getContext().getActivity(), RequestResponseCode.REQUEST_VCODE, cGm, false, zVar.aHk())));
                    } else {
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new VcodeActivityConfig(a.this.kLF.getContext().getActivity(), cGm, RequestResponseCode.REQUEST_VCODE)));
                    }
                } else if (postWriteCallBackData != null && postWriteCallBackData.isSensitiveError()) {
                    Intent intent2 = new Intent();
                    Bundle bundle2 = new Bundle();
                    bundle2.putSerializable("post_write_callback_data", postWriteCallBackData);
                    intent2.putExtras(bundle2);
                    BaseActivity context2 = a.this.kLF.getContext();
                    a.this.kLF.getContext();
                    context2.setResult(0, intent2);
                    a.this.kLF.getContext().finish();
                } else {
                    if (postWriteCallBackData != null) {
                        c.g(a.this.kLF.getContext().getActivity(), postWriteCallBackData.getErrorString(), postWriteCallBackData.getPreMsg(), postWriteCallBackData.getColorMsg());
                        BaseActivity context3 = a.this.kLF.getContext();
                        a.this.kLF.getContext();
                        context3.setResult(0, null);
                    }
                    a.this.kLF.getContext().finish();
                }
            }
        }
    };

    public a(b bVar, NewWriteModel newWriteModel) {
        this.kLF = bVar;
        this.kLJ = newWriteModel;
        newWriteModel.b(this.dut);
    }

    public boolean KB(String str) {
        if (this.kLF == null || str == null) {
            return false;
        }
        if (str.equals("http://tieba.baidu.com/account/access/cancel")) {
            this.kLF.getContext().finish();
            return true;
        } else if (str.equals("http://tieba.baidu.com/account/access/input_focus")) {
            this.kLF.setWebViewMargin(0, UtilHelper.getImmersiveStickyBarHeight(), 0, 0);
            if (this.kLF.cTe() != this.kLF.dS()) {
                this.kLF.setRatio(this.kLF.cTe());
                this.kLF.cTf();
            }
            this.kLF.getWebView().setVisibility(0);
            return true;
        } else if (str.equals("http://tieba.baidu.com/account/access/valid_success")) {
            cTd();
            return true;
        } else if (str.equals("http://tieba.baidu.com/account/access/feedback") || str.equals("https://tieba.baidu.com/account/access/feedback")) {
            this.kLF.getContext().finish();
            ba.aEt().b(this.kLF.getContext().getPageContext(), new String[]{UrlSchemaHelper.SCHEMA_TYPE_FEED_BACK});
            return true;
        } else {
            return true;
        }
    }

    public void cTb() {
        if (this.kLF != null) {
            this.kLF.showWebViewDelay(500);
        }
    }

    public void U(String str) {
        if (this.kLF != null) {
            this.kLF.tH(true);
            this.kLF.showWebView(false);
            this.kLF.getWebView().loadUrl(str);
        }
    }

    public void cTc() {
        if (this.kLF != null) {
            this.kLF.showPostThreadLoadingView(false);
        }
    }

    private void cTd() {
        this.kLK = false;
        if (this.kLF != null && this.kLJ != null) {
            if (!l.isNetOk()) {
                this.kLF.getContext().showToast(R.string.neterror);
                this.kLF.getContext().finish();
                return;
            }
            this.kLF.showPostThreadLoadingView(true);
            this.kLJ.cKK();
        }
    }
}
