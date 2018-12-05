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
import com.baidu.tbadk.coreExtra.data.w;
import com.baidu.tieba.e;
import com.baidu.tieba.tbadkCore.writeModel.NewWriteModel;
import com.baidu.tieba.tbadkCore.writeModel.PostWriteCallBackData;
import com.baidu.tieba.tbadkCore.writeModel.c;
/* loaded from: classes3.dex */
public class a {
    private final b hRw;
    private final NewWriteModel hRz;
    private boolean hRA = false;
    private final NewWriteModel.d baf = new NewWriteModel.d() { // from class: com.baidu.tieba.write.accountAccess.a.1
        @Override // com.baidu.tieba.tbadkCore.writeModel.NewWriteModel.d
        public void callback(boolean z, PostWriteCallBackData postWriteCallBackData, w wVar, WriteData writeData, AntiData antiData) {
            if (a.this.hRw != null && a.this.hRz != null && a.this.hRz.getWriteData() != null) {
                a.this.hRw.showPostThreadLoadingView(false);
                WriteData writeData2 = writeData == null ? a.this.hRz.getWriteData() : writeData;
                if (z) {
                    a.this.hRA = true;
                    if (writeData2.getType() != 0 || writeData2.isUserFeedback()) {
                        if (postWriteCallBackData == null) {
                            c.e(a.this.hRw.getContext().getActivity(), a.this.hRw.getContext().getResources().getString(e.j.send_success), null, null);
                        } else {
                            c.e(a.this.hRw.getContext().getActivity(), postWriteCallBackData.getErrorString(), postWriteCallBackData.getPreMsg(), postWriteCallBackData.getColorMsg());
                        }
                    }
                    Intent intent = new Intent();
                    Bundle bundle = new Bundle();
                    bundle.putSerializable("post_write_callback_data", postWriteCallBackData);
                    intent.putExtras(bundle);
                    BaseActivity context = a.this.hRw.getContext();
                    a.this.hRw.getContext();
                    context.setResult(-1, intent);
                    a.this.hRw.getContext().finish();
                } else if (writeData2 != null && wVar != null && !TextUtils.isEmpty(wVar.GV())) {
                    writeData2.setVcodeMD5(wVar.getVcode_md5());
                    writeData2.setVcodeUrl(wVar.getVcode_pic_url());
                    writeData2.setVcodeExtra(wVar.GW());
                    a.this.hRw.getContext().setVisible(false);
                    if (com.baidu.tbadk.r.a.iS(wVar.GV())) {
                        MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new NewVcodeActivityConfig(a.this.hRw.getContext().getActivity(), IEventCenterService.EventId.EventMode.SAPIACCOUNT_FACE_REG, writeData2, false, wVar.GV())));
                    } else {
                        MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new VcodeActivityConfig(a.this.hRw.getContext().getActivity(), writeData2, IEventCenterService.EventId.EventMode.SAPIACCOUNT_FACE_REG)));
                    }
                } else if (postWriteCallBackData != null && postWriteCallBackData.isSensitiveError()) {
                    Intent intent2 = new Intent();
                    Bundle bundle2 = new Bundle();
                    bundle2.putSerializable("post_write_callback_data", postWriteCallBackData);
                    intent2.putExtras(bundle2);
                    BaseActivity context2 = a.this.hRw.getContext();
                    a.this.hRw.getContext();
                    context2.setResult(0, intent2);
                    a.this.hRw.getContext().finish();
                } else {
                    if (postWriteCallBackData != null) {
                        c.e(a.this.hRw.getContext().getActivity(), postWriteCallBackData.getErrorString(), postWriteCallBackData.getPreMsg(), postWriteCallBackData.getColorMsg());
                        BaseActivity context3 = a.this.hRw.getContext();
                        a.this.hRw.getContext();
                        context3.setResult(0, null);
                    }
                    a.this.hRw.getContext().finish();
                }
            }
        }
    };

    public a(b bVar, NewWriteModel newWriteModel) {
        this.hRw = bVar;
        this.hRz = newWriteModel;
        newWriteModel.b(this.baf);
    }

    public boolean xv(String str) {
        if (this.hRw == null || str == null) {
            return false;
        }
        if (str.equals("http://tieba.baidu.com/account/access/cancel")) {
            this.hRw.getContext().finish();
            return true;
        } else if (str.equals("http://tieba.baidu.com/account/access/input_focus")) {
            this.hRw.setWebViewMargin(0, UtilHelper.getImmersiveStickyBarHeight(), 0, 0);
            if (this.hRw.bNj() != this.hRw.ff()) {
                this.hRw.setRatio(this.hRw.bNj());
                this.hRw.bNk();
            }
            this.hRw.getWebView().setVisibility(0);
            return true;
        } else if (str.equals("http://tieba.baidu.com/account/access/valid_success")) {
            bNi();
            return true;
        } else if (str.equals("http://tieba.baidu.com/account/access/feedback") || str.equals("https://tieba.baidu.com/account/access/feedback")) {
            this.hRw.getContext().finish();
            ay.Ef().c(this.hRw.getContext().getPageContext(), new String[]{"feedback:"});
            return true;
        } else {
            return true;
        }
    }

    public void bNh() {
        if (this.hRw != null) {
            this.hRw.showWebViewDelay(500);
        }
    }

    public void al(String str) {
        if (this.hRw != null) {
            this.hRw.showWebLoadingView(true);
            this.hRw.showWebView(false);
            this.hRw.getWebView().loadUrl(str);
        }
    }

    public void onPostThreadCancle() {
        if (this.hRw != null) {
            this.hRw.showPostThreadLoadingView(false);
        }
    }

    private void bNi() {
        this.hRA = false;
        if (this.hRw != null && this.hRz != null) {
            if (!l.ll()) {
                this.hRw.getContext().showToast(e.j.neterror);
                this.hRw.getContext().finish();
                return;
            }
            this.hRw.showPostThreadLoadingView(true);
            this.hRz.startPostWrite();
        }
    }
}
