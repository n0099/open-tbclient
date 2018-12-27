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
    private static g hDx;
    private VideoHolyCardModel.a fGN = new VideoHolyCardModel.a() { // from class: com.baidu.tieba.video.g.2
        @Override // com.baidu.tieba.model.VideoHolyCardModel.a
        public void onResult(boolean z) {
            g.this.hDz = z;
        }
    };
    private boolean hDA;
    private VideoHolyCardModel hDy;
    private boolean hDz;

    public static g bIG() {
        if (hDx == null) {
            synchronized (g.class) {
                if (hDx == null) {
                    hDx = new g();
                }
            }
        }
        return hDx;
    }

    public boolean bIH() {
        return this.hDz;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bII() {
        if (this.hDy == null) {
            this.hDy = new VideoHolyCardModel();
            this.hDy.a(this.fGN);
        }
        this.hDy.bcZ();
    }

    public void dc(Context context) {
        if (this.hDz && !this.hDA) {
            l.showToast(context, e.j.free_data_tips);
            this.hDA = true;
        }
    }

    private g() {
        bIJ();
        bII();
    }

    private void bIJ() {
        MessageManager.getInstance().registerListener(new CustomMessageListener(2000994) { // from class: com.baidu.tieba.video.g.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (j.kX()) {
                    g.this.bII();
                }
            }
        });
    }
}
