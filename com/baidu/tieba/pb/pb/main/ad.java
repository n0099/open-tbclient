package com.baidu.tieba.pb.pb.main;

import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.AntiData;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.coreExtra.data.WriteData;
import com.baidu.tieba.tbadkCore.writeModel.NewWriteModel;
import com.baidu.tieba.tbadkCore.writeModel.PostWriteCallBackData;
/* loaded from: classes.dex */
class ad implements NewWriteModel.d {
    final /* synthetic */ PbActivity enc;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ad(PbActivity pbActivity) {
        this.enc = pbActivity;
    }

    @Override // com.baidu.tieba.tbadkCore.writeModel.NewWriteModel.d
    public void callback(boolean z, PostWriteCallBackData postWriteCallBackData, com.baidu.tbadk.coreExtra.data.q qVar, WriteData writeData, AntiData antiData) {
        fx fxVar;
        fx fxVar2;
        com.baidu.tbadk.editortools.pb.c cVar;
        fx fxVar3;
        fx fxVar4;
        PbModel pbModel;
        PbModel pbModel2;
        PbModel pbModel3;
        fx fxVar5;
        PbModel pbModel4;
        String userId;
        PbModel pbModel5;
        fx fxVar6;
        PbModel pbModel6;
        PbModel pbModel7;
        PbModel pbModel8;
        fx fxVar7;
        fx fxVar8;
        com.baidu.tbadk.editortools.pb.c cVar2;
        this.enc.aas();
        fxVar = this.enc.elU;
        fxVar.iP(z);
        String str = "";
        int i = -1;
        if (postWriteCallBackData != null) {
            i = postWriteCallBackData.getErrorCode();
            str = postWriteCallBackData.getErrorString();
        }
        if (z) {
            fxVar2 = this.enc.elU;
            fxVar2.avy();
            cVar = this.enc.emh;
            if (cVar != null) {
                fxVar8 = this.enc.elU;
                cVar2 = this.enc.emh;
                fxVar8.gz(cVar2.CS());
            }
            fxVar3 = this.enc.elU;
            fxVar3.aMe();
            fxVar4 = this.enc.elU;
            fxVar4.gA(true);
            pbModel = this.enc.ele;
            pbModel.aLa();
            this.enc.a(antiData, postWriteCallBackData);
            if (writeData != null) {
                String floor = writeData.getFloor();
                if (writeData == null || writeData.getType() != 2) {
                    pbModel2 = this.enc.ele;
                    if (pbModel2.getHostMode()) {
                        pbModel4 = this.enc.ele;
                        com.baidu.tieba.pb.data.f pbData = pbModel4.getPbData();
                        if (pbData != null && pbData.aIB() != null && pbData.aIB().getAuthor() != null && (userId = pbData.aIB().getAuthor().getUserId()) != null && userId.equals(TbadkCoreApplication.getCurrentAccount())) {
                            pbModel5 = this.enc.ele;
                            if (pbModel5.aKT()) {
                                fxVar6 = this.enc.elU;
                                fxVar6.aMz();
                            }
                        }
                    } else {
                        pbModel3 = this.enc.ele;
                        if (pbModel3.aKT()) {
                            fxVar5 = this.enc.elU;
                            fxVar5.aMz();
                        }
                    }
                } else if (floor != null) {
                    pbModel8 = this.enc.ele;
                    com.baidu.tieba.pb.data.f pbData2 = pbModel8.getPbData();
                    fxVar7 = this.enc.elU;
                    fxVar7.l(pbData2);
                }
                pbModel6 = this.enc.ele;
                if (pbModel6.aKQ()) {
                    com.baidu.tbadk.core.util.as asVar = new com.baidu.tbadk.core.util.as("c10369");
                    pbModel7 = this.enc.ele;
                    TiebaStatic.log(asVar.Z("tid", pbModel7.getThreadID()));
                }
            }
        } else if (qVar != null || i == 227001) {
        } else {
            this.enc.a(i, antiData, str);
        }
    }
}
