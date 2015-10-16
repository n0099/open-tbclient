package com.baidu.tieba.tbadkCore.util;

import com.baidu.adp.lib.util.BdLog;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes.dex */
public class p {
    protected volatile int cGg;
    private volatile HashMap<Long, Integer> dbn = new HashMap<>();
    private volatile int dbm = 0;

    public p(int i) {
        this.cGg = i;
    }

    public void lK(String str) {
        try {
            Long valueOf = Long.valueOf(Long.parseLong(str));
            synchronized (this) {
                if (this.dbn.size() >= this.cGg) {
                    axI();
                }
                this.dbm++;
                this.dbn.put(valueOf, Integer.valueOf(this.dbm));
            }
        } catch (Exception e) {
            BdLog.e(e.getMessage());
        }
    }

    public void axI() {
        synchronized (this) {
            int i = 134217727;
            Long l = null;
            for (Map.Entry<Long, Integer> entry : this.dbn.entrySet()) {
                if (entry.getValue().intValue() < i) {
                    i = entry.getValue().intValue();
                    l = entry.getKey();
                }
            }
            if (l != null) {
                this.dbn.remove(l);
            } else {
                this.dbn.clear();
            }
        }
    }

    public boolean lL(String str) {
        boolean z = false;
        try {
            Long valueOf = Long.valueOf(Long.parseLong(str));
            synchronized (this) {
                if (this.dbn.get(valueOf) != null) {
                    z = true;
                }
            }
        } catch (Exception e) {
            BdLog.e(e.getMessage());
        }
        return z;
    }
}
