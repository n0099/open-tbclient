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
    private final b hKl;
    private final NewWriteModel hKo;
    private boolean hKp = false;
    private final NewWriteModel.d aWI = new NewWriteModel.d() { // from class: com.baidu.tieba.write.accountAccess.a.1
        @Override // com.baidu.tieba.tbadkCore.writeModel.NewWriteModel.d
        public void callback(boolean z, PostWriteCallBackData postWriteCallBackData, w wVar, WriteData writeData, AntiData antiData) {
            if (a.this.hKl != null && a.this.hKo != null && a.this.hKo.getWriteData() != null) {
                a.this.hKl.showPostThreadLoadingView(false);
                WriteData writeData2 = writeData == null ? a.this.hKo.getWriteData() : writeData;
                if (z) {
                    a.this.hKp = true;
                    if (writeData2.getType() != 0 || writeData2.isUserFeedback()) {
                        if (postWriteCallBackData == null) {
                            c.e(a.this.hKl.getContext().getActivity(), a.this.hKl.getContext().getResources().getString(e.j.send_success), null, null);
                        } else {
                            c.e(a.this.hKl.getContext().getActivity(), postWriteCallBackData.getErrorString(), postWriteCallBackData.getPreMsg(), postWriteCallBackData.getColorMsg());
                        }
                    }
                    Intent intent = new Intent();
                    Bundle bundle = new Bundle();
                    bundle.putSerializable("post_write_callback_data", postWriteCallBackData);
                    intent.putExtras(bundle);
                    BaseActivity context = a.this.hKl.getContext();
                    a.this.hKl.getContext();
                    context.setResult(-1, intent);
                    a.this.hKl.getContext().finish();
                } else if (writeData2 != null && wVar != null && !TextUtils.isEmpty(wVar.FR())) {
                    writeData2.setVcodeMD5(wVar.getVcode_md5());
                    writeData2.setVcodeUrl(wVar.getVcode_pic_url());
                    writeData2.setVcodeExtra(wVar.FS());
                    a.this.hKl.getContext().setVisible(false);
                    if (com.baidu.tbadk.q.a.iA(wVar.FR())) {
                        MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new NewVcodeActivityConfig(a.this.hKl.getContext().getActivity(), IEventCenterService.EventId.EventMode.SAPIACCOUNT_FACE_REG, writeData2, false, wVar.FR())));
                    } else {
                        MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new VcodeActivityConfig(a.this.hKl.getContext().getActivity(), writeData2, IEventCenterService.EventId.EventMode.SAPIACCOUNT_FACE_REG)));
                    }
                } else if (postWriteCallBackData != null && postWriteCallBackData.isSensitiveError()) {
                    Intent intent2 = new Intent();
                    Bundle bundle2 = new Bundle();
                    bundle2.putSerializable("post_write_callback_data", postWriteCallBackData);
                    intent2.putExtras(bundle2);
                    BaseActivity context2 = a.this.hKl.getContext();
                    a.this.hKl.getContext();
                    context2.setResult(0, intent2);
                    a.this.hKl.getContext().finish();
                } else {
                    if (postWriteCallBackData != null) {
                        c.e(a.this.hKl.getContext().getActivity(), postWriteCallBackData.getErrorString(), postWriteCallBackData.getPreMsg(), postWriteCallBackData.getColorMsg());
                        BaseActivity context3 = a.this.hKl.getContext();
                        a.this.hKl.getContext();
                        context3.setResult(0, null);
                    }
                    a.this.hKl.getContext().finish();
                }
            }
        }
    };

    public a(b bVar, NewWriteModel newWriteModel) {
        this.hKl = bVar;
        this.hKo = newWriteModel;
        newWriteModel.b(this.aWI);
    }

    public boolean wS(String str) {
        if (this.hKl == null || str == null) {
            return false;
        }
        if (str.equals("http://tieba.baidu.com/account/access/cancel")) {
            this.hKl.getContext().finish();
            return true;
        } else if (str.equals("http://tieba.baidu.com/account/access/input_focus")) {
            this.hKl.setWebViewMargin(0, UtilHelper.getImmersiveStickyBarHeight(), 0, 0);
            if (this.hKl.bLd() != this.hKl.ff()) {
                this.hKl.setRatio(this.hKl.bLd());
                this.hKl.bLe();
            }
            this.hKl.getWebView().setVisibility(0);
            return true;
        } else if (str.equals("http://tieba.baidu.com/account/access/valid_success")) {
            bLc();
            return true;
        } else if (str.equals("http://tieba.baidu.com/account/access/feedback") || str.equals("https://tieba.baidu.com/account/access/feedback")) {
            this.hKl.getContext().finish();
            ay.Db().c(this.hKl.getContext().getPageContext(), new String[]{"feedback:"});
            return true;
        } else {
            return true;
        }
    }

    public void bLb() {
        if (this.hKl != null) {
            this.hKl.showWebViewDelay(500);
        }
    }

    public void al(String str) {
        if (this.hKl != null) {
            this.hKl.showWebLoadingView(true);
            this.hKl.showWebView(false);
            this.hKl.getWebView().loadUrl(str);
        }
    }

    public void onPostThreadCancle() {
        if (this.hKl != null) {
            this.hKl.showPostThreadLoadingView(false);
        }
    }

    private void bLc() {
        this.hKp = false;
        if (this.hKl != null && this.hKo != null) {
            if (!l.lm()) {
                this.hKl.getContext().showToast(e.j.neterror);
                this.hKl.getContext().finish();
                return;
            }
            this.hKl.showPostThreadLoadingView(true);
            this.hKo.startPostWrite();
        }
    }
}
