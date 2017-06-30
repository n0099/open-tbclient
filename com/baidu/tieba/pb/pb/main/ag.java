package com.baidu.tieba.pb.pb.main;

import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.AntiData;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.coreExtra.data.WriteData;
import com.baidu.tieba.tbadkCore.writeModel.NewWriteModel;
import com.baidu.tieba.tbadkCore.writeModel.PostWriteCallBackData;
/* loaded from: classes.dex */
class ag implements NewWriteModel.d {
    final /* synthetic */ PbActivity ewh;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ag(PbActivity pbActivity) {
        this.ewh = pbActivity;
    }

    @Override // com.baidu.tieba.tbadkCore.writeModel.NewWriteModel.d
    public void callback(boolean z, PostWriteCallBackData postWriteCallBackData, com.baidu.tbadk.coreExtra.data.q qVar, WriteData writeData, AntiData antiData) {
        gg ggVar;
        gg ggVar2;
        com.baidu.tbadk.editortools.pb.c cVar;
        gg ggVar3;
        gg ggVar4;
        PbModel pbModel;
        PbModel pbModel2;
        PbModel pbModel3;
        gg ggVar5;
        PbModel pbModel4;
        String userId;
        PbModel pbModel5;
        gg ggVar6;
        PbModel pbModel6;
        PbModel pbModel7;
        PbModel pbModel8;
        gg ggVar7;
        gg ggVar8;
        com.baidu.tbadk.editortools.pb.c cVar2;
        this.ewh.aei();
        ggVar = this.ewh.euU;
        ggVar.jl(z);
        String str = "";
        int i = -1;
        if (postWriteCallBackData != null) {
            i = postWriteCallBackData.getErrorCode();
            str = postWriteCallBackData.getErrorString();
        }
        if (z) {
            ggVar2 = this.ewh.euU;
            ggVar2.azw();
            cVar = this.ewh.evh;
            if (cVar != null) {
                ggVar8 = this.ewh.euU;
                cVar2 = this.ewh.evh;
                ggVar8.gT(cVar2.Dm());
            }
            ggVar3 = this.ewh.euU;
            ggVar3.aQc();
            ggVar4 = this.ewh.euU;
            ggVar4.gU(true);
            pbModel = this.ewh.eue;
            pbModel.aOX();
            this.ewh.a(antiData, postWriteCallBackData);
            if (writeData != null) {
                String floor = writeData.getFloor();
                if (writeData == null || writeData.getType() != 2) {
                    pbModel2 = this.ewh.eue;
                    if (pbModel2.getHostMode()) {
                        pbModel4 = this.ewh.eue;
                        com.baidu.tieba.pb.data.f pbData = pbModel4.getPbData();
                        if (pbData != null && pbData.aMv() != null && pbData.aMv().getAuthor() != null && (userId = pbData.aMv().getAuthor().getUserId()) != null && userId.equals(TbadkCoreApplication.getCurrentAccount())) {
                            pbModel5 = this.ewh.eue;
                            if (pbModel5.aOQ()) {
                                ggVar6 = this.ewh.euU;
                                ggVar6.aQx();
                            }
                        }
                    } else {
                        pbModel3 = this.ewh.eue;
                        if (pbModel3.aOQ()) {
                            ggVar5 = this.ewh.euU;
                            ggVar5.aQx();
                        }
                    }
                } else if (floor != null) {
                    pbModel8 = this.ewh.eue;
                    com.baidu.tieba.pb.data.f pbData2 = pbModel8.getPbData();
                    ggVar7 = this.ewh.euU;
                    ggVar7.l(pbData2);
                }
                pbModel6 = this.ewh.eue;
                if (pbModel6.aON()) {
                    com.baidu.tbadk.core.util.au auVar = new com.baidu.tbadk.core.util.au("c10369");
                    pbModel7 = this.ewh.eue;
                    TiebaStatic.log(auVar.Z("tid", pbModel7.getThreadID()));
                }
            }
        } else if (qVar != null || i == 227001) {
        } else {
            this.ewh.a(i, antiData, str);
        }
    }
}
