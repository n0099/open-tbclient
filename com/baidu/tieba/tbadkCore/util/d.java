package com.baidu.tieba.tbadkCore.util;

import com.baidu.adp.lib.util.BdLog;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes.dex */
public class d {
    protected volatile int dXZ;
    protected volatile HashMap<Long, Integer> lIS = new HashMap<>();
    private volatile int mWeight = 0;

    public d(int i) {
        this.dXZ = i;
    }

    public void Nq(String str) {
        try {
            Long valueOf = Long.valueOf(Long.parseLong(str));
            synchronized (this) {
                if (this.lIS.size() >= this.dXZ) {
                    djd();
                }
                this.mWeight++;
                this.lIS.put(valueOf, Integer.valueOf(this.mWeight));
            }
        } catch (Exception e) {
            BdLog.e(e.getMessage());
        }
    }

    public void djd() {
        int i;
        Long l;
        synchronized (this) {
            Long l2 = null;
            int i2 = 134217727;
            for (Map.Entry<Long, Integer> entry : this.lIS.entrySet()) {
                if (entry.getValue().intValue() < i2) {
                    int intValue = entry.getValue().intValue();
                    l = entry.getKey();
                    i = intValue;
                } else {
                    i = i2;
                    l = l2;
                }
                i2 = i;
                l2 = l;
            }
            if (l2 != null) {
                this.lIS.remove(l2);
            } else {
                this.lIS.clear();
            }
        }
    }

    public boolean Nr(String str) {
        boolean z;
        try {
            Long valueOf = Long.valueOf(Long.parseLong(str));
            synchronized (this) {
                z = this.lIS.get(valueOf) != null;
            }
            return z;
        } catch (Exception e) {
            BdLog.e(e.getMessage());
            return false;
        }
    }

    public boolean Ns(String str) {
        try {
            return this.lIS.containsKey(Long.valueOf(Long.parseLong(str)));
        } catch (Exception e) {
            BdLog.e(e.getMessage());
            return false;
        }
    }

    public void djc() {
        synchronized (this) {
            this.lIS.clear();
        }
    }
}
