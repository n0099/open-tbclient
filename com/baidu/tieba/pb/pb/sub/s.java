package com.baidu.tieba.pb.pb.sub;

import com.baidu.tbadk.core.data.AntiData;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.coreExtra.data.WriteData;
import com.baidu.tieba.tbadkCore.writeModel.NewWriteModel;
import com.baidu.tieba.tbadkCore.writeModel.PostWriteCallBackData;
/* loaded from: classes.dex */
class s implements NewWriteModel.d {
    final /* synthetic */ NewSubPbActivity esV;

    /* JADX INFO: Access modifiers changed from: package-private */
    public s(NewSubPbActivity newSubPbActivity) {
        this.esV = newSubPbActivity;
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
            nVar = this.esV.dlk;
            if (nVar != null) {
                nVar2 = this.esV.dlk;
                if (nVar2.Dn() != null) {
                    nVar3 = this.esV.dlk;
                    nVar3.Dn().hide();
                    subPbModel = this.esV.esE;
                    if (subPbModel.aOU()) {
                        com.baidu.tbadk.core.util.as asVar = new com.baidu.tbadk.core.util.as("c10367");
                        subPbModel2 = this.esV.esE;
                        TiebaStatic.log(asVar.aa("post_id", subPbModel2.DJ()));
                    }
                }
            }
        }
        aoVar = this.esV.esG;
        aoVar.aOB();
    }
}
