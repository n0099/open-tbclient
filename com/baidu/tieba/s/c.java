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
import com.baidu.tbadk.core.util.ao;
import java.util.HashSet;
/* loaded from: classes.dex */
public class c {
    private static c lDj;
    private SparseArray<HashSet<String>> lDm;
    private a lDn;
    Handler mUIHandler = new Handler(Looper.getMainLooper()) { // from class: com.baidu.tieba.s.c.1
        @Override // android.os.Handler
        public void handleMessage(Message message) {
            a aVar;
            super.handleMessage(message);
            switch (message.what) {
                case 5:
                    if ((message.obj instanceof a) && (aVar = (a) message.obj) != null) {
                        aVar.hWY = false;
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
    private CustomMessageListener dFw = new CustomMessageListener(CmdConfigCustom.METHOD_ACCOUNT_CHANGE) { // from class: com.baidu.tieba.s.c.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null) {
                if (c.this.lDm != null) {
                    c.this.lDm.clear();
                }
                c.this.lDk.dgW();
            }
        }
    };
    private int lDl = com.baidu.tbadk.core.sharedPref.b.aVP().getInt("card_show_statistic_max_count", 200);
    private final b lDk = new b();

    private c() {
        MessageManager.getInstance().registerListener(this.dFw);
    }

    public static c dgX() {
        if (lDj == null) {
            synchronized (c.class) {
                if (lDj == null) {
                    lDj = new c();
                }
            }
        }
        return lDj;
    }

    public void z(BdUniqueId bdUniqueId) {
        l.checkMainThread();
        if (bdUniqueId != null) {
            this.lDk.z(bdUniqueId);
        }
    }

    public void A(BdUniqueId bdUniqueId) {
        l.checkMainThread();
        if (bdUniqueId != null) {
            this.lDk.A(bdUniqueId);
            C(bdUniqueId);
        }
    }

    public void C(BdUniqueId bdUniqueId) {
        if (this.lDm != null) {
            this.lDm.remove(bdUniqueId.getId());
        }
    }

    public void b(BdUniqueId bdUniqueId, ao aoVar) {
        this.lDk.a(bdUniqueId, true);
        TiebaStatic.log(aoVar);
    }

    public void a(BdUniqueId bdUniqueId, String str, ao aoVar) {
        if (bdUniqueId != null && aoVar != null) {
            long currentTimeMillis = System.currentTimeMillis();
            if (!this.lDk.B(bdUniqueId)) {
                BdLog.e("error, bdUniqueId not register");
                return;
            }
            if (TextUtils.isEmpty(str)) {
                BdLog.e("id is null, statistic key is=" + aoVar.getKey());
            }
            if (this.lDm == null) {
                this.lDm = new SparseArray<>();
            }
            HashSet<String> hashSet = this.lDm.get(bdUniqueId.getId());
            if (hashSet == null) {
                hashSet = new HashSet<>();
                this.lDm.put(bdUniqueId.getId(), hashSet);
            }
            String str2 = aoVar.getKey() + PageStayDurationHelper.STAT_SOURCE_TRACE_CONNECTORS + str;
            if (!hashSet.contains(str2) && !cer()) {
                hashSet.add(str2);
                this.lDk.a(bdUniqueId, aoVar);
                if (BdLog.isDebugMode()) {
                    BdLog.d("add show statistic log success" + (System.currentTimeMillis() - currentTimeMillis));
                }
            }
        }
    }

    private boolean cer() {
        if (this.lDn == null) {
            this.lDn = new a();
        }
        if (this.lDn.hWY) {
            return true;
        }
        long currentTimeMillis = System.currentTimeMillis();
        if (this.lDn.isRunning) {
            this.lDn.count++;
            if (currentTimeMillis - this.lDn.hWX < 120000) {
                if (this.lDn.count >= this.lDl) {
                    this.lDn.hWY = true;
                    a(this.lDn);
                    return true;
                }
            } else {
                this.lDn.isRunning = false;
                this.lDn.count = 0;
            }
        } else {
            this.lDn.isRunning = true;
            this.lDn.hWX = currentTimeMillis;
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
        this.lDk.a(bdUniqueId, z);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class a {
        public int count;
        public long hWX;
        public boolean hWY;
        public boolean isRunning;

        private a() {
            this.isRunning = false;
            this.count = 0;
            this.hWX = 0L;
            this.hWY = false;
        }
    }
}
