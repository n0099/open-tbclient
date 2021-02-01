package com.baidu.tieba.yuyinala.liveroom.wheat.a;

import android.os.Handler;
import android.text.TextUtils;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
/* loaded from: classes11.dex */
public class f {
    private a oFf;
    private Handler oFg;
    private ConcurrentHashMap<Long, b> oFe = new ConcurrentHashMap<>();
    boolean oFh = false;
    private Runnable mRunnable = new Runnable() { // from class: com.baidu.tieba.yuyinala.liveroom.wheat.a.f.1
        @Override // java.lang.Runnable
        public void run() {
            f.this.oFh = true;
            f.this.ecR();
            if (f.this.oFe != null && f.this.oFe.size() > 0) {
                f.this.oFg.postDelayed(f.this.mRunnable, 1000L);
            } else {
                f.this.oFh = false;
            }
        }
    };

    /* loaded from: classes11.dex */
    public interface a {
        void a(b bVar);
    }

    public f(Handler handler) {
        this.oFg = handler;
    }

    public void b(b bVar) {
        if (bVar != null && !TextUtils.isEmpty(bVar.thirdUserId)) {
            bVar.oFj = System.currentTimeMillis();
            this.oFe.put(Long.valueOf(bVar.imUK), bVar);
            sz();
        }
    }

    public void hQ(long j) {
        this.oFe.remove(Long.valueOf(j));
    }

    public void ecR() {
        Iterator<Map.Entry<Long, b>> it = this.oFe.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry<Long, b> next = it.next();
            if (System.currentTimeMillis() - next.getValue().oFj > 10000) {
                if (this.oFf != null) {
                    this.oFf.a(next.getValue());
                }
                it.remove();
            }
        }
    }

    public void a(a aVar) {
        this.oFf = aVar;
    }

    private void sz() {
        if (this.oFg == null) {
            this.oFh = false;
        } else if (this.oFe == null || this.oFe.size() == 0) {
            this.oFh = false;
        } else {
            this.oFg.postDelayed(this.mRunnable, 0L);
        }
    }

    /* loaded from: classes11.dex */
    public static class b {
        public long appId;
        public String cuid;
        public long imUK;
        public long oFj;
        public String thirdUserId;

        public b(long j, long j2, String str, String str2) {
            this.appId = j;
            this.imUK = j2;
            this.cuid = str;
            this.thirdUserId = str2;
        }
    }
}
