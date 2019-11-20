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
/* loaded from: classes6.dex */
public class a {
    private static a hzP;
    private long gVx = 0;
    @SuppressLint({"HandlerLeak"})
    private final Handler mHandler = new Handler() { // from class: com.baidu.tieba.myCollection.a.a.1
        @Override // android.os.Handler
        public void handleMessage(Message message) {
            if (message.what == 1) {
                a.this.gVx = System.currentTimeMillis();
                MessageManager.getInstance().sendMessage(new RequestQueryCollectUpdateNumMessage());
                a.this.mHandler.sendMessageDelayed(a.this.mHandler.obtainMessage(1), 1800000L);
            }
        }
    };
    private final c gxN = new c(CmdConfigSocket.CMD_QUERY_COLLECT_UPDATE_NUM) { // from class: com.baidu.tieba.myCollection.a.a.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(SocketResponsedMessage socketResponsedMessage) {
            if (socketResponsedMessage != null && socketResponsedMessage.getCmd() == 303005 && (socketResponsedMessage instanceof ResponseQueryCollectUpdateNumMessage)) {
                b.aqr().setMsgBookmark(((ResponseQueryCollectUpdateNumMessage) socketResponsedMessage).getCollectUpdateNum());
            }
        }
    };

    static {
        com.baidu.tieba.tbadkCore.a.a.a(CmdConfigSocket.CMD_QUERY_COLLECT_UPDATE_NUM, ResponseQueryCollectUpdateNumMessage.class, false, SocketMessageTask.DupLicateMode.REMOVE_ME, true);
        hzP = null;
    }

    public static synchronized a bNT() {
        a aVar;
        synchronized (a.class) {
            if (hzP == null) {
                hzP = new a();
            }
            aVar = hzP;
        }
        return aVar;
    }

    public a() {
        MessageManager.getInstance().registerListener(this.gxN);
    }

    public void restart() {
        this.gVx = 0L;
        destroy();
        start();
    }

    public void start() {
        long currentTimeMillis = System.currentTimeMillis() - this.gVx;
        long j = currentTimeMillis > 0 ? currentTimeMillis : 0L;
        if (j >= 1800000) {
            this.mHandler.sendMessageDelayed(this.mHandler.obtainMessage(1), 10000L);
        } else {
            this.mHandler.sendMessageDelayed(this.mHandler.obtainMessage(1), 1800000 - j);
        }
        this.gVx = System.currentTimeMillis();
    }

    public void destroy() {
        this.mHandler.removeMessages(1);
        this.mHandler.removeMessages(2);
    }
}
