package com.baidu.tieba.tbadkCore.util;

import com.baidu.adp.lib.util.BdLog;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes.dex */
public class s {
    protected volatile int fxF;
    protected volatile HashMap<Long, Integer> fxG = new HashMap<>();
    private volatile int fxE = 0;

    public s(int i) {
        this.fxF = i;
    }

    public void rt(String str) {
        try {
            Long valueOf = Long.valueOf(Long.parseLong(str));
            synchronized (this) {
                if (this.fxG.size() >= this.fxF) {
                    aXk();
                }
                this.fxE++;
                this.fxG.put(valueOf, Integer.valueOf(this.fxE));
            }
        } catch (Exception e) {
            BdLog.e(e.getMessage());
        }
    }

    public void aXk() {
        synchronized (this) {
            int i = 134217727;
            Long l = null;
            for (Map.Entry<Long, Integer> entry : this.fxG.entrySet()) {
                if (entry.getValue().intValue() < i) {
                    i = entry.getValue().intValue();
                    l = entry.getKey();
                }
            }
            if (l != null) {
                this.fxG.remove(l);
            } else {
                this.fxG.clear();
            }
        }
    }

    public boolean ru(String str) {
        boolean z = false;
        try {
            Long valueOf = Long.valueOf(Long.parseLong(str));
            synchronized (this) {
                if (this.fxG.get(valueOf) != null) {
                    z = true;
                }
            }
        } catch (Exception e) {
            BdLog.e(e.getMessage());
        }
        return z;
    }

    public boolean rv(String str) {
        try {
            return this.fxG.containsKey(Long.valueOf(Long.parseLong(str)));
        } catch (Exception e) {
            BdLog.e(e.getMessage());
            return false;
        }
    }

    public void bkN() {
        synchronized (this) {
            this.fxG.clear();
        }
    }
}
