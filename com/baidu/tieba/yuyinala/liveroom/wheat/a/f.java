package com.baidu.tieba.yuyinala.liveroom.wheat.a;

import android.os.Handler;
import android.text.TextUtils;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
/* loaded from: classes10.dex */
public class f {
    private a oHK;
    private Handler oHL;
    private ConcurrentHashMap<Long, b> oHJ = new ConcurrentHashMap<>();
    boolean oHM = false;
    private Runnable mRunnable = new Runnable() { // from class: com.baidu.tieba.yuyinala.liveroom.wheat.a.f.1
        @Override // java.lang.Runnable
        public void run() {
            f.this.oHM = true;
            f.this.edh();
            if (f.this.oHJ != null && f.this.oHJ.size() > 0) {
                f.this.oHL.postDelayed(f.this.mRunnable, 1000L);
            } else {
                f.this.oHM = false;
            }
        }
    };

    /* loaded from: classes10.dex */
    public interface a {
        void a(b bVar);
    }

    public f(Handler handler) {
        this.oHL = handler;
    }

    public void b(b bVar) {
        if (bVar != null && !TextUtils.isEmpty(bVar.thirdUserId)) {
            bVar.oHO = System.currentTimeMillis();
            this.oHJ.put(Long.valueOf(bVar.imUK), bVar);
            sz();
        }
    }

    public void hQ(long j) {
        this.oHJ.remove(Long.valueOf(j));
    }

    public void edh() {
        Iterator<Map.Entry<Long, b>> it = this.oHJ.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry<Long, b> next = it.next();
            if (System.currentTimeMillis() - next.getValue().oHO > 10000) {
                if (this.oHK != null) {
                    this.oHK.a(next.getValue());
                }
                it.remove();
            }
        }
    }

    public void a(a aVar) {
        this.oHK = aVar;
    }

    private void sz() {
        if (this.oHL == null) {
            this.oHM = false;
        } else if (this.oHJ == null || this.oHJ.size() == 0) {
            this.oHM = false;
        } else {
            this.oHL.postDelayed(this.mRunnable, 0L);
        }
    }

    /* loaded from: classes10.dex */
    public static class b {
        public long appId;
        public String cuid;
        public long imUK;
        public long oHO;
        public String thirdUserId;

        public b(long j, long j2, String str, String str2) {
            this.appId = j;
            this.imUK = j2;
            this.cuid = str;
            this.thirdUserId = str2;
        }
    }
}
