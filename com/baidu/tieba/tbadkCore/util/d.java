package com.baidu.tieba.tbadkCore.util;

import com.baidu.adp.lib.util.BdLog;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes.dex */
public class d {
    protected volatile int fbT;
    protected volatile HashMap<Long, Integer> nqg = new HashMap<>();
    private volatile int mWeight = 0;

    public d(int i) {
        this.fbT = i;
    }

    public void SC(String str) {
        try {
            Long valueOf = Long.valueOf(Long.parseLong(str));
            synchronized (this) {
                if (this.nqg.size() >= this.fbT) {
                    dMz();
                }
                this.mWeight++;
                this.nqg.put(valueOf, Integer.valueOf(this.mWeight));
            }
        } catch (Exception e) {
            BdLog.e(e.getMessage());
        }
    }

    public void dMz() {
        int i;
        Long l;
        synchronized (this) {
            Long l2 = null;
            int i2 = 134217727;
            for (Map.Entry<Long, Integer> entry : this.nqg.entrySet()) {
                if (entry.getValue().intValue() < i2) {
                    i = entry.getValue().intValue();
                    l = entry.getKey();
                } else {
                    i = i2;
                    l = l2;
                }
                i2 = i;
                l2 = l;
            }
            if (l2 != null) {
                this.nqg.remove(l2);
            } else {
                this.nqg.clear();
            }
        }
    }

    public boolean SD(String str) {
        boolean z;
        try {
            Long valueOf = Long.valueOf(Long.parseLong(str));
            synchronized (this) {
                z = this.nqg.get(valueOf) != null;
            }
            return z;
        } catch (Exception e) {
            BdLog.e(e.getMessage());
            return false;
        }
    }

    public boolean SE(String str) {
        try {
            return this.nqg.containsKey(Long.valueOf(Long.parseLong(str)));
        } catch (Exception e) {
            BdLog.e(e.getMessage());
            return false;
        }
    }

    public void dMy() {
        synchronized (this) {
            this.nqg.clear();
        }
    }
}
