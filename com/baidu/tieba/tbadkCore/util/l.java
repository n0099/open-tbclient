package com.baidu.tieba.tbadkCore.util;

import com.baidu.adp.lib.util.BdLog;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes.dex */
public class l {
    private volatile int bZR;
    private volatile HashMap<Long, Integer> cug = new HashMap<>();
    private volatile int cuf = 0;

    public l(int i) {
        this.bZR = i;
    }

    public void jK(String str) {
        try {
            Long valueOf = Long.valueOf(Long.parseLong(str));
            synchronized (this) {
                if (this.cug.size() >= this.bZR) {
                    apD();
                }
                this.cuf++;
                this.cug.put(valueOf, Integer.valueOf(this.cuf));
            }
        } catch (Exception e) {
            BdLog.e(e.getMessage());
        }
    }

    public void apD() {
        synchronized (this) {
            int i = 134217727;
            Long l = null;
            for (Map.Entry<Long, Integer> entry : this.cug.entrySet()) {
                if (entry.getValue().intValue() < i) {
                    i = entry.getValue().intValue();
                    l = entry.getKey();
                }
            }
            if (l != null) {
                this.cug.remove(l);
            } else {
                this.cug.clear();
            }
        }
    }

    public boolean jL(String str) {
        boolean z = false;
        try {
            Long valueOf = Long.valueOf(Long.parseLong(str));
            synchronized (this) {
                if (this.cug.get(valueOf) != null) {
                    z = true;
                }
            }
        } catch (Exception e) {
            BdLog.e(e.getMessage());
        }
        return z;
    }
}
