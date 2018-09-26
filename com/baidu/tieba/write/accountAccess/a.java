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
import com.baidu.tbadk.core.util.ay;
import com.baidu.tbadk.coreExtra.data.WriteData;
import com.baidu.tbadk.coreExtra.data.v;
import com.baidu.tieba.e;
import com.baidu.tieba.tbadkCore.writeModel.NewWriteModel;
import com.baidu.tieba.tbadkCore.writeModel.PostWriteCallBackData;
import com.baidu.tieba.tbadkCore.writeModel.c;
/* loaded from: classes3.dex */
public class a {
    private final b hBo;
    private final NewWriteModel hBr;
    private boolean hBs = false;
    private final NewWriteModel.d aRr = new NewWriteModel.d() { // from class: com.baidu.tieba.write.accountAccess.a.1
        @Override // com.baidu.tieba.tbadkCore.writeModel.NewWriteModel.d
        public void callback(boolean z, PostWriteCallBackData postWriteCallBackData, v vVar, WriteData writeData, AntiData antiData) {
            if (a.this.hBo != null && a.this.hBr != null && a.this.hBr.getWriteData() != null) {
                a.this.hBo.showPostThreadLoadingView(false);
                WriteData writeData2 = writeData == null ? a.this.hBr.getWriteData() : writeData;
                if (z) {
                    a.this.hBs = true;
                    if (writeData2.getType() != 0 || writeData2.isUserFeedback()) {
                        if (postWriteCallBackData == null) {
                            c.e(a.this.hBo.getContext().getActivity(), a.this.hBo.getContext().getResources().getString(e.j.send_success), null, null);
                        } else {
                            c.e(a.this.hBo.getContext().getActivity(), postWriteCallBackData.getErrorString(), postWriteCallBackData.getPreMsg(), postWriteCallBackData.getColorMsg());
                        }
                    }
                    Intent intent = new Intent();
                    Bundle bundle = new Bundle();
                    bundle.putSerializable("post_write_callback_data", postWriteCallBackData);
                    intent.putExtras(bundle);
                    BaseActivity context = a.this.hBo.getContext();
                    a.this.hBo.getContext();
                    context.setResult(-1, intent);
                    a.this.hBo.getContext().finish();
                } else if (writeData2 != null && vVar != null && !TextUtils.isEmpty(vVar.DE())) {
                    writeData2.setVcodeMD5(vVar.getVcode_md5());
                    writeData2.setVcodeUrl(vVar.getVcode_pic_url());
                    writeData2.setVcodeExtra(vVar.DF());
                    a.this.hBo.getContext().setVisible(false);
                    if (com.baidu.tbadk.q.a.il(vVar.DE())) {
                        MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new NewVcodeActivityConfig(a.this.hBo.getContext().getActivity(), IEventCenterService.EventId.EventMode.SAPIACCOUNT_FACE_REG, writeData2, false, vVar.DE())));
                    } else {
                        MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new VcodeActivityConfig(a.this.hBo.getContext().getActivity(), writeData2, IEventCenterService.EventId.EventMode.SAPIACCOUNT_FACE_REG)));
                    }
                } else if (postWriteCallBackData != null && postWriteCallBackData.isSensitiveError()) {
                    Intent intent2 = new Intent();
                    Bundle bundle2 = new Bundle();
                    bundle2.putSerializable("post_write_callback_data", postWriteCallBackData);
                    intent2.putExtras(bundle2);
                    BaseActivity context2 = a.this.hBo.getContext();
                    a.this.hBo.getContext();
                    context2.setResult(0, intent2);
                    a.this.hBo.getContext().finish();
                } else {
                    if (postWriteCallBackData != null) {
                        c.e(a.this.hBo.getContext().getActivity(), postWriteCallBackData.getErrorString(), postWriteCallBackData.getPreMsg(), postWriteCallBackData.getColorMsg());
                        BaseActivity context3 = a.this.hBo.getContext();
                        a.this.hBo.getContext();
                        context3.setResult(0, null);
                    }
                    a.this.hBo.getContext().finish();
                }
            }
        }
    };

    public a(b bVar, NewWriteModel newWriteModel) {
        this.hBo = bVar;
        this.hBr = newWriteModel;
        newWriteModel.b(this.aRr);
    }

    public boolean wm(String str) {
        if (this.hBo == null || str == null) {
            return false;
        }
        if (str.equals("http://tieba.baidu.com/account/access/cancel")) {
            this.hBo.getContext().finish();
            return true;
        } else if (str.equals("http://tieba.baidu.com/account/access/input_focus")) {
            this.hBo.A(0, UtilHelper.getImmersiveStickyBarHeight(), 0, 0);
            if (this.hBo.bIs() != this.hBo.eO()) {
                this.hBo.setRatio(this.hBo.bIs());
                this.hBo.bIt();
            }
            this.hBo.getWebView().setVisibility(0);
            return true;
        } else if (str.equals("http://tieba.baidu.com/account/access/valid_success")) {
            bIr();
            return true;
        } else if (str.equals("http://tieba.baidu.com/account/access/feedback") || str.equals("https://tieba.baidu.com/account/access/feedback")) {
            this.hBo.getContext().finish();
            ay.AN().c(this.hBo.getContext().getPageContext(), new String[]{"feedback:"});
            return true;
        } else {
            return true;
        }
    }

    public void bIq() {
        if (this.hBo != null) {
            this.hBo.showWebViewDelay(500);
        }
    }

    public void al(String str) {
        if (this.hBo != null) {
            this.hBo.showWebLoadingView(true);
            this.hBo.showWebView(false);
            this.hBo.getWebView().loadUrl(str);
        }
    }

    public void onPostThreadCancle() {
        if (this.hBo != null) {
            this.hBo.showPostThreadLoadingView(false);
        }
    }

    private void bIr() {
        this.hBs = false;
        if (this.hBo != null && this.hBr != null) {
            if (!l.lb()) {
                this.hBo.getContext().showToast(e.j.neterror);
                this.hBo.getContext().finish();
                return;
            }
            this.hBo.showPostThreadLoadingView(true);
            this.hBr.startPostWrite();
        }
    }
}
