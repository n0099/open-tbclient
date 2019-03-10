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
import com.baidu.tbadk.core.util.am;
import com.baidu.tieba.model.ReportUserInfoModel;
import java.util.HashSet;
/* loaded from: classes.dex */
public class c {
    private static c iDI;
    private SparseArray<HashSet<String>> iDL;
    private a iDM;
    Handler mUIHandler = new Handler(Looper.getMainLooper()) { // from class: com.baidu.tieba.q.c.1
        @Override // android.os.Handler
        public void handleMessage(Message message) {
            a aVar;
            super.handleMessage(message);
            switch (message.what) {
                case 5:
                    if ((message.obj instanceof a) && (aVar = (a) message.obj) != null) {
                        aVar.ftn = false;
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
    private CustomMessageListener bvr = new CustomMessageListener(2005016) { // from class: com.baidu.tieba.q.c.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null) {
                if (c.this.iDL != null) {
                    c.this.iDL.clear();
                }
                c.this.iDJ.cdq();
            }
        }
    };
    private int iDK = com.baidu.tbadk.core.sharedPref.b.getInstance().getInt("card_show_statistic_max_count", 200);
    private final b iDJ = new b();

    private c() {
        MessageManager.getInstance().registerListener(this.bvr);
    }

    public static c cdr() {
        if (iDI == null) {
            synchronized (c.class) {
                if (iDI == null) {
                    iDI = new c();
                }
            }
        }
        return iDI;
    }

    public void s(BdUniqueId bdUniqueId) {
        l.lm();
        if (bdUniqueId != null) {
            this.iDJ.s(bdUniqueId);
        }
    }

    public void t(BdUniqueId bdUniqueId) {
        l.lm();
        if (bdUniqueId != null) {
            this.iDJ.t(bdUniqueId);
            v(bdUniqueId);
        }
    }

    private void v(BdUniqueId bdUniqueId) {
        if (this.iDL != null) {
            this.iDL.remove(bdUniqueId.getId());
        }
    }

    public void b(BdUniqueId bdUniqueId, am amVar) {
        this.iDJ.a(bdUniqueId, true);
        TiebaStatic.log(amVar);
    }

    public void a(BdUniqueId bdUniqueId, String str, am amVar) {
        if (bdUniqueId != null && amVar != null) {
            long currentTimeMillis = System.currentTimeMillis();
            if (!this.iDJ.u(bdUniqueId)) {
                BdLog.e("error, bdUniqueId not register");
                return;
            }
            if (TextUtils.isEmpty(str)) {
                BdLog.e("id is null, statistic key is=" + amVar.getKey());
            }
            if (this.iDL == null) {
                this.iDL = new SparseArray<>();
            }
            HashSet<String> hashSet = this.iDL.get(bdUniqueId.getId());
            if (hashSet == null) {
                hashSet = new HashSet<>();
                this.iDL.put(bdUniqueId.getId(), hashSet);
            }
            String str2 = amVar.getKey() + "_" + str;
            if (!hashSet.contains(str2) && !bin()) {
                hashSet.add(str2);
                this.iDJ.a(bdUniqueId, amVar);
                if (BdLog.isDebugMode()) {
                    BdLog.d("add show statistic log success" + (System.currentTimeMillis() - currentTimeMillis));
                }
            }
        }
    }

    private boolean bin() {
        if (this.iDM == null) {
            this.iDM = new a();
        }
        if (this.iDM.ftn) {
            return true;
        }
        long currentTimeMillis = System.currentTimeMillis();
        if (this.iDM.isRunning) {
            this.iDM.count++;
            if (currentTimeMillis - this.iDM.ftm < 120000) {
                if (this.iDM.count >= this.iDK) {
                    this.iDM.ftn = true;
                    a(this.iDM);
                    return true;
                }
            } else {
                this.iDM.isRunning = false;
                this.iDM.count = 0;
            }
        } else {
            this.iDM.isRunning = true;
            this.iDM.ftm = currentTimeMillis;
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
        this.iDJ.a(bdUniqueId, z);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class a {
        public int count;
        public long ftm;
        public boolean ftn;
        public boolean isRunning;

        private a() {
            this.isRunning = false;
            this.count = 0;
            this.ftm = 0L;
            this.ftn = false;
        }
    }
}
