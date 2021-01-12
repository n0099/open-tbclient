package com.baidu.tieba.tbadkCore.util;

import com.baidu.adp.lib.util.BdLog;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes.dex */
public class d {
    protected volatile int fbT;
    protected volatile HashMap<Long, Integer> nqf = new HashMap<>();
    private volatile int mWeight = 0;

    public d(int i) {
        this.fbT = i;
    }

    public void SB(String str) {
        try {
            Long valueOf = Long.valueOf(Long.parseLong(str));
            synchronized (this) {
                if (this.nqf.size() >= this.fbT) {
                    dMz();
                }
                this.mWeight++;
                this.nqf.put(valueOf, Integer.valueOf(this.mWeight));
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
            for (Map.Entry<Long, Integer> entry : this.nqf.entrySet()) {
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
                this.nqf.remove(l2);
            } else {
                this.nqf.clear();
            }
        }
    }

    public boolean SC(String str) {
        boolean z;
        try {
            Long valueOf = Long.valueOf(Long.parseLong(str));
            synchronized (this) {
                z = this.nqf.get(valueOf) != null;
            }
            return z;
        } catch (Exception e) {
            BdLog.e(e.getMessage());
            return false;
        }
    }

    public boolean SD(String str) {
        try {
            return this.nqf.containsKey(Long.valueOf(Long.parseLong(str)));
        } catch (Exception e) {
            BdLog.e(e.getMessage());
            return false;
        }
    }

    public void dMy() {
        synchronized (this) {
            this.nqf.clear();
        }
    }
}
