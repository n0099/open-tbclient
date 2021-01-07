package com.baidu.tieba.yuyinala.liveroom.wheat.c;

import android.app.Activity;
import android.content.Context;
import com.baidu.live.adp.framework.MessageManager;
import com.baidu.live.adp.framework.listener.CustomMessageListener;
import com.baidu.live.adp.framework.message.CustomResponsedMessage;
/* loaded from: classes11.dex */
public class d {
    public static d oBf;
    private a oBg;
    private CustomMessageListener oBh = new CustomMessageListener(2501046) { // from class: com.baidu.tieba.yuyinala.liveroom.wheat.c.d.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2501046) {
                if (d.this.oBg != null) {
                    d.this.oBg.zM(true);
                }
                MessageManager.getInstance().unRegisterListener(d.this.oBh);
            }
        }
    };

    /* loaded from: classes11.dex */
    public interface a {
        void zM(boolean z);
    }

    public static d eeO() {
        if (oBf == null) {
            oBf = new d();
        }
        return oBf;
    }

    public void a(Context context, Activity activity, a aVar) {
        if (com.baidu.tieba.yuyinala.liveroom.wheat.e.f.a(context, activity)) {
            if (aVar != null) {
                aVar.zM(true);
                return;
            }
            return;
        }
        this.oBg = aVar;
        MessageManager.getInstance().registerListener(this.oBh);
    }
}
