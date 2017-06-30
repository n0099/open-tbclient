package com.baidu.tieba.pb.pb.sub;

import com.baidu.tbadk.core.data.AntiData;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.coreExtra.data.WriteData;
import com.baidu.tieba.tbadkCore.writeModel.NewWriteModel;
import com.baidu.tieba.tbadkCore.writeModel.PostWriteCallBackData;
/* loaded from: classes.dex */
class s implements NewWriteModel.d {
    final /* synthetic */ NewSubPbActivity eHC;

    /* JADX INFO: Access modifiers changed from: package-private */
    public s(NewSubPbActivity newSubPbActivity) {
        this.eHC = newSubPbActivity;
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
            nVar = this.eHC.duY;
            if (nVar != null) {
                nVar2 = this.eHC.duY;
                if (nVar2.CG() != null) {
                    nVar3 = this.eHC.duY;
                    nVar3.CG().hide();
                    subPbModel = this.eHC.eHl;
                    if (subPbModel.aSt()) {
                        com.baidu.tbadk.core.util.au auVar = new com.baidu.tbadk.core.util.au("c10367");
                        subPbModel2 = this.eHC.eHl;
                        TiebaStatic.log(auVar.Z("post_id", subPbModel2.Db()));
                    }
                }
            }
        }
        aoVar = this.eHC.eHn;
        aoVar.aSa();
    }
}
