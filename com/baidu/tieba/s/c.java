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
import com.baidu.tbadk.core.util.ar;
import java.util.HashSet;
/* loaded from: classes.dex */
public class c {
    private static c nwu;
    private SparseArray<HashSet<String>> nwx;
    private a nwy;
    Handler mUIHandler = new Handler(Looper.getMainLooper()) { // from class: com.baidu.tieba.s.c.1
        @Override // android.os.Handler
        public void handleMessage(Message message) {
            a aVar;
            super.handleMessage(message);
            switch (message.what) {
                case 5:
                    if ((message.obj instanceof a) && (aVar = (a) message.obj) != null) {
                        aVar.jJu = false;
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
    private CustomMessageListener eLa = new CustomMessageListener(CmdConfigCustom.METHOD_ACCOUNT_CHANGE) { // from class: com.baidu.tieba.s.c.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null) {
                if (c.this.nwx != null) {
                    c.this.nwx.clear();
                }
                c.this.nwv.dMG();
            }
        }
    };
    private int nww = com.baidu.tbadk.core.sharedPref.b.brR().getInt("card_show_statistic_max_count", 200);
    private final b nwv = new b();

    private c() {
        MessageManager.getInstance().registerListener(this.eLa);
    }

    public static c dMH() {
        if (nwu == null) {
            synchronized (c.class) {
                if (nwu == null) {
                    nwu = new c();
                }
            }
        }
        return nwu;
    }

    public void B(BdUniqueId bdUniqueId) {
        l.checkMainThread();
        if (bdUniqueId != null) {
            this.nwv.B(bdUniqueId);
        }
    }

    public void C(BdUniqueId bdUniqueId) {
        l.checkMainThread();
        if (bdUniqueId != null) {
            this.nwv.C(bdUniqueId);
            E(bdUniqueId);
        }
    }

    public void E(BdUniqueId bdUniqueId) {
        if (this.nwx != null) {
            this.nwx.remove(bdUniqueId.getId());
        }
    }

    public void b(BdUniqueId bdUniqueId, ar arVar) {
        this.nwv.a(bdUniqueId, true);
        TiebaStatic.log(arVar);
    }

    public void a(BdUniqueId bdUniqueId, String str, ar arVar) {
        if (bdUniqueId != null && arVar != null) {
            long currentTimeMillis = System.currentTimeMillis();
            if (!this.nwv.D(bdUniqueId)) {
                BdLog.e("error, bdUniqueId not register");
                return;
            }
            if (TextUtils.isEmpty(str)) {
                BdLog.e("id is null, statistic key is=" + arVar.getKey());
            }
            if (this.nwx == null) {
                this.nwx = new SparseArray<>();
            }
            HashSet<String> hashSet = this.nwx.get(bdUniqueId.getId());
            if (hashSet == null) {
                hashSet = new HashSet<>();
                this.nwx.put(bdUniqueId.getId(), hashSet);
            }
            String str2 = arVar.getKey() + PageStayDurationHelper.STAT_SOURCE_TRACE_CONNECTORS + str;
            if (!hashSet.contains(str2) && !cKs()) {
                hashSet.add(str2);
                this.nwv.a(bdUniqueId, arVar);
                if (BdLog.isDebugMode()) {
                    BdLog.d("add show statistic log success" + (System.currentTimeMillis() - currentTimeMillis));
                }
            }
        }
    }

    private boolean cKs() {
        if (this.nwy == null) {
            this.nwy = new a();
        }
        if (this.nwy.jJu) {
            return true;
        }
        long currentTimeMillis = System.currentTimeMillis();
        if (this.nwy.isRunning) {
            this.nwy.count++;
            if (currentTimeMillis - this.nwy.jJt < 120000) {
                if (this.nwy.count >= this.nww) {
                    this.nwy.jJu = true;
                    a(this.nwy);
                    return true;
                }
            } else {
                this.nwy.isRunning = false;
                this.nwy.count = 0;
            }
        } else {
            this.nwy.isRunning = true;
            this.nwy.jJt = currentTimeMillis;
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
        this.nwv.a(bdUniqueId, z);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class a {
        public int count;
        public boolean isRunning;
        public long jJt;
        public boolean jJu;

        private a() {
            this.isRunning = false;
            this.count = 0;
            this.jJt = 0L;
            this.jJu = false;
        }
    }
}
