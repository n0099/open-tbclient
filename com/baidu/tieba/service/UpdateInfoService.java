package com.baidu.tieba.service;

import android.content.Intent;
import android.os.IBinder;
import android.text.TextUtils;
import com.baidu.adp.base.BdBaseService;
import com.baidu.adp.lib.e.a;
import com.baidu.tbadk.core.TbadkCoreApplication;
/* loaded from: classes.dex */
public class UpdateInfoService extends BdBaseService {
    private a.InterfaceC0005a locationCallBack = new h(this);
    private com.baidu.tieba.model.c mModel;

    @Override // android.app.Service
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override // com.baidu.adp.base.BdBaseService, android.app.Service
    public void onCreate() {
        super.onCreate();
        this.mModel = new com.baidu.tieba.model.c(null);
        this.mModel.atJ();
        this.mModel.bA(540000L);
        this.mModel.a(new i(this));
    }

    @Override // android.app.Service
    public void onStart(Intent intent, int i) {
        super.onStart(intent, i);
        if (!TextUtils.isEmpty(TbadkCoreApplication.getCurrentAccount()) && TbadkCoreApplication.m11getInst().getLocationShared() && this.mModel.atH()) {
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
        com.baidu.adp.lib.e.a.cZ().a(true, this.locationCallBack);
    }

    private void unRegisterLocalLocation() {
        com.baidu.adp.lib.e.a.cZ().a(this.locationCallBack);
    }
}
