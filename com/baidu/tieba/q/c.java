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
    private static c hlS;
    private SparseArray<HashSet<String>> hlV;
    private a hlW;
    Handler mUIHandler = new Handler(Looper.getMainLooper()) { // from class: com.baidu.tieba.q.c.1
        @Override // android.os.Handler
        public void handleMessage(Message message) {
            a aVar;
            super.handleMessage(message);
            switch (message.what) {
                case 5:
                    if ((message.obj instanceof a) && (aVar = (a) message.obj) != null) {
                        aVar.eeW = false;
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
    private CustomMessageListener aoI = new CustomMessageListener(2005016) { // from class: com.baidu.tieba.q.c.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null) {
                if (c.this.hlV != null) {
                    c.this.hlV.clear();
                }
                c.this.hlT.bCB();
            }
        }
    };
    private int hlU = com.baidu.tbadk.core.sharedPref.b.getInstance().getInt("card_show_statistic_max_count", 200);
    private final b hlT = new b();

    private c() {
        MessageManager.getInstance().registerListener(this.aoI);
    }

    public static c bCC() {
        if (hlS == null) {
            synchronized (c.class) {
                if (hlS == null) {
                    hlS = new c();
                }
            }
        }
        return hlS;
    }

    public void r(BdUniqueId bdUniqueId) {
        l.lj();
        if (bdUniqueId != null) {
            this.hlT.r(bdUniqueId);
        }
    }

    public void s(BdUniqueId bdUniqueId) {
        l.lj();
        if (bdUniqueId != null) {
            this.hlT.s(bdUniqueId);
            u(bdUniqueId);
        }
    }

    private void u(BdUniqueId bdUniqueId) {
        if (this.hlV != null) {
            this.hlV.remove(bdUniqueId.getId());
        }
    }

    public void b(BdUniqueId bdUniqueId, am amVar) {
        this.hlT.a(bdUniqueId, true);
        TiebaStatic.log(amVar);
    }

    public void a(BdUniqueId bdUniqueId, String str, am amVar) {
        if (bdUniqueId != null && amVar != null) {
            long currentTimeMillis = System.currentTimeMillis();
            if (!this.hlT.t(bdUniqueId)) {
                BdLog.e("error, bdUniqueId not register");
                return;
            }
            if (TextUtils.isEmpty(str)) {
                BdLog.e("id is null, statistic key is=" + amVar.getKey());
            }
            if (this.hlV == null) {
                this.hlV = new SparseArray<>();
            }
            HashSet<String> hashSet = this.hlV.get(bdUniqueId.getId());
            if (hashSet == null) {
                hashSet = new HashSet<>();
                this.hlV.put(bdUniqueId.getId(), hashSet);
            }
            String str2 = amVar.getKey() + BaseRequestAction.SPLITE + str;
            if (!hashSet.contains(str2) && !aHX()) {
                hashSet.add(str2);
                this.hlT.a(bdUniqueId, amVar);
                if (BdLog.isDebugMode()) {
                    BdLog.d("add show statistic log success" + (System.currentTimeMillis() - currentTimeMillis));
                }
            }
        }
    }

    private boolean aHX() {
        if (this.hlW == null) {
            this.hlW = new a();
        }
        if (this.hlW.eeW) {
            return true;
        }
        long currentTimeMillis = System.currentTimeMillis();
        if (this.hlW.isRunning) {
            this.hlW.count++;
            if (currentTimeMillis - this.hlW.eeV < 120000) {
                if (this.hlW.count >= this.hlU) {
                    this.hlW.eeW = true;
                    a(this.hlW);
                    return true;
                }
            } else {
                this.hlW.isRunning = false;
                this.hlW.count = 0;
            }
        } else {
            this.hlW.isRunning = true;
            this.hlW.eeV = currentTimeMillis;
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
        this.hlT.a(bdUniqueId, z);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class a {
        public int count;
        public long eeV;
        public boolean eeW;
        public boolean isRunning;

        private a() {
            this.isRunning = false;
            this.count = 0;
            this.eeV = 0L;
            this.eeW = false;
        }
    }
}
