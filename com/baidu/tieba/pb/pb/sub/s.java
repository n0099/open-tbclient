package com.baidu.tieba.pb.pb.sub;

import com.baidu.tbadk.core.data.AntiData;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.coreExtra.data.WriteData;
import com.baidu.tieba.tbadkCore.writeModel.PostWriteCallBackData;
import com.baidu.tieba.tbadkCore.writeModel.b;
/* loaded from: classes.dex */
class s implements b.d {
    final /* synthetic */ NewSubPbActivity eis;

    /* JADX INFO: Access modifiers changed from: package-private */
    public s(NewSubPbActivity newSubPbActivity) {
        this.eis = newSubPbActivity;
    }

    @Override // com.baidu.tieba.tbadkCore.writeModel.b.d
    public void callback(boolean z, PostWriteCallBackData postWriteCallBackData, com.baidu.tbadk.coreExtra.data.q qVar, WriteData writeData, AntiData antiData) {
        ao aoVar;
        com.baidu.tbadk.editortools.e.p pVar;
        com.baidu.tbadk.editortools.e.p pVar2;
        com.baidu.tbadk.editortools.e.p pVar3;
        bc bcVar;
        bc bcVar2;
        if (z) {
            pVar = this.eis.ddg;
            if (pVar != null) {
                pVar2 = this.eis.ddg;
                if (pVar2.CB() != null) {
                    pVar3 = this.eis.ddg;
                    pVar3.CB().hide();
                    bcVar = this.eis.eib;
                    if (bcVar.aNy()) {
                        com.baidu.tbadk.core.util.at atVar = new com.baidu.tbadk.core.util.at("c10367");
                        bcVar2 = this.eis.eib;
                        TiebaStatic.log(atVar.ab("post_id", bcVar2.CX()));
                    }
                }
            }
        }
        aoVar = this.eis.eid;
        aoVar.aNf();
    }
}
