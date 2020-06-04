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
    private static c ljo;
    private SparseArray<HashSet<String>> ljr;
    private a ljs;
    Handler mUIHandler = new Handler(Looper.getMainLooper()) { // from class: com.baidu.tieba.s.c.1
        @Override // android.os.Handler
        public void handleMessage(Message message) {
            a aVar;
            super.handleMessage(message);
            switch (message.what) {
                case 5:
                    if ((message.obj instanceof a) && (aVar = (a) message.obj) != null) {
                        aVar.hJM = false;
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
    private CustomMessageListener dzd = new CustomMessageListener(CmdConfigCustom.METHOD_ACCOUNT_CHANGE) { // from class: com.baidu.tieba.s.c.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null) {
                if (c.this.ljr != null) {
                    c.this.ljr.clear();
                }
                c.this.ljp.dcH();
            }
        }
    };
    private int ljq = com.baidu.tbadk.core.sharedPref.b.aTX().getInt("card_show_statistic_max_count", 200);
    private final b ljp = new b();

    private c() {
        MessageManager.getInstance().registerListener(this.dzd);
    }

    public static c dcI() {
        if (ljo == null) {
            synchronized (c.class) {
                if (ljo == null) {
                    ljo = new c();
                }
            }
        }
        return ljo;
    }

    public void z(BdUniqueId bdUniqueId) {
        l.checkMainThread();
        if (bdUniqueId != null) {
            this.ljp.z(bdUniqueId);
        }
    }

    public void A(BdUniqueId bdUniqueId) {
        l.checkMainThread();
        if (bdUniqueId != null) {
            this.ljp.A(bdUniqueId);
            C(bdUniqueId);
        }
    }

    public void C(BdUniqueId bdUniqueId) {
        if (this.ljr != null) {
            this.ljr.remove(bdUniqueId.getId());
        }
    }

    public void b(BdUniqueId bdUniqueId, an anVar) {
        this.ljp.a(bdUniqueId, true);
        TiebaStatic.log(anVar);
    }

    public void a(BdUniqueId bdUniqueId, String str, an anVar) {
        if (bdUniqueId != null && anVar != null) {
            long currentTimeMillis = System.currentTimeMillis();
            if (!this.ljp.B(bdUniqueId)) {
                BdLog.e("error, bdUniqueId not register");
                return;
            }
            if (TextUtils.isEmpty(str)) {
                BdLog.e("id is null, statistic key is=" + anVar.getKey());
            }
            if (this.ljr == null) {
                this.ljr = new SparseArray<>();
            }
            HashSet<String> hashSet = this.ljr.get(bdUniqueId.getId());
            if (hashSet == null) {
                hashSet = new HashSet<>();
                this.ljr.put(bdUniqueId.getId(), hashSet);
            }
            String str2 = anVar.getKey() + PageStayDurationHelper.STAT_SOURCE_TRACE_CONNECTORS + str;
            if (!hashSet.contains(str2) && !caZ()) {
                hashSet.add(str2);
                this.ljp.a(bdUniqueId, anVar);
                if (BdLog.isDebugMode()) {
                    BdLog.d("add show statistic log success" + (System.currentTimeMillis() - currentTimeMillis));
                }
            }
        }
    }

    private boolean caZ() {
        if (this.ljs == null) {
            this.ljs = new a();
        }
        if (this.ljs.hJM) {
            return true;
        }
        long currentTimeMillis = System.currentTimeMillis();
        if (this.ljs.isRunning) {
            this.ljs.count++;
            if (currentTimeMillis - this.ljs.hJL < 120000) {
                if (this.ljs.count >= this.ljq) {
                    this.ljs.hJM = true;
                    a(this.ljs);
                    return true;
                }
            } else {
                this.ljs.isRunning = false;
                this.ljs.count = 0;
            }
        } else {
            this.ljs.isRunning = true;
            this.ljs.hJL = currentTimeMillis;
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
        this.ljp.a(bdUniqueId, z);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class a {
        public int count;
        public long hJL;
        public boolean hJM;
        public boolean isRunning;

        private a() {
            this.isRunning = false;
            this.count = 0;
            this.hJL = 0L;
            this.hJM = false;
        }
    }
}
