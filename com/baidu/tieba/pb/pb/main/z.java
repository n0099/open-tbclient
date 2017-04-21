package com.baidu.tieba.pb.pb.main;

import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.AntiData;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.coreExtra.data.WriteData;
import com.baidu.tieba.tbadkCore.writeModel.NewWriteModel;
import com.baidu.tieba.tbadkCore.writeModel.PostWriteCallBackData;
/* loaded from: classes.dex */
class z implements NewWriteModel.d {
    final /* synthetic */ PbActivity emk;

    /* JADX INFO: Access modifiers changed from: package-private */
    public z(PbActivity pbActivity) {
        this.emk = pbActivity;
    }

    @Override // com.baidu.tieba.tbadkCore.writeModel.NewWriteModel.d
    public void callback(boolean z, PostWriteCallBackData postWriteCallBackData, com.baidu.tbadk.coreExtra.data.q qVar, WriteData writeData, AntiData antiData) {
        ey eyVar;
        ey eyVar2;
        com.baidu.tbadk.editortools.pb.c cVar;
        ey eyVar3;
        ey eyVar4;
        PbModel pbModel;
        PbModel pbModel2;
        PbModel pbModel3;
        ey eyVar5;
        PbModel pbModel4;
        String userId;
        PbModel pbModel5;
        ey eyVar6;
        PbModel pbModel6;
        PbModel pbModel7;
        PbModel pbModel8;
        ey eyVar7;
        ey eyVar8;
        com.baidu.tbadk.editortools.pb.c cVar2;
        this.emk.aaq();
        eyVar = this.emk.eli;
        eyVar.iU(z);
        String str = "";
        int i = -1;
        if (postWriteCallBackData != null) {
            i = postWriteCallBackData.getErrorCode();
            str = postWriteCallBackData.getErrorString();
        }
        if (z) {
            eyVar2 = this.emk.eli;
            eyVar2.axI();
            cVar = this.emk.elu;
            if (cVar != null) {
                eyVar8 = this.emk.eli;
                cVar2 = this.emk.elu;
                eyVar8.gL(cVar2.DU());
            }
            eyVar3 = this.emk.eli;
            eyVar3.aNR();
            eyVar4 = this.emk.eli;
            eyVar4.gM(true);
            pbModel = this.emk.ekv;
            pbModel.aMR();
            this.emk.a(antiData, postWriteCallBackData);
            if (writeData != null) {
                String floor = writeData.getFloor();
                if (writeData == null || writeData.getType() != 2) {
                    pbModel2 = this.emk.ekv;
                    if (pbModel2.getHostMode()) {
                        pbModel4 = this.emk.ekv;
                        com.baidu.tieba.pb.data.f pbData = pbModel4.getPbData();
                        if (pbData != null && pbData.aKy() != null && pbData.aKy().getAuthor() != null && (userId = pbData.aKy().getAuthor().getUserId()) != null && userId.equals(TbadkCoreApplication.getCurrentAccount())) {
                            pbModel5 = this.emk.ekv;
                            if (pbModel5.aMK()) {
                                eyVar6 = this.emk.eli;
                                eyVar6.aOm();
                            }
                        }
                    } else {
                        pbModel3 = this.emk.ekv;
                        if (pbModel3.aMK()) {
                            eyVar5 = this.emk.eli;
                            eyVar5.aOm();
                        }
                    }
                } else if (floor != null) {
                    pbModel8 = this.emk.ekv;
                    com.baidu.tieba.pb.data.f pbData2 = pbModel8.getPbData();
                    eyVar7 = this.emk.eli;
                    eyVar7.k(pbData2);
                }
                pbModel6 = this.emk.ekv;
                if (pbModel6.aMH()) {
                    com.baidu.tbadk.core.util.as asVar = new com.baidu.tbadk.core.util.as("c10369");
                    pbModel7 = this.emk.ekv;
                    TiebaStatic.log(asVar.aa("tid", pbModel7.getThreadID()));
                }
            }
        } else if (qVar != null || i == 227001) {
        } else {
            this.emk.a(i, antiData, str);
        }
    }
}
