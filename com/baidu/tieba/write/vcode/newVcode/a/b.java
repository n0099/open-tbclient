package com.baidu.tieba.write.vcode.newVcode.a;

import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.tbadk.core.atomData.AccountAccessActivityConfig;
import com.baidu.tbadk.core.data.AntiData;
import com.baidu.tbadk.core.diskCache.ImagesInvalidReceiver;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.coreExtra.data.WriteData;
import com.baidu.tbadk.coreExtra.data.q;
import com.baidu.tieba.tbadkCore.writeModel.NewWriteModel;
import com.baidu.tieba.tbadkCore.writeModel.PostWriteCallBackData;
import com.baidu.tieba.write.vcode.newVcode.NewVcodeView;
import com.xiaomi.mipush.sdk.Constants;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class b implements NewWriteModel.d {
    final /* synthetic */ a gib;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(a aVar) {
        this.gib = aVar;
    }

    @Override // com.baidu.tieba.tbadkCore.writeModel.NewWriteModel.d
    public void callback(boolean z, PostWriteCallBackData postWriteCallBackData, q qVar, WriteData writeData, AntiData antiData) {
        NewVcodeView newVcodeView;
        NewVcodeView newVcodeView2;
        NewWriteModel.d dVar;
        NewWriteModel.d dVar2;
        NewVcodeView newVcodeView3;
        NewVcodeView newVcodeView4;
        String str;
        String str2;
        NewVcodeView newVcodeView5;
        String str3 = null;
        newVcodeView = this.gib.ghY;
        if (newVcodeView != null) {
            newVcodeView2 = this.gib.ghY;
            newVcodeView2.showPostThreadLoadingView(false);
            if (z) {
                this.gib.ghZ = postWriteCallBackData;
                if (qVar == null || qVar.yf() == null) {
                    str = null;
                    str2 = null;
                } else {
                    str2 = qVar.yf().endPoint;
                    str = qVar.yf().successImg;
                    str3 = qVar.yf().slideEndPoint;
                }
                newVcodeView5 = this.gib.ghY;
                newVcodeView5.runJsMethod(ImagesInvalidReceiver.SUCCESS, String.valueOf(str) + Constants.ACCEPT_TIME_SEPARATOR_SP + str2 + Constants.ACCEPT_TIME_SEPARATOR_SP + str3);
            } else if (postWriteCallBackData != null && postWriteCallBackData.getErrorCode() == 227001) {
                newVcodeView3 = this.gib.ghY;
                newVcodeView3.getContext().setVisible(false);
                MessageManager messageManager = MessageManager.getInstance();
                newVcodeView4 = this.gib.ghY;
                messageManager.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AccountAccessActivityConfig(newVcodeView4.getContext().getActivity(), 12006, writeData, postWriteCallBackData.getAccessState())));
            } else {
                dVar = this.gib.gia;
                if (dVar == null) {
                    return;
                }
                dVar2 = this.gib.gia;
                dVar2.callback(false, postWriteCallBackData, qVar, writeData, antiData);
            }
        }
    }
}
