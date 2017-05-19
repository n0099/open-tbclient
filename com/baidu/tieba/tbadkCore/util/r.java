package com.baidu.tieba.tbadkCore.util;

import com.baidu.adp.lib.util.BdLog;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes.dex */
public class r {
    protected volatile int fwJ;
    protected volatile HashMap<Long, Integer> fwK = new HashMap<>();
    private volatile int fwI = 0;

    public r(int i) {
        this.fwJ = i;
    }

    public void qh(String str) {
        try {
            Long valueOf = Long.valueOf(Long.parseLong(str));
            synchronized (this) {
                if (this.fwK.size() >= this.fwJ) {
                    aTm();
                }
                this.fwI++;
                this.fwK.put(valueOf, Integer.valueOf(this.fwI));
            }
        } catch (Exception e) {
            BdLog.e(e.getMessage());
        }
    }

    public void aTm() {
        synchronized (this) {
            int i = 134217727;
            Long l = null;
            for (Map.Entry<Long, Integer> entry : this.fwK.entrySet()) {
                if (entry.getValue().intValue() < i) {
                    i = entry.getValue().intValue();
                    l = entry.getKey();
                }
            }
            if (l != null) {
                this.fwK.remove(l);
            } else {
                this.fwK.clear();
            }
        }
    }

    public boolean qi(String str) {
        boolean z = false;
        try {
            Long valueOf = Long.valueOf(Long.parseLong(str));
            synchronized (this) {
                if (this.fwK.get(valueOf) != null) {
                    z = true;
                }
            }
        } catch (Exception e) {
            BdLog.e(e.getMessage());
        }
        return z;
    }

    public boolean qj(String str) {
        try {
            return this.fwK.containsKey(Long.valueOf(Long.parseLong(str)));
        } catch (Exception e) {
            BdLog.e(e.getMessage());
            return false;
        }
    }

    public void bhH() {
        synchronized (this) {
            this.fwK.clear();
        }
    }
}
