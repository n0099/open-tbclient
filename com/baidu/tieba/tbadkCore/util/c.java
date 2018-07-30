package com.baidu.tieba.tbadkCore.util;

import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.core.TbadkCoreApplication;
import java.util.HashMap;
/* loaded from: classes.dex */
public class c extends d {
    private volatile HashMap<String, Long> gQA;

    static {
        MessageManager.getInstance().registerListener(new CustomMessageListener(2005016) { // from class: com.baidu.tieba.tbadkCore.util.c.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (TbadkCoreApplication.getInst().getPhotoLiveReadThreadHistory() != null) {
                    TbadkCoreApplication.getInst().getPhotoLiveReadThreadHistory().bxd();
                }
            }
        });
    }

    public c(int i) {
        super(i);
        this.gQA = new HashMap<>();
    }

    public long tW(String str) {
        long longValue;
        try {
            synchronized (this) {
                longValue = this.gQA.get(str) != null ? this.gQA.get(str).longValue() : 0L;
            }
            return longValue;
        } catch (Exception e) {
            BdLog.e(e.getMessage());
            return 0L;
        }
    }

    @Override // com.baidu.tieba.tbadkCore.util.d
    public void bxd() {
        synchronized (this) {
            this.gQC.clear();
            this.gQA.clear();
        }
    }
}
