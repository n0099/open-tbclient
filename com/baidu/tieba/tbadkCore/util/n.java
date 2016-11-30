package com.baidu.tieba.tbadkCore.util;

import com.baidu.adp.lib.util.BdLog;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes.dex */
public class n extends r {
    private volatile HashMap<Long, com.baidu.tieba.myCollection.baseHistory.b> fEH;

    public n(int i) {
        super(i);
        this.fEH = new HashMap<>();
    }

    public void a(String str, com.baidu.tieba.myCollection.baseHistory.b bVar) {
        rO(str);
        try {
            Long valueOf = Long.valueOf(com.baidu.adp.lib.h.b.c(str, -1L));
            synchronized (this) {
                this.fEH.put(valueOf, bVar);
            }
        } catch (Exception e) {
            BdLog.e(e.getMessage());
        }
    }

    public com.baidu.tieba.myCollection.baseHistory.b rM(String str) {
        com.baidu.tieba.myCollection.baseHistory.b bVar;
        try {
            Long valueOf = Long.valueOf(com.baidu.adp.lib.h.b.c(str, -1L));
            synchronized (this) {
                bVar = this.fEH.get(valueOf) != null ? this.fEH.get(valueOf) : null;
            }
            return bVar;
        } catch (Exception e) {
            BdLog.e(e.getMessage());
            return null;
        }
    }

    @Override // com.baidu.tieba.tbadkCore.util.r
    public void aZs() {
        synchronized (this) {
            int i = 134217727;
            Long l = null;
            for (Map.Entry<Long, Integer> entry : this.fEL.entrySet()) {
                if (entry.getValue().intValue() < i) {
                    i = entry.getValue().intValue();
                    l = entry.getKey();
                }
            }
            if (l != null) {
                this.fEL.remove(l);
                this.fEH.remove(l);
            } else {
                this.fEL.clear();
                this.fEH.clear();
            }
        }
    }
}
