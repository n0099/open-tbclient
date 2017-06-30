package com.baidu.tieba.write.write;

import com.baidu.tbadk.core.dialog.a;
import com.baidu.tieba.tbadkCore.location.LocationModel;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class v implements a.b {
    final /* synthetic */ WriteActivity glP;

    /* JADX INFO: Access modifiers changed from: package-private */
    public v(WriteActivity writeActivity) {
        this.glP = writeActivity;
    }

    @Override // com.baidu.tbadk.core.dialog.a.b
    public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
        LocationModel.a aVar2;
        LocationModel locationModel;
        if (!com.baidu.adp.lib.util.i.hj()) {
            aVar2 = this.glP.aBS;
            aVar2.Dx();
        } else {
            this.glP.b(1, true, null);
            locationModel = this.glP.aBD;
            locationModel.SC();
        }
        aVar.dismiss();
    }
}
