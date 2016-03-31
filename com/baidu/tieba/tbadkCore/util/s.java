package com.baidu.tieba.tbadkCore.util;

import com.baidu.adp.lib.util.BdLog;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes.dex */
public class s {
    protected volatile int esc;
    protected volatile HashMap<Long, Integer> esd = new HashMap<>();
    private volatile int esb = 0;

    public s(int i) {
        this.esc = i;
    }

    public void og(String str) {
        try {
            Long valueOf = Long.valueOf(Long.parseLong(str));
            synchronized (this) {
                if (this.esd.size() >= this.esc) {
                    aGZ();
                }
                this.esb++;
                this.esd.put(valueOf, Integer.valueOf(this.esb));
            }
        } catch (Exception e) {
            BdLog.e(e.getMessage());
        }
    }

    public void aGZ() {
        synchronized (this) {
            int i = 134217727;
            Long l = null;
            for (Map.Entry<Long, Integer> entry : this.esd.entrySet()) {
                if (entry.getValue().intValue() < i) {
                    i = entry.getValue().intValue();
                    l = entry.getKey();
                }
            }
            if (l != null) {
                this.esd.remove(l);
            } else {
                this.esd.clear();
            }
        }
    }

    public boolean oh(String str) {
        boolean z = false;
        try {
            Long valueOf = Long.valueOf(Long.parseLong(str));
            synchronized (this) {
                if (this.esd.get(valueOf) != null) {
                    z = true;
                }
            }
        } catch (Exception e) {
            BdLog.e(e.getMessage());
        }
        return z;
    }

    public void aUw() {
        synchronized (this) {
            this.esd.clear();
        }
    }
}
