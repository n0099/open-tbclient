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
    private static h lUU;
    private VideoHolyCardModel.a jJa = new VideoHolyCardModel.a() { // from class: com.baidu.tieba.video.h.2
        @Override // com.baidu.tieba.model.VideoHolyCardModel.a
        public void onResult(boolean z) {
            h.this.lUW = z;
        }
    };
    private VideoHolyCardModel lUV;
    private boolean lUW;
    private boolean lUX;

    public static h dmk() {
        if (lUU == null) {
            synchronized (h.class) {
                if (lUU == null) {
                    lUU = new h();
                }
            }
        }
        return lUU;
    }

    public boolean dml() {
        return this.lUW;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dmm() {
        if (this.lUV == null) {
            this.lUV = new VideoHolyCardModel();
            this.lUV.a(this.jJa);
        }
        this.lUV.cCn();
    }

    public void fs(Context context) {
        if (this.lUW && !this.lUX) {
            l.showToast(context, (int) R.string.free_data_tips);
            this.lUX = true;
        }
    }

    private h() {
        dmn();
        dmm();
    }

    private void dmn() {
        MessageManager.getInstance().registerListener(new CustomMessageListener(MessageConfig.CMD_NETWORK_CHANGED) { // from class: com.baidu.tieba.video.h.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (com.baidu.adp.lib.util.j.isMobileNet()) {
                    h.this.dmm();
                }
            }
        });
    }
}
