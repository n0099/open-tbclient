package com.baidu.tieba.pb.pb.sub;

import com.baidu.tbadk.core.data.AntiData;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.coreExtra.data.WriteData;
import com.baidu.tieba.tbadkCore.writeModel.PostWriteCallBackData;
import com.baidu.tieba.tbadkCore.writeModel.a;
/* loaded from: classes.dex */
class m implements a.d {
    final /* synthetic */ NewSubPbActivity cmC;

    /* JADX INFO: Access modifiers changed from: package-private */
    public m(NewSubPbActivity newSubPbActivity) {
        this.cmC = newSubPbActivity;
    }

    @Override // com.baidu.tieba.tbadkCore.writeModel.a.d
    public void a(boolean z, PostWriteCallBackData postWriteCallBackData, com.baidu.tbadk.coreExtra.data.l lVar, WriteData writeData, AntiData antiData) {
        t tVar;
        com.baidu.tbadk.editortools.c.n nVar;
        com.baidu.tbadk.editortools.c.n nVar2;
        com.baidu.tbadk.editortools.c.n nVar3;
        ak akVar;
        ak akVar2;
        if (z) {
            nVar = this.cmC.caU;
            if (nVar != null) {
                nVar2 = this.cmC.caU;
                if (nVar2.Au() != null) {
                    nVar3 = this.cmC.caU;
                    nVar3.Au().hide();
                    akVar = this.cmC.cmt;
                    if (akVar.ahG()) {
                        aq aqVar = new aq("c10367");
                        akVar2 = this.cmC.cmt;
                        TiebaStatic.log(aqVar.ae("post_id", akVar2.Bi()));
                    }
                }
            }
        }
        tVar = this.cmC.cmv;
        tVar.ahj();
    }
}
