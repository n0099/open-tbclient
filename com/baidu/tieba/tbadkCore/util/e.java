package com.baidu.tieba.tbadkCore.util;

import com.baidu.adp.lib.util.BdLog;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes.dex */
public class e {
    protected volatile int gsP;
    protected volatile HashMap<Long, Integer> gsQ = new HashMap<>();
    private volatile int gsO = 0;

    public e(int i) {
        this.gsP = i;
    }

    public void sL(String str) {
        try {
            Long valueOf = Long.valueOf(Long.parseLong(str));
            synchronized (this) {
                if (this.gsQ.size() >= this.gsP) {
                    bei();
                }
                this.gsO++;
                this.gsQ.put(valueOf, Integer.valueOf(this.gsO));
            }
        } catch (Exception e) {
            BdLog.e(e.getMessage());
        }
    }

    public void bei() {
        int i;
        Long l;
        synchronized (this) {
            Long l2 = null;
            int i2 = 134217727;
            for (Map.Entry<Long, Integer> entry : this.gsQ.entrySet()) {
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
                this.gsQ.remove(l2);
            } else {
                this.gsQ.clear();
            }
        }
    }

    public boolean sM(String str) {
        boolean z;
        try {
            Long valueOf = Long.valueOf(Long.parseLong(str));
            synchronized (this) {
                z = this.gsQ.get(valueOf) != null;
            }
            return z;
        } catch (Exception e) {
            BdLog.e(e.getMessage());
            return false;
        }
    }

    public boolean sN(String str) {
        try {
            return this.gsQ.containsKey(Long.valueOf(Long.parseLong(str)));
        } catch (Exception e) {
            BdLog.e(e.getMessage());
            return false;
        }
    }

    public void bvB() {
        synchronized (this) {
            this.gsQ.clear();
        }
    }
}
