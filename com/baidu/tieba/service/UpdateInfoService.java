package com.baidu.tieba.service;

import android.content.Intent;
import android.os.IBinder;
import com.baidu.adp.base.BdBaseService;
import com.baidu.adp.lib.e.a;
/* loaded from: classes.dex */
public class UpdateInfoService extends BdBaseService {
    private a.InterfaceC0005a locationCallBack = new h(this);
    private com.baidu.tieba.model.e mModel;

    @Override // android.app.Service
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override // com.baidu.adp.base.BdBaseService, android.app.Service
    public void onCreate() {
        super.onCreate();
        this.mModel = new com.baidu.tieba.model.e(null);
        this.mModel.aKc();
        this.mModel.cr(540000L);
        this.mModel.a(new i(this));
    }

    @Override // android.app.Service
    public void onStart(Intent intent, int i) {
        super.onStart(intent, i);
        if (this.mModel.aKa()) {
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
        com.baidu.adp.lib.e.a.dU().a(true, this.locationCallBack);
    }

    private void unRegisterLocalLocation() {
        com.baidu.adp.lib.e.a.dU().a(this.locationCallBack);
    }
}
