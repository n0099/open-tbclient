package com.baidu.tieba.pb.pb.main;

import com.baidu.tieba.pb.pb.main.view.PbFakeFloorModel;
import com.baidu.tieba.tbadkCore.data.PostData;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class gi implements PbFakeFloorModel.a {
    final /* synthetic */ ey erv;

    /* JADX INFO: Access modifiers changed from: package-private */
    public gi(ey eyVar) {
        this.erv = eyVar;
    }

    @Override // com.baidu.tieba.pb.pb.main.view.PbFakeFloorModel.a
    public void i(PostData postData) {
        PbFakeFloorModel pbFakeFloorModel;
        cn cnVar;
        dc dcVar;
        pbFakeFloorModel = this.erv.ela;
        pbFakeFloorModel.j(postData);
        cnVar = this.erv.epH;
        cnVar.notifyDataSetChanged();
        dcVar = this.erv.eqO;
        dcVar.aLk();
    }
}
