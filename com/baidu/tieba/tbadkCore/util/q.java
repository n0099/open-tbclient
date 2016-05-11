package com.baidu.tieba.tbadkCore.util;

import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
/* loaded from: classes.dex */
public class q extends s {
    private volatile HashMap<String, Long> evj;

    static {
        MessageManager.getInstance().registerListener(new r(CmdConfigCustom.METHOD_ACCOUNT_CHANGE));
    }

    public q(int i) {
        super(i);
        this.evj = new HashMap<>();
    }

    public void bN(String str, String str2) {
        try {
            Long valueOf = Long.valueOf(Long.parseLong(str2));
            synchronized (this) {
                if (this.evj.size() >= this.evl) {
                    aHz();
                }
                this.evj.put(str, valueOf);
            }
        } catch (Exception e) {
            BdLog.e(e.getMessage());
        }
    }

    public long ob(String str) {
        long longValue;
        try {
            synchronized (this) {
                longValue = this.evj.get(str) != null ? this.evj.get(str).longValue() : 0L;
            }
            return longValue;
        } catch (Exception e) {
            BdLog.e(e.getMessage());
            return 0L;
        }
    }

    public void bO(String str, String str2) {
        String key;
        try {
            Long valueOf = Long.valueOf(Long.parseLong(str2));
            synchronized (this) {
                Iterator<Map.Entry<String, Long>> it = this.evj.entrySet().iterator();
                if (it.hasNext() && (key = it.next().getKey()) != null && key.equals(str)) {
                    this.evj.remove(key);
                }
                this.evj.put(str, valueOf);
            }
        } catch (Exception e) {
            BdLog.e(e.getMessage());
        }
    }

    @Override // com.baidu.tieba.tbadkCore.util.s
    public void aUR() {
        synchronized (this) {
            this.evm.clear();
            this.evj.clear();
        }
    }
}
