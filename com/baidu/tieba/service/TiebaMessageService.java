package com.baidu.tieba.service;

import android.app.Service;
import android.content.Intent;
import android.os.Handler;
import android.os.IBinder;
import com.baidu.tieba.TiebaApplication;
import com.baidu.tieba.a.ah;
import com.baidu.tieba.d.ae;
/* loaded from: classes.dex */
public class TiebaMessageService extends Service {
    private n a = null;
    private ah b = null;
    private Handler c = new m(this);

    @Override // android.app.Service
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override // android.app.Service
    public void onDestroy() {
        super.onDestroy();
        this.c.removeMessages(1);
        if (this.a != null) {
            this.a.cancel();
        }
    }

    @Override // android.app.Service
    public void onStart(Intent intent, int i) {
        super.onStart(intent, i);
        if (!TiebaApplication.ao() || !TiebaApplication.d().W()) {
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
            if (TiebaApplication.z() != null && TiebaApplication.D() != null) {
                if (this.a != null) {
                    this.a.cancel();
                }
                this.a = new n(this);
                this.a.execute(new String[0]);
            }
        } catch (Exception e) {
            ae.b(getClass().getName(), "getMsg", e.getMessage());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b() {
        if (this.b != null && this.b.a() >= 0 && this.b.b() >= 0 && this.b.c() >= 0) {
            if (!TiebaApplication.d().V()) {
                this.b.a(0L);
            }
            if (!TiebaApplication.d().U()) {
                this.b.b(0L);
            }
            if (!TiebaApplication.d().T()) {
                this.b.c(0L);
            }
            Intent intent = new Intent("com.baidu.tieba.broadcast.service");
            intent.putExtra("relay", this.b.a());
            intent.putExtra("at_me", this.b.b());
            intent.putExtra("fans", this.b.c());
            sendBroadcast(intent);
            ae.a(getClass().getName(), "broadcastMsg", "sendBroadcast: " + String.format("%d %d %d", Long.valueOf(this.b.a()), Long.valueOf(this.b.b()), Long.valueOf(this.b.c())));
        }
    }
}
