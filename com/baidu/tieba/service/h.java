package com.baidu.tieba.service;

import android.location.Address;
import com.baidu.adp.lib.d.a;
/* loaded from: classes.dex */
class h implements a.InterfaceC0003a {
    final /* synthetic */ UpdateInfoService cvi;

    /* JADX INFO: Access modifiers changed from: package-private */
    public h(UpdateInfoService updateInfoService) {
        this.cvi = updateInfoService;
    }

    @Override // com.baidu.adp.lib.d.a.InterfaceC0003a
    public void b(int i, String str, Address address) {
        com.baidu.tieba.a.d dVar;
        com.baidu.tieba.a.d dVar2;
        com.baidu.tieba.a.d dVar3;
        switch (i) {
            case 0:
                if (address != null) {
                    float longitude = (float) address.getLongitude();
                    float latitude = (float) address.getLatitude();
                    dVar = this.cvi.mModel;
                    if (dVar.abM()) {
                        dVar2 = this.cvi.mModel;
                        dVar2.a(1, longitude, latitude);
                        dVar3 = this.cvi.mModel;
                        dVar3.abN();
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
