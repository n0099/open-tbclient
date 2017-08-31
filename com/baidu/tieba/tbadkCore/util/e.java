package com.baidu.tieba.tbadkCore.util;

import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
/* loaded from: classes.dex */
public class e extends f {
    private volatile HashMap<String, Long> gkI;

    static {
        MessageManager.getInstance().registerListener(new CustomMessageListener(CmdConfigCustom.METHOD_ACCOUNT_CHANGE) { // from class: com.baidu.tieba.tbadkCore.util.e.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (TbadkCoreApplication.getInst().getPhotoLiveReadThreadHistory() != null) {
                    TbadkCoreApplication.getInst().getPhotoLiveReadThreadHistory().btj();
                }
            }
        });
    }

    public e(int i) {
        super(i);
        this.gkI = new HashMap<>();
    }

    public void cm(String str, String str2) {
        try {
            Long valueOf = Long.valueOf(Long.parseLong(str2));
            synchronized (this) {
                if (this.gkI.size() >= this.gkK) {
                    bcn();
                }
                this.gkI.put(str, valueOf);
            }
        } catch (Exception e) {
            BdLog.e(e.getMessage());
        }
    }

    public long sl(String str) {
        long longValue;
        try {
            synchronized (this) {
                longValue = this.gkI.get(str) != null ? this.gkI.get(str).longValue() : 0L;
            }
            return longValue;
        } catch (Exception e) {
            BdLog.e(e.getMessage());
            return 0L;
        }
    }

    public void cn(String str, String str2) {
        String key;
        try {
            Long valueOf = Long.valueOf(Long.parseLong(str2));
            synchronized (this) {
                Iterator<Map.Entry<String, Long>> it = this.gkI.entrySet().iterator();
                if (it.hasNext() && (key = it.next().getKey()) != null && key.equals(str)) {
                    this.gkI.remove(key);
                }
                this.gkI.put(str, valueOf);
            }
        } catch (Exception e) {
            BdLog.e(e.getMessage());
        }
    }

    @Override // com.baidu.tieba.tbadkCore.util.f
    public void btj() {
        synchronized (this) {
            this.gkL.clear();
            this.gkI.clear();
        }
    }
}
