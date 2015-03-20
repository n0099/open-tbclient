package com.baidu.tieba.tbadkCore.util;

import com.baidu.adp.lib.util.BdLog;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes.dex */
public class l {
    private volatile int bVX;
    private volatile HashMap<Long, Integer> cpL = new HashMap<>();
    private volatile int cpK = 0;

    public l(int i) {
        this.bVX = i;
    }

    public void iN(String str) {
        try {
            Long valueOf = Long.valueOf(Long.parseLong(str));
            synchronized (this) {
                if (this.cpL.size() >= this.bVX) {
                    anv();
                }
                this.cpK++;
                this.cpL.put(valueOf, Integer.valueOf(this.cpK));
            }
        } catch (Exception e) {
            BdLog.e(e.getMessage());
        }
    }

    public void anv() {
        synchronized (this) {
            int i = 134217727;
            Long l = null;
            for (Map.Entry<Long, Integer> entry : this.cpL.entrySet()) {
                if (entry.getValue().intValue() < i) {
                    i = entry.getValue().intValue();
                    l = entry.getKey();
                }
            }
            if (l != null) {
                this.cpL.remove(l);
            } else {
                this.cpL.clear();
            }
        }
    }

    public boolean iO(String str) {
        boolean z = false;
        try {
            Long valueOf = Long.valueOf(Long.parseLong(str));
            synchronized (this) {
                if (this.cpL.get(valueOf) != null) {
                    z = true;
                }
            }
        } catch (Exception e) {
            BdLog.e(e.getMessage());
        }
        return z;
    }
}
