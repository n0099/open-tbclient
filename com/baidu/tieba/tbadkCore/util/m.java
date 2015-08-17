package com.baidu.tieba.tbadkCore.util;

import com.baidu.adp.lib.util.BdLog;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes.dex */
public class m {
    private volatile int cqK;
    private volatile HashMap<Long, Integer> cKI = new HashMap<>();
    private volatile int cKH = 0;

    public m(int i) {
        this.cqK = i;
    }

    public void kD(String str) {
        try {
            Long valueOf = Long.valueOf(Long.parseLong(str));
            synchronized (this) {
                if (this.cKI.size() >= this.cqK) {
                    aqX();
                }
                this.cKH++;
                this.cKI.put(valueOf, Integer.valueOf(this.cKH));
            }
        } catch (Exception e) {
            BdLog.e(e.getMessage());
        }
    }

    public void aqX() {
        synchronized (this) {
            int i = 134217727;
            Long l = null;
            for (Map.Entry<Long, Integer> entry : this.cKI.entrySet()) {
                if (entry.getValue().intValue() < i) {
                    i = entry.getValue().intValue();
                    l = entry.getKey();
                }
            }
            if (l != null) {
                this.cKI.remove(l);
            } else {
                this.cKI.clear();
            }
        }
    }

    public boolean kE(String str) {
        boolean z = false;
        try {
            Long valueOf = Long.valueOf(Long.parseLong(str));
            synchronized (this) {
                if (this.cKI.get(valueOf) != null) {
                    z = true;
                }
            }
        } catch (Exception e) {
            BdLog.e(e.getMessage());
        }
        return z;
    }
}
