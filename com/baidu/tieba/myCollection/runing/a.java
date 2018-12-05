package com.baidu.tieba.myCollection.runing;

import android.annotation.SuppressLint;
import android.os.Handler;
import android.os.Message;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.c;
import com.baidu.adp.framework.message.SocketResponsedMessage;
import com.baidu.adp.framework.task.SocketMessageTask;
import com.baidu.searchbox.ng.ai.apps.trace.ErrDef;
import com.baidu.tieba.myCollection.message.RequestQueryCollectUpdateNumMessage;
import com.baidu.tieba.myCollection.message.ResponseQueryCollectUpdateNumMessage;
/* loaded from: classes3.dex */
public class a {
    private static a fHV;
    private long feF = 0;
    @SuppressLint({"HandlerLeak"})
    private final Handler mHandler = new Handler() { // from class: com.baidu.tieba.myCollection.runing.a.1
        @Override // android.os.Handler
        public void handleMessage(Message message) {
            if (message.what == 1) {
                a.this.feF = System.currentTimeMillis();
                MessageManager.getInstance().sendMessage(new RequestQueryCollectUpdateNumMessage());
                a.this.mHandler.sendMessageDelayed(a.this.mHandler.obtainMessage(1), 1800000L);
            }
        }
    };
    private final c eHa = new c(303005) { // from class: com.baidu.tieba.myCollection.runing.a.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(SocketResponsedMessage socketResponsedMessage) {
            if (socketResponsedMessage != null && socketResponsedMessage.getCmd() == 303005 && (socketResponsedMessage instanceof ResponseQueryCollectUpdateNumMessage)) {
                com.baidu.tbadk.coreExtra.messageCenter.a.HP().setMsgBookmark(((ResponseQueryCollectUpdateNumMessage) socketResponsedMessage).getCollectUpdateNum());
            }
        }
    };

    static {
        com.baidu.tieba.tbadkCore.a.a.a(303005, ResponseQueryCollectUpdateNumMessage.class, false, SocketMessageTask.DupLicateMode.REMOVE_ME, true);
        fHV = null;
    }

    public static synchronized a bdQ() {
        a aVar;
        synchronized (a.class) {
            if (fHV == null) {
                fHV = new a();
            }
            aVar = fHV;
        }
        return aVar;
    }

    public a() {
        MessageManager.getInstance().registerListener(this.eHa);
    }

    public void restart() {
        this.feF = 0L;
        destroy();
        start();
    }

    public void start() {
        long currentTimeMillis = System.currentTimeMillis() - this.feF;
        long j = currentTimeMillis > 0 ? currentTimeMillis : 0L;
        if (j >= 1800000) {
            this.mHandler.sendMessageDelayed(this.mHandler.obtainMessage(1), ErrDef.Feature.WEIGHT);
        } else {
            this.mHandler.sendMessageDelayed(this.mHandler.obtainMessage(1), 1800000 - j);
        }
        this.feF = System.currentTimeMillis();
    }

    public void destroy() {
        this.mHandler.removeMessages(1);
        this.mHandler.removeMessages(2);
    }
}
