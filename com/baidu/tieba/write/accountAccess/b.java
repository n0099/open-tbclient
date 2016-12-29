package com.baidu.tieba.write.accountAccess;

import android.app.Activity;
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
import com.baidu.tbadk.coreExtra.data.q;
import com.baidu.tieba.r;
import com.baidu.tieba.tbadkCore.writeModel.PostWriteCallBackData;
import com.baidu.tieba.tbadkCore.writeModel.b;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class b implements b.d {
    final /* synthetic */ a fxU;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(a aVar) {
        this.fxU = aVar;
    }

    @Override // com.baidu.tieba.tbadkCore.writeModel.b.d
    public void callback(boolean z, PostWriteCallBackData postWriteCallBackData, q qVar, WriteData writeData, AntiData antiData) {
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
        c cVar15;
        com.baidu.tieba.tbadkCore.writeModel.b bVar2;
        cVar = this.fxU.fxP;
        if (cVar != null) {
            bVar = this.fxU.fxT;
            if (bVar != null) {
                cVar2 = this.fxU.fxP;
                cVar2.showPostThreadLoadingView(false);
                if (writeData == null) {
                    bVar2 = this.fxU.fxT;
                    writeData2 = bVar2.bbN();
                } else {
                    writeData2 = writeData;
                }
                if (z) {
                    if (postWriteCallBackData == null) {
                        cVar14 = this.fxU.fxP;
                        Activity activity = cVar14.getContext().getActivity();
                        cVar15 = this.fxU.fxP;
                        com.baidu.tieba.tbadkCore.writeModel.f.c(activity, cVar15.getContext().getResources().getString(r.j.send_success), null, null);
                    } else {
                        cVar10 = this.fxU.fxP;
                        com.baidu.tieba.tbadkCore.writeModel.f.c(cVar10.getContext().getActivity(), postWriteCallBackData.getErrorString(), postWriteCallBackData.getPreMsg(), postWriteCallBackData.getColorMsg());
                    }
                    Intent intent = new Intent();
                    Bundle bundle = new Bundle();
                    bundle.putSerializable("post_write_callback_data", postWriteCallBackData);
                    intent.putExtras(bundle);
                    cVar11 = this.fxU.fxP;
                    BaseActivity context = cVar11.getContext();
                    cVar12 = this.fxU.fxP;
                    cVar12.getContext();
                    context.setResult(-1, intent);
                    cVar13 = this.fxU.fxP;
                    cVar13.getContext().finish();
                } else if (writeData2 != null && qVar != null && !TextUtils.isEmpty(qVar.xQ())) {
                    writeData2.setVcodeMD5(qVar.getVcode_md5());
                    writeData2.setVcodeUrl(qVar.getVcode_pic_url());
                    writeData2.setVcodeExtra(qVar.xR());
                    cVar7 = this.fxU.fxP;
                    cVar7.getContext().setVisible(false);
                    if (com.baidu.tbadk.j.a.gB(qVar.xQ())) {
                        MessageManager messageManager = MessageManager.getInstance();
                        cVar9 = this.fxU.fxP;
                        messageManager.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new NewVcodeActivityConfig(cVar9.getContext().getActivity(), 12006, writeData2, false, qVar.xQ())));
                        return;
                    }
                    MessageManager messageManager2 = MessageManager.getInstance();
                    cVar8 = this.fxU.fxP;
                    messageManager2.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new VcodeActivityConfig(cVar8.getContext().getActivity(), writeData2, 12006)));
                } else {
                    if (postWriteCallBackData != null) {
                        cVar4 = this.fxU.fxP;
                        com.baidu.tieba.tbadkCore.writeModel.f.c(cVar4.getContext().getActivity(), postWriteCallBackData.getErrorString(), postWriteCallBackData.getPreMsg(), postWriteCallBackData.getColorMsg());
                        cVar5 = this.fxU.fxP;
                        BaseActivity context2 = cVar5.getContext();
                        cVar6 = this.fxU.fxP;
                        cVar6.getContext();
                        context2.setResult(0, null);
                    }
                    cVar3 = this.fxU.fxP;
                    cVar3.getContext().finish();
                }
            }
        }
    }
}
