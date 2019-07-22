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
import com.baidu.tbadk.core.util.an;
import com.baidu.tieba.model.ReportUserInfoModel;
import java.util.HashSet;
/* loaded from: classes.dex */
public class c {
    private static c jcx;
    private SparseArray<HashSet<String>> jcA;
    private a jcB;
    Handler mUIHandler = new Handler(Looper.getMainLooper()) { // from class: com.baidu.tieba.q.c.1
        @Override // android.os.Handler
        public void handleMessage(Message message) {
            a aVar;
            super.handleMessage(message);
            switch (message.what) {
                case 5:
                    if ((message.obj instanceof a) && (aVar = (a) message.obj) != null) {
                        aVar.fOP = false;
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
    private CustomMessageListener bDy = new CustomMessageListener(2005016) { // from class: com.baidu.tieba.q.c.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null) {
                if (c.this.jcA != null) {
                    c.this.jcA.clear();
                }
                c.this.jcy.con();
            }
        }
    };
    private int jcz = com.baidu.tbadk.core.sharedPref.b.ahO().getInt("card_show_statistic_max_count", 200);
    private final b jcy = new b();

    private c() {
        MessageManager.getInstance().registerListener(this.bDy);
    }

    public static c coo() {
        if (jcx == null) {
            synchronized (c.class) {
                if (jcx == null) {
                    jcx = new c();
                }
            }
        }
        return jcx;
    }

    public void u(BdUniqueId bdUniqueId) {
        l.kr();
        if (bdUniqueId != null) {
            this.jcy.u(bdUniqueId);
        }
    }

    public void v(BdUniqueId bdUniqueId) {
        l.kr();
        if (bdUniqueId != null) {
            this.jcy.v(bdUniqueId);
            x(bdUniqueId);
        }
    }

    public void x(BdUniqueId bdUniqueId) {
        if (this.jcA != null) {
            this.jcA.remove(bdUniqueId.getId());
        }
    }

    public void b(BdUniqueId bdUniqueId, an anVar) {
        this.jcy.a(bdUniqueId, true);
        TiebaStatic.log(anVar);
    }

    public void a(BdUniqueId bdUniqueId, String str, an anVar) {
        if (bdUniqueId != null && anVar != null) {
            long currentTimeMillis = System.currentTimeMillis();
            if (!this.jcy.w(bdUniqueId)) {
                BdLog.e("error, bdUniqueId not register");
                return;
            }
            if (TextUtils.isEmpty(str)) {
                BdLog.e("id is null, statistic key is=" + anVar.getKey());
            }
            if (this.jcA == null) {
                this.jcA = new SparseArray<>();
            }
            HashSet<String> hashSet = this.jcA.get(bdUniqueId.getId());
            if (hashSet == null) {
                hashSet = new HashSet<>();
                this.jcA.put(bdUniqueId.getId(), hashSet);
            }
            String str2 = anVar.getKey() + "_" + str;
            if (!hashSet.contains(str2) && !brG()) {
                hashSet.add(str2);
                this.jcy.a(bdUniqueId, anVar);
                if (BdLog.isDebugMode()) {
                    BdLog.d("add show statistic log success" + (System.currentTimeMillis() - currentTimeMillis));
                }
            }
        }
    }

    private boolean brG() {
        if (this.jcB == null) {
            this.jcB = new a();
        }
        if (this.jcB.fOP) {
            return true;
        }
        long currentTimeMillis = System.currentTimeMillis();
        if (this.jcB.isRunning) {
            this.jcB.count++;
            if (currentTimeMillis - this.jcB.fOO < 120000) {
                if (this.jcB.count >= this.jcz) {
                    this.jcB.fOP = true;
                    a(this.jcB);
                    return true;
                }
            } else {
                this.jcB.isRunning = false;
                this.jcB.count = 0;
            }
        } else {
            this.jcB.isRunning = true;
            this.jcB.fOO = currentTimeMillis;
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
        this.jcy.a(bdUniqueId, z);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class a {
        public int count;
        public long fOO;
        public boolean fOP;
        public boolean isRunning;

        private a() {
            this.isRunning = false;
            this.count = 0;
            this.fOO = 0L;
            this.fOP = false;
        }
    }
}
