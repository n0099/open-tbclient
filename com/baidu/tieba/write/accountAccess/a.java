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
import com.baidu.tbadk.coreExtra.data.ag;
import com.baidu.tieba.R;
import com.baidu.tieba.tbadkCore.writeModel.NewWriteModel;
import com.baidu.tieba.tbadkCore.writeModel.PostWriteCallBackData;
import com.baidu.tieba.tbadkCore.writeModel.c;
/* loaded from: classes3.dex */
public class a {
    private final b mML;
    private final NewWriteModel mMO;
    private boolean mMP = false;
    private final NewWriteModel.d eMD = new NewWriteModel.d() { // from class: com.baidu.tieba.write.accountAccess.a.1
        @Override // com.baidu.tieba.tbadkCore.writeModel.NewWriteModel.d
        public void callback(boolean z, PostWriteCallBackData postWriteCallBackData, ag agVar, WriteData writeData, AntiData antiData) {
            if (a.this.mML != null && a.this.mMO != null && a.this.mMO.cKZ() != null) {
                a.this.mML.showPostThreadLoadingView(false);
                WriteData cKZ = writeData == null ? a.this.mMO.cKZ() : writeData;
                if (z) {
                    a.this.mMP = true;
                    if (cKZ.getType() != 0 || cKZ.isUserFeedback()) {
                        if (postWriteCallBackData == null) {
                            c.g(a.this.mML.getContext().getActivity(), a.this.mML.getContext().getResources().getString(R.string.send_success), null, null);
                        } else {
                            c.g(a.this.mML.getContext().getActivity(), postWriteCallBackData.getErrorString(), postWriteCallBackData.getPreMsg(), postWriteCallBackData.getColorMsg());
                        }
                    }
                    Intent intent = new Intent();
                    Bundle bundle = new Bundle();
                    bundle.putSerializable("post_write_callback_data", postWriteCallBackData);
                    intent.putExtras(bundle);
                    BaseActivity context = a.this.mML.getContext();
                    a.this.mML.getContext();
                    context.setResult(-1, intent);
                    a.this.mML.getContext().finish();
                } else if (cKZ != null && agVar != null && !TextUtils.isEmpty(agVar.bmY())) {
                    cKZ.setVcodeMD5(agVar.getVcode_md5());
                    cKZ.setVcodeUrl(agVar.getVcode_pic_url());
                    cKZ.setVcodeExtra(agVar.bmZ());
                    a.this.mML.getContext().setVisible(false);
                    if (com.baidu.tbadk.t.a.CO(agVar.bmY())) {
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new NewVcodeActivityConfig(a.this.mML.getContext().getActivity(), RequestResponseCode.REQUEST_VCODE, cKZ, false, agVar.bmY())));
                    } else {
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new VcodeActivityConfig(a.this.mML.getContext().getActivity(), cKZ, RequestResponseCode.REQUEST_VCODE)));
                    }
                } else if (postWriteCallBackData != null && postWriteCallBackData.isSensitiveError()) {
                    Intent intent2 = new Intent();
                    Bundle bundle2 = new Bundle();
                    bundle2.putSerializable("post_write_callback_data", postWriteCallBackData);
                    intent2.putExtras(bundle2);
                    BaseActivity context2 = a.this.mML.getContext();
                    a.this.mML.getContext();
                    context2.setResult(0, intent2);
                    a.this.mML.getContext().finish();
                } else {
                    if (postWriteCallBackData != null) {
                        c.g(a.this.mML.getContext().getActivity(), postWriteCallBackData.getErrorString(), postWriteCallBackData.getPreMsg(), postWriteCallBackData.getColorMsg());
                        BaseActivity context3 = a.this.mML.getContext();
                        a.this.mML.getContext();
                        context3.setResult(0, null);
                    }
                    a.this.mML.getContext().finish();
                }
            }
        }
    };

    public a(b bVar, NewWriteModel newWriteModel) {
        this.mML = bVar;
        this.mMO = newWriteModel;
        newWriteModel.b(this.eMD);
    }

    public boolean SB(String str) {
        if (this.mML == null || str == null) {
            return false;
        }
        if (str.equals("http://tieba.baidu.com/account/access/cancel")) {
            this.mML.getContext().finish();
            return true;
        } else if (str.equals("http://tieba.baidu.com/account/access/input_focus")) {
            this.mML.setWebViewMargin(0, UtilHelper.getImmersiveStickyBarHeight(), 0, 0);
            if (this.mML.dFR() != this.mML.dFQ()) {
                this.mML.setRatio(this.mML.dFR());
                this.mML.dFS();
            }
            this.mML.getWebView().setVisibility(0);
            return true;
        } else if (str.equals("http://tieba.baidu.com/account/access/valid_success")) {
            dFP();
            return true;
        } else if (str.equals("http://tieba.baidu.com/account/access/feedback") || str.equals("https://tieba.baidu.com/account/access/feedback")) {
            this.mML.getContext().finish();
            be.bju().b(this.mML.getContext().getPageContext(), new String[]{UrlSchemaHelper.SCHEMA_TYPE_FEED_BACK});
            return true;
        } else {
            return true;
        }
    }

    public void dFN() {
        if (this.mML != null) {
            this.mML.showWebViewDelay(500);
        }
    }

    public void bq(String str) {
        if (this.mML != null) {
            this.mML.xd(true);
            this.mML.showWebView(false);
            this.mML.getWebView().loadUrl(str);
        }
    }

    public void dFO() {
        if (this.mML != null) {
            this.mML.showPostThreadLoadingView(false);
        }
    }

    private void dFP() {
        this.mMP = false;
        if (this.mML != null && this.mMO != null) {
            if (!l.isNetOk()) {
                this.mML.getContext().showToast(R.string.neterror);
                this.mML.getContext().finish();
                return;
            }
            this.mML.showPostThreadLoadingView(true);
            this.mMO.dxS();
        }
    }
}
