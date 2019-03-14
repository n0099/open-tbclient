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
    private static c iDA;
    private SparseArray<HashSet<String>> iDD;
    private a iDE;
    Handler mUIHandler = new Handler(Looper.getMainLooper()) { // from class: com.baidu.tieba.q.c.1
        @Override // android.os.Handler
        public void handleMessage(Message message) {
            a aVar;
            super.handleMessage(message);
            switch (message.what) {
                case 5:
                    if ((message.obj instanceof a) && (aVar = (a) message.obj) != null) {
                        aVar.ftm = false;
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
    private CustomMessageListener bvt = new CustomMessageListener(2005016) { // from class: com.baidu.tieba.q.c.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null) {
                if (c.this.iDD != null) {
                    c.this.iDD.clear();
                }
                c.this.iDB.cds();
            }
        }
    };
    private int iDC = com.baidu.tbadk.core.sharedPref.b.getInstance().getInt("card_show_statistic_max_count", 200);
    private final b iDB = new b();

    private c() {
        MessageManager.getInstance().registerListener(this.bvt);
    }

    public static c cdt() {
        if (iDA == null) {
            synchronized (c.class) {
                if (iDA == null) {
                    iDA = new c();
                }
            }
        }
        return iDA;
    }

    public void s(BdUniqueId bdUniqueId) {
        l.lm();
        if (bdUniqueId != null) {
            this.iDB.s(bdUniqueId);
        }
    }

    public void t(BdUniqueId bdUniqueId) {
        l.lm();
        if (bdUniqueId != null) {
            this.iDB.t(bdUniqueId);
            v(bdUniqueId);
        }
    }

    private void v(BdUniqueId bdUniqueId) {
        if (this.iDD != null) {
            this.iDD.remove(bdUniqueId.getId());
        }
    }

    public void b(BdUniqueId bdUniqueId, am amVar) {
        this.iDB.a(bdUniqueId, true);
        TiebaStatic.log(amVar);
    }

    public void a(BdUniqueId bdUniqueId, String str, am amVar) {
        if (bdUniqueId != null && amVar != null) {
            long currentTimeMillis = System.currentTimeMillis();
            if (!this.iDB.u(bdUniqueId)) {
                BdLog.e("error, bdUniqueId not register");
                return;
            }
            if (TextUtils.isEmpty(str)) {
                BdLog.e("id is null, statistic key is=" + amVar.getKey());
            }
            if (this.iDD == null) {
                this.iDD = new SparseArray<>();
            }
            HashSet<String> hashSet = this.iDD.get(bdUniqueId.getId());
            if (hashSet == null) {
                hashSet = new HashSet<>();
                this.iDD.put(bdUniqueId.getId(), hashSet);
            }
            String str2 = amVar.getKey() + "_" + str;
            if (!hashSet.contains(str2) && !bim()) {
                hashSet.add(str2);
                this.iDB.a(bdUniqueId, amVar);
                if (BdLog.isDebugMode()) {
                    BdLog.d("add show statistic log success" + (System.currentTimeMillis() - currentTimeMillis));
                }
            }
        }
    }

    private boolean bim() {
        if (this.iDE == null) {
            this.iDE = new a();
        }
        if (this.iDE.ftm) {
            return true;
        }
        long currentTimeMillis = System.currentTimeMillis();
        if (this.iDE.isRunning) {
            this.iDE.count++;
            if (currentTimeMillis - this.iDE.ftl < 120000) {
                if (this.iDE.count >= this.iDC) {
                    this.iDE.ftm = true;
                    a(this.iDE);
                    return true;
                }
            } else {
                this.iDE.isRunning = false;
                this.iDE.count = 0;
            }
        } else {
            this.iDE.isRunning = true;
            this.iDE.ftl = currentTimeMillis;
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
        this.iDB.a(bdUniqueId, z);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class a {
        public int count;
        public long ftl;
        public boolean ftm;
        public boolean isRunning;

        private a() {
            this.isRunning = false;
            this.count = 0;
            this.ftl = 0L;
            this.ftm = false;
        }
    }
}
