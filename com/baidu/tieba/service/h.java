package com.baidu.tieba.service;

import android.location.Address;
import com.baidu.adp.lib.e.a;
/* loaded from: classes.dex */
class h implements a.InterfaceC0005a {
    final /* synthetic */ UpdateInfoService eVl;

    /* JADX INFO: Access modifiers changed from: package-private */
    public h(UpdateInfoService updateInfoService) {
        this.eVl = updateInfoService;
    }

    @Override // com.baidu.adp.lib.e.a.InterfaceC0005a
    public void b(int i, String str, Address address) {
        com.baidu.tieba.model.c cVar;
        com.baidu.tieba.model.c cVar2;
        com.baidu.tieba.model.c cVar3;
        switch (i) {
            case 0:
                if (address != null) {
                    float longitude = (float) address.getLongitude();
                    float latitude = (float) address.getLatitude();
                    cVar = this.eVl.mModel;
                    if (cVar.aCQ()) {
                        cVar2 = this.eVl.mModel;
                        cVar2.b(1, longitude, latitude);
                        cVar3 = this.eVl.mModel;
                        cVar3.aCR();
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
