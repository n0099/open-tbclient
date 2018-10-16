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
    private static g hrq;
    private VideoHolyCardModel.a fvP = new VideoHolyCardModel.a() { // from class: com.baidu.tieba.video.g.2
        @Override // com.baidu.tieba.model.VideoHolyCardModel.a
        public void onResult(boolean z) {
            g.this.hrs = z;
        }
    };
    private VideoHolyCardModel hrr;
    private boolean hrs;
    private boolean hrt;

    public static g bGn() {
        if (hrq == null) {
            synchronized (g.class) {
                if (hrq == null) {
                    hrq = new g();
                }
            }
        }
        return hrq;
    }

    public boolean bGo() {
        return this.hrs;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bGp() {
        if (this.hrr == null) {
            this.hrr = new VideoHolyCardModel();
            this.hrr.a(this.fvP);
        }
        this.hrr.baY();
    }

    public void dd(Context context) {
        if (this.hrs && !this.hrt) {
            l.showToast(context, e.j.free_data_tips);
            this.hrt = true;
        }
    }

    private g() {
        bGq();
        bGp();
    }

    private void bGq() {
        MessageManager.getInstance().registerListener(new CustomMessageListener(2000994) { // from class: com.baidu.tieba.video.g.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (j.kZ()) {
                    g.this.bGp();
                }
            }
        });
    }
}
