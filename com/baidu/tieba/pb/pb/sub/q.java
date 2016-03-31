package com.baidu.tieba.pb.pb.sub;

import com.baidu.tbadk.core.data.AntiData;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.aw;
import com.baidu.tbadk.coreExtra.data.WriteData;
import com.baidu.tieba.tbadkCore.writeModel.PostWriteCallBackData;
import com.baidu.tieba.tbadkCore.writeModel.a;
/* loaded from: classes.dex */
class q implements a.d {
    final /* synthetic */ NewSubPbActivity doF;

    /* JADX INFO: Access modifiers changed from: package-private */
    public q(NewSubPbActivity newSubPbActivity) {
        this.doF = newSubPbActivity;
    }

    @Override // com.baidu.tieba.tbadkCore.writeModel.a.d
    public void callback(boolean z, PostWriteCallBackData postWriteCallBackData, com.baidu.tbadk.coreExtra.data.n nVar, WriteData writeData, AntiData antiData) {
        x xVar;
        com.baidu.tbadk.editortools.d.p pVar;
        com.baidu.tbadk.editortools.d.p pVar2;
        com.baidu.tbadk.editortools.d.p pVar3;
        ap apVar;
        ap apVar2;
        if (z) {
            pVar = this.doF.cye;
            if (pVar != null) {
                pVar2 = this.doF.cye;
                if (pVar2.Dh() != null) {
                    pVar3 = this.doF.cye;
                    pVar3.Dh().hide();
                    apVar = this.doF.dou;
                    if (apVar.aAp()) {
                        aw awVar = new aw("c10367");
                        apVar2 = this.doF.dou;
                        TiebaStatic.log(awVar.ac("post_id", apVar2.DH()));
                    }
                }
            }
        }
        xVar = this.doF.dow;
        xVar.azS();
    }
}
