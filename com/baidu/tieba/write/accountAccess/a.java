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
import com.baidu.tbadk.coreExtra.data.x;
import com.baidu.tieba.e;
import com.baidu.tieba.tbadkCore.writeModel.NewWriteModel;
import com.baidu.tieba.tbadkCore.writeModel.PostWriteCallBackData;
import com.baidu.tieba.tbadkCore.writeModel.c;
/* loaded from: classes3.dex */
public class a {
    private final b hVP;
    private final NewWriteModel hVS;
    private boolean hVT = false;
    private final NewWriteModel.d baU = new NewWriteModel.d() { // from class: com.baidu.tieba.write.accountAccess.a.1
        @Override // com.baidu.tieba.tbadkCore.writeModel.NewWriteModel.d
        public void callback(boolean z, PostWriteCallBackData postWriteCallBackData, x xVar, WriteData writeData, AntiData antiData) {
            if (a.this.hVP != null && a.this.hVS != null && a.this.hVS.getWriteData() != null) {
                a.this.hVP.showPostThreadLoadingView(false);
                WriteData writeData2 = writeData == null ? a.this.hVS.getWriteData() : writeData;
                if (z) {
                    a.this.hVT = true;
                    if (writeData2.getType() != 0 || writeData2.isUserFeedback()) {
                        if (postWriteCallBackData == null) {
                            c.e(a.this.hVP.getContext().getActivity(), a.this.hVP.getContext().getResources().getString(e.j.send_success), null, null);
                        } else {
                            c.e(a.this.hVP.getContext().getActivity(), postWriteCallBackData.getErrorString(), postWriteCallBackData.getPreMsg(), postWriteCallBackData.getColorMsg());
                        }
                    }
                    Intent intent = new Intent();
                    Bundle bundle = new Bundle();
                    bundle.putSerializable("post_write_callback_data", postWriteCallBackData);
                    intent.putExtras(bundle);
                    BaseActivity context = a.this.hVP.getContext();
                    a.this.hVP.getContext();
                    context.setResult(-1, intent);
                    a.this.hVP.getContext().finish();
                } else if (writeData2 != null && xVar != null && !TextUtils.isEmpty(xVar.Hk())) {
                    writeData2.setVcodeMD5(xVar.getVcode_md5());
                    writeData2.setVcodeUrl(xVar.getVcode_pic_url());
                    writeData2.setVcodeExtra(xVar.Hl());
                    a.this.hVP.getContext().setVisible(false);
                    if (com.baidu.tbadk.r.a.jj(xVar.Hk())) {
                        MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new NewVcodeActivityConfig(a.this.hVP.getContext().getActivity(), IEventCenterService.EventId.EventMode.SAPIACCOUNT_FACE_REG, writeData2, false, xVar.Hk())));
                    } else {
                        MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new VcodeActivityConfig(a.this.hVP.getContext().getActivity(), writeData2, IEventCenterService.EventId.EventMode.SAPIACCOUNT_FACE_REG)));
                    }
                } else if (postWriteCallBackData != null && postWriteCallBackData.isSensitiveError()) {
                    Intent intent2 = new Intent();
                    Bundle bundle2 = new Bundle();
                    bundle2.putSerializable("post_write_callback_data", postWriteCallBackData);
                    intent2.putExtras(bundle2);
                    BaseActivity context2 = a.this.hVP.getContext();
                    a.this.hVP.getContext();
                    context2.setResult(0, intent2);
                    a.this.hVP.getContext().finish();
                } else {
                    if (postWriteCallBackData != null) {
                        c.e(a.this.hVP.getContext().getActivity(), postWriteCallBackData.getErrorString(), postWriteCallBackData.getPreMsg(), postWriteCallBackData.getColorMsg());
                        BaseActivity context3 = a.this.hVP.getContext();
                        a.this.hVP.getContext();
                        context3.setResult(0, null);
                    }
                    a.this.hVP.getContext().finish();
                }
            }
        }
    };

    public a(b bVar, NewWriteModel newWriteModel) {
        this.hVP = bVar;
        this.hVS = newWriteModel;
        newWriteModel.b(this.baU);
    }

    public boolean xO(String str) {
        if (this.hVP == null || str == null) {
            return false;
        }
        if (str.equals("http://tieba.baidu.com/account/access/cancel")) {
            this.hVP.getContext().finish();
            return true;
        } else if (str.equals("http://tieba.baidu.com/account/access/input_focus")) {
            this.hVP.setWebViewMargin(0, UtilHelper.getImmersiveStickyBarHeight(), 0, 0);
            if (this.hVP.bOH() != this.hVP.ff()) {
                this.hVP.setRatio(this.hVP.bOH());
                this.hVP.bOI();
            }
            this.hVP.getWebView().setVisibility(0);
            return true;
        } else if (str.equals("http://tieba.baidu.com/account/access/valid_success")) {
            bOG();
            return true;
        } else if (str.equals("http://tieba.baidu.com/account/access/feedback") || str.equals("https://tieba.baidu.com/account/access/feedback")) {
            this.hVP.getContext().finish();
            ay.Es().c(this.hVP.getContext().getPageContext(), new String[]{"feedback:"});
            return true;
        } else {
            return true;
        }
    }

    public void bOF() {
        if (this.hVP != null) {
            this.hVP.showWebViewDelay(500);
        }
    }

    public void al(String str) {
        if (this.hVP != null) {
            this.hVP.showWebLoadingView(true);
            this.hVP.showWebView(false);
            this.hVP.getWebView().loadUrl(str);
        }
    }

    public void onPostThreadCancle() {
        if (this.hVP != null) {
            this.hVP.showPostThreadLoadingView(false);
        }
    }

    private void bOG() {
        this.hVT = false;
        if (this.hVP != null && this.hVS != null) {
            if (!l.ll()) {
                this.hVP.getContext().showToast(e.j.neterror);
                this.hVP.getContext().finish();
                return;
            }
            this.hVP.showPostThreadLoadingView(true);
            this.hVS.startPostWrite();
        }
    }
}
