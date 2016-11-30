package com.baidu.tieba.service;

import android.location.Address;
import android.text.TextUtils;
import com.baidu.adp.lib.e.a;
import com.baidu.tbadk.core.TbadkCoreApplication;
/* loaded from: classes.dex */
class h implements a.InterfaceC0005a {
    final /* synthetic */ UpdateInfoService fnx;

    /* JADX INFO: Access modifiers changed from: package-private */
    public h(UpdateInfoService updateInfoService) {
        this.fnx = updateInfoService;
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
                    com.baidu.tieba.recapp.c.a.beA().setLongitude(String.valueOf(longitude));
                    com.baidu.tieba.recapp.c.a.beA().setLatitude(String.valueOf(latitude));
                    com.baidu.tieba.recapp.c.a.beA().cT(System.currentTimeMillis());
                    eVar = this.fnx.mModel;
                    if (eVar.aKa() && TbadkCoreApplication.m9getInst().getLocationShared() && !TextUtils.isEmpty(TbadkCoreApplication.getCurrentAccount())) {
                        eVar2 = this.fnx.mModel;
                        eVar2.b(1, longitude, latitude);
                        eVar3 = this.fnx.mModel;
                        eVar3.aKb();
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
