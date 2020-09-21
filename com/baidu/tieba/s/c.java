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
/* loaded from: classes.dex */
public class c {
    private static c mlY;
    private SparseArray<HashSet<String>> mmb;
    private a mmc;
    Handler mUIHandler = new Handler(Looper.getMainLooper()) { // from class: com.baidu.tieba.s.c.1
        @Override // android.os.Handler
        public void handleMessage(Message message) {
            a aVar;
            super.handleMessage(message);
            switch (message.what) {
                case 5:
                    if ((message.obj instanceof a) && (aVar = (a) message.obj) != null) {
                        aVar.iyC = false;
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
    private CustomMessageListener dWP = new CustomMessageListener(CmdConfigCustom.METHOD_ACCOUNT_CHANGE) { // from class: com.baidu.tieba.s.c.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null) {
                if (c.this.mmb != null) {
                    c.this.mmb.clear();
                }
                c.this.mlZ.dzB();
            }
        }
    };
    private int mma = com.baidu.tbadk.core.sharedPref.b.bjf().getInt("card_show_statistic_max_count", 200);
    private final b mlZ = new b();

    private c() {
        MessageManager.getInstance().registerListener(this.dWP);
    }

    public static c dzC() {
        if (mlY == null) {
            synchronized (c.class) {
                if (mlY == null) {
                    mlY = new c();
                }
            }
        }
        return mlY;
    }

    public void z(BdUniqueId bdUniqueId) {
        l.checkMainThread();
        if (bdUniqueId != null) {
            this.mlZ.z(bdUniqueId);
        }
    }

    public void A(BdUniqueId bdUniqueId) {
        l.checkMainThread();
        if (bdUniqueId != null) {
            this.mlZ.A(bdUniqueId);
            C(bdUniqueId);
        }
    }

    public void C(BdUniqueId bdUniqueId) {
        if (this.mmb != null) {
            this.mmb.remove(bdUniqueId.getId());
        }
    }

    public void b(BdUniqueId bdUniqueId, aq aqVar) {
        this.mlZ.a(bdUniqueId, true);
        TiebaStatic.log(aqVar);
    }

    public void a(BdUniqueId bdUniqueId, String str, aq aqVar) {
        if (bdUniqueId != null && aqVar != null) {
            long currentTimeMillis = System.currentTimeMillis();
            if (!this.mlZ.B(bdUniqueId)) {
                BdLog.e("error, bdUniqueId not register");
                return;
            }
            if (TextUtils.isEmpty(str)) {
                BdLog.e("id is null, statistic key is=" + aqVar.getKey());
            }
            if (this.mmb == null) {
                this.mmb = new SparseArray<>();
            }
            HashSet<String> hashSet = this.mmb.get(bdUniqueId.getId());
            if (hashSet == null) {
                hashSet = new HashSet<>();
                this.mmb.put(bdUniqueId.getId(), hashSet);
            }
            String str2 = aqVar.getKey() + PageStayDurationHelper.STAT_SOURCE_TRACE_CONNECTORS + str;
            if (!hashSet.contains(str2) && !cvL()) {
                hashSet.add(str2);
                this.mlZ.a(bdUniqueId, aqVar);
                if (BdLog.isDebugMode()) {
                    BdLog.d("add show statistic log success" + (System.currentTimeMillis() - currentTimeMillis));
                }
            }
        }
    }

    private boolean cvL() {
        if (this.mmc == null) {
            this.mmc = new a();
        }
        if (this.mmc.iyC) {
            return true;
        }
        long currentTimeMillis = System.currentTimeMillis();
        if (this.mmc.isRunning) {
            this.mmc.count++;
            if (currentTimeMillis - this.mmc.iyB < 120000) {
                if (this.mmc.count >= this.mma) {
                    this.mmc.iyC = true;
                    a(this.mmc);
                    return true;
                }
            } else {
                this.mmc.isRunning = false;
                this.mmc.count = 0;
            }
        } else {
            this.mmc.isRunning = true;
            this.mmc.iyB = currentTimeMillis;
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
        this.mlZ.a(bdUniqueId, z);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class a {
        public int count;
        public boolean isRunning;
        public long iyB;
        public boolean iyC;

        private a() {
            this.isRunning = false;
            this.count = 0;
            this.iyB = 0L;
            this.iyC = false;
        }
    }
}
