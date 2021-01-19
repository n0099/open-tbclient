package com.baidu.tieba.yuyinala.liveroom.wheat.a;

import android.os.Handler;
import android.text.TextUtils;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
/* loaded from: classes10.dex */
public class g {
    private a ovP;
    private Handler ovQ;
    private ConcurrentHashMap<Long, b> ovO = new ConcurrentHashMap<>();
    boolean ovR = false;
    private Runnable mRunnable = new Runnable() { // from class: com.baidu.tieba.yuyinala.liveroom.wheat.a.g.1
        @Override // java.lang.Runnable
        public void run() {
            g.this.ovR = true;
            g.this.eaF();
            if (g.this.ovO != null && g.this.ovO.size() > 0) {
                g.this.ovQ.postDelayed(g.this.mRunnable, 1000L);
            } else {
                g.this.ovR = false;
            }
        }
    };

    /* loaded from: classes10.dex */
    public interface a {
        void b(b bVar);
    }

    public g(Handler handler) {
        this.ovQ = handler;
    }

    public void c(b bVar) {
        if (bVar != null && !TextUtils.isEmpty(bVar.thirdUserId)) {
            bVar.ovT = System.currentTimeMillis();
            this.ovO.put(Long.valueOf(bVar.imUK), bVar);
            sC();
        }
    }

    public void hN(long j) {
        this.ovO.remove(Long.valueOf(j));
    }

    public void eaF() {
        Iterator<Map.Entry<Long, b>> it = this.ovO.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry<Long, b> next = it.next();
            if (System.currentTimeMillis() - next.getValue().ovT > 10000) {
                if (this.ovP != null) {
                    this.ovP.b(next.getValue());
                }
                it.remove();
            }
        }
    }

    public void a(a aVar) {
        this.ovP = aVar;
    }

    private void sC() {
        if (this.ovQ == null) {
            this.ovR = false;
        } else if (this.ovO == null || this.ovO.size() == 0) {
            this.ovR = false;
        } else {
            this.ovQ.postDelayed(this.mRunnable, 0L);
        }
    }

    /* loaded from: classes10.dex */
    public static class b {
        public long appId;
        public String cuid;
        public long imUK;
        public long ovT;
        public String thirdUserId;

        public b(long j, long j2, String str, String str2) {
            this.appId = j;
            this.imUK = j2;
            this.cuid = str;
            this.thirdUserId = str2;
        }
    }
}
