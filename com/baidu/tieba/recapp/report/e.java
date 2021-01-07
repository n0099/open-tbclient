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
    private static e mSF;
    private CustomMessageListener mSH = new CustomMessageListener(MessageConfig.CMD_NETWORK_CHANGED) { // from class: com.baidu.tieba.recapp.report.e.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2000994 && j.isNetWorkAvailable() && e.this.mSG != null) {
                e.this.mSG.dFY();
            }
        }
    };
    private f mSG = new i();

    public static e dFW() {
        if (mSF == null) {
            synchronized (e.class) {
                if (mSF == null) {
                    mSF = new e();
                }
            }
        }
        return mSF;
    }

    private boolean dFX() {
        return SwitchManager.getInstance().findType(AdUploadSwitch.KEY) != 0;
    }

    private e() {
        MessageManager.getInstance().registerListener(this.mSH);
    }

    public void a(c cVar) {
        if (dFX() && cVar != null && this.mSG != null) {
            if (j.isNetWorkAvailable()) {
                this.mSG.b(cVar);
            } else {
                this.mSG.c(cVar);
            }
        }
    }
}
