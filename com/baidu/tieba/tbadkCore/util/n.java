package com.baidu.tieba.tbadkCore.util;

import com.baidu.adp.lib.util.BdLog;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes.dex */
public class n extends r {
    private volatile HashMap<Long, com.baidu.tieba.myCollection.baseHistory.a> fwG;

    public n(int i) {
        super(i);
        this.fwG = new HashMap<>();
    }

    public void a(String str, com.baidu.tieba.myCollection.baseHistory.a aVar) {
        qh(str);
        try {
            Long valueOf = Long.valueOf(com.baidu.adp.lib.g.b.c(str, -1L));
            synchronized (this) {
                this.fwG.put(valueOf, aVar);
            }
        } catch (Exception e) {
            BdLog.e(e.getMessage());
        }
    }

    @Override // com.baidu.tieba.tbadkCore.util.r
    public void aTm() {
        synchronized (this) {
            int i = 134217727;
            Long l = null;
            for (Map.Entry<Long, Integer> entry : this.fwK.entrySet()) {
                if (entry.getValue().intValue() < i) {
                    i = entry.getValue().intValue();
                    l = entry.getKey();
                }
            }
            if (l != null) {
                this.fwK.remove(l);
                this.fwG.remove(l);
            } else {
                this.fwK.clear();
                this.fwG.clear();
            }
        }
    }
}
