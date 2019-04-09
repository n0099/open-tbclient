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
    private static c iDl;
    private SparseArray<HashSet<String>> iDo;
    private a iDp;
    Handler mUIHandler = new Handler(Looper.getMainLooper()) { // from class: com.baidu.tieba.q.c.1
        @Override // android.os.Handler
        public void handleMessage(Message message) {
            a aVar;
            super.handleMessage(message);
            switch (message.what) {
                case 5:
                    if ((message.obj instanceof a) && (aVar = (a) message.obj) != null) {
                        aVar.fsY = false;
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
    private CustomMessageListener bvx = new CustomMessageListener(2005016) { // from class: com.baidu.tieba.q.c.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null) {
                if (c.this.iDo != null) {
                    c.this.iDo.clear();
                }
                c.this.iDm.cdo();
            }
        }
    };
    private int iDn = com.baidu.tbadk.core.sharedPref.b.getInstance().getInt("card_show_statistic_max_count", 200);
    private final b iDm = new b();

    private c() {
        MessageManager.getInstance().registerListener(this.bvx);
    }

    public static c cdp() {
        if (iDl == null) {
            synchronized (c.class) {
                if (iDl == null) {
                    iDl = new c();
                }
            }
        }
        return iDl;
    }

    public void s(BdUniqueId bdUniqueId) {
        l.lm();
        if (bdUniqueId != null) {
            this.iDm.s(bdUniqueId);
        }
    }

    public void t(BdUniqueId bdUniqueId) {
        l.lm();
        if (bdUniqueId != null) {
            this.iDm.t(bdUniqueId);
            v(bdUniqueId);
        }
    }

    private void v(BdUniqueId bdUniqueId) {
        if (this.iDo != null) {
            this.iDo.remove(bdUniqueId.getId());
        }
    }

    public void b(BdUniqueId bdUniqueId, am amVar) {
        this.iDm.a(bdUniqueId, true);
        TiebaStatic.log(amVar);
    }

    public void a(BdUniqueId bdUniqueId, String str, am amVar) {
        if (bdUniqueId != null && amVar != null) {
            long currentTimeMillis = System.currentTimeMillis();
            if (!this.iDm.u(bdUniqueId)) {
                BdLog.e("error, bdUniqueId not register");
                return;
            }
            if (TextUtils.isEmpty(str)) {
                BdLog.e("id is null, statistic key is=" + amVar.getKey());
            }
            if (this.iDo == null) {
                this.iDo = new SparseArray<>();
            }
            HashSet<String> hashSet = this.iDo.get(bdUniqueId.getId());
            if (hashSet == null) {
                hashSet = new HashSet<>();
                this.iDo.put(bdUniqueId.getId(), hashSet);
            }
            String str2 = amVar.getKey() + "_" + str;
            if (!hashSet.contains(str2) && !bik()) {
                hashSet.add(str2);
                this.iDm.a(bdUniqueId, amVar);
                if (BdLog.isDebugMode()) {
                    BdLog.d("add show statistic log success" + (System.currentTimeMillis() - currentTimeMillis));
                }
            }
        }
    }

    private boolean bik() {
        if (this.iDp == null) {
            this.iDp = new a();
        }
        if (this.iDp.fsY) {
            return true;
        }
        long currentTimeMillis = System.currentTimeMillis();
        if (this.iDp.isRunning) {
            this.iDp.count++;
            if (currentTimeMillis - this.iDp.fsX < 120000) {
                if (this.iDp.count >= this.iDn) {
                    this.iDp.fsY = true;
                    a(this.iDp);
                    return true;
                }
            } else {
                this.iDp.isRunning = false;
                this.iDp.count = 0;
            }
        } else {
            this.iDp.isRunning = true;
            this.iDp.fsX = currentTimeMillis;
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
        this.iDm.a(bdUniqueId, z);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class a {
        public int count;
        public long fsX;
        public boolean fsY;
        public boolean isRunning;

        private a() {
            this.isRunning = false;
            this.count = 0;
            this.fsX = 0L;
            this.fsY = false;
        }
    }
}
