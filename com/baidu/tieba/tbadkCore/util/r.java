package com.baidu.tieba.tbadkCore.util;

import com.baidu.adp.lib.util.BdLog;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes.dex */
public class r {
    protected volatile int fiR;
    protected volatile HashMap<Long, Integer> fiS = new HashMap<>();
    private volatile int fiQ = 0;

    public r(int i) {
        this.fiR = i;
    }

    public void qu(String str) {
        try {
            Long valueOf = Long.valueOf(Long.parseLong(str));
            synchronized (this) {
                if (this.fiS.size() >= this.fiR) {
                    aTd();
                }
                this.fiQ++;
                this.fiS.put(valueOf, Integer.valueOf(this.fiQ));
            }
        } catch (Exception e) {
            BdLog.e(e.getMessage());
        }
    }

    public void aTd() {
        synchronized (this) {
            int i = 134217727;
            Long l = null;
            for (Map.Entry<Long, Integer> entry : this.fiS.entrySet()) {
                if (entry.getValue().intValue() < i) {
                    i = entry.getValue().intValue();
                    l = entry.getKey();
                }
            }
            if (l != null) {
                this.fiS.remove(l);
            } else {
                this.fiS.clear();
            }
        }
    }

    public boolean qv(String str) {
        boolean z = false;
        try {
            Long valueOf = Long.valueOf(Long.parseLong(str));
            synchronized (this) {
                if (this.fiS.get(valueOf) != null) {
                    z = true;
                }
            }
        } catch (Exception e) {
            BdLog.e(e.getMessage());
        }
        return z;
    }

    public boolean qw(String str) {
        try {
            return this.fiS.containsKey(Long.valueOf(Long.parseLong(str)));
        } catch (Exception e) {
            BdLog.e(e.getMessage());
            return false;
        }
    }

    public void bgX() {
        synchronized (this) {
            this.fiS.clear();
        }
    }
}
