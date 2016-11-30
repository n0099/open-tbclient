package com.baidu.tieba.pb.pb.sub;

import com.baidu.tbadk.core.data.AntiData;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.coreExtra.data.WriteData;
import com.baidu.tieba.tbadkCore.writeModel.PostWriteCallBackData;
import com.baidu.tieba.tbadkCore.writeModel.b;
/* loaded from: classes.dex */
class s implements b.d {
    final /* synthetic */ NewSubPbActivity eEs;

    /* JADX INFO: Access modifiers changed from: package-private */
    public s(NewSubPbActivity newSubPbActivity) {
        this.eEs = newSubPbActivity;
    }

    @Override // com.baidu.tieba.tbadkCore.writeModel.b.d
    public void callback(boolean z, PostWriteCallBackData postWriteCallBackData, com.baidu.tbadk.coreExtra.data.s sVar, WriteData writeData, AntiData antiData) {
        ao aoVar;
        com.baidu.tbadk.editortools.e.p pVar;
        com.baidu.tbadk.editortools.e.p pVar2;
        com.baidu.tbadk.editortools.e.p pVar3;
        bc bcVar;
        bc bcVar2;
        if (z) {
            pVar = this.eEs.dAe;
            if (pVar != null) {
                pVar2 = this.eEs.dAe;
                if (pVar2.CO() != null) {
                    pVar3 = this.eEs.dAe;
                    pVar3.CO().hide();
                    bcVar = this.eEs.eEb;
                    if (bcVar.aTH()) {
                        com.baidu.tbadk.core.util.av avVar = new com.baidu.tbadk.core.util.av("c10367");
                        bcVar2 = this.eEs.eEb;
                        TiebaStatic.log(avVar.ab("post_id", bcVar2.Do()));
                    }
                }
            }
        }
        aoVar = this.eEs.eEd;
        aoVar.aTo();
    }
}
