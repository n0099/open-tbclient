package com.baidu.tieba.pb.pb.sub;

import com.baidu.tbadk.core.data.AntiData;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.aw;
import com.baidu.tbadk.coreExtra.data.WriteData;
import com.baidu.tieba.tbadkCore.writeModel.PostWriteCallBackData;
import com.baidu.tieba.tbadkCore.writeModel.a;
/* loaded from: classes.dex */
class r implements a.d {
    final /* synthetic */ NewSubPbActivity dqn;

    /* JADX INFO: Access modifiers changed from: package-private */
    public r(NewSubPbActivity newSubPbActivity) {
        this.dqn = newSubPbActivity;
    }

    @Override // com.baidu.tieba.tbadkCore.writeModel.a.d
    public void callback(boolean z, PostWriteCallBackData postWriteCallBackData, com.baidu.tbadk.coreExtra.data.o oVar, WriteData writeData, AntiData antiData) {
        y yVar;
        com.baidu.tbadk.editortools.d.p pVar;
        com.baidu.tbadk.editortools.d.p pVar2;
        com.baidu.tbadk.editortools.d.p pVar3;
        ap apVar;
        ap apVar2;
        if (z) {
            pVar = this.dqn.czd;
            if (pVar != null) {
                pVar2 = this.dqn.czd;
                if (pVar2.Bc() != null) {
                    pVar3 = this.dqn.czd;
                    pVar3.Bc().hide();
                    apVar = this.dqn.dqc;
                    if (apVar.aAA()) {
                        aw awVar = new aw("c10367");
                        apVar2 = this.dqn.dqc;
                        TiebaStatic.log(awVar.ac("post_id", apVar2.BC()));
                    }
                }
            }
        }
        yVar = this.dqn.dqe;
        yVar.aAc();
    }
}
