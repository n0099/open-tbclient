package com.baidu.tieba.tbadkCore.util;

import com.baidu.adp.lib.util.BdLog;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes.dex */
public class e {
    protected volatile int gjb;
    protected volatile HashMap<Long, Integer> gjc = new HashMap<>();
    private volatile int gja = 0;

    public e(int i) {
        this.gjb = i;
    }

    public void rX(String str) {
        try {
            Long valueOf = Long.valueOf(Long.parseLong(str));
            synchronized (this) {
                if (this.gjc.size() >= this.gjb) {
                    baS();
                }
                this.gja++;
                this.gjc.put(valueOf, Integer.valueOf(this.gja));
            }
        } catch (Exception e) {
            BdLog.e(e.getMessage());
        }
    }

    public void baS() {
        int i;
        Long l;
        synchronized (this) {
            Long l2 = null;
            int i2 = 134217727;
            for (Map.Entry<Long, Integer> entry : this.gjc.entrySet()) {
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
                this.gjc.remove(l2);
            } else {
                this.gjc.clear();
            }
        }
    }

    public boolean rY(String str) {
        boolean z;
        try {
            Long valueOf = Long.valueOf(Long.parseLong(str));
            synchronized (this) {
                z = this.gjc.get(valueOf) != null;
            }
            return z;
        } catch (Exception e) {
            BdLog.e(e.getMessage());
            return false;
        }
    }

    public boolean rZ(String str) {
        try {
            return this.gjc.containsKey(Long.valueOf(Long.parseLong(str)));
        } catch (Exception e) {
            BdLog.e(e.getMessage());
            return false;
        }
    }

    public void bsl() {
        synchronized (this) {
            this.gjc.clear();
        }
    }
}
