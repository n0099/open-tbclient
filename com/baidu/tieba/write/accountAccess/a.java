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
import com.baidu.tieba.tbadkCore.writeModel.g;
/* loaded from: classes7.dex */
public class a {
    private final b nTs;
    private final NewWriteModel nTv;
    private boolean nTw = false;
    private final NewWriteModel.d fBH = new NewWriteModel.d() { // from class: com.baidu.tieba.write.accountAccess.a.1
        @Override // com.baidu.tieba.tbadkCore.writeModel.NewWriteModel.d
        public void callback(boolean z, PostWriteCallBackData postWriteCallBackData, ah ahVar, WriteData writeData, AntiData antiData) {
            if (a.this.nTs != null && a.this.nTv != null && a.this.nTv.cYx() != null) {
                a.this.nTs.showPostThreadLoadingView(false);
                WriteData cYx = writeData == null ? a.this.nTv.cYx() : writeData;
                if (z) {
                    a.this.nTw = true;
                    if (cYx.getType() != 0 || cYx.isUserFeedback()) {
                        if (postWriteCallBackData == null) {
                            g.i(a.this.nTs.getContext().getActivity(), a.this.nTs.getContext().getResources().getString(R.string.send_success), null, null);
                        } else {
                            g.i(a.this.nTs.getContext().getActivity(), postWriteCallBackData.getErrorString(), postWriteCallBackData.getPreMsg(), postWriteCallBackData.getColorMsg());
                        }
                    }
                    Intent intent = new Intent();
                    Bundle bundle = new Bundle();
                    bundle.putSerializable("post_write_callback_data", postWriteCallBackData);
                    intent.putExtras(bundle);
                    BaseActivity context = a.this.nTs.getContext();
                    a.this.nTs.getContext();
                    context.setResult(-1, intent);
                    a.this.nTs.getContext().finish();
                } else if (cYx != null && ahVar != null && !TextUtils.isEmpty(ahVar.bwm())) {
                    cYx.setVcodeMD5(ahVar.getVcode_md5());
                    cYx.setVcodeUrl(ahVar.getVcode_pic_url());
                    cYx.setVcodeExtra(ahVar.bwn());
                    a.this.nTs.getContext().setVisible(false);
                    if (com.baidu.tbadk.t.a.DE(ahVar.bwm())) {
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new NewVcodeActivityConfig(a.this.nTs.getContext().getActivity(), RequestResponseCode.REQUEST_VCODE, cYx, false, ahVar.bwm())));
                    } else {
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new VcodeActivityConfig(a.this.nTs.getContext().getActivity(), cYx, RequestResponseCode.REQUEST_VCODE)));
                    }
                } else if (postWriteCallBackData != null && postWriteCallBackData.isSensitiveError()) {
                    Intent intent2 = new Intent();
                    Bundle bundle2 = new Bundle();
                    bundle2.putSerializable("post_write_callback_data", postWriteCallBackData);
                    intent2.putExtras(bundle2);
                    BaseActivity context2 = a.this.nTs.getContext();
                    a.this.nTs.getContext();
                    context2.setResult(0, intent2);
                    a.this.nTs.getContext().finish();
                } else {
                    if (postWriteCallBackData != null) {
                        g.i(a.this.nTs.getContext().getActivity(), postWriteCallBackData.getErrorString(), postWriteCallBackData.getPreMsg(), postWriteCallBackData.getColorMsg());
                        BaseActivity context3 = a.this.nTs.getContext();
                        a.this.nTs.getContext();
                        context3.setResult(0, null);
                    }
                    a.this.nTs.getContext().finish();
                }
            }
        }
    };

    public a(b bVar, NewWriteModel newWriteModel) {
        this.nTs = bVar;
        this.nTv = newWriteModel;
        newWriteModel.b(this.fBH);
    }

    public boolean Uc(String str) {
        if (this.nTs == null || str == null) {
            return false;
        }
        if (str.equals("http://tieba.baidu.com/account/access/cancel")) {
            this.nTs.getContext().finish();
            return true;
        } else if (str.equals("http://tieba.baidu.com/account/access/input_focus")) {
            this.nTs.setWebViewMargin(0, UtilHelper.getImmersiveStickyBarHeight(), 0, 0);
            if (this.nTs.dUu() != this.nTs.getRatio()) {
                this.nTs.setRatio(this.nTs.dUu());
                this.nTs.dUv();
            }
            this.nTs.getWebView().setVisibility(0);
            return true;
        } else if (str.equals("http://tieba.baidu.com/account/access/valid_success")) {
            dUt();
            return true;
        } else if (str.equals("http://tieba.baidu.com/account/access/feedback") || str.equals("https://tieba.baidu.com/account/access/feedback")) {
            this.nTs.getContext().finish();
            be.bsB().b(this.nTs.getContext().getPageContext(), new String[]{UrlSchemaHelper.SCHEMA_TYPE_FEED_BACK});
            return true;
        } else {
            return true;
        }
    }

    public void dUr() {
        if (this.nTs != null) {
            this.nTs.showWebViewDelay(500);
        }
    }

    public void start(String str) {
        if (this.nTs != null) {
            this.nTs.ze(true);
            this.nTs.showWebView(false);
            this.nTs.getWebView().loadUrl(str);
        }
    }

    public void dUs() {
        if (this.nTs != null) {
            this.nTs.showPostThreadLoadingView(false);
        }
    }

    private void dUt() {
        this.nTw = false;
        if (this.nTs != null && this.nTv != null) {
            if (!l.isNetOk()) {
                this.nTs.getContext().showToast(R.string.neterror);
                this.nTs.getContext().finish();
                return;
            }
            this.nTs.showPostThreadLoadingView(true);
            this.nTv.dMK();
        }
    }
}
