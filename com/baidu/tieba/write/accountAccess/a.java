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
import com.baidu.tbadk.core.util.ba;
import com.baidu.tbadk.coreExtra.data.WriteData;
import com.baidu.tbadk.coreExtra.data.x;
import com.baidu.tieba.R;
import com.baidu.tieba.tbadkCore.writeModel.NewWriteModel;
import com.baidu.tieba.tbadkCore.writeModel.PostWriteCallBackData;
import com.baidu.tieba.tbadkCore.writeModel.c;
/* loaded from: classes3.dex */
public class a {
    private final b jFt;
    private final NewWriteModel jFw;
    private boolean jFx = false;
    private final NewWriteModel.d csD = new NewWriteModel.d() { // from class: com.baidu.tieba.write.accountAccess.a.1
        @Override // com.baidu.tieba.tbadkCore.writeModel.NewWriteModel.d
        public void callback(boolean z, PostWriteCallBackData postWriteCallBackData, x xVar, WriteData writeData, AntiData antiData) {
            if (a.this.jFt != null && a.this.jFw != null && a.this.jFw.getWriteData() != null) {
                a.this.jFt.showPostThreadLoadingView(false);
                WriteData writeData2 = writeData == null ? a.this.jFw.getWriteData() : writeData;
                if (z) {
                    a.this.jFx = true;
                    if (writeData2.getType() != 0 || writeData2.isUserFeedback()) {
                        if (postWriteCallBackData == null) {
                            c.f(a.this.jFt.getContext().getActivity(), a.this.jFt.getContext().getResources().getString(R.string.send_success), null, null);
                        } else {
                            c.f(a.this.jFt.getContext().getActivity(), postWriteCallBackData.getErrorString(), postWriteCallBackData.getPreMsg(), postWriteCallBackData.getColorMsg());
                        }
                    }
                    Intent intent = new Intent();
                    Bundle bundle = new Bundle();
                    bundle.putSerializable("post_write_callback_data", postWriteCallBackData);
                    intent.putExtras(bundle);
                    BaseActivity context = a.this.jFt.getContext();
                    a.this.jFt.getContext();
                    context.setResult(-1, intent);
                    a.this.jFt.getContext().finish();
                } else if (writeData2 != null && xVar != null && !TextUtils.isEmpty(xVar.alz())) {
                    writeData2.setVcodeMD5(xVar.getVcode_md5());
                    writeData2.setVcodeUrl(xVar.getVcode_pic_url());
                    writeData2.setVcodeExtra(xVar.alA());
                    a.this.jFt.getContext().setVisible(false);
                    if (com.baidu.tbadk.v.a.rd(xVar.alz())) {
                        MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new NewVcodeActivityConfig(a.this.jFt.getContext().getActivity(), IEventCenterService.EventId.EventMode.SAPIACCOUNT_FACE_REG, writeData2, false, xVar.alz())));
                    } else {
                        MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new VcodeActivityConfig(a.this.jFt.getContext().getActivity(), writeData2, IEventCenterService.EventId.EventMode.SAPIACCOUNT_FACE_REG)));
                    }
                } else if (postWriteCallBackData != null && postWriteCallBackData.isSensitiveError()) {
                    Intent intent2 = new Intent();
                    Bundle bundle2 = new Bundle();
                    bundle2.putSerializable("post_write_callback_data", postWriteCallBackData);
                    intent2.putExtras(bundle2);
                    BaseActivity context2 = a.this.jFt.getContext();
                    a.this.jFt.getContext();
                    context2.setResult(0, intent2);
                    a.this.jFt.getContext().finish();
                } else {
                    if (postWriteCallBackData != null) {
                        c.f(a.this.jFt.getContext().getActivity(), postWriteCallBackData.getErrorString(), postWriteCallBackData.getPreMsg(), postWriteCallBackData.getColorMsg());
                        BaseActivity context3 = a.this.jFt.getContext();
                        a.this.jFt.getContext();
                        context3.setResult(0, null);
                    }
                    a.this.jFt.getContext().finish();
                }
            }
        }
    };

    public a(b bVar, NewWriteModel newWriteModel) {
        this.jFt = bVar;
        this.jFw = newWriteModel;
        newWriteModel.b(this.csD);
    }

    public boolean FI(String str) {
        if (this.jFt == null || str == null) {
            return false;
        }
        if (str.equals("http://tieba.baidu.com/account/access/cancel")) {
            this.jFt.getContext().finish();
            return true;
        } else if (str.equals("http://tieba.baidu.com/account/access/input_focus")) {
            this.jFt.D(0, UtilHelper.getImmersiveStickyBarHeight(), 0, 0);
            if (this.jFt.cwG() != this.jFt.dY()) {
                this.jFt.setRatio(this.jFt.cwG());
                this.jFt.cwH();
            }
            this.jFt.getWebView().setVisibility(0);
            return true;
        } else if (str.equals("http://tieba.baidu.com/account/access/valid_success")) {
            cwF();
            return true;
        } else if (str.equals("http://tieba.baidu.com/account/access/feedback") || str.equals("https://tieba.baidu.com/account/access/feedback")) {
            this.jFt.getContext().finish();
            ba.aiz().c(this.jFt.getContext().getPageContext(), new String[]{"feedback:"});
            return true;
        } else {
            return true;
        }
    }

    public void cwE() {
        if (this.jFt != null) {
            this.jFt.showWebViewDelay(500);
        }
    }

    public void U(String str) {
        if (this.jFt != null) {
            this.jFt.showWebLoadingView(true);
            this.jFt.showWebView(false);
            this.jFt.getWebView().loadUrl(str);
        }
    }

    public void onPostThreadCancle() {
        if (this.jFt != null) {
            this.jFt.showPostThreadLoadingView(false);
        }
    }

    private void cwF() {
        this.jFx = false;
        if (this.jFt != null && this.jFw != null) {
            if (!l.ki()) {
                this.jFt.getContext().showToast(R.string.neterror);
                this.jFt.getContext().finish();
                return;
            }
            this.jFt.showPostThreadLoadingView(true);
            this.jFw.startPostWrite();
        }
    }
}
