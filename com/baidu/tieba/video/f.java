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
    private static f nFG;
    private VideoHolyCardModel.a lqL = new VideoHolyCardModel.a() { // from class: com.baidu.tieba.video.f.2
        @Override // com.baidu.tieba.model.VideoHolyCardModel.a
        public void onResult(boolean z) {
            f.this.nFI = z;
        }
    };
    private VideoHolyCardModel nFH;
    private boolean nFI;
    private boolean nFJ;

    public static f dTD() {
        if (nFG == null) {
            synchronized (f.class) {
                if (nFG == null) {
                    nFG = new f();
                }
            }
        }
        return nFG;
    }

    public boolean dTE() {
        return this.nFI;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dTF() {
        if (this.nFH == null) {
            this.nFH = new VideoHolyCardModel();
            this.nFH.a(this.lqL);
        }
        this.nFH.dix();
    }

    public void gY(Context context) {
        if (this.nFI && !this.nFJ) {
            l.showToast(context, R.string.free_data_tips);
            this.nFJ = true;
        }
    }

    private f() {
        dTG();
        dTF();
    }

    private void dTG() {
        MessageManager.getInstance().registerListener(new CustomMessageListener(MessageConfig.CMD_NETWORK_CHANGED) { // from class: com.baidu.tieba.video.f.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (j.isMobileNet()) {
                    f.this.dTF();
                }
            }
        });
    }
}
