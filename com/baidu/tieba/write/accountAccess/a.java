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
    private final b jFw;
    private final NewWriteModel jFz;
    private boolean jFA = false;
    private final NewWriteModel.d csE = new NewWriteModel.d() { // from class: com.baidu.tieba.write.accountAccess.a.1
        @Override // com.baidu.tieba.tbadkCore.writeModel.NewWriteModel.d
        public void callback(boolean z, PostWriteCallBackData postWriteCallBackData, x xVar, WriteData writeData, AntiData antiData) {
            if (a.this.jFw != null && a.this.jFz != null && a.this.jFz.getWriteData() != null) {
                a.this.jFw.showPostThreadLoadingView(false);
                WriteData writeData2 = writeData == null ? a.this.jFz.getWriteData() : writeData;
                if (z) {
                    a.this.jFA = true;
                    if (writeData2.getType() != 0 || writeData2.isUserFeedback()) {
                        if (postWriteCallBackData == null) {
                            c.f(a.this.jFw.getContext().getActivity(), a.this.jFw.getContext().getResources().getString(R.string.send_success), null, null);
                        } else {
                            c.f(a.this.jFw.getContext().getActivity(), postWriteCallBackData.getErrorString(), postWriteCallBackData.getPreMsg(), postWriteCallBackData.getColorMsg());
                        }
                    }
                    Intent intent = new Intent();
                    Bundle bundle = new Bundle();
                    bundle.putSerializable("post_write_callback_data", postWriteCallBackData);
                    intent.putExtras(bundle);
                    BaseActivity context = a.this.jFw.getContext();
                    a.this.jFw.getContext();
                    context.setResult(-1, intent);
                    a.this.jFw.getContext().finish();
                } else if (writeData2 != null && xVar != null && !TextUtils.isEmpty(xVar.alz())) {
                    writeData2.setVcodeMD5(xVar.getVcode_md5());
                    writeData2.setVcodeUrl(xVar.getVcode_pic_url());
                    writeData2.setVcodeExtra(xVar.alA());
                    a.this.jFw.getContext().setVisible(false);
                    if (com.baidu.tbadk.v.a.rc(xVar.alz())) {
                        MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new NewVcodeActivityConfig(a.this.jFw.getContext().getActivity(), IEventCenterService.EventId.EventMode.SAPIACCOUNT_FACE_REG, writeData2, false, xVar.alz())));
                    } else {
                        MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new VcodeActivityConfig(a.this.jFw.getContext().getActivity(), writeData2, IEventCenterService.EventId.EventMode.SAPIACCOUNT_FACE_REG)));
                    }
                } else if (postWriteCallBackData != null && postWriteCallBackData.isSensitiveError()) {
                    Intent intent2 = new Intent();
                    Bundle bundle2 = new Bundle();
                    bundle2.putSerializable("post_write_callback_data", postWriteCallBackData);
                    intent2.putExtras(bundle2);
                    BaseActivity context2 = a.this.jFw.getContext();
                    a.this.jFw.getContext();
                    context2.setResult(0, intent2);
                    a.this.jFw.getContext().finish();
                } else {
                    if (postWriteCallBackData != null) {
                        c.f(a.this.jFw.getContext().getActivity(), postWriteCallBackData.getErrorString(), postWriteCallBackData.getPreMsg(), postWriteCallBackData.getColorMsg());
                        BaseActivity context3 = a.this.jFw.getContext();
                        a.this.jFw.getContext();
                        context3.setResult(0, null);
                    }
                    a.this.jFw.getContext().finish();
                }
            }
        }
    };

    public a(b bVar, NewWriteModel newWriteModel) {
        this.jFw = bVar;
        this.jFz = newWriteModel;
        newWriteModel.b(this.csE);
    }

    public boolean FK(String str) {
        if (this.jFw == null || str == null) {
            return false;
        }
        if (str.equals("http://tieba.baidu.com/account/access/cancel")) {
            this.jFw.getContext().finish();
            return true;
        } else if (str.equals("http://tieba.baidu.com/account/access/input_focus")) {
            this.jFw.D(0, UtilHelper.getImmersiveStickyBarHeight(), 0, 0);
            if (this.jFw.cwF() != this.jFw.dY()) {
                this.jFw.setRatio(this.jFw.cwF());
                this.jFw.cwG();
            }
            this.jFw.getWebView().setVisibility(0);
            return true;
        } else if (str.equals("http://tieba.baidu.com/account/access/valid_success")) {
            cwE();
            return true;
        } else if (str.equals("http://tieba.baidu.com/account/access/feedback") || str.equals("https://tieba.baidu.com/account/access/feedback")) {
            this.jFw.getContext().finish();
            ba.aiz().c(this.jFw.getContext().getPageContext(), new String[]{"feedback:"});
            return true;
        } else {
            return true;
        }
    }

    public void cwD() {
        if (this.jFw != null) {
            this.jFw.showWebViewDelay(500);
        }
    }

    public void U(String str) {
        if (this.jFw != null) {
            this.jFw.showWebLoadingView(true);
            this.jFw.showWebView(false);
            this.jFw.getWebView().loadUrl(str);
        }
    }

    public void onPostThreadCancle() {
        if (this.jFw != null) {
            this.jFw.showPostThreadLoadingView(false);
        }
    }

    private void cwE() {
        this.jFA = false;
        if (this.jFw != null && this.jFz != null) {
            if (!l.ki()) {
                this.jFw.getContext().showToast(R.string.neterror);
                this.jFw.getContext().finish();
                return;
            }
            this.jFw.showPostThreadLoadingView(true);
            this.jFz.startPostWrite();
        }
    }
}
