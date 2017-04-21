package com.baidu.tieba.pb.pb.sub;

import com.baidu.tbadk.core.data.AntiData;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.coreExtra.data.WriteData;
import com.baidu.tieba.tbadkCore.writeModel.NewWriteModel;
import com.baidu.tieba.tbadkCore.writeModel.PostWriteCallBackData;
/* loaded from: classes.dex */
class s implements NewWriteModel.d {
    final /* synthetic */ NewSubPbActivity evm;

    /* JADX INFO: Access modifiers changed from: package-private */
    public s(NewSubPbActivity newSubPbActivity) {
        this.evm = newSubPbActivity;
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
            nVar = this.evm.dnB;
            if (nVar != null) {
                nVar2 = this.evm.dnB;
                if (nVar2.Dn() != null) {
                    nVar3 = this.evm.dnB;
                    nVar3.Dn().hide();
                    subPbModel = this.evm.euV;
                    if (subPbModel.aPV()) {
                        com.baidu.tbadk.core.util.as asVar = new com.baidu.tbadk.core.util.as("c10367");
                        subPbModel2 = this.evm.euV;
                        TiebaStatic.log(asVar.aa("post_id", subPbModel2.DJ()));
                    }
                }
            }
        }
        aoVar = this.evm.euX;
        aoVar.aPC();
    }
}
