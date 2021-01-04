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
    private static c noO;
    private SparseArray<HashSet<String>> noR;
    private a noS;
    Handler mUIHandler = new Handler(Looper.getMainLooper()) { // from class: com.baidu.tieba.s.c.1
        @Override // android.os.Handler
        public void handleMessage(Message message) {
            a aVar;
            super.handleMessage(message);
            switch (message.what) {
                case 5:
                    if ((message.obj instanceof a) && (aVar = (a) message.obj) != null) {
                        aVar.jGz = false;
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
    private CustomMessageListener eMe = new CustomMessageListener(CmdConfigCustom.METHOD_ACCOUNT_CHANGE) { // from class: com.baidu.tieba.s.c.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null) {
                if (c.this.noR != null) {
                    c.this.noR.clear();
                }
                c.this.noP.dNW();
            }
        }
    };
    private int noQ = com.baidu.tbadk.core.sharedPref.b.bvq().getInt("card_show_statistic_max_count", 200);
    private final b noP = new b();

    private c() {
        MessageManager.getInstance().registerListener(this.eMe);
    }

    public static c dNX() {
        if (noO == null) {
            synchronized (c.class) {
                if (noO == null) {
                    noO = new c();
                }
            }
        }
        return noO;
    }

    public void z(BdUniqueId bdUniqueId) {
        l.checkMainThread();
        if (bdUniqueId != null) {
            this.noP.z(bdUniqueId);
        }
    }

    public void A(BdUniqueId bdUniqueId) {
        l.checkMainThread();
        if (bdUniqueId != null) {
            this.noP.A(bdUniqueId);
            C(bdUniqueId);
        }
    }

    public void C(BdUniqueId bdUniqueId) {
        if (this.noR != null) {
            this.noR.remove(bdUniqueId.getId());
        }
    }

    public void b(BdUniqueId bdUniqueId, aq aqVar) {
        this.noP.a(bdUniqueId, true);
        TiebaStatic.log(aqVar);
    }

    public void a(BdUniqueId bdUniqueId, String str, aq aqVar) {
        if (bdUniqueId != null && aqVar != null) {
            long currentTimeMillis = System.currentTimeMillis();
            if (!this.noP.B(bdUniqueId)) {
                BdLog.e("error, bdUniqueId not register");
                return;
            }
            if (TextUtils.isEmpty(str)) {
                BdLog.e("id is null, statistic key is=" + aqVar.getKey());
            }
            if (this.noR == null) {
                this.noR = new SparseArray<>();
            }
            HashSet<String> hashSet = this.noR.get(bdUniqueId.getId());
            if (hashSet == null) {
                hashSet = new HashSet<>();
                this.noR.put(bdUniqueId.getId(), hashSet);
            }
            String str2 = aqVar.getKey() + PageStayDurationHelper.STAT_SOURCE_TRACE_CONNECTORS + str;
            if (!hashSet.contains(str2) && !cMJ()) {
                hashSet.add(str2);
                this.noP.a(bdUniqueId, aqVar);
                if (BdLog.isDebugMode()) {
                    BdLog.d("add show statistic log success" + (System.currentTimeMillis() - currentTimeMillis));
                }
            }
        }
    }

    private boolean cMJ() {
        if (this.noS == null) {
            this.noS = new a();
        }
        if (this.noS.jGz) {
            return true;
        }
        long currentTimeMillis = System.currentTimeMillis();
        if (this.noS.isRunning) {
            this.noS.count++;
            if (currentTimeMillis - this.noS.jGy < 120000) {
                if (this.noS.count >= this.noQ) {
                    this.noS.jGz = true;
                    a(this.noS);
                    return true;
                }
            } else {
                this.noS.isRunning = false;
                this.noS.count = 0;
            }
        } else {
            this.noS.isRunning = true;
            this.noS.jGy = currentTimeMillis;
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
        this.noP.a(bdUniqueId, z);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class a {
        public int count;
        public boolean isRunning;
        public long jGy;
        public boolean jGz;

        private a() {
            this.isRunning = false;
            this.count = 0;
            this.jGy = 0L;
            this.jGz = false;
        }
    }
}
