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
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.av;
import com.baidu.tbadk.coreExtra.data.WriteData;
import com.baidu.tbadk.coreExtra.data.s;
import com.baidu.tieba.d;
import com.baidu.tieba.tbadkCore.writeModel.NewWriteModel;
import com.baidu.tieba.tbadkCore.writeModel.PostWriteCallBackData;
import com.baidu.tieba.tbadkCore.writeModel.c;
/* loaded from: classes2.dex */
public class a {
    private final b heP;
    private final NewWriteModel heS;
    private boolean heT = false;
    private final NewWriteModel.d aDS = new NewWriteModel.d() { // from class: com.baidu.tieba.write.accountAccess.a.1
        @Override // com.baidu.tieba.tbadkCore.writeModel.NewWriteModel.d
        public void callback(boolean z, PostWriteCallBackData postWriteCallBackData, s sVar, WriteData writeData, AntiData antiData) {
            if (a.this.heP != null && a.this.heS != null && a.this.heS.getWriteData() != null) {
                a.this.heP.showPostThreadLoadingView(false);
                WriteData writeData2 = writeData == null ? a.this.heS.getWriteData() : writeData;
                if (z) {
                    a.this.heT = true;
                    if (writeData2.getIsStory() != 1 && (writeData2.getType() != 0 || writeData2.isUserFeedback())) {
                        if (postWriteCallBackData == null) {
                            c.d(a.this.heP.getContext().getActivity(), a.this.heP.getContext().getResources().getString(d.j.send_success), null, null);
                        } else {
                            c.d(a.this.heP.getContext().getActivity(), postWriteCallBackData.getErrorString(), postWriteCallBackData.getPreMsg(), postWriteCallBackData.getColorMsg());
                        }
                    }
                    Intent intent = new Intent();
                    Bundle bundle = new Bundle();
                    bundle.putSerializable("post_write_callback_data", postWriteCallBackData);
                    intent.putExtras(bundle);
                    BaseActivity context = a.this.heP.getContext();
                    a.this.heP.getContext();
                    context.setResult(-1, intent);
                    a.this.heP.getContext().finish();
                } else if (writeData2 != null && sVar != null && !TextUtils.isEmpty(sVar.yj())) {
                    writeData2.setVcodeMD5(sVar.getVcode_md5());
                    writeData2.setVcodeUrl(sVar.getVcode_pic_url());
                    writeData2.setVcodeExtra(sVar.yk());
                    a.this.heP.getContext().setVisible(false);
                    if (com.baidu.tbadk.p.a.hc(sVar.yj())) {
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new NewVcodeActivityConfig(a.this.heP.getContext().getActivity(), IEventCenterService.EventId.EventMode.SAPIACCOUNT_FACE_REG, writeData2, false, sVar.yj())));
                    } else {
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new VcodeActivityConfig(a.this.heP.getContext().getActivity(), writeData2, IEventCenterService.EventId.EventMode.SAPIACCOUNT_FACE_REG)));
                    }
                } else if (postWriteCallBackData != null && postWriteCallBackData.isSensitiveError()) {
                    Intent intent2 = new Intent();
                    Bundle bundle2 = new Bundle();
                    bundle2.putSerializable("post_write_callback_data", postWriteCallBackData);
                    intent2.putExtras(bundle2);
                    BaseActivity context2 = a.this.heP.getContext();
                    a.this.heP.getContext();
                    context2.setResult(0, intent2);
                    a.this.heP.getContext().finish();
                } else {
                    if (postWriteCallBackData != null) {
                        c.d(a.this.heP.getContext().getActivity(), postWriteCallBackData.getErrorString(), postWriteCallBackData.getPreMsg(), postWriteCallBackData.getColorMsg());
                        BaseActivity context3 = a.this.heP.getContext();
                        a.this.heP.getContext();
                        context3.setResult(0, null);
                    }
                    a.this.heP.getContext().finish();
                }
            }
        }
    };

    public a(b bVar, NewWriteModel newWriteModel) {
        this.heP = bVar;
        this.heS = newWriteModel;
        newWriteModel.b(this.aDS);
    }

    public boolean uD(String str) {
        if (this.heP == null || str == null) {
            return false;
        }
        if (str.equals("http://tieba.baidu.com/account/access/cancel")) {
            this.heP.getContext().finish();
            return true;
        } else if (str.equals("http://tieba.baidu.com/account/access/input_focus")) {
            this.heP.A(0, UtilHelper.getImmersiveStickyBarHeight(), 0, 0);
            if (this.heP.bFS() != this.heP.bm()) {
                this.heP.setRatio(this.heP.bFS());
                this.heP.bFT();
            }
            this.heP.getWebView().setVisibility(0);
            return true;
        } else if (str.equals("http://tieba.baidu.com/account/access/valid_success")) {
            bFQ();
            return true;
        } else if (str.equals("http://tieba.baidu.com/account/access/feedback") || str.equals("https://tieba.baidu.com/account/access/feedback")) {
            this.heP.getContext().finish();
            av.vI().c(this.heP.getContext().getPageContext(), new String[]{"feedback:"});
            return true;
        } else {
            return true;
        }
    }

    public void bFP() {
        if (this.heP != null) {
            this.heP.showWebViewDelay(500);
        }
    }

    public void start(String str) {
        if (this.heP != null) {
            this.heP.showWebLoadingView(true);
            this.heP.showWebView(false);
            this.heP.getWebView().loadUrl(str);
        }
    }

    public void onPostThreadCancle() {
        if (this.heP != null) {
            this.heP.showPostThreadLoadingView(false);
        }
    }

    private void bFQ() {
        this.heT = false;
        if (this.heP != null && this.heS != null) {
            if (!l.hy()) {
                this.heP.getContext().showToast(d.j.neterror);
                this.heP.getContext().finish();
                return;
            }
            this.heP.showPostThreadLoadingView(true);
            this.heS.startPostWrite();
        }
    }

    public boolean bFR() {
        return this.heT;
    }
}
