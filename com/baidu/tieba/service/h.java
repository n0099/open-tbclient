package com.baidu.tieba.service;

import android.location.Address;
import com.baidu.adp.lib.d.a;
/* loaded from: classes.dex */
class h implements a.InterfaceC0003a {
    final /* synthetic */ UpdateInfoService cLe;

    /* JADX INFO: Access modifiers changed from: package-private */
    public h(UpdateInfoService updateInfoService) {
        this.cLe = updateInfoService;
    }

    @Override // com.baidu.adp.lib.d.a.InterfaceC0003a
    public void b(int i, String str, Address address) {
        com.baidu.tieba.model.c cVar;
        com.baidu.tieba.model.c cVar2;
        com.baidu.tieba.model.c cVar3;
        switch (i) {
            case 0:
                if (address != null) {
                    float longitude = (float) address.getLongitude();
                    float latitude = (float) address.getLatitude();
                    cVar = this.cLe.mModel;
                    if (cVar.adj()) {
                        cVar2 = this.cLe.mModel;
                        cVar2.a(1, longitude, latitude);
                        cVar3 = this.cLe.mModel;
                        cVar3.adk();
                        return;
                    }
                    return;
                }
                return;
            case 1:
            case 2:
            case 3:
            default:
                return;
        }
    }
}
