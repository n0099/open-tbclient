package com.baidu.tieba.runing;

import android.os.Handler;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.e;
import com.baidu.adp.framework.task.SocketMessageTask;
import com.baidu.tieba.ai;
import com.baidu.tieba.message.ResponseQueryCollectUpdateNumMessage;
/* loaded from: classes.dex */
public class a {
    private static a bIJ;
    private long bIK = 0;
    private final Handler mHandler = new b(this);
    private e ayS = new c(this, 303005);

    static {
        ai.a(303005, ResponseQueryCollectUpdateNumMessage.class, false, SocketMessageTask.DupLicateMode.REMOVE_ME, true);
        bIJ = null;
    }

    public static synchronized a abP() {
        a aVar;
        synchronized (a.class) {
            if (bIJ == null) {
                bIJ = new a();
            }
            aVar = bIJ;
        }
        return aVar;
    }

    public a() {
        MessageManager.getInstance().registerListener(this.ayS);
    }

    public void abQ() {
        this.bIK = 0L;
        destroy();
        start();
    }

    public void start() {
        long currentTimeMillis = System.currentTimeMillis() - this.bIK;
        long j = currentTimeMillis > 0 ? currentTimeMillis : 0L;
        if (j >= 1800000) {
            this.mHandler.sendMessageDelayed(this.mHandler.obtainMessage(1), 10000L);
        } else {
            this.mHandler.sendMessageDelayed(this.mHandler.obtainMessage(1), 1800000 - j);
        }
        this.bIK = System.currentTimeMillis();
    }

    public void destroy() {
        this.mHandler.removeMessages(1);
        this.mHandler.removeMessages(2);
    }
}
