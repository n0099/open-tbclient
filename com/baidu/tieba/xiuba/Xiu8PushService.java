package com.baidu.tieba.xiuba;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import com.baidu.adp.plugin.PluginCenter;
import com.baidu.tbadk.plugins.XiubaPlugin;
/* loaded from: classes.dex */
public class Xiu8PushService extends Service {
    private XiubaPlugin xiubaPlugin;

    @Override // android.app.Service
    public void onCreate() {
        super.onCreate();
        this.xiubaPlugin = (XiubaPlugin) PluginCenter.gW().hd();
        if (this.xiubaPlugin != null) {
            this.xiubaPlugin.Xiu8PushService_onCreate(this);
        }
    }

    @Override // android.app.Service
    public int onStartCommand(Intent intent, int i, int i2) {
        return this.xiubaPlugin != null ? this.xiubaPlugin.Xiu8PushService_onStartCommand(intent, i, i2) : super.onStartCommand(intent, i, i2);
    }

    @Override // android.app.Service
    public void onDestroy() {
        super.onDestroy();
        if (this.xiubaPlugin != null) {
            this.xiubaPlugin.Xiu8PushService_onDestroy();
        }
    }

    @Override // android.app.Service
    public IBinder onBind(Intent intent) {
        return null;
    }
}
