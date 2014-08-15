package com.baidu.tieba.service;

import android.location.Address;
import com.baidu.tieba.model.ay;
/* loaded from: classes.dex */
class k implements com.baidu.adp.lib.c.d {
    final /* synthetic */ ReportUserInfoService a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public k(ReportUserInfoService reportUserInfoService) {
        this.a = reportUserInfoService;
    }

    @Override // com.baidu.adp.lib.c.d
    public void a(int i, String str, Address address) {
        ay ayVar;
        ay ayVar2;
        ay ayVar3;
        switch (i) {
            case 0:
                if (address != null) {
                    float longitude = (float) address.getLongitude();
                    float latitude = (float) address.getLatitude();
                    ayVar = this.a.mModel;
                    if (ayVar.a()) {
                        ayVar2 = this.a.mModel;
                        ayVar2.a(1, longitude, latitude);
                        ayVar3 = this.a.mModel;
                        ayVar3.b();
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
