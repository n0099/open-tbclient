package com.baidu.tieba.pb.pb.sub;

import com.baidu.tbadk.core.data.AntiData;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.av;
import com.baidu.tbadk.coreExtra.data.WriteData;
import com.baidu.tieba.tbadkCore.writeModel.PostWriteCallBackData;
import com.baidu.tieba.tbadkCore.writeModel.a;
/* loaded from: classes.dex */
class p implements a.d {
    final /* synthetic */ NewSubPbActivity cHd;

    /* JADX INFO: Access modifiers changed from: package-private */
    public p(NewSubPbActivity newSubPbActivity) {
        this.cHd = newSubPbActivity;
    }

    @Override // com.baidu.tieba.tbadkCore.writeModel.a.d
    public void a(boolean z, PostWriteCallBackData postWriteCallBackData, com.baidu.tbadk.coreExtra.data.n nVar, WriteData writeData, AntiData antiData) {
        w wVar;
        com.baidu.tbadk.editortools.d.p pVar;
        com.baidu.tbadk.editortools.d.p pVar2;
        com.baidu.tbadk.editortools.d.p pVar3;
        an anVar;
        an anVar2;
        if (z) {
            pVar = this.cHd.ceY;
            if (pVar != null) {
                pVar2 = this.cHd.ceY;
                if (pVar2.Bu() != null) {
                    pVar3 = this.cHd.ceY;
                    pVar3.Bu().hide();
                    anVar = this.cHd.cGS;
                    if (anVar.amP()) {
                        av avVar = new av("c10367");
                        anVar2 = this.cHd.cGS;
                        TiebaStatic.log(avVar.ab("post_id", anVar2.BU()));
                    }
                }
            }
        }
        wVar = this.cHd.cGU;
        wVar.ams();
    }
}
