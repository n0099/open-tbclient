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
import com.baidu.tieba.tbadkCore.writeModel.NewWriteModel;
import com.baidu.tieba.tbadkCore.writeModel.PostWriteCallBackData;
import com.baidu.tieba.w;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class b implements NewWriteModel.d {
    final /* synthetic */ a fMC;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(a aVar) {
        this.fMC = aVar;
    }

    @Override // com.baidu.tieba.tbadkCore.writeModel.NewWriteModel.d
    public void callback(boolean z, PostWriteCallBackData postWriteCallBackData, q qVar, WriteData writeData, AntiData antiData) {
        c cVar;
        NewWriteModel newWriteModel;
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
        NewWriteModel newWriteModel2;
        cVar = this.fMC.fMy;
        if (cVar != null) {
            newWriteModel = this.fMC.fMB;
            if (newWriteModel != null) {
                cVar2 = this.fMC.fMy;
                cVar2.showPostThreadLoadingView(false);
                if (writeData == null) {
                    newWriteModel2 = this.fMC.fMB;
                    writeData2 = newWriteModel2.getWriteData();
                } else {
                    writeData2 = writeData;
                }
                if (z) {
                    if (postWriteCallBackData == null) {
                        cVar14 = this.fMC.fMy;
                        Activity activity = cVar14.getContext().getActivity();
                        cVar15 = this.fMC.fMy;
                        com.baidu.tieba.tbadkCore.writeModel.e.c(activity, cVar15.getContext().getResources().getString(w.l.send_success), null, null);
                    } else {
                        cVar10 = this.fMC.fMy;
                        com.baidu.tieba.tbadkCore.writeModel.e.c(cVar10.getContext().getActivity(), postWriteCallBackData.getErrorString(), postWriteCallBackData.getPreMsg(), postWriteCallBackData.getColorMsg());
                    }
                    Intent intent = new Intent();
                    Bundle bundle = new Bundle();
                    bundle.putSerializable("post_write_callback_data", postWriteCallBackData);
                    intent.putExtras(bundle);
                    cVar11 = this.fMC.fMy;
                    BaseActivity context = cVar11.getContext();
                    cVar12 = this.fMC.fMy;
                    cVar12.getContext();
                    context.setResult(-1, intent);
                    cVar13 = this.fMC.fMy;
                    cVar13.getContext().finish();
                } else if (writeData2 != null && qVar != null && !TextUtils.isEmpty(qVar.yG())) {
                    writeData2.setVcodeMD5(qVar.getVcode_md5());
                    writeData2.setVcodeUrl(qVar.getVcode_pic_url());
                    writeData2.setVcodeExtra(qVar.yH());
                    cVar7 = this.fMC.fMy;
                    cVar7.getContext().setVisible(false);
                    if (com.baidu.tbadk.o.a.gt(qVar.yG())) {
                        MessageManager messageManager = MessageManager.getInstance();
                        cVar9 = this.fMC.fMy;
                        messageManager.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new NewVcodeActivityConfig(cVar9.getContext().getActivity(), 12006, writeData2, false, qVar.yG())));
                        return;
                    }
                    MessageManager messageManager2 = MessageManager.getInstance();
                    cVar8 = this.fMC.fMy;
                    messageManager2.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new VcodeActivityConfig(cVar8.getContext().getActivity(), writeData2, 12006)));
                } else {
                    if (postWriteCallBackData != null) {
                        cVar4 = this.fMC.fMy;
                        com.baidu.tieba.tbadkCore.writeModel.e.c(cVar4.getContext().getActivity(), postWriteCallBackData.getErrorString(), postWriteCallBackData.getPreMsg(), postWriteCallBackData.getColorMsg());
                        cVar5 = this.fMC.fMy;
                        BaseActivity context2 = cVar5.getContext();
                        cVar6 = this.fMC.fMy;
                        cVar6.getContext();
                        context2.setResult(0, null);
                    }
                    cVar3 = this.fMC.fMy;
                    cVar3.getContext().finish();
                }
            }
        }
    }
}
