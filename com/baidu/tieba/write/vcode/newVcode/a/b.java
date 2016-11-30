package com.baidu.tieba.write.vcode.newVcode.a;

import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.tbadk.core.atomData.AccountAccessActivityConfig;
import com.baidu.tbadk.core.data.AntiData;
import com.baidu.tbadk.core.diskCache.ImagesInvalidReceiver;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.coreExtra.data.WriteData;
import com.baidu.tbadk.coreExtra.data.s;
import com.baidu.tieba.tbadkCore.writeModel.PostWriteCallBackData;
import com.baidu.tieba.tbadkCore.writeModel.b;
import com.baidu.tieba.write.vcode.newVcode.NewVcodeView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class b implements b.d {
    final /* synthetic */ a glE;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(a aVar) {
        this.glE = aVar;
    }

    @Override // com.baidu.tieba.tbadkCore.writeModel.b.d
    public void callback(boolean z, PostWriteCallBackData postWriteCallBackData, s sVar, WriteData writeData, AntiData antiData) {
        NewVcodeView newVcodeView;
        NewVcodeView newVcodeView2;
        b.d dVar;
        b.d dVar2;
        NewVcodeView newVcodeView3;
        NewVcodeView newVcodeView4;
        String str;
        String str2;
        NewVcodeView newVcodeView5;
        String str3 = null;
        newVcodeView = this.glE.glB;
        if (newVcodeView != null) {
            newVcodeView2 = this.glE.glB;
            newVcodeView2.showPostThreadLoadingView(false);
            if (z) {
                this.glE.glC = postWriteCallBackData;
                if (sVar == null || sVar.yd() == null) {
                    str = null;
                    str2 = null;
                } else {
                    str2 = sVar.yd().endPoint;
                    str = sVar.yd().successImg;
                    str3 = sVar.yd().slideEndPoint;
                }
                newVcodeView5 = this.glE.glB;
                newVcodeView5.runJsMethod(ImagesInvalidReceiver.SUCCESS, String.valueOf(str) + "," + str2 + "," + str3);
            } else if (postWriteCallBackData != null && postWriteCallBackData.getErrorCode() == 227001) {
                newVcodeView3 = this.glE.glB;
                newVcodeView3.getContext().setVisible(false);
                MessageManager messageManager = MessageManager.getInstance();
                newVcodeView4 = this.glE.glB;
                messageManager.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AccountAccessActivityConfig(newVcodeView4.getContext().getActivity(), 12006, writeData, postWriteCallBackData.getAccessState())));
            } else {
                dVar = this.glE.glD;
                if (dVar == null) {
                    return;
                }
                dVar2 = this.glE.glD;
                dVar2.callback(false, postWriteCallBackData, sVar, writeData, antiData);
            }
        }
    }
}
