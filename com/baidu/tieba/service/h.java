package com.baidu.tieba.service;

import android.location.Address;
import com.baidu.adp.lib.d.a;
/* loaded from: classes.dex */
class h implements a.InterfaceC0003a {
    final /* synthetic */ UpdateInfoService cDE;

    /* JADX INFO: Access modifiers changed from: package-private */
    public h(UpdateInfoService updateInfoService) {
        this.cDE = updateInfoService;
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
                    dVar = this.cDE.mModel;
                    if (dVar.abR()) {
                        dVar2 = this.cDE.mModel;
                        dVar2.a(1, longitude, latitude);
                        dVar3 = this.cDE.mModel;
                        dVar3.abS();
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
