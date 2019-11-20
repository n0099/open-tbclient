package com.baidu.tieba.q;

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
    private static c jeW;
    private SparseArray<HashSet<String>> jeZ;
    private a jfa;
    Handler mUIHandler = new Handler(Looper.getMainLooper()) { // from class: com.baidu.tieba.q.c.1
        @Override // android.os.Handler
        public void handleMessage(Message message) {
            a aVar;
            super.handleMessage(message);
            switch (message.what) {
                case 5:
                    if ((message.obj instanceof a) && (aVar = (a) message.obj) != null) {
                        aVar.fPW = false;
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
    private CustomMessageListener bVa = new CustomMessageListener(CmdConfigCustom.METHOD_ACCOUNT_CHANGE) { // from class: com.baidu.tieba.q.c.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null) {
                if (c.this.jeZ != null) {
                    c.this.jeZ.clear();
                }
                c.this.jeX.cnh();
            }
        }
    };
    private int jeY = com.baidu.tbadk.core.sharedPref.b.alP().getInt("card_show_statistic_max_count", 200);
    private final b jeX = new b();

    private c() {
        MessageManager.getInstance().registerListener(this.bVa);
    }

    public static c cni() {
        if (jeW == null) {
            synchronized (c.class) {
                if (jeW == null) {
                    jeW = new c();
                }
            }
        }
        return jeW;
    }

    public void v(BdUniqueId bdUniqueId) {
        l.checkMainThread();
        if (bdUniqueId != null) {
            this.jeX.v(bdUniqueId);
        }
    }

    public void w(BdUniqueId bdUniqueId) {
        l.checkMainThread();
        if (bdUniqueId != null) {
            this.jeX.w(bdUniqueId);
            y(bdUniqueId);
        }
    }

    public void y(BdUniqueId bdUniqueId) {
        if (this.jeZ != null) {
            this.jeZ.remove(bdUniqueId.getId());
        }
    }

    public void b(BdUniqueId bdUniqueId, an anVar) {
        this.jeX.a(bdUniqueId, true);
        TiebaStatic.log(anVar);
    }

    public void a(BdUniqueId bdUniqueId, String str, an anVar) {
        if (bdUniqueId != null && anVar != null) {
            long currentTimeMillis = System.currentTimeMillis();
            if (!this.jeX.x(bdUniqueId)) {
                BdLog.e("error, bdUniqueId not register");
                return;
            }
            if (TextUtils.isEmpty(str)) {
                BdLog.e("id is null, statistic key is=" + anVar.getKey());
            }
            if (this.jeZ == null) {
                this.jeZ = new SparseArray<>();
            }
            HashSet<String> hashSet = this.jeZ.get(bdUniqueId.getId());
            if (hashSet == null) {
                hashSet = new HashSet<>();
                this.jeZ.put(bdUniqueId.getId(), hashSet);
            }
            String str2 = anVar.getKey() + PageStayDurationHelper.STAT_SOURCE_TRACE_CONNECTORS + str;
            if (!hashSet.contains(str2) && !bpI()) {
                hashSet.add(str2);
                this.jeX.a(bdUniqueId, anVar);
                if (BdLog.isDebugMode()) {
                    BdLog.d("add show statistic log success" + (System.currentTimeMillis() - currentTimeMillis));
                }
            }
        }
    }

    private boolean bpI() {
        if (this.jfa == null) {
            this.jfa = new a();
        }
        if (this.jfa.fPW) {
            return true;
        }
        long currentTimeMillis = System.currentTimeMillis();
        if (this.jfa.isRunning) {
            this.jfa.count++;
            if (currentTimeMillis - this.jfa.fPV < 120000) {
                if (this.jfa.count >= this.jeY) {
                    this.jfa.fPW = true;
                    a(this.jfa);
                    return true;
                }
            } else {
                this.jfa.isRunning = false;
                this.jfa.count = 0;
            }
        } else {
            this.jfa.isRunning = true;
            this.jfa.fPV = currentTimeMillis;
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
        this.jeX.a(bdUniqueId, z);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class a {
        public int count;
        public long fPV;
        public boolean fPW;
        public boolean isRunning;

        private a() {
            this.isRunning = false;
            this.count = 0;
            this.fPV = 0L;
            this.fPW = false;
        }
    }
}
