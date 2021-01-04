package com.baidu.tieba.tbadkCore.util;

import com.baidu.adp.lib.util.BdLog;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes.dex */
public class d {
    protected volatile int fgC;
    protected volatile HashMap<Long, Integer> nuM = new HashMap<>();
    private volatile int mWeight = 0;

    public d(int i) {
        this.fgC = i;
    }

    public void TK(String str) {
        try {
            Long valueOf = Long.valueOf(Long.parseLong(str));
            synchronized (this) {
                if (this.nuM.size() >= this.fgC) {
                    dQq();
                }
                this.mWeight++;
                this.nuM.put(valueOf, Integer.valueOf(this.mWeight));
            }
        } catch (Exception e) {
            BdLog.e(e.getMessage());
        }
    }

    public void dQq() {
        int i;
        Long l;
        synchronized (this) {
            Long l2 = null;
            int i2 = 134217727;
            for (Map.Entry<Long, Integer> entry : this.nuM.entrySet()) {
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
                this.nuM.remove(l2);
            } else {
                this.nuM.clear();
            }
        }
    }

    public boolean TL(String str) {
        boolean z;
        try {
            Long valueOf = Long.valueOf(Long.parseLong(str));
            synchronized (this) {
                z = this.nuM.get(valueOf) != null;
            }
            return z;
        } catch (Exception e) {
            BdLog.e(e.getMessage());
            return false;
        }
    }

    public boolean TM(String str) {
        try {
            return this.nuM.containsKey(Long.valueOf(Long.parseLong(str)));
        } catch (Exception e) {
            BdLog.e(e.getMessage());
            return false;
        }
    }

    public void dQp() {
        synchronized (this) {
            this.nuM.clear();
        }
    }
}
