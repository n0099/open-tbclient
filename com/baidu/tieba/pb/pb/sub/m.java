package com.baidu.tieba.pb.pb.sub;

import com.baidu.tbadk.core.data.AntiData;
import com.baidu.tbadk.coreExtra.data.WriteData;
import com.baidu.tieba.tbadkCore.writeModel.PostWriteCallBackData;
import com.baidu.tieba.tbadkCore.writeModel.a;
/* loaded from: classes.dex */
class m implements a.d {
    final /* synthetic */ NewSubPbActivity cfY;

    /* JADX INFO: Access modifiers changed from: package-private */
    public m(NewSubPbActivity newSubPbActivity) {
        this.cfY = newSubPbActivity;
    }

    @Override // com.baidu.tieba.tbadkCore.writeModel.a.d
    public void a(boolean z, PostWriteCallBackData postWriteCallBackData, com.baidu.tbadk.coreExtra.data.l lVar, WriteData writeData, AntiData antiData) {
        t tVar;
        com.baidu.tbadk.editortools.c.n nVar;
        com.baidu.tbadk.editortools.c.n nVar2;
        com.baidu.tbadk.editortools.c.n nVar3;
        if (z) {
            nVar = this.cfY.bWp;
            if (nVar != null) {
                nVar2 = this.cfY.bWp;
                if (nVar2.Ay() != null) {
                    nVar3 = this.cfY.bWp;
                    nVar3.Ay().hide();
                }
            }
        }
        tVar = this.cfY.cfR;
        tVar.afc();
    }
}
