package com.baidu.tieba.write.vcode.newVcode.a;

import com.baidu.tbadk.core.data.AntiData;
import com.baidu.tbadk.core.diskCache.ImagesInvalidReceiver;
import com.baidu.tbadk.coreExtra.data.WriteData;
import com.baidu.tbadk.coreExtra.data.p;
import com.baidu.tieba.tbadkCore.writeModel.PostWriteCallBackData;
import com.baidu.tieba.tbadkCore.writeModel.a;
import com.baidu.tieba.write.vcode.newVcode.NewVcodeView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class b implements a.d {
    final /* synthetic */ a fFL;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(a aVar) {
        this.fFL = aVar;
    }

    @Override // com.baidu.tieba.tbadkCore.writeModel.a.d
    public void callback(boolean z, PostWriteCallBackData postWriteCallBackData, p pVar, WriteData writeData, AntiData antiData) {
        a.d dVar;
        a.d dVar2;
        NewVcodeView newVcodeView;
        String str;
        String str2;
        NewVcodeView newVcodeView2;
        String str3 = null;
        if (z) {
            newVcodeView = this.fFL.fFH;
            newVcodeView.showPostThreadLoadingView(false);
            this.fFL.fFJ = postWriteCallBackData;
            if (pVar == null || pVar.wK() == null) {
                str = null;
                str2 = null;
            } else {
                str2 = pVar.wK().endPoint;
                str = pVar.wK().successImg;
                str3 = pVar.wK().slideEndPoint;
            }
            newVcodeView2 = this.fFL.fFH;
            newVcodeView2.runJsMethod(ImagesInvalidReceiver.SUCCESS, String.valueOf(str) + "," + str2 + "," + str3);
            return;
        }
        dVar = this.fFL.fFK;
        if (dVar == null) {
            return;
        }
        dVar2 = this.fFL.fFK;
        dVar2.callback(false, postWriteCallBackData, pVar, writeData, antiData);
    }
}
