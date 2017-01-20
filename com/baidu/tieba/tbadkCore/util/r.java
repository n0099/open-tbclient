package com.baidu.tieba.tbadkCore.util;

import com.baidu.adp.lib.util.BdLog;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes.dex */
public class r {
    protected volatile int fsd;
    protected volatile HashMap<Long, Integer> fse = new HashMap<>();
    private volatile int fsc = 0;

    public r(int i) {
        this.fsd = i;
    }

    public void qO(String str) {
        try {
            Long valueOf = Long.valueOf(Long.parseLong(str));
            synchronized (this) {
                if (this.fse.size() >= this.fsd) {
                    aVa();
                }
                this.fsc++;
                this.fse.put(valueOf, Integer.valueOf(this.fsc));
            }
        } catch (Exception e) {
            BdLog.e(e.getMessage());
        }
    }

    public void aVa() {
        synchronized (this) {
            int i = 134217727;
            Long l = null;
            for (Map.Entry<Long, Integer> entry : this.fse.entrySet()) {
                if (entry.getValue().intValue() < i) {
                    i = entry.getValue().intValue();
                    l = entry.getKey();
                }
            }
            if (l != null) {
                this.fse.remove(l);
            } else {
                this.fse.clear();
            }
        }
    }

    public boolean qP(String str) {
        boolean z = false;
        try {
            Long valueOf = Long.valueOf(Long.parseLong(str));
            synchronized (this) {
                if (this.fse.get(valueOf) != null) {
                    z = true;
                }
            }
        } catch (Exception e) {
            BdLog.e(e.getMessage());
        }
        return z;
    }

    public boolean qQ(String str) {
        try {
            return this.fse.containsKey(Long.valueOf(Long.parseLong(str)));
        } catch (Exception e) {
            BdLog.e(e.getMessage());
            return false;
        }
    }

    public void biI() {
        synchronized (this) {
            this.fse.clear();
        }
    }
}
