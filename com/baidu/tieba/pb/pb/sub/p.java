package com.baidu.tieba.pb.pb.sub;

import com.baidu.tbadk.core.data.AntiData;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.au;
import com.baidu.tbadk.coreExtra.data.WriteData;
import com.baidu.tieba.tbadkCore.writeModel.PostWriteCallBackData;
import com.baidu.tieba.tbadkCore.writeModel.a;
/* loaded from: classes.dex */
class p implements a.d {
    final /* synthetic */ NewSubPbActivity cTK;

    /* JADX INFO: Access modifiers changed from: package-private */
    public p(NewSubPbActivity newSubPbActivity) {
        this.cTK = newSubPbActivity;
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
            pVar = this.cTK.cnC;
            if (pVar != null) {
                pVar2 = this.cTK.cnC;
                if (pVar2.Cz() != null) {
                    pVar3 = this.cTK.cnC;
                    pVar3.Cz().hide();
                    aoVar = this.cTK.cTz;
                    if (aoVar.asF()) {
                        au auVar = new au("c10367");
                        aoVar2 = this.cTK.cTz;
                        TiebaStatic.log(auVar.aa("post_id", aoVar2.CZ()));
                    }
                }
            }
        }
        wVar = this.cTK.cTB;
        wVar.ash();
    }
}
