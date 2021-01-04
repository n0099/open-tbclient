package com.baidu.tieba.yuyinala.liveroom.wheat.c;

import android.app.Activity;
import android.content.Context;
import com.baidu.live.adp.framework.MessageManager;
import com.baidu.live.adp.framework.listener.CustomMessageListener;
import com.baidu.live.adp.framework.message.CustomResponsedMessage;
/* loaded from: classes11.dex */
public class d {
    public static d oBg;
    private a oBh;
    private CustomMessageListener oBi = new CustomMessageListener(2501046) { // from class: com.baidu.tieba.yuyinala.liveroom.wheat.c.d.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2501046) {
                if (d.this.oBh != null) {
                    d.this.oBh.zM(true);
                }
                MessageManager.getInstance().unRegisterListener(d.this.oBi);
            }
        }
    };

    /* loaded from: classes11.dex */
    public interface a {
        void zM(boolean z);
    }

    public static d eeN() {
        if (oBg == null) {
            oBg = new d();
        }
        return oBg;
    }

    public void a(Context context, Activity activity, a aVar) {
        if (com.baidu.tieba.yuyinala.liveroom.wheat.e.f.a(context, activity)) {
            if (aVar != null) {
                aVar.zM(true);
                return;
            }
            return;
        }
        this.oBh = aVar;
        MessageManager.getInstance().registerListener(this.oBi);
    }
}
