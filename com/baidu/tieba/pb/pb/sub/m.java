package com.baidu.tieba.pb.pb.sub;

import com.baidu.tbadk.core.data.AntiData;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.coreExtra.data.WriteData;
import com.baidu.tieba.tbadkCore.writeModel.PostWriteCallBackData;
import com.baidu.tieba.tbadkCore.writeModel.a;
/* loaded from: classes.dex */
class m implements a.d {
    final /* synthetic */ NewSubPbActivity cmr;

    /* JADX INFO: Access modifiers changed from: package-private */
    public m(NewSubPbActivity newSubPbActivity) {
        this.cmr = newSubPbActivity;
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
            nVar = this.cmr.caJ;
            if (nVar != null) {
                nVar2 = this.cmr.caJ;
                if (nVar2.Ax() != null) {
                    nVar3 = this.cmr.caJ;
                    nVar3.Ax().hide();
                    akVar = this.cmr.cmi;
                    if (akVar.ahK()) {
                        ap apVar = new ap("c10367");
                        akVar2 = this.cmr.cmi;
                        TiebaStatic.log(apVar.ae("post_id", akVar2.Bl()));
                    }
                }
            }
        }
        tVar = this.cmr.cmk;
        tVar.ahn();
    }
}
