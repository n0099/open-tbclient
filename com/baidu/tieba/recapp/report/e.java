package com.baidu.tieba.recapp.report;

import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.featureSwitch.SwitchManager;
import com.baidu.adp.lib.util.j;
import com.baidu.live.adp.framework.MessageConfig;
import com.baidu.tbadk.switchs.AdUploadSwitch;
/* loaded from: classes.dex */
public class e {
    private static e mXN;
    private CustomMessageListener mXP = new CustomMessageListener(MessageConfig.CMD_NETWORK_CHANGED) { // from class: com.baidu.tieba.recapp.report.e.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2000994 && j.isNetWorkAvailable() && e.this.mXO != null) {
                e.this.mXO.dEw();
            }
        }
    };
    private f mXO = new i();

    public static e dEu() {
        if (mXN == null) {
            synchronized (e.class) {
                if (mXN == null) {
                    mXN = new e();
                }
            }
        }
        return mXN;
    }

    private boolean dEv() {
        return SwitchManager.getInstance().findType(AdUploadSwitch.KEY) != 0;
    }

    private e() {
        MessageManager.getInstance().registerListener(this.mXP);
    }

    public void a(c cVar) {
        if (dEv() && this.mXO != null) {
            if (j.isNetWorkAvailable()) {
                this.mXO.b(cVar);
            } else {
                this.mXO.c(cVar);
            }
        }
    }
}
