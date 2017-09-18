package com.baidu.tieba.tbadkCore.util;

import com.baidu.adp.lib.util.BdLog;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes.dex */
public class f {
    protected volatile int glE;
    protected volatile HashMap<Long, Integer> glF = new HashMap<>();
    private volatile int glD = 0;

    public f(int i) {
        this.glE = i;
    }

    public void so(String str) {
        try {
            Long valueOf = Long.valueOf(Long.parseLong(str));
            synchronized (this) {
                if (this.glF.size() >= this.glE) {
                    bcy();
                }
                this.glD++;
                this.glF.put(valueOf, Integer.valueOf(this.glD));
            }
        } catch (Exception e) {
            BdLog.e(e.getMessage());
        }
    }

    public void bcy() {
        int i;
        Long l;
        synchronized (this) {
            Long l2 = null;
            int i2 = 134217727;
            for (Map.Entry<Long, Integer> entry : this.glF.entrySet()) {
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
                this.glF.remove(l2);
            } else {
                this.glF.clear();
            }
        }
    }

    public boolean sp(String str) {
        boolean z;
        try {
            Long valueOf = Long.valueOf(Long.parseLong(str));
            synchronized (this) {
                z = this.glF.get(valueOf) != null;
            }
            return z;
        } catch (Exception e) {
            BdLog.e(e.getMessage());
            return false;
        }
    }

    public boolean sq(String str) {
        try {
            return this.glF.containsKey(Long.valueOf(Long.parseLong(str)));
        } catch (Exception e) {
            BdLog.e(e.getMessage());
            return false;
        }
    }

    public void btu() {
        synchronized (this) {
            this.glF.clear();
        }
    }
}
