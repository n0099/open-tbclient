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
    private static f gWP;
    private VideoHolyCardModel.a fcT = new VideoHolyCardModel.a() { // from class: com.baidu.tieba.video.f.2
        @Override // com.baidu.tieba.model.VideoHolyCardModel.a
        public void ap(boolean z) {
            f.this.gWR = z;
        }
    };
    private VideoHolyCardModel gWQ;
    private boolean gWR;
    private boolean gWS;

    public static f bBb() {
        if (gWP == null) {
            synchronized (f.class) {
                if (gWP == null) {
                    gWP = new f();
                }
            }
        }
        return gWP;
    }

    public boolean bBc() {
        return this.gWR;
    }

    public void bBd() {
        if (j.jF()) {
            if (this.gWQ == null) {
                this.gWQ = new VideoHolyCardModel();
                this.gWQ.a(this.fcT);
            }
            this.gWQ.aWB();
        }
    }

    public void cm(Context context) {
        if (this.gWR && !this.gWS) {
            l.showToast(context, d.k.free_data_tips);
            this.gWS = true;
        }
    }

    private f() {
        bBe();
    }

    private void bBe() {
        MessageManager.getInstance().registerListener(new CustomMessageListener(2000994) { // from class: com.baidu.tieba.video.f.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                f.this.bBd();
            }
        });
    }
}
