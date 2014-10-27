package com.baidu.tieba.util;

import com.baidu.adp.lib.util.BdLog;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes.dex */
public class o {
    private volatile int bQa;
    private volatile HashMap<Long, Integer> bQb = new HashMap<>();
    private volatile int bPZ = 0;

    public o(int i) {
        this.bQa = i;
    }

    public void hG(String str) {
        try {
            Long valueOf = Long.valueOf(Long.parseLong(str));
            synchronized (this) {
                if (this.bQb.size() >= this.bQa) {
                    aeI();
                }
                this.bPZ++;
                this.bQb.put(valueOf, Integer.valueOf(this.bPZ));
            }
        } catch (Exception e) {
            BdLog.e(e.getMessage());
        }
    }

    public void aeI() {
        synchronized (this) {
            int i = 134217727;
            Long l = null;
            for (Map.Entry<Long, Integer> entry : this.bQb.entrySet()) {
                if (entry.getValue().intValue() < i) {
                    i = entry.getValue().intValue();
                    l = entry.getKey();
                }
            }
            if (l != null) {
                this.bQb.remove(l);
            } else {
                this.bQb.clear();
            }
        }
    }

    public boolean hH(String str) {
        boolean z = false;
        try {
            Long valueOf = Long.valueOf(Long.parseLong(str));
            synchronized (this) {
                if (this.bQb.get(valueOf) != null) {
                    z = true;
                }
            }
        } catch (Exception e) {
            BdLog.e(e.getMessage());
        }
        return z;
    }
}
