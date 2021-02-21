package com.baidu.tieba.yuyinala.liveroom.wheat.a;

import android.os.Handler;
import android.text.TextUtils;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
/* loaded from: classes11.dex */
public class f {
    private a oFF;
    private Handler oFG;
    private ConcurrentHashMap<Long, b> oFE = new ConcurrentHashMap<>();
    boolean oFH = false;
    private Runnable mRunnable = new Runnable() { // from class: com.baidu.tieba.yuyinala.liveroom.wheat.a.f.1
        @Override // java.lang.Runnable
        public void run() {
            f.this.oFH = true;
            f.this.ecZ();
            if (f.this.oFE != null && f.this.oFE.size() > 0) {
                f.this.oFG.postDelayed(f.this.mRunnable, 1000L);
            } else {
                f.this.oFH = false;
            }
        }
    };

    /* loaded from: classes11.dex */
    public interface a {
        void a(b bVar);
    }

    public f(Handler handler) {
        this.oFG = handler;
    }

    public void b(b bVar) {
        if (bVar != null && !TextUtils.isEmpty(bVar.thirdUserId)) {
            bVar.oFJ = System.currentTimeMillis();
            this.oFE.put(Long.valueOf(bVar.imUK), bVar);
            sz();
        }
    }

    public void hQ(long j) {
        this.oFE.remove(Long.valueOf(j));
    }

    public void ecZ() {
        Iterator<Map.Entry<Long, b>> it = this.oFE.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry<Long, b> next = it.next();
            if (System.currentTimeMillis() - next.getValue().oFJ > 10000) {
                if (this.oFF != null) {
                    this.oFF.a(next.getValue());
                }
                it.remove();
            }
        }
    }

    public void a(a aVar) {
        this.oFF = aVar;
    }

    private void sz() {
        if (this.oFG == null) {
            this.oFH = false;
        } else if (this.oFE == null || this.oFE.size() == 0) {
            this.oFH = false;
        } else {
            this.oFG.postDelayed(this.mRunnable, 0L);
        }
    }

    /* loaded from: classes11.dex */
    public static class b {
        public long appId;
        public String cuid;
        public long imUK;
        public long oFJ;
        public String thirdUserId;

        public b(long j, long j2, String str, String str2) {
            this.appId = j;
            this.imUK = j2;
            this.cuid = str;
            this.thirdUserId = str2;
        }
    }
}
