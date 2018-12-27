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
    private final b hUH;
    private final NewWriteModel hUK;
    private boolean hUL = false;
    private final NewWriteModel.d bai = new NewWriteModel.d() { // from class: com.baidu.tieba.write.accountAccess.a.1
        @Override // com.baidu.tieba.tbadkCore.writeModel.NewWriteModel.d
        public void callback(boolean z, PostWriteCallBackData postWriteCallBackData, w wVar, WriteData writeData, AntiData antiData) {
            if (a.this.hUH != null && a.this.hUK != null && a.this.hUK.getWriteData() != null) {
                a.this.hUH.showPostThreadLoadingView(false);
                WriteData writeData2 = writeData == null ? a.this.hUK.getWriteData() : writeData;
                if (z) {
                    a.this.hUL = true;
                    if (writeData2.getType() != 0 || writeData2.isUserFeedback()) {
                        if (postWriteCallBackData == null) {
                            c.e(a.this.hUH.getContext().getActivity(), a.this.hUH.getContext().getResources().getString(e.j.send_success), null, null);
                        } else {
                            c.e(a.this.hUH.getContext().getActivity(), postWriteCallBackData.getErrorString(), postWriteCallBackData.getPreMsg(), postWriteCallBackData.getColorMsg());
                        }
                    }
                    Intent intent = new Intent();
                    Bundle bundle = new Bundle();
                    bundle.putSerializable("post_write_callback_data", postWriteCallBackData);
                    intent.putExtras(bundle);
                    BaseActivity context = a.this.hUH.getContext();
                    a.this.hUH.getContext();
                    context.setResult(-1, intent);
                    a.this.hUH.getContext().finish();
                } else if (writeData2 != null && wVar != null && !TextUtils.isEmpty(wVar.GW())) {
                    writeData2.setVcodeMD5(wVar.getVcode_md5());
                    writeData2.setVcodeUrl(wVar.getVcode_pic_url());
                    writeData2.setVcodeExtra(wVar.GX());
                    a.this.hUH.getContext().setVisible(false);
                    if (com.baidu.tbadk.r.a.iT(wVar.GW())) {
                        MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new NewVcodeActivityConfig(a.this.hUH.getContext().getActivity(), IEventCenterService.EventId.EventMode.SAPIACCOUNT_FACE_REG, writeData2, false, wVar.GW())));
                    } else {
                        MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new VcodeActivityConfig(a.this.hUH.getContext().getActivity(), writeData2, IEventCenterService.EventId.EventMode.SAPIACCOUNT_FACE_REG)));
                    }
                } else if (postWriteCallBackData != null && postWriteCallBackData.isSensitiveError()) {
                    Intent intent2 = new Intent();
                    Bundle bundle2 = new Bundle();
                    bundle2.putSerializable("post_write_callback_data", postWriteCallBackData);
                    intent2.putExtras(bundle2);
                    BaseActivity context2 = a.this.hUH.getContext();
                    a.this.hUH.getContext();
                    context2.setResult(0, intent2);
                    a.this.hUH.getContext().finish();
                } else {
                    if (postWriteCallBackData != null) {
                        c.e(a.this.hUH.getContext().getActivity(), postWriteCallBackData.getErrorString(), postWriteCallBackData.getPreMsg(), postWriteCallBackData.getColorMsg());
                        BaseActivity context3 = a.this.hUH.getContext();
                        a.this.hUH.getContext();
                        context3.setResult(0, null);
                    }
                    a.this.hUH.getContext().finish();
                }
            }
        }
    };

    public a(b bVar, NewWriteModel newWriteModel) {
        this.hUH = bVar;
        this.hUK = newWriteModel;
        newWriteModel.b(this.bai);
    }

    public boolean xy(String str) {
        if (this.hUH == null || str == null) {
            return false;
        }
        if (str.equals("http://tieba.baidu.com/account/access/cancel")) {
            this.hUH.getContext().finish();
            return true;
        } else if (str.equals("http://tieba.baidu.com/account/access/input_focus")) {
            this.hUH.setWebViewMargin(0, UtilHelper.getImmersiveStickyBarHeight(), 0, 0);
            if (this.hUH.bNZ() != this.hUH.ff()) {
                this.hUH.setRatio(this.hUH.bNZ());
                this.hUH.bOa();
            }
            this.hUH.getWebView().setVisibility(0);
            return true;
        } else if (str.equals("http://tieba.baidu.com/account/access/valid_success")) {
            bNY();
            return true;
        } else if (str.equals("http://tieba.baidu.com/account/access/feedback") || str.equals("https://tieba.baidu.com/account/access/feedback")) {
            this.hUH.getContext().finish();
            ay.Ef().c(this.hUH.getContext().getPageContext(), new String[]{"feedback:"});
            return true;
        } else {
            return true;
        }
    }

    public void bNX() {
        if (this.hUH != null) {
            this.hUH.showWebViewDelay(500);
        }
    }

    public void al(String str) {
        if (this.hUH != null) {
            this.hUH.showWebLoadingView(true);
            this.hUH.showWebView(false);
            this.hUH.getWebView().loadUrl(str);
        }
    }

    public void onPostThreadCancle() {
        if (this.hUH != null) {
            this.hUH.showPostThreadLoadingView(false);
        }
    }

    private void bNY() {
        this.hUL = false;
        if (this.hUH != null && this.hUK != null) {
            if (!l.ll()) {
                this.hUH.getContext().showToast(e.j.neterror);
                this.hUH.getContext().finish();
                return;
            }
            this.hUH.showPostThreadLoadingView(true);
            this.hUK.startPostWrite();
        }
    }
}
