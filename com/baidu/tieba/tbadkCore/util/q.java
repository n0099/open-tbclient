package com.baidu.tieba.tbadkCore.util;

import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
/* loaded from: classes.dex */
public class q extends s {
    private volatile HashMap<String, Long> esa;

    static {
        MessageManager.getInstance().registerListener(new r(CmdConfigCustom.METHOD_ACCOUNT_CHANGE));
    }

    public q(int i) {
        super(i);
        this.esa = new HashMap<>();
    }

    public void bI(String str, String str2) {
        try {
            Long valueOf = Long.valueOf(Long.parseLong(str2));
            synchronized (this) {
                if (this.esa.size() >= this.esc) {
                    aGZ();
                }
                this.esa.put(str, valueOf);
            }
        } catch (Exception e) {
            BdLog.e(e.getMessage());
        }
    }

    public long oe(String str) {
        long longValue;
        try {
            synchronized (this) {
                longValue = this.esa.get(str) != null ? this.esa.get(str).longValue() : 0L;
            }
            return longValue;
        } catch (Exception e) {
            BdLog.e(e.getMessage());
            return 0L;
        }
    }

    public void bJ(String str, String str2) {
        String key;
        try {
            Long valueOf = Long.valueOf(Long.parseLong(str2));
            synchronized (this) {
                Iterator<Map.Entry<String, Long>> it = this.esa.entrySet().iterator();
                if (it.hasNext() && (key = it.next().getKey()) != null && key.equals(str)) {
                    this.esa.remove(key);
                }
                this.esa.put(str, valueOf);
            }
        } catch (Exception e) {
            BdLog.e(e.getMessage());
        }
    }

    @Override // com.baidu.tieba.tbadkCore.util.s
    public void aUw() {
        synchronized (this) {
            this.esd.clear();
            this.esa.clear();
        }
    }
}
