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
    private static c lKy;
    private SparseArray<HashSet<String>> lKB;
    private a lKC;
    Handler mUIHandler = new Handler(Looper.getMainLooper()) { // from class: com.baidu.tieba.s.c.1
        @Override // android.os.Handler
        public void handleMessage(Message message) {
            a aVar;
            super.handleMessage(message);
            switch (message.what) {
                case 5:
                    if ((message.obj instanceof a) && (aVar = (a) message.obj) != null) {
                        aVar.icW = false;
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
                if (c.this.lKB != null) {
                    c.this.lKB.clear();
                }
                c.this.lKz.dkg();
            }
        }
    };
    private int lKA = com.baidu.tbadk.core.sharedPref.b.aZP().getInt("card_show_statistic_max_count", 200);
    private final b lKz = new b();

    private c() {
        MessageManager.getInstance().registerListener(this.dLt);
    }

    public static c dkh() {
        if (lKy == null) {
            synchronized (c.class) {
                if (lKy == null) {
                    lKy = new c();
                }
            }
        }
        return lKy;
    }

    public void A(BdUniqueId bdUniqueId) {
        l.checkMainThread();
        if (bdUniqueId != null) {
            this.lKz.A(bdUniqueId);
        }
    }

    public void B(BdUniqueId bdUniqueId) {
        l.checkMainThread();
        if (bdUniqueId != null) {
            this.lKz.B(bdUniqueId);
            D(bdUniqueId);
        }
    }

    public void D(BdUniqueId bdUniqueId) {
        if (this.lKB != null) {
            this.lKB.remove(bdUniqueId.getId());
        }
    }

    public void b(BdUniqueId bdUniqueId, ap apVar) {
        this.lKz.a(bdUniqueId, true);
        TiebaStatic.log(apVar);
    }

    public void a(BdUniqueId bdUniqueId, String str, ap apVar) {
        if (bdUniqueId != null && apVar != null) {
            long currentTimeMillis = System.currentTimeMillis();
            if (!this.lKz.C(bdUniqueId)) {
                BdLog.e("error, bdUniqueId not register");
                return;
            }
            if (TextUtils.isEmpty(str)) {
                BdLog.e("id is null, statistic key is=" + apVar.getKey());
            }
            if (this.lKB == null) {
                this.lKB = new SparseArray<>();
            }
            HashSet<String> hashSet = this.lKB.get(bdUniqueId.getId());
            if (hashSet == null) {
                hashSet = new HashSet<>();
                this.lKB.put(bdUniqueId.getId(), hashSet);
            }
            String str2 = apVar.getKey() + PageStayDurationHelper.STAT_SOURCE_TRACE_CONNECTORS + str;
            if (!hashSet.contains(str2) && !chR()) {
                hashSet.add(str2);
                this.lKz.a(bdUniqueId, apVar);
                if (BdLog.isDebugMode()) {
                    BdLog.d("add show statistic log success" + (System.currentTimeMillis() - currentTimeMillis));
                }
            }
        }
    }

    private boolean chR() {
        if (this.lKC == null) {
            this.lKC = new a();
        }
        if (this.lKC.icW) {
            return true;
        }
        long currentTimeMillis = System.currentTimeMillis();
        if (this.lKC.isRunning) {
            this.lKC.count++;
            if (currentTimeMillis - this.lKC.icV < 120000) {
                if (this.lKC.count >= this.lKA) {
                    this.lKC.icW = true;
                    a(this.lKC);
                    return true;
                }
            } else {
                this.lKC.isRunning = false;
                this.lKC.count = 0;
            }
        } else {
            this.lKC.isRunning = true;
            this.lKC.icV = currentTimeMillis;
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
        this.lKz.a(bdUniqueId, z);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class a {
        public int count;
        public long icV;
        public boolean icW;
        public boolean isRunning;

        private a() {
            this.isRunning = false;
            this.count = 0;
            this.icV = 0L;
            this.icW = false;
        }
    }
}
