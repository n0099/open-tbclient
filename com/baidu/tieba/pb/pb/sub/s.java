package com.baidu.tieba.pb.pb.sub;

import com.baidu.tbadk.core.data.AntiData;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.coreExtra.data.WriteData;
import com.baidu.tieba.tbadkCore.writeModel.NewWriteModel;
import com.baidu.tieba.tbadkCore.writeModel.PostWriteCallBackData;
/* loaded from: classes.dex */
class s implements NewWriteModel.d {
    final /* synthetic */ NewSubPbActivity erC;

    /* JADX INFO: Access modifiers changed from: package-private */
    public s(NewSubPbActivity newSubPbActivity) {
        this.erC = newSubPbActivity;
    }

    @Override // com.baidu.tieba.tbadkCore.writeModel.NewWriteModel.d
    public void callback(boolean z, PostWriteCallBackData postWriteCallBackData, com.baidu.tbadk.coreExtra.data.q qVar, WriteData writeData, AntiData antiData) {
        ao aoVar;
        com.baidu.tbadk.editortools.pb.n nVar;
        com.baidu.tbadk.editortools.pb.n nVar2;
        com.baidu.tbadk.editortools.pb.n nVar3;
        SubPbModel subPbModel;
        SubPbModel subPbModel2;
        if (z) {
            nVar = this.erC.dkr;
            if (nVar != null) {
                nVar2 = this.erC.dkr;
                if (nVar2.Cw() != null) {
                    nVar3 = this.erC.dkr;
                    nVar3.Cw().hide();
                    subPbModel = this.erC.erl;
                    if (subPbModel.aPu()) {
                        com.baidu.tbadk.core.util.ar arVar = new com.baidu.tbadk.core.util.ar("c10367");
                        subPbModel2 = this.erC.erl;
                        TiebaStatic.log(arVar.ab("post_id", subPbModel2.CS()));
                    }
                }
            }
        }
        aoVar = this.erC.ern;
        aoVar.aPb();
    }
}
