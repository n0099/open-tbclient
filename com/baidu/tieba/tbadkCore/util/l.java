package com.baidu.tieba.tbadkCore.util;

import com.baidu.adp.lib.util.BdLog;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes.dex */
public class l {
    private volatile int bnc;
    private volatile HashMap<Long, Integer> caJ = new HashMap<>();
    private volatile int caI = 0;

    public l(int i) {
        this.bnc = i;
    }

    public void iv(String str) {
        try {
            Long valueOf = Long.valueOf(Long.parseLong(str));
            synchronized (this) {
                if (this.caJ.size() >= this.bnc) {
                    aiv();
                }
                this.caI++;
                this.caJ.put(valueOf, Integer.valueOf(this.caI));
            }
        } catch (Exception e) {
            BdLog.e(e.getMessage());
        }
    }

    public void aiv() {
        synchronized (this) {
            int i = 134217727;
            Long l = null;
            for (Map.Entry<Long, Integer> entry : this.caJ.entrySet()) {
                if (entry.getValue().intValue() < i) {
                    i = entry.getValue().intValue();
                    l = entry.getKey();
                }
            }
            if (l != null) {
                this.caJ.remove(l);
            } else {
                this.caJ.clear();
            }
        }
    }

    public boolean iw(String str) {
        boolean z = false;
        try {
            Long valueOf = Long.valueOf(Long.parseLong(str));
            synchronized (this) {
                if (this.caJ.get(valueOf) != null) {
                    z = true;
                }
            }
        } catch (Exception e) {
            BdLog.e(e.getMessage());
        }
        return z;
    }
}
