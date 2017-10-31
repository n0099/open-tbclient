package com.baidu.tieba.tbadkCore.util;

import com.baidu.adp.lib.util.BdLog;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes.dex */
public class e {
    protected volatile int grM;
    protected volatile HashMap<Long, Integer> grN = new HashMap<>();
    private volatile int grL = 0;

    public e(int i) {
        this.grM = i;
    }

    public void sF(String str) {
        try {
            Long valueOf = Long.valueOf(Long.parseLong(str));
            synchronized (this) {
                if (this.grN.size() >= this.grM) {
                    bea();
                }
                this.grL++;
                this.grN.put(valueOf, Integer.valueOf(this.grL));
            }
        } catch (Exception e) {
            BdLog.e(e.getMessage());
        }
    }

    public void bea() {
        int i;
        Long l;
        synchronized (this) {
            Long l2 = null;
            int i2 = 134217727;
            for (Map.Entry<Long, Integer> entry : this.grN.entrySet()) {
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
                this.grN.remove(l2);
            } else {
                this.grN.clear();
            }
        }
    }

    public boolean sG(String str) {
        boolean z;
        try {
            Long valueOf = Long.valueOf(Long.parseLong(str));
            synchronized (this) {
                z = this.grN.get(valueOf) != null;
            }
            return z;
        } catch (Exception e) {
            BdLog.e(e.getMessage());
            return false;
        }
    }

    public boolean sH(String str) {
        try {
            return this.grN.containsKey(Long.valueOf(Long.parseLong(str)));
        } catch (Exception e) {
            BdLog.e(e.getMessage());
            return false;
        }
    }

    public void bvp() {
        synchronized (this) {
            this.grN.clear();
        }
    }
}
