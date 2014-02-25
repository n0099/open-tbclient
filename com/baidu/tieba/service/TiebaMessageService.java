package com.baidu.tieba.service;

import android.app.Service;
import android.content.Intent;
import android.os.Handler;
import android.os.IBinder;
import com.baidu.tieba.TiebaApplication;
import com.baidu.tieba.data.ai;
import com.baidu.tieba.mention.v;
/* loaded from: classes.dex */
public class TiebaMessageService extends Service {
    private m a = null;
    private m b = null;
    private ai c = null;
    private int d = 0;
    private boolean e = false;
    private Handler f = new l(this);

    @Override // android.app.Service
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override // android.app.Service
    public void onDestroy() {
        super.onDestroy();
        this.e = false;
        this.f.removeMessages(1);
        this.f.removeMessages(2);
        if (this.a != null) {
            this.a.cancel();
        }
        if (this.b != null) {
            this.b.cancel();
        }
    }

    @Override // android.app.Service
    public void onStart(Intent intent, int i) {
        super.onStart(intent, i);
        if (!TiebaApplication.g().Z()) {
            stopSelf();
            return;
        }
        this.d = 0;
        if (intent != null) {
            if (intent.getBooleanExtra("getMessageAtOnce", false)) {
                this.f.removeMessages(3);
                this.f.sendEmptyMessageDelayed(3, 3000L);
            } else if (!this.e) {
                this.f.removeMessages(1);
                this.f.sendEmptyMessageDelayed(1, 3000L);
                this.e = true;
            }
        }
    }

    @Override // android.app.Service
    public boolean onUnbind(Intent intent) {
        return super.onUnbind(intent);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(int i) {
        try {
            if (TiebaApplication.A() != null && TiebaApplication.F() != null) {
                if (i == 1 || i == 3) {
                    if (this.a != null) {
                        this.a.cancel();
                    }
                    this.a = new m(this, i);
                    this.a.execute(new String[0]);
                } else if (i == 2) {
                    if (this.b != null) {
                        this.b.cancel();
                    }
                    if (this.a != null) {
                        this.a.cancel();
                    }
                    this.b = new m(this, i);
                    this.b.execute(new String[0]);
                }
            }
        } catch (Exception e) {
            com.baidu.adp.lib.util.f.b(getClass().getName(), "getMsg", e.getMessage());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(int i) {
        if (this.c != null && this.c.a() >= 0 && this.c.b() >= 0 && this.c.c() >= 0 && this.c.d() >= 0 && this.c.e() >= 0) {
            if (!TiebaApplication.g().W()) {
                this.c.a(0);
            }
            if (!TiebaApplication.g().V()) {
                this.c.b(0);
            }
            if (!TiebaApplication.g().U()) {
                this.c.c(0);
            }
            if (!TiebaApplication.g().X()) {
                this.c.d(0);
            }
            Intent intent = new Intent(com.baidu.tieba.data.i.e());
            intent.putExtra("relay", this.c.a());
            intent.putExtra("at_me", this.c.b());
            intent.putExtra("fans", this.c.c());
            intent.putExtra("pletter", this.c.d());
            if (i == 1) {
                intent.putExtra("new_bookmark", v.a().r());
            } else if (i == 2) {
                intent.putExtra("new_bookmark", this.c.e());
            }
            sendBroadcast(intent);
            com.baidu.adp.lib.util.f.a(getClass().getName(), "broadcastMsg", "sendBroadcast: " + String.format("%d %d %d %d", Integer.valueOf(this.c.a()), Integer.valueOf(this.c.b()), Integer.valueOf(this.c.c()), Integer.valueOf(this.c.e())));
        }
    }
}
