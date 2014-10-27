package com.baidu.tieba.runing;

import android.os.Handler;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.e;
import com.baidu.adp.framework.task.SocketMessageTask;
import com.baidu.tieba.ai;
import com.baidu.tieba.message.ResponseQueryCollectUpdateNumMessage;
/* loaded from: classes.dex */
public class a {
    private static a bIv;
    private long bIw = 0;
    private final Handler mHandler = new b(this);
    private e ayJ = new c(this, 303005);

    static {
        ai.a(303005, ResponseQueryCollectUpdateNumMessage.class, false, SocketMessageTask.DupLicateMode.REMOVE_ME, true);
        bIv = null;
    }

    public static synchronized a abM() {
        a aVar;
        synchronized (a.class) {
            if (bIv == null) {
                bIv = new a();
            }
            aVar = bIv;
        }
        return aVar;
    }

    public a() {
        MessageManager.getInstance().registerListener(this.ayJ);
    }

    public void abN() {
        this.bIw = 0L;
        destroy();
        start();
    }

    public void start() {
        long currentTimeMillis = System.currentTimeMillis() - this.bIw;
        long j = currentTimeMillis > 0 ? currentTimeMillis : 0L;
        if (j >= 1800000) {
            this.mHandler.sendMessageDelayed(this.mHandler.obtainMessage(1), 10000L);
        } else {
            this.mHandler.sendMessageDelayed(this.mHandler.obtainMessage(1), 1800000 - j);
        }
        this.bIw = System.currentTimeMillis();
    }

    public void destroy() {
        this.mHandler.removeMessages(1);
        this.mHandler.removeMessages(2);
    }
}
