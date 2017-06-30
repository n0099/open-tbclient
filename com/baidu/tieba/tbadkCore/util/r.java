package com.baidu.tieba.tbadkCore.util;

import com.baidu.adp.lib.util.BdLog;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes.dex */
public class r {
    protected volatile int fOG;
    protected volatile HashMap<Long, Integer> fOH = new HashMap<>();
    private volatile int fOF = 0;

    public r(int i) {
        this.fOG = i;
    }

    public void rt(String str) {
        try {
            Long valueOf = Long.valueOf(Long.parseLong(str));
            synchronized (this) {
                if (this.fOH.size() >= this.fOG) {
                    aYO();
                }
                this.fOF++;
                this.fOH.put(valueOf, Integer.valueOf(this.fOF));
            }
        } catch (Exception e) {
            BdLog.e(e.getMessage());
        }
    }

    public void aYO() {
        synchronized (this) {
            int i = 134217727;
            Long l = null;
            for (Map.Entry<Long, Integer> entry : this.fOH.entrySet()) {
                if (entry.getValue().intValue() < i) {
                    i = entry.getValue().intValue();
                    l = entry.getKey();
                }
            }
            if (l != null) {
                this.fOH.remove(l);
            } else {
                this.fOH.clear();
            }
        }
    }

    public boolean ru(String str) {
        boolean z = false;
        try {
            Long valueOf = Long.valueOf(Long.parseLong(str));
            synchronized (this) {
                if (this.fOH.get(valueOf) != null) {
                    z = true;
                }
            }
        } catch (Exception e) {
            BdLog.e(e.getMessage());
        }
        return z;
    }

    public boolean rv(String str) {
        try {
            return this.fOH.containsKey(Long.valueOf(Long.parseLong(str)));
        } catch (Exception e) {
            BdLog.e(e.getMessage());
            return false;
        }
    }

    public void bnp() {
        synchronized (this) {
            this.fOH.clear();
        }
    }
}
