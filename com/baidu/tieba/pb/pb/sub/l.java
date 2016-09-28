package com.baidu.tieba.pb.pb.sub;

import com.baidu.tbadk.core.data.AntiData;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.coreExtra.data.WriteData;
import com.baidu.tieba.tbadkCore.writeModel.PostWriteCallBackData;
import com.baidu.tieba.tbadkCore.writeModel.b;
/* loaded from: classes.dex */
class l implements b.d {
    final /* synthetic */ NewSubPbActivity exF;

    /* JADX INFO: Access modifiers changed from: package-private */
    public l(NewSubPbActivity newSubPbActivity) {
        this.exF = newSubPbActivity;
    }

    @Override // com.baidu.tieba.tbadkCore.writeModel.b.d
    public void callback(boolean z, PostWriteCallBackData postWriteCallBackData, com.baidu.tbadk.coreExtra.data.s sVar, WriteData writeData, AntiData antiData) {
        ag agVar;
        com.baidu.tbadk.editortools.e.p pVar;
        com.baidu.tbadk.editortools.e.p pVar2;
        com.baidu.tbadk.editortools.e.p pVar3;
        ax axVar;
        ax axVar2;
        if (z) {
            pVar = this.exF.duz;
            if (pVar != null) {
                pVar2 = this.exF.duz;
                if (pVar2.CG() != null) {
                    pVar3 = this.exF.duz;
                    pVar3.CG().hide();
                    axVar = this.exF.exr;
                    if (axVar.aRB()) {
                        com.baidu.tbadk.core.util.ax axVar3 = new com.baidu.tbadk.core.util.ax("c10367");
                        axVar2 = this.exF.exr;
                        TiebaStatic.log(axVar3.ab("post_id", axVar2.Dg()));
                    }
                }
            }
        }
        agVar = this.exF.exu;
        agVar.aRb();
    }
}
