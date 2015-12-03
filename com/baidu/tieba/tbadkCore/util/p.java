package com.baidu.tieba.tbadkCore.util;

import com.baidu.adp.lib.util.BdLog;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes.dex */
public class p {
    protected volatile int dgl;
    private volatile HashMap<Long, Integer> dBJ = new HashMap<>();
    private volatile int dBI = 0;

    public p(int i) {
        this.dgl = i;
    }

    public void mE(String str) {
        try {
            Long valueOf = Long.valueOf(Long.parseLong(str));
            synchronized (this) {
                if (this.dBJ.size() >= this.dgl) {
                    arI();
                }
                this.dBI++;
                this.dBJ.put(valueOf, Integer.valueOf(this.dBI));
            }
        } catch (Exception e) {
            BdLog.e(e.getMessage());
        }
    }

    public void arI() {
        synchronized (this) {
            int i = 134217727;
            Long l = null;
            for (Map.Entry<Long, Integer> entry : this.dBJ.entrySet()) {
                if (entry.getValue().intValue() < i) {
                    i = entry.getValue().intValue();
                    l = entry.getKey();
                }
            }
            if (l != null) {
                this.dBJ.remove(l);
            } else {
                this.dBJ.clear();
            }
        }
    }

    public boolean mF(String str) {
        boolean z = false;
        try {
            Long valueOf = Long.valueOf(Long.parseLong(str));
            synchronized (this) {
                if (this.dBJ.get(valueOf) != null) {
                    z = true;
                }
            }
        } catch (Exception e) {
            BdLog.e(e.getMessage());
        }
        return z;
    }
}
