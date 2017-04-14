package com.baidu.tieba.tbadkCore.util;

import com.baidu.adp.lib.util.BdLog;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes.dex */
public class r {
    protected volatile int fyk;
    protected volatile HashMap<Long, Integer> fyl = new HashMap<>();
    private volatile int fyj = 0;

    public r(int i) {
        this.fyk = i;
    }

    public void qn(String str) {
        try {
            Long valueOf = Long.valueOf(Long.parseLong(str));
            synchronized (this) {
                if (this.fyl.size() >= this.fyk) {
                    aUM();
                }
                this.fyj++;
                this.fyl.put(valueOf, Integer.valueOf(this.fyj));
            }
        } catch (Exception e) {
            BdLog.e(e.getMessage());
        }
    }

    public void aUM() {
        synchronized (this) {
            int i = 134217727;
            Long l = null;
            for (Map.Entry<Long, Integer> entry : this.fyl.entrySet()) {
                if (entry.getValue().intValue() < i) {
                    i = entry.getValue().intValue();
                    l = entry.getKey();
                }
            }
            if (l != null) {
                this.fyl.remove(l);
            } else {
                this.fyl.clear();
            }
        }
    }

    public boolean qo(String str) {
        boolean z = false;
        try {
            Long valueOf = Long.valueOf(Long.parseLong(str));
            synchronized (this) {
                if (this.fyl.get(valueOf) != null) {
                    z = true;
                }
            }
        } catch (Exception e) {
            BdLog.e(e.getMessage());
        }
        return z;
    }

    public boolean qp(String str) {
        try {
            return this.fyl.containsKey(Long.valueOf(Long.parseLong(str)));
        } catch (Exception e) {
            BdLog.e(e.getMessage());
            return false;
        }
    }

    public void bjj() {
        synchronized (this) {
            this.fyl.clear();
        }
    }
}
