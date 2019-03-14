package com.baidu.tieba.myCollection.runing;

import android.annotation.SuppressLint;
import android.os.Handler;
import android.os.Message;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.c;
import com.baidu.adp.framework.message.SocketResponsedMessage;
import com.baidu.adp.framework.task.SocketMessageTask;
import com.baidu.tbadk.coreExtra.messageCenter.b;
import com.baidu.tieba.myCollection.message.RequestQueryCollectUpdateNumMessage;
import com.baidu.tieba.myCollection.message.ResponseQueryCollectUpdateNumMessage;
/* loaded from: classes6.dex */
public class a {
    private static a hbO;
    private long gyn = 0;
    @SuppressLint({"HandlerLeak"})
    private final Handler mHandler = new Handler() { // from class: com.baidu.tieba.myCollection.runing.a.1
        @Override // android.os.Handler
        public void handleMessage(Message message) {
            if (message.what == 1) {
                a.this.gyn = System.currentTimeMillis();
                MessageManager.getInstance().sendMessage(new RequestQueryCollectUpdateNumMessage());
                a.this.mHandler.sendMessageDelayed(a.this.mHandler.obtainMessage(1), 1800000L);
            }
        }
    };
    private final c gaF = new c(303005) { // from class: com.baidu.tieba.myCollection.runing.a.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(SocketResponsedMessage socketResponsedMessage) {
            if (socketResponsedMessage != null && socketResponsedMessage.getCmd() == 303005 && (socketResponsedMessage instanceof ResponseQueryCollectUpdateNumMessage)) {
                b.ahA().setMsgBookmark(((ResponseQueryCollectUpdateNumMessage) socketResponsedMessage).getCollectUpdateNum());
            }
        }
    };

    static {
        com.baidu.tieba.tbadkCore.a.a.a(303005, ResponseQueryCollectUpdateNumMessage.class, false, SocketMessageTask.DupLicateMode.REMOVE_ME, true);
        hbO = null;
    }

    public static synchronized a bFC() {
        a aVar;
        synchronized (a.class) {
            if (hbO == null) {
                hbO = new a();
            }
            aVar = hbO;
        }
        return aVar;
    }

    public a() {
        MessageManager.getInstance().registerListener(this.gaF);
    }

    public void restart() {
        this.gyn = 0L;
        destroy();
        start();
    }

    public void start() {
        long currentTimeMillis = System.currentTimeMillis() - this.gyn;
        long j = currentTimeMillis > 0 ? currentTimeMillis : 0L;
        if (j >= 1800000) {
            this.mHandler.sendMessageDelayed(this.mHandler.obtainMessage(1), 10000L);
        } else {
            this.mHandler.sendMessageDelayed(this.mHandler.obtainMessage(1), 1800000 - j);
        }
        this.gyn = System.currentTimeMillis();
    }

    public void destroy() {
        this.mHandler.removeMessages(1);
        this.mHandler.removeMessages(2);
    }
}
