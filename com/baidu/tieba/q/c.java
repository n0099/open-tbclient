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
    private static c iWb;
    private SparseArray<HashSet<String>> iWe;
    private a iWf;
    Handler mUIHandler = new Handler(Looper.getMainLooper()) { // from class: com.baidu.tieba.q.c.1
        @Override // android.os.Handler
        public void handleMessage(Message message) {
            a aVar;
            super.handleMessage(message);
            switch (message.what) {
                case 5:
                    if ((message.obj instanceof a) && (aVar = (a) message.obj) != null) {
                        aVar.fJP = false;
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
    private CustomMessageListener bCA = new CustomMessageListener(2005016) { // from class: com.baidu.tieba.q.c.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null) {
                if (c.this.iWe != null) {
                    c.this.iWe.clear();
                }
                c.this.iWc.clu();
            }
        }
    };
    private int iWd = com.baidu.tbadk.core.sharedPref.b.agM().getInt("card_show_statistic_max_count", 200);
    private final b iWc = new b();

    private c() {
        MessageManager.getInstance().registerListener(this.bCA);
    }

    public static c clv() {
        if (iWb == null) {
            synchronized (c.class) {
                if (iWb == null) {
                    iWb = new c();
                }
            }
        }
        return iWb;
    }

    public void u(BdUniqueId bdUniqueId) {
        l.kg();
        if (bdUniqueId != null) {
            this.iWc.u(bdUniqueId);
        }
    }

    public void v(BdUniqueId bdUniqueId) {
        l.kg();
        if (bdUniqueId != null) {
            this.iWc.v(bdUniqueId);
            x(bdUniqueId);
        }
    }

    public void x(BdUniqueId bdUniqueId) {
        if (this.iWe != null) {
            this.iWe.remove(bdUniqueId.getId());
        }
    }

    public void b(BdUniqueId bdUniqueId, am amVar) {
        this.iWc.a(bdUniqueId, true);
        TiebaStatic.log(amVar);
    }

    public void a(BdUniqueId bdUniqueId, String str, am amVar) {
        if (bdUniqueId != null && amVar != null) {
            long currentTimeMillis = System.currentTimeMillis();
            if (!this.iWc.w(bdUniqueId)) {
                BdLog.e("error, bdUniqueId not register");
                return;
            }
            if (TextUtils.isEmpty(str)) {
                BdLog.e("id is null, statistic key is=" + amVar.getKey());
            }
            if (this.iWe == null) {
                this.iWe = new SparseArray<>();
            }
            HashSet<String> hashSet = this.iWe.get(bdUniqueId.getId());
            if (hashSet == null) {
                hashSet = new HashSet<>();
                this.iWe.put(bdUniqueId.getId(), hashSet);
            }
            String str2 = amVar.getKey() + "_" + str;
            if (!hashSet.contains(str2) && !bpD()) {
                hashSet.add(str2);
                this.iWc.a(bdUniqueId, amVar);
                if (BdLog.isDebugMode()) {
                    BdLog.d("add show statistic log success" + (System.currentTimeMillis() - currentTimeMillis));
                }
            }
        }
    }

    private boolean bpD() {
        if (this.iWf == null) {
            this.iWf = new a();
        }
        if (this.iWf.fJP) {
            return true;
        }
        long currentTimeMillis = System.currentTimeMillis();
        if (this.iWf.isRunning) {
            this.iWf.count++;
            if (currentTimeMillis - this.iWf.fJO < 120000) {
                if (this.iWf.count >= this.iWd) {
                    this.iWf.fJP = true;
                    a(this.iWf);
                    return true;
                }
            } else {
                this.iWf.isRunning = false;
                this.iWf.count = 0;
            }
        } else {
            this.iWf.isRunning = true;
            this.iWf.fJO = currentTimeMillis;
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
        this.iWc.a(bdUniqueId, z);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class a {
        public int count;
        public long fJO;
        public boolean fJP;
        public boolean isRunning;

        private a() {
            this.isRunning = false;
            this.count = 0;
            this.fJO = 0L;
            this.fJP = false;
        }
    }
}
