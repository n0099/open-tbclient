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
    private static g hEF;
    private VideoHolyCardModel.a fHI = new VideoHolyCardModel.a() { // from class: com.baidu.tieba.video.g.2
        @Override // com.baidu.tieba.model.VideoHolyCardModel.a
        public void onResult(boolean z) {
            g.this.hEH = z;
        }
    };
    private VideoHolyCardModel hEG;
    private boolean hEH;
    private boolean hEI;

    public static g bJp() {
        if (hEF == null) {
            synchronized (g.class) {
                if (hEF == null) {
                    hEF = new g();
                }
            }
        }
        return hEF;
    }

    public boolean bJq() {
        return this.hEH;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bJr() {
        if (this.hEG == null) {
            this.hEG = new VideoHolyCardModel();
            this.hEG.a(this.fHI);
        }
        this.hEG.bdz();
    }

    public void dc(Context context) {
        if (this.hEH && !this.hEI) {
            l.showToast(context, e.j.free_data_tips);
            this.hEI = true;
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
