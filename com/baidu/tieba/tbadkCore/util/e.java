package com.baidu.tieba.tbadkCore.util;

import com.baidu.adp.lib.util.BdLog;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes.dex */
public class e {
    protected volatile int hbj;
    protected volatile HashMap<Long, Integer> hbk = new HashMap<>();
    private volatile int hbi = 0;

    public e(int i) {
        this.hbj = i;
    }

    public void sN(String str) {
        try {
            Long valueOf = Long.valueOf(Long.parseLong(str));
            synchronized (this) {
                if (this.hbk.size() >= this.hbj) {
                    bwG();
                }
                this.hbi++;
                this.hbk.put(valueOf, Integer.valueOf(this.hbi));
            }
        } catch (Exception e) {
            BdLog.e(e.getMessage());
        }
    }

    public void bwG() {
        int i;
        Long l;
        synchronized (this) {
            Long l2 = null;
            int i2 = 134217727;
            for (Map.Entry<Long, Integer> entry : this.hbk.entrySet()) {
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
                this.hbk.remove(l2);
            } else {
                this.hbk.clear();
            }
        }
    }

    public boolean sO(String str) {
        boolean z;
        try {
            Long valueOf = Long.valueOf(Long.parseLong(str));
            synchronized (this) {
                z = this.hbk.get(valueOf) != null;
            }
            return z;
        } catch (Exception e) {
            BdLog.e(e.getMessage());
            return false;
        }
    }

    public boolean sP(String str) {
        try {
            return this.hbk.containsKey(Long.valueOf(Long.parseLong(str)));
        } catch (Exception e) {
            BdLog.e(e.getMessage());
            return false;
        }
    }

    public void bwH() {
        synchronized (this) {
            this.hbk.clear();
        }
    }
}
