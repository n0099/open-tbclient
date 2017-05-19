package com.baidu.tieba.pb.pb.main;

import com.baidu.tieba.pb.pb.main.view.PbFakeFloorModel;
import com.baidu.tieba.tbadkCore.data.PostData;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class gr implements PbFakeFloorModel.a {
    final /* synthetic */ fm epr;

    /* JADX INFO: Access modifiers changed from: package-private */
    public gr(fm fmVar) {
        this.epr = fmVar;
    }

    @Override // com.baidu.tieba.pb.pb.main.view.PbFakeFloorModel.a
    public void j(PostData postData) {
        PbFakeFloorModel pbFakeFloorModel;
        cq cqVar;
        dq dqVar;
        pbFakeFloorModel = this.epr.ejo;
        pbFakeFloorModel.k(postData);
        cqVar = this.epr.enG;
        cqVar.notifyDataSetChanged();
        dqVar = this.epr.eoN;
        dqVar.aJK();
    }
}
