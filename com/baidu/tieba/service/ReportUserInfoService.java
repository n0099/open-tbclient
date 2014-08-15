package com.baidu.tieba.service;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.text.TextUtils;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.atomData.bp;
import com.baidu.tieba.model.ay;
/* loaded from: classes.dex */
public class ReportUserInfoService extends Service {
    private com.baidu.adp.lib.c.d locationCallBack = new k(this);
    private ay mModel;

    static {
        TbadkApplication.m252getInst().RegisterIntent(bp.class, ReportUserInfoService.class);
    }

    @Override // android.app.Service
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override // android.app.Service
    public void onCreate() {
        super.onCreate();
        this.mModel = new ay();
        this.mModel.c();
        this.mModel.a(new l(this));
    }

    @Override // android.app.Service
    public void onStart(Intent intent, int i) {
        super.onStart(intent, i);
        if (!TextUtils.isEmpty(TbadkApplication.getCurrentAccount()) && TbadkApplication.m252getInst().getLocationShared() && this.mModel.a()) {
            findLocationFromLocal();
        }
    }

    @Override // android.app.Service
    public void onDestroy() {
        super.onDestroy();
        unRegisterLocalLocation();
        this.mModel.d();
    }

    private void findLocationFromLocal() {
        com.baidu.adp.lib.c.a.a().a(true, this.locationCallBack);
    }

    private void unRegisterLocalLocation() {
        com.baidu.adp.lib.c.a.a().a(this.locationCallBack);
    }
}
