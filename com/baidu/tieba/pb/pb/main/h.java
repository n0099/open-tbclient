package com.baidu.tieba.pb.pb.main;

import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.AntiData;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.coreExtra.data.WriteData;
import com.baidu.tieba.tbadkCore.writeModel.PostWriteCallBackData;
import com.baidu.tieba.tbadkCore.writeModel.a;
/* loaded from: classes.dex */
class h implements a.d {
    final /* synthetic */ PbActivity ciK;

    /* JADX INFO: Access modifiers changed from: package-private */
    public h(PbActivity pbActivity) {
        this.ciK = pbActivity;
    }

    @Override // com.baidu.tieba.tbadkCore.writeModel.a.d
    public void a(boolean z, PostWriteCallBackData postWriteCallBackData, com.baidu.tbadk.coreExtra.data.l lVar, WriteData writeData, AntiData antiData) {
        cc ccVar;
        cc ccVar2;
        com.baidu.tbadk.editortools.c.d dVar;
        cc ccVar3;
        cc ccVar4;
        bl blVar;
        bl blVar2;
        bl blVar3;
        cc ccVar5;
        bl blVar4;
        String userId;
        bl blVar5;
        cc ccVar6;
        bl blVar6;
        bl blVar7;
        bl blVar8;
        cc ccVar7;
        cc ccVar8;
        com.baidu.tbadk.editortools.c.d dVar2;
        this.ciK.stopVoice();
        ccVar = this.ciK.cim;
        ccVar.eK(z);
        String str = "";
        int i = -1;
        if (postWriteCallBackData != null) {
            i = postWriteCallBackData.getErrorCode();
            str = postWriteCallBackData.getErrorString();
        }
        if (z) {
            ccVar2 = this.ciK.cim;
            ccVar2.agI();
            dVar = this.ciK.ciu;
            if (dVar != null) {
                ccVar8 = this.ciK.cim;
                dVar2 = this.ciK.ciu;
                ccVar8.eN(dVar2.Bo());
            }
            ccVar3 = this.ciK.cim;
            ccVar3.agj();
            ccVar4 = this.ciK.cim;
            ccVar4.eP(true);
            blVar = this.ciK.cih;
            blVar.afS();
            this.ciK.a(antiData, postWriteCallBackData);
            if (writeData != null) {
                String floor = writeData.getFloor();
                if (writeData == null || writeData.getType() != 2) {
                    blVar2 = this.ciK.cih;
                    if (blVar2.getHostMode()) {
                        blVar4 = this.ciK.cih;
                        com.baidu.tieba.pb.a.b pbData = blVar4.getPbData();
                        if (pbData != null && pbData.aeK() != null && pbData.aeK().getAuthor() != null && (userId = pbData.aeK().getAuthor().getUserId()) != null && userId.equals(TbadkCoreApplication.getCurrentAccount())) {
                            blVar5 = this.ciK.cih;
                            if (blVar5.afN()) {
                                ccVar6 = this.ciK.cim;
                                ccVar6.agt();
                            }
                        }
                    } else {
                        blVar3 = this.ciK.cih;
                        if (blVar3.afN()) {
                            ccVar5 = this.ciK.cim;
                            ccVar5.agt();
                        }
                    }
                } else if (floor != null) {
                    blVar8 = this.ciK.cih;
                    com.baidu.tieba.pb.a.b pbData2 = blVar8.getPbData();
                    ccVar7 = this.ciK.cim;
                    ccVar7.h(pbData2);
                }
                blVar6 = this.ciK.cih;
                if (blVar6.afJ()) {
                    com.baidu.tbadk.core.util.aq aqVar = new com.baidu.tbadk.core.util.aq("c10369");
                    blVar7 = this.ciK.cih;
                    TiebaStatic.log(aqVar.ae("tid", blVar7.getThreadID()));
                }
            }
        } else if (lVar != null) {
        } else {
            this.ciK.a(i, antiData, str);
        }
    }
}
