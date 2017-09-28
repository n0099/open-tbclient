package com.baidu.tieba.tbadkCore.util;

import com.baidu.adp.lib.util.BdLog;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes.dex */
public class e {
    protected volatile int gjq;
    protected volatile HashMap<Long, Integer> gjr = new HashMap<>();
    private volatile int gjp = 0;

    public e(int i) {
        this.gjq = i;
    }

    public void rY(String str) {
        try {
            Long valueOf = Long.valueOf(Long.parseLong(str));
            synchronized (this) {
                if (this.gjr.size() >= this.gjq) {
                    baY();
                }
                this.gjp++;
                this.gjr.put(valueOf, Integer.valueOf(this.gjp));
            }
        } catch (Exception e) {
            BdLog.e(e.getMessage());
        }
    }

    public void baY() {
        int i;
        Long l;
        synchronized (this) {
            Long l2 = null;
            int i2 = 134217727;
            for (Map.Entry<Long, Integer> entry : this.gjr.entrySet()) {
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
                this.gjr.remove(l2);
            } else {
                this.gjr.clear();
            }
        }
    }

    public boolean rZ(String str) {
        boolean z;
        try {
            Long valueOf = Long.valueOf(Long.parseLong(str));
            synchronized (this) {
                z = this.gjr.get(valueOf) != null;
            }
            return z;
        } catch (Exception e) {
            BdLog.e(e.getMessage());
            return false;
        }
    }

    public boolean sa(String str) {
        try {
            return this.gjr.containsKey(Long.valueOf(Long.parseLong(str)));
        } catch (Exception e) {
            BdLog.e(e.getMessage());
            return false;
        }
    }

    public void bst() {
        synchronized (this) {
            this.gjr.clear();
        }
    }
}
