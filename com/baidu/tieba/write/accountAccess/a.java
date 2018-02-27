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
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.aw;
import com.baidu.tbadk.coreExtra.data.WriteData;
import com.baidu.tbadk.coreExtra.data.t;
import com.baidu.tieba.d;
import com.baidu.tieba.tbadkCore.writeModel.NewWriteModel;
import com.baidu.tieba.tbadkCore.writeModel.PostWriteCallBackData;
import com.baidu.tieba.tbadkCore.writeModel.c;
/* loaded from: classes2.dex */
public class a {
    private final b hEb;
    private final NewWriteModel hEe;
    private boolean hEf = false;
    private final NewWriteModel.d buj = new NewWriteModel.d() { // from class: com.baidu.tieba.write.accountAccess.a.1
        @Override // com.baidu.tieba.tbadkCore.writeModel.NewWriteModel.d
        public void callback(boolean z, PostWriteCallBackData postWriteCallBackData, t tVar, WriteData writeData, AntiData antiData) {
            if (a.this.hEb != null && a.this.hEe != null && a.this.hEe.getWriteData() != null) {
                a.this.hEb.showPostThreadLoadingView(false);
                WriteData writeData2 = writeData == null ? a.this.hEe.getWriteData() : writeData;
                if (z) {
                    a.this.hEf = true;
                    if (writeData2.getIsStory() != 1 && (writeData2.getType() != 0 || writeData2.isUserFeedback())) {
                        if (postWriteCallBackData == null) {
                            c.e(a.this.hEb.getContext().getActivity(), a.this.hEb.getContext().getResources().getString(d.j.send_success), null, null);
                        } else {
                            c.e(a.this.hEb.getContext().getActivity(), postWriteCallBackData.getErrorString(), postWriteCallBackData.getPreMsg(), postWriteCallBackData.getColorMsg());
                        }
                    }
                    Intent intent = new Intent();
                    Bundle bundle = new Bundle();
                    bundle.putSerializable("post_write_callback_data", postWriteCallBackData);
                    intent.putExtras(bundle);
                    BaseActivity context = a.this.hEb.getContext();
                    a.this.hEb.getContext();
                    context.setResult(-1, intent);
                    a.this.hEb.getContext().finish();
                } else if (writeData2 != null && tVar != null && !TextUtils.isEmpty(tVar.FW())) {
                    writeData2.setVcodeMD5(tVar.getVcode_md5());
                    writeData2.setVcodeUrl(tVar.getVcode_pic_url());
                    writeData2.setVcodeExtra(tVar.FX());
                    a.this.hEb.getContext().setVisible(false);
                    if (com.baidu.tbadk.p.a.hx(tVar.FW())) {
                        MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new NewVcodeActivityConfig(a.this.hEb.getContext().getActivity(), IEventCenterService.EventId.EventMode.SAPIACCOUNT_FACE_REG, writeData2, false, tVar.FW())));
                    } else {
                        MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new VcodeActivityConfig(a.this.hEb.getContext().getActivity(), writeData2, IEventCenterService.EventId.EventMode.SAPIACCOUNT_FACE_REG)));
                    }
                } else if (postWriteCallBackData != null && postWriteCallBackData.isSensitiveError()) {
                    Intent intent2 = new Intent();
                    Bundle bundle2 = new Bundle();
                    bundle2.putSerializable("post_write_callback_data", postWriteCallBackData);
                    intent2.putExtras(bundle2);
                    BaseActivity context2 = a.this.hEb.getContext();
                    a.this.hEb.getContext();
                    context2.setResult(0, intent2);
                    a.this.hEb.getContext().finish();
                } else {
                    if (postWriteCallBackData != null) {
                        c.e(a.this.hEb.getContext().getActivity(), postWriteCallBackData.getErrorString(), postWriteCallBackData.getPreMsg(), postWriteCallBackData.getColorMsg());
                        BaseActivity context3 = a.this.hEb.getContext();
                        a.this.hEb.getContext();
                        context3.setResult(0, null);
                    }
                    a.this.hEb.getContext().finish();
                }
            }
        }
    };

    public a(b bVar, NewWriteModel newWriteModel) {
        this.hEb = bVar;
        this.hEe = newWriteModel;
        newWriteModel.b(this.buj);
    }

    public boolean up(String str) {
        if (this.hEb == null || str == null) {
            return false;
        }
        if (str.equals("http://tieba.baidu.com/account/access/cancel")) {
            this.hEb.getContext().finish();
            return true;
        } else if (str.equals("http://tieba.baidu.com/account/access/input_focus")) {
            this.hEb.H(0, UtilHelper.getImmersiveStickyBarHeight(), 0, 0);
            if (this.hEb.bFQ() != this.hEb.iR()) {
                this.hEb.setRatio(this.hEb.bFQ());
                this.hEb.bFR();
            }
            this.hEb.getWebView().setVisibility(0);
            return true;
        } else if (str.equals("http://tieba.baidu.com/account/access/valid_success")) {
            bFO();
            return true;
        } else if (str.equals("http://tieba.baidu.com/account/access/feedback") || str.equals("https://tieba.baidu.com/account/access/feedback")) {
            this.hEb.getContext().finish();
            aw.Dt().c(this.hEb.getContext().getPageContext(), new String[]{"feedback:"});
            return true;
        } else {
            return true;
        }
    }

    public void bFN() {
        if (this.hEb != null) {
            this.hEb.showWebViewDelay(500);
        }
    }

    public void start(String str) {
        if (this.hEb != null) {
            this.hEb.showWebLoadingView(true);
            this.hEb.showWebView(false);
            this.hEb.getWebView().loadUrl(str);
        }
    }

    public void onPostThreadCancle() {
        if (this.hEb != null) {
            this.hEb.showPostThreadLoadingView(false);
        }
    }

    private void bFO() {
        this.hEf = false;
        if (this.hEb != null && this.hEe != null) {
            if (!l.pa()) {
                this.hEb.getContext().showToast(d.j.neterror);
                this.hEb.getContext().finish();
                return;
            }
            this.hEb.showPostThreadLoadingView(true);
            this.hEe.startPostWrite();
        }
    }

    public boolean bFP() {
        return this.hEf;
    }
}
