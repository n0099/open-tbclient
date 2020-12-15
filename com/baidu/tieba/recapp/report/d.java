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
    private static d mNx;
    private CustomMessageListener mNz = new CustomMessageListener(MessageConfig.CMD_NETWORK_CHANGED) { // from class: com.baidu.tieba.recapp.report.d.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2000994 && j.isNetWorkAvailable() && d.this.mNy != null) {
                d.this.mNy.dGi();
            }
        }
    };
    private e mNy = new h();

    public static d dGg() {
        if (mNx == null) {
            synchronized (d.class) {
                if (mNx == null) {
                    mNx = new d();
                }
            }
        }
        return mNx;
    }

    private boolean dGh() {
        return SwitchManager.getInstance().findType(AdUploadSwitch.KEY) != 0;
    }

    private d() {
        MessageManager.getInstance().registerListener(this.mNz);
    }

    public void a(c cVar) {
        if (dGh() && cVar != null && this.mNy != null) {
            if (j.isNetWorkAvailable()) {
                this.mNy.b(cVar);
            } else {
                this.mNy.c(cVar);
            }
        }
    }
}
