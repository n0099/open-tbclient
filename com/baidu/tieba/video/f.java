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
    private static f nBa;
    private VideoHolyCardModel.a lmb = new VideoHolyCardModel.a() { // from class: com.baidu.tieba.video.f.2
        @Override // com.baidu.tieba.model.VideoHolyCardModel.a
        public void onResult(boolean z) {
            f.this.nBc = z;
        }
    };
    private VideoHolyCardModel nBb;
    private boolean nBc;
    private boolean nBd;

    public static f dPM() {
        if (nBa == null) {
            synchronized (f.class) {
                if (nBa == null) {
                    nBa = new f();
                }
            }
        }
        return nBa;
    }

    public boolean dPN() {
        return this.nBc;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dPO() {
        if (this.nBb == null) {
            this.nBb = new VideoHolyCardModel();
            this.nBb.a(this.lmb);
        }
        this.nBb.deG();
    }

    public void gW(Context context) {
        if (this.nBc && !this.nBd) {
            l.showToast(context, R.string.free_data_tips);
            this.nBd = true;
        }
    }

    private f() {
        dPP();
        dPO();
    }

    private void dPP() {
        MessageManager.getInstance().registerListener(new CustomMessageListener(MessageConfig.CMD_NETWORK_CHANGED) { // from class: com.baidu.tieba.video.f.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (j.isMobileNet()) {
                    f.this.dPO();
                }
            }
        });
    }
}
