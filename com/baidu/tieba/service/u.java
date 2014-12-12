package com.baidu.tieba.service;

import android.location.Address;
/* loaded from: classes.dex */
class u implements com.baidu.adp.lib.d.d {
    final /* synthetic */ UpdateInfoService bNt;

    /* JADX INFO: Access modifiers changed from: package-private */
    public u(UpdateInfoService updateInfoService) {
        this.bNt = updateInfoService;
    }

    @Override // com.baidu.adp.lib.d.d
    public void b(int i, String str, Address address) {
        com.baidu.tieba.model.r rVar;
        com.baidu.tieba.model.r rVar2;
        com.baidu.tieba.model.r rVar3;
        switch (i) {
            case 0:
                if (address != null) {
                    float longitude = (float) address.getLongitude();
                    float latitude = (float) address.getLatitude();
                    rVar = this.bNt.mModel;
                    if (rVar.canSend()) {
                        rVar2 = this.bNt.mModel;
                        rVar2.a(1, longitude, latitude);
                        rVar3 = this.bNt.mModel;
                        rVar3.Ur();
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
