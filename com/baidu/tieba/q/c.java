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
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.an;
import com.baidu.tieba.model.ReportUserInfoModel;
import java.util.HashSet;
/* loaded from: classes.dex */
public class c {
    private static c jdB;
    private SparseArray<HashSet<String>> jdE;
    private a jdF;
    Handler mUIHandler = new Handler(Looper.getMainLooper()) { // from class: com.baidu.tieba.q.c.1
        @Override // android.os.Handler
        public void handleMessage(Message message) {
            a aVar;
            super.handleMessage(message);
            switch (message.what) {
                case 5:
                    if ((message.obj instanceof a) && (aVar = (a) message.obj) != null) {
                        aVar.fPD = false;
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
    private CustomMessageListener bDy = new CustomMessageListener(2005016) { // from class: com.baidu.tieba.q.c.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null) {
                if (c.this.jdE != null) {
                    c.this.jdE.clear();
                }
                c.this.jdC.coF();
            }
        }
    };
    private int jdD = com.baidu.tbadk.core.sharedPref.b.ahQ().getInt("card_show_statistic_max_count", 200);
    private final b jdC = new b();

    private c() {
        MessageManager.getInstance().registerListener(this.bDy);
    }

    public static c coG() {
        if (jdB == null) {
            synchronized (c.class) {
                if (jdB == null) {
                    jdB = new c();
                }
            }
        }
        return jdB;
    }

    public void u(BdUniqueId bdUniqueId) {
        l.kr();
        if (bdUniqueId != null) {
            this.jdC.u(bdUniqueId);
        }
    }

    public void v(BdUniqueId bdUniqueId) {
        l.kr();
        if (bdUniqueId != null) {
            this.jdC.v(bdUniqueId);
            x(bdUniqueId);
        }
    }

    public void x(BdUniqueId bdUniqueId) {
        if (this.jdE != null) {
            this.jdE.remove(bdUniqueId.getId());
        }
    }

    public void b(BdUniqueId bdUniqueId, an anVar) {
        this.jdC.a(bdUniqueId, true);
        TiebaStatic.log(anVar);
    }

    public void a(BdUniqueId bdUniqueId, String str, an anVar) {
        if (bdUniqueId != null && anVar != null) {
            long currentTimeMillis = System.currentTimeMillis();
            if (!this.jdC.w(bdUniqueId)) {
                BdLog.e("error, bdUniqueId not register");
                return;
            }
            if (TextUtils.isEmpty(str)) {
                BdLog.e("id is null, statistic key is=" + anVar.getKey());
            }
            if (this.jdE == null) {
                this.jdE = new SparseArray<>();
            }
            HashSet<String> hashSet = this.jdE.get(bdUniqueId.getId());
            if (hashSet == null) {
                hashSet = new HashSet<>();
                this.jdE.put(bdUniqueId.getId(), hashSet);
            }
            String str2 = anVar.getKey() + "_" + str;
            if (!hashSet.contains(str2) && !brT()) {
                hashSet.add(str2);
                this.jdC.a(bdUniqueId, anVar);
                if (BdLog.isDebugMode()) {
                    BdLog.d("add show statistic log success" + (System.currentTimeMillis() - currentTimeMillis));
                }
            }
        }
    }

    private boolean brT() {
        if (this.jdF == null) {
            this.jdF = new a();
        }
        if (this.jdF.fPD) {
            return true;
        }
        long currentTimeMillis = System.currentTimeMillis();
        if (this.jdF.isRunning) {
            this.jdF.count++;
            if (currentTimeMillis - this.jdF.fPC < 120000) {
                if (this.jdF.count >= this.jdD) {
                    this.jdF.fPD = true;
                    a(this.jdF);
                    return true;
                }
            } else {
                this.jdF.isRunning = false;
                this.jdF.count = 0;
            }
        } else {
            this.jdF.isRunning = true;
            this.jdF.fPC = currentTimeMillis;
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
        this.jdC.a(bdUniqueId, z);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class a {
        public int count;
        public long fPC;
        public boolean fPD;
        public boolean isRunning;

        private a() {
            this.isRunning = false;
            this.count = 0;
            this.fPC = 0L;
            this.fPD = false;
        }
    }
}
