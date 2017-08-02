package com.baidu.tieba.tbadkCore.util;

import com.baidu.adp.lib.util.BdLog;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes.dex */
public class f {
    protected volatile int gjf;
    protected volatile HashMap<Long, Integer> gjg = new HashMap<>();
    private volatile int gje = 0;

    public f(int i) {
        this.gjf = i;
    }

    public void sf(String str) {
        try {
            Long valueOf = Long.valueOf(Long.parseLong(str));
            synchronized (this) {
                if (this.gjg.size() >= this.gjf) {
                    bcq();
                }
                this.gje++;
                this.gjg.put(valueOf, Integer.valueOf(this.gje));
            }
        } catch (Exception e) {
            BdLog.e(e.getMessage());
        }
    }

    public void bcq() {
        int i;
        Long l;
        synchronized (this) {
            Long l2 = null;
            int i2 = 134217727;
            for (Map.Entry<Long, Integer> entry : this.gjg.entrySet()) {
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
                this.gjg.remove(l2);
            } else {
                this.gjg.clear();
            }
        }
    }

    public boolean sg(String str) {
        boolean z;
        try {
            Long valueOf = Long.valueOf(Long.parseLong(str));
            synchronized (this) {
                z = this.gjg.get(valueOf) != null;
            }
            return z;
        } catch (Exception e) {
            BdLog.e(e.getMessage());
            return false;
        }
    }

    public boolean sh(String str) {
        try {
            return this.gjg.containsKey(Long.valueOf(Long.parseLong(str)));
        } catch (Exception e) {
            BdLog.e(e.getMessage());
            return false;
        }
    }

    public void btm() {
        synchronized (this) {
            this.gjg.clear();
        }
    }
}
