package com.baidu.tieba.pb.pb.main;

import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.AntiData;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.coreExtra.data.WriteData;
import com.baidu.tieba.tbadkCore.writeModel.PostWriteCallBackData;
import com.baidu.tieba.tbadkCore.writeModel.b;
/* loaded from: classes.dex */
class aa implements b.d {
    final /* synthetic */ PbActivity eob;

    /* JADX INFO: Access modifiers changed from: package-private */
    public aa(PbActivity pbActivity) {
        this.eob = pbActivity;
    }

    @Override // com.baidu.tieba.tbadkCore.writeModel.b.d
    public void callback(boolean z, PostWriteCallBackData postWriteCallBackData, com.baidu.tbadk.coreExtra.data.s sVar, WriteData writeData, AntiData antiData) {
        ex exVar;
        ex exVar2;
        com.baidu.tbadk.editortools.d.e eVar;
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
        com.baidu.tbadk.editortools.d.e eVar2;
        this.eob.aaO();
        exVar = this.eob.enh;
        exVar.iu(z);
        String str = "";
        int i = -1;
        if (postWriteCallBackData != null) {
            i = postWriteCallBackData.getErrorCode();
            str = postWriteCallBackData.getErrorString();
        }
        if (z) {
            exVar2 = this.eob.enh;
            exVar2.aAE();
            eVar = this.eob.ens;
            if (eVar != null) {
                exVar8 = this.eob.enh;
                eVar2 = this.eob.ens;
                exVar8.gA(eVar2.Dr());
            }
            exVar3 = this.eob.enh;
            exVar3.aOW();
            exVar4 = this.eob.enh;
            exVar4.gB(true);
            dhVar = this.eob.emx;
            dhVar.aOa();
            this.eob.a(antiData, postWriteCallBackData);
            if (writeData != null) {
                String floor = writeData.getFloor();
                if (writeData == null || writeData.getType() != 2) {
                    dhVar2 = this.eob.emx;
                    if (dhVar2.getHostMode()) {
                        dhVar4 = this.eob.emx;
                        com.baidu.tieba.pb.data.h pbData = dhVar4.getPbData();
                        if (pbData != null && pbData.aLQ() != null && pbData.aLQ().getAuthor() != null && (userId = pbData.aLQ().getAuthor().getUserId()) != null && userId.equals(TbadkCoreApplication.getCurrentAccount())) {
                            dhVar5 = this.eob.emx;
                            if (dhVar5.aNT()) {
                                exVar6 = this.eob.enh;
                                exVar6.aPp();
                            }
                        }
                    } else {
                        dhVar3 = this.eob.emx;
                        if (dhVar3.aNT()) {
                            exVar5 = this.eob.enh;
                            exVar5.aPp();
                        }
                    }
                } else if (floor != null) {
                    dhVar8 = this.eob.emx;
                    com.baidu.tieba.pb.data.h pbData2 = dhVar8.getPbData();
                    exVar7 = this.eob.enh;
                    exVar7.j(pbData2);
                }
                dhVar6 = this.eob.emx;
                if (dhVar6.aNQ()) {
                    com.baidu.tbadk.core.util.ay ayVar = new com.baidu.tbadk.core.util.ay("c10369");
                    dhVar7 = this.eob.emx;
                    TiebaStatic.log(ayVar.ab("tid", dhVar7.getThreadID()));
                }
            }
        } else if (sVar != null || i == 227001) {
        } else {
            this.eob.a(i, antiData, str);
        }
    }
}
