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
    private static g jnR;
    private VideoHolyCardModel.a hoZ = new VideoHolyCardModel.a() { // from class: com.baidu.tieba.video.g.2
        @Override // com.baidu.tieba.model.VideoHolyCardModel.a
        public void bB(boolean z) {
            g.this.jnT = z;
        }
    };
    private VideoHolyCardModel jnS;
    private boolean jnT;
    private boolean jnU;

    public static g cqQ() {
        if (jnR == null) {
            synchronized (g.class) {
                if (jnR == null) {
                    jnR = new g();
                }
            }
        }
        return jnR;
    }

    public boolean cqR() {
        return this.jnT;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cqS() {
        if (this.jnS == null) {
            this.jnS = new VideoHolyCardModel();
            this.jnS.a(this.hoZ);
        }
        this.jnS.bLK();
    }

    public void en(Context context) {
        if (this.jnT && !this.jnU) {
            l.showToast(context, (int) R.string.free_data_tips);
            this.jnU = true;
        }
    }

    private g() {
        cqT();
        cqS();
    }

    private void cqT() {
        MessageManager.getInstance().registerListener(new CustomMessageListener(2000994) { // from class: com.baidu.tieba.video.g.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (j.jU()) {
                    g.this.cqS();
                }
            }
        });
    }
}
