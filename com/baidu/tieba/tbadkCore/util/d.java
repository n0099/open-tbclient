package com.baidu.tieba.tbadkCore.util;

import com.baidu.adp.lib.util.BdLog;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes.dex */
public class d {
    protected volatile int gAa;
    protected volatile HashMap<Long, Integer> gAb = new HashMap<>();
    private volatile int gzZ = 0;

    public d(int i) {
        this.gAa = i;
    }

    public void tf(String str) {
        try {
            Long valueOf = Long.valueOf(Long.parseLong(str));
            synchronized (this) {
                if (this.gAb.size() >= this.gAa) {
                    bsS();
                }
                this.gzZ++;
                this.gAb.put(valueOf, Integer.valueOf(this.gzZ));
            }
        } catch (Exception e) {
            BdLog.e(e.getMessage());
        }
    }

    public void bsS() {
        int i;
        Long l;
        synchronized (this) {
            Long l2 = null;
            int i2 = 134217727;
            for (Map.Entry<Long, Integer> entry : this.gAb.entrySet()) {
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
                this.gAb.remove(l2);
            } else {
                this.gAb.clear();
            }
        }
    }

    public boolean tg(String str) {
        boolean z;
        try {
            Long valueOf = Long.valueOf(Long.parseLong(str));
            synchronized (this) {
                z = this.gAb.get(valueOf) != null;
            }
            return z;
        } catch (Exception e) {
            BdLog.e(e.getMessage());
            return false;
        }
    }

    public boolean th(String str) {
        try {
            return this.gAb.containsKey(Long.valueOf(Long.parseLong(str)));
        } catch (Exception e) {
            BdLog.e(e.getMessage());
            return false;
        }
    }

    public void bsR() {
        synchronized (this) {
            this.gAb.clear();
        }
    }
}
