package com.baidu.tieba.pb.pb.sub;

import com.baidu.tbadk.core.data.AntiData;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.ay;
import com.baidu.tbadk.coreExtra.data.WriteData;
import com.baidu.tieba.tbadkCore.writeModel.PostWriteCallBackData;
import com.baidu.tieba.tbadkCore.writeModel.a;
/* loaded from: classes.dex */
class l implements a.d {
    final /* synthetic */ NewSubPbActivity dWP;

    /* JADX INFO: Access modifiers changed from: package-private */
    public l(NewSubPbActivity newSubPbActivity) {
        this.dWP = newSubPbActivity;
    }

    @Override // com.baidu.tieba.tbadkCore.writeModel.a.d
    public void callback(boolean z, PostWriteCallBackData postWriteCallBackData, com.baidu.tbadk.coreExtra.data.p pVar, WriteData writeData, AntiData antiData) {
        af afVar;
        com.baidu.tbadk.editortools.d.p pVar2;
        com.baidu.tbadk.editortools.d.p pVar3;
        com.baidu.tbadk.editortools.d.p pVar4;
        aw awVar;
        aw awVar2;
        if (z) {
            pVar2 = this.dWP.deA;
            if (pVar2 != null) {
                pVar3 = this.dWP.deA;
                if (pVar3.Bl() != null) {
                    pVar4 = this.dWP.deA;
                    pVar4.Bl().hide();
                    awVar = this.dWP.dWC;
                    if (awVar.aIQ()) {
                        ay ayVar = new ay("c10367");
                        awVar2 = this.dWP.dWC;
                        TiebaStatic.log(ayVar.ab("post_id", awVar2.BL()));
                    }
                }
            }
        }
        afVar = this.dWP.dWE;
        afVar.aIs();
    }
}
