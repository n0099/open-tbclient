package com.baidu.tieba.pb.pb.main;

import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.AntiData;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.coreExtra.data.WriteData;
import com.baidu.tieba.tbadkCore.writeModel.PostWriteCallBackData;
import com.baidu.tieba.tbadkCore.writeModel.a;
/* loaded from: classes.dex */
class w implements a.d {
    final /* synthetic */ PbActivity djE;

    /* JADX INFO: Access modifiers changed from: package-private */
    public w(PbActivity pbActivity) {
        this.djE = pbActivity;
    }

    @Override // com.baidu.tieba.tbadkCore.writeModel.a.d
    public void callback(boolean z, PostWriteCallBackData postWriteCallBackData, com.baidu.tbadk.coreExtra.data.o oVar, WriteData writeData, AntiData antiData) {
        el elVar;
        el elVar2;
        com.baidu.tbadk.editortools.d.e eVar;
        el elVar3;
        el elVar4;
        cw cwVar;
        cw cwVar2;
        cw cwVar3;
        el elVar5;
        cw cwVar4;
        String userId;
        cw cwVar5;
        el elVar6;
        cw cwVar6;
        cw cwVar7;
        cw cwVar8;
        el elVar7;
        el elVar8;
        com.baidu.tbadk.editortools.d.e eVar2;
        this.djE.Pm();
        elVar = this.djE.diR;
        elVar.gU(z);
        String str = "";
        int i = -1;
        if (postWriteCallBackData != null) {
            i = postWriteCallBackData.getErrorCode();
            str = postWriteCallBackData.getErrorString();
        }
        if (z) {
            elVar2 = this.djE.diR;
            elVar2.amT();
            eVar = this.djE.dja;
            if (eVar != null) {
                elVar8 = this.djE.diR;
                eVar2 = this.djE.dja;
                elVar8.fn(eVar2.BN());
            }
            elVar3 = this.djE.diR;
            elVar3.ayJ();
            elVar4 = this.djE.diR;
            elVar4.fo(true);
            cwVar = this.djE.dih;
            cwVar.axQ();
            this.djE.a(antiData, postWriteCallBackData);
            if (writeData != null) {
                String floor = writeData.getFloor();
                if (writeData == null || writeData.getType() != 2) {
                    cwVar2 = this.djE.dih;
                    if (cwVar2.getHostMode()) {
                        cwVar4 = this.djE.dih;
                        com.baidu.tieba.pb.data.e pbData = cwVar4.getPbData();
                        if (pbData != null && pbData.avE() != null && pbData.avE().getAuthor() != null && (userId = pbData.avE().getAuthor().getUserId()) != null && userId.equals(TbadkCoreApplication.getCurrentAccount())) {
                            cwVar5 = this.djE.dih;
                            if (cwVar5.axK()) {
                                elVar6 = this.djE.diR;
                                elVar6.azd();
                            }
                        }
                    } else {
                        cwVar3 = this.djE.dih;
                        if (cwVar3.axK()) {
                            elVar5 = this.djE.diR;
                            elVar5.azd();
                        }
                    }
                } else if (floor != null) {
                    cwVar8 = this.djE.dih;
                    com.baidu.tieba.pb.data.e pbData2 = cwVar8.getPbData();
                    elVar7 = this.djE.diR;
                    elVar7.j(pbData2);
                }
                cwVar6 = this.djE.dih;
                if (cwVar6.axG()) {
                    com.baidu.tbadk.core.util.aw awVar = new com.baidu.tbadk.core.util.aw("c10369");
                    cwVar7 = this.djE.dih;
                    TiebaStatic.log(awVar.ac("tid", cwVar7.getThreadID()));
                }
            }
        } else if (oVar != null) {
        } else {
            this.djE.a(i, antiData, str);
        }
    }
}
