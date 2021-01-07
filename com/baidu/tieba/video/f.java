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
    private static f nFF;
    private VideoHolyCardModel.a lqL = new VideoHolyCardModel.a() { // from class: com.baidu.tieba.video.f.2
        @Override // com.baidu.tieba.model.VideoHolyCardModel.a
        public void onResult(boolean z) {
            f.this.nFH = z;
        }
    };
    private VideoHolyCardModel nFG;
    private boolean nFH;
    private boolean nFI;

    public static f dTE() {
        if (nFF == null) {
            synchronized (f.class) {
                if (nFF == null) {
                    nFF = new f();
                }
            }
        }
        return nFF;
    }

    public boolean dTF() {
        return this.nFH;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dTG() {
        if (this.nFG == null) {
            this.nFG = new VideoHolyCardModel();
            this.nFG.a(this.lqL);
        }
        this.nFG.diy();
    }

    public void gY(Context context) {
        if (this.nFH && !this.nFI) {
            l.showToast(context, R.string.free_data_tips);
            this.nFI = true;
        }
    }

    private f() {
        dTH();
        dTG();
    }

    private void dTH() {
        MessageManager.getInstance().registerListener(new CustomMessageListener(MessageConfig.CMD_NETWORK_CHANGED) { // from class: com.baidu.tieba.video.f.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (j.isMobileNet()) {
                    f.this.dTG();
                }
            }
        });
    }
}
