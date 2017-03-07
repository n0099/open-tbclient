package com.baidu.tieba.pb.pb.main;

import com.baidu.tieba.pb.pb.main.view.PbFakeFloorModel;
import com.baidu.tieba.tbadkCore.data.PostData;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class gk implements PbFakeFloorModel.a {
    final /* synthetic */ fa etn;

    /* JADX INFO: Access modifiers changed from: package-private */
    public gk(fa faVar) {
        this.etn = faVar;
    }

    @Override // com.baidu.tieba.pb.pb.main.view.PbFakeFloorModel.a
    public void i(PostData postData) {
        PbFakeFloorModel pbFakeFloorModel;
        cp cpVar;
        de deVar;
        pbFakeFloorModel = this.etn.emS;
        pbFakeFloorModel.j(postData);
        cpVar = this.etn.ery;
        cpVar.notifyDataSetChanged();
        deVar = this.etn.esF;
        deVar.aLc();
    }
}
