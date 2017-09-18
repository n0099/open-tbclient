package com.baidu.tieba.tbadkCore.util;

import com.baidu.adp.lib.util.BdLog;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes.dex */
public class c extends f {
    private volatile HashMap<Long, com.baidu.tieba.myCollection.baseHistory.a> glB;

    public c(int i) {
        super(i);
        this.glB = new HashMap<>();
    }

    public void a(String str, com.baidu.tieba.myCollection.baseHistory.a aVar) {
        so(str);
        try {
            Long valueOf = Long.valueOf(com.baidu.adp.lib.g.b.c(str, -1L));
            synchronized (this) {
                this.glB.put(valueOf, aVar);
            }
        } catch (Exception e) {
            BdLog.e(e.getMessage());
        }
    }

    @Override // com.baidu.tieba.tbadkCore.util.f
    public void bcy() {
        int i;
        Long l;
        synchronized (this) {
            Long l2 = null;
            int i2 = 134217727;
            for (Map.Entry<Long, Integer> entry : this.glF.entrySet()) {
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
                this.glF.remove(l2);
                this.glB.remove(l2);
            } else {
                this.glF.clear();
                this.glB.clear();
            }
        }
    }
}
