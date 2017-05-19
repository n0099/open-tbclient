package com.baidu.tieba.pb.pb.sub;

import com.baidu.tbadk.core.data.AntiData;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.coreExtra.data.WriteData;
import com.baidu.tieba.tbadkCore.writeModel.NewWriteModel;
import com.baidu.tieba.tbadkCore.writeModel.PostWriteCallBackData;
/* loaded from: classes.dex */
class s implements NewWriteModel.d {
    final /* synthetic */ NewSubPbActivity eqU;

    /* JADX INFO: Access modifiers changed from: package-private */
    public s(NewSubPbActivity newSubPbActivity) {
        this.eqU = newSubPbActivity;
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
            nVar = this.eqU.dhG;
            if (nVar != null) {
                nVar2 = this.eqU.dhG;
                if (nVar2.Cs() != null) {
                    nVar3 = this.eqU.dhG;
                    nVar3.Cs().hide();
                    subPbModel = this.eqU.eqD;
                    if (subPbModel.aNl()) {
                        com.baidu.tbadk.core.util.as asVar = new com.baidu.tbadk.core.util.as("c10367");
                        subPbModel2 = this.eqU.eqD;
                        TiebaStatic.log(asVar.aa("post_id", subPbModel2.CN()));
                    }
                }
            }
        }
        aoVar = this.eqU.eqF;
        aoVar.aMS();
    }
}
