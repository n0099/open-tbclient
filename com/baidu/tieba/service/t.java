package com.baidu.tieba.service;

import android.location.Address;
/* loaded from: classes.dex */
class t implements com.baidu.adp.lib.d.d {
    final /* synthetic */ UpdateInfoService bPd;

    /* JADX INFO: Access modifiers changed from: package-private */
    public t(UpdateInfoService updateInfoService) {
        this.bPd = updateInfoService;
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
                    rVar = this.bPd.mModel;
                    if (rVar.canSend()) {
                        rVar2 = this.bPd.mModel;
                        rVar2.a(1, longitude, latitude);
                        rVar3 = this.bPd.mModel;
                        rVar3.UP();
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
