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
    private final b hEo;
    private final NewWriteModel hEr;
    private boolean hEs = false;
    private final NewWriteModel.d buw = new NewWriteModel.d() { // from class: com.baidu.tieba.write.accountAccess.a.1
        @Override // com.baidu.tieba.tbadkCore.writeModel.NewWriteModel.d
        public void callback(boolean z, PostWriteCallBackData postWriteCallBackData, t tVar, WriteData writeData, AntiData antiData) {
            if (a.this.hEo != null && a.this.hEr != null && a.this.hEr.getWriteData() != null) {
                a.this.hEo.showPostThreadLoadingView(false);
                WriteData writeData2 = writeData == null ? a.this.hEr.getWriteData() : writeData;
                if (z) {
                    a.this.hEs = true;
                    if (writeData2.getIsStory() != 1 && (writeData2.getType() != 0 || writeData2.isUserFeedback())) {
                        if (postWriteCallBackData == null) {
                            c.e(a.this.hEo.getContext().getActivity(), a.this.hEo.getContext().getResources().getString(d.j.send_success), null, null);
                        } else {
                            c.e(a.this.hEo.getContext().getActivity(), postWriteCallBackData.getErrorString(), postWriteCallBackData.getPreMsg(), postWriteCallBackData.getColorMsg());
                        }
                    }
                    Intent intent = new Intent();
                    Bundle bundle = new Bundle();
                    bundle.putSerializable("post_write_callback_data", postWriteCallBackData);
                    intent.putExtras(bundle);
                    BaseActivity context = a.this.hEo.getContext();
                    a.this.hEo.getContext();
                    context.setResult(-1, intent);
                    a.this.hEo.getContext().finish();
                } else if (writeData2 != null && tVar != null && !TextUtils.isEmpty(tVar.FX())) {
                    writeData2.setVcodeMD5(tVar.getVcode_md5());
                    writeData2.setVcodeUrl(tVar.getVcode_pic_url());
                    writeData2.setVcodeExtra(tVar.FY());
                    a.this.hEo.getContext().setVisible(false);
                    if (com.baidu.tbadk.p.a.hx(tVar.FX())) {
                        MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new NewVcodeActivityConfig(a.this.hEo.getContext().getActivity(), IEventCenterService.EventId.EventMode.SAPIACCOUNT_FACE_REG, writeData2, false, tVar.FX())));
                    } else {
                        MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new VcodeActivityConfig(a.this.hEo.getContext().getActivity(), writeData2, IEventCenterService.EventId.EventMode.SAPIACCOUNT_FACE_REG)));
                    }
                } else if (postWriteCallBackData != null && postWriteCallBackData.isSensitiveError()) {
                    Intent intent2 = new Intent();
                    Bundle bundle2 = new Bundle();
                    bundle2.putSerializable("post_write_callback_data", postWriteCallBackData);
                    intent2.putExtras(bundle2);
                    BaseActivity context2 = a.this.hEo.getContext();
                    a.this.hEo.getContext();
                    context2.setResult(0, intent2);
                    a.this.hEo.getContext().finish();
                } else {
                    if (postWriteCallBackData != null) {
                        c.e(a.this.hEo.getContext().getActivity(), postWriteCallBackData.getErrorString(), postWriteCallBackData.getPreMsg(), postWriteCallBackData.getColorMsg());
                        BaseActivity context3 = a.this.hEo.getContext();
                        a.this.hEo.getContext();
                        context3.setResult(0, null);
                    }
                    a.this.hEo.getContext().finish();
                }
            }
        }
    };

    public a(b bVar, NewWriteModel newWriteModel) {
        this.hEo = bVar;
        this.hEr = newWriteModel;
        newWriteModel.b(this.buw);
    }

    public boolean up(String str) {
        if (this.hEo == null || str == null) {
            return false;
        }
        if (str.equals("http://tieba.baidu.com/account/access/cancel")) {
            this.hEo.getContext().finish();
            return true;
        } else if (str.equals("http://tieba.baidu.com/account/access/input_focus")) {
            this.hEo.H(0, UtilHelper.getImmersiveStickyBarHeight(), 0, 0);
            if (this.hEo.bFR() != this.hEo.iR()) {
                this.hEo.setRatio(this.hEo.bFR());
                this.hEo.bFS();
            }
            this.hEo.getWebView().setVisibility(0);
            return true;
        } else if (str.equals("http://tieba.baidu.com/account/access/valid_success")) {
            bFP();
            return true;
        } else if (str.equals("http://tieba.baidu.com/account/access/feedback") || str.equals("https://tieba.baidu.com/account/access/feedback")) {
            this.hEo.getContext().finish();
            aw.Du().c(this.hEo.getContext().getPageContext(), new String[]{"feedback:"});
            return true;
        } else {
            return true;
        }
    }

    public void bFO() {
        if (this.hEo != null) {
            this.hEo.showWebViewDelay(500);
        }
    }

    public void start(String str) {
        if (this.hEo != null) {
            this.hEo.showWebLoadingView(true);
            this.hEo.showWebView(false);
            this.hEo.getWebView().loadUrl(str);
        }
    }

    public void onPostThreadCancle() {
        if (this.hEo != null) {
            this.hEo.showPostThreadLoadingView(false);
        }
    }

    private void bFP() {
        this.hEs = false;
        if (this.hEo != null && this.hEr != null) {
            if (!l.pa()) {
                this.hEo.getContext().showToast(d.j.neterror);
                this.hEo.getContext().finish();
                return;
            }
            this.hEo.showPostThreadLoadingView(true);
            this.hEr.startPostWrite();
        }
    }

    public boolean bFQ() {
        return this.hEs;
    }
}
