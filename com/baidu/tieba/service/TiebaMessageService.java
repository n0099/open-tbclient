package com.baidu.tieba.service;

import android.app.Service;
import android.content.Intent;
import android.os.Handler;
import android.os.IBinder;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.task.CustomMessageTask;
import com.baidu.adp.lib.util.BdLog;
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
        CustomMessageTask customMessageTask = new CustomMessageTask(2008001, new k());
        customMessageTask.a(CustomMessageTask.TASK_TYPE.SYNCHRONIZED);
        MessageManager.getInstance().registerTask(customMessageTask);
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
        if (!TbadkApplication.m252getInst().isMsgRemindOn()) {
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
            if (TbadkApplication.getCurrentAccount() != null && TbadkApplication.getCurrentAccountName() != null) {
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
            BdLog.e(getClass().getName(), "getMsg", e.getMessage());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(int i) {
        if (this.c != null && this.c.a() >= 0 && this.c.b() >= 0 && this.c.c() >= 0 && this.c.d() >= 0 && this.c.e() >= 0) {
            if (!TbadkApplication.m252getInst().isMsgReplymeOn()) {
                this.c.a(0);
            }
            if (!TbadkApplication.m252getInst().isMsgAtmeOn()) {
                this.c.b(0);
            }
            if (!TbadkApplication.m252getInst().isMsgFansOn()) {
                this.c.c(0);
            }
            if (!TbadkApplication.m252getInst().isMsgChatOn()) {
                this.c.d(0);
            }
            Intent intent = new Intent(com.baidu.tieba.data.d.b());
            intent.putExtra("relay", this.c.a());
            intent.putExtra("at_me", this.c.b());
            intent.putExtra("fans", this.c.c());
            intent.putExtra("pletter", this.c.d());
            if (i == 1) {
                intent.putExtra("new_bookmark", com.baidu.tbadk.coreExtra.messageCenter.a.a().p());
            } else if (i == 2) {
                intent.putExtra("new_bookmark", this.c.e());
            }
            sendBroadcast(intent);
            BdLog.i(getClass().getName(), "broadcastMsg", "sendBroadcast: " + String.format("%d %d %d %d", Integer.valueOf(this.c.a()), Integer.valueOf(this.c.b()), Integer.valueOf(this.c.c()), Integer.valueOf(this.c.e())));
        }
    }
}
