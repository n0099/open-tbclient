package com.baidu.tieba.tbadkCore.util;

import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
/* loaded from: classes.dex */
public class p extends r {
    private volatile HashMap<String, Long> fyi;

    static {
        MessageManager.getInstance().registerListener(new q(CmdConfigCustom.METHOD_ACCOUNT_CHANGE));
    }

    public p(int i) {
        super(i);
        this.fyi = new HashMap<>();
    }

    public void cf(String str, String str2) {
        try {
            Long valueOf = Long.valueOf(Long.parseLong(str2));
            synchronized (this) {
                if (this.fyi.size() >= this.fyk) {
                    aUM();
                }
                this.fyi.put(str, valueOf);
            }
        } catch (Exception e) {
            BdLog.e(e.getMessage());
        }
    }

    public long qm(String str) {
        long longValue;
        try {
            synchronized (this) {
                longValue = this.fyi.get(str) != null ? this.fyi.get(str).longValue() : 0L;
            }
            return longValue;
        } catch (Exception e) {
            BdLog.e(e.getMessage());
            return 0L;
        }
    }

    public void cg(String str, String str2) {
        String key;
        try {
            Long valueOf = Long.valueOf(Long.parseLong(str2));
            synchronized (this) {
                Iterator<Map.Entry<String, Long>> it = this.fyi.entrySet().iterator();
                if (it.hasNext() && (key = it.next().getKey()) != null && key.equals(str)) {
                    this.fyi.remove(key);
                }
                this.fyi.put(str, valueOf);
            }
        } catch (Exception e) {
            BdLog.e(e.getMessage());
        }
    }

    @Override // com.baidu.tieba.tbadkCore.util.r
    public void bjj() {
        synchronized (this) {
            this.fyl.clear();
            this.fyi.clear();
        }
    }
}
