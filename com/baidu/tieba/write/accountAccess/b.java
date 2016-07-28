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
import com.baidu.tbadk.coreExtra.data.p;
import com.baidu.tieba.tbadkCore.writeModel.PostWriteCallBackData;
import com.baidu.tieba.tbadkCore.writeModel.a;
import com.baidu.tieba.u;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class b implements a.d {
    final /* synthetic */ a fPG;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(a aVar) {
        this.fPG = aVar;
    }

    @Override // com.baidu.tieba.tbadkCore.writeModel.a.d
    public void callback(boolean z, PostWriteCallBackData postWriteCallBackData, p pVar, WriteData writeData, AntiData antiData) {
        c cVar;
        com.baidu.tieba.tbadkCore.writeModel.a aVar;
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
        com.baidu.tieba.tbadkCore.writeModel.a aVar2;
        cVar = this.fPG.fPB;
        if (cVar != null) {
            aVar = this.fPG.fPF;
            if (aVar != null) {
                cVar2 = this.fPG.fPB;
                cVar2.showPostThreadLoadingView(false);
                if (writeData == null) {
                    aVar2 = this.fPG.fPF;
                    writeData2 = aVar2.bbo();
                } else {
                    writeData2 = writeData;
                }
                if (z) {
                    cVar10 = this.fPG.fPB;
                    cVar11 = this.fPG.fPB;
                    cVar10.showToast(true, cVar11.getContext().getResources().getString(u.j.send_success));
                    Intent intent = new Intent();
                    Bundle bundle = new Bundle();
                    bundle.putSerializable("post_write_callback_data", postWriteCallBackData);
                    intent.putExtras(bundle);
                    cVar12 = this.fPG.fPB;
                    BaseActivity context = cVar12.getContext();
                    cVar13 = this.fPG.fPB;
                    cVar13.getContext();
                    context.setResult(-1, intent);
                    cVar14 = this.fPG.fPB;
                    cVar14.getContext().finish();
                } else if (writeData2 != null && pVar != null && !TextUtils.isEmpty(pVar.wJ())) {
                    writeData2.setVcodeMD5(pVar.getVcode_md5());
                    writeData2.setVcodeUrl(pVar.getVcode_pic_url());
                    writeData2.setVcodeExtra(pVar.wK());
                    cVar7 = this.fPG.fPB;
                    cVar7.getContext().setVisible(false);
                    if (com.baidu.tbadk.k.a.gz(pVar.wJ())) {
                        MessageManager messageManager = MessageManager.getInstance();
                        cVar9 = this.fPG.fPB;
                        messageManager.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new NewVcodeActivityConfig(cVar9.getContext().getActivity(), 12006, writeData2, false, pVar.wJ())));
                        return;
                    }
                    MessageManager messageManager2 = MessageManager.getInstance();
                    cVar8 = this.fPG.fPB;
                    messageManager2.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new VcodeActivityConfig(cVar8.getContext().getActivity(), writeData2, 12006)));
                } else {
                    if (postWriteCallBackData != null) {
                        cVar4 = this.fPG.fPB;
                        cVar4.showToast(true, postWriteCallBackData.getErrorString());
                        cVar5 = this.fPG.fPB;
                        BaseActivity context2 = cVar5.getContext();
                        cVar6 = this.fPG.fPB;
                        cVar6.getContext();
                        context2.setResult(0, null);
                    }
                    cVar3 = this.fPG.fPB;
                    cVar3.getContext().finish();
                }
            }
        }
    }
}
