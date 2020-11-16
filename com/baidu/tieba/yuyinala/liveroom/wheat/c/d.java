package com.baidu.tieba.yuyinala.liveroom.wheat.c;

import android.app.Activity;
import android.content.Context;
import com.baidu.live.adp.framework.MessageManager;
import com.baidu.live.adp.framework.listener.CustomMessageListener;
import com.baidu.live.adp.framework.message.CustomResponsedMessage;
/* loaded from: classes4.dex */
public class d {
    public static d oft;
    private a ofu;
    private CustomMessageListener ofv = new CustomMessageListener(2501046) { // from class: com.baidu.tieba.yuyinala.liveroom.wheat.c.d.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2501046) {
                if (d.this.ofu != null) {
                    d.this.ofu.zg(true);
                }
                MessageManager.getInstance().unRegisterListener(d.this.ofv);
            }
        }
    };

    /* loaded from: classes4.dex */
    public interface a {
        void zg(boolean z);
    }

    public static d dZi() {
        if (oft == null) {
            oft = new d();
        }
        return oft;
    }

    public void a(Context context, Activity activity, a aVar) {
        if (com.baidu.tieba.yuyinala.liveroom.wheat.e.f.a(context, activity)) {
            if (aVar != null) {
                aVar.zg(true);
                return;
            }
            return;
        }
        this.ofu = aVar;
        MessageManager.getInstance().registerListener(this.ofv);
    }
}
