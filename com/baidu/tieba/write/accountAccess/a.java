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
/* loaded from: classes7.dex */
public class a {
    private final b oge;
    private final NewWriteModel ogh;
    private boolean ogi = false;
    private final NewWriteModel.d fFv = new NewWriteModel.d() { // from class: com.baidu.tieba.write.accountAccess.a.1
        @Override // com.baidu.tieba.tbadkCore.writeModel.NewWriteModel.d
        public void callback(boolean z, PostWriteCallBackData postWriteCallBackData, ah ahVar, WriteData writeData, AntiData antiData) {
            if (a.this.oge != null && a.this.ogh != null && a.this.ogh.daL() != null) {
                a.this.oge.showPostThreadLoadingView(false);
                WriteData daL = writeData == null ? a.this.ogh.daL() : writeData;
                if (z) {
                    a.this.ogi = true;
                    if (daL.getType() != 0 || daL.isUserFeedback()) {
                        if (postWriteCallBackData == null) {
                            g.j(a.this.oge.getContext().getActivity(), a.this.oge.getContext().getResources().getString(R.string.send_success), null, null);
                        } else {
                            g.j(a.this.oge.getContext().getActivity(), postWriteCallBackData.getErrorString(), postWriteCallBackData.getPreMsg(), postWriteCallBackData.getColorMsg());
                        }
                    }
                    Intent intent = new Intent();
                    Bundle bundle = new Bundle();
                    bundle.putSerializable("post_write_callback_data", postWriteCallBackData);
                    intent.putExtras(bundle);
                    BaseActivity context = a.this.oge.getContext();
                    a.this.oge.getContext();
                    context.setResult(-1, intent);
                    a.this.oge.getContext().finish();
                } else if (daL != null && ahVar != null && !TextUtils.isEmpty(ahVar.bwH())) {
                    daL.setVcodeMD5(ahVar.getVcode_md5());
                    daL.setVcodeUrl(ahVar.getVcode_pic_url());
                    daL.setVcodeExtra(ahVar.bwI());
                    a.this.oge.getContext().setVisible(false);
                    if (com.baidu.tbadk.t.a.Ef(ahVar.bwH())) {
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new NewVcodeActivityConfig(a.this.oge.getContext().getActivity(), RequestResponseCode.REQUEST_VCODE, daL, false, ahVar.bwH())));
                    } else {
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new VcodeActivityConfig(a.this.oge.getContext().getActivity(), daL, RequestResponseCode.REQUEST_VCODE)));
                    }
                } else if (postWriteCallBackData != null && postWriteCallBackData.isSensitiveError()) {
                    Intent intent2 = new Intent();
                    Bundle bundle2 = new Bundle();
                    bundle2.putSerializable("post_write_callback_data", postWriteCallBackData);
                    intent2.putExtras(bundle2);
                    BaseActivity context2 = a.this.oge.getContext();
                    a.this.oge.getContext();
                    context2.setResult(0, intent2);
                    a.this.oge.getContext().finish();
                } else {
                    if (postWriteCallBackData != null) {
                        g.j(a.this.oge.getContext().getActivity(), postWriteCallBackData.getErrorString(), postWriteCallBackData.getPreMsg(), postWriteCallBackData.getColorMsg());
                        BaseActivity context3 = a.this.oge.getContext();
                        a.this.oge.getContext();
                        context3.setResult(0, null);
                    }
                    a.this.oge.getContext().finish();
                }
            }
        }
    };

    public a(b bVar, NewWriteModel newWriteModel) {
        this.oge = bVar;
        this.ogh = newWriteModel;
        newWriteModel.b(this.fFv);
    }

    public boolean Vt(String str) {
        if (this.oge == null || str == null) {
            return false;
        }
        if (str.equals("http://tieba.baidu.com/account/access/cancel")) {
            this.oge.getContext().finish();
            return true;
        } else if (str.equals("http://tieba.baidu.com/account/access/input_focus")) {
            this.oge.setWebViewMargin(0, UtilHelper.getImmersiveStickyBarHeight(), 0, 0);
            if (this.oge.dWY() != this.oge.getRatio()) {
                this.oge.setRatio(this.oge.dWY());
                this.oge.dWZ();
            }
            this.oge.getWebView().setVisibility(0);
            return true;
        } else if (str.equals("http://tieba.baidu.com/account/access/valid_success")) {
            dWX();
            return true;
        } else if (str.equals("http://tieba.baidu.com/account/access/feedback") || str.equals("https://tieba.baidu.com/account/access/feedback")) {
            this.oge.getContext().finish();
            bf.bsY().b(this.oge.getContext().getPageContext(), new String[]{UrlSchemaHelper.SCHEMA_TYPE_FEED_BACK});
            return true;
        } else {
            return true;
        }
    }

    public void dWV() {
        if (this.oge != null) {
            this.oge.showWebViewDelay(500);
        }
    }

    public void start(String str) {
        if (this.oge != null) {
            this.oge.zz(true);
            this.oge.showWebView(false);
            this.oge.getWebView().loadUrl(str);
        }
    }

    public void dWW() {
        if (this.oge != null) {
            this.oge.showPostThreadLoadingView(false);
        }
    }

    private void dWX() {
        this.ogi = false;
        if (this.oge != null && this.ogh != null) {
            if (!l.isNetOk()) {
                this.oge.getContext().showToast(R.string.neterror);
                this.oge.getContext().finish();
                return;
            }
            this.oge.showPostThreadLoadingView(true);
            this.ogh.dPm();
        }
    }
}
