package com.baidu.tieba.tbadkCore.util;

import com.baidu.adp.lib.util.BdLog;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes.dex */
public class e {
    protected volatile int gjp;
    protected volatile HashMap<Long, Integer> gjq = new HashMap<>();
    private volatile int gjo = 0;

    public e(int i) {
        this.gjp = i;
    }

    public void rY(String str) {
        try {
            Long valueOf = Long.valueOf(Long.parseLong(str));
            synchronized (this) {
                if (this.gjq.size() >= this.gjp) {
                    baX();
                }
                this.gjo++;
                this.gjq.put(valueOf, Integer.valueOf(this.gjo));
            }
        } catch (Exception e) {
            BdLog.e(e.getMessage());
        }
    }

    public void baX() {
        int i;
        Long l;
        synchronized (this) {
            Long l2 = null;
            int i2 = 134217727;
            for (Map.Entry<Long, Integer> entry : this.gjq.entrySet()) {
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
                this.gjq.remove(l2);
            } else {
                this.gjq.clear();
            }
        }
    }

    public boolean rZ(String str) {
        boolean z;
        try {
            Long valueOf = Long.valueOf(Long.parseLong(str));
            synchronized (this) {
                z = this.gjq.get(valueOf) != null;
            }
            return z;
        } catch (Exception e) {
            BdLog.e(e.getMessage());
            return false;
        }
    }

    public boolean sa(String str) {
        try {
            return this.gjq.containsKey(Long.valueOf(Long.parseLong(str)));
        } catch (Exception e) {
            BdLog.e(e.getMessage());
            return false;
        }
    }

    public void bss() {
        synchronized (this) {
            this.gjq.clear();
        }
    }
}
