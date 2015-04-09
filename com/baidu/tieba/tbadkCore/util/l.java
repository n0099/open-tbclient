package com.baidu.tieba.tbadkCore.util;

import com.baidu.adp.lib.util.BdLog;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes.dex */
public class l {
    private volatile int bWn;
    private volatile HashMap<Long, Integer> cqb = new HashMap<>();
    private volatile int cqa = 0;

    public l(int i) {
        this.bWn = i;
    }

    public void iQ(String str) {
        try {
            Long valueOf = Long.valueOf(Long.parseLong(str));
            synchronized (this) {
                if (this.cqb.size() >= this.bWn) {
                    anK();
                }
                this.cqa++;
                this.cqb.put(valueOf, Integer.valueOf(this.cqa));
            }
        } catch (Exception e) {
            BdLog.e(e.getMessage());
        }
    }

    public void anK() {
        synchronized (this) {
            int i = 134217727;
            Long l = null;
            for (Map.Entry<Long, Integer> entry : this.cqb.entrySet()) {
                if (entry.getValue().intValue() < i) {
                    i = entry.getValue().intValue();
                    l = entry.getKey();
                }
            }
            if (l != null) {
                this.cqb.remove(l);
            } else {
                this.cqb.clear();
            }
        }
    }

    public boolean iR(String str) {
        boolean z = false;
        try {
            Long valueOf = Long.valueOf(Long.parseLong(str));
            synchronized (this) {
                if (this.cqb.get(valueOf) != null) {
                    z = true;
                }
            }
        } catch (Exception e) {
            BdLog.e(e.getMessage());
        }
        return z;
    }
}
