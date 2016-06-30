package com.baidu.tieba.pb.pb.main;

import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.AntiData;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.coreExtra.data.WriteData;
import com.baidu.tieba.tbadkCore.writeModel.PostWriteCallBackData;
import com.baidu.tieba.tbadkCore.writeModel.a;
/* loaded from: classes.dex */
class z implements a.d {
    final /* synthetic */ PbActivity dPF;

    /* JADX INFO: Access modifiers changed from: package-private */
    public z(PbActivity pbActivity) {
        this.dPF = pbActivity;
    }

    @Override // com.baidu.tieba.tbadkCore.writeModel.a.d
    public void callback(boolean z, PostWriteCallBackData postWriteCallBackData, com.baidu.tbadk.coreExtra.data.p pVar, WriteData writeData, AntiData antiData) {
        es esVar;
        es esVar2;
        com.baidu.tbadk.editortools.d.e eVar;
        es esVar3;
        es esVar4;
        dg dgVar;
        dg dgVar2;
        dg dgVar3;
        es esVar5;
        dg dgVar4;
        String userId;
        dg dgVar5;
        es esVar6;
        dg dgVar6;
        dg dgVar7;
        dg dgVar8;
        es esVar7;
        es esVar8;
        com.baidu.tbadk.editortools.d.e eVar2;
        this.dPF.UR();
        esVar = this.dPF.dOO;
        esVar.hN(z);
        String str = "";
        int i = -1;
        if (postWriteCallBackData != null) {
            i = postWriteCallBackData.getErrorCode();
            str = postWriteCallBackData.getErrorString();
        }
        if (z) {
            esVar2 = this.dPF.dOO;
            esVar2.avf();
            eVar = this.dPF.dOX;
            if (eVar != null) {
                esVar8 = this.dPF.dOO;
                eVar2 = this.dPF.dOX;
                esVar8.gb(eVar2.BW());
            }
            esVar3 = this.dPF.dOO;
            esVar3.aGS();
            esVar4 = this.dPF.dOO;
            esVar4.gc(true);
            dgVar = this.dPF.dOf;
            dgVar.aFY();
            this.dPF.a(antiData, postWriteCallBackData);
            if (writeData != null) {
                String floor = writeData.getFloor();
                if (writeData == null || writeData.getType() != 2) {
                    dgVar2 = this.dPF.dOf;
                    if (dgVar2.getHostMode()) {
                        dgVar4 = this.dPF.dOf;
                        com.baidu.tieba.pb.data.h pbData = dgVar4.getPbData();
                        if (pbData != null && pbData.aDO() != null && pbData.aDO().getAuthor() != null && (userId = pbData.aDO().getAuthor().getUserId()) != null && userId.equals(TbadkCoreApplication.getCurrentAccount())) {
                            dgVar5 = this.dPF.dOf;
                            if (dgVar5.aFR()) {
                                esVar6 = this.dPF.dOO;
                                esVar6.aHn();
                            }
                        }
                    } else {
                        dgVar3 = this.dPF.dOf;
                        if (dgVar3.aFR()) {
                            esVar5 = this.dPF.dOO;
                            esVar5.aHn();
                        }
                    }
                } else if (floor != null) {
                    dgVar8 = this.dPF.dOf;
                    com.baidu.tieba.pb.data.h pbData2 = dgVar8.getPbData();
                    esVar7 = this.dPF.dOO;
                    esVar7.j(pbData2);
                }
                dgVar6 = this.dPF.dOf;
                if (dgVar6.aFO()) {
                    com.baidu.tbadk.core.util.ay ayVar = new com.baidu.tbadk.core.util.ay("c10369");
                    dgVar7 = this.dPF.dOf;
                    TiebaStatic.log(ayVar.ab("tid", dgVar7.getThreadID()));
                }
            }
        } else if (pVar != null) {
        } else {
            this.dPF.a(i, antiData, str);
        }
    }
}
