package com.baidu.tieba.pb.pb.main;

import com.baidu.tieba.pb.pb.main.view.PbFakeFloorModel;
import com.baidu.tieba.tbadkCore.data.PostData;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class gi implements PbFakeFloorModel.a {
    final /* synthetic */ ey etN;

    /* JADX INFO: Access modifiers changed from: package-private */
    public gi(ey eyVar) {
        this.etN = eyVar;
    }

    @Override // com.baidu.tieba.pb.pb.main.view.PbFakeFloorModel.a
    public void i(PostData postData) {
        PbFakeFloorModel pbFakeFloorModel;
        cn cnVar;
        dc dcVar;
        pbFakeFloorModel = this.etN.ens;
        pbFakeFloorModel.j(postData);
        cnVar = this.etN.erY;
        cnVar.notifyDataSetChanged();
        dcVar = this.etN.etg;
        dcVar.aMl();
    }
}
