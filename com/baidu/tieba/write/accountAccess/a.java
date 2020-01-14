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
    private final b kLK;
    private final NewWriteModel kLO;
    private boolean kLP = false;
    private final NewWriteModel.d dut = new NewWriteModel.d() { // from class: com.baidu.tieba.write.accountAccess.a.1
        @Override // com.baidu.tieba.tbadkCore.writeModel.NewWriteModel.d
        public void callback(boolean z, PostWriteCallBackData postWriteCallBackData, z zVar, WriteData writeData, AntiData antiData) {
            if (a.this.kLK != null && a.this.kLO != null && a.this.kLO.cGo() != null) {
                a.this.kLK.showPostThreadLoadingView(false);
                WriteData cGo = writeData == null ? a.this.kLO.cGo() : writeData;
                if (z) {
                    a.this.kLP = true;
                    if (cGo.getType() != 0 || cGo.isUserFeedback()) {
                        if (postWriteCallBackData == null) {
                            c.g(a.this.kLK.getContext().getActivity(), a.this.kLK.getContext().getResources().getString(R.string.send_success), null, null);
                        } else {
                            c.g(a.this.kLK.getContext().getActivity(), postWriteCallBackData.getErrorString(), postWriteCallBackData.getPreMsg(), postWriteCallBackData.getColorMsg());
                        }
                    }
                    Intent intent = new Intent();
                    Bundle bundle = new Bundle();
                    bundle.putSerializable("post_write_callback_data", postWriteCallBackData);
                    intent.putExtras(bundle);
                    BaseActivity context = a.this.kLK.getContext();
                    a.this.kLK.getContext();
                    context.setResult(-1, intent);
                    a.this.kLK.getContext().finish();
                } else if (cGo != null && zVar != null && !TextUtils.isEmpty(zVar.aHk())) {
                    cGo.setVcodeMD5(zVar.getVcode_md5());
                    cGo.setVcodeUrl(zVar.getVcode_pic_url());
                    cGo.setVcodeExtra(zVar.aHl());
                    a.this.kLK.getContext().setVisible(false);
                    if (com.baidu.tbadk.s.a.vG(zVar.aHk())) {
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new NewVcodeActivityConfig(a.this.kLK.getContext().getActivity(), RequestResponseCode.REQUEST_VCODE, cGo, false, zVar.aHk())));
                    } else {
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new VcodeActivityConfig(a.this.kLK.getContext().getActivity(), cGo, RequestResponseCode.REQUEST_VCODE)));
                    }
                } else if (postWriteCallBackData != null && postWriteCallBackData.isSensitiveError()) {
                    Intent intent2 = new Intent();
                    Bundle bundle2 = new Bundle();
                    bundle2.putSerializable("post_write_callback_data", postWriteCallBackData);
                    intent2.putExtras(bundle2);
                    BaseActivity context2 = a.this.kLK.getContext();
                    a.this.kLK.getContext();
                    context2.setResult(0, intent2);
                    a.this.kLK.getContext().finish();
                } else {
                    if (postWriteCallBackData != null) {
                        c.g(a.this.kLK.getContext().getActivity(), postWriteCallBackData.getErrorString(), postWriteCallBackData.getPreMsg(), postWriteCallBackData.getColorMsg());
                        BaseActivity context3 = a.this.kLK.getContext();
                        a.this.kLK.getContext();
                        context3.setResult(0, null);
                    }
                    a.this.kLK.getContext().finish();
                }
            }
        }
    };

    public a(b bVar, NewWriteModel newWriteModel) {
        this.kLK = bVar;
        this.kLO = newWriteModel;
        newWriteModel.b(this.dut);
    }

    public boolean KB(String str) {
        if (this.kLK == null || str == null) {
            return false;
        }
        if (str.equals("http://tieba.baidu.com/account/access/cancel")) {
            this.kLK.getContext().finish();
            return true;
        } else if (str.equals("http://tieba.baidu.com/account/access/input_focus")) {
            this.kLK.setWebViewMargin(0, UtilHelper.getImmersiveStickyBarHeight(), 0, 0);
            if (this.kLK.cTg() != this.kLK.dS()) {
                this.kLK.setRatio(this.kLK.cTg());
                this.kLK.cTh();
            }
            this.kLK.getWebView().setVisibility(0);
            return true;
        } else if (str.equals("http://tieba.baidu.com/account/access/valid_success")) {
            cTf();
            return true;
        } else if (str.equals("http://tieba.baidu.com/account/access/feedback") || str.equals("https://tieba.baidu.com/account/access/feedback")) {
            this.kLK.getContext().finish();
            ba.aEt().b(this.kLK.getContext().getPageContext(), new String[]{UrlSchemaHelper.SCHEMA_TYPE_FEED_BACK});
            return true;
        } else {
            return true;
        }
    }

    public void cTd() {
        if (this.kLK != null) {
            this.kLK.showWebViewDelay(500);
        }
    }

    public void U(String str) {
        if (this.kLK != null) {
            this.kLK.tH(true);
            this.kLK.showWebView(false);
            this.kLK.getWebView().loadUrl(str);
        }
    }

    public void cTe() {
        if (this.kLK != null) {
            this.kLK.showPostThreadLoadingView(false);
        }
    }

    private void cTf() {
        this.kLP = false;
        if (this.kLK != null && this.kLO != null) {
            if (!l.isNetOk()) {
                this.kLK.getContext().showToast(R.string.neterror);
                this.kLK.getContext().finish();
                return;
            }
            this.kLK.showPostThreadLoadingView(true);
            this.kLO.cKM();
        }
    }
}
