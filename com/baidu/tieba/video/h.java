package com.baidu.tieba.video;

import android.content.Context;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.util.l;
import com.baidu.live.adp.framework.MessageConfig;
import com.baidu.tieba.R;
import com.baidu.tieba.model.VideoHolyCardModel;
/* loaded from: classes.dex */
public class h {
    private static h lUX;
    private VideoHolyCardModel.a jJa = new VideoHolyCardModel.a() { // from class: com.baidu.tieba.video.h.2
        @Override // com.baidu.tieba.model.VideoHolyCardModel.a
        public void onResult(boolean z) {
            h.this.lUZ = z;
        }
    };
    private VideoHolyCardModel lUY;
    private boolean lUZ;
    private boolean lVa;

    public static h dmo() {
        if (lUX == null) {
            synchronized (h.class) {
                if (lUX == null) {
                    lUX = new h();
                }
            }
        }
        return lUX;
    }

    public boolean dmp() {
        return this.lUZ;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dmq() {
        if (this.lUY == null) {
            this.lUY = new VideoHolyCardModel();
            this.lUY.a(this.jJa);
        }
        this.lUY.cCo();
    }

    public void fs(Context context) {
        if (this.lUZ && !this.lVa) {
            l.showToast(context, (int) R.string.free_data_tips);
            this.lVa = true;
        }
    }

    private h() {
        dmr();
        dmq();
    }

    private void dmr() {
        MessageManager.getInstance().registerListener(new CustomMessageListener(MessageConfig.CMD_NETWORK_CHANGED) { // from class: com.baidu.tieba.video.h.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (com.baidu.adp.lib.util.j.isMobileNet()) {
                    h.this.dmq();
                }
            }
        });
    }
}
