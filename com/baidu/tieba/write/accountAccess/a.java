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
import com.baidu.tbadk.coreExtra.data.s;
import com.baidu.tieba.d;
import com.baidu.tieba.tbadkCore.writeModel.NewWriteModel;
import com.baidu.tieba.tbadkCore.writeModel.PostWriteCallBackData;
import com.baidu.tieba.tbadkCore.writeModel.c;
/* loaded from: classes2.dex */
public class a {
    private final b hMQ;
    private final NewWriteModel hMT;
    private boolean hMU = false;
    private final NewWriteModel.d brP = new NewWriteModel.d() { // from class: com.baidu.tieba.write.accountAccess.a.1
        @Override // com.baidu.tieba.tbadkCore.writeModel.NewWriteModel.d
        public void callback(boolean z, PostWriteCallBackData postWriteCallBackData, s sVar, WriteData writeData, AntiData antiData) {
            if (a.this.hMQ != null && a.this.hMT != null && a.this.hMT.getWriteData() != null) {
                a.this.hMQ.showPostThreadLoadingView(false);
                WriteData writeData2 = writeData == null ? a.this.hMT.getWriteData() : writeData;
                if (z) {
                    a.this.hMU = true;
                    if (writeData2.getIsStory() != 1 && (writeData2.getType() != 0 || writeData2.isUserFeedback())) {
                        if (postWriteCallBackData == null) {
                            c.e(a.this.hMQ.getContext().getActivity(), a.this.hMQ.getContext().getResources().getString(d.j.send_success), null, null);
                        } else {
                            c.e(a.this.hMQ.getContext().getActivity(), postWriteCallBackData.getErrorString(), postWriteCallBackData.getPreMsg(), postWriteCallBackData.getColorMsg());
                        }
                    }
                    Intent intent = new Intent();
                    Bundle bundle = new Bundle();
                    bundle.putSerializable("post_write_callback_data", postWriteCallBackData);
                    intent.putExtras(bundle);
                    BaseActivity context = a.this.hMQ.getContext();
                    a.this.hMQ.getContext();
                    context.setResult(-1, intent);
                    a.this.hMQ.getContext().finish();
                } else if (writeData2 != null && sVar != null && !TextUtils.isEmpty(sVar.FI())) {
                    writeData2.setVcodeMD5(sVar.getVcode_md5());
                    writeData2.setVcodeUrl(sVar.getVcode_pic_url());
                    writeData2.setVcodeExtra(sVar.FJ());
                    a.this.hMQ.getContext().setVisible(false);
                    if (com.baidu.tbadk.p.a.hf(sVar.FI())) {
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new NewVcodeActivityConfig(a.this.hMQ.getContext().getActivity(), IEventCenterService.EventId.EventMode.SAPIACCOUNT_FACE_REG, writeData2, false, sVar.FI())));
                    } else {
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new VcodeActivityConfig(a.this.hMQ.getContext().getActivity(), writeData2, IEventCenterService.EventId.EventMode.SAPIACCOUNT_FACE_REG)));
                    }
                } else if (postWriteCallBackData != null && postWriteCallBackData.isSensitiveError()) {
                    Intent intent2 = new Intent();
                    Bundle bundle2 = new Bundle();
                    bundle2.putSerializable("post_write_callback_data", postWriteCallBackData);
                    intent2.putExtras(bundle2);
                    BaseActivity context2 = a.this.hMQ.getContext();
                    a.this.hMQ.getContext();
                    context2.setResult(0, intent2);
                    a.this.hMQ.getContext().finish();
                } else {
                    if (postWriteCallBackData != null) {
                        c.e(a.this.hMQ.getContext().getActivity(), postWriteCallBackData.getErrorString(), postWriteCallBackData.getPreMsg(), postWriteCallBackData.getColorMsg());
                        BaseActivity context3 = a.this.hMQ.getContext();
                        a.this.hMQ.getContext();
                        context3.setResult(0, null);
                    }
                    a.this.hMQ.getContext().finish();
                }
            }
        }
    };

    public a(b bVar, NewWriteModel newWriteModel) {
        this.hMQ = bVar;
        this.hMT = newWriteModel;
        newWriteModel.b(this.brP);
    }

    public boolean uG(String str) {
        if (this.hMQ == null || str == null) {
            return false;
        }
        if (str.equals("http://tieba.baidu.com/account/access/cancel")) {
            this.hMQ.getContext().finish();
            return true;
        } else if (str.equals("http://tieba.baidu.com/account/access/input_focus")) {
            this.hMQ.I(0, UtilHelper.getImmersiveStickyBarHeight(), 0, 0);
            if (this.hMQ.bLB() != this.hMQ.iR()) {
                this.hMQ.setRatio(this.hMQ.bLB());
                this.hMQ.bLC();
            }
            this.hMQ.getWebView().setVisibility(0);
            return true;
        } else if (str.equals("http://tieba.baidu.com/account/access/valid_success")) {
            bLz();
            return true;
        } else if (str.equals("http://tieba.baidu.com/account/access/feedback") || str.equals("https://tieba.baidu.com/account/access/feedback")) {
            this.hMQ.getContext().finish();
            av.Di().c(this.hMQ.getContext().getPageContext(), new String[]{"feedback:"});
            return true;
        } else {
            return true;
        }
    }

    public void bLy() {
        if (this.hMQ != null) {
            this.hMQ.showWebViewDelay(500);
        }
    }

    public void start(String str) {
        if (this.hMQ != null) {
            this.hMQ.showWebLoadingView(true);
            this.hMQ.showWebView(false);
            this.hMQ.getWebView().loadUrl(str);
        }
    }

    public void onPostThreadCancle() {
        if (this.hMQ != null) {
            this.hMQ.showPostThreadLoadingView(false);
        }
    }

    private void bLz() {
        this.hMU = false;
        if (this.hMQ != null && this.hMT != null) {
            if (!l.oZ()) {
                this.hMQ.getContext().showToast(d.j.neterror);
                this.hMQ.getContext().finish();
                return;
            }
            this.hMQ.showPostThreadLoadingView(true);
            this.hMT.startPostWrite();
        }
    }

    public boolean bLA() {
        return this.hMU;
    }
}
