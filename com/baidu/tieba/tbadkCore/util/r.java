package com.baidu.tieba.tbadkCore.util;

import com.baidu.adp.lib.util.BdLog;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes.dex */
public class r {
    protected volatile int dzN;
    protected volatile HashMap<Long, Integer> dZn = new HashMap<>();
    private volatile int dZm = 0;

    public r(int i) {
        this.dzN = i;
    }

    public void mT(String str) {
        try {
            Long valueOf = Long.valueOf(Long.parseLong(str));
            synchronized (this) {
                if (this.dZn.size() >= this.dzN) {
                    azo();
                }
                this.dZm++;
                this.dZn.put(valueOf, Integer.valueOf(this.dZm));
            }
        } catch (Exception e) {
            BdLog.e(e.getMessage());
        }
    }

    public void azo() {
        synchronized (this) {
            int i = 134217727;
            Long l = null;
            for (Map.Entry<Long, Integer> entry : this.dZn.entrySet()) {
                if (entry.getValue().intValue() < i) {
                    i = entry.getValue().intValue();
                    l = entry.getKey();
                }
            }
            if (l != null) {
                this.dZn.remove(l);
            } else {
                this.dZn.clear();
            }
        }
    }

    public boolean mU(String str) {
        boolean z = false;
        try {
            Long valueOf = Long.valueOf(Long.parseLong(str));
            synchronized (this) {
                if (this.dZn.get(valueOf) != null) {
                    z = true;
                }
            }
        } catch (Exception e) {
            BdLog.e(e.getMessage());
        }
        return z;
    }

    public void aNv() {
        synchronized (this) {
            this.dZn.clear();
        }
    }
}
