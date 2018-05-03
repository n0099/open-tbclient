package com.baidu.tieba.tbadkCore.util;

import com.baidu.adp.lib.util.BdLog;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes.dex */
public class e {
    protected volatile int gyX;
    protected volatile HashMap<Long, Integer> gyY = new HashMap<>();
    private volatile int gyW = 0;

    public e(int i) {
        this.gyX = i;
    }

    public void tc(String str) {
        try {
            Long valueOf = Long.valueOf(Long.parseLong(str));
            synchronized (this) {
                if (this.gyY.size() >= this.gyX) {
                    bsT();
                }
                this.gyW++;
                this.gyY.put(valueOf, Integer.valueOf(this.gyW));
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
            for (Map.Entry<Long, Integer> entry : this.gyY.entrySet()) {
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
                this.gyY.remove(l2);
            } else {
                this.gyY.clear();
            }
        }
    }

    public boolean td(String str) {
        boolean z;
        try {
            Long valueOf = Long.valueOf(Long.parseLong(str));
            synchronized (this) {
                z = this.gyY.get(valueOf) != null;
            }
            return z;
        } catch (Exception e) {
            BdLog.e(e.getMessage());
            return false;
        }
    }

    public boolean te(String str) {
        try {
            return this.gyY.containsKey(Long.valueOf(Long.parseLong(str)));
        } catch (Exception e) {
            BdLog.e(e.getMessage());
            return false;
        }
    }

    public void bsU() {
        synchronized (this) {
            this.gyY.clear();
        }
    }
}
