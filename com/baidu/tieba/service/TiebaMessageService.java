package com.baidu.tieba.service;

import android.app.Service;
import android.content.Intent;
import android.os.Handler;
import android.os.IBinder;
import com.baidu.tieba.TiebaApplication;
import com.baidu.tieba.data.aj;
import com.baidu.tieba.util.be;
/* loaded from: classes.dex */
public class TiebaMessageService extends Service {
    private n a = null;
    private n b = null;
    private aj c = null;
    private int d = 0;
    private boolean e = false;
    private Handler f = new m(this);

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ int b(TiebaMessageService tiebaMessageService) {
        int i = tiebaMessageService.d;
        tiebaMessageService.d = i + 1;
        return i;
    }

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
        if (!TiebaApplication.h().ab()) {
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
            if (TiebaApplication.B() != null && TiebaApplication.G() != null) {
                if (i == 1 || i == 3) {
                    if (this.a != null) {
                        this.a.cancel();
                    }
                    this.a = new n(this, i);
                    this.a.execute(new String[0]);
                } else if (i == 2) {
                    if (this.b != null) {
                        this.b.cancel();
                    }
                    if (this.a != null) {
                        this.a.cancel();
                    }
                    this.b = new n(this, i);
                    this.b.execute(new String[0]);
                }
            }
        } catch (Exception e) {
            be.b(getClass().getName(), "getMsg", e.getMessage());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(int i) {
        if (this.c != null && this.c.a() >= 0 && this.c.b() >= 0 && this.c.c() >= 0 && this.c.d() >= 0 && this.c.e() >= 0) {
            if (!TiebaApplication.h().Y()) {
                this.c.a(0L);
            }
            if (!TiebaApplication.h().X()) {
                this.c.b(0L);
            }
            if (!TiebaApplication.h().W()) {
                this.c.c(0L);
            }
            if (!TiebaApplication.h().Z()) {
                this.c.d(0L);
            }
            Intent intent = new Intent("com.baidu.tieba.broadcast.service");
            intent.putExtra("relay", this.c.a());
            intent.putExtra("at_me", this.c.b());
            intent.putExtra("fans", this.c.c());
            intent.putExtra("pletter", this.c.d());
            if (i == 1) {
                intent.putExtra("new_bookmark", com.baidu.tieba.mention.t.a().r());
            } else if (i == 2) {
                intent.putExtra("new_bookmark", this.c.e());
            }
            sendBroadcast(intent);
            be.a(getClass().getName(), "broadcastMsg", "sendBroadcast: " + String.format("%d %d %d %d", Long.valueOf(this.c.a()), Long.valueOf(this.c.b()), Long.valueOf(this.c.c()), Long.valueOf(this.c.e())));
        }
    }
}
