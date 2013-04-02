package com.baidu.tieba.service;

import android.app.Service;
import android.content.Intent;
import android.os.Handler;
import android.os.IBinder;
import com.baidu.tieba.TiebaApplication;
import com.baidu.tieba.a.ag;
/* loaded from: classes.dex */
public class TiebaMessageService extends Service {
    private k a = null;
    private ag b = null;
    private Handler c = new j(this);

    @Override // android.app.Service
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override // android.app.Service
    public void onDestroy() {
        super.onDestroy();
        this.c.removeMessages(1);
        if (this.a != null) {
            this.a.a();
        }
    }

    @Override // android.app.Service
    public void onStart(Intent intent, int i) {
        super.onStart(intent, i);
        if (!TiebaApplication.am() || !TiebaApplication.b().V()) {
            stopSelf();
            return;
        }
        this.c.removeMessages(1);
        this.c.sendEmptyMessageDelayed(1, 3000L);
    }

    @Override // android.app.Service
    public boolean onUnbind(Intent intent) {
        return super.onUnbind(intent);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a() {
        try {
            if (TiebaApplication.y() != null && TiebaApplication.C() != null) {
                if (this.a != null) {
                    this.a.a();
                }
                this.a = new k(this);
                this.a.execute(new String[0]);
            }
        } catch (Exception e) {
            com.baidu.tieba.c.ag.b(getClass().getName(), "getMsg", e.getMessage());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b() {
        if (this.b != null && this.b.a() >= 0 && this.b.b() >= 0 && this.b.c() >= 0) {
            if (!TiebaApplication.b().U()) {
                this.b.a(0L);
            }
            if (!TiebaApplication.b().T()) {
                this.b.b(0L);
            }
            if (!TiebaApplication.b().S()) {
                this.b.c(0L);
            }
            Intent intent = new Intent("com.baidu.tieba.broadcast.service");
            intent.putExtra("relay", this.b.a());
            intent.putExtra("at_me", this.b.b());
            intent.putExtra("fans", this.b.c());
            sendBroadcast(intent);
            com.baidu.tieba.c.ag.a(getClass().getName(), "broadcastMsg", "sendBroadcast: " + String.format("%d %d %d", Long.valueOf(this.b.a()), Long.valueOf(this.b.b()), Long.valueOf(this.b.c())));
        }
    }
}
