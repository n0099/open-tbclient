package com.baidu.tieba.pb.pb.sub;

import com.baidu.tbadk.core.data.AntiData;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.coreExtra.data.WriteData;
import com.baidu.tieba.tbadkCore.writeModel.NewWriteModel;
import com.baidu.tieba.tbadkCore.writeModel.PostWriteCallBackData;
/* loaded from: classes.dex */
class s implements NewWriteModel.d {
    final /* synthetic */ NewSubPbActivity eye;

    /* JADX INFO: Access modifiers changed from: package-private */
    public s(NewSubPbActivity newSubPbActivity) {
        this.eye = newSubPbActivity;
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
            nVar = this.eye.dnc;
            if (nVar != null) {
                nVar2 = this.eye.dnc;
                if (nVar2.Cm() != null) {
                    nVar3 = this.eye.dnc;
                    nVar3.Cm().hide();
                    subPbModel = this.eye.exN;
                    if (subPbModel.aOu()) {
                        com.baidu.tbadk.core.util.as asVar = new com.baidu.tbadk.core.util.as("c10367");
                        subPbModel2 = this.eye.exN;
                        TiebaStatic.log(asVar.Z("post_id", subPbModel2.CH()));
                    }
                }
            }
        }
        aoVar = this.eye.exP;
        aoVar.aOb();
    }
}
