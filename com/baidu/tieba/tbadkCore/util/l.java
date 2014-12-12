package com.baidu.tieba.tbadkCore.util;

import com.baidu.adp.lib.util.BdLog;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes.dex */
public class l {
    private volatile int blF;
    private volatile HashMap<Long, Integer> bYQ = new HashMap<>();
    private volatile int bYP = 0;

    public l(int i) {
        this.blF = i;
    }

    public void io(String str) {
        try {
            Long valueOf = Long.valueOf(Long.parseLong(str));
            synchronized (this) {
                if (this.bYQ.size() >= this.blF) {
                    ahR();
                }
                this.bYP++;
                this.bYQ.put(valueOf, Integer.valueOf(this.bYP));
            }
        } catch (Exception e) {
            BdLog.e(e.getMessage());
        }
    }

    public void ahR() {
        synchronized (this) {
            int i = 134217727;
            Long l = null;
            for (Map.Entry<Long, Integer> entry : this.bYQ.entrySet()) {
                if (entry.getValue().intValue() < i) {
                    i = entry.getValue().intValue();
                    l = entry.getKey();
                }
            }
            if (l != null) {
                this.bYQ.remove(l);
            } else {
                this.bYQ.clear();
            }
        }
    }

    public boolean ip(String str) {
        boolean z = false;
        try {
            Long valueOf = Long.valueOf(Long.parseLong(str));
            synchronized (this) {
                if (this.bYQ.get(valueOf) != null) {
                    z = true;
                }
            }
        } catch (Exception e) {
            BdLog.e(e.getMessage());
        }
        return z;
    }
}
