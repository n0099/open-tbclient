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
    private final b hIB;
    private final NewWriteModel hIE;
    private boolean hIF = false;
    private final NewWriteModel.d aVS = new NewWriteModel.d() { // from class: com.baidu.tieba.write.accountAccess.a.1
        @Override // com.baidu.tieba.tbadkCore.writeModel.NewWriteModel.d
        public void callback(boolean z, PostWriteCallBackData postWriteCallBackData, v vVar, WriteData writeData, AntiData antiData) {
            if (a.this.hIB != null && a.this.hIE != null && a.this.hIE.getWriteData() != null) {
                a.this.hIB.showPostThreadLoadingView(false);
                WriteData writeData2 = writeData == null ? a.this.hIE.getWriteData() : writeData;
                if (z) {
                    a.this.hIF = true;
                    if (writeData2.getType() != 0 || writeData2.isUserFeedback()) {
                        if (postWriteCallBackData == null) {
                            c.e(a.this.hIB.getContext().getActivity(), a.this.hIB.getContext().getResources().getString(e.j.send_success), null, null);
                        } else {
                            c.e(a.this.hIB.getContext().getActivity(), postWriteCallBackData.getErrorString(), postWriteCallBackData.getPreMsg(), postWriteCallBackData.getColorMsg());
                        }
                    }
                    Intent intent = new Intent();
                    Bundle bundle = new Bundle();
                    bundle.putSerializable("post_write_callback_data", postWriteCallBackData);
                    intent.putExtras(bundle);
                    BaseActivity context = a.this.hIB.getContext();
                    a.this.hIB.getContext();
                    context.setResult(-1, intent);
                    a.this.hIB.getContext().finish();
                } else if (writeData2 != null && vVar != null && !TextUtils.isEmpty(vVar.FF())) {
                    writeData2.setVcodeMD5(vVar.getVcode_md5());
                    writeData2.setVcodeUrl(vVar.getVcode_pic_url());
                    writeData2.setVcodeExtra(vVar.FG());
                    a.this.hIB.getContext().setVisible(false);
                    if (com.baidu.tbadk.q.a.iy(vVar.FF())) {
                        MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new NewVcodeActivityConfig(a.this.hIB.getContext().getActivity(), IEventCenterService.EventId.EventMode.SAPIACCOUNT_FACE_REG, writeData2, false, vVar.FF())));
                    } else {
                        MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new VcodeActivityConfig(a.this.hIB.getContext().getActivity(), writeData2, IEventCenterService.EventId.EventMode.SAPIACCOUNT_FACE_REG)));
                    }
                } else if (postWriteCallBackData != null && postWriteCallBackData.isSensitiveError()) {
                    Intent intent2 = new Intent();
                    Bundle bundle2 = new Bundle();
                    bundle2.putSerializable("post_write_callback_data", postWriteCallBackData);
                    intent2.putExtras(bundle2);
                    BaseActivity context2 = a.this.hIB.getContext();
                    a.this.hIB.getContext();
                    context2.setResult(0, intent2);
                    a.this.hIB.getContext().finish();
                } else {
                    if (postWriteCallBackData != null) {
                        c.e(a.this.hIB.getContext().getActivity(), postWriteCallBackData.getErrorString(), postWriteCallBackData.getPreMsg(), postWriteCallBackData.getColorMsg());
                        BaseActivity context3 = a.this.hIB.getContext();
                        a.this.hIB.getContext();
                        context3.setResult(0, null);
                    }
                    a.this.hIB.getContext().finish();
                }
            }
        }
    };

    public a(b bVar, NewWriteModel newWriteModel) {
        this.hIB = bVar;
        this.hIE = newWriteModel;
        newWriteModel.b(this.aVS);
    }

    public boolean wN(String str) {
        if (this.hIB == null || str == null) {
            return false;
        }
        if (str.equals("http://tieba.baidu.com/account/access/cancel")) {
            this.hIB.getContext().finish();
            return true;
        } else if (str.equals("http://tieba.baidu.com/account/access/input_focus")) {
            this.hIB.setWebViewMargin(0, UtilHelper.getImmersiveStickyBarHeight(), 0, 0);
            if (this.hIB.bLE() != this.hIB.fg()) {
                this.hIB.setRatio(this.hIB.bLE());
                this.hIB.bLF();
            }
            this.hIB.getWebView().setVisibility(0);
            return true;
        } else if (str.equals("http://tieba.baidu.com/account/access/valid_success")) {
            bLD();
            return true;
        } else if (str.equals("http://tieba.baidu.com/account/access/feedback") || str.equals("https://tieba.baidu.com/account/access/feedback")) {
            this.hIB.getContext().finish();
            ay.CU().c(this.hIB.getContext().getPageContext(), new String[]{"feedback:"});
            return true;
        } else {
            return true;
        }
    }

    public void bLC() {
        if (this.hIB != null) {
            this.hIB.showWebViewDelay(500);
        }
    }

    public void al(String str) {
        if (this.hIB != null) {
            this.hIB.showWebLoadingView(true);
            this.hIB.showWebView(false);
            this.hIB.getWebView().loadUrl(str);
        }
    }

    public void onPostThreadCancle() {
        if (this.hIB != null) {
            this.hIB.showPostThreadLoadingView(false);
        }
    }

    private void bLD() {
        this.hIF = false;
        if (this.hIB != null && this.hIE != null) {
            if (!l.lo()) {
                this.hIB.getContext().showToast(e.j.neterror);
                this.hIB.getContext().finish();
                return;
            }
            this.hIB.showPostThreadLoadingView(true);
            this.hIE.startPostWrite();
        }
    }
}
