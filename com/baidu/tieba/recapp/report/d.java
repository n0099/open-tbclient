package com.baidu.tieba.recapp.report;

import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.featureSwitch.SwitchManager;
import com.baidu.adp.lib.util.j;
import com.baidu.live.adp.framework.MessageConfig;
import com.baidu.tbadk.switchs.AdUploadSwitch;
/* loaded from: classes.dex */
public class d {
    private static d lQS;
    private CustomMessageListener lQU = new CustomMessageListener(MessageConfig.CMD_NETWORK_CHANGED) { // from class: com.baidu.tieba.recapp.report.d.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2000994 && j.isNetWorkAvailable() && d.this.lQT != null) {
                d.this.lQT.drX();
            }
        }
    };
    private e lQT = new h();

    public static d drV() {
        if (lQS == null) {
            synchronized (d.class) {
                if (lQS == null) {
                    lQS = new d();
                }
            }
        }
        return lQS;
    }

    private boolean drW() {
        return SwitchManager.getInstance().findType(AdUploadSwitch.KEY) != 0;
    }

    private d() {
        MessageManager.getInstance().registerListener(this.lQU);
    }

    public void a(c cVar) {
        if (drW() && cVar != null && this.lQT != null) {
            if (j.isNetWorkAvailable()) {
                this.lQT.b(cVar);
            } else {
                this.lQT.c(cVar);
            }
        }
    }
}
