package com.baidu.tieba.yuyinala.liveroom.roomcard;

import android.app.Activity;
import android.content.Context;
import com.baidu.live.adp.framework.MessageManager;
import com.baidu.live.adp.framework.listener.CustomMessageListener;
import com.baidu.live.adp.framework.message.CustomResponsedMessage;
/* loaded from: classes4.dex */
public class c {
    public static c nZk;
    private a nZl;
    private CustomMessageListener nZm = new CustomMessageListener(2501061) { // from class: com.baidu.tieba.yuyinala.liveroom.roomcard.c.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2501061) {
                if (c.this.nZl != null) {
                    c.this.nZl.yT(true);
                }
                MessageManager.getInstance().unRegisterListener(c.this.nZm);
            }
        }
    };

    /* loaded from: classes4.dex */
    public interface a {
        void yT(boolean z);
    }

    public static c dYq() {
        if (nZk == null) {
            nZk = new c();
        }
        return nZk;
    }

    public void a(Context context, Activity activity, a aVar) {
        if (i.a(context, activity)) {
            if (aVar != null) {
                aVar.yT(true);
                return;
            }
            return;
        }
        this.nZl = aVar;
        MessageManager.getInstance().registerListener(this.nZm);
    }
}
