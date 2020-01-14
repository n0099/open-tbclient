package com.baidu.tieba.r;

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
import com.baidu.tbadk.core.util.an;
import java.util.HashSet;
/* loaded from: classes.dex */
public class c {
    private static c kcQ;
    private SparseArray<HashSet<String>> kcT;
    private a kcU;
    Handler mUIHandler = new Handler(Looper.getMainLooper()) { // from class: com.baidu.tieba.r.c.1
        @Override // android.os.Handler
        public void handleMessage(Message message) {
            a aVar;
            super.handleMessage(message);
            switch (message.what) {
                case 5:
                    if ((message.obj instanceof a) && (aVar = (a) message.obj) != null) {
                        aVar.gHx = false;
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
    private CustomMessageListener cHC = new CustomMessageListener(CmdConfigCustom.METHOD_ACCOUNT_CHANGE) { // from class: com.baidu.tieba.r.c.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null) {
                if (c.this.kcT != null) {
                    c.this.kcT.clear();
                }
                c.this.kcR.cIt();
            }
        }
    };
    private int kcS = com.baidu.tbadk.core.sharedPref.b.aDr().getInt("card_show_statistic_max_count", 200);
    private final b kcR = new b();

    private c() {
        MessageManager.getInstance().registerListener(this.cHC);
    }

    public static c cIu() {
        if (kcQ == null) {
            synchronized (c.class) {
                if (kcQ == null) {
                    kcQ = new c();
                }
            }
        }
        return kcQ;
    }

    public void w(BdUniqueId bdUniqueId) {
        l.checkMainThread();
        if (bdUniqueId != null) {
            this.kcR.w(bdUniqueId);
        }
    }

    public void x(BdUniqueId bdUniqueId) {
        l.checkMainThread();
        if (bdUniqueId != null) {
            this.kcR.x(bdUniqueId);
            z(bdUniqueId);
        }
    }

    public void z(BdUniqueId bdUniqueId) {
        if (this.kcT != null) {
            this.kcT.remove(bdUniqueId.getId());
        }
    }

    public void b(BdUniqueId bdUniqueId, an anVar) {
        this.kcR.a(bdUniqueId, true);
        TiebaStatic.log(anVar);
    }

    public void a(BdUniqueId bdUniqueId, String str, an anVar) {
        if (bdUniqueId != null && anVar != null) {
            long currentTimeMillis = System.currentTimeMillis();
            if (!this.kcR.y(bdUniqueId)) {
                BdLog.e("error, bdUniqueId not register");
                return;
            }
            if (TextUtils.isEmpty(str)) {
                BdLog.e("id is null, statistic key is=" + anVar.getKey());
            }
            if (this.kcT == null) {
                this.kcT = new SparseArray<>();
            }
            HashSet<String> hashSet = this.kcT.get(bdUniqueId.getId());
            if (hashSet == null) {
                hashSet = new HashSet<>();
                this.kcT.put(bdUniqueId.getId(), hashSet);
            }
            String str2 = anVar.getKey() + PageStayDurationHelper.STAT_SOURCE_TRACE_CONNECTORS + str;
            if (!hashSet.contains(str2) && !bIg()) {
                hashSet.add(str2);
                this.kcR.a(bdUniqueId, anVar);
                if (BdLog.isDebugMode()) {
                    BdLog.d("add show statistic log success" + (System.currentTimeMillis() - currentTimeMillis));
                }
            }
        }
    }

    private boolean bIg() {
        if (this.kcU == null) {
            this.kcU = new a();
        }
        if (this.kcU.gHx) {
            return true;
        }
        long currentTimeMillis = System.currentTimeMillis();
        if (this.kcU.isRunning) {
            this.kcU.count++;
            if (currentTimeMillis - this.kcU.gHw < 120000) {
                if (this.kcU.count >= this.kcS) {
                    this.kcU.gHx = true;
                    a(this.kcU);
                    return true;
                }
            } else {
                this.kcU.isRunning = false;
                this.kcU.count = 0;
            }
        } else {
            this.kcU.isRunning = true;
            this.kcU.gHw = currentTimeMillis;
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
        this.kcR.a(bdUniqueId, z);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class a {
        public int count;
        public long gHw;
        public boolean gHx;
        public boolean isRunning;

        private a() {
            this.isRunning = false;
            this.count = 0;
            this.gHw = 0L;
            this.gHx = false;
        }
    }
}
