package com.baidu.tieba.pb.pb.main;

import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.AntiData;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.coreExtra.data.WriteData;
import com.baidu.tieba.tbadkCore.writeModel.PostWriteCallBackData;
import com.baidu.tieba.tbadkCore.writeModel.a;
/* loaded from: classes.dex */
class k implements a.d {
    final /* synthetic */ PbActivity cjN;

    /* JADX INFO: Access modifiers changed from: package-private */
    public k(PbActivity pbActivity) {
        this.cjN = pbActivity;
    }

    @Override // com.baidu.tieba.tbadkCore.writeModel.a.d
    public void a(boolean z, PostWriteCallBackData postWriteCallBackData, com.baidu.tbadk.coreExtra.data.l lVar, WriteData writeData, AntiData antiData) {
        ct ctVar;
        ct ctVar2;
        com.baidu.tbadk.editortools.c.e eVar;
        ct ctVar3;
        ct ctVar4;
        ca caVar;
        ca caVar2;
        ca caVar3;
        ct ctVar5;
        ca caVar4;
        String userId;
        ca caVar5;
        ct ctVar6;
        ca caVar6;
        ca caVar7;
        ca caVar8;
        ct ctVar7;
        ct ctVar8;
        com.baidu.tbadk.editortools.c.e eVar2;
        this.cjN.stopVoice();
        ctVar = this.cjN.cjo;
        ctVar.eN(z);
        String str = "";
        int i = -1;
        if (postWriteCallBackData != null) {
            i = postWriteCallBackData.getErrorCode();
            str = postWriteCallBackData.getErrorString();
        }
        if (z) {
            ctVar2 = this.cjN.cjo;
            ctVar2.aho();
            eVar = this.cjN.cjw;
            if (eVar != null) {
                ctVar8 = this.cjN.cjo;
                eVar2 = this.cjN.cjw;
                ctVar8.eQ(eVar2.Bf());
            }
            ctVar3 = this.cjN.cjo;
            ctVar3.agO();
            ctVar4 = this.cjN.cjo;
            ctVar4.eS(true);
            caVar = this.cjN.cjj;
            caVar.agx();
            this.cjN.a(antiData, postWriteCallBackData);
            if (writeData != null) {
                String floor = writeData.getFloor();
                if (writeData == null || writeData.getType() != 2) {
                    caVar2 = this.cjN.cjj;
                    if (caVar2.getHostMode()) {
                        caVar4 = this.cjN.cjj;
                        com.baidu.tieba.pb.a.c pbData = caVar4.getPbData();
                        if (pbData != null && pbData.afh() != null && pbData.afh().getAuthor() != null && (userId = pbData.afh().getAuthor().getUserId()) != null && userId.equals(TbadkCoreApplication.getCurrentAccount())) {
                            caVar5 = this.cjN.cjj;
                            if (caVar5.ags()) {
                                ctVar6 = this.cjN.cjo;
                                ctVar6.agZ();
                            }
                        }
                    } else {
                        caVar3 = this.cjN.cjj;
                        if (caVar3.ags()) {
                            ctVar5 = this.cjN.cjo;
                            ctVar5.agZ();
                        }
                    }
                } else if (floor != null) {
                    caVar8 = this.cjN.cjj;
                    com.baidu.tieba.pb.a.c pbData2 = caVar8.getPbData();
                    ctVar7 = this.cjN.cjo;
                    ctVar7.h(pbData2);
                }
                caVar6 = this.cjN.cjj;
                if (caVar6.ago()) {
                    com.baidu.tbadk.core.util.aq aqVar = new com.baidu.tbadk.core.util.aq("c10369");
                    caVar7 = this.cjN.cjj;
                    TiebaStatic.log(aqVar.ae("tid", caVar7.getThreadID()));
                }
            }
        } else if (lVar != null) {
        } else {
            this.cjN.a(i, antiData, str);
        }
    }
}
