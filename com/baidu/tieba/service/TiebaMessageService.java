package com.baidu.tieba.service;

import android.app.Service;
import android.content.Intent;
import android.os.Handler;
import android.os.IBinder;
import com.baidu.tieba.TiebaApplication;
import com.baidu.tieba.data.aj;
import com.baidu.tieba.util.aq;
/* loaded from: classes.dex */
public class TiebaMessageService extends Service {

    /* renamed from: a  reason: collision with root package name */
    private o f1706a = null;
    private o b = null;
    private aj c = null;
    private int d = 0;
    private Handler e = new n(this);

    @Override // android.app.Service
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override // android.app.Service
    public void onDestroy() {
        super.onDestroy();
        this.e.removeMessages(1);
        this.e.removeMessages(2);
        if (this.f1706a != null) {
            this.f1706a.cancel();
        }
        if (this.b != null) {
            this.b.cancel();
        }
    }

    @Override // android.app.Service
    public void onStart(Intent intent, int i) {
        super.onStart(intent, i);
        if (!TiebaApplication.au() || !TiebaApplication.g().ab()) {
            stopSelf();
            return;
        }
        this.d = 0;
        this.e.removeMessages(1);
        this.e.sendEmptyMessageDelayed(1, 3000L);
    }

    @Override // android.app.Service
    public boolean onUnbind(Intent intent) {
        return super.onUnbind(intent);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(int i) {
        try {
            if (TiebaApplication.E() != null && TiebaApplication.I() != null) {
                if (i == 1) {
                    if (this.f1706a != null) {
                        this.f1706a.cancel();
                    }
                    this.f1706a = new o(this, i);
                    this.f1706a.execute(new String[0]);
                } else if (i == 2) {
                    if (this.b != null) {
                        this.b.cancel();
                    }
                    if (this.f1706a != null) {
                        this.f1706a.cancel();
                    }
                    this.b = new o(this, i);
                    this.b.execute(new String[0]);
                }
            }
        } catch (Exception e) {
            aq.b(getClass().getName(), "getMsg", e.getMessage());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(int i) {
        if (this.c != null && this.c.a() >= 0 && this.c.b() >= 0 && this.c.c() >= 0 && this.c.d() >= 0 && this.c.e() >= 0) {
            if (!TiebaApplication.g().aa()) {
                this.c.a(0L);
            }
            if (!TiebaApplication.g().Z()) {
                this.c.b(0L);
            }
            if (!TiebaApplication.g().Y()) {
                this.c.c(0L);
            }
            Intent intent = new Intent("com.baidu.tieba.broadcast.service");
            intent.putExtra("relay", this.c.a());
            intent.putExtra("at_me", this.c.b());
            intent.putExtra("fans", this.c.c());
            intent.putExtra("pletter", this.c.d());
            if (i == 1) {
                intent.putExtra("new_bookmark", com.baidu.tieba.mention.r.a().k());
            } else if (i == 2) {
                intent.putExtra("new_bookmark", this.c.e());
            }
            sendBroadcast(intent);
            aq.a(getClass().getName(), "broadcastMsg", "sendBroadcast: " + String.format("%d %d %d %d", Long.valueOf(this.c.a()), Long.valueOf(this.c.b()), Long.valueOf(this.c.c()), Long.valueOf(this.c.e())));
        }
    }
}
