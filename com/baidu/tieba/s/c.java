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
    private static c mOj;
    private SparseArray<HashSet<String>> mOm;
    private a mOn;
    Handler mUIHandler = new Handler(Looper.getMainLooper()) { // from class: com.baidu.tieba.s.c.1
        @Override // android.os.Handler
        public void handleMessage(Message message) {
            a aVar;
            super.handleMessage(message);
            switch (message.what) {
                case 5:
                    if ((message.obj instanceof a) && (aVar = (a) message.obj) != null) {
                        aVar.iZR = false;
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
    private CustomMessageListener erp = new CustomMessageListener(CmdConfigCustom.METHOD_ACCOUNT_CHANGE) { // from class: com.baidu.tieba.s.c.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null) {
                if (c.this.mOm != null) {
                    c.this.mOm.clear();
                }
                c.this.mOk.dGu();
            }
        }
    };
    private int mOl = com.baidu.tbadk.core.sharedPref.b.bnH().getInt("card_show_statistic_max_count", 200);
    private final b mOk = new b();

    private c() {
        MessageManager.getInstance().registerListener(this.erp);
    }

    public static c dGv() {
        if (mOj == null) {
            synchronized (c.class) {
                if (mOj == null) {
                    mOj = new c();
                }
            }
        }
        return mOj;
    }

    public void z(BdUniqueId bdUniqueId) {
        l.checkMainThread();
        if (bdUniqueId != null) {
            this.mOk.z(bdUniqueId);
        }
    }

    public void A(BdUniqueId bdUniqueId) {
        l.checkMainThread();
        if (bdUniqueId != null) {
            this.mOk.A(bdUniqueId);
            C(bdUniqueId);
        }
    }

    public void C(BdUniqueId bdUniqueId) {
        if (this.mOm != null) {
            this.mOm.remove(bdUniqueId.getId());
        }
    }

    public void b(BdUniqueId bdUniqueId, aq aqVar) {
        this.mOk.a(bdUniqueId, true);
        TiebaStatic.log(aqVar);
    }

    public void a(BdUniqueId bdUniqueId, String str, aq aqVar) {
        if (bdUniqueId != null && aqVar != null) {
            long currentTimeMillis = System.currentTimeMillis();
            if (!this.mOk.B(bdUniqueId)) {
                BdLog.e("error, bdUniqueId not register");
                return;
            }
            if (TextUtils.isEmpty(str)) {
                BdLog.e("id is null, statistic key is=" + aqVar.getKey());
            }
            if (this.mOm == null) {
                this.mOm = new SparseArray<>();
            }
            HashSet<String> hashSet = this.mOm.get(bdUniqueId.getId());
            if (hashSet == null) {
                hashSet = new HashSet<>();
                this.mOm.put(bdUniqueId.getId(), hashSet);
            }
            String str2 = aqVar.getKey() + PageStayDurationHelper.STAT_SOURCE_TRACE_CONNECTORS + str;
            if (!hashSet.contains(str2) && !cCp()) {
                hashSet.add(str2);
                this.mOk.a(bdUniqueId, aqVar);
                if (BdLog.isDebugMode()) {
                    BdLog.d("add show statistic log success" + (System.currentTimeMillis() - currentTimeMillis));
                }
            }
        }
    }

    private boolean cCp() {
        if (this.mOn == null) {
            this.mOn = new a();
        }
        if (this.mOn.iZR) {
            return true;
        }
        long currentTimeMillis = System.currentTimeMillis();
        if (this.mOn.isRunning) {
            this.mOn.count++;
            if (currentTimeMillis - this.mOn.iZQ < 120000) {
                if (this.mOn.count >= this.mOl) {
                    this.mOn.iZR = true;
                    a(this.mOn);
                    return true;
                }
            } else {
                this.mOn.isRunning = false;
                this.mOn.count = 0;
            }
        } else {
            this.mOn.isRunning = true;
            this.mOn.iZQ = currentTimeMillis;
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
        this.mOk.a(bdUniqueId, z);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class a {
        public int count;
        public long iZQ;
        public boolean iZR;
        public boolean isRunning;

        private a() {
            this.isRunning = false;
            this.count = 0;
            this.iZQ = 0L;
            this.iZR = false;
        }
    }
}
