package com.baidu.tieba.tbadkCore.util;

import com.baidu.adp.lib.util.BdLog;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes.dex */
public class f {
    protected volatile int gkq;
    protected volatile HashMap<Long, Integer> gkr = new HashMap<>();
    private volatile int gkp = 0;

    public f(int i) {
        this.gkq = i;
    }

    public void sk(String str) {
        try {
            Long valueOf = Long.valueOf(Long.parseLong(str));
            synchronized (this) {
                if (this.gkr.size() >= this.gkq) {
                    bcA();
                }
                this.gkp++;
                this.gkr.put(valueOf, Integer.valueOf(this.gkp));
            }
        } catch (Exception e) {
            BdLog.e(e.getMessage());
        }
    }

    public void bcA() {
        int i;
        Long l;
        synchronized (this) {
            Long l2 = null;
            int i2 = 134217727;
            for (Map.Entry<Long, Integer> entry : this.gkr.entrySet()) {
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
                this.gkr.remove(l2);
            } else {
                this.gkr.clear();
            }
        }
    }

    public boolean sl(String str) {
        boolean z;
        try {
            Long valueOf = Long.valueOf(Long.parseLong(str));
            synchronized (this) {
                z = this.gkr.get(valueOf) != null;
            }
            return z;
        } catch (Exception e) {
            BdLog.e(e.getMessage());
            return false;
        }
    }

    public boolean sm(String str) {
        try {
            return this.gkr.containsKey(Long.valueOf(Long.parseLong(str)));
        } catch (Exception e) {
            BdLog.e(e.getMessage());
            return false;
        }
    }

    public void btt() {
        synchronized (this) {
            this.gkr.clear();
        }
    }
}
