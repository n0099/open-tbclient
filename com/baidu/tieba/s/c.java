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
import com.baidu.tbadk.core.util.ap;
import java.util.HashSet;
/* loaded from: classes.dex */
public class c {
    private static c lKA;
    private SparseArray<HashSet<String>> lKD;
    private a lKE;
    Handler mUIHandler = new Handler(Looper.getMainLooper()) { // from class: com.baidu.tieba.s.c.1
        @Override // android.os.Handler
        public void handleMessage(Message message) {
            a aVar;
            super.handleMessage(message);
            switch (message.what) {
                case 5:
                    if ((message.obj instanceof a) && (aVar = (a) message.obj) != null) {
                        aVar.icY = false;
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
    private CustomMessageListener dLt = new CustomMessageListener(CmdConfigCustom.METHOD_ACCOUNT_CHANGE) { // from class: com.baidu.tieba.s.c.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null) {
                if (c.this.lKD != null) {
                    c.this.lKD.clear();
                }
                c.this.lKB.dkg();
            }
        }
    };
    private int lKC = com.baidu.tbadk.core.sharedPref.b.aZP().getInt("card_show_statistic_max_count", 200);
    private final b lKB = new b();

    private c() {
        MessageManager.getInstance().registerListener(this.dLt);
    }

    public static c dkh() {
        if (lKA == null) {
            synchronized (c.class) {
                if (lKA == null) {
                    lKA = new c();
                }
            }
        }
        return lKA;
    }

    public void A(BdUniqueId bdUniqueId) {
        l.checkMainThread();
        if (bdUniqueId != null) {
            this.lKB.A(bdUniqueId);
        }
    }

    public void B(BdUniqueId bdUniqueId) {
        l.checkMainThread();
        if (bdUniqueId != null) {
            this.lKB.B(bdUniqueId);
            D(bdUniqueId);
        }
    }

    public void D(BdUniqueId bdUniqueId) {
        if (this.lKD != null) {
            this.lKD.remove(bdUniqueId.getId());
        }
    }

    public void b(BdUniqueId bdUniqueId, ap apVar) {
        this.lKB.a(bdUniqueId, true);
        TiebaStatic.log(apVar);
    }

    public void a(BdUniqueId bdUniqueId, String str, ap apVar) {
        if (bdUniqueId != null && apVar != null) {
            long currentTimeMillis = System.currentTimeMillis();
            if (!this.lKB.C(bdUniqueId)) {
                BdLog.e("error, bdUniqueId not register");
                return;
            }
            if (TextUtils.isEmpty(str)) {
                BdLog.e("id is null, statistic key is=" + apVar.getKey());
            }
            if (this.lKD == null) {
                this.lKD = new SparseArray<>();
            }
            HashSet<String> hashSet = this.lKD.get(bdUniqueId.getId());
            if (hashSet == null) {
                hashSet = new HashSet<>();
                this.lKD.put(bdUniqueId.getId(), hashSet);
            }
            String str2 = apVar.getKey() + PageStayDurationHelper.STAT_SOURCE_TRACE_CONNECTORS + str;
            if (!hashSet.contains(str2) && !chR()) {
                hashSet.add(str2);
                this.lKB.a(bdUniqueId, apVar);
                if (BdLog.isDebugMode()) {
                    BdLog.d("add show statistic log success" + (System.currentTimeMillis() - currentTimeMillis));
                }
            }
        }
    }

    private boolean chR() {
        if (this.lKE == null) {
            this.lKE = new a();
        }
        if (this.lKE.icY) {
            return true;
        }
        long currentTimeMillis = System.currentTimeMillis();
        if (this.lKE.isRunning) {
            this.lKE.count++;
            if (currentTimeMillis - this.lKE.icX < 120000) {
                if (this.lKE.count >= this.lKC) {
                    this.lKE.icY = true;
                    a(this.lKE);
                    return true;
                }
            } else {
                this.lKE.isRunning = false;
                this.lKE.count = 0;
            }
        } else {
            this.lKE.isRunning = true;
            this.lKE.icX = currentTimeMillis;
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
        this.lKB.a(bdUniqueId, z);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class a {
        public int count;
        public long icX;
        public boolean icY;
        public boolean isRunning;

        private a() {
            this.isRunning = false;
            this.count = 0;
            this.icX = 0L;
            this.icY = false;
        }
    }
}
