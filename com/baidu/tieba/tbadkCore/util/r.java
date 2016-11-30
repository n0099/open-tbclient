package com.baidu.tieba.tbadkCore.util;

import com.baidu.adp.lib.util.BdLog;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes.dex */
public class r {
    protected volatile int fEK;
    protected volatile HashMap<Long, Integer> fEL = new HashMap<>();
    private volatile int fEJ = 0;

    public r(int i) {
        this.fEK = i;
    }

    public void rO(String str) {
        try {
            Long valueOf = Long.valueOf(Long.parseLong(str));
            synchronized (this) {
                if (this.fEL.size() >= this.fEK) {
                    aZs();
                }
                this.fEJ++;
                this.fEL.put(valueOf, Integer.valueOf(this.fEJ));
            }
        } catch (Exception e) {
            BdLog.e(e.getMessage());
        }
    }

    public void aZs() {
        synchronized (this) {
            int i = 134217727;
            Long l = null;
            for (Map.Entry<Long, Integer> entry : this.fEL.entrySet()) {
                if (entry.getValue().intValue() < i) {
                    i = entry.getValue().intValue();
                    l = entry.getKey();
                }
            }
            if (l != null) {
                this.fEL.remove(l);
            } else {
                this.fEL.clear();
            }
        }
    }

    public boolean rP(String str) {
        boolean z = false;
        try {
            Long valueOf = Long.valueOf(Long.parseLong(str));
            synchronized (this) {
                if (this.fEL.get(valueOf) != null) {
                    z = true;
                }
            }
        } catch (Exception e) {
            BdLog.e(e.getMessage());
        }
        return z;
    }

    public boolean rQ(String str) {
        try {
            return this.fEL.containsKey(Long.valueOf(Long.parseLong(str)));
        } catch (Exception e) {
            BdLog.e(e.getMessage());
            return false;
        }
    }

    public void bnd() {
        synchronized (this) {
            this.fEL.clear();
        }
    }
}
