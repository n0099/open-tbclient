package com.baidu.tieba.tbadkCore.util;

import com.baidu.adp.lib.util.BdLog;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes.dex */
public class e {
    protected volatile int hdG;
    protected volatile HashMap<Long, Integer> hdH = new HashMap<>();
    private volatile int hdF = 0;

    public e(int i) {
        this.hdG = i;
    }

    public void sV(String str) {
        try {
            Long valueOf = Long.valueOf(Long.parseLong(str));
            synchronized (this) {
                if (this.hdH.size() >= this.hdG) {
                    bxT();
                }
                this.hdF++;
                this.hdH.put(valueOf, Integer.valueOf(this.hdF));
            }
        } catch (Exception e) {
            BdLog.e(e.getMessage());
        }
    }

    public void bxT() {
        int i;
        Long l;
        synchronized (this) {
            Long l2 = null;
            int i2 = 134217727;
            for (Map.Entry<Long, Integer> entry : this.hdH.entrySet()) {
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
                this.hdH.remove(l2);
            } else {
                this.hdH.clear();
            }
        }
    }

    public boolean sW(String str) {
        boolean z;
        try {
            Long valueOf = Long.valueOf(Long.parseLong(str));
            synchronized (this) {
                z = this.hdH.get(valueOf) != null;
            }
            return z;
        } catch (Exception e) {
            BdLog.e(e.getMessage());
            return false;
        }
    }

    public boolean sX(String str) {
        try {
            return this.hdH.containsKey(Long.valueOf(Long.parseLong(str)));
        } catch (Exception e) {
            BdLog.e(e.getMessage());
            return false;
        }
    }

    public void bxU() {
        synchronized (this) {
            this.hdH.clear();
        }
    }
}
