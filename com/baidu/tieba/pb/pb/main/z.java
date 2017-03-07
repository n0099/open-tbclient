package com.baidu.tieba.pb.pb.main;

import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.AntiData;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.coreExtra.data.WriteData;
import com.baidu.tieba.tbadkCore.writeModel.NewWriteModel;
import com.baidu.tieba.tbadkCore.writeModel.PostWriteCallBackData;
/* loaded from: classes.dex */
class z implements NewWriteModel.d {
    final /* synthetic */ PbActivity elO;

    /* JADX INFO: Access modifiers changed from: package-private */
    public z(PbActivity pbActivity) {
        this.elO = pbActivity;
    }

    @Override // com.baidu.tieba.tbadkCore.writeModel.NewWriteModel.d
    public void callback(boolean z, PostWriteCallBackData postWriteCallBackData, com.baidu.tbadk.coreExtra.data.q qVar, WriteData writeData, AntiData antiData) {
        fa faVar;
        fa faVar2;
        com.baidu.tbadk.editortools.pb.c cVar;
        fa faVar3;
        fa faVar4;
        PbModel pbModel;
        PbModel pbModel2;
        PbModel pbModel3;
        fa faVar5;
        PbModel pbModel4;
        String userId;
        PbModel pbModel5;
        fa faVar6;
        PbModel pbModel6;
        PbModel pbModel7;
        PbModel pbModel8;
        fa faVar7;
        fa faVar8;
        com.baidu.tbadk.editortools.pb.c cVar2;
        this.elO.YT();
        faVar = this.elO.ekM;
        faVar.iL(z);
        String str = "";
        int i = -1;
        if (postWriteCallBackData != null) {
            i = postWriteCallBackData.getErrorCode();
            str = postWriteCallBackData.getErrorString();
        }
        if (z) {
            faVar2 = this.elO.ekM;
            faVar2.awO();
            cVar = this.elO.ekY;
            if (cVar != null) {
                faVar8 = this.elO.ekM;
                cVar2 = this.elO.ekY;
                faVar8.gB(cVar2.Dw());
            }
            faVar3 = this.elO.ekM;
            faVar3.aMH();
            faVar4 = this.elO.ekM;
            faVar4.gC(true);
            pbModel = this.elO.ejZ;
            pbModel.aLH();
            this.elO.a(antiData, postWriteCallBackData);
            if (writeData != null) {
                String floor = writeData.getFloor();
                if (writeData == null || writeData.getType() != 2) {
                    pbModel2 = this.elO.ejZ;
                    if (pbModel2.getHostMode()) {
                        pbModel4 = this.elO.ejZ;
                        com.baidu.tieba.pb.data.f pbData = pbModel4.getPbData();
                        if (pbData != null && pbData.aJq() != null && pbData.aJq().getAuthor() != null && (userId = pbData.aJq().getAuthor().getUserId()) != null && userId.equals(TbadkCoreApplication.getCurrentAccount())) {
                            pbModel5 = this.elO.ejZ;
                            if (pbModel5.aLA()) {
                                faVar6 = this.elO.ekM;
                                faVar6.aNc();
                            }
                        }
                    } else {
                        pbModel3 = this.elO.ejZ;
                        if (pbModel3.aLA()) {
                            faVar5 = this.elO.ekM;
                            faVar5.aNc();
                        }
                    }
                } else if (floor != null) {
                    pbModel8 = this.elO.ejZ;
                    com.baidu.tieba.pb.data.f pbData2 = pbModel8.getPbData();
                    faVar7 = this.elO.ekM;
                    faVar7.k(pbData2);
                }
                pbModel6 = this.elO.ejZ;
                if (pbModel6.aLx()) {
                    com.baidu.tbadk.core.util.as asVar = new com.baidu.tbadk.core.util.as("c10369");
                    pbModel7 = this.elO.ejZ;
                    TiebaStatic.log(asVar.Z("tid", pbModel7.getThreadID()));
                }
            }
        } else if (qVar != null || i == 227001) {
        } else {
            this.elO.a(i, antiData, str);
        }
    }
}
