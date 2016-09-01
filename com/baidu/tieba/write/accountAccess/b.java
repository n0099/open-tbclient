package com.baidu.tieba.write.accountAccess;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.core.atomData.NewVcodeActivityConfig;
import com.baidu.tbadk.core.atomData.VcodeActivityConfig;
import com.baidu.tbadk.core.data.AntiData;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.coreExtra.data.WriteData;
import com.baidu.tbadk.coreExtra.data.s;
import com.baidu.tieba.t;
import com.baidu.tieba.tbadkCore.writeModel.PostWriteCallBackData;
import com.baidu.tieba.tbadkCore.writeModel.b;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class b implements b.d {
    final /* synthetic */ a fZL;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(a aVar) {
        this.fZL = aVar;
    }

    @Override // com.baidu.tieba.tbadkCore.writeModel.b.d
    public void callback(boolean z, PostWriteCallBackData postWriteCallBackData, s sVar, WriteData writeData, AntiData antiData) {
        c cVar;
        com.baidu.tieba.tbadkCore.writeModel.b bVar;
        c cVar2;
        WriteData writeData2;
        c cVar3;
        c cVar4;
        c cVar5;
        c cVar6;
        c cVar7;
        c cVar8;
        c cVar9;
        c cVar10;
        c cVar11;
        c cVar12;
        c cVar13;
        c cVar14;
        com.baidu.tieba.tbadkCore.writeModel.b bVar2;
        cVar = this.fZL.fZG;
        if (cVar != null) {
            bVar = this.fZL.fZK;
            if (bVar != null) {
                cVar2 = this.fZL.fZG;
                cVar2.showPostThreadLoadingView(false);
                if (writeData == null) {
                    bVar2 = this.fZL.fZK;
                    writeData2 = bVar2.beT();
                } else {
                    writeData2 = writeData;
                }
                if (z) {
                    cVar10 = this.fZL.fZG;
                    cVar11 = this.fZL.fZG;
                    cVar10.showToast(true, cVar11.getContext().getResources().getString(t.j.send_success));
                    Intent intent = new Intent();
                    Bundle bundle = new Bundle();
                    bundle.putSerializable("post_write_callback_data", postWriteCallBackData);
                    intent.putExtras(bundle);
                    cVar12 = this.fZL.fZG;
                    BaseActivity context = cVar12.getContext();
                    cVar13 = this.fZL.fZG;
                    cVar13.getContext();
                    context.setResult(-1, intent);
                    cVar14 = this.fZL.fZG;
                    cVar14.getContext().finish();
                } else if (writeData2 != null && sVar != null && !TextUtils.isEmpty(sVar.xT())) {
                    writeData2.setVcodeMD5(sVar.getVcode_md5());
                    writeData2.setVcodeUrl(sVar.getVcode_pic_url());
                    writeData2.setVcodeExtra(sVar.xU());
                    cVar7 = this.fZL.fZG;
                    cVar7.getContext().setVisible(false);
                    if (com.baidu.tbadk.k.a.gC(sVar.xT())) {
                        MessageManager messageManager = MessageManager.getInstance();
                        cVar9 = this.fZL.fZG;
                        messageManager.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new NewVcodeActivityConfig(cVar9.getContext().getActivity(), 12006, writeData2, false, sVar.xT())));
                        return;
                    }
                    MessageManager messageManager2 = MessageManager.getInstance();
                    cVar8 = this.fZL.fZG;
                    messageManager2.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new VcodeActivityConfig(cVar8.getContext().getActivity(), writeData2, 12006)));
                } else {
                    if (postWriteCallBackData != null) {
                        cVar4 = this.fZL.fZG;
                        cVar4.showToast(true, postWriteCallBackData.getErrorString());
                        cVar5 = this.fZL.fZG;
                        BaseActivity context2 = cVar5.getContext();
                        cVar6 = this.fZL.fZG;
                        cVar6.getContext();
                        context2.setResult(0, null);
                    }
                    cVar3 = this.fZL.fZG;
                    cVar3.getContext().finish();
                }
            }
        }
    }
}
