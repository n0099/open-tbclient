package com.baidu.tieba.yuyinala.liveroom.wheat.a;

import android.os.Handler;
import android.text.TextUtils;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
/* loaded from: classes10.dex */
public class g {
    private a ovO;
    private Handler ovP;
    private ConcurrentHashMap<Long, b> ovN = new ConcurrentHashMap<>();
    boolean ovQ = false;
    private Runnable mRunnable = new Runnable() { // from class: com.baidu.tieba.yuyinala.liveroom.wheat.a.g.1
        @Override // java.lang.Runnable
        public void run() {
            g.this.ovQ = true;
            g.this.eaF();
            if (g.this.ovN != null && g.this.ovN.size() > 0) {
                g.this.ovP.postDelayed(g.this.mRunnable, 1000L);
            } else {
                g.this.ovQ = false;
            }
        }
    };

    /* loaded from: classes10.dex */
    public interface a {
        void b(b bVar);
    }

    public g(Handler handler) {
        this.ovP = handler;
    }

    public void c(b bVar) {
        if (bVar != null && !TextUtils.isEmpty(bVar.thirdUserId)) {
            bVar.ovS = System.currentTimeMillis();
            this.ovN.put(Long.valueOf(bVar.imUK), bVar);
            sC();
        }
    }

    public void hN(long j) {
        this.ovN.remove(Long.valueOf(j));
    }

    public void eaF() {
        Iterator<Map.Entry<Long, b>> it = this.ovN.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry<Long, b> next = it.next();
            if (System.currentTimeMillis() - next.getValue().ovS > 10000) {
                if (this.ovO != null) {
                    this.ovO.b(next.getValue());
                }
                it.remove();
            }
        }
    }

    public void a(a aVar) {
        this.ovO = aVar;
    }

    private void sC() {
        if (this.ovP == null) {
            this.ovQ = false;
        } else if (this.ovN == null || this.ovN.size() == 0) {
            this.ovQ = false;
        } else {
            this.ovP.postDelayed(this.mRunnable, 0L);
        }
    }

    /* loaded from: classes10.dex */
    public static class b {
        public long appId;
        public String cuid;
        public long imUK;
        public long ovS;
        public String thirdUserId;

        public b(long j, long j2, String str, String str2) {
            this.appId = j;
            this.imUK = j2;
            this.cuid = str;
            this.thirdUserId = str2;
        }
    }
}
