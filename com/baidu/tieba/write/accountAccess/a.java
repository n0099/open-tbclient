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
    private final b hIA;
    private final NewWriteModel hID;
    private boolean hIE = false;
    private final NewWriteModel.d aVS = new NewWriteModel.d() { // from class: com.baidu.tieba.write.accountAccess.a.1
        @Override // com.baidu.tieba.tbadkCore.writeModel.NewWriteModel.d
        public void callback(boolean z, PostWriteCallBackData postWriteCallBackData, v vVar, WriteData writeData, AntiData antiData) {
            if (a.this.hIA != null && a.this.hID != null && a.this.hID.getWriteData() != null) {
                a.this.hIA.showPostThreadLoadingView(false);
                WriteData writeData2 = writeData == null ? a.this.hID.getWriteData() : writeData;
                if (z) {
                    a.this.hIE = true;
                    if (writeData2.getType() != 0 || writeData2.isUserFeedback()) {
                        if (postWriteCallBackData == null) {
                            c.e(a.this.hIA.getContext().getActivity(), a.this.hIA.getContext().getResources().getString(e.j.send_success), null, null);
                        } else {
                            c.e(a.this.hIA.getContext().getActivity(), postWriteCallBackData.getErrorString(), postWriteCallBackData.getPreMsg(), postWriteCallBackData.getColorMsg());
                        }
                    }
                    Intent intent = new Intent();
                    Bundle bundle = new Bundle();
                    bundle.putSerializable("post_write_callback_data", postWriteCallBackData);
                    intent.putExtras(bundle);
                    BaseActivity context = a.this.hIA.getContext();
                    a.this.hIA.getContext();
                    context.setResult(-1, intent);
                    a.this.hIA.getContext().finish();
                } else if (writeData2 != null && vVar != null && !TextUtils.isEmpty(vVar.FF())) {
                    writeData2.setVcodeMD5(vVar.getVcode_md5());
                    writeData2.setVcodeUrl(vVar.getVcode_pic_url());
                    writeData2.setVcodeExtra(vVar.FG());
                    a.this.hIA.getContext().setVisible(false);
                    if (com.baidu.tbadk.q.a.iy(vVar.FF())) {
                        MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new NewVcodeActivityConfig(a.this.hIA.getContext().getActivity(), IEventCenterService.EventId.EventMode.SAPIACCOUNT_FACE_REG, writeData2, false, vVar.FF())));
                    } else {
                        MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new VcodeActivityConfig(a.this.hIA.getContext().getActivity(), writeData2, IEventCenterService.EventId.EventMode.SAPIACCOUNT_FACE_REG)));
                    }
                } else if (postWriteCallBackData != null && postWriteCallBackData.isSensitiveError()) {
                    Intent intent2 = new Intent();
                    Bundle bundle2 = new Bundle();
                    bundle2.putSerializable("post_write_callback_data", postWriteCallBackData);
                    intent2.putExtras(bundle2);
                    BaseActivity context2 = a.this.hIA.getContext();
                    a.this.hIA.getContext();
                    context2.setResult(0, intent2);
                    a.this.hIA.getContext().finish();
                } else {
                    if (postWriteCallBackData != null) {
                        c.e(a.this.hIA.getContext().getActivity(), postWriteCallBackData.getErrorString(), postWriteCallBackData.getPreMsg(), postWriteCallBackData.getColorMsg());
                        BaseActivity context3 = a.this.hIA.getContext();
                        a.this.hIA.getContext();
                        context3.setResult(0, null);
                    }
                    a.this.hIA.getContext().finish();
                }
            }
        }
    };

    public a(b bVar, NewWriteModel newWriteModel) {
        this.hIA = bVar;
        this.hID = newWriteModel;
        newWriteModel.b(this.aVS);
    }

    public boolean wN(String str) {
        if (this.hIA == null || str == null) {
            return false;
        }
        if (str.equals("http://tieba.baidu.com/account/access/cancel")) {
            this.hIA.getContext().finish();
            return true;
        } else if (str.equals("http://tieba.baidu.com/account/access/input_focus")) {
            this.hIA.setWebViewMargin(0, UtilHelper.getImmersiveStickyBarHeight(), 0, 0);
            if (this.hIA.bLE() != this.hIA.fg()) {
                this.hIA.setRatio(this.hIA.bLE());
                this.hIA.bLF();
            }
            this.hIA.getWebView().setVisibility(0);
            return true;
        } else if (str.equals("http://tieba.baidu.com/account/access/valid_success")) {
            bLD();
            return true;
        } else if (str.equals("http://tieba.baidu.com/account/access/feedback") || str.equals("https://tieba.baidu.com/account/access/feedback")) {
            this.hIA.getContext().finish();
            ay.CU().c(this.hIA.getContext().getPageContext(), new String[]{"feedback:"});
            return true;
        } else {
            return true;
        }
    }

    public void bLC() {
        if (this.hIA != null) {
            this.hIA.showWebViewDelay(500);
        }
    }

    public void al(String str) {
        if (this.hIA != null) {
            this.hIA.showWebLoadingView(true);
            this.hIA.showWebView(false);
            this.hIA.getWebView().loadUrl(str);
        }
    }

    public void onPostThreadCancle() {
        if (this.hIA != null) {
            this.hIA.showPostThreadLoadingView(false);
        }
    }

    private void bLD() {
        this.hIE = false;
        if (this.hIA != null && this.hID != null) {
            if (!l.lo()) {
                this.hIA.getContext().showToast(e.j.neterror);
                this.hIA.getContext().finish();
                return;
            }
            this.hIA.showPostThreadLoadingView(true);
            this.hID.startPostWrite();
        }
    }
}
