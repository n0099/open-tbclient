package com.baidu.tieba.tbadkCore.util;

import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
/* loaded from: classes.dex */
public class p extends r {
    private volatile HashMap<String, Long> fEI;

    static {
        MessageManager.getInstance().registerListener(new q(CmdConfigCustom.METHOD_ACCOUNT_CHANGE));
    }

    public p(int i) {
        super(i);
        this.fEI = new HashMap<>();
    }

    public void bY(String str, String str2) {
        try {
            Long valueOf = Long.valueOf(Long.parseLong(str2));
            synchronized (this) {
                if (this.fEI.size() >= this.fEK) {
                    aZs();
                }
                this.fEI.put(str, valueOf);
            }
        } catch (Exception e) {
            BdLog.e(e.getMessage());
        }
    }

    public long rN(String str) {
        long longValue;
        try {
            synchronized (this) {
                longValue = this.fEI.get(str) != null ? this.fEI.get(str).longValue() : 0L;
            }
            return longValue;
        } catch (Exception e) {
            BdLog.e(e.getMessage());
            return 0L;
        }
    }

    public void bZ(String str, String str2) {
        String key;
        try {
            Long valueOf = Long.valueOf(Long.parseLong(str2));
            synchronized (this) {
                Iterator<Map.Entry<String, Long>> it = this.fEI.entrySet().iterator();
                if (it.hasNext() && (key = it.next().getKey()) != null && key.equals(str)) {
                    this.fEI.remove(key);
                }
                this.fEI.put(str, valueOf);
            }
        } catch (Exception e) {
            BdLog.e(e.getMessage());
        }
    }

    @Override // com.baidu.tieba.tbadkCore.util.r
    public void bnd() {
        synchronized (this) {
            this.fEL.clear();
            this.fEI.clear();
        }
    }
}
