package com.baidu.tieba.runing;

import android.os.Handler;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.e;
import com.baidu.adp.framework.task.SocketMessageTask;
import com.baidu.tieba.message.ResponseQueryCollectUpdateNumMessage;
/* loaded from: classes.dex */
public class a {
    private static a bLU;
    private long bLV = 0;
    private final Handler mHandler = new b(this);
    private e mListener = new c(this, 303005);

    static {
        com.baidu.tieba.tbadkCore.a.a.a(303005, ResponseQueryCollectUpdateNumMessage.class, false, SocketMessageTask.DupLicateMode.REMOVE_ME, true);
        bLU = null;
    }

    public static synchronized a abX() {
        a aVar;
        synchronized (a.class) {
            if (bLU == null) {
                bLU = new a();
            }
            aVar = bLU;
        }
        return aVar;
    }

    public a() {
        MessageManager.getInstance().registerListener(this.mListener);
    }

    public void abY() {
        this.bLV = 0L;
        destroy();
        start();
    }

    public void start() {
        long currentTimeMillis = System.currentTimeMillis() - this.bLV;
        long j = currentTimeMillis > 0 ? currentTimeMillis : 0L;
        if (j >= 1800000) {
            this.mHandler.sendMessageDelayed(this.mHandler.obtainMessage(1), 10000L);
        } else {
            this.mHandler.sendMessageDelayed(this.mHandler.obtainMessage(1), 1800000 - j);
        }
        this.bLV = System.currentTimeMillis();
    }

    public void destroy() {
        this.mHandler.removeMessages(1);
        this.mHandler.removeMessages(2);
    }
}
