package com.baidu.tieba.pb.pb.main;

import com.baidu.tieba.pb.pb.main.view.PbFakeFloorModel;
import com.baidu.tieba.tbadkCore.data.PostData;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class hk implements PbFakeFloorModel.a {
    final /* synthetic */ gg eEv;

    /* JADX INFO: Access modifiers changed from: package-private */
    public hk(gg ggVar) {
        this.eEv = ggVar;
    }

    @Override // com.baidu.tieba.pb.pb.main.view.PbFakeFloorModel.a
    public void l(PostData postData) {
        PbFakeFloorModel pbFakeFloorModel;
        dc dcVar;
        ei eiVar;
        pbFakeFloorModel = this.eEv.eyj;
        pbFakeFloorModel.m(postData);
        dcVar = this.eEv.eCF;
        dcVar.notifyDataSetChanged();
        eiVar = this.eEv.eDQ;
        eiVar.aOB();
    }
}
