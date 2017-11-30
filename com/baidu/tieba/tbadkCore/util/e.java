package com.baidu.tieba.tbadkCore.util;

import com.baidu.adp.lib.util.BdLog;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes.dex */
public class e {
    protected volatile int gBL;
    protected volatile HashMap<Long, Integer> gBM = new HashMap<>();
    private volatile int gBK = 0;

    public e(int i) {
        this.gBL = i;
    }

    public void ti(String str) {
        try {
            Long valueOf = Long.valueOf(Long.parseLong(str));
            synchronized (this) {
                if (this.gBM.size() >= this.gBL) {
                    bfJ();
                }
                this.gBK++;
                this.gBM.put(valueOf, Integer.valueOf(this.gBK));
            }
        } catch (Exception e) {
            BdLog.e(e.getMessage());
        }
    }

    public void bfJ() {
        int i;
        Long l;
        synchronized (this) {
            Long l2 = null;
            int i2 = 134217727;
            for (Map.Entry<Long, Integer> entry : this.gBM.entrySet()) {
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
                this.gBM.remove(l2);
            } else {
                this.gBM.clear();
            }
        }
    }

    public boolean tj(String str) {
        boolean z;
        try {
            Long valueOf = Long.valueOf(Long.parseLong(str));
            synchronized (this) {
                z = this.gBM.get(valueOf) != null;
            }
            return z;
        } catch (Exception e) {
            BdLog.e(e.getMessage());
            return false;
        }
    }

    public boolean tk(String str) {
        try {
            return this.gBM.containsKey(Long.valueOf(Long.parseLong(str)));
        } catch (Exception e) {
            BdLog.e(e.getMessage());
            return false;
        }
    }

    public void bxl() {
        synchronized (this) {
            this.gBM.clear();
        }
    }
}
