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
    private static g hEE;
    private VideoHolyCardModel.a fHH = new VideoHolyCardModel.a() { // from class: com.baidu.tieba.video.g.2
        @Override // com.baidu.tieba.model.VideoHolyCardModel.a
        public void onResult(boolean z) {
            g.this.hEG = z;
        }
    };
    private VideoHolyCardModel hEF;
    private boolean hEG;
    private boolean hEH;

    public static g bJp() {
        if (hEE == null) {
            synchronized (g.class) {
                if (hEE == null) {
                    hEE = new g();
                }
            }
        }
        return hEE;
    }

    public boolean bJq() {
        return this.hEG;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bJr() {
        if (this.hEF == null) {
            this.hEF = new VideoHolyCardModel();
            this.hEF.a(this.fHH);
        }
        this.hEF.bdz();
    }

    public void dc(Context context) {
        if (this.hEG && !this.hEH) {
            l.showToast(context, e.j.free_data_tips);
            this.hEH = true;
        }
    }

    private g() {
        bJs();
        bJr();
    }

    private void bJs() {
        MessageManager.getInstance().registerListener(new CustomMessageListener(2000994) { // from class: com.baidu.tieba.video.g.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (j.kX()) {
                    g.this.bJr();
                }
            }
        });
    }
}
