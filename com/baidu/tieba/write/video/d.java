package com.baidu.tieba.write.video;

import com.baidu.tbadk.core.dialog.a;
import com.baidu.tieba.tbadkCore.location.LocationModel;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class d implements a.b {
    final /* synthetic */ WriteLocationView fPn;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(WriteLocationView writeLocationView) {
        this.fPn = writeLocationView;
    }

    @Override // com.baidu.tbadk.core.dialog.a.b
    public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
        LocationModel.a aVar2;
        LocationModel locationModel;
        if (!com.baidu.adp.lib.util.i.hk()) {
            aVar2 = this.fPn.aBd;
            aVar2.Dj();
        } else {
            this.fPn.c(1, true, null);
            locationModel = this.fPn.aAO;
            locationModel.Qy();
        }
        aVar.dismiss();
    }
}
