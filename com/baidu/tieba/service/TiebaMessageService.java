package com.baidu.tieba.service;

import android.app.Service;
import android.content.Intent;
import android.os.Handler;
import android.os.IBinder;
import com.baidu.tieba.TiebaApplication;
import com.baidu.tieba.data.af;
import com.baidu.tieba.util.z;
/* loaded from: classes.dex */
public class TiebaMessageService extends Service {

    /* renamed from: a  reason: collision with root package name */
    private o f1400a = null;
    private af b = null;
    private Handler c = new n(this);

    @Override // android.app.Service
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override // android.app.Service
    public void onDestroy() {
        super.onDestroy();
        this.c.removeMessages(1);
        if (this.f1400a != null) {
            this.f1400a.cancel();
        }
    }

    @Override // android.app.Service
    public void onStart(Intent intent, int i) {
        super.onStart(intent, i);
        if (!TiebaApplication.az() || !TiebaApplication.f().aa()) {
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
            if (TiebaApplication.E() != null && TiebaApplication.H() != null) {
                if (this.f1400a != null) {
                    this.f1400a.cancel();
                }
                this.f1400a = new o(this);
                this.f1400a.execute(new String[0]);
            }
        } catch (Exception e) {
            z.b(getClass().getName(), "getMsg", e.getMessage());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b() {
        if (this.b != null && this.b.a() >= 0 && this.b.b() >= 0 && this.b.c() >= 0 && this.b.d() >= 0) {
            if (!TiebaApplication.f().Z()) {
                this.b.a(0L);
            }
            if (!TiebaApplication.f().Y()) {
                this.b.b(0L);
            }
            if (!TiebaApplication.f().X()) {
                this.b.c(0L);
            }
            Intent intent = new Intent("com.baidu.tieba.broadcast.service");
            intent.putExtra("relay", this.b.a());
            intent.putExtra("at_me", this.b.b());
            intent.putExtra("fans", this.b.c());
            intent.putExtra("pletter", this.b.d());
            sendBroadcast(intent);
            z.a(getClass().getName(), "broadcastMsg", "sendBroadcast: " + String.format("%d %d %d", Long.valueOf(this.b.a()), Long.valueOf(this.b.b()), Long.valueOf(this.b.c())));
        }
    }
}
