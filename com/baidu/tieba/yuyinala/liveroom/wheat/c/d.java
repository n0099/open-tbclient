package com.baidu.tieba.yuyinala.liveroom.wheat.c;

import android.app.Activity;
import android.content.Context;
import com.baidu.live.adp.framework.MessageManager;
import com.baidu.live.adp.framework.listener.CustomMessageListener;
import com.baidu.live.adp.framework.message.CustomResponsedMessage;
/* loaded from: classes10.dex */
public class d {
    public static d owA;
    private a owB;
    private CustomMessageListener owC = new CustomMessageListener(2501046) { // from class: com.baidu.tieba.yuyinala.liveroom.wheat.c.d.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2501046) {
                if (d.this.owB != null) {
                    d.this.owB.zI(true);
                }
                MessageManager.getInstance().unRegisterListener(d.this.owC);
            }
        }
    };

    /* loaded from: classes10.dex */
    public interface a {
        void zI(boolean z);
    }

    public static d eaW() {
        if (owA == null) {
            owA = new d();
        }
        return owA;
    }

    public void a(Context context, Activity activity, a aVar) {
        if (com.baidu.tieba.yuyinala.liveroom.wheat.e.f.a(context, activity)) {
            if (aVar != null) {
                aVar.zI(true);
                return;
            }
            return;
        }
        this.owB = aVar;
        MessageManager.getInstance().registerListener(this.owC);
    }
}
