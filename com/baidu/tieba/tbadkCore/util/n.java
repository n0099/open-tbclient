package com.baidu.tieba.tbadkCore.util;

import com.baidu.adp.lib.util.BdLog;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes.dex */
public class n extends r {
    private volatile HashMap<Long, com.baidu.tieba.myCollection.baseHistory.b> fiO;

    public n(int i) {
        super(i);
        this.fiO = new HashMap<>();
    }

    public void a(String str, com.baidu.tieba.myCollection.baseHistory.b bVar) {
        qu(str);
        try {
            Long valueOf = Long.valueOf(com.baidu.adp.lib.h.b.c(str, -1L));
            synchronized (this) {
                this.fiO.put(valueOf, bVar);
            }
        } catch (Exception e) {
            BdLog.e(e.getMessage());
        }
    }

    public com.baidu.tieba.myCollection.baseHistory.b qs(String str) {
        com.baidu.tieba.myCollection.baseHistory.b bVar;
        try {
            Long valueOf = Long.valueOf(com.baidu.adp.lib.h.b.c(str, -1L));
            synchronized (this) {
                bVar = this.fiO.get(valueOf) != null ? this.fiO.get(valueOf) : null;
            }
            return bVar;
        } catch (Exception e) {
            BdLog.e(e.getMessage());
            return null;
        }
    }

    @Override // com.baidu.tieba.tbadkCore.util.r
    public void aTd() {
        synchronized (this) {
            int i = 134217727;
            Long l = null;
            for (Map.Entry<Long, Integer> entry : this.fiS.entrySet()) {
                if (entry.getValue().intValue() < i) {
                    i = entry.getValue().intValue();
                    l = entry.getKey();
                }
            }
            if (l != null) {
                this.fiS.remove(l);
                this.fiO.remove(l);
            } else {
                this.fiS.clear();
                this.fiO.clear();
            }
        }
    }
}
