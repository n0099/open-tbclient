package com.baidu.tieba.q;

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
import com.baidu.searchbox.ng.ai.apps.network.BaseRequestAction;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.am;
import com.baidu.tieba.model.ReportUserInfoModel;
import java.util.HashSet;
/* loaded from: classes.dex */
public class c {
    private static c hkN;
    private SparseArray<HashSet<String>> hkQ;
    private a hkR;
    Handler mUIHandler = new Handler(Looper.getMainLooper()) { // from class: com.baidu.tieba.q.c.1
        @Override // android.os.Handler
        public void handleMessage(Message message) {
            a aVar;
            super.handleMessage(message);
            switch (message.what) {
                case 5:
                    if ((message.obj instanceof a) && (aVar = (a) message.obj) != null) {
                        aVar.eep = false;
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
    private CustomMessageListener aof = new CustomMessageListener(2005016) { // from class: com.baidu.tieba.q.c.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null) {
                if (c.this.hkQ != null) {
                    c.this.hkQ.clear();
                }
                c.this.hkO.bBS();
            }
        }
    };
    private int hkP = com.baidu.tbadk.core.sharedPref.b.getInstance().getInt("card_show_statistic_max_count", 200);
    private final b hkO = new b();

    private c() {
        MessageManager.getInstance().registerListener(this.aof);
    }

    public static c bBT() {
        if (hkN == null) {
            synchronized (c.class) {
                if (hkN == null) {
                    hkN = new c();
                }
            }
        }
        return hkN;
    }

    public void r(BdUniqueId bdUniqueId) {
        l.lj();
        if (bdUniqueId != null) {
            this.hkO.r(bdUniqueId);
        }
    }

    public void s(BdUniqueId bdUniqueId) {
        l.lj();
        if (bdUniqueId != null) {
            this.hkO.s(bdUniqueId);
            u(bdUniqueId);
        }
    }

    private void u(BdUniqueId bdUniqueId) {
        if (this.hkQ != null) {
            this.hkQ.remove(bdUniqueId.getId());
        }
    }

    public void b(BdUniqueId bdUniqueId, am amVar) {
        this.hkO.a(bdUniqueId, true);
        TiebaStatic.log(amVar);
    }

    public void a(BdUniqueId bdUniqueId, String str, am amVar) {
        if (bdUniqueId != null && amVar != null) {
            long currentTimeMillis = System.currentTimeMillis();
            if (!this.hkO.t(bdUniqueId)) {
                BdLog.e("error, bdUniqueId not register");
                return;
            }
            if (TextUtils.isEmpty(str)) {
                BdLog.e("id is null, statistic key is=" + amVar.getKey());
            }
            if (this.hkQ == null) {
                this.hkQ = new SparseArray<>();
            }
            HashSet<String> hashSet = this.hkQ.get(bdUniqueId.getId());
            if (hashSet == null) {
                hashSet = new HashSet<>();
                this.hkQ.put(bdUniqueId.getId(), hashSet);
            }
            String str2 = amVar.getKey() + BaseRequestAction.SPLITE + str;
            if (!hashSet.contains(str2) && !aHA()) {
                hashSet.add(str2);
                this.hkO.a(bdUniqueId, amVar);
                if (BdLog.isDebugMode()) {
                    BdLog.d("add show statistic log success" + (System.currentTimeMillis() - currentTimeMillis));
                }
            }
        }
    }

    private boolean aHA() {
        if (this.hkR == null) {
            this.hkR = new a();
        }
        if (this.hkR.eep) {
            return true;
        }
        long currentTimeMillis = System.currentTimeMillis();
        if (this.hkR.isRunning) {
            this.hkR.count++;
            if (currentTimeMillis - this.hkR.eeo < 120000) {
                if (this.hkR.count >= this.hkP) {
                    this.hkR.eep = true;
                    a(this.hkR);
                    return true;
                }
            } else {
                this.hkR.isRunning = false;
                this.hkR.count = 0;
            }
        } else {
            this.hkR.isRunning = true;
            this.hkR.eeo = currentTimeMillis;
        }
        return false;
    }

    private void a(a aVar) {
        Message obtainMessage = this.mUIHandler.obtainMessage();
        obtainMessage.what = 5;
        obtainMessage.obj = aVar;
        this.mUIHandler.removeMessages(5);
        this.mUIHandler.sendMessageDelayed(obtainMessage, ReportUserInfoModel.TIME_INTERVAL);
    }

    public void b(BdUniqueId bdUniqueId, boolean z) {
        if (BdLog.isDebugMode()) {
            BdLog.d("logStatisticByKey start write log ");
        }
        this.hkO.a(bdUniqueId, z);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class a {
        public int count;
        public long eeo;
        public boolean eep;
        public boolean isRunning;

        private a() {
            this.isRunning = false;
            this.count = 0;
            this.eeo = 0L;
            this.eep = false;
        }
    }
}
