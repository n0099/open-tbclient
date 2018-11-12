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
    private static g hta;
    private VideoHolyCardModel.a fxf = new VideoHolyCardModel.a() { // from class: com.baidu.tieba.video.g.2
        @Override // com.baidu.tieba.model.VideoHolyCardModel.a
        public void onResult(boolean z) {
            g.this.htc = z;
        }
    };
    private VideoHolyCardModel htb;
    private boolean htc;
    private boolean htd;

    public static g bFM() {
        if (hta == null) {
            synchronized (g.class) {
                if (hta == null) {
                    hta = new g();
                }
            }
        }
        return hta;
    }

    public boolean bFN() {
        return this.htc;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bFO() {
        if (this.htb == null) {
            this.htb = new VideoHolyCardModel();
            this.htb.a(this.fxf);
        }
        this.htb.bav();
    }

    public void cY(Context context) {
        if (this.htc && !this.htd) {
            l.showToast(context, e.j.free_data_tips);
            this.htd = true;
        }
    }

    private g() {
        bFP();
        bFO();
    }

    private void bFP() {
        MessageManager.getInstance().registerListener(new CustomMessageListener(2000994) { // from class: com.baidu.tieba.video.g.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (j.kX()) {
                    g.this.bFO();
                }
            }
        });
    }
}
