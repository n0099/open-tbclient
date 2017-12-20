package com.baidu.tieba.tbadkCore.util;

import com.baidu.adp.lib.util.BdLog;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes.dex */
public class e {
    protected volatile int gEv;
    protected volatile HashMap<Long, Integer> gEw = new HashMap<>();
    private volatile int gEu = 0;

    public e(int i) {
        this.gEv = i;
    }

    public void tn(String str) {
        try {
            Long valueOf = Long.valueOf(Long.parseLong(str));
            synchronized (this) {
                if (this.gEw.size() >= this.gEv) {
                    bfQ();
                }
                this.gEu++;
                this.gEw.put(valueOf, Integer.valueOf(this.gEu));
            }
        } catch (Exception e) {
            BdLog.e(e.getMessage());
        }
    }

    public void bfQ() {
        int i;
        Long l;
        synchronized (this) {
            Long l2 = null;
            int i2 = 134217727;
            for (Map.Entry<Long, Integer> entry : this.gEw.entrySet()) {
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
                this.gEw.remove(l2);
            } else {
                this.gEw.clear();
            }
        }
    }

    public boolean to(String str) {
        boolean z;
        try {
            Long valueOf = Long.valueOf(Long.parseLong(str));
            synchronized (this) {
                z = this.gEw.get(valueOf) != null;
            }
            return z;
        } catch (Exception e) {
            BdLog.e(e.getMessage());
            return false;
        }
    }

    public boolean tp(String str) {
        try {
            return this.gEw.containsKey(Long.valueOf(Long.parseLong(str)));
        } catch (Exception e) {
            BdLog.e(e.getMessage());
            return false;
        }
    }

    public void bxR() {
        synchronized (this) {
            this.gEw.clear();
        }
    }
}
