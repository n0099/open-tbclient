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
    private static g nmn;
    private VideoHolyCardModel.a kXo = new VideoHolyCardModel.a() { // from class: com.baidu.tieba.video.g.2
        @Override // com.baidu.tieba.model.VideoHolyCardModel.a
        public void onResult(boolean z) {
            g.this.nmp = z;
        }
    };
    private VideoHolyCardModel nmo;
    private boolean nmp;
    private boolean nmq;

    public static g dOu() {
        if (nmn == null) {
            synchronized (g.class) {
                if (nmn == null) {
                    nmn = new g();
                }
            }
        }
        return nmn;
    }

    public boolean dOv() {
        return this.nmp;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dOw() {
        if (this.nmo == null) {
            this.nmo = new VideoHolyCardModel();
            this.nmo.a(this.kXo);
        }
        this.nmo.dea();
    }

    public void fW(Context context) {
        if (this.nmp && !this.nmq) {
            l.showToast(context, R.string.free_data_tips);
            this.nmq = true;
        }
    }

    private g() {
        dOx();
        dOw();
    }

    private void dOx() {
        MessageManager.getInstance().registerListener(new CustomMessageListener(MessageConfig.CMD_NETWORK_CHANGED) { // from class: com.baidu.tieba.video.g.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (j.isMobileNet()) {
                    g.this.dOw();
                }
            }
        });
    }
}
