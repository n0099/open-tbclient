package com.baidu.tieba.pb.pb.main;

import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.AntiData;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.coreExtra.data.WriteData;
import com.baidu.tieba.tbadkCore.writeModel.NewWriteModel;
import com.baidu.tieba.tbadkCore.writeModel.PostWriteCallBackData;
/* loaded from: classes.dex */
class aa implements NewWriteModel.d {
    final /* synthetic */ PbActivity ehy;

    /* JADX INFO: Access modifiers changed from: package-private */
    public aa(PbActivity pbActivity) {
        this.ehy = pbActivity;
    }

    @Override // com.baidu.tieba.tbadkCore.writeModel.NewWriteModel.d
    public void callback(boolean z, PostWriteCallBackData postWriteCallBackData, com.baidu.tbadk.coreExtra.data.q qVar, WriteData writeData, AntiData antiData) {
        fm fmVar;
        fm fmVar2;
        com.baidu.tbadk.editortools.pb.c cVar;
        fm fmVar3;
        fm fmVar4;
        PbModel pbModel;
        PbModel pbModel2;
        PbModel pbModel3;
        fm fmVar5;
        PbModel pbModel4;
        String userId;
        PbModel pbModel5;
        fm fmVar6;
        PbModel pbModel6;
        PbModel pbModel7;
        PbModel pbModel8;
        fm fmVar7;
        fm fmVar8;
        com.baidu.tbadk.editortools.pb.c cVar2;
        this.ehy.Zo();
        fmVar = this.ehy.egt;
        fmVar.iz(z);
        String str = "";
        int i = -1;
        if (postWriteCallBackData != null) {
            i = postWriteCallBackData.getErrorCode();
            str = postWriteCallBackData.getErrorString();
        }
        if (z) {
            fmVar2 = this.ehy.egt;
            fmVar2.auE();
            cVar = this.ehy.egG;
            if (cVar != null) {
                fmVar8 = this.ehy.egt;
                cVar2 = this.ehy.egG;
                fmVar8.gm(cVar2.CY());
            }
            fmVar3 = this.ehy.egt;
            fmVar3.aLi();
            fmVar4 = this.ehy.egt;
            fmVar4.gn(true);
            pbModel = this.ehy.efE;
            pbModel.aKg();
            this.ehy.a(antiData, postWriteCallBackData);
            if (writeData != null) {
                String floor = writeData.getFloor();
                if (writeData == null || writeData.getType() != 2) {
                    pbModel2 = this.ehy.efE;
                    if (pbModel2.getHostMode()) {
                        pbModel4 = this.ehy.efE;
                        com.baidu.tieba.pb.data.f pbData = pbModel4.getPbData();
                        if (pbData != null && pbData.aHG() != null && pbData.aHG().getAuthor() != null && (userId = pbData.aHG().getAuthor().getUserId()) != null && userId.equals(TbadkCoreApplication.getCurrentAccount())) {
                            pbModel5 = this.ehy.efE;
                            if (pbModel5.aJZ()) {
                                fmVar6 = this.ehy.egt;
                                fmVar6.aLD();
                            }
                        }
                    } else {
                        pbModel3 = this.ehy.efE;
                        if (pbModel3.aJZ()) {
                            fmVar5 = this.ehy.egt;
                            fmVar5.aLD();
                        }
                    }
                } else if (floor != null) {
                    pbModel8 = this.ehy.efE;
                    com.baidu.tieba.pb.data.f pbData2 = pbModel8.getPbData();
                    fmVar7 = this.ehy.egt;
                    fmVar7.l(pbData2);
                }
                pbModel6 = this.ehy.efE;
                if (pbModel6.aJW()) {
                    com.baidu.tbadk.core.util.as asVar = new com.baidu.tbadk.core.util.as("c10369");
                    pbModel7 = this.ehy.efE;
                    TiebaStatic.log(asVar.aa("tid", pbModel7.getThreadID()));
                }
            }
        } else if (qVar != null || i == 227001) {
        } else {
            this.ehy.a(i, antiData, str);
        }
    }
}
