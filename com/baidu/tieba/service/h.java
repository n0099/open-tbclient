package com.baidu.tieba.service;

import android.location.Address;
import com.baidu.adp.lib.e.a;
/* loaded from: classes.dex */
class h implements a.InterfaceC0005a {
    final /* synthetic */ UpdateInfoService eax;

    /* JADX INFO: Access modifiers changed from: package-private */
    public h(UpdateInfoService updateInfoService) {
        this.eax = updateInfoService;
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
                    cVar = this.eax.mModel;
                    if (cVar.atI()) {
                        cVar2 = this.eax.mModel;
                        cVar2.a(1, longitude, latitude);
                        cVar3 = this.eax.mModel;
                        cVar3.atJ();
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
