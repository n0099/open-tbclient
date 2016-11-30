package com.baidu.tieba.pb.pb.main;

import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.AntiData;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.coreExtra.data.WriteData;
import com.baidu.tieba.tbadkCore.writeModel.PostWriteCallBackData;
import com.baidu.tieba.tbadkCore.writeModel.b;
/* loaded from: classes.dex */
class aa implements b.d {
    final /* synthetic */ PbActivity evL;

    /* JADX INFO: Access modifiers changed from: package-private */
    public aa(PbActivity pbActivity) {
        this.evL = pbActivity;
    }

    @Override // com.baidu.tieba.tbadkCore.writeModel.b.d
    public void callback(boolean z, PostWriteCallBackData postWriteCallBackData, com.baidu.tbadk.coreExtra.data.s sVar, WriteData writeData, AntiData antiData) {
        ey eyVar;
        ey eyVar2;
        com.baidu.tbadk.editortools.e.e eVar;
        ey eyVar3;
        ey eyVar4;
        dj djVar;
        dj djVar2;
        dj djVar3;
        ey eyVar5;
        dj djVar4;
        String userId;
        dj djVar5;
        ey eyVar6;
        dj djVar6;
        dj djVar7;
        dj djVar8;
        ey eyVar7;
        ey eyVar8;
        com.baidu.tbadk.editortools.e.e eVar2;
        this.evL.acp();
        eyVar = this.evL.euP;
        eyVar.iU(z);
        String str = "";
        int i = -1;
        if (postWriteCallBackData != null) {
            i = postWriteCallBackData.getErrorCode();
            str = postWriteCallBackData.getErrorString();
        }
        if (z) {
            eyVar2 = this.evL.euP;
            eyVar2.aCY();
            eVar = this.evL.evb;
            if (eVar != null) {
                eyVar8 = this.evL.euP;
                eVar2 = this.evL.evb;
                eyVar8.gX(eVar2.Dz());
            }
            eyVar3 = this.evL.euP;
            eyVar3.aRG();
            eyVar4 = this.evL.euP;
            eyVar4.gY(true);
            djVar = this.evL.euf;
            djVar.aQB();
            this.evL.a(antiData, postWriteCallBackData);
            if (writeData != null) {
                String floor = writeData.getFloor();
                if (writeData == null || writeData.getType() != 2) {
                    djVar2 = this.evL.euf;
                    if (djVar2.getHostMode()) {
                        djVar4 = this.evL.euf;
                        com.baidu.tieba.pb.data.h pbData = djVar4.getPbData();
                        if (pbData != null && pbData.aOl() != null && pbData.aOl().getAuthor() != null && (userId = pbData.aOl().getAuthor().getUserId()) != null && userId.equals(TbadkCoreApplication.getCurrentAccount())) {
                            djVar5 = this.evL.euf;
                            if (djVar5.aQu()) {
                                eyVar6 = this.evL.euP;
                                eyVar6.aSa();
                            }
                        }
                    } else {
                        djVar3 = this.evL.euf;
                        if (djVar3.aQu()) {
                            eyVar5 = this.evL.euP;
                            eyVar5.aSa();
                        }
                    }
                } else if (floor != null) {
                    djVar8 = this.evL.euf;
                    com.baidu.tieba.pb.data.h pbData2 = djVar8.getPbData();
                    eyVar7 = this.evL.euP;
                    eyVar7.j(pbData2);
                }
                djVar6 = this.evL.euf;
                if (djVar6.aQr()) {
                    com.baidu.tbadk.core.util.av avVar = new com.baidu.tbadk.core.util.av("c10369");
                    djVar7 = this.evL.euf;
                    TiebaStatic.log(avVar.ab("tid", djVar7.getThreadID()));
                }
            }
        } else if (sVar != null || i == 227001) {
        } else {
            this.evL.a(i, antiData, str);
        }
    }
}
