package com.baidu.tieba.service;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.text.TextUtils;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.atomData.UpdateInfoServiceConfig;
import com.baidu.tieba.model.av;
/* loaded from: classes.dex */
public class UpdateInfoService extends Service {
    private com.baidu.adp.lib.d.d locationCallBack = new y(this);
    private av mModel;

    static {
        TbadkApplication.m251getInst().RegisterIntent(UpdateInfoServiceConfig.class, UpdateInfoService.class);
    }

    @Override // android.app.Service
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override // android.app.Service
    public void onCreate() {
        super.onCreate();
        this.mModel = new av(null);
        this.mModel.TW();
        this.mModel.W(540000L);
        this.mModel.a(new z(this));
    }

    @Override // android.app.Service
    public void onStart(Intent intent, int i) {
        super.onStart(intent, i);
        if (!TextUtils.isEmpty(TbadkApplication.getCurrentAccount()) && TbadkApplication.m251getInst().getLocationShared() && this.mModel.TU()) {
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
        com.baidu.adp.lib.d.a.dE().a(true, this.locationCallBack);
    }

    private void unRegisterLocalLocation() {
        com.baidu.adp.lib.d.a.dE().a(this.locationCallBack);
    }
}
