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
    private static f gKn;
    private VideoHolyCardModel.a eQx = new VideoHolyCardModel.a() { // from class: com.baidu.tieba.video.f.2
        @Override // com.baidu.tieba.model.VideoHolyCardModel.a
        public void am(boolean z) {
            f.this.gKp = z;
        }
    };
    private VideoHolyCardModel gKo;
    private boolean gKp;
    private boolean gKq;

    public static f bvW() {
        if (gKn == null) {
            synchronized (f.class) {
                if (gKn == null) {
                    gKn = new f();
                }
            }
        }
        return gKn;
    }

    public boolean bvX() {
        return this.gKp;
    }

    public void bvY() {
        if (j.gR()) {
            if (this.gKo == null) {
                this.gKo = new VideoHolyCardModel();
                this.gKo.a(this.eQx);
            }
            this.gKo.aRE();
        }
    }

    public void cb(Context context) {
        if (this.gKp && !this.gKq) {
            l.showToast(context, d.k.free_data_tips);
            this.gKq = true;
        }
    }

    private f() {
        bvZ();
    }

    private void bvZ() {
        MessageManager.getInstance().registerListener(new CustomMessageListener(2000994) { // from class: com.baidu.tieba.video.f.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                f.this.bvY();
            }
        });
    }
}
