package com.baidu.tieba.video;

import android.content.Context;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.util.j;
import com.baidu.adp.lib.util.l;
import com.baidu.tieba.e;
import com.baidu.tieba.model.VideoHolyCardModel;
/* loaded from: classes.dex */
public class g {
    private static g hAm;
    private VideoHolyCardModel.a fDV = new VideoHolyCardModel.a() { // from class: com.baidu.tieba.video.g.2
        @Override // com.baidu.tieba.model.VideoHolyCardModel.a
        public void onResult(boolean z) {
            g.this.hAo = z;
        }
    };
    private VideoHolyCardModel hAn;
    private boolean hAo;
    private boolean hAp;

    public static g bHR() {
        if (hAm == null) {
            synchronized (g.class) {
                if (hAm == null) {
                    hAm = new g();
                }
            }
        }
        return hAm;
    }

    public boolean bHS() {
        return this.hAo;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bHT() {
        if (this.hAn == null) {
            this.hAn = new VideoHolyCardModel();
            this.hAn.a(this.fDV);
        }
        this.hAn.bcm();
    }

    public void dc(Context context) {
        if (this.hAo && !this.hAp) {
            l.showToast(context, e.j.free_data_tips);
            this.hAp = true;
        }
    }

    private g() {
        bHU();
        bHT();
    }

    private void bHU() {
        MessageManager.getInstance().registerListener(new CustomMessageListener(2000994) { // from class: com.baidu.tieba.video.g.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (j.kX()) {
                    g.this.bHT();
                }
            }
        });
    }
}
