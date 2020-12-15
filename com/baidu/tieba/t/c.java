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
    private static c njh;
    private SparseArray<HashSet<String>> njk;
    private a njl;
    Handler mUIHandler = new Handler(Looper.getMainLooper()) { // from class: com.baidu.tieba.t.c.1
        @Override // android.os.Handler
        public void handleMessage(Message message) {
            a aVar;
            super.handleMessage(message);
            switch (message.what) {
                case 5:
                    if ((message.obj instanceof a) && (aVar = (a) message.obj) != null) {
                        aVar.jue = false;
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
    private CustomMessageListener eCA = new CustomMessageListener(CmdConfigCustom.METHOD_ACCOUNT_CHANGE) { // from class: com.baidu.tieba.t.c.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null) {
                if (c.this.njk != null) {
                    c.this.njk.clear();
                }
                c.this.nji.dOe();
            }
        }
    };
    private int njj = com.baidu.tbadk.core.sharedPref.b.bsO().getInt("card_show_statistic_max_count", 200);
    private final b nji = new b();

    private c() {
        MessageManager.getInstance().registerListener(this.eCA);
    }

    public static c dOf() {
        if (njh == null) {
            synchronized (c.class) {
                if (njh == null) {
                    njh = new c();
                }
            }
        }
        return njh;
    }

    public void z(BdUniqueId bdUniqueId) {
        l.checkMainThread();
        if (bdUniqueId != null) {
            this.nji.z(bdUniqueId);
        }
    }

    public void A(BdUniqueId bdUniqueId) {
        l.checkMainThread();
        if (bdUniqueId != null) {
            this.nji.A(bdUniqueId);
            C(bdUniqueId);
        }
    }

    public void C(BdUniqueId bdUniqueId) {
        if (this.njk != null) {
            this.njk.remove(bdUniqueId.getId());
        }
    }

    public void b(BdUniqueId bdUniqueId, ar arVar) {
        this.nji.a(bdUniqueId, true);
        TiebaStatic.log(arVar);
    }

    public void a(BdUniqueId bdUniqueId, String str, ar arVar) {
        if (bdUniqueId != null && arVar != null) {
            long currentTimeMillis = System.currentTimeMillis();
            if (!this.nji.B(bdUniqueId)) {
                BdLog.e("error, bdUniqueId not register");
                return;
            }
            if (TextUtils.isEmpty(str)) {
                BdLog.e("id is null, statistic key is=" + arVar.getKey());
            }
            if (this.njk == null) {
                this.njk = new SparseArray<>();
            }
            HashSet<String> hashSet = this.njk.get(bdUniqueId.getId());
            if (hashSet == null) {
                hashSet = new HashSet<>();
                this.njk.put(bdUniqueId.getId(), hashSet);
            }
            String str2 = arVar.getKey() + PageStayDurationHelper.STAT_SOURCE_TRACE_CONNECTORS + str;
            if (!hashSet.contains(str2) && !cJJ()) {
                hashSet.add(str2);
                this.nji.a(bdUniqueId, arVar);
                if (BdLog.isDebugMode()) {
                    BdLog.d("add show statistic log success" + (System.currentTimeMillis() - currentTimeMillis));
                }
            }
        }
    }

    private boolean cJJ() {
        if (this.njl == null) {
            this.njl = new a();
        }
        if (this.njl.jue) {
            return true;
        }
        long currentTimeMillis = System.currentTimeMillis();
        if (this.njl.isRunning) {
            this.njl.count++;
            if (currentTimeMillis - this.njl.jud < 120000) {
                if (this.njl.count >= this.njj) {
                    this.njl.jue = true;
                    a(this.njl);
                    return true;
                }
            } else {
                this.njl.isRunning = false;
                this.njl.count = 0;
            }
        } else {
            this.njl.isRunning = true;
            this.njl.jud = currentTimeMillis;
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
        this.nji.a(bdUniqueId, z);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class a {
        public int count;
        public boolean isRunning;
        public long jud;
        public boolean jue;

        private a() {
            this.isRunning = false;
            this.count = 0;
            this.jud = 0L;
            this.jue = false;
        }
    }
}
