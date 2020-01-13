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
    private static c kcL;
    private SparseArray<HashSet<String>> kcO;
    private a kcP;
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
                if (c.this.kcO != null) {
                    c.this.kcO.clear();
                }
                c.this.kcM.cIr();
            }
        }
    };
    private int kcN = com.baidu.tbadk.core.sharedPref.b.aDr().getInt("card_show_statistic_max_count", 200);
    private final b kcM = new b();

    private c() {
        MessageManager.getInstance().registerListener(this.cHC);
    }

    public static c cIs() {
        if (kcL == null) {
            synchronized (c.class) {
                if (kcL == null) {
                    kcL = new c();
                }
            }
        }
        return kcL;
    }

    public void w(BdUniqueId bdUniqueId) {
        l.checkMainThread();
        if (bdUniqueId != null) {
            this.kcM.w(bdUniqueId);
        }
    }

    public void x(BdUniqueId bdUniqueId) {
        l.checkMainThread();
        if (bdUniqueId != null) {
            this.kcM.x(bdUniqueId);
            z(bdUniqueId);
        }
    }

    public void z(BdUniqueId bdUniqueId) {
        if (this.kcO != null) {
            this.kcO.remove(bdUniqueId.getId());
        }
    }

    public void b(BdUniqueId bdUniqueId, an anVar) {
        this.kcM.a(bdUniqueId, true);
        TiebaStatic.log(anVar);
    }

    public void a(BdUniqueId bdUniqueId, String str, an anVar) {
        if (bdUniqueId != null && anVar != null) {
            long currentTimeMillis = System.currentTimeMillis();
            if (!this.kcM.y(bdUniqueId)) {
                BdLog.e("error, bdUniqueId not register");
                return;
            }
            if (TextUtils.isEmpty(str)) {
                BdLog.e("id is null, statistic key is=" + anVar.getKey());
            }
            if (this.kcO == null) {
                this.kcO = new SparseArray<>();
            }
            HashSet<String> hashSet = this.kcO.get(bdUniqueId.getId());
            if (hashSet == null) {
                hashSet = new HashSet<>();
                this.kcO.put(bdUniqueId.getId(), hashSet);
            }
            String str2 = anVar.getKey() + PageStayDurationHelper.STAT_SOURCE_TRACE_CONNECTORS + str;
            if (!hashSet.contains(str2) && !bIg()) {
                hashSet.add(str2);
                this.kcM.a(bdUniqueId, anVar);
                if (BdLog.isDebugMode()) {
                    BdLog.d("add show statistic log success" + (System.currentTimeMillis() - currentTimeMillis));
                }
            }
        }
    }

    private boolean bIg() {
        if (this.kcP == null) {
            this.kcP = new a();
        }
        if (this.kcP.gHx) {
            return true;
        }
        long currentTimeMillis = System.currentTimeMillis();
        if (this.kcP.isRunning) {
            this.kcP.count++;
            if (currentTimeMillis - this.kcP.gHw < 120000) {
                if (this.kcP.count >= this.kcN) {
                    this.kcP.gHx = true;
                    a(this.kcP);
                    return true;
                }
            } else {
                this.kcP.isRunning = false;
                this.kcP.count = 0;
            }
        } else {
            this.kcP.isRunning = true;
            this.kcP.gHw = currentTimeMillis;
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
        this.kcM.a(bdUniqueId, z);
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
