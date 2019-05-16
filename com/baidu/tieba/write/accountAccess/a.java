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
    private final b jFs;
    private final NewWriteModel jFv;
    private boolean jFw = false;
    private final NewWriteModel.d csD = new NewWriteModel.d() { // from class: com.baidu.tieba.write.accountAccess.a.1
        @Override // com.baidu.tieba.tbadkCore.writeModel.NewWriteModel.d
        public void callback(boolean z, PostWriteCallBackData postWriteCallBackData, x xVar, WriteData writeData, AntiData antiData) {
            if (a.this.jFs != null && a.this.jFv != null && a.this.jFv.getWriteData() != null) {
                a.this.jFs.showPostThreadLoadingView(false);
                WriteData writeData2 = writeData == null ? a.this.jFv.getWriteData() : writeData;
                if (z) {
                    a.this.jFw = true;
                    if (writeData2.getType() != 0 || writeData2.isUserFeedback()) {
                        if (postWriteCallBackData == null) {
                            c.f(a.this.jFs.getContext().getActivity(), a.this.jFs.getContext().getResources().getString(R.string.send_success), null, null);
                        } else {
                            c.f(a.this.jFs.getContext().getActivity(), postWriteCallBackData.getErrorString(), postWriteCallBackData.getPreMsg(), postWriteCallBackData.getColorMsg());
                        }
                    }
                    Intent intent = new Intent();
                    Bundle bundle = new Bundle();
                    bundle.putSerializable("post_write_callback_data", postWriteCallBackData);
                    intent.putExtras(bundle);
                    BaseActivity context = a.this.jFs.getContext();
                    a.this.jFs.getContext();
                    context.setResult(-1, intent);
                    a.this.jFs.getContext().finish();
                } else if (writeData2 != null && xVar != null && !TextUtils.isEmpty(xVar.alz())) {
                    writeData2.setVcodeMD5(xVar.getVcode_md5());
                    writeData2.setVcodeUrl(xVar.getVcode_pic_url());
                    writeData2.setVcodeExtra(xVar.alA());
                    a.this.jFs.getContext().setVisible(false);
                    if (com.baidu.tbadk.v.a.rd(xVar.alz())) {
                        MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new NewVcodeActivityConfig(a.this.jFs.getContext().getActivity(), IEventCenterService.EventId.EventMode.SAPIACCOUNT_FACE_REG, writeData2, false, xVar.alz())));
                    } else {
                        MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new VcodeActivityConfig(a.this.jFs.getContext().getActivity(), writeData2, IEventCenterService.EventId.EventMode.SAPIACCOUNT_FACE_REG)));
                    }
                } else if (postWriteCallBackData != null && postWriteCallBackData.isSensitiveError()) {
                    Intent intent2 = new Intent();
                    Bundle bundle2 = new Bundle();
                    bundle2.putSerializable("post_write_callback_data", postWriteCallBackData);
                    intent2.putExtras(bundle2);
                    BaseActivity context2 = a.this.jFs.getContext();
                    a.this.jFs.getContext();
                    context2.setResult(0, intent2);
                    a.this.jFs.getContext().finish();
                } else {
                    if (postWriteCallBackData != null) {
                        c.f(a.this.jFs.getContext().getActivity(), postWriteCallBackData.getErrorString(), postWriteCallBackData.getPreMsg(), postWriteCallBackData.getColorMsg());
                        BaseActivity context3 = a.this.jFs.getContext();
                        a.this.jFs.getContext();
                        context3.setResult(0, null);
                    }
                    a.this.jFs.getContext().finish();
                }
            }
        }
    };

    public a(b bVar, NewWriteModel newWriteModel) {
        this.jFs = bVar;
        this.jFv = newWriteModel;
        newWriteModel.b(this.csD);
    }

    public boolean FI(String str) {
        if (this.jFs == null || str == null) {
            return false;
        }
        if (str.equals("http://tieba.baidu.com/account/access/cancel")) {
            this.jFs.getContext().finish();
            return true;
        } else if (str.equals("http://tieba.baidu.com/account/access/input_focus")) {
            this.jFs.D(0, UtilHelper.getImmersiveStickyBarHeight(), 0, 0);
            if (this.jFs.cwE() != this.jFs.dY()) {
                this.jFs.setRatio(this.jFs.cwE());
                this.jFs.cwF();
            }
            this.jFs.getWebView().setVisibility(0);
            return true;
        } else if (str.equals("http://tieba.baidu.com/account/access/valid_success")) {
            cwD();
            return true;
        } else if (str.equals("http://tieba.baidu.com/account/access/feedback") || str.equals("https://tieba.baidu.com/account/access/feedback")) {
            this.jFs.getContext().finish();
            ba.aiz().c(this.jFs.getContext().getPageContext(), new String[]{"feedback:"});
            return true;
        } else {
            return true;
        }
    }

    public void cwC() {
        if (this.jFs != null) {
            this.jFs.showWebViewDelay(500);
        }
    }

    public void U(String str) {
        if (this.jFs != null) {
            this.jFs.showWebLoadingView(true);
            this.jFs.showWebView(false);
            this.jFs.getWebView().loadUrl(str);
        }
    }

    public void onPostThreadCancle() {
        if (this.jFs != null) {
            this.jFs.showPostThreadLoadingView(false);
        }
    }

    private void cwD() {
        this.jFw = false;
        if (this.jFs != null && this.jFv != null) {
            if (!l.ki()) {
                this.jFs.getContext().showToast(R.string.neterror);
                this.jFs.getContext().finish();
                return;
            }
            this.jFs.showPostThreadLoadingView(true);
            this.jFv.startPostWrite();
        }
    }
}
