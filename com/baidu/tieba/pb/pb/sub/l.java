package com.baidu.tieba.pb.pb.sub;

import com.baidu.tbadk.core.data.AntiData;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.coreExtra.data.WriteData;
import com.baidu.tieba.tbadkCore.writeModel.PostWriteCallBackData;
import com.baidu.tieba.tbadkCore.writeModel.b;
/* loaded from: classes.dex */
class l implements b.d {
    final /* synthetic */ NewSubPbActivity evy;

    /* JADX INFO: Access modifiers changed from: package-private */
    public l(NewSubPbActivity newSubPbActivity) {
        this.evy = newSubPbActivity;
    }

    @Override // com.baidu.tieba.tbadkCore.writeModel.b.d
    public void callback(boolean z, PostWriteCallBackData postWriteCallBackData, com.baidu.tbadk.coreExtra.data.s sVar, WriteData writeData, AntiData antiData) {
        ag agVar;
        com.baidu.tbadk.editortools.d.p pVar;
        com.baidu.tbadk.editortools.d.p pVar2;
        com.baidu.tbadk.editortools.d.p pVar3;
        ax axVar;
        ax axVar2;
        if (z) {
            pVar = this.evy.dtc;
            if (pVar != null) {
                pVar2 = this.evy.dtc;
                if (pVar2.CG() != null) {
                    pVar3 = this.evy.dtc;
                    pVar3.CG().hide();
                    axVar = this.evy.evl;
                    if (axVar.aQT()) {
                        com.baidu.tbadk.core.util.ay ayVar = new com.baidu.tbadk.core.util.ay("c10367");
                        axVar2 = this.evy.evl;
                        TiebaStatic.log(ayVar.ab("post_id", axVar2.Dg()));
                    }
                }
            }
        }
        agVar = this.evy.evn;
        agVar.aQt();
    }
}
