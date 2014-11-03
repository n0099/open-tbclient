package com.baidu.tieba.util;

import com.baidu.adp.lib.util.BdLog;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes.dex */
public class o {
    private volatile int bQp;
    private volatile HashMap<Long, Integer> bQq = new HashMap<>();
    private volatile int bQo = 0;

    public o(int i) {
        this.bQp = i;
    }

    public void hG(String str) {
        try {
            Long valueOf = Long.valueOf(Long.parseLong(str));
            synchronized (this) {
                if (this.bQq.size() >= this.bQp) {
                    aeL();
                }
                this.bQo++;
                this.bQq.put(valueOf, Integer.valueOf(this.bQo));
            }
        } catch (Exception e) {
            BdLog.e(e.getMessage());
        }
    }

    public void aeL() {
        synchronized (this) {
            int i = 134217727;
            Long l = null;
            for (Map.Entry<Long, Integer> entry : this.bQq.entrySet()) {
                if (entry.getValue().intValue() < i) {
                    i = entry.getValue().intValue();
                    l = entry.getKey();
                }
            }
            if (l != null) {
                this.bQq.remove(l);
            } else {
                this.bQq.clear();
            }
        }
    }

    public boolean hH(String str) {
        boolean z = false;
        try {
            Long valueOf = Long.valueOf(Long.parseLong(str));
            synchronized (this) {
                if (this.bQq.get(valueOf) != null) {
                    z = true;
                }
            }
        } catch (Exception e) {
            BdLog.e(e.getMessage());
        }
        return z;
    }
}
