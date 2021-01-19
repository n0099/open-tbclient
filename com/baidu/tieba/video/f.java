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
    private static f nBb;
    private VideoHolyCardModel.a lmb = new VideoHolyCardModel.a() { // from class: com.baidu.tieba.video.f.2
        @Override // com.baidu.tieba.model.VideoHolyCardModel.a
        public void onResult(boolean z) {
            f.this.nBd = z;
        }
    };
    private VideoHolyCardModel nBc;
    private boolean nBd;
    private boolean nBe;

    public static f dPM() {
        if (nBb == null) {
            synchronized (f.class) {
                if (nBb == null) {
                    nBb = new f();
                }
            }
        }
        return nBb;
    }

    public boolean dPN() {
        return this.nBd;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dPO() {
        if (this.nBc == null) {
            this.nBc = new VideoHolyCardModel();
            this.nBc.a(this.lmb);
        }
        this.nBc.deG();
    }

    public void gW(Context context) {
        if (this.nBd && !this.nBe) {
            l.showToast(context, R.string.free_data_tips);
            this.nBe = true;
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
