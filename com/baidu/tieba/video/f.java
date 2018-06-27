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
    private static f haU;
    private VideoHolyCardModel.a fgK = new VideoHolyCardModel.a() { // from class: com.baidu.tieba.video.f.2
        @Override // com.baidu.tieba.model.VideoHolyCardModel.a
        public void ap(boolean z) {
            f.this.haW = z;
        }
    };
    private VideoHolyCardModel haV;
    private boolean haW;
    private boolean haX;

    public static f bBB() {
        if (haU == null) {
            synchronized (f.class) {
                if (haU == null) {
                    haU = new f();
                }
            }
        }
        return haU;
    }

    public boolean bBC() {
        return this.haW;
    }

    public void bBD() {
        if (j.jF()) {
            if (this.haV == null) {
                this.haV = new VideoHolyCardModel();
                this.haV.a(this.fgK);
            }
            this.haV.aXi();
        }
    }

    public void ck(Context context) {
        if (this.haW && !this.haX) {
            l.showToast(context, d.k.free_data_tips);
            this.haX = true;
        }
    }

    private f() {
        bBE();
    }

    private void bBE() {
        MessageManager.getInstance().registerListener(new CustomMessageListener(2000994) { // from class: com.baidu.tieba.video.f.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                f.this.bBD();
            }
        });
    }
}
