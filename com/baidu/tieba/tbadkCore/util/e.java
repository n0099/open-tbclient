package com.baidu.tieba.tbadkCore.util;

import com.baidu.adp.lib.util.BdLog;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes.dex */
public class e {
    protected volatile int gza;
    protected volatile HashMap<Long, Integer> gzb = new HashMap<>();
    private volatile int gyZ = 0;

    public e(int i) {
        this.gza = i;
    }

    public void tc(String str) {
        try {
            Long valueOf = Long.valueOf(Long.parseLong(str));
            synchronized (this) {
                if (this.gzb.size() >= this.gza) {
                    bsT();
                }
                this.gyZ++;
                this.gzb.put(valueOf, Integer.valueOf(this.gyZ));
            }
        } catch (Exception e) {
            BdLog.e(e.getMessage());
        }
    }

    public void bsT() {
        int i;
        Long l;
        synchronized (this) {
            Long l2 = null;
            int i2 = 134217727;
            for (Map.Entry<Long, Integer> entry : this.gzb.entrySet()) {
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
                this.gzb.remove(l2);
            } else {
                this.gzb.clear();
            }
        }
    }

    public boolean td(String str) {
        boolean z;
        try {
            Long valueOf = Long.valueOf(Long.parseLong(str));
            synchronized (this) {
                z = this.gzb.get(valueOf) != null;
            }
            return z;
        } catch (Exception e) {
            BdLog.e(e.getMessage());
            return false;
        }
    }

    public boolean te(String str) {
        try {
            return this.gzb.containsKey(Long.valueOf(Long.parseLong(str)));
        } catch (Exception e) {
            BdLog.e(e.getMessage());
            return false;
        }
    }

    public void bsU() {
        synchronized (this) {
            this.gzb.clear();
        }
    }
}
