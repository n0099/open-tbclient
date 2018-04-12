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
    private final b hbe;
    private final NewWriteModel hbh;
    private boolean hbi = false;
    private final NewWriteModel.d aEK = new NewWriteModel.d() { // from class: com.baidu.tieba.write.accountAccess.a.1
        @Override // com.baidu.tieba.tbadkCore.writeModel.NewWriteModel.d
        public void callback(boolean z, PostWriteCallBackData postWriteCallBackData, t tVar, WriteData writeData, AntiData antiData) {
            if (a.this.hbe != null && a.this.hbh != null && a.this.hbh.getWriteData() != null) {
                a.this.hbe.showPostThreadLoadingView(false);
                WriteData writeData2 = writeData == null ? a.this.hbh.getWriteData() : writeData;
                if (z) {
                    a.this.hbi = true;
                    if (writeData2.getType() != 0 || writeData2.isUserFeedback()) {
                        if (postWriteCallBackData == null) {
                            c.e(a.this.hbe.getContext().getActivity(), a.this.hbe.getContext().getResources().getString(d.k.send_success), null, null);
                        } else {
                            c.e(a.this.hbe.getContext().getActivity(), postWriteCallBackData.getErrorString(), postWriteCallBackData.getPreMsg(), postWriteCallBackData.getColorMsg());
                        }
                    }
                    Intent intent = new Intent();
                    Bundle bundle = new Bundle();
                    bundle.putSerializable("post_write_callback_data", postWriteCallBackData);
                    intent.putExtras(bundle);
                    BaseActivity context = a.this.hbe.getContext();
                    a.this.hbe.getContext();
                    context.setResult(-1, intent);
                    a.this.hbe.getContext().finish();
                } else if (writeData2 != null && tVar != null && !TextUtils.isEmpty(tVar.yK())) {
                    writeData2.setVcodeMD5(tVar.getVcode_md5());
                    writeData2.setVcodeUrl(tVar.getVcode_pic_url());
                    writeData2.setVcodeExtra(tVar.yL());
                    a.this.hbe.getContext().setVisible(false);
                    if (com.baidu.tbadk.p.a.hq(tVar.yK())) {
                        MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new NewVcodeActivityConfig(a.this.hbe.getContext().getActivity(), IEventCenterService.EventId.EventMode.SAPIACCOUNT_FACE_REG, writeData2, false, tVar.yK())));
                    } else {
                        MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new VcodeActivityConfig(a.this.hbe.getContext().getActivity(), writeData2, IEventCenterService.EventId.EventMode.SAPIACCOUNT_FACE_REG)));
                    }
                } else if (postWriteCallBackData != null && postWriteCallBackData.isSensitiveError()) {
                    Intent intent2 = new Intent();
                    Bundle bundle2 = new Bundle();
                    bundle2.putSerializable("post_write_callback_data", postWriteCallBackData);
                    intent2.putExtras(bundle2);
                    BaseActivity context2 = a.this.hbe.getContext();
                    a.this.hbe.getContext();
                    context2.setResult(0, intent2);
                    a.this.hbe.getContext().finish();
                } else {
                    if (postWriteCallBackData != null) {
                        c.e(a.this.hbe.getContext().getActivity(), postWriteCallBackData.getErrorString(), postWriteCallBackData.getPreMsg(), postWriteCallBackData.getColorMsg());
                        BaseActivity context3 = a.this.hbe.getContext();
                        a.this.hbe.getContext();
                        context3.setResult(0, null);
                    }
                    a.this.hbe.getContext().finish();
                }
            }
        }
    };

    public a(b bVar, NewWriteModel newWriteModel) {
        this.hbe = bVar;
        this.hbh = newWriteModel;
        newWriteModel.b(this.aEK);
    }

    public boolean uF(String str) {
        if (this.hbe == null || str == null) {
            return false;
        }
        if (str.equals("http://tieba.baidu.com/account/access/cancel")) {
            this.hbe.getContext().finish();
            return true;
        } else if (str.equals("http://tieba.baidu.com/account/access/input_focus")) {
            this.hbe.A(0, UtilHelper.getImmersiveStickyBarHeight(), 0, 0);
            if (this.hbe.bBi() != this.hbe.aV()) {
                this.hbe.setRatio(this.hbe.bBi());
                this.hbe.bBj();
            }
            this.hbe.getWebView().setVisibility(0);
            return true;
        } else if (str.equals("http://tieba.baidu.com/account/access/valid_success")) {
            bBh();
            return true;
        } else if (str.equals("http://tieba.baidu.com/account/access/feedback") || str.equals("https://tieba.baidu.com/account/access/feedback")) {
            this.hbe.getContext().finish();
            ax.wg().c(this.hbe.getContext().getPageContext(), new String[]{"feedback:"});
            return true;
        } else {
            return true;
        }
    }

    public void bBg() {
        if (this.hbe != null) {
            this.hbe.showWebViewDelay(500);
        }
    }

    public void start(String str) {
        if (this.hbe != null) {
            this.hbe.showWebLoadingView(true);
            this.hbe.showWebView(false);
            this.hbe.getWebView().loadUrl(str);
        }
    }

    public void onPostThreadCancle() {
        if (this.hbe != null) {
            this.hbe.showPostThreadLoadingView(false);
        }
    }

    private void bBh() {
        this.hbi = false;
        if (this.hbe != null && this.hbh != null) {
            if (!l.hg()) {
                this.hbe.getContext().showToast(d.k.neterror);
                this.hbe.getContext().finish();
                return;
            }
            this.hbe.showPostThreadLoadingView(true);
            this.hbh.startPostWrite();
        }
    }
}
