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
import com.baidu.searchbox.ng.ai.apps.network.BaseRequestAction;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.am;
import com.baidu.tieba.model.ReportUserInfoModel;
import java.util.HashSet;
/* loaded from: classes.dex */
public class c {
    private static c hlR;
    private SparseArray<HashSet<String>> hlU;
    private a hlV;
    Handler mUIHandler = new Handler(Looper.getMainLooper()) { // from class: com.baidu.tieba.q.c.1
        @Override // android.os.Handler
        public void handleMessage(Message message) {
            a aVar;
            super.handleMessage(message);
            switch (message.what) {
                case 5:
                    if ((message.obj instanceof a) && (aVar = (a) message.obj) != null) {
                        aVar.eeV = false;
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
    private CustomMessageListener aoH = new CustomMessageListener(2005016) { // from class: com.baidu.tieba.q.c.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null) {
                if (c.this.hlU != null) {
                    c.this.hlU.clear();
                }
                c.this.hlS.bCB();
            }
        }
    };
    private int hlT = com.baidu.tbadk.core.sharedPref.b.getInstance().getInt("card_show_statistic_max_count", 200);
    private final b hlS = new b();

    private c() {
        MessageManager.getInstance().registerListener(this.aoH);
    }

    public static c bCC() {
        if (hlR == null) {
            synchronized (c.class) {
                if (hlR == null) {
                    hlR = new c();
                }
            }
        }
        return hlR;
    }

    public void r(BdUniqueId bdUniqueId) {
        l.lj();
        if (bdUniqueId != null) {
            this.hlS.r(bdUniqueId);
        }
    }

    public void s(BdUniqueId bdUniqueId) {
        l.lj();
        if (bdUniqueId != null) {
            this.hlS.s(bdUniqueId);
            u(bdUniqueId);
        }
    }

    private void u(BdUniqueId bdUniqueId) {
        if (this.hlU != null) {
            this.hlU.remove(bdUniqueId.getId());
        }
    }

    public void b(BdUniqueId bdUniqueId, am amVar) {
        this.hlS.a(bdUniqueId, true);
        TiebaStatic.log(amVar);
    }

    public void a(BdUniqueId bdUniqueId, String str, am amVar) {
        if (bdUniqueId != null && amVar != null) {
            long currentTimeMillis = System.currentTimeMillis();
            if (!this.hlS.t(bdUniqueId)) {
                BdLog.e("error, bdUniqueId not register");
                return;
            }
            if (TextUtils.isEmpty(str)) {
                BdLog.e("id is null, statistic key is=" + amVar.getKey());
            }
            if (this.hlU == null) {
                this.hlU = new SparseArray<>();
            }
            HashSet<String> hashSet = this.hlU.get(bdUniqueId.getId());
            if (hashSet == null) {
                hashSet = new HashSet<>();
                this.hlU.put(bdUniqueId.getId(), hashSet);
            }
            String str2 = amVar.getKey() + BaseRequestAction.SPLITE + str;
            if (!hashSet.contains(str2) && !aHX()) {
                hashSet.add(str2);
                this.hlS.a(bdUniqueId, amVar);
                if (BdLog.isDebugMode()) {
                    BdLog.d("add show statistic log success" + (System.currentTimeMillis() - currentTimeMillis));
                }
            }
        }
    }

    private boolean aHX() {
        if (this.hlV == null) {
            this.hlV = new a();
        }
        if (this.hlV.eeV) {
            return true;
        }
        long currentTimeMillis = System.currentTimeMillis();
        if (this.hlV.isRunning) {
            this.hlV.count++;
            if (currentTimeMillis - this.hlV.eeU < 120000) {
                if (this.hlV.count >= this.hlT) {
                    this.hlV.eeV = true;
                    a(this.hlV);
                    return true;
                }
            } else {
                this.hlV.isRunning = false;
                this.hlV.count = 0;
            }
        } else {
            this.hlV.isRunning = true;
            this.hlV.eeU = currentTimeMillis;
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
        this.hlS.a(bdUniqueId, z);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class a {
        public int count;
        public long eeU;
        public boolean eeV;
        public boolean isRunning;

        private a() {
            this.isRunning = false;
            this.count = 0;
            this.eeU = 0L;
            this.eeV = false;
        }
    }
}
