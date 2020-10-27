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
    private static d msJ;
    private CustomMessageListener msL = new CustomMessageListener(MessageConfig.CMD_NETWORK_CHANGED) { // from class: com.baidu.tieba.recapp.report.d.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2000994 && j.isNetWorkAvailable() && d.this.msK != null) {
                d.this.msK.dyP();
            }
        }
    };
    private e msK = new h();

    public static d dyN() {
        if (msJ == null) {
            synchronized (d.class) {
                if (msJ == null) {
                    msJ = new d();
                }
            }
        }
        return msJ;
    }

    private boolean dyO() {
        return SwitchManager.getInstance().findType(AdUploadSwitch.KEY) != 0;
    }

    private d() {
        MessageManager.getInstance().registerListener(this.msL);
    }

    public void a(c cVar) {
        if (dyO() && cVar != null && this.msK != null) {
            if (j.isNetWorkAvailable()) {
                this.msK.b(cVar);
            } else {
                this.msK.c(cVar);
            }
        }
    }
}
