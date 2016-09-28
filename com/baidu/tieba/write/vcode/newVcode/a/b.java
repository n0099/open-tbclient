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
    final /* synthetic */ a gea;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(a aVar) {
        this.gea = aVar;
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
        newVcodeView = this.gea.gdX;
        if (newVcodeView != null) {
            newVcodeView2 = this.gea.gdX;
            newVcodeView2.showPostThreadLoadingView(false);
            if (z) {
                this.gea.gdY = postWriteCallBackData;
                if (sVar == null || sVar.xX() == null) {
                    str = null;
                    str2 = null;
                } else {
                    str2 = sVar.xX().endPoint;
                    str = sVar.xX().successImg;
                    str3 = sVar.xX().slideEndPoint;
                }
                newVcodeView5 = this.gea.gdX;
                newVcodeView5.runJsMethod(ImagesInvalidReceiver.SUCCESS, String.valueOf(str) + "," + str2 + "," + str3);
            } else if (postWriteCallBackData != null && postWriteCallBackData.getErrorCode() == 227001) {
                newVcodeView3 = this.gea.gdX;
                newVcodeView3.getContext().setVisible(false);
                MessageManager messageManager = MessageManager.getInstance();
                newVcodeView4 = this.gea.gdX;
                messageManager.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AccountAccessActivityConfig(newVcodeView4.getContext().getActivity(), 12006, writeData, postWriteCallBackData.getAccessState())));
            } else {
                dVar = this.gea.gdZ;
                if (dVar == null) {
                    return;
                }
                dVar2 = this.gea.gdZ;
                dVar2.callback(false, postWriteCallBackData, sVar, writeData, antiData);
            }
        }
    }
}
