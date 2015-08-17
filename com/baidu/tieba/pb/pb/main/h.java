package com.baidu.tieba.pb.pb.main;

import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.AntiData;
import com.baidu.tbadk.coreExtra.data.WriteData;
import com.baidu.tieba.tbadkCore.writeModel.PostWriteCallBackData;
import com.baidu.tieba.tbadkCore.writeModel.a;
/* loaded from: classes.dex */
class h implements a.d {
    final /* synthetic */ PbActivity cbo;

    /* JADX INFO: Access modifiers changed from: package-private */
    public h(PbActivity pbActivity) {
        this.cbo = pbActivity;
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
        this.cbo.stopVoice();
        cbVar = this.cbo.caQ;
        cbVar.ex(z);
        String str = "";
        int i = -1;
        if (postWriteCallBackData != null) {
            i = postWriteCallBackData.getErrorCode();
            str = postWriteCallBackData.getErrorString();
        }
        if (z) {
            cbVar2 = this.cbo.caQ;
            cbVar2.aeA();
            dVar = this.cbo.caX;
            if (dVar != null) {
                cbVar8 = this.cbo.caQ;
                dVar2 = this.cbo.caX;
                cbVar8.eA(dVar2.Br());
            }
            cbVar3 = this.cbo.caQ;
            cbVar3.aeb();
            cbVar4 = this.cbo.caQ;
            cbVar4.eC(true);
            bkVar = this.cbo.caL;
            bkVar.adK();
            this.cbo.a(antiData, postWriteCallBackData);
            if (writeData != null) {
                String floor = writeData.getFloor();
                if (writeData == null || writeData.getType() != 2) {
                    bkVar2 = this.cbo.caL;
                    if (bkVar2.getHostMode()) {
                        bkVar4 = this.cbo.caL;
                        com.baidu.tieba.pb.a.b pbData = bkVar4.getPbData();
                        if (pbData != null && pbData.acH() != null && pbData.acH().getAuthor() != null && (userId = pbData.acH().getAuthor().getUserId()) != null && userId.equals(TbadkCoreApplication.getCurrentAccount())) {
                            bkVar5 = this.cbo.caL;
                            if (bkVar5.adE()) {
                                cbVar6 = this.cbo.caQ;
                                cbVar6.ael();
                                return;
                            }
                            return;
                        }
                        return;
                    }
                    bkVar3 = this.cbo.caL;
                    if (bkVar3.adE()) {
                        cbVar5 = this.cbo.caQ;
                        cbVar5.ael();
                    }
                } else if (floor != null) {
                    bkVar6 = this.cbo.caL;
                    com.baidu.tieba.pb.a.b pbData2 = bkVar6.getPbData();
                    cbVar7 = this.cbo.caQ;
                    cbVar7.h(pbData2);
                }
            }
        } else if (lVar != null) {
        } else {
            this.cbo.a(i, antiData, str);
        }
    }
}
