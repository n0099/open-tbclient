package com.baidu.tieba.pb.pb.main;

import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.AntiData;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.coreExtra.data.WriteData;
import com.baidu.tieba.tbadkCore.writeModel.PostWriteCallBackData;
import com.baidu.tieba.tbadkCore.writeModel.a;
/* loaded from: classes.dex */
class z implements a.d {
    final /* synthetic */ PbActivity ebT;

    /* JADX INFO: Access modifiers changed from: package-private */
    public z(PbActivity pbActivity) {
        this.ebT = pbActivity;
    }

    @Override // com.baidu.tieba.tbadkCore.writeModel.a.d
    public void callback(boolean z, PostWriteCallBackData postWriteCallBackData, com.baidu.tbadk.coreExtra.data.p pVar, WriteData writeData, AntiData antiData) {
        ew ewVar;
        ew ewVar2;
        com.baidu.tbadk.editortools.d.e eVar;
        ew ewVar3;
        ew ewVar4;
        dh dhVar;
        dh dhVar2;
        dh dhVar3;
        ew ewVar5;
        dh dhVar4;
        String userId;
        dh dhVar5;
        ew ewVar6;
        dh dhVar6;
        dh dhVar7;
        dh dhVar8;
        ew ewVar7;
        ew ewVar8;
        com.baidu.tbadk.editortools.d.e eVar2;
        this.ebT.VR();
        ewVar = this.ebT.ebb;
        ewVar.hZ(z);
        String str = "";
        int i = -1;
        if (postWriteCallBackData != null) {
            i = postWriteCallBackData.getErrorCode();
            str = postWriteCallBackData.getErrorString();
        }
        if (z) {
            ewVar2 = this.ebT.ebb;
            ewVar2.avR();
            eVar = this.ebT.ebk;
            if (eVar != null) {
                ewVar8 = this.ebT.ebb;
                eVar2 = this.ebT.ebk;
                ewVar8.ge(eVar2.BW());
            }
            ewVar3 = this.ebT.ebb;
            ewVar3.aKf();
            ewVar4 = this.ebT.ebb;
            ewVar4.gf(true);
            dhVar = this.ebT.eas;
            dhVar.aJj();
            this.ebT.a(antiData, postWriteCallBackData);
            if (writeData != null) {
                String floor = writeData.getFloor();
                if (writeData == null || writeData.getType() != 2) {
                    dhVar2 = this.ebT.eas;
                    if (dhVar2.getHostMode()) {
                        dhVar4 = this.ebT.eas;
                        com.baidu.tieba.pb.data.h pbData = dhVar4.getPbData();
                        if (pbData != null && pbData.aGY() != null && pbData.aGY().getAuthor() != null && (userId = pbData.aGY().getAuthor().getUserId()) != null && userId.equals(TbadkCoreApplication.getCurrentAccount())) {
                            dhVar5 = this.ebT.eas;
                            if (dhVar5.aJc()) {
                                ewVar6 = this.ebT.ebb;
                                ewVar6.aKy();
                            }
                        }
                    } else {
                        dhVar3 = this.ebT.eas;
                        if (dhVar3.aJc()) {
                            ewVar5 = this.ebT.ebb;
                            ewVar5.aKy();
                        }
                    }
                } else if (floor != null) {
                    dhVar8 = this.ebT.eas;
                    com.baidu.tieba.pb.data.h pbData2 = dhVar8.getPbData();
                    ewVar7 = this.ebT.ebb;
                    ewVar7.j(pbData2);
                }
                dhVar6 = this.ebT.eas;
                if (dhVar6.aIZ()) {
                    com.baidu.tbadk.core.util.ay ayVar = new com.baidu.tbadk.core.util.ay("c10369");
                    dhVar7 = this.ebT.eas;
                    TiebaStatic.log(ayVar.ab("tid", dhVar7.getThreadID()));
                }
            }
        } else if (pVar != null || i == 227001) {
        } else {
            this.ebT.a(i, antiData, str);
        }
    }
}
