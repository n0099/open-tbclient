package com.baidu.tieba.pb.pb.main;

import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.AntiData;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.coreExtra.data.WriteData;
import com.baidu.tieba.tbadkCore.writeModel.NewWriteModel;
import com.baidu.tieba.tbadkCore.writeModel.PostWriteCallBackData;
/* loaded from: classes.dex */
class z implements NewWriteModel.d {
    final /* synthetic */ PbActivity eiV;

    /* JADX INFO: Access modifiers changed from: package-private */
    public z(PbActivity pbActivity) {
        this.eiV = pbActivity;
    }

    @Override // com.baidu.tieba.tbadkCore.writeModel.NewWriteModel.d
    public void callback(boolean z, PostWriteCallBackData postWriteCallBackData, com.baidu.tbadk.coreExtra.data.q qVar, WriteData writeData, AntiData antiData) {
        ez ezVar;
        ez ezVar2;
        com.baidu.tbadk.editortools.pb.c cVar;
        ez ezVar3;
        ez ezVar4;
        PbModel pbModel;
        PbModel pbModel2;
        PbModel pbModel3;
        ez ezVar5;
        PbModel pbModel4;
        String userId;
        PbModel pbModel5;
        ez ezVar6;
        PbModel pbModel6;
        PbModel pbModel7;
        PbModel pbModel8;
        ez ezVar7;
        ez ezVar8;
        com.baidu.tbadk.editortools.pb.c cVar2;
        this.eiV.XU();
        ezVar = this.eiV.ehV;
        ezVar.iQ(z);
        String str = "";
        int i = -1;
        if (postWriteCallBackData != null) {
            i = postWriteCallBackData.getErrorCode();
            str = postWriteCallBackData.getErrorString();
        }
        if (z) {
            ezVar2 = this.eiV.ehV;
            ezVar2.axs();
            cVar = this.eiV.eih;
            if (cVar != null) {
                ezVar8 = this.eiV.ehV;
                cVar2 = this.eiV.eih;
                ezVar8.gK(cVar2.Dd());
            }
            ezVar3 = this.eiV.ehV;
            ezVar3.aNo();
            ezVar4 = this.eiV.ehV;
            ezVar4.gL(true);
            pbModel = this.eiV.ehh;
            pbModel.aMl();
            this.eiV.a(antiData, postWriteCallBackData);
            if (writeData != null) {
                String floor = writeData.getFloor();
                if (writeData == null || writeData.getType() != 2) {
                    pbModel2 = this.eiV.ehh;
                    if (pbModel2.getHostMode()) {
                        pbModel4 = this.eiV.ehh;
                        com.baidu.tieba.pb.data.f pbData = pbModel4.getPbData();
                        if (pbData != null && pbData.aJZ() != null && pbData.aJZ().getAuthor() != null && (userId = pbData.aJZ().getAuthor().getUserId()) != null && userId.equals(TbadkCoreApplication.getCurrentAccount())) {
                            pbModel5 = this.eiV.ehh;
                            if (pbModel5.aMe()) {
                                ezVar6 = this.eiV.ehV;
                                ezVar6.aNJ();
                            }
                        }
                    } else {
                        pbModel3 = this.eiV.ehh;
                        if (pbModel3.aMe()) {
                            ezVar5 = this.eiV.ehV;
                            ezVar5.aNJ();
                        }
                    }
                } else if (floor != null) {
                    pbModel8 = this.eiV.ehh;
                    com.baidu.tieba.pb.data.f pbData2 = pbModel8.getPbData();
                    ezVar7 = this.eiV.ehV;
                    ezVar7.j(pbData2);
                }
                pbModel6 = this.eiV.ehh;
                if (pbModel6.aMb()) {
                    com.baidu.tbadk.core.util.ar arVar = new com.baidu.tbadk.core.util.ar("c10369");
                    pbModel7 = this.eiV.ehh;
                    TiebaStatic.log(arVar.ab("tid", pbModel7.getThreadID()));
                }
            }
        } else if (qVar != null || i == 227001) {
        } else {
            this.eiV.a(i, antiData, str);
        }
    }
}
