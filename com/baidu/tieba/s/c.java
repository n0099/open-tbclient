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
    private static c lif;
    private SparseArray<HashSet<String>> lii;
    private a lij;
    Handler mUIHandler = new Handler(Looper.getMainLooper()) { // from class: com.baidu.tieba.s.c.1
        @Override // android.os.Handler
        public void handleMessage(Message message) {
            a aVar;
            super.handleMessage(message);
            switch (message.what) {
                case 5:
                    if ((message.obj instanceof a) && (aVar = (a) message.obj) != null) {
                        aVar.hIZ = false;
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
                if (c.this.lii != null) {
                    c.this.lii.clear();
                }
                c.this.lig.dcs();
            }
        }
    };
    private int lih = com.baidu.tbadk.core.sharedPref.b.aTX().getInt("card_show_statistic_max_count", 200);
    private final b lig = new b();

    private c() {
        MessageManager.getInstance().registerListener(this.dzd);
    }

    public static c dct() {
        if (lif == null) {
            synchronized (c.class) {
                if (lif == null) {
                    lif = new c();
                }
            }
        }
        return lif;
    }

    public void z(BdUniqueId bdUniqueId) {
        l.checkMainThread();
        if (bdUniqueId != null) {
            this.lig.z(bdUniqueId);
        }
    }

    public void A(BdUniqueId bdUniqueId) {
        l.checkMainThread();
        if (bdUniqueId != null) {
            this.lig.A(bdUniqueId);
            C(bdUniqueId);
        }
    }

    public void C(BdUniqueId bdUniqueId) {
        if (this.lii != null) {
            this.lii.remove(bdUniqueId.getId());
        }
    }

    public void b(BdUniqueId bdUniqueId, an anVar) {
        this.lig.a(bdUniqueId, true);
        TiebaStatic.log(anVar);
    }

    public void a(BdUniqueId bdUniqueId, String str, an anVar) {
        if (bdUniqueId != null && anVar != null) {
            long currentTimeMillis = System.currentTimeMillis();
            if (!this.lig.B(bdUniqueId)) {
                BdLog.e("error, bdUniqueId not register");
                return;
            }
            if (TextUtils.isEmpty(str)) {
                BdLog.e("id is null, statistic key is=" + anVar.getKey());
            }
            if (this.lii == null) {
                this.lii = new SparseArray<>();
            }
            HashSet<String> hashSet = this.lii.get(bdUniqueId.getId());
            if (hashSet == null) {
                hashSet = new HashSet<>();
                this.lii.put(bdUniqueId.getId(), hashSet);
            }
            String str2 = anVar.getKey() + PageStayDurationHelper.STAT_SOURCE_TRACE_CONNECTORS + str;
            if (!hashSet.contains(str2) && !caR()) {
                hashSet.add(str2);
                this.lig.a(bdUniqueId, anVar);
                if (BdLog.isDebugMode()) {
                    BdLog.d("add show statistic log success" + (System.currentTimeMillis() - currentTimeMillis));
                }
            }
        }
    }

    private boolean caR() {
        if (this.lij == null) {
            this.lij = new a();
        }
        if (this.lij.hIZ) {
            return true;
        }
        long currentTimeMillis = System.currentTimeMillis();
        if (this.lij.isRunning) {
            this.lij.count++;
            if (currentTimeMillis - this.lij.hIY < 120000) {
                if (this.lij.count >= this.lih) {
                    this.lij.hIZ = true;
                    a(this.lij);
                    return true;
                }
            } else {
                this.lij.isRunning = false;
                this.lij.count = 0;
            }
        } else {
            this.lij.isRunning = true;
            this.lij.hIY = currentTimeMillis;
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
        this.lig.a(bdUniqueId, z);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class a {
        public int count;
        public long hIY;
        public boolean hIZ;
        public boolean isRunning;

        private a() {
            this.isRunning = false;
            this.count = 0;
            this.hIY = 0L;
            this.hIZ = false;
        }
    }
}
