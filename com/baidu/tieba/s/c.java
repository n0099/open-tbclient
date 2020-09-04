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
    private static c mcy;
    private SparseArray<HashSet<String>> mcB;
    private a mcC;
    Handler mUIHandler = new Handler(Looper.getMainLooper()) { // from class: com.baidu.tieba.s.c.1
        @Override // android.os.Handler
        public void handleMessage(Message message) {
            a aVar;
            super.handleMessage(message);
            switch (message.what) {
                case 5:
                    if ((message.obj instanceof a) && (aVar = (a) message.obj) != null) {
                        aVar.irm = false;
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
    private CustomMessageListener dUF = new CustomMessageListener(CmdConfigCustom.METHOD_ACCOUNT_CHANGE) { // from class: com.baidu.tieba.s.c.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null) {
                if (c.this.mcB != null) {
                    c.this.mcB.clear();
                }
                c.this.mcz.dvI();
            }
        }
    };
    private int mcA = com.baidu.tbadk.core.sharedPref.b.bik().getInt("card_show_statistic_max_count", 200);
    private final b mcz = new b();

    private c() {
        MessageManager.getInstance().registerListener(this.dUF);
    }

    public static c dvJ() {
        if (mcy == null) {
            synchronized (c.class) {
                if (mcy == null) {
                    mcy = new c();
                }
            }
        }
        return mcy;
    }

    public void A(BdUniqueId bdUniqueId) {
        l.checkMainThread();
        if (bdUniqueId != null) {
            this.mcz.A(bdUniqueId);
        }
    }

    public void B(BdUniqueId bdUniqueId) {
        l.checkMainThread();
        if (bdUniqueId != null) {
            this.mcz.B(bdUniqueId);
            D(bdUniqueId);
        }
    }

    public void D(BdUniqueId bdUniqueId) {
        if (this.mcB != null) {
            this.mcB.remove(bdUniqueId.getId());
        }
    }

    public void b(BdUniqueId bdUniqueId, aq aqVar) {
        this.mcz.a(bdUniqueId, true);
        TiebaStatic.log(aqVar);
    }

    public void a(BdUniqueId bdUniqueId, String str, aq aqVar) {
        if (bdUniqueId != null && aqVar != null) {
            long currentTimeMillis = System.currentTimeMillis();
            if (!this.mcz.C(bdUniqueId)) {
                BdLog.e("error, bdUniqueId not register");
                return;
            }
            if (TextUtils.isEmpty(str)) {
                BdLog.e("id is null, statistic key is=" + aqVar.getKey());
            }
            if (this.mcB == null) {
                this.mcB = new SparseArray<>();
            }
            HashSet<String> hashSet = this.mcB.get(bdUniqueId.getId());
            if (hashSet == null) {
                hashSet = new HashSet<>();
                this.mcB.put(bdUniqueId.getId(), hashSet);
            }
            String str2 = aqVar.getKey() + PageStayDurationHelper.STAT_SOURCE_TRACE_CONNECTORS + str;
            if (!hashSet.contains(str2) && !csw()) {
                hashSet.add(str2);
                this.mcz.a(bdUniqueId, aqVar);
                if (BdLog.isDebugMode()) {
                    BdLog.d("add show statistic log success" + (System.currentTimeMillis() - currentTimeMillis));
                }
            }
        }
    }

    private boolean csw() {
        if (this.mcC == null) {
            this.mcC = new a();
        }
        if (this.mcC.irm) {
            return true;
        }
        long currentTimeMillis = System.currentTimeMillis();
        if (this.mcC.isRunning) {
            this.mcC.count++;
            if (currentTimeMillis - this.mcC.irl < 120000) {
                if (this.mcC.count >= this.mcA) {
                    this.mcC.irm = true;
                    a(this.mcC);
                    return true;
                }
            } else {
                this.mcC.isRunning = false;
                this.mcC.count = 0;
            }
        } else {
            this.mcC.isRunning = true;
            this.mcC.irl = currentTimeMillis;
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
        this.mcz.a(bdUniqueId, z);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class a {
        public int count;
        public long irl;
        public boolean irm;
        public boolean isRunning;

        private a() {
            this.isRunning = false;
            this.count = 0;
            this.irl = 0L;
            this.irm = false;
        }
    }
}
