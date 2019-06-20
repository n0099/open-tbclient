package com.baidu.tieba.video;

import android.content.Context;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.util.j;
import com.baidu.adp.lib.util.l;
import com.baidu.tieba.R;
import com.baidu.tieba.model.VideoHolyCardModel;
/* loaded from: classes.dex */
public class g {
    private static g jnW;
    private VideoHolyCardModel.a hpd = new VideoHolyCardModel.a() { // from class: com.baidu.tieba.video.g.2
        @Override // com.baidu.tieba.model.VideoHolyCardModel.a
        public void bB(boolean z) {
            g.this.jnY = z;
        }
    };
    private VideoHolyCardModel jnX;
    private boolean jnY;
    private boolean jnZ;

    public static g cqT() {
        if (jnW == null) {
            synchronized (g.class) {
                if (jnW == null) {
                    jnW = new g();
                }
            }
        }
        return jnW;
    }

    public boolean cqU() {
        return this.jnY;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cqV() {
        if (this.jnX == null) {
            this.jnX = new VideoHolyCardModel();
            this.jnX.a(this.hpd);
        }
        this.jnX.bLO();
    }

    public void en(Context context) {
        if (this.jnY && !this.jnZ) {
            l.showToast(context, (int) R.string.free_data_tips);
            this.jnZ = true;
        }
    }

    private g() {
        cqW();
        cqV();
    }

    private void cqW() {
        MessageManager.getInstance().registerListener(new CustomMessageListener(2000994) { // from class: com.baidu.tieba.video.g.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (j.jU()) {
                    g.this.cqV();
                }
            }
        });
    }
}
