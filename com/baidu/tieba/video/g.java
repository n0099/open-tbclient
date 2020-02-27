package com.baidu.tieba.video;

import android.content.Context;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.util.j;
import com.baidu.adp.lib.util.l;
import com.baidu.live.adp.framework.MessageConfig;
import com.baidu.tieba.R;
import com.baidu.tieba.model.VideoHolyCardModel;
/* loaded from: classes.dex */
public class g {
    private static g kvj;
    private VideoHolyCardModel.a ipG = new VideoHolyCardModel.a() { // from class: com.baidu.tieba.video.g.2
        @Override // com.baidu.tieba.model.VideoHolyCardModel.a
        public void onResult(boolean z) {
            g.this.kvl = z;
        }
    };
    private VideoHolyCardModel kvk;
    private boolean kvl;
    private boolean kvm;

    public static g cPf() {
        if (kvj == null) {
            synchronized (g.class) {
                if (kvj == null) {
                    kvj = new g();
                }
            }
        }
        return kvj;
    }

    public boolean cPg() {
        return this.kvl;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cPh() {
        if (this.kvk == null) {
            this.kvk = new VideoHolyCardModel();
            this.kvk.a(this.ipG);
        }
        this.kvk.cgu();
    }

    public void fy(Context context) {
        if (this.kvl && !this.kvm) {
            l.showToast(context, (int) R.string.free_data_tips);
            this.kvm = true;
        }
    }

    private g() {
        cPi();
        cPh();
    }

    private void cPi() {
        MessageManager.getInstance().registerListener(new CustomMessageListener(MessageConfig.CMD_NETWORK_CHANGED) { // from class: com.baidu.tieba.video.g.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (j.isMobileNet()) {
                    g.this.cPh();
                }
            }
        });
    }
}
