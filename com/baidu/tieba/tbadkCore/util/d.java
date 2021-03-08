package com.baidu.tieba.tbadkCore.util;

import com.baidu.adp.lib.util.BdLog;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes.dex */
public class d {
    protected volatile int ffI;
    protected volatile HashMap<Long, Integer> nCu = new HashMap<>();
    private volatile int mWeight = 0;

    public d(int i) {
        this.ffI = i;
    }

    public void TS(String str) {
        try {
            Long valueOf = Long.valueOf(Long.parseLong(str));
            synchronized (this) {
                if (this.nCu.size() >= this.ffI) {
                    dPb();
                }
                this.mWeight++;
                this.nCu.put(valueOf, Integer.valueOf(this.mWeight));
            }
        } catch (Exception e) {
            BdLog.e(e.getMessage());
        }
    }

    public void dPb() {
        int i;
        Long l;
        synchronized (this) {
            Long l2 = null;
            int i2 = 134217727;
            for (Map.Entry<Long, Integer> entry : this.nCu.entrySet()) {
                if (entry.getValue().intValue() < i2) {
                    i = entry.getValue().intValue();
                    l = entry.getKey();
                } else {
                    i = i2;
                    l = l2;
                }
                i2 = i;
                l2 = l;
            }
            if (l2 != null) {
                this.nCu.remove(l2);
            } else {
                this.nCu.clear();
            }
        }
    }

    public boolean TT(String str) {
        boolean z;
        try {
            Long valueOf = Long.valueOf(Long.parseLong(str));
            synchronized (this) {
                z = this.nCu.get(valueOf) != null;
            }
            return z;
        } catch (Exception e) {
            BdLog.e(e.getMessage());
            return false;
        }
    }

    public boolean TU(String str) {
        try {
            return this.nCu.containsKey(Long.valueOf(Long.parseLong(str)));
        } catch (Exception e) {
            BdLog.e(e.getMessage());
            return false;
        }
    }

    public void dPa() {
        synchronized (this) {
            this.nCu.clear();
        }
    }
}
