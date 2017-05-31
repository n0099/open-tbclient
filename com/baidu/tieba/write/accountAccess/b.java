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
    final /* synthetic */ a fTs;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(a aVar) {
        this.fTs = aVar;
    }

    @Override // com.baidu.tieba.tbadkCore.writeModel.NewWriteModel.d
    public void callback(boolean z, PostWriteCallBackData postWriteCallBackData, q qVar, WriteData writeData, AntiData antiData) {
        c cVar;
        NewWriteModel newWriteModel;
        NewWriteModel newWriteModel2;
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
        NewWriteModel newWriteModel3;
        cVar = this.fTs.fTo;
        if (cVar != null) {
            newWriteModel = this.fTs.fTr;
            if (newWriteModel != null) {
                newWriteModel2 = this.fTs.fTr;
                if (newWriteModel2.getWriteData() != null) {
                    cVar2 = this.fTs.fTo;
                    cVar2.showPostThreadLoadingView(false);
                    if (writeData == null) {
                        newWriteModel3 = this.fTs.fTr;
                        writeData2 = newWriteModel3.getWriteData();
                    } else {
                        writeData2 = writeData;
                    }
                    if (z) {
                        if (writeData2.getType() != 0 || writeData2.isUserFeedback()) {
                            if (postWriteCallBackData == null) {
                                cVar11 = this.fTs.fTo;
                                Activity activity = cVar11.getContext().getActivity();
                                cVar12 = this.fTs.fTo;
                                com.baidu.tieba.tbadkCore.writeModel.e.c(activity, cVar12.getContext().getResources().getString(w.l.send_success), null, null);
                            } else {
                                cVar10 = this.fTs.fTo;
                                com.baidu.tieba.tbadkCore.writeModel.e.c(cVar10.getContext().getActivity(), postWriteCallBackData.getErrorString(), postWriteCallBackData.getPreMsg(), postWriteCallBackData.getColorMsg());
                            }
                        }
                        Intent intent = new Intent();
                        Bundle bundle = new Bundle();
                        bundle.putSerializable("post_write_callback_data", postWriteCallBackData);
                        intent.putExtras(bundle);
                        cVar13 = this.fTs.fTo;
                        BaseActivity context = cVar13.getContext();
                        cVar14 = this.fTs.fTo;
                        cVar14.getContext();
                        context.setResult(-1, intent);
                        cVar15 = this.fTs.fTo;
                        cVar15.getContext().finish();
                    } else if (writeData2 != null && qVar != null && !TextUtils.isEmpty(qVar.xN())) {
                        writeData2.setVcodeMD5(qVar.getVcode_md5());
                        writeData2.setVcodeUrl(qVar.getVcode_pic_url());
                        writeData2.setVcodeExtra(qVar.xO());
                        cVar7 = this.fTs.fTo;
                        cVar7.getContext().setVisible(false);
                        if (com.baidu.tbadk.o.a.gq(qVar.xN())) {
                            MessageManager messageManager = MessageManager.getInstance();
                            cVar9 = this.fTs.fTo;
                            messageManager.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new NewVcodeActivityConfig(cVar9.getContext().getActivity(), 12006, writeData2, false, qVar.xN())));
                            return;
                        }
                        MessageManager messageManager2 = MessageManager.getInstance();
                        cVar8 = this.fTs.fTo;
                        messageManager2.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new VcodeActivityConfig(cVar8.getContext().getActivity(), writeData2, 12006)));
                    } else {
                        if (postWriteCallBackData != null) {
                            cVar4 = this.fTs.fTo;
                            com.baidu.tieba.tbadkCore.writeModel.e.c(cVar4.getContext().getActivity(), postWriteCallBackData.getErrorString(), postWriteCallBackData.getPreMsg(), postWriteCallBackData.getColorMsg());
                            cVar5 = this.fTs.fTo;
                            BaseActivity context2 = cVar5.getContext();
                            cVar6 = this.fTs.fTo;
                            cVar6.getContext();
                            context2.setResult(0, null);
                        }
                        cVar3 = this.fTs.fTo;
                        cVar3.getContext().finish();
                    }
                }
            }
        }
    }
}
