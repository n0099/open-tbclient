package com.baidu.tieba.pb.pb.main;

import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.AntiData;
import com.baidu.tbadk.coreExtra.data.WriteData;
import com.baidu.tieba.tbadkCore.writeModel.PostWriteCallBackData;
import com.baidu.tieba.tbadkCore.writeModel.a;
/* loaded from: classes.dex */
class h implements a.d {
    final /* synthetic */ PbActivity ccj;

    /* JADX INFO: Access modifiers changed from: package-private */
    public h(PbActivity pbActivity) {
        this.ccj = pbActivity;
    }

    @Override // com.baidu.tieba.tbadkCore.writeModel.a.d
    public void a(boolean z, PostWriteCallBackData postWriteCallBackData, com.baidu.tbadk.coreExtra.data.l lVar, WriteData writeData, AntiData antiData) {
        cb cbVar;
        cb cbVar2;
        com.baidu.tbadk.editortools.c.d dVar;
        cb cbVar3;
        cb cbVar4;
        bk bkVar;
        bk bkVar2;
        bk bkVar3;
        cb cbVar5;
        bk bkVar4;
        String userId;
        bk bkVar5;
        cb cbVar6;
        bk bkVar6;
        cb cbVar7;
        cb cbVar8;
        com.baidu.tbadk.editortools.c.d dVar2;
        this.ccj.stopVoice();
        cbVar = this.ccj.cbL;
        cbVar.eF(z);
        String str = "";
        int i = -1;
        if (postWriteCallBackData != null) {
            i = postWriteCallBackData.getErrorCode();
            str = postWriteCallBackData.getErrorString();
        }
        if (z) {
            cbVar2 = this.ccj.cbL;
            cbVar2.aeO();
            dVar = this.ccj.cbS;
            if (dVar != null) {
                cbVar8 = this.ccj.cbL;
                dVar2 = this.ccj.cbS;
                cbVar8.eI(dVar2.BE());
            }
            cbVar3 = this.ccj.cbL;
            cbVar3.aep();
            cbVar4 = this.ccj.cbL;
            cbVar4.eK(true);
            bkVar = this.ccj.cbG;
            bkVar.adY();
            this.ccj.a(antiData, postWriteCallBackData);
            if (writeData != null) {
                String floor = writeData.getFloor();
                if (writeData == null || writeData.getType() != 2) {
                    bkVar2 = this.ccj.cbG;
                    if (bkVar2.getHostMode()) {
                        bkVar4 = this.ccj.cbG;
                        com.baidu.tieba.pb.a.b pbData = bkVar4.getPbData();
                        if (pbData != null && pbData.acQ() != null && pbData.acQ().getAuthor() != null && (userId = pbData.acQ().getAuthor().getUserId()) != null && userId.equals(TbadkCoreApplication.getCurrentAccount())) {
                            bkVar5 = this.ccj.cbG;
                            if (bkVar5.adS()) {
                                cbVar6 = this.ccj.cbL;
                                cbVar6.aez();
                                return;
                            }
                            return;
                        }
                        return;
                    }
                    bkVar3 = this.ccj.cbG;
                    if (bkVar3.adS()) {
                        cbVar5 = this.ccj.cbL;
                        cbVar5.aez();
                    }
                } else if (floor != null) {
                    bkVar6 = this.ccj.cbG;
                    com.baidu.tieba.pb.a.b pbData2 = bkVar6.getPbData();
                    cbVar7 = this.ccj.cbL;
                    cbVar7.h(pbData2);
                }
            }
        } else if (lVar != null) {
        } else {
            this.ccj.a(i, antiData, str);
        }
    }
}
