package com.baidu.tieba.t;

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
import com.baidu.tbadk.core.util.ar;
import java.util.HashSet;
/* loaded from: classes.dex */
public class c {
    private static c mVh;
    private SparseArray<HashSet<String>> mVk;
    private a mVl;
    Handler mUIHandler = new Handler(Looper.getMainLooper()) { // from class: com.baidu.tieba.t.c.1
        @Override // android.os.Handler
        public void handleMessage(Message message) {
            a aVar;
            super.handleMessage(message);
            switch (message.what) {
                case 5:
                    if ((message.obj instanceof a) && (aVar = (a) message.obj) != null) {
                        aVar.jgz = false;
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
    private CustomMessageListener evz = new CustomMessageListener(CmdConfigCustom.METHOD_ACCOUNT_CHANGE) { // from class: com.baidu.tieba.t.c.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null) {
                if (c.this.mVk != null) {
                    c.this.mVk.clear();
                }
                c.this.mVi.dIN();
            }
        }
    };
    private int mVj = com.baidu.tbadk.core.sharedPref.b.bpu().getInt("card_show_statistic_max_count", 200);
    private final b mVi = new b();

    private c() {
        MessageManager.getInstance().registerListener(this.evz);
    }

    public static c dIO() {
        if (mVh == null) {
            synchronized (c.class) {
                if (mVh == null) {
                    mVh = new c();
                }
            }
        }
        return mVh;
    }

    public void z(BdUniqueId bdUniqueId) {
        l.checkMainThread();
        if (bdUniqueId != null) {
            this.mVi.z(bdUniqueId);
        }
    }

    public void A(BdUniqueId bdUniqueId) {
        l.checkMainThread();
        if (bdUniqueId != null) {
            this.mVi.A(bdUniqueId);
            C(bdUniqueId);
        }
    }

    public void C(BdUniqueId bdUniqueId) {
        if (this.mVk != null) {
            this.mVk.remove(bdUniqueId.getId());
        }
    }

    public void b(BdUniqueId bdUniqueId, ar arVar) {
        this.mVi.a(bdUniqueId, true);
        TiebaStatic.log(arVar);
    }

    public void a(BdUniqueId bdUniqueId, String str, ar arVar) {
        if (bdUniqueId != null && arVar != null) {
            long currentTimeMillis = System.currentTimeMillis();
            if (!this.mVi.B(bdUniqueId)) {
                BdLog.e("error, bdUniqueId not register");
                return;
            }
            if (TextUtils.isEmpty(str)) {
                BdLog.e("id is null, statistic key is=" + arVar.getKey());
            }
            if (this.mVk == null) {
                this.mVk = new SparseArray<>();
            }
            HashSet<String> hashSet = this.mVk.get(bdUniqueId.getId());
            if (hashSet == null) {
                hashSet = new HashSet<>();
                this.mVk.put(bdUniqueId.getId(), hashSet);
            }
            String str2 = arVar.getKey() + PageStayDurationHelper.STAT_SOURCE_TRACE_CONNECTORS + str;
            if (!hashSet.contains(str2) && !cEv()) {
                hashSet.add(str2);
                this.mVi.a(bdUniqueId, arVar);
                if (BdLog.isDebugMode()) {
                    BdLog.d("add show statistic log success" + (System.currentTimeMillis() - currentTimeMillis));
                }
            }
        }
    }

    private boolean cEv() {
        if (this.mVl == null) {
            this.mVl = new a();
        }
        if (this.mVl.jgz) {
            return true;
        }
        long currentTimeMillis = System.currentTimeMillis();
        if (this.mVl.isRunning) {
            this.mVl.count++;
            if (currentTimeMillis - this.mVl.jgy < 120000) {
                if (this.mVl.count >= this.mVj) {
                    this.mVl.jgz = true;
                    a(this.mVl);
                    return true;
                }
            } else {
                this.mVl.isRunning = false;
                this.mVl.count = 0;
            }
        } else {
            this.mVl.isRunning = true;
            this.mVl.jgy = currentTimeMillis;
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
        this.mVi.a(bdUniqueId, z);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class a {
        public int count;
        public boolean isRunning;
        public long jgy;
        public boolean jgz;

        private a() {
            this.isRunning = false;
            this.count = 0;
            this.jgy = 0L;
            this.jgz = false;
        }
    }
}
