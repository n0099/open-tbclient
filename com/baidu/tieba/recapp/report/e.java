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
    private static e mXn;
    private CustomMessageListener mXp = new CustomMessageListener(MessageConfig.CMD_NETWORK_CHANGED) { // from class: com.baidu.tieba.recapp.report.e.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2000994 && j.isNetWorkAvailable() && e.this.mXo != null) {
                e.this.mXo.dEo();
            }
        }
    };
    private f mXo = new i();

    public static e dEm() {
        if (mXn == null) {
            synchronized (e.class) {
                if (mXn == null) {
                    mXn = new e();
                }
            }
        }
        return mXn;
    }

    private boolean dEn() {
        return SwitchManager.getInstance().findType(AdUploadSwitch.KEY) != 0;
    }

    private e() {
        MessageManager.getInstance().registerListener(this.mXp);
    }

    public void a(c cVar) {
        if (dEn() && this.mXo != null) {
            if (j.isNetWorkAvailable()) {
                this.mXo.b(cVar);
            } else {
                this.mXo.c(cVar);
            }
        }
    }
}
