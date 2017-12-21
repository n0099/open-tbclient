package com.baidu.tieba.tbadkCore.util;

import com.baidu.adp.lib.util.BdLog;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes.dex */
public class e {
    protected volatile int gEA;
    protected volatile HashMap<Long, Integer> gEB = new HashMap<>();
    private volatile int gEz = 0;

    public e(int i) {
        this.gEA = i;
    }

    public void tn(String str) {
        try {
            Long valueOf = Long.valueOf(Long.parseLong(str));
            synchronized (this) {
                if (this.gEB.size() >= this.gEA) {
                    bfR();
                }
                this.gEz++;
                this.gEB.put(valueOf, Integer.valueOf(this.gEz));
            }
        } catch (Exception e) {
            BdLog.e(e.getMessage());
        }
    }

    public void bfR() {
        int i;
        Long l;
        synchronized (this) {
            Long l2 = null;
            int i2 = 134217727;
            for (Map.Entry<Long, Integer> entry : this.gEB.entrySet()) {
                if (entry.getValue().intValue() < i2) {
                    int intValue = entry.getValue().intValue();
                    l = entry.getKey();
                    i = intValue;
                } else {
                    i = i2;
                    l = l2;
                }
                i2 = i;
                l2 = l;
            }
            if (l2 != null) {
                this.gEB.remove(l2);
            } else {
                this.gEB.clear();
            }
        }
    }

    public boolean to(String str) {
        boolean z;
        try {
            Long valueOf = Long.valueOf(Long.parseLong(str));
            synchronized (this) {
                z = this.gEB.get(valueOf) != null;
            }
            return z;
        } catch (Exception e) {
            BdLog.e(e.getMessage());
            return false;
        }
    }

    public boolean tp(String str) {
        try {
            return this.gEB.containsKey(Long.valueOf(Long.parseLong(str)));
        } catch (Exception e) {
            BdLog.e(e.getMessage());
            return false;
        }
    }

    public void bxS() {
        synchronized (this) {
            this.gEB.clear();
        }
    }
}
