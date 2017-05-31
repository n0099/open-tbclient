package com.baidu.tieba.pb.pb.main;

import com.baidu.tieba.pb.pb.main.view.PbFakeFloorModel;
import com.baidu.tieba.tbadkCore.data.PostData;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class gz implements PbFakeFloorModel.a {
    final /* synthetic */ fx evi;

    /* JADX INFO: Access modifiers changed from: package-private */
    public gz(fx fxVar) {
        this.evi = fxVar;
    }

    @Override // com.baidu.tieba.pb.pb.main.view.PbFakeFloorModel.a
    public void j(PostData postData) {
        PbFakeFloorModel pbFakeFloorModel;
        cv cvVar;
        dz dzVar;
        pbFakeFloorModel = this.evi.epa;
        pbFakeFloorModel.k(postData);
        cvVar = this.evi.etv;
        cvVar.notifyDataSetChanged();
        dzVar = this.evi.euD;
        dzVar.aKE();
    }
}
