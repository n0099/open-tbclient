package com.baidu.tieba.service;

import android.location.Address;
import com.baidu.adp.lib.e.a;
/* loaded from: classes.dex */
class h implements a.InterfaceC0005a {
    final /* synthetic */ UpdateInfoService fge;

    /* JADX INFO: Access modifiers changed from: package-private */
    public h(UpdateInfoService updateInfoService) {
        this.fge = updateInfoService;
    }

    @Override // com.baidu.adp.lib.e.a.InterfaceC0005a
    public void b(int i, String str, Address address) {
        com.baidu.tieba.model.e eVar;
        com.baidu.tieba.model.e eVar2;
        com.baidu.tieba.model.e eVar3;
        switch (i) {
            case 0:
                if (address != null) {
                    float longitude = (float) address.getLongitude();
                    float latitude = (float) address.getLatitude();
                    eVar = this.fge.mModel;
                    if (eVar.aIf()) {
                        eVar2 = this.fge.mModel;
                        eVar2.b(1, longitude, latitude);
                        eVar3 = this.fge.mModel;
                        eVar3.aIg();
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
