package com.baidu.tieba.video;

import android.content.Context;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.util.j;
import com.baidu.adp.lib.util.l;
import com.baidu.tieba.d;
import com.baidu.tieba.model.VideoHolyCardModel;
/* loaded from: classes.dex */
public class g {
    private static g hch;
    private VideoHolyCardModel.a fgS = new VideoHolyCardModel.a() { // from class: com.baidu.tieba.video.g.2
        @Override // com.baidu.tieba.model.VideoHolyCardModel.a
        public void al(boolean z) {
            g.this.hcj = z;
        }
    };
    private VideoHolyCardModel hci;
    private boolean hcj;
    private boolean hck;

    public static g bAi() {
        if (hch == null) {
            synchronized (g.class) {
                if (hch == null) {
                    hch = new g();
                }
            }
        }
        return hch;
    }

    public boolean bAj() {
        return this.hcj;
    }

    public void bAk() {
        if (j.jG()) {
            if (this.hci == null) {
                this.hci = new VideoHolyCardModel();
                this.hci.a(this.fgS);
            }
            this.hci.aVB();
        }
    }

    public void cl(Context context) {
        if (this.hcj && !this.hck) {
            l.showToast(context, d.j.free_data_tips);
            this.hck = true;
        }
    }

    private g() {
        bAl();
    }

    private void bAl() {
        MessageManager.getInstance().registerListener(new CustomMessageListener(2000994) { // from class: com.baidu.tieba.video.g.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                g.this.bAk();
            }
        });
    }
}
