package com.baidu.tieba.tbadkCore.util;

import com.baidu.adp.lib.util.BdLog;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes.dex */
public class f {
    protected volatile int gmi;
    protected volatile HashMap<Long, Integer> gmj = new HashMap<>();
    private volatile int gmh = 0;

    public f(int i) {
        this.gmi = i;
    }

    public void sr(String str) {
        try {
            Long valueOf = Long.valueOf(Long.parseLong(str));
            synchronized (this) {
                if (this.gmj.size() >= this.gmi) {
                    bdc();
                }
                this.gmh++;
                this.gmj.put(valueOf, Integer.valueOf(this.gmh));
            }
        } catch (Exception e) {
            BdLog.e(e.getMessage());
        }
    }

    public void bdc() {
        int i;
        Long l;
        synchronized (this) {
            Long l2 = null;
            int i2 = 134217727;
            for (Map.Entry<Long, Integer> entry : this.gmj.entrySet()) {
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
                this.gmj.remove(l2);
            } else {
                this.gmj.clear();
            }
        }
    }

    public boolean ss(String str) {
        boolean z;
        try {
            Long valueOf = Long.valueOf(Long.parseLong(str));
            synchronized (this) {
                z = this.gmj.get(valueOf) != null;
            }
            return z;
        } catch (Exception e) {
            BdLog.e(e.getMessage());
            return false;
        }
    }

    public boolean st(String str) {
        try {
            return this.gmj.containsKey(Long.valueOf(Long.parseLong(str)));
        } catch (Exception e) {
            BdLog.e(e.getMessage());
            return false;
        }
    }

    public void btU() {
        synchronized (this) {
            this.gmj.clear();
        }
    }
}
