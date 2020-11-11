package com.baidu.tieba.myCollection.a;

import android.annotation.SuppressLint;
import android.os.Handler;
import android.os.Message;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.c;
import com.baidu.adp.framework.message.SocketResponsedMessage;
import com.baidu.adp.framework.task.SocketMessageTask;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigSocket;
import com.baidu.tbadk.coreExtra.messageCenter.b;
import com.baidu.tieba.myCollection.message.RequestQueryCollectUpdateNumMessage;
import com.baidu.tieba.myCollection.message.ResponseQueryCollectUpdateNumMessage;
/* loaded from: classes24.dex */
public class a {
    private static a lba;
    private long kvf = 0;
    @SuppressLint({"HandlerLeak"})
    private final Handler mHandler = new Handler() { // from class: com.baidu.tieba.myCollection.a.a.1
        @Override // android.os.Handler
        public void handleMessage(Message message) {
            if (message.what == 1) {
                a.this.kvf = System.currentTimeMillis();
                MessageManager.getInstance().sendMessage(new RequestQueryCollectUpdateNumMessage());
                a.this.mHandler.sendMessageDelayed(a.this.mHandler.obtainMessage(1), 1800000L);
            }
        }
    };
    private final c jUQ = new c(CmdConfigSocket.CMD_QUERY_COLLECT_UPDATE_NUM) { // from class: com.baidu.tieba.myCollection.a.a.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(SocketResponsedMessage socketResponsedMessage) {
            if (socketResponsedMessage != null && socketResponsedMessage.getCmd() == 303005 && (socketResponsedMessage instanceof ResponseQueryCollectUpdateNumMessage)) {
                b.bvS().setMsgBookmark(((ResponseQueryCollectUpdateNumMessage) socketResponsedMessage).getCollectUpdateNum());
            }
        }
    };

    static {
        com.baidu.tieba.tbadkCore.a.a.a(CmdConfigSocket.CMD_QUERY_COLLECT_UPDATE_NUM, ResponseQueryCollectUpdateNumMessage.class, false, SocketMessageTask.DupLicateMode.REMOVE_ME, true);
        lba = null;
    }

    public static synchronized a dfj() {
        a aVar;
        synchronized (a.class) {
            if (lba == null) {
                lba = new a();
            }
            aVar = lba;
        }
        return aVar;
    }

    public a() {
        MessageManager.getInstance().registerListener(this.jUQ);
    }

    public void restart() {
        this.kvf = 0L;
        destroy();
        start();
    }

    public void start() {
        long currentTimeMillis = System.currentTimeMillis() - this.kvf;
        long j = currentTimeMillis > 0 ? currentTimeMillis : 0L;
        if (j >= 1800000) {
            this.mHandler.sendMessageDelayed(this.mHandler.obtainMessage(1), 10000L);
        } else {
            this.mHandler.sendMessageDelayed(this.mHandler.obtainMessage(1), 1800000 - j);
        }
        this.kvf = System.currentTimeMillis();
    }

    public void destroy() {
        this.mHandler.removeMessages(1);
        this.mHandler.removeMessages(2);
    }
}
