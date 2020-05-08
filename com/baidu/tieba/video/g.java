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
public class g {
    private static g lhu;
    private VideoHolyCardModel.a jbA = new VideoHolyCardModel.a() { // from class: com.baidu.tieba.video.g.2
        @Override // com.baidu.tieba.model.VideoHolyCardModel.a
        public void onResult(boolean z) {
            g.this.lhw = z;
        }
    };
    private VideoHolyCardModel lhv;
    private boolean lhw;
    private boolean lhx;

    public static g dav() {
        if (lhu == null) {
            synchronized (g.class) {
                if (lhu == null) {
                    lhu = new g();
                }
            }
        }
        return lhu;
    }

    public boolean daw() {
        return this.lhw;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dax() {
        if (this.lhv == null) {
            this.lhv = new VideoHolyCardModel();
            this.lhv.a(this.jbA);
        }
        this.lhv.crv();
    }

    public void fd(Context context) {
        if (this.lhw && !this.lhx) {
            l.showToast(context, (int) R.string.free_data_tips);
            this.lhx = true;
        }
    }

    private g() {
        day();
        dax();
    }

    private void day() {
        MessageManager.getInstance().registerListener(new CustomMessageListener(MessageConfig.CMD_NETWORK_CHANGED) { // from class: com.baidu.tieba.video.g.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (j.isMobileNet()) {
                    g.this.dax();
                }
            }
        });
    }
}
