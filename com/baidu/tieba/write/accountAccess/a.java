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
import com.baidu.tbadk.core.util.az;
import com.baidu.tbadk.coreExtra.data.WriteData;
import com.baidu.tbadk.coreExtra.data.t;
import com.baidu.tieba.d;
import com.baidu.tieba.tbadkCore.writeModel.NewWriteModel;
import com.baidu.tieba.tbadkCore.writeModel.PostWriteCallBackData;
import com.baidu.tieba.tbadkCore.writeModel.c;
/* loaded from: classes3.dex */
public class a {
    private final b hsj;
    private final NewWriteModel hsm;
    private boolean hsn = false;
    private final NewWriteModel.d aOd = new NewWriteModel.d() { // from class: com.baidu.tieba.write.accountAccess.a.1
        @Override // com.baidu.tieba.tbadkCore.writeModel.NewWriteModel.d
        public void callback(boolean z, PostWriteCallBackData postWriteCallBackData, t tVar, WriteData writeData, AntiData antiData) {
            if (a.this.hsj != null && a.this.hsm != null && a.this.hsm.getWriteData() != null) {
                a.this.hsj.showPostThreadLoadingView(false);
                WriteData writeData2 = writeData == null ? a.this.hsm.getWriteData() : writeData;
                if (z) {
                    a.this.hsn = true;
                    if (writeData2.getType() != 0 || writeData2.isUserFeedback()) {
                        if (postWriteCallBackData == null) {
                            c.e(a.this.hsj.getContext().getActivity(), a.this.hsj.getContext().getResources().getString(d.k.send_success), null, null);
                        } else {
                            c.e(a.this.hsj.getContext().getActivity(), postWriteCallBackData.getErrorString(), postWriteCallBackData.getPreMsg(), postWriteCallBackData.getColorMsg());
                        }
                    }
                    Intent intent = new Intent();
                    Bundle bundle = new Bundle();
                    bundle.putSerializable("post_write_callback_data", postWriteCallBackData);
                    intent.putExtras(bundle);
                    BaseActivity context = a.this.hsj.getContext();
                    a.this.hsj.getContext();
                    context.setResult(-1, intent);
                    a.this.hsj.getContext().finish();
                } else if (writeData2 != null && tVar != null && !TextUtils.isEmpty(tVar.CB())) {
                    writeData2.setVcodeMD5(tVar.getVcode_md5());
                    writeData2.setVcodeUrl(tVar.getVcode_pic_url());
                    writeData2.setVcodeExtra(tVar.CC());
                    a.this.hsj.getContext().setVisible(false);
                    if (com.baidu.tbadk.p.a.hQ(tVar.CB())) {
                        MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new NewVcodeActivityConfig(a.this.hsj.getContext().getActivity(), IEventCenterService.EventId.EventMode.SAPIACCOUNT_FACE_REG, writeData2, false, tVar.CB())));
                    } else {
                        MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new VcodeActivityConfig(a.this.hsj.getContext().getActivity(), writeData2, IEventCenterService.EventId.EventMode.SAPIACCOUNT_FACE_REG)));
                    }
                } else if (postWriteCallBackData != null && postWriteCallBackData.isSensitiveError()) {
                    Intent intent2 = new Intent();
                    Bundle bundle2 = new Bundle();
                    bundle2.putSerializable("post_write_callback_data", postWriteCallBackData);
                    intent2.putExtras(bundle2);
                    BaseActivity context2 = a.this.hsj.getContext();
                    a.this.hsj.getContext();
                    context2.setResult(0, intent2);
                    a.this.hsj.getContext().finish();
                } else {
                    if (postWriteCallBackData != null) {
                        c.e(a.this.hsj.getContext().getActivity(), postWriteCallBackData.getErrorString(), postWriteCallBackData.getPreMsg(), postWriteCallBackData.getColorMsg());
                        BaseActivity context3 = a.this.hsj.getContext();
                        a.this.hsj.getContext();
                        context3.setResult(0, null);
                    }
                    a.this.hsj.getContext().finish();
                }
            }
        }
    };

    public a(b bVar, NewWriteModel newWriteModel) {
        this.hsj = bVar;
        this.hsm = newWriteModel;
        newWriteModel.b(this.aOd);
    }

    public boolean vy(String str) {
        if (this.hsj == null || str == null) {
            return false;
        }
        if (str.equals("http://tieba.baidu.com/account/access/cancel")) {
            this.hsj.getContext().finish();
            return true;
        } else if (str.equals("http://tieba.baidu.com/account/access/input_focus")) {
            this.hsj.C(0, UtilHelper.getImmersiveStickyBarHeight(), 0, 0);
            if (this.hsj.bGN() != this.hsj.dJ()) {
                this.hsj.setRatio(this.hsj.bGN());
                this.hsj.bGO();
            }
            this.hsj.getWebView().setVisibility(0);
            return true;
        } else if (str.equals("http://tieba.baidu.com/account/access/valid_success")) {
            bGM();
            return true;
        } else if (str.equals("http://tieba.baidu.com/account/access/feedback") || str.equals("https://tieba.baidu.com/account/access/feedback")) {
            this.hsj.getContext().finish();
            az.zV().c(this.hsj.getContext().getPageContext(), new String[]{"feedback:"});
            return true;
        } else {
            return true;
        }
    }

    public void bGL() {
        if (this.hsj != null) {
            this.hsj.showWebViewDelay(500);
        }
    }

    public void start(String str) {
        if (this.hsj != null) {
            this.hsj.showWebLoadingView(true);
            this.hsj.showWebView(false);
            this.hsj.getWebView().loadUrl(str);
        }
    }

    public void onPostThreadCancle() {
        if (this.hsj != null) {
            this.hsj.showPostThreadLoadingView(false);
        }
    }

    private void bGM() {
        this.hsn = false;
        if (this.hsj != null && this.hsm != null) {
            if (!l.jU()) {
                this.hsj.getContext().showToast(d.k.neterror);
                this.hsj.getContext().finish();
                return;
            }
            this.hsj.showPostThreadLoadingView(true);
            this.hsm.startPostWrite();
        }
    }
}
