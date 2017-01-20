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
import com.baidu.tieba.tbadkCore.writeModel.NewWriteModel;
import com.baidu.tieba.tbadkCore.writeModel.PostWriteCallBackData;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class b implements NewWriteModel.d {
    final /* synthetic */ a fGz;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(a aVar) {
        this.fGz = aVar;
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
        cVar = this.fGz.fGv;
        if (cVar != null) {
            newWriteModel = this.fGz.fGy;
            if (newWriteModel != null) {
                cVar2 = this.fGz.fGv;
                cVar2.showPostThreadLoadingView(false);
                if (writeData == null) {
                    newWriteModel2 = this.fGz.fGy;
                    writeData2 = newWriteModel2.getWriteData();
                } else {
                    writeData2 = writeData;
                }
                if (z) {
                    if (postWriteCallBackData == null) {
                        cVar14 = this.fGz.fGv;
                        Activity activity = cVar14.getContext().getActivity();
                        cVar15 = this.fGz.fGv;
                        com.baidu.tieba.tbadkCore.writeModel.e.c(activity, cVar15.getContext().getResources().getString(r.l.send_success), null, null);
                    } else {
                        cVar10 = this.fGz.fGv;
                        com.baidu.tieba.tbadkCore.writeModel.e.c(cVar10.getContext().getActivity(), postWriteCallBackData.getErrorString(), postWriteCallBackData.getPreMsg(), postWriteCallBackData.getColorMsg());
                    }
                    Intent intent = new Intent();
                    Bundle bundle = new Bundle();
                    bundle.putSerializable("post_write_callback_data", postWriteCallBackData);
                    intent.putExtras(bundle);
                    cVar11 = this.fGz.fGv;
                    BaseActivity context = cVar11.getContext();
                    cVar12 = this.fGz.fGv;
                    cVar12.getContext();
                    context.setResult(-1, intent);
                    cVar13 = this.fGz.fGv;
                    cVar13.getContext().finish();
                } else if (writeData2 != null && qVar != null && !TextUtils.isEmpty(qVar.xM())) {
                    writeData2.setVcodeMD5(qVar.getVcode_md5());
                    writeData2.setVcodeUrl(qVar.getVcode_pic_url());
                    writeData2.setVcodeExtra(qVar.xN());
                    cVar7 = this.fGz.fGv;
                    cVar7.getContext().setVisible(false);
                    if (com.baidu.tbadk.j.a.gy(qVar.xM())) {
                        MessageManager messageManager = MessageManager.getInstance();
                        cVar9 = this.fGz.fGv;
                        messageManager.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new NewVcodeActivityConfig(cVar9.getContext().getActivity(), 12006, writeData2, false, qVar.xM())));
                        return;
                    }
                    MessageManager messageManager2 = MessageManager.getInstance();
                    cVar8 = this.fGz.fGv;
                    messageManager2.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new VcodeActivityConfig(cVar8.getContext().getActivity(), writeData2, 12006)));
                } else {
                    if (postWriteCallBackData != null) {
                        cVar4 = this.fGz.fGv;
                        com.baidu.tieba.tbadkCore.writeModel.e.c(cVar4.getContext().getActivity(), postWriteCallBackData.getErrorString(), postWriteCallBackData.getPreMsg(), postWriteCallBackData.getColorMsg());
                        cVar5 = this.fGz.fGv;
                        BaseActivity context2 = cVar5.getContext();
                        cVar6 = this.fGz.fGv;
                        cVar6.getContext();
                        context2.setResult(0, null);
                    }
                    cVar3 = this.fGz.fGv;
                    cVar3.getContext().finish();
                }
            }
        }
    }
}
