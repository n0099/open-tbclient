package com.baidu.tieba.pb.pb.sub;

import com.baidu.tbadk.core.data.AntiData;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.av;
import com.baidu.tbadk.coreExtra.data.WriteData;
import com.baidu.tieba.tbadkCore.writeModel.PostWriteCallBackData;
import com.baidu.tieba.tbadkCore.writeModel.a;
/* loaded from: classes.dex */
class p implements a.d {
    final /* synthetic */ NewSubPbActivity cLc;

    /* JADX INFO: Access modifiers changed from: package-private */
    public p(NewSubPbActivity newSubPbActivity) {
        this.cLc = newSubPbActivity;
    }

    @Override // com.baidu.tieba.tbadkCore.writeModel.a.d
    public void a(boolean z, PostWriteCallBackData postWriteCallBackData, com.baidu.tbadk.coreExtra.data.n nVar, WriteData writeData, AntiData antiData) {
        w wVar;
        com.baidu.tbadk.editortools.d.p pVar;
        com.baidu.tbadk.editortools.d.p pVar2;
        com.baidu.tbadk.editortools.d.p pVar3;
        ao aoVar;
        ao aoVar2;
        if (z) {
            pVar = this.cLc.cjc;
            if (pVar != null) {
                pVar2 = this.cLc.cjc;
                if (pVar2.Bj() != null) {
                    pVar3 = this.cLc.cjc;
                    pVar3.Bj().hide();
                    aoVar = this.cLc.cKR;
                    if (aoVar.aoa()) {
                        av avVar = new av("c10367");
                        aoVar2 = this.cLc.cKR;
                        TiebaStatic.log(avVar.aa("post_id", aoVar2.BJ()));
                    }
                }
            }
        }
        wVar = this.cLc.cKT;
        wVar.anE();
    }
}
