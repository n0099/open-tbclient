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
    private static c mUn;
    private SparseArray<HashSet<String>> mUq;
    private a mUr;
    Handler mUIHandler = new Handler(Looper.getMainLooper()) { // from class: com.baidu.tieba.s.c.1
        @Override // android.os.Handler
        public void handleMessage(Message message) {
            a aVar;
            super.handleMessage(message);
            switch (message.what) {
                case 5:
                    if ((message.obj instanceof a) && (aVar = (a) message.obj) != null) {
                        aVar.jfO = false;
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
    private CustomMessageListener exi = new CustomMessageListener(CmdConfigCustom.METHOD_ACCOUNT_CHANGE) { // from class: com.baidu.tieba.s.c.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null) {
                if (c.this.mUq != null) {
                    c.this.mUq.clear();
                }
                c.this.mUo.dIW();
            }
        }
    };
    private int mUp = com.baidu.tbadk.core.sharedPref.b.bqh().getInt("card_show_statistic_max_count", 200);
    private final b mUo = new b();

    private c() {
        MessageManager.getInstance().registerListener(this.exi);
    }

    public static c dIX() {
        if (mUn == null) {
            synchronized (c.class) {
                if (mUn == null) {
                    mUn = new c();
                }
            }
        }
        return mUn;
    }

    public void z(BdUniqueId bdUniqueId) {
        l.checkMainThread();
        if (bdUniqueId != null) {
            this.mUo.z(bdUniqueId);
        }
    }

    public void A(BdUniqueId bdUniqueId) {
        l.checkMainThread();
        if (bdUniqueId != null) {
            this.mUo.A(bdUniqueId);
            C(bdUniqueId);
        }
    }

    public void C(BdUniqueId bdUniqueId) {
        if (this.mUq != null) {
            this.mUq.remove(bdUniqueId.getId());
        }
    }

    public void b(BdUniqueId bdUniqueId, aq aqVar) {
        this.mUo.a(bdUniqueId, true);
        TiebaStatic.log(aqVar);
    }

    public void a(BdUniqueId bdUniqueId, String str, aq aqVar) {
        if (bdUniqueId != null && aqVar != null) {
            long currentTimeMillis = System.currentTimeMillis();
            if (!this.mUo.B(bdUniqueId)) {
                BdLog.e("error, bdUniqueId not register");
                return;
            }
            if (TextUtils.isEmpty(str)) {
                BdLog.e("id is null, statistic key is=" + aqVar.getKey());
            }
            if (this.mUq == null) {
                this.mUq = new SparseArray<>();
            }
            HashSet<String> hashSet = this.mUq.get(bdUniqueId.getId());
            if (hashSet == null) {
                hashSet = new HashSet<>();
                this.mUq.put(bdUniqueId.getId(), hashSet);
            }
            String str2 = aqVar.getKey() + PageStayDurationHelper.STAT_SOURCE_TRACE_CONNECTORS + str;
            if (!hashSet.contains(str2) && !cEQ()) {
                hashSet.add(str2);
                this.mUo.a(bdUniqueId, aqVar);
                if (BdLog.isDebugMode()) {
                    BdLog.d("add show statistic log success" + (System.currentTimeMillis() - currentTimeMillis));
                }
            }
        }
    }

    private boolean cEQ() {
        if (this.mUr == null) {
            this.mUr = new a();
        }
        if (this.mUr.jfO) {
            return true;
        }
        long currentTimeMillis = System.currentTimeMillis();
        if (this.mUr.isRunning) {
            this.mUr.count++;
            if (currentTimeMillis - this.mUr.jfN < 120000) {
                if (this.mUr.count >= this.mUp) {
                    this.mUr.jfO = true;
                    a(this.mUr);
                    return true;
                }
            } else {
                this.mUr.isRunning = false;
                this.mUr.count = 0;
            }
        } else {
            this.mUr.isRunning = true;
            this.mUr.jfN = currentTimeMillis;
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
        this.mUo.a(bdUniqueId, z);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class a {
        public int count;
        public boolean isRunning;
        public long jfN;
        public boolean jfO;

        private a() {
            this.isRunning = false;
            this.count = 0;
            this.jfN = 0L;
            this.jfO = false;
        }
    }
}
