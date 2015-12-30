package com.baidu.tieba.pb.pb.main;

import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.AntiData;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.coreExtra.data.WriteData;
import com.baidu.tieba.tbadkCore.writeModel.PostWriteCallBackData;
import com.baidu.tieba.tbadkCore.writeModel.a;
/* loaded from: classes.dex */
class m implements a.d {
    final /* synthetic */ PbActivity cFS;

    /* JADX INFO: Access modifiers changed from: package-private */
    public m(PbActivity pbActivity) {
        this.cFS = pbActivity;
    }

    @Override // com.baidu.tieba.tbadkCore.writeModel.a.d
    public void a(boolean z, PostWriteCallBackData postWriteCallBackData, com.baidu.tbadk.coreExtra.data.n nVar, WriteData writeData, AntiData antiData) {
        dk dkVar;
        dk dkVar2;
        com.baidu.tbadk.editortools.d.e eVar;
        dk dkVar3;
        dk dkVar4;
        cf cfVar;
        cf cfVar2;
        cf cfVar3;
        dk dkVar5;
        cf cfVar4;
        String userId;
        cf cfVar5;
        dk dkVar6;
        cf cfVar6;
        cf cfVar7;
        cf cfVar8;
        dk dkVar7;
        dk dkVar8;
        com.baidu.tbadk.editortools.d.e eVar2;
        this.cFS.stopVoice();
        dkVar = this.cFS.cFq;
        dkVar.fq(z);
        String str = "";
        int i = -1;
        if (postWriteCallBackData != null) {
            i = postWriteCallBackData.getErrorCode();
            str = postWriteCallBackData.getErrorString();
        }
        if (z) {
            dkVar2 = this.cFS.cFq;
            dkVar2.ana();
            eVar = this.cFS.cFx;
            if (eVar != null) {
                dkVar8 = this.cFS.cFq;
                eVar2 = this.cFS.cFx;
                dkVar8.ft(eVar2.BU());
            }
            dkVar3 = this.cFS.cFq;
            dkVar3.amy();
            dkVar4 = this.cFS.cFq;
            dkVar4.fv(true);
            cfVar = this.cFS.cFl;
            cfVar.alY();
            this.cFS.a(antiData, postWriteCallBackData);
            if (writeData != null) {
                String floor = writeData.getFloor();
                if (writeData == null || writeData.getType() != 2) {
                    cfVar2 = this.cFS.cFl;
                    if (cfVar2.getHostMode()) {
                        cfVar4 = this.cFS.cFl;
                        com.baidu.tieba.pb.a.c pbData = cfVar4.getPbData();
                        if (pbData != null && pbData.akH() != null && pbData.akH().getAuthor() != null && (userId = pbData.akH().getAuthor().getUserId()) != null && userId.equals(TbadkCoreApplication.getCurrentAccount())) {
                            cfVar5 = this.cFS.cFl;
                            if (cfVar5.alS()) {
                                dkVar6 = this.cFS.cFq;
                                dkVar6.amJ();
                            }
                        }
                    } else {
                        cfVar3 = this.cFS.cFl;
                        if (cfVar3.alS()) {
                            dkVar5 = this.cFS.cFq;
                            dkVar5.amJ();
                        }
                    }
                } else if (floor != null) {
                    cfVar8 = this.cFS.cFl;
                    com.baidu.tieba.pb.a.c pbData2 = cfVar8.getPbData();
                    dkVar7 = this.cFS.cFq;
                    dkVar7.i(pbData2);
                }
                cfVar6 = this.cFS.cFl;
                if (cfVar6.alO()) {
                    com.baidu.tbadk.core.util.av avVar = new com.baidu.tbadk.core.util.av("c10369");
                    cfVar7 = this.cFS.cFl;
                    TiebaStatic.log(avVar.aa("tid", cfVar7.getThreadID()));
                }
            }
        } else if (nVar != null) {
        } else {
            this.cFS.a(i, antiData, str);
        }
    }
}
