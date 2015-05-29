package com.baidu.tieba.service;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
/* loaded from: classes.dex */
public class HandleSSOService extends Service {
    private com.baidu.tieba.a serviceImpl;

    @Override // android.app.Service
    public void onCreate() {
        super.onCreate();
        this.serviceImpl = createHandleSSOServiceImpl();
        if (this.serviceImpl != null) {
            this.serviceImpl.onCreate();
        }
    }

    @Override // android.app.Service
    public void onStart(Intent intent, int i) {
        super.onStart(intent, i);
    }

    @Override // android.app.Service
    public IBinder onBind(Intent intent) {
        if (this.serviceImpl != null) {
            return this.serviceImpl.onBind(intent);
        }
        return null;
    }

    @Override // android.app.Service
    public void onDestroy() {
        super.onDestroy();
        if (this.serviceImpl != null) {
            this.serviceImpl.onDestroy();
        }
        this.serviceImpl = null;
    }

    private com.baidu.tieba.a createHandleSSOServiceImpl() {
        CustomResponsedMessage runTask = MessageManager.getInstance().runTask(2902060, com.baidu.tieba.a.class);
        if (runTask != null) {
            return (com.baidu.tieba.a) runTask.getData();
        }
        return null;
    }
}
