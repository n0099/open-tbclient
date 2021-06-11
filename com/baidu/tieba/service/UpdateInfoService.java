package com.baidu.tieba.service;

import android.content.Intent;
import android.location.Address;
import android.os.IBinder;
import android.text.TextUtils;
import com.baidu.adp.base.BdBaseService;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.model.ReportUserInfoModel;
import d.a.c.e.i.a;
/* loaded from: classes5.dex */
public class UpdateInfoService extends BdBaseService {
    public a.c locationCallBack = new b();
    public ReportUserInfoModel mModel;

    /* loaded from: classes5.dex */
    public class a implements ReportUserInfoModel.b {
        public a() {
        }

        @Override // com.baidu.tieba.model.ReportUserInfoModel.b
        public void a(int i2) {
            BdLog.i("location_success");
            BdLog.e("location_success next time=" + i2);
            if (i2 <= 0) {
                i2 = 3600;
            } else if (i2 >= 32400) {
                i2 = 32400;
            }
            UpdateInfoService.this.mModel.B(i2 * 1000);
        }

        @Override // com.baidu.tieba.model.ReportUserInfoModel.b
        public void onError(int i2, String str) {
            BdLog.i("location_errorCode&errorCode=" + i2 + "&errorMsg" + str);
            UpdateInfoService.this.mModel.B(600000L);
        }
    }

    /* loaded from: classes5.dex */
    public class b implements a.c {
        public b() {
        }

        @Override // d.a.c.e.i.a.c
        public void onLocationGeted(int i2, String str, Address address) {
            if (i2 == 0 && address != null) {
                float longitude = (float) address.getLongitude();
                float latitude = (float) address.getLatitude();
                d.a.n0.t2.g0.a.e().j(String.valueOf(longitude));
                d.a.n0.t2.g0.a.e().i(String.valueOf(latitude));
                d.a.n0.t2.g0.a.e().k(System.currentTimeMillis());
                if (UpdateInfoService.this.mModel.x() && TbadkCoreApplication.getInst().getLocationShared() && !TextUtils.isEmpty(TbadkCoreApplication.getCurrentAccount())) {
                    UpdateInfoService.this.mModel.z(1, longitude, latitude);
                    UpdateInfoService.this.mModel.A();
                }
            }
        }
    }

    private void findLocationFromLocal() {
        d.a.c.e.i.a.l().i(true, this.locationCallBack);
    }

    private void unRegisterLocalLocation() {
        d.a.c.e.i.a.l().q(this.locationCallBack);
    }

    @Override // android.app.Service
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override // com.baidu.adp.base.BdBaseService, android.app.Service
    public void onCreate() {
        super.onCreate();
        ReportUserInfoModel reportUserInfoModel = new ReportUserInfoModel(null);
        this.mModel = reportUserInfoModel;
        reportUserInfoModel.y();
        this.mModel.B(540000L);
        this.mModel.C(new a());
    }

    @Override // android.app.Service
    public void onDestroy() {
        super.onDestroy();
        unRegisterLocalLocation();
        this.mModel.unRegisterListener();
    }

    @Override // android.app.Service
    public void onStart(Intent intent, int i2) {
        super.onStart(intent, i2);
        if (this.mModel.x()) {
            findLocationFromLocal();
        }
    }
}
