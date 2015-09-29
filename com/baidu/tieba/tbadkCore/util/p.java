package com.baidu.tieba.tbadkCore.util;

import com.baidu.adp.lib.util.BdLog;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes.dex */
public class p {
    protected volatile int cFV;
    private volatile HashMap<Long, Integer> daN = new HashMap<>();
    private volatile int daM = 0;

    public p(int i) {
        this.cFV = i;
    }

    public void lH(String str) {
        try {
            Long valueOf = Long.valueOf(Long.parseLong(str));
            synchronized (this) {
                if (this.daN.size() >= this.cFV) {
                    axy();
                }
                this.daM++;
                this.daN.put(valueOf, Integer.valueOf(this.daM));
            }
        } catch (Exception e) {
            BdLog.e(e.getMessage());
        }
    }

    public void axy() {
        synchronized (this) {
            int i = 134217727;
            Long l = null;
            for (Map.Entry<Long, Integer> entry : this.daN.entrySet()) {
                if (entry.getValue().intValue() < i) {
                    i = entry.getValue().intValue();
                    l = entry.getKey();
                }
            }
            if (l != null) {
                this.daN.remove(l);
            } else {
                this.daN.clear();
            }
        }
    }

    public boolean lI(String str) {
        boolean z = false;
        try {
            Long valueOf = Long.valueOf(Long.parseLong(str));
            synchronized (this) {
                if (this.daN.get(valueOf) != null) {
                    z = true;
                }
            }
        } catch (Exception e) {
            BdLog.e(e.getMessage());
        }
        return z;
    }
}
