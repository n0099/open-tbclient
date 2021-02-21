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
    private final b odY;
    private final NewWriteModel oeb;
    private boolean oec = false;
    private final NewWriteModel.d fDW = new NewWriteModel.d() { // from class: com.baidu.tieba.write.accountAccess.a.1
        @Override // com.baidu.tieba.tbadkCore.writeModel.NewWriteModel.d
        public void callback(boolean z, PostWriteCallBackData postWriteCallBackData, ah ahVar, WriteData writeData, AntiData antiData) {
            if (a.this.odY != null && a.this.oeb != null && a.this.oeb.daC() != null) {
                a.this.odY.showPostThreadLoadingView(false);
                WriteData daC = writeData == null ? a.this.oeb.daC() : writeData;
                if (z) {
                    a.this.oec = true;
                    if (daC.getType() != 0 || daC.isUserFeedback()) {
                        if (postWriteCallBackData == null) {
                            g.j(a.this.odY.getContext().getActivity(), a.this.odY.getContext().getResources().getString(R.string.send_success), null, null);
                        } else {
                            g.j(a.this.odY.getContext().getActivity(), postWriteCallBackData.getErrorString(), postWriteCallBackData.getPreMsg(), postWriteCallBackData.getColorMsg());
                        }
                    }
                    Intent intent = new Intent();
                    Bundle bundle = new Bundle();
                    bundle.putSerializable("post_write_callback_data", postWriteCallBackData);
                    intent.putExtras(bundle);
                    BaseActivity context = a.this.odY.getContext();
                    a.this.odY.getContext();
                    context.setResult(-1, intent);
                    a.this.odY.getContext().finish();
                } else if (daC != null && ahVar != null && !TextUtils.isEmpty(ahVar.bwE())) {
                    daC.setVcodeMD5(ahVar.getVcode_md5());
                    daC.setVcodeUrl(ahVar.getVcode_pic_url());
                    daC.setVcodeExtra(ahVar.bwF());
                    a.this.odY.getContext().setVisible(false);
                    if (com.baidu.tbadk.t.a.DY(ahVar.bwE())) {
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new NewVcodeActivityConfig(a.this.odY.getContext().getActivity(), RequestResponseCode.REQUEST_VCODE, daC, false, ahVar.bwE())));
                    } else {
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new VcodeActivityConfig(a.this.odY.getContext().getActivity(), daC, RequestResponseCode.REQUEST_VCODE)));
                    }
                } else if (postWriteCallBackData != null && postWriteCallBackData.isSensitiveError()) {
                    Intent intent2 = new Intent();
                    Bundle bundle2 = new Bundle();
                    bundle2.putSerializable("post_write_callback_data", postWriteCallBackData);
                    intent2.putExtras(bundle2);
                    BaseActivity context2 = a.this.odY.getContext();
                    a.this.odY.getContext();
                    context2.setResult(0, intent2);
                    a.this.odY.getContext().finish();
                } else {
                    if (postWriteCallBackData != null) {
                        g.j(a.this.odY.getContext().getActivity(), postWriteCallBackData.getErrorString(), postWriteCallBackData.getPreMsg(), postWriteCallBackData.getColorMsg());
                        BaseActivity context3 = a.this.odY.getContext();
                        a.this.odY.getContext();
                        context3.setResult(0, null);
                    }
                    a.this.odY.getContext().finish();
                }
            }
        }
    };

    public a(b bVar, NewWriteModel newWriteModel) {
        this.odY = bVar;
        this.oeb = newWriteModel;
        newWriteModel.b(this.fDW);
    }

    public boolean Vm(String str) {
        if (this.odY == null || str == null) {
            return false;
        }
        if (str.equals("http://tieba.baidu.com/account/access/cancel")) {
            this.odY.getContext().finish();
            return true;
        } else if (str.equals("http://tieba.baidu.com/account/access/input_focus")) {
            this.odY.setWebViewMargin(0, UtilHelper.getImmersiveStickyBarHeight(), 0, 0);
            if (this.odY.dWQ() != this.odY.getRatio()) {
                this.odY.setRatio(this.odY.dWQ());
                this.odY.dWR();
            }
            this.odY.getWebView().setVisibility(0);
            return true;
        } else if (str.equals("http://tieba.baidu.com/account/access/valid_success")) {
            dWP();
            return true;
        } else if (str.equals("http://tieba.baidu.com/account/access/feedback") || str.equals("https://tieba.baidu.com/account/access/feedback")) {
            this.odY.getContext().finish();
            bf.bsV().b(this.odY.getContext().getPageContext(), new String[]{UrlSchemaHelper.SCHEMA_TYPE_FEED_BACK});
            return true;
        } else {
            return true;
        }
    }

    public void dWN() {
        if (this.odY != null) {
            this.odY.showWebViewDelay(500);
        }
    }

    public void start(String str) {
        if (this.odY != null) {
            this.odY.zA(true);
            this.odY.showWebView(false);
            this.odY.getWebView().loadUrl(str);
        }
    }

    public void dWO() {
        if (this.odY != null) {
            this.odY.showPostThreadLoadingView(false);
        }
    }

    private void dWP() {
        this.oec = false;
        if (this.odY != null && this.oeb != null) {
            if (!l.isNetOk()) {
                this.odY.getContext().showToast(R.string.neterror);
                this.odY.getContext().finish();
                return;
            }
            this.odY.showPostThreadLoadingView(true);
            this.oeb.dPd();
        }
    }
}
