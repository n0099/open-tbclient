package com.baidu.tieba.tbadkCore.util;

import com.baidu.adp.lib.util.BdLog;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes.dex */
public class e {
    protected volatile int hdx;
    protected volatile HashMap<Long, Integer> hdy = new HashMap<>();
    private volatile int hdw = 0;

    public e(int i) {
        this.hdx = i;
    }

    public void sV(String str) {
        try {
            Long valueOf = Long.valueOf(Long.parseLong(str));
            synchronized (this) {
                if (this.hdy.size() >= this.hdx) {
                    bxP();
                }
                this.hdw++;
                this.hdy.put(valueOf, Integer.valueOf(this.hdw));
            }
        } catch (Exception e) {
            BdLog.e(e.getMessage());
        }
    }

    public void bxP() {
        int i;
        Long l;
        synchronized (this) {
            Long l2 = null;
            int i2 = 134217727;
            for (Map.Entry<Long, Integer> entry : this.hdy.entrySet()) {
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
                this.hdy.remove(l2);
            } else {
                this.hdy.clear();
            }
        }
    }

    public boolean sW(String str) {
        boolean z;
        try {
            Long valueOf = Long.valueOf(Long.parseLong(str));
            synchronized (this) {
                z = this.hdy.get(valueOf) != null;
            }
            return z;
        } catch (Exception e) {
            BdLog.e(e.getMessage());
            return false;
        }
    }

    public boolean sX(String str) {
        try {
            return this.hdy.containsKey(Long.valueOf(Long.parseLong(str)));
        } catch (Exception e) {
            BdLog.e(e.getMessage());
            return false;
        }
    }

    public void bxQ() {
        synchronized (this) {
            this.hdy.clear();
        }
    }
}
