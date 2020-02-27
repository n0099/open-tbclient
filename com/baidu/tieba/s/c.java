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
    private static c kdP;
    private SparseArray<HashSet<String>> kdS;
    private a kdT;
    Handler mUIHandler = new Handler(Looper.getMainLooper()) { // from class: com.baidu.tieba.s.c.1
        @Override // android.os.Handler
        public void handleMessage(Message message) {
            a aVar;
            super.handleMessage(message);
            switch (message.what) {
                case 5:
                    if ((message.obj instanceof a) && (aVar = (a) message.obj) != null) {
                        aVar.gJw = false;
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
    private CustomMessageListener cLF = new CustomMessageListener(CmdConfigCustom.METHOD_ACCOUNT_CHANGE) { // from class: com.baidu.tieba.s.c.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null) {
                if (c.this.kdS != null) {
                    c.this.kdS.clear();
                }
                c.this.kdQ.cJX();
            }
        }
    };
    private int kdR = com.baidu.tbadk.core.sharedPref.b.aFB().getInt("card_show_statistic_max_count", 200);
    private final b kdQ = new b();

    private c() {
        MessageManager.getInstance().registerListener(this.cLF);
    }

    public static c cJY() {
        if (kdP == null) {
            synchronized (c.class) {
                if (kdP == null) {
                    kdP = new c();
                }
            }
        }
        return kdP;
    }

    public void w(BdUniqueId bdUniqueId) {
        l.checkMainThread();
        if (bdUniqueId != null) {
            this.kdQ.w(bdUniqueId);
        }
    }

    public void x(BdUniqueId bdUniqueId) {
        l.checkMainThread();
        if (bdUniqueId != null) {
            this.kdQ.x(bdUniqueId);
            z(bdUniqueId);
        }
    }

    public void z(BdUniqueId bdUniqueId) {
        if (this.kdS != null) {
            this.kdS.remove(bdUniqueId.getId());
        }
    }

    public void b(BdUniqueId bdUniqueId, an anVar) {
        this.kdQ.a(bdUniqueId, true);
        TiebaStatic.log(anVar);
    }

    public void a(BdUniqueId bdUniqueId, String str, an anVar) {
        if (bdUniqueId != null && anVar != null) {
            long currentTimeMillis = System.currentTimeMillis();
            if (!this.kdQ.y(bdUniqueId)) {
                BdLog.e("error, bdUniqueId not register");
                return;
            }
            if (TextUtils.isEmpty(str)) {
                BdLog.e("id is null, statistic key is=" + anVar.getKey());
            }
            if (this.kdS == null) {
                this.kdS = new SparseArray<>();
            }
            HashSet<String> hashSet = this.kdS.get(bdUniqueId.getId());
            if (hashSet == null) {
                hashSet = new HashSet<>();
                this.kdS.put(bdUniqueId.getId(), hashSet);
            }
            String str2 = anVar.getKey() + PageStayDurationHelper.STAT_SOURCE_TRACE_CONNECTORS + str;
            if (!hashSet.contains(str2) && !bJI()) {
                hashSet.add(str2);
                this.kdQ.a(bdUniqueId, anVar);
                if (BdLog.isDebugMode()) {
                    BdLog.d("add show statistic log success" + (System.currentTimeMillis() - currentTimeMillis));
                }
            }
        }
    }

    private boolean bJI() {
        if (this.kdT == null) {
            this.kdT = new a();
        }
        if (this.kdT.gJw) {
            return true;
        }
        long currentTimeMillis = System.currentTimeMillis();
        if (this.kdT.isRunning) {
            this.kdT.count++;
            if (currentTimeMillis - this.kdT.gJv < 120000) {
                if (this.kdT.count >= this.kdR) {
                    this.kdT.gJw = true;
                    a(this.kdT);
                    return true;
                }
            } else {
                this.kdT.isRunning = false;
                this.kdT.count = 0;
            }
        } else {
            this.kdT.isRunning = true;
            this.kdT.gJv = currentTimeMillis;
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
        this.kdQ.a(bdUniqueId, z);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class a {
        public int count;
        public long gJv;
        public boolean gJw;
        public boolean isRunning;

        private a() {
            this.isRunning = false;
            this.count = 0;
            this.gJv = 0L;
            this.gJw = false;
        }
    }
}
