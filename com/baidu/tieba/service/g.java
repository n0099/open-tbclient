package com.baidu.tieba.service;

import android.location.Address;
import android.text.TextUtils;
import com.baidu.adp.lib.d.a;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.model.ReportUserInfoModel;
/* loaded from: classes.dex */
class g implements a.InterfaceC0004a {
    final /* synthetic */ UpdateInfoService feY;

    /* JADX INFO: Access modifiers changed from: package-private */
    public g(UpdateInfoService updateInfoService) {
        this.feY = updateInfoService;
    }

    @Override // com.baidu.adp.lib.d.a.InterfaceC0004a
    public void b(int i, String str, Address address) {
        ReportUserInfoModel reportUserInfoModel;
        ReportUserInfoModel reportUserInfoModel2;
        ReportUserInfoModel reportUserInfoModel3;
        switch (i) {
            case 0:
                if (address != null) {
                    float longitude = (float) address.getLongitude();
                    float latitude = (float) address.getLatitude();
                    com.baidu.tieba.recapp.d.a.aYU().setLongitude(String.valueOf(longitude));
                    com.baidu.tieba.recapp.d.a.aYU().setLatitude(String.valueOf(latitude));
                    com.baidu.tieba.recapp.d.a.aYU().ch(System.currentTimeMillis());
                    reportUserInfoModel = this.feY.mModel;
                    if (reportUserInfoModel.aDf() && TbadkCoreApplication.m9getInst().getLocationShared() && !TextUtils.isEmpty(TbadkCoreApplication.getCurrentAccount())) {
                        reportUserInfoModel2 = this.feY.mModel;
                        reportUserInfoModel2.b(1, longitude, latitude);
                        reportUserInfoModel3 = this.feY.mModel;
                        reportUserInfoModel3.aDg();
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
