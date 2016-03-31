package com.baidu.tieba.pb.pb.main;

import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.AntiData;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.coreExtra.data.WriteData;
import com.baidu.tieba.tbadkCore.writeModel.PostWriteCallBackData;
import com.baidu.tieba.tbadkCore.writeModel.a;
/* loaded from: classes.dex */
class ad implements a.d {
    final /* synthetic */ PbActivity dht;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ad(PbActivity pbActivity) {
        this.dht = pbActivity;
    }

    @Override // com.baidu.tieba.tbadkCore.writeModel.a.d
    public void callback(boolean z, PostWriteCallBackData postWriteCallBackData, com.baidu.tbadk.coreExtra.data.n nVar, WriteData writeData, AntiData antiData) {
        eu euVar;
        eu euVar2;
        com.baidu.tbadk.editortools.d.e eVar;
        eu euVar3;
        eu euVar4;
        df dfVar;
        df dfVar2;
        df dfVar3;
        eu euVar5;
        df dfVar4;
        String userId;
        df dfVar5;
        eu euVar6;
        df dfVar6;
        df dfVar7;
        df dfVar8;
        eu euVar7;
        eu euVar8;
        com.baidu.tbadk.editortools.d.e eVar2;
        this.dht.Qn();
        euVar = this.dht.dgF;
        euVar.gr(z);
        String str = "";
        int i = -1;
        if (postWriteCallBackData != null) {
            i = postWriteCallBackData.getErrorCode();
            str = postWriteCallBackData.getErrorString();
        }
        if (z) {
            euVar2 = this.dht.dgF;
            euVar2.amI();
            eVar = this.dht.dgP;
            if (eVar != null) {
                euVar8 = this.dht.dgF;
                eVar2 = this.dht.dgP;
                euVar8.eL(eVar2.DT());
            }
            euVar3 = this.dht.dgF;
            euVar3.ayj();
            euVar4 = this.dht.dgF;
            euVar4.eM(true);
            dfVar = this.dht.dfV;
            dfVar.axq();
            this.dht.a(antiData, postWriteCallBackData);
            if (writeData != null) {
                String floor = writeData.getFloor();
                if (writeData == null || writeData.getType() != 2) {
                    dfVar2 = this.dht.dfV;
                    if (dfVar2.getHostMode()) {
                        dfVar4 = this.dht.dfV;
                        com.baidu.tieba.pb.data.e pbData = dfVar4.getPbData();
                        if (pbData != null && pbData.avv() != null && pbData.avv().getAuthor() != null && (userId = pbData.avv().getAuthor().getUserId()) != null && userId.equals(TbadkCoreApplication.getCurrentAccount())) {
                            dfVar5 = this.dht.dfV;
                            if (dfVar5.axk()) {
                                euVar6 = this.dht.dgF;
                                euVar6.ayE();
                            }
                        }
                    } else {
                        dfVar3 = this.dht.dfV;
                        if (dfVar3.axk()) {
                            euVar5 = this.dht.dgF;
                            euVar5.ayE();
                        }
                    }
                } else if (floor != null) {
                    dfVar8 = this.dht.dfV;
                    com.baidu.tieba.pb.data.e pbData2 = dfVar8.getPbData();
                    euVar7 = this.dht.dgF;
                    euVar7.j(pbData2);
                }
                dfVar6 = this.dht.dfV;
                if (dfVar6.axg()) {
                    com.baidu.tbadk.core.util.aw awVar = new com.baidu.tbadk.core.util.aw("c10369");
                    dfVar7 = this.dht.dfV;
                    TiebaStatic.log(awVar.ac("tid", dfVar7.getThreadID()));
                }
            }
        } else if (nVar != null) {
        } else {
            this.dht.a(i, antiData, str);
        }
    }
}
