package com.baidu.tieba.pb.pb.main;

import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.AntiData;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.coreExtra.data.WriteData;
import com.baidu.tieba.tbadkCore.writeModel.NewWriteModel;
import com.baidu.tieba.tbadkCore.writeModel.PostWriteCallBackData;
/* loaded from: classes.dex */
class z implements NewWriteModel.d {
    final /* synthetic */ PbActivity ejU;

    /* JADX INFO: Access modifiers changed from: package-private */
    public z(PbActivity pbActivity) {
        this.ejU = pbActivity;
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
        this.ejU.Zp();
        eyVar = this.ejU.eiS;
        eyVar.iK(z);
        String str = "";
        int i = -1;
        if (postWriteCallBackData != null) {
            i = postWriteCallBackData.getErrorCode();
            str = postWriteCallBackData.getErrorString();
        }
        if (z) {
            eyVar2 = this.ejU.eiS;
            eyVar2.awH();
            cVar = this.ejU.eje;
            if (cVar != null) {
                eyVar8 = this.ejU.eiS;
                cVar2 = this.ejU.eje;
                eyVar8.gB(cVar2.DU());
            }
            eyVar3 = this.ejU.eiS;
            eyVar3.aMQ();
            eyVar4 = this.ejU.eiS;
            eyVar4.gC(true);
            pbModel = this.ejU.eif;
            pbModel.aLQ();
            this.ejU.a(antiData, postWriteCallBackData);
            if (writeData != null) {
                String floor = writeData.getFloor();
                if (writeData == null || writeData.getType() != 2) {
                    pbModel2 = this.ejU.eif;
                    if (pbModel2.getHostMode()) {
                        pbModel4 = this.ejU.eif;
                        com.baidu.tieba.pb.data.f pbData = pbModel4.getPbData();
                        if (pbData != null && pbData.aJx() != null && pbData.aJx().getAuthor() != null && (userId = pbData.aJx().getAuthor().getUserId()) != null && userId.equals(TbadkCoreApplication.getCurrentAccount())) {
                            pbModel5 = this.ejU.eif;
                            if (pbModel5.aLJ()) {
                                eyVar6 = this.ejU.eiS;
                                eyVar6.aNl();
                            }
                        }
                    } else {
                        pbModel3 = this.ejU.eif;
                        if (pbModel3.aLJ()) {
                            eyVar5 = this.ejU.eiS;
                            eyVar5.aNl();
                        }
                    }
                } else if (floor != null) {
                    pbModel8 = this.ejU.eif;
                    com.baidu.tieba.pb.data.f pbData2 = pbModel8.getPbData();
                    eyVar7 = this.ejU.eiS;
                    eyVar7.k(pbData2);
                }
                pbModel6 = this.ejU.eif;
                if (pbModel6.aLG()) {
                    com.baidu.tbadk.core.util.as asVar = new com.baidu.tbadk.core.util.as("c10369");
                    pbModel7 = this.ejU.eif;
                    TiebaStatic.log(asVar.aa("tid", pbModel7.getThreadID()));
                }
            }
        } else if (qVar != null || i == 227001) {
        } else {
            this.ejU.a(i, antiData, str);
        }
    }
}
