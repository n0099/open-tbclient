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
import com.baidu.tbadk.core.util.aq;
import java.util.HashSet;
/* loaded from: classes2.dex */
public class c {
    private static c mcj;
    private SparseArray<HashSet<String>> mcm;
    private a mcn;
    Handler mUIHandler = new Handler(Looper.getMainLooper()) { // from class: com.baidu.tieba.s.c.1
        @Override // android.os.Handler
        public void handleMessage(Message message) {
            a aVar;
            super.handleMessage(message);
            switch (message.what) {
                case 5:
                    if ((message.obj instanceof a) && (aVar = (a) message.obj) != null) {
                        aVar.irg = false;
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
    private CustomMessageListener dUB = new CustomMessageListener(CmdConfigCustom.METHOD_ACCOUNT_CHANGE) { // from class: com.baidu.tieba.s.c.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null) {
                if (c.this.mcm != null) {
                    c.this.mcm.clear();
                }
                c.this.mck.dvD();
            }
        }
    };
    private int mcl = com.baidu.tbadk.core.sharedPref.b.bik().getInt("card_show_statistic_max_count", 200);
    private final b mck = new b();

    private c() {
        MessageManager.getInstance().registerListener(this.dUB);
    }

    public static c dvE() {
        if (mcj == null) {
            synchronized (c.class) {
                if (mcj == null) {
                    mcj = new c();
                }
            }
        }
        return mcj;
    }

    public void A(BdUniqueId bdUniqueId) {
        l.checkMainThread();
        if (bdUniqueId != null) {
            this.mck.A(bdUniqueId);
        }
    }

    public void B(BdUniqueId bdUniqueId) {
        l.checkMainThread();
        if (bdUniqueId != null) {
            this.mck.B(bdUniqueId);
            D(bdUniqueId);
        }
    }

    public void D(BdUniqueId bdUniqueId) {
        if (this.mcm != null) {
            this.mcm.remove(bdUniqueId.getId());
        }
    }

    public void b(BdUniqueId bdUniqueId, aq aqVar) {
        this.mck.a(bdUniqueId, true);
        TiebaStatic.log(aqVar);
    }

    public void a(BdUniqueId bdUniqueId, String str, aq aqVar) {
        if (bdUniqueId != null && aqVar != null) {
            long currentTimeMillis = System.currentTimeMillis();
            if (!this.mck.C(bdUniqueId)) {
                BdLog.e("error, bdUniqueId not register");
                return;
            }
            if (TextUtils.isEmpty(str)) {
                BdLog.e("id is null, statistic key is=" + aqVar.getKey());
            }
            if (this.mcm == null) {
                this.mcm = new SparseArray<>();
            }
            HashSet<String> hashSet = this.mcm.get(bdUniqueId.getId());
            if (hashSet == null) {
                hashSet = new HashSet<>();
                this.mcm.put(bdUniqueId.getId(), hashSet);
            }
            String str2 = aqVar.getKey() + PageStayDurationHelper.STAT_SOURCE_TRACE_CONNECTORS + str;
            if (!hashSet.contains(str2) && !csv()) {
                hashSet.add(str2);
                this.mck.a(bdUniqueId, aqVar);
                if (BdLog.isDebugMode()) {
                    BdLog.d("add show statistic log success" + (System.currentTimeMillis() - currentTimeMillis));
                }
            }
        }
    }

    private boolean csv() {
        if (this.mcn == null) {
            this.mcn = new a();
        }
        if (this.mcn.irg) {
            return true;
        }
        long currentTimeMillis = System.currentTimeMillis();
        if (this.mcn.isRunning) {
            this.mcn.count++;
            if (currentTimeMillis - this.mcn.irf < 120000) {
                if (this.mcn.count >= this.mcl) {
                    this.mcn.irg = true;
                    a(this.mcn);
                    return true;
                }
            } else {
                this.mcn.isRunning = false;
                this.mcn.count = 0;
            }
        } else {
            this.mcn.isRunning = true;
            this.mcn.irf = currentTimeMillis;
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
        this.mck.a(bdUniqueId, z);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public class a {
        public int count;
        public long irf;
        public boolean irg;
        public boolean isRunning;

        private a() {
            this.isRunning = false;
            this.count = 0;
            this.irf = 0L;
            this.irg = false;
        }
    }
}
