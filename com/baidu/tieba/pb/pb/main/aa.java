package com.baidu.tieba.pb.pb.main;

import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.AntiData;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.coreExtra.data.WriteData;
import com.baidu.tieba.tbadkCore.writeModel.PostWriteCallBackData;
import com.baidu.tieba.tbadkCore.writeModel.b;
/* loaded from: classes.dex */
class aa implements b.d {
    final /* synthetic */ PbActivity eqa;

    /* JADX INFO: Access modifiers changed from: package-private */
    public aa(PbActivity pbActivity) {
        this.eqa = pbActivity;
    }

    @Override // com.baidu.tieba.tbadkCore.writeModel.b.d
    public void callback(boolean z, PostWriteCallBackData postWriteCallBackData, com.baidu.tbadk.coreExtra.data.s sVar, WriteData writeData, AntiData antiData) {
        ex exVar;
        ex exVar2;
        com.baidu.tbadk.editortools.e.e eVar;
        ex exVar3;
        ex exVar4;
        dh dhVar;
        dh dhVar2;
        dh dhVar3;
        ex exVar5;
        dh dhVar4;
        String userId;
        dh dhVar5;
        ex exVar6;
        dh dhVar6;
        dh dhVar7;
        dh dhVar8;
        ex exVar7;
        ex exVar8;
        com.baidu.tbadk.editortools.e.e eVar2;
        this.eqa.abb();
        exVar = this.eqa.epe;
        exVar.ix(z);
        String str = "";
        int i = -1;
        if (postWriteCallBackData != null) {
            i = postWriteCallBackData.getErrorCode();
            str = postWriteCallBackData.getErrorString();
        }
        if (z) {
            exVar2 = this.eqa.epe;
            exVar2.aBc();
            eVar = this.eqa.epp;
            if (eVar != null) {
                exVar8 = this.eqa.epe;
                eVar2 = this.eqa.epp;
                exVar8.gD(eVar2.Dr());
            }
            exVar3 = this.eqa.epe;
            exVar3.aPF();
            exVar4 = this.eqa.epe;
            exVar4.gE(true);
            dhVar = this.eqa.eov;
            dhVar.aOI();
            this.eqa.a(antiData, postWriteCallBackData);
            if (writeData != null) {
                String floor = writeData.getFloor();
                if (writeData == null || writeData.getType() != 2) {
                    dhVar2 = this.eqa.eov;
                    if (dhVar2.getHostMode()) {
                        dhVar4 = this.eqa.eov;
                        com.baidu.tieba.pb.data.h pbData = dhVar4.getPbData();
                        if (pbData != null && pbData.aMs() != null && pbData.aMs().getAuthor() != null && (userId = pbData.aMs().getAuthor().getUserId()) != null && userId.equals(TbadkCoreApplication.getCurrentAccount())) {
                            dhVar5 = this.eqa.eov;
                            if (dhVar5.aOB()) {
                                exVar6 = this.eqa.epe;
                                exVar6.aPY();
                            }
                        }
                    } else {
                        dhVar3 = this.eqa.eov;
                        if (dhVar3.aOB()) {
                            exVar5 = this.eqa.epe;
                            exVar5.aPY();
                        }
                    }
                } else if (floor != null) {
                    dhVar8 = this.eqa.eov;
                    com.baidu.tieba.pb.data.h pbData2 = dhVar8.getPbData();
                    exVar7 = this.eqa.epe;
                    exVar7.j(pbData2);
                }
                dhVar6 = this.eqa.eov;
                if (dhVar6.aOy()) {
                    com.baidu.tbadk.core.util.ax axVar = new com.baidu.tbadk.core.util.ax("c10369");
                    dhVar7 = this.eqa.eov;
                    TiebaStatic.log(axVar.ab("tid", dhVar7.getThreadID()));
                }
            }
        } else if (sVar != null || i == 227001) {
        } else {
            this.eqa.a(i, antiData, str);
        }
    }
}
