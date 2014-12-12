package com.baidu.tieba.service;

import android.content.Intent;
import android.os.IBinder;
import android.text.TextUtils;
import com.baidu.adp.base.BdBaseService;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.UpdateInfoServiceConfig;
/* loaded from: classes.dex */
public class UpdateInfoService extends BdBaseService {
    private com.baidu.adp.lib.d.d locationCallBack = new u(this);
    private com.baidu.tieba.model.r mModel;

    static {
        TbadkCoreApplication.m255getInst().RegisterIntent(UpdateInfoServiceConfig.class, UpdateInfoService.class);
    }

    @Override // android.app.Service
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override // android.app.Service
    public void onCreate() {
        super.onCreate();
        this.mModel = new com.baidu.tieba.model.r(null);
        this.mModel.Us();
        this.mModel.ah(540000L);
        this.mModel.a(new v(this));
    }

    @Override // android.app.Service
    public void onStart(Intent intent, int i) {
        super.onStart(intent, i);
        if (!TextUtils.isEmpty(TbadkCoreApplication.getCurrentAccount()) && TbadkCoreApplication.m255getInst().getLocationShared() && this.mModel.canSend()) {
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
        com.baidu.adp.lib.d.a.dD().a(true, this.locationCallBack);
    }

    private void unRegisterLocalLocation() {
        com.baidu.adp.lib.d.a.dD().a(this.locationCallBack);
    }
}
