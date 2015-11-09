package com.baidu.tieba.pb.pb.sub;

import com.baidu.tbadk.core.data.AntiData;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.coreExtra.data.WriteData;
import com.baidu.tieba.tbadkCore.writeModel.PostWriteCallBackData;
import com.baidu.tieba.tbadkCore.writeModel.a;
/* loaded from: classes.dex */
class o implements a.d {
    final /* synthetic */ NewSubPbActivity cnS;

    /* JADX INFO: Access modifiers changed from: package-private */
    public o(NewSubPbActivity newSubPbActivity) {
        this.cnS = newSubPbActivity;
    }

    @Override // com.baidu.tieba.tbadkCore.writeModel.a.d
    public void a(boolean z, PostWriteCallBackData postWriteCallBackData, com.baidu.tbadk.coreExtra.data.l lVar, WriteData writeData, AntiData antiData) {
        v vVar;
        com.baidu.tbadk.editortools.c.p pVar;
        com.baidu.tbadk.editortools.c.p pVar2;
        com.baidu.tbadk.editortools.c.p pVar3;
        am amVar;
        am amVar2;
        if (z) {
            pVar = this.cnS.cbv;
            if (pVar != null) {
                pVar2 = this.cnS.cbv;
                if (pVar2.Az() != null) {
                    pVar3 = this.cnS.cbv;
                    pVar3.Az().hide();
                    amVar = this.cnS.cnH;
                    if (amVar.aim()) {
                        aq aqVar = new aq("c10367");
                        amVar2 = this.cnS.cnH;
                        TiebaStatic.log(aqVar.ae("post_id", amVar2.AV()));
                    }
                }
            }
        }
        vVar = this.cnS.cnJ;
        vVar.ahP();
    }
}
