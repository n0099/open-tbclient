package com.baidu.tieba.tbadkCore.util;

import com.baidu.adp.lib.util.BdLog;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes.dex */
public class s {
    protected volatile int fab;
    protected volatile HashMap<Long, Integer> fac = new HashMap<>();
    private volatile int faa = 0;

    public s(int i) {
        this.fab = i;
    }

    public void pK(String str) {
        try {
            Long valueOf = Long.valueOf(Long.parseLong(str));
            synchronized (this) {
                if (this.fac.size() >= this.fab) {
                    aQw();
                }
                this.faa++;
                this.fac.put(valueOf, Integer.valueOf(this.faa));
            }
        } catch (Exception e) {
            BdLog.e(e.getMessage());
        }
    }

    public void aQw() {
        synchronized (this) {
            int i = 134217727;
            Long l = null;
            for (Map.Entry<Long, Integer> entry : this.fac.entrySet()) {
                if (entry.getValue().intValue() < i) {
                    i = entry.getValue().intValue();
                    l = entry.getKey();
                }
            }
            if (l != null) {
                this.fac.remove(l);
            } else {
                this.fac.clear();
            }
        }
    }

    public boolean pL(String str) {
        boolean z = false;
        try {
            Long valueOf = Long.valueOf(Long.parseLong(str));
            synchronized (this) {
                if (this.fac.get(valueOf) != null) {
                    z = true;
                }
            }
        } catch (Exception e) {
            BdLog.e(e.getMessage());
        }
        return z;
    }

    public boolean pM(String str) {
        try {
            return this.fac.containsKey(Long.valueOf(Long.parseLong(str)));
        } catch (Exception e) {
            BdLog.e(e.getMessage());
            return false;
        }
    }

    public void bdl() {
        synchronized (this) {
            this.fac.clear();
        }
    }
}
