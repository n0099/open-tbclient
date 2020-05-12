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
import com.baidu.tbadk.core.util.an;
import java.util.HashSet;
/* loaded from: classes.dex */
public class c {
    private static c kPP;
    private SparseArray<HashSet<String>> kPS;
    private a kPT;
    Handler mUIHandler = new Handler(Looper.getMainLooper()) { // from class: com.baidu.tieba.s.c.1
        @Override // android.os.Handler
        public void handleMessage(Message message) {
            a aVar;
            super.handleMessage(message);
            switch (message.what) {
                case 5:
                    if ((message.obj instanceof a) && (aVar = (a) message.obj) != null) {
                        aVar.hum = false;
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
    private CustomMessageListener dld = new CustomMessageListener(CmdConfigCustom.METHOD_ACCOUNT_CHANGE) { // from class: com.baidu.tieba.s.c.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null) {
                if (c.this.kPS != null) {
                    c.this.kPS.clear();
                }
                c.this.kPQ.cVo();
            }
        }
    };
    private int kPR = com.baidu.tbadk.core.sharedPref.b.aNT().getInt("card_show_statistic_max_count", 200);
    private final b kPQ = new b();

    private c() {
        MessageManager.getInstance().registerListener(this.dld);
    }

    public static c cVp() {
        if (kPP == null) {
            synchronized (c.class) {
                if (kPP == null) {
                    kPP = new c();
                }
            }
        }
        return kPP;
    }

    public void w(BdUniqueId bdUniqueId) {
        l.checkMainThread();
        if (bdUniqueId != null) {
            this.kPQ.w(bdUniqueId);
        }
    }

    public void x(BdUniqueId bdUniqueId) {
        l.checkMainThread();
        if (bdUniqueId != null) {
            this.kPQ.x(bdUniqueId);
            z(bdUniqueId);
        }
    }

    public void z(BdUniqueId bdUniqueId) {
        if (this.kPS != null) {
            this.kPS.remove(bdUniqueId.getId());
        }
    }

    public void b(BdUniqueId bdUniqueId, an anVar) {
        this.kPQ.a(bdUniqueId, true);
        TiebaStatic.log(anVar);
    }

    public void a(BdUniqueId bdUniqueId, String str, an anVar) {
        if (bdUniqueId != null && anVar != null) {
            long currentTimeMillis = System.currentTimeMillis();
            if (!this.kPQ.y(bdUniqueId)) {
                BdLog.e("error, bdUniqueId not register");
                return;
            }
            if (TextUtils.isEmpty(str)) {
                BdLog.e("id is null, statistic key is=" + anVar.getKey());
            }
            if (this.kPS == null) {
                this.kPS = new SparseArray<>();
            }
            HashSet<String> hashSet = this.kPS.get(bdUniqueId.getId());
            if (hashSet == null) {
                hashSet = new HashSet<>();
                this.kPS.put(bdUniqueId.getId(), hashSet);
            }
            String str2 = anVar.getKey() + PageStayDurationHelper.STAT_SOURCE_TRACE_CONNECTORS + str;
            if (!hashSet.contains(str2) && !bUu()) {
                hashSet.add(str2);
                this.kPQ.a(bdUniqueId, anVar);
                if (BdLog.isDebugMode()) {
                    BdLog.d("add show statistic log success" + (System.currentTimeMillis() - currentTimeMillis));
                }
            }
        }
    }

    private boolean bUu() {
        if (this.kPT == null) {
            this.kPT = new a();
        }
        if (this.kPT.hum) {
            return true;
        }
        long currentTimeMillis = System.currentTimeMillis();
        if (this.kPT.isRunning) {
            this.kPT.count++;
            if (currentTimeMillis - this.kPT.hul < 120000) {
                if (this.kPT.count >= this.kPR) {
                    this.kPT.hum = true;
                    a(this.kPT);
                    return true;
                }
            } else {
                this.kPT.isRunning = false;
                this.kPT.count = 0;
            }
        } else {
            this.kPT.isRunning = true;
            this.kPT.hul = currentTimeMillis;
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
        this.kPQ.a(bdUniqueId, z);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class a {
        public int count;
        public long hul;
        public boolean hum;
        public boolean isRunning;

        private a() {
            this.isRunning = false;
            this.count = 0;
            this.hul = 0L;
            this.hum = false;
        }
    }
}
