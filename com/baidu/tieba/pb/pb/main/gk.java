package com.baidu.tieba.pb.pb.main;

import com.baidu.tieba.pb.pb.main.view.PbFakeFloorModel;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class gk implements PbFakeFloorModel.a {
    final /* synthetic */ ez eqf;

    /* JADX INFO: Access modifiers changed from: package-private */
    public gk(ez ezVar) {
        this.eqf = ezVar;
    }

    @Override // com.baidu.tieba.pb.pb.main.view.PbFakeFloorModel.a
    public void h(com.baidu.tieba.tbadkCore.data.p pVar) {
        PbFakeFloorModel pbFakeFloorModel;
        cq cqVar;
        dd ddVar;
        pbFakeFloorModel = this.eqf.ejW;
        pbFakeFloorModel.i(pVar);
        cqVar = this.eqf.eov;
        cqVar.notifyDataSetChanged();
        ddVar = this.eqf.epz;
        ddVar.aLG();
    }
}
