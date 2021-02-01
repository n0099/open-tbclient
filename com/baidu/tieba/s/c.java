package com.baidu.tieba.s;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import android.util.SparseArray;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.util.l;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.live.tbadk.pagestayduration.PageStayDurationHelper;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.ar;
import java.util.HashSet;
/* loaded from: classes.dex */
public class c {
    private static c ntP;
    private SparseArray<HashSet<String>> ntS;
    private a ntT;
    Handler mUIHandler = new Handler(Looper.getMainLooper()) { // from class: com.baidu.tieba.s.c.1
        @Override // android.os.Handler
        public void handleMessage(Message message) {
            a aVar;
            super.handleMessage(message);
            switch (message.what) {
                case 5:
                    if ((message.obj instanceof a) && (aVar = (a) message.obj) != null) {
                        aVar.jHx = false;
                        aVar.isRunning = false;
                        aVar.count = 0;
                        return;
                    }
                    return;
                default:
                    return;
            }
        }
    };
    private CustomMessageListener eJz = new CustomMessageListener(CmdConfigCustom.METHOD_ACCOUNT_CHANGE) { // from class: com.baidu.tieba.s.c.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null) {
                if (c.this.ntS != null) {
                    c.this.ntS.clear();
                }
                c.this.ntQ.dMq();
            }
        }
    };
    private int ntR = com.baidu.tbadk.core.sharedPref.b.brQ().getInt("card_show_statistic_max_count", 200);
    private final b ntQ = new b();

    private c() {
        MessageManager.getInstance().registerListener(this.eJz);
    }

    public static c dMr() {
        if (ntP == null) {
            synchronized (c.class) {
                if (ntP == null) {
                    ntP = new c();
                }
            }
        }
        return ntP;
    }

    public void A(BdUniqueId bdUniqueId) {
        l.checkMainThread();
        if (bdUniqueId != null) {
            this.ntQ.A(bdUniqueId);
        }
    }

    public void B(BdUniqueId bdUniqueId) {
        l.checkMainThread();
        if (bdUniqueId != null) {
            this.ntQ.B(bdUniqueId);
            D(bdUniqueId);
        }
    }

    public void D(BdUniqueId bdUniqueId) {
        if (this.ntS != null) {
            this.ntS.remove(bdUniqueId.getId());
        }
    }

    public void b(BdUniqueId bdUniqueId, ar arVar) {
        this.ntQ.a(bdUniqueId, true);
        TiebaStatic.log(arVar);
    }

    public void a(BdUniqueId bdUniqueId, String str, ar arVar) {
        if (bdUniqueId != null && arVar != null) {
            long currentTimeMillis = System.currentTimeMillis();
            if (!this.ntQ.C(bdUniqueId)) {
                BdLog.e("error, bdUniqueId not register");
                return;
            }
            if (TextUtils.isEmpty(str)) {
                BdLog.e("id is null, statistic key is=" + arVar.getKey());
            }
            if (this.ntS == null) {
                this.ntS = new SparseArray<>();
            }
            HashSet<String> hashSet = this.ntS.get(bdUniqueId.getId());
            if (hashSet == null) {
                hashSet = new HashSet<>();
                this.ntS.put(bdUniqueId.getId(), hashSet);
            }
            String str2 = arVar.getKey() + PageStayDurationHelper.STAT_SOURCE_TRACE_CONNECTORS + str;
            if (!hashSet.contains(str2) && !cKf()) {
                hashSet.add(str2);
                this.ntQ.a(bdUniqueId, arVar);
                if (BdLog.isDebugMode()) {
                    BdLog.d("add show statistic log success" + (System.currentTimeMillis() - currentTimeMillis));
                }
            }
        }
    }

    private boolean cKf() {
        if (this.ntT == null) {
            this.ntT = new a();
        }
        if (this.ntT.jHx) {
            return true;
        }
        long currentTimeMillis = System.currentTimeMillis();
        if (this.ntT.isRunning) {
            this.ntT.count++;
            if (currentTimeMillis - this.ntT.jHw < 120000) {
                if (this.ntT.count >= this.ntR) {
                    this.ntT.jHx = true;
                    a(this.ntT);
                    return true;
                }
            } else {
                this.ntT.isRunning = false;
                this.ntT.count = 0;
            }
        } else {
            this.ntT.isRunning = true;
            this.ntT.jHw = currentTimeMillis;
        }
        return false;
    }

    private void a(a aVar) {
        Message obtainMessage = this.mUIHandler.obtainMessage();
        obtainMessage.what = 5;
        obtainMessage.obj = aVar;
        this.mUIHandler.removeMessages(5);
        this.mUIHandler.sendMessageDelayed(obtainMessage, 300000L);
    }

    public void b(BdUniqueId bdUniqueId, boolean z) {
        if (BdLog.isDebugMode()) {
            BdLog.d("logStatisticByKey start write log ");
        }
        this.ntQ.a(bdUniqueId, z);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class a {
        public int count;
        public boolean isRunning;
        public long jHw;
        public boolean jHx;

        private a() {
            this.isRunning = false;
            this.count = 0;
            this.jHw = 0L;
            this.jHx = false;
        }
    }
}
