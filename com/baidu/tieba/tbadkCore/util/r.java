package com.baidu.tieba.tbadkCore.util;

import com.baidu.adp.lib.util.BdLog;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes.dex */
public class r {
    protected volatile int fAA;
    protected volatile HashMap<Long, Integer> fAB = new HashMap<>();
    private volatile int fAz = 0;

    public r(int i) {
        this.fAA = i;
    }

    public void qo(String str) {
        try {
            Long valueOf = Long.valueOf(Long.parseLong(str));
            synchronized (this) {
                if (this.fAB.size() >= this.fAA) {
                    aVN();
                }
                this.fAz++;
                this.fAB.put(valueOf, Integer.valueOf(this.fAz));
            }
        } catch (Exception e) {
            BdLog.e(e.getMessage());
        }
    }

    public void aVN() {
        synchronized (this) {
            int i = 134217727;
            Long l = null;
            for (Map.Entry<Long, Integer> entry : this.fAB.entrySet()) {
                if (entry.getValue().intValue() < i) {
                    i = entry.getValue().intValue();
                    l = entry.getKey();
                }
            }
            if (l != null) {
                this.fAB.remove(l);
            } else {
                this.fAB.clear();
            }
        }
    }

    public boolean qp(String str) {
        boolean z = false;
        try {
            Long valueOf = Long.valueOf(Long.parseLong(str));
            synchronized (this) {
                if (this.fAB.get(valueOf) != null) {
                    z = true;
                }
            }
        } catch (Exception e) {
            BdLog.e(e.getMessage());
        }
        return z;
    }

    public boolean qq(String str) {
        try {
            return this.fAB.containsKey(Long.valueOf(Long.parseLong(str)));
        } catch (Exception e) {
            BdLog.e(e.getMessage());
            return false;
        }
    }

    public void bkk() {
        synchronized (this) {
            this.fAB.clear();
        }
    }
}
