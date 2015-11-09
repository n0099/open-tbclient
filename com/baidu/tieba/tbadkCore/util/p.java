package com.baidu.tieba.tbadkCore.util;

import com.baidu.adp.lib.util.BdLog;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes.dex */
public class p {
    protected volatile int cHC;
    private volatile HashMap<Long, Integer> ddy = new HashMap<>();
    private volatile int ddx = 0;

    public p(int i) {
        this.cHC = i;
    }

    public void lQ(String str) {
        try {
            Long valueOf = Long.valueOf(Long.parseLong(str));
            synchronized (this) {
                if (this.ddy.size() >= this.cHC) {
                    ayN();
                }
                this.ddx++;
                this.ddy.put(valueOf, Integer.valueOf(this.ddx));
            }
        } catch (Exception e) {
            BdLog.e(e.getMessage());
        }
    }

    public void ayN() {
        synchronized (this) {
            int i = 134217727;
            Long l = null;
            for (Map.Entry<Long, Integer> entry : this.ddy.entrySet()) {
                if (entry.getValue().intValue() < i) {
                    i = entry.getValue().intValue();
                    l = entry.getKey();
                }
            }
            if (l != null) {
                this.ddy.remove(l);
            } else {
                this.ddy.clear();
            }
        }
    }

    public boolean lR(String str) {
        boolean z = false;
        try {
            Long valueOf = Long.valueOf(Long.parseLong(str));
            synchronized (this) {
                if (this.ddy.get(valueOf) != null) {
                    z = true;
                }
            }
        } catch (Exception e) {
            BdLog.e(e.getMessage());
        }
        return z;
    }
}
