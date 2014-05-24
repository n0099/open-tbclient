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
    public static final String GETMESSAGE_ONLY_ONCE = "getMessageAtOnce";
    private static final int MESSAGE_GET_BOOKMARK = 2;
    private static final int MESSAGE_GET_BOOKMARK_FREQUENCY = 1800;
    private static final int MESSAGE_GET_MESSAGE = 1;
    private static final int MESSAGE_GET_MESSAGE_ONCE = 3;
    private q mMessageAsyncTask = null;
    private q mBookmarkAsyncTask = null;
    private ab mData = null;
    private int mFlag = 0;
    private boolean isServiceRunning = false;
    private final Handler mHandler = new p(this);

    static {
        CustomMessageTask customMessageTask = new CustomMessageTask(2008001, new o());
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
        this.isServiceRunning = false;
        this.mHandler.removeMessages(1);
        this.mHandler.removeMessages(2);
        if (this.mMessageAsyncTask != null) {
            this.mMessageAsyncTask.cancel();
        }
        if (this.mBookmarkAsyncTask != null) {
            this.mBookmarkAsyncTask.cancel();
        }
    }

    @Override // android.app.Service
    public void onStart(Intent intent, int i) {
        super.onStart(intent, i);
        if (!TbadkApplication.m252getInst().isMsgRemindOn()) {
            stopSelf();
            return;
        }
        this.mFlag = 0;
        if (intent != null) {
            if (intent.getBooleanExtra(GETMESSAGE_ONLY_ONCE, false)) {
                this.mHandler.removeMessages(3);
                this.mHandler.sendEmptyMessageDelayed(3, 3000L);
            } else if (!this.isServiceRunning) {
                this.mHandler.removeMessages(1);
                this.mHandler.sendEmptyMessageDelayed(1, 3000L);
                this.isServiceRunning = true;
            }
        }
    }

    @Override // android.app.Service
    public boolean onUnbind(Intent intent) {
        return super.onUnbind(intent);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void getMsg(int i) {
        try {
            if (TbadkApplication.getCurrentAccount() != null && TbadkApplication.getCurrentAccountName() != null) {
                if (i == 1 || i == 3) {
                    if (this.mMessageAsyncTask != null) {
                        this.mMessageAsyncTask.cancel();
                    }
                    this.mMessageAsyncTask = new q(this, i);
                    this.mMessageAsyncTask.execute(new String[0]);
                } else if (i == 2) {
                    if (this.mBookmarkAsyncTask != null) {
                        this.mBookmarkAsyncTask.cancel();
                    }
                    if (this.mMessageAsyncTask != null) {
                        this.mMessageAsyncTask.cancel();
                    }
                    this.mBookmarkAsyncTask = new q(this, i);
                    this.mBookmarkAsyncTask.execute(new String[0]);
                }
            }
        } catch (Exception e) {
            BdLog.e(getClass().getName(), "getMsg", e.getMessage());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void broadcastMsg(int i) {
        if (this.mData != null && this.mData.a() >= 0 && this.mData.b() >= 0 && this.mData.c() >= 0 && this.mData.d() >= 0 && this.mData.e() >= 0) {
            if (!TbadkApplication.m252getInst().isMsgReplymeOn()) {
                this.mData.a(0);
            }
            if (!TbadkApplication.m252getInst().isMsgAtmeOn()) {
                this.mData.b(0);
            }
            if (!TbadkApplication.m252getInst().isMsgFansOn()) {
                this.mData.c(0);
            }
            if (!TbadkApplication.m252getInst().isMsgChatOn()) {
                this.mData.d(0);
            }
            Intent intent = new Intent(com.baidu.tieba.data.d.b());
            intent.putExtra("relay", this.mData.a());
            intent.putExtra("at_me", this.mData.b());
            intent.putExtra("fans", this.mData.c());
            intent.putExtra("pletter", this.mData.d());
            if (i == 1) {
                intent.putExtra("new_bookmark", com.baidu.tbadk.coreExtra.messageCenter.a.a().p());
            } else if (i == 2) {
                intent.putExtra("new_bookmark", this.mData.e());
            }
            sendBroadcast(intent);
            BdLog.i(getClass().getName(), "broadcastMsg", "sendBroadcast: " + String.format("%d %d %d %d", Integer.valueOf(this.mData.a()), Integer.valueOf(this.mData.b()), Integer.valueOf(this.mData.c()), Integer.valueOf(this.mData.e())));
        }
    }
}
