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
import com.baidu.tbadk.core.util.ax;
import com.baidu.tbadk.coreExtra.data.WriteData;
import com.baidu.tbadk.coreExtra.data.t;
import com.baidu.tieba.d;
import com.baidu.tieba.tbadkCore.writeModel.NewWriteModel;
import com.baidu.tieba.tbadkCore.writeModel.PostWriteCallBackData;
import com.baidu.tieba.tbadkCore.writeModel.c;
/* loaded from: classes3.dex */
public class a {
    private final b hbb;
    private final NewWriteModel hbe;
    private boolean hbf = false;
    private final NewWriteModel.d aEK = new NewWriteModel.d() { // from class: com.baidu.tieba.write.accountAccess.a.1
        @Override // com.baidu.tieba.tbadkCore.writeModel.NewWriteModel.d
        public void callback(boolean z, PostWriteCallBackData postWriteCallBackData, t tVar, WriteData writeData, AntiData antiData) {
            if (a.this.hbb != null && a.this.hbe != null && a.this.hbe.getWriteData() != null) {
                a.this.hbb.showPostThreadLoadingView(false);
                WriteData writeData2 = writeData == null ? a.this.hbe.getWriteData() : writeData;
                if (z) {
                    a.this.hbf = true;
                    if (writeData2.getType() != 0 || writeData2.isUserFeedback()) {
                        if (postWriteCallBackData == null) {
                            c.e(a.this.hbb.getContext().getActivity(), a.this.hbb.getContext().getResources().getString(d.k.send_success), null, null);
                        } else {
                            c.e(a.this.hbb.getContext().getActivity(), postWriteCallBackData.getErrorString(), postWriteCallBackData.getPreMsg(), postWriteCallBackData.getColorMsg());
                        }
                    }
                    Intent intent = new Intent();
                    Bundle bundle = new Bundle();
                    bundle.putSerializable("post_write_callback_data", postWriteCallBackData);
                    intent.putExtras(bundle);
                    BaseActivity context = a.this.hbb.getContext();
                    a.this.hbb.getContext();
                    context.setResult(-1, intent);
                    a.this.hbb.getContext().finish();
                } else if (writeData2 != null && tVar != null && !TextUtils.isEmpty(tVar.yK())) {
                    writeData2.setVcodeMD5(tVar.getVcode_md5());
                    writeData2.setVcodeUrl(tVar.getVcode_pic_url());
                    writeData2.setVcodeExtra(tVar.yL());
                    a.this.hbb.getContext().setVisible(false);
                    if (com.baidu.tbadk.p.a.hq(tVar.yK())) {
                        MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new NewVcodeActivityConfig(a.this.hbb.getContext().getActivity(), IEventCenterService.EventId.EventMode.SAPIACCOUNT_FACE_REG, writeData2, false, tVar.yK())));
                    } else {
                        MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new VcodeActivityConfig(a.this.hbb.getContext().getActivity(), writeData2, IEventCenterService.EventId.EventMode.SAPIACCOUNT_FACE_REG)));
                    }
                } else if (postWriteCallBackData != null && postWriteCallBackData.isSensitiveError()) {
                    Intent intent2 = new Intent();
                    Bundle bundle2 = new Bundle();
                    bundle2.putSerializable("post_write_callback_data", postWriteCallBackData);
                    intent2.putExtras(bundle2);
                    BaseActivity context2 = a.this.hbb.getContext();
                    a.this.hbb.getContext();
                    context2.setResult(0, intent2);
                    a.this.hbb.getContext().finish();
                } else {
                    if (postWriteCallBackData != null) {
                        c.e(a.this.hbb.getContext().getActivity(), postWriteCallBackData.getErrorString(), postWriteCallBackData.getPreMsg(), postWriteCallBackData.getColorMsg());
                        BaseActivity context3 = a.this.hbb.getContext();
                        a.this.hbb.getContext();
                        context3.setResult(0, null);
                    }
                    a.this.hbb.getContext().finish();
                }
            }
        }
    };

    public a(b bVar, NewWriteModel newWriteModel) {
        this.hbb = bVar;
        this.hbe = newWriteModel;
        newWriteModel.b(this.aEK);
    }

    public boolean uF(String str) {
        if (this.hbb == null || str == null) {
            return false;
        }
        if (str.equals("http://tieba.baidu.com/account/access/cancel")) {
            this.hbb.getContext().finish();
            return true;
        } else if (str.equals("http://tieba.baidu.com/account/access/input_focus")) {
            this.hbb.A(0, UtilHelper.getImmersiveStickyBarHeight(), 0, 0);
            if (this.hbb.bBi() != this.hbb.aV()) {
                this.hbb.setRatio(this.hbb.bBi());
                this.hbb.bBj();
            }
            this.hbb.getWebView().setVisibility(0);
            return true;
        } else if (str.equals("http://tieba.baidu.com/account/access/valid_success")) {
            bBh();
            return true;
        } else if (str.equals("http://tieba.baidu.com/account/access/feedback") || str.equals("https://tieba.baidu.com/account/access/feedback")) {
            this.hbb.getContext().finish();
            ax.wg().c(this.hbb.getContext().getPageContext(), new String[]{"feedback:"});
            return true;
        } else {
            return true;
        }
    }

    public void bBg() {
        if (this.hbb != null) {
            this.hbb.showWebViewDelay(500);
        }
    }

    public void start(String str) {
        if (this.hbb != null) {
            this.hbb.showWebLoadingView(true);
            this.hbb.showWebView(false);
            this.hbb.getWebView().loadUrl(str);
        }
    }

    public void onPostThreadCancle() {
        if (this.hbb != null) {
            this.hbb.showPostThreadLoadingView(false);
        }
    }

    private void bBh() {
        this.hbf = false;
        if (this.hbb != null && this.hbe != null) {
            if (!l.hg()) {
                this.hbb.getContext().showToast(d.k.neterror);
                this.hbb.getContext().finish();
                return;
            }
            this.hbb.showPostThreadLoadingView(true);
            this.hbe.startPostWrite();
        }
    }
}
