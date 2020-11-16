package com.baidu.tieba.yuyinala.liveroom.roomcard;

import android.app.Activity;
import android.content.Context;
import com.baidu.live.adp.framework.MessageManager;
import com.baidu.live.adp.framework.listener.CustomMessageListener;
import com.baidu.live.adp.framework.message.CustomResponsedMessage;
/* loaded from: classes4.dex */
public class c {
    public static c oaN;
    private a oaO;
    private CustomMessageListener oaP = new CustomMessageListener(2501061) { // from class: com.baidu.tieba.yuyinala.liveroom.roomcard.c.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2501061) {
                if (c.this.oaO != null) {
                    c.this.oaO.za(true);
                }
                MessageManager.getInstance().unRegisterListener(c.this.oaP);
            }
        }
    };

    /* loaded from: classes4.dex */
    public interface a {
        void za(boolean z);
    }

    public static c dYp() {
        if (oaN == null) {
            oaN = new c();
        }
        return oaN;
    }

    public void a(Context context, Activity activity, a aVar) {
        if (i.a(context, activity)) {
            if (aVar != null) {
                aVar.za(true);
                return;
            }
            return;
        }
        this.oaO = aVar;
        MessageManager.getInstance().registerListener(this.oaP);
    }
}
