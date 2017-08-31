package com.baidu.tieba.service;

import android.content.Intent;
import android.location.Address;
import android.os.IBinder;
import android.text.TextUtils;
import com.baidu.adp.base.BdBaseService;
import com.baidu.adp.lib.d.a;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.model.ReportUserInfoModel;
/* loaded from: classes.dex */
public class UpdateInfoService extends BdBaseService {
    private a.InterfaceC0004a locationCallBack = new a.InterfaceC0004a() { // from class: com.baidu.tieba.service.UpdateInfoService.2
        @Override // com.baidu.adp.lib.d.a.InterfaceC0004a
        public void b(int i, String str, Address address) {
            switch (i) {
                case 0:
                    if (address != null) {
                        float longitude = (float) address.getLongitude();
                        float latitude = (float) address.getLatitude();
                        com.baidu.tieba.recapp.d.a.bhI().mh(String.valueOf(longitude));
                        com.baidu.tieba.recapp.d.a.bhI().mi(String.valueOf(latitude));
                        com.baidu.tieba.recapp.d.a.bhI().cA(System.currentTimeMillis());
                        if (UpdateInfoService.this.mModel.aMr() && TbadkCoreApplication.getInst().getLocationShared() && !TextUtils.isEmpty(TbadkCoreApplication.getCurrentAccount())) {
                            UpdateInfoService.this.mModel.b(1, longitude, latitude);
                            UpdateInfoService.this.mModel.aMs();
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
        this.mModel.aMt();
        this.mModel.ci(540000L);
        this.mModel.a(new ReportUserInfoModel.a() { // from class: com.baidu.tieba.service.UpdateInfoService.1
            @Override // com.baidu.tieba.model.ReportUserInfoModel.a
            public void oP(int i) {
                BdLog.i("location_success");
                BdLog.e("location_success next time=" + i);
                if (i <= 0) {
                    i = 3600;
                } else if (i >= 32400) {
                    i = 32400;
                }
                UpdateInfoService.this.mModel.ci(i * 1000);
                TbadkCoreApplication.getInst().getAlarmManager().a(com.baidu.tbadk.b.a.Qy, 1, System.currentTimeMillis() + (i * 1000), i * 1000);
            }

            @Override // com.baidu.tieba.model.ReportUserInfoModel.a
            public void onError(int i, String str) {
                BdLog.i("location_errorCode&errorCode=" + i + "&errorMsg" + str);
                UpdateInfoService.this.mModel.ci(600000L);
                TbadkCoreApplication.getInst().getAlarmManager().a(com.baidu.tbadk.b.a.Qy, 1, System.currentTimeMillis() + 600000, 600000L);
            }
        });
    }

    @Override // android.app.Service
    public void onStart(Intent intent, int i) {
        super.onStart(intent, i);
        if (this.mModel.aMr()) {
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
        a.fd().a(true, this.locationCallBack);
    }

    private void unRegisterLocalLocation() {
        a.fd().a(this.locationCallBack);
    }
}
