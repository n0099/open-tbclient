package com.baidu.tieba.service;

import android.content.Intent;
import android.location.Address;
import android.os.IBinder;
import android.text.TextUtils;
import com.baidu.adp.base.BdBaseService;
import com.baidu.adp.lib.d.a;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.keepLive.jobScheduler.KeepJobService;
import com.baidu.tieba.model.ReportUserInfoModel;
/* loaded from: classes.dex */
public class UpdateInfoService extends BdBaseService {
    private a.InterfaceC0015a locationCallBack = new a.InterfaceC0015a() { // from class: com.baidu.tieba.service.UpdateInfoService.2
        @Override // com.baidu.adp.lib.d.a.InterfaceC0015a
        public void b(int i, String str, Address address) {
            switch (i) {
                case 0:
                    if (address != null) {
                        float longitude = (float) address.getLongitude();
                        float latitude = (float) address.getLatitude();
                        com.baidu.tieba.recapp.d.a.ciL().yC(String.valueOf(longitude));
                        com.baidu.tieba.recapp.d.a.ciL().yD(String.valueOf(latitude));
                        com.baidu.tieba.recapp.d.a.ciL().et(System.currentTimeMillis());
                        if (UpdateInfoService.this.mModel.bOF() && TbadkCoreApplication.getInst().getLocationShared() && !TextUtils.isEmpty(TbadkCoreApplication.getCurrentAccount())) {
                            UpdateInfoService.this.mModel.a(1, longitude, latitude);
                            UpdateInfoService.this.mModel.bOG();
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
        this.mModel.bOH();
        this.mModel.eb(540000L);
        this.mModel.a(new ReportUserInfoModel.a() { // from class: com.baidu.tieba.service.UpdateInfoService.1
            @Override // com.baidu.tieba.model.ReportUserInfoModel.a
            public void xl(int i) {
                BdLog.i("location_success");
                BdLog.e("location_success next time=" + i);
                if (i <= 0) {
                    i = 3600;
                } else if (i >= 32400) {
                    i = 32400;
                }
                UpdateInfoService.this.mModel.eb(i * 1000);
            }

            @Override // com.baidu.tieba.model.ReportUserInfoModel.a
            public void onError(int i, String str) {
                BdLog.i("location_errorCode&errorCode=" + i + "&errorMsg" + str);
                UpdateInfoService.this.mModel.eb(KeepJobService.JOB_CHECK_PERIODIC);
            }
        });
    }

    @Override // android.app.Service
    public void onStart(Intent intent, int i) {
        super.onStart(intent, i);
        if (this.mModel.bOF()) {
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
        a.hY().a(true, this.locationCallBack);
    }

    private void unRegisterLocalLocation() {
        a.hY().a(this.locationCallBack);
    }
}
