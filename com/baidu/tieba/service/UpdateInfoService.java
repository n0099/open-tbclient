package com.baidu.tieba.service;

import android.content.Intent;
import android.location.Address;
import android.os.IBinder;
import android.text.TextUtils;
import com.baidu.adp.base.BdBaseService;
import com.baidu.adp.lib.c.a;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.model.ReportUserInfoModel;
import com.kwad.sdk.core.response.model.SdkConfigData;
/* loaded from: classes.dex */
public class UpdateInfoService extends BdBaseService {
    private a.InterfaceC0015a locationCallBack = new a.InterfaceC0015a() { // from class: com.baidu.tieba.service.UpdateInfoService.2
        @Override // com.baidu.adp.lib.c.a.InterfaceC0015a
        public void onLocationGeted(int i, String str, Address address) {
            switch (i) {
                case 0:
                    if (address != null) {
                        float longitude = (float) address.getLongitude();
                        float latitude = (float) address.getLatitude();
                        com.baidu.tieba.recapp.c.a.dEe().RB(String.valueOf(longitude));
                        com.baidu.tieba.recapp.c.a.dEe().RC(String.valueOf(latitude));
                        com.baidu.tieba.recapp.c.a.dEe().hB(System.currentTimeMillis());
                        if (UpdateInfoService.this.mModel.KL() && TbadkCoreApplication.getInst().getLocationShared() && !TextUtils.isEmpty(TbadkCoreApplication.getCurrentAccount())) {
                            UpdateInfoService.this.mModel.a(1, longitude, latitude);
                            UpdateInfoService.this.mModel.dgC();
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
    };
    private ReportUserInfoModel mModel;

    @Override // android.app.Service
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override // com.baidu.adp.base.BdBaseService, android.app.Service
    public void onCreate() {
        super.onCreate();
        this.mModel = new ReportUserInfoModel(null);
        this.mModel.dgD();
        this.mModel.hl(540000L);
        this.mModel.a(new ReportUserInfoModel.a() { // from class: com.baidu.tieba.service.UpdateInfoService.1
            @Override // com.baidu.tieba.model.ReportUserInfoModel.a
            public void dJ(int i) {
                BdLog.i("location_success");
                BdLog.e("location_success next time=" + i);
                if (i <= 0) {
                    i = SdkConfigData.DEFAULT_REQUEST_INTERVAL;
                } else if (i >= 32400) {
                    i = 32400;
                }
                UpdateInfoService.this.mModel.hl(i * 1000);
            }

            @Override // com.baidu.tieba.model.ReportUserInfoModel.a
            public void onError(int i, String str) {
                BdLog.i("location_errorCode&errorCode=" + i + "&errorMsg" + str);
                UpdateInfoService.this.mModel.hl(600000L);
            }
        });
    }

    @Override // android.app.Service
    public void onStart(Intent intent, int i) {
        super.onStart(intent, i);
        if (this.mModel.KL()) {
            findLocationFromLocal();
        }
    }

    @Override // android.app.Service
    public void onDestroy() {
        super.onDestroy();
        unRegisterLocalLocation();
        this.mModel.unRegisterListener();
    }

    private void findLocationFromLocal() {
        a.lH().a(true, this.locationCallBack);
    }

    private void unRegisterLocalLocation() {
        a.lH().a(this.locationCallBack);
    }
}
