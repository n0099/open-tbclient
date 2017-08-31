package com.baidu.tieba.tbadkCore.util;

import com.baidu.adp.lib.util.BdLog;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes.dex */
public class c extends f {
    private volatile HashMap<Long, com.baidu.tieba.myCollection.baseHistory.a> gkH;

    public c(int i) {
        super(i);
        this.gkH = new HashMap<>();
    }

    public void a(String str, com.baidu.tieba.myCollection.baseHistory.a aVar) {
        sm(str);
        try {
            Long valueOf = Long.valueOf(com.baidu.adp.lib.g.b.c(str, -1L));
            synchronized (this) {
                this.gkH.put(valueOf, aVar);
            }
        } catch (Exception e) {
            BdLog.e(e.getMessage());
        }
    }

    @Override // com.baidu.tieba.tbadkCore.util.f
    public void bcn() {
        int i;
        Long l;
        synchronized (this) {
            Long l2 = null;
            int i2 = 134217727;
            for (Map.Entry<Long, Integer> entry : this.gkL.entrySet()) {
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
                this.gkL.remove(l2);
                this.gkH.remove(l2);
            } else {
                this.gkL.clear();
                this.gkH.clear();
            }
        }
    }
}
