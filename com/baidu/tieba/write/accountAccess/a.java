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
    private final b hCR;
    private final NewWriteModel hCU;
    private boolean hCV = false;
    private final NewWriteModel.d bsh = new NewWriteModel.d() { // from class: com.baidu.tieba.write.accountAccess.a.1
        @Override // com.baidu.tieba.tbadkCore.writeModel.NewWriteModel.d
        public void callback(boolean z, PostWriteCallBackData postWriteCallBackData, t tVar, WriteData writeData, AntiData antiData) {
            if (a.this.hCR != null && a.this.hCU != null && a.this.hCU.getWriteData() != null) {
                a.this.hCR.showPostThreadLoadingView(false);
                WriteData writeData2 = writeData == null ? a.this.hCU.getWriteData() : writeData;
                if (z) {
                    a.this.hCV = true;
                    if (writeData2.getIsStory() != 1 && (writeData2.getType() != 0 || writeData2.isUserFeedback())) {
                        if (postWriteCallBackData == null) {
                            c.e(a.this.hCR.getContext().getActivity(), a.this.hCR.getContext().getResources().getString(d.j.send_success), null, null);
                        } else {
                            c.e(a.this.hCR.getContext().getActivity(), postWriteCallBackData.getErrorString(), postWriteCallBackData.getPreMsg(), postWriteCallBackData.getColorMsg());
                        }
                    }
                    Intent intent = new Intent();
                    Bundle bundle = new Bundle();
                    bundle.putSerializable("post_write_callback_data", postWriteCallBackData);
                    intent.putExtras(bundle);
                    BaseActivity context = a.this.hCR.getContext();
                    a.this.hCR.getContext();
                    context.setResult(-1, intent);
                    a.this.hCR.getContext().finish();
                } else if (writeData2 != null && tVar != null && !TextUtils.isEmpty(tVar.FB())) {
                    writeData2.setVcodeMD5(tVar.getVcode_md5());
                    writeData2.setVcodeUrl(tVar.getVcode_pic_url());
                    writeData2.setVcodeExtra(tVar.FC());
                    a.this.hCR.getContext().setVisible(false);
                    if (com.baidu.tbadk.p.a.hn(tVar.FB())) {
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new NewVcodeActivityConfig(a.this.hCR.getContext().getActivity(), IEventCenterService.EventId.EventMode.SAPIACCOUNT_FACE_REG, writeData2, false, tVar.FB())));
                    } else {
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new VcodeActivityConfig(a.this.hCR.getContext().getActivity(), writeData2, IEventCenterService.EventId.EventMode.SAPIACCOUNT_FACE_REG)));
                    }
                } else if (postWriteCallBackData != null && postWriteCallBackData.isSensitiveError()) {
                    Intent intent2 = new Intent();
                    Bundle bundle2 = new Bundle();
                    bundle2.putSerializable("post_write_callback_data", postWriteCallBackData);
                    intent2.putExtras(bundle2);
                    BaseActivity context2 = a.this.hCR.getContext();
                    a.this.hCR.getContext();
                    context2.setResult(0, intent2);
                    a.this.hCR.getContext().finish();
                } else {
                    if (postWriteCallBackData != null) {
                        c.e(a.this.hCR.getContext().getActivity(), postWriteCallBackData.getErrorString(), postWriteCallBackData.getPreMsg(), postWriteCallBackData.getColorMsg());
                        BaseActivity context3 = a.this.hCR.getContext();
                        a.this.hCR.getContext();
                        context3.setResult(0, null);
                    }
                    a.this.hCR.getContext().finish();
                }
            }
        }
    };

    public a(b bVar, NewWriteModel newWriteModel) {
        this.hCR = bVar;
        this.hCU = newWriteModel;
        newWriteModel.b(this.bsh);
    }

    public boolean ui(String str) {
        if (this.hCR == null || str == null) {
            return false;
        }
        if (str.equals("http://tieba.baidu.com/account/access/cancel")) {
            this.hCR.getContext().finish();
            return true;
        } else if (str.equals("http://tieba.baidu.com/account/access/input_focus")) {
            this.hCR.H(0, UtilHelper.getImmersiveStickyBarHeight(), 0, 0);
            if (this.hCR.bFd() != this.hCR.iR()) {
                this.hCR.setRatio(this.hCR.bFd());
                this.hCR.bFe();
            }
            this.hCR.getWebView().setVisibility(0);
            return true;
        } else if (str.equals("http://tieba.baidu.com/account/access/valid_success")) {
            bFb();
            return true;
        } else if (str.equals("http://tieba.baidu.com/account/access/feedback") || str.equals("https://tieba.baidu.com/account/access/feedback")) {
            this.hCR.getContext().finish();
            av.Da().c(this.hCR.getContext().getPageContext(), new String[]{"feedback:"});
            return true;
        } else {
            return true;
        }
    }

    public void bFa() {
        if (this.hCR != null) {
            this.hCR.showWebViewDelay(500);
        }
    }

    public void start(String str) {
        if (this.hCR != null) {
            this.hCR.showWebLoadingView(true);
            this.hCR.showWebView(false);
            this.hCR.getWebView().loadUrl(str);
        }
    }

    public void onPostThreadCancle() {
        if (this.hCR != null) {
            this.hCR.showPostThreadLoadingView(false);
        }
    }

    private void bFb() {
        this.hCV = false;
        if (this.hCR != null && this.hCU != null) {
            if (!l.pa()) {
                this.hCR.getContext().showToast(d.j.neterror);
                this.hCR.getContext().finish();
                return;
            }
            this.hCR.showPostThreadLoadingView(true);
            this.hCU.startPostWrite();
        }
    }

    public boolean bFc() {
        return this.hCV;
    }
}
