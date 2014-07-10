package com.baidu.tieba.service;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.text.TextUtils;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.atomData.bh;
import com.baidu.tieba.model.ax;
/* loaded from: classes.dex */
public class ReportUserInfoService extends Service {
    private com.baidu.adp.lib.c.d locationCallBack = new k(this);
    private ax mModel;

    static {
        TbadkApplication.m252getInst().RegisterIntent(bh.class, ReportUserInfoService.class);
    }

    @Override // android.app.Service
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override // android.app.Service
    public void onCreate() {
        super.onCreate();
        this.mModel = new ax();
        this.mModel.b();
        this.mModel.a(new l(this));
        ((AlarmManager) getSystemService("alarm")).setRepeating(0, System.currentTimeMillis() + 14400000, 14400000L, PendingIntent.getService(this, 0, new Intent(this, ReportUserInfoService.class), 0));
    }

    @Override // android.app.Service
    public void onStart(Intent intent, int i) {
        super.onStart(intent, i);
        if (!TextUtils.isEmpty(TbadkApplication.getCurrentAccount()) && TbadkApplication.m252getInst().getLocationShared()) {
            findLocationFromLocal();
        }
    }

    @Override // android.app.Service
    public void onDestroy() {
        super.onDestroy();
        unRegisterLocalLocation();
        this.mModel.c();
    }

    private void findLocationFromLocal() {
        com.baidu.adp.lib.c.a.a().a(true, this.locationCallBack);
    }

    private void unRegisterLocalLocation() {
        com.baidu.adp.lib.c.a.a().a(this.locationCallBack);
    }
}
