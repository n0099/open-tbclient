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
    private static c iVZ;
    private SparseArray<HashSet<String>> iWc;
    private a iWd;
    Handler mUIHandler = new Handler(Looper.getMainLooper()) { // from class: com.baidu.tieba.q.c.1
        @Override // android.os.Handler
        public void handleMessage(Message message) {
            a aVar;
            super.handleMessage(message);
            switch (message.what) {
                case 5:
                    if ((message.obj instanceof a) && (aVar = (a) message.obj) != null) {
                        aVar.fJO = false;
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
                if (c.this.iWc != null) {
                    c.this.iWc.clear();
                }
                c.this.iWa.cls();
            }
        }
    };
    private int iWb = com.baidu.tbadk.core.sharedPref.b.agM().getInt("card_show_statistic_max_count", 200);
    private final b iWa = new b();

    private c() {
        MessageManager.getInstance().registerListener(this.bCA);
    }

    public static c clt() {
        if (iVZ == null) {
            synchronized (c.class) {
                if (iVZ == null) {
                    iVZ = new c();
                }
            }
        }
        return iVZ;
    }

    public void u(BdUniqueId bdUniqueId) {
        l.kg();
        if (bdUniqueId != null) {
            this.iWa.u(bdUniqueId);
        }
    }

    public void v(BdUniqueId bdUniqueId) {
        l.kg();
        if (bdUniqueId != null) {
            this.iWa.v(bdUniqueId);
            x(bdUniqueId);
        }
    }

    public void x(BdUniqueId bdUniqueId) {
        if (this.iWc != null) {
            this.iWc.remove(bdUniqueId.getId());
        }
    }

    public void b(BdUniqueId bdUniqueId, am amVar) {
        this.iWa.a(bdUniqueId, true);
        TiebaStatic.log(amVar);
    }

    public void a(BdUniqueId bdUniqueId, String str, am amVar) {
        if (bdUniqueId != null && amVar != null) {
            long currentTimeMillis = System.currentTimeMillis();
            if (!this.iWa.w(bdUniqueId)) {
                BdLog.e("error, bdUniqueId not register");
                return;
            }
            if (TextUtils.isEmpty(str)) {
                BdLog.e("id is null, statistic key is=" + amVar.getKey());
            }
            if (this.iWc == null) {
                this.iWc = new SparseArray<>();
            }
            HashSet<String> hashSet = this.iWc.get(bdUniqueId.getId());
            if (hashSet == null) {
                hashSet = new HashSet<>();
                this.iWc.put(bdUniqueId.getId(), hashSet);
            }
            String str2 = amVar.getKey() + "_" + str;
            if (!hashSet.contains(str2) && !bpA()) {
                hashSet.add(str2);
                this.iWa.a(bdUniqueId, amVar);
                if (BdLog.isDebugMode()) {
                    BdLog.d("add show statistic log success" + (System.currentTimeMillis() - currentTimeMillis));
                }
            }
        }
    }

    private boolean bpA() {
        if (this.iWd == null) {
            this.iWd = new a();
        }
        if (this.iWd.fJO) {
            return true;
        }
        long currentTimeMillis = System.currentTimeMillis();
        if (this.iWd.isRunning) {
            this.iWd.count++;
            if (currentTimeMillis - this.iWd.fJN < 120000) {
                if (this.iWd.count >= this.iWb) {
                    this.iWd.fJO = true;
                    a(this.iWd);
                    return true;
                }
            } else {
                this.iWd.isRunning = false;
                this.iWd.count = 0;
            }
        } else {
            this.iWd.isRunning = true;
            this.iWd.fJN = currentTimeMillis;
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
        this.iWa.a(bdUniqueId, z);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class a {
        public int count;
        public long fJN;
        public boolean fJO;
        public boolean isRunning;

        private a() {
            this.isRunning = false;
            this.count = 0;
            this.fJN = 0L;
            this.fJO = false;
        }
    }
}
