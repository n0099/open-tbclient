package com.baidu.tieba.pb.pb.main;

import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.AntiData;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.coreExtra.data.WriteData;
import com.baidu.tieba.tbadkCore.writeModel.PostWriteCallBackData;
import com.baidu.tieba.tbadkCore.writeModel.a;
/* loaded from: classes.dex */
class l implements a.d {
    final /* synthetic */ PbActivity cCm;

    /* JADX INFO: Access modifiers changed from: package-private */
    public l(PbActivity pbActivity) {
        this.cCm = pbActivity;
    }

    @Override // com.baidu.tieba.tbadkCore.writeModel.a.d
    public void a(boolean z, PostWriteCallBackData postWriteCallBackData, com.baidu.tbadk.coreExtra.data.n nVar, WriteData writeData, AntiData antiData) {
        da daVar;
        da daVar2;
        com.baidu.tbadk.editortools.d.e eVar;
        da daVar3;
        da daVar4;
        cc ccVar;
        cc ccVar2;
        cc ccVar3;
        da daVar5;
        cc ccVar4;
        String userId;
        cc ccVar5;
        da daVar6;
        cc ccVar6;
        cc ccVar7;
        cc ccVar8;
        da daVar7;
        da daVar8;
        com.baidu.tbadk.editortools.d.e eVar2;
        this.cCm.stopVoice();
        daVar = this.cCm.cBL;
        daVar.fr(z);
        String str = "";
        int i = -1;
        if (postWriteCallBackData != null) {
            i = postWriteCallBackData.getErrorCode();
            str = postWriteCallBackData.getErrorString();
        }
        if (z) {
            daVar2 = this.cCm.cBL;
            daVar2.alO();
            eVar = this.cCm.cBS;
            if (eVar != null) {
                daVar8 = this.cCm.cBL;
                eVar2 = this.cCm.cBS;
                daVar8.fu(eVar2.Cf());
            }
            daVar3 = this.cCm.cBL;
            daVar3.alm();
            daVar4 = this.cCm.cBL;
            daVar4.fw(true);
            ccVar = this.cCm.cBG;
            ccVar.akR();
            this.cCm.a(antiData, postWriteCallBackData);
            if (writeData != null) {
                String floor = writeData.getFloor();
                if (writeData == null || writeData.getType() != 2) {
                    ccVar2 = this.cCm.cBG;
                    if (ccVar2.getHostMode()) {
                        ccVar4 = this.cCm.cBG;
                        com.baidu.tieba.pb.a.c pbData = ccVar4.getPbData();
                        if (pbData != null && pbData.ajz() != null && pbData.ajz().getAuthor() != null && (userId = pbData.ajz().getAuthor().getUserId()) != null && userId.equals(TbadkCoreApplication.getCurrentAccount())) {
                            ccVar5 = this.cCm.cBG;
                            if (ccVar5.akL()) {
                                daVar6 = this.cCm.cBL;
                                daVar6.alx();
                            }
                        }
                    } else {
                        ccVar3 = this.cCm.cBG;
                        if (ccVar3.akL()) {
                            daVar5 = this.cCm.cBL;
                            daVar5.alx();
                        }
                    }
                } else if (floor != null) {
                    ccVar8 = this.cCm.cBG;
                    com.baidu.tieba.pb.a.c pbData2 = ccVar8.getPbData();
                    daVar7 = this.cCm.cBL;
                    daVar7.i(pbData2);
                }
                ccVar6 = this.cCm.cBG;
                if (ccVar6.akH()) {
                    com.baidu.tbadk.core.util.av avVar = new com.baidu.tbadk.core.util.av("c10369");
                    ccVar7 = this.cCm.cBG;
                    TiebaStatic.log(avVar.ab("tid", ccVar7.getThreadID()));
                }
            }
        } else if (nVar != null) {
        } else {
            this.cCm.a(i, antiData, str);
        }
    }
}
