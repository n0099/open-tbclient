package com.baidu.tieba.video;

import android.content.Context;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.util.j;
import com.baidu.adp.lib.util.l;
import com.baidu.tieba.f;
import com.baidu.tieba.model.VideoHolyCardModel;
/* loaded from: classes.dex */
public class g {
    private static g hci;
    private VideoHolyCardModel.a fgM = new VideoHolyCardModel.a() { // from class: com.baidu.tieba.video.g.2
        @Override // com.baidu.tieba.model.VideoHolyCardModel.a
        public void am(boolean z) {
            g.this.hck = z;
        }
    };
    private VideoHolyCardModel hcj;
    private boolean hck;
    private boolean hcl;

    public static g bAk() {
        if (hci == null) {
            synchronized (g.class) {
                if (hci == null) {
                    hci = new g();
                }
            }
        }
        return hci;
    }

    public boolean bAl() {
        return this.hck;
    }

    public void bAm() {
        if (j.jG()) {
            if (this.hcj == null) {
                this.hcj = new VideoHolyCardModel();
                this.hcj.a(this.fgM);
            }
            this.hcj.aVx();
        }
    }

    public void ck(Context context) {
        if (this.hck && !this.hcl) {
            l.showToast(context, f.j.free_data_tips);
            this.hcl = true;
        }
    }

    private g() {
        bAn();
    }

    private void bAn() {
        MessageManager.getInstance().registerListener(new CustomMessageListener(2000994) { // from class: com.baidu.tieba.video.g.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                g.this.bAm();
            }
        });
    }
}
