package com.baidu.tieba.write.vcode.newVcode.a;

import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.tbadk.core.atomData.AccountAccessActivityConfig;
import com.baidu.tbadk.core.data.AntiData;
import com.baidu.tbadk.core.diskCache.ImagesInvalidReceiver;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.coreExtra.data.WriteData;
import com.baidu.tbadk.coreExtra.data.p;
import com.baidu.tieba.tbadkCore.writeModel.PostWriteCallBackData;
import com.baidu.tieba.tbadkCore.writeModel.a;
import com.baidu.tieba.write.vcode.newVcode.NewVcodeView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class b implements a.d {
    final /* synthetic */ a fRM;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(a aVar) {
        this.fRM = aVar;
    }

    @Override // com.baidu.tieba.tbadkCore.writeModel.a.d
    public void callback(boolean z, PostWriteCallBackData postWriteCallBackData, p pVar, WriteData writeData, AntiData antiData) {
        NewVcodeView newVcodeView;
        NewVcodeView newVcodeView2;
        a.d dVar;
        a.d dVar2;
        NewVcodeView newVcodeView3;
        NewVcodeView newVcodeView4;
        String str;
        String str2;
        NewVcodeView newVcodeView5;
        String str3 = null;
        newVcodeView = this.fRM.fRJ;
        if (newVcodeView != null) {
            newVcodeView2 = this.fRM.fRJ;
            newVcodeView2.showPostThreadLoadingView(false);
            if (z) {
                this.fRM.fRK = postWriteCallBackData;
                if (pVar == null || pVar.wK() == null) {
                    str = null;
                    str2 = null;
                } else {
                    str2 = pVar.wK().endPoint;
                    str = pVar.wK().successImg;
                    str3 = pVar.wK().slideEndPoint;
                }
                newVcodeView5 = this.fRM.fRJ;
                newVcodeView5.runJsMethod(ImagesInvalidReceiver.SUCCESS, String.valueOf(str) + "," + str2 + "," + str3);
            } else if (postWriteCallBackData != null && postWriteCallBackData.getErrorCode() == 227001) {
                newVcodeView3 = this.fRM.fRJ;
                newVcodeView3.getContext().setVisible(false);
                MessageManager messageManager = MessageManager.getInstance();
                newVcodeView4 = this.fRM.fRJ;
                messageManager.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AccountAccessActivityConfig(newVcodeView4.getContext().getActivity(), 12006, writeData, postWriteCallBackData.getAccessState())));
            } else {
                dVar = this.fRM.fRL;
                if (dVar == null) {
                    return;
                }
                dVar2 = this.fRM.fRL;
                dVar2.callback(false, postWriteCallBackData, pVar, writeData, antiData);
            }
        }
    }
}
