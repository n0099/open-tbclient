package com.baidu.tieba.service;

import android.location.Address;
/* loaded from: classes.dex */
class q implements com.baidu.adp.lib.d.d {
    final /* synthetic */ UpdateInfoService bZf;

    /* JADX INFO: Access modifiers changed from: package-private */
    public q(UpdateInfoService updateInfoService) {
        this.bZf = updateInfoService;
    }

    @Override // com.baidu.adp.lib.d.d
    public void b(int i, String str, Address address) {
        com.baidu.tieba.a.g gVar;
        com.baidu.tieba.a.g gVar2;
        com.baidu.tieba.a.g gVar3;
        switch (i) {
            case 0:
                if (address != null) {
                    float longitude = (float) address.getLongitude();
                    float latitude = (float) address.getLatitude();
                    gVar = this.bZf.mModel;
                    if (gVar.canSend()) {
                        gVar2 = this.bZf.mModel;
                        gVar2.a(1, longitude, latitude);
                        gVar3 = this.bZf.mModel;
                        gVar3.XK();
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
