package com.baidu.tieba.video;

import android.content.Context;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.util.j;
import com.baidu.adp.lib.util.l;
import com.baidu.tieba.R;
import com.baidu.tieba.model.VideoHolyCardModel;
/* loaded from: classes.dex */
public class g {
    private static g jxG;
    private VideoHolyCardModel.a hyb = new VideoHolyCardModel.a() { // from class: com.baidu.tieba.video.g.2
        @Override // com.baidu.tieba.model.VideoHolyCardModel.a
        public void bE(boolean z) {
            g.this.jxI = z;
        }
    };
    private VideoHolyCardModel jxH;
    private boolean jxI;
    private boolean jxJ;

    public static g cuO() {
        if (jxG == null) {
            synchronized (g.class) {
                if (jxG == null) {
                    jxG = new g();
                }
            }
        }
        return jxG;
    }

    public boolean cuP() {
        return this.jxI;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cuQ() {
        if (this.jxH == null) {
            this.jxH = new VideoHolyCardModel();
            this.jxH.a(this.hyb);
        }
        this.jxH.bPx();
    }

    public void eq(Context context) {
        if (this.jxI && !this.jxJ) {
            l.showToast(context, (int) R.string.free_data_tips);
            this.jxJ = true;
        }
    }

    private g() {
        cuR();
        cuQ();
    }

    private void cuR() {
        MessageManager.getInstance().registerListener(new CustomMessageListener(2000994) { // from class: com.baidu.tieba.video.g.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (j.ke()) {
                    g.this.cuQ();
                }
            }
        });
    }
}
