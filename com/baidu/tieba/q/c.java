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
    private static c jfW;
    private SparseArray<HashSet<String>> jfZ;
    private a jga;
    Handler mUIHandler = new Handler(Looper.getMainLooper()) { // from class: com.baidu.tieba.q.c.1
        @Override // android.os.Handler
        public void handleMessage(Message message) {
            a aVar;
            super.handleMessage(message);
            switch (message.what) {
                case 5:
                    if ((message.obj instanceof a) && (aVar = (a) message.obj) != null) {
                        aVar.fRu = false;
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
    private CustomMessageListener bDW = new CustomMessageListener(2005016) { // from class: com.baidu.tieba.q.c.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null) {
                if (c.this.jfZ != null) {
                    c.this.jfZ.clear();
                }
                c.this.jfX.cps();
            }
        }
    };
    private int jfY = com.baidu.tbadk.core.sharedPref.b.ahU().getInt("card_show_statistic_max_count", 200);
    private final b jfX = new b();

    private c() {
        MessageManager.getInstance().registerListener(this.bDW);
    }

    public static c cpt() {
        if (jfW == null) {
            synchronized (c.class) {
                if (jfW == null) {
                    jfW = new c();
                }
            }
        }
        return jfW;
    }

    public void u(BdUniqueId bdUniqueId) {
        l.kr();
        if (bdUniqueId != null) {
            this.jfX.u(bdUniqueId);
        }
    }

    public void v(BdUniqueId bdUniqueId) {
        l.kr();
        if (bdUniqueId != null) {
            this.jfX.v(bdUniqueId);
            x(bdUniqueId);
        }
    }

    public void x(BdUniqueId bdUniqueId) {
        if (this.jfZ != null) {
            this.jfZ.remove(bdUniqueId.getId());
        }
    }

    public void b(BdUniqueId bdUniqueId, an anVar) {
        this.jfX.a(bdUniqueId, true);
        TiebaStatic.log(anVar);
    }

    public void a(BdUniqueId bdUniqueId, String str, an anVar) {
        if (bdUniqueId != null && anVar != null) {
            long currentTimeMillis = System.currentTimeMillis();
            if (!this.jfX.w(bdUniqueId)) {
                BdLog.e("error, bdUniqueId not register");
                return;
            }
            if (TextUtils.isEmpty(str)) {
                BdLog.e("id is null, statistic key is=" + anVar.getKey());
            }
            if (this.jfZ == null) {
                this.jfZ = new SparseArray<>();
            }
            HashSet<String> hashSet = this.jfZ.get(bdUniqueId.getId());
            if (hashSet == null) {
                hashSet = new HashSet<>();
                this.jfZ.put(bdUniqueId.getId(), hashSet);
            }
            String str2 = anVar.getKey() + "_" + str;
            if (!hashSet.contains(str2) && !bsG()) {
                hashSet.add(str2);
                this.jfX.a(bdUniqueId, anVar);
                if (BdLog.isDebugMode()) {
                    BdLog.d("add show statistic log success" + (System.currentTimeMillis() - currentTimeMillis));
                }
            }
        }
    }

    private boolean bsG() {
        if (this.jga == null) {
            this.jga = new a();
        }
        if (this.jga.fRu) {
            return true;
        }
        long currentTimeMillis = System.currentTimeMillis();
        if (this.jga.isRunning) {
            this.jga.count++;
            if (currentTimeMillis - this.jga.fRt < 120000) {
                if (this.jga.count >= this.jfY) {
                    this.jga.fRu = true;
                    a(this.jga);
                    return true;
                }
            } else {
                this.jga.isRunning = false;
                this.jga.count = 0;
            }
        } else {
            this.jga.isRunning = true;
            this.jga.fRt = currentTimeMillis;
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
        this.jfX.a(bdUniqueId, z);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class a {
        public int count;
        public long fRt;
        public boolean fRu;
        public boolean isRunning;

        private a() {
            this.isRunning = false;
            this.count = 0;
            this.fRt = 0L;
            this.fRu = false;
        }
    }
}
