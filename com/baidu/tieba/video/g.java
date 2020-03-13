package com.baidu.tieba.video;

import android.content.Context;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.util.j;
import com.baidu.adp.lib.util.l;
import com.baidu.live.adp.framework.MessageConfig;
import com.baidu.tieba.R;
import com.baidu.tieba.model.VideoHolyCardModel;
/* loaded from: classes.dex */
public class g {
    private static g kvx;
    private VideoHolyCardModel.a ipU = new VideoHolyCardModel.a() { // from class: com.baidu.tieba.video.g.2
        @Override // com.baidu.tieba.model.VideoHolyCardModel.a
        public void onResult(boolean z) {
            g.this.kvz = z;
        }
    };
    private boolean kvA;
    private VideoHolyCardModel kvy;
    private boolean kvz;

    public static g cPi() {
        if (kvx == null) {
            synchronized (g.class) {
                if (kvx == null) {
                    kvx = new g();
                }
            }
        }
        return kvx;
    }

    public boolean cPj() {
        return this.kvz;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cPk() {
        if (this.kvy == null) {
            this.kvy = new VideoHolyCardModel();
            this.kvy.a(this.ipU);
        }
        this.kvy.cgx();
    }

    public void fy(Context context) {
        if (this.kvz && !this.kvA) {
            l.showToast(context, (int) R.string.free_data_tips);
            this.kvA = true;
        }
    }

    private g() {
        cPl();
        cPk();
    }

    private void cPl() {
        MessageManager.getInstance().registerListener(new CustomMessageListener(MessageConfig.CMD_NETWORK_CHANGED) { // from class: com.baidu.tieba.video.g.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (j.isMobileNet()) {
                    g.this.cPk();
                }
            }
        });
    }
}
