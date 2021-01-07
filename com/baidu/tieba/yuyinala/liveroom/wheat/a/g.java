package com.baidu.tieba.yuyinala.liveroom.wheat.a;

import android.os.Handler;
import android.text.TextUtils;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
/* loaded from: classes11.dex */
public class g {
    private a oAt;
    private Handler oAu;
    private ConcurrentHashMap<Long, b> oAs = new ConcurrentHashMap<>();
    boolean oAv = false;
    private Runnable mRunnable = new Runnable() { // from class: com.baidu.tieba.yuyinala.liveroom.wheat.a.g.1
        @Override // java.lang.Runnable
        public void run() {
            g.this.oAv = true;
            g.this.eex();
            if (g.this.oAs != null && g.this.oAs.size() > 0) {
                g.this.oAu.postDelayed(g.this.mRunnable, 1000L);
            } else {
                g.this.oAv = false;
            }
        }
    };

    /* loaded from: classes11.dex */
    public interface a {
        void b(b bVar);
    }

    public g(Handler handler) {
        this.oAu = handler;
    }

    public void c(b bVar) {
        if (bVar != null && !TextUtils.isEmpty(bVar.thirdUserId)) {
            bVar.oAx = System.currentTimeMillis();
            this.oAs.put(Long.valueOf(bVar.imUK), bVar);
            sN();
        }
    }

    public void hN(long j) {
        this.oAs.remove(Long.valueOf(j));
    }

    public void eex() {
        Iterator<Map.Entry<Long, b>> it = this.oAs.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry<Long, b> next = it.next();
            if (System.currentTimeMillis() - next.getValue().oAx > 10000) {
                if (this.oAt != null) {
                    this.oAt.b(next.getValue());
                }
                it.remove();
            }
        }
    }

    public void a(a aVar) {
        this.oAt = aVar;
    }

    private void sN() {
        if (this.oAu == null) {
            this.oAv = false;
        } else if (this.oAs == null || this.oAs.size() == 0) {
            this.oAv = false;
        } else {
            this.oAu.postDelayed(this.mRunnable, 0L);
        }
    }

    /* loaded from: classes11.dex */
    public static class b {
        public long appId;
        public String cuid;
        public long imUK;
        public long oAx;
        public String thirdUserId;

        public b(long j, long j2, String str, String str2) {
            this.appId = j;
            this.imUK = j2;
            this.cuid = str;
            this.thirdUserId = str2;
        }
    }
}
