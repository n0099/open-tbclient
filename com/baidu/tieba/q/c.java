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
import com.baidu.tieba.model.ReportUserInfoModel;
import java.util.HashSet;
/* loaded from: classes.dex */
public class c {
    private static c jfN;
    private SparseArray<HashSet<String>> jfQ;
    private a jfR;
    Handler mUIHandler = new Handler(Looper.getMainLooper()) { // from class: com.baidu.tieba.q.c.1
        @Override // android.os.Handler
        public void handleMessage(Message message) {
            a aVar;
            super.handleMessage(message);
            switch (message.what) {
                case 5:
                    if ((message.obj instanceof a) && (aVar = (a) message.obj) != null) {
                        aVar.fQN = false;
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
    private CustomMessageListener bVR = new CustomMessageListener(CmdConfigCustom.METHOD_ACCOUNT_CHANGE) { // from class: com.baidu.tieba.q.c.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null) {
                if (c.this.jfQ != null) {
                    c.this.jfQ.clear();
                }
                c.this.jfO.cnj();
            }
        }
    };
    private int jfP = com.baidu.tbadk.core.sharedPref.b.alR().getInt("card_show_statistic_max_count", 200);
    private final b jfO = new b();

    private c() {
        MessageManager.getInstance().registerListener(this.bVR);
    }

    public static c cnk() {
        if (jfN == null) {
            synchronized (c.class) {
                if (jfN == null) {
                    jfN = new c();
                }
            }
        }
        return jfN;
    }

    public void v(BdUniqueId bdUniqueId) {
        l.checkMainThread();
        if (bdUniqueId != null) {
            this.jfO.v(bdUniqueId);
        }
    }

    public void w(BdUniqueId bdUniqueId) {
        l.checkMainThread();
        if (bdUniqueId != null) {
            this.jfO.w(bdUniqueId);
            y(bdUniqueId);
        }
    }

    public void y(BdUniqueId bdUniqueId) {
        if (this.jfQ != null) {
            this.jfQ.remove(bdUniqueId.getId());
        }
    }

    public void b(BdUniqueId bdUniqueId, an anVar) {
        this.jfO.a(bdUniqueId, true);
        TiebaStatic.log(anVar);
    }

    public void a(BdUniqueId bdUniqueId, String str, an anVar) {
        if (bdUniqueId != null && anVar != null) {
            long currentTimeMillis = System.currentTimeMillis();
            if (!this.jfO.x(bdUniqueId)) {
                BdLog.e("error, bdUniqueId not register");
                return;
            }
            if (TextUtils.isEmpty(str)) {
                BdLog.e("id is null, statistic key is=" + anVar.getKey());
            }
            if (this.jfQ == null) {
                this.jfQ = new SparseArray<>();
            }
            HashSet<String> hashSet = this.jfQ.get(bdUniqueId.getId());
            if (hashSet == null) {
                hashSet = new HashSet<>();
                this.jfQ.put(bdUniqueId.getId(), hashSet);
            }
            String str2 = anVar.getKey() + PageStayDurationHelper.STAT_SOURCE_TRACE_CONNECTORS + str;
            if (!hashSet.contains(str2) && !bpK()) {
                hashSet.add(str2);
                this.jfO.a(bdUniqueId, anVar);
                if (BdLog.isDebugMode()) {
                    BdLog.d("add show statistic log success" + (System.currentTimeMillis() - currentTimeMillis));
                }
            }
        }
    }

    private boolean bpK() {
        if (this.jfR == null) {
            this.jfR = new a();
        }
        if (this.jfR.fQN) {
            return true;
        }
        long currentTimeMillis = System.currentTimeMillis();
        if (this.jfR.isRunning) {
            this.jfR.count++;
            if (currentTimeMillis - this.jfR.fQM < 120000) {
                if (this.jfR.count >= this.jfP) {
                    this.jfR.fQN = true;
                    a(this.jfR);
                    return true;
                }
            } else {
                this.jfR.isRunning = false;
                this.jfR.count = 0;
            }
        } else {
            this.jfR.isRunning = true;
            this.jfR.fQM = currentTimeMillis;
        }
        return false;
    }

    private void a(a aVar) {
        Message obtainMessage = this.mUIHandler.obtainMessage();
        obtainMessage.what = 5;
        obtainMessage.obj = aVar;
        this.mUIHandler.removeMessages(5);
        this.mUIHandler.sendMessageDelayed(obtainMessage, ReportUserInfoModel.TIME_INTERVAL);
    }

    public void b(BdUniqueId bdUniqueId, boolean z) {
        if (BdLog.isDebugMode()) {
            BdLog.d("logStatisticByKey start write log ");
        }
        this.jfO.a(bdUniqueId, z);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class a {
        public int count;
        public long fQM;
        public boolean fQN;
        public boolean isRunning;

        private a() {
            this.isRunning = false;
            this.count = 0;
            this.fQM = 0L;
            this.fQN = false;
        }
    }
}
