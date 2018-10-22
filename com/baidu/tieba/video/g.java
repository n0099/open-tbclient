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
    private static g hrr;
    private VideoHolyCardModel.a fvQ = new VideoHolyCardModel.a() { // from class: com.baidu.tieba.video.g.2
        @Override // com.baidu.tieba.model.VideoHolyCardModel.a
        public void onResult(boolean z) {
            g.this.hrt = z;
        }
    };
    private VideoHolyCardModel hrs;
    private boolean hrt;
    private boolean hru;

    public static g bGn() {
        if (hrr == null) {
            synchronized (g.class) {
                if (hrr == null) {
                    hrr = new g();
                }
            }
        }
        return hrr;
    }

    public boolean bGo() {
        return this.hrt;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bGp() {
        if (this.hrs == null) {
            this.hrs = new VideoHolyCardModel();
            this.hrs.a(this.fvQ);
        }
        this.hrs.baY();
    }

    public void dd(Context context) {
        if (this.hrt && !this.hru) {
            l.showToast(context, e.j.free_data_tips);
            this.hru = true;
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
