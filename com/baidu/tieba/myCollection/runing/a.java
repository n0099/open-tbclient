package com.baidu.tieba.myCollection.runing;

import android.os.Handler;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.task.SocketMessageTask;
import com.baidu.location.a3;
import com.baidu.tieba.myCollection.message.ResponseQueryCollectUpdateNumMessage;
/* loaded from: classes.dex */
public class a {
    private static a bEF;
    private long bCZ = 0;
    private final Handler mHandler = new b(this);
    private final com.baidu.adp.framework.listener.e mListener = new c(this, 303005);

    static {
        com.baidu.tieba.tbadkCore.a.a.a(303005, ResponseQueryCollectUpdateNumMessage.class, false, SocketMessageTask.DupLicateMode.REMOVE_ME, true);
        bEF = null;
    }

    public static synchronized a Yh() {
        a aVar;
        synchronized (a.class) {
            if (bEF == null) {
                bEF = new a();
            }
            aVar = bEF;
        }
        return aVar;
    }

    public a() {
        MessageManager.getInstance().registerListener(this.mListener);
    }

    public void XC() {
        this.bCZ = 0L;
        destroy();
        start();
    }

    public void start() {
        long currentTimeMillis = System.currentTimeMillis() - this.bCZ;
        long j = currentTimeMillis > 0 ? currentTimeMillis : 0L;
        if (j >= a3.jw) {
            this.mHandler.sendMessageDelayed(this.mHandler.obtainMessage(1), 10000L);
        } else {
            this.mHandler.sendMessageDelayed(this.mHandler.obtainMessage(1), a3.jw - j);
        }
        this.bCZ = System.currentTimeMillis();
    }

    public void destroy() {
        this.mHandler.removeMessages(1);
        this.mHandler.removeMessages(2);
    }
}
