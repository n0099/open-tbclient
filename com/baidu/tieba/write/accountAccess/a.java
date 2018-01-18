package com.baidu.tieba.write.accountAccess;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.lib.util.l;
import com.baidu.sapi2.passhost.pluginsdk.service.IEventCenterService;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.core.atomData.NewVcodeActivityConfig;
import com.baidu.tbadk.core.atomData.VcodeActivityConfig;
import com.baidu.tbadk.core.data.AntiData;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.av;
import com.baidu.tbadk.coreExtra.data.WriteData;
import com.baidu.tbadk.coreExtra.data.t;
import com.baidu.tieba.d;
import com.baidu.tieba.tbadkCore.writeModel.NewWriteModel;
import com.baidu.tieba.tbadkCore.writeModel.PostWriteCallBackData;
import com.baidu.tieba.tbadkCore.writeModel.c;
/* loaded from: classes2.dex */
public class a {
    private final NewWriteModel hCA;
    private final b hCx;
    private boolean hCB = false;
    private final NewWriteModel.d brY = new NewWriteModel.d() { // from class: com.baidu.tieba.write.accountAccess.a.1
        @Override // com.baidu.tieba.tbadkCore.writeModel.NewWriteModel.d
        public void callback(boolean z, PostWriteCallBackData postWriteCallBackData, t tVar, WriteData writeData, AntiData antiData) {
            if (a.this.hCx != null && a.this.hCA != null && a.this.hCA.getWriteData() != null) {
                a.this.hCx.showPostThreadLoadingView(false);
                WriteData writeData2 = writeData == null ? a.this.hCA.getWriteData() : writeData;
                if (z) {
                    a.this.hCB = true;
                    if (writeData2.getIsStory() != 1 && (writeData2.getType() != 0 || writeData2.isUserFeedback())) {
                        if (postWriteCallBackData == null) {
                            c.e(a.this.hCx.getContext().getActivity(), a.this.hCx.getContext().getResources().getString(d.j.send_success), null, null);
                        } else {
                            c.e(a.this.hCx.getContext().getActivity(), postWriteCallBackData.getErrorString(), postWriteCallBackData.getPreMsg(), postWriteCallBackData.getColorMsg());
                        }
                    }
                    Intent intent = new Intent();
                    Bundle bundle = new Bundle();
                    bundle.putSerializable("post_write_callback_data", postWriteCallBackData);
                    intent.putExtras(bundle);
                    BaseActivity context = a.this.hCx.getContext();
                    a.this.hCx.getContext();
                    context.setResult(-1, intent);
                    a.this.hCx.getContext().finish();
                } else if (writeData2 != null && tVar != null && !TextUtils.isEmpty(tVar.Fz())) {
                    writeData2.setVcodeMD5(tVar.getVcode_md5());
                    writeData2.setVcodeUrl(tVar.getVcode_pic_url());
                    writeData2.setVcodeExtra(tVar.FA());
                    a.this.hCx.getContext().setVisible(false);
                    if (com.baidu.tbadk.p.a.hg(tVar.Fz())) {
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new NewVcodeActivityConfig(a.this.hCx.getContext().getActivity(), IEventCenterService.EventId.EventMode.SAPIACCOUNT_FACE_REG, writeData2, false, tVar.Fz())));
                    } else {
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new VcodeActivityConfig(a.this.hCx.getContext().getActivity(), writeData2, IEventCenterService.EventId.EventMode.SAPIACCOUNT_FACE_REG)));
                    }
                } else if (postWriteCallBackData != null && postWriteCallBackData.isSensitiveError()) {
                    Intent intent2 = new Intent();
                    Bundle bundle2 = new Bundle();
                    bundle2.putSerializable("post_write_callback_data", postWriteCallBackData);
                    intent2.putExtras(bundle2);
                    BaseActivity context2 = a.this.hCx.getContext();
                    a.this.hCx.getContext();
                    context2.setResult(0, intent2);
                    a.this.hCx.getContext().finish();
                } else {
                    if (postWriteCallBackData != null) {
                        c.e(a.this.hCx.getContext().getActivity(), postWriteCallBackData.getErrorString(), postWriteCallBackData.getPreMsg(), postWriteCallBackData.getColorMsg());
                        BaseActivity context3 = a.this.hCx.getContext();
                        a.this.hCx.getContext();
                        context3.setResult(0, null);
                    }
                    a.this.hCx.getContext().finish();
                }
            }
        }
    };

    public a(b bVar, NewWriteModel newWriteModel) {
        this.hCx = bVar;
        this.hCA = newWriteModel;
        newWriteModel.b(this.brY);
    }

    public boolean ub(String str) {
        if (this.hCx == null || str == null) {
            return false;
        }
        if (str.equals("http://tieba.baidu.com/account/access/cancel")) {
            this.hCx.getContext().finish();
            return true;
        } else if (str.equals("http://tieba.baidu.com/account/access/input_focus")) {
            this.hCx.H(0, UtilHelper.getImmersiveStickyBarHeight(), 0, 0);
            if (this.hCx.bFb() != this.hCx.iR()) {
                this.hCx.setRatio(this.hCx.bFb());
                this.hCx.bFc();
            }
            this.hCx.getWebView().setVisibility(0);
            return true;
        } else if (str.equals("http://tieba.baidu.com/account/access/valid_success")) {
            bEZ();
            return true;
        } else if (str.equals("http://tieba.baidu.com/account/access/feedback") || str.equals("https://tieba.baidu.com/account/access/feedback")) {
            this.hCx.getContext().finish();
            av.CZ().c(this.hCx.getContext().getPageContext(), new String[]{"feedback:"});
            return true;
        } else {
            return true;
        }
    }

    public void bEY() {
        if (this.hCx != null) {
            this.hCx.showWebViewDelay(500);
        }
    }

    public void start(String str) {
        if (this.hCx != null) {
            this.hCx.showWebLoadingView(true);
            this.hCx.showWebView(false);
            this.hCx.getWebView().loadUrl(str);
        }
    }

    public void onPostThreadCancle() {
        if (this.hCx != null) {
            this.hCx.showPostThreadLoadingView(false);
        }
    }

    private void bEZ() {
        this.hCB = false;
        if (this.hCx != null && this.hCA != null) {
            if (!l.oZ()) {
                this.hCx.getContext().showToast(d.j.neterror);
                this.hCx.getContext().finish();
                return;
            }
            this.hCx.showPostThreadLoadingView(true);
            this.hCA.startPostWrite();
        }
    }

    public boolean bFa() {
        return this.hCB;
    }
}
