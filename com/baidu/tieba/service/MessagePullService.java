package com.baidu.tieba.service;

import android.app.Service;
import android.content.Intent;
import android.os.Handler;
import android.os.IBinder;
import com.baidu.tieba.TiebaApplication;
import com.baidu.tieba.data.au;
import com.baidu.tieba.util.aq;
import java.util.Random;
/* loaded from: classes.dex */
public class MessagePullService extends Service {

    /* renamed from: a  reason: collision with root package name */
    private f f1703a = null;
    private au b = null;
    private Runnable c = new e(this);
    private Handler d;

    @Override // android.app.Service
    public void onCreate() {
        super.onCreate();
        this.b = new au();
        this.d = new Handler();
        Random random = new Random(System.currentTimeMillis());
        aq.a(getClass().getName(), "onCreate", "Create message service");
        if (TiebaApplication.g().U()) {
            this.d.removeCallbacks(this.c);
            this.d.postDelayed(this.c, random.nextLong() % com.baidu.tieba.data.g.c.longValue());
            return;
        }
        stopSelf();
    }

    @Override // android.app.Service
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override // android.app.Service
    public void onStart(Intent intent, int i) {
        super.onStart(intent, i);
    }

    @Override // android.app.Service
    public void onDestroy() {
        super.onDestroy();
        this.d.removeCallbacks(this.c);
        if (this.f1703a != null) {
            this.f1703a.cancel(true);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a() {
        if (this.f1703a != null) {
            this.f1703a.cancel();
        }
        this.f1703a = new f(this, null);
        this.f1703a.execute(new String[0]);
    }
}
