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
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.am;
import com.baidu.tieba.model.ReportUserInfoModel;
import java.util.HashSet;
/* loaded from: classes.dex */
public class c {
    private static c iWf;
    private SparseArray<HashSet<String>> iWi;
    private a iWj;
    Handler mUIHandler = new Handler(Looper.getMainLooper()) { // from class: com.baidu.tieba.q.c.1
        @Override // android.os.Handler
        public void handleMessage(Message message) {
            a aVar;
            super.handleMessage(message);
            switch (message.what) {
                case 5:
                    if ((message.obj instanceof a) && (aVar = (a) message.obj) != null) {
                        aVar.fJR = false;
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
    private CustomMessageListener bCB = new CustomMessageListener(2005016) { // from class: com.baidu.tieba.q.c.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null) {
                if (c.this.iWi != null) {
                    c.this.iWi.clear();
                }
                c.this.iWg.clv();
            }
        }
    };
    private int iWh = com.baidu.tbadk.core.sharedPref.b.agM().getInt("card_show_statistic_max_count", 200);
    private final b iWg = new b();

    private c() {
        MessageManager.getInstance().registerListener(this.bCB);
    }

    public static c clw() {
        if (iWf == null) {
            synchronized (c.class) {
                if (iWf == null) {
                    iWf = new c();
                }
            }
        }
        return iWf;
    }

    public void u(BdUniqueId bdUniqueId) {
        l.kg();
        if (bdUniqueId != null) {
            this.iWg.u(bdUniqueId);
        }
    }

    public void v(BdUniqueId bdUniqueId) {
        l.kg();
        if (bdUniqueId != null) {
            this.iWg.v(bdUniqueId);
            x(bdUniqueId);
        }
    }

    public void x(BdUniqueId bdUniqueId) {
        if (this.iWi != null) {
            this.iWi.remove(bdUniqueId.getId());
        }
    }

    public void b(BdUniqueId bdUniqueId, am amVar) {
        this.iWg.a(bdUniqueId, true);
        TiebaStatic.log(amVar);
    }

    public void a(BdUniqueId bdUniqueId, String str, am amVar) {
        if (bdUniqueId != null && amVar != null) {
            long currentTimeMillis = System.currentTimeMillis();
            if (!this.iWg.w(bdUniqueId)) {
                BdLog.e("error, bdUniqueId not register");
                return;
            }
            if (TextUtils.isEmpty(str)) {
                BdLog.e("id is null, statistic key is=" + amVar.getKey());
            }
            if (this.iWi == null) {
                this.iWi = new SparseArray<>();
            }
            HashSet<String> hashSet = this.iWi.get(bdUniqueId.getId());
            if (hashSet == null) {
                hashSet = new HashSet<>();
                this.iWi.put(bdUniqueId.getId(), hashSet);
            }
            String str2 = amVar.getKey() + "_" + str;
            if (!hashSet.contains(str2) && !bpF()) {
                hashSet.add(str2);
                this.iWg.a(bdUniqueId, amVar);
                if (BdLog.isDebugMode()) {
                    BdLog.d("add show statistic log success" + (System.currentTimeMillis() - currentTimeMillis));
                }
            }
        }
    }

    private boolean bpF() {
        if (this.iWj == null) {
            this.iWj = new a();
        }
        if (this.iWj.fJR) {
            return true;
        }
        long currentTimeMillis = System.currentTimeMillis();
        if (this.iWj.isRunning) {
            this.iWj.count++;
            if (currentTimeMillis - this.iWj.fJQ < 120000) {
                if (this.iWj.count >= this.iWh) {
                    this.iWj.fJR = true;
                    a(this.iWj);
                    return true;
                }
            } else {
                this.iWj.isRunning = false;
                this.iWj.count = 0;
            }
        } else {
            this.iWj.isRunning = true;
            this.iWj.fJQ = currentTimeMillis;
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
        this.iWg.a(bdUniqueId, z);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class a {
        public int count;
        public long fJQ;
        public boolean fJR;
        public boolean isRunning;

        private a() {
            this.isRunning = false;
            this.count = 0;
            this.fJQ = 0L;
            this.fJR = false;
        }
    }
}
