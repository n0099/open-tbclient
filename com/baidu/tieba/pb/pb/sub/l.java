package com.baidu.tieba.pb.pb.sub;

import com.baidu.tbadk.core.data.AntiData;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.ay;
import com.baidu.tbadk.coreExtra.data.WriteData;
import com.baidu.tieba.tbadkCore.writeModel.PostWriteCallBackData;
import com.baidu.tieba.tbadkCore.writeModel.a;
/* loaded from: classes.dex */
class l implements a.d {
    final /* synthetic */ NewSubPbActivity ejr;

    /* JADX INFO: Access modifiers changed from: package-private */
    public l(NewSubPbActivity newSubPbActivity) {
        this.ejr = newSubPbActivity;
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
            pVar2 = this.ejr.dhw;
            if (pVar2 != null) {
                pVar3 = this.ejr.dhw;
                if (pVar3.Bl() != null) {
                    pVar4 = this.ejr.dhw;
                    pVar4.Bl().hide();
                    awVar = this.ejr.eje;
                    if (awVar.aMb()) {
                        ay ayVar = new ay("c10367");
                        awVar2 = this.ejr.eje;
                        TiebaStatic.log(ayVar.ab("post_id", awVar2.BL()));
                    }
                }
            }
        }
        afVar = this.ejr.ejg;
        afVar.aLD();
    }
}
