package com.baidu.tieba.tbadkCore.util;

import com.baidu.adp.lib.util.BdLog;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes.dex */
public class e {
    protected volatile int haP;
    protected volatile HashMap<Long, Integer> haQ = new HashMap<>();
    private volatile int haO = 0;

    public e(int i) {
        this.haP = i;
    }

    public void sG(String str) {
        try {
            Long valueOf = Long.valueOf(Long.parseLong(str));
            synchronized (this) {
                if (this.haQ.size() >= this.haP) {
                    bwE();
                }
                this.haO++;
                this.haQ.put(valueOf, Integer.valueOf(this.haO));
            }
        } catch (Exception e) {
            BdLog.e(e.getMessage());
        }
    }

    public void bwE() {
        int i;
        Long l;
        synchronized (this) {
            Long l2 = null;
            int i2 = 134217727;
            for (Map.Entry<Long, Integer> entry : this.haQ.entrySet()) {
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
                this.haQ.remove(l2);
            } else {
                this.haQ.clear();
            }
        }
    }

    public boolean sH(String str) {
        boolean z;
        try {
            Long valueOf = Long.valueOf(Long.parseLong(str));
            synchronized (this) {
                z = this.haQ.get(valueOf) != null;
            }
            return z;
        } catch (Exception e) {
            BdLog.e(e.getMessage());
            return false;
        }
    }

    public boolean sI(String str) {
        try {
            return this.haQ.containsKey(Long.valueOf(Long.parseLong(str)));
        } catch (Exception e) {
            BdLog.e(e.getMessage());
            return false;
        }
    }

    public void bwF() {
        synchronized (this) {
            this.haQ.clear();
        }
    }
}
