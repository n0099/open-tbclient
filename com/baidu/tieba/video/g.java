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
    private static g jnS;
    private VideoHolyCardModel.a hpc = new VideoHolyCardModel.a() { // from class: com.baidu.tieba.video.g.2
        @Override // com.baidu.tieba.model.VideoHolyCardModel.a
        public void bB(boolean z) {
            g.this.jnU = z;
        }
    };
    private VideoHolyCardModel jnT;
    private boolean jnU;
    private boolean jnV;

    public static g cqS() {
        if (jnS == null) {
            synchronized (g.class) {
                if (jnS == null) {
                    jnS = new g();
                }
            }
        }
        return jnS;
    }

    public boolean cqT() {
        return this.jnU;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cqU() {
        if (this.jnT == null) {
            this.jnT = new VideoHolyCardModel();
            this.jnT.a(this.hpc);
        }
        this.jnT.bLN();
    }

    public void en(Context context) {
        if (this.jnU && !this.jnV) {
            l.showToast(context, (int) R.string.free_data_tips);
            this.jnV = true;
        }
    }

    private g() {
        cqV();
        cqU();
    }

    private void cqV() {
        MessageManager.getInstance().registerListener(new CustomMessageListener(2000994) { // from class: com.baidu.tieba.video.g.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (j.jU()) {
                    g.this.cqU();
                }
            }
        });
    }
}
