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
public class f {
    private static f nNq;
    private VideoHolyCardModel.a lwy = new VideoHolyCardModel.a() { // from class: com.baidu.tieba.video.f.2
        @Override // com.baidu.tieba.model.VideoHolyCardModel.a
        public void onResult(boolean z) {
            f.this.nNs = z;
        }
    };
    private VideoHolyCardModel nNr;
    private boolean nNs;
    private boolean nNt;

    public static f dSn() {
        if (nNq == null) {
            synchronized (f.class) {
                if (nNq == null) {
                    nNq = new f();
                }
            }
        }
        return nNq;
    }

    public boolean dSo() {
        return this.nNs;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dSp() {
        if (this.nNr == null) {
            this.nNr = new VideoHolyCardModel();
            this.nNr.a(this.lwy);
        }
        this.nNr.dgW();
    }

    public void gY(Context context) {
        if (this.nNs && !this.nNt) {
            l.showToast(context, R.string.free_data_tips);
            this.nNt = true;
        }
    }

    private f() {
        dSq();
        dSp();
    }

    private void dSq() {
        MessageManager.getInstance().registerListener(new CustomMessageListener(MessageConfig.CMD_NETWORK_CHANGED) { // from class: com.baidu.tieba.video.f.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (j.isMobileNet()) {
                    f.this.dSp();
                }
            }
        });
    }
}
