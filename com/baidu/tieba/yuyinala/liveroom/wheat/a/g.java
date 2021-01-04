package com.baidu.tieba.yuyinala.liveroom.wheat.a;

import android.os.Handler;
import android.text.TextUtils;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
/* loaded from: classes11.dex */
public class g {
    private a oAu;
    private Handler oAv;
    private ConcurrentHashMap<Long, b> oAt = new ConcurrentHashMap<>();
    boolean oAw = false;
    private Runnable mRunnable = new Runnable() { // from class: com.baidu.tieba.yuyinala.liveroom.wheat.a.g.1
        @Override // java.lang.Runnable
        public void run() {
            g.this.oAw = true;
            g.this.eew();
            if (g.this.oAt != null && g.this.oAt.size() > 0) {
                g.this.oAv.postDelayed(g.this.mRunnable, 1000L);
            } else {
                g.this.oAw = false;
            }
        }
    };

    /* loaded from: classes11.dex */
    public interface a {
        void b(b bVar);
    }

    public g(Handler handler) {
        this.oAv = handler;
    }

    public void c(b bVar) {
        if (bVar != null && !TextUtils.isEmpty(bVar.thirdUserId)) {
            bVar.oAy = System.currentTimeMillis();
            this.oAt.put(Long.valueOf(bVar.imUK), bVar);
            sN();
        }
    }

    public void hN(long j) {
        this.oAt.remove(Long.valueOf(j));
    }

    public void eew() {
        Iterator<Map.Entry<Long, b>> it = this.oAt.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry<Long, b> next = it.next();
            if (System.currentTimeMillis() - next.getValue().oAy > 10000) {
                if (this.oAu != null) {
                    this.oAu.b(next.getValue());
                }
                it.remove();
            }
        }
    }

    public void a(a aVar) {
        this.oAu = aVar;
    }

    private void sN() {
        if (this.oAv == null) {
            this.oAw = false;
        } else if (this.oAt == null || this.oAt.size() == 0) {
            this.oAw = false;
        } else {
            this.oAv.postDelayed(this.mRunnable, 0L);
        }
    }

    /* loaded from: classes11.dex */
    public static class b {
        public long appId;
        public String cuid;
        public long imUK;
        public long oAy;
        public String thirdUserId;

        public b(long j, long j2, String str, String str2) {
            this.appId = j;
            this.imUK = j2;
            this.cuid = str;
            this.thirdUserId = str2;
        }
    }
}
