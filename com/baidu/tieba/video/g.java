package com.baidu.tieba.video;

import android.content.Context;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.util.j;
import com.baidu.adp.lib.util.l;
import com.baidu.tieba.e;
import com.baidu.tieba.model.VideoHolyCardModel;
/* loaded from: classes.dex */
public class g {
    private static g hka;
    private VideoHolyCardModel.a foj = new VideoHolyCardModel.a() { // from class: com.baidu.tieba.video.g.2
        @Override // com.baidu.tieba.model.VideoHolyCardModel.a
        public void av(boolean z) {
            g.this.hkc = z;
        }
    };
    private VideoHolyCardModel hkb;
    private boolean hkc;
    private boolean hkd;

    public static g bCZ() {
        if (hka == null) {
            synchronized (g.class) {
                if (hka == null) {
                    hka = new g();
                }
            }
        }
        return hka;
    }

    public boolean bDa() {
        return this.hkc;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bDb() {
        if (this.hkb == null) {
            this.hkb = new VideoHolyCardModel();
            this.hkb.a(this.foj);
        }
        this.hkb.aXL();
    }

    public void cR(Context context) {
        if (this.hkc && !this.hkd) {
            l.showToast(context, e.j.free_data_tips);
            this.hkd = true;
        }
    }

    private g() {
        bDc();
        bDb();
    }

    private void bDc() {
        MessageManager.getInstance().registerListener(new CustomMessageListener(2000994) { // from class: com.baidu.tieba.video.g.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (j.kM()) {
                    g.this.bDb();
                }
            }
        });
    }
}
