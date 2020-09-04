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
    private final b mNd;
    private final NewWriteModel mNg;
    private boolean mNh = false;
    private final NewWriteModel.d eMH = new NewWriteModel.d() { // from class: com.baidu.tieba.write.accountAccess.a.1
        @Override // com.baidu.tieba.tbadkCore.writeModel.NewWriteModel.d
        public void callback(boolean z, PostWriteCallBackData postWriteCallBackData, ag agVar, WriteData writeData, AntiData antiData) {
            if (a.this.mNd != null && a.this.mNg != null && a.this.mNg.cLa() != null) {
                a.this.mNd.showPostThreadLoadingView(false);
                WriteData cLa = writeData == null ? a.this.mNg.cLa() : writeData;
                if (z) {
                    a.this.mNh = true;
                    if (cLa.getType() != 0 || cLa.isUserFeedback()) {
                        if (postWriteCallBackData == null) {
                            c.g(a.this.mNd.getContext().getActivity(), a.this.mNd.getContext().getResources().getString(R.string.send_success), null, null);
                        } else {
                            c.g(a.this.mNd.getContext().getActivity(), postWriteCallBackData.getErrorString(), postWriteCallBackData.getPreMsg(), postWriteCallBackData.getColorMsg());
                        }
                    }
                    Intent intent = new Intent();
                    Bundle bundle = new Bundle();
                    bundle.putSerializable("post_write_callback_data", postWriteCallBackData);
                    intent.putExtras(bundle);
                    BaseActivity context = a.this.mNd.getContext();
                    a.this.mNd.getContext();
                    context.setResult(-1, intent);
                    a.this.mNd.getContext().finish();
                } else if (cLa != null && agVar != null && !TextUtils.isEmpty(agVar.bmY())) {
                    cLa.setVcodeMD5(agVar.getVcode_md5());
                    cLa.setVcodeUrl(agVar.getVcode_pic_url());
                    cLa.setVcodeExtra(agVar.bmZ());
                    a.this.mNd.getContext().setVisible(false);
                    if (com.baidu.tbadk.t.a.CP(agVar.bmY())) {
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new NewVcodeActivityConfig(a.this.mNd.getContext().getActivity(), RequestResponseCode.REQUEST_VCODE, cLa, false, agVar.bmY())));
                    } else {
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new VcodeActivityConfig(a.this.mNd.getContext().getActivity(), cLa, RequestResponseCode.REQUEST_VCODE)));
                    }
                } else if (postWriteCallBackData != null && postWriteCallBackData.isSensitiveError()) {
                    Intent intent2 = new Intent();
                    Bundle bundle2 = new Bundle();
                    bundle2.putSerializable("post_write_callback_data", postWriteCallBackData);
                    intent2.putExtras(bundle2);
                    BaseActivity context2 = a.this.mNd.getContext();
                    a.this.mNd.getContext();
                    context2.setResult(0, intent2);
                    a.this.mNd.getContext().finish();
                } else {
                    if (postWriteCallBackData != null) {
                        c.g(a.this.mNd.getContext().getActivity(), postWriteCallBackData.getErrorString(), postWriteCallBackData.getPreMsg(), postWriteCallBackData.getColorMsg());
                        BaseActivity context3 = a.this.mNd.getContext();
                        a.this.mNd.getContext();
                        context3.setResult(0, null);
                    }
                    a.this.mNd.getContext().finish();
                }
            }
        }
    };

    public a(b bVar, NewWriteModel newWriteModel) {
        this.mNd = bVar;
        this.mNg = newWriteModel;
        newWriteModel.b(this.eMH);
    }

    public boolean SB(String str) {
        if (this.mNd == null || str == null) {
            return false;
        }
        if (str.equals("http://tieba.baidu.com/account/access/cancel")) {
            this.mNd.getContext().finish();
            return true;
        } else if (str.equals("http://tieba.baidu.com/account/access/input_focus")) {
            this.mNd.setWebViewMargin(0, UtilHelper.getImmersiveStickyBarHeight(), 0, 0);
            if (this.mNd.dGa() != this.mNd.dFZ()) {
                this.mNd.setRatio(this.mNd.dGa());
                this.mNd.dGb();
            }
            this.mNd.getWebView().setVisibility(0);
            return true;
        } else if (str.equals("http://tieba.baidu.com/account/access/valid_success")) {
            dFY();
            return true;
        } else if (str.equals("http://tieba.baidu.com/account/access/feedback") || str.equals("https://tieba.baidu.com/account/access/feedback")) {
            this.mNd.getContext().finish();
            be.bju().b(this.mNd.getContext().getPageContext(), new String[]{UrlSchemaHelper.SCHEMA_TYPE_FEED_BACK});
            return true;
        } else {
            return true;
        }
    }

    public void dFW() {
        if (this.mNd != null) {
            this.mNd.showWebViewDelay(500);
        }
    }

    public void bq(String str) {
        if (this.mNd != null) {
            this.mNd.xf(true);
            this.mNd.showWebView(false);
            this.mNd.getWebView().loadUrl(str);
        }
    }

    public void dFX() {
        if (this.mNd != null) {
            this.mNd.showPostThreadLoadingView(false);
        }
    }

    private void dFY() {
        this.mNh = false;
        if (this.mNd != null && this.mNg != null) {
            if (!l.isNetOk()) {
                this.mNd.getContext().showToast(R.string.neterror);
                this.mNd.getContext().finish();
                return;
            }
            this.mNd.showPostThreadLoadingView(true);
            this.mNg.dxX();
        }
    }
}
