package com.baidu.tieba.tbadkCore.util;

import com.baidu.adp.lib.util.BdLog;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes.dex */
public class l {
    private volatile int bnb;
    private volatile HashMap<Long, Integer> caI = new HashMap<>();
    private volatile int caH = 0;

    public l(int i) {
        this.bnb = i;
    }

    public void it(String str) {
        try {
            Long valueOf = Long.valueOf(Long.parseLong(str));
            synchronized (this) {
                if (this.caI.size() >= this.bnb) {
                    aiq();
                }
                this.caH++;
                this.caI.put(valueOf, Integer.valueOf(this.caH));
            }
        } catch (Exception e) {
            BdLog.e(e.getMessage());
        }
    }

    public void aiq() {
        synchronized (this) {
            int i = 134217727;
            Long l = null;
            for (Map.Entry<Long, Integer> entry : this.caI.entrySet()) {
                if (entry.getValue().intValue() < i) {
                    i = entry.getValue().intValue();
                    l = entry.getKey();
                }
            }
            if (l != null) {
                this.caI.remove(l);
            } else {
                this.caI.clear();
            }
        }
    }

    public boolean iu(String str) {
        boolean z = false;
        try {
            Long valueOf = Long.valueOf(Long.parseLong(str));
            synchronized (this) {
                if (this.caI.get(valueOf) != null) {
                    z = true;
                }
            }
        } catch (Exception e) {
            BdLog.e(e.getMessage());
        }
        return z;
    }
}
