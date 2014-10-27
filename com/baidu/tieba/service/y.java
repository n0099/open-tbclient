package com.baidu.tieba.service;

import android.location.Address;
import com.baidu.tieba.model.av;
/* loaded from: classes.dex */
class y implements com.baidu.adp.lib.d.d {
    final /* synthetic */ UpdateInfoService bIU;

    /* JADX INFO: Access modifiers changed from: package-private */
    public y(UpdateInfoService updateInfoService) {
        this.bIU = updateInfoService;
    }

    @Override // com.baidu.adp.lib.d.d
    public void OnLocationGeted(int i, String str, Address address) {
        av avVar;
        av avVar2;
        av avVar3;
        switch (i) {
            case 0:
                if (address != null) {
                    float longitude = (float) address.getLongitude();
                    float latitude = (float) address.getLatitude();
                    avVar = this.bIU.mModel;
                    if (avVar.TU()) {
                        avVar2 = this.bIU.mModel;
                        avVar2.a(1, longitude, latitude);
                        avVar3 = this.bIU.mModel;
                        avVar3.TV();
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
