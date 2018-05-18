package com.baidu.tieba.video;

import android.content.Context;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.util.j;
import com.baidu.adp.lib.util.l;
import com.baidu.tieba.d;
import com.baidu.tieba.model.VideoHolyCardModel;
/* loaded from: classes.dex */
public class f {
    private static f gLn;
    private VideoHolyCardModel.a eRB = new VideoHolyCardModel.a() { // from class: com.baidu.tieba.video.f.2
        @Override // com.baidu.tieba.model.VideoHolyCardModel.a
        public void am(boolean z) {
            f.this.gLp = z;
        }
    };
    private VideoHolyCardModel gLo;
    private boolean gLp;
    private boolean gLq;

    public static f bvU() {
        if (gLn == null) {
            synchronized (f.class) {
                if (gLn == null) {
                    gLn = new f();
                }
            }
        }
        return gLn;
    }

    public boolean bvV() {
        return this.gLp;
    }

    public void bvW() {
        if (j.gR()) {
            if (this.gLo == null) {
                this.gLo = new VideoHolyCardModel();
                this.gLo.a(this.eRB);
            }
            this.gLo.aRE();
        }
    }

    public void cb(Context context) {
        if (this.gLp && !this.gLq) {
            l.showToast(context, d.k.free_data_tips);
            this.gLq = true;
        }
    }

    private f() {
        bvX();
    }

    private void bvX() {
        MessageManager.getInstance().registerListener(new CustomMessageListener(2000994) { // from class: com.baidu.tieba.video.f.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                f.this.bvW();
            }
        });
    }
}
