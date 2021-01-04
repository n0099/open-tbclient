package com.baidu.tieba.yuyinala.liveroom.roomcard;

import android.app.Activity;
import android.content.Context;
import com.baidu.live.adp.framework.MessageManager;
import com.baidu.live.adp.framework.listener.CustomMessageListener;
import com.baidu.live.adp.framework.message.CustomResponsedMessage;
/* loaded from: classes11.dex */
public class c {
    public static c oth;
    private a oti;
    private CustomMessageListener otj = new CustomMessageListener(2501061) { // from class: com.baidu.tieba.yuyinala.liveroom.roomcard.c.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2501061) {
                if (c.this.oti != null) {
                    c.this.oti.zE(true);
                }
                MessageManager.getInstance().unRegisterListener(c.this.otj);
            }
        }
    };

    /* loaded from: classes11.dex */
    public interface a {
        void zE(boolean z);
    }

    public static c edm() {
        if (oth == null) {
            oth = new c();
        }
        return oth;
    }

    public void a(Context context, Activity activity, a aVar) {
        if (i.a(context, activity)) {
            if (aVar != null) {
                aVar.zE(true);
                return;
            }
            return;
        }
        this.oti = aVar;
        MessageManager.getInstance().registerListener(this.otj);
    }
}
