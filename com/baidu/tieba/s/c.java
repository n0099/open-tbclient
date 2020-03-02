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
    private static c kdR;
    private SparseArray<HashSet<String>> kdU;
    private a kdV;
    Handler mUIHandler = new Handler(Looper.getMainLooper()) { // from class: com.baidu.tieba.s.c.1
        @Override // android.os.Handler
        public void handleMessage(Message message) {
            a aVar;
            super.handleMessage(message);
            switch (message.what) {
                case 5:
                    if ((message.obj instanceof a) && (aVar = (a) message.obj) != null) {
                        aVar.gJy = false;
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
    private CustomMessageListener cLG = new CustomMessageListener(CmdConfigCustom.METHOD_ACCOUNT_CHANGE) { // from class: com.baidu.tieba.s.c.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null) {
                if (c.this.kdU != null) {
                    c.this.kdU.clear();
                }
                c.this.kdS.cJZ();
            }
        }
    };
    private int kdT = com.baidu.tbadk.core.sharedPref.b.aFD().getInt("card_show_statistic_max_count", 200);
    private final b kdS = new b();

    private c() {
        MessageManager.getInstance().registerListener(this.cLG);
    }

    public static c cKa() {
        if (kdR == null) {
            synchronized (c.class) {
                if (kdR == null) {
                    kdR = new c();
                }
            }
        }
        return kdR;
    }

    public void w(BdUniqueId bdUniqueId) {
        l.checkMainThread();
        if (bdUniqueId != null) {
            this.kdS.w(bdUniqueId);
        }
    }

    public void x(BdUniqueId bdUniqueId) {
        l.checkMainThread();
        if (bdUniqueId != null) {
            this.kdS.x(bdUniqueId);
            z(bdUniqueId);
        }
    }

    public void z(BdUniqueId bdUniqueId) {
        if (this.kdU != null) {
            this.kdU.remove(bdUniqueId.getId());
        }
    }

    public void b(BdUniqueId bdUniqueId, an anVar) {
        this.kdS.a(bdUniqueId, true);
        TiebaStatic.log(anVar);
    }

    public void a(BdUniqueId bdUniqueId, String str, an anVar) {
        if (bdUniqueId != null && anVar != null) {
            long currentTimeMillis = System.currentTimeMillis();
            if (!this.kdS.y(bdUniqueId)) {
                BdLog.e("error, bdUniqueId not register");
                return;
            }
            if (TextUtils.isEmpty(str)) {
                BdLog.e("id is null, statistic key is=" + anVar.getKey());
            }
            if (this.kdU == null) {
                this.kdU = new SparseArray<>();
            }
            HashSet<String> hashSet = this.kdU.get(bdUniqueId.getId());
            if (hashSet == null) {
                hashSet = new HashSet<>();
                this.kdU.put(bdUniqueId.getId(), hashSet);
            }
            String str2 = anVar.getKey() + PageStayDurationHelper.STAT_SOURCE_TRACE_CONNECTORS + str;
            if (!hashSet.contains(str2) && !bJK()) {
                hashSet.add(str2);
                this.kdS.a(bdUniqueId, anVar);
                if (BdLog.isDebugMode()) {
                    BdLog.d("add show statistic log success" + (System.currentTimeMillis() - currentTimeMillis));
                }
            }
        }
    }

    private boolean bJK() {
        if (this.kdV == null) {
            this.kdV = new a();
        }
        if (this.kdV.gJy) {
            return true;
        }
        long currentTimeMillis = System.currentTimeMillis();
        if (this.kdV.isRunning) {
            this.kdV.count++;
            if (currentTimeMillis - this.kdV.gJx < 120000) {
                if (this.kdV.count >= this.kdT) {
                    this.kdV.gJy = true;
                    a(this.kdV);
                    return true;
                }
            } else {
                this.kdV.isRunning = false;
                this.kdV.count = 0;
            }
        } else {
            this.kdV.isRunning = true;
            this.kdV.gJx = currentTimeMillis;
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
        this.kdS.a(bdUniqueId, z);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class a {
        public int count;
        public long gJx;
        public boolean gJy;
        public boolean isRunning;

        private a() {
            this.isRunning = false;
            this.count = 0;
            this.gJx = 0L;
            this.gJy = false;
        }
    }
}
