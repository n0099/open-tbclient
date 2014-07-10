package com.baidu.tieba.service;

import android.location.Address;
import com.baidu.tbadk.TbConfig;
import com.baidu.tieba.model.ax;
/* loaded from: classes.dex */
class k implements com.baidu.adp.lib.c.d {
    final /* synthetic */ ReportUserInfoService a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public k(ReportUserInfoService reportUserInfoService) {
        this.a = reportUserInfoService;
    }

    @Override // com.baidu.adp.lib.c.d
    public void a(int i, String str, Address address) {
        ax axVar;
        ax axVar2;
        ax axVar3;
        switch (i) {
            case 0:
                if (address != null) {
                    float longitude = (float) address.getLongitude();
                    float latitude = (float) address.getLatitude();
                    long currentTimeMillis = System.currentTimeMillis();
                    axVar = this.a.mModel;
                    if (Math.abs(currentTimeMillis - axVar.a()) > TbConfig.USE_TIME_INTERVAL) {
                        axVar2 = this.a.mModel;
                        axVar2.a(System.currentTimeMillis());
                        axVar3 = this.a.mModel;
                        axVar3.a(1, longitude, latitude);
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
