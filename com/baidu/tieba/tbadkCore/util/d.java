package com.baidu.tieba.tbadkCore.util;

import com.baidu.adp.lib.util.BdLog;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes.dex */
public class d {
    protected volatile int fej;
    protected volatile HashMap<Long, Integer> nAp = new HashMap<>();
    private volatile int mWeight = 0;

    public d(int i) {
        this.fej = i;
    }

    public void TL(String str) {
        try {
            Long valueOf = Long.valueOf(Long.parseLong(str));
            synchronized (this) {
                if (this.nAp.size() >= this.fej) {
                    dOS();
                }
                this.mWeight++;
                this.nAp.put(valueOf, Integer.valueOf(this.mWeight));
            }
        } catch (Exception e) {
            BdLog.e(e.getMessage());
        }
    }

    public void dOS() {
        int i;
        Long l;
        synchronized (this) {
            Long l2 = null;
            int i2 = 134217727;
            for (Map.Entry<Long, Integer> entry : this.nAp.entrySet()) {
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
                this.nAp.remove(l2);
            } else {
                this.nAp.clear();
            }
        }
    }

    public boolean TM(String str) {
        boolean z;
        try {
            Long valueOf = Long.valueOf(Long.parseLong(str));
            synchronized (this) {
                z = this.nAp.get(valueOf) != null;
            }
            return z;
        } catch (Exception e) {
            BdLog.e(e.getMessage());
            return false;
        }
    }

    public boolean TN(String str) {
        try {
            return this.nAp.containsKey(Long.valueOf(Long.parseLong(str)));
        } catch (Exception e) {
            BdLog.e(e.getMessage());
            return false;
        }
    }

    public void dOR() {
        synchronized (this) {
            this.nAp.clear();
        }
    }
}
