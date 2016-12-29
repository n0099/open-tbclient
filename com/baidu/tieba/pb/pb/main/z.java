package com.baidu.tieba.pb.pb.main;

import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.AntiData;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.coreExtra.data.WriteData;
import com.baidu.tieba.tbadkCore.writeModel.PostWriteCallBackData;
import com.baidu.tieba.tbadkCore.writeModel.b;
/* loaded from: classes.dex */
class z implements b.d {
    final /* synthetic */ PbActivity eah;

    /* JADX INFO: Access modifiers changed from: package-private */
    public z(PbActivity pbActivity) {
        this.eah = pbActivity;
    }

    @Override // com.baidu.tieba.tbadkCore.writeModel.b.d
    public void callback(boolean z, PostWriteCallBackData postWriteCallBackData, com.baidu.tbadk.coreExtra.data.q qVar, WriteData writeData, AntiData antiData) {
        er erVar;
        er erVar2;
        com.baidu.tbadk.editortools.e.e eVar;
        er erVar3;
        er erVar4;
        dc dcVar;
        dc dcVar2;
        dc dcVar3;
        er erVar5;
        dc dcVar4;
        String userId;
        dc dcVar5;
        er erVar6;
        dc dcVar6;
        dc dcVar7;
        dc dcVar8;
        er erVar7;
        er erVar8;
        com.baidu.tbadk.editortools.e.e eVar2;
        this.eah.WD();
        erVar = this.eah.dZk;
        erVar.iG(z);
        String str = "";
        int i = -1;
        if (postWriteCallBackData != null) {
            i = postWriteCallBackData.getErrorCode();
            str = postWriteCallBackData.getErrorString();
        }
        if (z) {
            erVar2 = this.eah.dZk;
            erVar2.awl();
            eVar = this.eah.dZw;
            if (eVar != null) {
                erVar8 = this.eah.dZk;
                eVar2 = this.eah.dZw;
                erVar8.gH(eVar2.Di());
            }
            erVar3 = this.eah.dZk;
            erVar3.aLA();
            erVar4 = this.eah.dZk;
            erVar4.gI(true);
            dcVar = this.eah.dYA;
            dcVar.aKy();
            this.eah.a(antiData, postWriteCallBackData);
            if (writeData != null) {
                String floor = writeData.getFloor();
                if (writeData == null || writeData.getType() != 2) {
                    dcVar2 = this.eah.dYA;
                    if (dcVar2.getHostMode()) {
                        dcVar4 = this.eah.dYA;
                        com.baidu.tieba.pb.data.f pbData = dcVar4.getPbData();
                        if (pbData != null && pbData.aIl() != null && pbData.aIl().getAuthor() != null && (userId = pbData.aIl().getAuthor().getUserId()) != null && userId.equals(TbadkCoreApplication.getCurrentAccount())) {
                            dcVar5 = this.eah.dYA;
                            if (dcVar5.aKr()) {
                                erVar6 = this.eah.dZk;
                                erVar6.aLU();
                            }
                        }
                    } else {
                        dcVar3 = this.eah.dYA;
                        if (dcVar3.aKr()) {
                            erVar5 = this.eah.dZk;
                            erVar5.aLU();
                        }
                    }
                } else if (floor != null) {
                    dcVar8 = this.eah.dYA;
                    com.baidu.tieba.pb.data.f pbData2 = dcVar8.getPbData();
                    erVar7 = this.eah.dZk;
                    erVar7.j(pbData2);
                }
                dcVar6 = this.eah.dYA;
                if (dcVar6.aKo()) {
                    com.baidu.tbadk.core.util.at atVar = new com.baidu.tbadk.core.util.at("c10369");
                    dcVar7 = this.eah.dYA;
                    TiebaStatic.log(atVar.ab("tid", dcVar7.getThreadID()));
                }
            }
        } else if (qVar != null || i == 227001) {
        } else {
            this.eah.a(i, antiData, str);
        }
    }
}
