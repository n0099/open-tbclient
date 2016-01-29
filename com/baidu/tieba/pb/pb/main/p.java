package com.baidu.tieba.pb.pb.main;

import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.AntiData;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.coreExtra.data.WriteData;
import com.baidu.tieba.tbadkCore.writeModel.PostWriteCallBackData;
import com.baidu.tieba.tbadkCore.writeModel.a;
/* loaded from: classes.dex */
class p implements a.d {
    final /* synthetic */ PbActivity cNq;

    /* JADX INFO: Access modifiers changed from: package-private */
    public p(PbActivity pbActivity) {
        this.cNq = pbActivity;
    }

    @Override // com.baidu.tieba.tbadkCore.writeModel.a.d
    public void a(boolean z, PostWriteCallBackData postWriteCallBackData, com.baidu.tbadk.coreExtra.data.n nVar, WriteData writeData, AntiData antiData) {
        dz dzVar;
        dz dzVar2;
        com.baidu.tbadk.editortools.d.e eVar;
        dz dzVar3;
        dz dzVar4;
        cm cmVar;
        cm cmVar2;
        cm cmVar3;
        dz dzVar5;
        cm cmVar4;
        String userId;
        cm cmVar5;
        dz dzVar6;
        cm cmVar6;
        cm cmVar7;
        cm cmVar8;
        dz dzVar7;
        dz dzVar8;
        com.baidu.tbadk.editortools.d.e eVar2;
        this.cNq.Oy();
        dzVar = this.cNq.cMK;
        dzVar.fH(z);
        String str = "";
        int i = -1;
        if (postWriteCallBackData != null) {
            i = postWriteCallBackData.getErrorCode();
            str = postWriteCallBackData.getErrorString();
        }
        if (z) {
            dzVar2 = this.cNq.cMK;
            dzVar2.ajp();
            eVar = this.cNq.cMU;
            if (eVar != null) {
                dzVar8 = this.cNq.cMK;
                eVar2 = this.cNq.cMU;
                dzVar8.ep(eVar2.Dk());
            }
            dzVar3 = this.cNq.cMK;
            dzVar3.aqS();
            dzVar4 = this.cNq.cMK;
            dzVar4.eq(true);
            cmVar = this.cNq.cMF;
            cmVar.aqb();
            this.cNq.a(antiData, postWriteCallBackData);
            if (writeData != null) {
                String floor = writeData.getFloor();
                if (writeData == null || writeData.getType() != 2) {
                    cmVar2 = this.cNq.cMF;
                    if (cmVar2.getHostMode()) {
                        cmVar4 = this.cNq.cMF;
                        com.baidu.tieba.pb.a.c pbData = cmVar4.getPbData();
                        if (pbData != null && pbData.aoF() != null && pbData.aoF().getAuthor() != null && (userId = pbData.aoF().getAuthor().getUserId()) != null && userId.equals(TbadkCoreApplication.getCurrentAccount())) {
                            cmVar5 = this.cNq.cMF;
                            if (cmVar5.apV()) {
                                dzVar6 = this.cNq.cMK;
                                dzVar6.arh();
                            }
                        }
                    } else {
                        cmVar3 = this.cNq.cMF;
                        if (cmVar3.apV()) {
                            dzVar5 = this.cNq.cMK;
                            dzVar5.arh();
                        }
                    }
                } else if (floor != null) {
                    cmVar8 = this.cNq.cMF;
                    com.baidu.tieba.pb.a.c pbData2 = cmVar8.getPbData();
                    dzVar7 = this.cNq.cMK;
                    dzVar7.j(pbData2);
                }
                cmVar6 = this.cNq.cMF;
                if (cmVar6.apR()) {
                    com.baidu.tbadk.core.util.au auVar = new com.baidu.tbadk.core.util.au("c10369");
                    cmVar7 = this.cNq.cMF;
                    TiebaStatic.log(auVar.aa("tid", cmVar7.getThreadID()));
                }
            }
        } else if (nVar != null) {
        } else {
            this.cNq.a(i, antiData, str);
        }
    }
}
