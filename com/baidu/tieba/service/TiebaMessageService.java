package com.baidu.tieba.service;

import android.app.Service;
import android.content.Intent;
import android.os.Handler;
import android.os.IBinder;
import com.baidu.adp.framework.task.CustomMessageTask;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tieba.data.ab;
/* loaded from: classes.dex */
public class TiebaMessageService extends Service {
    private m a = null;
    private m b = null;
    private ab c = null;
    private int d = 0;
    private boolean e = false;
    private final Handler f = new l(this);

    static {
        CustomMessageTask customMessageTask = new CustomMessageTask(2006001, new k());
        customMessageTask.a(CustomMessageTask.TASK_TYPE.SYNCHRONIZED);
        com.baidu.adp.framework.c.a().a(customMessageTask);
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
        TbadkApplication.j();
        if (!TbadkApplication.aG()) {
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

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void a(TiebaMessageService tiebaMessageService, int i) {
        try {
            if (TbadkApplication.E() == null || TbadkApplication.O() == null) {
                return;
            }
            if (i == 1 || i == 3) {
                if (tiebaMessageService.a != null) {
                    tiebaMessageService.a.cancel();
                }
                tiebaMessageService.a = new m(tiebaMessageService, i);
                tiebaMessageService.a.execute(new String[0]);
            } else if (i == 2) {
                if (tiebaMessageService.b != null) {
                    tiebaMessageService.b.cancel();
                }
                if (tiebaMessageService.a != null) {
                    tiebaMessageService.a.cancel();
                }
                tiebaMessageService.b = new m(tiebaMessageService, i);
                tiebaMessageService.b.execute(new String[0]);
            }
        } catch (Exception e) {
            com.baidu.adp.lib.util.f.b(tiebaMessageService.getClass().getName(), "getMsg", e.getMessage());
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void c(TiebaMessageService tiebaMessageService, int i) {
        if (tiebaMessageService.c == null || tiebaMessageService.c.a() < 0 || tiebaMessageService.c.b() < 0 || tiebaMessageService.c.c() < 0 || tiebaMessageService.c.d() < 0 || tiebaMessageService.c.e() < 0) {
            return;
        }
        if (!TbadkApplication.j().ak()) {
            tiebaMessageService.c.a(0);
        }
        if (!TbadkApplication.j().aj()) {
            tiebaMessageService.c.b(0);
        }
        if (!TbadkApplication.j().am()) {
            tiebaMessageService.c.c(0);
        }
        if (!TbadkApplication.j().ag()) {
            tiebaMessageService.c.d(0);
        }
        Intent intent = new Intent(com.baidu.tieba.data.d.b());
        intent.putExtra("relay", tiebaMessageService.c.a());
        intent.putExtra("at_me", tiebaMessageService.c.b());
        intent.putExtra("fans", tiebaMessageService.c.c());
        intent.putExtra("pletter", tiebaMessageService.c.d());
        if (i == 1) {
            intent.putExtra("new_bookmark", com.baidu.tbadk.coreExtra.messageCenter.a.a().n());
        } else if (i == 2) {
            intent.putExtra("new_bookmark", tiebaMessageService.c.e());
        }
        tiebaMessageService.sendBroadcast(intent);
        com.baidu.adp.lib.util.f.a(tiebaMessageService.getClass().getName(), "broadcastMsg", "sendBroadcast: " + String.format("%d %d %d %d", Integer.valueOf(tiebaMessageService.c.a()), Integer.valueOf(tiebaMessageService.c.b()), Integer.valueOf(tiebaMessageService.c.c()), Integer.valueOf(tiebaMessageService.c.e())));
    }
}
