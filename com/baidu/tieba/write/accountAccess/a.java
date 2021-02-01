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
import com.baidu.tbadk.core.util.bf;
import com.baidu.tbadk.coreExtra.data.WriteData;
import com.baidu.tbadk.coreExtra.data.ah;
import com.baidu.tieba.R;
import com.baidu.tieba.tbadkCore.writeModel.NewWriteModel;
import com.baidu.tieba.tbadkCore.writeModel.PostWriteCallBackData;
import com.baidu.tieba.tbadkCore.writeModel.g;
/* loaded from: classes8.dex */
public class a {
    private final NewWriteModel odB;
    private final b ody;
    private boolean odC = false;
    private final NewWriteModel.d fDW = new NewWriteModel.d() { // from class: com.baidu.tieba.write.accountAccess.a.1
        @Override // com.baidu.tieba.tbadkCore.writeModel.NewWriteModel.d
        public void callback(boolean z, PostWriteCallBackData postWriteCallBackData, ah ahVar, WriteData writeData, AntiData antiData) {
            if (a.this.ody != null && a.this.odB != null && a.this.odB.dav() != null) {
                a.this.ody.showPostThreadLoadingView(false);
                WriteData dav = writeData == null ? a.this.odB.dav() : writeData;
                if (z) {
                    a.this.odC = true;
                    if (dav.getType() != 0 || dav.isUserFeedback()) {
                        if (postWriteCallBackData == null) {
                            g.i(a.this.ody.getContext().getActivity(), a.this.ody.getContext().getResources().getString(R.string.send_success), null, null);
                        } else {
                            g.i(a.this.ody.getContext().getActivity(), postWriteCallBackData.getErrorString(), postWriteCallBackData.getPreMsg(), postWriteCallBackData.getColorMsg());
                        }
                    }
                    Intent intent = new Intent();
                    Bundle bundle = new Bundle();
                    bundle.putSerializable("post_write_callback_data", postWriteCallBackData);
                    intent.putExtras(bundle);
                    BaseActivity context = a.this.ody.getContext();
                    a.this.ody.getContext();
                    context.setResult(-1, intent);
                    a.this.ody.getContext().finish();
                } else if (dav != null && ahVar != null && !TextUtils.isEmpty(ahVar.bwE())) {
                    dav.setVcodeMD5(ahVar.getVcode_md5());
                    dav.setVcodeUrl(ahVar.getVcode_pic_url());
                    dav.setVcodeExtra(ahVar.bwF());
                    a.this.ody.getContext().setVisible(false);
                    if (com.baidu.tbadk.t.a.Ea(ahVar.bwE())) {
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new NewVcodeActivityConfig(a.this.ody.getContext().getActivity(), RequestResponseCode.REQUEST_VCODE, dav, false, ahVar.bwE())));
                    } else {
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new VcodeActivityConfig(a.this.ody.getContext().getActivity(), dav, RequestResponseCode.REQUEST_VCODE)));
                    }
                } else if (postWriteCallBackData != null && postWriteCallBackData.isSensitiveError()) {
                    Intent intent2 = new Intent();
                    Bundle bundle2 = new Bundle();
                    bundle2.putSerializable("post_write_callback_data", postWriteCallBackData);
                    intent2.putExtras(bundle2);
                    BaseActivity context2 = a.this.ody.getContext();
                    a.this.ody.getContext();
                    context2.setResult(0, intent2);
                    a.this.ody.getContext().finish();
                } else {
                    if (postWriteCallBackData != null) {
                        g.i(a.this.ody.getContext().getActivity(), postWriteCallBackData.getErrorString(), postWriteCallBackData.getPreMsg(), postWriteCallBackData.getColorMsg());
                        BaseActivity context3 = a.this.ody.getContext();
                        a.this.ody.getContext();
                        context3.setResult(0, null);
                    }
                    a.this.ody.getContext().finish();
                }
            }
        }
    };

    public a(b bVar, NewWriteModel newWriteModel) {
        this.ody = bVar;
        this.odB = newWriteModel;
        newWriteModel.b(this.fDW);
    }

    public boolean Va(String str) {
        if (this.ody == null || str == null) {
            return false;
        }
        if (str.equals("http://tieba.baidu.com/account/access/cancel")) {
            this.ody.getContext().finish();
            return true;
        } else if (str.equals("http://tieba.baidu.com/account/access/input_focus")) {
            this.ody.setWebViewMargin(0, UtilHelper.getImmersiveStickyBarHeight(), 0, 0);
            if (this.ody.dWI() != this.ody.getRatio()) {
                this.ody.setRatio(this.ody.dWI());
                this.ody.dWJ();
            }
            this.ody.getWebView().setVisibility(0);
            return true;
        } else if (str.equals("http://tieba.baidu.com/account/access/valid_success")) {
            dWH();
            return true;
        } else if (str.equals("http://tieba.baidu.com/account/access/feedback") || str.equals("https://tieba.baidu.com/account/access/feedback")) {
            this.ody.getContext().finish();
            bf.bsV().b(this.ody.getContext().getPageContext(), new String[]{UrlSchemaHelper.SCHEMA_TYPE_FEED_BACK});
            return true;
        } else {
            return true;
        }
    }

    public void dWF() {
        if (this.ody != null) {
            this.ody.showWebViewDelay(500);
        }
    }

    public void start(String str) {
        if (this.ody != null) {
            this.ody.zA(true);
            this.ody.showWebView(false);
            this.ody.getWebView().loadUrl(str);
        }
    }

    public void dWG() {
        if (this.ody != null) {
            this.ody.showPostThreadLoadingView(false);
        }
    }

    private void dWH() {
        this.odC = false;
        if (this.ody != null && this.odB != null) {
            if (!l.isNetOk()) {
                this.ody.getContext().showToast(R.string.neterror);
                this.ody.getContext().finish();
                return;
            }
            this.ody.showPostThreadLoadingView(true);
            this.odB.dOV();
        }
    }
}
