package com.baidu.tieba.tbadkCore.util;

import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.core.TbadkCoreApplication;
import java.util.HashMap;
/* loaded from: classes.dex */
public class c extends d {
    private volatile HashMap<String, Long> gLA;

    static {
        MessageManager.getInstance().registerListener(new CustomMessageListener(2005016) { // from class: com.baidu.tieba.tbadkCore.util.c.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (TbadkCoreApplication.getInst().getPhotoLiveReadThreadHistory() != null) {
                    TbadkCoreApplication.getInst().getPhotoLiveReadThreadHistory().bxW();
                }
            }
        });
    }

    public c(int i) {
        super(i);
        this.gLA = new HashMap<>();
    }

    public long tY(String str) {
        long longValue;
        try {
            synchronized (this) {
                longValue = this.gLA.get(str) != null ? this.gLA.get(str).longValue() : 0L;
            }
            return longValue;
        } catch (Exception e) {
            BdLog.e(e.getMessage());
            return 0L;
        }
    }

    @Override // com.baidu.tieba.tbadkCore.util.d
    public void bxW() {
        synchronized (this) {
            this.gLC.clear();
            this.gLA.clear();
        }
    }
}
