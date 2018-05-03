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
    private static f gKk;
    private VideoHolyCardModel.a eQu = new VideoHolyCardModel.a() { // from class: com.baidu.tieba.video.f.2
        @Override // com.baidu.tieba.model.VideoHolyCardModel.a
        public void am(boolean z) {
            f.this.gKm = z;
        }
    };
    private VideoHolyCardModel gKl;
    private boolean gKm;
    private boolean gKn;

    public static f bvW() {
        if (gKk == null) {
            synchronized (f.class) {
                if (gKk == null) {
                    gKk = new f();
                }
            }
        }
        return gKk;
    }

    public boolean bvX() {
        return this.gKm;
    }

    public void bvY() {
        if (j.gR()) {
            if (this.gKl == null) {
                this.gKl = new VideoHolyCardModel();
                this.gKl.a(this.eQu);
            }
            this.gKl.aRE();
        }
    }

    public void cb(Context context) {
        if (this.gKm && !this.gKn) {
            l.showToast(context, d.k.free_data_tips);
            this.gKn = true;
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
