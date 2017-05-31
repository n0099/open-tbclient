package com.baidu.tieba.write.write;

import com.baidu.tbadk.core.dialog.a;
import com.baidu.tieba.tbadkCore.location.LocationModel;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class x implements a.b {
    final /* synthetic */ WriteActivity gaR;

    /* JADX INFO: Access modifiers changed from: package-private */
    public x(WriteActivity writeActivity) {
        this.gaR = writeActivity;
    }

    @Override // com.baidu.tbadk.core.dialog.a.b
    public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
        LocationModel.a aVar2;
        LocationModel locationModel;
        if (!com.baidu.adp.lib.util.i.hk()) {
            aVar2 = this.gaR.aAP;
            aVar2.Dd();
        } else {
            this.gaR.b(1, true, null);
            locationModel = this.gaR.aAA;
            locationModel.QK();
        }
        aVar.dismiss();
    }
}
